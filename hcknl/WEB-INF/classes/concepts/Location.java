// (C) OntoOO Inc 2000
package concepts;

import java.util.*;
import java.io.*;
import com.Common;
import com.D;
import com.L;
import com.LR;

/**
   The Location class is a singleton class with instance "body".
   All other locations are in subclasses.

   An (indirect) instance of Location gives a somewhat fuzzy description 
   of a position in a body.  Perhaps confusing is that the
   names of body parts are used to describe locations.  For 
   example the string "heart" can be used to describe a Location
   instance.  This Location instance can be used inside an 
   instance of BodySystem to denote the location of a heart-object.
 */

public class Location implements Serializable, HasName {

    public Location(String name, String locationType) {
	this.name = name;
	printName = Common.unPolish(name);
	this.locationType = locationType;
	Common.addLocation(this);
    }
    public Location() {} // for phantoms

    // gender indicates whether the location is gender specific or not
    protected String gender = LR.both; // both | LR.male | LR.female

    protected String name;
    protected String printName;
    protected String locationType; // 1d | 2d | 3d
    private Vector containedLocations = new Vector(); // elements are LocationRelation
    // Those instances of BodySystem not contained in sub-locations
    private Vector containedBodySystems = new Vector(); // elements in BodySystem
    private Vector abnormalConditions = new Vector();
    private Vector symptoms = new Vector();
    private Vector illustrations = new Vector(); 

    public String getGender() { return gender; }
    public void setGender(String val) { gender = val; }  // LR.male | LR.female

    public String getName() { return name; }
    public String getPrintName() { return printName; }
    public void setName(String name) { this.name = name; }
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

    public String getLocationType() { return locationType; }
    public void setLocationType(String locationType) { this.locationType = locationType; }

    public Vector getContainedLocations() { return containedLocations; }

    public void addContainedLocation(LocationRelation lr) {
      containedLocations.addElement(lr);
    }
    public void removeContainedLocation(LocationRelation lr) {
	containedLocations.removeElement(lr);
    }
    
    public Vector getContainedBodySystems() { return containedBodySystems; }

    // may have to change this when dealing with the names of BodySystems;
    // see the contained locations !!!
    public void addContainedBodySystem(String bodySystem) {
	if ( containedBodySystems.indexOf(bodySystem) < 0 ) 
	    containedBodySystems.addElement(bodySystem);
    }
    public void removeContainedBodySystem(String bodySystem) {
	containedBodySystems.removeElement(bodySystem);
    }

  public Vector getAbnormalConditions() { return abnormalConditions; }
  public Vector getSymptoms() { return symptoms; }

  private Vector allSymptoms = null;
  public Vector getAllSymptoms() { 
	if ( null != allSymptoms ) return allSymptoms;
	int lng = containedLocations.size();
	if ( 0 == lng ) {
	   allSymptoms = symptoms;
	   return allSymptoms;
	}
	allSymptoms = (Vector) symptoms.clone();
	for (int i = 0; i < lng; i++) {
	    LocationRelation lr = (LocationRelation) containedLocations.elementAt(i);
	    String position = lr.getPosition();
	    if ( position.equals("inside") ) {
	       String locName2 = lr.getLocationName2();
	       Location loc2 = Common.getLocation(locName2);
	       Vector loc2Symptoms = loc2.getAllSymptoms();
	       int lng2 = loc2Symptoms.size();
     	       for (int j = 0; j < lng2; j++) {
		   String symp2 = (String) loc2Symptoms.elementAt(j);
		   if ( allSymptoms.contains(symp2) ) continue;
		   allSymptoms.addElement(symp2);
	       }
	    }

	}
	return allSymptoms;
  }

    public boolean hasAsymptom() {
	return (0 < getAllSymptoms().size());
    }

