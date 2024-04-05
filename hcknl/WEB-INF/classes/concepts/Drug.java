// (C) OntoOO Inc 2011
package concepts;

import com.Common;
import com.L;
import concepts.Symptom;

import java.net.URLEncoder;
import java.util.*;
import java.io.*;

public class Drug implements Serializable, HasName {

  private String description;
  public String getDescription() { 
      if ( 0 < brandNames.size() ) 
	  return description + " | " + 
	      ( (String)brandNames.elementAt(0) );
      else 
	  return description; 
  }
  public String getPrintName() { return description; }
  private String name;
  public String getName() { return name; }
  private Vector sideEffects = new Vector(); // symptom names
  public Vector getSideEffects() { return sideEffects; }
  public void addSideEffect(String symptomName) {
      if ( !sideEffects.contains(symptomName) ) {
	  sideEffects.addElement(symptomName);
	  Symptom sym = Common.getSymptom(symptomName);
	  if ( null == sym ) {
	      System.out.println(
		  "########## Drug/addSideEffect/ symptomName= " + 
		  symptomName);
	      return;
	  }
	  sym.addSideEffect(name);
      }
  }
  public void addSideEffects(String [] symptomNames) {
      for (int i = 0; i < symptomNames.length; i++ )
	  addSideEffect(symptomNames[i]);
  }
  private Vector criticalSideEffects = new Vector(); // symptom names
    public Vector getCriticalSideEffects() { return criticalSideEffects; }
    public void addCriticalSideEffect(String symptomName) {
      if ( !criticalSideEffects.contains(symptomName) ) {
	  criticalSideEffects.addElement(symptomName);
	  Symptom sym = Common.getSymptom(symptomName);
	  if ( null == sym ) {
	      System.out.println(
		  "########## Drug/addCriticalSideEffect/ symptomName= " 
		  + symptomName);
	      return;
	  }
	  sym.addCriticalSideEffect(name);
      }
  }
  public void addCriticalSideEffects(String [] symptomNames) {
      for (int i = 0; i < symptomNames.length; i++ )
	  addCriticalSideEffect(symptomNames[i]);
  }
  private Vector brandNames = new Vector();
  public Vector getBrandNames() { return brandNames; }
  public void addBrandName(String brandName) {
      if ( !brandNames.contains(brandName) ) {
	  brandNames.addElement(brandName);
	  Common.addXWord(brandName, "synonym");
	  XWord brandx = (XWord) Common.getXWord(brandName);
	  brandx.setSynonym(name);
      }
  }

  public Drug(
	   String description
	   ) {
    this.description = description;
    name = Common.eliminateSpace(description);
    Common.addDrug(this);  
  } // end of Drug()

  public String html() {
      String encodedName = URLEncoder.encode(description);
      String wr1 = "http://search.yahoo.com/bin/search?p=" + encodedName;
      String wr2 = "http://www.google.com/search?q=" + encodedName;
      String wr = 
	  "<a href=\"" + wr1 + "\">Yahoo</a> | " +
	  "<a href=\"" + wr2 + "\">Google</a>";
      /*
	return (Common.htmlVector(brandNames, "Brand names") +
	Common.htmlVectorSY(sideEffects, "Side effects") +
	Common.htmlVectorSY(criticalSideEffects, "Critical side effects") +
	"<tr><td><b>" + L.WebResource + "</b></td><td>" + 
	wr + "</td></tr>\n" );
      */
      StringBuffer sb = new StringBuffer();
      sb.append(Common.htmlVector(brandNames, "Brand names"));
      sb.append(Common.htmlVectorSY(sideEffects, "Side effects"));
      sb.append(Common.htmlVectorSY(criticalSideEffects, "Critical side effects"));
      sb.append("<tr><td><b>" + L.WebResource + "</b></td><td>" + 
		wr + "</td></tr>\n");
      return sb.toString();
  }


  /*
    // Perhaps this can be transformed into a relationship between Drugs and diseases
    // via the intervening Treatment ...

  private String theDiseaseKeys = null;

  public String getDiseaseKeys() { 
    if ( null != theDiseaseKeys ) return theDiseaseKeys;
    String expand = Common.getECDiseaseKeys(description);
    if ( null == expand ) return null;
    StringBuffer out = new StringBuffer(expand);
    boolean done = false;
    StringTokenizer st;
    String expand2 = "";
    String diseaseN;
    Disease dis;
    Vector subDiseases;
    String subDisI;
    while (!done) {
      st = new StringTokenizer(expand);
      while ( st.hasMoreTokens() ) {
	diseaseN = st.nextToken();
	dis = Common.getDisease(diseaseN);
	if ( !dis.isSuperDisease() ) continue;
	subDiseases = dis.getSubDiseases();
	for (int i=0; i<subDiseases.size(); i++) {
	  subDisI = " "+subDiseases.elementAt(i);
	  out.append(subDisI);
	  expand2 = expand2 + subDisI;
	}
      }
      if ( expand2.equals("") ) done = true; 
      else { expand = expand2; expand2 = ""; }
    }
    theDiseaseKeys = out.toString();
    return theDiseaseKeys;
  }

  public void printDrug() {
	Common.println("");
	Common.print("Drug:");
	Common.println(description);
	Common.println("Disease Keys: " + getDiseaseKeys());
  }

  public String html() {
    return ("<p><b>" + L.Drug + "</b> " + 
	    "<b>" + L.Description + " </b>" + description +
	    Common.htmlVectorDI(getHtmlDiseaseKeys(), L.DiseaseKeys) );
  }

  private Vector htmlDiseaseKeys = null;
  private Vector getHtmlDiseaseKeys() {
    if (null == htmlDiseaseKeys) setHtmlDiseaseKeys();
    return htmlDiseaseKeys;
  }
  private void setHtmlDiseaseKeys() {
    htmlDiseaseKeys = new Vector();
    String theDiseaseKeys = getDiseaseKeys();
    if ( null == theDiseaseKeys ) { return; }
    StringTokenizer st = new StringTokenizer(theDiseaseKeys);
    String diseaseN;
    while ( st.hasMoreTokens() ) {
	diseaseN = st.nextToken();
	htmlDiseaseKeys.addElement(diseaseN);
    }
  }
  */

} // end of Drug


