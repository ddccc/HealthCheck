// (C) OntoOO Inc 2003
package patient;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.DV;
import com.D;
import com.L;
import com.DVM;
import misc.DB;
import misc.SessionExpired;


public class GetBMIInput extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {


	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    SessionExpired.call(res,
				DV.GetBMIInput);
	    return;
	}

	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html><head><title>" +
		    // "Get Body Mass Index Input" + 
		    L.GetBMIInputS1 +
		    "</title>" +
		    D.linkHckStyle +
		    D.favicon +
		    "</head>" +
		    "<body>" +
		    "<font color=\"#850a0a\">");

	out.println(
"<script language=\"JavaScript\"> \n" +
"function checkField (form) { \n" +
"       TestVar = isNumberString(form.myWeight.value); \n" +
"	if (TestVar == false) { alert('Weight should be a number!'); return; } \n" +
"       TestVar = isNumberString(form.myHeight.value); \n" +
"	if (TestVar == false) { alert('Height should be a number!'); return; } \n" +
"       form.submit(); \n" +
"} \n" +
"function isNumberString (InString) { \n" +
"   if (InString.length==0) return (false); \n" +
"   var RefString='1234567890'; \n" +
"   for (Count=0; Count<InString.length; Count++) { \n" +
"      TempChar = InString.charAt(Count); \n" +
"      if (-1 == RefString.indexOf(TempChar)) return (false); \n" +
"   } \n" +
"   return (true); \n" +
"} \n" +
"</script>"
);

	DB props = (DB) session.getValue("theDB");
	// Construct the applet input here from the weight info in the DB
	String myWeight = props.getMostRecent("weight");
	String height = props.getProperty("height");
	if ( null == myWeight || null == height ) {
	  out.println("<h3>" + 
		      // "No weight and/or height data available" +
		      L.GetBMIInputS2 +
		      "</h3>");
	  out.println(DV.htmlBack);

	  // the standard trailer
	  // localhost:8000 === healthcareProvider:80 or so
	  out.println(DV.SCRIPTCC);

	  out.println("</font></body>");
	  out.println("</html>");
	  return;
	}

	// intro text here
	out.println(DVM.htmlLogoutUser(
				       // "Calculate Body Mass Index"
				       L.GetBMIInputS3 ));
	out.println("<h3>" + 
		    // "Click submit or modify the weight and/or height fields first" +
		    L.GetBMIInputS4 +
		    "</h3>");

	out.println("<form name=\"bmi\" method=\"get\" action=\"" + D.servletCalcBMI + "\">");

	out.println("<table>");
	out.println("<tr><td>" + 
		    // "My weight in lbs is:" +
		    L.GetBMIInputS5 +
		    "</td>" +
		    "<td><input type=\"text\" size=\"5\" name=\"myWeight\" value=\"" + myWeight + "\" /></td>");
	out.println("<td>" +
		    // "Save this value:" +
		    L.GetBMIInputS6 +
		    " <input type=\"checkbox\" name=\"saveWeight\" /></td></tr>");
	out.println("<tr><td>" +
		    // "My height in inches is:" +
		    L.GetBMIInputS7 +
		    "</td>" +
		    "<td><input type=\"text\" size=\"5\" name=\"myHeight\" value=\"" + height + "\" /></td>");
	out.println("<td>" +
		    // "Save this value:" +
		    L.GetBMIInputS6 +
		    " <input type=\"checkbox\" name=\"saveHeight\" /></td></tr>");
	out.println("</table>");
	out.println("<br><hr>");

	out.println("<input type=\"button\" value=\"Submit\" onClick=\"checkField(this.form)\" />");
	out.println("</form>");
	out.println("<script language=\"JavaScript\"> document.forms['bmi'].myWeight.focus(); </script>");


	out.println(DV.htmlBack);

	// the standard trailer
	// localhost:8000 === healthcareProvider:80 or so
	out.println(DV.SCRIPTCC);

	out.println("</font></body>");
	out.println("</html>");
    }
}





