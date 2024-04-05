// Copyright OntoOO Inc, 2007
package com;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.DV;
import com.D;
import com.L;
import concepts.Symptom;
import concepts.Location;
import concepts.LocationSet;


public class ZMaleSymptoms extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String ageStr = req.getParameter("age");
	if ( null == ageStr ) ageStr = "50";
	int age = 50;
	try { age = Integer.parseInt(ageStr); }
	catch (NumberFormatException ignore) {}

	HashSet maleSymptomNames = Common.allMaleSymptoms();
	Vector maleSymptoms = new Vector();
	
	for (Iterator it = maleSymptomNames.iterator(); it.hasNext();) {
	    String sym = (String) it.next();
	    Symptom symptom = Common.getSymptom(sym);
	    if ( age < symptom.getMinAge() ) continue;
	    if ( symptom.getMaxAge() < age ) continue;
	    maleSymptoms.addElement(symptom);
	}
	Collections.sort(maleSymptoms, new SymComp());

	int lng = maleSymptoms.size();

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>All Male Symptoms</TITLE>" +
		  D.favicon + "</HEAD>");
      out.println(
"<script language=\"JavaScript\"> \n" +
"function fetchSymptom(form) { \n" +
"  idx = form.symptoms.options.selectedIndex; \n" +
"  xyz = form.symptoms.options[idx].value; \n" +
"  split = xyz.indexOf('|'); \n" +
"  head = xyz.substring(0, split); \n" +
// Add the head to a hidden field
"  tail = xyz.substring(split+1, xyz.length); \n" +
"  txt = form.chosenSymptoms.value + ' '; \n" +
// "  alert('*** split: ' + split + ' head: ' + head + ' tail: ' + tail); \n" +
"  form.chosenSymptoms.value = txt + tail; \n" +
"} \n" +
"</script>");

      out.println("<BODY BGCOLOR=\"yellow\">");
      out.println("<H1>All Male Symptoms, # = " + lng + 
		  " age: " + age + "</H1>");
      String dis, printName, description, token;
      String symp, statusCondition;
      Symptom symptom;
      int numberOfDiseases;
      int minAge, maxAge;
      //      /*
      out.println("<table BORDER>");
      for (int i = 0; i < lng; i++) {
	symptom = (Symptom) maleSymptoms.elementAt(i);
	symp = symptom.getName();
	description = symptom.getDescription();
	printName = symptom.getPrintName();
	minAge =  symptom.getMinAge();
	maxAge =  symptom.getMaxAge();
	statusCondition =  symptom.getStatusCondition();
	numberOfDiseases = symptom.getTheDiseases().size();
	out.println(
	     "<tr><td>" +
	     "<A HREF='" + D.servletShowSymptom + "?sym=" + symp + "'>" +
	     symp + "</A></td><td>" + 
	     printName + "</td><td>" + 
	     description + "</td><td>" +
	     minAge + "</td><td>" + 
	     maxAge + "</td><td>" + 
	     statusCondition + "</td><td>" + 
	     numberOfDiseases + "</td></tr>");
      }
      out.println("</table>");
      out.println("<form name=\"sympSelect\">");
      out.println("<p><textarea name=\"chosenSymptoms\" " +
		  "readonly rows=\"1\" cols=\"60\">Hello </textarea>");
      out.println("<p><select name=\"symptoms\" onChange='fetchSymptom(this.form)'>");
      for (int i = 0; i < lng; i++) {
	symptom = (Symptom) maleSymptoms.elementAt(i);
	symp = symptom.getName();
	printName = symptom.getPrintName();
	description = symptom.getDescription();
	token  = ( description.equals(printName) ?
		   printName :
		   printName + "/ " + description );

	out.println("<option value=\"" + symp + "|" + printName + 
		    "\">" + token + "</option>");
      }
      out.println("</select>");
      out.println("</form>");
      //   */
      /*
      String rootStr = "body";
      out.println("<table BORDER>");
      listBodyLocations(out, rootStr, 0, new HashSet());
      out.println("</table>");
      */
      out.println(DV.htmlBack);

      out.println("</BODY>");
      out.println("</HTML>");
    }

    private void listBodyLocations(ServletOutputStream out, 
				   String locStr, int level, HashSet locs) 
	throws IOException {
	if ( locs.contains(locStr) ) return;
	locs.add(locStr);
	Location loc = Common.getLocation(locStr);
	if ( null == loc ) {
	    out.println("**** locStr empty: " + locStr);
	    return;
	}
	String printName = loc.getPrintName();
	Vector allSymptoms = loc.getAllSymptoms();
	Vector symptoms = loc.getSymptoms();


	StringBuffer sb = new StringBuffer();
	String indent = 
	    "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
	    "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";

	for (int i = 0; i < level; i++) sb.append(indent);
	// sb.append(locStr + "/" + printName);
	sb.append(printName);
	// sb.append("<br>");
	out.println("<tr><td>" + sb.toString() + "</td><td>" + 
		    "<A HREF='" + D.servletShowLocation + "?loc=" + locStr + "'>" +
		    locStr + "</A></td><td>" + 
		    allSymptoms.size() + "</td><td>" + 
		    symptoms.size() + "</td><td>" + 
		    loc.getGender() + 
		    "</td></tr>");
	// try to go deeper 
	int level2 = level + 1;
	Vector parts = loc.getParts();
	int lng = parts.size();
	for (int i = 0; i < lng; i++) 
	    listBodyLocations(out,
			      (String) parts.elementAt(i),
			      level2, locs);
	if ( !(loc instanceof LocationSet ) ) return;
	LocationSet ls = (LocationSet) loc;
	parts = ls.getMembers();
	lng = parts.size();
	// if ( 0 < lng ) 
	//    out.println("<tr><td>Set with members: " + locStr + "</td></tr>");
	for (int i = 0; i < lng; i++) 
	    listBodyLocations(out,
			      (String) parts.elementAt(i),
			      level2, locs);
	parts = ls.getSubsets();
	lng = parts.size();
	// if ( 0 < lng ) 
	//     out.println("<tr><td>Set with subsets: " + locStr + "</td></tr>");
	for (int i = 0; i < lng; i++) 
	    listBodyLocations(out,
			      (String) parts.elementAt(i),
			      level2, locs);
    } // end listBodyLocations
} // end ZMaleSymptoms





