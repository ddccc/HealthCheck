
// (C) OntoOO Inc 2002
package patient;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.DV;
import com.D;
import com.Common;
import misc.DB;
import misc.DiagStackEntry;
import concepts.XWord;
import concepts.XWordNormal;
import concepts.XWordPolish;
import concepts.Symptom;
import concepts.Disease;
import misc.SessionExpired;


public class Diag1a extends HttpServlet {
    private static final boolean LOGGING = DV.LOGGINGdiag1a;
    // private static final boolean LOGGING = true;

    /* Access from:
       Diag1Focussed (starting a diag session)
       Diag1c (user has made an addition/ a change in Diag1b)
       Diag2B to deal with a new round of user inputs

       Input is "massaged" and passed on to Diag1b
       Main responsibility is processing free-form user-input,
       which is done by procUserInput(...)
     */
    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String enteringFrom = req.getParameter("enteringFrom");
      String iter = req.getParameter("iteration");
      int iteration = 0;
      try { iteration = Integer.parseInt(iter); } 
      catch(NumberFormatException ignore) {}
      if ( LOGGING ) {
	System.out.println("*** Diag1a: Enter iteration: " + iteration);
      }
      String[] newInSymptomsArr = req.getParameterValues("newInSymptoms");
      String newAllSymptoms = req.getParameter("newAllSymptoms");
      String userInput = req.getParameter("userInput");

