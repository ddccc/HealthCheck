
// (C) OntoOO Inc 2000
package init;

import com.D;
import com.LR;
import com.F;
import concepts.*;

public class InitImmuneDiseases {
  public static void doit() {

// -------------- acquiredImmunoDeficiencySyndrome --------------
// (C) OntoOO Inc Tue Mar 25 13:52:06 PST 2003
Disease acquiredImmunoDeficiencySyndromeDis = new Disease(
   LR.acquiredImmunoDeficiencySyndrome, 
   "progressive immuno deficiency against opportunistic infections and unusual cancers", 
   LR.immuneDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.immuneSysSt, 
   LR.HIVInfection
);
acquiredImmunoDeficiencySyndromeDis.addCausesDisease(LR.acquiredImmunoDeficiencySyndromeAdvanced);
acquiredImmunoDeficiencySyndromeDis.setPrintName("acquired immuno deficiency syndrome");
acquiredImmunoDeficiencySyndromeDis.addReference("pp 383-7");
acquiredImmunoDeficiencySyndromeDis.setMiscComments(
   "there may be no symptoms for years in the first phase after infection");
acquiredImmunoDeficiencySyndromeDis.setCode358(48);
acquiredImmunoDeficiencySyndromeDis.setICD10code("B20");


// -------------- acquiredImmunoDeficiencySyndromeAdvanced --------------
// (C) OntoOO Inc Tue Mar 25 14:59:56 PST 2003
Disease acquiredImmunoDeficiencySyndromeAdvancedDis = new Disease(
   LR.acquiredImmunoDeficiencySyndromeAdvanced, 
   "progressive immuno deficiency against opportunistic infections and " + 
   "unusual cancers in the advanced stage", 
   LR.immuneDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   F.acquiredImmunoDeficiencySyndromeAdvancedFreq, 
   LR.immuneSysSt, 
   LR.HIVInfection
);
acquiredImmunoDeficiencySyndromeAdvancedDis.setPrintName("acquired immuno deficiency syndrome advanced");
acquiredImmunoDeficiencySyndromeAdvancedDis.setTemperature((float)101.0);
acquiredImmunoDeficiencySyndromeAdvancedDis.addSymptom(LR.cachexia);
acquiredImmunoDeficiencySyndromeAdvancedDis.addSymptom(LR.fatigue);
acquiredImmunoDeficiencySyndromeAdvancedDis.addSymptom(LR.nightSweating);
acquiredImmunoDeficiencySyndromeAdvancedDis.addSymptom(LR.weightLoss);
acquiredImmunoDeficiencySyndromeAdvancedDis.addInternalCause(LR.acquiredImmunoDeficiencySyndrome);
acquiredImmunoDeficiencySyndromeAdvancedDis.addReference("pp 383-7");
acquiredImmunoDeficiencySyndromeAdvancedDis.setMiscComments(
   "treatment aims to slow down the progression");
Treatment acquiredImmunoDeficiencySyndromeAdvancedTr1  = 
   new Treatment("acquiredImmunoDeficiencySyndromeAdvancedTr1");
acquiredImmunoDeficiencySyndromeAdvancedTr1.addDrug(LR.zidovudine);
acquiredImmunoDeficiencySyndromeAdvancedTr1.addDrug(LR.lamivudine);
acquiredImmunoDeficiencySyndromeAdvancedTr1.addDrug(LR.didanosine);
acquiredImmunoDeficiencySyndromeAdvancedTr1.addDrug(LR.stavudine);
acquiredImmunoDeficiencySyndromeAdvancedTr1.addDrug(LR.zalcitabine);
acquiredImmunoDeficiencySyndromeAdvancedDis.addTreatment(
   acquiredImmunoDeficiencySyndromeAdvancedTr1.getName());
Treatment acquiredImmunoDeficiencySyndromeAdvancedTr2 
   = new Treatment("acquiredImmunoDeficiencySyndromeAdvancedTr2");
acquiredImmunoDeficiencySyndromeAdvancedTr2.addDrug(LR.ritonavir);
acquiredImmunoDeficiencySyndromeAdvancedTr2.addDrug(LR.indinavir);
acquiredImmunoDeficiencySyndromeAdvancedTr2.addDrug(LR.nelfinavir);
acquiredImmunoDeficiencySyndromeAdvancedTr2.addDrug(LR.saquinavirMaleate);
acquiredImmunoDeficiencySyndromeAdvancedDis.addTreatment(
   acquiredImmunoDeficiencySyndromeAdvancedTr2.getName()); 
acquiredImmunoDeficiencySyndromeAdvancedDis.setCode358(49);
acquiredImmunoDeficiencySyndromeAdvancedDis.setICD10code("B20");


    // --------------  anaphylaxis ---------------
// (C) OntoOO Inc Mon Oct 29 20:02:01 PST 2001
Disease anaphylaxisDis = new Disease(
   LR.anaphylaxis, 
   "rapid allergic reaction to a substance leading to skin swellings " +
   "and respiratory distress", 
   LR.immuneDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vascularSysSt, 
   LR.none
);
anaphylaxisDis.addSymptom(LR.abdomenCramping, "", 1.0f);
anaphylaxisDis.addSymptom(LR.doomFeeling, "", 1.0f);
anaphylaxisDis.addSymptom(LR.dyspnea, "", 1.0f);
anaphylaxisDis.addSymptom(LR.hypotension, "", 1.0f);
anaphylaxisDis.addSymptom(LR.respirationDistress, "", 1.0f);
anaphylaxisDis.addSymptom(LR.sneezing, "", 1.0f);
anaphylaxisDis.addSymptom(LR.urticaria, "", 1.0f);
anaphylaxisDis.addSymptom(LR.weakness, "", 1.0f);
anaphylaxisDis.addSymptom(LR.wheezing, "", 1.0f);
anaphylaxisDis.addExternalCause(LR.antigenExposure);
anaphylaxisDis.addCausesAbnormalCondition(LR.shock);
anaphylaxisDis.addReference("pp 350-2");
anaphylaxisDis.setMiscComments(
   "a severe reaction may cause a vascular collapse, " +
   "leading to shock and is sometimes fatal");
Treatment anaphylaxisTr1 = new Treatment("anaphylaxisTr1");
anaphylaxisTr1.addTreatmentAction(LR.establishmentOfAirway);
anaphylaxisTr1.addTreatmentAction(LR.IVVolumeExpanders);
anaphylaxisTr1.addDrug(LR.epinephrine);
anaphylaxisTr1.addDrug(LR.steroids);
anaphylaxisTr1.addDrug(LR.diphenhydramine);
anaphylaxisDis.addTreatment(anaphylaxisTr1.getName()); 
Treatment anaphylaxisTr2 = 
    new Treatment("anaphylaxisTr2", LR.ifCardiacArrest);
anaphylaxisTr2.addTreatmentAction(LR.CPR);
anaphylaxisDis.addTreatment(anaphylaxisTr2.getName()); 


// -------------- ankylosingSpondylitis --------------
// (C) OntoOO Inc Fri Dec 26 13:30:54 PST 2003
Disease ankylosingSpondylitisDis = new Disease(
   LR.ankylosingSpondylitis, 
   "inflammation of joints and adjacent soft tissue", 
   LR.immuneDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.jointsSysSt, 
   LR.none
);
ankylosingSpondylitisDis.setPrintName("ankylosing spondylitis");
ankylosingSpondylitisDis.addSymptom(LR.anorexia, "", 0.2f);
ankylosingSpondylitisDis.addSymptom(LR.chestPain, "", 0.2f);
ankylosingSpondylitisDis.addSymptom(LR.fatigue, "", 0.2f);
ankylosingSpondylitisDis.addSymptom(LR.lowBackPain, "", 1.0f);
ankylosingSpondylitisDis.addSymptom(LR.weightLoss, "", 0.2f);
ankylosingSpondylitisDis.addSymptom(LR.spineStiff, "", 0.2f);
ankylosingSpondylitisDis.addInternalCause(LR.ulcerativeColitis);
ankylosingSpondylitisDis.addCausesDisease(LR.arthritis);
ankylosingSpondylitisDis.addCausesDisease(LR.uveitis);
ankylosingSpondylitisDis.addCausesDisease(LR.aortaInsufficiency); 
ankylosingSpondylitisDis.addCausesDisease(LR.kyphosis);
// ankylosingSpondylitisDis.addCausesDisease(LR.upperLobePulmonaryFibrosis);
ankylosingSpondylitisDis.addCausesDisease(LR.idiopathicPulmonaryFibrosis);
ankylosingSpondylitisDis.addCausesAbnormalCondition(LR.hipDeformity);
ankylosingSpondylitisDis.addCausesAbnormalCondition(LR.cardiacEnlargement);
ankylosingSpondylitisDis.addReference("pp 363-5");
ankylosingSpondylitisDis.setMiscComments("easier to diagnose in men than in women");
Treatment ankylosingSpondylitisTr1 = new Treatment("ankylosingSpondylitisTr1");
ankylosingSpondylitisTr1.addTreatmentAction(LR.exercise);
ankylosingSpondylitisTr1.addDrug(LR.analgetics);
ankylosingSpondylitisDis.addTreatment("ankylosingSpondylitisTr1");
Treatment ankylosingSpondylitisTr2  = 
   new Treatment("ankylosingSpondylitisTr2", LR.ifHipInvolvement);
ankylosingSpondylitisTr2.addTreatmentAction(LR.surgery);
ankylosingSpondylitisDis.addTreatment(ankylosingSpondylitisTr2.getName());


// -------------- asthma --------------
// (C) OntoOO Inc Fri Jan 24 22:12:03 PST 2003
Disease asthmaDis = new Disease(
   LR.asthma, 
   "reversible lung disease: narrowing of the airways due to inflammation", 
   LR.immuneDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.allergens
);
asthmaDis.addSymptom(LR.dyspnea, "", 1.0f);
asthmaDis.addSymptom(LR.cough, "", 1.0f);
asthmaDis.addSymptom(LR.wheezing, "", 1.0f);
asthmaDis.addSymptom(LR.chestTightness, "", 1.0f);
asthmaDis.addSymptom(LR.diaphoresis, "", 0.3f);
asthmaDis.addSymptom(LR.rhonchus, "", 0.5f);
asthmaDis.addSymptom(LR.sputumMucoid, "after attack subsides", 1.0f);
asthmaDis.addSymptom(LR.tachycardia, "", 0.3f);
asthmaDis.addSymptom(LR.tachypnea, "", 0.3f);
asthmaDis.addExternalCause(LR.pollen);
asthmaDis.addExternalCause(LR.animalDander);
asthmaDis.addExternalCause(LR.houseDustAndMold);
asthmaDis.addExternalCause(LR.kapokAndFeatherPillows);
asthmaDis.addExternalCause(LR.foodSulfites);
asthmaDis.addExternalCause(LR.cigaretteSmoking);
asthmaDis.addExternalCause(LR.coughing);
asthmaDis.addExternalCause(LR.laughing);
asthmaDis.addExternalCause(LR.anxiety);
asthmaDis.addInternalCause(LR.gastroesophagealReflux);
asthmaDis.addCausesDisease(LR.chronicAsthma);
asthmaDis.addReference("pp 340-6");
Treatment asthmaTr1 = new Treatment("asthmaTr1", LR.ifInfection);
asthmaTr1.addDrug(LR.antibiotics);
asthmaDis.addTreatment("asthmaTr1");
Treatment asthmaTr2  = new Treatment("asthmaTr2");
asthmaTr2.addDrug(LR.bronchodilator);
asthmaTr2.addDrug(LR.corticosteroids);
asthmaDis.addTreatment(asthmaTr2.getName());
asthmaDis.setCode358(268);
asthmaDis.setICD10code("J45");


// -------------- chronicFatigueSyndrome --------------
// (C) OntoOO Inc Mon May 05 19:51:08 PDT 2003
Disease chronicFatigueSyndromeDis = new Disease(
   LR.chronicFatigueSyndrome, 
   "debilitating fatigue with neurologic abnormalities ", 
   LR.immuneDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   50,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.immuneSysSt, 
   LR.none
);
chronicFatigueSyndromeDis.setPrintName("chronic fatigue syndrome");
chronicFatigueSyndromeDis.addSymptom(LR.arthralgia, "", 0.6f);
chronicFatigueSyndromeDis.addSymptom(LR.concentrationLoss, "", 0.3f);
chronicFatigueSyndromeDis.addSymptom(LR.confusion, "", 0.3f);
chronicFatigueSyndromeDis.addSymptom(LR.fatigueProlonged, "", 1.0f);
chronicFatigueSyndromeDis.addSymptom(LR.forgetfulness, "", 0.3f);
chronicFatigueSyndromeDis.addSymptom(LR.headache, "", 1.0f);
chronicFatigueSyndromeDis.addSymptom(LR.irritability, "", 0.3f);
chronicFatigueSyndromeDis.addSymptom(LR.lymphNodePainful, "", 1.0f);
chronicFatigueSyndromeDis.addSymptom(LR.mentalDepression, "", 0.3f);
chronicFatigueSyndromeDis.addSymptom(LR.muscleWeakness, "", 1.0f);
chronicFatigueSyndromeDis.addSymptom(LR.photophobia, "", 0.3f);
chronicFatigueSyndromeDis.addSymptom(LR.sleepDisturbed, "", 1.0f);
chronicFatigueSyndromeDis.setMiscComments("joining a support group for CFIDS is recommended"); 
chronicFatigueSyndromeDis.addReference("pp 388-9");
Treatment chronicFatigueSyndromeTr1 = new Treatment("chronicFatigueSyndromeTr1");
chronicFatigueSyndromeTr1.addDrug(LR.acyclovir);
chronicFatigueSyndromeTr1.addDrug(LR.ampligen);
chronicFatigueSyndromeDis.addTreatment("chronicFatigueSyndromeTr1");
Treatment chronicFatigueSyndromeTr2 = new Treatment("chronicFatigueSyndromeTr2");
chronicFatigueSyndromeTr2.addDrug(LR.antianxietyDrug);
chronicFatigueSyndromeTr2.addDrug(LR.antidepressants);
chronicFatigueSyndromeDis.addTreatment(chronicFatigueSyndromeTr2.getName()); 


    // --------------  lupusErythematosus ---------------
// (C) OntoOO Inc Mon Oct 01 18:59:30 PDT 2001
Disease lupusErythematosusDis = new Disease(
   LR.lupusErythematosus, 
   "chronic inflammation of connective tissues", 
   LR.immuneDisorders,
   LR.moreFemale, // genderSpecificity 
   LR.africanAmerican, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.immuneSysSt, 
   LR.none
);
lupusErythematosusDis.setPrintName("lupus erythematosus");
lupusErythematosusDis.setTemperature((float)99.8);
lupusErythematosusDis.addSymptom(LR.arthralgia);
lupusErythematosusDis.addSymptom(LR.fatigue);
lupusErythematosusDis.addSymptom(LR.malaise);
lupusErythematosusDis.addSymptom(LR.rash);
lupusErythematosusDis.addSymptom(LR.weightLoss);
lupusErythematosusDis.addSymptom(LR.butterflyRash, "", 0.5f);
lupusErythematosusDis.addReference("pp 366-370");
lupusErythematosusDis.addIllustration(D.ButterflyRashJpg);
Treatment lupusErythematosusTr1 = new Treatment("lupusErythematosusTr1");
lupusErythematosusTr1.addDrug(LR.aspirin);
lupusErythematosusTr1.addDrug(LR.corticosteroids);
lupusErythematosusDis.addTreatment(lupusErythematosusTr1.getName()); 


// -------------- lupusErythematosusDiscoid --------------
// (C) OntoOO Inc Wed Jul 14 07:26:06 PDT 2004
Disease lupusErythematosusDiscoidDis = new Disease(
   LR.lupusErythematosusDiscoid, 
   "chronic inflammation of connective tissues marked by chronic skin eruptions", 
   LR.immuneDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.africanAmerican, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.immuneSysSt, 
   LR.none
);
lupusErythematosusDiscoidDis.setPrintName("discoid lupus erythematosus");
lupusErythematosusDiscoidDis.setSuperDisease(LR.lupusErythematosus);
lupusErythematosusDiscoidDis.addSymptom(LR.skinPlaquesRaised);
lupusErythematosusDiscoidDis.addSymptom(LR.skinPlaquesRed);
lupusErythematosusDiscoidDis.addSymptom(LR.skinPlaquesScaled);
lupusErythematosusDiscoidDis.addCausesDisease(LR.lupusErythematosusSystemic); 
lupusErythematosusDiscoidDis.setTemperature((float)99.8);
lupusErythematosusDiscoidDis.addReference("pp 366-370");


// -------------- lupusErythematosusSystemic --------------
// (C) OntoOO Inc Mon Jul 19 15:02:37 PDT 2004
Disease lupusErythematosusSystemicDis = new Disease(
   LR.lupusErythematosusSystemic, 
   "chronic inflammation of connective tissues which impacts not only the skin but also multiple organs", 
   LR.immuneDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.africanAmerican, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.immuneSysSt, 
   LR.none
);
lupusErythematosusSystemicDis.setPrintName("systemic lupus erythematosus");
lupusErythematosusSystemicDis.setSuperDisease(LR.lupusErythematosus);
lupusErythematosusSystemicDis.setTemperature((float)99.8);
lupusErythematosusSystemicDis.addSymptom(LR.skinPlaquesRaised, "", 1.0f);
lupusErythematosusSystemicDis.addSymptom(LR.skinPlaquesRed, "", 1.0f);
lupusErythematosusSystemicDis.addSymptom(LR.skinPlaquesScaled, "", 1.0f);
lupusErythematosusSystemicDis.addSymptom(LR.vomiting, "", 1.0f);
lupusErythematosusSystemicDis.addSymptom(LR.anorexia, "", 1.0f);
lupusErythematosusSystemicDis.addSymptom(LR.chills, "", 1.0f);
lupusErythematosusSystemicDis.addSymptom(LR.abdomenPain);
lupusErythematosusSystemicDis.addSymptom(LR.lymphadenopathy);
lupusErythematosusSystemicDis.addSymptom(LR.nausea);
lupusErythematosusSystemicDis.addInternalCause(LR.lupusErythematosusDiscoid); 
lupusErythematosusSystemicDis.addReference("pp 366-370");



// -------------- polymyositis --------------
// (C) OntoOO Inc Tue Mar 25 13:07:18 PST 2003
// (C) OntoOO Inc Thu Aug 26 17:13:18 GMT-08:00 2004
Disease polymyositisDis = new Disease(
   LR.polymyositis, 
   "symmetrical weakness of striated muscles that are under voluntary control", 
   LR.immuneDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.muscleSysSt, 
   LR.none
);
polymyositisDis.addSymptom(LR.dysphagia);
polymyositisDis.addSymptom(LR.muscleWeakness);
polymyositisDis.addSymptom(LR.muscleTender);
polymyositisDis.addSymptom(LR.dysphonia);
polymyositisDis.addInternalCause(LR.toxoplasmosisAcquiredAdvanced); 
polymyositisDis.addReference("pp 378-9");
Treatment polymyositisTr1 = new Treatment("polymyositisTr1");
polymyositisTr1.addDrug(LR.corticosteroids);
polymyositisDis.addTreatment("polymyositisTr1");


// -------------- arthritis --------------
// (C) OntoOO Inc Mon May 12 08:13:14 PDT 2003
Disease arthritisDis = new Disease(
   LR.arthritis, 
   "a family of  joint inflammation problems", 
   LR.immuneDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.jointsSysSt, 
   LR.none
);
arthritisDis.addSymptom(LR.jointPain);
arthritisDis.addInternalCause(LR.ankylosingSpondylitis);
arthritisDis.addInternalCause(LR.lymeDisease3);
arthritisDis.addInternalCause(LR.ulcerativeColitis);
arthritisDis.addReference("HealthWise pp 115-7");
Treatment arthritisTr1  = new Treatment("arthritisTr1");
arthritisTr1.addTreatmentAction(LR.exercise);
arthritisTr1.addTreatmentAction(LR.weightReduction);
arthritisTr1.addTreatmentAction(LR.stretching);
arthritisTr1.addDrug(LR.analgetics);
arthritisDis.addTreatment(arthritisTr1.getName());
  

    // --------------  rheumatoidArthritis ---------------
// (C) OntoOO Inc Mon Oct 01 19:05:03 PDT 2001
Disease rheumatoidArthritisDis = new Disease(
   LR.rheumatoidArthritis, 
   "inflammation of joints, surrounding muscles, tendons, ligaments & veins", 
   LR.immuneDisorders,
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.immuneSysSt, 
   LR.none
);
rheumatoidArthritisDis.setPrintName("rheumatoid arthritis");
rheumatoidArthritisDis.setSuperDisease(LR.arthritis);
rheumatoidArthritisDis.addReference("pp 355-60");
rheumatoidArthritisDis.setCode358(311);
rheumatoidArthritisDis.setICD10code("M05");


// -------------- rheumatoidArthritis1 --------------
// (C) OntoOO Inc Mon May 12 12:11:38 PDT 2003
Disease rheumatoidArthritis1Dis = new Disease(
   LR.rheumatoidArthritis1, 
   "first phase of inflammation of joints, surrounding muscles, tendons, ligaments & veins", 
   LR.immuneDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.immuneSysSt, 
   LR.none
);
rheumatoidArthritis1Dis.setPrintName("rheumatoid arthritis first phase");
rheumatoidArthritis1Dis.setSuperDisease(LR.rheumatoidArthritis);
rheumatoidArthritis1Dis.addSymptom(LR.anorexia);
rheumatoidArthritis1Dis.addSymptom(LR.fatigue);
rheumatoidArthritis1Dis.addSymptom(LR.lymphadenopathy);
rheumatoidArthritis1Dis.addSymptom(LR.malaise);
rheumatoidArthritis1Dis.addSymptom(LR.weightLoss);
rheumatoidArthritis1Dis.addCausesDisease(LR.rheumatoidArthritis2);
rheumatoidArthritis1Dis.addReference("pp 355-60");
rheumatoidArthritis1Dis.setCode358(311);
rheumatoidArthritis1Dis.setICD10code("M05");


// -------------- rheumatoidArthritis2 --------------
// (C) OntoOO Inc Mon May 12 14:02:14 PDT 2003
Disease rheumatoidArthritis2Dis = new Disease(
   LR.rheumatoidArthritis2, 
   "second phase of inflammation of joints, surrounding muscles, tendons, ligaments & veins", 
   LR.immuneDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.immuneSysSt, 
   LR.none
);
rheumatoidArthritis2Dis.setPrintName("rheumatoid arthritis second phase");
rheumatoidArthritis2Dis.setSuperDisease(LR.rheumatoidArthritis);
rheumatoidArthritis2Dis.addSymptom(LR.anorexia, "", 1.0f);
rheumatoidArthritis2Dis.addSymptom(LR.fatigue, "", 1.0f);
rheumatoidArthritis2Dis.addSymptom(LR.jointStiffen, "", 1.0f);
rheumatoidArthritis2Dis.addSymptom(LR.jointSwelling, "", 1.0f);
rheumatoidArthritis2Dis.addSymptom(LR.lymphadenopathy, "", 1.0f);
rheumatoidArthritis2Dis.addSymptom(LR.malaise, "", 1.0f);
rheumatoidArthritis2Dis.addSymptom(LR.weightLoss, "", 1.0f);
rheumatoidArthritis2Dis.addInternalCause(LR.rheumatoidArthritis1);
rheumatoidArthritis2Dis.addCausesDisease(LR.rheumatoidArthritis3);
rheumatoidArthritis2Dis.addReference("pp 355-60");
rheumatoidArthritis2Dis.setCode358(311);
rheumatoidArthritis2Dis.setICD10code("M05");


// -------------- rheumatoidArthritis3 --------------
// (C) OntoOO Inc Mon May 12 16:07:56 PDT 2003
Disease rheumatoidArthritis3Dis = new Disease(
   LR.rheumatoidArthritis3, 
   "third phase of inflammation of joints, surrounding muscles, tendons, ligaments & veins", 
   LR.immuneDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.immuneSysSt, 
   LR.none
);
rheumatoidArthritis3Dis.setPrintName("rheumatoid arthritis third phase");
rheumatoidArthritis3Dis.setSuperDisease(LR.rheumatoidArthritis);
rheumatoidArthritis3Dis.addSymptom(LR.anorexia, "", 1.0f);
rheumatoidArthritis3Dis.addSymptom(LR.fatigue, "", 1.0f);
rheumatoidArthritis3Dis.addSymptom(LR.fingerJointDeformity, "", 1.0f);
rheumatoidArthritis3Dis.addSymptom(LR.jointStiffen, "", 1.0f);
rheumatoidArthritis3Dis.addSymptom(LR.jointSwelling, "", 1.0f);
rheumatoidArthritis3Dis.addSymptom(LR.lymphadenopathy, "", 1.0f);
rheumatoidArthritis3Dis.addSymptom(LR.malaise, "", 1.0f);
rheumatoidArthritis3Dis.addSymptom(LR.weightLoss, "", 1.0f);
rheumatoidArthritis3Dis.addInternalCause(LR.rheumatoidArthritis2);
rheumatoidArthritis3Dis.addCausesDisease(LR.pericarditis);
rheumatoidArthritis3Dis.addCausesDisease(LR.pleurisy);
rheumatoidArthritis3Dis.addReference("pp 355-60");
Treatment rheumatoidArthritis3Tr1 = new Treatment("rheumatoidArthritis3Tr1", LR.ifSevere);
rheumatoidArthritis3Tr1.addTreatmentAction(LR.surgery);
rheumatoidArthritis3Dis.addTreatment(rheumatoidArthritis3Tr1.getName()); 
rheumatoidArthritis3Dis.setCode358(311);
rheumatoidArthritis3Dis.setICD10code("M05");


    // --------------  scleroderma ---------------
// (C) OntoOO Inc Fri Sep 28 12:49:29 PDT 2001
// (C) OntoOO Inc Thu Sep 09 15:09:49 GMT-08:00 2004
Disease sclerodermaDis = new Disease(
   LR.scleroderma, 
   "connective tissue degeneration with sometimes changes in skin, bloodvessels, " +
   "synovial membranes, skeletal muscles and internal organs", 
   LR.immuneDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   50,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.immuneSysSt, 
   LR.none
);
sclerodermaDis.addSymptom(LR.abdomenDistension, "", 0.3f);
sclerodermaDis.addSymptom(LR.bloating, "after meals", 0.3f);
sclerodermaDis.addSymptom(LR.constipation, "", 0.3f);
sclerodermaDis.addSymptom(LR.diarrhea, "", 0.3f);
sclerodermaDis.addSymptom(LR.dysphagia, "", 0.3f);
sclerodermaDis.addSymptom(LR.fingerSwelling);
sclerodermaDis.addSymptom(LR.heartburn, "", 0.3f);
sclerodermaDis.addSymptom(LR.jointPain, "", 1.0f);
sclerodermaDis.addSymptom(LR.jointStiffen, "", 1.0f);
sclerodermaDis.addSymptom(LR.jointSwelling, "", 1.0f);
sclerodermaDis.addSymptom(LR.skinFaceTight);
sclerodermaDis.addSymptom(LR.skinHandsTight);
sclerodermaDis.addReference("pp 372-4");
sclerodermaDis.setMiscComments("70% survival after 5 years - no cure available (98)");
Treatment sclerodermaTr1 = new Treatment("sclerodermaTr1");
sclerodermaTr1.addDrug(LR.corticosteroids);
sclerodermaDis.addTreatment("sclerodermaTr1");


    // --------------  vasculitis ---------------
/* ***************************************
   Replace    LR.immuneSysSt, 
   By         LR.vascularSysSt 
   to narrow down the location ????
*************************************** */

// (C) OntoOO Inc Fri Sep 28 15:15:48 PDT 2001
Disease vasculitisDis = new Disease(
   LR.vasculitis, 
   "inflammation and necrosis of bloodvessels", 
   LR.immuneDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vascularSysSt, 
   LR.none
);
vasculitisDis.addReference("pp 374-7");
vasculitisDis.setMiscComments(
    "broad spectrum of disorders/ classified by the bloodvessels involved");
Treatment vasculitisTr1 = new Treatment("vasculitisTr1");
vasculitisTr1.addDrug(LR.corticosteroids);
vasculitisTr1.addDrug(LR.cyclophosphamide);
vasculitisDis.addTreatment(vasculitisTr1.getName());


// -------------- polyarteritisNodosa --------------
// (C) OntoOO Inc Tue Sep 21 15:57:01 GMT-08:00 2004
Disease polyarteritisNodosaDis = new Disease(
   LR.polyarteritisNodosa, 
   "inflammation and necrosis of non-large bloodvessels throughout the body", 
   LR.immuneDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vascularSysSt, 
   LR.none
);
polyarteritisNodosaDis.setPrintName("polyarteritis nodosa");
polyarteritisNodosaDis.setSuperDisease(LR.vasculitis);
polyarteritisNodosaDis.addSymptom(LR.abdomenPain);
polyarteritisNodosaDis.addSymptom(LR.anorexia);
polyarteritisNodosaDis.addSymptom(LR.fatigue);
polyarteritisNodosaDis.addSymptom(LR.feverSym);
polyarteritisNodosaDis.addSymptom(LR.headache);
polyarteritisNodosaDis.addSymptom(LR.jointPain);
polyarteritisNodosaDis.addSymptom(LR.myalgia);
polyarteritisNodosaDis.addSymptom(LR.weakness);
polyarteritisNodosaDis.addSymptom(LR.weightLoss);
polyarteritisNodosaDis.addCausesDisease(LR.hypertension);
polyarteritisNodosaDis.addReference("pp 374-7");


// -------------- vasculitisPulmonary --------------
// (C) OntoOO Inc Wed Jun 19 13:02:33 PDT 2002
// (C) OntoOO Inc Fri Oct 08 12:47:43 GMT-08:00 2004
Disease vasculitisPulmonaryDis = new Disease(
   LR.vasculitisPulmonary, 
   "inflammation and necrosis of bloodvessels in the lungs and kidney", 
   LR.immuneDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vascularSysSt, 
   LR.none
);
vasculitisPulmonaryDis.setPrintName("vasculitis pulmonary");
vasculitisPulmonaryDis.setSuperDisease(LR.vasculitis);
vasculitisPulmonaryDis.setTemperature((float)101.0);
vasculitisPulmonaryDis.addSymptom(LR.pulmonaryCongestion);
vasculitisPulmonaryDis.addSymptom(LR.anorexia);
vasculitisPulmonaryDis.addSymptom(LR.cough);
vasculitisPulmonaryDis.addSymptom(LR.hematuria);
vasculitisPulmonaryDis.addSymptom(LR.malaise);
vasculitisPulmonaryDis.addSymptom(LR.weightLoss);
vasculitisPulmonaryDis.addCausesDisease(LR.corPulmonale);
vasculitisPulmonaryDis.addReference("pp 374-7");



  }
}
