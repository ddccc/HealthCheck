// (C) OntoOO Inc 2003 Feb
package su;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.DV;
import com.DVM;
import com.D;
import misc.DB;
import patient.AngelLogin;
import misc.HCError;

public class SUShowLoggedinUsers extends HttpServlet {

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
      boolean phAccess = ( null != phName);

      Hashtable loggedInUsers = AngelLogin.getLoggedInUsers();
      Enumeration enumz = loggedInUsers.keys();
      Vector allAccounts = new Vector();
      while ( enumz.hasMoreElements() ) allAccounts.addElement(enumz.nextElement());

      Collections.sort(allAccounts);
      int lng = allAccounts.size();

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();

      out.println("<html>");
      out.println("<head><title>Show Logged in Users</title></head>");
      out.println("<body bgcolor=\"bbbbbb\">");
      if ( phAccess )
	  out.println(DVM.htmlLogoutPH("Show Logged in Users  # " + lng));
      else
	  out.println(DVM.htmlLogoutSU("Show Logged in Users  # " + lng));

      out.println("<table border=\"1\">");
      String account;
      String password;
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
	if ( null == props ) {
	    out.println(
			"<tr><td>" + account + " </td><td> " +
			"<a href=\"" + D.servletShowUserAccount + 
			"?account=" + account + "\"> Show </a></td><td> " +
			"<a href=\"" + D.servletSUKillSession + "?logName=" + account +
			"&password=" + account + "\"> Kill </a></td><td> " +
			"*** No props</td><td> " +
			"*** No props</td><td> " +
			"*** No props</td></tr>");
	    continue; // screwed up/ hence ignore
	}



	password = props.getProperty("password");
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
	   "<a href=\"" + D.servletShowUserAccount + 
	         "?account=" + account + "\"> Show </a></td><td> " +
	   "<a href=\"" + D.servletSUKillSession + "?logName=" + account +
	         "&password=" + password + "\"> Kill </a></td><td> " +
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

