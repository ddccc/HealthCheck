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
import concepts.Location;

public class ShowLocations extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allLocations = Common.allLocations();
      int lng = allLocations.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>" + L.AllLocations + "</title>" +
		  D.favicon + "</head>");
      out.println("<body bgcolor=\"yellow\">");
      out.println("<h1>" + L.AllLocations + " # = " + lng + "</h1>");
      String dis, printName;
      Location location;
      for (int i = 0; i < allLocations.length; i++) {
	dis = allLocations[i];
	location = Common.getLocation(dis);
	printName = location.getName();
	out.println(
	     "<br />" +
	     "<a href=\"" + D.servletShowLocation + "?loc=" + dis + "\">" +
	     printName + "</a>");
      }

      out.println(DV.htmlBack);

      out.println("</body>");
      out.println("</html>");
    }
}



