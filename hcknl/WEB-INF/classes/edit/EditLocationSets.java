// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.LocationSet;


public class EditLocationSets extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allLocationSets = Common.allLocationSets();
      int lng = allLocationSets.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>All LocationSets</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H1>Select LocationSet, # = " + lng + "</H1>");
      String dis;
      LocationSet pl;
      out.println(
	     "<br>" +
	     "<A HREF='" + D.servletEditLocationSet + "?ls=" + 
	     "newLocationSet" + "'>" +
	     "new ls" + "</A><p>");
      out.println("<table Border>");
      for (int i = 0; i < allLocationSets.length; i++) {
	dis = allLocationSets[i];
	out.println(
	     "<tr><td>" + dis + " </td><td> " +
	     "<A HREF='" + D.servletEditLocationSet + "?ls=" + 
	              dis + "'> edit </A></td><td>" +
	     "<A HREF='" + D.servletShowLocation + "?loc=" + 
	              dis + "'> show </A></td></tr>");
      }
      out.println("</table>");
      out.println("</BODY>");
      out.println("</HTML>");
    }
}



