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
import concepts.BodySystem;
import concepts.Symptom;
import concepts.DiseaseSet;
import concepts.AbnormalCondition;
import concepts.Treatment;
import concepts.WeightedSymptom;

public class EditDisease extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String dis = req.getParameter("dis"); // existing disease | newDisease
      boolean newDisease = dis.equals("newDisease");
      Disease disease = ( newDisease ? null : Common.getDisease(dis) );
      String printName = ( newDisease ? "provide disease print name" :
			   disease.getPrintName());
      String description = ( newDisease ? "provide description" :
			   disease.getDescription());
      String superDisease = ( newDisease ? null :
			   disease.getSuperDisease() );
      String diseaseSet = ( newDisease ? null :
			   disease.getDiseaseSet() );
      String genderSpecificity  = ( newDisease ? "none" : 
				    disease.getGenderSpecificity() );
      String raceSpecificity  = ( newDisease ? "none" : 
				  disease.getRaceSpecificity() );
      int minAge = ( newDisease ? 0 : disease.getMinAge() );
      int maxAge = ( newDisease ? LR.maxAge : disease.getMaxAge() );
      String statusCondition  = ( newDisease ? "none" : 
				    disease.getStatusCondition() );
      int duration = ( newDisease ? 0 : disease.getDuration() );
      int frequency = ( newDisease ? -1 : disease.getFrequency() );
      String bodySystem = ( newDisease ? null : disease.getBodySystem() );
      String underlyingDisease = ( newDisease ? null : 
				   disease.getUnderlyingDisease0() );
      // genetic = none|1parent|2parents|father|mother
      String genetic = ( newDisease ? "none" : disease.getGenetic() );
      String parentDisease = ( newDisease ? null : disease.getParentDisease() );
      Vector symptoms = ( newDisease ? null : disease.getSymptoms0() );
      boolean bSymptoms = ( (null != symptoms) && (0 < symptoms.size()) );
      Vector allSymptoms2 = new Vector();
      // Vector phases = ( newDisease ? null : disease.getPhases() ) ;
      Vector treatments = ( newDisease ? null : disease.getTreatments0() );
      boolean bTreatments = ( (null != treatments) && (0 < treatments.size()) );
      Vector allTreatments2 = new Vector();
      Vector externalCauses = ( newDisease ? 
				null : disease.getExternalCauses0() );
      boolean bExternalCauses = ( (null != externalCauses) && 
				  (0 < externalCauses.size()) );
      Vector allExternalCauses2 = new Vector();
      Vector internalCauses = ( newDisease ? 
				null : disease.getInternalCauses0() );
      boolean bInternalCauses = ( (null != internalCauses) && 
				  (0 < internalCauses.size()) );
      Vector allInternalCauses2 = new Vector();
      Vector causingSets =
	( newDisease ? null : disease.getCausingSets() );
      boolean bCausingSets = ( (null != causingSets) && 
			       (0 < causingSets.size()) );
      Vector allCausingSets2 = new Vector();
      Vector causingAbnormalConditions = 
	( newDisease ? null : disease.getCausingAbnormalConditions0() );
      boolean bCausingAbnormalConditions = ( (null != causingAbnormalConditions) && 
				  (0 < causingAbnormalConditions.size()) );
      Vector allCausingAbnormalConditions2 = new Vector();
      Vector causesDiseases = 
	( newDisease ? null : disease.getCausesDiseases0() );
      boolean bCausesDiseases = ( (null != causesDiseases) && 
				  (0 < causesDiseases.size()) );
      Vector allCausesDiseases2 = new Vector();
      Vector causesAbnormalConditions =
	( newDisease ? null : disease.getCausesAbnormalConditions0() );
      boolean bCausesAbnormalConditions = ( (null != causesAbnormalConditions) && 
				  (0 < causesAbnormalConditions.size()) );
      Vector allCausesAbnormalConditions2 = new Vector();
      String miscComments = 
	( newDisease ? "" : disease.getMiscComments() );
      if ( null == miscComments ) miscComments = "";
      Vector literature = 
	( newDisease ? null : disease.getLiterature() );
      boolean bLiterature = ( (null != literature) && 
				  (0 < literature.size()) );
      Vector allLiterature2 = new Vector();
      float setTemperature = // default 99.3;
	( newDisease ? (float)99.3 : disease.getTemperature0() );
      String webResource = ( newDisease ? "" :
			   disease.getWebResource());
      if ( null == webResource ) webResource = "";

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Edit Disease " + dis + "</TITLE></HEAD>");
      String script =
