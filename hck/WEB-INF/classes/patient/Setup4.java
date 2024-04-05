// (C) OntoOO Inc 2011 April
package patient;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import misc.HCError;
import misc.SessionExpired;
import misc.DB;
import htmls.Angel;
import com.DV;

public class Setup4 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException

    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    SessionExpired.call(res,
				DV.Setup);
	    return;
	}
	String selectedDrugs = req.getParameter("selectedDrugs"); // used drugs
	String selectedDrugsA = req.getParameter("selectedDrugsA"); // drugs causing allergy
	String selectedDiseases = req.getParameter("selectedDiseases"); // father diseases 
	String selectedDiseasesM = req.getParameter("selectedDiseasesM"); // mother diseases 
	String selectedDiseasesS = req.getParameter("selectedDiseasesS"); // sibling diseases 

	DB props = (DB) session.getValue("theDB");
	/*
	System.out.println("Setup4 \n" +
			   "selectedDrugs " + selectedDrugs + "\n" +
			   "selectedDrugsA " + selectedDrugsA + "\n" +
			   "selectedDiseases " + selectedDiseases + "\n" +
			   "selectedDiseasesM " + selectedDiseasesM + "\n" +
			   "selectedDiseasesS " + selectedDiseasesS);
	*/

	boolean changed = false;
	if ( null != selectedDrugs && !selectedDrugs.equals("") ) {
	    selectedDrugs = selectedDrugs.substring(1); // eliminate first ','
	    props.putProperty("drugs_used", selectedDrugs);
	    changed = true;
	}
	if ( null != selectedDrugsA && !selectedDrugsA.equals("") ) {
	    selectedDrugsA = selectedDrugsA.substring(1); // eliminate first ','
	    props.putProperty("drugs_causing_allergy", selectedDrugsA);
	    changed = true;
	}
	if ( null != selectedDiseases && !selectedDiseases.equals("") ) {
	    selectedDiseases = selectedDiseases.substring(1); // eliminate first ','
	    props.putProperty("diseases_of_father", selectedDiseases);
	    changed = true;
	}
	if ( null != selectedDiseasesM && !selectedDiseasesM.equals("") ) {
	    selectedDiseasesM = selectedDiseasesM.substring(1); // eliminate first ','
	    props.putProperty("diseases_of_mother", selectedDiseasesM);
	    changed = true;
	}
	if ( null != selectedDiseasesS && !selectedDiseasesS.equals("") ) {
	    selectedDiseasesS = selectedDiseasesS.substring(1); // eliminate first ','
	    props.putProperty("diseases_of_sibling", selectedDiseasesS);
	    changed = true;
	}
	if ( changed ) {
	    try {
		props.save("Setup4");
	    } catch (IOException ex) {
		HCError.call(res,
			     "Can't save this info, exception: " + ex.getMessage() +
			     "<br>Use the back arrow to return to the previous page.");
		return;
	    }
	}
   
	String logName = (String) session.getValue("logName");
	String password = props.getProperty("password");
	session.invalidate();
	Angel.call(res, logName, password);
	
    } // end doPost
}
