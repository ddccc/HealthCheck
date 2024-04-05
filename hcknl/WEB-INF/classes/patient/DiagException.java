// Copyright OntoOO Inc, 2003 Mar
package patient;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.D;
import com.DV;
import com.L;

public class DiagException extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	call(res);
    }

    public static void call(HttpServletResponse res) throws IOException {
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>" + L.DiagException + "</title>" +
		  D.favicon +
		  "</head>");
      out.println("<body bgcolor=\"yellow\">");
      out.println("<h2>" +
		  // "No diseases found to explore or your input did not " +
		  // "yield a recognized symptom or body location." +
		  L.DiagExceptionS1 + 
		  "</h2>");
      out.println("<h3>" +
		  // "Provide different input and/or use another search mode." + 
		  L.DiagExceptionS2 + 
		  "</h3>");
      out.println("<h3>" +
		  // "Use the browser BACK button to return." + 
		  L.DiagExceptionS3 +
		  "</h3>");

      // localhost:8000 === healthcareProvider:80 or so
      out.println(DV.SCRIPTCC);

      out.println("</body>");
      out.println("</html>");
    }
}






