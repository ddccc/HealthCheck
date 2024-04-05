// Copyright OntoOO Inc, 2003 Oct
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.LR;
import com.Common;
import com.DV;
import com.D;
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
import patient.DiseaseInst;
import patient.TestSymptoms;
import patient.Diag2;


public class Simulation extends HttpServlet {

    static private String statusConditionX = null;
    static private int ageX = 0;
    static private String genderX = null;
    static private HashSet S1X = null;


    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allDiseases = Common.allDiseases();
      int lng = allDiseases.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Simulation</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=\"lightgreen\">");
      out.println("<H1>Simulation, # diseases= " + lng + "</H1>");
      String dis, printName;
      Disease disease;
      Vector symptoms;
      int lngSymptoms;
      out.println("<table Border>");
      // set up counters
      int super1 = 0;
      int temp = 0;
      int nosymps = 0;
      int zeroIndex = 0;
      int posIndex = 0;
      int negIndex = 0;

      int iterationSum = 0;
      int numRejectedSum = 0;
      int indexSum = 0;

      for (int i = 0; i < lng; i++) {
	dis = allDiseases[i];
	disease = Common.getDisease(dis);
	out.println(
	     "<tr><td>" + 
	     "<A HREF='" + D.servletShowDisease + "?dis=" + dis + "'>" + dis + "</A></td><td>");

	String comment = disease.getMiscComments();
	if ( null != comment && comment.startsWith("** temp") ) {
	    temp++;
	    out.println(
		"<font color='0000ff'>** temp</font></td></tr>");
	    continue;
	}

	if ( disease.isSuperDisease() ) {
	    super1++;
	    out.println(
			"<font color='0000ff'>Super disease</font></td></tr>");
	    continue;
	}

	symptoms = disease.getSymptoms();
	lngSymptoms = symptoms.size();
	if ( 0 == lngSymptoms ) {
	    if ( disease.isSuperDisease() ) { // already filtered out
		super1++;
		out.println(
		   "<font color='0000ff'>Super disease</font></td></tr>");
	    } else {
		nosymps++;
		out.println(
		    "<font color='ff0000'># symptoms = 0 </font></td></tr>");
	    }
	    continue;
	}

	statusConditionX = disease.getStatusCondition();
	ageX = disease.getMinAge();
	genderX = disease.getGenderSpecificity();

	Vector locations = new Vector();
	Vector systems = new Vector();
	Vector selectedSymptoms = new Vector();
	WeightedSymptom ws = (WeightedSymptom) symptoms.elementAt(0);
	String symp = ws.getSymptom();
	Vector newInSymptoms = new Vector();
	newInSymptoms.addElement(symp);
	HashSet notSelectedSymptoms = new HashSet();
	Vector diseases = new Vector(); // instances of DiseaseInst
	DiagStackEntry dse = new DiagStackEntry(
		locations,
		systems,
		selectedSymptoms,
		notSelectedSymptoms,
		diseases);
	dse.setBodyPart("unspecified");
	dse.setSystem("unspecified");
	TestSymptoms testSymptoms = new TestSymptoms(ageX, statusConditionX);
	dse.setTestSymptoms(testSymptoms);

	dse.setNewInSymptomsVec(newInSymptoms);
	dse.setNewAllSymptomsVec(newInSymptoms);

	// set the collection of diseases to be investigated
	// HashSet D1 = (HashSet) session.getValue("D1"); // all diaseases

	HashSet D1 = null;
	if ( genderX.equals(LR.female) ) D1 = Common.allFemaleDiseases(); else
	    D1 = Common.allMaleDiseases();
	dse.setD2(D1);
	if ( genderX.equals(LR.female) ) S1X = Common.allFemaleSymptoms(); else
	    S1X = Common.allMaleSymptoms();

	// out.println("TEST " + D1.size() + " " + S1X.size() + "</td><td>");

	// do the simulation
	OutObj outObj = foo(disease, 1, dse, out);

	String status = outObj.getStatus();
	int iteration = outObj.getIteration();
	int index = outObj.getIndex();
	String indexStr = "" + index;
	float indexRate = outObj.getIndexRate();
	int numRejected = outObj.getNumRejected();
	if ( indexRate < 1 ) status = "<font color='ff0000'>" + status + "</font>";
	if ( index < 0) {
	    indexStr = "<font color='ff0000'>" + indexStr + "</font>";
	}
	out.println(
	     status + "</td><td> " + 
	     iteration + "</td><td> " + 
	     indexStr + "</td><td> " + 
	     indexRate + "</td>");
	if ( 0 == index ) { 
	    zeroIndex++;
	    iterationSum = iterationSum + iteration;
	    numRejectedSum = numRejectedSum + numRejected;
	    out.println("</tr>"); 
	    continue; 
	}
	out.println("<td>");
	if ( 0 < index ) { 
	    posIndex++; 
	    iterationSum = iterationSum + iteration;
	    numRejectedSum = numRejectedSum + numRejected;
	    indexSum = indexSum + index;
	} else negIndex++;
	Vector diseaseNames = outObj.getDiseaseNames();
	int lng2 = diseaseNames.size();
	for (int j = 0; j < lng2; j++) {
	    String dis2 = (String) diseaseNames.elementAt(j);
	    out.println("<br><A HREF='" + D.servletShowDisease + 
			                  "?dis=" + dis2 + "'>" + dis2 + "</A>");
	}
	out.println("</tr>");
      }
      out.println("</table>");

      out.println(
	  "<h3>total: " + lng +
	  " zeroIndex: " + zeroIndex +
	  " super1: " + super1 +
	  " temp: " + temp +
	  " posIndex: " + posIndex +
	  " negIndex: " + negIndex + "</h3>");

      int success = zeroIndex + posIndex;
      
      float iterationAvg = 
	  ( 0 < success ? (iterationSum + 0.0f)/ success : 0);
      float numRejectedAvg = 
	  ( 0 < success ? (numRejectedSum + 0.0f)/ success : 0);
      float indexAvg = 
	  ( 0 < success ? (indexSum + 0.0f)/ success : 0);

      out.println(
	  "<h3>success: " + success +
	  " iterationAvg: " + iterationAvg + 
	  " numRejectedAvg: " + numRejectedAvg + 
	  " indexAvg: " + indexAvg + "</h3>");

      out.println("</BODY>");
      out.println("</HTML>");
    } // doGet


