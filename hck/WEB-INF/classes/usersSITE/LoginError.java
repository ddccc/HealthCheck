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
	out.println("<HTML>");
	out.println("<HEAD><TITLE>Login Error</TITLE></HEAD>");
	out.println("<BODY  BGCOLOR=pink>");
	  
	out.println("<H1 align=center><FONT Color='#FF0000' SIZE=4>" +
		    "Login Error</FONT></H1>");
	out.println(msg);
	out.println(DV.htmlBack);
	out.println("</BODY></HTML>");
    }
}
