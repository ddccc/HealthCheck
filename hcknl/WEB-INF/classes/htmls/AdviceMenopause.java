// (C) OntoOO Inc 2004 Mar
package htmls;

import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.util.*; 
 
public class AdviceMenopause extends HttpServlet { 
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
"<head><title>Advice</title></head>  \n"  +
"  \n"  +
"<body bgcolor=\"yellow\">  \n"  +
"  \n"  +
"<font size=\"+1\">  \n"  +
"  \n"  +
"<h2>  \n"  +
"<font size=\"4\">  \n"  +
"ADVICE: Since your postmenopause   \n"  +
"appears to be late, please make an appointment with your physician.  \n"  +
"</font>  \n"  +
"</h2>  \n"  +
"  \n"  +
"<a href=\"/hcknl/servlet/patient.SetSessionMaxInterval\">Proceed</a>  \n"  +
"  \n"  +
"</body>  \n"  +
"</html>  \n"  +
"";
   out.println(str); 

}}
