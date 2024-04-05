// (C) OntoOO Inc 2004 Sep
package actors;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import fol.*;
import com.L;
import com.Common;
import concepts.Disease;
import concepts.Symptom;
import patient.DiseaseInst0;

    /*  Reminders:::::
    E={ e | e is selected temporal entity with episodic extensions 
            and associated properties } 
    B={ b | b is a selected believe regarding the current situation that 
            describes the current state of the "world" }
    G={ g | g is potential goal (= desire?) - with or without an associated 
            action/ executable plan/ algorithm - see the class Job & 
	    the class Task }
     */


public class Actor extends ActorBase  {

    static private Hashtable allActors = new Hashtable();

    static public void putActor(String key, Actor actor) {
	allActors.put(key, actor);
    }
    static public Actor fetchActor(String key) { 
	return (Actor) allActors.get(key);
    }
    static public void removeActor(String key) {
	allActors.remove(key);
    }



    // --- trace utility for tracing via ActorLogin
    /*
    private Vector trace = new Vector(); 
    public void addTrace(String addition) { 
	trace.addElement("" + cnt + " " + addition);
    }
    public String getTrace() { 
	StringBuffer sb = new StringBuffer("<h2>Actor: " + name + "</h2>");
	int lng = trace.size();
	for (int i = 0; i < lng; i++) {
	    sb.append("<br>" + ((String) trace.elementAt(i)));
	}
	return sb.toString();
    }
    */
    private StringBuffer trace = new StringBuffer("<h2>Actor: " + name + "</h2> \n");
    public void addTrace(String addition) { 
	// trace.append("<br>" + cnt + " " + addition + "\n");
	System.out.println("cnt " + cnt + " " + addition);
    }
    public String getTrace() { 
	return trace.toString();
    }

    // -------------- Instance elements -----------------------
    private State actorWorry = new State(0.1f);
    public State getActorWorry() { return actorWorry; }

    private ActorMeta actorMeta = null;



    // --- patient 
    private ActorPatient patient = null;
    public void setSession(HttpSession session ) { 
	patient.setSession(session); 
    }
    public ActorPatient getPatient() { return patient; }

    // --- Patient States
    public State getPageAndCounter() { 
	return patient.getVisitedPage();
    }
    
    public State getWorry() { return patient.getWorry(); }

    public State getDiagnosing() { return patient.getDiagnosing(); }

    public State getHasFever() { return patient.getHasFever(); }

    public State getHasPolyuria() { return patient.getHasPolyuria(); }
    public State getHasPolydipsia() { return patient.getHasPolydipsia(); }

    // --- Actor States

    private State patientInaction = new State();
    public float getPatientInactionValue() { 
	return patientInaction.getFloatValue(); 
    }

    private State diag1cState =  new State();


    // -------  alert generators:

    public void patientInactionUp() {
	State pageAndCounter = getPageAndCounter();
	String page = pageAndCounter.getStringValue();
	int counter = pageAndCounter.getIntValue();
	addTrace("Actor.patientInactionUp() for page: " + page +
		 " counter: " + counter);

	// create a task to reduce the worry ?
	String trigger = "AtPageCounter(" + cnt + " " + page + " " + counter + ")";
	Atom triggerAtom = Symbol.UNKNOWN;
	try { triggerAtom = (Atom) parser.parse(trigger); }
	catch ( Exception pe ) {
	    String messg = "patientInactionUp() Parser Error of: " + trigger;
	    System.out.println(messg);
	    addTrace(messg);
	    return;
	}
	addTrace("Actor: <b>new alert trigger:</b> " + triggerAtom.html());
	Dispatcher dispatcher = new AtPageCounter();
	dispatcher.setActor(this);
	dispatcher.setTheory(alertEvents);
	PageAdvice pageAdvice = 
	    new PageAdvice(this, L.inactive);
	Alert alert = new Alert(patient, triggerAtom, dispatcher, pageAdvice);
	dispatcher.setAlert(alert);
	dispatcher.init();

	addAlert(alert); // a queue
	addTrace("Actor: patientInactionUp/alert.wakeUp ...");
	wakeUp();
    } // end patientInactionUp()

