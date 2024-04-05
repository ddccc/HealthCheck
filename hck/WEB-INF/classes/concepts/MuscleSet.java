// (C) OntoOO Inc 2001
package concepts;
import com.L;
import java.util.*;

public class MuscleSet extends LocationSet {

public MuscleSet(String name, 
	       String locationType, 
	       LocationRelation partOf) {
     super(name, locationType, partOf);
   }
   public MuscleSet() {} // for phantoms

    public Vector getAllSymptoms() { return getSymptoms(); }

   public String html() {
     return "<p><b>" + L.MuscleSet + "</b>" + super.html();   }

 }
