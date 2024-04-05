// (C) OntoOO/ Dennis de Champeaux 2000/ 2011
package concepts;

import java.net.URLEncoder;
import java.util.*;
import java.io.*;
import com.Common;
import com.LR;
import com.L;
import com.D;

public class Disease extends Condition implements Serializable {

  // private String name;
  private String superDisease = null; // ako superclass !
  private Vector subDiseases = new Vector();
  private float defaultTemperature = (float) 99.3;
  private float setTemperature = (float) 0.0; 
  private float inheritedTemperature = (float) 0.0; 
  // private boolean temperatureSet = false;
  private String genderSpecificity; // none | male | female | moreMale | moreFemale
  private String raceSpecificity; // none | africanAmerican | ...
  private int minAge; // under bound of typical age
  private int maxAge; // upper bound of typical age
  // statusCondition 
  // gender neutral disease: none
  //   female = premenstruating | menstruating | pregnant | menopause | postmenopause
  //   male = none
  private String statusCondition = "none"; 
  // typical duration (in days)
  // 0 critically acute
  // -1 for chronic
  // -2 less than a day
  // -3 less than a week
  // -4 less than a month
  // -5 less than three months
  // -6 less than six months
  // -7 less than a year
  // -10 unknown
  // -11 NA
  private int duration; 
  private int frequency; // # incidences in 10^6/ year  | -1 unknown
  private String bodySystem;
  private String underlyingDisease = null;
  private Vector symptoms = new Vector(); // Symptom elements
  private float maxRate = -1;
    // private Vector phases = new Vector(); // DiseasePhase elements | null
  private Vector treatments = new Vector(); // Treatment elements
  // external causes: 
  //  none | trauma | infection | genetic | unknown | several | lifeStyle
  private Vector externalCauses = new Vector(); // String descriptions
  private Vector internalCauses = new Vector(); // upstream Disease elements
  // AC are ako diseases but without symptom characterizations
  private Vector causingAbnormalConditions = new Vector(); // AC elements
  private Vector causesDiseases = new Vector(); // downstream Disease elements
  private Vector causesAbnormalConditions = new Vector(); // AC elements
  private String miscComments = null;
  // String refs to: books, articles, urls 
  private Vector literature = new Vector(); 
  private Vector causingSets = new Vector(); 
  private String diseaseSet;
  private boolean lifeThreatening = false;
  // none     = no inheritance known | not relevant
  // 1parent  = at least on parent had the disease
  // 2parents = both parents has/had the disease
  // father   = the father has/had the disease
  // mother   = the mother has/had the disease
  private String genetic = "none"; // none|1parent|2parents|father|mother
  private String parentDisease = null; // != null if genetic != none
  private Vector illustrations = new Vector(); 
  private int code358 = 0;
  private String ICD10code = null;

  public Disease (
		  String name,
		  String description,
		  String diseaseSet,
		  String genderSpecificity,
		  String raceSpecificity,
		  int minAge,
		  int maxAge,
		  int duration,
		  int frequency,
		  String bodySystem,
		  String externalCause
		   ) {
    super(name, description, null); // location is set at the end ... 
    this.genderSpecificity = genderSpecificity;
    this.raceSpecificity = raceSpecificity;
    this.minAge = minAge;
    this.maxAge = maxAge;
    this.duration = duration;
    this.frequency = frequency;
    this.bodySystem = bodySystem;
    // externalCauses.addElement(externalCause);
    addExternalCause(externalCause);  // one of possibly more
    this.diseaseSet = diseaseSet;
    DiseaseSet dis = Common.getDiseaseSet(diseaseSet);
    dis.addDiseaseMember(name);
    Common.addDisease(this);
    BodySystem bs = Common.getBodySystem(bodySystem);
    bs.addDisease(name);
    locationSt = bs.getLocationName(); // ... in the Condition superclass 
  } // end Disease( ... )

