// (C) OntoOO Inc 2002
package patient;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import com.D;
import com.DV;
import com.DVM;
import com.L;

public class Info extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException

    {
	HttpSession session = req.getSession(false);
	boolean tracking = ( null != session );	

        res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>" + L.GetInfo + "</title> \n" + 
		    D.linkHckStyle +
		    D.favicon +
		    "</head> \n" +
		    "<body>" +
		    "<font color=\"#850a0a\">");

	out.println(DVM.htmlLogoutUser(L.GetInfo));

	// user Search
	out.println(DiagStart.search());
	out.println(
		    "<script language=\"JavaScript\"> " +
		    "document.forms['searchForm'].searchInput.focus(); " +
		    "</script>");

	out.println(DV.htmlBack);

	if ( tracking ) {
	    // localhost:8000 === healthcareProvider:80 or so
	    out.println(DV.SCRIPTCC);
	}

	out.println("</font></body>");
	out.println("</html>");
    }
}

