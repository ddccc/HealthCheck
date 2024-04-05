// (C) OntoOO Inc 2002 June
package phone;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import com.DV;
import com.D;
import com.L;
import misc.DB;
import misc.SessionExpired;
import patient.CheckPremenstruating2;


public class PhoneCheckStatus extends HttpServlet {

static private String askLastMenstruation(String host) {
    return
"   <field name=\"month\"> \n" +
"     <help>  <reprompt/>  </help> \n" +
"     <prompt> \n" +
	/*
"       OK, let's figure out the date of your last menstruation." +
"       First the month and then the day. " +
"       What was the last month in which you menstruated?" +
"       For example say \"June\". " +
	*/
	L.PCheckStatus1 +
"     </prompt> \n" +
	    ( host.equals("bevocal") ?
"            <grammar type=\"application/x-nuance-gsl\"> \n" 
	      :
"            <grammar type=\"text/gsl\"> \n" ) +
"            <![CDATA[ MonthChoices[ \n" + 
	/*
"  [january] {<month \"Jan0\">} \n " +
"  [february] {<month \"Feb1\">} \n " +
"  [march] {<month \"Mar2\">} \n " +
"  [april] {<month \"Apr3\">} \n " +
"  [may] {<month \"May4\">} \n " +
"  [june] {<month \"Jun5\">} \n " +
"  [july] {<month \"Jul6\">} \n " +
"  [august] {<month \"Aug7\">} \n " +
"  [september] {<month \"Sep8\">} \n " +
"  [october] {<month \"Oct9\">} \n " +
"  [november] {<month \"Nov10\">} \n " +
"  [december] {<month \"Dec11\">} \n " + 
	*/
	L.PCheckStatus2 +
"            ]]]> \n " +
"           </grammar> \n" +
"    <filled> \n" +
"    Got it! " +
"    </filled> \n" +
"   </field> \n" +
"   <field name=\"day\"> \n" +
"     <help>  <reprompt/>  </help> \n" +
"     <prompt> \n" +
	/*
"       OK, now the day of your last menstruation." +
"       For example say \"seventh\" or say \"twenty first\". " +
	*/
	L.PCheckStatus3 +
"     </prompt> \n" +
	    ( host.equals("bevocal") ?
"            <grammar type=\"application/x-nuance-gsl\"> \n" 
	      :
"            <grammar type=\"text/gsl\"> \n" ) +
"            <![CDATA[ DayChoices[ \n" + 
	/*
"  [first] {<day \"1\">} \n " +
"  [second] {<day \"2\">} \n " +
"  [third] {<day \"3\">} \n " +
"  [fourth] {<day \"4\">} \n " +
"  [fifth] {<day \"5\">} \n " +
"  [sixth] {<day \"6\">} \n " +
"  [seventh] {<day \"7\">} \n " +
"  [eighth] {<day \"8\">} \n " +
"  [ninth] {<day \"9\">} \n " +
"  [tenth] {<day \"10\">} \n " +
"  [eleventh] {<day \"11\">} \n " +
"  [twelfth] {<day \"12\">} \n " +
"  [thirteenth] {<day \"13\">} \n " +
"  [fourteenth] {<day \"14\">} \n " +
"  [fifteenth] {<day \"15\">} \n " +
"  [sixteenth] {<day \"16\">} \n " +
"  [seventeenth] {<day \"17\">} \n " +
"  [eighteenth] {<day \"18\">} \n " +
"  [nineteenth] {<day \"19\">} \n " +
"  [twentieth] {<day \"20\">} \n " +
"  [(twenty first)] {<day \"21\">} \n " +
"  [(twenty second)] {<day \"22\">} \n " +
"  [(twenty third)] {<day \"23\">} \n " +
"  [(twenty fourth)] {<day \"24\">} \n " +
"  [(twenty fifth)] {<day \"25\">} \n " +
"  [(twenty sixth)] {<day \"26\">} \n " +
"  [(twenty seventh)] {<day \"27\">} \n " +
"  [(twenty eighth)] {<day \"28\">} \n " +
"  [(twenty ninth)] {<day \"29\">} \n " +
"  [thirtieth] {<day \"30\">} \n " +
"  [( thirty first )] {<day \"31\">} \n " +
	*/
	L.PCheckStatus4 +
"            ]]]> \n " +
"     </grammar> \n" +
"     <filled> \n" +
//"       Got it! " +
	 L.PCheckStatus5 +
"        <submit next=\"" + D.servletPSetPregnant + "\" \n" +
"                   method=\"get\" namelist=\"answer month day\" fetchtimeout=\"60s\"/> \n" +
"    </filled> \n" +
"   </field> \n";
}

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException

