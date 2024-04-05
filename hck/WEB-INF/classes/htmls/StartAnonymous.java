// (C) OntoOO Inc 2004 Mar
package htmls;

import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.util.*; 
 
public class StartAnonymous extends HttpServlet { 
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
"<head>  \n"  +
"   <title>  \n"  +
"Set up new anonymous user  \n"  +
"   </title>  \n"  +
"<link rel=\"stylesheet\" type=\"text/css\" href=\"/hck/hckStyle.css\" /><link rel=\"shortcut icon\" href=\"/hck/favicon.ico\" type=\"image/x-icon\" /></head>  \n"  +
"<script language=\"JavaScript\">  \n"  +
"  \n"  +
"function trim(inString) {  \n"  +
"  var lng = inString.length;   \n"  +
"  if (0 == lng) return inString;  \n"  +
"  if (' ' == inString.charAt(0) )  \n"  +
"     return trim(inString.substring(1,lng));  \n"  +
"  lng--;  \n"  +
"  if (' ' == inString.charAt(lng) )  \n"  +
"     return trim(inString.substring(0,lng));  \n"  +
"  return inString;  \n"  +
"}  \n"  +
"  \n"  +
"function isDigit(aChar) {  \n"  +
"   var refString='1234567890';  \n"  +
"   return refString.indexOf(aChar);  \n"  +
"}  \n"  +
"  \n"  +
"function isLowercase(aChar) {  \n"  +
"   var refString='abcdefghijklmnopqrstuvwxyz';  \n"  +
"   return refString.indexOf(aChar);  \n"  +
"}  \n"  +
"  \n"  +
"function isUppercase(aChar) {  \n"  +
"   var refString='ABCDEFGHIJKLMNOPQRSTUVWXYZ';  \n"  +
"   return refString.indexOf(aChar);  \n"  +
"}  \n"  +
"  \n"  +
"function isLetter(aChar) {  \n"  +
"   var out = isLowercase(aChar);  \n"  +
"   if ( 0 <= out ) return out;  \n"  +
"   return isUppercase(aChar);  \n"  +
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
"function isLetterString (inString) {  \n"  +
"   if (0==inString.length) return (false);  \n"  +
"   for (count=0; count<inString.length; count++) {  \n"  +
"      tempChar = inString.charAt(count);  \n"  +
"      if (-1 == isLetter(tempChar)) return (false);  \n"  +
"   }  \n"  +
"   return (true);  \n"  +
"}  \n"  +
"  \n"  +
"function isLetterOrDigitString(inString) {  \n"  +
"   if (0==inString.length) return (false);  \n"  +
"   for (count=0; count<inString.length; count++) {  \n"  +
"      tempChar = inString.charAt(count);  \n"  +
"      if (-1 == isLetter(tempChar) &&  \n"  +
"          -1 == isDigit(tempChar)) return (false);  \n"  +
"   }  \n"  +
"   return (true);  \n"  +
"}  \n"  +
"  \n"  +
"function isLetterOrDigitOrSpaceString(inString) {  \n"  +
"   if (0==inString.length) return (false);  \n"  +
"   for (count=0; count<inString.length; count++) {  \n"  +
"      tempChar = inString.charAt(count);  \n"  +
"      if (-1 == isLetter(tempChar) &&  \n"  +
"          -1 == isDigit(tempChar) && ' ' != tempChar) return (false);  \n"  +
"   }  \n"  +
"   return (true);  \n"  +
"}  \n"  +
"  \n"  +
"function isLetterOrSpaceString(inString) {  \n"  +
"   if (0==inString.length) return (false);  \n"  +
"   for (count=0; count<inString.length; count++) {  \n"  +
"      tempChar = inString.charAt(count);  \n"  +
"      if (-1 == isLetter(tempChar) && ' ' != tempChar) return (false);  \n"  +
"   }  \n"  +
"   return (true);  \n"  +
"}  \n"  +
"  \n"  +
"  \n"  +
"  \n"  +
"function checkFields(form) {  \n"  +
"  val2 = form.logName.value;  \n"  +
"  val3 = trim(val2);  \n"  +
"  if ( val2 != val3 ) { val2 = val3; form.logName.value = val2; }  \n"  +
"  out = isLetterOrDigitString(val2);  \n"  +
"  if ( 1 != out ) { alert('Enter or fix log name/ only letters or digits ...');  \n"  +
"  return; };  \n"  +
"  \n"  +
"  val2 = form.password.value;  \n"  +
"  val3 = trim(val2);  \n"  +
"  if ( val2 != val3 ) { val2 = val3; form.password.value = val2; }  \n"  +
"  out = isLetterOrDigitString(val2);  \n"  +
"  if ( 1 != out ) { alert('Enter or fix password ...'); return; };  \n"  +
"  \n"  +
"  val2 = form.year.value;  \n"  +
"  if ( 4 != val2.length ) { alert('Enter year of birth ...'); return; };  \n"  +
"  out = isDigitString(val2);  \n"  +
"  if ( 1 != out  ) { alert('Enter year of birth ...'); return; };  \n"  +
"  number = parseInt(val2);  \n"  +
"  theDate = new Date(); theYear = theDate.getFullYear();  \n"  +
"  if ( number < 1900 || theYear < number ) { alert('Enter year of birth ...'); return; };  \n"  +
"  \n"  +
"  val2 = form.height.value;  \n"  +
"  if ( 3 < val2.length ) { alert('Enter height ...'); return; };  \n"  +
"  out = isDigitString(val2);  \n"  +
"  if ( 1 != out  ) { alert('Enter height ...'); return; };  \n"  +
"  \n"  +
"  val2 = form.weight.value;  \n"  +
"  out = isDigitString(val2);  \n"  +
"  if ( 1 != out  ) { alert('Enter weight ...'); return; };  \n"  +
"  \n"  +
"  form.submit();  \n"  +
"}  \n"  +
"</script>  \n"  +
"  \n"  +
"<body>  \n"  +
"<font color=\"#850a0a\">  \n"  +
"  \n"  +
"<h1 align=\"center\">  \n"  +
"   <font color=\"#1C5540\" size=\"4\">  \n"  +
"OK, Lets Setup a New Account  \n"  +
"   </font>  \n"  +
"</h1>  \n"  +
"  \n"  +
"<form method=\"post\" action=\"/hck/servlet/patient.Setup\">  \n"  +
"<table>  \n"  +
"<tr>  \n"  +
"  <td><b>To access your data:</b></td>  \n"  +
"</tr>  \n"  +
"<tr>  \n"  +
"   <td>Identification:</td>  \n"  +
"<td>  \n"  +
"";
   out.println(str1); 

