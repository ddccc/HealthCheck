// (C) OntoOO Dennis de Champeaux 2000, 2012
package patient;

import concepts.WeightedSymptom;
import concepts.Symptom;
import com.L;
import com.Incidence358;

import java.util.*;
import java.io.*;

/* An instance of this class is either a conjectured disease during a 
   diagnosis process or ?? */

public class DiseaseInst extends DiseaseInst0 implements Comparable {

  private Vector requiredSymptoms;
  private Vector allSymptomNames = null;
  private Vector inSymptoms = new Vector();
  private Vector outSymptoms = new Vector();
  private float temperature;
  private float maxRate;
  private float acceptanceRate = 0;
  // To keep track how often its acceptance rate improves in Diag2:
  private int boostCnt = 0; 
  private int iterationCnt = 0; 
  private float incidenceRate = 0;
  public DiseaseInst (String disease, float temp, String source, 
		      String gender, int age, int itCnt) {
      this(disease, temp, source);
      incidenceRate = Incidence358.incidence(gender, age, disease);
      iterationCnt = itCnt;
  }

  public DiseaseInst (String disease, float temp, String source) {
    // this.disease = disease;
    // dis = getDiseaseC();
    super(disease, source, new Date());
    temperature = temp;
    requiredSymptoms = dis.getSymptoms();
    allSymptomNames = dis.getAllSymptomNames();
    maxRate = dis.getMaxRate();
  } // end DiseaseInst(String disease, float temp, String source)

  public DiseaseInst copy() {
    DiseaseInst di = new DiseaseInst(disease, temperature, source);
    di.setBoostCnt(boostCnt);
    di.setIncidenceRate(incidenceRate);
    di.setIterationCnt(iterationCnt+1);
    Vector in = new Vector();
    int lng = inSymptoms.size();
    WeightedSymptom ws;
    for (int i=0; i<lng; i++) {
	ws = (WeightedSymptom) inSymptoms.elementAt(i);
	in.addElement(ws.getSymptom());
    }
    Vector out = new Vector();
    lng = outSymptoms.size();
    for (int i=0; i<lng; i++) {
	ws = (WeightedSymptom) outSymptoms.elementAt(i);
	out.addElement(ws.getSymptom());
    }
    di.requalify(in, out);
    return di;
  }

  public DiseaseInst (String disease, float temp) {
    this(disease, temp, null);
  } // end DiseaseInst(String disease, float temp)

  public Vector getRequiredSymptoms() { return requiredSymptoms; }
  public Vector getAllSymptomNames() { return allSymptomNames; }
  public Vector getInSymptoms() { return inSymptoms; }
  public Vector getOutSymptoms() { return outSymptoms; }

  public float getAcceptanceRate() { return acceptanceRate; }
  public int getBoostCnt() { return boostCnt; }
  public void incrementBoostCnt() { boostCnt++; }
  public void setBoostCnt(int x) { boostCnt = x; }

  public void setIncidenceRate(float x) { incidenceRate = x; }
  public float getIncidenceRate() { return incidenceRate; }
  public void setIterationCnt(int x) { iterationCnt = x; }
  public int getIterationCnt() { return iterationCnt; }


  // requalify does two things:
  // - updates inSymptoms and outSymptoms
  // - (re)calculates acceptanceRate
  public void requalify(Vector newInSymptoms, Vector newOutSymptoms) {
    HashSet hs = new HashSet();
    int lng = newOutSymptoms.size();
    String symptom;
    for (int i = 0; i < lng; i++) {
      symptom = (String) newOutSymptoms.elementAt(i);
      hs.add(symptom);
    }
    requalify(newInSymptoms, hs);
  }
  public void requalify(Vector newInSymptoms, HashSet newOutSymptoms) {
    if ( maxRate <= 0 ) {
      // should never happen ...
      acceptanceRate = 0;
      return;
    }
    if ( null == newOutSymptoms ) newOutSymptoms = new HashSet();

    WeightedSymptom ws;
    int lng = requiredSymptoms.size();
    String sympName;
    for (int i = 0; i<lng; i++) {
      ws = (WeightedSymptom) requiredSymptoms.elementAt(i);
      if ( inSymptoms.contains(ws) ) continue;
      if ( outSymptoms.contains(ws) ) continue;
      sympName = ws.getSymptom();
      if ( newInSymptoms.contains(sympName) )
	inSymptoms.addElement(ws);
      else
      if ( newOutSymptoms.contains(sympName) )
	outSymptoms.addElement(ws);
    }

    float inSupport = 0;
    lng = inSymptoms.size();
    for (int i = 0; i < lng; i++) {
      ws = (WeightedSymptom) inSymptoms.elementAt(i);
      inSupport += ws.getWeight();
    }
    float outSupport = 0;
/*  We will not measure the impact of missing symptoms - for now
    lng = outSymptoms.size();
    for (int i = 0; i < lng; i++) {
      ws = (WeightedSymptom) outSymptoms.elementAt(i);
      outSupport += ws.getWeight();
    }
*/
    //    acceptanceRate = (inSupport - 0.1f * outSupport) / maxRate;
    acceptanceRate = (inSupport - outSupport);
    if ( acceptanceRate < 0 ) 
      acceptanceRate = 0; 
    else
      acceptanceRate = acceptanceRate / maxRate;
  }

