// (C) OntoOO Inc 2004
package gen;

import com.D;
import com.L;


import java.io.*;
import java.util.*;
 
public class GenHelp  {

public static void main (String [] arguments) 
    throws Exception     {

    String str =
"<html> $$" +
"<head><title>" + L.HELP + "</title> $$" +
D.linkHckStyle +
D.favicon +
"</head> $$" +
" $$" +
"<body> $$" +
" $$" +
"<font color=\"#1C5540\"> $$" +
"<h1>" + L.HELP + "</h1> $$" +
"</font> $$" +
" $$" +
"<font color=\"#850a0a\" size=\"4\"> $$" +
" $$" +
"<p><b>" + L.Problem + "</b> $$" +
	//"<i>I have trouble with creating an anonymous account.</i> $$" +
"<i>" + L.helpS1 + "</i> $$" +
"<br /><b>A:</b>  $$" +
	//"Sorry for that.  Here an $$" +
	//"example:<br /> $$" +
L.helpS2 + "<br /> $$" +
	//"- Click on the link: First time visitor: Create first an anonymous  $$" +
	//"account<br /> $$" +
L.helpS3 + "<br /> $$" +
	//"- Type in, for example: name23<br /> $$" +
L.helpS4 + "<br /> $$" +
	//"- This creates the account name23 with password name23<br /> $$" +
L.helpS5 + "<br /> $$" +
	//"- Proceed with the setup using name23 and name23<br /> $$" +
L.helpS6 + "<br /> $$" +
	//"- When the setup is completed login with name23 and name23<br /> $$" +
L.helpS7 + "<br /> $$" +
	//"Yes, you can also change your password. $$" +
L.helpS8 + " $$" +
" $$" +
"<p><b>" + L.Problem + "</b> $$" +
	//"<i>I cannot login.</i> $$" +
"<i>" + L.helpS9 + "</i> $$" +
"<br /><b>A:</b>  $$" +
	//"Did you create first an anonymous account?<br /> $$" +
L.helpS10 + "<br /> $$" +
L.IfNot + "<a href=\"" + D.servletCreateAnonymousAccount + "\"> $$" +
	//"Create an anonymous account</a>  $$" +
L.helpS11 + "</a> $$" +
" $$" +
"<p><b>" + L.Problem + "</b> $$" +
	//"<i>I forgot my password.</i> $$" +
"<i>" + L.helpS12 + "</i> $$" +
"<br /><b>A:</b>  $$" +
	//"If you are willing to disclose your email address then provide also your  $$" +
	//"user name and describe when you created the account, how many sessions you  $$" +
	//"think you had and things that you entered when you setup the account and  $$" +
	//"send this to: $$" +
L.helpS13 + " $$" +
"<a href=\"" + D.SendMailHtml + "\"> $$" +
	//"ask for my password. $$" 
L.helpS14 + " $$" +
"</a> <br /> $$" +
	//"Otherwise just create another account - with a different user name of course. $$" +
L.helpS15 + " $$" +
" $$" +
"<p><b>" + L.Problem + "</b> $$" +
	//"<i>I get a pink page that tells me that I cannot login twice.</i> $$" +
"<i>" + L.helpS16 + "</i> $$" +
"<br /><b>A:</b>  $$" +
	//"That's right. There are several possibilities:<br /> $$" +
L.helpS17 + "<br /> $$" +
	//"-- You interrupted the setup of your account and went to another site. Try: $$" +
L.helpS18 + " $$" +
	//"<a href='" + D.killSessionHtml + "'>" + L.killSession + "</a> and do a login, $$" +
"<a href=\"" + D.killSessionHtml + "\">" + L.killSession + "</a> " + L.helpS19 + " $$" +
	//"which will restart the account setup process.<br /> $$" +
L.helpS20 + "<br /> $$" +
	//"-- You are logged in with the <i>same browser</i> as yourself or as $$" +
	//"another user.  $$" +
L.helpS21 + " <i>" + L.helpS22 + "</i> " + L.helpS23 + " $$" +
	//"If you are already logged in as yourself, why logging in again?  You cannot.  $$" +
	//"If you are logged in as another user, logout first.<br /> $$" +
L.helpS24 + "<br /> $$" +
	//"-- You are logged in with <i>another browser.</i>  Well, you cannot and $$" +
	//"why login twice in the first place?<br /> $$" +
L.helpS25 + " <i>" + L.helpS26 + "</i> " + L.helpS27 + "<br /> $$" +
	//"-- You are logged in on <i>another machine.</i>  Logout first.  You $$" +
	//"are at home and the other machine is at work?  Try: $$" +
L.helpS28 + " <i>" + L.helpS29 + "</i> " + L.helpS30 + " $$" +
"<a href=\"" + D.killSessionHtml + "\"> " + L.killSession + "</a> $$" +
	//"or you will be logged out when the server reboots: 12 noon and midnight PST. <br /> $$" +
L.helpS31 + "<br /> $$" +
	//"-- Someone else is using your account. Try:  $$" +
L.helpS32 + " $$" +
"<a href=\"" + D.killSessionHtml + "\"> " + L.killSession + "</a> $$" +
	//"and change your password as soon as you can login again.<br />  $$" +
L.helpS33 + "<br /> $$" +
	//"-- Hmmm.  You mean the previous five cases do not apply? $$" +
	//"Sorry to hear that.  Please let us know how you got in this pickle:<br />  $$" +
L.helpS34 + "<br /> $$" +
"<a href=\"" + D.SendMailHtml + "\"> $$" +
	//"yeah, there is something else happening ... $$" 
L.helpS35 + " $$" +
"</a> $$" +
" $$" +
"<p><b>" + L.Problem + "</b> $$" +
	//"<i>I have another problem.</i> $$" +
"<i>" + L.helpS36 + "</i> $$" +
"<br /><b>A:</b>  $$" +
	//"Sorry to hear that.  Please let us know:  $$" +
L.helpS37 + " $$" +
"<a href=\"" + D.SendMailHtml + "\"> $$" +
	//"yes, I have another problem ... $$" +
L.helpS38 + " $$" +
"</a> $$" +
" $$" +
" $$" +
"<form> $$" +
"<input type=\"button\" value=\"Back\" onClick=\"history.back()\" />  $$" +
"<input type=\"button\" value=\"Home\" onClick=\"location='" + D.indexHtml + "'\" /> $$" +
"</form> $$" +
" $$" +
"</font> $$" +
"</body> $$" +
"</html> $$";


    File genOut = new File("GenHtmlDir/help.html");
    FileOutputStream fosStr = new FileOutputStream(genOut);
    PrintWriter psStr = new PrintWriter(fosStr);

    StringTokenizer st = new StringTokenizer(str, "$$");
    while ( st.hasMoreTokens() )
	psStr.println(st.nextToken());

    psStr.flush();     psStr.close();

} // end of main

} // end class GenFaq


