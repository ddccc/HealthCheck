// (C) OntoOO Inc 2002
package patient;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import com.Common;
import com.DV;
import com.DVM;
import com.D;
import com.L;
import com.LR;
import misc.DB;
import misc.DiagStackEntry;
import concepts.BodySystem;
import concepts.Disease;
import concepts.Location;
import concepts.LocationSet;
import concepts.PartOfLocation;
import concepts.LocationRelation;
import concepts.Symptom;
import concepts.XWord;
import concepts.Drug;
import misc.SessionExpired;
import patient.DiagStart;

public class Diag1b extends HttpServlet {
    public static final String popupDisplaySymptom =
	  "<script language= \"JavaScript\"> \n" +
	  "function displaySymptom(sym) {\n " +
	  "  symptomWindow = open( \n" +
	  "    \"" + D.servletShowSymptom + "?sym=\"+sym, \n" +
	  "    \"symptomWindowName\", " +
	  "    \"resizable=yes,scrollbars=yes,height=300,width=600\") \n" +
	  "}\n" +
	  "</script>\n ";
    public static final String popupDisplayDisease =
	  "<script language= \"JavaScript\"> \n" +
	  "function displayDisease(dis) {\n " +
	  "  diseaseWindow = open( \n" +
	  "    \"" + D.servletShowDisease + "?dis=\"+dis, \n" +
	  "    \"diseaseWindowName\", " +
	  "    \"resizable=yes,scrollbars=yes,height=300,width=600\") \n" +
	  "}\n" +
	  "</script>\n ";
    public static final String popupDisplaySystem =
	  "<script language= \"JavaScript\"> \n" +
	  "function displaySystem(bs) {\n " +
	  "  systemWindow = open( \n" +
	  "    \"" + D.servletShowBodySystem + "?bs=\"+bs, \n" +
	  "    \"systemWindowName\", " +
	  "    \"resizable=yes,scrollbars=yes,height=300,width=600\") \n" +
	  "}\n" +
	  "</script>\n ";
    public static final String popupDisplayDrug =
	  "<script language= \"JavaScript\"> \n" +
	  "function displayDrug(drug) {\n " +
	  "  drugWindow = open( \n" +
	  "    \"" + D.servletShowDrug + "?drug=\"+drug, \n" +
	  "    \"drugWindowName\", " +
	  "    \"resizable=yes,scrollbars=yes,height=300,width=600\") \n" +
	  "}\n" +
	  "</script>\n ";


