// (C) OntoOO Inc 2004
package gen;

import com.D;
import com.L;

import java.io.*;
import java.util.*;
 
public class GenGetTargetWeight  {

public static void main (String [] arguments) 
    throws Exception     {

    String str =
"<html> $$" +
"<head> $$" +
	//"   <title>Weight Management Program</title> $$" +
"   <title>" + L.GTWS1 + "</title> $$" +
"<script language=\"JavaScript\"> $$" +
"function checkField (form) { $$" +
"        TestVar = isNumberString(form.myWeight.value) $$" +
"	if (TestVar == 1) form.submit(); else $$" +
"	alert('Please provide a number!');  $$" +
"	} $$" +
"function isNumberString (InString) { $$" +
"   if (InString.length==0) return (false); $$" +
"   var RefString='1234567890'; $$" +
"   for (Count=0; Count<InString.length; Count++) { $$" +
"      TempChar = InString.substring(Count, Count+1); $$" +
"      if (-1 == RefString.indexOf(TempChar, 0)) return (false); $$" +
"   } $$" +
"   return (true); $$" +
"} $$" +
"</script> $$" +
D.linkHckStyle +
D.favicon +
"</head> $$" +
" $$" +
"<body> $$" +
"<font color=\"#850a0a\"> $$" +
" $$" +
	/*
"<table width=\"100%\"> $$" +
"<tr><td> $$" +
"    <img align=\"left\" height=\"34\" width=\"75\" border=\"1\" src=\"" + D.logoJpg + "\" $$" +
"         onClick='alert(\"HC4M is a product of OntoOO Inc.  Visit: www.ontooo.com\")' /></td>  $$" +
"<td align=\"left\"> $$" +
"<font color= "#1C5540" size=\"4\"> $$" +
"<b>Welcome to Weight Management</b> $$" +
	*/
D.leftHeading + L.GTWS2 + "</b> $$" +
"</font> $$" +
"</td></tr> $$" +
"</table> $$" +
" $$" +
	//"<h3> Please provide your TARGET weight: </h3> $$" +
"<h3>" + L.GTWS3 + "</h3> $$" +
"<form method=\"post\" action=\"" + D.servletProcessWeightValue + "\"> $$" +
	//"My target weight is:  $$" +
L.GTWS4 + " $$" +
"<input type=\"tetxt\" size=\"5\" maxlength=\"5\" name=\"myWeight\" value=\"\" /> $$" +
"<br /><hr /> $$" +
"<input type=\"button\" value=\"Submit\" onClick=\"checkField(this.form)\" /> $$" +
"<input type=\"hidden\" name=\"weightType\" value=\"targetWeight\"> $$" +
"</form> $$" +
"<script language=\"JavaScript\"> document.forms[0].myWeight.focus(); </script> $$" +
" $$" +
"<script language=\"JavaScript\" src=\"" + D.kangelJs + "\"> $$" +
"</script> $$" +
" $$" +
"</font> $$" +
"</body> $$" +
"</html> $$";

    File genOut = new File("GenHtmlDir/GetTargetWeight.html");
    FileOutputStream fosStr = new FileOutputStream(genOut);
    PrintWriter psStr = new PrintWriter(fosStr);

    StringTokenizer st = new StringTokenizer(str, "$$");
    while ( st.hasMoreTokens() )
	psStr.println(st.nextToken());

    psStr.flush();     psStr.close();

} // end of main

} // end class GenFaq


