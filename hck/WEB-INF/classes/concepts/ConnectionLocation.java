// (C) OntoOO Inc 2000
package concepts;

import java.util.*;
import com.Common;
import com.LR;
import com.D;
import com.L;

public class ConnectionLocation extends PartLocation {

    private String referenceLocation1 = null; // names of PartOf objects
    private String referenceLocation2 = null;
    public ConnectionLocation(
	        String name, 
		String locationType,
		LocationRelation partOf,
		String referenceLocation1,
		String referenceLocation2
		) {
	super(name, locationType, partOf);
	this.referenceLocation1 = referenceLocation1;
	this.referenceLocation2 = referenceLocation2;
	PartLocation container;
	LocationRelation lr;
	if (null != referenceLocation1) {
	  container = 
	    (PartLocation) Common.getLocation(referenceLocation1);
	  lr = new LocationRelation(
		   referenceLocation1, 
		   name,
		   LR.connecting, 
		   LR.na, LR.na, LR.na);
	  container.addAdjacent(lr);
	}
	if (null != referenceLocation2) {
	  container = (PartLocation) Common.getLocation(referenceLocation2);
	  lr = new LocationRelation(
		   referenceLocation2, 
		   name,
		   LR.connecting, 
		   LR.na, LR.na, LR.na);
	  container.addAdjacent(lr);
	}
    }
  public ConnectionLocation() {} // for phantoms

  public String getReferenceLocation1() { 
	return referenceLocation1; 
  }
  public String getReferenceLocation2() { 
	return referenceLocation2; 
  }

    public Vector getAllSymptoms() { return getSymptoms(); }

  public void printLocation() {
    Common.println("");
    Common.print("ConnectionLocation:");
    super.printLocation();
    Common.println("referenceLocation1: " + referenceLocation1);
    Common.println("referenceLocation2: " + referenceLocation2);

  } // end of printLocation()

  public String html() {
    return 
      "<p><b>" + L.ConnectionLocation + "</b>" +
      super.html() +
      "<tr><td><b>" + L.ReferenceLocation1 + "</b></td><td> " + 
      "<a href=\"" + D.servletShowLocation + "?loc=" + referenceLocation1 + "\">" +
	     referenceLocation1 + "</a> </td></tr>" +
      "<tr><td><b>" + L.ReferenceLocation2 + "</b></td><td> " + 
      "<a href=\"" + D.servletShowLocation + "?loc=" + referenceLocation2 + "\">" +
	     referenceLocation2 + "</a> </td></tr>";
  }

} // end of ConnectionLocation
