// (C) OntoOO Inc 2002 Jul
package patient;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.DV;
import com.D;
import com.LR;
import com.L;
import su.DiseaseRecord;
import concepts.Disease;
import concepts.Symptom;
import concepts.Location;
import concepts.LocationSet;
import misc.DB;
import misc.PeriodLogin;
import misc.SendEmail;
import misc.HCError;
import htmls.AngelRoot;
import htmls.StartAnonymous;
import htmls.SetupAccount;
import actors.Actor;

public class AngelLogin extends HttpServlet  {

    static public String synchroObject = "synchroObject";
    static private int loginCnt = 0;
    static private int createCnt = 0;
    static private int quickCnt = 0; // for quick accounts naming
    static private DB HALogging = null;
    static private boolean HALoggingLoaded = false;
    static public boolean HALoggingSaved = false;
    static public Hashtable loggedInUsers = new Hashtable();
    static public void addUser(String logName, Object obj) { loggedInUsers.put(logName, obj); }
    static public Hashtable getLoggedInUsers() { return loggedInUsers; }
    static public void logoutUser(String logName) { loggedInUsers.remove(logName); }
    static private CheckLogger checkLogger = null;
    // setQuickCnt is called by AccountQuick in a desparate attempt to find 
    // an acceptable quickCnt value for the creation of a quick-account
    static public void setQuickCnt(int i) { quickCnt = i; }

    public void init(ServletConfig config) throws ServletException {
	super.init(config);
	initAngelLogin();
	checkLogger = new CheckLogger();
    }

    static public void initAngelLogin() {
	synchronized(synchroObject) {
	    if ( !HALoggingLoaded ) {
		// we load some hash tables in the background ...
		new LoadTables();
		startLogging(); 
	    }
	}
    }

    static public void startLogging() {
      String loggingFileName = D.healthAngelLogging;
      try {
	HALogging = new DB(loggingFileName);
      } catch (Exception ex) {
	HALogging = new DB();
	HALogging.setFileName(loggingFileName);
      }
      String loginCntStr = HALogging.getProperty("loginCnt", "0");
      String createCntStr = HALogging.getProperty("createCnt", "0");
      String quickCntStr = HALogging.getProperty("quickCnt", "0");
      // System.out.println("********quickCntStr: " + quickCntStr);
      try {
	loginCnt = Integer.parseInt(loginCntStr);
	createCnt = Integer.parseInt(createCntStr);
	quickCnt = Integer.parseInt(quickCntStr);
      } catch (Exception ignore) {}
      HALoggingLoaded = true;
    }
    // Called when the system terminates (ako finalize()-function)
    // Should be a no-op because all changes to the counters have been saved already
    public void destroy() {
	setAndSaveHALogging("AngelLogin.destroy");
    }

    static public void setAndSaveHALogging(String source) {
	synchronized(synchroObject) {
	    if ( !HALoggingSaved ) {
		HALogging.putProperty("loginCnt", "" + loginCnt);
		HALogging.putProperty("createCnt", "" + createCnt);
		HALogging.putProperty("quickCnt", "" + quickCnt);
		// To create a time line:
		// HALogging.extendProperty("loginCnt", "" + loginCnt);
		// and use to display a variant of: ShowWeightGraph.java
		try { HALogging.save(source); } catch (IOException ignore) {}
		HALoggingSaved = true;
	    }
	}
    }

    static public void incrementLoginCnt() { 
	loginCnt++; 
	HALoggingSaved = false;
	setAndSaveHALogging("AngelLogin.incrementLoginCnt");
    }
    static public void incrementCreateCnt() { 
	createCnt++; 
	HALoggingSaved = false;
    }
    static public int incrementAndFetchQuickCnt() { 
	synchronized(synchroObject) {
	    if ( !HALoggingLoaded ) {
		// we load some hash tables in the background ...
		new LoadTables();
		startLogging(); 
	    }
	}
	quickCnt++; 
	HALoggingSaved = false;
	setAndSaveHALogging("AngelLogin.incrementAndFetchQuickCnt");
	return quickCnt; 
    }

