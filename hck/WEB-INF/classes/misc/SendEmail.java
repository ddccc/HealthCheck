// (C) OntoOO Inc 2003 Apr
package misc;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import com.D;

public class SendEmail extends HttpServlet {
    // static final String FROM = "ZTestEmail";
    static final String TO = D.sendEmailAddress;
    static final String BUTTONS =
	 "<p><form> \n" +
	 "<input type=\"button\" value=\"Back\" onClick=\"history.back()\"> \n" +
	 "<input type=\"button\" value=\"Home\" onClick='location=\"" +
	 D.indexHtml + "\"'> \n" +
	 "</form>";

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String emailAddress = req.getParameter("emailAddress");
      String messageBody = req.getParameter("messageBody");
      String subject = req.getParameter("subject");
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println(
	  "<html><header><title>Thanks!</title></header>" +
	  "<body bgcolor=\"" + D.bgcolor + "\">" +
	  "<font color=\"#850a0a\"><p>");
      // Check for real user
      boolean realUser = true;
      String code = req.getParameter("test");  
      if ( null == code || !code.equals("YouAreIdiots7081943000079999999999999") ) 
	  realUser = false;
      /*
      if ( null == code || code.equals("") ) realUser = false;
      else { 
          String userReply = req.getParameter("userReply"); 
          if ( null == userReply || userReply.equals("") ) realUser = false;
	  else 
              realUser = checkUser(code, userReply);
      }
      */
      if ( realUser)  {
	  try { sendEmailFunc(TO, emailAddress, subject, messageBody, req); }
	  catch (Exception ex) {
	      out.println("<p>Something went wrong:<br> " + ex.toString());
	      out.println(BUTTONS);
	      out.println("</body></html>");
	      return;
	  }
      }
      out.println("<h1>THANKS for your Input/ Request/ Feedback/ ...</h1>");
      out.println(BUTTONS);
      out.println("</body></html>");
    }

    private boolean checkUser(String code, String userReply) {
	if ( 6 != code.length() ) return false;
	userReply = userReply.trim();
	if ( 3 != userReply.length() ) return false;
	userReply = userReply.toLowerCase();
	if ( 
	    !checkUser1(code.substring(0,2), userReply.substring(0,1)) ||
	    !checkUser1(code.substring(2,4), userReply.substring(1,2)) ||
	    !checkUser1(code.substring(4,6), userReply.substring(2,3)) )
	    return false;
	return true;
	/*
	  return ( 
	     checkUser1(code.substring(0,2), userReply.substring(0,1)) &&
	     checkUser1(code.substring(2,4), userReply.substring(1,2)) &&
	     checkUser1(code.substring(4,6), userReply.substring(2,3)) );
	 */
    }
    private boolean checkUser1(String code2, String userReply1) {
	char figure = code2.charAt(0);
	char letter = code2.charAt(1);
	/*
	  if ('0' == figure) {
	      if ('0' == letter) return userReply1.equals("a");
	      else 
	      if ('1' == letter) return userReply1.equals("b");
	      else return false;
          }
	  if ('1' == figure) {
	      if ('0' == letter) return userReply1.equals("k");
	      else 
	      if ('1' == letter) return userReply1.equals("l");
	      else return false;
          }
	  if ('2' == figure) {
	      if ('0' == letter) return userReply1.equals("x");
	      else 
	      if ('1' == letter) return userReply1.equals("y");
	      else return false;
          }
	  return false;
	 */
	if ( ('0' == figure) && ('0' == letter) ) return userReply1.equals("a");
	if ( ('0' == figure) && ('1' == letter) ) return userReply1.equals("b");
	if ( ('1' == figure) && ('0' == letter) ) return userReply1.equals("k");
	if ( ('1' == figure) && ('1' == letter) ) return userReply1.equals("l");
	if ( ('2' == figure) && ('0' == letter) ) return userReply1.equals("x");
	if ( ('2' == figure) && ('1' == letter) ) return userReply1.equals("y");
	return false;
    }

    public static void sendEmailFunc(String to, String from, 
				     String subject, String message,
				     HttpServletRequest req)
	throws Exception {
	  if ( null == message || message.equals("") ) {
	      throw new Exception("Message is empty ..."); 
	  }

	  Properties props = new Properties();
	  // props.put("mail.smtp.host", "healthcheck4me.info");
	  props.put("mail.smtp.host", "localhost");
	  Session session = Session.getDefaultInstance(props, null);
	  Message msg = new MimeMessage(session);
	  if ( null == from || from.equals("") ) from = D.fromAddress;
	  InternetAddress ia = null;
	  try { ia = new InternetAddress(from); }
	  catch (Exception ex) { 
	      throw new Exception("Return address invalid"); 
	  }
	  msg.setFrom(ia);
	  
	  InternetAddress[] address = { new InternetAddress(to) };
	  msg.setRecipients(Message.RecipientType.TO, address);
	  if ( null == subject || subject.equals("") ) subject = "Unknown";
	  msg.setSubject(subject);

	  ByteArrayOutputStream baos = new ByteArrayOutputStream();
	  PrintWriter msgText = new PrintWriter(baos, true);
	  msgText.println(message);
	  msgText.println();
	  msgText.println("---");
	  if ( null == req )
	      msgText.println("Sent by CheckLogger in AngelLogin; use sulogin to investigate");
	  else 
	      msgText.println("Sent by " + HttpUtils.getRequestURL(req));
	  msg.setText(baos.toString());
	  // out.println("<p>Before Transport ....");
	  Transport.send(msg); 
    }

}




