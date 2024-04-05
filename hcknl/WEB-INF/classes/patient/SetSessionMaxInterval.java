// (C) OntoOO Inc 2002 June
package patient;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.DV;
import com.D;
import misc.DB;
import misc.SessionExpired;
import htmls.AngelRoot;

// NOT used at this time ...
public class SetSessionMaxInterval extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException

    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    SessionExpired.call(res,
			   DV.SetSessionMaxInterval);
	    return;
	}

	session.setMaxInactiveInterval(DV.maxInactiveInterval); // Jrun in millisec ....
	AngelRoot.call(res);
    } // end doGet
}