    public void lifeThreateningConjecture(String disease, float acceptanceRate) {
	addTrace("Actor: lifeThreateningConjecture(): " + 
		 disease + " " + acceptanceRate);
	Disease dis = Common.getDisease(disease); 
	PageAdvice pageAdvice = 
	    new PageAdvice(this, 
			   // "The life threatening disease " +
			   L.lifeThreateningConjecture1 +
			   dis.getPrintName() + " " +
			   // "has the acceptance rate " + 
			   L.lifeThreateningConjecture2 +
			   acceptanceRate + ". " +
			   //"Consider calling 911");
			   L.lifeThreateningConjecture3);
	int ar = (int) (100 * acceptanceRate);
	String trigger = "LifeThreatening(" + cnt + " " + disease + " " + ar + ")";
	Atom triggerAtom = Symbol.UNKNOWN;
	try { triggerAtom = (Atom) parser.parse(trigger); }
	catch ( Exception pe ) {
	    String messg = "lifeThreateningConjecture() Parser Error of: " + trigger;
	    System.out.println(messg);
	    addTrace(messg);
	    return;
	}
	addTrace("Actor: <b>new alert trigger:</b> " + triggerAtom.html());
	Dispatcher dispatcher = new LifeThreatening();
	dispatcher.setActor(this);
	dispatcher.setTheory(alertEvents);
	Alert alert = new Alert(patient, triggerAtom, dispatcher, pageAdvice);
	dispatcher.setAlert(alert);
	dispatcher.init();

	addAlert(alert); // a queue
	addTrace("Actor: lifeThreateningConjecture/alert.wakeUp ...");
	wakeUp();
    }

    public void internalCauseConjecture(String disease, float acceptanceRate) {
	addTrace("Actor: internalCauseConjecture(): " + 
		 disease + " " + acceptanceRate);
	Disease dis = Common.getDisease(disease); 
	PageAdvice pageAdvice = 
	    new PageAdvice(this, 
			   // "The disease conjecture " + 
			   L.internalCauseConjecture1 +
			   dis.getPrintName() + " " +
			   // "has the acceptance rate " + 
			   L.lifeThreateningConjecture2 +
			   acceptanceRate  + " " +
			   // "is a possible consequence of a previous disease.");
			   L.internalCauseConjecture2);
	// int ar = (int) (100 * acceptanceRate);
	String trigger = "InternallyCaused(" + cnt + " " + disease + ")";
	Atom triggerAtom = Symbol.UNKNOWN;
	try { triggerAtom = (Atom) parser.parse(trigger); }
	catch ( Exception pe ) {
	    String messg = "internalCauseConjecture() Parser Error of: " + trigger;
	    System.out.println(messg);
	    addTrace(messg);
	    return;
	}
	addTrace("Actor: <b>new alert trigger:</b> " + triggerAtom.html());
	Dispatcher dispatcher = new InternallyCaused();
	dispatcher.setActor(this);
	dispatcher.setTheory(alertEvents);
	Alert alert = new Alert(patient, triggerAtom, dispatcher, pageAdvice);
	dispatcher.setAlert(alert);
	dispatcher.init();

	addAlert(alert); // a queue
	addTrace("Actor: internalCauseConjecture/alert.wakeUp ...");
	wakeUp();
    }

    public void previousDisease(String disease, float acceptanceRate) {
	addTrace("Actor: previousDisease(): " + 
		 disease + " " + acceptanceRate);
	Disease dis = Common.getDisease(disease); 
	PageAdvice pageAdvice = 
	    new PageAdvice(this, 
			   // "The disease conjecture " + 
			   L.internalCauseConjecture1 +
			   dis.getPrintName() + " " +
			   // "has the acceptance rate " + 
			   L.lifeThreateningConjecture2 +
			   acceptanceRate  + " " +
			   // "and is a disease you had earlier.");
			   L.previousDisease);
	// int ar = (int) (100 * acceptanceRate);
	String trigger = "PreviousDisease(" + cnt + " " + disease + ")";
	Atom triggerAtom = Symbol.UNKNOWN;
	try { triggerAtom = (Atom) parser.parse(trigger); }
	catch ( Exception pe ) {
	    String messg = "previousDisease() Parser Error of: " + trigger;
	    System.out.println(messg);
	    addTrace(messg);
	    return;
	}
	addTrace("Actor: <b>new alert trigger:</b> " + triggerAtom.html());
	Dispatcher dispatcher = new PreviousDisease();
	dispatcher.setActor(this);
	dispatcher.setTheory(alertEvents);
	Alert alert = new Alert(patient, triggerAtom, dispatcher, pageAdvice);
	dispatcher.setAlert(alert);
	dispatcher.init();

	addAlert(alert); // a queue
	addTrace("Actor: previousDisease/alert.wakeUp ...");
	wakeUp();
    }

