// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import com.LR;
import concepts.Disease;

public class DiseaseSubsumption extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allDiseases = Common.allDiseases();
      int lng = allDiseases.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>ShowDiseaseSubsumption</title></head>");
      out.println("<body bgcolor=\"lightgreen\">");
      out.println("<h1>DiseaseSubsumption, # diseases= " + lng + "</h1>");
      out.println("<h3>This screen shows disease pairs that are subsumed</h3><p>");
      String printName = null;
      String printName2 = null;
      String dis = null;
      String dis2 = null;
      Disease disease, disease2;
      Vector symptomNames = null;
      Vector symptomNames2 = null;
      int lngSN, lngSN2;
      int cnt = 0;
      int causesCnt = 0;
      int superCnt = 0;

      out.println("<table border=\"1\">");

      for (int i = 0; i < lng; i++) {
	  // if ( 300 < cnt ) break;
	dis = allDiseases[i];
	disease = Common.getDisease(dis);
	if ( disease.isSuperDisease() ) {
	    superCnt++;
	    continue;
	}
	symptomNames = disease.getAllSymptomNames();
	lngSN = symptomNames.size();
	printName = disease.getPrintName();
	int minAge = disease.getMinAge();
	int maxAge = disease.getMaxAge();
	String gender = disease.getGenderSpecificity();
	for (int j = 0; j < lng; j++) 
	    if ( i != j ) {
		dis2 = allDiseases[j];
		disease2 = Common.getDisease(dis2);
		if ( disease2.isSuperDisease() ) continue;
		symptomNames2 = disease2.getAllSymptomNames();
		lngSN2 = symptomNames2.size();
		if ( 0 == lngSN ) continue;
		if ( lngSN2 < lngSN ) continue;
		printName2 = disease2.getPrintName();
		int minAge2 = disease2.getMinAge();
		int maxAge2 = disease2.getMaxAge();
		if ( maxAge <  minAge2 || maxAge2 <  minAge) continue;
		String gender2 = disease2.getGenderSpecificity();
		if ( (gender.equals(LR.male) && gender2.equals(LR.female) ) ||
		     (gender.equals(LR.female) && gender2.equals(LR.male) ) )
		    continue;
		boolean subsumed = true;
		for (int k = 0; k < lngSN; k++) 
		    if ( !symptomNames2.contains(symptomNames.elementAt(k)) ) {
			subsumed = false;
			break;
		    }
		if ( !subsumed )  continue;
		String causes = "";
		if ( disease2.getInternalCauses().contains(dis) ) {
		    causes = " <b>causes:</b>";
		    causesCnt++;
		}
		// dis subsumes dis2
		out.println("<tr><td><a href='" + D.servletShowDisease + "?dis=" + dis + 
		    "'>" + dis + "</a>" + causes + "</td><td>" + lngSN + "</td>");
		out.println("<td><a href='" + D.servletShowDisease + "?dis=" + dis2 + 
		    "'>" + dis2 + "</a></td><td>" + lngSN2 + "</td></tr>");
		cnt++;
	    }
      }
      out.println("</table><p>");
      out.println("<h3>count: " + cnt + 
		  " causesCnt: " + causesCnt +  
		  " superCnt: " + superCnt +  
		  "</h3>");
      out.println("</body>");
      out.println("</html>");
    }
}



