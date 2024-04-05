// Copyright OntoOO Inc, 2000
package show;

import com.Common;
import com.DV;
import com.L;
import concepts.Disease;
import concepts.Treatment;
import concepts.Treatment;
import concepts.Drug;
import concepts.TreatmentAction;


import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DisplayTreatment extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String diseaseName = req.getParameter("dis");
	String printName = null;
	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>" + L.Treatment + "</title></head>");
	try {
	  if ( null == diseaseName || diseaseName.equals("") ) {
	      out.println("<body bgcolor=\"pink\">");
	      out.println("<h3>Error: Nothing to display</h3>");
	  } else {
	      Disease disease = Common.getDisease(diseaseName);
	      if ( null == disease ) {
		  out.println("<body bgcolor=\"pink\">");
		  out.println("<h3>Error: Nothing to display</h3>");
	      }
	      else {
		  printName = disease.getPrintName();
		  Vector treatments = disease.getTreatments();
		  String treatmentName;
		  Treatment aTreatment;
		  Vector vec;
		  out.println("<body bgcolor=\"yellow\">");
		  int lng = treatments.size();
		  if (lng <= 0) 
		      out.println("<h1>" + 
				  // "No treatment for" +
				  L.DisplayTreatmentS1 +
				  " " + printName + "</h1>");
		  else {
		      TreatmentAction ta;
		      Drug drug;
		      out.println("<h1>" +
				  // "Treatment for" +
				  L.TreatmentFor +
				  " " + printName + "</h1>");
		      for (int i=0; i<lng; i++) {
			  treatmentName = (String) treatments.elementAt(i);
			  aTreatment = Common.getTreatment(treatmentName);
			  vec = aTreatment.getTreatmentActions();
			  out.println("<br /><b>" + L.TreatmentNum + "</b> " + (i+1));
			  for (int j=0; j<vec.size(); j++) {
			      ta = (TreatmentAction) vec.elementAt(j);
			      out.println("<br />" + ta.getDescription());
			  }
			  vec = aTreatment.getDrugs();
			  out.println("<br /><b>Drugs:</b>");
			  for (int j=0; j<vec.size(); j++) {
			      drug = (Drug) vec.elementAt(j);
			      out.println("<br />" + drug.getDescription());
			  }
			  out.println("<p>");
		      }
		  }
	      }
	  }
	} catch (Exception ex) { 
	    out.println("<body bgcolor=\"pink\">");
	    out.println("<h3>Can't display treatments</h3>");
	    out.println("Exception: " + ex.getMessage());
	    Common.log(this.getClass().getName(), 
		       "diseaseName= " + diseaseName+ "<br />" +
		       ex.getMessage());
	}

	out.println("<p>");
	out.println(DV.htmlDismiss);
	out.println("</body>");
	out.println("</html>");
    }
}



