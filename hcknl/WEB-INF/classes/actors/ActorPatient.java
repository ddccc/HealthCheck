// (C) OntoOO Inc 2004 Nov
package actors;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import misc.DiagStackEntry;
import patient.KClient;

public class ActorPatient extends ActorSuper   {


    static private Hashtable allSessions = new Hashtable();

    static public void putSession(String key, HttpSession session) {
	allSessions.put(key, session);
    }
    static public HttpSession fetchSession(String key) { 
	return (HttpSession) allSessions.get(key);
    }
    static public void removeSession(String key) {
	allSessions.remove(key);
    }



    public ActorPatient(String name) {
	super(name);
    }
    public void reset() {
	visitedPages = new Vector();
    }

    public void setSession(HttpSession session) {
	putSession(name, session);
    }
    public void removeSession() {
	removeSession(name);
    }

    private Vector visitedPages = new Vector(); // elements is visitedPage
    public Vector getVisitedPages() { return visitedPages; }
    public String getVisitedPagesHtml() { 
	String out = "";
	if ( null == visitedPage ) return out;
	StringBuffer sb = new StringBuffer("<br><b>VisitedPages:</b> ");
	int lng = visitedPages.size();
	State state;
	for (int i = 0; i < lng; i++) {
	    state = (State) visitedPages.elementAt(i);
	    sb.append(state.htmlStringInt0());
	    sb.append(" ");
	}
	sb.append(visitedPage.htmlStringInt0());
	out = sb.toString();
	return out;
    }

    private State visitedPage = new State();
    public State getVisitedPage() { return visitedPage; }

    public void addNewPage(String page) {
	if ( null != visitedPage ) visitedPages.addElement(visitedPage);
	visitedPage = new State(page);
    }

   

    private State currentPage = new State(-3);
    public State getCurrentPage() {
	String currentPageStr = null;
	String currentPageCnt = null;
	try {
	    HttpSession session = fetchSession(name);
	    if ( null == session ) return currentPage;
	    currentPageStr = (String) session.getValue("page");
	    currentPageCnt = (String) session.getValue("counter");
	} catch (Exception ex) { return currentPage; }
	if ( null == currentPageStr ) return currentPage; 
	if ( null == currentPageCnt ) currentPageCnt = "-2";
	int cnt;
	try { cnt = Integer.parseInt(currentPageCnt); }
	catch (NumberFormatException ex) { cnt = -1; }
	currentPage.setStringValue(currentPageStr);
	currentPage.setIntValue(cnt);
	return currentPage;
    } // end getCurrentPage()

    public void sendAlert(String message) {
	Actor actor = Actor.fetchActor(name);
	// String currentPageCnt = null;
	try {
	    HttpSession session = fetchSession(name);
	    if ( null == session ) return;
	    String previousMessage = null;
	    synchronized(KClient.synchroObject) {
		previousMessage = (String) session.getValue("sendAlert");
		previousMessage = ( null == previousMessage ? message :
				    previousMessage + "<br>" + message );
		session.putValue("sendAlert", previousMessage);
	    }
	    actor.addTrace("ActorPatient: sendAlert() put on session: " + previousMessage);
	    
	    // add message to the record 
	    String alertMessages = (String) session.getValue("alertMessages");
	    alertMessages = ( null == alertMessages ? message : 
			      alertMessages + "<br>" + message );
	    session.putValue("alertMessages", alertMessages);
	    Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");
	    unboundHashtable.put("alertMessages", alertMessages);
	} catch (Exception ignore) {
	    actor.addTrace("## ActorPatient FAILED to put on session: " + message);
	}
    } // end sendAlert(message)

    private Vector getDiagStack() {
	Vector out = null;
	try {
	    HttpSession session = fetchSession(name);
	    out = (Vector) session.getValue("diagStack");
	} catch (Exception ignore) { }
	return out;
    } // end getDiagStack()

    private DiagStackEntry getLastDSE() {
	Vector diagStack = getDiagStack();
	if ( null == diagStack ) return null;
	DiagStackEntry dse = null;
	try {
	    HttpSession session = fetchSession(name);
	    String iter = (String) session.getValue("iter");
	    int iteration = Integer.parseInt(iter);
	    dse = (DiagStackEntry) diagStack.elementAt(iteration);
	} catch (Exception ignore) { }
	return dse;
    }

    public Vector getDiseasesInst() {
	DiagStackEntry dse = getLastDSE();
	if ( null == dse ) return null;
	return dse.getDiseases();
    }

