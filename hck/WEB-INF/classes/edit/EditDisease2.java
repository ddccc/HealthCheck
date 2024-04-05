// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.LR;
import com.D;
import concepts.Disease;
import concepts.Treatment;
import concepts.TreatmentAction;
import concepts.Drug;

public class EditDisease2 extends HttpServlet {

    public void doPost (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      boolean doModifyIncore = true;

      String name = req.getParameter("name");
      String printName = req.getParameter("printName");
      String description = req.getParameter("description");
      String superDisease = req.getParameter("superDisease");
      String diseaseSet = req.getParameter("diseaseSet");
      String genderSpecificity = req.getParameter("genderSpecificity");
      String raceSpecificity = req.getParameter("raceSpecificity");
      String minAge = req.getParameter("minAge");
      String maxAge = req.getParameter("maxAge");
      String statusCondition = req.getParameter("statusCondition");
      String duration = req.getParameter("duration");
      String frequency = req.getParameter("frequency");
      String bodySystem = req.getParameter("bodySystem");
      if ( bodySystem.equals("newBodySystem") ) doModifyIncore = false;
      String underlyingDisease = req.getParameter("underlyingDisease");
      String setTemperature = req.getParameter("setTemperature");
      String genetic = req.getParameter("genetic");
      String parentDisease = req.getParameter("parentDisease");
      String symptomsList = req.getParameter("symptomsList");
      String addSymptoms = req.getParameter("addSymptoms");
      String externalCausesList = req.getParameter("externalCausesList");
      String addExternalCauses = req.getParameter("addExternalCauses");
      String newExternalCauses = req.getParameter("newExternalCauses");
      String internalCausesList = req.getParameter("internalCausesList");
      String addInternalCauses = req.getParameter("addInternalCauses");
      String causingSetsList = req.getParameter("causingSetsList");
      String addCausingDiseaseSets = req.getParameter("addCausingDiseaseSets");
      String causingAbnormalConditionsList = 
	req.getParameter("causingAbnormalConditionsList");
      String addCausingAbnormalConditions = 
	req.getParameter("addCausingAbnormalConditions");
      String causesDiseasesList = req.getParameter("causesDiseasesList");
      String addCausesDiseases = req.getParameter("addCausesDiseases");
      String causesAbnormalConditionsList = req.getParameter("causesAbnormalConditionsList");
      String addCausesAbnormalConditions = req.getParameter("addCausesAbnormalConditions");
      String miscComments = req.getParameter("miscComments");
      String literatureList = req.getParameter("literatureList");
      String addLitRef = req.getParameter("addLitRef");
      String treatmentsList = req.getParameter("treatmentsList");
      String addTreatment = req.getParameter("addTreatment");
      String webResource = req.getParameter("webResource");

      String nameDis = name + "Dis";
      String code = "";
      Disease newDis = null;
      int lng;
      Vector treatmentsVecEdit = new Vector();
      Vector externalCausesVec = null;
      Vector addExternalCausesVec = null;
      try {
      externalCausesVec = unpackList(externalCausesList, req);
      addExternalCausesVec = unpackListS(addExternalCauses);
      if ( 0 == externalCausesVec.size() ) {
	Vector temp = externalCausesVec;
	externalCausesVec = addExternalCausesVec;
	addExternalCausesVec = temp;
      }

      int maxAgeInt = LR.maxAge;
      try {
	maxAgeInt = Integer.parseInt(maxAge);
      } catch (NumberFormatException ignore) {}
      code += 
	"<br>Disease " + nameDis + " = new Disease(" +
	"<br>   LR." + name + ", " +
	"<br>   \"" + description + "\", " +
	"<br>   LR." + diseaseSet + ", " +
	"<br>   LR." + genderSpecificity + ", // genderSpecificity " +
	"<br>   LR." + raceSpecificity + ", // raceSpecificity " +
	"<br>   " + minAge + ", //  minAge " +
	"<br>   " + ( LR.maxAge == maxAgeInt ? "LR.maxAge" : maxAge ) + "," +
	"<br>   " + duration + ", //  duration " +
	"<br>   " + frequency + ", //  diagnosis frequency, -1 = unknown " +
	"<br>   LR." + bodySystem + "St, " +
	"<br>   LR." + ( 0 == externalCausesVec.size() ? "none" : 
			 (String) externalCausesVec.elementAt(0) ) +
	"<br>);";

      if ( doModifyIncore ) {
	int minAgeInt = 0;
	// int maxAgeInt = LR.maxAge;
	int durationInt = 0;
	int frequencyInt = -1;
	try {
	  minAgeInt = Integer.parseInt(minAge);
	  // maxAgeInt = Integer.parseInt(maxAge);
	  durationInt = Integer.parseInt(duration);
	  frequencyInt = Integer.parseInt(frequency);
	} catch (NumberFormatException ignore) {}
	newDis = new Disease(
	    name, description, diseaseSet,
	    unPolish(genderSpecificity), unPolish(raceSpecificity),
	    minAgeInt, maxAgeInt, durationInt, frequencyInt, bodySystem, 
	    ( 0 == externalCausesVec.size() ? "none" : 
	      Common.unPolish((String) externalCausesVec.elementAt(0)) ) );
      }

      if ( 0 < printName.length() && !name.equals(printName) ) {
	code += "<br>" + nameDis + ".setPrintName(" +
	        ( printName.equals(description) ? "" :
		  "\"" + printName + "\"") + 
	        ");";
	if ( doModifyIncore ) {
	  if ( printName.equals(description) )
	    newDis.setPrintName();
	  else
	    newDis.setPrintName(printName);
	}
      }

      if ( !webResource.equals("") ) {
	code += 
               "<br>" + nameDis + ".setWebResource(\"" + webResource + "\");";
	if (doModifyIncore) 
	  newDis.setWebResource(webResource);
      }

      if ( !superDisease.equals("none") ) {
	code += "<br>" + nameDis + ".setSuperDisease(LR." +
	        superDisease + ");";
	if ( doModifyIncore ) 
	    newDis.setSuperDisease(superDisease);
      }

      if ( !underlyingDisease.equals("none") ) {
	code += "<br>" + nameDis + ".setUnderlyingDisease(LR." +
		underlyingDisease + ");";
	if ( doModifyIncore ) 
	    newDis.setUnderlyingDisease(underlyingDisease);
      }

      if ( !setTemperature.equals("99.3") ) {
	code += "<br>" + nameDis + ".setTemperature((float)" + 
	        setTemperature + ");";
	if ( doModifyIncore ) {
	  float temperature = (float) 99.3;
	  try {
	    temperature = Float.parseFloat(setTemperature);
	  } catch (NumberFormatException ignore) {}
	  newDis.setTemperature(temperature);
	}
      }

      if ( !statusCondition.equals("none") ) {
	code += "<br>" + nameDis + ".setStatusCondition(\"" + statusCondition + "\");";
	if ( doModifyIncore ) {
	    newDis.setStatusCondition(statusCondition);
	}
      }

      if ( !genetic.equals("none") ) {
	code += "<br>" + nameDis + ".setGenetic(\"" + genetic + "\");";
	if ( parentDisease.equals("thisDisease") ) parentDisease = name;
	code += "<br>" + nameDis + ".setParentDisease(LR." + parentDisease + ");";
	if ( doModifyIncore ) {
	    newDis.setGenetic(genetic);
	    newDis.setParentDisease(parentDisease);
	}
      }

      StringTokenizer st;
      String token, tokenValue;
      StringBuffer sb;

      // Vector symptomsVec = unpackList(symptomsList);
      if ( null != symptomsList ) {
	st = new StringTokenizer(symptomsList, ",");
	sb = new StringBuffer(code);
	String weight;
	float weightF;
	String elaboration;
	while ( st.hasMoreTokens() ) {
	  token = st.nextToken();
	  token = token.trim();
	  tokenValue = req.getParameter(token);
	  if ( tokenValue.equals("keep") ) {
	    elaboration = req.getParameter(token + "elab");
	    if ( elaboration.equals(" ") ) elaboration = "";
	    weight = req.getParameter(token + "weight");
	    weightF = 1.0f;
	    try {
	      weightF = (Float.valueOf(weight)).floatValue();
	    } 
	    catch (NumberFormatException ignore) {}
	    sb.append("<br>" + nameDis + 
		      ".addSymptom(LR." + token + ", " +
		      "\"" + elaboration + "\", " +
		      weightF + "f);");
	    if ( doModifyIncore ) 
	      newDis.addSymptom(token, elaboration, weightF);
	  }
	}
	code = sb.toString();
      }

      Vector addSymptomsVec = unpackListS(addSymptoms);
      lng = addSymptomsVec.size();
      if ( 0 < lng ) {
	sb = new StringBuffer(code);
	for (int i = 0; i<lng; i++) {
	  token = (String) addSymptomsVec.elementAt(i);
	  sb.append("<br>" + nameDis + ".addSymptom(LR." + token + ");");
	  if ( doModifyIncore ) 
	    newDis.addSymptom(token);
	}
	code = sb.toString();
      }

      // Vector externalCausesVec = unpackList(externalCausesList);
      lng = externalCausesVec.size();
      if ( 1 < lng ) {
	sb = new StringBuffer(code);
	String ecNameU, ecNameS;
	for (int i = 1; i<lng; i++) {
	  ecNameU = (String) externalCausesVec.elementAt(i);
	  ecNameS = Common.unPolish(ecNameU);
	  sb.append("<br>" + nameDis + ".addExternalCause(LR." + ecNameU + ");");
	  if ( doModifyIncore ) 
	    newDis.addExternalCause(ecNameS);
	}
	code = sb.toString();
      }

      // Vector addExternalCausesVec = unpackListS(addExternalCauses);
      lng = addExternalCausesVec.size();
      if ( 0 < lng ) {
	sb = new StringBuffer(code);
	String ecNameU, ecNameS;
	for (int i = 0; i<lng; i++) {
	  ecNameU = (String) addExternalCausesVec.elementAt(i);
	  ecNameS = eliminateSpace(ecNameU);
	  sb.append("<br>" + nameDis + ".addExternalCause(LR." + ecNameS + ");");
	  if ( doModifyIncore ) {
	    newDis.addExternalCause(ecNameU);
	  }
	}
	code = sb.toString();
      }

      if ( !newExternalCauses.equals("") ) {
	sb = new StringBuffer(code);
	String ecNameS, ecNameC;
	st = new StringTokenizer(newExternalCauses, "|");
	while ( st.hasMoreTokens() ) {
	  ecNameS = st.nextToken();
	  ecNameC = eliminateSpace(ecNameS);
	  sb.append("<br>" + nameDis + ".addExternalCause(LR." + ecNameC + ");");
	  if ( doModifyIncore ) {
	    newDis.addExternalCause(ecNameS);
	  }
	}
	code = sb.toString();
      }


      Vector internalCausesVec = unpackList(internalCausesList, req, "ic");
      lng = internalCausesVec.size();
      if ( 0 < lng ) {
	sb = new StringBuffer(code);
	for (int i = 0; i<lng; i++) {
	  token = (String) internalCausesVec.elementAt(i);
	  // chop the ic prefix
	  // token = token.substring(2);
	  sb.append("<br>" + nameDis + ".addInternalCause(LR." + token + ");");
	  if ( doModifyIncore ) 
	    newDis.addInternalCause(token);
	}
	code = sb.toString();
      }

      Vector addInternalCausesVec = unpackListS(addInternalCauses);
      lng = addInternalCausesVec.size();
      if ( 0 < lng ) {
	sb = new StringBuffer(code);
	for (int i = 0; i<lng; i++) {
	  token = (String) addInternalCausesVec.elementAt(i);
	  sb.append("<br>" + nameDis + ".addInternalCause(LR." + token + ");");
	  if ( doModifyIncore ) 
	    newDis.addInternalCause(token);
	}
	code = sb.toString();
      }

      Vector  causingSetsVec = unpackList( causingSetsList,req,"aDisSet");
      lng = causingSetsVec.size();
      if ( 0 < lng ) {
	sb = new StringBuffer(code);
	for (int i = 0; i<lng; i++) {
	  token = (String) causingSetsVec.elementAt(i);
	  // chop ac1 prefix
	  // token = token.substring(3);
	  sb.append("<br>" + nameDis + ".addCausingSet(LR." + token + ");");
	  if ( doModifyIncore ) 
	    newDis.addCausingSet(token);
	}
	code = sb.toString();
      }

      Vector addCausingDiseaseSetsVec = unpackListS(addCausingDiseaseSets);
      lng = addCausingDiseaseSetsVec.size();
      if ( 0 < lng ) {
	sb = new StringBuffer(code);
	for (int i = 0; i<lng; i++) {
	  token = (String) addCausingDiseaseSetsVec.elementAt(i);
	  sb.append("<br>" + nameDis + ".addCausingSet(LR." + token + ");");
	  if ( doModifyIncore ) 
	    newDis.addCausingSet(token);
	}
	code = sb.toString();
      }

      Vector causingAbnormalConditionsVec = 
	unpackList(causingAbnormalConditionsList,req,"ac1");
      lng = causingAbnormalConditionsVec.size();
      if ( 0 < lng ) {
	sb = new StringBuffer(code);
	for (int i = 0; i<lng; i++) {
	  token = (String) causingAbnormalConditionsVec.elementAt(i);
	  // chop ac1 prefix
	  // token = token.substring(3);
	  sb.append("<br>" + nameDis + ".addCausingAbnormalCondition(LR." + token + ");");
	  if ( doModifyIncore ) 
	    newDis.addCausingAbnormalCondition(token);
	}
	code = sb.toString();
      }

      Vector addCausingAbnormalConditionsVec = unpackListS(addCausingAbnormalConditions);
      lng = addCausingAbnormalConditionsVec.size();
      if ( 0 < lng ) {
	sb = new StringBuffer(code);
	for (int i = 0; i<lng; i++) {
	  token = (String) addCausingAbnormalConditionsVec.elementAt(i);
	  sb.append("<br>" + nameDis + ".addCausingAbnormalCondition(LR." + token + ");");
	  if ( doModifyIncore ) 
	    newDis.addCausingAbnormalCondition(token);
	}
	code = sb.toString();
      }

      Vector causesDiseasesVec = unpackList(causesDiseasesList,req,"cd");
      lng = causesDiseasesVec.size();
      if ( 0 < lng ) {
	sb = new StringBuffer(code);
	for (int i = 0; i<lng; i++) {
	  token = (String) causesDiseasesVec.elementAt(i);
	  // chop cd prefix
	  // token = token.substring(2);
	  sb.append("<br>" + nameDis + ".addCausesDisease(LR." + token + ");");
	  if ( doModifyIncore ) 
	    newDis.addCausesDisease(token);
	}
	code = sb.toString();
      }

      Vector addCausesDiseasesVec = unpackListS(addCausesDiseases);
      lng = addCausesDiseasesVec.size();
      if ( 0 < lng ) {
	sb = new StringBuffer(code);
	for (int i = 0; i<lng; i++) {
	  token = (String) addCausesDiseasesVec.elementAt(i);
	  sb.append("<br>" + nameDis + ".addCausesDisease(LR." + token + ");");
	  if ( doModifyIncore ) 
	    newDis.addCausesDisease(token);
	}
	code = sb.toString();
      }

      Vector causesAbnormalConditionsVec = 
	unpackList(causesAbnormalConditionsList,req,"ac2");
      lng = causesAbnormalConditionsVec.size();
      if ( 0 < lng ) {
	sb = new StringBuffer(code);
	for (int i = 0; i<lng; i++) {
	  token = (String) causesAbnormalConditionsVec.elementAt(i);
	  // chop ac2 prefix
	  // token = token.substring(3);
	  sb.append("<br>" + nameDis + ".addCausesAbnormalCondition(LR." + token + ");");
	  if ( doModifyIncore ) 
	    newDis.addCausesAbnormalCondition(token);
	}
	code = sb.toString();
      }

      Vector addCausesAbnormalConditionsVec = unpackListS(addCausesAbnormalConditions);
      lng = addCausesAbnormalConditionsVec.size();
      if ( 0 < lng ) {
	sb = new StringBuffer(code);
	for (int i = 0; i<lng; i++) {
	  token = (String) addCausesAbnormalConditionsVec.elementAt(i);
	  sb.append("<br>" + nameDis + ".addCausesAbnormalCondition(LR." + token + ");");
	  if ( doModifyIncore ) 
	    newDis.addCausesAbnormalCondition(token);
	}
	code = sb.toString();
      }

      Vector literatureVec = unpackList(literatureList,req);
      lng = literatureVec.size();
      String aReference;
      if ( 0 < lng ) {
	sb = new StringBuffer(code);
	for (int i = 0; i<lng; i++) {
	  token = (String) literatureVec.elementAt(i);
	  aReference = req.getParameter(token+"Value");
	  sb.append("<br>" + nameDis + ".addReference(\"" + 
		    aReference + "\");");
	  if ( doModifyIncore ) 
	    newDis.addReference(aReference);
	}
	code = sb.toString();
      }

      // ++++++ if ( !addLitRef.equals("") ) literatureVec.addElement(addLitRef);
      if ( !addLitRef.equals("") ) {
	sb = new StringBuffer(code);
	aReference = addLitRef;
	sb.append("<br>" + nameDis + ".addReference(\"" + 
		  aReference + "\");");
	if ( doModifyIncore ) 
	  newDis.addReference(aReference);
	code = sb.toString();
      }

      if ( !miscComments.equals("") ) {
	code += "<br>" + nameDis + ".setMiscComments(\"" + miscComments + "\");";
	if ( doModifyIncore ) 
	  newDis.setMiscComments(miscComments);
      }

      // Vector treatmentsVec = unpackList(treatmentsList);
      // lng = treatmentsVec.size();
      // Vector treatmentsVecEdit = new Vector();
      if ( null != treatmentsList ) {
	st = new StringTokenizer(treatmentsList, ",");
	sb = new StringBuffer(code);
	Treatment tr;
	String condition;
	Vector vec;
	TreatmentAction tac;
	Drug drug;
	String veci;
	while ( st.hasMoreTokens() ) {
	  token = st.nextToken();
	  token = token.trim(); 
	  tokenValue = req.getParameter(token);
	  if ( tokenValue.equals("keep") ) {
	    // sb.append("<br>// keep the treatment: " + token);
	    tr = Common.getTreatment(token);
	    condition = tr.getCondition();
	    sb.append("<br>Treatment " + token + 
		      " = new Treatment(\"" + token + "\"" +
		      ( null == condition ? "" :
			", LR." + eliminateSpace(condition) ) +
		      ");");
	    vec = tr.getTreatmentActions();
	    lng = vec.size();
	    for (int i = 0; i<lng; i++) {
	      tac = (TreatmentAction) vec.elementAt(i);
	      veci = tac.getDescription();
	      sb.append("<br>" + token + ".addTreatmentAction(LR." +
			eliminateSpace(veci) + ");");
	    }
	    vec = tr.getDrugs();
	    lng = vec.size();
	    for (int i = 0; i<lng; i++) {
	      drug = (Drug) vec.elementAt(i);
	      veci = drug.getDescription();
	      sb.append("<br>" + token + ".addDrug(LR." +
			eliminateSpace(veci) + ");");
	    }
	    sb.append("<br>" + nameDis + ".addTreatment(\"" + token + "\");");
	    if ( doModifyIncore ) newDis.addTreatment(token);
	  } else {
	    if ( tokenValue.equals("edit") ) treatmentsVecEdit.addElement(token);
	  }
	}
	code = sb.toString();
      }

      // Vector treatmentsVecEdit = unpackList(treatmentsList, ".edit");
      if ( addTreatment.equals("yes") ) 
	treatmentsVecEdit.addElement(name + "TrX");
      lng = treatmentsVecEdit.size();

      } catch (Exception ex) {
	   res.setContentType("text/html");
	   ServletOutputStream outx = res.getOutputStream();
	   outx.println("<HTML>");
	   outx.println("<HEAD><TITLE>EditDisease2 Exception</TITLE></HEAD>");
	   outx.println("<BODY BGCOLOR=red>");
	   outx.println("<H1>EditDisease2 </H1>");
	   StringBuffer sb = new StringBuffer("<br><b>Selected Values</b>");
	   sb.append("<br>addExternalCauses: " + addExternalCauses);
	   sb.append("<br>newExternalCauses: " + newExternalCauses);
	   sb.append("<br>externalCausesVec: " + externalCausesVec.toString());
	   sb.append("<br>addExternalCausesVec: " + addExternalCausesVec.toString());
	   outx.println(sb.toString());
	   outx.println("<br><b>code:</b> " + code);
	   outx.println("<br>Exception: " + ex.toString());
	   outx.println("<pre>");
	   PrintStream ps = new PrintStream(outx);
	   ex.printStackTrace(ps);
	   outx.println("</pre>");
	   outx.println("</BODY>");
	   outx.println("</HTML>");
	   return;
      }

	HttpSession session = req.getSession(true);
	session.putValue("name", name);
	session.putValue("code", code);
	session.putValue("treatmentsVecEdit", treatmentsVecEdit);
	session.putValue("addTreatment", addTreatment);
	session.putValue("newDis", newDis);
      if ( 0 < lng ) {
	res.sendRedirect(D.servletEditTreatments);
      } else
	res.sendRedirect(D.servletEditDisease3);
    }