  //  public String getName() { return name; }
  public boolean isSuperDisease() { return (0 < subDiseases.size()); }
  public String getSuperDisease() { return superDisease; }
  public Vector getSubDiseases() { return subDiseases; }
  public float getTemperature0() { 
    return ( 0.0 < setTemperature ? setTemperature : defaultTemperature );
  }
  public float getTemperature() {
    if (  0.0 < setTemperature ) return setTemperature;
    if (  0.0 < inheritedTemperature ) return inheritedTemperature;
    if (  null == superDisease ) return defaultTemperature;
    Disease sd = Common.getDisease(superDisease);
    inheritedTemperature = sd.getTemperature();
    return inheritedTemperature;
  }
  public String getGenderSpecificity() { return genderSpecificity; }
  public String getRaceSpecificity() { return raceSpecificity; } 
  public int getMinAge() { return minAge; }
  public int getMaxAge() { return maxAge; }
  public String getStatusCondition() { return statusCondition; }
  public void setStatusCondition(String sc) { statusCondition = sc; }
  public int getDuration() { return duration; }
  public int getFrequency() { return frequency; }
  public String getBodySystem() { return bodySystem; }
  public String getUnderlyingDisease0() { return underlyingDisease; }
  public String getUnderlyingDisease() {
    if ( null != underlyingDisease ) return underlyingDisease;
    if ( null == superDisease ) return null;
    Disease sd = Common.getDisease(superDisease);
    return sd.getUnderlyingDisease();
  }
  public Vector getSymptoms0() { return symptoms; }
  private Vector allSymptoms = null;
  public Vector getSymptoms() { 
    if ( null == superDisease ) return symptoms;
    if ( allSymptoms != null ) return allSymptoms;
    Disease sd = Common.getDisease(superDisease);
    Vector vec = sd.getSymptoms(); // symptoms of super
    int lng = vec.size();
    if ( lng <= 0 ) {
      allSymptoms = symptoms;
      return symptoms;
    }
    allSymptoms = (Vector) symptoms.clone();
    WeightedSymptom ws, ws2;
    String symp;
    for (int i=0; i<lng; i++) {
      ws = (WeightedSymptom) vec.elementAt(i);
      symp = ws.getSymptom();
      ws2 =  getWeightedSymptom(symp, symptoms);
      if ( null == ws2 ) allSymptoms.addElement(ws);
    }
    return allSymptoms;
  }
  public float getMaxRate() {
    if ( 0 <= maxRate ) return maxRate;
    float out = 0;
    Vector vec = getSymptoms();
    int lng = vec.size();
    WeightedSymptom ws;
    for (int i=0; i<lng; i++) {
      ws = (WeightedSymptom) vec.elementAt(i);
      out = out + ws.getWeight();
    }
    maxRate = out;
    return out;
  }
    // public Vector getPhases() { return phases; }
  public Vector getTreatments0() { return treatments; }
  private Vector allTreatments = null;
  public Vector getTreatments() { 
    if ( null == superDisease ) return treatments;
    if ( allTreatments != null ) return allTreatments;
    Disease sd = Common.getDisease(superDisease);
    Vector vec = sd.getTreatments();
    if ( vec.size() <= 0 ) {
      allTreatments = treatments;
      return treatments;
    }
    vec = (Vector) vec.clone();
    for (int i=0; i<treatments.size(); i++) 
      vec.addElement(treatments.elementAt(i));
    allTreatments = vec;
    return vec;
  }
  public Vector getExternalCauses0() { return externalCauses; }
  private Vector allExternalCauses = null;
  public Vector getExternalCauses() { 
    if ( null == superDisease ) return externalCauses;
    if ( allExternalCauses != null ) return allExternalCauses;
    Disease sd = Common.getDisease(superDisease);
    Vector vec = sd.getExternalCauses();
    if ( vec.size() <= 0 ) {
      allExternalCauses = externalCauses;
      return externalCauses;
    }
    vec = (Vector) vec.clone();
    String str;
    for (int i=0; i<externalCauses.size(); i++) {
      str = (String) externalCauses.elementAt(i);
      if ( str.equals("none") ) continue;
      if ( vec.indexOf(str) < 0 ) vec.addElement(str);
    }
    allExternalCauses = vec;
    return vec;
  }
  public Vector getInternalCauses0() { return internalCauses; }
  private Vector allInternalCauses = null;
  public Vector getInternalCauses() { 
    if ( null == superDisease ) return internalCauses;
    if ( allInternalCauses != null ) return allInternalCauses;
    Disease sd = Common.getDisease(superDisease);
    Vector vec = sd.getInternalCauses();
    if ( vec.size() <= 0 ) {
      allInternalCauses = internalCauses;
      return internalCauses;
    }
    vec = (Vector) vec.clone();
    String str;
    for (int i=0; i<internalCauses.size(); i++) {
      str = (String) internalCauses.elementAt(i);
      if ( vec.indexOf(str) < 0 ) vec.addElement(str);
    }
    allInternalCauses = vec;
    return vec;
  }
  private Vector allCausingAbnormalConditions = null;
  public Vector getCausingAbnormalConditions0() { 
    return causingAbnormalConditions; }
  public Vector getCausingAbnormalConditions() { 
    if ( null == superDisease ) return causingAbnormalConditions;
    if ( allCausingAbnormalConditions != null ) return allCausingAbnormalConditions;
    Disease sd = Common.getDisease(superDisease);
    Vector vec = sd.getCausingAbnormalConditions();
    if ( vec.size() <= 0 ) {
      allCausingAbnormalConditions = causingAbnormalConditions;
      return causingAbnormalConditions;
    }
    vec = (Vector) vec.clone();
    String str;
    for (int i=0; i<causingAbnormalConditions.size(); i++) {
      str = (String) causingAbnormalConditions.elementAt(i);
      if ( vec.indexOf(str) < 0 ) vec.addElement(str);
    }
    allCausingAbnormalConditions = vec;
    return vec;
  }
  public Vector getCausesDiseases0() { return causesDiseases; }
  private Vector allCausesDiseases = null;
  public Vector getCausesDiseases() { 
    if ( null == superDisease ) return causesDiseases;
    if ( allCausesDiseases != null ) return allCausesDiseases;
    Disease sd = Common.getDisease(superDisease);
    Vector vec = sd.getCausesDiseases();
    if ( vec.size() <= 0 ) {
      allCausesDiseases = causesDiseases;
      return causesDiseases;
    }
    vec = (Vector) vec.clone();
    String str;
    for (int i=0; i<causesDiseases.size(); i++) {
      str = (String) causesDiseases.elementAt(i);
      if ( vec.indexOf(str) < 0 ) vec.addElement(str);
    }
    allCausesDiseases = vec;
    return vec;
  }
  public Vector getCausesAbnormalConditions0() { return causesAbnormalConditions; }
  private Vector allCausesAbnormalConditions = null;
  public Vector getCausesAbnormalConditions() { 
    if ( null == superDisease ) return causesAbnormalConditions;
    if ( allCausesAbnormalConditions != null ) return allCausesAbnormalConditions;
    Disease sd = Common.getDisease(superDisease);
    Vector vec = sd.getCausesAbnormalConditions();
    if ( vec.size() <= 0 ) {
      allCausesAbnormalConditions = causesAbnormalConditions;
      return causesAbnormalConditions;
    }
    vec = (Vector) vec.clone();
    String str;
    for (int i=0; i<causesAbnormalConditions.size(); i++) {
      str = (String) causesAbnormalConditions.elementAt(i);
      if ( vec.indexOf(str) < 0 ) vec.addElement(str);
    }
    allCausesAbnormalConditions = vec;
    return vec;
  }