    public void iterationDepth(int iterationDepth) {
	addTrace("Actor: iterationDepth(): " + iterationDepth);
	PageAdvice pageAdvice = 
	    new PageAdvice(this, 
			   // "Consider typing a symptom or a body location or " +
			   //"restart because the iteration depth is already: " +
			   L.iterationDepth +
			   iterationDepth);
	String trigger = "IterationDepth(" + cnt + ")";
	Atom triggerAtom = Symbol.UNKNOWN;
	try { triggerAtom = (Atom) parser.parse(trigger); }
	catch ( Exception pe ) {
	    String messg = "iterationDepth() Parser Error of: " + trigger;
	    System.out.println(messg);
	    addTrace(messg);
	    return;
	}
	addTrace("Actor: <b>new alert trigger:</b> " + triggerAtom.html());
	Dispatcher dispatcher = new IterationDepth();
	dispatcher.setActor(this);
	dispatcher.setTheory(alertEvents);
	Alert alert = new Alert(patient, triggerAtom, dispatcher, pageAdvice);
	dispatcher.setAlert(alert);
	dispatcher.init();

	addAlert(alert); // a queue
	addTrace("Actor: iterationDepth/alert.wakeUp ...");
	wakeUp();
    }

    public void numberDecidedSymptoms(int numberDecidedSymptoms) {
	addTrace("Actor: numberDecidedSymptoms(): " + numberDecidedSymptoms);
	PageAdvice pageAdvice = 
	    new PageAdvice(this, 
		 "Consider typing a symptom or a body location or " +
		 "restart because the number of symptoms decided is already: " +
		 numberDecidedSymptoms);
	String trigger = "NumberDecidedSymptoms(" + cnt + ")";
	Atom triggerAtom = Symbol.UNKNOWN;
	try { triggerAtom = (Atom) parser.parse(trigger); }
	catch ( Exception pe ) {
	    String messg = "numberDecidedSymptoms() Parser Error of: " + trigger;
	    System.out.println(messg);
	    addTrace(messg);
	    return;
	}
	addTrace("Actor: <b>new alert trigger:</b> " + triggerAtom.html());
	Dispatcher dispatcher = new NumberDecidedSymptoms();
	dispatcher.setActor(this);
	dispatcher.setTheory(alertEvents);
	Alert alert = new Alert(patient, triggerAtom, dispatcher, pageAdvice);
	dispatcher.setAlert(alert);
	dispatcher.init();

	addAlert(alert); // a queue
	addTrace("Actor: numberDecidedSymptoms/alert.wakeUp ...");
	wakeUp();
    }

    public void childFeverWarning() {
	addTrace("Actor: childFeverWarning()");
	PageAdvice pageAdvice = 
	    new PageAdvice(this, L.havingFever);
	String trigger = "ChildFeverWarning(" + name + ")";
	Atom triggerAtom = Symbol.UNKNOWN;
	try { triggerAtom = (Atom) parser.parse(trigger); }
	catch ( Exception pe ) {
	    String messg = "childFeverWarning() Parser Error of: " + trigger;
	    System.out.println(messg);
	    addTrace(messg);
	    return;
	}
	addTrace("Actor: <b>new alert trigger:</b> " + triggerAtom.html());
	Dispatcher dispatcher = new ChildFeverWarning();
	dispatcher.setActor(this);
	dispatcher.setTheory(alertEvents);
	Alert alert = new Alert(patient, triggerAtom, dispatcher, pageAdvice);
	dispatcher.setAlert(alert);
	dispatcher.init();

	addAlert(alert); // a queue
	addTrace("Actor: childFeverWarning/alert.wakeUp ...");
	wakeUp();
    }

