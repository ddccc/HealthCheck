// Copyright OntoOO Inc, 2002 May
package su;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.DVM;
import com.D;
import com.Common;

public class SURoot extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	call(res);
    }

    static public void call(HttpServletResponse res) throws IOException {
	Vector logger = Common.getLogger();
	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>SURoot</title>" +
		    D.linkGreyStyle + " \n" +
		    D.favicon + "</head>");
	out.println("<body bgcolor=\"bbbbbb\">");
	out.println(DVM.htmlLogoutSU("SURoot"));
	StringBuffer sb = new StringBuffer();
sb.append("<br /><a href=\"" + D.servletSUCreateAccount + "?type=user\">Create User Account</a>\n ");
sb.append(" | <a href=\"" + D.servletSUDeleteAnAccount + "?type=user\">Delete User Account</a>\n ");
sb.append(" | <a href=\"" + D.servletSUShowAnAccount + "?type=user\">Show User Accounts</a>\n ");
sb.append(" | <a href=\"" + D.servletSUShowUserAccounts + "\">Show Detail User Accounts</a>\n ");
sb.append(" | <a href=\"" + D.servletSUShowChronoAccounts + "\">Show Chrono Ordered User Accounts</a>\n ");
sb.append("<hr />\n ");
sb.append("<br /><a href=\"" + D.servletSUCreateAccount + "?type=cc\">Create CC Account</a>\n ");
sb.append(" | <a href=\"" + D.servletSUDeleteAnAccount + "?type=cc\">Delete CC Account</a>\n ");
sb.append(" | <a href=\"" + D.servletSUShowAnAccount + "?type=cc\">Show CC Account</a>\n ");
sb.append("<hr />\n ");
sb.append("<br /><a href=\"" + D.servletSUCreateAccount + "?type=ph\">Create Physician Account</a>\n ");
sb.append(" | <a href=\"" + D.servletSUDeleteAnAccount + "?type=ph\">Delete Physician Account</a>\n ");
sb.append(" | <a href=\"" + D.servletSUShowAnAccount + "?type=ph\">Show Physician Account</a>\n ");
sb.append("<hr />\n ");
sb.append("<br /><a href=\"" + D.servletSUShowHALogging + "\">Show HALogging</a>\n ");
sb.append("<hr />\n ");
sb.append("<br /><a href=\"" + D.servletSUShowLoggedinUsers + "\">Show Logged in Users</a>\n ");
sb.append("<hr />\n ");
sb.append("<br /><a href=\"" + D.servletSUShowZeroAccounts + "\">Show Detail Zero Accounts</a>\n ");
sb.append(" | <a href=\"" + D.servletSUDeleteZeroAccounts + "\">Delete Zero Accounts</a>\n ");
sb.append("<hr />\n ");
sb.append("<br /><b>Logger size:</b> " + logger.size() + "\n ");
sb.append("<br /><a href=\"" + D.servletSUShowLogger + "\">Show Logger</a>\n ");
sb.append(" | <a href=\"" + D.servletSUClearLog + "\">Clear the log</a>\n ");

out.println(sb.toString());


	out.println("</body>");
	out.println("</html>");
    }

}







