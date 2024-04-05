// (C) OntoOO Inc 2000
package concepts;

import java.util.*;
import java.io.*;
import com.Common;
import com.D;
import com.L;
import com.LR;

public class BodySystem implements Serializable, HasName {

  private String name;
  private String printName;
  private String gender = LR.both; // male | female | both
  private String locationName;
  private String superSystemName; // or null
  private String oneLineDescription;
  private Vector subSystems = new Vector(); // element in BodySystem, their names
  private Vector associatedDiseases = new Vector(); // element in Diseasse, their keys
  private Vector illustrations = new Vector(); 


  // constructors   
  public BodySystem(
	     String name,
	     String locationName,
	     String superSystemName,
	     String oneLineDescription
	     ) {
    this.name = name;
    printName = ( name.endsWith("Sys") ?
		  name.substring(0, name.length() - 3) + " system"
		  : name );
    this.locationName = locationName;
    Location theLocation = Common.getLocation(locationName);
    theLocation.addContainedBodySystem(name);
    this.superSystemName = superSystemName;
    this.oneLineDescription = oneLineDescription;
    Common.addBodySystem(this);
    if ( null != superSystemName ) {
      BodySystem superSystem = Common.getBodySystem(superSystemName);
      superSystem.addSubSystemName(name);
    }
  }

  public String getName() { return name; }
  public String getPrintName() { return printName; }
  public String getGender() { return gender; }
  public String getLocationName() { return locationName; }
  public String getDescription() { return oneLineDescription; }
  public Vector getAssociatedDiseases() { return associatedDiseases; }
  public String getSuperSystemName() { return superSystemName; }
  public Vector getSubSystems() { return subSystems; }

  private Vector allDiseases = null;
  public Vector getAllDiseases() { 
	if ( null != allDiseases ) return allDiseases;
	int lng = subSystems.size();
	if ( 0 == lng ) {
	   allDiseases = associatedDiseases;
	   return allDiseases;
	}
	allDiseases = (Vector) associatedDiseases.clone();
	for (int i = 0; i < lng; i++) {
	    String bsName = (String) subSystems.elementAt(i);
	    BodySystem bs = Common.getBodySystem(bsName);
	    Vector vec = bs.getAllDiseases();
	    int lng2 = vec.size();
	    for (int j = 0; j < lng2; j++) {
		String dis2 = (String) vec.elementAt(j);
		if ( allDiseases.contains(dis2) ) continue;
		allDiseases.addElement(dis2);
	    }
	}
	return allDiseases;
  }


  // set stuff
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
  public void setGender(String val) { gender = val ; }

  public void addDisease(String diseaseKey) {
    if ( !associatedDiseases.contains(diseaseKey) )
      associatedDiseases.addElement(diseaseKey);
  }
  public void addSubSystemName(String subSystemName) {
    if ( !subSystems.contains(subSystemName) )
      subSystems.addElement(subSystemName);
  }

  public Vector getIllustrations() { return illustrations; }
  public void addIllustration(String illustration) { 
    illustrations.addElement(illustration); 
  }

  public void printBodySystem() {
      Common.println("");
      Common.println("BodySystem: " + name);
      Common.println("location: " + locationName +
		     " gender: " + gender +
		     " superSystemName: " + superSystemName
		     );
      Common.println("Txt: " + oneLineDescription);
      int lng = associatedDiseases.size();
      if ( 0<lng) {
	Common.println("disease keys:");
	for (int i = 0; i < lng; i++) {
	  Common.println( (String) associatedDiseases.elementAt(i) );
	}
      }
      lng = subSystems.size();
      if ( 0<lng ) {
	Common.println("subSystems:");
	for (int i = 0; i < lng; i++) {
	  Common.println( (String) subSystems.elementAt(i) );
	}
      }
  }

  public String html() {
      int numberOfIllustrations = illustrations.size();
    return 
	// "<p><b>" + L.BodySystem + "</b> " + printName +
      "<tr><td><b>" + L.Location + "</b></td><td>" + 
      "<a href=\"" + D.servletShowLocation + "?loc=" + locationName + "\">" +
	     locationName + "</a></td></tr>" +
      "<tr><td><b>" + L.gender + "</b></td><td>" + gender + "</td></tr>" +
      ( null == superSystemName ? "" :
	"<tr><td><b>" + L.SupersystemKey + "</b></td><td>" + 
	"<a href=\"" + D.servletShowBodySystem + "?bs=" + superSystemName + "\">" +
	bsPrintName(superSystemName) + "</a></td></tr>" ) +
      "<tr><td><b>" + L.Description + "</b></td><td>" + oneLineDescription + "</td></tr>" +
      ( 0 == numberOfIllustrations ? "" :
	"<tr><td><b>" + L.Illustrations + "</b></td><td>" + listIllustrations() + "</td></tr> \n" ) +
      htmlDiseases() +
      htmlSubsystems();
  }

  private String htmlDiseases() {
    return Common.htmlVectorDI(associatedDiseases, L.DiseaseKeys);
  }
  private String htmlSubsystems() {
    return Common.htmlVectorBS(subSystems, L.SubsystemsKeys);
  }

    static public String bsPrintName(String str) {
	BodySystem bs = Common.getBodySystem(str);
	if ( null == bs ) return str;
	return bs.getPrintName();
    }

    private String listIllustrations() {
	return Disease.listIllustrations(illustrations);
    }

} // end of BodySystem
