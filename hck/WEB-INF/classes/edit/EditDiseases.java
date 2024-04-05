// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.Disease;

public class EditDiseases extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allDiseases = Common.allDiseases();
      int lng = allDiseases.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>All Diseases</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H1>Select Disease, # = " + lng + "</H1>");
      String dis, printName;
      Disease disease;
      boolean isLT;
      out.println(
	     "<br>" +
	     "<A HREF='" + D.servletEditDisease + "?dis=" + "newDisease" + "'>" +
	     "new disease" + "</A><p>");
      out.println("<table Border>");
/*
      for (int i = 0; i < allDiseases.length; i++) {
	dis = allDiseases[i];
	disease = Common.getDisease(dis);
	isLT = disease.isLifeThreatening();
	printName = disease.getPrintName();
	printName = ( dis.equals(printName) ? dis : dis + "/ " + printName );
	out.println(
	     "<tr><td>" + 
	     ( isLT ? 
	       "<FONT Color= \"FF0000\">" + printName + "</FONT>" :
	       printName ) +
	     " </td><td> " +
	     "<A HREF='/servlet/EditDisease?dis=" + dis + "'> edit </A></td><td>" +
	     "<A HREF='/servlet/ShowDisease?dis=" + dis + "'> show </A></td></tr>");
      }
*/
      // to speed things up do not get the disease/ printname ...
      for (int i = 0; i < lng; i++) {
	dis = allDiseases[i];
	out.println(
	     "<tr><td>" + dis + " </td><td> " +
	     "<A HREF='" + D.servletEditDisease + "?dis=" + dis + "'> edit </A></td><td>" +
	     "<A HREF='" + D.servletShowDisease + "?dis=" + 
	              dis + "'> show </A></td></tr>");
      }
      out.println("</table>");
      out.println("</BODY>");
      out.println("</HTML>");


    }
}



