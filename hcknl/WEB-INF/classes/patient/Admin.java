// (C) OntoOO Inc 2002 Jul
package patient;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.DV;
import com.D;
import com.L;
import misc.DB;
import misc.SessionExpired;

public class Admin extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException

    {
	HttpSession session = req.getSession(false);
	if ( null == session ) { 
	    SessionExpired.call(res,
				DV.Admin);
	    return;
	}
	DB props = (DB) session.getValue("theDB");

        res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<HTML>");
	out.println("<HEAD><TITLE>" + L.AdminStuff + "</TITLE></HEAD>");
	out.println(
"<script LANGUAGE='JavaScript'> \n" +

"function trim(inString) { \n" +
"  var lng = inString.length;  \n" +
"  if (0 == lng) return inString; \n" +
"  if (\" \" == inString.charAt(0) ) \n" +
"     return trim(inString.substring(1,lng)); \n" +
"  lng--; \n" +
"  if (\" \" == inString.charAt(lng) ) \n" +
"     return trim(inString.substring(0,lng)); \n" +
"  return inString; \n" +
"} \n" +

"function isDigit(aChar) { \n" +
"   var refString=\"1234567890\"; \n" +
"   return refString.indexOf(aChar); \n" +
"} \n" +

"function isLowercase(aChar) { \n" +
"   var refString=\"abcdefghijklmnopqrstuvwxyz\"; \n" +
"   return refString.indexOf(aChar); \n" +
"} \n" +

"function isUppercase(aChar) { \n" +
"   var refString=\"ABCDEFGHIJKLMNOPQRSTUVWXYZ\"; \n" +
"   return refString.indexOf(aChar); \n" +
"} \n" +

"function isLetter(aChar) { \n" +
"   var out = isLowercase(aChar); \n" +
"   if ( 0 <= out ) return out; \n" +
"   return isUppercase(aChar); \n" +
"} \n" +

"function isDigitString (inString) { \n" +
"   if (0==inString.length) return (false); \n" +
"   for (count=0; count<inString.length; count++) { \n" +
"      tempChar = inString.charAt(count); \n" +
"      if (-1 == isDigit(tempChar)) return (false); \n" +
"   } \n" +
"   return (true); \n" +
"} \n" +

"function isLetterOrDigitOrSpaceString(inString) { \n" +
"   if (0==inString.length) return (false); \n" +
"   for (count=0; count<inString.length; count++) { \n" +
"      tempChar = inString.charAt(count); \n" +
"      if (-1 == isLetter(tempChar) && \n" +
"          -1 == isDigit(tempChar) && \" \" != tempChar) return (false); \n" +
"   } \n" +
"   return (true); \n" +
"} \n" +

"function isLetterOrSpaceString(inString) { \n" +
"   if (0==inString.length) return (false); \n" +
"   for (count=0; count<inString.length; count++) { \n" +
"      tempChar = inString.charAt(count); \n" +
"      if (-1 == isLetter(tempChar) && \" \" != tempChar) return (false); \n" +
"   } \n" +
"   return (true); \n" +
"} \n" +

"function isPhoneString(inString) { \n" +
"   if (false == isDigitString(inString.substring(0, 3))) return (false); \n" +
"   if ( \" \" != inString.charAt(3) ) return (false); \n" +
"   if (false == isDigitString(inString.substring(4, 7))) return (false); \n" +
"   if ( \" \" != inString.charAt(7) ) return (false); \n" +
"   if (false == isDigitString(inString.substring(8, 12))) return (false); \n" +
"   return (true); \n" +
"} \n" +

"function isSSString(inString) { \n" +
"   if (false == isDigitString(inString.substring(0, 3))) return (false); \n" +
"   if ( \"-\" != inString.charAt(3) ) return (false); \n" +
"   if (false == isDigitString(inString.substring(4, 6))) return (false); \n" +
"   if ( \"-\" != inString.charAt(6) ) return (false); \n" +
"   if (false == isDigitString(inString.substring(7, 11))) return (false); \n" +
"   return (true); \n" +
"} \n" +

"function checkFields(form) { \n" +
"  val2 = form.streetAddress.value; \n" +
"  val3 = trim(val2); \n" +
"  if ( val2 != val3 ) { val2 = val3; form.streetAddress.value = val2; } \n" +
"  out = isLetterOrDigitOrSpaceString(val2); \n" +
"  if ( 1 != out ) { alert(\"Enter or fix street address ...\"); return; }; \n" +
"  val2 = form.city.value; \n" +
"  val3 = trim(val2); \n" +
"  if ( val2 != val3 ) { val2 = val3; form.city.value = val2; } \n" +
"  out = isLetterOrSpaceString(val2); \n" +
"  if ( 1 != out ) { alert(\"Enter or fix city ...\"); return; }; \n" +
"  val2 = form.zipCode.value; \n" +
"  if (5 != val2.length) { alert(\"Enter or fix zipcode ...\"); return; }; \n" +
"  out = isDigitString(val2); \n" +
"  if ( 1 != out ) { alert(\"Enter or fix zipcode ...\"); return; }; \n" +
"  val2 = form.homePhone.value; \n" +
"  if (12 != val2.length) { alert(\"Enter or fix home phone ...\"); return; }; \n" +
"  out = isPhoneString(val2); \n" +
"  if ( 1 != out ) { alert(\"Enter or fix home phone ...\"); return; }; \n" +
"  val2 = form.ssNumber.value; \n" +
"  if (11 != val2.length) { alert(\"Enter or fix SS # ...\"); return; }; \n" +
"  out = isSSString(val2); \n" +
"  if ( 1 != out ) { alert(\"Enter or fix SS# ...\"); return; }; \n" +
"  form.submit(); \n" +
"} \n" +
"</script>"
        );
	out.println("<BODY  BGCOLOR='khaki'>");

	out.println("<H1 align=center><FONT Color='#FF0000' SIZE=4>" +
		    L.AdminStuff + "</FONT></H1>");

	out.println("<B>" + L.MakeCorrectionsAsNecessary + "</B><p>");
	out.println(
	    "<FORM METHOD=post " + 
	    "ACTION='" + D.servletAdminUpdate + "'>");

	out.println("<TABLE>");
	
	out.println("<TR><TD>" + L.Name + "</TD>");
	out.println("<TD>" + props.getProperty("userName") + "</TD></TR>");

	out.println("<TR><TD>" + L.Gender + "</TD>");
	out.println("<TD>" + props.getProperty("gender") + "</TD></TR>");

	out.println("<TR><TD>" + L.DateOfBirth + "</TD>");
	out.println("<TD>" + props.getProperty("dob") + "</TD></TR>");

	out.println("<TR><TD>" + L.StreetAddress + "</TD>"); 
	out.println(
	    "<TD><INPUT TYPE=TEXTAREA SIZE=40 " +
                  "NAME=streetAddress " + 
	          "VALUE='" + props.getProperty("streetAddress") + "'></TD></TR>");

	out.println("<TR><TD>" + L.City + "</TD>"); 
	out.println(
	    "<TD><INPUT TYPE=TEXTAREA SIZE=40 " +
                  "NAME=city " + 
	          "VALUE='" + props.getProperty("city") + "'></TD></TR>");

	out.println("<TR><TD>" + L.ZipCode + "</TD>"); 
	out.println(
	    "<TD><INPUT TYPE=TEXTAREA SIZE=5 " +
                  "NAME=zipCode " + 
	          "VALUE='" + props.getProperty("zipCode") + "'></TD></TR>");

	out.println("<TR><TD>" + L.HomePhone + "</TD>"); 
	out.println(
	    "<TD><INPUT TYPE=TEXTAREA SIZE=12 " +
                  "NAME=homePhone " + 
	          "VALUE='" + props.getProperty("homePhone") + "'></TD></TR>");

	out.println("<TR><TD>" + L.SS + "</TD>");
	out.println(
            "<TD><INPUT TYPE=TEXTAREA SIZE=11 " +
                  "NAME=ssNumber " +
	          "VALUE='" + props.getProperty("ssNumber") + "'> </TD></TR>");

	out.println("</TABLE><hr>");

	out.println(
	    L.PleaseCheckAllFieldsBeforeSubmitting + " " +
	    "<input TYPE='button' VALUE='Submit' onClick='checkFields(this.form)'>");
	out.println("</FORM>");

	out.println(DV.SCRIPTCC);

	out.println("</BODY>");
	out.println("</HTML>");
    }
}