    public void childSymptoms1(Vector foundSymptoms) {
	// Generate warning for each symptom in foundSymptoms
	int lng = foundSymptoms.size();
	addTrace("Actor: childSymptoms1 #: " + lng);
	for (int i = 0; i < lng; i++) {
	    String sym = (String) foundSymptoms.elementAt(i);
	    Symptom symptom = Common.getSymptom(sym);
	    String printName = symptom.getPrintName();
	    String description = symptom.getDescription();
	    String txt = ( printName.equals(description) ? printName :
			   printName + "/ " + description );
	    String warning = 
		( sym.equals("weightLoss") ? L.childWeightLoss : txt + L.warrants );
	    PageAdvice pageAdvice = 
		new PageAdvice(this, warning);
	    String trigger = "ChildSymptoms1(" + sym + ")";
	    Atom triggerAtom = Symbol.UNKNOWN;
	    try { triggerAtom = (Atom) parser.parse(trigger); }
	    catch ( Exception pe ) {
		String messg = "childSymptoms1() Parser Error of: " + trigger;
		System.out.println(messg);
		addTrace(messg);
		return;
	    }
	    addTrace("Actor: <b>new alert trigger:</b> " + triggerAtom.html());
	    Dispatcher dispatcher = new ChildSymptoms1();
	    dispatcher.setActor(this);
	    dispatcher.setTheory(alertEvents);
	    Alert alert = new Alert(patient, triggerAtom, dispatcher, pageAdvice);
	    dispatcher.setAlert(alert);
	    dispatcher.init();
	    
	    addAlert(alert); // a queue
	    addTrace("Actor: childSymptoms1/alert.wakeUp ...");
	    wakeUp();
	}
    } // childSymptoms1(..)

    public void childPolydipsiaAnduriaWarning() {
	addTrace("Actor: childPolydipsiaAnduriaWarning()");
	PageAdvice pageAdvice = 
	    new PageAdvice(this, L.havingPolydipsiaAnduria);
	String trigger = "ChildPolydipsiaAnduriaWarning(" + name + ")";
	Atom triggerAtom = Symbol.UNKNOWN;
	try { triggerAtom = (Atom) parser.parse(trigger); }
	catch ( Exception pe ) {
	    String messg = "childPolydipsiaAnduriaWarning() Parser Error of: " + trigger;
	    System.out.println(messg);
	    addTrace(messg);
	    return;
	}
	addTrace("Actor: <b>new alert trigger:</b> " + triggerAtom.html());
	Dispatcher dispatcher = new ChildPolydipsiaAnduriaWarning();
	dispatcher.setActor(this);
	dispatcher.setTheory(alertEvents);
	Alert alert = new Alert(patient, triggerAtom, dispatcher, pageAdvice);
	dispatcher.setAlert(alert);
	dispatcher.init();

	addAlert(alert); // a queue
	addTrace("Actor: childPolydipsiaAnduriaWarning/alert.wakeUp ...");
	wakeUp();
    } // childPolydipsiaAnduriaWarning()


