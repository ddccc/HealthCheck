// Copyright OntoOO/ Dennis de Champeaux, 2011
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.D;
import com.LR;
import com.Incidence358;
import com.Common;
import concepts.Disease;


public class Incidence3 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String gender = req.getParameter("gender");
	String dis = req.getParameter("dis");

	Disease disease = Common.getDisease(dis);
	String printName = disease.getPrintName();

	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>Incidence3</title>" +
		    D.favicon + "</head>");
	out.println("<body bgcolor=\"yellow\">");
	out.println("<h1>Diseases Incidence: gender = " 
		    + gender + " disease = " + printName + "</h1>");
	out.println("<table border=\"1\">");
	for (int i = 0; i < 105; i = i+5) {
	    float ix = Incidence358.incidence(gender, i+1, dis);
	    out.println("<tr><td>" + i + "-" + (i+4) + "</td><td>" + ix + "</td><td><img src='" +
			D.dot3Gif + "' height=8 width=" + (10000*ix) + "><td></tr>");
	}

	out.println("</table>");
	//out.println("</form>");

	out.println("<p><p>");
	out.println("<form><input type=\"button\" value=\"Back\" onClick=\"history.back()\" /></form>");
	out.println("</body>");
	out.println("</html>");
    }
}