  public String getMiscComments() { return miscComments; }
  public Vector getLiterature() { return literature; }
  public Vector getCausingSets() { return causingSets; }
  public String getDiseaseSet() { return diseaseSet; }
  public boolean isLifeThreatening() { return lifeThreatening; }
  public String getGenetic() { return genetic; }
  public String getParentDisease() { return parentDisease; }

  private Vector allIllustrations = null;
  public Vector getIllustrations() { 
      if ( null == allIllustrations )
	  allIllustrations = setAllIllustrations();
      return allIllustrations; 
  }
  private Vector setAllIllustrations() {
      if ( null == superDisease ) return illustrations;
      Disease dis = Common.getDisease(superDisease);
      Vector vec = dis.getIllustrations();
      int lng = vec.size();
      for ( int i = 0; i < lng; i++ )
	  illustrations.addElement(vec.elementAt(i));
      return illustrations;
  }
  private int numberOfIllustrations() { return getIllustrations().size(); }

  public void setTemperature(float temp) { 
    setTemperature = temp; 
  }

  public void setUnderlyingDisease(String disease) {
    underlyingDisease = disease;
    // underlyingDiseaseIsDetermined = true;
  }
  public void addSubDisease(String subDisease) {
    if ( !subDiseases.contains(subDisease) ) 
      subDiseases.addElement(subDisease);
  }
  public void setSuperDisease(String superDisease) { 
      this.superDisease = superDisease;
      Disease dis = Common.getDisease(superDisease);
      dis.addSubDisease(name);
  }

