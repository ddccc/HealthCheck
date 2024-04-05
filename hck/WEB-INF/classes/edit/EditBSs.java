// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.BodySystem;

public class EditBSs extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allBodySystems = Common.allBodySystems();
      int lng = allBodySystems.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>All BSs</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H1>Select BodySystem, # = " + lng + "</H1>");
      String dis, printName;
      BodySystem bs;
      out.println( 
	     "<br>" +
	     "<A HREF='" + D.servletEditBS + "?bs=" + "newSys" + "'>" +
	     "new BS" + "</A><p>");
      out.println("<table Border>");
      for (int i = 0; i < allBodySystems.length; i++) {
	dis = allBodySystems[i];
	bs = Common.getBodySystem(dis);
	printName = bs.getPrintName();
	out.println(
	     "<tr><td>" + printName + " </td><td> " +
	     "<A HREF='" + D.servletEditBS + "?bs=" + dis + "'> edit </A></td><td>" +
	     "<A HREF='" + D.servletShowBodySystem + "?bs=" + 
	               dis + "'> show </A></td></tr>");
      }
      out.println("</table>");
      out.println("</BODY>");
      out.println("</HTML>");
    }
}



