// (C) OntoOO Inc 2005 Apr
package actors;

import java.util.*;
import java.io.*;
import fol.*;


public abstract class Dispatcher extends Job {
    /**
       An instance of a subclass is a job that decides whether an alert 
       is ignored or not.  The mechanism is doing a limited number of 
       resolutions in a connection graph theorem prover - which lives in the 
       fol package.

       When the alert is honored an action, pre-specified in the alert,
       will be launched as another job.

       {Note: In a more advanced approach the alert would not contain a 
       pre-specified action but instead just a goal to be achieved.  
       A planning operation would be required to construct the sequence 
       of actions to be subsequently executed.}

       Making launch decisions in terms of predicate calculus reasoning is 
       essentially different from what goes on in the sensory realm where 
       low level states are observed by monitors, which can impact states 
       in turn, or - after data enrichments - can produce alerts.

       Instances of subclasses are created in ActorBase by 
       dispatchAlert(Alert alert)
       
       @see ActorBase
     */

    protected Alert alert = null; 
    protected Atom trigger = null;
    protected Theory theory = null;
    // public Dispatcher() {}
    protected void setAlert(Alert alert) { 
	this.alert = alert; 
	trigger = alert.getTrigger();
    }
    protected void setActor(ActorBase actor) { 
	this.actor = actor; 
	actorName = actor.getName();
    }
    protected void setTheory(Theory theory) { this.theory = theory; }
    protected int resolveMax = 5;
    protected int resolveCnt = 0;
    abstract public void init();
    // abstract public boolean launchQ(Theory alertEvents, Atom trigger);
} // end Dispatcher


class AtPageCounter extends Dispatcher {
    /**
       An instance will test whether a page advice regarding inactivity
       (for a specific page) has been launched before.  If so the alert is ignored.

       An instances is created in Actor by patientInactionUp() in an alert.
       The alert contains a trigger whose predicate is "AtPageCounter".
       Actor.run launches dispatchAlert(Alert alert), which creates a task for 
       the job AtPageCounter.

       This job tries to prove that an earlier alert subsumes the current one.
       If the proof fails, we use a closed world assumption and conclude that no
       previous alert was honored and hence we can 

     */

    static final String query = "(eq ?t &&(LaunchedPageAdvice(?t ?page) <(?t ?variablexyz) ))";
    static final Existential queryFormula = (Existential) Parser.parse3(query);
    static final Variable tVariable = queryFormula.getVariable();
    static final Conjunction queryConjunction = (Conjunction) queryFormula.getBody();
    static final Vector queryConjuncts = queryConjunction.getConjuncts();
    static final Atom queryConjunct0 = (Atom) queryConjuncts.elementAt(0);
    static final Vector queryConjunct0Args = queryConjunct0.getArgs();
    static final Variable variablePage = (Variable) queryConjunct0Args.elementAt(1);
    static final Atom queryConjunct1 = (Atom) queryConjuncts.elementAt(1);
    static final Vector queryConjunct1Args = queryConjunct1.getArgs();
    static final Variable variablexyz = (Variable) queryConjunct1Args.elementAt(1);
    
    private Vector triggerArgs = null;
    private IntSymbol cnt = null;
    private Symbol page = null;
    private Existential queryFormulaX = null;
    private CG cg = null;

    public void init() {
	priority = 2;
	triggerArgs = trigger.getArgs();
	cnt = (IntSymbol) triggerArgs.elementAt(0);
	page = (Symbol)  triggerArgs.elementAt(1);
	queryFormulaX = (Existential) queryFormula.subst(variablexyz, cnt);
	queryFormulaX = (Existential) queryFormulaX.subst(variablePage, page);
	// because we know that it cannot be proven by the preprocessors in the theory
	// we go directly to a connection graph
	cg = theory.setUpCGforConjecture(queryFormulaX); 
    }

    // trigger ~=~ AtPageCounter(309 AngelRoot 6) 
    // reply true if no similar alert was launched in this session already for this page
    // Example: LaunchedPageAdvice(309 AngelRoot)
    // Test: (eq ?t &&(LaunchedPageAdvice(?t AngelRoot) <(?t 309) ))

