// (C) OntoOO Inc 2003 Jan
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

public class SUShowUserAccounts extends HttpServlet {

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
	    SUtil.getPHaccounts(
		 (String) session.getValue("logName"))  : 
	    SUtil.getUUaccounts() );
      Collections.sort(allAccounts);
      int lng = allAccounts.size();

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
      String account;
      String fileName;
      String prefix2 = D.theUsersDir;
      DB props;
      String accountCreationDate;
      Vector logSessions;
      int lng2;
      String lastVisit;
      Hashtable ht;
      for (int i = 0; i < lng; i++) {
	account = (String) allAccounts.elementAt(i);
	fileName = account;
	props = null;
	try {
	    props = new DB(prefix2 + fileName);
	} catch (IOException ignore) {}
	if ( null == props ) continue; // screwed up/ hence ignore
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
	   "<tr><td>" + account + " </td><td> " +
	   "<a href=\"" + D.servletShowUserAccount + "?account=" + account + 
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



