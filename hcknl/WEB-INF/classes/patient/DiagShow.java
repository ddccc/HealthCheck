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
import concepts.XWord;
import com.DVM;
import com.LR;
import misc.SessionExpired;

public class DiagShow extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {

      HttpSession session = req.getSession(false);
      boolean tracking = ( null != session );	

      /*
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
      */

	HashSet D1 = null; 
	if ( tracking ) 
	    D1 = (HashSet) session.getValue("D1"); // all gender specific diaseases

	// Get resources:
	int lng, lng2;
	String diseaseName, diseasePrintName, printName;
	Disease dis;

	// String subSys;
	// String disSet;
	// String bsGender;
	// String locName2;
	// LocationRelation lr
	// Vector vec;
	// PartOfLocation loc2;


	DiseaseSet lifeThreateningDiseases = Common.getDiseaseSet(LR.lifeThreateningDisorders);
	Vector lifeThreateningDiseaseMembers = lifeThreateningDiseases.getDiseaseMembers();
	Collections.sort(lifeThreateningDiseaseMembers);

	String [] allDiseases = Common.allDiseasesForShow();

	/*
	BodySystem bs = Common.getBodySystem("bodySys");
	Vector subSystems = bs.getSubSystems();

	String [] allDiseaseSets = Common.allDiseaseSets();

	Location body = Common.getLocation("body");
	Vector containedLocations = body.getContainedLocations();
	*/

        res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html><head><title>" + L.ShowDiseaseDetail + "</title> \n" +
		    D.linkHckStyle +
		    D.favicon +
		    "</head>");

String script =
Diag1b.popupDisplayDisease +

"<script language=\"JavaScript\">" +
    /*
"function displayDisease(dis) { \n" +
"  diseaseWindow = open( \n" +
"    \"" + D.servletShowDisease + "?dis=\"+dis, \n" +
"    \"diseaseWindowName\", \n" +
"    \"toolbar=yes,resizable=yes,scrollbars=yes,height=600,width=900\" \n" +
"  ); \n" +
"} \n" +
    */
"function doLifeThreatening(form) { \n" +
       // verify that at least something is entered
"item = form.showLifeThreateningDisease.selectedIndex; \n" +
"if ( 0 == item ) { \n" +
"  alert('Cant proceed without your input!!!');  \n" +
"  return false; \n" +
"  } \n" +
"displayDisease(form.showLifeThreateningDisease.options[item].value); \n" +
"} \n" +

"</script>";

	out.println(script);

	out.println("<body>" +
		    "<font color=\"#850a0a\">");
	// out.println("Loading wait count: " + waitCnt);

	out.println(DVM.htmlLogoutUser(
				       // "OK, Here the Show Disease Options"
				       L.DiagShowS1 ));

	// ------------------------------------------------------------------------

	out.println(
	   "<form name=\"showLifeThreateningDisease\"> \n" +
	   "<table border=\"1\" width=\"100%\"> \n" +
	   "<tr><th colspan=\"2\"><font color=\"#850a0a\" size=\"4\">" + 
	       "<b>" +
	       // "Pop up the Details of a Life Threatening Disease" +
	       L.DiagShowS2 +
	       "</b></font></th></tr> \n " +
	   "<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">Select:</font></td><td>" );
	out.println("<select name=\"showLifeThreateningDisease\">");
	out.println("<option value=\"none\">none</option>"); 
	lng = lifeThreateningDiseaseMembers.size();
	for (int i=0; i<lng; i++) {
	    diseaseName = (String) lifeThreateningDiseaseMembers.elementAt(i);
	    if ( tracking && !D1.contains(diseaseName) ) continue; // gender check
	    dis = Common.getDisease(diseaseName);
	    diseasePrintName = dis.getPrintName();
	    out.println("<option value=\"" + diseaseName + "\">" + diseasePrintName + "</option>");
	}
	out.println("</select></td></tr>");

	out.println(
	    "<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">" +
	        // "Please check your data before submitting!" +
	        L.Diag1bS13 +
	        "</font></td>" +
	    "<td><input TYPE=\"button\" value=\"Submit\" " +
		    "onClick=\"doLifeThreatening(this.form)\" /> </td></tr>");
	out.println(
	   "</table> \n" +
	   "</form><br /> \n" +
	   "<p>");

	// ------------------------------------------------------------------------

	out.println(
	   "<form name=\"showAnyDisease\"> \n" +
	   "<table border=\"1\" width=\"100%\"> \n" +
	   "<tr><th colspan=\"2\"><font color=\"#850a0a\" size=\"4\">" + 
	       "<b>" + 
	       // "Pop up the Details of Any Disease" +
	       L.DiagShowS3 +
	       "</b></font></th></tr> \n " +
	   "<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">Select:</font></td><td>" );
	out.println("<select name=\"showLifeThreateningDisease\">");
	out.println("<option value=\"none\">none</option>"); 
	lng = allDiseases.length;
	for (int i=0; i<lng; i++) {
	    diseaseName = allDiseases[i];
	    if ( tracking &&!D1.contains(diseaseName) ) continue; // gender check
	    dis = Common.getDisease(diseaseName);
	    if ( null != dis ) 
		diseasePrintName = dis.getPrintName();
	    else {
		XWord xw = Common.getXWord(diseaseName);
		if ( null == xw ) continue;
		String dis2 = xw.getSynonym();
		dis = Common.getDisease(dis2);
		if ( null == dis ) continue;
		diseasePrintName = xw.getPrintName() + " => " + dis.getPrintName();
	    }
	    out.println("<option value=\"" + diseaseName + "\">" + diseasePrintName + "</option>");
	}
	out.println("</select></td></tr>");

	out.println(
	    "<tr><td width=\"30%\"><font color=\"#850a0a\" size=\"4\">" +
	        // "Please check your data before submitting!" +
	        L.Diag1bS13 +
	        "</font></td>" +
	    "<td><input TYPE=\"button\" value=\"Submit\" " +
		    "onClick=\"doLifeThreatening(this.form)\" /> </td></tr>");
	out.println(
	   "</table> \n" +
	   "</form> \n" +
	   "<p><b>" + L.SearchAdvice + "</b>" +
	   "<p>");


	// ------------------------------------------------------------------------


	out.println(DV.htmlBack);


	// user Search
	// out.println(DiagStart.search());

	if ( tracking ) {
	    // localhost:8000 === healthcareProvider:80 or so
	    out.println(DV.SCRIPTCC);
	}

	out.println("</font></body>");
	out.println("</html>");
    }

  } // end of DiagShow









