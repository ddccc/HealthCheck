// (C) OntoOO Inc 2006 May
package patient;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.DV;
import com.D;
import com.L;
import com.DVM;
import misc.SessionExpired;
import com.Common;
import concepts.Symptom;
import concepts.Location;

public class Diag2B extends HttpServlet {

  private static final boolean expert = DV.expert;
  private static final boolean TRACING = DV.TRACINGdiag2;
    //private static final boolean TRACING = true;
    // private static final String FORMDIAG2 = 
    //      "<form name=\"symptomsForm\" action=\"" + D.servletDiag1a + "\">";

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
       throws ServletException, IOException {

      HttpSession session = req.getSession(false);
      if ( null == session ) {	
	  SessionExpired.call(res,
			      DV.Diag2);
	  return;
      }

      String iter = req.getParameter("iteration");
      int iteration = 0;
      try { iteration = Integer.parseInt(iter); } 
      catch(NumberFormatException ignore) {}  
      Vector ts = (Vector) session.getValue("ts");

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html><head><title>" + L.HealthScreen + "</title>" +
		    D.linkHckStyle +
		    D.favicon +
		    "</head>" +
		    "<body>" +
		    "<font color=\"#850a0a\">");

      out.println(DVM.htmlLogoutUser(L.HealthScreen + " " +
				     L.Iteration + " " + iteration));
      call(out, session, iteration, ts);
    } // end doGet

