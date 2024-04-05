// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.Symptom;

public class EditSymptom2 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      boolean doModifyIncore = true;

      String name = req.getParameter("name");
      String printName = makePrintName(name);
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
      String webResource = req.getParameter("webResource");

      Symptom newSymptom = null;

      String code = 
	"<br>Symptom " + name + " = new Symptom(" +
	"<br>    LR." + name + "," +
	"<br>    \"" + description + "\"," +
	"<br>    LR." + theLocation + "St" +
	"<br>);";

      if (doModifyIncore)
	newSymptom = new Symptom(
	     name,
	     description,
	     theLocation);

      if ( !name.equals(printName) ) {
	code += 
               "<br>" + name + ".setPrintName(" +
	       ( printName.equals(description) ? ")" : "\"" + printName + "\")" ) +
	       ";";
	if (doModifyIncore) {
	  if ( printName.equals(description) )
	    newSymptom.setPrintName();
	  else
	    newSymptom.setPrintName(printName);
	}
      }

      if ( !webResource.equals("") ) {
	code += 
               "<br>" + name + ".setWebResource(\"" + webResource + "\");";
	if (doModifyIncore) 
	  newSymptom.setWebResource(webResource);
      }

      Vector codeLines = EditPartLocation2.makeCodeLines(name, code);

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Edit Symptom2</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H3>Edit Symptom2:</H3>");

      out.println("<br>name: " + name);
      out.println("<br>printName: " + printName);
      out.println("<br>description: " + description);
      out.println("<br>locationSt: " + locationSt);
      out.println("<br>newlocationSt: " + newlocationSt);
      if ( !webResource.equals("") ) 
	out.println("<br>webResource: " + webResource);


      if ( null != newSymptom ) {
	out.println("<table border>");
	out.println(newSymptom.html());
	out.println("</table>");
	Common.saveTheSymptoms();
	out.println("<H3>Symptom Hash table has been saved ... </H3>");
      }

      out.println("<br><b>code generated:</b>");
      out.println(code);

      String directory = D.theNewSymptomsDir;
      EditPartLocation2.writeCode(name, directory, codeLines, out);
      out.println("<H3>Code has been generated ...</H3>");

      out.println("</BODY>");
      out.println("</HTML>");
    }

  private String makePrintName(String name) {
    return Common.unPolish(name);
  }
}



