// (C) OntoOO Inc 2004 Nov
package actors;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import fol.*;

public abstract class ActorBase extends ActorSuper implements Runnable   {

    protected int cnt = 0;
    public int getCnt() { return cnt; }


    // protected State worry = new State(0.1f);
    abstract public State getWorry();
    
    public ActorBase(String name) { super(name); }

    abstract protected void addTrace(String message);

    // ------ Monitors
    protected Vector monitors = new Vector(); // has the monitors that check
    public Vector getMonitors() { return monitors; }

    // add focusMonitor ?
    protected ActorSuper focus = null; // may have to broaden this ...

    // --- Task stuff
    protected int tasksCnt = 0;
    protected int getTasksCnt() { return tasksCnt; }
    protected LinkedList taskList = new LinkedList();
    // calls to insertTask must be synchronized like:
    // synchronized (actor) { insertTask(taskx); } 
    public void insertTask(Task task) {
	tasksCnt++;
	taskList.addLast(task);
	int lng = taskList.size();
	if ( lng <= 1 ) return;
	sortTaskList(lng - 1);
	addTrace("ActorBase: insertTask(): " + task.getJobClassName() + 
		 " and taskFocus.wakeUp"
		 );
	try { taskFocus.wakeUp(); }
	catch (Exception ignore) {}

    }
    private void sortTaskList(int lastIndex) {
	// 1 <= lastIndex
	Task tLI = (Task) taskList.get(lastIndex);
	int priorityLI = tLI.getPriority();
	int j = lastIndex - 1;
	Task tJ = (Task) taskList.get(j);
	int priorityJ = tJ.getPriority();
	if ( priorityLI <= priorityJ ) return; // done
	taskList.set(lastIndex, tJ); // swapping
	taskList.set(j, tLI);
	if ( 0 == j ) return; // done
	sortTaskList(j);
    }

    // taskFocus has the current task/activity

    public LinkedList getTaskList() { return taskList; }
    public int getTaskListSize() { return taskList.size(); }

    protected NullJob nj = new NullJob(this);
    protected Task nullTask = new Task(nj);
    public Task getNullTask() { return nullTask; }

    protected Task taskFocus = nullTask;
    public void setTaskFocus(Task taskFocus) { this.taskFocus = taskFocus; }
    public Task getTaskFocus() { return taskFocus; }

    // PARSER
    protected Parser parser = new Parser(false);  // true for tracing

    // --- alerts
    protected int alertsCnt = 0;
    protected int getAlertsCnt() { return alertsCnt; }
    protected LinkedList alerts = new LinkedList();
    public void addAlert(Alert alert) {
	synchronized ( alerts ) {
	    alertsCnt++;
	    alerts.add(alert); 
	}
    }

    // --- actions
    protected int actionsCnt = 0;
    protected int getActionsCnt() { return actionsCnt; }
    protected LinkedList actions = new LinkedList();
    public void addAction(Job job) { 
	synchronized ( actions ) {
	    actionsCnt++;
	    actions.add(job);
	} 
    }

    // --- alert trace
    protected Vector alertTrace = new Vector();
    public Vector getAlertTrace() { return alertTrace; }

    protected Theory alertEvents = new Theory();

    protected void dispatchAlert(Alert alert) {
	// check for the entity involved
	// add to a bounded list of memory with 
	// recent alerts;
	// check for alert looping and if so freakout/ 
	// generate a task to clean up, raise fear, 
	// excitation etc 
	// ActorSuper actor = alert.getActor();
	// focus = actor; // ? focusMonitor.wakeUp()
	Atom trigger = alert.getTrigger();

	addTrace("Actor: dispatchAlert(): trigger = " + trigger.html());
	Dispatcher dispatcher = alert.getDispatcher();
	insertTask(new Task(dispatcher));

	// anyway add the alert ...
	alertTrace.addElement(alert);
	// ... and have a look at it 
	// insertTask(new Task(new AnalyzeAlertTrace(this)));
    } // end dispatchAlert

    protected RunMonitor rmTaskFocus = null;

    public void wakeUpMonitorTaskFocus() { 
        synchronized(this) {
 	   if ( null == rmTaskFocus || rmTaskFocus.stopped() ) return;
	   rmTaskFocus.wakeUp(); 
        }
    }

    protected Thread myThread = null;
    public abstract void start();
    public abstract void run();
    protected abstract void nullJobCheck(int cnt);

    public void wakeUp() { 
	try { myThread.interrupt(); }
	catch (Exception ignore) {}
    }
    public boolean stopped() { return ( null == myThread ); }

    private State tasksCounter = new State();
    public State getTasksCounter() { return tasksCounter; }
    private State alertsCounter = new State();
    public State getAlertsCounter() { return alertsCounter; }
    private State actionsCounter = new State();
    public State getActionsCounter() { return actionsCounter; }
    protected void nullJobCheckBase() {
	int x = tasksCounter.getIntValue();
	if ( x != tasksCnt ) {
	    tasksCounter.setIntValue(tasksCnt);
	    tasksCounter.wakeUp();
	}
	x = alertsCounter.getIntValue();
	if ( x != alertsCnt ) {
	    alertsCounter.setIntValue(alertsCnt);
	    alertsCounter.wakeUp();
	}
	x = actionsCounter.getIntValue();
	if ( x != actionsCnt ) {
	    actionsCounter.setIntValue(actionsCnt);
	    actionsCounter.wakeUp();
	}
	if ( 0 == (cnt%50)) 
	    addTrace("nullJobCheckBase actor: " + name + 
		     " tasksCnt: " + tasksCnt +
		     " alertsCnt: " + alertsCnt +
		     " actionsCnt: " + actionsCnt
		     );
    } // end nullJobCheckBase

    protected void stopMonitors(Vector monitors) {
	int lng = monitors.size();
	for (int i = 0; i < lng; i++) {
	    RunMonitor rm = (RunMonitor) monitors.elementAt(i);
	    rm.stop();
	} 
    } // end stopMonitors
    protected boolean notStoppedMonitor(Vector monitors) {
	// return true if at least one monitor has not stopped yet
	boolean checkAgain = false;
	int lng = monitors.size();
	for (int i = 0; i < lng; i++) {
	    RunMonitor rm = (RunMonitor) monitors.elementAt(i);
	    if ( !rm.stopped() ) { 
		addTrace("Actor: RunMonitor NOT stopped: " + i + " " +
			 rm.getMonitor().getClass().getName());
		checkAgain = true; 
	    }
	}
	return checkAgain;
    } // end notStoppedMonitor

} // end class ActorBase





