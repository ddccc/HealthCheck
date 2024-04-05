// (C) OntoOO Inc 2001
package concepts;
import com.L;
import java.util.*;

public class OrganSet extends LocationSet {

  public OrganSet(String name, 
	      String locationType, 
	      LocationRelation partOf) {
    super(name, locationType, partOf);
  }
  public OrganSet() {} // for phantoms

    public Vector getAllSymptoms() { return getSymptoms(); }

  public String html() {
      return "<p><b>" + L.OrganSet + "</b>" + super.html();
  }

}
