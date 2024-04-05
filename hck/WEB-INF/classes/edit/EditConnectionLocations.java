// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.ConnectionLocation;

public class EditConnectionLocations extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allConnectionLocations = Common.allConnectionLocations();
      int lng = allConnectionLocations.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>All ConnectionLocations</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H1>Select ConnectionLocation, # = " + lng + "</H1>");
      String dis;
      ConnectionLocation pl;
      out.println(
	     "<br>" +
	     "<A HREF='" + D.servletEditConnectionLocation + "?cl=" + 
	     "newConnectionLocation" + "'>" +
	     "new cl" + "</A><p>");
      out.println("<table Border>");
      for (int i = 0; i < allConnectionLocations.length; i++) {
	dis = allConnectionLocations[i];
	out.println(
	     "<tr><td>" + dis + " </td><td> " +
	     "<A HREF='" + D.servletEditConnectionLocation + "?cl=" + dis + 
	     "'> edit </A></td><td>" +
	     "<A HREF='" + D.servletShowLocation + "?loc=" + 
	              dis + "'> show </A></td></tr>");
      }
      out.println("</table>");
      out.println("</BODY>");
      out.println("</HTML>");
    }
}



