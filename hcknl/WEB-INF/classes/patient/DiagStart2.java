// (C) OntoOO Inc 2003 Mar
package patient;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import com.DV;
import com.D;
import com.L;
import misc.DiagStackEntry;
import misc.DB;
import com.Common;
import concepts.Disease;
import concepts.DiseaseSet;
import concepts.LocationRelation;
import concepts.Location;
import concepts.PartOfLocation;
import concepts.BodySystem;
import com.DVM;
import com.LR;
import misc.SessionExpired;

public class DiagStart2 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {

      HttpSession session = req.getSession(false);
      if ( null == session ) {	
	  SessionExpired.call(res,
			      DV.DiagStart);
	  return;
      }
      session.removeValue("enteringFrom"); // clean out if the user searches again
      session.putValue("diagnosis", "started");
      session.putValue("searchMode", "unspecified"); // used in Diag1c

      DB props = (DB) session.getValue("theDB");
      String gender = props.getProperty("gender");

      // wait until loading has completed

      int waitCnt = 0;
      while ( !Common.getTheBodySystemsLoaded() ) { 
	try { Thread.sleep(1000); } catch (InterruptedException ignore) {}
	waitCnt++;
      }

	HashSet D1 = (HashSet) session.getValue("D1"); // all diaseases

	// Get resources:
	int lng, lng2;
	String diseaseName, diseasePrintName, printName;
	Disease dis;
	String subSys;
	String disSet;
	String bsGender;
	DiseaseSet diseaseSet;

	String locName2;
	LocationRelation lr;
	Vector vec;

	PartOfLocation loc2;
	/*
	DiseaseSet lifeThreateningDiseases = Common.getDiseaseSet(LR.lifeThreateningDisorders);
	Vector lifeThreateningDiseaseMembers = lifeThreateningDiseases.getDiseaseMembers();
	Collections.sort(lifeThreateningDiseaseMembers);

	String [] allDiseases = Common.allDiseases();
	*/

	BodySystem bs = Common.getBodySystem("bodySys");
	Vector subSystems = bs.getSubSystems();

	String [] allDiseaseSets = Common.allDiseaseSets();

	Location body = Common.getLocation("body");
	Vector parts = body.getParts();

        res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html><head><title>" + L.SelectSearch + "</title>" +
		    D.linkHckStyle +
		    D.favicon +
		    "</head>");

String script =
"<script language=\"JavaScript\">" +
    /*
"function displayDisease(dis) { \n" +
"  diseaseWindow = open( \n" +
"    \"" + D.servletShowDisease + "?dis=\"+dis, \n" +
"    \"diseaseWindowName\", \n" +
"    \"toolbar=yes,resizable=yes,scrollbars=yes,height=600,width=900\" \n" +
"  ); \n" +
"} \n" +

"function doLifeThreatening(form) { \n" +
       // verify that at least something is entered
"item = form.showLifeThreateningDisease.selectedIndex; \n" +
"if ( 0 == item ) { \n" +
"  alert('Cant proceed without your input!!!');  \n" +
"  return false; \n" +
"  } \n" +
"displayDisease(form.showLifeThreateningDisease.options[item].value); \n" +
"} \n" +
    */
"function checkLTD(form) { \n" +
       // verify that at least something is entered
"if ( \"\" == form.userInput.value ) { \n" +
"  alert('Cant proceed without your input!!!');  \n" +
"  return false; \n" +
"  } \n" +
"form.submit(); \n" +
"} \n" +

"function checkDiseasesubsets(form) { \n" +
       // verify that at least something is entered
"var cnt = 0; \n" +
"var lng = form.diseasesubset.length; \n" +
"for (i=0; i<lng; i++) \n" +
"  if ( form.diseasesubset[i].checked ) cnt++; \n" +
"if ( 0 == cnt ) { \n" +
"  alert('Cant proceed without your input!!!');  \n" + 
"  return false; \n" +
"} \n" +
"form.submit(); \n" +
"} \n" +

"function checkUnrestricted(form) { \n" +
       // verify that at least something is entered
"item = form.bodyPart.selectedIndex; \n" +
"if ( 0 == item && \"\" == form.userInput.value ) { \n" +
"  alert('Cant proceed without your input!!!');  \n" +
"  return false; \n" +
"  } \n" +
"form.submit(); \n" +
"} \n" +

"function checkFocus(form) { \n" +
       // verify that at least something is entered
"if ( \"\" == form.userInput.value ) { \n" +
"  alert('Cant proceed without your input!!!');  \n" +
"  return false; \n" +
"  } \n" +
"form.submit(); \n" +
"} \n" +

