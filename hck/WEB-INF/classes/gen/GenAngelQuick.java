// (C) OntoOO Inc 2007 March

package gen;

import com.D;
import com.L;
import patient.Setup2;


import java.io.*;
import java.util.*;
 
public class GenAngelQuick   {

public static void main (String [] arguments) 
    throws Exception     {

    String str1 =
"<html> $$" +
"<head><title>" + L.HealthCheckQuick + "</title> $$" +
	//"<link rel=\"stylesheet\" type=\"text/css\" href=\"" + D.hckStyle + "\" /> $$" +
D.linkHckStyle +
D.favicon +
"</head> $$" +
"<script language=\"JavaScript\"> $$" +
"function isDigit(aChar) { $$" +
"   var refString='1234567890'; $$" +
"   return refString.indexOf(aChar); $$" +
"} $$" +
" $$" +
"function isDigitString (inString) { $$" +
"   if (0==inString.length) return (false); $$" +
"   for (count=0; count<inString.length; count++) { $$" +
"      tempChar = inString.charAt(count); $$" +
"      if (-1 == isDigit(tempChar)) return (false); $$" +
"   } $$" +
"   return (true); $$" +
"} $$" +
" $$" +
"function checkFields(form) { $$" +
"  val2 = form.year.value; $$" +
"  if ( 4 != val2.length ) { alert('Enter year of birth ...'); return; }; $$" +
"  out = isDigitString(val2); $$" +
"  if ( 1 != out  ) { alert('Enter year of birth ...'); return; }; $$" +
"  number = parseInt(val2); $$" +
"  theDate = new Date(); theYear = theDate.getFullYear(); $$" +
"  if ( number < 1900 || theYear < number ) { alert('Enter year of birth ...'); return; }; $$" +
" $$" +
"  form.submit(); $$" +
"} $$" +
"function testPopUp() { $$" +
"   var features = 'directories=no,location=no,menubar=no,status=no'; $$" +
"   features += 'titlebar=no,toolbar=no,hotkeys=no'; $$" +
"   features += 'scrollbars=no,width=200,height=100,resizeable=no'; $$" +
"   newWin = open('', 'myDoc', features); $$" +
	// YES! Your browser allows pop ups for this site<p>
	// It will go away by it self ...
"   newWin.document.writeln('" + L.AngelS23D + "'); $$" +
"   newWin.document.close(); $$" +
"   newWin.focus(); $$" +
"   setTimeout('closePopup()', 5000); $$" +
"} $$" +
"function closePopup() { $$" +
"   newWin.close(); $$" +
"} $$" +
"</script> $$" +
"<body> $$" +
"<font color=\"#850a0a\"> $$" +
" $$" +
"<h1 align=\"center\"> $$" +
"   <font color=\"#1C5540\" size=\"6\"> $$" +
	//"      Welcome to Your Health Check $$" +
"      " + L.AngelS2 + "  $$" +
"   </font> $$" +
"</h1> $$" +
" $$" +
"<h2 align=\"center\"> $$" +
"   <font color=\"0000FF\" size=\"5\"> $$" +
	//"      If you have a life threatening condition:  $$" +
"       " + L.AngelS3 + " $$" +
	//"      Call 911 or go to the nearest hospital. $$" +
"       " + L.AngelS4 + " $$" +
"   </font> $$" +
"</h2> $$" +
" $$" +
"<h3><i>" +
	// "The medical information in this system will always be incomplete, and $$" +
"  " + L.AngelS5 + " $$" +
	// "while assembled with great care it remains subjective.  $$" +
"  " + L.AngelS6 + " $$" +
	// "A symptom of a disease may not be manifest or a symptom may be $$" +
"  " + L.AngelS7 + " $$" +
	// "manifest that is unrelated with a disease, etc.<br /> $$" +
"  " + L.AngelS8 + "<br /> $$" +
	// "You and only you are FULLY responsible for any conclusion you draw from the $$" +
"  " + L.AngelS9 + " $$" +
	// "presented information!!<br /> $$" +
"  " + L.AngelS10 + "<br /> $$" +
	// "Login only provided you fully agree with the above statements.</i></h3> $$" +
"  " + L.AngelS11 + "</i></h3> $$" +
" $$" +
"<b> $$" +
	"<form method=\"post\" action=\"" + D.servletAccountQuick +"\"> $$" +
"<center><table> $$" +
"<tr> $$" +
"   <td><span class=\"text12\">" + L.Gender + "</span></td> $$" +
"   <td> $$" +
"       <select name=\"gender\"> $$" +
"           <option value=\"female\" selected=\"selected\">" + L.female + " $$" +
"           <option value=\"male\">" + L.male + " $$" +
"       </select>    $$" +
"   </td> $$" +
"</tr> $$" +
"<tr> $$" +
"   <td><span class=\"text12\">" + L.DateOfBirth + "&nbsp;&nbsp;&nbsp;</span></td> $$" +
"   <td><span class=\"text12\"> $$" +
"       " + L.Year + " <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"year\" value=\"yyyy\"> $$" +
	/*
"       " + L.Month + " $$" +
"       <select name=\"month\"> $$" +
"           <option value=\"Jan0\" selected=\"selected\" > Jan $$" +
"           <option value=\"Feb1\"> Feb </option> $$" +
"           <option value=\"Mar2\"> Mar </option> $$" +
"           <option value=\"Apr3\"> Apr </option> $$" +
"           <option value=\"May4\"> May </option> $$" +
"           <option value=\"Jun5\"> Jun </option> $$" +
"           <option value=\"Jul6\"> Jul </option> $$" +
"           <option value=\"Aug7\"> Aug </option> $$" +
"           <option value=\"Sep8\"> Sep </option> $$" +
"           <option value=\"Oct9\"> Oct </option> $$" +
"           <option value=\"Nov10\"> Nov </option> $$" +
"           <option value=\"Dec11\"> Dec </option> $$" +
"       </select>    $$" +
L.Day + " $$" +
"       <select name=\"day\"> $$" +
"           <option value=\"1\" selected=\"selected\"> 1 </option> $$" +
"           <option value=\"2\"> 2 </option> $$" +
"           <option value=\"3\"> 3 </option> $$" +
"           <option value=\"4\"> 4 </option> $$" +
"           <option value=\"5\"> 5 </option> $$" +
"           <option value=\"6\"> 6 </option> $$" +
"           <option value=\"7\"> 7 </option> $$" +
"           <option value=\"8\"> 8 </option> $$" +
"           <option value=\"9\"> 9 </option> $$" +
"           <option value=\"10\"> 10 </option> $$" +
"           <option value=\"11\"> 11 </option> $$" +
"           <option value=\"12\"> 12 </option> $$" +
"           <option value=\"13\"> 13 </option> $$" +
"           <option value=\"14\"> 14 </option> $$" +
"           <option value=\"15\"> 15 </option> $$" +
"           <option value=\"16\"> 16 </option> $$" +
"           <option value=\"17\"> 17 </option> $$" +
"           <option value=\"18\"> 18 </option> $$" +
"           <option value=\"19\"> 19 </option> $$" +
"           <option value=\"20\"> 20 </option> $$" +
"           <option value=\"21\"> 21 </option> $$" +
"           <option value=\"22\"> 22 </option> $$" +
"           <option value=\"23\"> 23 </option> $$" +
"           <option value=\"24\"> 24 </option> $$" +
"           <option value=\"25\"> 25 </option> $$" +
"           <option value=\"26\"> 26 </option> $$" +
"           <option value=\"27\"> 27 </option> $$" +
"           <option value=\"28\"> 28 </option> $$" +
"           <option value=\"29\"> 29 </option> $$" +
"           <option value=\"30\"> 30 </option> $$" +
"           <option value=\"31\"> 31 </option> $$" +
"       </select>    $$" +
	*/
Setup2.monthDaySelector + " $$" +
"   </span></td> $$" +
"</tr> $$" +
"<tr><td> $$" +
"<input type=\"button\" value=\"" + L.Submit + "\" onClick=\"checkFields(this.form)\" /> $$" +
"</td></tr> $$" +
"</table></center> $$";





    /*
	// "   Login name: <input type=\"TEXTAREA\" size=\"10\" name=\"logName\"> $$" +
	// "   Password: <input type=\"PASSWORD\" size=\"10\" name=\"password\"> $$" +
String f1 =
    "  " + L.LoginName + " <input type=\"text\" size=\"10\" maxlength=\"10\" name=\"logName\" value=\"LOGNAME\" />";
String f2 =
    "  " + L.Password  + " <input type=\"password" size=\"10\" maxlength=\"10\" name=\"password\" value=\"PASSWORDX\" />";
    */


String str2 =
    // "<input type=\"button\" value=\"" + L.Submit + "\" onClick=\"checkFields(this.form)\" /> $$" +
"</form> $$" +
    //"<script language=\"JavaScript\"> document.forms[0].logName.focus(); </script> $$" +
"<p> <hr> $$" +
    /*
"<form action=\"" + D.servletCreateAnonymousAccount +"\"> $$" +
        //"   <A href=\"" + D.servletCreateAnonymousAccount + "\">  $$" +
 	// "   First time visitor: Create first an anonymous account</A> |  $$" +
        // "  " + L.AngelS12 + "</A> |  $$" +
"  " + L.AngelS12 + " $$" +
"<input type=\"submit\" value=\"" + L.AngelS12B + "\" /> $$" +
"</form> $$" +
" $$" +
//"<input type=\"button\" value=\"" + L.BackCancel + "\" onClick=\"history.back()\" /> $$" +
//"<input type=\"button\" value=\"" + L.Home + "\" onClick='location=\"" + D.indexHtml + "\"' /> $$" +
//"</form> $$" +
"<hr /> $$" +
    */
" $$" +
    /*
"<a href=\"" + D.servletChangePassword0 + "?user=user\"> $$" +
	// "Change my password</a> |  $$" +
L.AngelS13 + "</a> |  $$" +
"<a href=\"" + D.faqHtml +"\">  $$" +
	// "I want to know more about this site</a> | $$" +
L.AngelS14 + "</a> | $$" +
    */
"<a href=\"" + D.helpHtml + "\">HELP </a> $$" +

" $$" +
" $$" +
"<hr /> $$" +
	/*
"<i>" + L.Warnings + "</i><br /> $$" +
	// "** Do NOT log in as another person.  You will get erroneous results and $$" +
L.AngelS15 + " $$" +
	// "you will mess up the history of that other person.<br /> $$" +
L.AngelS16 + "<br /> $$" +
" $$" +
	*/
"<i>Alerts:</i><br /> $$" +
    /*
"<a href=\"#11\" name=\"11\" onClick= $$" +
	// "   'alert('** Do NOT log in as another person.  You will get erroneous  
        //     results and you will mess up the history of that other person.')'> $$" +
"    \"alert('" + L.AngelS15 + L.AngelS16 + "')\"> $$" +
	// " Login as another person?</a> | $$" + 
L.AngelS16B + "</a> | $$" + 
" $$" +
    */
	/*
	// "** If you you leave the site for more than 60 seconds, you will be $$" +
L.AngelS17 + " $$" +
	// "logged out automaticly.<br /> $$" +
L.AngelS18 + "<br /> $$" +
" $$" +
	*/
"<a href=\"#12\" name=\"12\" onClick= $$" +
	//"   'alert('** If you you leave the site for more than 60 seconds, 
	// you will be logged out automaticly.')'> $$" +
"    \"alert('" + L.AngelS17 + L.AngelS18 + "')\"> $$" +
	// " Automatic Logout</a> $$" + 
L.AngelS18B + "</a> | $$" + 
" $$" +
	/*
"<font color=\"FF0000\"> $$" +
	// "** POPUPS::: This site USES popups. No, NOT for ads, but to explain, $$" +
L.AngelS19 + " $$" +
	// "for example, a medical term. $$" +
L.AngelS20 + "</font> <i> $$" +
	// "Tell your browser to accept popups from this site.</i> $$" +
L.AngelS21 + "</i> $$" +
	// "There are also popup links into Yahoo to further explain medical terms, $$" +
L.AngelS22 + " $$" +
	// "which may in turn create whatever popups.<br />  $$" +
L.AngelS23 + "<br /> $$" +
" $$" +
	*/
"<a href=\"#13\" name=\"13\" onClick= $$" +
	//"   'alert('** POPUPS::: This site USES popups. No, NOT for ads, but to explain, 
	// for example, a medical term. Tell your browser to accept popups from this site. 
	// There are also popup links into Yahoo to further explain medical terms, 
	// which may in turn create whatever popups.')'> $$" +
"    \"alert('" + L.AngelS19 + L.AngelS20 +  L.AngelS21 + L.AngelS22 + L.AngelS23 + "')\"> $$" +
	// " POP UPS</a> $$" +
L.AngelS23B + "</a> | $$" + 
" $$" +
"<a href=\"#13a\" name=\"13a\" onClick='testPopUp()'> $$" +
    // "Pop Up Test" + 
L.AngelS23C + "</a> | $$" + 

	/*
	// "** Your browser (or you) must accept a (transient) cookie,  $$" +
L.AngelS24 + " $$" +
	// "and must have Javascript and Java enabled.<br />  $$" +
L.AngelS25 + " $$" +
"  $$" +
	*/
"<a href=\"#14\" name=\"14\" onClick= $$" +
	//"   'alert('** Your browser (or you) must accept a (transient) cookie, 
	// and must have Javascript and Java enabled.')'> $$" +
"    \"alert('" + L.AngelS24 + L.AngelS25 + "')\"> $$" +
	// "Cookies, etc.</a> | $$" +
L.AngelS25B + "</a> | $$" + 
" $$" +
	/*
"<font color=\"FF0000\"> $$" +
	// "** We found that the following browsers are 'broken':  $$" +
L.AngelS26 + " $$" +
"<a href=\"#1\" name=\"1\" onClick= $$" +
"   \"alert('IE5.5 generates erroneous pop-up windows')\"> IE5.5</a> $$" +
	// "and  $$" +
L.and + "  $$" +
"<a href=\"#2\" name=\"2\" onClick= $$" +
"   \"alert('Netscape6.2 causes a logout if the user stays on a page longer than 60 seconds')\"> $$" +
"Netscape6.2</a>.</font> $$" +
	// "The browsers IE6.0, Netscape7 and 4.08 and likely many others DO work.  $$" +
L.AngelS27 + " $$" +
	// "Netscape 7.1 does not handle blinking properly ... $$" +
L.AngelS28 + " $$" +
	*/
"<a href=\"#15\" name=\"15\" onClick= $$" +
	//"   'alert('** We found that the following browsers are broken: 
	//IE5.5 generates erroneous pop-up windows, Netscape6.2 causes a 
	//logout if the user stays on a page longer than 60 seconds. 
	//The browsers IE6.0, Netscape7 and 4.08 and likely many others DO work.  
	//Netscape 7.1 does not handle blinking properly.')'> $$" +
"    \"alert('** We found that the following browsers are broken: IE5.5 generates erroneous pop-up windows, Netscape6.2 causes a logout if the user stays on a page longer than 60 seconds.  The browsers IE6.0, Netscape7 and 4.08 and likely many others DO work.  Netscape 7.1 does not handle blinking properly.')\"> $$" +
"Browsers</a> $$" +
"</b> $$" +
"</font> $$" +
"</body> $$" +
"</html> $$";





    String name = "AngelQuick";
    File genOut = new File("GenHtmlDir/" + name + ".java");
    FileOutputStream fosStr = new FileOutputStream(genOut);
    PrintWriter psStr = new PrintWriter(fosStr);

    psStr.println("// (C) OntoOO Inc 2007 Mar");
    psStr.println("package htmls;");
    psStr.println();
    psStr.println(
       "import java.io.*; \n" +
       "import javax.servlet.*; \n" +
       "import javax.servlet.http.*; \n" +
       "import java.util.*; \n" +
       " \n" +
       "public class " + name + " extends HttpServlet { \n" +
       "   public void doGet (HttpServletRequest req, \n" +
       "                      HttpServletResponse res) \n" +
       "       throws ServletException, IOException { \n" +
       "     call(res, \"\", \"\"); \n" +
       "} \n" +
       " \n" +
       "static public void call(HttpServletResponse res, String logName, String password) \n" +
       "    throws IOException { \n" +
       "    res.setContentType(\"text/html\"); \n" +
       "    ServletOutputStream out = res.getOutputStream(); \n" +
       "    String str1 = \n");
    psStr.println();

    StringTokenizer st = new StringTokenizer(str1, "$$");
    String token;
    while ( st.hasMoreTokens() ) {
	token = st.nextToken();
	int idx = token.indexOf('\n');
	if (0 <= idx) { 
	    // System.out.println("{{{{Found: " + token + " }}}}");
	    StringTokenizer st2 = new StringTokenizer(token, "\n");
	    while ( st2.hasMoreTokens() ) {
		token = st2.nextToken();
		// System.out.println(token);
		psStr.println("\"" + fix(token) + " \\n\"  +");
	    }
	    // System.out.println("|||||||");
	}
	psStr.println("\"" + fix(token) + " \\n\"  +");
    }
    psStr.println("\"\";");
    psStr.println("   out.println(str1); \n");

    /*
    // here f1 & f2
    psStr.println("  String f1 = \n");
    psStr.println("\"" + fix2(fix(f1)) + "\";");
    psStr.println("   out.println(f1); \n");
    psStr.println("  String f2 = \n");
    psStr.println("\"" + fix2(fix(f2)) + "\";");
    psStr.println("   out.println(f2); \n");
    */

    psStr.println("  String str2 = \n");
    st = new StringTokenizer(str2, "$$");
    // String token;
    while ( st.hasMoreTokens() ) {
	token = st.nextToken();
	int idx = token.indexOf('\n');
	if (0 <= idx) { 
	    // System.out.println("{{{{Found: " + token + " }}}}");
	    StringTokenizer st2 = new StringTokenizer(token, "\n");
	    while ( st2.hasMoreTokens() ) {
		token = st2.nextToken();
		// System.out.println(token);
		psStr.println("\"" + fix(token) + " \\n\"  +");
	    }
	    // System.out.println("|||||||");
	}
	psStr.println("\"" + fix(token) + " \\n\"  +");
    }
    psStr.println("\"\";");
    psStr.println("   out.println(str2); \n");




    psStr.println("}}");

    psStr.flush();     psStr.close();

} // end of main

    // fix1 replaces " by: \"
    static public String fix(String str) {
	int idx = str.indexOf('"');
	if ( idx < 0 ) return str;
	return str.substring(0,idx) + "\\\"" + fix(str.substring(idx+1));
    }
    // fix2 replaces LOGNAME by: " + logName + "
    // and
    // PASSWORD by: " + password + "
    static public String fix2(String str) {
	int idx = str.indexOf("LOGNAME");
	if ( 0 < idx  ) {
	    // System.out.println("LOGNAME:::: " + str);
	    return str.substring(0,idx) + "\" + logName + \"" + str.substring(idx+7);
	}
	idx = str.indexOf("PASSWORDX");
	if ( 0 < idx  ) {
	    // System.out.println("PASSWORD:::: " + str);
	    return str.substring(0,idx) + "\" + password + \"" + str.substring(idx+9);
	}
	return str;
    }


} // GenAngelQuick
