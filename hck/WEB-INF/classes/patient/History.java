// (C) OntoOO Inc 2002
package patient;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.DV;
import com.D;
import com.L;
import com.DVM;
import misc.DB;
import concepts.Disease;
import concepts.Symptom;
import su.DiseaseRecord;
import misc.PeriodLogin0;
import misc.SessionExpired;

/*
  This generates a display of a member's history consisting of:
  -- the "heading" info of the member's account - provided at
     set up
  -- a chronologic list of subsequent session info, which is done
  by the workhorse processLogSessions

  To show another type of info captured in log-sessions, see 
  the body of processLogSessions.
  How to add another type of info to log sessions, see the comment 
  in the body of:   misc.PeriodLogin 
 */
public class History extends HttpServlet {
  public void doGet (HttpServletRequest req, 
		     HttpServletResponse res)
       throws ServletException, IOException
  {
    HttpSession session = req.getSession(false);
    if ( null == session ) {
	SessionExpired.call(res,
			    DV.History);
	return;
    }

    res.setContentType("text/html");
    ServletOutputStream out = res.getOutputStream();
    out.println(
       "<html><head><title>" + L.History + 
       "</title>" +
       D.favicon +
       "</head><body bgcolor=\"lightgreen\">");

    StringBuffer sb = null;

    try {
      String histVecName = (String) session.getValue("logName");
      Vector logSessions = Common.getLogSessions(histVecName);

      // in case we must deal with DiseaseInstHist:
      scriptDiseaseInstHist(out, histVecName);

      out.println(DVM.htmlLogoutUser(L.HistoryElements));

	  /*
	    // This will show all name-value pairs in session:
	    String [] valueNames = session.getValueNames();
	    int lng2 = valueNames.length;
	    out.println("<br><b>ValueNames:</b> ");
	    sb = new StringBuffer();
	    for (int i = 0; i<lng2; i++) {
	    String vn = valueNames[i];
	    Object obj = session.getValue(vn);
	    sb.append("<br><b>" + vn + ":</b> " + obj.toString());
	    }
	    out.println(sb.toString());
	    */

	// stuff from theDB:
	sb = new StringBuffer("<center><table border=\"1\">");

	/* episodic stuff is now in the 1st Hashtable of the logSessions vector
	sb.append("<tr><th colspan=\"2\"><b>" + 
	          "Pre HealthCheck History Summary" +
		  "<br />" + "
		  "Preliminary Format" +
		  "</b></th></tr>");
	sb.append("</td></tr><tr><td><b>MajorEvents=</b></td><td>"+
		  props.getProperty("majorEvents"));
	sb.append("</td></tr><tr><td><b>EatingDisorder=</b></td><td>"+
		  props.getProperty("eatingDisorder"));
	sb.append("</td></tr><tr><td><b>Mental=</b></td><td>"+
		  props.getProperty("mental"));
	sb.append("</td></tr><tr><td><b>ChronicCondition=</b></td><td>"+
		  props.getProperty("chronicCondition"));
	sb.append(
		  // other stuff here
		  "</td></tr>");
		  */

	// stuff from logSessions
	int lng = logSessions.size();
	if (0 < lng) processLogSessions(sb, logSessions, true);
	sb.append("</table></center>");
	out.println(sb.toString());
    } catch (Exception ex) {
      if ( null != sb ) {
	sb.append("</table></center>");
	out.println(sb.toString());
      }
      out.println("<h3><i><b>Something weird happened ... </b></i></h3>");
      out.println(ex.toString());
      out.println("<pre>");
      PrintStream ps = new PrintStream(out);
      ex.printStackTrace(ps);
      out.println("</pre>");
      
    }
    out.println(DV.htmlBack);

    // localhost:8000 === healthcareProvider:80 or so
    out.println(DV.SCRIPTCC);

    out.println("</body></html>");
  }

