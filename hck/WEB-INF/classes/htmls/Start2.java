// (C) OntoOO Inc 2004 Mar
package htmls;

import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.util.*; 
 
public class Start2 extends HttpServlet { 
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
"<head>  \n"  +
"   <title>  \n"  +
"Set up new user 2  \n"  +
"   </title>  \n"  +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"/hck/hckStyle.css\" /><link rel=\"shortcut icon\" href=\"/hck/favicon.ico\" type=\"image/x-icon\" /></head>  \n"  +
"  \n"  +
"<body>  \n"  +
"<font color=\"#850a0a\">  \n"  +
"  \n"  +
"<h1 align=\"center\">  \n"  +
"   <font color=\"#1C5540\" size=\"4\">  \n"  +
"OK, Here the 2nd Set of Questions  \n"  +
"   </font>  \n"  +
"</h1>  \n"  +
"  \n"  +
"<form method=\"post\" action=\"/hck/servlet/patient.Setup2\">  \n"  +
"<table>  \n"  +
"<tr>  \n"  +
"  <td><b>Life style:</b></td>  \n"  +
"</tr>  \n"  +
"<tr>  \n"  +
"  <td>Marital Status:</td>  \n"  +
"  <td>   \n"  +
"       <select name=\"maritalStatus\">  \n"  +
"           <option value=\"single\" selected=\"selected\">single</option>  \n"  +
"           <option value=\"marriedOK\">married OK</option>  \n"  +
"           <option value=\"marriedNotOK\">married not OK</option>  \n"  +
"           <option value=\"remarried\">remarried</option>  \n"  +
"           <option value=\"separated\">separated</option>  \n"  +
"           <option value=\"divorced\">divorced</option>  \n"  +
"           <option value=\"widow(er)\">widow(er)</option>  \n"  +
"       </select>     \n"  +
"  </td>  \n"  +
"</tr>  \n"  +
"<tr>  \n"  +
"  <td>Smoking?</td>  \n"  +
"  <td>   \n"  +
"       <select name=\"smoking\">  \n"  +
"           <option value=\"none\" selected=\"selected\">none</option>  \n"  +
"           <option value=\"lessThanOnePackDay\">less than one pack a day</option>  \n"  +
"           <option value=\"onePackDay\">one pack a day</option>  \n"  +
"           <option value=\"twoPackDay\">two pack a day</option>  \n"  +
"           <option value=\"moreThanTwoPackDay\">more than two pack a day</option>  \n"  +
"       </select>     \n"  +
"  </td>  \n"  +
"</tr>  \n"  +
"<tr>  \n"  +
"  <td>Alcohol?</td>  \n"  +
"  <td>   \n"  +
"       <select name=\"alcohol\">  \n"  +
"           <option value=\"never\" selected=\"selected\">never</option>  \n"  +
"           <option value=\"infrequent\">infrequent</option>  \n"  +
"           <option value=\"frequent\">frequent</option>  \n"  +
"           <option value=\"daily\">daily</option>  \n"  +
"       </select>     \n"  +
"  </td>  \n"  +
"</tr>  \n"  +
"<tr>  \n"  +
"  <td>Exercising? </td>  \n"  +
"  <td>   \n"  +
"       <select name=\"exercising\">  \n"  +
"           <option value=\"never\" selected=\"selected\">never</option>  \n"  +
"           <option value=\"infrequent\">infrequent</option>  \n"  +
"           <option value=\"frequent\">frequent</option>  \n"  +
"           <option value=\"daily\">daily</option>  \n"  +
"       </select>     \n"  +
"  </td>  \n"  +
"</tr>  \n"  +
"<tr>  \n"  +
"  <td>Sources of Tension and Worries:</td>  \n"  +
"  <td>   \n"  +
"       <input type=\"checkbox\" name=\"stress\" value=\"job\" />job  \n"  +
"       <input type=\"checkbox\" name=\"stress\" value=\"spouse\" />spouse  \n"  +
"       <input type=\"checkbox\" name=\"stress\" value=\"finances\" />finances  \n"  +
"       <input type=\"checkbox\" name=\"stress\" value=\"religion\" />religion  \n"  +
"       <input type=\"checkbox\" name=\"stress\" value=\"colleages\" />fellow employees  \n"  +
"       <input type=\"checkbox\" name=\"stress\" value=\"drugs\" />drugs  \n"  +
"       <input type=\"checkbox\" name=\"stress\" value=\"alcohol\" />alcohol  \n"  +
"  </td>  \n"  +
"</tr>  \n"  +
"  \n"  +
"</table>  \n"  +
"  \n"  +
"<hr />  \n"  +
"Please check your data before submitting   \n"  +
"<input type=\"submit\" value=\"Submit\" />  \n"  +
"</form>  \n"  +
"  \n"  +
"</font>  \n"  +
"</body>  \n"  +
"</html>  \n"  +
"";
   out.println(str); 

}}
