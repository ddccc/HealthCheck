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
import htmls.AngelRoot;


public class CheckPregnancy2 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException

    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    SessionExpired.call(res,
				DV.CheckPregnancy2);
	    return;
	}
	DB props = (DB) session.getValue("theDB");

	String statusCondition = req.getParameter("statusCondition");
	
	if ( statusCondition.equals("pregnant") ) {
	  // Save this stuff and redirect to AngelRoot ...
	  session.setMaxInactiveInterval(DV.maxInactiveInterval); // Jrun in millisec ....
	  AngelRoot.call(res);
	  return;
	}

	boolean pregnant = 
	    statusCondition.equals("lifeBirthPregnant") ||
	    statusCondition.equals("stillBirthPregnant") ||
	    statusCondition.equals("miscarriagePregnant");

	// store in DB 
	props.putProperty("statusCondition", 
			  ( pregnant ? "pregnant" : "menstruating") );
	// should save this data somewhere ...
	props.removeProperty("pregnantDate");
	props.removeProperty("pregnantMonthNum");
	props.removeProperty("pregnantDay");
	props.removeProperty("pregnantYear");
	int x = 0;
	if ( statusCondition.equals("lifeBirthMenstruating") ||
	     statusCondition.equals("lifeBirthPregnant") ) {
	  String numLifeBirths = props.getProperty("numLifeBirths");
	  try { 
	    x = Integer.parseInt(numLifeBirths);
	  } catch (NumberFormatException ignore) {}
	  x++;
	  props.putProperty("numLifeBirths", "" + x);
	}
	else
	if ( statusCondition.equals("miscarriageMenstruating") ||
	     statusCondition.equals("miscarriagePregnant") ) {
	  String numMiscarriages = props.getProperty("numMiscarriages");
	  try { 
	    x = Integer.parseInt(numMiscarriages);
	  } catch (NumberFormatException ignore) {}
	  x++;
	  props.putProperty("numMiscarriages", "" + x);
	}
	else
	if ( statusCondition.equals("stillBirthMenstruating") ||
	     statusCondition.equals("stillBirthPregnant") ) {
	  String numStillBirths = props.getProperty("numStillBirths");
	  try { 
	    x = Integer.parseInt(numStillBirths);
	  } catch (NumberFormatException ignore) {}
	  x++;
	  props.putProperty("numStillBirths", "" + x);
	}
	// else an error which we ignore for now

	if ( pregnant ) {
	  String month = req.getParameter("month");
	  String day = req.getParameter("day");
	  String monthNum = month.substring(3);
	  month = month.substring(0,3);
	  int monthi = 0;
	  int dayi = 1;
	  try { 
	    monthi = Integer.parseInt(monthNum);
	    dayi = Integer.parseInt(day);
	  } catch (Exception ignore) {}
	  int yeari = CheckPremenstruating2.year(monthi, dayi);
	  int pregnancyDuration = CheckPremenstruating2.duration(yeari, monthi, dayi);

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
	try { 
	  props.save("CheckPregnancy2");
	} catch (IOException ex) {
	    HCError.call(res,
			"Can't save this info, exception: " + ex.getMessage() +
			"<br>Use the back arrow to return to the previous page.");
	    return;
	}
	// Save this stuff and redirect to AngelRoot ...
	session.setMaxInactiveInterval(DV.maxInactiveInterval); // Jrun in millisec ....
	AngelRoot.call(res);

    } // end doGet
}















