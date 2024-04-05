// (C) OntoOO Inc 2004 Oct
package actors;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import misc.DB;
import misc.HCError;

public class ActorLogin extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      // res.setContentType("text/html");
	
	String logName = req.getParameter("logName");

	if ((logName == null) || 
	    logName.equals("") 
		) {
	    HCError.call(res,
			 "Log name required!<br>" +
			 "Use the back arrow to return to the previous page.");

	    return;
	}
	String fileName = logName + "Actor";
	Actor actor = Actor.fetchActor(fileName);
	if (null == actor) {
	    HCError.call(res,
			 "Cannot find actor! " + fileName + "<br>" +
			 "Use the back arrow to return to the previous page.");

	    return;
	}

	// Save this stuff and redirect to  ...
	HttpSession session = req.getSession(true);
	session.putValue("actor", actor);
	session.putValue("logName", logName);
	session.putValue("fileName", fileName);
	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<HTML>");
	out.println("<HEAD><TITLE>ActorRoot</TITLE></HEAD>");
	out.println("<BODY BGCOLOR=bbbbbb>");
	out.println("<A HREF='" + D.servletActorRoot + "'>ActorRoot</A>");
	out.println("</BODY>");
	out.println("</HTML>");

	// ActorRoot.call(res, session);
    }
}