    private static final boolean expert = DV.expert;

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      HttpSession session = req.getSession(false);
      if ( null == session ) {
	    SessionExpired.call(res,
				DV.Diag1b);
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

      // access values on the stack here
      Vector diagStack = (Vector) session.getValue("diagStack");
      DiagStackEntry dse = (DiagStackEntry) diagStack.elementAt(iteration);
      String bodyPart = dse.getBodyPart();
      String system = dse.getSystem();

      Vector checkConcepts = (Vector) session.getValue("checkConcepts");
      // using vectors below would have been easier ...
      String allSymptoms = "";
      String allLocations = "";
      String allSystems = "";
      String allDiseases = "";
      String allUnknowns = "";

      int lng = checkConcepts.size();
      if ( 0 < lng ) {
	  // System.out.println("***Diag1b CheckConcepts: " + checkConcepts.toString());
	HashSet S1 = (HashSet) session.getValue("S1"); // all symptoms
	// HashSet D1 = (HashSet) session.getValue("D1"); // all diaseases
	HashSet D1 = dse.getD2(); // collection of diseases investigated, a subset of D1

	for (int i = 0; i < lng; i++) {
	  XWord xword = (XWord) checkConcepts.elementAt(i);
	  String type = xword.getType();
	  String token = xword.getName();
	  if ( type.equals("Symptom") ) {
	    if ( !S1.contains(token) ) continue; // gender check
	    allSymptoms += "," + token;
	    continue;
	  }
	  if ( type.equals("Location") ) {
	    allLocations += "," + token;
	    continue;
	  }
	  if ( type.equals("BodySystem") ) {
	    allSystems += "," + token;
	    continue;
	  }
	  if ( type.equals("Disease") ) {
	    if ( !D1.contains(token) ) continue; // gender check
	    allDiseases += "," + token;
	    continue;
	  }
	  allUnknowns += "," + token;
	}
	// System.out.println("***Diag1b allSymptoms: " + allSymptoms);
      }

	DB props = (DB) session.getValue("theDB");
	String statusCondition = props.getProperty("statusCondition");
	String gender = props.getProperty("gender");

	Vector newInSymptomsVec = dse.getNewInSymptomsVec();
	/*  System.out.println("Diag1b: " +  
			   newInSymptomsVec.size() + "\n" +
			   newInSymptomsVec.toString()   );  */

	String usedDrugs = props.getProperty("drugs_used");
	/* new symptoms are in newInSymptomsVec and/or in allSymptoms
	   List all symptom/drug combinations where a symptom is a
	   (severe) side-effect of the taken drug & write them all 
	   in the record. 
	   Urge to terminate the session or at least remove them below
	*/
	Vector drugEffects = new Vector();  // regular side effect
	Vector drugEffects2 = new Vector(); // critical side effect
	lng = newInSymptomsVec.size();
	if ( null != usedDrugs && !usedDrugs.equals("") &&
	     ( 0 < lng || !allSymptoms.equals("") ) ) {
	    Vector drugs = new Vector();	    
	    StringTokenizer st = new StringTokenizer(usedDrugs, ",");
	    while ( st.hasMoreTokens() ) 
		drugs.addElement(Common.getDrug(st.nextToken()));
	    int lngDrugs = drugs.size();
	    for (int i = 0; i < lng; i++) {
		String sympName = (String) newInSymptomsVec.elementAt(i);
		for (int j = 0; j < lngDrugs; j++) {
		    Drug drugJ = (Drug) drugs.elementAt(j);
		    if ( drugJ.getSideEffects().contains(sympName) ) {
			drugEffects.addElement(drugJ.getName());
			drugEffects.addElement(sympName);
			continue;
		    }
		    if ( drugJ.getCriticalSideEffects().contains(sympName) ) {
			drugEffects2.addElement(drugJ.getName());
			drugEffects2.addElement(sympName);
		    }
		}
	    }
	    if ( !allSymptoms.equals("") ) { // do the same with allSymptoms
		st = new StringTokenizer(allSymptoms, ",");
		while ( st.hasMoreTokens() ) {
		    String sympName = st.nextToken();
		    for (int j = 0; j < lngDrugs; j++) {
			Drug drugJ = (Drug) drugs.elementAt(j);
			if ( drugJ.getSideEffects().contains(sympName) ) {
			    drugEffects.addElement(drugJ.getName());
			    drugEffects.addElement(sympName);
			    continue;
			}
			if ( drugJ.getCriticalSideEffects().contains(sympName) ) {
			    drugEffects2.addElement(drugJ.getName());
			    drugEffects2.addElement(sympName);
			}
		    }
		}
	    }
	}
	// System.out.println("drugEffects: " + drugEffects.size() +
	//                    " drugEffects2: " + drugEffects2.size());

        res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>" + L.ConfirmConcepts + "</title>" +
		    D.linkHckStyle +
		    D.favicon +
		    "</head>" +
		    "<body>");
	// javascript:
	out.println(popupDisplaySymptom);
	out.println(popupDisplayDisease);
	out.println(popupDisplaySystem);
	out.println(popupDisplayDrug);
	int anchor = 1000; // for popup links

	out.println(DVM.htmlLogoutUser(L.ConfirmConcepts ));


	out.println(Diag2B.showInputsScript);
	if ( 0 < iteration )
	    out.println("<p><a href=\"#showInputs\" name=\"showInputs\" onClick=\"showInputs('" +
		  iteration + 
		  "')\"> <font size=\"4\"><i>" +
		  // "Pop Up My Previous Choices" +
		  L.Diag2S1 +
		  "</i></font></a><p>");



	// out.println("<h3>Drugs: " + usedDrugs + "</h3>");
       
