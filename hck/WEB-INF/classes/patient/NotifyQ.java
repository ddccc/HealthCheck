// (C) OntoOO Inc 2005 Aug
package patient;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.DV;
import misc.SessionExpired;
import htmls.AngelRoot;

public class NotifyQ extends HttpServlet {
  private static final boolean LOGGING = DV.LOGGINGdiag1;

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      if ( LOGGING ) {
	System.out.println("*** Diag1: Enter");
      }
      HttpSession session = req.getSession(false);
      if ( null == session ) {
	  SessionExpired.call(res,
			      DV.NotifyQ);
	  return;
      }

      // get the decision
      String yesNo = req.getParameter("returnVal");
      if ( yesNo.equals("1") )
	  ElaborateSymptomsQ.call(res, session);
      else
	  AngelRoot.call(res);
    }




} // end NotifyQ