    {
      // The person is female 
      // Will check whether the statusCondition needs change

	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    PhoneError.call(res, "bevocal", 
			    // "Your session expired while in Phone Check Status."
			    L.PCheckStatus0
			    );
	    return;
	}
    }

    static public void call(HttpServletResponse res, HttpSession session)
	throws  IOException {

	Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");
	String page = "phone.PhoneCheckStatus";
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


" <form id=\"checkStatus\"> \n";

	DB props = (DB) session.getValue("theDB");
	String statusCondition = props.getProperty("statusCondition");
	Integer ageInt = (Integer) session.getValue("ageInt");
	int age = ageInt.intValue();

	if ( statusCondition.equals("premenstruating") ) {
	  if ( age < 9 ) { 
	    // Save this stuff and redirect to AngelRoot ...
	    AskLocation.call(res, session);
	    return;
	  }
	  // CheckPremenstruation2
	  xml = xml + 
"    <field name=\"answer\"> \n" +
"     <help>  <reprompt/>  </help> \n" +
"     <prompt> \n" +
	      /*
"       According to previously provided info you have never menstruated. " +
"       Please say \"never menstruated\" if you have still never menstruated. " +
"       Say \"I have menstruated\" if you do have menstruated and you are not pregnant. " +
"       Say \"I am pregnant\" if you are now pregnant. " +
"       Say \"help\" to hear these choices again. " +
	      */
	      L.PCheckStatus6 +
"     </prompt> \n" +
	    ( host.equals("bevocal") ?
"            <grammar type=\"application/x-nuance-gsl\"> \n" 
	      :
"            <grammar type=\"text/gsl\"> \n" ) +
"            <![CDATA[ PremenstruatingChoices[ \n" +
	      /*
"                [(?i ?have never menstruated)] {<answer \"premenstruating\">} \n " +
"                [(?i ?have menstruated)] {<answer \"menstruating\">} \n "+
"                [(?i ?am pregnant)] {<answer \"pregnant\">} \n "+
	      */
	      L.PCheckStatus7 +
"            ]]]> \n " +
"           </grammar> \n" +
"    <filled> \n" +
"       <if cond=\"(answer != 'pregnant') \"> \n" +
"           <submit next=\"" + D.servletPCheckPremenstruating2 + "\" \n" +
"                   method=\"get\" namelist=\"answer\" fetchtimeout=\"60s\"/> \n" +
"       </if> \n" +
"    </filled> \n" +
"   </field> \n" +
askLastMenstruation(host) +
" </form> \n" +
"</vxml>";
	  res.setContentType("application/voicexml+xml");
	  ServletOutputStream out = res.getOutputStream();
	  out.println(xml);
	  return;
	} // end premenstruating
	
	//   ////////////////////////////////////////////////////////////////////////////////////////

	if ( statusCondition.equals("pregnant") ) { // PCheckPregnancy2
	  // CheckPregnancy2
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

	    if ( pregnancyDuration < 180 ) {
		xml = xml + 
"    <field name=\"answer\" type=\"boolean\"> \n" +
"     <help>  <reprompt/>  </help> \n" +
"     <prompt> \n" +
		    /*
"       According to previously provided info you were pregnant. " +
"       Your last recorded menstruation was " +
		    */
	L.PCheckStatus8 +
"       <say-as interpret-as=\"number\"> " + pregnancyDuration + " </say-as> " + 
		    /*
"       days ago. " +
"       Is that pregnancy still continuing? " +
"       Answer no if you had a miscarriage. " +
		    */
	L.PCheckStatus9 +
"     </prompt> \n" +
"    <filled> \n" +
"       <if cond=\"(answer == true) \"> \n" +
"           <submit next=\"" + D.servletAskLocation + "\" \n" +
"                   method=\"get\" fetchtimeout=\"60s\"/> \n" +
"       </if> \n" +
"    </filled> \n" +
"   </field> \n" +
"   <field name=\"answer2\"  type=\"boolean\"> \n" +
"     <help>  <reprompt/>  </help> \n" +
"     <prompt> \n" +
//"        Have you become pregnant again? " +
	   L.PCheckStatus10 +
"     </prompt> \n" +
"    <filled> \n" +
"       <if cond=\"(answer2 == false) \"> \n" +
"           <var name=\"answer\" expr=\"'menstruating'\"/> \n" +
"           <var name=\"statusCondition\" expr=\"'miscarriage'\"/> \n" +
"           <submit next=\"" + D.servletPCheckPregnancy2 + "\" \n" +
"                   method=\"get\" namelist=\"answer statusCondition\" fetchtimeout=\"60s\"/> \n" +
"       </if> \n" +
"    </filled> \n" +
"   </field> \n" +
askLastMenstruation(host) +
" </form> \n" +
"</vxml>";
	       res.setContentType("application/voicexml+xml");
	       ServletOutputStream out = res.getOutputStream();
	       out.println(xml);
	       return;
	    } // 180

	    if ( pregnancyDuration < 325 ) {
		xml = xml + 
"  <block> \n" +
"     <prompt> \n" +
		    /*
"       According to previously provided info you were pregnant. " +
"       Your last recorded menstruation was " +
		    */
         L.PCheckStatus11 +
"       <say-as interpret-as=\"number\"> " + pregnancyDuration + " </say-as> " +
//"     days ago. " +
         L.PCheckStatus12 +
"     </prompt> \n" +
"  </block> \n" +
		( 290 <= pregnancyDuration ?
"  <block> \n" +
"     <prompt> \n" +
//"       If that pregnancy is still continuing you are now overdue for " +
          L.PCheckStatus13 +
"         <say-as interpret-as=\"number\"> " + ( pregnancyDuration - 280 ) + " </say-as> " + 
//"       days and you should contact a physician. " +
          L.PCheckStatus14 +
"     </prompt> \n" 
		  : "" ) +
"  </block> \n" +
"    <field name=\"answer0\" type=\"boolean\"> \n" +
"     <help>  <reprompt/>  </help> \n" +
"     <prompt> \n" +
//"       Is that pregnancy still continuing? " +
          L.PCheckStatus15 +
"     </prompt> \n" +
"    <filled> \n" +
//"       Got it! " +
          L.PCheckStatus5 +
"       <if cond=\"(answer0 == true) \"> \n" +
"           <submit next=\"" + D.servletAskLocation + "\" \n" +
"                   method=\"get\" fetchtimeout=\"60s\"/> \n" +
"       </if> \n" +
"    </filled> \n" +
"   </field> \n" +
"   <field name=\"answer\"> \n" +
"     <help>  <reprompt/>  </help> \n" +
"     <prompt> \n" +
		    /*
"        If you had a life birth say \"life birth\". " +
"        If you had a still birth say \"still birth\". " +
"        If you had a miscariage say \"miscarriage\". " +
"        Say \"help\" to hear these choices again. " +
		    */
         L.PCheckStatus16 +
"     </prompt> \n" +
	    ( host.equals("bevocal") ?
"            <grammar type=\"application/x-nuance-gsl\"> \n" 
	      :
"            <grammar type=\"text/gsl\"> \n" ) +
"            <![CDATA[ PregnancyChoices[ \n" +
		    /*
"                [(?i ?had ?a life birth)] {<answer \"lifeBirth\">} \n " +
"                [(?i ?had ?a miscarriage)] {<answer \"miscarriage\">} \n " +
"                [(?i ?had ?a stillBirth)] {<answer \"stillBirth\">} \n " +
		    */
                 L.PCheckStatus17 +
"            ]]]> \n " +
"           </grammar> \n" +
"     <filled> \n" +
//"       Got it! " +
          L.PCheckStatus5 +
"     </filled> \n" +
"   </field> \n" +
"   <field name=\"answer2\"  type=\"boolean\"> \n" +
"     <help>  <reprompt/>  </help> \n" +
"     <prompt> \n" +
//"        Have you become pregnant again? " +
	   L.PCheckStatus10 +
"     </prompt> \n" +
"    <filled> \n" +
"       <if cond=\"(answer2 == false) \"> \n" +
"           <var name=\"statusCondition=\" expr=\"answer\"/> \n" +
"           <var name=\"answer\" expr=\"'menstruating'\"/> \n" +
"           <submit next=\"" + D.servletPCheckPregnancy2 + "\" \n" +
"                   method=\"get\" namelist=\"answer statusCondition\" fetchtimeout=\"60s\"/> \n" +
"       </if> \n" +
"    </filled> \n" +
"   </field> \n" +
askLastMenstruation(host) +
" </form> \n" +
"</vxml>";
	       res.setContentType("application/voicexml+xml");
	       ServletOutputStream out = res.getOutputStream();
	       out.println(xml);
	       return;
	    } // < 325

	    // 325 <= 

	    xml = xml +
"   <field name=\"answer\"> \n" +
"     <help>  <reprompt/>  </help> \n" +
"     <prompt> \n" +
		/*
"        If you had a life birth say \"life birth\". " +
"        If you had a miscarriage say \"miscarriage\". " +
"        If you had a stillbirth say \"stillbirth\". " +
"        Say \"help\" to hear these choices again. " +
		*/
         L.PCheckStatus16 +
"     </prompt> \n" +
	    ( host.equals("bevocal") ?
"            <grammar type=\"application/x-nuance-gsl\"> \n" 
	      :
"            <grammar type=\"text/gsl\"> \n" ) +
"            <![CDATA[ PregnancyChoices[ \n" +
		/*
"                [(?i ?had ?a life birth)] {<answer \"lifeBirth\">} \n " +
"                [(?i ?had ?a miscarriage)] {<answer \"miscarriage\">} \n " +
"                [(?i ?had ?a stillBirth)] {<answer \"stillBirth\">} \n " +
		*/
                L.PCheckStatus17 +
"            ]]]> \n " +
"           </grammar> \n" +
"     <filled> \n" +
//"       Got it! " +
          L.PCheckStatus5 +
"     </filled> \n" +
"   </field> \n" +
"   <field name=\"answer2\"  type=\"boolean\"> \n" +
"     <help>  <reprompt/>  </help> \n" +
"     <prompt> \n" +
//"        Have you become pregnant again? " +
	   L.PCheckStatus10 +
"     </prompt> \n" +
"    <filled> \n" +
"       <if cond=\"(answer2 == false) \"> \n" +
"           <var name=\"statusCondition=\" expr=\"answer\"/> \n" +
"           <var name=\"answer\" expr=\"'menstruating'\"/> \n" +
"           <submit next=\"" + D.servletPCheckPregnancy2 + "\" \n" +
"                   method=\"get\" namelist=\"answer statusCondition\" fetchtimeout=\"60s\"/> \n" +
"       </if> \n" +
"    </filled> \n" +
"   </field> \n" +
askLastMenstruation(host) +
" </form> \n" +
"</vxml>";
	       res.setContentType("application/voicexml+xml");
	       ServletOutputStream out = res.getOutputStream();
	       out.println(xml);
	       return;

	} // end pregnant

	//   ////////////////////////////////////////////////////////////////////////////////////////

	if ( statusCondition.equals("menstruating") ) { // PCheckMenstruating2 
	    // CheckMenstruating2

	  // should we ask about a change in to menopause?
	  boolean askMenopause = (48 <= age);

	  xml = xml + 
"    <var name=\"askMenopause\" expr=\"" + askMenopause + "\"/> \n" +
"    <field name=\"answer\" type=\"boolean\"> \n" +
"     <help>  <reprompt/>  </help> \n" +
"     <prompt> \n" +
	      /*
"       According to previously provided info you were not pregnant. " +
"       Are you now pregnant? " +
	      */
	L.PCheckStatus18 +
"     </prompt> \n" +
"    <filled> \n" +
"       <if cond=\"(answer == true) \"> \n" +
"           <goto nextitem=\"month\"/> \n" +
"       </if> \n" +
"       <if cond=\"(askMenopause == true) \"> \n" +
"           <goto nextitem=\"menopause\"/> \n" +
"       </if> \n" +
"       <submit next=\"" + D.servletAskLocation + "\" \n" +
"                   method=\"get\" fetchtimeout=\"60s\"/> \n" +
"    </filled> \n" +
"   </field> \n" +
askLastMenstruation(host) +
"    <field name=\"menopause\" type=\"boolean\"> \n" +
"     <help>  <reprompt/>  </help> \n" +
"     <prompt> \n" +
//"       Have you entered menopause? " +
	  L.PCheckStatus19 +
"     </prompt> \n" +
"    <filled> \n" +
"        <submit next=\"" + D.servletPCheckMenstruating2 + "\" \n" +
"                   method=\"get\" namelist=\"menopause\" fetchtimeout=\"60s\"/> \n" +
"    </filled> \n" +
"   </field> \n" +
" </form> \n" +
"</vxml>";
	  res.setContentType("application/voicexml+xml");
	  ServletOutputStream out = res.getOutputStream();
	  out.println(xml);
	  return;
	} // end menstruating

	//   ////////////////////////////////////////////////////////////////////////////////////////

	if ( statusCondition.equals("menopause") ) { // PCheckMenopause2 
	    // CheckMenopause2 

	  // should we ask about a change in to postmenopause?
	  boolean askPostmenopause = (54 <= age);
	  xml = xml + 
"    <field name=\"answer\"> \n" +
"     <help>  <reprompt/>  </help> \n" +
"     <prompt> \n" +
	      /*
"       According to previously provided info you are in menopause. " +
"       Please say \"menopause\" if you are still in menopause. " +
"       Say \"postmenopause\" if you have transitioned into postmenopause. " +
"       Say \"I am pregnant\" if you happen to be pregnant. " +
"       Say \"help\" to hear these choices again. " +
	      */
        L.PCheckStatus20 +
"     </prompt> \n" +
	    ( host.equals("bevocal") ?
"            <grammar type=\"application/x-nuance-gsl\"> \n" 
	      :
"            <grammar type=\"text/gsl\"> \n" ) +
"            <![CDATA[ MenopauseChoices[ \n" +
	      /*
"                [(menopause)] {<answer \"menopause\">} \n " +
"                [(postmenopause)] {<answer \"postmenopause\">} \n " +
"                [(?i ?am pregnant)] {<answer \"pregnant\">} \n " +
	      */
              L.PCheckStatus21 +
"            ]]]> \n " +
"           </grammar> \n" +
"    <filled> \n" +
"       <if cond=\"(answer != 'pregnant') \"> \n" +
"           <submit next=\"" + D.servletPCheckMenopause2 + "\" \n" +
"                   method=\"get\" namelist=\"answer\" fetchtimeout=\"60s\"/> \n" +
"       </if> \n" +
"    </filled> \n" +
"   </field> \n" +
askLastMenstruation(host) +
" </form> \n" +
"</vxml>";
	  res.setContentType("application/voicexml+xml");
	  ServletOutputStream out = res.getOutputStream();
	  out.println(xml);
	  return;
	} // end menopause

	//   ////////////////////////////////////////////////////////////////////////////////////////


	// statusCondition = postmenopause, thus proceed right away:
	// Save this stuff and redirect to AngelRoot ...
	AskLocation.call(res, session);
    }
}










