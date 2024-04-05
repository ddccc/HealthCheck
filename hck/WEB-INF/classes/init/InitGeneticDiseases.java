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

public class InitGeneticDiseases {
  public static void doit() {


// -------------- cysticFibrosis --------------
// (C) OntoOO Inc Mon Feb 23 19:01:18 PST 2004
Disease cysticFibrosisDis = new Disease(
   LR.cysticFibrosis, 
   "genetic dysfunction of the endocrine glands that affects multiple organs", 
   LR.geneticDisorders, 
   LR.none, // genderSpecificity 
   LR.caucasian, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.exocrineGlandsSysSt, 
   LR.none
);
cysticFibrosisDis.setPrintName("cystic fibrosis");
cysticFibrosisDis.setGenetic("1parent");
cysticFibrosisDis.setParentDisease(LR.cysticFibrosis);
cysticFibrosisDis.addSymptom(LR.arrhythmia, "", 1.0f);
cysticFibrosisDis.addSymptom(LR.coughDry, "", 1.0f);
cysticFibrosisDis.addSymptom(LR.dyspnea, "", 1.0f);
cysticFibrosisDis.addSymptom(LR.tachypnea, "", 1.0f);
cysticFibrosisDis.addSymptom(LR.wheezing, "", 1.0f);
cysticFibrosisDis.addCausingAbnormalCondition(LR.shock);
cysticFibrosisDis.addCausesDisease(LR.hypochloremia);
cysticFibrosisDis.addCausesDisease(LR.hyponatremia);
cysticFibrosisDis.addCausesDisease(LR.atelectasis);
cysticFibrosisDis.addCausesDisease(LR.emphysema);
cysticFibrosisDis.addReference("pp 15-17");
cysticFibrosisDis.setMiscComments(
   "transmitted as a recessive trait its outcome is fatal. " +
   "Life expectancy has risen above 16 to 28 and more");
cysticFibrosisDis.setCode358(171);
cysticFibrosisDis.setICD10code("E84");


// -------------- hemophilia --------------
// (C) OntoOO Inc Sun Feb 02 18:07:50 PST 2003
Disease hemophiliaDis = new Disease(
   LR.hemophilia, 
   "bleeding disorder due to a deficiency of clotting factors", 
   LR.geneticDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.hematologicSysSt, 
   LR.none
);
hemophiliaDis.setGenetic("mother");
hemophiliaDis.setParentDisease(LR.hemophilia);
hemophiliaDis.addSymptom(LR.bleedingAbnormal);
hemophiliaDis.addSymptom(LR.bleedingProlonged);
hemophiliaDis.addReference("pp 25-8");
hemophiliaDis.setMiscComments(
   "50% of sons is affected; there are two variants: A 80% and B 20%");


// -------------- sickleCellCrisis --------------
// (C) OntoOO Inc Thu Dec 06 16:04:26 PST 2001
Disease sickleCellCrisisDis = new Disease(
   LR.sickleCellCrisis, 
   "complication of sickle cell anemia", 
   LR.geneticDisorders, 
   LR.none, // genderSpecificity 
   LR.africanAmerican, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.hematologicSysSt, 
   LR.none
);
sickleCellCrisisDis.setPrintName("sickle cell crisis");
sickleCellCrisisDis.setUnderlyingDisease(LR.sickleCellAnemia); 
sickleCellCrisisDis.setTemperature((float)104.0);
sickleCellCrisisDis.addSymptom(LR.irritability);
sickleCellCrisisDis.addSymptom(LR.lethargy);
sickleCellCrisisDis.addSymptom(LR.painSevere);
sickleCellCrisisDis.addSymptom(LR.lipsPale); 
sickleCellCrisisDis.addSymptom(LR.nailsPale); 
sickleCellCrisisDis.addSymptom(LR.palmsPale); 
sickleCellCrisisDis.addSymptom(LR.tonguePale); 
sickleCellCrisisDis.addReference("pp 21-4");

Treatment sickleCellCrisisTr1  = new Treatment("sickleCellCrisisTr1");
sickleCellCrisisTr1.addTreatmentAction(LR.IVFluids);
sickleCellCrisisTr1.addTreatmentAction(LR.bloodTransfusion);
sickleCellCrisisTr1.addTreatmentAction(LR.oxygenTherapy);
sickleCellCrisisTr1.addDrug(LR.analgetics);
sickleCellCrisisTr1.addDrug(LR.sedatives);
sickleCellCrisisDis.addTreatment(sickleCellCrisisTr1.getName());


// -------------- sickleCellAnemia --------------
// (C) OntoOO Inc Thu Dec 06 21:48:41 PST 2001
// (C) OntoOO Inc Fri Sep 10 12:09:34 GMT-08:00 2004
Disease sickleCellAnemiaDis = new Disease(
   LR.sickleCellAnemia, 
   "congenital defective hemoglobin molecule causing malfunctioning blood cells", 
   LR.geneticDisorders, 
   LR.none, // genderSpecificity 
   LR.africanAmerican, // raceSpecificity 
   2, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.hematologicSysSt, 
   LR.none
);
sickleCellAnemiaDis.setPrintName("sickle cell anemia");
sickleCellAnemiaDis.addSymptom(LR.dyspnea, "", 1.0f);
sickleCellAnemiaDis.addSymptom(LR.tachycardia, "", 1.0f);
sickleCellAnemiaDis.addSymptom(LR.chestPain, "", 1.0f);
sickleCellAnemiaDis.addSymptom(LR.jaundice, "", 1.0f);
sickleCellAnemiaDis.addSymptom(LR.pallor, "", 1.0f);
sickleCellAnemiaDis.addSymptom(LR.bonePain);
sickleCellAnemiaDis.addSymptom(LR.chestPain);
sickleCellAnemiaDis.addSymptom(LR.fatigueProlonged);
sickleCellAnemiaDis.addSymptom(LR.jointSwelling);
sickleCellAnemiaDis.addCausesDisease(LR.corPulmonale);
sickleCellAnemiaDis.addCausesAbnormalCondition(LR.cardiacEnlargement);
sickleCellAnemiaDis.addCausesAbnormalCondition(LR.hepatomegaly);
sickleCellAnemiaDis.addReference("pp 21-5");
sickleCellAnemiaDis.setMiscComments("half die in early twenties; few live to middle age");
Treatment sickleCellAnemiaTr1  = new Treatment("sickleCellAnemiaTr1");
sickleCellAnemiaTr1.addDrug(LR.penicillin);
sickleCellAnemiaDis.addTreatment(sickleCellAnemiaTr1.getName());



  } // end doit()

} // end InitGeneticDiseases


