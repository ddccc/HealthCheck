// Copyright OntoOO Inc, 2000
package misc;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.DV;

public class SessionExpired extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String module = req.getParameter("m");
      call(res, module);
    }

    static public void call(HttpServletResponse res, String module)
	throws IOException {
      int moduleNum = -1;
      try { moduleNum = Integer.parseInt(module); }
      catch ( NumberFormatException ignore ) {}
      if ( DV.SessionExpiredInfo.length <= moduleNum ) moduleNum = -1;
      call(res, moduleNum);
    }

    static public void call(HttpServletResponse res, int moduleNum)
	throws IOException {
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>Session Expired</title></head>");
      out.println("<body bgcolor=\"pink\">");
      out.println("<h2>Your Session Expired ...</h2>");
      out.println("<h3>Log in again</h3>");
      out.println("Session Expiration was found in module: " +
		  ( 0<= moduleNum ? DV.SessionExpiredInfo[moduleNum] : "??" ) );
      out.println("</body>");
      out.println("</html>");

    }
}





