// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import concepts.AbnormalCondition;
import com.Common;
import com.D;

public class EditAC2 extends HttpServlet {

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

      AbnormalCondition newAC = null;

      String code = 
	"<br>AbnormalCondition " + name + " = new AbnormalCondition(" +
	"<br>    LR." + name + "," +
	"<br>    \"" + description + "\"," +
	"<br>    LR." + theLocation + "St" +
	"<br>);";

      if (doModifyIncore)
	newAC = new AbnormalCondition(
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
	    newAC.setPrintName();
	  else
	    newAC.setPrintName(printName);
	}
      }

      if ( !webResource.equals("") ) {
	code += 
               "<br>" + name + ".setWebResource(\"" + webResource + "\");";
	if (doModifyIncore) 
	  newAC.setWebResource(webResource);
      }


      Vector codeLines = EditPartLocation2.makeCodeLines(name, code);

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Edit AC2</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H3>Edit AC2:</H3>");

      out.println("<br>name: " + name);
      out.println("<br>printName: " + printName);
      out.println("<br>description: " + description);
      out.println("<br>locationSt: " + locationSt);
      out.println("<br>newlocationSt: " + newlocationSt);
      if ( !webResource.equals("") ) 
	out.println("<br>webResource: " + webResource);


      if ( null != newAC ) {
	out.println("<table border>");
	out.println(newAC.html());
	out.println("</table>");
	Common.saveTheAbnormalConditions();
	out.println("<H3>AC Hash table has been saved ... </H3>");
      }

      out.println("<br><b>code generated:</b>");
      out.println(code);

      String directory = D.theNewACsDir;
      EditPartLocation2.writeCode(name, directory, codeLines, out);
      out.println("<H3>Code has been generated ...</H3>");

      out.println("</BODY>");
      out.println("</HTML>");

    }

  private String makePrintName(String name) {
    return Common.unPolish(name);
  }
}