"<SCRIPT LANGUAGE='JavaScript'>" + "\n" +
"function checkForm(form) {" +
	"if ( (form.name.value == \"\") || " +
	     "(form.name.value == \"newDisease\") ) {" +
	     "alert(\"Need value in name field ...\");" +
	     "return false;" +
	"}" + "\n" +
	"if (form.printName.value == \"provide disease print name\") {" +
	     "alert(\"Clear printName field value ...\");" +
	     "return false;" +
	"}" + "\n" +
	"description = form.description.value; \n" + 
	"if ( (description == \"provide description\") || (description == \"\") ) {" +
	     "alert(\"Provide description field value ...\");" +
	     "return false;" +
	"}" + "\n" +
	"if (!isNumberString(form.minAge.value)) {" +
	     "alert(\"minAge field value must be a number ...\");" +
	     "return false;" +
	"}" + "\n" +
	"if (!isNumberString(form.maxAge.value)) {" +
	     "alert(\"maxAge field value must be a number ...\");" +
	     "return false;" +
	"}" + "\n" +
	"frequency = form.frequency.value; " +
	"if ( (frequency != \"-1\") && !isNumberString(frequency) ) {" +
	     "alert(\"Diagnostic frequency field value must be a number ...\");" +
	     "return false;" +
	"}" + "\n" +
	"setTemperature = form.setTemperature.value; " +
	"if ( !isFloatString(setTemperature) || setTemperature.indexOf('.')<0 ) {" +
	     "alert(\"setTemperature field value must be a float number ...\");" +
	     "return false;" +
	"}" + "\n" +
	// ( bTreatments ? treatmentsScript(treatments) : "" ) + "\n" +

	/*
	"if ( (form.locationSt.selectedIndex == 0) && " +
	     "(form.newlocationSt.value == \"\")) {" +
	     "alert(\"Need a location ...\");" +
	     "return false;" +
	"}" +
	*/
	"form.submit(); \n" +
"} \n" +
"digits = \"1234567890\"; \n" +
"function isNumberString (inString) {" +
   "if (inString.length==0) return (false);" +
   "for (count=0; count<inString.length; count++) {" +
      "var tempChar = inString.charAt(count);" +
      "if (-1 == digits.indexOf(tempChar)) return (false);" +
   "}" +
   "return (true);" +
"}" + "\n" +
"function isFloatString (inString) {" +
   "if (inString.length==0) return (false);" +
   "return isFstring(inString);" +
"}" + "\n" +
"function isFstring (inString) {" +
   "var ch = inString.charAt(0);" +
   "var tail = inString.substring(1, inString.length);" +
   "if (ch == '.') return isNumberString(tail);" +
   "if (-1 == digits.indexOf(ch)) return (false);" +
   "if (tail.length == 0) return (true);" +
   "return isFstring(tail);" +