	int lng1 = drugEffects.size();  // regular side effects
	int lng2 = drugEffects2.size(); // critical side effects
	if ( 0 < lng1 || 0 < lng2 ) {
	    out.println("<p><center><table border=\"1\">");
	    String regularSideEffects = "";
	    HashSet hs = new HashSet();
	    if ( 0 < lng1 ) {
		out.println(
		    "<tr><th colspan=\"2\"><font color=\"#1C5540\" size=\"4\">" + 
		    // "Drug(s) potentially causing symptom(s)" +
		    L.Diag1bS15 +
		    "</font></th></tr>");
		for ( int k = 0; k < lng1; k = k+2) {
		    String drugName = (String) drugEffects.elementAt(k);
		    Drug drugk = Common.getDrug(drugName);
		    String sympName = (String) drugEffects.elementAt(k+1);
		    if ( !hs.contains(sympName) ) {
			hs.add(sympName);
			regularSideEffects = regularSideEffects + sympName + ",";
		    }
		    Symptom sympk = Common.getSymptom(sympName);
		    anchor++;
		    out.println(
                         "<tr><td><a href=\"#" + anchor + "\" name=\"" + anchor +
			 "\" onClick=\"displayDrug('" + drugName + "')\">" + drugk.getPrintName() +
			 "</a></td>");
		    anchor++;
		    out.println(
                         "<td><a href=\"#" + anchor + "\" name=\"" + anchor +
			 "\" onClick=\"displaySymptom('" + sympName + "')\">" + sympk.getPrintName() +
			 "</a></td></tr>");
		}
	    }
	    String criticalSideEffects = "";
	    hs.clear();
	    if ( 0 < lng2 ) {
		out.println(
		    "<tr><th colspan=\"2\"><font color=\"#1C5540\" size=\"4\">" + 
		    // "Drug(s) potentially causing critical symptom(s)" +
		    L.Diag1bS16 +
		    "</font></th></tr>");
		for ( int k = 0; k < lng2; k = k+2) {
		    String drugName = (String) drugEffects2.elementAt(k);
		    Drug drugk = Common.getDrug(drugName);
		    String sympName = (String) drugEffects2.elementAt(k+1);
		    if ( !hs.contains(sympName) ) {
			hs.add(sympName);
			criticalSideEffects = criticalSideEffects + sympName + ",";
		    }
		    Symptom sympk = Common.getSymptom(sympName);
		    anchor++;
		    out.println(
                         "<tr><td><a href=\"#" + anchor + "\" name=\"" + anchor +
			 "\" onClick=\"displayDrug('" + drugName + "')\">" + drugk.getPrintName() +
			 "</a></td>");
		    anchor++;
		    out.println(
                         "<td><a href=\"#" + anchor + "\" name=\"" + anchor +
			 "\" onClick=\"displaySymptom('" + sympName + "')\">" + sympk.getPrintName() +
			 "</a></td></tr>");
		}
	    }
	    out.println("</table>");
	    if ( 0 < lng2 ) 
		out.println("<font color=\"#FF0000\" size=\"4\">" +
			    // "If you experience critical symptoms you may " +
			    // "want to terminate this session and obtain professional help." +
			    L.Diag1bS17 +
			    "</font><br>");
	    if ( 0 < lng1 ) 
		out.println("<font color=\"#1C5540\" size=\"4\">" +
			    // "If you believe that your symptoms are caused by your drugs " +
			    // "you many want to terminate this session." +
			    L.Diag1bS18 +
			    "</font><br>");
	    out.println("<font color=\"#1C5540\" size=\"4\">" +
			// "If you do NOT terminate, you may want to UNcheck these drug related symptoms<br> " +
			// "to avoid them being used for the generation of disease conjectures." +
			L.Diag1bS19 +
			"</font><br>");
	    out.println("<form name=\"terminateForm\" action=\"" + D.servletDiag1cTerminate + "\">");
	    out.println("<input type=\"hidden\" name=\"regularSideEffects\" " +
			"value=\"" + regularSideEffects + "\" />");
	    out.println("<input type=\"hidden\" name=\"criticalSideEffects\" " +
			"value=\"" + criticalSideEffects + "\" />");
	    out.println("<input type=\"submit\" value=\"" + L.Terminate + "\" /> ");
	    out.println("</form>");
	    out.println("</center>");
	}

	out.println("<form name=\"conceptsForm\" action=\"" + D.servletDiag1c + "\">");

	StringBuffer sb;
	StringTokenizer st;
	String symp, symp2;

	out.println("<p><center><table border=\"1\">");
	out.println(
	       "<tr><th colspan=\"2\"><font color=\"#1C5540\" size=\"4\">" + 
	       // "Current Input. Validate and, Optional, Modify" +
	       L.Diag1bS1 +
	       "</font></th></tr>");

