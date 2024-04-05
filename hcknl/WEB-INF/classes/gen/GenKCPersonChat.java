// (C) OntoOO Inc 2004
package gen;

import com.D;
import com.L;

import java.io.*;
import java.util.*;
 
public class GenKCPersonChat  {

public static void main (String [] arguments) 
    throws Exception     {

    String str =
"<html> $$" +
"<head><title>" + L.CCPersonChat + "</title></head> $$" +
" $$" +
"<frameset rows=\"50%,35%,15%\"> $$" +
"   <frame name=\"header2\" src=\"" + D.servletKChatCPersonTop + "\" /> $$" +
"   <frameset cols=\"99%,1%\"> $$" +
"	<frame name=\"canvas2\" src=\"" + D.kblankHtml + "\" /> $$" +
"	<frame name=\"scribe2\" src=\"" + D.servletKCPersonScribe + "\" /> $$" +
"   </frameset> $$" +
"   <frame name=\"input2\" src=\"" + D.kChatCPersonInputHtml + "\" /> $$" +
"</frameset> $$" +
"</html> $$";


    File genOut = new File("GenHtmlDir/kCPersonChat.html");

    FileOutputStream fosStr = new FileOutputStream(genOut);
    PrintWriter psStr = new PrintWriter(fosStr);

    StringTokenizer st = new StringTokenizer(str, "$$");
    while ( st.hasMoreTokens() )
	psStr.println(st.nextToken());

    psStr.flush();     psStr.close();

} // end of main

} // end class GenFaq


