
// Copyright OntoOO Inc, 2000
package show;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.DV;
import com.D;
import concepts.Symptom;


public class ShowSymptomsDis extends HttpServlet {

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
      out.println("<body bgcolor=\"yellow\">");
      out.println("<h1>All Symptoms # = " + lng + "</h1>");
      out.println("<table border=\"1\">");
      String dis, printName, dis2;
      Symptom symptom;
      boolean first;
      int cnt;
      Vector theDiseases;
      for (int i = 0; i < lng; i++) {
	dis = allSymptoms[i];
	symptom = Common.getSymptom(dis);
	printName = symptom.getPrintName();
	out.println(
	     "<tr><td>" +
	     "<a href=\"" + D.servletShowSymptom + "?sym=" + dis + "\">" +
	     printName + "</a></td><td>");
	theDiseases = symptom.getTheDiseases();
	cnt = 0;
	int lng2 = theDiseases.size();
	if ( 0 < lng2 ) {
	  first = true;
	  while ( cnt < lng2 ) {
	      dis2 = (String) theDiseases.elementAt(cnt);
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



