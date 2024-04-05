// (C) OntoOO Inc 2007 Mar
package htmls;

import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.util.*; 
 
public class AngelQuick extends HttpServlet { 
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
"<head><title>Health Check Quick</title>  \n"  +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"/hck/hckStyle.css\" /><link rel=\"shortcut icon\" href=\"/hck/favicon.ico\" type=\"image/x-icon\" /></head>  \n"  +
"<script language=\"JavaScript\">  \n"  +
"function isDigit(aChar) {  \n"  +
"   var refString='1234567890';  \n"  +
"   return refString.indexOf(aChar);  \n"  +
"}  \n"  +
"  \n"  +
"function isDigitString (inString) {  \n"  +
"   if (0==inString.length) return (false);  \n"  +
"   for (count=0; count<inString.length; count++) {  \n"  +
"      tempChar = inString.charAt(count);  \n"  +
"      if (-1 == isDigit(tempChar)) return (false);  \n"  +
"   }  \n"  +
"   return (true);  \n"  +
"}  \n"  +
"  \n"  +
"function checkFields(form) {  \n"  +
"  val2 = form.year.value;  \n"  +
"  if ( 4 != val2.length ) { alert('Enter year of birth ...'); return; };  \n"  +
"  out = isDigitString(val2);  \n"  +
"  if ( 1 != out  ) { alert('Enter year of birth ...'); return; };  \n"  +
"  number = parseInt(val2);  \n"  +
"  theDate = new Date(); theYear = theDate.getFullYear();  \n"  +
"  if ( number < 1900 || theYear < number ) { alert('Enter year of birth ...'); return; };  \n"  +
"  \n"  +
"  form.submit();  \n"  +
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
"<form method=\"post\" action=\"/hck/servlet/su.AccountQuick\">  \n"  +
"<center><table>  \n"  +
"<tr>  \n"  +
"   <td><span class=\"text12\">Gender:</span></td>  \n"  +
"   <td>  \n"  +
"       <select name=\"gender\">  \n"  +
"           <option value=\"female\" selected=\"selected\">female  \n"  +
"           <option value=\"male\">male  \n"  +
"       </select>     \n"  +
"   </td>  \n"  +
"</tr>  \n"  +
"<tr>  \n"  +
"   <td><span class=\"text12\">Date of Birth:&nbsp;&nbsp;&nbsp;</span></td>  \n"  +
"   <td><span class=\"text12\">  \n"  +
"       Year: <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"year\" value=\"yyyy\">  \n"  +
"Month: <select name=\"month\"><option value=\"Jan0\" selected=\"selected\"> Jan </option>  \n"  +
" <option value=\"Feb1\"> Feb </option>  \n"  +
" <option value=\"Mar2\"> Mar </option>  \n"  +
" <option value=\"Apr3\"> Apr </option>  \n"  +
" <option value=\"May4\"> May </option>  \n"  +
" <option value=\"Jun5\"> Jun </option>  \n"  +
" <option value=\"Jul6\"> Jul </option>  \n"  +
" <option value=\"Aug7\"> Aug </option>  \n"  +
" <option value=\"Sep8\"> Sep </option>  \n"  +
" <option value=\"Oct9\"> Oct </option>  \n"  +
" <option value=\"Nov10\"> Nov </option>  \n"  +
" <option value=\"Dec11\"> Dec </option>  \n"  +
" </select> \n"  +
"Day: <select name=\"day\"> <option value=\"1\" selected=\"selected\"> 1  </option>  \n"  +
" <option value=\"2\"> 2  </option>  \n"  +
" <option value=\"3\"> 3  </option>  \n"  +
" <option value=\"4\"> 4  </option>  \n"  +
" <option value=\"5\"> 5  </option>  \n"  +
" <option value=\"6\"> 6  </option>  \n"  +
" <option value=\"7\"> 7  </option>  \n"  +
" <option value=\"8\"> 8  </option>  \n"  +
" <option value=\"9\"> 9  </option>  \n"  +
" <option value=\"10\"> 10  </option>  \n"  +
" <option value=\"11\"> 11  </option>  \n"  +
" <option value=\"12\"> 12  </option>  \n"  +
" <option value=\"13\"> 13  </option>  \n"  +
" <option value=\"14\"> 14  </option>  \n"  +
" <option value=\"15\"> 15  </option>  \n"  +
" <option value=\"16\"> 16  </option>  \n"  +
" <option value=\"17\"> 17  </option>  \n"  +
" <option value=\"18\"> 18  </option>  \n"  +
" <option value=\"19\"> 19  </option>  \n"  +
" <option value=\"20\"> 20  </option>  \n"  +
" <option value=\"21\"> 21  </option>  \n"  +
" <option value=\"22\"> 22  </option>  \n"  +
" <option value=\"23\"> 23  </option>  \n"  +
" <option value=\"24\"> 24  </option>  \n"  +
" <option value=\"25\"> 25  </option>  \n"  +
" <option value=\"26\"> 26  </option>  \n"  +
" <option value=\"27\"> 27  </option>  \n"  +
" <option value=\"28\"> 28  </option>  \n"  +
" <option value=\"29\"> 29  </option>  \n"  +
" <option value=\"30\"> 30  </option>  \n"  +
" <option value=\"31\"> 31  </option>  \n"  +
" </select>  \n"  +
"  \n"  +
"  \n"  +
"   </span></td>  \n"  +
"</tr>  \n"  +
"<tr><td>  \n"  +
"<input type=\"button\" value=\"Submit\" onClick=\"checkFields(this.form)\" />  \n"  +
"</td></tr>  \n"  +
"</table></center>  \n"  +
"";
   out.println(str1); 

  String str2 = 

"</form>  \n"  +
"<p> <hr>  \n"  +
"  \n"  +
"<a href=\"/hck/help.html\">HELP </a>  \n"  +
"  \n"  +
"  \n"  +
"<hr />  \n"  +
"<i>Alerts:</i><br />  \n"  +
"<a href=\"#12\" name=\"12\" onClick=  \n"  +
"    \"alert('** If you you leave the site for more than 60 seconds, your session will be terminated automaticly.')\">  \n"  +
" Automatic Termination</a> |  \n"  +
"  \n"  +
"<a href=\"#13\" name=\"13\" onClick=  \n"  +
"    \"alert('** POPUPS::: This site USES popups. No, NOT for ads, but to explain, for example, a medical term. Tell your browser to accept popups from this site. There are also popup links into Yahoo to further explain medical terms, which may in turn create whatever popups.')\">  \n"  +
"Pop Ups</a> |  \n"  +
"  \n"  +
"<a href=\"#13a\" name=\"13a\" onClick='testPopUp()'>  \n"  +
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