    public void doPost (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      // res.setContentType("text/html");
	
	String logName = req.getParameter("logName");
	if ((logName == null) || 
	    logName.equals("")
		) {
	  HCError.call(res,
		       // "Log name and password required!<br>" +
		       L.AngelLoginS1 + "<br>" +
		       // "Use the back arrow to return to the previous page."
		       L.AngelLoginS2
		       );
	  return;
	}
	synchronized ( loggedInUsers ) {
	  if ( loggedInUsers.containsKey(logName) ) {
	      HCError.call(res,
			   // "Can't login twice!<br>" +
			   L.AngelLoginS3 + "<br>" +
			   // "Use the back arrow to return to the previous page.<br>" +
			   L.AngelLoginS2 + "<br>" +
			   L.orTry +
			   "<a href='" + D.helpHtml + "'> Help</a>"
			   );
	      return;
	  }
	  loggedInUsers.put(logName, logName);
	}
	
	String password = req.getParameter("password");
	if ((password == null) ||
	    password.equals("")
		) {
	  logoutUser(logName);
	  HCError.call(res,
		       // "Log name and password required!<br>" +
		       L.AngelLoginS1 + "<br>" +
		       // "Use the back arrow to return to the previous page."
		       L.AngelLoginS2
		       );
	  return;
	}

	// Check user name
	String prefix2 = D.theUsersDir;
	DB props = null;
	try {
	  props = new DB(prefix2 + logName);
	} catch (IOException ignore) {}
	if ( null == props ) {
	    logoutUser(logName);
	    HCError.call(res,
			 // "User name - password combination not acceptable.<br>" +
			 L.AngelLoginS5 + "<br>" +
			 // "Use the back arrow to return to the previous page."
			 L.AngelLoginS2
			 );
	    return;
	}
	// Check password
	if ( !password.equals(props.getProperty("password")) ) {
	    logoutUser(logName);
	    HCError.call(res,
			 // "User name - password combination not acceptable.<br>" +
			 L.AngelLoginS5 + "<br>" +
			 // "Use the back arrow to return to the previous page."
			 L.AngelLoginS2
			 );
	    return;
	}
	call(req, res, logName, password, props);
    }

    static public void call(HttpServletRequest req,
			    HttpServletResponse res,
			    String logName, String password) 
	throws IOException {

	String prefix2 = D.theUsersDir;
	DB props = null;
	try {
	  props = new DB(prefix2 + logName);
	} catch (IOException ignore) {}
	if ( null == props ) { // impossible, but lets check anyway
	    logoutUser(logName);
	    HCError.call(res,
			 // "User name - password combination not acceptable.<br>" +
			 L.AngelLoginS5 + "<br>" +
			 // "Use the back arrow to return to the previous page."
			 L.AngelLoginS2
			 );
	    return;
	}
	call(req, res, logName, password, props);
    }