static private OutObj foo(Disease diseaseX, int iteration, 
			  DiagStackEntry dse, ServletOutputStream out) 
                   throws IOException {
      // out.println("TEST iteration " + iteration);

      String statusCondition = statusConditionX;

      int age = ageX;

      Vector newInSymptoms = dse.getNewInSymptomsVec();
      Vector newAllSymptoms = dse.getNewAllSymptomsVec();
      // out.println("TEST newInSymptoms: " + newInSymptoms.size() + "<br>");


      Vector newOutSymptoms = new Vector();
      // newOutSymptoms = newAllSymptoms - newInSymptoms 
      int lng = newAllSymptoms.size();
      String token;
      for (int i = 0; i < lng; i++) {
	token = (String) newAllSymptoms.elementAt(i);
	if ( !newInSymptoms.contains(token) ) 
	    newOutSymptoms.addElement(token);
      }
      /*
      Float tsFloat = (Float) session.getValue("tsFloat");
      float temperature = tsFloat.floatValue();
      String weight = (String) session.getValue("weight");
      String duration = (String) session.getValue("duration");
      */
      float temperature = 99.7f;

      // access more values on the stack here
      Vector locations = (Vector) dse.getLocations().clone();
      Vector systems = (Vector) dse.getSystems().clone();
      String bodyPart = dse.getBodyPart();
      String system = dse.getSystem();

      Vector selectedSymptoms = (Vector) dse.getSelectedSymptoms().clone();
      HashSet notSelectedSymptoms = (HashSet) dse.getNotSelectedSymptoms().clone();

      Vector diseases = (Vector) dse.getDiseases().clone(); // ie DiseaseInst
      lng = diseases.size();
      for ( int i = 0; i < lng; i++ ) {
	  DiseaseInst di = (DiseaseInst) diseases.elementAt(i);
	  diseases.setElementAt(di.copy(), i);
      }
      Vector expertDiseases = new Vector(); // (Vector) session.getValue("expertDiseases");

      // TestSymptoms elements are SortableSymptom that have not yet been used
      TestSymptoms testSymptoms= (TestSymptoms) dse.getTestSymptoms().clone();

      iteration++;

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
	// unboundHashtable.put("notSelectedSymptoms", notSelectedSymptoms);
      }

      HashSet S1 = S1X; // (HashSet) session.getValue("S1"); // all symptoms
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
	    di = new DiseaseInst(diseaseName, temperature, "Diag2");
	    di.requalify(selectedSymptoms, notSelectedSymptoms);
	    newInSymptomsDiseases.addElement(di);
	  }
	}
	// put new selectedSymptoms in unboundHashtable:
	// unboundHashtable.put("selectedSymptoms", selectedSymptoms);
      }

      // Generate additional disease if systemNarrowed
      Vector newSystemDiseases = new Vector(); // elements are DiseaseInst
      if ( systemNarrowed ) {
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
	  for (int j=0; j<associatedDiseases.size(); j++) {
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
	    di = new DiseaseInst(diseaseName, temperature, "Diag2");
	    di.requalify(selectedSymptoms, notSelectedSymptoms);
	    newSystemDiseases.addElement(di);
	  }
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
      /*
      if ( TRACING ) {
	trace += "<br>*** Passing E2 ...";
	lng = diseases.size();
	String dis;
	for (int i = 0; i < lng; i++) {
	  di = (DiseaseInst) diseases.elementAt(i); 
	  dis = di.getDisease();
	  trace += "<br><b>disease #:</b> " + i + ": " + dis + " " + di.getAcceptanceRate();
	}
      }
      */

      lng = diseases.size();
      // out.println("TEST diseases.size(): " + lng + "</td><td>");

      float topRate = 0;
      /*
	Extended diseases are looked for only when the topRate == 1.
	Let d be the disease that has the topRate == 1.
	An extended disease:
	- has no rejected symptom
	- has all the confirmed symptoms of d
	- does not have an acceptanceRate == 1
       */
      Vector extendedDiseases = new Vector();
      if ( 0< lng ) {
	Collections.sort(diseases);

	// **************************
	// we can terminate if the first element has sufficient support ....
	// **************************
	di = (DiseaseInst)diseases.elementAt(0);
	topRate = di.getAcceptanceRate();
	if ( 1 == topRate ) {
	    Diag2.findExtendedDiseases(diseases, extendedDiseases, 0);
	    if ( 0 == extendedDiseases.size() ) {
		String dis = diseaseX.getName();
		int index = -1;
		float indexRate = -1;
		Vector diseaseNames = new Vector();
		for (int i = 0; i < lng; i++) {
		    di = (DiseaseInst) diseases.elementAt(i);
		    token = di.getDisease();
		    if ( token.equals(dis) ) { 
			index = i;
			indexRate = di.getAcceptanceRate();
			break; }
		    diseaseNames.addElement(token);
		}
		return new OutObj("finished", index, indexRate, iteration, diseaseNames,
				  notSelectedSymptoms.size());
	    }
	}
      }

      /*    
      if ( TRACING ) {
	trace += "<br>*** Passing F ...";
      }
      */

      // ************************************
      // ************************************
      // termination condition must change
      // also consider asking for relevant locations 
      // ************************************
      // ************************************

      boolean globalSymptoms = false;

	// Searching for new testable symptoms 
	// investigate: newExpertDiseases, newSystemDiseases, narrowed locations
	// boostedDiseases, newInSymptomsDiseases, ...
	  /*
	testSymptoms.addSymptomsFromDiseases(newExpertDiseases,"newExpertDiseases", 
					     S1, notSelectedSymptoms, selectedSymptoms);

	testSymptoms.addSymptomsFromDiseases(newSystemDiseases,"newSystemDiseases",
					     S1, notSelectedSymptoms, selectedSymptoms);
	  */
	/*
	if ( TRACING ) {
	  trace += 
	    "<br>*** Passing I ..." +
	    "<br><b>bodyPartNarrowed:</b> " +  bodyPartNarrowed;
	}
	*/
	/*
	if ( bodyPartNarrowed ) {
	  // will generate option to further narrow down - if possible
	  locations = (Vector) locations.clone();
	  locations.addElement(bodyPart);
	  //   a location has associated symptoms as well as subsystems 
	  //   (which have diseases) Fow now we ignore the subsystems ...
	  if ( !bodyPart.equals("unspecified") ) {
	    Location loc = Common.getLocation(bodyPart);
	    Vector symptomsOfLoc = loc.getSymptoms();
	    testSymptoms.addSymptoms(symptomsOfLoc, "bodyPartNarrowed",
				     S1, notSelectedSymptoms, selectedSymptoms);
	  }
	}
	*/

        // out.println("TEST boostedDiseases.size(): " + boostedDiseases.size() + "</td><td>");

	testSymptoms.addSymptomsFromDiseases(boostedDiseases,"boostedDiseases",
					     S1, notSelectedSymptoms, selectedSymptoms);

	testSymptoms.addSymptomsFromDiseases(newInSymptomsDiseases,"newInSymptomsDiseases",
					     S1, notSelectedSymptoms, selectedSymptoms);

	lng = testSymptoms.size();
	if ( 0 == lng ) { 
	    globalSymptoms = true;
	    // get the most promissing from S1 - (selectedSymptoms + notSelectedSymptoms)
	    for (Iterator i = S1.iterator(); i.hasNext(); ) {
	        symptomName = (String) i.next();
		testSymptoms.addSymptom(symptomName, "none",
					S1, notSelectedSymptoms, selectedSymptoms);
	    }
	}
	
      // Notice: even when globalSymptoms = true testSymptoms may still be empty!!
      lng = testSymptoms.size();
      if ( 0 == lng ) return new OutObj("0 == testSymptoms", -1, -1, iteration, new Vector(), 0);

      
      Vector ts = new Vector();
      /*
      Vector orderedSortedSymptoms =
	      testSymptoms.orderedTestSymptoms(diseases, notSelectedSymptoms, D1, false);
      */

      Vector orderedSortedSymptoms = null;
	  if ( iteration < Diag2.iterationSwitch ) {
	      // use only the diseases that have all the selected symptoms
	      Vector filteredDiseases = new Vector();
	      int lngd = diseases.size();
	      // System.out.println("Diag2 diseases.size() " + lngd);
	      int lng3 = selectedSymptoms.size();
	      for ( int i = 0; i < lngd; i++ ) {
		  di = (DiseaseInst) diseases.elementAt(i);
		  Vector requiredSymptoms = di.getRequiredSymptoms();
		  Vector requiredSymptomNames = new Vector();
		  for ( int j = 0; j < requiredSymptoms.size(); j++ ) {
		      WeightedSymptom ws = (WeightedSymptom) requiredSymptoms.elementAt(j);
		      requiredSymptomNames.addElement(ws.getSymptom());
		  }
		  boolean allow = true;
		  for ( int j = 0; j < lng3; j++ ) {
		      String sympName = (String) selectedSymptoms.elementAt(j);
		      if ( ! requiredSymptomNames.contains(sympName) ) {
			  // System.out.println(di.getDisease() + " has not " + sympName);
			  allow = false; break;
		      }
		  }
		  if ( allow ) filteredDiseases.addElement(di);
	      }
	      // System.out.println("Diag2 iteration " + iteration +
	      //		    " filteredDiseases.size() " + filteredDiseases.size());
	      orderedSortedSymptoms =
		  testSymptoms.orderedTestSymptoms(filteredDiseases, notSelectedSymptoms, D1, true);

	      // System.out.println("Diag2 orderedSortedSymptoms.size() " +
	      //		    orderedSortedSymptoms.size());

	      if ( 0 == orderedSortedSymptoms.size() ) // defensive
		  orderedSortedSymptoms =
		      testSymptoms.orderedTestSymptoms(diseases, notSelectedSymptoms, D1, false);
	  } else 
	      orderedSortedSymptoms =
		  testSymptoms.orderedTestSymptoms(diseases, notSelectedSymptoms, D1, false);

      SortableSymptom ss;
      String sympName;
      int lng2 = ( lng < 20 ? lng : 20 ); // max # of test symptoms
      for (int i = 0; i < lng2; i++) {
	  ss = (SortableSymptom) orderedSortedSymptoms.elementAt(i);
	  sympName = ss.getSympName();
	  testSymptoms.remove(sympName);
	  ts.addElement(sympName);
      }

      Vector newInSymptoms2 = new Vector();
      Vector newAllSymptoms2 = ts;
      Vector symptoms = diseaseX.getSymptoms();
      int lng3 = symptoms.size();
      for (int i = 0; i < lng2; i++) {
	  sympName = (String) ts.elementAt(i);
	  for (int j = 0; j < lng3; j++) {
	      WeightedSymptom ws = (WeightedSymptom) symptoms.elementAt(j);
	      String symp = ws.getSymptom();
	      if ( symp.equals(sympName) ) {
		  newInSymptoms2.addElement(symp);
		  break;
	      }
	  }
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

      dse2.setNewInSymptomsVec(newInSymptoms2);
      dse2.setNewAllSymptomsVec(newAllSymptoms2);

      return foo(diseaseX, iteration, dse2, out);
}

} // class simulation


class OutObj {
    private String status;
    private int index;
    private float indexRate;
    private int iteration;
    private Vector diseaseNames;
    private int numRejected;
    OutObj(String status, int index, float indexRate, int iteration, Vector diseaseNames,
	   int numRejected) {
	this.status = status;
	this.index = index;
	this.indexRate = indexRate;
	this.iteration = iteration;
	this.diseaseNames = diseaseNames;
	this.numRejected = numRejected;
    }
    public String getStatus() { return status; }
    public int getIndex() { return index; }
    public float getIndexRate() { return indexRate; }
    public int getIteration() { return iteration; }
    public Vector getDiseaseNames() { return diseaseNames; }
    public int getNumRejected() { return numRejected; }

} // end OutObj

