// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.XWord;
import concepts.XWordNormal;

public class EditXWords2 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String [] allXWords = Common.allXWords();
      int lng = allXWords.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>All XWords</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H1>Select XWord, # = " + lng + "</H1>");
      String dis, type;
      XWord xWord;
      /*
      out.println(
	     "<br>" +
	     "<A HREF='/servlet/EditXWord?sym=" + "newXWord" + "'>" +
	     "new xWord" + "</A><p>");
	     */
      out.println("<table Border>");
      Vector refs;
      int lng2;
      String aRef;
      int cnt = 0;
      int max = 0;
      int freq[]= {0,0,0,0,0,0,0,0,0,0};
      for (int i = 0; i < lng; i++) {
	dis = allXWords[i];
	xWord = Common.getXWord(dis);
	type = xWord.getType();
	if ( !type.equals("unknown") ) continue;
	if ( !(xWord instanceof XWordNormal) ) continue;
	XWordNormal xw = (XWordNormal) xWord;
	refs = xw.getReferences();
	lng2 = refs.size();
	if ( 10 < lng2 ) continue;
	freq[lng2-1]++;
	if ( max < lng2 ) max = lng2;
	cnt++;
	out.println(
	     "<tr><td><A HREF='" + D.servletShowXWord + "?xw=" + 
	              dis + "'>" + dis + "</A></td><td>" + lng2 + "</td><td>");
	for (int j = 0; j<lng2; j++) {
	  aRef = (String) refs.elementAt(j);
	  out.println("<A HREF='" + D.servletShowXWord + "?xw=" + 
		      aRef + "'>" + aRef + "</A> ");
	}
	out.println("</td></tr>");
      }
      out.println("</table>");
      out.println("cnt = " + cnt + " max = " + max);
      for (int i = 0; i < 10; i++) {
	out.println("<br>i = " + (i+1) + " freq[i] = " + freq[i]);
      }
      
      out.println("</BODY>");
      out.println("</HTML>");
    }
}



