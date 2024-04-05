// (C) OntoOO Inc 2007 Apr
package com;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import concepts.Symptom;

/*
import com.DV;
import com.D;
import com.L;
import com.SymComp;
import misc.DiagStackEntry;
import misc.DB;
import com.Common;
import concepts.Disease;
import concepts.DiseaseSet;
import concepts.LocationRelation;
import concepts.Location;
import concepts.PartOfLocation;
import concepts.BodySystem;
import com.DVM;
import com.LR;
import com.LHE;
import misc.SessionExpired;
*/

public class ZType extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {

	String sym, printName;
	Symptom symptom;

	String [] allSymptoms = Common.allSymptoms();
	int lng = allSymptoms.length;
	Vector symptoms = new Vector();
	for (int i = 0; i < lng; i++ ) {
	    sym = allSymptoms[i];
	    symptom = Common.getSymptom(sym);
	    symptoms.addElement(symptom);
	}
	Collections.sort(symptoms, new SymComp());

String typeDisplay =
"<style type=\"text/css\">  \n" +
"<!-- \n" +
"#typeDisplay { \n" +
"display: none;  \n" +
"padding: 5; \n" +
"font-size: 12px; \n" +
"border: black solid 1px; \n" +
"font-family: verdana;  \n" +
"background-color: #ffd038; \n" +
"color: 000000; \n" +
"width: 250px; \n" +
"text-align: left; \n" +
"} \n" +
"--> \n" +
"</style> \n";

