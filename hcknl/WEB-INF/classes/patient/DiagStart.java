// (C) OntoOO Inc 2003 Mar
package patient;

import com.DV;
import com.D;
import com.L;
import com.SymComp;
import misc.DiagStackEntry;
import misc.DB;
import com.Common;
import concepts.Symptom;
import concepts.Disease;
import concepts.DiseaseSet;
import concepts.LocationRelation;
import concepts.Location;
import concepts.PartOfLocation;
import concepts.BodySystem;
import concepts.Drug;
import com.DVM;
import com.LR;
import com.LHE;
import misc.SessionExpired;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class DiagStart extends HttpServlet {
    static String exitButton = 
	  "<input type=\"button\" value=\"X\" onClick=\"leaveRegion()\" />";

    static String maleMap =
"<map name=\"map1\"> \n" +
"  <area shape=circ coords=\"83,22,18\" \n" +
"        onMouseOver=\"enterRegion2(this,'<b>Click for Head locations</b>')\" \n" +
"        onClick=\"popUpHead(this)\" /> \n" +
"  <area shape=rect coords=\"70,40,94,48\" \n" +
"        onMouseOver=\"enterRegion2(this,'<b>Click for Neck locations</b>')\" \n" +
"        onClick=\"popUpNeck(this)\" /> \n" +
"  <area shape=rect coords=\"57,49,107,127\" \n" + 
"        onMouseOver=\"enterRegion2(this,'<b>Click for Chest locations</b>')\" \n" +
"        onClick=\"popUpChest(this)\" /> \n" +
"  <area shape=poly coords=\"58,49,  58,93,   30,179, 4,159, 50,49\" \n" + 
"        onMouseOver=\"enterRegion2(this,'<b>Click for Arms locations</b>')\" \n" +
"        onClick=\"popUpArms(this)\" /> \n" +
"  <area shape=poly coords=\"110,49, 110,93, 134,179, 158,159, 118,49\" \n" +
"        onMouseOver=\"enterRegion2(this,'<b>Click for Arms locations</b>')\" \n" +
"        onClick=\"popUpArms(this)\" /> \n" +
"  <area shape=rect coords=\"75,149,92,168\" \n" + 
"        onMouseOver=\"enterRegion2(this,'<b>Click for Genitalia locations</b>')\" \n" +
"        onClick=\"popUpGenitalia(this)\" /> \n" +
"  <area shape=rect coords=\"54,128,114,161\" \n" + 
"        onMouseOver=\"enterRegion2(this,'<b>Click for Abdomen locations</b>')\" \n" +
"        onClick=\"popUpAbdomen(this)\" /> \n" +
"  <area shape=rect coords=\"48,162,118,301\" \n" + 
"        onMouseOver=\"enterRegion2(this,'<b>Click for Legs locations</b>')\" \n" +
"        onClick=\"popUpLegs(this)\" /> \n" +
"</map>";
    static String femaleMap =
"<map name=\"map2\"> \n" +
"  <area shape=circ coords=\"79,25,18\" \n" +
"        onMouseOver=\"enterRegion2(this,'<b>Click for Head locations</b>')\" \n" +
"        onClick=\"popUpHead(this)\" /> \n" +
"  <area shape=rect coords=\"70,44,94,56\" \n" +
"        onMouseOver=\"enterRegion2(this,'<b>Click for Neck locations</b>')\" \n" +
"        onClick=\"popUpNeck(this)\" /> \n" +
"  <area shape=rect coords=\"59,57,103,129\" \n" + 
"        onMouseOver=\"enterRegion2(this,'<b>Click for Chest locations</b>')\" \n" +
"        onClick=\"popUpChest(this)\" /> \n" +
"  <area shape=poly coords=\"58,57,  58,93,   30,179, 4,159, 50,57\" \n" + 
"        onMouseOver=\"enterRegion2(this,'<b>Click for Arms locations</b>')\" \n" +
"        onClick=\"popUpArms(this)\" /> \n" +
"  <area shape=poly coords=\"104,57, 104,93, 134,179, 158,159, 112,57\" \n" +
"        onMouseOver=\"enterRegion2(this,'<b>Click for Arms locations</b>')\" \n" +
"        onClick=\"popUpArms(this)\" /> \n" +
"  <area shape=rect coords=\"75,149,92,168\" \n" + 
"        onMouseOver=\"enterRegion2(this,'<b>Click for Genitalia locations</b>')\" \n" +
"        onClick=\"popUpGenitalia(this)\" /> \n" +
"  <area shape=rect coords=\"54,130,110,165\" \n" + 
"        onMouseOver=\"enterRegion2(this,'<b>Click for Abdomen locations</b>')\" \n" +
"        onClick=\"popUpAbdomen(this)\" /> \n" +
"  <area shape=rect coords=\"44,166,110,301\" \n" + 
"        onMouseOver=\"enterRegion2(this,'<b>Click for Legs locations</b>')\" \n" +
"        onClick=\"popUpLegs(this)\" /> \n" +
"</map>";

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
      String proceed = req.getParameter("arrivingFromCheckDrugEffects");
      if ( null != proceed ) {
	  // we came back from checkForDrugEffects because the user selected to proceed
	  call(req, res, session);
	  return;
      }

      // Check whether we need to look for side effects of drugs:
      DB props = (DB) session.getValue("theDB");
      String usedDrugs = props.getProperty("drugs_used");
      if ( null != usedDrugs && !usedDrugs.equals("") ) {
	  // the user may decide that problems are caused by drugs and terminate the session
	  checkForDrugEffects(req, res, usedDrugs, session);
      } else 
	  call(req, res, session);
    } // end doGet

    /*
      If the user made a detour via checkForDrugEffects the session may contain
      the side effects of drugs: (a string with comma separated items)
           -- allCriticalSymptoms
	   -- criticalSideEffects those confirmed from allCriticalSymptoms
	   -- allOtherSymptoms
	   -- regularSideEffects those confirmed from allOtherSymptoms
      They may all be null even when the detour was made.
     */
    static public void call(HttpServletRequest req, 
			    HttpServletResponse res,
			    HttpSession session)
	throws ServletException, IOException
    {
	/* session has
	   logName
	   theDB (has gender)
	   S1 -> male/female symptoms (HashSet)
	   D1 -> male/female diseases (HashSet)
	   ageInt -> age (Integer)
	 */

      session.removeValue("enteringFrom"); // clean out if the user searches again
      session.putValue("diagnosis", "started");
      session.putValue("searchMode", "unspecified"); // used in Diag1c
      DB props = (DB) session.getValue("theDB");
      String gender = props.getProperty("gender");

      /*
      // wait until loading has completed
      int waitCnt = 0;
      while ( !Common.getTheBodySystemsLoaded() ) { 
	try { Thread.sleep(1000); } catch (InterruptedException ignore) {}
	waitCnt++;
      }
      */

      HashSet L1 = (HashSet) session.getValue("L1"); // all filtered locations
      Vector locationHierarchy = Common.theLocationHierarchy();
      Vector headHierarchy = Common.theHeadHierarchy();
      Vector neckHierarchy = Common.theNeckHierarchy();
      Vector chestHierarchy = Common.theChestHierarchy();
      Vector abdomenHierarchy = Common.theAbdomenHierarchy();
      Vector genitaliaHierarchy = Common.theGenitaliaHierarchy();
      Vector armsHierarchy = Common.theArmsHierarchy();
      Vector legsHierarchy = Common.theLegsHierarchy();
      Vector miscHierarchy = Common.theMiscHierarchy();
      StringBuffer sb = null;
      String indent = 
	  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
	  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
      LHE lhe = null;
      String locStr = null;
      String printName = null;
      int level, lng;

String typeDisplay =
"<style type=\"text/css\">  \n" +
"<!-- \n" +
"#typeDisplay { \n" +
"display: none;  \n" +
"padding: 5; \n" +
"font-size: 12px; \n" +
"border: black solid 1px; \n" +
"font-family: verdana;  \n" +
"position: absolute; \n" +
"background-color: #ffd038; \n" +
"color: 000000; \n" +
"width: 250px; \n" +
"text-align: left; \n" +
"} \n" +

"#locationsBox { \n" +
"display: none; \n" +
"padding: 5; \n" +
"font-size: 12px; \n" +
"border: black solid 1px; \n" +
"font-family: verdana; \n" +
"position: absolute; \n" +
"top: 30px; \n" +
"left: 15%; \n" +
"background-color: #ffd038; \n" +
"color: 000000; \n" +
"} \n" +
"--> \n" +
"</style> \n";


String locationStuff =
"var theObj = null; \n" +
"function enterRegion(me, txt) { \n" +
"    theObj = me; \n" +
"    document.getElementById('locationsBox').style.display=\"none\"; \n" +
    //"    document.getElementById('locationsBox').style.top = 100+\"px\"; \n" +
    //"    document.getElementById('locationsBox').style.left = 500+\"px\"; \n" +
"    document.getElementById('locationsBox').innerHTML = txt; \n" +
"    document.getElementById('locationsBox').style.display=\"block\"; \n" +
"} \n" +
"var popUpEntered = 0; \n" +
"function enterRegion2(me, txt) { \n" +
"   if ( 1 == popUpEntered ) return; \n" +
"   enterRegion(me, txt + ' " + exitButton + "'); \n" +
"} \n" +
"function leaveRegion() { \n" +
"    popUpEntered = 0;  \n" +
"    document.getElementById('locationsBox').style.display=\"none\"; \n" +
"} \n" +
"function setLocationChoice(me) { \n" +
"   var index = me.selectedIndex;  \n" +
"   var value = me.options[index].value; \n" +
"   var txt = me.options[index].text; \n" +
"   txt = trim(txt); \n" +
"   form = document.forms['focussed'];  \n" +
"   form.bodyPart.value = value; \n" +
"   form.chosenLocation.value = txt; \n" +
"   leaveRegion();  \n" +
"} \n" +
"function setLoc(value, txt) { \n" +
"   form = document.forms['focussed'];  \n" +
"   form.bodyPart.value = value; \n" +
"   form.chosenLocation.value = txt; \n" +
"   leaveRegion();  \n" +
"} \n" +
"function trim(txt) { \n" +
"  if ( 160 == txt.charCodeAt(0) ) return trim(txt.substring(1)); \n" +
"  else return txt; \n" +
"} \n" +
"function removeLocation(form, txt) { \n" +
"   form.bodyPart.value = \"unspecified\"; \n" +
"   form.chosenLocation.value = txt; \n" +
"} \n";

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html><head><title>" + L.SelectSearch + "</title>" + " \n" +
		  D.linkHckStyle + " \n" +
		  D.favicon + " \n" +
		  "<style type=\"text/css\"> \n" +
		  "  td {font-size:15pt; color:#850a0a} \n" +
		  "</style> \n" +
		  typeDisplay +
		  // typeFetch +
		  "<script language=\"JavaScript\"> \n" +
                  locationStuff +
		  "</script> \n" +
		  "</head>");
      out.println("<body>" +
		  "<font color=\"#850a0a\">");

      // out.println("Loading wait count: " + waitCnt);
      
      out.println(DVM.htmlLogoutUser(// Focussed Search
				     L.SelectSearch ));
      /*
      out.println("<h3><i>" +
		  // "A mistake can be corrected on the next page" +
		  L.DiagStartS26 +
		  "<i></h3>");
      */

      // intake session?
      String intakeStr = (String) session.getValue("intake");
      boolean intake = null != intakeStr;
      out.println(
		  "<p> \n" +
		  // "<a name=\"searchFocussed\"> \n" +
		  "<form name=\"focussed\" action=\"" + 
		  ( intake ? D.servletAssessSymptoms : D.servletDiagStartSymptom ) + "\"> \n" +
		  "<input type=\"hidden\" name=\"bodyPart\" value=\"unspecified\" /> \n" +
		  // "<table border=\"1\" width=\"100%\">");
		  "<center>" +
		  "<table border=\"1\">");

      out.println("<tr><td>" + 
		  "<center>" +
		  // "Select a specific worrysome location, if any" +
		  L.DiagStartS23 +
		  "</center></td></tr>");

      // ------------- for location ------------------
      // Here the popup area for locations:: see above ...
      out.println("<span id=\"locationsBox\"></span>");

      out.println("<tr><td valign=\"top\"><center>");
      /*
		  "<textarea name=\"chosenLocation\" " +
		  "readonly rows=\"0\" cols=\"30\">" +
		  // "Selected location" +
		  L.unspecifiedLoc +
		  // L.DiagStartS27 + " " + 
		  "</textarea>");
      */
      out.println("<input type=\"text\" name=\"chosenLocation\" size=\"30\" " +
		  "readonly value=\"" + L.unspecifiedLoc + "\" />");
      out.println("<br />" +
		  //"<input type=\"button\" value=\"Remove last\" " +
		  "<input type=\"button\" value=\"" + L.DiagStartS32L + "\" " +
		  "onClick=\"removeLocation(this.form, '" +
		                            L.unspecifiedLoc + "')\" />");
      out.println("<hr align=\"center\" width=\"70%\" />");


      // out.println("<font color=\"red\"><i>Internet Explorer users can NOT use the image. " +
      //    "Instead use the selection boxes below </i></font><br />");
      // check for male/female  etc.
      if ( gender.equals(LR.male) ) {
	  out.println("<img src=\"" + D.maleJpg + 
		  "\" border=\"1\" usemap=\"#map1\" />");
	  out.println(maleMap);
      } else {
	  out.println("<img src=\"" + D.femaleJpg + 
		  "\" border=\"1\" usemap=\"#map2\" />");
	  out.println(femaleMap);
      }

      //  ---- Head -------------
      /*
      StringBuffer sb2 = new StringBuffer();
      lng = headHierarchy.size();
      for ( int i = 0; i < lng; i++ ) {
	  lhe = (LHE) headHierarchy.elementAt(i);
	  locStr = lhe.getLocStr();
	  if ( !L1.contains(locStr) ) continue;
	  printName = lhe.getPrintName();
	  level = lhe.getLevel();
	  sb2.append("   <option value=\"" + locStr + "\">");
	  for ( int j = 0; j < level; j++ ) sb2.append(indent);
	  sb2.append(printName);
	  sb2.append("</option> \n");
      }
      sb = new StringBuffer();
      sb.append("<script language=\"JavaScript\"> \n");
      sb.append("function popUpHead(me) { popUpEntered = 1; \n");
      sb.append("  selector = '<b>" + L.headPrintName + "</b><br />" +
		"<table><tr><td><select name=\"headPartSelect\" " +
		"onChange=\"setLocationChoice(this)\">'; \n");
      sb.append("  selector += '<option value=\"unspecified\">" + L.unspecifiedLoc + "</option>'; \n");
      sb.append("  selector += '" + sb2.toString() + "'; \n");
      sb.append("  selector += '</select></td><td>" + exitButton + "</td></tr></table>'; \n");
      sb.append("  enterRegion(me, selector); \n");
      sb.append("} \n");
      sb.append("</script> \n");
      out.println(sb.toString());
      */

      sb = new StringBuffer();
      lng = headHierarchy.size();
      sb.append("<script language=\"JavaScript\"> \n");
      sb.append("function popUpHead(me) { popUpEntered = 1; \n");
      sb.append("  selector = '<b>" + L.headPrintName + "</b> " + exitButton + "<br />'; \n");
      for ( int i = 0; i < lng; i++ ) {
	  lhe = (LHE) headHierarchy.elementAt(i);
	  locStr = lhe.getLocStr();
	  if ( !L1.contains(locStr) ) continue;
	  printName = lhe.getPrintName();
	  level = -1 + lhe.getLevel();
	  sb.append("selector += '<a href=\"#" + i + "\" name=\"" + i + "\" " +
		     "onClick=setLoc(\"" + locStr + "\",\"" + printName + "\")>");
	  for ( int j = 0; j < level; j++ ) sb.append(indent);
	  sb.append(printName);
	  sb.append("</a><br />'; \n");
      }
      sb.append("  enterRegion(me, selector); \n");
      sb.append("} \n");
      sb.append("</script> \n");
      out.println(sb.toString());


      //  ---- Neck -------------
      sb = new StringBuffer();
      lng = neckHierarchy.size();
      sb.append("<script language=\"JavaScript\"> \n");
      sb.append("function popUpNeck(me) { popUpEntered = 1; \n");
      sb.append("  selector = '<b>" + L.neckPrintName + "</b> " + exitButton + "<br />'; \n");
      for ( int i = 0; i < lng; i++ ) {
	  lhe = (LHE) neckHierarchy.elementAt(i);
	  locStr = lhe.getLocStr();
	  if ( !L1.contains(locStr) ) continue;
	  printName = lhe.getPrintName();
	  level = -1 + lhe.getLevel();
	  sb.append("selector += '<a href=\"#" + i + "\" name=\"" + i + "\" " +
		     "onClick=setLoc(\"" + locStr + "\",\"" + printName + "\")>");
	  for ( int j = 0; j < level; j++ ) sb.append(indent);
	  sb.append(printName);
	  sb.append("</a><br />'; \n");
      }
      sb.append("  enterRegion(me, selector); \n");
      sb.append("} \n");
      sb.append("</script> \n");
      out.println(sb.toString());

      //  ---- Chest -------------
      sb = new StringBuffer();
      lng = chestHierarchy.size();
      sb.append("<script language=\"JavaScript\"> \n");
      sb.append("function popUpChest(me) { popUpEntered = 1; \n");
      sb.append("  selector = '<b>" + L.chestPrintName + "</b> " + exitButton + "<br />'; \n");
      for ( int i = 0; i < lng; i++ ) {
	  lhe = (LHE) chestHierarchy.elementAt(i);
	  locStr = lhe.getLocStr();
	  if ( !L1.contains(locStr) ) continue;
	  printName = lhe.getPrintName();
	  level = -1 + lhe.getLevel();
	  sb.append("selector += '<a href=\"#" + i + "\" name=\"" + i + "\" " +
		     "onClick=setLoc(\"" + locStr + "\",\"" + printName + "\")>");
	  for ( int j = 0; j < level; j++ ) sb.append(indent);
	  sb.append(printName);
	  sb.append("</a><br />'; \n");
      }
      sb.append("  enterRegion(me, selector); \n");
      sb.append("} \n");
      sb.append("</script> \n");
      out.println(sb.toString());

      //  ---- Abdomen -------------
      sb = new StringBuffer();
      lng = abdomenHierarchy.size();
      sb.append("<script language=\"JavaScript\"> \n");
      sb.append("function popUpAbdomen(me) { popUpEntered = 1; \n");
      sb.append("  selector = '<b>" + L.abdomenPrintName + "</b> " + exitButton + "<br />'; \n");
      for ( int i = 0; i < lng; i++ ) {
	  lhe = (LHE) abdomenHierarchy.elementAt(i);
	  locStr = lhe.getLocStr();
	  if ( !L1.contains(locStr) ) continue;
	  printName = lhe.getPrintName();
	  level = -1 + lhe.getLevel();
	  sb.append("selector += '<a href=\"#" + i + "\" name=\"" + i + "\" " +
		     "onClick=setLoc(\"" + locStr + "\",\"" + printName + "\")>");
	  for ( int j = 0; j < level; j++ ) sb.append(indent);
	  sb.append(printName);
	  sb.append("</a><br />'; \n");
      }
      sb.append("  enterRegion(me, selector); \n");
      sb.append("} \n");
      sb.append("</script> \n");
      out.println(sb.toString());

      //  ---- Genitalia -------------
      sb = new StringBuffer();
      lng = genitaliaHierarchy.size();
      sb.append("<script language=\"JavaScript\"> \n");
      sb.append("function popUpGenitalia(me) { popUpEntered = 1; \n");
      sb.append("  selector = '<b>" + L.genitaliaPrintName + "</b> " + exitButton + "<br />'; \n");
      for ( int i = 0; i < lng; i++ ) {
	  lhe = (LHE) genitaliaHierarchy.elementAt(i);
	  locStr = lhe.getLocStr();
	  if ( !L1.contains(locStr) ) continue;
	  printName = lhe.getPrintName();
	  level = -1 + lhe.getLevel();
	  sb.append("selector += '<a href=\"#" + i + "\" name=\"" + i + "\" " +
		     "onClick=setLoc(\"" + locStr + "\",\"" + printName + "\")>");
	  for ( int j = 0; j < level; j++ ) sb.append(indent);
	  sb.append(printName);
	  sb.append("</a><br />'; \n");
      }
      sb.append("  enterRegion(me, selector); \n");
      sb.append("} \n");
      sb.append("</script> \n");
      out.println(sb.toString());

      //  ---- Arms -------------
      sb = new StringBuffer();
      lng = armsHierarchy.size();
      sb.append("<script language=\"JavaScript\"> \n");
      sb.append("function popUpArms(me) { popUpEntered = 1; \n");
      sb.append("  selector = '<b>" + L.armsPrintName + "</b> " + exitButton + "<br />'; \n");
      for ( int i = 0; i < lng; i++ ) {
	  lhe = (LHE) armsHierarchy.elementAt(i);
	  locStr = lhe.getLocStr();
	  if ( !L1.contains(locStr) ) continue;
	  printName = lhe.getPrintName();
	  level = -1 + lhe.getLevel();
	  sb.append("selector += '<a href=\"#" + i + "\" name=\"" + i + "\" " +
		     "onClick=setLoc(\"" + locStr + "\",\"" + printName + "\")>");
	  for ( int j = 0; j < level; j++ ) sb.append(indent);
	  sb.append(printName);
	  sb.append("</a><br />'; \n");
      }
      sb.append("  enterRegion(me, selector); \n");
      sb.append("} \n");
      sb.append("</script> \n");
      out.println(sb.toString());

      //  ---- Legs -------------
      sb = new StringBuffer();
      lng = legsHierarchy.size();
      sb.append("<script language=\"JavaScript\"> \n");
      sb.append("function popUpLegs(me) { popUpEntered = 1; \n");
      sb.append("  selector = '<b>" + L.legsPrintName + "</b> " + exitButton + "<br />'; \n");
      for ( int i = 0; i < lng; i++ ) {
	  lhe = (LHE) legsHierarchy.elementAt(i);
	  locStr = lhe.getLocStr();
	  if ( !L1.contains(locStr) ) continue;
	  printName = lhe.getPrintName();
	  level = -1 + lhe.getLevel();
	  sb.append("selector += '<a href=\"#" + i + "\" name=\"" + i + "\" " +
		     "onClick=setLoc(\"" + locStr + "\",\"" + printName + "\")>");
	  for ( int j = 0; j < level; j++ ) sb.append(indent);
	  sb.append(printName);
	  sb.append("</a><br />'; \n");
      }
      sb.append("  enterRegion(me, selector); \n");
      sb.append("} \n");
      sb.append("</script> \n");
      out.println(sb.toString());

      //  ---- Misc -------------
      out.println("<hr align=\"center\" width=\"70%\" />");

      out.println(L.DiagStartS36 + "<br />");
      out.println("<select name=\"bodyPartSelect\" " +
		  "onChange=\"setLocationChoice(this)\">");
      out.println("<option value=\"unspecified\">" + L.unspecifiedLoc + "</option> \n");

      StringBuffer sb2 = new StringBuffer();
      lng = miscHierarchy.size();
      for ( int i = 0; i < lng; i++ ) {
	  lhe = (LHE) miscHierarchy.elementAt(i);
	  locStr = lhe.getLocStr();
	  if ( !L1.contains(locStr) ) continue;
	  printName = lhe.getPrintName();
	  level = lhe.getLevel();
	  sb2.append("   <option value=\"" + locStr + "\">");
	  for ( int j = 0; j < level; j++ ) sb2.append(indent);
	  sb2.append(printName);
	  sb2.append("</option> \n");
      }
      out.println(sb2.toString());
      out.println("</select> \n");

      // --------- all locations ------------
      out.println("<hr align=\"center\" width=\"70%\" />");

      out.println(L.DiagStartS35 + "<br />");
      out.println("<select name=\"bodyPartSelect\" " +
		  "onChange=\"setLocationChoice(this)\">");
      out.println("<option value=\"unspecified\">" + L.unspecifiedLoc + "</option> \n");

      sb2 = new StringBuffer();
      lng = locationHierarchy.size();
      for ( int i = 0; i < lng; i++ ) {
	  lhe = (LHE) locationHierarchy.elementAt(i);
	  locStr = lhe.getLocStr();
	  if ( !L1.contains(locStr) ) continue;
	  printName = lhe.getPrintName();
	  level = lhe.getLevel();
	  sb2.append("   <option value=\"" + locStr + "\">");
	  for ( int j = 0; j < level; j++ ) sb2.append(indent);
	  sb2.append(printName);
	  sb2.append("</option> \n");
      }
      out.println(sb2.toString());
      out.println("</select>");

      // out.println(hintToNarrow("loc1"));
      // out.println(hintLocWhat("loc1What"));
      out.println("</center></td></tr>");


      out.println("<tr><td><center>" +
		  // "Please check your choice before submitting!" +
		  L.Diag1bS13 + " " +
		  "<input type=\"submit\" value=\"" + L.Submit + "\" />" +
		  "</center> </td></tr>");
      out.println("</table></center><p>");

      out.println("</form> \n");


	out.println(DV.htmlBack);

	// user Search
	// out.println(search());

	// localhost:8000 === healthcareProvider:80 or so
	out.println(DV.SCRIPTCC);

	out.println("</font></body>");
	out.println("</html>");
    }

  
