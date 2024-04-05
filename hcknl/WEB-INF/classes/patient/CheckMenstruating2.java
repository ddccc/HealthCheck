// (C) OntoOO Inc 2002 May
package patient;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import com.DV;
import com.D;
import com.L;
import misc.DB;
import misc.HCError;
import misc.SessionExpired;
import htmls.AngelRoot;
import htmls.AdviceMenstruating;

public class CheckMenstruating2 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException

    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    SessionExpired.call(res,
				DV.CheckMenstruating2);
	    return;
	}
	DB props = (DB) session.getValue("theDB");

	String statusCondition = req.getParameter("statusCondition");

	// store in DB 
	props.putProperty("statusCondition", statusCondition);

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
	  Date now = new Date();
	  Calendar cal = Calendar.getInstance();
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
			  "<br>Fix the last menstruation date or call 911 ..." +
			  "<br>Use the back arrow to return to the previous page.");
	      return;
	  }
	  props.putProperty("pregnantDate", "" + yeari + "-" + month + "-" + day);
	  props.putProperty("pregnantYear", "" + yeari);
	  props.putProperty("pregnantMonthNum", monthNum);
	  props.putProperty("pregnantDay", day);
	}

	if ( !statusCondition.equals("menstruating") ) {
	  try { 
	    props.save("CheckMenstruating2");
	  } catch (IOException ex) {
	      HCError.call(res,
			  "Can't save this info, exception: " + ex.getMessage() +
			  "<br>Use the back arrow to return to the previous page.");
	      return;
	  }
	  // Save this stuff and redirect to AngelRoot ...
	  session.setMaxInactiveInterval(DV.maxInactiveInterval); // Jrun in millisec ....
	  AngelRoot.call(res);
	  return;
	}

	Integer ageInt = (Integer) session.getValue("ageInt");
	int age = ageInt.intValue();
	if ( age < 52 ) {
	  // Save this stuff and redirect to AngelRoot ...
	  session.setMaxInactiveInterval(DV.maxInactiveInterval); // Jrun in millisec ....
	  AngelRoot.call(res);
	  return;
	}

	AdviceMenstruating.call(res);


    } // end doGet
}

