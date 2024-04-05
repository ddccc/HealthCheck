// Copyright OntoOO Inc, 2000
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

public class SelectSymptoms2 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String startSymptoms = req.getParameter("startSymptoms");
      if ( null == startSymptoms || startSymptoms.equals("") ) {
	startSymptoms = req.getParameter("allSymptoms2");
      }
      if ( null == startSymptoms || startSymptoms.equals("") ) {
	res.sendRedirect(D.servletSelectSymptoms);
	return;
      }


      HttpSession session = req.getSession(false);
      Hashtable sTotal = (Hashtable) session.getValue("sTotal");
      Hashtable dTotal = (Hashtable) session.getValue("dTotal");
      Integer roundInt = (Integer) session.getValue("roundInt");
      // allSymptomsVec has instances of Symptom
      Vector allSymptomsVec = (Vector) session.getValue("allSymptomsVec");
      // sortSymptomsVec has instances of DynamicSortSymptom
      Vector sortSymptomsVec = (Vector) session.getValue("sortSymptomsVec");
      // symptomVecs has instances of Vector which have instances of String 
      Vector symptomVecs  = (Vector) session.getValue("symptomVecs");

      int round = 1+roundInt.intValue();
      session.putValue("roundInt", new Integer(round));

      String sympStr, disStr;
      Vector newSymps = new Vector();
      int lng, lng2, lngj;
      Symptom symptom;
      Vector diseasesOfSymptom;
      Vector symptomsOfDisease;
      Disease disease;
      WeightedSymptom ws;
      Vector newTestVec = new Vector();
      Integer rejectInt;
      Integer one = new Integer(1);

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>SelectSymptoms2</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H1>SelectSymptoms2 round: " + round + "</H1>");

try{

      StringTokenizer st = new StringTokenizer(startSymptoms, ",");

      while ( st.hasMoreTokens() ) {
	sympStr = st.nextToken(); 
	sTotal.put(sympStr, sympStr);
	newSymps.addElement(sympStr);
      }

      // 0 < newSymps.size() !!
      // out.println("<br>/// newSymps.size(): " + newSymps.size());

      symptomVecs.addElement(newSymps);
      lng = newSymps.size();
      for (int k = 0; k < lng; k++) {
	sympStr = (String) newSymps.elementAt(k);
	symptom = Common.getSymptom(sympStr);
	diseasesOfSymptom = symptom.getTheDiseases();
	lng2 = diseasesOfSymptom.size();
	for (int i = 0; i < lng2; i++) {
	  disStr = (String) diseasesOfSymptom.elementAt(i);
	  rejectInt = (Integer) dTotal.get(disStr);
	  if (null == rejectInt) dTotal.put(disStr, one); else
	    dTotal.put(disStr, new Integer(1 + rejectInt.intValue()));
	}
      }
      // out.println("<br>/// dTotal.size(): " + dTotal.size());

      lng = sortSymptomsVec.size();
      DynamicSortSymptom dss;
      int eligibleDiseases;
      for (int i = 0; i < lng; i++) {
	dss = (DynamicSortSymptom) sortSymptomsVec.elementAt(i);
	symptom = dss.getSymptom();
	sympStr = symptom.getName();
	if ( sTotal.containsKey(sympStr) ) {
	  dss.setEligibleDiseases(-1); // off limits
	  continue;
	}
	diseasesOfSymptom = symptom.getTheDiseases();
	lng2 = diseasesOfSymptom.size();
	eligibleDiseases = 0;
	for (int j = 0; j < lng2; j++) {
	  disStr = (String) diseasesOfSymptom.elementAt(j);
	  rejectInt = (Integer) dTotal.get(disStr);
	  if (null == rejectInt) { eligibleDiseases++; continue; }
	  if ( rejectInt.intValue() < 2 ) eligibleDiseases++;
	}
	dss.setEligibleDiseases( 
	     ( 0 == eligibleDiseases ? -1 // no need to keep this symptom around
	       : eligibleDiseases ) );
      }
      Collections.sort(sortSymptomsVec);
      // out.println("<br>/// sorted sortSymptomsVec ...");

      out.println("<br>Prompt symptoms per iteration:");
      lng = symptomVecs.size();
      String printName2;
      for (int i = 0; i < lng; i++) {
	newSymps = (Vector) symptomVecs.elementAt(i);
	lngj = newSymps.size();
	out.println("<br> Prompt symptoms round: " + i + 
		    " #: " + lngj + "<br>");
	for (int j = 0; j < lngj; j++) { 
	  sympStr = (String) newSymps.elementAt(j);
	  symptom = Common.getSymptom(sympStr);
	  printName2 = symptom.getPrintName();
	  out.println("<A HREF='" + D.servletShowSymptom + "?sym=" + 
		      sympStr + "'>" + printName2 + "</A> ");
	}
      }
      out.println("<br>sTotal.size(): " + sTotal.size());
      out.println("<br>dTotal.size(): " + dTotal.size());
      /*
      out.println("<br>sortSymptomsVec.size(): " + sortSymptomsVec.size());
      dss = (DynamicSortSymptom) sortSymptomsVec.elementAt(0);
      symptom = dss.getSymptom();
      sympStr = symptom.getName();
      eligibleDiseases = dss.getEligibleDiseases();
      out.println("<br>sortSymptomsVec(0): " + sympStr + " " + eligibleDiseases);
      symptom = (Symptom) allSymptomsVec.elementAt(0);
      sympStr = symptom.getName();
      out.println("<br>allSymptomsVec(0): " + sympStr + " " +
		  symptom.getTheDiseases().size());
      */

      out.println("<p>Select collection of next prompt symptoms:");
      out.println("<FORM  ACTION='" + D.servletSelectSymptoms2 + "'>");
      out.println("<SELECT name='startSymptoms' MULTIPLE SIZE=6>");
      lng = sortSymptomsVec.size();
      for (int i = 0; i < lng; i++) {
	dss = (DynamicSortSymptom) sortSymptomsVec.elementAt(i);
	eligibleDiseases = dss.getEligibleDiseases();
	if ( eligibleDiseases < 0 ) break; // no more symptoms
	symptom = dss.getSymptom();
	sympStr = symptom.getName();
	printName2 = symptom.getName();
	out.println("<OPTION VALUE='" + sympStr + "'>" + 
		    eligibleDiseases + " " +printName2 ); 
      }
      out.println("</SELECT>");
      out.println("<p><input type='submit' value='Submit'>");

      out.println("</FORM>");

} catch (Exception ex) {
  out.println("<br>**** Exception: " + ex.getMessage());
  out.println("Exception: " + ex.toString());
  out.println("<pre>");
  PrintStream ps = new PrintStream(out);
  ex.printStackTrace(ps);
  out.println("</pre>");
}



      out.println(DV.htmlDismissOrBack);
      out.println("</BODY>");
      out.println("</HTML>");
    }
}



