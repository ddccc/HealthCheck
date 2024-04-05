// (C) OntoOO Inc 2002
package patient;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URLEncoder;
import com.Common;
import com.DV;
import com.D;
import misc.DiagStackEntry;
import concepts.Location;
import concepts.Symptom;
import misc.SessionExpired;

public class Diag1c extends HttpServlet {
  private static final boolean LOGGING = DV.LOGGINGdiag1c;

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      if ( LOGGING ) {
	System.out.println("*** Diag1c: Enter");
      }
      HttpSession session = req.getSession(false);
      if ( null == session ) {
	  SessionExpired.call(res,
			      DV.Diag1c);
	  return;
      }

      String iter = req.getParameter("iteration");
      int iteration = 0;
      try { iteration = Integer.parseInt(iter); } 
      catch(NumberFormatException ignore) {}
      // access values on the stack here
      Vector diagStack = (Vector) session.getValue("diagStack");

      DiagStackEntry dse = (DiagStackEntry) diagStack.elementAt(iteration);
      String bodyPart = dse.getBodyPart();
      String system = dse.getSystem();

      // String newInSymptomsStr = req.getParameter("newInSymptomsStr"); 
      // String newInSymptomsStr = dse.getNewInSymptomsStr();
      
      Vector newInSymptomsVec = new Vector();
      String[] newInSymptomsArr = req.getParameterValues("newInSymptomsStr");
      if ( null != newInSymptomsArr && 0 < newInSymptomsArr.length ) {
	for (int i = 0; i < newInSymptomsArr.length; i++)
	  newInSymptomsVec.addElement(newInSymptomsArr[i]);
      }
      dse.setNewInSymptomsVec(newInSymptomsVec);

      String narrowBodyPart = req.getParameter("narrowBodyPart");
      String narrowSystem = req.getParameter("narrowSystem");
      String[] expertDiseasesArr = req.getParameterValues("expertDiseases");

      String[] checkSymptomsArr = req.getParameterValues("checkSymptoms");
      String checkBodyPart = req.getParameter("checkBodyPart");
      String checkSystem = req.getParameter("checkSystem");
      String[] checkDiseasesArr = req.getParameterValues("checkDiseases");
      String userInput = req.getParameter("userInput");
      if ( null == userInput ) userInput = "";

      if ( LOGGING ) {
	System.out.println("newInSymptomsVec: " + newInSymptomsVec.toString());
	System.out.println("narrowBodyPart: " + narrowBodyPart);
	System.out.println("narrowSystem: " + narrowSystem);
	System.out.println("expertDiseasesArr: " + expertDiseasesArr);
	System.out.println("checkSymptomsArr: " + checkSymptomsArr);
	System.out.println("checkBodyPart: " + checkBodyPart);
	System.out.println("checkDiseasesArr: " + checkDiseasesArr);
	System.out.println("userInput: " + userInput);
      }

      // rebuild expertDisease
      Vector expertDiseases = (Vector) session.getValue("expertDiseases");
      expertDiseases.removeAllElements();
      Vector allExpertDiseasesVec = new Vector();
      if ( null != expertDiseasesArr && 0 < expertDiseasesArr.length ) {
	for (int i = 0; i < expertDiseasesArr.length; i++)
	  allExpertDiseasesVec.addElement(expertDiseasesArr[i]);
      }
      if ( null != checkDiseasesArr && 0 < checkDiseasesArr.length ) {
	for (int i = 0; i < checkDiseasesArr.length; i++)
	  allExpertDiseasesVec.addElement(checkDiseasesArr[i]);
      }

      if ( LOGGING ) 
	System.out.println("allExpertDiseasesVec: " + 
			   allExpertDiseasesVec.toString());

      //      if ( null != allExpertDiseasesStr ) {
      //	StringTokenizer st = new StringTokenizer(allExpertDiseasesStr, ",");
      if ( 0 < allExpertDiseasesVec.size() ) {
	String token;
	Float tsFloat = (Float) session.getValue("tsFloat");
	float temperature = tsFloat.floatValue();
	Vector empty = new Vector();
	Vector diseases = dse.getDiseases();
	// while ( st.hasMoreTokens() ) {
	//   token = st.nextToken();
	for (int i = 0; i < allExpertDiseasesVec.size(); i++) {
	  token = (String) allExpertDiseasesVec.elementAt(i);
	  if ( Common.isDiseaseMember(token, expertDiseases) ||
	       Common.isDiseaseMember(token, diseases) ) continue;
	  DiseaseInst di = new DiseaseInst(token, temperature);
	  di.requalify(empty, empty);
	  expertDiseases.addElement(di);
	}
      }

