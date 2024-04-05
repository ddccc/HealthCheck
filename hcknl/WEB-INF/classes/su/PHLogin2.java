// (C) OntoOO Inc 2016 May
package su;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


//import com.Common;
import com.DV;
import com.DVM;
import com.D;
// import misc.DB;
// import misc.PeriodLoginPH;
// import misc.HCError;
// import htmls.SetupPHAccount;
// import patient.AngelLogin;


public class PHLogin2 extends HttpServlet {
    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {       
	String logName = req.getParameter("logName");
	call(res, logName);
    }

    static public void call(HttpServletResponse res, String logName) 
	throws IOException {

	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	phPage(out, logName);

    } // end call

    static public void phPage(ServletOutputStream out, String logName) 
    	throws IOException {
	out.println(phPageTop());
	Vector sessions = SUtil.getPHsessions(logName);
	int lng = sessions.size();
	if ( 0 < lng ) out.println(phPageSessions(lng, sessions));
	out.println(phAssessPatient());
	out.println("</body></html>");
    } // end phPage

    static public String phPageTop() {
	StringBuffer sb = new StringBuffer();
	sb.append("<html>");
	sb.append("<head><title>Patient Accounts Management</title>" +
		  D.linkGreyStyle + " \n" +
		  D.favicon + "</head> \n");
	sb.append("<body bgcolor=\"bbbbbb\">");
	sb.append(DVM.htmlLogoutPH("Patient Accounts Management"));
	sb.append(
  "<br /><a href=\"" + D.servletSUCreateAccount + "?type=anonymous\">Create User Account</a>\n " +
  " | <a href=\"" + D.servletSUDeleteAnAccount + "?type=user\">Delete User Account</a>\n " +
  " | <a href=\"" + D.servletSUShowAnAccount + "?type=user\">Show User Accounts</a>\n " +
  " | <a href=\"" + D.servletSUShowUserAccounts + "\">Show Detail User Accounts</a>\n " +
  " | <a href=\"" + D.servletSUShowChronoAccounts + "\">Show Chrono Ordered User Accounts</a>\n " +
  "<hr>\n " +
  "<br /><a href=\"" + D.servletSUShowLoggedinUsers + "\">Show Logged in Users</a>\n " +
  "<hr />\n " 
  );
	return sb.toString();
    } // end phPageTop

    static public String phPageSessions(int lng, Vector sessions) {
	StringBuffer sb = new StringBuffer();
	sb.append("<center>");
	sb.append("<h3>Patients with new sessions:</h3>");
	sb.append("<table border=\"1\">\n");
	for (int i = 0; i < lng; i++) {
	    String patient = (String) sessions.elementAt(i);
	    Date dat = SUtil.getSessionDate(patient);
	    sb.append("<tr>" +
		      "<td>" + dat.toString() + "</td>" +
		      "<td><a href=\"" + D.servletShowUserAccount + 
		      "?account=" + patient + "\"> Show " + patient + "</a></td>" +
		      "<td><a href=\"" + D.servletSURemoveSession + 
		      "?account=" + patient + "\"> Remove " + patient + "</a></td></tr>\n");
	}
	sb.append("</table>\n");
	sb.append("</center>\n");
	sb.append("<hr />\n");
	return sb.toString();
    } // end phPageSessions

    static public String phAssessPatient() {
	StringBuffer sb = new StringBuffer();
	sb.append("<h3>Assess Patient:</h3>\n");
	sb.append(
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
// "  location = '" + D.servletSUAssessPatient + "?userName='+val2; \n" +
"}" +
"</script>\n"
		  );
	sb.append(
"<form action=\"" + D.servletSUAssessPatient + "\">\n" +
"   Name: <input type=\"text\" size=\"10\" maxlength=\"10\" name=\"userName\" /> \n" +
"   <p> \n" +
"<input type=\"button\" value=\"Submit\" onClick=\"checkFields(this.form)\" /> \n" +
"</form>"
		  );
	
	return sb.toString();
    } // end phAssessPatient


} // end PHLogin2
