// Copyright OntoOO Inc, 2000
package edit;

import com.Common;
import com.DV;
import com.D;
import concepts.Symptom;


import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowMaleSymps extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      HashSet allMaleSymptoms = Common.allMaleSymptoms();
      HashSet allFemaleSymptoms = Common.allFemaleSymptoms();
      Vector maleSymptoms = new Vector();
      Vector femaleSymptoms = new Vector();
      Vector neutralSymptoms = new Vector();

      Iterator enumz = allMaleSymptoms.iterator();
      String symp, printName, description, statusCondition;
      while ( enumz.hasNext() ) {
	symp = (String) enumz.next();
	if ( allFemaleSymptoms.contains(symp) )
	  neutralSymptoms.addElement(symp);
	else
	  maleSymptoms.addElement(symp);
      }
      enumz = allFemaleSymptoms.iterator();
      while ( enumz.hasNext() ) {
	symp = (String) enumz.next();
	if ( !allMaleSymptoms.contains(symp) )
	  femaleSymptoms.addElement(symp);
      }
      Collections.sort(maleSymptoms);
      Collections.sort(femaleSymptoms);
      Collections.sort(neutralSymptoms);

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>All Male/Female Symptoms</title></head>");
      out.println("<body bgcolor=\"lightgreen\">");
      Symptom symptom;
      int numberOfDiseases;
      int minAge, maxAge;
      boolean cardinal;
      out.println("<b>Headings:</b><br>" +
	  "link/ printName/ description/ minAge/ maxAge/ statusCondition/ numberOfDisease/ cardinal?");

      int lng = maleSymptoms.size();
      out.println("<h1>All Male Symptoms, # = " + lng + "</h1>");
      out.println("<table border>");
      for (int i = 0; i<lng; i++) {
	symp = (String) maleSymptoms.elementAt(i);
	symptom = Common.getSymptom(symp);
	printName = symptom.getPrintName();
	description = symptom.getDescription();
	minAge =  symptom.getMinAge();
	maxAge =  symptom.getMaxAge();
	statusCondition =  symptom.getStatusCondition();
	numberOfDiseases = symptom.getTheDiseases().size();
	cardinal = symptom.getCardinal();
	out.println(
	     "<tr><td>" +
	     "<a href='" + D.servletShowSymptom + "?sym=" + symp + "'>" +
	     symp + "</a></td><td>" + 
	     printName + "</td><td>" + 
	     description + "</td><td>" + 
	     minAge + "</td><td>" + 
	     maxAge + "</td><td>" + 
	     statusCondition + "</td><td>" + 
	     numberOfDiseases + "</td><td>" + 
	     ( cardinal? "C" : "-" ) +
	     "</td></tr>");
      }
      out.println("</table>");

      lng = femaleSymptoms.size();
      out.println("<h1>All Female Symptoms, # = " + lng + "</h1>");
      out.println("<table border>");
      for (int i = 0; i<lng; i++) {
	symp = (String) femaleSymptoms.elementAt(i);
	symptom = Common.getSymptom(symp);
	printName = symptom.getPrintName();
	description = symptom.getDescription();
	minAge =  symptom.getMinAge();
	maxAge =  symptom.getMaxAge();
	statusCondition =  symptom.getStatusCondition();
	numberOfDiseases = symptom.getTheDiseases().size();
	cardinal = symptom.getCardinal();
	out.println(
	     "<tr><td>" +
	     "<a href='" + D.servletShowSymptom + "?sym=" + symp + "'>" +
	     symp + "</a></td><td>" + 
	     printName + "</td><td>" + 
	     description + "</td><td>" + 
	     minAge + "</td><td>" + 
	     maxAge + "</td><td>" + 
	     statusCondition + "</td><td>" + 
	     numberOfDiseases + "</td><td>" + 
	     ( cardinal? "C" : "-" ) +
	     "</td></tr>");
      }
      out.println("</table>");

      lng = neutralSymptoms.size();
      out.println("<h1>All Neutral Symptoms, # = " + lng + "</h1>");
      out.println("<table border>");
      for (int i = 0; i<lng; i++) {
	symp = (String) neutralSymptoms.elementAt(i);
	symptom = Common.getSymptom(symp);
	printName = symptom.getPrintName();
	description = symptom.getDescription();
	minAge =  symptom.getMinAge();
	maxAge =  symptom.getMaxAge();
	statusCondition =  symptom.getStatusCondition();
	numberOfDiseases = symptom.getTheDiseases().size();
	cardinal = symptom.getCardinal();
	out.println(
	     "<tr><td>" +
	     "<a href='" + D.servletShowSymptom + "?sym=" + symp + "'>" +
	     symp + "</a></td><td>" + 
	     printName + "</td><td>" + 
	     description + "</td><td>" + 
	     minAge + "</td><td>" + 
	     maxAge + "</td><td>" + 
	     statusCondition + "</td><td>" + 
	     numberOfDiseases + "</td><td>" + 
	     ( cardinal? "C" : "-" ) +
	     "</td></tr>");
      }
      out.println("</table>");
      out.println(DV.htmlBack);

      out.println("</body>");
      out.println("</html>");
    }
}





