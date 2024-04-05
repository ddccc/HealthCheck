// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.LocationSet;

public class EditLocationSet extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String trace = "start";
try{
      String ls = req.getParameter("ls"); // existing ls | newLocationSet
      boolean newLocationSet = ls.equals("newLocationSet");
      LocationSet abcl = 
	( newLocationSet ? null : (LocationSet) Common.getLocation(ls) );
      String superset = 
	( newLocationSet ? "provide superset if any" :
			   abcl.getSuperset() );
      String [] allLocationSets = Common.allLocationSets();
      int lng = allLocationSets.length;

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Edit LocationSet</TITLE></HEAD>");
      String script =
"<SCRIPT LANGUAGE= \"JavaScript\">" +
"function checkForm(form) {" +
	"if ( (form.name.value == \"\") || " +
	     "(form.name.value == \"newLocationSet\") ) {" +
	     "alert(\"Need value in name field ...\");" +
	     "return false;" +
	"}" +
	"form.submit();" +
"}" +
"</SCRIPT>";

      out.println(script);
      out.println("<BODY BGCOLOR=lightgreen>");
      if ( newLocationSet )
	out.println("<H3>Create new LocationSet:</H3>");
      else
	out.println("<H3>Edit the LocationSet: " + ls + "</H3>");

      out.println(
	"<FORM NAME=editLocationSet" +
	" ACTION='" + D.servletEditPartLocation + "'>");
      out.println("<table BORDER>");
      out.println("<tr><td><b>Select a superset if any:</b></td><td>");
      out.println("<SELECT name=superset>");
      out.println("<OPTION VALUE='none' >none"); 
      String dis;
      for (int i = 0; i < allLocationSets.length; i++) {
	dis = allLocationSets[i];
	out.println("<OPTION VALUE='" + dis + "'" +
		    ( dis.equals(superset) ? " SELECTED" : "" ) + 
		    ">" + dis);  
      }
      out.println("</SELECT>");
      out.println("</td></tr>");
      out.println("</table>");
      out.println("<input TYPE=\"hidden\" NAME= \"pl\" VALUE=" + ls +">");
      out.println("<p><input type='button' value='Submit' " +
		  "onClick= \"checkForm(this.form)\">");
      out.println("</FORM>");

      out.println("</BODY>");
      out.println("</HTML>");
} catch(Exception ex) {
      res.setContentType("text/html");
      ServletOutputStream outx = res.getOutputStream();
      outx.println("<HTML>");
      outx.println("<HEAD><TITLE>Edit LocationSet Exception</TITLE></HEAD>");
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



