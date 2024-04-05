// (C) OntoOO Inc 2001
package concepts;

import com.L;
import java.util.*;

public class BoneSet extends LocationSet {

  public BoneSet(String name, 
	      String locationType, 
	      LocationRelation partOf) {
    super(name, locationType, partOf);
  }
  public BoneSet() {} // for phantoms

    public Vector getAllSymptoms() { return getSymptoms(); }

  public String html() {
    return "<p><b>" + L.BoneSet + "</b>" + super.html();
  }

}
