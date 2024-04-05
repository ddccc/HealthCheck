// (C) OntoOO Inc 2005 Jul
package su;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.DV;
import com.DVM;
import com.D;
import misc.DB;
import misc.PeriodLoginPH;
import misc.HCError;
import htmls.SetupPHAccount;
import patient.AngelLogin;


public class PHLogin extends HttpServlet {

  static private Hashtable allPHs = null;
  static public HttpSession getPH(String key) {
    return (HttpSession) allPHs.get(key);
  }
  static public void putPH(String key, HttpSession session) {
    allPHs.put(key, session);
  }
  static public void removePH(String key) {
    allPHs.remove(key);
  }
  static public Enumeration allPHKeys() {
    return allPHs.keys();
  }  
  static public Enumeration allPHSessions() {
    return allPHs.elements();
  }


    static public String getPHemailAddress(String logName) {
	String fileName = "ph" + logName;
	String prefix2 = D.theUsersDir;
	DB props = null;
	try {
	  props = new DB(prefix2 + fileName);
	} catch (IOException ignore) { return null; }
	return props.getProperty("email");
    }

    public void init(ServletConfig config) throws ServletException {
         super.init(config);
	 allPHs = new Hashtable();
	 AngelLogin.initAngelLogin();
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
	String fileName = "ph" + logName;
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
	if ( !session.isNew() ) {
	    HCError.call(res,
		"You are already logged into the HealthCheck system; " +
		"as a physician, as a patient, as a call center user or ... " +
		"Logout first in your other role.<br> "  +
		"A patient login can be killed by trying a relogin " +
		"and following the instructions.<br> " +
		"Other logins will terminate due to inactivity within 30 minutes."
			 );
	    return;
	}

	session.putValue("logName", logName);
	session.putValue("theDB", props);

	String lastName = props.getProperty("lastName");
	if ( null == lastName ) {
	  SetupPHAccount.call(res);
	  return;
	}

	session.putValue("fileName", fileName);
	session.putValue("lastName", lastName);
	session.putValue("phName", props.getProperty("phName"));
	// session.setMaxInactiveInterval(DV.maxInactiveInterval); // Jrun in millisec ....

	// this will add to session (see PeriodLogin):
	//    session.putValue("unboundHashtable", unboundHashtable);
	String sessionId = session.getId();
	session.putValue("periodLoginPH", 
			 new PeriodLoginPH(fileName, 
					   "unboundHashtable",
					   sessionId));
	putPH(sessionId, session);
	
	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	// redirect 
	out.println("<html>");
	out.println("<script language='JavaScript'> \n" +
		    "location='" + D.servletPHLogin2 + 
		    "?logName=" + logName + "'; \n" +
		    "</script>");
	out.println("</html>");

    } // end doPost

} // end PHLogin











