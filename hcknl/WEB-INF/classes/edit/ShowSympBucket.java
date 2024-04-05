// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.Symptom;

public class ShowSympBucket extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Symptom Bucket</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
try{
      HttpSession session = req.getSession(false);
      // out.println("null ==  session: " + (null == session));
      Vector [] freq = (Vector []) session.getValue("freq");
      // out.println("null ==  freq: " + (null == freq));
      String istr = req.getParameter("i");
      int i2 = 0;
      i2 = Integer.parseInt(istr); 

      Vector symVec = (Vector) freq[i2];
      int lng = symVec.size();
      out.println("<H1>Symptom Bucket # = " + i2 + "</H1>");

      String symp, printName;
      Symptom symptom;
      out.println("<table Border>");
      out.println("<tr><td><b>Symptom name </b></td><td><b>#" + lng + "</b></td></tr>");
      for (int i = 0; i < lng; i++) {
	symp = (String) symVec.elementAt(i);
	symptom = Common.getSymptom(symp);
	printName = symptom.getPrintName();
	out.println(
	     "<tr><td>" + 
	     ( symp.equals(printName) ? symp : symp + "/ " + printName ) +
	     "</td><td>" +
	     "<A HREF='" + D.servletShowSymptom + "?sym=" + 
	              symp + "'> show </A></td></tr>");
      }
      out.println("</table><p>");
      out.println("<table Border>");

      out.println(
	   "<p><FORM>" +
	   "<INPUT TYPE='button' VALUE='Back' onClick='history.back()'>" +
	   "</FORM>");
} catch(Exception ex) {
      out.println("<br>***** Ex: " + ex.getMessage());
}
      out.println("</BODY>");
      out.println("</HTML>");


    }
}



