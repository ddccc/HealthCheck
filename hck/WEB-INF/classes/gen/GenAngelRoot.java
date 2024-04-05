// (C) OntoOO Inc 2004
package gen;

import com.D;
import com.L;


import java.io.*;
import java.util.*;
 


public class GenAngelRoot   {

public static void main (String [] arguments) 
    throws Exception     {

    String str =
"<html> $$" +
"<head><title>" + L.AngelRoot + "</title>$$" +
	// "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + D.hckStyle + "\" /> $$" +
D.linkHckStyle +
D.favicon +
"</head> $$" +
	/*
"<script language=\"JavaScript\"> $$" +
"function logout(form) { $$" +
"   form.action = '" + D.servletUserLogout + "'; $$" +
"   form.method = 'get'; $$" +
"   form.submit(); $$" +
"} $$" +
"</script> $$" +
	*/
" $$" +
"<body> $$" +
"<font color=\"#850a0a\"> $$" +
" $$" +
	//"<form> $$" +
"<form action=\"" + D.servletUserLogout + "\"> $$" +
	/*
"<table width=\"100%\"> $$" +
"<tr><td> $$" +
"    <img align=\"left\" height=\"34\" width=\"75\" border=\"1\" src=\"" + D.logoJpg + "\" $$" +
"         onClick=\"alert('HC4M is a product of OntoOO Inc.  Visit: www.ontooo.com')\" /></td>  $$" +
"<td align=\"left\"> $$" +
"<font color=\"#1C5540\" Size=\"4\"> $$" +
	// "<b>Your Health Angel At Your Service!</b> $$" +
"<b>" + L.AngelRootS1 + "</b> $$" +
"</font> $$" +
"</td><td align=\"right\"> $$" +
"<input type=\"button\" value=\"Logout\" onClick=\"logout(this.form)\" /> $$" +
"</td></tr> $$" +
"</table> $$" +
	*/
D.leftHeading + " $$" +
L.AngelRootS1 + " $$" +
D.rightHeading + " $$" +
"</form> $$" +
" $$" +
" $$" +
"<font size=\"+1\"> $$" +
" $$" +
"<h2> $$" +
"<font size=\"4\">" + L.Select + "</font>  $$" +
"<font color= \"#1C5540\" size=\"5\"><blink> " + L.ONE + " </blink></font>  $$" +
"<font size=\"4\">" + L.ofThese + " :::::::</font> $$" +
"</h2> $$" +
" $$" +
"<table border=\"1\" width=\"100%\"> $$" +
"<tr><td><font color=\"#850a0a\" size=\"4\">" + L.HealthScreen + "</td> $$" +
"<td><ul><font size=\"4\"> $$" +
	// "<li> <a href=\"" + D.servletDiagStart +"\">" + "What Disease Could I Have?</a> $$" +
"<li> <a href=\"" + D.servletDiagStart +"\">" + L.AngelRootS2 + "</a> $$" +
"<li> <a href=\"" + D.servletDiagStart2 +"\">" + L.AngelRootS2b + "</a> $$" +
"<li> <a href=\"" + D.servletDiagShow + "\"> $$" +
	// "Show the Details of a Suspected Disease (More for Experts)</a> $$" +
L.AngelRootS3 + "</a> $$" +
"</ul></td></tr> $$" +
"<!-- $$" +
"<li> <a href=\"/Explain.html\"> $$" +
"Explain and/or clarify proposed or scheduled intervention <i>(Not $$" +
"active)</i></a> $$" +
"<hr> $$" +
"--> $$" +
" $$" +
"<tr><td><font color=\"#850a0a\" size=\"4\">" + L.WeightProgram + "</td> $$" +
"<td><ul><font size=\"4\"> $$" +
	//"<li> <a href=\"" + D.ProgWeightHtml + "\">Enter Today\"s Weight</a> $$" +
"<li> <a href=\"" + D.ProgWeightHtml + "\">" + L.AngelRootS4 + "</a> $$" +
	//"<li> <a href=\"" + D.GetTargetWeightHtml + "\">Enter/Change my Target Weight</a> $$" +
"<li> <a href=\"" + D.GetTargetWeightHtml + "\">" + L.AngelRootS5 + "</a> $$" +
	//"<li> <a href=\"" + D.servletShowWeightGraph + "\">Display my Weight Graph</a> $$" +
"<li> <a href=\"" + D.servletShowWeightGraph + "\">" + L.AngelRootS6 + "</a> $$" +
	//"<li> <a href=\"" + D.servletGetBMIInput + "\">Calculate my Body Mass Index</a> $$" +
"<li> <a href=\"" + D.servletGetBMIInput + "\">" + L.AngelRootS7 + "</a> $$" +
"</ul></td></tr> $$" +
" $$" +
	/*
"<!-- $$" +
"<li> <a href="/ProgDiet.html">Diet Management Program <i>(Not active)</i></a> $$" +
"<hr> $$" +
"--> $$" +
	*/
" $$" +
"<tr><td><font color=\"#850a0a\" size=\"4\">" + L.Miscellaneous + "</td> $$" +
"<td><ul><font size=\"4\"> $$" +
	//"<li> <a href=\"" + D.servletHistory + "\">Show Medical History</a> $$" +
"<li> <a href=\"" + D.servletHistory + "\">" + L.AngelRootS8 + "</a> $$" +
	//"<li> <a href=\"" + D.servletAdmin + "\">Show/ Modify Miscellaneous Stuff </a> $$" +
	//"<li> <a href=\"" + D.servletInfo + "\">Search For/ Explain</a> $$" +
"<li> <a href=\"" + D.servletInfo + "\">" + L.AngelRootS9 + "</a> $$" +
	//"<li> <a href=\"" + D.servletDebug + "\">Debug <i>(Ignore)</i></a> $$" +
"</ul></td></tr> $$" +
"</table> $$" +
" $$" +
"</font> $$" +
" $$" +
" $$" +
"<script language=\"JavaScript\" src=\"" + D.kangelJs + "\"></script> $$" +
" $$" +
"</font> $$" +
"</body> $$" +
	"</html> $$";

    String name = "AngelRoot";

    File genOut = new File("GenHtmlDir/" + name + ".java");
    FileOutputStream fosStr = new FileOutputStream(genOut);
    PrintWriter psStr = new PrintWriter(fosStr);

    psStr.println("// (C) OntoOO Inc 2004 Mar");
    psStr.println("package htmls;");
    psStr.println();
    psStr.println(
       "import java.io.*; \n" +
       "import javax.servlet.*; \n" +
       "import javax.servlet.http.*; \n" +
       "import java.util.*; \n" +
       " \n" +
       "public class " + name + " extends HttpServlet { \n" +
       "   public void doGet (HttpServletRequest req, \n" +
       "                      HttpServletResponse res) \n" +
       "       throws ServletException, IOException { \n" +
       "     call(res); \n" +
       "} \n" +
       " \n" +
       "static public void call(HttpServletResponse res) \n" +
       "    throws IOException { \n" +
       "    res.setContentType(\"text/html\"); \n" +
       "    ServletOutputStream out = res.getOutputStream(); \n" +
       "    String str = \n");
    psStr.println();

    StringTokenizer st = new StringTokenizer(str, "$$");
    String token;
    while ( st.hasMoreTokens() ) {
	token = st.nextToken();
	int idx = token.indexOf('\n');
	if (0 <= idx) { 
	    // System.out.println("{{{{Found: " + token + " }}}}");
	    StringTokenizer st2 = new StringTokenizer(token, "\n");
	    while ( st2.hasMoreTokens() ) {
		token = st2.nextToken();
		// System.out.println(token);
		psStr.println("\"" + fix(token) + " \\n\"  +");
	    }
	    // System.out.println("|||||||");
	}
	psStr.println("\"" + fix(token) + " \\n\"  +");
    }



    psStr.println("\"\";");
    psStr.println("   out.println(str); \n");
    psStr.println("}}");

    psStr.flush();     psStr.close();

} // end of main

    static public String fix(String str) {
	int idx = str.indexOf('"');
	if ( idx < 0 ) return str;
	return str.substring(0,idx) + "\\\"" + fix(str.substring(idx+1));
    }

} // end class GenAngelRoot


