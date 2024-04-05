// Copyright OntoOO Inc, 2000
package edit;

import com.Common;
import com.IO;
import com.D;
import com.InitAll;
import concepts.Symptom;
import concepts.XWord;
import concepts.XWordNormal;
import concepts.XWordPolish;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FindIndexInSymptom extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      
      Hashtable ignoreWords = getHashtable(D.ignoreWords);
      Hashtable indexWords = getHashtable(D.indexWords);

      String [] allSymptoms = Common.allSymptoms();
      int lngSymptoms = allSymptoms.length;

      Hashtable wordsFound = new Hashtable();
 
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>FindIndexInSymptom </TITLE></HEAD>");
      out.println("<BODY BGCOLOR=\"lightgreen\">");
      out.println("<H1>FindIndexInSymptom</H1>");

      // out.println("<table BORDER>");
      String symptom, description;
      Symptom sym;

      for (int i = 0; i < lngSymptoms; i++) {
	symptom = allSymptoms[i];
	// out.println("<tr><td><b>" + symptom + "</b></td></tr>");
	sym = Common.getSymptom(symptom);
	description = sym.getDescription();
	processDescription(
	   description, ignoreWords, indexWords, wordsFound, symptom);
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
	    xwn.setSynonym(symptom);
	    ignoreWords.remove(description); // just in case
	    indexWords.put(description, symptom);
	} else { // polish 
	    XWordPolish xwp = null;
	    try { xwp = (XWordPolish) Common.getXWord(printNamePolish); }
	    catch (ClassCastException ignore) { continue; } // impossible
	    if ( null == xwp ) 
	      xwp = new XWordPolish(printNamePolish, "synonym");
	    else continue; // give up
	    xwp.setSynonym(symptom);
	    ignoreWords.remove(description); // just in case
	    indexWords.put(description, symptom);
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

      makeTable(out, wordsFound);

      out.println("</BODY>");
      out.println("</HTML>");
    }

  static public Hashtable getHashtable(String htName) {
    return IO.readOrCreateHT(htName);
  }
  static public boolean saveHashtable(String htName, Hashtable ht) {
    return IO.saveHT(htName, ht);
  }
  

  static public String stripToken(String token) {
      return InitAll.stripToken(token);
  }

  static public void processDescription(String description,
					Hashtable ignoreWords,
					Hashtable indexWords,
					Hashtable wordsFound,
					String symptom) {
        String token, context, type;
	int lng;
	XWord xword;
	Class aClass;
	String className;
	XWordNormal xwordn;
	StringTokenizer st = new StringTokenizer(description);
	while ( st.hasMoreTokens() ) {
	  token = st.nextToken();
	  token = stripToken(token);

	  lng = token.length();
	  if ( lng < 3 ) continue;
	  if ( ignoreWords.containsKey(token) ) continue;
	  if ( indexWords.containsKey(token) ) continue;

	  context = (String) wordsFound.get(token);
	  if ( null != context ) continue;

	  xword = Common.getXWord(token);
	  if ( null == xword ) {
	    wordsFound.put(token, symptom + "| " + description);
	    // out.println("<tr><td>new word</td><td>" + token + "<td></tr>");
	    continue;
	  }
	  type = xword.getType();
	  if ( !type.equals("unknown") ) continue;
	  aClass = xword.getClass();
	  className = aClass.getName();
	  if ( !className.equals(D.XWordNormalClass) ) {
	    // out.println("<tr><td>**POLISH**</td><td>" + token + "</td></tr>");
	    continue;
	  }
	  xwordn = (XWordNormal) xword;
	  if ( xwordn.isReferenced(symptom) ) continue;
	  wordsFound.put(token, symptom + "| " + description);
	  // out.println("<tr><td>known word</td><td>" + token + "</td></tr>");
	}
  }

  static public void makeTable(ServletOutputStream out, Hashtable wordsFound) 
	throws ServletException, IOException   {
      // display table of wordsFound and decide whether or not to index on them
      Enumeration keys = wordsFound.keys();
      out.println("<FORM METHOD=post ACTION='" + D.servletARW + "'>");
      out.println("<table BORDER>");
      String token, description;
      while ( keys.hasMoreElements() ) {
	token = (String) keys.nextElement();
	description =(String) wordsFound.get(token);
	out.println(
           "<tr><td>" + token + "</td><td>" + 
	   "<INPUT TYPE='radio' NAME='" + token + "' VALUE='1'> inx" +
	   "<br><INPUT TYPE='radio' NAME='" + token + "' VALUE='0' CHECKED> ign" +
	   "</td><td>" + description + "</td></tr>");
      }

      out.println("</table>");
      out.println("<p><input TYPE='submit' VALUE='Submit'>");
      out.println("</FORM>");
  }

}



