// Copyright OntoOO Inc, 2007
package edit;

import com.Common;
import com.DV;
import com.D;
import com.L;
import com.LHE;
import concepts.Symptom;
import concepts.Location;
import concepts.LocationSet;


import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ShowLocationHierarchy extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	Vector locationHierarchy = Common.theLocationHierarchy();
	int lng = locationHierarchy.size();
	String indent = 
	    "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
	    "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	LHE lhe = null;
	String locStr = null;
	String printName = null;
	String gender = null;
	Vector symptoms = null;
	int level = 0;
	StringBuffer sb = null;

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Hierarchy of all locations</TITLE>" +
		  D.favicon + "</HEAD>");

      out.println("<BODY BGCOLOR=\"yellow\">");
      out.println("<H1>Hierarchy of all locations</H1>");
      out.println("Column headings:<br>" +
		  "indent level<br>" +
		  "indented item<br>" +
		  "link<br>" +
		  "# associated symptoms<br>" +
		  "gender LR.both|LR.male|LR.female<p>");

      out.println("<table BORDER>");
      for ( int i = 0; i < lng; i++ ) {
	  lhe = (LHE) locationHierarchy.elementAt(i);
	  locStr = lhe.getLocStr();
	  printName = lhe.getPrintName();
	  gender = lhe.getGender();
	  symptoms = lhe.getSymptoms();
	  level = lhe.getLevel();
	  sb = new StringBuffer();
	  for ( int j = 0; j < level; j++ ) sb.append(indent);
	  sb.append(printName);
	  out.println("<tr><td>" + 
		      level + "</td><td>" + 
		      sb.toString() + "</td><td>" + 
		      "<A HREF='" + D.servletShowLocation + "?loc=" + locStr + "'>" +
		      locStr + "</A></td><td>" + 
		      symptoms.size() + "</td><td>" + 
		      gender + 
		      "</td></tr>");

      }
      out.println("</table>");
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
	// Vector allSymptoms = loc.getAllSymptoms();
	Vector symptoms = loc.getSymptoms();


	StringBuffer sb = new StringBuffer();
	String indent = 
	    "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
	    "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";

	for (int i = 0; i < level; i++) sb.append(indent);
	// sb.append(locStr + "/" + printName);
	sb.append(printName);
	// sb.append("<br>");
	out.println("<tr><td>" + level + "</td><td>" +
		    sb.toString() + "</td><td>" + 
		    "<A HREF='" + D.servletShowLocation + "?loc=" + locStr + "'>" +
		    locStr + "</A></td><td>" + 
		    // allSymptoms.size() + "</td><td>" + 
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
}




