// Copyright OntoOO Inc, 2000
package show;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.DV;
import com.D;
import com.L;
import concepts.XWord;


public class EditXWords extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allXWords = Common.allXWords();
      int lng = allXWords.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>" + L.AllXWords + "</title></head>");
      out.println("<body bgcolor=\"lightgreen\">");
      out.println("<h1>" + L.SelectXWord + " # = " + lng + "</h1>");
      String dis, type;
      XWord xWord;
      out.println("<table border=\"1\">");
      for (int i = 0; i < allXWords.length; i++) {
	dis = allXWords[i];
	xWord = Common.getXWord(dis);
	type = xWord.getType();
	out.println(
	     "<tr><td>" + dis + " </td><td> " +
	     "<a href=\"" + D.servletShowXWord + "?xw=" + dis + "\"> show </a></td>" +
	     "<td>" + type + "</td></tr>");
      }
      out.println("</table>");
      out.println(DV.htmlBack);

      out.println("</body>");
      out.println("</html>");


    }
}





