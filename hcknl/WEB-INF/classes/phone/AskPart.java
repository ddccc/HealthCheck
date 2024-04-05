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
// import concepts.LocationRelation;
// import concepts.PartOfLocation;
import patient.DiagStart;
import misc.DiagStackEntry;

public class AskPart extends HttpServlet {


    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    PhoneError.call(res, "bevocal", 
			    // "Your session expired while in Ask Part."
			    L.AskPart1
			    );
	    return;
	}
	call(res, session);
    }

    static public void call(HttpServletResponse res, HttpSession session) 
	throws IOException {

	Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");
	String page = "phone.AskPart";
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

        Location body = Common.getLocation(bodyPart);
	String printName = body.getPrintName();
	String lexiconEntry = ( 0 < printName.indexOf(' ') ?
				"(" + printName + ")" :
				printName );

	// generate help 
	Vector parts = body.getParts();
	DB props = (DB) session.getValue("theDB");
	String gender = props.getProperty("gender");
	parts = DiagStart.filterParts(parts, gender);
	StringBuffer sb = new StringBuffer(
            "<help><prompt>" +
	    // "If you say \"a part\" you can then later select from the following: "
	    L.AskPart2
	    );
	int lng = parts.size();
	for (int i = 0; i < lng; i++) {
	    String aPart = (String) parts.elementAt(i);
	    Location loc = Common.getLocation(aPart);
	    String pn = loc.getPrintName();
	    sb.append("<break time=\"500ms\"/> " + pn + ", ");
	}
	sb.append(
		  //"Just say: " +
		  L.AskPart3 +
		  "\"" + printName + "\"" + 
		  // " if you do <emphasis level=\"strong\"> not </emphasis> want to zoom in further. " +
		  L.AskPart4 +
		  "</prompt></help>");
	String helpString = sb.toString();

	String host = (String) session.getValue("host");

	String xml = 
"<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +

	    ( host.equals("bevocal") ?
	      L.vxml1
	      :
	      L.vxml2 ) +

	    // " <property name=\"universals\" value=\"all\" /> \n" +
" <help>" +
//"I'm sorry. There's no help available here.
L.noHelp +
"</help> \n" +
" <noinput>" +
	    // I'm sorry. I didn't hear anything. \n" +
L.silence +
"   <reprompt/> \n" +
" </noinput> \n" +
" <nomatch>" +
	    //I didn't get that. \n" +
L.nomatch +
"   <reprompt/> \n" +
" </nomatch> \n" +
" <form id=\"bodyPart\"> \n" +
"	<field name=\"answer\"> \n" +
             helpString +
"	     <prompt> \n" +
//"               Are you bothered by a distinct part of your " +
	        L.AskPart5 +
"               \"" + printName + "\" \n" +
//"               or does your problem concerns your whole " +
	        L.AskPart6 +
"               \"" + printName + "\"? \n" +
//"               If you are focussed on a part of your " +
	        L.AskPart7 +
"               \"" + printName + "\" \n" +
//"               say: \"a part\". \n" +
	        L.AskPart8 +
//"               Otherwise say: "
	        L.AskPart9 +
"               \"" + printName + "\". \n" + 
//"               Say \"help\" to hear the choices you will get after you say \"a part\". \n" +
	        L.AskPart10 +
"	     </prompt> \n" +

	    ( host.equals("bevocal") ?
"            <grammar type=\"application/x-nuance-gsl\"> \n" 
	      :
"            <grammar type=\"text/gsl\"> \n" ) +

"            <![CDATA[ \n" +
"      AskPart[ \n " +

//"              [ (a part) ] {<answer \"aPart\">} \n" +
	        L.AskPart11 +
"              [ " + lexiconEntry + " ] {<answer \"" + bodyPart + "\">} \n" +
"             ]]]> \n " +
"            </grammar> \n" +
"            <filled> \n" +
"              <if cond=\"(answer == 'aPart') \"> \n" +
"	          <prompt> \n" +
//"                 OK, will explore parts of your: " +
	        L.AskPart12 +
"	           \"" + printName + "\". \n" +
"	          </prompt> \n" +
"                 <submit next=\"" + D.servletAskBodyPart + "\" " +
"  method=\"get\" fetchtimeout=\"60s\"/> \n" +
"              <else/> \n" +
"	          <prompt> \n" +
//"                 OK, will concentrate on your: " +
	            L.AskPart13 +
"                 \"" + printName + "\". \n" +
"	          </prompt> \n" +
"                 <submit next=\"" + D.servletLocationNarrowedQ + "\" " +
"  method=\"get\" fetchtimeout=\"60s\"/> \n" +
"              </if> \n" +
"            </filled> \n" +
"       </field> \n" +
"</form> \n" +
"</vxml>";

	res.setContentType("application/voicexml+xml");
	ServletOutputStream out = res.getOutputStream();

	out.println(xml);

    }
}



