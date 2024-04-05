// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.DV;
import com.D;
import misc.SessionExpired;

public class ARW extends HttpServlet {

    public void doPost (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      Hashtable ignoreWords = FindIndexInSymptom.getHashtable(D.ignoreWords);
      Hashtable indexWords = FindIndexInSymptom.getHashtable(D.indexWords);

      HttpSession session = req.getSession(false);
      if ( null == session ) {
	  SessionExpired.call(res,
			      DV.ARW);
	  return;
      }

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>ARW </TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H1>ARW</H1>");

      int cntNewIndexWords = 0;
      int cntNewIgnoreWords = 0;

String trace = "";
boolean ok = true;
try{
      Hashtable wordsFound = (Hashtable) session.getValue("wordsFound");
trace += "wordsFound = null " + (null == wordsFound);

      if ( null == wordsFound ) wordsFound = new Hashtable();

      out.println("<br># of ignoreWords: " + ignoreWords.size());
      out.println("<br># of indexWords: " + indexWords.size());
      out.println("<br># of wordsFound: " + wordsFound.size());

      out.println("<table BORDER>");

      Enumeration keys = wordsFound.keys();
      String token, tokenValue, description, symptom;
trace += "<br> before while";
      while ( keys.hasMoreElements() ) {
	token = (String) keys.nextElement();
	description = (String) wordsFound.get(token);
	symptom = description.substring(0,description.indexOf('|'));
	tokenValue = req.getParameter(token);
	out.println(
           "<tr><td>" + token + 
	   "</td><td>" + tokenValue + 
	   "</td><td>" + symptom + 
	   "</td></tr>");
	if ( tokenValue.equals("1") ) {
	  indexWords.put(token, symptom); cntNewIndexWords++;
        }
        else {
	  ignoreWords.put(token, symptom); cntNewIgnoreWords++;
        }
      }

      out.println("</table>");
      // save the hashtables ignoreWords indexWords 

} catch (Exception ex) {
      out.println("<br>***Exception: " + ex.getMessage());
      out.println("<br>trace: " + trace);
      ok = false;
}
      out.println("<br># of cntNewIgnoreWords: " + cntNewIgnoreWords);
      out.println("<br># of cntNewIndexWords: " + cntNewIndexWords);

      out.println("<br># of ignoreWords: " + ignoreWords.size());
      out.println("<br># of indexWords: " + indexWords.size());

      boolean errorInWritingIgnoreWords = false;
      boolean errorInWritingIndexWords = false;
      if ( ok && 0 < cntNewIgnoreWords ) 
	errorInWritingIgnoreWords = 
	  !FindIndexInSymptom.saveHashtable(D.ignoreWords, ignoreWords);
      if ( ok && 0 < cntNewIndexWords ) 
	errorInWritingIndexWords = 
	  !FindIndexInSymptom.saveHashtable(D.indexWords, indexWords);

      Common.saveTheXWords();

      out.println("<br>errorInWritingIgnoreWords: " + errorInWritingIgnoreWords);
      out.println("<br>errorInWritingIndexWords: " + errorInWritingIndexWords);
      out.println("<br>ok to write: " + ok);

      out.println("</BODY>");
      out.println("</HTML>");
    }
}



