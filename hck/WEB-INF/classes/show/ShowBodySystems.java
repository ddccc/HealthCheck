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
import concepts.BodySystem;


public class ShowBodySystems extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allBodySystems = Common.allBodySystems();
      int lng = allBodySystems.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>" + L.AllBodySystems + "</title>" +
		  D.favicon + "</head>");
      out.println("<body bgcolor=\"yellow\">");
      out.println("<h1>" + L.AllBodySystems + " # = " + lng + "</h1>");
      String dis, printName;
      BodySystem bodySystem;
      for (int i = 0; i < allBodySystems.length; i++) {
	dis = allBodySystems[i];
	bodySystem = Common.getBodySystem(dis);
	printName = bodySystem.getPrintName();
	out.println(
	     "<br />" +
	     "<a href=\"" + D.servletShowBodySystem + "?bs=" + dis + "\">" +
	     printName + "</a>");
      }

      out.println(DV.htmlBack);

      out.println("</body>");
      out.println("</html>");
    }
}