    public boolean execute() {
	resolveCnt++;
	if ( resolveMax < resolveCnt ) return false; // terminate this task
	int out = cg.resolve();
	if ( 0 < out ) {
	    actor.addTrace("LifeThreatening: execute(): resolve out= " + out);
	    return true; // no decision yet
	}
	if ( 0 == out ) { // no need to launch again
	    actor.addTrace("AtPageCounter: execute(): *NOT* launching trigger = " + 
			   trigger.html());
	    return false; // terminate this task
	}

	// The action in the alert will be executed
	// The action could be something like "achieve(goal)", which would entail
	// a planning + execute plan activity ...
	actor.addTrace("AtPageCounter: execute(): *DO* launch trigger = " + trigger.html());
	Atom newAssertion = (Atom) queryConjunct0.subst(tVariable, cnt);
	newAssertion = (Atom) newAssertion.subst(variablePage, page);
	theory.addAssertion(newAssertion);
	Job job = alert.getJob();
	actor.addAction(job);
	actor.wakeUp();
	alert.setLaunched(true);
	return false; // terminate this task
    } // end execute

} // end  AtPageCounter


class LifeThreatening extends Dispatcher {

    static final String query = 
	"(eq ?t &&(LaunchedLifeThreatening(?t ?disease ?acr) <(?t ?variablexyz) ))";
    static final Existential queryFormula = (Existential) Parser.parse3(query);
    static final Variable tVariable = queryFormula.getVariable();
    static final Conjunction queryConjunction = (Conjunction) queryFormula.getBody();
    static final Vector queryConjuncts = queryConjunction.getConjuncts();
    static final Atom queryConjunct0 = (Atom) queryConjuncts.elementAt(0);
    static final Vector queryConjunct0Args = queryConjunct0.getArgs();
    static final Variable variableDisease = (Variable) queryConjunct0Args.elementAt(1);
    static final Variable variableAR = (Variable) queryConjunct0Args.elementAt(2);
    static final Atom queryConjunct1 = (Atom) queryConjuncts.elementAt(1);
    static final Vector queryConjunct1Args = queryConjunct1.getArgs();
    static final Variable variablexyz = (Variable) queryConjunct1Args.elementAt(1);
    
    private Vector triggerArgs = null;
    private IntSymbol cnt = null;
    private Symbol disease = null;
    private IntSymbol acr = null;
    private Existential queryFormulaX = null;
    private CG cg = null;

    // trigger ~=~ LifeThreatening(394 myocardialInfarction 63) 
    // reply true if no similar alert was launched in this session already for this disease
    // Example: LifeThreatening(304 myocardialInfarction 63)
    // Test: (eq ?t &&(LaunchedLifeThreatening(?t myocardialInfarction 63) <(?t 394) ))

    public void init() {
	priority = 5;
	triggerArgs = trigger.getArgs();
	cnt = (IntSymbol) triggerArgs.elementAt(0);
	disease = (Symbol) triggerArgs.elementAt(1);
	acr = (IntSymbol) triggerArgs.elementAt(2); // acceptanceRate
	queryFormulaX = (Existential) queryFormula.subst(variablexyz, cnt);
	queryFormulaX = (Existential) queryFormulaX.subst(variableDisease, disease);
	queryFormulaX = (Existential) queryFormulaX.subst(variableAR, acr);
	// because we know that it cannot be proven by the preprocessors in the theory
	// we go directly to a connection graph
	cg = theory.setUpCGforConjecture(queryFormulaX); 
    }

    public boolean execute() { // limit the # of execute() ????
	resolveCnt++;
	if ( resolveMax < resolveCnt ) return false; 
	int out = cg.resolve();
	if ( 0 < out ) {
	    actor.addTrace("LifeThreatening: execute(): resolve out= " + out);
	    return true; // no decision yet
	}
	if ( 0 == out ) { // no need to launch again
	    actor.addTrace("LifeThreatening: execute(): *NOT* launching trigger = " + 
			   trigger.html());
	    return false; // terminate this task
	}
	actor.addTrace("LifeThreatening: execute(): *DO* launch trigger = " + trigger.html());
	Atom newAssertion = (Atom) queryConjunct0.subst(tVariable, cnt);
	newAssertion = (Atom) newAssertion.subst(variableDisease, disease);
	newAssertion = (Atom) newAssertion.subst(variableAR, acr);
	theory.addAssertion(newAssertion);
	Job job = alert.getJob();
	actor.addAction(job);
	actor.wakeUp();
	alert.setLaunched(true);
	return false; // terminate this task
    } // end execute

} // end  LifeThreatening



