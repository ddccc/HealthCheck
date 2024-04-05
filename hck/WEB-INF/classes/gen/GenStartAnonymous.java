// (C) OntoOO Inc 2004

package gen;

import com.D;
import com.L;
import patient.Setup2;


import java.io.*;
import java.util.*;
 
public class GenStartAnonymous {

public static void main (String [] arguments) 
    throws Exception     {

    String str1 = 
"<html> $$" +
"<head> $$" +
"   <title> $$" +
	//"      Set up new anonymous user $$" +
L.StartAS1 + " $$" +
"   </title> $$" +
D.linkHckStyle +
D.favicon +
"</head> $$" +
"<script language=\"JavaScript\"> $$" +
" $$" +
"function trim(inString) { $$" +
"  var lng = inString.length;  $$" +
"  if (0 == lng) return inString; $$" +
"  if (' ' == inString.charAt(0) ) $$" +
"     return trim(inString.substring(1,lng)); $$" +
"  lng--; $$" +
"  if (' ' == inString.charAt(lng) ) $$" +
"     return trim(inString.substring(0,lng)); $$" +
"  return inString; $$" +
"} $$" +
" $$" +
"function isDigit(aChar) { $$" +
"   var refString='1234567890'; $$" +
"   return refString.indexOf(aChar); $$" +
"} $$" +
" $$" +
"function isLowercase(aChar) { $$" +
"   var refString='abcdefghijklmnopqrstuvwxyz'; $$" +
"   return refString.indexOf(aChar); $$" +
"} $$" +
" $$" +
"function isUppercase(aChar) { $$" +
"   var refString='ABCDEFGHIJKLMNOPQRSTUVWXYZ'; $$" +
"   return refString.indexOf(aChar); $$" +
"} $$" +
" $$" +
"function isLetter(aChar) { $$" +
"   var out = isLowercase(aChar); $$" +
"   if ( 0 <= out ) return out; $$" +
"   return isUppercase(aChar); $$" +
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
"function isLetterString (inString) { $$" +
"   if (0==inString.length) return (false); $$" +
"   for (count=0; count<inString.length; count++) { $$" +
"      tempChar = inString.charAt(count); $$" +
"      if (-1 == isLetter(tempChar)) return (false); $$" +
"   } $$" +
"   return (true); $$" +
"} $$" +
" $$" +
"function isLetterOrDigitString(inString) { $$" +
"   if (0==inString.length) return (false); $$" +
"   for (count=0; count<inString.length; count++) { $$" +
"      tempChar = inString.charAt(count); $$" +
"      if (-1 == isLetter(tempChar) && $$" +
"          -1 == isDigit(tempChar)) return (false); $$" +
"   } $$" +
"   return (true); $$" +
"} $$" +
" $$" +
"function isLetterOrDigitOrSpaceString(inString) { $$" +
"   if (0==inString.length) return (false); $$" +
"   for (count=0; count<inString.length; count++) { $$" +
"      tempChar = inString.charAt(count); $$" +
"      if (-1 == isLetter(tempChar) && $$" +
"          -1 == isDigit(tempChar) && ' ' != tempChar) return (false); $$" +
"   } $$" +
"   return (true); $$" +
"} $$" +
" $$" +
"function isLetterOrSpaceString(inString) { $$" +
"   if (0==inString.length) return (false); $$" +
"   for (count=0; count<inString.length; count++) { $$" +
"      tempChar = inString.charAt(count); $$" +
"      if (-1 == isLetter(tempChar) && ' ' != tempChar) return (false); $$" +
"   } $$" +
"   return (true); $$" +
"} $$" +
" $$" +
" $$" +
" $$" +
"function checkFields(form) { $$" +
"  val2 = form.logName.value; $$" +
"  val3 = trim(val2); $$" +
"  if ( val2 != val3 ) { val2 = val3; form.logName.value = val2; } $$" +
"  out = isLetterOrDigitString(val2); $$" +
"  if ( 1 != out ) { alert('Enter or fix log name/ only letters or digits ...'); $$" +
"  return; }; $$" +
" $$" +
"  val2 = form.password.value; $$" +
"  val3 = trim(val2); $$" +
"  if ( val2 != val3 ) { val2 = val3; form.password.value = val2; } $$" +
"  out = isLetterOrDigitString(val2); $$" +
"  if ( 1 != out ) { alert('Enter or fix password ...'); return; }; $$" +
" $$" +
"  val2 = form.year.value; $$" +
"  if ( 4 != val2.length ) { alert('Enter year of birth ...'); return; }; $$" +
"  out = isDigitString(val2); $$" +
"  if ( 1 != out  ) { alert('Enter year of birth ...'); return; }; $$" +
"  number = parseInt(val2); $$" +
"  theDate = new Date(); theYear = theDate.getFullYear(); $$" +
"  if ( number < 1900 || theYear < number ) { alert('Enter year of birth ...'); return; }; $$" +
" $$" +
"  val2 = form.height.value; $$" +
"  if ( 3 < val2.length ) { alert('Enter height ...'); return; }; $$" +
"  out = isDigitString(val2); $$" +
"  if ( 1 != out  ) { alert('Enter height ...'); return; }; $$" +
	// "  number = parseInt(val2); $$" +
	// "  if ( number < 12 || 96 < number ) { alert('Enter heigth ...'); return; }; $$" +
" $$" +
"  val2 = form.weight.value; $$" +
"  out = isDigitString(val2); $$" +
"  if ( 1 != out  ) { alert('Enter weight ...'); return; }; $$" +
	// "  number = parseInt(val2); $$" +
	// "  if ( number < 2 || 500 < number ) { alert('Enter weight ...'); return; }; $$" +
" $$" +
"  form.submit(); $$" +
"} $$" +
"</script> $$" +
" $$" +
"<body> $$" +
"<font color=\"#850a0a\"> $$" +
" $$" +
"<h1 align=\"center\"> $$" +
"   <font color=\"#1C5540\" size=\"4\"> $$" +
	//"      OK, Lets Setup a New Account $$" +
L.startS2 + " $$" +
"   </font> $$" +
"</h1> $$" +
" $$" +
"<form method=\"post\" action=\"" + D.servletSetup + "\"> $$" +
"<table> $$" +
"<tr> $$" +
	//"  <td><b>To access your data:</b></td> $$" +
"  <td><b>" + L.startS3 + "</b></td> $$" +
"</tr> $$" +
"<tr> $$" +
"   <td>" + L.Identification + "</td> $$" +
"<td> $$";

String f1 =
    "  " + L.LoginName + " <input type=\"text\" size=\"10\" maxlength=\"10\" name=\"logName\" VALUE=\"LOGNAME\" />";
String f2 =
    "  " + L.Password  + " <input type=\"password\" size=\"10\" maxlength=\"10\" name=\"password\" VALUE=\"PASSWORD\" />";

String str2 =
"   </td> $$" +
"</tr> $$" +
" $$" +
"<tr> $$" + 
"  <td><b>" + L.SomeDetails + "</b></td> $$" +
"</tr> $$" +
"<tr> $$" +
"   <td>" + L.Gender + "</td> $$" +
"   <td> $$" +
"       <select name=\"gender\"> $$" +
"           <option value=\"female\" selected=\"selected\">" + L.female + "</option>  $$" +
"           <option value=\"male\">" + L.male + "</option>  $$" +
"       </select>    $$" +
"   </td> $$" +
"</tr> $$" +
"<tr> $$" +
"   <td>" + L.DateOfBirth + "</td> $$" +
"   <td> $$" +
"       " + L.Year + " <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"year\" value=\"yyyy\"> $$" +
    /*
"       " + L.Month + " $$" +
"       <select name=\"month\"> $$" +
"           <option value=\"Jan0\" selected=\"selected\"> Jan </option> $$" +
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

"   </td> $$" +
"</tr> $$" +
"<tr> $$" +
"   <td>" + L.PopulationGroup + "</td> $$" +
"   <td> $$" +
"       <select name=\"race\">    $$" +
"           <option value=\"africanAmerican\" selected=\"selected\"> african american  </option> $$" +
"           <option value=\"asian\"> asian  </option> $$" +
"           <option value=\"caucasian\"> caucasian  </option> $$" +
"           <option value=\"chineseAmerican\"> chinese american </option> $$" +
"           <option value=\"hispanic\"> hispanic/ latino   </option> $$" +
"           <option value=\"indianAmerican\"> indian american </option> $$" +
"           <option value=\"japaneseAmerican\"> japanese american </option> $$" +
"           <option value=\"jewishAmerican\"> jewish american </option> $$" +
"           <option value=\"nativeAmerican\"> native american  </option> $$" +
"       </select>    $$" +
"   </td> $$" +
"</tr> $$" +
" $$" +
"<tr> $$" +
"  <td>" + L.SexualOrientation + "</td> $$" +
"  <td>  $$" +
"       <select name=\"sexPartner\"> $$" +
"           <option value=\"hetero\" selected=\"selected\">" + L.oppositeSex + " </option> $$" +
"           <option value=\"same\">" + L.sameSex + " </option> $$" +
"           <option value=\"bi\">" + L.bothSexes + " </option> $$" +
"           <option value=\"none\">" + L.noneAbstain + " </option> $$" +
"       </select>    $$" +
"  </td> $$" +
"</tr> $$" +
"<tr> $$" +
"  <td>" + L.Miscellania + "</td> $$" +
"  <td>  $$" +
"       " + L.Height + " <input type=\"text\" size=\"3\" maxlength=\"3\" name=\"height\" /> $$" +
"       " + L.Weight + " <input type=\"text\" size=\"3\" maxlength=\"3\" name=\"weight\" /> $$" +
"       " + L.BloodGroup + " $$" +
"       <select name=\"bloodGroup\"> $$" +
"           <option value=\"unknown\" selected=\"selected\">" + L.unKnown + " </option> $$" +
"           <option value=\"O\"> O </option> $$" +
"           <option value=\"A\"> A </option> $$" +
"           <option value=\"B\"> B </option> $$" +
"           <option value=\"AB\"> AB </option> $$" +
"       </select>    $$" +
"  </td> $$" +
"</tr> $$" +
"</table> $$" +
" $$" +
" $$" +
"<hr /> $$" +
	//"Please check your data before submitting:  $$" +
L.Diag1bS13 + " $$" +
"<input type=\"button\" value=\"Submit\" onClick=\"checkFields(this.form)\" /> $$" +
"</form> $$" +
"<script language=\"JavaScript\"> document.forms[0].logName.focus(); </script> $$" +
" $$" +
"</font> $$" +
"</body> $$" +
"</html> $$";

    String name = "StartAnonymous";

    File genOut = new File("GenHtmlDir/" + name + ".java");
    FileOutputStream fosStr = new FileOutputStream(genOut);
    PrintWriter psStr = new PrintWriter(fosStr);

    psStr.println("// (C) OntoOO Inc 2004 Mar");
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

    // here f1 & f2
    psStr.println("  String f1 = \n");
    psStr.println("\"" + fix2(fix(f1)) + "\";");
    psStr.println("   out.println(f1); \n");
    psStr.println("  String f2 = \n");
    psStr.println("\"" + fix2(fix(f2)) + "\";");
    psStr.println("   out.println(f2); \n");

    psStr.println("    String str2 = \n");
    st = new StringTokenizer(str2, "$$");
    //String token;
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

    static public String fix(String str) {
	int idx = str.indexOf('"');
	if ( idx < 0 ) return str;
	return str.substring(0,idx) + "\\\"" + fix(str.substring(idx+1));
    }

    static public String fix2(String str) { return GenAngel.fix2(str); }


} // end class GenStartAnonymous








