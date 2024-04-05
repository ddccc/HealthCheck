// (C) OntoOO Inc 2002
package patient;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.DV;
import com.D;
import misc.SessionExpired;
import htmls.KChatClientInputH;

public class KChatClientInput extends HttpServlet {

  public void doGet (HttpServletRequest req, 
		     HttpServletResponse res)
       throws ServletException, IOException
  {
    String clientString = req.getParameter("clientString");
    String cst2 = "<b>Client: </b>" + clientString + "<br>";
    HttpSession session = req.getSession(false);
    if ( null == session ) {
	SessionExpired.call(res,
			    DV.KChatClientInput);
	return;
    }
    synchronized (session) {
      Vector chatRecord = (Vector) session.getValue("chatRecord");
      Vector chatClient = (Vector) session.getValue("chatClient");
      Vector chatCallPerson = 
	(Vector) session.getValue("chatCallPerson");
      chatRecord.addElement(cst2);
      String state = (String) session.getValue("state");
      if ( state.equals("**CPersonTerminate**") ||
	   state.equals("**ClientTerminate**") ) {
	KChatClientInputH.call(res); // wait for window to close
	return;
      }
      chatClient.addElement(cst2);
      chatCallPerson.addElement(cst2);
    }
    if ( clientString.equals("**ClientTerminate**") )
      session.putValue("state", clientString);
    KChatClientInputH.call(res); // get more input
  }
}


