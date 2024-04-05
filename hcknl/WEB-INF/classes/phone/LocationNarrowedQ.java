// Copyright OntoOO Inc, 2004 Mar
package phone;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.LR;
// import com.Common;
// import com.D;
// import misc.DB;
// import concepts.Location;
// import concepts.LocationSet;
// import concepts.PartOfLocation;
// import patient.DiagStart;
import misc.DiagStackEntry;
import com.L;

public class LocationNarrowedQ extends HttpServlet {


    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {	
	    PhoneError.call(res, "bevocal", 
			    //"Your session expired while in Location Narrowed Q."
			    L.LocationNarrowedQ1
			    );
	    return;
	}

	call(res, session);
    } 

    static public void call(HttpServletResponse res, HttpSession session)
	throws IOException {

	Vector diagStack = (Vector) session.getValue("diagStack");
	DiagStackEntry dse = (DiagStackEntry) diagStack.elementAt(0);
	String bodyPart = dse.getBodyPart();

	if ( bodyPart.equals(LR.bodySt) ) {
	    AskSymptom.call(res, session);
	    return;
	}

	AskLocDrivenSymptoms.call(res, session);

    }
}



