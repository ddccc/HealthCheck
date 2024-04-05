// (C) OntoOO Inc 2002 August
package users;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.DV;

public class LoginError extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String msg = req.getParameter("msg");

	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>Login Error</title></head>");
	out.println("<body bgcolor=\"pink\">");
	  
	out.println("<h1 align=\"center\"><font color=\"#FF0000\" size=\"4\">" +
		    "Login Error</font></h1>");
	out.println(msg);
	out.println(DV.htmlBack);
	out.println("</body></html>");
    }
}
