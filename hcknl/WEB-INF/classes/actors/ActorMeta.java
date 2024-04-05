// (C) OntoOO Inc 2004 Sep
package actors;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import fol.*;

    /*  Reminders:::::
    E={ e | e is selected temporal entity with episodic extensions 
            and associated properties } 
    B={ b | b is a selected believe regarding the current situation that 
            describes the current state of the "world" }
    G={ g | g is potential goal (= desire?) - with or without an associated 
            action/ executable plan/ algorithm - see the class Job & 
	    the class Task }
     */


public class ActorMeta extends ActorBase  {


    // -------------- Instance elements -----------------------

    Actor actor = null;
    public Actor getActor() { return actor; }

    public State getWorry() { return actor.getActorWorry(); }

    // --- trace utility for tracing via ActorLogin
    public void addTrace(String addition) { 
	actor.addTrace("Meta: " + addition);
    }

    // --- States

    // RunMonitor
    private RunMonitor rmActorAlertTrace = null;

    // -------  alert generators:

    public void actorWorry(float x) {
	addTrace("ActorMeta.actorWorry(x): " + x);
	int xval = (int) (100 * x);
	String trigger = "ActorWorry(" + cnt + " " + xval + ")";
	Atom triggerAtom = Symbol.UNKNOWN;
	try { triggerAtom = (Atom) parser.parse(trigger); }
	catch ( Exception pe ) {
	    String messg = "actorWorry(x) Parser Error of: " + trigger;
	    System.out.println(messg);
	    addTrace(messg);
	    return;
	}
	addTrace("ActorMeta: <b>new alert trigger:</b> " + triggerAtom.html());
	Dispatcher dispatcher = new ActorWorry();
	dispatcher.setActor(this);
	dispatcher.setTheory(alertEvents);
	CCAdvice ccAdvice = 
	    new CCAdvice(this, "Actor worry: " + (xval/ 100.0f));
	Alert alert = new Alert(actor, triggerAtom, dispatcher, ccAdvice);
	dispatcher.setAlert(alert);
	dispatcher.init();

	addAlert(alert); // a queue
	addTrace("ActorMeta: actorWorry/alert.wakeUp ...");
	wakeUp();
    } // end actorWorry(x)

    // ----- constructor
    public ActorMeta(Actor actor) {
	super("Meta-" + actor.getName());
	this.actor = actor;
	// monitors
	rmTaskFocus = new RunMonitor(new MonitorTaskFocus(this));
	monitors.addElement(rmTaskFocus); // keeps an eye on the task focus

	rmActorAlertTrace = new RunMonitor(new MonitorActorAlertTrace(this));
	monitors.addElement(rmActorAlertTrace);

	RunMonitor rmActorTasksCounter = 
	    new RunMonitor(new MonitorActorTasksCounter(this), 1000000);
	actor.getTasksCounter().addConsumer(rmActorTasksCounter);
	monitors.addElement(rmActorTasksCounter);

	RunMonitor rmActorWorry = 
	    new RunMonitor(new MonitorActorWorry(this), 1000000);
	getWorry().addConsumer(rmActorWorry); // = actorWorry
	monitors.addElement(rmActorWorry);
    }

    // -------------------- core consciousnesss loop ------------------

    static final private int updateInterval = 200; // 0.2 secs
    private boolean again = true;
    // private Thread myThread = null;

    public void start() { 
	cnt = 0;
	// start the monitors
	int lng = monitors.size();
	for (int i = 0; i < lng; i++) {
	    RunMonitor rm = (RunMonitor) monitors.elementAt(i);
	    rm.start();
	}
	// start the taskFocus
	taskFocus.start();
	// start the consciousness loop
	myThread = new Thread(this);
	again = true;
	myThread.start(); 
    }

