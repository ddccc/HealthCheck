// (C) OntoOO Inc 2002
package patient;

import java.util.*;
// import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import misc.DB;

public class KClientDigest implements Runnable {
    static final private int updateInterval = 3000; // 3 secs
    static private boolean again = true;
    static private Thread myThread = null;
    static private int cnt = 0;
    static public int getCnt() { return cnt; }


  public KClientDigest() {
    if ( null == myThread ) myThread = new Thread(this);
  }

  public void start() { myThread.start(); }

  public void run() {
    
    while ( again ) {
      cnt++;
      Vector nextDigest = new Vector();
      Enumeration enumz = KClient.allKClientKeys();
      while ( enumz.hasMoreElements() ) {
	String clientId = (String) enumz.nextElement();
	HttpSession clientSession = KClient.getKClient(clientId);
	Vector clientVector = new Vector();
	clientVector.addElement(clientId); // 0
	String state = (String) clientSession.getValue("state");
	if ( null == state ) state = "state not available";
	clientVector.addElement(state); // 1
	DB props = (DB) clientSession.getValue("theDB");
	String client = props.getProperty("userName");
	if ( null == client ) client = (String) clientSession.getValue("logName");
	clientVector.addElement(client); // 2
	String page = (String) clientSession.getValue("page");
	clientVector.addElement(page); // 3
	Integer pageCnt = (Integer) clientSession.getValue("pageCnt");
	clientVector.addElement(pageCnt); // 4
	Integer surfCnt = (Integer) clientSession.getValue("surfCnt");
	clientVector.addElement(surfCnt); // 5
	String foundLifeThreateningDisease = 
		(String) clientSession.getValue("foundLifeThreateningDisease");
	clientVector.addElement(foundLifeThreateningDisease); //6
	String diagnosis = (String) clientSession.getValue("diagnosis");
	clientVector.addElement(diagnosis); // 7

	nextDigest.addElement(clientVector);
      }
      KClient.setTheClientDigest(nextDigest);
      try {
	Thread.sleep(updateInterval);
      } catch (InterruptedException ignore) {}
    }
  }

  public void stop() {
    again = false;
  }

}