  public void addSymptom(String symptom) { // symptom is the name of a Symptom
    addSymptom(symptom, "", 1.0f);
  }
  public WeightedSymptom getWeightedSymptom(String symptom) {
    return getWeightedSymptom(symptom, getSymptoms());
  }
  private WeightedSymptom getWeightedSymptom(String symptom, Vector vec) {
    WeightedSymptom wsymp;
    int lng = vec.size();
    for (int i = 0; i<lng; i++) {
      wsymp = (WeightedSymptom) vec.elementAt(i);
      if ( symptom.equals(wsymp.getSymptom()) ) { return wsymp; }
    }
    return null;
  }
  public void addSymptom(String symptom, String elaboration, float weight) {
      //    deleteSymptom(symptom);
      if ( null == getWeightedSymptom(symptom, symptoms) ) {
	  symptoms.addElement(new WeightedSymptom(symptom, elaboration, weight));
	  Symptom sym = Common.getSymptom(symptom);
	  sym.addDisease(name);
      }
  }

    /*
  public void addPhase(DiseasePhase phase) {
    phases.addElement(phase);
  }
  public void deletePhase(DiseasePhase phase) {
    phases.removeElement(phase);
  }
    */

  public void addTreatment(String treatment) {
    treatments.addElement(treatment);
  }
  public void deleteTreatment(String treatment) {
    treatments.removeElement(treatment);
  }
  public void addExternalCause(String str) {
    if ( str.equals("none") ) return;
    int j = externalCauses.indexOf(LR.none);
    if ( 0 <= j ) externalCauses.remove(j);
    if ( externalCauses.indexOf(str) < 0 ) {
      // Common.println("*****: " + str + " " + name);
      externalCauses.addElement(str);
      ExternalCause ec = Common.getExternalCause(str);
      if ( null == ec ) ec = new ExternalCause(str);
      // Common.insertECDisease(str, name);
      ec.addCausesDisease(name); 
      // ec.printExternalCause();
    }
  }
  public void addInternalCause(String disease) {
    if ( internalCauses.indexOf(disease) < 0 ) 
      internalCauses.addElement(disease);
  }
  public void deleteInternalCause(String disease) {
    internalCauses.removeElement(disease);
  }
  public void addCausingAbnormalCondition(String abnormalCondition) { 
    // abnormalCondition is the name of a AbnormalCondition
    if ( causingAbnormalConditions.indexOf(abnormalCondition) < 0 ) {
      causingAbnormalConditions.addElement(abnormalCondition);
      // Common.insertDisease(abnormalCondition, this);
      AbnormalCondition ac = Common.getAbnormalCondition(abnormalCondition);
      ac.addCausesDisease(name);
    } 
  }

  public void addCausesDisease(String disease) {
    if ( causesDiseases.indexOf(disease) < 0 ) {
      causesDiseases.addElement(disease);
    }
  }
  public void deleteCausesDisease(String disease) {
    causesDiseases.removeElement(disease);
  }
  public void addCausesAbnormalCondition(String abnormalCondition) { 
    // abnormalCondition is the name of a AbnormalCondition
    if ( causesAbnormalConditions.indexOf(abnormalCondition) < 0 ) {
      causesAbnormalConditions.addElement(abnormalCondition);
      // Common.insertDisease(abnormalCondition, this);
      AbnormalCondition ac = Common.getAbnormalCondition(abnormalCondition);
      ac.addCausedByDisease(name);
    } 
  }

