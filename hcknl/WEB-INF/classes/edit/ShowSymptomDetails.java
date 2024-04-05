// Copyright OntoOO/ Dennis de Champeaux, 2011
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.D;
import com.DV;
import com.L;
import concepts.Symptom;
import concepts.Disease;

public class ShowSymptomDetails extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String sym = req.getParameter("sym");
	String printName = null;
	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>" + L.TheSymptom + "</title> " +
		     D.favicon + "</head>");
	try {
	  if ( null == sym || sym.equals("") ) {
	      out.println("<body bgcolor=\"pink\">");
	      out.println("<h3>Error: Nothing to display</h3>");
	  } else {
	      Symptom symptom = Common.getSymptom(sym);
	      if ( null == symptom ) {
		  out.println("<body bgcolor=\"pink\">");
		  out.println("<h3>Error: Nothing to display</h3>");
	      }
	      else {
		  printName = symptom.getPrintName();
		  out.println("<body bgcolor=\"yellow\">");
		  out.println("<h3>" + L.TheSymptom + " " + printName + "</h3>");
		  Vector vec = symptom.getTheDiseases();
		  int lng = vec.size();
		  if ( 0<lng) {
		      out.println("# diseases in which this symptom occurs: " + lng);
		      out.println("<table border=\"1\">");
		      out.println("<tr><td>Disease</td><td>#symptoms</td><td>Disease set</td><tr>");
		      String servlet = D.servletShowDisease + "?dis=";
		      // StringBuffer sb = sortVec(vec, prefix);
		      StringBuffer sb = new StringBuffer();
		      Collections.sort(vec);
		      String str;
		      Hashtable ht = new Hashtable();
		      int cnt = 0;
		      for (int i = 0; i < lng; i++) {
			  str = (String) vec.elementAt(i);
			  Disease bs = Common.getDisease(str);
			  boolean lt = bs.isLifeThreatening();
			  if ( lt ) cnt++;
			  Vector theSymptoms = bs.getSymptoms();
			  String diseaseSet = bs.getDiseaseSet();
			  sb.append("<tr><td>");
			  sb.append("<a href='" + servlet + str + "'>" +
				    (lt ? "<font color=\"#ff0000a\">" : "") +
				    bs.getPrintName() + 
				    (lt ? "</font>" : "") +
				    "</a></td>");
			  sb.append("<td>" + theSymptoms.size() + "</td>");
			  sb.append("<td>" + diseaseSet + "</td>");
			  sb.append("</tr>");
			  if ( ht.containsKey(diseaseSet) ) {
			      Integer ii = (Integer) ht.get(diseaseSet);
			      ht.put(diseaseSet, new Integer(1+ii.intValue()));
			  } else ht.put(diseaseSet, new Integer(1));
		      }
		      out.println(sb.toString());
		      out.println("</table>");
		      Enumeration enumx = ht.keys();
		      out.println("<p><table border=\"1\">");
		      out.println("<tr><td>Disease set</td><td># in set</td></tr>");
		      while ( enumx.hasMoreElements() ) {
			  String key = (String) enumx.nextElement();
			  Integer ii = (Integer) ht.get(key);
			  out.println("<tr><td>" + key + "</td>" +
				      "<td>" + ii.intValue() + "</td></tr>");
		      }
		      out.println("</table>");
		      out.println("<p># life threatening: " + cnt + " balance: " + (lng-cnt));
		  } else out.println("<h3>There are no disease (yet)</h3>");
	      }
	  }
	} catch (Exception ex) { 
	    out.println("<body bgcolor=\"pink\">");
	    out.println("<h3>Can't display abnormal condition</h3>");
	    out.println("Exception: " + ex.getMessage());
	    Common.log(this.getClass().getName(), 
		       "sym= " + sym + "<br />" +
		       ex.getMessage());
	}
	out.println("<p>");
	out.println(DV.htmlDismissOrBack);
      out.println("</body>");
      out.println("</html>");
    }
}



