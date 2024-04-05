// Copyright OntoOO Inc, 2000
package show;

import com.Common;
import com.DV;
import concepts.Location;
import com.D;
import com.L;
import misc.SendEmail;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowLocation extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String loc = req.getParameter("loc");
	String printName = null;
	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>" + L.TheLocation + "</title> " +
		     D.favicon + "</head>");
	try {
	  if ( null == loc || loc.equals("") ) {
	      out.println("<body bgcolor=\"pink\">");
	      out.println("<h3>Error: Nothing to display</h3>");
	  } else {
	      Location location = Common.getLocation(loc);
	      if ( null == location ) {
		  out.println("<body bgcolor=\"pink\">");
		  out.println("<h3>Error: Nothing to display</h3>");
	      }
	      else {
		  printName = location.getPrintName();
		  out.println("<body bgcolor=\"yellow\">");
		  out.println("<h3>" + L.TheLocation + " " + printName + "</h3>");
		  out.println("<table border=\"1\">");
		  out.println(location.html());
		  out.println("</table>");
	      }
	  }
	} catch (Exception ex) { 
	    out.println("<body bgcolor=\"pink\">");
	    out.println("<h3>Can't display abnormal condition</h3>");
	    out.println("Exception: " + ex.getMessage());
	    Common.log(this.getClass().getName(), 
		       "loc= " + loc + "<br />" +
		       ex.getMessage());
	}
	out.println("<p>");
	out.println(DV.htmlDismissOrBack);

	out.println("</body>");
	out.println("</html>");
    }
}




