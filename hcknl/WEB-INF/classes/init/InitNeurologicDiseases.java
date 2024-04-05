// (C) OntoOO Inc 2000
package init;

import com.LR;
import com.D;
import com.F;
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

public class InitNeurologicDiseases {
  public static void doit() {

// -------------- alzheimer --------------
// (C) OntoOO Inc Wed Apr 16 16:03:26 PDT 2003
Disease alzheimerDis = new Disease(
   LR.alzheimer, 
   "progressive dementia due to gradual detoriation of the brain ", 
   LR.neurologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.brainSysSt, 
   LR.none
);
alzheimerDis.addReference("pp 638-40");
Treatment alzheimerTr1 = new Treatment("alzheimerTr1");
alzheimerTr1.addTreatmentAction(LR.oxygenTherapy);
alzheimerTr1.addDrug(LR.antidepressants);
alzheimerTr1.addDrug(LR.cerebralVasodilators);
alzheimerTr1.addDrug(LR.psychostimulators);
alzheimerTr1.addDrug(LR.tacrine);
alzheimerTr1.addDrug(LR.vitaminE);
alzheimerDis.addTreatment(alzheimerTr1.getName()); 
alzheimerDis.setCode358(189);
alzheimerDis.setICD10code("G30");


// -------------- alzheimer1 --------------
// (C) OntoOO Inc Thu Apr 17 08:39:02 PDT 2003
Disease alzheimer1Dis = new Disease(
   LR.alzheimer1, 
   "progressive dementia due to gradual detoriation of the brain early phase", 
   LR.neurologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.brainSysSt, 
   LR.none
);
alzheimer1Dis.setPrintName("alzheimer 1");
alzheimer1Dis.setSuperDisease(LR.alzheimer);
alzheimer1Dis.addSymptom(LR.concentrationLoss, "", 1.0f);
alzheimer1Dis.addSymptom(LR.forgetfulness, "", 1.0f);
alzheimer1Dis.addSymptom(LR.memoryRecentLoss, "", 1.0f);
alzheimer1Dis.addSymptom(LR.learningDifficulty, "", 1.0f);
alzheimer1Dis.addCausesDisease(LR.alzheimer2);
alzheimer1Dis.addReference("pp 638-40");
alzheimer1Dis.setCode358(189);
alzheimer1Dis.setICD10code("G30");


// -------------- alzheimer2 --------------
// (C) OntoOO Inc Thu Apr 17 08:58:07 PDT 2003
Disease alzheimer2Dis = new Disease(
   LR.alzheimer2, 
   "progressive dementia due to gradual detoriation of the brain 2nd phase", 
   LR.neurologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.brainSysSt, 
   LR.none
);
alzheimer2Dis.setPrintName("alzheimer 2");
alzheimer2Dis.setSuperDisease(LR.alzheimer);
alzheimer2Dis.addSymptom(LR.concentrationLoss, "", 1.0f);
alzheimer2Dis.addSymptom(LR.forgetfulness, "", 1.0f);
alzheimer2Dis.addSymptom(LR.memoryRecentLoss, "", 1.0f);
alzheimer2Dis.addSymptom(LR.learningDifficulty, "", 1.0f);
alzheimer2Dis.addSymptom(LR.abstractThinkingImpaired);
alzheimer2Dis.addSymptom(LR.judgementImpaired); 
alzheimer2Dis.addInternalCause(LR.alzheimer1);
alzheimer2Dis.addCausesDisease(LR.alzheimer3);
alzheimer2Dis.addReference("pp 638-40");
alzheimer2Dis.setCode358(189);
alzheimer2Dis.setICD10code("G30");


// -------------- alzheimer3 --------------
// (C) OntoOO Inc Thu Apr 17 09:59:07 PDT 2003
Disease alzheimer3Dis = new Disease(
   LR.alzheimer3, 
   "progressive dementia due to gradual detoriation of the brain 3rd phase", 
   LR.neurologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.brainSysSt, 
   LR.none
);
alzheimer3Dis.setPrintName("alzheimer 3");
alzheimer3Dis.setSuperDisease(LR.alzheimer);
alzheimer3Dis.addSymptom(LR.concentrationLoss, "", 1.0f);
alzheimer3Dis.addSymptom(LR.forgetfulness, "", 1.0f);
alzheimer3Dis.addSymptom(LR.memoryRecentLoss, "", 1.0f);
alzheimer3Dis.addSymptom(LR.learningDifficulty, "", 1.0f);
alzheimer3Dis.addSymptom(LR.abstractThinkingImpaired, "", 1.0f);
alzheimer3Dis.addSymptom(LR.judgementImpaired, "", 1.0f);

alzheimer3Dis.addSymptom(LR.communicationImpaired, "", 1.0f);
alzheimer3Dis.addSymptom(LR.memoryDetoriation, "", 1.0f);
alzheimer3Dis.addSymptom(LR.languageDetoriation, "", 1.0f);
alzheimer3Dis.addSymptom(LR.coordinationDetoriation, "", 1.0f);

alzheimer3Dis.addSymptom(LR.personalityChange, "", 1.0f);
alzheimer3Dis.addSymptom(LR.restlessness, "", 1.0f);
alzheimer3Dis.addSymptom(LR.irritability, "", 1.0f);
alzheimer3Dis.addInternalCause(LR.alzheimer2);
alzheimer3Dis.addReference("pp 638-40");
alzheimer3Dis.setCode358(189);
alzheimer3Dis.setICD10code("G30");


// -------------- amyotropicLateralSclerosis --------------
// (C) OntoOO Inc Wed Jun 19 14:03:51 PDT 2002
Disease amyotropicLateralSclerosisDis = new Disease(
   LR.amyotropicLateralSclerosis, 
   "motor neuron defect leading to muscle atrophy, Lou Gehrig disease", 
   LR.neurologicDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   70,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.neurologicSysSt, 
   LR.none
);
amyotropicLateralSclerosisDis.setPrintName("amyotropic lateral sclerosis");
amyotropicLateralSclerosisDis.setGenetic("1parent");
amyotropicLateralSclerosisDis.setParentDisease(LR.amyotropicLateralSclerosis );
amyotropicLateralSclerosisDis.addSymptom(LR.breathingDifficult, "", 1.0f); 
amyotropicLateralSclerosisDis.addSymptom(LR.chewingDifficult, "", 1.0f); 
amyotropicLateralSclerosisDis.addSymptom(LR.choking, "", 0.2f); 
amyotropicLateralSclerosisDis.addSymptom(LR.drooling, "", 0.2f); 
amyotropicLateralSclerosisDis.addSymptom(LR.muscleWeakness, "", 1.0f); 
amyotropicLateralSclerosisDis.addSymptom(LR.speechDifficulty, "", 1.0f); 
amyotropicLateralSclerosisDis.addSymptom(LR.dysphagia, "", 1.0f); 
amyotropicLateralSclerosisDis.addCausesDisease(LR.corPulmonale);
amyotropicLateralSclerosisDis.addReference("pp 647-9");
amyotropicLateralSclerosisDis.setMiscComments("no effective treatment");


// -------------- bellPalsy --------------
// (C) OntoOO Inc Thu May 15 16:14:07 PDT 2003
Disease bellPalsyDis = new Disease(
   LR.bellPalsy, 
   "blockage of face nerve causing face weakness or paralysis", 
   LR.neurologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -5, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.cranialNerve7thSysSt, 
   LR.none
);
bellPalsyDis.setPrintName("Bell palsy");
bellPalsyDis.addSymptom(LR.mouthDroops);
bellPalsyDis.addSymptom(LR.tasteLoss, "", 0.5f);
bellPalsyDis.addSymptom(LR.tinnitus, "", 0.5f);
bellPalsyDis.addReference("pp 654-5");
bellPalsyDis.setMiscComments("in 80% of the patients it subsides spontaneously in 1 to 8 weeks"); 
Treatment bellPalsyTr1  = new Treatment("bellPalsyTr1");
bellPalsyTr1.addDrug(LR.prednisone);
bellPalsyDis.addTreatment(bellPalsyTr1.getName());


    // -------------- brainAbscess  ---------------
// (C) OntoOO Inc Thu Nov 01 13:38:06 PST 2001
Disease brainAbscessDis = new Disease(
   LR.brainAbscess, 
   "a collection of pus in the brain", 
   LR.neurologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   10, //  minAge 
   30, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.brainSysSt, 
   LR.none
);
brainAbscessDis.setPrintName("brain abscess");

brainAbscessDis.addSymptom(LR.headacheConstant, "", 1.0f); 
brainAbscessDis.addSymptom(LR.nausea, "", 1.0f); 
brainAbscessDis.addSymptom(LR.ocularDisturbance, "", 1.0f); 
brainAbscessDis.addSymptom(LR.seizure, "", 1.0f); 
brainAbscessDis.addSymptom(LR.vomiting, "", 1.0f);
 
brainAbscessDis.addReference("pp 631-4");
brainAbscessDis.setMiscComments(
     "fatal when untreated; 30% develop focal seizures");

Treatment brainAbscessTr1  = new Treatment("brainAbscessTr1");
brainAbscessTr1.addTreatmentAction(LR.bedRest);
brainAbscessTr1.addTreatmentAction(LR.drainageOfAbscess);
brainAbscessTr1.addDrug(LR.analgetics);
brainAbscessTr1.addDrug(LR.antibiotics);
brainAbscessDis.addTreatment(brainAbscessTr1.getName());


    // -------------- cerebralAneurysm  ---------------
// (C) OntoOO Inc Fri Nov 02 09:16:00 PST 2001
Disease cerebralAneurysmDis = new Disease(
   LR.cerebralAneurysm, 
   "rupture of an artery in the brain (often in the Willis Circle)", 
   LR.neurologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.brainSysSt, 
   LR.none
);
cerebralAneurysmDis.setPrintName("cerebral aneurysm");

cerebralAneurysmDis.addSymptom(LR.consciousnessDecreased, "", 1.0f);
cerebralAneurysmDis.addSymptom(LR.dysphagia, "", 1.0f);
cerebralAneurysmDis.addSymptom(LR.headache, "", 1.0f);
cerebralAneurysmDis.addSymptom(LR.nausea, "", 1.0f);
cerebralAneurysmDis.addSymptom(LR.nuchalRigidity, "", 1.0f);
cerebralAneurysmDis.addSymptom(LR.visionBlurred, "", 1.0f);
cerebralAneurysmDis.addSymptom(LR.pupilChanges, "", 1.0f);
cerebralAneurysmDis.addSymptom(LR.seizure, "", 1.0f);
cerebralAneurysmDis.addSymptom(LR.backStiff, "", 1.0f);
cerebralAneurysmDis.addSymptom(LR.legStiff, "", 1.0f);

cerebralAneurysmDis.addReference("pp 614-8");
cerebralAneurysmDis.setMiscComments("mortality is over 50%");

Treatment cerebralAneurysmTr1 = new Treatment("cerebralAneurysmTr1");
cerebralAneurysmTr1.addTreatmentAction(LR.bedRest);
cerebralAneurysmTr1.addTreatmentAction(LR.surgery);
cerebralAneurysmTr1.addDrug(LR.corticosteroids);
cerebralAneurysmTr1.addDrug(LR.codeine);
cerebralAneurysmTr1.addDrug(LR.antihypertensives);
cerebralAneurysmTr1.addDrug(LR.calciumChannelBlockers);
cerebralAneurysmTr1.addDrug(LR.phenytoin);
cerebralAneurysmTr1.addDrug(LR.phenobarbital);
cerebralAneurysmTr1.addDrug(LR.fibrinolyticInhibitor);
cerebralAneurysmDis.addTreatment(cerebralAneurysmTr1.getName()); 


    // -------------- cerebrovascularAccident (= stroke)  ---------------
// (C) OntoOO Inc Fri Nov 02 16:41:58 PST 2001 
Disease cerebrovascularAccidentDis = new Disease( 
LR.cerebrovascularAccident, 
"(stroke) impairment of one or more brain blood vessels ", 
LR.neurologicDisorders, 
LR.none, // genderSpecificity 
LR.none, // raceSpecificity 
0, // minAge 
LR.maxAge, // maxAge 
0, // duration 
-1, // diagnosis frequency, -1 = unknown 
LR.brainSysSt, 
LR.none 
); 
cerebrovascularAccidentDis.setPrintName("cerebrovascular accident"); 

cerebrovascularAccidentDis.addSymptom(LR.amnesia, "", 1.0f); 
cerebrovascularAccidentDis.addSymptom(LR.aphasia, "", 1.0f); 
cerebrovascularAccidentDis.addSymptom(LR.confusion, "", 1.0f); 
cerebrovascularAccidentDis.addSymptom(LR.dysphasia, "", 1.0f); 
cerebrovascularAccidentDis.addSymptom(LR.hemiparesis, "", 1.0f); 
cerebrovascularAccidentDis.addSymptom(LR.pupilChanges, "", 1.0f); 
cerebrovascularAccidentDis.addSymptom(LR.sensoryChanges, "", 1.0f); 
cerebrovascularAccidentDis.addSymptom(LR.speechSlurred, "", 1.0f); 
cerebrovascularAccidentDis.addSymptom(LR.weakness, "", 1.0f); 
cerebrovascularAccidentDis.addInternalCause(LR.hypertension);

cerebrovascularAccidentDis.addReference("pp 623-7"); 

Treatment cerebrovascularAccidentTr1 = new Treatment("cerebrovascularAccidentTr1");
cerebrovascularAccidentTr1.addTreatmentAction(LR.surgery);
cerebrovascularAccidentTr1.addTreatmentAction(LR.antiplateletAggregateTherapy);
cerebrovascularAccidentTr1.addDrug(LR.anticonvulsants);
cerebrovascularAccidentTr1.addDrug(LR.analgetics);
cerebrovascularAccidentTr1.addDrug(LR.stoolSoftener);
cerebrovascularAccidentDis.addTreatment(cerebrovascularAccidentTr1.getName()); 
cerebrovascularAccidentDis.setCode358(238);
cerebrovascularAccidentDis.setICD10code("I64");


// -------------- chorea --------------
// (C) OntoOO Inc Wed Nov 13 09:26:37 PST 2002
Disease choreaDis = new Disease(
   LR.chorea, 
   "brief purposeless involuntary movements of the extremities and face", 
   LR.neurologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.centralNervousSysSt, 
   LR.none
);
choreaDis.addSymptom(LR.faceSpasm, "", 0.6f);
choreaDis.addSymptom(LR.fingerSpasm, "", 0.4f);
choreaDis.addSymptom(LR.footSpasm, "", 0.2f);
choreaDis.addSymptom(LR.handSpasm, "", 0.4f);
choreaDis.addSymptom(LR.spasm, "", 1.0f); 
choreaDis.addReference("1087 and 634-5");
choreaDis.setMiscComments("variants: transient, permanent - hereditary");


// -------------- huntingtonDisease --------------
// (C) OntoOO Inc Wed Nov 13 21:31:13 PST 2002
Disease huntingtonDiseaseDis = new Disease(
   LR.huntingtonDisease, 
   "brief purposeless involuntary muscle movements which worsens " +
   "over time progressing into dementia", 
   LR.neurologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   25, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.centralNervousSysSt, 
   LR.none
);
huntingtonDiseaseDis.setPrintName("Huntington disease");
huntingtonDiseaseDis.setSuperDisease(LR.chorea);
huntingtonDiseaseDis.setGenetic("1parent");
huntingtonDiseaseDis.setParentDisease(LR.huntingtonDisease);
huntingtonDiseaseDis.addSymptom(LR.clumsy);
huntingtonDiseaseDis.addSymptom(LR.focussingDifficulty);
huntingtonDiseaseDis.addSymptom(LR.impulsive);
huntingtonDiseaseDis.addSymptom(LR.learningDifficulty);
huntingtonDiseaseDis.addReference("pp 634-5");
huntingtonDiseaseDis.setMiscComments(
   "slow detoriation during 10-15 years including personality changes");
Treatment huntingtonDiseaseTr1  = new Treatment("huntingtonDiseaseTr1");
huntingtonDiseaseTr1.addDrug(LR.tranquilizer);
huntingtonDiseaseDis.addTreatment(huntingtonDiseaseTr1.getName());


// -------------- choreaTransient --------------
// (C) OntoOO Inc Thu Nov 14 15:11:03 PST 2002
Disease choreaTransientDis = new Disease(
   LR.choreaTransient, 
   "brief purposeless involuntary muscle movements - this disease is temporary", 
   LR.neurologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   25, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.centralNervousSysSt, 
   LR.none
);
choreaTransientDis.setPrintName("chorea transient");
choreaTransientDis.setSuperDisease(LR.chorea);
choreaTransientDis.addSymptom(LR.concentrationLoss);
choreaTransientDis.addSymptom(LR.irritability);
choreaTransientDis.addSymptom(LR.weakness);
choreaTransientDis.addInternalCause(LR.rheumaticFever);
choreaTransientDis.addReference("pp 1087-8");
choreaTransientDis.setMiscComments("no residual neurologic damage ");


// -------------- chronicHeadache --------------
// (C) OntoOO Inc Fri May 30 13:13:05 PDT 2003
Disease chronicHeadacheDis = new Disease(
   LR.chronicHeadache, 
   "chronic headache", 
   LR.neurologicDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.neurologicSysSt, 
   LR.none
);
chronicHeadacheDis.setPrintName();
chronicHeadacheDis.addSymptom(LR.anorexia, "", 0.2f);
chronicHeadacheDis.addSymptom(LR.headacheConstant, "", 1.0f);
chronicHeadacheDis.addSymptom(LR.headacheSevere, "", 1.0f);
chronicHeadacheDis.addSymptom(LR.irritability, "", 0.2f);
chronicHeadacheDis.addSymptom(LR.nausea, "", 0.2f);
chronicHeadacheDis.addSymptom(LR.photophobia, "", 0.2f);
chronicHeadacheDis.addSymptom(LR.vomiting, "", 0.2f);
chronicHeadacheDis.addReference("pp 618-20");
Treatment chronicHeadacheTr1 = new Treatment("chronicHeadacheTr1");
chronicHeadacheTr1.addDrug(LR.aspirin);
chronicHeadacheDis.addTreatment("chronicHeadacheTr1");
Treatment chronicHeadacheTr2  = new Treatment("chronicHeadacheTr2", LR.ifAcute);
chronicHeadacheTr2.addDrug(LR.diazepam);
chronicHeadacheDis.addTreatment(chronicHeadacheTr2.getName());


    // -------------- encephalitis  ---------------
// (C) OntoOO Inc Wed Nov 14 01:07:13 PST 2001 
Disease encephalitisDis = new Disease( 
LR.encephalitis, 
"inflammation of the brain caused by a virus", 
LR.neurologicDisorders, 
LR.none, // genderSpecificity 
LR.none, // raceSpecificity 
0, // minAge 
LR.maxAge, // maxAge 
0, // duration 
-1, // diagnosis frequency, -1 = unknown 
LR.brainSysSt, 
LR.none 
); 
encephalitisDis.setTemperature((float)100.0); 

encephalitisDis.addSymptom(LR.ataxia);
encephalitisDis.addSymptom(LR.backStiff);
encephalitisDis.addSymptom(LR.coma, "", 1.0f);
encephalitisDis.addSymptom(LR.drowsiness, "", 1.0f);
encephalitisDis.addSymptom(LR.feverRapidOnset);
encephalitisDis.addSymptom(LR.headache, "", 1.0f);
encephalitisDis.addSymptom(LR.neckStiff);
encephalitisDis.addSymptom(LR.paralysis);
encephalitisDis.addSymptom(LR.psychosis);
encephalitisDis.addSymptom(LR.seizure, "", 1.0f);
encephalitisDis.addSymptom(LR.vomiting, "", 1.0f);
encephalitisDis.addInternalCause(LR.lymeDisease);
encephalitisDis.addInternalCause(LR.toxoplasmosisAcquiredAdvanced);
encephalitisDis.addInternalCause(LR.westNileVirus);
encephalitisDis.addReference("pp 630");

Treatment encephalitisTr1  = new Treatment("encephalitisTr1");
encephalitisTr1.addTreatmentAction(LR.bedRest);
encephalitisTr1.addTreatmentAction(LR.seizurePrecautions);
encephalitisTr1.addDrug(LR.acyclovir);
encephalitisTr1.addDrug(LR.analgetics);
encephalitisTr1.addDrug(LR.anticonvulsants);
encephalitisTr1.addDrug(LR.furosemide);
encephalitisTr1.addDrug(LR.mannitol);
encephalitisTr1.addDrug(LR.glucocorticoids);
encephalitisDis.addTreatment(encephalitisTr1.getName());
encephalitisDis.setCode358(39);
encephalitisDis.setICD10code("A83");

// -------------- epilepsy --------------
// (C) OntoOO Inc Fri Jun 06 16:04:23 PDT 2003
Disease epilepsyDis = new Disease(
   LR.epilepsy, 
   "recurrent seizures", 
   LR.neurologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.brainSysSt, 
   LR.none
);
epilepsyDis.addSymptom(LR.seizure, "", 1.0f);
epilepsyDis.addSymptom(LR.hallucinations, "", 0.05f);
epilepsyDis.addSymptom(LR.muscleContractions, "", 0.1f); 
epilepsyDis.addReference("pp 620-3");
epilepsyDis.setMiscComments(
    "seizures come in different types, some with more or less loss of consciousness");
Treatment epilepsyTr1  = new Treatment("epilepsyTr1");
epilepsyTr1.addDrug(LR.phenobarbital);
epilepsyTr1.addDrug(LR.phenytoin);
epilepsyTr1.addDrug(LR.carbamazepine);
epilepsyTr1.addDrug(LR.primidone);
epilepsyDis.addTreatment(epilepsyTr1.getName());
epilepsyDis.setCode358(191);
epilepsyDis.setICD10code("G40");


    // -------------- guillainBarreSyndrome  ---------------
// (C) OntoOO Inc Tue Jul 17 11:16:47 PDT 2001
Disease guillainBarreSyndromeDis = new Disease(
   LR.guillainBarreSyndrome, 
   "acute, rapidly developing sometimes fatal nerve disease causing " +
   "muscle weakness, sensory disturbances and/or lost reflexes", 
   LR.neurologicDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   50, //  maxAge 
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.neurologicSysSt, 
   LR.none
);
guillainBarreSyndromeDis.setPrintName("Guillain-Barre Syndrome");
guillainBarreSyndromeDis.addSymptom(LR.dysarthria, "", 0.7f);
guillainBarreSyndromeDis.addSymptom(LR.dysphagia, "", 0.7f);
guillainBarreSyndromeDis.addSymptom(LR.muscleWeakness, "", 1.0f);
guillainBarreSyndromeDis.addSymptom(LR.paresthesia, "", 1.0f);
guillainBarreSyndromeDis.addSymptom(LR.stiffness, "", 1.0f);
guillainBarreSyndromeDis.addInternalCause(LR.campylobacteriosis);

guillainBarreSyndromeDis.addCausesAbnormalCondition(LR.areflexia);
guillainBarreSyndromeDis.addCausesAbnormalCondition(LR.hypotonia);
guillainBarreSyndromeDis.addReference("pp 642-645");
guillainBarreSyndromeDis.setMiscComments(
   "recovery is spontaneous and complete in about 95% of patients");


// -------------- hydrocephalus --------------
// (C) OntoOO Inc Tue Mar 25 11:34:35 PST 2003
Disease hydrocephalusDis = new Disease(
   LR.hydrocephalus, 
   "excessive accumulation of fluid within the brain", 
   LR.neurologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.brainSysSt, 
   LR.none
);
hydrocephalusDis.addInternalCause(LR.precociousPubertyFemaleCerebral);
hydrocephalusDis.addInternalCause(LR.precociousPubertyMaleCerebral);
hydrocephalusDis.addInternalCause(LR.toxoplasmosisCongenital);
hydrocephalusDis.addReference("pp 611-4");
Treatment hydrocephalusTr1  = new Treatment("hydrocephalusTr1");
hydrocephalusTr1.addTreatmentAction(LR.surgery);
hydrocephalusDis.addTreatment(hydrocephalusTr1.getName());


// -------------- hydrocephalusAdult --------------
// (C) OntoOO Inc Tue May 11 16:25:55 PDT 2004
Disease hydrocephalusAdultDis = new Disease(
   LR.hydrocephalusAdult, 
   "excessive accumulation of fluid within the brain of an adult", 
   LR.neurologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   1, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.brainSysSt, 
   LR.injury
);
hydrocephalusAdultDis.setPrintName("hydrocephalus of an adult");
hydrocephalusAdultDis.setSuperDisease(LR.hydrocephalus);
hydrocephalusAdultDis.addSymptom(LR.ataxia);
hydrocephalusAdultDis.addSymptom(LR.consciousnessDecreased);
hydrocephalusAdultDis.addSymptom(LR.incontinence);
hydrocephalusAdultDis.addSymptom(LR.intellectImpaired);
hydrocephalusAdultDis.addReference("pp 611-4");


// -------------- hydrocephalusInfant --------------
// (C) OntoOO Inc Tue May 11 15:22:45 PDT 2004
Disease hydrocephalusInfantDis = new Disease(
   LR.hydrocephalusInfant, 
   "excessive accumulation of fluid within the brain of an infant", 
   LR.neurologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   1,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.brainSysSt, 
   LR.none
);
hydrocephalusInfantDis.setPrintName("hydrocephalus of an infant");
hydrocephalusInfantDis.setSuperDisease(LR.hydrocephalus);
hydrocephalusInfantDis.addSymptom(LR.skullDistension);
hydrocephalusInfantDis.addSymptom(LR.anorexia);
hydrocephalusInfantDis.addSymptom(LR.irritability);
hydrocephalusInfantDis.addReference("pp 611-4");


    // -------------- meningitis ---------------
// (C) OntoOO Inc Thu Aug 09 17:53:17 PDT 2001
Disease meningitisDis = new Disease(
   LR.meningitis, 
   "inflammation of the brain and spinal cord typically due to a bacterial infection", 
   LR.neurologicDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   F.meningitisFreq,
   LR.centralNervousSysSt, 
   LR.none
);
meningitisDis.setTemperature((float)100.0);

meningitisDis.addSymptom(LR.arrhythmia);
meningitisDis.addSymptom(LR.chills, "", 1.0f);
meningitisDis.addSymptom(LR.coma);
meningitisDis.addSymptom(LR.headache, "", 1.0f);
meningitisDis.addSymptom(LR.irritability);
meningitisDis.addSymptom(LR.malaise, "", 1.0f);
meningitisDis.addSymptom(LR.nuchalRigidity); 
meningitisDis.addSymptom(LR.opisthotonos); 
meningitisDis.addSymptom(LR.papilledema, "", 0.1f);
meningitisDis.addSymptom(LR.photophobia); 
meningitisDis.addSymptom(LR.stupor);
meningitisDis.addSymptom(LR.vomiting, "", 1.0f);
meningitisDis.addInternalCause(LR.pneumonia);
meningitisDis.addInternalCause(LR.sarcoidosisCNS);
meningitisDis.addInternalCause(LR.syphilisLateNeurologic);
meningitisDis.addInternalCause(LR.lymeDisease2);
meningitisDis.addInternalCause(LR.otitisMedia);
meningitisDis.addInternalCause(LR.listeriosisSuper);
meningitisDis.addReference("pp 627-30");

Treatment meningitisTr1 = new Treatment("meningitisTr1");
meningitisTr1.addTreatmentAction(LR.bedRest);
meningitisTr1.addDrug(LR.analgetics);
meningitisTr1.addDrug(LR.antibiotics);
meningitisTr1.addDrug(LR.anticonvulsants);
meningitisTr1.addDrug(LR.digitalisGlycosides);
meningitisTr1.addDrug(LR.sedatives);
meningitisDis.addTreatment(meningitisTr1.getName()); 
meningitisDis.setCode358(186);
meningitisDis.setICD10code("G00");


// -------------- multipleSclerosis --------------
// (C) OntoOO Inc Tue Jun 10 15:19:53 PDT 2003
Disease multipleSclerosisDis = new Disease(
   LR.multipleSclerosis, 
   "progressive destruction of white matter in the brain and spine", 
   LR.neurologicDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.neurologicSysSt, 
   LR.none
);
multipleSclerosisDis.setPrintName("multiple sclerosis");
multipleSclerosisDis.setGenetic("1parent");
multipleSclerosisDis.setParentDisease(LR.multipleSclerosis);
multipleSclerosisDis.addSymptom(LR.ataxia);
multipleSclerosisDis.addSymptom(LR.dysphagia);
multipleSclerosisDis.addSymptom(LR.incontinence);
multipleSclerosisDis.addSymptom(LR.irritability);
multipleSclerosisDis.addSymptom(LR.moodSwings);
multipleSclerosisDis.addSymptom(LR.numbness);
multipleSclerosisDis.addSymptom(LR.ocularDisturbance);
multipleSclerosisDis.addSymptom(LR.paralysis);
multipleSclerosisDis.addSymptom(LR.paresthesia);
multipleSclerosisDis.addSymptom(LR.spasm);
multipleSclerosisDis.addSymptom(LR.tremors);
multipleSclerosisDis.addSymptom(LR.urinaryFrequency);
multipleSclerosisDis.addSymptom(LR.urinaryUrgency);
multipleSclerosisDis.addSymptom(LR.weakness);
multipleSclerosisDis.addCausesDisease(LR.depression);
multipleSclerosisDis.addReference("pp 649-51");
multipleSclerosisDis.setMiscComments(
   "prognosis varies between fatal in several months to 25 years");
Treatment multipleSclerosisTr1  = new Treatment("multipleSclerosisTr1");
multipleSclerosisTr1.addTreatmentAction(LR.bedRest);
multipleSclerosisTr1.addTreatmentAction(LR.massage);
multipleSclerosisTr1.addDrug(LR.dexamethasone);
multipleSclerosisTr1.addDrug(LR.prednisone);
multipleSclerosisTr1.addDrug(LR.corticotropin);
multipleSclerosisDis.addTreatment(multipleSclerosisTr1.getName());
multipleSclerosisDis.setCode358(190);
multipleSclerosisDis.setICD10code("G35");


    // -------------- myastheniaGravis ---------------
// (C) OntoOO Inc Fri Jun 29 16:18:00 PDT 2001
Disease myastheniaGravisDis = new Disease(
   LR.myastheniaGravis, 
   "sporadic but progressive weakness of skeletal muscles", 
   LR.neurologicDisorders,
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.neurologicSysSt, 
   LR.none
);
myastheniaGravisDis.setPrintName("myasthenia gravis");
myastheniaGravisDis.addSymptom(LR.chewingDifficult);
myastheniaGravisDis.addSymptom(LR.diplopia);
myastheniaGravisDis.addSymptom(LR.fatigue);
myastheniaGravisDis.addSymptom(LR.ptosis);
myastheniaGravisDis.addSymptom(LR.dysphagia);
myastheniaGravisDis.addReference("pp 645-7");
Treatment myastheniaGravisTr1  = new Treatment("myastheniaGravisTr1");
myastheniaGravisTr1.addDrug(LR.corticosteroids);
myastheniaGravisTr1.addDrug(LR.anticholinesterase);
myastheniaGravisTr1.addDrug(LR.immunosuppressant);
myastheniaGravisTr1.addDrug(LR.plasmapheresis);
myastheniaGravisDis.addTreatment(myastheniaGravisTr1.getName());


// -------------- parkinson --------------
// (C) OntoOO Inc Wed Jun 11 10:13:54 PDT 2003
Disease parkinsonDis = new Disease(
   LR.parkinson, 
   "progressive muscle rigidity and involuntary tremors", 
   LR.neurologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   50, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.centralNervousSysSt, 
   LR.none
);
parkinsonDis.addSymptom(LR.akinesia);
parkinsonDis.addSymptom(LR.muscleRigid);
parkinsonDis.addSymptom(LR.tremors);
parkinsonDis.addReference("pp 635-7");
Treatment parkinsonTr1 = new Treatment("parkinsonTr1");
parkinsonTr1.addDrug(LR.levodopa);
parkinsonDis.addTreatment(parkinsonTr1.getName()); 
parkinsonDis.setCode358(188);
parkinsonDis.setICD10code("G20");


// -------------- trigeminalNeuralgia --------------
// (C) OntoOO Inc Thu Jun 12 13:57:00 PDT 2003
Disease trigeminalNeuralgiaDis = new Disease(
   LR.trigeminalNeuralgia, 
   "face nerve disorder causing sudden sharp pain flashes", 
   LR.neurologicDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   35, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.cranialNerve5thSysSt, 
   LR.none
);
trigeminalNeuralgiaDis.setPrintName("trigeminal neuralgia");
trigeminalNeuralgiaDis.addSymptom(LR.faceBurningPain);
trigeminalNeuralgiaDis.addSymptom(LR.faceSearingPain);
trigeminalNeuralgiaDis.addReference("pp 652-4");
trigeminalNeuralgiaDis.setMiscComments(
   "short-circuit of touch and pain fiber is probable cause");
trigeminalNeuralgiaDis.addIllustration(D.TrigeminalNeuralgiaGif);
Treatment trigeminalNeuralgiaTr1 = new Treatment("trigeminalNeuralgiaTr1");
trigeminalNeuralgiaTr1.addDrug(LR.carbamazepine);
trigeminalNeuralgiaTr1.addDrug(LR.phenytoin);
trigeminalNeuralgiaDis.addTreatment("trigeminalNeuralgiaTr1");
Treatment trigeminalNeuralgiaTr2 = new Treatment("trigeminalNeuralgiaTr2", LR.ifSevere);
trigeminalNeuralgiaTr2.addTreatmentAction(LR.surgery);
trigeminalNeuralgiaDis.addTreatment(trigeminalNeuralgiaTr2.getName()); 

  } // end doit()

} // end InitNeurologicDiseases
