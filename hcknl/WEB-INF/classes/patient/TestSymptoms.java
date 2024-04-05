// (C) OntoOO Inc 2003 Feb
package patient;
import java.util.*;
// import java.io.*;
import misc.SortableSymptom;
import concepts.Symptom;
import patient.DiseaseInst;
import concepts.WeightedSymptom;
import concepts.Symptom;
import concepts.Disease;
import com.Common;

public class TestSymptoms extends Hashtable {
    // age and statusCondition are used for symptom filtering
    private int age;
    private String statusCondition;

    public TestSymptoms(int age, String statusCondition) { 
	super(); 
	this.age = age;
	this.statusCondition = statusCondition;
    }

    public void addSymptom(String sympName, String source,
			   HashSet S1, 
			   HashSet notSelectedSymptoms,
			   Vector selectedSymptoms) {
	if ( containsKey(sympName) ) {
	    SortableSymptom ss = (SortableSymptom) get(sympName);
	    if ( source.equals("newExpertDiseases") ) {
		ss.setSource(source); return;
	    }
	    String ssSource = ss.getSource();
	    if ( ssSource.equals("newExpertDiseases") ) return;
	    if ( source.equals("newSystemDiseases") || 
		 source.equals("bodyPartNarrowed") ) {
		ss.setSource(source); return;
	    }
	    if ( ssSource.equals("newSystemDiseases") || 
		 ssSource.equals("bodyPartNarrowed") ) return;
	    if ( source.equals("boostedDiseases") ) {
		ss.setSource(source); return;
	    }
	    if ( ssSource.equals("boostedDiseases") ) return;
	    if ( source.equals("newInSymptomsDiseases") ) {
		ss.setSource(source); return;
	    }
	    return;
	}
	if ( !S1.contains(sympName) ) return; // gender check
	if ( notSelectedSymptoms.contains(sympName) ) return;
	if ( selectedSymptoms.contains(sympName) ) return;
	Symptom symptom = Common.getSymptom(sympName);
	if ( age < symptom.getMinAge() || symptom.getMaxAge() < age ) return;
	String symptomStatusCondition = symptom.getStatusCondition();
	if ( !symptomStatusCondition.equals("none") ) {
	    // check whether the client matches the statusCondition
	    if ( !symptomStatusCondition.equals(statusCondition) &&
		 // perhaps the client does not know she is pregnant
		 !symptomStatusCondition.equals("pregnant") ) return; 
	}
	put(sympName, new SortableSymptom(sympName, source));
    }

    public void addSymptoms(Vector symptomNames, String source,
			    HashSet S1, 
			    HashSet notSelectedSymptoms,
			    Vector selectedSymptoms) {
	String sympName;
	int lng = symptomNames.size();
	for (int i = 0; i < lng; i++) {
	    sympName = (String) symptomNames.elementAt(i);
	    addSymptom(sympName, source, S1, notSelectedSymptoms, selectedSymptoms);
	}
    }

    public void addSymptomsFromDiseases(Vector sourceDiseases, String source,
					HashSet S1, 
					HashSet notSelectedSymptoms,
					Vector selectedSymptoms) {
	DiseaseInst di;
	Vector requiredSymptoms;
	WeightedSymptom ws;
	String sympName;
	int lng = sourceDiseases.size();
	for (int i = 0; i < lng; i++) {
	    di = (DiseaseInst) sourceDiseases.elementAt(i);
	    requiredSymptoms = di.getRequiredSymptoms();
	    int lng2 = requiredSymptoms.size();
	    for (int j = 0; j < lng2; j++) {
		ws = (WeightedSymptom) requiredSymptoms.elementAt(j);
		sympName = ws.getSymptom();
		addSymptom(sympName, source, S1, notSelectedSymptoms, selectedSymptoms);
	    }
	}
    }

    public Vector orderedTestSymptoms(Vector diseases,
				      HashSet notSelectedSymptoms,
				      HashSet D1,
				      boolean boostLifeThreateningSymptoms) {
    float newExpertDiseases = 10000.0f; // newExpertDiseases 
    float newSystemDiseases = 1000.0f; // newSystemDiseases | bodyPartNarrowed
    float boostedDiseases = 100.0f; // newSystemDiseases | bodyPartNarrowed
    float alpha1 = 10.0f; // this will help diseases already investigated
    float alpha2 = 1.0f;
    Hashtable ht = new Hashtable(); // diseaseName -> di 
    int lng = diseases.size();
    DiseaseInst di;
    String disName;
    for (int i = 0; i < lng; i++) {
      di = (DiseaseInst) diseases.elementAt(i);
      disName = di.getDisease();
      ht.put(disName, di);
    }
    Vector sortableSymptoms = new Vector();
    String sympName, diseaseName, wsSymptomName;
    Symptom symp;
    Vector theDiseases;
    float sigma, weight, dPSN, dRS, dDiff;
    int lng2, lng3;
    Disease disease;
    Vector weightedSymptoms;
    WeightedSymptom ws;
    SortableSymptom ss;
    String source;
    Enumeration enumz = this.keys();
    while ( enumz.hasMoreElements() ) {
	sympName = (String) enumz.nextElement();
	ss = (SortableSymptom) get(sympName);
	source = ss.getSource();
	if ( source.equals("newExpertDiseases") )
	    sigma = newExpertDiseases;
	else
	if ( source.equals("newSystemDiseases") ||
	     source.equals("bodyPartNarrowed") ) 
	    sigma = newSystemDiseases;
	else {
	    sigma = ( source.equals("boostedDiseases") ? boostedDiseases : 0.0f );
	    symp = Common.getSymptom(sympName);
	    theDiseases = symp.getTheDiseases();
	    lng2 = theDiseases.size();
	    for (int j = 0; j < lng2; j++) {
		diseaseName = (String) theDiseases.elementAt(j);
		if ( !D1.contains(diseaseName) ) continue;
		di = (DiseaseInst) ht.get(diseaseName);
		disease = Common.getDisease(diseaseName);
		if ( null != di ) { 
		    sigma += alpha1 * di.getAcceptanceRate() * (1 + di.getBoostCnt());
		    if ( disease.isLifeThreatening() ) { 
			if ( boostLifeThreateningSymptoms )
			    sigma += newExpertDiseases;
			ss.setLifeThreatening();
		    };
		    continue;
		}
		weightedSymptoms = disease.getSymptoms();
		lng3 = weightedSymptoms.size();
		dPSN = 0.0f; // accumulate the weights of symptoms in testSymptoms
		dRS = 0.0f;  // accumulate the weights of symptoms in notSelectedSymptoms
		for (int k = 0; k < lng3; k++) {
		    ws = (WeightedSymptom) weightedSymptoms.elementAt(k);
		    wsSymptomName = ws.getSymptom();
		    weight = ws.getWeight();
		    if ( this.contains(wsSymptomName) ) { dPSN += weight; continue; }
		    if ( notSelectedSymptoms.contains(wsSymptomName) ) dRS  += weight;
		}
		dDiff = dPSN - dRS;
		if ( dDiff < 0.0f ) dDiff = 0.0f;
		sigma += alpha2 * dDiff;
	    }
	}
	ss.setSigma(sigma);
	sortableSymptoms.addElement(ss);
    }
    Collections.sort(sortableSymptoms);
    return sortableSymptoms;
    }
}
