// (C) OntoOO Inc 2002
package patient;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.DV;
import com.D;
import misc.DB;
import misc.HCError;
import misc.SessionExpired;
import htmls.AngelRoot;

public class ProcessWeightValue extends HttpServlet {

    public void doPost (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
        String myWeightSt = req.getParameter("myWeight");
        String weightType = req.getParameter("weightType");

	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    SessionExpired.call(res,
				DV.ProcessWeightValue);
	    return;
	}
	DB props = (DB) session.getValue("theDB");
	try {
	  if (weightType.equals("targetWeight")) {
	    props.putProperty("targetWeight", myWeightSt);
	    AngelRoot.call(res);
	    return;
	  }
	  // System.out.println("trace: " + myWeightSt);
	  // ... so this is a "real" weight
	  props.extendProperty("weight", myWeightSt); 
	  props.save("ProcessWeightValue");
	} catch (IOException ex) {
	    HCError.call(res,
			"Can't store new value, exception: " + ex.getMessage() +
			"<br>Use the back arrow to return to the previous page(s)",
			 "");
	    return;
	}

	ShowWeightGraph.call(res, session);
    }
}



