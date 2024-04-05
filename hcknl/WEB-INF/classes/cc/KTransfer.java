// (C) OntoOO Inc 2002
package cc;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.DV;
import com.D;
import misc.DB;
import patient.KClient;
import misc.SessionExpired;

public class KTransfer extends HttpServlet {


  public void doGet (HttpServletRequest req, 
		     HttpServletResponse res)
       throws ServletException, IOException
  {
    String clientId = req.getParameter("client");
    HttpSession session = req.getSession(false);
    if ( null == session ) {
	    SessionExpired.call(res,
				DV.KInvite);
	    return;
    }
    String kstate = (String) session.getValue("kstate");
    if ( !kstate.equals("available") ) {
	KCallPerson.call(res, session);
      return;
    }
    DB props = (DB) session.getValue("theDB");
    String phoneNumber = props.getProperty("phone");
    try {
      HttpSession clientSession = KClient.getKClient(clientId);
      synchronized(clientSession) {
	String state = (String) clientSession.getValue("state");
	if ( !state.equals("initial") ) {
	    KCallPerson.call(res, session);
	    return;
	}
	clientSession.putValue("state", "transfer"); 
	clientSession.putValue("phoneNumber", phoneNumber);
	clientSession.putValue("kCallPerson", session.getId());
	clientSession.putValue("kCallPersonName", 
			       session.getValue("ccName"));
	clientSession.putValue("kCallPersonLogName", 
			       session.getValue("logName"));
      }
      session.putValue("kstate", "inviting");
      session.putValue("invitedClient", clientId);
      // time out the invitation after 120 sec
      session.putValue("invitationTimeout", 
		       new Long(120000 + ((new Date()).getTime())) );
    } catch(Exception ex) {
      session.putValue("kstate", "available");
    }
    KCallPerson.call(res, session);

  }
}



