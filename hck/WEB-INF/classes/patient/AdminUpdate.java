// (C) OntoOO Inc 2002 Jul
package patient;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.DV;
import com.D;
import misc.DB;
import misc.HCError;
import misc.SessionExpired;
import htmls.AngelRoot;

public class AdminUpdate extends HttpServlet {

    public void doPost (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException

    {   
	String streetAddress2 = req.getParameter("streetAddress");
	String city2 = req.getParameter("city");
	String zipCode2 = req.getParameter("zipCode");
	String homePhone2 = req.getParameter("homePhone");
	String ssNumber2 = req.getParameter("ssNumber");


	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    SessionExpired.call(res,
				DV.AdminUpdate);
	    return;
	}
	DB props = (DB) session.getValue("theDB");
	// String aDate = Common.normalizedDate();
	// example of using aDate:
	// if ( !ssNumber2.equals(props.getProperty("ssNumber")) )
	//  props.pushProperty("ssNumber", ssNumber2, aDate);

	if ( !streetAddress2.equals(props.getProperty("streetAddress")) )
	  props.putProperty("streetAddress", streetAddress2);
	if ( !city2.equals(props.getProperty("city")) )
	  props.putProperty("city", city2);
	if ( !zipCode2.equals(props.getProperty("zipCode")) )
	  props.putProperty("zipCode", zipCode2);
	if ( !homePhone2.equals(props.getProperty("homePhone")) )
	  props.putProperty("homePhone", homePhone2);
	if ( !ssNumber2.equals(props.getProperty("ssNumber")) )
	  props.putProperty("ssNumber", ssNumber2);

	try { 
	  props.save("AdminUpdate");
	} catch (IOException ex) {
	    HCError.call(res,
			"Can't save this info, exception: " + ex.getMessage() +
			"<br>Use the back arrow to return to the previous page.",
			 "");
	    return;
	}

	AngelRoot.call(res);

    }
}
