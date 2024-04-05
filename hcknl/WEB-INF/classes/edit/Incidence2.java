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


public class Incidence2 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String gender = req.getParameter("gender");
	String ageS = req.getParameter("age");
	int age = 1;
	try { age = Integer.parseInt(ageS); }
	catch (NumberFormatException ignore) {}
	String [] allDiseases = 
	    ( gender.equals(LR.male) ?
	      Common.allMaleDiseasesArr() :
	      Common.allFemaleDiseasesArr() );
	int lng = allDiseases.length;

	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>Incidence2</title>" +
		    D.favicon + "</head>");
	out.println("<body bgcolor=\"yellow\">");
	out.println("<h1>Diseases Incidence: gender = " 
		    + gender + " age = " + age + "</h1>");
	out.println("<table border=\"1\">");
	for (int i = 0; i < lng; i++) {
	    String dis = allDiseases[i];
	    Disease disease = Common.getDisease(dis);
	    String printName = disease.getPrintName();
	    float ix = Incidence358.incidence(gender, age, dis);
	    out.println("<tr><td><a href=\"" + D.servletIncidence3 + "?gender=" + gender + 
			"&dis=" + dis + "\">" +
			printName + "</td><td>" + ix + "</td><td><img src='" +
			D.dot3Gif + "' height=8 width=" + (10000*ix) + "><td></tr>");
	}

	out.println("</table>");

	out.println("<p><p>");
	out.println("<form><input type=\"button\" value=\"Back\" onClick=\"history.back()\" /></form>");
	out.println("</body>");
	out.println("</html>");
    }
}



