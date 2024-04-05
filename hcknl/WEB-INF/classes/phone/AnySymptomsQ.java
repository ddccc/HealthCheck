// Copyright OntoOO Inc, 2006 May
package phone;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

// import com.LR;
// import com.Common;
// import com.D;
// import misc.DB;
// import concepts.Location;
// import concepts.LocationSet;
// import concepts.PartOfLocation;
// import patient.DiagStart;
import misc.DiagStackEntry;
import com.L;

public class AnySymptomsQ extends HttpServlet {


    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {	
	    PhoneError.call(res, "bevocal", 
			    //"Your session expired while in Any Symptoms Q."
			    L.AnySymptomsQ1
			    );
	    return;
	}

	call(req, res, session);
    } 

    static public void call(HttpServletRequest req, HttpServletResponse res, HttpSession session)
	throws IOException {

	Vector diagStack = (Vector) session.getValue("diagStack");
	DiagStackEntry dse = (DiagStackEntry) diagStack.elementAt(0);

	Vector newInSymptoms = new Vector();
	Vector newAllSymptoms = dse.getNewAllSymptomsVec();
	int lng = newAllSymptoms.size();
	String symptomName;
	String value;
	for (int i = 0; i < lng; i++) {
	    symptomName = (String) newAllSymptoms.elementAt(i);
	    value = req.getParameter(symptomName);
	    if ( value != null && value.equals("true") ) newInSymptoms.addElement(symptomName);
	}

	if ( 0 == newInSymptoms.size() ) 
	    AskSymptom.call(res, session);
	else
	    AskMoreSymptoms.call(req, res, session, null);

    }
}



