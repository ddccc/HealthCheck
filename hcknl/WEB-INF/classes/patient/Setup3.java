// (C) OntoOO Inc 2002 May
package patient;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import com.Common;
import com.DV;
import com.D;
import com.L;
import misc.DB;
import misc.HCError;
import misc.SessionExpired;
import su.DiseaseRecord;
import concepts.Drug;
import concepts.Disease;
// import htmls.Angel;


public class Setup3 extends HttpServlet {

    public void doPost (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException

    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    SessionExpired.call(res,
				DV.Setup);
	    return;
	}
	DB props = (DB) session.getValue("theDB");
	String dobYear = props.getProperty("year");
	int dobYeari = 1900;
	try { dobYeari = Integer.parseInt(dobYear); }
	catch (NumberFormatException ignore) {}
	Date now = new Date();
	Calendar cal = Calendar.getInstance();
	cal.setTime(now);
	int nowYeari = cal.get(Calendar.YEAR);

	String [] illnesses = req.getParameterValues("illnesses");
	Vector illities = new Vector();
	Vector years = new Vector();
	int lng = 0;
	String illness;
	
	if ( null != illnesses ) lng = illnesses.length;
	if ( 0 < lng ) {
	  for (int i = 0; i < lng; i++) {
	    illness = illnesses[i];
	    illities.addElement(illness);
	    years.addElement(req.getParameter(illness));
	  }
	}

	String dis = null;
	DiseaseRecord dr;
	String yearStr;
	int yeari = 1900;
	Date dat;
	Vector historyOfDiseases = new Vector();
	for (int i = 0; i < lng; i++) {
	  dis = (String) illities.elementAt(i);
	  yearStr = (String) years.elementAt(i);
	  try { yeari = Integer.parseInt(yearStr); }
	  catch (NumberFormatException ignore) {}
	  if ( yeari < dobYeari || nowYeari < yeari ) {
	      HCError.call(res,
			  "The year for disease: " + dis + " is incorrect!" +
			  "<br>Use the back arrow to return to the previous page." +
			  "<br>dobYeari= " + dobYeari +
			  "<br>nowYeari= " + nowYeari +
			  "<br>yeari= " + yeari
			  );
	      return;
	  }
	  cal.set(Calendar.YEAR, yeari);
	  cal.set(Calendar.MONTH, 0);
	  cal.set(Calendar.DAY_OF_MONTH, 1);
	  dat = cal.getTime();
	  dr = new DiseaseRecord(dis, dat, "Setup3");
	  historyOfDiseases.addElement(dr);
	}
	Collections.sort(historyOfDiseases);

	Hashtable ht = new Hashtable();
	ht.put("historyOfDiseases", historyOfDiseases);
	String logName = (String) session.getValue("logName");
	// this will create an empty vector
	// Vector logSessions = Common.getLogSessions(logName);
	Vector logSessions = new Vector();
	logSessions.addElement(ht);
	Common.saveLogSessions(logName, logSessions);

	AngelLogin.incrementCreateCnt();

