// (C) OntoOO Inc 2006 Jul
package htmls;

import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.util.*; 
 
public class Angel extends HttpServlet { 
   public void doGet (HttpServletRequest req, 
                      HttpServletResponse res) 
       throws ServletException, IOException { 
     call(res, "", ""); 
} 
 
static public void call(HttpServletResponse res, String logName, String password) 
    throws IOException { 
    res.setContentType("text/html"); 
    ServletOutputStream out = res.getOutputStream(); 
    String str1 = 


"<html>  \n"  +
"<head><title>Health Check Login</title>  \n"  +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"/hcknl/hckStyle.css\" /><link rel=\"shortcut icon\" href=\"/hcknl/favicon.ico\" type=\"image/x-icon\" /></head>  \n"  +
"<script language=\"JavaScript\">  \n"  +
"function checkFields(form) {  \n"  +
"	if ( (\"\" != form.logName.value) && (\"\" != form.password.value) )  \n"  +
"		form.submit();  \n"  +
"	else  \n"  +
"		alert('Enter values in both fields ...');  \n"  +
"}  \n"  +
"function checkSubmit(evt) {  \n"  +
"     var evt = (evt) ? evt : event;  \n"  +
"     var charCode = (evt.which) ? evt.which : evt.keyCode;  \n"  +
"     if ( 13 == charCode ) {  \n"  +
"        checkFields(document.forms[0]);  \n"  +
"	return false;  \n"  +
"     }  \n"  +
"     return true;  \n"  +
"}  \n"  +
"function testPopUp() {  \n"  +
"   var features = 'directories=no,location=no,menubar=no,status=no';  \n"  +
"   features += 'titlebar=no,toolbar=no,hotkeys=no';  \n"  +
"   features += 'scrollbars=no,width=200,height=100,resizeable=no';  \n"  +
"   newWin = open('', 'myDoc', features);  \n"  +
"   newWin.document.writeln('YES! Your browser allows pop ups for this site<p>It will go away by it self ...');  \n"  +
"   newWin.document.close();  \n"  +
"   newWin.focus();  \n"  +
"   setTimeout('closePopup()', 5000);  \n"  +
"}  \n"  +
"function closePopup() {  \n"  +
"   newWin.close();  \n"  +
"}  \n"  +
"</script>  \n"  +
"<body>  \n"  +
"<font color=\"#850a0a\">  \n"  +
"  \n"  +
"<h1 align=\"center\">  \n"  +
"   <font color=\"#1C5540\" size=\"6\">  \n"  +
"      Welcome to Your Health Check   \n"  +
"   </font>  \n"  +
"</h1>  \n"  +
"  \n"  +
"<h2 align=\"center\">  \n"  +
"   <font color=\"0000FF\" size=\"5\">  \n"  +
"       If you have a life threatening condition:  \n"  +
"       Call 911 or go to the nearest hospital.  \n"  +
"   </font>  \n"  +
"</h2>  \n"  +
"  \n"  +
"<h3><i>  The medical information in this system will always be incomplete, and  \n"  +
"  while assembled with great care it remains subjective.  \n"  +
"  A symptom of a disease may not be manifest or a symptom may be  \n"  +
"  manifest that is unrelated with a disease, etc.<br />  \n"  +
"  You and only you are FULLY responsible for any conclusion you draw from the  \n"  +
"  presented information!!<br />  \n"  +
"  Proceed only provided you fully agree with the above statements.</i></h3>  \n"  +
"  \n"  +
"<b>  \n"  +
"<form method=\"post\" action=\"/hcknl/servlet/patient.AngelLogin\">  \n"  +
"";
   out.println(str1); 

  String f1 = 

"  Login name: <input type=\"text\" size=\"10\" maxlength=\"10\" name=\"logName\" value=\"" + logName + "\" />";
   out.println(f1); 

  String f2 = 

"  Password: <input type=\"password\" size=\"10\" maxlength=\"10\" name=\"password\" value=\"" + password + "\" onKeyUp=\"checkSubmit(event)\" />";
   out.println(f2); 

  String str2 = 

"<input type=\"button\" value=\"Submit\" onClick=\"checkFields(this.form)\" />  \n"  +
"</form>  \n"  +
"<script language=\"JavaScript\"> document.forms[0].logName.focus(); </script>  \n"  +
"<p> <hr />  \n"  +
"  \n"  +
"<a href=\"/hcknl/servlet/misc.ChangePassword0?user=user\">  \n"  +
"Change my password</a> |   \n"  +
"<a href=\"/hcknl/help.html\">HELP </a>  \n"  +
"  \n"  +
"  \n"  +
"<hr />  \n"  +
"<i>Alerts:</i><br />  \n"  +
"<a href=\"#11\" name=\"11\" onClick=  \n"  +
"    \"alert('** Do NOT log in as another person.  You will get erroneous results and you will mess up the history of that other person.')\">  \n"  +
" Login as another person?</a> |  \n"  +
"  \n"  +
"<a href=\"#12\" name=\"12\" onClick=  \n"  +
"    \"alert('** If you you leave the site for more than 60 seconds, your session will be terminated automaticly.')\">  \n"  +
" Automatic Termination</a> |  \n"  +
"  \n"  +
"<a href=\"#13\" name=\"13\" onClick=  \n"  +
"    \"alert('** POPUPS::: This site USES popups. No, NOT for ads, but to explain, for example, a medical term. Tell your browser to accept popups from this site. There are also popup links into Yahoo to further explain medical terms, which may in turn create whatever popups.')\">  \n"  +
"Pop Ups</a> |  \n"  +
"  \n"  +
"<a href=\"#13a\" name=\"13a\" onClick=\"testPopUp()\">  \n"  +
"Pop Up Test</a> |  \n"  +
"<a href=\"#14\" name=\"14\" onClick=  \n"  +
"    \"alert('** Your browser (or you) must accept a (session) cookie, and must have Javascript and Java enabled.')\">  \n"  +
"Cookies, etc.</a> |  \n"  +
"  \n"  +
"<a href=\"#15\" name=\"15\" onClick=  \n"  +
"    \"alert('** We found that the following browsers are broken: IE5.5 generates erroneous pop-up windows, Netscape6.2 causes a logout if the user stays on a page longer than 60 seconds.  The browsers IE6.0, Netscape7 and 4.08 and likely many others DO work.  Netscape 7.1 does not handle blinking properly.')\">  \n"  +
"Browsers</a>  \n"  +
"</b>  \n"  +
"</font>  \n"  +
"</body>  \n"  +
"</html>  \n"  +
"";
   out.println(str2); 

}}
