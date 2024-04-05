// (C) OntoOO Inc 2004
package gen;

import com.D;
import com.L;

import java.io.*;
import java.util.*;
 
public class GenFaq   {

public static void main (String [] arguments) 
    throws Exception     {

    String str =
"<html> $$" +
"<head><title>FAQ</title> $$" +
D.linkHckStyle +
D.favicon +
"</head> $$" +
" $$" +
"<body> $$" +
"<font color=\"#850a0a\"> $$" +
" $$" +
	//"<H1> Frequently Asked Questions</H1> $$" +
"<h1>" + L.faqS1 + "</h1> $$" +
"<font size=\"4\"> $$" +
" $$" +
"<p><b>Q:</b> $$" +
	//"What can I do with this site? $$" +
L.faqS2 + " $$" +
"<br /><b>A:</b>  $$" +
	//"You can do a self-diagnosis based on the answers you give.  It is $$" +
	//"actually a pre-diagnosis because the program cannot see you, touch $$" +
	//"you, do lab test, x-ray's, etc.<br /> $$" +
L.faqS3 + "<br /> $$" +
	//"You can also track your weigth.<br /> $$" +
L.faqS4 + "<br /> $$" +
	//"And you can search the build-in medical "knowledge" and go $$" +
	//"transparently into the WWW. $$" +
L.faqS5 + " $$" +
" $$" +
"<p><b>Q:</b> $$" +
	//"Do I have to login?" $$" +
L.faqS6 + " $$" +
"<br /><b>A:</b>  $$" +
	// "Only if you want to want to come back. " +
	// "The system can use the 'history' in subsequent sessions.<br />"
L.faqS7 + "<br /> $$" +
	//"Of course you also can look into the history."
L.faqS8 + " $$" +
" $$" +
"<p><b>Q:</b> $$" +
	//"How long does it take to set up an anonymous account? $$" +
L.faqS9 + " $$" +
"<br /><b>A:</b>  $$" +
	//"Two minutes at most. $$" +
L.faqS10 + " $$" +
" $$" +
"<p><b>Q:</b> $$" +
	//"Is an anonymous account really anonymous? $$" +
L.faqS11 + " $$" +
"<br /><b>A:</b>  $$" +
	//"Yes! Just create an account name that does not identify yourself.  $$" +
	//"The system does not ask you anything that can be used to identify $$" +
	//"you.  It is wise to change the password that is given to you, but even $$" +
	//"if you do not change it then noone can get at you.  They can only mess up $$" +
	//"your history. $$" +
L.faqS12 + " $$" +
" $$" +
"<p><b>Q:</b> $$" +
	//"What can I do if - during self-diagnosis - I realize that a previously $$" +
	//"clicked in symptom is wrong? $$" +
L.faqS13 + " $$" +
"<br /><b>A:</b>  $$" +
	//"Just use the back-button and correct your mistake.  In fact you can go $$" +
	//"all the way back to the start diagnostic page and start over again. $$" +
L.faqS14 + " $$" +
" $$" +
	// HON code additions
"<p><b>Q:</b> $$" +
L.faqS15 + " $$" +
"<br /><b>A:</b>  $$" +
L.faqS16 + " $$" +
" $$" +
"<p><b>Q:</b> $$" +
L.faqS17 + " $$" +
"<br /><b>A:</b>  $$" +
L.faqS18 + " $$" +
" $$" +
"<p><b>Q:</b> $$" +
L.faqS19 + " $$" +
"<br /><b>A:</b>  $$" +
L.faqS20 + " $$" +
" $$" +

"</font> $$" +
"<form> $$" +
"<input type=\"button\" value=\"Back\" onClick=\"history.back()\" />  $$" +
"<input type=\"button\" value=\"Home\" onClick=\"location='" + D.indexHtml + "'\" /> $$" +
"</form> $$" +
" $$" +
"</body> $$" +
"</html> $$";


    File genOut = new File("GenHtmlDir/faq.html");
    FileOutputStream fosStr = new FileOutputStream(genOut);
    PrintWriter psStr = new PrintWriter(fosStr);

    StringTokenizer st = new StringTokenizer(str, "$$");
    while ( st.hasMoreTokens() )
	psStr.println(st.nextToken());

    psStr.flush();     psStr.close();

} // end of main

} // end class GenFaq


