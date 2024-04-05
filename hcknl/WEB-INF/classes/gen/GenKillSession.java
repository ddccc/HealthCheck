// (C) OntoOO Inc 2004
package gen;

import com.D;
import com.L;

import java.io.*;
import java.util.*;
 
public class GenKillSession  {

public static void main (String [] arguments) 
    throws Exception     {

    String str =
"<html> $$" +
"<head><title>" + L.KillSession + "</title> $$" +
D.linkHckStyle +
D.favicon +
"</head> $$" +
"<script language=\"JavaScript\"> $$" +
"function checkFields(form) { $$" +
"	if ( ('' != form.logName.value) && ('' != form.password.value) ) $$" +
"		form.submit(); $$" +
"	else $$" +
"		alert('Enter values in both fields ...'); $$" +
"} $$" +
"</script> $$" +
"<body bgcolor=\"yellow\"> $$" +
" $$" +
"<h1 align=\"center\"> $$" +
"   <font color=\"FF0000\" size=\"7\"> $$" +
"      " + L.KillSession + " $$" +
"   </font> $$" +
"</h1> $$" +
" $$" +
"<form action=\"" + D.servletSUKillSession + "\"> $$" +
"   Login name: <input type=\"text\" size=\"10\" maxlength=\"10\" name=\"logName\" /> $$" +
"   Password: <input type=\"password\" size=\"10\" maxlength=\"10\" name=\"password\" /><p> $$" +
"<input type=\"button\" value=\"Submit\" onClick=\"checkFields(this.form)\" /> $$" +
"</form> $$" +
"<script language=\"JavaScript\"> document.forms[0].logName.focus(); </script> $$" +
"<hr> $$" +
" $$" +
"<form> $$" +
"<input type=\"button\" value=\"Back\" onClick=\"history.back()\" />  $$" +
"<input type=\"button\" value=\"Home\" onClick=\"location='" + D.indexHtml + "'\" /> $$" +
"</form> $$" +
" $$" +
"</body> $$" +
"</html> $$";


    File genOut = new File("GenHtmlDir/killSession.html");

    FileOutputStream fosStr = new FileOutputStream(genOut);
    PrintWriter psStr = new PrintWriter(fosStr);

    StringTokenizer st = new StringTokenizer(str, "$$");
    while ( st.hasMoreTokens() )
	psStr.println(st.nextToken());

    psStr.flush();     psStr.close();

} // end of main

} // end class GenFaq


