// Copyright OntoOO/ Dennis de Champeaux, 2011
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.D;
import com.LR;


public class Incidence extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>Incidence</title>" +
		  D.favicon + "</head>");
      out.println("<body bgcolor=\"lightgreen\">");
      out.println("<h1>Disease Incidence</h1>");
      out.println("<form action='" + D.servletIncidence2 + "'>");
      out.println("<table border=\"1\">");
      out.println("<tr><td><b>Gender:</b></td><td>Age:</td></tr>");
      out.println("<tr><td><select name=\"gender\">");
      out.println("<option value=\"" + LR.male + "\">" + LR.male + "</option>");
      out.println("<option value=\"" + LR.female + "\">" + LR.female + "</option>");
      out.println("</select></td>");
      out.println("<td><select name=\"age\">");
      out.println("<option value=\"1\">1-4</option>");
      for (int i = 5; i < 100; i = i + 5)
	  out.println("<option value=\"" + i + "\">" + i +"-" + (i+4) + "</option>");
      out.println("<option value=\"100\">100-</option>");
      out.println("</select></td><tr>");
      out.println("</table>");
      out.println("<p><input type=\"submit\" value=\"Submit\">");
      out.println("</form>");
      out.println("<p><p>");
      out.println("<form><input type=\"button\" value=\"Back\" onClick=\"history.back()\" /></form>");
      out.println("</body>");
      out.println("</html>");
    }
}



