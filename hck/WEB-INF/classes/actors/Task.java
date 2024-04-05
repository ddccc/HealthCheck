// (C) OntoOO Inc 2005 Apr
package actors;

import java.util.*;
import java.io.*;


public class Task implements Runnable {
    private Job job = null;
    private ActorBase actor = null;
    private String jobClassName = null;
    private int priority = 0;
    public int getPriority() { return priority; }
    public String getJobClassName() { return jobClassName; }

    public Task(Job job) { 
	this.job = job; 
	actor = job.getActor(); 
	jobClassName = job.getClass().getName();
	priority = job.getPriority();
    }
    private boolean again = true;
    private boolean repeat = true;
    private Thread myThread = null;
    public void start() { 
	myThread = new Thread(this);
	again = true;
	repeat = true;
	myThread.start(); 
    }
    public void stop() { 
	actor.addTrace("Task: stopping run for job: " + jobClassName);
	repeat = false; 
	wakeUp();
    }

    public void run() {
	actor.addTrace("Task: entering run for job: " + jobClassName);
	while ( repeat && again ) {
	    // Check whether there is a higher priority task
	    LinkedList taskList = actor.getTaskList();
	    synchronized ( actor ) {
		if ( 0 < taskList.size() ) {
		    Task task0 = (Task) taskList.getFirst();
		    if ( priority < task0.getPriority() ) {
			myThread = null;
			actor.addTrace("Task: suspending run for job: " + jobClassName);
			taskList.removeFirst();
			actor.insertTask(this);
			actor.setTaskFocus(task0);
			task0.start();
			return;
		    }
		} 
	    }
	    try { again = job.execute(); }
	    catch (Exception ex) {
		actor.addTrace("########## Task: EXCEPTION for job: " + jobClassName);
		actor.addTrace("########## Task: " + ex.getMessage());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		ex.printStackTrace(ps);
		actor.addTrace("########## Task: <br>" + 
			       "<pre>" +
			       baos.toString() +
			       "</pre>");
		again = false;
	    }
	}
	myThread = null;
	actor.addTrace("Task: exiting run for job: " + jobClassName);
	actor.setTaskFocus(null);
	actor.wakeUpMonitorTaskFocus();

    } // end of run()

    /** 
	The job executed by a task may do a Thread.sleep(updateInterval).
	wakeUp() wakes up such a sleeping task.  See the class NullJob 
	for a job that invokes Thread.sleep(updateInterval).
	Ignore if the job has finished already.
     */
    public void wakeUp() { 
	if ( stopped() ) return;
	try { myThread.interrupt(); }
	catch (Exception ignore) {}
    }
    public boolean stopped() { return (null == myThread); }


} // end of Task 