    // ----- constructor
    public Actor(String name) {
	/* This constructor is to be used to bootstrap an Actor
	   and set all kind of initial features. 
	   An active actor can be stopped and is then saved (again).
	   An actor can be "revived" via fetchActor and 
	   the start() operation.  */
	super(name);
	int wait = 1000000; // activation interval 1000 secs
	patient = new ActorPatient(name);
	actorMeta = new ActorMeta(this);
	State visitedPage = this.getPageAndCounter();

	// set monitors
	// keeps an eye on the task focus
	rmTaskFocus = new RunMonitor(new MonitorTaskFocus(this), 50);
	// monitors.addElement(rmTaskFocus); 

	monitors.addElement(
	    new RunMonitor(new MonitorTrackPage(this, visitedPage)));

	RunMonitor monitorPagesPatient =
	    new RunMonitor(
		   new MonitorPagesPatient(this, patientInaction), wait);
	visitedPage.addConsumer(monitorPagesPatient);
	monitors.addElement(monitorPagesPatient);
	
	RunMonitor monitorPageCount =
	    new RunMonitor(
		   new MonitorPageCount(this, patientInaction), wait);
	visitedPage.addConsumer(monitorPageCount);
	monitors.addElement(monitorPageCount);
	
	RunMonitor monitorVisitedPages =
	    new RunMonitor(
		   new MonitorVisitedPages(this), wait);
	visitedPage.addConsumer(monitorVisitedPages);
	monitors.addElement(monitorVisitedPages);
		
	RunMonitor monitorPatientInaction = 
	    new RunMonitor(new MonitorPatientInaction(this, actorWorry),
			   wait);
	patientInaction.addConsumer(monitorPatientInaction);
	monitors.addElement(monitorPatientInaction);

	RunMonitor monitorDiag1cPage =
            new RunMonitor(new MonitorDiag1cPage(this, diag1cState), wait);
	// visitedPage.addConsumer(monitorDiag1cPage);
	patientInaction.addConsumer(monitorDiag1cPage);
	monitors.addElement(monitorDiag1cPage);

	RunMonitor monitorLifeThreatening = 
	    new RunMonitor(
		new MonitorLifeThreatening(this, this.getWorry()), // patient worry 
		wait);
	diag1cState.addConsumer(monitorLifeThreatening);
	monitors.addElement(monitorLifeThreatening);

	RunMonitor monitorInternalCause = 
	    new RunMonitor(new MonitorInternalCause(this), wait);
	diag1cState.addConsumer(monitorInternalCause);
	monitors.addElement(monitorInternalCause);

	RunMonitor monitorPreviousDisease = 
	    new RunMonitor(new MonitorPreviousDisease(this), wait);
	diag1cState.addConsumer(monitorPreviousDisease);
	monitors.addElement(monitorPreviousDisease);

	RunMonitor monitorIterationDepth = 
	    new RunMonitor(new MonitorIterationDepth(this), wait);
	diag1cState.addConsumer(monitorIterationDepth);
	monitors.addElement(monitorIterationDepth);

	RunMonitor monitorNumberDecidedSymptoms = 
	    new RunMonitor(new MonitorNumberDecidedSymptoms(this), wait);
	diag1cState.addConsumer(monitorNumberDecidedSymptoms);
	monitors.addElement(monitorNumberDecidedSymptoms);

	RunMonitor monitorFever = 
	    new RunMonitor(new MonitorFever(this, this.getHasFever()), // patient hasFever
			   wait);
	diag1cState.addConsumer(monitorFever);
	monitors.addElement(monitorFever);

	MonitorLaunch monitorPediatric = new MonitorPediatric(this);
	monitorPediatric.addMonitor(
	    new MonitorCandidate(new MonitorChildFever(this),
				 this.getHasFever(),
				 wait) );
	monitorPediatric.addMonitor(
	    new MonitorCandidate(new MonitorChildSymptoms1(this),
				 diag1cState,
				 wait) );
	monitorPediatric.addMonitor(
	    new MonitorCandidate(
		 new MonitorChildHasPolyuria(this, 
					     this.getHasPolyuria()),
		 diag1cState,
		 wait) );
	monitorPediatric.addMonitor(
	    new MonitorCandidate(
		 new MonitorChildHasPolydipsia(this, 
					       this.getHasPolydipsia()),
		 diag1cState,
		 wait) );
	
	monitorPediatric.addMonitor(
	    new MonitorCandidate(
		 new MonitorChildHasPolydipsiaAnduria(this), 
		 this.getHasPolyuria(), this.getHasPolydipsia(), // two states
		 wait) );
	
	// **** add other pediatric monitors here ****

	RunMonitor rmPediatric = 
	    new RunMonitor(monitorPediatric);
	monitors.addElement(rmPediatric);

	RunMonitor rmPatientWorry = 
	    new RunMonitor(new MonitorPatientWorry(this, actorWorry), wait);
	this.getWorry().addConsumer(rmPatientWorry); // this.getWorry() == patient worry 
	monitors.addElement(rmPatientWorry);

	RunMonitor monitorPatientDiagnosing = 
	    new RunMonitor(new MonitorPatientDiagnosing(this,
							this.getDiagnosing()),
			   wait);
	visitedPage.addConsumer(monitorPatientDiagnosing);
	monitors.addElement(monitorPatientDiagnosing);


	// set the taskFocus
	// taskFocus = nullTask;

	// parser = new Parser(false); // true for tracing
	// other initialization here
    }


    // -------------------- core consciousnesss loop ------------------

    static final private int updateInterval = 200; // 0.2 secs
    private boolean again = true;

    public void start() { 

	HashSet hs = patient.getPreviousDiseases();
	String out = ""; 
	for ( Iterator i = hs.iterator(); i.hasNext(); ) {
	    out = out + i.next() + " ";
	}
	addTrace("previous diseases: " + out);
	hs = patient.getCandidateDiseases();
	out = ""; 
	for ( Iterator i = hs.iterator(); i.hasNext(); ) {
	    out = out + i.next() + " ";
	}
	addTrace("candidate diseases: " + out);


	cnt = 0;
	putActor(name, this); // register in allActors

	// start the monitors
	rmTaskFocus.start();
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
	actorMeta.start();
    } // end start

