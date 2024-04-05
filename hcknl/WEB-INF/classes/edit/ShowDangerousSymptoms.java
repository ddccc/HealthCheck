// Copyright OntoOO Inc, 2007 January
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.D;
import concepts.Disease;
import concepts.Symptom;
import concepts.WeightedSymptom;


public class ShowDangerousSymptoms extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allDiseases = Common.allDiseases();
      int lng = allDiseases.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>Show Dangerous Symptoms</title></head>");
      out.println("<body bgcolor=\"lightgreen\">");
      out.println("<h1>Show Dangerous Symptoms</h1>");
      String dis, printName;
      Disease disease;
      boolean isLT;
      Vector allSymptoms;
      int cnt = 0;
      Hashtable ht = new Hashtable();
      out.println("<table Border>");
      for (int i = 0; i < lng; i++) {
	dis = allDiseases[i];
	disease = Common.getDisease(dis);
	// filter here
	if ( disease.isSuperDisease() ) continue;
	isLT = disease.isLifeThreatening();
	if ( !isLT ) continue;
	allSymptoms = disease.getSymptoms();
	int lng2 = allSymptoms.size();
	if ( 0 == lng2 ) continue; // unlikely
	cnt++;
	printName = disease.getPrintName();
	printName = ( dis.equals(printName) ? dis : dis + "/ " + printName );
	out.println(
	     "<tr><td>" +
	     printName +
	     " </td><td> ");
	for (int j = 0; j < lng2; j++) {
	    WeightedSymptom ws = (WeightedSymptom) allSymptoms.elementAt(j);
	    String sym = ws.getSymptom();
	    Symptom symptom = Common.getSymptom(sym);
	    String pName = symptom.getPrintName();
	    pName = ( sym.equals(pName) ? pName : sym + "/ " + pName );
	    out.println((j == 0 ? "" : "<br> ") + pName);
	    Vector vec = (Vector) ht.get(sym);
	    if ( null == vec ) {
		vec = new Vector();
		vec.addElement(dis);
		ht.put(sym, vec);
	    } else {
		vec.addElement(dis);
	    }
	}
	out.println("</td></tr>");
      }
      out.println("</table>");
      out.println("<h2># Life Threatening Diseases: " + cnt + "</h2>");
      Enumeration enumz = ht.keys();
      int size = ht.size();
      out.println("<p><H2># Symptoms: " + size + "</H2>");
      String [] out2 = new String [size];
      int k = 0;
      while ( enumz.hasMoreElements() ) {
	out2[k++] = (String) enumz.nextElement();
      }
      Arrays.sort(out2);

      out.println("<table Border>");
      for (int i = 0; i < size; i++) {
	  String sym = out2[i];
	  Symptom symptom = Common.getSymptom(sym);
	  String pName = symptom.getPrintName();
	  pName = ( sym.equals(pName) ? pName : sym + "/ " + pName );
	  out.println(
	     "<tr><td>" +
	     pName +
	     " </td><td> ");
	  Vector vec = (Vector) ht.get(sym);
	  int lngvec = vec.size();
	  out.println(
	     lngvec +
	     " </td><td> ");
	  for (int j = 0; j < lngvec; j++) {
	      dis = (String) vec.elementAt(j);
	      disease = Common.getDisease(dis);
	      printName = disease.getPrintName();
	      printName = ( dis.equals(printName) ? dis : dis + "/ " + printName );
	      out.println((j == 0 ? "" : "<br> ") + printName);
	  }
	  out.println("</td></tr>");
      }
      out.println("</table>");
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
      out.println("</body>");
      out.println("</html>");
    }
}



