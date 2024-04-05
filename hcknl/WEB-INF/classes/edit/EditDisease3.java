// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.Disease;

public class EditDisease3 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {

      HttpSession session = req.getSession(true);
      String name = (String) session.getValue("name");
      String code = (String) session.getValue("code");
      Disease newDis = (Disease) session.getValue("newDis");



      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Edit Disease2</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H3>Edit Disease3: " + name + "</H3>");


      if ( null != newDis ) {
	out.println("<br><b>In core:</b>");
	out.println("<table border>");
	out.println(newDis.html());
	out.println("</table>");
	Common.saveHashTables();
	out.println("<H3>Hash tables have been saved ... </H3>");
      }

      Vector codeLines = makeCodeLines(name, code);
      int lng = codeLines.size();

      // to test:
      out.println("<br><b>Code generated:</b>");
      for (int i = 0; i < lng; i++) 
	out.println("<br>" + ((String)codeLines.elementAt(i)));

      String directory = D.theNewDiseasesDir;
      EditPartLocation2.writeCode(name, directory, codeLines, out);

      out.println("<H3>Code has been generated ...</H3>");

      out.println("</BODY>");
      out.println("</HTML>");
    } // end doGet

  private static Vector makeCodeLines(String name, String code) {
    return EditPartLocation2.makeCodeLines(name, code);
    /*
    Vector vec = new Vector();
    vec.addElement("// -------------- " + name + " --------------");
    vec.addElement("// (C) OntoOO Inc " + ((new Date()).toString()) );
    if ( (null == code) || !code.startsWith("<br>") ) {
      vec.addElement(code);
      return vec;
    }
    return stripBR(code, vec);
    */
  }

  public static Vector stripBR(String code, Vector vec) {
    // code starts with "<br>" ...
    int begin = 0; int next;
    String codeLine;
    while ( 0 <= begin ) {
      next = code.indexOf("<br>", begin + 1);
      if ( next < 0 ) {
	codeLine = code.substring(begin + 4);
      } else {
	codeLine = code.substring(begin + 4, next);
      }
      vec.addElement(codeLine);
      begin = next;
    }
    return vec;
  }
  /*
  private String eliminateSpace(String in) {
    return EditDisease.eliminateSpace(in);
  }

  public String unPolish(String in) {
    return Common.unPolish(in);
  }
  */
}



