// Copyright OntoOO Inc, 2000
package show;

import com.Common;
import com.DV;
import com.D;
import com.L;
import concepts.Disease;
import concepts.XWord;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowDiseases extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	// String [] allDiseases = Common.allDiseases();
      String [] allDiseases = Common.allDiseasesForShow();
      int lng = allDiseases.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>" + L.AllDiseases + "</title></head>");
      out.println("<body bgcolor=\"yellow\">");
      out.println("<h1>" + L.AllDiseases + " # = " + lng + "</h1>");
      String dis, printName;
      Disease disease;
      for (int i = 0; i < lng; i++) {
	dis = allDiseases[i];
	disease = Common.getDisease(dis);
	if ( null != disease ) 
	    printName = disease.getPrintName();
	else {
	    XWord xw = Common.getXWord(dis);
	    if ( null == xw ) continue;
	    String dis2 = xw.getSynonym();
	    disease = Common.getDisease(dis2);
	    if ( null == disease ) continue;
		printName = xw.getPrintName() + " => " + disease.getPrintName();
	}
	out.println(
	     "<br />" +
	     "<a href=\"" + D.servletShowDisease + "?dis=" + dis + "\">" +
	     printName + "</a>");
      }

      out.println(DV.htmlBack);

      out.println("</body>");
      out.println("</html>");
    }
}



