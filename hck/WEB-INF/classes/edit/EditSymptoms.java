// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.Symptom;

public class EditSymptoms extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allSymptoms = Common.allSymptoms();
      int lng = allSymptoms.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>All Symptoms</title></head>");
      out.println("<body bgcolor=\"lightgreen\">");
      out.println("<h1>Select Symptom, # = " + lng + "</h1>");
      String dis, printName;
      Symptom symptom;

      out.println(
	     "<br>" +
	     "<a href='" + D.servletEditSymptom + "?sym=" + "newSymptom" + "'>" +
	     "new symptom" + "</a><p>");
      out.println("<table border>");
      for (int i = 0; i < lng; i++) {
	dis = allSymptoms[i];
	symptom = Common.getSymptom(dis);
	printName = symptom.getPrintName();
	out.println(
	     "<tr><td>" + 
	     ( dis.equals(printName) ? dis : dis + "/ " + printName ) +
	     " </td><td> " +
	     "<a href='" + D.servletEditSymptom + "?sym=" + dis + "'> edit </a></td><td>" +
	     "<a href='" + D.servletShowSymptom + "?sym=" + 
	              dis + "'> show </a></td></tr>");
      }
      out.println("</table>");
      out.println("</body>");
      out.println("</html>");
    }
}