// popup for ShowInputs
static public String showInputsScript =
"<script language=\"JavaScript\">" +
"function showInputs(iteration) { \n" +
"  showInputsWindow = open( \n" +
"    \"" + D.servletShowInputs + "?iteration=\"+iteration, \n" +
"    \"showInputsWindowName\", \n" +
"    \"toolbar=yes,resizable=yes,scrollbars=yes,height=600,width=900\" \n" +
"  ); \n" +
"} \n" +
"</script>";
    
    static public void call(ServletOutputStream out, HttpSession session, 
			    int iteration, Vector ts) 
       throws IOException {

	/*
	String quickyStr = (String) session.getValue("quicky");
	boolean quicky = ( null != quickyStr );
	*/

      out.println(showInputsScript);

      // popup for show symptom
      out.println(Diag1b.popupDisplaySymptom);

      // /* Moved to the bottom of the page
      out.println("<p><a href=\"#showInputs\" name=\"showInputs\" onClick=\"showInputs('" +
		  iteration + 
		  "')\"> <font size=\"4\"><i>" +
		  // "Pop Up My Previous Choices" +
		  L.Diag2S1 +
		  "</i></font></a><p>");
      // */
      if ( 6 < iteration ) {
	  out.println(// "<i>You have reached a high iteration level.<br>" +
		      "<i>" + L.Diag2S11 + "<br>" +
		      // "A plausible condition is usually already identified at a lower level.<br> " +
		      L.Diag2S12 + "<br>" +
		      // "Consider trying another search.</i>");
		      L.Diag2S13 + "</i>");
      }

      generateTestSymptoms(out, ts, session);

      out.println("<p> ");
      out.println("<font size=\"4\">" +
		    // "Please check your data before submitting!" +
		    L.Diag1bS13 +
		    "</font> ");
      out.println("<input type=\"submit\" value=\"Submit\" /> ");
      /* Prevent 500-errors
      out.println("<input type=\"button\" value=\"Cancel\" " +
		  "onClick=\"location='" + D.AngelRootHtml + "'\" /> ");
      */
      StringBuffer sb = new StringBuffer();
      int lng = ts.size();
      for (int i = 0; i < lng; i++) {
	  String token = (String) ts.elementAt(i);
	  sb.append(token + ",");
      }
      // strip last ,
      sb.setLength(sb.length() - 1);
      
      String allTestSymptoms = sb.toString();
      out.println("<input type=\"hidden\" name= \"newAllSymptoms\" " +
		  "value=\"" + allTestSymptoms + "\" /> ");
      /*	  
	} else {
	  out.println("<input type=\"hidden\" name= \"newInSymptoms\" value=\"\" />" +
		      "<input type=\"hidden\" name= \"newAllSymptoms\" value=\"\" /> ");
	}
      */
      out.println("<input type=\"hidden\" name=\"iteration\" " +
		  "value=\"" + iteration + "\">");
      out.println("<input type=\"hidden\" name=\"enteringFrom\" value=\"Diag2\" />");

      out.println("</form>");

      /*  moved to the top of the page
      out.println("<p><a href=\"#showInputs\" name=\"showInputs\" onClick=\"showInputs('" +
		  iteration + 
		  "')\"> <font size=\"4\"><i>" +
		  // "Pop Up My Previous Choices" +
		  L.Diag2S1 +
		  "</i></font></a><p>");
      */

      /* Prevent 500-errors
      out.println("<form name=\"returnForm\">");
      if ( !quicky )
	  out.println("<input type=\"button\" value=\"" + L.BackToRoot + "\" " +
		      "onClick=\"location='" + D.AngelRootHtml + "'\" />");
      out.println(
	 "<input type=\"button\" value=\"" + L.AnotherSearch + "\" " +
	         "onClick=\"location='" + D.servletDiagStart + "'\" /> \n" +
	 "</form>");
      */


      out.println(DV.htmlBack);
      out.println(DV.SCRIPTCC);

      out.println("</font></body>");
      out.println("</html>");

    } // end call


  static private void generateTestSymptoms(ServletOutputStream out, 
				    Vector testSymptoms,
				    HttpSession session) throws IOException {

    out.println("<h1 align=\"center\"><font color=\"#1C5540\" size=\"5\">" +
		// "Please decide more symptoms:" +
		L.Diag2S2 +
		"</font></h1>");
    // out.println(FORMDIAG2);
    out.println("<form name=\"symptomsForm\" action=\"" + D.servletDiag1a + "\">");
    out.println("<b>" +
		// "Check all that apply - if any:" +
		L.Diag1bS9 +
		"</b>");

    Hashtable ht = new Hashtable();
    int lng = testSymptoms.size();
    String symptomName;
    Symptom sym;
    String locationSt;
    Vector vec;
    for (int i = 0; i < lng; i++) {
      symptomName = (String) testSymptoms.elementAt(i);
      sym = Common.getSymptom(symptomName);
      locationSt = sym.getLocationSt();
      vec = (Vector) ht.get(locationSt);
      if ( null == vec ) {
	vec = new Vector();
	ht.put(locationSt, vec);
      }
      vec.addElement(symptomName);
    }
    lng = ht.size();
    String [] theLocations = new String[lng];
    Enumeration enumz = ht.keys();
    for (int i = 0; i < lng; i++) theLocations[i] = (String) enumz.nextElement();
    java.text.Collator col = java.text.Collator.getInstance();
    Arrays.sort(theLocations, col);
    int lng2;
    String [] theLocations2;

    StringBuffer sb = new StringBuffer("<center><table border=\"1\">\n");
    String description;
    String printName;
    int anchor = 1000;
    for (int i = 0; i < lng; i++) {
      locationSt = theLocations[i];
      Location loc = Common.getLocation(locationSt);
      String pn = loc.getPrintName();
      sb.append("<tr><td><b>" + pn + "</b></td><td>\n");
      vec = (Vector) ht.get(locationSt);
      lng2 = vec.size();
      theLocations2 = new String[lng2];
      for (int j = 0; j < lng2; j++) theLocations2[j] = (String) vec.elementAt(j);
      Arrays.sort(theLocations2, col);
      for (int j = 0; j < lng2; j++) {
	symptomName = theLocations2[j];
	sym = Common.getSymptom(symptomName);
	printName = sym.getPrintName();
	// description = sym.getDescription();
	anchor++;
	sb.append("<input type=\"checkbox\" name=\"newInSymptoms\" value=\"" +
		  symptomName + "\">\n" + 
		  "<a href=\"#" + anchor + "\" name=\"" + anchor +
		  "\" onClick=\"displaySymptom('" + symptomName + "')\">" + 
		  "<i>" + printName + "</i></a>\n");
      }
      sb.append("</td></tr>");
    }
    sb.append("</table></center>");
    out.println(sb.toString());

  } // end generateTestSymptoms(...)

} // end Diag2B
