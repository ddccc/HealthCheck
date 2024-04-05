// Copyright OntoOO Inc, 2000
package show;

import com.Common;
import com.DV;
import com.D;
import com.L;
import concepts.DiseaseSet;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ShowDiseaseSets extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allDiseaseSets = Common.allDiseaseSets();
      int lng = allDiseaseSets.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>" + L.AllDiseaseSets + "</title>" +
		  D.favicon + "</head>");
      out.println("<body bgcolor=\"lightgreen\">");
      out.println("<h1>" +
		  // "Select Disease Set, # =" +
		  L.ShowDiseaseSetsS1 +
		  " " + lng + "</h1>");
      String dis, printName;
      DiseaseSet diseaseSet;
      int lng2;
      out.println("<table border=\"1\">");
      for (int i = 0; i < lng; i++) {
	dis = allDiseaseSets[i];
	diseaseSet = Common.getDiseaseSet(dis);
	lng2 = diseaseSet.getDiseaseMembers().size();
	printName = diseaseSet.getPrintName();
	out.println(
	     "<tr><td>" + printName + " </td><td> " + lng2 + "</td><td>" +
	     "<a href=\"" + D.servletShowDiseaseSet + "?dis=" + 
	              dis + "\"> show </a></td></tr>");
      }
      out.println("</table>");

      out.println(DV.htmlBack);

      out.println("</body>");
      out.println("</html>");
    }
}



