// (C) OntoOO Inc 2002 Jul
package phone;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.DV;
import com.D;
import com.LR;
import com.L;
import misc.DB;
import misc.PeriodLogin;
import patient.AngelLogin;
import patient.KClient;
import patient.KClientDigest;
import concepts.Location;
import patient.CheckStatus;

public class PhoneLogin extends HttpServlet implements Runnable {

    static private Thread loader;

    public void init(ServletConfig config) throws ServletException {
      super.init(config);
      // the aim is to load hash tables in the background ...
      loader = new Thread(this);
      loader.start();
      synchronized(KClient.synchroObject) {
	  if ( null == KClient.allKClients ) {
	      // this will start the digest 
	      KClient.allKClients = new Hashtable();
	      KClient.kClientDigest = new KClientDigest();
	      KClient.kClientDigest.start();
	  }
      }
      synchronized(AngelLogin.synchroObject) { AngelLogin.startLogging(); }
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

    public void doPost (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      // res.setContentType("text/html");
	String host = req.getParameter("myhost");
	if ( null == host || host.equals("dutch") ) host = "bevocal";
	
	String logName = req.getParameter("logName");
	if ((logName == null) || 
	    logName.equals("")
		) {
	    PhoneError.call(res, host, 
			    // "Log name and password required!"
			    L.AngelLoginS1
			    );
	    return;
	}

	if ( logName.equals("123") ) logName = "test"; else
        if ( logName.equals("321") ) logName = "phonetest"; else
	if ( logName.equals("327") ) logName = "xxaa7"; 
	if ( logName.equals("320") ) logName = "xxaa20"; 
	if ( logName.equals("325") ) logName = "xxaa25"; // pregnant
	if ( logName.equals("350") ) logName = "xxaa50"; 
	if ( logName.equals("360") ) logName = "xxaa60"; 
	String password = logName; // for testing

	synchronized ( AngelLogin.loggedInUsers ) {
	  if ( AngelLogin.loggedInUsers.containsKey(logName) ) {
	    PhoneError.call(res, host, 
			    // "Can't login twice!"
			    L.AngelLoginS3 
			    );
	    return;
	  }
	  AngelLogin.addUser(logName, logName);
	}
	
	// String password = req.getParameter("password");

	if ((password == null) ||
	    password.equals("")
		) {
	  AngelLogin.logoutUser(logName);
	  PhoneError.call(res, host, 
			  // "Log name and password required!");
			  L.AngelLoginS1
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
	    AngelLogin.logoutUser(logName);
	    PhoneError.call(res, host, 
			    // "User name - password combination not acceptable.");
			    L.AngelLoginS5
			    );
	    return;
	}
	// Check password
	if ( !password.equals(props.getProperty("password")) ) {
	    AngelLogin.logoutUser(logName);
	    PhoneError.call(res, host, 
			    // "User name - password combination not acceptable.");
			    L.AngelLoginS5
			    );
	    return;
	}

	HttpSession session = req.getSession(true);
	if ( !session.isNew() ) {
	    session.invalidate();
	    AngelLogin.logoutUser(logName);
	    PhoneError.call(res, host, 
			    // "An unexpected session was invalidated.  Try to call in again.");
			    L.PhoneLoginS1
			    );
	    return;
	}
	
	session.putValue("logName", logName);
	session.putValue("theDB", props);
	AngelLogin.addUser(logName, session);

	/* Eliminate for now
	Vector logSessions = Common.getLogSessions(logName);
	if ( 0 == logSessions.size() ) { // need still to set up account
	    // to delete logName from loggedInUsers when the session invalidates/ timeout:
	    session.putValue("removeUser", new RemoveUser(logName));
	    session.setMaxInactiveInterval(10 * DV.maxInactiveInterval); // 10 minutes
	    if ( logName.startsWith("xx") ) 
		res.sendRedirect(D.StartAnonymousHtml);
	    else
		res.sendRedirect(D.SetupAccountHtml);
	    return;
	}
	*/

	AngelLogin.incrementLoginCnt();

	String sessionId = session.getId();
	// this will add to session (see PeriodLogin):
	//    session.putValue("unboundHashtable", unboundHashtable);
	session.putValue("periodLogin", 
			 new PeriodPhone(logName, 
					 "unboundHashtable",
					 sessionId));

	AngelLogin.adjustGender(props);
	String gender = props.getProperty("gender");
	session.putValue("gender", gender);

	// S1 and D1 are gender specific HashSet collections
	// allMaleSymptoms() and allFemaleSymptoms() both yield also gender neutral symptoms
	// same for allMaleDiseases() and allFemaleDiseases()
	session.putValue("S1", 
			 (gender.equals(LR.male) ?
			  Common.allMaleSymptoms() :
			  Common.allFemaleSymptoms()));
	session.putValue("D1", 
			 (gender.equals(LR.male) ?
			  Common.allMaleDiseases() :
			  Common.allFemaleDiseases()));

	int age = AngelLogin.calcAge(props);
	Integer ageInt = new Integer(age);
	session.putValue("ageInt", ageInt);

	session.putValue("diagnosis", "none");
	session.putValue("accessMode", "phone");

	// add this user to the digest following KClient
	//session.putValue("counter", counter);
	Integer pageCnt, surfCnt;
	Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");

	// init this session 
	session.putValue("state", "phone start");
	/*
	// preparation to store a chatRecord - if any - in logSessions
	...
	*/

	session.putValue("page", "phone.PhoneLogin");
	pageCnt = new Integer(1);
	session.putValue("pageCnt", pageCnt);
	unboundHashtable.put("pageCnt", pageCnt);
	surfCnt = new Integer(0);
	session.putValue("surfCnt", surfCnt);
	unboundHashtable.put("surfCnt", surfCnt);
	// finally add this client
	KClient.putKClient(sessionId, session);

	// prepare for AskLocation
	session.putValue("host", host); // bevocal | voxeo
	session.putValue("bodyPart", LR.bodySt);
	
	session.setMaxInactiveInterval(5 * DV.maxInactiveInterval); // 5 minutes

	if ( gender.equals(LR.male) ) {
	    // Save this stuff and redirect to AngelRoot ...
	    // session.setMaxInactiveInterval(DV.maxInactiveInterval); // Jrun in millisec ....
	    // res.sendRedirect(D.AngelRootHtml);
	    // res.sendRedirect(D.servletAskPart);
            // PhoneWait.call(res, session, "0");
	    // AskMoreSymptoms.call(req, res, session, "chills");
	    AskLocation.call(res, session);
	    return;
	}
	PhoneCheckStatus.call(res, session);
    }


}







