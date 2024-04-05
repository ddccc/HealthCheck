// (C) OntoOO Inc 2002 May
package su;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.DV;
import com.D;
import misc.DB;
import misc.HCError;
import patient.AngelLogin;


public class SUCA2 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String userName = req.getParameter("userName");
      if ( null == userName ) {
	  HCError.call(res,
		      "User name is missing ..." +
		      "<br>Use the back arrow to return to the previous page.");
	  return;
      }

      // check it
      int lng = userName.length();
      if ( lng <= 0 || 10 < lng )  {
	  HCError.call(res,
		      "User name length unacceptable ..." +
		      "<br>Use the back arrow to return to the previous page.");
	  return;
      }

      // type = CcType321456 | user | anonymous | PhType321456
      String type = req.getParameter("type");
      if ( null == type ) {
	  HCError.call(res,
		      "Account type not recognized ..." +
		      "<br />Use the back arrow to return to the previous page.");
	  return;
      }
      if ( type.equals("CcType321456") ) type = "cc";
      else 
      if ( type.equals("PhType321456") ) type = "ph";
      if ( !type.equals("cc") && 
	   !type.equals("user") && 
	   !type.equals("anonymous") &&
	   !type.equals("ph")
	   ) {
	  HCError.call(res,
		      "Account type not recognized ..." +
		      "<br />Use the back arrow to return to the previous page.");
	  return;
      }

      char c;
      c = userName.charAt(0);
      if ( Character.isDigit(c) ) {
	  HCError.call(res, 
			"User name cannot start with a digit.<br />" +
			"Use the back arrow to return to the previous page.");
	  return;
      }

      for (int i = 0; i < lng; i++) {
	c = userName.charAt(i);
	if ( c == ' ' ) { 
	  HCError.call(res, 
			"No space allowed in the user name.<br />" +
			"Use the back arrow to return to the previous page.");
	    return;
	}
	if ( Character.isDigit(c) ) continue;
	if ( Character.isLowerCase(c) ) continue; 
	// if ( Character.isUpperCase(c) ) continue;
	HCError.call(res,
		      "Character(s) in the userName should be digit or lowercase letter.<br />" +
		      "Use the back arrow to return to the previous page.");
	return;
      }
      call(req, res, userName, type, false);
    }

    static public void call(HttpServletRequest req,
			    HttpServletResponse res,
			    String userName, String type, boolean intake) 
	throws IOException {
	/* modify SUCA2 so that intake = 1 leads
	 to stop the session and immediate transfer to AngelLogin
	*/
	// if true = intake sets " props.put("intake", "1"); "
	// invalidate session and go to AngelLogin


      boolean anonymous = false;
      if ( type.equals("anonymous") ) {
	  anonymous = true;
	  type = "user";
      }

      boolean outb =
	( type.equals("user") ?
	  SUtil.addUUaccount(userName) :
	  ( type.equals("cc") ?
	    SUtil.addCCaccount(userName) :
	    ( type.equals("ph") ?
	      SUtil.addPHaccount(userName) :
	      false ) ) );
      if ( !outb ) {
	  HCError.call(res,
		      "UserName exists already ...<br />" +
		      "Use the back arrow to return to the previous page.");
	  return;
      }

      boolean phDefinedUser = false;
      String phLogName = "";
      HttpSession session = req.getSession(false);
      if ( null != session && null != session.getValue("phName") ) {
	  phDefinedUser = true;
	  phLogName = (String) session.getValue("logName");
	  outb = SUtil.addPHaccount(phLogName, userName);
	  if ( !outb ) { // can NOT happen, but just in case clean up first
	      SUtil.deleteUUaccount(userName);
	      HCError.call(res,
		      "UserName " + userName + " could NOT be added ...<br />" +
		      "Use the back arrow to return to the previous page.");
	      return;
	  }
      }
      
      // make the account
      Properties props2 = new Properties();
      props2.put("password", userName); 
      props2.put("fileName", userName); 
      if ( anonymous ) props2.put("anonymous", "1");
      if ( phDefinedUser ) props2.put("myPhysician", phLogName);
      if ( intake )  props2.put("intake", "1");
      Date now = new Date();
      props2.put("accountCreationDate", "" + now.getTime());
      
      String prefix2 = D.theUsersDir;
      try { 
	FileOutputStream fos = 
	  new FileOutputStream(prefix2 + 
			       ( type.equals("cc") ? "cc" : 
				 ( type.equals("ph") ? "ph" : "") ) 
			       + userName);
	props2.store(fos, "SUCA2");
	fos.close();
      }
      catch (IOException ex) {
	  if ( type.equals("user") ) 
	      SUtil.deleteUUaccount(userName);
	  else
	  if ( type.equals("cc") ) 
	      SUtil.deleteCCaccount(userName);
	  else
	      SUtil.deletePHaccount(userName);
	  if ( phDefinedUser ) SUtil.deletePHaccount(phLogName, userName);
	  HCError.call(res,
		      "Can't create new account, exception: " + ex.getMessage() +
		      "<br />Use the back arrow to return to the previous page.");
	  return;
      }
      if ( intake ) {
	  if ( null != session ) session.invalidate();
	  AngelLogin.call(req, res, userName, userName);
	  return;
      }

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>Account Created</title></head>");
      out.println("<body bgcolor=\"bbbbbb\">");
      out.println("<h1>Account created with:</h1>" +
		  "<table><tr>" +
		  "<td><font size=\"5\">User name:</font></td>" + 
		  "<td><font size=\"5\">" + userName + "</font></td></tr>" + 
		  "<td><font size=\"5\">Password:</font></td>" + 
		  "<td><font size=\"5\">" + userName + "</font></td></tr>" + 
		  "</table>");
      out.println("<h2>You <i>MUST</i> change your password as soon as possible because " +
		  "accounts where the user name is the same as the password " +
		  "can be deleted at any time!</h2>");

      if ( type.equals("user") && !phDefinedUser ) {
	  if ( anonymous ) {
	      out.println(
		"<h2>Your account must still be setup, which will take a minute or two.<br />" +
		"If you proceed with the setup you must complete it, otherwise your account may " +
		"not work and you have to create another one.<br />" +
		"Why the setup? The system uses - among others - your gender and age to generate " +
		"its conjectures.<br />" +
		"How to do the setup? Just click the YES button and you are presented with " +
		"3-4 screens dependent on your gender.  Subsequently you login.</h2><br />");
	      out.println(
		"<form method=\"post\" action=\"" + D.servletAngelLogin + "\"> \n" +
		"<input type=\"submit\" value=\"Yes, will do it now\" /> \n" + 
		"<input type=\"hidden\" name=\"logName\" value=\"" + userName + "\" /> \n" +
		"<input type=\"hidden\" name=\"password\" value=\"" + userName + "\" /> \n" +
		"<input type=\"button\" value=\"No, will do it later\" " + 
		"onClick=\"location='" + D.indexHtml + "'\" /> \n" +
		"</form>");
	  } 
      }

      out.println(DV.htmlBack);

      out.println("</body>");
      out.println("</html>");
    }
} // end SUCA2




