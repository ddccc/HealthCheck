// Copyright OntoOO Inc, 2004 Mar
package phone;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.L;
import com.D;
// import misc.DB;
// import misc.PeriodLogin;
import concepts.Location;
// import concepts.LocationRelation;
// import concepts.PartOfLocation;
// import patient.DiagStart;


public class AskSymptom extends HttpServlet {


    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    PhoneError.call(res, "bevocal", 
			    // "Your session expired while in Ask Symptom."
			    L.AskSymptom1
			    );
	    return;
	}
	call(res, session);
    }

    static public void call(HttpServletResponse res, HttpSession session) 
	throws IOException {

	session.putValue("state", "initial");
	Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");
	String page = "phone.AskSymptom";
	String currentPage = (String) session.getValue("page");
	if ( !page.equals(currentPage) ) {
	    session.putValue("page", page);
	    Integer pageCnt = (Integer) session.getValue("pageCnt");
	    pageCnt = new Integer(1+ pageCnt.intValue());
	    session.putValue("pageCnt", pageCnt);
	    unboundHashtable.put("pageCnt", pageCnt);
	}
	Integer surfCnt = (Integer) session.getValue("surfCnt");
	surfCnt = new Integer(1+ surfCnt.intValue());
	
	session.putValue("surfCnt", surfCnt);
	unboundHashtable.put("surfCnt", surfCnt);
	String host = (String) session.getValue("host");


	String xml = 
"<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +

	    ( host.equals("bevocal") ?
	      L.vxml1
	      :
	      L.vxml2 ) +

	    // " <property name=\"universals\" value=\"all\" /> \n" +

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

" <form id=\"symptom\"> \n" +

	    ( host.equals("bevocal") ?
"            <grammar type=\"application/x-nuance-gsl\"> \n" 
	      :
"            <grammar type=\"text/gsl\"> \n" ) +

"            <![CDATA[ SomeSymptoms[ \n" +
	    /*
"                [(?i ?have abdomen pain) (pain ?in abdomen)] {<answer \"abdomenPain\">} \n " +
"                [(?i ?have no appetite) \n "+
"                 (?i ?am not hungry) \n "+
"                 (?i ?have not eaten) \n "+
"                 (?i don't want food) \n "+
"                 (?i don't  eat) \n "+
"                 (?i can't  eat)] \n "+
"                      {<answer \"anorexia\">} \n " +
"                [(?i ?have anxiety) \n " +
"                 (?i ?am fearfull) \n " +
"                 (?i ?am afraid) \n " +
"                 (?i ?am anxious) \n " +
"                 (?i ?am frightened)] \n " +
"                     {<answer \"anxiety\">} \n " +
"                [(?i ?have arrhythmia)] {<answer \"arrhythmia\">} \n " +
"                [(?i ?have chills) \n " +
"                 (?i ?am ?feel cold) ] \n " +
"                      {<answer \"chills\">} \n " +
"                [(?i ?have confusion) \n "+
"                 (?i ?am confused)] \n " +
"                     {<answer \"confusion\">} \n " +
"                [(?i cough)(?i ?am coughing)] {<answer \"cough\">} \n " +
"                [(?i ?have crackles)] {<answer \"crackles\">} \n " +
"                [(?i ?have diarrhea)] {<answer \"diarrhea\">} \n " +
"                [(?i ?have blue skin) \n " + 
"                 (?i ?have blueish skin)] \n " +
"                     {<answer \"cyanosis\">} \n " +
"                [(?i ?have short of breath)] {<answer \"dyspnea\">} \n " +
"                [(?i ?have dysuria) \n " +
"                 (?i ?can not piss) \n " +
"                 (?i can't piss) \n " +
"                 (?i ?can not pee) \n " +
"                 (?i can't pee) \n " +
"                 (?i ?can not urinate) \n " +
"                 (?i can't urinate)] \n " +
"                     {<answer \"dysuria\">} \n " +
"                [(?i ?have edema)(?i ?have swellings)] {<answer \"edema\">} \n " +
"                [(?i ?am fatigued) \n " +
"                 (?i ?am tired)] \n " +
"                     {<answer \"fatique\">} \n " +
"                [(?i ?have ?a headache)] {<answer \"headache\">} \n " +
"                [(?i ?have low blood pressure) (blood pressure low)] {<answer \"hypotension\">} \n " +
"                [(?i ?am ?feel irritated )] \n " +
"                     {<answer \"irritability\">} \n " +
"                [(?i ?feel sick)\n " +
"                 (?i ?feel miserable)] \n" +
"                     {<answer \"malaise\">} \n " +
"                [(?i ?have myalgia) \n " +
"                 (?i ?have muscle pain) \n " +
"                 (?i ?have painful muscles) \n " +
"                 (?i ?have hurting muscles) \n " +
"                 (?my muscles are painful) \n " +
"                 (?my muscles hurt)] \n " +
"                      {<answer \"myalgia\">} \n " +
"                [(?i ?have nausea)] {<answer \"nausea\">} \n " +
"                [(?i ?have seizures)] {<answer \"seizure\">} \n " +
"                [(?i ?have ?a ?too fast heartbeat ) \n" +
"                 (?my heartbeat ?is ?too fast )] \n" +
"                      {<answer \"tachycardia\">} \n " +
"                [(?i breath fast) (fast breathing)] {<answer \"tachypnea\">} \n " +
"                [(?i ?have ?a sore throat) (throat ?is sore)] {<answer \"throatSore\">} \n " +
"                [(?i ?am vomiting )] {<answer \"vomiting\">} \n " +
"                [(?i ?feel ?am weak)\n " +
"                 (?i ?feel weakness)] \n" +
"                     {<answer \"weakness\">} \n " +
"                [(?i ?am loosing weight) \n " +
"                 (?i ?have lost weight) \n " +
"                 (?i ?have weight loss)] \n " +
"                     {<answer \"weightloss\">} \n " +
	    */
	    L.AskSymptom4 +
"           ]]]> \n " +
"           </grammar> \n" +

"	<field name=\"answer3\" expr=\"'not set'\" /> \n" +
"	<field name=\"answer\"> \n" +
"            <help> <prompt>" + 
	            // "Please say which symptom bothers you the most." +
	            L.AskSymptom2 +
"                   </prompt> </help> \n" +
"	     <prompt> \n" +
	    /*
"               Secondly, we are investigating which symptoms you may have. " +
"               Please say which symptom bothers you the most. " +
"               For example say: short of breath, or say: headache, or say: chills, or say: cough, " +
"               or say chest pain, or say sore throat. " +
	    */
	        L.AskSymptom3 +
"	     </prompt> \n" +

"           <nomatch count=\"1\"> \n" + 
//"              Your answer was not recognized.  Let's try one more time. \n" +
	    L.AskSymptom5 + " \n" +
"              <reprompt/> \n" +
"           </nomatch> \n" + 
"           <nomatch count=\"2\"> \n" + 
//"              Your answer was again not recognized.  You are put for now in the wait queue. \n" +
	         L.AskSymptom6 + " \n" +
"              <var name=\"cnt\" expr=\"0\"/> \n" +
"              <submit next=\"" + D.servletPhoneWait + "\" " +
"                      method=\"get\" namelist=\"cnt\" fetchtimeout=\"60s\"/> \n" +
"           </nomatch> \n" + 
"           <filled> \n" +
//"              OK will proceed with: " +
	         L.AskSymptom7 +
"              <value expr=\"answer3\"/>. \n" +
"              <submit next=\"" + D.servletAskMoreSymptoms + "\" " +
"                      method=\"get\" namelist=\"answer\" fetchtimeout=\"60s\"/> \n" +
"           </filled> \n" +
"       </field> \n" +
" </form> \n" +
"</vxml>";

	res.setContentType("application/voicexml+xml");
	ServletOutputStream out = res.getOutputStream();

	out.println(xml);

    }
}











