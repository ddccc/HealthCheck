// (C) OntoOO Inc 2003 Aug
package su;

import java.util.*;
import java.io.*;

import com.IO;
import com.D;
import misc.DB;
import patient.DiseaseInst0;
import com.Common;



public class ZModifyLogSession0 {

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
    int cntNoFile = 0;
    int cntException = 0;
    int cntOK = 0;
    for (int i = 0; i < lng; i++) {
	props = (DB) allAccounts2.elementAt(i);
	fileName = props.getProperty("fileName");
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
	Hashtable ht =(Hashtable) vec.elementAt(0);
	Vector historyOfDiseases = (Vector) ht.get("historyOfDiseases");
	int lng2 = historyOfDiseases.size();
	if ( lng2 <= 0 ) continue;
	System.out.println("lng2= " + lng2 + " fileName: " + fileName);
	Vector his2 = new Vector();
	for (int j = 0; j < lng2; j++) {
	    DiseaseInst0 di0 = (DiseaseInst0) historyOfDiseases.elementAt(j);
	    String disease = di0.getDisease();
	    Date dat = di0.getDateTime();
	    String source = di0.getSource();
	    DiseaseRecord dr = new DiseaseRecord(disease, dat, source);
	    his2.addElement(dr);
	}
	Hashtable ht2 = new Hashtable();
	ht2.put("historyOfDiseases", his2);
	Vector vec2 = (Vector) vec.clone();
	vec2.set(0, ht2);
	Common.saveLogSessions(fileName, vec2);
    }
    System.out.println("lng=          " + lng + "\n" +
		       "cntNoFile=    " + cntNoFile + "\n" +
		       "cntException= " + cntException + "\n" +
		       "cntOK=        " + cntOK + "\n" +
		       "sum=          " + (cntNoFile + cntException + cntOK));


} // end of main

} // end class ZZ
