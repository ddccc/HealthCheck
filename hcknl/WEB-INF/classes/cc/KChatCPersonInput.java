// (C) OntoOO Inc 2002
package cc;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.DV;
import com.D;
import patient.KClient;
import misc.SessionExpired;
import htmls.KChatCPersonInputH;

public class KChatCPersonInput extends HttpServlet {

  public void doGet (HttpServletRequest req, 
		     HttpServletResponse res)
       throws ServletException, IOException
  {
    String cpersonString = req.getParameter("cpersonString");
    HttpSession session = req.getSession(false);
    if ( null == session ) {
	SessionExpired.call(res,
			    DV.KChatCPersonInput);
	return;
    }
    String logName = (String) session.getValue("logName");
    String cst2 = "<b>Call Center/" + logName + "</b> <i>" + cpersonString + "</i><br />";

    String clientId = (String) session.getValue("invitedClient");
    try { // client can disapppear at all times
      HttpSession clientSession = KClient.getKClient(clientId);
      synchronized (clientSession) {
	Vector chatRecord = 
	  (Vector) clientSession.getValue("chatRecord");
	Vector chatClient = 
	  (Vector) clientSession.getValue("chatClient");
	Vector chatCallPerson = 
	  (Vector) clientSession.getValue("chatCallPerson");
	chatRecord.addElement(cst2);
	String clientState = (String) clientSession.getValue("state");
	if ( clientState.equals("**CPersonTerminate**") ||
	     clientState.equals("**ClientTerminate**") ) {
	  session.putValue("state", "available");
	  // wait for window to close
	  KChatCPersonInputH.call(res);
	  return;
	}
	if ( cpersonString.equals("**CPersonTerminate**") )
	  clientSession.putValue("state", cpersonString);
	else {
	  chatClient.addElement(cst2);
	  chatCallPerson.addElement(cst2);
	}
      }
    } catch(Exception ex) {}
    // get more input
    KChatCPersonInputH.call(res);

  }
}



