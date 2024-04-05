// (C) OntoOO Inc 2001
package show;

import com.Common;
import com.DV;
import concepts.BodySystem;
import com.D;
import com.L;
import misc.SendEmail;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowBodySystem extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String bsName = req.getParameter("bs");
	String printName = null;
	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>" + L.BodySystem + "</title> " +
		    D.favicon + "</head>");
	try {
	  if ( null == bsName || bsName.equals("") ) {
	      out.println("<body bgcolor=\"pink\">");
	      out.println("<h3>Error: Nothing to display</h3>");
	  } else {
	      BodySystem bodySystem = Common.getBodySystem(bsName);
	      if ( null == bodySystem ) {
		  out.println("<body bgcolor=\"pink\">");
		  out.println("<h3>Error: Nothing to display</h3>");
	      }
	      else {
		  printName = bodySystem.getPrintName();
		  out.println("<body bgcolor=\"yellow\">");
		  out.println("<h3>" +
			// "The Body System:" +
			L.ShowBodySystem +
			" " + printName + "</h3>");
		  out.println("<table border=\"1\">");
		  out.println(bodySystem.html());
		  out.println("</table>");
	      }
	  }
	} catch (Exception ex) { 
	    out.println("<body bgcolor=\"pink\">");
	    out.println("<h3>Can't display body system</h3>");
	    out.println("Exception: " + ex.getMessage());
	    Common.log(this.getClass().getName(), 
		       "bsName= " + bsName + "<br />" +
		       ex.getMessage());
	}
	out.println("<p>");

	out.println(DV.htmlDismissOrBack);
	out.println("</body>");
	out.println("</html>");
    }
}



