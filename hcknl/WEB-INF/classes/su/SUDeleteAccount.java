// (C) OntoOO Inc 2002 May
package su;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.DV;
import com.D;
import misc.DB;
import misc.HCError;
import patient.AngelLogin;

public class SUDeleteAccount extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {

      String type = req.getParameter("type");
      String account = req.getParameter("account");

      HttpSession session = req.getSession(false);
      if ( null == session ) {
	  HCError.call(res, "Session expired/ relogin ...");
	  return;
      }
      
      String phLogName = null;
      if ( type.equals("user") ) {
	  String prefix2 = D.theUsersDir;
	  DB props = null;
	  try {
	      props = new DB(prefix2 + account);
	      phLogName = props.getProperty("myPhysician");
	  } catch (IOException ignore) {}
      } else
      if ( type.equals("ph") ) {
	  Vector vec = SUtil.getPHaccounts(account);
	  if ( 0 < vec.size() ) {
	      res.setContentType("text/html");
	      ServletOutputStream out = res.getOutputStream();
	      out.println("<html>");
	      out.println("<head><title>Account NOT Deleted</title></head>");
	      out.println("<body bgcolor=\"pink\">");
	      out.println("<h1> PH account was NOT deleted !</h1>" +
			  "<h3> There are still patient accounts, which must be deleted first.</h3>");
	      out.println(DV.htmlBack);
	      out.println("</body>");
	      out.println("</html>");
	      return;
	  }
      }

      String prefix2 = D.theUsersDir;
      File aFile = new File(prefix2 + 
			    ( type.equals("cc") ? "cc" : 
			      ( type.equals("ph") ? "ph" : "" )) +
			    account);
      aFile.delete();
      aFile = new File(prefix2 + 
			    ( type.equals("cc") ? "cc" : 
			      ( type.equals("ph") ? "ph" : "" )) +
			    account + "logSessions");
      aFile.delete();

      boolean outb = 
	( type.equals("user") ? 
	  SUtil.deleteUUaccount(account) :
	  ( type.equals("cc") ? 
	    SUtil.deleteCCaccount(account) :
	    ( type.equals("ph") ? 
	      SUtil.deletePHaccount(account) :
	      false ) ) );
      if ( outb && null != phLogName ) outb = SUtil.deletePHaccount(phLogName, account);

      if ( type.equals("user") ) AngelLogin.logoutUser(account);

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>Account Deleted</title>" +
		  D.favicon + "</head>");
      out.println("<body bgcolor=\"bbbbbb\">");
      out.println("<h1>" + 
		  ( type.equals("user") ? "User" : 
		    ( type.equals("cc") ? "CC" : 
		      ( type.equals("ph") ? "PH" : "???"))) + 
		  " account " + account + " was " + 
		  ( outb ? "" :
		    "<font color=\"#FF0000\" size=\"4\"> NOT </font>" ) + 
		  "deleted!!</h1>");
      out.println(DV.htmlBack);

      out.println("</body>");
      out.println("</html>");
    }
} // end SUDeleteAccount




