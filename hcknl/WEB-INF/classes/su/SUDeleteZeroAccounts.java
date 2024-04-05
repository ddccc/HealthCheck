// (C) OntoOO Inc 2004 Jan
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

public class SUDeleteZeroAccounts extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {

      HttpSession session = req.getSession(false);
      if ( null == session ) {
	  HCError.call(res, "Session expired/ relogin ...");
	  return;
      }

      Vector allAccounts = SUtil.getUUaccounts();
      Collections.sort(allAccounts);
      int lng = allAccounts.size();

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();

      out.println("<html>");
      out.println("<head><title>Delete Zero Accounts</title></head>");
      out.println("<body bgcolor=\"bbbbbb\">");
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
      int cnt = 0;
      Vector keptAccounts = new Vector();
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
	if ( 0 < lng2  ) {
	    keptAccounts.addElement(account);
	    continue;
	}
	cnt++;
	out.println(
	   "<tr><td>Deleting: " + account + " </td><td> " +
	   accountCreationDate + "</td></tr>");
      }
      out.println("</table>");
      out.println("Total # deleted accounts: " + cnt);
      out.println("Total # kept accounts: " + keptAccounts.size());

      if ( 0 < cnt ) {
	  boolean out2 = SUtil.SetUUaccounts(keptAccounts);
	  out.println("Writing of the keptAccounts: " + ( out2 ? "SUCCEEDED" : " **** FAILED **** "));
      }

      out.println(DV.htmlBack);
      out.println("</body>");
      out.println("</html>");
  }
}



