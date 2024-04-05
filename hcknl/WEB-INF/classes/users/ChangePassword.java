// (C) Copyright OntoOO Inc, 2002 July
package users;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.DV;
import com.D;
import misc.DB;
import users.HCError;


public class ChangePassword extends HttpServlet {

    public void doPost (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	
	String source = req.getParameter("source");
	if ( null == source ) {
	    HCError.call(res,
		      "Account type not recognized ..." +
		      "<br>Use the back arrow to return to the previous page.");
	    return;
	}
	if ( !source.equals("cc") && 
	     !source.equals("user") && 
	     !source.equals("su") &&
	     !source.equals("ph") 
	     ) {
	    HCError.call(res,
		      "Account type not recognized ..." +
		      "<br>Use the back arrow to return to the previous page.");
	    return;
	}

	String logName = req.getParameter("logName");
	if ( null == logName || logName.length() <= 0 ) {
	    HCError.call(res,
		      "User name not recognized ..." +
		      "<br>Use the back arrow to return to the previous page.");
	    return;
	}

	String password = req.getParameter("password");
	if ( null == password || password.length() <= 0 ) {
	    HCError.call(res,
		      "Password not recognized ..." +
		      "<br>Use the back arrow to return to the previous page.");
	    return;
	}

	String newpassword = req.getParameter("newpassword");
	if ( null == newpassword || newpassword.length() <= 0 ) {
	    HCError.call(res,
		      "New password not recognized ..." +
		      "<br>Use the back arrow to return to the previous page.");
	    return;
	}

	String newpassword2 = req.getParameter("newpassword2");
	if ( null == newpassword2 || newpassword2.length() <= 0 ) {
	    HCError.call(res,
		      "Second new password not recognized ..." +
		      "<br>Use the back arrow to return to the previous page.");
	    return;
	}


	if ( logName.equals("test") ||
	     logName.equals("male") ||
	     logName.equals("female") ) {
	  errorResponse(res,
			"Can NOT change the password for this login name.<br> " +
			"Use the back arrow to return to the previous page.");
	  return;
	}

	// check new password

	if ( !newpassword.equals(newpassword2) ) {
	  errorResponse(res,
			"New passwords do not match.<br> " +
			"Use the back arrow to return to the previous page.");
	  return;
	}

	int lng = newpassword.length();
	if ( lng < 8 || 10 < lng ) {
	  errorResponse(res,
			"Length of the new password not acceptable.<br>" +
			"Use the back arrow to return to the previous page.");
	  return;
	}
	char c;
	int digitCnt = 0;
	int lowerCnt = 0;
	int upperCnt = 0;
	for (int i = 0; i < lng; i++) {
	  c = newpassword.charAt(i);
	  if ( c == ' ' ) { 
	    errorResponse(res,
			  "No space allowed in password.<br>" +
			  "Use the back arrow to return to the previous page.");
	    return;
	  }
	  if ( Character.isDigit(c) ) { digitCnt++; continue; }
	  if ( Character.isLowerCase(c) ) { lowerCnt++; continue; }
	  if ( Character.isUpperCase(c) ) { upperCnt++; continue; }
	  errorResponse(res,
			"Character(s) in the password out of range.<br>" +
			"Use the back arrow to return to the previous page.");
	  return;
	}
	if ( 0 == digitCnt ) {
	  errorResponse(res,
			"Need at least one digit in the new password.<br>" +
			"Use the back arrow to return to the previous page.");
	  return;
	}
	if ( 0 == lowerCnt ) {
	  errorResponse(res,
			"Need at least one lower case character in the new password.<br>" +
			"Use the back arrow to return to the previous page.");
	  return;
	}
	if ( 0 == upperCnt ) {
	  errorResponse(res,
			"Need at least one upper case character in the new password.<br>" +
			"Use the back arrow to return to the previous page.");
	  return;
	}
	// new password is OK


	String fileName = logName;
	// change file name if source != "user" ...
	if ( source.equals("su") ) 
	  fileName = "su" + fileName;
	else
	if ( source.equals("cc") ) 
	  fileName = "cc" + fileName;
	else
	if ( source.equals("ph") ) 
	  fileName = "ph" + fileName;

	// Check user name
	String prefix2 = D.theUsersDir;
	DB props = null;
	try {
	  props = new DB(prefix2+fileName);
	} catch (IOException ignore) {}
	if ( null == props ) {
	  errorResponse(res,
			"User name - password combination not acceptable.<br />" +
			"Use the back arrow to return to the previous page.");
	  return;
	}

	// Check password
	if ( !password.equals(props.getProperty("password")) ) {
	  errorResponse(res,
			"User name - password combination not acceptable.<br />" +
			"Use the back arrow to return to the previous page.");
	  return;
	}

	props.putProperty("password", newpassword);

	try { props.save("ChangePassword"); }
	catch (IOException ex) {
	  errorResponse(res,
			"Can't store new password, exception: " + ex.getMessage() +
			"<br />Use the back arrow to return to the previous page.");
	  return;
	}

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();

      out.println("<html>");
      out.println("<head><title>Password Changed</title></head>");
      out.println("<body bgcolor=\"yellow\">");
      out.println("<h1>Password was changed!!</h1>");
      out.println(DV.htmlBack);
      out.println("</body>");
      out.println("</html>");
    }

    private void errorResponse(HttpServletResponse res, String msg) 
	throws IOException { 
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>Password Change Error</title></head>");
      out.println("<body bgcolor=\"pink\">");
      out.println("<h1>Password was NOT changed!!</h1>");
      out.println("<h3>" + msg + "</h3>");
      out.println(DV.htmlBack);
      out.println("</body>");
      out.println("</html>");
   
    }

}





