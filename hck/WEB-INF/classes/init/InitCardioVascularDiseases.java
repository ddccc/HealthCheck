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
// causing abnormal conditions Dis.addCausingAbnormalCondition(LR.heartFailure);
// causes abnormal conditions / complications
//                            Dis.addCausesAbnormalCondition(LR.hypoxemia);

public class InitCardioVascularDiseases {
  public static void doit() {


// -------------- atrialSeptalDefect  --------------
// (C) OntoOO Inc Mon Dec 10 21:20:08 PST 2001
Disease atrialSeptalDefectDis = new Disease(
   LR.atrialSeptalDefect, 
   "incomplete separation of the atria heart chambers", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
atrialSeptalDefectDis.setPrintName("atrial septal defect");

atrialSeptalDefectDis.addSymptom(LR.dyspnea); 
atrialSeptalDefectDis.addSymptom(LR.fatigue);
atrialSeptalDefectDis.addSymptom(LR.breathlessness);
atrialSeptalDefectDis.addSymptom(LR.palpitations); 
atrialSeptalDefectDis.addReference("pp 1070-2"); 
atrialSeptalDefectDis.setMiscComments(
    "condition at birth; symptoms become more prevalent over time, " +
    "especially after 40"); 

Treatment atrialSeptalDefectTr1 = 
  new Treatment("atrialSeptalDefectTr1");
atrialSeptalDefectTr1.addTreatmentAction(LR.surgery);
atrialSeptalDefectDis.addTreatment(atrialSeptalDefectTr1.getName()); 


    // -------------- cardiacArrest ---------------
// (C) OntoOO Inc Thu Nov 01 15:28:00 PST 2001
Disease cardiacArrestDis = new Disease(
   LR.cardiacArrest, 
   "cardiac arrest", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
cardiacArrestDis.setPrintName();
cardiacArrestDis.addSymptom(LR.anuria, "", 1.0f);
cardiacArrestDis.addSymptom(LR.apnea, "", 1.0f);
cardiacArrestDis.addSymptom(LR.consciousnessLoss, "", 1.0f);
cardiacArrestDis.addSymptom(LR.coolExtremities, "", 1.0f);
cardiacArrestDis.addSymptom(LR.pulseAbsent, "", 1.0f);
cardiacArrestDis.addInternalCause(LR.hypokalemiaSuper);
cardiacArrestDis.addInternalCause(LR.hypertension);
cardiacArrestDis.addReference("pp 0");
Treatment cardiacArrestTr1  = new Treatment("cardiacArrestTr1");
cardiacArrestTr1.addTreatmentAction(LR.CPR);
cardiacArrestTr1.addTreatmentAction(LR.fluidManagement);
cardiacArrestTr1.addTreatmentAction(LR.mechanicalVentilation);
cardiacArrestTr1.addTreatmentAction(LR.oxygenTherapy);
cardiacArrestTr1.addTreatmentAction(LR.cardioversion); // =??
cardiacArrestTr1.addDrug(LR.epinephrine);
cardiacArrestTr1.addDrug(LR.lidocaine);
cardiacArrestTr1.addDrug(LR.bretyllium);
cardiacArrestDis.addTreatment(cardiacArrestTr1.getName());


// -------------- cardiacArrhythmia --------------
// (C) OntoOO Inc Thu Oct 06 11:53:11 PDT 2011
Disease cardiacArrhythmiaDis = new Disease(
   LR.cardiacArrhythmia,
   "abnormal heart rhythms some of which are life threatening",
   LR.cardioDisorders,
   LR.none, // genderSpecificity
   LR.none, // raceSpecificity
   0, // minAge
   LR.maxAge,
   0, // duration
   -1, // diagnosis frequency, -1 = unknown
   LR.cardioVascularSysSt,
   LR.none
);
cardiacArrhythmiaDis.setPrintName("cardiac arrhythmia");
cardiacArrhythmiaDis.addSymptom(LR.arrhythmia);
cardiacArrhythmiaDis.addSymptom(LR.chestPain, "", 0.3f);
cardiacArrhythmiaDis.addSymptom(LR.diaphoresis, "", 0.3f);
cardiacArrhythmiaDis.addSymptom(LR.dyspnea, "", 0.3f);
cardiacArrhythmiaDis.addSymptom(LR.lightHeadedness, "", 0.3f);
cardiacArrhythmiaDis.addSymptom(LR.palpitations, "", 0.3f);
cardiacArrhythmiaDis.addSymptom(LR.vertigo, "", 0.3f);
cardiacArrhythmiaDis.addSymptom(LR.weakness, "", 0.3f);
cardiacArrhythmiaDis.addReference("pp 1125-1134"); 
cardiacArrhythmiaDis.setCode358(228);
cardiacArrhythmiaDis.setICD10code("I44");


    // -------------- cardiogenicShock ---------------
// (C) OntoOO Inc Thu Nov 01 16:50:59 PST 2001
Disease cardiogenicShockDis = new Disease(
   LR.cardiogenicShock, 
   "diminished cardiac output", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
cardiogenicShockDis.setPrintName("cardiogenic shock");
cardiogenicShockDis.addSymptom(LR.confusion, "", 1.0f);
cardiogenicShockDis.addSymptom(LR.cyanosis, "", 1.0f);
cardiogenicShockDis.addSymptom(LR.hypotension, "", 1.0f);
cardiogenicShockDis.addSymptom(LR.oliguria, "", 1.0f);
cardiogenicShockDis.addSymptom(LR.pallor, "", 1.0f);
cardiogenicShockDis.addSymptom(LR.tachypnea);
cardiogenicShockDis.addSymptom(LR.respirationShallow, "", 1.0f);
cardiogenicShockDis.addSymptom(LR.restlessness, "", 1.0f);
cardiogenicShockDis.addSymptom(LR.skinClammy, "", 1.0f);
cardiogenicShockDis.addSymptom(LR.skinCold, "", 1.0f);
cardiogenicShockDis.addSymptom(LR.tachycardia, "", 1.0f);
cardiogenicShockDis.addSymptom(LR.obtundation, "", 1.0f);
cardiogenicShockDis.addSymptom(LR.pulsePressureNarrows, "", 1.0f);
cardiogenicShockDis.addReference("pp 1118-21");
cardiogenicShockDis.setMiscComments("24 hour survival is less than 50%");
Treatment cardiogenicShockTr1 = new Treatment("cardiogenicShockTr1");
cardiogenicShockTr1.addTreatmentAction(LR.increaseCardiacOutput);
cardiogenicShockTr1.addTreatmentAction(LR.decreaseCardiacWorkload);
cardiogenicShockDis.addTreatment(cardiogenicShockTr1.getName()); 


// -------------- cardiomyopathy --------------
// (C) OntoOO Inc Thu Oct 03 11:46:23 PDT 2002
Disease cardiomyopathyDis = new Disease(
   LR.cardiomyopathy, 
   "extensive damage of heart muscle fibers", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
cardiomyopathyDis.addSymptom(LR.arrhythmia);
cardiomyopathyDis.addSymptom(LR.breathlessness, "", 1.0f);
cardiomyopathyDis.addSymptom(LR.coughDry, "", 1.0f);
cardiomyopathyDis.addSymptom(LR.cyanosis, "", 0.3f);
cardiomyopathyDis.addSymptom(LR.dyspnea, "", 1.0f);
cardiomyopathyDis.addSymptom(LR.edema, "", 1.0f);
cardiomyopathyDis.addSymptom(LR.fatigue, "", 1.0f);
cardiomyopathyDis.addSymptom(LR.liverEnlarged, "", 1.0f);
cardiomyopathyDis.addSymptom(LR.neckVeinsElevated, "", 1.0f);
cardiomyopathyDis.addSymptom(LR.orthopnea, "", 1.0f);
cardiomyopathyDis.addInternalCause(LR.sarcoidosisCardio);
cardiomyopathyDis.addReference("pp 1111-2");
Treatment cardiomyopathyTr1  = new Treatment("cardiomyopathyTr1");
cardiomyopathyTr1.addTreatmentAction(LR.bedRest);
cardiomyopathyTr1.addTreatmentAction(LR.oxygenTherapy);
cardiomyopathyTr1.addTreatmentAction(LR.vasopressor);
cardiomyopathyTr1.addTreatmentAction(LR.sodiumRestriction);
cardiomyopathyTr1.addDrug(LR.digoxin);
cardiomyopathyTr1.addDrug(LR.diuretics);
cardiomyopathyTr1.addDrug(LR.steroids);
cardiomyopathyDis.addTreatment(cardiomyopathyTr1.getName());
cardiomyopathyDis.setCode358(227);
cardiomyopathyDis.setICD10code("I42");


// -------------- coronaryArteryDisease --------------
// (C) OntoOO Inc Wed Dec 28 20:18:51 PST 2011
Disease coronaryArteryDiseaseDis = new Disease(
   LR.coronaryArteryDisease, 
   "loss of oxygen and nutrients to myocardial tissue", 
   LR.cardioDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
coronaryArteryDiseaseDis.setPrintName("coronary artery disease");
coronaryArteryDiseaseDis.addSymptom(LR.anginaPain);
coronaryArteryDiseaseDis.addSymptom(LR.chestTightness);
coronaryArteryDiseaseDis.addSymptom(LR.coolExtremities);
coronaryArteryDiseaseDis.addSymptom(LR.fainting);
coronaryArteryDiseaseDis.addSymptom(LR.nausea);
coronaryArteryDiseaseDis.addSymptom(LR.sweating);
coronaryArteryDiseaseDis.addSymptom(LR.vomiting);
coronaryArteryDiseaseDis.addCausingAbnormalCondition(LR.atherosclerosis);
coronaryArteryDiseaseDis.addReference("pp 1098-1101");
Treatment coronaryArteryDiseaseTr1  = new Treatment("coronaryArteryDiseaseTr1");
coronaryArteryDiseaseTr1.addTreatmentAction(LR.surgery);
coronaryArteryDiseaseTr1.addDrug(LR.nitroglycerin);
coronaryArteryDiseaseDis.addTreatment(coronaryArteryDiseaseTr1.getName());
coronaryArteryDiseaseDis.setCode358(214);
coronaryArteryDiseaseDis.setICD10code("I25");


    // -------------- corPulmonale ---------------
    Disease corPulmonaleDis = new Disease(
       LR.corPulmonale,
       "cor pulmonale is hyperthrophy of the right heart ventricle",
       LR.cardioDisorders,
       LR.moreMale, // genderSpecificity
       LR.none, // raceSpecificity
       40, // minAge 
       LR.maxAge, // maxAge
       -3, // duration, less than a week
       -1, // diagnosis frequency, unknown
       LR.heartSysSt,
       LR.none
       );
    // set printName              Dis.setPrintName("");
    corPulmonaleDis.setPrintName("cor pulmonale");

    // set super disease          Dis.setSuperDisease(LR.aRFinCOPD);
    // set underlying disease     Dis.setUnderlyingDisease(LR.COPD);

    // caused by:                 Dis.addExternalCause(...)
    corPulmonaleDis.addExternalCause(LR.lungTissueLossDueToSurgery);

    // symptoms:                  Dis.addSymptom(LR.airHunger);
    corPulmonaleDis.addSymptom(LR.coughProductive);
    corPulmonaleDis.addSymptom(LR.dyspnea);
    corPulmonaleDis.addSymptom(LR.wheezing);
    corPulmonaleDis.addSymptom(LR.fatigue);
    corPulmonaleDis.addSymptom(LR.weakness);
    corPulmonaleDis.addSymptom(LR.tachypnea);
    corPulmonaleDis.addSymptom(LR.orthopnea);
    corPulmonaleDis.addSymptom(LR.edema);
    corPulmonaleDis.addSymptom(LR.neckVeinsElevated);
    corPulmonaleDis.addSymptom(LR.liverEnlarged);
    corPulmonaleDis.addSymptom(LR.tachycardia);

    // treatments:
    Treatment corPulmonaleTr1 = new Treatment("corPulmonaleTr1");
    corPulmonaleTr1.addTreatmentAction(LR.bedRest);
    corPulmonaleDis.addTreatment(corPulmonaleTr1.getName());
    Treatment corPulmonaleTr2 = new Treatment("corPulmonaleTr2");
    corPulmonaleTr2.addTreatmentAction(LR.ifInfectionProvideAntibiotic);
    corPulmonaleTr2.addDrug(LR.digoxin);
    corPulmonaleTr2.addDrug(LR.pulmonaryArteryVasodilators);
    corPulmonaleTr2.addDrug(LR.diazoxide);
    corPulmonaleTr2.addDrug(LR.nitroprusside);
    corPulmonaleTr2.addDrug(LR.hydralazine);
    corPulmonaleTr2.addDrug(LR.prostaglandins);
    corPulmonaleDis.addTreatment(corPulmonaleTr2.getName());
    Treatment corPulmonaleTr3 = new Treatment("corPulmonaleTr3");
    corPulmonaleTr3.addTreatmentAction(LR.oxygenTherapy);
    corPulmonaleTr3.addTreatmentAction(LR.mechanicalVentilation);
    corPulmonaleDis.addTreatment(corPulmonaleTr3.getName());
    Treatment corPulmonaleTr4 = new Treatment("corPulmonaleTr4");
    corPulmonaleTr4.addTreatmentAction(LR.dietLowSalt);
    corPulmonaleTr4.addDrug(LR.diuretics);
    corPulmonaleTr4.addDrug(LR.furosemide);
    corPulmonaleDis.addTreatment(corPulmonaleTr4.getName());
    Treatment corPulmonaleTr5 = new Treatment("corPulmonaleTr5");
    corPulmonaleTr5.addTreatmentAction(LR.phlebotomy);
    corPulmonaleDis.addTreatment(corPulmonaleTr5.getName());
    Treatment corPulmonaleTr6 = new Treatment("corPulmonaleTr6");
    corPulmonaleTr6.addDrug(LR.anticoagulants);
    corPulmonaleTr6.addDrug(LR.heparin);
    corPulmonaleDis.addTreatment(corPulmonaleTr6.getName());


    // causing:                   Dis.addInternalCause(LR.pneumonia);

    corPulmonaleDis.addInternalCause(LR.amyotropicLateralSclerosis);
    corPulmonaleDis.addInternalCause(LR.asbestosis); 
    corPulmonaleDis.addInternalCause(LR.berylliosisChronic);
    corPulmonaleDis.addInternalCause(LR.bronchiectasis);
    // corPulmonaleDis.addInternalCause(LR.chronicMountainSickness);
    corPulmonaleDis.addInternalCause(LR.chronicObstructivePulmonaryDisease);
    corPulmonaleDis.addInternalCause(LR.coalWorkerPneumoconiosis);
    corPulmonaleDis.addInternalCause(LR.cysticFibrosis);
    // corPulmonaleDis.addInternalCause(LR.interstitialPneumonitis);
    corPulmonaleDis.addInternalCause(LR.kyphoscoliosis);
    corPulmonaleDis.addInternalCause(LR.muscularDystrophy);
    corPulmonaleDis.addInternalCause(LR.pulmonaryHypertension);
    corPulmonaleDis.addInternalCause(LR.sarcoidosis);
    corPulmonaleDis.addInternalCause(LR.sarcoidosisRespiratory);
    corPulmonaleDis.addInternalCause(LR.schistosomiasis);
    corPulmonaleDis.addInternalCause(LR.scleroderma);
    corPulmonaleDis.addInternalCause(LR.sickleCellAnemia);
    corPulmonaleDis.addInternalCause(LR.silicosis);
    // corPulmonaleDis.addInternalCause(LR.thromboembolism);
    corPulmonaleDis.addInternalCause(LR.vasculitisPulmonary);


// can cause:                 Dis.addCausesDisease(LR.lungAbscess);
// references:                Dis.addReference("pp 501-4");
    corPulmonaleDis.addReference("pp 506-8");

    // comments:                  Dis.setMiscComments("");
    corPulmonaleDis.setMiscComments(
	 "25% of patients with COPD develop cor pulmonale; " +
	 "85% of patients with cor pulmonale have COPD; " +
	 "cor pulmonale can also result from a left sided heart disease, or " +
	 "is congenital; " +
	 "cor pulmonale accounts for 25% of all types of heart failure");

    // causing abnormal conditions Dis.addCausingAbnormalCondition(LR.heartFailure);
    corPulmonaleDis.addCausingAbnormalCondition(LR.upperAirwayObstruction);
    corPulmonaleDis.addCausingAbnormalCondition(LR.spinalCordLesionAboveC6);
    corPulmonaleDis.addCausingAbnormalCondition(LR.obesityHypoVentilation);

// causes abnormal conditions / complications
//                            Dis.addCausesAbnormalCondition(LR.hypoxemia);


// -------------- dissecting abdomen aorta aneurysm ---------------
// (C) OntoOO Inc Sat Nov 03 14:04:53 PST 2001
Disease dissectingAbdomenAortaAneurysmDis = new Disease(
   LR.dissectingAbdomenAortaAneurysm, 
   "wall of aorta vein in the abdomen fails", 
   LR.vascularDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.caucasian, // raceSpecificity 
   50, //  minAge 
   80, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vascularSysSt, 
   LR.none
);
dissectingAbdomenAortaAneurysmDis.setPrintName("dissecting abdomen aorta aneurysm");
dissectingAbdomenAortaAneurysmDis.addSymptom(LR.hypotension, "", 1.0f);
dissectingAbdomenAortaAneurysmDis.addSymptom(LR.sweating, "", 1.0f);
dissectingAbdomenAortaAneurysmDis.addSymptom(LR.tachycardia, "", 1.0f);
dissectingAbdomenAortaAneurysmDis.addSymptom(LR.weakness, "", 1.0f);
dissectingAbdomenAortaAneurysmDis.addSymptom(LR.flankPain, "", 1.0f);
dissectingAbdomenAortaAneurysmDis.addSymptom(LR.groinPain, "", 1.0f);

dissectingAbdomenAortaAneurysmDis.addReference("pp 1137-40");

Treatment dissectingAbdomenAortaAneurysmTr1  = 
  new Treatment("dissectingAbdomenAortaAneurysmTr1");
dissectingAbdomenAortaAneurysmTr1.addTreatmentAction(LR.fluidManagement);
dissectingAbdomenAortaAneurysmTr1.addTreatmentAction(LR.surgery);
dissectingAbdomenAortaAneurysmTr1.addTreatmentAction(LR.pneumaticAntishockGarment);
dissectingAbdomenAortaAneurysmDis.addTreatment(
  dissectingAbdomenAortaAneurysmTr1.getName());


    // -------------- endocarditis ---------------
// (C) OntoOO Inc Thu Nov 15 15:07:15 PST 2001
Disease endocarditisDis = new Disease(
   LR.endocarditis, 
   "infection in the heart due to bacterial or fungal invasion", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.infection
);

endocarditisDis.addSymptom(LR.anorexia, "", 1.0f);
endocarditisDis.addSymptom(LR.arthralgia, "", 1.0f);
endocarditisDis.addSymptom(LR.chills, "", 1.0f);
endocarditisDis.addSymptom(LR.fatigue, "", 1.0f);
endocarditisDis.addSymptom(LR.feverIntermittent);
endocarditisDis.addSymptom(LR.malaise, "", 1.0f);
endocarditisDis.addSymptom(LR.murmurLoud);
endocarditisDis.addSymptom(LR.nightSweating, "", 1.0f);
endocarditisDis.addSymptom(LR.weakness, "", 1.0f);
endocarditisDis.addSymptom(LR.weightLoss, "", 1.0f);
endocarditisDis.addInternalCause(LR.pneumonia);
endocarditisDis.addInternalCause(LR.rheumaticFever);

endocarditisDis.addCausesAbnormalCondition(LR.valvularInsufficiency);

endocarditisDis.addReference("pp 1082-4");

Treatment endocarditisTr1  = new Treatment("endocarditisTr1");
endocarditisTr1.addTreatmentAction(LR.fluidManagement);
endocarditisTr1.addTreatmentAction(LR.ifFeverProvideAntipyretic);
endocarditisTr1.addTreatmentAction(LR.nutritionImprove);
endocarditisTr1.addDrug(LR.antimicrobials);
endocarditisDis.addTreatment(endocarditisTr1.getName());
endocarditisDis.setCode358(221);
endocarditisDis.setICD10code("I33");


// -------------- heartFailure --------------
// (C) OntoOO Inc Sat Nov 17 11:23:53 PST 2001
Disease heartFailureDis = new Disease(
   LR.heartFailure, 
   "impaired pumping", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
heartFailureDis.setPrintName("heart failure");
heartFailureDis.addInternalCause(LR.legionaire);
heartFailureDis.addInternalCause(LR.renalFailureAcute);
heartFailureDis.addInternalCause(LR.schistosomiasis);
heartFailureDis.addInternalCause(LR.tubularNecrosisAcute);
heartFailureDis.addInternalCause(LR.muscularDystrophyBecker);
heartFailureDis.addInternalCause(LR.muscularDystrophyDuchenne);
heartFailureDis.addInternalCause(LR.valveDisorders);
heartFailureDis.addReference("pp 1106-11");

Treatment heartFailureTr1  = new Treatment("heartFailureTr1");
heartFailureTr1.addTreatmentAction(LR.bedRest);
heartFailureTr1.addTreatmentAction(LR.antiembolismStockings);
heartFailureTr1.addDrug(LR.digoxin);
heartFailureTr1.addDrug(LR.diuretics);
heartFailureTr1.addDrug(LR.vasodilators);
heartFailureDis.addTreatment(heartFailureTr1.getName());
heartFailureDis.setCode358(230);
heartFailureDis.setICD10code("I50");


// -------------- heartFailureLeftSided --------------
// (C) OntoOO Inc Sat Nov 17 12:56:04 PST 2001
Disease heartFailureLeftSidedDis = new Disease(
   LR.heartFailureLeftSided, 
   "heart failure left sided", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
heartFailureLeftSidedDis.setPrintName();
heartFailureLeftSidedDis.setSuperDisease(LR.heartFailure);
heartFailureLeftSidedDis.addSymptom(LR.arrhythmia, "", 1.0f);
heartFailureLeftSidedDis.addSymptom(LR.cough, "", 1.0f);
heartFailureLeftSidedDis.addSymptom(LR.crackles, "", 1.0f);
heartFailureLeftSidedDis.addSymptom(LR.cyanosis, "", 1.0f);
heartFailureLeftSidedDis.addSymptom(LR.dyspnea, "", 1.0f);
heartFailureLeftSidedDis.addSymptom(LR.orthopnea, "", 1.0f);
heartFailureLeftSidedDis.addSymptom(LR.palpitations);
heartFailureLeftSidedDis.addSymptom(LR.pulsusAlternans);
heartFailureLeftSidedDis.addSymptom(LR.wheezing, "", 1.0f);

heartFailureLeftSidedDis.addInternalCause(LR.hypertension);
heartFailureLeftSidedDis.addInternalCause(LR.aortaInsufficiency); 

heartFailureLeftSidedDis.addCausesAbnormalCondition(LR.acidosis);
heartFailureLeftSidedDis.addCausesAbnormalCondition(LR.hypoxia);

heartFailureLeftSidedDis.addReference("pp 1106-11");
heartFailureLeftSidedDis.setCode358(230);
heartFailureLeftSidedDis.setICD10code("I50");


// -------------- heartFailureRightSided --------------
// (C) OntoOO Inc Sat Nov 17 12:39:18 PST 2001
Disease heartFailureRightSidedDis = new Disease(
   LR.heartFailureRightSided, 
   "heart failure right sided", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
heartFailureRightSidedDis.setPrintName();
heartFailureRightSidedDis.setSuperDisease(LR.heartFailure);
heartFailureRightSidedDis.addSymptom(LR.anorexia);
heartFailureRightSidedDis.addSymptom(LR.arrhythmia);
heartFailureRightSidedDis.addSymptom(LR.dizziness);
heartFailureRightSidedDis.addSymptom(LR.neckVeinsElevated);
heartFailureRightSidedDis.addSymptom(LR.fatigue);
heartFailureRightSidedDis.addSymptom(LR.nausea);
heartFailureRightSidedDis.addSymptom(LR.edemaPeripheral);
heartFailureRightSidedDis.addSymptom(LR.syncope);
heartFailureRightSidedDis.addSymptom(LR.vomiting);
heartFailureRightSidedDis.addSymptom(LR.weakness);
heartFailureRightSidedDis.addSymptom(LR.weightGain);

heartFailureRightSidedDis.addInternalCause(LR.bronchiectasis);
heartFailureRightSidedDis.addInternalCause(LR.pulmonaryHypertension);
heartFailureRightSidedDis.addInternalCause(LR.hypertension);
heartFailureRightSidedDis.addCausingAbnormalCondition(LR.ascites);
heartFailureRightSidedDis.addCausingAbnormalCondition(LR.hepatomegaly);
heartFailureRightSidedDis.addCausingAbnormalCondition(LR.splenomegaly);

heartFailureRightSidedDis.addCausesAbnormalCondition(LR.hepatoJugularReflux);

heartFailureRightSidedDis.addReference("pp 1106-11");
heartFailureRightSidedDis.setCode358(230);
heartFailureRightSidedDis.setICD10code("I50");


// -------------- hypertension --------------
// (C) OntoOO Inc Sun Dec 15 15:33:01 PST 2002
Disease hypertensionDis = new Disease(
   LR.hypertension, 
   "high blood pressure defined as above 140-90", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vascularSysSt, 
   LR.sedentaryLifestyle
);
hypertensionDis.setGenetic("1parent");
hypertensionDis.setParentDisease(LR.hypertension);
hypertensionDis.addSymptom(LR.dizziness, "", 0.1f);
hypertensionDis.addSymptom(LR.edema, "", 0.1f);
hypertensionDis.addSymptom(LR.headache, "", 0.1f); 
hypertensionDis.addExternalCause(LR.oralContraceptiveUse);
hypertensionDis.addExternalCause(LR.sodiumExcess);
hypertensionDis.addExternalCause(LR.stress);
hypertensionDis.addExternalCause(LR.tobaccoUse);
 
hypertensionDis.addInternalCause(LR.blackWidowSpiderBite);
hypertensionDis.addInternalCause(LR.cushingSyndrome);
hypertensionDis.addInternalCause(LR.gout);
hypertensionDis.addInternalCause(LR.hyperaldosteronism);
hypertensionDis.addInternalCause(LR.kidneyCancer);
hypertensionDis.addInternalCause(LR.obesity);
hypertensionDis.addInternalCause(LR.pheochromocytoma);
hypertensionDis.addInternalCause(LR.polyarteritisNodosa);
hypertensionDis.addInternalCause(LR.pregnancyInducedHypertension);
hypertensionDis.addInternalCause(LR.pyelonephritisChronic);
hypertensionDis.addInternalCause(LR.renalInfarction);
hypertensionDis.addInternalCause(LR.skullFracture);
// hypertensionDis.addCausingAbnormalCondition(LR.obesity);
hypertensionDis.addCausingAbnormalCondition(LR.pregnancy);
hypertensionDis.addCausesDisease(LR.cardiacArrest);
hypertensionDis.addCausesDisease(LR.cerebrovascularAccident);
hypertensionDis.addCausesDisease(LR.heartFailureLeftSided);
hypertensionDis.addCausesDisease(LR.heartFailureRightSided);
hypertensionDis.addCausesDisease(LR.hypertensiveCrisis); 
hypertensionDis.addCausesDisease(LR.myocardialInfarction); 
hypertensionDis.addCausesDisease(LR.pulmonaryEdema);
hypertensionDis.addCausesDisease(LR.renalFailureAcute);
hypertensionDis.addCausingAbnormalCondition(LR.atherosclerosis);
hypertensionDis.addCausesAbnormalCondition(LR.blindness);
hypertensionDis.addCausesAbnormalCondition(LR.proteinuria); 
hypertensionDis.addReference("pp 1093-7");
hypertensionDis.setMiscComments("often no symptoms"); 
Treatment hypertensionTr1 = new Treatment("hypertensionTr1");
hypertensionTr1.addTreatmentAction(LR.dietLowSalt);
hypertensionTr1.addTreatmentAction(LR.exercise);
hypertensionTr1.addTreatmentAction(LR.sodiumRestriction);
hypertensionTr1.addTreatmentAction(LR.weightReduction);
hypertensionTr1.addTreatmentAction(LR.alcoholModeration);
hypertensionTr1.addTreatmentAction(LR.smokingCessation);
hypertensionDis.addTreatment(hypertensionTr1.getName()); 
Treatment hypertensionTr2 = new Treatment("hypertensionTr2");
hypertensionTr2.addDrug(LR.diuretics);
hypertensionTr2.addDrug(LR.betaBlocker);
hypertensionDis.addTreatment(hypertensionTr2.getName()); 
hypertensionDis.setCode358(206);
hypertensionDis.setICD10code("I10");


// -------------- hypertensiveCrisis --------------
// (C) OntoOO Inc Sat Nov 17 21:20:56 PST 2001
Disease hypertensiveCrisisDis = new Disease(
   LR.hypertensiveCrisis, 
   "severe rise in blood pressure due to failing control mechanisms", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.cardioVascularSysSt, 
   LR.none
);
hypertensiveCrisisDis.setPrintName("hypertensive crisis");

hypertensiveCrisisDis.addSymptom(LR.coma, "", 1.0f);
hypertensiveCrisisDis.addSymptom(LR.headacheSevere, "", 1.0f);
hypertensiveCrisisDis.addSymptom(LR.ocularDisturbance);
hypertensiveCrisisDis.addSymptom(LR.papilledema, "", 1.0f);
hypertensiveCrisisDis.addSymptom(LR.paralysisTransient);
hypertensiveCrisisDis.addSymptom(LR.retinaHemorrhage);
hypertensiveCrisisDis.addSymptom(LR.seizure, "", 1.0f);
hypertensiveCrisisDis.addSymptom(LR.stupor, "", 1.0f);
hypertensiveCrisisDis.addSymptom(LR.vomiting, "", 1.0f);
hypertensiveCrisisDis.addInternalCause(LR.hypertension);

hypertensiveCrisisDis.addReference("pp 1095");

Treatment hypertensiveCrisisTr1 = new Treatment("hypertensiveCrisisTr1");
hypertensiveCrisisTr1.addDrug(LR.diazoxide);
hypertensiveCrisisTr1.addDrug(LR.hydralazine);
hypertensiveCrisisTr1.addDrug(LR.nitroprusside);
hypertensiveCrisisTr1.addDrug(LR.trimethaphan);
hypertensiveCrisisTr1.addDrug(LR.nitroglycerin);
hypertensiveCrisisTr1.addDrug(LR.methyldopa);
hypertensiveCrisisDis.addTreatment(hypertensiveCrisisTr1.getName()); 
hypertensiveCrisisDis.setCode358(207);
hypertensiveCrisisDis.setICD10code("I11");


// -------------- valveDisorders --------------
// (C) OntoOO Inc Thu Dec 12 16:03:28 PST 2002
Disease valveDisordersDis = new Disease(
   LR.valveDisorders, 
   "collection of three types of heart valve disorders", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
valveDisordersDis.setPrintName("valve disorders");
valveDisordersDis.addInternalCause(LR.endocarditis);
valveDisordersDis.addCausingSet(LR.infections);
valveDisordersDis.addCausesDisease(LR.heartFailure);
valveDisordersDis.addReference("pp 1089-93");
Treatment valveDisordersTr1 = new Treatment("valveDisordersTr1", LR.ifHeartFailure);
valveDisordersTr1.addTreatmentAction(LR.dietLowSalt);
valveDisordersTr1.addTreatmentAction(LR.oxygenTherapy);
valveDisordersTr1.addDrug(LR.digoxin);
valveDisordersTr1.addDrug(LR.diuretics);
valveDisordersDis.addTreatment("valveDisordersTr1");
Treatment valveDisordersTr2 = new Treatment("valveDisordersTr2");
valveDisordersTr2.addDrug(LR.anticoagulants);
valveDisordersDis.addTreatment("valveDisordersTr2");
Treatment valveDisordersTr3  = new Treatment("valveDisordersTr3", LR.ifSevere);
valveDisordersTr3.addTreatmentAction(LR.valveReplacement);
valveDisordersDis.addTreatment(valveDisordersTr3.getName());
valveDisordersDis.setCode358(225);
valveDisordersDis.setICD10code("I35");


// -------------- aortaInsufficiency --------------
// (C) OntoOO Inc Tue Jan 14 16:17:19 PST 2003
Disease aortaInsufficiencyDis = new Disease(
   LR.aortaInsufficiency, 
   "blood flows back into left ventricle", 
   LR.cardioDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
aortaInsufficiencyDis.setPrintName("aorta insufficiency");
aortaInsufficiencyDis.setSuperDisease(LR.valveDisorders);
aortaInsufficiencyDis.addSymptom(LR.dyspnea, "", 1.0f);
aortaInsufficiencyDis.addSymptom(LR.fatigue, "", 1.0f);
aortaInsufficiencyDis.addSymptom(LR.palpitations, "", 1.0f);
aortaInsufficiencyDis.addSymptom(LR.anginaPain, "", 1.0f);
aortaInsufficiencyDis.addSymptom(LR.cough, "", 1.0f);
aortaInsufficiencyDis.addSymptom(LR.syncope, "", 1.0f);
aortaInsufficiencyDis.addSymptom(LR.arrhythmia);
aortaInsufficiencyDis.addInternalCause(LR.ankylosingSpondylitis); 
aortaInsufficiencyDis.addInternalCause(LR.endocarditis);
aortaInsufficiencyDis.addInternalCause(LR.rheumaticFever);
aortaInsufficiencyDis.addInternalCause(LR.syphilis);
aortaInsufficiencyDis.addInternalCause(LR.syphilisLateCardioVascular);
aortaInsufficiencyDis.addInternalCause(LR.thoracicAortaAneurysm);
aortaInsufficiencyDis.addCausesDisease(LR.heartFailureLeftSided);
aortaInsufficiencyDis.addCausesDisease(LR.pulmonaryEdema);
aortaInsufficiencyDis.addReference("pp 1089-93");


// -------------- mitralInsufficiency --------------
// (C) OntoOO Inc Thu Dec 12 17:49:53 PST 2002
Disease mitralInsufficiencyDis = new Disease(
   LR.mitralInsufficiency, 
   "blood flows back from the left ventricle into the left atrium", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
mitralInsufficiencyDis.setPrintName("mitral insufficiency");
mitralInsufficiencyDis.setSuperDisease(LR.valveDisorders);
mitralInsufficiencyDis.addSymptom(LR.crackles, "", 1.0f);
mitralInsufficiencyDis.addSymptom(LR.dyspnea, "", 1.0f);
mitralInsufficiencyDis.addSymptom(LR.edemaPeripheral, "", 1.0f);
mitralInsufficiencyDis.addSymptom(LR.fatigue, "", 1.0f);
mitralInsufficiencyDis.addSymptom(LR.neckVeinsElevated, "", 1.0f);
mitralInsufficiencyDis.addSymptom(LR.orthopnea, "", 1.0f);
mitralInsufficiencyDis.addSymptom(LR.palpitations, "", 1.0f);
mitralInsufficiencyDis.addSymptom(LR.anginaPain);
mitralInsufficiencyDis.addSymptom(LR.tachycardia);
mitralInsufficiencyDis.addInternalCause(LR.heartFailureLeftSided);
mitralInsufficiencyDis.addInternalCause(LR.myocardialInfarction);
mitralInsufficiencyDis.addInternalCause(LR.rheumaticFever);
mitralInsufficiencyDis.addCausingAbnormalCondition(LR.hepatomegaly);
mitralInsufficiencyDis.addReference("pp 1089-93");
mitralInsufficiencyDis.setCode358(224);
mitralInsufficiencyDis.setICD10code("I34");

// -------------- mitralStenosis --------------
// (C) OntoOO Inc Tue Oct 29 14:57:51 PST 2002
Disease mitralStenosisDis = new Disease(
   LR.mitralStenosis, 
   "narrowing of heart valve", 
   LR.cardioDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
mitralStenosisDis.setPrintName("mitral stenosis");
mitralStenosisDis.setSuperDisease(LR.valveDisorders); 
mitralStenosisDis.addSymptom(LR.arrhythmia);
mitralStenosisDis.addSymptom(LR.crackles);
mitralStenosisDis.addSymptom(LR.dyspnea);
mitralStenosisDis.addSymptom(LR.edemaPeripheral);
mitralStenosisDis.addSymptom(LR.fatigue);
mitralStenosisDis.addSymptom(LR.neckVeinsElevated);
mitralStenosisDis.addSymptom(LR.orthopnea);
mitralStenosisDis.addSymptom(LR.palpitations);
mitralStenosisDis.addSymptom(LR.weakness);
mitralStenosisDis.addCausesAbnormalCondition(LR.ascites);
mitralStenosisDis.addCausesAbnormalCondition(LR.hepatomegaly);
mitralStenosisDis.addReference("pp 1089-93");
mitralStenosisDis.setCode358(224);
mitralStenosisDis.setICD10code("I34");


// -------------- mitralValveProlapse --------------
// (C) OntoOO Inc Thu Dec 12 20:21:45 PST 2002
Disease mitralValveProlapseDis = new Disease(
   LR.mitralValveProlapse, 
   "valve(s) protrude into the left atrium", 
   LR.cardioDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
mitralValveProlapseDis.setPrintName("mitral valve prolapse");
mitralValveProlapseDis.setSuperDisease(LR.valveDisorders);
mitralValveProlapseDis.addSymptom(LR.dyspnea, "", 1.0f);
mitralValveProlapseDis.addSymptom(LR.fatigue, "", 1.0f);
mitralValveProlapseDis.addSymptom(LR.palpitations, "", 1.0f);
mitralValveProlapseDis.addSymptom(LR.weakness, "", 1.0f);
mitralValveProlapseDis.addSymptom(LR.anxiety, "", 1.0f);
mitralValveProlapseDis.addSymptom(LR.chestPain, "", 1.0f);
mitralValveProlapseDis.addSymptom(LR.headache, "", 1.0f);
mitralValveProlapseDis.addSymptom(LR.lightHeadedness, "", 1.0f);
mitralValveProlapseDis.addSymptom(LR.syncope, "", 1.0f);
mitralValveProlapseDis.addSymptom(LR.moodSwings);
mitralValveProlapseDis.addSymptom(LR.panicAttacks);
mitralValveProlapseDis.addReference("pp 1089-93");
mitralValveProlapseDis.setCode358(203);
mitralValveProlapseDis.setICD10code("I08");


// -------------- tricuspidInsufficiency --------------
// (C) OntoOO Inc Tue Jan 14 17:39:01 PST 2003
Disease tricuspidInsufficiencyDis = new Disease(
   LR.tricuspidInsufficiency, 
   "blood flows back in the right atrium during the heart contraction", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
tricuspidInsufficiencyDis.setPrintName("tricuspid insufficiency");
tricuspidInsufficiencyDis.setSuperDisease(LR.valveDisorders);
tricuspidInsufficiencyDis.addSymptom(LR.abdomenBloating);
tricuspidInsufficiencyDis.addSymptom(LR.dyspnea, "", 1.0f);
tricuspidInsufficiencyDis.addSymptom(LR.edemaPeripheral, "", 1.0f);
tricuspidInsufficiencyDis.addSymptom(LR.fatigue, "", 1.0f);
tricuspidInsufficiencyDis.addSymptom(LR.neckVeinsElevated, "", 1.0f);
tricuspidInsufficiencyDis.addSymptom(LR.urineRetention);
tricuspidInsufficiencyDis.addSymptom(LR.weakness);
tricuspidInsufficiencyDis.addInternalCause(LR.endocarditis);
tricuspidInsufficiencyDis.addInternalCause(LR.heartFailureRightSided);
tricuspidInsufficiencyDis.addInternalCause(LR.rheumaticFever); 
tricuspidInsufficiencyDis.addCausesAbnormalCondition(LR.ascites);
tricuspidInsufficiencyDis.addCausesAbnormalCondition(LR.hepatomegaly);
tricuspidInsufficiencyDis.addReference("pp 1089-93");


// -------------- tricuspidStenosis --------------
// (C) OntoOO Inc Thu Jan 16 16:10:11 PST 2003
Disease tricuspidStenosisDis = new Disease(
   LR.tricuspidStenosis, 
   "blood flow from the right atrium to the right ventricle is obstructed", 
   LR.cardioDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
tricuspidStenosisDis.setPrintName("tricuspid stenosis");
tricuspidStenosisDis.setSuperDisease(LR.valveDisorders);
tricuspidStenosisDis.addSymptom(LR.abdomenPainUpperRightSide);
tricuspidStenosisDis.addSymptom(LR.dyspnea, "", 1.0f);
tricuspidStenosisDis.addSymptom(LR.fatigue, "", 1.0f);
tricuspidStenosisDis.addSymptom(LR.edemaPeripheral, "", 1.0f);
tricuspidStenosisDis.addSymptom(LR.neckVeinsElevated, "", 1.0f);
tricuspidStenosisDis.addSymptom(LR.skinCold);
tricuspidStenosisDis.addSymptom(LR.syncope);
tricuspidStenosisDis.addInternalCause(LR.rheumaticFever);
tricuspidStenosisDis.addCausesAbnormalCondition(LR.ascites);
tricuspidStenosisDis.addCausesAbnormalCondition(LR.hepatomegaly);
tricuspidStenosisDis.addReference("pp 1089-93");


    // -------------- myocardialInfarction ---------------
// (C) OntoOO Inc Wed Nov 07 20:46:52 PST 2001
Disease myocardialInfarctionDis = new Disease(
   LR.myocardialInfarction, 
   "impaired blood flow through the heart arteries", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
myocardialInfarctionDis.setPrintName("myocardial infarction");
myocardialInfarctionDis.addSymptom(LR.armPitPain);
myocardialInfarctionDis.addSymptom(LR.chestPain);
myocardialInfarctionDis.addSymptom(LR.doomFeeling);
myocardialInfarctionDis.addSymptom(LR.fainting);
myocardialInfarctionDis.addSymptom(LR.jawPain);
myocardialInfarctionDis.addSymptom(LR.lightHeadedness);
myocardialInfarctionDis.addSymptom(LR.nausea);
myocardialInfarctionDis.addSymptom(LR.neckPain);
myocardialInfarctionDis.addSymptom(LR.dyspnea);
myocardialInfarctionDis.addSymptom(LR.shoulderPain);
myocardialInfarctionDis.addSymptom(LR.sweating);
myocardialInfarctionDis.addInternalCause(LR.electricShock);
myocardialInfarctionDis.addInternalCause(LR.hypertension);
myocardialInfarctionDis.addReference("pp 1101-6");
Treatment myocardialInfarctionTr1 = new Treatment("myocardialInfarctionTr1");
myocardialInfarctionTr1.addTreatmentAction(LR.oxygenTherapy);
myocardialInfarctionTr1.addTreatmentAction(LR.thrombolyticTherapy);
myocardialInfarctionTr1.addTreatmentAction(LR.angioplasty);
myocardialInfarctionTr1.addDrug(LR.nitroglycerin);
myocardialInfarctionDis.addTreatment(myocardialInfarctionTr1.getName()); 
myocardialInfarctionDis.setCode358(211);
myocardialInfarctionDis.setICD10code("I21");


// -------------- myocarditis --------------
// (C) OntoOO Inc Fri Dec 06 11:21:21 PST 2002
Disease myocarditisDis = new Disease(
   LR.myocarditis, 
   "inflammation of the heart muscle", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.alcoholAbuse
);
myocarditisDis.setTemperature((float)100.5);
myocarditisDis.addSymptom(LR.arrhythmia, "if cardio megaly", 0.2f);
myocarditisDis.addSymptom(LR.chestPain, "if cardio megaly", 0.2f);
myocarditisDis.addSymptom(LR.dyspnea, "", 1.0f);
myocarditisDis.addSymptom(LR.fatigue, "", 1.0f);
myocarditisDis.addSymptom(LR.neckVeinsElevated, "if cardio megaly", 0.2f);
myocarditisDis.addSymptom(LR.palpitations, "", 1.0f);
myocarditisDis.addSymptom(LR.tachycardia, "if cardio megaly", 0.2f);
myocarditisDis.addExternalCause(LR.infection);
myocarditisDis.addExternalCause(LR.radiation);
myocarditisDis.addInternalCause(LR.rheumaticFever);
myocarditisDis.addInternalCause(LR.toxoplasmosisAcquiredAdvanced);
myocarditisDis.addReference("pp 1080-2");
Treatment myocarditisTr1 = new Treatment("myocarditisTr1");
myocarditisTr1.addTreatmentAction(LR.bedRest);
myocarditisTr1.addDrug(LR.antibiotics);
myocarditisDis.addTreatment("myocarditisTr1");
myocarditisDis.setCode358(232);
myocarditisDis.setICD10code("I51");


    // -------------- patentDuctusArteriosus ---------------
// (C) OntoOO Inc Sun Sep 30 21:19:59 PDT 2001
// (C) OntoOO Inc Fri Aug 20 11:55:10 GMT-08:00 2004
Disease patentDuctusArteriosusDis = new Disease(
   LR.patentDuctusArteriosus, 
   "congenital pulmonary artery - aorta connection defect causing a circulation problem", 
   LR.vascularDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.pulmonaryArterySysSt, 
   LR.none
);
patentDuctusArteriosusDis.setPrintName("patent ductus arteriosus");
patentDuctusArteriosusDis.addSymptom(LR.respirationDistress);
patentDuctusArteriosusDis.addReference("pp 1074-6");
Treatment patentDuctusArteriosusTr1  = new Treatment("patentDuctusArteriosusTr1", LR.ifSevere);
patentDuctusArteriosusTr1.addTreatmentAction(LR.surgery);
patentDuctusArteriosusDis.addTreatment(patentDuctusArteriosusTr1.getName());


// -------------- patentDuctusArteriosusInfant --------------
// (C) OntoOO Inc Fri Aug 20 12:15:20 GMT-08:00 2004
Disease patentDuctusArteriosusInfantDis = new Disease(
   LR.patentDuctusArteriosusInfant, 
   "congenital pulmonary artery - " +
   "aorta connection defect causing a circulation problem of an infant", 
   LR.vascularDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   6,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.pulmonaryArterySysSt, 
   LR.none
);
patentDuctusArteriosusInfantDis.setPrintName("patent ductus arteriosus infant");
patentDuctusArteriosusInfantDis.setSuperDisease(LR.patentDuctusArteriosus);
patentDuctusArteriosusInfantDis.addSymptom(LR.motorDysfunction);
patentDuctusArteriosusInfantDis.addSymptom(LR.developmentSlow);
patentDuctusArteriosusInfantDis.addReference("pp 1074-6");
Treatment patentDuctusArteriosusInfantTr1  = new Treatment("patentDuctusArteriosusInfantTr1");
patentDuctusArteriosusInfantTr1.addTreatmentAction(LR.fluidRestriction);
patentDuctusArteriosusInfantTr1.addDrug(LR.digitalisGlycosides);
patentDuctusArteriosusInfantTr1.addDrug(LR.diuretics);
patentDuctusArteriosusInfantDis.addTreatment(patentDuctusArteriosusInfantTr1.getName());


// -------------- patentDuctusArteriosusChild --------------
// (C) OntoOO Inc Fri Aug 20 14:09:07 GMT-08:00 2004
Disease patentDuctusArteriosusChildDis = new Disease(
   LR.patentDuctusArteriosusChild, 
   "congenital pulmonary artery - " +
   "aorta connection defect causing a circulation problem of a child", 
   LR.vascularDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   7, //  minAge 
   16,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.pulmonaryArterySysSt, 
   LR.none
);
patentDuctusArteriosusChildDis.setPrintName("patent ductus arteriosus child");
patentDuctusArteriosusChildDis.setSuperDisease(LR.patentDuctusArteriosus);
patentDuctusArteriosusChildDis.addSymptom(LR.developmentSlow, "", 1.0f);
patentDuctusArteriosusChildDis.addSymptom(LR.fatigueProlonged);
patentDuctusArteriosusChildDis.addReference("pp 1074-6");
patentDuctusArteriosusChildDis.setMiscComments("frequent respiratory tract infections");
Treatment patentDuctusArteriosusChildTr1  = 
    new Treatment("patentDuctusArteriosusChildTr1", LR.beforeSurgery);
patentDuctusArteriosusChildTr1.addDrug(LR.antibiotics);
patentDuctusArteriosusChildDis.addTreatment(patentDuctusArteriosusChildTr1.getName());


// -------------- patentDuctusArteriosusAdult --------------
// (C) OntoOO Inc Fri Aug 20 14:43:45 GMT-08:00 2004
Disease patentDuctusArteriosusAdultDis = new Disease(
   LR.patentDuctusArteriosusAdult, 
   "congenital pulmonary artery - " +
   "aorta connection defect causing a circulation problem of an adult", 
   LR.vascularDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   17, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.pulmonaryArterySysSt, 
   LR.none
);
patentDuctusArteriosusAdultDis.setPrintName("patent ductus arteriosus adult");
patentDuctusArteriosusAdultDis.setSuperDisease(LR.patentDuctusArteriosus);
patentDuctusArteriosusAdultDis.addSymptom(LR.dyspnea);
patentDuctusArteriosusAdultDis.addSymptom(LR.fatigueProlonged);
// patentDuctusArteriosusAdultDis.addCausesDisease(LR.pulmonaryVascularDisease);
patentDuctusArteriosusAdultDis.addReference("pp 1074-6");


// -------------- pericarditis --------------
// (C) OntoOO Inc Fri Oct 25 09:59:45 PDT 2002
Disease pericarditisDis = new Disease(
   LR.pericarditis, 
   "inflammation of the pericardium - the sac that contains the heart", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.infection
);
pericarditisDis.addSymptom(LR.armPitPain);
pericarditisDis.addSymptom(LR.breastBonePain);
pericarditisDis.addSymptom(LR.chestPain);
pericarditisDis.addSymptom(LR.neckPain);
pericarditisDis.addSymptom(LR.shoulderPain);
pericarditisDis.addInternalCause(LR.pneumonia);
pericarditisDis.addInternalCause(LR.tubularNecrosisAcute);
pericarditisDis.addInternalCause(LR.myocardialInfarction);
pericarditisDis.addInternalCause(LR.rheumaticFever);
pericarditisDis.addInternalCause(LR.rheumatoidArthritis3);
pericarditisDis.addCausingAbnormalCondition(LR.uremia);
pericarditisDis.addReference("pp 1084-7");
pericarditisDis.setMiscComments("deal with underlying systemic disease");
Treatment pericarditisTr1  = new Treatment("pericarditisTr1");
pericarditisTr1.addTreatmentAction(LR.bedRest);
pericarditisTr1.addDrug(LR.aspirin);
pericarditisDis.addTreatment(pericarditisTr1.getName());
pericarditisDis.setCode358(222);
pericarditisDis.setICD10code("I30");



// -------------- rheumaticFever --------------
// (C) OntoOO Inc Tue Oct 29 21:59:18 PST 2002
Disease rheumaticFeverDis = new Disease(
   LR.rheumaticFever, 
   "a streptococcal infection usually affecting joints with potential impact on the heart", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   20,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
rheumaticFeverDis.setPrintName("rheumatic fever");
rheumaticFeverDis.setTemperature((float)100.5);
rheumaticFeverDis.addCausesDisease(LR.choreaTransient);
rheumaticFeverDis.addCausesDisease(LR.endocarditis);
rheumaticFeverDis.addCausesDisease(LR.myocarditis);
rheumaticFeverDis.addCausesDisease(LR.pericarditis);
rheumaticFeverDis.addCausesDisease(LR.rheumaticHeartDisease);
rheumaticFeverDis.addReference("pp 1087-9");
rheumaticFeverDis.setMiscComments(
    "hypersensitive reaction to beta-hemolic streptococcal infection; " + 
    "antibodies can cause lesions in joints and heart");
Treatment rheumaticFeverTr1  = new Treatment("rheumaticFeverTr1");
rheumaticFeverTr1.addDrug(LR.aspirin);
rheumaticFeverTr1.addDrug(LR.penicillin);
rheumaticFeverDis.addTreatment(rheumaticFeverTr1.getName());
rheumaticFeverDis.setCode358(199);
rheumaticFeverDis.setICD10code("I00");


// -------------- rheumaticFeverJoints --------------
// (C) OntoOO Inc Tue Oct 29 21:59:18 PST 2002
Disease rheumaticFeverJointsDis = new Disease(
   LR.rheumaticFeverJoints, 
   "a streptococcal infection affecting the joints with potential impact on the heart", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   20,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
rheumaticFeverJointsDis.setPrintName("rheumatic fever joints");
rheumaticFeverJointsDis.setSuperDisease(LR.rheumaticFever); 
rheumaticFeverJointsDis.setTemperature((float)100.5);
rheumaticFeverJointsDis.addSymptom(LR.jointRedness, "", 0.95f);
rheumaticFeverJointsDis.addSymptom(LR.jointSwelling, "", 0.95f);
rheumaticFeverJointsDis.addSymptom(LR.anklePain, "", 0.95f);
rheumaticFeverJointsDis.addSymptom(LR.elbowPain, "", 0.95f);
rheumaticFeverJointsDis.addSymptom(LR.hipPain, "", 0.95f);
rheumaticFeverJointsDis.addSymptom(LR.kneePain, "", 0.95f);
rheumaticFeverJointsDis.addSymptom(LR.polyarthritis, "", 0.95f); 
// rheumaticFeverJointsDis.addCausesDisease(LR.rheumaticHeartDisease);
rheumaticFeverJointsDis.addReference("pp 1087-9");


// -------------- rheumaticFeverSkin --------------
// (C) OntoOO Inc Mon Nov 11 16:23:49 PST 2002
Disease rheumaticFeverSkinDis = new Disease(
   LR.rheumaticFeverSkin, 
   "a streptococcal infection affecting the skin with potential impact on the heart", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   20,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
rheumaticFeverSkinDis.setPrintName("rheumatic fever skin");
rheumaticFeverSkinDis.setSuperDisease(LR.rheumaticFever);
rheumaticFeverSkinDis.setTemperature((float)100.5);
rheumaticFeverSkinDis.addSymptom(LR.rashCreeping);
rheumaticFeverSkinDis.addSymptom(LR.skinLesionMacular);
rheumaticFeverSkinDis.addSymptom(LR.skinLesionRedWhite); 
rheumaticFeverSkinDis.addReference("pp 1087-9");


// -------------- rheumaticFeverNodules --------------
// (C) OntoOO Inc Tue Nov 12 13:51:37 PST 2002
Disease rheumaticFeverNodulesDis = new Disease(
   LR.rheumaticFeverNodules, 
   "a streptococcal infection causing skin nodules with potential impact on the heart", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   20,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
rheumaticFeverNodulesDis.setPrintName("rheumatic fever skin nodules");
rheumaticFeverNodulesDis.setSuperDisease(LR.rheumaticFever);
rheumaticFeverNodulesDis.setTemperature((float)100.5);
rheumaticFeverNodulesDis.addSymptom(LR.handNodule, "", 0.5f);
rheumaticFeverNodulesDis.addSymptom(LR.jointNodule, "", 1.0f);
rheumaticFeverNodulesDis.addSymptom(LR.scalpNodule, "", 0.5f);
rheumaticFeverNodulesDis.addReference("pp 1087-9");


// -------------- rheumaticHeartDisease --------------
// (C) OntoOO Inc Tue Feb 19 17:03:02 PST 2002
Disease rheumaticHeartDiseaseDis = new Disease(
   LR.rheumaticHeartDisease, 
   "RHD = acute cardiac manifestations of rheumatic fever and " +
   "chronic valvular disease later", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt,
   LR.none
);
rheumaticHeartDiseaseDis.setPrintName("rheumatic heart disease");
rheumaticHeartDiseaseDis.addSymptom(LR.coughHacking);
rheumaticHeartDiseaseDis.addSymptom(LR.dyspnea);
rheumaticHeartDiseaseDis.addSymptom(LR.edema);
rheumaticHeartDiseaseDis.addSymptom(LR.heartPain);
rheumaticHeartDiseaseDis.addSymptom(LR.tachycardia);
rheumaticHeartDiseaseDis.addSymptom(LR.tachypnea); 
rheumaticHeartDiseaseDis.addInternalCause(LR.rheumaticFever);
rheumaticHeartDiseaseDis.addReference("pp 1087-9");
Treatment rheumaticHeartDiseaseTr1 = new Treatment("rheumaticHeartDiseaseTr1");
rheumaticHeartDiseaseTr1.addTreatmentAction(LR.bedRest);
rheumaticHeartDiseaseTr1.addDrug(LR.corticosteroids);
rheumaticHeartDiseaseDis.addTreatment(rheumaticHeartDiseaseTr1.getName()); 
rheumaticHeartDiseaseDis.setCode358(201);
rheumaticHeartDiseaseDis.setICD10code("I05");


// -------------- thoracicAortaAneurysm --------------
// (C) OntoOO Inc Fri Dec 07 15:52:20 PST 2001
Disease thoracicAortaAneurysmDis = new Disease(
   LR.thoracicAortaAneurysm, 
   "abnormal widening of an aorta section", 
   LR.vascularDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vascularSysSt, 
   LR.none
);
thoracicAortaAneurysmDis.setPrintName("thoracic aorta aneurysm");

thoracicAortaAneurysmDis.addSymptom(LR.abdomenPain, "", 1.0f);
thoracicAortaAneurysmDis.addSymptom(LR.backPain);
thoracicAortaAneurysmDis.addSymptom(LR.bradycardia, "", 1.0f);
thoracicAortaAneurysmDis.addSymptom(LR.dysphagia, "", 1.0f);
thoracicAortaAneurysmDis.addSymptom(LR.dyspnea, "", 1.0f);
thoracicAortaAneurysmDis.addSymptom(LR.hoarseness);
thoracicAortaAneurysmDis.addSymptom(LR.neckPain, "", 1.0f);
thoracicAortaAneurysmDis.addSymptom(LR.shoulderPain, "", 1.0f);

thoracicAortaAneurysmDis.addInternalCause(LR.syphilisLateCardioVascular);
thoracicAortaAneurysmDis.addCausesDisease(LR.aortaInsufficiency);
thoracicAortaAneurysmDis.addCausesAbnormalCondition(LR.pericardialFrictionRub);
thoracicAortaAneurysmDis.addCausesAbnormalCondition(LR.bloodPressureDifferences); 
thoracicAortaAneurysmDis.addCausesAbnormalCondition(LR.neurologicDeficiences);  
thoracicAortaAneurysmDis.addReference("pp 1134-7");

Treatment thoracicAortaAneurysmTr1 = new Treatment("thoracicAortaAneurysmTr1");
thoracicAortaAneurysmTr1.addTreatmentAction(LR.IVFluids);
thoracicAortaAneurysmTr1.addTreatmentAction(LR.airwayMaintenance);
thoracicAortaAneurysmTr1.addTreatmentAction(LR.bloodTransfusion);
thoracicAortaAneurysmTr1.addTreatmentAction(LR.surgery);
thoracicAortaAneurysmTr1.addDrug(LR.antihypertensives);
thoracicAortaAneurysmTr1.addDrug(LR.narcotics);
thoracicAortaAneurysmTr1.addDrug(LR.negativeInotropicAgents);
thoracicAortaAneurysmDis.addTreatment(thoracicAortaAneurysmTr1.getName()); 
thoracicAortaAneurysmDis.setCode358(242);
thoracicAortaAneurysmDis.setICD10code("I71");


// -------------- thrombophlebitis --------------
// (C) OntoOO Inc Mon Jan 20 12:40:37 PST 2003
Disease thrombophlebitisDis = new Disease(
   LR.thrombophlebitis, 
   "inflammation and thrombus formation in various veins", 
   LR.vascularDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.cardioVascularSysSt, 
   LR.longTermImmobility
);
thrombophlebitisDis.addSymptom(LR.chills, "", 1.0f);
thrombophlebitisDis.addSymptom(LR.cyanosis, "", 1.0f);
thrombophlebitisDis.addSymptom(LR.malaise, "", 1.0f);
thrombophlebitisDis.addSymptom(LR.lymphadenitis, " if extensive vein involvement", 0.1f);
thrombophlebitisDis.addSymptom(LR.veinHeat, "", 1.0f);
thrombophlebitisDis.addSymptom(LR.veinPain, "", 1.0f);
thrombophlebitisDis.addSymptom(LR.veinSwelling, "", 1.0f);
thrombophlebitisDis.addSymptom(LR.veinTender, "", 1.0f);
thrombophlebitisDis.addExternalCause(LR.trauma);
thrombophlebitisDis.addExternalCause(LR.oralContraceptiveUse);
thrombophlebitisDis.addExternalCause(LR.childbirth);
thrombophlebitisDis.addExternalCause(LR.surgery);
thrombophlebitisDis.addReference("pp 1142-5");
Treatment thrombophlebitisTr1 = new Treatment("thrombophlebitisTr1");
thrombophlebitisTr1.addTreatmentAction(LR.bedRest);
thrombophlebitisTr1.addDrug(LR.analgetics);
thrombophlebitisDis.addTreatment("thrombophlebitisTr1");
thrombophlebitisDis.setCode358(245);
thrombophlebitisDis.setICD10code("I80");


// -------------- ventricularAneurysm --------------
// (C) OntoOO Inc Sun Dec 09 18:56:01 PST 2001
Disease ventricularAneurysmDis = new Disease(
   LR.ventricularAneurysm, 
   "outpouching of a ventricle (= chamber) of the heart, typically after an infarct", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
ventricularAneurysmDis.setPrintName("ventricular aneurysm");

ventricularAneurysmDis.addSymptom(LR.anginaPain);
ventricularAneurysmDis.addSymptom(LR.arrhythmia);
ventricularAneurysmDis.addSymptom(LR.crackles);
ventricularAneurysmDis.addSymptom(LR.dyspnea);
ventricularAneurysmDis.addSymptom(LR.edema);
ventricularAneurysmDis.addSymptom(LR.fatigue);
ventricularAneurysmDis.addSymptom(LR.neckVeinsElevated);
ventricularAneurysmDis.addSymptom(LR.palpitations);
ventricularAneurysmDis.addSymptom(LR.pulsusAlternans);
ventricularAneurysmDis.addSymptom(LR.weakness);

ventricularAneurysmDis.addInternalCause(LR.myocardialInfarction);
ventricularAneurysmDis.addCausesAbnormalCondition(LR.systemicEmbolization);

ventricularAneurysmDis.addReference("pp 1122-3");
ventricularAneurysmDis.setMiscComments("20% of infarct patients develop this complication");

Treatment ventricularAneurysmTr1 = new Treatment("ventricularAneurysmTr1");
ventricularAneurysmTr1.addTreatmentAction(LR.intubation);
ventricularAneurysmTr1.addTreatmentAction(LR.mechanicalVentilation);
ventricularAneurysmTr1.addTreatmentAction(LR.oxygenTherapy);
ventricularAneurysmTr1.addTreatmentAction(LR.embolectomy);
ventricularAneurysmTr1.addTreatmentAction(LR.cardioversion);
ventricularAneurysmTr1.addDrug(LR.antiArrhythemics);
ventricularAneurysmTr1.addDrug(LR.anticoagulants);
ventricularAneurysmTr1.addDrug(LR.digitalisGlycosides);
ventricularAneurysmTr1.addDrug(LR.furosemide);
ventricularAneurysmTr1.addDrug(LR.morphine);
ventricularAneurysmTr1.addDrug(LR.sodiumNitroprusside);
ventricularAneurysmDis.addTreatment(ventricularAneurysmTr1.getName()); 


// -------------- ventricularSeptalDefect --------------
// (C) OntoOO Inc Mon Dec 10 21:20:08 PST 2001
Disease ventricularSeptalDefectDis = new Disease(
   LR.ventricularSeptalDefect, 
   "incomplete separation of the ventricle heart chambers", 
   LR.cardioDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
ventricularSeptalDefectDis.setPrintName("ventricular septal defect");
ventricularSeptalDefectDis.addSymptom(LR.cyanosis);
ventricularSeptalDefectDis.addSymptom(LR.diaphoresis);
ventricularSeptalDefectDis.addSymptom(LR.grunting);
ventricularSeptalDefectDis.addSymptom(LR.pulseRapid);
ventricularSeptalDefectDis.addSymptom(LR.tachypnea);
ventricularSeptalDefectDis.addSymptom(LR.skinDusky);
ventricularSeptalDefectDis.addReference("pp 1068-70");
ventricularSeptalDefectDis.setMiscComments("condition at birth");

Treatment ventricularSeptalDefectTr1 = 
  new Treatment("ventricularSeptalDefectTr1");
ventricularSeptalDefectTr1.addTreatmentAction(LR.surgery);
ventricularSeptalDefectDis.addTreatment(ventricularSeptalDefectTr1.getName()); 

  } // end doit()

} // end InitCardioDiseases
