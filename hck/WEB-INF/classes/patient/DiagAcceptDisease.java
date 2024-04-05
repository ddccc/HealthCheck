// (C) OntoOO Inc 2005 Mar
package patient;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import misc.SessionExpired;
import misc.DB;
import com.DV;
import com.Common;
import com.L;
import com.D;
import com.DVM;
import htmls.AngelRoot;
import su.DiseaseRecord;



public class DiagAcceptDisease extends HttpServlet {
  private static final boolean LOGGING = DV.LOGGINGdiag1;

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      if ( LOGGING ) {
	System.out.println("*** DiagAcceptDisease: Enter");
      }
      HttpSession session = req.getSession(false);
      if ( null == session ) {
	  SessionExpired.call(res,
			      DV.DiagAcceptDisease);
	  return;
      }

      Hashtable unboundHashtable = 
           (Hashtable) session.getValue("unboundHashtable");

      String acceptedDisease = req.getParameter("dis");
      unboundHashtable.put("acceptedDisease", acceptedDisease);

      // add to logSessions(0)/ht/historyOfDiseases
      DiseaseRecord dr = new DiseaseRecord(acceptedDisease, new Date(), "DiagAcceptDisease");
      String logName = (String) session.getValue("logName");
      Vector logSessions = Common.getLogSessions(logName);
      Hashtable ht =(Hashtable) logSessions.elementAt(0);
      Vector historyOfDiseases = (Vector) ht.get("historyOfDiseases");
      historyOfDiseases.addElement(dr);
      Common.saveLogSessions(logName, logSessions);

      DB props = (DB) session.getValue("theDB");
      String myPhysician = props.getProperty("myPhysician");

      if ( null != myPhysician ) {
	  // ask whether to notify 
	  res.setContentType("text/html"); 
	  ServletOutputStream out = res.getOutputStream(); 
	  out.println("<html>");
	  out.println("<head><title>" + L.NotifyPhysicianQ + "</title>" +
		      D.linkHckStyle +
		      D.favicon +
		      "</head>");
	  out.println(
"<script language=\"JavaScript\">\n" + 
"function setHidden(form, val) { \n" +
"     form.returnVal.value = val; \n" +
"     form.submit(); \n" + 
"} \n" + 
"</script>");

	  out.println("<body>" +
		      "<font color=\"#850a0a\">");

	  out.println(DVM.htmlLogoutUser(L.NotifyPhysicianQ));
	  out.println("<p><font size=\"4\">" +
		    // "Your session will terminate if you select to notify your physician"
		    L.DiagAcceptDiseaseS1 +
		    "</font> ");

	  out.println("<form name=\"notifyQ\" action=\"" + D.servletNotifyQ + "\">");
	  out.println("<center> " +
		      "<input type=\"button\" " +
		      "value=\"" + L.YesNotify +
		      "\" onClick=\"setHidden(this.form, 1)\" /> " +
		      "<input type=\"button\" " +
		      "value=\"" + L.NoNotify +
		      "\" onClick=\"setHidden(this.form, 0)\" /> ");
	  out.println("<input type=\"hidden\" name=\"returnVal\" value=\"0\" /> ");

	  out.println("</center></form>");

	  // localhost:8000 === healthcareProvider:80 or so
	  out.println(DV.SCRIPTCC);
       
	  out.println("</font></body>");
	  out.println("</html>");
      }
      // to bypass the notification question:
      //ElaborateSymptomsQ.call(res, session);
      else
	  AngelRoot.call(res);
    }
} // end DiagAcceptDisease

