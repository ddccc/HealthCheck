// (C) OntoOO/ Dennis de Champeaux 2011
package patient;

import com.DV;
import com.D;
import com.L;
import com.DVM;
import com.Common;
import misc.SessionExpired;
import misc.DB;
import concepts.Symptom;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class CheckDrugEffects extends HttpServlet {

public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      HttpSession session = req.getSession(false);
      if ( null == session ) {	
	  SessionExpired.call(res, DV.CheckDrugEffects);
	  return;
      }

      String [] criticalSymptomsArr = req.getParameterValues("criticalSymptoms"); // can be null
      String [] otherSymptomsArr = req.getParameterValues("otherSymptoms"); // can be null
      String allCriticalSymptoms = req.getParameter("allCriticalSymptoms"); // can be ""
      String allOtherSymptoms = req.getParameter("allOtherSymptoms"); // can be ""
      String criticalSideEffects = "";
      String regularSideEffects = "";
      int lng2 = ( null == criticalSymptomsArr ? 0 : criticalSymptomsArr.length );
      for ( int i = 0; i < lng2; i++ ) 
	  criticalSideEffects = criticalSideEffects + criticalSymptomsArr[i] + ",";
      int lng = ( null == otherSymptomsArr ? 0 : otherSymptomsArr.length );
      for ( int i = 0; i < lng; i++ ) 
	  regularSideEffects = regularSideEffects + otherSymptomsArr[i] + ",";

      // >>> to be used in DiagStartSymptom/ AssessSymptoms or Diag1Focussed <<<
      if ( !allCriticalSymptoms.equals("") ) {
	  session.putValue("allCriticalSymptoms", allCriticalSymptoms);
	  if ( 0 < lng2 )
	      session.putValue("criticalSideEffects", criticalSideEffects);
      }
      if ( !allOtherSymptoms.equals("") ) {
	  session.putValue("allOtherSymptoms", allOtherSymptoms);
	  if ( 0 < lng )
	      session.putValue("regularSideEffects", regularSideEffects);
      }
      if ( 0 == lng2 && 0 == lng ) {
	  DiagStart.call(req, res, session);
	  return;
      }

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html><head><title>" + L.DrugSideEffects + "</title>" + " \n" +
		  D.linkHckStyle + " \n" +
		  D.favicon + " \n" +
		  "<style type=\"text/css\"> \n" +
		  "  td {font-size:15pt; color:#850a0a} \n" +
		  "</style> \n" +
		  Diag1b.popupDisplaySymptom +
		  // Diag1b.popupDisplayDrug +
		  "</head>");
      out.println("<body>" +
		  "<font color=\"#850a0a\">");

      // out.println("Loading wait count: " + waitCnt);
      
      out.println(DVM.htmlLogoutUser(L.DrugSideEffects));
      
      int anchor = 1000;
      if ( 0 < lng2 ) {
	  out.println("<font color=\"#FF0000\" size=\"4\">" +
		      // "You have confirmed the following critical symptoms:" +
		      L.DrugSideEffects1 +
		      "</font><br>");
	  for ( int i = 0; i < lng2; i++ ) {
	      String sympName = criticalSymptomsArr[i];
	      Symptom sympi = Common.getSymptom(sympName);
	      anchor++;
	      out.println(
                         "<a href=\"#" + anchor + "\" name=\"" + anchor +
			 "\" onClick=\"displaySymptom('" + sympName + "')\">" + sympi.getPrintName() +
			 "</a><br>");
	  }
      }      
      if ( 0 < lng ) {
	  out.println( ( 0 < lng2 ? "<p />" : "" ) +
		      "<font color=\"#1C5540\" size=\"4\">" +
		       // "You have confirmed the following other symptoms:" +
		       L.DrugSideEffects2 +
		      "</font><br>");
	  for ( int i = 0; i < lng; i++ ) {
	      String sympName = otherSymptomsArr[i];
	      Symptom sympi = Common.getSymptom(sympName);
	      anchor++;
	      out.println(
                         "<a href=\"#" + anchor + "\" name=\"" + anchor +
			 "\" onClick=\"displaySymptom('" + sympName + "')\">" + sympi.getPrintName() +
			 "</a><br>");
	  }
      }
      if ( 0 < lng2 ) 
	  out.println("<font color=\"#FF0000\" size=\"4\">" +
		      // "If you experience critical symptoms you may " +
		      // "want to terminate this session and obtain professional help." +
		      L.Diag1bS17 +
		      "</font><br>");
       if ( 0 < lng )
	   out.println("<font color=\"#1C5540\" size=\"4\">" +
		      // "If you believe that your symptoms are caused by your drugs " +
		      // "you many want to terminate this session." +
		      L.Diag1bS18 +
		      "</font><br>");

      out.println("<form name=\"terminateForm\" action=\"" + D.servletDiag1cTerminate + "\">");
      out.println("<input type=\"hidden\" name=\"regularSideEffects\" " +
		  "value=\"" + regularSideEffects + "\" />");
      out.println("<input type=\"hidden\" name=\"criticalSideEffects\" " +
		  "value=\"" + criticalSideEffects + "\" />");
      out.println("<input type=\"submit\" value=\"" + L.Terminate + "\" /> ");
      out.println("</form>");

      out.println("<form name=\"continueForm\" action=\"" + D.servletDiagStart + "\">");
      out.println("<input type=\"hidden\" name=\"arrivingFromCheckDrugEffects\" " +
		  "value=\"1\" />");
      out.println("<input type=\"submit\" value=\"" + L.Continue + "\" /> ");
      out.println("</form>");

      out.println(DV.htmlBack);

	// user Search
	// out.println(DiagStart.search());

	// localhost:8000 === healthcareProvider:80 or so
	out.println(DV.SCRIPTCC);

	out.println("</font></body>");
	out.println("</html>");
    
    } // end doGet
} // end CheckDrugEffects
