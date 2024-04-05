// (C) OntoOO Inc 2002 May
package patient;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import com.DV;
import com.D;
import com.L;
import com.LR;
import misc.DB;
import misc.HCError;
import misc.SessionExpired;
import htmls.Start3;

public class Setup2 extends HttpServlet {

    public void doPost (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException

    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    SessionExpired.call(res,
				DV.Setup);
	    return;
	}
	DB props = (DB) session.getValue("theDB");

	String maritalStatus = req.getParameter("maritalStatus");
	String smoking = req.getParameter("smoking");
	String alcohol = req.getParameter("alcohol");
	String exercising = req.getParameter("exercising");
	String [] stress = req.getParameterValues("stress");
	// store in DB 
	props.putProperty("maritalStatus", maritalStatus);
	props.putProperty("smoking", smoking);
	props.putProperty("alcohol", alcohol);
	props.putProperty("exercising", exercising);
	if ( null != stress && 0 < stress.length ) {
	  String stresses = "";
	  for ( int i = 0; i < stress.length; i++ ) 
	    stresses = stresses + stress[i] +
	      ( i == stress.length -1 ? "" : "," );
	  props.putProperty("stress", stresses);
	}
	// the statusCondition will be changed for female
	props.putProperty("statusCondition", "none"); 

	try { 
	  props.save("Setup2");
	} catch (IOException ex) {
	    HCError.call(res,
			"Can't save this info, exception: " + ex.getMessage() +
			"<br>Use the back arrow to return to the previous page.");
	    return;
	}

	// proceed with the next set of questions ...
	String gender = props.getProperty("gender");
	/* The next test is language independent because the gender generators
	   (Start, StartAnonymous AngelQuick produce English descriptions) 
	   See also su.AccountQuick.
	*/
	if ( gender.equals("male") ) {
	  Start3.call(res);
	  return;
	}

	// generate questions specific for woman
	int age = AngelLogin.calcAge(props);
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
	    "<br>" +
	    // "Please correct if necessary:" +
	    L.Setup2S4 +
	    "</th></tr> \n");

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
  "<table border>" +
  "<tr><td>" +
  // "# life births:" +
  L.Setup2S10 +
  "</td><td>" +
  "<input type=\"text\" name=\"numLifeBirths\" value=\"0\" size=\"2\" maxlength=\"2\" /></td></tr>");

	out.println(
  "<tr><td>" +
  // "# miscarriages:" +
  L.Setup2S11 +
  "</td><td>" +
  "<input type=\"text\" name=\"numMiscarriages\" value=\"0\" size=\"2\" maxlength=\"2\" /></td></tr>");

	out.println(
  "<tr><td>" + 
  // "# stillbirths:" +
  L.Setup2S12 +
  "</td><td>" +
  "<input type=\"text\" name=\"numStillBirths\" value=\"0\" size=\"2\" maxlength=\"2\" /></td></tr></table>");

	out.println(
  "<hr>" + 
  // "Please check your data before submitting!" +
  L.Diag1bS13 +
  " <input type=\"button\" value=\"Submit\" onClick=\"checkFields(this.form)\" />\n " +
  "</form></font></body></html>");

    } // end doPost

    static public void writeLastMenstruationDate(ServletOutputStream out)
	throws IOException {
	out.println(monthDaySelector);
    }

    // this stuff can be reused elswhere ...
    static public String monthDaySelector =
             L.Month +
	     " <select name=\"month\">" +
	     "<option value=\"Jan0\" selected=\"selected\"> Jan </option> \n " +
	     "<option value=\"Feb1\"> Feb </option> \n " +
	     "<option value=\"Mar2\"> Mar </option> \n " +
	     "<option value=\"Apr3\"> Apr </option> \n " +
	     "<option value=\"May4\"> May </option> \n " +
	     "<option value=\"Jun5\"> Jun </option> \n " +
	     "<option value=\"Jul6\"> Jul </option> \n " +
	     "<option value=\"Aug7\"> Aug </option> \n " +
	     "<option value=\"Sep8\"> Sep </option> \n " +
	     "<option value=\"Oct9\"> Oct </option> \n " +
	     "<option value=\"Nov10\"> Nov </option> \n " +
	     "<option value=\"Dec11\"> Dec </option> \n " +
	     "</select>\n" + 
             L.Day +
	     " <select name=\"day\"> " +
	     "<option value=\"1\" selected=\"selected\"> 1  </option> \n " +
	     "<option value=\"2\"> 2  </option> \n " +
	     "<option value=\"3\"> 3  </option> \n " +
	     "<option value=\"4\"> 4  </option> \n " +
	     "<option value=\"5\"> 5  </option> \n " +
	     "<option value=\"6\"> 6  </option> \n " +
	     "<option value=\"7\"> 7  </option> \n " +
	     "<option value=\"8\"> 8  </option> \n " +
	     "<option value=\"9\"> 9  </option> \n " +
	     "<option value=\"10\"> 10  </option> \n " +
	     "<option value=\"11\"> 11  </option> \n " +
	     "<option value=\"12\"> 12  </option> \n " +
	     "<option value=\"13\"> 13  </option> \n " +
	     "<option value=\"14\"> 14  </option> \n " +
	     "<option value=\"15\"> 15  </option> \n " +
	     "<option value=\"16\"> 16  </option> \n " +
	     "<option value=\"17\"> 17  </option> \n " +
	     "<option value=\"18\"> 18  </option> \n " +
	     "<option value=\"19\"> 19  </option> \n " +
	     "<option value=\"20\"> 20  </option> \n " +
	     "<option value=\"21\"> 21  </option> \n " +
	     "<option value=\"22\"> 22  </option> \n " +
	     "<option value=\"23\"> 23  </option> \n " +
	     "<option value=\"24\"> 24  </option> \n " +
	     "<option value=\"25\"> 25  </option> \n " +
	     "<option value=\"26\"> 26  </option> \n " +
	     "<option value=\"27\"> 27  </option> \n " +
	     "<option value=\"28\"> 28  </option> \n " +
	     "<option value=\"29\"> 29  </option> \n " +
	     "<option value=\"30\"> 30  </option> \n " +
	     "<option value=\"31\"> 31  </option> \n " +
	     "</select> \n";   // do not remove this new line character !!!
}