class InternallyCaused extends Dispatcher {

    static final String query = 
	"(eq ?t &&(LaunchedDownStreamDisease(?t ?disease) <(?t ?variablexyz) ))";
    static final Existential queryFormula = (Existential) Parser.parse3(query);
    static final Variable tVariable = queryFormula.getVariable();
    static final Conjunction queryConjunction = (Conjunction) queryFormula.getBody();
    static final Vector queryConjuncts = queryConjunction.getConjuncts();
    static final Atom queryConjunct0 = (Atom) queryConjuncts.elementAt(0);
    static final Vector queryConjunct0Args = queryConjunct0.getArgs();
    static final Variable variableDisease = (Variable) queryConjunct0Args.elementAt(1);
    static final Atom queryConjunct1 = (Atom) queryConjuncts.elementAt(1);
    static final Vector queryConjunct1Args = queryConjunct1.getArgs();
    static final Variable variablexyz = (Variable) queryConjunct1Args.elementAt(1);
    
    private Vector triggerArgs = null;
    private IntSymbol cnt = null;
    private Symbol disease = null;
    private Existential queryFormulaX = null;
    private CG cg = null;

    public void init() {
	priority = 2;
	triggerArgs = trigger.getArgs();
	cnt = (IntSymbol) triggerArgs.elementAt(0);
	disease = (Symbol)  triggerArgs.elementAt(1);
	queryFormulaX = (Existential) queryFormula.subst(variablexyz, cnt);
	queryFormulaX = (Existential) queryFormulaX.subst(variableDisease, disease);
	// because we know that it cannot be proven by the preprocessors in the theory
	// we go directly to a connection graph
	cg = theory.setUpCGforConjecture(queryFormulaX); 
    }

    // trigger ~=~ InternallyCaused(309  otitisMedia) 
    // reply true if no similar alert was launched in this session already for this page
    // Example: LaunchedDownStreamDisease(309 otitisMedia)
    // Test: (eq ?t &&(LaunchedDownStreamDisease(?t otitisMedia) <(?t 309) ))

    public boolean execute() {
	resolveCnt++;
	if ( resolveMax < resolveCnt ) return false; 
	int out = cg.resolve();
	if ( 0 < out ) {
	    actor.addTrace("InternallyCaused: execute(): resolve out= " + out);
	    return true; // no decision yet
	}
	if ( 0 == out ) { // no need to launch again
	    actor.addTrace("InternallyCaused: execute(): *NOT* launching trigger = " + 
			   trigger.html());
	    return false; // terminate this task
	}
	actor.addTrace("InternallyCaused: execute(): *DO* launch trigger = " + trigger.html());
	Atom newAssertion = (Atom) queryConjunct0.subst(tVariable, cnt);
	newAssertion = (Atom) newAssertion.subst(variableDisease, disease);
	theory.addAssertion(newAssertion);
	Job job = alert.getJob();
	actor.addAction(job);
	actor.wakeUp();
	alert.setLaunched(true);
	return false; // terminate this task
    } // end execute

} // end  InternallyCaused


class PreviousDisease extends Dispatcher {

    static final String query = 
	"(eq ?t &&(LaunchedPreviousDisease(?t ?disease) <(?t ?variablexyz) ))";
    static final Existential queryFormula = (Existential) Parser.parse3(query);
    static final Variable tVariable = queryFormula.getVariable();
    static final Conjunction queryConjunction = (Conjunction) queryFormula.getBody();
    static final Vector queryConjuncts = queryConjunction.getConjuncts();
    static final Atom queryConjunct0 = (Atom) queryConjuncts.elementAt(0);
    static final Vector queryConjunct0Args = queryConjunct0.getArgs();
    static final Variable variableDisease = (Variable) queryConjunct0Args.elementAt(1);
    static final Atom queryConjunct1 = (Atom) queryConjuncts.elementAt(1);
    static final Vector queryConjunct1Args = queryConjunct1.getArgs();
    static final Variable variablexyz = (Variable) queryConjunct1Args.elementAt(1);
    
