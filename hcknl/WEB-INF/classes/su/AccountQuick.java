// (C) OntoOO Inc 2007 March
package su;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import patient.AngelLogin;
import patient.Setup2;
import misc.HCError;
import com.D;
import com.Common;
import com.L;


public class AccountQuick extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
	super.init(config);
	AngelLogin.initAngelLogin();
    }
    // Called when the system terminates (ako finalize()-function)
    // Should be a no-op because all changes to the counters have been saved already
    public void destroy() { 
	AngelLogin.setAndSaveHALogging("AccountQuick.destroy");
    }

    public void doPost (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	// Check whether this user is logged in already
	HttpSession session = req.getSession(false);
	if ( null != session ) {
	    String logName = (String) session.getValue("logName");
	    session.invalidate();
	    AngelLogin.logoutUser(logName);
	}

	
	String gender = req.getParameter("gender");
	String year = req.getParameter("year");
	String month = req.getParameter("month");
	String day = req.getParameter("day");

	if (
	    (year == null) ||
	    (month == null) ||
	    (day == null) ||
	    year.equals("") || 
	    month.equals("") || 
	    day.equals("")
		) {
	    HCError.call(res,
			 "The date of birth is not recognized!<br>" +
			 "Use the back arrow to return to the previous page.");
	    return;
	}
	String monthNum = month.substring(3);
	month = month.substring(0,3);

	String userName = null;
	int cnt = 0;
	while ( true ) {
	    int postfix = AngelLogin.incrementAndFetchQuickCnt();
	    userName = "QA" + postfix + "qa";
	    boolean outb = SUtil.addUUaccount(userName);
	    if ( outb ) { 
		// AngelLogin.setAndSaveHALogging("AccountQuick");
		break;
	    }
	    // One can be here only when the system has been initialized with 
	    // many quick-accounts and the file su.healthAngelLogging has
	    // not been initialized with proper values as well
	    cnt++;
	    if ( 100 < cnt ) { // give up
		HCError.call(res,
		      "The System is not able to create a Quick Account<br>" +
		      "Please notify us of this error<br>" +
		      "Use the back arrow to return to a page with a Feedback link.");
		return;
	    }
	    AngelLogin.setQuickCnt(2*postfix);
	}
	Properties props2 = new Properties();
	props2.put("password", userName); 
	props2.put("fileName", userName); 
	props2.put("anonymous", "1");
	Date now = new Date();
	props2.put("accountCreationDate", "" + now.getTime());
	props2.put("gender",gender); 
	props2.put("year",year); 
	props2.put("month",month);
	props2.put("monthNum",monthNum); // for age calculation
	props2.put("day",day); 
	props2.put("dob",year+"-"+month+"-"+day); 
	props2.put("quickAccount", "1");

	String prefix2 = D.theUsersDir;
	try { 
	    FileOutputStream fos = 
		new FileOutputStream(prefix2 + userName);
	    props2.store(fos, "AccountQuick");
	    fos.close();
	}
	catch (IOException ex) {
	      SUtil.deleteUUaccount(userName);
	      HCError.call(res,
		      "Can't create quick account, exception: " + ex.getMessage() + "<br>" +
		      "Please notify us of this error<br>" +
		      "Use the back arrow to return to the previous page.");
	      return;
	}
	
	// Now add the 2nd File
	Vector historyOfDiseases = new Vector();
	Hashtable ht = new Hashtable();
	ht.put("historyOfDiseases", historyOfDiseases);
	Vector logSessions = new Vector();
	logSessions.addElement(ht);
	Common.saveLogSessions(userName, logSessions);

	/* The next test is language independent because the gender descriptions are
	   still in English -- see also patient.Setup2 */
	if ( gender.equals("male") ) { 
	    AngelLogin.call(req, res, userName, userName);
	    return;
	} 
	// do the woman stuff here before going to AngelLogin
	// The code here is adapted from Setup2
	// generate questions specific for woman
	int age = AngelLogin.calcAge(props2);
	String guessedStatusCondition = 
	  ( age < 13 ? "premenstruating" :
	    ( age < 47 ? "menstruating" :
	      ( age < 52 ? "menopause" : "postmenopause" ) ) );

        res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html><head><title>" + 
		    // "Obtain Woman Specific History" +
		    L.Setup2S1 +
		    "</title>" +
		    "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + D.hckStyle + "\" />" +
		    "</head>");
	// javascript here
	out.println(
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

"function isDigitString (inString) { \n" +
"   if (0==inString.length) return (false); \n" +
"   for (count=0; count<inString.length; count++) { \n" +
"      tempChar = inString.charAt(count); \n" +
"      if (-1 == isDigit(tempChar)) return (false); \n" +
"   } \n" +
"   return (true); \n" +
"} \n" +

"function checkFields(form) { \n" +
"  val2 = form.numLifeBirths.value; \n" +
"  val3 = trim(val2); \n" +
"  if ( val2 != val3 ) { val2 = val3; form.numLifeBirths.value = val2; } \n" +
"  out = isDigitString(val2); \n" +
"  if ( 1 != out ) { alert(\"Enter or fix # life births ...\"); return; }; \n" +
"  val2 = form.numMiscarriages.value; \n" +
"  val3 = trim(val2); \n" +
"  if ( val2 != val3 ) { val2 = val3; form.numMiscarriages.value = val2; } \n" +
"  out = isDigitString(val2); \n" +
"  if ( 1 != out ) { alert(\"Enter or fix # miscarriages ...\"); return; }; \n" +
"  val2 = form.numStillBirths.value; \n" +
"  val3 = trim(val2); \n" +
"  if ( val2 != val3 ) { val2 = val3; form.numStillBirths.value = val2; } \n" +
"  out = isDigitString(val2); \n" +
"  if ( 1 != out ) { alert(\"Enter or fix # stillbirths ...\"); return; }; \n" +
"  form.submit(); \n" +
"} \n" +
"</script>"
        );

	out.println("<body>" +
		    "<font color=\"#850a0a\">");

	out.println(
	    "<h1 align=\"center\"><font color=\"#FF0000\" size=\"4\">" +
	    // "OK, Here Woman Specific Questions" +
	    L.Setup2S2 +
	    "</font></h1>\n" +
	    "<form method=\"post\" action=\"" + D.servletSetupWoman + "\">\n");
	out.println(
	    "<table border=\"1\">" +
	    "<tr><th colspan=\"2\">" +
	    // "Based on your age the program has guessed " +
	    // "that you are in the life phase of: " +
	    L.Setup2S3 +
	    " " + guessedStatusCondition +
	    "<br />" +
	    // "Please correct if necessary:" +
	    L.Setup2S4 +
	    "</th></tr>");

	out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"premenstruating\" " +
  ( guessedStatusCondition.equals("premenstruating") ? "checked=\"checked\"" : "") +
  " /></td><td>" + 
  // "premenstruating: you have never menstruated and " +
  // "according to your age you are not supposed to" +
  L.Setup2S5 +
  "</td></tr>");

	out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"menstruating\" " +
  ( guessedStatusCondition.equals("menstruating") ? "checked=\"checked\"" : "") +
  " /></td><td>" +
  // "menstruating: (you are not pregnant) and you have had at least once " +
  // "a menstruation or you should have had one given your age" +
  L.Setup2S6 +
  "</td></tr>");

	out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"pregnant\" " +
  ( guessedStatusCondition.equals("pregnant") ? "checked=\"checked\"" : "") +
  " /></td><td>" +
  // "pregnant: date of last menstruation:" +
  L.Setup2S7 + 
  " ");

	writeLastMenstruationDate(out);
	out.println("</td></tr>");

	out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"menopause\" " +
  ( guessedStatusCondition.equals("menopause") ? "checked=\"checked\"" : "") +
  " /></td><td>" + 
  // "menopause: your menstruations have become irregular as " +
  // "expected with your age" +
  L.Setup2S8 +
  "</td></tr>");

	out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"postmenopause\" " +
  ( guessedStatusCondition.equals("postmenopause") ? "checked=\"checked\"" : "") +
  " /></td><td>" +
  // "postmenopause: your menstruations has ceased as " +
  // "expected with your age" +
  L.Setup2S9 +
  "</td></tr></table>");

	out.println(
  "<table border=\"1\">" +
  "<tr><td>" +
  // "# life births:" +
  L.Setup2S10 +
  "</td><td>" +
  "<input type=\"text\" name=\"numLifeBirths\" value=\"0\" size=\"2\" /></td></tr>");

	out.println(
  "<tr><td>" +
  // "# miscarriages:" +
  L.Setup2S11 +
  "</td><td>" +
  "<input type=\"text\" name=\"numMiscarriages\" value=\"0\" size=\"2\" /></td></tr>");

	out.println(
  "<tr><td>" + 
  // "# stillbirths:" +
  L.Setup2S12 +
  "</td><td>" +
  "<input type=\"text\" name=\"numStillBirths\" value=\"0\" size=\"2\" /></td></tr></table>");

	out.println(
  "<hr />" + 
  // "Please check your data before submitting!" +
  L.Diag1bS13 +
  " <input type=\"button\" value=\"Submit\" onClick=\"checkFields(this.form)\" />\n " +
  " <input type=\"hidden\" name=\"userName\" value=\"" + userName + "\" /> \n " +
  "</form></font></body></html>");

    } // end doPost

  static public void writeLastMenstruationDate(ServletOutputStream out) 
      throws IOException { 
      Setup2.writeLastMenstruationDate(out); 
  }

}




