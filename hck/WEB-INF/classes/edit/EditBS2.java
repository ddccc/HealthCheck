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

public class EditBS2 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      boolean doModifyIncore = true;
String trace = "start";
try{
      String name = req.getParameter("name");
      String printName = req.getParameter("printName");
      String gender = req.getParameter("gender");
      String description = req.getParameter("description");
      if ( null == description || description.length() == 0 )
	description = printName;
      String locationSt = req.getParameter("locationSt");
      String newlocationSt = req.getParameter("newlocationSt");
      String theLocation = null;
      if ( locationSt.equals("select") ) {
	theLocation = newlocationSt;
	doModifyIncore = false;
      } else
	theLocation = locationSt;

      String superSysSt = req.getParameter("superSysSt");
      String newSuperSysSt = req.getParameter("newSuperSysSt");
      String theSuperSys = null;
      if ( !newSuperSysSt.equals("") ) {
	  theSuperSys = newSuperSysSt;
	  doModifyIncore = false;
      } else
      if ( !superSysSt.equals("null") )
	theSuperSys = superSysSt;

      BodySystem newBS = null;

      String code = 
	"<br>BodySystem " + name + " = new BodySystem(" +
	"<br>    LR." + name + "St," +
	"<br>    LR." + theLocation + "St," +
	( null == theSuperSys ?
	  "<br>    null," :
	  "<br>    LR." + theSuperSys + "St,") +
	"<br>    \"" + description + "\"" +
	"<br>);";

      if (doModifyIncore)
	newBS = new BodySystem(
	     name,
	     theLocation,
	     theSuperSys,
	     description);


      if ( !printName.equals("") ) {
	code = code + 
               "<br>" + name + ".setPrintName(\"" +
	       printName +
	       "\");";
	if (doModifyIncore)
	    newBS.setPrintName(printName);
      }

      if ( !gender.equals(LR.both) ) {
	code = code + 
               "<br>" + name + ".setGender(LR." +
	       gender +
	       ");";
	if (doModifyIncore)
	    newBS.setGender(gender);
      }


      Vector codeLines = EditPartLocation2.makeCodeLines(name, code);

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Edit BS2</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H3>Edit BS2:</H3>");

      out.println("<br>name: " + name);
      out.println("<br>printName: " + printName);
      out.println("<br>description: " + description);
      out.println("<br>locationSt: " + locationSt);
      out.println("<br>newlocationSt: " + newlocationSt);
      out.println("<br>theLocation: " + theLocation);
      out.println("<br>superSyst: " + superSysSt);
      out.println("<br>newSuperSysSt: " + newSuperSysSt);
      out.println("<br>theSuperSys: " + theSuperSys);

      out.println("<br><b>code generated:</b>");
      out.println(code);
      if ( null != newBS ) {
	out.println("<table border>");
	out.println(newBS.html());
	out.println("</table>");
	Common.saveTheBodySystems();
      }

      String directory = D.theNewBSsDir;
      EditPartLocation2.writeCode(name, directory, codeLines, out);

      out.println("</BODY>");
      out.println("</HTML>");

    } catch(Exception ex) {
      res.setContentType("text/html");
      ServletOutputStream outx = res.getOutputStream();
      outx.println("<HTML>");
      outx.println("<HEAD><TITLE>Edit Symptom Exception</TITLE></HEAD>");
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



