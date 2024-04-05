// (C) OntoOO Inc 2005 Apr
package actors;

import patient.DiseaseInst;
import com.LR;

import java.util.*;
import java.io.*;


public abstract class Monitor  {
    protected int previousInt = 0;
    protected float previousFloat = 0;
    protected String previousString = "";
    protected boolean previousBool = false;
    protected ActorBase actorMonitored = null;

    protected RunMonitor myRunMonitor = null;
    public void setMyRunMonitor(RunMonitor x) { myRunMonitor = x; }

    /*  state can register a down stream effect; if used, check() can do:
	state.wakeUp() to notify other monitors that depend on state
    */
    protected State state = null; 

    public Monitor (ActorBase actor, State state) { 
	actorMonitored = actor; 
	this.state = state;
    }
    public Monitor (ActorBase actor) { this(actor, null); }

    public ActorBase getActorMonitored() { return actorMonitored; }
    /* RunMonitor calls check() periodically.
       A state can also trigger check() to run via the wakeUp() feature
       in RunMonitor, as mentioned above
    */
    abstract public void check(); 
    protected int lastCnt = 0; 
    public int getLastCnt() { return lastCnt; }
    protected int previousCnt = 0; 

    protected void check0() {
	previousCnt = lastCnt;
	lastCnt = actorMonitored.getCnt();
    }

} // end Monitor

/* There is at most one task running, which is referred to in Actor by the taskFocus
   This monitor keeps an eye on the focus and if no task is running it restarts the
   nulltask is the taskList is empty otherwise it grabs the first task.
*/
class MonitorTaskFocus extends Monitor {
    public MonitorTaskFocus (ActorBase actor) { super(actor); }
    public void check() {
	check0();
	// actorMonitored.addTrace("MonitorTaskFocus: checking task focus ....");
	Task taskFocus = actorMonitored.getTaskFocus();
	if ( null == taskFocus ) {
	    LinkedList taskList = actorMonitored.getTaskList();
	    Task task0;
	    synchronized ( actorMonitored ) {
		task0 = 
		    ( 0 < taskList.size() ?
		      (Task) taskList.removeFirst() :
		      actorMonitored.getNullTask() );
	    }
	    actorMonitored.setTaskFocus(task0);
	    task0.start();
	    actorMonitored.addTrace
		("MonitorTaskFocus: new task= " + task0.getJobClassName());
	}
    } // end check()
} // end MonitorTaskFocus


class MonitorTrackPage extends Monitor {
    private ActorPatient patient = null;
    public MonitorTrackPage (Actor actor, State visitedPage) { 
	super(actor, visitedPage); 
	patient = actor.getPatient();
    }
    public void check() {
	check0();
	Actor actor = (Actor) actorMonitored;
	State currentPage = patient.getCurrentPage();
	String currentPageStr = currentPage.getStringValue();
	int currentPageCnt = currentPage.getIntValue();
	State visitedPage = state;
	if ( !previousString.equals(currentPageStr) ) {
	    previousString = currentPageStr;
	    visitedPage.setStringValue(currentPageStr);
	    previousInt = currentPageCnt;
	    visitedPage.setIntValue(currentPageCnt);
	    visitedPage.wakeUp();
	    return;
	}
	if ( previousInt != currentPageCnt ) {
	    previousInt = currentPageCnt;
	    visitedPage.setIntValue(currentPageCnt);
	    visitedPage.wakeUp();
	    return;
	}
    } // end check
} // end MonitorTrackPage


