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


public class PCheckPremenstruating2 extends HttpServlet {

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

	String statusCondition = req.getParameter("answer");
	
	// store in DB 
	props.putProperty("statusCondition", statusCondition);

	if ( !statusCondition.equals("premenstruating") ) {
	  try { 
	    props.save("CheckPremenstruating2");
	    // send an email in case of a failure??
	  } catch (IOException ignore) {}

	  // Save this stuff and redirect to AskLocation
	  AskLocation.call(res, session);
	  return;
	}

	Integer ageInt = (Integer) session.getValue("ageInt");
	int age = ageInt.intValue();
	if ( age < 16 ) {
	  // Save this stuff and redirect to AngelRoot ...
	  AskLocation.call(res, session);
	  return;
	}

	// AdvicePremenstruating.call(res);
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
"       Since a first menstruation appears to be late, \n " +
"       please make an appointment with your physician.  \n"  +
"       Do you still want to proceed with this call? \n" +
	    */
	    L.PCheckPremenstruating2S +
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

    } // end doGet
}








