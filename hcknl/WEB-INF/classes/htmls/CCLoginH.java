// (C) OntoOO Inc 2004 Mar
package htmls;

import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.util.*; 
 
public class CCLoginH extends HttpServlet { 
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
"<head><title>CC login</title></head>  \n"  +
"<script language=\"JavaScript\">  \n"  +
"function checkFields(form) {  \n"  +
"	if ( ('' != form.logName.value) && ('' != form.password.value) )  \n"  +
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
"</script>  \n"  +
"<body bgcolor=\"lightblue\">  \n"  +
"  \n"  +
"<h1 align=\"center\">  \n"  +
"   <font color=\"FF0000\" size=\"7\">  \n"  +
"      Welcome to Health Angel CC   \n"  +
"   </font>  \n"  +
"</h1>  \n"  +
"  \n"  +
"<h3> Please Login: </h3>  \n"  +
"  \n"  +
"<form method=\"post\" action=\"/hcknl/servlet/cc.CCLogin\">  \n"  +
"   Login name: <input type=\"text\" size=\"10\" maxlength=\"10\" name=\"logName\" />  \n"  +
"   Password: <input type=\"password\" SIZE=\"10\" maxlength=\"10\" name=\"password\" onKeyUp=\"checkSubmit(event)\" /><p>  \n"  +
"  \n"  +
"<input type=\"button\" value=\"Submit\" onClick=\"checkFields(this.form)\" />  \n"  +
"<input type=\"button\" value=\"Cancel\" onClick=\"history.back()\" />  \n"  +
"  \n"  +
"</form>  \n"  +
"<hr />  \n"  +
"  \n"  +
"If you want to change your password,   \n"  +
"<a href=\"/hcknl/servlet/misc.ChangePassword0?user=cc\">click here.</a>  \n"  +
"  \n"  +
"</body>  \n"  +
"</html>  \n"  +
"";
   out.println(str); 

}}