      HttpSession session = req.getSession(false);
      if ( null == session ) {
	  SessionExpired.call(res,
			      DV.Diag1a);
	  return;
      }
      call(enteringFrom, iteration, session, userInput, newInSymptomsArr, newAllSymptoms, res);
    }

    static public void call
	(String enteringFrom, int iteration, HttpSession session,
	 String userInput, String[] newInSymptomsArr, String newAllSymptoms,
	 HttpServletResponse res) 
	throws IOException {
      call(enteringFrom, iteration, session, userInput, "", newInSymptomsArr, newAllSymptoms, res);
    }

    static public void call
	(String enteringFrom, int iteration, HttpSession session,
	 String userInput, String selectedSymptomsStr, String[] newInSymptomsArr, 
	 String newAllSymptoms, HttpServletResponse res) 
	throws IOException {

      // access values on the stack here
      Vector diagStack = (Vector) session.getValue("diagStack");
      
      DiagStackEntry dse = (DiagStackEntry) diagStack.elementAt(iteration);
      String bodyPart = dse.getBodyPart();
      String system = dse.getSystem();

      Vector newInSymptomsVec = null;
      Vector newAllSymptomsVec = null;
      if ( enteringFrom.equals("Diag1c") ) {
	  newInSymptomsVec = dse.getNewInSymptomsVec();
	  newAllSymptomsVec = dse.getNewAllSymptomsVec();
      } else {
	  newInSymptomsVec = new Vector();
	  newAllSymptomsVec = new Vector();
	  if ( enteringFrom.equals("Diag2") ) {
	      // String[] newInSymptomsArr = req.getParameterValues("newInSymptoms");
	      if ( null != newInSymptomsArr && 0 < newInSymptomsArr.length ) 
		  for (int i = 0; i < newInSymptomsArr.length; i++)
		      newInSymptomsVec.addElement(newInSymptomsArr[i]);
	      // String newAllSymptoms = req.getParameter("newAllSymptoms");
	      if ( null != newAllSymptoms && !newAllSymptoms.equals("") ) {
		  StringTokenizer st = new StringTokenizer(newAllSymptoms, ",");
		  while ( st.hasMoreTokens() ) newAllSymptomsVec.addElement(st.nextToken());
	      }
	  } else { // we entered from Diag1Focussed
	      session.removeValue("newInSymptomsArr");
	      session.putValue("enteringFrom", enteringFrom);
	  }
      }

      //   String userInput = req.getParameter("userInput");
      String ts = (String) session.getValue("temperatureSelected");
      Float tsFloat = (Float) session.getValue("tsFloat");
      float temperature = tsFloat.floatValue();

      if ( LOGGING ) {
	System.out.println("*** Diag1a: newInSymptomsVec= " + 
			   newInSymptomsVec.toString());
	System.out.println("*** Diag1a: newAllSymptomsVec= " + 
			   newAllSymptomsVec.toString());
	System.out.println("*** Diag1a: bodyPart= " + bodyPart);
	System.out.println("*** Diag1a: system= " + system);
	System.out.println("*** Diag1a: userInput= " + userInput);
      }


      Vector checkConcepts = (Vector) session.getValue("checkConcepts");
      checkConcepts.removeAllElements(); // defensive
      Vector foundConcepts = new Vector();
      Vector skipWords = new Vector();

      // instances of DiseaseInst
      Vector expertDiseases = (Vector) session.getValue("expertDiseases");
      // Vector diseases = (Vector) session.getValue("diseases");
      Vector diseases = dse.getDiseases();

      if ( null != selectedSymptomsStr &&
	   !selectedSymptomsStr.equals("") ) {
	  StringTokenizer st = new StringTokenizer(selectedSymptomsStr, "|");
	  while ( st.hasMoreTokens() ) {
	      String token = st.nextToken();
	      XWord xword = Common.getXWord(token);
	      // test is not supposed to fail/ but lets be defensive
	      if ( null != xword ) foundConcepts.addElement(xword);
	  }
	  if ( null == userInput && 0 < foundConcepts.size() ) userInput = "";
      }

      // process userInput here 
      if ( null != userInput ) {
	HashSet S1 = (HashSet) session.getValue("S1"); // all symptoms
	HashSet D1 = dse.getD2(); // collection of diseases investigated, a subset of D1

	procUserInput(
	  userInput, diseases, expertDiseases, foundConcepts, checkConcepts, skipWords);

	// checkConcepts contains things to be submitted to the user
	// foundConcepts contains symptoms|locations|diseases| ...

	if ( LOGGING ) log("<br>**** Diag1a AAA ",
			   checkConcepts, foundConcepts, skipWords);

	XWord xword;
	String type;
	String token;
	Symptom symptom;
	String symptomStatusCondition;
	Disease disease;
	String diseaseStatusCondition;

	Vector empty = new Vector(); // bogus vector
	Integer ageInt = (Integer) session.getValue("ageInt");
	int age = ageInt.intValue();
	DB props = (DB) session.getValue("theDB");
	String statusCondition = props.getProperty("statusCondition");

	for (int i = 0; i < foundConcepts.size(); i++) {
	  xword = (XWord) foundConcepts.elementAt(i);
	  type = xword.getType();
	  token = xword.getName();
	  if ( type.equals("Symptom") ) { 
	    // if ( 0 <= newInSymptomsStr.indexOf(token) ) continue;
	    if ( newInSymptomsVec.contains(token) ) continue;
	    if ( !S1.contains(token) ) continue; // gender check
	    symptom = Common.getSymptom(token);
	    if ( age < symptom.getMinAge() || symptom.getMaxAge() < age ) continue;
	    symptomStatusCondition = symptom.getStatusCondition();
	    if ( !symptomStatusCondition.equals("none") ) {
	      // check whether the client matches the statusCondition
	      if ( !symptomStatusCondition.equals(statusCondition) &&
		   // perhaps the client does not know she is pregnant
		   !symptomStatusCondition.equals("pregnant") ) continue; 
	    }
	    // newInSymptomsStr += "," + token;
	    newInSymptomsVec.addElement(token);
	    // if ( newAllSymptoms.indexOf(token) < 0) newAllSymptoms += "," + token;
	    if ( !newAllSymptomsVec.contains(token) ) 
	      newAllSymptomsVec.addElement(token);
	    continue; 
	  }
	  if ( type.equals("Location") ) { 
	    if ( token.equals("body") ) continue;
	    if ( bodyPart.equals("unspecified") ||
		 bodyPart.equals("body") ) {
	      bodyPart = token; continue;
	    }
	    if ( bodyPart.equals(token) ) continue;
	    // now we have two new locations ....
	    // lets assume the user's is more specific ...
	    bodyPart = token;
	    continue;
	  }
	  if ( type.equals("BodySystem") ) { 
	    if ( token.equals("bodySys") ) continue;
	    if ( system.equals("unspecified") ||
		 system.equals("bodySys") ) {
	      system = token; continue;
	    }
	    if ( system.equals(token) ) continue;
	    // now we have two new locations ....
	    // lets assume the user's is more specific ...
	    system = token;
	    continue;
	  }
	  if ( type.equals("Disease") ) { 
	    if ( !D1.contains(token) ) continue; // gender check
	    disease = Common.getDisease(token);
	    if ( age < disease.getMinAge() || disease.getMaxAge() < age ) continue;
	    diseaseStatusCondition = disease.getStatusCondition();
	    if ( !diseaseStatusCondition.equals("none") ) {
	      // check whether the client matches the statusCondition
	      if ( !diseaseStatusCondition.equals(statusCondition) &&
		   // perhaps the client does not know she is pregnant
		   !diseaseStatusCondition.equals("pregnant") ) continue; 
	    }
	    DiseaseInst di = new DiseaseInst(token, temperature);
	    di.requalify(empty, empty);
	    expertDiseases.addElement(di);
	    continue;
	  }
	}
      }
      
      if ( LOGGING ) log("<br>**** Diag1a after processing userInput ",
			   checkConcepts, foundConcepts, skipWords);

      // always go through a verification phase
      // session.putValue("newInSymptomsStr", newInSymptomsStr);
      // session.putValue("newAllSymptoms", newAllSymptoms);

      dse.setBodyPart(bodyPart);
      dse.setSystem(system);
      dse.setNewInSymptomsVec(newInSymptomsVec);
      dse.setNewAllSymptomsVec(newAllSymptomsVec);

      if ( 0 == iteration ) {
	  HashSet D2 = null;
	  if ( enteringFrom.equals("Diag1Focussed") ) 
	      D2 = new HashSet();
	  else {
	      String enteringFrom2 = (String) session.getValue(enteringFrom);
	      if ( enteringFrom.equals("Diag1Focussed") )
		  D2 = dse.getD2();
	  }
	  if ( null != D2 ) {
	      HashSet D1 = (HashSet) session.getValue("D1"); // all relevant diaseases
	      int lng = newInSymptomsVec.size();
	      for (int i=0; i<lng; i++) {
		  String sympName = (String) newInSymptomsVec.elementAt(i);
		  Symptom symptom = Common.getSymptom(sympName);
		  Vector theDiseases = symptom.getTheDiseases();
		  int lng2 = theDiseases.size();
		  for (int j=0; j<lng2; j++) {
		      String diseaseName = (String) theDiseases.elementAt(j);
		      if ( !D1.contains(diseaseName) ) continue; // gender check
		      if ( D2.contains(diseaseName) ) continue; // already there
		      D2.add(diseaseName);
		  }
	      }
	      dse.setD2(D2);
	  }
      }

      Diag1b.call(res, session, iteration);
    }

  static private void log(String label, Vector checkConcepts, 
		   Vector foundConcepts, Vector skipWords) {
	System.out.println(label);
	int lng5 = checkConcepts.size(); 
	System.out.println("checkConcepts: ");
	for (int i = 0; i<lng5; i++) 
	  System.out.println(((XWord)checkConcepts.elementAt(i)).getName());
	lng5 = foundConcepts.size(); 
	System.out.println("foundConcepts: ");
	for (int i = 0; i<lng5; i++) 
	  System.out.println(((XWord)foundConcepts.elementAt(i)).getName());
	System.out.println("skipWords: ");
	System.out.println(skipWords.toString());
  }

  static public void procUserInput(
	   String userInput,
	   Vector diseases,
	   Vector expertDiseases,
	   Vector foundConcepts,
	   Vector checkConcepts,
	   Vector skipWords) {
      StringTokenizer st;
      String token;
      int lng;

      // Process userInput 
      // Test every word and look for a corresponding XWord
      // If found add the xword into the vector userInputs
      // Output is stored in:
      //       foundConcepts, checkConcepts & skipWords 

	if (LOGGING) System.out.println("*** Diag1a/ processing user input");
	st = new StringTokenizer(userInput);
	Vector userInputs2 = new Vector();
	XWord xword;
	while ( st.hasMoreTokens() ) {
	  token = st.nextToken();
	  // token = token.toLowerCase();
	  if ( token.equals("acute") || // noise words - more filtering below
	       token.equals("chronic") ||
	       token.equals("increased") ||
	       token.equals("decreased") ||
	       token.equals("disease") ||
	       token.equals("failure") ||
	       token.equals("loss") ||
	       token.equals("lower") ||
	       token.equals("upper") 
	       ) continue;
	  // strip plural?, commas, brackets?
	  xword = Common.getXWord(token);
	  while ( null == xword ) {
	    if ( token.endsWith("s") || token.endsWith(",") ) {
	      token = token.substring(0, token.length() - 1);
	      xword = Common.getXWord(token);
	    } else {
	      String token2 = token.toLowerCase();
	      if ( token2.equals(token) ) break;
	      token = token2;
	      xword = Common.getXWord(token);
	      if ( null != xword ) userInput += " " + token;
	    }
	  }
	  if ( null == xword ) continue;
	  if ( userInputs2.contains(xword) ) continue;
	  userInputs2.addElement(xword);
	}

	// try find doubles, triples, ...
	Vector userInputs = findCombinations(userInputs2);

	// Process the xword-s in userInputs
	if (LOGGING) System.out.println("*** Diag1a/ userInputs# " + userInputs.size() );

	// find symptoms, locations, diseases, unknown
	String type;
	for (int i = 0; i < userInputs.size(); i++) {
	  xword = (XWord) userInputs.elementAt(i);
	  type = xword.getType();
	  token = xword.getName();
	  if (LOGGING) 
	    System.out.println("*** Diag1a/ userInputs token: " + token );

	  if ( type.equals("synonym") ) {
	    if (LOGGING) 
	      System.out.println("*** Diag1a/ userInputs synonym: " + token );
	    String reference = xword.getSynonym();
	    if ( null == reference ) continue; // impossible
	    xword = Common.getXWord(reference);
	    if ( !userInputs.contains(xword) )
	      userInputs.addElement(xword);
	    continue;
	  }

	  if ( type.equals("Disease") ) {
	    if ( Common.isDiseaseMember(token, diseases) ) continue;
	    if ( Common.isDiseaseMember(token, expertDiseases) ) continue;
	    Disease dis = Common.getDisease(token);
	    Vector subDiseases = dis.getSubDiseases();
	    int sd = subDiseases.size();
	    if ( 0 == sd ) {
	      foundConcepts.addElement(xword);
	      continue;
	    }
	    for (int j = 0; j < sd; j++) {
	      String subDisease = (String) subDiseases.elementAt(j);
	      xword = Common.getXWord(subDisease);
	      if ( null == xword ) continue; // impossible
	      if ( userInputs.contains(xword) ) continue;
	      userInputs.addElement(xword);
	    }
	    continue;
	  }

	  if ( !type.equals("unknown") ) { // Symptom or Location
	    foundConcepts.addElement(xword);
	    // perhaps there are refinements 
	    if ( xword instanceof XWordNormal ) {
	      XWordNormal xwn = (XWordNormal) xword;
	      Vector references = xwn.getReferences();
	      int lng2 = references.size();
	      String reference;
	      XWord xwordRef;
	      for (int j = 0; j<lng2; j++) {
		reference = (String) references.elementAt(j);
		xwordRef = Common.getXWord(reference);
		if ( foundConcepts.contains(xwordRef) ) continue; 
		if ( checkConcepts.contains(xwordRef) ) continue;
		checkConcepts.addElement(xwordRef);
	      }
	    }
	    continue;
	  }

	  // type == unknown, check whether we can find a reference in the input
	  // this xword must be an XWordNormal
	  if (LOGGING) 
	    System.out.println("*** Diag1a/ userInputs unknown token: " + token );

	  if ( skipWords.contains(token) ) continue;

	  // Chase through a chain of synonyms
	  String reference1 = xword.getSynonym();
	  if ( null != reference1 ) { 
	    String reference2;
	    XWord xword2;
	    while (true) { 
	      xword2 = Common.getXWord(reference1);
	      reference2 = xword2.getSynonym();
	      if ( null == reference2 ) break;
	      reference1 = reference2;
	    }
	    userInputs.addElement(xword2);
	    // continue;
	  }

	  // no synonym
 	  XWordNormal xwn = (XWordNormal) xword;
	  Vector references = xwn.getReferences();
	  int lng2 = references.size();
	  // if ( 10 < lng2 ) continue; // noise word
	  String reference;
	  XWord xwordRef;
	  for (int j = 0; j<lng2; j++) {
	    reference = (String) references.elementAt(j);
	    if (LOGGING) 
	      System.out.println("*** Diag1a/ userInputs reference: " + reference );
	    xwordRef = Common.getXWord(reference);
	    if ( foundConcepts.contains(xwordRef) ) continue; 
	    // xwordRef need not be of type XWordPolish !
	    if ( xword instanceof XWordNormal ) {
	      type = xwordRef.getType();
	      if ( type.equals("unknown") ) continue; // dont go too far ...
	      if ( !checkConcepts.contains(xwordRef) ) checkConcepts.addElement(xwordRef);
	      continue;
	    }
	    // check that the full description is present
	    XWordPolish xp = (XWordPolish) xwordRef;
	    Vector subWords = xp.getSubWords();
	    int lng3 = subWords.size();
	    boolean found = true;
	    String subWord;
	    for (int k = 0; k < lng3; k++) {
	      subWord = (String) subWords.elementAt(k);
	      if ( userInput.indexOf(subWord) < 0 ) {
		found = false; break;
	      }
	    }
	    if ( found ) { 
	      if (LOGGING) {
		System.out.println("*** Diag1a found reference= " + reference);
	      }
	      // 2) add subWords to skipWords
	      for (int k = 0; k < lng3; k++) {
		subWord = (String) subWords.elementAt(k);
		if ( !skipWords.contains(subWord) ) skipWords.addElement(subWord);
	      }
	      // 3) remove entries in checkConcepts that contain a subWord
	      int lng4 = checkConcepts.size();
	      for (int k = lng4-1; 0<=k; k--) {
		XWord xw = (XWord) checkConcepts.elementAt(k);
		boolean keep = true;
		if ( xw instanceof XWordNormal ) {
		  XWordNormal xwn2 = (XWordNormal) xw;
		  if ( subWords.contains(xwn2.getName()) ) keep = false;
		} else {
		  XWordPolish xwp = (XWordPolish) xw;
		  Vector subWords2 = xwp.getSubWords();
		  for (int n = 0; n<subWords2.size(); n++) 
		    if ( subWords.contains(subWords2.elementAt(n)) ) {
		      keep = false; break;
		    }
		}
		if (!keep) { 
		  checkConcepts.removeElementAt(k);
		  if (LOGGING) {
		    System.out.println("*** Diag1a found remove concept= " +
				       xw.getName());
		  }
		}
	      }
	      // 4) remove entries in foundConcepts that contain a subWord
	      lng4 = foundConcepts.size();
	      for (int k = lng4-1; 0<=k; k--) {
		XWord xw = (XWord) foundConcepts.elementAt(k);
		boolean keep = true;
		if ( xw instanceof XWordNormal ) {
		  XWordNormal xwn2 = (XWordNormal) xw;
		  if ( subWords.contains(xwn2.getName()) ) keep = false;
		} else {
		  XWordPolish xwp = (XWordPolish) xw;
		  Vector subWords2 = xwp.getSubWords();
		  for (int n = 0; n<subWords2.size(); n++) 
		    if ( subWords.contains(subWords2.elementAt(n)) ) {
		      keep = false; break;
		    }
		}
		if (!keep) { 
		  foundConcepts.removeElementAt(k);
		  if (LOGGING) {
		    System.out.println("*** Diag1a found remove concept= " +
				       xw.getName());
		  }
		}
	      }
	      // 1) add xwordRef to userInputs - because it may be still an alias
	      userInputs.addElement(xwordRef);
	      break;
	    }
	    if (LOGGING) 
	      System.out.println("*** Not found= " + reference);
	    // add xwordRef to checkConcepts ?
	    if ( checkConcepts.contains(xwordRef) ) continue;
	    if ( foundConcepts.contains(xwordRef) ) continue;
	    type = xwordRef.getType();
	    if ( type.equals("Disease") ) {
	      String token2 = xwordRef.getName();
	      if ( Common.isDiseaseMember(token2, diseases) ||
		   Common.isDiseaseMember(token2, expertDiseases) )
		continue;
	    }
	    if (LOGGING) 
	      System.out.println("*** Adding to checkConcepts= " + reference);
	    checkConcepts.addElement(xwordRef);
	  }
	}
  } // end  procUserInput(...)

    static private Vector findCombinations(Vector ui2) {
	int lng = ui2.size();
	if ( lng <= 1 ) return ui2;
	if ( 2 == lng ) 
	    return findCombinations2((XWordNormal)ui2.elementAt(0), (XWord)ui2.elementAt(1)); 
	Vector tail = (Vector) ui2.clone();
	tail.removeElementAt(0);
	tail = findCombinations(tail);
	Vector head2 = findCombinations2((XWordNormal)ui2.elementAt(0), (XWord)tail.elementAt(0));
	if ( 1 == head2.size() ) {
	    tail.setElementAt(head2.elementAt(0),0);
	    return tail;
	}
	tail.insertElementAt(head2.elementAt(0),0);
	return tail;
    } // end of findCombinations

    static private Vector findCombinations2(XWordNormal x0, XWord x1) {
	// chase through synonyms of x0 and x1?
	Vector out = new Vector();
	Vector ref0 = x0.getReferences();
	if ( 0 == ref0.size() ) {
	    out.addElement(x0); out.addElement(x1); return out;
	}
	String name1 = ( x1 instanceof XWordPolish ?
			 getPrefix((XWordPolish)x1) :
			 x1.getName() );
	int lng = ref0.size();
	for (int i = 0; i<lng; i++) {
	    String ref0i = (String) ref0.elementAt(i);
	    XWord xref = Common.getXWord(ref0i);
	    if ( !(xref instanceof XWordPolish) ) continue;
	    XWordPolish xwp = (XWordPolish) xref;
	    Vector subWords = xwp.getSubWords();
	    int lng2 = subWords.size();
	    for (int j = 0; j<lng2; j++) {
		// XWord swj = (XWord) subWords.elementAt(j);
		// String name1j = swj.getName();
		String name1j = (String) subWords.elementAt(j);
		if ( name1.equals(name1j) ) { // found a pair
		    out.addElement(xwp);
		    // return out;
		}
	    }
	}
	if ( 0 == out.size() ) {
	    out.addElement(x0); 
	    out.addElement(x1); 
	}
	return out;
    }  // end of findCombinations2

    static private String getPrefix(XWordPolish xwp) {
	Vector subWords = xwp.getSubWords();
	// XWord sw = (XWord) subWords.elementAt(0);
	// return sw.getName();
	return (String) subWords.elementAt(0);
    }
}
