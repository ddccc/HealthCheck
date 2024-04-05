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
import concepts.Disease;
import concepts.WeightedSymptom;

public class ShowSympClosure2 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      Hashtable sTotal = new Hashtable();
      Hashtable dTotal = new Hashtable();
      Vector sHashtables = new Vector();
      Vector dHashtables = new Vector();
      Hashtable sn = new Hashtable();
      sHashtables.addElement(sn);
      Hashtable dn;
      
      String startSymptoms = req.getParameter("startSymptoms");
      if ( null == startSymptoms || startSymptoms.equals("") ) {
	res.sendRedirect(D.servletShowSympClosure);
	return;
      }
      String sympStr, disStr;
      Integer zero = new Integer(0);
      StringTokenizer st = new StringTokenizer(startSymptoms, ",");
      while ( st.hasMoreTokens() ) {
	sympStr = st.nextToken();
	sn.put(sympStr, zero); sTotal.put(sympStr, zero);
      }
      boolean again = true;
      Integer nI = zero;
      int n = 0;
      Enumeration enumz;
      Symptom symptom;
      Vector diseasesOfSymptom;
      Vector symptomsOfDisease;
      int lng;
      Disease disease;
      WeightedSymptom ws;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>ShowSympClosure2</title></head>");
      out.println("<body bgcolor=\"lightgreen\">");
      out.println("<h1>ShowSympClosure2</h1>");

try{
      while (again) {
	n = nI.intValue();
	// out.println("<br>n: " + n);
	sn = (Hashtable) sHashtables.elementAt(n);
	dn = new Hashtable();
	dHashtables.addElement(dn);
	enumz = sn.keys();
	while ( enumz.hasMoreElements() ) {
	  sympStr = (String) enumz.nextElement();
	  symptom = Common.getSymptom(sympStr);
	  diseasesOfSymptom = symptom.getTheDiseases();
	  lng = diseasesOfSymptom.size();
	  for (int i = 0; i<lng; i++) {
	    disStr = (String) diseasesOfSymptom.elementAt(i);
	    if ( !dTotal.containsKey(disStr) ) {
	      dn.put(disStr, nI); dTotal.put(disStr, nI);
	    }
	  }
	}
	if ( 0 == dn.size() ) { again = false; continue; }
	// out.println("<br>n: " + n + " again == true " + (again == true));
	// creating n+1 h-table
	nI = new Integer(n+1);
	sn = new Hashtable();
	sHashtables.addElement(sn);
	enumz = dn.keys();
	while ( enumz.hasMoreElements() ) {
	  disStr = (String) enumz.nextElement();
	  disease = Common.getDisease(disStr);
	  symptomsOfDisease = disease.getSymptoms();
	  lng = symptomsOfDisease.size();
	  for (int i = 0; i<lng; i++) {
	    ws = (WeightedSymptom) symptomsOfDisease.elementAt(i);
	    sympStr = ws.getSymptom();
	    if ( !sTotal.containsKey(sympStr) ) {
	      sn.put(sympStr, nI); sTotal.put(sympStr, nI);
	    }
	  }
	}
	if ( 0 == sn.size() ) again = false; 
      }
} catch (Exception ex) {
  out.println("<br>**** Exception: " + ex.getMessage());
}

      // all layers are determined
      int sTotalSize = sTotal.size();
      int dTotalSize = dTotal.size();

      out.println("<h3>sTotalSize: " + sTotalSize + "</h3>");
      out.println("<h3>dTotalSize: " + dTotalSize + "</h3>");
      out.println("<h3>n: " + n + "</h3>");

      String [] allSymptoms = Common.allSymptoms();
      lng = allSymptoms.length;
      Vector deltaS = new Vector();
      for (int i = 0; i<lng; i++) {
	sympStr = allSymptoms[i];
	if ( !sTotal.containsKey(sympStr) ) deltaS.addElement(sympStr);
      }
      lng = deltaS.size();

      if ( 0 < lng ) {
	String [] deltaStr = new String[lng];
	deltaS.copyInto(deltaStr);
	HttpSession session = req.getSession(true);
	session.putValue("allSymptoms", deltaStr);
	out.println("<p><form  action='" + D.servletShowSympStats2 + "'>");
	out.println("<p><input type='submit' value='ShowSympStats2'>");
	out.println("</form>");
      }
      

      out.println(DV.htmlDismissOrBack);
      out.println("</body>");
      out.println("</html>");
    }
}



