package misc;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class ZTestEmail extends HttpServlet {
    static final String FROM = "ddc@healthcheck4me.info";
    static final String TO = "ddc@rexx.com";

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      res.setContentType("text/plain");
      PrintWriter out = res.getWriter();
      try {
	  Properties props = new Properties();
	  props.put("mail.smtp.host", "healthcheck4me.info");
	  Session session = Session.getDefaultInstance(props, null);
	  Message msg = new MimeMessage(session);
	  msg.setFrom(new InternetAddress(FROM));
	  InternetAddress[] address = { new InternetAddress(TO) };
	  msg.setRecipients(Message.RecipientType.TO, address);
	  msg.setSubject("Test from home");

	  ByteArrayOutputStream baos = new ByteArrayOutputStream();
	  PrintWriter msgText = new PrintWriter(baos, true);
	  msgText.println("Does this show up ??????");
	  msgText.println();
	  msgText.println("---");
	  msgText.println("Sent by " + HttpUtils.getRequestURL(req));
	  msg.setText(baos.toString());

	  out.println("Before Transport ....");
	  Transport.send(msg);
	  out.println("Seems to have worked ....");
      } catch (Exception ex) {
	  out.println("Exception: " + ex.toString());
      }
    }
}



