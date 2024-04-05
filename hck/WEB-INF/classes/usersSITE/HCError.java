// (C) OntoOO Inc 2003 August
package users;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.DV;
import com.D;


public class HCError extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String msg = req.getParameter("msg");
	String loggedin = req.getParameter("loggedin");

	call(res, msg, loggedin);
    }

    public static void call(HttpServletResponse res, String msg)
	throws IOException { 
	call(res, msg, null); 
    }
    public static void call(HttpServletResponse res, String msg, String loggedin) 
	throws IOException {
	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<HTML>");
	out.println("<HEAD><TITLE>HealthCheck Error</TITLE></HEAD>");
	out.println("<BODY  BGCOLOR=pink>");
	  
	out.println("<H1 align=center><FONT Color='#FF0000' SIZE=4>" +
		    "HealthCheck Error</FONT></H1>");
	out.println(msg);
	out.println(
"<SCRIPT LANGUAGE='JavaScript'>\n" +
"function openSendMail(arg) { \n" +
"    win1 = open(arg, 'SendMail', 'resizable=1,scrollbars=1,height=600,width=700'); \n" +
"    win1.focus();" +
"} \n" +
"</SCRIPT>");

	out.println("<hr>" +
		    "<A href='#1' name='1' onClick='openSendMail(\"" +
                    D.SendMailHtml + "\")'>" +
		    "For if you want to provide feedback.</a> Thanks!<hr>");

	out.println(DV.htmlBack);

	// already logged in?
	if ( null != loggedin ) 
	    out.println(DV.SCRIPTCC);

	out.println("</BODY></HTML>");
    }
}

