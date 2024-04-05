// (C) OntoOO Inc 2001
package concepts;
import com.L;
import java.util.*;

public class Tendon extends ConnectionLocation {

  //  public static Tendon aTendon = new Tendon(LR.aTendonSt, LR.d3, null, null, null);

  public Tendon(String name, 
		String locationType, 
		LocationRelation partOf,
		String referenceLocation1,
		String referenceLocation2
		) {
    super(name, locationType, partOf, referenceLocation1, referenceLocation2);
  }
  //  public Tendon() {} // for phantoms

    public Vector getAllSymptoms() { return getSymptoms(); }

  public String html() {
    return "<p><b>" + L.Tendon + "</b>" + super.html();
  }

}
