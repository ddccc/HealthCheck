// Copyright OntoOO Inc, 2001
package show;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.DV;
import concepts.HasName;

public class ShowHasName extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String hn = req.getParameter("hn");
      String cn = req.getParameter("cn");
      if ( null == cn ) cn = "unknown";
      if ( null == hn ) cn = "unknown"; 
      HasName obj = null;
      if ( cn.equals("Location") )
	obj = Common.getLocation(hn);
      else 
      if ( cn.equals("Disease") )
	obj = Common.getDisease(hn);
      else 
      if ( cn.equals("Symptom") )
	obj = Common.getSymptom(hn);
      else 
      if ( cn.equals("BodySystem") )
	obj = Common.getBodySystem(hn);
      else 
      if ( cn.equals("AbnormalCondition") )
	obj = Common.getAbnormalCondition(hn);
      else 
      if ( cn.equals("DiseaseSet") )
	obj = Common.getDiseaseSet(hn);
      if ( cn.equals("Drug") )
	  obj = Common.getDrug(hn);

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>A HasName</title></head>");
      out.println("<body bgcolor=\"yellow\">");
      out.println("<h3>The HasName: " + hn + "</h3>");
      if ( null == obj ) 
	  out.println("<h4>Can't find: " + hn + "</h4>");
      else {
	  out.println("<table border=\"1\">");
	  out.println(obj.html());
	  out.println("</table>");
      }
      out.println(DV.htmlDismissOrBack);

      out.println("</body>");
      out.println("</html>");
    }
}