    private Vector triggerArgs = null;
    private IntSymbol cnt = null;
    private Symbol disease = null;
    private Existential queryFormulaX = null;
    private CG cg = null;

    public void init() {
	priority = 2;
	triggerArgs = trigger.getArgs();
	cnt = (IntSymbol) triggerArgs.elementAt(0);
	disease = (Symbol)  triggerArgs.elementAt(1);
	queryFormulaX = (Existential) queryFormula.subst(variablexyz, cnt);
	queryFormulaX = (Existential) queryFormulaX.subst(variableDisease, disease);
	// because we know that it cannot be proven by the preprocessors in the theory
	// we go directly to a connection graph
	cg = theory.setUpCGforConjecture(queryFormulaX); 
    }

    // trigger ~=~ PreviousDisease(309  otitisMedia) 
    // reply true if no similar alert was launched in this session already
    // Example: LaunchedPreviousDisease(309  otitisMedia)
    // Test: (eq ?t &&(LaunchedPreviousDisease(?t  otitisMedia) <(?t 309) ))

    public boolean execute() {
	resolveCnt++;
	if ( resolveMax < resolveCnt ) return false; 
	int out = cg.resolve();
	if ( 0 < out ) {
	    actor.addTrace("PreviousDisease: execute(): resolve out= " + out);
	    return true; // no decision yet
	}
	if ( 0 == out ) { // no need to launch again
	    actor.addTrace("PreviousDisease: execute(): *NOT* launching trigger = " + 
			   trigger.html());
	    return false; // terminate this task
	}
	actor.addTrace("PreviousDisease: execute(): *DO* launch trigger = " + trigger.html());
	Atom newAssertion = (Atom) queryConjunct0.subst(tVariable, cnt);
	newAssertion = (Atom) newAssertion.subst(variableDisease, disease);
	theory.addAssertion(newAssertion);
	Job job = alert.getJob();
	actor.addAction(job);
	actor.wakeUp();
	alert.setLaunched(true);
	return false; // terminate this task
    } // end execute

} // end  PreviousDisease



class IterationDepth extends Dispatcher {
    static final String query = 
	"(eq ?t &&(LaunchedIterationDepth(?t) <(?t ?variablexyz) ))";
    static final Existential queryFormula = (Existential) Parser.parse3(query);
    static final Variable tVariable = queryFormula.getVariable();
    static final Conjunction queryConjunction = (Conjunction) queryFormula.getBody();
    static final Vector queryConjuncts = queryConjunction.getConjuncts();
    static final Atom queryConjunct0 = (Atom) queryConjuncts.elementAt(0);
    /*
    static final Vector queryConjunct0Args = queryConjunct0.getArgs();
    static final Variable variableDisease = (Variable) queryConjunct0Args.elementAt(1);
    */
    static final Atom queryConjunct1 = (Atom) queryConjuncts.elementAt(1);
    static final Vector queryConjunct1Args = queryConjunct1.getArgs();
    static final Variable variablexyz = (Variable) queryConjunct1Args.elementAt(1);
    
    private Vector triggerArgs = null;
    private IntSymbol cnt = null;
    // private Symbol disease = null;
    private Existential queryFormulaX = null;
    private CG cg = null;

    public void init() {
	priority = 2;
	triggerArgs = trigger.getArgs();
	cnt = (IntSymbol) triggerArgs.elementAt(0);
	// disease = (Symbol)  triggerArgs.elementAt(1);
	queryFormulaX = (Existential) queryFormula.subst(variablexyz, cnt);
	// queryFormulaX = (Existential) queryFormulaX.subst(variableDisease, disease);
	// because we know that it cannot be proven by the preprocessors in the theory
	// we go directly to a connection graph
	cg = theory.setUpCGforConjecture(queryFormulaX); 
    }

