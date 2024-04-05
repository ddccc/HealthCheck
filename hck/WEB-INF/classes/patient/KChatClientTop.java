// (C) OntoOO Inc 2002
package patient;

import com.DV;
import com.L;
import misc.SessionExpired;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URLEncoder;


public class KChatClientTop extends HttpServlet {

  public void doGet (HttpServletRequest req, 
		     HttpServletResponse res)
       throws ServletException, IOException
  {
    HttpSession session = req.getSession(false);
    if ( null == session ) {
	    SessionExpired.call(res,
				DV.KChatClientTop);
	    return;
    }
    String kCallPersonName = (String) session.getValue("kCallPersonName");
    String kCPLogName = (String) session.getValue("kCallPersonLogName");
    Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");
    Date now = new Date(); // to create an anchor value ...
    long anchor = now.getTime();
    unboundHashtable.put("ccPerson", 
       kCallPersonName + 
       " <a href=\"#" + anchor + 
       "\" name=\"" + anchor + 
       "\" onClick=\"showAccount('cc','" +
			               kCPLogName + "')\">" + kCPLogName + "</a>");
    res.setContentType("text/html");
    ServletOutputStream out = res.getOutputStream();
    out.println("<html><body bgcolor=\"turquoise\">");
    out.println("<font size=\"5\"><b>" + 
		kCallPersonName + " " +
		// "is assisting you" + 
		L.KChatClientTopS1 +
		"</b></font>");
    out.println("</body></html>");
  }
}



