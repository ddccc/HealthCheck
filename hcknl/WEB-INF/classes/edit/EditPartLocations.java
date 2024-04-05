// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.PartLocation;

public class EditPartLocations extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allPartLocations = Common.allPartLocations();
      int lng = allPartLocations.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>All PartLocations</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H2>Select PartLocation, # = " + lng + "</H2>" +
		  "<br>Warning: body canNOT be edited");
      String dis;
      PartLocation pl;
      out.println(
	     "<p>" +
	     "<A HREF='" + D.servletEditPartLocation + "?pl=newPartLocation'>" +
	     "new part location </A>");

      out.println("<table Border>");
      for (int i = 0; i < allPartLocations.length; i++) {
	dis = allPartLocations[i];
	out.println(
	     "<tr><td>" + dis + " </td><td> " +
	     "<A HREF='" + D.servletEditPartLocation + "?pl=" + 
	              dis + "'> edit </A></td><td>" +
	     "<A HREF='" + D.servletShowLocation + "?loc=" + 
	              dis + "'> show </A></td></tr>");
      }
      out.println("</table>");
      out.println("</BODY>");
      out.println("</HTML>");
    }
}