    // trigger ~=~ IterationDepth(309) 
    // reply true if no similar alert was launched in this session already 
    // Example: LaunchedIterationDepth(309)
    // Test: (eq ?t &&(LaunchedIterationDepth(?t) <(?t 309) ))

    public boolean execute() {
	resolveCnt++;
	if ( resolveMax < resolveCnt ) return false; 
	int out = cg.resolve();
	if ( 0 < out ) {
	    actor.addTrace("IterationDepth: execute(): resolve out= " + out);
	    return true; // no decision yet
	}
	if ( 0 == out ) { // no need to launch again
	    actor.addTrace("IterationDepth: execute(): *NOT* launching trigger = " + 
			   trigger.html());
	    return false; // terminate this task
	}
	actor.addTrace("IterationDepth: execute(): *DO* launch trigger = " + trigger.html());
	Atom newAssertion = (Atom) queryConjunct0.subst(tVariable, cnt);
	// newAssertion = (Atom) newAssertion.subst(variableDisease, disease);
	theory.addAssertion(newAssertion);
	Job job = alert.getJob();
	actor.addAction(job);
	actor.wakeUp();
	alert.setLaunched(true);
	return false; // terminate this task
    } // end execute

} // end  IterationDepth


class NumberDecidedSymptoms extends Dispatcher {
    static final String query = 
	"(eq ?t &&(LaunchedNumberDecidedSymptoms(?t) <(?t ?variablexyz) ))";
    static final Existential queryFormula = (Existential) Parser.parse3(query);
    static final Variable tVariable = queryFormula.getVariable();
    static final Conjunction queryConjunction = (Conjunction) queryFormula.getBody();
    static final Vector queryConjuncts = queryConjunction.getConjuncts();
    static final Atom queryConjunct0 = (Atom) queryConjuncts.elementAt(0);
    /*
    static final Vector queryConjunct0Args = queryConjunct0.getArgs();
    static final Variable variableDisease = (Variable) queryConjunct0Args.elementAt(1);
    */
    static final Atom queryConjunct1 = (Atom) queryConjuncts.elementAt(1);
    static final Vector queryConjunct1Args = queryConjunct1.getArgs();
    static final Variable variablexyz = (Variable) queryConjunct1Args.elementAt(1);
    
    private Vector triggerArgs = null;
    private IntSymbol cnt = null;
    // private Symbol disease = null;
    private Existential queryFormulaX = null;
    private CG cg = null;

    public void init() {
	priority = 2;
	triggerArgs = trigger.getArgs();
	cnt = (IntSymbol) triggerArgs.elementAt(0);
	// disease = (Symbol)  triggerArgs.elementAt(1);
	queryFormulaX = (Existential) queryFormula.subst(variablexyz, cnt);
	// queryFormulaX = (Existential) queryFormulaX.subst(variableDisease, disease);
	// because we know that it cannot be proven by the preprocessors in the theory
	// we go directly to a connection graph
	cg = theory.setUpCGforConjecture(queryFormulaX); 
    }

    // trigger ~=~ NumberDecidedSymptoms(309) 
    // reply true if no similar alert was launched in this session already
    // Example: LaunchedNumberDecidedSymptoms(309)
    // Test: (eq ?t &&(LaunchedNumberDecidedSymptoms(?t) <(?t 309) ))

    public boolean execute() {
	resolveCnt++;
	if ( resolveMax < resolveCnt ) return false; 
	int out = cg.resolve();
	if ( 0 < out ) {
	    actor.addTrace("NumberDecidedSymptoms: execute(): resolve out= " + out);
	    return true; // no decision yet
	}
	if ( 0 == out ) { // no need to launch again
	    actor.addTrace("NumberDecidedSymptoms: execute(): *NOT* launching trigger = " + 
			   trigger.html());
	    return false; // terminate this task
	}
	actor.addTrace("NumberDecidedSymptoms: execute(): *DO* launch trigger = " + trigger.html());
	Atom newAssertion = (Atom) queryConjunct0.subst(tVariable, cnt);
	// newAssertion = (Atom) newAssertion.subst(variableDisease, disease);
	theory.addAssertion(newAssertion);
	Job job = alert.getJob();
	actor.addAction(job);
	actor.wakeUp();
	alert.setLaunched(true);
	return false; // terminate this task
    } // end execute

} // end  NumberDecidedSymptoms


