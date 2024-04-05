// (C) OntoOO Inc 2002 May
package su;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import misc.DB;
import misc.HCError;

public class SULogin extends HttpServlet {

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
			 "Log name and password required!<br />" +
			 "Use the back arrow to return to the previous page.");

	    return;
	}

	// Check user name
	String prefix2 = D.theUsersDir;
	DB props = null;
	try {
	  props = new DB(prefix2+"su" + logName);
	} catch (IOException ignore) {}
	if ( null == props ) {
	    HCError.call(res,
		    "Account not found.<br />" +
		    "Use the back arrow to return to the previous page.");
	    return;
	}
	// Check password
	if ( !password.equals(props.getProperty("password")) ) {
	    HCError.call(res,
			"User name - password combination not acceptable.<br />" +
			"Use the back arrow to return to the previous page.");
	    return;
	}

	// Save this stuff and redirect to SURoot ...
	HttpSession session = req.getSession(true);
	session.putValue("theDB", props);
	session.putValue("logName", logName);

	SURoot.call(res);
    }
}




