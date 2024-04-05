// (C) OntoOO Inc 2002
package cc;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.DV;
import com.D;
import misc.SessionExpired;


public class KChatInvitation extends HttpServlet {

  public void doGet (HttpServletRequest req, 
		     HttpServletResponse res)
       throws ServletException, IOException
  {
    HttpSession session = req.getSession(false);
    if ( null == session ) {
	SessionExpired.call(res,
			    DV.KChatInvitation);
	return;
    }
    res.setContentType("text/html");
    ServletOutputStream out = res.getOutputStream();

    String sendAlert2 = (String) session.getValue("sendAlert2");

    if ( null != sendAlert2 ) { // message from the Actor
	session.removeValue("sendAlert2");
	out.println("<html><title>Actor Message</title><body bgcolor=\"yellow\">");
	out.println("<h1> Actor Alert Message</h1>");
	out.println(
	      "<script language=\"JavaScript\">" +
	      "setTimeout('window.close()', 20000);" +
	      "</script> \n" +
	      "<center><h2>" + sendAlert2 + "</h2> \n" +
	      "<p><form name=\"myForm\">" +
	      "<input type=\"button\" value=\"Close\" onClick=\"window.close()\" >" +
	      "</form></center> \n" +
	      "</body>" +
	      "</html>"
	      );
	return;
    }

    String kCallPerson = (String) session.getValue("kCallPersonName");
    if ( null == kCallPerson ) { // phantom invitation
	out.println("<html><body>");
	out.println(
	      "<script language=\"JavaScript\">" +
	      "window.close();" +
	      "</script> \n" +
	      "</body></html>"
	      );
	return;
    }

    // chat invitation from CC
    session.putValue("state", "windowOpened");
    out.println("<html><title>Invitation</title><body bgcolor=\"yellow\">");
    out.println("<h1>" + kCallPerson + " can help you!</h1>");
    out.println(
	"<script language=\"JavaScript\">" +
	"function setHidden(form) {" +
	"  val = form.yesno[0].checked;" +
	"  if (val) setHidden2('yes'); " +
	"  else setHidden2('no'); " +
	"}" +
	"function timeOut() { setHidden2('timeout'); } " +
	"function setHidden2(val) {" +
	"  window.clearTimeout(myTimeout);" +
	"  document.myForm.invitationReply.value=val;" +
	"  document.myForm.submit();" +
	// this window will be closed by KChatResponse 
	"}" +
	"var myTimeout = setTimeout('timeOut()', 20000);" +
	"</script>" +

	"<form name=\"myForm\" action=\"" + D.servletKChatResponse + "\">" +
	"<br /><input type=\"radio\" name=\"yesno\" checked=\"checked\"> Yes please help!" +
	"<br /><input type=\"radio\" name=\"yesno\" > No thank you!" +
	"<p><input type=\"button\" value=\"Reply\" onClick=\"setHidden(this.form)\" >" +

	"<input type=\"hidden\" name=\"invitationReply\" value=\"no\">" +
	"</form>" +
	"</body>" +
	"</html>"
	);

  }
}