	// String newInSymptomsStr = dse.getNewInSymptomsStr();
	// Vector newInSymptomsVec = dse.getNewInSymptomsVec();
	out.println("<tr><td><b>" + L.SymptomsSelected + "</b></td><td>");
	int cnt = 0;
	//	if ( newInSymptomsStr.equals("") ) 
	if ( 0 == newInSymptomsVec.size() ) 
	  out.println(
		      // "NO symptoms provided yet" +
		      L.Diag1bS2 +
		      "</td></tr>");
	else {
	  sb = new StringBuffer();
	  sb.append(
		    // "UNcheck if a previous selection was wrong:" +
		    L.Diag1bS3 +
		    "<br/> \n"); 
	  Vector theDiseases;
	  // st = new StringTokenizer(newInSymptomsStr, ",");
	  // while ( st.hasMoreTokens() ) {
	  for ( int i = 0; i < newInSymptomsVec.size(); i++ ) {
	    anchor++;
	    symp = (String) newInSymptomsVec.elementAt(i);
	    // newInSymptomsVec.addElement(symp);
	    Symptom sym = Common.getSymptom(symp);
	    theDiseases = sym.getTheDiseases();
	    if ( 0 == theDiseases.size() ) continue;
	    cnt++;
	    symp2 = ( expert ? sym.getPrintName() : sym.getDescription() );
	    sb.append("<input type=\"checkbox\" name=\"newInSymptomsStr\" value=\"" );
	    sb.append(symp);
	    // non-expert:
	    // sb.append("\">" + symp2 + " ");
	    // expert:
	    sb.append("\" checked=\"checked\" />");
	    sb.append("<a href=\"#" + anchor);
	    sb.append("\" name=\"" + anchor + "\" onClick=\"displaySymptom('" +
			  symp + "')\">" +
			  symp2 + 
			  "</a>\n ");
	  }
	  sb.append("</td></tr>");
	  if ( 0 < cnt ) 
	    out.println(sb.toString());
	  else 
	    out.println(
			// "NO symptoms found yet" +
			L.Diag1bS4 +
			"</td></tr>");
	}

	// String bodyPart = (String) session.getValue("bodyPart");
	out.println("<tr><td><b>" + L.LocationFocus + "</b></td><td>");
	Location body = null;
	String bodyPartPrintName = bodyPart;
	if ( !bodyPart.equals("unspecified") ) {
	    body = Common.getLocation(bodyPart);
	    bodyPartPrintName = body.getPrintName();
	}
	out.println(bodyPartPrintName + "</td></tr>");

	// check whether we can narrow down
	if ( body != null ) {
	    //  Location body = Common.getLocation(bodyPart);
	  Vector parts = body.getParts();
	  parts = DiagStart.filterParts(parts, gender); 
	  if ( 0 < parts.size() ) {
	      // check whether it is a set and we can add to parts
	      // String className = body.getClass().getName();
	      // if ( DVM.isSetClass(className) ) {
	      if ( body instanceof LocationSet ) {
		  LocationSet locSet = (LocationSet) body;
		  Vector subsets = locSet.getSubsets();
		  subsets = DiagStart.filterParts(subsets, gender);
		  lng = subsets.size();
		  // add subsets if any
		  for (int i = 0; i < lng; i++) parts.addElement(subsets.elementAt(i));
		  Vector members = locSet.getMembers();
		  members = DiagStart.filterParts(members, gender);
		  lng = members.size();
		  // add members if any
		  for (int i = 0; i < lng; i++) parts.addElement(members.elementAt(i));
	      }
	      generateRefinement(out, bodyPart, parts);
	  }
	  else {
	      // investigate whether body is a set
	      // String className = body.getClass().getName();
	      // if ( DVM.isSetClass(className) ) {
	      if ( body instanceof LocationSet ) {
		  LocationSet locSet = (LocationSet) body;
		  // investigate whether there are subsets:
		  Vector subsets = locSet.getSubsets();
		  subsets = DiagStart.filterParts(subsets, gender);
		  if ( 0 < subsets.size() ) {
		      // add members if any
		      Vector members = locSet.getMembers();
		      members = DiagStart.filterParts(members, gender);
		      lng = members.size();
		      for (int i = 0; i < lng; i++) subsets.addElement(members.elementAt(i));
		      generateRefinement(out, bodyPart, subsets);
		  }
		  else {
		      // investigate whether there are members:
		      Vector members = locSet.getMembers();
		      members = DiagStart.filterParts(members, gender);
		      if ( 0 < members.size() )
			  generateRefinement(out, bodyPart, members);
		  }
	      }
	  }
	}
	// separator here
	out.println("<tr></tr>");

