// (C) OntoOO Inc 2005 Apr
package actors;

import java.util.*;
import java.io.*;

public class RunMonitor implements Runnable {
    private Monitor monitor = null;
    private int updateInterval = 1000; // 1 secs
    private ActorBase actor = null;
    public int getUpdateInterval() { return updateInterval; }
    public void setUpdateInterval(int x) { updateInterval = x; }

    public RunMonitor(Monitor monitor, int interval) {
	this(monitor);
	updateInterval = interval;
    }

    public RunMonitor(Monitor monitor) {
	this.monitor = monitor;
	actor = monitor.getActorMonitored();
	monitor.setMyRunMonitor(this);
    }

    public Monitor getMonitor() { return monitor; }

    // core monitor loop
    private boolean again = true;
    private Thread myThread = null;
    public void start() { 
	myThread = new Thread(this);
	again = true;
	myThread.start(); 
    }
    public void stop() { 
	again = false; 
	wakeUp();
    }
    public void run() {
	actor.addTrace(
	      "RunMonitor: start for monitor: " + monitor.getClass().getName());
	try { Thread.sleep(updateInterval); }
	catch (InterruptedException ignore) {}
	while ( again ) {
	    try {
		monitor.check();
	    } catch (Exception ignore) {
		// Here we should notify a repair/ debug entity
	    }
	    try { Thread.sleep(updateInterval); }
	    catch (InterruptedException ignore) {}
	}
	actor.addTrace("RunMonitor: stopped run of: " + 
		       monitor.getClass().getName());
	myThread = null;
    }
    public void wakeUp() { 
	// actor.addTrace("WakeUp of: " + monitor.getClass().getName());
	try { myThread.interrupt(); }
	catch (Exception ignore) {}
    }
    public boolean stopped() { return (null == myThread); }
}
