// Copyright OntoOO Inc, 2002
package show;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.DV;
import concepts.XWord;

public class ShowXWord extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String sym = req.getParameter("xw");
      XWord xWord = Common.getXWord(sym);
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>A XWord</title></head>");
      out.println("<body bgcolor=\"yellow\">");
      out.println("<h3>The XWord: " + sym + "</h3>");
      out.println(xWord.html());
      out.println(DV.htmlDismissOrBack);

      out.println("</body>");
      out.println("</html>");
    }
}



