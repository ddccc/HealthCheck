// (C) OntoOO Inc 2000
package concepts;

import java.util.*;
import com.Common;
import com.D;
import com.L;

public class LocationSet extends PartLocation {

    private Vector members = new Vector();
    private String superset = null;
    private Vector subsets = new Vector();
    public LocationSet (
	        String name, 
		String locationType,
		LocationRelation partOf
		) {
	super(name, locationType, partOf);
    }
  public LocationSet() {} // for phantoms

  public void addMember(String name) { members.addElement(name); }
  public void removeMember(String name) { members.removeElement(name); }
  public Vector getMembers() { return members; }
  // public void remove() { super.remove(); }
  public String getSuperset() { return superset; }
  public void setSuperset(String ls) { 
    superset = ls;
    LocationSet lss = (LocationSet) Common.getLocation(ls);
    lss.addSubset(name);
 }
  public void addSubset(String name) { subsets.addElement(name); }
  public void removeSubset(String name) { subsets.removeElement(name); }
  public Vector getSubsets() { return subsets; }

    private boolean setmemberSymptomsAdded = false;
    public Vector getSymptoms() {
      // System.out.println("LocationSet/getSymptoms()/name: " + name);
      if ( setmemberSymptomsAdded || null == superset )
	return super.getSymptoms();
      else {
	setmemberSymptomsAdded = true;
	String aSymptom;
	LocationSet aLoc;
	Vector setSymptoms;
	aLoc = (LocationSet) Common.getLocation(superset);
	setSymptoms = aLoc.getSymptoms();
	int lng2 = setSymptoms.size();
	for (int j = 0; j<lng2; j++) {
	  aSymptom = (String) setSymptoms.elementAt(j);
	  if ( super.getSymptoms().contains(aSymptom) ) continue;
	  addSymptom(aSymptom);
	}	  
	return super.getSymptoms();
      }
    }

    public Vector getAllSymptoms() { return getSymptoms(); }

    public boolean hasAsymptom() {
	if ( 0 < getAllSymptoms().size() ) return true;
	int lng = subsets.size();
	for (int i = 0; i < lng; i++) {
	    String locSetStr = (String) subsets.elementAt(i);
	    LocationSet locSet = (LocationSet) Common.getLocation(locSetStr);
	    if ( locSet.hasAsymptom() ) return true;
	}
	return false;
    }

    public boolean isSubset(String locationSetName) {
	if ( subsets.contains(locationSetName) ) return true;
	int lng = subsets.size();
	for (int i = 0; i < lng; i++) {
	    String locSetName = (String) subsets.elementAt(i);
	    LocationSet locSet = (LocationSet) Common.getLocation(locSetName);
	    if ( locSet.isSubset(locationSetName) ) return true;
	}
	return false;
    }

    public boolean isMember(String partOfName) {
	if ( members.contains(partOfName) ) return true;
	int lng = subsets.size();
	for (int i = 0; i < lng; i++) {
	    String locSetName = (String) subsets.elementAt(i);
	    LocationSet locSet = (LocationSet) Common.getLocation(locSetName);
	    if ( locSet.isMember(partOfName) ) return true;
	}
	return false;
    }

  public void printLocation() {
    Common.println("");
    Common.println("LocationSet:");
    super.printLocation();
    for (int i = 0; i < members.size(); i++) 
      Common.println("member:    " + (String) members.elementAt(i));
    if ( null != superset )
      Common.println("superset:    " + superset);
    for (int i = 0; i < subsets.size(); i++) 
      Common.println("subset:    " + (String) subsets.elementAt(i));
  } // end of printLocation()

  public String html() {
    return 
      "<p><b>" + L.LocationSet + "</b>" +
      super.html() +
      Common.htmlVectorLOC(members, L.SetMembers) +
      ( null == superset ? "" :  
	"<tr><td><b>" + L.superset + " </b></td><td>" + 
	" <a href=\"" + D.servletShowLocation + "?loc=" + superset + "\">" +
	     superset + "</a> </td></tr> " ) +
      Common.htmlVectorLOC(subsets, L.Subsets);
  }

} // end of LocationSet

