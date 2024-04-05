// Copyright OntoOO Inc, 2002
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;

public class ShowSympStats extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      HttpSession session = req.getSession(true);
      session.setMaxInactiveInterval(3600000); // Jrun in millisec ....

      String [] allSymptoms = Common.allSymptoms();
      session.putValue("allSymptoms", allSymptoms);
      res.sendRedirect(D.servletShowSympStats2);
    }
}



