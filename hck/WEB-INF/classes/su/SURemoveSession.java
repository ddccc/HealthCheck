// (C) OntoOO Inc 2005 Jul
package su;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import misc.HCError;

public class SURemoveSession extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {

      HttpSession session = req.getSession(false);
      if ( null == session ) {
	  HCError.call(res, "Session expired/ relogin ...");
	  return;
      }
      String patient = req.getParameter("account");
      String logName = (String) session.getValue("logName");
      SUtil.deletePHsession(logName, patient);

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      
      // out.println(PHLogin.phPage(logName));
      PHLogin2.phPage(out, logName);
    }

}