  static public Vector unpackList(String aList) {
    return unpackList(aList, ".keep");
  }
  static private Vector unpackList(String aList, String postFix) {
    Vector out = new Vector();
    if ( null == aList || 0 == aList.length() ) return out;
    int postFixLng = postFix.length();
    StringTokenizer st = new StringTokenizer(aList, "|");
    String elem;
    while (st.hasMoreTokens()) {
      elem = st.nextToken();
      if ( 0 == postFixLng )
	out.addElement(elem);
      else
	if ( elem.endsWith(postFix) )
	  out.addElement(elem.substring(0, elem.length() - postFixLng));
    }
    return out;
  }

  static public Vector unpackListS(String aList) {
    Vector out = new Vector();
    if ( null == aList || 0 == aList.length() ) return out;
    StringTokenizer st = new StringTokenizer(aList, ",");
    while (st.hasMoreTokens()) {
      out.addElement(st.nextToken());
    }
    return out;
  }

  static private Vector unpackList(String aList, HttpServletRequest req) {
    return unpackList(aList, req, "");
  }

  static private Vector unpackList(String aList, HttpServletRequest req, String prefix) {
    Vector out = new Vector();
    if ( null == aList || 0 == aList.length() ) return out;
    StringTokenizer st = new StringTokenizer(aList, ",");
    String token, tokenValue;
    while (st.hasMoreTokens()) {
      token = st.nextToken();
      token = token.trim();
      tokenValue = req.getParameter(prefix+token);
      if ( tokenValue.equals("keep") ) 
	out.addElement(token);
    }
    return out;
  }

  private String eliminateSpace(String in) {
    return EditDisease.eliminateSpace(in);
  }

  public String unPolish(String in) {
    return Common.unPolish(in);
  }

}



