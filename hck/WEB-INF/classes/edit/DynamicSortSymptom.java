// Copyright OntoOO Inc, 2002
package edit;

// import java.util.*;
import com.D;
import concepts.Symptom;

public class DynamicSortSymptom implements Comparable {
  Symptom symptom;
  int eligibleDiseases = -1;
  
  public DynamicSortSymptom(Symptom symptom) { this.symptom = symptom; }
  public Symptom getSymptom() { return symptom; }
  public int getEligibleDiseases() { return eligibleDiseases; }
  public void setEligibleDiseases(int val) { eligibleDiseases = val; }
  
  public int compareTo(Object s2) throws ClassCastException {
    if ( s2.equals(this) ) return 0;
    Class aClass = s2.getClass();
    String className = aClass.getName();
    if ( !className.equals(D.DynamicSortSymptomClass) )
      throw new ClassCastException(
                   "Expect " + D.DynamicSortSymptomClass + " instead of: " + className);
    DynamicSortSymptom ds2 = (DynamicSortSymptom) s2;
    int eligibleDiseases2 = ds2.getEligibleDiseases();
    return ( eligibleDiseases == eligibleDiseases2 ? 0 : 
	     ( eligibleDiseases < eligibleDiseases2 ? 1 : -1 ) );
  }
}
