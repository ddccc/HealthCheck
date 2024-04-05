// (C) OntoOO Inc 2002
package cc;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.DVM;
import com.D;
import patient.KClient;
import patient.KClientDigest;
import misc.HCError;

public class KCallPerson extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
         super.init(config);
	 // to start up the digest thread ...
	 synchronized(KClient.synchroObject) {
	     // this will start the digest 
	     if ( null == KClient.allKClients ) {
		 KClient.allKClients = new Hashtable();
		 KClient.kClientDigest = new KClientDigest();
		 KClient.kClientDigest.start();
	     }
	 }
    }

    static final private String refreshInterval = "4"; // seconds

    static private Hashtable allKCallPersons = new Hashtable();
    static public HttpSession getKCallPerson(String key) {
	return (HttpSession) allKCallPersons.get(key);
    }
  static public void putKCallPerson(String key, HttpSession session) {
    allKCallPersons.put(key, session);
  }
  static public void removeKCallPerson(String key) {
    allKCallPersons.remove(key);
  }
  static public Enumeration allKCallPersonKeys() {
    return allKCallPersons.keys();
  }  
  static public Enumeration allKCallPersonSessions() {
    return allKCallPersons.elements();
  }

  public void doGet (HttpServletRequest req, 
		     HttpServletResponse res)
       throws ServletException, IOException
  {
    HttpSession session = req.getSession(false);
    if (null == session) {
	HCError.call(res,
			"Use cclogin.html to login!" +
			"<br /> <a href='" + D.ccloginHtml + "'>click here.</a>");
	return;
    }
    call(res, session);
  }

    static public void call(HttpServletResponse res, HttpSession session) 
	throws IOException {

    String sessionId = session.getId();
    res.setContentType("text/html");
    ServletOutputStream out = res.getOutputStream();
    String state;
    //    if ( session.isNew() || !allKCallPersons.containsKey(sessionId) ) {
    if ( !allKCallPersons.containsKey(sessionId) ) {
      // init this session
      putKCallPerson(sessionId, session);
      state = "available";
      session.putValue("kstate", state);
      Vector chatRecords = new Vector();
      // preparation to store a chatRecord - if any - in logSessions
      Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");
      unboundHashtable.put("chatRecords", chatRecords);
      session.putValue("chatRecords", chatRecords);
      session.putValue("visitors", "none");    
    } else {
      String clientId = (String) session.getValue("invitedClient");
      state = (String) session.getValue("kstate");
      String clientState = null;
      HttpSession clientSession = null;
      if ( state.equals("inviting") ) {
	try { // client can disapppear at all times
	  clientSession = KClient.getKClient(clientId);
	  clientState = (String) clientSession.getValue("state");
	} catch (Exception ex) { 
	  state = "available";
	  session.putValue("kstate", state);
	}
      }
      if ( state.equals("inviting") ) {
	if ( clientState.equals("invitationRejected") || 
	     clientState.equals("timeout") ||
	     clientState.equals("**ErrorResponse") ||
	     clientState.equals("transferred") // only in tomcat
	     ) {
	  state = "available";
	  session.putValue("kstate", state);
	} else 
        if ( clientState.equals("chatting") ) {
	    state = "chatting";
	    session.putValue("kstate", state);
	    try {
	      // record the cc-person identity in the client's persistent record
	      Hashtable unboundHashtable = 
		(Hashtable) clientSession.getValue("unboundHashtable");
	      String kCallPerson = (String) session.getValue("ccName");
	      unboundHashtable.put("ccPerson", kCallPerson);
	      // store a ref to the client's chatRecord into the own permanent record
	      Vector chatRecord = (Vector) clientSession.getValue("chatRecord");
	      Vector chatRecords = (Vector) session.getValue("chatRecords");
	      chatRecords.addElement(chatRecord);
	      // create the chat window for the CC person
	      out.println(
			  "<html><BODY BGCOLOR=lightblue> \n" +
			  "<SCRIPT LANGUAGE='JavaScript'> \n" +
			  "win2 = open('" + D.kCPersonChatHtml + "'," +
			  "'kCPersonChat'," +
			  "'resizable=1,scrollbars=1,height=500,width=750'" +
			  "); \n" +
			  "location='" + D.servletKCallPerson + "';" +
			  "</SCRIPT> \n" +
			  "</BODY></html>");
	      return;
	    } catch (Exception ex) {
	      state = "available";
	      session.putValue("kstate", state);
	    }
	  } else {
	    long now = (new Date()).getTime();
	    Long invitationTimeout = 
	      (Long) session.getValue("invitationTimeout");
	    if ( invitationTimeout.longValue() < now ) { 
	      state = "available";
	      session.putValue("kstate", state);
	      // notify the client
	      try {
		clientSession.putValue("state", "**CPersonTerminate**");
	      } catch (Exception ignore ) { }
	    }
	  }
      } else if ( state.equals("chatting") ) {
	try { // client can disapppear at all times
	  clientSession = KClient.getKClient(clientId);
	  clientState = (String) clientSession.getValue("state");
	  if ( clientState.equals("**ClientTerminate**") ||
	       clientState.equals("**CPersonTerminate**") ) {
	    state = "available";
	    session.putValue("kstate", state);
	    // the stuff below is moved to the beginning of the chat session
	    // Vector chatRecord = (Vector) clientSession.getValue("chatRecord");
	    // Vector chatRecords = (Vector) session.getValue("chatRecords");
	    // chatRecords.addElement(chatRecord);
	  }
	} catch (Exception ex) {
	  state = "available";
	  session.putValue("kstate", state);
	}
      }
    }
    
    String visitors = (String) session.getValue("visitors");
    Vector theClientDigest = KClient.getTheClientDigest();
    int lng = theClientDigest.size();
    if ( lng <= 0 ) 
	session.putValue("visitors", "none");
    else if ( visitors.equals("none") ) {
	session.putValue("visitors", "yes");
	res.sendRedirect(D.VisitorsHtml); // sound notification
	return;
    }

    res.setHeader("Refresh", refreshInterval);
    out.println("<html><head><title>CallPerson</title>" +
		D.linkBlueStyle + " \n" +
		D.favicon + "</head>");
    out.println("<body bgcolor=\"lightblue\">");
    out.println(DVM.htmlLogoutCC("State: " + state + 
				 " / Digest #: " + KClientDigest.getCnt()));
    out.println("<center><table border=\"1\">");
    // table header here
      out.println(
	  "<tr><td>ClientId" +
	  "</td><td>Client State" +
	  "</td><td>Action" +
	  "</td><td>Page" +
	  "</td><td>PageCnt" +
	  "</td><td>SurfCnt" +
	  "</td><td>Diag Rate" +
	  "</td></tr>");

    Vector clientVector;
    String clientId, kupdates, client, page, foundLifeThreateningDisease, diagnosis, accessMode;
    Integer pageCnt;
    Integer surfCnt;
    String sendCCAdvice;
    for (int i=0; i<lng; i++) {
      clientVector = (Vector) theClientDigest.elementAt(i);
      clientId = (String)clientVector.elementAt(0);
      accessMode = "unknown";
      sendCCAdvice = null;
      try { 
	  HttpSession clientSession = KClient.getKClient(clientId);
	  accessMode = (String) clientSession.getValue("accessMode");
	  sendCCAdvice = (String) clientSession.getValue("sendCCAdvice");
      } catch (Exception ignore) {}
      state = (String)clientVector.elementAt(1);
      // kupdates = (String)clientVector.elementAt(2);
      client = (String)clientVector.elementAt(2);
      page = (String)clientVector.elementAt(3);
      pageCnt = (Integer)clientVector.elementAt(4);
      surfCnt = (Integer)clientVector.elementAt(5);
      foundLifeThreateningDisease = (String)clientVector.elementAt(6);
      diagnosis = (String)clientVector.elementAt(7);
      // = notFound | float number
      float acceptanceRate = 0.0f;
      try { acceptanceRate = Float.parseFloat(foundLifeThreateningDisease);
      } catch (Exception ignore) {}
      boolean warn = ( 0.3f <= acceptanceRate ) || ( null != sendCCAdvice );
	  
      // following code fails ...
      // if ( warn ) out.println("<SCRIPT>location='spacemusic.au'</SCRIPT>");
      out.println(
	  "<tr><td><a href=\"" + D.servletKDetails + "?clientId=" +
	              clientId + "\">" + client + "</a>" +
	  "</td><td>" + ( warn ? 
			  "<font color=\"#FF0000\" size=\"5\">" + state + "</font>" :
			  state ) +
	  "</td><td>" + ( !state.equals("initial") ?
			  "No Action"
			  :
			  ( accessMode.equals("browser") ?
			    "<a href=\"" + D.servletKInvite + "?client=" +
			    clientId + "\">invite</a>" :
			    ( accessMode.equals("phone") ?
			      "<a href=\"" + D.servletKTransfer + "?client=" +
			      clientId + "\">transfer call</a>" :
			      "No Action" ) ) ) +
	  "</td><td>" + page +
	  "</td><td>" + pageCnt.intValue() +
	  "</td><td>" + surfCnt.intValue() +
	  "</td><td>" + ( diagnosis.startsWith("ambiguity") ?
			  "<font color=\"#FF0000\" size=\"5\">" + diagnosis + "</font>" :
			  diagnosis ) +
	  "</td></tr>");

    }
    out.println("</table></center>");
    out.println("</body></html>");
  }
}




