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

public class ShowExternalCauses extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allExternalCauses = Common.allExternalCauses();
      int lng = allExternalCauses.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>" + L.AllExternalCauses + "</title></head>");
      out.println("<body bgcolor=\"yellow\">");
      out.println("<h1>" + L.AllExternalCauses + " # = " + lng + "</h1>");
      String dis, printName;
      // ExternalCause externalCause;
      for (int i = 0; i < allExternalCauses.length; i++) {
	printName = allExternalCauses[i];
	dis = java.net.URLEncoder.encode(printName);
	//	externalCause = Common.getExternalCause(dis);
	//	printName = externalCause.getPrintName();
	out.println(
	     "<br />" +
	     "<a href=\"" + D.servletShowExternalCause + "?ec=" + dis + "\">" +
	     printName + "</a>");
      }

      out.println(DV.htmlBack);

      out.println("</body>");
      out.println("</html>");
    }
}



