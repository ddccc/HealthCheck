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
import concepts.AbnormalCondition;


public class ShowAbnormalConditions extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allAbnormalConditions = Common.allAbnormalConditions();
      int lng = allAbnormalConditions.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><TITLE>" + L.AllAbnormalConditions + "</TITLE></head>");
      out.println("<body bgcolor=\"yellow\">");
      out.println("<h1>" + L.AllAbnormalConditions + ", # = " + lng + "</h1>");
      String dis, printName;
      AbnormalCondition abnormalCondition;
      for (int i = 0; i < allAbnormalConditions.length; i++) {
	dis = allAbnormalConditions[i];
	abnormalCondition = Common.getAbnormalCondition(dis);
	printName = abnormalCondition.getPrintName();
	out.println(
	     "<br />" +
	     "<a href=\"" + D.servletShowAbnormalCondition + "?ac=" + dis + "\">" +
	     printName + "</a>");
      }
      out.println(DV.htmlBack);

      out.println("</body>");
      out.println("</html>");
    }
}





