// (C) OntoOO/ Dennis de Champeaux 2011
package patient;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import com.DV;
import misc.SessionExpired;

/*
  A user may have confirmed (a) symptom(s) that is(are) (critical) side-effect(s) of
  a used drug(s).  The user has accepted the advice to terminate the session,
  which triggers this exit path.
 */
public class Diag1cTerminate extends HttpServlet {
 public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      HttpSession session = req.getSession(false);
      if ( null == session ) {
	    SessionExpired.call(res, DV.Diag1cTerminate);
	    return;
      }
      // comma separated symptom names
      String regularSideEffects = req.getParameter("regularSideEffects");
      String criticalSideEffects = req.getParameter("criticalSideEffects");
      Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");
      if ( !regularSideEffects.equals("") ) 
	  unboundHashtable.put("regularSideEffects", regularSideEffects);      
      if ( !criticalSideEffects.equals("") )
	  unboundHashtable.put("criticalSideEffects", criticalSideEffects);
      
      UserLogout.call(req, res);
    } // end doGet
} // end Diag1cTerminate
