// (C) OntoOO Inc 2000
package init;

import com.Common;
import com.LR;
import concepts.*;

// Aspects for a disease::
// disease def:
// set printName              Dis.setPrintName("");
// set super disease          Dis.setSuperDisease(LR.aRFinCOPD);
// set underlying disease     Dis.setUnderlyingDisease(LR.COPD); 
// caused by:                 Dis.addExternalCause(...)
// temperature                Dis.setTemperature(LR.highFever);
// symptoms:                  Dis.addSymptom(LR.airHunger);
// treatments:
// causing:                   Dis.addInternalCause(LR.pneumonia);
// can cause:                 Dis.addCausesDisease(LR.lungAbscess);
// references:                Dis.addReference("pp 501-4");
// comments:                  Dis.setMiscComments("");
// causing abnormal conditions Dis.addCausingAbnormalCondition(LR.dead);
// causes abnormal conditions / complications
//                            Dis.addCausesAbnormalCondition(LR.hypoxemia);

public class InitNoseDiseases {
  public static void doit() {

// -------------- epistaxis --------------
// (C) OntoOO Inc Wed Feb 05 16:01:25 PST 2003
Disease epistaxisDis = new Disease(
   LR.epistaxis, 
   "nosebleed", 
   LR.noseDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -2, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.noseSysSt, 
   LR.trauma
);
epistaxisDis.addSymptom(LR.bleedingFromMouth, "dark or bright red", 1.0f);
epistaxisDis.addSymptom(LR.bleedingFromNose, "bright red", 1.0f);
epistaxisDis.addSymptom(LR.dizziness, "when substantial bloodloss", 0.2f);
epistaxisDis.addSymptom(LR.lightHeadedness, "when substantial bloodloss", 0.2f);
epistaxisDis.addExternalCause(LR.aspirinUse);
epistaxisDis.addInternalCause(LR.anemia);
epistaxisDis.addExternalCause(LR.highAltitude);
epistaxisDis.addInternalCause(LR.hemophilia);
epistaxisDis.addInternalCause(LR.hodgkinDisease);
epistaxisDis.addInternalCause(LR.hypertension);
epistaxisDis.addInternalCause(LR.idiopathicThrombocytopenicPurpura);
epistaxisDis.addInternalCause(LR.leukemia);
epistaxisDis.addInternalCause(LR.rheumaticFever);
epistaxisDis.addInternalCause(LR.vitaminCDeficiency);
epistaxisDis.addInternalCause(LR.vitaminKDeficiency);
epistaxisDis.addReference("pp 1210-2");
epistaxisDis.setMiscComments("Twice as common in children than in adults");
Treatment epistaxisTr1 = new Treatment("epistaxisTr1");
epistaxisTr1.addTreatmentAction(LR.externalPressure);
epistaxisDis.addTreatment("epistaxisTr1");
Treatment epistaxisTr2  = new Treatment("epistaxisTr2", LR.ifSevereBleeding);
epistaxisTr2.addTreatmentAction(LR.cottonBall);
epistaxisTr2.addTreatmentAction(LR.cauterization);
epistaxisDis.addTreatment(epistaxisTr2.getName());


// -------------- sinusitis --------------
// (C) OntoOO Inc Tue Oct 22 16:36:55 PDT 2002
Disease sinusitisDis = new Disease(
   LR.sinusitis, 
   "inflammation of the sinuses - the conduit above the nose ", 
   LR.noseDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.noseSysSt, 
   LR.infection
);
sinusitisDis.setTemperature((float)99.5);
sinusitisDis.addSymptom(LR.headache, "", 1.0f);
sinusitisDis.addSymptom(LR.malaise, "", 1.0f);
sinusitisDis.addSymptom(LR.noseDischarge, "", 1.0f);
sinusitisDis.addSymptom(LR.throatSore, "", 1.0f);
sinusitisDis.addInternalCause(LR.bronchiectasis); 
sinusitisDis.addInternalCause(LR.pharyngitisStreptococcal);
sinusitisDis.addReference("pp 1213-1215");
Treatment sinusitisTr1  = new Treatment("sinusitisTr1");
sinusitisTr1.addTreatmentAction(LR.steamInhalation);
sinusitisTr1.addDrug(LR.decongestant);
sinusitisDis.addTreatment(sinusitisTr1.getName());
Treatment sinusitisTr2 = new Treatment("sinusitisTr2", LR.ifInfection);
sinusitisTr2.addDrug(LR.antibiotics);
sinusitisDis.addTreatment("sinusitisTr2");

  } // end doit()

} // end InitNoseDiseases