class ActorWorry extends Dispatcher {
    static final String query = 
	"(eq ?t &&(LaunchedActorWorry(?t) <(?t ?variablexyz) ))";
    static final Existential queryFormula = (Existential) Parser.parse3(query);
    static final Variable tVariable = queryFormula.getVariable();
    static final Conjunction queryConjunction = (Conjunction) queryFormula.getBody();
    static final Vector queryConjuncts = queryConjunction.getConjuncts();
    static final Atom queryConjunct0 = (Atom) queryConjuncts.elementAt(0);
    /*
    static final Vector queryConjunct0Args = queryConjunct0.getArgs();
    static final Variable variableDisease = (Variable) queryConjunct0Args.elementAt(1);
    */
    static final Atom queryConjunct1 = (Atom) queryConjuncts.elementAt(1);
    static final Vector queryConjunct1Args = queryConjunct1.getArgs();
    static final Variable variablexyz = (Variable) queryConjunct1Args.elementAt(1);
    
    private Vector triggerArgs = null;
    private IntSymbol cnt = null;
    // private Symbol disease = null;
    private Existential queryFormulaX = null;
    private CG cg = null;

    public void init() {
	priority = 2;
	triggerArgs = trigger.getArgs();
	cnt = (IntSymbol) triggerArgs.elementAt(0);
	// disease = (Symbol)  triggerArgs.elementAt(1);
	queryFormulaX = (Existential) queryFormula.subst(variablexyz, cnt);
	// queryFormulaX = (Existential) queryFormulaX.subst(variableDisease, disease);
	// because we know that it cannot be proven by the preprocessors in the theory
	// we go directly to a connection graph
	cg = theory.setUpCGforConjecture(queryFormulaX); 
    }

    // trigger ~=~ ActorWorry(309) 
    // reply true if no similar alert was launched in this session already
    // Example: LaunchedActorWorry(309)
    // Test: (eq ?t &&(LaunchedActorWorry(?t) <(?t 309) ))

    public boolean execute() {
	resolveCnt++;
	if ( resolveMax < resolveCnt ) return false; 
	int out = cg.resolve();
	if ( 0 < out ) {
	    actor.addTrace("ActorWorry: execute(): resolve out= " + out);
	    return true; // no decision yet
	}
	if ( 0 == out ) { // no need to launch again
	    actor.addTrace("ActorWorry: execute(): *NOT* launching trigger = " + 
			   trigger.html());
	    return false; // terminate this task
	}
	actor.addTrace("ActorWorry: execute(): *DO* launch trigger = " + trigger.html());
	Atom newAssertion = (Atom) queryConjunct0.subst(tVariable, cnt);
	// newAssertion = (Atom) newAssertion.subst(variableDisease, disease);
	theory.addAssertion(newAssertion);
	Job job = alert.getJob();
	actor.addAction(job);
	actor.wakeUp();
	alert.setLaunched(true);
	return false; // terminate this task
    } // end execute

} // end  ActorWorry


class ChildFeverWarning extends Dispatcher {
    static final String query = 
	"(eq ?t &&(LaunchedChildFeverWarning(?t) ==(?t ?variablexyz) ))";
    static final Existential queryFormula = (Existential) Parser.parse3(query);
    static final Variable tVariable = queryFormula.getVariable();
    static final Conjunction queryConjunction = (Conjunction) queryFormula.getBody();
    static final Vector queryConjuncts = queryConjunction.getConjuncts();
    static final Atom queryConjunct0 = (Atom) queryConjuncts.elementAt(0);
    /*
    static final Vector queryConjunct0Args = queryConjunct0.getArgs();
    static final Variable variableDisease = (Variable) queryConjunct0Args.elementAt(1);
    */
    static final Atom queryConjunct1 = (Atom) queryConjuncts.elementAt(1);
    static final Vector queryConjunct1Args = queryConjunct1.getArgs();
    static final Variable variablexyz = (Variable) queryConjunct1Args.elementAt(1);
    
