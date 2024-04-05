// Copyright OntoOO Inc, 2000
package show;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.DV;
import com.D;
import com.L;
import concepts.Symptom;


public class ShowSymptoms extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allSymptoms = Common.allSymptoms();
      int lng = allSymptoms.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>" + L.AllSymptoms + "</title>" +
		  D.favicon + "</head>");
      out.println("<body bgcolor=\"yellow\">");
      out.println("<h1>" + L.AllSymptoms + " # = " + lng + "</h1>");
      String dis, printName;
      Symptom symptom;
      for (int i = 0; i < allSymptoms.length; i++) {
	dis = allSymptoms[i];
	symptom = Common.getSymptom(dis);
	printName = symptom.getPrintName();
	out.println(
	     "<br />" +
	     "<a href=\"" + D.servletShowSymptom + "?sym=" + dis + "\">" +
	     printName + "</a>");
      }

      out.println(DV.htmlBack);

      out.println("</body>");
      out.println("</html>");
    }
}





