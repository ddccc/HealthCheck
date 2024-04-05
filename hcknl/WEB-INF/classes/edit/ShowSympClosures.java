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

public class ShowSympClosures extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allSymptoms = Common.allSymptoms();

      Hashtable sTotal = new Hashtable();
      Hashtable dTotal = new Hashtable();
      Vector sympsNoDiseases = new Vector();

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>ShowSympClosure2</title></head>");
      out.println("<body bgcolor=\"lightgreen\">");
      out.println("<h1>ShowSympClosures</h1>");

      String seed = "dyspnea";
      boolean repeat = true;
      int repeatCnt = 0;
try {
while ( repeat ) {
      out.println("<br> seed: " + seed + " repeatCnt: " + repeatCnt);

      Vector sHashtables = new Vector();
      Vector dHashtables = new Vector();
      Hashtable sn = new Hashtable();
      sHashtables.addElement(sn);
      Hashtable dn;
      Vector allDis = new Vector();
      Vector allSym = new Vector();

      String sympStr, disStr;
      Integer zero = new Integer(0);

      sympStr = seed;
      sn.put(sympStr, zero); sTotal.put(sympStr, zero);
      allSym.addElement(sympStr);

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
	      allDis.addElement(disStr);
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
	      allSym.addElement(sympStr);
	    }
	  }
	}
	if ( 0 == sn.size() ) again = false; 
      }

      // all layers are determined
      int sTotalSize = sTotal.size();
      int dTotalSize = dTotal.size();

      out.println("<br>sTotalSize: " + sTotalSize);
      out.println("<br>dTotalSize: " + dTotalSize);
      out.println("<br>n: " + n);

      // ********** display all diseases in {dn}
      lng = allDis.size();
      out.println("<br># Diseases found in this cluster: " + lng);
      if ( lng <= 20 ) {
	for (int i = 0; i<lng; i++) {
	  disStr = (String) allDis.elementAt(i);
	  out.println("<br><a href='" + D.servletShowDisease + "?dis=" + 
		      disStr + "'>" + disStr + " </a>");
	}
	lng = allSym.size();
	out.println("<br># Symptoms found in this cluster: " + lng);
	for (int i = 0; i<lng; i++) {
	  sympStr = (String) allSym.elementAt(i);
	  out.println("<br><a href='" + D.servletShowSymptom + "?sym=" + 
		      sympStr + "'>" + sympStr + " </a>");
	}
      }

      out.println("<hr>");
      lng = allSymptoms.length;
      seed = null;
      for (int i = 0; i<lng; i++) {
	sympStr = allSymptoms[i];
	if ( sTotal.containsKey(sympStr) ) continue;
	symptom = Common.getSymptom(sympStr);
	diseasesOfSymptom = symptom.getTheDiseases();
	if ( 0 == diseasesOfSymptom.size() ) {
	  if ( sympsNoDiseases.contains(sympStr) ) continue;
	  sympsNoDiseases.addElement(sympStr);
	  continue;
	}
	seed = sympStr; 
	// out.println("<br>------ new seed: " + sympStr);
	break;
      }
      repeat = (null != seed);
      repeatCnt++;
} // end of while (repeat) 
int lng = sympsNoDiseases.size();
String sympStr;
if (0 < lng) {
  out.println("<p>Symptoms without diseases:");
  for (int i = 0; i<lng; i++) {
    sympStr = (String) sympsNoDiseases.elementAt(i);
    out.println("<br><a href='" + D.servletShowSymptom + "?sym=" + 
		sympStr + "'>" + sympStr + " </a>");
  }
}
} catch (Exception ex) {
  out.println("<br>*** Exception: " + ex.getMessage());
  out.println("Exception: " + ex.toString());
  out.println("<pre>");
  PrintStream ps = new PrintStream(out);
  ex.printStackTrace(ps);
  out.println("</pre>");
}      



      out.println(DV.htmlDismissOrBack);
      out.println("</body>");
      out.println("</html>");
    }
}