    private Vector triggerArgs = null;
    // private IntSymbol cnt = null;
    private Symbol child = null;
    // private Symbol disease = null;
    private Existential queryFormulaX = null;
    private CG cg = null;

    public void init() {
	priority = 2;
	triggerArgs = trigger.getArgs();
	child = (Symbol) triggerArgs.elementAt(0);
	// disease = (Symbol)  triggerArgs.elementAt(1);
	queryFormulaX = (Existential) queryFormula.subst(variablexyz, child);
	// queryFormulaX = (Existential) queryFormulaX.subst(variableDisease, disease);
	// because we know that it cannot be proven by the preprocessors in the theory
	// we go directly to a connection graph
	cg = theory.setUpCGforConjecture(queryFormulaX); 
    }

    // trigger ~=~ ChildFeverWarning(peter) 
    // reply true if no similar alert was launched in this session already 
    // Example: LaunchedChildFeverWarning(309)
    // Test: (eq ?t &&(LaunchedChildFeverWarning(?t) ==(?t peter) ))

    public boolean execute() {
	resolveCnt++;
	if ( resolveMax < resolveCnt ) return false; 
	int out = cg.resolve();
	if ( 0 < out ) {
	    actor.addTrace("ChildFeverWarning: execute(): resolve out= " + out);
	    return true; // no decision yet
	}
	if ( 0 == out ) { // no need to launch again
	    actor.addTrace("ChildFeverWarning: execute(): *NOT* launching trigger = " + 
			   trigger.html());
	    return false; // terminate this task
	}
	actor.addTrace("ChildFeverWarning: execute(): *DO* launch trigger = " + trigger.html());
	Atom newAssertion = (Atom) queryConjunct0.subst(tVariable, child);
	// newAssertion = (Atom) newAssertion.subst(variableDisease, disease);
	theory.addAssertion(newAssertion);
	Job job = alert.getJob();
	actor.addAction(job);
	actor.wakeUp();
	alert.setLaunched(true);
	return false; // terminate this task
    } // end execute

} // end  ChildFeverWarning


class ChildSymptoms1 extends Dispatcher {
    static final String query = 
	"(eq ?t &&(LaunchedChildSymptoms1(?t) ==(?t ?variablexyz) ))";
    static final Existential queryFormula = (Existential) Parser.parse3(query);
    static final Variable tVariable = queryFormula.getVariable();
    static final Conjunction queryConjunction = (Conjunction) queryFormula.getBody();
    static final Vector queryConjuncts = queryConjunction.getConjuncts();
    static final Atom queryConjunct0 = (Atom) queryConjuncts.elementAt(0);
    /*
    static final Vector queryConjunct0Args = queryConjunct0.getArgs();
    static final Variable variableDisease = (Variable) queryConjunct0Args.elementAt(1);
    */
    static final Atom queryConjunct1 = (Atom) queryConjuncts.elementAt(1);
    static final Vector queryConjunct1Args = queryConjunct1.getArgs();
    static final Variable variablexyz = (Variable) queryConjunct1Args.elementAt(1);
    
    private Vector triggerArgs = null;
    // private IntSymbol cnt = null;
    private Symbol child = null;
    // private Symbol disease = null;
    private Existential queryFormulaX = null;
    private CG cg = null;

    public void init() {
	priority = 2;
	triggerArgs = trigger.getArgs();
	child = (Symbol) triggerArgs.elementAt(0);
	// disease = (Symbol)  triggerArgs.elementAt(1);
	queryFormulaX = (Existential) queryFormula.subst(variablexyz, child);
	// queryFormulaX = (Existential) queryFormulaX.subst(variableDisease, disease);
	// because we know that it cannot be proven by the preprocessors in the theory
	// we go directly to a connection graph
	cg = theory.setUpCGforConjecture(queryFormulaX); 
    }

    // trigger ~=~ ChildSymptoms1(peter) 
    // reply true if no similar alert was launched in this session already 
    // Example: LaunchedChildSymptoms1(309)
    // Test: (eq ?t &&(LaunchedChildSymptoms1(?t) ==(?t peter) ))

