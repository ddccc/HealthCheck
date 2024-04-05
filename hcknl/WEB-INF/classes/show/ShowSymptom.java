// Copyright OntoOO Inc, 2000
package show;

import com.Common;
import com.DV;
import concepts.Symptom;
import com.D;
import com.L;
import misc.SendEmail;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowSymptom extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String sym = req.getParameter("sym");
	String printName = null;
	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>" + L.TheSymptom + "</title> " +
		     D.favicon + "</head>");
	try {
	  if ( null == sym || sym.equals("") ) {
	      out.println("<body bgcolor=\"pink\">");
	      out.println("<h3>Error: Nothing to display</h3>");
	  } else {
	      Symptom symptom = Common.getSymptom(sym);
	      if ( null == symptom ) {
		  out.println("<body bgcolor=\"pink\">");
		  out.println("<h3>Error: Nothing to display</h3>");
	      }
	      else {
		  printName = symptom.getPrintName();
		  out.println("<body bgcolor=\"yellow\">");
		  out.println("<h3>" + L.TheSymptom + " " + printName + "</h3>");
		  out.println("<table border=\"1\">");
		  out.println(symptom.html());
		  out.println("</table>");
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
} // end ShowSymptom