  public void setMiscComments(String comments) { miscComments = comments; }
  public void addReference(String reference) {
    literature.addElement(reference);
  }
  public void deleteReference(String reference) {
    literature.removeElement(reference);
  }

  public void addCausingSet(String diseasesSet) { 
    causingSets.addElement(diseasesSet); 
  }

  public void setLifeThreatening(boolean val) {
    lifeThreatening = val;
  }

  public void setGenetic(String val) {
    genetic = val; // none|1parent|2parents|father|mother
  }

  public void setParentDisease(String val) {
    parentDisease = val; 
  }

  public void setPrintName(String namex) { 
	printName = namex; 
	if ( name.equals(printName) ) return;
	String name2 = Common.eliminateSpace(printName);
	if ( name.equals(name2) ) return;
	// Common.println("Disease name: " + name + " name2: " + name2);
	Common.addXWord(name2, "synonym");
	boolean isNormal = printName.indexOf(' ') < 0;
	if ( isNormal ) {
	    XWordNormal xwn = (XWordNormal) Common.getXWord(name2);
	    xwn.setSynonym(name);
	} else {
	    XWordPolish xwp = (XWordPolish) Common.getXWord(name2);
	    xwp.setSynonym(name);
	}
    }

  public void addIllustration(String illustration) { 
    illustrations.addElement(illustration); 
  }

  public void setCode358(int c) { code358 = c; }
  public int getCode358() { return code358; }
  public void setICD10code(String s) { ICD10code = s; }
  public String getICD10code() { return ICD10code; } 

  public void printDisease() {
    Common.println("");
    Common.println("Disease: ");
    super.printCondition();
    if (null != superDisease) Common.println("Super disease: " + superDisease);
    Common.println("diseaseSet: " + getDiseaseSet());    
    Common.println("temperature: " + getTemperature());    
    Common.println("genderSpecificity: " + genderSpecificity);    
    Common.println("raceSpecificity: " + raceSpecificity);
    Common.println("minAge: " + minAge + " maxAge: " + maxAge);
    Common.println("statusCondition: " + statusCondition);
    Common.println("duration: " + duration + " frequency: " + frequency);
    Common.println("bodySystem: " + bodySystem);
    String ud = getUnderlyingDisease();
    if (null != ud) Common.println("underlying disease: " + ud);
    String genetic = getGenetic();
    if ( !genetic.equals("none") ) { 
      Common.println("genetic: " + genetic);
      Common.println("parentDisease: " + parentDisease);
    }
    if (null != miscComments) Common.println("miscComments: " + miscComments);
    Vector vec = getSymptoms();
    int lng = vec.size();
    if ( 0<lng) {
      Common.println("Symptoms:");
      for (int i=0; i<lng; i++) 
	Common.println(((WeightedSymptom)vec.elementAt(i)).html());
    }
    Common.println("maxRate: " + maxRate);
    /*
    lng = phases.size();
    if ( 0<lng) {
      Common.println("Phases:");
      for (int i=0; i<lng; i++) Common.println((String)phases.elementAt(i));
    }
    */
    // printTreatments();
    vec = getTreatments();
    lng = vec.size();
    if ( 0<lng) {
      Common.println("Treatments for: " + name);
      for (int i=0; i<lng; i++) Common.println((String)vec.elementAt(i));
    }
    vec = getExternalCauses();
    lng = vec.size();
    if ( 0<lng) {
      Common.println("External Causes:");
      for (int i=0; i<lng; i++) Common.println((String)vec.elementAt(i));
    }
    vec = getInternalCauses();
    lng = vec.size();
    if ( 0<lng) {
      Common.println("InternalCauses:");
      for (int i=0; i<lng; i++) Common.println((String)vec.elementAt(i));
    }
    vec = getCausingSets();
    lng = vec.size();
    if ( 0<lng) {
      Common.println("CausingSets:");
      for (int i=0; i<lng; i++) Common.println((String)vec.elementAt(i));
    }
    vec = getCausingAbnormalConditions();
    lng = vec.size();
    if ( 0<lng) {
      Common.println("Causing Abnormal Conditions:");
      for (int i=0; i<lng; i++) Common.println((String)vec.elementAt(i));
    }
    vec = getCausesDiseases();
    lng = vec.size();
    if ( 0<lng) {
      Common.println("Causes Diseases:");
      for (int i=0; i<lng; i++) Common.println((String)vec.elementAt(i));
    }
    vec = getCausesAbnormalConditions();
    lng = vec.size();
    if ( 0<lng) {
      Common.println("Causes Abnormal Conditions/ Complications:");
      for (int i=0; i<lng; i++) Common.println((String)vec.elementAt(i));
    }
    lng = literature.size();
    if ( 0<lng) {
      Common.println("Literature:");
      for (int i=0; i<lng; i++) Common.println((String)literature.elementAt(i));
    }
    lng = illustrations.size();
    if ( 0<lng) {
      Common.println("Illustrations:");
      for (int i=0; i<lng; i++) Common.println((String)illustrations.elementAt(i));
    }
  }
  