    static public void call(HttpServletRequest req,
			    HttpServletResponse res,
			    String logName, String password, DB props) 
	throws IOException {

	HttpSession session = req.getSession(true);
	if ( !session.isNew() ) {
	    session.invalidate();
	    logoutUser(logName);
	    HCError.call(res,
			 // "An unexpected session was invalidated.  Try to login again.<br>" +
			 L.AngelLoginS6 + "<br>" +
			 // "Use the back arrow to return to the previous page."
			 L.AngelLoginS2
			 );
	    return;
	}
	
	session.putValue("logName", logName);
	session.putValue("theDB", props);
	loggedInUsers.put(logName, session);

	Vector logSessions = Common.getLogSessions(logName);
	if ( 0 == logSessions.size() ) { // need still to set up account
	    // to delete logName from loggedInUsers when the session invalidates/ timeout:
	    session.putValue("removeUser", new RemoveUser(logName));
	    session.setMaxInactiveInterval(10 * DV.maxInactiveInterval); // 10 minutes

	    String anonymous = props.getProperty("anonymous");
	    if ( null != anonymous && anonymous.equals("1") )
		StartAnonymous.call(res, logName, password);
	    else
		SetupAccount.call(res);
	    return;
	}

        // test for intake session
	String intake = props.getProperty("intake");
	boolean intakeb = false;
	if ( null != intake ) {
	    intakeb = true;
	    props.remove("intake");
	    try { props.save("AngelLogin"); }
	    catch (IOException ignore) {}
	    session.putValue("intake", "1");
	}
	
	// extract previous diseases and candidate downstream diseases
	Hashtable ht =(Hashtable) logSessions.elementAt(0);
	Vector historyOfDiseases = (Vector) ht.get("historyOfDiseases");
	HashSet previousDiseases = new HashSet();
	HashSet candidateDiseases = new HashSet();
	int lng = historyOfDiseases.size();
	for ( int i = 0; i < lng; i++ ) {
	    DiseaseRecord dr = (DiseaseRecord) historyOfDiseases.elementAt(i);
	    String disease = dr.getDisease();
	    previousDiseases.add(disease);
	    Disease dis = Common.getDisease(disease);
	    Vector causesDiseases = dis.getCausesDiseases();
	    int lng2 = causesDiseases.size();
	    for ( int j = 0; j < lng2; j++ )
		candidateDiseases.add(causesDiseases.elementAt(j));
	}
	session.putValue("previousDiseases", previousDiseases);
	session.putValue("candidateDiseases", candidateDiseases);

	incrementLoginCnt();

	// this will add to session (see PeriodLogin):
	//    session.putValue("unboundHashtable", unboundHashtable);
	session.putValue("periodLogin", 
			 new PeriodLogin(logName, 
					 "unboundHashtable",
					 session.getId()));

	adjustGender(props);
	String gender = props.getProperty("gender");
	session.putValue("gender", gender);

	int age = calcAge(props);
	Integer ageInt = new Integer(age);
	session.putValue("ageInt", ageInt);

	// S1 and D1 are gender specific HashSet collections
	// allMaleSymptoms() and allFemaleSymptoms() both yield also gender neutral symptoms
	// same for allMaleDiseases() and allFemaleDiseases()
	// Here we filter them on age
	HashSet diseases = (gender.equals(LR.male) ?
			    Common.allMaleDiseases() :
			    Common.allFemaleDiseases());
	HashSet diseasesFiltered = new HashSet();
	for (Iterator it = diseases.iterator(); it.hasNext();) {
	    String dis = (String) it.next();
	    Disease disease = Common.getDisease(dis);
	    if ( age < disease.getMinAge() ) continue;
	    if ( disease.getMaxAge() < age ) continue;
	    diseasesFiltered.add(dis);
	}
	session.putValue("D1", diseasesFiltered);

	HashSet symptoms = (gender.equals(LR.male) ?
			    Common.allMaleSymptoms() :
			    Common.allFemaleSymptoms());
	HashSet symptomsFiltered = new HashSet();
	for (Iterator it = symptoms.iterator(); it.hasNext();) {
	    String sym = (String) it.next();
	    Symptom symptom = Common.getSymptom(sym);
	    // if ( symptom.getOccursOnce() ) continue;
	    if ( age < symptom.getMinAge() ) continue;
	    if ( symptom.getMaxAge() < age ) continue;
	    symptomsFiltered.add(sym);
	}
	session.putValue("S1", symptomsFiltered);

	HashSet locations = (gender.equals(LR.male) ?
			    Common.allMaleLocations() :
			    Common.allFemaleLocations());
	HashSet locationsFiltered = new HashSet();
	for (Iterator it = locations.iterator(); it.hasNext();) {
	    String loc = (String) it.next();
	    Location location = Common.getLocation(loc);
	    if ( relevantLocation(location, symptomsFiltered) )
		locationsFiltered.add(loc);
	}
	session.putValue("L1", locationsFiltered);

	session.putValue("diagnosis", "none");
	session.putValue("accessMode", "browser");

	String quickAccount = props.getProperty("quickAccount");
	boolean quicky = (null != quickAccount) && quickAccount.equals("1");
	if ( quicky ) {
	    session.putValue("quicky", "1");
	    session.setMaxInactiveInterval(DV.maxInactiveInterval); // Jrun in millisec ....
	    res.setContentType("text/html"); // create a "redirect" page
	    ServletOutputStream out = res.getOutputStream();
	    out.println("<html>" +
			"<script LANGUAGE=\"JavaScript\">" +
			"location='" + D.servletDiagStart + "';" +
			"</script>" + 
			"</html>");
	    return;
	}
	if ( intakeb ) {
	    session.setMaxInactiveInterval(DV.maxInactiveInterval); // Jrun in millisec ....
	    res.setContentType("text/html"); // create a "redirect" page
	    ServletOutputStream out = res.getOutputStream();
	    out.println("<html>" +
			"<script LANGUAGE=\"JavaScript\">" +
			"location='" + D.servletDiagStart + "';" +
			"</script>" + 
			"</html>");
	    return;
	}

	// start the actor for 'test' for now
	if ( logName.equals("test" ) || 
	     logName.equals("child1" ) 
	     ) {
	    String fileName = logName + "Actor";
	    Actor actor = Actor.getActor(fileName);
	    // if (null == actor) actor = new Actor(fileName);
	    session.putValue("actor", actor);
	    actor.setSession(session);
	    actor.start();
	}

	if ( gender.equals(LR.male) ) {
	  session.setMaxInactiveInterval(DV.maxInactiveInterval); // Jrun in millisec ....
	  // AngelRoot.call(res);
	  res.setContentType("text/html"); // create a "redirect" page
	  ServletOutputStream out = res.getOutputStream();
	  out.println("<html>" +
		      "<script LANGUAGE=\"JavaScript\">" +
		      "location='" + D.AngelRootHtml + "';" +
		      "</script>" + 
		      "</html>");
	  return;
	}
	// Do the female checks
	CheckStatus.call(res, session);
    }

