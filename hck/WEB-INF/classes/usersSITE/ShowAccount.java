// Copyright OntoOO Inc, 2002 May
package users;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.DV;
import com.D;
import com.Common;
import misc.DB;
import patient.History;
import users.HCError;

public class ShowAccount extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String type = req.getParameter("type"); // user | cc | ph
      String account = req.getParameter("account");
      String fileName = 
	  ( type.equals("cc") ? "cc" : 
	    ( type.equals("ph") ? "ph" : "" ) ) +
	  account;
            String prefix2 = D.theUsersDir;
      DB props = null;
      try {
	props = new DB(prefix2 + fileName);
      } catch (IOException ignore) {}
      if ( null == props ) {
	  HCError.call(res, 
		      "Account not found ...<br>" +
		      "Use the back arrow to return to the previous page.");
	  return;
      }

      Enumeration enum = props.propertyNames();

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>An Account</TITLE></HEAD>");
      out.println(DV.scriptShowAccount);
      out.println("<BODY BGCOLOR='bbbbbb'>");
      out.println("<H3>The " + 
		  ( type.equals("user") ? "User" : 
		    ( type.equals("cc") ? "CC" : "PH" )) +
		  " Account: " + account + "</H3>");
      String key;
      String value;
      while ( enum.hasMoreElements() ) {
	key = (String) enum.nextElement();
	value = props.getProperty(key);
	if ( key.equals("accountCreationDate") ) {
	    long x = 0;
	    try { x = Long.parseLong(value); }
	    catch (NumberFormatException ignore) {}
	    Date aDate = new Date(x);
	    out.println("<br><b>" + key + ":</b> " + aDate.toString());
	} else
	if ( key.equals("monthNum") ) {
	    int x = 0;
	    try { x = Integer.parseInt(value); }
	    catch (NumberFormatException ignore) {}
	    out.println("<br><b>" + key + ":</b> " + (1 + x));
	} else
	    out.println("<br><b>" + key + ":</b> " + value);
      }

      // This is stolen from KDetails2 ...
      StringBuffer sb = null;
try { 
      // test whether there is a logSession
      String histVecName = fileName;
      Vector logSessions = Common.getLogSessions(histVecName);
      int lng = logSessions.size(); 
      if ( lng <= 0 ) {
	out.println(DV.htmlDismissOrBack);
	out.println("</BODY>");
	out.println("</HTML>");
	return;
      }

      // stuff from logSessions

      // in case we must deal with DiseaseInstHist:
      History.scriptDiseaseInstHist(out, histVecName);

      sb = new StringBuffer("<p><table border>");
      History.processLogSessions(sb, logSessions, false);
      
      sb.append("</table>");
      out.println(sb.toString());
      
    } catch (Exception ex) {
      if ( null != sb ) {
	sb.append("</table></center>");
	out.println(sb.toString());
      }
      out.println("<H3><i><b>Something weird happened ... </b></i></H3>");
      out.println("Exception: " + ex.toString());
      out.println("<pre>");
      PrintStream ps = new PrintStream(out);
      ex.printStackTrace(ps);
      out.println("</pre>");
    }

    out.println(DV.htmlBack);
    
    out.println("</BODY>");
    out.println("</HTML>");
    }
}




