// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.ConnectionLocation;

public class EditConnectionLocation extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String trace = "start";
try{
      String cl = req.getParameter("cl"); // existing cl | newConnectionLocation
      boolean newConnectionLocation = cl.equals("newConnectionLocation");
      ConnectionLocation abcl = 
	( newConnectionLocation ? null : (ConnectionLocation) Common.getLocation(cl) );
      String referenceLocation1 = 
	( newConnectionLocation ? "provide referenceLocation1" :
			   abcl.getReferenceLocation1() );
      String referenceLocation2 = 
	( newConnectionLocation ? "provide referenceLocation2" :
			   abcl.getReferenceLocation2() );
      String [] allLocations = Common.allLocations();
      int lng = allLocations.length;

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Edit ConnectionLocation</TITLE></HEAD>");
      String script =
"<SCRIPT LANGUAGE= \"JavaScript\">" +
"function checkForm(form) {" +
	"if ( (form.name.value == \"\") || " +
	     "(form.name.value == \"newConnectionLocation\") ) {" +
	     "alert(\"Need value in name field ...\");" +
	     "return false;" +
	"}" +
	"if (form.referenceLocation1.selectedIndex == 0) { " +
	     "alert(\"Need a referenceLocation1 ...\");" +
	     "return false;" +
	"}" +
	"if (form.referenceLocation2.selectedIndex == 0) { " +
	     "alert(\"Need a referenceLocation2 ...\");" +
	     "return false;" +
	"}" +
	"form.submit();" +
"}" +
"</SCRIPT>";

      out.println(script);
      out.println("<BODY BGCOLOR=lightgreen>");
      if ( newConnectionLocation )
	out.println("<H3>Create new ConnectionLocation:</H3>");
      else
	out.println("<H3>Edit the ConnectionLocation: " + cl + "</H3>");

      out.println(
	"<FORM NAME=editConnectionLocation" +
	" ACTION='" + D.servletEditPartLocation + "'>");
      out.println("<table BORDER>");
      /*
      out.println("<tr><td><b>name:</b></td><td>" +
		  "<input type='text' name='referenceLocation1' size=30 value='" +
		  referenceLocation1 + "'> NO spaces as in: leftArm</td></tr>");
		  */
      out.println("<tr><td><b>Select a referenceLocation1:</b></td><td>");
      out.println("<SELECT name=referenceLocation1>");
      out.println("<OPTION VALUE='select1' >select1"); 
      String dis;
      for (int i = 0; i < allLocations.length; i++) {
	dis = allLocations[i];
	out.println("<OPTION VALUE='" + dis + "'" +
		    ( dis.equals(referenceLocation1) ? " SELECTED" : "" ) + 
		    ">" + dis);  
      }
      out.println("</SELECT>");
      out.println("</td></tr>");
      out.println("<tr><td><b>Select a referenceLocation2:</b></td><td>");
      out.println("<SELECT name=referenceLocation2>");
      out.println("<OPTION VALUE='select2' >select2"); 
      for (int i = 0; i < allLocations.length; i++) {
	dis = allLocations[i];
	out.println("<OPTION VALUE='" + dis + "'" +
		    ( dis.equals(referenceLocation2) ? " SELECTED" : "" ) + 
		    ">" + dis);  
      }
      out.println("</SELECT>");
      out.println("</td></tr>");
      out.println("</table>");
      out.println("<input TYPE=\"hidden\" NAME= \"pl\" VALUE=" + cl +">");
      out.println("<p><input type='button' value='Submit' " +
		  "onClick= \"checkForm(this.form)\">");
      out.println("</FORM>");

      out.println("</BODY>");
      out.println("</HTML>");
} catch(Exception ex) {
      res.setContentType("text/html");
      ServletOutputStream outx = res.getOutputStream();
      outx.println("<HTML>");
      outx.println("<HEAD><TITLE>Edit ConnectionLocation Exception</TITLE></HEAD>");
      outx.println("<BODY BGCOLOR=red>");
      outx.println("<H3>Trace: " + trace + "</H3>");
      outx.println("Exception: " + ex.toString());
      outx.println("<pre>");
      PrintStream ps = new PrintStream(outx);
      ex.printStackTrace(ps);
      outx.println("</pre>");
      outx.println("</BODY>");
      outx.println("</HTML>");
}

    }
}



