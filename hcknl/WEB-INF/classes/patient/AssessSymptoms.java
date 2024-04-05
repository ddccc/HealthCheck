// (C) OntoOO Inc 2011 March
package patient;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.DV;
import com.DVM;
import com.D;
import com.L;
import misc.DB;
import concepts.Symptom;
import misc.SessionExpired;



/* Called when there is an intake session and the patient is prompted with a 
   a specific set of candidate symptoms/ a checklist.
*/
public class AssessSymptoms extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
String temperatureInput = 
"<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">" + L.TemperatureF + "</font></td><td> \n" +
"       <select name=\"temperatureSelected\"> \n" +
"           <option value=\">104\"> >104 </option> \n" +
"           <option value=\"104\"> 104 </option> \n" +
"           <option value=\"103\"> 103 </option> \n" +
"           <option value=\"high\"> high </option> \n" +
"           <option value=\"102\"> 102 </option> \n" +
"           <option value=\"101\"> 101 </option> \n" +
"           <option value=\"raised\"> raised </option> \n" +
"           <option value=\"100\"> 100 </option> \n" +
"           <option value=\"normal\" selected=\"selected\"> normal </option> \n" +
"           <option value=\"99\"> 99 </option> \n" +
"           <option value=\"98\"> 98 </option> \n" +
"           <option value=\"lowered\"> lowered </option> \n" +
"           <option value=\"97\"> 97 </option> \n" +
"           <option value=\"96\"> 96 </option> \n" +
"           <option value=\"low\"> low </option> \n" +
"           <option value=\"<96\"> <96 </option> \n" +
"       </select> </td></tr>";

String jcode =
"<script language=\"JavaScript\"> \n" +
"function checkSymptoms(form) { \n" +
"   cnt = 0; \n" +
"   lng = form.newInSymptoms.length; \n" +
"   for (i = 0; i < lng; i++ ) { \n" +
"      val = form.newInSymptoms[i].value; \n" +
"      if ( form.newInSymptoms[i].checked ) { \n" +
"         cnt++; \n" +
"         form.selectedSymptoms.value += (val+'|'); \n" +
"      } \n" +
"      else \n" +
"         form.notSelectedSymptoms.value += (val+'|'); \n" +
"   } \n" +
"   if ( 0 == cnt ) { \n" +
"      alert('" + L.DiagStartS29 + "'); \n" +
"      return; \n" +
"   } \n" +
"   form.submit(); \n" +
"} \n" +
"</script> \n";

      HttpSession session = req.getSession(false);
      if ( null == session ) {	
	  SessionExpired.call(res,
			      DV.AssessSymptoms);
	  return;
      }
      session.removeValue("enteringFrom"); // clean out if the user searches again
      session.putValue("diagnosis", "started");
      session.putValue("searchMode", "unspecified"); // used in Diag1c
      String bodyPart = req.getParameter("bodyPart");
      if ( null == bodyPart ) bodyPart = "unspecified"; // just being defensive here

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();

      out.println("<html><head><title>" + L.SelectSearch + "</title>" + " \n" +
		  D.linkGreyStyle + " \n" +
		  D.favicon + " \n" +
		  "<style type=\"text/css\"> \n" +
		  "  td {font-size:15pt; color:#850a0a} \n" +
		  "</style> \n" +
                  jcode +
		  "</head>");
      // out.println("<body><font color=\"#850a0a\">");
      out.println("<body bgcolor=\"bbbbbb\">");

      out.println(DVM.htmlLogoutUser(// Focussed Search
				     L.SelectSearch ));

      // The symptoms string should be obtained from the patient's physician
      String symptoms =      // this list comes from Bill Seidman
	  "headache,diplopia,ataxia,coordinationDetoriation," +
	  "dysphagia,hearingLoss,tinnitus,paresthesia," +
	  "memoryDetoriation,seizure," +
	  "dyspnea,breathingDifficult,chestPain," + // cardio respiratory: 
	  "abdomenPain,diarrhea,constipation,bowelActivityDecreased," + // GI
	  "sexDriveLow,erectionFailure,dysuria,sleepDisturbed"; // genito urinary: 
      
      String [] misc = { // to be removed ...
	  "focalWeakness", "headInjury", "CVAs", 
	  "heartDisease", "ROS", "PMH", "soiling"
      };

      out.println(
		  "<p> \n" +
		  // "<a name=\"searchFocussed\"> \n" +
		  "<form name=\"focussed\" action=\"" + D.servletDiag1Focussed + "\"> \n" +
		  "<input type=\"hidden\" name=\"bodyPart\" value=\"" + bodyPart + "\" /> \n" +
		  "<input type=\"hidden\" name=\"userInput\" value=\"\" /> \n" + // for Diag1Focussed
		  "<input type=\"hidden\" name=\"selectedSymptoms\" value=\"\" /> \n" +
		  "<input type=\"hidden\" name=\"notSelectedSymptoms\" value=\"\" /> \n" + 
		  // "<table border=\"1\" width=\"100%\">");
		  "<center><table border=\"1\">");
      out.println("<tr><th colspan=\"2\">" +  L.DiagStartS24 + "</th></tr>");

      StringTokenizer st = new StringTokenizer(symptoms, ",");
      while ( st.hasMoreTokens() ){
	  String symp = st.nextToken(); 
	  Symptom sym = Common.getSymptom(symp);
	  if ( null == sym ) {
	      out.println("<tr><td>" + symp + "</td><td>" + "unknown symptom" + "</td></tr>");
	      continue;
	  }
	  String symp2 = sym.getDescription();
	  String sympn = Common.unPolish(symp);
	  out.println("<tr><td>" +
		      "<input type=\"checkbox\" name=\"newInSymptoms\"" +
		      "value=\"" + symp + "\">" +
		      "</td><td>" + 
		      (sympn.equals(symp2) ? sympn : sympn + " / " + symp2) +
		      "</td></tr>");
      }
      out.println("</table><p>");

      // to be removed <<<<
      out.println("<table border=\"1\">" +
      "<tr><th colspan=\"2\">WHAT TO DO WITH:::::::::</th></tr>");
      int lng = misc.length;
      for ( int i = 0; i < lng; i++ ) {
	  String symp = misc[i]; 
	  out.println("<tr><td>" +
		      "<input type=\"checkbox\" name=\"miscs\"" +
		      "value=\"" + symp + "\">" +
		      "</td><td>" + Common.unPolish(symp) +
		      "</td></tr>");
      }
      out.println("</table><p>");
      // to be removed >>>>

      out.println("<table border=\"1\">");
      out.println(temperatureInput);
      out.println("</table></center><p>");

      out.println("<br /><font size=\"4\">" +
		    // "Please check your data before submitting!" +
		    L.Diag1bS13 +
		    "</font> ");
      out.println("<input type=\"button\" value=\"" + L.Submit + "\" " +
		  "onClick=\"checkSymptoms(this.form)\" />");
      out.println("</form>");


      out.println(DV.htmlBack);
      out.println(DV.SCRIPTCC);
      out.println("</font></body>");
      out.println("</html>");
    } // end doGet
} // end AssessSymptoms
