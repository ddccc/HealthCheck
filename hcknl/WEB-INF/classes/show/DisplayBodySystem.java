// (C) OntoOO Inc, 2000
package show;

import com.Common;
import com.DV;
import com.L;
import concepts.BodySystem;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// ******************* DEAD CODE **************************
// ******************* DEAD CODE **************************
// ******************* DEAD CODE **************************
// ******************* DEAD CODE **************************
// ******************* DEAD CODE **************************
// ******************* DEAD CODE **************************

public class DisplayBodySystem extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String bsName = req.getParameter("bs");
	String printName = null;
	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>" + L.BodySystem + "</title></head>");
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
		  out.println("<body bgcolorR=\"yellow\">");
		  out.println("<h1>" + L.DetailsFor + " " + printName + "</h1>");  
		  out.println(bodySystem.html());
	      }
	  }
	} catch (Exception ex) { 
	    out.println("<body bgcolor=\"pink\">");
	    out.println("<h1>Can't display this body system</h1>");
	    out.println("Exception: " + ex.getMessage());
	    Common.log(this.getClass().getName(), 
		       "bsName= " + bsName + "<br />" +
		       ex.getMessage());
	}
	out.println("<p>");
	out.println(DV.htmlDismiss);
	out.println("</body>");
	out.println("</html>");
    }
}





