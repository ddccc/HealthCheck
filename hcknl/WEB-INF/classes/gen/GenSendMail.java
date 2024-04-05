// (C) OntoOO Inc 2004
package gen;

import com.D;
import com.L;

import java.io.*;
import java.util.*;
 
public class GenSendMail {

public static void main (String [] arguments) 
    throws Exception     {

    String str = 
"<html> $$" +
"<head> <title>" + L.SendMail + "</title> $$" +
D.linkHckStyle +
D.favicon +
"</head> $$" +
"<script language=\"JavaScript\"> $$" +
"function checkFields(form) { $$" +
"	if ( \"\" != form.messageBody.value ) { $$" +
	//"               document.myForm.test.value = code; $$" +
	//"               document.myForm.instruction.value = \"\"; $$" +
"               form.submit(); $$" +
"	} else $$" +
"		alert(\"Why sending an empty message ??\"); $$" +
"} $$" +
	/*
"var instruction = \"\"; $$" +
"var code=\"\"; $$" +
"function makeInstruction() { $$" +
"   var instr1 = makeInstruction1(); $$" +
"   var instr2 = makeInstruction1(); $$" +
"   var instr3 = makeInstruction1(); $$" +
"   instruction = instr1 + \"\\n\" + $$" +
"                 instr2 + \"\\n\" + $$" +
"                 instr3; $$" +
"   document.myForm.instruction.value= $$" +
"   \"To fight spam, please type in the box below the letters \" +  $$" +
"   \"you find in the figures to the left according to:\\n\" + $$" +
"   instruction; $$" +
"} $$" +
"function makeInstruction1() { $$" +
"  var instr = \"\"; $$" +
"  var fig = selectFigure(); $$" +
"  if ( 0 == fig ) { $$" +
"     instr = \"   From the circle \"; $$" +
"     code = code + \"0\"; $$" +
"  } else if ( 1 == fig ) { $$" +
"     instr = \"   From the rectangle \"; $$" +
"     code = code + \"1\"; $$" +
"  } else { $$" +
"     instr = \"   From the triangle \"; $$" +
"     code = code + \"2\"; $$" +
"  } $$" +
"  var let = selectLetter(); $$" +
"  if ( 0 == let ) { $$" +
"     instr = instr + \"the first letter\"; $$" +
"     code = code + \"0\"; $$" +
"  } else { $$" +
"     instr = instr + \"the second letter\"; $$" +
"     code = code + \"1\"; $$" +
"  } $$" +
"  return instr; $$" +
"} $$" +
"function selectFigure() { $$" +
"  var x = Math.random(); $$" +
"  if ( x < 0.3 ) return 0; $$" +
"  if ( x < 0.6 ) return 1; $$" +
"  return 2; $$" +
"} $$" +
"function selectLetter() { $$" +
"  var x = Math.random(); $$" +
"  if ( x < 0.5 ) return 0; $$" +
"  return 1; $$" +
"} $$" +
	*/
"</script> $$" +
"<body> $$" +
"<font color=\"#850a0a\"> $$" +
" $$" +
"<h1 align=\"center\"> $$" +
"   <font color=\"#1C5540\" size=\"6\"> $$" +
"      " + L.SendMail + " $$" +
"   </font> $$" +
"</h1> $$" +
" $$" +
"<form method=\"get\" action=\"" + D.servletSendEmail + "\" name=\"myForm\"> $$" +
" $$" +
	//"Your email address if you want an answer:  $$" +
L.SendMailS1 + " $$" +
"<input type=\"text\" size=\"50\" maxlength=\"50\" name=\"emailAddress\" /><p> $$" +
L.YourMessage + "<br> $$" +
"<textarea cols=\"75\" rows=\"20\" name=\"messageBody\">$$" +
"</textarea><p> $$" +
" $$" +
"<input type=\"button\" value=\"Submit\" onClick=\"checkFields(this.form)\" /> $$" +
"<input type=\"button\" value=\"Back/Cancel\" onClick=\"history.back()\" /> $$" +
"<input type=\"button\" value=\"Home\" onClick=\"location='" + D.indexHtml + "'\" /> $$" +
"<input type=\"hidden\" name=\"subject\" value=\"Site Feedback\" />  $$" +
"<input type=\"hidden\" name=\"test\" value=\"YouAreIdiots7081943000079999999999999\" />  $$" +
	/*
"<p> $$" +
"<table> $$" +
"<tr> $$" +
"<td> $$" +
"<img border=\"1\" src=\"" + D.mailJpg + "\"> $$" +
"</td> $$" +
"<td> $$" +
"<textarea COLS=\"60\" ROWS=\"5\" name=\"instruction\"></textarea><br>$$" +
"<textarea COLS=\"4\" ROWS=\"1\" name=\"userReply\"></textarea>$$" +
"</td> $$" +
"</tr> $$" +
"</table> $$" +
	*/
"</form> $$" +
"</font> $$" +
"</body> $$" +
	/*
"<script language=\"JavaScript\"> $$" +
"makeInstruction(); $$" +
"</script>  $$" +
	*/
"</html> $$";



    File genOut = new File("GenHtmlDir/SendMail.html");

    FileOutputStream fosStr = new FileOutputStream(genOut);
    PrintWriter psStr = new PrintWriter(fosStr);

    StringTokenizer st = new StringTokenizer(str, "$$");
    while ( st.hasMoreTokens() )
	psStr.println(st.nextToken());

    psStr.flush();     psStr.close();

} // end of main

} // end class GenFaq


