// (C) OntoOO Inc 2004
package gen;

import com.D;
import com.L;

import java.io.*;
import java.util.*;
 
public class GenKChatClientInput  {

public static void main (String [] arguments) 
    throws Exception     {

    String str =
"<html> $$" +
"<body bgcolor=\"bbbbbb\"> $$" +
"<script language=\"JavaScript\"> $$" +
"function checkInput(form) { $$" +
"        if ( '' ==  form.clientString.value )  $$" +
"		alert('Please provide input ...'); $$" +
"	else $$" +
"	        form.submit(); $$" +
"} $$" +
"function terminate(form) { $$" +
"       form.clientString.value = '**ClientTerminate**'; $$" +
"       form.submit(); $$" +
"} $$" +
"</script> $$" +
"<form action=\"" + D.servletKChatClientInput + "\"> $$" +
"<input type=\"text\" name=\"clientString\" value=\"\" size=\"80\" maxlength=\"80\" /> $$" +
"<p> $$" +
	//"<input type=\"button\" value=\"Send to CallCenter\"  $$" +
"<input type=\"button\" value=\"" + L.kCCIS1 + "\"  $$" +
"	onClick=\"checkInput(this.form)\" /> $$" +
	//"<input type=\"button\" value=\"Terminate Chat Session/Cancel\"  $$" +
"<input type=\"button\" value=\"" + L.kCCIS2 + "\"  $$" +
"        onClick=\"terminate(this.form)\" /> $$" +
"</form> $$" +
"<script language=\"JavaScript\"> document.forms[0].clientString.focus(); </script> $$" +
" $$" +
"</body> $$" +
"</html> $$";


    String name = "KChatClientInputH";
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


} // end class GenKChatClientInput




