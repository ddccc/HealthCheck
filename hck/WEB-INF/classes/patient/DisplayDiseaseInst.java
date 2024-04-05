// (C) OntoOO Inc 2002
package patient;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.DV;
import com.D;
import com.L;
import concepts.Disease;
import misc.DiagStackEntry;
import misc.SessionExpired;

public class DisplayDiseaseInst extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      HttpSession clientSession;
      HttpSession session = req.getSession(false);
      if ( null == session ) {
	  SessionExpired.call(res,
			      DV.DisplayDiseaseInst);
	  return;
      }
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      String printName = "exception: unknown print name";
      String clientId = "unknown";
      try {
        // Investigate whether we are in the user or in the callcenter
         clientId = req.getParameter("clientId");
        if ( clientId.equals("client") ) 
	   // we are in the user
	   clientSession = session;
        else
	   // we are in the callcenter
	   // (notice that we assume that a callcenter person invites
	   // only one client at the time !!)
	   clientSession = KClient.getKClient(clientId);
	Vector diagStack = (Vector) clientSession.getValue("diagStack");
	// String iter = (String) clientSession.getValue("iter");
	String iter = req.getParameter("iter");
	int iteration = 0;
	try { iteration = Integer.parseInt(iter); } 
	catch(NumberFormatException ignore) {}  
	DiagStackEntry dse = (DiagStackEntry) diagStack.elementAt(iteration);
	Vector diseases = (Vector) dse.getDiseases(); // ie DiseaseInst
        // Vector diseases = (Vector) clientSession.getValue("diseases");
	String diseaseInstNum = req.getParameter("dis");
	int disInstNum = 0;
	try { disInstNum = Integer.parseInt(diseaseInstNum);
	} catch (NumberFormatException cantHappen) {}
	DiseaseInst di = (DiseaseInst) diseases.elementAt(disInstNum);
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
	out.println("<br />Exception: " + ex.getMessage());
	out.println(DV.htmlDismiss);

      }
      out.println("</body>");
      out.println("</html>");
    }
}







