// (C) OntoOO Inc 2002
package patient;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.DV;
import com.D;
import misc.SessionExpired;

// *********************** DEAD CODE *********************************
// *********************** DEAD CODE *********************************
// *********************** DEAD CODE *********************************
// *********************** DEAD CODE *********************************
// *********************** DEAD CODE *********************************
// *********************** DEAD CODE *********************************
// *********************** DEAD CODE *********************************

public class KClientCanvas extends HttpServlet {

  public void doGet (HttpServletRequest req, 
		     HttpServletResponse res)
       throws ServletException, IOException
  {
    HttpSession session = req.getSession(false);
    if ( null == session ) {
	SessionExpired.call(res,
			    DV.KClientCanvas);
	return;
    }
    Vector chatRecord = (Vector) session.getValue("chatRecord");
    res.setContentType("text/html");
    ServletOutputStream out = res.getOutputStream();
    out.println("<html><body bgcolor=\"yellow\">");
    out.println("<form action=\"" + D.servletKClientCanvas + "\">" +
		"<input type=\"submit\" value=\"Refresh\" />" +
		"</form><br />");
    String chatItem;
    for (int i=0 ; i<chatRecord.size(); i++) {
	chatItem = (String) chatRecord.elementAt(i);
	out.println(chatItem);
      }
    out.println("</body></html>");
  }
}