  /*
  private void printTreatments() {
    if ( null != superDisease ) {
      Disease dis = Common.getDisease(superDisease);
      dis.printTreatments();
    }
    int lng = treatments.size();
    if ( 0<lng) {
      Common.println("Treatments for: " + name);
      for (int i=0; i<lng; i++) Common.println((String)treatments.elementAt(i));
    }
  }
  */

  public String html() {
    String underlyingDisease = getUnderlyingDisease();
    String genetic = getGenetic();
    Vector externalCauses = getExternalCauses();
    Vector causesAbnormalConditions = getCausesAbnormalConditions();
    int numberOfIllustrations = numberOfIllustrations();
    String treatmentResource = URLEncoder.encode(printName + " treatment");
    String wr1 = "http://search.yahoo.com/bin/search?p=" + treatmentResource;
    String wr2 = "http://www.google.com/search?q=" + treatmentResource;
    String wr = 
	  "<a href=\"" + wr1 + "\">Yahoo</a> | " +
	  "<a href=\"" + wr2 + "\">Google</a>";
    return 
	// "<br /><b>" + L.Disease + "</b> " + 
      super.html() + 
      ( lifeThreatening ? 
	"<tr><td><b>" + L.LifeThreatening + "</b></td><td><font Color=\"#FF0000\">" + 
	L.Yes + "</font></td></tr>" : "" ) +
      ( null == superDisease ? "" : 
	"<tr><td><b>" + L.SuperDisease + "</b></td><td>" + 
	     "<a href=\"" + D.servletShowDisease + "?dis=" + superDisease + "\">" +
	     printNameDisease(superDisease) + "</a></td></tr>") +
      ( subDiseases.size() <= 0 ? "" :
	Common.htmlVectorDI(subDiseases, L.Subdiseases) ) +
      "<tr><td><b>" + L.DiseaseSet + "</b></td><td>" + 
            "<a href=\"" + D.servletShowDiseaseSet + "?dis=" + diseaseSet + "\">" +
	     printNameDiseaseSet(diseaseSet) + "</a></td></tr>" +
      "<tr><td><b>" + L.Temperature + "</b></td><td>" + getTemperature() + "</td></tr>" +
      "<tr><td><b>" + L.GenderSpecific + "</b></td><td>" + genderSpecificity + "</td></tr>" +
      "<tr><td><b>" + L.RaceSpecific + "</b></td><td>" + raceSpecificity + "</td></tr>" + 
      "<tr><td><b>" + L.AgeRange + "</b></td><td>" + 
          L.AgeMin + " " + minAge + " " + L.AgeMax + " " + maxAge + "</td></tr>" +
      "<tr><td><b>" + L.StatusCondition + "</b></td><td>" + statusCondition + "</td></tr>" +
      "<tr><td><b>" + L.Duration + "</b></td><td>" + printDuration() + "</td></tr>" +
	( -1 == frequency ? "" : 
	  "<tr><td><b>" + L.frequency + "</b></td><td>" + frequency + "</td></tr>" ) +
      "<tr><td><b>" + L.BodySystem + "</b></td><td>" + printNameBodySystem() + "</td></tr>" +
      ( genetic.equals("none") ? "" :
	"<tr><td><b>" + L.Genetic + "</b></td><td>" + genetic +
	" <b>" + L.ParentDisease + "</b> " + 
	"<a href=\"" + D.servletShowDisease + "?dis=" + parentDisease + "\">" +
	printNameDisease(parentDisease) + "</a></td></tr>" ) +
      ( null == underlyingDisease ? "" :
	"<tr><td><b>" + L.UnderlyingDisease + "</b></td><td>" + 
	     "<a href=\"" + D.servletShowDisease + "?dis=" + underlyingDisease + "\">" +
	     printNameDisease(underlyingDisease) + "</a></td></tr>" ) +
      ( 0 == externalCauses.size() ? "" :
	"<tr><td><b>" + L.ExternalCauses + "</b></td><td>" + 
	listExternalCauses(externalCauses) + "</td></tr>"  ) +
      ( null == miscComments ? "" : 
	"<tr><td><b>" + L.MiscComments + "</b></td><td>" + miscComments + "</td></tr> \n" ) +
      Symptom.htmlList(L.Symptoms, getSymptoms()) + "\n" +
      "<tr><td><b>" + L.MaxRate + "</b></td><td>" + maxRate  +  "</td></tr> \n" +
      ( 0 == getInternalCauses().size() ? "" :
	Common.htmlVectorDI(getInternalCauses(), L.InternalCauses) + "\n" ) + 
      ( 0 == getCausingSets().size() ? "" :
	Common.htmlVectorDISet(getCausingSets(), L.CausingSets) + "\n" ) + 
      ( 0 == getCausingAbnormalConditions().size() ? "" :
	Common.htmlVectorAC(getCausingAbnormalConditions(), 
			    L.CausingAbnormalConditions) + "\n" ) +
      ( 0 == getCausesDiseases().size() ? "" :
	Common.htmlVectorDI(getCausesDiseases(), L.CausesDiseases) + "\n" ) +
      ( 0 == causesAbnormalConditions.size() ? "" :
	Common.htmlVectorAC(causesAbnormalConditions, 
			    L.CausesAbnormalConditions) + "\n" ) +
      ( 0 == literature.size() ? "" :
	"<tr><td><b>" + L.Literature + "</b></td><td>" + listLiterature() + "</td></tr> \n"  ) +
      ( 0 == numberOfIllustrations ? "" :
	"<tr><td><b>" + L.Illustrations + "</b></td><td>" + listIllustrations() + "</td></tr> \n" ) +
	"<tr><td><b>Treatment resources:</b></td><td>" + wr + "</td></tr> \n" +
      ( 0 == getTreatments().size() ? "" :
	"<tr><td><b>" + L.Treatments + "</b></td><td>" + listTreatments() + "</td></tr> \n"  ) +
      ( 0 == causesAbnormalConditions.size() ? "" :
	htmlVectorAC2(causesAbnormalConditions, 
		      L.AbnormalConditionTreatments) + "\n" ) ;
  }