    public void stop() {
	addTrace("Actor.stop() " + name + 
		 " taskList.size(): " + taskList.size());
	actorMeta.stop();

	// stop the conscious loop 
	again = false; 
	wakeUp();

	// stop the monitors
	rmTaskFocus.stop();
	stopMonitors(monitors);
	int lng = monitors.size();
	taskFocus.stop();

	// check that they have stopped 
	boolean checkAgain = true;
	while ( checkAgain ) {
	    checkAgain = false;
	    if ( !stopped() ) checkAgain = true;
	    if ( !rmTaskFocus.stopped() ) checkAgain = true;
	    if ( notStoppedMonitor(monitors) ) checkAgain = true;
	    if ( null != taskFocus ) checkAgain = true; 
	    if ( checkAgain ) {
		addTrace("Actor: ** Waiting for threads to stop ...");
		// try {
		    // Thread.sleep(updateInterval);
		// } catch (InterruptedException ignore) {}
		Thread.yield();
	    }
	}
	addTrace("Actor: All Threads stopped");
	
	addTrace("Actor: Stopped run of Actor: " + name);
	if ( saveActor() )
	    addTrace("Actor: " + name + " is saved !!!");
	Vector assertions = alertEvents.getAssertions();
	lng = assertions.size();
	if ( 0 < lng ) {
	    addTrace("Actor: # assertions " + lng);
	    for (int i = 0; i < lng; i++) {
	        Atom assertion = (Atom) assertions.elementAt(i);
	        addTrace("Assertion: " + i + ": " + assertion.html());
	    }
	}
	lng = alertTrace.size();
	if ( 0 < lng ) {
	    addTrace("Actor: # alertTrace " + lng);
	    for (int i = 0; i < lng; i++) {
		Alert alert = (Alert) alertTrace.elementAt(i);
		boolean launched = alert.getLaunched();
		Atom trigger = alert.getTrigger();
	        addTrace("Trigger: " + i + ": " + 
			 "launched: " + launched + 
			 " " + trigger.html());
	    }
	}

    } // end stop

    public void run() {
	addTrace("Actor: Entering consciousness loop of Actor: " + 
		 name + " cnt: " + cnt);
	
	while ( again ) {
	    cnt++; 
	    // addTrace("Actor.run().cnt: " + cnt);

	    // dispatch alerts, wrapped due to concurrency
	    synchronized ( alerts ) {
		while ( 0 < alerts.size() ) {
		    Alert alert = (Alert) alerts.removeFirst();
		    addTrace("Actor: Found alert!! for: " +
			     alert.getJobName() + 
			     " trigger: " + alert.getTrigger().html());
		    // add to a queue so that meta can observe things 
		    // decide whether to act on the alert
		    synchronized ( this ) { dispatchAlert(alert); }
		    /* check for the entity involved
		       add to a bounded list of memory with 
		       recent alerts;
		       check for alert looping and if so freakout/ 
		       generate a task to clean up, raise fear, 
		       excitation etc */
		}
	    }
	    // launch actions
	    synchronized ( actions ) {
		while ( 0 < actions.size() ) {
		    Job job = (Job) actions.removeFirst();
		    addTrace("Actor: Found job!! for: " +
			     job.getClass().getName());
		    // add to a queue so that meta can observe things
		    insertTask(new Task(job));
		}
	    }

	    try {
		Thread.sleep(updateInterval);
	    } catch (InterruptedException ignore) {}
	}
	addTrace("Actor: Stopping consciousness loop of Actor: " + name);
	myThread = null;
    } // end run()

    protected void nullJobCheck(int cnt) {
	nullJobCheckBase();
	if ( 0 == (cnt%50)) 
	    addTrace("nullJobCheck actor: " + name + " cnt: " + cnt + 
		     " patientInaction: " + getPatientInactionValue()
		     );
    }

    // ------ save and get Actor ----
    public boolean saveActor() {
	removeActor(name);
	patient.removeSession();
	return P.store(name, this); // nop, see P.java
    } // end saveActor()

    static public Actor getActor(String name) {
	return new Actor(name);
	/* nop, see P.java
	Actor out = null;
	try {
	    out = (Actor) P.load(name);
	} catch (Exception ex) {}
	return out;
	*/
    } // end getActor(String name)

} // end of Actor






