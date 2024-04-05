// (C) OntoOO Inc 2001
package concepts;
import com.L;
import java.util.*;

public class TendonSet extends LocationSet {

  public TendonSet(String name, 
	      String locationType, 
	      LocationRelation partOf) {
    super(name, locationType, partOf);
  }
  public TendonSet() {} // for phantoms

    public Vector getAllSymptoms() { return getSymptoms(); }

  public String html() {
    return "<p><b>" + L.TendonSet + "</b>" + super.html();
  }

}
