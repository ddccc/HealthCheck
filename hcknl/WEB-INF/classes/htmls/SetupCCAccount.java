// (C) OntoOO Inc 2004 Mar
package htmls;

import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.util.*; 
 
public class SetupCCAccount extends HttpServlet { 
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
"<head><title>Setup Account</title></head>  \n"  +
"  \n"  +
"<body bgcolor=\"bbbbbb\">  \n"  +
"  \n"  +
"<h1 align=\"center\">  \n"  +
"   <font color=\"FF0000\" size=\"7\">  \n"  +
"      Setup Your Account  \n"  +
"   </font>  \n"  +
"</h1>  \n"  +
"  \n"  +
"<font size=\"+2\">  \n"  +
"  \n"  +
"The system does not 'know' you ... <br />  \n"  +
"To setup your account you have to answer first a questionaire.<br>  \n"  +
"<p>  \n"  +
"To proceed <a href=\"/hcknl/startCC.html\">click here.</a>  \n"  +
"<hr />  \n"  +
"  \n"  +
"<form>  \n"  +
"<input type=\"button\" value=\"Cancel\" onClick=\"history.back()\" />  \n"  +
"</form>  \n"  +
"  \n"  +
"</font>  \n"  +
"  \n"  +
"</body>  \n"  +
"</html>  \n"  +
"";
   out.println(str); 

}}
