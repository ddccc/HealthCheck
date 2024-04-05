// (C) OntoOO Inc 2002 May
package phone;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.DV;
import com.D;
import com.L;
import misc.DB;


public class PCheckMenopause2 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException

    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    PhoneError.call(res, "bevocal", 
			    // "Your session expired while in Phone Check Status."
			    L.PCheckStatus0
			    );
	    return;
	}
	DB props = (DB) session.getValue("theDB");

	String answer = req.getParameter("answer");

	props.putProperty("statusCondition", answer);

	try { 
	  props.save("PCheckMenopause2");
	  // send email in case of failure?
	} catch (IOException ignore) {}

	AskLocation.call(res, session);

    } // end doGet
}