    // Warning: the iterationCnt produced by patient.Diag2 is somewhat different
    // than the one set by phone.AskMoreSymptoms.
    // The former generates 20 symptom questions, the latter 5 - as I recollect
  public float rate() {
      float alpha = 1.0f/(1 + iterationCnt);
      return alpha * incidenceRate + (1-alpha) * inSymptoms.size()/ 500;
  }

  public int compareTo(Object o) {
    int i = inSymptoms.size();
    float rate = rate();
    DiseaseInst di2 = this;
    try { di2 = (DiseaseInst) o; } catch (ClassCastException ignore) {}
    float acceptanceRate2 = di2.getAcceptanceRate();
    int i2 = di2.getInSymptoms().size();
    float rate2 = di2.rate();
    /*
    if ( 1 == acceptanceRate ) {
	if ( acceptanceRate2 < 1 ) return -1;
	// 1 == acceptanceRate =  acceptanceRate2
	if ( i2 < i ) return -1;
	if ( i < i2 ) return 1;
	// i == i2
	if ( rate2 < rate ) return -1;
	if ( rate < rate2 ) return 1;
	return 0;
    }

    if ( 1 == acceptanceRate2 ) return 1;

    if ( rate2 < rate ) return -1;
    if ( rate < rate2 ) return 1;
    // rate == rate2
    if ( i2 < i ) return -1;
    if ( i < i2 ) return 1;
    // i == i2
    if ( acceptanceRate2 < acceptanceRate ) return -1;
    if ( acceptanceRate < acceptanceRate2 ) return 1;
    return 0;
    */
    // Wed Jan 29 18:25:24 2020
    if ( i == i2 ) {
	if ( acceptanceRate2 < acceptanceRate ) return 1;
	if ( acceptanceRate < acceptanceRate2 ) return -1;
	if ( rate2 < rate ) return -1;
	if ( rate < rate2 ) return 1;
	return 0;
    }
    // if ( rate2 < rate ) return -1;
    // if ( rate < rate2 ) return 1;

    if ( i2 < i ) return -1;
    if ( i < i2 ) return 1;

    /* Wed Jan 29 18:23:54 2020
    if ( i == i2 ) {
	if ( acceptanceRate2 < acceptanceRate ) return 1;
	if ( acceptanceRate < acceptanceRate2 ) return -1;
	if ( rate2 < rate ) return -1;
	if ( rate < rate2 ) return 1;
	return 0;
    }
    if ( rate2 < rate ) return -1;
    if ( rate < rate2 ) return 1;
    // rate == rate2
    if ( i2 < i ) return -1;
    if ( i < i2 ) return 1;
    */

    /*
    if ( acceptanceRate2 < acceptanceRate ) return -1;
    if ( acceptanceRate < acceptanceRate2 ) return 1;
    */
    return 0;
  }

  public String html() { 
    // Disease dis = getDiseaseC();
    float expectedTemperature = dis.getTemperature();
    boolean red = 
      ( ( 99.3 < expectedTemperature && expectedTemperature <= temperature ) ||
	( 99.3 > expectedTemperature && expectedTemperature >= temperature ) );
    
    return
      super.html() +
      Symptom.htmlList(
		       // "Supporting symptoms: ", 
		       L.SupportingSymptoms + " ", 
		       //		       inSymptoms, 1000) +
		       inSymptoms) +
      Symptom.htmlList(
		       //"Not confirmed symptoms: ",
		       L.DiseaseInstS1 + " ", 
		       // outSymptoms, 1000 + inSymptoms.size()) +
		       outSymptoms) +
      "<tr><td><b>" + L.AcceptanceRate + " </b></td><td>" + acceptanceRate + "</td></tr>" +
      "<tr><td><b>" + L.ExpectedTemperature + " </b></td><td>" + dis.getTemperature() +
            (red ? "<font color=\"#FF0000\">" : "") +
            " <b>" + L.ReportedTemperature + " </b> " + temperature +
            (red ? "</font>" : "") + "</td></tr>" +
      dis.html();
  }

} // end of DiseaseInst



