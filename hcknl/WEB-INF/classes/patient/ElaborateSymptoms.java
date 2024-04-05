// (C) OntoOO Inc 2005 Aug
package patient;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.DV;
import com.D;
import misc.SessionExpired;
import misc.DB;
import misc.DiagStackEntry;
import su.SUtil;
import su.PHLogin;
import misc.SendEmail;


public class ElaborateSymptoms extends HttpServlet {
  private static final boolean LOGGING = DV.LOGGINGdiag1;

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      if ( LOGGING ) {
	System.out.println("*** ElaborateSymptoms: Enter");
      }
      HttpSession session = req.getSession(false);
      if ( null == session ) {
	  SessionExpired.call(res,
			      DV.ElaborateSymptoms);
	  return;
      }
      // get the symptoms
      String iter = (String) session.getValue("iter");
      int iteration = 0;
      try { iteration = Integer.parseInt(iter); } 
      catch(NumberFormatException ignore) {}  
      Vector diagStack = (Vector) session.getValue("diagStack");
      DiagStackEntry dse = (DiagStackEntry) diagStack.elementAt(iteration);
      Vector selectedSymptoms = (Vector) dse.getSelectedSymptoms();
      int lng = selectedSymptoms.size();
      
      Vector symptomElaborations = new Vector();
      Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");
      
      if ( 0 < lng ) {
	  for ( int i = 0; i < lng; i++ ) {
	      Vector triple = new Vector();
	      String symptomName = (String) selectedSymptoms.elementAt(i);
	      triple.addElement(symptomName);
	      String duration = req.getParameter(symptomName + "Duration");
	      triple.addElement(duration);
	      String change = req.getParameter(symptomName + "Change");
	      triple.addElement(change);
	      symptomElaborations.addElement(triple);
	  }
	  // store in session
	  unboundHashtable.put("symptomElaborations", symptomElaborations);
      }
      String messageBody = req.getParameter("messageBody");
      if ( null != messageBody && !messageBody.equals("") )
	  unboundHashtable.put("messageBody", messageBody);

      DB props = (DB) session.getValue("theDB");
      String myPhysician = props.getProperty("myPhysician");
      String logName = (String) session.getValue("logName");
      SUtil.addPHsession(myPhysician, logName); // add to the fresh session list

      String to = PHLogin.getPHemailAddress(myPhysician);
      String from = null;
      String subject = "Session notification for: " + logName;
      StringBuffer sb = new StringBuffer();
      sb.append("A new session was created for: " + logName + "\n");
      sb.append("For details login to your account: \n");
      sb.append(D.phloginHtml + "\n");
      String message = sb.toString();
      try { SendEmail.sendEmailFunc(to, from, subject, message, req); }
      catch (Exception ex) {
	  res.setContentType("text/html");
	  ServletOutputStream out = res.getOutputStream();
	  out.println(
	     "<html><header><title>Notification Failure</title></header><body bgcolor=\"pink\"><p>");
	  out.println("<p>Your physician could NOT be notified. " +
		      "Please contact your physician as you see fit." +
		      "<br >Cause of failure: " + ex.toString());
	  out.println("<h3>Use the Back button to proceed.</h3>");
	  out.println(DV.htmlBack);
	  out.println(DV.SCRIPTCC);
	  out.println("</body></html>");
	  return;
      }
      UserLogout.call(req, res);
      //      AngelRoot.call(res);
    }




} // end ElaborateSymptoms

