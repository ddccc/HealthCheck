// (C) OntoOO 2011
package init;
import com.D;
import com.L;
import com.F;
import com.LR;
import concepts.Disease;
import concepts.Treatment;
public class GenDiseases2 {
  public static void doit() {
   cardioDisorders();
   earDisorders();
   endocrineDisorders();
   eyeDisorders();
   gastrointestinalDisorders();
   geneticDisorders();
   gynecologicDisorders();
   hematologicDisorders();
   hepatobiliaryDisorders();
   immuneDisorders();
   infections();
   metabolicDisorders();
   musculoDisorders();
   neoPlasms();
   neurologicDisorders();
   noseDisorders();
   nutritionalDisorders();
   pediatricDisorders();
   psychiatricDisorders();
   renalDisorders();
   respiratoryDisorders();
   sexualDisorders();
   skeletalDisorders();
   skinDisorders();
   throatDisorders();
   traumas();
   urologicDisorders();
   vascularDisorders();
} // end of doit


// ------------- cardioDisorders  -------------
static public void cardioDisorders() { 


// ------------- atrialSeptalDefect  -------------
Disease atrialSeptalDefectDis = new Disease(
    LR.atrialSeptalDefect,
    L.atrialSeptalDefectDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
atrialSeptalDefectDis.setPrintName(L.atrialSeptalDefectPrintName);
atrialSeptalDefectDis.setMiscComments(L.atrialSeptalDefectComment);
atrialSeptalDefectDis.addReference("pp 1070-2");
atrialSeptalDefectDis.addSymptom(LR.dyspnea);
atrialSeptalDefectDis.addSymptom(LR.fatigue);
atrialSeptalDefectDis.addSymptom(LR.breathlessness);
atrialSeptalDefectDis.addSymptom(LR.palpitations);
Treatment atrialSeptalDefectTr1 = new Treatment("atrialSeptalDefectTr1");
atrialSeptalDefectTr1.addTreatmentAction(LR.surgery);
atrialSeptalDefectDis.addTreatment("atrialSeptalDefectTr1");


// ------------- cardiacArrest  -------------
Disease cardiacArrestDis = new Disease(
    LR.cardiacArrest,
    L.cardiacArrestDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
cardiacArrestDis.setPrintName(L.cardiacArrestPrintName);
cardiacArrestDis.addInternalCause(LR.hypokalemiaSuper);
cardiacArrestDis.addInternalCause(LR.hypertension);
cardiacArrestDis.addReference("pp 0");
cardiacArrestDis.addSymptom(LR.anuria);
cardiacArrestDis.addSymptom(LR.apnea);
cardiacArrestDis.addSymptom(LR.consciousnessLoss);
cardiacArrestDis.addSymptom(LR.coolExtremities);
cardiacArrestDis.addSymptom(LR.pulseAbsent);
Treatment cardiacArrestTr1 = new Treatment("cardiacArrestTr1");
cardiacArrestTr1.addTreatmentAction(LR.CPR);
cardiacArrestTr1.addTreatmentAction(LR.fluidManagement);
cardiacArrestTr1.addTreatmentAction(LR.mechanicalVentilation);
cardiacArrestTr1.addTreatmentAction(LR.oxygenTherapy);
cardiacArrestTr1.addTreatmentAction(LR.cardioversion);
cardiacArrestTr1.addDrug(LR.epinephrine);
cardiacArrestTr1.addDrug(LR.lidocaine);
cardiacArrestTr1.addDrug(LR.bretyllium);
cardiacArrestDis.addTreatment("cardiacArrestTr1");


// ------------- cardiacArrhythmia  -------------
Disease cardiacArrhythmiaDis = new Disease(
    LR.cardiacArrhythmia,
    L.cardiacArrhythmiaDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.cardioVascularSysSt,
    LR.none
);
cardiacArrhythmiaDis.setPrintName(L.cardiacArrhythmiaPrintName);
cardiacArrhythmiaDis.setCode358(228);
cardiacArrhythmiaDis.setICD10code("I44");
cardiacArrhythmiaDis.addReference("pp 1125-1134");
cardiacArrhythmiaDis.addSymptom(LR.arrhythmia);
cardiacArrhythmiaDis.addSymptom(LR.chestPain, "", 0.3f);
cardiacArrhythmiaDis.addSymptom(LR.diaphoresis, "", 0.3f);
cardiacArrhythmiaDis.addSymptom(LR.dyspnea, "", 0.3f);
cardiacArrhythmiaDis.addSymptom(LR.lightHeadedness, "", 0.3f);
cardiacArrhythmiaDis.addSymptom(LR.palpitations, "", 0.3f);
cardiacArrhythmiaDis.addSymptom(LR.vertigo, "", 0.3f);
cardiacArrhythmiaDis.addSymptom(LR.weakness, "", 0.3f);


// ------------- cardiogenicShock  -------------
Disease cardiogenicShockDis = new Disease(
    LR.cardiogenicShock,
    L.cardiogenicShockDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
cardiogenicShockDis.setPrintName(L.cardiogenicShockPrintName);
cardiogenicShockDis.setMiscComments(L.cardiogenicShockComment);
cardiogenicShockDis.addReference("pp 1118-21");
cardiogenicShockDis.addSymptom(LR.confusion);
cardiogenicShockDis.addSymptom(LR.cyanosis);
cardiogenicShockDis.addSymptom(LR.hypotension);
cardiogenicShockDis.addSymptom(LR.oliguria);
cardiogenicShockDis.addSymptom(LR.pallor);
cardiogenicShockDis.addSymptom(LR.tachypnea);
cardiogenicShockDis.addSymptom(LR.respirationShallow);
cardiogenicShockDis.addSymptom(LR.restlessness);
cardiogenicShockDis.addSymptom(LR.skinClammy);
cardiogenicShockDis.addSymptom(LR.skinCold);
cardiogenicShockDis.addSymptom(LR.tachycardia);
cardiogenicShockDis.addSymptom(LR.obtundation);
cardiogenicShockDis.addSymptom(LR.pulsePressureNarrows);
Treatment cardiogenicShockTr1 = new Treatment("cardiogenicShockTr1");
cardiogenicShockTr1.addTreatmentAction(LR.increaseCardiacOutput);
cardiogenicShockTr1.addTreatmentAction(LR.decreaseCardiacWorkload);
cardiogenicShockDis.addTreatment("cardiogenicShockTr1");


// ------------- cardiomyopathy  -------------
Disease cardiomyopathyDis = new Disease(
    LR.cardiomyopathy,
    L.cardiomyopathyDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
cardiomyopathyDis.setPrintName(L.cardiomyopathyPrintName);
cardiomyopathyDis.setCode358(227);
cardiomyopathyDis.setICD10code("I42");
cardiomyopathyDis.addInternalCause(LR.sarcoidosisCardio);
cardiomyopathyDis.addReference("pp 1111-2");
cardiomyopathyDis.addSymptom(LR.arrhythmia);
cardiomyopathyDis.addSymptom(LR.breathlessness);
cardiomyopathyDis.addSymptom(LR.coughDry);
cardiomyopathyDis.addSymptom(LR.cyanosis, "", 0.3f);
cardiomyopathyDis.addSymptom(LR.dyspnea);
cardiomyopathyDis.addSymptom(LR.edema);
cardiomyopathyDis.addSymptom(LR.fatigue);
cardiomyopathyDis.addSymptom(LR.liverEnlarged);
cardiomyopathyDis.addSymptom(LR.neckVeinsElevated);
cardiomyopathyDis.addSymptom(LR.orthopnea);
Treatment cardiomyopathyTr1 = new Treatment("cardiomyopathyTr1");
cardiomyopathyTr1.addTreatmentAction(LR.bedRest);
cardiomyopathyTr1.addTreatmentAction(LR.oxygenTherapy);
cardiomyopathyTr1.addTreatmentAction(LR.vasopressor);
cardiomyopathyTr1.addTreatmentAction(LR.sodiumRestriction);
cardiomyopathyTr1.addDrug(LR.digoxin);
cardiomyopathyTr1.addDrug(LR.diuretics);
cardiomyopathyTr1.addDrug(LR.steroids);
cardiomyopathyDis.addTreatment("cardiomyopathyTr1");


// ------------- coronaryArteryDisease  -------------
Disease coronaryArteryDiseaseDis = new Disease(
    LR.coronaryArteryDisease,
    L.coronaryArteryDiseaseDescription,
    LR.cardioDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
coronaryArteryDiseaseDis.setPrintName(L.coronaryArteryDiseasePrintName);
coronaryArteryDiseaseDis.setCode358(214);
coronaryArteryDiseaseDis.setICD10code("I25");
coronaryArteryDiseaseDis.addCausingAbnormalCondition(LR.atherosclerosis);
coronaryArteryDiseaseDis.addReference("pp 1098-1101");
coronaryArteryDiseaseDis.addSymptom(LR.anginaPain);
coronaryArteryDiseaseDis.addSymptom(LR.chestTightness);
coronaryArteryDiseaseDis.addSymptom(LR.coolExtremities);
coronaryArteryDiseaseDis.addSymptom(LR.fainting);
coronaryArteryDiseaseDis.addSymptom(LR.nausea);
coronaryArteryDiseaseDis.addSymptom(LR.sweating);
coronaryArteryDiseaseDis.addSymptom(LR.vomiting);
Treatment coronaryArteryDiseaseTr1 = new Treatment("coronaryArteryDiseaseTr1");
coronaryArteryDiseaseTr1.addTreatmentAction(LR.surgery);
coronaryArteryDiseaseTr1.addDrug(LR.nitroglycerin);
coronaryArteryDiseaseDis.addTreatment("coronaryArteryDiseaseTr1");


// ------------- corPulmonale  -------------
Disease corPulmonaleDis = new Disease(
    LR.corPulmonale,
    L.corPulmonaleDescription,
    LR.cardioDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.lungTissueLossDueToSurgery
);
corPulmonaleDis.setPrintName(L.corPulmonalePrintName);
corPulmonaleDis.setMiscComments(L.corPulmonaleComment);
corPulmonaleDis.addInternalCause(LR.amyotropicLateralSclerosis);
corPulmonaleDis.addInternalCause(LR.asbestosis);
corPulmonaleDis.addInternalCause(LR.berylliosisChronic);
corPulmonaleDis.addInternalCause(LR.bronchiectasis);
corPulmonaleDis.addInternalCause(LR.chronicObstructivePulmonaryDisease);
corPulmonaleDis.addInternalCause(LR.coalWorkerPneumoconiosis);
corPulmonaleDis.addInternalCause(LR.cysticFibrosis);
corPulmonaleDis.addInternalCause(LR.kyphoscoliosis);
corPulmonaleDis.addInternalCause(LR.muscularDystrophy);
corPulmonaleDis.addInternalCause(LR.pulmonaryHypertension);
corPulmonaleDis.addInternalCause(LR.sarcoidosis);
corPulmonaleDis.addInternalCause(LR.sarcoidosisRespiratory);
corPulmonaleDis.addInternalCause(LR.schistosomiasis);
corPulmonaleDis.addInternalCause(LR.scleroderma);
corPulmonaleDis.addInternalCause(LR.sickleCellAnemia);
corPulmonaleDis.addInternalCause(LR.silicosis);
corPulmonaleDis.addInternalCause(LR.vasculitisPulmonary);
corPulmonaleDis.addCausingAbnormalCondition(LR.upperAirwayObstruction);
corPulmonaleDis.addCausingAbnormalCondition(LR.spinalCordLesionAboveC6);
corPulmonaleDis.addCausingAbnormalCondition(LR.obesityHypoVentilation);
corPulmonaleDis.addReference("pp 506-8");
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
Treatment corPulmonaleTr1 = new Treatment("corPulmonaleTr1");
corPulmonaleTr1.addTreatmentAction(LR.bedRest);
corPulmonaleDis.addTreatment("corPulmonaleTr1");
Treatment corPulmonaleTr2 = new Treatment("corPulmonaleTr2");
corPulmonaleTr2.addTreatmentAction(LR.ifInfectionProvideAntibiotic);
corPulmonaleTr2.addDrug(LR.digoxin);
corPulmonaleTr2.addDrug(LR.pulmonaryArteryVasodilators);
corPulmonaleTr2.addDrug(LR.diazoxide);
corPulmonaleTr2.addDrug(LR.nitroprusside);
corPulmonaleTr2.addDrug(LR.hydralazine);
corPulmonaleTr2.addDrug(LR.prostaglandins);
corPulmonaleDis.addTreatment("corPulmonaleTr2");
Treatment corPulmonaleTr3 = new Treatment("corPulmonaleTr3");
corPulmonaleTr3.addTreatmentAction(LR.oxygenTherapy);
corPulmonaleTr3.addTreatmentAction(LR.mechanicalVentilation);
corPulmonaleDis.addTreatment("corPulmonaleTr3");
Treatment corPulmonaleTr4 = new Treatment("corPulmonaleTr4");
corPulmonaleTr4.addTreatmentAction(LR.dietLowSalt);
corPulmonaleTr4.addDrug(LR.diuretics);
corPulmonaleTr4.addDrug(LR.furosemide);
corPulmonaleDis.addTreatment("corPulmonaleTr4");
Treatment corPulmonaleTr5 = new Treatment("corPulmonaleTr5");
corPulmonaleTr5.addTreatmentAction(LR.phlebotomy);
corPulmonaleDis.addTreatment("corPulmonaleTr5");
Treatment corPulmonaleTr6 = new Treatment("corPulmonaleTr6");
corPulmonaleTr6.addDrug(LR.anticoagulants);
corPulmonaleTr6.addDrug(LR.heparin);
corPulmonaleDis.addTreatment("corPulmonaleTr6");


// ------------- endocarditis  -------------
Disease endocarditisDis = new Disease(
    LR.endocarditis,
    L.endocarditisDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.infection
);
endocarditisDis.setPrintName(L.endocarditisPrintName);
endocarditisDis.setCode358(221);
endocarditisDis.setICD10code("I33");
endocarditisDis.addInternalCause(LR.pneumonia);
endocarditisDis.addInternalCause(LR.rheumaticFever);
endocarditisDis.addCausesAbnormalCondition(LR.valvularInsufficiency);
endocarditisDis.addReference("pp 1082-4");
endocarditisDis.addSymptom(LR.anorexia);
endocarditisDis.addSymptom(LR.arthralgia);
endocarditisDis.addSymptom(LR.chills);
endocarditisDis.addSymptom(LR.fatigue);
endocarditisDis.addSymptom(LR.feverIntermittent);
endocarditisDis.addSymptom(LR.malaise);
endocarditisDis.addSymptom(LR.murmurLoud);
endocarditisDis.addSymptom(LR.nightSweating);
endocarditisDis.addSymptom(LR.weakness);
endocarditisDis.addSymptom(LR.weightLoss);
Treatment endocarditisTr1 = new Treatment("endocarditisTr1");
endocarditisTr1.addTreatmentAction(LR.fluidManagement);
endocarditisTr1.addTreatmentAction(LR.ifFeverProvideAntipyretic);
endocarditisTr1.addTreatmentAction(LR.nutritionImprove);
endocarditisTr1.addDrug(LR.antimicrobials);
endocarditisDis.addTreatment("endocarditisTr1");


// ------------- heartFailure  -------------
Disease heartFailureDis = new Disease(
    LR.heartFailure,
    L.heartFailureDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
heartFailureDis.setPrintName(L.heartFailurePrintName);
heartFailureDis.setCode358(230);
heartFailureDis.setICD10code("I50");
heartFailureDis.addInternalCause(LR.legionaire);
heartFailureDis.addInternalCause(LR.renalFailureAcute);
heartFailureDis.addInternalCause(LR.schistosomiasis);
heartFailureDis.addInternalCause(LR.tubularNecrosisAcute);
heartFailureDis.addInternalCause(LR.muscularDystrophyBecker);
heartFailureDis.addInternalCause(LR.muscularDystrophyDuchenne);
heartFailureDis.addInternalCause(LR.valveDisorders);
heartFailureDis.addReference("pp 1106-11");
Treatment heartFailureTr1 = new Treatment("heartFailureTr1");
heartFailureTr1.addTreatmentAction(LR.bedRest);
heartFailureTr1.addTreatmentAction(LR.antiembolismStockings);
heartFailureTr1.addDrug(LR.digoxin);
heartFailureTr1.addDrug(LR.diuretics);
heartFailureTr1.addDrug(LR.vasodilators);
heartFailureDis.addTreatment("heartFailureTr1");


// ------------- heartFailureLeftSided  -------------
Disease heartFailureLeftSidedDis = new Disease(
    LR.heartFailureLeftSided,
    L.heartFailureLeftSidedDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
heartFailureLeftSidedDis.setPrintName(L.heartFailureLeftSidedPrintName);
heartFailureLeftSidedDis.setSuperDisease(LR.heartFailure);
heartFailureLeftSidedDis.setCode358(230);
heartFailureLeftSidedDis.setICD10code("I50");
heartFailureLeftSidedDis.addInternalCause(LR.hypertension);
heartFailureLeftSidedDis.addInternalCause(LR.aortaInsufficiency);
heartFailureLeftSidedDis.addCausesAbnormalCondition(LR.acidosis);
heartFailureLeftSidedDis.addCausesAbnormalCondition(LR.hypoxia);
heartFailureLeftSidedDis.addReference("pp 1106-11");
heartFailureLeftSidedDis.addSymptom(LR.arrhythmia);
heartFailureLeftSidedDis.addSymptom(LR.cough);
heartFailureLeftSidedDis.addSymptom(LR.crackles);
heartFailureLeftSidedDis.addSymptom(LR.cyanosis);
heartFailureLeftSidedDis.addSymptom(LR.dyspnea);
heartFailureLeftSidedDis.addSymptom(LR.orthopnea);
heartFailureLeftSidedDis.addSymptom(LR.palpitations);
heartFailureLeftSidedDis.addSymptom(LR.pulsusAlternans);
heartFailureLeftSidedDis.addSymptom(LR.wheezing);


// ------------- heartFailureRightSided  -------------
Disease heartFailureRightSidedDis = new Disease(
    LR.heartFailureRightSided,
    L.heartFailureRightSidedDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
heartFailureRightSidedDis.setPrintName(L.heartFailureRightSidedPrintName);
heartFailureRightSidedDis.setSuperDisease(LR.heartFailure);
heartFailureRightSidedDis.setCode358(230);
heartFailureRightSidedDis.setICD10code("I50");
heartFailureRightSidedDis.addInternalCause(LR.bronchiectasis);
heartFailureRightSidedDis.addInternalCause(LR.pulmonaryHypertension);
heartFailureRightSidedDis.addInternalCause(LR.hypertension);
heartFailureRightSidedDis.addCausingAbnormalCondition(LR.ascites);
heartFailureRightSidedDis.addCausingAbnormalCondition(LR.hepatomegaly);
heartFailureRightSidedDis.addCausingAbnormalCondition(LR.splenomegaly);
heartFailureRightSidedDis.addCausesAbnormalCondition(LR.hepatoJugularReflux);
heartFailureRightSidedDis.addReference("pp 1106-11");
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


// ------------- hypertension  -------------
Disease hypertensionDis = new Disease(
    LR.hypertension,
    L.hypertensionDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vascularSysSt,
    LR.sedentaryLifestyle
);
hypertensionDis.setPrintName(L.hypertensionPrintName);
hypertensionDis.setMiscComments(L.hypertensionComment);
hypertensionDis.addExternalCause(LR.oralContraceptiveUse);
hypertensionDis.addExternalCause(LR.sodiumExcess);
hypertensionDis.addExternalCause(LR.stress);
hypertensionDis.addExternalCause(LR.tobaccoUse);
hypertensionDis.setGenetic("1parent");
hypertensionDis.setParentDisease(LR.hypertension);
hypertensionDis.setCode358(206);
hypertensionDis.setICD10code("I10");
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
hypertensionDis.addCausingAbnormalCondition(LR.pregnancy);
hypertensionDis.addCausingAbnormalCondition(LR.atherosclerosis);
hypertensionDis.addCausesDisease(LR.cardiacArrest);
hypertensionDis.addCausesDisease(LR.cerebrovascularAccident);
hypertensionDis.addCausesDisease(LR.heartFailureLeftSided);
hypertensionDis.addCausesDisease(LR.heartFailureRightSided);
hypertensionDis.addCausesDisease(LR.hypertensiveCrisis);
hypertensionDis.addCausesDisease(LR.myocardialInfarction);
hypertensionDis.addCausesDisease(LR.pulmonaryEdema);
hypertensionDis.addCausesDisease(LR.renalFailureAcute);
hypertensionDis.addCausesAbnormalCondition(LR.blindness);
hypertensionDis.addCausesAbnormalCondition(LR.proteinuria);
hypertensionDis.addReference("pp 1093-7");
hypertensionDis.addSymptom(LR.dizziness, "", 0.1f);
hypertensionDis.addSymptom(LR.edema, "", 0.1f);
hypertensionDis.addSymptom(LR.headache, "", 0.1f);
Treatment hypertensionTr1 = new Treatment("hypertensionTr1");
hypertensionTr1.addTreatmentAction(LR.dietLowSalt);
hypertensionTr1.addTreatmentAction(LR.exercise);
hypertensionTr1.addTreatmentAction(LR.sodiumRestriction);
hypertensionTr1.addTreatmentAction(LR.weightReduction);
hypertensionTr1.addTreatmentAction(LR.alcoholModeration);
hypertensionTr1.addTreatmentAction(LR.smokingCessation);
hypertensionDis.addTreatment("hypertensionTr1");
Treatment hypertensionTr2 = new Treatment("hypertensionTr2");
hypertensionTr2.addDrug(LR.diuretics);
hypertensionTr2.addDrug(LR.betaBlocker);
hypertensionDis.addTreatment("hypertensionTr2");


// ------------- hypertensiveCrisis  -------------
Disease hypertensiveCrisisDis = new Disease(
    LR.hypertensiveCrisis,
    L.hypertensiveCrisisDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.cardioVascularSysSt,
    LR.none
);
hypertensiveCrisisDis.setPrintName(L.hypertensiveCrisisPrintName);
hypertensiveCrisisDis.setCode358(207);
hypertensiveCrisisDis.setICD10code("I11");
hypertensiveCrisisDis.addInternalCause(LR.hypertension);
hypertensiveCrisisDis.addReference("pp 1095");
hypertensiveCrisisDis.addSymptom(LR.coma);
hypertensiveCrisisDis.addSymptom(LR.headacheSevere);
hypertensiveCrisisDis.addSymptom(LR.ocularDisturbance);
hypertensiveCrisisDis.addSymptom(LR.papilledema);
hypertensiveCrisisDis.addSymptom(LR.paralysisTransient);
hypertensiveCrisisDis.addSymptom(LR.retinaHemorrhage);
hypertensiveCrisisDis.addSymptom(LR.seizure);
hypertensiveCrisisDis.addSymptom(LR.stupor);
hypertensiveCrisisDis.addSymptom(LR.vomiting);
Treatment hypertensiveCrisisTr1 = new Treatment("hypertensiveCrisisTr1");
hypertensiveCrisisTr1.addDrug(LR.diazoxide);
hypertensiveCrisisTr1.addDrug(LR.hydralazine);
hypertensiveCrisisTr1.addDrug(LR.nitroprusside);
hypertensiveCrisisTr1.addDrug(LR.trimethaphan);
hypertensiveCrisisTr1.addDrug(LR.nitroglycerin);
hypertensiveCrisisTr1.addDrug(LR.methyldopa);
hypertensiveCrisisDis.addTreatment("hypertensiveCrisisTr1");


// ------------- valveDisorders  -------------
Disease valveDisordersDis = new Disease(
    LR.valveDisorders,
    L.valveDisordersDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
valveDisordersDis.setPrintName(L.valveDisordersPrintName);
valveDisordersDis.setCode358(225);
valveDisordersDis.setICD10code("I35");
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
Treatment valveDisordersTr3 = new Treatment("valveDisordersTr3", LR.ifSevere);
valveDisordersTr3.addTreatmentAction(LR.valveReplacement);
valveDisordersDis.addTreatment("valveDisordersTr3");


// ------------- aortaInsufficiency  -------------
Disease aortaInsufficiencyDis = new Disease(
    LR.aortaInsufficiency,
    L.aortaInsufficiencyDescription,
    LR.cardioDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
aortaInsufficiencyDis.setPrintName(L.aortaInsufficiencyPrintName);
aortaInsufficiencyDis.setSuperDisease(LR.valveDisorders);
aortaInsufficiencyDis.addInternalCause(LR.ankylosingSpondylitis);
aortaInsufficiencyDis.addInternalCause(LR.endocarditis);
aortaInsufficiencyDis.addInternalCause(LR.rheumaticFever);
aortaInsufficiencyDis.addInternalCause(LR.syphilis);
aortaInsufficiencyDis.addInternalCause(LR.syphilisLateCardioVascular);
aortaInsufficiencyDis.addInternalCause(LR.thoracicAortaAneurysm);
aortaInsufficiencyDis.addCausesDisease(LR.heartFailureLeftSided);
aortaInsufficiencyDis.addCausesDisease(LR.pulmonaryEdema);
aortaInsufficiencyDis.addReference("pp 1089-93");
aortaInsufficiencyDis.addSymptom(LR.dyspnea);
aortaInsufficiencyDis.addSymptom(LR.fatigue);
aortaInsufficiencyDis.addSymptom(LR.palpitations);
aortaInsufficiencyDis.addSymptom(LR.anginaPain);
aortaInsufficiencyDis.addSymptom(LR.cough);
aortaInsufficiencyDis.addSymptom(LR.syncope);
aortaInsufficiencyDis.addSymptom(LR.arrhythmia);


// ------------- mitralInsufficiency  -------------
Disease mitralInsufficiencyDis = new Disease(
    LR.mitralInsufficiency,
    L.mitralInsufficiencyDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
mitralInsufficiencyDis.setPrintName(L.mitralInsufficiencyPrintName);
mitralInsufficiencyDis.setSuperDisease(LR.valveDisorders);
mitralInsufficiencyDis.setCode358(224);
mitralInsufficiencyDis.setICD10code("I34");
mitralInsufficiencyDis.addInternalCause(LR.heartFailureLeftSided);
mitralInsufficiencyDis.addInternalCause(LR.myocardialInfarction);
mitralInsufficiencyDis.addInternalCause(LR.rheumaticFever);
mitralInsufficiencyDis.addCausingAbnormalCondition(LR.hepatomegaly);
mitralInsufficiencyDis.addReference("pp 1089-93");
mitralInsufficiencyDis.addSymptom(LR.crackles);
mitralInsufficiencyDis.addSymptom(LR.dyspnea);
mitralInsufficiencyDis.addSymptom(LR.edemaPeripheral);
mitralInsufficiencyDis.addSymptom(LR.fatigue);
mitralInsufficiencyDis.addSymptom(LR.neckVeinsElevated);
mitralInsufficiencyDis.addSymptom(LR.orthopnea);
mitralInsufficiencyDis.addSymptom(LR.palpitations);
mitralInsufficiencyDis.addSymptom(LR.anginaPain);
mitralInsufficiencyDis.addSymptom(LR.tachycardia);


// ------------- mitralStenosis  -------------
Disease mitralStenosisDis = new Disease(
    LR.mitralStenosis,
    L.mitralStenosisDescription,
    LR.cardioDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
mitralStenosisDis.setPrintName(L.mitralStenosisPrintName);
mitralStenosisDis.setSuperDisease(LR.valveDisorders);
mitralStenosisDis.setCode358(224);
mitralStenosisDis.setICD10code("I34");
mitralStenosisDis.addCausesAbnormalCondition(LR.ascites);
mitralStenosisDis.addCausesAbnormalCondition(LR.hepatomegaly);
mitralStenosisDis.addReference("pp 1089-93");
mitralStenosisDis.addSymptom(LR.arrhythmia);
mitralStenosisDis.addSymptom(LR.crackles);
mitralStenosisDis.addSymptom(LR.dyspnea);
mitralStenosisDis.addSymptom(LR.edemaPeripheral);
mitralStenosisDis.addSymptom(LR.fatigue);
mitralStenosisDis.addSymptom(LR.neckVeinsElevated);
mitralStenosisDis.addSymptom(LR.orthopnea);
mitralStenosisDis.addSymptom(LR.palpitations);
mitralStenosisDis.addSymptom(LR.weakness);


// ------------- mitralValveProlapse  -------------
Disease mitralValveProlapseDis = new Disease(
    LR.mitralValveProlapse,
    L.mitralValveProlapseDescription,
    LR.cardioDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
mitralValveProlapseDis.setPrintName(L.mitralValveProlapsePrintName);
mitralValveProlapseDis.setSuperDisease(LR.valveDisorders);
mitralValveProlapseDis.setCode358(203);
mitralValveProlapseDis.setICD10code("I08");
mitralValveProlapseDis.addReference("pp 1089-93");
mitralValveProlapseDis.addSymptom(LR.dyspnea);
mitralValveProlapseDis.addSymptom(LR.fatigue);
mitralValveProlapseDis.addSymptom(LR.palpitations);
mitralValveProlapseDis.addSymptom(LR.weakness);
mitralValveProlapseDis.addSymptom(LR.anxiety);
mitralValveProlapseDis.addSymptom(LR.chestPain);
mitralValveProlapseDis.addSymptom(LR.headache);
mitralValveProlapseDis.addSymptom(LR.lightHeadedness);
mitralValveProlapseDis.addSymptom(LR.syncope);
mitralValveProlapseDis.addSymptom(LR.moodSwings);
mitralValveProlapseDis.addSymptom(LR.panicAttacks);


// ------------- tricuspidInsufficiency  -------------
Disease tricuspidInsufficiencyDis = new Disease(
    LR.tricuspidInsufficiency,
    L.tricuspidInsufficiencyDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
tricuspidInsufficiencyDis.setPrintName(L.tricuspidInsufficiencyPrintName);
tricuspidInsufficiencyDis.setSuperDisease(LR.valveDisorders);
tricuspidInsufficiencyDis.addInternalCause(LR.endocarditis);
tricuspidInsufficiencyDis.addInternalCause(LR.heartFailureRightSided);
tricuspidInsufficiencyDis.addInternalCause(LR.rheumaticFever);
tricuspidInsufficiencyDis.addCausesAbnormalCondition(LR.ascites);
tricuspidInsufficiencyDis.addCausesAbnormalCondition(LR.hepatomegaly);
tricuspidInsufficiencyDis.addReference("pp 1089-93");
tricuspidInsufficiencyDis.addSymptom(LR.abdomenBloating);
tricuspidInsufficiencyDis.addSymptom(LR.dyspnea);
tricuspidInsufficiencyDis.addSymptom(LR.edemaPeripheral);
tricuspidInsufficiencyDis.addSymptom(LR.fatigue);
tricuspidInsufficiencyDis.addSymptom(LR.neckVeinsElevated);
tricuspidInsufficiencyDis.addSymptom(LR.urineRetention);
tricuspidInsufficiencyDis.addSymptom(LR.weakness);


// ------------- tricuspidStenosis  -------------
Disease tricuspidStenosisDis = new Disease(
    LR.tricuspidStenosis,
    L.tricuspidStenosisDescription,
    LR.cardioDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
tricuspidStenosisDis.setPrintName(L.tricuspidStenosisPrintName);
tricuspidStenosisDis.setSuperDisease(LR.valveDisorders);
tricuspidStenosisDis.addInternalCause(LR.rheumaticFever);
tricuspidStenosisDis.addCausesAbnormalCondition(LR.ascites);
tricuspidStenosisDis.addCausesAbnormalCondition(LR.hepatomegaly);
tricuspidStenosisDis.addReference("pp 1089-93");
tricuspidStenosisDis.addSymptom(LR.abdomenPainUpperRightSide);
tricuspidStenosisDis.addSymptom(LR.dyspnea);
tricuspidStenosisDis.addSymptom(LR.fatigue);
tricuspidStenosisDis.addSymptom(LR.edemaPeripheral);
tricuspidStenosisDis.addSymptom(LR.neckVeinsElevated);
tricuspidStenosisDis.addSymptom(LR.skinCold);
tricuspidStenosisDis.addSymptom(LR.syncope);


// ------------- myocardialInfarction  -------------
Disease myocardialInfarctionDis = new Disease(
    LR.myocardialInfarction,
    L.myocardialInfarctionDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
myocardialInfarctionDis.setPrintName(L.myocardialInfarctionPrintName);
myocardialInfarctionDis.setCode358(211);
myocardialInfarctionDis.setICD10code("I21");
myocardialInfarctionDis.addInternalCause(LR.electricShock);
myocardialInfarctionDis.addInternalCause(LR.hypertension);
myocardialInfarctionDis.addReference("pp 1101-6");
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
Treatment myocardialInfarctionTr1 = new Treatment("myocardialInfarctionTr1");
myocardialInfarctionTr1.addTreatmentAction(LR.oxygenTherapy);
myocardialInfarctionTr1.addTreatmentAction(LR.thrombolyticTherapy);
myocardialInfarctionTr1.addTreatmentAction(LR.angioplasty);
myocardialInfarctionTr1.addDrug(LR.nitroglycerin);
myocardialInfarctionDis.addTreatment("myocardialInfarctionTr1");


// ------------- myocarditis  -------------
Disease myocarditisDis = new Disease(
    LR.myocarditis,
    L.myocarditisDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.alcoholAbuse
);
myocarditisDis.setPrintName(L.myocarditisPrintName);
myocarditisDis.addExternalCause(LR.infection);
myocarditisDis.addExternalCause(LR.radiation);
myocarditisDis.setTemperature(100.5f);
myocarditisDis.setCode358(232);
myocarditisDis.setICD10code("I51");
myocarditisDis.addInternalCause(LR.rheumaticFever);
myocarditisDis.addInternalCause(LR.toxoplasmosisAcquiredAdvanced);
myocarditisDis.addReference("pp 1080-2");
myocarditisDis.addSymptom(LR.arrhythmia, L.myocarditis_arrhythmia, 0.2f);
myocarditisDis.addSymptom(LR.chestPain, L.myocarditis_chestPain, 0.2f);
myocarditisDis.addSymptom(LR.dyspnea);
myocarditisDis.addSymptom(LR.fatigue);
myocarditisDis.addSymptom(LR.neckVeinsElevated, L.myocarditis_neckVeinsElevated, 0.2f);
myocarditisDis.addSymptom(LR.palpitations);
myocarditisDis.addSymptom(LR.tachycardia, L.myocarditis_tachycardia, 0.2f);
Treatment myocarditisTr1 = new Treatment("myocarditisTr1");
myocarditisTr1.addTreatmentAction(LR.bedRest);
myocarditisTr1.addDrug(LR.antibiotics);
myocarditisDis.addTreatment("myocarditisTr1");


// ------------- pericarditis  -------------
Disease pericarditisDis = new Disease(
    LR.pericarditis,
    L.pericarditisDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.infection
);
pericarditisDis.setPrintName(L.pericarditisPrintName);
pericarditisDis.setMiscComments(L.pericarditisComment);
pericarditisDis.setCode358(222);
pericarditisDis.setICD10code("I30");
pericarditisDis.addInternalCause(LR.pneumonia);
pericarditisDis.addInternalCause(LR.tubularNecrosisAcute);
pericarditisDis.addInternalCause(LR.myocardialInfarction);
pericarditisDis.addInternalCause(LR.rheumaticFever);
pericarditisDis.addInternalCause(LR.rheumatoidArthritis3);
pericarditisDis.addCausingAbnormalCondition(LR.uremia);
pericarditisDis.addReference("pp 1084-7");
pericarditisDis.addSymptom(LR.armPitPain);
pericarditisDis.addSymptom(LR.breastBonePain);
pericarditisDis.addSymptom(LR.chestPain);
pericarditisDis.addSymptom(LR.neckPain);
pericarditisDis.addSymptom(LR.shoulderPain);
Treatment pericarditisTr1 = new Treatment("pericarditisTr1");
pericarditisTr1.addTreatmentAction(LR.bedRest);
pericarditisTr1.addDrug(LR.aspirin);
pericarditisDis.addTreatment("pericarditisTr1");


// ------------- rheumaticHeartDisease  -------------
Disease rheumaticHeartDiseaseDis = new Disease(
    LR.rheumaticHeartDisease,
    L.rheumaticHeartDiseaseDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
rheumaticHeartDiseaseDis.setPrintName(L.rheumaticHeartDiseasePrintName);
rheumaticHeartDiseaseDis.setCode358(201);
rheumaticHeartDiseaseDis.setICD10code("I05");
rheumaticHeartDiseaseDis.addInternalCause(LR.rheumaticFever);
rheumaticHeartDiseaseDis.addReference("pp 1087-9");
rheumaticHeartDiseaseDis.addSymptom(LR.coughHacking);
rheumaticHeartDiseaseDis.addSymptom(LR.dyspnea);
rheumaticHeartDiseaseDis.addSymptom(LR.edema);
rheumaticHeartDiseaseDis.addSymptom(LR.heartPain);
rheumaticHeartDiseaseDis.addSymptom(LR.tachycardia);
rheumaticHeartDiseaseDis.addSymptom(LR.tachypnea);
Treatment rheumaticHeartDiseaseTr1 = new Treatment("rheumaticHeartDiseaseTr1");
rheumaticHeartDiseaseTr1.addTreatmentAction(LR.bedRest);
rheumaticHeartDiseaseTr1.addDrug(LR.corticosteroids);
rheumaticHeartDiseaseDis.addTreatment("rheumaticHeartDiseaseTr1");


// ------------- ventricularAneurysm  -------------
Disease ventricularAneurysmDis = new Disease(
    LR.ventricularAneurysm,
    L.ventricularAneurysmDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
ventricularAneurysmDis.setPrintName(L.ventricularAneurysmPrintName);
ventricularAneurysmDis.setMiscComments(L.ventricularAneurysmComment);
ventricularAneurysmDis.addInternalCause(LR.myocardialInfarction);
ventricularAneurysmDis.addCausesAbnormalCondition(LR.systemicEmbolization);
ventricularAneurysmDis.addReference("pp 1122-3");
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
ventricularAneurysmDis.addTreatment("ventricularAneurysmTr1");


// ------------- ventricularSeptalDefect  -------------
Disease ventricularSeptalDefectDis = new Disease(
    LR.ventricularSeptalDefect,
    L.ventricularSeptalDefectDescription,
    LR.cardioDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
ventricularSeptalDefectDis.setPrintName(L.ventricularSeptalDefectPrintName);
ventricularSeptalDefectDis.setMiscComments(L.ventricularSeptalDefectComment);
ventricularSeptalDefectDis.addReference("pp 1068-70");
ventricularSeptalDefectDis.addSymptom(LR.cyanosis);
ventricularSeptalDefectDis.addSymptom(LR.diaphoresis);
ventricularSeptalDefectDis.addSymptom(LR.grunting);
ventricularSeptalDefectDis.addSymptom(LR.pulseRapid);
ventricularSeptalDefectDis.addSymptom(LR.tachypnea);
ventricularSeptalDefectDis.addSymptom(LR.skinDusky);
Treatment ventricularSeptalDefectTr1 = new Treatment("ventricularSeptalDefectTr1");
ventricularSeptalDefectTr1.addTreatmentAction(LR.surgery);
ventricularSeptalDefectDis.addTreatment("ventricularSeptalDefectTr1");
} // end of cardioDisorders





// ------------- earDisorders  -------------
static public void earDisorders() { 


// ------------- meniereDisease  -------------
Disease meniereDiseaseDis = new Disease(
    LR.meniereDisease,
    L.meniereDiseaseDescription,
    LR.earDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    60, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.earsSysSt,
    LR.none
);
meniereDiseaseDis.setPrintName(L.meniereDiseasePrintName);
meniereDiseaseDis.setMiscComments(L.meniereDiseaseComment);
meniereDiseaseDis.addReference("pp 1205-6");
meniereDiseaseDis.addSymptom(LR.hearingLoss, L.meniereDisease_hearingLoss, 1.0f);
meniereDiseaseDis.addSymptom(LR.tinnitus);
meniereDiseaseDis.addSymptom(LR.earBlockageFeeling);
meniereDiseaseDis.addSymptom(LR.vertigo);
meniereDiseaseDis.addSymptom(LR.giddiness);
meniereDiseaseDis.addSymptom(LR.nystagmus);
meniereDiseaseDis.addSymptom(LR.nausea);
meniereDiseaseDis.addSymptom(LR.sweating);
meniereDiseaseDis.addSymptom(LR.vomiting);
meniereDiseaseDis.addSymptom(LR.lossOfBalance, "", 0.4f);
Treatment meniereDiseaseTr1 = new Treatment("meniereDiseaseTr1");
meniereDiseaseTr1.addDrug(LR.atropine);
meniereDiseaseTr1.addDrug(LR.diazepam);
meniereDiseaseDis.addTreatment("meniereDiseaseTr1");
Treatment meniereDiseaseTr2 = new Treatment("meniereDiseaseTr2", LR.ifSevereAttack);
meniereDiseaseTr2.addDrug(LR.diphenhydramine);
meniereDiseaseTr2.addDrug(LR.epinephrine);
meniereDiseaseDis.addTreatment("meniereDiseaseTr2");
Treatment meniereDiseaseTr3 = new Treatment("meniereDiseaseTr3", LR.ifSevere);
meniereDiseaseTr3.addTreatmentAction(LR.surgery);
meniereDiseaseDis.addTreatment("meniereDiseaseTr3");


// ------------- otitisMedia  -------------
Disease otitisMediaDis = new Disease(
    LR.otitisMedia,
    L.otitisMediaDescription,
    LR.earDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.earsSysSt,
    LR.infection
);
otitisMediaDis.setPrintName(L.otitisMediaPrintName);
otitisMediaDis.addExternalCause(LR.pneumococciInfection);
otitisMediaDis.addExternalCause(LR.staphylococcusInfection);
otitisMediaDis.addExternalCause(LR.streptococcusInfection);
otitisMediaDis.addInternalCause(LR.croup);
otitisMediaDis.addInternalCause(LR.pharyngitisStreptococcal);
otitisMediaDis.addCausesDisease(LR.meningitis);
otitisMediaDis.addReference("pp 1199-1202");
otitisMediaDis.addSymptom(LR.cough);
otitisMediaDis.addSymptom(LR.dizziness);
otitisMediaDis.addSymptom(LR.earache);
otitisMediaDis.addSymptom(LR.hearingLoss);
otitisMediaDis.addSymptom(LR.nausea);
otitisMediaDis.addSymptom(LR.sneezing);
otitisMediaDis.addSymptom(LR.tinnitus);
otitisMediaDis.addSymptom(LR.vomiting);
Treatment otitisMediaTr1 = new Treatment("otitisMediaTr1");
otitisMediaTr1.addDrug(LR.antibiotics);
otitisMediaTr1.addDrug(LR.ampicillin);
otitisMediaTr1.addDrug(LR.amoxicillin);
otitisMediaDis.addTreatment("otitisMediaTr1");
} // end of earDisorders





// ------------- endocrineDisorders  -------------
static public void endocrineDisorders() { 


// ------------- adrenalCrisis  -------------
Disease adrenalCrisisDis = new Disease(
    LR.adrenalCrisis,
    L.adrenalCrisisDescription,
    LR.endocrineDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.adrenalSysSt,
    LR.none
);
adrenalCrisisDis.setPrintName(L.adrenalCrisisPrintName);
adrenalCrisisDis.setMiscComments(L.adrenalCrisisComment);
adrenalCrisisDis.setTemperature(103.0f);
adrenalCrisisDis.addCausesDisease(LR.renalInfarction);
adrenalCrisisDis.addCausesAbnormalCondition(LR.vascularCollapse);
adrenalCrisisDis.addCausesAbnormalCondition(LR.death);
adrenalCrisisDis.addReference("pp 835-8");
adrenalCrisisDis.addSymptom(LR.coma, L.adrenalCrisis_coma, 0.1f);
adrenalCrisisDis.addSymptom(LR.fatigue);
adrenalCrisisDis.addSymptom(LR.hypotension);
adrenalCrisisDis.addSymptom(LR.nausea);
adrenalCrisisDis.addSymptom(LR.vomiting);
adrenalCrisisDis.addSymptom(LR.weakness);
adrenalCrisisDis.addSymptom(LR.dehydration);
adrenalCrisisDis.addSymptom(LR.hypothermia, L.adrenalCrisis_hypothermia, 0.3f);
Treatment adrenalCrisisTr1 = new Treatment("adrenalCrisisTr1");
adrenalCrisisTr1.addTreatmentAction(LR.IVFluids);
adrenalCrisisTr1.addDrug(LR.corticosteroids);
adrenalCrisisTr1.addDrug(LR.insulin);
adrenalCrisisTr1.addDrug(LR.potassium);
adrenalCrisisDis.addTreatment("adrenalCrisisTr1");


// ------------- adrenogenitalSyndrome  -------------
Disease adrenogenitalSyndromeDis = new Disease(
    LR.adrenogenitalSyndrome,
    L.adrenogenitalSyndromeDescription,
    LR.endocrineDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.endocrineSysSt,
    LR.none
);
adrenogenitalSyndromeDis.setPrintName(L.adrenogenitalSyndromePrintName);
adrenogenitalSyndromeDis.addReference("pp 843-6");


// ------------- congenitalAdrenalHyperplasia  -------------
Disease congenitalAdrenalHyperplasiaDis = new Disease(
    LR.congenitalAdrenalHyperplasia,
    L.congenitalAdrenalHyperplasiaDescription,
    LR.endocrineDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    20, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.endocrineSysSt,
    LR.none
);
congenitalAdrenalHyperplasiaDis.setPrintName(L.congenitalAdrenalHyperplasiaPrintName);
congenitalAdrenalHyperplasiaDis.setSuperDisease(LR.adrenogenitalSyndrome);
congenitalAdrenalHyperplasiaDis.setGenetic("1parent");
congenitalAdrenalHyperplasiaDis.setParentDisease(LR.congenitalAdrenalHyperplasia);
congenitalAdrenalHyperplasiaDis.addReference("pp 843-6");
Treatment congenitalAdrenalHyperplasiaTr1 = new Treatment("congenitalAdrenalHyperplasiaTr1");
congenitalAdrenalHyperplasiaTr1.addDrug(LR.hydrocortisone);
congenitalAdrenalHyperplasiaTr1.addDrug(LR.cortisone);
congenitalAdrenalHyperplasiaDis.addTreatment("congenitalAdrenalHyperplasiaTr1");


// ------------- congenitalAdrenalHyperplasiaFemale  -------------
Disease congenitalAdrenalHyperplasiaFemaleDis = new Disease(
    LR.congenitalAdrenalHyperplasiaFemale,
    L.congenitalAdrenalHyperplasiaFemaleDescription,
    LR.endocrineDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    20, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.endocrineSysSt,
    LR.none
);
congenitalAdrenalHyperplasiaFemaleDis.setPrintName(L.congenitalAdrenalHyperplasiaFemalePrintName);
congenitalAdrenalHyperplasiaFemaleDis.setSuperDisease(LR.congenitalAdrenalHyperplasia);
congenitalAdrenalHyperplasiaFemaleDis.setGenetic("1parent");
congenitalAdrenalHyperplasiaFemaleDis.setParentDisease(LR.congenitalAdrenalHyperplasia);
congenitalAdrenalHyperplasiaFemaleDis.addReference("pp 843-6");
congenitalAdrenalHyperplasiaFemaleDis.addSymptom(LR.acne);
congenitalAdrenalHyperplasiaFemaleDis.addSymptom(LR.voiceDeepened);
congenitalAdrenalHyperplasiaFemaleDis.addSymptom(LR.faceHair);
congenitalAdrenalHyperplasiaFemaleDis.addSymptom(LR.pubisHairEarly);


// ------------- congenitalAdrenalHyperplasiaMale  -------------
Disease congenitalAdrenalHyperplasiaMaleDis = new Disease(
    LR.congenitalAdrenalHyperplasiaMale,
    L.congenitalAdrenalHyperplasiaMaleDescription,
    LR.endocrineDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    20, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.endocrineSysSt,
    LR.none
);
congenitalAdrenalHyperplasiaMaleDis.setPrintName(L.congenitalAdrenalHyperplasiaMalePrintName);
congenitalAdrenalHyperplasiaMaleDis.setSuperDisease(LR.congenitalAdrenalHyperplasia);
congenitalAdrenalHyperplasiaMaleDis.setGenetic("1parent");
congenitalAdrenalHyperplasiaMaleDis.setParentDisease(LR.congenitalAdrenalHyperplasia);
congenitalAdrenalHyperplasiaMaleDis.addReference("pp 843-6");
congenitalAdrenalHyperplasiaMaleDis.addSymptom(LR.voiceDeepened);
congenitalAdrenalHyperplasiaMaleDis.addSymptom(LR.penisEnlarged);
congenitalAdrenalHyperplasiaMaleDis.addSymptom(LR.erectionFrequent);


// ------------- saltLosingCongenitalAdrenalHyperplasia  -------------
Disease saltLosingCongenitalAdrenalHyperplasiaDis = new Disease(
    LR.saltLosingCongenitalAdrenalHyperplasia,
    L.saltLosingCongenitalAdrenalHyperplasiaDescription,
    LR.endocrineDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    1, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.endocrineSysSt,
    LR.none
);
saltLosingCongenitalAdrenalHyperplasiaDis.setPrintName(L.saltLosingCongenitalAdrenalHyperplasiaPrintName);
saltLosingCongenitalAdrenalHyperplasiaDis.setSuperDisease(LR.adrenogenitalSyndrome);
saltLosingCongenitalAdrenalHyperplasiaDis.setGenetic("1parent");
saltLosingCongenitalAdrenalHyperplasiaDis.setParentDisease(LR.congenitalAdrenalHyperplasia);
saltLosingCongenitalAdrenalHyperplasiaDis.addReference("pp 843-6");
saltLosingCongenitalAdrenalHyperplasiaDis.addSymptom(LR.apathy);
saltLosingCongenitalAdrenalHyperplasiaDis.addSymptom(LR.appetiteLoss);
saltLosingCongenitalAdrenalHyperplasiaDis.addSymptom(LR.dehydration);
saltLosingCongenitalAdrenalHyperplasiaDis.addSymptom(LR.diarrhea);
saltLosingCongenitalAdrenalHyperplasiaDis.addSymptom(LR.vomiting);
Treatment saltLosingCongenitalAdrenalHyperplasiaTr1 = new Treatment("saltLosingCongenitalAdrenalHyperplasiaTr1");
saltLosingCongenitalAdrenalHyperplasiaTr1.addTreatmentAction(LR.sodiumChloride);
saltLosingCongenitalAdrenalHyperplasiaTr1.addTreatmentAction(LR.glucose);
saltLosingCongenitalAdrenalHyperplasiaDis.addTreatment("saltLosingCongenitalAdrenalHyperplasiaTr1");


// ------------- cushingSyndrome  -------------
Disease cushingSyndromeDis = new Disease(
    LR.cushingSyndrome,
    L.cushingSyndromeDescription,
    LR.endocrineDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.adrenalSysSt,
    LR.none
);
cushingSyndromeDis.setPrintName(L.cushingSyndromePrintName);
cushingSyndromeDis.addCausingAbnormalCondition(LR.leftVentricularDysfunction);
cushingSyndromeDis.addCausesDisease(LR.hypertension);
cushingSyndromeDis.addCausesDisease(LR.diabetesMellitusSuper);
cushingSyndromeDis.addCausesAbnormalCondition(LR.glycosuria);
cushingSyndromeDis.addCausesAbnormalCondition(LR.hypercalciuria);
cushingSyndromeDis.addCausesAbnormalCondition(LR.hyperglycemia);
cushingSyndromeDis.addReference("pp 838-41");
cushingSyndromeDis.addSymptom(LR.acne, "", 0.3f);
cushingSyndromeDis.addSymptom(LR.buffaloHump);
cushingSyndromeDis.addSymptom(LR.ecchymoses);
cushingSyndromeDis.addSymptom(LR.hirsutism, "", 0.3f);
cushingSyndromeDis.addSymptom(LR.irritability);
cushingSyndromeDis.addSymptom(LR.moonFace);
cushingSyndromeDis.addSymptom(LR.muscleWeakness);
cushingSyndromeDis.addSymptom(LR.petechiae);
cushingSyndromeDis.addSymptom(LR.sleepDisturbed);
cushingSyndromeDis.addSymptom(LR.striaePurplish);
Treatment cushingSyndromeTr1 = new Treatment("cushingSyndromeTr1");
cushingSyndromeTr1.addTreatmentAction(LR.radiationTherapy);
cushingSyndromeTr1.addTreatmentAction(LR.surgery);
cushingSyndromeTr1.addDrug(LR.aminoglutethimide);
cushingSyndromeTr1.addDrug(LR.ketoconazole);
cushingSyndromeDis.addTreatment("cushingSyndromeTr1");


// ------------- diabetes  -------------
Disease diabetesDis = new Disease(
    LR.diabetes,
    L.diabetesDescription,
    LR.endocrineDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.endocrineSysSt,
    LR.none
);
diabetesDis.setPrintName(L.diabetesPrintName);
diabetesDis.addReference("Webster");
diabetesDis.addSymptom(LR.polydipsia);
diabetesDis.addSymptom(LR.polyuria);


// ------------- diabetesInsidipus  -------------
Disease diabetesInsidipusDis = new Disease(
    LR.diabetesInsidipus,
    L.diabetesInsidipusDescription,
    LR.endocrineDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.endocrineSysSt,
    LR.none
);
diabetesInsidipusDis.setPrintName(L.diabetesInsidipusPrintName);
diabetesInsidipusDis.setSuperDisease(LR.diabetes);
diabetesInsidipusDis.addInternalCause(LR.sarcoidosisCNS);
diabetesInsidipusDis.addReference("pp 818-20");
diabetesInsidipusDis.addSymptom(LR.constipation, "", 0.4f);
diabetesInsidipusDis.addSymptom(LR.dehydration, "", 0.4f);
diabetesInsidipusDis.addSymptom(LR.dizziness, "", 0.4f);
diabetesInsidipusDis.addSymptom(LR.fatigue, L.diabetesInsidipus_fatigue, 0.1f);
diabetesInsidipusDis.addSymptom(LR.hypotension, "", 0.4f);
diabetesInsidipusDis.addSymptom(LR.mucousMembranesDry, "", 0.4f);
diabetesInsidipusDis.addSymptom(LR.muscleWeakness, "", 0.4f);
diabetesInsidipusDis.addSymptom(LR.nocturia, "", 0.3f);
diabetesInsidipusDis.addSymptom(LR.thirstExcessive);
Treatment diabetesInsidipusTr1 = new Treatment("diabetesInsidipusTr1");
diabetesInsidipusTr1.addTreatmentAction(LR.fluidIncrease);
diabetesInsidipusTr1.addDrug(LR.vasopressin);
diabetesInsidipusDis.addTreatment("diabetesInsidipusTr1");


// ------------- diabetesMellitusSuper  -------------
Disease diabetesMellitusSuperDis = new Disease(
    LR.diabetesMellitusSuper,
    L.diabetesMellitusSuperDescription,
    LR.endocrineDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.endocrineSysSt,
    LR.none
);
diabetesMellitusSuperDis.setPrintName(L.diabetesMellitusSuperPrintName);
diabetesMellitusSuperDis.setSuperDisease(LR.diabetes);
diabetesMellitusSuperDis.setCode358(159);
diabetesMellitusSuperDis.setICD10code("E10");
diabetesMellitusSuperDis.addInternalCause(LR.cushingSyndrome);
diabetesMellitusSuperDis.addCausesAbnormalCondition(LR.hyperglycemia);
diabetesMellitusSuperDis.addReference("pp 849-53");
diabetesMellitusSuperDis.addSymptom(LR.bingeEating);
diabetesMellitusSuperDis.addSymptom(LR.dehydration);
diabetesMellitusSuperDis.addSymptom(LR.fatigue);
diabetesMellitusSuperDis.addSymptom(LR.mucousMembranesDry);
diabetesMellitusSuperDis.addSymptom(LR.skinElasticityLoss);
Treatment diabetesMellitusSuperTr1 = new Treatment("diabetesMellitusSuperTr1");
diabetesMellitusSuperTr1.addTreatmentAction(LR.diet);
diabetesMellitusSuperTr1.addTreatmentAction(LR.exercise);
diabetesMellitusSuperTr1.addDrug(LR.insulin);
diabetesMellitusSuperDis.addTreatment("diabetesMellitusSuperTr1");


// ------------- diabetesMellitus  -------------
Disease diabetesMellitusDis = new Disease(
    LR.diabetesMellitus,
    L.diabetesMellitusDescription,
    LR.endocrineDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.endocrineSysSt,
    LR.none
);
diabetesMellitusDis.setPrintName(L.diabetesMellitusPrintName);
diabetesMellitusDis.setSuperDisease(LR.diabetesMellitusSuper);
diabetesMellitusDis.setCode358(159);
diabetesMellitusDis.setICD10code("E10");
diabetesMellitusDis.addInternalCause(LR.obesity);
diabetesMellitusDis.addCausesDisease(LR.diabetesMellitusAdvanced);
diabetesMellitusDis.addReference("pp 849-53");
diabetesMellitusDis.addSymptom(LR.nocturia);
diabetesMellitusDis.addSymptom(LR.weightLoss);


// ------------- diabetesMellitus2  -------------
Disease diabetesMellitus2Dis = new Disease(
    LR.diabetesMellitus2,
    L.diabetesMellitus2Description,
    LR.endocrineDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.endocrineSysSt,
    LR.none
);
diabetesMellitus2Dis.setPrintName(L.diabetesMellitus2PrintName);
diabetesMellitus2Dis.setSuperDisease(LR.diabetesMellitusSuper);
diabetesMellitus2Dis.setCode358(159);
diabetesMellitus2Dis.setICD10code("E10");
diabetesMellitus2Dis.addCausesDisease(LR.diabetesMellitusAdvanced);
diabetesMellitus2Dis.addReference("pp 849-5");
diabetesMellitus2Dis.addSymptom(LR.nocturia);
diabetesMellitus2Dis.addSymptom(LR.overweight);


// ------------- diabetesMellitusAdvanced  -------------
Disease diabetesMellitusAdvancedDis = new Disease(
    LR.diabetesMellitusAdvanced,
    L.diabetesMellitusAdvancedDescription,
    LR.endocrineDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    17, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.endocrineSysSt,
    LR.none
);
diabetesMellitusAdvancedDis.setPrintName(L.diabetesMellitusAdvancedPrintName);
diabetesMellitusAdvancedDis.setSuperDisease(LR.diabetesMellitusSuper);
diabetesMellitusAdvancedDis.setCode358(159);
diabetesMellitusAdvancedDis.setICD10code("E10");
diabetesMellitusAdvancedDis.addInternalCause(LR.diabetesMellitus);
diabetesMellitusAdvancedDis.addInternalCause(LR.diabetesMellitus2);
diabetesMellitusAdvancedDis.addCausesDisease(LR.vulvovaginitis);
diabetesMellitusAdvancedDis.addCausesDisease(LR.vascularRetinopathy);
diabetesMellitusAdvancedDis.addCausesDisease(LR.nephroticSyndrome);
diabetesMellitusAdvancedDis.addCausesDisease(LR.urinaryTractInfection);
diabetesMellitusAdvancedDis.addCausesAbnormalCondition(LR.atherosclerosis);
diabetesMellitusAdvancedDis.addReference("pp 849-53");
diabetesMellitusAdvancedDis.addSymptom(LR.diarrheaNocturnal);
diabetesMellitusAdvancedDis.addSymptom(LR.feetNumbness, "", 0.4f);
diabetesMellitusAdvancedDis.addSymptom(LR.feetPain, "", 0.4f);
diabetesMellitusAdvancedDis.addSymptom(LR.gastroparesis);
diabetesMellitusAdvancedDis.addSymptom(LR.handNumbness, "", 0.4f);
diabetesMellitusAdvancedDis.addSymptom(LR.handPain, "", 0.4f);
diabetesMellitusAdvancedDis.addSymptom(LR.skinInfection);


// ------------- hyperaldosteronism  -------------
Disease hyperaldosteronismDis = new Disease(
    LR.hyperaldosteronism,
    L.hyperaldosteronismDescription,
    LR.endocrineDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    50, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.adrenalSysSt,
    LR.none
);
hyperaldosteronismDis.setPrintName(L.hyperaldosteronismPrintName);
hyperaldosteronismDis.addCausesDisease(LR.hypertension);
hyperaldosteronismDis.addReference("pp 841-3");
hyperaldosteronismDis.addSymptom(LR.fatigue);
hyperaldosteronismDis.addSymptom(LR.headache);
hyperaldosteronismDis.addSymptom(LR.paresthesia);
hyperaldosteronismDis.addSymptom(LR.muscleWeakness);
hyperaldosteronismDis.addSymptom(LR.paralysisTransient);
hyperaldosteronismDis.addSymptom(LR.tetany, "", 0.6f);
hyperaldosteronismDis.addSymptom(LR.ocularDisturbance, "", 0.4f);
Treatment hyperaldosteronismTr1 = new Treatment("hyperaldosteronismTr1");
hyperaldosteronismTr1.addTreatmentAction(LR.sodiumRestriction);
hyperaldosteronismDis.addTreatment("hyperaldosteronismTr1");


// ------------- hyperthyroidism  -------------
Disease hyperthyroidismDis = new Disease(
    LR.hyperthyroidism,
    L.hyperthyroidismDescription,
    LR.endocrineDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.thyroidSysSt,
    LR.none
);
hyperthyroidismDis.setPrintName(L.hyperthyroidismPrintName);
hyperthyroidismDis.setMiscComments(L.hyperthyroidismComment);
hyperthyroidismDis.setGenetic("1parent");
hyperthyroidismDis.setParentDisease(LR.hyperthyroidism);
hyperthyroidismDis.addReference("pp 826-30");
hyperthyroidismDis.addSymptom(LR.goiter);
hyperthyroidismDis.addSymptom(LR.exophthalmos, "", 0.8f);
hyperthyroidismDis.addSymptom(LR.diarrhea);
hyperthyroidismDis.addSymptom(LR.nervousness);
hyperthyroidismDis.addSymptom(LR.palpitations);
hyperthyroidismDis.addSymptom(LR.sweating);
hyperthyroidismDis.addSymptom(LR.tremors);
hyperthyroidismDis.addSymptom(LR.weightLoss);
Treatment hyperthyroidismTr1 = new Treatment("hyperthyroidismTr1");
hyperthyroidismTr1.addTreatmentAction(LR.surgery);
hyperthyroidismTr1.addTreatmentAction(LR.radioactiveIodine);
hyperthyroidismTr1.addDrug(LR.antithyroid);
hyperthyroidismDis.addTreatment("hyperthyroidismTr1");


// ------------- hypothyroidismSuper  -------------
Disease hypothyroidismSuperDis = new Disease(
    LR.hypothyroidismSuper,
    L.hypothyroidismSuperDescription,
    LR.endocrineDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    16, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.thyroidSysSt,
    LR.none
);
hypothyroidismSuperDis.setPrintName(L.hypothyroidismSuperPrintName);
hypothyroidismSuperDis.setMiscComments(L.hypothyroidismSuperComment);
hypothyroidismSuperDis.addReference("pp 820-2");
hypothyroidismSuperDis.addSymptom(LR.coldIntolerance);
hypothyroidismSuperDis.addSymptom(LR.constipation);
hypothyroidismSuperDis.addSymptom(LR.eyelidDroop);
hypothyroidismSuperDis.addSymptom(LR.faceEdema);
hypothyroidismSuperDis.addSymptom(LR.fatigue);
hypothyroidismSuperDis.addSymptom(LR.forgetfulness);
hypothyroidismSuperDis.addSymptom(LR.hairLoss);
hypothyroidismSuperDis.addSymptom(LR.hoarseness);
hypothyroidismSuperDis.addSymptom(LR.mentalInstability);
hypothyroidismSuperDis.addSymptom(LR.nailBrittle);
hypothyroidismSuperDis.addSymptom(LR.skinDry);
hypothyroidismSuperDis.addSymptom(LR.skinElasticityLoss);
hypothyroidismSuperDis.addSymptom(LR.weightGain);
Treatment hypothyroidismSuperTr1 = new Treatment("hypothyroidismSuperTr1");
hypothyroidismSuperTr1.addDrug(LR.levothyroxine);
hypothyroidismSuperDis.addTreatment("hypothyroidismSuperTr1");


// ------------- hypothyroidism  -------------
Disease hypothyroidismDis = new Disease(
    LR.hypothyroidism,
    L.hypothyroidismDescription,
    LR.endocrineDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    16, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.thyroidSysSt,
    LR.none
);
hypothyroidismDis.setPrintName(L.hypothyroidismPrintName);
hypothyroidismDis.setSuperDisease(LR.hypothyroidismSuper);
hypothyroidismDis.setMiscComments(L.hypothyroidismComment);
hypothyroidismDis.addCausesDisease(LR.hypothyroidismCardio);
hypothyroidismDis.addReference("pp 820-2");


// ------------- hypothyroidismCardio  -------------
Disease hypothyroidismCardioDis = new Disease(
    LR.hypothyroidismCardio,
    L.hypothyroidismCardioDescription,
    LR.endocrineDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    16, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.thyroidSysSt,
    LR.none
);
hypothyroidismCardioDis.setPrintName(L.hypothyroidismCardioPrintName);
hypothyroidismCardioDis.setSuperDisease(LR.hypothyroidismSuper);
hypothyroidismCardioDis.setMiscComments(L.hypothyroidismCardioComment);
hypothyroidismCardioDis.addInternalCause(LR.hypothyroidism);
hypothyroidismCardioDis.addReference("pp 820-2");
hypothyroidismCardioDis.addSymptom(LR.coldIntolerance);
hypothyroidismCardioDis.addSymptom(LR.constipation);
hypothyroidismCardioDis.addSymptom(LR.eyelidDroop);
hypothyroidismCardioDis.addSymptom(LR.faceEdema);
hypothyroidismCardioDis.addSymptom(LR.fatigue);
hypothyroidismCardioDis.addSymptom(LR.forgetfulness);
hypothyroidismCardioDis.addSymptom(LR.hairLoss);
hypothyroidismCardioDis.addSymptom(LR.hoarseness);
hypothyroidismCardioDis.addSymptom(LR.mentalInstability);
hypothyroidismCardioDis.addSymptom(LR.nailBrittle);
hypothyroidismCardioDis.addSymptom(LR.skinDry);
hypothyroidismCardioDis.addSymptom(LR.skinElasticityLoss);
hypothyroidismCardioDis.addSymptom(LR.weightGain);
hypothyroidismCardioDis.addSymptom(LR.abdomenDistension);
hypothyroidismCardioDis.addSymptom(LR.anorexia);
hypothyroidismCardioDis.addSymptom(LR.ataxia);
hypothyroidismCardioDis.addSymptom(LR.libidoLoss);
hypothyroidismCardioDis.addSymptom(LR.pulseWeak);


// ------------- pheochromocytoma  -------------
Disease pheochromocytomaDis = new Disease(
    LR.pheochromocytoma,
    L.pheochromocytomaDescription,
    LR.endocrineDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    40, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.adrenalSysSt,
    LR.none
);
pheochromocytomaDis.setPrintName(L.pheochromocytomaPrintName);
pheochromocytomaDis.setGenetic("1parent");
pheochromocytomaDis.setParentDisease(LR.pheochromocytoma);
pheochromocytomaDis.addCausesDisease(LR.hypertension);
pheochromocytomaDis.addCausesAbnormalCondition(LR.hyperglycemia);
pheochromocytomaDis.addReference("pp 846-8");
pheochromocytomaDis.addSymptom(LR.abdomenPain);
pheochromocytomaDis.addSymptom(LR.diaphoresis);
pheochromocytomaDis.addSymptom(LR.doomFeeling);
pheochromocytomaDis.addSymptom(LR.flushing);
pheochromocytomaDis.addSymptom(LR.headache);
pheochromocytomaDis.addSymptom(LR.nausea);
pheochromocytomaDis.addSymptom(LR.nervousness);
pheochromocytomaDis.addSymptom(LR.pallor);
pheochromocytomaDis.addSymptom(LR.palpitations);
pheochromocytomaDis.addSymptom(LR.tachycardia);
pheochromocytomaDis.addSymptom(LR.tachypnea);
pheochromocytomaDis.addSymptom(LR.trembling);
pheochromocytomaDis.addSymptom(LR.vomiting);
Treatment pheochromocytomaTr1 = new Treatment("pheochromocytomaTr1");
pheochromocytomaTr1.addTreatmentAction(LR.surgery);
pheochromocytomaDis.addTreatment("pheochromocytomaTr1");
} // end of endocrineDisorders





// ------------- eyeDisorders  -------------
static public void eyeDisorders() { 


// ------------- conjunctivitis  -------------
Disease conjunctivitisDis = new Disease(
    LR.conjunctivitis,
    L.conjunctivitisDescription,
    LR.eyeDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.eyesSysSt,
    LR.infection
);
conjunctivitisDis.setPrintName(L.conjunctivitisPrintName);
conjunctivitisDis.setMiscComments(L.conjunctivitisComment);
conjunctivitisDis.addInternalCause(LR.flu);
conjunctivitisDis.addInternalCause(LR.westNileVirus);
conjunctivitisDis.addInternalCause(LR.whoopingCoughCatarrh);
conjunctivitisDis.addReference("pp 1166-7");
conjunctivitisDis.addSymptom(LR.eyelidHyperemia);
conjunctivitisDis.addSymptom(LR.eyePain, "", 0.3f);
conjunctivitisDis.addSymptom(LR.photophobia, "", 0.2f);
conjunctivitisDis.addSymptom(LR.tearing, "", 0.3f);
Treatment conjunctivitisTr1 = new Treatment("conjunctivitisTr1", LR.ifBacterialInfection);
conjunctivitisTr1.addDrug(LR.antibiotics);
conjunctivitisTr1.addDrug(LR.sulfonamide);
conjunctivitisDis.addTreatment("conjunctivitisTr1");


// ------------- vascularRetinopathy  -------------
Disease vascularRetinopathyDis = new Disease(
    LR.vascularRetinopathy,
    L.vascularRetinopathyDescription,
    LR.eyeDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.eyesSysSt,
    LR.none
);
vascularRetinopathyDis.setPrintName(L.vascularRetinopathyPrintName);
vascularRetinopathyDis.setMiscComments(L.vascularRetinopathyComment);
vascularRetinopathyDis.addInternalCause(LR.diabetesMellitusAdvanced);
vascularRetinopathyDis.addCausesAbnormalCondition(LR.blindness);
vascularRetinopathyDis.addReference("pp 1175-8");
vascularRetinopathyDis.addSymptom(LR.visionDefect);
vascularRetinopathyDis.addSymptom(LR.visionLoss);


// ------------- glaucoma  -------------
Disease glaucomaDis = new Disease(
    LR.glaucoma,
    L.glaucomaDescription,
    LR.eyeDisorders,
    LR.none, // genderSpecificity
    LR.africanAmerican, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.eyesSysSt,
    LR.none
);
glaucomaDis.setPrintName(L.glaucomaPrintName);
glaucomaDis.setMiscComments(L.glaucomaComment);
glaucomaDis.setWebResource("http://search.yahoo.com/bin/search?p=glaucoma");
glaucomaDis.addInternalCause(LR.sarcoidosisOphthalmic);
glaucomaDis.addReference("pp 1186-9");


// ------------- glaucomaChronic  -------------
Disease glaucomaChronicDis = new Disease(
    LR.glaucomaChronic,
    L.glaucomaChronicDescription,
    LR.eyeDisorders,
    LR.none, // genderSpecificity
    LR.africanAmerican, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.eyesSysSt,
    LR.none
);
glaucomaChronicDis.setPrintName(L.glaucomaChronicPrintName);
glaucomaChronicDis.setSuperDisease(LR.glaucoma);
glaucomaChronicDis.setWebResource("http://search.yahoo.com/bin/search?p=glaucoma");
glaucomaChronicDis.setGenetic("1parent");
glaucomaChronicDis.setParentDisease(LR.glaucoma);
glaucomaChronicDis.addInternalCause(LR.diabetes);
glaucomaChronicDis.addInternalCause(LR.hypertension);
glaucomaChronicDis.addReference("pp 1186-9");
glaucomaChronicDis.addSymptom(LR.eyePainMild);
glaucomaChronicDis.addSymptom(LR.visionPeripheralLoss);
glaucomaChronicDis.addSymptom(LR.visionNightLoss);
glaucomaChronicDis.addSymptom(LR.seeingHalosAroundLights);
Treatment glaucomaChronicTr1 = new Treatment("glaucomaChronicTr1");
glaucomaChronicTr1.addDrug(LR.betaBlocker);
glaucomaChronicTr1.addDrug(LR.diuretics);
glaucomaChronicDis.addTreatment("glaucomaChronicTr1");


// ------------- glaucomaAcute  -------------
Disease glaucomaAcuteDis = new Disease(
    LR.glaucomaAcute,
    L.glaucomaAcuteDescription,
    LR.eyeDisorders,
    LR.none, // genderSpecificity
    LR.africanAmerican, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.eyesSysSt,
    LR.none
);
glaucomaAcuteDis.setPrintName(L.glaucomaAcutePrintName);
glaucomaAcuteDis.setSuperDisease(LR.glaucoma);
glaucomaAcuteDis.setMiscComments(L.glaucomaAcuteComment);
glaucomaAcuteDis.setWebResource("http://search.yahoo.com/bin/search?p=glaucoma");
glaucomaAcuteDis.setGenetic("1parent");
glaucomaAcuteDis.setParentDisease(LR.glaucoma);
glaucomaAcuteDis.addReference("pp 1186-9");
glaucomaAcuteDis.addSymptom(LR.eyePainMild);
glaucomaAcuteDis.addSymptom(LR.seeingHalosAroundLights);
glaucomaAcuteDis.addSymptom(LR.photophobia);
glaucomaAcuteDis.addSymptom(LR.pupilDilation);
glaucomaAcuteDis.addSymptom(LR.corneaCloudy);
glaucomaAcuteDis.addSymptom(LR.eyePressure);
glaucomaAcuteDis.addSymptom(LR.visionBlurred);
glaucomaAcuteDis.addSymptom(LR.nausea, L.glaucomaAcute_nausea, 0.1f);
glaucomaAcuteDis.addSymptom(LR.vomiting, L.glaucomaAcute_vomiting, 0.1f);
Treatment glaucomaAcuteTr1 = new Treatment("glaucomaAcuteTr1");
glaucomaAcuteTr1.addTreatmentAction(LR.surgery);
glaucomaAcuteDis.addTreatment("glaucomaAcuteTr1");


// ------------- keratitis  -------------
Disease keratitisDis = new Disease(
    LR.keratitis,
    L.keratitisDescription,
    LR.eyeDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.eyesSysSt,
    LR.bacterialInfection
);
keratitisDis.setPrintName(L.keratitisPrintName);
keratitisDis.addExternalCause(LR.herpesSimplexVirus);
keratitisDis.addReference("pp 1169-70");
keratitisDis.addSymptom(LR.corneaOpaque);
keratitisDis.addSymptom(LR.eyePainMild);
keratitisDis.addSymptom(LR.photophobia);
keratitisDis.addSymptom(LR.tearing);
keratitisDis.addSymptom(LR.visionBlurred, L.keratitis_visionBlurred, 0.1f);
Treatment keratitisTr1 = new Treatment("keratitisTr1");
keratitisTr1.addDrug(LR.trifluridineEyeDrops);
keratitisTr1.addDrug(LR.vidarabineOintment);
keratitisDis.addTreatment("keratitisTr1");


// ------------- maculaDegeneration  -------------
Disease maculaDegenerationDis = new Disease(
    LR.maculaDegeneration,
    L.maculaDegenerationDescription,
    LR.eyeDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.eyesSysSt,
    LR.none
);
maculaDegenerationDis.setPrintName(L.maculaDegenerationPrintName);
maculaDegenerationDis.addReference("pp 1178-9");
maculaDegenerationDis.addSymptom(LR.visionBlurred);
maculaDegenerationDis.addSymptom(LR.visionDefect);
Treatment maculaDegenerationTr1 = new Treatment("maculaDegenerationTr1");
maculaDegenerationTr1.addTreatmentAction(LR.laserPhotocoagulation);
maculaDegenerationDis.addTreatment("maculaDegenerationTr1");


// ------------- retinochoroiditis  -------------
Disease retinochoroiditisDis = new Disease(
    LR.retinochoroiditis,
    L.retinochoroiditisDescription,
    LR.eyeDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.eyesSysSt,
    LR.none
);
retinochoroiditisDis.setPrintName(L.retinochoroiditisPrintName);
retinochoroiditisDis.setMiscComments(L.retinochoroiditisComment);
retinochoroiditisDis.addInternalCause(LR.toxoplasmosisCongenital);
retinochoroiditisDis.addReference("pp 1294-5");
retinochoroiditisDis.addSymptom(LR.retinaInflammation);
Treatment retinochoroiditisTr1 = new Treatment("retinochoroiditisTr1");
retinochoroiditisTr1.addDrug(LR.steroids);
retinochoroiditisDis.addTreatment("retinochoroiditisTr1");


// ------------- trachoma  -------------
Disease trachomaDis = new Disease(
    LR.trachoma,
    L.trachomaDescription,
    LR.eyeDisorders,
    LR.none, // genderSpecificity
    LR.indianAmerican, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.eyesSysSt,
    LR.chlamydialInfection
);
trachomaDis.setPrintName(L.trachomaPrintName);
trachomaDis.addReference("pp 1167-9");
trachomaDis.addSymptom(LR.eyePain);
trachomaDis.addSymptom(LR.eyelidRed);
trachomaDis.addSymptom(LR.eyelidSwollen);
trachomaDis.addSymptom(LR.photophobia);
trachomaDis.addSymptom(LR.tearing);
Treatment trachomaTr1 = new Treatment("trachomaTr1");
trachomaTr1.addDrug(LR.antibiotics);
trachomaTr1.addDrug(LR.erythromycin);
trachomaTr1.addDrug(LR.sulfonamide);
trachomaTr1.addDrug(LR.tetracycline);
trachomaDis.addTreatment("trachomaTr1");


// ------------- uveitis  -------------
Disease uveitisDis = new Disease(
    LR.uveitis,
    L.uveitisDescription,
    LR.eyeDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.eyesSysSt,
    LR.allergens
);
uveitisDis.setPrintName(L.uveitisPrintName);
uveitisDis.addExternalCause(LR.infection);
uveitisDis.addExternalCause(LR.trauma);
uveitisDis.addExternalCause(LR.fungi);
uveitisDis.addInternalCause(LR.rheumatoidArthritis);
uveitisDis.addInternalCause(LR.ankylosingSpondylitis);
uveitisDis.addInternalCause(LR.toxoplasmosis);
uveitisDis.addInternalCause(LR.ulcerativeColitis);
uveitisDis.addReference("pp 1173-4");
Treatment uveitisTr1 = new Treatment("uveitisTr1");
uveitisTr1.addDrug(LR.cycloplegic);
uveitisDis.addTreatment("uveitisTr1");
Treatment uveitisTr2 = new Treatment("uveitisTr2", LR.ifSevere);
uveitisTr2.addDrug(LR.corticosteroids);
uveitisDis.addTreatment("uveitisTr2");


// ------------- uveitisAnterior  -------------
Disease uveitisAnteriorDis = new Disease(
    LR.uveitisAnterior,
    L.uveitisAnteriorDescription,
    LR.eyeDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.eyesSysSt,
    LR.none
);
uveitisAnteriorDis.setPrintName(L.uveitisAnteriorPrintName);
uveitisAnteriorDis.setSuperDisease(LR.uveitis);
uveitisAnteriorDis.addInternalCause(LR.sarcoidosisOphthalmic);
uveitisAnteriorDis.addReference("pp 1173-4");
uveitisAnteriorDis.addSymptom(LR.eyePain);
uveitisAnteriorDis.addSymptom(LR.photophobia);
uveitisAnteriorDis.addSymptom(LR.pupilNonReactive);
uveitisAnteriorDis.addSymptom(LR.tearing);
uveitisAnteriorDis.addSymptom(LR.visionBlurred);


// ------------- uveitisPosterior  -------------
Disease uveitisPosteriorDis = new Disease(
    LR.uveitisPosterior,
    L.uveitisPosteriorDescription,
    LR.eyeDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.eyesSysSt,
    LR.none
);
uveitisPosteriorDis.setPrintName(L.uveitisPosteriorPrintName);
uveitisPosteriorDis.setSuperDisease(LR.uveitis);
uveitisPosteriorDis.setMiscComments(L.uveitisPosteriorComment);
uveitisPosteriorDis.addCausesAbnormalCondition(LR.blindness);
uveitisPosteriorDis.addReference("pp 1173-4");
uveitisPosteriorDis.addSymptom(LR.eyePain, "", 0.5f);
uveitisPosteriorDis.addSymptom(LR.photophobia, "", 0.2f);
uveitisPosteriorDis.addSymptom(LR.visionBlurred);
} // end of eyeDisorders





// ------------- gastrointestinalDisorders  -------------
static public void gastrointestinalDisorders() { 


// ------------- appendicitis  -------------
Disease appendicitisDis = new Disease(
    LR.appendicitis,
    L.appendicitisDescription,
    LR.gastrointestinalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.appendixSysSt,
    LR.none
);
appendicitisDis.setPrintName(L.appendicitisPrintName);
appendicitisDis.setMiscComments(L.appendicitisComment);
appendicitisDis.addCausesDisease(LR.appendicitis2);
appendicitisDis.addReference("pp 696-7");
appendicitisDis.addSymptom(LR.abdomenPainUpperRightSide);
appendicitisDis.addSymptom(LR.anorexia);
appendicitisDis.addSymptom(LR.nausea);
appendicitisDis.addSymptom(LR.vomiting);
Treatment appendicitisTr1 = new Treatment("appendicitisTr1");
appendicitisTr1.addTreatmentAction(LR.surgery);
appendicitisTr1.addDrug(LR.antibiotics);
appendicitisDis.addTreatment("appendicitisTr1");


// ------------- appendicitis2  -------------
Disease appendicitis2Dis = new Disease(
    LR.appendicitis2,
    L.appendicitis2Description,
    LR.gastrointestinalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.appendixSysSt,
    LR.none
);
appendicitis2Dis.setPrintName(L.appendicitis2PrintName);
appendicitis2Dis.setMiscComments(L.appendicitis2Comment);
appendicitis2Dis.addInternalCause(LR.appendicitis);
appendicitis2Dis.addReference("pp 696-7");
appendicitis2Dis.addSymptom(LR.anorexia);
appendicitis2Dis.addSymptom(LR.constipation, "", 0.4f);
appendicitis2Dis.addSymptom(LR.diarrhea, "", 0.4f);
appendicitis2Dis.addSymptom(LR.nausea);
appendicitis2Dis.addSymptom(LR.vomiting);
appendicitis2Dis.addSymptom(LR.abdomenPainLowerRightSide);
appendicitis2Dis.addSymptom(LR.abdomenRigidity);
appendicitis2Dis.addSymptom(LR.abdomenCramping);
appendicitis2Dis.addSymptom(LR.abdomenTenderness);
appendicitis2Dis.addSymptom(LR.reboundTenderness);
appendicitis2Dis.addSymptom(LR.respirationRetractive);


// ------------- celiacDisease  -------------
Disease celiacDiseaseDis = new Disease(
    LR.celiacDisease,
    L.celiacDiseaseDescription,
    LR.gastrointestinalDisorders,
    LR.moreFemale, // genderSpecificity
    LR.caucasian, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gastrointestinalSysSt,
    LR.none
);
celiacDiseaseDis.setPrintName(L.celiacDiseasePrintName);
celiacDiseaseDis.addCausesDisease(LR.amenorrhea);
celiacDiseaseDis.addCausesDisease(LR.anemia);
celiacDiseaseDis.addCausesDisease(LR.dermatitisHerpetiformis);
celiacDiseaseDis.addCausesDisease(LR.osteoporosis);
celiacDiseaseDis.addCausesDisease(LR.psoriasis);
celiacDiseaseDis.addCausesDisease(LR.vitaminDDeficiency);
celiacDiseaseDis.addReference("pp 692-4");
celiacDiseaseDis.addSymptom(LR.abdomenDistension);
celiacDiseaseDis.addSymptom(LR.acne);
celiacDiseaseDis.addSymptom(LR.anorexia);
celiacDiseaseDis.addSymptom(LR.bloating);
celiacDiseaseDis.addSymptom(LR.bonePain);
celiacDiseaseDis.addSymptom(LR.diarrhea);
celiacDiseaseDis.addSymptom(LR.eczema);
celiacDiseaseDis.addSymptom(LR.fatigue);
celiacDiseaseDis.addSymptom(LR.gas);
celiacDiseaseDis.addSymptom(LR.irritability);
celiacDiseaseDis.addSymptom(LR.nailBrittle);
celiacDiseaseDis.addSymptom(LR.skinDry);
celiacDiseaseDis.addSymptom(LR.stoolMalodorous);
celiacDiseaseDis.addSymptom(LR.stomachache);
celiacDiseaseDis.addSymptom(LR.tetany);
celiacDiseaseDis.addSymptom(LR.weakness);
Treatment celiacDiseaseTr1 = new Treatment("celiacDiseaseTr1");
celiacDiseaseTr1.addTreatmentAction(LR.dietWithoutGluten);
celiacDiseaseDis.addTreatment("celiacDiseaseTr1");


// ------------- diverticularSuper  -------------
Disease diverticularSuperDis = new Disease(
    LR.diverticularSuper,
    L.diverticularSuperDescription,
    LR.gastrointestinalDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.colonSysSt,
    LR.none
);
diverticularSuperDis.setPrintName(L.diverticularSuperPrintName);
diverticularSuperDis.setTemperature(100.5f);
diverticularSuperDis.setCode358(294);
diverticularSuperDis.setICD10code("K57");
diverticularSuperDis.addCausesAbnormalCondition(LR.leukocytosis);
diverticularSuperDis.addReference("pp 694-6");
diverticularSuperDis.addSymptom(LR.abdomenPainLowerLeftSide);
diverticularSuperDis.addSymptom(LR.constipation, L.diverticularSuper_constipation, 0.5f);
diverticularSuperDis.addSymptom(LR.diarrhea, L.diverticularSuper_diarrhea, 0.5f);
diverticularSuperDis.addSymptom(LR.feverSym);
diverticularSuperDis.addSymptom(LR.nausea);
diverticularSuperDis.addSymptom(LR.gas);
Treatment diverticularSuperTr1 = new Treatment("diverticularSuperTr1");
diverticularSuperTr1.addTreatmentAction(LR.bedRest);
diverticularSuperTr1.addTreatmentAction(LR.dietLiquid);
diverticularSuperTr1.addDrug(LR.antibiotics);
diverticularSuperTr1.addDrug(LR.stoolSoftener);
diverticularSuperTr1.addDrug(LR.meperidine);
diverticularSuperTr1.addDrug(LR.antispasmodic);
diverticularSuperDis.addTreatment("diverticularSuperTr1");


// ------------- diverticularDisease  -------------
Disease diverticularDiseaseDis = new Disease(
    LR.diverticularDisease,
    L.diverticularDiseaseDescription,
    LR.gastrointestinalDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.colonSysSt,
    LR.none
);
diverticularDiseaseDis.setPrintName(L.diverticularDiseasePrintName);
diverticularDiseaseDis.setSuperDisease(LR.diverticularSuper);
diverticularDiseaseDis.setTemperature(100.5f);
diverticularDiseaseDis.setCode358(294);
diverticularDiseaseDis.setICD10code("K57");
diverticularDiseaseDis.addCausesDisease(LR.diverticularDiseaseSevere);


// ------------- diverticularDiseaseSevere  -------------
Disease diverticularDiseaseSevereDis = new Disease(
    LR.diverticularDiseaseSevere,
    L.diverticularDiseaseSevereDescription,
    LR.gastrointestinalDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.colonSysSt,
    LR.none
);
diverticularDiseaseSevereDis.setPrintName(L.diverticularDiseaseSeverePrintName);
diverticularDiseaseSevereDis.setSuperDisease(LR.diverticularSuper);
diverticularDiseaseSevereDis.setTemperature(103.0f);
diverticularDiseaseSevereDis.setCode358(294);
diverticularDiseaseSevereDis.setICD10code("K57");
diverticularDiseaseSevereDis.addInternalCause(LR.diverticularDisease);
diverticularDiseaseSevereDis.addCausesDisease(LR.peritonitis);
diverticularDiseaseSevereDis.addCausesAbnormalCondition(LR.sepsis);
diverticularDiseaseSevereDis.addCausesAbnormalCondition(LR.shock);
diverticularDiseaseSevereDis.addReference("pp 694-6");
diverticularDiseaseSevereDis.addSymptom(LR.abdomenRigidity);
diverticularDiseaseSevereDis.addSymptom(LR.chills);
diverticularDiseaseSevereDis.addSymptom(LR.hypotension);
Treatment diverticularDiseaseSevereTr1 = new Treatment("diverticularDiseaseSevereTr1", LR.ifSevere);
diverticularDiseaseSevereTr1.addTreatmentAction(LR.surgery);
diverticularDiseaseSevereDis.addTreatment("diverticularDiseaseSevereTr1");


// ------------- gastroenteritis  -------------
Disease gastroenteritisDis = new Disease(
    LR.gastroenteritis,
    L.gastroenteritisDescription,
    LR.gastrointestinalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.gastroenteritisFreq, // diagnosis frequency, -1 = unknown
    LR.intestinesSysSt,
    LR.none
);
gastroenteritisDis.setPrintName(L.gastroenteritisPrintName);
gastroenteritisDis.addReference("pp 680-1");
gastroenteritisDis.addSymptom(LR.vomiting, "", 0.3f);
gastroenteritisDis.addSymptom(LR.abdomenCramping);
gastroenteritisDis.addSymptom(LR.diarrhea);
gastroenteritisDis.addSymptom(LR.nausea);
gastroenteritisDis.addSymptom(LR.malaise, "", 0.3f);
gastroenteritisDis.addSymptom(LR.borborygmi, "", 0.3f);
Treatment gastroenteritisTr1 = new Treatment("gastroenteritisTr1");
gastroenteritisTr1.addTreatmentAction(LR.bedRest);
gastroenteritisTr1.addTreatmentAction(LR.fluidIncrease);
gastroenteritisTr1.addTreatmentAction(LR.nutritionSupport);
gastroenteritisDis.addTreatment("gastroenteritisTr1");


// ------------- gastroesophagealReflux  -------------
Disease gastroesophagealRefluxDis = new Disease(
    LR.gastroesophagealReflux,
    L.gastroesophagealRefluxDescription,
    LR.gastrointestinalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.esophagusSysSt,
    LR.none
);
gastroesophagealRefluxDis.setPrintName(L.gastroesophagealRefluxPrintName);
gastroesophagealRefluxDis.addCausesDisease(LR.asthma);
gastroesophagealRefluxDis.addCausesDisease(LR.chronicObstructivePulmonaryDisease);
gastroesophagealRefluxDis.addReference("pp 666-8");
gastroesophagealRefluxDis.addSymptom(LR.bleedingFromMouth, L.gastroesophagealReflux_bleedingFromMouth, 0.05f);
gastroesophagealRefluxDis.addSymptom(LR.cough, "", 0.4f);
gastroesophagealRefluxDis.addSymptom(LR.dysphagia, "", 0.4f);
gastroesophagealRefluxDis.addSymptom(LR.esophagusSpasm, "", 0.4f);
gastroesophagealRefluxDis.addSymptom(LR.heartburn);
gastroesophagealRefluxDis.addSymptom(LR.hiccups, "", 0.4f);
gastroesophagealRefluxDis.addSymptom(LR.hoarseness, "", 0.4f);
gastroesophagealRefluxDis.addSymptom(LR.nausea, L.gastroesophagealReflux_nausea, 0.5f);
gastroesophagealRefluxDis.addSymptom(LR.retrosternalChestPain);
gastroesophagealRefluxDis.addSymptom(LR.throatSore, "", 0.4f);
gastroesophagealRefluxDis.addSymptom(LR.vomiting, "", 0.4f);
Treatment gastroesophagealRefluxTr1 = new Treatment("gastroesophagealRefluxTr1");
gastroesophagealRefluxTr1.addDrug(LR.antacid);
gastroesophagealRefluxDis.addTreatment("gastroesophagealRefluxTr1");


// ------------- giHemorrhage  -------------
Disease giHemorrhageDis = new Disease(
    LR.giHemorrhage,
    L.giHemorrhageDescription,
    LR.gastrointestinalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gastrointestinalSysSt,
    LR.none
);
giHemorrhageDis.setPrintName(L.giHemorrhagePrintName);
giHemorrhageDis.addReference("pp 0");
giHemorrhageDis.addSymptom(LR.bleedingFromMouth);
giHemorrhageDis.addSymptom(LR.bleedingFromRectum);
giHemorrhageDis.addSymptom(LR.consciousnessDecreased);
giHemorrhageDis.addSymptom(LR.hypotension);
giHemorrhageDis.addSymptom(LR.nausea);
giHemorrhageDis.addSymptom(LR.oliguria);
giHemorrhageDis.addSymptom(LR.tachypnea);
giHemorrhageDis.addSymptom(LR.skinClammy);
giHemorrhageDis.addSymptom(LR.skinCold);
giHemorrhageDis.addSymptom(LR.tachycardia);
Treatment giHemorrhageTr1 = new Treatment("giHemorrhageTr1");
giHemorrhageTr1.addTreatmentAction(LR.IVFluids);
giHemorrhageTr1.addTreatmentAction(LR.MinnesotaTube);
giHemorrhageTr1.addTreatmentAction(LR.bloodTransfusion);
giHemorrhageTr1.addTreatmentAction(LR.endotrachealIntubation);
giHemorrhageTr1.addTreatmentAction(LR.mechanicalVentilation);
giHemorrhageTr1.addTreatmentAction(LR.surgery);
giHemorrhageTr1.addTreatmentAction(LR.cauterization);
giHemorrhageTr1.addDrug(LR.vasopressin);
giHemorrhageDis.addTreatment("giHemorrhageTr1");


// ------------- gingivitis  -------------
Disease gingivitisDis = new Disease(
    LR.gingivitis,
    L.gingivitisDescription,
    LR.gastrointestinalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mouthSysSt,
    LR.none
);
gingivitisDis.setPrintName(L.gingivitisPrintName);
gingivitisDis.addReference("pp 665");
gingivitisDis.addSymptom(LR.gumsBleeding);
gingivitisDis.addSymptom(LR.gumPockets);
gingivitisDis.addSymptom(LR.gumsSwollen);
Treatment gingivitisTr1 = new Treatment("gingivitisTr1");
gingivitisTr1.addTreatmentAction(LR.mouthWash);
gingivitisTr1.addTreatmentAction(LR.oralHygiene);
gingivitisTr1.addDrug(LR.corticosteroids);
gingivitisDis.addTreatment("gingivitisTr1");


// ------------- glossitis  -------------
Disease glossitisDis = new Disease(
    LR.glossitis,
    L.glossitisDescription,
    LR.gastrointestinalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.tongueSysSt,
    LR.alcoholAbuse
);
glossitisDis.setPrintName(L.glossitisPrintName);
glossitisDis.addExternalCause(LR.streptococcusInfection);
glossitisDis.addExternalCause(LR.injury);
glossitisDis.addExternalCause(LR.smoking);
glossitisDis.addExternalCause(LR.spicyFoods);
glossitisDis.addExternalCause(LR.vitaminBDeficiency);
glossitisDis.addInternalCause(LR.anemia);
glossitisDis.addInternalCause(LR.anemiaFolicAcidDeficiency);
glossitisDis.addReference("pp 665");
glossitisDis.addSymptom(LR.chewingPainful);
glossitisDis.addSymptom(LR.speechDifficulty);
glossitisDis.addSymptom(LR.tonguePainful);
glossitisDis.addSymptom(LR.tongueRed);
glossitisDis.addSymptom(LR.tongueSwollen);
glossitisDis.addSymptom(LR.swallowingPainful);
Treatment glossitisTr1 = new Treatment("glossitisTr1");
glossitisTr1.addTreatmentAction(LR.mouthWash);
glossitisTr1.addTreatmentAction(LR.oralHygiene);
glossitisTr1.addDrug(LR.aspirin);
glossitisDis.addTreatment("glossitisTr1");


// ------------- hemorrhoids  -------------
Disease hemorrhoidsDis = new Disease(
    LR.hemorrhoids,
    L.hemorrhoidsDescription,
    LR.gastrointestinalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    60, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.rectumSysSt,
    LR.none
);
hemorrhoidsDis.setPrintName(L.hemorrhoidsPrintName);
hemorrhoidsDis.addReference("pp 715-7");
hemorrhoidsDis.addSymptom(LR.stoolBrightRedBloody);
hemorrhoidsDis.addSymptom(LR.rectumItching);
Treatment hemorrhoidsTr1 = new Treatment("hemorrhoidsTr1");
hemorrhoidsTr1.addTreatmentAction(LR.dietFiber);
hemorrhoidsTr1.addTreatmentAction(LR.anestheticLocal);
hemorrhoidsTr1.addDrug(LR.stoolSoftener);
hemorrhoidsDis.addTreatment("hemorrhoidsTr1");
Treatment hemorrhoidsTr2 = new Treatment("hemorrhoidsTr2", LR.ifSevere);
hemorrhoidsTr2.addTreatmentAction(LR.surgery);
hemorrhoidsDis.addTreatment("hemorrhoidsTr2");


// ------------- hirschsprung  -------------
Disease hirschsprungDis = new Disease(
    LR.hirschsprung,
    L.hirschsprungDescription,
    LR.gastrointestinalDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.largeIntestineSysSt,
    LR.none
);
hirschsprungDis.setPrintName(L.hirschsprungPrintName);
hirschsprungDis.setWebResource("http://en.wikipedia.org/wiki/Hirschsprung_disease");
hirschsprungDis.setGenetic("mother");
hirschsprungDis.setParentDisease(LR.hirschsprung);
hirschsprungDis.addReference("pp 708-11");
hirschsprungDis.addSymptom(LR.abdomenDistension);
hirschsprungDis.addSymptom(LR.constipation);
Treatment hirschsprungTr1 = new Treatment("hirschsprungTr1");
hirschsprungTr1.addTreatmentAction(LR.surgery);
hirschsprungDis.addTreatment("hirschsprungTr1");


// ------------- hirschsprungInfant  -------------
Disease hirschsprungInfantDis = new Disease(
    LR.hirschsprungInfant,
    L.hirschsprungInfantDescription,
    LR.gastrointestinalDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    1, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.largeIntestineSysSt,
    LR.none
);
hirschsprungInfantDis.setPrintName(L.hirschsprungInfantPrintName);
hirschsprungInfantDis.setSuperDisease(LR.hirschsprung);
hirschsprungInfantDis.setWebResource("http://en.wikipedia.org/wiki/Hirschsprung_disease");
hirschsprungInfantDis.setGenetic("mother");
hirschsprungInfantDis.setParentDisease(LR.hirschsprung);
hirschsprungInfantDis.addReference("pp 708-11");
hirschsprungInfantDis.addSymptom(LR.dehydration);
hirschsprungInfantDis.addSymptom(LR.diarrhea, "", 0.2f);
hirschsprungInfantDis.addSymptom(LR.feedingDifficulties);
hirschsprungInfantDis.addSymptom(LR.irritability);
hirschsprungInfantDis.addSymptom(LR.vomitBile);


// ------------- hirschsprungChild  -------------
Disease hirschsprungChildDis = new Disease(
    LR.hirschsprungChild,
    L.hirschsprungChildDescription,
    LR.gastrointestinalDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    2, // minAge
    17, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.largeIntestineSysSt,
    LR.none
);
hirschsprungChildDis.setPrintName(L.hirschsprungChildPrintName);
hirschsprungChildDis.setSuperDisease(LR.hirschsprung);
hirschsprungChildDis.setWebResource("http://en.wikipedia.org/wiki/Hirschsprung_disease");
hirschsprungChildDis.setGenetic("mother");
hirschsprungChildDis.setParentDisease(LR.hirschsprung);
hirschsprungChildDis.addCausesDisease(LR.anemia);
hirschsprungChildDis.addReference("pp 708-11");
hirschsprungChildDis.addSymptom(LR.anorexia, "", 0.4f);
hirschsprungChildDis.addSymptom(LR.diarrhea, "", 0.2f);


// ------------- hirschsprungAdult  -------------
Disease hirschsprungAdultDis = new Disease(
    LR.hirschsprungAdult,
    L.hirschsprungAdultDescription,
    LR.gastrointestinalDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    18, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.largeIntestineSysSt,
    LR.none
);
hirschsprungAdultDis.setPrintName(L.hirschsprungAdultPrintName);
hirschsprungAdultDis.setSuperDisease(LR.hirschsprung);
hirschsprungAdultDis.setWebResource("http://en.wikipedia.org/wiki/Hirschsprung_disease");
hirschsprungAdultDis.setGenetic("mother");
hirschsprungAdultDis.setParentDisease(LR.hirschsprung);
hirschsprungAdultDis.addCausesDisease(LR.anemia);
hirschsprungAdultDis.addReference("pp 708-11");
hirschsprungAdultDis.addSymptom(LR.pallor, "", 0.2f);


// ------------- intestinalObstruction  -------------
Disease intestinalObstructionDis = new Disease(
    LR.intestinalObstruction,
    L.intestinalObstructionDescription,
    LR.gastrointestinalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.intestinesSysSt,
    LR.none
);
intestinalObstructionDis.setPrintName(L.intestinalObstructionPrintName);
intestinalObstructionDis.addReference("pp 699-703");
intestinalObstructionDis.addSymptom(LR.abdomenDistension);
intestinalObstructionDis.addSymptom(LR.abdomenPain);
intestinalObstructionDis.addSymptom(LR.obstipation);
intestinalObstructionDis.addSymptom(LR.dehydration);
intestinalObstructionDis.addSymptom(LR.diarrhea);
intestinalObstructionDis.addSymptom(LR.drowsiness);
intestinalObstructionDis.addSymptom(LR.nausea);
intestinalObstructionDis.addSymptom(LR.thirst);
intestinalObstructionDis.addSymptom(LR.vomiting);
Treatment intestinalObstructionTr1 = new Treatment("intestinalObstructionTr1");
intestinalObstructionTr1.addTreatmentAction(LR.IVFluids);
intestinalObstructionTr1.addTreatmentAction(LR.bedRest);
intestinalObstructionTr1.addTreatmentAction(LR.surgery);
intestinalObstructionTr1.addTreatmentAction(LR.paranteralNutrition);
intestinalObstructionTr1.addTreatmentAction(LR.nasogastricTube);
intestinalObstructionDis.addTreatment("intestinalObstructionTr1");


// ------------- necrotizingEnterocolitis  -------------
Disease necrotizingEnterocolitisDis = new Disease(
    LR.necrotizingEnterocolitis,
    L.necrotizingEnterocolitisDescription,
    LR.gastrointestinalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    2, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.intestinesSysSt,
    LR.none
);
necrotizingEnterocolitisDis.setPrintName(L.necrotizingEnterocolitisPrintName);
necrotizingEnterocolitisDis.addCausesDisease(LR.disseminatedIntravascularCoagulation);
necrotizingEnterocolitisDis.addCausesDisease(LR.metabolicAcidosis);
necrotizingEnterocolitisDis.addReference("pp 687-9");
necrotizingEnterocolitisDis.addSymptom(LR.abdomenDistension);
necrotizingEnterocolitisDis.addSymptom(LR.bradycardia);
necrotizingEnterocolitisDis.addSymptom(LR.diarrheaBloody);
necrotizingEnterocolitisDis.addSymptom(LR.gastricResidueIncreased);
necrotizingEnterocolitisDis.addSymptom(LR.jaundice);
necrotizingEnterocolitisDis.addSymptom(LR.lethargy);
Treatment necrotizingEnterocolitisTr1 = new Treatment("necrotizingEnterocolitisTr1");
necrotizingEnterocolitisTr1.addTreatmentAction(LR.IVFluids);
necrotizingEnterocolitisTr1.addTreatmentAction(LR.nasogastricTube);
necrotizingEnterocolitisTr1.addTreatmentAction(LR.paranteralNutrition);
necrotizingEnterocolitisTr1.addTreatmentAction(LR.surgery);
necrotizingEnterocolitisTr1.addTreatmentAction(LR.nothingByMouth);
necrotizingEnterocolitisTr1.addTreatmentAction(LR.bowelRest);
necrotizingEnterocolitisTr1.addDrug(LR.antibiotics);
necrotizingEnterocolitisTr1.addDrug(LR.dextran);
necrotizingEnterocolitisDis.addTreatment("necrotizingEnterocolitisTr1");


// ------------- pancreatitis  -------------
Disease pancreatitisDis = new Disease(
    LR.pancreatitis,
    L.pancreatitisDescription,
    LR.gastrointestinalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.pancreasSysSt,
    LR.none
);
pancreatitisDis.setPrintName(L.pancreatitisPrintName);
pancreatitisDis.setTemperature(101.0f);
pancreatitisDis.setCode358(304);
pancreatitisDis.setICD10code("K85");
pancreatitisDis.addCausesAbnormalCondition(LR.pleuralEffusionLeft);
pancreatitisDis.addReference("pp 712-5");
pancreatitisDis.addSymptom(LR.abdomenRigidity);
pancreatitisDis.addSymptom(LR.bowelActivityDecreased);
pancreatitisDis.addSymptom(LR.crackles);
pancreatitisDis.addSymptom(LR.epigastricUmbilicusPain);
pancreatitisDis.addSymptom(LR.malaise);
pancreatitisDis.addSymptom(LR.skinMottled);
pancreatitisDis.addSymptom(LR.vomiting);
Treatment pancreatitisTr1 = new Treatment("pancreatitisTr1");
pancreatitisTr1.addTreatmentAction(LR.IVFluids);
pancreatitisTr1.addDrug(LR.antibiotics);
pancreatitisTr1.addDrug(LR.insulin);
pancreatitisTr1.addDrug(LR.morphine);
pancreatitisTr1.addDrug(LR.diazepam);
pancreatitisTr1.addDrug(LR.calciumGluconate);
pancreatitisDis.addTreatment("pancreatitisTr1");


// ------------- pepticUlcers  -------------
Disease pepticUlcersDis = new Disease(
    LR.pepticUlcers,
    L.pepticUlcersDescription,
    LR.gastrointestinalDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gastrointestinalSysSt,
    LR.helicobacterPyloriInfection
);
pepticUlcersDis.setPrintName(L.pepticUlcersPrintName);
pepticUlcersDis.addExternalCause(LR.alcoholAbuse);
pepticUlcersDis.addExternalCause(LR.tobaccoUse);
pepticUlcersDis.setCode358(286);
pepticUlcersDis.setICD10code("K27");
pepticUlcersDis.addInternalCause(LR.hepatitis);
pepticUlcersDis.addInternalCause(LR.pancreatitis);
pepticUlcersDis.addReference("pp 681-4");
pepticUlcersDis.addSymptom(LR.heartburn);
pepticUlcersDis.addSymptom(LR.dyspepsia);
pepticUlcersDis.addSymptom(LR.weightGain);
Treatment pepticUlcersTr1 = new Treatment("pepticUlcersTr1");
pepticUlcersTr1.addDrug(LR.amoxicillin);
pepticUlcersTr1.addDrug(LR.metronidazole);
pepticUlcersTr1.addDrug(LR.tetracycline);
pepticUlcersDis.addTreatment("pepticUlcersTr1");


// ------------- peritonitis  -------------
Disease peritonitisDis = new Disease(
    LR.peritonitis,
    L.peritonitisDescription,
    LR.gastrointestinalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.peritoneumSysSt,
    LR.none
);
peritonitisDis.setPrintName(L.peritonitisPrintName);
peritonitisDis.setMiscComments(L.peritonitisComment);
peritonitisDis.addInternalCause(LR.ectopicPregnancyRupture);
peritonitisDis.addInternalCause(LR.diverticularDiseaseSevere);
peritonitisDis.addReference("pp 698-9");
peritonitisDis.addSymptom(LR.abdomenPainSuddenSevere);
peritonitisDis.addSymptom(LR.abdomenRigidity);
peritonitisDis.addSymptom(LR.nausea);
peritonitisDis.addSymptom(LR.vomiting);
peritonitisDis.addSymptom(LR.diarrhea);
peritonitisDis.addSymptom(LR.pulseWeak);
peritonitisDis.addSymptom(LR.tachycardia);
peritonitisDis.addSymptom(LR.hiccups);
Treatment peritonitisTr1 = new Treatment("peritonitisTr1");
peritonitisTr1.addTreatmentAction(LR.IVFluids);
peritonitisTr1.addTreatmentAction(LR.nothingByMouth);
peritonitisTr1.addTreatmentAction(LR.electrolyteReplacement);
peritonitisTr1.addDrug(LR.antibiotics);
peritonitisTr1.addDrug(LR.antiemetics);
peritonitisDis.addTreatment("peritonitisTr1");


// ------------- stomatitis  -------------
Disease stomatitisDis = new Disease(
    LR.stomatitis,
    L.stomatitisDescription,
    LR.gastrointestinalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mouthSysSt,
    LR.none
);
stomatitisDis.setPrintName(L.stomatitisPrintName);
stomatitisDis.addInternalCause(LR.renalFailureAcute);
stomatitisDis.addReference("pp 664-6");
stomatitisDis.addSymptom(LR.mouthUlcers);


// ------------- stomatitisAcuteHerpetic  -------------
Disease stomatitisAcuteHerpeticDis = new Disease(
    LR.stomatitisAcuteHerpetic,
    L.stomatitisAcuteHerpeticDescription,
    LR.gastrointestinalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mouthSysSt,
    LR.herpesSimplexVirus
);
stomatitisAcuteHerpeticDis.setPrintName(L.stomatitisAcuteHerpeticPrintName);
stomatitisAcuteHerpeticDis.setSuperDisease(LR.stomatitis);
stomatitisAcuteHerpeticDis.addReference("pp 664-6");
stomatitisAcuteHerpeticDis.addSymptom(LR.anorexia);
stomatitisAcuteHerpeticDis.addSymptom(LR.gumsSwollen);
stomatitisAcuteHerpeticDis.addSymptom(LR.irritability);
stomatitisAcuteHerpeticDis.addSymptom(LR.lethargy);
stomatitisAcuteHerpeticDis.addSymptom(LR.malaise);
stomatitisAcuteHerpeticDis.addSymptom(LR.mouthPain);
Treatment stomatitisAcuteHerpeticTr1 = new Treatment("stomatitisAcuteHerpeticTr1");
stomatitisAcuteHerpeticTr1.addTreatmentAction(LR.mouthWash);
stomatitisAcuteHerpeticDis.addTreatment("stomatitisAcuteHerpeticTr1");


// ------------- stomatitisAphthous  -------------
Disease stomatitisAphthousDis = new Disease(
    LR.stomatitisAphthous,
    L.stomatitisAphthousDescription,
    LR.gastrointestinalDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mouthSysSt,
    LR.stress
);
stomatitisAphthousDis.setPrintName(L.stomatitisAphthousPrintName);
stomatitisAphthousDis.setSuperDisease(LR.stomatitis);
stomatitisAphthousDis.addExternalCause(LR.trauma);
stomatitisAphthousDis.addExternalCause(LR.fatigue);
stomatitisAphthousDis.addReference("pp 664-6");
stomatitisAphthousDis.addSymptom(LR.feverSym, "", 0.3f);
stomatitisAphthousDis.addSymptom(LR.mouthTingling, "", 0.7f);
stomatitisAphthousDis.addSymptom(LR.mouthPain);
Treatment stomatitisAphthousTr1 = new Treatment("stomatitisAphthousTr1");
stomatitisAphthousTr1.addTreatmentAction(LR.anesthetic);
stomatitisAphthousDis.addTreatment("stomatitisAphthousTr1");


// ------------- ulcerativeColitis  -------------
Disease ulcerativeColitisDis = new Disease(
    LR.ulcerativeColitis,
    L.ulcerativeColitisDescription,
    LR.gastrointestinalDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    60, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.colonSysSt,
    LR.none
);
ulcerativeColitisDis.setPrintName(L.ulcerativeColitisPrintName);
ulcerativeColitisDis.setMiscComments(L.ulcerativeColitisComment);
ulcerativeColitisDis.setCode358(292);
ulcerativeColitisDis.setICD10code("K51");
ulcerativeColitisDis.addCausesDisease(LR.anemia);
ulcerativeColitisDis.addCausesDisease(LR.ankylosingSpondylitis);
ulcerativeColitisDis.addCausesDisease(LR.arthritis);
ulcerativeColitisDis.addCausesDisease(LR.uveitis);
ulcerativeColitisDis.addCausesDisease(LR.cirrhosis);
ulcerativeColitisDis.addReference("pp 684-7");
ulcerativeColitisDis.addSymptom(LR.abdomenPain);
ulcerativeColitisDis.addSymptom(LR.anorexia);
ulcerativeColitisDis.addSymptom(LR.diarrheaBloody);
ulcerativeColitisDis.addSymptom(LR.irritability);
ulcerativeColitisDis.addSymptom(LR.nausea);
ulcerativeColitisDis.addSymptom(LR.vomiting);
ulcerativeColitisDis.addSymptom(LR.weightLoss);
Treatment ulcerativeColitisTr1 = new Treatment("ulcerativeColitisTr1");
ulcerativeColitisTr1.addTreatmentAction(LR.IVFluids);
ulcerativeColitisTr1.addTreatmentAction(LR.bedRest);
ulcerativeColitisTr1.addTreatmentAction(LR.dietLiquid);
ulcerativeColitisDis.addTreatment("ulcerativeColitisTr1");
} // end of gastrointestinalDisorders





// ------------- geneticDisorders  -------------
static public void geneticDisorders() { 


// ------------- cysticFibrosis  -------------
Disease cysticFibrosisDis = new Disease(
    LR.cysticFibrosis,
    L.cysticFibrosisDescription,
    LR.geneticDisorders,
    LR.none, // genderSpecificity
    LR.caucasian, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.exocrineGlandsSysSt,
    LR.none
);
cysticFibrosisDis.setPrintName(L.cysticFibrosisPrintName);
cysticFibrosisDis.setMiscComments(L.cysticFibrosisComment);
cysticFibrosisDis.setGenetic("1parent");
cysticFibrosisDis.setParentDisease(LR.cysticFibrosis);
cysticFibrosisDis.setCode358(171);
cysticFibrosisDis.setICD10code("E84");
cysticFibrosisDis.addCausingAbnormalCondition(LR.shock);
cysticFibrosisDis.addCausesDisease(LR.hypochloremia);
cysticFibrosisDis.addCausesDisease(LR.hyponatremia);
cysticFibrosisDis.addCausesDisease(LR.atelectasis);
cysticFibrosisDis.addCausesDisease(LR.emphysema);
cysticFibrosisDis.addReference("pp 15-17");
cysticFibrosisDis.addSymptom(LR.arrhythmia);
cysticFibrosisDis.addSymptom(LR.coughDry);
cysticFibrosisDis.addSymptom(LR.dyspnea);
cysticFibrosisDis.addSymptom(LR.tachypnea);
cysticFibrosisDis.addSymptom(LR.wheezing);


// ------------- hemophilia  -------------
Disease hemophiliaDis = new Disease(
    LR.hemophilia,
    L.hemophiliaDescription,
    LR.geneticDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.hematologicSysSt,
    LR.none
);
hemophiliaDis.setPrintName(L.hemophiliaPrintName);
hemophiliaDis.setMiscComments(L.hemophiliaComment);
hemophiliaDis.setGenetic("mother");
hemophiliaDis.setParentDisease(LR.hemophilia);
hemophiliaDis.addReference("pp 25-8");
hemophiliaDis.addSymptom(LR.bleedingAbnormal);
hemophiliaDis.addSymptom(LR.bleedingProlonged);


// ------------- sickleCellCrisis  -------------
Disease sickleCellCrisisDis = new Disease(
    LR.sickleCellCrisis,
    L.sickleCellCrisisDescription,
    LR.geneticDisorders,
    LR.none, // genderSpecificity
    LR.africanAmerican, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.hematologicSysSt,
    LR.none
);
sickleCellCrisisDis.setPrintName(L.sickleCellCrisisPrintName);
sickleCellCrisisDis.setUnderlyingDisease(LR.sickleCellAnemia);
sickleCellCrisisDis.setTemperature(104.0f);
sickleCellCrisisDis.addReference("pp 21-4");
sickleCellCrisisDis.addSymptom(LR.irritability);
sickleCellCrisisDis.addSymptom(LR.lethargy);
sickleCellCrisisDis.addSymptom(LR.painSevere);
sickleCellCrisisDis.addSymptom(LR.lipsPale);
sickleCellCrisisDis.addSymptom(LR.nailsPale);
sickleCellCrisisDis.addSymptom(LR.palmsPale);
sickleCellCrisisDis.addSymptom(LR.tonguePale);
Treatment sickleCellCrisisTr1 = new Treatment("sickleCellCrisisTr1");
sickleCellCrisisTr1.addTreatmentAction(LR.IVFluids);
sickleCellCrisisTr1.addTreatmentAction(LR.bloodTransfusion);
sickleCellCrisisTr1.addTreatmentAction(LR.oxygenTherapy);
sickleCellCrisisTr1.addDrug(LR.analgetics);
sickleCellCrisisTr1.addDrug(LR.sedatives);
sickleCellCrisisDis.addTreatment("sickleCellCrisisTr1");


// ------------- sickleCellAnemia  -------------
Disease sickleCellAnemiaDis = new Disease(
    LR.sickleCellAnemia,
    L.sickleCellAnemiaDescription,
    LR.geneticDisorders,
    LR.none, // genderSpecificity
    LR.africanAmerican, // raceSpecificity
    2, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.hematologicSysSt,
    LR.none
);
sickleCellAnemiaDis.setPrintName(L.sickleCellAnemiaPrintName);
sickleCellAnemiaDis.setMiscComments(L.sickleCellAnemiaComment);
sickleCellAnemiaDis.addCausesDisease(LR.corPulmonale);
sickleCellAnemiaDis.addCausesAbnormalCondition(LR.cardiacEnlargement);
sickleCellAnemiaDis.addCausesAbnormalCondition(LR.hepatomegaly);
sickleCellAnemiaDis.addReference("pp 21-5");
sickleCellAnemiaDis.addSymptom(LR.dyspnea);
sickleCellAnemiaDis.addSymptom(LR.tachycardia);
sickleCellAnemiaDis.addSymptom(LR.chestPain);
sickleCellAnemiaDis.addSymptom(LR.jaundice);
sickleCellAnemiaDis.addSymptom(LR.pallor);
sickleCellAnemiaDis.addSymptom(LR.bonePain);
sickleCellAnemiaDis.addSymptom(LR.fatigueProlonged);
sickleCellAnemiaDis.addSymptom(LR.jointSwelling);
Treatment sickleCellAnemiaTr1 = new Treatment("sickleCellAnemiaTr1");
sickleCellAnemiaTr1.addDrug(LR.penicillin);
sickleCellAnemiaDis.addTreatment("sickleCellAnemiaTr1");
} // end of geneticDisorders





// ------------- gynecologicDisorders  -------------
static public void gynecologicDisorders() { 


// ------------- premenstrualSyndrome  -------------
Disease premenstrualSyndromeDis = new Disease(
    LR.premenstrualSyndrome,
    L.premenstrualSyndromeDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    50, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
premenstrualSyndromeDis.setPrintName(L.premenstrualSyndromePrintName);
premenstrualSyndromeDis.addReference("pp 920-1");
premenstrualSyndromeDis.addSymptom(LR.abdomenBloating);
premenstrualSyndromeDis.addSymptom(LR.abdomenTenderness);
premenstrualSyndromeDis.addSymptom(LR.agitation);
premenstrualSyndromeDis.addSymptom(LR.breastSwelling);
premenstrualSyndromeDis.addSymptom(LR.breastTenderness);
premenstrualSyndromeDis.addSymptom(LR.constipation);
premenstrualSyndromeDis.addSymptom(LR.diarrhea);
premenstrualSyndromeDis.addSymptom(LR.edema);
premenstrualSyndromeDis.addSymptom(LR.fatigue);
premenstrualSyndromeDis.addSymptom(LR.headache);
premenstrualSyndromeDis.addSymptom(LR.hostility);
premenstrualSyndromeDis.addSymptom(LR.irritability);
premenstrualSyndromeDis.addSymptom(LR.jointPain);
premenstrualSyndromeDis.addSymptom(LR.lethargy);
premenstrualSyndromeDis.addSymptom(LR.mentalDepression);
premenstrualSyndromeDis.addSymptom(LR.nervousness);
premenstrualSyndromeDis.addSymptom(LR.rash);
premenstrualSyndromeDis.addSymptom(LR.sleepDisturbed);
Treatment premenstrualSyndromeTr1 = new Treatment("premenstrualSyndromeTr1");
premenstrualSyndromeTr1.addDrug(LR.diuretics);
premenstrualSyndromeTr1.addDrug(LR.antidepressants);
premenstrualSyndromeTr1.addDrug(LR.vitaminBComplex);
premenstrualSyndromeTr1.addDrug(LR.progestins);
premenstrualSyndromeTr1.addDrug(LR.prostaglandinInhibitor);
premenstrualSyndromeDis.addTreatment("premenstrualSyndromeTr1");


// ------------- dysmenorrhea  -------------
Disease dysmenorrheaDis = new Disease(
    LR.dysmenorrhea,
    L.dysmenorrheaDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    50, // maxAge
    -2, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.uterusSysSt,
    LR.none
);
dysmenorrheaDis.setPrintName(L.dysmenorrheaPrintName);
dysmenorrheaDis.addInternalCause(LR.trichomoniasisFemale);
dysmenorrheaDis.addReference("pp 921-3");
dysmenorrheaDis.addSymptom(LR.abdomenCramping);
dysmenorrheaDis.addSymptom(LR.abdomenPainLowerSide);
dysmenorrheaDis.addSymptom(LR.dizziness, "", 0.3f);
dysmenorrheaDis.addSymptom(LR.headache, "", 0.3f);
dysmenorrheaDis.addSymptom(LR.nausea, "", 0.3f);
Treatment dysmenorrheaTr1 = new Treatment("dysmenorrheaTr1");
dysmenorrheaTr1.addDrug(LR.analgetics);
dysmenorrheaTr1.addDrug(LR.prostaglandinInhibitor);
dysmenorrheaDis.addTreatment("dysmenorrheaTr1");
Treatment dysmenorrheaTr2 = new Treatment("dysmenorrheaTr2", LR.ifSevere);
dysmenorrheaTr2.addDrug(LR.narcotics);
dysmenorrheaDis.addTreatment("dysmenorrheaTr2");


// ------------- vulvovaginitis  -------------
Disease vulvovaginitisDis = new Disease(
    LR.vulvovaginitis,
    L.vulvovaginitisDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vaginagySysSt,
    LR.none
);
vulvovaginitisDis.setPrintName(L.vulvovaginitisPrintName);
vulvovaginitisDis.addInternalCause(LR.diabetesMellitusAdvanced);
vulvovaginitisDis.addReference("pp 923-4");
vulvovaginitisDis.addSymptom(LR.intercourseDiscomfort, "", 0.5f);
Treatment vulvovaginitisTr1 = new Treatment("vulvovaginitisTr1", LR.ifItchyVulva);
vulvovaginitisTr1.addTreatmentAction(LR.coldCompress);
vulvovaginitisTr1.addTreatmentAction(LR.coolSitzBath);
vulvovaginitisDis.addTreatment("vulvovaginitisTr1");
Treatment vulvovaginitisTr2 = new Treatment("vulvovaginitisTr2", LR.ifSevereInflammation);
vulvovaginitisTr2.addTreatmentAction(LR.warmCompress);
vulvovaginitisTr2.addDrug(LR.corticosteroids);
vulvovaginitisDis.addTreatment("vulvovaginitisTr2");
Treatment vulvovaginitisTr3 = new Treatment("vulvovaginitisTr3", LR.ifChronic);
vulvovaginitisTr3.addDrug(LR.hydrocortisone);
vulvovaginitisTr3.addDrug(LR.antipruritics);
vulvovaginitisDis.addTreatment("vulvovaginitisTr3");
Treatment vulvovaginitisTr4 = new Treatment("vulvovaginitisTr4", LR.ifMenopausalMucosaAtrophy);
vulvovaginitisTr4.addTreatmentAction(LR.topicalEstrogenOintment);
vulvovaginitisDis.addTreatment("vulvovaginitisTr4");


// ------------- vulvovaginitisCan  -------------
Disease vulvovaginitisCanDis = new Disease(
    LR.vulvovaginitisCan,
    L.vulvovaginitisCanDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    50, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vaginagySysSt,
    LR.candidaAlbicansInfection
);
vulvovaginitisCanDis.setPrintName(L.vulvovaginitisCanPrintName);
vulvovaginitisCanDis.setSuperDisease(LR.vulvovaginitis);
vulvovaginitisCanDis.addReference("pp 923-4");
vulvovaginitisCanDis.addSymptom(LR.pruritus);
vulvovaginitisCanDis.addSymptom(LR.vulvaRedSwollen);
vulvovaginitisCanDis.addSymptom(LR.vaginaDischargeThickWhite);
vulvovaginitisCanDis.addSymptom(LR.vaginaItching);
Treatment vulvovaginitisCanTr1 = new Treatment("vulvovaginitisCanTr1");
vulvovaginitisCanTr1.addDrug(LR.miconazole);
vulvovaginitisCanTr1.addDrug(LR.clotrimazole);
vulvovaginitisCanDis.addTreatment("vulvovaginitisCanTr1");


// ------------- vulvovaginitisClam  -------------
Disease vulvovaginitisClamDis = new Disease(
    LR.vulvovaginitisClam,
    L.vulvovaginitisClamDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    50, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vaginagySysSt,
    LR.infection
);
vulvovaginitisClamDis.setPrintName(L.vulvovaginitisClamPrintName);
vulvovaginitisClamDis.setSuperDisease(LR.vulvovaginitis);
vulvovaginitisClamDis.addInternalCause(LR.chlamydialInfection);
vulvovaginitisClamDis.addReference("pp 923-4");
vulvovaginitisClamDis.addSymptom(LR.urinationPainful);
vulvovaginitisClamDis.addSymptom(LR.vaginaDischarge);
Treatment vulvovaginitisClamTr1 = new Treatment("vulvovaginitisClamTr1");
vulvovaginitisClamTr1.addDrug(LR.erythromycin);
vulvovaginitisClamTr1.addDrug(LR.doxycycline);
vulvovaginitisClamDis.addTreatment("vulvovaginitisClamTr1");


// ------------- vulvovaginitisGar  -------------
Disease vulvovaginitisGarDis = new Disease(
    LR.vulvovaginitisGar,
    L.vulvovaginitisGarDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    50, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vaginagySysSt,
    LR.gardnerellaInfection
);
vulvovaginitisGarDis.setPrintName(L.vulvovaginitisGarPrintName);
vulvovaginitisGarDis.setSuperDisease(LR.vulvovaginitis);
vulvovaginitisGarDis.addReference("pp 923-4");
vulvovaginitisGarDis.addSymptom(LR.vaginaDischargeGrayFoulFishySmelling);
Treatment vulvovaginitisGarTr1 = new Treatment("vulvovaginitisGarTr1");
vulvovaginitisGarTr1.addDrug(LR.metronidazole);
vulvovaginitisGarDis.addTreatment("vulvovaginitisGarTr1");


// ------------- vulvovaginitisGon  -------------
Disease vulvovaginitisGonDis = new Disease(
    LR.vulvovaginitisGon,
    L.vulvovaginitisGonDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    50, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vaginagySysSt,
    LR.gonorrheaInfection
);
vulvovaginitisGonDis.setPrintName(L.vulvovaginitisGonPrintName);
vulvovaginitisGonDis.setSuperDisease(LR.vulvovaginitis);
vulvovaginitisGonDis.addReference("pp 923-4");
vulvovaginitisGonDis.addSymptom(LR.dysuria);
vulvovaginitisGonDis.addSymptom(LR.vaginaDischargePurulent);
Treatment vulvovaginitisGonTr1 = new Treatment("vulvovaginitisGonTr1");
vulvovaginitisGonTr1.addDrug(LR.antibiotics);
vulvovaginitisGonDis.addTreatment("vulvovaginitisGonTr1");


// ------------- vulvovaginitisHer  -------------
Disease vulvovaginitisHerDis = new Disease(
    LR.vulvovaginitisHer,
    L.vulvovaginitisHerDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    50, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vaginagySysSt,
    LR.none
);
vulvovaginitisHerDis.setPrintName(L.vulvovaginitisHerPrintName);
vulvovaginitisHerDis.setSuperDisease(LR.vulvovaginitis);
vulvovaginitisHerDis.addInternalCause(LR.herpesSimplex);
vulvovaginitisHerDis.addReference("pp 923-4");
vulvovaginitisHerDis.addSymptom(LR.blister);
vulvovaginitisHerDis.addSymptom(LR.ulcer);
Treatment vulvovaginitisHerTr1 = new Treatment("vulvovaginitisHerTr1");
vulvovaginitisHerTr1.addDrug(LR.acyclovir);
vulvovaginitisHerDis.addTreatment("vulvovaginitisHerTr1");


// ------------- vulvovaginitisTri  -------------
Disease vulvovaginitisTriDis = new Disease(
    LR.vulvovaginitisTri,
    L.vulvovaginitisTriDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    50, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vaginagySysSt,
    LR.trichomonasInfection
);
vulvovaginitisTriDis.setPrintName(L.vulvovaginitisTriPrintName);
vulvovaginitisTriDis.setSuperDisease(LR.vulvovaginitis);
vulvovaginitisTriDis.addReference("pp 923-4");
vulvovaginitisTriDis.addSymptom(LR.burningSensation);
vulvovaginitisTriDis.addSymptom(LR.vaginaItching);
vulvovaginitisTriDis.addSymptom(LR.pruritus);
vulvovaginitisTriDis.addSymptom(LR.vaginaDischargeThinBubblyGreentingedMalodorous);
Treatment vulvovaginitisTriTr1 = new Treatment("vulvovaginitisTriTr1");
vulvovaginitisTriTr1.addDrug(LR.metronidazole);
vulvovaginitisTriDis.addTreatment("vulvovaginitisTriTr1");


// ------------- ovariesCysts  -------------
Disease ovariesCystsDis = new Disease(
    LR.ovariesCysts,
    L.ovariesCystsDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    10, // minAge
    55, // maxAge
    -5, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
ovariesCystsDis.setPrintName(L.ovariesCystsPrintName);
ovariesCystsDis.addCausesDisease(LR.dyspareunia);
ovariesCystsDis.addReference("pp 924-6");
ovariesCystsDis.addSymptom(LR.abdomenDistension);
ovariesCystsDis.addSymptom(LR.abdomenPainSuddenSevere, L.ovariesCysts_abdomenPainSuddenSevere, 1.0f);
ovariesCystsDis.addSymptom(LR.abdomenRigidity);
ovariesCystsDis.addSymptom(LR.abdomenTenderness);
ovariesCystsDis.addSymptom(LR.lowBackPain, L.ovariesCysts_lowBackPain, 1.0f);
ovariesCystsDis.addSymptom(LR.pelvisDiscomfort, L.ovariesCysts_pelvisDiscomfort, 1.0f);
ovariesCystsDis.addSymptom(LR.uterusBleeding, L.ovariesCysts_uterusBleeding, 1.0f);
Treatment ovariesCystsTr1 = new Treatment("ovariesCystsTr1");
ovariesCystsTr1.addDrug(LR.clomipheneCitrate);
ovariesCystsTr1.addDrug(LR.oralContraceptives);
ovariesCystsDis.addTreatment("ovariesCystsTr1");


// ------------- endometriosis  -------------
Disease endometriosisDis = new Disease(
    LR.endometriosis,
    L.endometriosisDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    40, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
endometriosisDis.setPrintName(L.endometriosisPrintName);
endometriosisDis.addCausesDisease(LR.infertilityFemale);
endometriosisDis.addReference("pp 926-7");
endometriosisDis.addSymptom(LR.lowBackPain);
endometriosisDis.addSymptom(LR.abdomenPainLowerSide);
endometriosisDis.addSymptom(LR.menstruationPainful);
endometriosisDis.addSymptom(LR.pelvisPain);
endometriosisDis.addSymptom(LR.vaginaPain);
Treatment endometriosisTr1 = new Treatment("endometriosisTr1", LR.ifStage1Or2);
endometriosisTr1.addDrug(LR.androgens);
endometriosisTr1.addDrug(LR.progestins);
endometriosisTr1.addDrug(LR.oralContraceptives);
endometriosisDis.addTreatment("endometriosisTr1");
Treatment endometriosisTr2 = new Treatment("endometriosisTr2", LR.ifStage3Or4);
endometriosisTr2.addTreatmentAction(LR.surgery);
endometriosisDis.addTreatment("endometriosisTr2");


// ------------- endometriosisOO  -------------
Disease endometriosisOODis = new Disease(
    LR.endometriosisOO,
    L.endometriosisOODescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    40, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.ovariesSysSt,
    LR.none
);
endometriosisOODis.setPrintName(L.endometriosisOOPrintName);
endometriosisOODis.setSuperDisease(LR.endometriosis);
endometriosisOODis.addReference("pp 926-7");
endometriosisOODis.addSymptom(LR.infertilityFemaleSymptom);
endometriosisOODis.addSymptom(LR.menstruationProfuse);


// ------------- endometriosisOC  -------------
Disease endometriosisOCDis = new Disease(
    LR.endometriosisOC,
    L.endometriosisOCDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    40, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.ovariesSysSt,
    LR.none
);
endometriosisOCDis.setPrintName(L.endometriosisOCPrintName);
endometriosisOCDis.setSuperDisease(LR.endometriosis);
endometriosisOCDis.addReference("pp 926-7");
endometriosisOCDis.addSymptom(LR.deepThrustDyspareunia);


// ------------- endometriosisBladder  -------------
Disease endometriosisBladderDis = new Disease(
    LR.endometriosisBladder,
    L.endometriosisBladderDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    40, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bladderSysSt,
    LR.none
);
endometriosisBladderDis.setPrintName(L.endometriosisBladderPrintName);
endometriosisBladderDis.setSuperDisease(LR.endometriosis);
endometriosisBladderDis.addReference("pp 926-7");
endometriosisBladderDis.addSymptom(LR.dysuria);
endometriosisBladderDis.addSymptom(LR.hematuria);
endometriosisBladderDis.addSymptom(LR.pubisPain);


// ------------- endometriosisBA  -------------
Disease endometriosisBADis = new Disease(
    LR.endometriosisBA,
    L.endometriosisBADescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    40, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.smallIntestineSysSt,
    LR.none
);
endometriosisBADis.setPrintName(L.endometriosisBAPrintName);
endometriosisBADis.setSuperDisease(LR.endometriosis);
endometriosisBADis.addReference("pp 926-7");
endometriosisBADis.addSymptom(LR.abdomenCramping);
endometriosisBADis.addSymptom(LR.nausea);
endometriosisBADis.addSymptom(LR.vomiting);


// ------------- endometriosisCVP  -------------
Disease endometriosisCVPDis = new Disease(
    LR.endometriosisCVP,
    L.endometriosisCVPDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    40, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vaginagySysSt,
    LR.none
);
endometriosisCVPDis.setPrintName(L.endometriosisCVPPrintName);
endometriosisCVPDis.setSuperDisease(LR.endometriosis);
endometriosisCVPDis.addReference("pp 926-7");
endometriosisCVPDis.addSymptom(LR.bleedingFromVagina);


// ------------- menopause  -------------
Disease menopauseDis = new Disease(
    LR.menopause,
    L.menopauseDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    45, // minAge
    55, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
menopauseDis.setPrintName(L.menopausePrintName);
menopauseDis.addCausesDisease(LR.osteoporosis);
menopauseDis.addReference("pp 930-2");
menopauseDis.addSymptom(LR.atrophicVulvitis);
menopauseDis.addSymptom(LR.menstruationFlowDecrease);
menopauseDis.addSymptom(LR.menstruationIrregular);
menopauseDis.addSymptom(LR.spotting);
menopauseDis.addSymptom(LR.pelvisRelaxation);
menopauseDis.addSymptom(LR.vaginaDischarge);
menopauseDis.addSymptom(LR.vaginaDryness);
menopauseDis.addSymptom(LR.vaginaItching);
menopauseDis.addSymptom(LR.vaginaMucosaAtrophy);
menopauseDis.addSymptom(LR.dysuria);
menopauseDis.addSymptom(LR.hematuria);
menopauseDis.addSymptom(LR.incontinence);
menopauseDis.addSymptom(LR.meatalTenderness);
menopauseDis.addSymptom(LR.pyuria);
menopauseDis.addSymptom(LR.urinaryUrgency);
menopauseDis.addSymptom(LR.breastSizeDecrease);
menopauseDis.addSymptom(LR.slightAlopecia);
menopauseDis.addSymptom(LR.pubisHairLoss);
menopauseDis.addSymptom(LR.skinElasticityLoss);
menopauseDis.addSymptom(LR.cryingSpell);
menopauseDis.addSymptom(LR.dyspnea);
menopauseDis.addSymptom(LR.exacerbationOfMentalProblems);
menopauseDis.addSymptom(LR.fitOfAnger);
menopauseDis.addSymptom(LR.hotFlash);
menopauseDis.addSymptom(LR.irritability);
menopauseDis.addSymptom(LR.nervousness);
menopauseDis.addSymptom(LR.nightSweating);
menopauseDis.addSymptom(LR.syncope);
menopauseDis.addSymptom(LR.tachycardia);
menopauseDis.addSymptom(LR.tinnitus);
menopauseDis.addSymptom(LR.vertigo);
Treatment menopauseTr1 = new Treatment("menopauseTr1");
menopauseTr1.addDrug(LR.estrogen);
menopauseDis.addTreatment("menopauseTr1");


// ------------- infertilityFemale  -------------
Disease infertilityFemaleDis = new Disease(
    LR.infertilityFemale,
    L.infertilityFemaleDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    50, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
infertilityFemaleDis.setPrintName(L.infertilityFemalePrintName);
infertilityFemaleDis.setMiscComments(L.infertilityFemaleComment);
infertilityFemaleDis.addInternalCause(LR.anorexiaNervosa);
infertilityFemaleDis.addInternalCause(LR.endometriosis);
infertilityFemaleDis.addReference("pp 932-4");
infertilityFemaleDis.addSymptom(LR.infertilityFemaleSymptom);
infertilityFemaleDis.addSymptom(LR.menstruationAbsence);
infertilityFemaleDis.addSymptom(LR.menstruationInfrequent);
infertilityFemaleDis.addSymptom(LR.menstruationIrregular);
Treatment infertilityFemaleTr1 = new Treatment("infertilityFemaleTr1", LR.ifAndrenalGlandMalfunction);
infertilityFemaleTr1.addTreatmentAction(LR.hormoneTherapy);
infertilityFemaleDis.addTreatment("infertilityFemaleTr1");
Treatment infertilityFemaleTr2 = new Treatment("infertilityFemaleTr2", LR.ifThyroidGlandMalfunction);
infertilityFemaleTr2.addTreatmentAction(LR.hormoneTherapy);
infertilityFemaleDis.addTreatment("infertilityFemaleTr2");
Treatment infertilityFemaleTr3 = new Treatment("infertilityFemaleTr3", LR.ifProgesteroneDeficiency);
infertilityFemaleTr3.addDrug(LR.progesterone);
infertilityFemaleDis.addTreatment("infertilityFemaleTr3");
Treatment infertilityFemaleTr4 = new Treatment("infertilityFemaleTr4", LR.ifNoOvulation);
infertilityFemaleTr4.addDrug(LR.clomiphene);
infertilityFemaleTr4.addDrug(LR.gonadotropin);
infertilityFemaleDis.addTreatment("infertilityFemaleTr4");
Treatment infertilityFemaleTr5 = new Treatment("infertilityFemaleTr5", LR.ifEndometriosis);
infertilityFemaleTr5.addTreatmentAction(LR.surgery);
infertilityFemaleTr5.addDrug(LR.oralContraceptives);
infertilityFemaleTr5.addDrug(LR.danazol);
infertilityFemaleTr5.addDrug(LR.medroxyprogesterone);
infertilityFemaleDis.addTreatment("infertilityFemaleTr5");
Treatment infertilityFemaleTr6 = new Treatment("infertilityFemaleTr6", LR.ifAnatomicDefects);
infertilityFemaleTr6.addTreatmentAction(LR.surgery);
infertilityFemaleDis.addTreatment("infertilityFemaleTr6");


// ------------- pelvisInflammatoryDisease  -------------
Disease pelvisInflammatoryDiseaseDis = new Disease(
    LR.pelvisInflammatoryDisease,
    L.pelvisInflammatoryDiseaseDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.infection
);
pelvisInflammatoryDiseaseDis.setPrintName(L.pelvisInflammatoryDiseasePrintName);
pelvisInflammatoryDiseaseDis.setTemperature(101.5f);
pelvisInflammatoryDiseaseDis.addInternalCause(LR.chlamydialInfectionCervix);
pelvisInflammatoryDiseaseDis.addInternalCause(LR.chlamydialInfectionEndometrium);
pelvisInflammatoryDiseaseDis.addInternalCause(LR.chlamydialInfectionUrethraFemale);
pelvisInflammatoryDiseaseDis.addInternalCause(LR.gonorrheaPelvis);
pelvisInflammatoryDiseaseDis.addReference("934-6");
pelvisInflammatoryDiseaseDis.addSymptom(LR.abdomenPainLowerSide);
pelvisInflammatoryDiseaseDis.addSymptom(LR.malaise);
pelvisInflammatoryDiseaseDis.addSymptom(LR.vaginaDischargePurulent);
Treatment pelvisInflammatoryDiseaseTr1 = new Treatment("pelvisInflammatoryDiseaseTr1");
pelvisInflammatoryDiseaseTr1.addDrug(LR.antibiotics);
pelvisInflammatoryDiseaseDis.addTreatment("pelvisInflammatoryDiseaseTr1");


// ------------- salpingoOophoritis  -------------
Disease salpingoOophoritisDis = new Disease(
    LR.salpingoOophoritis,
    L.salpingoOophoritisDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
salpingoOophoritisDis.setPrintName(L.salpingoOophoritisPrintName);
salpingoOophoritisDis.setSuperDisease(LR.pelvisInflammatoryDisease);
salpingoOophoritisDis.setTemperature(101.5f);
salpingoOophoritisDis.addInternalCause(LR.chlamydialInfectionCervix);
salpingoOophoritisDis.addInternalCause(LR.chlamydialInfectionEndometrium);
salpingoOophoritisDis.addInternalCause(LR.chlamydialInfectionUrethraFemale);
salpingoOophoritisDis.addInternalCause(LR.gonorrheaPelvis);
salpingoOophoritisDis.addReference("pp 935");
salpingoOophoritisDis.addSymptom(LR.abdomenRigidity);
salpingoOophoritisDis.addSymptom(LR.abdomenTenderness);
salpingoOophoritisDis.addSymptom(LR.malaise);
salpingoOophoritisDis.addSymptom(LR.pelvisPain);
salpingoOophoritisDis.addSymptom(LR.tachycardia);


// ------------- cervicitis  -------------
Disease cervicitisDis = new Disease(
    LR.cervicitis,
    L.cervicitisDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.cervixSysSt,
    LR.none
);
cervicitisDis.setPrintName(L.cervicitisPrintName);
cervicitisDis.setSuperDisease(LR.pelvisInflammatoryDisease);
cervicitisDis.addReference("pp 935");
cervicitisDis.addSymptom(LR.infertilityFemaleSymptom);
cervicitisDis.addSymptom(LR.pelvisDiscomfort);
cervicitisDis.addSymptom(LR.vaginaDischargeFoulSmelling);
cervicitisDis.addSymptom(LR.vaginaItching);
cervicitisDis.addSymptom(LR.abortionSpontaneous);
cervicitisDis.addSymptom(LR.cervixEdematous);
cervicitisDis.addSymptom(LR.cervixRed);
cervicitisDis.addSymptom(LR.sexualDysfunction);
cervicitisDis.addSymptom(LR.vaginaBurning);


// ------------- amenorrhea  -------------
Disease amenorrheaDis = new Disease(
    LR.amenorrhea,
    L.amenorrheaDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    18, // minAge
    45, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
amenorrheaDis.setPrintName(L.amenorrheaPrintName);
amenorrheaDis.setMiscComments(L.amenorrheaComment);
amenorrheaDis.addInternalCause(LR.anorexiaNervosa);
amenorrheaDis.addInternalCause(LR.bulimiaNervosa);
amenorrheaDis.addInternalCause(LR.celiacDisease);
amenorrheaDis.addReference("pp 936-7");
amenorrheaDis.addSymptom(LR.menstruationAbsence);
Treatment amenorrheaTr1 = new Treatment("amenorrheaTr1");
amenorrheaTr1.addTreatmentAction(LR.hormoneTherapy);
amenorrheaDis.addTreatment("amenorrheaTr1");
Treatment amenorrheaTr2 = new Treatment("amenorrheaTr2", LR.ifTumor);
amenorrheaTr2.addTreatmentAction(LR.surgery);
amenorrheaDis.addTreatment("amenorrheaTr2");


// ------------- abnormalPremenopausalBleeding  -------------
Disease abnormalPremenopausalBleedingDis = new Disease(
    LR.abnormalPremenopausalBleeding,
    L.abnormalPremenopausalBleedingDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    50, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
abnormalPremenopausalBleedingDis.setPrintName(L.abnormalPremenopausalBleedingPrintName);
abnormalPremenopausalBleedingDis.addReference("pp 937-9");
abnormalPremenopausalBleedingDis.addSymptom(LR.breastTenderness, L.abnormalPremenopausalBleeding_breastTenderness, 0.1f);
abnormalPremenopausalBleedingDis.addSymptom(LR.nausea, L.abnormalPremenopausalBleeding_nausea, 0.1f);
abnormalPremenopausalBleedingDis.addSymptom(LR.uterusBleedingAbnormal);
abnormalPremenopausalBleedingDis.addSymptom(LR.bloating, L.abnormalPremenopausalBleeding_bloating, 0.1f);
Treatment abnormalPremenopausalBleedingTr1 = new Treatment("abnormalPremenopausalBleedingTr1", LR.toAchieveConception);
abnormalPremenopausalBleedingTr1.addDrug(LR.clomiphene);
abnormalPremenopausalBleedingDis.addTreatment("abnormalPremenopausalBleedingTr1");
Treatment abnormalPremenopausalBleedingTr2 = new Treatment("abnormalPremenopausalBleedingTr2", LR.ifCervixPolyps);
abnormalPremenopausalBleedingTr2.addTreatmentAction(LR.electrocautery);
abnormalPremenopausalBleedingTr2.addTreatmentAction(LR.chemicalCautery);
abnormalPremenopausalBleedingTr2.addTreatmentAction(LR.cryosurgery);
abnormalPremenopausalBleedingDis.addTreatment("abnormalPremenopausalBleedingTr2");
Treatment abnormalPremenopausalBleedingTr3 = new Treatment("abnormalPremenopausalBleedingTr3", LR.ifOrganicDisorder);
abnormalPremenopausalBleedingTr3.addTreatmentAction(LR.hysterectomy);
abnormalPremenopausalBleedingTr3.addTreatmentAction(LR.xrayTherapy);
abnormalPremenopausalBleedingDis.addTreatment("abnormalPremenopausalBleedingTr3");


// ------------- hypomenorrhea  -------------
Disease hypomenorrheaDis = new Disease(
    LR.hypomenorrhea,
    L.hypomenorrheaDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    50, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
hypomenorrheaDis.setPrintName(L.hypomenorrheaPrintName);
hypomenorrheaDis.setSuperDisease(LR.abnormalPremenopausalBleeding);
hypomenorrheaDis.addInternalCause(LR.hyperthyroidism);
hypomenorrheaDis.addCausingAbnormalCondition(LR.infectionsSevere);
hypomenorrheaDis.addCausingAbnormalCondition(LR.malnutrition);
hypomenorrheaDis.addCausingAbnormalCondition(LR.psychicTraumaSevere);
hypomenorrheaDis.addReference("pp 938");
hypomenorrheaDis.addSymptom(LR.menstruationDeficient);


// ------------- oligomenorrhea  -------------
Disease oligomenorrheaDis = new Disease(
    LR.oligomenorrhea,
    L.oligomenorrheaDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    50, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
oligomenorrheaDis.setPrintName(L.oligomenorrheaPrintName);
oligomenorrheaDis.setSuperDisease(LR.abnormalPremenopausalBleeding);
oligomenorrheaDis.addInternalCause(LR.hyperthyroidism);
oligomenorrheaDis.addCausingAbnormalCondition(LR.infectionsSevere);
oligomenorrheaDis.addCausingAbnormalCondition(LR.malnutrition);
oligomenorrheaDis.addCausingAbnormalCondition(LR.psychicTraumaSevere);
oligomenorrheaDis.addReference("pp 938");
oligomenorrheaDis.addSymptom(LR.menstruationInfrequent);


// ------------- metrorrhagia  -------------
Disease metrorrhagiaDis = new Disease(
    LR.metrorrhagia,
    L.metrorrhagiaDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    50, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
metrorrhagiaDis.setPrintName(L.metrorrhagiaPrintName);
metrorrhagiaDis.setSuperDisease(LR.abnormalPremenopausalBleeding);
metrorrhagiaDis.addInternalCause(LR.endometritis);
metrorrhagiaDis.addCausingAbnormalCondition(LR.bloodDyscrasias);
metrorrhagiaDis.addCausingAbnormalCondition(LR.uterusTumors);
metrorrhagiaDis.addReference("pp 938");
metrorrhagiaDis.addSymptom(LR.menstruationIrregular);


// ------------- polymenorrhea  -------------
Disease polymenorrheaDis = new Disease(
    LR.polymenorrhea,
    L.polymenorrheaDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    50, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
polymenorrheaDis.setPrintName(L.polymenorrheaPrintName);
polymenorrheaDis.setSuperDisease(LR.abnormalPremenopausalBleeding);
polymenorrheaDis.addInternalCause(LR.hypothyroidism);
polymenorrheaDis.addCausingAbnormalCondition(LR.bloodDyscrasias);
polymenorrheaDis.addReference("pp 938");
polymenorrheaDis.addSymptom(LR.menstruationTooFrequent);


// ------------- menorrhagia  -------------
Disease menorrhagiaDis = new Disease(
    LR.menorrhagia,
    L.menorrhagiaDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    50, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
menorrhagiaDis.setPrintName(L.menorrhagiaPrintName);
menorrhagiaDis.setSuperDisease(LR.abnormalPremenopausalBleeding);
menorrhagiaDis.addInternalCause(LR.hypothyroidism);
menorrhagiaDis.addInternalCause(LR.trichomoniasisFemale);
menorrhagiaDis.addCausingAbnormalCondition(LR.bloodDyscrasias);
menorrhagiaDis.addCausingAbnormalCondition(LR.psychicTraumaSevere);
menorrhagiaDis.addCausingAbnormalCondition(LR.uterusTumors);
menorrhagiaDis.addReference("pp 938");
menorrhagiaDis.addSymptom(LR.menstruationProfuse);


// ------------- postMenopauseBleeding  -------------
Disease postMenopauseBleedingDis = new Disease(
    LR.postMenopauseBleeding,
    L.postMenopauseBleedingDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    45, // minAge
    150, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
postMenopauseBleedingDis.setPrintName(L.postMenopauseBleedingPrintName);
postMenopauseBleedingDis.addReference("pp 940-1");
postMenopauseBleedingDis.addSymptom(LR.uterusBleedingAbnormal);
Treatment postMenopauseBleedingTr1 = new Treatment("postMenopauseBleedingTr1");
postMenopauseBleedingTr1.addTreatmentAction(LR.curettage);
postMenopauseBleedingDis.addTreatment("postMenopauseBleedingTr1");
Treatment postMenopauseBleedingTr2 = new Treatment("postMenopauseBleedingTr2");
postMenopauseBleedingTr2.addTreatmentAction(LR.hysterectomy);
postMenopauseBleedingDis.addTreatment("postMenopauseBleedingTr2");


// ------------- abortion  -------------
Disease abortionDis = new Disease(
    LR.abortion,
    L.abortionDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    13, // minAge
    50, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.uterusSysSt,
    LR.none
);
abortionDis.setPrintName(L.abortionPrintName);
abortionDis.setCode358(342);
abortionDis.setICD10code("O03");
abortionDis.addInternalCause(LR.hydatidiformMole);
abortionDis.addReference("pp 941-4");
abortionDis.addSymptom(LR.bleedingFromVagina);
abortionDis.addSymptom(LR.vaginaDischargePink, "", 0.5f);
abortionDis.addSymptom(LR.vaginaDischargeBrown, "", 0.5f);
abortionDis.addSymptom(LR.abdomenCramping);
Treatment abortionTr1 = new Treatment("abortionTr1", LR.ifSevereBleeding);
abortionTr1.addTreatmentAction(LR.hospitalization);
abortionTr1.addTreatmentAction(LR.bloodTransfusion);
abortionDis.addTreatment("abortionTr1");
Treatment abortionTr2 = new Treatment("abortionTr2", LR.ifAbortionIncomplete);
abortionTr2.addTreatmentAction(LR.curettage);
abortionDis.addTreatment("abortionTr2");


// ------------- ectopicPregnancySuper  -------------
Disease ectopicPregnancySuperDis = new Disease(
    LR.ectopicPregnancySuper,
    L.ectopicPregnancySuperDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    13, // minAge
    50, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
ectopicPregnancySuperDis.setPrintName(L.ectopicPregnancySuperPrintName);
ectopicPregnancySuperDis.addReference("pp 944-6");
ectopicPregnancySuperDis.addSymptom(LR.menstruationAbsence);
ectopicPregnancySuperDis.addSymptom(LR.menstruationDeficient);
ectopicPregnancySuperDis.addSymptom(LR.bleedingFromVaginaSlight);
ectopicPregnancySuperDis.addSymptom(LR.pelvisDiscomfort);


// ------------- ectopicPregnancy  -------------
Disease ectopicPregnancyDis = new Disease(
    LR.ectopicPregnancy,
    L.ectopicPregnancyDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    13, // minAge
    50, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
ectopicPregnancyDis.setPrintName(L.ectopicPregnancyPrintName);
ectopicPregnancyDis.setSuperDisease(LR.ectopicPregnancySuper);
ectopicPregnancyDis.setCode358(341);
ectopicPregnancyDis.setICD10code("O00");
ectopicPregnancyDis.addCausesDisease(LR.ectopicPregnancyRupture);
ectopicPregnancyDis.addReference("pp 944-6");


// ------------- ectopicPregnancyRupture  -------------
Disease ectopicPregnancyRuptureDis = new Disease(
    LR.ectopicPregnancyRupture,
    L.ectopicPregnancyRuptureDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    13, // minAge
    50, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.fallopianTubesSysSt,
    LR.none
);
ectopicPregnancyRuptureDis.setPrintName(L.ectopicPregnancyRupturePrintName);
ectopicPregnancyRuptureDis.setSuperDisease(LR.ectopicPregnancySuper);
ectopicPregnancyRuptureDis.setCode358(341);
ectopicPregnancyRuptureDis.setICD10code("O00");
ectopicPregnancyRuptureDis.addInternalCause(LR.ectopicPregnancy);
ectopicPregnancyRuptureDis.addCausesDisease(LR.peritonitis);
ectopicPregnancyRuptureDis.addCausesAbnormalCondition(LR.shock);
ectopicPregnancyRuptureDis.addReference("pp 944-6");
ectopicPregnancyRuptureDis.addSymptom(LR.hemorrhage);
ectopicPregnancyRuptureDis.addSymptom(LR.abdomenPainLowerSide);
ectopicPregnancyRuptureDis.addSymptom(LR.shoulderPain);
ectopicPregnancyRuptureDis.addSymptom(LR.neckPain);
ectopicPregnancyRuptureDis.addSymptom(LR.uterusTender);
Treatment ectopicPregnancyRuptureTr1 = new Treatment("ectopicPregnancyRuptureTr1");
ectopicPregnancyRuptureTr1.addTreatmentAction(LR.bloodTransfusion);
ectopicPregnancyRuptureTr1.addTreatmentAction(LR.surgery);
ectopicPregnancyRuptureTr1.addDrug(LR.antibiotics);
ectopicPregnancyRuptureDis.addTreatment("ectopicPregnancyRuptureTr1");


// ------------- hyperemesisGravidarum  -------------
Disease hyperemesisGravidarumDis = new Disease(
    LR.hyperemesisGravidarum,
    L.hyperemesisGravidarumDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    12, // minAge
    50, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
hyperemesisGravidarumDis.setPrintName(L.hyperemesisGravidarumPrintName);
hyperemesisGravidarumDis.addReference("pp 946-7");
hyperemesisGravidarumDis.addSymptom(LR.nausea);
hyperemesisGravidarumDis.addSymptom(LR.vomiting);
hyperemesisGravidarumDis.addSymptom(LR.weightLoss, L.hyperemesisGravidarum_weightLoss, 0.3f);
hyperemesisGravidarumDis.addSymptom(LR.skinDry, L.hyperemesisGravidarum_skinDry, 0.3f);
hyperemesisGravidarumDis.addSymptom(LR.skinPale, L.hyperemesisGravidarum_skinPale, 0.3f);
hyperemesisGravidarumDis.addSymptom(LR.skinWaxy, L.hyperemesisGravidarum_skinWaxy, 0.3f);
hyperemesisGravidarumDis.addSymptom(LR.jaundice, L.hyperemesisGravidarum_jaundice, 0.3f);
hyperemesisGravidarumDis.addSymptom(LR.pulseRapid, L.hyperemesisGravidarum_pulseRapid, 0.3f);
hyperemesisGravidarumDis.addSymptom(LR.breathStinking, L.hyperemesisGravidarum_breathStinking, 0.3f);
hyperemesisGravidarumDis.addSymptom(LR.confusion, L.hyperemesisGravidarum_confusion, 0.1f);
hyperemesisGravidarumDis.addSymptom(LR.delirium, L.hyperemesisGravidarum_delirium, 0.1f);
hyperemesisGravidarumDis.addSymptom(LR.headache, L.hyperemesisGravidarum_headache, 0.3f);
hyperemesisGravidarumDis.addSymptom(LR.weakness, L.hyperemesisGravidarum_weakness, 0.3f);
hyperemesisGravidarumDis.addSymptom(LR.stupor, L.hyperemesisGravidarum_stupor, 0.1f);
Treatment hyperemesisGravidarumTr1 = new Treatment("hyperemesisGravidarumTr1", LR.ifSevere);
hyperemesisGravidarumTr1.addTreatmentAction(LR.hospitalization);
hyperemesisGravidarumTr1.addTreatmentAction(LR.IVNutrition);
hyperemesisGravidarumDis.addTreatment("hyperemesisGravidarumTr1");


// ------------- pregnancyInducedHypertension  -------------
Disease pregnancyInducedHypertensionDis = new Disease(
    LR.pregnancyInducedHypertension,
    L.pregnancyInducedHypertensionDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    12, // minAge
    50, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vascularSysSt,
    LR.none
);
pregnancyInducedHypertensionDis.setPrintName(L.pregnancyInducedHypertensionPrintName);
pregnancyInducedHypertensionDis.setMiscComments(L.pregnancyInducedHypertensionComment);
pregnancyInducedHypertensionDis.addCausesDisease(LR.hypertension);
pregnancyInducedHypertensionDis.addReference("pp 947-9");
pregnancyInducedHypertensionDis.addSymptom(LR.edema);
pregnancyInducedHypertensionDis.addSymptom(LR.weightGain);
Treatment pregnancyInducedHypertensionTr1 = new Treatment("pregnancyInducedHypertensionTr1", LR.ifNearTerm);
pregnancyInducedHypertensionTr1.addTreatmentAction(LR.inductionOfLabor);
pregnancyInducedHypertensionDis.addTreatment("pregnancyInducedHypertensionTr1");
Treatment pregnancyInducedHypertensionTr2 = new Treatment("pregnancyInducedHypertensionTr2");
pregnancyInducedHypertensionTr2.addTreatmentAction(LR.bedRest);
pregnancyInducedHypertensionTr2.addDrug(LR.anticonvulsants);
pregnancyInducedHypertensionTr2.addDrug(LR.sedatives);
pregnancyInducedHypertensionDis.addTreatment("pregnancyInducedHypertensionTr2");


// ------------- hydatidiformMole  -------------
Disease hydatidiformMoleDis = new Disease(
    LR.hydatidiformMole,
    L.hydatidiformMoleDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.asian, // raceSpecificity
    45, // minAge
    55, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
hydatidiformMoleDis.setPrintName(L.hydatidiformMolePrintName);
hydatidiformMoleDis.setMiscComments(L.hydatidiformMoleComment);
hydatidiformMoleDis.addCausingSet(LR.infections);
hydatidiformMoleDis.addCausesDisease(LR.anemia);
hydatidiformMoleDis.addCausesDisease(LR.abortion);
hydatidiformMoleDis.addCausesDisease(LR.choriocarcinoma);
hydatidiformMoleDis.addCausesAbnormalCondition(LR.uterusRupture);
hydatidiformMoleDis.addReference("pp 949-50");
hydatidiformMoleDis.addSymptom(LR.abdomenCramping);
hydatidiformMoleDis.addSymptom(LR.bleedingFromVagina);
hydatidiformMoleDis.addSymptom(LR.menstruationAbsence);
hydatidiformMoleDis.addSymptom(LR.fetalHeartTonesAbsent);
hydatidiformMoleDis.addSymptom(LR.uterusGrowsTooFast);
Treatment hydatidiformMoleTr1 = new Treatment("hydatidiformMoleTr1");
hydatidiformMoleTr1.addTreatmentAction(LR.curettage);
hydatidiformMoleTr1.addTreatmentAction(LR.hysterectomy);
hydatidiformMoleDis.addTreatment("hydatidiformMoleTr1");


// ------------- choriocarcinoma  -------------
Disease choriocarcinomaDis = new Disease(
    LR.choriocarcinoma,
    L.choriocarcinomaDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    50, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.uterusSysSt,
    LR.none
);
choriocarcinomaDis.setPrintName(L.choriocarcinomaPrintName);
choriocarcinomaDis.setMiscComments(L.choriocarcinomaComment);
choriocarcinomaDis.addInternalCause(LR.hydatidiformMole);
choriocarcinomaDis.addReference("pp 1282-3");
choriocarcinomaDis.addSymptom(LR.pelvisPain);
choriocarcinomaDis.addSymptom(LR.bleedingFromVaginaProfuse);
Treatment choriocarcinomaTr1 = new Treatment("choriocarcinomaTr1");
choriocarcinomaTr1.addTreatmentAction(LR.curettage);
choriocarcinomaTr1.addTreatmentAction(LR.hysterectomy);
choriocarcinomaTr1.addTreatmentAction(LR.chemoTherapy);
choriocarcinomaDis.addTreatment("choriocarcinomaTr1");


// ------------- placentaPrevia  -------------
Disease placentaPreviaDis = new Disease(
    LR.placentaPrevia,
    L.placentaPreviaDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    50, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.placentaSysSt,
    LR.none
);
placentaPreviaDis.setPrintName(L.placentaPreviaPrintName);
placentaPreviaDis.addReference("pp 950-2");
placentaPreviaDis.addSymptom(LR.bleedingThirdTrimester);
Treatment placentaPreviaTr1 = new Treatment("placentaPreviaTr1");
placentaPreviaTr1.addTreatmentAction(LR.hospitalization);
placentaPreviaTr1.addTreatmentAction(LR.IVFluids);
placentaPreviaTr1.addTreatmentAction(LR.bloodTransfusion);
placentaPreviaDis.addTreatment("placentaPreviaTr1");
Treatment placentaPreviaTr2 = new Treatment("placentaPreviaTr2", LR.ifSevereBleeding);
placentaPreviaTr2.addTreatmentAction(LR.cesarianDelivery);
placentaPreviaDis.addTreatment("placentaPreviaTr2");


// ------------- abruptioPlacentae  -------------
Disease abruptioPlacentaeDis = new Disease(
    LR.abruptioPlacentae,
    L.abruptioPlacentaeDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    35, // minAge
    50, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.placentaSysSt,
    LR.none
);
abruptioPlacentaeDis.setPrintName(L.abruptioPlacentaePrintName);
abruptioPlacentaeDis.setMiscComments(L.abruptioPlacentaeComment);
abruptioPlacentaeDis.addReference("pp 952-4");
abruptioPlacentaeDis.addSymptom(LR.abdomenPain);
abruptioPlacentaeDis.addSymptom(LR.bleedingGestation2ndHalf);
abruptioPlacentaeDis.addSymptom(LR.uterusIrritation);
Treatment abruptioPlacentaeTr1 = new Treatment("abruptioPlacentaeTr1");
abruptioPlacentaeTr1.addTreatmentAction(LR.IVFluids);
abruptioPlacentaeTr1.addTreatmentAction(LR.hospitalization);
abruptioPlacentaeDis.addTreatment("abruptioPlacentaeTr1");


// ------------- cardiovascularDiseaseInPregnancy  -------------
Disease cardiovascularDiseaseInPregnancyDis = new Disease(
    LR.cardiovascularDiseaseInPregnancy,
    L.cardiovascularDiseaseInPregnancyDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.cardioVascularSysSt,
    LR.none
);
cardiovascularDiseaseInPregnancyDis.setPrintName(L.cardiovascularDiseaseInPregnancyPrintName);
cardiovascularDiseaseInPregnancyDis.setMiscComments(L.cardiovascularDiseaseInPregnancyComment);
cardiovascularDiseaseInPregnancyDis.addInternalCause(LR.rheumaticHeartDisease);
cardiovascularDiseaseInPregnancyDis.addCausesAbnormalCondition(LR.cardiacEnlargement);
cardiovascularDiseaseInPregnancyDis.addCausesAbnormalCondition(LR.diastolicMurmurs);
cardiovascularDiseaseInPregnancyDis.addReference("pp 954-6");
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.arrhythmia);
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.neckVeinsElevated);
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.crackles);
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.cyanosis);
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.pulseDelay);
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.pulsusAlternans);
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.dyspnea, L.cardiovascularDiseaseInPregnancy_dyspnea, 0.2f);
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.edema, L.cardiovascularDiseaseInPregnancy_edema, 0.2f);
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.hemoptysis, L.cardiovascularDiseaseInPregnancy_hemoptysis, 0.2f);
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.palpitations, L.cardiovascularDiseaseInPregnancy_palpitations, 0.2f);
Treatment cardiovascularDiseaseInPregnancyTr1 = new Treatment("cardiovascularDiseaseInPregnancyTr1", LR.ifSevere);
cardiovascularDiseaseInPregnancyTr1.addTreatmentAction(LR.hospitalization);
cardiovascularDiseaseInPregnancyDis.addTreatment("cardiovascularDiseaseInPregnancyTr1");


// ------------- diabetesComplicationsInPregnancy  -------------
Disease diabetesComplicationsInPregnancyDis = new Disease(
    LR.diabetesComplicationsInPregnancy,
    L.diabetesComplicationsInPregnancyDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    50, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.endocrineSysSt,
    LR.none
);
diabetesComplicationsInPregnancyDis.setPrintName(L.diabetesComplicationsInPregnancyPrintName);
diabetesComplicationsInPregnancyDis.setSuperDisease(LR.diabetesMellitusSuper);
diabetesComplicationsInPregnancyDis.setGenetic("1parent");
diabetesComplicationsInPregnancyDis.setParentDisease(LR.diabetes);
diabetesComplicationsInPregnancyDis.addInternalCause(LR.pregnancyInducedHypertension);
diabetesComplicationsInPregnancyDis.addInternalCause(LR.candidiasis);
diabetesComplicationsInPregnancyDis.addInternalCause(LR.obesity);
diabetesComplicationsInPregnancyDis.addCausesAbnormalCondition(LR.glycosuria);
diabetesComplicationsInPregnancyDis.addCausesAbnormalCondition(LR.polyhydramnios);
diabetesComplicationsInPregnancyDis.addReference("pp 958-60");
diabetesComplicationsInPregnancyDis.addSymptom(LR.hungerExcessive);
diabetesComplicationsInPregnancyDis.addSymptom(LR.thirstExcessive);
diabetesComplicationsInPregnancyDis.addSymptom(LR.weightGainExcessive);
Treatment diabetesComplicationsInPregnancyTr1 = new Treatment("diabetesComplicationsInPregnancyTr1", LR.toControlGlucoseLevel);
diabetesComplicationsInPregnancyTr1.addDrug(LR.insulin);
diabetesComplicationsInPregnancyDis.addTreatment("diabetesComplicationsInPregnancyTr1");


// ------------- prematureLabor  -------------
Disease prematureLaborDis = new Disease(
    LR.prematureLabor,
    L.prematureLaborDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    50, // maxAge
    -2, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
prematureLaborDis.setPrintName(L.prematureLaborPrintName);
prematureLaborDis.addReference("pp 960-2");
prematureLaborDis.addSymptom(LR.amnioticMembraneRupture, "", 0.5f);
prematureLaborDis.addSymptom(LR.cervixDilation);
prematureLaborDis.addSymptom(LR.uterusContractions);
prematureLaborDis.addSymptom(LR.vaginaDischargeBloody);
Treatment prematureLaborTr1 = new Treatment("prematureLaborTr1", LR.ifSuppressLabor);
prematureLaborTr1.addTreatmentAction(LR.bedRest);
prematureLaborTr1.addDrug(LR.betaAdrenergicStimulants);
prematureLaborTr1.addDrug(LR.magnesiumSulfate);
prematureLaborDis.addTreatment("prematureLaborTr1");


// ------------- prematureRuptureOfTheMembranes  -------------
Disease prematureRuptureOfTheMembranesDis = new Disease(
    LR.prematureRuptureOfTheMembranes,
    L.prematureRuptureOfTheMembranesDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    13, // minAge
    50, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.none
);
prematureRuptureOfTheMembranesDis.setPrintName(L.prematureRuptureOfTheMembranesPrintName);
prematureRuptureOfTheMembranesDis.addReference("pp 962-4");
prematureRuptureOfTheMembranesDis.addSymptom(LR.amnioticMembraneRupture);
prematureRuptureOfTheMembranesDis.addSymptom(LR.vaginaDischargeFoulSmelling, L.prematureRuptureOfTheMembranes_vaginaDischargeFoulSmelling, 0.1f);
Treatment prematureRuptureOfTheMembranesTr1 = new Treatment("prematureRuptureOfTheMembranesTr1", LR.ifNoSpontaneousLabor);
prematureRuptureOfTheMembranesTr1.addTreatmentAction(LR.inductionOfLabor);
prematureRuptureOfTheMembranesTr1.addDrug(LR.oxytocin);
prematureRuptureOfTheMembranesDis.addTreatment("prematureRuptureOfTheMembranesTr1");


// ------------- mastitis  -------------
Disease mastitisDis = new Disease(
    LR.mastitis,
    L.mastitisDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    13, // minAge
    50, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mammaryGlandsSysSt,
    LR.none
);
mastitisDis.setPrintName(L.mastitisPrintName);
mastitisDis.setMiscComments(L.mastitisComment);
mastitisDis.setTemperature(101.0f);
mastitisDis.addReference("pp 967-70");
mastitisDis.addSymptom(LR.malaise);
mastitisDis.addSymptom(LR.breastHard);
mastitisDis.addSymptom(LR.breastSwelling);
mastitisDis.addSymptom(LR.breastTenderness);
mastitisDis.addSymptom(LR.breastWarm);
Treatment mastitisTr1 = new Treatment("mastitisTr1");
mastitisTr1.addDrug(LR.antibiotics);
mastitisDis.addTreatment("mastitisTr1");
Treatment mastitisTr2 = new Treatment("mastitisTr2", LR.ifPain);
mastitisTr2.addDrug(LR.analgetics);
mastitisDis.addTreatment("mastitisTr2");
Treatment mastitisTr3 = new Treatment("mastitisTr3", LR.ifSevere);
mastitisTr3.addTreatmentAction(LR.surgery);
mastitisDis.addTreatment("mastitisTr3");


// ------------- breastEngorgement  -------------
Disease breastEngorgementDis = new Disease(
    LR.breastEngorgement,
    L.breastEngorgementDescription,
    LR.gynecologicDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    13, // minAge
    50, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mammaryGlandsSysSt,
    LR.none
);
breastEngorgementDis.setPrintName(L.breastEngorgementPrintName);
breastEngorgementDis.setTemperature(101.0f);
breastEngorgementDis.addSymptom(LR.breastHard);
breastEngorgementDis.addSymptom(LR.breastSwelling);
breastEngorgementDis.addSymptom(LR.breastTenderness);
breastEngorgementDis.addSymptom(LR.breastWarm);
Treatment breastEngorgementTr1 = new Treatment("breastEngorgementTr1", LR.ifPain);
breastEngorgementTr1.addDrug(LR.analgetics);
breastEngorgementDis.addTreatment("breastEngorgementTr1");
Treatment breastEngorgementTr2 = new Treatment("breastEngorgementTr2");
breastEngorgementTr2.addTreatmentAction(LR.icePack);
breastEngorgementTr2.addTreatmentAction(LR.upliftSupportBra);
breastEngorgementDis.addTreatment("breastEngorgementTr2");


// ------------- galactorrhea  -------------
Disease galactorrheaDis = new Disease(
    LR.galactorrhea,
    L.galactorrheaDescription,
    LR.gynecologicDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    13, // minAge
    50, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mammaryGlandsSysSt,
    LR.none
);
galactorrheaDis.setPrintName(L.galactorrheaPrintName);
galactorrheaDis.setMiscComments(L.galactorrheaComment);
galactorrheaDis.addReference("pp 970");
galactorrheaDis.addSymptom(LR.lactationAbnormal);
Treatment galactorrheaTr1 = new Treatment("galactorrheaTr1");
galactorrheaTr1.addDrug(LR.estrogen);
galactorrheaTr1.addDrug(LR.progestins);
galactorrheaTr1.addDrug(LR.bromocriptine);
galactorrheaDis.addTreatment("galactorrheaTr1");


// ------------- hyperbilirubinemia  -------------
Disease hyperbilirubinemiaDis = new Disease(
    LR.hyperbilirubinemia,
    L.hyperbilirubinemiaDescription,
    LR.gynecologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    1, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
hyperbilirubinemiaDis.setPrintName(L.hyperbilirubinemiaPrintName);
hyperbilirubinemiaDis.setMiscComments(L.hyperbilirubinemiaComment);
hyperbilirubinemiaDis.addReference("pp 971-3");
hyperbilirubinemiaDis.addSymptom(LR.jaundice);


// ------------- hyperbilirubinemiaPhysiologic  -------------
Disease hyperbilirubinemiaPhysiologicDis = new Disease(
    LR.hyperbilirubinemiaPhysiologic,
    L.hyperbilirubinemiaPhysiologicDescription,
    LR.gynecologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    1, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
hyperbilirubinemiaPhysiologicDis.setPrintName(L.hyperbilirubinemiaPhysiologicPrintName);
hyperbilirubinemiaPhysiologicDis.setSuperDisease(LR.hyperbilirubinemia);
hyperbilirubinemiaPhysiologicDis.setMiscComments(L.hyperbilirubinemiaPhysiologicComment);
hyperbilirubinemiaPhysiologicDis.addReference("pp 971-3");
hyperbilirubinemiaPhysiologicDis.addSymptom(LR.jaundice);
Treatment hyperbilirubinemiaPhysiologicTr1 = new Treatment("hyperbilirubinemiaPhysiologicTr1");
hyperbilirubinemiaPhysiologicTr1.addTreatmentAction(LR.phototherapy);
hyperbilirubinemiaPhysiologicDis.addTreatment("hyperbilirubinemiaPhysiologicTr1");


// ------------- hyperbilirubinemiaPathologic  -------------
Disease hyperbilirubinemiaPathologicDis = new Disease(
    LR.hyperbilirubinemiaPathologic,
    L.hyperbilirubinemiaPathologicDescription,
    LR.gynecologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    1, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
hyperbilirubinemiaPathologicDis.setPrintName(L.hyperbilirubinemiaPathologicPrintName);
hyperbilirubinemiaPathologicDis.setSuperDisease(LR.hyperbilirubinemia);
hyperbilirubinemiaPathologicDis.setMiscComments(L.hyperbilirubinemiaPathologicComment);
hyperbilirubinemiaPathologicDis.addReference("pp 971-3");
hyperbilirubinemiaPathologicDis.addSymptom(LR.jaundice);
Treatment hyperbilirubinemiaPathologicTr2 = new Treatment("hyperbilirubinemiaPathologicTr2");
hyperbilirubinemiaPathologicTr2.addTreatmentAction(LR.bloodTransfusion);
hyperbilirubinemiaPathologicDis.addTreatment("hyperbilirubinemiaPathologicTr2");
} // end of gynecologicDisorders





// ------------- hematologicDisorders  -------------
static public void hematologicDisorders() { 


// ------------- anemia  -------------
Disease anemiaDis = new Disease(
    LR.anemia,
    L.anemiaDescription,
    LR.hematologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.hematologicSysSt,
    LR.none
);
anemiaDis.setPrintName(L.anemiaPrintName);
anemiaDis.addInternalCause(LR.benignProstaticHyperplasia2);
anemiaDis.addInternalCause(LR.bronchiectasis);
anemiaDis.addInternalCause(LR.celiacDisease);
anemiaDis.addInternalCause(LR.cervixCancerAdvanced);
anemiaDis.addInternalCause(LR.colorectalCancer);
anemiaDis.addInternalCause(LR.hirschsprungChild);
anemiaDis.addInternalCause(LR.hirschsprungAdult);
anemiaDis.addInternalCause(LR.hodgkinDisease2);
anemiaDis.addInternalCause(LR.hydatidiformMole);
anemiaDis.addInternalCause(LR.hypersplenism);
anemiaDis.addInternalCause(LR.leukemia);
anemiaDis.addInternalCause(LR.multipleMyeloma);
anemiaDis.addInternalCause(LR.pyelonephritisChronic);
anemiaDis.addInternalCause(LR.stomachCancerAdvanced);
anemiaDis.addInternalCause(LR.syphilisLateBenign);
anemiaDis.addInternalCause(LR.tubularNecrosisAcute);
anemiaDis.addInternalCause(LR.ulcerativeColitis);
anemiaDis.addInternalCause(LR.vitaminCDeficiency);
anemiaDis.addReference("pp 1021-36");


// ------------- anemiaFolicAcidDeficiency  -------------
Disease anemiaFolicAcidDeficiencyDis = new Disease(
    LR.anemiaFolicAcidDeficiency,
    L.anemiaFolicAcidDeficiencyDescription,
    LR.hematologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    2, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.hematologicSysSt,
    LR.alcoholAbuse
);
anemiaFolicAcidDeficiencyDis.setPrintName(L.anemiaFolicAcidDeficiencyPrintName);
anemiaFolicAcidDeficiencyDis.setSuperDisease(LR.anemia);
anemiaFolicAcidDeficiencyDis.addExternalCause(LR.excessiveCooking);
anemiaFolicAcidDeficiencyDis.addExternalCause(LR.dietPoor);
anemiaFolicAcidDeficiencyDis.addCausingAbnormalCondition(LR.pregnancy);
anemiaFolicAcidDeficiencyDis.addCausingAbnormalCondition(LR.lactating);
anemiaFolicAcidDeficiencyDis.addCausesDisease(LR.glossitis);
anemiaFolicAcidDeficiencyDis.addReference("pp 1025-6");
anemiaFolicAcidDeficiencyDis.addSymptom(LR.anorexia);
anemiaFolicAcidDeficiencyDis.addSymptom(LR.breathlessness);
anemiaFolicAcidDeficiencyDis.addSymptom(LR.fainting);
anemiaFolicAcidDeficiencyDis.addSymptom(LR.fatigue);
anemiaFolicAcidDeficiencyDis.addSymptom(LR.forgetfulness);
anemiaFolicAcidDeficiencyDis.addSymptom(LR.headache);
anemiaFolicAcidDeficiencyDis.addSymptom(LR.irritability);
anemiaFolicAcidDeficiencyDis.addSymptom(LR.jaundice);
anemiaFolicAcidDeficiencyDis.addSymptom(LR.nausea);
anemiaFolicAcidDeficiencyDis.addSymptom(LR.pallor);
anemiaFolicAcidDeficiencyDis.addSymptom(LR.palpitations);
anemiaFolicAcidDeficiencyDis.addSymptom(LR.weakness);
Treatment anemiaFolicAcidDeficiencyTr1 = new Treatment("anemiaFolicAcidDeficiencyTr1");
anemiaFolicAcidDeficiencyTr1.addDrug(LR.folicAcidSupplement);
anemiaFolicAcidDeficiencyDis.addTreatment("anemiaFolicAcidDeficiencyTr1");


// ------------- disseminatedIntravascularCoagulation  -------------
Disease disseminatedIntravascularCoagulationDis = new Disease(
    LR.disseminatedIntravascularCoagulation,
    L.disseminatedIntravascularCoagulationDescription,
    LR.hematologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.hematologicSysSt,
    LR.none
);
disseminatedIntravascularCoagulationDis.setPrintName(L.disseminatedIntravascularCoagulationPrintName);
disseminatedIntravascularCoagulationDis.addInternalCause(LR.necrotizingEnterocolitis);
disseminatedIntravascularCoagulationDis.addInternalCause(LR.malaria2);
disseminatedIntravascularCoagulationDis.addInternalCause(LR.meningococcemiaSevere);
disseminatedIntravascularCoagulationDis.addReference("pp 1052-5");
disseminatedIntravascularCoagulationDis.addSymptom(LR.bleedingAbnormal);
disseminatedIntravascularCoagulationDis.addSymptom(LR.bruising);
disseminatedIntravascularCoagulationDis.addSymptom(LR.hypotension);
Treatment disseminatedIntravascularCoagulationTr1 = new Treatment("disseminatedIntravascularCoagulationTr1");
disseminatedIntravascularCoagulationTr1.addTreatmentAction(LR.IVFluids);
disseminatedIntravascularCoagulationTr1.addTreatmentAction(LR.bloodTransfusion);
disseminatedIntravascularCoagulationTr1.addTreatmentAction(LR.platelets);
disseminatedIntravascularCoagulationTr1.addTreatmentAction(LR.freshFrozenPlasma);
disseminatedIntravascularCoagulationTr1.addTreatmentAction(LR.pressureDressing);
disseminatedIntravascularCoagulationDis.addTreatment("disseminatedIntravascularCoagulationTr1");


// ------------- hypersplenism  -------------
Disease hypersplenismDis = new Disease(
    LR.hypersplenism,
    L.hypersplenismDescription,
    LR.hematologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.spleenSysSt,
    LR.none
);
hypersplenismDis.setPrintName(L.hypersplenismPrintName);
hypersplenismDis.addInternalCause(LR.malaria);
hypersplenismDis.addInternalCause(LR.polycythemiaVera);
hypersplenismDis.addInternalCause(LR.rheumatoidArthritis);
hypersplenismDis.addCausesDisease(LR.anemia);
hypersplenismDis.addCausesAbnormalCondition(LR.splenomegaly);
hypersplenismDis.addCausesAbnormalCondition(LR.leukopenia);
hypersplenismDis.addCausesAbnormalCondition(LR.thrombocytopenia);
hypersplenismDis.addReference("pp 1057-9");
hypersplenismDis.addSymptom(LR.palpitations);
hypersplenismDis.addSymptom(LR.weakness);
hypersplenismDis.addSymptom(LR.bruising);
hypersplenismDis.addSymptom(LR.bleedingSpontaneously);
hypersplenismDis.addSymptom(LR.ulcer, L.hypersplenism_ulcer, 0.8f);


// ------------- idiopathicThrombocytopenicPurpura  -------------
Disease idiopathicThrombocytopenicPurpuraDis = new Disease(
    LR.idiopathicThrombocytopenicPurpura,
    L.idiopathicThrombocytopenicPurpuraDescription,
    LR.hematologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.hematologicSysSt,
    LR.none
);
idiopathicThrombocytopenicPurpuraDis.setPrintName(L.idiopathicThrombocytopenicPurpuraPrintName);
idiopathicThrombocytopenicPurpuraDis.addReference("pp 1049-51");
idiopathicThrombocytopenicPurpuraDis.addSymptom(LR.bleedingFromMouth);
idiopathicThrombocytopenicPurpuraDis.addSymptom(LR.bleedingFromNose);
idiopathicThrombocytopenicPurpuraDis.addSymptom(LR.ecchymoses);
idiopathicThrombocytopenicPurpuraDis.addSymptom(LR.petechiae);


// ------------- idiopathicThrombocytopenicPurpuraAcute  -------------
Disease idiopathicThrombocytopenicPurpuraAcuteDis = new Disease(
    LR.idiopathicThrombocytopenicPurpuraAcute,
    L.idiopathicThrombocytopenicPurpuraAcuteDescription,
    LR.hematologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    6, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.hematologicSysSt,
    LR.none
);
idiopathicThrombocytopenicPurpuraAcuteDis.setPrintName(L.idiopathicThrombocytopenicPurpuraAcutePrintName);
idiopathicThrombocytopenicPurpuraAcuteDis.setSuperDisease(LR.idiopathicThrombocytopenicPurpura);
idiopathicThrombocytopenicPurpuraAcuteDis.addReference("pp 1049-51");
Treatment idiopathicThrombocytopenicPurpuraAcuteTr1 = new Treatment("idiopathicThrombocytopenicPurpuraAcuteTr1");
idiopathicThrombocytopenicPurpuraAcuteTr1.addDrug(LR.glucocorticoids);
idiopathicThrombocytopenicPurpuraAcuteDis.addTreatment("idiopathicThrombocytopenicPurpuraAcuteTr1");


// ------------- idiopathicThrombocytopenicPurpuraChronic  -------------
Disease idiopathicThrombocytopenicPurpuraChronicDis = new Disease(
    LR.idiopathicThrombocytopenicPurpuraChronic,
    L.idiopathicThrombocytopenicPurpuraChronicDescription,
    LR.hematologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    18, // minAge
    55, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.hematologicSysSt,
    LR.none
);
idiopathicThrombocytopenicPurpuraChronicDis.setPrintName(L.idiopathicThrombocytopenicPurpuraChronicPrintName);
idiopathicThrombocytopenicPurpuraChronicDis.setSuperDisease(LR.idiopathicThrombocytopenicPurpura);
idiopathicThrombocytopenicPurpuraChronicDis.addReference("pp 1049-51");
Treatment idiopathicThrombocytopenicPurpuraChronicTr1 = new Treatment("idiopathicThrombocytopenicPurpuraChronicTr1");
idiopathicThrombocytopenicPurpuraChronicTr1.addDrug(LR.corticosteroids);
idiopathicThrombocytopenicPurpuraChronicDis.addTreatment("idiopathicThrombocytopenicPurpuraChronicTr1");
Treatment idiopathicThrombocytopenicPurpuraChronicTr2 = new Treatment("idiopathicThrombocytopenicPurpuraChronicTr2", LR.ifSevere);
idiopathicThrombocytopenicPurpuraChronicTr2.addTreatmentAction(LR.splenectomy);
idiopathicThrombocytopenicPurpuraChronicDis.addTreatment("idiopathicThrombocytopenicPurpuraChronicTr2");


// ------------- polycythemiaVera  -------------
Disease polycythemiaVeraDis = new Disease(
    LR.polycythemiaVera,
    L.polycythemiaVeraDescription,
    LR.hematologicDisorders,
    LR.moreMale, // genderSpecificity
    LR.jewishAmerican, // raceSpecificity
    40, // minAge
    60, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.hematologicSysSt,
    LR.none
);
polycythemiaVeraDis.setPrintName(L.polycythemiaVeraPrintName);
polycythemiaVeraDis.addCausesAbnormalCondition(LR.hypervolemia);
polycythemiaVeraDis.addReference("pp 1036-9");
polycythemiaVeraDis.addSymptom(LR.cyanosis);
polycythemiaVeraDis.addSymptom(LR.dizziness);
polycythemiaVeraDis.addSymptom(LR.headache);
polycythemiaVeraDis.addSymptom(LR.digitsClubbing);
polycythemiaVeraDis.addSymptom(LR.noseCyanosis);
Treatment polycythemiaVeraTr1 = new Treatment("polycythemiaVeraTr1");
polycythemiaVeraTr1.addTreatmentAction(LR.phlebotomy);
polycythemiaVeraDis.addTreatment("polycythemiaVeraTr1");
} // end of hematologicDisorders





// ------------- hepatobiliaryDisorders  -------------
static public void hepatobiliaryDisorders() { 


// ------------- bleedingEsophagealVarices  -------------
Disease bleedingEsophagealVaricesDis = new Disease(
    LR.bleedingEsophagealVarices,
    L.bleedingEsophagealVaricesDescription,
    LR.hepatobiliaryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.esophagusSysSt,
    LR.none
);
bleedingEsophagealVaricesDis.setPrintName(L.bleedingEsophagealVaricesPrintName);
bleedingEsophagealVaricesDis.addReference("pp 738-9");
bleedingEsophagealVaricesDis.addSymptom(LR.anxiety);
bleedingEsophagealVaricesDis.addSymptom(LR.hypotension);
bleedingEsophagealVaricesDis.addSymptom(LR.respirationDistress);
bleedingEsophagealVaricesDis.addSymptom(LR.skinClammy);
bleedingEsophagealVaricesDis.addSymptom(LR.skinCold);
bleedingEsophagealVaricesDis.addSymptom(LR.tachycardia);
bleedingEsophagealVaricesDis.addSymptom(LR.vomitBloody);
Treatment bleedingEsophagealVaricesTr1 = new Treatment("bleedingEsophagealVaricesTr1");
bleedingEsophagealVaricesTr1.addTreatmentAction(LR.IVFluids);
bleedingEsophagealVaricesTr1.addTreatmentAction(LR.endotrachealIntubation);
bleedingEsophagealVaricesTr1.addTreatmentAction(LR.mechanicalVentilation);
bleedingEsophagealVaricesTr1.addTreatmentAction(LR.surgery);
bleedingEsophagealVaricesTr1.addTreatmentAction(LR.bloodTransfusion);
bleedingEsophagealVaricesTr1.addTreatmentAction(LR.MinnesotaTube);
bleedingEsophagealVaricesTr1.addDrug(LR.vasopressin);
bleedingEsophagealVaricesDis.addTreatment("bleedingEsophagealVaricesTr1");


// ------------- hepatitis  -------------
Disease hepatitisDis = new Disease(
    LR.hepatitis,
    L.hepatitisDescription,
    LR.hepatobiliaryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.hepatobiliarySysSt,
    LR.none
);
hepatitisDis.setPrintName(L.hepatitisPrintName);
hepatitisDis.setMiscComments(L.hepatitisComment);
hepatitisDis.addInternalCause(LR.lymeDisease1);
hepatitisDis.addInternalCause(LR.sarcoidosisHepatic);
hepatitisDis.addInternalCause(LR.toxoplasmosisAcquiredAdvanced);
hepatitisDis.addCausesAbnormalCondition(LR.hepatomegaly);
hepatitisDis.addReference("pp 733-6");
hepatitisDis.addSymptom(LR.anorexia);
hepatitisDis.addSymptom(LR.pruritus, "", 0.3f);
hepatitisDis.addSymptom(LR.stoolClayColored);
hepatitisDis.addSymptom(LR.urineDark);


// ------------- hepatitisViral  -------------
Disease hepatitisViralDis = new Disease(
    LR.hepatitisViral,
    L.hepatitisViralDescription,
    LR.hepatobiliaryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    F.hepatitisViralFreq, // diagnosis frequency, -1 = unknown
    LR.hepatobiliarySysSt,
    LR.none
);
hepatitisViralDis.setPrintName(L.hepatitisViralPrintName);
hepatitisViralDis.setSuperDisease(LR.hepatitis);
hepatitisViralDis.setCode358(47);
hepatitisViralDis.setICD10code("B15");
hepatitisViralDis.addReference("pp 733-6");


// ------------- hepatitisProdromal  -------------
Disease hepatitisProdromalDis = new Disease(
    LR.hepatitisProdromal,
    L.hepatitisProdromalDescription,
    LR.hepatobiliaryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.hepatitisProdromalFreq, // diagnosis frequency, -1 = unknown
    LR.hepatobiliarySysSt,
    LR.none
);
hepatitisProdromalDis.setPrintName(L.hepatitisProdromalPrintName);
hepatitisProdromalDis.setSuperDisease(LR.hepatitisViral);
hepatitisProdromalDis.setMiscComments(L.hepatitisProdromalComment);
hepatitisProdromalDis.setTemperature(101.0f);
hepatitisProdromalDis.setCode358(47);
hepatitisProdromalDis.setICD10code("B15");
hepatitisProdromalDis.addCausesDisease(LR.hepatitisJaundice);
hepatitisProdromalDis.addReference("pp 733-6");
hepatitisProdromalDis.addSymptom(LR.arthralgia);
hepatitisProdromalDis.addSymptom(LR.fatigue);
hepatitisProdromalDis.addSymptom(LR.headache);
hepatitisProdromalDis.addSymptom(LR.malaise);
hepatitisProdromalDis.addSymptom(LR.myalgia);
hepatitisProdromalDis.addSymptom(LR.nausea);
hepatitisProdromalDis.addSymptom(LR.vomiting);
hepatitisProdromalDis.addSymptom(LR.weakness);
hepatitisProdromalDis.addSymptom(LR.weightLoss);


// ------------- hepatitisJaundice  -------------
Disease hepatitisJaundiceDis = new Disease(
    LR.hepatitisJaundice,
    L.hepatitisJaundiceDescription,
    LR.hepatobiliaryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    2, // minAge
    150, // maxAge
    -5, // duration
    F.hepatitisJaundiceFreq, // diagnosis frequency, -1 = unknown
    LR.hepatobiliarySysSt,
    LR.none
);
hepatitisJaundiceDis.setPrintName(L.hepatitisJaundicePrintName);
hepatitisJaundiceDis.setSuperDisease(LR.hepatitisViral);
hepatitisJaundiceDis.setTemperature(101.0f);
hepatitisJaundiceDis.setCode358(47);
hepatitisJaundiceDis.setICD10code("B15");
hepatitisJaundiceDis.addInternalCause(LR.hepatitisProdromal);
hepatitisJaundiceDis.addReference("pp 733-6");
hepatitisJaundiceDis.addSymptom(LR.abdomenPain);
hepatitisJaundiceDis.addSymptom(LR.dyspepsia);
hepatitisJaundiceDis.addSymptom(LR.jaundice);
hepatitisJaundiceDis.addSymptom(LR.rash);
hepatitisJaundiceDis.addSymptom(LR.rashRed);
hepatitisJaundiceDis.addSymptom(LR.urticaria);


// ------------- hepatitisNonViral  -------------
Disease hepatitisNonViralDis = new Disease(
    LR.hepatitisNonViral,
    L.hepatitisNonViralDescription,
    LR.hepatobiliaryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    2, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.hepatobiliarySysSt,
    LR.none
);
hepatitisNonViralDis.setPrintName(L.hepatitisNonViralPrintName);
hepatitisNonViralDis.setSuperDisease(LR.hepatitis);
hepatitisNonViralDis.addReference("pp 733-6");
hepatitisNonViralDis.addSymptom(LR.abdomenPain);
hepatitisNonViralDis.addSymptom(LR.jaundice);
hepatitisNonViralDis.addSymptom(LR.nausea);
hepatitisNonViralDis.addSymptom(LR.vomiting);


// ------------- cirrhosis  -------------
Disease cirrhosisDis = new Disease(
    LR.cirrhosis,
    L.cirrhosisDescription,
    LR.hepatobiliaryDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.hepatobiliarySysSt,
    LR.none
);
cirrhosisDis.setPrintName(L.cirrhosisPrintName);
cirrhosisDis.setMiscComments(L.cirrhosisComment);
cirrhosisDis.setCode358(298);
cirrhosisDis.setICD10code("K70");
cirrhosisDis.addInternalCause(LR.ulcerativeColitis);
cirrhosisDis.addReference("pp 736-40");
cirrhosisDis.addSymptom(LR.anorexia);
cirrhosisDis.addSymptom(LR.abdomenPain);
cirrhosisDis.addSymptom(LR.dyspepsia);
cirrhosisDis.addSymptom(LR.nausea);
cirrhosisDis.addSymptom(LR.vomiting);
Treatment cirrhosisTr1 = new Treatment("cirrhosisTr1");
cirrhosisTr1.addTreatmentAction(LR.dietHighCalorie);
cirrhosisDis.addTreatment("cirrhosisTr1");


// ------------- cholelithiasis  -------------
Disease cholelithiasisDis = new Disease(
    LR.cholelithiasis,
    L.cholelithiasisDescription,
    LR.hepatobiliaryDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gallbladderSysSt,
    LR.none
);
cholelithiasisDis.setPrintName(L.cholelithiasisPrintName);
cholelithiasisDis.setCode358(302);
cholelithiasisDis.setICD10code("K80");
cholelithiasisDis.addInternalCause(LR.celiacDisease);
cholelithiasisDis.addInternalCause(LR.diabetesMellitus);
cholelithiasisDis.addInternalCause(LR.pancreatitis);
cholelithiasisDis.addCausingAbnormalCondition(LR.pregnancy);
cholelithiasisDis.addReference("pp 747-50");
cholelithiasisDis.addSymptom(LR.abdomenPainUpperSide, L.cholelithiasis_abdomenPainUpperSide, 1.0f);
cholelithiasisDis.addSymptom(LR.backPain, L.cholelithiasis_backPain, 0.3f);
cholelithiasisDis.addSymptom(LR.belching, "", 0.3f);
cholelithiasisDis.addSymptom(LR.chestPain, "", 0.3f);
cholelithiasisDis.addSymptom(LR.chills, "", 0.3f);
cholelithiasisDis.addSymptom(LR.diaphoresis, "", 0.3f);
cholelithiasisDis.addSymptom(LR.gas, "", 0.3f);
cholelithiasisDis.addSymptom(LR.dyspepsia, "", 0.3f);
cholelithiasisDis.addSymptom(LR.jaundice, "", 0.3f);
cholelithiasisDis.addSymptom(LR.nausea, "", 0.3f);
cholelithiasisDis.addSymptom(LR.vomiting, "", 0.3f);
Treatment cholelithiasisTr1 = new Treatment("cholelithiasisTr1");
cholelithiasisTr1.addTreatmentAction(LR.surgery);
cholelithiasisTr1.addTreatmentAction(LR.dietLowFat);
cholelithiasisTr1.addDrug(LR.vitaminK);
cholelithiasisDis.addTreatment("cholelithiasisTr1");
} // end of hepatobiliaryDisorders





// ------------- immuneDisorders  -------------
static public void immuneDisorders() { 


// ------------- acquiredImmunoDeficiencySyndrome  -------------
Disease acquiredImmunoDeficiencySyndromeDis = new Disease(
    LR.acquiredImmunoDeficiencySyndrome,
    L.acquiredImmunoDeficiencySyndromeDescription,
    LR.immuneDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.immuneSysSt,
    LR.HIVInfection
);
acquiredImmunoDeficiencySyndromeDis.setPrintName(L.acquiredImmunoDeficiencySyndromePrintName);
acquiredImmunoDeficiencySyndromeDis.setMiscComments(L.acquiredImmunoDeficiencySyndromeComment);
acquiredImmunoDeficiencySyndromeDis.setCode358(48);
acquiredImmunoDeficiencySyndromeDis.setICD10code("B20");
acquiredImmunoDeficiencySyndromeDis.addCausesDisease(LR.acquiredImmunoDeficiencySyndromeAdvanced);
acquiredImmunoDeficiencySyndromeDis.addReference("pp 383-7");


// ------------- acquiredImmunoDeficiencySyndromeAdvanced  -------------
Disease acquiredImmunoDeficiencySyndromeAdvancedDis = new Disease(
    LR.acquiredImmunoDeficiencySyndromeAdvanced,
    L.acquiredImmunoDeficiencySyndromeAdvancedDescription,
    LR.immuneDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    F.acquiredImmunoDeficiencySyndromeAdvancedFreq, // diagnosis frequency, -1 = unknown
    LR.immuneSysSt,
    LR.HIVInfection
);
acquiredImmunoDeficiencySyndromeAdvancedDis.setPrintName(L.acquiredImmunoDeficiencySyndromeAdvancedPrintName);
acquiredImmunoDeficiencySyndromeAdvancedDis.setMiscComments(L.acquiredImmunoDeficiencySyndromeAdvancedComment);
acquiredImmunoDeficiencySyndromeAdvancedDis.setTemperature(101.0f);
acquiredImmunoDeficiencySyndromeAdvancedDis.setCode358(49);
acquiredImmunoDeficiencySyndromeAdvancedDis.setICD10code("B20");
acquiredImmunoDeficiencySyndromeAdvancedDis.addInternalCause(LR.acquiredImmunoDeficiencySyndrome);
acquiredImmunoDeficiencySyndromeAdvancedDis.addReference("pp 383-7");
acquiredImmunoDeficiencySyndromeAdvancedDis.addSymptom(LR.cachexia);
acquiredImmunoDeficiencySyndromeAdvancedDis.addSymptom(LR.fatigue);
acquiredImmunoDeficiencySyndromeAdvancedDis.addSymptom(LR.nightSweating);
acquiredImmunoDeficiencySyndromeAdvancedDis.addSymptom(LR.weightLoss);
Treatment acquiredImmunoDeficiencySyndromeAdvancedTr1 = new Treatment("acquiredImmunoDeficiencySyndromeAdvancedTr1");
acquiredImmunoDeficiencySyndromeAdvancedTr1.addDrug(LR.zidovudine);
acquiredImmunoDeficiencySyndromeAdvancedTr1.addDrug(LR.lamivudine);
acquiredImmunoDeficiencySyndromeAdvancedTr1.addDrug(LR.didanosine);
acquiredImmunoDeficiencySyndromeAdvancedTr1.addDrug(LR.stavudine);
acquiredImmunoDeficiencySyndromeAdvancedTr1.addDrug(LR.zalcitabine);
acquiredImmunoDeficiencySyndromeAdvancedDis.addTreatment("acquiredImmunoDeficiencySyndromeAdvancedTr1");
Treatment acquiredImmunoDeficiencySyndromeAdvancedTr2 = new Treatment("acquiredImmunoDeficiencySyndromeAdvancedTr2");
acquiredImmunoDeficiencySyndromeAdvancedTr2.addDrug(LR.ritonavir);
acquiredImmunoDeficiencySyndromeAdvancedTr2.addDrug(LR.indinavir);
acquiredImmunoDeficiencySyndromeAdvancedTr2.addDrug(LR.nelfinavir);
acquiredImmunoDeficiencySyndromeAdvancedTr2.addDrug(LR.saquinavirMaleate);
acquiredImmunoDeficiencySyndromeAdvancedDis.addTreatment("acquiredImmunoDeficiencySyndromeAdvancedTr2");


// ------------- anaphylaxis  -------------
Disease anaphylaxisDis = new Disease(
    LR.anaphylaxis,
    L.anaphylaxisDescription,
    LR.immuneDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vascularSysSt,
    LR.antigenExposure
);
anaphylaxisDis.setPrintName(L.anaphylaxisPrintName);
anaphylaxisDis.setMiscComments(L.anaphylaxisComment);
anaphylaxisDis.addCausesAbnormalCondition(LR.shock);
anaphylaxisDis.addReference("pp 350-2");
anaphylaxisDis.addSymptom(LR.abdomenCramping);
anaphylaxisDis.addSymptom(LR.doomFeeling);
anaphylaxisDis.addSymptom(LR.dyspnea);
anaphylaxisDis.addSymptom(LR.hypotension);
anaphylaxisDis.addSymptom(LR.respirationDistress);
anaphylaxisDis.addSymptom(LR.sneezing);
anaphylaxisDis.addSymptom(LR.urticaria);
anaphylaxisDis.addSymptom(LR.weakness);
anaphylaxisDis.addSymptom(LR.wheezing);
Treatment anaphylaxisTr1 = new Treatment("anaphylaxisTr1");
anaphylaxisTr1.addTreatmentAction(LR.establishmentOfAirway);
anaphylaxisTr1.addTreatmentAction(LR.IVVolumeExpanders);
anaphylaxisTr1.addDrug(LR.epinephrine);
anaphylaxisTr1.addDrug(LR.steroids);
anaphylaxisTr1.addDrug(LR.diphenhydramine);
anaphylaxisDis.addTreatment("anaphylaxisTr1");
Treatment anaphylaxisTr2 = new Treatment("anaphylaxisTr2", LR.ifCardiacArrest);
anaphylaxisTr2.addTreatmentAction(LR.CPR);
anaphylaxisDis.addTreatment("anaphylaxisTr2");


// ------------- ankylosingSpondylitis  -------------
Disease ankylosingSpondylitisDis = new Disease(
    LR.ankylosingSpondylitis,
    L.ankylosingSpondylitisDescription,
    LR.immuneDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.jointsSysSt,
    LR.none
);
ankylosingSpondylitisDis.setPrintName(L.ankylosingSpondylitisPrintName);
ankylosingSpondylitisDis.setMiscComments(L.ankylosingSpondylitisComment);
ankylosingSpondylitisDis.addInternalCause(LR.ulcerativeColitis);
ankylosingSpondylitisDis.addCausesDisease(LR.arthritis);
ankylosingSpondylitisDis.addCausesDisease(LR.uveitis);
ankylosingSpondylitisDis.addCausesDisease(LR.aortaInsufficiency);
ankylosingSpondylitisDis.addCausesDisease(LR.kyphosis);
ankylosingSpondylitisDis.addCausesDisease(LR.idiopathicPulmonaryFibrosis);
ankylosingSpondylitisDis.addCausesAbnormalCondition(LR.hipDeformity);
ankylosingSpondylitisDis.addCausesAbnormalCondition(LR.cardiacEnlargement);
ankylosingSpondylitisDis.addReference("pp 363-5");
ankylosingSpondylitisDis.addSymptom(LR.anorexia, "", 0.2f);
ankylosingSpondylitisDis.addSymptom(LR.chestPain, "", 0.2f);
ankylosingSpondylitisDis.addSymptom(LR.fatigue, "", 0.2f);
ankylosingSpondylitisDis.addSymptom(LR.lowBackPain);
ankylosingSpondylitisDis.addSymptom(LR.weightLoss, "", 0.2f);
ankylosingSpondylitisDis.addSymptom(LR.spineStiff, "", 0.2f);
Treatment ankylosingSpondylitisTr1 = new Treatment("ankylosingSpondylitisTr1");
ankylosingSpondylitisTr1.addTreatmentAction(LR.exercise);
ankylosingSpondylitisTr1.addDrug(LR.analgetics);
ankylosingSpondylitisDis.addTreatment("ankylosingSpondylitisTr1");
Treatment ankylosingSpondylitisTr2 = new Treatment("ankylosingSpondylitisTr2", LR.ifHipInvolvement);
ankylosingSpondylitisTr2.addTreatmentAction(LR.surgery);
ankylosingSpondylitisDis.addTreatment("ankylosingSpondylitisTr2");


// ------------- asthma  -------------
Disease asthmaDis = new Disease(
    LR.asthma,
    L.asthmaDescription,
    LR.immuneDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.allergens
);
asthmaDis.setPrintName(L.asthmaPrintName);
asthmaDis.addExternalCause(LR.pollen);
asthmaDis.addExternalCause(LR.animalDander);
asthmaDis.addExternalCause(LR.houseDustAndMold);
asthmaDis.addExternalCause(LR.kapokAndFeatherPillows);
asthmaDis.addExternalCause(LR.foodSulfites);
asthmaDis.addExternalCause(LR.cigaretteSmoking);
asthmaDis.addExternalCause(LR.coughing);
asthmaDis.addExternalCause(LR.laughing);
asthmaDis.addExternalCause(LR.anxiety);
asthmaDis.setCode358(268);
asthmaDis.setICD10code("J45");
asthmaDis.addInternalCause(LR.gastroesophagealReflux);
asthmaDis.addCausesDisease(LR.chronicAsthma);
asthmaDis.addReference("pp 340-6");
asthmaDis.addSymptom(LR.dyspnea);
asthmaDis.addSymptom(LR.cough);
asthmaDis.addSymptom(LR.wheezing);
asthmaDis.addSymptom(LR.chestTightness);
asthmaDis.addSymptom(LR.diaphoresis, "", 0.3f);
asthmaDis.addSymptom(LR.rhonchus, "", 0.5f);
asthmaDis.addSymptom(LR.sputumMucoid, L.asthma_sputumMucoid, 1.0f);
asthmaDis.addSymptom(LR.tachycardia, "", 0.3f);
asthmaDis.addSymptom(LR.tachypnea, "", 0.3f);
Treatment asthmaTr1 = new Treatment("asthmaTr1", LR.ifInfection);
asthmaTr1.addDrug(LR.antibiotics);
asthmaDis.addTreatment("asthmaTr1");
Treatment asthmaTr2 = new Treatment("asthmaTr2");
asthmaTr2.addDrug(LR.bronchodilator);
asthmaTr2.addDrug(LR.corticosteroids);
asthmaDis.addTreatment("asthmaTr2");


// ------------- chronicFatigueSyndrome  -------------
Disease chronicFatigueSyndromeDis = new Disease(
    LR.chronicFatigueSyndrome,
    L.chronicFatigueSyndromeDescription,
    LR.immuneDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    50, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.immuneSysSt,
    LR.none
);
chronicFatigueSyndromeDis.setPrintName(L.chronicFatigueSyndromePrintName);
chronicFatigueSyndromeDis.setMiscComments(L.chronicFatigueSyndromeComment);
chronicFatigueSyndromeDis.addReference("pp 388-9");
chronicFatigueSyndromeDis.addSymptom(LR.arthralgia, "", 0.6f);
chronicFatigueSyndromeDis.addSymptom(LR.concentrationLoss, "", 0.3f);
chronicFatigueSyndromeDis.addSymptom(LR.confusion, "", 0.3f);
chronicFatigueSyndromeDis.addSymptom(LR.fatigueProlonged);
chronicFatigueSyndromeDis.addSymptom(LR.forgetfulness, "", 0.3f);
chronicFatigueSyndromeDis.addSymptom(LR.headache);
chronicFatigueSyndromeDis.addSymptom(LR.irritability, "", 0.3f);
chronicFatigueSyndromeDis.addSymptom(LR.lymphNodePainful);
chronicFatigueSyndromeDis.addSymptom(LR.mentalDepression, "", 0.3f);
chronicFatigueSyndromeDis.addSymptom(LR.muscleWeakness);
chronicFatigueSyndromeDis.addSymptom(LR.photophobia, "", 0.3f);
chronicFatigueSyndromeDis.addSymptom(LR.sleepDisturbed);
Treatment chronicFatigueSyndromeTr1 = new Treatment("chronicFatigueSyndromeTr1");
chronicFatigueSyndromeTr1.addDrug(LR.acyclovir);
chronicFatigueSyndromeTr1.addDrug(LR.ampligen);
chronicFatigueSyndromeDis.addTreatment("chronicFatigueSyndromeTr1");
Treatment chronicFatigueSyndromeTr2 = new Treatment("chronicFatigueSyndromeTr2");
chronicFatigueSyndromeTr2.addDrug(LR.antianxietyDrug);
chronicFatigueSyndromeTr2.addDrug(LR.antidepressants);
chronicFatigueSyndromeDis.addTreatment("chronicFatigueSyndromeTr2");


// ------------- lupusErythematosus  -------------
Disease lupusErythematosusDis = new Disease(
    LR.lupusErythematosus,
    L.lupusErythematosusDescription,
    LR.immuneDisorders,
    LR.moreFemale, // genderSpecificity
    LR.africanAmerican, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.immuneSysSt,
    LR.none
);
lupusErythematosusDis.setPrintName(L.lupusErythematosusPrintName);
lupusErythematosusDis.setTemperature(99.8f);
lupusErythematosusDis.addReference("pp 366-370");
lupusErythematosusDis.addIllustration(D.ButterflyRashJpg);
lupusErythematosusDis.addSymptom(LR.arthralgia);
lupusErythematosusDis.addSymptom(LR.fatigue);
lupusErythematosusDis.addSymptom(LR.malaise);
lupusErythematosusDis.addSymptom(LR.rash);
lupusErythematosusDis.addSymptom(LR.weightLoss);
lupusErythematosusDis.addSymptom(LR.butterflyRash, "", 0.5f);
Treatment lupusErythematosusTr1 = new Treatment("lupusErythematosusTr1");
lupusErythematosusTr1.addDrug(LR.aspirin);
lupusErythematosusTr1.addDrug(LR.corticosteroids);
lupusErythematosusDis.addTreatment("lupusErythematosusTr1");


// ------------- lupusErythematosusDiscoid  -------------
Disease lupusErythematosusDiscoidDis = new Disease(
    LR.lupusErythematosusDiscoid,
    L.lupusErythematosusDiscoidDescription,
    LR.immuneDisorders,
    LR.moreFemale, // genderSpecificity
    LR.africanAmerican, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.immuneSysSt,
    LR.none
);
lupusErythematosusDiscoidDis.setPrintName(L.lupusErythematosusDiscoidPrintName);
lupusErythematosusDiscoidDis.setSuperDisease(LR.lupusErythematosus);
lupusErythematosusDiscoidDis.setTemperature(99.8f);
lupusErythematosusDiscoidDis.addCausesDisease(LR.lupusErythematosusSystemic);
lupusErythematosusDiscoidDis.addReference("pp 366-370");
lupusErythematosusDiscoidDis.addIllustration(D.ButterflyRashJpg);
lupusErythematosusDiscoidDis.addSymptom(LR.skinPlaquesRaised);
lupusErythematosusDiscoidDis.addSymptom(LR.skinPlaquesRed);
lupusErythematosusDiscoidDis.addSymptom(LR.skinPlaquesScaled);


// ------------- lupusErythematosusSystemic  -------------
Disease lupusErythematosusSystemicDis = new Disease(
    LR.lupusErythematosusSystemic,
    L.lupusErythematosusSystemicDescription,
    LR.immuneDisorders,
    LR.moreFemale, // genderSpecificity
    LR.africanAmerican, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.immuneSysSt,
    LR.none
);
lupusErythematosusSystemicDis.setPrintName(L.lupusErythematosusSystemicPrintName);
lupusErythematosusSystemicDis.setSuperDisease(LR.lupusErythematosus);
lupusErythematosusSystemicDis.setTemperature(99.8f);
lupusErythematosusSystemicDis.addInternalCause(LR.lupusErythematosusDiscoid);
lupusErythematosusSystemicDis.addReference("pp 366-370");
lupusErythematosusSystemicDis.addIllustration(D.ButterflyRashJpg);
lupusErythematosusSystemicDis.addSymptom(LR.skinPlaquesRaised);
lupusErythematosusSystemicDis.addSymptom(LR.skinPlaquesRed);
lupusErythematosusSystemicDis.addSymptom(LR.skinPlaquesScaled);
lupusErythematosusSystemicDis.addSymptom(LR.vomiting);
lupusErythematosusSystemicDis.addSymptom(LR.anorexia);
lupusErythematosusSystemicDis.addSymptom(LR.chills);
lupusErythematosusSystemicDis.addSymptom(LR.abdomenPain);
lupusErythematosusSystemicDis.addSymptom(LR.lymphadenopathy);
lupusErythematosusSystemicDis.addSymptom(LR.nausea);


// ------------- polymyositis  -------------
Disease polymyositisDis = new Disease(
    LR.polymyositis,
    L.polymyositisDescription,
    LR.immuneDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.muscleSysSt,
    LR.none
);
polymyositisDis.setPrintName(L.polymyositisPrintName);
polymyositisDis.addInternalCause(LR.toxoplasmosisAcquiredAdvanced);
polymyositisDis.addReference("pp 378-9");
polymyositisDis.addSymptom(LR.dysphagia);
polymyositisDis.addSymptom(LR.muscleWeakness);
polymyositisDis.addSymptom(LR.muscleTender);
polymyositisDis.addSymptom(LR.dysphonia);
Treatment polymyositisTr1 = new Treatment("polymyositisTr1");
polymyositisTr1.addDrug(LR.corticosteroids);
polymyositisDis.addTreatment("polymyositisTr1");


// ------------- arthritis  -------------
Disease arthritisDis = new Disease(
    LR.arthritis,
    L.arthritisDescription,
    LR.immuneDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.jointsSysSt,
    LR.none
);
arthritisDis.setPrintName(L.arthritisPrintName);
arthritisDis.addInternalCause(LR.ankylosingSpondylitis);
arthritisDis.addInternalCause(LR.lymeDisease3);
arthritisDis.addInternalCause(LR.ulcerativeColitis);
arthritisDis.addReference("HealthWise pp 115-7");
arthritisDis.addSymptom(LR.jointPain);
Treatment arthritisTr1 = new Treatment("arthritisTr1");
arthritisTr1.addTreatmentAction(LR.exercise);
arthritisTr1.addTreatmentAction(LR.weightReduction);
arthritisTr1.addTreatmentAction(LR.stretching);
arthritisTr1.addDrug(LR.analgetics);
arthritisDis.addTreatment("arthritisTr1");


// ------------- rheumatoidArthritis  -------------
Disease rheumatoidArthritisDis = new Disease(
    LR.rheumatoidArthritis,
    L.rheumatoidArthritisDescription,
    LR.immuneDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.immuneSysSt,
    LR.none
);
rheumatoidArthritisDis.setPrintName(L.rheumatoidArthritisPrintName);
rheumatoidArthritisDis.setSuperDisease(LR.arthritis);
rheumatoidArthritisDis.setCode358(311);
rheumatoidArthritisDis.setICD10code("M05");
rheumatoidArthritisDis.addReference("pp 355-60");


// ------------- rheumatoidArthritis1  -------------
Disease rheumatoidArthritis1Dis = new Disease(
    LR.rheumatoidArthritis1,
    L.rheumatoidArthritis1Description,
    LR.immuneDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.immuneSysSt,
    LR.none
);
rheumatoidArthritis1Dis.setPrintName(L.rheumatoidArthritis1PrintName);
rheumatoidArthritis1Dis.setSuperDisease(LR.rheumatoidArthritis);
rheumatoidArthritis1Dis.setCode358(311);
rheumatoidArthritis1Dis.setICD10code("M05");
rheumatoidArthritis1Dis.addCausesDisease(LR.rheumatoidArthritis2);
rheumatoidArthritis1Dis.addReference("pp 355-60");
rheumatoidArthritis1Dis.addSymptom(LR.anorexia);
rheumatoidArthritis1Dis.addSymptom(LR.fatigue);
rheumatoidArthritis1Dis.addSymptom(LR.lymphadenopathy);
rheumatoidArthritis1Dis.addSymptom(LR.malaise);
rheumatoidArthritis1Dis.addSymptom(LR.weightLoss);


// ------------- rheumatoidArthritis2  -------------
Disease rheumatoidArthritis2Dis = new Disease(
    LR.rheumatoidArthritis2,
    L.rheumatoidArthritis2Description,
    LR.immuneDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.immuneSysSt,
    LR.none
);
rheumatoidArthritis2Dis.setPrintName(L.rheumatoidArthritis2PrintName);
rheumatoidArthritis2Dis.setSuperDisease(LR.rheumatoidArthritis);
rheumatoidArthritis2Dis.setCode358(311);
rheumatoidArthritis2Dis.setICD10code("M05");
rheumatoidArthritis2Dis.addInternalCause(LR.rheumatoidArthritis1);
rheumatoidArthritis2Dis.addCausesDisease(LR.rheumatoidArthritis3);
rheumatoidArthritis2Dis.addReference("pp 355-60");
rheumatoidArthritis2Dis.addSymptom(LR.anorexia);
rheumatoidArthritis2Dis.addSymptom(LR.fatigue);
rheumatoidArthritis2Dis.addSymptom(LR.jointStiffen);
rheumatoidArthritis2Dis.addSymptom(LR.jointSwelling);
rheumatoidArthritis2Dis.addSymptom(LR.lymphadenopathy);
rheumatoidArthritis2Dis.addSymptom(LR.malaise);
rheumatoidArthritis2Dis.addSymptom(LR.weightLoss);


// ------------- rheumatoidArthritis3  -------------
Disease rheumatoidArthritis3Dis = new Disease(
    LR.rheumatoidArthritis3,
    L.rheumatoidArthritis3Description,
    LR.immuneDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.immuneSysSt,
    LR.none
);
rheumatoidArthritis3Dis.setPrintName(L.rheumatoidArthritis3PrintName);
rheumatoidArthritis3Dis.setSuperDisease(LR.rheumatoidArthritis);
rheumatoidArthritis3Dis.setCode358(311);
rheumatoidArthritis3Dis.setICD10code("M05");
rheumatoidArthritis3Dis.addInternalCause(LR.rheumatoidArthritis2);
rheumatoidArthritis3Dis.addCausesDisease(LR.pericarditis);
rheumatoidArthritis3Dis.addCausesDisease(LR.pleurisy);
rheumatoidArthritis3Dis.addReference("pp 355-60");
rheumatoidArthritis3Dis.addSymptom(LR.anorexia);
rheumatoidArthritis3Dis.addSymptom(LR.fatigue);
rheumatoidArthritis3Dis.addSymptom(LR.fingerJointDeformity);
rheumatoidArthritis3Dis.addSymptom(LR.jointStiffen);
rheumatoidArthritis3Dis.addSymptom(LR.jointSwelling);
rheumatoidArthritis3Dis.addSymptom(LR.lymphadenopathy);
rheumatoidArthritis3Dis.addSymptom(LR.malaise);
rheumatoidArthritis3Dis.addSymptom(LR.weightLoss);
Treatment rheumatoidArthritis3Tr1 = new Treatment("rheumatoidArthritis3Tr1", LR.ifSevere);
rheumatoidArthritis3Tr1.addTreatmentAction(LR.surgery);
rheumatoidArthritis3Dis.addTreatment("rheumatoidArthritis3Tr1");


// ------------- scleroderma  -------------
Disease sclerodermaDis = new Disease(
    LR.scleroderma,
    L.sclerodermaDescription,
    LR.immuneDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    50, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.immuneSysSt,
    LR.none
);
sclerodermaDis.setPrintName(L.sclerodermaPrintName);
sclerodermaDis.setMiscComments(L.sclerodermaComment);
sclerodermaDis.addReference("pp 372-4");
sclerodermaDis.addSymptom(LR.abdomenDistension, "", 0.3f);
sclerodermaDis.addSymptom(LR.bloating, L.scleroderma_bloating, 0.3f);
sclerodermaDis.addSymptom(LR.constipation, "", 0.3f);
sclerodermaDis.addSymptom(LR.diarrhea, "", 0.3f);
sclerodermaDis.addSymptom(LR.dysphagia, "", 0.3f);
sclerodermaDis.addSymptom(LR.fingerSwelling);
sclerodermaDis.addSymptom(LR.heartburn, "", 0.3f);
sclerodermaDis.addSymptom(LR.jointPain);
sclerodermaDis.addSymptom(LR.jointStiffen);
sclerodermaDis.addSymptom(LR.jointSwelling);
sclerodermaDis.addSymptom(LR.skinFaceTight);
sclerodermaDis.addSymptom(LR.skinHandsTight);
Treatment sclerodermaTr1 = new Treatment("sclerodermaTr1");
sclerodermaTr1.addDrug(LR.corticosteroids);
sclerodermaDis.addTreatment("sclerodermaTr1");


// ------------- vasculitis  -------------
Disease vasculitisDis = new Disease(
    LR.vasculitis,
    L.vasculitisDescription,
    LR.immuneDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vascularSysSt,
    LR.none
);
vasculitisDis.setPrintName(L.vasculitisPrintName);
vasculitisDis.setMiscComments(L.vasculitisComment);
vasculitisDis.addReference("pp 374-7");
Treatment vasculitisTr1 = new Treatment("vasculitisTr1");
vasculitisTr1.addDrug(LR.corticosteroids);
vasculitisTr1.addDrug(LR.cyclophosphamide);
vasculitisDis.addTreatment("vasculitisTr1");


// ------------- polyarteritisNodosa  -------------
Disease polyarteritisNodosaDis = new Disease(
    LR.polyarteritisNodosa,
    L.polyarteritisNodosaDescription,
    LR.immuneDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vascularSysSt,
    LR.none
);
polyarteritisNodosaDis.setPrintName(L.polyarteritisNodosaPrintName);
polyarteritisNodosaDis.setSuperDisease(LR.vasculitis);
polyarteritisNodosaDis.addCausesDisease(LR.hypertension);
polyarteritisNodosaDis.addReference("pp 374-7");
polyarteritisNodosaDis.addSymptom(LR.abdomenPain);
polyarteritisNodosaDis.addSymptom(LR.anorexia);
polyarteritisNodosaDis.addSymptom(LR.fatigue);
polyarteritisNodosaDis.addSymptom(LR.feverSym);
polyarteritisNodosaDis.addSymptom(LR.headache);
polyarteritisNodosaDis.addSymptom(LR.jointPain);
polyarteritisNodosaDis.addSymptom(LR.myalgia);
polyarteritisNodosaDis.addSymptom(LR.weakness);
polyarteritisNodosaDis.addSymptom(LR.weightLoss);


// ------------- vasculitisPulmonary  -------------
Disease vasculitisPulmonaryDis = new Disease(
    LR.vasculitisPulmonary,
    L.vasculitisPulmonaryDescription,
    LR.immuneDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vascularSysSt,
    LR.none
);
vasculitisPulmonaryDis.setPrintName(L.vasculitisPulmonaryPrintName);
vasculitisPulmonaryDis.setSuperDisease(LR.vasculitis);
vasculitisPulmonaryDis.setTemperature(101.0f);
vasculitisPulmonaryDis.addCausesDisease(LR.corPulmonale);
vasculitisPulmonaryDis.addReference("pp 374-7");
vasculitisPulmonaryDis.addSymptom(LR.pulmonaryCongestion);
vasculitisPulmonaryDis.addSymptom(LR.anorexia);
vasculitisPulmonaryDis.addSymptom(LR.cough);
vasculitisPulmonaryDis.addSymptom(LR.hematuria);
vasculitisPulmonaryDis.addSymptom(LR.malaise);
vasculitisPulmonaryDis.addSymptom(LR.weightLoss);
} // end of immuneDisorders





// ------------- infections  -------------
static public void infections() { 


// ------------- rheumaticFever  -------------
Disease rheumaticFeverDis = new Disease(
    LR.rheumaticFever,
    L.rheumaticFeverDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    20, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
rheumaticFeverDis.setPrintName(L.rheumaticFeverPrintName);
rheumaticFeverDis.setMiscComments(L.rheumaticFeverComment);
rheumaticFeverDis.setTemperature(100.5f);
rheumaticFeverDis.setCode358(199);
rheumaticFeverDis.setICD10code("I00");
rheumaticFeverDis.addCausesDisease(LR.choreaTransient);
rheumaticFeverDis.addCausesDisease(LR.endocarditis);
rheumaticFeverDis.addCausesDisease(LR.myocarditis);
rheumaticFeverDis.addCausesDisease(LR.pericarditis);
rheumaticFeverDis.addCausesDisease(LR.rheumaticHeartDisease);
rheumaticFeverDis.addReference("pp 1087-9");
Treatment rheumaticFeverTr1 = new Treatment("rheumaticFeverTr1");
rheumaticFeverTr1.addDrug(LR.aspirin);
rheumaticFeverTr1.addDrug(LR.penicillin);
rheumaticFeverDis.addTreatment("rheumaticFeverTr1");


// ------------- rheumaticFeverJoints  -------------
Disease rheumaticFeverJointsDis = new Disease(
    LR.rheumaticFeverJoints,
    L.rheumaticFeverJointsDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    20, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
rheumaticFeverJointsDis.setPrintName(L.rheumaticFeverJointsPrintName);
rheumaticFeverJointsDis.setSuperDisease(LR.rheumaticFever);
rheumaticFeverJointsDis.setTemperature(100.5f);
rheumaticFeverJointsDis.addReference("pp 1087-9");
rheumaticFeverJointsDis.addSymptom(LR.jointRedness, "", 0.95f);
rheumaticFeverJointsDis.addSymptom(LR.jointSwelling, "", 0.95f);
rheumaticFeverJointsDis.addSymptom(LR.anklePain, "", 0.95f);
rheumaticFeverJointsDis.addSymptom(LR.elbowPain, "", 0.95f);
rheumaticFeverJointsDis.addSymptom(LR.hipPain, "", 0.95f);
rheumaticFeverJointsDis.addSymptom(LR.kneePain, "", 0.95f);
rheumaticFeverJointsDis.addSymptom(LR.polyarthritis, "", 0.95f);


// ------------- rheumaticFeverSkin  -------------
Disease rheumaticFeverSkinDis = new Disease(
    LR.rheumaticFeverSkin,
    L.rheumaticFeverSkinDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    20, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
rheumaticFeverSkinDis.setPrintName(L.rheumaticFeverSkinPrintName);
rheumaticFeverSkinDis.setSuperDisease(LR.rheumaticFever);
rheumaticFeverSkinDis.setTemperature(100.5f);
rheumaticFeverSkinDis.addReference("pp 1087-9");
rheumaticFeverSkinDis.addSymptom(LR.rashCreeping);
rheumaticFeverSkinDis.addSymptom(LR.skinLesionMacular);
rheumaticFeverSkinDis.addSymptom(LR.skinLesionRedWhite);


// ------------- rheumaticFeverNodules  -------------
Disease rheumaticFeverNodulesDis = new Disease(
    LR.rheumaticFeverNodules,
    L.rheumaticFeverNodulesDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    20, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
rheumaticFeverNodulesDis.setPrintName(L.rheumaticFeverNodulesPrintName);
rheumaticFeverNodulesDis.setSuperDisease(LR.rheumaticFever);
rheumaticFeverNodulesDis.setTemperature(100.5f);
rheumaticFeverNodulesDis.addReference("pp 1087-9");
rheumaticFeverNodulesDis.addSymptom(LR.handNodule, "", 0.5f);
rheumaticFeverNodulesDis.addSymptom(LR.jointNodule);
rheumaticFeverNodulesDis.addSymptom(LR.scalpNodule, "", 0.5f);


// ------------- puerperalInfection  -------------
Disease puerperalInfectionDis = new Disease(
    LR.puerperalInfection,
    L.puerperalInfectionDescription,
    LR.infections,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    13, // minAge
    50, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gynecologicSysSt,
    LR.infection
);
puerperalInfectionDis.setPrintName(L.puerperalInfectionPrintName);
puerperalInfectionDis.setTemperature(100.4f);
puerperalInfectionDis.addReference("pp 965-7");
puerperalInfectionDis.addSymptom(LR.anxiety);
puerperalInfectionDis.addSymptom(LR.chills);
puerperalInfectionDis.addSymptom(LR.headache);
puerperalInfectionDis.addSymptom(LR.malaise);
puerperalInfectionDis.addSymptom(LR.restlessness);
Treatment puerperalInfectionTr1 = new Treatment("puerperalInfectionTr1");
puerperalInfectionTr1.addTreatmentAction(LR.IVFluids);
puerperalInfectionTr1.addTreatmentAction(LR.bedRest);
puerperalInfectionTr1.addDrug(LR.analgetics);
puerperalInfectionTr1.addDrug(LR.antibiotics);
puerperalInfectionDis.addTreatment("puerperalInfectionTr1");


// ------------- puerperalInfectionLocalLesions  -------------
Disease puerperalInfectionLocalLesionsDis = new Disease(
    LR.puerperalInfectionLocalLesions,
    L.puerperalInfectionLocalLesionsDescription,
    LR.infections,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    13, // minAge
    50, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.perineumVulvaVaginaSysSt,
    LR.infection
);
puerperalInfectionLocalLesionsDis.setPrintName(L.puerperalInfectionLocalLesionsPrintName);
puerperalInfectionLocalLesionsDis.setSuperDisease(LR.puerperalInfection);
puerperalInfectionLocalLesionsDis.setTemperature(100.4f);
puerperalInfectionLocalLesionsDis.addReference("pp 965-7");
puerperalInfectionLocalLesionsDis.addSymptom(LR.dysuria);
puerperalInfectionLocalLesionsDis.addSymptom(LR.edema);
puerperalInfectionLocalLesionsDis.addSymptom(LR.pain);
Treatment puerperalInfectionLocalLesionsTr1 = new Treatment("puerperalInfectionLocalLesionsTr1");
puerperalInfectionLocalLesionsTr1.addDrug(LR.antiseptics);
puerperalInfectionLocalLesionsDis.addTreatment("puerperalInfectionLocalLesionsTr1");


// ------------- endometritis  -------------
Disease endometritisDis = new Disease(
    LR.endometritis,
    L.endometritisDescription,
    LR.infections,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    13, // minAge
    50, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.endometriumSysSt,
    LR.infection
);
endometritisDis.setPrintName(L.endometritisPrintName);
endometritisDis.setSuperDisease(LR.puerperalInfection);
endometritisDis.setTemperature(100.4f);
endometritisDis.addReference("pp 965-7");
endometritisDis.addSymptom(LR.backPain);
endometritisDis.addSymptom(LR.uterusTender);
endometritisDis.addSymptom(LR.uterusEnlarged);
endometritisDis.addSymptom(LR.vaginaDischargeFoulSmelling, "", 0.2f);
endometritisDis.addSymptom(LR.lochiaHeavy);
endometritisDis.addSymptom(LR.contractionsAfterChildbirth);
Treatment endometritisTr1 = new Treatment("endometritisTr1");
endometritisTr1.addDrug(LR.anticoagulants);
endometritisDis.addTreatment("endometritisTr1");


// ------------- parametritis  -------------
Disease parametritisDis = new Disease(
    LR.parametritis,
    L.parametritisDescription,
    LR.infections,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    13, // minAge
    50, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.pelvisSysSt,
    LR.infection
);
parametritisDis.setPrintName(L.parametritisPrintName);
parametritisDis.setSuperDisease(LR.puerperalInfection);
parametritisDis.setTemperature(100.4f);
parametritisDis.addReference("pp 965-7");
parametritisDis.addSymptom(LR.abdomenPain);
parametritisDis.addSymptom(LR.abdomenTenderness);
parametritisDis.addSymptom(LR.vaginaTenderness);


// ------------- pelvisThrombophlebitis  -------------
Disease pelvisThrombophlebitisDis = new Disease(
    LR.pelvisThrombophlebitis,
    L.pelvisThrombophlebitisDescription,
    LR.infections,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    13, // minAge
    50, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.pelvisSysSt,
    LR.infection
);
pelvisThrombophlebitisDis.setPrintName(L.pelvisThrombophlebitisPrintName);
pelvisThrombophlebitisDis.setSuperDisease(LR.puerperalInfection);
pelvisThrombophlebitisDis.setTemperature(100.4f);
pelvisThrombophlebitisDis.addReference("pp 965-7");
pelvisThrombophlebitisDis.addSymptom(LR.abdomenTenderness, L.pelvisThrombophlebitis_abdomenTenderness, 1.0f);
pelvisThrombophlebitisDis.addSymptom(LR.abdomenPainLowerSide);
pelvisThrombophlebitisDis.addSymptom(LR.chillsSevere);
pelvisThrombophlebitisDis.addSymptom(LR.flankPain);
pelvisThrombophlebitisDis.addSymptom(LR.temperatureSwingsSevere);
Treatment pelvisThrombophlebitisTr1 = new Treatment("pelvisThrombophlebitisTr1");
pelvisThrombophlebitisTr1.addDrug(LR.anticoagulants);
pelvisThrombophlebitisDis.addTreatment("pelvisThrombophlebitisTr1");


// ------------- femoralThrombophlebitis  -------------
Disease femoralThrombophlebitisDis = new Disease(
    LR.femoralThrombophlebitis,
    L.femoralThrombophlebitisDescription,
    LR.infections,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    13, // minAge
    50, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.groinSysSt,
    LR.infection
);
femoralThrombophlebitisDis.setPrintName(L.femoralThrombophlebitisPrintName);
femoralThrombophlebitisDis.setSuperDisease(LR.puerperalInfection);
femoralThrombophlebitisDis.setTemperature(100.4f);
femoralThrombophlebitisDis.addCausesDisease(LR.pulmonaryEmbolism);
femoralThrombophlebitisDis.addReference("pp 965-7");
femoralThrombophlebitisDis.addSymptom(LR.groinPain);
femoralThrombophlebitisDis.addSymptom(LR.legEdema);
femoralThrombophlebitisDis.addSymptom(LR.groinStiffness);
femoralThrombophlebitisDis.addSymptom(LR.groinSwelling);
femoralThrombophlebitisDis.addSymptom(LR.legPain);
femoralThrombophlebitisDis.addSymptom(LR.legStiff);


// ------------- amebiasis  -------------
Disease amebiasisDis = new Disease(
    LR.amebiasis,
    L.amebiasisDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.amebiasisFreq, // diagnosis frequency, -1 = unknown
    LR.intestinesSysSt,
    LR.protozoanInfection
);
amebiasisDis.setPrintName(L.amebiasisPrintName);
amebiasisDis.setMiscComments(L.amebiasisComment);
amebiasisDis.setTemperature(104.0f);
amebiasisDis.setCode358(9);
amebiasisDis.setICD10code("A06");
amebiasisDis.addReference("pp 254");
amebiasisDis.addSymptom(LR.abdomenCramping);
amebiasisDis.addSymptom(LR.abdomenTenderness);
amebiasisDis.addSymptom(LR.chills);
amebiasisDis.addSymptom(LR.diarrheaBloody);
amebiasisDis.addSymptom(LR.tenesmus);
Treatment amebiasisTr1 = new Treatment("amebiasisTr1");
amebiasisTr1.addDrug(LR.metronidazole);
amebiasisDis.addTreatment("amebiasisTr1");


// ------------- anthrax  -------------
Disease anthraxDis = new Disease(
    LR.anthrax,
    L.anthraxDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.anthracisBacterialInfection
);
anthraxDis.setPrintName(L.anthraxPrintName);
anthraxDis.setMiscComments(L.anthraxComment);
anthraxDis.addReference("pp 1278-9");
Treatment anthraxTr1 = new Treatment("anthraxTr1");
anthraxTr1.addDrug(LR.antibiotics);
anthraxTr1.addDrug(LR.penicillin);
anthraxTr1.addDrug(LR.erythromycin);
anthraxTr1.addDrug(LR.tetracycline);
anthraxTr1.addDrug(LR.chloramphenicol);
anthraxDis.addTreatment("anthraxTr1");


// ------------- anthraxInhalation  -------------
Disease anthraxInhalationDis = new Disease(
    LR.anthraxInhalation,
    L.anthraxInhalationDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.respiratorySysSt,
    LR.anthracisBacterialInfection
);
anthraxInhalationDis.setPrintName(L.anthraxInhalationPrintName);
anthraxInhalationDis.setSuperDisease(LR.anthrax);
anthraxInhalationDis.setMiscComments(L.anthraxInhalationComment);
anthraxInhalationDis.setTemperature(102.5f);
anthraxInhalationDis.addCausesAbnormalCondition(LR.shock);
anthraxInhalationDis.addReference("pp 516-7");
anthraxInhalationDis.addSymptom(LR.breathlessness, L.anthraxInhalation_breathlessness, 0.2f);
anthraxInhalationDis.addSymptom(LR.chills, L.anthraxInhalation_chills, 1.0f);
anthraxInhalationDis.addSymptom(LR.cough, L.anthraxInhalation_cough, 1.0f);
anthraxInhalationDis.addSymptom(LR.headache, L.anthraxInhalation_headache, 1.0f);
anthraxInhalationDis.addSymptom(LR.malaise, L.anthraxInhalation_malaise, 1.0f);
anthraxInhalationDis.addSymptom(LR.myalgia, L.anthraxInhalation_myalgia, 1.0f);


// ------------- anthraxIntestinal  -------------
Disease anthraxIntestinalDis = new Disease(
    LR.anthraxIntestinal,
    L.anthraxIntestinalDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.gastrointestinalSysSt,
    LR.anthracisBacterialInfection
);
anthraxIntestinalDis.setPrintName(L.anthraxIntestinalPrintName);
anthraxIntestinalDis.setSuperDisease(LR.anthrax);
anthraxIntestinalDis.setMiscComments(L.anthraxIntestinalComment);
anthraxIntestinalDis.addReference("pp 1278-9 ");
anthraxIntestinalDis.addSymptom(LR.abdomenPain);
anthraxIntestinalDis.addSymptom(LR.appetiteLoss);
anthraxIntestinalDis.addSymptom(LR.diarrhea);
anthraxIntestinalDis.addSymptom(LR.hemoptysis);
anthraxIntestinalDis.addSymptom(LR.nausea);
anthraxIntestinalDis.addSymptom(LR.vomiting);


// ------------- campylobacteriosis  -------------
Disease campylobacteriosisDis = new Disease(
    LR.campylobacteriosis,
    L.campylobacteriosisDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.campylobacteriosisFreq, // diagnosis frequency, -1 = unknown
    LR.intestinesSysSt,
    LR.bacterialInfection
);
campylobacteriosisDis.setPrintName(L.campylobacteriosisPrintName);
campylobacteriosisDis.setMiscComments(L.campylobacteriosisComment);
campylobacteriosisDis.setTemperature(101.0f);
campylobacteriosisDis.addCausesDisease(LR.guillainBarreSyndrome);
campylobacteriosisDis.addReference("www.cdc.gov");
campylobacteriosisDis.addSymptom(LR.abdomenCramping);
campylobacteriosisDis.addSymptom(LR.abdomenPain);
campylobacteriosisDis.addSymptom(LR.diarrhea);
campylobacteriosisDis.addSymptom(LR.diarrheaBloody, "", 0.4f);
campylobacteriosisDis.addSymptom(LR.fatigue);
campylobacteriosisDis.addSymptom(LR.feverSym);
campylobacteriosisDis.addSymptom(LR.headache);
campylobacteriosisDis.addSymptom(LR.myalgia);
campylobacteriosisDis.addSymptom(LR.nausea, "", 0.4f);
campylobacteriosisDis.addSymptom(LR.vomiting, "", 0.4f);
Treatment campylobacteriosisTr1 = new Treatment("campylobacteriosisTr1");
campylobacteriosisTr1.addTreatmentAction(LR.fluidIncrease);
campylobacteriosisDis.addTreatment("campylobacteriosisTr1");


// ------------- botulism  -------------
Disease botulismDis = new Disease(
    LR.botulism,
    L.botulismDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.clostridiumBotulinumInfection
);
botulismDis.setPrintName(L.botulismPrintName);
botulismDis.setMiscComments(L.botulismComment);
botulismDis.addReference("pp 177-8");
botulismDis.addSymptom(LR.diarrhea);
botulismDis.addSymptom(LR.diplopia);
botulismDis.addSymptom(LR.mouthDry);
botulismDis.addSymptom(LR.dysarthria);
botulismDis.addSymptom(LR.muscleWeakness, L.botulism_muscleWeakness, 1.0f);
botulismDis.addSymptom(LR.ptosis);
botulismDis.addSymptom(LR.throatSore);
botulismDis.addSymptom(LR.vomiting);
botulismDis.addSymptom(LR.weakness);
Treatment botulismTr1 = new Treatment("botulismTr1");
botulismTr1.addDrug(LR.botulinumAntitoxin);
botulismDis.addTreatment("botulismTr1");


// ------------- candidiasis  -------------
Disease candidiasisDis = new Disease(
    LR.candidiasis,
    L.candidiasisDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.candidaInfection
);
candidiasisDis.setPrintName(L.candidiasisPrintName);
candidiasisDis.setMiscComments(L.candidiasisComment);
candidiasisDis.addReference("pp 205-7");
Treatment candidiasisTr1 = new Treatment("candidiasisTr1");
candidiasisTr1.addDrug(LR.nystatin);
candidiasisTr1.addDrug(LR.fluconazole);
candidiasisDis.addTreatment("candidiasisTr1");


// ------------- candidiasisBrain  -------------
Disease candidiasisBrainDis = new Disease(
    LR.candidiasisBrain,
    L.candidiasisBrainDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.brainSysSt,
    LR.none
);
candidiasisBrainDis.setPrintName(L.candidiasisBrainPrintName);
candidiasisBrainDis.setSuperDisease(LR.candidiasis);
candidiasisBrainDis.setTemperature(101.0f);
candidiasisBrainDis.addReference("pp 205-7");
candidiasisBrainDis.addSymptom(LR.confusion);
candidiasisBrainDis.addSymptom(LR.disorientation);
candidiasisBrainDis.addSymptom(LR.feverSym);
candidiasisBrainDis.addSymptom(LR.headache);
candidiasisBrainDis.addSymptom(LR.nuchalRigidity);
candidiasisBrainDis.addSymptom(LR.seizure);


// ------------- candidiasisEsophagus  -------------
Disease candidiasisEsophagusDis = new Disease(
    LR.candidiasisEsophagus,
    L.candidiasisEsophagusDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.esophagusSysSt,
    LR.none
);
candidiasisEsophagusDis.setPrintName(L.candidiasisEsophagusPrintName);
candidiasisEsophagusDis.setSuperDisease(LR.candidiasis);
candidiasisEsophagusDis.addReference("pp 205-7");
candidiasisEsophagusDis.addSymptom(LR.dysphagia);
candidiasisEsophagusDis.addSymptom(LR.retrosternalChestPain);
candidiasisEsophagusDis.addSymptom(LR.vomiting);
candidiasisEsophagusDis.addSymptom(LR.mouthLesion, "", 0.1f);
candidiasisEsophagusDis.addSymptom(LR.throatScale, "", 0.1f);


// ------------- candidiasisEye  -------------
Disease candidiasisEyeDis = new Disease(
    LR.candidiasisEye,
    L.candidiasisEyeDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.eyesSysSt,
    LR.none
);
candidiasisEyeDis.setPrintName(L.candidiasisEyePrintName);
candidiasisEyeDis.setSuperDisease(LR.candidiasis);
candidiasisEyeDis.setTemperature(101.0f);
candidiasisEyeDis.addReference("pp 205-7");
candidiasisEyeDis.addSymptom(LR.visionBlurred);
candidiasisEyeDis.addSymptom(LR.orbitPain);
candidiasisEyeDis.addSymptom(LR.eyeExudate);


// ------------- candidiasisNails  -------------
Disease candidiasisNailsDis = new Disease(
    LR.candidiasisNails,
    L.candidiasisNailsDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
candidiasisNailsDis.setPrintName(L.candidiasisNailsPrintName);
candidiasisNailsDis.setSuperDisease(LR.candidiasis);
candidiasisNailsDis.addReference("pp 205-7");
candidiasisNailsDis.addSymptom(LR.nailBedRed);
candidiasisNailsDis.addSymptom(LR.nailBedSwollen);


// ------------- candidiasisPulmonary  -------------
Disease candidiasisPulmonaryDis = new Disease(
    LR.candidiasisPulmonary,
    L.candidiasisPulmonaryDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.none
);
candidiasisPulmonaryDis.setPrintName(L.candidiasisPulmonaryPrintName);
candidiasisPulmonaryDis.setSuperDisease(LR.candidiasis);
candidiasisPulmonaryDis.setTemperature(101.0f);
candidiasisPulmonaryDis.addReference("pp 205-7");
candidiasisPulmonaryDis.addSymptom(LR.anorexia);
candidiasisPulmonaryDis.addSymptom(LR.cough);
candidiasisPulmonaryDis.addSymptom(LR.feverSym);
candidiasisPulmonaryDis.addSymptom(LR.hemoptysis);
candidiasisPulmonaryDis.addSymptom(LR.weakness);


// ------------- candidiasisRenal  -------------
Disease candidiasisRenalDis = new Disease(
    LR.candidiasisRenal,
    L.candidiasisRenalDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.none
);
candidiasisRenalDis.setPrintName(L.candidiasisRenalPrintName);
candidiasisRenalDis.setSuperDisease(LR.candidiasis);
candidiasisRenalDis.setTemperature(101.0f);
candidiasisRenalDis.addReference("pp 205-7");
candidiasisRenalDis.addSymptom(LR.dysuria);
candidiasisRenalDis.addSymptom(LR.flankPain);
candidiasisRenalDis.addSymptom(LR.hematuria);
candidiasisRenalDis.addSymptom(LR.pyuria);
candidiasisRenalDis.addSymptom(LR.urineCloudy);


// ------------- candidiasisSkin  -------------
Disease candidiasisSkinDis = new Disease(
    LR.candidiasisSkin,
    L.candidiasisSkinDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
candidiasisSkinDis.setPrintName(L.candidiasisSkinPrintName);
candidiasisSkinDis.setSuperDisease(LR.candidiasis);
candidiasisSkinDis.setMiscComments(L.candidiasisSkinComment);
candidiasisSkinDis.addReference("pp 205-7");
candidiasisSkinDis.addSymptom(LR.rash);
candidiasisSkinDis.addSymptom(LR.rashErupting);
candidiasisSkinDis.addSymptom(LR.rashScaly);
candidiasisSkinDis.addSymptom(LR.rashRed);
candidiasisSkinDis.addSymptom(LR.rashPapular);


// ------------- thrush  -------------
Disease thrushDis = new Disease(
    LR.thrush,
    L.thrushDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mouthSysSt,
    LR.none
);
thrushDis.setPrintName(L.thrushPrintName);
thrushDis.setSuperDisease(LR.candidiasis);
thrushDis.addReference("pp 205-7");
thrushDis.addSymptom(LR.mouthPain);
thrushDis.addSymptom(LR.mouthPatchWhite);
thrushDis.addSymptom(LR.mouthPatchYellow);


// ------------- cryptosporidiosis  -------------
Disease cryptosporidiosisDis = new Disease(
    LR.cryptosporidiosis,
    L.cryptosporidiosisDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    F.cryptosporidiosisFreq, // diagnosis frequency, -1 = unknown
    LR.intestinesSysSt,
    LR.protozoanInfection
);
cryptosporidiosisDis.setPrintName(L.cryptosporidiosisPrintName);
cryptosporidiosisDis.setMiscComments(L.cryptosporidiosisComment);
cryptosporidiosisDis.setTemperature(101.0f);
cryptosporidiosisDis.addSymptom(LR.abdomenCramping);
cryptosporidiosisDis.addSymptom(LR.anorexia);
cryptosporidiosisDis.addSymptom(LR.diarrheaWatery);
cryptosporidiosisDis.addSymptom(LR.gas);
cryptosporidiosisDis.addSymptom(LR.malaise);
cryptosporidiosisDis.addSymptom(LR.myalgia);
cryptosporidiosisDis.addSymptom(LR.nausea);
cryptosporidiosisDis.addSymptom(LR.vomiting);


// ------------- epsteinBarrDisease  -------------
Disease epsteinBarrDiseaseDis = new Disease(
    LR.epsteinBarrDisease,
    L.epsteinBarrDiseaseDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.epsteinBarrVirus
);
epsteinBarrDiseaseDis.setPrintName(L.epsteinBarrDiseasePrintName);
epsteinBarrDiseaseDis.setTemperature(101.0f);
epsteinBarrDiseaseDis.addReference("pp 1286-7");
epsteinBarrDiseaseDis.addSymptom(LR.feverSym);
epsteinBarrDiseaseDis.addSymptom(LR.lymphadenopathy);
epsteinBarrDiseaseDis.addSymptom(LR.throatSore);


// ------------- escherichiaColi  -------------
Disease escherichiaColiDis = new Disease(
    LR.escherichiaColi,
    L.escherichiaColiDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.escherichiaColiFreq, // diagnosis frequency, -1 = unknown
    LR.intestinesSysSt,
    LR.none
);
escherichiaColiDis.setPrintName(L.escherichiaColiPrintName);
escherichiaColiDis.setMiscComments(L.escherichiaColiComment);
escherichiaColiDis.addReference("pp 187-8");
escherichiaColiDis.addSymptom(LR.abdomenCramping);
escherichiaColiDis.addSymptom(LR.diarrheaBloody);
escherichiaColiDis.addSymptom(LR.feverSym, "", 0.5f);
escherichiaColiDis.addSymptom(LR.irritability);
escherichiaColiDis.addSymptom(LR.nausea);
escherichiaColiDis.addSymptom(LR.vomiting);
Treatment escherichiaColiTr1 = new Treatment("escherichiaColiTr1");
escherichiaColiTr1.addTreatmentAction(LR.fluidManagement);
escherichiaColiDis.addTreatment("escherichiaColiTr1");


// ------------- flu  -------------
Disease fluDis = new Disease(
    LR.flu,
    L.fluDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.respiratorySysSt,
    LR.myxovirusInfluenzaeInfection
);
fluDis.setPrintName(L.fluPrintName);
fluDis.setTemperature(102.5f);
fluDis.addCausesDisease(LR.conjunctivitis);
fluDis.addCausesDisease(LR.laryngitis);
fluDis.addReference("pp 220-1");
fluDis.addSymptom(LR.chills);
fluDis.addSymptom(LR.cough);
fluDis.addSymptom(LR.headache);
fluDis.addSymptom(LR.hoarseness);
fluDis.addSymptom(LR.malaise);
fluDis.addSymptom(LR.myalgia);
fluDis.addSymptom(LR.rhinitis);
fluDis.addSymptom(LR.noseDischarge);
Treatment fluTr1 = new Treatment("fluTr1");
fluTr1.addTreatmentAction(LR.bedRest);
fluTr1.addTreatmentAction(LR.fluidIncrease);
fluTr1.addDrug(LR.aspirin);
fluTr1.addDrug(LR.antitussive);
fluDis.addTreatment("fluTr1");


// ------------- gasGangrene  -------------
Disease gasGangreneDis = new Disease(
    LR.gasGangrene,
    L.gasGangreneDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.clostridiumPerfringensInfection
);
gasGangreneDis.setPrintName(L.gasGangrenePrintName);
gasGangreneDis.setTemperature(100.0f);
gasGangreneDis.addCausesAbnormalCondition(LR.hypovolemia);
gasGangreneDis.addReference("pp 178-80");
gasGangreneDis.addSymptom(LR.discoloration);
gasGangreneDis.addSymptom(LR.stoolMalodorous);
gasGangreneDis.addSymptom(LR.hypotension);
gasGangreneDis.addSymptom(LR.infectionSiteCrepitation);
gasGangreneDis.addSymptom(LR.pain);
gasGangreneDis.addSymptom(LR.tachycardia);
gasGangreneDis.addSymptom(LR.tachypnea);
Treatment gasGangreneTr1 = new Treatment("gasGangreneTr1");
gasGangreneTr1.addTreatmentAction(LR.IVFluids);
gasGangreneTr1.addTreatmentAction(LR.surgery);
gasGangreneTr1.addTreatmentAction(LR.hyperbaricOxygen);
gasGangreneTr1.addTreatmentAction(LR.painManagement);
gasGangreneTr1.addDrug(LR.antibiotics);
gasGangreneDis.addTreatment("gasGangreneTr1");


// ------------- giardiasis  -------------
Disease giardiasisDis = new Disease(
    LR.giardiasis,
    L.giardiasisDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.giardiasisFreq, // diagnosis frequency, -1 = unknown
    LR.intestinesSysSt,
    LR.protozoanInfection
);
giardiasisDis.setPrintName(L.giardiasisPrintName);
giardiasisDis.setMiscComments(L.giardiasisComment);
giardiasisDis.addReference("pp 256-7");
giardiasisDis.addSymptom(LR.abdomenCramping);
giardiasisDis.addSymptom(LR.nausea);
giardiasisDis.addSymptom(LR.diarrheaWatery);
giardiasisDis.addSymptom(LR.gas);
giardiasisDis.addSymptom(LR.stoolFrequent);
giardiasisDis.addSymptom(LR.stoolGreasy);
giardiasisDis.addSymptom(LR.stoolMalodorous);
Treatment giardiasisTr1 = new Treatment("giardiasisTr1");
giardiasisTr1.addDrug(LR.metronidazole);
giardiasisDis.addTreatment("giardiasisTr1");


// ------------- herpesSimplex  -------------
Disease herpesSimplexDis = new Disease(
    LR.herpesSimplex,
    L.herpesSimplexDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.herpesSimplexVirus
);
herpesSimplexDis.setPrintName(L.herpesSimplexPrintName);
herpesSimplexDis.setCode358(42);
herpesSimplexDis.setICD10code("B00");
herpesSimplexDis.addReference("pp 228-32");


// ------------- herpesSimplex1  -------------
Disease herpesSimplex1Dis = new Disease(
    LR.herpesSimplex1,
    L.herpesSimplex1Description,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.herpesSimplexVirus
);
herpesSimplex1Dis.setPrintName(L.herpesSimplex1PrintName);
herpesSimplex1Dis.setSuperDisease(LR.herpesSimplex);
herpesSimplex1Dis.setCode358(42);
herpesSimplex1Dis.setICD10code("B00");
herpesSimplex1Dis.addReference("pp 228-32");
herpesSimplex1Dis.addIllustration(D.HerpesSimplexJpg);
herpesSimplex1Dis.addSymptom(LR.vesicleMouth, L.herpesSimplex1_vesicleMouth, 1.0f);
herpesSimplex1Dis.addSymptom(LR.vesicleCheek, L.herpesSimplex1_vesicleCheek, 1.0f);
Treatment herpesSimplex1Tr1 = new Treatment("herpesSimplex1Tr1", LR.ifFever);
herpesSimplex1Tr1.addDrug(LR.analgetics);
herpesSimplex1Tr1.addDrug(LR.antipyretic);
herpesSimplex1Dis.addTreatment("herpesSimplex1Tr1");


// ------------- herpesZoster  -------------
Disease herpesZosterDis = new Disease(
    LR.herpesZoster,
    L.herpesZosterDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.herpesvirusVaricella
);
herpesZosterDis.setPrintName(L.herpesZosterPrintName);
herpesZosterDis.setMiscComments(L.herpesZosterComment);
herpesZosterDis.setTemperature(102.0f);
herpesZosterDis.setCode358(43);
herpesZosterDis.setICD10code("B02");
herpesZosterDis.addReference("pp 230-2");
Treatment herpesZosterTr1 = new Treatment("herpesZosterTr1");
herpesZosterTr1.addDrug(LR.antipruritics);
herpesZosterTr1.addDrug(LR.aspirin);
herpesZosterDis.addTreatment("herpesZosterTr1");
Treatment herpesZosterTr2 = new Treatment("herpesZosterTr2", LR.ifInfection);
herpesZosterTr2.addDrug(LR.antibiotics);
herpesZosterDis.addTreatment("herpesZosterTr2");
Treatment herpesZosterTr3 = new Treatment("herpesZosterTr3", LR.ifRash);
herpesZosterTr3.addDrug(LR.acyclovir);
herpesZosterDis.addTreatment("herpesZosterTr3");


// ------------- herpesZoster1  -------------
Disease herpesZoster1Dis = new Disease(
    LR.herpesZoster1,
    L.herpesZoster1Description,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
herpesZoster1Dis.setPrintName(L.herpesZoster1PrintName);
herpesZoster1Dis.setSuperDisease(LR.herpesZoster);
herpesZoster1Dis.setMiscComments(L.herpesZoster1Comment);
herpesZoster1Dis.setTemperature(102.0f);
herpesZoster1Dis.setCode358(43);
herpesZoster1Dis.setICD10code("B02");
herpesZoster1Dis.addCausesDisease(LR.herpesZoster2);
herpesZoster1Dis.addReference("pp 230-2");
herpesZoster1Dis.addSymptom(LR.malaise);
herpesZoster1Dis.addSymptom(LR.painDeep);
herpesZoster1Dis.addSymptom(LR.paresthesia);
herpesZoster1Dis.addSymptom(LR.pruritus);


// ------------- herpesZoster2  -------------
Disease herpesZoster2Dis = new Disease(
    LR.herpesZoster2,
    L.herpesZoster2Description,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
herpesZoster2Dis.setPrintName(L.herpesZoster2PrintName);
herpesZoster2Dis.setSuperDisease(LR.herpesZoster);
herpesZoster2Dis.setMiscComments(L.herpesZoster2Comment);
herpesZoster2Dis.setTemperature(102.0f);
herpesZoster2Dis.setCode358(43);
herpesZoster2Dis.setICD10code("B02");
herpesZoster2Dis.addInternalCause(LR.herpesZoster1);
herpesZoster2Dis.addCausesDisease(LR.herpesZoster3);
herpesZoster2Dis.addReference("pp 230-2");
herpesZoster2Dis.addSymptom(LR.malaise);
herpesZoster2Dis.addSymptom(LR.painDeep);
herpesZoster2Dis.addSymptom(LR.skinLesionRedNodule);
herpesZoster2Dis.addSymptom(LR.vesicle, L.herpesZoster2_vesicle, 1.0f);


// ------------- herpesZoster3  -------------
Disease herpesZoster3Dis = new Disease(
    LR.herpesZoster3,
    L.herpesZoster3Description,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
herpesZoster3Dis.setPrintName(L.herpesZoster3PrintName);
herpesZoster3Dis.setSuperDisease(LR.herpesZoster);
herpesZoster3Dis.setTemperature(102.0f);
herpesZoster3Dis.setCode358(43);
herpesZoster3Dis.setICD10code("B02");
herpesZoster3Dis.addInternalCause(LR.herpesZoster2);
herpesZoster3Dis.addCausesDisease(LR.postherpeticNeuralgia);
herpesZoster3Dis.addReference("pp 230-2");
herpesZoster3Dis.addSymptom(LR.malaise);
herpesZoster3Dis.addSymptom(LR.painDeep);
herpesZoster3Dis.addSymptom(LR.scab, L.herpesZoster3_scab, 1.0f);


// ------------- postherpeticNeuralgia  -------------
Disease postherpeticNeuralgiaDis = new Disease(
    LR.postherpeticNeuralgia,
    L.postherpeticNeuralgiaDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    50, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
postherpeticNeuralgiaDis.setPrintName(L.postherpeticNeuralgiaPrintName);
postherpeticNeuralgiaDis.setSuperDisease(LR.herpesZoster);
postherpeticNeuralgiaDis.setMiscComments(L.postherpeticNeuralgiaComment);
postherpeticNeuralgiaDis.setTemperature(102.0f);
postherpeticNeuralgiaDis.addInternalCause(LR.herpesZoster3);
postherpeticNeuralgiaDis.addReference("pp 230-2");
postherpeticNeuralgiaDis.addSymptom(LR.painDeep);
postherpeticNeuralgiaDis.addSymptom(LR.painBurning);
postherpeticNeuralgiaDis.addSymptom(LR.painStabbing);
postherpeticNeuralgiaDis.addSymptom(LR.painGnawing);


// ------------- listeriosisSuper  -------------
Disease listeriosisSuperDis = new Disease(
    LR.listeriosisSuper,
    L.listeriosisSuperDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -5, // duration
    F.listeriosisSuperFreq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
listeriosisSuperDis.setPrintName(L.listeriosisSuperPrintName);
listeriosisSuperDis.setTemperature(103.0f);
listeriosisSuperDis.addCausesDisease(LR.meningitis);
listeriosisSuperDis.addReference("pp 174-5");
listeriosisSuperDis.addSymptom(LR.diarrhea, "", 0.05f);
listeriosisSuperDis.addSymptom(LR.feverSym);
listeriosisSuperDis.addSymptom(LR.myalgia);
listeriosisSuperDis.addSymptom(LR.nausea, "", 0.05f);
listeriosisSuperDis.addSymptom(LR.vomiting, "", 0.05f);
Treatment listeriosisSuperTr1 = new Treatment("listeriosisSuperTr1");
listeriosisSuperTr1.addDrug(LR.ampicillin);
listeriosisSuperTr1.addDrug(LR.penicillin);
listeriosisSuperDis.addTreatment("listeriosisSuperTr1");


// ------------- listeriosisPregnant  -------------
Disease listeriosisPregnantDis = new Disease(
    LR.listeriosisPregnant,
    L.listeriosisPregnantDescription,
    LR.infections,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -5, // duration
    F.listeriosisPregnantFreq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
listeriosisPregnantDis.setPrintName(L.listeriosisPregnantPrintName);
listeriosisPregnantDis.setSuperDisease(LR.listeriosisSuper);
listeriosisPregnantDis.setMiscComments(L.listeriosisPregnantComment);
listeriosisPregnantDis.setTemperature(103.0f);
listeriosisPregnantDis.addReference("pp 174-5");
listeriosisPregnantDis.addSymptom(LR.backPain);
listeriosisPregnantDis.addSymptom(LR.chills);
listeriosisPregnantDis.addSymptom(LR.irritability, "", 0.4f);
listeriosisPregnantDis.addSymptom(LR.malaise);


// ------------- listeriosis  -------------
Disease listeriosisDis = new Disease(
    LR.listeriosis,
    L.listeriosisDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -5, // duration
    F.listeriosisFreq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
listeriosisDis.setPrintName(L.listeriosisPrintName);
listeriosisDis.setSuperDisease(LR.listeriosisSuper);
listeriosisDis.setTemperature(103.0f);
listeriosisDis.addReference("pp 174-5");
listeriosisDis.addSymptom(LR.convulsions, "", 0.1f);
listeriosisDis.addSymptom(LR.headache, "", 0.1f);
listeriosisDis.addSymptom(LR.lossOfBalance, "", 0.1f);
listeriosisDis.addSymptom(LR.malaise);
listeriosisDis.addSymptom(LR.neckStiff, "", 0.1f);


// ------------- lymeDisease  -------------
Disease lymeDiseaseDis = new Disease(
    LR.lymeDisease,
    L.lymeDiseaseDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    F.lymeDiseaseFreq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.borreliaBurgdorferiSpirochete
);
lymeDiseaseDis.setPrintName(L.lymeDiseasePrintName);
lymeDiseaseDis.setMiscComments(L.lymeDiseaseComment);
lymeDiseaseDis.setCode358(33);
lymeDiseaseDis.setICD10code("A69");
lymeDiseaseDis.addInternalCause(LR.tickBite);
lymeDiseaseDis.addCausesDisease(LR.encephalitis);
lymeDiseaseDis.addReference("pp 199-200");
Treatment lymeDiseaseTr1 = new Treatment("lymeDiseaseTr1");
lymeDiseaseTr1.addDrug(LR.antibiotics);
lymeDiseaseDis.addTreatment("lymeDiseaseTr1");


// ------------- lymeDisease1  -------------
Disease lymeDisease1Dis = new Disease(
    LR.lymeDisease1,
    L.lymeDisease1Description,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -5, // duration
    F.lymeDisease1Freq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
lymeDisease1Dis.setPrintName(L.lymeDisease1PrintName);
lymeDisease1Dis.setSuperDisease(LR.lymeDisease);
lymeDisease1Dis.setTemperature(101.0f);
lymeDisease1Dis.setCode358(33);
lymeDisease1Dis.setICD10code("A69");
lymeDisease1Dis.addCausesDisease(LR.lymeDisease2);
lymeDisease1Dis.addCausesDisease(LR.hepatitis);
lymeDisease1Dis.addCausesAbnormalCondition(LR.splenomegaly);
lymeDisease1Dis.addReference("pp 199-200");
lymeDisease1Dis.addSymptom(LR.throatSore, L.lymeDisease1_throatSore, 0.05f);
lymeDisease1Dis.addSymptom(LR.coughDry, L.lymeDisease1_coughDry, 0.05f);
lymeDisease1Dis.addSymptom(LR.papuleRedWarm, L.lymeDisease1_papuleRedWarm, 1.0f);
lymeDisease1Dis.addSymptom(LR.blotchesRed, L.lymeDisease1_blotchesRed, 1.0f);
lymeDisease1Dis.addSymptom(LR.chills, L.lymeDisease1_chills, 0.2f);
lymeDisease1Dis.addSymptom(LR.fatigue);
lymeDisease1Dis.addSymptom(LR.headache, L.lymeDisease1_headache, 0.2f);
lymeDisease1Dis.addSymptom(LR.lymphadenopathy, L.lymeDisease1_lymphadenopathy, 0.2f);
lymeDisease1Dis.addSymptom(LR.malaise);
lymeDisease1Dis.addSymptom(LR.neckStiff, L.lymeDisease1_neckStiff, 0.2f);
lymeDisease1Dis.addSymptom(LR.myalgia, L.lymeDisease1_myalgia, 0.1f);


// ------------- lymeDisease2  -------------
Disease lymeDisease2Dis = new Disease(
    LR.lymeDisease2,
    L.lymeDisease2Description,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -10, // duration
    F.lymeDisease2Freq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
lymeDisease2Dis.setPrintName(L.lymeDisease2PrintName);
lymeDisease2Dis.setSuperDisease(LR.lymeDisease);
lymeDisease2Dis.setMiscComments(L.lymeDisease2Comment);
lymeDisease2Dis.setCode358(33);
lymeDisease2Dis.setICD10code("A69");
lymeDisease2Dis.addInternalCause(LR.lymeDisease1);
lymeDisease2Dis.addCausesDisease(LR.lymeDisease3);
lymeDisease2Dis.addCausesDisease(LR.meningitis);
lymeDisease2Dis.addCausesAbnormalCondition(LR.cardiacEnlargement);
lymeDisease2Dis.addCausesAbnormalCondition(LR.neurologicDeficiences);
lymeDisease2Dis.addCausesAbnormalCondition(LR.atrioventricularHeartBlock);
lymeDisease2Dis.addCausesAbnormalCondition(LR.leftVentricularDysfunction);
lymeDisease2Dis.addReference("pp 199-200");
lymeDisease2Dis.addSymptom(LR.palsyFace);


// ------------- lymeDisease3  -------------
Disease lymeDisease3Dis = new Disease(
    LR.lymeDisease3,
    L.lymeDisease3Description,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -10, // duration
    F.lymeDisease3Freq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
lymeDisease3Dis.setPrintName(L.lymeDisease3PrintName);
lymeDisease3Dis.setSuperDisease(LR.lymeDisease);
lymeDisease3Dis.setCode358(33);
lymeDisease3Dis.setICD10code("A69");
lymeDisease3Dis.addInternalCause(LR.lymeDisease2);
lymeDisease3Dis.addCausesDisease(LR.arthritis);
lymeDisease3Dis.addReference("pp 199-200");
lymeDisease3Dis.addSymptom(LR.myalgia);
lymeDisease3Dis.addSymptom(LR.jointSwelling);


// ------------- malaria  -------------
Disease malariaDis = new Disease(
    LR.malaria,
    L.malariaDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    F.malariaFreq, // diagnosis frequency, -1 = unknown
    LR.liverSysSt,
    LR.none
);
malariaDis.setPrintName(L.malariaPrintName);
malariaDis.setMiscComments(L.malariaComment);
malariaDis.setTemperature(105.0f);
malariaDis.setCode358(58);
malariaDis.setICD10code("B50");
malariaDis.addCausesDisease(LR.malaria2);
malariaDis.addReference("pp 250-4");
malariaDis.addSymptom(LR.chills);
malariaDis.addSymptom(LR.headache);
malariaDis.addSymptom(LR.myalgia);
malariaDis.addSymptom(LR.shaking);
malariaDis.addSymptom(LR.sweating);
Treatment malariaTr1 = new Treatment("malariaTr1");
malariaTr1.addDrug(LR.chloroquine);
malariaDis.addTreatment("malariaTr1");


// ------------- malaria2  -------------
Disease malaria2Dis = new Disease(
    LR.malaria2,
    L.malaria2Description,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    F.malaria2Freq, // diagnosis frequency, -1 = unknown
    LR.liverSysSt,
    LR.none
);
malaria2Dis.setPrintName(L.malaria2PrintName);
malaria2Dis.setMiscComments(L.malaria2Comment);
malaria2Dis.setTemperature(105.0f);
malaria2Dis.setCode358(58);
malaria2Dis.setICD10code("B50");
malaria2Dis.addInternalCause(LR.malaria);
malaria2Dis.addCausesDisease(LR.disseminatedIntravascularCoagulation);
malaria2Dis.addCausesAbnormalCondition(LR.uremia);
malaria2Dis.addReference("pp 250-4");
malaria2Dis.addSymptom(LR.abdomenPain);
malaria2Dis.addSymptom(LR.anuria);
malaria2Dis.addSymptom(LR.coma);
malaria2Dis.addSymptom(LR.cough);
malaria2Dis.addSymptom(LR.delirium);
malaria2Dis.addSymptom(LR.diarrhea);
malaria2Dis.addSymptom(LR.hemoptysis);
malaria2Dis.addSymptom(LR.oliguria);
malaria2Dis.addSymptom(LR.seizure);
malaria2Dis.addSymptom(LR.vomiting);
malaria2Dis.addSymptom(LR.hemiparesis);
malaria2Dis.addSymptom(LR.melena);


// ------------- meningococcemia  -------------
Disease meningococcemiaDis = new Disease(
    LR.meningococcemia,
    L.meningococcemiaDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    F.meningococcemiaFreq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.neisseriaMeningitidisInfection
);
meningococcemiaDis.setPrintName(L.meningococcemiaPrintName);
meningococcemiaDis.setTemperature(102.0f);
meningococcemiaDis.setCode358(22);
meningococcemiaDis.setICD10code("A39");
meningococcemiaDis.addCausesDisease(LR.meningococcemiaSevere);
meningococcemiaDis.addReference("pp 172-3");
meningococcemiaDis.addSymptom(LR.arthralgia);
meningococcemiaDis.addSymptom(LR.chills);
meningococcemiaDis.addSymptom(LR.cough);
meningococcemiaDis.addSymptom(LR.headache);
meningococcemiaDis.addSymptom(LR.hypotension);
meningococcemiaDis.addSymptom(LR.myalgia);
meningococcemiaDis.addSymptom(LR.rash);
meningococcemiaDis.addSymptom(LR.tachycardia);
meningococcemiaDis.addSymptom(LR.tachypnea);
meningococcemiaDis.addSymptom(LR.throatSore);
Treatment meningococcemiaTr1 = new Treatment("meningococcemiaTr1");
meningococcemiaTr1.addDrug(LR.ampicillin);
meningococcemiaTr1.addDrug(LR.penicillinG);
meningococcemiaDis.addTreatment("meningococcemiaTr1");
Treatment meningococcemiaTr2 = new Treatment("meningococcemiaTr2");
meningococcemiaTr2.addTreatmentAction(LR.bedRest);
meningococcemiaTr2.addTreatmentAction(LR.electrolyteReplacement);
meningococcemiaTr2.addTreatmentAction(LR.fluidManagement);
meningococcemiaDis.addTreatment("meningococcemiaTr2");


// ------------- meningococcemiaSevere  -------------
Disease meningococcemiaSevereDis = new Disease(
    LR.meningococcemiaSevere,
    L.meningococcemiaSevereDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    F.meningococcemiaSevereFreq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.neisseriaMeningitidisInfection
);
meningococcemiaSevereDis.setPrintName(L.meningococcemiaSeverePrintName);
meningococcemiaSevereDis.setMiscComments(L.meningococcemiaSevereComment);
meningococcemiaSevereDis.setTemperature(102.0f);
meningococcemiaSevereDis.addInternalCause(LR.meningococcemia);
meningococcemiaSevereDis.addCausesDisease(LR.disseminatedIntravascularCoagulation);
meningococcemiaSevereDis.addCausesAbnormalCondition(LR.shock);
meningococcemiaSevereDis.addReference("pp 172-3");
meningococcemiaSevereDis.addSymptom(LR.skinLesionEnlarged);
meningococcemiaSevereDis.addSymptom(LR.arthralgia);
meningococcemiaSevereDis.addSymptom(LR.chills);
meningococcemiaSevereDis.addSymptom(LR.cough);
meningococcemiaSevereDis.addSymptom(LR.headache);
meningococcemiaSevereDis.addSymptom(LR.hypotension);
meningococcemiaSevereDis.addSymptom(LR.myalgia);
meningococcemiaSevereDis.addSymptom(LR.rash);
meningococcemiaSevereDis.addSymptom(LR.tachycardia);
meningococcemiaSevereDis.addSymptom(LR.tachypnea);
meningococcemiaSevereDis.addSymptom(LR.throatSore);


// ------------- mumps  -------------
Disease mumpsDis = new Disease(
    LR.mumps,
    L.mumpsDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    6, // minAge
    8, // maxAge
    -4, // duration
    F.mumpsFreq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
mumpsDis.setPrintName(L.mumpsPrintName);
mumpsDis.addReference("pp 238-9");
mumpsDis.addSymptom(LR.anorexia);
mumpsDis.addSymptom(LR.chills);
mumpsDis.addSymptom(LR.fatigue);
mumpsDis.addSymptom(LR.feverSym);
mumpsDis.addSymptom(LR.malaise);
mumpsDis.addSymptom(LR.myalgia);
mumpsDis.addSymptom(LR.parotidGlandsSwollen);
mumpsDis.addSymptom(LR.throatSore);
mumpsDis.addSymptom(LR.weakness);
Treatment mumpsTr1 = new Treatment("mumpsTr1");
mumpsTr1.addTreatmentAction(LR.ifFeverProvideAntipyretic);
mumpsTr1.addDrug(LR.analgetics);
mumpsDis.addTreatment("mumpsTr1");


// ------------- poliomyelitis  -------------
Disease poliomyelitisDis = new Disease(
    LR.poliomyelitis,
    L.poliomyelitisDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -7, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.poliovirus
);
poliomyelitisDis.setPrintName(L.poliomyelitisPrintName);
poliomyelitisDis.setTemperature(99.8f);
poliomyelitisDis.setCode358(37);
poliomyelitisDis.setICD10code("A80");
poliomyelitisDis.addReference("pp 234-237");


// ------------- poliomyelitisMinor  -------------
Disease poliomyelitisMinorDis = new Disease(
    LR.poliomyelitisMinor,
    L.poliomyelitisMinorDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
poliomyelitisMinorDis.setPrintName(L.poliomyelitisMinorPrintName);
poliomyelitisMinorDis.setSuperDisease(LR.poliomyelitis);
poliomyelitisMinorDis.setTemperature(101.0f);
poliomyelitisMinorDis.setCode358(37);
poliomyelitisMinorDis.setICD10code("A80");
poliomyelitisMinorDis.addReference("pp 234-237");
poliomyelitisMinorDis.addSymptom(LR.abdomenPain);
poliomyelitisMinorDis.addSymptom(LR.constipation);
poliomyelitisMinorDis.addSymptom(LR.feverSym);
poliomyelitisMinorDis.addSymptom(LR.headache);
poliomyelitisMinorDis.addSymptom(LR.malaise);
poliomyelitisMinorDis.addSymptom(LR.nausea);
poliomyelitisMinorDis.addSymptom(LR.throatSore);
poliomyelitisMinorDis.addSymptom(LR.vomiting);


// ------------- poliomyelitisNonparalytic  -------------
Disease poliomyelitisNonparalyticDis = new Disease(
    LR.poliomyelitisNonparalytic,
    L.poliomyelitisNonparalyticDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
poliomyelitisNonparalyticDis.setPrintName(L.poliomyelitisNonparalyticPrintName);
poliomyelitisNonparalyticDis.setSuperDisease(LR.poliomyelitis);
poliomyelitisNonparalyticDis.setTemperature(101.0f);
poliomyelitisNonparalyticDis.setCode358(37);
poliomyelitisNonparalyticDis.setICD10code("A80");
poliomyelitisNonparalyticDis.addReference("pp 234-237");
poliomyelitisNonparalyticDis.addSymptom(LR.headache);
poliomyelitisNonparalyticDis.addSymptom(LR.vomiting);
poliomyelitisNonparalyticDis.addSymptom(LR.abdomenPain);
poliomyelitisNonparalyticDis.addSymptom(LR.armPain);
poliomyelitisNonparalyticDis.addSymptom(LR.backPain);
poliomyelitisNonparalyticDis.addSymptom(LR.irritability);
poliomyelitisNonparalyticDis.addSymptom(LR.legPain);
poliomyelitisNonparalyticDis.addSymptom(LR.lethargy);
poliomyelitisNonparalyticDis.addSymptom(LR.muscleTender);
poliomyelitisNonparalyticDis.addSymptom(LR.neckPain);
poliomyelitisNonparalyticDis.addSymptom(LR.neckSpasm);
poliomyelitisNonparalyticDis.addSymptom(LR.weakness);
Treatment poliomyelitisNonparalyticTr1 = new Treatment("poliomyelitisNonparalyticTr1");
poliomyelitisNonparalyticTr1.addDrug(LR.analgetics);
poliomyelitisNonparalyticDis.addTreatment("poliomyelitisNonparalyticTr1");


// ------------- poliomyelitisParalytic  -------------
Disease poliomyelitisParalyticDis = new Disease(
    LR.poliomyelitisParalytic,
    L.poliomyelitisParalyticDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -7, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
poliomyelitisParalyticDis.setPrintName(L.poliomyelitisParalyticPrintName);
poliomyelitisParalyticDis.setSuperDisease(LR.poliomyelitis);
poliomyelitisParalyticDis.setTemperature(101.0f);
poliomyelitisParalyticDis.setCode358(37);
poliomyelitisParalyticDis.setICD10code("A80");
poliomyelitisParalyticDis.addReference("pp 234-237");
poliomyelitisParalyticDis.addSymptom(LR.headache);
poliomyelitisParalyticDis.addSymptom(LR.vomiting);
poliomyelitisParalyticDis.addSymptom(LR.abdomenPain);
poliomyelitisParalyticDis.addSymptom(LR.armPain);
poliomyelitisParalyticDis.addSymptom(LR.backPain);
poliomyelitisParalyticDis.addSymptom(LR.irritability);
poliomyelitisParalyticDis.addSymptom(LR.legPain);
poliomyelitisParalyticDis.addSymptom(LR.lethargy);
poliomyelitisParalyticDis.addSymptom(LR.muscleTender);
poliomyelitisParalyticDis.addSymptom(LR.neckPain);
poliomyelitisParalyticDis.addSymptom(LR.neckSpasm);
poliomyelitisParalyticDis.addSymptom(LR.weakness);
poliomyelitisParalyticDis.addSymptom(LR.abdomenDistension);
poliomyelitisParalyticDis.addSymptom(LR.constipation);
poliomyelitisParalyticDis.addSymptom(LR.paresthesia);
poliomyelitisParalyticDis.addSymptom(LR.reflexControlLoss);
poliomyelitisParalyticDis.addSymptom(LR.urineRetention);
Treatment poliomyelitisParalyticTr1 = new Treatment("poliomyelitisParalyticTr1");
poliomyelitisParalyticTr1.addTreatmentAction(LR.bedRest);
poliomyelitisParalyticDis.addTreatment("poliomyelitisParalyticTr1");


// ------------- rabies  -------------
Disease rabiesDis = new Disease(
    LR.rabies,
    L.rabiesDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    F.rabiesFreq, // diagnosis frequency, -1 = unknown
    LR.centralNervousSysSt,
    LR.none
);
rabiesDis.setPrintName(L.rabiesPrintName);
rabiesDis.setMiscComments(L.rabiesComment);
rabiesDis.setTemperature(101.5f);
rabiesDis.setCode358(38);
rabiesDis.setICD10code("A82");
rabiesDis.addCausesAbnormalCondition(LR.cranialNerveDysfunction);
rabiesDis.addReference("pp 240-2");
rabiesDis.addSymptom(LR.anorexia);
rabiesDis.addSymptom(LR.burningSensation);
rabiesDis.addSymptom(LR.headache);
rabiesDis.addSymptom(LR.hydrophobia);
rabiesDis.addSymptom(LR.irritability);
rabiesDis.addSymptom(LR.lacrimation);
rabiesDis.addSymptom(LR.malaise);
rabiesDis.addSymptom(LR.nausea);
rabiesDis.addSymptom(LR.noiseSensitivity);
rabiesDis.addSymptom(LR.pain);
rabiesDis.addSymptom(LR.perspiration);
rabiesDis.addSymptom(LR.photophobia);
rabiesDis.addSymptom(LR.pupilDilation);
rabiesDis.addSymptom(LR.salivation);
rabiesDis.addSymptom(LR.throatSore);
Treatment rabiesTr1 = new Treatment("rabiesTr1");
rabiesTr1.addDrug(LR.rabiesImmuneGlobin);
rabiesDis.addTreatment("rabiesTr1");


// ------------- rockyMountainSpottedFever  -------------
Disease rockyMountainSpottedFeverDis = new Disease(
    LR.rockyMountainSpottedFever,
    L.rockyMountainSpottedFeverDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    F.rockyMountainSpottedFeverFreq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
rockyMountainSpottedFeverDis.setPrintName(L.rockyMountainSpottedFeverPrintName);
rockyMountainSpottedFeverDis.setMiscComments(L.rockyMountainSpottedFeverComment);
rockyMountainSpottedFeverDis.setTemperature(103.0f);
rockyMountainSpottedFeverDis.addInternalCause(LR.tickBite);
rockyMountainSpottedFeverDis.addReference("pp 246-8");
rockyMountainSpottedFeverDis.addSymptom(LR.bonePain);
rockyMountainSpottedFeverDis.addSymptom(LR.headacheSevere);
rockyMountainSpottedFeverDis.addSymptom(LR.jointPain);
rockyMountainSpottedFeverDis.addSymptom(LR.myalgia);
rockyMountainSpottedFeverDis.addSymptom(LR.nausea);
rockyMountainSpottedFeverDis.addSymptom(LR.vomiting);
rockyMountainSpottedFeverDis.addSymptom(LR.chills);
rockyMountainSpottedFeverDis.addSymptom(LR.fatigue);
rockyMountainSpottedFeverDis.addSymptom(LR.rashErupting);
rockyMountainSpottedFeverDis.addSymptom(LR.tongueCoating);
Treatment rockyMountainSpottedFeverTr1 = new Treatment("rockyMountainSpottedFeverTr1");
rockyMountainSpottedFeverTr1.addDrug(LR.antibiotics);
rockyMountainSpottedFeverDis.addTreatment("rockyMountainSpottedFeverTr1");


// ------------- rubella  -------------
Disease rubellaDis = new Disease(
    LR.rubella,
    L.rubellaDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    25, // maxAge
    -4, // duration
    F.rubellaFreq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
rubellaDis.setPrintName(L.rubellaPrintName);
rubellaDis.setMiscComments(L.rubellaComment);
rubellaDis.setTemperature(101.0f);
rubellaDis.setCode358(46);
rubellaDis.setICD10code("B06");
rubellaDis.addReference("pp 224-6");
rubellaDis.addSymptom(LR.appetiteLoss, "", 0.5f);
rubellaDis.addSymptom(LR.headache, "", 0.5f);
rubellaDis.addSymptom(LR.jointPain, "", 0.5f);
rubellaDis.addSymptom(LR.lymphadenopathy);
rubellaDis.addSymptom(LR.rashPapular);
rubellaDis.addSymptom(LR.throatSore, "", 0.5f);
Treatment rubellaTr1 = new Treatment("rubellaTr1");
rubellaTr1.addDrug(LR.aspirin);
rubellaDis.addTreatment("rubellaTr1");


// ------------- salmonellosis  -------------
Disease salmonellosisDis = new Disease(
    LR.salmonellosis,
    L.salmonellosisDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.infection
);
salmonellosisDis.setPrintName(L.salmonellosisPrintName);
salmonellosisDis.setMiscComments(L.salmonellosisComment);
salmonellosisDis.setTemperature(101.0f);
salmonellosisDis.addReference("pp 182-5");
salmonellosisDis.addSymptom(LR.abdomenPain);
Treatment salmonellosisTr1 = new Treatment("salmonellosisTr1");
salmonellosisTr1.addTreatmentAction(LR.bedRest);
salmonellosisTr1.addTreatmentAction(LR.electrolyteReplacement);
salmonellosisTr1.addTreatmentAction(LR.fluidIncrease);
salmonellosisDis.addTreatment("salmonellosisTr1");


// ------------- salmonellosisBacteremia  -------------
Disease salmonellosisBacteremiaDis = new Disease(
    LR.salmonellosisBacteremia,
    L.salmonellosisBacteremiaDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vascularSysSt,
    LR.none
);
salmonellosisBacteremiaDis.setPrintName(L.salmonellosisBacteremiaPrintName);
salmonellosisBacteremiaDis.setSuperDisease(LR.salmonellosis);
salmonellosisBacteremiaDis.setMiscComments(L.salmonellosisBacteremiaComment);
salmonellosisBacteremiaDis.setTemperature(101.0f);
salmonellosisBacteremiaDis.addReference("pp 182-5");
salmonellosisBacteremiaDis.addSymptom(LR.anorexia);
salmonellosisBacteremiaDis.addSymptom(LR.chills);
salmonellosisBacteremiaDis.addSymptom(LR.jointPain);
salmonellosisBacteremiaDis.addSymptom(LR.weightLoss);
Treatment salmonellosisBacteremiaTr1 = new Treatment("salmonellosisBacteremiaTr1");
salmonellosisBacteremiaTr1.addDrug(LR.amoxicillin);
salmonellosisBacteremiaTr1.addDrug(LR.chloramphenicol);
salmonellosisBacteremiaDis.addTreatment("salmonellosisBacteremiaTr1");


// ------------- salmonellosisEnterocolitis  -------------
Disease salmonellosisEnterocolitisDis = new Disease(
    LR.salmonellosisEnterocolitis,
    L.salmonellosisEnterocolitisDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.salmonellosisEnterocolitisFreq, // diagnosis frequency, -1 = unknown
    LR.intestinesSysSt,
    LR.none
);
salmonellosisEnterocolitisDis.setPrintName(L.salmonellosisEnterocolitisPrintName);
salmonellosisEnterocolitisDis.setSuperDisease(LR.salmonellosis);
salmonellosisEnterocolitisDis.setMiscComments(L.salmonellosisEnterocolitisComment);
salmonellosisEnterocolitisDis.setTemperature(101.0f);
salmonellosisEnterocolitisDis.addReference("pp 182-5");
salmonellosisEnterocolitisDis.addSymptom(LR.chills);
salmonellosisEnterocolitisDis.addSymptom(LR.diarrhea);
salmonellosisEnterocolitisDis.addSymptom(LR.feverSym);
salmonellosisEnterocolitisDis.addSymptom(LR.myalgia);
salmonellosisEnterocolitisDis.addSymptom(LR.nausea);
salmonellosisEnterocolitisDis.addSymptom(LR.vomiting);


// ------------- typhoidFever1  -------------
Disease typhoidFever1Dis = new Disease(
    LR.typhoidFever1,
    L.typhoidFever1Description,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.typhoidFever1Freq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
typhoidFever1Dis.setPrintName(L.typhoidFever1PrintName);
typhoidFever1Dis.setSuperDisease(LR.salmonellosis);
typhoidFever1Dis.setMiscComments(L.typhoidFever1Comment);
typhoidFever1Dis.setTemperature(101.0f);
typhoidFever1Dis.setCode358(5);
typhoidFever1Dis.setICD10code("A01");
typhoidFever1Dis.addCausesDisease(LR.typhoidFever2);
typhoidFever1Dis.addReference("pp 182-5");
typhoidFever1Dis.addSymptom(LR.diarrhea);
typhoidFever1Dis.addSymptom(LR.nausea);
typhoidFever1Dis.addSymptom(LR.vomiting);
typhoidFever1Dis.addSymptom(LR.anorexia);
typhoidFever1Dis.addSymptom(LR.headache);
typhoidFever1Dis.addSymptom(LR.malaise);
typhoidFever1Dis.addSymptom(LR.myalgia);
typhoidFever1Dis.addSymptom(LR.pulseWeak);


// ------------- typhoidFever2  -------------
Disease typhoidFever2Dis = new Disease(
    LR.typhoidFever2,
    L.typhoidFever2Description,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.typhoidFever2Freq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
typhoidFever2Dis.setPrintName(L.typhoidFever2PrintName);
typhoidFever2Dis.setSuperDisease(LR.salmonellosis);
typhoidFever2Dis.setMiscComments(L.typhoidFever2Comment);
typhoidFever2Dis.setTemperature(103.0f);
typhoidFever2Dis.setCode358(5);
typhoidFever2Dis.setICD10code("A01");
typhoidFever2Dis.addInternalCause(LR.typhoidFever1);
typhoidFever2Dis.addCausesDisease(LR.typhoidFever3);
typhoidFever2Dis.addReference("pp 182-5");
typhoidFever2Dis.addSymptom(LR.diarrhea, "", 0.5f);
typhoidFever2Dis.addSymptom(LR.malaise);
typhoidFever2Dis.addSymptom(LR.abdomenDistension);
typhoidFever2Dis.addSymptom(LR.chills);
typhoidFever2Dis.addSymptom(LR.constipation, "", 0.5f);
typhoidFever2Dis.addSymptom(LR.cough);
typhoidFever2Dis.addSymptom(LR.crackles);
typhoidFever2Dis.addSymptom(LR.delirium);
typhoidFever2Dis.addSymptom(LR.diaphoresis);
typhoidFever2Dis.addSymptom(LR.rashPapular);
typhoidFever2Dis.addSymptom(LR.weakness);


// ------------- typhoidFever3  -------------
Disease typhoidFever3Dis = new Disease(
    LR.typhoidFever3,
    L.typhoidFever3Description,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.typhoidFever3Freq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
typhoidFever3Dis.setPrintName(L.typhoidFever3PrintName);
typhoidFever3Dis.setSuperDisease(LR.salmonellosis);
typhoidFever3Dis.setMiscComments(L.typhoidFever3Comment);
typhoidFever3Dis.setTemperature(103.0f);
typhoidFever3Dis.setCode358(5);
typhoidFever3Dis.setICD10code("A01");
typhoidFever3Dis.addInternalCause(LR.typhoidFever2);
typhoidFever3Dis.addReference("pp 182-5");
typhoidFever3Dis.addSymptom(LR.malaise);
typhoidFever3Dis.addSymptom(LR.weakness);
typhoidFever3Dis.addSymptom(LR.fatigue);


// ------------- schistosomiasis  -------------
Disease schistosomiasisDis = new Disease(
    LR.schistosomiasis,
    L.schistosomiasisDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.intestinesSysSt,
    LR.infection
);
schistosomiasisDis.setPrintName(L.schistosomiasisPrintName);
schistosomiasisDis.setMiscComments(L.schistosomiasisComment);
schistosomiasisDis.setTemperature(101.5f);
schistosomiasisDis.addCausesDisease(LR.heartFailure);
schistosomiasisDis.addCausesDisease(LR.pulmonaryHypertension);
schistosomiasisDis.addCausesDisease(LR.renalFailureAcute);
schistosomiasisDis.addCausesAbnormalCondition(LR.hepatomegaly);
schistosomiasisDis.addCausesAbnormalCondition(LR.splenomegaly);
schistosomiasisDis.addCausesAbnormalCondition(LR.ascites);
schistosomiasisDis.addReference("pp 265-6");
schistosomiasisDis.addSymptom(LR.cough);
schistosomiasisDis.addSymptom(LR.myalgia);
schistosomiasisDis.addSymptom(LR.paralysisTransient, L.schistosomiasis_paralysisTransient, 0.3f);
schistosomiasisDis.addSymptom(LR.rashErupting);
schistosomiasisDis.addSymptom(LR.seizure, L.schistosomiasis_seizure, 0.3f);
schistosomiasisDis.addSymptom(LR.ulcer, L.schistosomiasis_ulcer, 0.3f);
Treatment schistosomiasisTr1 = new Treatment("schistosomiasisTr1");
schistosomiasisTr1.addDrug(LR.praziquantel);
schistosomiasisDis.addTreatment("schistosomiasisTr1");


// ------------- septicShock  -------------
Disease septicShockDis = new Disease(
    LR.septicShock,
    L.septicShockDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.infection
);
septicShockDis.setPrintName(L.septicShockPrintName);
septicShockDis.setMiscComments(L.septicShockComment);
septicShockDis.addReference("pp 191-3");
Treatment septicShockTr1 = new Treatment("septicShockTr1");
septicShockTr1.addTreatmentAction(LR.IVFluids);
septicShockTr1.addTreatmentAction(LR.vasopressor);
septicShockTr1.addTreatmentAction(LR.colloidCrystalloidInfusions);
septicShockTr1.addDrug(LR.antimicrobials);
septicShockTr1.addDrug(LR.diuretics);
septicShockDis.addTreatment("septicShockTr1");


// ------------- septicShockEarlyPhase  -------------
Disease septicShockEarlyPhaseDis = new Disease(
    LR.septicShockEarlyPhase,
    L.septicShockEarlyPhaseDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.infection
);
septicShockEarlyPhaseDis.setPrintName(L.septicShockEarlyPhasePrintName);
septicShockEarlyPhaseDis.setSuperDisease(LR.septicShock);
septicShockEarlyPhaseDis.setTemperature(101.0f);
septicShockEarlyPhaseDis.addCausesAbnormalCondition(LR.hyperglycemia);
septicShockEarlyPhaseDis.addReference("pp 191-3");
septicShockEarlyPhaseDis.addSymptom(LR.chills);
septicShockEarlyPhaseDis.addSymptom(LR.diarrhea);
septicShockEarlyPhaseDis.addSymptom(LR.feverRapidOnset);
septicShockEarlyPhaseDis.addSymptom(LR.nausea);
septicShockEarlyPhaseDis.addSymptom(LR.oliguria);
septicShockEarlyPhaseDis.addSymptom(LR.prostration);
septicShockEarlyPhaseDis.addSymptom(LR.pulseFullBounding);
septicShockEarlyPhaseDis.addSymptom(LR.tachycardia);
septicShockEarlyPhaseDis.addSymptom(LR.tachypnea);
septicShockEarlyPhaseDis.addSymptom(LR.vomiting);


// ------------- septicShockLatePhase  -------------
Disease septicShockLatePhaseDis = new Disease(
    LR.septicShockLatePhase,
    L.septicShockLatePhaseDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.infection
);
septicShockLatePhaseDis.setPrintName(L.septicShockLatePhasePrintName);
septicShockLatePhaseDis.setMiscComments(L.septicShockLatePhaseComment);
septicShockLatePhaseDis.addCausesAbnormalCondition(LR.hypoglycemia);
septicShockLatePhaseDis.addReference("pp 191-3");
septicShockLatePhaseDis.addSymptom(LR.anuria);
septicShockLatePhaseDis.addSymptom(LR.apprehension);
septicShockLatePhaseDis.addSymptom(LR.consciousnessDecreased);
septicShockLatePhaseDis.addSymptom(LR.hyperventilation);
septicShockLatePhaseDis.addSymptom(LR.hypotension);
septicShockLatePhaseDis.addSymptom(LR.hypothermia);
septicShockLatePhaseDis.addSymptom(LR.irritability);
septicShockLatePhaseDis.addSymptom(LR.restlessness);
septicShockLatePhaseDis.addSymptom(LR.thirst);


// ------------- shigellosis  -------------
Disease shigellosisDis = new Disease(
    LR.shigellosis,
    L.shigellosisDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    F.shigellosisFreq, // diagnosis frequency, -1 = unknown
    LR.intestinesSysSt,
    LR.infection
);
shigellosisDis.setPrintName(L.shigellosisPrintName);
shigellosisDis.setMiscComments(L.shigellosisComment);
shigellosisDis.setTemperature(101.0f);
shigellosisDis.setCode358(7);
shigellosisDis.setICD10code("A03");
shigellosisDis.addReference("pp 182-5");
shigellosisDis.addSymptom(LR.abdomenPain);
shigellosisDis.addSymptom(LR.abdomenCramping);
shigellosisDis.addSymptom(LR.diarrhea);
shigellosisDis.addSymptom(LR.diarrheaBloody, "", 0.8f);
shigellosisDis.addSymptom(LR.feverSym);
shigellosisDis.addSymptom(LR.nausea);
shigellosisDis.addSymptom(LR.vomiting);
Treatment shigellosisTr1 = new Treatment("shigellosisTr1");
shigellosisTr1.addTreatmentAction(LR.fluidManagement);
shigellosisDis.addTreatment("shigellosisTr1");
Treatment shigellosisTr2 = new Treatment("shigellosisTr2", LR.ifSevere);
shigellosisTr2.addTreatmentAction(LR.hospitalization);
shigellosisTr2.addDrug(LR.ampicillin);
shigellosisTr2.addDrug(LR.coTrimoxazole);
shigellosisTr2.addDrug(LR.tetracycline);
shigellosisDis.addTreatment("shigellosisTr2");


// ------------- streptococcalInfection  -------------
Disease streptococcalInfectionDis = new Disease(
    LR.streptococcalInfection,
    L.streptococcalInfectionDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.streptococcusInfection
);
streptococcalInfectionDis.setPrintName(L.streptococcalInfectionPrintName);
streptococcalInfectionDis.addReference("pp 166-71");
Treatment streptococcalInfectionTr1 = new Treatment("streptococcalInfectionTr1");
streptococcalInfectionTr1.addDrug(LR.penicillin);
streptococcalInfectionDis.addTreatment("streptococcalInfectionTr1");


// ------------- septicemia  -------------
Disease septicemiaDis = new Disease(
    LR.septicemia,
    L.septicemiaDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.immuneSysSt,
    LR.infection
);
septicemiaDis.setPrintName(L.septicemiaPrintName);
septicemiaDis.setTemperature(103.0f);
septicemiaDis.setCode358(23);
septicemiaDis.setICD10code("A40");
septicemiaDis.addInternalCause(LR.impetigo);
septicemiaDis.addCausingAbnormalCondition(LR.sepsis);
septicemiaDis.addCausingAbnormalCondition(LR.shock);
septicemiaDis.addSymptom(LR.agitation);
septicemiaDis.addSymptom(LR.anxiety);
septicemiaDis.addSymptom(LR.chills);
septicemiaDis.addSymptom(LR.coma);
septicemiaDis.addSymptom(LR.irritability);
septicemiaDis.addSymptom(LR.lethargy);
septicemiaDis.addSymptom(LR.cyanosis);
septicemiaDis.addSymptom(LR.ecchymoses);
septicemiaDis.addSymptom(LR.skinClammy);
septicemiaDis.addSymptom(LR.pallor);
septicemiaDis.addSymptom(LR.petechiae);
septicemiaDis.addSymptom(LR.urineRetention);
Treatment septicemiaTr1 = new Treatment("septicemiaTr1");
septicemiaTr1.addTreatmentAction(LR.IVFluids);
septicemiaTr1.addTreatmentAction(LR.hospitalization);
septicemiaTr1.addTreatmentAction(LR.oxygenTherapy);
septicemiaTr1.addDrug(LR.antibiotics);
septicemiaDis.addTreatment("septicemiaTr1");


// ------------- tetanus  -------------
Disease tetanusDis = new Disease(
    LR.tetanus,
    L.tetanusDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.tetanusInfection
);
tetanusDis.setPrintName(L.tetanusPrintName);
tetanusDis.setCode358(18);
tetanusDis.setICD10code("A33");
tetanusDis.addReference("pp 175-7");
tetanusDis.addSymptom(LR.abdomenRigidity);
tetanusDis.addSymptom(LR.apnea);
tetanusDis.addSymptom(LR.backArched);
tetanusDis.addSymptom(LR.diaphoresis);
tetanusDis.addSymptom(LR.tendonReflexesHyperactive);
tetanusDis.addSymptom(LR.lockjaw);
tetanusDis.addSymptom(LR.muscleContractions);
tetanusDis.addSymptom(LR.muscleHypertonicity);
tetanusDis.addSymptom(LR.seizure);
tetanusDis.addSymptom(LR.tachycardia);
Treatment tetanusTr1 = new Treatment("tetanusTr1");
tetanusTr1.addTreatmentAction(LR.airwayMaintenance);
tetanusTr1.addDrug(LR.antibiotics);
tetanusTr1.addDrug(LR.diazepam);
tetanusTr1.addDrug(LR.tetanusToxoid);
tetanusDis.addTreatment("tetanusTr1");


// ------------- toxoplasmosis  -------------
Disease toxoplasmosisDis = new Disease(
    LR.toxoplasmosis,
    L.toxoplasmosisDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.toxoplasmaGondiiInfection
);
toxoplasmosisDis.setPrintName(L.toxoplasmosisPrintName);
toxoplasmosisDis.setMiscComments(L.toxoplasmosisComment);
toxoplasmosisDis.addCausesDisease(LR.uveitis);
toxoplasmosisDis.addReference("pp 257-8");


// ------------- toxoplasmosisAcquiredSuper  -------------
Disease toxoplasmosisAcquiredSuperDis = new Disease(
    LR.toxoplasmosisAcquiredSuper,
    L.toxoplasmosisAcquiredSuperDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.toxoplasmaGondiiInfection
);
toxoplasmosisAcquiredSuperDis.setPrintName(L.toxoplasmosisAcquiredSuperPrintName);
toxoplasmosisAcquiredSuperDis.setSuperDisease(LR.toxoplasmosis);
toxoplasmosisAcquiredSuperDis.setMiscComments(L.toxoplasmosisAcquiredSuperComment);
toxoplasmosisAcquiredSuperDis.setTemperature(101.0f);
toxoplasmosisAcquiredSuperDis.addReference("pp 257-8");
toxoplasmosisAcquiredSuperDis.addSymptom(LR.fatigue);
toxoplasmosisAcquiredSuperDis.addSymptom(LR.headache);
toxoplasmosisAcquiredSuperDis.addSymptom(LR.lymphadenitis);
toxoplasmosisAcquiredSuperDis.addSymptom(LR.lymphadenopathy);
toxoplasmosisAcquiredSuperDis.addSymptom(LR.malaise);
toxoplasmosisAcquiredSuperDis.addSymptom(LR.myalgia);
toxoplasmosisAcquiredSuperDis.addSymptom(LR.throatSore);
Treatment toxoplasmosisAcquiredSuperTr1 = new Treatment("toxoplasmosisAcquiredSuperTr1");
toxoplasmosisAcquiredSuperTr1.addDrug(LR.sulfonamide);
toxoplasmosisAcquiredSuperTr1.addDrug(LR.pyrimetathamine);
toxoplasmosisAcquiredSuperDis.addTreatment("toxoplasmosisAcquiredSuperTr1");


// ------------- toxoplasmosisAcquired  -------------
Disease toxoplasmosisAcquiredDis = new Disease(
    LR.toxoplasmosisAcquired,
    L.toxoplasmosisAcquiredDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
toxoplasmosisAcquiredDis.setPrintName(L.toxoplasmosisAcquiredPrintName);
toxoplasmosisAcquiredDis.setSuperDisease(LR.toxoplasmosisAcquiredSuper);
toxoplasmosisAcquiredDis.setMiscComments(L.toxoplasmosisAcquiredComment);
toxoplasmosisAcquiredDis.setTemperature(101.0f);
toxoplasmosisAcquiredDis.addCausesDisease(LR.toxoplasmosisAcquiredAdvanced);
toxoplasmosisAcquiredDis.addReference("pp 257-8");


// ------------- toxoplasmosisAcquiredAdvanced  -------------
Disease toxoplasmosisAcquiredAdvancedDis = new Disease(
    LR.toxoplasmosisAcquiredAdvanced,
    L.toxoplasmosisAcquiredAdvancedDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.toxoplasmaGondiiInfection
);
toxoplasmosisAcquiredAdvancedDis.setPrintName(L.toxoplasmosisAcquiredAdvancedPrintName);
toxoplasmosisAcquiredAdvancedDis.setSuperDisease(LR.toxoplasmosisAcquiredSuper);
toxoplasmosisAcquiredAdvancedDis.setMiscComments(L.toxoplasmosisAcquiredAdvancedComment);
toxoplasmosisAcquiredAdvancedDis.setTemperature(101.0f);
toxoplasmosisAcquiredAdvancedDis.addInternalCause(LR.toxoplasmosisAcquired);
toxoplasmosisAcquiredAdvancedDis.addCausesDisease(LR.encephalitis);
toxoplasmosisAcquiredAdvancedDis.addCausesDisease(LR.hepatitis);
toxoplasmosisAcquiredAdvancedDis.addCausesDisease(LR.myocarditis);
toxoplasmosisAcquiredAdvancedDis.addCausesDisease(LR.polymyositis);
toxoplasmosisAcquiredAdvancedDis.addReference("pp 257-8");
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.fatigue);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.headache);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.lymphadenitis);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.lymphadenopathy);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.malaise);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.myalgia);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.throatSore);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.delirium);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.rash);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.seizure);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.vomiting);


// ------------- toxoplasmosisCongenital  -------------
Disease toxoplasmosisCongenitalDis = new Disease(
    LR.toxoplasmosisCongenital,
    L.toxoplasmosisCongenitalDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    2, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.toxoplasmaGondiiInfection
);
toxoplasmosisCongenitalDis.setPrintName(L.toxoplasmosisCongenitalPrintName);
toxoplasmosisCongenitalDis.setSuperDisease(LR.toxoplasmosis);
toxoplasmosisCongenitalDis.setMiscComments(L.toxoplasmosisCongenitalComment);
toxoplasmosisCongenitalDis.setTemperature(101.0f);
toxoplasmosisCongenitalDis.addCausesDisease(LR.retinochoroiditis);
toxoplasmosisCongenitalDis.addCausesDisease(LR.hydrocephalus);
toxoplasmosisCongenitalDis.addCausesAbnormalCondition(LR.hepatomegaly);
toxoplasmosisCongenitalDis.addCausesAbnormalCondition(LR.splenomegaly);
toxoplasmosisCongenitalDis.addReference("pp 257-8");
toxoplasmosisCongenitalDis.addSymptom(LR.jaundice);
toxoplasmosisCongenitalDis.addSymptom(LR.lymphadenopathy);
toxoplasmosisCongenitalDis.addSymptom(LR.rash);
toxoplasmosisCongenitalDis.addSymptom(LR.seizure);


// ------------- westNileVirus  -------------
Disease westNileVirusDis = new Disease(
    LR.westNileVirus,
    L.westNileVirusDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.virusInfection
);
westNileVirusDis.setPrintName(L.westNileVirusPrintName);
westNileVirusDis.setTemperature(101.0f);
westNileVirusDis.addSymptom(LR.headache);


// ------------- westNileVirusMild  -------------
Disease westNileVirusMildDis = new Disease(
    LR.westNileVirusMild,
    L.westNileVirusMildDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
westNileVirusMildDis.setPrintName(L.westNileVirusMildPrintName);
westNileVirusMildDis.setSuperDisease(LR.westNileVirus);
westNileVirusMildDis.setMiscComments(L.westNileVirusMildComment);
westNileVirusMildDis.setTemperature(101.0f);
westNileVirusMildDis.addCausesDisease(LR.westNileVirusSevere);
westNileVirusMildDis.addSymptom(LR.myalgia);
westNileVirusMildDis.addSymptom(LR.nausea);
westNileVirusMildDis.addSymptom(LR.rash, "", 0.2f);
westNileVirusMildDis.addSymptom(LR.vomiting);
westNileVirusMildDis.addSymptom(LR.lymphadenopathy, "", 0.2f);


// ------------- westNileVirusSevere  -------------
Disease westNileVirusSevereDis = new Disease(
    LR.westNileVirusSevere,
    L.westNileVirusSevereDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
westNileVirusSevereDis.setPrintName(L.westNileVirusSeverePrintName);
westNileVirusSevereDis.setSuperDisease(LR.westNileVirus);
westNileVirusSevereDis.setMiscComments(L.westNileVirusSevereComment);
westNileVirusSevereDis.setTemperature(103.0f);
westNileVirusSevereDis.addInternalCause(LR.westNileVirusMild);
westNileVirusSevereDis.addSymptom(LR.coma);
westNileVirusSevereDis.addSymptom(LR.convulsions);
westNileVirusSevereDis.addSymptom(LR.disorientation);
westNileVirusSevereDis.addSymptom(LR.neckStiff);
westNileVirusSevereDis.addSymptom(LR.stupor);
westNileVirusSevereDis.addSymptom(LR.tremors);
westNileVirusSevereDis.addSymptom(LR.muscleWeakness);
westNileVirusSevereDis.addSymptom(LR.numbness);
westNileVirusSevereDis.addSymptom(LR.paralysis);
westNileVirusSevereDis.addSymptom(LR.visionLoss);


// ------------- whoopingCough  -------------
Disease whoopingCoughDis = new Disease(
    LR.whoopingCough,
    L.whoopingCoughDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -5, // duration
    F.whoopingCoughFreq, // diagnosis frequency, -1 = unknown
    LR.respiratorySysSt,
    LR.none
);
whoopingCoughDis.setPrintName(L.whoopingCoughPrintName);
whoopingCoughDis.setCode358(20);
whoopingCoughDis.setICD10code("A37");
whoopingCoughDis.addReference("pp 194-5");
Treatment whoopingCoughTr1 = new Treatment("whoopingCoughTr1");
whoopingCoughTr1.addDrug(LR.antibiotics);
whoopingCoughTr1.addDrug(LR.codeine);
whoopingCoughDis.addTreatment("whoopingCoughTr1");


// ------------- whoopingCoughCatarrh  -------------
Disease whoopingCoughCatarrhDis = new Disease(
    LR.whoopingCoughCatarrh,
    L.whoopingCoughCatarrhDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    F.whoopingCoughCatarrhFreq, // diagnosis frequency, -1 = unknown
    LR.respiratorySysSt,
    LR.none
);
whoopingCoughCatarrhDis.setPrintName(L.whoopingCoughCatarrhPrintName);
whoopingCoughCatarrhDis.setSuperDisease(LR.whoopingCough);
whoopingCoughCatarrhDis.setMiscComments(L.whoopingCoughCatarrhComment);
whoopingCoughCatarrhDis.setTemperature(101.0f);
whoopingCoughCatarrhDis.setCode358(20);
whoopingCoughCatarrhDis.setICD10code("A37");
whoopingCoughCatarrhDis.addCausesDisease(LR.conjunctivitis);
whoopingCoughCatarrhDis.addReference("pp 194-5");
whoopingCoughCatarrhDis.addSymptom(LR.anorexia);
whoopingCoughCatarrhDis.addSymptom(LR.coughHacking);
whoopingCoughCatarrhDis.addSymptom(LR.listlessness);
whoopingCoughCatarrhDis.addSymptom(LR.sneezing);


// ------------- whoopingCoughParoxysm  -------------
Disease whoopingCoughParoxysmDis = new Disease(
    LR.whoopingCoughParoxysm,
    L.whoopingCoughParoxysmDescription,
    LR.infections,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    F.whoopingCoughParoxysmFreq, // diagnosis frequency, -1 = unknown
    LR.respiratorySysSt,
    LR.none
);
whoopingCoughParoxysmDis.setPrintName(L.whoopingCoughParoxysmPrintName);
whoopingCoughParoxysmDis.setSuperDisease(LR.whoopingCough);
whoopingCoughParoxysmDis.setCode358(20);
whoopingCoughParoxysmDis.setICD10code("A37");
whoopingCoughParoxysmDis.addReference("pp 194-5");
whoopingCoughParoxysmDis.addSymptom(LR.cough);
whoopingCoughParoxysmDis.addSymptom(LR.coughProductive);
whoopingCoughParoxysmDis.addSymptom(LR.thickMucus);
whoopingCoughParoxysmDis.addSymptom(LR.vomiting);
whoopingCoughParoxysmDis.addSymptom(LR.whoopInhalation);
} // end of infections





// ------------- metabolicDisorders  -------------
static public void metabolicDisorders() { 


// ------------- diabetesKetoacidosis  -------------
Disease diabetesKetoacidosisDis = new Disease(
    LR.diabetesKetoacidosis,
    L.diabetesKetoacidosisDescription,
    LR.metabolicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.metabolicSysSt,
    LR.none
);
diabetesKetoacidosisDis.setPrintName(L.diabetesKetoacidosisPrintName);
diabetesKetoacidosisDis.addInternalCause(LR.diabetesInsidipus);
diabetesKetoacidosisDis.addReference("pp 0; pp 906-8");
diabetesKetoacidosisDis.addSymptom(LR.breathAcetone);
diabetesKetoacidosisDis.addSymptom(LR.consciousnessDecreased);
diabetesKetoacidosisDis.addSymptom(LR.dehydration);
diabetesKetoacidosisDis.addSymptom(LR.mucousMembranesDry);
diabetesKetoacidosisDis.addSymptom(LR.nausea);
diabetesKetoacidosisDis.addSymptom(LR.pulseThready);
diabetesKetoacidosisDis.addSymptom(LR.pulseWeak);
diabetesKetoacidosisDis.addSymptom(LR.respirationKussmaul);
diabetesKetoacidosisDis.addSymptom(LR.vomiting);
Treatment diabetesKetoacidosisTr1 = new Treatment("diabetesKetoacidosisTr1");
diabetesKetoacidosisTr1.addTreatmentAction(LR.IVFluids);
diabetesKetoacidosisTr1.addDrug(LR.insulin);
diabetesKetoacidosisTr1.addDrug(LR.sodiumBicarbonate);
diabetesKetoacidosisDis.addTreatment("diabetesKetoacidosisTr1");


// ------------- metabolicAcidosis  -------------
Disease metabolicAcidosisDis = new Disease(
    LR.metabolicAcidosis,
    L.metabolicAcidosisDescription,
    LR.metabolicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.metabolicSysSt,
    LR.none
);
metabolicAcidosisDis.setPrintName(L.metabolicAcidosisPrintName);
metabolicAcidosisDis.addInternalCause(LR.necrotizingEnterocolitis);
metabolicAcidosisDis.addCausesAbnormalCondition(LR.centralNervousSystemDepression);
metabolicAcidosisDis.addReference("pp 906-8");
metabolicAcidosisDis.addSymptom(LR.drowsiness);
metabolicAcidosisDis.addSymptom(LR.headache);
metabolicAcidosisDis.addSymptom(LR.lethargy);
metabolicAcidosisDis.addSymptom(LR.stupor);
Treatment metabolicAcidosisTr1 = new Treatment("metabolicAcidosisTr1");
metabolicAcidosisTr1.addDrug(LR.sodiumBicarbonate);
metabolicAcidosisDis.addTreatment("metabolicAcidosisTr1");


// ------------- metabolicAlkalosis  -------------
Disease metabolicAlkalosisDis = new Disease(
    LR.metabolicAlkalosis,
    L.metabolicAlkalosisDescription,
    LR.metabolicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.metabolicSysSt,
    LR.none
);
metabolicAlkalosisDis.setPrintName(L.metabolicAlkalosisPrintName);
metabolicAlkalosisDis.addInternalCause(LR.hypokalemiaSuper);
metabolicAlkalosisDis.addReference("pp 908-9");
metabolicAlkalosisDis.addSymptom(LR.confusion);
metabolicAlkalosisDis.addSymptom(LR.diarrhea);
metabolicAlkalosisDis.addSymptom(LR.hypoventilation);
metabolicAlkalosisDis.addSymptom(LR.irritability);
metabolicAlkalosisDis.addSymptom(LR.nausea);
metabolicAlkalosisDis.addSymptom(LR.twitching);
metabolicAlkalosisDis.addSymptom(LR.vomiting);
Treatment metabolicAlkalosisTr1 = new Treatment("metabolicAlkalosisTr1");
metabolicAlkalosisTr1.addDrug(LR.ammoniumChloride);
metabolicAlkalosisDis.addTreatment("metabolicAlkalosisTr1");


// ------------- potassiumImbalance  -------------
Disease potassiumImbalanceDis = new Disease(
    LR.potassiumImbalance,
    L.potassiumImbalanceDescription,
    LR.metabolicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.muscleSysSt,
    LR.none
);
potassiumImbalanceDis.setPrintName(L.potassiumImbalancePrintName);
potassiumImbalanceDis.addReference("pp 892-894");
potassiumImbalanceDis.addSymptom(LR.muscleWeakness);


// ------------- hyponatremia  -------------
Disease hyponatremiaDis = new Disease(
    LR.hyponatremia,
    L.hyponatremiaDescription,
    LR.metabolicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
hyponatremiaDis.setPrintName(L.hyponatremiaPrintName);
hyponatremiaDis.addInternalCause(LR.cysticFibrosis);
hyponatremiaDis.addReference("pp 895-7");
hyponatremiaDis.addSymptom(LR.abdomenCramping);
hyponatremiaDis.addSymptom(LR.apathy);
hyponatremiaDis.addSymptom(LR.headache);
hyponatremiaDis.addSymptom(LR.hypotension);
hyponatremiaDis.addSymptom(LR.muscleWeakness);
hyponatremiaDis.addSymptom(LR.nausea);
hyponatremiaDis.addSymptom(LR.seizure);
hyponatremiaDis.addSymptom(LR.tachycardia);
hyponatremiaDis.addSymptom(LR.twitching);
hyponatremiaDis.addSymptom(LR.vomiting);
hyponatremiaDis.addSymptom(LR.skinClammy);
hyponatremiaDis.addSymptom(LR.skinCold);
hyponatremiaDis.addSymptom(LR.skinElasticityLoss);
Treatment hyponatremiaTr1 = new Treatment("hyponatremiaTr1");
hyponatremiaTr1.addTreatmentAction(LR.fluidRestriction);
hyponatremiaDis.addTreatment("hyponatremiaTr1");


// ------------- hyperkalemia  -------------
Disease hyperkalemiaDis = new Disease(
    LR.hyperkalemia,
    L.hyperkalemiaDescription,
    LR.metabolicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.muscleSysSt,
    LR.none
);
hyperkalemiaDis.setPrintName(L.hyperkalemiaPrintName);
hyperkalemiaDis.setSuperDisease(LR.potassiumImbalance);
hyperkalemiaDis.addInternalCause(LR.tubularNecrosisAcute);
hyperkalemiaDis.addCausesAbnormalCondition(LR.acidosis);
hyperkalemiaDis.addReference("pp 892-4");
hyperkalemiaDis.addSymptom(LR.abdomenCramping);
hyperkalemiaDis.addSymptom(LR.anuria);
hyperkalemiaDis.addSymptom(LR.bradycardia, L.hyperkalemia_bradycardia, 0.1f);
hyperkalemiaDis.addSymptom(LR.diarrhea);
hyperkalemiaDis.addSymptom(LR.nausea);
hyperkalemiaDis.addSymptom(LR.numbness);
hyperkalemiaDis.addSymptom(LR.oliguria);
hyperkalemiaDis.addSymptom(LR.paralysisTransient);
hyperkalemiaDis.addSymptom(LR.tachycardia);
hyperkalemiaDis.addSymptom(LR.tingling);
Treatment hyperkalemiaTr1 = new Treatment("hyperkalemiaTr1");
hyperkalemiaTr1.addDrug(LR.calciumGluconate);
hyperkalemiaDis.addTreatment("hyperkalemiaTr1");


// ------------- hypokalemiaSuper  -------------
Disease hypokalemiaSuperDis = new Disease(
    LR.hypokalemiaSuper,
    L.hypokalemiaSuperDescription,
    LR.metabolicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.metabolicSysSt,
    LR.none
);
hypokalemiaSuperDis.setPrintName(L.hypokalemiaSuperPrintName);
hypokalemiaSuperDis.setSuperDisease(LR.potassiumImbalance);
hypokalemiaSuperDis.addCausesDisease(LR.cardiacArrest);
hypokalemiaSuperDis.addCausesDisease(LR.metabolicAlkalosis);
hypokalemiaSuperDis.addReference("pp 893");
hypokalemiaSuperDis.addSymptom(LR.abdomenDistension);
hypokalemiaSuperDis.addSymptom(LR.anorexia);
hypokalemiaSuperDis.addSymptom(LR.confusion);
hypokalemiaSuperDis.addSymptom(LR.diarrhea);
hypokalemiaSuperDis.addSymptom(LR.dizziness);
hypokalemiaSuperDis.addSymptom(LR.fatigue);
hypokalemiaSuperDis.addSymptom(LR.hypotension);
hypokalemiaSuperDis.addSymptom(LR.legCramps);
hypokalemiaSuperDis.addSymptom(LR.mentalDepression);
hypokalemiaSuperDis.addSymptom(LR.nausea);
hypokalemiaSuperDis.addSymptom(LR.reflexesDecreased);
hypokalemiaSuperDis.addSymptom(LR.polyuria);
hypokalemiaSuperDis.addSymptom(LR.respirationParalysis);
hypokalemiaSuperDis.addSymptom(LR.vomiting);
Treatment hypokalemiaSuperTr1 = new Treatment("hypokalemiaSuperTr1");
hypokalemiaSuperTr1.addTreatmentAction(LR.potassiumReplacement);
hypokalemiaSuperDis.addTreatment("hypokalemiaSuperTr1");


// ------------- hypokalemia  -------------
Disease hypokalemiaDis = new Disease(
    LR.hypokalemia,
    L.hypokalemiaDescription,
    LR.metabolicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.metabolicSysSt,
    LR.none
);
hypokalemiaDis.setPrintName(L.hypokalemiaPrintName);
hypokalemiaDis.setSuperDisease(LR.hypokalemiaSuper);
hypokalemiaDis.addCausesDisease(LR.hypokalemiaSevere);
hypokalemiaDis.addReference("pp 893");


// ------------- hypokalemiaSevere  -------------
Disease hypokalemiaSevereDis = new Disease(
    LR.hypokalemiaSevere,
    L.hypokalemiaSevereDescription,
    LR.metabolicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.metabolicSysSt,
    LR.none
);
hypokalemiaSevereDis.setPrintName(L.hypokalemiaSeverePrintName);
hypokalemiaSevereDis.setSuperDisease(LR.hypokalemiaSuper);
hypokalemiaSevereDis.addInternalCause(LR.hypokalemia);
hypokalemiaSevereDis.addReference("pp 893");
Treatment hypokalemiaSevereTr1 = new Treatment("hypokalemiaSevereTr1");
hypokalemiaSevereTr1.addTreatmentAction(LR.CPR);
hypokalemiaSevereTr1.addTreatmentAction(LR.mechanicalVentilation);
hypokalemiaSevereDis.addTreatment("hypokalemiaSevereTr1");


// ------------- hypochloremia  -------------
Disease hypochloremiaDis = new Disease(
    LR.hypochloremia,
    L.hypochloremiaDescription,
    LR.metabolicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
hypochloremiaDis.setPrintName(L.hypochloremiaPrintName);
hypochloremiaDis.addInternalCause(LR.cysticFibrosis);
hypochloremiaDis.addReference("pp 900-2");
hypochloremiaDis.addSymptom(LR.headache);
hypochloremiaDis.addSymptom(LR.nausea);
hypochloremiaDis.addSymptom(LR.weakness);
Treatment hypochloremiaTr1 = new Treatment("hypochloremiaTr1");
hypochloremiaTr1.addTreatmentAction(LR.saltyBroth);
hypochloremiaDis.addTreatment("hypochloremiaTr1");


// ------------- hypochloremia1  -------------
Disease hypochloremia1Dis = new Disease(
    LR.hypochloremia1,
    L.hypochloremia1Description,
    LR.metabolicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
hypochloremia1Dis.setPrintName(L.hypochloremia1PrintName);
hypochloremia1Dis.setSuperDisease(LR.hypochloremia);
hypochloremia1Dis.addInternalCause(LR.hyponatremia);
hypochloremia1Dis.addReference("pp 900-2");
hypochloremia1Dis.addSymptom(LR.muscleWeakness);
hypochloremia1Dis.addSymptom(LR.twitching);


// ------------- hypochloremia2  -------------
Disease hypochloremia2Dis = new Disease(
    LR.hypochloremia2,
    L.hypochloremia2Description,
    LR.metabolicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
hypochloremia2Dis.setPrintName(L.hypochloremia2PrintName);
hypochloremia2Dis.setSuperDisease(LR.hypochloremia);
hypochloremia2Dis.addInternalCause(LR.metabolicAlkalosis);
hypochloremia2Dis.addReference("pp 900-2");
hypochloremia2Dis.addSymptom(LR.muscleHypertonicity);
hypochloremia2Dis.addSymptom(LR.tetany);
hypochloremia2Dis.addSymptom(LR.respirationShallow);


// ------------- syndromeOfInappropriateAntidiureticHormoneSecretion  -------------
Disease syndromeOfInappropriateAntidiureticHormoneSecretionDis = new Disease(
    LR.syndromeOfInappropriateAntidiureticHormoneSecretion,
    L.syndromeOfInappropriateAntidiureticHormoneSecretionDescription,
    LR.metabolicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.metabolicSysSt,
    LR.none
);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.setPrintName(L.syndromeOfInappropriateAntidiureticHormoneSecretionPrintName);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addReference("pp 905-6");
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addSymptom(LR.anorexia);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addSymptom(LR.coma);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addSymptom(LR.nausea);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addSymptom(LR.restlessness);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addSymptom(LR.seizure);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addSymptom(LR.vomiting);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addSymptom(LR.weakness);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addSymptom(LR.weightGain);
Treatment syndromeOfInappropriateAntidiureticHormoneSecretionTr1 = new Treatment("syndromeOfInappropriateAntidiureticHormoneSecretionTr1");
syndromeOfInappropriateAntidiureticHormoneSecretionTr1.addTreatmentAction(LR.fluidRestriction);
syndromeOfInappropriateAntidiureticHormoneSecretionTr1.addDrug(LR.lithium);
syndromeOfInappropriateAntidiureticHormoneSecretionTr1.addDrug(LR.demeclocycline);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addTreatment("syndromeOfInappropriateAntidiureticHormoneSecretionTr1");


// ------------- vitaminCDeficiency  -------------
Disease vitaminCDeficiencyDis = new Disease(
    LR.vitaminCDeficiency,
    L.vitaminCDeficiencyDescription,
    LR.metabolicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
vitaminCDeficiencyDis.setPrintName(L.vitaminCDeficiencyPrintName);
vitaminCDeficiencyDis.addCausesDisease(LR.anemia);
vitaminCDeficiencyDis.addReference("pp 866-8");
vitaminCDeficiencyDis.addSymptom(LR.anorexia);
vitaminCDeficiencyDis.addSymptom(LR.ecchymoses);
vitaminCDeficiencyDis.addSymptom(LR.gumsSwollen);
vitaminCDeficiencyDis.addSymptom(LR.jointPain);
vitaminCDeficiencyDis.addSymptom(LR.pallor);
vitaminCDeficiencyDis.addSymptom(LR.petechiae);
vitaminCDeficiencyDis.addSymptom(LR.weakness);
vitaminCDeficiencyDis.addSymptom(LR.lethargy);
vitaminCDeficiencyDis.addSymptom(LR.sleepDisturbed);
vitaminCDeficiencyDis.addSymptom(LR.teethLoose);
Treatment vitaminCDeficiencyTr1 = new Treatment("vitaminCDeficiencyTr1");
vitaminCDeficiencyTr1.addDrug(LR.vitaminC);
vitaminCDeficiencyDis.addTreatment("vitaminCDeficiencyTr1");


// ------------- vitaminDDeficiency  -------------
Disease vitaminDDeficiencyDis = new Disease(
    LR.vitaminDDeficiency,
    L.vitaminDDeficiencyDescription,
    LR.metabolicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
vitaminDDeficiencyDis.setPrintName(L.vitaminDDeficiencyPrintName);
vitaminDDeficiencyDis.addInternalCause(LR.celiacDisease);
vitaminDDeficiencyDis.addReference("pp 868-9");
vitaminDDeficiencyDis.addSymptom(LR.irritability);
vitaminDDeficiencyDis.addSymptom(LR.restlessness);
vitaminDDeficiencyDis.addSymptom(LR.sweating);
Treatment vitaminDDeficiencyTr1 = new Treatment("vitaminDDeficiencyTr1");
vitaminDDeficiencyTr1.addDrug(LR.vitaminD);
vitaminDDeficiencyDis.addTreatment("vitaminDDeficiencyTr1");


// ------------- vitaminKDeficiency  -------------
Disease vitaminKDeficiencyDis = new Disease(
    LR.vitaminKDeficiency,
    L.vitaminKDeficiencyDescription,
    LR.metabolicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
vitaminKDeficiencyDis.setPrintName(L.vitaminKDeficiencyPrintName);
vitaminKDeficiencyDis.addReference("pp 870-1");
vitaminKDeficiencyDis.addSymptom(LR.bleedingAbnormal);
vitaminKDeficiencyDis.addSymptom(LR.bleedingFromNose);
vitaminKDeficiencyDis.addSymptom(LR.bruising);
vitaminKDeficiencyDis.addSymptom(LR.gumsBleeding);
Treatment vitaminKDeficiencyTr1 = new Treatment("vitaminKDeficiencyTr1");
vitaminKDeficiencyTr1.addDrug(LR.vitaminK);
vitaminKDeficiencyDis.addTreatment("vitaminKDeficiencyTr1");
} // end of metabolicDisorders





// ------------- musculoDisorders  -------------
static public void musculoDisorders() { 


// ------------- carpalTunnelSyndrome  -------------
Disease carpalTunnelSyndromeDis = new Disease(
    LR.carpalTunnelSyndrome,
    L.carpalTunnelSyndromeDescription,
    LR.musculoDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    60, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.wristsSysSt,
    LR.none
);
carpalTunnelSyndromeDis.setPrintName(L.carpalTunnelSyndromePrintName);
carpalTunnelSyndromeDis.addReference("pp 594-6");
carpalTunnelSyndromeDis.addSymptom(LR.handBurning);
carpalTunnelSyndromeDis.addSymptom(LR.handNumbness);
carpalTunnelSyndromeDis.addSymptom(LR.handPain);
carpalTunnelSyndromeDis.addSymptom(LR.handTingling);
carpalTunnelSyndromeDis.addSymptom(LR.handWeak);
Treatment carpalTunnelSyndromeTr1 = new Treatment("carpalTunnelSyndromeTr1");
carpalTunnelSyndromeTr1.addTreatmentAction(LR.wristSplint);
carpalTunnelSyndromeDis.addTreatment("carpalTunnelSyndromeTr1");
Treatment carpalTunnelSyndromeTr2 = new Treatment("carpalTunnelSyndromeTr2");
carpalTunnelSyndromeTr2.addTreatmentAction(LR.surgery);
carpalTunnelSyndromeDis.addTreatment("carpalTunnelSyndromeTr2");


// ------------- gout  -------------
Disease goutDis = new Disease(
    LR.gout,
    L.goutDescription,
    LR.musculoDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.jointsSysSt,
    LR.none
);
goutDis.setPrintName(L.goutPrintName);
goutDis.setSuperDisease(LR.arthritis);
goutDis.setMiscComments(L.goutComment);
goutDis.addCausesDisease(LR.hypertension);
goutDis.addCausesDisease(LR.renalCalculi);
goutDis.addReference("pp 567-70");
goutDis.addSymptom(LR.backPain, "", 0.2f);
goutDis.addSymptom(LR.jointRedness);
goutDis.addSymptom(LR.jointHot);
goutDis.addSymptom(LR.jointTender);
Treatment goutTr1 = new Treatment("goutTr1");
goutTr1.addTreatmentAction(LR.bedRest);
goutTr1.addDrug(LR.analgetics);
goutDis.addTreatment("goutTr1");


// ------------- herniatedDisk  -------------
Disease herniatedDiskDis = new Disease(
    LR.herniatedDisk,
    L.herniatedDiskDescription,
    LR.musculoDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.musculoSkeletalSysSt,
    LR.trauma
);
herniatedDiskDis.setPrintName(L.herniatedDiskPrintName);
herniatedDiskDis.addCausingAbnormalCondition(LR.spineJointDegeneration);
herniatedDiskDis.addReference("pp 585-7");
herniatedDiskDis.addSymptom(LR.buttockPain);
herniatedDiskDis.addSymptom(LR.feetPain);
herniatedDiskDis.addSymptom(LR.legPain);
herniatedDiskDis.addSymptom(LR.hipPain);
herniatedDiskDis.addSymptom(LR.lowBackPain);
herniatedDiskDis.addSymptom(LR.spasm, "", 0.3f);
Treatment herniatedDiskTr1 = new Treatment("herniatedDiskTr1");
herniatedDiskTr1.addTreatmentAction(LR.exercise);
herniatedDiskTr1.addDrug(LR.aspirin);
herniatedDiskTr1.addDrug(LR.diazepam);
herniatedDiskTr1.addDrug(LR.methocarbamol);
herniatedDiskDis.addTreatment("herniatedDiskTr1");
Treatment herniatedDiskTr2 = new Treatment("herniatedDiskTr2", LR.ifSevere);
herniatedDiskTr2.addTreatmentAction(LR.surgery);
herniatedDiskDis.addTreatment("herniatedDiskTr2");


// ------------- muscularDystrophy  -------------
Disease muscularDystrophyDis = new Disease(
    LR.muscularDystrophy,
    L.muscularDystrophyDescription,
    LR.musculoDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.muscleSysSt,
    LR.none
);
muscularDystrophyDis.setPrintName(L.muscularDystrophyPrintName);
muscularDystrophyDis.setMiscComments(L.muscularDystrophyComment);
muscularDystrophyDis.addReference("pp 563-5");


// ------------- muscularDystrophyDuchenne  -------------
Disease muscularDystrophyDuchenneDis = new Disease(
    LR.muscularDystrophyDuchenne,
    L.muscularDystrophyDuchenneDescription,
    LR.musculoDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    3, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.muscleSysSt,
    LR.none
);
muscularDystrophyDuchenneDis.setPrintName(L.muscularDystrophyDuchennePrintName);
muscularDystrophyDuchenneDis.setSuperDisease(LR.muscularDystrophy);
muscularDystrophyDuchenneDis.setMiscComments(L.muscularDystrophyDuchenneComment);
muscularDystrophyDuchenneDis.setGenetic("1parent");
muscularDystrophyDuchenneDis.setParentDisease(LR.muscularDystrophyDuchenne);
muscularDystrophyDuchenneDis.addCausesDisease(LR.heartFailure);
muscularDystrophyDuchenneDis.addCausesDisease(LR.respiratoryFailureAcute);
muscularDystrophyDuchenneDis.addReference("pp 563-5");
muscularDystrophyDuchenneDis.addSymptom(LR.fatigue);
muscularDystrophyDuchenneDis.addSymptom(LR.muscleContractions);
muscularDystrophyDuchenneDis.addSymptom(LR.muscleWeakness);
muscularDystrophyDuchenneDis.addSymptom(LR.walkingTrouble);
muscularDystrophyDuchenneDis.addSymptom(LR.waddle);
muscularDystrophyDuchenneDis.addSymptom(LR.lordosis);


// ------------- muscularDystrophyBecker  -------------
Disease muscularDystrophyBeckerDis = new Disease(
    LR.muscularDystrophyBecker,
    L.muscularDystrophyBeckerDescription,
    LR.musculoDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.muscleSysSt,
    LR.none
);
muscularDystrophyBeckerDis.setPrintName(L.muscularDystrophyBeckerPrintName);
muscularDystrophyBeckerDis.setSuperDisease(LR.muscularDystrophy);
muscularDystrophyBeckerDis.setMiscComments(L.muscularDystrophyBeckerComment);
muscularDystrophyBeckerDis.setGenetic("1parent");
muscularDystrophyBeckerDis.setParentDisease(LR.muscularDystrophyBecker);
muscularDystrophyBeckerDis.addCausesDisease(LR.heartFailure);
muscularDystrophyBeckerDis.addCausesDisease(LR.respiratoryFailureAcute);
muscularDystrophyBeckerDis.addReference("pp 563-5");
muscularDystrophyBeckerDis.addSymptom(LR.fatigue);
muscularDystrophyBeckerDis.addSymptom(LR.lossOfBalance);
muscularDystrophyBeckerDis.addSymptom(LR.muscleContractions);
muscularDystrophyBeckerDis.addSymptom(LR.muscleWeakness);
muscularDystrophyBeckerDis.addSymptom(LR.walkingTrouble);
muscularDystrophyBeckerDis.addSymptom(LR.waddle);


// ------------- muscularDystrophyFacioscapulahumeral  -------------
Disease muscularDystrophyFacioscapulahumeralDis = new Disease(
    LR.muscularDystrophyFacioscapulahumeral,
    L.muscularDystrophyFacioscapulahumeralDescription,
    LR.musculoDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    8, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.muscleSysSt,
    LR.none
);
muscularDystrophyFacioscapulahumeralDis.setPrintName(L.muscularDystrophyFacioscapulahumeralPrintName);
muscularDystrophyFacioscapulahumeralDis.setSuperDisease(LR.muscularDystrophy);
muscularDystrophyFacioscapulahumeralDis.setGenetic("1parent");
muscularDystrophyFacioscapulahumeralDis.setParentDisease(LR.muscularDystrophyFacioscapulahumeral);
muscularDystrophyFacioscapulahumeralDis.addReference("pp 563-5");
muscularDystrophyFacioscapulahumeralDis.addSymptom(LR.muscleWeakness);
muscularDystrophyFacioscapulahumeralDis.addSymptom(LR.lipLowerHanging);
muscularDystrophyFacioscapulahumeralDis.addSymptom(LR.faceMovementsAbnormal);
muscularDystrophyFacioscapulahumeralDis.addSymptom(LR.nasolabialFoldAbsent);
muscularDystrophyFacioscapulahumeralDis.addSymptom(LR.armWeakness);


// ------------- muscularDystrophyLimbGirdle  -------------
Disease muscularDystrophyLimbGirdleDis = new Disease(
    LR.muscularDystrophyLimbGirdle,
    L.muscularDystrophyLimbGirdleDescription,
    LR.musculoDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    6, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.muscleSysSt,
    LR.none
);
muscularDystrophyLimbGirdleDis.setPrintName(L.muscularDystrophyLimbGirdlePrintName);
muscularDystrophyLimbGirdleDis.setSuperDisease(LR.muscularDystrophy);
muscularDystrophyLimbGirdleDis.setGenetic("1parent");
muscularDystrophyLimbGirdleDis.setParentDisease(LR.muscularDystrophyLimbGirdle);
muscularDystrophyLimbGirdleDis.addReference("pp 563-5");
muscularDystrophyLimbGirdleDis.addSymptom(LR.muscleWeakness);
muscularDystrophyLimbGirdleDis.addSymptom(LR.lordosis);
muscularDystrophyLimbGirdleDis.addSymptom(LR.lossOfBalance);
muscularDystrophyLimbGirdleDis.addSymptom(LR.waddle);
muscularDystrophyLimbGirdleDis.addSymptom(LR.armWeakness);


// ------------- osteoarthritis  -------------
Disease osteoarthritisDis = new Disease(
    LR.osteoarthritis,
    L.osteoarthritisDescription,
    LR.musculoDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.musculoSkeletalSysSt,
    LR.none
);
osteoarthritisDis.setPrintName(L.osteoarthritisPrintName);
osteoarthritisDis.setSuperDisease(LR.arthritis);
osteoarthritisDis.addReference("pp 571-4");
osteoarthritisDis.addSymptom(LR.stiffness);
Treatment osteoarthritisTr1 = new Treatment("osteoarthritisTr1");
osteoarthritisTr1.addTreatmentAction(LR.massage);
osteoarthritisTr1.addDrug(LR.acetaminophen);
osteoarthritisDis.addTreatment("osteoarthritisTr1");
Treatment osteoarthritisTr2 = new Treatment("osteoarthritisTr2", LR.ifSevere);
osteoarthritisTr2.addTreatmentAction(LR.surgery);
osteoarthritisDis.addTreatment("osteoarthritisTr2");
} // end of musculoDisorders





// ------------- neoPlasms  -------------
static public void neoPlasms() { 


// ------------- cancer  -------------
Disease cancerDis = new Disease(
    LR.cancer,
    L.cancerDescription,
    LR.neoPlasms,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.radiation
);
cancerDis.setPrintName(L.cancerPrintName);
cancerDis.setMiscComments(L.cancerComment);
cancerDis.addExternalCause(LR.tobaccoUse);
cancerDis.addExternalCause(LR.asbestosExposure);
cancerDis.addExternalCause(LR.industrialPollutantsExposure);
cancerDis.addExternalCause(LR.vinylChlorideExposure);
cancerDis.addExternalCause(LR.aromaticHydrocarbonsExposure);
cancerDis.addExternalCause(LR.benzopyreneExposure);
cancerDis.addReference("pp 45-55");


// ------------- basalCellCarcinoma  -------------
Disease basalCellCarcinomaDis = new Disease(
    LR.basalCellCarcinoma,
    L.basalCellCarcinomaDescription,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.sunLight
);
basalCellCarcinomaDis.setPrintName(L.basalCellCarcinomaPrintName);
basalCellCarcinomaDis.setSuperDisease(LR.cancer);
basalCellCarcinomaDis.setMiscComments(L.basalCellCarcinomaComment);
basalCellCarcinomaDis.addReference("pp 124-5");
Treatment squamousCellCarcinomaTr1 = new Treatment("squamousCellCarcinomaTr1");
squamousCellCarcinomaTr1.addTreatmentAction(LR.chemoTherapy);
squamousCellCarcinomaTr1.addTreatmentAction(LR.curettage);
squamousCellCarcinomaTr1.addTreatmentAction(LR.radiationTherapy);
squamousCellCarcinomaTr1.addTreatmentAction(LR.surgery);
basalCellCarcinomaDis.addTreatment("squamousCellCarcinomaTr1");


// ------------- basalCellCarcinomaNodulo  -------------
Disease basalCellCarcinomaNoduloDis = new Disease(
    LR.basalCellCarcinomaNodulo,
    L.basalCellCarcinomaNoduloDescription,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.faceSysSt,
    LR.none
);
basalCellCarcinomaNoduloDis.setPrintName(L.basalCellCarcinomaNoduloPrintName);
basalCellCarcinomaNoduloDis.setSuperDisease(LR.basalCellCarcinoma);
basalCellCarcinomaNoduloDis.setMiscComments(L.basalCellCarcinomaNoduloComment);
basalCellCarcinomaNoduloDis.addReference("pp 124-5");
basalCellCarcinomaNoduloDis.addSymptom(LR.faceLesionPinkPapules, L.basalCellCarcinomaNodulo_faceLesionPinkPapules, 1.0f);
basalCellCarcinomaNoduloDis.addSymptom(LR.faceLesionTranslucentPapules, L.basalCellCarcinomaNodulo_faceLesionTranslucentPapules, 1.0f);


// ------------- basalCellCarcinomaSclerotic  -------------
Disease basalCellCarcinomaScleroticDis = new Disease(
    LR.basalCellCarcinomaSclerotic,
    L.basalCellCarcinomaScleroticDescription,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
basalCellCarcinomaScleroticDis.setPrintName(L.basalCellCarcinomaScleroticPrintName);
basalCellCarcinomaScleroticDis.setSuperDisease(LR.basalCellCarcinoma);
basalCellCarcinomaScleroticDis.setMiscComments(L.basalCellCarcinomaScleroticComment);
basalCellCarcinomaScleroticDis.addReference("pp 124-5");
basalCellCarcinomaScleroticDis.addSymptom(LR.skinLesionPlaqueLike);
basalCellCarcinomaScleroticDis.addSymptom(LR.skinLesionFuzzyBorder);
basalCellCarcinomaScleroticDis.addSymptom(LR.skinLesionYellowish);


// ------------- basalCellCarcinomaSuperficial  -------------
Disease basalCellCarcinomaSuperficialDis = new Disease(
    LR.basalCellCarcinomaSuperficial,
    L.basalCellCarcinomaSuperficialDescription,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
basalCellCarcinomaSuperficialDis.setPrintName(L.basalCellCarcinomaSuperficialPrintName);
basalCellCarcinomaSuperficialDis.setSuperDisease(LR.basalCellCarcinoma);
basalCellCarcinomaSuperficialDis.setMiscComments(L.basalCellCarcinomaSuperficialComment);
basalCellCarcinomaSuperficialDis.addReference("pp 124-5");
basalCellCarcinomaSuperficialDis.addSymptom(LR.skinLesionPlaqueLike);
basalCellCarcinomaSuperficialDis.addSymptom(LR.skinLesionDryScaly);
basalCellCarcinomaSuperficialDis.addSymptom(LR.skinLesionLightlyPigmented);
basalCellCarcinomaSuperficialDis.addSymptom(LR.skinLesionSharpBorder);


// ------------- bladderCancer  -------------
Disease bladderCancerDis = new Disease(
    LR.bladderCancer,
    L.bladderCancerDescription,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    50, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bladderSysSt,
    LR.none
);
bladderCancerDis.setPrintName(L.bladderCancerPrintName);
bladderCancerDis.setSuperDisease(LR.cancer);
bladderCancerDis.setMiscComments(L.bladderCancerComment);
bladderCancerDis.setCode358(118);
bladderCancerDis.setICD10code("C67");
bladderCancerDis.addReference("pp 93-96");
bladderCancerDis.addSymptom(LR.bladderIrritability);
bladderCancerDis.addSymptom(LR.nocturia);
bladderCancerDis.addSymptom(LR.postVoidingPain);
bladderCancerDis.addSymptom(LR.urinaryFrequency);
bladderCancerDis.addSymptom(LR.urineDribbling);
Treatment bladderCancerTr1 = new Treatment("bladderCancerTr1");
bladderCancerTr1.addTreatmentAction(LR.surgery);
bladderCancerDis.addTreatment("bladderCancerTr1");


// ------------- colorectalCancer  -------------
Disease colorectalCancerDis = new Disease(
    LR.colorectalCancer,
    L.colorectalCancerDescription,
    LR.neoPlasms,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.colonSysSt,
    LR.none
);
colorectalCancerDis.setPrintName(L.colorectalCancerPrintName);
colorectalCancerDis.setSuperDisease(LR.cancer);
colorectalCancerDis.setGenetic("1parent");
colorectalCancerDis.setParentDisease(LR.colorectalCancer);
colorectalCancerDis.setCode358(81);
colorectalCancerDis.setICD10code("C18");
colorectalCancerDis.addInternalCause(LR.ulcerativeColitis);
colorectalCancerDis.addCausesDisease(LR.anemia);
colorectalCancerDis.addCausesDisease(LR.colorectalCancerAdvanced);
colorectalCancerDis.addCausesDisease(LR.colorectalCancerAdvancedLeftTumor);
colorectalCancerDis.addCausesAbnormalCondition(LR.ascites);
colorectalCancerDis.addCausesAbnormalCondition(LR.hepatomegaly);
colorectalCancerDis.addReference("pp 87-89");
colorectalCancerDis.addSymptom(LR.pallor);
colorectalCancerDis.addSymptom(LR.cachexia);
colorectalCancerDis.addSymptom(LR.stoolBlack);
colorectalCancerDis.addSymptom(LR.stoolTarry);
colorectalCancerDis.addSymptom(LR.abdomenCramping);
Treatment colorectalCancerTr1 = new Treatment("colorectalCancerTr1");
colorectalCancerTr1.addTreatmentAction(LR.surgery);
colorectalCancerDis.addTreatment("colorectalCancerTr1");


// ------------- colorectalCancerAdvanced  -------------
Disease colorectalCancerAdvancedDis = new Disease(
    LR.colorectalCancerAdvanced,
    L.colorectalCancerAdvancedDescription,
    LR.neoPlasms,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.colonSysSt,
    LR.none
);
colorectalCancerAdvancedDis.setPrintName(L.colorectalCancerAdvancedPrintName);
colorectalCancerAdvancedDis.setSuperDisease(LR.cancer);
colorectalCancerAdvancedDis.setGenetic("1parent");
colorectalCancerAdvancedDis.setParentDisease(LR.colorectalCancer);
colorectalCancerAdvancedDis.setCode358(81);
colorectalCancerAdvancedDis.setICD10code("C18");
colorectalCancerAdvancedDis.addInternalCause(LR.colorectalCancer);
colorectalCancerAdvancedDis.addReference("pp 87-89");
colorectalCancerAdvancedDis.addSymptom(LR.anorexia);
colorectalCancerAdvancedDis.addSymptom(LR.diarrhea);
colorectalCancerAdvancedDis.addSymptom(LR.dyspnea);
colorectalCancerAdvancedDis.addSymptom(LR.fatigue);
colorectalCancerAdvancedDis.addSymptom(LR.obstipation);
colorectalCancerAdvancedDis.addSymptom(LR.vertigo);
colorectalCancerAdvancedDis.addSymptom(LR.vomiting);
colorectalCancerAdvancedDis.addSymptom(LR.weakness);
colorectalCancerAdvancedDis.addSymptom(LR.weightLoss);
Treatment colorectalCancerAdvancedTr1 = new Treatment("colorectalCancerAdvancedTr1");
colorectalCancerAdvancedTr1.addTreatmentAction(LR.surgery);
colorectalCancerAdvancedDis.addTreatment("colorectalCancerAdvancedTr1");


// ------------- colorectalCancerAdvancedLeftTumor  -------------
Disease colorectalCancerAdvancedLeftTumorDis = new Disease(
    LR.colorectalCancerAdvancedLeftTumor,
    L.colorectalCancerAdvancedLeftTumorDescription,
    LR.neoPlasms,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.colonSysSt,
    LR.none
);
colorectalCancerAdvancedLeftTumorDis.setPrintName(L.colorectalCancerAdvancedLeftTumorPrintName);
colorectalCancerAdvancedLeftTumorDis.setSuperDisease(LR.cancer);
colorectalCancerAdvancedLeftTumorDis.setGenetic("1parent");
colorectalCancerAdvancedLeftTumorDis.setParentDisease(LR.colorectalCancer);
colorectalCancerAdvancedLeftTumorDis.setCode358(81);
colorectalCancerAdvancedLeftTumorDis.setICD10code("C18");
colorectalCancerAdvancedLeftTumorDis.addInternalCause(LR.colorectalCancer);
colorectalCancerAdvancedLeftTumorDis.addReference("pp 87-89");
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.anorexia);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.diarrhea);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.dyspnea);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.fatigue);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.obstipation);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.vertigo);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.vomiting);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.weakness);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.weightLoss);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.bleedingFromRectum);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.stoolThinShaped);
Treatment colorectalCancerAdvancedLeftTumorTr1 = new Treatment("colorectalCancerAdvancedLeftTumorTr1");
colorectalCancerAdvancedLeftTumorTr1.addTreatmentAction(LR.surgery);
colorectalCancerAdvancedLeftTumorDis.addTreatment("colorectalCancerAdvancedLeftTumorTr1");


// ------------- larynxCancer  -------------
Disease larynxCancerDis = new Disease(
    LR.larynxCancer,
    L.larynxCancerDescription,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.larynxSysSt,
    LR.alcoholAbuse
);
larynxCancerDis.setPrintName(L.larynxCancerPrintName);
larynxCancerDis.setSuperDisease(LR.cancer);
larynxCancerDis.setCode358(92);
larynxCancerDis.setICD10code("C32");
larynxCancerDis.addReference("pp 63-65");
larynxCancerDis.addSymptom(LR.cough);
larynxCancerDis.addSymptom(LR.dyspnea);
larynxCancerDis.addSymptom(LR.dysphagia);
larynxCancerDis.addSymptom(LR.hoarseness);
larynxCancerDis.addSymptom(LR.throatSore);
Treatment larynxCancerTr1 = new Treatment("larynxCancerTr1");
larynxCancerTr1.addTreatmentAction(LR.surgery);
larynxCancerDis.addTreatment("larynxCancerTr1");
Treatment larynxCancerTr2 = new Treatment("larynxCancerTr2");
larynxCancerTr2.addTreatmentAction(LR.chemoTherapy);
larynxCancerDis.addTreatment("larynxCancerTr2");
Treatment larynxCancerTr3 = new Treatment("larynxCancerTr3");
larynxCancerTr3.addTreatmentAction(LR.radiationTherapy);
larynxCancerDis.addTreatment("larynxCancerTr3");


// ------------- lungCancer  -------------
Disease lungCancerDis = new Disease(
    LR.lungCancer,
    L.lungCancerDescription,
    LR.neoPlasms,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.none
);
lungCancerDis.setPrintName(L.lungCancerPrintName);
lungCancerDis.setSuperDisease(LR.cancer);
lungCancerDis.setMiscComments(L.lungCancerComment);
lungCancerDis.setCode358(93);
lungCancerDis.setICD10code("C33");
lungCancerDis.addReference("pp 70-73");
Treatment lungCancerTr1 = new Treatment("lungCancerTr1");
lungCancerTr1.addTreatmentAction(LR.chemoTherapy);
lungCancerTr1.addTreatmentAction(LR.radiationTherapy);
lungCancerTr1.addTreatmentAction(LR.surgery);
lungCancerDis.addTreatment("lungCancerTr1");


// ------------- lungCancerLargeCells  -------------
Disease lungCancerLargeCellsDis = new Disease(
    LR.lungCancerLargeCells,
    L.lungCancerLargeCellsDescription,
    LR.neoPlasms,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.none
);
lungCancerLargeCellsDis.setPrintName(L.lungCancerLargeCellsPrintName);
lungCancerLargeCellsDis.setSuperDisease(LR.lungCancer);
lungCancerLargeCellsDis.setMiscComments(L.lungCancerLargeCellsComment);
lungCancerLargeCellsDis.setCode358(93);
lungCancerLargeCellsDis.setICD10code("C33");
lungCancerLargeCellsDis.addReference("pp 70-73");
lungCancerLargeCellsDis.addSymptom(LR.anorexia);
lungCancerLargeCellsDis.addSymptom(LR.shoulderPain);
lungCancerLargeCellsDis.addSymptom(LR.weakness);
lungCancerLargeCellsDis.addSymptom(LR.weightLoss);


// ------------- lungCancerSmallCells  -------------
Disease lungCancerSmallCellsDis = new Disease(
    LR.lungCancerSmallCells,
    L.lungCancerSmallCellsDescription,
    LR.neoPlasms,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.none
);
lungCancerSmallCellsDis.setPrintName(L.lungCancerSmallCellsPrintName);
lungCancerSmallCellsDis.setSuperDisease(LR.lungCancer);
lungCancerSmallCellsDis.setMiscComments(L.lungCancerSmallCellsComment);
lungCancerSmallCellsDis.setCode358(93);
lungCancerSmallCellsDis.setICD10code("C33");
lungCancerSmallCellsDis.addReference("pp 70-73");
lungCancerSmallCellsDis.addSymptom(LR.chestPain);
lungCancerSmallCellsDis.addSymptom(LR.cough);
lungCancerSmallCellsDis.addSymptom(LR.dyspnea);
lungCancerSmallCellsDis.addSymptom(LR.hemoptysis);
lungCancerSmallCellsDis.addSymptom(LR.hoarseness);
lungCancerSmallCellsDis.addSymptom(LR.wheezing);


// ------------- breastsCancer  -------------
Disease breastsCancerDis = new Disease(
    LR.breastsCancer,
    L.breastsCancerDescription,
    LR.neoPlasms,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.breastsSysSt,
    LR.menstrualCycleLong
);
breastsCancerDis.setPrintName(L.breastsCancerPrintName);
breastsCancerDis.setSuperDisease(LR.cancer);
breastsCancerDis.setMiscComments(L.breastsCancerComment);
breastsCancerDis.addExternalCause(LR.mensesEarly);
breastsCancerDis.addExternalCause(LR.menopauseLate);
breastsCancerDis.addExternalCause(LR.neverPregnant);
breastsCancerDis.addExternalCause(LR.firstPregnancyLate);
breastsCancerDis.setGenetic("mother");
breastsCancerDis.setParentDisease(LR.breastsCancer);
breastsCancerDis.setCode358(104);
breastsCancerDis.setICD10code("C50");
breastsCancerDis.addInternalCause(LR.ovariesCancer);
breastsCancerDis.addInternalCause(LR.uterusCancer);
breastsCancerDis.addReference("pp 74-8");
breastsCancerDis.addSymptom(LR.breastLump);
breastsCancerDis.addSymptom(LR.breastSizeChange);
breastsCancerDis.addSymptom(LR.breastSkinThickening);
breastsCancerDis.addSymptom(LR.nippleAreaSkinScaly);
breastsCancerDis.addSymptom(LR.breastSkinDimpling);
breastsCancerDis.addSymptom(LR.breastSkinEdema);
breastsCancerDis.addSymptom(LR.breastSkinUlceration);
breastsCancerDis.addSymptom(LR.breastSkinAreaHot);
breastsCancerDis.addSymptom(LR.breastDischargeUnusual);
breastsCancerDis.addSymptom(LR.nippleItching);
breastsCancerDis.addSymptom(LR.nippleBurning);
breastsCancerDis.addSymptom(LR.nippleErosion);
breastsCancerDis.addSymptom(LR.nippleRetraction);
Treatment breastsCancerTr1 = new Treatment("breastsCancerTr1");
breastsCancerTr1.addTreatmentAction(LR.chemoTherapy);
breastsCancerTr1.addTreatmentAction(LR.radiationTherapy);
breastsCancerTr1.addTreatmentAction(LR.surgery);
breastsCancerDis.addTreatment("breastsCancerTr1");
Treatment breastsCancerTr2 = new Treatment("breastsCancerTr2");
breastsCancerTr2.addDrug(LR.androgens);
breastsCancerTr2.addDrug(LR.estrogen);
breastsCancerTr2.addDrug(LR.progesterone);
breastsCancerTr2.addDrug(LR.aminoglutethimide);
breastsCancerDis.addTreatment("breastsCancerTr2");


// ------------- cervixCancer  -------------
Disease cervixCancerDis = new Disease(
    LR.cervixCancer,
    L.cervixCancerDescription,
    LR.neoPlasms,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    50, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.cervixSysSt,
    LR.multiplePartners
);
cervixCancerDis.setPrintName(L.cervixCancerPrintName);
cervixCancerDis.setSuperDisease(LR.cancer);
cervixCancerDis.setMiscComments(L.cervixCancerComment);
cervixCancerDis.addExternalCause(LR.multiplePregnancies);
cervixCancerDis.addExternalCause(LR.youngAgeIntercourse);
cervixCancerDis.setCode358(107);
cervixCancerDis.setICD10code("C53");
cervixCancerDis.addInternalCause(LR.herpesSimplex);
cervixCancerDis.addReference("pp 104-7");


// ------------- cervixCancerEarly  -------------
Disease cervixCancerEarlyDis = new Disease(
    LR.cervixCancerEarly,
    L.cervixCancerEarlyDescription,
    LR.neoPlasms,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    50, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.cervixSysSt,
    LR.none
);
cervixCancerEarlyDis.setPrintName(L.cervixCancerEarlyPrintName);
cervixCancerEarlyDis.setSuperDisease(LR.cervixCancer);
cervixCancerEarlyDis.setMiscComments(L.cervixCancerEarlyComment);
cervixCancerEarlyDis.setCode358(107);
cervixCancerEarlyDis.setICD10code("C53");
cervixCancerEarlyDis.addReference("pp 104-7");
cervixCancerEarlyDis.addSymptom(LR.bleedingFromVagina);
cervixCancerEarlyDis.addSymptom(LR.vaginaDischargePersistent);
cervixCancerEarlyDis.addSymptom(LR.postcoitalPain);
cervixCancerEarlyDis.addSymptom(LR.postcoitalBleeding);
Treatment cervixCancerEarlyTr1 = new Treatment("cervixCancerEarlyTr1");
cervixCancerEarlyTr1.addTreatmentAction(LR.cryosurgery);
cervixCancerEarlyTr1.addTreatmentAction(LR.excision);
cervixCancerEarlyTr1.addTreatmentAction(LR.laserSurgery);
cervixCancerEarlyDis.addTreatment("cervixCancerEarlyTr1");


// ------------- cervixCancerAdvanced  -------------
Disease cervixCancerAdvancedDis = new Disease(
    LR.cervixCancerAdvanced,
    L.cervixCancerAdvancedDescription,
    LR.neoPlasms,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    50, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.cervixSysSt,
    LR.none
);
cervixCancerAdvancedDis.setPrintName(L.cervixCancerAdvancedPrintName);
cervixCancerAdvancedDis.setSuperDisease(LR.cervixCancer);
cervixCancerAdvancedDis.setCode358(107);
cervixCancerAdvancedDis.setICD10code("C53");
cervixCancerAdvancedDis.addCausesDisease(LR.anemia);
cervixCancerAdvancedDis.addReference("pp 104-7");
cervixCancerAdvancedDis.addSymptom(LR.anorexia);
cervixCancerAdvancedDis.addSymptom(LR.bleedingFromVagina);
cervixCancerAdvancedDis.addSymptom(LR.pelvisPain);
cervixCancerAdvancedDis.addSymptom(LR.vaginaDischargePersistent);
cervixCancerAdvancedDis.addSymptom(LR.weightLoss);
Treatment cervixCancerAdvancedTr2 = new Treatment("cervixCancerAdvancedTr2");
cervixCancerAdvancedTr2.addTreatmentAction(LR.hysterectomy);
cervixCancerAdvancedTr2.addTreatmentAction(LR.radiationTherapy);
cervixCancerAdvancedDis.addTreatment("cervixCancerAdvancedTr2");


// ------------- esophagusCancer  -------------
Disease esophagusCancerDis = new Disease(
    LR.esophagusCancer,
    L.esophagusCancerDescription,
    LR.neoPlasms,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    10, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.esophagusSysSt,
    LR.alcoholAbuse
);
esophagusCancerDis.setPrintName(L.esophagusCancerPrintName);
esophagusCancerDis.setSuperDisease(LR.cancer);
esophagusCancerDis.addExternalCause(LR.tobaccoUse);
esophagusCancerDis.setCode358(77);
esophagusCancerDis.setICD10code("C15");
esophagusCancerDis.addReference("pp 81-83");
esophagusCancerDis.addSymptom(LR.cough);
esophagusCancerDis.addSymptom(LR.dysphagia);
esophagusCancerDis.addSymptom(LR.emaciation);
esophagusCancerDis.addSymptom(LR.hoarseness);
esophagusCancerDis.addSymptom(LR.weightLoss);
Treatment esophagusCancerTr1 = new Treatment("esophagusCancerTr1");
esophagusCancerTr1.addTreatmentAction(LR.chemoTherapy);
esophagusCancerDis.addTreatment("esophagusCancerTr1");
Treatment esophagusCancerTr2 = new Treatment("esophagusCancerTr2");
esophagusCancerTr2.addTreatmentAction(LR.surgery);
esophagusCancerDis.addTreatment("esophagusCancerTr2");
Treatment esophagusCancerTr3 = new Treatment("esophagusCancerTr3");
esophagusCancerTr3.addTreatmentAction(LR.radiationTherapy);
esophagusCancerDis.addTreatment("esophagusCancerTr3");


// ------------- hodgkinDisease  -------------
Disease hodgkinDiseaseDis = new Disease(
    LR.hodgkinDisease,
    L.hodgkinDiseaseDescription,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lymphSysSt,
    LR.none
);
hodgkinDiseaseDis.setPrintName(L.hodgkinDiseasePrintName);
hodgkinDiseaseDis.setMiscComments(L.hodgkinDiseaseComment);
hodgkinDiseaseDis.setCode358(127);
hodgkinDiseaseDis.setICD10code("C81");
hodgkinDiseaseDis.addReference("pp 133-6");
Treatment hodgkinDiseaseTr1 = new Treatment("hodgkinDiseaseTr1");
hodgkinDiseaseTr1.addTreatmentAction(LR.chemoTherapy);
hodgkinDiseaseTr1.addTreatmentAction(LR.radiationTherapy);
hodgkinDiseaseDis.addTreatment("hodgkinDiseaseTr1");


// ------------- hodgkinDisease1  -------------
Disease hodgkinDisease1Dis = new Disease(
    LR.hodgkinDisease1,
    L.hodgkinDisease1Description,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lymphSysSt,
    LR.none
);
hodgkinDisease1Dis.setPrintName(L.hodgkinDisease1PrintName);
hodgkinDisease1Dis.setSuperDisease(LR.hodgkinDisease);
hodgkinDisease1Dis.setMiscComments(L.hodgkinDisease1Comment);
hodgkinDisease1Dis.setTemperature(101.0f);
hodgkinDisease1Dis.setCode358(127);
hodgkinDisease1Dis.setICD10code("C81");
hodgkinDisease1Dis.addCausesDisease(LR.hodgkinDisease2);
hodgkinDisease1Dis.addReference("pp 133-6");
hodgkinDisease1Dis.addSymptom(LR.neckLymphNodeEnlarged);
hodgkinDisease1Dis.addSymptom(LR.pruritus);


// ------------- hodgkinDisease2  -------------
Disease hodgkinDisease2Dis = new Disease(
    LR.hodgkinDisease2,
    L.hodgkinDisease2Description,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    2, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lymphSysSt,
    LR.none
);
hodgkinDisease2Dis.setPrintName(L.hodgkinDisease2PrintName);
hodgkinDisease2Dis.setSuperDisease(LR.hodgkinDisease);
hodgkinDisease2Dis.setMiscComments(L.hodgkinDisease2Comment);
hodgkinDisease2Dis.setTemperature(101.0f);
hodgkinDisease2Dis.setCode358(127);
hodgkinDisease2Dis.setICD10code("C81");
hodgkinDisease2Dis.addInternalCause(LR.hodgkinDisease1);
hodgkinDisease2Dis.addCausesDisease(LR.anemia);
hodgkinDisease2Dis.addReference("pp 133-6");
hodgkinDisease2Dis.addSymptom(LR.neckLymphNodeEnlarged);
hodgkinDisease2Dis.addSymptom(LR.pruritus);
hodgkinDisease2Dis.addSymptom(LR.jaundice);
hodgkinDisease2Dis.addSymptom(LR.lymphadenopathy);
hodgkinDisease2Dis.addSymptom(LR.faceEdema);
hodgkinDisease2Dis.addSymptom(LR.neckEdema);
hodgkinDisease2Dis.addSymptom(LR.nervePain);


// ------------- kidneyCancer  -------------
Disease kidneyCancerDis = new Disease(
    LR.kidneyCancer,
    L.kidneyCancerDescription,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.renalSysSt,
    LR.none
);
kidneyCancerDis.setPrintName(L.kidneyCancerPrintName);
kidneyCancerDis.setSuperDisease(LR.cancer);
kidneyCancerDis.setTemperature(101.0f);
kidneyCancerDis.setCode358(117);
kidneyCancerDis.setICD10code("C64");
kidneyCancerDis.addCausesDisease(LR.hypertension);
kidneyCancerDis.addReference("pp 89-91");
kidneyCancerDis.addSymptom(LR.abdomenMassPalpable);
kidneyCancerDis.addSymptom(LR.abdomenPain);
kidneyCancerDis.addSymptom(LR.backPain);
kidneyCancerDis.addSymptom(LR.flankPain);
kidneyCancerDis.addSymptom(LR.hematuria);
kidneyCancerDis.addSymptom(LR.urineRetention);
kidneyCancerDis.addSymptom(LR.weightLoss);
Treatment kidneyCancerTr1 = new Treatment("kidneyCancerTr1");
kidneyCancerTr1.addTreatmentAction(LR.surgery);
kidneyCancerDis.addTreatment("kidneyCancerTr1");


// ------------- leukemia  -------------
Disease leukemiaDis = new Disease(
    LR.leukemia,
    L.leukemiaDescription,
    LR.neoPlasms,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.hematologicSysSt,
    LR.none
);
leukemiaDis.setPrintName(L.leukemiaPrintName);
leukemiaDis.setTemperature(102.0f);
leukemiaDis.setCode358(135);
leukemiaDis.setICD10code("C92");
leukemiaDis.addCausesDisease(LR.anemia);
leukemiaDis.addReference("pp 139-45");
leukemiaDis.addSymptom(LR.bleedingAbnormal);
leukemiaDis.addSymptom(LR.bruising);
leukemiaDis.addSymptom(LR.chills);
leukemiaDis.addSymptom(LR.ecchymoses);
leukemiaDis.addSymptom(LR.pallor);
leukemiaDis.addSymptom(LR.petechiae);
leukemiaDis.addSymptom(LR.purpura);
leukemiaDis.addSymptom(LR.dyspnea, "", 0.3f);
leukemiaDis.addSymptom(LR.fatigue, "", 0.3f);
leukemiaDis.addSymptom(LR.malaise, "", 0.3f);
leukemiaDis.addSymptom(LR.palpitations, "", 0.3f);
leukemiaDis.addSymptom(LR.tachycardia, "", 0.3f);
Treatment leukemiaTr1 = new Treatment("leukemiaTr1");
leukemiaTr1.addTreatmentAction(LR.chemoTherapy);
leukemiaTr1.addTreatmentAction(LR.boneMarrowTransplant);
leukemiaDis.addTreatment("leukemiaTr1");


// ------------- liverCancer  -------------
Disease liverCancerDis = new Disease(
    LR.liverCancer,
    L.liverCancerDescription,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    50, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.liverSysSt,
    LR.none
);
liverCancerDis.setPrintName(L.liverCancerPrintName);
liverCancerDis.setSuperDisease(LR.cancer);
liverCancerDis.setMiscComments(L.liverCancerComment);
liverCancerDis.setTemperature(101.0f);
liverCancerDis.setCode358(85);
liverCancerDis.setICD10code("C22");
liverCancerDis.addInternalCause(LR.hepatitisViral);
liverCancerDis.addReference("pp 91-93");
liverCancerDis.addSymptom(LR.abdomenBloating);
liverCancerDis.addSymptom(LR.abdomenPainUpperRightSide);
liverCancerDis.addSymptom(LR.abdomenTenderness);
liverCancerDis.addSymptom(LR.anorexia);
liverCancerDis.addSymptom(LR.bleedingAbnormal);
liverCancerDis.addSymptom(LR.bruising);
liverCancerDis.addSymptom(LR.jaundice);
liverCancerDis.addSymptom(LR.weakness);
liverCancerDis.addSymptom(LR.weightLoss);
Treatment liverCancerTr1 = new Treatment("liverCancerTr1");
liverCancerTr1.addTreatmentAction(LR.surgery);
liverCancerDis.addTreatment("liverCancerTr1");


// ------------- malignantLymphomas  -------------
Disease malignantLymphomasDis = new Disease(
    LR.malignantLymphomas,
    L.malignantLymphomasDescription,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lymphSysSt,
    LR.none
);
malignantLymphomasDis.setPrintName(L.malignantLymphomasPrintName);
malignantLymphomasDis.setSuperDisease(LR.cancer);
malignantLymphomasDis.setTemperature(101.0f);
malignantLymphomasDis.setCode358(129);
malignantLymphomasDis.setICD10code("C82");
malignantLymphomasDis.addReference("pp 136-138");
malignantLymphomasDis.addSymptom(LR.appetiteLoss);
malignantLymphomasDis.addSymptom(LR.fatigue);
malignantLymphomasDis.addSymptom(LR.lymphadenopathy);
malignantLymphomasDis.addSymptom(LR.malaise);
malignantLymphomasDis.addSymptom(LR.nausea);
malignantLymphomasDis.addSymptom(LR.nightSweating);
malignantLymphomasDis.addSymptom(LR.tonsilsSwollen);
malignantLymphomasDis.addSymptom(LR.vomiting);
malignantLymphomasDis.addSymptom(LR.weightLoss);
Treatment malignantLymphomasTr1 = new Treatment("malignantLymphomasTr1");
malignantLymphomasTr1.addTreatmentAction(LR.radiationTherapy);
malignantLymphomasDis.addTreatment("malignantLymphomasTr1");
Treatment malignantLymphomasTr2 = new Treatment("malignantLymphomasTr2");
malignantLymphomasTr2.addTreatmentAction(LR.chemoTherapy);
malignantLymphomasTr2.addDrug(LR.cyclophosphamide);
malignantLymphomasTr2.addDrug(LR.prednisone);
malignantLymphomasDis.addTreatment("malignantLymphomasTr2");


// ------------- malignantMelanoma  -------------
Disease malignantMelanomaDis = new Disease(
    LR.malignantMelanoma,
    L.malignantMelanomaDescription,
    LR.neoPlasms,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    10, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.sunLight
);
malignantMelanomaDis.setPrintName(L.malignantMelanomaPrintName);
malignantMelanomaDis.setSuperDisease(LR.cancer);
malignantMelanomaDis.setMiscComments(L.malignantMelanomaComment);
malignantMelanomaDis.setCode358(98);
malignantMelanomaDis.setICD10code("C43");
malignantMelanomaDis.addReference("pp 127-31");
Treatment malignantMelanomaTr1 = new Treatment("malignantMelanomaTr1");
malignantMelanomaTr1.addTreatmentAction(LR.surgery);
malignantMelanomaDis.addTreatment("malignantMelanomaTr1");
Treatment malignantMelanomaTr2 = new Treatment("malignantMelanomaTr2", LR.ifSevere);
malignantMelanomaTr2.addTreatmentAction(LR.chemoTherapy);
malignantMelanomaDis.addTreatment("malignantMelanomaTr2");


// ------------- lentigoMalignaMelanoma  -------------
Disease lentigoMalignaMelanomaDis = new Disease(
    LR.lentigoMalignaMelanoma,
    L.lentigoMalignaMelanomaDescription,
    LR.neoPlasms,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    10, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
lentigoMalignaMelanomaDis.setPrintName(L.lentigoMalignaMelanomaPrintName);
lentigoMalignaMelanomaDis.setSuperDisease(LR.malignantMelanoma);
lentigoMalignaMelanomaDis.setMiscComments(L.lentigoMalignaMelanomaComment);
lentigoMalignaMelanomaDis.setCode358(98);
lentigoMalignaMelanomaDis.setICD10code("C43");
lentigoMalignaMelanomaDis.addReference("pp 127-31");
lentigoMalignaMelanomaDis.addIllustration(D.LentigoMalignaMelanomaJpg);
lentigoMalignaMelanomaDis.addSymptom(LR.skinLesionFreckelLike);
lentigoMalignaMelanomaDis.addSymptom(LR.skinLesionBlackNodules);


// ------------- nodularMelanoma  -------------
Disease nodularMelanomaDis = new Disease(
    LR.nodularMelanoma,
    L.nodularMelanomaDescription,
    LR.neoPlasms,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    10, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
nodularMelanomaDis.setPrintName(L.nodularMelanomaPrintName);
nodularMelanomaDis.setSuperDisease(LR.malignantMelanoma);
nodularMelanomaDis.setMiscComments(L.nodularMelanomaComment);
nodularMelanomaDis.setCode358(98);
nodularMelanomaDis.setICD10code("C43");
nodularMelanomaDis.addReference("pp 127-31");
nodularMelanomaDis.addSymptom(LR.skinLesionUniformDarkColor);
nodularMelanomaDis.addSymptom(LR.skinLesionBlackberryLike);


// ------------- superficialSpreadingMelanoma  -------------
Disease superficialSpreadingMelanomaDis = new Disease(
    LR.superficialSpreadingMelanoma,
    L.superficialSpreadingMelanomaDescription,
    LR.neoPlasms,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    10, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
superficialSpreadingMelanomaDis.setPrintName(L.superficialSpreadingMelanomaPrintName);
superficialSpreadingMelanomaDis.setSuperDisease(LR.malignantMelanoma);
superficialSpreadingMelanomaDis.setMiscComments(L.superficialSpreadingMelanomaComment);
superficialSpreadingMelanomaDis.setCode358(98);
superficialSpreadingMelanomaDis.setICD10code("C43");
superficialSpreadingMelanomaDis.addReference("pp 127-31");
superficialSpreadingMelanomaDis.addSymptom(LR.skinLesionRedWhite);
superficialSpreadingMelanomaDis.addSymptom(LR.skinLesionBlue);
superficialSpreadingMelanomaDis.addSymptom(LR.skinLesionBackgroundBrownBlack);
superficialSpreadingMelanomaDis.addSymptom(LR.skinLesionSurfaceIrregular);
superficialSpreadingMelanomaDis.addSymptom(LR.skinLesionNodulesBleeding);


// ------------- multipleMyeloma  -------------
Disease multipleMyelomaDis = new Disease(
    LR.multipleMyeloma,
    L.multipleMyelomaDescription,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skeletalSysSt,
    LR.none
);
multipleMyelomaDis.setPrintName(L.multipleMyelomaPrintName);
multipleMyelomaDis.setSuperDisease(LR.cancer);
multipleMyelomaDis.setCode358(132);
multipleMyelomaDis.setICD10code("C90");
multipleMyelomaDis.addCausesDisease(LR.anemia);
multipleMyelomaDis.addReference("pp 122-124");
multipleMyelomaDis.addSymptom(LR.backPain);
multipleMyelomaDis.addSymptom(LR.jointSwelling);
multipleMyelomaDis.addSymptom(LR.jointTender);
multipleMyelomaDis.addSymptom(LR.feverSym);
multipleMyelomaDis.addSymptom(LR.malaise);
multipleMyelomaDis.addSymptom(LR.weightLoss);
Treatment multipleMyelomaTr1 = new Treatment("multipleMyelomaTr1");
multipleMyelomaTr1.addTreatmentAction(LR.chemoTherapy);
multipleMyelomaTr1.addDrug(LR.prednisone);
multipleMyelomaDis.addTreatment("multipleMyelomaTr1");


// ------------- pancreasCancer  -------------
Disease pancreasCancerDis = new Disease(
    LR.pancreasCancer,
    L.pancreasCancerDescription,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    35, // minAge
    70, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.pancreasSysSt,
    LR.alcoholAbuse
);
pancreasCancerDis.setPrintName(L.pancreasCancerPrintName);
pancreasCancerDis.setSuperDisease(LR.cancer);
pancreasCancerDis.setMiscComments(L.pancreasCancerComment);
pancreasCancerDis.setTemperature(101.0f);
pancreasCancerDis.setCode358(88);
pancreasCancerDis.setICD10code("C25");
pancreasCancerDis.addInternalCause(LR.diabetesMellitus);
pancreasCancerDis.addInternalCause(LR.pancreatitis);
pancreasCancerDis.addCausesDisease(LR.depression);
pancreasCancerDis.addReference("pp 83-7");
pancreasCancerDis.addSymptom(LR.abdomenPain, "", 0.5f);
pancreasCancerDis.addSymptom(LR.anxiety);
pancreasCancerDis.addSymptom(LR.diarrhea);
pancreasCancerDis.addSymptom(LR.doomFeeling);
pancreasCancerDis.addSymptom(LR.jaundice);
pancreasCancerDis.addSymptom(LR.lowBackPain, "", 0.5f);
pancreasCancerDis.addSymptom(LR.weightLoss);
Treatment pancreasCancerTr1 = new Treatment("pancreasCancerTr1");
pancreasCancerTr1.addTreatmentAction(LR.chemoTherapy);
pancreasCancerTr1.addTreatmentAction(LR.radiationTherapy);
pancreasCancerTr1.addTreatmentAction(LR.surgery);
pancreasCancerDis.addTreatment("pancreasCancerTr1");


// ------------- prostateCancer  -------------
Disease prostateCancerDis = new Disease(
    LR.prostateCancer,
    L.prostateCancerDescription,
    LR.neoPlasms,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.prostateSysSt,
    LR.none
);
prostateCancerDis.setPrintName(L.prostateCancerPrintName);
prostateCancerDis.setSuperDisease(LR.cancer);
prostateCancerDis.setMiscComments(L.prostateCancerComment);
prostateCancerDis.setCode358(113);
prostateCancerDis.setICD10code("C61");
prostateCancerDis.addCausesDisease(LR.cystitis);
prostateCancerDis.addReference("pp 98-101");
prostateCancerDis.addSymptom(LR.hematuria, "", 0.05f);
prostateCancerDis.addSymptom(LR.urinaryFrequency);
prostateCancerDis.addSymptom(LR.nocturia);
prostateCancerDis.addSymptom(LR.urinationStartDifficult);
prostateCancerDis.addSymptom(LR.urineDribbling);
prostateCancerDis.addSymptom(LR.urineRetention);
Treatment prostateCancerTr1 = new Treatment("prostateCancerTr1");
prostateCancerTr1.addTreatmentAction(LR.radiationTherapy);
prostateCancerTr1.addTreatmentAction(LR.surgery);
prostateCancerTr1.addDrug(LR.estrogen);
prostateCancerTr1.addDrug(LR.antiandrogens);
prostateCancerDis.addTreatment("prostateCancerTr1");


// ------------- squamousCellCarcinoma  -------------
Disease squamousCellCarcinomaDis = new Disease(
    LR.squamousCellCarcinoma,
    L.squamousCellCarcinomaDescription,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    50, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.sunLight
);
squamousCellCarcinomaDis.setPrintName(L.squamousCellCarcinomaPrintName);
squamousCellCarcinomaDis.setSuperDisease(LR.cancer);
squamousCellCarcinomaDis.addReference("pp 125-7");
squamousCellCarcinomaDis.addSymptom(LR.papuleRedSmall, L.squamousCellCarcinoma_papuleRedSmall, 0.5f);
squamousCellCarcinomaDis.addSymptom(LR.skinLesionCrackedCrusty, "", 0.5f);
squamousCellCarcinomaDis.addSymptom(LR.skinLesionDryScaly, "", 0.5f);
squamousCellCarcinomaDis.addSymptom(LR.skinLesionSurfaceIrregular, L.squamousCellCarcinoma_skinLesionSurfaceIrregular, 0.5f);


// ------------- stomachCancerSuper  -------------
Disease stomachCancerSuperDis = new Disease(
    LR.stomachCancerSuper,
    L.stomachCancerSuperDescription,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.stomachSysSt,
    LR.alcoholAbuse
);
stomachCancerSuperDis.setPrintName(L.stomachCancerSuperPrintName);
stomachCancerSuperDis.setSuperDisease(LR.cancer);
stomachCancerSuperDis.addExternalCause(LR.tobaccoUse);
stomachCancerSuperDis.setGenetic("1parent");
stomachCancerSuperDis.setParentDisease(LR.stomachCancerSuper);
stomachCancerSuperDis.setCode358(78);
stomachCancerSuperDis.setICD10code("C16");
stomachCancerSuperDis.addReference("pp 78-81");
stomachCancerSuperDis.addSymptom(LR.dyspepsia);
stomachCancerSuperDis.addSymptom(LR.dysphagia);
stomachCancerSuperDis.addSymptom(LR.stomachache);
Treatment stomachCancerSuperTr1 = new Treatment("stomachCancerSuperTr1");
stomachCancerSuperTr1.addTreatmentAction(LR.surgery);
stomachCancerSuperDis.addTreatment("stomachCancerSuperTr1");


// ------------- stomachCancer  -------------
Disease stomachCancerDis = new Disease(
    LR.stomachCancer,
    L.stomachCancerDescription,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.stomachSysSt,
    LR.alcoholAbuse
);
stomachCancerDis.setPrintName(L.stomachCancerPrintName);
stomachCancerDis.setSuperDisease(LR.stomachCancerSuper);
stomachCancerDis.setGenetic("1parent");
stomachCancerDis.setParentDisease(LR.stomachCancer);
stomachCancerDis.setCode358(78);
stomachCancerDis.setICD10code("C16");
stomachCancerDis.addCausesDisease(LR.stomachCancerAdvanced);
stomachCancerDis.addReference("pp 78-81");
stomachCancerDis.addSymptom(LR.anorexia, "", 0.5f);
stomachCancerDis.addSymptom(LR.bloating, "", 0.5f);
stomachCancerDis.addSymptom(LR.heartburn, "", 0.5f);
stomachCancerDis.addSymptom(LR.nausea, "", 0.5f);


// ------------- stomachCancerAdvanced  -------------
Disease stomachCancerAdvancedDis = new Disease(
    LR.stomachCancerAdvanced,
    L.stomachCancerAdvancedDescription,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.stomachSysSt,
    LR.none
);
stomachCancerAdvancedDis.setPrintName(L.stomachCancerAdvancedPrintName);
stomachCancerAdvancedDis.setSuperDisease(LR.stomachCancerSuper);
stomachCancerAdvancedDis.setGenetic("1parent");
stomachCancerAdvancedDis.setParentDisease(LR.stomachCancer);
stomachCancerAdvancedDis.setCode358(78);
stomachCancerAdvancedDis.setICD10code("C16");
stomachCancerAdvancedDis.addInternalCause(LR.stomachCancer);
stomachCancerAdvancedDis.addCausesDisease(LR.anemia);
stomachCancerAdvancedDis.addReference("pp 78-81");
stomachCancerAdvancedDis.addSymptom(LR.anorexia);
stomachCancerAdvancedDis.addSymptom(LR.fatigue);
stomachCancerAdvancedDis.addSymptom(LR.vomiting);
stomachCancerAdvancedDis.addSymptom(LR.weightLoss);
stomachCancerAdvancedDis.addSymptom(LR.stoolBloody, "", 0.5f);


// ------------- thyroidCancer  -------------
Disease thyroidCancerDis = new Disease(
    LR.thyroidCancer,
    L.thyroidCancerDescription,
    LR.neoPlasms,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.thyroidSysSt,
    LR.none
);
thyroidCancerDis.setPrintName(L.thyroidCancerPrintName);
thyroidCancerDis.setSuperDisease(LR.cancer);
thyroidCancerDis.setCode358(124);
thyroidCancerDis.setICD10code("C73");
thyroidCancerDis.addReference("pp 65-68");
thyroidCancerDis.addSymptom(LR.cough);
thyroidCancerDis.addSymptom(LR.dysphagia);
thyroidCancerDis.addSymptom(LR.dyspnea);
thyroidCancerDis.addSymptom(LR.hoarseness);
thyroidCancerDis.addSymptom(LR.neckEdema);
thyroidCancerDis.addSymptom(LR.thyroidEnlargement);
Treatment thyroidCancerTr1 = new Treatment("thyroidCancerTr1");
thyroidCancerTr1.addTreatmentAction(LR.surgery);
thyroidCancerDis.addTreatment("thyroidCancerTr1");
Treatment thyroidCancerTr2 = new Treatment("thyroidCancerTr2");
thyroidCancerTr2.addTreatmentAction(LR.radiationTherapy);
thyroidCancerDis.addTreatment("thyroidCancerTr2");
Treatment thyroidCancerTr3 = new Treatment("thyroidCancerTr3");
thyroidCancerTr3.addTreatmentAction(LR.chemoTherapy);
thyroidCancerDis.addTreatment("thyroidCancerTr3");


// ------------- uterusCancer  -------------
Disease uterusCancerDis = new Disease(
    LR.uterusCancer,
    L.uterusCancerDescription,
    LR.neoPlasms,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    50, // minAge
    60, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.uterusSysSt,
    LR.uterusPolypsHistory
);
uterusCancerDis.setPrintName(L.uterusCancerPrintName);
uterusCancerDis.setSuperDisease(LR.cancer);
uterusCancerDis.setGenetic("mother");
uterusCancerDis.setParentDisease(LR.uterusCancer);
uterusCancerDis.setCode358(108);
uterusCancerDis.setICD10code("C54");
uterusCancerDis.addInternalCause(LR.diabetes);
uterusCancerDis.addInternalCause(LR.obesity);
uterusCancerDis.addCausingAbnormalCondition(LR.lowFertility);
uterusCancerDis.addCausingAbnormalCondition(LR.anovulation);
uterusCancerDis.addReference("pp 107-10");
uterusCancerDis.addSymptom(LR.uterusBleedingAbnormal);
uterusCancerDis.addSymptom(LR.uterusEnlarged);
uterusCancerDis.addSymptom(LR.weightLoss, L.uterusCancer_weightLoss, 0.2f);
uterusCancerDis.addSymptom(LR.uterusPain, L.uterusCancer_uterusPain, 0.2f);
Treatment uterusCancerTr1 = new Treatment("uterusCancerTr1");
uterusCancerTr1.addTreatmentAction(LR.hysterectomy);
uterusCancerDis.addTreatment("uterusCancerTr1");
Treatment uterusCancerTr2 = new Treatment("uterusCancerTr2");
uterusCancerTr2.addTreatmentAction(LR.radiationTherapy);
uterusCancerDis.addTreatment("uterusCancerTr2");
Treatment uterusCancerTr3 = new Treatment("uterusCancerTr3");
uterusCancerTr3.addTreatmentAction(LR.hormoneTherapy);
uterusCancerDis.addTreatment("uterusCancerTr3");
Treatment uterusCancerTr4 = new Treatment("uterusCancerTr4");
uterusCancerTr4.addTreatmentAction(LR.chemoTherapy);
uterusCancerDis.addTreatment("uterusCancerTr4");


// ------------- vaginaCancer  -------------
Disease vaginaCancerDis = new Disease(
    LR.vaginaCancer,
    L.vaginaCancerDescription,
    LR.neoPlasms,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    50, // minAge
    55, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vaginagySysSt,
    LR.none
);
vaginaCancerDis.setPrintName(L.vaginaCancerPrintName);
vaginaCancerDis.setSuperDisease(LR.cancer);
vaginaCancerDis.setCode358(106);
vaginaCancerDis.setICD10code("C52");
vaginaCancerDis.addReference("pp 110-2");
vaginaCancerDis.addSymptom(LR.bleedingFromVaginaAbnormal);
vaginaCancerDis.addSymptom(LR.vaginaDischarge);
vaginaCancerDis.addSymptom(LR.vaginaUlceratedLesion);


// ------------- vaginaCancerEarly  -------------
Disease vaginaCancerEarlyDis = new Disease(
    LR.vaginaCancerEarly,
    L.vaginaCancerEarlyDescription,
    LR.neoPlasms,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    50, // minAge
    55, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vaginagySysSt,
    LR.none
);
vaginaCancerEarlyDis.setPrintName(L.vaginaCancerEarlyPrintName);
vaginaCancerEarlyDis.setSuperDisease(LR.vaginaCancer);
vaginaCancerEarlyDis.setCode358(106);
vaginaCancerEarlyDis.setICD10code("C52");
vaginaCancerEarlyDis.addCausesDisease(LR.vaginaCancerAdvanced);
vaginaCancerEarlyDis.addReference("pp 110-2");
Treatment vaginaCancerEarlyTr1 = new Treatment("vaginaCancerEarlyTr1");
vaginaCancerEarlyTr1.addTreatmentAction(LR.chemoTherapy);
vaginaCancerEarlyDis.addTreatment("vaginaCancerEarlyTr1");


// ------------- vaginaCancerAdvanced  -------------
Disease vaginaCancerAdvancedDis = new Disease(
    LR.vaginaCancerAdvanced,
    L.vaginaCancerAdvancedDescription,
    LR.neoPlasms,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    50, // minAge
    55, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vaginagySysSt,
    LR.none
);
vaginaCancerAdvancedDis.setPrintName(L.vaginaCancerAdvancedPrintName);
vaginaCancerAdvancedDis.setSuperDisease(LR.vaginaCancer);
vaginaCancerAdvancedDis.setCode358(106);
vaginaCancerAdvancedDis.setICD10code("C52");
vaginaCancerAdvancedDis.addInternalCause(LR.vaginaCancerEarly);
vaginaCancerAdvancedDis.addReference("pp 110-2");
vaginaCancerAdvancedDis.addSymptom(LR.bleedingFromRectum);
vaginaCancerAdvancedDis.addSymptom(LR.urinaryFrequency);
vaginaCancerAdvancedDis.addSymptom(LR.bladderPain);
vaginaCancerAdvancedDis.addSymptom(LR.vulvaLesion);
vaginaCancerAdvancedDis.addSymptom(LR.pubisPain);
Treatment vaginaCancerAdvancedTr1 = new Treatment("vaginaCancerAdvancedTr1");
vaginaCancerAdvancedTr1.addTreatmentAction(LR.radiationTherapy);
vaginaCancerAdvancedTr1.addTreatmentAction(LR.surgery);
vaginaCancerAdvancedDis.addTreatment("vaginaCancerAdvancedTr1");


// ------------- ovariesCancer  -------------
Disease ovariesCancerDis = new Disease(
    LR.ovariesCancer,
    L.ovariesCancerDescription,
    LR.neoPlasms,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    54, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.ovariesSysSt,
    LR.asbestosExposure
);
ovariesCancerDis.setPrintName(L.ovariesCancerPrintName);
ovariesCancerDis.setSuperDisease(LR.cancer);
ovariesCancerDis.addExternalCause(LR.nulliparity);
ovariesCancerDis.addExternalCause(LR.dietHighFat);
ovariesCancerDis.addExternalCause(LR.talcExposure);
ovariesCancerDis.setGenetic("mother");
ovariesCancerDis.setParentDisease(LR.ovariesCancer);
ovariesCancerDis.setCode358(109);
ovariesCancerDis.setICD10code("C56");
ovariesCancerDis.addInternalCause(LR.infertilityFemale);
ovariesCancerDis.addInternalCause(LR.breastsCancer);
ovariesCancerDis.addInternalCause(LR.uterusCancer);
ovariesCancerDis.addReference("pp 112-5");
Treatment ovariesCancerTr1 = new Treatment("ovariesCancerTr1");
ovariesCancerTr1.addTreatmentAction(LR.chemoTherapy);
ovariesCancerTr1.addTreatmentAction(LR.radiationTherapy);
ovariesCancerTr1.addTreatmentAction(LR.surgery);
ovariesCancerDis.addTreatment("ovariesCancerTr1");


// ------------- ovariesCancerEarly  -------------
Disease ovariesCancerEarlyDis = new Disease(
    LR.ovariesCancerEarly,
    L.ovariesCancerEarlyDescription,
    LR.neoPlasms,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    54, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.ovariesSysSt,
    LR.none
);
ovariesCancerEarlyDis.setPrintName(L.ovariesCancerEarlyPrintName);
ovariesCancerEarlyDis.setSuperDisease(LR.ovariesCancer);
ovariesCancerEarlyDis.setGenetic("mother");
ovariesCancerEarlyDis.setParentDisease(LR.ovariesCancer);
ovariesCancerEarlyDis.setCode358(109);
ovariesCancerEarlyDis.setICD10code("C56");
ovariesCancerEarlyDis.addReference("pp 112-5");
ovariesCancerEarlyDis.addSymptom(LR.abdomenPain);
ovariesCancerEarlyDis.addSymptom(LR.constipation);
ovariesCancerEarlyDis.addSymptom(LR.dyspepsia);
ovariesCancerEarlyDis.addSymptom(LR.pelvisDiscomfort);
ovariesCancerEarlyDis.addSymptom(LR.urinaryFrequency);
ovariesCancerEarlyDis.addSymptom(LR.weightLoss);


// ------------- ovariesCancerAdvanced  -------------
Disease ovariesCancerAdvancedDis = new Disease(
    LR.ovariesCancerAdvanced,
    L.ovariesCancerAdvancedDescription,
    LR.neoPlasms,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    54, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.ovariesSysSt,
    LR.none
);
ovariesCancerAdvancedDis.setPrintName(L.ovariesCancerAdvancedPrintName);
ovariesCancerAdvancedDis.setSuperDisease(LR.ovariesCancerEarly);
ovariesCancerAdvancedDis.setMiscComments(L.ovariesCancerAdvancedComment);
ovariesCancerAdvancedDis.setGenetic("mother");
ovariesCancerAdvancedDis.setParentDisease(LR.ovariesCancer);
ovariesCancerAdvancedDis.setCode358(109);
ovariesCancerAdvancedDis.setICD10code("C56");
ovariesCancerAdvancedDis.addCausesAbnormalCondition(LR.ascites);
ovariesCancerAdvancedDis.addCausesAbnormalCondition(LR.pleuralEffusion);
ovariesCancerAdvancedDis.addReference("pp 112-5");


// ------------- vulvaCancer  -------------
Disease vulvaCancerDis = new Disease(
    LR.vulvaCancer,
    L.vulvaCancerDescription,
    LR.neoPlasms,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    60, // minAge
    70, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vulvaSysSt,
    LR.nulliparity
);
vulvaCancerDis.setPrintName(L.vulvaCancerPrintName);
vulvaCancerDis.setSuperDisease(LR.cancer);
vulvaCancerDis.setMiscComments(L.vulvaCancerComment);
vulvaCancerDis.setCode358(106);
vulvaCancerDis.setICD10code("C51");
vulvaCancerDis.addInternalCause(LR.leukoplakia);
vulvaCancerDis.addInternalCause(LR.diabetes);
vulvaCancerDis.addInternalCause(LR.herpesSimplex);
vulvaCancerDis.addInternalCause(LR.obesity);
vulvaCancerDis.addReference("pp 115-7");
vulvaCancerDis.addSymptom(LR.vulvaItching);
vulvaCancerDis.addSymptom(LR.bleedingVulva);
vulvaCancerDis.addSymptom(LR.vulvaUlcer);
vulvaCancerDis.addSymptom(LR.vulvaUlcerInfected);
vulvaCancerDis.addSymptom(LR.vulvaPain);
Treatment vulvaCancerTr1 = new Treatment("vulvaCancerTr1");
vulvaCancerTr1.addTreatmentAction(LR.laserSurgery);
vulvaCancerTr1.addTreatmentAction(LR.surgery);
vulvaCancerDis.addTreatment("vulvaCancerTr1");


// ------------- fallopianTubeCancer  -------------
Disease fallopianTubeCancerDis = new Disease(
    LR.fallopianTubeCancer,
    L.fallopianTubeCancerDescription,
    LR.neoPlasms,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    50, // minAge
    70, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.fallopianTubesSysSt,
    LR.nulliparity
);
fallopianTubeCancerDis.setPrintName(L.fallopianTubeCancerPrintName);
fallopianTubeCancerDis.setSuperDisease(LR.cancer);
fallopianTubeCancerDis.setMiscComments(L.fallopianTubeCancerComment);
fallopianTubeCancerDis.setCode358(110);
fallopianTubeCancerDis.setICD10code("C57");
fallopianTubeCancerDis.addReference("pp 117-9");
fallopianTubeCancerDis.addSymptom(LR.abdomenCramping);
fallopianTubeCancerDis.addSymptom(LR.abdomenDistension);
fallopianTubeCancerDis.addSymptom(LR.abdomenMassPalpable);
fallopianTubeCancerDis.addSymptom(LR.bladderPressure);
fallopianTubeCancerDis.addSymptom(LR.bleedingFromVaginaProfuse);
fallopianTubeCancerDis.addSymptom(LR.colonPain);
fallopianTubeCancerDis.addSymptom(LR.constipation);
fallopianTubeCancerDis.addSymptom(LR.urinaryFrequency);
fallopianTubeCancerDis.addSymptom(LR.vaginaDischargeAmberColored);
fallopianTubeCancerDis.addSymptom(LR.weightLoss);
Treatment fallopianTubeCancerTr1 = new Treatment("fallopianTubeCancerTr1");
fallopianTubeCancerTr1.addTreatmentAction(LR.chemoTherapy);
fallopianTubeCancerTr1.addTreatmentAction(LR.radiationTherapy);
fallopianTubeCancerTr1.addTreatmentAction(LR.surgery);
fallopianTubeCancerDis.addTreatment("fallopianTubeCancerTr1");


// ------------- leukoplakia  -------------
Disease leukoplakiaDis = new Disease(
    LR.leukoplakia,
    L.leukoplakiaDescription,
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
leukoplakiaDis.setPrintName(L.leukoplakiaPrintName);
leukoplakiaDis.addReference("pp 126");
Treatment leukoplakiaTr1 = new Treatment("leukoplakiaTr1");
leukoplakiaTr1.addTreatmentAction(LR.curettage);
leukoplakiaTr1.addTreatmentAction(LR.surgery);
leukoplakiaDis.addTreatment("leukoplakiaTr1");


// ------------- leukoplakiaMale  -------------
Disease leukoplakiaMaleDis = new Disease(
    LR.leukoplakiaMale,
    L.leukoplakiaMaleDescription,
    LR.neoPlasms,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mouthSysSt,
    LR.none
);
leukoplakiaMaleDis.setPrintName(L.leukoplakiaMalePrintName);
leukoplakiaMaleDis.setSuperDisease(LR.leukoplakia);
leukoplakiaMaleDis.addReference("pp 126");
leukoplakiaMaleDis.addSymptom(LR.mouthLesionWhiteGrey);


// ------------- leukoplakiaFemale  -------------
Disease leukoplakiaFemaleDis = new Disease(
    LR.leukoplakiaFemale,
    L.leukoplakiaFemaleDescription,
    LR.neoPlasms,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
leukoplakiaFemaleDis.setPrintName(L.leukoplakiaFemalePrintName);
leukoplakiaFemaleDis.setSuperDisease(LR.leukoplakia);
leukoplakiaFemaleDis.addReference("pp 126");
leukoplakiaFemaleDis.addSymptom(LR.mouthLesionWhiteGrey);
leukoplakiaFemaleDis.addSymptom(LR.genitalLesionWhiteGrey);
} // end of neoPlasms





// ------------- neurologicDisorders  -------------
static public void neurologicDisorders() { 


// ------------- alzheimer  -------------
Disease alzheimerDis = new Disease(
    LR.alzheimer,
    L.alzheimerDescription,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.brainSysSt,
    LR.none
);
alzheimerDis.setPrintName(L.alzheimerPrintName);
alzheimerDis.setCode358(189);
alzheimerDis.setICD10code("G30");
alzheimerDis.addReference("pp 638-40");
Treatment alzheimerTr1 = new Treatment("alzheimerTr1");
alzheimerTr1.addTreatmentAction(LR.oxygenTherapy);
alzheimerTr1.addDrug(LR.antidepressants);
alzheimerTr1.addDrug(LR.cerebralVasodilators);
alzheimerTr1.addDrug(LR.psychostimulators);
alzheimerTr1.addDrug(LR.tacrine);
alzheimerTr1.addDrug(LR.vitaminE);
alzheimerDis.addTreatment("alzheimerTr1");


// ------------- alzheimer1  -------------
Disease alzheimer1Dis = new Disease(
    LR.alzheimer1,
    L.alzheimer1Description,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.brainSysSt,
    LR.none
);
alzheimer1Dis.setPrintName(L.alzheimer1PrintName);
alzheimer1Dis.setSuperDisease(LR.alzheimer);
alzheimer1Dis.setCode358(189);
alzheimer1Dis.setICD10code("G30");
alzheimer1Dis.addCausesDisease(LR.alzheimer2);
alzheimer1Dis.addReference("pp 638-40");
alzheimer1Dis.addSymptom(LR.concentrationLoss);
alzheimer1Dis.addSymptom(LR.forgetfulness);
alzheimer1Dis.addSymptom(LR.memoryRecentLoss);
alzheimer1Dis.addSymptom(LR.learningDifficulty);


// ------------- alzheimer2  -------------
Disease alzheimer2Dis = new Disease(
    LR.alzheimer2,
    L.alzheimer2Description,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.brainSysSt,
    LR.none
);
alzheimer2Dis.setPrintName(L.alzheimer2PrintName);
alzheimer2Dis.setSuperDisease(LR.alzheimer);
alzheimer2Dis.setCode358(189);
alzheimer2Dis.setICD10code("G30");
alzheimer2Dis.addInternalCause(LR.alzheimer1);
alzheimer2Dis.addCausesDisease(LR.alzheimer3);
alzheimer2Dis.addReference("pp 638-40");
alzheimer2Dis.addSymptom(LR.concentrationLoss);
alzheimer2Dis.addSymptom(LR.forgetfulness);
alzheimer2Dis.addSymptom(LR.memoryRecentLoss);
alzheimer2Dis.addSymptom(LR.learningDifficulty);
alzheimer2Dis.addSymptom(LR.abstractThinkingImpaired);
alzheimer2Dis.addSymptom(LR.judgementImpaired);


// ------------- alzheimer3  -------------
Disease alzheimer3Dis = new Disease(
    LR.alzheimer3,
    L.alzheimer3Description,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.brainSysSt,
    LR.none
);
alzheimer3Dis.setPrintName(L.alzheimer3PrintName);
alzheimer3Dis.setSuperDisease(LR.alzheimer);
alzheimer3Dis.setCode358(189);
alzheimer3Dis.setICD10code("G30");
alzheimer3Dis.addInternalCause(LR.alzheimer2);
alzheimer3Dis.addReference("pp 638-40");
alzheimer3Dis.addSymptom(LR.concentrationLoss);
alzheimer3Dis.addSymptom(LR.forgetfulness);
alzheimer3Dis.addSymptom(LR.memoryRecentLoss);
alzheimer3Dis.addSymptom(LR.learningDifficulty);
alzheimer3Dis.addSymptom(LR.abstractThinkingImpaired);
alzheimer3Dis.addSymptom(LR.judgementImpaired);
alzheimer3Dis.addSymptom(LR.communicationImpaired);
alzheimer3Dis.addSymptom(LR.memoryDetoriation);
alzheimer3Dis.addSymptom(LR.languageDetoriation);
alzheimer3Dis.addSymptom(LR.coordinationDetoriation);
alzheimer3Dis.addSymptom(LR.personalityChange);
alzheimer3Dis.addSymptom(LR.restlessness);
alzheimer3Dis.addSymptom(LR.irritability);


// ------------- amyotropicLateralSclerosis  -------------
Disease amyotropicLateralSclerosisDis = new Disease(
    LR.amyotropicLateralSclerosis,
    L.amyotropicLateralSclerosisDescription,
    LR.neurologicDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    70, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.neurologicSysSt,
    LR.none
);
amyotropicLateralSclerosisDis.setPrintName(L.amyotropicLateralSclerosisPrintName);
amyotropicLateralSclerosisDis.setMiscComments(L.amyotropicLateralSclerosisComment);
amyotropicLateralSclerosisDis.setGenetic("1parent");
amyotropicLateralSclerosisDis.setParentDisease(LR.amyotropicLateralSclerosis);
amyotropicLateralSclerosisDis.addCausesDisease(LR.corPulmonale);
amyotropicLateralSclerosisDis.addReference("pp 647-9");
amyotropicLateralSclerosisDis.addSymptom(LR.breathingDifficult);
amyotropicLateralSclerosisDis.addSymptom(LR.chewingDifficult);
amyotropicLateralSclerosisDis.addSymptom(LR.choking, "", 0.2f);
amyotropicLateralSclerosisDis.addSymptom(LR.drooling, "", 0.2f);
amyotropicLateralSclerosisDis.addSymptom(LR.muscleWeakness);
amyotropicLateralSclerosisDis.addSymptom(LR.speechDifficulty);
amyotropicLateralSclerosisDis.addSymptom(LR.dysphagia);


// ------------- bellPalsy  -------------
Disease bellPalsyDis = new Disease(
    LR.bellPalsy,
    L.bellPalsyDescription,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -5, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.cranialNerve7thSysSt,
    LR.none
);
bellPalsyDis.setPrintName(L.bellPalsyPrintName);
bellPalsyDis.setMiscComments(L.bellPalsyComment);
bellPalsyDis.addReference("pp 654-5");
bellPalsyDis.addSymptom(LR.mouthDroops);
bellPalsyDis.addSymptom(LR.tasteLoss, "", 0.5f);
bellPalsyDis.addSymptom(LR.tinnitus, "", 0.5f);
Treatment bellPalsyTr1 = new Treatment("bellPalsyTr1");
bellPalsyTr1.addDrug(LR.prednisone);
bellPalsyDis.addTreatment("bellPalsyTr1");


// ------------- brainAbscess  -------------
Disease brainAbscessDis = new Disease(
    LR.brainAbscess,
    L.brainAbscessDescription,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    10, // minAge
    30, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.brainSysSt,
    LR.none
);
brainAbscessDis.setPrintName(L.brainAbscessPrintName);
brainAbscessDis.setMiscComments(L.brainAbscessComment);
brainAbscessDis.addReference("pp 631-4");
brainAbscessDis.addSymptom(LR.headacheConstant);
brainAbscessDis.addSymptom(LR.nausea);
brainAbscessDis.addSymptom(LR.ocularDisturbance);
brainAbscessDis.addSymptom(LR.seizure);
brainAbscessDis.addSymptom(LR.vomiting);
Treatment brainAbscessTr1 = new Treatment("brainAbscessTr1");
brainAbscessTr1.addTreatmentAction(LR.bedRest);
brainAbscessTr1.addTreatmentAction(LR.drainageOfAbscess);
brainAbscessTr1.addDrug(LR.analgetics);
brainAbscessTr1.addDrug(LR.antibiotics);
brainAbscessDis.addTreatment("brainAbscessTr1");


// ------------- cerebralAneurysm  -------------
Disease cerebralAneurysmDis = new Disease(
    LR.cerebralAneurysm,
    L.cerebralAneurysmDescription,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.brainSysSt,
    LR.none
);
cerebralAneurysmDis.setPrintName(L.cerebralAneurysmPrintName);
cerebralAneurysmDis.setMiscComments(L.cerebralAneurysmComment);
cerebralAneurysmDis.addReference("pp 614-8");
cerebralAneurysmDis.addSymptom(LR.consciousnessDecreased);
cerebralAneurysmDis.addSymptom(LR.dysphagia);
cerebralAneurysmDis.addSymptom(LR.headache);
cerebralAneurysmDis.addSymptom(LR.nausea);
cerebralAneurysmDis.addSymptom(LR.nuchalRigidity);
cerebralAneurysmDis.addSymptom(LR.visionBlurred);
cerebralAneurysmDis.addSymptom(LR.pupilChanges);
cerebralAneurysmDis.addSymptom(LR.seizure);
cerebralAneurysmDis.addSymptom(LR.backStiff);
cerebralAneurysmDis.addSymptom(LR.legStiff);
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
cerebralAneurysmDis.addTreatment("cerebralAneurysmTr1");


// ------------- cerebrovascularAccident  -------------
Disease cerebrovascularAccidentDis = new Disease(
    LR.cerebrovascularAccident,
    L.cerebrovascularAccidentDescription,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.brainSysSt,
    LR.none
);
cerebrovascularAccidentDis.setPrintName(L.cerebrovascularAccidentPrintName);
cerebrovascularAccidentDis.setCode358(238);
cerebrovascularAccidentDis.setICD10code("I64");
cerebrovascularAccidentDis.addInternalCause(LR.hypertension);
cerebrovascularAccidentDis.addReference("pp 623-7");
cerebrovascularAccidentDis.addSymptom(LR.amnesia);
cerebrovascularAccidentDis.addSymptom(LR.aphasia);
cerebrovascularAccidentDis.addSymptom(LR.confusion);
cerebrovascularAccidentDis.addSymptom(LR.dysphasia);
cerebrovascularAccidentDis.addSymptom(LR.hemiparesis);
cerebrovascularAccidentDis.addSymptom(LR.pupilChanges);
cerebrovascularAccidentDis.addSymptom(LR.sensoryChanges);
cerebrovascularAccidentDis.addSymptom(LR.speechSlurred);
cerebrovascularAccidentDis.addSymptom(LR.weakness);
Treatment cerebrovascularAccidentTr1 = new Treatment("cerebrovascularAccidentTr1");
cerebrovascularAccidentTr1.addTreatmentAction(LR.surgery);
cerebrovascularAccidentTr1.addTreatmentAction(LR.antiplateletAggregateTherapy);
cerebrovascularAccidentTr1.addDrug(LR.anticonvulsants);
cerebrovascularAccidentTr1.addDrug(LR.analgetics);
cerebrovascularAccidentTr1.addDrug(LR.stoolSoftener);
cerebrovascularAccidentDis.addTreatment("cerebrovascularAccidentTr1");


// ------------- chorea  -------------
Disease choreaDis = new Disease(
    LR.chorea,
    L.choreaDescription,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.centralNervousSysSt,
    LR.none
);
choreaDis.setPrintName(L.choreaPrintName);
choreaDis.setMiscComments(L.choreaComment);
choreaDis.addReference("1087 and 634-5");
choreaDis.addSymptom(LR.faceSpasm, "", 0.6f);
choreaDis.addSymptom(LR.fingerSpasm, "", 0.4f);
choreaDis.addSymptom(LR.footSpasm, "", 0.2f);
choreaDis.addSymptom(LR.handSpasm, "", 0.4f);
choreaDis.addSymptom(LR.spasm);


// ------------- huntingtonDisease  -------------
Disease huntingtonDiseaseDis = new Disease(
    LR.huntingtonDisease,
    L.huntingtonDiseaseDescription,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    25, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.centralNervousSysSt,
    LR.none
);
huntingtonDiseaseDis.setPrintName(L.huntingtonDiseasePrintName);
huntingtonDiseaseDis.setSuperDisease(LR.chorea);
huntingtonDiseaseDis.setMiscComments(L.huntingtonDiseaseComment);
huntingtonDiseaseDis.setGenetic("1parent");
huntingtonDiseaseDis.setParentDisease(LR.huntingtonDisease);
huntingtonDiseaseDis.addReference("pp 634-5");
huntingtonDiseaseDis.addSymptom(LR.clumsy);
huntingtonDiseaseDis.addSymptom(LR.focussingDifficulty);
huntingtonDiseaseDis.addSymptom(LR.impulsive);
huntingtonDiseaseDis.addSymptom(LR.learningDifficulty);
Treatment huntingtonDiseaseTr1 = new Treatment("huntingtonDiseaseTr1");
huntingtonDiseaseTr1.addDrug(LR.tranquilizer);
huntingtonDiseaseDis.addTreatment("huntingtonDiseaseTr1");


// ------------- choreaTransient  -------------
Disease choreaTransientDis = new Disease(
    LR.choreaTransient,
    L.choreaTransientDescription,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    25, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.centralNervousSysSt,
    LR.none
);
choreaTransientDis.setPrintName(L.choreaTransientPrintName);
choreaTransientDis.setSuperDisease(LR.chorea);
choreaTransientDis.setMiscComments(L.choreaTransientComment);
choreaTransientDis.addInternalCause(LR.rheumaticFever);
choreaTransientDis.addReference("pp 1087-8");
choreaTransientDis.addSymptom(LR.concentrationLoss);
choreaTransientDis.addSymptom(LR.irritability);
choreaTransientDis.addSymptom(LR.weakness);


// ------------- chronicHeadache  -------------
Disease chronicHeadacheDis = new Disease(
    LR.chronicHeadache,
    L.chronicHeadacheDescription,
    LR.neurologicDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.neurologicSysSt,
    LR.none
);
chronicHeadacheDis.setPrintName(L.chronicHeadachePrintName);
chronicHeadacheDis.addReference("pp 618-20");
chronicHeadacheDis.addSymptom(LR.anorexia, "", 0.2f);
chronicHeadacheDis.addSymptom(LR.headacheConstant);
chronicHeadacheDis.addSymptom(LR.headacheSevere);
chronicHeadacheDis.addSymptom(LR.irritability, "", 0.2f);
chronicHeadacheDis.addSymptom(LR.nausea, "", 0.2f);
chronicHeadacheDis.addSymptom(LR.photophobia, "", 0.2f);
chronicHeadacheDis.addSymptom(LR.vomiting, "", 0.2f);
Treatment chronicHeadacheTr1 = new Treatment("chronicHeadacheTr1");
chronicHeadacheTr1.addDrug(LR.aspirin);
chronicHeadacheDis.addTreatment("chronicHeadacheTr1");
Treatment chronicHeadacheTr2 = new Treatment("chronicHeadacheTr2", LR.ifAcute);
chronicHeadacheTr2.addDrug(LR.diazepam);
chronicHeadacheDis.addTreatment("chronicHeadacheTr2");


// ------------- encephalitis  -------------
Disease encephalitisDis = new Disease(
    LR.encephalitis,
    L.encephalitisDescription,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.brainSysSt,
    LR.none
);
encephalitisDis.setPrintName(L.encephalitisPrintName);
encephalitisDis.setTemperature(100.0f);
encephalitisDis.setCode358(39);
encephalitisDis.setICD10code("A83");
encephalitisDis.addInternalCause(LR.lymeDisease);
encephalitisDis.addInternalCause(LR.toxoplasmosisAcquiredAdvanced);
encephalitisDis.addInternalCause(LR.westNileVirus);
encephalitisDis.addReference("pp 630");
encephalitisDis.addSymptom(LR.ataxia);
encephalitisDis.addSymptom(LR.backStiff);
encephalitisDis.addSymptom(LR.coma);
encephalitisDis.addSymptom(LR.drowsiness);
encephalitisDis.addSymptom(LR.feverRapidOnset);
encephalitisDis.addSymptom(LR.headache);
encephalitisDis.addSymptom(LR.neckStiff);
encephalitisDis.addSymptom(LR.paralysis);
encephalitisDis.addSymptom(LR.psychosis);
encephalitisDis.addSymptom(LR.seizure);
encephalitisDis.addSymptom(LR.vomiting);
Treatment encephalitisTr1 = new Treatment("encephalitisTr1");
encephalitisTr1.addTreatmentAction(LR.bedRest);
encephalitisTr1.addTreatmentAction(LR.seizurePrecautions);
encephalitisTr1.addDrug(LR.acyclovir);
encephalitisTr1.addDrug(LR.analgetics);
encephalitisTr1.addDrug(LR.anticonvulsants);
encephalitisTr1.addDrug(LR.furosemide);
encephalitisTr1.addDrug(LR.mannitol);
encephalitisTr1.addDrug(LR.glucocorticoids);
encephalitisDis.addTreatment("encephalitisTr1");


// ------------- epilepsy  -------------
Disease epilepsyDis = new Disease(
    LR.epilepsy,
    L.epilepsyDescription,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.brainSysSt,
    LR.none
);
epilepsyDis.setPrintName(L.epilepsyPrintName);
epilepsyDis.setMiscComments(L.epilepsyComment);
epilepsyDis.setCode358(191);
epilepsyDis.setICD10code("G40");
epilepsyDis.addReference("pp 620-3");
epilepsyDis.addSymptom(LR.seizure);
epilepsyDis.addSymptom(LR.hallucinations, "", 0.05f);
epilepsyDis.addSymptom(LR.muscleContractions, "", 0.1f);
Treatment epilepsyTr1 = new Treatment("epilepsyTr1");
epilepsyTr1.addDrug(LR.phenobarbital);
epilepsyTr1.addDrug(LR.phenytoin);
epilepsyTr1.addDrug(LR.carbamazepine);
epilepsyTr1.addDrug(LR.primidone);
epilepsyDis.addTreatment("epilepsyTr1");


// ------------- guillainBarreSyndrome  -------------
Disease guillainBarreSyndromeDis = new Disease(
    LR.guillainBarreSyndrome,
    L.guillainBarreSyndromeDescription,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    50, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.neurologicSysSt,
    LR.none
);
guillainBarreSyndromeDis.setPrintName(L.guillainBarreSyndromePrintName);
guillainBarreSyndromeDis.setMiscComments(L.guillainBarreSyndromeComment);
guillainBarreSyndromeDis.addInternalCause(LR.campylobacteriosis);
guillainBarreSyndromeDis.addCausesAbnormalCondition(LR.areflexia);
guillainBarreSyndromeDis.addCausesAbnormalCondition(LR.hypotonia);
guillainBarreSyndromeDis.addReference("pp 642-645");
guillainBarreSyndromeDis.addSymptom(LR.dysarthria, "", 0.7f);
guillainBarreSyndromeDis.addSymptom(LR.dysphagia, "", 0.7f);
guillainBarreSyndromeDis.addSymptom(LR.muscleWeakness);
guillainBarreSyndromeDis.addSymptom(LR.paresthesia);
guillainBarreSyndromeDis.addSymptom(LR.stiffness);


// ------------- hydrocephalus  -------------
Disease hydrocephalusDis = new Disease(
    LR.hydrocephalus,
    L.hydrocephalusDescription,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.brainSysSt,
    LR.none
);
hydrocephalusDis.setPrintName(L.hydrocephalusPrintName);
hydrocephalusDis.addInternalCause(LR.precociousPubertyFemaleCerebral);
hydrocephalusDis.addInternalCause(LR.precociousPubertyMaleCerebral);
hydrocephalusDis.addInternalCause(LR.toxoplasmosisCongenital);
hydrocephalusDis.addReference("pp 611-4");
Treatment hydrocephalusTr1 = new Treatment("hydrocephalusTr1");
hydrocephalusTr1.addTreatmentAction(LR.surgery);
hydrocephalusDis.addTreatment("hydrocephalusTr1");


// ------------- hydrocephalusAdult  -------------
Disease hydrocephalusAdultDis = new Disease(
    LR.hydrocephalusAdult,
    L.hydrocephalusAdultDescription,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    1, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.brainSysSt,
    LR.injury
);
hydrocephalusAdultDis.setPrintName(L.hydrocephalusAdultPrintName);
hydrocephalusAdultDis.setSuperDisease(LR.hydrocephalus);
hydrocephalusAdultDis.addReference("pp 611-4");
hydrocephalusAdultDis.addSymptom(LR.ataxia);
hydrocephalusAdultDis.addSymptom(LR.consciousnessDecreased);
hydrocephalusAdultDis.addSymptom(LR.incontinence);
hydrocephalusAdultDis.addSymptom(LR.intellectImpaired);


// ------------- hydrocephalusInfant  -------------
Disease hydrocephalusInfantDis = new Disease(
    LR.hydrocephalusInfant,
    L.hydrocephalusInfantDescription,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    1, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.brainSysSt,
    LR.none
);
hydrocephalusInfantDis.setPrintName(L.hydrocephalusInfantPrintName);
hydrocephalusInfantDis.setSuperDisease(LR.hydrocephalus);
hydrocephalusInfantDis.addReference("pp 611-4");
hydrocephalusInfantDis.addSymptom(LR.skullDistension);
hydrocephalusInfantDis.addSymptom(LR.anorexia);
hydrocephalusInfantDis.addSymptom(LR.irritability);


// ------------- meningitis  -------------
Disease meningitisDis = new Disease(
    LR.meningitis,
    L.meningitisDescription,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    F.meningitisFreq, // diagnosis frequency, -1 = unknown
    LR.centralNervousSysSt,
    LR.none
);
meningitisDis.setPrintName(L.meningitisPrintName);
meningitisDis.setTemperature(100.0f);
meningitisDis.setCode358(186);
meningitisDis.setICD10code("G00");
meningitisDis.addInternalCause(LR.pneumonia);
meningitisDis.addInternalCause(LR.sarcoidosisCNS);
meningitisDis.addInternalCause(LR.syphilisLateNeurologic);
meningitisDis.addInternalCause(LR.lymeDisease2);
meningitisDis.addInternalCause(LR.otitisMedia);
meningitisDis.addInternalCause(LR.listeriosisSuper);
meningitisDis.addReference("pp 627-30");
meningitisDis.addSymptom(LR.arrhythmia);
meningitisDis.addSymptom(LR.chills);
meningitisDis.addSymptom(LR.coma);
meningitisDis.addSymptom(LR.headache);
meningitisDis.addSymptom(LR.irritability);
meningitisDis.addSymptom(LR.malaise);
meningitisDis.addSymptom(LR.nuchalRigidity);
meningitisDis.addSymptom(LR.opisthotonos);
meningitisDis.addSymptom(LR.papilledema, "", 0.1f);
meningitisDis.addSymptom(LR.photophobia);
meningitisDis.addSymptom(LR.stupor);
meningitisDis.addSymptom(LR.vomiting);
Treatment meningitisTr1 = new Treatment("meningitisTr1");
meningitisTr1.addTreatmentAction(LR.bedRest);
meningitisTr1.addDrug(LR.analgetics);
meningitisTr1.addDrug(LR.antibiotics);
meningitisTr1.addDrug(LR.anticonvulsants);
meningitisTr1.addDrug(LR.digitalisGlycosides);
meningitisTr1.addDrug(LR.sedatives);
meningitisDis.addTreatment("meningitisTr1");


// ------------- multipleSclerosis  -------------
Disease multipleSclerosisDis = new Disease(
    LR.multipleSclerosis,
    L.multipleSclerosisDescription,
    LR.neurologicDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.neurologicSysSt,
    LR.none
);
multipleSclerosisDis.setPrintName(L.multipleSclerosisPrintName);
multipleSclerosisDis.setMiscComments(L.multipleSclerosisComment);
multipleSclerosisDis.setGenetic("1parent");
multipleSclerosisDis.setParentDisease(LR.multipleSclerosis);
multipleSclerosisDis.setCode358(190);
multipleSclerosisDis.setICD10code("G35");
multipleSclerosisDis.addCausesDisease(LR.depression);
multipleSclerosisDis.addReference("pp 649-51");
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
Treatment multipleSclerosisTr1 = new Treatment("multipleSclerosisTr1");
multipleSclerosisTr1.addTreatmentAction(LR.bedRest);
multipleSclerosisTr1.addTreatmentAction(LR.massage);
multipleSclerosisTr1.addDrug(LR.dexamethasone);
multipleSclerosisTr1.addDrug(LR.prednisone);
multipleSclerosisTr1.addDrug(LR.corticotropin);
multipleSclerosisDis.addTreatment("multipleSclerosisTr1");


// ------------- myastheniaGravis  -------------
Disease myastheniaGravisDis = new Disease(
    LR.myastheniaGravis,
    L.myastheniaGravisDescription,
    LR.neurologicDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.neurologicSysSt,
    LR.none
);
myastheniaGravisDis.setPrintName(L.myastheniaGravisPrintName);
myastheniaGravisDis.addReference("pp 645-7");
myastheniaGravisDis.addSymptom(LR.chewingDifficult);
myastheniaGravisDis.addSymptom(LR.diplopia);
myastheniaGravisDis.addSymptom(LR.fatigue);
myastheniaGravisDis.addSymptom(LR.ptosis);
myastheniaGravisDis.addSymptom(LR.dysphagia);
Treatment myastheniaGravisTr1 = new Treatment("myastheniaGravisTr1");
myastheniaGravisTr1.addDrug(LR.corticosteroids);
myastheniaGravisTr1.addDrug(LR.anticholinesterase);
myastheniaGravisTr1.addDrug(LR.immunosuppressant);
myastheniaGravisTr1.addDrug(LR.plasmapheresis);
myastheniaGravisDis.addTreatment("myastheniaGravisTr1");


// ------------- parkinson  -------------
Disease parkinsonDis = new Disease(
    LR.parkinson,
    L.parkinsonDescription,
    LR.neurologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    50, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.centralNervousSysSt,
    LR.none
);
parkinsonDis.setPrintName(L.parkinsonPrintName);
parkinsonDis.setCode358(188);
parkinsonDis.setICD10code("G20");
parkinsonDis.addReference("pp 635-7");
parkinsonDis.addSymptom(LR.akinesia);
parkinsonDis.addSymptom(LR.muscleRigid);
parkinsonDis.addSymptom(LR.tremors);
Treatment parkinsonTr1 = new Treatment("parkinsonTr1");
parkinsonTr1.addDrug(LR.levodopa);
parkinsonDis.addTreatment("parkinsonTr1");


// ------------- trigeminalNeuralgia  -------------
Disease trigeminalNeuralgiaDis = new Disease(
    LR.trigeminalNeuralgia,
    L.trigeminalNeuralgiaDescription,
    LR.neurologicDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    35, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.cranialNerve5thSysSt,
    LR.none
);
trigeminalNeuralgiaDis.setPrintName(L.trigeminalNeuralgiaPrintName);
trigeminalNeuralgiaDis.setMiscComments(L.trigeminalNeuralgiaComment);
trigeminalNeuralgiaDis.addReference("pp 652-4");
trigeminalNeuralgiaDis.addIllustration(D.TrigeminalNeuralgiaGif);
trigeminalNeuralgiaDis.addSymptom(LR.faceBurningPain);
trigeminalNeuralgiaDis.addSymptom(LR.faceSearingPain);
Treatment trigeminalNeuralgiaTr1 = new Treatment("trigeminalNeuralgiaTr1");
trigeminalNeuralgiaTr1.addDrug(LR.carbamazepine);
trigeminalNeuralgiaTr1.addDrug(LR.phenytoin);
trigeminalNeuralgiaDis.addTreatment("trigeminalNeuralgiaTr1");
Treatment trigeminalNeuralgiaTr2 = new Treatment("trigeminalNeuralgiaTr2", LR.ifSevere);
trigeminalNeuralgiaTr2.addTreatmentAction(LR.surgery);
trigeminalNeuralgiaDis.addTreatment("trigeminalNeuralgiaTr2");
} // end of neurologicDisorders





// ------------- noseDisorders  -------------
static public void noseDisorders() { 


// ------------- epistaxis  -------------
Disease epistaxisDis = new Disease(
    LR.epistaxis,
    L.epistaxisDescription,
    LR.noseDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -2, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.noseSysSt,
    LR.trauma
);
epistaxisDis.setPrintName(L.epistaxisPrintName);
epistaxisDis.setMiscComments(L.epistaxisComment);
epistaxisDis.addExternalCause(LR.aspirinUse);
epistaxisDis.addExternalCause(LR.highAltitude);
epistaxisDis.addInternalCause(LR.anemia);
epistaxisDis.addInternalCause(LR.hemophilia);
epistaxisDis.addInternalCause(LR.hodgkinDisease);
epistaxisDis.addInternalCause(LR.hypertension);
epistaxisDis.addInternalCause(LR.idiopathicThrombocytopenicPurpura);
epistaxisDis.addInternalCause(LR.leukemia);
epistaxisDis.addInternalCause(LR.rheumaticFever);
epistaxisDis.addInternalCause(LR.vitaminCDeficiency);
epistaxisDis.addInternalCause(LR.vitaminKDeficiency);
epistaxisDis.addReference("pp 1210-2");
epistaxisDis.addSymptom(LR.bleedingFromMouth, L.epistaxis_bleedingFromMouth, 1.0f);
epistaxisDis.addSymptom(LR.bleedingFromNose, L.epistaxis_bleedingFromNose, 1.0f);
epistaxisDis.addSymptom(LR.dizziness, L.epistaxis_dizziness, 0.2f);
epistaxisDis.addSymptom(LR.lightHeadedness, L.epistaxis_lightHeadedness, 0.2f);
Treatment epistaxisTr1 = new Treatment("epistaxisTr1");
epistaxisTr1.addTreatmentAction(LR.externalPressure);
epistaxisDis.addTreatment("epistaxisTr1");
Treatment epistaxisTr2 = new Treatment("epistaxisTr2", LR.ifSevereBleeding);
epistaxisTr2.addTreatmentAction(LR.cottonBall);
epistaxisTr2.addTreatmentAction(LR.cauterization);
epistaxisDis.addTreatment("epistaxisTr2");


// ------------- sinusitis  -------------
Disease sinusitisDis = new Disease(
    LR.sinusitis,
    L.sinusitisDescription,
    LR.noseDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.noseSysSt,
    LR.infection
);
sinusitisDis.setPrintName(L.sinusitisPrintName);
sinusitisDis.setTemperature(99.5f);
sinusitisDis.addInternalCause(LR.bronchiectasis);
sinusitisDis.addInternalCause(LR.pharyngitisStreptococcal);
sinusitisDis.addReference("pp 1213-1215");
sinusitisDis.addSymptom(LR.headache);
sinusitisDis.addSymptom(LR.malaise);
sinusitisDis.addSymptom(LR.noseDischarge);
sinusitisDis.addSymptom(LR.throatSore);
Treatment sinusitisTr1 = new Treatment("sinusitisTr1");
sinusitisTr1.addTreatmentAction(LR.steamInhalation);
sinusitisTr1.addDrug(LR.decongestant);
sinusitisDis.addTreatment("sinusitisTr1");
Treatment sinusitisTr2 = new Treatment("sinusitisTr2", LR.ifInfection);
sinusitisTr2.addDrug(LR.antibiotics);
sinusitisDis.addTreatment("sinusitisTr2");
} // end of noseDisorders





// ------------- nutritionalDisorders  -------------
static public void nutritionalDisorders() { 


// ------------- obesity  -------------
Disease obesityDis = new Disease(
    LR.obesity,
    L.obesityDescription,
    LR.nutritionalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
obesityDis.setPrintName(L.obesityPrintName);
obesityDis.setMiscComments(L.obesityComment);
obesityDis.addCausesDisease(LR.atelectasis);
obesityDis.addCausesDisease(LR.diabetesComplicationsInPregnancy);
obesityDis.addCausesDisease(LR.diabetesMellitus);
obesityDis.addCausesDisease(LR.hypertension);
obesityDis.addCausesDisease(LR.pulmonaryEmbolism);
obesityDis.addCausesDisease(LR.uterusCancer);
obesityDis.addCausesDisease(LR.vulvaCancer);
obesityDis.addCausesAbnormalCondition(LR.death);
obesityDis.addReference("pp 874");
obesityDis.addSymptom(LR.BMIover30);
obesityDis.addSymptom(LR.overweight);
Treatment obesityTr1 = new Treatment("obesityTr1");
obesityTr1.addTreatmentAction(LR.diet);
obesityTr1.addTreatmentAction(LR.exercise);
obesityTr1.addTreatmentAction(LR.surgery);
obesityDis.addTreatment("obesityTr1");
} // end of nutritionalDisorders





// ------------- pediatricDisorders  -------------
static public void pediatricDisorders() { 


// ------------- colicInfant  -------------
Disease colicInfantDis = new Disease(
    LR.colicInfant,
    L.colicInfantDescription,
    LR.pediatricDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    1, // maxAge
    -6, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
colicInfantDis.setPrintName(L.colicInfantPrintName);
colicInfantDis.setMiscComments(L.colicInfantComment);
colicInfantDis.addReference("pp2 234-5");
colicInfantDis.addSymptom(LR.cryingSpellFrequent);
} // end of pediatricDisorders





// ------------- psychiatricDisorders  -------------
static public void psychiatricDisorders() { 


// ------------- anorexiaNervosa  -------------
Disease anorexiaNervosaDis = new Disease(
    LR.anorexiaNervosa,
    L.anorexiaNervosaDescription,
    LR.psychiatricDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mindSysSt,
    LR.none
);
anorexiaNervosaDis.setPrintName(L.anorexiaNervosaPrintName);
anorexiaNervosaDis.setMiscComments(L.anorexiaNervosaComment);
anorexiaNervosaDis.addCausesDisease(LR.amenorrhea);
anorexiaNervosaDis.addCausesDisease(LR.infertilityFemale);
anorexiaNervosaDis.addReference("pp 480-3");
anorexiaNervosaDis.addSymptom(LR.hyperactivity, "", 0.5f);
anorexiaNervosaDis.addSymptom(LR.bodyImageDistorted, "", 0.5f);
anorexiaNervosaDis.addSymptom(LR.angry, "", 0.3f);
anorexiaNervosaDis.addSymptom(LR.bradycardia, "", 0.3f);
anorexiaNervosaDis.addSymptom(LR.coldIntolerance, "", 0.3f);
anorexiaNervosaDis.addSymptom(LR.constipation, "", 0.3f);
anorexiaNervosaDis.addSymptom(LR.fatigue, "", 0.3f);
anorexiaNervosaDis.addSymptom(LR.hypotension, "", 0.3f);
anorexiaNervosaDis.addSymptom(LR.libidoLoss, "", 0.3f);
anorexiaNervosaDis.addSymptom(LR.muscleLoss, "", 0.3f);
anorexiaNervosaDis.addSymptom(LR.sleepDisturbed, "", 0.3f);
anorexiaNervosaDis.addSymptom(LR.weightLoss);
anorexiaNervosaDis.addSymptom(LR.reflexesDecreased);
anorexiaNervosaDis.addSymptom(LR.ritualistic, "", 0.3f);
Treatment anorexiaNervosaTr1 = new Treatment("anorexiaNervosaTr1");
anorexiaNervosaTr1.addTreatmentAction(LR.behaviorTherapy);
anorexiaNervosaTr1.addTreatmentAction(LR.weightIncrease);
anorexiaNervosaTr1.addTreatmentAction(LR.hospitalization);
anorexiaNervosaTr1.addDrug(LR.vitaminSupplements);
anorexiaNervosaDis.addTreatment("anorexiaNervosaTr1");


// ------------- attentionDeficitHyperactivityDisorder  -------------
Disease attentionDeficitHyperactivityDisorderDis = new Disease(
    LR.attentionDeficitHyperactivityDisorder,
    L.attentionDeficitHyperactivityDisorderDescription,
    LR.psychiatricDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.brainSysSt,
    LR.none
);
attentionDeficitHyperactivityDisorderDis.setPrintName(L.attentionDeficitHyperactivityDisorderPrintName);
attentionDeficitHyperactivityDisorderDis.setGenetic("1parent");
attentionDeficitHyperactivityDisorderDis.setParentDisease(LR.attentionDeficitHyperactivityDisorder);
attentionDeficitHyperactivityDisorderDis.addReference("pp 416-8");
attentionDeficitHyperactivityDisorderDis.addSymptom(LR.concentrationLoss);
attentionDeficitHyperactivityDisorderDis.addSymptom(LR.daydreaming);
attentionDeficitHyperactivityDisorderDis.addSymptom(LR.fidgeting);
attentionDeficitHyperactivityDisorderDis.addSymptom(LR.impulsive);
attentionDeficitHyperactivityDisorderDis.addSymptom(LR.inattention);
Treatment attentionDeficitHyperactivityDisorderTr1 = new Treatment("attentionDeficitHyperactivityDisorderTr1");
attentionDeficitHyperactivityDisorderTr1.addTreatmentAction(LR.behaviorTherapy);
attentionDeficitHyperactivityDisorderDis.addTreatment("attentionDeficitHyperactivityDisorderTr1");


// ------------- bulimiaNervosa  -------------
Disease bulimiaNervosaDis = new Disease(
    LR.bulimiaNervosa,
    L.bulimiaNervosaDescription,
    LR.psychiatricDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mindSysSt,
    LR.none
);
bulimiaNervosaDis.setPrintName(L.bulimiaNervosaPrintName);
bulimiaNervosaDis.setMiscComments(L.bulimiaNervosaComment);
bulimiaNervosaDis.addCausesDisease(LR.amenorrhea);
bulimiaNervosaDis.addReference("pp  477-9");
bulimiaNervosaDis.addSymptom(LR.bingeEating);
bulimiaNervosaDis.addSymptom(LR.hyperactivity, "", 0.5f);
bulimiaNervosaDis.addSymptom(LR.bodyImageDistorted, "", 0.5f);
Treatment bulimiaNervosaTr1 = new Treatment("bulimiaNervosaTr1");
bulimiaNervosaTr1.addTreatmentAction(LR.behaviorTherapy);
bulimiaNervosaTr1.addDrug(LR.antidepressants);
bulimiaNervosaDis.addTreatment("bulimiaNervosaTr1");


// ------------- depression  -------------
Disease depressionDis = new Disease(
    LR.depression,
    L.depressionDescription,
    LR.psychiatricDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    10, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mindSysSt,
    LR.none
);
depressionDis.setPrintName(L.depressionPrintName);
depressionDis.addInternalCause(LR.multipleSclerosis);
depressionDis.addInternalCause(LR.nephroticSyndrome);
depressionDis.addInternalCause(LR.pancreasCancer);
depressionDis.addInternalCause(LR.posttraumaticStressDisorder);
depressionDis.addReference("pp 446-50");
depressionDis.addSymptom(LR.agitation, L.depression_agitation, 0.2f);
depressionDis.addSymptom(LR.angry, "", 0.4f);
depressionDis.addSymptom(LR.anxiety, "", 0.4f);
depressionDis.addSymptom(LR.apathy, L.depression_apathy, 0.5f);
depressionDis.addSymptom(LR.appetiteIncrease, L.depression_appetiteIncrease, 0.2f);
depressionDis.addSymptom(LR.appetiteLoss, L.depression_appetiteLoss, 0.2f);
depressionDis.addSymptom(LR.concentrationLoss, "", 0.4f);
depressionDis.addSymptom(LR.dailyActivityUninteresting);
depressionDis.addSymptom(LR.constipation, L.depression_constipation, 0.2f);
depressionDis.addSymptom(LR.diarrhea, L.depression_diarrhea, 0.2f);
depressionDis.addSymptom(LR.indecisive, "", 0.4f);
depressionDis.addSymptom(LR.moodSad);
depressionDis.addSymptom(LR.selfDoubt, "", 0.5f);
depressionDis.addSymptom(LR.sexualDesireAbsent, "", 0.4f);
depressionDis.addSymptom(LR.sleepDisturbed, "", 0.4f);
depressionDis.addSymptom(LR.unhappy, "", 0.5f);
Treatment depressionTr1 = new Treatment("depressionTr1");
depressionTr1.addTreatmentAction(LR.psychologicalCounseling);
depressionTr1.addTreatmentAction(LR.electroconvulsiveTherapy);
depressionTr1.addDrug(LR.antidepressants);
depressionDis.addTreatment("depressionTr1");


// ------------- generalizedAnxiety  -------------
Disease generalizedAnxietyDis = new Disease(
    LR.generalizedAnxiety,
    L.generalizedAnxietyDescription,
    LR.psychiatricDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mindSysSt,
    LR.none
);
generalizedAnxietyDis.setPrintName(L.generalizedAnxietyPrintName);
generalizedAnxietyDis.setMiscComments(L.generalizedAnxietyComment);
generalizedAnxietyDis.addReference("pp 452-4");
generalizedAnxietyDis.addSymptom(LR.angry, L.generalizedAnxiety_angry, 0.2f);
generalizedAnxietyDis.addSymptom(LR.anxiety);
generalizedAnxietyDis.addSymptom(LR.fearful, L.generalizedAnxiety_fearful, 0.2f);
generalizedAnxietyDis.addSymptom(LR.myalgia, "", 0.3f);
generalizedAnxietyDis.addSymptom(LR.trembling, "", 0.3f);
generalizedAnxietyDis.addSymptom(LR.abdomenPain, "", 0.5f);
generalizedAnxietyDis.addSymptom(LR.apprehension, "", 0.3f);
generalizedAnxietyDis.addSymptom(LR.dyspnea, "", 0.5f);
generalizedAnxietyDis.addSymptom(LR.headache, "", 0.3f);
generalizedAnxietyDis.addSymptom(LR.spasm);
generalizedAnxietyDis.addSymptom(LR.sweating, "", 0.5f);
generalizedAnxietyDis.addSymptom(LR.tachycardia, "", 0.5f);
generalizedAnxietyDis.addSymptom(LR.selfAwarenessHigh);
generalizedAnxietyDis.addSymptom(LR.alertnessHigh);
Treatment generalizedAnxietyTr1 = new Treatment("generalizedAnxietyTr1");
generalizedAnxietyTr1.addTreatmentAction(LR.psychologicalCounseling);
generalizedAnxietyTr1.addDrug(LR.antidepressants);
generalizedAnxietyTr1.addDrug(LR.benzodiazepines);
generalizedAnxietyTr1.addDrug(LR.buspirone);
generalizedAnxietyDis.addTreatment("generalizedAnxietyTr1");


// ------------- generalizedAnxietyMild  -------------
Disease generalizedAnxietyMildDis = new Disease(
    LR.generalizedAnxietyMild,
    L.generalizedAnxietyMildDescription,
    LR.psychiatricDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mindSysSt,
    LR.none
);
generalizedAnxietyMildDis.setPrintName(L.generalizedAnxietyMildPrintName);
generalizedAnxietyMildDis.setSuperDisease(LR.generalizedAnxiety);
generalizedAnxietyMildDis.setMiscComments(L.generalizedAnxietyMildComment);
generalizedAnxietyMildDis.addCausesDisease(LR.generalizedAnxietyModerate);
generalizedAnxietyMildDis.addCausesDisease(LR.generalizedAnxietySevere);
generalizedAnxietyMildDis.addReference("pp 452-4");


// ------------- generalizedAnxietyModerate  -------------
Disease generalizedAnxietyModerateDis = new Disease(
    LR.generalizedAnxietyModerate,
    L.generalizedAnxietyModerateDescription,
    LR.psychiatricDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mindSysSt,
    LR.none
);
generalizedAnxietyModerateDis.setPrintName(L.generalizedAnxietyModeratePrintName);
generalizedAnxietyModerateDis.setSuperDisease(LR.generalizedAnxiety);
generalizedAnxietyModerateDis.setMiscComments(L.generalizedAnxietyModerateComment);
generalizedAnxietyModerateDis.addInternalCause(LR.generalizedAnxietyMild);
generalizedAnxietyModerateDis.addCausesDisease(LR.generalizedAnxietySevere);
generalizedAnxietyModerateDis.addReference("pp 452-4");
generalizedAnxietyModerateDis.addSymptom(LR.inattention);


// ------------- generalizedAnxietySevere  -------------
Disease generalizedAnxietySevereDis = new Disease(
    LR.generalizedAnxietySevere,
    L.generalizedAnxietySevereDescription,
    LR.psychiatricDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mindSysSt,
    LR.none
);
generalizedAnxietySevereDis.setPrintName(L.generalizedAnxietySeverePrintName);
generalizedAnxietySevereDis.setSuperDisease(LR.generalizedAnxiety);
generalizedAnxietySevereDis.setMiscComments(L.generalizedAnxietySevereComment);
generalizedAnxietySevereDis.addInternalCause(LR.generalizedAnxietyMild);
generalizedAnxietySevereDis.addInternalCause(LR.generalizedAnxietyModerate);
generalizedAnxietySevereDis.addReference("pp 452-4");
generalizedAnxietySevereDis.addSymptom(LR.concentrationLoss);
generalizedAnxietySevereDis.addSymptom(LR.speechUnintelligible);


// ------------- obsessiveCompulsiveDisorder  -------------
Disease obsessiveCompulsiveDisorderDis = new Disease(
    LR.obsessiveCompulsiveDisorder,
    L.obsessiveCompulsiveDisorderDescription,
    LR.psychiatricDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mindSysSt,
    LR.none
);
obsessiveCompulsiveDisorderDis.setPrintName(L.obsessiveCompulsiveDisorderPrintName);
obsessiveCompulsiveDisorderDis.addReference("pp 456-9");
obsessiveCompulsiveDisorderDis.addSymptom(LR.anxiety);
obsessiveCompulsiveDisorderDis.addSymptom(LR.obsessiveThoughts);
obsessiveCompulsiveDisorderDis.addSymptom(LR.compulsiveActions);
Treatment obsessiveCompulsiveDisorderTr1 = new Treatment("obsessiveCompulsiveDisorderTr1");
obsessiveCompulsiveDisorderTr1.addTreatmentAction(LR.behaviorTherapy);
obsessiveCompulsiveDisorderTr1.addDrug(LR.antidepressants);
obsessiveCompulsiveDisorderDis.addTreatment("obsessiveCompulsiveDisorderTr1");


// ------------- panicDisorder  -------------
Disease panicDisorderDis = new Disease(
    LR.panicDisorder,
    L.panicDisorderDescription,
    LR.psychiatricDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mindSysSt,
    LR.none
);
panicDisorderDis.setPrintName(L.panicDisorderPrintName);
panicDisorderDis.addReference("pp 454-6");
panicDisorderDis.addSymptom(LR.anxiety, L.panicDisorder_anxiety, 1.0f);
panicDisorderDis.addSymptom(LR.apprehension, L.panicDisorder_apprehension, 1.0f);
panicDisorderDis.addSymptom(LR.diaphoresis, L.panicDisorder_diaphoresis, 0.5f);
panicDisorderDis.addSymptom(LR.fearful, L.panicDisorder_fearful, 1.0f);
panicDisorderDis.addSymptom(LR.hyperventilation, L.panicDisorder_hyperventilation, 0.5f);
panicDisorderDis.addSymptom(LR.tachycardia, L.panicDisorder_tachycardia, 0.5f);
panicDisorderDis.addSymptom(LR.breathingDifficult, L.panicDisorder_breathingDifficult, 0.2f);
panicDisorderDis.addSymptom(LR.chestPain, L.panicDisorder_chestPain, 0.2f);
panicDisorderDis.addSymptom(LR.trembling, L.panicDisorder_trembling, 0.5f);
panicDisorderDis.addSymptom(LR.shaking, L.panicDisorder_shaking, 0.5f);
panicDisorderDis.addSymptom(LR.palpitations, L.panicDisorder_palpitations, 0.5f);
panicDisorderDis.addSymptom(LR.chokingFeeling, L.panicDisorder_chokingFeeling, 0.2f);
Treatment panicDisorderTr1 = new Treatment("panicDisorderTr1");
panicDisorderTr1.addTreatmentAction(LR.behaviorTherapy);
panicDisorderTr1.addDrug(LR.antianxietyDrug);
panicDisorderTr1.addDrug(LR.antidepressants);
panicDisorderTr1.addDrug(LR.betaBlocker);
panicDisorderDis.addTreatment("panicDisorderTr1");


// ------------- phobia  -------------
Disease phobiaDis = new Disease(
    LR.phobia,
    L.phobiaDescription,
    LR.psychiatricDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mindSysSt,
    LR.none
);
phobiaDis.setPrintName(L.phobiaPrintName);
phobiaDis.addReference("pp 450-2");
phobiaDis.addSymptom(LR.anxiety);
phobiaDis.addSymptom(LR.palpitations, "", 0.3f);
phobiaDis.addSymptom(LR.sweating, "", 0.3f);
Treatment phobiaTr1 = new Treatment("phobiaTr1");
phobiaTr1.addTreatmentAction(LR.behaviorTherapy);
phobiaDis.addTreatment("phobiaTr1");


// ------------- agoraphobia  -------------
Disease agoraphobiaDis = new Disease(
    LR.agoraphobia,
    L.agoraphobiaDescription,
    LR.psychiatricDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mindSysSt,
    LR.none
);
agoraphobiaDis.setPrintName(L.agoraphobiaPrintName);
agoraphobiaDis.setSuperDisease(LR.phobia);
agoraphobiaDis.addReference("pp 450-2");
agoraphobiaDis.addSymptom(LR.dizziness, "", 0.3f);
agoraphobiaDis.addSymptom(LR.fallingSensation, "", 0.3f);
agoraphobiaDis.addSymptom(LR.unrealityFeeling, "", 0.3f);
agoraphobiaDis.addSymptom(LR.vomiting, "", 0.3f);
Treatment agoraphobiaTr1 = new Treatment("agoraphobiaTr1");
agoraphobiaTr1.addDrug(LR.antidepressants);
agoraphobiaTr1.addDrug(LR.antianxietyDrug);
agoraphobiaDis.addTreatment("agoraphobiaTr1");


// ------------- socialPhobia  -------------
Disease socialPhobiaDis = new Disease(
    LR.socialPhobia,
    L.socialPhobiaDescription,
    LR.psychiatricDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    10, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mindSysSt,
    LR.none
);
socialPhobiaDis.setPrintName(L.socialPhobiaPrintName);
socialPhobiaDis.setSuperDisease(LR.phobia);
socialPhobiaDis.addReference("pp 450-2");
socialPhobiaDis.addSymptom(LR.socialPerformanceFear);


// ------------- objectPhobia  -------------
Disease objectPhobiaDis = new Disease(
    LR.objectPhobia,
    L.objectPhobiaDescription,
    LR.psychiatricDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    10, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mindSysSt,
    LR.none
);
objectPhobiaDis.setPrintName(L.objectPhobiaPrintName);
objectPhobiaDis.setSuperDisease(LR.phobia);
objectPhobiaDis.addReference("pp 450-2");
objectPhobiaDis.addSymptom(LR.nausea, "", 0.3f);


// ------------- posttraumaticStressDisorder  -------------
Disease posttraumaticStressDisorderDis = new Disease(
    LR.posttraumaticStressDisorder,
    L.posttraumaticStressDisorderDescription,
    LR.psychiatricDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mindSysSt,
    LR.none
);
posttraumaticStressDisorderDis.setPrintName(L.posttraumaticStressDisorderPrintName);
posttraumaticStressDisorderDis.setWebResource("http://www.postgradmed.com/issues/2001/11_01/khouzam.htm");
posttraumaticStressDisorderDis.addCausesDisease(LR.depression);
posttraumaticStressDisorderDis.addReference("pp 459-61");
posttraumaticStressDisorderDis.addSymptom(LR.anxiety);
posttraumaticStressDisorderDis.addSymptom(LR.panicAttacks);
posttraumaticStressDisorderDis.addSymptom(LR.sleepDisturbed);
posttraumaticStressDisorderDis.addSymptom(LR.thoughtsDisturbing);
posttraumaticStressDisorderDis.addSymptom(LR.emotionPangs);
posttraumaticStressDisorderDis.addSymptom(LR.flashbacks);
posttraumaticStressDisorderDis.addSymptom(LR.fitOfAnger);
posttraumaticStressDisorderDis.addSymptom(LR.nightmares);
posttraumaticStressDisorderDis.addSymptom(LR.concentrationLoss);
Treatment posttraumaticStressDisorderTr1 = new Treatment("posttraumaticStressDisorderTr1");
posttraumaticStressDisorderTr1.addTreatmentAction(LR.behaviorTherapy);
posttraumaticStressDisorderTr1.addTreatmentAction(LR.psychoanalyticTherapy);
posttraumaticStressDisorderTr1.addTreatmentAction(LR.psychologicalCounseling);
posttraumaticStressDisorderTr1.addDrug(LR.antianxietyDrug);
posttraumaticStressDisorderTr1.addDrug(LR.antidepressants);
posttraumaticStressDisorderDis.addTreatment("posttraumaticStressDisorderTr1");


// ------------- schizophrenia  -------------
Disease schizophreniaDis = new Disease(
    LR.schizophrenia,
    L.schizophreniaDescription,
    LR.psychiatricDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mindSysSt,
    LR.none
);
schizophreniaDis.setPrintName(L.schizophreniaPrintName);
schizophreniaDis.setWebResource("http://www.mentalhealth.com/dis/p20-ps01.html");
schizophreniaDis.setCode358(180);
schizophreniaDis.setICD10code("F20");
schizophreniaDis.addReference("pp 431-7");
schizophreniaDis.addSymptom(LR.apathy);
Treatment schizophreniaTr1 = new Treatment("schizophreniaTr1");
schizophreniaTr1.addTreatmentAction(LR.psychotherapy);
schizophreniaTr1.addDrug(LR.antipsychoticDrugs);
schizophreniaDis.addTreatment("schizophreniaTr1");


// ------------- schizophreniaProdromal  -------------
Disease schizophreniaProdromalDis = new Disease(
    LR.schizophreniaProdromal,
    L.schizophreniaProdromalDescription,
    LR.psychiatricDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mindSysSt,
    LR.none
);
schizophreniaProdromalDis.setPrintName(L.schizophreniaProdromalPrintName);
schizophreniaProdromalDis.setSuperDisease(LR.schizophrenia);
schizophreniaProdromalDis.setCode358(180);
schizophreniaProdromalDis.setICD10code("F20");
schizophreniaProdromalDis.addCausesDisease(LR.schizophreniaActive);
schizophreniaProdromalDis.addReference("pp 431-7");
schizophreniaProdromalDis.addSymptom(LR.anxiety, "", 0.6f);
schizophreniaProdromalDis.addSymptom(LR.concentrationLoss);
schizophreniaProdromalDis.addSymptom(LR.energyLoss, "", 0.9f);
schizophreniaProdromalDis.addSymptom(LR.irritability, "", 0.5f);
schizophreniaProdromalDis.addSymptom(LR.mentalDepression, "", 0.8f);
schizophreniaProdromalDis.addSymptom(LR.motivationLoss, "", 0.9f);
schizophreniaProdromalDis.addSymptom(LR.roleFunctioningDetoriation, "", 0.5f);
schizophreniaProdromalDis.addSymptom(LR.sleepDisturbed, "", 0.7f);
schizophreniaProdromalDis.addSymptom(LR.socialWithdrawal, "", 0.6f);
schizophreniaProdromalDis.addSymptom(LR.speechUnintelligible, "", 0.4f);
schizophreniaProdromalDis.addSymptom(LR.speechUnusual, "", 0.4f);
schizophreniaProdromalDis.addSymptom(LR.suspiciousness, "", 0.5f);


// ------------- schizophreniaActive  -------------
Disease schizophreniaActiveDis = new Disease(
    LR.schizophreniaActive,
    L.schizophreniaActiveDescription,
    LR.psychiatricDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mindSysSt,
    LR.none
);
schizophreniaActiveDis.setPrintName(L.schizophreniaActivePrintName);
schizophreniaActiveDis.setSuperDisease(LR.schizophrenia);
schizophreniaActiveDis.setCode358(180);
schizophreniaActiveDis.setICD10code("F20");
schizophreniaActiveDis.addInternalCause(LR.schizophreniaProdromal);
schizophreniaActiveDis.addCausesDisease(LR.schizophreniaResidual);
schizophreniaActiveDis.addReference("pp 431-7");
schizophreniaActiveDis.addSymptom(LR.behaviorDisorganized);
schizophreniaActiveDis.addSymptom(LR.catatonic);
schizophreniaActiveDis.addSymptom(LR.delusions);
schizophreniaActiveDis.addSymptom(LR.hallucinations);
schizophreniaActiveDis.addSymptom(LR.incoherence);
schizophreniaActiveDis.addSymptom(LR.speechUnintelligible, "", 0.8f);
schizophreniaActiveDis.addSymptom(LR.speechUnusual, "", 0.8f);


// ------------- schizophreniaResidual  -------------
Disease schizophreniaResidualDis = new Disease(
    LR.schizophreniaResidual,
    L.schizophreniaResidualDescription,
    LR.psychiatricDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.mindSysSt,
    LR.none
);
schizophreniaResidualDis.setPrintName(L.schizophreniaResidualPrintName);
schizophreniaResidualDis.setSuperDisease(LR.schizophrenia);
schizophreniaResidualDis.setCode358(180);
schizophreniaResidualDis.setICD10code("F20");
schizophreniaResidualDis.addInternalCause(LR.schizophreniaActive);
schizophreniaResidualDis.addReference("pp 431-7");
schizophreniaResidualDis.addSymptom(LR.anxiety, "", 0.6f);
schizophreniaResidualDis.addSymptom(LR.concentrationLoss);
schizophreniaResidualDis.addSymptom(LR.energyLoss, "", 0.9f);
schizophreniaResidualDis.addSymptom(LR.irritability, "", 0.5f);
schizophreniaResidualDis.addSymptom(LR.mentalDepression, "", 0.8f);
schizophreniaResidualDis.addSymptom(LR.motivationLoss, "", 0.9f);
schizophreniaResidualDis.addSymptom(LR.roleFunctioningDetoriation, "", 0.5f);
schizophreniaResidualDis.addSymptom(LR.sleepDisturbed, "", 0.7f);
schizophreniaResidualDis.addSymptom(LR.socialWithdrawal, "", 0.6f);
schizophreniaResidualDis.addSymptom(LR.speechUnintelligible, "", 0.4f);
schizophreniaResidualDis.addSymptom(LR.speechUnusual, "", 0.4f);
schizophreniaResidualDis.addSymptom(LR.suspiciousness, "", 0.5f);
schizophreniaResidualDis.addSymptom(LR.delusions, "", 0.3f);
schizophreniaResidualDis.addSymptom(LR.hallucinations, "", 0.3f);
} // end of psychiatricDisorders





// ------------- renalDisorders  -------------
static public void renalDisorders() { 


// ------------- pyelonephritis  -------------
Disease pyelonephritisDis = new Disease(
    LR.pyelonephritis,
    L.pyelonephritisDescription,
    LR.renalDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    10, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.renalSysSt,
    LR.none
);
pyelonephritisDis.setPrintName(L.pyelonephritisPrintName);
pyelonephritisDis.addReference("pp 766-768");
pyelonephritisDis.addSymptom(LR.flankPain);
Treatment pyelonephritisTr1 = new Treatment("pyelonephritisTr1");
pyelonephritisTr1.addDrug(LR.antibiotics);
pyelonephritisDis.addTreatment("pyelonephritisTr1");


// ------------- pyelonephritisAcute  -------------
Disease pyelonephritisAcuteDis = new Disease(
    LR.pyelonephritisAcute,
    L.pyelonephritisAcuteDescription,
    LR.renalDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    10, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.renalSysSt,
    LR.none
);
pyelonephritisAcuteDis.setPrintName(L.pyelonephritisAcutePrintName);
pyelonephritisAcuteDis.setSuperDisease(LR.pyelonephritis);
pyelonephritisAcuteDis.addReference("pp 766-768");
pyelonephritisAcuteDis.addSymptom(LR.dysuria);
pyelonephritisAcuteDis.addSymptom(LR.hematuria);
pyelonephritisAcuteDis.addSymptom(LR.nocturia);
pyelonephritisAcuteDis.addSymptom(LR.urineCloudy);
pyelonephritisAcuteDis.addSymptom(LR.urinaryBurning);
pyelonephritisAcuteDis.addSymptom(LR.urinaryFrequency);
pyelonephritisAcuteDis.addSymptom(LR.urinaryUrgency);
pyelonephritisAcuteDis.addSymptom(LR.anorexia);
pyelonephritisAcuteDis.addSymptom(LR.chills);
pyelonephritisAcuteDis.addSymptom(LR.fatigue);
pyelonephritisAcuteDis.addSymptom(LR.shaking);


// ------------- pyelonephritisChronic  -------------
Disease pyelonephritisChronicDis = new Disease(
    LR.pyelonephritisChronic,
    L.pyelonephritisChronicDescription,
    LR.renalDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.renalSysSt,
    LR.none
);
pyelonephritisChronicDis.setPrintName(L.pyelonephritisChronicPrintName);
pyelonephritisChronicDis.setSuperDisease(LR.pyelonephritis);
pyelonephritisChronicDis.addInternalCause(LR.pyelonephritisAcute);
pyelonephritisChronicDis.addCausesDisease(LR.anemia);
pyelonephritisChronicDis.addCausesDisease(LR.hypertension);
pyelonephritisChronicDis.addCausesAbnormalCondition(LR.proteinuria);
pyelonephritisChronicDis.addCausesAbnormalCondition(LR.bacteriuria);
pyelonephritisChronicDis.addReference("pp 766-768");
pyelonephritisChronicDis.addSymptom(LR.anorexia);
pyelonephritisChronicDis.addSymptom(LR.feverSym);
pyelonephritisChronicDis.addSymptom(LR.hematuria);
pyelonephritisChronicDis.addSymptom(LR.malaise);
pyelonephritisChronicDis.addSymptom(LR.weightLoss);


// ------------- renalCalculi  -------------
Disease renalCalculiDis = new Disease(
    LR.renalCalculi,
    L.renalCalculiDescription,
    LR.renalDisorders,
    LR.moreMale, // genderSpecificity
    LR.caucasian, // raceSpecificity
    30, // minAge
    50, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.renalSysSt,
    LR.none
);
renalCalculiDis.setPrintName(L.renalCalculiPrintName);
renalCalculiDis.addInternalCause(LR.berylliosisChronic);
renalCalculiDis.addInternalCause(LR.gout);
renalCalculiDis.addReference("pp 773-6");
renalCalculiDis.addSymptom(LR.abdomenPain, "", 0.6f);
renalCalculiDis.addSymptom(LR.backPain, "", 0.6f);
renalCalculiDis.addSymptom(LR.flankPain);
renalCalculiDis.addSymptom(LR.nausea, "", 0.8f);
renalCalculiDis.addSymptom(LR.vomiting, "", 0.8f);
renalCalculiDis.addSymptom(LR.abdomenDistension, "", 0.3f);
renalCalculiDis.addSymptom(LR.anuria, "", 0.03f);
renalCalculiDis.addSymptom(LR.chills, "", 0.3f);
renalCalculiDis.addSymptom(LR.hematuria, "", 0.3f);
renalCalculiDis.addSymptom(LR.pyuria, "", 0.3f);
Treatment renalCalculiTr1 = new Treatment("renalCalculiTr1", LR.ifSevere);
renalCalculiTr1.addTreatmentAction(LR.surgery);
renalCalculiDis.addTreatment("renalCalculiTr1");
Treatment renalCalculiTr2 = new Treatment("renalCalculiTr2");
renalCalculiTr2.addTreatmentAction(LR.hydration);
renalCalculiTr2.addDrug(LR.analgetics);
renalCalculiTr2.addDrug(LR.antimicrobials);
renalCalculiTr2.addDrug(LR.diuretics);
renalCalculiDis.addTreatment("renalCalculiTr2");


// ------------- renalFailureAcute  -------------
Disease renalFailureAcuteDis = new Disease(
    LR.renalFailureAcute,
    L.renalFailureAcuteDescription,
    LR.renalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.renalSysSt,
    LR.renalObstruction
);
renalFailureAcuteDis.setPrintName(L.renalFailureAcutePrintName);
renalFailureAcuteDis.setTemperature(101.0f);
renalFailureAcuteDis.setCode358(327);
renalFailureAcuteDis.setICD10code("N17");
renalFailureAcuteDis.addInternalCause(LR.schistosomiasis);
renalFailureAcuteDis.addInternalCause(LR.hypertension);
renalFailureAcuteDis.addCausingAbnormalCondition(LR.azotemia);
renalFailureAcuteDis.addCausesDisease(LR.heartFailure);
renalFailureAcuteDis.addCausesDisease(LR.stomatitis);
renalFailureAcuteDis.addCausesAbnormalCondition(LR.acidosis);
renalFailureAcuteDis.addCausesAbnormalCondition(LR.electrolyteImbalance);
renalFailureAcuteDis.addCausesAbnormalCondition(LR.neuropathy);
renalFailureAcuteDis.addReference("pp 764-6");
renalFailureAcuteDis.addSymptom(LR.anorexia);
renalFailureAcuteDis.addSymptom(LR.coma);
renalFailureAcuteDis.addSymptom(LR.confusion);
renalFailureAcuteDis.addSymptom(LR.constipation, "", 0.4f);
renalFailureAcuteDis.addSymptom(LR.diarrhea, "", 0.4f);
renalFailureAcuteDis.addSymptom(LR.drowsiness);
renalFailureAcuteDis.addSymptom(LR.edema);
renalFailureAcuteDis.addSymptom(LR.headache);
renalFailureAcuteDis.addSymptom(LR.irritability);
renalFailureAcuteDis.addSymptom(LR.nausea);
renalFailureAcuteDis.addSymptom(LR.pallor);
renalFailureAcuteDis.addSymptom(LR.seizure);
renalFailureAcuteDis.addSymptom(LR.vomiting);
renalFailureAcuteDis.addSymptom(LR.anuria, "", 0.02f);
renalFailureAcuteDis.addSymptom(LR.oliguria);
renalFailureAcuteDis.addSymptom(LR.uremicBreath);
renalFailureAcuteDis.addSymptom(LR.pruritus);
Treatment renalFailureAcuteTr1 = new Treatment("renalFailureAcuteTr1");
renalFailureAcuteTr1.addTreatmentAction(LR.fluidManagement);
renalFailureAcuteTr1.addTreatmentAction(LR.dietHighCalorie);
renalFailureAcuteTr1.addTreatmentAction(LR.dietLowProtein);
renalFailureAcuteTr1.addTreatmentAction(LR.hemodialysis);
renalFailureAcuteTr1.addTreatmentAction(LR.peritonealDialysis);
renalFailureAcuteDis.addTreatment("renalFailureAcuteTr1");


// ------------- renalInfarction  -------------
Disease renalInfarctionDis = new Disease(
    LR.renalInfarction,
    L.renalInfarctionDescription,
    LR.renalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.renalSysSt,
    LR.none
);
renalInfarctionDis.setPrintName(L.renalInfarctionPrintName);
renalInfarctionDis.setTemperature(102.0f);
renalInfarctionDis.addInternalCause(LR.adrenalCrisis);
renalInfarctionDis.addInternalCause(LR.legionaire);
renalInfarctionDis.addReference("pp 771-3");
renalInfarctionDis.addSymptom(LR.abdomenPainUpperSide);
renalInfarctionDis.addSymptom(LR.anorexia);
renalInfarctionDis.addSymptom(LR.flankPain);
renalInfarctionDis.addSymptom(LR.nausea);
renalInfarctionDis.addSymptom(LR.vomiting);
Treatment renalInfarctionTr1 = new Treatment("renalInfarctionTr1");
renalInfarctionTr1.addTreatmentAction(LR.surgery);
renalInfarctionTr1.addDrug(LR.antihypertensives);
renalInfarctionTr1.addDrug(LR.heparin);
renalInfarctionTr1.addDrug(LR.streptokinase);
renalInfarctionDis.addTreatment("renalInfarctionTr1");


// ------------- renalVeinThrombosis  -------------
Disease renalVeinThrombosisDis = new Disease(
    LR.renalVeinThrombosis,
    L.renalVeinThrombosisDescription,
    LR.renalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.renalSysSt,
    LR.none
);
renalVeinThrombosisDis.setPrintName(L.renalVeinThrombosisPrintName);
renalVeinThrombosisDis.setTemperature(102.0f);
renalVeinThrombosisDis.addCausesAbnormalCondition(LR.leukocytosis);
renalVeinThrombosisDis.addCausesAbnormalCondition(LR.proteinuria);
renalVeinThrombosisDis.addReference("pp 776-7");
renalVeinThrombosisDis.addSymptom(LR.edema);
renalVeinThrombosisDis.addSymptom(LR.epigastricPain);
renalVeinThrombosisDis.addSymptom(LR.flankPain);
renalVeinThrombosisDis.addSymptom(LR.hematuria);
renalVeinThrombosisDis.addSymptom(LR.lumbarPain);
renalVeinThrombosisDis.addSymptom(LR.oliguria);
renalVeinThrombosisDis.addSymptom(LR.pallor);
Treatment renalVeinThrombosisTr1 = new Treatment("renalVeinThrombosisTr1");
renalVeinThrombosisTr1.addTreatmentAction(LR.dialysis);
renalVeinThrombosisTr1.addTreatmentAction(LR.surgery);
renalVeinThrombosisTr1.addTreatmentAction(LR.kidneyTransplantation);
renalVeinThrombosisTr1.addDrug(LR.anticoagulants);
renalVeinThrombosisDis.addTreatment("renalVeinThrombosisTr1");


// ------------- tubularNecrosisAcute  -------------
Disease tubularNecrosisAcuteDis = new Disease(
    LR.tubularNecrosisAcute,
    L.tubularNecrosisAcuteDescription,
    LR.renalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.renalSysSt,
    LR.none
);
tubularNecrosisAcuteDis.setPrintName(L.tubularNecrosisAcutePrintName);
tubularNecrosisAcuteDis.setMiscComments(L.tubularNecrosisAcuteComment);
tubularNecrosisAcuteDis.addCausesDisease(LR.heartFailure);
tubularNecrosisAcuteDis.addCausesDisease(LR.pericarditis);
tubularNecrosisAcuteDis.addCausesDisease(LR.anemia);
tubularNecrosisAcuteDis.addCausesDisease(LR.hyperkalemia);
tubularNecrosisAcuteDis.addCausesAbnormalCondition(LR.uremia);
tubularNecrosisAcuteDis.addReference("pp 769-71");
tubularNecrosisAcuteDis.addSymptom(LR.anorexia);
tubularNecrosisAcuteDis.addSymptom(LR.confusion);
tubularNecrosisAcuteDis.addSymptom(LR.consciousnessDecreased);
tubularNecrosisAcuteDis.addSymptom(LR.drowsiness);
tubularNecrosisAcuteDis.addSymptom(LR.edema);
tubularNecrosisAcuteDis.addSymptom(LR.nausea);
tubularNecrosisAcuteDis.addSymptom(LR.oliguria);
tubularNecrosisAcuteDis.addSymptom(LR.vomiting);
Treatment tubularNecrosisAcuteTr1 = new Treatment("tubularNecrosisAcuteTr1");
tubularNecrosisAcuteTr1.addTreatmentAction(LR.IVFluids);
tubularNecrosisAcuteTr1.addTreatmentAction(LR.dialysis);
tubularNecrosisAcuteTr1.addTreatmentAction(LR.bloodTransfusion);
tubularNecrosisAcuteTr1.addDrug(LR.diuretics);
tubularNecrosisAcuteTr1.addDrug(LR.insulin);
tubularNecrosisAcuteDis.addTreatment("tubularNecrosisAcuteTr1");


// ------------- nephroticSyndrome  -------------
Disease nephroticSyndromeDis = new Disease(
    LR.nephroticSyndrome,
    L.nephroticSyndromeDescription,
    LR.renalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.renalSysSt,
    LR.none
);
nephroticSyndromeDis.setPrintName(L.nephroticSyndromePrintName);
nephroticSyndromeDis.addInternalCause(LR.diabetesMellitusAdvanced);
nephroticSyndromeDis.addCausingAbnormalCondition(LR.proteinuria);
nephroticSyndromeDis.addCausesDisease(LR.depression);
nephroticSyndromeDis.addCausesAbnormalCondition(LR.ascites);
nephroticSyndromeDis.addCausesAbnormalCondition(LR.pleuralEffusion);
nephroticSyndromeDis.addReference("pp 777-9");
nephroticSyndromeDis.addSymptom(LR.edema);
nephroticSyndromeDis.addSymptom(LR.anorexia);
nephroticSyndromeDis.addSymptom(LR.hypotension);
nephroticSyndromeDis.addSymptom(LR.lethargy);
nephroticSyndromeDis.addSymptom(LR.pallor);
Treatment nephroticSyndromeTr1 = new Treatment("nephroticSyndromeTr1");
nephroticSyndromeTr1.addTreatmentAction(LR.sodiumRestriction);
nephroticSyndromeTr1.addTreatmentAction(LR.proteinSupplement);
nephroticSyndromeTr1.addDrug(LR.antibiotics);
nephroticSyndromeTr1.addDrug(LR.diuretics);
nephroticSyndromeDis.addTreatment("nephroticSyndromeTr1");


// ------------- epididymitis  -------------
Disease epididymitisDis = new Disease(
    LR.epididymitis,
    L.epididymitisDescription,
    LR.renalDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.epididymisSysSt,
    LR.staphylococcusInfection
);
epididymitisDis.setPrintName(L.epididymitisPrintName);
epididymitisDis.addExternalCause(LR.streptococcusInfection);
epididymitisDis.setTemperature(103.0f);
epididymitisDis.addInternalCause(LR.chlamydialInfectionEpididymis);
epididymitisDis.addInternalCause(LR.gonorrheaUrethraMale);
epididymitisDis.addInternalCause(LR.syphilis);
epididymitisDis.addReference("pp 803-4");
epididymitisDis.addSymptom(LR.groinPain);
epididymitisDis.addSymptom(LR.groinSwelling);
epididymitisDis.addSymptom(LR.malaise);
epididymitisDis.addSymptom(LR.scrotumSwellingPainful);
Treatment epididymitisTr1 = new Treatment("epididymitisTr1");
epididymitisTr1.addDrug(LR.analgetics);
epididymitisTr1.addDrug(LR.antibiotics);
epididymitisDis.addTreatment("epididymitisTr1");
} // end of renalDisorders





// ------------- respiratoryDisorders  -------------
static public void respiratoryDisorders() { 


// ------------- respiratoryDistressSyndrome  -------------
Disease respiratoryDistressSyndromeDis = new Disease(
    LR.respiratoryDistressSyndrome,
    L.respiratoryDistressSyndromeDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    1, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.none
);
respiratoryDistressSyndromeDis.setPrintName(L.respiratoryDistressSyndromePrintName);
respiratoryDistressSyndromeDis.addReference("pp 493-5");
respiratoryDistressSyndromeDis.addSymptom(LR.edemaPeripheral, "", 0.5f);
respiratoryDistressSyndromeDis.addSymptom(LR.grunting);
respiratoryDistressSyndromeDis.addSymptom(LR.hypotension, "", 0.5f);
respiratoryDistressSyndromeDis.addSymptom(LR.oliguria, "", 0.5f);
respiratoryDistressSyndromeDis.addSymptom(LR.tachypnea);
respiratoryDistressSyndromeDis.addSymptom(LR.respirationShallow);
Treatment respiratoryDistressSyndromeTr1 = new Treatment("respiratoryDistressSyndromeTr1");
respiratoryDistressSyndromeTr1.addTreatmentAction(LR.IVFluids);
respiratoryDistressSyndromeTr1.addTreatmentAction(LR.IVNutrition);
respiratoryDistressSyndromeTr1.addTreatmentAction(LR.mechanicalVentilation);
respiratoryDistressSyndromeDis.addTreatment("respiratoryDistressSyndromeTr1");


// ------------- croup  -------------
Disease croupDis = new Disease(
    LR.croup,
    L.croupDescription,
    LR.respiratoryDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    3, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.tracheaSysSt,
    LR.infection
);
croupDis.setPrintName(L.croupPrintName);
croupDis.addExternalCause(LR.adenoVirusInfection);
croupDis.addExternalCause(LR.diphteriaBacterialInfection);
croupDis.addExternalCause(LR.influenzaVirusInfection);
croupDis.addExternalCause(LR.parainfluenzaVirusInfection);
croupDis.addExternalCause(LR.measlesVirusInfection);
croupDis.addExternalCause(LR.pertussisBacterialInfection);
croupDis.addExternalCause(LR.respiratorySyncytialVirusInfection);
croupDis.addCausesDisease(LR.otitisMedia);
croupDis.addCausesDisease(LR.pneumonia);
croupDis.addReference("pp 496-498");
croupDis.addSymptom(LR.coughBark);
croupDis.addSymptom(LR.stridor, "", 0.7f);
croupDis.addSymptom(LR.hoarseness, "", 0.5f);
croupDis.addSymptom(LR.respirationDistress, "", 0.6f);
croupDis.addSymptom(LR.throatSpasm, "", 0.3f);
Treatment croupTr1 = new Treatment("croupTr1");
croupTr1.addTreatmentAction(LR.ifFeverProvideAntipyretic);
croupTr1.addDrug(LR.ifInfectionProvideAntibiotic);
croupTr1.addDrug(LR.inhaleRacemicEpiphrine);
croupTr1.addDrug(LR.inhaleCorticosteroids);
croupDis.addTreatment("croupTr1");
Treatment croupTr2 = new Treatment("croupTr2", LR.ifDistress);
croupDis.addTreatment("croupTr2");
Treatment croupTr3 = new Treatment("croupTr3", LR.ifModerate);
croupTr3.addTreatmentAction(LR.homeCareAndRest);
croupDis.addTreatment("croupTr3");
Treatment croupTr4 = new Treatment("croupTr4", LR.ifSevere);
croupTr4.addTreatmentAction(LR.hospitalization);
croupTr4.addTreatmentAction(LR.parenteralFluidReplacement);
croupTr4.addTreatmentAction(LR.oxygenTherapy);
croupDis.addTreatment("croupTr4");


// ------------- laryngotracheobronchitis  -------------
Disease laryngotracheobronchitisDis = new Disease(
    LR.laryngotracheobronchitis,
    L.laryngotracheobronchitisDescription,
    LR.respiratoryDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    3, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.tracheaSysSt,
    LR.infection
);
laryngotracheobronchitisDis.setPrintName(L.laryngotracheobronchitisPrintName);
laryngotracheobronchitisDis.setSuperDisease(LR.croup);
laryngotracheobronchitisDis.setMiscComments(L.laryngotracheobronchitisComment);
laryngotracheobronchitisDis.setTemperature(101.0f);
laryngotracheobronchitisDis.addReference("pp 496");
laryngotracheobronchitisDis.addSymptom(LR.crackles);
laryngotracheobronchitisDis.addSymptom(LR.rhonchus);


// ------------- laryngitis  -------------
Disease laryngitisDis = new Disease(
    LR.laryngitis,
    L.laryngitisDescription,
    LR.respiratoryDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.larynxSysSt,
    LR.infection
);
laryngitisDis.setPrintName(L.laryngitisPrintName);
laryngitisDis.setSuperDisease(LR.croup);
laryngitisDis.setCode358(250);
laryngitisDis.setICD10code("J04");
laryngitisDis.addInternalCause(LR.flu);
laryngitisDis.addReference("pp 496");
laryngitisDis.addSymptom(LR.throatSore);
laryngitisDis.addSymptom(LR.cough);


// ------------- epiglottitis  -------------
Disease epiglottitisDis = new Disease(
    LR.epiglottitis,
    L.epiglottitisDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    2, // minAge
    8, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.tracheaSysSt,
    LR.infection
);
epiglottitisDis.setPrintName(L.epiglottitisPrintName);
epiglottitisDis.setMiscComments(L.epiglottitisComment);
epiglottitisDis.addExternalCause(LR.haemophilusInfluenzaBInfection);
epiglottitisDis.addExternalCause(LR.pneumococciInfection);
epiglottitisDis.addExternalCause(LR.streptococcusInfection);
epiglottitisDis.setTemperature(103.0f);
epiglottitisDis.addReference("pp 498-499");
epiglottitisDis.addSymptom(LR.drooling);
epiglottitisDis.addSymptom(LR.dysphagia);
epiglottitisDis.addSymptom(LR.irritability);
epiglottitisDis.addSymptom(LR.restlessness);
epiglottitisDis.addSymptom(LR.rhonchus);
epiglottitisDis.addSymptom(LR.throatSore);
epiglottitisDis.addSymptom(LR.stridor);
Treatment epiglottitisTr1 = new Treatment("epiglottitisTr1", LR.ifAcute);
epiglottitisTr1.addTreatmentAction(LR.hospitalization);
epiglottitisTr1.addTreatmentAction(LR.endotrachealIntubation);
epiglottitisTr1.addTreatmentAction(LR.tracheotomy);
epiglottitisTr1.addDrug(LR.parenteralAntibiotics);
epiglottitisDis.addTreatment("epiglottitisTr1");
Treatment epiglottitisTr2 = new Treatment("epiglottitisTr2", LR.ifSwallowingProblem);
epiglottitisTr2.addTreatmentAction(LR.parenteralFluidAdministration);
epiglottitisDis.addTreatment("epiglottitisTr2");


// ------------- aRFinCOPD  -------------
Disease aRFinCOPDDis = new Disease(
    LR.aRFinCOPD,
    L.aRFinCOPDDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -2, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.respiratorySysSt,
    LR.none
);
aRFinCOPDDis.setPrintName(L.aRFinCOPDPrintName);
aRFinCOPDDis.setUnderlyingDisease(LR.chronicObstructivePulmonaryDisease);
aRFinCOPDDis.addCausesAbnormalCondition(LR.acidosis);
aRFinCOPDDis.addCausesAbnormalCondition(LR.hypoxemia);
aRFinCOPDDis.addReference("pp 499-501");
Treatment aRFinCOPDTr1 = new Treatment("aRFinCOPDTr1");
aRFinCOPDTr1.addDrug(LR.antibiotics);
aRFinCOPDTr1.addDrug(LR.bronchodilator);
aRFinCOPDTr1.addDrug(LR.steroids);
aRFinCOPDDis.addTreatment("aRFinCOPDTr1");
Treatment aRFinCOPDTr2 = new Treatment("aRFinCOPDTr2", LR.ifSignificantRespiratoryAcidosis);
aRFinCOPDTr2.addTreatmentAction(LR.mechanicalVentilation);
aRFinCOPDTr2.addTreatmentAction(LR.endotrachealIntubation);
aRFinCOPDTr2.addTreatmentAction(LR.tracheotomy);
aRFinCOPDTr2.addTreatmentAction(LR.hospitalization);
aRFinCOPDTr2.addTreatmentAction(LR.oxygenTherapy);
aRFinCOPDDis.addTreatment("aRFinCOPDTr2");


// ------------- aRFinCOPDinf  -------------
Disease aRFinCOPDinfDis = new Disease(
    LR.aRFinCOPDinf,
    L.aRFinCOPDinfDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -2, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.respiratorySysSt,
    LR.infection
);
aRFinCOPDinfDis.setPrintName(L.aRFinCOPDinfPrintName);
aRFinCOPDinfDis.setSuperDisease(LR.aRFinCOPD);
aRFinCOPDinfDis.setUnderlyingDisease(LR.chronicObstructivePulmonaryDisease);
aRFinCOPDinfDis.setCode358(278);
aRFinCOPDinfDis.setICD10code("J80");
aRFinCOPDinfDis.addInternalCause(LR.pneumonia);
aRFinCOPDinfDis.addReference("pp 499-501");
aRFinCOPDinfDis.addSymptom(LR.airHunger);
aRFinCOPDinfDis.addSymptom(LR.cyanosis);
aRFinCOPDinfDis.addSymptom(LR.crackles);
aRFinCOPDinfDis.addSymptom(LR.rhonchus);
aRFinCOPDinfDis.addSymptom(LR.wheezing);


// ------------- aRFinCOPDcns  -------------
Disease aRFinCOPDcnsDis = new Disease(
    LR.aRFinCOPDcns,
    L.aRFinCOPDcnsDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -2, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.respiratorySysSt,
    LR.headTrauma
);
aRFinCOPDcnsDis.setPrintName(L.aRFinCOPDcnsPrintName);
aRFinCOPDcnsDis.setSuperDisease(LR.aRFinCOPD);
aRFinCOPDcnsDis.setUnderlyingDisease(LR.chronicObstructivePulmonaryDisease);
aRFinCOPDcnsDis.addExternalCause(LR.narcoticsMisuse);
aRFinCOPDcnsDis.addExternalCause(LR.oxygenMisuse);
aRFinCOPDcnsDis.addExternalCause(LR.sedativeMisuse);
aRFinCOPDcnsDis.addExternalCause(LR.tranquilizerMisuse);
aRFinCOPDcnsDis.setCode358(278);
aRFinCOPDcnsDis.setICD10code("J80");
aRFinCOPDcnsDis.addCausingAbnormalCondition(LR.centralNervousSystemDepression);
aRFinCOPDcnsDis.addReference("pp 499-501");
aRFinCOPDcnsDis.addSymptom(LR.concentrationLoss);
aRFinCOPDcnsDis.addSymptom(LR.confusion);
aRFinCOPDcnsDis.addSymptom(LR.irritability);
aRFinCOPDcnsDis.addSymptom(LR.papilledema);
aRFinCOPDcnsDis.addSymptom(LR.restlessness);
aRFinCOPDcnsDis.addSymptom(LR.tendonReflexDecreased);
aRFinCOPDcnsDis.addSymptom(LR.trembling);


// ------------- aRFinCOPDcardio  -------------
Disease aRFinCOPDcardioDis = new Disease(
    LR.aRFinCOPDcardio,
    L.aRFinCOPDcardioDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -2, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.respiratorySysSt,
    LR.none
);
aRFinCOPDcardioDis.setPrintName(L.aRFinCOPDcardioPrintName);
aRFinCOPDcardioDis.setSuperDisease(LR.aRFinCOPD);
aRFinCOPDcardioDis.setUnderlyingDisease(LR.chronicObstructivePulmonaryDisease);
aRFinCOPDcardioDis.setCode358(278);
aRFinCOPDcardioDis.setICD10code("J80");
aRFinCOPDcardioDis.addInternalCause(LR.heartFailure);
aRFinCOPDcardioDis.addInternalCause(LR.myocardialInfarction);
aRFinCOPDcardioDis.addInternalCause(LR.pulmonaryEmbolism);
aRFinCOPDcardioDis.addCausingAbnormalCondition(LR.myocardialHypoxia);
aRFinCOPDcardioDis.addReference("pp 499-501");
aRFinCOPDcardioDis.addSymptom(LR.arrhythmia);
aRFinCOPDcardioDis.addSymptom(LR.neckVeinsElevated);
aRFinCOPDcardioDis.addSymptom(LR.liverEnlarged);
aRFinCOPDcardioDis.addSymptom(LR.edemaPeripheral);
aRFinCOPDcardioDis.addSymptom(LR.tachycardia);


// ------------- adultRespiratoryDistressSyndrome  -------------
Disease adultRespiratoryDistressSyndromeDis = new Disease(
    LR.adultRespiratoryDistressSyndrome,
    L.adultRespiratoryDistressSyndromeDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.trauma
);
adultRespiratoryDistressSyndromeDis.setPrintName(L.adultRespiratoryDistressSyndromePrintName);
adultRespiratoryDistressSyndromeDis.addExternalCause(LR.aspirationGastricContents);
adultRespiratoryDistressSyndromeDis.addExternalCause(LR.oxygenToxicity);
adultRespiratoryDistressSyndromeDis.addExternalCause(LR.drugOverdose);
adultRespiratoryDistressSyndromeDis.addExternalCause(LR.bloodTransfusion);
adultRespiratoryDistressSyndromeDis.addExternalCause(LR.smokeInhalation);
adultRespiratoryDistressSyndromeDis.addExternalCause(LR.chemicalInhalation);
adultRespiratoryDistressSyndromeDis.addExternalCause(LR.hydrocarbonIngestion);
adultRespiratoryDistressSyndromeDis.addExternalCause(LR.paraquatIngestion);
adultRespiratoryDistressSyndromeDis.addExternalCause(LR.nearDrowning);
adultRespiratoryDistressSyndromeDis.addInternalCause(LR.pancreatitis);
adultRespiratoryDistressSyndromeDis.addInternalCause(LR.pneumonia);
adultRespiratoryDistressSyndromeDis.addInternalCause(LR.tuberculosis);
adultRespiratoryDistressSyndromeDis.addCausingAbnormalCondition(LR.acidosis);
adultRespiratoryDistressSyndromeDis.addCausingAbnormalCondition(LR.microEmboli);
adultRespiratoryDistressSyndromeDis.addCausingAbnormalCondition(LR.sepsis);
adultRespiratoryDistressSyndromeDis.addCausingAbnormalCondition(LR.shock);
adultRespiratoryDistressSyndromeDis.addCausingAbnormalCondition(LR.uremia);
adultRespiratoryDistressSyndromeDis.addCausesAbnormalCondition(LR.hypoxemia);
adultRespiratoryDistressSyndromeDis.addReference("pp 501-4");
adultRespiratoryDistressSyndromeDis.addSymptom(LR.apprehension);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.crackles);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.dyspnea);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.hypotension);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.motorDysfunction);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.oliguria);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.restlessness);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.rhonchus);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.sluggishness);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.tachycardia);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.tachypnea);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.ventricularFibrillation);
Treatment ARDSTr1 = new Treatment("ARDSTr1");
ARDSTr1.addTreatmentAction(LR.humidifiedOxygen);
adultRespiratoryDistressSyndromeDis.addTreatment("ARDSTr1");
Treatment ARDSTr2 = new Treatment("ARDSTr2", LR.ifSevere);
ARDSTr2.addTreatmentAction(LR.intubation);
ARDSTr2.addTreatmentAction(LR.volumeVentilation);
ARDSTr2.addTreatmentAction(LR.fluidRestriction);
ARDSTr2.addDrug(LR.diuretics);
adultRespiratoryDistressSyndromeDis.addTreatment("ARDSTr2");
Treatment ARDSTr3 = new Treatment("ARDSTr3", LR.ifMechanicalVentilation);
ARDSTr3.addDrug(LR.sedatives);
ARDSTr3.addDrug(LR.narcotics);
ARDSTr3.addDrug(LR.tubocurarine);
ARDSTr3.addDrug(LR.pancuroniumBromide);
adultRespiratoryDistressSyndromeDis.addTreatment("ARDSTr3");
Treatment ARDSTr4 = new Treatment("ARDSTr4", LR.ifSevereAcidosis);
ARDSTr4.addDrug(LR.sodiumBicarbonate);
adultRespiratoryDistressSyndromeDis.addTreatment("ARDSTr4");
Treatment ARDSTr5 = new Treatment("ARDSTr5", LR.ifInfection);
ARDSTr5.addDrug(LR.antimicrobials);
adultRespiratoryDistressSyndromeDis.addTreatment("ARDSTr5");


// ------------- pulmonaryEdema  -------------
Disease pulmonaryEdemaDis = new Disease(
    LR.pulmonaryEdema,
    L.pulmonaryEdemaDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.excessiveIVFluids
);
pulmonaryEdemaDis.setPrintName(L.pulmonaryEdemaPrintName);
pulmonaryEdemaDis.setMiscComments(L.pulmonaryEdemaComment);
pulmonaryEdemaDis.addInternalCause(LR.heartFailureLeftSided);
pulmonaryEdemaDis.addInternalCause(LR.aortaInsufficiency);
pulmonaryEdemaDis.addInternalCause(LR.hypertension);
pulmonaryEdemaDis.addReference("pp 504-5");
pulmonaryEdemaDis.addSymptom(LR.confusion);
pulmonaryEdemaDis.addSymptom(LR.cough);
pulmonaryEdemaDis.addSymptom(LR.cyanosis);
pulmonaryEdemaDis.addSymptom(LR.dyspnea);
pulmonaryEdemaDis.addSymptom(LR.neckVeinsElevated);
pulmonaryEdemaDis.addSymptom(LR.orthopnea);
pulmonaryEdemaDis.addSymptom(LR.skinClammy);
pulmonaryEdemaDis.addSymptom(LR.hemoptysis);
pulmonaryEdemaDis.addSymptom(LR.sputumFrothy);
pulmonaryEdemaDis.addSymptom(LR.tachycardia);
pulmonaryEdemaDis.addSymptom(LR.tachypnea);
Treatment pulmonaryEdemaTr1 = new Treatment("pulmonaryEdemaTr1");
pulmonaryEdemaTr1.addTreatmentAction(LR.oxygenTherapy);
pulmonaryEdemaTr1.addTreatmentAction(LR.mechanicalVentilation);
pulmonaryEdemaDis.addTreatment("pulmonaryEdemaTr1");
Treatment pulmonaryEdemaTr2 = new Treatment("pulmonaryEdemaTr2");
pulmonaryEdemaTr2.addDrug(LR.diuretics);
pulmonaryEdemaDis.addTreatment("pulmonaryEdemaTr2");
Treatment pulmonaryEdemaTr3 = new Treatment("pulmonaryEdemaTr3");
pulmonaryEdemaTr3.addDrug(LR.morphine);
pulmonaryEdemaDis.addTreatment("pulmonaryEdemaTr3");


// ------------- pulmonaryEdemaAcute  -------------
Disease pulmonaryEdemaAcuteDis = new Disease(
    LR.pulmonaryEdemaAcute,
    L.pulmonaryEdemaAcuteDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.excessiveIVFluids
);
pulmonaryEdemaAcuteDis.setPrintName(L.pulmonaryEdemaAcutePrintName);
pulmonaryEdemaAcuteDis.setSuperDisease(LR.pulmonaryEdema);
pulmonaryEdemaAcuteDis.addReference("pp 504-5");
pulmonaryEdemaAcuteDis.addSymptom(LR.crackles);
pulmonaryEdemaAcuteDis.addSymptom(LR.diastolicGallop);
pulmonaryEdemaAcuteDis.addSymptom(LR.skinCold);
Treatment pulmonaryEdemaAcuteTr1 = new Treatment("pulmonaryEdemaAcuteTr1");
pulmonaryEdemaAcuteTr1.addDrug(LR.digitalisGlycosides);
pulmonaryEdemaAcuteTr1.addDrug(LR.antiArrhythemics);
pulmonaryEdemaAcuteTr1.addDrug(LR.vasodilators);
pulmonaryEdemaAcuteDis.addTreatment("pulmonaryEdemaAcuteTr1");


// ------------- pulmonaryEdemaChronic  -------------
Disease pulmonaryEdemaChronicDis = new Disease(
    LR.pulmonaryEdemaChronic,
    L.pulmonaryEdemaChronicDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.excessiveIVFluids
);
pulmonaryEdemaChronicDis.setPrintName(L.pulmonaryEdemaChronicPrintName);
pulmonaryEdemaChronicDis.setSuperDisease(LR.pulmonaryEdema);
pulmonaryEdemaChronicDis.addReference("pp 504-5");
pulmonaryEdemaChronicDis.addSymptom(LR.hypotension);
pulmonaryEdemaChronicDis.addSymptom(LR.respirationLabored);
pulmonaryEdemaChronicDis.addSymptom(LR.tachypnea);
pulmonaryEdemaChronicDis.addSymptom(LR.diaphoresis);
Treatment pulmonaryEdemaChronicTr1 = new Treatment("pulmonaryEdemaChronicTr1");
pulmonaryEdemaChronicTr1.addDrug(LR.furosemide);
pulmonaryEdemaChronicTr1.addDrug(LR.bumetanide);
pulmonaryEdemaChronicDis.addTreatment("pulmonaryEdemaChronicTr1");


// ------------- legionaire  -------------
Disease legionaireDis = new Disease(
    LR.legionaire,
    L.legionaireDescription,
    LR.respiratoryDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -4, // duration
    F.legionaireFreq, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.infection
);
legionaireDis.setPrintName(L.legionairePrintName);
legionaireDis.setMiscComments(L.legionaireComment);
legionaireDis.addExternalCause(LR.legionellaPneumophiliaBacillus);
legionaireDis.setTemperature(105.0f);
legionaireDis.addCausesDisease(LR.heartFailure);
legionaireDis.addCausesDisease(LR.renalInfarction);
legionaireDis.addCausesAbnormalCondition(LR.hypoxia);
legionaireDis.addCausesAbnormalCondition(LR.respiratoryFailure);
legionaireDis.addCausesAbnormalCondition(LR.shock);
legionaireDis.addReference("pp 508-9");
legionaireDis.addSymptom(LR.amnesia);
legionaireDis.addSymptom(LR.anorexia);
legionaireDis.addSymptom(LR.arrhythmia);
legionaireDis.addSymptom(LR.bradycardia);
legionaireDis.addSymptom(LR.chills);
legionaireDis.addSymptom(LR.confusion);
legionaireDis.addSymptom(LR.cough);
legionaireDis.addSymptom(LR.crackles);
legionaireDis.addSymptom(LR.delirium);
legionaireDis.addSymptom(LR.diarrhea);
legionaireDis.addSymptom(LR.disorientation);
legionaireDis.addSymptom(LR.dyspnea);
legionaireDis.addSymptom(LR.headache);
legionaireDis.addSymptom(LR.hypotension);
legionaireDis.addSymptom(LR.malaise);
legionaireDis.addSymptom(LR.myalgia);
legionaireDis.addSymptom(LR.nausea);
legionaireDis.addSymptom(LR.pleuriticChestPain);
legionaireDis.addSymptom(LR.sluggishness);
legionaireDis.addSymptom(LR.hemoptysis);
legionaireDis.addSymptom(LR.sputumGray);
legionaireDis.addSymptom(LR.tachypnea);
legionaireDis.addSymptom(LR.vomiting);
legionaireDis.addSymptom(LR.weakness);
Treatment legionaireTr1 = new Treatment("legionaireTr1");
legionaireTr1.addDrug(LR.antibiotics);
legionaireTr1.addDrug(LR.erythromycin);
legionaireTr1.addDrug(LR.rifampin);
legionaireTr1.addDrug(LR.tetracycline);
legionaireDis.addTreatment("legionaireTr1");
Treatment legionaireTr2 = new Treatment("legionaireTr2");
legionaireTr2.addTreatmentAction(LR.ifFeverProvideAntipyretic);
legionaireTr2.addTreatmentAction(LR.parenteralFluidReplacement);
legionaireTr2.addTreatmentAction(LR.oxygenTherapy);
legionaireDis.addTreatment("legionaireTr2");


// ------------- atelectasis  -------------
Disease atelectasisDis = new Disease(
    LR.atelectasis,
    L.atelectasisDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.trauma
);
atelectasisDis.setPrintName(L.atelectasisPrintName);
atelectasisDis.addExternalCause(LR.oxygenToxicity);
atelectasisDis.addExternalCause(LR.tightChessBandage);
atelectasisDis.addInternalCause(LR.lungCancer);
atelectasisDis.addInternalCause(LR.respiratoryDistressSyndrome);
atelectasisDis.addInternalCause(LR.pulmonaryEdema);
atelectasisDis.addInternalCause(LR.cysticFibrosis);
atelectasisDis.addInternalCause(LR.obesity);
atelectasisDis.addCausingAbnormalCondition(LR.bronchialMucusPlugs);
atelectasisDis.addCausingAbnormalCondition(LR.centralNervousSystemDepression);
atelectasisDis.addCausingAbnormalCondition(LR.ribFracture);
atelectasisDis.addCausesAbnormalCondition(LR.hypoxemia);
atelectasisDis.addReference("pp 510-11");
atelectasisDis.addSymptom(LR.dyspnea);
atelectasisDis.addSymptom(LR.anxiety);
atelectasisDis.addSymptom(LR.cyanosis);
atelectasisDis.addSymptom(LR.diaphoresis);
Treatment atelectasisTr1 = new Treatment("atelectasisTr1", LR.ifObstructingNeoplasm);
atelectasisTr1.addTreatmentAction(LR.surgery);
atelectasisTr1.addTreatmentAction(LR.radiationTherapy);
atelectasisDis.addTreatment("atelectasisTr1");
Treatment atelectasisTr2 = new Treatment("atelectasisTr2");
atelectasisTr2.addTreatmentAction(LR.chestPercussion);
atelectasisTr2.addTreatmentAction(LR.posturalDrainage);
atelectasisTr2.addTreatmentAction(LR.bronchoscopy);
atelectasisTr2.addDrug(LR.mucolytics);
atelectasisDis.addTreatment("atelectasisTr2");


// ------------- respiratoryAcidosis  -------------
Disease respiratoryAcidosisDis = new Disease(
    LR.respiratoryAcidosis,
    L.respiratoryAcidosisDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.respiratorySysSt,
    LR.anestheticsUse
);
respiratoryAcidosisDis.setPrintName(L.respiratoryAcidosisPrintName);
respiratoryAcidosisDis.setMiscComments(L.respiratoryAcidosisComment);
respiratoryAcidosisDis.addExternalCause(LR.hypnoticsUse);
respiratoryAcidosisDis.addExternalCause(LR.narcoticsMisuse);
respiratoryAcidosisDis.addExternalCause(LR.sedativesUse);
respiratoryAcidosisDis.addInternalCause(LR.adultRespiratoryDistressSyndrome);
respiratoryAcidosisDis.addInternalCause(LR.asthma);
respiratoryAcidosisDis.addInternalCause(LR.chronicBronchitis);
respiratoryAcidosisDis.addInternalCause(LR.chronicObstructivePulmonaryDisease);
respiratoryAcidosisDis.addInternalCause(LR.guillainBarreSyndrome);
respiratoryAcidosisDis.addInternalCause(LR.pneumonia);
respiratoryAcidosisDis.addInternalCause(LR.myastheniaGravis);
respiratoryAcidosisDis.addInternalCause(LR.poliomyelitis);
respiratoryAcidosisDis.addInternalCause(LR.pulmonaryEdema);
respiratoryAcidosisDis.addCausingAbnormalCondition(LR.airwayObstruction);
respiratoryAcidosisDis.addCausingAbnormalCondition(LR.centralNervousSystemDepression);
respiratoryAcidosisDis.addReference("pp 511-3");
respiratoryAcidosisDis.addSymptom(LR.arrhythmia);
respiratoryAcidosisDis.addSymptom(LR.asterixis);
respiratoryAcidosisDis.addSymptom(LR.apprehension);
respiratoryAcidosisDis.addSymptom(LR.coma);
respiratoryAcidosisDis.addSymptom(LR.confusion);
respiratoryAcidosisDis.addSymptom(LR.dyspnea);
respiratoryAcidosisDis.addSymptom(LR.headache);
respiratoryAcidosisDis.addSymptom(LR.papilledema);
respiratoryAcidosisDis.addSymptom(LR.reflexesDecreased);
respiratoryAcidosisDis.addSymptom(LR.restlessness);
respiratoryAcidosisDis.addSymptom(LR.somnolence);
respiratoryAcidosisDis.addSymptom(LR.tachycardia);
respiratoryAcidosisDis.addSymptom(LR.tachypnea);
respiratoryAcidosisDis.addSymptom(LR.vasodilation);
Treatment respiratoryAcidosisTr1 = new Treatment("respiratoryAcidosisTr1", LR.ifSevereAcidosis);
respiratoryAcidosisTr1.addTreatmentAction(LR.mechanicalVentilation);
respiratoryAcidosisTr1.addTreatmentAction(LR.oxygenTherapy);
respiratoryAcidosisTr1.addTreatmentAction(LR.dialysis);
respiratoryAcidosisTr1.addDrug(LR.antibiotics);
respiratoryAcidosisTr1.addDrug(LR.bronchodilator);
respiratoryAcidosisTr1.addDrug(LR.corticosteroids);
respiratoryAcidosisDis.addTreatment("respiratoryAcidosisTr1");


// ------------- respiratoryAlkalosis  -------------
Disease respiratoryAlkalosisDis = new Disease(
    LR.respiratoryAlkalosis,
    L.respiratoryAlkalosisDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.respiratorySysSt,
    LR.aspirinToxicity
);
respiratoryAlkalosisDis.setPrintName(L.respiratoryAlkalosisPrintName);
respiratoryAlkalosisDis.setTemperature(100.0f);
respiratoryAlkalosisDis.addInternalCause(LR.asthma);
respiratoryAlkalosisDis.addInternalCause(LR.idiopathicPulmonaryFibrosis);
respiratoryAlkalosisDis.addInternalCause(LR.pneumonia);
respiratoryAlkalosisDis.addCausingAbnormalCondition(LR.hepaticFailure);
respiratoryAlkalosisDis.addCausingAbnormalCondition(LR.hypoxemia);
respiratoryAlkalosisDis.addCausingAbnormalCondition(LR.sepsis);
respiratoryAlkalosisDis.addReference("pp 513");
respiratoryAlkalosisDis.addSymptom(LR.agitation);
respiratoryAlkalosisDis.addSymptom(LR.anxiety);
respiratoryAlkalosisDis.addSymptom(LR.arrhythmia);
respiratoryAlkalosisDis.addSymptom(LR.dizziness);
respiratoryAlkalosisDis.addSymptom(LR.hyperventilation);
respiratoryAlkalosisDis.addSymptom(LR.lightHeadedness);
respiratoryAlkalosisDis.addSymptom(LR.muscleWeakness);
respiratoryAlkalosisDis.addSymptom(LR.paresthesia);
respiratoryAlkalosisDis.addSymptom(LR.seizure);
respiratoryAlkalosisDis.addSymptom(LR.spasm);
respiratoryAlkalosisDis.addSymptom(LR.twitching);
Treatment respiratoryAlkalosisTr1 = new Treatment("respiratoryAlkalosisTr1", LR.ifSevereAnxiety);
respiratoryAlkalosisTr1.addTreatmentAction(LR.breathIntoPaperBag);
respiratoryAlkalosisDis.addTreatment("respiratoryAlkalosisTr1");
Treatment respiratoryAlkalosisTr2 = new Treatment("respiratoryAlkalosisTr2", LR.ifAcuteHypoxemia);
respiratoryAlkalosisTr2.addTreatmentAction(LR.oxygenTherapy);
respiratoryAlkalosisDis.addTreatment("respiratoryAlkalosisTr2");


// ------------- pneumothorax  -------------
Disease pneumothoraxDis = new Disease(
    LR.pneumothorax,
    L.pneumothoraxDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.trauma
);
pneumothoraxDis.setPrintName(L.pneumothoraxPrintName);
pneumothoraxDis.setMiscComments(L.pneumothoraxComment);
pneumothoraxDis.addInternalCause(LR.berylliosisChronic);
pneumothoraxDis.addInternalCause(LR.idiopathicPulmonaryFibrosis);
pneumothoraxDis.addCausingAbnormalCondition(LR.pleuralSpaceRupture);
pneumothoraxDis.addCausesAbnormalCondition(LR.circulatoryFailure);
pneumothoraxDis.addCausesAbnormalCondition(LR.pulmonaryFailure);
pneumothoraxDis.addReference("pp 513-5");
pneumothoraxDis.addSymptom(LR.anxiety);
pneumothoraxDis.addSymptom(LR.breathingAsymmetric);
pneumothoraxDis.addSymptom(LR.dyspnea);
pneumothoraxDis.addSymptom(LR.neckVeinsElevated);
pneumothoraxDis.addSymptom(LR.pallor);
pneumothoraxDis.addSymptom(LR.pleuriticChestPain);
pneumothoraxDis.addSymptom(LR.pulseRapid);
pneumothoraxDis.addSymptom(LR.pulseWeak);
Treatment pneumothoraxTr1 = new Treatment("pneumothoraxTr1", LR.ifModerate);
pneumothoraxTr1.addTreatmentAction(LR.bedRest);
pneumothoraxTr1.addTreatmentAction(LR.oxygenTherapy);
pneumothoraxDis.addTreatment("pneumothoraxTr1");
Treatment pneumothoraxTr2 = new Treatment("pneumothoraxTr2", LR.ifSevere);
pneumothoraxTr2.addTreatmentAction(LR.chestTubeDrainage);
pneumothoraxTr2.addTreatmentAction(LR.surgery);
pneumothoraxDis.addTreatment("pneumothoraxTr2");


// ------------- pneumonia  -------------
Disease pneumoniaDis = new Disease(
    LR.pneumonia,
    L.pneumoniaDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.infection
);
pneumoniaDis.setPrintName(L.pneumoniaPrintName);
pneumoniaDis.setMiscComments(L.pneumoniaComment);
pneumoniaDis.setTemperature(101.0f);
pneumoniaDis.addInternalCause(LR.croup);
pneumoniaDis.addCausesDisease(LR.endocarditis);
pneumoniaDis.addCausesDisease(LR.lungAbscess);
pneumoniaDis.addCausesDisease(LR.meningitis);
pneumoniaDis.addCausesDisease(LR.pericarditis);
pneumoniaDis.addCausesAbnormalCondition(LR.empyema);
pneumoniaDis.addCausesAbnormalCondition(LR.hypoxemia);
pneumoniaDis.addCausesAbnormalCondition(LR.pleuralEffusion);
pneumoniaDis.addCausesAbnormalCondition(LR.respiratoryFailure);
pneumoniaDis.addReference("pp 515-520");
pneumoniaDis.addSymptom(LR.chills);
pneumoniaDis.addSymptom(LR.cough);
pneumoniaDis.addSymptom(LR.crackles);
pneumoniaDis.addSymptom(LR.pleuriticChestPain);
pneumoniaDis.addSymptom(LR.shaking);
pneumoniaDis.addSymptom(LR.sputumProduction);


// ------------- pneumoniaAcute  -------------
Disease pneumoniaAcuteDis = new Disease(
    LR.pneumoniaAcute,
    L.pneumoniaAcuteDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.infection
);
pneumoniaAcuteDis.setPrintName(L.pneumoniaAcutePrintName);
pneumoniaAcuteDis.setSuperDisease(LR.pneumonia);
pneumoniaAcuteDis.setTemperature(101.0f);
pneumoniaAcuteDis.addReference("pp 515-20");
pneumoniaAcuteDis.addSymptom(LR.breathingDifficult);
pneumoniaAcuteDis.addSymptom(LR.cheeksFlushed);
pneumoniaAcuteDis.addSymptom(LR.feverSym);
pneumoniaAcuteDis.addSymptom(LR.sweating, "", 0.3f);
pneumoniaAcuteDis.addSymptom(LR.throatSore);
pneumoniaAcuteDis.addSymptom(LR.wheezing);
Treatment pneumoniaAcuteTr1 = new Treatment("pneumoniaAcuteTr1");
pneumoniaAcuteTr1.addTreatmentAction(LR.bedRest);
pneumoniaAcuteTr1.addTreatmentAction(LR.fluidIncrease);
pneumoniaAcuteTr1.addTreatmentAction(LR.mechanicalVentilation);
pneumoniaAcuteTr1.addTreatmentAction(LR.oxygenTherapy);
pneumoniaAcuteTr1.addDrug(LR.analgetics);
pneumoniaAcuteTr1.addDrug(LR.antibiotics);
pneumoniaAcuteDis.addTreatment("pneumoniaAcuteTr1");


// ------------- influenza  -------------
Disease influenzaDis = new Disease(
    LR.influenza,
    L.influenzaDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.infection
);
influenzaDis.setPrintName(L.influenzaPrintName);
influenzaDis.setSuperDisease(LR.pneumonia);
influenzaDis.setMiscComments(L.influenzaComment);
influenzaDis.addExternalCause(LR.influenzaVirusInfection);
influenzaDis.setTemperature(103.0f);
influenzaDis.setCode358(253);
influenzaDis.setICD10code("J10");
influenzaDis.addReference("pp 516-7");
influenzaDis.addSymptom(LR.anorexia);
influenzaDis.addSymptom(LR.cyanosis);
influenzaDis.addSymptom(LR.dyspnea);
influenzaDis.addSymptom(LR.fatigue);
influenzaDis.addSymptom(LR.feverSym);
influenzaDis.addSymptom(LR.headacheFrontal);
influenzaDis.addSymptom(LR.malaise);
influenzaDis.addSymptom(LR.myalgia);
influenzaDis.addSymptom(LR.throatSore);
Treatment influenzaTr1 = new Treatment("influenzaTr1");
influenzaTr1.addTreatmentAction(LR.ifFeverProvideAntipyretic);
influenzaDis.addTreatment("influenzaTr1");
Treatment influenzaTr2 = new Treatment("influenzaTr2", LR.ifRespiratoryFailure);
influenzaTr2.addTreatmentAction(LR.endotrachealIntubation);
influenzaTr2.addTreatmentAction(LR.mechanicalVentilation);
influenzaDis.addTreatment("influenzaTr2");
Treatment influenzaTr3 = new Treatment("influenzaTr3", LR.ifInfluenzaA);
influenzaTr3.addDrug(LR.amantadine);
influenzaTr3.addDrug(LR.rimantadine);
influenzaDis.addTreatment("influenzaTr3");


// ------------- pneumoniaAdenoVirus  -------------
Disease pneumoniaAdenoVirusDis = new Disease(
    LR.pneumoniaAdenoVirus,
    L.pneumoniaAdenoVirusDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    30, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.infection
);
pneumoniaAdenoVirusDis.setPrintName(L.pneumoniaAdenoVirusPrintName);
pneumoniaAdenoVirusDis.setSuperDisease(LR.pneumonia);
pneumoniaAdenoVirusDis.addExternalCause(LR.adenoVirusInfection);
pneumoniaAdenoVirusDis.setCode358(255);
pneumoniaAdenoVirusDis.setICD10code("J12");
pneumoniaAdenoVirusDis.addReference("pp 516-517");
pneumoniaAdenoVirusDis.addSymptom(LR.anorexia, "", 0.5f);
pneumoniaAdenoVirusDis.addSymptom(LR.retrosternalChestPain, "", 0.5f);
pneumoniaAdenoVirusDis.addSymptom(LR.throatSore);
pneumoniaAdenoVirusDis.addSymptom(LR.sputumMucoid);


// ------------- pneumoniaSyncytialVirus  -------------
Disease pneumoniaSyncytialVirusDis = new Disease(
    LR.pneumoniaSyncytialVirus,
    L.pneumoniaSyncytialVirusDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    10, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.infection
);
pneumoniaSyncytialVirusDis.setPrintName(L.pneumoniaSyncytialVirusPrintName);
pneumoniaSyncytialVirusDis.setSuperDisease(LR.pneumonia);
pneumoniaSyncytialVirusDis.addExternalCause(LR.syncytialVirusInfection);
pneumoniaSyncytialVirusDis.setCode358(255);
pneumoniaSyncytialVirusDis.setICD10code("J12");
pneumoniaSyncytialVirusDis.addReference("pp 516-517");
pneumoniaSyncytialVirusDis.addSymptom(LR.irritability);
pneumoniaSyncytialVirusDis.addSymptom(LR.listlessness);
pneumoniaSyncytialVirusDis.addSymptom(LR.severeMalaise);
pneumoniaSyncytialVirusDis.addSymptom(LR.tachypnea);
Treatment pneumoniaSyncytialVirusTr1 = new Treatment("pneumoniaSyncytialVirusTr1");
pneumoniaSyncytialVirusTr1.addTreatmentAction(LR.humidifiedAir);
pneumoniaSyncytialVirusTr1.addTreatmentAction(LR.oxygenTherapy);
pneumoniaSyncytialVirusTr1.addDrug(LR.ribavirin);
pneumoniaSyncytialVirusTr1.addDrug(LR.antimicrobials);
pneumoniaSyncytialVirusDis.addTreatment("pneumoniaSyncytialVirusTr1");


// ------------- measles  -------------
Disease measlesDis = new Disease(
    LR.measles,
    L.measlesDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    F.measlesFreq, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.infection
);
measlesDis.setPrintName(L.measlesPrintName);
measlesDis.setSuperDisease(LR.pneumonia);
measlesDis.addExternalCause(LR.measlesVirusInfection);
measlesDis.setCode358(45);
measlesDis.setICD10code("B05");
measlesDis.addReference("pp 516-517");
measlesDis.addSymptom(LR.coryza);
measlesDis.addSymptom(LR.dyspnea);
measlesDis.addSymptom(LR.lymphadenopathy);
measlesDis.addSymptom(LR.rash);
Treatment measlesTr1 = new Treatment("measlesTr1");
measlesTr1.addTreatmentAction(LR.bedRest);
measlesTr1.addTreatmentAction(LR.hydration);
measlesTr1.addTreatmentAction(LR.mechanicalVentilation);
measlesTr1.addDrug(LR.antimicrobials);
measlesDis.addTreatment("measlesTr1");


// ------------- chickenpox  -------------
Disease chickenpoxDis = new Disease(
    LR.chickenpox,
    L.chickenpoxDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    F.chickenpoxFreq, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.herpesvirusVaricella
);
chickenpoxDis.setPrintName(L.chickenpoxPrintName);
chickenpoxDis.setSuperDisease(LR.pneumonia);
chickenpoxDis.addReference("pp 516-517");
chickenpoxDis.addIllustration(D.ChickenPoxJpg);
chickenpoxDis.addSymptom(LR.cyanosis);
chickenpoxDis.addSymptom(LR.dyspnea);
chickenpoxDis.addSymptom(LR.hemoptysis);
chickenpoxDis.addSymptom(LR.rash);
chickenpoxDis.addSymptom(LR.rhonchus);
chickenpoxDis.addSymptom(LR.tachypnea);
Treatment chickenpoxTr1 = new Treatment("chickenpoxTr1");
chickenpoxTr1.addTreatmentAction(LR.hydration);
chickenpoxTr1.addTreatmentAction(LR.oxygenTherapy);
chickenpoxTr1.addDrug(LR.acyclovir);
chickenpoxDis.addTreatment("chickenpoxTr1");


// ------------- pneumoniaCytomegaloVirus  -------------
Disease pneumoniaCytomegaloVirusDis = new Disease(
    LR.pneumoniaCytomegaloVirus,
    L.pneumoniaCytomegaloVirusDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.infection
);
pneumoniaCytomegaloVirusDis.setPrintName(L.pneumoniaCytomegaloVirusPrintName);
pneumoniaCytomegaloVirusDis.setSuperDisease(LR.pneumonia);
pneumoniaCytomegaloVirusDis.setMiscComments(L.pneumoniaCytomegaloVirusComment);
pneumoniaCytomegaloVirusDis.addExternalCause(LR.respiratoryCytomegaloVirusInfection);
pneumoniaCytomegaloVirusDis.setCode358(255);
pneumoniaCytomegaloVirusDis.setICD10code("J12");
pneumoniaCytomegaloVirusDis.addReference("pp 516-517");
pneumoniaCytomegaloVirusDis.addSymptom(LR.cyanosis);
pneumoniaCytomegaloVirusDis.addSymptom(LR.dyspnea);
pneumoniaCytomegaloVirusDis.addSymptom(LR.fatigue);
pneumoniaCytomegaloVirusDis.addSymptom(LR.feverSym);
pneumoniaCytomegaloVirusDis.addSymptom(LR.malaise);
pneumoniaCytomegaloVirusDis.addSymptom(LR.myalgia);
pneumoniaCytomegaloVirusDis.addSymptom(LR.nightSweating);
Treatment pneumoniaCytomegaloVirusTr1 = new Treatment("pneumoniaCytomegaloVirusTr1");
pneumoniaCytomegaloVirusTr1.addTreatmentAction(LR.hydration);
pneumoniaCytomegaloVirusTr1.addTreatmentAction(LR.oxygenTherapy);
pneumoniaCytomegaloVirusTr1.addTreatmentAction(LR.bedRest);
pneumoniaCytomegaloVirusTr1.addDrug(LR.ganciclovir);
pneumoniaCytomegaloVirusDis.addTreatment("pneumoniaCytomegaloVirusTr1");


// ------------- pneumoniaStreptococcus  -------------
Disease pneumoniaStreptococcusDis = new Disease(
    LR.pneumoniaStreptococcus,
    L.pneumoniaStreptococcusDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    F.pneumoniaStreptococcusFreq, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.infection
);
pneumoniaStreptococcusDis.setPrintName(L.pneumoniaStreptococcusPrintName);
pneumoniaStreptococcusDis.setSuperDisease(LR.pneumonia);
pneumoniaStreptococcusDis.setMiscComments(L.pneumoniaStreptococcusComment);
pneumoniaStreptococcusDis.addExternalCause(LR.streptococcusInfection);
pneumoniaStreptococcusDis.setTemperature(103.0f);
pneumoniaStreptococcusDis.setCode358(256);
pneumoniaStreptococcusDis.setICD10code("J13");
pneumoniaStreptococcusDis.addReference("pp 516-517");
pneumoniaStreptococcusDis.addSymptom(LR.coughProductive);
pneumoniaStreptococcusDis.addSymptom(LR.fatigue);
pneumoniaStreptococcusDis.addSymptom(LR.feverSym);
pneumoniaStreptococcusDis.addSymptom(LR.headache);
pneumoniaStreptococcusDis.addSymptom(LR.malaise);
pneumoniaStreptococcusDis.addSymptom(LR.nausea);
pneumoniaStreptococcusDis.addSymptom(LR.tachypnea);
pneumoniaStreptococcusDis.addSymptom(LR.throatSore);
pneumoniaStreptococcusDis.addSymptom(LR.vomiting);
Treatment pneumoniaStreptococcusTr1 = new Treatment("pneumoniaStreptococcusTr1");
pneumoniaStreptococcusTr1.addDrug(LR.penicillinG);
pneumoniaStreptococcusTr1.addDrug(LR.erythromycin);
pneumoniaStreptococcusDis.addTreatment("pneumoniaStreptococcusTr1");


// ------------- pneumoniaKlebsiella  -------------
Disease pneumoniaKlebsiellaDis = new Disease(
    LR.pneumoniaKlebsiella,
    L.pneumoniaKlebsiellaDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.infection
);
pneumoniaKlebsiellaDis.setPrintName(L.pneumoniaKlebsiellaPrintName);
pneumoniaKlebsiellaDis.setSuperDisease(LR.pneumonia);
pneumoniaKlebsiellaDis.setMiscComments(L.pneumoniaKlebsiellaComment);
pneumoniaKlebsiellaDis.addExternalCause(LR.klebsiellaInfection);
pneumoniaKlebsiellaDis.setCode358(256);
pneumoniaKlebsiellaDis.setICD10code("J13");
pneumoniaKlebsiellaDis.addReference("pp 518-519");
pneumoniaKlebsiellaDis.addSymptom(LR.cyanosis);
pneumoniaKlebsiellaDis.addSymptom(LR.hemoptysis);
pneumoniaKlebsiellaDis.addSymptom(LR.respirationShallow);
Treatment pneumoniaKlebsiellaTr1 = new Treatment("pneumoniaKlebsiellaTr1");
pneumoniaKlebsiellaTr1.addDrug(LR.antimicrobials);
pneumoniaKlebsiellaTr1.addDrug(LR.aminoglycocide);
pneumoniaKlebsiellaTr1.addDrug(LR.cephalosporin);
pneumoniaKlebsiellaDis.addTreatment("pneumoniaKlebsiellaTr1");


// ------------- pneumoniaStaphylococcus  -------------
Disease pneumoniaStaphylococcusDis = new Disease(
    LR.pneumoniaStaphylococcus,
    L.pneumoniaStaphylococcusDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.infection
);
pneumoniaStaphylococcusDis.setPrintName(L.pneumoniaStaphylococcusPrintName);
pneumoniaStaphylococcusDis.setSuperDisease(LR.pneumonia);
pneumoniaStaphylococcusDis.setMiscComments(L.pneumoniaStaphylococcusComment);
pneumoniaStaphylococcusDis.addExternalCause(LR.staphylococcusInfection);
pneumoniaStaphylococcusDis.setCode358(256);
pneumoniaStaphylococcusDis.setICD10code("J13");
pneumoniaStaphylococcusDis.addReference("pp 518-519");
pneumoniaStaphylococcusDis.addSymptom(LR.dyspnea);
pneumoniaStaphylococcusDis.addSymptom(LR.hemoptysis);
pneumoniaStaphylococcusDis.addSymptom(LR.tachypnea);
Treatment pneumoniaStaphylococcusTr1 = new Treatment("pneumoniaStaphylococcusTr1");
pneumoniaStaphylococcusTr1.addTreatmentAction(LR.chestTubeDrainage);
pneumoniaStaphylococcusTr1.addDrug(LR.antimicrobials);
pneumoniaStaphylococcusTr1.addDrug(LR.nafcillin);
pneumoniaStaphylococcusTr1.addDrug(LR.oxacillin);
pneumoniaStaphylococcusDis.addTreatment("pneumoniaStaphylococcusTr1");


// ------------- pneumocystisCarinii  -------------
Disease pneumocystisCariniiDis = new Disease(
    LR.pneumocystisCarinii,
    L.pneumocystisCariniiDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.infection
);
pneumocystisCariniiDis.setPrintName(L.pneumocystisCariniiPrintName);
pneumocystisCariniiDis.setSuperDisease(LR.pneumonia);
pneumocystisCariniiDis.setMiscComments(L.pneumocystisCariniiComment);
pneumocystisCariniiDis.addExternalCause(LR.pneumocystisCariniiInfection);
pneumocystisCariniiDis.setTemperature(100.0f);
pneumocystisCariniiDis.setCode358(257);
pneumocystisCariniiDis.setICD10code("J16");
pneumocystisCariniiDis.addReference("pp 518-519");
pneumocystisCariniiDis.addSymptom(LR.anorexia);
pneumocystisCariniiDis.addSymptom(LR.dyspnea);
pneumocystisCariniiDis.addSymptom(LR.fatigue);
pneumocystisCariniiDis.addSymptom(LR.weightLoss);
Treatment pneumocystisCariniiTr1 = new Treatment("pneumocystisCariniiTr1");
pneumocystisCariniiTr1.addTreatmentAction(LR.oxygenTherapy);
pneumocystisCariniiTr1.addTreatmentAction(LR.mechanicalVentilation);
pneumocystisCariniiTr1.addTreatmentAction(LR.nutritionImprove);
pneumocystisCariniiTr1.addDrug(LR.antimicrobials);
pneumocystisCariniiTr1.addDrug(LR.coTrimoxazole);
pneumocystisCariniiTr1.addDrug(LR.pentamidine);
pneumocystisCariniiDis.addTreatment("pneumocystisCariniiTr1");


// ------------- pneumoniaAspiration  -------------
Disease pneumoniaAspirationDis = new Disease(
    LR.pneumoniaAspiration,
    L.pneumoniaAspirationDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.infection
);
pneumoniaAspirationDis.setPrintName(L.pneumoniaAspirationPrintName);
pneumoniaAspirationDis.setSuperDisease(LR.pneumonia);
pneumoniaAspirationDis.setMiscComments(L.pneumoniaAspirationComment);
pneumoniaAspirationDis.addExternalCause(LR.aspirationContamination);
pneumoniaAspirationDis.setCode358(273);
pneumoniaAspirationDis.setICD10code("J69");
pneumoniaAspirationDis.addReference("pp 518-519");
pneumoniaAspirationDis.addSymptom(LR.cyanosis);
pneumoniaAspirationDis.addSymptom(LR.dyspnea);
pneumoniaAspirationDis.addSymptom(LR.hypotension);
pneumoniaAspirationDis.addSymptom(LR.tachycardia);
Treatment pneumoniaAspirationTr1 = new Treatment("pneumoniaAspirationTr1");
pneumoniaAspirationTr1.addTreatmentAction(LR.oxygenTherapy);
pneumoniaAspirationTr1.addTreatmentAction(LR.suctioning);
pneumoniaAspirationTr1.addTreatmentAction(LR.hydration);
pneumoniaAspirationTr1.addDrug(LR.antimicrobials);
pneumoniaAspirationTr1.addDrug(LR.penicillinG);
pneumoniaAspirationTr1.addDrug(LR.clindamycin);
pneumoniaAspirationDis.addTreatment("pneumoniaAspirationTr1");


// ------------- severeAcuteRespiratorySyndrome  -------------
Disease severeAcuteRespiratorySyndromeDis = new Disease(
    LR.severeAcuteRespiratorySyndrome,
    L.severeAcuteRespiratorySyndromeDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.coronavirusInfection
);
severeAcuteRespiratorySyndromeDis.setPrintName(L.severeAcuteRespiratorySyndromePrintName);
severeAcuteRespiratorySyndromeDis.setSuperDisease(LR.pneumonia);
severeAcuteRespiratorySyndromeDis.setWebResource("http://www.cdc.gov/ncidod/sars/");
severeAcuteRespiratorySyndromeDis.setTemperature(100.5f);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.breathingDifficult);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.chills);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.diarrhea, "", 0.3f);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.dizziness, "", 0.3f);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.feverSym);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.headache);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.malaise);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.myalgia);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.nausea, "", 0.3f);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.throatSore, "", 0.3f);


// ------------- h5n1  -------------
Disease h5n1Dis = new Disease(
    LR.h5n1,
    L.h5n1Description,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.infection
);
h5n1Dis.setPrintName(L.h5n1PrintName);
h5n1Dis.setSuperDisease(LR.pneumonia);
h5n1Dis.setMiscComments(L.h5n1Comment);
h5n1Dis.setWebResource("http://www.who.int/mediacentre/factsheets/avian_influenza/en/index.html");
h5n1Dis.addExternalCause(LR.h5n1BirdFluVirus);
h5n1Dis.setTemperature(103.0f);
h5n1Dis.addSymptom(LR.cyanosis);
h5n1Dis.addSymptom(LR.dyspnea);
h5n1Dis.addSymptom(LR.headacheFrontal);
h5n1Dis.addSymptom(LR.myalgia);
h5n1Dis.addSymptom(LR.abdomenPain);
h5n1Dis.addSymptom(LR.breathingDifficult);
h5n1Dis.addSymptom(LR.diarrhea);
h5n1Dis.addSymptom(LR.gumsBleeding);
h5n1Dis.addSymptom(LR.hoarseness);
h5n1Dis.addSymptom(LR.respirationDistress);
h5n1Dis.addSymptom(LR.vomiting);
Treatment h5n1Tr1 = new Treatment("h5n1Tr1");
h5n1Tr1.addDrug(LR.oseltamivir);
h5n1Dis.addTreatment("h5n1Tr1");


// ------------- bronchiolitisObliteransWithPneumonia  -------------
Disease bronchiolitisObliteransWithPneumoniaDis = new Disease(
    LR.bronchiolitisObliteransWithPneumonia,
    L.bronchiolitisObliteransWithPneumoniaDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    50, // minAge
    60, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.none
);
bronchiolitisObliteransWithPneumoniaDis.setPrintName(L.bronchiolitisObliteransWithPneumoniaPrintName);
bronchiolitisObliteransWithPneumoniaDis.setUnderlyingDisease(LR.pneumonia);
bronchiolitisObliteransWithPneumoniaDis.setMiscComments(L.bronchiolitisObliteransWithPneumoniaComment);
bronchiolitisObliteransWithPneumoniaDis.setTemperature(100.0f);
bronchiolitisObliteransWithPneumoniaDis.setCode358(259);
bronchiolitisObliteransWithPneumoniaDis.setICD10code("J21");
bronchiolitisObliteransWithPneumoniaDis.addCausesAbnormalCondition(LR.hypoxemia);
bronchiolitisObliteransWithPneumoniaDis.addReference("pp 520-2");
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.anorexia);
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.chestTightness);
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.chills);
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.cough);
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.crackles);
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.dyspnea);
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.hemoptysis);
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.malaise);
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.nightSweating);
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.weightLoss);
Treatment bronchiolitisObliteransWithPneumoniaTr1 = new Treatment("bronchiolitisObliteransWithPneumoniaTr1");
bronchiolitisObliteransWithPneumoniaTr1.addDrug(LR.corticosteroids);
bronchiolitisObliteransWithPneumoniaDis.addTreatment("bronchiolitisObliteransWithPneumoniaTr1");


// ------------- pulmonaryEmbolism  -------------
Disease pulmonaryEmbolismDis = new Disease(
    LR.pulmonaryEmbolism,
    L.pulmonaryEmbolismDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.surgery
);
pulmonaryEmbolismDis.setPrintName(L.pulmonaryEmbolismPrintName);
pulmonaryEmbolismDis.addExternalCause(LR.longTermImmobility);
pulmonaryEmbolismDis.addExternalCause(LR.oralContraceptiveUse);
pulmonaryEmbolismDis.setTemperature(99.8f);
pulmonaryEmbolismDis.setCode358(218);
pulmonaryEmbolismDis.setICD10code("I26");
pulmonaryEmbolismDis.addInternalCause(LR.burn);
pulmonaryEmbolismDis.addInternalCause(LR.cancer);
pulmonaryEmbolismDis.addInternalCause(LR.chronicObstructivePulmonaryDisease);
pulmonaryEmbolismDis.addInternalCause(LR.heartFailure);
pulmonaryEmbolismDis.addInternalCause(LR.polycythemiaVera);
pulmonaryEmbolismDis.addInternalCause(LR.sickleCellAnemia);
pulmonaryEmbolismDis.addInternalCause(LR.thrombophlebitis);
pulmonaryEmbolismDis.addInternalCause(LR.femoralThrombophlebitis);
pulmonaryEmbolismDis.addInternalCause(LR.obesity);
pulmonaryEmbolismDis.addCausingAbnormalCondition(LR.atrialFibrillation);
pulmonaryEmbolismDis.addCausingAbnormalCondition(LR.thrombocytosis);
pulmonaryEmbolismDis.addCausingAbnormalCondition(LR.varicoseVeins);
pulmonaryEmbolismDis.addCausesAbnormalCondition(LR.pleuralEffusion);
pulmonaryEmbolismDis.addReference("pp 522-4");
pulmonaryEmbolismDis.addSymptom(LR.anginaPain);
pulmonaryEmbolismDis.addSymptom(LR.coughProductive);
pulmonaryEmbolismDis.addSymptom(LR.cyanosis, L.pulmonaryEmbolism_cyanosis, 0.2f);
pulmonaryEmbolismDis.addSymptom(LR.dyspnea);
pulmonaryEmbolismDis.addSymptom(LR.neckVeinsElevated, L.pulmonaryEmbolism_neckVeinsElevated, 0.2f);
pulmonaryEmbolismDis.addSymptom(LR.hemoptysis, "", 0.2f);
pulmonaryEmbolismDis.addSymptom(LR.legEdema, "", 0.2f);
pulmonaryEmbolismDis.addSymptom(LR.pleuriticChestPain);
pulmonaryEmbolismDis.addSymptom(LR.syncope, L.pulmonaryEmbolism_syncope, 0.2f);
pulmonaryEmbolismDis.addSymptom(LR.tachycardia);
Treatment pulmonaryEmbolismTr1 = new Treatment("pulmonaryEmbolismTr1");
pulmonaryEmbolismTr1.addTreatmentAction(LR.oxygenTherapy);
pulmonaryEmbolismTr1.addDrug(LR.analgetics);
pulmonaryEmbolismTr1.addDrug(LR.anticoagulants);
pulmonaryEmbolismTr1.addDrug(LR.heparin);
pulmonaryEmbolismDis.addTreatment("pulmonaryEmbolismTr1");
Treatment pulmonaryEmbolismTr2 = new Treatment("pulmonaryEmbolismTr2", LR.ifMassiveEmbolism);
pulmonaryEmbolismTr2.addTreatmentAction(LR.fibrinolyticTherapy);
pulmonaryEmbolismTr2.addTreatmentAction(LR.surgicalEmbolectomy);
pulmonaryEmbolismDis.addTreatment("pulmonaryEmbolismTr2");
Treatment pulmonaryEmbolismTr3 = new Treatment("pulmonaryEmbolismTr3", LR.ifHypotension);
pulmonaryEmbolismTr3.addTreatmentAction(LR.vasopressor);
pulmonaryEmbolismDis.addTreatment("pulmonaryEmbolismTr3");
Treatment pulmonaryEmbolismTr4 = new Treatment("pulmonaryEmbolismTr4", LR.ifSepticEmboli);
pulmonaryEmbolismTr4.addDrug(LR.antibiotics);
pulmonaryEmbolismDis.addTreatment("pulmonaryEmbolismTr4");


// ------------- sarcoidosis  -------------
Disease sarcoidosisDis = new Disease(
    LR.sarcoidosis,
    L.sarcoidosisDescription,
    LR.respiratoryDisorders,
    LR.moreFemale, // genderSpecificity
    LR.africanAmerican, // raceSpecificity
    20, // minAge
    40, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
sarcoidosisDis.setPrintName(L.sarcoidosisPrintName);
sarcoidosisDis.setMiscComments(L.sarcoidosisComment);
sarcoidosisDis.setWebResource("http://health.yahoo.com/health/Diseases_and_Conditions/Disease_Feed_Data/Sarcoidosis/");
sarcoidosisDis.addReference("pp 524-6");
sarcoidosisDis.addSymptom(LR.arthralgia, "", 0.1f);
sarcoidosisDis.addSymptom(LR.fatigue, "", 0.6f);
sarcoidosisDis.addSymptom(LR.feverSym, "", 0.6f);
sarcoidosisDis.addSymptom(LR.malaise);
sarcoidosisDis.addSymptom(LR.nightSweating, "", 0.6f);
sarcoidosisDis.addSymptom(LR.weightLoss, "", 0.6f);
Treatment sarcoidosisTr1 = new Treatment("sarcoidosisTr1");
sarcoidosisTr1.addTreatmentAction(LR.dietLowCalcium);
sarcoidosisTr1.addDrug(LR.steroids);
sarcoidosisDis.addTreatment("sarcoidosisTr1");
Treatment sarcoidosisTr2 = new Treatment("sarcoidosisTr2", LR.ifHypercalcemia);
sarcoidosisTr2.addTreatmentAction(LR.avoidSunlightExposure);
sarcoidosisDis.addTreatment("sarcoidosisTr2");


// ------------- sarcoidosisRespiratory  -------------
Disease sarcoidosisRespiratoryDis = new Disease(
    LR.sarcoidosisRespiratory,
    L.sarcoidosisRespiratoryDescription,
    LR.respiratoryDisorders,
    LR.moreFemale, // genderSpecificity
    LR.africanAmerican, // raceSpecificity
    20, // minAge
    40, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.none
);
sarcoidosisRespiratoryDis.setPrintName(L.sarcoidosisRespiratoryPrintName);
sarcoidosisRespiratoryDis.setSuperDisease(LR.sarcoidosis);
sarcoidosisRespiratoryDis.addCausesDisease(LR.corPulmonale);
sarcoidosisRespiratoryDis.addCausesDisease(LR.pulmonaryHypertension);
sarcoidosisRespiratoryDis.addReference("pp 525");
sarcoidosisRespiratoryDis.addSymptom(LR.breathlessness, "", 0.4f);
sarcoidosisRespiratoryDis.addSymptom(LR.cough, "", 0.4f);
sarcoidosisRespiratoryDis.addSymptom(LR.substernalPain, "", 0.4f);


// ------------- sarcoidosisCutaneous  -------------
Disease sarcoidosisCutaneousDis = new Disease(
    LR.sarcoidosisCutaneous,
    L.sarcoidosisCutaneousDescription,
    LR.respiratoryDisorders,
    LR.moreFemale, // genderSpecificity
    LR.africanAmerican, // raceSpecificity
    20, // minAge
    40, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
sarcoidosisCutaneousDis.setPrintName(L.sarcoidosisCutaneousPrintName);
sarcoidosisCutaneousDis.setSuperDisease(LR.sarcoidosis);
sarcoidosisCutaneousDis.addReference("pp 525");
sarcoidosisCutaneousDis.addSymptom(LR.erythemaNodosum, "", 0.4f);
sarcoidosisCutaneousDis.addSymptom(LR.maculopapularEruption, "", 0.4f);
sarcoidosisCutaneousDis.addSymptom(LR.noseMucosalLesion, "", 0.4f);
sarcoidosisCutaneousDis.addSymptom(LR.skinNodules, "", 0.4f);


// ------------- sarcoidosisOphthalmic  -------------
Disease sarcoidosisOphthalmicDis = new Disease(
    LR.sarcoidosisOphthalmic,
    L.sarcoidosisOphthalmicDescription,
    LR.respiratoryDisorders,
    LR.moreFemale, // genderSpecificity
    LR.africanAmerican, // raceSpecificity
    20, // minAge
    40, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.eyesSysSt,
    LR.none
);
sarcoidosisOphthalmicDis.setPrintName(L.sarcoidosisOphthalmicPrintName);
sarcoidosisOphthalmicDis.setSuperDisease(LR.sarcoidosis);
sarcoidosisOphthalmicDis.addCausesDisease(LR.uveitisAnterior);
sarcoidosisOphthalmicDis.addCausesDisease(LR.glaucoma);
sarcoidosisOphthalmicDis.addCausesAbnormalCondition(LR.blindness);
sarcoidosisOphthalmicDis.addReference("pp 525");
sarcoidosisOphthalmicDis.addSymptom(LR.eyePain, "", 0.4f);
sarcoidosisOphthalmicDis.addSymptom(LR.eyeDryness, "", 0.4f);
sarcoidosisOphthalmicDis.addSymptom(LR.eyeExudate, "", 0.4f);
sarcoidosisOphthalmicDis.addSymptom(LR.eyeRedness, "", 0.4f);
sarcoidosisOphthalmicDis.addSymptom(LR.visionBlurred, "", 0.4f);


// ------------- sarcoidosisLymphatic  -------------
Disease sarcoidosisLymphaticDis = new Disease(
    LR.sarcoidosisLymphatic,
    L.sarcoidosisLymphaticDescription,
    LR.respiratoryDisorders,
    LR.moreFemale, // genderSpecificity
    LR.africanAmerican, // raceSpecificity
    20, // minAge
    40, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lymphSysSt,
    LR.none
);
sarcoidosisLymphaticDis.setPrintName(L.sarcoidosisLymphaticPrintName);
sarcoidosisLymphaticDis.setSuperDisease(LR.sarcoidosis);
sarcoidosisLymphaticDis.addCausesAbnormalCondition(LR.splenomegaly);
sarcoidosisLymphaticDis.addReference("pp 525");
sarcoidosisLymphaticDis.addSymptom(LR.lymphadenopathy, "", 0.2f);


// ------------- sarcoidosisMusculoSkeletal  -------------
Disease sarcoidosisMusculoSkeletalDis = new Disease(
    LR.sarcoidosisMusculoSkeletal,
    L.sarcoidosisMusculoSkeletalDescription,
    LR.respiratoryDisorders,
    LR.moreFemale, // genderSpecificity
    LR.africanAmerican, // raceSpecificity
    20, // minAge
    40, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.musculoSkeletalSysSt,
    LR.none
);
sarcoidosisMusculoSkeletalDis.setPrintName(L.sarcoidosisMusculoSkeletalPrintName);
sarcoidosisMusculoSkeletalDis.setSuperDisease(LR.sarcoidosis);
sarcoidosisMusculoSkeletalDis.addReference("pp 525");
sarcoidosisMusculoSkeletalDis.addSymptom(LR.arthralgia, "", 0.2f);
sarcoidosisMusculoSkeletalDis.addSymptom(LR.fingerBoneLesion, "", 0.2f);
sarcoidosisMusculoSkeletalDis.addSymptom(LR.myalgia, "", 0.2f);
sarcoidosisMusculoSkeletalDis.addSymptom(LR.muscleWeakness, "", 0.2f);


// ------------- sarcoidosisHepatic  -------------
Disease sarcoidosisHepaticDis = new Disease(
    LR.sarcoidosisHepatic,
    L.sarcoidosisHepaticDescription,
    LR.respiratoryDisorders,
    LR.moreFemale, // genderSpecificity
    LR.africanAmerican, // raceSpecificity
    20, // minAge
    40, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.liverSysSt,
    LR.none
);
sarcoidosisHepaticDis.setPrintName(L.sarcoidosisHepaticPrintName);
sarcoidosisHepaticDis.setSuperDisease(LR.sarcoidosis);
sarcoidosisHepaticDis.addCausesDisease(LR.hepatitis);
sarcoidosisHepaticDis.addReference("pp 525");
sarcoidosisHepaticDis.addSymptom(LR.jaundice, "", 0.2f);
sarcoidosisHepaticDis.addSymptom(LR.pruritus, "", 0.2f);


// ------------- sarcoidosisUrinary  -------------
Disease sarcoidosisUrinaryDis = new Disease(
    LR.sarcoidosisUrinary,
    L.sarcoidosisUrinaryDescription,
    LR.respiratoryDisorders,
    LR.moreFemale, // genderSpecificity
    LR.africanAmerican, // raceSpecificity
    20, // minAge
    40, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bladderSysSt,
    LR.none
);
sarcoidosisUrinaryDis.setPrintName(L.sarcoidosisUrinaryPrintName);
sarcoidosisUrinaryDis.setSuperDisease(LR.sarcoidosis);
sarcoidosisUrinaryDis.addCausesAbnormalCondition(LR.hypercalciuria);
sarcoidosisUrinaryDis.addReference("pp 525");
sarcoidosisUrinaryDis.addSymptom(LR.backPain, "", 0.2f);
sarcoidosisUrinaryDis.addSymptom(LR.flankPain, "", 0.2f);
sarcoidosisUrinaryDis.addSymptom(LR.urinaryFrequency, "", 0.2f);


// ------------- sarcoidosisCardio  -------------
Disease sarcoidosisCardioDis = new Disease(
    LR.sarcoidosisCardio,
    L.sarcoidosisCardioDescription,
    LR.respiratoryDisorders,
    LR.moreFemale, // genderSpecificity
    LR.africanAmerican, // raceSpecificity
    20, // minAge
    40, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.heartSysSt,
    LR.none
);
sarcoidosisCardioDis.setPrintName(L.sarcoidosisCardioPrintName);
sarcoidosisCardioDis.setSuperDisease(LR.sarcoidosis);
sarcoidosisCardioDis.addCausesDisease(LR.cardiomyopathy);
sarcoidosisCardioDis.addReference("pp 525");
sarcoidosisCardioDis.addSymptom(LR.arrhythmia, "", 0.2f);
sarcoidosisCardioDis.addSymptom(LR.chestTightness, "", 0.2f);
sarcoidosisCardioDis.addSymptom(LR.dyspnea, "", 0.2f);
sarcoidosisCardioDis.addSymptom(LR.legEdema, "", 0.2f);
sarcoidosisCardioDis.addSymptom(LR.palpitations, "", 0.2f);


// ------------- sarcoidosisCNS  -------------
Disease sarcoidosisCNSDis = new Disease(
    LR.sarcoidosisCNS,
    L.sarcoidosisCNSDescription,
    LR.respiratoryDisorders,
    LR.moreFemale, // genderSpecificity
    LR.africanAmerican, // raceSpecificity
    20, // minAge
    40, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.centralNervousSysSt,
    LR.none
);
sarcoidosisCNSDis.setPrintName(L.sarcoidosisCNSPrintName);
sarcoidosisCNSDis.setSuperDisease(LR.sarcoidosis);
sarcoidosisCNSDis.addCausesDisease(LR.diabetesInsidipus);
sarcoidosisCNSDis.addCausesDisease(LR.meningitis);
sarcoidosisCNSDis.addReference("pp 525");
sarcoidosisCNSDis.addSymptom(LR.headache, "", 0.2f);
sarcoidosisCNSDis.addSymptom(LR.palsy, "", 0.2f);
sarcoidosisCNSDis.addSymptom(LR.seizure, "", 0.2f);
sarcoidosisCNSDis.addSymptom(LR.visionDefect, "", 0.2f);


// ------------- lungAbscess  -------------
Disease lungAbscessDis = new Disease(
    LR.lungAbscess,
    L.lungAbscessDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -6, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.infection
);
lungAbscessDis.setPrintName(L.lungAbscessPrintName);
lungAbscessDis.setMiscComments(L.lungAbscessComment);
lungAbscessDis.setTemperature(99.9f);
lungAbscessDis.addInternalCause(LR.pneumonia);
lungAbscessDis.addCausesDisease(LR.bronchiectasis);
lungAbscessDis.addCausesAbnormalCondition(LR.empyema);
lungAbscessDis.addReference("pp 526-7");
lungAbscessDis.addSymptom(LR.chills);
lungAbscessDis.addSymptom(LR.cough);
lungAbscessDis.addSymptom(LR.diaphoresis);
lungAbscessDis.addSymptom(LR.dyspnea);
lungAbscessDis.addSymptom(LR.headache);
lungAbscessDis.addSymptom(LR.hemorrhage, L.lungAbscess_hemorrhage, 0.05f);
lungAbscessDis.addSymptom(LR.malaise);
lungAbscessDis.addSymptom(LR.pleuriticChestPain);
lungAbscessDis.addSymptom(LR.hemoptysis);
lungAbscessDis.addSymptom(LR.sputumFoulSmelling);
lungAbscessDis.addSymptom(LR.sputumPurulent);
lungAbscessDis.addSymptom(LR.weightLoss);
Treatment lungAbscessTr1 = new Treatment("lungAbscessTr1");
lungAbscessTr1.addTreatmentAction(LR.IVFluids);
lungAbscessTr1.addTreatmentAction(LR.oxygenTherapy);
lungAbscessTr1.addTreatmentAction(LR.suctioning);
lungAbscessTr1.addTreatmentAction(LR.aspirationPrecautions);
lungAbscessTr1.addDrug(LR.antibiotics);
lungAbscessDis.addTreatment("lungAbscessTr1");


// ------------- hemothorax  -------------
Disease hemothoraxDis = new Disease(
    LR.hemothorax,
    L.hemothoraxDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.chestTrauma
);
hemothoraxDis.setPrintName(L.hemothoraxPrintName);
hemothoraxDis.addCausesAbnormalCondition(LR.shock);
hemothoraxDis.addReference("pp 527");
hemothoraxDis.addSymptom(LR.anxiety, L.hemothorax_anxiety, 1.0f);
hemothoraxDis.addSymptom(LR.chestPain);
hemothoraxDis.addSymptom(LR.cyanosis, L.hemothorax_cyanosis, 0.5f);
hemothoraxDis.addSymptom(LR.dyspnea);
hemothoraxDis.addSymptom(LR.hypotension, L.hemothorax_hypotension, 0.2f);
hemothoraxDis.addSymptom(LR.restlessness, L.hemothorax_restlessness, 1.0f);
hemothoraxDis.addSymptom(LR.stupor, L.hemothorax_stupor, 0.5f);
hemothoraxDis.addSymptom(LR.tachypnea);
Treatment hemothoraxTr1 = new Treatment("hemothoraxTr1");
hemothoraxTr1.addTreatmentAction(LR.oxygenTherapy);
hemothoraxTr1.addTreatmentAction(LR.IVFluids);
hemothoraxTr1.addTreatmentAction(LR.bloodTransfusion);
hemothoraxDis.addTreatment("hemothoraxTr1");


// ------------- pulmonaryHypertension  -------------
Disease pulmonaryHypertensionDis = new Disease(
    LR.pulmonaryHypertension,
    L.pulmonaryHypertensionDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.pulmonaryArterySysSt,
    LR.none
);
pulmonaryHypertensionDis.setPrintName(L.pulmonaryHypertensionPrintName);
pulmonaryHypertensionDis.setMiscComments(L.pulmonaryHypertensionComment);
pulmonaryHypertensionDis.setWebResource("http://www.primary-pulmonary-hypertension-resources.com/");
pulmonaryHypertensionDis.addInternalCause(LR.asbestosis);
pulmonaryHypertensionDis.addInternalCause(LR.berylliosisChronic);
pulmonaryHypertensionDis.addInternalCause(LR.coalWorkerPneumoconiosis);
pulmonaryHypertensionDis.addInternalCause(LR.idiopathicPulmonaryFibrosis);
pulmonaryHypertensionDis.addInternalCause(LR.respiratoryFailureAcute);
pulmonaryHypertensionDis.addInternalCause(LR.sarcoidosisRespiratory);
pulmonaryHypertensionDis.addInternalCause(LR.schistosomiasis);
pulmonaryHypertensionDis.addCausesDisease(LR.heartFailureRightSided);
pulmonaryHypertensionDis.addCausesAbnormalCondition(LR.ascites);
pulmonaryHypertensionDis.addCausesAbnormalCondition(LR.hepatomegaly);
pulmonaryHypertensionDis.addReference("pp 528-9");
pulmonaryHypertensionDis.addSymptom(LR.chestPain, "", 0.3f);
pulmonaryHypertensionDis.addSymptom(LR.dizziness, "", 0.6f);
pulmonaryHypertensionDis.addSymptom(LR.dyspnea);
pulmonaryHypertensionDis.addSymptom(LR.edemaPeripheral);
pulmonaryHypertensionDis.addSymptom(LR.fainting, "", 0.6f);
pulmonaryHypertensionDis.addSymptom(LR.fatigue, "", 0.6f);
pulmonaryHypertensionDis.addSymptom(LR.neckVeinsElevated);
pulmonaryHypertensionDis.addSymptom(LR.syncope);
pulmonaryHypertensionDis.addSymptom(LR.weakness);
Treatment pulmonaryHypertensionTr1 = new Treatment("pulmonaryHypertensionTr1");
pulmonaryHypertensionTr1.addTreatmentAction(LR.oxygenTherapy);
pulmonaryHypertensionDis.addTreatment("pulmonaryHypertensionTr1");
Treatment pulmonaryHypertensionTr2 = new Treatment("pulmonaryHypertensionTr2", LR.ifRightSidedHeartFailure);
pulmonaryHypertensionTr2.addTreatmentAction(LR.fluidRestriction);
pulmonaryHypertensionTr2.addDrug(LR.diuretics);
pulmonaryHypertensionTr2.addDrug(LR.digitalisGlycosides);
pulmonaryHypertensionDis.addTreatment("pulmonaryHypertensionTr2");


// ------------- pulmonaryHypertensionPrimary  -------------
Disease pulmonaryHypertensionPrimaryDis = new Disease(
    LR.pulmonaryHypertensionPrimary,
    L.pulmonaryHypertensionPrimaryDescription,
    LR.respiratoryDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    40, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.pulmonaryArterySysSt,
    LR.none
);
pulmonaryHypertensionPrimaryDis.setPrintName(L.pulmonaryHypertensionPrimaryPrintName);
pulmonaryHypertensionPrimaryDis.setSuperDisease(LR.pulmonaryHypertension);
pulmonaryHypertensionPrimaryDis.setMiscComments(L.pulmonaryHypertensionPrimaryComment);
pulmonaryHypertensionPrimaryDis.addReference("pp 528-9");
Treatment pulmonaryHypertensionPrimaryTr1 = new Treatment("pulmonaryHypertensionPrimaryTr1");
pulmonaryHypertensionPrimaryTr1.addTreatmentAction(LR.heartLungTransplantation);
pulmonaryHypertensionPrimaryDis.addTreatment("pulmonaryHypertensionPrimaryTr1");


// ------------- pulmonaryHypertensionHypoventilation  -------------
Disease pulmonaryHypertensionHypoventilationDis = new Disease(
    LR.pulmonaryHypertensionHypoventilation,
    L.pulmonaryHypertensionHypoventilationDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.pulmonaryArterySysSt,
    LR.none
);
pulmonaryHypertensionHypoventilationDis.setPrintName(L.pulmonaryHypertensionHypoventilationPrintName);
pulmonaryHypertensionHypoventilationDis.setSuperDisease(LR.pulmonaryHypertension);
pulmonaryHypertensionHypoventilationDis.addInternalCause(LR.chronicObstructivePulmonaryDisease);
pulmonaryHypertensionHypoventilationDis.addInternalCause(LR.lungCancer);
pulmonaryHypertensionHypoventilationDis.addInternalCause(LR.sarcoidosis);
pulmonaryHypertensionHypoventilationDis.addInternalCause(LR.scleroderma);
pulmonaryHypertensionHypoventilationDis.addInternalCause(LR.silicosis);
pulmonaryHypertensionHypoventilationDis.addCausingAbnormalCondition(LR.hypoxemia);
pulmonaryHypertensionHypoventilationDis.addReference("pp 528");


// ------------- pulmonaryHypertensionVascularObstruction  -------------
Disease pulmonaryHypertensionVascularObstructionDis = new Disease(
    LR.pulmonaryHypertensionVascularObstruction,
    L.pulmonaryHypertensionVascularObstructionDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.pulmonaryArterySysSt,
    LR.none
);
pulmonaryHypertensionVascularObstructionDis.setPrintName(L.pulmonaryHypertensionVascularObstructionPrintName);
pulmonaryHypertensionVascularObstructionDis.setSuperDisease(LR.pulmonaryHypertension);
pulmonaryHypertensionVascularObstructionDis.addInternalCause(LR.pulmonaryEmbolism);
pulmonaryHypertensionVascularObstructionDis.addInternalCause(LR.vasculitis);
pulmonaryHypertensionVascularObstructionDis.addReference("pp 528");


// ------------- pulmonaryHypertensionCardiac  -------------
Disease pulmonaryHypertensionCardiacDis = new Disease(
    LR.pulmonaryHypertensionCardiac,
    L.pulmonaryHypertensionCardiacDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.pulmonaryArterySysSt,
    LR.none
);
pulmonaryHypertensionCardiacDis.setPrintName(L.pulmonaryHypertensionCardiacPrintName);
pulmonaryHypertensionCardiacDis.setSuperDisease(LR.pulmonaryHypertension);
pulmonaryHypertensionCardiacDis.addInternalCause(LR.mitralStenosis);
pulmonaryHypertensionCardiacDis.addInternalCause(LR.patentDuctusArteriosus);
pulmonaryHypertensionCardiacDis.addReference("pp 528");


// ------------- pleurisy  -------------
Disease pleurisyDis = new Disease(
    LR.pleurisy,
    L.pleurisyDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.chestTrauma
);
pleurisyDis.setPrintName(L.pleurisyPrintName);
pleurisyDis.addInternalCause(LR.lupusErythematosus);
pleurisyDis.addInternalCause(LR.pneumonia);
pleurisyDis.addInternalCause(LR.rheumatoidArthritis);
pleurisyDis.addInternalCause(LR.tuberculosis);
pleurisyDis.addInternalCause(LR.rheumatoidArthritis3);
pleurisyDis.addCausingAbnormalCondition(LR.uremia);
pleurisyDis.addReference("pp 531");
pleurisyDis.addSymptom(LR.dyspnea, "", 0.6f);
pleurisyDis.addSymptom(LR.stabbingChestPain);
Treatment pleurisyTr1 = new Treatment("pleurisyTr1");
pleurisyTr1.addTreatmentAction(LR.bedRest);
pleurisyTr1.addDrug(LR.analgetics);
pleurisyDis.addTreatment("pleurisyTr1");


// ------------- chronicObstructivePulmonaryDisease  -------------
Disease chronicObstructivePulmonaryDiseaseDis = new Disease(
    LR.chronicObstructivePulmonaryDisease,
    L.chronicObstructivePulmonaryDiseaseDescription,
    LR.respiratoryDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.airPollution
);
chronicObstructivePulmonaryDiseaseDis.setPrintName(L.chronicObstructivePulmonaryDiseasePrintName);
chronicObstructivePulmonaryDiseaseDis.addExternalCause(LR.chronicRespiratoryInfections);
chronicObstructivePulmonaryDiseaseDis.addInternalCause(LR.gastroesophagealReflux);
chronicObstructivePulmonaryDiseaseDis.addCausesDisease(LR.corPulmonale);
chronicObstructivePulmonaryDiseaseDis.addCausesAbnormalCondition(LR.hypoxemia);
chronicObstructivePulmonaryDiseaseDis.addReference("pp 531-537");
chronicObstructivePulmonaryDiseaseDis.addSymptom(LR.coughProductive);
chronicObstructivePulmonaryDiseaseDis.addSymptom(LR.dyspnea);
Treatment chronicObstructivePulmonaryDiseaseTr1 = new Treatment("chronicObstructivePulmonaryDiseaseTr1");
chronicObstructivePulmonaryDiseaseTr1.addDrug(LR.betaAgonistBronchodilator);
chronicObstructivePulmonaryDiseaseTr1.addDrug(LR.albuterol);
chronicObstructivePulmonaryDiseaseTr1.addDrug(LR.salmeterol);
chronicObstructivePulmonaryDiseaseTr1.addDrug(LR.anticholinergicBronchodilator);
chronicObstructivePulmonaryDiseaseTr1.addDrug(LR.ipratropium);
chronicObstructivePulmonaryDiseaseTr1.addDrug(LR.corticosteroids);
chronicObstructivePulmonaryDiseaseTr1.addDrug(LR.beclomethasone);
chronicObstructivePulmonaryDiseaseTr1.addDrug(LR.triamcinolone);
chronicObstructivePulmonaryDiseaseDis.addTreatment("chronicObstructivePulmonaryDiseaseTr1");
Treatment chronicObstructivePulmonaryDiseaseTr2 = new Treatment("chronicObstructivePulmonaryDiseaseTr2");
chronicObstructivePulmonaryDiseaseTr2.addTreatmentAction(LR.oxygenTherapy);
chronicObstructivePulmonaryDiseaseTr2.addDrug(LR.ifInfectionProvideAntibiotic);
chronicObstructivePulmonaryDiseaseDis.addTreatment("chronicObstructivePulmonaryDiseaseTr2");
Treatment chronicObstructivePulmonaryDiseaseTr3 = new Treatment("chronicObstructivePulmonaryDiseaseTr3");
chronicObstructivePulmonaryDiseaseDis.addTreatment("chronicObstructivePulmonaryDiseaseTr3");


// ------------- emphysema  -------------
Disease emphysemaDis = new Disease(
    LR.emphysema,
    L.emphysemaDescription,
    LR.respiratoryDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.lifeStyle
);
emphysemaDis.setPrintName(L.emphysemaPrintName);
emphysemaDis.setSuperDisease(LR.chronicObstructivePulmonaryDisease);
emphysemaDis.addExternalCause(LR.cigaretteSmoking);
emphysemaDis.setCode358(266);
emphysemaDis.setICD10code("J43");
emphysemaDis.addInternalCause(LR.coalWorkerPneumoconiosis);
emphysemaDis.addInternalCause(LR.cysticFibrosis);
emphysemaDis.addCausesAbnormalCondition(LR.death);
emphysemaDis.addCausesAbnormalCondition(LR.recurrentRespiratoryTractInfections);
emphysemaDis.addCausesAbnormalCondition(LR.respiratoryFailure);
emphysemaDis.addReference("pp 532-3");
emphysemaDis.addSymptom(LR.anorexia);
emphysemaDis.addSymptom(LR.barrelChest);
emphysemaDis.addSymptom(LR.grunting);
emphysemaDis.addSymptom(LR.malaise);
emphysemaDis.addSymptom(LR.pursedLipBreathing);
emphysemaDis.addSymptom(LR.tachypnea);
emphysemaDis.addSymptom(LR.weightLoss);


// ------------- chronicBronchitis  -------------
Disease chronicBronchitisDis = new Disease(
    LR.chronicBronchitis,
    L.chronicBronchitisDescription,
    LR.respiratoryDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.lifeStyle
);
chronicBronchitisDis.setPrintName(L.chronicBronchitisPrintName);
chronicBronchitisDis.setSuperDisease(LR.chronicObstructivePulmonaryDisease);
chronicBronchitisDis.addExternalCause(LR.cigaretteSmoking);
chronicBronchitisDis.setCode358(265);
chronicBronchitisDis.setICD10code("J41");
chronicBronchitisDis.addInternalCause(LR.coalWorkerPneumoconiosis);
chronicBronchitisDis.addSymptom(LR.cyanosis);
chronicBronchitisDis.addSymptom(LR.prolongedExpiration);
chronicBronchitisDis.addSymptom(LR.sputumProduction);
chronicBronchitisDis.addSymptom(LR.tachypnea);
chronicBronchitisDis.addSymptom(LR.weightGain);
chronicBronchitisDis.addSymptom(LR.wheezing);
Treatment chronicBronchitisTr1 = new Treatment("chronicBronchitisTr1");
chronicBronchitisTr1.addDrug(LR.diuretics);
chronicBronchitisDis.addTreatment("chronicBronchitisTr1");


// ------------- chronicAsthma  -------------
Disease chronicAsthmaDis = new Disease(
    LR.chronicAsthma,
    L.chronicAsthmaDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.lifeStyle
);
chronicAsthmaDis.setPrintName(L.chronicAsthmaPrintName);
chronicAsthmaDis.setSuperDisease(LR.chronicObstructivePulmonaryDisease);
chronicAsthmaDis.setMiscComments(L.chronicAsthmaComment);
chronicAsthmaDis.addExternalCause(LR.cigaretteSmoking);
chronicAsthmaDis.addExternalCause(LR.coughing);
chronicAsthmaDis.addExternalCause(LR.laughing);
chronicAsthmaDis.addExternalCause(LR.anxiety);
chronicAsthmaDis.addExternalCause(LR.upperAirwayInfection);
chronicAsthmaDis.setCode358(268);
chronicAsthmaDis.setICD10code("J46");
chronicAsthmaDis.addInternalCause(LR.asthma);
chronicAsthmaDis.addCausesAbnormalCondition(LR.death);
chronicAsthmaDis.addCausesAbnormalCondition(LR.respiratoryFailure);
chronicAsthmaDis.addReference("pp 534-5");
chronicAsthmaDis.addSymptom(LR.chestTightness);
chronicAsthmaDis.addSymptom(LR.eczema);
chronicAsthmaDis.addSymptom(LR.flaringNostrils);
chronicAsthmaDis.addSymptom(LR.flushing);
chronicAsthmaDis.addSymptom(LR.perspiration);
chronicAsthmaDis.addSymptom(LR.prolongedExpiration);
chronicAsthmaDis.addSymptom(LR.tachycardia);
chronicAsthmaDis.addSymptom(LR.tachypnea);
chronicAsthmaDis.addSymptom(LR.thickMucus);
chronicAsthmaDis.addSymptom(LR.wheezing);
Treatment chronicAsthmaTr1 = new Treatment("chronicAsthmaTr1");
chronicAsthmaTr1.addDrug(LR.metaproterenol);
chronicAsthmaTr1.addDrug(LR.terbutaline);
chronicAsthmaTr1.addDrug(LR.theophylline);
chronicAsthmaDis.addTreatment("chronicAsthmaTr1");
Treatment chronicAsthmaTr2 = new Treatment("chronicAsthmaTr2", LR.ifSevere);
chronicAsthmaTr2.addDrug(LR.IVTheophylline);
chronicAsthmaTr2.addDrug(LR.corticosteroids);
chronicAsthmaTr2.addDrug(LR.epinephrine);
chronicAsthmaTr2.addDrug(LR.ipratropiumBromide);
chronicAsthmaDis.addTreatment("chronicAsthmaTr2");


// ------------- bronchiectasis  -------------
Disease bronchiectasisDis = new Disease(
    LR.bronchiectasis,
    L.bronchiectasisDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.aspirationGastricContents
);
bronchiectasisDis.setPrintName(L.bronchiectasisPrintName);
bronchiectasisDis.setMiscComments(L.bronchiectasisComment);
bronchiectasisDis.addExternalCause(LR.chemicalInhalation);
bronchiectasisDis.setTemperature(99.8f);
bronchiectasisDis.setCode358(269);
bronchiectasisDis.setICD10code("J47");
bronchiectasisDis.addInternalCause(LR.cysticFibrosis);
bronchiectasisDis.addInternalCause(LR.lungAbscess);
bronchiectasisDis.addCausingSet(LR.immuneDisorders);
bronchiectasisDis.addCausingSet(LR.respiratoryTractInfections);
bronchiectasisDis.addCausesDisease(LR.corPulmonale);
bronchiectasisDis.addCausesDisease(LR.heartFailureRightSided);
bronchiectasisDis.addCausesDisease(LR.anemia);
bronchiectasisDis.addCausesDisease(LR.sinusitis);
bronchiectasisDis.addCausesAbnormalCondition(LR.hypoxemia);
bronchiectasisDis.addReference("pp 537-9");
bronchiectasisDis.addSymptom(LR.coughProductiveFoulSmelling);
bronchiectasisDis.addSymptom(LR.crackles);
bronchiectasisDis.addSymptom(LR.dyspnea);
bronchiectasisDis.addSymptom(LR.hemoptysis);
bronchiectasisDis.addSymptom(LR.malaise);
bronchiectasisDis.addSymptom(LR.weightLoss);
bronchiectasisDis.addSymptom(LR.wheezing);
Treatment bronchiectasisTr1 = new Treatment("bronchiectasisTr1");
bronchiectasisTr1.addTreatmentAction(LR.bronchoscopy);
bronchiectasisTr1.addTreatmentAction(LR.chestPercussion);
bronchiectasisTr1.addTreatmentAction(LR.posturalDrainage);
bronchiectasisTr1.addDrug(LR.antibiotics);
bronchiectasisTr1.addDrug(LR.bronchodilator);
bronchiectasisDis.addTreatment("bronchiectasisTr1");
Treatment bronchiectasisTr2 = new Treatment("bronchiectasisTr2", LR.ifSevereHemoptysis);
bronchiectasisTr2.addTreatmentAction(LR.lobectomy);
bronchiectasisDis.addTreatment("bronchiectasisTr2");


// ------------- idiopathicPulmonaryFibrosis  -------------
Disease idiopathicPulmonaryFibrosisDis = new Disease(
    LR.idiopathicPulmonaryFibrosis,
    L.idiopathicPulmonaryFibrosisDescription,
    LR.respiratoryDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    50, // minAge
    70, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.none
);
idiopathicPulmonaryFibrosisDis.setPrintName(L.idiopathicPulmonaryFibrosisPrintName);
idiopathicPulmonaryFibrosisDis.setMiscComments(L.idiopathicPulmonaryFibrosisComment);
idiopathicPulmonaryFibrosisDis.addInternalCause(LR.ankylosingSpondylitis);
idiopathicPulmonaryFibrosisDis.addCausesDisease(LR.pulmonaryHypertension);
idiopathicPulmonaryFibrosisDis.addCausesAbnormalCondition(LR.hypoxia);
idiopathicPulmonaryFibrosisDis.addReference("pp 539-42");
idiopathicPulmonaryFibrosisDis.addSymptom(LR.coughHacking);
idiopathicPulmonaryFibrosisDis.addSymptom(LR.crackles);
idiopathicPulmonaryFibrosisDis.addSymptom(LR.cyanosis);
idiopathicPulmonaryFibrosisDis.addSymptom(LR.dyspnea);
idiopathicPulmonaryFibrosisDis.addSymptom(LR.tachypnea);
idiopathicPulmonaryFibrosisDis.addSymptom(LR.respirationShallow);
Treatment idiopathicPulmonaryFibrosisTr1 = new Treatment("idiopathicPulmonaryFibrosisTr1");
idiopathicPulmonaryFibrosisTr1.addTreatmentAction(LR.oxygenTherapy);
idiopathicPulmonaryFibrosisTr1.addDrug(LR.corticosteroids);
idiopathicPulmonaryFibrosisTr1.addDrug(LR.cyclophosphamide);
idiopathicPulmonaryFibrosisTr1.addDrug(LR.colchicine);
idiopathicPulmonaryFibrosisDis.addTreatment("idiopathicPulmonaryFibrosisTr1");


// ------------- tuberculosis  -------------
Disease tuberculosisDis = new Disease(
    LR.tuberculosis,
    L.tuberculosisDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    F.tuberculosisFreq, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.infection
);
tuberculosisDis.setPrintName(L.tuberculosisPrintName);
tuberculosisDis.setCode358(12);
tuberculosisDis.setICD10code("A16");
tuberculosisDis.addInternalCause(LR.coalWorkerPneumoconiosis);
tuberculosisDis.addReference("pp 542-4");
tuberculosisDis.addSymptom(LR.anorexia);
tuberculosisDis.addSymptom(LR.chestPain, "", 0.3f);
tuberculosisDis.addSymptom(LR.cough);
tuberculosisDis.addSymptom(LR.fatigue);
tuberculosisDis.addSymptom(LR.hemoptysis, "", 0.3f);
tuberculosisDis.addSymptom(LR.nightSweating);
tuberculosisDis.addSymptom(LR.sputumMucopurulent);
tuberculosisDis.addSymptom(LR.weakness);
tuberculosisDis.addSymptom(LR.weightLoss);
Treatment tuberculosisTr1 = new Treatment("tuberculosisTr1");
tuberculosisTr1.addDrug(LR.isoniazid);
tuberculosisTr1.addDrug(LR.rifampin);
tuberculosisTr1.addDrug(LR.pirazinamide);
tuberculosisDis.addTreatment("tuberculosisTr1");


// ------------- silicosis  -------------
Disease silicosisDis = new Disease(
    LR.silicosis,
    L.silicosisDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    20, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.silicaExposure
);
silicosisDis.setPrintName(L.silicosisPrintName);
silicosisDis.setMiscComments(L.silicosisComment);
silicosisDis.addCausesDisease(LR.pulmonaryHypertensionHypoventilation);
silicosisDis.addCausesAbnormalCondition(LR.hypoxemia);
silicosisDis.addReference("pp 544-5");
silicosisDis.addSymptom(LR.confusion, L.silicosis_confusion, 1.0f);
silicosisDis.addSymptom(LR.coughDry);
silicosisDis.addSymptom(LR.dyspnea);
silicosisDis.addSymptom(LR.hoarseness);
silicosisDis.addSymptom(LR.lethargy, L.silicosis_lethargy, 1.0f);
silicosisDis.addSymptom(LR.malaise);
silicosisDis.addSymptom(LR.respirationShallow, L.silicosis_respirationShallow, 1.0f);
silicosisDis.addSymptom(LR.sleepDisturbed);
silicosisDis.addSymptom(LR.tachypnea);
Treatment silicosisTr1 = new Treatment("silicosisTr1");
silicosisTr1.addTreatmentAction(LR.chestPercussion);
silicosisTr1.addTreatmentAction(LR.ifInfectionProvideAntibiotic);
silicosisTr1.addTreatmentAction(LR.fluidIncrease);
silicosisTr1.addTreatmentAction(LR.steamInhalation);
silicosisTr1.addDrug(LR.bronchodilator);
silicosisDis.addTreatment("silicosisTr1");


// ------------- asbestosis  -------------
Disease asbestosisDis = new Disease(
    LR.asbestosis,
    L.asbestosisDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.regularAsbestosExposure
);
asbestosisDis.setPrintName(L.asbestosisPrintName);
asbestosisDis.setMiscComments(L.asbestosisComment);
asbestosisDis.addCausingSet(LR.respiratoryTractInfections);
asbestosisDis.addCausesDisease(LR.corPulmonale);
asbestosisDis.addCausesDisease(LR.pulmonaryHypertension);
asbestosisDis.addCausesAbnormalCondition(LR.hypoxemia);
asbestosisDis.addReference("pp 545-7");
asbestosisDis.addSymptom(LR.chestPain);
asbestosisDis.addSymptom(LR.coughDry);
asbestosisDis.addSymptom(LR.dyspnea);
asbestosisDis.addSymptom(LR.tachypnea);
asbestosisDis.addSymptom(LR.weightLoss);
Treatment asbestosisTr1 = new Treatment("asbestosisTr1");
asbestosisTr1.addTreatmentAction(LR.chestPercussion);
asbestosisTr1.addTreatmentAction(LR.coughingExercise);
asbestosisTr1.addTreatmentAction(LR.fluidIncrease);
asbestosisTr1.addTreatmentAction(LR.ifInfectionProvideAntibiotic);
asbestosisTr1.addTreatmentAction(LR.bronchialDrainage);
asbestosisTr1.addDrug(LR.mucolytics);
asbestosisDis.addTreatment("asbestosisTr1");


// ------------- berylliosis  -------------
Disease berylliosisDis = new Disease(
    LR.berylliosis,
    L.berylliosisDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.respiratorySysSt,
    LR.berylliumInhalation
);
berylliosisDis.setPrintName(L.berylliosisPrintName);
berylliosisDis.setMiscComments(L.berylliosisComment);
berylliosisDis.addExternalCause(LR.berylliumSkinAbsorption);
berylliosisDis.addReference("pp 547-8");


// ------------- berylliosisAcute  -------------
Disease berylliosisAcuteDis = new Disease(
    LR.berylliosisAcute,
    L.berylliosisAcuteDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.respiratorySysSt,
    LR.none
);
berylliosisAcuteDis.setPrintName(L.berylliosisAcutePrintName);
berylliosisAcuteDis.setSuperDisease(LR.berylliosis);
berylliosisAcuteDis.setMiscComments(L.berylliosisAcuteComment);
berylliosisAcuteDis.addCausesAbnormalCondition(LR.hypoxemia);
berylliosisAcuteDis.addCausesAbnormalCondition(LR.tracheitis);
berylliosisAcuteDis.addCausesAbnormalCondition(LR.respiratoryFailure);
berylliosisAcuteDis.addReference("pp 547-8");
berylliosisAcuteDis.addSymptom(LR.chestTightness);
berylliosisAcuteDis.addSymptom(LR.coughDry);
berylliosisAcuteDis.addSymptom(LR.noseMucosaSwelling);
berylliosisAcuteDis.addSymptom(LR.noseMucosaUlceration);
berylliosisAcuteDis.addSymptom(LR.rashItchy);
berylliosisAcuteDis.addSymptom(LR.substernalPain);
berylliosisAcuteDis.addSymptom(LR.tachycardia);
berylliosisAcuteDis.addSymptom(LR.noseSeptumPerforation);
Treatment berylliosisAcuteTr1 = new Treatment("berylliosisAcuteTr1", LR.ifBerylliumUlcer);
berylliosisAcuteTr1.addTreatmentAction(LR.excision);
berylliosisAcuteDis.addTreatment("berylliosisAcuteTr1");
Treatment berylliosisAcuteTr2 = new Treatment("berylliosisAcuteTr2");
berylliosisAcuteTr2.addDrug(LR.corticosteroids);
berylliosisAcuteDis.addTreatment("berylliosisAcuteTr2");


// ------------- berylliosisChronic  -------------
Disease berylliosisChronicDis = new Disease(
    LR.berylliosisChronic,
    L.berylliosisChronicDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.none
);
berylliosisChronicDis.setPrintName(L.berylliosisChronicPrintName);
berylliosisChronicDis.setSuperDisease(LR.berylliosis);
berylliosisChronicDis.setMiscComments(L.berylliosisChronicComment);
berylliosisChronicDis.addCausesDisease(LR.corPulmonale);
berylliosisChronicDis.addCausesDisease(LR.pneumothorax);
berylliosisChronicDis.addCausesDisease(LR.pulmonaryHypertension);
berylliosisChronicDis.addCausesDisease(LR.renalCalculi);
berylliosisChronicDis.addCausesAbnormalCondition(LR.splenomegaly);
berylliosisChronicDis.addReference("pp 547-8");
berylliosisChronicDis.addSymptom(LR.anorexia);
berylliosisChronicDis.addSymptom(LR.chestPain);
berylliosisChronicDis.addSymptom(LR.coughDry);
berylliosisChronicDis.addSymptom(LR.dyspnea);
berylliosisChronicDis.addSymptom(LR.fatigue);
berylliosisChronicDis.addSymptom(LR.tachypnea);
Treatment berylliosisChronicTr1 = new Treatment("berylliosisChronicTr1");
berylliosisChronicTr1.addDrug(LR.corticosteroids);
berylliosisChronicDis.addTreatment("berylliosisChronicTr1");


// ------------- coalWorkerPneumoconiosis  -------------
Disease coalWorkerPneumoconiosisDis = new Disease(
    LR.coalWorkerPneumoconiosis,
    L.coalWorkerPneumoconiosisDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.lungsSysSt,
    LR.coalDustInhalation
);
coalWorkerPneumoconiosisDis.setPrintName(L.coalWorkerPneumoconiosisPrintName);
coalWorkerPneumoconiosisDis.setMiscComments(L.coalWorkerPneumoconiosisComment);
coalWorkerPneumoconiosisDis.addCausesDisease(LR.chronicBronchitis);
coalWorkerPneumoconiosisDis.addCausesDisease(LR.corPulmonale);
coalWorkerPneumoconiosisDis.addCausesDisease(LR.emphysema);
coalWorkerPneumoconiosisDis.addCausesDisease(LR.pulmonaryHypertension);
coalWorkerPneumoconiosisDis.addCausesDisease(LR.tuberculosis);
coalWorkerPneumoconiosisDis.addCausesAbnormalCondition(LR.hypoxemia);
coalWorkerPneumoconiosisDis.addReference("pp 548-9");
coalWorkerPneumoconiosisDis.addSymptom(LR.cough);
coalWorkerPneumoconiosisDis.addSymptom(LR.coughProductive);
coalWorkerPneumoconiosisDis.addSymptom(LR.dyspnea);
coalWorkerPneumoconiosisDis.addSymptom(LR.sputumBlack);
coalWorkerPneumoconiosisDis.addSymptom(LR.sputumGray);
coalWorkerPneumoconiosisDis.addSymptom(LR.sputumYellowGreenThick);
Treatment coalWorkerPneumoconiosisTr1 = new Treatment("coalWorkerPneumoconiosisTr1");
coalWorkerPneumoconiosisTr1.addTreatmentAction(LR.bronchialDrainage);
coalWorkerPneumoconiosisTr1.addTreatmentAction(LR.chestPercussion);
coalWorkerPneumoconiosisTr1.addTreatmentAction(LR.coughingExercise);
coalWorkerPneumoconiosisTr1.addTreatmentAction(LR.fluidIncrease);
coalWorkerPneumoconiosisTr1.addDrug(LR.bronchodilator);
coalWorkerPneumoconiosisTr1.addDrug(LR.mucolytics);
coalWorkerPneumoconiosisDis.addTreatment("coalWorkerPneumoconiosisTr1");


// ------------- respiratoryFailureAcute  -------------
Disease respiratoryFailureAcuteDis = new Disease(
    LR.respiratoryFailureAcute,
    L.respiratoryFailureAcuteDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.respiratorySysSt,
    LR.none
);
respiratoryFailureAcuteDis.setPrintName(L.respiratoryFailureAcutePrintName);
respiratoryFailureAcuteDis.addInternalCause(LR.muscularDystrophyBecker);
respiratoryFailureAcuteDis.addInternalCause(LR.muscularDystrophyDuchenne);
respiratoryFailureAcuteDis.addCausesDisease(LR.pulmonaryHypertension);
respiratoryFailureAcuteDis.addReference("pp 0");
respiratoryFailureAcuteDis.addSymptom(LR.airHunger);
respiratoryFailureAcuteDis.addSymptom(LR.confusion);
respiratoryFailureAcuteDis.addSymptom(LR.consciousnessDecreased);
respiratoryFailureAcuteDis.addSymptom(LR.cyanosis);
respiratoryFailureAcuteDis.addSymptom(LR.irritability);
respiratoryFailureAcuteDis.addSymptom(LR.respirationDeep, "", 0.5f);
respiratoryFailureAcuteDis.addSymptom(LR.respirationShallow, "", 0.5f);
respiratoryFailureAcuteDis.addSymptom(LR.respirationSporadic);
respiratoryFailureAcuteDis.addSymptom(LR.tachycardia);
Treatment respiratoryFailureAcuteTr1 = new Treatment("respiratoryFailureAcuteTr1");
respiratoryFailureAcuteTr1.addTreatmentAction(LR.bedRest);
respiratoryFailureAcuteTr1.addTreatmentAction(LR.fluidManagement);
respiratoryFailureAcuteTr1.addTreatmentAction(LR.oxygenTherapy);
respiratoryFailureAcuteTr1.addDrug(LR.antibiotics);
respiratoryFailureAcuteDis.addTreatment("respiratoryFailureAcuteTr1");


// ------------- asphyxia  -------------
Disease asphyxiaDis = new Disease(
    LR.asphyxia,
    L.asphyxiaDescription,
    LR.respiratoryDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.respiratorySysSt,
    LR.narcoticsMisuse
);
asphyxiaDis.setPrintName(L.asphyxiaPrintName);
asphyxiaDis.setMiscComments(L.asphyxiaComment);
asphyxiaDis.addExternalCause(LR.inhalationOfToxicAgents);
asphyxiaDis.addExternalCause(LR.nearDrowning);
asphyxiaDis.addExternalCause(LR.strangulation);
asphyxiaDis.addExternalCause(LR.suffocation);
asphyxiaDis.addInternalCause(LR.asthma);
asphyxiaDis.addInternalCause(LR.pneumonia);
asphyxiaDis.addInternalCause(LR.pulmonaryEdema);
asphyxiaDis.addInternalCause(LR.pneumothorax);
asphyxiaDis.addCausingAbnormalCondition(LR.airwayObstruction);
asphyxiaDis.addReference("pp 308");
asphyxiaDis.addSymptom(LR.agitation);
asphyxiaDis.addSymptom(LR.anxiety);
asphyxiaDis.addSymptom(LR.apnea);
asphyxiaDis.addSymptom(LR.bradypnea);
asphyxiaDis.addSymptom(LR.breathlessness);
asphyxiaDis.addSymptom(LR.confusion);
asphyxiaDis.addSymptom(LR.consciousnessDecreased);
asphyxiaDis.addSymptom(LR.cyanosis);
asphyxiaDis.addSymptom(LR.dyspnea);
asphyxiaDis.addSymptom(LR.hypoventilation);
asphyxiaDis.addSymptom(LR.tachypnea);
Treatment asphyxiaTr1 = new Treatment("asphyxiaTr1");
asphyxiaTr1.addTreatmentAction(LR.CPR);
asphyxiaTr1.addTreatmentAction(LR.endotrachealIntubation);
asphyxiaTr1.addTreatmentAction(LR.oxygenTherapy);
asphyxiaDis.addTreatment("asphyxiaTr1");
Treatment asphyxiaTr2 = new Treatment("asphyxiaTr2", LR.ifObstructingObject);
asphyxiaTr2.addTreatmentAction(LR.bronchoscopy);
asphyxiaDis.addTreatment("asphyxiaTr2");
Treatment asphyxiaTr3 = new Treatment("asphyxiaTr3", LR.ifNarcoticOverdose);
asphyxiaTr3.addDrug(LR.naloxone);
asphyxiaDis.addTreatment("asphyxiaTr3");
Treatment asphyxiaTr4 = new Treatment("asphyxiaTr4", LR.ifPoisoned);
asphyxiaTr4.addTreatmentAction(LR.gastricLavage);
asphyxiaDis.addTreatment("asphyxiaTr4");
} // end of respiratoryDisorders





// ------------- sexualDisorders  -------------
static public void sexualDisorders() { 


// ------------- gonorrhea  -------------
Disease gonorrheaDis = new Disease(
    LR.gonorrhea,
    L.gonorrheaDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.gonorrheaFreq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.gonorrheaInfection
);
gonorrheaDis.setPrintName(L.gonorrheaPrintName);
gonorrheaDis.setMiscComments(L.gonorrheaComment);
gonorrheaDis.setCode358(30);
gonorrheaDis.setICD10code("A54");
gonorrheaDis.addCausesDisease(LR.pharyngitisGonorrhea);
gonorrheaDis.addCausesDisease(LR.tonsillitis);
gonorrheaDis.addCausesDisease(LR.gonococcalSepticemia);
gonorrheaDis.addReference("pp 983-5");
gonorrheaDis.addIllustration(D.GonococcalOphthalmiaJpg);
gonorrheaDis.addIllustration(D.GonorrheaSkinLesion1Jpg);
gonorrheaDis.addIllustration(D.GonorrheaSkinLesion2Jpg);
Treatment gonorrheaTr1 = new Treatment("gonorrheaTr1");
gonorrheaTr1.addDrug(LR.ceftriaxone);
gonorrheaDis.addTreatment("gonorrheaTr1");


// ------------- gonorrheaRectum  -------------
Disease gonorrheaRectumDis = new Disease(
    LR.gonorrheaRectum,
    L.gonorrheaRectumDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.gonorrheaRectumFreq, // diagnosis frequency, -1 = unknown
    LR.rectumSysSt,
    LR.none
);
gonorrheaRectumDis.setPrintName(L.gonorrheaRectumPrintName);
gonorrheaRectumDis.setSuperDisease(LR.gonorrhea);
gonorrheaRectumDis.setCode358(30);
gonorrheaRectumDis.setICD10code("A54");
gonorrheaRectumDis.addReference("pp 983-5");
gonorrheaRectumDis.addIllustration(D.GonococcalOphthalmiaJpg);
gonorrheaRectumDis.addIllustration(D.GonorrheaSkinLesion1Jpg);
gonorrheaRectumDis.addIllustration(D.GonorrheaSkinLesion2Jpg);
gonorrheaRectumDis.addSymptom(LR.rectumBloodyDischarge);
gonorrheaRectumDis.addSymptom(LR.rectumBurning);
gonorrheaRectumDis.addSymptom(LR.rectumItching);


// ------------- gonorrheaUrethraMale  -------------
Disease gonorrheaUrethraMaleDis = new Disease(
    LR.gonorrheaUrethraMale,
    L.gonorrheaUrethraMaleDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.gonorrheaUrethraMaleFreq, // diagnosis frequency, -1 = unknown
    LR.urethraMLSysSt,
    LR.none
);
gonorrheaUrethraMaleDis.setPrintName(L.gonorrheaUrethraMalePrintName);
gonorrheaUrethraMaleDis.setSuperDisease(LR.gonorrhea);
gonorrheaUrethraMaleDis.setCode358(30);
gonorrheaUrethraMaleDis.setICD10code("A54");
gonorrheaUrethraMaleDis.addReference("pp 983-5");
gonorrheaUrethraMaleDis.addIllustration(D.GonococcalUrethritisJpg);
gonorrheaUrethraMaleDis.addIllustration(D.GonococcalOphthalmiaJpg);
gonorrheaUrethraMaleDis.addIllustration(D.GonorrheaSkinLesion1Jpg);
gonorrheaUrethraMaleDis.addIllustration(D.GonorrheaSkinLesion2Jpg);
gonorrheaUrethraMaleDis.addSymptom(LR.dysuria);
gonorrheaUrethraMaleDis.addSymptom(LR.urethraMaleDischargePurulent);
gonorrheaUrethraMaleDis.addSymptom(LR.urinationPainful);


// ------------- gonorrheaFemale  -------------
Disease gonorrheaFemaleDis = new Disease(
    LR.gonorrheaFemale,
    L.gonorrheaFemaleDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.gonorrheaFemaleFreq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
gonorrheaFemaleDis.setPrintName(L.gonorrheaFemalePrintName);
gonorrheaFemaleDis.setSuperDisease(LR.gonorrhea);
gonorrheaFemaleDis.setCode358(30);
gonorrheaFemaleDis.setICD10code("A54");
gonorrheaFemaleDis.addReference("pp 983-5");
gonorrheaFemaleDis.addIllustration(D.GonococcalOphthalmiaJpg);
gonorrheaFemaleDis.addIllustration(D.GonorrheaSkinLesion1Jpg);
gonorrheaFemaleDis.addIllustration(D.GonorrheaSkinLesion2Jpg);
gonorrheaFemaleDis.addSymptom(LR.cervixDischargeGreenYellow);


// ------------- gonorrheaUrethraFemale  -------------
Disease gonorrheaUrethraFemaleDis = new Disease(
    LR.gonorrheaUrethraFemale,
    L.gonorrheaUrethraFemaleDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.gonorrheaUrethraFemaleFreq, // diagnosis frequency, -1 = unknown
    LR.urethraFMSysSt,
    LR.none
);
gonorrheaUrethraFemaleDis.setPrintName(L.gonorrheaUrethraFemalePrintName);
gonorrheaUrethraFemaleDis.setSuperDisease(LR.gonorrheaFemale);
gonorrheaUrethraFemaleDis.setCode358(30);
gonorrheaUrethraFemaleDis.setICD10code("A54");
gonorrheaUrethraFemaleDis.addReference("pp 983-5");
gonorrheaUrethraFemaleDis.addIllustration(D.GonococcalOphthalmiaJpg);
gonorrheaUrethraFemaleDis.addIllustration(D.GonorrheaSkinLesion1Jpg);
gonorrheaUrethraFemaleDis.addIllustration(D.GonorrheaSkinLesion2Jpg);
gonorrheaUrethraFemaleDis.addSymptom(LR.dysuria);
gonorrheaUrethraFemaleDis.addSymptom(LR.urinaryFrequency);
gonorrheaUrethraFemaleDis.addSymptom(LR.incontinence);
gonorrheaUrethraFemaleDis.addSymptom(LR.urethraFemaleDischargePurulent);
gonorrheaUrethraFemaleDis.addSymptom(LR.urethraFemaleItching);
gonorrheaUrethraFemaleDis.addSymptom(LR.urethraFemaleRed);
gonorrheaUrethraFemaleDis.addSymptom(LR.urethraFemaleSwollen);


// ------------- gonorrheaVulva  -------------
Disease gonorrheaVulvaDis = new Disease(
    LR.gonorrheaVulva,
    L.gonorrheaVulvaDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.gonorrheaVulvaFreq, // diagnosis frequency, -1 = unknown
    LR.vulvaSysSt,
    LR.none
);
gonorrheaVulvaDis.setPrintName(L.gonorrheaVulvaPrintName);
gonorrheaVulvaDis.setSuperDisease(LR.gonorrheaFemale);
gonorrheaVulvaDis.setCode358(30);
gonorrheaVulvaDis.setICD10code("A54");
gonorrheaVulvaDis.addReference("pp 983-5");
gonorrheaVulvaDis.addIllustration(D.GonococcalOphthalmiaJpg);
gonorrheaVulvaDis.addIllustration(D.GonorrheaSkinLesion1Jpg);
gonorrheaVulvaDis.addIllustration(D.GonorrheaSkinLesion2Jpg);
gonorrheaVulvaDis.addSymptom(LR.vulvaItching);
gonorrheaVulvaDis.addSymptom(LR.vulvaBurning);
gonorrheaVulvaDis.addSymptom(LR.vulvaPain);


// ------------- gonorrheaVagina  -------------
Disease gonorrheaVaginaDis = new Disease(
    LR.gonorrheaVagina,
    L.gonorrheaVaginaDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.gonorrheaVaginaFreq, // diagnosis frequency, -1 = unknown
    LR.vaginagySysSt,
    LR.none
);
gonorrheaVaginaDis.setPrintName(L.gonorrheaVaginaPrintName);
gonorrheaVaginaDis.setSuperDisease(LR.gonorrheaFemale);
gonorrheaVaginaDis.setCode358(30);
gonorrheaVaginaDis.setICD10code("A54");
gonorrheaVaginaDis.addReference("pp 983-5");
gonorrheaVaginaDis.addIllustration(D.GonococcalCervicitisJpg);
gonorrheaVaginaDis.addIllustration(D.GonococcalOphthalmiaJpg);
gonorrheaVaginaDis.addIllustration(D.GonorrheaSkinLesion1Jpg);
gonorrheaVaginaDis.addIllustration(D.GonorrheaSkinLesion2Jpg);
gonorrheaVaginaDis.addSymptom(LR.vaginaRed);
gonorrheaVaginaDis.addSymptom(LR.vaginaSwollen);
gonorrheaVaginaDis.addSymptom(LR.vaginaDischargePurulent);


// ------------- gonorrheaLiver  -------------
Disease gonorrheaLiverDis = new Disease(
    LR.gonorrheaLiver,
    L.gonorrheaLiverDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.gonorrheaLiverFreq, // diagnosis frequency, -1 = unknown
    LR.liverSysSt,
    LR.none
);
gonorrheaLiverDis.setPrintName(L.gonorrheaLiverPrintName);
gonorrheaLiverDis.setSuperDisease(LR.gonorrhea);
gonorrheaLiverDis.setCode358(30);
gonorrheaLiverDis.setICD10code("A54");
gonorrheaLiverDis.addReference("pp 983-5");
gonorrheaLiverDis.addIllustration(D.GonococcalOphthalmiaJpg);
gonorrheaLiverDis.addIllustration(D.GonorrheaSkinLesion1Jpg);
gonorrheaLiverDis.addIllustration(D.GonorrheaSkinLesion2Jpg);
gonorrheaLiverDis.addSymptom(LR.liverPain);


// ------------- gonorrheaPelvis  -------------
Disease gonorrheaPelvisDis = new Disease(
    LR.gonorrheaPelvis,
    L.gonorrheaPelvisDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.gonorrheaPelvisFreq, // diagnosis frequency, -1 = unknown
    LR.pelvisSysSt,
    LR.none
);
gonorrheaPelvisDis.setPrintName(L.gonorrheaPelvisPrintName);
gonorrheaPelvisDis.setSuperDisease(LR.gonorrheaFemale);
gonorrheaPelvisDis.setCode358(30);
gonorrheaPelvisDis.setICD10code("A54");
gonorrheaPelvisDis.addCausesDisease(LR.pelvisInflammatoryDisease);
gonorrheaPelvisDis.addCausesDisease(LR.salpingoOophoritis);
gonorrheaPelvisDis.addReference("pp 983-5");
gonorrheaPelvisDis.addIllustration(D.GonococcalOphthalmiaJpg);
gonorrheaPelvisDis.addIllustration(D.GonorrheaSkinLesion1Jpg);
gonorrheaPelvisDis.addIllustration(D.GonorrheaSkinLesion2Jpg);
gonorrheaPelvisDis.addSymptom(LR.abdomenDistension);
gonorrheaPelvisDis.addSymptom(LR.abdomenPainLowerSide);
gonorrheaPelvisDis.addSymptom(LR.abdomenTenderness);
gonorrheaPelvisDis.addSymptom(LR.pelvisPain);


// ------------- gonococcalSepticemia  -------------
Disease gonococcalSepticemiaDis = new Disease(
    LR.gonococcalSepticemia,
    L.gonococcalSepticemiaDescription,
    LR.sexualDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.gonococcalSepticemiaFreq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.gonorrheaInfection
);
gonococcalSepticemiaDis.setPrintName(L.gonococcalSepticemiaPrintName);
gonococcalSepticemiaDis.setCode358(30);
gonococcalSepticemiaDis.setICD10code("A54");
gonococcalSepticemiaDis.addInternalCause(LR.gonorrhea);
gonococcalSepticemiaDis.addReference("pp 983-5");
gonococcalSepticemiaDis.addSymptom(LR.skinLesionFoot);
gonococcalSepticemiaDis.addSymptom(LR.skinLesionHand);


// ------------- chlamydialInfection  -------------
Disease chlamydialInfectionDis = new Disease(
    LR.chlamydialInfection,
    L.chlamydialInfectionDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.chlamydialInfection
);
chlamydialInfectionDis.setPrintName(L.chlamydialInfectionPrintName);
chlamydialInfectionDis.setCode358(32);
chlamydialInfectionDis.setICD10code("A69");
chlamydialInfectionDis.addReference("pp 985-7");
Treatment chlamydialInfectionTr1 = new Treatment("chlamydialInfectionTr1");
chlamydialInfectionTr1.addDrug(LR.doxycycline);
chlamydialInfectionTr1.addDrug(LR.azithromycin);
chlamydialInfectionDis.addTreatment("chlamydialInfectionTr1");
Treatment chlamydialInfectionTr2 = new Treatment("chlamydialInfectionTr2", LR.ifPregnant);
chlamydialInfectionTr2.addDrug(LR.erythromycin);
chlamydialInfectionDis.addTreatment("chlamydialInfectionTr2");


// ------------- chlamydialInfectionCervix  -------------
Disease chlamydialInfectionCervixDis = new Disease(
    LR.chlamydialInfectionCervix,
    L.chlamydialInfectionCervixDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.chlamydialInfectionCervixFreq, // diagnosis frequency, -1 = unknown
    LR.cervixSysSt,
    LR.none
);
chlamydialInfectionCervixDis.setPrintName(L.chlamydialInfectionCervixPrintName);
chlamydialInfectionCervixDis.setSuperDisease(LR.chlamydialInfection);
chlamydialInfectionCervixDis.setCode358(32);
chlamydialInfectionCervixDis.setICD10code("A69");
chlamydialInfectionCervixDis.addCausesDisease(LR.dyspareunia);
chlamydialInfectionCervixDis.addCausesDisease(LR.pelvisInflammatoryDisease);
chlamydialInfectionCervixDis.addCausesDisease(LR.salpingoOophoritis);
chlamydialInfectionCervixDis.addReference("pp 985-7");
chlamydialInfectionCervixDis.addSymptom(LR.pelvisPain);
chlamydialInfectionCervixDis.addSymptom(LR.vaginaDischargePurulent);
chlamydialInfectionCervixDis.addSymptom(LR.cervixErosion);


// ------------- chlamydialInfectionEndometrium  -------------
Disease chlamydialInfectionEndometriumDis = new Disease(
    LR.chlamydialInfectionEndometrium,
    L.chlamydialInfectionEndometriumDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.chlamydialInfectionEndometriumFreq, // diagnosis frequency, -1 = unknown
    LR.endometriumSysSt,
    LR.none
);
chlamydialInfectionEndometriumDis.setPrintName(L.chlamydialInfectionEndometriumPrintName);
chlamydialInfectionEndometriumDis.setSuperDisease(LR.chlamydialInfection);
chlamydialInfectionEndometriumDis.setTemperature(101.0f);
chlamydialInfectionEndometriumDis.setCode358(32);
chlamydialInfectionEndometriumDis.setICD10code("A69");
chlamydialInfectionEndometriumDis.addCausesDisease(LR.pelvisInflammatoryDisease);
chlamydialInfectionEndometriumDis.addCausesDisease(LR.salpingoOophoritis);
chlamydialInfectionEndometriumDis.addReference("pp 985-7");
chlamydialInfectionEndometriumDis.addSymptom(LR.abdomenPain);
chlamydialInfectionEndometriumDis.addSymptom(LR.abdomenTenderness);
chlamydialInfectionEndometriumDis.addSymptom(LR.cervixTenderness);
chlamydialInfectionEndometriumDis.addSymptom(LR.chills);
chlamydialInfectionEndometriumDis.addSymptom(LR.dysuria);
chlamydialInfectionEndometriumDis.addSymptom(LR.postcoitalBleeding);
chlamydialInfectionEndometriumDis.addSymptom(LR.uterusTender);
chlamydialInfectionEndometriumDis.addSymptom(LR.vaginaDischarge);
chlamydialInfectionEndometriumDis.addSymptom(LR.vaginaDischargeBloody);


// ------------- chlamydialInfectionUrethraFemale  -------------
Disease chlamydialInfectionUrethraFemaleDis = new Disease(
    LR.chlamydialInfectionUrethraFemale,
    L.chlamydialInfectionUrethraFemaleDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    F.chlamydialInfectionUrethraFemaleFreq, // diagnosis frequency, -1 = unknown
    LR.urethraFMSysSt,
    LR.none
);
chlamydialInfectionUrethraFemaleDis.setPrintName(L.chlamydialInfectionUrethraFemalePrintName);
chlamydialInfectionUrethraFemaleDis.setSuperDisease(LR.chlamydialInfection);
chlamydialInfectionUrethraFemaleDis.setCode358(32);
chlamydialInfectionUrethraFemaleDis.setICD10code("A69");
chlamydialInfectionUrethraFemaleDis.addCausesDisease(LR.pelvisInflammatoryDisease);
chlamydialInfectionUrethraFemaleDis.addCausesDisease(LR.salpingoOophoritis);
chlamydialInfectionUrethraFemaleDis.addReference("pp 985-7");
chlamydialInfectionUrethraFemaleDis.addSymptom(LR.dysuria);
chlamydialInfectionUrethraFemaleDis.addSymptom(LR.pyuria);
chlamydialInfectionUrethraFemaleDis.addSymptom(LR.urinaryFrequency);


// ------------- chlamydialInfectionUrethraMale  -------------
Disease chlamydialInfectionUrethraMaleDis = new Disease(
    LR.chlamydialInfectionUrethraMale,
    L.chlamydialInfectionUrethraMaleDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.urethraMLSysSt,
    LR.none
);
chlamydialInfectionUrethraMaleDis.setPrintName(L.chlamydialInfectionUrethraMalePrintName);
chlamydialInfectionUrethraMaleDis.setSuperDisease(LR.chlamydialInfection);
chlamydialInfectionUrethraMaleDis.setCode358(32);
chlamydialInfectionUrethraMaleDis.setICD10code("A69");
chlamydialInfectionUrethraMaleDis.addReference("pp 985-7");
chlamydialInfectionUrethraMaleDis.addSymptom(LR.dysuria);
chlamydialInfectionUrethraMaleDis.addSymptom(LR.urinaryFrequency);
chlamydialInfectionUrethraMaleDis.addSymptom(LR.pruritus);
chlamydialInfectionUrethraMaleDis.addSymptom(LR.urethraMaleDischarge);
chlamydialInfectionUrethraMaleDis.addSymptom(LR.erythemaUrethraMale);


// ------------- chlamydialInfectionEpididymis  -------------
Disease chlamydialInfectionEpididymisDis = new Disease(
    LR.chlamydialInfectionEpididymis,
    L.chlamydialInfectionEpididymisDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.epididymisSysSt,
    LR.none
);
chlamydialInfectionEpididymisDis.setPrintName(L.chlamydialInfectionEpididymisPrintName);
chlamydialInfectionEpididymisDis.setSuperDisease(LR.chlamydialInfection);
chlamydialInfectionEpididymisDis.setCode358(32);
chlamydialInfectionEpididymisDis.setICD10code("A69");
chlamydialInfectionEpididymisDis.addCausesDisease(LR.epididymitis);
chlamydialInfectionEpididymisDis.addReference("pp 985-7");
chlamydialInfectionEpididymisDis.addSymptom(LR.urethraMaleDischarge);
chlamydialInfectionEpididymisDis.addSymptom(LR.scrotumSwellingPainful);


// ------------- chlamydialInfectionProstate  -------------
Disease chlamydialInfectionProstateDis = new Disease(
    LR.chlamydialInfectionProstate,
    L.chlamydialInfectionProstateDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.prostateSysSt,
    LR.none
);
chlamydialInfectionProstateDis.setPrintName(L.chlamydialInfectionProstatePrintName);
chlamydialInfectionProstateDis.setSuperDisease(LR.chlamydialInfection);
chlamydialInfectionProstateDis.setCode358(32);
chlamydialInfectionProstateDis.setICD10code("A69");
chlamydialInfectionProstateDis.addReference("pp 985-7");
chlamydialInfectionProstateDis.addSymptom(LR.backPain);
chlamydialInfectionProstateDis.addSymptom(LR.dysuria);
chlamydialInfectionProstateDis.addSymptom(LR.urinaryFrequency);
chlamydialInfectionProstateDis.addSymptom(LR.nocturia);
chlamydialInfectionProstateDis.addSymptom(LR.ejaculationPainful);


// ------------- chlamydialInfectionRectum  -------------
Disease chlamydialInfectionRectumDis = new Disease(
    LR.chlamydialInfectionRectum,
    L.chlamydialInfectionRectumDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.rectumSysSt,
    LR.none
);
chlamydialInfectionRectumDis.setPrintName(L.chlamydialInfectionRectumPrintName);
chlamydialInfectionRectumDis.setSuperDisease(LR.chlamydialInfection);
chlamydialInfectionRectumDis.setCode358(32);
chlamydialInfectionRectumDis.setICD10code("A69");
chlamydialInfectionRectumDis.addReference("pp 985-7");
chlamydialInfectionRectumDis.addSymptom(LR.diarrhea);
chlamydialInfectionRectumDis.addSymptom(LR.pruritus);
chlamydialInfectionRectumDis.addSymptom(LR.tenesmus);
chlamydialInfectionRectumDis.addSymptom(LR.rectumBloodyDischarge, "", 0.5f);
chlamydialInfectionRectumDis.addSymptom(LR.anusDischargeMucopurulent, "", 0.5f);


// ------------- genitalHerpes  -------------
Disease genitalHerpesDis = new Disease(
    LR.genitalHerpes,
    L.genitalHerpesDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    F.genitalHerpesFreq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
genitalHerpesDis.setPrintName(L.genitalHerpesPrintName);
genitalHerpesDis.setSuperDisease(LR.herpesSimplex);
genitalHerpesDis.setTemperature(101.0f);
genitalHerpesDis.addReference("pp 987-9");
genitalHerpesDis.addSymptom(LR.dysuria);
genitalHerpesDis.addSymptom(LR.malaise);
genitalHerpesDis.addSymptom(LR.mouthLesion, "", 0.3f);
genitalHerpesDis.addSymptom(LR.anusLesion, "", 0.1f);
Treatment genitalHerpesTr1 = new Treatment("genitalHerpesTr1");
genitalHerpesTr1.addDrug(LR.acyclovir);
genitalHerpesDis.addTreatment("genitalHerpesTr1");


// ------------- genitalHerpesMale  -------------
Disease genitalHerpesMaleDis = new Disease(
    LR.genitalHerpesMale,
    L.genitalHerpesMaleDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    F.genitalHerpesMaleFreq, // diagnosis frequency, -1 = unknown
    LR.penisxSysSt,
    LR.none
);
genitalHerpesMaleDis.setPrintName(L.genitalHerpesMalePrintName);
genitalHerpesMaleDis.setSuperDisease(LR.genitalHerpes);
genitalHerpesMaleDis.setMiscComments(L.genitalHerpesMaleComment);
genitalHerpesMaleDis.setTemperature(101.0f);
genitalHerpesMaleDis.addReference("pp 987-9");
genitalHerpesMaleDis.addIllustration(D.HerpesMalePrimaryJpg);
genitalHerpesMaleDis.addIllustration(D.HerpesMaleRecurrentJpg);
genitalHerpesMaleDis.addSymptom(LR.penisVesicle);
genitalHerpesMaleDis.addSymptom(LR.penisGlansVesicle);
genitalHerpesMaleDis.addSymptom(LR.foreSkinVesicle);


// ------------- genitalHerpesFemale  -------------
Disease genitalHerpesFemaleDis = new Disease(
    LR.genitalHerpesFemale,
    L.genitalHerpesFemaleDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    F.genitalHerpesFemaleFreq, // diagnosis frequency, -1 = unknown
    LR.cervixSysSt,
    LR.none
);
genitalHerpesFemaleDis.setPrintName(L.genitalHerpesFemalePrintName);
genitalHerpesFemaleDis.setSuperDisease(LR.genitalHerpes);
genitalHerpesFemaleDis.setMiscComments(L.genitalHerpesFemaleComment);
genitalHerpesFemaleDis.setTemperature(101.0f);
genitalHerpesFemaleDis.addReference("pp 987-9");
genitalHerpesFemaleDis.addIllustration(D.HerpesFemaleJpg);
genitalHerpesFemaleDis.addIllustration(D.HerpesFemalePrimaryJpg);
genitalHerpesFemaleDis.addIllustration(D.HerpesFemale4DaysLaterJpg);
genitalHerpesFemaleDis.addSymptom(LR.cervixVesicle);
genitalHerpesFemaleDis.addSymptom(LR.labiaVesicle, "", 0.3f);
genitalHerpesFemaleDis.addSymptom(LR.vulvaVesicle, "", 0.3f);
genitalHerpesFemaleDis.addSymptom(LR.vaginaVesicle, "", 0.3f);


// ------------- genitalWarts  -------------
Disease genitalWartsDis = new Disease(
    LR.genitalWarts,
    L.genitalWartsDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    12, // minAge
    50, // maxAge
    -6, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.papillomavirusInfection
);
genitalWartsDis.setPrintName(L.genitalWartsPrintName);
genitalWartsDis.setMiscComments(L.genitalWartsComment);
genitalWartsDis.addReference("pp 989");
genitalWartsDis.addSymptom(LR.perineumWarts);
Treatment genitalWartsTr1 = new Treatment("genitalWartsTr1");
genitalWartsTr1.addDrug(LR.podophyllum);
genitalWartsDis.addTreatment("genitalWartsTr1");
Treatment genitalWartsTr2 = new Treatment("genitalWartsTr2");
genitalWartsTr2.addTreatmentAction(LR.electrocautery);
genitalWartsTr2.addTreatmentAction(LR.carbonDioxideLaser);
genitalWartsTr2.addTreatmentAction(LR.cryosurgery);
genitalWartsDis.addTreatment("genitalWartsTr2");


// ------------- genitalWartsFemale  -------------
Disease genitalWartsFemaleDis = new Disease(
    LR.genitalWartsFemale,
    L.genitalWartsFemaleDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    12, // minAge
    50, // maxAge
    -6, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
genitalWartsFemaleDis.setPrintName(L.genitalWartsFemalePrintName);
genitalWartsFemaleDis.setSuperDisease(LR.genitalWarts);
genitalWartsFemaleDis.setMiscComments(L.genitalWartsFemaleComment);
genitalWartsFemaleDis.addReference("pp 989");
genitalWartsFemaleDis.addSymptom(LR.cervixWarts);
genitalWartsFemaleDis.addSymptom(LR.vaginaWarts);
genitalWartsFemaleDis.addSymptom(LR.vulvaWarts);


// ------------- genitalWartsMale  -------------
Disease genitalWartsMaleDis = new Disease(
    LR.genitalWartsMale,
    L.genitalWartsMaleDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    12, // minAge
    50, // maxAge
    -6, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
genitalWartsMaleDis.setPrintName(L.genitalWartsMalePrintName);
genitalWartsMaleDis.setSuperDisease(LR.genitalWarts);
genitalWartsMaleDis.setMiscComments(L.genitalWartsMaleComment);
genitalWartsMaleDis.addReference("pp 989");
genitalWartsMaleDis.addSymptom(LR.penisWarts);
genitalWartsMaleDis.addSymptom(LR.urethraWarts);


// ------------- syphilis  -------------
Disease syphilisDis = new Disease(
    LR.syphilis,
    L.syphilisDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    39, // maxAge
    -1, // duration
    F.syphilisFreq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.spirocheteTreponemaPallidumInfection
);
syphilisDis.setPrintName(L.syphilisPrintName);
syphilisDis.setMiscComments(L.syphilisComment);
syphilisDis.setCode358(26);
syphilisDis.setICD10code("A50");
syphilisDis.addCausesDisease(LR.syphilisSecondary);
syphilisDis.addReference("pp 989-92");
syphilisDis.addIllustration(D.SyphilisChancrePenisJpg);
syphilisDis.addIllustration(D.SyphilisChancreVaginaJpg);
syphilisDis.addIllustration(D.SyphilisChancreVagina2Jpg);
syphilisDis.addIllustration(D.SyphilisChancreAnusJpg);
syphilisDis.addIllustration(D.SyphilisChancreChinJpg);
syphilisDis.addSymptom(LR.skinOfGenitalChancre);
syphilisDis.addSymptom(LR.anusChancre, "", 0.2f);
syphilisDis.addSymptom(LR.fingerChancre, "", 0.2f);
syphilisDis.addSymptom(LR.lipChancre, "", 0.2f);
syphilisDis.addSymptom(LR.tongueChancre, "", 0.2f);
syphilisDis.addSymptom(LR.nippleChancre, "", 0.2f);
syphilisDis.addSymptom(LR.tonsilChancre, "", 0.2f);
syphilisDis.addSymptom(LR.eyelidChancre, "", 0.2f);
Treatment syphilisTr1 = new Treatment("syphilisTr1");
syphilisTr1.addDrug(LR.penicillinG);
syphilisDis.addTreatment("syphilisTr1");


// ------------- syphilisSecondary  -------------
Disease syphilisSecondaryDis = new Disease(
    LR.syphilisSecondary,
    L.syphilisSecondaryDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    39, // maxAge
    -1, // duration
    F.syphilisSecondaryFreq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.spirocheteTreponemaPallidumInfection
);
syphilisSecondaryDis.setPrintName(L.syphilisSecondaryPrintName);
syphilisSecondaryDis.setMiscComments(L.syphilisSecondaryComment);
syphilisSecondaryDis.setCode358(26);
syphilisSecondaryDis.setICD10code("A50");
syphilisSecondaryDis.addInternalCause(LR.syphilis);
syphilisSecondaryDis.addCausesDisease(LR.syphilisLatent);
syphilisSecondaryDis.addReference("pp 989-92");
syphilisSecondaryDis.addIllustration(D.Syphilis2RashPapuloSquamousJpg);
syphilisSecondaryDis.addIllustration(D.Syphilis2RashPapuloPustularJpg);
syphilisSecondaryDis.addIllustration(D.Syphilis2RashHandsJpg);
syphilisSecondaryDis.addIllustration(D.Syphilis2CondylomaLataJpg);
syphilisSecondaryDis.addIllustration(D.Syphilis2RashTorsoJpg);
syphilisSecondaryDis.addIllustration(D.Syphilis2RashChinJpg);
syphilisSecondaryDis.addSymptom(LR.rash);
syphilisSecondaryDis.addSymptom(LR.rashErupting);
syphilisSecondaryDis.addSymptom(LR.skinLesionPinkWhite, L.syphilisSecondary_skinLesionPinkWhite, 1.0f);
syphilisSecondaryDis.addSymptom(LR.anorexia);
syphilisSecondaryDis.addSymptom(LR.headache);
syphilisSecondaryDis.addSymptom(LR.malaise);
syphilisSecondaryDis.addSymptom(LR.nausea);
syphilisSecondaryDis.addSymptom(LR.weightLoss);
syphilisSecondaryDis.addSymptom(LR.vomiting);
syphilisSecondaryDis.addSymptom(LR.throatSore);
syphilisSecondaryDis.addSymptom(LR.nailBrittle);


// ------------- syphilisLatent  -------------
Disease syphilisLatentDis = new Disease(
    LR.syphilisLatent,
    L.syphilisLatentDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    F.syphilisLatentFreq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.spirocheteTreponemaPallidumInfection
);
syphilisLatentDis.setPrintName(L.syphilisLatentPrintName);
syphilisLatentDis.setMiscComments(L.syphilisLatentComment);
syphilisLatentDis.setCode358(26);
syphilisLatentDis.setICD10code("A50");
syphilisLatentDis.addInternalCause(LR.syphilisSecondary);
syphilisLatentDis.addCausesDisease(LR.syphilisLate);
syphilisLatentDis.addReference("pp 989-92");
syphilisLatentDis.addSymptom(LR.skinLesionPinkWhite, L.syphilisLatent_skinLesionPinkWhite, 1.0f);


// ------------- syphilisLate  -------------
Disease syphilisLateDis = new Disease(
    LR.syphilisLate,
    L.syphilisLateDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    F.syphilisLateFreq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.spirocheteTreponemaPallidumInfection
);
syphilisLateDis.setPrintName(L.syphilisLatePrintName);
syphilisLateDis.setCode358(26);
syphilisLateDis.setICD10code("A50");
syphilisLateDis.addInternalCause(LR.syphilisLatent);
syphilisLateDis.addReference("pp 989-92");


// ------------- syphilisLateBenign  -------------
Disease syphilisLateBenignDis = new Disease(
    LR.syphilisLateBenign,
    L.syphilisLateBenignDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    F.syphilisLateBenignFreq, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
syphilisLateBenignDis.setPrintName(L.syphilisLateBenignPrintName);
syphilisLateBenignDis.setSuperDisease(LR.syphilisLate);
syphilisLateBenignDis.setCode358(26);
syphilisLateBenignDis.setICD10code("A50");
syphilisLateBenignDis.addCausesDisease(LR.anemia);
syphilisLateBenignDis.addCausesAbnormalCondition(LR.splenomegaly);
syphilisLateBenignDis.addReference("pp 989-92");
syphilisLateBenignDis.addIllustration(D.Syphilis4GummaSerpiginousJpg);
syphilisLateBenignDis.addIllustration(D.Syphilis4GummaUlceratingJpg);
syphilisLateBenignDis.addSymptom(LR.skinGumma);
syphilisLateBenignDis.addSymptom(LR.boneGumma);
syphilisLateBenignDis.addSymptom(LR.mucousMembraneGumma);
syphilisLateBenignDis.addSymptom(LR.organGumma);
syphilisLateBenignDis.addSymptom(LR.epigastricPain, L.syphilisLateBenign_epigastricPain, 0.2f);
syphilisLateBenignDis.addSymptom(LR.liverTender, L.syphilisLateBenign_liverTender, 0.2f);
syphilisLateBenignDis.addSymptom(LR.noseSeptumPerforation, "", 0.1f);
syphilisLateBenignDis.addSymptom(LR.palatePerforation, "", 0.1f);


// ------------- syphilisLateCardioVascular  -------------
Disease syphilisLateCardioVascularDis = new Disease(
    LR.syphilisLateCardioVascular,
    L.syphilisLateCardioVascularDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    F.syphilisLateCardioVascularFreq, // diagnosis frequency, -1 = unknown
    LR.cardioVascularSysSt,
    LR.none
);
syphilisLateCardioVascularDis.setPrintName(L.syphilisLateCardioVascularPrintName);
syphilisLateCardioVascularDis.setSuperDisease(LR.syphilisLate);
syphilisLateCardioVascularDis.setMiscComments(L.syphilisLateCardioVascularComment);
syphilisLateCardioVascularDis.setCode358(27);
syphilisLateCardioVascularDis.setICD10code("A52");
syphilisLateCardioVascularDis.addCausesDisease(LR.thoracicAortaAneurysm);
syphilisLateCardioVascularDis.addCausesDisease(LR.aortaInsufficiency);
syphilisLateCardioVascularDis.addReference("pp 989-92");
syphilisLateCardioVascularDis.addIllustration(D.Syphilis4CardioAortaNarrowingJpg);


// ------------- syphilisLateNeurologic  -------------
Disease syphilisLateNeurologicDis = new Disease(
    LR.syphilisLateNeurologic,
    L.syphilisLateNeurologicDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    F.syphilisLateNeurologicFreq, // diagnosis frequency, -1 = unknown
    LR.neurologicSysSt,
    LR.none
);
syphilisLateNeurologicDis.setPrintName(L.syphilisLateNeurologicPrintName);
syphilisLateNeurologicDis.setSuperDisease(LR.syphilisLate);
syphilisLateNeurologicDis.setMiscComments(L.syphilisLateNeurologicComment);
syphilisLateNeurologicDis.setCode358(28);
syphilisLateNeurologicDis.setICD10code("A52");
syphilisLateNeurologicDis.addCausesDisease(LR.meningitis);
syphilisLateNeurologicDis.addReference("pp 989-92");
syphilisLateNeurologicDis.addIllustration(D.Syphilis4NeuralTissueSpirochetesJpg);
syphilisLateNeurologicDis.addSymptom(LR.armWeakness);
syphilisLateNeurologicDis.addSymptom(LR.legWeakness);
syphilisLateNeurologicDis.addSymptom(LR.paralysis);
syphilisLateNeurologicDis.addSymptom(LR.personalityChange);


// ------------- trichomoniasis  -------------
Disease trichomoniasisDis = new Disease(
    LR.trichomoniasis,
    L.trichomoniasisDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -5, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.protozoanInfection
);
trichomoniasisDis.setPrintName(L.trichomoniasisPrintName);
trichomoniasisDis.addReference("pp 992-4");
Treatment trichomoniasisTr1 = new Treatment("trichomoniasisTr1");
trichomoniasisTr1.addDrug(LR.metronidazole);
trichomoniasisDis.addTreatment("trichomoniasisTr1");


// ------------- trichomoniasisFemale  -------------
Disease trichomoniasisFemaleDis = new Disease(
    LR.trichomoniasisFemale,
    L.trichomoniasisFemaleDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -5, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
trichomoniasisFemaleDis.setPrintName(L.trichomoniasisFemalePrintName);
trichomoniasisFemaleDis.setSuperDisease(LR.trichomoniasis);
trichomoniasisFemaleDis.addCausesDisease(LR.dyspareunia);
trichomoniasisFemaleDis.addCausesDisease(LR.dysmenorrhea);
trichomoniasisFemaleDis.addCausesDisease(LR.menorrhagia);
trichomoniasisFemaleDis.addReference("pp 992-4");
trichomoniasisFemaleDis.addSymptom(LR.dysuria);
trichomoniasisFemaleDis.addSymptom(LR.urinaryFrequency);
trichomoniasisFemaleDis.addSymptom(LR.vaginaRed);
trichomoniasisFemaleDis.addSymptom(LR.vaginaSwollen);
trichomoniasisFemaleDis.addSymptom(LR.vaginaDischargeFrothy, "", 0.5f);
trichomoniasisFemaleDis.addSymptom(LR.vaginaDischargeProfuse, "", 0.5f);
trichomoniasisFemaleDis.addSymptom(LR.vaginaDischargeGrayFoulFishySmelling, "", 0.5f);
trichomoniasisFemaleDis.addSymptom(LR.vaginaItching);
trichomoniasisFemaleDis.addSymptom(LR.vaginaTenderness);


// ------------- trichomoniasisMale  -------------
Disease trichomoniasisMaleDis = new Disease(
    LR.trichomoniasisMale,
    L.trichomoniasisMaleDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -5, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
trichomoniasisMaleDis.setPrintName(L.trichomoniasisMalePrintName);
trichomoniasisMaleDis.setSuperDisease(LR.trichomoniasis);
trichomoniasisMaleDis.addCausesDisease(LR.urethritisML);
trichomoniasisMaleDis.addReference("pp 992-4");
trichomoniasisMaleDis.addSymptom(LR.dysuria);
trichomoniasisMaleDis.addSymptom(LR.urethraMaleDischargePurulent, "", 0.05f);
trichomoniasisMaleDis.addSymptom(LR.urinaryBurning);
trichomoniasisMaleDis.addSymptom(LR.urinaryFrequency);


// ------------- chancroid  -------------
Disease chancroidDis = new Disease(
    LR.chancroid,
    L.chancroidDescription,
    LR.sexualDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.haemophilusDucreyiInfection
);
chancroidDis.setPrintName(L.chancroidPrintName);
chancroidDis.setMiscComments(L.chancroidComment);
chancroidDis.addCausesDisease(LR.chancroidPhase2);
chancroidDis.addReference("pp 994-5");
chancroidDis.addSymptom(LR.groinPapule, "", 0.4f);
chancroidDis.addSymptom(LR.thighPapule, "", 0.4f);
chancroidDis.addSymptom(LR.tonguePapule, "", 0.01f);
chancroidDis.addSymptom(LR.lipPapule, "", 0.01f);
chancroidDis.addSymptom(LR.navelPapule, "", 0.01f);
Treatment chancroidTr1 = new Treatment("chancroidTr1");
chancroidTr1.addDrug(LR.azithromycin);
chancroidDis.addTreatment("chancroidTr1");


// ------------- chancroidMale  -------------
Disease chancroidMaleDis = new Disease(
    LR.chancroidMale,
    L.chancroidMaleDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
chancroidMaleDis.setPrintName(L.chancroidMalePrintName);
chancroidMaleDis.setSuperDisease(LR.chancroid);
chancroidMaleDis.setMiscComments(L.chancroidMaleComment);
chancroidMaleDis.addReference("pp 994-5");
chancroidMaleDis.addIllustration(D.ChancroidPenisUlcersJpg);
chancroidMaleDis.addIllustration(D.ChancroidPenisRupturedPapuleJpg);
chancroidMaleDis.addSymptom(LR.penisPapule, "", 0.1f);


// ------------- chancroidFemale  -------------
Disease chancroidFemaleDis = new Disease(
    LR.chancroidFemale,
    L.chancroidFemaleDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
chancroidFemaleDis.setPrintName(L.chancroidFemalePrintName);
chancroidFemaleDis.setSuperDisease(LR.chancroid);
chancroidFemaleDis.setMiscComments(L.chancroidFemaleComment);
chancroidFemaleDis.addReference("pp 994-5");
chancroidFemaleDis.addSymptom(LR.vulvaPapule, "", 0.08f);
chancroidFemaleDis.addSymptom(LR.vaginaPapule, "", 0.02f);
chancroidFemaleDis.addSymptom(LR.cervixPapule, "", 0.02f);
chancroidFemaleDis.addSymptom(LR.breastPapule, "", 0.01f);


// ------------- chancroidPhase2  -------------
Disease chancroidPhase2Dis = new Disease(
    LR.chancroidPhase2,
    L.chancroidPhase2Description,
    LR.sexualDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.haemophilusDucreyiInfection
);
chancroidPhase2Dis.setPrintName(L.chancroidPhase2PrintName);
chancroidPhase2Dis.setMiscComments(L.chancroidPhase2Comment);
chancroidPhase2Dis.addInternalCause(LR.chancroid);
chancroidPhase2Dis.addReference("pp 994-5");
chancroidPhase2Dis.addIllustration(D.ChancroidPenisUlcersJpg);
chancroidPhase2Dis.addIllustration(D.ChancroidPenisRupturedPapuleJpg);
chancroidPhase2Dis.addSymptom(LR.headache, "", 0.5f);
chancroidPhase2Dis.addSymptom(LR.malaise, "", 0.5f);
chancroidPhase2Dis.addSymptom(LR.papuleUlcerated, L.chancroidPhase2_papuleUlcerated, 1.0f);
chancroidPhase2Dis.addSymptom(LR.ulcerPainful);
chancroidPhase2Dis.addSymptom(LR.ulcerSoft);
chancroidPhase2Dis.addSymptom(LR.ulcerMalodorous);
chancroidPhase2Dis.addSymptom(LR.ulcerBleedsEasily);
chancroidPhase2Dis.addSymptom(LR.ulcerGray);
chancroidPhase2Dis.addSymptom(LR.ulcerShallow);
chancroidPhase2Dis.addSymptom(LR.groinAdenitis, L.chancroidPhase2_groinAdenitis, 1.0f);
chancroidPhase2Dis.addSymptom(LR.groinLymphNodeRuptured);


// ------------- arousalDisorder  -------------
Disease arousalDisorderDis = new Disease(
    LR.arousalDisorder,
    L.arousalDisorderDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
arousalDisorderDis.setPrintName(L.arousalDisorderPrintName);
arousalDisorderDis.addReference("pp 996-8");
arousalDisorderDis.addSymptom(LR.sexualDesireAbsent);
arousalDisorderDis.addSymptom(LR.sexualStimulationIgnored);
Treatment arousalDisorderTr1 = new Treatment("arousalDisorderTr1");
arousalDisorderTr1.addTreatmentAction(LR.MasterAndJohnsonTherapy);
arousalDisorderTr1.addTreatmentAction(LR.psychoanalyticTherapy);
arousalDisorderTr1.addTreatmentAction(LR.behaviorTherapy);
arousalDisorderDis.addTreatment("arousalDisorderTr1");


// ------------- orgasmicDisorder  -------------
Disease orgasmicDisorderDis = new Disease(
    LR.orgasmicDisorder,
    L.orgasmicDisorderDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
orgasmicDisorderDis.setPrintName(L.orgasmicDisorderPrintName);
orgasmicDisorderDis.addReference("pp 996-8");
orgasmicDisorderDis.addSymptom(LR.orgasmUnachievable);
Treatment orgasmicDisorderTr1 = new Treatment("orgasmicDisorderTr1");
orgasmicDisorderTr1.addTreatmentAction(LR.behaviorTherapy);
orgasmicDisorderTr1.addTreatmentAction(LR.psychoanalyticTherapy);
orgasmicDisorderTr1.addTreatmentAction(LR.experientialTherapy);
orgasmicDisorderDis.addTreatment("orgasmicDisorderTr1");


// ------------- dyspareunia  -------------
Disease dyspareuniaDis = new Disease(
    LR.dyspareunia,
    L.dyspareuniaDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.physicalProblem
);
dyspareuniaDis.setPrintName(L.dyspareuniaPrintName);
dyspareuniaDis.setMiscComments(L.dyspareuniaComment);
dyspareuniaDis.addExternalCause(LR.psychologicalProblem);
dyspareuniaDis.addInternalCause(LR.chlamydialInfectionCervix);
dyspareuniaDis.addInternalCause(LR.ovariesCysts);
dyspareuniaDis.addInternalCause(LR.trichomoniasisFemale);
dyspareuniaDis.addReference("pp 998-9");
dyspareuniaDis.addSymptom(LR.intercourseDiscomfort);
dyspareuniaDis.addSymptom(LR.vaginaBurning);
dyspareuniaDis.addSymptom(LR.vaginaItching);
Treatment dyspareuniaTr1 = new Treatment("dyspareuniaTr1", LR.ifLubricationProblem);
dyspareuniaTr1.addTreatmentAction(LR.creamsOrGels);
dyspareuniaDis.addTreatment("dyspareuniaTr1");
Treatment dyspareuniaTr2 = new Treatment("dyspareuniaTr2", LR.ifInfection);
dyspareuniaTr2.addDrug(LR.antibiotics);
dyspareuniaTr2.addDrug(LR.antimicrobials);
dyspareuniaDis.addTreatment("dyspareuniaTr2");
Treatment dyspareuniaTr3 = new Treatment("dyspareuniaTr3", LR.ifHymenalScars);
dyspareuniaTr3.addTreatmentAction(LR.excision);
dyspareuniaDis.addTreatment("dyspareuniaTr3");
Treatment dyspareuniaTr4 = new Treatment("dyspareuniaTr4", LR.ifPsychologicalProblem);
dyspareuniaTr4.addTreatmentAction(LR.behaviorTherapy);
dyspareuniaTr4.addTreatmentAction(LR.education);
dyspareuniaDis.addTreatment("dyspareuniaTr4");


// ------------- vaginismus  -------------
Disease vaginismusDis = new Disease(
    LR.vaginismus,
    L.vaginismusDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.physicalProblem
);
vaginismusDis.setPrintName(L.vaginismusPrintName);
vaginismusDis.addExternalCause(LR.psychologicalProblem);
vaginismusDis.addReference("pp 999-1000");
vaginismusDis.addSymptom(LR.vaginaMuscleSpasm, L.vaginismus_vaginaMuscleSpasm, 1.0f);
vaginismusDis.addSymptom(LR.sexualDesireAbsent, "", 0.5f);
Treatment vaginismusTr1 = new Treatment("vaginismusTr1", LR.ifPsychologicalProblem);
vaginismusTr1.addTreatmentAction(LR.MasterAndJohnsonTherapy);
vaginismusTr1.addTreatmentAction(LR.behaviorTherapy);
vaginismusDis.addTreatment("vaginismusTr1");


// ------------- erectionDisorder  -------------
Disease erectionDisorderDis = new Disease(
    LR.erectionDisorder,
    L.erectionDisorderDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.penisxSysSt,
    LR.physicalProblem
);
erectionDisorderDis.setPrintName(L.erectionDisorderPrintName);
erectionDisorderDis.setMiscComments(L.erectionDisorderComment);
erectionDisorderDis.addExternalCause(LR.psychologicalProblem);
erectionDisorderDis.addReference("pp 1000-1");
erectionDisorderDis.addSymptom(LR.erectionFailure);
Treatment erectionDisorderTr1 = new Treatment("erectionDisorderTr1", LR.ifPsychologicalProblem);
erectionDisorderTr1.addTreatmentAction(LR.sexTherapy);
erectionDisorderDis.addTreatment("erectionDisorderTr1");
Treatment erectionDisorderTr2 = new Treatment("erectionDisorderTr2", LR.ifPhysicalProblem);
erectionDisorderTr2.addTreatmentAction(LR.surgery);
erectionDisorderDis.addTreatment("erectionDisorderTr2");


// ------------- hypogonadism  -------------
Disease hypogonadismDis = new Disease(
    LR.hypogonadism,
    L.hypogonadismDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.endocrineSysSt,
    LR.none
);
hypogonadismDis.setPrintName(L.hypogonadismPrintName);
hypogonadismDis.addReference("pp 1001-3");
hypogonadismDis.addSymptom(LR.boneAgeImmature);
hypogonadismDis.addSymptom(LR.pubertyDelayed);
hypogonadismDis.addSymptom(LR.penisInfantile);
hypogonadismDis.addSymptom(LR.testicleSoft);
hypogonadismDis.addSymptom(LR.muscleUnderdeveloped);
hypogonadismDis.addSymptom(LR.muscleWeakness);
hypogonadismDis.addSymptom(LR.faceHairSparse);
hypogonadismDis.addSymptom(LR.bodyHairSparse);
hypogonadismDis.addSymptom(LR.sexDriveLow);
Treatment hypogonadismTr1 = new Treatment("hypogonadismTr1");
hypogonadismTr1.addTreatmentAction(LR.hormoneTherapy);
hypogonadismTr1.addDrug(LR.gonadotropin);
hypogonadismTr1.addDrug(LR.testosterone);
hypogonadismDis.addTreatment("hypogonadismTr1");


// ------------- undescendedTestes  -------------
Disease undescendedTestesDis = new Disease(
    LR.undescendedTestes,
    L.undescendedTestesDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.testesSysSt,
    LR.congenital
);
undescendedTestesDis.setPrintName(L.undescendedTestesPrintName);
undescendedTestesDis.addReference("pp 1003-4");
undescendedTestesDis.addSymptom(LR.infertilityMaleSymptom);
Treatment undescendedTestesTr1 = new Treatment("undescendedTestesTr1");
undescendedTestesTr1.addTreatmentAction(LR.surgery);
undescendedTestesDis.addTreatment("undescendedTestesTr1");


// ------------- prematureEjaculation  -------------
Disease prematureEjaculationDis = new Disease(
    LR.prematureEjaculation,
    L.prematureEjaculationDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    12, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
prematureEjaculationDis.setPrintName(L.prematureEjaculationPrintName);
prematureEjaculationDis.addReference("pp 1004-5");
prematureEjaculationDis.addSymptom(LR.prematureEjaculationSymptom);
Treatment prematureEjaculationTr1 = new Treatment("prematureEjaculationTr1");
prematureEjaculationTr1.addTreatmentAction(LR.MasterAndJohnsonTherapy);
prematureEjaculationDis.addTreatment("prematureEjaculationTr1");


// ------------- testicleTorsion  -------------
Disease testicleTorsionDis = new Disease(
    LR.testicleTorsion,
    L.testicleTorsionDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    12, // minAge
    18, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.testesSysSt,
    LR.none
);
testicleTorsionDis.setPrintName(L.testicleTorsionPrintName);
testicleTorsionDis.addReference("pp 1005-6");
testicleTorsionDis.addSymptom(LR.testiclePain);
Treatment testicleTorsionTr1 = new Treatment("testicleTorsionTr1");
testicleTorsionTr1.addTreatmentAction(LR.surgery);
testicleTorsionDis.addTreatment("testicleTorsionTr1");


// ------------- infertilityMale  -------------
Disease infertilityMaleDis = new Disease(
    LR.infertilityMale,
    L.infertilityMaleDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
infertilityMaleDis.setPrintName(L.infertilityMalePrintName);
infertilityMaleDis.setMiscComments(L.infertilityMaleComment);
infertilityMaleDis.addReference("pp 1006-7");
infertilityMaleDis.addSymptom(LR.infertilityMaleSymptom);
Treatment infertilityMaleTr1 = new Treatment("infertilityMaleTr1", LR.ifPhysicalProblem);
infertilityMaleTr1.addTreatmentAction(LR.surgery);
infertilityMaleDis.addTreatment("infertilityMaleTr1");
Treatment infertilityMaleTr2 = new Treatment("infertilityMaleTr2", LR.ifPsychologicalProblem);
infertilityMaleTr2.addTreatmentAction(LR.education);
infertilityMaleTr2.addTreatmentAction(LR.sexTherapy);
infertilityMaleDis.addTreatment("infertilityMaleTr2");
Treatment infertilityMaleTr3 = new Treatment("infertilityMaleTr3");
infertilityMaleTr3.addDrug(LR.gonadotropin);
infertilityMaleTr3.addDrug(LR.testosterone);
infertilityMaleDis.addTreatment("infertilityMaleTr3");


// ------------- precociousPubertyMale  -------------
Disease precociousPubertyMaleDis = new Disease(
    LR.precociousPubertyMale,
    L.precociousPubertyMaleDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    10, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
precociousPubertyMaleDis.setPrintName(L.precociousPubertyMalePrintName);
precociousPubertyMaleDis.addReference("pp 1007-9");
precociousPubertyMaleDis.addSymptom(LR.boneDevelopmentEarly);
precociousPubertyMaleDis.addSymptom(LR.muscleDevelopmentEarly);
precociousPubertyMaleDis.addSymptom(LR.adultHairPattern);
precociousPubertyMaleDis.addSymptom(LR.penisGrowth);


// ------------- precociousPubertyMaleConstitutional  -------------
Disease precociousPubertyMaleConstitutionalDis = new Disease(
    LR.precociousPubertyMaleConstitutional,
    L.precociousPubertyMaleConstitutionalDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    10, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.constitutional
);
precociousPubertyMaleConstitutionalDis.setPrintName(L.precociousPubertyMaleConstitutionalPrintName);
precociousPubertyMaleConstitutionalDis.setSuperDisease(LR.precociousPubertyMale);
precociousPubertyMaleConstitutionalDis.setGenetic("father");
precociousPubertyMaleConstitutionalDis.setParentDisease(LR.precociousPubertyMaleConstitutional);
precociousPubertyMaleConstitutionalDis.addReference("pp 1007-9");
precociousPubertyMaleConstitutionalDis.addSymptom(LR.testiclesEnlarged);
Treatment precociousPubertyMaleConstitutionalTr1 = new Treatment("precociousPubertyMaleConstitutionalTr1");
precociousPubertyMaleConstitutionalTr1.addTreatmentAction(LR.psychologicalCounseling);
precociousPubertyMaleConstitutionalDis.addTreatment("precociousPubertyMaleConstitutionalTr1");


// ------------- precociousPubertyMaleCerebral  -------------
Disease precociousPubertyMaleCerebralDis = new Disease(
    LR.precociousPubertyMaleCerebral,
    L.precociousPubertyMaleCerebralDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    10, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
precociousPubertyMaleCerebralDis.setPrintName(L.precociousPubertyMaleCerebralPrintName);
precociousPubertyMaleCerebralDis.setSuperDisease(LR.precociousPubertyMale);
precociousPubertyMaleCerebralDis.setMiscComments(L.precociousPubertyMaleCerebralComment);
precociousPubertyMaleCerebralDis.addCausingAbnormalCondition(LR.brainLesion);
precociousPubertyMaleCerebralDis.addCausesDisease(LR.hydrocephalus);
precociousPubertyMaleCerebralDis.addReference("pp 1007-9");
precociousPubertyMaleCerebralDis.addSymptom(LR.testiclesEnlarged);
precociousPubertyMaleCerebralDis.addSymptom(LR.headache);
precociousPubertyMaleCerebralDis.addSymptom(LR.nausea);
precociousPubertyMaleCerebralDis.addSymptom(LR.vomiting);
precociousPubertyMaleCerebralDis.addSymptom(LR.ocularDisturbance);
Treatment precociousPubertyMaleCerebralTr1 = new Treatment("precociousPubertyMaleCerebralTr1", LR.ifBrainTumor);
precociousPubertyMaleCerebralTr1.addTreatmentAction(LR.neurosurgery);
precociousPubertyMaleCerebralDis.addTreatment("precociousPubertyMaleCerebralTr1");


// ------------- precociousPubertyMaleTumor  -------------
Disease precociousPubertyMaleTumorDis = new Disease(
    LR.precociousPubertyMaleTumor,
    L.precociousPubertyMaleTumorDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    10, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
precociousPubertyMaleTumorDis.setPrintName(L.precociousPubertyMaleTumorPrintName);
precociousPubertyMaleTumorDis.setSuperDisease(LR.precociousPubertyMale);
precociousPubertyMaleTumorDis.addReference("pp 1007-9");
precociousPubertyMaleTumorDis.addSymptom(LR.testiclesEnlarged);
precociousPubertyMaleTumorDis.addSymptom(LR.acne);
precociousPubertyMaleTumorDis.addSymptom(LR.testicleSizeDiffer, "", 0.8f);
precociousPubertyMaleTumorDis.addSymptom(LR.testicleNodule, "", 0.5f);
Treatment precociousPubertyMaleTumorTr1 = new Treatment("precociousPubertyMaleTumorTr1");
precociousPubertyMaleTumorTr1.addTreatmentAction(LR.surgery);
precociousPubertyMaleTumorDis.addTreatment("precociousPubertyMaleTumorTr1");


// ------------- precociousPubertyMaleAdrenogenital  -------------
Disease precociousPubertyMaleAdrenogenitalDis = new Disease(
    LR.precociousPubertyMaleAdrenogenital,
    L.precociousPubertyMaleAdrenogenitalDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    10, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
precociousPubertyMaleAdrenogenitalDis.setPrintName(L.precociousPubertyMaleAdrenogenitalPrintName);
precociousPubertyMaleAdrenogenitalDis.setSuperDisease(LR.precociousPubertyMale);
precociousPubertyMaleAdrenogenitalDis.setUnderlyingDisease(LR.adrenogenitalSyndrome);
precociousPubertyMaleAdrenogenitalDis.addCausesAbnormalCondition(LR.prostateEnlarged);
precociousPubertyMaleAdrenogenitalDis.addReference("pp 1007-9");
precociousPubertyMaleAdrenogenitalDis.addSymptom(LR.skinToneAdult);
precociousPubertyMaleAdrenogenitalDis.addSymptom(LR.voiceDeepened);
precociousPubertyMaleAdrenogenitalDis.addSymptom(LR.scrotumEnlarged);
Treatment precociousPubertyMaleAdrenogenitalTr1 = new Treatment("precociousPubertyMaleAdrenogenitalTr1");
precociousPubertyMaleAdrenogenitalTr1.addDrug(LR.glucocorticoids);
precociousPubertyMaleAdrenogenitalDis.addTreatment("precociousPubertyMaleAdrenogenitalTr1");


// ------------- precociousPubertyFemale  -------------
Disease precociousPubertyFemaleDis = new Disease(
    LR.precociousPubertyFemale,
    L.precociousPubertyFemaleDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    9, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
precociousPubertyFemaleDis.setPrintName(L.precociousPubertyFemalePrintName);
precociousPubertyFemaleDis.addReference("pp 928-9");
precociousPubertyFemaleDis.addSymptom(LR.growthRapid);
precociousPubertyFemaleDis.addSymptom(LR.breastDevelopment);
precociousPubertyFemaleDis.addSymptom(LR.pubisHairDevelopment);
precociousPubertyFemaleDis.addSymptom(LR.menarcheEarly);


// ------------- precociousPubertyFemaleConstitutional  -------------
Disease precociousPubertyFemaleConstitutionalDis = new Disease(
    LR.precociousPubertyFemaleConstitutional,
    L.precociousPubertyFemaleConstitutionalDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    9, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.constitutional
);
precociousPubertyFemaleConstitutionalDis.setPrintName(L.precociousPubertyFemaleConstitutionalPrintName);
precociousPubertyFemaleConstitutionalDis.setSuperDisease(LR.precociousPubertyFemale);
precociousPubertyFemaleConstitutionalDis.addReference("pp 928-9");
Treatment precociousPubertyFemaleConstitutionalTr1 = new Treatment("precociousPubertyFemaleConstitutionalTr1");
precociousPubertyFemaleConstitutionalTr1.addDrug(LR.medroxyprogesterone);
precociousPubertyFemaleConstitutionalDis.addTreatment("precociousPubertyFemaleConstitutionalTr1");


// ------------- precociousPubertyFemaleAdrenogenital  -------------
Disease precociousPubertyFemaleAdrenogenitalDis = new Disease(
    LR.precociousPubertyFemaleAdrenogenital,
    L.precociousPubertyFemaleAdrenogenitalDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    9, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
precociousPubertyFemaleAdrenogenitalDis.setPrintName(L.precociousPubertyFemaleAdrenogenitalPrintName);
precociousPubertyFemaleAdrenogenitalDis.setSuperDisease(LR.precociousPubertyFemale);
precociousPubertyFemaleAdrenogenitalDis.setUnderlyingDisease(LR.adrenogenitalSyndrome);
precociousPubertyFemaleAdrenogenitalDis.addCausesAbnormalCondition(LR.anovulation);
precociousPubertyFemaleAdrenogenitalDis.addReference("pp 928-9");
precociousPubertyFemaleAdrenogenitalDis.addSymptom(LR.clitorisEnlarged);
Treatment precociousPubertyFemaleAdrenogenitalTr1 = new Treatment("precociousPubertyFemaleAdrenogenitalTr1");
precociousPubertyFemaleAdrenogenitalTr1.addDrug(LR.corticosteroids);
precociousPubertyFemaleAdrenogenitalDis.addTreatment("precociousPubertyFemaleAdrenogenitalTr1");


// ------------- precociousPubertyFemaleCerebral  -------------
Disease precociousPubertyFemaleCerebralDis = new Disease(
    LR.precociousPubertyFemaleCerebral,
    L.precociousPubertyFemaleCerebralDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    9, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
precociousPubertyFemaleCerebralDis.setPrintName(L.precociousPubertyFemaleCerebralPrintName);
precociousPubertyFemaleCerebralDis.setSuperDisease(LR.precociousPubertyFemale);
precociousPubertyFemaleCerebralDis.setMiscComments(L.precociousPubertyFemaleCerebralComment);
precociousPubertyFemaleCerebralDis.addCausingAbnormalCondition(LR.brainLesion);
precociousPubertyFemaleCerebralDis.addCausesDisease(LR.hydrocephalus);
precociousPubertyFemaleCerebralDis.addReference("pp 928-9");
precociousPubertyFemaleCerebralDis.addSymptom(LR.acne);
Treatment precociousPubertyFemaleCerebralTr1 = new Treatment("precociousPubertyFemaleCerebralTr1", LR.ifBrainTumor);
precociousPubertyFemaleCerebralTr1.addTreatmentAction(LR.neurosurgery);
precociousPubertyFemaleCerebralDis.addTreatment("precociousPubertyFemaleCerebralTr1");


// ------------- precociousPubertyFemaleTumor  -------------
Disease precociousPubertyFemaleTumorDis = new Disease(
    LR.precociousPubertyFemaleTumor,
    L.precociousPubertyFemaleTumorDescription,
    LR.sexualDisorders,
    LR.female, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    9, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
precociousPubertyFemaleTumorDis.setPrintName(L.precociousPubertyFemaleTumorPrintName);
precociousPubertyFemaleTumorDis.setSuperDisease(LR.precociousPubertyFemale);
precociousPubertyFemaleTumorDis.addInternalCause(LR.choriocarcinoma);
precociousPubertyFemaleTumorDis.addCausingAbnormalCondition(LR.ovariesTumor);
precociousPubertyFemaleTumorDis.addCausingAbnormalCondition(LR.adrenalTumor);
precociousPubertyFemaleTumorDis.addReference("pp 928-9");
Treatment precociousPubertyFemaleTumorTr1 = new Treatment("precociousPubertyFemaleTumorTr1");
precociousPubertyFemaleTumorTr1.addTreatmentAction(LR.surgery);
precociousPubertyFemaleTumorDis.addTreatment("precociousPubertyFemaleTumorTr1");


// ------------- genderIdentityDisorder  -------------
Disease genderIdentityDisorderDis = new Disease(
    LR.genderIdentityDisorder,
    L.genderIdentityDisorderDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
genderIdentityDisorderDis.setPrintName(L.genderIdentityDisorderPrintName);
genderIdentityDisorderDis.addReference("pp 1009-10");
genderIdentityDisorderDis.addSymptom(LR.sexChangeDesire);
Treatment genderIdentityDisorderTr1 = new Treatment("genderIdentityDisorderTr1");
genderIdentityDisorderTr1.addTreatmentAction(LR.psychologicalCounseling);
genderIdentityDisorderDis.addTreatment("genderIdentityDisorderTr1");
Treatment genderIdentityDisorderTr2 = new Treatment("genderIdentityDisorderTr2", LR.ifSuicidal);
genderIdentityDisorderTr2.addTreatmentAction(LR.hospitalization);
genderIdentityDisorderDis.addTreatment("genderIdentityDisorderTr2");
Treatment genderIdentityDisorderTr3 = new Treatment("genderIdentityDisorderTr3");
genderIdentityDisorderTr3.addTreatmentAction(LR.perhapsSurgery);
genderIdentityDisorderDis.addTreatment("genderIdentityDisorderTr3");


// ------------- paraphilias  -------------
Disease paraphiliasDis = new Disease(
    LR.paraphilias,
    L.paraphiliasDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
paraphiliasDis.setPrintName(L.paraphiliasPrintName);
paraphiliasDis.addReference("pp 1010-3");
Treatment paraphiliasTr1 = new Treatment("paraphiliasTr1");
paraphiliasTr1.addTreatmentAction(LR.behaviorTherapy);
paraphiliasTr1.addTreatmentAction(LR.psychologicalCounseling);
paraphiliasTr1.addTreatmentAction(LR.surgery);
paraphiliasTr1.addTreatmentAction(LR.pharmacotherapy);
paraphiliasDis.addTreatment("paraphiliasTr1");


// ------------- exhibitionism  -------------
Disease exhibitionismDis = new Disease(
    LR.exhibitionism,
    L.exhibitionismDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
exhibitionismDis.setPrintName(L.exhibitionismPrintName);
exhibitionismDis.setSuperDisease(LR.paraphilias);
exhibitionismDis.addReference("pp 1010-3");
exhibitionismDis.addSymptom(LR.genitaliaExposureToStrangers);


// ------------- fetishism  -------------
Disease fetishismDis = new Disease(
    LR.fetishism,
    L.fetishismDescription,
    LR.sexualDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
fetishismDis.setPrintName(L.fetishismPrintName);
fetishismDis.setSuperDisease(LR.paraphilias);
fetishismDis.addReference("pp 1010-3");
fetishismDis.addSymptom(LR.sexualArousalFromInanimateObjects);


// ------------- frotteurism  -------------
Disease frotteurismDis = new Disease(
    LR.frotteurism,
    L.frotteurismDescription,
    LR.sexualDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    25, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
frotteurismDis.setPrintName(L.frotteurismPrintName);
frotteurismDis.setSuperDisease(LR.paraphilias);
frotteurismDis.addReference("pp 1010-3");
frotteurismDis.addSymptom(LR.sexualArousalFromRubbingANonconsentingPerson);


// ------------- pedophilia  -------------
Disease pedophiliaDis = new Disease(
    LR.pedophilia,
    L.pedophiliaDescription,
    LR.sexualDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    16, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
pedophiliaDis.setPrintName(L.pedophiliaPrintName);
pedophiliaDis.setSuperDisease(LR.paraphilias);
pedophiliaDis.addReference("pp 1010-3");
pedophiliaDis.addSymptom(LR.sexualArousalFromChildren);


// ------------- sexualMasochism  -------------
Disease sexualMasochismDis = new Disease(
    LR.sexualMasochism,
    L.sexualMasochismDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
sexualMasochismDis.setPrintName(L.sexualMasochismPrintName);
sexualMasochismDis.setSuperDisease(LR.paraphilias);
sexualMasochismDis.addReference("pp 1010-3");
sexualMasochismDis.addSymptom(LR.sexualArousalFromObtainingRealOrFantasizedPain);


// ------------- sexualSadism  -------------
Disease sexualSadismDis = new Disease(
    LR.sexualSadism,
    L.sexualSadismDescription,
    LR.sexualDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
sexualSadismDis.setPrintName(L.sexualSadismPrintName);
sexualSadismDis.setSuperDisease(LR.paraphilias);
sexualSadismDis.addReference("pp 1010-3");
sexualSadismDis.addSymptom(LR.sexualArousalFromInflictingRealOrFantasizedPain);


// ------------- transvestiteFetishism  -------------
Disease transvestiteFetishismDis = new Disease(
    LR.transvestiteFetishism,
    L.transvestiteFetishismDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
transvestiteFetishismDis.setPrintName(L.transvestiteFetishismPrintName);
transvestiteFetishismDis.setSuperDisease(LR.paraphilias);
transvestiteFetishismDis.addReference("pp 1010-3");
transvestiteFetishismDis.addSymptom(LR.sexualArousalFromCrossDressing);


// ------------- voyeurism  -------------
Disease voyeurismDis = new Disease(
    LR.voyeurism,
    L.voyeurismDescription,
    LR.sexualDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    15, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.sexualSysSt,
    LR.none
);
voyeurismDis.setPrintName(L.voyeurismPrintName);
voyeurismDis.setSuperDisease(LR.paraphilias);
voyeurismDis.addReference("pp 1010-3");
voyeurismDis.addSymptom(LR.sexualArousalFromWatchingSexualSituations);
} // end of sexualDisorders





// ------------- skeletalDisorders  -------------
static public void skeletalDisorders() { 


// ------------- halluxValgus  -------------
Disease halluxValgusDis = new Disease(
    LR.halluxValgus,
    L.halluxValgusDescription,
    LR.skeletalDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    30, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.largeToesSysSt,
    LR.none
);
halluxValgusDis.setPrintName(L.halluxValgusPrintName);
halluxValgusDis.addReference("pp 582-3");
halluxValgusDis.addSymptom(LR.bunion);
Treatment halluxValgusTr1 = new Treatment("halluxValgusTr1", LR.ifSevere);
halluxValgusTr1.addTreatmentAction(LR.surgery);
halluxValgusDis.addTreatment("halluxValgusTr1");


// ------------- kyphoscoliosis  -------------
Disease kyphoscoliosisDis = new Disease(
    LR.kyphoscoliosis,
    L.kyphoscoliosisDescription,
    LR.skeletalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.spineSysSt,
    LR.none
);
kyphoscoliosisDis.setPrintName(L.kyphoscoliosisPrintName);
kyphoscoliosisDis.setWebResource("http://www.meddean.luc.edu/lumen/MedEd/medicine/pulmonar/diseases/pul22.htm");
kyphoscoliosisDis.addCausingAbnormalCondition(LR.hypoxia);
kyphoscoliosisDis.addCausesDisease(LR.corPulmonale);
kyphoscoliosisDis.addReference("pp 587-91");
kyphoscoliosisDis.addSymptom(LR.spineDeformation);


// ------------- kyphosis  -------------
Disease kyphosisDis = new Disease(
    LR.kyphosis,
    L.kyphosisDescription,
    LR.skeletalDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.spineSysSt,
    LR.infection
);
kyphosisDis.setPrintName(L.kyphosisPrintName);
kyphosisDis.addInternalCause(LR.ankylosingSpondylitis);
kyphosisDis.addInternalCause(LR.osteoporosis);
kyphosisDis.addReference("pp 583-5");
kyphosisDis.addSymptom(LR.roundback);
Treatment kyphosisTr1 = new Treatment("kyphosisTr1");
kyphosisTr1.addTreatmentAction(LR.exercise);
kyphosisTr1.addTreatmentAction(LR.surgery);
kyphosisDis.addTreatment("kyphosisTr1");


// ------------- osteoporosis  -------------
Disease osteoporosisDis = new Disease(
    LR.osteoporosis,
    L.osteoporosisDescription,
    LR.skeletalDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    50, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skeletalSysSt,
    LR.lackOfCalciumInDiet
);
osteoporosisDis.setPrintName(L.osteoporosisPrintName);
osteoporosisDis.addExternalCause(LR.sedentaryLifestyle);
osteoporosisDis.setCode358(317);
osteoporosisDis.setICD10code("M80");
osteoporosisDis.addInternalCause(LR.menopause);
osteoporosisDis.addInternalCause(LR.celiacDisease);
osteoporosisDis.addCausesDisease(LR.kyphosis);
osteoporosisDis.addReference("pp 576-7");
osteoporosisDis.addSymptom(LR.backPain);
osteoporosisDis.addSymptom(LR.heightLoss);
Treatment osteoporosisTr1 = new Treatment("osteoporosisTr1");
osteoporosisTr1.addDrug(LR.estrogen);
osteoporosisTr1.addDrug(LR.sodiumFluoride);
osteoporosisTr1.addDrug(LR.vitaminD);
osteoporosisDis.addTreatment("osteoporosisTr1");
} // end of skeletalDisorders





// ------------- skinDisorders  -------------
static public void skinDisorders() { 


// ------------- anthraxCutaneous  -------------
Disease anthraxCutaneousDis = new Disease(
    LR.anthraxCutaneous,
    L.anthraxCutaneousDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.anthracisBacterialInfection
);
anthraxCutaneousDis.setPrintName(L.anthraxCutaneousPrintName);
anthraxCutaneousDis.setSuperDisease(LR.anthrax);
anthraxCutaneousDis.setMiscComments(L.anthraxCutaneousComment);
anthraxCutaneousDis.addReference("pp 1278-9");
anthraxCutaneousDis.addSymptom(LR.bumpItchy);
anthraxCutaneousDis.addSymptom(LR.lymphadenopathy);
anthraxCutaneousDis.addSymptom(LR.ulcer);


// ------------- erypsipelas  -------------
Disease erypsipelasDis = new Disease(
    LR.erypsipelas,
    L.erypsipelasDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
erypsipelasDis.setPrintName(L.erypsipelasPrintName);
erypsipelasDis.setSuperDisease(LR.streptococcalInfection);
erypsipelasDis.setTemperature(102.0f);
erypsipelasDis.addInternalCause(LR.pharyngitisStreptococcal);
erypsipelasDis.addReference("pp 166-7");
erypsipelasDis.addSymptom(LR.throatSore);
erypsipelasDis.addSymptom(LR.vomiting, "", 0.3f);
erypsipelasDis.addSymptom(LR.headache);
erypsipelasDis.addSymptom(LR.lymphadenopathy);
erypsipelasDis.addSymptom(LR.bleb);
erypsipelasDis.addSymptom(LR.skinLesionRedSwollenRaised, L.erypsipelas_skinLesionRedSwollenRaised, 1.0f);
Treatment erypsipelasTr1 = new Treatment("erypsipelasTr1");
erypsipelasTr1.addDrug(LR.analgetics);
erypsipelasTr1.addDrug(LR.topicalAnesthetics);
erypsipelasDis.addTreatment("erypsipelasTr1");


// ------------- impetigo  -------------
Disease impetigoDis = new Disease(
    LR.impetigo,
    L.impetigoDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    2, // minAge
    5, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
impetigoDis.setPrintName(L.impetigoPrintName);
impetigoDis.setSuperDisease(LR.streptococcalInfection);
impetigoDis.setTemperature(102.0f);
impetigoDis.addCausesDisease(LR.cellulitis);
impetigoDis.addCausesDisease(LR.septicemia);
impetigoDis.addReference("pp 168-9");
impetigoDis.addSymptom(LR.erythema);
impetigoDis.addSymptom(LR.itches);
impetigoDis.addSymptom(LR.vesicle);
impetigoDis.addSymptom(LR.maculePustular);
impetigoDis.addSymptom(LR.maculeEncrusted);
Treatment impetigoTr1 = new Treatment("impetigoTr1");
impetigoTr1.addTreatmentAction(LR.woundCare);
impetigoDis.addTreatment("impetigoTr1");


// ------------- scarletFever  -------------
Disease scarletFeverDis = new Disease(
    LR.scarletFever,
    L.scarletFeverDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    2, // minAge
    15, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
scarletFeverDis.setPrintName(L.scarletFeverPrintName);
scarletFeverDis.setSuperDisease(LR.streptococcalInfection);
scarletFeverDis.setMiscComments(L.scarletFeverComment);
scarletFeverDis.setTemperature(102.0f);
scarletFeverDis.setCode358(21);
scarletFeverDis.setICD10code("A38");
scarletFeverDis.addInternalCause(LR.pharyngitisStreptococcal);
scarletFeverDis.addReference("pp 166-7");
scarletFeverDis.addSymptom(LR.erythema);
scarletFeverDis.addSymptom(LR.rashSandpapery);
scarletFeverDis.addSymptom(LR.throatSore);
scarletFeverDis.addSymptom(LR.tongueRed);
scarletFeverDis.addSymptom(LR.abdomenPain, "", 0.3f);
scarletFeverDis.addSymptom(LR.chills, "", 0.3f);
scarletFeverDis.addSymptom(LR.malaise, "", 0.3f);
scarletFeverDis.addSymptom(LR.vomiting, "", 0.3f);


// ------------- streptococcalGangrene  -------------
Disease streptococcalGangreneDis = new Disease(
    LR.streptococcalGangrene,
    L.streptococcalGangreneDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    50, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
streptococcalGangreneDis.setPrintName(L.streptococcalGangrenePrintName);
streptococcalGangreneDis.setSuperDisease(LR.streptococcalInfection);
streptococcalGangreneDis.setTemperature(102.0f);
streptococcalGangreneDis.addCausesAbnormalCondition(LR.hypovolemia);
streptococcalGangreneDis.addReference("pp 168-9");
streptococcalGangreneDis.addSymptom(LR.disorientation);
streptococcalGangreneDis.addSymptom(LR.hypotension);
streptococcalGangreneDis.addSymptom(LR.jaundice);
streptococcalGangreneDis.addSymptom(LR.lethargy);
streptococcalGangreneDis.addSymptom(LR.prostration);
streptococcalGangreneDis.addSymptom(LR.skinLesionRedStreaked, L.streptococcalGangrene_skinLesionRedStreaked, 1.0f);
streptococcalGangreneDis.addSymptom(LR.tachycardia);
Treatment streptococcalGangreneTr1 = new Treatment("streptococcalGangreneTr1");
streptococcalGangreneTr1.addTreatmentAction(LR.surgery);
streptococcalGangreneDis.addTreatment("streptococcalGangreneTr1");


// ------------- cellulitis  -------------
Disease cellulitisDis = new Disease(
    LR.cellulitis,
    L.cellulitisDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.staphylococcusInfection
);
cellulitisDis.setPrintName(L.cellulitisPrintName);
cellulitisDis.setMiscComments(L.cellulitisComment);
cellulitisDis.addExternalCause(LR.streptococcusInfection);
cellulitisDis.addInternalCause(LR.impetigo);
cellulitisDis.addReference("<a HREF='http://www.mayoclinic.com/invoke.cfm?id=DS00450'>http://www.mayoclinic.com/invoke.cfm?id=DS00450</a>");
cellulitisDis.addSymptom(LR.erythema);
cellulitisDis.addSymptom(LR.skinInfection);
cellulitisDis.addSymptom(LR.skinSwollen);
cellulitisDis.addSymptom(LR.skinTender);
cellulitisDis.addSymptom(LR.skinWarm);
Treatment cellulitisTr1 = new Treatment("cellulitisTr1");
cellulitisTr1.addDrug(LR.antibiotics);
cellulitisDis.addTreatment("cellulitisTr1");


// ------------- dermatitis  -------------
Disease dermatitisDis = new Disease(
    LR.dermatitis,
    L.dermatitisDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
dermatitisDis.setPrintName(L.dermatitisPrintName);
dermatitisDis.setMiscComments(L.dermatitisComment);
dermatitisDis.addReference("pp 1255-60");


// ------------- dermatitisAtopic  -------------
Disease dermatitisAtopicDis = new Disease(
    LR.dermatitisAtopic,
    L.dermatitisAtopicDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    20, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.foodAllergies
);
dermatitisAtopicDis.setPrintName(L.dermatitisAtopicPrintName);
dermatitisAtopicDis.setSuperDisease(LR.dermatitis);
dermatitisAtopicDis.setMiscComments(L.dermatitisAtopicComment);
dermatitisAtopicDis.addExternalCause(LR.chemicals);
dermatitisAtopicDis.addExternalCause(LR.extremeHumidity);
dermatitisAtopicDis.addExternalCause(LR.extremeTemperature);
dermatitisAtopicDis.addReference("pp 1255-60");
dermatitisAtopicDis.addSymptom(LR.skinDry);
dermatitisAtopicDis.addSymptom(LR.skinInfection);
dermatitisAtopicDis.addSymptom(LR.skinLesionDryScaly);
dermatitisAtopicDis.addSymptom(LR.skinLesionRedWeeping);
Treatment dermatitisAtopicTr1 = new Treatment("dermatitisAtopicTr1");
dermatitisAtopicTr1.addDrug(LR.corticosteroids);
dermatitisAtopicDis.addTreatment("dermatitisAtopicTr1");


// ------------- dermatitisChronic  -------------
Disease dermatitisChronicDis = new Disease(
    LR.dermatitisChronic,
    L.dermatitisChronicDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    20, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
dermatitisChronicDis.setPrintName(L.dermatitisChronicPrintName);
dermatitisChronicDis.setSuperDisease(LR.dermatitis);
dermatitisChronicDis.addInternalCause(LR.dermatitisContact);
dermatitisChronicDis.addReference("pp 1255-60");
dermatitisChronicDis.addSymptom(LR.skinDry);
dermatitisChronicDis.addSymptom(LR.skinInfection);
dermatitisChronicDis.addSymptom(LR.skinLesionDryScaly);
dermatitisChronicDis.addSymptom(LR.skinLesionHand);
Treatment dermatitisChronicTr1 = new Treatment("dermatitisChronicTr1", LR.ifInfection);
dermatitisChronicTr1.addDrug(LR.antibiotics);
dermatitisChronicDis.addTreatment("dermatitisChronicTr1");
Treatment dermatitisChronicTr2 = new Treatment("dermatitisChronicTr2");
dermatitisChronicTr2.addDrug(LR.antihistamines);
dermatitisChronicTr2.addDrug(LR.corticosteroids);
dermatitisChronicDis.addTreatment("dermatitisChronicTr2");


// ------------- dermatitisContact  -------------
Disease dermatitisContactDis = new Disease(
    LR.dermatitisContact,
    L.dermatitisContactDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.allergens
);
dermatitisContactDis.setPrintName(L.dermatitisContactPrintName);
dermatitisContactDis.setSuperDisease(LR.dermatitis);
dermatitisContactDis.addExternalCause(LR.chemicals);
dermatitisContactDis.addReference("pp 1255-60");
dermatitisContactDis.addSymptom(LR.skinInfection);
Treatment dermatitisContactTr1 = new Treatment("dermatitisContactTr1");
dermatitisContactTr1.addTreatmentAction(LR.protectiveClothing);
dermatitisContactTr1.addDrug(LR.antihistamines);
dermatitisContactTr1.addDrug(LR.corticosteroids);
dermatitisContactDis.addTreatment("dermatitisContactTr1");


// ------------- dermatitisContactMild  -------------
Disease dermatitisContactMildDis = new Disease(
    LR.dermatitisContactMild,
    L.dermatitisContactMildDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
dermatitisContactMildDis.setPrintName(L.dermatitisContactMildPrintName);
dermatitisContactMildDis.setSuperDisease(LR.dermatitisContact);
dermatitisContactMildDis.addReference("pp 1255-60");
dermatitisContactMildDis.addSymptom(LR.erythema);
dermatitisContactMildDis.addSymptom(LR.blisterSmallItch);
dermatitisContactMildDis.addSymptom(LR.blisterSmallOoze);
dermatitisContactMildDis.addSymptom(LR.blisterSmallScale);


// ------------- dermatitisContactStrong  -------------
Disease dermatitisContactStrongDis = new Disease(
    LR.dermatitisContactStrong,
    L.dermatitisContactStrongDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
dermatitisContactStrongDis.setPrintName(L.dermatitisContactStrongPrintName);
dermatitisContactStrongDis.setSuperDisease(LR.dermatitisContact);
dermatitisContactStrongDis.addReference("pp 1255-60");
dermatitisContactStrongDis.addSymptom(LR.blister);
dermatitisContactStrongDis.addSymptom(LR.ulcer);


// ------------- dermatitisContactAllergens  -------------
Disease dermatitisContactAllergensDis = new Disease(
    LR.dermatitisContactAllergens,
    L.dermatitisContactAllergensDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -10, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
dermatitisContactAllergensDis.setPrintName(L.dermatitisContactAllergensPrintName);
dermatitisContactAllergensDis.setSuperDisease(LR.dermatitisContact);
dermatitisContactAllergensDis.addReference("pp 1255-60");
dermatitisContactAllergensDis.addSymptom(LR.edema);


// ------------- dermatitisHerpetiformis  -------------
Disease dermatitisHerpetiformisDis = new Disease(
    LR.dermatitisHerpetiformis,
    L.dermatitisHerpetiformisDescription,
    LR.skinDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
dermatitisHerpetiformisDis.setPrintName(L.dermatitisHerpetiformisPrintName);
dermatitisHerpetiformisDis.setSuperDisease(LR.dermatitis);
dermatitisHerpetiformisDis.setMiscComments(L.dermatitisHerpetiformisComment);
dermatitisHerpetiformisDis.addInternalCause(LR.celiacDisease);
dermatitisHerpetiformisDis.addReference("pp 1284-5");
dermatitisHerpetiformisDis.addSymptom(LR.blister);
dermatitisHerpetiformisDis.addSymptom(LR.burningSensation);
dermatitisHerpetiformisDis.addSymptom(LR.itches);
dermatitisHerpetiformisDis.addSymptom(LR.skinInfection);
dermatitisHerpetiformisDis.addSymptom(LR.skinLesionRedPapular);


// ------------- dermatitisNummular  -------------
Disease dermatitisNummularDis = new Disease(
    LR.dermatitisNummular,
    L.dermatitisNummularDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.limbsSysSt,
    LR.none
);
dermatitisNummularDis.setPrintName(L.dermatitisNummularPrintName);
dermatitisNummularDis.setSuperDisease(LR.dermatitis);
dermatitisNummularDis.addReference("pp 1255-60");
dermatitisNummularDis.addSymptom(LR.skinInfection);
dermatitisNummularDis.addSymptom(LR.itches);
dermatitisNummularDis.addSymptom(LR.skinLesionCoinShaped);
Treatment dermatitisNummularTr1 = new Treatment("dermatitisNummularTr1");
dermatitisNummularTr1.addTreatmentAction(LR.humidifiedAir);
dermatitisNummularTr1.addTreatmentAction(LR.wetDressings);
dermatitisNummularTr1.addDrug(LR.antibiotics);
dermatitisNummularTr1.addDrug(LR.corticosteroids);
dermatitisNummularTr1.addDrug(LR.antihistamines);
dermatitisNummularDis.addTreatment("dermatitisNummularTr1");


// ------------- dermatitisSeborrheic  -------------
Disease dermatitisSeborrheicDis = new Disease(
    LR.dermatitisSeborrheic,
    L.dermatitisSeborrheicDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.scalpSysSt,
    LR.none
);
dermatitisSeborrheicDis.setPrintName(L.dermatitisSeborrheicPrintName);
dermatitisSeborrheicDis.setSuperDisease(LR.dermatitis);
dermatitisSeborrheicDis.addReference("pp 1255-60");
dermatitisSeborrheicDis.addSymptom(LR.skinInfection);
dermatitisSeborrheicDis.addSymptom(LR.itches);
dermatitisSeborrheicDis.addSymptom(LR.skinLesionGreasy, "", 0.5f);
dermatitisSeborrheicDis.addSymptom(LR.skinLesionYellowScales);
Treatment dermatitisSeborrheicTr1 = new Treatment("dermatitisSeborrheicTr1");
dermatitisSeborrheicTr1.addDrug(LR.corticosteroids);
dermatitisSeborrheicDis.addTreatment("dermatitisSeborrheicTr1");


// ------------- dermatophytosis  -------------
Disease dermatophytosisDis = new Disease(
    LR.dermatophytosis,
    L.dermatophytosisDescription,
    LR.skinDisorders,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.fungi
);
dermatophytosisDis.setPrintName(L.dermatophytosisPrintName);
dermatophytosisDis.setMiscComments(L.dermatophytosisComment);
dermatophytosisDis.addReference("pp 1240-2");
Treatment dermatophytosisTr1 = new Treatment("dermatophytosisTr1");
dermatophytosisTr1.addDrug(LR.imidazole);
dermatophytosisTr1.addDrug(LR.griseofulvin);
dermatophytosisDis.addTreatment("dermatophytosisTr1");


// ------------- tineaBarbae  -------------
Disease tineaBarbaeDis = new Disease(
    LR.tineaBarbae,
    L.tineaBarbaeDescription,
    LR.skinDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    15, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.faceSysSt,
    LR.fungi
);
tineaBarbaeDis.setPrintName(L.tineaBarbaePrintName);
tineaBarbaeDis.setSuperDisease(LR.dermatophytosis);
tineaBarbaeDis.setMiscComments(L.tineaBarbaeComment);
tineaBarbaeDis.addReference("pp 1240-2");
tineaBarbaeDis.addSymptom(LR.beardSkinLesions);


// ------------- tineaCapitis  -------------
Disease tineaCapitisDis = new Disease(
    LR.tineaCapitis,
    L.tineaCapitisDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    15, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.scalpSysSt,
    LR.fungi
);
tineaCapitisDis.setPrintName(L.tineaCapitisPrintName);
tineaCapitisDis.setSuperDisease(LR.dermatophytosis);
tineaCapitisDis.setMiscComments(L.tineaCapitisComment);
tineaCapitisDis.addReference("pp 1240-2");
tineaCapitisDis.addSymptom(LR.hairBroken);
tineaCapitisDis.addSymptom(LR.hairLoss);
tineaCapitisDis.addSymptom(LR.scalpNodule);


// ------------- tineaCorporis  -------------
Disease tineaCorporisDis = new Disease(
    LR.tineaCorporis,
    L.tineaCorporisDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    15, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.fungi
);
tineaCorporisDis.setPrintName(L.tineaCorporisPrintName);
tineaCorporisDis.setSuperDisease(LR.dermatophytosis);
tineaCorporisDis.setMiscComments(L.tineaCorporisComment);
tineaCorporisDis.addReference("pp 1240-2");
tineaCorporisDis.addSymptom(LR.skinLesionDryScaly, "", 0.5f);
tineaCorporisDis.addSymptom(LR.skinLesionMoistCrusty, "", 0.5f);
tineaCorporisDis.addSymptom(LR.skinLesionRingShaped);


// ------------- tineaCruris  -------------
Disease tineaCrurisDis = new Disease(
    LR.tineaCruris,
    L.tineaCrurisDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    15, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.groinSysSt,
    LR.fungi
);
tineaCrurisDis.setPrintName(L.tineaCrurisPrintName);
tineaCrurisDis.setSuperDisease(LR.dermatophytosis);
tineaCrurisDis.setMiscComments(L.tineaCrurisComment);
tineaCrurisDis.addReference("pp 1240-2");
tineaCrurisDis.addSymptom(LR.groinLesionItchy);
tineaCrurisDis.addSymptom(LR.groinLesionRed);


// ------------- tineaPedis  -------------
Disease tineaPedisDis = new Disease(
    LR.tineaPedis,
    L.tineaPedisDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    15, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.feetSysSt,
    LR.fungi
);
tineaPedisDis.setPrintName(L.tineaPedisPrintName);
tineaPedisDis.setSuperDisease(LR.dermatophytosis);
tineaPedisDis.setMiscComments(L.tineaPedisComment);
tineaPedisDis.addReference("pp 1240-2");
tineaPedisDis.addSymptom(LR.toesBetweenBlisters);
tineaPedisDis.addSymptom(LR.toesBetweenScaling);


// ------------- tineaUnguium  -------------
Disease tineaUnguiumDis = new Disease(
    LR.tineaUnguium,
    L.tineaUnguiumDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    15, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.toeNailsSysSt,
    LR.fungi
);
tineaUnguiumDis.setPrintName(L.tineaUnguiumPrintName);
tineaUnguiumDis.setSuperDisease(LR.dermatophytosis);
tineaUnguiumDis.setMiscComments(L.tineaUnguiumComment);
tineaUnguiumDis.addReference("pp 1240-2");
tineaUnguiumDis.addSymptom(LR.toeNailCrumble);
tineaUnguiumDis.addSymptom(LR.toeNailDiscolor);
tineaUnguiumDis.addSymptom(LR.toeNailThicken);


// ------------- pediculosis  -------------
Disease pediculosisDis = new Disease(
    LR.pediculosis,
    L.pediculosisDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.lice
);
pediculosisDis.setPrintName(L.pediculosisPrintName);
pediculosisDis.addReference("pp 1244-6");


// ------------- pediculosisCapitis  -------------
Disease pediculosisCapitisDis = new Disease(
    LR.pediculosisCapitis,
    L.pediculosisCapitisDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.scalpSysSt,
    LR.none
);
pediculosisCapitisDis.setPrintName(L.pediculosisCapitisPrintName);
pediculosisCapitisDis.setSuperDisease(LR.pediculosis);
pediculosisCapitisDis.addReference("pp 1244-6");
pediculosisCapitisDis.addSymptom(LR.itches);
pediculosisCapitisDis.addSymptom(LR.hairSmelly);
pediculosisCapitisDis.addSymptom(LR.neckLymphNodeEnlarged);
Treatment pediculosisCapitisTr1 = new Treatment("pediculosisCapitisTr1");
pediculosisCapitisTr1.addTreatmentAction(LR.permethrinCream);
pediculosisCapitisDis.addTreatment("pediculosisCapitisTr1");


// ------------- pediculosisCorporis  -------------
Disease pediculosisCorporisDis = new Disease(
    LR.pediculosisCorporis,
    L.pediculosisCorporisDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
pediculosisCorporisDis.setPrintName(L.pediculosisCorporisPrintName);
pediculosisCorporisDis.setSuperDisease(LR.pediculosis);
pediculosisCorporisDis.addReference("pp 1244-6");
pediculosisCorporisDis.addSymptom(LR.papuleRedSmall);
pediculosisCorporisDis.addSymptom(LR.wheals, L.pediculosisCorporis_wheals, 0.5f);
Treatment pediculosisCorporisTr1 = new Treatment("pediculosisCorporisTr1");
pediculosisCorporisTr1.addTreatmentAction(LR.lindaneCream);
pediculosisCorporisDis.addTreatment("pediculosisCorporisTr1");


// ------------- pediculosisPubis  -------------
Disease pediculosisPubisDis = new Disease(
    LR.pediculosisPubis,
    L.pediculosisPubisDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.pubisHairSysSt,
    LR.none
);
pediculosisPubisDis.setPrintName(L.pediculosisPubisPrintName);
pediculosisPubisDis.setSuperDisease(LR.pediculosis);
pediculosisPubisDis.addReference("pp 1244-6");
pediculosisPubisDis.addIllustration(D.PubicLiceJpg);
pediculosisPubisDis.addSymptom(LR.pubisSkinIrritation);
Treatment pediculosisPubisTr1 = new Treatment("pediculosisPubisTr1");
pediculosisPubisTr1.addTreatmentAction(LR.lindaneShampoo);
pediculosisPubisDis.addTreatment("pediculosisPubisTr1");


// ------------- psoriasis  -------------
Disease psoriasisDis = new Disease(
    LR.psoriasis,
    L.psoriasisDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.stress
);
psoriasisDis.setPrintName(L.psoriasisPrintName);
psoriasisDis.setMiscComments(L.psoriasisComment);
psoriasisDis.addExternalCause(LR.trauma);
psoriasisDis.setGenetic("1parent");
psoriasisDis.setParentDisease(LR.psoriasis);
psoriasisDis.addInternalCause(LR.celiacDisease);
psoriasisDis.addCausingAbnormalCondition(LR.pregnancy);
psoriasisDis.addReference("pp 1264-6");
psoriasisDis.addSymptom(LR.erythema);
psoriasisDis.addSymptom(LR.itches);
psoriasisDis.addSymptom(LR.skinLesionDryScaly);
psoriasisDis.addSymptom(LR.skinLesionCrackedCrusty);
psoriasisDis.addSymptom(LR.skinPlaques);
psoriasisDis.addSymptom(LR.skinSilveryScales);
Treatment psoriasisTr1 = new Treatment("psoriasisTr1");
psoriasisTr1.addDrug(LR.steroidCream);
psoriasisDis.addTreatment("psoriasisTr1");


// ------------- scabies  -------------
Disease scabiesDis = new Disease(
    LR.scabies,
    L.scabiesDescription,
    LR.skinDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.itchMite
);
scabiesDis.setPrintName(L.scabiesPrintName);
scabiesDis.addReference("pp 1242-3");
scabiesDis.addIllustration(D.ScabiesHandJpg);
scabiesDis.addSymptom(LR.elbowLesion);
scabiesDis.addSymptom(LR.fingerLesion);
scabiesDis.addSymptom(LR.itches);
scabiesDis.addSymptom(LR.waistlineLesion);
scabiesDis.addSymptom(LR.wristLesion);
Treatment scabiesTr1 = new Treatment("scabiesTr1");
scabiesTr1.addTreatmentAction(LR.lindaneCream);
scabiesDis.addTreatment("scabiesTr1");
} // end of skinDisorders





// ------------- throatDisorders  -------------
static public void throatDisorders() { 


// ------------- pharyngitis  -------------
Disease pharyngitisDis = new Disease(
    LR.pharyngitis,
    L.pharyngitisDescription,
    LR.throatDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.throatSysSt,
    LR.infection
);
pharyngitisDis.setPrintName(L.pharyngitisPrintName);
pharyngitisDis.setCode358(249);
pharyngitisDis.setICD10code("J02");
pharyngitisDis.addReference("pp 1219-20");
pharyngitisDis.addSymptom(LR.coryza, "", 0.3f);
pharyngitisDis.addSymptom(LR.headache, "", 0.3f);
pharyngitisDis.addSymptom(LR.jointPain, "", 0.3f);
pharyngitisDis.addSymptom(LR.myalgia, "", 0.3f);
pharyngitisDis.addSymptom(LR.dysphagia);
pharyngitisDis.addSymptom(LR.throatSore);
Treatment pharyngitisTr1 = new Treatment("pharyngitisTr1");
pharyngitisTr1.addTreatmentAction(LR.salineGargles);
pharyngitisDis.addTreatment("pharyngitisTr1");


// ------------- pharyngitisBacterial  -------------
Disease pharyngitisBacterialDis = new Disease(
    LR.pharyngitisBacterial,
    L.pharyngitisBacterialDescription,
    LR.throatDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.throatSysSt,
    LR.bacterialInfection
);
pharyngitisBacterialDis.setPrintName(L.pharyngitisBacterialPrintName);
pharyngitisBacterialDis.setSuperDisease(LR.pharyngitis);
pharyngitisBacterialDis.setCode358(249);
pharyngitisBacterialDis.setICD10code("J02");
pharyngitisBacterialDis.addReference("pp 1219-20");
Treatment pharyngitisBacterialTr1 = new Treatment("pharyngitisBacterialTr1");
pharyngitisBacterialTr1.addDrug(LR.antibiotics);
pharyngitisBacterialTr1.addDrug(LR.penicillin);
pharyngitisBacterialDis.addTreatment("pharyngitisBacterialTr1");


// ------------- pharyngitisGonorrhea  -------------
Disease pharyngitisGonorrheaDis = new Disease(
    LR.pharyngitisGonorrhea,
    L.pharyngitisGonorrheaDescription,
    LR.throatDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.throatSysSt,
    LR.bacterialInfection
);
pharyngitisGonorrheaDis.setPrintName(L.pharyngitisGonorrheaPrintName);
pharyngitisGonorrheaDis.setSuperDisease(LR.pharyngitisBacterial);
pharyngitisGonorrheaDis.addExternalCause(LR.gonorrheaInfection);
pharyngitisGonorrheaDis.setCode358(249);
pharyngitisGonorrheaDis.setICD10code("J02");
pharyngitisGonorrheaDis.addInternalCause(LR.gonorrhea);
pharyngitisGonorrheaDis.addReference("pp 1219-20");
pharyngitisGonorrheaDis.addSymptom(LR.feverSym);
pharyngitisGonorrheaDis.addSymptom(LR.neckLymphNodeEnlarged);
pharyngitisGonorrheaDis.addSymptom(LR.neckPain, "", 0.3f);


// ------------- pharyngitisStreptococcal  -------------
Disease pharyngitisStreptococcalDis = new Disease(
    LR.pharyngitisStreptococcal,
    L.pharyngitisStreptococcalDescription,
    LR.throatDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.throatSysSt,
    LR.bacterialInfection
);
pharyngitisStreptococcalDis.setPrintName(L.pharyngitisStreptococcalPrintName);
pharyngitisStreptococcalDis.setSuperDisease(LR.pharyngitisBacterial);
pharyngitisStreptococcalDis.addExternalCause(LR.streptococcusInfection);
pharyngitisStreptococcalDis.setTemperature(102.0f);
pharyngitisStreptococcalDis.setCode358(249);
pharyngitisStreptococcalDis.setICD10code("J02");
pharyngitisStreptococcalDis.addCausesDisease(LR.otitisMedia);
pharyngitisStreptococcalDis.addCausesDisease(LR.sinusitis);
pharyngitisStreptococcalDis.addReference("pp 1219-20");
pharyngitisStreptococcalDis.addSymptom(LR.abdomenPain, "", 0.1f);
pharyngitisStreptococcalDis.addSymptom(LR.anorexia);
pharyngitisStreptococcalDis.addSymptom(LR.feverSym);
pharyngitisStreptococcalDis.addSymptom(LR.malaise);
pharyngitisStreptococcalDis.addSymptom(LR.throatRed);
pharyngitisStreptococcalDis.addSymptom(LR.tonsilsExude);
pharyngitisStreptococcalDis.addSymptom(LR.tonsilsSwollen);
pharyngitisStreptococcalDis.addSymptom(LR.weakness);
Treatment pharyngitisStreptococcalTr1 = new Treatment("pharyngitisStreptococcalTr1");
pharyngitisStreptococcalTr1.addTreatmentAction(LR.bedRest);
pharyngitisStreptococcalTr1.addDrug(LR.analgetics);
pharyngitisStreptococcalTr1.addDrug(LR.antipyretic);
pharyngitisStreptococcalDis.addTreatment("pharyngitisStreptococcalTr1");


// ------------- pharyngitisViral  -------------
Disease pharyngitisViralDis = new Disease(
    LR.pharyngitisViral,
    L.pharyngitisViralDescription,
    LR.throatDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -4, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.throatSysSt,
    LR.virusInfection
);
pharyngitisViralDis.setPrintName(L.pharyngitisViralPrintName);
pharyngitisViralDis.setSuperDisease(LR.pharyngitis);
pharyngitisViralDis.setMiscComments(L.pharyngitisViralComment);
pharyngitisViralDis.setCode358(249);
pharyngitisViralDis.setICD10code("J02");
pharyngitisViralDis.addReference("pp 1219-20");
pharyngitisViralDis.addSymptom(LR.feverSym);
pharyngitisViralDis.addSymptom(LR.neckLymphNodeEnlarged);


// ------------- tonsillitis  -------------
Disease tonsillitisDis = new Disease(
    LR.tonsillitis,
    L.tonsillitisDescription,
    LR.throatDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    5, // minAge
    10, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.tonsilsSysSt,
    LR.infection
);
tonsillitisDis.setPrintName(L.tonsillitisPrintName);
tonsillitisDis.setTemperature(101.0f);
tonsillitisDis.setCode358(249);
tonsillitisDis.setICD10code("J03");
tonsillitisDis.addInternalCause(LR.gonorrhea);
tonsillitisDis.addReference("pp 1220-1");
tonsillitisDis.addSymptom(LR.chills, "", 0.3f);
tonsillitisDis.addSymptom(LR.dysphagia, "", 0.3f);
tonsillitisDis.addSymptom(LR.headache, "", 0.3f);
tonsillitisDis.addSymptom(LR.jointPain, "", 0.3f);
tonsillitisDis.addSymptom(LR.lymphadenopathy, "", 0.3f);
tonsillitisDis.addSymptom(LR.malaise, "", 0.4f);
tonsillitisDis.addSymptom(LR.myalgia, "", 0.3f);
tonsillitisDis.addSymptom(LR.throatSore);
Treatment tonsillitisTr1 = new Treatment("tonsillitisTr1");
tonsillitisTr1.addTreatmentAction(LR.bedRest);
tonsillitisTr1.addTreatmentAction(LR.fluidIncrease);
tonsillitisTr1.addDrug(LR.antibiotics);
tonsillitisTr1.addDrug(LR.penicillin);
tonsillitisTr1.addDrug(LR.ibuprofen);
tonsillitisDis.addTreatment("tonsillitisTr1");
Treatment tonsillitisTr2 = new Treatment("tonsillitisTr2", LR.ifChronic);
tonsillitisTr2.addTreatmentAction(LR.surgery);
tonsillitisDis.addTreatment("tonsillitisTr2");
} // end of throatDisorders





// ------------- traumas  -------------
static public void traumas() { 


// ------------- abdomenTrauma  -------------
Disease abdomenTraumaDis = new Disease(
    LR.abdomenTrauma,
    L.abdomenTraumaDescription,
    LR.traumas,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.trauma
);
abdomenTraumaDis.setPrintName(L.abdomenTraumaPrintName);
abdomenTraumaDis.addReference("pp 290-2");
abdomenTraumaDis.addSymptom(LR.abdomenDistension);
abdomenTraumaDis.addSymptom(LR.abdomenPain);
abdomenTraumaDis.addSymptom(LR.abdomenRigidity);
abdomenTraumaDis.addSymptom(LR.bruising);
abdomenTraumaDis.addSymptom(LR.cyanosis);
abdomenTraumaDis.addSymptom(LR.dyspnea);
abdomenTraumaDis.addSymptom(LR.hypotension);
abdomenTraumaDis.addSymptom(LR.nausea);
abdomenTraumaDis.addSymptom(LR.pallor);
abdomenTraumaDis.addSymptom(LR.rigidity);
abdomenTraumaDis.addSymptom(LR.tachycardia);
abdomenTraumaDis.addSymptom(LR.vomiting);
Treatment abdomenTraumaTr1 = new Treatment("abdomenTraumaTr1");
abdomenTraumaTr1.addTreatmentAction(LR.IVFluids);
abdomenTraumaTr1.addTreatmentAction(LR.surgery);
abdomenTraumaTr1.addDrug(LR.analgetics);
abdomenTraumaTr1.addDrug(LR.antibiotics);
abdomenTraumaDis.addTreatment("abdomenTraumaTr1");


// ------------- beeWaspYellowJacketSting  -------------
Disease beeWaspYellowJacketStingDis = new Disease(
    LR.beeWaspYellowJacketSting,
    L.beeWaspYellowJacketStingDescription,
    LR.traumas,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
beeWaspYellowJacketStingDis.setPrintName(L.beeWaspYellowJacketStingPrintName);
beeWaspYellowJacketStingDis.setMiscComments(L.beeWaspYellowJacketStingComment);
beeWaspYellowJacketStingDis.addReference("pp 320-1");
beeWaspYellowJacketStingDis.addSymptom(LR.insectSting);
beeWaspYellowJacketStingDis.addSymptom(LR.woundPainful);
beeWaspYellowJacketStingDis.addSymptom(LR.edema);
beeWaspYellowJacketStingDis.addSymptom(LR.urticaria);
beeWaspYellowJacketStingDis.addSymptom(LR.pruritus);
beeWaspYellowJacketStingDis.addSymptom(LR.weakness, L.beeWaspYellowJacketSting_weakness, 0.2f);
beeWaspYellowJacketStingDis.addSymptom(LR.chestTightness, L.beeWaspYellowJacketSting_chestTightness, 0.2f);
beeWaspYellowJacketStingDis.addSymptom(LR.dizziness, L.beeWaspYellowJacketSting_dizziness, 0.2f);
beeWaspYellowJacketStingDis.addSymptom(LR.nausea, L.beeWaspYellowJacketSting_nausea, 0.2f);
beeWaspYellowJacketStingDis.addSymptom(LR.vomiting, L.beeWaspYellowJacketSting_vomiting, 0.2f);
beeWaspYellowJacketStingDis.addSymptom(LR.abdomenCramping, L.beeWaspYellowJacketSting_abdomenCramping, 0.2f);
beeWaspYellowJacketStingDis.addSymptom(LR.throatConstriction, L.beeWaspYellowJacketSting_throatConstriction, 0.2f);
Treatment beeWaspYellowJacketStingTr1 = new Treatment("beeWaspYellowJacketStingTr1");
beeWaspYellowJacketStingTr1.addDrug(LR.antihistamines);
beeWaspYellowJacketStingTr1.addDrug(LR.corticosteroids);
beeWaspYellowJacketStingTr1.addDrug(LR.tetanusToxoid);
beeWaspYellowJacketStingDis.addTreatment("beeWaspYellowJacketStingTr1");
Treatment beeWaspYellowJacketStingTr2 = new Treatment("beeWaspYellowJacketStingTr2", LR.ifHypersensitive);
beeWaspYellowJacketStingTr2.addTreatmentAction(LR.oxygenTherapy);
beeWaspYellowJacketStingTr2.addDrug(LR.epinephrine);
beeWaspYellowJacketStingDis.addTreatment("beeWaspYellowJacketStingTr2");
Treatment beeWaspYellowJacketStingTr3 = new Treatment("beeWaspYellowJacketStingTr3", LR.ifBronchospasm);
beeWaspYellowJacketStingTr3.addDrug(LR.albuterol);
beeWaspYellowJacketStingTr3.addDrug(LR.corticosteroids);
beeWaspYellowJacketStingDis.addTreatment("beeWaspYellowJacketStingTr3");
Treatment beeWaspYellowJacketStingTr4 = new Treatment("beeWaspYellowJacketStingTr4", LR.ifHypotension);
beeWaspYellowJacketStingTr4.addDrug(LR.epinephrine);
beeWaspYellowJacketStingTr4.addDrug(LR.isoproterenol);
beeWaspYellowJacketStingDis.addTreatment("beeWaspYellowJacketStingTr4");


// ------------- blackWidowSpiderBite  -------------
Disease blackWidowSpiderBiteDis = new Disease(
    LR.blackWidowSpiderBite,
    L.blackWidowSpiderBiteDescription,
    LR.traumas,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
blackWidowSpiderBiteDis.setPrintName(L.blackWidowSpiderBitePrintName);
blackWidowSpiderBiteDis.setTemperature(100.3f);
blackWidowSpiderBiteDis.addCausesDisease(LR.hypertension);
blackWidowSpiderBiteDis.addCausesAbnormalCondition(LR.circulatoryFailure);
blackWidowSpiderBiteDis.addReference("pp 320-1");
blackWidowSpiderBiteDis.addIllustration(D.BlackwidowGif);
blackWidowSpiderBiteDis.addIllustration(D.BlackwidowJpg);
blackWidowSpiderBiteDis.addSymptom(LR.spiderBite);
blackWidowSpiderBiteDis.addSymptom(LR.biteMarksRed);
blackWidowSpiderBiteDis.addSymptom(LR.abdomenPain);
blackWidowSpiderBiteDis.addSymptom(LR.chills);
blackWidowSpiderBiteDis.addSymptom(LR.edema);
blackWidowSpiderBiteDis.addSymptom(LR.grunting);
blackWidowSpiderBiteDis.addSymptom(LR.headache);
blackWidowSpiderBiteDis.addSymptom(LR.nausea);
blackWidowSpiderBiteDis.addSymptom(LR.pallor);
blackWidowSpiderBiteDis.addSymptom(LR.paralysis);
blackWidowSpiderBiteDis.addSymptom(LR.pruritus);
blackWidowSpiderBiteDis.addSymptom(LR.ptosis);
blackWidowSpiderBiteDis.addSymptom(LR.pulseThready);
blackWidowSpiderBiteDis.addSymptom(LR.reflexesHyperactive);
blackWidowSpiderBiteDis.addSymptom(LR.restlessness);
blackWidowSpiderBiteDis.addSymptom(LR.seizure, L.blackWidowSpiderBite_seizure, 0.2f);
blackWidowSpiderBiteDis.addSymptom(LR.spasm);
blackWidowSpiderBiteDis.addSymptom(LR.dysphagia);
blackWidowSpiderBiteDis.addSymptom(LR.sweating);
blackWidowSpiderBiteDis.addSymptom(LR.tachycardia);
blackWidowSpiderBiteDis.addSymptom(LR.urticaria);
blackWidowSpiderBiteDis.addSymptom(LR.vertigo);
blackWidowSpiderBiteDis.addSymptom(LR.vomiting);
Treatment blackWidowSpiderBiteTr1 = new Treatment("blackWidowSpiderBiteTr1");
blackWidowSpiderBiteTr1.addTreatmentAction(LR.oxygenTherapy);
blackWidowSpiderBiteTr1.addTreatmentAction(LR.antivenin);
blackWidowSpiderBiteTr1.addTreatmentAction(LR.calciumGluconate);
blackWidowSpiderBiteTr1.addDrug(LR.antibiotics);
blackWidowSpiderBiteTr1.addDrug(LR.antihistamines);
blackWidowSpiderBiteTr1.addDrug(LR.diazepam);
blackWidowSpiderBiteTr1.addDrug(LR.tetanusToxoid);
blackWidowSpiderBiteDis.addTreatment("blackWidowSpiderBiteTr1");


// ------------- brownRecluseSpiderBite  -------------
Disease brownRecluseSpiderBiteDis = new Disease(
    LR.brownRecluseSpiderBite,
    L.brownRecluseSpiderBiteDescription,
    LR.traumas,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
brownRecluseSpiderBiteDis.setPrintName(L.brownRecluseSpiderBitePrintName);
brownRecluseSpiderBiteDis.setTemperature(100.3f);
brownRecluseSpiderBiteDis.addReference("pp 318-9");
brownRecluseSpiderBiteDis.addIllustration(D.RecluseJpg);
brownRecluseSpiderBiteDis.addIllustration(D.RecluseBiteGif);
brownRecluseSpiderBiteDis.addSymptom(LR.spiderBite);
brownRecluseSpiderBiteDis.addSymptom(LR.bleb, L.brownRecluseSpiderBite_bleb, 1.0f);
brownRecluseSpiderBiteDis.addSymptom(LR.chills);
brownRecluseSpiderBiteDis.addSymptom(LR.cyanosis);
brownRecluseSpiderBiteDis.addSymptom(LR.edema);
brownRecluseSpiderBiteDis.addSymptom(LR.jointPain);
brownRecluseSpiderBiteDis.addSymptom(LR.malaise);
brownRecluseSpiderBiteDis.addSymptom(LR.petechiae);
brownRecluseSpiderBiteDis.addSymptom(LR.phlebitis, "", 0.3f);
brownRecluseSpiderBiteDis.addSymptom(LR.seizure);
brownRecluseSpiderBiteDis.addSymptom(LR.vomiting);
brownRecluseSpiderBiteDis.addSymptom(LR.weakness);
Treatment brownRecluseSpiderBiteTr1 = new Treatment("brownRecluseSpiderBiteTr1");
brownRecluseSpiderBiteTr1.addTreatmentAction(LR.IVFluids);
brownRecluseSpiderBiteTr1.addDrug(LR.antibiotics);
brownRecluseSpiderBiteTr1.addDrug(LR.antihistamines);
brownRecluseSpiderBiteTr1.addDrug(LR.corticosteroids);
brownRecluseSpiderBiteTr1.addDrug(LR.tetanusToxoid);
brownRecluseSpiderBiteTr1.addDrug(LR.tranquilizer);
brownRecluseSpiderBiteDis.addTreatment("brownRecluseSpiderBiteTr1");


// ------------- burn  -------------
Disease burnDis = new Disease(
    LR.burn,
    L.burnDescription,
    LR.traumas,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.chemicals
);
burnDis.setPrintName(L.burnPrintName);
burnDis.addExternalCause(LR.sunLight);
burnDis.addExternalCause(LR.thermal);
burnDis.addExternalCause(LR.electrical);
burnDis.addExternalCause(LR.friction);
burnDis.addInternalCause(LR.electricShock);
burnDis.addReference("pp 299-302");
Treatment burnTr1 = new Treatment("burnTr1", LR.ifHeartFailure);
burnTr1.addTreatmentAction(LR.CPR);
burnDis.addTreatment("burnTr1");
Treatment burnTr2 = new Treatment("burnTr2", LR.ifRespiratoryFailure);
burnTr2.addTreatmentAction(LR.CPR);
burnDis.addTreatment("burnTr2");


// ------------- burnFirstDegree  -------------
Disease burnFirstDegreeDis = new Disease(
    LR.burnFirstDegree,
    L.burnFirstDegreeDescription,
    LR.traumas,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
burnFirstDegreeDis.setPrintName(L.burnFirstDegreePrintName);
burnFirstDegreeDis.setSuperDisease(LR.burn);
burnFirstDegreeDis.addReference("pp 299-302");
burnFirstDegreeDis.addSymptom(LR.erythema);
burnFirstDegreeDis.addSymptom(LR.skinBurnedPain);
Treatment burnFirstDegreeTr1 = new Treatment("burnFirstDegreeTr1");
burnFirstDegreeTr1.addTreatmentAction(LR.coldCompress);
burnFirstDegreeTr1.addTreatmentAction(LR.painManagement);
burnFirstDegreeDis.addTreatment("burnFirstDegreeTr1");


// ------------- burnSecondDegree  -------------
Disease burnSecondDegreeDis = new Disease(
    LR.burnSecondDegree,
    L.burnSecondDegreeDescription,
    LR.traumas,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
burnSecondDegreeDis.setPrintName(L.burnSecondDegreePrintName);
burnSecondDegreeDis.setSuperDisease(LR.burn);
burnSecondDegreeDis.addReference("pp 299-302");
burnSecondDegreeDis.addSymptom(LR.skinBurnedPain);
burnSecondDegreeDis.addSymptom(LR.blister);
burnSecondDegreeDis.addSymptom(LR.edema);
Treatment burnSecondDegreeTr1 = new Treatment("burnSecondDegreeTr1");
burnSecondDegreeTr1.addTreatmentAction(LR.woundCare);
burnSecondDegreeTr1.addDrug(LR.tetanusToxoid);
burnSecondDegreeDis.addTreatment("burnSecondDegreeTr1");


// ------------- burnThirdDegree  -------------
Disease burnThirdDegreeDis = new Disease(
    LR.burnThirdDegree,
    L.burnThirdDegreeDescription,
    LR.traumas,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
burnThirdDegreeDis.setPrintName(L.burnThirdDegreePrintName);
burnThirdDegreeDis.setSuperDisease(LR.burn);
burnThirdDegreeDis.addReference("pp 299-302");
burnThirdDegreeDis.addSymptom(LR.skinBurnedPain);
burnThirdDegreeDis.addSymptom(LR.skinBurnedLeatheryWhite, "", 0.3f);
burnThirdDegreeDis.addSymptom(LR.skinBurnedLeatheryBrown, "", 0.3f);
burnThirdDegreeDis.addSymptom(LR.skinBurnedLeatheryBlack, "", 0.3f);


// ------------- burnFourthDegree  -------------
Disease burnFourthDegreeDis = new Disease(
    LR.burnFourthDegree,
    L.burnFourthDegreeDescription,
    LR.traumas,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.skinSysSt,
    LR.none
);
burnFourthDegreeDis.setPrintName(L.burnFourthDegreePrintName);
burnFourthDegreeDis.setSuperDisease(LR.burn);
burnFourthDegreeDis.addReference("pp 299-302");
burnFourthDegreeDis.addSymptom(LR.skinBurnedPain);
burnFourthDegreeDis.addSymptom(LR.skinTissueCharred);
Treatment burnFourthDegreeTr1 = new Treatment("burnFourthDegreeTr1", LR.ifRespiratoryFailure);
burnFourthDegreeTr1.addTreatmentAction(LR.endotrachealIntubation);
burnFourthDegreeDis.addTreatment("burnFourthDegreeTr1");
Treatment burnFourthDegreeTr2 = new Treatment("burnFourthDegreeTr2");
burnFourthDegreeTr2.addTreatmentAction(LR.IVFluids);
burnFourthDegreeDis.addTreatment("burnFourthDegreeTr2");


// ------------- cerebralContusion  -------------
Disease cerebralContusionDis = new Disease(
    LR.cerebralContusion,
    L.cerebralContusionDescription,
    LR.traumas,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.brainSysSt,
    LR.trauma
);
cerebralContusionDis.setPrintName(L.cerebralContusionPrintName);
cerebralContusionDis.addCausesAbnormalCondition(LR.death);
cerebralContusionDis.addReference("pp 276-8");
cerebralContusionDis.addSymptom(LR.confusion);
cerebralContusionDis.addSymptom(LR.consciousnessLoss);
cerebralContusionDis.addSymptom(LR.decerebratePosturing);
cerebralContusionDis.addSymptom(LR.disorientation);
cerebralContusionDis.addSymptom(LR.drowsiness);
cerebralContusionDis.addSymptom(LR.hemiparesis);
cerebralContusionDis.addSymptom(LR.pupilResponseUnequal);
cerebralContusionDis.addSymptom(LR.respirationLabored);
cerebralContusionDis.addSymptom(LR.scalpWound);
Treatment cerebralContusionTr1 = new Treatment("cerebralContusionTr1");
cerebralContusionTr1.addTreatmentAction(LR.fluidRestriction);
cerebralContusionTr1.addTreatmentAction(LR.airwayMaintenance);
cerebralContusionTr1.addTreatmentAction(LR.bedHeadElevated);
cerebralContusionTr1.addTreatmentAction(LR.hyperventilationAfterIntubation);
cerebralContusionTr1.addDrug(LR.mannitol);
cerebralContusionTr1.addDrug(LR.dexamethasone);
cerebralContusionDis.addTreatment("cerebralContusionTr1");


// ------------- electricShock  -------------
Disease electricShockDis = new Disease(
    LR.electricShock,
    L.electricShockDescription,
    LR.traumas,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.contactWithElectricalPower
);
electricShockDis.setPrintName(L.electricShockPrintName);
electricShockDis.addCausesDisease(LR.burn);
electricShockDis.addCausesDisease(LR.myocardialInfarction);
electricShockDis.addReference("pp 302-4");
electricShockDis.addSymptom(LR.arrhythmia);
electricShockDis.addSymptom(LR.cataract);
electricShockDis.addSymptom(LR.consciousnessLoss);
electricShockDis.addSymptom(LR.hearingLoss);
electricShockDis.addSymptom(LR.lymphadenopathy);
electricShockDis.addSymptom(LR.muscleContractions);
electricShockDis.addSymptom(LR.reflexControlLoss);
electricShockDis.addSymptom(LR.respirationParalysis);
Treatment electricShockTr1 = new Treatment("electricShockTr1");
electricShockTr1.addTreatmentAction(LR.CPR);
electricShockTr1.addTreatmentAction(LR.lactatedRingerSolution);
electricShockTr1.addTreatmentAction(LR.surgicalDebridement);
electricShockTr1.addDrug(LR.furosemide);
electricShockTr1.addDrug(LR.mannitol);
electricShockTr1.addDrug(LR.sodiumBicarbonate);
electricShockDis.addTreatment("electricShockTr1");


// ------------- intracerebralHemorrhage  -------------
Disease intracerebralHemorrhageDis = new Disease(
    LR.intracerebralHemorrhage,
    L.intracerebralHemorrhageDescription,
    LR.traumas,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.brainSysSt,
    LR.headTrauma
);
intracerebralHemorrhageDis.setPrintName(L.intracerebralHemorrhagePrintName);
intracerebralHemorrhageDis.setCode358(236);
intracerebralHemorrhageDis.setICD10code("I61");
intracerebralHemorrhageDis.addReference("pp 276-278");
intracerebralHemorrhageDis.addSymptom(LR.aphasia);
intracerebralHemorrhageDis.addSymptom(LR.dizziness);
intracerebralHemorrhageDis.addSymptom(LR.headache);
intracerebralHemorrhageDis.addSymptom(LR.hemiparesis);
intracerebralHemorrhageDis.addSymptom(LR.nausea);
intracerebralHemorrhageDis.addSymptom(LR.seizure);
intracerebralHemorrhageDis.addSymptom(LR.vomiting);
Treatment intracerebralHemorrhageTr1 = new Treatment("intracerebralHemorrhageTr1");
intracerebralHemorrhageTr1.addTreatmentAction(LR.surgery);
intracerebralHemorrhageDis.addTreatment("intracerebralHemorrhageTr1");


// ------------- penetratingChestWound  -------------
Disease penetratingChestWoundDis = new Disease(
    LR.penetratingChestWound,
    L.penetratingChestWoundDescription,
    LR.traumas,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
penetratingChestWoundDis.setPrintName(L.penetratingChestWoundPrintName);
penetratingChestWoundDis.addReference("pp 289-90");
penetratingChestWoundDis.addSymptom(LR.chestPainSevere);
penetratingChestWoundDis.addSymptom(LR.consciousnessDecreased);
penetratingChestWoundDis.addSymptom(LR.pulseThready);
penetratingChestWoundDis.addSymptom(LR.pulseWeak);
penetratingChestWoundDis.addSymptom(LR.suckingSoundWhileBreathing);
penetratingChestWoundDis.addSymptom(LR.tachycardia);
Treatment penetratingChestWoundTr1 = new Treatment("penetratingChestWoundTr1");
penetratingChestWoundTr1.addTreatmentAction(LR.airwayMaintenance);
penetratingChestWoundTr1.addTreatmentAction(LR.bleedingControl);
penetratingChestWoundTr1.addTreatmentAction(LR.bloodTransfusion);
penetratingChestWoundTr1.addTreatmentAction(LR.chestTubeDrainage);
penetratingChestWoundTr1.addTreatmentAction(LR.IVFluids);
penetratingChestWoundTr1.addTreatmentAction(LR.surgery);
penetratingChestWoundDis.addTreatment("penetratingChestWoundTr1");


// ------------- poisoning  -------------
Disease poisoningDis = new Disease(
    LR.poisoning,
    L.poisoningDescription,
    LR.traumas,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
poisoningDis.setPrintName(L.poisoningPrintName);
poisoningDis.addReference("pp 313-5");
poisoningDis.addSymptom(LR.chestPain);
poisoningDis.addSymptom(LR.consciousnessLoss);
poisoningDis.addSymptom(LR.dizziness);
poisoningDis.addSymptom(LR.headache);
poisoningDis.addSymptom(LR.muscleWeakness);
poisoningDis.addSymptom(LR.nausea);
poisoningDis.addSymptom(LR.seizure);
poisoningDis.addSymptom(LR.vomiting);
Treatment poisoningTr1 = new Treatment("poisoningTr1");
poisoningTr1.addTreatmentAction(LR.CPR);
poisoningTr1.addTreatmentAction(LR.IVFluids);
poisoningTr1.addTreatmentAction(LR.oxygenTherapy);
poisoningTr1.addTreatmentAction(LR.seizurePrecautions);
poisoningTr1.addTreatmentAction(LR.placedOnLeftSide);
poisoningTr1.addDrug(LR.poisonAntidote);
poisoningDis.addTreatment("poisoningTr1");


// ------------- poisonousSnakeBite  -------------
Disease poisonousSnakeBiteDis = new Disease(
    LR.poisonousSnakeBite,
    L.poisonousSnakeBiteDescription,
    LR.traumas,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
poisonousSnakeBiteDis.setPrintName(L.poisonousSnakeBitePrintName);
poisonousSnakeBiteDis.setTemperature(100.3f);
poisonousSnakeBiteDis.addReference("pp 315-9");
poisonousSnakeBiteDis.addSymptom(LR.bleb);
poisonousSnakeBiteDis.addSymptom(LR.blister);
poisonousSnakeBiteDis.addSymptom(LR.bloodyWoundDischarge);
poisonousSnakeBiteDis.addSymptom(LR.ecchymoses);
poisonousSnakeBiteDis.addSymptom(LR.edema);
poisonousSnakeBiteDis.addSymptom(LR.necrosis);
poisonousSnakeBiteDis.addSymptom(LR.pain);
poisonousSnakeBiteDis.addSymptom(LR.petechiae);
poisonousSnakeBiteDis.addSymptom(LR.skinMottled);
Treatment poisonousSnakeBiteTr1 = new Treatment("poisonousSnakeBiteTr1");
poisonousSnakeBiteTr1.addTreatmentAction(LR.IVFluids);
poisonousSnakeBiteTr1.addTreatmentAction(LR.bloodTransfusion);
poisonousSnakeBiteTr1.addTreatmentAction(LR.endotrachealIntubation);
poisonousSnakeBiteTr1.addTreatmentAction(LR.mechanicalVentilation);
poisonousSnakeBiteTr1.addTreatmentAction(LR.lieDownPatient);
poisonousSnakeBiteTr1.addTreatmentAction(LR.positionBittenLimbBelowHeart);
poisonousSnakeBiteTr1.addTreatmentAction(LR.surgicalDebridement);
poisonousSnakeBiteTr1.addDrug(LR.analgetics);
poisonousSnakeBiteTr1.addDrug(LR.antivenin);
poisonousSnakeBiteDis.addTreatment("poisonousSnakeBiteTr1");


// ------------- scorpionSting  -------------
Disease scorpionStingDis = new Disease(
    LR.scorpionSting,
    L.scorpionStingDescription,
    LR.traumas,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.none
);
scorpionStingDis.setPrintName(L.scorpionStingPrintName);
scorpionStingDis.setMiscComments(L.scorpionStingComment);
scorpionStingDis.addReference("pp 320-1");
scorpionStingDis.addIllustration(D.ScorpionGif);
scorpionStingDis.addSymptom(LR.insectSting);
scorpionStingDis.addSymptom(LR.swellingLocal);
scorpionStingDis.addSymptom(LR.tendernessLocal);
scorpionStingDis.addSymptom(LR.burningSensation);
scorpionStingDis.addSymptom(LR.skinDiscoloration);
scorpionStingDis.addSymptom(LR.paresthesia);
scorpionStingDis.addSymptom(LR.lymphadenopathy);
scorpionStingDis.addSymptom(LR.painSharp);
scorpionStingDis.addSymptom(LR.hyperesthesia);
scorpionStingDis.addSymptom(LR.drowsiness);
scorpionStingDis.addSymptom(LR.noseItches);
scorpionStingDis.addSymptom(LR.throatItches);
scorpionStingDis.addSymptom(LR.mouthItches);
scorpionStingDis.addSymptom(LR.speechDifficulty);
scorpionStingDis.addSymptom(LR.spasm);
scorpionStingDis.addSymptom(LR.nausea);
scorpionStingDis.addSymptom(LR.vomiting);
scorpionStingDis.addSymptom(LR.drooling);
Treatment scorpionStingTr1 = new Treatment("scorpionStingTr1");
scorpionStingTr1.addDrug(LR.antivenin);
scorpionStingTr1.addDrug(LR.calciumGluconate);
scorpionStingTr1.addDrug(LR.phenobarbital);
scorpionStingDis.addTreatment("scorpionStingTr1");


// ------------- skullFracture  -------------
Disease skullFractureDis = new Disease(
    LR.skullFracture,
    L.skullFractureDescription,
    LR.traumas,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.brainSysSt,
    LR.blowToTheHead
);
skullFractureDis.setPrintName(L.skullFracturePrintName);
skullFractureDis.addCausesDisease(LR.hypertension);
skullFractureDis.addReference("pp 278-81");
skullFractureDis.addSymptom(LR.agitation);
skullFractureDis.addSymptom(LR.bleedingSkull);
skullFractureDis.addSymptom(LR.cerebrospinalFluidLeakage);
skullFractureDis.addSymptom(LR.consciousnessLoss);
skullFractureDis.addSymptom(LR.ecchymosesFace);
skullFractureDis.addSymptom(LR.irritability);
skullFractureDis.addSymptom(LR.reflexesDecreased);
skullFractureDis.addSymptom(LR.seizure);
skullFractureDis.addSymptom(LR.vomiting);
Treatment skullFractureTr1 = new Treatment("skullFractureTr1");
skullFractureTr1.addTreatmentAction(LR.IVFluids);
skullFractureTr1.addTreatmentAction(LR.bloodTransfusion);
skullFractureTr1.addTreatmentAction(LR.endotrachealIntubation);
skullFractureTr1.addTreatmentAction(LR.mechanicalVentilation);
skullFractureTr1.addTreatmentAction(LR.craniotomy);
skullFractureTr1.addDrug(LR.analgetics);
skullFractureTr1.addDrug(LR.antibiotics);
skullFractureTr1.addDrug(LR.dexamethasone);
skullFractureDis.addTreatment("skullFractureTr1");


// ------------- tickBite  -------------
Disease tickBiteDis = new Disease(
    LR.tickBite,
    L.tickBiteDescription,
    LR.traumas,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bodySysSt,
    LR.tickBite
);
tickBiteDis.setPrintName(L.tickBitePrintName);
tickBiteDis.setTemperature(100.3f);
tickBiteDis.addCausesDisease(LR.lymeDisease);
tickBiteDis.addCausesDisease(LR.rockyMountainSpottedFever);
tickBiteDis.addReference("pp 318-9");
tickBiteDis.addIllustration(D.TickGif);
tickBiteDis.addSymptom(LR.tickInSkin);
tickBiteDis.addSymptom(LR.itches);
Treatment tickBiteTr1 = new Treatment("tickBiteTr1");
tickBiteTr1.addTreatmentAction(LR.removeTick);
tickBiteTr1.addDrug(LR.antipruritics);
tickBiteDis.addTreatment("tickBiteTr1");
Treatment tickBiteTr2 = new Treatment("tickBiteTr2", LR.ifRespiratoryFailure);
tickBiteTr2.addTreatmentAction(LR.mechanicalVentilation);
tickBiteDis.addTreatment("tickBiteTr2");
} // end of traumas





// ------------- urologicDisorders  -------------
static public void urologicDisorders() { 


// ------------- benignProstaticHyperplasia  -------------
Disease benignProstaticHyperplasiaDis = new Disease(
    LR.benignProstaticHyperplasia,
    L.benignProstaticHyperplasiaDescription,
    LR.urologicDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    50, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.prostateSysSt,
    LR.none
);
benignProstaticHyperplasiaDis.setPrintName(L.benignProstaticHyperplasiaPrintName);
benignProstaticHyperplasiaDis.addReference("pp 804-6");
Treatment benignProstaticHyperplasiaTr1 = new Treatment("benignProstaticHyperplasiaTr1");
benignProstaticHyperplasiaTr1.addTreatmentAction(LR.fluidRestriction);
benignProstaticHyperplasiaTr1.addTreatmentAction(LR.massage);
benignProstaticHyperplasiaTr1.addTreatmentAction(LR.sitzBath);
benignProstaticHyperplasiaTr1.addTreatmentAction(LR.regularEjaculation);
benignProstaticHyperplasiaDis.addTreatment("benignProstaticHyperplasiaTr1");
Treatment benignProstaticHyperplasiaTr2 = new Treatment("benignProstaticHyperplasiaTr2", LR.ifInfection);
benignProstaticHyperplasiaTr2.addDrug(LR.antimicrobials);
benignProstaticHyperplasiaDis.addTreatment("benignProstaticHyperplasiaTr2");
Treatment benignProstaticHyperplasiaTr3 = new Treatment("benignProstaticHyperplasiaTr3");
benignProstaticHyperplasiaTr3.addDrug(LR.prazosin);
benignProstaticHyperplasiaTr3.addDrug(LR.terazosin);
benignProstaticHyperplasiaDis.addTreatment("benignProstaticHyperplasiaTr3");
Treatment benignProstaticHyperplasiaTr4 = new Treatment("benignProstaticHyperplasiaTr4");
benignProstaticHyperplasiaTr4.addDrug(LR.finasteride);
benignProstaticHyperplasiaDis.addTreatment("benignProstaticHyperplasiaTr4");


// ------------- benignProstaticHyperplasia1  -------------
Disease benignProstaticHyperplasia1Dis = new Disease(
    LR.benignProstaticHyperplasia1,
    L.benignProstaticHyperplasia1Description,
    LR.urologicDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    50, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.prostateSysSt,
    LR.none
);
benignProstaticHyperplasia1Dis.setPrintName(L.benignProstaticHyperplasia1PrintName);
benignProstaticHyperplasia1Dis.setSuperDisease(LR.benignProstaticHyperplasia);
benignProstaticHyperplasia1Dis.addCausesDisease(LR.benignProstaticHyperplasia2);
benignProstaticHyperplasia1Dis.addReference("pp 804-6");
benignProstaticHyperplasia1Dis.addSymptom(LR.urinaryHesitancy);
benignProstaticHyperplasia1Dis.addSymptom(LR.urinaryStreamInterrupted);
benignProstaticHyperplasia1Dis.addSymptom(LR.urinaryStreamReduced);
benignProstaticHyperplasia1Dis.addSymptom(LR.urinationStartDifficult);


// ------------- benignProstaticHyperplasia2  -------------
Disease benignProstaticHyperplasia2Dis = new Disease(
    LR.benignProstaticHyperplasia2,
    L.benignProstaticHyperplasia2Description,
    LR.urologicDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    50, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.prostateSysSt,
    LR.none
);
benignProstaticHyperplasia2Dis.setPrintName(L.benignProstaticHyperplasia2PrintName);
benignProstaticHyperplasia2Dis.setSuperDisease(LR.benignProstaticHyperplasia);
benignProstaticHyperplasia2Dis.addInternalCause(LR.benignProstaticHyperplasia1);
benignProstaticHyperplasia2Dis.addCausesDisease(LR.anemia);
benignProstaticHyperplasia2Dis.addCausesAbnormalCondition(LR.infectionsSevere);
benignProstaticHyperplasia2Dis.addCausesAbnormalCondition(LR.shock);
benignProstaticHyperplasia2Dis.addReference("pp 804-6");
benignProstaticHyperplasia2Dis.addSymptom(LR.urinaryHesitancy);
benignProstaticHyperplasia2Dis.addSymptom(LR.urinaryStreamInterrupted);
benignProstaticHyperplasia2Dis.addSymptom(LR.urinaryStreamReduced);
benignProstaticHyperplasia2Dis.addSymptom(LR.urinationStartDifficult);
benignProstaticHyperplasia2Dis.addSymptom(LR.hematuria);
benignProstaticHyperplasia2Dis.addSymptom(LR.nocturia);
benignProstaticHyperplasia2Dis.addSymptom(LR.urinaryFrequency);
benignProstaticHyperplasia2Dis.addSymptom(LR.incontinence);
Treatment benignProstaticHyperplasia2Tr3 = new Treatment("benignProstaticHyperplasia2Tr3", LR.ifAcuteUrinaryBlockage);
benignProstaticHyperplasia2Tr3.addTreatmentAction(LR.surgery);
benignProstaticHyperplasia2Dis.addTreatment("benignProstaticHyperplasia2Tr3");


// ------------- prostatitis  -------------
Disease prostatitisDis = new Disease(
    LR.prostatitis,
    L.prostatitisDescription,
    LR.urologicDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.prostateSysSt,
    LR.klebsiellaInfection
);
prostatitisDis.setPrintName(L.prostatitisPrintName);
prostatitisDis.addExternalCause(LR.escherichiaColiInfection);
prostatitisDis.addExternalCause(LR.staphylococcusInfection);
prostatitisDis.addExternalCause(LR.streptococcusInfection);
prostatitisDis.addExternalCause(LR.enterobacterInfection);
prostatitisDis.addExternalCause(LR.proteusInfection);
prostatitisDis.addExternalCause(LR.pseudomonasInfection);
prostatitisDis.addReference("pp 802-3");
Treatment prostatitisTr1 = new Treatment("prostatitisTr1");
prostatitisTr1.addTreatmentAction(LR.bedRest);
prostatitisTr1.addTreatmentAction(LR.fluidIncrease);
prostatitisTr1.addTreatmentAction(LR.sitzBath);
prostatitisTr1.addDrug(LR.analgetics);
prostatitisTr1.addDrug(LR.antipyretic);
prostatitisTr1.addDrug(LR.stoolSoftener);
prostatitisDis.addTreatment("prostatitisTr1");
Treatment prostatitisTr2 = new Treatment("prostatitisTr2");
prostatitisTr2.addTreatmentAction(LR.massage);
prostatitisTr2.addTreatmentAction(LR.regularEjaculation);
prostatitisDis.addTreatment("prostatitisTr2");
Treatment prostatitisTr3 = new Treatment("prostatitisTr3", LR.ifSevere);
prostatitisTr3.addTreatmentAction(LR.surgery);
prostatitisDis.addTreatment("prostatitisTr3");


// ------------- prostatitisAcute  -------------
Disease prostatitisAcuteDis = new Disease(
    LR.prostatitisAcute,
    L.prostatitisAcuteDescription,
    LR.urologicDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.prostateSysSt,
    LR.none
);
prostatitisAcuteDis.setPrintName(L.prostatitisAcutePrintName);
prostatitisAcuteDis.setSuperDisease(LR.prostatitis);
prostatitisAcuteDis.setTemperature(102.0f);
prostatitisAcuteDis.addCausesDisease(LR.prostatitisChronic);
prostatitisAcuteDis.addCausesAbnormalCondition(LR.prostateFirm);
prostatitisAcuteDis.addCausesAbnormalCondition(LR.prostateSwollen);
prostatitisAcuteDis.addCausesAbnormalCondition(LR.prostateTender);
prostatitisAcuteDis.addReference("pp 802-3");
prostatitisAcuteDis.addSymptom(LR.arthralgia);
prostatitisAcuteDis.addSymptom(LR.chills);
prostatitisAcuteDis.addSymptom(LR.dysuria, "", 0.3f);
prostatitisAcuteDis.addSymptom(LR.lowBackPain);
prostatitisAcuteDis.addSymptom(LR.myalgia);
prostatitisAcuteDis.addSymptom(LR.nocturia, "", 0.3f);
prostatitisAcuteDis.addSymptom(LR.urinaryFrequency);
prostatitisAcuteDis.addSymptom(LR.urineCloudy, "", 0.1f);
Treatment prostatitisAcuteTr1 = new Treatment("prostatitisAcuteTr1");
prostatitisAcuteTr1.addDrug(LR.antibiotics);
prostatitisAcuteDis.addTreatment("prostatitisAcuteTr1");


// ------------- prostatitisChronic  -------------
Disease prostatitisChronicDis = new Disease(
    LR.prostatitisChronic,
    L.prostatitisChronicDescription,
    LR.urologicDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    150, // maxAge
    -11, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.prostateSysSt,
    LR.none
);
prostatitisChronicDis.setPrintName(L.prostatitisChronicPrintName);
prostatitisChronicDis.setSuperDisease(LR.prostatitis);
prostatitisChronicDis.addInternalCause(LR.prostatitisAcute);
prostatitisChronicDis.addReference("pp 802-3");
prostatitisChronicDis.addSymptom(LR.arthralgia, "", 0.5f);
prostatitisChronicDis.addSymptom(LR.chills, "", 0.5f);
prostatitisChronicDis.addSymptom(LR.dysuria, "", 0.2f);
prostatitisChronicDis.addSymptom(LR.lowBackPain, "", 0.5f);
prostatitisChronicDis.addSymptom(LR.myalgia, "", 0.5f);
prostatitisChronicDis.addSymptom(LR.nocturia, "", 0.1f);
prostatitisChronicDis.addSymptom(LR.urinaryFrequency, "", 0.5f);
prostatitisChronicDis.addSymptom(LR.urineCloudy, "", 0.1f);
prostatitisChronicDis.addSymptom(LR.ejaculationPainful, "", 0.5f);
prostatitisChronicDis.addSymptom(LR.sexualDysfunction, "", 0.5f);
prostatitisChronicDis.addSymptom(LR.urethraMaleDischarge, "", 0.5f);
prostatitisChronicDis.addSymptom(LR.hemospermia, "", 0.2f);
Treatment prostatitisChronicTr1 = new Treatment("prostatitisChronicTr1");
prostatitisChronicTr1.addDrug(LR.coTrimoxazole);
prostatitisChronicDis.addTreatment("prostatitisChronicTr1");


// ------------- urinaryTractInfection  -------------
Disease urinaryTractInfectionDis = new Disease(
    LR.urinaryTractInfection,
    L.urinaryTractInfectionDescription,
    LR.urologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.urologicSysSt,
    LR.bacterialInfection
);
urinaryTractInfectionDis.setPrintName(L.urinaryTractInfectionPrintName);
urinaryTractInfectionDis.setCode358(330);
urinaryTractInfectionDis.setICD10code("N39");
urinaryTractInfectionDis.addInternalCause(LR.diabetesMellitusAdvanced);
urinaryTractInfectionDis.addReference("pp 792-4");
urinaryTractInfectionDis.addSymptom(LR.abdomenPain);
urinaryTractInfectionDis.addSymptom(LR.abdomenTenderness);
urinaryTractInfectionDis.addSymptom(LR.bladderCramp);
urinaryTractInfectionDis.addSymptom(LR.chills);
urinaryTractInfectionDis.addSymptom(LR.dysuria);
urinaryTractInfectionDis.addSymptom(LR.flankPain);
urinaryTractInfectionDis.addSymptom(LR.lowBackPain);
urinaryTractInfectionDis.addSymptom(LR.malaise);
urinaryTractInfectionDis.addSymptom(LR.nausea);
urinaryTractInfectionDis.addSymptom(LR.nocturia);
urinaryTractInfectionDis.addSymptom(LR.urinaryFrequency);
urinaryTractInfectionDis.addSymptom(LR.urinaryUrgency);
urinaryTractInfectionDis.addSymptom(LR.vomiting);
Treatment urinaryTractInfectionTr1 = new Treatment("urinaryTractInfectionTr1");
urinaryTractInfectionTr1.addDrug(LR.antimicrobials);
urinaryTractInfectionDis.addTreatment("urinaryTractInfectionTr1");


// ------------- cystitis  -------------
Disease cystitisDis = new Disease(
    LR.cystitis,
    L.cystitisDescription,
    LR.urologicDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bladderSysSt,
    LR.none
);
cystitisDis.setPrintName(L.cystitisPrintName);
cystitisDis.setSuperDisease(LR.urinaryTractInfection);
cystitisDis.setTemperature(101.0f);
cystitisDis.addInternalCause(LR.prostateCancer);
cystitisDis.addReference("pp 792-4");
cystitisDis.addSymptom(LR.hematuria);


// ------------- urethritisML  -------------
Disease urethritisMLDis = new Disease(
    LR.urethritisML,
    L.urethritisMLDescription,
    LR.urologicDisorders,
    LR.male, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -3, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.bladderSysSt,
    LR.none
);
urethritisMLDis.setPrintName(L.urethritisMLPrintName);
urethritisMLDis.setSuperDisease(LR.urinaryTractInfection);
urethritisMLDis.addInternalCause(LR.trichomoniasisMale);
urethritisMLDis.addReference("pp 792-4");
urethritisMLDis.addSymptom(LR.urethraMaleDischarge);
} // end of urologicDisorders





// ------------- vascularDisorders  -------------
static public void vascularDisorders() { 


// ------------- dissectingAbdomenAortaAneurysm  -------------
Disease dissectingAbdomenAortaAneurysmDis = new Disease(
    LR.dissectingAbdomenAortaAneurysm,
    L.dissectingAbdomenAortaAneurysmDescription,
    LR.vascularDisorders,
    LR.moreMale, // genderSpecificity
    LR.caucasian, // raceSpecificity
    50, // minAge
    80, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vascularSysSt,
    LR.none
);
dissectingAbdomenAortaAneurysmDis.setPrintName(L.dissectingAbdomenAortaAneurysmPrintName);
dissectingAbdomenAortaAneurysmDis.addReference("pp 1137-40");
dissectingAbdomenAortaAneurysmDis.addSymptom(LR.hypotension);
dissectingAbdomenAortaAneurysmDis.addSymptom(LR.sweating);
dissectingAbdomenAortaAneurysmDis.addSymptom(LR.tachycardia);
dissectingAbdomenAortaAneurysmDis.addSymptom(LR.weakness);
dissectingAbdomenAortaAneurysmDis.addSymptom(LR.flankPain);
dissectingAbdomenAortaAneurysmDis.addSymptom(LR.groinPain);
Treatment dissectingAbdomenAortaAneurysmTr1 = new Treatment("dissectingAbdomenAortaAneurysmTr1");
dissectingAbdomenAortaAneurysmTr1.addTreatmentAction(LR.fluidManagement);
dissectingAbdomenAortaAneurysmTr1.addTreatmentAction(LR.surgery);
dissectingAbdomenAortaAneurysmTr1.addTreatmentAction(LR.pneumaticAntishockGarment);
dissectingAbdomenAortaAneurysmDis.addTreatment("dissectingAbdomenAortaAneurysmTr1");


// ------------- patentDuctusArteriosus  -------------
Disease patentDuctusArteriosusDis = new Disease(
    LR.patentDuctusArteriosus,
    L.patentDuctusArteriosusDescription,
    LR.vascularDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.pulmonaryArterySysSt,
    LR.none
);
patentDuctusArteriosusDis.setPrintName(L.patentDuctusArteriosusPrintName);
patentDuctusArteriosusDis.addReference("pp 1074-6");
patentDuctusArteriosusDis.addSymptom(LR.respirationDistress);
Treatment patentDuctusArteriosusTr1 = new Treatment("patentDuctusArteriosusTr1", LR.ifSevere);
patentDuctusArteriosusTr1.addTreatmentAction(LR.surgery);
patentDuctusArteriosusDis.addTreatment("patentDuctusArteriosusTr1");


// ------------- patentDuctusArteriosusInfant  -------------
Disease patentDuctusArteriosusInfantDis = new Disease(
    LR.patentDuctusArteriosusInfant,
    L.patentDuctusArteriosusInfantDescription,
    LR.vascularDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    6, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.pulmonaryArterySysSt,
    LR.none
);
patentDuctusArteriosusInfantDis.setPrintName(L.patentDuctusArteriosusInfantPrintName);
patentDuctusArteriosusInfantDis.setSuperDisease(LR.patentDuctusArteriosus);
patentDuctusArteriosusInfantDis.addReference("pp 1074-6");
patentDuctusArteriosusInfantDis.addSymptom(LR.motorDysfunction);
patentDuctusArteriosusInfantDis.addSymptom(LR.developmentSlow);
Treatment patentDuctusArteriosusInfantTr1 = new Treatment("patentDuctusArteriosusInfantTr1");
patentDuctusArteriosusInfantTr1.addTreatmentAction(LR.fluidRestriction);
patentDuctusArteriosusInfantTr1.addDrug(LR.digitalisGlycosides);
patentDuctusArteriosusInfantTr1.addDrug(LR.diuretics);
patentDuctusArteriosusInfantDis.addTreatment("patentDuctusArteriosusInfantTr1");


// ------------- patentDuctusArteriosusChild  -------------
Disease patentDuctusArteriosusChildDis = new Disease(
    LR.patentDuctusArteriosusChild,
    L.patentDuctusArteriosusChildDescription,
    LR.vascularDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    7, // minAge
    16, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.pulmonaryArterySysSt,
    LR.none
);
patentDuctusArteriosusChildDis.setPrintName(L.patentDuctusArteriosusChildPrintName);
patentDuctusArteriosusChildDis.setSuperDisease(LR.patentDuctusArteriosus);
patentDuctusArteriosusChildDis.setMiscComments(L.patentDuctusArteriosusChildComment);
patentDuctusArteriosusChildDis.addReference("pp 1074-6");
patentDuctusArteriosusChildDis.addSymptom(LR.developmentSlow);
patentDuctusArteriosusChildDis.addSymptom(LR.fatigueProlonged);
Treatment patentDuctusArteriosusChildTr1 = new Treatment("patentDuctusArteriosusChildTr1", LR.beforeSurgery);
patentDuctusArteriosusChildTr1.addDrug(LR.antibiotics);
patentDuctusArteriosusChildDis.addTreatment("patentDuctusArteriosusChildTr1");


// ------------- patentDuctusArteriosusAdult  -------------
Disease patentDuctusArteriosusAdultDis = new Disease(
    LR.patentDuctusArteriosusAdult,
    L.patentDuctusArteriosusAdultDescription,
    LR.vascularDisorders,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    17, // minAge
    150, // maxAge
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.pulmonaryArterySysSt,
    LR.none
);
patentDuctusArteriosusAdultDis.setPrintName(L.patentDuctusArteriosusAdultPrintName);
patentDuctusArteriosusAdultDis.setSuperDisease(LR.patentDuctusArteriosus);
patentDuctusArteriosusAdultDis.addReference("pp 1074-6");
patentDuctusArteriosusAdultDis.addSymptom(LR.dyspnea);
patentDuctusArteriosusAdultDis.addSymptom(LR.fatigueProlonged);


// ------------- thoracicAortaAneurysm  -------------
Disease thoracicAortaAneurysmDis = new Disease(
    LR.thoracicAortaAneurysm,
    L.thoracicAortaAneurysmDescription,
    LR.vascularDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.vascularSysSt,
    LR.none
);
thoracicAortaAneurysmDis.setPrintName(L.thoracicAortaAneurysmPrintName);
thoracicAortaAneurysmDis.setCode358(242);
thoracicAortaAneurysmDis.setICD10code("I71");
thoracicAortaAneurysmDis.addInternalCause(LR.syphilisLateCardioVascular);
thoracicAortaAneurysmDis.addCausesDisease(LR.aortaInsufficiency);
thoracicAortaAneurysmDis.addCausesAbnormalCondition(LR.pericardialFrictionRub);
thoracicAortaAneurysmDis.addCausesAbnormalCondition(LR.bloodPressureDifferences);
thoracicAortaAneurysmDis.addCausesAbnormalCondition(LR.neurologicDeficiences);
thoracicAortaAneurysmDis.addReference("pp 1134-7");
thoracicAortaAneurysmDis.addSymptom(LR.abdomenPain);
thoracicAortaAneurysmDis.addSymptom(LR.backPain);
thoracicAortaAneurysmDis.addSymptom(LR.bradycardia);
thoracicAortaAneurysmDis.addSymptom(LR.dysphagia);
thoracicAortaAneurysmDis.addSymptom(LR.dyspnea);
thoracicAortaAneurysmDis.addSymptom(LR.hoarseness);
thoracicAortaAneurysmDis.addSymptom(LR.neckPain);
thoracicAortaAneurysmDis.addSymptom(LR.shoulderPain);
Treatment thoracicAortaAneurysmTr1 = new Treatment("thoracicAortaAneurysmTr1");
thoracicAortaAneurysmTr1.addTreatmentAction(LR.IVFluids);
thoracicAortaAneurysmTr1.addTreatmentAction(LR.airwayMaintenance);
thoracicAortaAneurysmTr1.addTreatmentAction(LR.bloodTransfusion);
thoracicAortaAneurysmTr1.addTreatmentAction(LR.surgery);
thoracicAortaAneurysmTr1.addDrug(LR.antihypertensives);
thoracicAortaAneurysmTr1.addDrug(LR.narcotics);
thoracicAortaAneurysmTr1.addDrug(LR.negativeInotropicAgents);
thoracicAortaAneurysmDis.addTreatment("thoracicAortaAneurysmTr1");


// ------------- thrombophlebitis  -------------
Disease thrombophlebitisDis = new Disease(
    LR.thrombophlebitis,
    L.thrombophlebitisDescription,
    LR.vascularDisorders,
    LR.none, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    150, // maxAge
    0, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.cardioVascularSysSt,
    LR.longTermImmobility
);
thrombophlebitisDis.setPrintName(L.thrombophlebitisPrintName);
thrombophlebitisDis.addExternalCause(LR.trauma);
thrombophlebitisDis.addExternalCause(LR.oralContraceptiveUse);
thrombophlebitisDis.addExternalCause(LR.childbirth);
thrombophlebitisDis.addExternalCause(LR.surgery);
thrombophlebitisDis.setCode358(245);
thrombophlebitisDis.setICD10code("I80");
thrombophlebitisDis.addReference("pp 1142-5");
thrombophlebitisDis.addSymptom(LR.chills);
thrombophlebitisDis.addSymptom(LR.cyanosis);
thrombophlebitisDis.addSymptom(LR.malaise);
thrombophlebitisDis.addSymptom(LR.lymphadenitis, L.thrombophlebitis_lymphadenitis, 0.1f);
thrombophlebitisDis.addSymptom(LR.veinHeat);
thrombophlebitisDis.addSymptom(LR.veinPain);
thrombophlebitisDis.addSymptom(LR.veinSwelling);
thrombophlebitisDis.addSymptom(LR.veinTender);
Treatment thrombophlebitisTr1 = new Treatment("thrombophlebitisTr1");
thrombophlebitisTr1.addTreatmentAction(LR.bedRest);
thrombophlebitisTr1.addDrug(LR.analgetics);
thrombophlebitisDis.addTreatment("thrombophlebitisTr1");
} // end of vascularDisorders



}
