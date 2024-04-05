// Copyright OntoOO Dennis de Champeaux, 2012
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.Disease;

public class ShowDiseaseLinks extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allDiseases = Common.allDiseases();
      int lng = allDiseases.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>ShowDiseaseLinks</title></head>");
      out.println("<body bgcolor=\"lightgreen\">");
      out.println("<h1>ShowDiseaseLinks, # diseases= " + lng + "</h1>");
      out.println(
	   "This screen allows to verify existing, and check for missing, " +
	   "causal connections between diseases." +
	   "<br>Error checking is done as well. " +
	   "<br>Assumption: a downstream disease D in U MUST be " +
	   "reported in D with U as a potential cause." +
	   "<br>Inherited diseases from a superdisease (upstream and downstream) " +
	   "are ignored." +
           "<p>Upstream entries: " +
	   "<br>- black: bi-directional causing-causes link" +
	   "<br>- <font Color='#FF0000'>red</font>: error/ disease is not defined" +
	   "<br>- <font Color='#0000FF'>blue</font> URL: uni-directional causing disease" +
           "<br>Downstream entries: " +
	   "<br>- black: bi-directional causing-causes link" +
	   "<br>- <font Color='#FF0000'>red</font>: error/ disease is not defined" +
	   "<br>- <font Color='#FF0000'>red</font> URL: error/ " +
	   "reverse link should be defined<p>");
      String printName = null;
      String dis = null;
      String dis2 = null;
      Disease disease, disease2;

      out.println("<table Border>");
      Vector upstream, downstream, upstream2, downstream2;
      int lng2 = 0;
try {
      for (int i = 0; i < lng; i++) {
	dis = allDiseases[i];
	disease = Common.getDisease(dis);
	printName = disease.getPrintName();
	printName = ( dis.equals(printName) ? dis : dis + "/ " + printName );
	out.println("<tr><td><a href='" + D.servletShowDisease + "?dis=" + dis + 
		    "'>" + printName + "</a></td></tr>");
	upstream = disease.getInternalCauses0();
	lng2 = upstream.size();
	if ( 0 < lng2 ) {
	  out.println("<tr><td>upstream:</td><td>");
	  for (int j = 0; j < lng2; j++) {
	    dis2 = (String) upstream.elementAt(j);
	    disease2 = Common.getDisease(dis2);
	    if ( null == disease2 ) 
	      out.println(
                 "<br><font Color='#FF0000' Size= 4>" + dis2 + "</font>");
	    else {
	      downstream2 = disease2.getCausesDiseases0();
	      if ( !downstream2.contains(dis) ) 
		out.println(
		  "<br><a href='" + D.servletEditDisease + "?dis=" + 
		               dis2 + "'>" + dis2 + "</a>");
	      else
		out.println(
                 "<br><font Color= 'black'>" + dis2 + "</font>");
	    }
	  }
	  out.println("</td></tr>");
	}
	downstream = disease.getCausesDiseases0();
	lng2 = downstream.size();
	if ( 0 < lng2 ) {
	  out.println("<tr><td>downstream:</td><td>");
	  for (int j = 0; j < lng2; j++) {
	    dis2 = (String) downstream.elementAt(j);
	    disease2 = Common.getDisease(dis2);
	    if ( null == disease2 ) 
	      out.println(
                 "<br><font Color='#FF0000' Size= 4>" + dis2 + "</font>");
	    else {
	      upstream2 = disease2.getInternalCauses0();
	      if ( !upstream2.contains(dis) ) 
		out.println(
		  "<br><a href='" + D.servletEditDisease + "?dis=" + dis2 + "'>" + 
		  "<font Color='#FF0000' Size= 4>" + dis2 + "</font> </a>");
	      else
		out.println(
                 "<br><font Color= 'black'>" + dis2 + "</font>");
	    }
	  }
	  out.println("</td></tr>");
	}
      }
} catch (Exception ex) {
      out.println("</table>");
      out.println("<br>Ex : " + ex.getMessage());
      out.println("<br>Ex dis: " + dis + " dis2: " + dis2 + " lng2: " + lng2);
      out.println("</body>");
      out.println("</html>");
      return;
}
      out.println("</table>");
      out.println("</body>");
      out.println("</html>");


    }
}



