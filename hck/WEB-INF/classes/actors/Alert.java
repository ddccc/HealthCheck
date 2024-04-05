// (C) OntoOO Inc 2005 Apr
package actors;

import java.util.*;
import java.io.*;

import fol.Atom;

public class Alert {
    private ActorSuper actor;
    private Atom trigger; // fol assertion with cnt/time stamp
    private Dispatcher dispatcher;
    private Job job;
    private String jobName = null;
    private boolean launched = false;

    public Alert(ActorSuper actor, Atom trigger, Dispatcher dispatcher, Job job) {
	this.actor = actor;
	this.trigger = trigger;
	this.dispatcher = dispatcher;
	this.job = job;
	jobName = job.getClass().getName();
    }
    public ActorSuper getActor() { return actor; }
    public Atom getTrigger() { return trigger; }
    public Dispatcher getDispatcher() { return dispatcher; }
    public Job getJob() { return job; }
    public String getJobName() { return jobName; }
    public void setLaunched(boolean b) { launched = b; }
    public boolean getLaunched() { return launched; }

} // end Alert 