static public String search() {
    String script =
"<script language=\"JavaScript\"> \n" + 
"function checkSearch(form) { \n" +
"   searchInput = form.searchInput.value; \n" +
"   if ( \"\" == searchInput ) { \n" +
"      alert('Need input for searching ...'); \n" +
"      return; \n" +
"   }\n" +
"   searchInput = escape(searchInput); \n" +
"   winSearch = open(\n" +
"          \"" + D.servletUserSearch + "?searchInput=\"+searchInput, \n" +
"	   \"searchPopUp\",\n" +
"	   \"toolbar=1,location=1,resizable=1,scrollbars=1,height=500,width=700\" \n" +
"	); \n" +
"   winSearch.focus(); \n" +
"} \n" +
"</script> \n" +
"<hr /> \n" +
"<form name=\"searchForm\"> \n" +
"<b>" + 
	// "Search for/ Explain (gender neutral):" +
L.DiagStartS19 +
"</b> " +
"<input type=\"text\" name=\"searchInput\" size=\"60\" maxlength=\"60\" value=\"\" /> " +   
"<input type=\"button\" value=\"Submit\" onClick=\"checkSearch(this.form)\" /> \n" +
"</form> \n" +
"<p><b>" + L.SearchAdvice + "</b>";
    return script;
  } // end of search()

    static public String hintToNarrow(String pageLabel) {
	return
	    " <a href=\"#" + pageLabel + "\" name=\"" + pageLabel + "\" onClick=\"alert('" +
	    // "This choice can be narrowed in a later iteration." + 
	    L.DiagStartS20 +
	    "')\">" +
	    "<b><i>" + L.Hint + "</i></b> </a>";
    } // end of  hintToNarrow

    static public String hintLocWhat(String pageLabel) {
	return
	    " <a href=\"#" + pageLabel + "\" name=\"" + pageLabel + "\" onClick=\"alert('" +
	    // "A location that bothers you." +
	    L.DiagStartS21 +
	    "')\">" +
	    "<b><i>" + L.What + "</i></b></a> ";
    } // end of  hintToNarrow

    static public Vector filterParts(Vector parts, String gender) {
	Vector tmp = new Vector();
	int lng = parts.size();
	// filter those that do not have attributes & gender specific ...
	String partIStr;
	Location partI;
	String partGender;
	for (int i = 0; i < lng; i++) {
	    partIStr = (String) parts.elementAt(i);
	    partI = Common.getLocation(partIStr);
	    if ( !partI.hasAsymptom() ) continue;
	    partGender = partI.getGender();
	    if ( !partGender.equals(LR.both) && !partGender.equals(gender) ) continue;
	    tmp.addElement(partIStr);
	}
	return tmp;
    }

