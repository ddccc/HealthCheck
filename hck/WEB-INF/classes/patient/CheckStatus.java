// (C) OntoOO Inc 2002 June
package patient;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import com.DV;
import com.D;
import com.L;
import misc.DB;
import misc.SessionExpired;
import htmls.AngelRoot;

public class CheckStatus extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException

    {
      // The person is female 
      // Will check whether the statusCondition needs change

	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    SessionExpired.call(res,
				DV.CheckStatus);
	    return;
	}
	call(res, session);
    }

    static public void call(HttpServletResponse res, HttpSession session)
	throws  IOException {
	DB props = (DB) session.getValue("theDB");
	String statusCondition = props.getProperty("statusCondition");
	Integer ageInt = (Integer) session.getValue("ageInt");
	int age = ageInt.intValue();

	if ( statusCondition.equals("premenstruating") ) {
	  if ( age < 9 ) { 
	    // Save this stuff and redirect to AngelRoot ...
	    session.setMaxInactiveInterval(DV.maxInactiveInterval); // Jrun in millisec ....
	    AngelRoot.call(res);
	    return;
	  }
	  // CheckPremenstruation2
	  res.setContentType("text/html");
	  ServletOutputStream out = res.getOutputStream();
	  out.println("<html>");
	  out.println("<head><title>" + L.Menstruating + "</title>" +
		      D.linkHckStyle +
		      D.favicon +
		      "</head>" +
		      "<body>");
	  out.println("<h1 align=\"center\"><font color=\"#FF0000\" size=\"4\">" +
		      L.Menstruating + "</font></h1>\n " +
		      "<form action=\"" + D.servletCheckPremenstruating2 + "\">\n");
	  out.println(
   "<table border=\"1\">" +
   "<tr><th colspan=\"2\">" +
   // "According to previously provided info you have never menstruated" +
   L.CheckStatusQ1 +
   "<br />" + L.PleaseCorrectIfNecessary + "</th></tr> \n");

	  out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"premenstruating\" checked=\"checked\" " +
  "/></td><td><b>" +
  //  "Indeed I have never menstruated" +
  L.CheckStatusS1 +
  "</b></td></tr>");

	  out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"menstruating\" " +
  "/></td><td><b>" +
  //  "I DO have had a menstruation (and I am NOT pregnant)" +
  L.CheckStatusS2 +
  "</b></td></tr>");

	  out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"pregnant\" /" +
  "></td><td><b>" +
  //  "In fact, I AM pregnant" +
  L.CheckStatusS3 +
  "</b> " + 
  //  "date of last menstruation: "
  L.CheckStatusS4
  );
	  Setup2.writeLastMenstruationDate(out);
	  out.println("</td></tr></table>");

	  out.println("<hr />" + L.PleaseCheckAllFieldsBeforeSubmitting + " " +
		      "<input type=\"submit\" value=\"Submit\" />\n " +
		      "</form></body></html>");
	  return;
	} // end premenstruating
	
	if ( statusCondition.equals("pregnant") ) {
	    // calculate the duration 
	    String year =  props.getProperty("pregnantYear");
	    String monthNum =  props.getProperty("pregnantMonthNum");
	    String day =  props.getProperty("pregnantDay");
	    String pregnantDate =  props.getProperty("pregnantDate");

	    int monthi = 0;
	    int dayi = 1;
	    int yeari = 2000;
	    try { 
		yeari = Integer.parseInt(year);
		monthi = Integer.parseInt(monthNum);
		dayi = Integer.parseInt(day);
	    } catch (Exception ignore) {}
	    int pregnancyDuration = CheckPremenstruating2.duration(yeari, monthi, dayi);

	  res.setContentType("text/html");
	  ServletOutputStream out = res.getOutputStream();
	  out.println("<html>");
	  out.println("<head><title>" + L.Pregnant + "</title></head>");

	  out.println("<body bgcolor=\"" + D.bgcolor + "\">");

	  out.println("<h1 align=\"center\"><font color=\"#FF0000\" size=\"4\">" +
		      L.Pregnant + "</font></h1>\n " +
		      "<form action=\"" + D.servletCheckPregnancy2 + "\">\n");
	
	  out.println(
   "<table border=\"1\">" +
   "<tr><th colspan=\"3\">" +
   // "According to previously provided info you WERE pregnant" +
   L.CheckStatusQ2 +
   "<br />" + L.LastMenstructionDate + pregnantDate +
   "<br />" + L.PleaseCorrectIfNecessary + "</th></tr> \n");

	  if ( pregnancyDuration < 180  ) {
	  out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"pregnant\" checked=\"checked\" /" +
  "></td><td><b>" +
  // "Indeed I am STILL pregnant" +
  L.CheckStatusS5 +
  "</b></td></tr>");

	  out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"miscarriageMenstruating\" /" +
  "></td><td><b>" +
  // "I had a miscarriage and I am now NOT pregnant"
  L.CheckStatusS5E +
  "</b></td></tr>");

	  out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"miscarriagePregnant\" /" +
  "></td><td><b>" +
  // "I had a miscarriage and I am pregnant again"
  L.CheckStatusS5F +
  "</b></td><td> " +
  //  "date of last menstruation: "
  L.CheckStatusS4);
	  Setup2.writeLastMenstruationDate(out);
	  out.println("</td></tr></table>");

	  out.println("<hr />" + L.PleaseCheckAllFieldsBeforeSubmitting + " " +
		      "<input type=\"submit\" value=\"Submit\" />\n " +
		      "</form></body></html>");
	  return;
	  } // pregnancyDuration < 180 

	  if ( pregnancyDuration < 325  ) {

	      if ( 290 <= pregnancyDuration && pregnancyDuration < 325 ) 
		  out.println(
   "<tr><th colspan=\"3\"><font color=\"#FF0000\">" + 
   // "If that pregnancy is still on going you are overdue and " +
   // "you should take immediate action.";
   L.CheckStatusS4A + "</font></th></tr> \n");

	      out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"pregnant\" checked=\"checked\" /" +
  "></td><td><b>" +
  // "Indeed I am STILL pregnant" +
  L.CheckStatusS5 +
  "</b></td></tr>");

	      out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"lifeBirthMenstruating\" " +
  ( 325 <= pregnancyDuration ? "checked=\"checked\"" : "" ) +
  " /></td><td><b>" +
  // "I had a life birth and I am now NOT pregnant"
  L.CheckStatusS5A +
  "</b></td></tr>");

	      out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"lifeBirthPregnant\" " +
  "></td><td><b>" +
  // "I had a life birth and I am pregnant again"
  L.CheckStatusS5B +
  "</b></td><td> " +
  //  "date of last menstruation: "
  L.CheckStatusS4);
	      Setup2.writeLastMenstruationDate(out);
	      out.println("</td></tr>");

	      out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"stillBirthMenstruating\" /" +
  "></td><td><b>" +
  // "I had a still birth and I am now NOT pregnant"
  L.CheckStatusS5C +
  "</b></td></tr>");

	      out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"stillBirthPregnant\" /" +
  "></td><td><b>" +
  // "I had a still birth and I am pregnant again"
  L.CheckStatusS5D +
  "</b></td><td> " +
  //  "date of last menstruation: "
  L.CheckStatusS4);
	      Setup2.writeLastMenstruationDate(out);
	      out.println("</td></tr></table>");

	      out.println("<hr />" + L.PleaseCheckAllFieldsBeforeSubmitting + " " +
			  "<input type=\"submit\" value=\"Submit\" />\n " +
			  "</form></body></html>");
	      return;
	  } // pregnancyDuration < 325 

	  // 325 <= pregnancyDuration 

	  out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"lifeBirthMenstruating\" checked=\"checked\" /" +
  "></td><td><b>" +
  // "I had a life birth and I am now NOT pregnant"
  L.CheckStatusS5A +
  "</b></td></tr>");

	  out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"lifeBirthPregnant\" /" +
  "></td><td><b>" +
  // "I had a life birth and I am pregnant again"
  L.CheckStatusS5B +
  "</b></td><td> " +
  //  "date of last menstruation: "
  L.CheckStatusS4);
	  Setup2.writeLastMenstruationDate(out);
	  out.println("</td></tr>");

	  out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"stillBirthMenstruating\" /" +
  "></td><td><b>" +
  // "I had a still birth and I am now NOT pregnant"
  L.CheckStatusS5C +
  "</b></td></tr>");

	  out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"stillBirthPregnant\" /" +
  "></td><td><b>" +
  // "I had a still birth and I am pregnant again"
  L.CheckStatusS5D +
  "</b></td><td> " +
  //  "date of last menstruation: "
  L.CheckStatusS4);
	  Setup2.writeLastMenstruationDate(out);
	  out.println("</td></tr>");

	  out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"miscarriageMenstruating\" /" +
  "></td><td><b>" +
  // "I had a miscarriage and I am now NOT pregnant"
  L.CheckStatusS5E +
  "</b></td></tr>");

	  out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"miscarriagePregnant\" /" +
  "></td><td><b>" +
  // "I had a miscarriage and I am pregnant again"
  L.CheckStatusS5F +
  "</b></td><td> " +
  //  "date of last menstruation: "
  L.CheckStatusS4);
	  Setup2.writeLastMenstruationDate(out);
	  out.println("</td></tr></table>");

	  out.println("<hr />" + L.PleaseCheckAllFieldsBeforeSubmitting + " " +
		      "<input type=\"submit\" value=\"Submit\" />\n " +
		      "</form></body></html>");
	  return;
	} // end pregnant

	if ( statusCondition.equals("menstruating") ) {
	  res.setContentType("text/html");
	  ServletOutputStream out = res.getOutputStream();
	  out.println("<html>");
	  out.println("<head><title>" + L.Pregnant + "</title></head>");
	  out.println("<body bgcolor=\"" + D.bgcolor + "\">");

	  out.println("<h1 align=\"center\"><font color=\"#FF0000\" size=\"4\">" +
		      L.Pregnant + "</font></h1>\n " +
		      "<form action=\"" + D.servletCheckMenstruating2 + "\">\n");

	  // should we ask about a change in to menopause?
	  boolean askMenopause = (48 <= age);
	  
	  out.println(
   "<table border=\"1\">" +
   "<tr><th colspan=\"2\">" +
   // "According to previously provided info you are NOT pregnant" +
   L.CheckStatusQ3 +
   "<br />" + L.PleaseCorrectIfNecessary + "</th></tr> \n");

	  out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"menstruating\" checked=\"checked\" /" +
  "></td><td><b>" +
  // "Indeed I am NOT pregnant" +
  L.CheckStatusS10 +
  "</b></td></tr>");

	  out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"pregnant\" /" +
  "></td><td><b>" +
  // "I have become pregnant:" +
  L.CheckStatusS11 +
  "</b> " + 
  // "date of last menstruation: " +
  L.CheckStatusS4);
	  Setup2.writeLastMenstruationDate(out);
	  out.println("</td></tr>");

	  if ( askMenopause ) {
	    out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"menopause\" /" +
  "></td><td><b>" +
  // "I have entered menopause" +
  L.CheckStatusS12 +
  "</b>");
	    out.println("</td></tr></table>");
	  } else
	    out.println("</table>");

	  out.println("<hr />" + L.PleaseCheckAllFieldsBeforeSubmitting + " " +
		      "<input type=\"submit\" value=\"Submit\" />\n " +
		      "</form></body></html>");
	  return;
	} // end menstruating


	if ( statusCondition.equals("menopause") ) {
	  res.setContentType("text/html");
	  ServletOutputStream out = res.getOutputStream();
	  out.println("<html>");
	  out.println("<head><title>" + L.Menopause + "</title></head>");
	  out.println("<body bgcolor=\"" + D.bgcolor + "\">");

	  out.println("<h1 align=\"center\"><font color=\"#FF0000\" size=\"4\">" +
		      L.Menopause + "</font></h1>\n " +
		      "<form action=\"" + D.servletCheckMenopause2 + "\">\n");

	  // should we ask about a change in to postmenopause?
	  boolean askPostmenopause = (54 <= age);
	  
	  out.println(
   "<table border=\"1\">" +
   "<tr><th colspan=\"2\">" +
   // "According to previously provided info you are in menopause" +
   L.CheckStatusQ4 +
   "<br />" + L.PleaseCorrectIfNecessary + "</th></tr> \n");

	  out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"menopause\" checked=\"checked\" /" +
  "></td><td><b>" +
  // "Indeed I am still in menopause" +
  L.CheckStatusS13 +
  "</b></td></tr>");

	  out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"pregnant\" /" +
  "></td><td><b>" +
  // "Surprise, I have become pregnant:" + 
  L.CheckStatusS14 +
  "</b> " + 
  // "date of last menstruation: " +
  L.CheckStatusS4);
	  Setup2.writeLastMenstruationDate(out);
	  out.println("</td></tr>");

	  if ( askPostmenopause ) {
	    out.println(
  "<tr><td><input type=\"radio\" name=\"statusCondition\" value=\"postmenopause\" /" +
  "></td><td><b>" +
  // "I have entered post menopause" +
  L.CheckStatusS15 + 
  "</b>");
	    out.println("</td></tr></table>");
	  } else
	    out.println("</table>");

	  out.println("<hr />" + L.PleaseCheckAllFieldsBeforeSubmitting + " " +
		      "<input type=\"submit\" value=\"Submit\" />\n " +
		      "</form></body></html>");
	  return;
	} // end menopause

	// statusCondition = postmenopause, thus proceed right away:
	// Save this stuff and redirect to AngelRoot ...
	session.setMaxInactiveInterval(DV.maxInactiveInterval); // Jrun in millisec ....
	AngelRoot.call(res);
    }
}















