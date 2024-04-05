// Copyright OntoOO Inc, 2002 May
package su;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.DV;
import com.D;
import misc.DB;
import patient.AngelLogin;
import misc.HCError;

public class SUKillSession extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String logName = req.getParameter("logName");
	if ((logName == null) || 
	    logName.equals("")
		) {
	  HCError.call(res,
			"Log name and password required!<br>" +
			"Use the back arrow to return to the previous page.");
	  return;
	}
	Hashtable loggedInUsers = AngelLogin.getLoggedInUsers();
	Object obj = null;
	try { obj = loggedInUsers.get(logName); }
	catch (Exception ignore) {}
	if ( null == obj ) {
	    HCError.call(res,
			 "User not logged in.<br>" +
			 "Use the back arrow to return to the previous page.");
	    return;
	}

	String password = req.getParameter("password");
	if ((password == null) ||
	    password.equals("")
		) {
	  HCError.call(res,
			"Log name and password required!<br>" +
			"Use the back arrow to return to the previous page.");
	  return;
	}
	// Check user name
	String prefix2 = D.theUsersDir;
	DB props = null;
	try {
	  props = new DB(prefix2 + logName);
	} catch (IOException ignore) {}
	if ( null == props ) {
	  HCError.call(res,
			"User name - password combination not acceptable.<br>" +
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

	HttpSession session = null;
	try { session = (HttpSession) obj; }
	catch (Exception ignore) {}
	if ( null == session ) {
	    loggedInUsers.remove(logName);
	    HCError.call(res,
			 "User not logged in.<br>" +
			 "Use the back arrow to return to the previous page.");
	    return;
	}
	try { session.invalidate(); } catch (Exception ignore) {}
	loggedInUsers.remove(logName);

	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>Session Killed</title></head>");
	out.println("<body bgcolor=\"yellow\">");
	out.println("<h1 align=\"center\"><font color=\"#FF0000\" size=\"4\">" +
		    "Session Killed</font></h1>");
	out.println("<h2>The session for user: " + logName + " was killed</h2>");
	out.println(
           "<form>" +
	   "<input type=\"button\" value=\"Proceed to Login\" " +
	   "onClick=\"location='" + D.AngelHtml + "'\" />" +
	   "</form>");
	out.println(DV.htmlBack);
	out.println("</body></html>");
  }
}

