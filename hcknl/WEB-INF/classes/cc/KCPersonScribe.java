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

public class KCPersonScribe extends HttpServlet {
  static final private String refreshInterval = "2"; // seconds

  public void doGet (HttpServletRequest req, 
		     HttpServletResponse res)
       throws ServletException, IOException
  {
    HttpSession session = req.getSession(false);
    if ( null == session ) {
	SessionExpired.call(res,
			    DV.KCPersonScribe);
	return;
    }

    String clientId = (String) session.getValue("invitedClient");
    String clientState = "**ClientTerminate**";
    Vector chatCallPerson;
    try { // client can disapppear at all times
      HttpSession clientSession = KClient.getKClient(clientId);
      synchronized (clientSession) {
	clientState = (String) clientSession.getValue("state");
	chatCallPerson = 
	  (Vector) clientSession.getValue("chatCallPerson");
	clientSession.putValue("chatCallPerson", new Vector());
      }
    } catch (Exception ex) { chatCallPerson = new Vector(); }
    res.setContentType("text/html");
    res.setHeader("Refresh", refreshInterval);
    ServletOutputStream out = res.getOutputStream();
    out.println(
	 //	 "<HTML><BODY BGCOLOR=lightblue>" +
	 "<script language=\"JavaScript\">"
	 );
    if ( clientState.equals("**ClientTerminate**") ||
	 clientState.equals("**CPersonTerminate**") ) 
      out.println("parent.close();");
    else {
      String chatItem;
      for (int i=0 ; i<chatCallPerson.size(); i++) {
	chatItem = (String) chatCallPerson.elementAt(i);
	out.println("parent.canvas2.document.writeln('" + chatItem + "');" );
      }
    }
    out.println("</script>");
    //    out.println("</BODY></HTML>");
  }
}



