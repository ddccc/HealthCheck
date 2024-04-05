// Copyright OntoOO Inc, 2003 Dec
package phone;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GenInit extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String xml = 

"<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +
"<!DOCTYPE vxml PUBLIC '-//Nuance/DTD VoiceXML 1.0//EN' \n" +
"          'http://voicexml.nuance.com/dtd/nuancevoicexml-1-2.dtd'> \n" +
"<vxml version=\"2.0\"> \n" +

" <property name=\"universals\" value=\"all\" /> \n" +
" <help>I'm sorry. There's no help available here.</help> \n" +
" <noinput>I'm sorry. I didn't hear anything. \n" +
"   <reprompt/> \n" +
" </noinput> \n" +
" <nomatch>I didn't get that. \n" +
"   <reprompt/> \n" +
" </nomatch> \n" +
" <form id=\"form\"> \n" +
"   <field name=\"logName\" type=\"digits?minlength=3;maxlength=3\"> \n" +
"      <prompt> \n" +
"          Welcome to Health Check's phone advice line. \n" +
"          If you have a life threatening condition:  \n" +
"          Call nine-one-one or go to the nearest hospital. \n" +
"	   To login please say three digits. \n" +
"      </prompt> \n" +
"   </field> \n" +
"   <filled> \n" +
"   <submit \n" +
"       next=\"http://www.healthcheck4me.info/hck/servlet/phone.PhoneLogin\" \n" +
"			   method=\"post\" namelist=\"logName\" \n" +
"			   fetchtimeout=\"60s\"/> \n" +
"   </filled> \n" +
" </form> \n" +
"</vxml>";





	res.setContentType("application/voicexml+xml");
	ServletOutputStream out = res.getOutputStream();

	out.println(xml);

    }
}



