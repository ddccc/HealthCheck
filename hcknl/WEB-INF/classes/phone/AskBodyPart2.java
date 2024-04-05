// Copyright OntoOO Inc, 2004 Jan
package phone;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.D;
import com.LR;
import misc.DB;
import misc.PeriodLogin;
import concepts.Location;
import concepts.LocationRelation;
import concepts.PartOfLocation;
import patient.DiagStart;


public class AskBodyPart2 extends HttpServlet {


    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {

	String bodyPart = "body";
        Location body = Common.getLocation(bodyPart);
	Vector parts = body.getParts();
	String gender = LR.male;
	parts = DiagStart.filterParts(parts, gender);

	// 1 < # parts !!
	String printName = body.getPrintName();
	printName = printName.replace(' ', '^');
	StringBuffer sb = new StringBuffer(); // locChoices
	StringBuffer sb2 = new StringBuffer(); // grammarEntries
	int lng = parts.size();
	for (int i = 0; i < lng; i++) {
	    String locName2 = (String) parts.elementAt(i);
	    PartOfLocation loc2 = (PartOfLocation) Common.getLocation(locName2);
	    if ( loc2.hasAsymptom() ) {
		String pn = loc2.getPrintName();
		sb.append("\"" + pn + "\" <break time=\"500ms\"/> ");
		pn = pn.replace(' ', '^');
		sb2.append("[" + pn + "]{<answer2 \"" + locName2 + "\">} \n"); 
	    }
	}
	sb.append("\"none of them\"");
	sb2.append("[none^of^them]{<answer2 \"noneOfThem\">} \n");
	String locChoices = sb.toString();
	String grammarEntries = sb2.toString();
	String xml = 

"<?xml version=\"1.0\"?> \n" +
"<!DOCTYPE vxml PUBLIC \"-//BeVocal Inc//VoiceXML 2.0//EN\" \n" +
"	  \"http://cafe.bevocal.com/libraries/dtd/vxml2-0-bevocal.dtd\"> \n" +
"<vxml version=\"2.0\" xmlns=\"http://www.w3.org/2001/vxml\"> \n" +
 
	    // " <property name=\"universals\" value=\"all\" /> \n" +
" <help>I'm sorry. There's no help available here.</help> \n" +
" <noinput>I'm sorry. I didn't hear anything. \n" +
"   <reprompt/> \n" +
" </noinput> \n" +
" <nomatch>I didn't get that. \n" +
"   <reprompt/> \n" +
" </nomatch> \n" +

"<form id=\"form2\"> \n" + 
"	<field name=\"answer2\"> \n" +
"            <help><prompt> Select from the following: \n "  +
"                     <prosody volume=\"loud\"> \n" +
                               locChoices + ". \n" +
"                     </prosody> \n" +
"                  </prompt></help> \n" +
"	     <prompt> \n" +
"		OK, which part of your: " + printName + " if any, hinders you the most? \n" +
"               Select from the following choices: \n" +
"               <prosody volume=\"loud\"> \n" +
	                 locChoices + ". \n" +
"               </prosody> \n" +
"	     </prompt> \n" +
"            <grammar type=\"application/x-nuance-gsl\"> \n" +
"            <![CDATA[[ \n" +
	    grammarEntries +
"           ]]]> \n " +
"            </grammar> \n" +
"            <filled> \n" +
"                  OK will explore further: <value expr=\"answer2\"/>. \n" +
"            </filled> \n" +
"       </field> \n" +
"    <block> \n" +
"       Thanks for trying Health Check.  Bye now!! \n" +
"    </block> \n" +
" </form> \n" +
"</vxml>";





	res.setContentType("application/voicexml+xml");
	ServletOutputStream out = res.getOutputStream();

	out.println(xml);

    }
}



