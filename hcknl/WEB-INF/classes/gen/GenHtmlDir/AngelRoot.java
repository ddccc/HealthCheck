// (C) OntoOO Inc 2004 Mar
package htmls;

import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.util.*; 
 
public class AngelRoot extends HttpServlet { 
   public void doGet (HttpServletRequest req, 
                      HttpServletResponse res) 
       throws ServletException, IOException { 
     call(res); 
} 
 
static public void call(HttpServletResponse res) 
    throws IOException { 
    res.setContentType("text/html"); 
    ServletOutputStream out = res.getOutputStream(); 
    String str = 


"<html>  \n"  +
"<head><title>Angel Root</title> \n"  +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"/hcknl/hckStyle.css\" /><link rel=\"shortcut icon\" href=\"/hcknl/favicon.ico\" type=\"image/x-icon\" /></head>  \n"  +
"  \n"  +
"<body>  \n"  +
"<font color=\"#850a0a\">  \n"  +
"  \n"  +
"<form action=\"/hcknl/servlet/patient.UserLogout\">  \n"  +
"<span id=\"toolTipBox\" width=\"200\"></span>  \n"  +
"<script language=\"JavaScript\">  \n"  +
"function myAlert(x, y, timeOut, txt) {  \n"  +
"    document.getElementById('toolTipBox').style.top = y + \"px\";  \n"  +
"    document.getElementById('toolTipBox').style.left = x + \"px\";  \n"  +
"    document.getElementById('toolTipBox').innerHTML= txt;  \n"  +
"    document.getElementById('toolTipBox').style.display=\"block\";  \n"  +
"    setTimeout(\"closeTT()\", timeOut);  \n"  +
"}  \n"  +
"function closeTT() {  \n"  +
"    document.getElementById('toolTipBox').style.display=\"none\";  \n"  +
"}  \n"  +
"function sloagan() {   \n"  +
"   return 'HC4M is a product of <br> <a href=\"#11\" name=\"11\" onClick=\"openOOWin()\">OntoOO</a>';  \n"  +
"}  \n"  +
"function openOOWin() {   \n"  +
"  open('http://www.ontooo.com', 'OntoOO');  \n"  +
"}  \n"  +
"</script>  \n"  +
"<table width=\"100%\">  \n"  +
"<tr><td><img align=\"left\" height=\"24\" width=\"141\" border=\"1\" src=\"/hck/images/logo4.jpg\"  \n"  +
"        onClick=\"myAlert(30, 30, 3000, sloagan())\" /></td>  \n"  +
"<td align=\"left\">  \n"  +
"<font color=\"#1C5540\" size=\"4\">  \n"  +
"<b>  \n"  +
"<b>  \n"  +
"Your Health Tool At Your Service!  \n"  +
"</b>  \n"  +
"</font>  \n"  +
"</td><td align=\"right\">  \n"  +
"<input type=\"submit\" value=\"Finish\" />  \n"  +
"</td></tr>  \n"  +
"</table>  \n"  +
"  \n"  +
"  \n"  +
"</form>  \n"  +
"  \n"  +
"  \n"  +
"<font size=\"+1\">  \n"  +
"  \n"  +
"<h2>  \n"  +
"<font size=\"4\">Select</font>   \n"  +
"<font color= \"#1C5540\" size=\"5\"><blink> ONE </blink></font>   \n"  +
"<font size=\"4\">of These :::::::</font>  \n"  +
"</h2>  \n"  +
"  \n"  +
"<table border=\"1\" width=\"100%\">  \n"  +
"<tr><td><font color=\"#850a0a\" size=\"4\">Health Screen</td>  \n"  +
"<td><ul><font size=\"4\">  \n"  +
"<li> <a href=\"/hcknl/servlet/patient.DiagStart\">What Condition Could I Have?</a>  \n"  +
"<li> <a href=\"/hcknl/servlet/patient.DiagStart2\">What Condition Could I Have? - Advanced Search</a>  \n"  +
"<li> <a href=\"/hcknl/servlet/patient.DiagShow\">  \n"  +
"Details of a Suspected Condition</a>  \n"  +
"</ul></td></tr>  \n"  +
"<!--  \n"  +
"<li> <a href=\"/Explain.html\">  \n"  +
"Explain and/or clarify proposed or scheduled intervention <i>(Not  \n"  +
"active)</i></a>  \n"  +
"<hr>  \n"  +
"-->  \n"  +
"  \n"  +
"<tr><td><font color=\"#850a0a\" size=\"4\">Weight Tracking</td>  \n"  +
"<td><ul><font size=\"4\">  \n"  +
"<li> <a href=\"/hcknl/ProgWeight.html\">Enter Today's Weight</a>  \n"  +
"<li> <a href=\"/hcknl/GetTargetWeight.html\">Enter/Change my Target Weight</a>  \n"  +
"<li> <a href=\"/hcknl/servlet/patient.ShowWeightGraph\">Display my Weight Graph</a>  \n"  +
"<li> <a href=\"/hcknl/servlet/patient.GetBMIInput\">Calculate my Body Mass Index</a>  \n"  +
"</ul></td></tr>  \n"  +
"  \n"  +
"  \n"  +
"<tr><td><font color=\"#850a0a\" size=\"4\">Miscellaneous</td>  \n"  +
"<td><ul><font size=\"4\">  \n"  +
"<li> <a href=\"/hcknl/servlet/patient.History\">Show Medical History</a>  \n"  +
"<li> <a href=\"/hcknl/servlet/patient.Info\">Search For/ Explain</a>  \n"  +
"</ul></td></tr>  \n"  +
"</table>  \n"  +
"  \n"  +
"</font>  \n"  +
"  \n"  +
"  \n"  +
"<script language=\"JavaScript\" src=\"/hcknl/kangel.js\"></script>  \n"  +
"  \n"  +
"</font>  \n"  +
"</body>  \n"  +
"</html>  \n"  +
"";
   out.println(str); 

}}
