// (C) OntoOO Inc 2002
package patient;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URLEncoder;
import com.DV;
import misc.DiagStackEntry;

public class Diag1 extends HttpServlet {
  private static final boolean LOGGING = DV.LOGGINGdiag1;

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      if ( LOGGING ) {
	System.out.println("*** Diag1: Enter");
      }
      HttpSession session = req.getSession(false);
      if ( null == session ) {
	res.sendRedirect("/hck/servlet/misc.SessionExpired?m=" + DV.Diag1);
	return;
      }

      Hashtable unboundHashtable = 
           (Hashtable) session.getValue("unboundHashtable");

      String [] newInSymptomsArr = req.getParameterValues("symptoms");
      String newAllSymptoms = req.getParameter("allSymptoms");
      String previousBodyPart = "unspecified";
      String previousSystem = "unspecified";

      String ts = req.getParameter("temperatureSelected");
      if ( ts.equals("normal") ) ts = "99.3"; else
      if ( ts.equals("raised") ) ts = "101"; else
      if ( ts.equals("lowered") ) ts = "97"; else
      if ( ts.equals("high") ) ts = "103"; else
      if ( ts.equals("low") ) ts = "96"; else
      if ( ts.equals(">104") ) ts = "105"; else
      if ( ts.equals("<96") ) ts = "95";

      String weight = req.getParameter("weight");
      String duration = req.getParameter("duration");
      String bodyPart = req.getParameter("bodyPart");
      String system = req.getParameter("system");
      String userInput = req.getParameter("userInput");

      if ( LOGGING ) {
	System.out.println("session == null: " + (session == null));
	System.out.println("newInSymptomsArr: " + newInSymptomsArr);
	System.out.println("newAllSymptoms: " + newAllSymptoms);
	System.out.println("weight: " + weight);
	System.out.println("duration: " + duration);
	System.out.println("bodyPart: " + bodyPart);
	System.out.println("system: " + system);
	System.out.println("userInput: " + userInput);
      }

      Vector selectedSymptoms = new Vector();
      HashSet notSelectedSymptoms = new HashSet();
      Vector locations = new Vector();
      locations.addElement(previousBodyPart);
      Vector systems = new Vector();
      systems.addElement(previousSystem);
      Vector diseases = new Vector(); // instances of DiseaseInst
      Vector expertDiseases = new Vector(); // instances of DiseaseInst
      Vector checkConcepts = new Vector(); 

      Float tsFloat = new Float(99.3f);
      try { tsFloat = new Float(ts); }
      catch (NumberFormatException ignore) {}
      unboundHashtable.put("tsFloat", tsFloat);

      if ( null != newInSymptomsArr )
	session.putValue("newInSymptomsArr", newInSymptomsArr);

      session.putValue("temperatureSelected", ts);
      session.putValue("tsFloat", tsFloat);
      session.putValue("weight", weight);
      session.putValue("duration", duration);
      session.putValue("foundLifeThreateningDisease", "notFound");
      session.putValue("expertDiseases", expertDiseases);
      session.putValue("checkConcepts", checkConcepts);

      Vector diagStack = new Vector();
      session.putValue("diagStack", diagStack);
      DiagStackEntry dse = 
	new DiagStackEntry(locations, systems, 
			   selectedSymptoms, notSelectedSymptoms,
			   diseases);
      diagStack.addElement(dse);
      dse.setBodyPart(bodyPart);
      dse.setSystem(system);

      res.sendRedirect("/hck/servlet/patient.Diag1a?iteration=0&" + 
		       "newAllSymptoms=" + newAllSymptoms +
		       ( userInput.equals("") ? "" :
			 "&userInput=" + URLEncoder.encode(userInput) )
		       );
    }
}

