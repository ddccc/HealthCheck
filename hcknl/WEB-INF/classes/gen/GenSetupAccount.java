// (C) OntoOO Inc 2004
package gen;

import com.D;
import com.L;

import java.io.*;
import java.util.*;
 
public class GenSetupAccount {

public static void main (String [] arguments) 
    throws Exception     {

    String str = 
"<html> $$" +
"<head><title>" + L.SetupAccount + "</title> $$" +
D.linkHckStyle +
D.favicon +
"</head> $$" +

" $$" +
"<body> $$" +
"<font color=\"#850a0a\"  size=\"+2\"> $$" +
" $$" +
"<h1 align=\"center\"> $$" +
"   <font color=\"#1C5540\" size=\"7\"> $$" +
"      " + L.SetupAccount + " $$" +
"   </font> $$" +
"</h1> $$" +
" $$" +
" $$" +
	//"The system does not 'know' you ... <br /> $$" +
L.SetupAccountS1 + "<br /> $$" +
	//"To setup your account you have to answer first a questionaire.<br /> $$" +
L.SetupAccountS2 + "<br /> $$" +
	//"The more details you provide the more specific will be the information $$" +
	//"that can be generated for you.<br /> $$" +
L.SetupAccountS3 + "<br /> $$" +
	//"If you have concerns regarding privacy, please contact your provider. $$" +
L.SetupAccountS4 + " $$" +
"<p> $$" +
	//"To proceed <A href='/start.html'>click here.</A> $$" +
L.ToProceed + " <a href=\"" + D.startHtml + "\">" + L.Setup3S3 + "</a> $$" +
"<hr /> $$" +
" $$" +
"<form> $$" +
"<input type=\"button\" value=\"Cancel\" onClick=\"history.back()\" /> $$" +
"</form> $$" +
" $$" +
" $$" +
"</font> $$" +
"</body> $$" +
"</html> $$";

    String name = "SetupAccount";

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


} // end class GenSetupAccount










