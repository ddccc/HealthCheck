// (C) OntoOO Inc 2003 Aug
package su;

import java.util.*;
import java.io.*;

import com.IO;
import com.D;
import misc.DB;

/*
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.DV;
import com.DVM;
import com.D;
import users.HCError;
*/


public class ZZ {

public static void main (String [] arguments) {

    Vector allAccounts = IO.readOrCreateVector(D.userAccounts);
    int lng = allAccounts.size();
    Vector allAccounts2 = new Vector();
    String account;
    DB props;
    String prefix2 = D.theUsersDir;
    System.out.println("--- Accessing all accounts lng= " + lng); 
    for (int i=0; i<lng; i++) {
	account = (String) allAccounts.elementAt(i);
	props = null;
	try {
	    props = new DB(prefix2 + account);
	} catch (IOException ignore) {}
	if ( null == props ) { 
	    System.out.println("### can't find props for: " + account); 
	    continue; // screwed up/ hence ignore
	}
	allAccounts2.addElement(props);
    }
    Collections.sort(allAccounts2);

    lng = allAccounts2.size();
    System.out.println("--- Accessing log sessions lng= " + lng); 
    String fileName;
    String accountCreationDate;
    int cntNoFile = 0;
    int cntException = 0;
    int cntOK = 0;
    for (int i = 0; i < lng; i++) {
	props = (DB) allAccounts2.elementAt(i);
	fileName = props.getProperty("fileName");
	accountCreationDate = props.getProperty("accountCreationDate");
	long x = 0;
	try { x = Long.parseLong(accountCreationDate); }
	catch (NumberFormatException ignore) {}
	Date aDate = new Date(x);
	accountCreationDate = aDate.toString();
	String vecName = D.theUsersDir+fileName+"logSessions";
	File aFile = new File(vecName);
	if ( !aFile.exists() ) {
	    cntNoFile++;
	    continue;
	}
	Vector vec = null;
	try {
	    FileInputStream fis = new FileInputStream(aFile);
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    vec = (Vector) ois.readObject();
	    ois.close();
	    fis.close();
	} catch (Exception ex) {
	    System.out.println("Exception: readVector vecName: " + 
			       vecName + " " + ex.getMessage());
	    cntException++;
	    continue;
	}
	cntOK++;
    }
    System.out.println("lng=          " + lng + "\n" +
		       "cntNoFile=    " + cntNoFile + "\n" +
		       "cntException= " + cntException + "\n" +
		       "cntOK=        " + cntOK + "\n" +
		       "sum=          " + (cntNoFile + cntException + cntOK));


} // end of main

} // end class ZZ