  private String printNameDisease(String disStr) {
    Disease dis = Common.getDisease(disStr);
    if ( null != dis ) return dis.getPrintName();
    return disStr;
  }

  private String printNameDiseaseSet(String disStr) {
    DiseaseSet dis = Common.getDiseaseSet(disStr);
    if ( null != dis ) return dis.getPrintName();
    return disStr;
  }

  private String printDuration() { 
    if ( 0 < duration ) return L.about  + duration + L.days;
    if ( duration == 0 ) return L.criticallyAcute;
    if ( duration == -1 ) return L.chronic;
    if ( duration == -2 ) return L.lessDay;
    if ( duration == -3 ) return L.lessWeek;
    if ( duration == -4 ) return L.lessMonth;
    if ( duration == -5 ) return L.lessMonth3;
    if ( duration == -6 ) return L.lessMonth6;
    if ( duration == -7 ) return L.lessYear;
    if ( duration == -10 ) return L.unknown;
    if ( duration == -11 ) return L.NA;
    return L.unknown;
  }

  private String printNameBodySystem() {
    BodySystem bs = Common.getBodySystem(bodySystem);
    String printName = bs.getPrintName();
    return
      /* for a popup version ....
      "<SCRIPT LANGUAGE= \"JavaScript\">"+
      "function bsFunc(bodySystem) {" +
      "open(\"" + D.servletDisplayBodySystem + "?bs=\"+bodySystem" +
      ",\"DisplayBodySystem\"," +
      "\"resizable=yes,scrollbars=yes,height=300,width=600\"); }" +
      "</SCRIPT>" +
      "<a href=\"#bs\" NAME=\"bs\" onClick=\"bsFunc('" + bodySystem + "')\">" +
      printName + "</a>";
      */
      "<a href=\"" + D.servletShowBodySystem + "?bs=" + bodySystem + "\">" +
      printName + "</a>";
  }

