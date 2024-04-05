// (C) OntoOO Inc 2004 Mar
package phone;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.L;
import com.D;
import misc.DB;
import misc.SortableSymptom;
import patient.DiseaseInst;
import patient.TestSymptoms;
import misc.DiagStackEntry;
import concepts.Disease;
import concepts.Symptom;
import concepts.Location;
import concepts.WeightedSymptom;
import concepts.BodySystem; // ???
import patient.Diag2;

public class AskMoreSymptoms extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {

	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    PhoneError.call(res, "bevocal", 
			    //"Your session expired while in Ask More Symptoms."
			    L.AskMoreSymptoms1
			    );
	    return;
	}

	String aSymptomName = req.getParameter("answer");

	call(req, res, session, aSymptomName);
    }
    
    static public void call(HttpServletRequest req, HttpServletResponse res, 
			    HttpSession session, String aSymptomName)
	throws IOException {

	// We check first whether we can transfer the call right away
	String state = (String) session.getValue("state");
	if ( state.equals("transfer") ) {
	    session.putValue("state", "transferred");
	    String phoneNumber = (String) session.getValue("phoneNumber");
	    // to deal with different speech sites:
	    String host = (String) session.getValue("host");

	    String xml = 

"<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +

	    ( host.equals("bevocal") ?
"<!DOCTYPE vxml PUBLIC \"-//BeVocal Inc//VoiceXML 2.0//EN\" \n" + 
"	  \"http://cafe.bevocal.com/libraries/dtd/vxml2-0-bevocal.dtd\"> \n" +
"<vxml version=\"2.0\"  xmlns=\"http://www.w3.org/2001/vxml\"> \n" 
	      :
"<!DOCTYPE vxml PUBLIC '-//Nuance/DTD VoiceXML 1.0//EN' \n" +
"          'http://voicexml.nuance.com/dtd/nuancevoicexml-1-2.dtd'> \n" +
"<vxml version=\"2.0\"> \n" );
	    xml = xml +
" <form> \n" +
" <block> \n" +
"    <prompt> \n" +
//"       You will now be transferred to a physician in the call center. \n" +
L.AskMoreSymptoms2 + " \n" +

"    </prompt> \n" +
" </block> \n" +
" <transfer dest=\"tel:" + phoneNumber + "\" bridge=\"false\"/> \n" +
" </form> \n" +
"</vxml>";
	    res.setContentType("application/voicexml+xml");
	    ServletOutputStream out = res.getOutputStream();

	    out.println(xml);
	    return;
	}

	// We did NOT transfer the call, thus back to business::

	Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");
	String page = "phone.AskMoreSymptoms";
	String currentPage = (String) session.getValue("page");
	if ( !page.equals(currentPage) ) {
	    session.putValue("page", page);
	    Integer pageCnt = (Integer) session.getValue("pageCnt");
	    pageCnt = new Integer(1+ pageCnt.intValue());
	    session.putValue("pageCnt", pageCnt);
	    unboundHashtable.put("pageCnt", pageCnt);
	}
	Integer surfCnt = (Integer) session.getValue("surfCnt");
	surfCnt = new Integer(1+ surfCnt.intValue());
	
	session.putValue("surfCnt", surfCnt);
	unboundHashtable.put("surfCnt", surfCnt);

	// if we arrive here for the first time the location focus is just body and we have one symptom !! 
	// we are going to ask the client whether other symptoms are present as well 
	Vector diagStack = (Vector) session.getValue("diagStack");
	DiagStackEntry dse = (DiagStackEntry) diagStack.elementAt(0);

	// diag2 fragment
      DB props = (DB) session.getValue("theDB");
      String statusCondition = props.getProperty("statusCondition");

      //  Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");
      Integer ageInt = (Integer) session.getValue("ageInt");
      int age = ageInt.intValue();
      String gender = (String) session.getValue("gender");

      boolean sourceIsAskSymptom = ( null != aSymptomName );

      Vector newInSymptoms = new Vector();
      Vector newAllSymptoms = dse.getNewAllSymptomsVec();
      if ( sourceIsAskSymptom ) {
	  newInSymptoms.addElement(aSymptomName);
	  newAllSymptoms.addElement(aSymptomName);

	  // Lets set up the focus search as in diag1c
	  // This is risky indeed because we rely on a single symptom!
	      HashSet D1 = (HashSet) session.getValue("D1"); // all diseases
	      HashSet D2 = new HashSet();
	      Symptom sym = Common.getSymptom(aSymptomName);
	      Vector theDiseases = sym.getTheDiseases();
	      int lng2 = theDiseases.size();
	      for (int j = 0; j < lng2; j++) {
		  String diseaseName = (String) theDiseases.elementAt(j);
		  if ( !D1.contains(diseaseName) ) continue; // gender check
		  D2.add(diseaseName);
	      }
	      dse.setD2(D2);
      } else {
	  int lng = newAllSymptoms.size();
	  String symptomName;
	  String value;
	  for (int i = 0; i < lng; i++) {
	      symptomName = (String) newAllSymptoms.elementAt(i);
	      value = req.getParameter(symptomName);
	      if ( value != null && value.equals("true") ) newInSymptoms.addElement(symptomName);
	  }
      }

      Vector newOutSymptoms = new Vector();
      // newOutSymptoms = newAllSymptoms - newInSymptoms 
      int lng = newAllSymptoms.size();
      String token;
      for (int i = 0; i < lng; i++) {
	token = (String) newAllSymptoms.elementAt(i);
	if ( !newInSymptoms.contains(token) ) 
	    newOutSymptoms.addElement(token);
      }

      Float tsFloat = (Float) session.getValue("tsFloat");
      float temperature = tsFloat.floatValue();
      String weight = (String) session.getValue("weight");
      String duration = (String) session.getValue("duration");

      // access more values on the stack here
      Vector locations = (Vector) dse.getLocations();
      Vector systems = (Vector) dse.getSystems();
      String bodyPart = dse.getBodyPart();
      String system = dse.getSystem();

      Vector selectedSymptoms = (Vector) dse.getSelectedSymptoms();
      HashSet notSelectedSymptoms = (HashSet) dse.getNotSelectedSymptoms();

      Vector diseases = (Vector) dse.getDiseases(); // ie DiseaseInst

      /*
      lng = diseases.size();
      for ( int i = 0; i < lng; i++ ) {
	  DiseaseInst di = (DiseaseInst) diseases.elementAt(i);
	  diseases.setElementAt(di.copy(), i);
      }
      Vector expertDiseases = (Vector) session.getValue("expertDiseases");
      */

      // TestSymptoms elements are SortableSymptom that have not yet been used
      TestSymptoms testSymptoms= (TestSymptoms) dse.getTestSymptoms();

      // iteration++;

      // did the user narrow the location?
      boolean bodyPartNarrowed = false;
      // bodyPartNarrowed = (null != bodyPart) && (!locations.contains(bodyPart));

      // did the user narrow the system ??
      boolean systemNarrowed = false;
      // systemNarrowed = (null != system) && (!systems.contains(system));

      DiseaseInst di;
      /*
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
      */

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
	    // if ( Common.isDiseaseMember(diseaseName, newExpertDiseases) ) continue;
	    disease = Common.getDisease(diseaseName);
	    if ( age < disease.getMinAge() || disease.getMaxAge() < age ) continue;
	    diseaseStatusCondition = disease.getStatusCondition();
	    if ( !diseaseStatusCondition.equals("none") ) {
	      // check whether the client matches the statusCondition
	      if ( !diseaseStatusCondition.equals(statusCondition) &&
		   // perhaps the client does not know she is pregnant
		   !diseaseStatusCondition.equals("pregnant") ) continue; 
	    }
	    di = new DiseaseInst(diseaseName, temperature, "AskMoreSymptoms", gender, age, surfCnt);
	    di.requalify(selectedSymptoms, notSelectedSymptoms);
	    newInSymptomsDiseases.addElement(di);
	  }
	}
	// put new selectedSymptoms in unboundHashtable:
	unboundHashtable.put("selectedSymptoms", selectedSymptoms);
      }

      /*
      // Generate additional disease if systemNarrowed
      Vector newSystemDiseases = new Vector(); // elements are DiseaseInst
      if ( systemNarrowed ) {
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
	  for (int j=0; j<associatedDiseases.size(); j++) {
	    diseaseName = (String) associatedDiseases.elementAt(j);
	    if ( !D1.contains(diseaseName) ) continue;
	    if ( Common.isDiseaseMember(diseaseName, newSystemDiseases) ) continue;
	    if ( Common.isDiseaseMember(diseaseName, diseases) ) continue;
	    // if ( Common.isDiseaseMember(diseaseName, newExpertDiseases) ) continue;
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
	    di = new DiseaseInst(diseaseName, temperature, "Diag2", gender, age);
	    di.requalify(selectedSymptoms, notSelectedSymptoms);
	    newSystemDiseases.addElement(di);
	  }
	}
      }
      */

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

      /*
      // Requalify *newExpertDiseases* against newInSymptoms & newOutSymptoms
      lng = newExpertDiseases.size();
      if ( 0<lng ) {
	for (int i = 0; i < lng; i++) {
	  di = (DiseaseInst) newExpertDiseases.elementAt(i);
	  di.requalify(newInSymptoms, newOutSymptoms);
	  diseases.addElement(di);
	} 
      }
      */

      /*
      // Requalify *newSystemDiseases* against newInSymptoms & newOutSymptoms
      lng = newSystemDiseases.size();
      if ( 0<lng ) {
	for (int i = 0; i < lng; i++) {
	  di = (DiseaseInst) newSystemDiseases.elementAt(i);
	  di.requalify(newInSymptoms, newOutSymptoms);
	  diseases.addElement(di);
	} 
      }
      */

      // Requalify *newInSymptomsDiseases* against newInSymptoms & newOutSymptoms
      lng = newInSymptomsDiseases.size();
      if ( 0<lng ) {
	for (int i = 0; i < lng; i++) {
 	  di = (DiseaseInst) newInSymptomsDiseases.elementAt(i);
	  di.requalify(newInSymptoms, newOutSymptoms);
	  diseases.addElement(di);
	} 
      }

      newAllSymptoms.removeAllElements();
      newInSymptoms.removeAllElements();
      newOutSymptoms.removeAllElements();

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
      if ( 0 < lng ) {
	Collections.sort(diseases);
	// **************************
	// we can terminate if the first element has sufficient support ....
	// **************************
	di = (DiseaseInst)diseases.elementAt(0);
	topRate = di.getAcceptanceRate();
	if ( 1 == topRate ) Diag2.findExtendedDiseases(diseases, extendedDiseases, 0);
	if ( 1 == lng ) 
	  session.putValue("diagnosis", "" + topRate);
	else {
	  di = (DiseaseInst)diseases.elementAt(1);
	  float nextRate = di.getAcceptanceRate();
	  session.putValue("diagnosis", 
			   ( topRate == nextRate ? "ambiguity-" : "" ) +
			   topRate);
	}
	  

	float acceptanceRate = 0;
	float ar;
	for (int i = 0; i < lng; i++) {
	  di = (DiseaseInst) diseases.elementAt(i);
	  ar = di.getAcceptanceRate();
	  if ( (acceptanceRate < ar) && di.isLifeThreatening() ) {
	    acceptanceRate = ar;
	  } 
	}
	if ( 0 < acceptanceRate )
	  session.putValue("foundLifeThreateningDisease", "" + acceptanceRate);

	// saving the disease conjectures
	StringBuffer sb = new StringBuffer();
	for (int i = 0; i < lng; i++) {
	  di = (DiseaseInst) diseases.elementAt(i);
	  String name = di.getDisease();
	  sb.append(name + "|");
	}
	unboundHashtable.put("diseaseConjectures", sb.toString());
      }
    

      // ************************************
      // ************************************
      // termination condition must change
      // also consider asking for relevant locations 
      // ************************************
      // ************************************

      boolean globalSymptoms = false;

      if ( topRate < 1 ) { 
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
	if ( bodyPartNarrowed ) {
	  // will generate option to further narrow down - if possible
	  locations = (Vector) locations.clone();
	  locations.addElement(bodyPart);
	  // a location has associated symptoms as well as subsystems 
	  // (which have diseases) Fow now we ignore the subsystems ...

	  if ( !bodyPart.equals("unspecified") ) {
	      unboundHashtable.put("bodyPart", bodyPart);
	      Location loc = Common.getLocation(bodyPart);
	      Vector symptomsOfLoc = loc.getSymptoms();
	      testSymptoms.addSymptoms(symptomsOfLoc, "bodyPartNarrowed",
				       S1, notSelectedSymptoms, selectedSymptoms);
	  }
	}
	  */

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
      } else // 1 == topRate
      if ( 0 < extendedDiseases.size() ) 
	testSymptoms.addSymptomsFromDiseases(extendedDiseases, "boostedDiseases", 
					     S1, notSelectedSymptoms, selectedSymptoms);
      // end of creating testSymptoms elements
	
      // Notice: even when globalSymptoms = true testSymptoms may still be empty!!

      /*
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

      if ( diagStack.size() <= iteration )
	diagStack.addElement(dse2);
      else
	diagStack.setElementAt(dse2, iteration);
      session.putValue("iter", "" + iteration); // for DisplayDiseaseInst
      */

      // end of diag2 fragment

      if ( 0 == testSymptoms.size() || ( 1 == topRate && 0 == extendedDiseases.size() ) ) {
	  // we cant ask more questions or no need to ask more questions 
	  PhoneWait.call(res, session, "0");
	  return;
      }

      // generate a list of symptoms to be presented to the caller
      	  Vector orderedSortedSymptoms =
	      testSymptoms.orderedTestSymptoms(diseases, notSelectedSymptoms, D1, false);
	  SortableSymptom ss;
	  String sympName;
	  int lng2 = ( lng < 5 ? lng : 5 ); // max # of test symptoms
	  Vector ts = new Vector();
	  for (int i = 0; i < lng2; i++) {
	      ss = (SortableSymptom) orderedSortedSymptoms.elementAt(i);
	      sympName = ss.getSympName();
	      testSymptoms.remove(sympName);
	      ts.addElement(sympName);
	      newAllSymptoms.addElement(sympName);
	  }

	  StringBuffer sb = new StringBuffer();
	  for (int i = 0; i < lng2; i++) {
	      sympName = (String) ts.elementAt(i);
	      Symptom sym = Common.getSymptom(sympName);
	      String printName = sym.getPrintName();
	      String description = sym.getDescription();
	      sb.append("<field name=\"" + sympName + "\" type=\"boolean\"> \n");
	      sb.append("<help>" +
			// "Do you have the symptom:" +
			L.AskLocDrivenSymptoms2 +
			" \"" + printName + "\" " +
			// "described by" +
			L.AskLocDrivenSymptoms3 +
			" \"" + description + "\"? </help> \n");
	      sb.append("<prompt>" +
			// "Do you have the symptom:" +
			L.AskLocDrivenSymptoms2 +
			" \"" + description + "\"? </prompt> \n");
	      sb.append("<filled> <if cond=\"(" + sympName + " == true)\"> \n");
	      sb.append("            <prompt>" +
			                 // "Got it: you do have" +
			                 L.AskLocDrivenSymptoms4 +
			                 " \"" + description + "\" </prompt> \n");
	      sb.append("         </if> \n");
	      sb.append("</filled> \n");
	      sb.append("</field> \n");
	  }
	  sb.append("<block>" +
		    // "OK, will get the next batch of questions, if any." + 
		    L.AskLocDrivenSymptoms5 +
		    "\n");
	  sb.append("<submit next=\"" + D.servletAskMoreSymptoms + "\" \n ");
	  sb.append("    method=\"get\" fetchtimeout=\"60s\" \n namelist=\"");
	  lng = ts.size();
	  for (int i = 0; i < lng; i++) sb.append( (String)ts.elementAt(i) + " ");
	  sb.append("\" /> \n");
	  sb.append("</block> \n");

	  String questions = sb.toString();

	  //+++++++++++++++++++++

      if ( globalSymptoms ) testSymptoms.clear();

	String host = (String) session.getValue("host");

	String traceInfo = ""; // "" or a block

	String logName = (String) session.getValue("logName");
	if ( logName.equals("phonetest") ) {
	    sb = new StringBuffer();
	    lng = diseases.size();
	    lng2 = ( lng < 5 ? lng : 5 );
	    for (int i = 0; i < lng2; i++ ) {
		di = (DiseaseInst) diseases.elementAt(i);
		String name = di.getDisease();
		Disease dis = Common.getDisease(name);
		String pn = dis.getPrintName();
		float ar = di.getAcceptanceRate();
		boolean bool = di.isLifeThreatening();
		sb.append(
			  // "The disease " + 
			  L.AskMoreSymptoms3 +
			  pn + 
			  // " has the rating: " +
			  L.AskMoreSymptoms4 +
			  "<say-as interpret-as=\"number\"> " + ar + " </say-as>. ");
		if ( bool ) 
		    sb.append(
			      //"The disease " + 
			      L.AskMoreSymptoms3 +
			      pn + 
			      //" is life threatening. "
			      L.AskMoreSymptoms5
			      );
	    }

	    traceInfo = 
"<block><prompt> \n" +
// "Start tracing info. " +
L.AskMoreSymptoms6 +
	    ( lng <= 0 ?
// "There are no disease conjectures yet." 
L.AskMoreSymptoms7
	      :
// "The rating of the disease conjecture with most support is still " +
// "less than one.  The system has now found ";
L.AskMoreSymptoms8 +
"<say-as interpret-as=\"number\"> " + lng + " </say-as> " + 
// "disease conjectures. " +
// "Here some top disease conjectures: " +
L.AskMoreSymptoms9 +
sb.toString() + ". " +
// "Currently, the system will continue asking for symptoms " +
// "until one of the disease conjectures has full support. " +
// "Just hang up if you can not achieve this termination condition. " 
L.AskMoreSymptoms10
	      ) +
// "End tracing info. \n" +
L.AskMoreSymptoms11 + " \n" +
"</prompt></block> \n";
	} // end of: if ( logName.equals("phonetest") )

	String xml = 
"<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +

	    ( host.equals("bevocal") ?
	      L.vxml1
	      :
	      L.vxml2 ) +

" <property name=\"universals\" value=\"all\" /> \n" +
" <help>" +
  // I'm sorry. There's no help available here.
  L.noHelp +
"</help> \n" +
" <noinput>" +
  //I'm sorry. I didn't hear anything. \n" +
  L.silence +
"   <reprompt/> \n" +
" </noinput> \n" +
" <nomatch>" +
  // I didn't get that. \n" +
  L.nomatch +
"   <reprompt/> \n" +
" </nomatch> \n" +
"<form>" +
traceInfo +
questions +
"</form>" +
"</vxml>";


	res.setContentType("application/voicexml+xml");
	ServletOutputStream out = res.getOutputStream();

	out.println(xml);

    }
}






