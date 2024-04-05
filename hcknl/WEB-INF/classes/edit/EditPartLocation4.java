// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.PartLocation;
import concepts.LocationRelation;
import com.LR;



public class EditPartLocation4 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      HttpSession session = req.getSession(true);
      String name = (String) session.getValue("name");
      String code = (String) session.getValue("code");
      PartLocation newPL = (PartLocation) session.getValue("newPL");
      boolean doModifyIncore = (null != newPL);

      String addAdjacents = (String) session.getValue("addAdjacents"); // loc2
      String addAlsoPartOfs = (String) session.getValue("addAlsoPartOfs"); // loc1

      String positionP = req.getParameter("positionP");

      String leftRightA = req.getParameter("leftRightA");
      String leftRightP = req.getParameter("leftRightP");
      String topBottomA = req.getParameter("topBottomA");
      String topBottomP = req.getParameter("topBottomP");
      String backFrontA = req.getParameter("backFrontA");
      String backFrontP = req.getParameter("backFrontP");


      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Edit PartLocation4</TITLE></HEAD>");

      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H3>Add adjacent and/or alsoPartOf:</H3>");

      out.println("<br><b>Name:</b> " + name);
      /*
      out.println("<br><b>1st code:</b>");
      out.println(code);
      out.println("<br><b>addAdjacents:</b> " + addAdjacents);
      out.println("<br><b>leftRightA:</b> " + leftRightA);
      out.println("<br><b>topBottomA:</b> " + topBottomA);
      out.println("<br><b>backFrontA:</b> " + backFrontA);

      out.println("<br><b>addAlsoPartOfs:</b> " + addAlsoPartOfs);
      out.println("<br><b>positionP:</b> " + positionP);
      out.println("<br><b>leftRightP:</b> " + leftRightP);
      out.println("<br><b>topBottomP:</b> " + topBottomP);
      out.println("<br><b>backFrontP:</b> " + backFrontP);
      */
      String capitalizedName = capitalize(name);
      LocationRelation lrNew;
      if ( null != addAdjacents ) {
	StringBuffer sb = new StringBuffer(code);
	StringTokenizer st = new StringTokenizer(addAdjacents, ","); 
	StringTokenizer lr = new StringTokenizer(leftRightA, ","); 
	StringTokenizer tb = new StringTokenizer(topBottomA, ",");
 	StringTokenizer bf = new StringTokenizer(backFrontA, ",");
	String stI, lrI, tbI, bfI, locRel;
	while ( st.hasMoreTokens() ) {
	  stI = st.nextToken();
	  lrI = lr.nextToken();
	  tbI = tb.nextToken();
	  bfI = bf.nextToken();
	  locRel = "lr" + capitalizedName + capitalize(stI);
	  sb.append("<br>LocationRelation " + locRel + " =");
	  sb.append("<br>   new LocationRelation(LR." + name + "St, LR." +
		    stI + "St, LR.adjacent, LR." +
		    lrI + ", LR." + 
		    tbI + ", LR." +
		    bfI + ");");
	  sb.append("<br>" + name + ".addAdjacent(" + locRel + ");");
	  if ( doModifyIncore ) {
	    lrNew = new LocationRelation(
		       name, stI, LR.adjacent, lrI, tbI, bfI);
	    newPL.addAdjacent(lrNew);
	  }
	}
	code = sb.toString();
      }

      if ( null != addAlsoPartOfs ) {
	StringBuffer sb = new StringBuffer(code);
	StringTokenizer st = new StringTokenizer(addAlsoPartOfs, ","); 
	StringTokenizer ps = new StringTokenizer(positionP, ","); 
	StringTokenizer lr = new StringTokenizer(leftRightP, ","); 
	StringTokenizer tb = new StringTokenizer(topBottomP, ",");
 	StringTokenizer bf = new StringTokenizer(backFrontP, ",");
	String psI, stI, lrI, tbI, bfI, locRel;
	while ( st.hasMoreTokens() ) {
	  psI = ps.nextToken();
	  stI = st.nextToken();
	  lrI = lr.nextToken();
	  tbI = tb.nextToken();
	  bfI = bf.nextToken();
	  locRel = "lr" + capitalizedName + capitalize(stI);
	  sb.append("<br>LocationRelation " + locRel + " =");
	  sb.append("<br>   new LocationRelation(LR." + stI + "St, LR." +
		    name + "St, LR." +
		    psI + ", LR." +
		    lrI + ", LR." + 
		    tbI + ", LR." +
		    bfI + ");");
	  sb.append("<br>" + name + ".addAlsoPartOf(" + locRel + ");");
	  if ( doModifyIncore ) {
	    lrNew = new LocationRelation(
		       stI, name, psI, lrI, tbI, bfI);
	    newPL.addAlsoPartOf(lrNew);
	  }
	}
	code = sb.toString();
      }

      out.println("<br><b>2nd code:</b>");
      out.println(code);

      if ( null != newPL ) {
	out.println("<table border>");
	out.println(newPL.html());
	out.println("</table>");
	Common.saveTheLocations();
      }

      Vector codeLines = EditPartLocation2.makeCodeLines(name, code);
      String directory = D.theNewPartLocationsDir;
      EditPartLocation2.writeCode(name, directory, codeLines, out);

      out.println("</BODY>");
      out.println("</HTML>");
    }

  private String capitalize(String in) { 
    if ( (null == in) || (in.length() <= 0) ) return in;
    return (Character.toUpperCase(in.charAt(0))) + in.substring(1);
  }

}



