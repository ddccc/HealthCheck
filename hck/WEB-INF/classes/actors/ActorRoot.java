// Copyright OntoOO Inc, 2004 Oct
package actors;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import misc.SessionExpired;
import com.DV;

public class ActorRoot extends HttpServlet {
    static final private String refreshInterval = "5"; // seconds

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    SessionExpired.call(res,
				DV.ActorRoot);
	    return;
	}
	call(res, session);
    }

    static public void call(HttpServletResponse res,
			    HttpSession session) throws IOException {
	Actor actor = (Actor) session.getValue("actor");
	String trace = actor.getTrace();
	boolean stopped = actor.stopped();
	if ( !stopped) 
	    res.setHeader("Refresh", refreshInterval);
	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<HTML>");
	out.println("<HEAD><TITLE>ActorRoot</TITLE></HEAD>");
	out.println("<BODY BGCOLOR=bbbbbb>");
	//	out.println(DVM.htmlLogoutSU("SURoot"));
	out.println(trace);
	out.println("</BODY>");
	out.println("</HTML>");
    }

}




