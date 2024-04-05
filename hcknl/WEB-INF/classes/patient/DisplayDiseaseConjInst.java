// (C) OntoOO Inc 2002
package patient;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.DV;
import com.D;
import com.L;
import com.Common;
import concepts.Disease;
import misc.SessionExpired;

public class DisplayDiseaseConjInst extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      HttpSession session = req.getSession(false);
      if ( null == session ) {
	  SessionExpired.call(res,
			      DV.DisplayDiseaseConjInst);
	  return;
      }
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      String printName = "exception: unknown print name";
      String clientId = "unknown";

      String sessionKey = req.getParameter("sessionKey");
      try {
	Vector diseases = (Vector) session.getValue(sessionKey);

	String diseaseNumStr = req.getParameter("diseaseNum");
	int diseaseNum = 0;
	try { diseaseNum = Integer.parseInt(diseaseNumStr);
	} catch (NumberFormatException cantHappen) {}

	DiseaseInst di = (DiseaseInst) diseases.elementAt(diseaseNum);
	String diseaseName = di.getDisease();
	Disease dis = Common.getDisease(diseaseName);
	printName = dis.getPrintName();
	out.println("<html>");
	out.println("<head><title>" + L.DiseaseDetails + "</title>" +
		    // D.linkHckStyle +
		    D.favicon +
		    "</head>");
	out.println("<body bgcolor=\"yellow\">");
	out.println("<h1>" + L.DetailsFor + " " + printName + "</h1>");
	out.println("<table border=\"1\">");
	out.println(di.html());
	out.println("</table>");
	out.println(DV.htmlDismiss);
	
      } catch (Exception ex) { 
	out.println("<h3>*** Can't display disease instance for " + printName + "</h3>");
	out.println("<br />*** clientId: " + clientId);
	out.println("<br>Exception: " + ex.getMessage());
	out.println(DV.htmlDismiss);

      }
      out.println("</body>");
      out.println("</html>");
    }
}




