// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.AbnormalCondition;

public class EditACs extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allAbnormalConditions = Common.allAbnormalConditions();
      int lng = allAbnormalConditions.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>All ACs</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H1>Select AbnormalCondition, # = " + lng + "</H1>");
      String dis, printName;
      AbnormalCondition ac;
      out.println(
	     "<br>" +
	     "<A HREF='" + D.servletEditAC + "?ac=" + "newAC" + "'>" +
	     "new ac" + "</A><p>");
      out.println("<table Border>");
      for (int i = 0; i < allAbnormalConditions.length; i++) {
	dis = allAbnormalConditions[i];
	ac = Common.getAbnormalCondition(dis);
	printName = ac.getPrintName();
	out.println(
	     "<tr><td>" + printName + " </td><td> " +
	     "<A HREF='" + D.servletEditAC + "?ac=" + dis + "'> edit </A></td><td>" +
	     "<A HREF='" + D.servletShowAbnormalCondition + "?ac=" + 
	     dis + "'> show </A></td></tr>");
      }
      out.println("</table>");
      out.println("</BODY>");
      out.println("</HTML>");


    }
}