    private Vector parts = null;
    public Vector getParts() {
	if ( null != parts ) return parts;
	parts = new Vector();
	int lng = containedLocations.size();
	for (int i = 0; i<lng; i++) {
	    LocationRelation lr = (LocationRelation) containedLocations.elementAt(i);
	    String locName2 = lr.getLocationName2();
	    Location loc2 = Common.getLocation(locName2);
	    int lng2 = parts.size();
	    /*
	    Class aClass = loc2.getClass();
	    String className = aClass.getName();
	    if ( className.equals(D.LocationSetClass) ) {
	    */
	    if ( loc2 instanceof LocationSet ) {
		LocationSet locSet = (LocationSet) loc2;
		boolean isSubset = false;
		for (int j = 0; j<lng2; j++) {
		    String locPartSt = (String) parts.elementAt(j);
		    Location locPart = Common.getLocation(locPartSt);
		    /*
		    Class aClassPart = locPart.getClass();
		    String classNamePart = aClassPart.getName();
		    if ( !classNamePart.equals(D.LocationSetClass ) ) continue;
		    */
		    if ( !(locPart instanceof LocationSet) ) continue;
		    LocationSet locPartSet = (LocationSet) locPart;
		    if ( locPartSet.isSubset(locName2) ) {
			isSubset = true;
			break;
		    }
		}
		if ( isSubset ) continue;
	    }
	    PartOfLocation partOfLoc = (PartOfLocation) loc2;
	    boolean isPart = false;
	    for (int j = 0; j < lng2; j++) {
		String locPartSt = (String) parts.elementAt(j);
		Location locPart = Common.getLocation(locPartSt);
		/*
		Class aClassPart = locPart.getClass();
		String classNamePart = aClassPart.getName();
		if ( !classNamePart.equals(D.LocationSetClass ) ) continue;
		*/
		if ( !(locPart instanceof LocationSet) ) continue;
		LocationSet locPartSet = (LocationSet) locPart;
		if ( locPartSet.isMember(locName2) ) { 
			isPart = true;
			break;
		}
	    }
	    if ( isPart ) continue;
	    parts.addElement(locName2);
	}
	return parts;
    }

  public void addAbnormalCondition(String name) {
      abnormalConditions.addElement(name);
  }
  public void addSymptom(String name) {
      symptoms.addElement(name);
  }

  public Vector getIllustrations() { return illustrations; }
  public void addIllustration(String illustration) { 
    illustrations.addElement(illustration); 
  }

    public void printLocation() {
      Common.println("Location: " + name + " type: " + locationType);
      for (int i = 0; i < containedLocations.size(); i++) {
	LocationRelation lr = (LocationRelation) containedLocations.elementAt(i);
	Common.println("contained location: " + lr.getLocationName2() );
      }
      for (int i = 0; i < containedBodySystems.size(); i++)
	Common.println("contained body-system: " + 
			   (String) containedBodySystems.elementAt(i) );
      for (int i = 0; i < abnormalConditions.size(); i++)
	Common.println("abnormalCondition: " + 
			   (String) abnormalConditions.elementAt(i) );
      for (int i = 0; i < symptoms.size(); i++)
	Common.println("symptom: " + (String) symptoms.elementAt(i) );
    } 


  public String html() {
      int numberOfIllustrations = illustrations.size();

    return 
	/*
      "<br><b>" + L.Location + "</b> " + 
	     "<A HREF='" + D.servletShowLocation + "?loc=" + name + "'>" +
	     printName + "</A> " +
	*/
      "<tr><td><b>type:</b></td><td> " + locationType + "</td></tr>" +
      htmlContainedLocs() +
      Common.htmlVectorBS(containedBodySystems, L.ContainedBodySystems) +
      Common.htmlVectorAC(abnormalConditions, L.AbnormalConditions) +
      Common.htmlVectorSY(symptoms, L.Symptoms) +
      ( 0 == numberOfIllustrations ? "" :
	"<tr><td><b>" + L.Illustrations + "</b></td><td>" + listIllustrations() + "</td></tr> \n" );
  }


  private String htmlContainedLocs() {
    int lng = containedLocations.size();
    if ( 0 < lng ) {
      StringBuffer sb = 
	  new StringBuffer("<tr><td><b>" + L.ContainedLocations + "</b></td><td>");
      String locName2;
      LocationRelation lr;
      for (int i = 0; i < lng; i++) {
	lr = (LocationRelation) containedLocations.elementAt(i);
	locName2 = lr.getLocationName2();
	sb.append(
	     " <a href=\"" + D.servletShowLocation + "?loc=" + locName2 + "\">" +
	     Condition.locPrintName(locName2) + "</a>");
      }
      sb.append("</td></tr>");
      return sb.toString();
    } else return "";
  }

  private String listIllustrations() {
      return Disease.listIllustrations(illustrations);
  }

} // end of class Location


