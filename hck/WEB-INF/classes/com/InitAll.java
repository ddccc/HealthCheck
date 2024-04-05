// (C) OntoOO Inc 2000
package com;

import concepts.*;
import init.*;

import java.util.Vector;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class InitAll {
  public static void main(String[] args) {

    Common.resetHashTables();

    Common.createTheXWords();
    Common.setTheXWordsLoaded(true);

    // Locations
    CreateLocations();

    // BodySystems
    System.out.println("****** InitBodySystems ...");
    InitBodySystems.doit();
    System.out.println("****** return from InitBodySystems ...");

    // Symptoms
    System.out.print("****** InitSymptoms: ");
    InitSymptoms.doit();
    String [] allSymptoms = Common.allSymptoms();
    int lng = allSymptoms.length;
    System.out.println(lng);

    Common.createTheTreatments();
    Common.setTheTreatmentsLoaded(true);
    Common.createTheDrugs();
    Common.setTheDrugsLoaded(true);
    Common.createTheTreatmentActions();
    Common.setTheTreatmentActionsLoaded(true);
    Common.createTheTreatmentConditions();
    Common.setTheTreatmentConditionsLoaded(true);

    // Abnormal Conditions
    System.out.println("****** InitAbnormalConditions ...");
    InitAbnormalConditions.doit();

    // Disease Sets
    System.out.println("****** InitDiseaseSets ...");
    InitDiseaseSets.doit();

    // Diseases
    System.out.println("****** Switch to InitDiseases ...");
    InitDiseases.doit();
    System.out.println("****** Return from InitDiseases ...");

    // mark here the diseases that are life threatening ...
    MarkLifeThreateningDiseases();

    // Drugs
    System.out.println("****** Switch to InitDrugs ...");
    InitDrugs.doit();
    System.out.println("****** Return from InitDrugs ...");

    // Read synonyms
    System.out.println("****** InitSynonyms ...");
    InitSynonyms.doit();
    System.out.println("****** Return from InitSynonyms ...");
    // Common.saveTheXWords();
    // System.out.println("****** Saved the XWords");

    System.out.println("***** AddIndices to add references ...");

    StringBuffer sb = new StringBuffer();
    procAddIndices(sb, false);
    System.out.println(sb.toString());


    // make some diseases accessible
    adjustSymptoms();

    // Create sets of male and female symptoms
    CreateMaleFemaleSymptoms();

    // Create sets of male and female diseases
    CreateMaleFemaleDiseases();

    // Create sets of male and female locations
    CreateMaleFemaleLocations();

    // Create location hierarchy
    CreateLocationHierarchy();
    CreateHeadHierarchy();
    CreateNeckHierarchy();
    CreateChestHierarchy();
    CreateAbdomenHierarchy();
    CreateGenitaliaHierarchy();
    CreateArmsHierarchy();
    CreateLegsHierarchy();
    CreateMiscHierarchy();

    Common.saveHashTables();


  } // end of main(...)

    static public void CreateLocations() {

	System.out.println("****** InitBody ...");
	InitBody.doit();

	System.out.println("****** InitHead ...");
	InitHead.doit();
    
	System.out.println("****** InitTorso ...");
	InitTorso.doit();

	System.out.println("****** InitHeart ...");
	InitHeart.doit();
    
	System.out.println("****** InitArms ...");
	InitArms.doit();
    
	System.out.println("****** InitLegs ...");
	InitLegs.doit();

	System.out.println("****** InitMultiParts ...");
	InitMultiParts.doit();

	System.out.println("****** InitNeck ...");
	InitNeck.doit();
    }

    static public void MarkLifeThreateningDiseases() {
	DiseaseSet lifeThreateningDisorders = 
	    Common.getDiseaseSet(LR.lifeThreateningDisorders);
	Vector vec = lifeThreateningDisorders.getDiseaseMembers();
	int lng = vec.size();
	System.out.println("# lifeThreateningDisorders= " + lng);
	String dis;
	Disease disease;
	for (int i = 0; i<lng; i++) {
	    dis = (String) vec.elementAt(i);
	    disease = Common.getDisease(dis);
	    disease.setLifeThreatening(true);
	}
    }

    static public void adjustSymptoms() {
	String [] allDiseases = Common.allDiseases();
	int lng = allDiseases.length;
	String dis;
	Disease disease;
	Vector allSymptoms;
	int cnt = 0;
	for (int i = 0; i<lng; i++) {
	    dis = allDiseases[i];
	    disease = Common.getDisease(dis);
	    if ( disease.isSuperDisease() ) continue; // ignore these
	    if ( 0 < disease.getSymptoms0().size() ) continue; // OK
	    allSymptoms = disease.getSymptoms();
	    if ( 0 == allSymptoms.size() ) {
		System.out.println("***** No symptoms for: " + dis);
		continue;
	    }
	    cnt++;
	    int lng2 = allSymptoms.size();
	    WeightedSymptom wsymp;
	    Symptom sym;
	    String symptomName;
	    for (int j = 0; j < lng2; j++) {
		wsymp = (WeightedSymptom) allSymptoms.elementAt(j);
		symptomName = wsymp.getSymptom();
		sym = Common.getSymptom(symptomName);
		sym.addDisease(dis);
	    }
	}
	System.out.println("***** # diseases fixed: " + cnt);
    }

    static public void CreateMaleFemaleSymptoms() {

	String [] allSymptoms = Common.allSymptoms();
	int lng = allSymptoms.length;
	HashSet maleSymptoms = new HashSet();
	HashSet femaleSymptoms = new HashSet();
	String symp, locationSt, gender;
	Symptom symptom;
	Vector theDiseases;
	PartOfLocation location;
	String aDiseaseName;
	Disease aDisease;
	int minAge, maxAge;
	boolean none; // set but not used ...
	boolean premenstruating;
	boolean menstruating;
	boolean pregnant;
	boolean menopause;
	boolean postmenopause;
	boolean male;
	boolean female;
	for (int i = 0; i < lng; i++) {
	    symp = allSymptoms[i];
	    symptom = Common.getSymptom(symp);
	    theDiseases = symptom.getTheDiseases();
	    if ( theDiseases.size() <= 0 ) continue; // ignore these
	    // investigate here whether we can specialize this symptom
	    theDiseases = (Vector) theDiseases.clone();
	    minAge = LR.maxAge;
	    maxAge = 0;
	    none = false; 
	    male = true;
	    female = true;
	    premenstruating = false; 
	    menstruating = false;
	    pregnant = false;
	    menopause = false;
	    postmenopause = false;
	    for (int j = 0; j < theDiseases.size(); j++) {
		aDiseaseName = (String) theDiseases.elementAt(j);
		aDisease = Common.getDisease(aDiseaseName);
		int minAge2 = aDisease.getMinAge();
		int maxAge2 = aDisease.getMaxAge();
		String statusCondition2 = aDisease.getStatusCondition();
		Vector subDiseases = aDisease.getSubDiseases();
		for (int k = 0; k < subDiseases.size(); k++) 
		    theDiseases.addElement(subDiseases.elementAt(k));
		gender = aDisease.getGenderSpecificity();
		if ( gender.equals(LR.male) )
		    female = false;
		else
		if ( gender.equals(LR.female) )
		    male = false;
		else { // we find a disease that is NOT gender specific, thus the symptom 
		       // is not gender specific regarding the diseases it is occurring in
		    female = false;
		    male = false;
		}
		if ( minAge2 < minAge ) minAge = minAge2;
		if ( maxAge < maxAge2 ) maxAge = maxAge2;
		if ( statusCondition2.equals("none") ) { none = true; continue; }
		if ( statusCondition2.equals("premenstruating") ) { premenstruating = true; continue; }
		if ( statusCondition2.equals("menstruating") ) { menstruating = true; continue; }
		if ( statusCondition2.equals("pregnant") ) { pregnant = true; continue; }
		if ( statusCondition2.equals("menopause") ) { menopause = true; continue; }
		if ( statusCondition2.equals("postmenopause") ) { postmenopause = true; continue; }
	    }
	    // none = ( !male && ! female );
	    // adjust in symptom minAge, maxAge, statusCondition ...
	    symptom.setMinAge(minAge);
	    // if (0 < minAge) System.out.println("** Symptom: " + symp + " minAge: " + minAge);
	    symptom.setMaxAge(maxAge);
	    // if (maxAge < LR.maxAge) System.out.println("** Symptom: " + symp + " maxAge: " + maxAge);
	    // narrow down statusCondition if warranted
	    if ( female ) {
		if ( none ) { 
		    symptom.setStatusCondition("none");
		}
		else
		if ( premenstruating && !menstruating && !pregnant && !menopause && !postmenopause ) {
		    symptom.setStatusCondition("premenstruating");
		}
		else
		if ( !premenstruating && menstruating && !pregnant && !menopause && !postmenopause ) {
		    symptom.setStatusCondition("menstruating");
		}
		else
		if ( !premenstruating && !menstruating && pregnant && !menopause && !postmenopause ) {
		    symptom.setStatusCondition("pregnant");
		}
		else
		if ( !premenstruating && !menstruating && !pregnant && menopause && !postmenopause ) {
		    symptom.setStatusCondition("menopause");
		}
		else
		if ( !premenstruating && !menstruating && !pregnant && !menopause && postmenopause ) {
		    symptom.setStatusCondition("postmenopause");
		}
	    }
	    /*
	      String statusCondition = symptom.getStatusCondition();
	      if ( !statusCondition.equals("none") ) 
	          System.out.println("** Symptom: " + symp + " statusCondition: " + statusCondition);
	    */
	    /*
	      Flag symptoms that occur only in one diseases (unless that disease itself has only 
	      one symptom).  A cardinal symptom (as defined  by InitSymptom) will NOT be flagged
	      as skippable.  Flagged symptoms will be ignored by DiagStart.
	      Hence the pull down lists in DiagStart will NOT contain the "esoteric"
	      flagged symptoms  */
	    if ( 1 == theDiseases.size() ) {
		aDiseaseName = (String) theDiseases.elementAt(0);
		aDisease = Common.getDisease(aDiseaseName);
		Vector itsSymptoms = aDisease.getSymptoms();
		if ( 1 < itsSymptoms.size() ) { 
		    // symptom.setOccursOnce(true);
		    symptom.setSkip();
		}
	    }

	    if ( female ) {
		femaleSymptoms.add(symp);
		continue;
	    }
	    if ( male ) {
		maleSymptoms.add(symp);
		continue;
	    }

	    locationSt = symptom.getLocationSt();
	    if ( locationSt.equals("body") ) {
		maleSymptoms.add(symp);
		femaleSymptoms.add(symp);
		continue;
	    }
	    location = (PartOfLocation) Common.getLocation(locationSt);
	    gender = location.getGender();
	    if ( gender.equals(LR.male) ) {
		maleSymptoms.add(symp);
		continue;
	    }
	    if ( gender.equals(LR.female) ) {
		femaleSymptoms.add(symp);
		continue;
	    }
	    maleSymptoms.add(symp);
	    femaleSymptoms.add(symp);
	}
	IO.saveHashSet(D.maleSymptoms, maleSymptoms);
	System.out.println("****** |maleSymptoms| = " + maleSymptoms.size());
	IO.saveHashSet(D.femaleSymptoms, femaleSymptoms);
	System.out.println("****** |femaleSymptoms| = " + femaleSymptoms.size());

	// Construct a list of common symptoms
	String[] commonSymptoms = {
	    "abdomenPain", "anklePain", "anorexia", "anxiety", 
	    "backPain", "bleedingFromNose", "breathingDifficult", 
	    "chestPain", "chills", "constipation", "cough", "crackles", "cyanosis", 
	    "diarrhea", "dizziness", "dyspnea", "dysphagia",
	    "edema",
	    "fainting", "fatigue", "feetPain", 
	    "gas", "hairLoss", "headache",
	    "heartburn", "hiccups", "hipPain", "hypotension", 
	    "irritability", 
	    "jaundice", "jointPain", "kneePain", 
	    "legPain", "lethargy", "lowBackPain", 
	    "malaise", "moodSad", "myalgia", 
	    "nausea", "neckPain", 
	    "rash", 
	    "seizure", "shoulderPain", "skinDiscoloration", "skinInfection", 
	    "skinLesionDryScaly", "sleepDisturbed", "sneezing", 
	    "tachycardia", "tachypnea", "tinnitus", "throatSore",
	    "urinaryFrequency", 
	    "vertigo", "vomiting", 
	    "weakness", "weightLoss"
	};
	lng = commonSymptoms.length;
	Vector symptoms = new Vector();
	for ( int i = 0; i < lng; i++ )
	    symptoms.addElement(Common.getSymptom(commonSymptoms[i]));
	Collections.sort(symptoms, new SymComp());
	Vector commonSymptomNames = new Vector();
	for ( int i = 0; i < lng; i++ ) 
	    commonSymptomNames.addElement( ((Symptom) symptoms.elementAt(i)).getName() );
	IO.saveVector(D.commonSymptomNames, commonSymptomNames);
	System.out.println("****** |commonSymptomNames| = " + commonSymptomNames.size());
    } // end CreateMaleFemaleSymptoms()

    static public void CreateMaleFemaleDiseases() {
	String [] allDiseases = Common.allDiseases();
	int lng = allDiseases.length;
	HashSet maleDiseases = new HashSet();
	HashSet femaleDiseases = new HashSet();
	// String symp, locationSt, gender;
	// Disease disease;
	// int numberOfDiseases;
	// PartOfLocation location;
	String disName;
	Vector weightedSymptoms;
	int numberOfSymptoms;
	WeightedSymptom ws;
	Disease disease;
	String gender;
	String symp;
	HashSet maleSymptoms = Common.allMaleSymptoms();
	HashSet femaleSymptoms = Common.allFemaleSymptoms();
	for (int i = 0; i<lng; i++) {
	    disName = allDiseases[i];
	    /*
	      if ( check-1 <= i && i <= check+1 ) 
	      System.out.println("^^^ i= " + i + " " + disName + 
	                         " #male= " + maleDiseases.size() +
			         " #female= " + femaleDiseases.size());
	    */
	    disease = Common.getDisease(disName);
	    if ( disease.isSuperDisease() ) continue; // ignore these
	    weightedSymptoms = disease.getSymptoms();
	    numberOfSymptoms = weightedSymptoms.size();
	    if ( numberOfSymptoms <= 0 ) continue; // ignore these
	    gender = disease.getGenderSpecificity();
	    // check also that the symptoms have the proper gender
	    if ( gender.equals(LR.male) ) {
		maleDiseases.add(disName);
		for (int j = 0; j<numberOfSymptoms; j++) {
		    ws = (WeightedSymptom) weightedSymptoms.elementAt(j);
		    symp = ws.getSymptom();
		    if ( !maleSymptoms.contains(symp) )
			System.out.println("*** Gender mismatch: " + symp + " " + disName + " ****");
		}
		continue;
	    }
	    if ( gender.equals(LR.female) ) {
		femaleDiseases.add(disName);
		for (int j = 0; j<numberOfSymptoms; j++) {
		    ws = (WeightedSymptom) weightedSymptoms.elementAt(j);
		    symp = ws.getSymptom();
		    if ( !femaleSymptoms.contains(symp) )
			System.out.println("*** Gender mismatch: " + symp + " " + disName + " ****");
		}
		continue;
	    }
	    maleDiseases.add(disName);
	    femaleDiseases.add(disName);
	}
	IO.saveHashSet(D.maleDiseases, maleDiseases);
	System.out.println("****** |maleDiseases| = " + maleDiseases.size());
	IO.saveHashSet(D.femaleDiseases, femaleDiseases);
	System.out.println("****** |femaleDiseases| = " + femaleDiseases.size());
    }

    static public void procAddIndices(StringBuffer sb, boolean addEntry) {

	  Hashtable indexWords = getHashtable(D.indexWords);
	  int indexWordsSize = indexWords.size();
	  
	  int changeCnt = 0;
	  String description;
	  
	  String [] allSymptoms = Common.allSymptoms();
	  int lngSymptoms = allSymptoms.length;
	  String symptom;
	  Symptom sym;
	  for (int i = 0; i < lngSymptoms; i++) {
	      symptom = allSymptoms[i];
	      sym = Common.getSymptom(symptom);
	      description = sym.getDescription();
	      changeCnt = processDescription(
		 description, indexWords, changeCnt, sb, symptom, addEntry);
	      description = sym.getPrintName();
	      changeCnt = processDescription(
		 description, indexWords, changeCnt, sb, symptom, addEntry);
	  }

	  String [] allBodySystems = Common.allBodySystems();
	  int lngBodySystems = allBodySystems.length;
	  String bodySystem;
	  BodySystem bs;
	  for (int i = 0; i < lngBodySystems; i++) {
	      bodySystem = allBodySystems[i];
	      bs = Common.getBodySystem(bodySystem);
	      description = bs.getDescription();
	      changeCnt = processDescription(
		 description, indexWords, changeCnt, sb, bodySystem, addEntry);
	      description = bs.getPrintName();
	      changeCnt = processDescription(
		 description, indexWords, changeCnt, sb, bodySystem, addEntry);
	  }

	  String [] allDiseases = Common.allDiseases();
	  int lngDiseases = allDiseases.length;
	  String disease;
	  Disease dis;
	  for (int i = 0; i < lngDiseases; i++) {
	      disease = allDiseases[i];
	      dis = Common.getDisease(disease);
	      description = dis.getDescription();
	      changeCnt = processDescription(
		 description, indexWords, changeCnt, sb, disease, addEntry);
	      description = dis.getPrintName();
	      changeCnt = processDescription(
		 description, indexWords, changeCnt, sb, disease, addEntry);
	  }

	  if ( 0 < changeCnt ) {
	      Common.setTheXWordsSaved(false);
	      Common.saveTheXWords();
	  } 
	  
	  if ( indexWords.size() < indexWordsSize ) {
	      sb.append("\n \n Saving decreased indexWords\n ");
	      boolean ok = saveHashtable("indexWords", indexWords);
	      sb.append("Saving succeeded: " + ok + "\n");
	  }
	  
	  sb.append("\n \n References changeCnt: " + changeCnt);

      } // end procAddIndices(StringBuffer sb)

  static private int processDescription(
           String description,
	   Hashtable indexWords,
	   int changeCnt,
	   StringBuffer sb,
	   String symptom,
	   boolean addEntry) {

	StringTokenizer st = new StringTokenizer(description);
	String token, type;
	XWordNormal xwn = null;
	while ( st.hasMoreTokens() ) {
	  token = st.nextToken();
	  token = stripToken(token);
	  if ( indexWords.containsKey(token) ) { 
	    try { xwn = (XWordNormal) Common.getXWord(token); }
	    catch (ClassCastException ignore) { continue; }
	    if ( null == xwn ) 
	      xwn = new XWordNormal(token, "unknown");
	    else {
	      type = xwn.getType();
	      if ( !type.equals("unknown") ) {
		sb.append("\n*** Removing: " + token);
		indexWords.remove(token);
		continue;
	      }
	    }
	    if ( xwn.isReferenced(symptom) ) continue;
	    changeCnt++;
	    if ( addEntry) sb.append("\n Add: " + symptom + " to: " + token);
	    xwn.checkAddReference(symptom);
	  }
	}
	return changeCnt;
  } // end processDescription(...)

  static public Hashtable getHashtable(String htName) {
    return IO.readOrCreateHT(htName);
  }
  static public boolean saveHashtable(String htName, Hashtable ht) {
    return IO.saveHT(htName, ht);
  }
  
  static public String stripToken(String token) {
    boolean again = true;
    int lng;
    while (again) {
      lng = token.length() -1;
            if ( token.startsWith("(") ) token = token.substring(1); else
            if ( token.startsWith("\"") ) token = token.substring(1); else
	    if ( token.startsWith("'") ) token = token.substring(1); else
	    if ( token.endsWith(",") ) token = token.substring(0, lng); else
	    if ( token.endsWith(")") ) token = token.substring(0, lng); else
	    if ( token.endsWith("?") ) token = token.substring(0, lng); else
	    if ( token.endsWith("/") ) token = token.substring(0, lng); else
	    if ( token.endsWith(":") ) token = token.substring(0, lng); else
	    if ( token.endsWith(".") ) token = token.substring(0, lng); else
	    if ( token.endsWith(";") ) token = token.substring(0, lng); else
	    if ( token.endsWith("\"") ) token = token.substring(0, lng); else
	    if ( token.endsWith("'") ) token = token.substring(0, lng); else
	    again = false;
    }
    return token;
  }

    static public void CreateMaleFemaleLocations() {
	String [] allLocations = Common.allLocations();
	int lng = allLocations.length;
	HashSet maleLocations = new HashSet();
	HashSet femaleLocations = new HashSet();
	for ( int i = 0; i < lng; i++ ) {
	    String locStr = allLocations[i];
	    Location loc = Common.getLocation(locStr);
	    String gender = loc.getGender();
	    if ( gender.equals(LR.male) ) 
		maleLocations.add(locStr);
	    else
	    if ( gender.equals(LR.female) ) 
		femaleLocations.add(locStr);
	    else {
		maleLocations.add(locStr);
		femaleLocations.add(locStr);
	    }
	}
	IO.saveHashSet(D.maleLocations, maleLocations);
	System.out.println("****** |maleLocations| = " + maleLocations.size());
	IO.saveHashSet(D.femaleLocations, femaleLocations);
	System.out.println("****** |femaleLocations| = " + femaleLocations.size());
 
    }

    static public void CreateLocationHierarchy() {
	Vector locationHierarchy = new Vector();
	listBodyLocations(locationHierarchy, LR.bodySt, 0, new HashSet());
	IO.saveVector(D.locationHierarchy, locationHierarchy);
	System.out.println("****** |locationHierarchy| = " + locationHierarchy.size());
    }
    static public void CreateHeadHierarchy() {
	Vector locationHierarchy = new Vector();
	listBodyLocations(locationHierarchy, LR.headSt, 0, new HashSet());
	IO.saveVector(D.headHierarchy, locationHierarchy);
	System.out.println("****** |headHierarchy| = " + locationHierarchy.size());
    }
    static public void CreateNeckHierarchy() {
	Vector locationHierarchy = new Vector();
	listBodyLocations(locationHierarchy, LR.neckSt, 0, new HashSet());
	IO.saveVector(D.neckHierarchy, locationHierarchy);
	System.out.println("****** |neckHierarchy| = " + locationHierarchy.size());
    }
    static public void CreateChestHierarchy() {
	Vector locationHierarchy = new Vector();
	listBodyLocations(locationHierarchy, LR.chestSt, 0, new HashSet());
	IO.saveVector(D.chestHierarchy, locationHierarchy);
	System.out.println("****** |chestHierarchy| = " + locationHierarchy.size());
    }
    static public void CreateAbdomenHierarchy() {
	Vector locationHierarchy = new Vector();
	listBodyLocations(locationHierarchy, LR.abdomenSt, 0, new HashSet());
	IO.saveVector(D.abdomenHierarchy, locationHierarchy);
	System.out.println("****** |abdomenHierarchy| = " + locationHierarchy.size());
    }
    static public void CreateGenitaliaHierarchy() {
	Vector locationHierarchy = new Vector();
	listBodyLocations(locationHierarchy, LR.genitaliaSt, 0, new HashSet());
	IO.saveVector(D.genitaliaHierarchy, locationHierarchy);
	System.out.println("****** |genitaliaHierarchy| = " + locationHierarchy.size());
    }
    static public void CreateArmsHierarchy() {
	Vector locationHierarchy = new Vector();
	listBodyLocations(locationHierarchy, LR.armsSt, 0, new HashSet());
	IO.saveVector(D.armsHierarchy, locationHierarchy);
	System.out.println("****** |armsHierarchy| = " + locationHierarchy.size());
    }    
    static public void CreateLegsHierarchy() {
	Vector locationHierarchy = new Vector();
	listBodyLocations(locationHierarchy, LR.legsSt, 0, new HashSet());
	IO.saveVector(D.legsHierarchy, locationHierarchy);
	System.out.println("****** |legsHierarchy| = " + locationHierarchy.size());
    }

    static public void CreateMiscHierarchy() {
	Vector locationHierarchy = new Vector();
	HashSet locs = new HashSet();
	listBodyLocations(locationHierarchy, LR.skinSt, 0, locs);
	listBodyLocations(locationHierarchy, LR.backSt, 0, locs);
	listBodyLocations(locationHierarchy, LR.jointsSt, 0, locs);
	listBodyLocations(locationHierarchy, LR.aMuscleSt, 0, locs);
	listBodyLocations(locationHierarchy, LR.spineSt, 0, locs);
	listBodyLocations(locationHierarchy, LR.groinSt, 0, locs);
	listBodyLocations(locationHierarchy, LR.digitsSt, 0, locs);
	IO.saveVector(D.miscHierarchy, locationHierarchy);
	System.out.println("****** |miscHierarchy| = " + locationHierarchy.size());
    }

    static private void listBodyLocations(Vector out, 
				   String locStr, int level, HashSet locs) {
	if ( locs.contains(locStr) ) return;
	Location loc = Common.getLocation(locStr);
	if ( null == loc ) {
	    System.out.println("**** locStr empty: " + locStr);
	    return;
	}
	if ( loc instanceof PartLocation ) { // to bypass "body"
	    PartLocation locPart = (PartLocation) loc;
	    Vector vec = locPart.getMemberships();
	    int lng = vec.size();
	    if ( 1 < lng ) 
		// it is a member of a set thus
		// postpone dealing with this location
		return;
	    if ( 1 == lng ) {
		String vec0 = (String) vec.elementAt(0);
		if ( !vec0.equals(LR.mucousMembranesSt) )
		    // same story, but we DO handle elements of 
		    // mucousMembranesSt, because it is a secondary grouping
		    return;
	    }
	    // we are here because loc is at most a member of mucousMembranesSt
	}
	listIt(out, locStr, level, locs, loc);
    }
    static private void listBodyLocations2(Vector out, 
				   String locStr, int level, HashSet locs) {
	if ( locs.contains(locStr) ) return;
	Location loc = Common.getLocation(locStr);
	if ( null == loc ) {
	    System.out.println("**** locStr empty: " + locStr);
	    return;
	}
	listIt(out, locStr, level, locs, loc);
    }
    static private void listIt(Vector out, String locStr, int level, 
			       HashSet locs, Location loc) {
	locs.add(locStr);

	String printName = replaceSpace(loc.getPrintName());
	Vector symptoms = loc.getSymptoms();

	LHE lhe = new LHE(locStr, printName,
			  loc.getGender(), symptoms, level);
	out.addElement(lhe);

	// look at parts
	int level2 = level + 1;
	Vector parts = loc.getParts();
	int lng = parts.size();
	for (int i = 0; i < lng; i++) 
	    listBodyLocations(out,
			      (String) parts.elementAt(i),
			      level2, locs);
	if ( !(loc instanceof LocationSet ) ) return;

	// we have set!
	LocationSet ls = (LocationSet) loc;
	parts = ls.getMembers();
	lng = parts.size();
	for (int i = 0; i < lng; i++) 
	    // do NOT test anymore the elements for membership 
	    listBodyLocations2(out,
			      (String) parts.elementAt(i),
			      level2, locs);
	// check for subsets
	parts = ls.getSubsets();
	lng = parts.size();
	for (int i = 0; i < lng; i++) 
	    listBodyLocations(out,
			      (String) parts.elementAt(i),
			      level2, locs);
    } // end listBodyLocations

  static public String replaceSpace(String in) {
    int ix = in.indexOf(' ');
    if ( ix < 0 ) return in;
    return replaceSpace(
	in.substring(0, ix) + 
	"&nbsp;" +
	in.substring(ix+1) );
  }

} // end of InitAll