    public Vector getSelectedSymptoms() {
	DiagStackEntry dse = getLastDSE();
	if ( null == dse ) return null;
	Vector selectedSymptoms = null;
	try {
	    selectedSymptoms = (Vector) dse.getSelectedSymptoms();
	} catch (Exception ignore) {}
	return selectedSymptoms;
    }

    public int getNumberDecidedSymptoms() {
	DiagStackEntry dse = getLastDSE();
	if ( null == dse ) return -1;
	int out = 0;
	try {
	    Vector selectedSymptoms = (Vector) dse.getSelectedSymptoms();
	    HashSet notSelectedSymptoms = (HashSet) dse.getNotSelectedSymptoms();
	    out = selectedSymptoms.size() + notSelectedSymptoms.size();
	} catch (Exception ignore) {}
	return out;
    }

    public Vector getHistoryOfDiseases() {
	Actor actor = Actor.fetchActor(name);
	Vector out = null;
	try {
	    HttpSession session = fetchSession(name);
	    String logName = (String) session.getValue("logName");
	    Vector logSessions = Common.getLogSessions(logName);
	    Hashtable ht =(Hashtable) logSessions.elementAt(0);
	    out = (Vector) ht.get("historyOfDiseases");
	} catch (Exception ignore) { 
	    actor.addTrace("ActorPatient getHistoryOfDiseases() Exception: " +
			   ignore.getMessage());
	}
	return out;
    }

    public HashSet getPreviousDiseases() {
	Actor actor = Actor.fetchActor(name);
	HashSet out = null;
	try {
	    HttpSession session = fetchSession(name);
	    out = (HashSet) session.getValue("previousDiseases");
	} catch (Exception ignore) { 
	    actor.addTrace("ActorPatient getPreviousDiseases() Exception: " +
			   ignore.getMessage());
	}
	return out;
    }

    public HashSet getCandidateDiseases() {
	Actor actor = Actor.fetchActor(name);
	HashSet out = null;
	try {
	    HttpSession session = fetchSession(name);
	    out = (HashSet) session.getValue("candidateDiseases");
	} catch (Exception ignore) { 
	    actor.addTrace("ActorPatient getCandidateDiseases() Exception: " +
			   ignore.getMessage());
	}
	return out;
    }

    public int getIteration() {
	// Actor actor = Actor.fetchActor(name);
	int out = 0;
	try {
	    HttpSession session = fetchSession(name);
	    String iter = (String) session.getValue("iter");
	    if ( null == iter ) return -1;
	    out = Integer.parseInt(iter); 
	} catch (Exception ignore) { return -1; }
	return out;
    }

    public float getTemperature() {
	// Actor actor = Actor.fetchActor(name);
	float out = 99.3f;
	try {
	    HttpSession session = fetchSession(name);
	    Float temp = (Float) session.getValue("tsFloat");
	    if ( null == temp ) return -1;
	    out = temp.floatValue(); 
	} catch (Exception ignore) { return -1; }
	return out;
    }


    private State worry = new State(0.1f);
    public State getWorry() { return worry; }

    private State diagnosing = new State();
    public State getDiagnosing() { return diagnosing; }

    public void sendCCAdvice(String message) {
	Actor actor = Actor.fetchActor(name);
	try {
	    HttpSession session = fetchSession(name);
	    if ( null == session ) return;
	    String previousCCAdvice = (String) session.getValue("sendCCAdvice");
	    if ( null != previousCCAdvice ) 
		message = previousCCAdvice + "& " + message;
	    session.putValue("sendCCAdvice", message);
	    actor.addTrace("ActorPatient: sendCCAdvice() put on session: " + message);
	} catch (Exception ignore) {
	    actor.addTrace("## ActorPatient FAILED to put on session: " + message);
	}
    } // end sendCCAdvice(message)


    private State hasFever = new State();
    public State getHasFever() { return hasFever; }

    public int getAge() {
	int out = -1;
	try {
	    HttpSession session = fetchSession(name);
	    Integer ageInt = (Integer) session.getValue("ageInt");
	    if ( null == ageInt ) return -1;
	    out = ageInt.intValue();
	} catch (Exception ignore) { return -1; }
	return out;
    }

    private State hasPolyuria = new State();
    public State getHasPolyuria() { return hasPolyuria; }
    private State hasPolydipsia = new State();
    public State getHasPolydipsia() { return hasPolydipsia; }


} // end class ActorPatient