  String f1 = 

"  Login name: <input type=\"text\" size=\"10\" maxlength=\"10\" name=\"logName\" VALUE=\"" + logName + "\" />";
   out.println(f1); 

  String f2 = 

"  Password: <input type=\"password\" size=\"10\" maxlength=\"10\" name=\"password\" VALUE=\"PASSWORD\" />";
   out.println(f2); 

    String str2 = 

"   </td>  \n"  +
"</tr>  \n"  +
"  \n"  +
"<tr>  \n"  +
"  <td><b>Some Details:</b></td>  \n"  +
"</tr>  \n"  +
"<tr>  \n"  +
"   <td>Gender:</td>  \n"  +
"   <td>  \n"  +
"       <select name=\"gender\">  \n"  +
"           <option value=\"female\" selected=\"selected\">female</option>   \n"  +
"           <option value=\"male\">male</option>   \n"  +
"       </select>     \n"  +
"   </td>  \n"  +
"</tr>  \n"  +
"<tr>  \n"  +
"   <td>Date of Birth:</td>  \n"  +
"   <td>  \n"  +
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
"   </td>  \n"  +
"</tr>  \n"  +
"<tr>  \n"  +
"   <td>Population group:</td>  \n"  +
"   <td>  \n"  +
"       <select name=\"race\">     \n"  +
"           <option value=\"africanAmerican\" selected=\"selected\"> african american  </option>  \n"  +
"           <option value=\"asian\"> asian  </option>  \n"  +
"           <option value=\"caucasian\"> caucasian  </option>  \n"  +
"           <option value=\"chineseAmerican\"> chinese american </option>  \n"  +
"           <option value=\"hispanic\"> hispanic/ latino   </option>  \n"  +
"           <option value=\"indianAmerican\"> indian american </option>  \n"  +
"           <option value=\"japaneseAmerican\"> japanese american </option>  \n"  +
"           <option value=\"jewishAmerican\"> jewish american </option>  \n"  +
"           <option value=\"nativeAmerican\"> native american  </option>  \n"  +
"       </select>     \n"  +
"   </td>  \n"  +
"</tr>  \n"  +
"  \n"  +
"<tr>  \n"  +
"  <td>Sexual orientation:</td>  \n"  +
"  <td>   \n"  +
"       <select name=\"sexPartner\">  \n"  +
"           <option value=\"hetero\" selected=\"selected\">opposite sex </option>  \n"  +
"           <option value=\"same\">same sex </option>  \n"  +
"           <option value=\"bi\">both sexes </option>  \n"  +
"           <option value=\"none\">none/ abstain </option>  \n"  +
"       </select>     \n"  +
"  </td>  \n"  +
"</tr>  \n"  +
"<tr>  \n"  +
"  <td>Miscellania:</td>  \n"  +
"  <td>   \n"  +
"       Height(inches): <input type=\"text\" size=\"3\" maxlength=\"3\" name=\"height\" />  \n"  +
"       Weight(lbs): <input type=\"text\" size=\"3\" maxlength=\"3\" name=\"weight\" />  \n"  +
"       Blood Group:  \n"  +
"       <select name=\"bloodGroup\">  \n"  +
"           <option value=\"unknown\" selected=\"selected\">un-known </option>  \n"  +
"           <option value=\"O\"> O </option>  \n"  +
"           <option value=\"A\"> A </option>  \n"  +
"           <option value=\"B\"> B </option>  \n"  +
"           <option value=\"AB\"> AB </option>  \n"  +
"       </select>     \n"  +
"  </td>  \n"  +
"</tr>  \n"  +
"</table>  \n"  +
"  \n"  +
"  \n"  +
"<hr />  \n"  +
"Please check your data before submitting  \n"  +
"<input type=\"button\" value=\"Submit\" onClick=\"checkFields(this.form)\" />  \n"  +
"</form>  \n"  +
"<script language=\"JavaScript\"> document.forms[0].logName.focus(); </script>  \n"  +
"  \n"  +
"</font>  \n"  +
"</body>  \n"  +
"</html>  \n"  +
"";
   out.println(str2); 

}}
