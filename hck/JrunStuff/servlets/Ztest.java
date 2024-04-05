import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Ztest extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
        // res.setContentType("image/gif");
	// res.sendRedirect("http://localhost:8000/jrunlogo.gif");
        // res.setContentType("image/jpg");
	// res.sendRedirect("http://localhost:8000/standing.jpg");
	
	Enumeration enum = req.getParameterNames();
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Ztest servlet</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=yellow>");
      out.println("<H3>Ztest servlet</H3>");
      while (enum.hasMoreElements()) {
		String name = (String) enum.nextElement();
		String value = req.getParameter(name);
		out.println(name + " " + value);
	}
      out.println("</BODY>");
      out.println("</HTML>");
    }
}