"}" + "\n" +
"</SCRIPT>";

      out.println("<BODY BGCOLOR=lightgreen>");

      out.println(script);
      if ( newDisease )
	out.println("<H3>Create new Disease:</H3>");
      else
	out.println("<H3>Edit the Disease: " + printName + "</H3>");

      out.println("<FORM METHOD='post' NAME='editDisease' " +
		  "ACTION='" + D.servletEditDisease2 + "'>");
      out.println("<table BORDER>");
      out.println("<tr><td><b>name:</b></td><td>" +
		  "<input type='text' name='name' size=50 value='" +
		  dis + "'> NO spaces as in: chronicBronchitis</td></tr>");
      out.println("<tr><td><b>printName:</b></td><td>" +
		  "<input type='text' name='printName' size=100 value=\"" +
		  printName + "\"> If different from name</td></tr>");
      out.println("<tr><td><b>description:</b></td><td>" + 
		  "<input type='text' name='description' size=200 value=\"" +
		  description + "\"></td></tr>");
      String [] allDiseases = Common.allDiseases();
      int lng = allDiseases.length;
      out.println("<tr><td><b>Select a superdisease if any:</b></td><td>");
      out.println("<SELECT name='superDisease'>");
      out.println("<OPTION VALUE='none'>none"); 
      String dis2, printName2;
      Disease disease2;
      for (int i = 0; i < lng; i++) {
	dis2 = allDiseases[i];
	disease2 = Common.getDisease(dis2);
	printName2 = disease2.getName();
	out.println("<OPTION VALUE='" + dis2 + "'" +
		    ( null == superDisease ? "" :
		      ( dis2.equals(superDisease) ? " SELECTED" : "")) +
		    ">" + printName2); 
      }
      out.println("</SELECT>");
      out.println("</td></tr>");

      String [] allDiseaseSets = Common.allDiseaseSets();
      lng = allDiseaseSets.length;
      out.println("<tr><td><b>Select a disease set:</b></td><td>");
      out.println("<SELECT name='diseaseSet'>");
      for (int i = 0; i < lng; i++) {
	dis2 = allDiseaseSets[i];
	out.println("<OPTION VALUE='" + dis2 + "'" +
		    ( null == diseaseSet ? "" :
		      ( dis2.equals(diseaseSet) ? " SELECTED" : "")) +
		    ">" + dis2); 
      }
      out.println("</SELECT>");
      out.println("</td></tr>");

      out.println("<tr><td><b>genderSpecificity if any:</b></td><td>");
      out.println("<SELECT name='genderSpecificity'>");
      out.println("<OPTION VALUE='none'" +
		  ( genderSpecificity.equals("none") ? " SELECTED" : "" ) +
		  ">none"); 
      out.println("<OPTION VALUE='male'" +
		  ( genderSpecificity.equals("male") ? " SELECTED" : "" ) +
		  ">male"); 
      out.println("<OPTION VALUE='female'" +
		  ( genderSpecificity.equals("female") ? " SELECTED" : "" ) +
		  ">female");
       out.println("<OPTION VALUE='moreMale'" +
		  ( genderSpecificity.equals("more male") ? " SELECTED" : "" ) +
		  ">more male"); 
      out.println("<OPTION VALUE='moreFemale'" +
		  ( genderSpecificity.equals("more female") ? " SELECTED" : "" ) +
		  ">more female");
      out.println("</SELECT>");
      out.println("</td></tr>");
      out.println("<tr><td><b>raceSpecificity if any:</b></td><td>");
      out.println("<SELECT name='raceSpecificity'>");
      out.println("<OPTION VALUE='none'" +
		  ( raceSpecificity.equals("none") ? " SELECTED" : "" ) +
		  ">none"); 
      out.println("<OPTION VALUE='africanAmerican'" +
		  ( raceSpecificity.equals("african american") ? " SELECTED" : "" ) +
		  ">african american"); 
      out.println("<OPTION VALUE='asian'" +
		  ( raceSpecificity.equals("asian") ? " SELECTED" : "" ) +
		  ">asian"); 
      out.println("<OPTION VALUE='caucasian'" +
		  ( raceSpecificity.equals("caucasian") ? " SELECTED" : "" ) +
		  ">caucasian"); 
      out.println("<OPTION VALUE='chineseAmerican'" +
		  ( raceSpecificity.equals("chinese american") ? " SELECTED" : "" ) +
		  ">chinese american");
      out.println("<OPTION VALUE='hispanic'" +
		  ( raceSpecificity.equals("hispanic") ? " SELECTED" : "" ) +
		  ">hispanic");
      out.println("<OPTION VALUE='indianAmerican'" +
		  ( raceSpecificity.equals("indian american") ? " SELECTED" : "" ) +
		  ">indian american");
      out.println("<OPTION VALUE='japaneseAmerican'" +
		  ( raceSpecificity.equals("japanese american") ? " SELECTED" : "" ) +
		  ">japanese american");
      out.println("<OPTION VALUE='jewish american'" +
		  ( raceSpecificity.equals("jewish american") ? " SELECTED" : "" ) +
		  ">jewish american");
      out.println("<OPTION VALUE='nativeIndian'" +
		  ( raceSpecificity.equals("native indian") ? " SELECTED" : "" ) +
		  ">native indian");
      out.println("</SELECT>");
      out.println("</td></tr>");

      // minage
      out.println("<tr><td><b>minAge (year):</b></td><td>" + 
		  "<input type='text' name='minAge' size=2 value='" +
		  minAge + "'></td></tr>");
      // maxage
      out.println("<tr><td><b>maxAge (year):</b></td><td>" + 
		  "<input type='text' name='maxAge' size=3 value='" +
		  maxAge + "'></td></tr>");

      // statusCondition
      out.println("<tr><td><b>statusCondition:</b></td><td>");
      out.println("<SELECT name='statusCondition'>");
      out.println("<OPTION VALUE='none'" +
		  ( statusCondition.equals("none") ? " SELECTED" : "" ) +
		  ">none");
      out.println("<OPTION VALUE='premenstruating'" +
		  ( statusCondition.equals("premenstruating") ? " SELECTED" : "" ) +
		  ">premenstruating");
      out.println("<OPTION VALUE='menstruating'" +
		  ( statusCondition.equals("menstruating") ? " SELECTED" : "" ) +
		  ">menstruating");
      out.println("<OPTION VALUE='pregnant'" +
		  ( statusCondition.equals("pregnant") ? " SELECTED" : "" ) +
		  ">pregnant");
      out.println("<OPTION VALUE='menopause'" +
		  ( statusCondition.equals("menopause") ? " SELECTED" : "" ) +
		  ">menopause");
      out.println("<OPTION VALUE='postmenopause'" +
		  ( statusCondition.equals("postmenopause") ? " SELECTED" : "" ) +
		  ">postmenopause");
      out.println("</SELECT>");
      out.println("</td></tr>");

      // duration
      String durationSt = "" + duration;
      out.println("<tr><td><b>duration:</b></td><td>");
      out.println("<SELECT name='duration'>");
      out.println("<OPTION VALUE=0" +
		  ( durationSt.equals("0") ? " SELECTED" : "" ) +
		  ">critically acute"); 
      out.println("<OPTION VALUE=-1" +
		  ( durationSt.equals("-1") ? " SELECTED" : "" ) +
		  ">chronic"); 
      out.println("<OPTION VALUE=-2" +
		  ( durationSt.equals("-2") ? " SELECTED" : "" ) +
		  ">less than a day"); 
      out.println("<OPTION VALUE=-3" +
		  ( durationSt.equals("-3") ? " SELECTED" : "" ) +
		  ">less than a week"); 
      out.println("<OPTION VALUE=-4" +
		  ( durationSt.equals("-4") ? " SELECTED" : "" ) +
		  ">less than a month"); 
      out.println("<OPTION VALUE=-5" +
		  ( durationSt.equals("-5") ? " SELECTED" : "" ) +
		  ">less than 3 months"); 
      out.println("<OPTION VALUE=-6" +
		  ( durationSt.equals("-6") ? " SELECTED" : "" ) +
		  ">less than 6 months"); 
      out.println("<OPTION VALUE=-7" +
		  ( durationSt.equals("-7") ? " SELECTED" : "" ) +
		  ">less than a year"); 
      out.println("<OPTION VALUE=-10" +
		  ( durationSt.equals("-10") ? " SELECTED" : "" ) +
		  ">unknown"); 
      out.println("<OPTION VALUE=-11" +
		  ( durationSt.equals("-11") ? " SELECTED" : "" ) +
		  ">NA"); 
      out.println("</SELECT>");
      out.println("</td></tr>");
      out.println("<tr><td><b>Diagnostic frequency:</b></td><td>" + 
		  "<input type='text' name='frequency' size=5 value='" +
		  frequency + "'> # diagnosis in 1000</td></tr>");

      // body system
      String [] allBSs = Common.allBodySystems();
      lng = allBSs.length;
      out.println("<tr><td><b>Select a body system:</b></td><td>");
      out.println("<SELECT name='bodySystem'>");
      // String dis2, printName2;
      BodySystem bs2;
      out.println("<OPTION VALUE='newBodySystem'>new body system");
      for (int i = 0; i < lng; i++) {
	dis2 = allBSs[i];
	bs2 = Common.getBodySystem(dis2);
	printName2 = bs2.getName();
	out.println("<OPTION VALUE='" + dis2 + "'" +
		    ( null == bodySystem ? "" :
		      ( dis2.equals(bodySystem) ? " SELECTED" : "" ) ) +
		    ">" + printName2); 
      }
      out.println("</SELECT>");
      out.println("</td></tr>");

      // underlying disease
      lng = allDiseases.length;
      out.println("<tr><td><b>Select an underlying disease if any:</b></td><td>");
      out.println("<SELECT name='underlyingDisease'>");
      out.println("<OPTION VALUE='none'>none"); 
      // String dis2, printName2;
      // Disease disease2;
      for (int i = 0; i < lng; i++) {
	dis2 = allDiseases[i];
	disease2 = Common.getDisease(dis2);
	printName2 = disease2.getName();
	out.println("<OPTION VALUE='" + dis2 + "'" + 
		    ( null == underlyingDisease ? "" :
		      ( dis2.equals(underlyingDisease) ? " SELECTED" : "")) +
		    ">" + printName2); 
      }
      out.println("</SELECT>");
      out.println("</td></tr>");

      // genetic
      out.println("<tr><td><b>Genetic if any:</b></td><td>");
      out.println("<SELECT name='genetic'>");
      out.println("<OPTION VALUE='none' " +
		  ( genetic.equals("none") ? "SELECTED" : "" ) + "> none");
      out.println("<OPTION VALUE='1parent' " +
		  ( genetic.equals("1parent") ? "SELECTED" : "" ) + ">at least 1 parent");
      out.println("<OPTION VALUE='2parents' " +
		  ( genetic.equals("2parents") ? "SELECTED" : "" ) + ">both parents");
      out.println("<OPTION VALUE='father' " +
		  ( genetic.equals("father") ? "SELECTED" : "" ) + ">father");
      out.println("<OPTION VALUE='mother' " +
		  ( genetic.equals("mother") ? "SELECTED" : "" ) + ">mother");
      out.println("</SELECT> ");
      lng = allDiseases.length;
      out.println("<SELECT name='parentDisease'>");
      out.println("<OPTION VALUE='thisDisease'>this disease"); 
      // String dis2, printName2;
      // Disease disease2;
      for (int i = 0; i < lng; i++) {
	dis2 = allDiseases[i];
	disease2 = Common.getDisease(dis2);
	printName2 = disease2.getName();
	out.println("<OPTION VALUE='" + dis2 + "'" + 
		    ( null != parentDisease && dis2.equals(parentDisease) ?
		      " SELECTED" : "" ) +
		    ">" + printName2); 
      }
      out.println("</SELECT>");
      out.println("</td></tr>");

      // symptoms
      int anchor = 0;
      Symptom symptom;
      if ( bSymptoms ) {
	out.println("<tr><td><b>Symptoms:</b></td></tr>");
	lng = symptoms.size();
	WeightedSymptom ws;
	float weight;
	String elaboration;
	String sym, description2;
	for (int i = 0; i < lng; i++) {
	  ws = (WeightedSymptom) symptoms.elementAt(i);
	  sym = ws.getSymptom();
	  allSymptoms2.addElement(sym);
	  weight = ws.getWeight();
	  elaboration = ws.getElaboration();
	  if ( elaboration.equals("") ) elaboration = " ";
	  symptom = Common.getSymptom(sym);
	  printName2 = symptom.getPrintName();
	  description2 = symptom.getDescription();
	  out.println(
	     "<tr><td>" + // printName2 + " " +
	     "<INPUT TYPE='radio' NAME='" + sym + "' VALUE='keep' CHECKED> keep? " +
	     // "<INPUT TYPE='radio' NAME='" + sym + "' VALUE='edit'> edit? " +
	     "<INPUT TYPE='radio' NAME='" + sym + "' VALUE='remove'> remove? " +
	     "</td>");
	  anchor++;
	  out.println("<td>" +
		      "<A HREF='#" + anchor + 
		      "' NAME='" + anchor + "' onClick=\"alert('" +
		      description2 + "')\">" +
		      printName2 + "</A> " + 
		      "<input type='text' name='" + sym + "weight' size=3 value='" +
		      weight + "'> " + 
		      "<input type='text' name='" + sym + "elab' size=60 value='" +
		      elaboration + "'> " + 
		      "</td></tr>");
	}
      }
      String [] allSymptoms = Common.allSymptoms(); 
      lng = allSymptoms.length;
      out.println("<tr><td><b>Add symptom(s):</b></td><td>");
      out.println("<SELECT name='addSymptoms' MULTIPLE SIZE=6>");
      // String dis;
      // Symptom symptom;
      for (int i = 0; i < lng; i++) {
	dis = allSymptoms[i];
	symptom = Common.getSymptom(dis);
	printName2 = symptom.getName();
	out.println("<OPTION VALUE='" + dis + "'>" + printName2); 
      }
      out.println("</SELECT>");
      out.println("?</td></tr>");

      // externalCauses
      if ( bExternalCauses ) {
	out.println("<tr><td><b>ExternalCauses:</b></td></tr>");
	lng = externalCauses.size();
	String sym, ec;
	for (int i = 0; i < lng; i++) {
	  sym = (String) externalCauses.elementAt(i);
	  ec = eliminateSpace(sym);
	  // ec = sym.replace(' ', '_');
	  allExternalCauses2.addElement(ec);
	  anchor++;
	  out.println("<tr><td>" + sym
		       + "</A>" +
		      "</td>");
	  out.println(
	     "<td>" + // printName2 + " " +
	     "<INPUT TYPE='radio' NAME='" + ec + "' VALUE='keep' CHECKED> keep? " +
	     // "<INPUT TYPE='radio' NAME='" + ec + "' VALUE='edit'> edit? " +
	     "<INPUT TYPE='radio' NAME='" + ec + "' VALUE='remove'> remove? " +
	     "</td></tr>");
	}
      }
      String [] allExternalCauses = Common.allExternalCauses(); 
      lng = allExternalCauses.length;
      out.println("<tr><td><b>Add externalCause(s):</b></td><td>");
      out.println("<SELECT name='addExternalCauses' MULTIPLE SIZE=6>");
      // String dis2;
      // ExternalCause externalCause;
      for (int i = 0; i < lng; i++) {
	dis = allExternalCauses[i];
	dis2 = eliminateSpace(dis);
	// dis2 = dis.replace(' ', '_');
	out.println("<OPTION VALUE=\"" + dis2 + "\">" + dis); 
      }
      out.println("</SELECT>");
      out.println("?</td></tr>");

      out.println("<tr><td><b>Add new externalCause(s):</b>" +
		  "<br>| = separator</td><td>" +
		  "<input type='text' name='newExternalCauses' size=200 value=\"\"" +
		  "></td></tr>");

      // internalCauses
      if ( bInternalCauses ) {
	out.println("<tr><td><b>InternalCauses:</b></td></tr>");
	lng = internalCauses.size();
	String sym, description2;
	// Disease disease;
	for (int i = 0; i < lng; i++) {
	  sym = (String) internalCauses.elementAt(i);
	  allInternalCauses2.addElement(sym);
	  disease = Common.getDisease(sym);
	  printName2 = (null == disease ? sym : disease.getPrintName());
	  description2 = (null == disease ? sym : disease.getDescription());
	  anchor++;
	  out.println("<tr><td>" +
		      "<A HREF='#" + anchor + 
		      "' NAME='" + anchor + "' onClick=\"alert('" +
		      description2 + "')\">" +
		      printName2 + "</A>" +
		      "</td>");
	  sym = eliminateSpace(sym);
	  out.println(
	     "<td>" + // printName2 + " " +
	     "<INPUT TYPE='radio' NAME=ic" + sym + " VALUE=keep CHECKED> keep? " +
	     // "<INPUT TYPE='radio' NAME=ic" + sym + " VALUE=edit> edit? " +
	     "<INPUT TYPE='radio' NAME=ic" + sym + " VALUE=remove> remove? " +
	     "</td></tr>");
	}
      }
      // String [] allDiseases = Common.allDiseases(); 
      lng = allDiseases.length;
      out.println("<tr><td><b>Add internal cause(s):</b></td><td>");
      out.println("<SELECT name=addInternalCauses MULTIPLE SIZE=6>");
      // String dis;
      // Disease disease;
      for (int i = 0; i < lng; i++) {
	dis = allDiseases[i];
	disease = Common.getDisease(dis);
	printName2 = (null == disease ? dis : disease.getName());
	out.println("<OPTION VALUE='" + dis + "'>" + printName2); 
      }
      out.println("</SELECT>");
      out.println("?</td></tr>");

       // causingSets
      DiseaseSet diss;
      if ( bCausingSets ) {
	out.println("<tr><td><b>causingSets:</b></td></tr>");
	lng = causingSets.size();
	String sym, description2;
	for (int i = 0; i < lng; i++) {
	  sym = (String) causingSets.elementAt(i);
	  allCausingSets2.addElement(sym);
	  diss = Common.getDiseaseSet(sym);
	  out.println("<tr><td>" + sym +
		      "</td>");
	  out.println(
	     "<td>" + // printName2 + " " +
	     "<INPUT TYPE='radio' NAME='aDisSet" + sym + "' VALUE='keep' CHECKED> keep? " +
	     // "<INPUT TYPE='radio' NAME='ac2" + sym + "' VALUE='edit'> edit? " +
	     "<INPUT TYPE='radio' NAME='aDisSet" + sym + "' VALUE='remove'> remove? " +
	     "</td></tr>");
	}
      }
      // String [] allAbnormalConditions = Common.allAbnormalConditions(); 
      lng = allDiseaseSets.length;
      out.println("<tr><td><b>Add causing disease set(s):</b></td><td>");
      out.println("<SELECT name='addCausingDiseaseSets' MULTIPLE SIZE=6>");
      // String dis;
      for (int i = 0; i < lng; i++) {
	dis = allDiseaseSets[i];
	out.println("<OPTION VALUE='" + dis + "'>" + dis); 
      }
      out.println("</SELECT>");
      out.println("?</td></tr>");

      // causingAbnormalConditions
      AbnormalCondition abnormalCondition;
      if ( bCausingAbnormalConditions ) {
	out.println("<tr><td><b>causingAbnormalConditions:</b></td></tr>");
	lng = causingAbnormalConditions.size();
	String sym, description2;
	for (int i = 0; i < lng; i++) {
	  sym = (String) causingAbnormalConditions.elementAt(i);
	  allCausingAbnormalConditions2.addElement(sym);
	  abnormalCondition = Common.getAbnormalCondition(sym);
	  printName2 = (null == abnormalCondition ? sym : abnormalCondition.getPrintName());
	  description2 = (null == abnormalCondition ? sym : 
			  abnormalCondition.getDescription());
	  anchor++;
	  out.println("<tr><td>" +
		      "<A HREF='#" + anchor + 
		      "' NAME='" + anchor + "' onClick=\"alert('" +
		      description2 + "')\">" +
		      printName2 + "</A>" +
		      "</td>");
	  out.println(
	     "<td>" + // printName2 + " " +
	     "<INPUT TYPE='radio' NAME='ac1" + sym + "' VALUE='keep' CHECKED> keep? " +
	     // "<INPUT TYPE='radio' NAME='ac1" + sym + "' VALUE='edit'> edit? " +
	     "<INPUT TYPE='radio' NAME='ac1" + sym + "' VALUE='remove'> remove? " +
	     "</td></tr>");
	}
      }
      String [] allAbnormalConditions = Common.allAbnormalConditions(); 
      lng = allAbnormalConditions.length;
      out.println("<tr><td><b>Add causing ac(s):</b></td><td>");
      out.println("<SELECT name='addCausingAbnormalConditions' MULTIPLE SIZE=6>");
      // String dis;
      // AbnormalCondition abnormalCondition;
      for (int i = 0; i < lng; i++) {
	dis = allAbnormalConditions[i];
	abnormalCondition = Common.getAbnormalCondition(dis);
	printName2 = (null == abnormalCondition ? dis : abnormalCondition.getName());
	out.println("<OPTION VALUE='" + dis + "'>" + printName2); 
      }
      out.println("</SELECT>");
      out.println("?</td></tr>");

      // causes diseases
      if ( bCausesDiseases ) {
	out.println("<tr><td><b>causesDiseases:</b></td></tr>");
	lng = causesDiseases.size();
	String sym, description2;
	// Disease disease;
	for (int i = 0; i < lng; i++) {
	  sym = (String) causesDiseases.elementAt(i);
	  allCausesDiseases2.addElement(sym);
	  disease = Common.getDisease(sym);
	  printName2 = (null == disease ? sym : disease.getPrintName());
	  description2 = (null == disease ? sym : disease.getDescription());
	  anchor++;
	  out.println("<tr><td>" +
		      "<A HREF='#" + anchor + 
		      "' NAME='" + anchor + "' onClick=\"alert('" +
		      description2 + "')\">" +
		      printName2 + "</A>" +
		      "</td>");
	  out.println(
	     "<td>" + // printName2 + " " +
	     "<INPUT TYPE='radio' NAME='cd" + sym + "' VALUE='keep' CHECKED> keep? " +
	     // "<INPUT TYPE='radio' NAME='cd" + sym + "' VALUE='edit'> edit? " +
	     "<INPUT TYPE='radio' NAME='cd" + sym + "' VALUE='remove'> remove? " +
	     "</td></tr>");
	}
      }
      // String [] allDiseases = Common.allDiseases(); 
      lng = allDiseases.length;
      out.println("<tr><td><b>Add causes disease(s):</b></td><td>");
      out.println("<SELECT name='addCausesDiseases' MULTIPLE SIZE=6>");
      // String dis;
      // Disease disease;
      for (int i = 0; i < lng; i++) {
	dis = allDiseases[i];
	disease = Common.getDisease(dis);
	printName2 = (null == disease ? dis : disease.getName());
	out.println("<OPTION VALUE='" + dis + "'>" + printName2); 
      }
      out.println("</SELECT>");
      out.println("?</td></tr>");

       // causesAbnormalConditions
      // AbnormalCondition abnormalCondition;
      if ( bCausesAbnormalConditions ) {
	out.println("<tr><td><b>causesAbnormalConditions:</b></td></tr>");
	lng = causesAbnormalConditions.size();
	String sym, description2;
	for (int i = 0; i < lng; i++) {
	  sym = (String) causesAbnormalConditions.elementAt(i);
	  allCausesAbnormalConditions2.addElement(sym);
	  abnormalCondition = Common.getAbnormalCondition(sym);
	  printName2 = (null == abnormalCondition ? sym : abnormalCondition.getPrintName());
	  description2 = (null == abnormalCondition ? sym : 
			  abnormalCondition.getDescription());
	  anchor++;
	  out.println("<tr><td>" +
		      "<A HREF='#" + anchor + 
		      "' NAME='" + anchor + "' onClick=\"alert('" +
		      description2 + "')\">" +
		      printName2 + "</A>" +
		      "</td>");
	  out.println(
	     "<td>" + // printName2 + " " +
	     "<INPUT TYPE='radio' NAME='ac2" + sym + "' VALUE='keep' CHECKED> keep? " +
	     // "<INPUT TYPE='radio' NAME='ac2" + sym + "' VALUE='edit'> edit? " +
	     "<INPUT TYPE='radio' NAME='ac2" + sym + "' VALUE='remove'> remove? " +
	     "</td></tr>");
	}
      }
      // String [] allAbnormalConditions = Common.allAbnormalConditions(); 
      lng = allAbnormalConditions.length;
      out.println("<tr><td><b>Add causes ac(s):</b></td><td>");
      out.println("<SELECT name='addCausesAbnormalConditions' MULTIPLE SIZE=6>");
      // String dis;
      // AbnormalCondition abnormalCondition;
      for (int i = 0; i < lng; i++) {
	dis = allAbnormalConditions[i];
	abnormalCondition = Common.getAbnormalCondition(dis);
	printName2 = (null == abnormalCondition ? dis : abnormalCondition.getName());
	out.println("<OPTION VALUE='" + dis + "'>" + printName2); 
      }
      out.println("</SELECT>");
      out.println("?</td></tr>");

      // miscComments
      out.println("<tr><td><b>miscComments:</b></td><td>" +
		  "<input type='text' name='miscComments' size=400 value='" +
		  miscComments + "'> misc comments (400 chars max)</td></tr>");
      
      // Literature
      if ( bLiterature ) {
	out.println("<tr><td><b>Literature:</b></td></tr>");
	lng = literature.size();
	String sym, description2, liName, liNameValue;
	for (int i = 0; i < lng; i++) {
	  sym = (String) literature.elementAt(i);
	  liName = "li" + i;
	  liNameValue = liName + "Value";
	  allLiterature2.addElement(liName);
	  out.println(
	     "<tr><td>" + // printName2 + " " +
	     "<INPUT TYPE='radio' NAME='" + liName + "' VALUE='keep' CHECKED> keep? " +
	     // "<INPUT TYPE='radio' NAME='" + sym + "' VALUE='edit'> edit? " +
	     "<INPUT TYPE='radio' NAME='" + liName + "' VALUE='remove'> remove? " +
	     "</td>");
	  out.println("<td>" + sym +
		      "</td></tr>");
	  out.println("<input TYPE=\"hidden\" " +
		      "NAME=\"" + liNameValue + "\" " +
		      " VALUE=\"" + sym + "\">");
	}
      }
      out.println("<tr><td><b>add literature ref?:</b></td>");
      out.println("<td><input type='text' name='addLitRef' size=120 value=''" +
		  "></td></tr>");

      // temperature
      out.println("<tr><td><b>setTemperature:</b></td>");
      out.println("<td><input type='text' name='setTemperature' size=5 value='" +
		  setTemperature + "'></td></tr>");

      // treatments
      if ( bTreatments ) {
	out.println("<tr><td><b>Treatments:</b></td></tr>");
	lng = treatments.size();
	String sym, description2;
	Treatment treatment;
	for (int i = 0; i < lng; i++) {
	  sym = (String) treatments.elementAt(i);
	  allTreatments2.addElement(sym);
	  treatment = Common.getTreatment(sym);
	  // printName2 = treatment.getPrintName();
	  description2 = treatment.alertDescription();
	  anchor++;
	  out.println("<tr><td><b>" + sym + "</b><br>" + description2 + "</td>");
	  out.println(
	     "<td>" + // printName2 + " " +
	     "<INPUT TYPE='radio' NAME='" + sym + "' VALUE='keep' CHECKED> keep? " +
	     "<INPUT TYPE='radio' NAME='" + sym + "' VALUE='edit'> edit? " +
	     "<INPUT TYPE='radio' NAME='" + sym + "' VALUE='remove'> remove? " +
	     "</td></tr>");
	}
      }

      out.println("<tr><td><b>Add Treatment?:</b></td>");
      out.println(
	     "<td>" + // printName2 + " " +	
	     "<INPUT TYPE='radio' NAME='addTreatment' VALUE='no' CHECKED> no " +
	     "<INPUT TYPE='radio' NAME='addTreatment' VALUE='yes'> yes " +
	     "</td></tr>");
      out.println("<tr><td><b>webResource:</b></td><td>" +
		  "<input type='text' name='webResource' size=100 value='" +
		  webResource + "'> </td></tr>");

      out.println("</table>");
      out.println("<p><input type='button' value='Submit' " +
		  "onClick= \"checkForm(this.form)\">");
      String vecStr;
      if ( bSymptoms ) {
	vecStr = allSymptoms2.toString();
	out.println("<input TYPE=\"hidden\" NAME=\"symptomsList\" " +
		    "VALUE=\"" + vecStr.substring(1, vecStr.length()-1) +
		    "\">");
      }
      if ( bExternalCauses ) {
	vecStr = allExternalCauses2.toString();
	out.println("<input TYPE=\"hidden\" NAME=\"externalCausesList\" " +
		    "VALUE=\"" + vecStr.substring(1, vecStr.length()-1) +
		    "\">");
      }
      if ( bInternalCauses ) {
	vecStr = allInternalCauses2.toString();
	out.println("<input TYPE=\"hidden\" NAME=\"internalCausesList\" " +
		    "VALUE=\"" + vecStr.substring(1, vecStr.length()-1) +
		    "\">");
      }
      if ( bCausingSets ) {
	vecStr = allCausingSets2.toString();
	out.println("<input TYPE=\"hidden\" NAME=\"causingSetsList\" " +
		    "VALUE=\"" + vecStr.substring(1, vecStr.length()-1) +
		    "\">");
      }
      if ( bCausingAbnormalConditions ) {
	vecStr = allCausingAbnormalConditions2.toString();
	out.println("<input TYPE=\"hidden\" NAME=\"causingAbnormalConditionsList\" " +
		    "VALUE=\"" + vecStr.substring(1, vecStr.length()-1) +
		    "\">");
      }
      if ( bCausesDiseases ) {
	vecStr = allCausesDiseases2.toString();
	out.println("<input TYPE=\"hidden\" NAME=\"causesDiseasesList\" " +
		    "VALUE=\"" + vecStr.substring(1, vecStr.length()-1) +
		    "\">");
      }
      if ( bCausesAbnormalConditions ) {
	vecStr = allCausesAbnormalConditions2.toString();
	out.println("<input TYPE=\"hidden\" NAME=\"causesAbnormalConditionsList\" " +
		    "VALUE=\"" + vecStr.substring(1, vecStr.length()-1) +
		    "\">");
      }
      if ( bLiterature ) {
	vecStr = allLiterature2.toString();
	out.println("<input TYPE=\"hidden\" NAME=\"literatureList\" " +
		    "VALUE=\"" + vecStr.substring(1, vecStr.length()-1) +
		    "\">");
      }
      // out.println("<input TYPE=\"hidden\" NAME=\"literatureList\" VALUE=\"\">");
      // out.println("<input TYPE=\"hidden\" NAME=\"treatmentsList\" VALUE=\"\">");
      if ( bTreatments ) {
	vecStr = allTreatments2.toString();
	out.println("<input TYPE=\"hidden\" NAME=\"treatmentsList\" " +
		    "VALUE=\"" + vecStr.substring(1, vecStr.length()-1) +
		    "\">");
      }
      out.println("</FORM>");

      out.println("<SCRIPT LANGUAGE='JavaScript'> " +
		  "document.forms[0].name.focus(); " +
		  "</SCRIPT>");

      out.println("</BODY>");
      out.println("</HTML>");
    }

  // this will "polish" a string with spaces/ the inverse is Common.unPolish
  static public String eliminateSpace(String in) {
    int ix = in.indexOf(' ');
    if ( ix < 0 ) return in;
    return eliminateSpace(
	in.substring(0, ix) +
	Character.toUpperCase(in.charAt(ix+1)) +
	in.substring(ix+2) );
  }


}




