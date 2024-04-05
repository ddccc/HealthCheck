// Copyright OntoOO Inc, 2004 Jan
package phone;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.D;
import com.L;
import com.DVM;
import misc.DB;
import concepts.Location;
import concepts.LocationSet;
import concepts.PartOfLocation;
import patient.DiagStart;
import misc.DiagStackEntry;

public class RefinePartQ extends HttpServlet {


    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {	
	    PhoneError.call(res, "bevocal", 
			    //"Your session expired while in Refine Part Q."
			    L.RefinePartQ1
			    );
	    return;
	}

	String bodyPart = req.getParameter("answer2");
	Vector diagStack = (Vector) session.getValue("diagStack");
	DiagStackEntry dse = (DiagStackEntry) diagStack.elementAt(0);
	dse.setBodyPart(bodyPart);


	// investigate whether there are subparts
        Location body = Common.getLocation(bodyPart);
	Vector parts = body.getParts();
	DB props = (DB) session.getValue("theDB");
	String gender = props.getProperty("gender");
	parts = DiagStart.filterParts(parts, gender);
	if ( 0 < parts.size() ) { 
	    AskPart.call(res, session);
	    return;
	}

	// investigate whether body is a set:
	// String className = body.getClass().getName();
	// if ( !DVM.isSetClass(className) ) {
	if ( !(body instanceof LocationSet) ) {
	    LocationNarrowedQ.call(res, session);
	    return;
	}
	LocationSet locSet = (LocationSet) body;
	
	// investigate whether there are subsets:
	Vector subsets = locSet.getSubsets();
	subsets = DiagStart.filterParts(subsets, gender);
	if ( 0 < subsets.size() ) {
	    AskSubsets.call(res, session);
	    return;
	}

	// investigate whether there are members:
	Vector members = locSet.getMembers();
	members = DiagStart.filterParts(members, gender);
	if ( 0 < members.size() ) {
	    AskMembers.call(res, session);
	    return;
	}

	LocationNarrowedQ.call(res, session);
    }
}