class MonitorPagesPatient extends Monitor {
    public MonitorPagesPatient(Actor actor, State patientInaction) {
	super(actor, patientInaction); 
    }
    public void check() {
	check0();
	Actor actor = (Actor) actorMonitored;
	State visitedPage = actor.getPageAndCounter();
	String currentPage = visitedPage.getStringValue();
	if ( currentPage.equals("") ) return; // cant do anything
	synchronized(visitedPage) {
	    String previousPage = previousString; 
	    previousString = currentPage;
	    if ( !currentPage.equals(previousPage) ) {
		actorMonitored.addTrace
		    ("MonitorPagesPatient: page change: " +
		     "<br>with previous page= " + previousPage + 
		     " previous page cnt = " + previousInt + 
		     " current page= " + currentPage 
		     );
		State precedingPage = new State(previousInt);
		precedingPage.setStringValue(previousPage);
		ActorPatient patient = actor.getPatient();
		Vector visitedPages = patient.getVisitedPages();
		visitedPages.addElement(precedingPage);

		previousInt = visitedPage.getIntValue();
		state.setFloatValue(0); 
		state.wakeUp(); // notify monitors interested in certain pages
	    } 
	}
    } // end check()
} // end MonitorPagesPatient


class MonitorPageCount extends Monitor {
    public MonitorPageCount(Actor actor, State patientInaction) { 
	super(actor, patientInaction); 
    }
    public void check() {
	check0();
	Actor actor = (Actor) actorMonitored;
	State visitedPage = actor.getPageAndCounter();
	String currentPage = visitedPage.getStringValue();
	if ( currentPage.equals("") ) return; // cant do anything
	synchronized(visitedPage) {
	    int previousPageCnt = previousInt; 
	    int currentPageCnt = visitedPage.getIntValue();
	    previousInt = currentPageCnt;
	    if ( currentPageCnt != previousPageCnt ) { 
		actorMonitored.addTrace
		    ("MonitorPageCount: count up: " +
		     " currentPageCnt: " + currentPageCnt);
		// generate warning when nothing happens during 20 ticks
		if ( 20 < currentPageCnt ) {
		actorMonitored.addTrace
		    ("MonitorPageCount: -> increasing patient inaction");
		    state.increaseFloatValue();
		    state.wakeUp();
		}
	    }
	}
    } // end check()
} // end MonitorPageCount


class MonitorVisitedPages extends Monitor {
    private ActorPatient patient = null;
    public MonitorVisitedPages (Actor actor) { 
	super(actor); 
	patient = actor.getPatient();
    }
    public void check() {
	check0();
	int x = previousInt; 
	Vector visitedPages = patient.getVisitedPages();
	int currentSize = visitedPages.size();
	previousInt = currentSize;
	if ( x != currentSize && 0 < currentSize ) {
	    actorMonitored.addTrace
		("MonitorVisitedPages: list of pages change: " +
		 actorMonitored.getName() +
		 patient.getVisitedPagesHtml()
		 );
	    // actorMonitored.visitedPagesEmpty();
	}
    } // end check()
} // end MonitorVisitedPages


class MonitorPatientInaction extends Monitor {
    public MonitorPatientInaction (Actor actor, State actorWorry) { 
	super(actor, actorWorry); }
    public void check() {
	check0();
	float x = previousFloat;
	Actor actor = (Actor) actorMonitored;
	previousFloat = actor.getPatientInactionValue();
	if ( x < previousFloat ) {
	    actor.addTrace
		("MonitorPatientInaction: inaction increases to: " +
		 previousFloat +
		 " also increasing actorWorry");
	    actor.patientInactionUp();
	    state.increaseFloatValue();
	    state.wakeUp();
	    return;
	} 
	if ( x == previousFloat ) return;
	actor.addTrace
		("MonitorPatientInaction: inaction decreases to: " + 
		 previousFloat +
		 " also decreasing actorWorry");
	state.decreaseFloatValue();
	state.wakeUp();
    } // end check()
} // end MonitorPatientInaction 


class MonitorDiag1cPage extends Monitor {
    private ActorPatient patient = null;
    public MonitorDiag1cPage(Actor actor, State diag1cState) {
	super(actor, diag1cState); 
	patient = actor.getPatient();
    }
    public void check() {
	check0();
	// actorMonitored.addTrace("MonitorDiag1cPage check()");
	Actor actor = (Actor) actorMonitored;
	State visitedPage = actor.getPageAndCounter();
	String currentPage = visitedPage.getStringValue();
	actorMonitored.addTrace("MonitorDiag1cPage currentPage1: " + currentPage);
	if ( !currentPage.equals("Diag1c") ) return; // cant do anything 
	state.wakeUp(); // triggers: MonitorLifeThreatening & others
    }
}
	