    public boolean execute() {
	resolveCnt++;
	if ( resolveMax < resolveCnt ) return false; 
	int out = cg.resolve();
	if ( 0 < out ) {
	    actor.addTrace("ChildSymptoms1: execute(): resolve out= " + out);
	    return true; // no decision yet
	}
	if ( 0 == out ) { // no need to launch again
	    actor.addTrace("ChildSymptoms1: execute(): *NOT* launching trigger = " + 
			   trigger.html());
	    return false; // terminate this task
	}
	actor.addTrace("ChildSymptoms1: execute(): *DO* launch trigger = " + trigger.html());
	Atom newAssertion = (Atom) queryConjunct0.subst(tVariable, child);
	// newAssertion = (Atom) newAssertion.subst(variableDisease, disease);
	theory.addAssertion(newAssertion);
	Job job = alert.getJob();
	actor.addAction(job);
	actor.wakeUp();
	alert.setLaunched(true);
	return false; // terminate this task
    } // end execute

} // end  ChildSymptoms1


class ChildPolydipsiaAnduriaWarning extends Dispatcher {
    static final String query = 
	"(eq ?t &&(LaunchedChildPolydipsiaAnduriaWarning(?t) ==(?t ?variablexyz) ))";
    static final Existential queryFormula = (Existential) Parser.parse3(query);
    static final Variable tVariable = queryFormula.getVariable();
    static final Conjunction queryConjunction = (Conjunction) queryFormula.getBody();
    static final Vector queryConjuncts = queryConjunction.getConjuncts();
    static final Atom queryConjunct0 = (Atom) queryConjuncts.elementAt(0);
    /*
    static final Vector queryConjunct0Args = queryConjunct0.getArgs();
    static final Variable variableDisease = (Variable) queryConjunct0Args.elementAt(1);
    */
    static final Atom queryConjunct1 = (Atom) queryConjuncts.elementAt(1);
    static final Vector queryConjunct1Args = queryConjunct1.getArgs();
    static final Variable variablexyz = (Variable) queryConjunct1Args.elementAt(1);
    
    private Vector triggerArgs = null;
    // private IntSymbol cnt = null;
    private Symbol child = null;
    // private Symbol disease = null;
    private Existential queryFormulaX = null;
    private CG cg = null;

    public void init() {
	priority = 2;
	triggerArgs = trigger.getArgs();
	child = (Symbol) triggerArgs.elementAt(0);
	// disease = (Symbol)  triggerArgs.elementAt(1);
	queryFormulaX = (Existential) queryFormula.subst(variablexyz, child);
	// queryFormulaX = (Existential) queryFormulaX.subst(variableDisease, disease);
	// because we know that it cannot be proven by the preprocessors in the theory
	// we go directly to a connection graph
	cg = theory.setUpCGforConjecture(queryFormulaX); 
    }

    // trigger ~=~ ChildPolydipsiaAnduriaWarning(peter) 
    // reply true if no similar alert was launched in this session already 
    // Example: LaunchedChildPolydipsiaAnduriaWarning(309)
    // Test: (eq ?t &&(LaunchedChildPolydipsiaAnduriaWarning(?t) ==(?t peter) ))

    public boolean execute() {
	resolveCnt++;
	if ( resolveMax < resolveCnt ) return false; 
	int out = cg.resolve();
	if ( 0 < out ) {
	    actor.addTrace("ChildPolydipsiaAnduriaWarning: execute(): resolve out= " + out);
	    return true; // no decision yet
	}
	if ( 0 == out ) { // no need to launch again
	    actor.addTrace("ChildPolydipsiaAnduriaWarning: execute(): *NOT* launching trigger = " + 
			   trigger.html());
	    return false; // terminate this task
	}
	actor.addTrace("ChildPolydipsiaAnduriaWarning: execute(): " +
		       "*DO* launch trigger = " + trigger.html());
	Atom newAssertion = (Atom) queryConjunct0.subst(tVariable, child);
	// newAssertion = (Atom) newAssertion.subst(variableDisease, disease);
	theory.addAssertion(newAssertion);
	Job job = alert.getJob();
	actor.addAction(job);
	actor.wakeUp();
	alert.setLaunched(true);
	return false; // terminate this task
    } // end execute

} // end  ChildPolydipsiaAnduriaWarning



