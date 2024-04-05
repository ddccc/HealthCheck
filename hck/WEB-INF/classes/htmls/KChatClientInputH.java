// (C) OntoOO Inc 2004 Mar
package htmls;

import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.util.*; 
 
public class KChatClientInputH extends HttpServlet { 
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
"<body bgcolor=\"bbbbbb\">  \n"  +
"<script language=\"JavaScript\">  \n"  +
"function checkInput(form) {  \n"  +
"        if ( '' ==  form.clientString.value )   \n"  +
"		alert('Please provide input ...');  \n"  +
"	else  \n"  +
"	        form.submit();  \n"  +
"}  \n"  +
"function terminate(form) {  \n"  +
"       form.clientString.value = '**ClientTerminate**';  \n"  +
"       form.submit();  \n"  +
"}  \n"  +
"</script>  \n"  +
"<form action=\"/hck/servlet/patient.KChatClientInput\">  \n"  +
"<input type=\"text\" name=\"clientString\" value=\"\" size=\"80\" maxlength=\"80\" />  \n"  +
"<p>  \n"  +
"<input type=\"button\" value=\"Send to CallCenter\"   \n"  +
"	onClick=\"checkInput(this.form)\" />  \n"  +
"<input type=\"button\" value=\"Terminate Chat Session/Cancel\"   \n"  +
"        onClick=\"terminate(this.form)\" />  \n"  +
"</form>  \n"  +
"<script language=\"JavaScript\"> document.forms[0].clientString.focus(); </script>  \n"  +
"  \n"  +
"</body>  \n"  +
"</html>  \n"  +
"";
   out.println(str); 

}}
