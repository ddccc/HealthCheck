// Copyright OntoOO Inc, 2002
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.DV;
import com.D;
import concepts.Symptom;
import concepts.Disease;


public class ShowSympStats2 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      HttpSession session = req.getSession(false);
      String [] allSymptoms = (String []) session.getValue("allSymptoms");

      int freqLength = 100;
      Vector [] freq = new Vector[freqLength];
      session.putValue("freq", freq);
      for (int i = 0; i < freqLength; i++) freq[i] = new Vector();


      int lng = allSymptoms.length;
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Symptom Stats</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H1>Symptom Stats, # = " + lng + "</H1>");
      String dis, printName;
      Symptom symptom;
      Vector theDiseases;
      int lng2;

      out.println("<table Border>");
      out.println("<tr><td><b>Symptom</b></td><td><b># diseases</b></td></tr>");
      Vector veci;
      int uniqueCnt = 0;
      for (int i = 0; i < allSymptoms.length; i++) {
	dis = allSymptoms[i];
	symptom = Common.getSymptom(dis);
	printName = symptom.getPrintName();
	theDiseases = symptom.getTheDiseases();
	lng2 = theDiseases.size();
	boolean unique = false;
	if ( 1 == lng2 ) {
	    String dis2 = (String) theDiseases.elementAt(0);
	    Disease disease = Common.getDisease(dis2);
	    Vector syms = disease.getSymptoms();
	    if ( 1 == syms.size() ) { 
		unique = true;
		uniqueCnt++;
	    }
	}

	if ( freqLength <= lng2 ) lng2 = freqLength - 1;
	veci = (Vector) freq[lng2];
	veci.addElement(dis);
	out.println(
	     "<tr><td>" + 
	     ( dis.equals(printName) ? dis : dis + "/ " + printName ) +
	     " </td><td> " + lng2 + "</td><td>" +
	     "<A HREF='" + D.servletShowSymptom + "?sym=" + dis + "'> show </A></td><td>" +
	     (unique ? "UNIQUE" : "-") + 
	     "</td></tr>");
      }
      out.println("</table>");
      out.println("# diseases having only ONE symptom that occurs in only ONE disease: " + uniqueCnt);

      out.println("<p><table Border>");
      int freqi;
      for (int i = 0; i < freqLength; i++) {
	veci = (Vector) freq[i];
	freqi = veci.size();
	if ( 0 < freqi )
	  out.println(
	     "<tr><td>" + 
	     "<A HREF='" + D.servletShowSympBucket + "?i=" + i + "'> " + i + " </A>" +
	     "</td><td>" + freqi + 
	     "</td><td><img src='" + D.dot3Gif + "' height=8 width=" + (4*freqi) +
	     "></td></tr>"); 
      }
      out.println("</table>");


      out.println("<p><table Border>");
      out.println("<tr><td>bucket</td><td>size</td></tr>"); 

      int maxIndex = freqLength - 1;
      while ( 0 <= maxIndex ) {
	veci = (Vector) freq[maxIndex];
	freqi = veci.size();
	if ( 0 < freqi ) break;
	maxIndex--;
      }
      int minIndex = 15;
      if ( maxIndex < minIndex ) minIndex = 2;
      
      int numOfSym = 0;
      int buckCnt = 0;
      Hashtable ht = new Hashtable();
      for (int i = minIndex; i <= maxIndex; i++) {
	veci = (Vector) freq[i];
	freqi = veci.size();
	if ( 0 < freqi ) {
	  numOfSym += freqi;
          buckCnt += i*freqi;
	  out.println("<tr><td>" + i + "</td><td>" + freqi + "</td><td>"); 
	  for ( int j = 0; j < freqi; j++) { 
	    dis = (String) veci.elementAt(j);
	    symptom = Common.getSymptom(dis);
	    printName = symptom.getPrintName();
	    out.println(
	     " <A HREF='" + D.servletShowSymptom + "?sym=" + dis + "'>" +
	     printName + "</A>");
	    theDiseases = symptom.getTheDiseases();
	    lng2 = theDiseases.size();
	    for (int k = 0; k<lng2; k++) {
	      dis = (String) theDiseases.elementAt(k);
	      if ( !ht.containsKey(dis) ) ht.put(dis, dis);
	    }
	  }
	  out.println("</td></tr>");
	}
      }

      out.println("</table>");
      out.println("<p># symptoms: " + numOfSym + 
		  " # diseases covered: " + ht.size() +
		  " # sum (bucket * size): " + buckCnt );


      out.println(DV.htmlDismissOrBack);

      out.println("</BODY>");
      out.println("</HTML>");


    }
}



