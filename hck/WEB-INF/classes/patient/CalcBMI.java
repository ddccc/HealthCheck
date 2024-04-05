// (C) OntoOO Inc 2003
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
import misc.HCError;
import misc.SessionExpired;


public class CalcBMI extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {


	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    SessionExpired.call(res,
				DV.CalcBMI);
	    return;
	}
	String myWeight = req.getParameter("myWeight");
	String saveWeight = req.getParameter("saveWeight");
	String myHeight = req.getParameter("myHeight");
	String saveHeight = req.getParameter("saveHeight");

	int weightI = 0;
	try { weightI = Integer.parseInt(myWeight); } catch (NumberFormatException ignore) {}
	int heightI = 0;
	try { heightI = Integer.parseInt(myHeight); } catch (NumberFormatException ignore) {}


	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html><head><title>" + L.YourBodyMassIndex + "</title>" +
		    D.linkHckStyle +
		    D.favicon +
		    "</head>" +
		    "<body>" +
		    "<font color=\"#850a0a\">");

	if ( weightI < 2 || 600 < weightI || heightI < 10 || 230 < heightI ) {
	    // out.println("<h3>Weight and/or height not realistic data ...</h3>");
	    out.println("<h3>" + L.CalcBMIError + "</h3>");
	  out.println(DV.htmlBack);

	  // the standard trailer
	  // localhost:8000 === healthcareProvider:80 or so
	  out.println(DV.SCRIPTCC);

	  out.println("</font></body>");
	  out.println("</html>");
	  return;
	}
	// lb & inch -> bmiCoefficient = 701
	// kg & cm -> bmiCoefficient = 10000
	float bmi = (L.bmiCoefficient * weightI) / ( heightI * heightI );


	if ( null != saveWeight || null != saveHeight ) {
	    DB props = (DB) session.getValue("theDB");
	    try {
		if ( null != saveWeight ) props.extendProperty("weight", myWeight); 
		if ( null != saveHeight ) props.putProperty("height", myHeight);
		props.save("CalcBMI");
	    } catch (IOException ex) {
		HCError.call(res,
			     "Can't store new value, exception: " + ex.getMessage() +
			     "<br />Use the back arrow to return to the previous page(s)",
			     ""); // 3rd arg will force script addition to the page
		return;
	    }
	}
	// intro text here
	out.println(DVM.htmlLogoutUser("Your Body Mass Index"));
	out.println("<h3>" + L.YourBodyMassIndex + "</h3>");

	out.println("<table>");
	out.println("<tr><td>" + L.YourWeight + "</td><td>" + myWeight + "</td></tr>");
	out.println("<tr><td>" + L.YourHeight + "</td><td>" + myHeight + "</td></tr>");
	out.println("<tr><td>" + L.YourBMI + "</td><td>" + bmi + "</td></tr>");
	out.println("</table>");
	/*
	out.println("A BMI in the range of 20-25 is considered OK; " + 
		    "below 20 is under weight and above 25 is over weight.");
	*/
	out.println(L.CalcBMIExplain);

	out.println(DV.htmlBack);

	// the standard trailer
	// localhost:8000 === healthcareProvider:80 or so

	out.println(DV.SCRIPTCC);

	out.println("</font></body>");
	out.println("</html>");
    }
}





