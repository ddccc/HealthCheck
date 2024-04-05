// (C) OntoOO Inc 2000
package concepts;

import java.util.*;
import java.io.*;
import com.Common;
import com.L;

public class AbnormalCondition extends Condition implements Serializable {

  private Vector treatments = new Vector(); // Treatment elements
  private Vector causesDiseases = new Vector();
  private Vector causedByDiseases = new Vector();

  public AbnormalCondition(
	   String name,
	   String description,
	   String locationSt
	   ) {
    super(name, description, locationSt);
    Common.addAbnormalCondition(this);
    Location location = Common.getLocation(locationSt);
    location.addAbnormalCondition(name);

  } // end of AbnormalCondition()

  public Vector getTreatments() { return treatments; }
  public void addTreatment(String treatment) {
    treatments.addElement(treatment);
  }
    //  public String getDiseaseKeys() { return Common.getDiseaseKeys(name); }
  public Vector getCausesDiseases() { return causesDiseases; }
  public void addCausesDisease(String name) { causesDiseases.addElement(name); }

  public Vector getCausedByDiseases() { return causedByDiseases; }
  public void addCausedByDisease(String name) { causedByDiseases.addElement(name); }

  public void printAbnormalCondition() {
	Common.println("");
	Common.print("AbnormalCondition:");
	super.printCondition();
	// Common.println("Disease Keys: "+getDiseaseKeys());
	int lng = causesDiseases.size();
	if ( 0 < lng ) 
	    Common.println("Causes Diseases: " + causesDiseases.toString());
	lng = causedByDiseases.size();
	if ( 0 < lng ) 
	    Common.println("Caused by Diseases: " + causedByDiseases.toString());
	lng = treatments.size();
	if ( 0 < lng ) {
	  Common.println("Treatments for: " + name);
	  for (int i=0; i<lng; i++) 
	    Common.println((String)treatments.elementAt(i));
    }
  }

  public String html() {
      return // "<p><b>" + L.AbnormalCondition + "</b> " + 
	    super.html() +
	    ( 0 == causesDiseases.size() ? "" :
	      Common.htmlVectorDI(causesDiseases, L.CausesDiseases) ) +
	    ( 0 == causedByDiseases.size() ? "" :
	      Common.htmlVectorDI(causedByDiseases, L.CausedByDiseases) ) +
	    ( 0 == getTreatments().size() ? "" :
	      "<tr><td><b>" + L.Treatments + "</b></td><td> " 
	      + listTreatments() + "</td></tr>" ) ;
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
      if ( 0 == i )
	  sb.append(tr.htmlNoBr());
      else
	  sb.append(tr.html());
    }
    return sb.toString();
  }


} // end of AbnormalCondition
