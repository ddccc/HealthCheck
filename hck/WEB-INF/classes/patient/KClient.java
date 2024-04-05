// (C) OntoOO Inc 2000
package patient;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.DV;
import com.D;

public class KClient extends HttpServlet {
  static public String synchroObject = "synchroObject";
  static public Hashtable allKClients = null;
  static public HttpSession getKClient(String key) {
    return (HttpSession) allKClients.get(key);
  }
  static public void putKClient(String key, HttpSession session) {
      if ( null != key ) allKClients.put(key, session);
  }
  static public void removeKClient(String key) {
      if ( null != key ) allKClients.remove(key);
  }
  static public Enumeration allKClientKeys() {
    return allKClients.keys();
  }  
  static public Enumeration allKClientSessions() {
    return allKClients.elements();
  }

  static public KClientDigest kClientDigest = null;

  static private Vector theClientDigest = new Vector();
  static public void setTheClientDigest(Vector nextDigest) {
    theClientDigest = nextDigest;
  }
  static public Vector getTheClientDigest() { return theClientDigest; }

  static private byte pix1 [] = new byte[0];
  static private byte pix2 [] = new byte[0];

  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    synchronized(KClient.synchroObject) {
	// this will start the digest 
	if ( null == KClient.allKClients ) {
	    KClient.allKClients = new Hashtable();
	    KClient.kClientDigest = new KClientDigest();
	    KClient.kClientDigest.start();
	}
    }
    /*
    allKClients = new Hashtable();
    kClientDigest = new KClientDigest();
    kClientDigest.start();
    try {
	String fileRoot = D.htmlDir;
	File aFile = new File(fileRoot + "pix1.gif");
	FileInputStream fis = new FileInputStream(aFile);
	int size = (int) aFile.length();
	pix1 = new byte[size];
	fis.read(pix1);
	aFile = new File(fileRoot + "pix2.gif");
	fis = new FileInputStream(aFile);
	size = (int) aFile.length();
	pix2 = new byte[size];
	fis.read(pix2);
    } catch (Exception ignore) {}
    */
  }

  public void doGet (HttpServletRequest req, 
		     HttpServletResponse res)
       throws ServletException, IOException
  {
    String counter = req.getParameter("counter"); // is not used ...
    String page = req.getParameter("page");
    HttpSession session = req.getSession(false);
    if ( null == session ) { // cannot happen ...
	/*
	res.setContentType("image/gif");
	ServletOutputStream out = res.getOutputStream();
	out.write(pix1);
	*/
	res.sendRedirect(D.dotGif);
	return;
    }
    String sessionId = session.getId();
    session.putValue("counter", counter);
    Integer pageCnt, surfCnt;
    Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");

    if ( !allKClients.containsKey(sessionId) ) { // new session

      // init this session 
      session.putValue("state", "initial");
      Vector chatRecord = new Vector();
      String logName = (String) session.getValue("logName");
      Date now = new Date(); // to create an anchor value ...
      long anchor = now.getTime();
      chatRecord.addElement(
           "<b>**Client logName:**</b> " +
	   "<a href=\"#" + anchor + 
	       "\" name=\"" + anchor + 
               "\" onClick=\"showAccount('user','" +
			               logName + "')\">" + logName + "</a><br />");
      // preparation to store a chatRecord - if any - in logSessions
      unboundHashtable.put("chatRecord", chatRecord);
      session.putValue("chatRecord", chatRecord);
      session.putValue("chatClient", new Vector());
      session.putValue("chatCallPerson", new Vector());
      session.putValue("page", page);
      pageCnt = new Integer(1);
      session.putValue("pageCnt", pageCnt);
      unboundHashtable.put("pageCnt", pageCnt);
      surfCnt = new Integer(0);
      session.putValue("surfCnt", surfCnt);
      // finally add this client
      putKClient(sessionId, session);
    } else { // existing session
      String currentPage = (String) session.getValue("page");
      if ( !page.equals(currentPage) ) {
	session.putValue("page", page);
	pageCnt = (Integer) session.getValue("pageCnt");
	pageCnt = new Integer(1+ pageCnt.intValue());
	session.putValue("pageCnt", pageCnt);
	unboundHashtable.put("pageCnt", pageCnt);
      }
      surfCnt = (Integer) session.getValue("surfCnt");
      surfCnt = new Integer(1+ surfCnt.intValue());
      session.putValue("surfCnt", surfCnt);
    }
    unboundHashtable.put("surfCnt", surfCnt);

    String state = (String) session.getValue("state");
    // res.setContentType("image/gif");

    if ( state.equals("invited") ) { // abnormal response
	// System.out.println("KClient: invited response " + counter);
      session.putValue("state", "openWindow");
      // res.setContentType("image/gif");
      // out.write(pix2);
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html><body></body></html>");
      return;
    }

    synchronized(KClient.synchroObject) {
	String sendAlert = (String) session.getValue("sendAlert");
	if ( null != sendAlert ) {
	    // System.out.println("KClient: sendAlert response " + counter);
	    session.removeValue("sendAlert");
	    session.putValue("sendAlert2", sendAlert);
	    res.setContentType("text/html");
	    ServletOutputStream out = res.getOutputStream();
	    out.println("<html><body></body></html>");
	    return;
	}
    }

    // normal response
    // System.out.println("KClient: NORMAL response " + counter);
    res.sendRedirect(D.dotGif);
    /*
    res.setContentType("image/gif");
    out.write(pix1);
    */
  }
}