	StringBuffer sb = new StringBuffer();
	sb.append(typeDisplay);
	sb.append("<script language=\"JavaScript\"> \n");
	/*
	sb.append("ops = [");
	int k = 0;
	for (int i = 0; i < lng; i++) {
	  symptom = (Symptom) symptoms.elementAt(i);
	  printName = symptom.getPrintName();
	  sb.append("\"" + printName + "\",");
	  k++;
	  if ( 10 == k ) {
	      k=0; sb.append("\n");
	  }
	}
	sb.setLength(sb.length()-1);
	sb.append("];\n");
	*/
    
String typeFetch =
"function typeFetch(form) { \n" +
"  ops = form.symptoms.options; \n" +
"  probe = form.userInput.value; \n" +
"  if ( \"\" == probe ) return; \n" +
"  if ( (probe < 'a') || ('zz' < probe) ) return( noSymptom() ); \n" +
"  min = 1; max = ops.length - 1; \n" +
"  pmax = v(ops[max]); \n" +
"  if ( pmax < probe ) return( noSymptom() ); \n" +
"  ix = narrowUp(min, max); \n" +
"  pix = v(ops[ix]); \n" +
"  pixj = pix.indexOf(probe); \n" +
"  if ( 0 != pixj ) return( noSymptom() ); \n" +
"  show(probe, ix);  \n" +
"} \n" +

"function v(oi) { \n" +
"  oj = oi.value; \n" +
"  i = oj.indexOf(\"|\"); \n" +
"  return oj.substring(i+1, oj.length); \n" +
"} \n" +

"function sym(oi) { \n" +
"  oj = oi.value; \n" +
"  i = oj.indexOf(\"|\"); \n" +
"  return oj.substring(0, i); \n" +
"} \n" +

"function narrowUp(i, j) { \n" +
"  if ( j <= i ) return i; \n" +
"  pi = v(ops[i]); \n" +
"  if ( probe <= pi ) { return i; } \n" +
"  k = Math.floor((i + j) / 2); \n" +
"  if ( i == k ) return j; \n" +
"  pk = v(ops[k]); \n" +
"  if ( pk <= probe ) return narrowUp(k, j); \n" +
"  return narrowUp(i, k);  \n" +
"} \n" +

"function noSymptom(){ \n" +
"    popup('No symptom for: ' + probe, 2000); \n" +
"} \n" +

"var myTimeout = 0;  \n" +

"function show(probe, ix){ \n" +
"  display = 'When found click on the item:<br>'; \n" +
"  last = ix + 10; \n" +
"  if ( max < last ) last = max; \n" +
"  for (var i = ix; i < last; i++) { \n" +
"    pix = v(ops[i]); \n" +
"    pixj = pix.indexOf(probe); \n" +
"    if ( 0 == pixj ) display = display + \n" +
"       '<a href=\"#' + i + '\" name=\"' + i + '\" onClick=\"addItem(' + i + ')\">' + \n" +
"       pix + '</a><br>'; \n" +
"    else break; \n" +
"  } \n" +
"  popup10(display); \n" +
"} \n" +

"function popup10(txt) { \n" +
"  popup(txt, 10000); \n" +
"} \n" +
"function popup(txt, tim) { \n" +
"  closeTypeDisplay(); \n" +
"  clearTimeout(myTimeout); \n" +
"  document.getElementById('typeDisplay').innerHTML=txt;  \n" +
"  document.getElementById('typeDisplay').style.display=\"block\"; \n" +
"  myTimeout = setTimeout(\"closeTypeDisplay()\", tim); \n" +
"} \n" +

"function closeTypeDisplay() { \n" +
"  document.getElementById('typeDisplay').style.display=\"none\"; \n" +
"} \n" +

"function addItem(i) { \n" +
"   closeTypeDisplay(); \n" +
"   item = ops[i]; \n" +
"   sm = sym(item); \n" +
"   pn = v(item); \n" +
"   form = document.forms[0]; \n" +
"   form.userInput.value=\"\"; \n" +
"   alert('addItem: ' + i + ' sm: ' + sm + ' pn: ' + pn);  \n" +
"}\n" +
"</script> \n";
    sb.append(typeFetch);

      
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML><HEAD><TITLE>ZType</TITLE>" + " \n" +
		  D.linkHckStyle + " \n" +
		  D.favicon + " \n" +
		  "<style type=\"text/css\"> \n" +
		  "  td {font-size:15pt; color:#850a0a} \n" +
		  "</style> \n");
      out.println(sb.toString());
      out.println("</HEAD>");
      out.println("<BODY >" +
		  "<font Color=\"#850a0a\">");
      
      out.println(
		  "<p> \n" +
		  "<FORM NAME=\"focussed\"> \n");
      out.println(
		  "<table border width=\"100%\">" +
		  "<tr><td width=\"30%\">" );

      out.println(
		  // "All symptoms:" +
		  L.AllSymptoms +
		  "</td><td>" +
		  "<select name=\"symptoms\" >");
      out.println("   <option value=\"ignore\">" +
		  L.DiagStartS22 + "</option>");
      lng = symptoms.size();
      String symp, description, token;
      for (int i = 0; i < lng; i++) {
	  symptom = (Symptom) symptoms.elementAt(i);
	  symp = symptom.getName();
	  printName = symptom.getPrintName();
	  description = symptom.getDescription();
	  token  = ( description.equals(printName) ?
		     printName :
		     printName + "/ " + description );
	  out.println("   <option value=\"" + symp + "|" + printName + 
		      "\">" + token + "</option>");
	  // printNames[i] = printName;
      }
      out.println("</SELECT>");
      out.println("</td></tr>"); 


      out.println( "<tr><td width=\"30%\">" +
		  // "... or type them" +
		  L.DiagStartS25 +
		  "</td><td>");
      out.println("<INPUT TYPE=\"text\" NAME=\"userInput\" SIZE=\"100\" VALUE=\"\" " +
		  "onKeyUp='typeFetch(this.form)' >" +
		  "</td></tr>"); 
      out.println("</table><p>");
      out.println("<center><span id=\"typeDisplay\"></span></center>");
      out.println("</form>");

      out.println("<p>");
      out.println("<table border width=\"100%\">");
      for (int i = 0; i < lng; i++) {
	  symptom = (Symptom) symptoms.elementAt(i);
	  symp = symptom.getName();
	  printName = symptom.getPrintName();
	  description = symptom.getDescription();
	  token  = ( description.equals(printName) ?
		     printName :
		     printName + "/ " + description );
	  out.println("<tr><td>" + symp + "</td><td>" +
		      token + "</td><tr>");
      }
      out.println("</table>");


	out.println("</font></BODY>");
	out.println("</HTML>");
    }


} // end of ZType




