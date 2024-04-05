// Copyright OntoOO Inc, 2000
package show;

import com.Common;
import com.DV;
import com.L;
import concepts.Disease;
import concepts.Symptom;
import concepts.XWord;
import com.D;
import misc.SendEmail;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowDisease extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String dis = req.getParameter("dis");
	String printName = null;
	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>" + L.TheDisease + "</title> " +
		     D.favicon + "</head>");
	try {
	  if ( null == dis || dis.equals("") ) {
	      out.println("<body bgcolor=\"pink\">");
	      out.println("<h3>Error: Nothing to display</h3>");
	  } else {
	      Disease disease = Common.getDisease(dis);
	      if ( null != disease ) {
		  printName = disease.getPrintName();
		  out.println("<body bgcolor=\"yellow\">");
		  out.println("<h3>" + L.TheDisease + " " + printName + "</h3>");
		  out.println("<table border=\"1\">");
		  out.println(disease.html());
		  out.println("</table>");
	      } else {
		  XWord xw = Common.getXWord(dis);
		  if ( null == xw ) {
		      out.println("<body bgcolor=\"pink\">");
		      out.println("<h3>Error: Nothing to display for: " + dis + "</h3>");
		  } else {
		      String dis2 = xw.getSynonym();
		      // System.out.println("dis: " + dis + " dis2: " + dis2);
		      disease = Common.getDisease(dis2);
		      if ( null == disease ) {
			  out.println("<body bgcolor=\"pink\">");
			  out.println("<h3>Error: Nothing to display for: " + dis + "</h3>");
		      } else {
			  printName = xw.getPrintName() + " => " + disease.getPrintName();
			  out.println("<body bgcolor=\"yellow\">");
			  out.println("<h3>" + L.TheDisease + " " + printName + "</h3>");
			  out.println("<table border=\"1\">");
			  out.println(disease.html());
			  out.println("</table>");
		      }
		  }
	      }
	  }
	} catch (Exception ex) { 
	    out.println("<body bgcolor=\"pink\">");
	    out.println("<h3>Can't display disease</h3>");
	    out.println("Exception: " + ex.getMessage());
	    Common.log("show.ShowDisease", 
		       "dis= " + dis + "<br />" +
		       ex.getMessage());
	}
	out.println("<p>");
	out.println(DV.htmlDismissOrBack);

	out.println("</body>");
	out.println("</html>");
    }
}





