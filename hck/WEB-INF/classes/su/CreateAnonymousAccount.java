// (C) OntoOO Inc 2002 May
package su;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.D;

public class CreateAnonymousAccount extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String type = "anonymous";

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println(

"<html>" +
"<head><title>Create Anonymous Account</title></head> \n" +

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
"  val2 = form.userName0.value; \n" +
"  val3 = trim(val2); \n" +
"  if ( val2 != val3 ) { val2 = val3; form.userName0.value = val2; } \n" +
"  if ( val2.length <= 0) { \n" +
"     alert(\"Please provide a user name ...\"); return; }; \n" +
"  if ( 8 < val2.length ) { \n" +
"     alert(\"max length = 8 ...\"); return; }; \n" +
"  if ( 0 <= isDigit(val2.charAt(0) ) ) { \n" +
"     alert(\"1st char cannot be a digit ...\"); return; }; \n" +
"  out = isLowercaseOrDigitString(val2); \n" +
"  if ( 1 != out ) { \n" +
"     alert(\"lower case or digits in user name ...\"); return; }; \n" +
"  form.userName.value = val2; \n" +
"  form.submit(); \n" +
"}" +
"</script>\n" + 

"<body bgcolor=\"bbbbbb\">\n" +
"<h1 align=\"center\"> <font color=\"#FF0000\" size=\"7\"> Enter new " + type +
   " name </font></h1>\n" +

"<h3>Your account name must have:</h3>" +
"<h4>** characters in the ranges: a-z and 0-9</h4>" +
"<h4>** cannot start with a digit</h4>" +
"<h4>** its length must be less than 9 characters</h4>" + 

"<form action=\"" + D.servletSUCA2 + "\">\n" +
"   Name: <input type=\"text\" size=\"8\" maxlength=\"8\" name=\"userName0\">\n" +
"   <p>\n" +
"<input type=\"button\" value=\"Submit\" onClick=\"checkFields(this.form)\">\n" +
"<input type=\"button\" value=\"Cancel/Back\" onClick=\"history.back()\">\n" +
"<input type=\"hidden\" name =\"userName\" value=\"\">\n" +
"<input type=\"hidden\" name =\"type\" value=\"" + type + "\">\n" +
"</form>" +

"</body>" +
"</html>");

    }
}




