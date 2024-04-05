// Copyright OntoOO Inc, 2000
package edit;

import com.Common;
import com.IO;
import com.D;
import com.InitAll;
import concepts.Disease;
import concepts.XWord;
import concepts.XWordNormal;
import concepts.XWordPolish;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class FindIndexInDisease extends HttpServlet {
  // static String filePrefix = Common.filePrefix;

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      Hashtable ignoreWords = FindIndexInSymptom.getHashtable(D.ignoreWords);
      Hashtable indexWords = FindIndexInSymptom.getHashtable(D.indexWords);

      String [] allDiseases = Common.allDiseases();
      int lngDiseases = allDiseases.length;

      Hashtable wordsFound = new Hashtable();
 
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>FindIndexInDisease </TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H1>FindIndexInDisease</H1>");
      // out.println("<table BORDER>");
      String disease, description;
      Disease sym;
      for (int i = 0; i < lngDiseases; i++) {
	disease = allDiseases[i];
	// out.println("<tr><td><b>" + disease + "</b></td></tr>");
	sym = Common.getDisease(disease);
	description = sym.getDescription();
	FindIndexInSymptom.processDescription(
	   description, ignoreWords, indexWords, wordsFound, disease);
	description = sym.getPrintName();
	String printNamePolish = Common.eliminateSpace(description);
	if (  printNamePolish.equals(description) ) { // no spaces
	    description = stripToken(description);
	    XWordNormal xwn = null;
	    try { xwn = (XWordNormal) Common.getXWord(description); }
	    catch (ClassCastException ignore) { continue; } // impossible
	    if ( null == xwn ) 
	      xwn = new XWordNormal(description, "synonym");
	    else continue; // give up
	    xwn.setSynonym(disease);
	    ignoreWords.remove(description); // just in case
	    indexWords.put(description, disease);
	} else { // polish 
	    XWordPolish xwp = null;
	    try { xwp = (XWordPolish) Common.getXWord(printNamePolish); }
	    catch (ClassCastException ignore) { continue; } // impossible
	    if ( null == xwp ) 
	      xwp = new XWordPolish(printNamePolish, "synonym");
	    else continue; // give up
	    xwp.setSynonym(disease);
	    ignoreWords.remove(description); // just in case
	    indexWords.put(description, disease);
	}

	if ( 25 < wordsFound.size() ) break;
      }
      // out.println("</table>");
      out.println("<br># of ignoreWords: " + ignoreWords.size());
      out.println("<br># of indexWords: " + indexWords.size());
      out.println("<br># of wordsFound: " + wordsFound.size());

      HttpSession session = req.getSession(true);
      session.setMaxInactiveInterval(D.maxEditInactiveInterval);
      session.putValue("wordsFound", wordsFound);

      FindIndexInSymptom.makeTable(out, wordsFound);

      out.println("</BODY>");
      out.println("</HTML>");
    }
  static public String stripToken(String token) {
      return InitAll.stripToken(token);
  }
}



