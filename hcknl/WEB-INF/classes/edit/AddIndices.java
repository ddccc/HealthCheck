// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.D;
import com.InitAll;
import concepts.BodySystem;
import concepts.Disease;
import concepts.Symptom;
import concepts.XWordNormal;

public class AddIndices  extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      Hashtable indexWords = FindIndexInSymptom.getHashtable(D.indexWords);
      int indexWordsSize = indexWords.size();
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>AddIndices </TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H1>AddIndices</H1>");

      StringBuffer sb =  new StringBuffer("<pre>\n");
      InitAll.procAddIndices(sb, true);
      sb.append("</pre>\n"); 

      out.println(sb.toString());

      out.println("</BODY>");
      out.println("</HTML>");
    }


}

