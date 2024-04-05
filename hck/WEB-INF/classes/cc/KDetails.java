// (C) OntoOO Inc 2002
package cc;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.D;

public class KDetails extends HttpServlet {

  public void doGet (HttpServletRequest req, 
		     HttpServletResponse res)
       throws ServletException, IOException
  {
    String clientId = req.getParameter("clientId");
    res.setContentType("text/html");
    ServletOutputStream out = res.getOutputStream();
    Date now = new Date();
    out.println(
       "<html><body bgcolor=\"yellow\">" +
       "<script language=\"JavaScript\">");
    out.println(
       "open(" +
       "    \"" + D.servletKDetails2 + 
               "?clientId=" + clientId +
               "&delete=yes" +
               "&random=" + now.getTime() +  "\"," +
            " \"KDetails2\"," +
            " \"resizable=1,scrollbars=1,height=500,width=700\");" +
       "location.href='" + D.servletKCallPerson + "';" );
    out.println(
       "</script></body></html>");
  }
}



