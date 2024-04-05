// (C) OntoOO Inc 2004
package gen;

import com.D;
import com.L;


import java.io.*;
import java.util.*;
 
public class GenKClientChat  {

public static void main (String [] arguments) 
    throws Exception     {

    String str =
"<html> $$" +
"<head><title>" + L.ClientChat + "</title></head> $$" +
" $$" +
"<frameset rows=\"10%,75%,15%\"> $$" +
"   <frame name=\"header1\" src=\"" + D.servletKChatClientTop + "\" /> $$" +
"   <frameset cols=\"99%,1%\"> $$" +
"	<frame name=\"canvas1\" src=\"" + D.kblankHtml + "\" /> $$" +
"	<frame name=\"scribe1\" src=\"" + D.servletKClientScribe + "\" /> $$" +
"   </frameset> $$" +
"   <frame name=\"input1\" src=\"" + D.kChatClientInputHtml + "\" /> $$" +
"</frameset> $$" +
"</html> $$";


    File genOut = new File("GenHtmlDir/kClientChat.html");

    FileOutputStream fosStr = new FileOutputStream(genOut);
    PrintWriter psStr = new PrintWriter(fosStr);

    StringTokenizer st = new StringTokenizer(str, "$$");
    while ( st.hasMoreTokens() )
	psStr.println(st.nextToken());

    psStr.flush();     psStr.close();

} // end of main

} // end class GenFaq


