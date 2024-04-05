// Copyright OntoOO Inc, 2004 Jan
package phone;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.L;
import com.D;
import misc.DB;
// import misc.PeriodLogin;
import concepts.Location;
// import concepts.LocationRelation;
// import concepts.PartOfLocation;
import misc.DiagStackEntry;
import patient.TestSymptoms;


public class AskLocation extends HttpServlet {


    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
	HttpSession session = req.getSession(false);
	if ( null == session ) {
	    PhoneError.call(res, "bevocal", 
			    // "Your session expired while in Ask Location."
			    L.AskLocationS0
			    );
	    return;
	}
	call(res, session);
    }

    static public void call(HttpServletResponse res, HttpSession session) 
	throws IOException {

	// Setup the diagnosis stack
	// We will use only one iteration because we will not backtrack
	Hashtable unboundHashtable = 
	    (Hashtable) session.getValue("unboundHashtable");


	String previousBodyPart = "unspecified";
	String previousSystem = "unspecified";

	String ts = "99.3"; // default value because we have asked the client yet

	String weight = null;
	String duration = null;
	String bodyPart = (String) session.getValue("bodyPart"); // which is "body"
	String system = "unspecified";
	

	Vector selectedSymptoms = new Vector();
	HashSet notSelectedSymptoms = new HashSet();
	Vector locations = new Vector();
	locations.addElement(previousBodyPart);
	Vector systems = new Vector();
	systems.addElement(previousSystem);
	Vector diseases = new Vector(); // instances of DiseaseInst
	// Vector expertDiseases = new Vector(); // instances of DiseaseInst
	// Vector checkConcepts = new Vector(); 

	Float tsFloat = new Float(99.3f);
	try { tsFloat = new Float(ts); }
	catch (NumberFormatException ignore) {}
	unboundHashtable.put("tsFloat", tsFloat);


	session.putValue("temperatureSelected", ts);
	session.putValue("tsFloat", tsFloat);

	session.putValue("foundLifeThreateningDisease", "notFound");
	// session.putValue("expertDiseases", expertDiseases);
	// session.putValue("checkConcepts", checkConcepts);

	DB props = (DB) session.getValue("theDB");
	String statusCondition = props.getProperty("statusCondition");
	Integer ageInt = (Integer) session.getValue("ageInt");
	int age = ageInt.intValue();
	TestSymptoms testSymptoms = new TestSymptoms(age, statusCondition);

	Vector diagStack = new Vector();
	session.putValue("diagStack", diagStack);
	session.putValue("iter", "0"); // for DisplayDiseaseInst - fixed because only one iteration here
	DiagStackEntry dse = 
	    new DiagStackEntry(locations, systems, 
			       selectedSymptoms, notSelectedSymptoms,
			       diseases);
	diagStack.addElement(dse);
	dse.setBodyPart(bodyPart);
	dse.setSystem(system);
	dse.setTestSymptoms(testSymptoms);
	dse.setNewAllSymptomsVec(new Vector());

	// set the collection of diseases to be investigated
	HashSet D1 = (HashSet) session.getValue("D1"); // all diaseases
	dse.setD2(D1);


	// update the "page description" that we produce
	// Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");
	String page = "phone.AskLocation";
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

	// to deal with different speech sites:
	String host = (String) session.getValue("host");


	String xml = 
"<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +

	    ( host.equals("bevocal") ?
	      L.vxml1
	      :
	      L.vxml2 ) +

" <property name=\"universals\" value=\"all\" /> \n" +
" <help> " + 
	    // I'm sorry. There's no help available here.
	    L.noHelp +
"</help> \n" +
" <noinput>" +
	    // I'm sorry. I didn't hear anything. \n" +
	    L.silence +
"   <reprompt/> \n" +
" </noinput> \n" +
" <nomatch>" +
	    // I didn't get that. \n" +
	    L.nomatch +
"   <reprompt/> \n" +
" </nomatch> \n" +

" <form id=\"bodyPart\"> \n" +
"	<field name=\"answer\"> \n" +
"            <help> <prompt> " +
	         // Say <break time=\"500ms\"/> \"a part\" or \n" +
	         // say <break time=\"500ms\"/> \"body\". 
	         L.partOrBody +
"            </prompt> </help> \n" +
"	     <prompt> \n" +
	    /*
"               The first step is identifying a specific area, if any, of concern. \n" +
"               At any time you can say \"help\" to have a question repeated and or to obtain advice. \n" +
"               Are you bothered by a distinct part of your \"body\" \n" +
"               or does your problem concerns your whole \"body\"? \n" +
"               Please say \"a part\" or say \"body\". \n" + 
	    */
	    L.AskLocationS1 +
"	     </prompt> \n" +

	    ( host.equals("bevocal") ?
"            <grammar type=\"application/x-nuance-gsl\"> \n" 
	      :
"            <grammar type=\"text/gsl\"> \n" ) +
	    //"                  [(a part) body] \n" +
	         L.partOrBody2 +
"            </grammar> \n" +
"            <filled> \n" +
	    /*
"              <if cond=\"(answer == 'a part') \"> \n" +
"	          <prompt> \n" +
"                 OK, will explore parts of your: \"body\". \n" +
	    */
	    L.AskLocationS2 +
"	          </prompt> \n" +
"                 <goto nextitem=\"answer2\"/> \n" +	    
"              <else/> \n" +
"	          <prompt> \n" +
	    //"                 OK, will concentrate on your: \"body\". \n" +
	              L.AskLocationS3 +
"	          </prompt> \n" +
"                 <submit next=\"" + D.servletAskSymptom + "\" " +
"                        method=\"get\" fetchtimeout=\"60s\"/> \n" +
"              </if> \n" +
"            </filled> \n" +
"       </field> \n" +

	    ( host.equals("bevocal") ?
"            <grammar type=\"application/x-nuance-gsl\"> \n" 
	      :
"            <grammar type=\"text/gsl\"> \n" ) +

"            <![CDATA[ \n" +
"  SomeBodyLocations[ \n " +
	    /*
"           [(?my abdomen)] {<answer2 \"abdomen\">} \n " +
"           [(?my ankles)] {<answer2 \"ankles\">} \n " +
"           [(?my left ankle)] {<answer2 \"leftAnkle\">} \n " +
"           [(?my right ankle)] {<answer2 \"rightAnkle\">} \n " +
"           [(?my arms)] {<answer2 \"arms\">} \n " +
"           [(?my left arm)]  {<answer2 \"leftArm\">} \n " +
"           [(?my right arm)] {<answer2 \"rightArm\">} \n " +
"           [(?my arm pits)] {<answer2 \"armPits\">} \n " +
"           [(?my left arm pit)] {<answer2 \"leftArmPit\">} \n " +
"           [(?my right arm pit)] {<answer2 \"rightArmPit\">} \n " +
"           [(?my back)] {<answer2 \"back\">} \n " +
"           [(?my chest)] {<answer2 \"chest\">} \n " +
"           [(?my ears)] {<answer2 \"ears\">} \n " +
"           [(?my left ear)]  {<answer2 \"leftEar\">} \n " +
"           [(?my right ear)] {<answer2 \"rightEar\">} \n " +
"           [(?my elbows)] {<answer2 \"elbows\">} \n " +
"           [(?my left elbow)]  {<answer2 \"leftElbow\">} \n " +
"           [(?my right elbow)] {<answer2 \"rightElbow\">} \n " +
"           [(?my eyes)] {<answer2 \"eyes\">} \n " +
"           [(?my left eye)]  {<answer2 \"leftEye\">} \n " +
"           [(?my right eye)] {<answer2 \"rightEye\">} \n " +
"           [(?my face)] {<answer2 \"face\">} \n " +
"           [(?my feet)] {<answer2 \"feet\">} \n " +
"           [(?my left foot)] {<answer2 \"leftFoot\">} \n " +
"           [(?my right foot)] {<answer2 \"rightFoot\">} \n " +
"           [(?my fingers)] {<answer2 \"fingers\">} \n " +
"           [(?my left fingers)]  {<answer2 \"leftFingers\">} \n " +
"           [(?my right fingers)] {<answer2 \"rightFingers\">} \n " +
"           [(?my hands)] {<answer2 \"hands\">} \n " +
"           [(?my left hand)]  {<answer2 \"leftHand\">} \n " +
"           [(?my right hand)] {<answer2 \"rightHand\">} \n " +
"           [(?my head)] {<answer2 \"head\">} \n " +
"           [(?my heart)] {<answer2 \"heart\">} \n " +
"           [(?my hips)] {<answer2 \"hips\">} \n " +
"           [(?my left hip)]  {<answer2 \"leftHip\">} \n " +
"           [(?my right hip)] {<answer2 \"rightHip\">} \n " +
"           [(?my intestines)] {<answer2 \"intestines\">} \n " +
"           [(?my jaws)] {<answer2 \"jaws\">} \n " +
"           [(?my left jaw)]  {<answer2 \"leftJaw\">} \n " +
"           [(?my right jaw)] {<answer2 \"rightJaw\">} \n " +
"           [(?my joints)] {<answer2 \"joints\">} \n " +
"           [(?my left joint)]  {<answer2 \"leftJoint\">} \n " +
"           [(?my right joint)] {<answer2 \"rightJoint\">} \n " +
"           [(?my kidneys)] {<answer2 \"kidneys\">} \n " +
"           [(?my left kidney)]  {<answer2 \"leftKidney\">} \n " +
"           [(?my right kidney)] {<answer2 \"rightKidney\">} \n " +
"           [(?my knees)] {<answer2 \"knees\">} \n " +
"           [(?my left knee)]  {<answer2 \"leftKnee\">} \n " +
"           [(?my right knee)] {<answer2 \"rightKnee\">} \n " +
"           [(?my legs)] {<answer2 \"legs\">} \n " +
"           [(?my left leg)]  {<answer2 \"leftLeg\">} \n " +
"           [(?my right leg)] {<answer2 \"rightLeg\">} \n " +
"           [(?my liver)] {<answer2 \"liver\">} \n " +
"           [(?my lungs)] {<answer2 \"lungs\">} \n " +
"           [(?my left lung)]  {<answer2 \"leftLung\">} \n " +
"           [(?my right lung)] {<answer2 \"rightLung\">} \n " +
"           [(?my neck)] {<answer2 \"neck\">} \n " +
"           [(?my nose)] {<answer2 \"nose\">} \n " +
"           [(?my shoulders)] {<answer2 \"shoulders\">} \n " +
"           [(?my left shoulder)]  {<answer2 \"leftShoulder\">} \n " +
"           [(?my right shoulder)] {<answer2 \"rightShoulder\">} \n " +
"           [(?my stomach)] {<answer2 \"stomach\">} \n " +
"           [(?my throat)] {<answer2 \"throat\">} \n " +
"           [(?my tongue)] {<answer2 \"tongue\">} \n " +
"           [(?my torso)] {<answer2 \"torso\">} \n " +
	    */
	         L.AskLocationS6 +
"           ]]]> \n " +
"           </grammar> \n" +

"	<field name=\"answer3\"  expr=\"'not set'\" /> \n" +

"	<field name=\"answer2\"> \n" +
"            <help> " +
	         // Other examples: abdomen, joints, back, my eyes, my lungs, and so on. \n" +
	         L.AskLocationS4 +
"            </help> \n" +
"	     <prompt> \n" +
	    /*
"               Please say which part of your body is bothering you the most. \n" +
"               For example say: neck, or say: my knees, or say: stomach, or say: my head. \n" +
"               Say \"help\" to hear some other choices. \n" +
	    */
	         L.AskLocationS5 +
"	     </prompt> \n" +

"           <nomatch count=\"1\"> \n" + 
	    //"  Your answer was not recognized.  Let's try one more time with a more specific location. \n" +
	         L.AskLocationS7 +
"              <reprompt/> \n" +
"           </nomatch> \n" + 
"           <nomatch count=\"2\"> \n" + 
	    //" Your answer was again not recognized.  Will try another systematic approach. \n" +
	         L.AskLocationS8 +
"              <submit next=\"" + D.servletAskBodyPart + "\" " +
"                      method=\"get\" fetchtimeout=\"60s\"/> \n" +
"           </nomatch> \n" + 
"           <filled> \n" +
	       //"  OK will explore further: "
	       L.AskLocationS9 + 
"              <value expr=\"answer3\"/>. \n" +
"              <submit next=\"" + D.servletRefinePartQ + "\" " +
"                      method=\"get\" namelist=\"answer2\" fetchtimeout=\"60s\"/> \n" +
"           </filled> \n" +
"       </field> \n" +
" </form> \n" +
"</vxml>";

	res.setContentType("application/voicexml+xml");
	ServletOutputStream out = res.getOutputStream();

	out.println(xml);

    }
}



