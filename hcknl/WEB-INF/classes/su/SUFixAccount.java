// (C) OntoOO Inc 2003 Aug
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

public class SUFixAccount extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {

      HttpSession session = req.getSession(false);
      if ( null == session ) {
	  HCError.call(res, "Session expired/ relogin ...");
	  return;
      }

      Vector allAccounts =  SUtil.getUUaccounts();

      Collections.sort(allAccounts);
      int lng = allAccounts.size();

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();

      out.println("<html>");
      out.println("<head><TITLE>Show an Account</TITLE></head>");
      out.println("<body bgcolor=\"bbbbbb\">");
      out.println(DVM.htmlLogoutSU(
				 "Show User Account # " + lng));
      out.println("<table border=\"1\">");
      String account;
      String fileName;
      String prefix2 = D.theUsersDir;
      DB props;
      for (int i = 0; i < lng; i++) {
	account = (String) allAccounts.elementAt(i);
	out.println(
	   "<tr><td>" + account + " </td><td> " +
	   "<A HREF='" + D.servletShowUserAccount + 
	         "?account=" + account + "'> Show </A></td></tr>");

	fileName = account;
	props = null;
	try {
	    props = new DB(prefix2 + fileName);
	} catch (IOException ignore) {}
	if ( null == props ) {
	    out.println(
			"<tr><td>" + account + " </td><td> " +
			"******** null == props </td></tr>");
	    continue;
	}
	props.put("fileName", fileName); 	
	try { 
	    FileOutputStream fos = 
		new FileOutputStream(prefix2 + fileName);
	    props.store(fos, "SUFixAccount");
	    fos.close();
	}
	catch (IOException ex) {
	    out.println(
			"<tr><td>" + account + " </td><td> " +
			"******** props store failure </td></tr>");
	    continue;
	} 
      }
      out.println("</table>");

      out.println(DV.htmlBack);
      out.println("</body>");
      out.println("</html>");
  }
}




