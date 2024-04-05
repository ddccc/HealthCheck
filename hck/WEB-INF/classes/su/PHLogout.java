// (C) OntoOO Inc 2005 July
package su;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import com.D;
import htmls.PHLoginH;

public class PHLogout extends HttpServlet {
    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      HttpSession session = req.getSession(false);
      if ( null != session ) {
	session.invalidate();
      }

      PHLoginH.call(res);

    } // end doGet

} // end PHLogout