private void checkForDrugEffects(HttpServletRequest req, 
				 HttpServletResponse res,
				 String userDrugs,
				 HttpSession session)
    throws ServletException, IOException {
    // Let user decide whether having a symptom that can be a side effect of a drug
    Vector drugs = new Vector();
    StringTokenizer st = new StringTokenizer(userDrugs, ",");
    while ( st.hasMoreTokens() ) 
	drugs.addElement(Common.getDrug(st.nextToken()));
    int lngDrugs = drugs.size();
    HashSet hs2 = new HashSet(); // to avoid displaying a symptom more than once
    HashSet hs = new HashSet(); // to avoid displaying a symptom more than once
    for ( int i = 0; i < lngDrugs; i++ ) {
	  Drug drugi = (Drug) drugs.elementAt(i);
	  Vector vec = drugi.getCriticalSideEffects();
	  int lng = vec.size();
	  for ( int j = 0; j < lng; j++ ) {
	      String sympName = (String) vec.elementAt(j);
	      if ( !hs2.contains(sympName) ) {
		  hs2.add(sympName);
		  if ( hs.contains(sympName) ) hs.remove(sympName);
	      }
	  }
	  vec = drugi.getSideEffects();
	  lng = vec.size();
	  for ( int j = 0; j < lng; j++ ) {
	      String sympName = (String) vec.elementAt(j);
	      if ( hs2.contains(sympName) ) continue;
	      if ( !hs.contains(sympName) ) hs.add(sympName);
	  }
    }
    if ( hs.isEmpty() && hs2.isEmpty() ) { // no symptoms found to be checked, hence::
	call(req, res, session);
	return;
    }
	
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html><head><title>" + L.CheckDrugEffects + "</title>" + " \n" +
		  D.linkHckStyle + " \n" +
		  D.favicon + " \n" +
		  "<style type=\"text/css\"> \n" +
		  "  td {font-size:15pt; color:#850a0a} \n" +
		  "</style> \n" +
		  Diag1b.popupDisplaySymptom +
		  // Diag1b.popupDisplayDrug +
		  "</head>");
      out.println("<body>" +
		  "<font color=\"#850a0a\">");

      out.println(DVM.htmlLogoutUser(L.CheckDrugEffects));
      out.println("<form name=\"drugsForm\" action=\"" + D.servletCheckDrugEffects + "\">");
      out.println("<p><center><table border=\"1\">");
      out.println("<tr><th colspan=\"2\"><font color=\"#1C5540\" size=\"4\">" + 
	       // "Check all that apply - if any:" 
		L.Diag1bS9 +
	       "</font></th></tr>");
      out.println("<tr></tr>");
      int anchor = 1000; // for popup links
      int size2 = hs2.size();
      String allCriticalSymptoms = "";
      if ( 0 < size2 ) {
	  out.println("<tr><td>" +
		      "Critical symptom(s)" +
		      "</td><td>");
	  Iterator it = hs2.iterator();
	  boolean first = true;
	  while ( it.hasNext() ) {
	      if ( first ) first = false; else out.println("<br />");
	      String sympName = (String) it.next();
	      allCriticalSymptoms = allCriticalSymptoms + sympName + ",";
	      Symptom sympj = Common.getSymptom(sympName);
	      anchor++;
	      out.println(
			  "<input type=\"checkbox\" name=\"criticalSymptoms\" value=\"" +
			  sympName + "\" /> ");
	      out.println(
			  "<a href=\"#" + anchor + "\" name=\"" + anchor + "\" " +
			  "onClick=\"displaySymptom('" + sympName + "')\">" + sympj.getPrintName() +
			  "</a>");
	  }
	  out.println("</td></tr>");
      }
      int size = hs.size();
      String allOtherSymptoms = "";
      if ( 0 < size ) {
	  out.println("<tr><td>" +
		      "Other symptom(s)" +
		      "</td><td>");
	  Iterator it = hs.iterator();
	  boolean first = true;
	  while ( it.hasNext() ) {
	      if ( first ) first = false; else out.println("<br />");
	      String sympName = (String) it.next();
	      allOtherSymptoms = allOtherSymptoms + sympName + ",";
	      Symptom sympj = Common.getSymptom(sympName);
	      anchor++;
	      out.println(
			  "<input type=\"checkbox\" name=\"otherSymptoms\" value=\"" +
			  sympName + "\" /> ");
	      out.println(
			  "<a href=\"#" + anchor + "\" name=\"" + anchor + "\" " +
			  "onClick=\"displaySymptom('" + sympName + "')\">" + sympj.getPrintName() +
			  "</a>");
	  }
	  out.println("</td></tr>");
      }

      out.println("</table></center>");

      out.println("<br /><font size=\"4\">" +
		    // "Please check your data before submitting!" +
		    L.Diag1bS13 +
		    "</font> ");
      out.println("<input type=\"hidden\" name=\"allOtherSymptoms\" " +
			"value=\"" + allOtherSymptoms + "\" />");
	    out.println("<input type=\"hidden\" name=\"allCriticalSymptoms\" " +
			"value=\"" + allCriticalSymptoms + "\" />");
      out.println("<input type=\"submit\" value=\"Submit\" /> ");
      out.println("</form>");

      out.println(DV.htmlBack);

	// user Search
	// out.println(DiagStart.search());

	// localhost:8000 === healthcareProvider:80 or so
	out.println(DV.SCRIPTCC);

	out.println("</font></body>");
	out.println("</html>");
    
} // end checkForDrugEffects


} // end of DiagStart




