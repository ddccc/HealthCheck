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
import concepts.Drug;


public class ShowDrugs extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allDrugs = Common.allDrugs();
      int lng = allDrugs.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>" + L.AllDrugs + "</title>" +
		  D.favicon + "</head>");
      out.println("<body bgcolor=\"yellow\">");
      out.println("<h1>" + L.AllDrugs + " # = " + lng + "</h1>");
      String dis, printName;
      Drug drug;
      for (int i = 0; i < allDrugs.length; i++) {
	dis = allDrugs[i];
	drug = Common.getDrug(dis);
	printName = drug.getDescription();
	out.println(
	     "<br />" +
	     "<a href=\"" + D.servletShowDrug + "?drug=" + dis + "\">" +
	     printName + "</a>");
      }

      out.println(DV.htmlBack);

      out.println("</body>");
      out.println("</html>");
    }
}





