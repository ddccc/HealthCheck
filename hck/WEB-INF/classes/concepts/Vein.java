// (C) OntoOO Inc 2001
package concepts;
import com.L;
import java.util.*;


public class Vein extends PartLocation {

  //  public static Vein aVein = new Vein(LR.aVeinSt, LR.d3, null);

  public Vein(String name, 
	      String locationType, 
	      LocationRelation partOf) {
    super(name, locationType, partOf);
  }
  //  public Vein() {} // for phantoms

    public Vector getAllSymptoms() { return getSymptoms(); }

  public String html() {
    return "<p><b>" + L.Vein + "</b>" + super.html();
  }

}
