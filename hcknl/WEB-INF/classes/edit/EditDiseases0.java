// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.Disease;

public class EditDiseases0 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allDiseases = Common.allDiseases();
      int lng = allDiseases.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>All Diseases0</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H1>Select Disease without symptoms or ** temp</H1>");
      String dis, printName;
      Disease disease;
      boolean isLT;
      Vector allSymptoms;
      int cnt = 0;
      out.println("<table Border>");
      for (int i = 0; i < lng; i++) {
	dis = allDiseases[i];
	disease = Common.getDisease(dis);
	// filter here
	allSymptoms = disease.getSymptoms();
	if ( 0 < allSymptoms.size() ) {
	    String miscComments = disease.getMiscComments();
	    if ( null == miscComments ) continue;
	    if ( miscComments.indexOf("**") < 0 ) continue;
	}
	// no symptoms or temp entry
	if ( disease.isSuperDisease() ) continue;
	cnt++;
	isLT = disease.isLifeThreatening();
	printName = disease.getPrintName();
	printName = ( dis.equals(printName) ? dis : dis + "/ " + printName );
	out.println(
	     "<tr><td>" + 
	     ( isLT ? 
	       "<FONT Color= \"FF0000\">" + printName + "</FONT>" :
	       printName ) +
	     " </td><td> " +
	     "<A HREF='" + D.servletEditDisease + "?dis=" + dis + "'> edit </A></td><td>" +
	     "<A HREF='" + D.servletShowDisease + "?dis=" + 
	             dis + "'> show </A></td></tr>");
      }

      /*
      // to speed things up do not get the disease/ printname ...
      for (int i = 0; i < allDiseases.length; i++) {
	dis = allDiseases[i];
	out.println(
	     "<tr><td>" + dis + " </td><td> " +
	     "<A HREF='/servlet/EditDisease?dis=" + dis + "'> edit </A></td><td>" +
	     "<A HREF='/servlet/ShowDisease?dis=" + dis + "'> show </A></td></tr>");
      }
      */
      out.println("</table>");
      out.println("<p># diseases without symptoms or temp: " + cnt);
      out.println("</BODY>");
      out.println("</HTML>");
    }
}



