// (C) OntoOO Inc 2002 May
package su;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.D;

public class SULogout extends HttpServlet {
    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      HttpSession session = req.getSession(false);
      if ( null != session ) session.invalidate();
      res.sendRedirect(D.suloginHtml);
    } // end doGet
} // end SULogout
