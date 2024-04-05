// (C) OntoOO Inc 2002 May
package phone;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.DV;
import com.D;
import com.L;
import misc.DB;
import patient.CheckPremenstruating2;


public class PSetPregnant extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException

    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    PhoneError.call(res, "bevocal", 
			    // "Your session expired while in Phone Set Pregnant."
			    L.PSetPregnant1
			    );
	    return;
	}
	DB props = (DB) session.getValue("theDB");

	String statusCondition = req.getParameter("answer");
	if ( null != statusCondition ) { // as in PCheckPregnancy2 
	    PCheckPregnancy2.registerPregnancyResult(props, statusCondition);
	}

	// store in DB 
	props.putProperty("statusCondition", "pregnant");

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

	  // save, even if it does not make sense
	  props.putProperty("pregnantDate", "" + yeari + "-" + month + "-" + day);
	  props.putProperty("pregnantYear", "" + yeari);
	  props.putProperty("pregnantMonthNum", monthNum);
	  props.putProperty("pregnantDay", day);
	  if ( 300 < pregnancyDuration ) {
	      String host = (String) session.getValue("host");
	      String xml = 
"<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +

	    ( host.equals("bevocal") ?
	      L.vxml1
	      :
	      L.vxml2 ) +

" <property name=\"universals\" value=\"all\" /> \n" +

" <help>" +
  // I'm sorry. There's no help available here.
  L.noHelp +
"</help> \n" +
" <noinput>" +
  // I'm sorry. I didn't hear anything. \n" +
  L.silence +
"   <reprompt/> \n" +
" </noinput> \n" +
" <nomatch>" +
  // I didn't get that. \n" +
  L.nomatch +
"   <reprompt/> \n" +
" </nomatch> \n" +

" <form id=\"askProceed\"> \n" +
"    <field name=\"answer\" type=\"boolean\"> \n" +
"     <help>  <reprompt/>  </help> \n" +
"     <prompt> \n" +
		  /*
"       It looks like that your pregnancy is over due. \n " +
"       You should contact your physician or go to a hospital or perhaps call nine one one. \n" +
"       Do you still want to proceed with this call? \n" +
		  */
        L.PSetPregnant2 +
"     </prompt> \n" +
"    <filled> \n" +
"       <if cond=\"(answer == true) \"> \n" +
"           <submit next=\"" + D.servletAskLocation + "\" \n" +
"                   method=\"get\"  fetchtimeout=\"60s\"/> \n" +
"           <else/> \n" +
"           <submit next=\"" + D.servletPhoneLogout + "\" \n" +
"                   method=\"get\"  fetchtimeout=\"60s\"/> \n" +
"       </if> \n" +
"    </filled> \n" +
"   </field> \n" +
" </form> \n" +
"</vxml>";
	      res.setContentType("application/voicexml+xml");
	      ServletOutputStream out = res.getOutputStream();
	      out.println(xml);
	  }

	  AskLocation.call(res, session);
    }
}