  static public void scriptDiseaseInstHist(ServletOutputStream out, String histVecName) 
                    throws IOException {
      out.println(
"<script language =\"JavaScript\"> \n" +
"function explainDI(sessionNum,key) { \n" +
"  explainWindowDI = open( \n" +
"    '" + D.servletDisplayDiseaseInstHist + "?sessionNumStr='+sessionNum+" +
	  "'&key='+key+'&histVecName=" + histVecName + "', \n" +
"    'explainWindowNameDIHist', \n" +
"    'toolbar=1,resizable=1,scrollbars=1,height=600,width=900' \n" +
"  ); \n" +
"} \n" +
"function explainDIS(sessionNum,key) { \n" +
"  explainWindowDIS = open( \n" +
"    '" + D.servletDisplayDiseaseConjecturesHist + "?sessionNumStr='+sessionNum+" +
	  "'&key='+key+'&histVecName=" + histVecName + "', \n" +
"    'explainWindowNameDISHist', \n" +
"    'toolbar=1,resizable=1,scrollbars=1,height=600,width=900' \n" +
"  ); \n" +
"} \n" +
"</script> ");
  }

  static public void processLogSessions(StringBuffer sb, 
					Vector logSessions,
					boolean userInvoked) {
    sb.append("<tr><th colspan=\"2\"><b>" +
	      // "Health Check History Summary" +
	      L.HistoryS1 +
	      "<br>" +
	      // "Some items from previous sessions:" +
	      L.HistoryS2 +
	      "</b></th></tr>");
    Hashtable ht;
    ht = (Hashtable) logSessions.elementAt(0);
    Vector historyOfDiseases = (Vector) ht.get("historyOfDiseases");
    if ( null != historyOfDiseases && 0 < historyOfDiseases.size() ) {
      sb.append("<tr><th colspan=\"2\"><b>" + 
		// "Diseases Pre Health Check" +
		L.HistoryS3 +
		"</b></th></tr>");
      int lng2 = historyOfDiseases.size();
      DiseaseRecord dr;
      String source;
      Date dat;
      Calendar cal; 
      String startDate;
      Disease dis;
      for (int j = 0; j < lng2; j++) {
	dr = (DiseaseRecord) historyOfDiseases.elementAt(j);
	source = dr.getSource();
	dat = dr.getDate();
	cal = Calendar.getInstance();
	cal.setTime(dat);
	startDate = "" + cal.get(Calendar.YEAR) + " " +
	  ( source.equals("Setup3") ? "" :
	    (1 + cal.get(Calendar.MONTH)) + " " + cal.get(Calendar.DAY_OF_MONTH) );
	dis = Common.getDisease(dr.getDisease());
	sb.append("<tr><td><b>" + dis.getPrintName());
	sb.append("</b></td><td>" + 
		  "<b>" + L.Source + "</b> " + source +
		  "<br /><b>" + L.StartDate + "</b> " + startDate);
      }
    }
    int lng = logSessions.size();
    for (int i=1; i<lng; i++) {
      ht = (Hashtable) logSessions.elementAt(i);
      sb.append("<tr><th colspan=\"2\"><b>" + L.LogSession + "</b></th></tr>");
      sb.append(makeRow(i, "start", ht));
      sb.append(makeRow(i, "pageCnt", ht));
      sb.append(makeRow(i, "surfCnt", ht));
      sb.append(makeRow(i, "tsFloat", ht));
      sb.append(makeRow(i, "bodyPart", ht));
      sb.append(makeRow(i, "system", ht));
      sb.append(makeRow(i, "selectedSymptoms", ht));
      sb.append(makeRow(i, "symptomElaborations", ht));
      sb.append(makeRow(i, "messageBody", ht));
      // sb.append(makeRow(i, "diseaseConjecture", ht));
      sb.append(makeRow(i, "acceptedDisease", ht));
      sb.append(makeRow(i, "diseaseConjectures", ht));
      sb.append(makeRow(i, 
			( userInvoked ? "ccPersonUserInvoked" : "ccPerson"), ht));
      sb.append(makeRow(i, "chatRecord", ht));
      sb.append(makeRow(i, "chatRecords", ht));
      sb.append(makeRow(i, "alertMessages", ht));
      sb.append(makeRow(i, "regularSideEffects", ht));
      sb.append(makeRow(i, "criticalSideEffects", ht));
      // other attributes here
      sb.append(makeRow(i, "end", ht));
    }
  }

