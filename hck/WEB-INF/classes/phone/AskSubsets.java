// Copyright OntoOO Inc, 2004 Jan
package phone;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.L;
import com.D;
import misc.DB;
// import misc.PeriodLogin;
import concepts.Location;
import concepts.LocationSet;
import concepts.PartOfLocation;
import patient.DiagStart;
import misc.DiagStackEntry;

public class AskSubsets extends HttpServlet {


    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {	
	    PhoneError.call(res, "bevocal", 
			    // "Your session expired while in Ask Subsets."
			    L.AskSubsets1
			    );
	    return;
	}
	call(res, session);
    }

    static public void call (HttpServletResponse res, HttpSession session) 
	throws IOException {

	Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");
	String page = "phone.AskSubsets";
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

	Vector diagStack = (Vector) session.getValue("diagStack");
	DiagStackEntry dse = (DiagStackEntry) diagStack.elementAt(0);
	String bodyPart = dse.getBodyPart();

        LocationSet body = (LocationSet) Common.getLocation(bodyPart);
	Vector subsets = body.getSubsets();
	DB props = (DB) session.getValue("theDB");
	String gender = props.getProperty("gender");
	subsets = DiagStart.filterParts(subsets, gender);
	// add members if any
	Vector members = body.getMembers();
	members = DiagStart.filterParts(members, gender);
	int lng = members.size();
	for (int i = 0; i < lng; i++) subsets.addElement(members.elementAt(i));
	// 0 < # parts !!
	String printName = body.getPrintName();
	// printName = printName.replace(' ', '^');
	StringBuffer sb = new StringBuffer(); // locChoices
	StringBuffer sb2 = new StringBuffer(); // grammarEntries
	lng = subsets.size();
	for (int i = 0; i < lng; i++) {
	    String locName2 = (String) subsets.elementAt(i);
	    Location loc2 = (Location) Common.getLocation(locName2);
	    if ( loc2.hasAsymptom() ) {
		String pn = loc2.getPrintName();
		sb.append("\"" + pn + "\" <break time=\"500ms\"/> ");
		// pn = pn.replace(' ', '^');
		sb2.append("[(" + pn + ")] " +
		           "{<answer3 \"" + pn + "\">" +
			   "<answer2 \"" + locName2 + "\">} \n"); 
	    }
	}
	sb.append( "\"" +
		   //none of them
		   L.noneOfThem +
		   "\"");
	sb2.append("[(" + L.noneOfThem + ")] " +
	           "{<answer3 \"" + L.noneOfThem + "\"> <answer2 \"noneOfThem\">} \n");
	String locChoices = sb.toString();
	String grammarEntries = sb2.toString();

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

"<form id=\"form2\"> \n" + 
	    ( host.equals("bevocal") ?
"            <grammar type=\"application/x-nuance-gsl\"> \n" 
	      :
"            <grammar type=\"text/gsl\"> \n" ) +

"            <![CDATA[AskSubsets[ \n" +
	    grammarEntries +
"           ]]]> \n " +
"            </grammar> \n" +

"	<field name=\"answer3\"  expr=\"'not set'\" /> \n" +

"	<field name=\"answer2\"> \n" +
"            <help><prompt>" +
	                   // Select from the following choices: \n "  +
	                   L.AskBodyPart3 +
"                     <prosody volume=\"loud\"> \n" +
                               locChoices + ". \n" +
"                     </prosody> \n" +
"                  </prompt></help> \n" +
"	     <prompt> \n" +
//"		OK, which subset of the: " + 
	        L.AskSubsets2 +
	        printName + " " +
//"             if any, hinders you the most? \n" +
	        L.AskBodyPart2 +
//"             Select from the following choices: \n" +
	        L.AskBodyPart3 + "\n "  +
"               <prosody volume=\"loud\"> \n" +
	                 locChoices + ". \n" +
"               </prosody> \n" +
"	     </prompt> \n" +

"            <filled> \n" +
"            <if cond=\"answer2 == 'noneOfThem'\"> \n" +
//"                  OK will focus now on: " 
	             L.AskBodyPart4 +
	             printName + ". \n" +
"                  <submit next=\"" + D.servletLocationNarrowedQ + "\" " +
"                          method=\"get\" fetchtimeout=\"60s\"/> \n" +
"            <else/> \n" +
//"                  OK will explore further: " +
	             L.AskLocationS9 +
	           "<value expr=\"answer3\"/>. \n" +
"                  <submit next=\"" + D.servletRefinePartQ + "\" " +
"                          method=\"get\" namelist=\"answer2\" fetchtimeout=\"60s\"/> \n" +
"            </if> \n " +
"            </filled> \n" +
"       </field> \n" +
"    <block> \n" +
"       An error happend in Ask Subsets.  This sentence is not supposed to be reachable!! \n" +
"       <submit next=\"" + D.servletPhoneLogout + "\" " +
"               method=\"get\" fetchtimeout=\"60s\"/> \n" +
"    </block> \n" +
" </form> \n" +
"</vxml>";

	res.setContentType("application/voicexml+xml");
	ServletOutputStream out = res.getOutputStream();

	out.println(xml);

    }
}



