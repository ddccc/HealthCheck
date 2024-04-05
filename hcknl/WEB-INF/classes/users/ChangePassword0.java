// (C) Copyright OntoOO Inc, 2002 July
package users;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.D;
import users.HCError;

public class ChangePassword0 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	
	String user = req.getParameter("user");
	if ( null == user ) {
	    HCError.call(res, 
		      "Account type not recognized ..." +
		      "<br>Use the back arrow to return to the previous page.");
	    return;
	}
	if ( !user.equals("cc") && 
	     !user.equals("user") && 
	     !user.equals("su") &&
	     !user.equals("ph") 
	     ) {
	    HCError.call(res, 
		      "Account type not recognized ..." +
		      "<br />Use the back arrow to return to the previous page.");
	    return;
	}

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println(

"<html>" +
"<head><TITLE>Change Password</TITLE></head>" +
"<script language=\"JavaScript\">" +
"function checkFields(form) {" +
"	if ( ('' != form.logName.value) &&" + 
"	     ('' != form.password.value) &&" +
"	     ('' != form.newpassword.value) && " +
"	     ('' != form.newpassword2.value) )" +
"		form.submit();" +
"	else" +
"		alert('Enter values in all fields ...');" +
"}" +
"</script>" + 
"<body bgcolor=\"" + D.bgcolor + "\">" +
"<h1 align=\"center\"> <font color=\"#FF0000\" size=\"7\"> Change Your Password </font></h1>" +
"<h3>You new password must have:</h3>" +
"<h4>** characters in the ranges: a-z, A-Z and 0-9</h4>" +
"<h4>** have at least one lower case character, one upper case " +
"character and one digit</h4>" +
"<h4>** its length must be at least 8 and at most 10 characters</h4>" + 


"<form method=\"post\" action=\"" + D.servletChangePassword + "\">" +
"   Login name: <input type=\"text\" maxlength=\"10\" size=\"10\" name=\"logName\" />" +
"   Password: <input type=\"password\" maxlength=\"10\" size=\"10\" name=\"password\" />" +
"   New password: <input type=\"password\" maxlength=\"10\" size=\"10\" name=\"newpassword\" />" +
"   New password again: <input type=\"password\" maxlength=\"10\" size=\"10\" name=\"newpassword2\" />" +
"   <p>" +
"<input type=\"button\" value=\"Submit\" onClick=\"checkFields(this.form)\" />" +
"<input type=\"button\" value=\"Cancel\" onClick=\"history.back()\" />" +
"<input type=\"hidden\" name=\"source\" value=\"" + user + "\" />" +
"</form>" +

"</body>" +
"</html>");

    }
}




