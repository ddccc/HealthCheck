// (C) OntoOO Inc 2004
package gen;

import java.util.Vector;
// import java.util.Hashtable;
// import java.util.Properties;
// import java.util.Enumeration;
import java.io.*;

public class GenHtml {

public static void main (String [] arguments) 
    throws Exception {

    // adjust the next line to create a file that is the source for a generator
    String fileName = "c:/jrun/jsm-default/services/jws/htdocs/Angel.html";

    File genIn = new File(fileName);
    FileInputStream fis = new FileInputStream(genIn);
    DataInputStream in = new DataInputStream(fis);

    File genOut = new File("genHtml.txt");
    FileOutputStream fosStr = new FileOutputStream(genOut);
    PrintWriter psStr = new PrintWriter(fosStr);

    String line = null;
    while ((line = in.readLine()) != null ) {
	line = line.replace('"', '\'');
	// psStr.println("//\"" + line + "\" +");
	psStr.println("\"" + line + " $$\" +");
    }

    psStr.flush();     psStr.close();
} // end of main

} // end class GenHtml


