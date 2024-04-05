// Copyright OntoOO Inc, 2003 Dec
package phone;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Zxml extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String bodyPart = req.getParameter("bodyPart");
	String symptom = 
	    (bodyPart.equals("head") ? "headache" : "short of breadth");

	String xml = 

"<?xml version=\"1.0\"?> \n" +
"<!DOCTYPE vxml PUBLIC \"-//BeVocal Inc//VoiceXML 2.0//EN\" \n" +
"	  \"http://cafe.bevocal.com/libraries/dtd/vxml2-0-bevocal.dtd\"> \n" +
"<vxml version=\"2.0\" xmlns=\"http://www.w3.org/2001/vxml\"> \n" +

 
" <property name=\"universals\" value=\"all\" /> \n" +
" <help>I'm sorry. There's no help available here.</help> \n" +
" <noinput>I'm sorry. I didn't hear anything. \n" +
"   <reprompt/> \n" +
" </noinput> \n" +
" <nomatch>I didn't get that. \n" +
"   <reprompt/> \n" +
" </nomatch> \n" +

" <form id=\"form\"> \n" +
"	<field name=\"answer\"> \n" +
"	     <prompt> \n" +
"		Dear user, do you have a " + symptom + "? \n" +
"	     </prompt> \n" +
"            <grammar type=\"application/x-nuance-gsl\"> \n" +
"                  [yes no] \n" +
"            </grammar> \n" +
"            <help> Say yes or no. </help> \n" +
"            <filled> \n" +
"              <if cond=\"(answer == 'yes') \"> \n" +
"                 I am sorry to hear you have a " + symptom + ". \n" +
"                 I hope you have a good insurance. \n" +
"              <else/> \n" +
"                 I am glad to hear you do not have a " + symptom + ". \n" +
"                 Perhaps you do not need health insurance. \n" +
"              </if> \n" +
	    // " 	       <goto next=\"#form2\"/> \n" +
"            </filled> \n" +
"       </field> \n" +
"</form> \n" +
"<form id=\"form2\"> \n" + 
"	<field name=\"answer2\"> \n" +
"	     <prompt> \n" +
"		Do you want to try another test? \n" +
"	     </prompt> \n" +
"            <grammar type=\"application/x-nuance-gsl\"> \n" +
"                  [yes no] \n" +
"            </grammar> \n" +
"            <help> Say yes or no. </help> \n" +
"            <filled> \n" +
"              <var name=\"bodyPart\" expr=\"body\"/> \n" +
"              <if cond=\"(answer2 == 'yes') \"> \n" +
"              <submit \n" +
"	                   next=\"http://healthcheck4me.info/servlet/phone.AskBodyPart\" \n" +
"			   method=\"get\" namelist=\"bodyPart\" \n" +
"			   fetchtimeout=\"60s\"/> \n" +
	    //"                  <goto next=\"application.default2.vxml\"/> \n" +
"              </if> \n" +
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



