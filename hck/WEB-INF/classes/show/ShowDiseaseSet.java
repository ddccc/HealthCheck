// Copyright OntoOO Inc, 2007 March
package show;

import com.Common;
import com.DV;
import com.D;
import com.L;
import concepts.DiseaseSet;
import concepts.Disease;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowDiseaseSet extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String diss = req.getParameter("dis");
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>" + L.TheDiseaseSet + " " + diss + "</title>" +
		  D.favicon + "</head>");
      out.println("<body bgcolor=\"yellow\">");
      DiseaseSet diseaseSet = Common.getDiseaseSet(diss);
      if ( null != diseaseSet ) {
	String printName = diseaseSet.getName();
	try {
	  out.println("<h3>" + L.TheDiseaseSet + " " + printName + "</h3>");
	  Vector diseaseMembers = diseaseSet.getDiseaseMembers();
	  Collections.sort(diseaseMembers);
	  int lng = diseaseMembers.size();
	  out.println("<br />" +
		      // "# diseaseMembers:" +
		      L.ShowDiseaseSetS1 +
		      " " + lng);
	  String diseaseName;
	  Disease dis;
	  String diseasePrintName;
	  if (0 < lng) {
	     out.println("<table border=\"1\">");
	     for (int i = 0; i < lng; i++) {
	       diseaseName = (String) diseaseMembers.elementAt(i);
	       dis = Common.getDisease(diseaseName);
	       diseasePrintName = dis.getPrintName();
	       out.println(
		 "<tr><td>" + diseasePrintName + 
		 "</td><td><a href=\"" + D.servletShowDisease + "?dis=" + diseaseName + 
                 /*
		 "\"> show </a></td><td><a href=\"" + D.servletEditDisease + "?dis=" + 
		                                diseaseName + 
		 "\"> edit </a></td></tr>");
                 */
                 "\"> show </a></td></tr>");
	     }
	     out.println("</table>");
	  }
	  // out.println(diseaseSet.html());
	} catch (Exception ex) {
	  out.println("<h3>Exception with the DiseaseSet: " + 
		      printName + "</h3>");
	  out.println(ex.getMessage() + "<p>");
	  ByteArrayOutputStream baos = new ByteArrayOutputStream();
	  PrintWriter pw = new PrintWriter(baos, true); // autoflush
	  ex.printStackTrace(pw);
	  out.println("Stack trace: <pre>");
	  out.println(baos.toString());
	  out.println("</pre>");  
	}
      } else {
	out.println("<h3>The DiseaseSet: " + diss + 
		    " has not yet been defined ...</h3>");
      }

      out.println(DV.htmlDismissOrBack);

      out.println("</body>");
      out.println("</html>");
    }
}




