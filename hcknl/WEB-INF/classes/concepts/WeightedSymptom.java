// (C) OntoOO Inc 2001
package concepts;
import com.L;

import java.io.*;
import java.util.Vector;

public class WeightedSymptom implements Serializable {
  private String symptom;
  private String elaboration;
  private float weight; // 0 < weight <=1
  WeightedSymptom(String symptom, String elaboration, float weight) {
    this.symptom = symptom;
    this.elaboration = elaboration;
    this.weight = weight;
  }
  public String getSymptom() { return symptom; }
  public String getElaboration() { return elaboration; }
  public float getWeight() { return weight; }

    public boolean containedIn(Vector vec) {
	int lng = vec.size();
	WeightedSymptom ws;
	for (int i = 0; i < lng; i++ ) {
	    ws = (WeightedSymptom) vec.elementAt(i);
	    if ( symptom.equals(ws.getSymptom()) ) return true;
	}
	return false;
    }

  public String html() {
    return 
      "<br /><b>" + L.Symptom + "</b> " + symptom +
      " " + L.weight + " " + weight +
      ( elaboration.equals("") ? "" :
	" " + L.elaboration + " " + elaboration );
  }

} // end WeightedSymptom
