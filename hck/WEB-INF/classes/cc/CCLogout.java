// (C) OntoOO Inc 2002 May
package cc;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import com.D;
import htmls.CCLoginH;

public class CCLogout extends HttpServlet {
    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      HttpSession session = req.getSession(false);
      if ( null != session ) {
	String state = (String) session.getValue("kstate");
	if ( state.equals("chatting") ) { //  can't logout, thus ignore
	    KCallPerson.call(res, session);
	    return;
	}
	session.invalidate();
      }

      CCLoginH.call(res);

    } // end doGet

} // end CCLogout