      static public void adjustGender(DB props) {
	  // make sure that the gender stored correspond with the language used
	  String gender = props.getProperty("gender");
	  if ( L.language.equals("US") ) {
	      if ( gender.equals("male") || gender.equals("female") ) return;
	      if ( gender.equals("mannelijk") ) {
		  props.putProperty("gender", "male");
		  try { props.save("adjustGender"); }
		  catch (IOException ignore) {}
		  return;
	      }
	      if ( gender.equals("vrouwelijk") ) {
		  props.putProperty("gender", "female");
		  try { props.save("adjustGender"); }
		  catch (IOException ignore) {}
		  return;
	      }
	      return; // is not supposed to be executed ...
	  }
	  if ( L.language.equals("NL") ) {
	      if ( gender.equals("mannelijk") || gender.equals("vrouwelijk") ) return;
	      if ( gender.equals("male") ) {
		  props.putProperty("gender", "mannelijk");
		  try { props.save("adjustGender"); }
		  catch (IOException ignore) {}
		  return;
	      }
	      if ( gender.equals("female") ) {
		  props.putProperty("gender", "vrouwelijk");
		  try { props.save("adjustGender"); }
		  catch (IOException ignore) {}
		  return;
	      }
	      return; // is not supposed to be executed ...
	  }
	  // other languages here

      } // end of adjustGender(DB props)

      static public int calcAge(Properties props) {
	// calculate age, which is absurdly laborious ....
	String year = props.getProperty("year");
	String monthNum = props.getProperty("monthNum");
	String day = props.getProperty("day");
	int yeari = 1900;
	int monthi = 0;
	int dayi = 1;
	try { 
	  yeari = Integer.parseInt(year);
	  monthi = Integer.parseInt(monthNum);
	  dayi = Integer.parseInt(day);
	} catch (Exception ignore) {}
	Date now = new Date();
	Calendar cal = Calendar.getInstance();
	cal.setTime(now);
	int yearNow = cal.get(Calendar.YEAR);
	int age = yearNow - yeari;
	if ( 0 < age ) { // subtract one?
	  cal.set(Calendar.YEAR, yearNow);
	  cal.set(Calendar.MONTH, monthi);
	  cal.set(Calendar.DAY_OF_MONTH, dayi);
	  Date birthday = cal.getTime();
	  if ( now.before(birthday) ) age--;
	}
	return age;
      }

    static private boolean relevantLocation(Location location, HashSet symptomsFiltered) {
	Vector vec = location.getAllSymptoms();
	int lng = vec.size();
	for ( int i = 0; i < lng; i++ )
	    if ( symptomsFiltered.contains(vec.elementAt(i)) ) return true;
	if ( !(location instanceof LocationSet) ) return false;
	return relevantLocation((LocationSet)location, symptomsFiltered);
    }
    static boolean relevantLocation(LocationSet location, HashSet symptomsFiltered) {
	Vector vec = location.getMembers();
	int lng = vec.size();
	String locStr;
	Location loc;
	for ( int i = 0; i < lng; i++ ) {
	    locStr = (String) vec.elementAt(i);
	    loc = Common.getLocation(locStr);
	    if ( relevantLocation(loc, symptomsFiltered) )
		return true;
	}
	vec = location.getSubsets();
	lng = vec.size();
	for ( int i = 0; i < lng; i++ ) {
	    locStr = (String) vec.elementAt(i);
	    loc = Common.getLocation(locStr);
	    if ( relevantLocation(loc, symptomsFiltered) )
		return true;
	}
	return false;
    }


} // end AngelLogin


class RemoveUser implements HttpSessionBindingListener {

    protected String logName = null;
    
    public RemoveUser(String logName) {
	this.logName = logName;
    }

    public void valueBound(HttpSessionBindingEvent event) {}

    public void valueUnbound(HttpSessionBindingEvent event) {
	AngelLogin.logoutUser(logName);
    }
}


class LoadTables implements Runnable {
    private Thread loader;
    LoadTables() {
	loader = new Thread(this);
	loader.start();
    }
    public void run() {
         // to force these in ...
         Common.loadTheLocations();
         Common.loadTheSymptoms();
         Common.loadTheDiseases();
	 // others here ...
	 Common.loadTheBodySystems();
	 // DiagStart waits on: Common.getTheBodySystemsLoaded()
    }
}

class CheckLogger implements Runnable {
    private Thread checker;
    private Vector logger;
    private int size = 0;
    private final String site = D.site;
    private final int interval = 24 * 60 * 60 * 1000; // once a day
    CheckLogger() {
	checker = new Thread(this);
	checker.start();
    }
    public void run() {
	while (true) {
	    logger = Common.getLogger();
	    int lng = logger.size();
	    if ( 0 == lng ) 
		size = lng;
	    else
	    if ( size != lng ) {
		size = lng;
		try { SendEmail.sendEmailFunc(
			 D.sendEmailAddress,
			 null, // no from address
			 "Logger has new entry", // subject
			 "Site = " + site + " logger size = " + lng,
			 null); }
		catch (Exception ignore) {}
	    }
	    try {
		Thread.sleep(interval);
	    } catch (InterruptedException ignore) {}
	}
    }
}






