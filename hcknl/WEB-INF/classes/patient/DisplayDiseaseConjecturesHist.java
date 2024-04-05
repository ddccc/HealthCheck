// (C) OntoOO Inc 2002
package patient;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.DV;
import com.D;
import com.L;
import concepts.Disease;
import misc.SessionExpired;

public class DisplayDiseaseConjecturesHist extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      HttpSession session = req.getSession(false);
      if ( null == session ) {
	  SessionExpired.call(res,
			      DV.DisplayDiseaseConjecturesHist);
	  return;
      }
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>" + 
		  // "Disease Conjectures Details" +
		  L.DDCHS1 +
		  "</title>" +
		  // D.linkHckStyle +
		  D.favicon +
		  "</head>");
      out.println("<body bgcolor=\"yellow\">");
      String diseaseList = "Unknown";
      try {

	String logName = req.getParameter("histVecName");
	Vector logSessions = Common.getLogSessions(logName);

	String sessionNumStr = req.getParameter("sessionNumStr");
	int sessionNum = 0;
	try { sessionNum = Integer.parseInt(sessionNumStr);
	} catch (NumberFormatException cantHappen) {}
	Hashtable ht = (Hashtable) logSessions.elementAt(sessionNum);
	String key = req.getParameter("key");
	diseaseList = (String) ht.get(key);
	StringTokenizer st = new StringTokenizer(diseaseList, "|");
	Float tsFloat = (Float) ht.get("tsFloat");
	float temperature = tsFloat.floatValue();
	Vector selectedSymptoms = (Vector) ht.get("selectedSymptoms");
	HashSet notSelectedSymptoms = (HashSet) ht.get("notSelectedSymptoms");
	DiseaseInst di;
	String diseaseName;
	Vector diseases = new Vector();
	while ( st.hasMoreTokens() ) {
	  diseaseName = st.nextToken();
	  di = new DiseaseInst(diseaseName, temperature);
	  di.requalify(selectedSymptoms, notSelectedSymptoms);
	  diseases.addElement(di);
	}
	Collections.sort(diseases);
	String sessionKey = logName+sessionNumStr;
	session.putValue(sessionKey, diseases);

	out.println("<h1>" + 
		    // "Conjectured diseases in session:" + 
		    L.DDCHS2 +
		    " " + sessionNum + "</h1>"); 
	displayDiseaseConjectures(out, diseases, sessionKey); 
	
	
      } catch (Exception ex) { 
	out.println("<h1>Can't display disease conjectures for " + diseaseList + "</h1>");
	out.println(" Exception: " + ex.getMessage());
      }
      out.println(DV.htmlDismiss);
      out.println("</body>");
      out.println("</html>");
    } // end doGet

  private void displayDiseaseConjectures(ServletOutputStream out, 
					 Vector diseases,
					 String sessionKey)
     throws IOException {

      if ( DV.TRACINGdisplayDiseases ) {
       String trace = "<br>*** displayDiseases";
	int lng = diseases.size();
	String dis;
	DiseaseInst di;
	for (int i = 0; i < lng; i++) {
	  di = (DiseaseInst) diseases.elementAt(i); 
	  dis = di.getDisease();
	  trace += "<br /><b>disease #: " + i + ":</b> " + dis + " " + di.getAcceptanceRate();
	}
	out.println(trace);
      }

      DiseaseInst di;
      float acceptanceRate;

      out.println(
"<script language=\"JavaScript\"> \n" +
"function explainConjHist(diseaseNum) {\n " +
"  explainWindowConjHist = open( \n" +
"    \"" + D.servletDisplayDiseaseConjInst + "?diseaseNum=\"+diseaseNum+" +
		                 "\"&sessionKey=\"+\""+sessionKey+"\", \n" +
"    \"explainWindowNameConjHist\", \n" +
"    \"toolbar=1,resizable=1,scrollbars=1,height=300,width=600\" \n" +
"  ); \n" +
"} \n " +
"</script> \n");

	  out.println("<h1 align=\"center\"><font color=\"#FF0000\" size=\"5\">" +
		      // "Conjectured Diseases:" + 
		      L.DDCHS3 +
		      "</font></h1>");
	  out.println("<table border=\"1\">");
	  out.println("<tr><td><b>" +
		      // "Life threatening disease in" +
		      L.Diag2S3 +
		      " <font color=\"#FF0000\">" + L.red + "</font></b></td>" + 
		      "<td>" + L.Support + "</td></tr>");
	  String diseaseName;
	  Disease dis;
	  String description;
	  String printName;
	  int anchor, anchor2;
	  int lng = diseases.size();
	  int accep;
	  boolean lifeThreatening;
	  for ( int i = 0; i < lng; i++ ) {
	    di = (DiseaseInst) diseases.elementAt(i);
	    diseaseName = di.getDisease();
	    lifeThreatening = di.isLifeThreatening();
	    dis = Common.getDisease(diseaseName);
	    printName = dis.getPrintName();
	    acceptanceRate = di.getAcceptanceRate();
	    accep = (int) (acceptanceRate * 100); // chopping details
	    acceptanceRate = (float) (accep * 0.01);
	    anchor = i; anchor2 = i+500;
	    if ( 0 < acceptanceRate ) 
	      out.println("<tr><td>" + 
			  "<a HREF=\"#" + anchor + 
			  "\" NAME=\"" + anchor + "\" onClick=\"explainConjHist('" +
			  i + "')\">" +
			  (lifeThreatening ? "<font color=\"#FF0000\">" : "") +
			  printName + 
			  (lifeThreatening ? "</font>" : "") +
			  "</a></td><td>" + 
			  (lifeThreatening ? "<font color=\"#FF0000\">" : "") +
			  acceptanceRate + 
			  (lifeThreatening ? "</font>" : "") +
			  "</td></tr>");
	  }
	  out.println("</table>");
	  out.println("<font color=\"#FF0000\" size=\"+1\">");
	  out.println("<b>" +
		      // "Warning!! The listed diseases as well as the support levels " +
		      // "are based on the " +
		      L.Diag2S9 +
		      "<i>" + L.limited + "</i> " +
		      // "'knowledge' in this program" +
		      L.Diag2S10 +
		      "</b>");
	  out.println("</font>");

  } // end displayDiseaseConjectures(out, diseases, sessionKey)


}



