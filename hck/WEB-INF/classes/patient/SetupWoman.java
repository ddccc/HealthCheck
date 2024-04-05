// (C) OntoOO Inc 2002 May
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
import htmls.Start3;

public class SetupWoman extends HttpServlet {

    public void doPost (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException

    {
	DB props = null;
	String userName = null;
	
	HttpSession session = req.getSession(false);
	if ( null != session ) 
	    props = (DB) session.getValue("theDB");	    
	else {
	    userName = req.getParameter("userName");
	    if ( null != userName ) {
		String prefix2 = D.theUsersDir;
		try {
		    props = new DB(prefix2 + userName);
		} catch (IOException ignore) {}
	    }
	}
	if ( null == props ) { // Something wrong, jump out
	    SessionExpired.call(res,
				DV.SetupWoman);
	    return;
	}


	String statusCondition = req.getParameter("statusCondition");
	String numLifeBirths = req.getParameter("numLifeBirths");
	String numMiscarriages = req.getParameter("numMiscarriages");
	String numStillBirths = req.getParameter("numStillBirths");

	// store in DB 
	props.putProperty("statusCondition", statusCondition);
	props.putProperty("numLifeBirths", numLifeBirths);
	props.putProperty("numMiscarriages", numMiscarriages);
	props.putProperty("numStillBirths", numStillBirths);
	if ( statusCondition.equals("pregnant") ) {
	  String month = req.getParameter("month");
	  String day = req.getParameter("day");
	  String monthNum = month.substring(3);
	  month = month.substring(0,3);
	  int yeari;
	  int monthi = 0;
	  int dayi = 1;
	  try { 
	    monthi = Integer.parseInt(monthNum);
	    dayi = Integer.parseInt(day);
	  } catch (Exception ignore) {}
	  Calendar cal = Calendar.getInstance();
	  Date now = new Date();
	  cal.setTime(now);
	  int yearNow = cal.get(Calendar.YEAR);
	  int dayOfYearNow = cal.get(Calendar.DAY_OF_YEAR);
	  cal.set(Calendar.YEAR, yearNow);
	  cal.set(Calendar.MONTH, monthi);
	  cal.set(Calendar.DAY_OF_MONTH, dayi);
	  Date lastMenstruation = cal.getTime();
	  int dayOfYearLastMenstruation;
	  int pregnancyDuration;
	  if ( now.before(lastMenstruation) ) {
	    yeari = yearNow -1;
	    cal.set(Calendar.YEAR, yeari);
	    dayOfYearLastMenstruation = cal.get(Calendar.DAY_OF_YEAR);
	    pregnancyDuration = 365 - dayOfYearLastMenstruation + dayOfYearNow;
	  }
	  else {
	    yeari = yearNow;
	    dayOfYearLastMenstruation = cal.get(Calendar.DAY_OF_YEAR);
	    pregnancyDuration = dayOfYearNow - dayOfYearLastMenstruation;
	  }
	  if ( 300 < pregnancyDuration ) {
	      HCError.call(res,
			  "Pregnancy duration longer than 300 days !!" +
			  "<br />Fix the last menstruation date or call 911 ..." +
			  "<br />Use the back arrow to return to the previous page.");
	      return;
	  }
	  props.putProperty("pregnantDate", "" + yeari + "-" + month + "-" + day);
	  props.putProperty("pregnantYear", "" + yeari);
	  props.putProperty("pregnantMonthNum", monthNum);
	  props.putProperty("pregnantDay", day);
	}
	
	try { 
	  props.save("SetupWoman");
	} catch (IOException ex) {
	    HCError.call(res,
			"Can't save this info, exception: " + ex.getMessage() +
			"<br>Use the back arrow to return to the previous page.");
	    return;
	}

	// Check whether we do a quick setup
	if ( null != userName ) {
	    AngelLogin.call(req, res, userName, userName);
	    return;
	}

	// proceed with the next set of questions ...
	Start3.call(res);

    } // end doPost
}

