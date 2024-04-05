// (C) OntoOO Inc 2002
package patient;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.DV;

public class Debug extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {

    HttpSession session = req.getSession();
    String [] valueNames = session.getValueNames();
    Arrays.sort(valueNames);
    int lng = valueNames.length;

    res.setContentType("text/html");
    ServletOutputStream out = res.getOutputStream();
    out.println(
       "<HTML><HEAD><TITLE>Debug</TITLE></HEAD><BODY BGCOLOR=yellow>");
    out.println(DV.scriptShowAccount); // to drill down in an account

    out.println("<table border>");
    String aKey;
    Object value;
    Class theClass;
    String className;
    Vector hashtables = new Vector();
    for (int i=0; i<lng; i++) {
      aKey = (String) valueNames[i];
      value = session.getValue(aKey);
      theClass = value.getClass();
      className = theClass.getName();
      if ( className.equals("java.util.Hashtable") )
	hashtables.addElement(aKey);
      else
	out.println("<tr><td><b>"+aKey+"</b></td><td>" +
		    ( !className.equals("java.util.Hashtable") ? 
		      value.toString() : className ) +
		    "</td></tr>");
    }
    lng = hashtables.size();
    Hashtable ht;
    for (int i=0; i<lng; i++) {
      aKey = (String) hashtables.elementAt(i);
      out.println("<tr><th colspan=2><b>hashtable: " + aKey + "</b></th></tr>");
      ht = (Hashtable) session.getValue(aKey);
      Enumeration emumz = ht.keys();
      while (emumz.hasMoreElements()) {
	aKey = (String) emumz.nextElement();
	value = ht.get(aKey);
	out.println("<tr><td><b>"+aKey+"</b></td><td>"+value.toString()+"</td></tr>");
      }
    }
    out.println("</table>");

    out.println(DV.htmlBack);
    out.println(DV.SCRIPTCC);

    out.println("</BODY></HTML>");
    }
}



