// Copyright OntoOO Inc, 2002 May
package su;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.DV;
import com.DVM;
import com.D;
import misc.DB;

public class SUShowHALogging extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      int loginCnt = 0;
      int createCnt = 0;
      int quickCnt = 0;
      DB HALogging = null;

      String loggingFileName = D.healthAngelLogging;
      try {
	HALogging = new DB(loggingFileName);
	String loginCntStr = HALogging.getProperty("loginCnt", "0");
	loginCnt = Integer.parseInt(loginCntStr);
	String createCntStr = HALogging.getProperty("createCnt", "0");
	createCnt = Integer.parseInt(createCntStr);
	String quickCntStr = HALogging.getProperty("quickCnt", "0");
	quickCnt = Integer.parseInt(quickCntStr);
      } catch (Exception ex) {}
      Vector allAccounts = SUtil.getUUaccounts();
      int lng = allAccounts.size();

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>SUShowHALogging</title></head>");
      out.println("<body bgcolor=\"bbbbbb\">");
      out.println(DVM.htmlLogoutSU("SUShowHALogging"));
      out.println("<table border=\"1\">");
      out.println("<tr><td><b># accounts:</b></td><td> " + lng + "</td></tr>");
      out.println("<tr><td><b>loginCnt:</b></td><td> " + loginCnt + "</td></tr>");
      out.println("<tr><td><b>createCnt:</b></td><td> " + createCnt + "</td></tr>");
      out.println("<tr><td><b>quickCnt:</b></td><td> " + quickCnt + "</td></tr>");
      out.println("</table>");

      out.println(DV.htmlBack);
      out.println("</body>");
      out.println("</html>");
    }
}


