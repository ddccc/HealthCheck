// (C) OntoOO Inc 2007 Apr
package actors;

import java.util.*;
import java.io.*;

/* These monitors look for conditions to launch other monitors.
   If they succeed they deactivete themselves
 */
public abstract class MonitorLaunch extends Monitor { 
    protected Vector monitors = null;
    public MonitorLaunch(ActorBase actor, State state) {
	super(actor, state);
	monitors = actor.getMonitors();
    }
    public MonitorLaunch(ActorBase actor) {
	super(actor);
	monitors = actor.getMonitors();
    }

    protected Vector inactiveMonitors = new Vector();
    /* This vector must contain a 3-set
       -- inactive monitor
       -- state of which to be a consumer off, if any
       -- executon interval
    */

    public void addMonitor(MonitorCandidate monitorCandidate) {
	inactiveMonitors.addElement(monitorCandidate);
    }
    protected void activateMonitors() {
	int lng = inactiveMonitors.size();
	for (int i = 0; i < lng; i++) {
	    MonitorCandidate mc = 
		(MonitorCandidate) inactiveMonitors.elementAt(i);
	    Monitor mon = mc.getMonitor();
	    State upStreamState1 = mc.getUpStreamState1();
	    State upStreamState2 = mc.getUpStreamState2();
	    int interval = mc.getInterval();
	    RunMonitor rmMon =
		new RunMonitor(mon, interval);
	    if ( null != upStreamState1 )
		upStreamState1.addConsumer(rmMon);
	    if ( null != upStreamState2 )
		upStreamState2.addConsumer(rmMon);
	    monitors.addElement(rmMon);
	    rmMon.start();
	}
	// stop excution of this launcher
	myRunMonitor.stop();
	// and remove::
	monitors.remove(myRunMonitor);
    }
    
} // MonitorLaunch


class MonitorPediatric extends MonitorLaunch {
    private ActorPatient patient = null;
    public MonitorPediatric(Actor actor) { 
	super(actor); 
	patient = actor.getPatient();
    }
    public void check() {
	check0();
	Actor actor = (Actor) actorMonitored;
	// actor.addTrace("MonitorPediatric check");
	int age = patient.getAge();
	if ( age <= 5 ) {
	    actor.addTrace("MonitorPediatric: launching pediatric monitors");
	    activateMonitors();
	}
	else {
	    actor.addTrace("MonitorPediatric: NOT launching pediatric monitors");
	    // stop excution of this launcher
	    myRunMonitor.stop();
	    // and remove::
	    monitors.remove(myRunMonitor);
	}

    } // end check()
} // end MonitorPediatric
