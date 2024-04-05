// Copyright OntoOO Inc, 2000
package show;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.D;

public class ShowAll extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>Show All</title></head>");
      out.println("<body bgcolor=\"yellow\">");
      out.println("<h1>Show All</h1>");
      out.println(
  "<br /><a href=\"" + D.servletShowLocations + "\">Show Locations</a>" +
  "<br /><a href=\"" + D.servletShowBodySystems + "\">Show BodySystems</a>" +
  "<br /><a href=\"" + D.servletShowDiseases + "\">Show Diseases</a>" +
  "<br /><a href=\"" + D.servletShowDiseaseSets + "\">Show Disease Sets</a>" +
  "<br /><a href=\"" + D.servletShowAbnormalConditions + "\">Show AbnormalConditions</a>" +
  "<br /><a href=\"" + D.servletShowSymptoms + "\">Show Symptoms</a>" +
  "<br /><a href=\"" + D.servletShowExternalCauses + "\">Show ExternalCauses</a>" +
  "<hr />" +
  "<br /><a href=\"" + D.servletShowSymptomsDis + "\">Show Symptoms & Diseases</a>" +
  "<br /><a href=\"" + D.servletShowExternalCausesDis + "\">Show ExternalCauses & Diseases</a>" +
  "<br><a href='" + D.servletShowDrugs + "'>Show Drugs</a>"
  );

      out.println("</body>");
      out.println("</html>");
    }
}



