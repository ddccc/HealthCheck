// (C) OntoOO Inc 2004
package gen;

import com.D;
import com.L;

import java.io.*;
import java.util.*;
 
public class GenProgWeight {

public static void main (String [] arguments) 
    throws Exception     {

    String str =
"<html> $$" +
"<head> $$" +
"   <title>" + L.WeightManagementProgram + "</title> $$" +
D.linkHckStyle +
D.favicon +
"<script language= \"JavaScript\"> $$" +
"function checkField (form) { $$" +
"        TestVar = isNumberString(form.myWeight.value) $$" +
"	if (TestVar == 1) form.submit(); else $$" +
"	alert('Please provide a number!');  $$" +
"	} $$" +
"function isNumberString (InString) { $$" +
"   if (InString.length==0) return (false); $$" +
"   var RefString='1234567890'; $$" +
"   for (Count=0; Count<InString.length; Count++) { $$" +
"      TempChar = InString.charAt(Count); $$" +
"      if (-1 == RefString.indexOf(TempChar)) return (false); $$" +
"   } $$" +
"   return (true); $$" +
"} $$" +
"</script> $$" +
"</head> $$" +
" $$" +
"<body> $$" +
"<font color=\"#850a0a\"> $$" +
" $$" +
	/*
"<table width=\"100%\"> $$" +
"<tr><td> $$" +
"    <img align=\"left\" height=\"34\" width=\"75\" border=\"1\" src=\"/logo2.jpg\" $$" +
"         onClick=\"alert('HC4M is a product of OntoOO Inc.  Visit: www.ontooo.com')\" /></td>  $$" +
"<td align=left> $$" +
"<font color=\"#1C5540\" size=\"4\"> $$" +
"<b>Welcome to Weight Management</b> $$" +
	*/
D.leftHeading + L.ProgWeightS1 + "</b> $$" +
"</font> $$" +
"</td></tr> $$" +
"</table> $$" +
" $$" +
	//"<H3>Please provide today's weight:</H3> $$" +
"<h3>" + L.ProgWeightS2 + "</h3> $$" +
"<form method=\"post\" action=\"" + D.servletProcessWeightValue + "\"> $$" +
"My weight is: <input type=\"text\" size=\"5\" maxlength=\"5\" name=\"myWeight\" value=\"\" /> $$" +
"<br /><hr /> $$" +
"<input type=\"button\" value=\"Submit\" onClick=\"checkField(this.form)\" /> $$" +
"<input type=\"hidden\" name=\"weightType\" value=\"weight\" /> $$" +
"</form> $$" +
"<script language=\"JavaScript\"> document.forms[0].myWeight.focus(); </script> $$" +
" $$" +
"<script language=\"JavaScript\" src=\"" + D.kangelJs + "\"> $$" +
"</script> $$" +
" $$" +
"</font> $$" +
"</body > $$" +
"</html> $$";



    File genOut = new File("GenHtmlDir/ProgWeight.html");

    FileOutputStream fosStr = new FileOutputStream(genOut);
    PrintWriter psStr = new PrintWriter(fosStr);

    StringTokenizer st = new StringTokenizer(str, "$$");
    while ( st.hasMoreTokens() )
	psStr.println(st.nextToken());

    psStr.flush();     psStr.close();

} // end of main

} // end class GenProgWeight


