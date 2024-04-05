// (C) OntoOO Inc 2005 Aug
package patient;

import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.util.*; 

import com.Common;
import com.D;
import com.DV;
import com.DVM;
import misc.SessionExpired;
import misc.DiagStackEntry;
import com.L;
import concepts.Symptom;

public class ElaborateSymptomsQ extends HttpServlet { 
   public void doGet (HttpServletRequest req, 
                      HttpServletResponse res) 
       throws ServletException, IOException { 

       HttpSession session = req.getSession(false);
       if ( null == session ) {
	  SessionExpired.call(res,
			      DV.ElaborateSymptomsQ);
	  return;
       }
       call(res, session); 
} 
 
    static public void call(HttpServletResponse res, HttpSession session) 
	throws IOException { 
    
	String iter = (String) session.getValue("iter");
	int iteration = 0;
	try { iteration = Integer.parseInt(iter); } 
	catch(NumberFormatException ignore) {}  
	Vector diagStack = (Vector) session.getValue("diagStack");
	DiagStackEntry dse = (DiagStackEntry) diagStack.elementAt(iteration);
	Vector selectedSymptoms = (Vector) dse.getSelectedSymptoms();
	int lng = selectedSymptoms.size();

	// Ask for details of the selected symptoms
	
	res.setContentType("text/html"); 
	ServletOutputStream out = res.getOutputStream(); 

	out.println("<html>");
	out.println("<head><title>" + L.ElaborateSymptoms + "</title>" +
		    D.linkHckStyle +
		    D.favicon +
		    "</head>");
	out.println("<body>" +
		    "<font color=\"#850a0a\">");

	out.println(DVM.htmlLogoutUser(L.ElaborateSymptoms));

	out.println("<form name=\"elaborateForm\" action=\"" + D.servletElaborateSymptoms + "\">");

	if ( 0 < lng ) { // check there are symptoms to be elaborated
	    // Please provide details on these symptoms:
	    out.println("<br /><font size=\"4\">" +
			L.provideDetails +
			"</font> ");

	    out.println("<p><center><table border=\"1\">");
	    out.println("<tr><td><b>" + L.Symptoms + "</b></td>" +
			"<td><b>" + L.Duration + "</b></td>" +
			"<td><b>" + L.Change + "</b></td>" + 
			"</tr>");

	    for ( int i = 0; i < lng; i++ ) {
		String symptomName = (String) selectedSymptoms.elementAt(i);
		Symptom symptom = Common.getSymptom(symptomName);
		String symptomPrintName = symptom.getPrintName();
		out.println("<tr><td><b>" + symptomPrintName + "<b></td>" +
			    "<td>" + duration(symptomName) + "</td> \n" + 
			    "<td>" + change(symptomName) + "</td>" + 
			    "</tr>");
	    }
	    out.println("</table></center>");
	}

	// ++++++++++++++++ add freeform
	out.println("<br /><font size=\"4\">" +
		    L.AdditionalComments +
		    "</font> ");
	out.println("<p><center>" +
		    "<textarea cols=\"75\" rows=\"15\" name=\"messageBody\"> </textarea>" +
		    "</center>");

	out.println("<p><font size=\"4\">" +
		    // "Please check your data before submitting!" +
		    L.Diag1bS13 +
		    "</font> ");
	out.println("<input type=\"submit\" value=\"Submit\" /> ");

	out.println("</form>");

	// localhost:8000 === healthcareProvider:80 or so
	out.println(DV.SCRIPTCC);
       
	out.println("</font></body>");
	out.println("</html>");
    }

    static private String duration(String symptomName) {
	return 
	    "<select name=\"" + symptomName + "Duration\">" +
	    "<option value=\"anHour\">" + L.anHour + "</option> \n" +
	    "<option value=\"aFewHours\">" + L.aFewHours + "</option> \n" +
	    "<option value=\"aDay\" selected=\"selected\">" + L.aDay + "</option> \n" +
	    "<option value=\"severalDays\">" + L.severalDays + "</option> \n" +
	    "<option value=\"aWeek\">" + L.aWeek + "</option> \n" +
	    "<option value=\"severalWeeks\">" + L.severalWeeks + "</option> \n" +
	    "<option value=\"quiteAWhile\">" + L.quiteAWhile + "</option> \n" +
	    "</select>";
    }
    static private String change(String symptomName) {
	return 
	    "<select name=\"" + symptomName + "Change\">" +
	    "<option value=\"noChange\" selected=\"selected\">" + L.noChange + "</option> \n" +
	    "<option value=\"getsWorse\">" + L.getsWorse + "</option> \n" +
	    "<option value=\"getsLess\">" + L.getsLess +"</option> \n" +
	    "</select>";
    }
} // end ElaborateSymptomsQ

