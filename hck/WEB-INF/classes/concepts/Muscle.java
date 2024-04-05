// (C) OntoOO Inc 2001
package concepts;
import com.L;
import java.util.*;

public class Muscle extends PartLocation {

  //  public static Muscle aMuscle = new Muscle(LR.aMuscleSt, LR.d3, null);

  public Muscle(String name, 
	      String locationType, 
	      LocationRelation partOf) {
    super(name, locationType, partOf);
  }
  //  public Muscle() {} // for phantoms

    public Vector getAllSymptoms() { return getSymptoms(); }

  public String html() {
      return "<p><b>" + L.Muscle + "</b>" + super.html();  }

}