class MonitorLifeThreatening extends Monitor {
    private ActorPatient patient = null;
    public MonitorLifeThreatening(Actor actor) { 
	super(actor); 
	patient = actor.getPatient();
    }
    public MonitorLifeThreatening(Actor actor, State worry ) {
	this(actor);
	state = worry;
	previousInt = -1;
    } 

    public void check() {
	check0();
	Actor actor = (Actor) actorMonitored;
	// actor.addTrace("MonitorLifeThreatening check");
	Vector diseasesInst = patient.getDiseasesInst();
	if ( null == diseasesInst ) {
	    actor.addTrace(
	       "MonitorLifeThreatening null == diseasesInst");
	    return;
	}
	int lng = diseasesInst.size();
	// actor.addTrace("MonitorLifeThreatening lng = " + lng);
	DiseaseInst di = null;
	float acceptanceRate = 0;
	// float ar;
	int index = -1;
	for (int i = 0; i < lng; i++) {
	  di = (DiseaseInst) diseasesInst.elementAt(i);
	  acceptanceRate = di.getAcceptanceRate();
	  if ( di.isLifeThreatening() ) {
	    index = i; // found a life threatening disease
	    break;
	  } 
	}
	if ( -1 == index ) return; // nothing found
	if ( acceptanceRate < 0.4 ) return; // ignore 
	// di = (DiseaseInst) diseasesInst.elementAt(index);
	String disease = di.getDisease();

	if ( -1 == previousInt ) { // first time we find one
	    previousInt = index;
	    previousFloat = acceptanceRate;
	    previousString = disease;
	    actor.lifeThreateningConjecture(disease, acceptanceRate);
	    actor.addTrace("MonitorLifeThreatening disease: " +
				    disease + 
				    " acceptanceRate: " +
				    acceptanceRate);
	    // increase worry of the actor
	    state.increaseFloatValue();
	    state.wakeUp();
	    return;
	}

	if ( previousInt < index ) {
	    // non-life threatening disease appears more plausible
	    previousInt = index;
	    previousFloat = acceptanceRate;
	    previousString = disease;
	    state.decreaseFloatValue();
	    state.wakeUp();
	    return;
	}

	if ( previousFloat < acceptanceRate ) {
	    // life threatening disease appears more plausible
	    previousInt = index;
	    previousFloat = acceptanceRate;
	    previousString = disease;
	    actor.lifeThreateningConjecture(disease, acceptanceRate);
	    actor.addTrace("MonitorLifeThreatening disease: " +
				    disease + 
				    " acceptanceRate: " +
				    acceptanceRate);
	    // increase worry of the actor
	    state.increaseFloatValue();
	    state.wakeUp();
	    return;
	}

	if ( !previousString.equals(disease) ) {
	    // different disease
	    previousInt = index;
	    previousFloat = acceptanceRate;
	    previousString = disease;
	    actor.lifeThreateningConjecture(disease, acceptanceRate);
	    actor.addTrace("MonitorLifeThreatening disease: " +
				    disease + 
				    " acceptanceRate: " +
				    acceptanceRate);
	    
	    // state.increaseFloatValue();
	    // state.wakeUp();

	    return;
	}
    } // end check()
} // end MonitorLifeThreatening


