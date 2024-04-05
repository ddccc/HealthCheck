package su;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Zdirectory extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {

      File aFile = new File("webapps/hck/WEB-INF/classes/users/aFile.txt");

      String path = aFile.getAbsolutePath();

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("path = " + path);

    }
}