      // append element in checkSymptomsArr
      Vector newAllSymptomsVec = dse.getNewAllSymptomsVec();
      if ( null != checkSymptomsArr && 0 < checkSymptomsArr.length ) {
	String token;
	for (int i = 0; i < checkSymptomsArr.length; i++) {
	  token = checkSymptomsArr[i];
	  if ( !newInSymptomsVec.contains(token) ) newInSymptomsVec.addElement(token);
	  if ( !newAllSymptomsVec.contains(token) ) newAllSymptomsVec.addElement(token);
	}
      }

      if ( LOGGING ) System.out.println("*** Passing A");

      if ( null == checkBodyPart || checkBodyPart.equals("ignore") )
	checkBodyPart = bodyPart;
      if ( null == checkSystem || checkSystem.equals("ignore") )
	checkSystem = system;

      boolean isBodyNarrowed =
	( null != narrowBodyPart && !checkBodyPart.equals(narrowBodyPart) );
      boolean isSystemNarrowed =
	( null != narrowSystem && !checkSystem.equals(narrowSystem) );

      if ( LOGGING ) {
	System.out.println("checkBodyPart: " + checkBodyPart);
	System.out.println("isBodyNarrowed: " + isBodyNarrowed);
	System.out.println("checkSystem: " + checkSystem);
	System.out.println("isSystemNarrowed: " + isSystemNarrowed);
	System.out.println("newInSymptomsVec: " + newInSymptomsVec.toString());
	System.out.println("newAllSymptomsVec: " + newAllSymptomsVec.toString());
      }

      if ( isBodyNarrowed ) 
	  dse.setBodyPart(narrowBodyPart); // give priority to this field
      else
	  dse.setBodyPart(checkBodyPart);
      if ( isSystemNarrowed ) 
	  dse.setSystem(narrowSystem); // give priority to this field
      else
	  dse.setSystem(checkSystem);

      if ( !userInput.equals("") || isBodyNarrowed || isSystemNarrowed ) {
	  Diag1a.call("Diag1c", iteration, session, userInput, null, null, res);
	  return;
      }

      // Check whether we have to adjust for a focussed search
      String searchMode = (String) session.getValue("searchMode");
      if ( 0 == iteration ) {
	  if ( searchMode.equals("focussed") ) {
	      HashSet D1 = (HashSet) session.getValue("D1"); // all diseases
	      HashSet D2 = new HashSet();
	      String locName = dse.getBodyPart();
	      Vector vec;
	      if ( locName.equals("unspecified") ) 
		  vec = new Vector();
	      else {
		  Location loc = Common.getLocation(locName);
		  vec = loc.getAllSymptoms();
		  vec = (Vector)vec.clone();
	      }
	      int lng = newInSymptomsVec.size();
	      for (int i = 0; i < lng; i++) {
		  String sympName = (String) newInSymptomsVec.elementAt(i);
		  if ( !vec.contains(sympName) ) vec.addElement(sympName);
	      }
	      lng = vec.size();
	      for (int i = 0; i < lng; i++) {
		  String sympName = (String) vec.elementAt(i);
		  Symptom sym = Common.getSymptom(sympName);
		  Vector theDiseases = sym.getTheDiseases();
		  int lng2 = theDiseases.size();
		  for (int j = 0; j < lng2; j++) {
		      String diseaseName = (String) theDiseases.elementAt(j);
		      if ( !D1.contains(diseaseName) ) continue; // gender check
		      D2.add(diseaseName);
		  }
	      }
	      dse.setD2(D2);
	      // D2 is empty iff { lccName == unspecified && 0 == newInSymptomsVec }
	  } else {
	      // check that at least something has been set:
	      if ( 0 == newInSymptomsVec.size() &&
		   dse.getBodyPart().equals("unspecified") &&
		   dse.getSystem().equals("unspecified") ) {
		  DiagException.call(res);
		  return;
	      }
	  }
	  // check here whether D2 is non empty
	  HashSet D2 = dse.getD2();
	  if ( D2.isEmpty() ) {
	      DiagException.call(res);
	      return;
	  }
      }

      Diag2.call(res, session, iteration);
    }

} // end of Diag1c

