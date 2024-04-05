// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.D;

public class EditPartLocation3 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      HttpSession session = req.getSession(true);
      String name = (String) session.getValue("name");
      String code = (String) session.getValue("code");
      String addAdjacents = (String) session.getValue("addAdjacents");
      String addAlsoPartOfs = (String) session.getValue("addAlsoPartOfs");

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Edit PartLocation3</TITLE></HEAD>");

      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H3>Add adjacent and/or alsoPartOf:</H3>");

      out.println("<br><b>Name:</b> " + name);
      out.println("<br><b>code</b>");
      out.println(code);


      out.println("<FORM NAME=editPartLocation3 " +
		  "ACTION='" + D.servletEditPartLocation4 + "'>");

      if ( null != addAdjacents) {
	StringTokenizer st = new StringTokenizer(addAdjacents, ",");
	String locationName2;
	while ( st.hasMoreTokens() ) {
	  out.println("<table BORDER>");
	  locationName2 = st.nextToken();
	  out.println("<tr><td><b>The new adjacent:</b></td><td>");
	  out.println(locationName2 + "</td></tr>");
	  /*
	  out.println("<tr><td><b>Select the position:</b></td><td>");
	  out.println("<SELECT name=positionA>");
	  out.println("<OPTION VALUE='inside'" + 
		      ">inside"); 
	  out.println("<OPTION VALUE='surface'" + 
		      ">surface"); 
	  out.println("</SELECT>");
	  out.println("</td></tr>");
	  */
	  out.println("<tr><td><b>Select leftRight:</b></td><td>");
	  out.println("<SELECT name=leftRightA>");
	  out.println("<OPTION VALUE='left'" + 
		      ">left"); 
	  out.println("<OPTION VALUE='right'" + 
		      ">right"); 
	  out.println("<OPTION VALUE='middle'" + 
		      ">middle"); 
	  out.println("<OPTION VALUE='leftToRight'" + 
		      ">lefToRight"); 
	  out.println("<OPTION VALUE='leftToMiddle'" + 
		      ">leftToMiddle"); 
	  out.println("<OPTION VALUE='rightToMiddle'" + 
		      ">rightToMiddle");
	  out.println("<OPTION VALUE='na'" + 
		      ">na"); 
	  out.println("</SELECT>");
	  out.println("</td></tr>");

	  out.println("<tr><td><b>Select topBottom:</b></td><td>");
	  out.println("<SELECT name=topBottomA>");
	  out.println("<OPTION VALUE='top'" + 
		      ">top"); 
	  out.println("<OPTION VALUE='bottom'" + 
		      ">bottom"); 
	  out.println("<OPTION VALUE='middle'" + 
		      ">middle");
	  out.println("<OPTION VALUE='topToBottom'" + 
		      ">topToBottom"); 
	  out.println("<OPTION VALUE='topToMiddle'" + 
		      ">topToMiddle");
	  out.println("<OPTION VALUE='bottomToMiddle'" + 
		      ">bottomToMiddle");
	  out.println("<OPTION VALUE='na'" + 
		      ">na"); 
	  out.println("</SELECT>");
	  out.println("</td></tr>");

	  out.println("<tr><td><b>Select backFront:</b></td><td>");
	  out.println("<SELECT name=backFrontA>");
	  out.println("<OPTION VALUE='front'" + 
		      ">front"); 
	  out.println("<OPTION VALUE='back'" + 
		      ">back"); 
	  out.println("<OPTION VALUE='middle'" + 
		      ">middle");
	  out.println("<OPTION VALUE='backToFront'" + 
		      ">backToFront"); 
	  out.println("<OPTION VALUE='frontToMiddle'" + 
		      ">frontToMiddle");
	  out.println("<OPTION VALUE='backToMiddle'" + 
		      ">backToMiddle"); 
	  out.println("<OPTION VALUE='na'" + 
		      ">na"); 
	  out.println("</SELECT>");
	  out.println("</td></tr>");
	  out.println("</table>");
	}
      }

      if ( null != addAlsoPartOfs) {
	StringTokenizer st = new StringTokenizer(addAlsoPartOfs, ",");
	String locationName2;
	while ( st.hasMoreTokens() ) {
	  out.println("<table BORDER>");
	  locationName2 = st.nextToken();
	  out.println("<tr><td><b>The new alsoPartOf:</b></td><td>");
	  out.println(locationName2 + "</td></tr>");
	  out.println("<tr><td><b>Select the position:</b></td><td>");
	  out.println("<SELECT name=positionP>");
	  out.println("<OPTION VALUE='inside'" + 
		      ">inside"); 
	  out.println("<OPTION VALUE='surface'" + 
		      ">surface"); 
	  out.println("</SELECT>");
	  out.println("</td></tr>");
	  
	  out.println("<tr><td><b>Select leftRight:</b></td><td>");
	  out.println("<SELECT name=leftRightP>");
	  out.println("<OPTION VALUE='left'" + 
		      ">left"); 
	  out.println("<OPTION VALUE='right'" + 
		      ">right"); 
	  out.println("<OPTION VALUE='middle'" + 
		      ">middle"); 
	  out.println("<OPTION VALUE='leftToRight'" + 
		      ">lefToRight"); 
	  out.println("<OPTION VALUE='leftToMiddle'" + 
		      ">leftToMiddle"); 
	  out.println("<OPTION VALUE='rightToMiddle'" + 
		      ">rightToMiddle");
	  out.println("<OPTION VALUE='na'" + 
		      ">na"); 
	  out.println("</SELECT>");
	  out.println("</td></tr>");

	  out.println("<tr><td><b>Select topBottom:</b></td><td>");
	  out.println("<SELECT name=topBottomP>");
	  out.println("<OPTION VALUE='top'" + 
		      ">top"); 
	  out.println("<OPTION VALUE='bottom'" + 
		      ">bottom"); 
	  out.println("<OPTION VALUE='middle'" + 
		      ">middle");
	  out.println("<OPTION VALUE='topToBottom'" + 
		      ">topToBottom"); 
	  out.println("<OPTION VALUE='topToMiddle'" + 
		      ">topToMiddle");
	  out.println("<OPTION VALUE='bottomToMiddle'" + 
		      ">bottomToMiddle");
	  out.println("<OPTION VALUE='na'" + 
		      ">na"); 
	  out.println("</SELECT>");
	  out.println("</td></tr>");

	  out.println("<tr><td><b>Select backFront:</b></td><td>");
	  out.println("<SELECT name=backFrontP>");
	  out.println("<OPTION VALUE='front'" + 
		      ">front"); 
	  out.println("<OPTION VALUE='back'" + 
		  ">back"); 
	  out.println("<OPTION VALUE='middle'" + 
		      ">middle");
	  out.println("<OPTION VALUE='backToFront'" + 
		      ">backToFront"); 
	  out.println("<OPTION VALUE='frontToMiddle'" + 
		      ">frontToMiddle");
	  out.println("<OPTION VALUE='backToMiddle'" + 
		      ">backToMiddle"); 
	  out.println("<OPTION VALUE='na'" + 
		      ">na"); 
	  out.println("</SELECT>");
	  out.println("</td></tr>");
	  out.println("</table>");
	}
      }


      // out.println("</table>");
      out.println("<p><input type='submit' value='Submit'>");
      /*
      out.println("<p><input type='button' value='Submit' " +
		  "onClick= \"checkForm(this.form)\">");
      out.println("<input TYPE=\"hidden\" NAME= \"membershipsList\" VALUE=\"\">");
      out.println("<input TYPE=\"hidden\" NAME= \"adjacentsList\" VALUE=\"\">");
      out.println("<input TYPE=\"hidden\" NAME= \"alsoPartOfsList\" VALUE=\"\">");
      */
      out.println("</FORM>");

      out.println("</BODY>");
      out.println("</HTML>");
    }

}



