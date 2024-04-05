// (C) OntoOO Inc 2002
package cc;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.DV;
import com.D;
import misc.SessionExpired;

public class KChatResponse extends HttpServlet {

  public void doGet (HttpServletRequest req, 
		     HttpServletResponse res)
       throws ServletException, IOException
  {
    String invitationReply = req.getParameter("invitationReply");
    HttpSession session = req.getSession(false);
    if ( null == session ) {
	SessionExpired.call(res,
			    DV.KChatResponse);
	return;
    }
    res.setContentType("text/html");
    ServletOutputStream out = res.getOutputStream();
    if ( invitationReply.equals("yes") ) {
      session.putValue("state", "chatting");
      out.println(
	  "<html><body bgcolor=\"yellow\">" +
	  "<script language=\"JavaScript\">" +
	  "win3 = open(\"" + D.kClientChatHtml + "\"," +
	  "\"kClientChat\"," +
	  "\"resizable=1,scrollbars=1,height=500,width=750\"" +
	  ");" +
	  // "alert('testing in  KChatResponse');" +
	  "window.close();" +
	  "</script>" +
	  "</body></html>");
      return;
    }

    if ( invitationReply.equals("timeout") )
      session.putValue("state", "timeout");
    else 
    if ( invitationReply.equals("no") )
      session.putValue("state", "invitationRejected");
    else
      session.putValue("state", "**ErrorResponse"); // Cant happen

    // close the invitation pop up, if not closed already
    out.println(
	"<html><body bgcolor=\"red\">" +
	"<script language=\"JavaScript\">" +
	"window.close();" +
	"</script>" +
	"</body>" +
	"</html>"
	);

  }
}