class MonitorInternalCause extends Monitor {
    private ActorPatient patient = null;
    public MonitorInternalCause(Actor actor) { 
	super(actor); 
	patient = actor.getPatient();
    }
    public void check() {
	check0();
	Actor actor = (Actor) actorMonitored;
	// actor.addTrace("MonitorInternalCause check");
	Vector diseasesInst = patient.getDiseasesInst();
	if ( null == diseasesInst ) {
	    actor.addTrace(
	       "MonitorInternalCause null == diseasesInst");
	    return;
	}
	// HashSet hs = patient.getPreviousDiseases();
	HashSet hs = patient.getCandidateDiseases();
	int lng = diseasesInst.size();
	// actor.addTrace("MonitorInternalCause lng = " + lng);
	DiseaseInst di;
	float acceptanceRate = 0;
	int index = 0;
	String disease = null;
	for (int i = 0; i < lng; i++) {
	  di = (DiseaseInst) diseasesInst.elementAt(i);
	  acceptanceRate = di.getAcceptanceRate();
	  disease = di.getDisease();
	  if ( hs.contains(disease) ) {
	    index = i; // found a down stream disease
	    break;
	  } 
	}
	if ( acceptanceRate < 0.4 ) return; // ignore 
	String previousDisease = previousString; 
	float previousRate = previousFloat;
	boolean diseaseChange = false;
	boolean rateChange = false;
	if ( !previousString.equals(disease) ) {
	    diseaseChange = true;
	    previousString = disease;
	}
	if ( previousFloat != acceptanceRate ) {
	    rateChange = true;
	    previousFloat = acceptanceRate;
	}
	if ( diseaseChange || rateChange ) {
	    actor.internalCauseConjecture(disease, acceptanceRate);
	    actor.addTrace("MonitorInternalCause disease: " +
				    disease + 
				    " acceptanceRate: " +
				    acceptanceRate);
	}

    } // end check()
} // end MonitorInternalCause



class MonitorPreviousDisease extends Monitor {
    private ActorPatient patient = null;
    public MonitorPreviousDisease(Actor actor) { 
	super(actor); 
	patient = actor.getPatient();
    }
    public void check() {
	check0();
	Actor actor = (Actor) actorMonitored;
	// actor.addTrace("MonitorPreviousDisease check");
	Vector diseasesInst = patient.getDiseasesInst();
	if ( null == diseasesInst ) {
	    actor.addTrace(
	       "MonitorPreviousDisease null == diseasesInst");
	    return;
	}
	HashSet hs = patient.getPreviousDiseases();
	// HashSet hs = patient.getCandidateDiseases();
	int lng = diseasesInst.size();
	// actor.addTrace("MonitorPreviousDisease lng = " + lng);
	DiseaseInst di;
	float acceptanceRate = 0;
	int index = 0;
	String disease = null;
	for (int i = 0; i < lng; i++) {
	  di = (DiseaseInst) diseasesInst.elementAt(i);
	  acceptanceRate = di.getAcceptanceRate();
	  disease = di.getDisease();
	  if ( hs.contains(disease) ) {
	    index = i; // found a down stream disease
	    break;
	  } 
	}
	if ( acceptanceRate < 0.4 ) return; // ignore 
	String previousDisease = previousString; 
	float previousRate = previousFloat;
	boolean diseaseChange = false;
	boolean rateChange = false;
	if ( !previousString.equals(disease) ) {
	    diseaseChange = true;
	    previousString = disease;
	}
	if ( previousFloat != acceptanceRate ) {
	    rateChange = true;
	    previousFloat = acceptanceRate;
	}
	if ( diseaseChange || rateChange ) {
	    actor.previousDisease(disease, acceptanceRate);
	    actor.addTrace("MonitorPreviousDisease disease: " +
				    disease + 
				    " acceptanceRate: " +
				    acceptanceRate);
	}

    } // end check()
} // end MonitorPreviousDisease


class MonitorIterationDepth extends Monitor {
    private ActorPatient patient = null;
    public MonitorIterationDepth(Actor actor) { 
	super(actor); 
	patient = actor.getPatient();
    }
    public void check() {
	check0();
	Actor actor = (Actor) actorMonitored;
	// actor.addTrace("MonitorIterationDepth check");
	int iterationDepth = patient.getIteration();
	if ( iterationDepth < 0 ) return;
	if ( previousInt == iterationDepth ) return;
	previousInt = iterationDepth;
	if ( iterationDepth <= 8 ) return; // adjust this value ....
	actor.addTrace("MonitorIterationDepth depth: " + iterationDepth);
	actor.iterationDepth(iterationDepth);
    } // end check()
} // end MonitorIterationDepth


