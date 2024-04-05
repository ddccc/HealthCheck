// (C) OntoOO Inc 2002 Jul
package cc;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.DV;
import com.D;
import misc.DB;
import misc.PeriodLoginCC;
import misc.HCError;
import patient.KClient;
import patient.KClientDigest;
import htmls.SetupCCAccount;


public class CCLogin extends HttpServlet {

  static private Hashtable allCCs = null;
  static public HttpSession getCC(String key) {
    return (HttpSession) allCCs.get(key);
  }
  static public void putCC(String key, HttpSession session) {
    allCCs.put(key, session);
  }
  static public void removeCC(String key) {
    allCCs.remove(key);
  }
  static public Enumeration allCCKeys() {
    return allCCs.keys();
  }  
  static public Enumeration allCCSessions() {
    return allCCs.elements();
  }

    public void init(ServletConfig config) throws ServletException {
         super.init(config);
	 allCCs = new Hashtable();
	 // to start up the digest thread ...
	 synchronized(KClient.synchroObject) {
	     // this will start the digest 
	     if ( null == KClient.allKClients ) {
		 KClient.allKClients = new Hashtable();
		 KClient.kClientDigest = new KClientDigest();
		 KClient.kClientDigest.start();
	     }
	 }
    }
    

    public void doPost (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      // res.setContentType("text/html");
	
	String logName = req.getParameter("logName");
	String password = req.getParameter("password");

	if ((logName == null) || 
	    (password == null) ||
	    logName.equals("") || 
	    password.equals("")
		) {
	  HCError.call(res,
			"Log name and password required!<br>" +
			"Use the back arrow to return to the previous page");
	  return;
	}

	// Check user name
	String fileName = "cc" + logName;
	String prefix2 = D.theUsersDir;
	DB props = null;
	try {
	  props = new DB(prefix2 + fileName);
	} catch (IOException ignore) {}
	if ( null == props ) {
	  HCError.call(res, 
		    "Account not found.<br>" +
		    "Use the back arrow to return to the previous page.");
	  return;
	}

	// Check password
	if ( !password.equals(props.getProperty("password")) ) {
	  HCError.call(res,
			"User name - password combination not acceptable.<br>" +
			"Use the back arrow to return to the previous page.");
	  return;
	}

	HttpSession session = req.getSession(true);
	session.putValue("logName", logName);
	session.putValue("theDB", props);

	String lastName = props.getProperty("lastName");
	if ( null == lastName ) {
	  SetupCCAccount.call(res);
	  return;
	}

	session.putValue("fileName", fileName);
	session.putValue("lastName", lastName);
	session.putValue("ccName", props.getProperty("ccName"));
	session.setMaxInactiveInterval(DV.maxInactiveInterval); // Jrun in millisec ....

	// this will add to session (see PeriodLogin):
	//    session.putValue("unboundHashtable", unboundHashtable);
	String sessionId = session.getId();
	session.putValue("periodLoginCC", 
			 new PeriodLoginCC(fileName, 
					   "unboundHashtable",
					   sessionId));
	putCC(sessionId, session);
	
	// res.sendRedirect(D.servletKCallPerson);
	// KCallPerson.call(res, session); // cannot refresh a post !!
        res.setContentType("text/html"); // create a "redirect" page
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<script language='JavaScript'> \n" +
		    "location='" + D.servletKCallPerson + "'; \n" +
		    "</script>");
	out.println("</html>");
    }
}











