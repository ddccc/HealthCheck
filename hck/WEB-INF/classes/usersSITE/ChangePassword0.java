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
		      "<br>Use the back arrow to return to the previous page.");
	    return;
	}

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println(

"<HTML>" +
"<HEAD><TITLE>Change Password</TITLE></HEAD>" +
"<script LANGUAGE='JavaScript'>" +
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
"<BODY BGCOLOR='khaki'>" +
"<H1 align='center'> <FONT Color='#FF0000' SIZE='7'> Change Your Password </FONT></H1>" +
"<H3>You new password must have:</H3>" +
"<H4>** characters in the ranges: a-z, A-Z and 0-9</H4>" +
"<H4>** have at least one lower case character, one upper case " +
"character and one digit</H4>" +
"<H4>** its length must be at least 8 and at most 10 characters</H4>" + 


"<FORM METHOD=post ACTION='" + D.servletChangePassword + "'>" +
"   Login name: <INPUT TYPE='TEXTAREA' SIZE='10' NAME='logName'>" +
"   Password: <INPUT TYPE='PASSWORD' SIZE='10' NAME='password'>" +
"   New password: <INPUT TYPE='PASSWORD' SIZE='10' NAME='newpassword'>" +
"   New password again: <INPUT TYPE='PASSWORD' SIZE='10' NAME='newpassword2'>" +
"   <p>" +
"<input TYPE='button' VALUE='Submit' onClick='checkFields(this.form)'>" +
"<input TYPE='button' VALUE='Cancel' onClick='history.back()'>" +
"<input TYPE='hidden' NAME='source' VALUE='" + user + "'>" +
"</FORM>" +

"</BODY>" +
"</HTML>");

    }
}




