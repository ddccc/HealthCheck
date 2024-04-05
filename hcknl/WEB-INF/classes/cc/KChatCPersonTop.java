// (C) OntoOO Inc 2002
package cc;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.DV;
import com.D;
import misc.SessionExpired;

public class KChatCPersonTop extends HttpServlet {

  public void doGet (HttpServletRequest req, 
		     HttpServletResponse res)
       throws ServletException, IOException
  {
    HttpSession session = req.getSession(false);
    if ( null == session ) {
	SessionExpired.call(res,
			    DV.KChatCPersonTop);
	return;
    }

    call(res, session);
  }

    static public void call(HttpServletResponse res, HttpSession session)
	throws IOException {

	String invitedClient = (String) session.getValue("invitedClient");
	KDetails2.call(res, invitedClient, "no");
	
    }
}



