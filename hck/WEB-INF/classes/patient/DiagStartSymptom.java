// (C) OntoOO Inc 2008 July
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
import com.DVM;
import com.LR;
import com.LHE;
import misc.SessionExpired;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class DiagStartSymptom extends HttpServlet {
    static String exitButton = 
	  "<input type=\"button\" value=\"X\" onClick=\"leaveRegion()\" />";

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

      String bodyPart = req.getParameter("bodyPart");
      if ( null == bodyPart ) bodyPart = "unspecified"; // just being defensive here

      String locStr = null;
      String printName = null;
      int level;

      HashSet S1 = (HashSet) session.getValue("S1"); // all filtered symptoms
      String sym;
      Symptom symptom;
      Vector symptoms = new Vector();
      for (Iterator it = S1.iterator(); it.hasNext();) {
	    sym = (String) it.next();
	    symptom = Common.getSymptom(sym);
	    if ( symptom.getSkip() ) continue;
	    symptoms.addElement(symptom);
      }
      Collections.sort(symptoms, new SymComp());

      Vector commonSymptomNames = Common.theCommonSymptomNames();
      Vector commonSymptoms = new Vector();
      int lng = commonSymptomNames.size();
      for ( int i = 0; i < lng; i++ ) {
	  sym = (String) commonSymptomNames.elementAt(i);
	  if ( S1.contains(sym) ) {
	      symptom = Common.getSymptom(sym);
	      if ( symptom.getSkip() ) continue;
	      commonSymptoms.addElement(symptom);
	  }
      }

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

String fetchSymptom =
"function fetchSymptom1(form) { \n" +
"  idx = form.symptoms.options.selectedIndex; \n" +
"  if ( 0 == idx ) return; \n" +
"  xyz = form.symptoms.options[idx].value; \n" +
"  split = xyz.indexOf('|'); \n" +
"  head = xyz.substring(0, split); \n" +
// check whether it has been selected already
"  hidden = form.selectedSymptoms.value; \n" +
"  if ( 0 <= hidden.indexOf(head) ) return; \n" +
// Add the head to a hidden field
"  form.selectedSymptoms.value = hidden + '|' + head; \n" +
"  tail = xyz.substring(split+1, xyz.length); \n" +
"  txt = form.chosenSymptoms.value; \n" +
// "  alert('*** split: ' + split + ' head: ' + head + ' tail: ' + tail); \n" +
"  form.chosenSymptoms.value = txt + tail + ', '; \n" +
"} \n" +

"function fetchSymptom2(form) { \n" +
"  idx = form.commonsymptoms.options.selectedIndex; \n" +
"  if ( 0 == idx ) return; \n" +
"  xyz = form.commonsymptoms.options[idx].value; \n" +
"  split = xyz.indexOf('|'); \n" +
"  head = xyz.substring(0, split); \n" +
// check whether it has been selected already
"  hidden = form.selectedSymptoms.value; \n" +
"  if ( 0 <= hidden.indexOf(head) ) return; \n" +
// Add the head to a hidden field
"  form.selectedSymptoms.value = hidden + '|' + head; \n" +
"  tail = xyz.substring(split+1, xyz.length); \n" +
"  txt = form.chosenSymptoms.value; \n" +
// "  alert('*** split: ' + split + ' head: ' + head + ' tail: ' + tail); \n" +
"  form.chosenSymptoms.value = txt + tail + ', '; \n" +
"} \n";

String checkFocus =
"function checkFocus(form) { \n" +
       // verify that at least something is entered
"if ( (\"\" == form.userInput.value) && (\"\" == form.selectedSymptoms.value) ) { \n" +
    //"  alert('Cant proceed without your input!!!');  \n" +
"  alert('" + L.DiagStartS29 + "');  \n" +
"  return false; \n" +
"  } \n" +
"form.submit(); \n" +
"} \n";

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
"</style> \n";

String typeFetch =
"<script language=\"JavaScript\"> \n" +
"function typeFetch(form) { \n" +
"  ops = form.symptoms.options; \n" +
"  probe = form.userInput2.value; \n" +
"  if ( \"\" == probe ) return; \n" +
"  if ( (probe < 'a') || ('zz' < probe) ) return( noSymptom() ); \n" +
"  min = 1; max = ops.length - 1; \n" +
"  pmax = v(ops[max]); \n" +
"  if ( pmax < probe ) return( noSymptom() ); \n" +
"  ix = narrowUp(min, max); \n" +
"  pix = v(ops[ix]); \n" +
"  pixj = pix.indexOf(probe); \n" +
"  if ( 0 != pixj ) return( noSymptom() ); \n" +
"  show(probe, ix);  \n" +
"} \n" +

"function v(oi) { \n" +
"  oj = oi.value; \n" +
"  i = oj.indexOf(\"|\"); \n" +
"  return oj.substring(i+1, oj.length); \n" +
"} \n" +

"function sym(oi) { \n" +
"  oj = oi.value; \n" +
"  i = oj.indexOf(\"|\"); \n" +
"  return oj.substring(0, i); \n" +
"} \n" +

"function narrowUp(i, j) { \n" +
"  if ( j <= i ) return i; \n" +
"  pi = v(ops[i]); \n" +
"  if ( probe <= pi ) { return i; } \n" +
"  k = Math.floor((i + j) / 2); \n" +
"  if ( i == k ) return j; \n" +
"  pk = v(ops[k]); \n" +
"  if ( pk <= probe ) return narrowUp(k, j); \n" +
"  return narrowUp(i, k);  \n" +
"} \n" +

"function noSymptom(){ \n" +
    //"    popup('No symptom for: ' + probe, 2000); \n" +
"    popup('" + L.DiagStartS30 + "' + probe, 2000); \n" +
"} \n" +

"var myTimeout = 0;  \n" +

"function show(probe, ix){ \n" +
    //"  display = 'When found click on the item:<br />'; \n" +
"  display = '" + L.DiagStartS31 + "<br />'; \n" +
"  last = ix + 10; \n" +
"  if ( max < last ) last = max; \n" +
"  for (var i = ix; i < last; i++) { \n" +
"    pix = v(ops[i]); \n" +
"    pixj = pix.indexOf(probe); \n" +
"    if ( 0 == pixj ) display = display + \n" +
"       '<a href=\"#' + i + '\" name=\"' + i + '\" onClick=\"addItem(' + i + ')\">' + \n" +
"       pix + '</a><br />'; \n" +
"    else break; \n" +
"  } \n" +
"  popup10(display); \n" +
"} \n" +

"function popup10(txt) { \n" +
"  popup(txt, 10000); \n" +
"} \n" +
"function popup(txt, tim) { \n" +
"  closeTypeDisplay(); \n" +
"  clearTimeout(myTimeout); \n" +
"  document.getElementById('typeDisplay').style.top = 200+\"px\"; \n" +
"  document.getElementById('typeDisplay').style.left = 400+\"px\"; \n" +
"  document.getElementById('typeDisplay').innerHTML=txt;  \n" +
"  document.getElementById('typeDisplay').style.display=\"block\"; \n" +
"  myTimeout = setTimeout(\"closeTypeDisplay()\", tim); \n" +
"} \n" +

"function closeTypeDisplay() { \n" +
"  document.getElementById('typeDisplay').style.display=\"none\"; \n" +
"} \n" +

"function addItem(i) { \n" +
"   closeTypeDisplay(); \n" +
"   head = sym(ops[i]); \n" +
"   tail = v(ops[i]); \n" +
"   form = document.forms['focussed']; \n" +
"   form.userInput2.value=\"\"; \n" +
// check whether it has been selected already
"   hidden = form.selectedSymptoms.value; \n" +
"   if ( 0 <= hidden.indexOf(head) ) return; \n" +
// Add the head to a hidden field
"  form.selectedSymptoms.value = hidden + '|' + head; \n" +
"  txt = form.chosenSymptoms.value; \n" +
"  form.chosenSymptoms.value = txt + tail + ', '; \n" +
"}\n" +

"function removeLast(form) { \n" +
"   chosenSymptoms = form.chosenSymptoms.value; \n" +
"   ix = chosenSymptoms.lastIndexOf(','); \n" +
"   if ( ix < 0 ) return; \n" +
"   chosenSymptoms = chosenSymptoms.substring(0, -2 + chosenSymptoms.length); \n" +
"   ix = chosenSymptoms.lastIndexOf(','); \n" +
"   if ( ix < 0 ) { \n" +
"     ix = chosenSymptoms.indexOf(':'); \n" +
"     form.chosenSymptoms.value = chosenSymptoms.substring(0, ix+2); \n" +
"     form.selectedSymptoms.value = \"\"; \n" +
"     return; \n" +
"   } \n" +
"   form.chosenSymptoms.value = chosenSymptoms.substring(0, ix+2); \n" +
"   selectedSymptoms = form.selectedSymptoms.value; \n" +
"   ix = selectedSymptoms.lastIndexOf('|'); \n" +
"   form.selectedSymptoms.value = selectedSymptoms.substring(0, ix); \n" +
"}\n";



      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html><head><title>" + L.SelectSearch + "</title>" + " \n" +
		  D.linkHckStyle + " \n" +
		  D.favicon + " \n" +
		  "<script language=\"JavaScript\"> \n" +
		  fetchSymptom +
		  checkFocus +
		  "</script> \n" +
		  "<style type=\"text/css\"> \n" +
		  "  td {font-size:15pt; color:#850a0a} \n" +
		  "</style> \n" +
		  typeDisplay +
		  typeFetch +
                  // locationStuff +
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
      out.println(
		  "<p> \n" +
		  // "<a name=\"searchFocussed\"> \n" +
		  "<form name=\"focussed\" action=\"" + D.servletDiag1Focussed + "\"> \n" +
		  "<input type=\"hidden\" name=\"bodyPart\" value=\"" + bodyPart + "\" /> \n" +
		  // "<table border=\"1\" width=\"100%\">");
		  "<center><table border=\"1\">");

      out.println("<tr><td><center>" + 
		  // "Select symptom(s) from a list ..." +
		  L.DiagStartS24 +
		  "</center></td></tr>");


      // -------------- symptom column ------------------
      out.println("<tr><td valign=\"top\"><center>" +
		  "<textarea name=\"chosenSymptoms\" " +
		  "readonly rows=\"2\" cols=\"60\">" +
		  // "Selected symptoms:" +
		  L.DiagStartS27 + " " +
		  "</textarea>");
      out.println("<br />" +
		  //"<input type=\"button\" value=\"Remove last\" " +
		  "<input type=\"button\" value=\"" + L.DiagStartS32 + "\" " +
		  "onClick=\"removeLast(this.form)\" />" +
		  "<p>");
      out.println("<hr align=\"center\" width=\"70%\" />");
      out.println(// "Common Symptoms:" + 
		  L.DiagStartS28 +
		  "<br />" +
		  "<select name=\"commonsymptoms\" " +
		  "onChange='fetchSymptom2(this.form)'>");
      out.println("   <option value=\"ignore\">" +
		  L.DiagStartS22 + "</option>");
      lng = commonSymptoms.size();
      String symp, description, token;
      for (int i = 0; i < lng; i++) {
	  symptom = (Symptom) commonSymptoms.elementAt(i);
	  symp = symptom.getName();
	  printName = symptom.getPrintName();
	  description = symptom.getDescription();
	  token  = ( description.equals(printName) ?
		     printName :
		     printName + "/ " + description );
	  out.println("   <option value=\"" + symp + "|" + token + 
		      "\">" + token + "</option>");
      }
      out.println("</select>");
      out.println("<br />" +
		  // "All symptoms:" +
		  L.AllSymptoms +
		  "<br />" +
		  "<select name=\"symptoms\" " +
		  "onChange='fetchSymptom1(this.form)'>");
      out.println("   <option value=\"ignore\">" +
		  L.DiagStartS22 + "</option>");
      lng = symptoms.size();
      // String symp, description, token;
      for (int i = 0; i < lng; i++) {
	  symptom = (Symptom) symptoms.elementAt(i);
	  symp = symptom.getName();
	  printName = symptom.getPrintName();
	  description = symptom.getDescription();
	  token  = ( description.equals(printName) ?
		     printName :
		     printName + "/ " + description );
	  out.println("   <option value=\"" + symp + "|" + token + 
		      "\">" + token + "</option>");
      }
      out.println("</select>");
      out.println("<hr align=\"center\" width=\"70%\" />");
      out.println(// "... or type them" +
		  L.DiagStartS25);
      out.println("<hr align=\"center\" width=\"70%\" />");
      out.println(//"Type assisted:<br />" +
		  L.DiagStartS33 + "<br />" +
		  "<input type=\"text\" name=\"userInput2\" size=\"100\" maxlength=\"100\" value=\"\" " +
		  "onKeyUp=\"typeFetch(this.form)\" /><br />");
      out.println(//"Type free form:<br />" +
		  L.DiagStartS34 + "<br />" +
		  "<input type=\"text\" name=\"userInput\" size=\"100\" maxlength=\"100\" value=\"\">");

      // Here the popup area for assisted typing::
      out.println("<span id=\"typeDisplay\"></span>");
      out.println("<hr align=\"center\" width=\"70%\" />");

      out.println("<table border=\"1\">");
      out.println(temperatureInput);
      out.println("</table><p>");

      out.println("</center></td></tr>"); 
      out.println("<tr><td><center>" +
		  // "Please check your choice before submitting!" +
		  L.Diag1bS13 + " " +
		  "<input type=\"button\" value=\"" + L.Submit + "\" " +
		  "onClick=\"checkFocus(this.form)\" /></center> </td></tr>");
      out.println("</table></center><p>");

      out.println("<input type=\"hidden\" name=\"selectedSymptoms\" value=\"\" /> \n" +
		  "</form><br />");


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


} // end of DiagStartSymptom




