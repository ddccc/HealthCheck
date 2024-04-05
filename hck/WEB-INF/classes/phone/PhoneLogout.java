// (C) OntoOO Inc 2002 May
package phone;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import com.D;
import com.L;
// import htmls.Angel;

public class PhoneLogout extends HttpServlet {
    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	HttpSession session = req.getSession(false);
	call(res, session);
    } // end doGet

    static public void call(HttpServletResponse res, HttpSession session)
	throws IOException {
	String host = "bevocal";
      if ( null != session ) { 
	  host = (String) session.getValue("host");
	  session.invalidate();
      } // tough luck if the host is not bevocal !

      String xml = 

"<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +

	    ( host.equals("bevocal") ?
	      L.vxml1
	      :
	      L.vxml2 ) +

" <form> \n" +
" <block> \n" +
//"    Thanks for using Health Check's phone advice line.  Bye now. \n" +
L.PhoneLogout1 +
" <disconnect/> \n" +
" </block> \n" +
" </form> \n" +
"</vxml>";


	res.setContentType("application/voicexml+xml");
	ServletOutputStream out = res.getOutputStream();

	out.println(xml);

    } // end call

} // end PhoneLogout
