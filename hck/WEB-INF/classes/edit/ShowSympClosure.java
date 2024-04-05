// Copyright OntoOO Inc, 2002
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.DV;
import com.D;
import concepts.Symptom;

public class ShowSympClosure extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allSymptoms = Common.allSymptoms();
      int lng = allSymptoms.length;

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>ShowSympClosure</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H1>ShowSympClosure</H1>");
      out.println("Select collection of start symptoms:");
      out.println("<FORM  ACTION='" + D.servletShowSympClosure2 + "'>");
      out.println("<SELECT name='startSymptoms' MULTIPLE SIZE=6>");
      String dis, printName2;
      Symptom symptom;
      for (int i = 0; i < lng; i++) {
	dis = allSymptoms[i];
	symptom = Common.getSymptom(dis);
	printName2 = symptom.getName();
	out.println("<OPTION VALUE='" + dis + "'>" + printName2); 
      }
      out.println("</SELECT>");
      out.println("<p><input type='submit' value='Submit'>");

      out.println("</FORM>");

      out.println(DV.htmlDismissOrBack);
      out.println("</BODY>");
      out.println("</HTML>");
    }
}



