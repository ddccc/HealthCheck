// (C) OntoOO Inc 2000
package cc;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import com.DV;
import com.D;
import misc.DB;
import misc.HCError;
import misc.SessionExpired;

public class SetupCC extends HttpServlet {

    public void doPost (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException

    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    SessionExpired.call(res,
				DV.SetupCC);
	    return;
	}
	String logName2 = (String) session.getValue("logName");
	DB props = (DB) session.getValue("theDB");
	String password2 = props.getProperty("password");

	String logName = req.getParameter("logName");
	String password = req.getParameter("password");

	if ( !logName.equals(logName2) || !password.equals(password2) ) {
	    HCError.call(res,
			"User name or password erroneous.<br>" +
			"Use the back arrow to return to the previous page.");
	    return;
	}

	String firstName = req.getParameter("firstName");
	String lastName = req.getParameter("lastName");
	String phone = req.getParameter("phone");

	props.putProperty("firstName",firstName);
	props.putProperty("lastName",lastName);
	props.putProperty("ccName",firstName+"_"+lastName);
	props.putProperty("phone",phone);

	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>Setup</title></head>");
	out.println("<body  bgcolor=\"bbbbbb\">");
	out.println("<h1>Setup</h1>"); 

	try { 
	  props.save("SetupCC");
	} catch (IOException ex) {
	    HCError.call(res,
			"Can't save this info, exception: " + ex.getMessage() +
			"<br />Use the back arrow to return to the previous page.");
	    return;
	}

	//	out.println("<H5>logName: " + logName + "</H5>"); 
	//	out.println("<H5>password: " + password + "</H5>");
	out.println("<b>firstName:</b> " + firstName + "<br />");
	out.println("<b>lastName:</b> " + lastName + "<br />");
	out.println("<b>phone:</b> " + phone + "<br />");

	out.println("<h3Info was saved!!</h3>");
	out.println("<h4><i>Use the Back Key of your browser to relogin ...</i></h4>");

	out.println("</body>"); 
	out.println("</html>"); 
	session.invalidate();
    }
}











