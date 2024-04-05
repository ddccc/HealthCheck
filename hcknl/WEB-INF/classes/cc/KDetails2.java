// (C) OntoOO Inc 2002
package cc;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import patient.KClient;
import com.Common;
import com.LR;
import com.DV;
import com.D;
import misc.DB;
import misc.DiagStackEntry;
import misc.PeriodLogin0;
import misc.ShowUserAccount;
import concepts.Symptom;
import patient.Diag2;
import patient.History;


public class KDetails2 extends HttpServlet {
  static final private String refreshInterval = "30"; // seconds
  public void doGet (HttpServletRequest req, 
		     HttpServletResponse res)
       throws ServletException, IOException
  {
    String clientId = req.getParameter("clientId");
    String delete = req.getParameter("delete");
    call(res, clientId, delete);
  }

    static public void call(HttpServletResponse res, String clientId, 
			    String delete)
	throws IOException {
    HttpSession session = KClient.getKClient(clientId);

    StringBuffer sb = null;

    res.setContentType("text/html");
    // res.setHeader("Refresh", refreshInterval);
    ServletOutputStream out = res.getOutputStream();
    out.println(
       "<html><body bgcolor=\"lightblue\">");
    try {

	/* This will show all name-value pairs in session:
	   sb = new StringBuffer();
	   String [] valueNames = session.getValueNames();
	   int lng2 = valueNames.length;
	   out.println("<br>ValueNames: ");
	   for (int i = 0; i<lng2; i++) {
	      String vn = valueNames[i];
	      Object obj = session.getValue(vn);
	      sb.append("<br><b>" + vn + ":</b> " + obj.toString());
	   }
	   out.println(sb.toString());
	*/

      Float tsFloat = (Float) session.getValue("tsFloat");
      float temperature = ( null == tsFloat ? 0.0f : tsFloat.floatValue() );
      Integer ageInt = (Integer) session.getValue("ageInt");
      int age = ageInt.intValue();
      DB props = (DB) session.getValue("theDB");
      String userName = props.getProperty("userName");
      if ( null == userName ) userName = (String) session.getValue("logName");
      out.println("<H1>Details for " + userName + "</H1>");

      String sendCCAdvice = (String) session.getValue("sendCCAdvice");
      if ( null != sendCCAdvice ) 
	  out.println("<font color=\"#FF0000\" SIZE=\"4\">" +
		      "<i><b>Actor Alert: " + sendCCAdvice + "</b></i>" +
		      "</font> <p>" );


      // contains: Diag1b.popupDisplayDrug
      ShowUserAccount.userAccountHeader(props, out);
      

      int lng;

      // See whether there is a diagnostic session
      DiagStackEntry dse = null;
      Vector diagStack = (Vector) session.getValue("diagStack");
      int iteration = 0;
      if ( null != diagStack && 0 < diagStack.size() ) {
	String iter = (String) session.getValue("iter");
	if ( null != iter && !iter.equals("") ) {
	  try { iteration = Integer.parseInt(iter); } 
	  catch(NumberFormatException ignore) {}
	  if ( 0 <= iteration && iteration < diagStack.size() ) {
	    dse = (DiagStackEntry) diagStack.elementAt(iteration);
	  }
	}
      }
      if ( null != dse ) {
	sb = new StringBuffer("<p><table border=\"1\">");
	sb.append("<tr><th colspan=\"2\"><b>Session Info</b></th></tr>");

	if ( 0.0f == temperature ) 
	  sb.append("<tr><td><b>Temperature:</b></td><td>not set");
	else
	  sb.append("<tr><td><b>Temperature:</b></td><td>" + temperature);

	sb.append("</td></tr><tr><td><b>Duration:</b></td><td>" +
		  ((String)session.getValue("duration")));

	sb.append("</td></tr><tr><td><b>Body Part:</b></td><td>" +
		  dse.getBodyPart());
	sb.append("</td></tr><tr><td><b>System:</b></td><td>" +
		  dse.getSystem());
	Vector newInSymptomsVec = dse.getNewInSymptomsVec();
	if ( null != newInSymptomsVec ) 
	  sb.append("</td></tr><tr><td><b>newInSymptoms:</b></td><td>" +
		    newInSymptomsVec.toString());
	String alertMessages = (String) session.getValue("alertMessages");
	if ( null != alertMessages )
	    sb.append("</td></tr><tr><td><b>alertMessages:</b></td><td>" +
		    alertMessages);
	// other stuff here
	sb.append("</td></tr>");

	/*
	// ***** temp
	sb.append("</table>");
	out.println(sb.toString());
	sb = new StringBuffer("<p><table border=\"1\">");
	sb.append("<tr><th colspan=2><b>Selected Symptom Info</b></th></tr>");
	*/

	String symptomName = null;
	Symptom sym;
	String printName = null;
	String description = null;
	int anchor = 0;
      
	// show selected symptoms, if any
	// Vector selectedSymptoms = (Vector) session.getValue("selectedSymptoms");
	Vector selectedSymptoms = dse.getSelectedSymptoms();
	if ( null != selectedSymptoms ) {
	  sb.append("<tr><td><b>selected symptoms:</b></td><td>");
	  lng = selectedSymptoms.size();
	  for (int i = 0; i < lng; i++) {
	    symptomName = (String) selectedSymptoms.elementAt(i);
	    sym = Common.getSymptom(symptomName);
	    if ( null == sym ) {
		sb.append("*** Obsolete symptom: " + symptomName + " ");
	    } else {
		printName = sym.getPrintName();
		description = sym.getDescription();
		anchor = 1000+i;
		sb.append(
			  "<a href=\"#" + anchor + 
			  "\" name=\"" + anchor + "\" onClick=\"alert('" +
			  description + "')\"><i>" +
			  printName + "</i></a> " );
	    }
	  }
	  sb.append("</td></tr>");
	}
	/*
	// ***** temp
	sb.append("</table>");
	out.println(sb.toString());
	sb = new StringBuffer("<p><table border=\"1\">");
	sb.append("<tr><th colspan=2><b>Not Selected Symptom Info</b></th></tr>");
	*/

	// show not selected symptoms, if any
	// Vector notSelectedSymptoms = (Vector) session.getValue("notSelectedSymptoms");
	HashSet notSelectedSymptoms = dse.getNotSelectedSymptoms();
	if ( null != notSelectedSymptoms ) {
	  sb.append("<tr><td><b>not selected symptoms:</b></td><td>");
	  // lng = notSelectedSymptoms.size();
	  // for (int i = 0; i < lng; i++) {
	  int i = 0;
	  for (Iterator it = notSelectedSymptoms.iterator(); it.hasNext();) {
	    symptomName = (String) it.next();
	    sym = Common.getSymptom(symptomName);
	    if ( null == sym ) {
		sb.append("*** Obsolete symptom: " + symptomName + " ");
	    } else {
		printName = sym.getPrintName();
		description = sym.getDescription();
		anchor = 1000+i;
		sb.append(
			  "<a href=\"#" + anchor + 
			  "\" NAME=\"" + anchor + "\" onClick=\"alert('" +
			  description + "')\"><i>" +
			  printName + "</i></a> " );
		i++;
	    }
	  }
	  out.println("</td></tr>");
	}
	sb.append("</table>");
	out.println(sb.toString());

	// show diseases, if any
	// Vector diseases = (Vector) session.getValue("diseases");
	Vector diseases = dse.getDiseases(); // ie DiseaseInst
	if ( 0 < diseases.size() ) 
	  Diag2.displayDiseases(out, diseases, clientId, true, iteration);
      }

      // show previous log sessions of this client
      PeriodLogin0 pl = (PeriodLogin0) session.getValue("periodLogin");
      String histVecName = pl.getHistVecName();
      Vector logSessions = Common.getLogSessions(histVecName);


      // stuff from logSessions
      lng = logSessions.size();
      if (0 < lng) {
	// in case we must deal with DiseaseInstHist:
	History.scriptDiseaseInstHist(out, histVecName);
	// in case we must deal with showAccount
	out.println(DV.scriptShowAccount);

	sb = new StringBuffer("<p><table border=\"1\">");
	History.processLogSessions(sb, logSessions, false);
	sb.append("</table>");
	out.println(sb.toString());
      }
      
    } catch (Exception ex) {
      if ( null != sb ) {
	sb.append("</table></center>");
	out.println(sb.toString());
      }
      out.println("<h3><i><b>Something weird happened ... </b></i></h3>");
      out.println("Exception: " + ex.toString());
      out.println("<pre>");
      PrintStream ps = new PrintStream(out);
      ex.printStackTrace(ps);
      out.println("</pre>");
    }

    // if ( delete.equals("yes") ) out.println( DV.htmlDismiss );
    Date now = new Date();
    out.println( 
       (delete.equals("yes") ? 
	"<p><form><input type=\"button\" value=\"Dismiss\" onClick=\"parent.close()\"> " :
	"<p><form>") +
       "<input type=\"button\" value=\"Refresh\" onClick=" +
         "'location=\"" + D.servletKDetails2 + "?clientId=" + clientId + "&delete=" + delete + 
         "&random=" + now.getTime() +
          "\"'> </form>");

    out.println("</body></html>");
  }


}