class MonitorNumberDecidedSymptoms extends Monitor {
    private ActorPatient patient = null;
    public MonitorNumberDecidedSymptoms(Actor actor) { 
	super(actor); 
	patient = actor.getPatient();
    }
    public void check() {
	check0();
	Actor actor = (Actor) actorMonitored;
	// actor.addTrace("MonitorNumberDecidedSymptoms check");
	int numberDecidedSymptoms = patient.getNumberDecidedSymptoms();
	if ( numberDecidedSymptoms <= 0 ) return;
	if ( previousInt == numberDecidedSymptoms ) return;
	previousInt = numberDecidedSymptoms;
	if ( numberDecidedSymptoms <= 80 ) return; // adjust this value ....
	actor.addTrace("MonitorNumberDecidedSymptoms: " + numberDecidedSymptoms);
	actor.numberDecidedSymptoms(numberDecidedSymptoms);
    } // end check()
} // end MonitorNumberDecidedSymptoms


class MonitorFever extends Monitor {
    private ActorPatient patient = null;
    public MonitorFever(Actor actor, State hasFever) { 
	super(actor, hasFever); 
	patient = actor.getPatient();
    }
    public void check() {
	check0();
	Actor actor = (Actor) actorMonitored;
	// actor.addTrace("MonitorFever check");
	float temperature = patient.getTemperature();
	if ( temperature <= 99.3f ) return;
	if ( previousFloat == temperature ) return;
	previousFloat = temperature;
	actor.addTrace("MonitorFever: " + temperature);
	State hasFever = state;
	hasFever.setTrue();
	hasFever.wakeUp();
    } // end check()
} // end MonitorFever


class MonitorChildFever extends Monitor {
    private ActorPatient patient = null;
    public MonitorChildFever(Actor actor) { 
	super(actor); 
	patient = actor.getPatient();
    }
    public void check() {
	check0();
	Actor actor = (Actor) actorMonitored;
	// actor.addTrace("MonitorChildFever check");
	// The next 'backward looking' check is to prevent the monitor to fire 
	// when it is launched ...
	/*
	State hasFever = actor.getHasFever();
	if ( !hasFever.bool() ) return;
	int age = patient.getAge();
	if ( age < 0 ) return;
	if ( 6 <= age ) return;
	*/
	int age = patient.getAge();
	actor.addTrace("MonitorChildFever age: " + age);
	actor.childFeverWarning();
    } // end check()
} // end MonitorChildFever


class MonitorChildSymptoms1 extends Monitor {
    static private String[] watchList = {
	/*
	"confusion", "convulsions", "hematuria", "lethargy", 
	"stoolBloody", "stridor", "weightLoss"
	*/
	LR.confusion, LR.convulsions, LR.hematuria, LR.lethargy, 
	LR.stoolBloody, LR.stridor, LR.vomitBile, LR.weightLoss	
    };
    static private int watchListLng = watchList.length;
    private HashSet repository = new HashSet();
    private ActorPatient patient = null;
    public MonitorChildSymptoms1(Actor actor) { 
	super(actor); 
	patient = actor.getPatient();
    }
    public void check() {
	check0();
	Actor actor = (Actor) actorMonitored;
	// actor.addTrace("MonitorChildSymptoms1 check");
	Vector selectedSymptoms = patient.getSelectedSymptoms();
	if ( null == selectedSymptoms ) return;
	Vector foundSymptoms = new Vector();
	for ( int i = 0; i < watchListLng; i++ ) {
	    String sym = watchList[i];
	    if ( selectedSymptoms.contains(sym) && !repository.contains(sym) ) {
		foundSymptoms.addElement(sym);
		repository.add(sym);
	    }
	}
	int lng = foundSymptoms.size();
	if ( 0 == lng ) return;
	actor.addTrace("MonitorChildSymptoms1: " + foundSymptoms.toString());
	actor.childSymptoms1(foundSymptoms);
    } // end check()
} // end MonitorChildSymptoms1


