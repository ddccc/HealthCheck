// (C) OntoOO Inc 2004
package gen;

import com.D;
import com.L;


import java.io.*;
import java.util.*;
 
public class GenKChatCPersonInput  {

public static void main (String [] arguments) 
    throws Exception     {

    String str =
"<html> $$" +
"<body bgcolor=\"bbbbbb\"> $$" +
"<script language=\"JavaScript\"> $$" +
"function checkInput(form) { $$" +
"        if ( '' ==  form.cpersonString.value )  $$" +
"		alert('Please provide input ...'); $$" +
"	else $$" +
"	        form.submit(); $$" +
"} $$" +
"function terminate(form) { $$" +
"        form.cpersonString.value = '**CPersonTerminate**'; $$" +
"        form.submit(); $$" +
"} $$" +
"</script> $$" +
" $$" +
"<form action=\"" + D.servletKChatCPersonInput + "\"> $$" +
"<input type=\"text\" name=\"cpersonString\" value=\"\" size=\"80\" maxlength=\"80\" /> $$" +
"<p> $$" +
	//"<input type=\"button\" value=\"Send to Client\"  $$" +
"<input type=\"button\" value=\"" + L.kCCPIS1 + "\"  $$" +
"	onClick=\"checkInput(this.form)\" /> $$" +
	//"<input type=\"button\" value=\"Terminate Chat Session/Cancel\"  $$" +
"<input type=\"button\" value=\"" + L.kCCIS2 + "\"  $$" +
"       onClick=\"terminate(this.form)\" /> $$" +
"</form> $$" +
"<script language=\"JavaScript\"> document.forms[0].cpersonString.focus(); </script> $$" +
" $$" +
"</body> $$" +
"</html> $$";


    File genOut = new File("GenHtmlDir/kChatCPersonInput.html");

    FileOutputStream fosStr = new FileOutputStream(genOut);
    PrintWriter psStr = new PrintWriter(fosStr);

    StringTokenizer st = new StringTokenizer(str, "$$");
    while ( st.hasMoreTokens() )
	psStr.println(st.nextToken());

    psStr.flush();     psStr.close();

} // end of main

} // end class GenFaq


