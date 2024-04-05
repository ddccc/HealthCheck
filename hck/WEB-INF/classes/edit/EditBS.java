// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import com.LR;
import concepts.BodySystem;
import concepts.Location;

public class EditBS extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String bs = req.getParameter("bs"); // existing bs | newBS
      boolean newBS = bs.equals("newSys");
      BodySystem abbs = ( newBS ? null : Common.getBodySystem(bs) );
      String printName = ( newBS ? "provide bs print name" :
			   abbs.getPrintName());
      String description = ( newBS ? "provide description" :
			   abbs.getDescription());
      String gender = ( newBS ? LR.both :
			   abbs.getGender());
      String locationSt = ( newBS ? "provide location" :
			   abbs.getLocationName());
      String [] allLocations = Common.allLocations();
      int lng = allLocations.length;
      String superSys = ( newBS ? "null" :
			  abbs.getSuperSystemName());
      if ( null == superSys ) superSys = "null";
      String [] allBodySystems = Common.allBodySystems();
      int lngBS = allBodySystems.length;

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Edit BS</TITLE></HEAD>");
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
      if ( newBS )
	out.println("<H3>Create new BS:</H3>");
      else
	out.println("<H3>Edit the BS: " + printName + "</H3>");

      out.println("<FORM NAME=editBS ACTION='" + D.servletEditBS2 + "'>");
      out.println("<table BORDER>");
      out.println("<tr><td><b>name:</b></td><td>" +
		  "<input type='text' name='name' size=30 value='" +
		  bs + "'> NO spaces as in: cardioVascularSys</td></tr>");
      String constructedPrintName = 
	( bs.endsWith("Sys") ?
	  bs.substring(0, bs.length() - 3) + " system"
	  : bs );
      if ( printName.equals(constructedPrintName) )
	out.println("<tr><td><b>printName:</b></td><td>" +
		    "<input type='text' name='printName' size=30 value=\"\">" +
		    "<br>provide if different from: " + printName + "</td></tr>");
      else
	out.println("<tr><td><b>printName:</b></td><td>" +
		    "<input type='text' name='printName' size=30 value=\"" +
		    printName + "\"> Leave blank for: " +
		    constructedPrintName + "</td></tr>");
      out.println("<tr><td><b>description:</b></td><td>" + 
		  "<input type='text' name='description' size=70 value=\"" +
		  description + "\"> </td></tr>");

      out.println("<tr><td><b>Select the gender:</b></td><td>");
      out.println("<SELECT name=gender>");
      out.println("<OPTION VALUE='both'" + 
		  ( gender.equals("both") ? " SELECTED" : "") +
		  ">both"); 
      out.println("<OPTION VALUE='male'" + 
		  ( gender.equals("male") ? " SELECTED" : "") +
		  ">male"); 
      out.println("<OPTION VALUE='female'" + 
		  ( gender.equals("female") ? " SELECTED" : "") +
		  ">female");
      out.println("</SELECT>");
      out.println("</td></tr>");

      out.println("<tr><td><b>Select a locationSt:</b></td><td>");
      out.println("<SELECT name=locationSt>");
      out.println("<OPTION VALUE='select'  SELECTED>select"); 
      String dis, printName2;
      Location location;
      for (int i = 0; i < lng; i++) {
	dis = allLocations[i];
	location = Common.getLocation(dis);
	printName2 = location.getName();
	out.println("<OPTION VALUE='" + dis + "'>" + printName2); 
      }
      out.println("</SELECT>");
      out.println("</td></tr>");
      out.println("<tr><td><b>OR create new locationSt:</b></td><td>" + 
		  "<input type='text' name='newlocationSt' size=30 value='" +
		  locationSt + "'> NO spaces as in: leftHand</td></tr>");

      out.println("<tr><td><b>Select a super sys:</b></td><td>");
      out.println("<SELECT name=superSysSt>");
      out.println("<OPTION VALUE='null' " +
		  (superSys.equals("null") ? "SELECTED" : "") +
		  ">no super sys"); 
      BodySystem bs2;
      for (int i = 0; i < lngBS; i++) {
	dis = allBodySystems[i];
	bs2 = Common.getBodySystem(dis);
	printName2 = bs2.getName();
	out.println("<OPTION VALUE='" + dis + "' " +
		    (superSys.equals(dis) ? "SELECTED" : "") +
		    ">" + printName2); 
      }
      out.println("</SELECT>");
      out.println("</td></tr>");
      out.println("<tr><td><b>OR create new bodySys:</b></td><td>" + 
		  "<input type='text' name='newSuperSysSt' size=30 value=\"\"" +
		  "> NO spaces as in: respiratorySys</td></tr>");

      out.println("</table>");
      out.println("<p><input type='button' value='Submit' " +
		  "onClick= \"checkForm(this.form)\">");
      out.println("</FORM>");

      out.println("</BODY>");
      out.println("</HTML>");
    }
}



