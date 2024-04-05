// (C) OntoOO Inc 2002 May
package su;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.DVM;
import com.D;
import misc.HCError;

public class SUCreateAccount extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      HttpSession session = req.getSession(false);
      if ( null == session ) {
	  HCError.call(res, "Session expired/ relogin ...");
	  return;
      }

      String phName = (String) session.getValue("phName");
      boolean phAccess = ( null != phName );

      String type = req.getParameter("type"); // user | cc | ph
      if ( type.equals("cc") ) type = "CcType321456"; // prevent guessing in SUCA2
      else
      if ( type.equals("ph") ) type = "PhType321456"; // prevent guessing in SUCA2

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println(

"<html>" +
"<head><title>Create Account</title>" +
D.favicon + "</head> \n" +

"<script language=\"JavaScript\"> \n" +

"function trim(inString) { \n" +
"  var lng = inString.length;  \n" +
"  if (0 == lng) return inString; \n" +
"  if (\" \" == inString.charAt(0) ) \n" +
"     return trim(inString.substring(1,lng)); \n" +
"  lng--; \n" +
"  if (\" \" == inString.charAt(lng) ) \n" +
"     return trim(inString.substring(0,lng)); \n" +
"  return inString; \n" +
"} \n" +

"function isDigit(aChar) { \n" +
"   var refString=\"1234567890\"; \n" +
"   return refString.indexOf(aChar); \n" +
"} \n" +

"function isLowercase(aChar) { \n" +
"   var refString=\"abcdefghijklmnopqrstuvwxyz\"; \n" +
"   return refString.indexOf(aChar); \n" +
"} \n" +

"function isLowercaseOrDigitString(inString) { \n" +
"   if (0==inString.length) return (false); \n" +
"   for (count=0; count<inString.length; count++) { \n" +
"      tempChar = inString.charAt(count); \n" +
"      if (-1 == isLowercase(tempChar) && \n" +
"          -1 == isDigit(tempChar) && \" \" != tempChar) return (false); \n" +
"   } \n" +
"   return (true); \n" +
"} \n" +

"function checkFields(form) { \n" +
"  val2 = form.userName.value; \n" +
"  val3 = trim(val2); \n" +
"  if ( val2 != val3 ) { val2 = val3; form.userName.value = val2; } \n" +
"  if ( val2.length <= 0) { \n" +
"     alert(\"Please provide a user name ...\"); return; }; \n" +
"  if ( 10 < val2.length ) { \n" +
"     alert(\"max length = 10 ...\"); return; }; \n" +
"  if ( 0 <= isDigit(val2.charAt(0) ) ) { \n" +
"     alert(\"1st char cannot be a digit ...\"); return; }; \n" +
"  out = isLowercaseOrDigitString(val2); \n" +
"  if ( 1 != out ) { \n" +
"     alert(\"lower case or digits in user name ...\"); return; }; \n" +
"  form.submit(); \n" +
"}" +
"</script>\n" + 

"<body bgcolor=\"bbbbbb\">"
);
      if ( phAccess )
	  out.println(DVM.htmlLogoutPH("Enter new " + type + " name"));
      else
	  out.println(DVM.htmlLogoutSU("Enter new " + type + " name"));
      out.println(

"<form action=\"" + D.servletSUCA2 + "\">\n" +
"   Name: <input type=\"text\" size=\"10\" maxlength=\"10\" name=\"userName\" /> \n" +
"   <p> \n" +
"<input type=\"button\" value=\"Submit\" onClick=\"checkFields(this.form)\" /> \n" +
"<input type=\"button\" value=\"Cancel\" onClick=\"history.back()\" />\n" +
"<input type=\"hidden\" name =\"type\" value=\"" + type + "\" /> \n" +
"</form>" +

"</body>" +
"</html>");

    }
} // end SUCreateAccount








