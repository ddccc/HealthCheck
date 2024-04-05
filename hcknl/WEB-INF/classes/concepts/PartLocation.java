// (C) OntoOO Inc 2001
package concepts;

import java.util.*;
import com.Common;
import com.D;
import com.L;

public class PartLocation extends PartOfLocation {
    /*
      int xCoordinate = 0; // negative=left, positive=right, dimension=cm
      int yCoordinate = 0; // negative=back, positive=front, dimension=cm
      int zCoordinate = 0; // negative=down, positive=up, dimension=cm
    */

  private Vector adjacents = new Vector();
  public Vector getAdjacents() { return adjacents; }
  public void addAdjacent(LocationRelation lr) { 
      adjacents.addElement(lr);
      String adjacentName = lr.getLocationName2();
      PartLocation pol = (PartLocation) Common.getLocation(adjacentName);
      pol.addAdjacent2(lr);
    }
  public void removeAdjacent(LocationRelation lr) { 
      adjacents.removeElement(lr); 
      String adjacentName = lr.getLocationName2();
      PartLocation pol = (PartLocation) Common.getLocation(adjacentName);
      pol.removeAdjacent2(lr);
    }
  private Vector adjacents2 = new Vector();
  public Vector getAdjacents2() { return adjacents2; }
  public void addAdjacent2(LocationRelation lr) { 
      adjacents2.addElement(lr);
    }
  public void removeAdjacent2(LocationRelation lr) { 
      adjacents2.removeElement(lr); 
    }
  private Vector alsoPartOfs = new Vector();
  public Vector getAlsoPartOfs() { return alsoPartOfs; }
  public void addAlsoPartOf(LocationRelation partOf) {
      alsoPartOfs.addElement(partOf);
      String containerName = partOf.getLocationName1();
      Location container = Common.getLocation(containerName);
      container.addContainedLocation(partOf);
    }

  public PartLocation(
                 String name, 
		 String locationType,
		 LocationRelation partOf
		 ) {
	super(name, locationType, partOf);
    }
  public PartLocation() {} // for phantoms

    public Vector getAllSymptoms() { return getSymptoms(); }

  public void printLocation() {
    Common.println("");
    Common.println("PartLocation:");
    super.printLocation();
    for (int i = 0; i < adjacents.size(); i++) {
      LocationRelation lr = (LocationRelation) adjacents.elementAt(i);
      // String position = lr.getPosition();
      // System.out.println("position info: "+position);
      Common.println(
	   lr.getPosition() +
	   " location: " + lr.getLocationName1() +
	   " leftRight: " + lr.getLeftRight() +
	   " topBottom: " + lr.getTopBottom() +
	   " backFront: " + lr.getBackFront()
			 );
    }
    for (int i = 0; i < adjacents2.size(); i++) {
      LocationRelation lr = (LocationRelation) adjacents2.elementAt(i);
      Common.println("adjacent location2: " + lr.getLocationName2() );
    }
    for (int i = 0; i < alsoPartOfs.size(); i++) {
      LocationRelation lr = (LocationRelation) alsoPartOfs.elementAt(i);
      Common.println("also part of: " + lr.getLocationName1() );
    }
  } // end of printLocation()

  public String html() {
    return 
	//"<tr><td><b>" + L.PartLocation + "</b></td></tr> " + 
	super.html() +
	htmlAdjacents() +
	htmlAdjacents2() +
	htmlAlsoPartsOf();
  }

  private String htmlAdjacents() {
    int lng = adjacents.size();
    if ( 0 < lng ) {
      StringBuffer sb = new StringBuffer(); 
      LocationRelation lr;
      String loc1;
      for (int i = 0; i < lng; i++) {
	lr = (LocationRelation) adjacents.elementAt(i);
	loc1 = lr.getLocationName2(); // try this 
	sb.append(
	   "<tr><td><b>" +
	   lr.getPosition() +
	   " " + L.Location + "</b></td><td> " + 
	     "<a href=\"" + D.servletShowLocation + "?loc=" + loc1 + "\">" +
	     Condition.locPrintName(loc1) + "</a>" +
	   " <b>" + L.leftRight + "</b> " + lr.getLeftRight() +
	   " <b>" + L.topBottom + "</b> " + lr.getTopBottom() +
	   " <b>" + L.backFront + "</b> " + lr.getBackFront() + "</td></tr>" );
      }
      return sb.toString();
    } else return "";
  }
  private String htmlAdjacents2() {
    int lng = adjacents2.size();
    if ( 0 < lng ) {
      StringBuffer sb = 
	  new StringBuffer("<tr><td><b>" + L.adjacentLocation2 + "</b></td><td>"); 
      LocationRelation lr;
      String loc2;
      for (int i = 0; i < lng; i++) {
	lr = (LocationRelation) adjacents2.elementAt(i);
	loc2 = lr.getLocationName1(); // try this
	sb.append(
	     "<a href=\"" + D.servletShowLocation + "?loc=" + loc2 + "\">" +
	     Condition.locPrintName(loc2) + "</a> ");
      }
      sb.append("</td></tr>");
      return sb.toString();
    } else return "";
  }
  private String htmlAlsoPartsOf() {
    int lng = alsoPartOfs.size();
    if ( 0 < lng ) {
      StringBuffer sb = new StringBuffer("<tr><td><b>" + L.alsoPartOf + "</b></td><td> "); 
      LocationRelation lr;
      String loc1;
      for (int i = 0; i < lng; i++) {
	lr = (LocationRelation) alsoPartOfs.elementAt(i);
	loc1 = lr.getLocationName1();
	sb.append(
	     "<a href=\"" + D.servletShowLocation + "?loc=" + loc1 + "\">" +
	     Condition.locPrintName(loc1) + "</a> ");
      }
      sb.append("</td></tr>");
      return sb.toString();
    } else return "";
  }


} // end of PartLocation

