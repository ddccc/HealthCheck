// (C) OntoOO Inc 2000
package patient;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import com.LR;
import com.L;
import com.DV;
import com.D;
import misc.DB;
import misc.HCError;
import misc.SessionExpired;
import htmls.Start2;

public class Setup extends HttpServlet {

    public void doPost (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException

    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    SessionExpired.call(res,
				DV.Setup);
	    return;
	}
	String logName2 = (String) session.getValue("logName");
	DB props = (DB) session.getValue("theDB");

	String password2 = props.getProperty("password");

	String logName = req.getParameter("logName");
	String password = req.getParameter("password");

	if ( !logName.equals(logName2) || !password.equals(password2) ) {
	    HCError.call(res,
			"User name or password erroneous.<br>" +
			"Use the back arrow to return to the previous page.");
	    return;
	}

	String firstName = req.getParameter("firstName");
	String lastName = req.getParameter("lastName");
	String streetAddress = req.getParameter("streetAddress");
	String city = req.getParameter("city");
	String state = req.getParameter("state");
	String zipCode = req.getParameter("zipCode");
	String homePhone = req.getParameter("homePhone");
	String homeLineAvailable = req.getParameter("homeLineAvailable");
	String ssNumber = req.getParameter("ssNumber");
	String providerId = req.getParameter("providerId");
	String gender = req.getParameter("gender");
	String year = req.getParameter("year");
	String month = req.getParameter("month");
	String day = req.getParameter("day");
	String race = req.getParameter("race");
	String sexPartner = req.getParameter("sexPartner");
	String height = req.getParameter("height");
	String weight = req.getParameter("weight");
	String bloodGroup = req.getParameter("bloodGroup");

	String monthNum = month.substring(3);
	month = month.substring(0,3);

	String anonymous = props.getProperty("anonymous");
	// store in DB 
	if ( null == anonymous || !anonymous.equals("1") ) {
	  props.putProperty("firstName",firstName);
	  props.putProperty("lastName",lastName);
	  props.putProperty("userName",firstName + " " + lastName);
	  props.putProperty("streetAddress",streetAddress);
	  props.putProperty("city",city);
	  props.putProperty("state",state);
	  props.putProperty("zipCode",zipCode);
	  props.putProperty("homePhone",homePhone);
	  props.putProperty("homeLineAvailable",homeLineAvailable);
	  props.putProperty("ssNumber",ssNumber); 
	  props.putProperty("providerId",providerId);
	}
	/*
	if ( L.language.equals("NL") ) {
	    if ( gender.equals("male") ) gender = LR.male; else
	    if ( gender.equals("female") ) gender = LR.female;
	}
	*/
	props.putProperty("gender",gender); 
	props.putProperty("year",year); 
	props.putProperty("month",month);
	props.putProperty("monthNum",monthNum); // for age calculation
	props.putProperty("day",day); 
	props.putProperty("dob",year+"-"+month+"-"+day); 
	props.putProperty("race",race); 
	props.putProperty("sexPartner",sexPartner);
	props.putProperty("height",height); 
	props.extendProperty("weight",weight); 
	props.putProperty("bloodGroup",bloodGroup); 

	try {
	  props.save("Setup");
	} catch (IOException ex) {
	    HCError.call(res,
       			"Can't save this info, exception: " + ex.getMessage() +
       			"<br>Use the back arrow to return to the previous page.");
	    return;
	}

	// proceed with the next set of questions ...
	Start2.call(res);
    }
}
