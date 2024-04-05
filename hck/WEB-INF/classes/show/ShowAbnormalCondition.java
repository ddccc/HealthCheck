// Copyright OntoOO Inc, 2000
package show;

import com.Common;
import com.DV;
import concepts.AbnormalCondition;
import com.D;
import com.L;
import misc.SendEmail;


import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowAbnormalCondition extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String ac = req.getParameter("ac");
	String printName = null;
	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>" + L.AnAbnormalCondition + "</title> " +
		     D.favicon + "</head>");
	try {
	  if ( null == ac || ac.equals("") ) {
	      out.println("<body bgcolor=\"pink\">");
	      out.println("<h3>Error: Nothing to display</h3>");
	  } else {
	      AbnormalCondition abc = Common.getAbnormalCondition(ac);
	      if ( null == abc ) {
		  out.println("<body bgcolor=\"pink\">");
		  out.println("<h3>Error: Nothing to display</h3>");
	      }
	      else {
		  printName = abc.getPrintName();
		  out.println("<body bgcolor=\"yellow\">");
		  out.println("<h3>" +
			      // "The Abnormal Condition:" +
			      L.ShowAC +
			      " " + printName + "</h3>");
		  out.println("<table border=\"1\">");
		  out.println(abc.html());
		  out.println("</table>");
	      }
	  }
	} catch (Exception ex) { 
	    out.println("<body bgcolor=\"pink\">");
	    out.println("<h3>Can't display abnormal condition</h3>");
	    out.println("Exception: " + ex.getMessage());
	    Common.log(this.getClass().getName(), 
		       "ac= " + ac + "<br />" +
		       ex.getMessage());
	}
	out.println("<p>");
	out.println(DV.htmlDismissOrBack);
	
	out.println("</body>");
	out.println("</html>");
    }
}




