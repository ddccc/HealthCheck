// (C) OntoOO Inc 2002
// Mon May 06 15:32:25 2002
package misc;

import java.util.Vector;
import java.util.HashSet;
import patient.TestSymptoms;


public class DiagStackEntry {

  private String bodyPart = null;
  private String system = null;
  private Vector locations;
  private Vector systems;
  private Vector newInSymptomsVec = null;
  private Vector newAllSymptomsVec = null;
  private Vector selectedSymptoms;
  private HashSet notSelectedSymptoms;
  private Vector diseases;
  private TestSymptoms testSymptoms;
  private HashSet D2; // collection of diseases investigated, a subset of D1

  public DiagStackEntry(
      Vector locations,
      Vector systems,
      Vector selectedSymptoms, 
      HashSet notSelectedSymptoms,
      Vector diseases
      ) {
    this.locations = locations;
    this.systems = systems;
    this.selectedSymptoms = selectedSymptoms;
    this.notSelectedSymptoms = notSelectedSymptoms;
    this.diseases = diseases;
  }

  public Vector getLocations() { return locations; }
  public Vector getSystems() { return systems; }
  public String getBodyPart() { return bodyPart; }
  public String getSystem() { return system; }
  public Vector getNewInSymptomsVec() { return newInSymptomsVec; }
  public Vector getNewAllSymptomsVec() { return newAllSymptomsVec; }
  public Vector getSelectedSymptoms() { return selectedSymptoms; }
  public HashSet getNotSelectedSymptoms() { return notSelectedSymptoms; }
  public Vector getDiseases() { return diseases; }
  public TestSymptoms getTestSymptoms() { return testSymptoms; }
  public HashSet getD2() { return D2; } // collection of diseases investigated, a subset of D1

  public void setBodyPart(String bodyPart) { this.bodyPart = bodyPart; }
  public void setSystem(String system) { this.system = system; }
  public void setNewInSymptomsVec(Vector newInSymptomsVec) { 
    this.newInSymptomsVec = newInSymptomsVec; }
  public void setNewAllSymptomsVec(Vector newAllSymptomsVec) { 
    this.newAllSymptomsVec = newAllSymptomsVec; }
  public void setTestSymptoms(TestSymptoms testSymptoms) { this.testSymptoms = testSymptoms; }
  public void setD2(HashSet D2) { this.D2 = D2; }

}