	// javascript
String removeLast =
"function removeLast(formChosenDrugs, formSelectedDrugs) { \n" +
"   chosenDrugs = formChosenDrugs.value; \n" +
"   ix = chosenDrugs.lastIndexOf(','); \n" +
"   if ( ix < 0 ) return; \n" +
"   chosenDrugs = chosenDrugs.substring(0, -2 + chosenDrugs.length); \n" +
"   ix = chosenDrugs.lastIndexOf(','); \n" +
"   if ( ix < 0 ) { \n" +
"     ix = chosenDrugs.indexOf(':'); \n" +
"     formChosenDrugs.value = chosenDrugs.substring(0, ix+2); \n" +
"     formSelectedDrugs.value = \"\"; \n" +
"     return; \n" +
"   } \n" +
"   formChosenDrugs.value = chosenDrugs.substring(0, ix+2); \n" +
"   selectedDrugs = formSelectedDrugs.value; \n" +
"   ix = selectedDrugs.lastIndexOf(','); \n" +
"   formSelectedDrugs.value = selectedDrugs.substring(0, ix); \n" +
"}\n";

String fetchDrug2 =
"function fetchDrug2(formUsedDrugs, formSelectedDrugs, formChosenDrugs) { \n" +
"  idx = formUsedDrugs.options.selectedIndex; \n" +
"  if ( 0 == idx ) return; \n" +
"  xyz = formUsedDrugs.options[idx].value; \n" +
"  split = xyz.indexOf('|'); \n" +
"  head = xyz.substring(0, split); \n" +
// check whether it has been selected already
"  hidden = formSelectedDrugs.value; \n" +
"  if ( 0 <= hidden.indexOf(head) ) return; \n" +
// Add the head to a hidden field
"  formSelectedDrugs.value = hidden + ',' + head; \n" +
"  tail = xyz.substring(split+1, xyz.length); \n" +
"  txt = formChosenDrugs.value; \n" +
// "  alert('*** split: ' + split + ' head: ' + head + ' tail: ' + tail); \n" +
"  formChosenDrugs.value = txt + tail + ', '; \n" +
    // "  alert('xx:' + formSelectedDrugs.value); \n" +
"} \n";

/*
String setFields =
"function setFields(form) { \n" +
"  item = form.fatherDisease.selectedIndex; \n" +
"  form.fatherDiseaseA.value = form.fatherDisease.options[item].value; \n" +
"  item = form.motherDisease.selectedIndex; \n" +
"  form.motherDiseaseA.value = form.motherDisease.options[item].value; \n" +
"  item = form.siblingDisease.selectedIndex; \n" +
"  form.siblingDiseaseA.value = form.siblingDisease.options[item].value; \n" +
    // "  alert('xx:' + form.selectedDrugs.value); \n" +
    // "  alert('xxA:' + form.selectedDrugsA.value); \n" +
"  form.submit(); \n" +
"} \n";
*/
	// Ask for medication/ allergies, etc.
	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html><head><title>" + L.Setup3S4 + "</title>" + " \n" +
		    D.linkHckStyle + " \n" +
		    D.favicon + " \n" +
		    "</head>");
	out.println("<script language=\"JavaScript\">");
	out.println(removeLast);
	out.println(fetchDrug2);
	// out.println(setFields);
	out.println("</script>");
	out.println("<body>" +
		    "<font color=\"#850a0a\">");
	out.println("<h1 align=\"center\"> " +
		    "<font color=\"#1C5540\" size=\"4\">" +
		    L.Setup3S5 +
		    "</font></h1>");
	out.println("<form name=\"s3\" action=\"" + D.servletSetup4 + "\">");
	out.println("<center><table border=\"1\">");
	out.println("<tr><td><center>" + 
		    // "Select drug(s) from a list ..." +
		    L.Setup3S6 +
		    "</center></td></tr>");
	// used drugs & medication
	out.println("<tr><td valign=\"top\"><center>" +
		    "<textarea name=\"chosenDrugs\" " +
		    "readonly rows=\"2\" cols=\"60\">" +
		    // "Selected drugs:" +
		    L.Setup3S7 + " " +
		    "</textarea>");
	out.println("<br />" +
		    //"<input type=\"button\" value=\"Remove last\" " +
		    "<input type=\"button\" value=\"" + L.DiagStartS32 + "\" " +
		    // "onClick=\"removeLast(this.form)\" />" +
		    "onClick=\"removeLast(this.form.chosenDrugs, this.form.selectedDrugs)\" />" +
		    "<p>");
	out.println("<hr align=\"center\" width=\"70%\" />");
	out.println(// "Drugs" + 
		    L.Setup3S8);
	out.println("<br />" +
		    "<select name=\"usedDrugs\" " +
	"onChange='fetchDrug2(this.form.usedDrugs, this.form.selectedDrugs, this.form.chosenDrugs)'>");
	out.println("   <option value=\"none\">" +
		    L.Setup3S9 + "</option>");
	String [] allDrugs = Common.allDrugs();
	lng = allDrugs.length;
	for (int i = 0; i < lng; i++) {
	    String drugStr = allDrugs[i];
	    Drug drug = Common.getDrug(drugStr);
	    String printName = drug.getDescription();
	    out.println("   <option value=\"" + drugStr + "|" + printName + 
		      "\">" + printName + "</option>");
	}
	out.println("</select>");
	out.println("</table></center>");

	// Allergy
	out.println("<h1 align=\"center\"> " +
		    "<font color=\"#1C5540\" size=\"4\">" +
		    L.Setup3S10 +
		    "</font></h1>");
	out.println("<center><table border=\"1\">");
	out.println("<tr><td><center>" + 
		    // "Select drug(s) from a list ..." +
		    L.Setup3S6 +
		    "</center></td></tr>");
	// used drugs & medication
	out.println("<tr><td valign=\"top\"><center>" +
		    "<textarea name=\"chosenDrugsA\" " +
		    "readonly rows=\"2\" cols=\"60\">" +
		    // "Selected drugs:" +
		    L.Setup3S7 + " " +
		    "</textarea>");
	out.println("<br />" +
		    //"<input type=\"button\" value=\"Remove last\" " +
		    "<input type=\"button\" value=\"" + L.DiagStartS32 + "\" " +
		    // "onClick=\"removeLast(this.form)\" />" +
		    "onClick=\"removeLast(this.form.chosenDrugsA, this.form.selectedDrugsA)\" />" +
		    "<p>");
	out.println("<hr align=\"center\" width=\"70%\" />");
	out.println(// "Drugs" + 
		    L.Setup3S8);
	out.println("<br />" +
		    "<select name=\"usedDrugsA\" " +
	"onChange='fetchDrug2(this.form.usedDrugsA, this.form.selectedDrugsA, this.form.chosenDrugsA)'>");
	out.println("   <option value=\"none\">" +
		    L.Setup3S9 + "</option>");
	for (int i = 0; i < lng; i++) {
	    String drugStr = allDrugs[i];
	    Drug drug = Common.getDrug(drugStr);
	    String printName = drug.getDescription();
	    out.println("   <option value=\"" + drugStr + "|" + printName + 
		      "\">" + printName + "</option>");
	}
	out.println("</select>");
	out.println("</table></center>");

	out.println("<h1 align=\"center\"> " +
		    "<font color=\"#1C5540\" size=\"4\">" +
		    L.Setup3S11 +
		    "</font></h1>");
	/*
	out.println("<center><table border=\"1\"><tr><td>");

	out.println(L.Setup3S12);
	out.println("<br /><select name=\"fatherDisease\">");
	out.println("<option value=\"none\">still alive</option>"); 
	out.println("<option value=\"none\">do not know</option>"); 
	String[] allMaleDiseasesArr = Common.allMaleDiseasesArr();
	lng = allMaleDiseasesArr.length;
	for (int i=0; i<lng; i++) {
	    String diseaseName = allMaleDiseasesArr[i];
	    Disease dis2 = Common.getDisease(diseaseName);
	    String diseasePrintName = dis2.getPrintName();
	    out.println("<option value=\"" + diseaseName + "\">" + diseasePrintName + "</option>");
	}
	out.println("</select><p>");
	out.println(L.Setup3S13);
	out.println("<br /><select name=\"motherDisease\">");
	out.println("<option value=\"none\">still alive</option>"); 
	out.println("<option value=\"none\">do not know</option>"); 
	String[] allFemaleDiseasesArr = Common.allFemaleDiseasesArr();
	lng = allFemaleDiseasesArr.length;
	for (int i=0; i<lng; i++) {
	    String diseaseName = allFemaleDiseasesArr[i];
	    Disease dis2 = Common.getDisease(diseaseName);
	    String diseasePrintName = dis2.getPrintName();
	    out.println("<option value=\"" + diseaseName + "\">" + diseasePrintName + "</option>");
	}
	out.println("</select><p>");
	out.println(L.Setup3S14);
	out.println("<br /><select name=\"siblingDisease\">");
	out.println("<option value=\"none\">still alive</option>"); 
	out.println("<option value=\"none\">do not know</option>"); 
	String[] allDiseases = Common.allDiseases();
	lng = allDiseases.length;
	for (int i=0; i<lng; i++) {
	    String diseaseName = allDiseases[i];
	    Disease dis2 = Common.getDisease(diseaseName);
	    String diseasePrintName = dis2.getPrintName();
	    out.println("<option value=\"" + diseaseName + "\">" + diseasePrintName + "</option>");
	}
	out.println("</select>");
	out.println("</td></tr>");
	out.println("</table></center><p />");
	*/

        out.println("<center><table border=\"1\">");
	out.println("<tr><td><center>" + 
		    // "Select drug(s) from a list ..." +
		    L.Setup3S6 +
		    "</center></td></tr>");
	// Father illnesses
	out.println("<tr><td valign=\"top\"><center>" +
		    "<textarea name=\"chosenDiseases\" " +
		    "readonly rows=\"2\" cols=\"60\">" +
		    // "Selected diseases:" +
		    L.Setup3S12 + " " +
		    "</textarea>");
	out.println("<br />" +
		    //"<input type=\"button\" value=\"Remove last\" " +
		    "<input type=\"button\" value=\"" + L.DiagStartS32 + "\" " +
		    // "onClick=\"removeLast(this.form)\" />" +
		    "onClick=\"removeLast(this.form.chosenDiseases, this.form.selectedDiseases)\" />" +
		    "<p>");
	out.println("<hr align=\"center\" width=\"70%\" />");
	out.println(// Major diseases of father:
		    L.Setup3S13);
	out.println("<br />" +
		    "<select name=\"usedDiseases\" " +
	"onChange='fetchDrug2(this.form.usedDiseases, this.form.selectedDiseases, this.form.chosenDiseases)'>");
	out.println("   <option value=\"none\">" +
		    L.Setup3S9 + "</option>");
	String [] allDiseases = Common.allMaleDiseasesArr();
	lng = allDiseases.length;
	for (int i = 0; i < lng; i++) {
	    String diseaseStr = allDiseases[i];
	    Disease disease = Common.getDisease(diseaseStr);
	    String printName = disease.getPrintName();
	    out.println("   <option value=\"" + diseaseStr + "|" + printName + 
		      "\">" + printName + "</option>");
	}
	out.println("</select>");
	out.println("</table></center>");

	// mother 
	out.println("<center><table border=\"1\">");
	out.println("<tr><td><center>" + 
		    // "Select drug(s) from a list ..." +
		    L.Setup3S6 +
		    "</center></td></tr>");
	// Mother illnesses
	out.println("<tr><td valign=\"top\"><center>" +
		    "<textarea name=\"chosenDiseasesM\" " +
		    "readonly rows=\"2\" cols=\"60\">" +
		    // "Selected diseases:" +
		    L.Setup3S12 + " " +
		    "</textarea>");
	out.println("<br />" +
		    //"<input type=\"button\" value=\"Remove last\" " +
		    "<input type=\"button\" value=\"" + L.DiagStartS32 + "\" " +
		    // "onClick=\"removeLast(this.form)\" />" +
		    "onClick=\"removeLast(this.form.chosenDiseasesM, this.form.selectedDiseasesM)\" />" +
		    "<p>");
	out.println("<hr align=\"center\" width=\"70%\" />");
	out.println(// Major diseases of mother:
		    L.Setup3S14);
	out.println("<br />" +
		    "<select name=\"usedDiseasesM\" " +
	"onChange='fetchDrug2(this.form.usedDiseasesM, this.form.selectedDiseasesM, this.form.chosenDiseasesM)'>");
	out.println("   <option value=\"none\">" +
		    L.Setup3S9 + "</option>");
	allDiseases = Common.allFemaleDiseasesArr();
	lng = allDiseases.length;
	for (int i = 0; i < lng; i++) {
	    String diseaseStr = allDiseases[i];
	    Disease disease = Common.getDisease(diseaseStr);
	    String printName = disease.getPrintName();
	    out.println("   <option value=\"" + diseaseStr + "|" + printName + 
		      "\">" + printName + "</option>");
	}
	out.println("</select>");
	out.println("</table></center>");

	//sibling 
	out.println("<center><table border=\"1\">");
	out.println("<tr><td><center>" + 
		    // "Select drug(s) from a list ..." +
		    L.Setup3S6 +
		    "</center></td></tr>");
	// Sibbling illnesses
	out.println("<tr><td valign=\"top\"><center>" +
		    "<textarea name=\"chosenDiseasesS\" " +
		    "readonly rows=\"2\" cols=\"60\">" +
		    // "Selected diseases:" +
		    L.Setup3S12 + " " +
		    "</textarea>");
	out.println("<br />" +
		    //"<input type=\"button\" value=\"Remove last\" " +
		    "<input type=\"button\" value=\"" + L.DiagStartS32 + "\" " +
		    // "onClick=\"removeLast(this.form)\" />" +
		    "onClick=\"removeLast(this.form.chosenDiseasesS, this.form.selectedDiseasesS)\" />" +
		    "<p>");
	out.println("<hr align=\"center\" width=\"70%\" />");
	out.println(// Major diseases of sibling:
		    L.Setup3S15);
	out.println("<br />" +
		    "<select name=\"usedDiseasesS\" " +
	"onChange='fetchDrug2(this.form.usedDiseasesS, this.form.selectedDiseasesS, this.form.chosenDiseasesS)'>");
	out.println("   <option value=\"none\">" +
		    L.Setup3S9 + "</option>");
	allDiseases = Common.allDiseases();
	lng = allDiseases.length;
	for (int i = 0; i < lng; i++) {
	    String diseaseStr = allDiseases[i];
	    Disease disease = Common.getDisease(diseaseStr);
	    String printName = disease.getPrintName();
	    out.println("   <option value=\"" + diseaseStr + "|" + printName + 
		      "\">" + printName + "</option>");
	}
	out.println("</select>");
	out.println("</table></center>");

	out.println(
		  // "Please check your choice before submitting!" +
		  L.Diag1bS13 + " " +
		  // "<input type=\"button\" value=\"" + L.Submit + "\" " +
		  // "onClick=\"setFields(this.form)\" />");
		  "<input type=\"submit\" value=\"" + L.Submit + "\" />"); 

	out.println("<input type=\"hidden\" name=\"selectedDrugs\" value=\"\" /> \n" +
		    "<input type=\"hidden\" name=\"selectedDrugsA\" value=\"\" /> \n" +
		    "<input type=\"hidden\" name=\"selectedDiseases\" value=\"\" /> \n" +  // father
		    "<input type=\"hidden\" name=\"selectedDiseasesM\" value=\"\" /> \n" + // mother
		    "<input type=\"hidden\" name=\"selectedDiseasesS\" value=\"\" /> \n" + // sibling
		    "</form><br />");
	out.println(DV.htmlBack);

	out.println("</font></body>");
	out.println("</html>");


	// 

	/*
	session.invalidate();
	AngelLogin.logoutUser(logName);

	String password = props.getProperty("password");

	Angel.call(res, logName, password);
	*/
	/*
        res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>" + 
		    // "Setup is Completed" + 
		    L.Setup3S1 +
		    "</title></head>");
	out.println("<body bgcolor=\"yellow\">");

	out.println("<h1 align=\"center\"><font color=\"#FF0000\" size=\"4\">" +
		    "Setup3</font></h1>");
	
	out.println("<h4><font size=\"4\">" +
		    // "Setup is completed.  To login:" +
		    L.Setup3S2 +
		    " <a href=\"" + D.AngelHtml + "\">" +
		    // "click here." +
		    L.Setup3S3 +
		    "</a>" +
		    "</font></H4>");

	out.println("<br>logName: " + logName);
	out.println("<br>password: " + password);

	out.println("</body>");
	out.println("</html>");
	*/
    }
}







