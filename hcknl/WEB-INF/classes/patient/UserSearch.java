// Copyright OntoOO Inc, 2002
package patient;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.DV;
import com.D;
import com.L;
import concepts.XWord;
import concepts.Symptom;
import concepts.Location;
import concepts.BodySystem;
import concepts.Disease;


public class UserSearch extends HttpServlet {

  private static final boolean expert = DV.expert;
  private static final boolean LOGGING = false;

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String searchInput = req.getParameter("searchInput"); // != ""

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>" + L.UserSearch + "</title></head>");
      out.println("<body bgcolor=\"yellow\">");
      out.println("<h3>" +
		  // "User Search Input:" + 
		  L.UserSearchS1 +
		  " " + searchInput + "</h3>");

      Vector diseases = new Vector();
      Vector expertDiseases = new Vector();
      Vector foundConcepts = new Vector();
      Vector checkConcepts = new Vector();
      Vector skipWords = new Vector();

      Diag1a.procUserInput(
	  searchInput, diseases, expertDiseases, foundConcepts, checkConcepts, skipWords);
      // checkConcepts contains things to be submitted to the user
      // foundConcepts contains symptoms|locations|diseases| ...

      if (LOGGING) {
	System.out.println("UserSearch after Diag1a.procUserInput(...)");
	// System.out.println("foundConcepts: " + foundConcepts.toString());
	// System.out.println("checkConcepts: " + checkConcepts.toString());
      }
      XWord xword;
      String type;
      String token;
      Vector empty = new Vector(); // bogus vector
      String bodyPart = "unspecified";
      String system = "unspecified";
      String newInSymptomsStr = "";
      String newAllSymptoms = "";
      float temperature = 99.3f;

      int lng = foundConcepts.size();
      for (int i = 0; i < lng; i++) {
	xword = (XWord) foundConcepts.elementAt(i);
	type = xword.getType();
	token = xword.getName();
	if ( type.equals("Symptom") ) { 
	  if ( 0 <= newInSymptomsStr.indexOf(token) ) continue;
	  newInSymptomsStr += "," + token;
	  if ( newAllSymptoms.indexOf(token) < 0) 
	    newAllSymptoms += "," + token;
	  continue; 
	}
	if ( type.equals("Location") ) { 
	  if ( token.equals("body") ) continue;
	  if ( bodyPart.equals("unspecified") ||
	       bodyPart.equals("body") ) {
	    bodyPart = token; continue;
	  }
	  if ( bodyPart.equals(token) ) continue;
	  // now we have two new locations ....
	  // lets assume the user's is more specific ...
	  bodyPart = token;
	  continue;
	}
	if ( type.equals("BodySystem") ) { 
	  if ( token.equals("bodySys") ) continue;
	  if ( system.equals("unspecified") ||
	       system.equals("bodySys") ) {
	    system = token; continue;
	  }
	  if ( system.equals(token) ) continue;
	  // now we have two new locations ....
	  // lets assume the user's is more specific ...
	  system = token;
	  continue;
	}
	if ( type.equals("Disease") ) { 
	  DiseaseInst di = new DiseaseInst(token, temperature);
	  di.requalify(empty, empty);
	  expertDiseases.addElement(di);
	  continue;
	}
      }

      // using vectors below would have been easier ...
      String allSymptoms = "";
      String allLocations = "";
      String allSystems = "";
      String allDiseases = "";
      String allUnknowns = "";

      lng = checkConcepts.size();
      if ( 0 < lng ) {
	for (int i = 0; i < lng; i++) {
	  xword = (XWord) checkConcepts.elementAt(i);
	  type = xword.getType();
	  token = xword.getName();
	  if ( type.equals("Symptom") ) {
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
	    allDiseases += "," + token;
	    continue;
	  }
	  allUnknowns += "," + token;
	}
      }

      if (LOGGING) {
	System.out.println("allSymptoms: " + allSymptoms);
      }

	StringBuffer sb;
	StringTokenizer st;
	String symp, symp2;

	out.println("<p><center><table border=\"1\">");
	out.println(
	       "<tr><th colspan=\"2\"><font color=\"#FF0000\" size=\"4\">" + 
	       // "Concepts Found:" +
	       L.UserSearchS2 +
	       "</font></th></tr>");

	// String newInSymptomsStr = (String) session.getValue("newInSymptomsStr");
	Vector newInSymptomsVec = new Vector();
	out.println("<tr><td><b>" + L.Symptoms + "</b></td><td>");
	int cnt = 0;
	if ( newInSymptomsStr.equals("") ) 
	  out.println(L.noneFound + "</td></tr>");
	else {
	  sb = new StringBuffer();
	  st = new StringTokenizer(newInSymptomsStr, ",");
	  Vector theDiseases;
	  while ( st.hasMoreTokens() ) {
	    symp = st.nextToken();
	    newInSymptomsVec.addElement(symp);
	    Symptom sym = Common.getSymptom(symp);
	    theDiseases = sym.getTheDiseases();
	    if ( 0 == theDiseases.size() ) continue;
	    cnt++;
	    symp2 = ( expert ? sym.getPrintName() : sym.getDescription() );
	    sb.append("<a href=\"" + D.servletShowSymptom + "?sym=" + symp + "\">" +
		       symp2 + "</a> ");
	  }
	  sb.append("</td></tr>");
	  if ( 0<cnt ) 
	    out.println(sb.toString());
	  else 
	    out.println(L.noneFound + "</td></tr>");
	}

