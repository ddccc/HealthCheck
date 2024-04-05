// (C) OntoOO Inc 2004 Mar
package htmls;

import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.util.*; 
 
public class SetupAccount extends HttpServlet { 
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
"<head><title>Setup Account</title>  \n"  +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"/hcknl/hckStyle.css\" /><link rel=\"shortcut icon\" href=\"/hcknl/favicon.ico\" type=\"image/x-icon\" /></head>  \n"  +
"  \n"  +
"<body>  \n"  +
"<font color=\"#850a0a\"  size=\"+2\">  \n"  +
"  \n"  +
"<h1 align=\"center\">  \n"  +
"   <font color=\"#1C5540\" size=\"7\">  \n"  +
"      Setup Account  \n"  +
"   </font>  \n"  +
"</h1>  \n"  +
"  \n"  +
"  \n"  +
"The system does not 'know' you ... <br />  \n"  +
"To setup your account you have to answer first a questionaire.<br />  \n"  +
"The more details you provide the more specific will be the information that can be generated for you.<br />  \n"  +
"If you have concerns regarding privacy, please contact your provider.  \n"  +
"<p>  \n"  +
"To proceed <a href=\"/hcknl/start.html\">click here.</a>  \n"  +
"<hr />  \n"  +
"  \n"  +
"<form>  \n"  +
"<input type=\"button\" value=\"Cancel\" onClick=\"history.back()\" />  \n"  +
"</form>  \n"  +
"  \n"  +
"  \n"  +
"</font>  \n"  +
"</body>  \n"  +
"</html>  \n"  +
"";
   out.println(str); 

}}
