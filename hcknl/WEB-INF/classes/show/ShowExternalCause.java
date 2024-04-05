// Copyright OntoOO Inc, 2000
package show;

import com.Common;
import com.DV;
import com.L;
import com.D;
import concepts.ExternalCause;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowExternalCause extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String sym = req.getParameter("ec");
	String printName = null;
	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>" + L.TheExternalCause + "</title> " +
		     D.favicon + "</head>");
	try {
	  if ( null == sym || sym.equals("") ) {
	      out.println("<body bgcolor=\"pink\">");
	      out.println("<h3>Error: Nothing to display</h3>");
	  } else {
	      ExternalCause externalCause = Common.getExternalCause(sym);
	      if ( null == externalCause ) {
		  out.println("<body bgcolor=\"pink\">");
		  out.println("<h3>Error: Nothing to display</h3>");
	      }
	      else {
		  printName = externalCause.getDescription();
		  out.println("<body bgcolor=\"yellow\">");
		  out.println("<h3>" + L.TheExternalCause + " " + printName + "</h3>");
		  out.println(externalCause.html());
	      }
	  }
	} catch (Exception ex) { 
	    out.println("<body bgcolor=\"pink\">");
	    out.println("<h3>Can't display abnormal condition</h3>");
	    out.println("Exception: " + ex.getMessage());
	    Common.log(this.getClass().getName(), 
		       "sym= " + sym + "<br />" +
		       ex.getMessage());
	}
	out.println("<p>");
	out.println(DV.htmlDismissOrBack);

	out.println("</body>");
	out.println("</html>");
    }
}






