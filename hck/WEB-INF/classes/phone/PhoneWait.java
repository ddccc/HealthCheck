// (C) OntoOO Inc 2002 May
package phone;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.L;
import com.D;
// import htmls.Angel;

public class PhoneWait extends HttpServlet {
    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    PhoneError.call(res, "bevocal", 
			    // "Your session expired while in Phone Wait."
			    L.PhoneWait1
			    );
	    return;
	}
	String cnt = req.getParameter("cnt");
	call(res, session, cnt);
    } // end doGet

    static public void call(HttpServletResponse res, HttpSession session, String cnt)
	throws IOException {

	// update the "page description" that we produce
	Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");
	String page = "phone.PhoneWait";
	String currentPage = (String) session.getValue("page");
	if ( !page.equals(currentPage) ) {
	    session.putValue("page", page);
	    Integer pageCnt = (Integer) session.getValue("pageCnt");
	    pageCnt = new Integer(1+ pageCnt.intValue());
	    session.putValue("pageCnt", pageCnt);
	    unboundHashtable.put("pageCnt", pageCnt);
	}
	Integer surfCnt = (Integer) session.getValue("surfCnt");
	surfCnt = new Integer(1+ surfCnt.intValue());
	
	session.putValue("surfCnt", surfCnt);
	unboundHashtable.put("surfCnt", surfCnt);

	// to deal with different speech sites:
	String host = (String) session.getValue("host");

      String xml = 

"<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +

	    ( host.equals("bevocal") ?
	      L.vxml1
	      :
	      L.vxml2 );

	String state = (String) session.getValue("state");
	if ( state.equals("transfer") ) {
	    session.putValue("state", "transferred");
	    String phoneNumber = (String) session.getValue("phoneNumber");
	    xml = xml +
" <form> \n" +
" <block> \n" +
//"    You will now be transferred to a physician in the call center. \n" +
       L.PhoneWait2 +
" </block> \n" +
" <transfer dest=\"tel:" + phoneNumber + "\" bridge=\"false\"/> \n" +
" </form> \n" +
"</vxml>";
	} else {
	    int count = 0;
	    try { count = Integer.parseInt(cnt); } catch (NumberFormatException ignore) {};
	    boolean terminate = (2 < count);
	    if ( terminate ) session.invalidate();
	    else { // wait
		for (int i = 0; i < 15; i++) {
		    try { Thread.sleep(1000); } catch (InterruptedException ignore) {}
		    // check whether a call transfer is to be done
		} 
	    }
	    count++;

	    xml = xml +
"<property name=\"fetchaudio\" value=\"true\"/> \n" +
" <form> \n" +
" <block> \n" +
	  ( terminate ?
"    <prompt> \n" +
//"      Waiting time ends.  Thanks for using Health Check's phone advice line.  Bye now." +
         L.PhoneWait3 +
"    </prompt> \n" +
"    <disconnect/> \n" 
	    :
"    <prompt> \n" +
	    ( cnt.equals("0") ?
	      /*
"        You arrived here either because either the system was not able to recognize a body area " +
"        and neither any symptom or you managed to provide all the symptoms for a disease conjecture. " +
"        In the latter case: congratulations!! " +
"        The wait mode will currently terminate within a minute. "
	      */
	      L.PhoneWait4
	      : "") +
//"        You are still waiting with count is " + 
	   L.PhoneWait5 +
	   count + ". " +
//"        The wait mode will terminate pretty soon. " +
	   L.PhoneWait6 +
"    </prompt> \n" +
"     <var name=\"cnt\" expr=\"" + count + "\"/> \n" +
"     <submit next=\"" + D.servletPhoneWait + "\" " +
"                      method=\"get\" namelist=\"cnt\" fetchtimeout=\"60s\"/> \n" 
	    ) +
" </block> \n" +
" </form> \n" +
"</vxml>";
	}

	res.setContentType("application/voicexml+xml");
	ServletOutputStream out = res.getOutputStream();

	out.println(xml);

    } // end call

} // end PhoneWait
