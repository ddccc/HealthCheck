// (C) OntoOO Inc 2003 Mar
package patient;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URLEncoder;
import com.Common;
import com.DV;
import com.D;
import misc.DB;
import patient.TestSymptoms;
import misc.DiagStackEntry;
import misc.SessionExpired;

public class Diag1Unrestricted extends HttpServlet {
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
	  SessionExpired.call(res,
			      DV.Diag1);
	  return;
      }

      session.putValue("searchMode", "unrestricted"); // used in Diag1c

      Hashtable unboundHashtable = 
           (Hashtable) session.getValue("unboundHashtable");

      // String [] newInSymptomsArr = req.getParameterValues("symptoms");
      // String newAllSymptoms = req.getParameter("allSymptoms");
      String [] newInSymptomsArr = null;
      String newAllSymptoms = "";
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

      // String weight = req.getParameter("weight");
      String weight = null;
      // String duration = req.getParameter("duration");
      String duration = null;
      String bodyPart = req.getParameter("bodyPart"); 
      // String system = req.getParameter("system");
      String system = "unspecified";
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

      /*
      if ( null != newInSymptomsArr )
	session.putValue("newInSymptomsArr", newInSymptomsArr);
      */

      session.putValue("temperatureSelected", ts);
      session.putValue("tsFloat", tsFloat);
      // session.putValue("weight", weight);
      // session.putValue("duration", duration);
      session.putValue("foundLifeThreateningDisease", "notFound");
      session.putValue("expertDiseases", expertDiseases);
      session.putValue("checkConcepts", checkConcepts);

      DB props = (DB) session.getValue("theDB");
      String statusCondition = props.getProperty("statusCondition");
      Integer ageInt = (Integer) session.getValue("ageInt");
      int age = ageInt.intValue();
      TestSymptoms testSymptoms = new TestSymptoms(age, statusCondition);

      Vector diagStack = new Vector();
      session.putValue("diagStack", diagStack);
      DiagStackEntry dse = 
	new DiagStackEntry(locations, systems, 
			   selectedSymptoms, notSelectedSymptoms,
			   diseases);
      diagStack.addElement(dse);
      dse.setBodyPart(bodyPart);
      dse.setSystem(system);
      dse.setTestSymptoms(testSymptoms);

      // set the collection of diseases to be investigated
      HashSet D1 = (HashSet) session.getValue("D1"); // all diaseases
      dse.setD2(D1);

      Diag1a.call("Diag1Unrestricted", 0, session, userInput, null, null, res);
    }
}

