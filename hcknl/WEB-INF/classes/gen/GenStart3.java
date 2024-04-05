// (C) OntoOO Inc 2004
package gen;

import concepts.Disease;
import com.Common;
import com.D;
import com.L;

import java.io.*;
import java.util.*;
 
public class GenStart3 {

public static void main (String [] arguments) 
    throws Exception     {

    String str = 
"<html> $$" +
"<head> $$" +
"   <title> $$" +
	//"      Set up new user 3 $$" +
L.start3S1 + " $$" +
"   </title> $$" +
D.linkHckStyle +
D.favicon +
"</head> $$" +
"<script language=\"JavaScript\"> $$" +
"function isNumberString (InString) { $$" +
"   if (0==InString.length) return (false); $$" +
"   var RefString='1234567890'; $$" +
"   for (Count=0; Count<InString.length; Count++) { $$" +
"      TempChar = InString.charAt(Count); $$" +
"      if (-1 == RefString.indexOf(TempChar)) return (false); $$" +
"   } $$" +
"   return (true); $$" +
"} $$" +
"function checkFields(form) { $$" +
"   lng = form.illnesses.length; $$" +
"   // alert('lng: ' + lng); $$" +
"   for (i = 0; i<lng; i++) {  $$" +
"      if ( form.illnesses[i].checked ) { $$" +
"         val = form.illnesses[i].value; $$" +
"	 // alert('val: ' + val + ' i: ' + i); $$" +
"	 expr = 'form.' + val; $$" +
"	 //alert('expr: ' + expr); $$" +
"	 val2 = (eval(expr)).value; $$" +
"	 // alert('val2: ' + val2); $$" +
"	 if ( 4 != val2.length ) { $$" +
"	    alert('Provide year for: ' + val); $$" +
"	    return; $$" +
"	 } $$" +
"	 isNumber = isNumberString(val2); $$" +
"	 if ( 1 != isNumber  ) { $$" +
"	    alert('Provide year for: ' + val); $$" +
"	    return; $$" +
"	 } $$" +
"	 number = parseInt(val2); $$" +
"        theDate = new Date(); theYear = theDate.getFullYear(); $$" +
"	 if ( number < 1900 || theYear < number ) { $$" +
"	    alert('Provide year for: ' + val); $$" +
"	    return; $$" +
"	 } $$" +
"      }  $$" +
"  }  $$" +
"  form.submit(); $$" +
"} $$" +
"</script> $$" +
" $$" +
"<body> $$" +
"<font color=\"#850a0a\"> $$" +
" $$" +
"<h1 align=\"center\"> $$" +
"   <font color=\"#1C5540\" size=\"4\"> $$" +
//"      OK, Here the 3rd and Last Set of Questions $$" +
L.start3S2 + " $$" +
"   </font> $$" +
"</h1> $$" +
" $$" + 
"<form method=\"post\" name=\"diseases\" action=\"" + D.servletSetup3 + "\"> $$" +
"<table border=\"1\"> $$" +
"<tr> $$" +
"  <td><b>" + L.Illnesses + "</b></td> $$" +
"</tr> $$" +
"<tr> $$" +
//"  <td colspan=3>Check which apply & add year of illness</td> $$" +
"  <td colspan=\"3\">" + L.start3S3 + "</td> $$" +
"</tr> $$" +
makeEntry("asthma") +
makeEntry("cystitis") +
makeEntry("cancer") +
makeEntry("chickenpox") +
makeEntry("diabetes") +
makeEntry("emphysema") +
makeEntry("cholelithiasis") +
makeEntry("glaucoma") +
makeEntry("gonorrhea") +
makeEntry("gout") +
makeEntry("myocardialInfarction") +
makeEntry("hepatitis") +
makeEntry("pyelonephritis") +
makeEntry("renalCalculi") +
makeEntry("malaria") +
makeEntry("measles") +
makeEntry("rubella") +
makeEntry("epsteinBarrDisease") +
makeEntry("mumps") +
makeEntry("pneumonia") +
makeEntry("rheumaticFever") +
makeEntry("cerebrovascularAccident") +
makeEntry("syphilis") +
makeEntry("tuberculosis") +
" $$" +
"</table> $$" +
" $$" +
"<hr /> $$" +
//"Please check all fields before submitting:  $$" +
L.Diag1bS13 + " $$" +
"<input type=\"button\" value=\"Submit\" onClick=\"checkFields(this.form)\" /> $$" +
"</form> $$" +
" $$" +
"</font> $$" +
"</body> $$" +
"</html> $$";


    String name = "Start3";
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
       "     call(res); \n" +
       "} \n" +
       " \n" +
       "static public void call(HttpServletResponse res) \n" +
       "    throws IOException { \n" +
       "    res.setContentType(\"text/html\"); \n" +
       "    ServletOutputStream out = res.getOutputStream(); \n" +
       "    String str = \n");
    psStr.println();

    StringTokenizer st = new StringTokenizer(str, "$$");
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
    psStr.println("   out.println(str); \n");
    psStr.println("}}");

    psStr.flush();     psStr.close();

} // end of main

    static public String fix(String str) {
	int idx = str.indexOf('"');
	if ( idx < 0 ) return str;
	return str.substring(0,idx) + "\\\"" + fix(str.substring(idx+1));
    }


    static private String makeEntry(String diseaseName) {
	Disease dis = Common.getDisease(diseaseName);
	String pn = dis.getPrintName();
	String description = dis.getDescription();
	return 
"<tr><td>" + pn + " / " + description + " $$" +
"    </td><td> <input type=\"checkbox\" name=\"illnesses\" $$" +
"       value=\"" + diseaseName + "\" /> $$" +
"  </td><td> $$" +
"       <input type=\"text\" size=\"4\" maxlength=\"4\" name=\"" + diseaseName + "\" value=\"\" /> $$" +
"  </td></tr> $$";
    }


} // end class GenStart3














