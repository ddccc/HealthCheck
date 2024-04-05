// (C) OntoOO Inc 2004 Mar
package phone;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.DV;
import com.D;
import com.L;
import com.Common;
import misc.DB;
import misc.SortableSymptom;
import patient.DiseaseInst;
import patient.TestSymptoms;
import misc.DiagStackEntry;
import concepts.Disease;
import concepts.Symptom;
import concepts.Location;
import concepts.WeightedSymptom;

public class AskLocDrivenSymptoms extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {

	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    PhoneError.call(res, "bevocal", 
			    // "Your session expired while in Ask Loc Driven Symptoms."
			    L.AskLocDrivenSymptoms1
			    );
	    return;
	}
	call(res, session);
    }
    
    static public void call(HttpServletResponse res, HttpSession session)
	throws IOException {

	session.putValue("state", "initial");
	Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");
	String page = "phone.AskLocDrivenSymptoms";
	String currentPage = (String) session.getValue("page");
	if ( !page.equals(currentPage) ) {
	    session.putValue("page", page);
	    Integer pageCnt = (Integer) session.getValue("pageCnt");
	    pageCnt = new Integer(1+ pageCnt.intValue());
	    session.putValue("pageCnt", pageCnt);
	    unboundHashtable.put("pageCnt", pageCnt);
	}
	Integer surfCnt = (Integer) session.getValue("surfCnt");
	surfCnt = new Integer(1+ surfCnt.intValue());
	
	session.putValue("surfCnt", surfCnt);
	unboundHashtable.put("surfCnt", surfCnt);

	// We get here via LocationNarrowedQ with a specific body focus
	// we are going to ask the client whether symptoms for that loc are present 
	Vector diagStack = (Vector) session.getValue("diagStack");
	DiagStackEntry dse = (DiagStackEntry) diagStack.elementAt(0);
	String bodyPart = dse.getBodyPart();

	// diag2 fragment
      DB props = (DB) session.getValue("theDB");
      String statusCondition = props.getProperty("statusCondition");
      Vector newAllSymptoms = dse.getNewAllSymptomsVec();


      // access more values on the stack here
      Vector locations = (Vector) dse.getLocations();

      Vector selectedSymptoms = (Vector) dse.getSelectedSymptoms();
      HashSet notSelectedSymptoms = (HashSet) dse.getNotSelectedSymptoms();

      Vector diseases = (Vector) dse.getDiseases(); // ie DiseaseInst


      // TestSymptoms elements are SortableSymptom that have not yet been used
      TestSymptoms testSymptoms= (TestSymptoms) dse.getTestSymptoms();

      // did the user narrow the location?
      boolean bodyPartNarrowed = true;

      // did the user narrow the system ??
      boolean systemNarrowed = false;

      HashSet S1 = (HashSet) session.getValue("S1"); // all symptoms
      // HashSet D1 = (HashSet) session.getValue("D1"); // all diaseases
      HashSet D1 = dse.getD2(); // collection of diseases investigated, a subset of D1

      int lng = diseases.size();
      float topRate = 0;

      boolean globalSymptoms = false;

      if ( topRate < 1 ) { 
	// Searching for new testable symptoms 
	// investigate: newExpertDiseases, newSystemDiseases, narrowed locations
	// boostedDiseases, newInSymptomsDiseases, ...

	if ( bodyPartNarrowed ) {
	    // will generate option to further narrow down - if possible
	    // locations = (Vector) locations.clone();
	    locations.addElement(bodyPart);
	    // a location has associated symptoms as well as subsystems 
	    // (which have diseases) Fow now we ignore the subsystems ...

	    if ( !bodyPart.equals("unspecified") ) {
		unboundHashtable.put("bodyPart", bodyPart);
		Location loc = Common.getLocation(bodyPart);
		Vector symptomsOfLoc = loc.getSymptoms();
		testSymptoms.addSymptoms(symptomsOfLoc, "bodyPartNarrowed",
					 S1, notSelectedSymptoms, selectedSymptoms);
	    }
	}

	lng = testSymptoms.size();
	String symptomName;
	if ( 0 == lng ) { 
	    globalSymptoms = true;
	    // get the most promissing from S1 - (selectedSymptoms + notSelectedSymptoms)
	    for (Iterator i = S1.iterator(); i.hasNext(); ) {
	        symptomName = (String) i.next();
		testSymptoms.addSymptom(symptomName, "none",
					S1, notSelectedSymptoms, selectedSymptoms);
	    }
	}
      } // end of creating testSymptoms elements
	
      // Notice: even when globalSymptoms = true testSymptoms may still be empty!!

      // end of diag2 fragment

      if ( 1 == topRate || 0 == testSymptoms.size() ) {
	  // Cannot happen/ just defensive programming
	  // no need to ask more questions or we cant ask more questions
	  PhoneWait.call(res, session, "0");
	  return;
      }

      // generate a list of symptoms to be presented to the caller
      	  Vector orderedSortedSymptoms =
	      testSymptoms.orderedTestSymptoms(diseases, notSelectedSymptoms, D1, false);
	  SortableSymptom ss;
	  String sympName;
	  int lng2 = ( lng < 20 ? lng : 20 ); // max # of test symptoms
	  Vector ts = new Vector();
	  for (int i = 0; i < lng2; i++) {
	      ss = (SortableSymptom) orderedSortedSymptoms.elementAt(i);
	      sympName = ss.getSympName();
	      testSymptoms.remove(sympName);
	      ts.addElement(sympName);
	      newAllSymptoms.addElement(sympName);
	  }

	  StringBuffer sb = new StringBuffer("<form id=\"querySymptoms\"> \n");
	  for (int i = 0; i < lng2; i++) {
	      sympName = (String) ts.elementAt(i);
	      Symptom sym = Common.getSymptom(sympName);
	      String printName = sym.getPrintName();
	      String description = sym.getDescription();
	      sb.append("<field name=\"" + sympName + "\" type=\"boolean\"> \n");
	      sb.append("<help>" +
			// "Do you have the symptom:" +
			L.AskLocDrivenSymptoms2 +
			" \"" + printName + "\" " +
			// "described by" +
			L.AskLocDrivenSymptoms3 +
			" \"" + description + "\"? </help> \n");
	      sb.append("<prompt>" +
			// "Do you have the symptom:" +
			L.AskLocDrivenSymptoms2 +
			" \"" + description + "\"? </prompt> \n");
	      sb.append("<filled> <if cond=\"(" + sympName + " == true)\"> \n");
	      sb.append("            <prompt>" +
			                 // "Got it: you do have" +
			                 L.AskLocDrivenSymptoms4 +
			                 " \"" + description + "\" </prompt> \n");
	      sb.append("         </if> \n");
	      sb.append("</filled> \n");
	      sb.append("</field> \n");
	  }
	  sb.append("<block>" +
		    // "OK, will get the next batch of questions, if any." + 
		    L.AskLocDrivenSymptoms5 +
		    "\n");
	  sb.append("<submit next=\"" + D.servletAnySymptomsQ + "\" \n ");
	  sb.append("    method=\"get\" fetchtimeout=\"60s\" \n namelist=\"");
	  // lng = ts.size();
	  for (int i = 0; i < lng2; i++) sb.append( (String)ts.elementAt(i) + " ");
	  sb.append("\" /> \n");
	  sb.append("</block> \n");
	  sb.append("</form> \n");

	  String questions = sb.toString();

	  //+++++++++++++++++++++

      if ( globalSymptoms ) testSymptoms.clear();

	String host = (String) session.getValue("host");

	String xml = 
"<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +

	    ( host.equals("bevocal") ?
	      L.vxml1
	      :
	      L.vxml2 ) +

" <property name=\"universals\" value=\"all\" /> \n" +
" <help>" +
  // I'm sorry. There's no help available here.
  L.noHelp +
"</help> \n" +
" <noinput>" +
  //I'm sorry. I didn't hear anything. \n" +
  L.silence +
"   <reprompt/> \n" +
" </noinput> \n" +
" <nomatch>" +
  // I didn't get that. \n" +
  L.nomatch +
"   <reprompt/> \n" +
" </nomatch> \n" +

questions +

"</vxml>";



	res.setContentType("application/voicexml+xml");
	ServletOutputStream out = res.getOutputStream();

	out.println(xml);

    }
}


