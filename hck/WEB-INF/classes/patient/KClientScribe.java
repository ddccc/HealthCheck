// (C) OntoOO Inc 2002
package patient;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.DV;
import com.D;
import misc.SessionExpired;

public class KClientScribe extends HttpServlet {
  static final private String refreshInterval = "2"; // seconds

  public void doGet (HttpServletRequest req, 
		     HttpServletResponse res)
       throws ServletException, IOException
  {
    HttpSession session = req.getSession(false);
    if ( null == session ) {
	SessionExpired.call(res,
			    DV.KClientScribe);
	return;
    }
    String state = "";
    Vector chatClient;
    synchronized (session) {
      state = (String) session.getValue("state");
      chatClient = (Vector) session.getValue("chatClient");
      session.putValue("chatClient", new Vector());
    }
    res.setHeader("Refresh", refreshInterval);
    res.setContentType("text/html");
    ServletOutputStream out = res.getOutputStream();
    out.println(
	 // "<HTML><BODY BGCOLOR=lightblue>" +
	 "<script language=\"JavaScript\">"
	 );
    if ( state.equals("**ClientTerminate**") ||
	 state.equals("**CPersonTerminate**") ) 
      out.println("parent.close();");
    else {
      String chatItem;
      for (int i = 0 ; i < chatClient.size(); i++) {
	chatItem = (String) chatClient.elementAt(i);
	out.println("parent.canvas1.document.writeln('" + chatItem + "');" );
      }
    }
    out.println("</script>");
    // out.println("<br>chatClient vector: " + chatClient.toString());
    // out.println("</BODY></HTML>");
  }
}



