// (C) OntoOO Inc 2002
package users;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// This class is just a template ...
public class DrawGraphServ extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	res.setContentType("text/html");
	
	ServletOutputStream out = res.getOutputStream();
	out.println("<HTML>");
	out.println("<HEAD><TITLE>Draw Graph</TITLE></HEAD>");
	out.println("<BODY>");
	out.println("<APPLET CODE='/hck/applets.DrawGraphAppl' WIDTH= 700 HEIGHT= 300> ");
	//	out.println("CODEBASE=/C:/JavaWebServer2.0/classes > ");
	out.println("<PARAM NAME= numberOfPairs VALUE= 5>");
	out.println("<PARAM NAME= minX VALUE= -2>");
	out.println("<PARAM NAME= maxX VALUE= 2>");
	out.println("<PARAM NAME= minY VALUE= -2>");
	out.println("<PARAM NAME= maxY VALUE= 2>");
	String seq = "\"-2 -2 -1 -1 0 0 1 1 2 2\"";
	out.println("<PARAM NAME= sequence VALUE=" + seq +">");
	out.println("<PARAM NAME= xText VALUE=days>");
	out.println("<PARAM NAME= yText VALUE=weight>");
	out.println("<PARAM NAME= leftBottomSt VALUE='4 days ago'>");
	out.println("<PARAM NAME= rightBottomSt VALUE=today>");
	
	out.println("</APPLET>");
	out.println("</BODY>");
	out.println("</HTML>");
    }
}



