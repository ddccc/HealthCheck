// (C) OntoOO Inc 2003 Mar
package patient;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.DV;
import com.D;
import com.L;
import misc.DiagStackEntry;
import concepts.Symptom;
import misc.SessionExpired;

public class ShowInputs extends HttpServlet {

  private static final boolean expert = DV.expert;
  private static final boolean TRACING = DV.TRACINGdiag2;
    //private static final boolean TRACING = true;


    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
       throws ServletException, IOException {

      String trace = "";
      boolean startedPage = false;
      ServletOutputStream out = null;

try {
      HttpSession session = req.getSession(false);
      if ( null == session ) {	
	  SessionExpired.call(res,
			      DV.Diag2);
	  return;
      }
      /*
      DB props = (DB) session.getValue("theDB");
      String statusCondition = props.getProperty("statusCondition");

      Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");
      Integer ageInt = (Integer) session.getValue("ageInt");
      int age = ageInt.intValue();
      */

      Vector diagStack = (Vector) session.getValue("diagStack");
      String iter = req.getParameter("iteration");
      int iteration = 0;
      try { iteration = Integer.parseInt(iter); } 
      catch(NumberFormatException ignore) {}  

      res.setContentType("text/html");
      out = res.getOutputStream();

      out.println("<html><head><title>" + L.ShowInputs + "</title>" +
		  D.favicon +
		  "</head>" +
		  "<body bgcolor=\"yellow\">");
      int i2 = iteration - 1;
      out.println("<font color=\"#FF0000\" size=\"4\"><b>" +
		  // "Show Inputs/ Iteration:" + 
		  L.ShowInputsS1 +
		  " " + i2 +
		  "</b></font>");
      for (int i = iteration; 1 <= i; i--) {
	  i2 = i - 1;
	  out.println("<p><b>" + 
		      // "Inputs at iteration:" +
		      L.ShowInputsS2 +
		      "</b> " + i2);
	  DiagStackEntry dse = (DiagStackEntry) diagStack.elementAt(i);
	  /*
	  Vector newInSymptoms = dse.getNewInSymptomsVec();
	  if ( null != newInSymptoms && 0 < newInSymptoms.size() )
	      out.println("<br> newInSymptoms: " + newInSymptoms.toString());
	  Vector newAllSymptoms = dse.getNewAllSymptomsVec();
	  if ( null != newAllSymptoms && 0 < newAllSymptoms.size() )
	      out.println("<br> newAllSymptoms: " + newAllSymptoms.toString());
	  Vector locations = dse.getLocations();
	  if ( null != locations && 0 < locations.size() )
	      out.println("<br> locations: " + locations.toString());
	  Vector systems = dse.getSystems();
	  if ( null != systems && 0 < systems.size() )
	      out.println("<br> systems: " + systems.toString());
	  */
	  String bodyPart = dse.getBodyPart();
	  out.println("<br /><b>" + L.BodyLocation + "</b> " + bodyPart);
	  String system = dse.getSystem();
	  out.println("<br /><b>" + L.BodySystem + "</b> " + system);
	  Vector selectedSymptoms = (Vector) dse.getSelectedSymptoms();
	  String symName;
	  Symptom sym;
	  int lng;
	  if ( null != selectedSymptoms ) {
	      lng = selectedSymptoms.size();
	      if ( 0 < lng ) {
		  out.println("<br /><b>Selected Symptoms: (" + 
			      lng + ")</b> ");
		  for (int j = 0; j < lng; j++) {
		      symName = (String) selectedSymptoms.elementAt(j);
		      sym = Common.getSymptom(symName);
		      out.println(sym.getDescription() + ( j == lng-1 ? "" : ", "));
		  }
	      }
	  }
	  HashSet notSelectedSymptoms = (HashSet) dse.getNotSelectedSymptoms();
	  if ( null != notSelectedSymptoms ) {
	      lng = notSelectedSymptoms.size();
	      if ( 0 < lng ) {
		  out.println("<br /><b>Not Selected Symptoms: (" + 
			      lng + ")</b> ");
		  int j = 0;
		  for ( Iterator it = notSelectedSymptoms.iterator(); it.hasNext(); ) {
		      symName = (String) it.next();
		      sym = Common.getSymptom(symName);
		      out.println(sym.getDescription() + ( j == lng-1 ? "" : ", "));
		      j++;
		  }
	      }
	  }
      }

      out.println("<p><b>" + 
		  // "Suggestion:" + 
		  L.Suggestion + 
		  "</b> " +
		  // "To change a choice at a previous iteration use " +
		  // "the browser back and correct your choice."
		  L.ShowInputsS3 );
      out.println(DV.htmlDismiss);
      out.println("</body></html>");

} catch (Exception ex) {
           ServletOutputStream outx = null;
           if ( !startedPage ) {
	     res.setContentType("text/html");
	     outx = res.getOutputStream();
	     outx.println("<html>");
	     outx.println("<head><title>Diag2 Exception</title></head>");
	     outx.println("<body bgcolor=\"red\">");
	     outx.println("<b>Trace:</b> " + trace);
           } else 
	     outx = out;

	   outx.println("<br /><b>Exception:</b> " + ex.toString());
	   outx.println("<pre>");
	   PrintStream ps = new PrintStream(outx);
	   ex.printStackTrace(ps);
	   outx.println("</pre>");
	   outx.println("</body>");
	   outx.println("</html>");
	   return;
} // end of catch and try block

    }

}

