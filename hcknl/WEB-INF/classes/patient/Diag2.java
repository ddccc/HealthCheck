// (C) OntoOO Inc 2002
package patient;

import com.Common;
import com.DV;
import com.D;
import com.L;
import com.DVM;
import misc.DB;
import misc.DiagStackEntry;
import misc.SortableSymptom;
import concepts.BodySystem;
import concepts.Disease;
import concepts.Location;
import concepts.LocationRelation;
import concepts.Symptom;
import concepts.WeightedSymptom;
import misc.SessionExpired;

import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;

/*
  This code adds items (symptomps, disease conjectures, system, bodyPart, ...)
  to: unboundHashtable
  When a session terminates the content of unboundHashtable will be added 
  to the user's eRecord.  This is achieved by misc.PeriodLogin.valueUnbound(...),
  which exploits brilliant servlet functionality to do a final operation when a 
  session terminates.   AngelLogin sets up the unboundHashtable with 
  misc.PeriodLogin0.valueBound(...), which puts it on the session.
 */

public class Diag2 extends HttpServlet {
  private static final NumberFormat nf = new DecimalFormat("0.000E00");

  private static final boolean expert = DV.expert;
  private static final boolean TRACING = DV.TRACINGdiag2;
    //private static final boolean TRACING = true;

    public static final int iterationSwitch = 3;

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
       throws ServletException, IOException {

      HttpSession session = req.getSession(false);
      if ( null == session ) {	
	  SessionExpired.call(res,
			      DV.Diag2);
	  return;
      }
      String iter = req.getParameter("iteration");
      int iteration = 0;
      try { iteration = Integer.parseInt(iter); } 
      catch(NumberFormatException ignore) {}  

      call(res, session, iteration);
    }
    
