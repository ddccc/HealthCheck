// (C) OntoOO Inc 2000
package patient;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.DV;
import com.D;
import com.L;
import com.DVM;
import misc.DB;
import misc.SessionExpired;

public class ShowWeightGraph extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    SessionExpired.call(res,
				DV.ShowWeightGraph);
	  return;
	}
	call(res, session);
    }

    static public void call(HttpServletResponse res, HttpSession session)
	throws IOException {

	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html><head><title>" +
		    // "Draw Weight Graph" +
		    L.SWGS1 +
		    "</title>" +
		    D.linkHckStyle +
		    D.favicon +
		    "</head>" +
		    "<body>" +
		    "<font color=\"#850a0a\">");

	DB props = (DB) session.getValue("theDB");
	// Construct the applet input here from the weight info in the DB
	String weightStream = props.getStream("weight");
	if ( null == weightStream ) {
	  out.println("<h3>" +
		      // "No weight data available ..." +
		      L.SWGS2 +
		      "</h3>");
	  out.println(DV.htmlBack);

	  // the standard trailer
	  // localhost:8000 === healthcareProvider:80 or so
	  out.println(DV.SCRIPTCC);

	  out.println("</font></body>");
	  out.println("</html>");
	  return;
	}
	String targetWeightSt = props.getProperty("targetWeight");
	// split the dates and the weights from the stream
	StringTokenizer st = new StringTokenizer(weightStream, "|");
	Vector dates = new Vector();
	Vector weights = new Vector();
	int count = 0;
	while (st.hasMoreElements()) {
	  count++;
	  dates.addElement(st.nextElement());
	  weights.addElement(st.nextElement());
	}
	// find min and max for the x and y dimensions
	StringBuffer sb = new StringBuffer('"');
	long minX = Long.MAX_VALUE;
	long maxX = Long.MIN_VALUE;
	int minY = 1000;
	int maxY = 0;
	String elem;
	long g;
	int e;
	for (int i=0; i < count; i++) {
	  elem = (String) dates.elementAt(count - i - 1);
	  sb.append(elem); sb.append(' ');
	  try {
	    g = Long.parseLong(elem);
	  } catch (NumberFormatException ex) { g = ((new Date()).getTime()); }
	  if ( g < minX) minX = g;
	  if ( maxX < g) maxX = g;
	  elem = (String) weights.elementAt(count - i - 1);
	  sb.append(elem); sb.append(' ');
	  try {
	    e = Integer.parseInt(elem);
	  } catch (NumberFormatException ex) { e = 0; }
	  if ( e < minY) minY = e;
	  if ( maxY < e) maxY = e;
	}
	sb.append('"');
	// create the display

	// intro text here
	out.println(DVM.htmlLogoutUser(
				       // "Weight Graph/ Keep it up/down :-)"
				       L.SWGS3  ));
	out.println("<center>");

	// out.println("<br><br>");

	out.println("<applet " + D.appletBase +
		    "code=\"DrawWeightAppl\" width=\"700\" height=\"300\"> ");
	out.println("<param name=\"numberOfPairs\" value=\""+count+"\" />");
	out.println("<param name=\"minX\" value=\""+minX+"\" />");
	out.println("<param name=\"maxX\" value=\""+maxX+"\" />");
	out.println("<param name=\"minY\" value=\""+minY+"\" />");
	out.println("<param name=\"maxY\" value=\""+maxY+"\" />");
	// String seq = "\"-2 -2 -1 -1 0 0 1 1 2 2\"";
	String seq = sb.toString();
	out.println("<param name=\"sequence\" value=\"" + seq + "\" />");
	out.println("<param name=\"xText\" value=\"time\" />");
	out.println("<param name=\"yText\" value=\"weight\" />");
	Date thatDate = new Date(minX);
        String leftBottomX = thatDate.toString().substring(4,10);
	out.println("<param name=\"leftBottomSt\" value=\"" +
		    leftBottomX +
		    "\" />");
	thatDate = new Date(maxX);
        String rightBottomX = thatDate.toString().substring(4,10);
	out.println("<param name=\"rightBottomSt\" value=\"" +
		    rightBottomX +
		    "\" />");
	if (null != targetWeightSt) 
	  out.println("<param name=\"targetWeight\" value=\"" +
		      targetWeightSt + "\" />");
	out.println("</applet>");

	out.println("<br />");
	// Create a proceed button that causes a return to AngelRoot.html
	out.println("</center>");

	out.println(DV.htmlBack);

	// the standard trailer
	// localhost:8000 === healthcareProvider:80 or so
	out.println(DV.SCRIPTCC);

	out.println("</font></body>");
	out.println("</html>");
    }
}







