// (C) OntoOO Inc 2003 Aug
package su;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import misc.DB;
import com.DV;
import com.DVM;
import com.D;
import misc.HCError;


public class SUShowChronoAccounts extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {

      HttpSession session = req.getSession(false);
      if ( null == session ) {
	  HCError.call(res, "Session expired/ relogin ...");
	  return;
      }

      String phName = (String) session.getValue("phName");
      boolean phAccess = ( null != phName );

      Vector allAccounts = 
	  ( phAccess ?
	    SUtil.getPHaccounts( (String) session.getValue("logName"))  : 
	    SUtil.getUUaccounts() );
      int lng = allAccounts.size();
      Vector allAccounts2 = new Vector();
      String account;
      DB props;
      String prefix2 = D.theUsersDir;
      for (int i=0; i<lng; i++) {
	account = (String) allAccounts.elementAt(i);
	props = null;
	try {
	    props = new DB(prefix2 + account);
	} catch (IOException ignore) {}
	if ( null == props ) continue; // screwed up/ hence ignore
	allAccounts2.addElement(props);
      }
      Collections.sort(allAccounts2);

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();

      out.println("<html>");
      out.println("<head><title>Show Accounts</title></head>");
      out.println("<body bgcolor=\"bbbbbb\">");
      if ( phAccess )
	  out.println(DVM.htmlLogoutPH("Show User Accounts # " + lng));
      else
	  out.println(DVM.htmlLogoutSU("Show User Accounts # " + lng));
      
      out.println("<table border=\"1\">");
      String fileName;
      String accountCreationDate;
      Vector logSessions;
      int lng2;
      String lastVisit;
      Hashtable ht;
      lng = allAccounts2.size();
      for (int i = 0; i < lng; i++) {
	props = (DB) allAccounts2.elementAt(i);
	fileName = props.getProperty("fileName");
	accountCreationDate = props.getProperty("accountCreationDate");
	    long x = 0;
	    try { x = Long.parseLong(accountCreationDate); }
	    catch (NumberFormatException ignore) {}
	    Date aDate = new Date(x);
	    accountCreationDate = aDate.toString();
	logSessions = Common.getLogSessions(fileName);
	lng2 = logSessions.size(); 
	if ( lng2 <= 1 ) 
	    lastVisit = "none yet";
	else {
	    ht = (Hashtable) logSessions.elementAt(lng2 - 1);
	    lastVisit = ( ht.get("end") ).toString();
	}

	out.println(
	   "<tr><td>" + fileName + " </td><td> " +
	   "<a href=\"" + D.servletShowUserAccount + "?account=" + fileName + 
	   "\"> Show </a></td><td> " +
	   accountCreationDate + "</td><td> " +
	   lng2 + "</td><td> " +
	   lastVisit + "</td></tr>");
      }
      out.println("</table>");

      out.println(DV.htmlBack);
      out.println("</body>");
      out.println("</html>");
  }
}