	// String bodyPart = (String) session.getValue("bodyPart");
	out.println("<tr><td><b>" + L.Location + "</b></td><td>");
	if ( bodyPart.equals("unspecified") )
	  out.println(L.noneFound + "</td></tr>");
	else { 
	    Location loc = Common.getLocation(bodyPart);
	    out.println("<a href=\"" + D.servletShowLocation + "?loc=" +
			bodyPart + "\"> " + loc.getPrintName() + "</a></td></tr>");
	}
	// separator here
	out.println("<tr></tr>");

	// String system = (String) session.getValue("system");
	out.println("<tr><td><b>System: </b></td><td>");
	if ( system.equals("unspecified") )
	  out.println(L.noneFound + "</td></tr>");
	else {
	    BodySystem bs = Common.getBodySystem(system);
	    out.println("<a href=\"" + D.servletShowBodySystem + "?bs=" +
			system + "\"> " + bs.getPrintName() + "</a></td></tr>");
	}

	// Vector expertDiseases = (Vector) session.getValue("expertDiseases");
	lng = expertDiseases.size();
	if ( 0 < lng ) {
	  out.println("<tr><td><b>" + L.Diseases + "</b></td><td>");
	  sb = new StringBuffer();
	  for (int i=0; i<lng; i++) {
	    DiseaseInst di = (DiseaseInst) expertDiseases.elementAt(i);
	    String dis = di.getDisease();
	    sb.append("<a href=\"" + D.servletShowDisease + "?dis=" + dis + "\">" +
		      Common.unPolish(dis) + "</a> ");
	  }
	  sb.append("</td></tr>");
	  out.println(sb.toString());
	}

	// deal now with the stuff found in userInput to be checked

	boolean displayStringBuffer = false;
	StringBuffer dsb = new StringBuffer();

	if ( 0 < checkConcepts.size() ) 
	  dsb.append(
	       "<tr><th colspan=\"2\"><font color=\"#FF0000\" size=\"4\">" + 
	       // "Conjectured Concepts:" + 
	       L.ConjecturedConcepts + 
	       "</font></th></tr>");

	// checkConcepts.removeAllElements();

     if (LOGGING) {
	System.out.println("allSymptoms: " + allSymptoms);
      }

	cnt = 0;
	if ( !allSymptoms.equals("") ) {
	  sb = new StringBuffer();
	  sb.append("<tr><td><b>" +
		    // "Conjectured Symptoms:" + 
		    L.ConjecturedSymptoms +
		    "</b></td><td>");
	  st = new StringTokenizer(allSymptoms, ",");
	  Vector theDiseases;
	  while ( st.hasMoreTokens() ) {
	    symp = st.nextToken();
	    if ( newInSymptomsVec.contains(symp) ) continue;
	    Symptom sym = Common.getSymptom(symp);
	    theDiseases = sym.getTheDiseases();
	    if ( 0 == theDiseases.size() ) continue;
	    cnt++;
	    symp2 = ( expert ? sym.getPrintName() : sym.getDescription() );
	    sb.append("<a href=\"" + D.servletShowSymptom + "?sym=" + symp + "\">" +
		       symp2 + "</a> ");
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
	  sb.append("<tr><td><b>" +
		    // "Conjectured Locations:" +
		    L.ConjecturedLocations +
		    "</b></td><td>");
	  st = new StringTokenizer(allLocations, ",");
	  while ( st.hasMoreTokens() ) {
	    symp = st.nextToken();
	    if ( symp.equals(bodyPart) ) continue;
	    cnt++;
	    Location loc = Common.getLocation(symp);
	    symp2 = loc.getPrintName();
	    sb.append("<a href=\"" + D.servletShowLocation + "?loc=" +
		      symp + "\"> " + symp2 + "</a> ");
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
	  sb.append("<tr><td><b>" + 
		    // "Conjectured Body Systems:" + 
		    L.ConjecturedBodySystems +
		    "</b></td><td>");
	  st = new StringTokenizer(allSystems, ",");
	  while ( st.hasMoreTokens() ) {
	    symp = st.nextToken();
	    if ( symp.equals(system) ) continue;
	    cnt++;
	    BodySystem bs = Common.getBodySystem(symp);
	    symp2 = bs.getPrintName();
	    sb.append("<a href=\"" + D.servletShowBodySystem + "?bs=" +
		      symp + "\"> " + symp2 + "</a> ");
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
	  sb.append("<tr><td><b>" +
		    // "Conjectured Diseases:" +
		    L.ConjecturedDiseases +
		    "</b></td><td>");
	  st = new StringTokenizer(allDiseases, ",");
	  while ( st.hasMoreTokens() ) {
	    symp = st.nextToken();
	    if ( Common.isDiseaseMember(symp, expertDiseases) ||
		 Common.isDiseaseMember(symp, diseases) ) continue;
	    cnt++;
	    Disease dis = Common.getDisease(symp);
	    symp2 = dis.getPrintName();
	    sb.append("<a href=\"" + D.servletShowDisease + "?dis=" + symp + "\">" +
		      symp2 + "</a> ");
	  }
	  sb.append("</td></tr>");
	  if ( 0 < cnt ) { 
	    displayStringBuffer = true;
	    dsb.append(sb.toString());
	  }
	}
	if ( displayStringBuffer ) out.println(dsb.toString());


	out.println("</table></center>");

	if ( !allUnknowns.equals("") ) {
	    out.println("<br><b>" + 
			// "Not processed concepts:" +
			L.UserSearchS3 +
			"</b>");
	    st = new StringTokenizer(allUnknowns, ",");
	    while (st.hasMoreTokens()) 
		out.println(" " + st.nextToken());
	}
      out.println(DV.htmlDismiss);

      String googleAd = D.googleAd;
      if ( !googleAd.equals("") ) out.println(googleAd);

      out.println("</body>");
      out.println("</html>");
    }
}