class MonitorChildHasPolyuria extends Monitor {
    private ActorPatient patient = null;
    public MonitorChildHasPolyuria(Actor actor, State childHasPolyuria) { 
	super(actor, childHasPolyuria); 
	patient = actor.getPatient();
    }
    public void check() {
	check0();
	if ( previousBool ) return; // already set
	Actor actor = (Actor) actorMonitored;
	// actor.addTrace("MonitorChildHasPolyuria check");
	Vector selectedSymptoms = patient.getSelectedSymptoms();
	if ( null == selectedSymptoms ) return;
	if ( !selectedSymptoms.contains(LR.polyuria) ) return;
	actor.addTrace("MonitorChildHasPolyuria: true");
	previousBool = true;
	State hasChildHasPolyuria = state;
	hasChildHasPolyuria.setTrue();
	hasChildHasPolyuria.wakeUp();
    } // end check()
} // end MonitorChildHasPolyuria


class MonitorChildHasPolydipsia extends Monitor {
    private ActorPatient patient = null;
    public MonitorChildHasPolydipsia(Actor actor, State childHasPolydipsia) { 
	super(actor, childHasPolydipsia); 
	patient = actor.getPatient();
    }
    public void check() {
	check0();
	if ( previousBool ) return; // already set
	Actor actor = (Actor) actorMonitored;
	// actor.addTrace("MonitorChildHasPolydipsia check");
	Vector selectedSymptoms = patient.getSelectedSymptoms();
	if ( null == selectedSymptoms ) return;
	if ( !selectedSymptoms.contains(LR.polydipsia) ) return;
	actor.addTrace("MonitorChildHasPolydipsia: true");
	previousBool = true;
	State hasChildHasPolydipsia = state;
	hasChildHasPolydipsia.setTrue();
	hasChildHasPolydipsia.wakeUp();
    } // end check()
} // end MonitorChildHasPolydipsia


class MonitorChildHasPolydipsiaAnduria extends Monitor {
    private ActorPatient patient = null;
    public MonitorChildHasPolydipsiaAnduria(Actor actor) { 
	super(actor); 
	patient = actor.getPatient();
    }
    public void check() {
	check0();
	if ( previousBool ) return; // already set
	Actor actor = (Actor) actorMonitored;
	// actor.addTrace("MonitorChildHasPolydipsiaAnduria check");
	Vector selectedSymptoms = patient.getSelectedSymptoms();
	if ( null == selectedSymptoms ) return;
	if ( !selectedSymptoms.contains(LR.polydipsia) ) return;
	if ( !selectedSymptoms.contains(LR.polyuria) ) return;
	actor.addTrace("MonitorChildHasPolydipsiaAnduria: true");
	previousBool = true;
	actor.childPolydipsiaAnduriaWarning();
    } // end check()
} // end MonitorChildHasPolydipsiaAnduria


class MonitorPatientWorry extends Monitor {
    public MonitorPatientWorry (Actor actor, State actorWorry) { 
	super(actor, actorWorry); } 
    public void check() {
	check0();
	Actor actor = (Actor) actorMonitored;
	State patientWorry = actor.getWorry();
	float x = patientWorry.getFloatValue();
	State actorWorry = state;
	if ( previousFloat < x ) {
	    actor.addTrace
		("MonitorPatientWorry:" +
		 " previousCnt: " + previousCnt +
		 " lastCnt: " + lastCnt +
		 " previous worry: " + previousFloat +
		 " current worry : " + x);
	    previousFloat = x;
	    if ( previousCnt < lastCnt ) {
		// this condition prevents the update when the actor starts
		actorWorry.increaseFloatValue();
		actorWorry.wakeUp();
	    }
	} else 
	if ( previousFloat > x ) {
	    actor.addTrace
		("MonitorPatientWorry:" +
		 " previousCnt: " + previousCnt +
		 " lastCnt: " + lastCnt +
		 " previous worry: " + previousFloat +
		 " current worry : " + x);
	    previousFloat = x;
	    actorWorry.decreaseFloatValue();
	    actorWorry.wakeUp();
	}
    } // end check()
} // end MonitorPatientWorry


