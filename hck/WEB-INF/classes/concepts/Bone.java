// (C) OntoOO Inc 2001
package concepts;

import com.L;
import java.util.*;

public class Bone extends PartLocation {

  //  public static Bone aBone = new Bone(LR.aBoneSt, LR.d3, null);

  public Bone(String name, 
	      String locationType, 
	      LocationRelation partOf) {
    super(name, locationType, partOf);
  }
  //   public Bone() {} // for phantoms

    public Vector getAllSymptoms() { return getSymptoms(); }

  public String html() {
    return "<p><b>" + L.Bone + "</b>" + super.html();
  }

}
