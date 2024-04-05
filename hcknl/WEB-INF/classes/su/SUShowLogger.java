// Copyright OntoOO Inc, 2008 Aug
package su;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.DVM;
import com.D;
import com.DV;
import com.Common;

public class SUShowLogger extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	Vector logger = Common.getLogger();
	int lng = logger.size();
	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>SURoot</title>" +
		    D.linkGreyStyle + " \n" +
		    D.favicon + "</head>");
	out.println("<body bgcolor=\"bbbbbb\">");
	out.println(DVM.htmlLogoutSU("SUShowLogger"));
	out.println(Common.getLogHTML(logger));
	out.println(DV.htmlBack);
	out.println("</body>");
	out.println("</html>");
    }

}







