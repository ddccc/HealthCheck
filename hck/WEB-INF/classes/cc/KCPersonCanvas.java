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

public class KCPersonCanvas extends HttpServlet {

  public void doGet (HttpServletRequest req, 
		     HttpServletResponse res)
       throws ServletException, IOException
  {
    HttpSession session = req.getSession(false);
    if ( null == session ) {
	SessionExpired.call(res,
			    DV.KCPersonCanvas);
	return;
    }
    String clientId = (String) session.getValue("invitedClient");
    res.setContentType("text/html");
    ServletOutputStream out = res.getOutputStream();
    out.println("<html><body bgcolor=\"yellow\">");
    out.println("<form action=\"" + D.servletKCPersonCanvas + "\">" +
		"<input type=\"submit\" value=\"Refresh\">" +
		"</form><br />");
    try {
      HttpSession clientSession = KClient.getKClient(clientId);
      Vector chatRecord = (Vector) clientSession.getValue("chatRecord");
      String chatItem;
      for (int i=0 ; i<chatRecord.size(); i++) {
	chatItem = (String) chatRecord.elementAt(i);
	out.println(chatItem);
      }
    } catch (Exception ignore) { // defensive manouvres ...
      session.putValue("kstate", "available");
      out.println("<script language=\"JavaScript\">" +
		  "parent.close();" +
		  "</script>");
    }
    out.println("</body></html>");

  }
}



