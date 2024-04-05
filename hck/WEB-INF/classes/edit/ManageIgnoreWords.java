// Copyright OntoOO Inc, 2007 March
package edit;
import com.D;
import com.IO;
import com.Common;
import concepts.XWord;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


/*
import com.InitAll;
import concepts.Symptom;
import concepts.XWordNormal;
*/
public class ManageIgnoreWords extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      
      Hashtable ignoreWords = getHashtable(D.ignoreWords);
      Hashtable indexWords = getHashtable(D.indexWords);

 
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>ManageIgnoreWords</title></head>");
      out.println("<body BGCOLOR=\"lightgreen\">");
      out.println("<h1>ManageIgnoreWords</h1>");
      out.println("<br># of ignoreWords: " + ignoreWords.size());
      out.println("<form action=\"" + D.servletManageIgnoreWords2 + "\">");
      out.println("<table border=\"1\">");
      out.println("<tr><td><b>ignore entry</b></td><td>" + 
		  "<b>found in description of</b></td><td>" + 
		  "<b>dictionary?</b></td><td>" + 
		  "<b>in index set?</b>" +
		  "</td></tr>");

      int lng = ignoreWords.size();
      String keys[] = new String[lng];
      int i = 0;
      Enumeration enumz = ignoreWords.keys();
      while ( enumz.hasMoreElements() ) {
	  keys[i++] = (String) enumz.nextElement();
      }
      Arrays.sort(keys);
      for (int j = 0; j < lng; j++) {
	  String key = keys[j];
	  XWord xw = Common.getXWord(key);
	  String xwString = ( null == xw ? "*** not XWord" : xw.getName() );
	  String outWord = (String) indexWords.get(key);
	  out.println("<tr><td>" + key + "</td><td>" + 
		      (String) ignoreWords.get(key) + "</td><td>" + 
		      ( null == xw ? xwString :
		        "<A HREF='" + D.servletShowXWord  + "?xw=" + xwString + "'>" + xwString + "</A>" ) +
		      "</td><td>" + 
		      outWord +
		      "</td></tr>");
      }
      out.println("</table>");
      out.println("</form>");
      /*
      HttpSession session = req.getSession(true);
      session.setMaxInactiveInterval(D.maxEditInactiveInterval);
      session.putValue("wordsFound", wordsFound);

      makeTable(out, wordsFound);
      */
      out.println("</body>");
      out.println("</html>");
    }

  static public Hashtable getHashtable(String htName) {
    return IO.readOrCreateHT(htName);
  }
    /*
  static public boolean saveHashtable(String htName, Hashtable ht) {
    return IO.saveHT(htName, ht);
  }
  

  static public String stripToken(String token) {
      return InitAll.stripToken(token);
  }
    */

    /*
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
    */
    /*
  static public void makeTable(ServletOutputStream out, Hashtable wordsFound) 
	throws ServletException, IOException   {
      // display table of wordsFound and decide whether or not to index on them
      Enumeration keys = wordsFound.keys();
      out.println("<form METHOD=post action='" + D.servletARW + "'>");
      out.println("<table border=\"1\">");
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
      out.println("</form>");
  }
    */

}



