// (C) OntoOO Inc 2004
package gen;

import com.D;
import com.L;

import java.io.*;
import java.util.*;
 
public class GenStart2 {

public static void main (String [] arguments) 
    throws Exception     {

    String str = 
"<html> $$" +
"<head> $$" +
"   <title> $$" +
	//"      Set up new user 2 $$" +
L.start2S1 + " $$" +
"   </title> $$" +
D.linkHckStyle +
D.favicon +
"</head> $$" +
" $$" +
"<body> $$" +
"<font color=\"#850a0a\"> $$" +
" $$" +
"<h1 align=\"center\"> $$" +
"   <font color=\"#1C5540\" size=\"4\"> $$" +
	//"      OK, Here the 2nd Set of Questions $$" +
L.start2S2 + " $$" +
"   </font> $$" +
"</h1> $$" +
" $$" +
"<form method=\"post\" action=\"" + D.servletSetup2 + "\"> $$" +
"<table> $$" +
"<tr> $$" +
"  <td><b>" + L.LifeStyle + "</b></td> $$" +
"</tr> $$" +
"<tr> $$" +
"  <td>" + L.MaritalStatus + "</td> $$" +
"  <td>  $$" +
"       <select name=\"maritalStatus\"> $$" +
"           <option value=\"single\" selected=\"selected\">" + L.single + "</option> $$" +
"           <option value=\"marriedOK\">" + L.marriedOK + "</option> $$" +
"           <option value=\"marriedNotOK\">" + L.marriedNotOK + "</option> $$" +
"           <option value=\"remarried\">" + L.remarried + "</option> $$" +
"           <option value=\"separated\">" + L.separated + "</option> $$" +
"           <option value=\"divorced\">" + L.divorced + "</option> $$" +
"           <option value=\"widow(er)\">" + L.widow + "</option> $$" +
"       </select>    $$" +
"  </td> $$" +
"</tr> $$" +
"<tr> $$" +
"  <td>" + L.Smoking + "</td> $$" +
"  <td>  $$" +
"       <select name=\"smoking\"> $$" +
"           <option value=\"none\" selected=\"selected\">" + L.none + "</option> $$" +
"           <option value=\"lessThanOnePackDay\">" + L.lessThanOnePackDay + "</option> $$" +
"           <option value=\"onePackDay\">" + L.onePackDay + "</option> $$" +
"           <option value=\"twoPackDay\">" + L.twoPackDay + "</option> $$" +
"           <option value=\"moreThanTwoPackDay\">" + L.moreThanTwoPackDay + "</option> $$" +
"       </select>    $$" +
"  </td> $$" +
"</tr> $$" +
"<tr> $$" +
"  <td>" + L.Alcohol + "</td> $$" +
"  <td>  $$" +
"       <select name=\"alcohol\"> $$" +
"           <option value=\"never\" selected=\"selected\">" + L.never + "</option> $$" +
"           <option value=\"infrequent\">" + L.infrequent + "</option> $$" +
"           <option value=\"frequent\">" + L.frequent + "</option> $$" +
"           <option value=\"daily\">" + L.daily + "</option> $$" +
"       </select>    $$" +
"  </td> $$" +
"</tr> $$" +
"<tr> $$" +
"  <td>" + L.Exercising + " </td> $$" +
"  <td>  $$" + 
"       <select name=\"exercising\"> $$" +
"           <option value=\"never\" selected=\"selected\">" + L.never + "</option> $$" +
"           <option value=\"infrequent\">" + L.infrequent + "</option> $$" +
"           <option value=\"frequent\">" + L.frequent + "</option> $$" +
"           <option value=\"daily\">" + L.daily + "</option> $$" +
"       </select>    $$" +
"  </td> $$" +
"</tr> $$" +
"<tr> $$" +
	//"  <td> Sources of Tension and Worries: </td> $$" +
"  <td>" + L.start2S3 + "</td> $$" +
"  <td>  $$" +
"       <input type=\"checkbox\" name=\"stress\" value=\"job\" />" + L.job + " $$" +
"       <input type=\"checkbox\" name=\"stress\" value=\"spouse\" />" + L.spouse + " $$" +
"       <input type=\"checkbox\" name=\"stress\" value=\"finances\" />" + L.finances + " $$" +
"       <input type=\"checkbox\" name=\"stress\" value=\"religion\" />" + L.religion + " $$" +
"       <input type=\"checkbox\" name=\"stress\" value=\"colleages\" />" + L.fellowEmployees + " $$" +
"       <input type=\"checkbox\" name=\"stress\" value=\"drugs\" />" + L.drugs + " $$" +
"       <input type=\"checkbox\" name=\"stress\" value=\"alcohol\" />" + L.alcohol + " $$" +
"  </td> $$" +
"</tr> $$" +
" $$" +
"</table> $$" +
" $$" +
"<hr /> $$" +
	//"Please check all fields before submitting:  $$" +
L.Diag1bS13 + "  $$" +
"<input type=\"submit\" value=\"Submit\" /> $$" +
"</form> $$" +
" $$" +
"</font> $$" +
"</body> $$" +
"</html> $$";



    String name = "Start2";
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


} // end class GenStart2








