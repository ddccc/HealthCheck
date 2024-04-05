// Copyright OntoOO Inc, 2011
package show;

import com.Common;
import com.DV;
import concepts.Drug;
import com.D;
import com.L;
import misc.SendEmail;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowDrug extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String sym = req.getParameter("drug");
	String printName = null;
	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>" + L.TheDrug + "</title> " +
		     D.favicon + "</head>");
	try {
	  if ( null == sym || sym.equals("") ) {
	      out.println("<body bgcolor=\"pink\">");
	      out.println("<h3>Error: Nothing to display</h3>");
	  } else {
	      Drug drug = Common.getDrug(sym);
	      if ( null == drug ) {
		  out.println("<body bgcolor=\"pink\">");
		  out.println("<h3>Error: Nothing to display</h3>");
	      }
	      else {
		  printName = drug.getDescription();
		  out.println("<body bgcolor=\"yellow\">");
		  out.println("<h3>" + L.TheDrug + " " + printName + "</h3>");
		  out.println("<table border=\"1\">");
		  out.println(drug.html());
		  out.println("</table>");
	      }
	  }
	} catch (Exception ex) { 
	    out.println("<body bgcolor=\"pink\">");
	    out.println("<h3>Can't display drug</h3>");
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
} // end ShowDrug



