// Copyright OntoOO Inc, 2000
package show;

import com.Common;
import com.DV;
import com.D;
import com.L;
import concepts.ExternalCause;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowExternalCausesDis extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allExternalCauses = Common.allExternalCauses();
      int lng = allExternalCauses.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>" +
		  // "All External Causes and Diseases" +
		  L.SECDS1 +
		  "</title></head>");
      out.println("<body bgcolor=\"yellow\">");
      out.println("<h1>" + L.SECDS1 + " # = " + lng + "</h1>");
      out.println("<table border=\"1\">");
      String dis, printName, dis2;
      ExternalCause externalCause;
      boolean first;
      int cnt;
      Vector causesDiseases;
      for (int i = 0; i < lng; i++) {
	printName = allExternalCauses[i];
	dis = java.net.URLEncoder.encode(printName);
	//	printName = externalCause.getPrintName();
	out.println(
	     "<tr><td>" +
	     "<a href=\"" + D.servletShowExternalCause + "?ec=" + dis + "\">" +
	     printName + "</a></td><td>");
	externalCause = Common.getExternalCause(printName);
	causesDiseases = externalCause.getCausesDiseases();
	cnt = 0;
	int lng2 = causesDiseases.size();
	if ( 0 < lng2 ) {
	  first = true;
	  while ( cnt < lng2 ) {
	      dis2 = (String) causesDiseases.elementAt(cnt);
	      cnt++;
	      if ( first ) first = false;
	      else
		  out.println("<br />");
	      out.println("<a href=\"" + D.servletShowDisease + "?dis=" +
			  dis2 + "\">" + dis2 + "</a>");
	  }
	} 
	else
	  out.println("**none**");
	out.println("</td><td>" + cnt + "</td></tr>");
      }
      out.println("</table>");

      out.println(DV.htmlDismissOrBack);

      out.println("</body>");
      out.println("</html>");
    }
}