	// String system = (String) session.getValue("system");
	out.println("<tr><td><b>" + L.SystemFocus + "</b></td><td>");
	out.println(system + "</td></tr>");
	// check whether we can narrow down
	if ( !system.equals("unspecified") ) {
	  BodySystem bs = Common.getBodySystem(system);
	  Vector subSystems = bs.getSubSystems();
	  lng =  subSystems.size();
	  if ( 0 < lng ) {
	    out.println("<tr><td><b>" +
			// "Optional: Narrow down system:" +
			L.Diag1bS6 +
			"</b></td>");
	    out.println("<td>");
	    out.println("<select name=\"narrowSystem\">");
	    out.println(" <option value=\"" + system + 
			"\" selected=\"selected\"> this system: " + system + "</option>");
	    String subSys,printName;
	    for (int i = 0; i < lng; i++) {
	      subSys = (String) subSystems.elementAt(i);
	      BodySystem bs2 = Common.getBodySystem(subSys);
	      String bsGender = bs2.getGender();
	      if ( !bsGender.equals(LR.both) && !bsGender.equals(gender) ) continue;
	      Vector vec = bs2.getAllDiseases();
	      if ( 0 == vec.size() ) continue;
	      printName = Common.unPolish(subSys);
	      out.println("      <option value=\"" + subSys + "\">" + printName + "</option>");
	    }
	    out.println("       </select> ");
	    out.println(DiagStart.hintToNarrow("sub1"));
	    out.println("</td></tr>");
	  }
	}

	Vector expertDiseases = (Vector) session.getValue("expertDiseases");
	lng = expertDiseases.size();
	if ( 0 < lng ) {
	  out.println("<tr><td><b>" + L.SelectedDiseases + "</b></td><td>" +
		      // "UNcheck if a previous selection was wrong:" +
		      L.Diag1bS7 +
		      "<br />"); 
	  sb = new StringBuffer();
	  for (int i=0; i<lng; i++) {
	    DiseaseInst di = (DiseaseInst) expertDiseases.elementAt(i);
	    //  sb.append(di.getDisease() + " ");
	    String dis = di.getDisease();
	    anchor++;
	    sb.append("<input type=\"checkbox\" name=\"expertDiseases\" value=\"" );
	    sb.append(dis);
	    // non-expert:
	    // sb.append("\">" + symp2 + " ");
	    // expert:
	    sb.append("\" checked=\"checked\" />");
	    sb.append("<a href=\"#" + anchor);
	    sb.append("\" name=\"" + anchor + "\" onClick=\"displayDisease('" +
		          dis + "')\">" +
			  Common.unPolish(dis) + 
			  "</a> ");
	  }
	  sb.append("</td></tr>");
	  out.println(sb.toString());
	}

	// deal now with the stuff found in userInput to be checked

	boolean displayStringBuffer = false;
	StringBuffer dsb = new StringBuffer();

	if ( !allSymptoms.equals("") || !allLocations.equals("") || 
	     !allSystems.equals("") || !allDiseases.equals("") )
	  dsb.append(
	       "<tr><th colspan=\"2\"><font color=\"#1C5540\" size=\"4\">" + 
	       // "Found in the text box. Confirm or Not:" +
	       L.Diag1bS8 +
	       "</font></th></tr>");

	checkConcepts.removeAllElements();

	// prepare for age and statusCondition filtering
	Integer ageInt = (Integer) session.getValue("ageInt");
	int age = ageInt.intValue();

