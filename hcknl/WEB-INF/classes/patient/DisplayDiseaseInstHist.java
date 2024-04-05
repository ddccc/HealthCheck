// (C) OntoOO Inc 2002
package patient;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.DV;
import com.D;
import com.L;
import concepts.Disease;
import com.Common;
import misc.SessionExpired;

public class DisplayDiseaseInstHist extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      HttpSession session = req.getSession(false);
      if ( null == session ) {
	  SessionExpired.call(res,
			      DV.DisplayDiseaseInstHist);
	  return;
      }
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>" + L.DiseaseDetails + "</title>" +
		  // D.linkHckStyle +
		  D.favicon +
		  "</head>");
      out.println("<body bgcolor=\"yellow\">");
      String printName = "Unknown";
      try {

	String histVecName = req.getParameter("histVecName");
	Vector logSessions = Common.getLogSessions(histVecName);

	String sessionNumStr = req.getParameter("sessionNumStr");
	int sessionNum = 0;
	try { sessionNum = Integer.parseInt(sessionNumStr);
	} catch (NumberFormatException cantHappen) {}
	Hashtable ht = (Hashtable) logSessions.elementAt(sessionNum);
	String key = req.getParameter("key");
	String diseaseName = (String) ht.get(key);
	Float tsFloat = (Float) ht.get("tsFloat");
	float temperature = tsFloat.floatValue();
	DiseaseInst di = new DiseaseInst(diseaseName, temperature);
	Vector selectedSymptoms = (Vector) ht.get("selectedSymptoms");
	HashSet notSelectedSymptoms = (HashSet) ht.get("notSelectedSymptoms");
	di.requalify(selectedSymptoms, notSelectedSymptoms);
	Disease dis = Common.getDisease(diseaseName);
	printName = dis.getPrintName();
	out.println("<h1>" + L.DetailsFor + " " + printName + "</h1>");  
	out.println("<table border=\"1\">");
	out.println(di.html());
	out.println("</table>");
	
      } catch (Exception ex) { 
	out.println("<h1>Can't display disease instance for " + printName + "</h1>");
	out.println(" Exception: " + ex.getMessage());
      }
      out.println("</body>");
      out.println("</html>");
    }
}



