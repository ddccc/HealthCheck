// (C) OntoOO Inc 2001
package concepts;
import com.L;
import java.util.*;

public class Organ extends PartLocation {

  //  public static Organ anOrgan = new Organ(LR.anOrganSt, LR.d3, null);

  public Organ(String name, 
	      String locationType, 
	      LocationRelation partOf) {
    super(name, locationType, partOf);
  }
  //  public Organ() {} // for phantoms

    public Vector getAllSymptoms() { return getSymptoms(); }

  public String html() {
    return "<p><b>" + L.Organ + "</b>" + super.html();
  }

}