"</script>";

	out.println(script);

String temperatureInput = 
"<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">" + L.TemperatureF + "</font></td><td> \n" +
"       <select name=\"temperatureSelected\"> \n" +
"           <option value=\">104\"> >104 </option> \n" +
"           <option value=\"104\"> 104 </option> \n" +
"           <option value=\"103\"> 103 </option> \n" +
"           <option value=\"high\"> high </option> \n" +
"           <option value=\"102\"> 102 </option> \n" +
"           <option value=\"101\"> 101 </option> \n" +
"           <option value=\"raised\"> raised </option> \n" +
"           <option value=\"100\"> 100 </option> \n" +
"           <option value=\"normal\" selected=\"selected\"> normal </option> \n" +
"           <option value=\"99\"> 99 </option> \n" +
"           <option value=\"98\"> 98 </option> \n" +
"           <option value=\"lowered\"> lowered </option> \n" +
"           <option value=\"97\"> 97 </option> \n" +
"           <option value=\"96\"> 96 </option> \n" +
"           <option value=\"low\"> low </option> \n" +
"           <option value=\"<96\"> <96 </option> \n" +
"       </select> </td></tr>";

	out.println("<body>" +
		    "<font color=\"#850a0a\">");
	// out.println("Loading wait count: " + waitCnt);

	out.println(DVM.htmlLogoutUser(
				       // "OK, Here the Search Options" +
				       L.DiagStartS1 ));

	out.println(
	   "<a name=\"top\"> \n" + 
	   "<font size=\"4\">" +
	   // "There are several ways to proceed. " +
	   // "Whatever your choice you always can start over." + 
	   L.DiagStartS2 +
	   "<br /> " +
	   // "If this is your first visit, jump around on this page with the " +
	   // "links below before making your choice." +
	   // L.DiagStartS3 +
	   // "<br />" +
	   "<ul>" +
	   /*
	   "<li> <a href=\"#searchFocussed\">" + 
	         // "Focussed Search among the Diseases Associated " +
	         // "with Initial Input - RECOMMENDED" +
	         L.DiagStartS4 +
	         "</a> \n" +
	   */
	   "<li> <a href=\"#searchLifeThreateningDiseases\">" + 
	         // "Search in the Subset of Life Threatening Diseases" + 
	         L.DiagStartS5 +
	         "</a> \n" +
	   "<li> <a href=\"#subsystem\">" +
	         // "Search in the Subset of Diseases Associated with a Body Subsystem" + 
	         L.DiagStartS6 +
	         "</a>\n" +
	   "<li> <a href=\"#diseasesubsets\">" +
	         // "Search in Disease Subset(s) of your Choice" +
	         L.DiagStartS7 +
	         "</a> \n" +
	   "<li> <a href=\"#unrestricted\">" +
	         // "Search in all Diseases" +
	         L.DiagStartS8 +
	         "</a> \n" +
	   "</ul>" +
	   "</font><p> \n");

	// ------------------------------------------------------------------------
	/*
	out.println(
	   "<a name=\"searchFocussed\"> \n" +
	   "<form name=\"focussed\" action=\"" + D.servletDiag1Focussed + "\"> \n" +
	   "<table border=\"1\" width=\"100%\"> \n" +
	   "<tr><th colspan=\"2\"><font size=\"4\">" + 
	       "<b>" +
	       // "Focussed Search - RECOMMENDED" +
	       L.DiagStartS9 +
               "</b></font></th></tr> \n" +
	   "<tr><th colspan=\"2\">" +
	        // "This search mode may be the fastest." +
                L.DiagStartS10 +
                "</th></tr>\n" +
	   "<tr><td width=\"30%\"><font size=\"4\">" +
	        // "Select body location and/or:" +
                L.DiagStartS11 +
                "</font></td><td>");
	out.println("<select name=\"bodyPart\">");
	out.println("      <option value=\"unspecified\">" + L.unspecified + "</option>");

	parts = DiagStart.filterParts(parts, gender);
	lng = parts.size();
	for (int i = 0; i < lng; i++) {
	  locName2 = (String) parts.elementAt(i);
	  loc2 = (PartOfLocation) Common.getLocation(locName2);
	  printName = loc2.getPrintName();
	  out.println("      <option value=\"" + locName2 + "\">" + printName + "</option>");
	}

	out.println("</select>");
	out.println(DiagStart.hintToNarrow("loc1"));
	out.println(DiagStart.hintLocWhat("loc1What"));
	out.println("</td></tr>");

	out.println(
            "<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">" +
	         // "Provide one or more symptoms:" +
	         L.DiagStartS12 +
	         "</font></td> \n" +
	    "<td><input type=\"text\" name=\"userInput\" size=\"100\" maxlength=\"100\" value=\"\" /></td></tr>"); 

	out.println(temperatureInput);

	out.println(
	    "<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">" +
	         // "Please check your choice before submitting!" +
	         L.Diag1bS13 +
	         "</font></td> \n" +
	    "<td><input type=\"button\" value=\"Submit\" " +
		    "onClick=\"checkFocus(this.form)\" /> </td></tr>");

	out.println(
	   "</table> \n" +
	   "</form><br /> \n" +
	   "<a href=\"#top\">" +
	       // "Return to top of page" +
	       L.topOfPage +
	       "</a><p>");
	*/

	// ------------------------------------------------------------------------

	out.println(
	   "<a name=\"searchLifeThreateningDiseases\"> \n" +
	   "<form name=\"expert\" action=\"" + D.servletDiag1SearchLTD + "\"> \n" +
	   "<table border=\"1\" width=\"100%\"> \n" +
	   "<tr><th colspan=\"2\"><font color=\"#850a0a\" size=\"4\">" + 
	   "<b>" +
	       // "Search in the Subset of Life Threatening Diseases" +
	       L.DiagStartS13 +
	   "</b></font></th></tr>");

	out.println(
            "<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">" +
	        // "Provide one or more symptoms:" +
	        L.DiagStartS12 +
	        "</font></td> \n" +
	    "<td><input type=\"text\" name=\"userInput\" size=\"100\" maxlength=\"100\" value=\"\" /></td></tr>");

	out.println(temperatureInput);

	out.println(
	    "<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">" +
	        // Please check your data before submitting!" +
	        L.Diag1bS13 +
	        "</font></td> \n" +
	    "<td><input type=\"button\" value=\"Submit\" " +
		    "onClick=\"checkLTD(this.form)\" /> </td></tr>");
	out.println(
	   "</table> \n" +
	   "</form><br /> \n" +
	   "<a href=\"#top\">" + 
	       // "Return to top of page" +
	       L.topOfPage +
	   "</a><p>");
	   
	// ------------------------------------------------------------------------

	out.println(
	   "<a name=\"subsystem\"> \n" +
	   "<form name=\"subsystem\" action=\"" + D.servletDiag1Subsystem + "\"> \n" +
	   "<table border=\"1\" width=\"100%\"> \n" +
	   "<tr><th colspan=\"2\"><font color=\"#850a0a\" size=\"4\">" + 
	       "<b>" +
	        // "Search in the Subset of Diseases Associated with a Body Subsystem" +
	        L.DiagStartS14 +
	        "</b></font></th></tr> \n" +
	   "<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">Select:</font></td><td>");
	out.println("<select name=\"system\">");
	lng = subSystems.size();
	for (int i = 0; i < lng; i++) {
	  subSys = (String) subSystems.elementAt(i);
	  bs = Common.getBodySystem(subSys);
	  bsGender = bs.getGender();
	  if ( !bsGender.equals(LR.both) && !bsGender.equals(gender) ) continue;
	  vec = bs.getAllDiseases();
	  if ( 0 == vec.size() ) continue;
	  printName = bs.getPrintName();
	  out.println("      <option value=\"" + subSys + "\">" + printName + "</option>");
	}
	out.println("</select>");
	out.println(DiagStart.hintToNarrow("sys1"));
	out.println("</td></tr>");

	out.println(
            "<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">" +
	        // "Provide one or more symptoms:" +
	        L.DiagStartS12 +
	        "</font></td> \n" +
	    "<td><input type=\"text\" name=\"userInput\" size=\"100\" maxlength=\"100\" value=\"\" /></td></tr>");

	out.println(temperatureInput);

	out.println(
	    "<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">" +
	        // "Please check your choice before submitting!"
	        L.Diag1bS13 +
	        "</font></td> \n" +
	    "<td><input type=\"submit\" value=\"Submit\" /> </td></tr>");

	out.println(
	   "</table> \n" +
	   "</form><br /> \n" +
	   "<a href=\"#top\">" + 
	      // "Return to top of page" +
	      L.topOfPage +
	   "</a><p>");

	// ------------------------------------------------------------------------

	out.println(
	   "<a name=\"diseasesubsets\"> \n" +
	   "<form name=\"diseasesubsets\" action=\"" + D.servletDiag1DiseaseSubsets + "\"> \n" +
	   "<table border=\"1\" width=\"100%\"> \n" +
	   "<tr><th colspan=\"2\"><font color=\"#850a0a\" size=\"4\">" + 
	       "<b>" +
	           // "Search in Disease Subset(s) of your Choice" +
	           L.DiagStartS15 +
	       "</b></font></th></tr> \n " +
	   "<tr><th colspan=\"2\"><font color=\"#850a0a\">" +
	         // "The more subsets you include, the more time it will take " +
	         // "to reach a final conclusion." +
	         L.DiagStartS16 +
	   "</th></tr>\n" +
	   "<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">Select:</font></td><td>");
	lng = allDiseaseSets.length;
	for (int i = 0; i < lng; i++) {
	    disSet = allDiseaseSets[i];
	    if ( ( disSet.equals("obstreticDisorders") ||
		   disSet.equals("gynecologicDisorders") ) && gender.equals(LR.male) ) continue;
	    diseaseSet = Common.getDiseaseSet(disSet);
	    lng2 = diseaseSet.getDiseaseMembers().size();
	    printName = diseaseSet.getPrintName();
	    out.println(
              "<input type=\"checkbox\" name=\"diseasesubset\" value=\"" + disSet + "\" />" +
	      printName + "<br />");
	}
	out.println("</td></tr>");

	out.println(
            "<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">" +
	         // "Provide one or more symptoms:" +
	         L.DiagStartS12 +
	         "</font></td> \n" +
	    "<td><input type=\"text\" name=\"userInput\" size=\"100\" maxlength=\"100\" value=\"\" /></td></tr>");

	out.println(temperatureInput);

	out.println(
	    "<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">" +
	         // "Please check your data before submitting!" +
	         L.Diag1bS13 +
	         "</font></td>" +
	    "<td><input type=\"button\" value=\"Submit\" " +
		    "onClick=\"checkDiseasesubsets(this.form)\" /> </td></tr>");

	out.println(
	   "</table> \n" +
	   "</form><br /> \n" +
	   "<a href=\"#top\">" +
	       // "Return to top of page" +
	       L.topOfPage +
	   "</a><p> \n");

	// ------------------------------------------------------------------------

	out.println(
	   "<a name=\"unrestricted\"> \n" +
	   "<form name=\"subsystem\" action=\"" + D.servletDiag1Unrestricted + "\"> \n" +
	   "<table border=\"1\" width=\"100%\"> \n" +
	   "<tr><th colspan=\"2\"><font color=\"#850a0a\" size=\"4\">" + 
	       "<b>" +
	       // "Search in all Diseases" +
	       L.DiagStartS17 +
	       "</b></font></th></tr> \n" +
	   "<tr><th colspan=\"2\"><font color=\"#850a0a\">" +
	   // "This search mode may take the longest to reach a final conclusion." +
	   L.DiagStartS18 +
	   "</th></tr>\n" +
	   "<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">" +
	        // "Select body location and/or:" +
	        L.DiagStartS11 +
	        "</font></td><td>");
	out.println("<select name=\"bodyPart\">");
	out.println("      <option value=\"unspecified\">" + L.unspecified + "</option>");
	lng = parts.size();
	for (int i = 0; i < lng; i++) {
	  locName2 = (String) parts.elementAt(i);
	  loc2 = (PartOfLocation) Common.getLocation(locName2);
	  printName = loc2.getPrintName();
	  out.println("      <option value=\"" + locName2 + "\">" + printName + "</option>");
	}

	out.println("</select>");
	out.println(DiagStart.hintToNarrow("loc2"));
	out.println(DiagStart.hintLocWhat("loc2What"));
	out.println("</td></tr>");

	out.println(
            "<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">" +
	         // "Provide one or more symptoms:" + 
	         L.DiagStartS12 +
	         "</font></td> \n" +
	    "<td><input type=\"text\" name=\"userInput\" size=\"100\" maxlength=\"100\" value=\"\" /></td></tr>"); 

	out.println(temperatureInput);

	out.println(
	    "<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">" + 
	         // "Please check your data before submitting!" +
	         L.Diag1bS13 +
	         "</font></td> \n" +
	    "<td><input type=\"button\" value=\"Submit\" " +
		    "onClick=\"checkUnrestricted(this.form)\" /> </td></tr>");

	out.println(
	   "</table> \n" +
	   "</form><br /> \n" +
	   "<a href=\"#top\">" +
	       // "Return to top of page" +
	       L.topOfPage +
	   "</a><p> \n");


	// ------------------------------------------------------------------------


	out.println(DV.htmlBack);

	// user Search
	// out.println(DiagStart.search());

	// localhost:8000 === healthcareProvider:80 or so
	out.println(DV.SCRIPTCC);

	out.println("</font></body>");
	out.println("</html>");
    }


} // end of DiagStart2









