// (C) OntoOO Inc 2001
package concepts;
import com.L;
import java.util.*;

public class VeinSet extends LocationSet {

  public VeinSet(String name, 
	      String locationType, 
	      LocationRelation partOf) {
    super(name, locationType, partOf);
  }
  public VeinSet() {} // for phantoms

  public String html() {
    return "<p><b>" + L.VeinSet + "</b>" + super.html();
  }

}
