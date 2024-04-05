// (C) OntoOO Inc 2000
package concepts;
import com.L;

// import java.util.*;
import java.io.*;

public class LocationRelation implements Serializable {

  private String locationName1;
  private String locationName2;

  private String position  = L.inside; // inside | surface | adjacent | connecting
  private String leftRight = L.middle; // left | right | middle | NA
  private String topBottom = L.middle; // top | bottom | middle | NA
  private String backFront = L.middle; // back | front | middle | NA

    public LocationRelation(
	       String locationName1,
	       String locationName2,
	       String position,
	       String leftRight,
	       String topBottom,
	       String backFront
		) {
        this.locationName1 = locationName1;
        this.locationName2 = locationName2;
	this.position = position;
	this.leftRight = leftRight;
	this.topBottom = topBottom;
	this.backFront = backFront;
    }

    public String getLocationName1() { return locationName1; }
    public String getLocationName2() { return locationName2; }
    public String getPosition() { return position; }
    public String getLeftRight() { return leftRight; }
    public String getTopBottom() { return topBottom; }
    public String getBackFront() { return backFront; }

} // end of LocationRelation
