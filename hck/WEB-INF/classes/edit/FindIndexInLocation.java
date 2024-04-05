// Copyright OntoOO Inc, 2000
package edit;

import com.Common;
import com.IO;
import com.D;
import com.InitAll;
import concepts.Location;
import concepts.XWord;
import concepts.XWordNormal;
import concepts.XWordPolish;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class FindIndexInLocation extends HttpServlet {
  // static String filePrefix = Common.filePrefix;

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      Hashtable ignoreWords = FindIndexInSymptom.getHashtable(D.ignoreWords);
      Hashtable indexWords = FindIndexInSymptom.getHashtable(D.indexWords);

      String [] allLocations = Common.allLocations();
      int lngLocations = allLocations.length;

      Hashtable wordsFound = new Hashtable();
 
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>FindIndexInLocation </TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H1>FindIndexInLocation</H1>");
      out.println("<b>BEFORE:::</b>");
      out.println("<br># of ignoreWords: " + ignoreWords.size());
      out.println("<br># of indexWords: " + indexWords.size());
      out.println("<br># of wordsFound: " + wordsFound.size());

      // out.println("<table BORDER>");
      String location, description;
      Location sym;
      for (int i = 0; i < lngLocations; i++) {
	location = allLocations[i];
	// out.println("<tr><td><b>" + location + "</b></td></tr>");
	sym = Common.getLocation(location);
	/*
	description = sym.getDescription();
	FindIndexInSymptom.processDescription(
	   description, ignoreWords, indexWords, wordsFound, location);
	*/
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
	    xwn.setSynonym(location);
	    ignoreWords.remove(description); // just in case
	    indexWords.put(description, location);
	} else { // polish 
	    XWordPolish xwp = null;
	    try { xwp = (XWordPolish) Common.getXWord(printNamePolish); }
	    catch (ClassCastException ignore) { continue; } // impossible
	    if ( null == xwp ) 
	      xwp = new XWordPolish(printNamePolish, "synonym");
	    else continue; // give up
	    xwp.setSynonym(location);
	    ignoreWords.remove(description); // just in case
	    indexWords.put(description, location);
	}

	if ( 25 < wordsFound.size() ) break;
      }
      // out.println("</table>");
      out.println("<p> <b>AFTER:::</b>");
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



