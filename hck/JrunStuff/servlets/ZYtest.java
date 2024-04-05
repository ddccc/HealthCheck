import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ZYtest extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      // res.setContentType("image/gif");
      // res.sendRedirect("http://localhost:8000/jrunlogo.gif");
      // res.setContentType("image/jpg");
      // res.sendRedirect("http://localhost:8000/standing.jpg");
	
      // ServletOutputStream out = res.getOutputStream();
      res.sendRedirect("/AngelRoot.html");

    }
}