class MonitorPatientDiagnosing extends Monitor {
    public MonitorPatientDiagnosing(Actor actor, State state) { 
	super(actor, state); 
    }
    public void check() {
	check0();
	// actorMonitored.addTrace("MonitorPatientDiagnosing check()");
	Actor actor = (Actor) actorMonitored;
	State visitedPage = actor.getPageAndCounter();
	String currentPage = visitedPage.getStringValue();
	if ( currentPage.equals("") ) return; // cant do anything
	// actorMonitored.addTrace("MonitorPatientDiagnosing currentPage1: " + currentPage);
	if ( currentPage.equals("DiagStart") ||
	     currentPage.equals("Diag1Focussed") ||
	     currentPage.equals("Diag1SearchLTD") ||
	     currentPage.equals("Diag1Subsystem") ||
	     currentPage.equals("Diag1DiseaseSubsets") ||
	     currentPage.equals("Diag1Unrestricted") ||
	     currentPage.equals("Diag1a") ||
	     currentPage.equals("Diag1c") ) {
	    if ( !state.bool() ) {
		state.setTrue();
		actorMonitored.addTrace("MonitorPatientDiagnosing START diagnosing");
		state.wakeUp();
	    }
	} else // now not diagnosing
	if ( state.bool() ) {
	    state.setFalse();
	    actorMonitored.addTrace("MonitorPatientDiagnosing STOP diagnosing");
	    state.wakeUp();
	}
    } // end check
} // end MonitorPatientDiagnosing


// -|-|-|-|-|-|-|-|-|-|-|-|-|-|  META -|-|-|-|-|-|-|-|-|-|-|-|-|-|  

class MonitorActorAlertTrace extends Monitor {
    public MonitorActorAlertTrace (ActorMeta actor) { super(actor); }
    public void check() {
	check0();
	// actorMonitored.addTrace("MonitorActorAlertTrace: checking alert trace ....");
	ActorMeta actorMeta = (ActorMeta) actorMonitored;
	Actor actor = actorMeta.getActor();
	Vector alertTrace = actor.getAlertTrace();
	int lng = alertTrace.size();
	if ( previousInt < lng ) {
	    previousInt = lng;
	    actorMeta.insertTask(new Task(new ShowAlertTrace(actorMeta)));
	    actorMeta.addTrace(
		"MonitorActorAlertTrace: new task= AnalyzeAlertTrace");
	} 
    } // end check()
} // end MonitorActorAlertTrace


class MonitorActorTasksCounter extends Monitor {
    public MonitorActorTasksCounter (ActorMeta actor) { super(actor); }
    public void check() {
	check0();
	ActorMeta actorMeta = (ActorMeta) actorMonitored;
	Actor actor = actorMeta.getActor();
	State tasksCounter = actor.getTasksCounter();
	int x = tasksCounter.getIntValue();
	if ( previousInt < x ) {
	    actorMeta.addTrace
		("MonitorActorTasksCounter:" +
		 " previousCnt: " + previousCnt +
		 " lastCnt: " + lastCnt +
		 " previousInt: " + previousInt +
		 " x: " + x);
	    previousInt = x;
	}
    } // end check()
} // end MonitorActorTasksCounter


class MonitorActorWorry extends Monitor {
    public MonitorActorWorry (ActorMeta actor) { 
	super(actor); } 
    public void check() {
	check0();
	ActorMeta actorMeta = (ActorMeta) actorMonitored;
	Actor actor = actorMeta.getActor();
	State actorWorry = actor.getActorWorry();
	float x = actorWorry.getFloatValue();
	if ( previousFloat < x ) {
	    actor.addTrace
		("MonitorActorWorry:" +
		 " previousCnt: " + previousCnt +
		 " lastCnt: " + lastCnt +
		 " previous worry: " + previousFloat +
		 " current worry : " + x);
	    previousFloat = x;
	    if ( 0.8 < x ) actorMeta.actorWorry(x);
	} else 
	if ( previousFloat > x ) {
	    actor.addTrace
		("MonitorActorWorry:" +
		 " previousCnt: " + previousCnt +
		 " lastCnt: " + lastCnt +
		 " previous worry: " + previousFloat +
		 " current worry : " + x);
	    previousFloat = x;
	}
    } // end check()
} // end MonitorActorWorry


