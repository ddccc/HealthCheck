// (C) OntoOO Inc 2000
package concepts;

import java.util.*;


public class DiseasePhase {

  private String keyLabel;
  private String name;
  private Vector treatmentActions; // elements of TreatmentAction

  public DiseasePhase(
	   String keyLabel,
	   String name
	   ) {
    this.keyLabel = keyLabel;
    this.name = name;
  } // end of DiseasePhase()

} // end of DiseasePhase
