// Copyright OntoOO Inc, 2000
package edit;

import com.Common;
import com.DV;
import com.D;
import concepts.Disease;
import concepts.Symptom;
import concepts.WeightedSymptom;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowMaleDiseases extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {

      HashSet allMaleDiseases = Common.allMaleDiseases();
      HashSet allFemaleDiseases = Common.allFemaleDiseases();
      Vector maleDiseases = new Vector();
      Vector femaleDiseases = new Vector();
      Vector neutralDiseases = new Vector();

      Iterator enumz = allMaleDiseases.iterator();
      String dis, printName;
      while ( enumz.hasNext() ) {
	dis = (String) enumz.next();
	if ( allFemaleDiseases.contains(dis) )
	  neutralDiseases.addElement(dis);
	else
	  maleDiseases.addElement(dis);
      }
      enumz = allFemaleDiseases.iterator();
      while ( enumz.hasNext() ) {
	dis = (String) enumz.next();
	if ( !allMaleDiseases.contains(dis) )
	  femaleDiseases.addElement(dis);
      }
      Collections.sort(maleDiseases);
      Collections.sort(femaleDiseases);
      Collections.sort(neutralDiseases);

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>All Male/Female Diseases</title>" +
		  D.favicon + "</head>");
      out.println("<body bgcolor=\"lightgreen\">");
      out.println("<b>Headings:</b><br>" +
		  "link/ #symptoms/ whether all symptoms are single");
      int singleCnt = 0;
      Disease disease;
      int numberOfSymptoms;
      Vector symptoms;
      String sym;
      Symptom symptom;
      boolean allSingle;
      WeightedSymptom ws;

      int lng = maleDiseases.size();
      out.println("<h1>All Male Diseases, # = " + lng + "</h1>");
      out.println("<table border>");
      for (int i = 0; i<lng; i++) {
	dis = (String) maleDiseases.elementAt(i);
	disease = Common.getDisease(dis);
	printName = disease.getPrintName();
	symptoms = disease.getSymptoms();
	numberOfSymptoms = symptoms.size();
	allSingle = true;
	for (int j = 0; j < numberOfSymptoms; j++) {
	    ws = (WeightedSymptom) symptoms.elementAt(j);
	    sym = ws.getSymptom();
	    symptom = Common.getSymptom(sym);
	    if ( !symptom.getSkip() ) { 
		allSingle = false;
		break;
	    }
	}
	if ( allSingle ) singleCnt++;
	out.println(
	     "<tr><td>" +
	     "<a href='" + D.servletShowDisease + "?dis=" + dis + "'>" +
	     printName + "</a></td><td>" + 
	     numberOfSymptoms + "</td><td>" +
	     ( allSingle ? "AllSingle" : "-" ) +
	     "</td></tr>");
      }
      out.println("</table>");

      lng = femaleDiseases.size();
      out.println("<h1>All Female Diseases, # = " + lng + "</h1>");
      out.println("<table BORDER>");
      for (int i = 0; i<lng; i++) {
	dis = (String) femaleDiseases.elementAt(i);
	disease = Common.getDisease(dis);
	printName = disease.getPrintName();
	symptoms = disease.getSymptoms();
	numberOfSymptoms = symptoms.size();
	allSingle = true;
	for (int j = 0; j < numberOfSymptoms; j++) {
	    ws = (WeightedSymptom) symptoms.elementAt(j);
	    sym = ws.getSymptom();
	    symptom = Common.getSymptom(sym);
	    if ( !symptom.getSkip() ) { 
		allSingle = false;
		break;
	    }
	}
	if ( allSingle ) singleCnt++;
	out.println(
	     "<tr><td>" +
	     "<a href='" + D.servletShowDisease + "?dis=" + dis + "'>" +
	     printName + "</a></td><td>" + 
	     numberOfSymptoms + "</td><td>" +
	     ( allSingle ? "AllSingle" : "-" ) +
	     "</td></tr>");
      }
      out.println("</table>");

      lng = neutralDiseases.size();
      out.println("<h1>All Neutral Diseases, # = " + lng + "</h1>");
      out.println("<table border>");
      for (int i = 0; i<lng; i++) {
	dis = (String) neutralDiseases.elementAt(i);
	disease = Common.getDisease(dis);
	printName = disease.getPrintName();
	symptoms = disease.getSymptoms();
	numberOfSymptoms = symptoms.size();
	allSingle = true;
	for (int j = 0; j < numberOfSymptoms; j++) {
	    ws = (WeightedSymptom) symptoms.elementAt(j);
	    sym = ws.getSymptom();
	    symptom = Common.getSymptom(sym);
	    if ( !symptom.getSkip() ) { 
		allSingle = false;
		break;
	    }
	}
	if ( allSingle ) singleCnt++;
	out.println(
	     "<tr><td>" +
	     "<a href='" + D.servletShowDisease + "?dis=" + dis + "'>" +
	     printName + "</a></td><td>" + 
	     numberOfSymptoms + "</td><td>" +
	     ( allSingle ? "AllSingle" : "-" ) +
	     "</td></tr>");
      }
      out.println("</table>");
      out.println("<b>singleCnt</b>:" + singleCnt);
      out.println(DV.htmlBack);

      out.println("</body>");
      out.println("</html>");
    }
}



