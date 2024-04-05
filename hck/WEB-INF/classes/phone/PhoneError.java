// (C) OntoOO Inc 2004 Feb
package phone;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.DV;
import com.D;
import com.L;


public class PhoneError extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	String msg = req.getParameter("msg");
	String host = req.getParameter("host");

	HttpSession session = req.getSession(false);
	if ( null != session ) session.invalidate();

	call(res, host, msg);
    }
    
    static public void call(HttpServletResponse res, String host, String msg) 
	throws IOException {

	String xml = 

"<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +

	    ( host.equals("bevocal") ?
	      L.vxml1
	      :
	      L.vxml2 ) +

" <form> \n" +
" <block> \n" +
//"    A problem has been encountered that prevents continuation.  Specificly: \n" +
L.PhoneError1 +
msg +
" </block> \n" +
" </form> \n" +
"</vxml>";


	res.setContentType("application/voicexml+xml");
	ServletOutputStream out = res.getOutputStream();

	out.println(xml);

    }
}






