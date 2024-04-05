// (C) OntoOO Inc 2002 May
package su;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import misc.DB;
import com.DV;
import com.D;
import com.DVM;
import misc.HCError;

public class SUShowAnAccount extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String type = req.getParameter("type"); // user | cc | ph

      HttpSession session = req.getSession(false);
      if ( null == session ) {
	  HCError.call(res, "Session expired/ relogin ...");
	  return;
      }

      String phName = (String) session.getValue("phName");
      boolean phAccess = ( null != phName );

      Vector allAccounts = 
	  ( phAccess ? SUtil.getPHaccounts(
               (String) session.getValue("logName"))  : 
	    ( type.equals("user") ?
	      SUtil.getUUaccounts() :
	      ( type.equals("cc") ?
		SUtil.getCCaccounts() : 
		( type.equals("ph") ?
		  SUtil.getPHaccounts() : 
		  new Vector() ) ) ) );
      Collections.sort(allAccounts);
      int lng = allAccounts.size();

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();

      out.println("<html>");
      out.println("<head><title>Show an Account</title></head>");
      out.println("<body bgcolor=\"bbbbbb\">");
      if ( phAccess )
	  out.println(DVM.htmlLogoutPH(
	      "Show " +
	      ( type.equals("user") ? "User" : 
		( type.equals("cc") ? "CC" : 
		  ( type.equals("ph") ? "PH" : 
		    "???" ))) + 
	      " Account # " + lng));
      else
	  out.println(DVM.htmlLogoutSU(
	      "Show " +
	      ( type.equals("user") ? "User" : 
		( type.equals("cc") ? "CC" : 
		  ( type.equals("ph") ? "PH" : 
		    "???" ))) + 
	      " Account # " + lng));
      out.println("<table border=\"1\">");
      String account;
      for (int i = 0; i < lng; i++) {
	account = (String) allAccounts.elementAt(i);
	out.println(
	   "<tr><td>" + account + " </td><td> " +
	   // "<a href=\"" + D.servletShowAccount + "?type=" + type + 
	   //      "&account=" + account + "\"> Show </a></td></tr>");
	   ( type.equals("user") ?
	     "<a href=\"" + D.servletShowUserAccount + "?account=" + account + "\"> Show </a>" :
	     "<a href=\"" + D.servletShowAccount + "?type=" + type + 
	     "&account=" + account + "\"> Show </a>" ) +
	   "</td></tr>");
	   
      }
      out.println("</table>");

      out.println(DV.htmlBack);
      out.println("</body>");
      out.println("</html>");
  }
}




