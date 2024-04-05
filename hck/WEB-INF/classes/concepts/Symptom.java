// (C) OntoOO Inc 2000
package concepts;
import com.Common;
import com.LR;
import com.D;
import com.L;

import java.util.*;
import java.io.*;


public class Symptom extends Condition 
                     implements Serializable, Comparable {

    // htmlList produces a row in a table with symptom descriptions that can be expanded
    // Would make more sense to take the table stuff and prefix out ....
  public static String htmlList(String prefix, 
				// Vector weightedSymptoms, int anchor) {
				Vector weightedSymptoms) {
    int lng = weightedSymptoms.size();
    if ( 0 == lng ) return "";
    StringBuffer sb = new StringBuffer("<tr><td><b>" + prefix + "</b></td><td>");
    WeightedSymptom ws;
    String symptomName;
    float weight;
    String elaboration;
    Symptom symptom;
    String printName;
    String description;
    String entry;
    int anchor2; // not used
    for (int i = 0; i < lng; i++) {
      ws = (WeightedSymptom) weightedSymptoms.elementAt(i);
      symptomName = ws.getSymptom();
      weight = ws.getWeight();
      elaboration = ws.getElaboration();
      try {
	symptom = Common.getSymptom(symptomName);
	printName = symptom.getPrintName();
	description = symptom.getDescription();
	//	anchor2 = anchor + i;
	entry =
	    ( 0 == i ? "" : "<br>" ) +
	    /*
	    "<a href=\"#" + anchor2 + "\" name=\"" + anchor2 + "\" onClick=\"alert('" +
	    description + "')\"><i>" +
	    printName + "</i></a> " +
	    */
	    "<a href=\"" + D.servletShowSymptom + "?sym=" + symptomName + "\">" +
	    description + "</a> " +
	    "weight: " + weight +
	    ( elaboration.equals("") ? "" :
	      " elaboration: " + elaboration );
      } catch (Exception ex) {
	entry = "<h2>**** Exception with: " + symptomName + " ****</h2>";
      }
      sb.append(entry);
    }
    sb.append("</td></tr> \n");
    return sb.toString();
  }

    /* 
       Appears to be dead code ....
    // as the operation above but without the table row primitives 
    // consolidation here is needed ...
  public static String htmlListDrilldown(String prefix, 
					 Vector weightedSymptoms) {
    int lng = weightedSymptoms.size();
    if ( 0 == lng ) return "";
    StringBuffer sb = new StringBuffer("<br><b>" + prefix + "</b>");
    WeightedSymptom ws;
    String symptomName;
    float weight;
    String elaboration;
    Symptom symptom;
    String printName;
    String description;
    String entry;
    for (int i = 0; i < lng; i++) {
      ws = (WeightedSymptom) weightedSymptoms.elementAt(i);
      symptomName = ws.getSymptom();
      weight = ws.getWeight();
      elaboration = ws.getElaboration();
      try {
	symptom = Common.getSymptom(symptomName);
	printName = symptom.getPrintName();
	entry =
	  "<br><a href=\"" + D.servletShowSymptom + "?sym=" + symptomName + "\">" +
	  printName + "</a> " +
	  "weight: " + weight +
	  ( elaboration.equals("") ? "" :
	    " elaboration: " + elaboration );
      } catch (Exception ex) {
	entry = "<h2>**** Exception with: " + symptomName + " ****</h2>";
      }
      sb.append(entry);
    }
    return sb.toString();
  }
    */

  private Vector allDiseases = null;
  private Vector theDiseases = new Vector();
  private Vector sideEffects = new Vector();
  private Vector criticalSideEffects = new Vector();

  private int minAge = 0; // under bound of typical age
  private int maxAge = LR.maxAge; // upper bound of typical age
  // statusCondition 
  // gender neutral disease: none
  //   female = premenstruating | menstruating | pregnant | menopause | postmenopause
  //   male = none
  private String statusCondition = "none"; 
    // private boolean occursOnce = false;
  private boolean cardinal = false;
  private boolean skip = false;

  public Symptom(
	   String name,
	   String description,
	   String locationSt
	   ) {
    super(name, description, locationSt);
    Common.addSymptom(this);  
    Location location = Common.getLocation(locationSt);
    location.addSymptom(name);
  } // end of Symptom()

  public Vector getTheDiseases() {
      if ( null == allDiseases ) 
	  allDiseases = findAllDiseases((Vector)theDiseases.clone());
      return allDiseases;
  }
  private Vector findAllDiseases(Vector theDiseasesClone) {
      for (int i = 0; i < theDiseasesClone.size(); i++) {
	  String disName = (String)theDiseasesClone.elementAt(i);
	  Disease dis = Common.getDisease(disName);
	  Vector subDiseases = dis.getSubDiseases();
	  int lng = subDiseases.size();
	  for (int j = 0; j<lng; j++) {
	      String subDiseaseJ = (String) subDiseases.elementAt(j);
	      if ( !theDiseasesClone.contains(subDiseaseJ) )
		  theDiseasesClone.addElement(subDiseaseJ);
	  }
       }
      return theDiseasesClone;
  }

  public void addDisease(String diseaseName) {
      if ( !theDiseases.contains(diseaseName) ) 
	  theDiseases.addElement(diseaseName);
  }
  public Vector getSideEffects() { return sideEffects; }
  public void addSideEffect(String drugName) {
      if ( !sideEffects.contains(drugName) ) 
	  sideEffects.addElement(drugName);
  }
  public Vector getCriticalSideEffects() { return criticalSideEffects; }
  public void addCriticalSideEffect(String drugName) {
      if ( !criticalSideEffects.contains(drugName) ) 
	  criticalSideEffects.addElement(drugName);
  }


  public int getMinAge() { return minAge; }
  public void setMinAge(int i) { minAge = i; }
  public int getMaxAge() { return maxAge; }
  public void setMaxAge(int i) { maxAge = i; }
  public String getStatusCondition() { return statusCondition; }
  public void setStatusCondition(String sc) { statusCondition = sc; }
    // public void setOccursOnce(boolean x) { occursOnce = x; }
    // public boolean getOccursOnce() { return occursOnce; }

    /* some symptoms are cardinal as set by InitSymptom
       A symptom is cardinal:
       - It is a "red flag":
             for example jaundice is the only early symptom for pancreas cancer,
             for pediatric warnings
       - It is a single symptom occurring in a disease that has only single symptoms;
         by making at least one of them cardinal, these diseases become accessible via
         the pull down lists in DiagStart
    */
  public void setCardinal() { cardinal = true; }
  public boolean getCardinal() { return cardinal; }
    /* skip is used in DiagStart to filter out of the pulldown lists esoteric symptoms
       a cardinal symptom is NEVER filtered out
    */
  public void setSkip() { skip = !cardinal; } 
  public boolean getSkip() { return skip; }

  public void setPrintName(String namex) { 
	printName = namex; 
	if ( name.equals(printName) ) return;
	String name2 = Common.eliminateSpace(printName);
	if ( name.equals(name2) ) return;
	// Common.println("Location name: " + name + " name2: " + name2);
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

  public int compareTo(Object s2) throws ClassCastException {
    if ( s2.equals(this) ) return 0;
    if ( !(s2 instanceof Symptom) )
      throw new ClassCastException(
                   "Expect " + D.SymptomClass);
    Symptom ss2 = (Symptom) s2;
    getTheDiseases();
    int lng1 = theDiseases.size();

    Vector theDiseases2 = ss2.getTheDiseases();
    int lng2 = theDiseases2.size();
    return ( lng1 == lng2 ? 0 : ( lng1 < lng2 ? 1 : -1 ) );
  }

  public void printSymptom() {
	Common.println("");
	Common.print("Symptom:");
	super.printCondition();
	Common.println("minAge: " + minAge + " maxAge: " + maxAge);
	Common.println("statusCondition: " + statusCondition);
	Common.println("Diseases: " + theDiseases.toString());
  }

  public String html() {
    return 
	    // "<p><b>" + L.Symptom + "</b> " + 
      super.html() +
      "<tr><td><b>" + L.AgeRange + "</b></td><td>" + 
          L.AgeMin + " " + minAge + " " + L.AgeMax + " " + maxAge + "</td></tr>\n" +
      "<tr><td><b>" + L.StatusCondition + "</b></td><td>" + statusCondition + "</td></tr>\n" +
      Common.htmlVectorDI(getTheDiseases(), L.DiseaseKeys) +
	(0 < sideEffects.size() ? 
	 "<tr><td><b>Caused by medication side effect</b></td><td>" +
	 Treatment.drugs(sideEffects, "<br>", false) +
	 "</td><tr>" : "") +
	(0 < criticalSideEffects.size() ? 
	 "<tr><td><b>CRITICAL Caused by medication side effect</b></td><td>" +
	 Treatment.drugs(criticalSideEffects, "<br>", false) +
	 "</td><tr>" : "");
  }

} // end of Symptom