  static private String makeRow(int i, String key, Hashtable ht) {
try {
    boolean userInvoked = false;
    if ( key.equals("ccPersonUserInvoked") ) {
      key = "ccPerson";
      userInvoked = true;
    }
    String stringValue = null;
    Object value = ht.get(key);
    if ( null == value ) return "";
    //    /* This code is weird.  An alternative is:
       if ( value instanceof String ) 
          stringValue = (String) value;
       else
       if ( value instanceof Float ) {
          stringValue = value.toString();
	  key = "temperature";
       }
       else
       if ( value instanceof Date ) 
          stringValue = value.toString();
       else
       if ( value instanceof Integer ) 
          stringValue = value.toString();

       //    */
       /*
    Class theClass = value.getClass();
    String className = theClass.getName();

    if ( className.equals("java.lang.String") ) 
      stringValue = (String) value;
    else
    if ( className.equals("java.util.Date") ) 
      stringValue = value.toString();
    else
    if ( className.equals("java.lang.Integer") ) 
      stringValue = value.toString();
    else
    if ( className.equals("java.lang.Float") ) {
      stringValue = value.toString();
      key = "temperature";
    }
       */

    if ( userInvoked ) { 
      // key was: ccPersonUserInvoked, hence will strip off the link 
      int linkIndex = stringValue.indexOf("<A");
      if ( linkIndex < 0 ) linkIndex = stringValue.indexOf("<a");
      if ( 0 < linkIndex ) stringValue = stringValue.substring(0, linkIndex);
    }

    if ( key.equals("diseaseConjecture") ||
         key.equals("acceptedDisease") ) { // stringValue is a diseaseName
      int anchor = i;
      String diseaseName = stringValue;
      Disease dis = Common.getDisease(diseaseName);
      if ( null == dis ) { 
	  return "<tr><td><b>*** Removed Disease:</b></td><td>" + 
	      diseaseName + "</td></tr>";
      }
      String printName = dis.getPrintName();
      boolean lifeThreatening = dis.isLifeThreatening();
      return ("<tr><td><b>" + L.DiseaseConjecture + "</b></td><td>" + 
	      "<a href=\"#" + anchor + 
			  "\" name=\"" + anchor + "\" onClick=\"explainDI('" +
			  i + "','" + key + "')\"><i>" +
			  (lifeThreatening ? "<font color=\"#FF0000\">" : "") +
			  printName + 
			  (lifeThreatening ? "</font>" : "") +
			  "</i></a>" +
	      "</td></tr>\n");
    }

    if ( key.equals("diseaseConjectures") ) { 
      // stringValue is a list: diseaseName1|diseaseName2|...
      int anchor = 1000+i;
      String diseaseList = stringValue;
      return ("<tr><td><b>" + L.DiseaseConjectures + "</b></td><td>" + 
	      "<a href=\"#" + anchor + 
			  "\" name=\"" + anchor + "\" onClick=\"explainDIS('" +
			  i + "','" + key + "')\"><i>disease conjectures</i></a>" +
	      "</td></tr>\n");
    }

    if ( !(null == stringValue)  )
      return ("<tr><td><b>" + key + ":</b></td><td>" + stringValue + "</td></tr>\n");

    // investigate other types here

    if ( key.equals("selectedSymptoms") ) { // value is a Vector
      Vector selectedSymptoms = (Vector) value;
      int lng = selectedSymptoms.size();
      if ( 0 == lng ) return "";
      String symptomName;
      Symptom sym;
      String printName;
      String description;
      int anchor;
      StringBuffer sb = new StringBuffer();
      for (int j = 0; j < lng; j++) {
	  symptomName = (String) selectedSymptoms.elementAt(j);
	  sym = Common.getSymptom(symptomName);
	  if ( null == sym ) {
	      sb.append("*** Removed Symptom: " + symptomName + " ");
	  } else {
	      printName = sym.getPrintName();
	      description = sym.getDescription();
	      anchor = 10000*i+j;
	      sb.append(
			"<a href=\"#" + anchor + 
			"\" name=\"" + anchor + "\" onClick=\"alert('" +
			description + "')\"><i>" +
			printName + "</i></a> " );
	  }
      }
      return ("<tr><td><b>" + L.SelectedSymptoms + "</b></td><td>" + 
	      sb.toString() + "</td></tr>\n");
    }

    if ( key.equals("symptomElaborations") ) { // value is a Vector
      Vector symptomElaborations = (Vector) value;
      int lng = symptomElaborations.size();
      if ( 0 == lng ) return "";
      String symptomName;
      Symptom sym;
      String printName;
      String duration;
      String change;
      StringBuffer sb = new StringBuffer();
      for (int j = 0; j < lng; j++) {
	  Vector triple = (Vector) symptomElaborations.elementAt(j);
	  symptomName = (String) triple.elementAt(0);
	  sym = Common.getSymptom(symptomName);
	  if ( null == sym ) {
	      sb.append("*** Removed Symptom: " + symptomName + " ");
	  } else {
	      printName = sym.getPrintName();
	      duration = (String) triple.elementAt(1);
	      change = (String) triple.elementAt(2);
	      sb.append( (0 < j ? "<br />" : "") +
			 "<i>" + printName + ":</i> " +
			 durationMap(duration) + ", " +
			 changeMap(change) );
	  }
      }
      return ("<tr><td><b>" + L.SelectedSymptoms + "</b></td><td>" + 
	      sb.toString() + "</td></tr>\n");
    }


    if ( key.equals("chatRecord") ) { // value is a Vector
      Vector chatRecordItems = (Vector) value;
      int lng = chatRecordItems.size();
      if ( 0 == lng ) return ""; // defensive move/ should never execute ...
      StringBuffer sb = new StringBuffer();
      String sentence;
      for (int j = 1; j < lng; j++) {
	sentence = (String) chatRecordItems.elementAt(j);
	sb.append(sentence);
      }
      return ("<tr><td><b>" + L.ChatSession + "</b></td><td>" + 
	      sb.toString() + "</td></tr>\n");
    }

    if ( key.equals("chatRecords") ) { // value is a Vector
      Vector chatRecords = (Vector) value;
      int lng2 = chatRecords.size();
      if ( 0 == lng2 ) return ""; // defensive move/ should never execute ...
      StringBuffer sb = new StringBuffer();
      String sentence;
      Vector chatRecordItems;
      int lng;
      for (int k = 0; k < lng2; k++) {
	chatRecordItems = (Vector) chatRecords.elementAt(k);
	lng = chatRecordItems.size();
	for (int j = 0; j < lng; j++) {
	  sentence = (String) chatRecordItems.elementAt(j);
	  sb.append(sentence);
	}
	if ( k < lng2 - 1 ) sb.append("<hr>");
      }
      return ("<tr><td><b>" + L.ChatSessions + "</b></td><td>" + 
	      sb.toString() + "</td></tr>\n");
    }
} catch (Exception ex) {
return "<tr><td>EXCEPTION i: " + i + " key: " + key + "</td></tr>";
}
    return "";
  }

    static public String durationMap(String duration) {
	if ( duration.equals("anHour") ) return L.anHour;
	if ( duration.equals("aFewHours") ) return L.aFewHours;
	if ( duration.equals("aDay") ) return L.aDay;
	if ( duration.equals("severalDays") ) return L.severalDays;
	if ( duration.equals("aWeek") ) return L.aWeek;
	if ( duration.equals("severalWeeks") ) return L.severalWeeks;
	if ( duration.equals("quiteAWhile") ) return L.quiteAWhile;
	return null;
    }
    static public String changeMap(String change) {
	if ( change.equals("noChange") ) return L.noChange;
	if ( change.equals("getsWorse") ) return L.getsWorse;
	if ( change.equals("getsLess") ) return L.getsLess;
	return null;
    }

}