  private String listLiterature() {
    return listStringVector(literature);
  }
  private String listExternalCauses(Vector vec) {
    StringBuffer sb = new StringBuffer();
    String lit, urlLit;
    int lng = vec.size();
    for (int i=0; i<lng; i++) {
      lit = (String) vec.elementAt(i);
      sb.append(( 0 == i ? "" : "<br />" ) + 
		"<a href=\"" + D.servletShowExternalCause + "?ec=" +
		java.net.URLEncoder.encode(lit) +
		"\">" + lit + "</a>");
    }
    return sb.toString();
  }
  static private String listStringVector(Vector vec) {
    StringBuffer sb = new StringBuffer();
    String lit;
    int lng = vec.size();
    for (int i=0; i<lng; i++) {
      lit = (String) vec.elementAt(i);
      sb.append(( 0 == i ? "" : "<br />" ) + lit);
    }
    return sb.toString();
  }

  private String listTreatments() {
    StringBuffer sb = new StringBuffer();
    String treatmentName, treat;
    Treatment tr;
    Vector vec = getTreatments();
    int lng = vec.size();
    for (int i=0; i<lng; i++) {
      treatmentName = (String) vec.elementAt(i);
      tr = Common.getTreatment(treatmentName);
      // sb.append(( 0 == i ? "" : "<br />" ) + tr.htmlNoBr());
      if ( 0 == i )
	  sb.append(tr.htmlNoBr());
      else
	  sb.append(tr.html());
    }
    return sb.toString();
  }

  private String htmlVectorAC2(Vector vec, String prefix) {
    int lng = vec.size();
    boolean addedTreatment = false;
    StringBuffer sb = new StringBuffer("<tr><td><b>" + prefix + "</b></td><td>");
    if ( 0<lng) {
      String str;
      AbnormalCondition ac;
      Vector treatments;
      int lng2;
      String treatmentName;
      Treatment tr;
      for (int i = 0; i < lng; i++) {
	str = (String) vec.elementAt(i);
	ac = Common.getAbnormalCondition(str);
	treatments = ac.getTreatments();
	lng2 = treatments.size();
	if ( 0 < lng2 ) {
	  sb.append("<br /><b>Treatment for: </b>" + Common.unPolish(str));
	  for (int j=0; j<lng2; j++) {
	    treatmentName = (String) treatments.elementAt(j);
	    tr = Common.getTreatment(treatmentName);
	    if ( !addedTreatment ) {
		addedTreatment = true;
		sb.append(tr.htmlNoBr());
	    } else
		sb.append(tr.html());
	  }
	}
      }
    } 
    if ( addedTreatment ) {
	sb.append("</td></tr>");
	return sb.toString();
    }
    return "";
  }

  private String listIllustrations() {
      return listIllustrations(getIllustrations());
  }

  static public String listIllustrations(Vector vecIn) { // vecIn = illustrations
      Vector vec = new Vector();
      String lit;
      int lng = vecIn.size();
      for (int i=0; i<lng; i++) {
	  lit = (String) vecIn.elementAt(i);
	  vec.addElement("<a href=\"" + lit + "\">" + lit + "</a> ");
      } 
      return listStringVector(vec);
  }

  private Vector allSymptomNames = null;
  public Vector getAllSymptomNames() {
      if ( null != allSymptomNames ) return allSymptomNames;
      allSymptomNames = new Vector();
      Vector vec = getSymptoms();
      int lng = vec.size();
      WeightedSymptom ws;
      for (int i=0; i<lng; i++) {
	  ws = (WeightedSymptom) vec.elementAt(i);
	  allSymptomNames.addElement(ws.getSymptom());
      }
      return allSymptomNames;
  }

} // end of Disease






