// (C) OntoOO Inc 2002 May
package patient;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.D;
import htmls.Angel;
import actors.Actor;

public class UserLogout extends HttpServlet {
    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	call(req, res);
    }

static public void call (HttpServletRequest req, 
			 HttpServletResponse res)
    throws IOException {
      HttpSession session = req.getSession(false);
      if ( null != session ) {
	  Actor actor = (Actor) session.getValue("actor");
	  if ( null != actor ) actor.stop();

	  String state = (String) session.getValue("state");
	  if ( state.equals("chatting") ) { // record rude client behavior
	      Vector chatRecord = (Vector) session.getValue("chatRecord");
	      chatRecord.addElement("**Logout**<br>");
	  }
	  session.invalidate();
      }

      // Angel.call(res);

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println(
"<html><head><title>Feedback?</title>" +
D.linkHckStyle +
D.favicon +
"</head> \n" +
"<script language=\"JavaScript\"> \n" +
"function checkFields(form) { \n" +
"   if ( \"\" != form.messageBody.value ) \n" +
"     form.submit(); \n" +
"   else \n" +
"     alert(\"Why sending an empty message ??\"); \n" +
"} \n" +
"</script> \n" +
"<body>" +
"<font color=\"#850a0a\">");

      out.println(
"<h1 align=\"center\"> <font color=\"#1C5540\" size=\"6\"> \n" +
"Send Feedback ? \n" +
"</font> </h1>");

      out.println(
"<p>We hope your visit was helpful.  If not please let us know how we can improve!" +
"<br />A reply, whether or not you provide an email address, is NOT traceable " + 
"to your anonymous account.");

      out.println(
"<form method=\"get\" action=\"" + D.servletSendEmail + "\"> \n " +
"<p>Your email address if you want an answer: \n" +
"<input type=\"text\" size=\"50\" maxlength=\"50\" name=\"emailAddress\" /><p> \n" +
"Your message:<br> \n" +
"<textarea cols=\"75\" rows=\"15\" name=\"messageBody\"></textarea><p> \n" +

"<input type=\"button\" value=\"Submit\" onClick=\"checkFields(this.form)\" /> \n" +
// "<input type=\"button\" value=\"Back/Cancel\" onClick=\"history.back()\" /> \n" +
"<input type=\"button\" value=\"Home\" onClick=\"location='" + D.indexHtml + "'\" /> \n" +
"<input type=\"hidden\" name=\"subject\" value=\"Site Feedback\" />  \n" +
"<input type=\"hidden\" name=\"test\" value=\"YouAreIdiots7081943000079999999999999\" />  \n" +
"</form>  \n");

      out.println("</font></body></html>");



    } // end doGet
} // end UserLogout

