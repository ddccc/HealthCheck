// (C) OntoOO Inc 2000
package concepts;

import java.util.*;
import com.Common;
import com.D;
import com.L;
import com.LR;

public class PartOfLocation extends Location {

    private LocationRelation partOf = null;

     /* A location can be a member of more than one set.  Example: 
	the left thumb is member of thumbs and member of the left fingers
     */
    private Vector memberships = new Vector();

    public PartOfLocation(String name, 
		   String locationType,
		   LocationRelation partOf
		   ) {
	super(name, locationType);
	this.partOf = partOf;
	if ( null != partOf ) {
	  String containerName = partOf.getLocationName1();
	  Location container = Common.getLocation(containerName);
	  container.addContainedLocation(partOf);
	}

    } // end of PartOfLocation(...)
    public PartOfLocation() {} // for phantoms
 
    public LocationRelation getPartOf() { return partOf; }
    public void setPartOf(LocationRelation partOf) { this.partOf = partOf; }

    public Vector getMemberships() { return memberships; }
    /*
    public void setMemberships(Vector memberships) { 
	this.memberships = memberships; 
    }
    */
    public void addMembership(LocationSet locationSet) {
        addMembership(locationSet.getName());
    }
    public void addMembership(String locationSetName) {
	memberships.addElement(locationSetName);
	LocationSet locationSet = (LocationSet) Common.getLocation(locationSetName);
	locationSet.addMember(name);
    }
    public void removeMembership(LocationSet locationSet) {
        removeMembership(locationSet.getName());
    }
    public void removeMembership(String locationSetName) {
	memberships.removeElement(locationSetName);
	LocationSet locationSet = (LocationSet) Common.getLocation(locationSetName);
	locationSet.removeMember(name);
    }

    private boolean setmemberSymptomsAdded = false;
    public Vector getSymptoms() {
      int lng = memberships.size();
      if ( setmemberSymptomsAdded || 0 == lng )
	return super.getSymptoms();
      else {
	setmemberSymptomsAdded = true;
	String aSet, aSymptom;
	LocationSet aLoc;
	Vector setSymptoms;
	for (int i = 0; i<lng; i++) {
	  aSet = (String) memberships.elementAt(i);
	  aLoc = (LocationSet) Common.getLocation(aSet);
	  setSymptoms = aLoc.getSymptoms();
	  int lng2 = setSymptoms.size();
	  for (int j = 0; j<lng2; j++) {
	    aSymptom = (String) setSymptoms.elementAt(j);
	    if ( super.getSymptoms().contains(aSymptom) ) continue;
	    addSymptom(aSymptom);
	  }	  
	}
	return super.getSymptoms();
      }
    }

    public void printLocation() { 
      // force symptoms to be added from members
      Vector symptoms = getSymptoms();
      super.printLocation();
      if ( !gender.equals(LR.both) )
	  Common.println("gender:    " + gender);
      if ( null != partOf ) {
	Common.println("partOf:    " + partOf.getLocationName1());
	Common.println("position:  " + partOf.getPosition() +
		       " leftRight: " + partOf.getLeftRight() +
		       " topBottom: " + partOf.getTopBottom() +
		       " backFront: " + partOf.getBackFront());
      }
      for (int i = 0; i < memberships.size(); i++) 
	Common.println("memberOf: " + (String) memberships.elementAt(i));
    }

  public String html() {
    String loc1 = ( null == partOf ? null : partOf.getLocationName1());
    // force symptoms to be added from members
    Vector symptoms = getSymptoms();
    return 
      super.html() +
      ( gender.equals(LR.both) ? "" : 
	"<tr><td><b>" + L.gender + "</b></td><td> " + gender + "</td></tr>" ) +
      ( null == loc1 ? "" : 
	"<tr><td><b>" + L.partOf + "</b></td><td> " + 
	"<a href=\"" + D.servletShowLocation + "?loc=" + loc1 + "\">" +
	Condition.locPrintName(loc1) + "</a> </td></tr>" +
	"<tr><td><b>Details:</b></td><td><b>" + L.position + "</b> " + partOf.getPosition() +
	" <b>" + L.leftRight + "</b> " + partOf.getLeftRight() +
	" <b>" + L.topBottom + "</b> " + partOf.getTopBottom() +
	" <b>" + L.backFront + "</b> " + partOf.getBackFront() + "</td></tr>" ) +
      Common.htmlVectorLOC(memberships, L.memberOf);
  }


} // end of PartOfLocation
