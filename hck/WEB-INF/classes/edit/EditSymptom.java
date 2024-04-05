// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.Symptom;
import concepts.Location;

public class EditSymptom extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String sym = req.getParameter("sym"); // existing symptom | newSymptom
      boolean newSymptom = sym.equals("newSymptom");
      Symptom symptom = ( newSymptom ? null : Common.getSymptom(sym) );
      String printName = ( newSymptom ? "provide symptom print name" :
			   symptom.getPrintName());
      String description = ( newSymptom ? "provide description" :
			   symptom.getDescription());
      String locationSt = ( newSymptom ? "provide location" :
			   symptom.getLocationSt());
      String webResource = ( newSymptom ? "" :
			   symptom.getWebResource());
      if ( null == webResource ) webResource = "";

      String [] allLocations = Common.allLocations();
      int lng = allLocations.length;

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Edit Symptom</TITLE></HEAD>");
      String script =
"<SCRIPT LANGUAGE= 'JavaScript'>" +
"function checkForm(form) {" +
	"if (form.name.value == \"\") {" +
	     "alert('Need value in name field ...');" +
	     "return false;" +
	"}" +
	"if ( (form.locationSt.selectedIndex == 0) && " +
	     "(form.newlocationSt.value == \"\")) {" +
	     "alert('Need a location ...');" +
	     "return false;" +
	"}" +
	"form.submit();" +
"}" +
"</SCRIPT>";

      out.println(script);
      out.println("<BODY BGCOLOR=lightgreen>");
      if ( newSymptom )
	out.println("<H3>Create new Symptom:</H3>");
      else
	out.println("<H3>Edit the Symptom: " + printName + "</H3>");

      out.println("<FORM NAME=editSymptom ACTION='" + D.servletEditSymptom2 + "'>");
      out.println("<table BORDER>");
      out.println("<tr><td><b>name:</b></td><td>" +
		  "<input type='text' name='name' size=50 value='" +
		  sym + "'> NO spaces as in: mucoidSputum</td></tr>");
      out.println("<tr><td><b>description:</b></td><td>" + 
		  "<input type='text' name='description' size=200 value='" +
		  description + "'> <br> if different from name</td></tr>");
      out.println("<tr><td><b>Select a locationSt:</b></td><td>");
      out.println("<SELECT name=locationSt>");
      out.println("<OPTION VALUE='select'>select"); 
      String dis, printName2;
      Location location;
      for (int i = 0; i < allLocations.length; i++) {
	dis = allLocations[i];
	location = Common.getLocation(dis);
	printName2 = location.getName();
	out.println("<OPTION VALUE=" + dis + 
		    (newSymptom ? "" : ( dis.equals(locationSt) ? " SELECTED" : "") ) +
		    ">" + printName2); 
      }
      out.println("</SELECT>");
      out.println("</td></tr>");
      out.println("<tr><td><b>OR create new locationSt:</b></td><td>" + 
		  "<input type='text' name='newlocationSt' size=30 value='" +
		  locationSt + "'> NO spaces as in: leftHand</td></tr>");
      out.println("<tr><td><b>webResource:</b></td><td>" +
		  "<input type='text' name='webResource' size=100 value='" +
		  webResource + "'> </td></tr>");
      out.println("</table>");
      out.println("<p><input type='button' value='Submit' " +
		  "onClick= \"checkForm(this.form)\">");
      out.println("</FORM>");
      out.println("</BODY>");
      out.println("</HTML>");

    }
}