    static public void call(HttpServletResponse res, HttpSession session, int iteration) 
       throws IOException {

      String trace = "";
      boolean startedPage = false;
      ServletOutputStream out = null;

try {
      DB props = (DB) session.getValue("theDB");
      String statusCondition = props.getProperty("statusCondition");
      // see explanation at the top
      Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");
      Integer ageInt = (Integer) session.getValue("ageInt");
      int age = ageInt.intValue();
      String gender = (String) session.getValue("gender");

      Vector diagStack = (Vector) session.getValue("diagStack");
      DiagStackEntry dse = (DiagStackEntry) diagStack.elementAt(iteration);

      Vector newInSymptoms = dse.getNewInSymptomsVec();
      Vector newAllSymptoms = dse.getNewAllSymptomsVec();
      Vector newOutSymptoms = new Vector();
      // newOutSymptoms = newAllSymptoms - newInSymptoms 
      int lng = newAllSymptoms.size();
      String token;
      for (int i = 0; i < lng; i++) {
	token = (String) newAllSymptoms.elementAt(i);
	if ( !newInSymptoms.contains(token) ) 
	    newOutSymptoms.addElement(token);
      }

      if ( TRACING ) {
	trace += 
	  "<br /><b>newInSymptoms:</b> " + newInSymptoms.toString() + "\n" +
	  "<br /><b>newAllSymptoms:</b> " + newAllSymptoms.toString() + "\n" +
	  "<br /><b>newOutSymptoms:</b> " + newOutSymptoms.toString();
	System.out.println("*** Diag2 trace: " + trace);
      }

      Float tsFloat = (Float) session.getValue("tsFloat");
      float temperature = tsFloat.floatValue();
      String weight = (String) session.getValue("weight");
      String duration = (String) session.getValue("duration");

      // access more values on the stack here
      Vector locations = (Vector) dse.getLocations().clone();
      Vector systems = (Vector) dse.getSystems().clone();
      String bodyPart = dse.getBodyPart();
      String system = dse.getSystem();

      if ( TRACING ) {
	trace += 
	  "<br /><b>locations:</b> " + locations.toString() +
	  "<br /><b>systems:</b> " + systems.toString() +
	  "<br /><b>bodyPart:</b> " + bodyPart +
	  "<br /><b>system:</b> " + system + "\n";
      }

      Vector selectedSymptoms = (Vector) dse.getSelectedSymptoms().clone();
      HashSet notSelectedSymptoms = (HashSet) dse.getNotSelectedSymptoms().clone();

      if ( TRACING ) {
	trace += 
	  "<br /><b>selectedSymptoms:</b> " + selectedSymptoms.toString() + 
	  "<br /><b>notSelectedSymptoms:</b> " + notSelectedSymptoms.toString() + "\n";
	// System.out.println("*** Diag2 trace: " + trace);
      }

      Vector diseases = (Vector) dse.getDiseases().clone(); // ie DiseaseInst
      lng = diseases.size();
      for ( int i = 0; i < lng; i++ ) {
	  DiseaseInst di = (DiseaseInst) diseases.elementAt(i);
	  diseases.setElementAt(di.copy(), i);
      }
      Vector expertDiseases = (Vector) session.getValue("expertDiseases");
      if ( TRACING ) {
	trace += 
	  "<br /><b> #diseases:</b> " + diseases.size() +
	  ( null == expertDiseases ? "\n" :
	    "<br /><b> #expertDiseases:</b> " + expertDiseases.size() + "\n");
	// System.out.println("*** Diag2 trace: " + trace);
      }

      // TestSymptoms elements are SortableSymptom that have not yet been used
      TestSymptoms testSymptoms= (TestSymptoms) dse.getTestSymptoms().clone();

      iteration++;

      if ( TRACING ) trace += "<br /> *** Passing A ...";

      // did the user narrow the location?
      boolean bodyPartNarrowed = false;
      bodyPartNarrowed = (null != bodyPart) && (!locations.contains(bodyPart));

      // did the user narrow the system ??
      boolean systemNarrowed = false;
      systemNarrowed = (null != system) && (!systems.contains(system));

      DiseaseInst di;
      Vector newExpertDiseases = new Vector(); // elements are DiseaseInst
      lng = expertDiseases.size();
      if ( 0 < lng ) {
	// for now only when arriving from Diag0 & Diag1
	for (int i = 0; i < lng; i++) {
	  // being defensive here
	  di = (DiseaseInst) expertDiseases.elementAt(i);
	  token = di.getDisease();
	  if ( Common.isDiseaseMember(token, newExpertDiseases) ) continue;
	  if ( Common.isDiseaseMember(token, diseases) ) continue;
	  // filtering for age and statusCondition was done in Diag1a
	  di.requalify(selectedSymptoms, notSelectedSymptoms);
	  newExpertDiseases.addElement(di);
	}
	expertDiseases.removeAllElements();
      }

      // Add newOutSymptoms to notSelectedSymptoms
      String symptomName = null;
      lng = newOutSymptoms.size();
      if ( 0<lng ) {
	for (int i = 0; i < lng; i++) {
	  symptomName = (String) newOutSymptoms.elementAt(i);
	  if ( !notSelectedSymptoms.contains(symptomName) )
	    notSelectedSymptoms.add(symptomName);
	}
	// put new notSelectedSymptoms in unboundHashtable:
	// see explanation at the top
	unboundHashtable.put("notSelectedSymptoms", notSelectedSymptoms);
      }

      HashSet S1 = (HashSet) session.getValue("S1"); // all symptoms
      // HashSet D1 = (HashSet) session.getValue("D1"); // all diaseases
      HashSet D1 = dse.getD2(); // collection of diseases investigated, a subset of D1

      String diseaseStatusCondition;
      Disease disease;

      // Generate additional disease conjectures from newInSymptoms
      Vector newInSymptomsDiseases = new Vector(); // elements are DiseaseInst
      lng = newInSymptoms.size();
      if ( 0<lng ) {
	String diseaseName, diseaseKeys;
	Symptom sym;
	Vector vec;
	int lngVec;
	for (int i = 0; i < lng; i++) {
	  symptomName = (String) newInSymptoms.elementAt(i);
	  // System.out.println("** Diagnose2 #2.5 symptomName:" + symptomName);
	  if ( Common.member(symptomName, selectedSymptoms) ) continue;
	  selectedSymptoms.addElement(symptomName);
	  sym = Common.getSymptom(symptomName);
	  vec = sym.getTheDiseases();
	  lngVec = vec.size();
	  for (int j = 0; j < lngVec; j++) {
	    diseaseName = (String) vec.elementAt(j);
	    if ( !D1.contains(diseaseName) ) continue;
	    if ( Common.isDiseaseMember(diseaseName, newInSymptomsDiseases) ) continue;
	    if ( Common.isDiseaseMember(diseaseName, diseases) ) continue;
	    if ( Common.isDiseaseMember(diseaseName, newExpertDiseases) ) continue;
	    disease = Common.getDisease(diseaseName);
	    if ( age < disease.getMinAge() || disease.getMaxAge() < age ) continue;
	    diseaseStatusCondition = disease.getStatusCondition();
	    if ( !diseaseStatusCondition.equals("none") ) {
	      // check whether the client matches the statusCondition
	      if ( !diseaseStatusCondition.equals(statusCondition) &&
		   // perhaps the client does not know she is pregnant
		   !diseaseStatusCondition.equals("pregnant") ) continue; 
	    }
	    di = new DiseaseInst(diseaseName, temperature, "Diag2", gender, age, iteration);
	    di.requalify(selectedSymptoms, notSelectedSymptoms);
	    newInSymptomsDiseases.addElement(di);
	  }
	}
	// put new selectedSymptoms in unboundHashtable:
	// see explanation at the top
	unboundHashtable.put("selectedSymptoms", selectedSymptoms);
      }
      /*
      System.out.println("Diag2 selectedSymptoms: size: " + selectedSymptoms.size());
      for ( int i = 0; i < selectedSymptoms.size(); i++ ) 
	  System.out.println("Diag2 selectedSymptoms: " + i + " " + ((String) selectedSymptoms.elementAt(i)));
      */



      if ( TRACING ) {
	trace += "<br />*** Passing D ...";
	trace += 
	  "<br />*** Passing D2 ..." +
	  "<br /><b>systemNarrowed:</b> " +  systemNarrowed;
      }

      // Generate additional disease if systemNarrowed
      Vector newSystemDiseases = new Vector(); // elements are DiseaseInst
      if ( systemNarrowed ) {
	  // see explanation at the top
	  unboundHashtable.put("system", system);
	// will generate option to further narrow down - if possible
	systems = (Vector) systems.clone();
	systems.addElement(system);
	if( !system.equals("unspecified") ) {
	  BodySystem bs = Common.getBodySystem(system);
	  // out.println(bs.html());
	  Vector associatedDiseases = bs.getAssociatedDiseases();
	  WeightedSymptom ws;
	  lng = associatedDiseases.size();
	  String diseaseName;
	  for (int j = 0; j < associatedDiseases.size(); j++) {
	    diseaseName = (String) associatedDiseases.elementAt(j);
	    if ( !D1.contains(diseaseName) ) continue;
	    if ( Common.isDiseaseMember(diseaseName, newSystemDiseases) ) continue;
	    if ( Common.isDiseaseMember(diseaseName, diseases) ) continue;
	    if ( Common.isDiseaseMember(diseaseName, newExpertDiseases) ) continue;
	    if ( Common.isDiseaseMember(diseaseName, newInSymptomsDiseases) ) continue;
	    disease = Common.getDisease(diseaseName);
	    if ( age < disease.getMinAge() || disease.getMaxAge() < age ) continue;
	    diseaseStatusCondition = disease.getStatusCondition();
	    if ( !diseaseStatusCondition.equals("none") ) {
	      // check whether the client matches the statusCondition
	      if ( !diseaseStatusCondition.equals(statusCondition) &&
		   // perhaps the client does not know she is pregnant
		   !diseaseStatusCondition.equals("pregnant") ) continue; 
	    }
	    di = new DiseaseInst(diseaseName, temperature, "Diag2", gender, age, iteration);
	    di.requalify(selectedSymptoms, notSelectedSymptoms);
	    newSystemDiseases.addElement(di);
	  }
	}
      }

      if ( TRACING ) {
	trace += "<br />*** Passing E ...";
	lng = diseases.size();
	String dis;
	for (int i = 0; i < lng; i++) {
	  di = (DiseaseInst) diseases.elementAt(i); 
	  dis = di.getDisease();
	  trace += "<br /><b>disease #:</b> " + i + ": " + dis + " " + di.getAcceptanceRate();
	}
      }

      // Requalify *diseases* against newInSymptoms & newOutSymptoms
      Vector boostedDiseases = new Vector(); // elements of DiseaseInst
      lng = diseases.size();
      if ( 0<lng ) {
	float preAcceptanceRate;
	for (int i = 0; i < lng; i++) {
	  di = (DiseaseInst) diseases.elementAt(i);
	  preAcceptanceRate = di.getAcceptanceRate();
	  di.requalify(newInSymptoms, newOutSymptoms);
	  if ( preAcceptanceRate < di.getAcceptanceRate() ) {
	    di.incrementBoostCnt();
	    boostedDiseases.addElement(di);
	  }
	} 
      }

      // Requalify *newExpertDiseases* against newInSymptoms & newOutSymptoms
      lng = newExpertDiseases.size();
      if ( 0<lng ) {
	for (int i = 0; i < lng; i++) {
	  di = (DiseaseInst) newExpertDiseases.elementAt(i);
	  di.requalify(newInSymptoms, newOutSymptoms);
	  diseases.addElement(di);
	} 
      }

      // Requalify *newSystemDiseases* against newInSymptoms & newOutSymptoms
      lng = newSystemDiseases.size();
      if ( 0<lng ) {
	for (int i = 0; i < lng; i++) {
	  di = (DiseaseInst) newSystemDiseases.elementAt(i);
	  di.requalify(newInSymptoms, newOutSymptoms);
	  diseases.addElement(di);
	} 
      }

      // Requalify *newInSymptomsDiseases* against newInSymptoms & newOutSymptoms
      lng = newInSymptomsDiseases.size();
      if ( 0<lng ) {
	for (int i = 0; i < lng; i++) {
	  di = (DiseaseInst) newInSymptomsDiseases.elementAt(i);
	  di.requalify(newInSymptoms, newOutSymptoms);
	  diseases.addElement(di);
	} 
      }

      newInSymptoms.removeAllElements();
      newOutSymptoms.removeAllElements();

      if ( TRACING ) {
	trace += "<br />*** Passing E2 ...";
	lng = diseases.size();
	String dis;
	for (int i = 0; i < lng; i++) {
	  di = (DiseaseInst) diseases.elementAt(i); 
	  dis = di.getDisease();
	  trace += "<br /><b>disease #:</b> " + i + ": " + dis + " " + di.getAcceptanceRate();
	}
      }

      /*
	Extended diseases are looked for only when the topRate == 1.
	Let d be the disease that has the topRate == 1.
	An extended disease:
	- has no rejected symptom
	- has all the confirmed symptoms of d
	- does not have an acceptanceRate == 1
       */
      Vector extendedDiseases = new Vector();

      lng = diseases.size();
      float topRate = 0;
      int index = -1;
      if ( 0 < lng ) {
	Collections.sort(diseases);
	// **************************
	// we can terminate if the first element has sufficient support ....
	// **************************
	for (int i = 0; i < lng; i++) {
	    di = (DiseaseInst)diseases.elementAt(i);
	    float tRate = di.getAcceptanceRate();
	    if ( topRate < tRate ) { topRate = tRate; index = i; }
	    if ( 1 == topRate ) break; 
	}

	// di = (DiseaseInst)diseases.elementAt(0);
	// topRate = di.getAcceptanceRate();
	if ( 1 == topRate ) findExtendedDiseases(diseases, extendedDiseases, index);
	session.putValue("diagnosis", "" + topRate);
	/*
	if ( 1 == lng ) 
	  session.putValue("diagnosis", "" + topRate);
	else {
	  di = (DiseaseInst)diseases.elementAt(1);
	  float nextRate = di.getAcceptanceRate();
	  session.putValue("diagnosis", 
			   ( topRate == nextRate ? "ambiguity-" : "" ) +
			   topRate);
	}
	*/

	float acceptanceRate = 0; 
	float ar;
	// System.out.println("-------------------------------------------------");
	for (int i = 0; i < lng; i++) {
	  di = (DiseaseInst) diseases.elementAt(i);
	  ar = di.getAcceptanceRate();
	  /*
	  System.out.println(
			     nf.format(ar) +
			     " " + nf.format(di.getIncidenceRate()) +
			     " " + nf.format(di.rate()) +
			     " " + nf.format(di.getIterationCnt()) +
			     " " + nf.format((1.0f/(1 + di.getIterationCnt()))) +
			     " " + di.getDisease()
			     );
	  */
	  if ( (acceptanceRate < ar) && di.isLifeThreatening() ) {
	    acceptanceRate = ar;
	  } 
	}
	if ( 0 < acceptanceRate )
	  session.putValue("foundLifeThreateningDisease", "" + acceptanceRate);
      }
    
      if ( TRACING ) {
	trace += "<br />*** Passing F ...";
      }


      // ************************************
      // ************************************
      // termination condition must change
      // also consider asking for relevant locations 
      // ************************************
      // ************************************

      boolean globalSymptoms = false;

      // if ( topRate < 1 ) { 
	// Searching for new testable symptoms 
	// investigate: newExpertDiseases, newSystemDiseases, narrowed locations
	// boostedDiseases, newInSymptomsDiseases, ...

	testSymptoms.addSymptomsFromDiseases(
		  newExpertDiseases, "newExpertDiseases", 
		  S1, notSelectedSymptoms, selectedSymptoms);

	testSymptoms.addSymptomsFromDiseases(
		  newSystemDiseases, "newSystemDiseases",
		  S1, notSelectedSymptoms, selectedSymptoms);

	if ( TRACING ) {
	  trace += 
	    "<br />*** Passing I ..." +
	    "<br /><b>bodyPartNarrowed:</b> " +  bodyPartNarrowed;
	}


	if ( bodyPartNarrowed ) {
	  // will generate option to further narrow down - if possible
	  locations = (Vector) locations.clone();
	  locations.addElement(bodyPart);
	  /* a location has associated symptoms as well as subsystems 
	     (which have diseases) Fow now we ignore the subsystems ...
	     */
	  if ( !bodyPart.equals("unspecified") ) {
	      // see explanation at the top
	      unboundHashtable.put("bodyPart", bodyPart);
	      Location loc = Common.getLocation(bodyPart);
	      Vector symptomsOfLoc = loc.getSymptoms();
	      testSymptoms.addSymptoms(
                     symptomsOfLoc, "bodyPartNarrowed",
		     S1, notSelectedSymptoms, selectedSymptoms);
	  }
	}

	testSymptoms.addSymptomsFromDiseases(
                     boostedDiseases, "boostedDiseases",
		     S1, notSelectedSymptoms, selectedSymptoms);

	testSymptoms.addSymptomsFromDiseases(
		     newInSymptomsDiseases, "newInSymptomsDiseases",
		     S1, notSelectedSymptoms, selectedSymptoms);

	lng = testSymptoms.size();
	if ( 0 == lng ) { 
	    globalSymptoms = true;
	    // get the most promissing from S1 - (selectedSymptoms + notSelectedSymptoms)
	    for (Iterator i = S1.iterator(); i.hasNext(); ) {
	        symptomName = (String) i.next();
		testSymptoms.addSymptom(
                     symptomName, "none",
		     S1, notSelectedSymptoms, selectedSymptoms);
	    }
	}
	// } else { // 1 == topRate
	  if ( 0 < extendedDiseases.size() ) 
	      testSymptoms.addSymptomsFromDiseases(
                     extendedDiseases, "boostedDiseases", 
		     S1, notSelectedSymptoms, selectedSymptoms);
	  // }

      // end of creating testSymptoms elements
      // Notice: even when globalSymptoms = true testSymptoms may still be empty!!


      lng = testSymptoms.size();
      Vector ts = new Vector();

      // if ( 0 < lng && ( topRate < 1 || 0 < extendedDiseases.size() ) ) {
      if ( 0 < lng ) {
	  Vector orderedSortedSymptoms = null;
	  if ( iteration < iterationSwitch ) {
	      // use only the diseases that have all the selected symptoms
	      Vector filteredDiseases = new Vector();
	      int lngd = diseases.size();
	      // System.out.println("Diag2 diseases.size() " + lngd);
	      int lng3 = selectedSymptoms.size();
	      for ( int i = 0; i < lngd; i++ ) {
		  di = (DiseaseInst) diseases.elementAt(i);
		  /*
		  Vector requiredSymptoms = di.getRequiredSymptoms();
		  Vector requiredSymptomNames = new Vector();
		  for ( int j = 0; j < requiredSymptoms.size(); j++ ) {
		      WeightedSymptom ws = 
			  (WeightedSymptom) requiredSymptoms.elementAt(j);
		      requiredSymptomNames.addElement(ws.getSymptom());
		  }
		  */
		  Vector requiredSymptomNames = di.getAllSymptomNames();
		  boolean allow = true;
		  for ( int j = 0; j < lng3; j++ ) {
		      String sympName = (String) selectedSymptoms.elementAt(j);
		      if ( ! requiredSymptomNames.contains(sympName) ) {
			  // System.out.println(di.getDisease() + 
			  //                    " has not " + sympName);
			  allow = false; break;
		      }
		  }
		  if ( allow ) filteredDiseases.addElement(di);
	      }
	      // System.out.println("Diag2 iteration " + iteration +
	      //	 " filteredDiseases.size() " + filteredDiseases.size());
	      orderedSortedSymptoms = 
                  testSymptoms.orderedTestSymptoms(
		      filteredDiseases, notSelectedSymptoms, D1, true);

	      // System.out.println("Diag2 orderedSortedSymptoms.size() " +
	      //		    orderedSortedSymptoms.size());

	      if ( 0 == orderedSortedSymptoms.size() ) // defensive
		  orderedSortedSymptoms =
		      testSymptoms.orderedTestSymptoms(
			  diseases, notSelectedSymptoms, D1, false);
	  } else 
	      orderedSortedSymptoms =
		  testSymptoms.orderedTestSymptoms(
                          diseases, notSelectedSymptoms, D1, false);

	  // System.out.println("Diag2 filteredDiseases.size() " + 
	  //                    filteredDiseases.size());

	  SortableSymptom ss;
	  String sympName;

	  boolean lifeThreatening = false;
	  for (int i = 0; i < lng; i++) {
	      ss = (SortableSymptom) orderedSortedSymptoms.elementAt(i);
	      if ( ss.isLifeThreatening() ) {
		  lifeThreatening = true;
		  break;
	      }
	  }

	  // System.out.println("Diag2/ iteration: " + iteration + 
	  //                    " lifeThreatening: " + lifeThreatening);
	  int lng2 = ( lng < 20 ? lng : 20 ); // max # of test symptoms
	  for (int i = 0; i < lng2; i++) {
	      ss = (SortableSymptom) orderedSortedSymptoms.elementAt(i);
	      sympName = ss.getSympName();
	      if ( lifeThreatening && iteration < iterationSwitch ) {
		  if ( ss.isLifeThreatening() ) {
		      testSymptoms.remove(sympName);
		      ts.addElement(sympName);
		  }
		  continue;
	      }
	      testSymptoms.remove(sympName);
	      ts.addElement(sympName);
	  }
	  // generateTestSymptoms(out, ts, session);
	  // generatedForm = true;
	  // generatedTestSymptoms = true;
      }

      // push on stack
      DiagStackEntry dse2 = 
	new DiagStackEntry(locations, systems, 
			   selectedSymptoms, notSelectedSymptoms,
			   diseases);
      dse2.setBodyPart(bodyPart);
      dse2.setSystem(system);
      dse2.setD2(dse.getD2());
      if ( globalSymptoms ) testSymptoms.clear();
      dse2.setTestSymptoms(testSymptoms);

      /*
      System.out.println(
	     "diagStack.size(): " + diagStack.size() +
	     " iteration: " + iteration);
      */
      if ( iteration < diagStack.size() ) diagStack.setSize(iteration);
      diagStack.addElement(dse2);
      /*
      if ( diagStack.size() <= iteration )
	diagStack.addElement(dse2);
      else
	diagStack.setElementAt(dse2, iteration);
      */

      session.putValue("iter", "" + iteration); // for DisplayDiseaseInst

      // produce output .....
	String quickAccount = props.getProperty("quickAccount");
	boolean notQuickie = (null == quickAccount);



      startedPage = true;

      // start the output      
      res.setContentType("text/html");
      out = res.getOutputStream();

      out.println("<html><head><title>" + L.HealthScreen + "</title>" +
// "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + D.hckStyle + "\" />" +
		  D.linkHckStyle +
// "<link rel=\"shortcut icon\" href=\"" + hck + "/favicon.ico\" type=\"image/x-icon\" />" +
		  D.favicon +
		  "</head>" +
		  "<body>" +
		  "<font color=\"#850a0a\">");

      out.println(DVM.htmlLogoutUser(L.HealthScreen + " " +
				     L.Iteration + " " + iteration));

      if ( TRACING ) {
	out.println("<h3> Trace Info ...</h3> ");
	out.println(trace);
	// trace = "";
	out.println("<br /><b>iteration:</b> " + iteration);
	out.println("<br /><b>temperatureSelected:</b> " + tsFloat);
	out.println("<br /><b>weight:</b> " + weight);
	out.println("<br /><b>duration:</b> " + duration);
	out.println("<br /><b>selectedSymptoms:</b> " + 
		    selectedSymptoms.toString());
	out.println("<br /><b>newInSymptoms:</b> " + newInSymptoms.toString());
	out.println("<br /><b>notSelectedSymptoms:</b> " + 
		    notSelectedSymptoms.toString());
	out.println("<br /><b>newOutSymptoms:</b> " + newOutSymptoms.toString());
	out.println("<br /><b>locations:</b> " + locations.toString());
	out.println("<br /><b>systems:</b> " + systems.toString());
	out.println("<br /><b>#diseases:</b> " + diseases.size());

	out.println("<br /><b>Updating ...</b>");
	
	out.println("<br /><b>testSymptoms:</b> " + testSymptoms.toString());
      }


      out.println(Diag2B.showInputsScript);
      out.println("<p><a href=\"#showInputs\" name=\"showInputs\" " +
		      "onClick=\"showInputs('" +  iteration + "')\"> " +
		  "<font size=\"4\"><i>" +
		  // "Pop Up My Previous Choices" +
		  L.Diag2S1 +
		  "</i></font></a><p>");

      lng = diseases.size();

      // The following is to test the History class.
      // More realistic is that the CC sets the conjecture - which is tricky
      di = (DiseaseInst) diseases.elementAt(index);
      String diseaseName = di.getDisease();
      // see explanation at the top
      unboundHashtable.put("diseaseConjecture", diseaseName);
      
      // saving all the disease conjectures
      StringBuffer sb = new StringBuffer();
      for (int i=0; i<lng; i++) {
	  di = (DiseaseInst) diseases.elementAt(i);
	  diseaseName = di.getDisease();
	  sb.append(diseaseName + "|");
      }
      // see explanation at the top
      unboundHashtable.put("diseaseConjectures", sb.toString());

      // boolean displayedDiseases = false;
      // display only when significant support
      if ( 0 < lng && 0.5 < topRate && 1 < selectedSymptoms.size() ) { 
	displayDiseases(out, diseases, "client", notQuickie, iteration);
	// displayedDiseases = true;

	/*  Mon Jan 16 17:04:06 2012 -- moved up out of this block
	// The following is to test the History class.
	// More realistic is that the CC sets the conjecture - which is tricky
	di = (DiseaseInst) diseases.elementAt(index);
	String diseaseName = di.getDisease();
	unboundHashtable.put("diseaseConjecture", diseaseName);

	// saving all the disease conjectures
	StringBuffer sb = new StringBuffer();
	for (int i=0; i<lng; i++) {
	  di = (DiseaseInst) diseases.elementAt(i);
	  diseaseName = di.getDisease();
	  sb.append(diseaseName + "|");
	}
	unboundHashtable.put("diseaseConjectures", sb.toString());
	*/

	// if ( 1 == topRate || 0 == ts.size() ) {
	if ( 0 == ts.size() ) {
	     out.println("<h2>" + L.FinalConclusion + "</h2>");
	     /* Prevent 500-errors
	     out.println(
 	         "<form name=\"returnForm\">" +
		 ( notQuickie ?
		   "<input type=\"button\" value=\"" + L.BackToRoot + "\" " +
		   "onClick=\"location='" + D.AngelRootHtml + "'\" /> \n" 
		   : "" ) +
		 "<input type=\"button\" value=\"" + L.AnotherSearch + "\" " +
	              "onClick=\"location='" + D.servletDiagStart + "'\" /> \n" +
		 "</form>");
	     */

	     out.println(DV.htmlBack);
	     out.println(DV.SCRIPTCC);
	     out.println("</font></body>");
	     out.println("</html>");
	     return;
	}

	out.println("<p>" + L.Diag2S14);




	// save stuff testSymptoms stuff here
	session.putValue("ts", ts);

	out.println(
	    "<form name=\"returnForm\">" +
	    "<input type=\"button\" value=\"" + L.Continue + "\" " +
	            "onClick=\"location='" + D.servletDiag2B + 
	                         "?iteration=" + iteration + "'\" />");
	/*
	out.println("<input type=\"hidden\" name=\"iteration\" " +
		    "value=\"" + iteration + "\" />");
	*/

	out.println(
	    /* Prevent 500-errors
	    "<p> \n" +
	    "<input type=\"button\" value=\"" + L.BackToRoot + "\" " +
	         "onClick=\"location='" + 
         	    ( notQuickie ? D.AngelRootHtml : D.servletDiagStart )  + "'\" /> \n" +
	    //	    "<input type=\"button\" value=\"" + L.AnotherSearch + "\" " +
	    //	         "onClick=\"location='" + D.servletDiagStart + "'\" /> \n" +
	    */
	    "</form>");

	out.println(DV.htmlBack);
	out.println(DV.SCRIPTCC);
	out.println("</font></body>");
	out.println("</html>");
	return;
      }

      // no diseases displayed
      if ( 0 < ts.size() ) { // we DO have symptoms 
	  Diag2B.call(out, session, iteration, ts);
	  return;
      }

      // not even symptoms available::

      out.println("<h2>" + L.NoDiseasesFound + "</h2>");
      
      /* Prevent 500-errors
      out.println(
	 "<form name=\"returnForm\">" +
	 "<input type=\"button\" value=\"" + L.BackToRoot + "\" " +
	         "onClick=\"location='" + 
         	    ( notQuickie ? D.AngelRootHtml : D.servletDiagStart )  + "'\" /> \n" +
	 // "<input type=\"button\" value=\"" + L.AnotherSearch + "\" " +
	 //        "onClick=\"location='" + D.servletDiagStart + "'\" /> \n" +
	 "</form>");
      */

      // user Search
      // out.println(DiagStart.search());

      out.println(DV.htmlBack);

      // localhost:8000 === healthcareProvider:80 or so
      out.println(DV.SCRIPTCC);

      out.println("</font></body>");
      out.println("</html>");

} catch (Exception ex) {
           ServletOutputStream outx = null;
           if ( !startedPage ) {
	     res.setContentType("text/html");
	     outx = res.getOutputStream();
	     outx.println("<html>");
	     outx.println("<head><title>Diag2 Exception</title></head>");
	     outx.println("<body BGCOLOR=\"red\">");
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
    } // end of doGet



    /* This function is also invoked by a cc-person in KDetails2 
       The Accept column is generated only when the request comes from a client
       who has logged in; i.e. not when the client is a quickie */
  static public void displayDiseases(ServletOutputStream out, 
				     Vector diseases,
				     String clientId, // clientId = "client" | <a clientId>
				     boolean notQuickie,
				     int iteration)
     throws IOException {
      if ( DV.TRACINGdisplayDiseases ) {
       String trace = "<br />*** displayDiseases";
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


	// check whether we should display the table
	// display only when the first disease has a non zero acceptance rate
	DiseaseInst di = (DiseaseInst) diseases.elementAt(0);
	float acceptanceRate = di.getAcceptanceRate();
	if (0 < acceptanceRate) {

	  out.println("<script language=\"JavaScript\"> ");
	  out.println("function explain(diseaseNum, iteration) { ");
	  out.println("  explainWindow = open( ");
	  out.println("    \"" + D.servletDisplayDiseaseInst + 
		                 "?dis=\"+diseaseNum+" +
		                 "\"&iter=\"+iteration+" +
		                 "\"&clientId=\"+\""+clientId+"\", ");
	  out.println("    \"explainWindowName\", ");
	  out.println("    \"toolbar=1,resizable=1,scrollbars=1,height=600,width=900\" ");
	  out.println("  ); ");
	  out.println("} ");
	  /* Is not used anymore
	  out.println("function displayTreatment(diseaseN) { ");
	  out.println("  treatmentWindow = open( ");
	  out.println("    \"" + D.servletDisplayTreatment + "?dis=\"+diseaseN, ");
	  out.println("    \"treatmentWindowName\", ");
	  out.println("    \"resizable=yes,scrollbars=yes,height=600,width=900\" ");
	  out.println("  ); ");
	  out.println("}");
	  */
	  out.println("</script> ");

	  out.println("<h1 align=\"center\"><font color=\"#1C5540\" size=\"5\">" +
		      L.ConjecturedDiseases +
		      "</font></h1>");
	  out.println("<center><table border=\"1\">");
	  out.println(
              "<tr><td><b>" +
	      // "Life threatening disease in" +
	      L.Diag2S3 +
	      " <font color=\"#FF0000\">" + L.red + "</font></b><br />" +
	      // "Clicking a link generates a popup with details" +
	      L.Diag2S4 +
	      "</td>");
	  out.println(
	      "<td><b>" + L.Support + "</b><br />" +
	      "<a href=\"#hintSupport\" name=\"hintSupport\" onClick=\"alert('" +
	      /*
    "A number in this column is the ratio of the confirmed symptoms and " +
    "the expected symptoms for a disease. " +
    "Thus the support for a disease is less than 1 when one or more of " +
    "its symptoms have not been confirmed because: " +
    "-- it is optional, -- you have not recognized it, or " +
    "-- the system has not yet presented the symptom(s) to you. \n" +
    "The ordering in the table depends on gender, age and frequency of occurrence."
	      */
	      L.Diag2S5 +
	      "')\">" +
	      "<i>" + L.Hint + "</i> </a> </td>");
	  out.println(
		      /*
	      "<td><b>" + L.Treatments + "</b><br />" +
	      // "Clicking a link generates a popup with details" +
	      L.Diag2S4 +
	      "</td>" +
		      */
		      "<td><b>" + L.Support + "</b><br />" +
	      "<a href=\"#hintSupport2\" name=\"hintSupport2\" onClick=\"alert('" +
	      L.Diag2S52 +
	      "')\">" +
	      "<i>" + L.Hint + "</i> </a> </td>");
	  out.println(
	      /* We need better incidence data in the file com/F.java
	      "<td><b>" + L.Frequency + "</b><br />" +
	      "<a href=\"#hintFrequency\" name=\"hintFrequency\" onClick=\"alert('" +
		// "The bar length is an estimate of the diagnosis frequency in the " + 
		// "total population." 
	      L.FrequencyHint +
	      "')\">" +
	      "<i>" + L.Hint + "</i> </a> </td>" +
	      */

	      ( clientId.equals("client") && notQuickie ?
		"<td><b>" + L.Accept + "</b><br />" +
		"<a href=\"#hintAccept\" name=\"hintAccept\" onClick=\"alert('" +
		// "A clicked entry will be entered in your record and " +
		// "the search terminates." +
		L.Diag2S6 +
                "')\">" +
		"<i>" + L.Hint + "</i> </a> </td>" : 
		"") + // here the cc-version
	      "</tr>");

	  String diseaseName;
	  Disease dis;
	  String description;
	  String printName;
	  int anchor, anchor2;
	  int lng = diseases.size();
	  // limit the # of candidate diseases displayed for the client
	  if ( clientId.equals("client") ) {
	    if ( DV.maxNumberOfDisplayedDiseases < lng ) {
	      out.println("<tr><th colspan=\"4\">" +
			  // "# candidate diseases:" + 
			  L.Diag2S7 +
			  " " + lng + " " + 
			  // "# displayed:" + 
			  L.Diag2S8 +
			  " " + DV.maxNumberOfDisplayedDiseases +
			  "</th></tr>");
	      lng = DV.maxNumberOfDisplayedDiseases;
	    }
	  }
	  int accep;
	  boolean lifeThreatening;
	  for ( int i = 0; i < lng; i++ ) {
	    di = (DiseaseInst) diseases.elementAt(i);
	    diseaseName = di.getDisease();
	    lifeThreatening = di.isLifeThreatening();
	    dis = Common.getDisease(diseaseName);
	    // Perhaps we should not display super diseases at all.  For now:
	    /*
	    if ( dis.isSuperDisease() ) {
		Vector vec = dis.getSymptoms();
		if ( vec.size() < 3 ) continue; // dont display
	    }
	    */
	    if ( dis.isSuperDisease() ) continue;

	    // description = dis.getDescription();
	    printName = dis.getPrintName();
	    acceptanceRate = di.getAcceptanceRate();
	    accep = (int) (acceptanceRate * 100); // chopping details
	    acceptanceRate = (float) (accep * 0.01);
	    /* int frequency = dis.getFrequency();
	    frequency = ( -1 == frequency ? 1 :
			  ( frequency <= 12 ? 2 :
			  ( frequency <= 144 ? 3 : 4 ))); */
	    anchor = i; anchor2 = i+500;
	    if ( 0 < acceptanceRate ) 
	      out.println("<tr><td>" + 
			  "<a href=\"#" + anchor + 
			  // "' name='" + anchor + "' onClick=\"explain('" +
			  // i + "','" + iteration + "')\">" +
			  "\" name=\"" + anchor + "\" onClick=\"explain(" +
			  i + "," + iteration + ")\">" +
			  (lifeThreatening ? "<font color=\"#FF0000\">" : "") +
			  printName + 
			  (lifeThreatening ? "</font>" : "") +
			  "</a></td><td>" + 
			  (lifeThreatening ? "<font color=\"#FF0000\">" : "") +
			  acceptanceRate + 
			  (lifeThreatening ? "</font>" : "") +
			  "</td><td>" +
			  /* no treatment ....
			  "<a href='#" + anchor2 + 
			  "' name='" + anchor2 + "' onClick=\"displayTreatment('" +
			  diseaseName + "')\">" +
			  (lifeThreatening ? "<font color='#FF0000'>" : "") +
			  printName + 
			  (lifeThreatening ? "</font>" : "") +
			  "</a></td>" +
			  */
			  "<img src='" + D.dot3Gif + "' height=8 width=" + ( accep ) +
			  /* need better incidence data ...
			  "> </td><td>" +
			  "<img src='" + D.dot3Gif + "' height=8 width=" + ( 32*frequency ) +
			  */
			  " /> </td>" +

			  ( clientId.equals("client") && notQuickie ?
			    "<td><a href=\"" + D.servletDiagAcceptDisease + 
			                      "?dis=" + diseaseName + "\">" +
			    (lifeThreatening ? "<font color=\"#FF0000\">" : "") +
			    // "accept" + 
			    L.Accept +
			    (lifeThreatening ? "</font>" : "") + "</td>" :
			    "") + // here the cc-version
			  "</tr>");
	  }
	  out.println("</table></center>" +
		      "<font color=\"#FF0000\" SIZE=\"+1\">" +
		      "<b>" + 
		      // "Warning!! The listed diseases as well as the support levels " +
		      // "are based on the " +
		      L.Diag2S9 +
		      " <i>" + L.limited + "</i> " +
		      // "'knowledge' in this program" +
		      L.Diag2S10 +
		      "</b>" +
		      "</font>");
	}
  } // end displayDiseases(ServletOutputStream out, Vector diseases)

      /*
	Extended diseases are looked for only when the topRate == 1.
	Let d be the disease that has the topRate == 1.
	An extended disease:
	- has no rejected symptom
	- has all the confirmed symptoms of d
	- does not have an acceptanceRate == 1
       */
    static public void findExtendedDiseases(Vector diseases, 
					    Vector extendedDiseases,
					    int index) {
	int lng = diseases.size();
	if ( lng == index ) return;
	DiseaseInst di = (DiseaseInst)diseases.elementAt(index);
	float topRate = di.getAcceptanceRate();
	if ( topRate < 1 ) return;
	Vector confirmedSymptoms = di.getInSymptoms();
	int lng2 = confirmedSymptoms.size();
	int lngTest = index + 6; // candidates are close to the top
	if ( lng < lngTest ) lngTest = lng;

	for (int i = index + 1; i < lngTest; i++) {
	    di = (DiseaseInst) diseases.elementAt(i);
	    if ( 1 <= di.getAcceptanceRate() ) continue; // cannot improve
	    if ( 0 < di.getOutSymptoms().size() ) continue; // cannot increase to 1
	    boolean allIncluded = true;
	    Vector confirmedSymptomsDi = di.getInSymptoms();
	    for ( int j = 0; j < lng2; j++ ) {
		WeightedSymptom ws = (WeightedSymptom) confirmedSymptoms.elementAt(j);
		if ( !ws.containedIn(confirmedSymptomsDi) ) {
		    allIncluded = false;
		    break;
		}
	    }
	    if ( allIncluded ) extendedDiseases.addElement(di);
	}
	findExtendedDiseases(diseases, extendedDiseases, index + 1);
    } // end of findExtendedDiseases( ... )



} // end Diag2 

/*  
// Example how to display exceptions
	 } catch (Exception ex) {
	   res.setContentType("text/html");
	   ServletOutputStream outx = res.getOutputStream();
	   outx.println("<html>");
	   outx.println("<head><title>Diag2 Exception</title></head>");
	   outx.println("<body bgcolor=\"red\">");
	   outx.println("<h1>Diag2/ 1st block </h1>");
	   outx.println("Trace: " + trace);
	   outx.println("Exception: " + ex.toString());
	   outx.println("<pre>");
	   PrintStream ps = new PrintStream(outx);
	   ex.printStackTrace(ps);
	   outx.println("</pre>");
	   outx.println("</body>");
	   outx.println("</html>");
	   return;
	 }
*/


