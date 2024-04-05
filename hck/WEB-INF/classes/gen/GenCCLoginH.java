// (C) OntoOO Inc 2004
package gen;

import com.D;
import com.L;

import java.io.*;
import java.util.*;
 
public class GenCCLoginH  {

public static void main (String [] arguments) 
    throws Exception     {

    String str =

"<html> $$" +
"<head><title>CC login</title></head> $$" +
"<script language=\"JavaScript\"> $$" +
"function checkFields(form) { $$" +
"	if ( ('' != form.logName.value) && ('' != form.password.value) ) $$" +
"		form.submit(); $$" +
"	else $$" +
"		alert('Enter values in both fields ...'); $$" +
"} $$" +
"function checkSubmit(evt) { $$" +
"     var evt = (evt) ? evt : event; $$" +
"     var charCode = (evt.which) ? evt.which : evt.keyCode; $$" +
"     if ( 13 == charCode ) { $$" +
"        checkFields(document.forms[0]); $$" +
"	return false; $$" +
"     } $$" +
"     return true; $$" +
"} $$" +
"</script> $$" +
"<body bgcolor=\"lightblue\"> $$" +
" $$" +
"<h1 align=\"center\"> $$" +
"   <font color=\"FF0000\" size=\"7\"> $$" +
"      Welcome to Health Angel CC  $$" +
"   </font> $$" +
"</h1> $$" +
" $$" +
"<h3> Please Login: </h3> $$" +
" $$" +
"<form method=\"post\" action=\"" + D.servletCCLogin + "\"> $$" +
"   Login name: <input type=\"text\" size=\"10\" maxlength=\"10\" name=\"logName\" /> $$" +
"   Password: <input type=\"password\" SIZE=\"10\" maxlength=\"10\" name=\"password\" onKeyUp=\"checkSubmit(event)\" /><p> $$" +
" $$" +
"<input type=\"button\" value=\"Submit\" onClick=\"checkFields(this.form)\" /> $$" +
"<input type=\"button\" value=\"Cancel\" onClick=\"history.back()\" /> $$" +
" $$" +
"</form> $$" +
"<hr /> $$" +
" $$" +
"If you want to change your password,  $$" +
"<a href=\"" + D.servletChangePassword0 + "?user=cc\">click here.</a> $$" +
" $$" +
"</body> $$" +
	"</html> $$";

    String name = "CCLoginH";

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


} // end class GenCCLoginH







