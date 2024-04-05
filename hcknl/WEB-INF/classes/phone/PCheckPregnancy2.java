// (C) OntoOO Inc 2002 May
package phone;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.DV;
import com.L;
import misc.DB;


public class PCheckPregnancy2 extends HttpServlet {

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
	// store in DB 
	props.putProperty("statusCondition", answer);


	String statusCondition = req.getParameter("statusCondition");
	
	if ( null != statusCondition ) {
	    registerPregnancyResult(props, statusCondition);
	    /*
	    // should save this data somewhere ...
	    props.removeProperty("pregnantDate");
	    props.removeProperty("pregnantMonthNum");
	    props.removeProperty("pregnantDay");
	    props.removeProperty("pregnantYear");
	    int x = 0;
	    if ( statusCondition.equals("lifeBirth") ) {
		String numLifeBirths = props.getProperty("numLifeBirths");
		try { 
		    x = Integer.parseInt(numLifeBirths);
		} catch (NumberFormatException ignore) {}
		x++;
		props.putProperty("numLifeBirths", "" + x);
	    }
	    else
	    if ( statusCondition.equals("miscarriage") ) {
		String numMiscarriages = props.getProperty("numMiscarriages");
		try { 
		    x = Integer.parseInt(numMiscarriages);
		} catch (NumberFormatException ignore) {}
		x++;
		props.putProperty("numMiscarriages", "" + x);
	    }
	    else
	    if ( statusCondition.equals("stillBirth") ) {
		String numStillBirths = props.getProperty("numStillBirths");
		try { 
		    x = Integer.parseInt(numStillBirths);
		} catch (NumberFormatException ignore) {}
		x++;
		props.putProperty("numStillBirths", "" + x);
	    }
	    // else an error which we ignore for now
	    */
	}

	try { 
	  props.save("PCheckPregnancy2");
	  // send email in case of failure?
	} catch (IOException ignore) {}

	AskLocation.call(res, session);

    } // end doGet

    static public void registerPregnancyResult(DB props, String statusCondition) {
	    // should save this data somewhere ...
	    props.removeProperty("pregnantDate");
	    props.removeProperty("pregnantMonthNum");
	    props.removeProperty("pregnantDay");
	    props.removeProperty("pregnantYear");
	    int x = 0;
	    if ( statusCondition.equals("lifeBirth") ) {
		String numLifeBirths = props.getProperty("numLifeBirths");
		try { 
		    x = Integer.parseInt(numLifeBirths);
		} catch (NumberFormatException ignore) {}
		x++;
		props.putProperty("numLifeBirths", "" + x);
	    }
	    else
	    if ( statusCondition.equals("miscarriage") ) {
		String numMiscarriages = props.getProperty("numMiscarriages");
		try { 
		    x = Integer.parseInt(numMiscarriages);
		} catch (NumberFormatException ignore) {}
		x++;
		props.putProperty("numMiscarriages", "" + x);
	    }
	    else
	    if ( statusCondition.equals("stillBirth") ) {
		String numStillBirths = props.getProperty("numStillBirths");
		try { 
		    x = Integer.parseInt(numStillBirths);
		} catch (NumberFormatException ignore) {}
		x++;
		props.putProperty("numStillBirths", "" + x);
	    }
	    // else an irrelevant value, thus ignore
    }


}

