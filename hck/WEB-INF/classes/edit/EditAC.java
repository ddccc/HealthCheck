// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.AbnormalCondition;
import concepts.Location;
import concepts.Treatment;

public class EditAC extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String ac = req.getParameter("ac"); // existing ac | newAC
      boolean newAC = ac.equals("newAC");
      AbnormalCondition abac = ( newAC ? null : Common.getAbnormalCondition(ac) );
      String printName = ( newAC ? "provide ac print name" :
			   abac.getPrintName());
      String description = ( newAC ? "provide description" :
			   abac.getDescription());
      String locationSt = ( newAC ? "provide location" :
			   abac.getLocationSt());
      String webResource = ( newAC ? "" :
			   abac.getWebResource());
      if ( null == webResource ) webResource = "";
      Vector treatments = ( newAC ? null : abac.getTreatments() );
      boolean bTreatments = ( (null != treatments) && (0 < treatments.size()) );
      Vector allTreatments2 = new Vector();

      String [] allLocations = Common.allLocations();
      int lng = allLocations.length;

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Edit AC</TITLE></HEAD>");
      String script =
"<SCRIPT LANGUAGE= \"JavaScript\">" +
"function checkForm(form) {" +
	"if (form.name.value == \"\") {" +
	     "alert(\"Need value in name field ...\");" +
	     "return false;" +
	"}" +
	"if ( (form.locationSt.selectedIndex == 0) && " +
	     "(form.newlocationSt.value == \"\")) {" +
	     "alert(\"Need a location ...\");" +
	     "return false;" +
	"}" +
	"form.submit();" +
"}" +
"</SCRIPT>";

      out.println(script);
      out.println("<BODY BGCOLOR=lightgreen>");
      if ( newAC )
	out.println("<H3>Create new AC:</H3>");
      else
	out.println("<H3>Edit the AC: " + printName + "</H3>");

      out.println("<FORM NAME=editAC ACTION='" + D.servletEditAC2 + "'>");
      out.println("<table BORDER>");
      out.println("<tr><td><b>name:</b></td><td>" +
		  "<input type='text' name='name' size=30 value='" +
		  ac + "'> NO spaces as in: mucoidSputum</td></tr>");
      out.println("<tr><td><b>description:</b></td><td>" + 
		  "<input type='text' name='description' size=200 value=\"" +
		  description + "\"> <br> if different from name</td></tr>");
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
		    (newAC ? "" : ( dis.equals(locationSt) ? " SELECTED" : "") ) +
		    ">" + printName2); 
      }
      out.println("</SELECT>");
      out.println("</td></tr>");
      out.println("<tr><td><b>OR create new locationSt:</b></td><td>" + 
		  "<input type='text' name='newlocationSt' size=30 value=''" +
		  "> NO spaces as in: leftHand</td></tr>");
      out.println("<tr><td><b>webResource:</b></td><td>" +
		  "<input type='text' name='webResource' size=100 value='" +
		  webResource + "'> </td></tr>");

      // treatments
      if ( bTreatments ) {
	out.println("<tr><td><b>Treatments:</b></td></tr>");
	lng = treatments.size();
	String sym, description2;
	Treatment treatment;
	int anchor = 0;
	for (int i = 0; i < lng; i++) {
	  sym = (String) treatments.elementAt(i);
	  allTreatments2.addElement(sym);
	  treatment = Common.getTreatment(sym);
	  // printName2 = treatment.getPrintName();
	  description2 = treatment.alertDescription();
	  anchor++;
	  out.println("<tr><td>" +
		      "<A HREF='#" + anchor + 
		      "' NAME='" + anchor + "' onClick=\"alert('" +
		      description2 + "')\">" +
		      sym + "</A>" +
		      "</td>");
	  out.println(
	     "<td>" + // printName2 + " " +
	     "<INPUT TYPE='radio' NAME='" + sym + "' VALUE='keep' CHECKED> keep? " +
	     "<INPUT TYPE='radio' NAME='" + sym + "' VALUE='edit'> edit? " +
	     "<INPUT TYPE='radio' NAME='" + sym + "' VALUE='remove'> remove? " +
	     "</td></tr>");
	}
      }

      out.println("<tr><td><b>Add Treatment?:</b></td>");
      out.println(
	     "<td>" + // printName2 + " " +	
	     "<INPUT TYPE='radio' NAME='addTreatment' VALUE='no' CHECKED> no " +
	     "<INPUT TYPE='radio' NAME='addTreatment' VALUE='yes'> yes " +
	     "</td></tr>");

      out.println("</table>");
      out.println("<p><input type='button' value='Submit' " +
		  "onClick= \"checkForm(this.form)\">");
      if ( bTreatments ) {
	String vecStr = allTreatments2.toString();
	out.println("<input TYPE=\"hidden\" NAME=\"treatmentsList\" " +
		    "VALUE=\"" + vecStr.substring(1, vecStr.length()-1) +
		    "\">");
      }
      out.println("</FORM>");

      out.println("</BODY>");
      out.println("</HTML>");
    }
}



