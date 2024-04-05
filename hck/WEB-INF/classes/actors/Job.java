// (C) OntoOO Inc 2005 Apr
package actors;

import java.util.*;
import java.io.*;

import fol.Atom;
/*
Jobs:
     NullJob
     PageAdvice
Candidate Jobs:
     CreatePlan
     ExecutePlan
     Deduce
     CreateConjectures
     CreateInferences
     SelectGoal
     Explain?
     ????????????????????? HC job = ???
 */

public abstract class Job {
    static final protected int updateInterval = 200; // 0.1 secs
    protected ActorBase actor = null;
    public ActorBase getActor() { return actor; }
    protected int priority = 5;
    public void setPriority(int i) { priority = i; }
    public int getPriority() { return priority; }
    protected String actorName = "unknown";
    public Job() {}
    public Job(ActorBase actor) { 
	this.actor = actor; 
	actorName = actor.getName();
    }
    abstract public boolean execute();

} // end Job


class NullJob extends Job {
    NullJob(ActorBase actor) { 
	super(actor); 
	priority = 1;
    }
    private int cnt = 0;
    public boolean execute() {
	cnt = actor.getCnt();
	// int actorCnt = actor.getCnt();
	actor.nullJobCheck(cnt);

	if ( 0 == (cnt%50) ) {
	    State worry = actor.getWorry();
	    float worryValue = worry.getFloatValue();
	    actor.addTrace
		("NullJob: actor: " + actorName +
		 " worry= " + worryValue
		 );
	    // actor.nullJobCheck();
	}
	try {
	    Thread.sleep(updateInterval);
	} catch (InterruptedException ignore) {}
	return true;
    } // end execute()

} // end NullJob 


class ShowAlertTrace extends Job {
    ShowAlertTrace(ActorMeta actor) { 
	super(actor); 
	priority = 2;
    }
    public boolean execute() {
	ActorMeta actorMeta = (ActorMeta) actor;
	Actor actor0 = actorMeta.getActor();

	Vector alertTrace = actor0.getAlertTrace();
	int lng = alertTrace.size();
	actor.addTrace
	    ("AnalyzeAlertTrace: for: " + actor0.getName() +
	     " alertTrace size:" + lng
	     );
	StringBuffer sb = new StringBuffer("AnalyzeAlertTrace: <b>alerts:</b>");
	for (int i = 0; i < lng; i++) {
	    Alert alert = (Alert) alertTrace.elementAt(i);
	    Atom trigger = alert.getTrigger();
	    String jobName = alert.getJobName();
	    boolean launched = alert. getLaunched();
	    sb.append(
		"<br>" +
		trigger.html() + " " +
		jobName + " " +
		launched);
	}
	actor.addTrace(sb.toString());
	return false;
    } // end execute()

} // end ShowAlertTrace 


class PageAdvice extends Job {
    ActorPatient patient = null;
    String advice = "";
    String page = "";
    PageAdvice(Actor actor, String advice) { 
	super(actor);
	priority = 6;
	this.advice = advice;
	patient = actor.getPatient();
	State visitedPage = patient.getVisitedPage();
	page = visitedPage.getStringValue();
	priority = 3; // or depends on page?
    }
    public boolean execute() {
	actor.addTrace
	    ("PageAdvice: while at page: " + page +
	     " advice= " + advice
	     );
	patient.sendAlert("<b><i>" + advice + "</i></b>");
	return false; // end job
    } // end execute()

} // end PageAdvice


class CCAdvice extends Job {
    ActorPatient patient = null;
    Actor myActor = null;
    String advice = "";
    CCAdvice(ActorMeta actorM, String advice) { 
	super(actorM);  // or depends on page?
	priority = 6;
	this.advice = advice;
	myActor = actorM.getActor();
	patient = myActor.getPatient();
    }
    public boolean execute() {
	actor.addTrace("CCAdvice for advice: " + advice);
	patient.sendCCAdvice(advice);
	return false; // end job
    } // end execute()

} // end CCAdvice

