	cnt = 0;
	if ( !allSymptoms.equals("") ) {
	  sb = new StringBuffer();
	  sb.append("<tr><td><b>" + L.ConjecturedSymptoms + "</b></td><td>" +
		    // "Check all that apply - if any:" +
		    L.Diag1bS9 +
		    "<br />"); 
	  st = new StringTokenizer(allSymptoms, ",");
	  Vector theDiseases;
	  String symptomStatusCondition;
	  while ( st.hasMoreTokens() ) {
	    symp = st.nextToken();
	    if ( newInSymptomsVec.contains(symp) ) continue;
	    Symptom sym = Common.getSymptom(symp);
	    theDiseases = sym.getTheDiseases();
	    if ( 0 == theDiseases.size() ) continue;
	    if ( age < sym.getMinAge() || sym.getMaxAge() < age ) continue;
	    symptomStatusCondition = sym.getStatusCondition();
	    if ( !symptomStatusCondition.equals("none") ) {
	      // check whether the client matches the statusCondition
	      if ( !symptomStatusCondition.equals(statusCondition) &&
		   // perhaps the client does not know she is pregnant
		   !symptomStatusCondition.equals("pregnant") ) continue; 
	    }
	    cnt++;
	    anchor++;
	    symp2 = ( expert ? sym.getPrintName() : sym.getDescription() );
	    sb.append("<input type=\"checkbox\" name=\"checkSymptoms\" value=\"");
	    sb.append(symp);
	    // non-expert:
	    // sb.append("\">" + symp2 + " ");
	    // expert:
	    sb.append("\" />");
	    sb.append("<a href=\"#" + anchor);
	    sb.append("\" name=\"" + anchor + "\" onClick=\"displaySymptom('" +
			  symp + "')\">" +
			  symp2 + 
			  "</a> ");
	  }
	  sb.append("</td></tr>");
	  if (0 < cnt) { 
	    displayStringBuffer = true;
	    dsb.append(sb.toString());
	  }
	}

	cnt = 0;
	if ( !allLocations.equals("") ) {
	  sb = new StringBuffer();
	  sb.append("<tr><td><b>" + L.ConjecturedLocations + "</b></td><td>" +
		    // "Check one that applies - if any:" +
		    L.Diag1bS10 +
		    "<br>"); 
	  sb.append("<input type=\"radio\" name=\"checkBodyPart\" value=\"ignore\" " +
		    "checked=\"checked\" /> ignore ");
	  st = new StringTokenizer(allLocations, ",");
	  while ( st.hasMoreTokens() ) {
	    symp = st.nextToken();
	    if ( symp.equals(bodyPart) ) continue;
	    cnt++;
	    symp2 = Common.unPolish(symp);
	    sb.append("<input type=\"radio\" name=\"checkBodyPart\" value=\"");
	    sb.append(symp);
	    sb.append("\" />" + symp2 + " ");
	  }
	  sb.append("</td></tr>");
	  if ( 0 < cnt ) {
	    displayStringBuffer = true;
	    dsb.append(sb.toString());
	  }
	}

	cnt = 0;
	if ( !allSystems.equals("") ) {
	  sb = new StringBuffer();
	  sb.append("<tr><td><b>" + L.ConjecturedBodySystems + "</b></td><td>" +
		    // "Check one that applies - if any:" +
		    L.Diag1bS10 +
		    "<br />"); 
	  sb.append("<input type=\"radio\" name=\"checkSystem\" value=\"ignore\" " +
		    "checked=\"checked\" /> ignore ");
	  st = new StringTokenizer(allSystems, ",");
	  while ( st.hasMoreTokens() ) {
	    symp = st.nextToken();
	    if ( symp.equals(system) ) continue;
	    cnt++;
	    anchor++;
	    symp2 = Common.unPolish(symp);
	    sb.append("<input type=\"radio\" name=\"checkSystem\" value=\"");
	    sb.append(symp);
	    // non-expert:
	    // sb.append("\" />" + symp2 + " ");
	    // expert:
	    sb.append("\" />");
	    sb.append("<a href=\"#" + anchor);
	    sb.append("\" name=\"" + anchor + "\" onClick=\"displaySystem('" +
			  symp + "')\">" +
			  symp2 + 
			  "</a> ");
	  }
	  sb.append("</td></tr>");
	  if ( 0 < cnt ) { 
	    displayStringBuffer = true;
	    dsb.append(sb.toString());
	  }
	}