    public void stop() {
	addTrace("Actor.stop() " + name + 
		 " taskList.size(): " + taskList.size());
	// stop the conscious loop 
	again = false; 
	wakeUp();
	// stop the monitors
	int lng = monitors.size();
	for (int i = 0; i < lng; i++) {
	    RunMonitor rm = (RunMonitor) monitors.elementAt(i);
	    rm.stop();
	}
	// check 
	boolean checkStopped = true;
	while ( checkStopped ) {
	    checkStopped = false;
	    for (int i = 0; i < lng; i++) {
	        RunMonitor rm = (RunMonitor) monitors.elementAt(i);
	        if ( !rm.stopped() ) { 
		    addTrace("ActorMeta: RunMonitor NOT stopped: " + i);
		    checkStopped = true; break; 
		}
	    }
	    if ( checkStopped ) {
		addTrace("ActorMeta: ** Waiting for threads to stop ...");
		try {
		    Thread.sleep(updateInterval);
		} catch (InterruptedException ignore) {}
	    }
	}
	addTrace("ActorMeta: All Monitors stopped");
	// stop the task loop
	try { taskFocus.stop(); } // may be null already
	catch (Exception ignore) {}
	checkStopped = true;
	while ( checkStopped ) {
	    checkStopped = false;
	    if ( !stopped() ) checkStopped = true; else 
	    if ( null != taskFocus ) {
		checkStopped = true; 
		addTrace("ActorMeta: taskFocus NOT stopped ");
	    }
	    if ( checkStopped ) {
		addTrace("ActorMeta: ** Waiting for threads to stop ...");
		try {
		    Thread.sleep(updateInterval);
		} catch (InterruptedException ignore) {}
	    }
	}

	addTrace("ActorMeta: Stopped run: " + name);
	Vector assertions = alertEvents.getAssertions();
	lng = assertions.size();
	if ( 0 < lng ) {
	    addTrace("ActorMeta: # assertions " + lng);
	    for (int i = 0; i < lng; i++) {
	        Atom assertion = (Atom) assertions.elementAt(i);
	        addTrace("Assertion: " + i + ": " + assertion.html());
	    }
	}
    }

    public void run() {
	addTrace("ActorMeta: Entering consciousness loop of Actor: " + 
		 name + " cnt: " + cnt);
	
	while ( again ) {
	    cnt++; 
	    // addTrace("ActorMeta.run().cnt: " + cnt);
	    while ( 0 < alerts.size() ) {
		Alert alert = (Alert) alerts.removeFirst();
		addTrace("ActorMeta: Found alert!! for: " +
			 alert.getJobName() + 
			 " trigger: " + alert.getTrigger().html());
		// add to a queue so that meta can observe things 
		// decide whether to act on the alert
		dispatchAlert(alert);
		/* check for the entity involved
		   add to a bounded list of memory with 
		   recent alerts;
		   check for alert looping and if so freakout/ 
		   generate a task to clean up, raise fear, 
		   excitation etc */
	    }
	    while ( 0 < actions.size() ) {
		Job job = (Job) actions.removeFirst();
		addTrace("ActorMeta: Found job!! for: " +
			 job.getClass().getName());
		// add to a queue so that meta can observe things
		insertTask(new Task(job));
	    }

	    try {
		Thread.sleep(updateInterval);
	    } catch (InterruptedException ignore) {}
	}
	addTrace("ActorMeta: Stopping consciousness loop of Actor: " + name);
	myThread = null;
    }

    protected void nullJobCheck(int cnt) {
	nullJobCheckBase();
	if ( 0 == (cnt%50)) {
	    addTrace("nullJobCheck actor: " + name + " cnt: " + cnt);
	    /*
	    addTrace("nullJobCheck actor: " + actor.getName() + 
		     " tasksCnt: " + actor.getTasksCnt() +
		     " alertsCnt: " + actor.getAlertsCnt() +
		     " actionsCnt: " + actor.getActionsCnt()
		     );
	    */
	}
    }


} // end of ActorMeta