	cnt = 0;
	if ( !allDiseases.equals("") ) {
	  sb = new StringBuffer();
	  sb.append("<tr><td><b>" + L.ConjecturedDiseases + "</b></td><td>" +
		    // "Check all that apply - if any:" +
		    L.Diag1bS9 +
		    "<br>"); 
	  st = new StringTokenizer(allDiseases, ",");
	  //  Vector diseases = (Vector) session.getValue("diseases");
	  Vector diseases = dse.getDiseases();
	  Disease disease;
	  String diseaseStatusCondition;
	  while ( st.hasMoreTokens() ) {
	    symp = st.nextToken();
	    if ( Common.isDiseaseMember(symp, expertDiseases) ||
		 Common.isDiseaseMember(symp, diseases) ) continue;
	    disease = Common.getDisease(symp);
	    if ( age < disease.getMinAge() || disease.getMaxAge() < age ) continue;
	    diseaseStatusCondition = disease.getStatusCondition();
	    if ( !diseaseStatusCondition.equals("none") ) {
	      // check whether the client matches the statusCondition
	      if ( !diseaseStatusCondition.equals(statusCondition) &&
		   // perhaps the client does not know she is pregnant
		   !diseaseStatusCondition.equals("pregnant") ) continue; 
	    }
	    cnt++;
	    anchor++;
	    symp2 = Common.unPolish(symp);
	    sb.append("<input type=\"checkbox\" name=\"checkDiseases\" value=\"");
	    sb.append(symp);
	    // non-expert:
	    // sb.append("\">" + symp2 + " ");
	    // expert:
	    sb.append("\" />");
	    sb.append("<a href=\"#" + anchor);
	    sb.append("\" name=\"" + anchor + "\" onClick=\"displayDisease('" +
			  symp + "')\">" +
			  symp2 + 
			  "</a> ");
	  }
	  sb.append("</td></tr>");
	  if ( 0 < cnt ) { 
	    displayStringBuffer = true;
	    dsb.append(sb.toString());
	  }
	}
	if ( displayStringBuffer ) out.println(dsb.toString());

	out.println("<tr><th colspan=\"2\"><font color=\"#1C5540\" size=\"4\">" +
	            // "Optional, provide more symptoms and/or locations: " +
		    L.Diag1bS11 +
		    " <a href=\"#hint\" name=\"hint\" onClick=\"alert('" +
		    // "The more you provide the faster the search yields results." +
		    L.Diag1bS12 +
		    "')\">" +
		    "<i>" + L.Hint + "</i> </a> </font></th></tr> ");

	out.println("<tr><th colspan=\"2\">" +
	            "<input type=\"text\" name=\"userInput\" size=\"60\" maxlength=\"60\" value=\"\" />" +
		    "</th></tr> ");

	out.println("</table></center>");


	out.println("<br /><font size=\"4\">" +
		    // "Please check your data before submitting!" +
		    L.Diag1bS13 +
		    "</font> ");
	//	out.println("<input type=\"button\" value=\"Submit\" " +
	//		    "onClick=\"checkForm(this.form)\" />");
	out.println("<input type=\"submit\" value=\"Submit\" /> ");
	
	/* Prevent 500-errors
	String quickAccount = props.getProperty("quickAccount");
	boolean quickie = (null != quickAccount);
	out.println("<input type=\"button\" value=\"Cancel\" " +
		    "onClick= \"location = '" + 
		    (quickie ? D.servletDiagStart : D.AngelRootHtml) + "'\" />");
	*/
	out.println("<input type=\"hidden\" name=\"iteration\" " +
		    "value=\"" + iteration + "\" />");

	/* Confusing 
	if ( !allUnknowns.equals("") )
	  out.println("<br><b>" +
		      // "Not processed concepts:" +
		      L.Diag1bS14 +
		      "</b> " + allUnknowns);
	*/

	out.println(DV.htmlBack);

	// user Search
	// out.println(DiagStart.search());

	// localhost:8000 === healthcareProvider:80 or so
	out.println(DV.SCRIPTCC);

	out.println("</font></body>");
	out.println("</html>");
    }

    static private void generateRefinement(ServletOutputStream out, String bodyPart,
					   Vector parts)
	throws IOException {
	int lng = parts.size();
	out.println("<tr><td><b>" +
		    // "Optional: Narrow down body part:" +
		    L.Diag1bS5 +
		    "</b></td>");
	out.println("<td>");
	out.println("<select name=\"narrowBodyPart\">");
	out.println(" <option value=\"" + bodyPart + 
		    "\" selected=\"selected\"> this loc: " + bodyPart + "</option>");
	String locName2;
	PartOfLocation loc2;
	String printName;
	for (int i = 0; i < lng; i++) {
	    locName2 = (String) parts.elementAt(i);
	    loc2 = (PartOfLocation) Common.getLocation(locName2);
	    printName = loc2.getPrintName();
	    out.println("      <option value=\"" + locName2 + "\">" + printName + "</option>");
	}
	out.println("       </select> ");
	out.println(DiagStart.hintToNarrow("loc1"));
	out.println(DiagStart.hintLocWhat("loc1What"));
	out.println("</td></tr>");
    } // end generateRefinement


} // end of Diag1b



