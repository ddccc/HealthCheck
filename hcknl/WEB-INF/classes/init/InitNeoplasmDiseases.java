// (C) OntoOO Inc 2000
package init;

import com.D;
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

public class InitNeoplasmDiseases {
  public static void doit() {


    // ----------------- cancer -----------------------------------
// (C) OntoOO Inc Wed Sep 19 12:09:40 PDT 2001
Disease cancerDis = new Disease(
   LR.cancer, 
   "impaired enlarged disfunctional cells that divide more rapidly than normal ",
   LR.neoPlasms,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.radiation
);
cancerDis.addExternalCause(LR.tobaccoUse);
cancerDis.addExternalCause(LR.asbestosExposure);
cancerDis.addExternalCause(LR.industrialPollutantsExposure);
cancerDis.addExternalCause(LR.vinylChlorideExposure);
cancerDis.addExternalCause(LR.aromaticHydrocarbonsExposure);
cancerDis.addExternalCause(LR.benzopyreneExposure);
cancerDis.addReference("pp 45-55");
cancerDis.setMiscComments("67% are over age 65");


// -------------- basalCellCarcinoma --------------
// (C) OntoOO Inc Fri Oct 31 14:41:36 PST 2003
Disease basalCellCarcinomaDis = new Disease(
   LR.basalCellCarcinoma, 
   "slow growing destructive skin tumor", 
   LR.neoPlasms, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.sunLight
);
basalCellCarcinomaDis.setPrintName("basal cell carcinoma");
basalCellCarcinomaDis.setSuperDisease(LR.cancer);
basalCellCarcinomaDis.addReference("pp 124-5");
basalCellCarcinomaDis.setMiscComments("prevalent in blond fair skinned whites");
Treatment squamousCellCarcinomaTr1 = new Treatment("squamousCellCarcinomaTr1");
squamousCellCarcinomaTr1.addTreatmentAction(LR.chemoTherapy);
squamousCellCarcinomaTr1.addTreatmentAction(LR.curettage);
squamousCellCarcinomaTr1.addTreatmentAction(LR.radiationTherapy);
squamousCellCarcinomaTr1.addTreatmentAction(LR.surgery);
basalCellCarcinomaDis.addTreatment("squamousCellCarcinomaTr1");


// -------------- basalCellCarcinomaNodulo --------------
// (C) OntoOO Inc Fri Oct 31 15:31:21 PST 2003
Disease basalCellCarcinomaNoduloDis = new Disease(
   LR.basalCellCarcinomaNodulo, 
   "slow growing destructive skin tumor with ulcerating nodules", 
   LR.neoPlasms, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.faceSysSt, 
   LR.none
);
basalCellCarcinomaNoduloDis.setPrintName("basal cell carcinoma nodulo");
basalCellCarcinomaNoduloDis.setSuperDisease(LR.basalCellCarcinoma);
basalCellCarcinomaNoduloDis.addSymptom(LR.faceLesionPinkPapules, "early stage", 1.0f);
basalCellCarcinomaNoduloDis.addSymptom(LR.faceLesionTranslucentPapules, "early stage", 1.0f); 
basalCellCarcinomaNoduloDis.addReference("pp 124-5");
basalCellCarcinomaNoduloDis.setMiscComments("prevalent in blond fair skinned whites");


// -------------- basalCellCarcinomaSclerotic --------------
// (C) OntoOO Inc Mon Nov 03 17:36:59 PST 2003
Disease basalCellCarcinomaScleroticDis = new Disease(
   LR.basalCellCarcinomaSclerotic, 
   "superficial skin tumor on the head and/or neck", 
   LR.neoPlasms, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
basalCellCarcinomaScleroticDis.setPrintName("basal cell carcinoma sclerotic");
basalCellCarcinomaScleroticDis.setSuperDisease(LR.basalCellCarcinoma);
basalCellCarcinomaScleroticDis.addSymptom(LR.skinLesionPlaqueLike, "", 1.0f);
basalCellCarcinomaScleroticDis.addSymptom(LR.skinLesionFuzzyBorder);
basalCellCarcinomaScleroticDis.addSymptom(LR.skinLesionYellowish);
basalCellCarcinomaScleroticDis.addReference("pp 124-5");
basalCellCarcinomaScleroticDis.setMiscComments("prevalent in blond fair skinned whites");


// -------------- basalCellCarcinomaSuperficial --------------
// (C) OntoOO Inc Sun Nov 02 14:53:32 PST 2003
Disease basalCellCarcinomaSuperficialDis = new Disease(
   LR.basalCellCarcinomaSuperficial, 
   "superficial skin tumor on chest and/or back", 
   LR.neoPlasms, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
basalCellCarcinomaSuperficialDis.setPrintName("basal cell carcinoma superficial");
basalCellCarcinomaSuperficialDis.setSuperDisease(LR.basalCellCarcinoma);
basalCellCarcinomaSuperficialDis.addSymptom(LR.skinLesionPlaqueLike);
basalCellCarcinomaSuperficialDis.addSymptom(LR.skinLesionDryScaly);
basalCellCarcinomaSuperficialDis.addSymptom(LR.skinLesionLightlyPigmented);
basalCellCarcinomaSuperficialDis.addSymptom(LR.skinLesionSharpBorder);
basalCellCarcinomaSuperficialDis.addReference("pp 124-5");
basalCellCarcinomaSuperficialDis.setMiscComments("prevalent in blond fair skinned whites");


// -------------- bladderCancer --------------
// (C) OntoOO Inc Sat Sep 24 20:08:34 PDT 2011
Disease bladderCancerDis = new Disease(
   LR.bladderCancer, 
   "tumors can be of different types and on different locations in the bladder", 
   LR.neoPlasms, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   50, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bladderSysSt, 
   LR.none
);
bladderCancerDis.setPrintName("bladder cancer");
bladderCancerDis.setSuperDisease(LR.cancer);
bladderCancerDis.addSymptom(LR.bladderIrritability);
bladderCancerDis.addSymptom(LR.nocturia);
bladderCancerDis.addSymptom(LR.postVoidingPain);
bladderCancerDis.addSymptom(LR.urinaryFrequency);
bladderCancerDis.addSymptom(LR.urineDribbling);
bladderCancerDis.addReference("pp 93-96");
bladderCancerDis.setMiscComments("more common in densily populated industrial areas");
Treatment bladderCancerTr1 = new Treatment("bladderCancerTr1");
bladderCancerTr1.addTreatmentAction(LR.surgery);
bladderCancerDis.addTreatment(bladderCancerTr1.getName()); 
bladderCancerDis.setCode358(118);
bladderCancerDis.setICD10code("C67");


// -------------- colorectalCancer --------------
// (C) OntoOO Inc Mon Feb 10 15:10:41 PST 2003
Disease colorectalCancerDis = new Disease(
   LR.colorectalCancer, 
   "tumors and polyps in the colon", 
   LR.neoPlasms, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.colonSysSt, 
   LR.none
);
colorectalCancerDis.setPrintName("colorectal cancer");
colorectalCancerDis.setSuperDisease(LR.cancer);
colorectalCancerDis.setGenetic("1parent");
colorectalCancerDis.setParentDisease(LR.colorectalCancer);
colorectalCancerDis.addSymptom(LR.pallor, "", 1.0f);
colorectalCancerDis.addSymptom(LR.cachexia, "", 1.0f);
colorectalCancerDis.addSymptom(LR.stoolBlack, "", 1.0f);
colorectalCancerDis.addSymptom(LR.stoolTarry, "", 1.0f);
colorectalCancerDis.addSymptom(LR.abdomenCramping);
colorectalCancerDis.addInternalCause(LR.ulcerativeColitis);
colorectalCancerDis.addCausesDisease(LR.anemia);
colorectalCancerDis.addCausesDisease(LR.colorectalCancerAdvanced);
colorectalCancerDis.addCausesDisease(LR.colorectalCancerAdvancedLeftTumor);
colorectalCancerDis.addCausesAbnormalCondition(LR.ascites);
colorectalCancerDis.addCausesAbnormalCondition(LR.hepatomegaly); 
colorectalCancerDis.addReference("pp 87-89");
Treatment colorectalCancerTr1 = new Treatment("colorectalCancerTr1");
colorectalCancerTr1.addTreatmentAction(LR.surgery);
colorectalCancerDis.addTreatment(colorectalCancerTr1.getName()); 
colorectalCancerDis.setCode358(81);
colorectalCancerDis.setICD10code("C18");


// -------------- colorectalCancerAdvanced --------------
// (C) OntoOO Inc Tue Feb 11 16:14:54 PST 2003
Disease colorectalCancerAdvancedDis = new Disease(
   LR.colorectalCancerAdvanced, 
   "tumors and polyps in the colon advanced", 
   LR.neoPlasms, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.colonSysSt, 
   LR.none
);
colorectalCancerAdvancedDis.setPrintName("colorectal cancer advanced");
colorectalCancerAdvancedDis.setSuperDisease(LR.cancer);
colorectalCancerAdvancedDis.setGenetic("1parent");
colorectalCancerAdvancedDis.setParentDisease(LR.colorectalCancer);
colorectalCancerAdvancedDis.addSymptom(LR.anorexia);
colorectalCancerAdvancedDis.addSymptom(LR.diarrhea);
colorectalCancerAdvancedDis.addSymptom(LR.dyspnea);
colorectalCancerAdvancedDis.addSymptom(LR.fatigue);
colorectalCancerAdvancedDis.addSymptom(LR.obstipation);
colorectalCancerAdvancedDis.addSymptom(LR.vertigo);
colorectalCancerAdvancedDis.addSymptom(LR.vomiting);
colorectalCancerAdvancedDis.addSymptom(LR.weakness);
colorectalCancerAdvancedDis.addSymptom(LR.weightLoss);
colorectalCancerAdvancedDis.addInternalCause(LR.colorectalCancer);
colorectalCancerAdvancedDis.addReference("pp 87-89");
Treatment colorectalCancerAdvancedTr1 = new Treatment("colorectalCancerAdvancedTr1");
colorectalCancerAdvancedTr1.addTreatmentAction(LR.surgery);
colorectalCancerAdvancedDis.addTreatment("colorectalCancerAdvancedTr1");
colorectalCancerAdvancedDis.setCode358(81);
colorectalCancerAdvancedDis.setICD10code("C18");


// -------------- colorectalCancerAdvancedLeftTumor --------------
// (C) OntoOO Inc Thu Feb 13 12:08:47 PST 2003
Disease colorectalCancerAdvancedLeftTumorDis = new Disease(
   LR.colorectalCancerAdvancedLeftTumor, 
   "tumors and polyps in the colon advanced with tumor at the left side", 
   LR.neoPlasms, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.colonSysSt, 
   LR.none
);
colorectalCancerAdvancedLeftTumorDis.setPrintName("colorectal cancer advanced  left tumor");
colorectalCancerAdvancedLeftTumorDis.setSuperDisease(LR.cancer);
colorectalCancerAdvancedLeftTumorDis.setGenetic("1parent");
colorectalCancerAdvancedLeftTumorDis.setParentDisease(LR.colorectalCancer);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.anorexia, "", 1.0f);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.diarrhea, "", 1.0f);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.dyspnea, "", 1.0f);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.fatigue, "", 1.0f);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.obstipation, "", 1.0f);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.vertigo, "", 1.0f);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.vomiting, "", 1.0f);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.weakness, "", 1.0f);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.weightLoss, "", 1.0f);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.bleedingFromRectum);
colorectalCancerAdvancedLeftTumorDis.addSymptom(LR.stoolThinShaped);
colorectalCancerAdvancedLeftTumorDis.addInternalCause(LR.colorectalCancer);
colorectalCancerAdvancedLeftTumorDis.addReference("pp 87-89");
Treatment colorectalCancerAdvancedLeftTumorTr1  = 
   new Treatment("colorectalCancerAdvancedLeftTumorTr1");
colorectalCancerAdvancedLeftTumorTr1.addTreatmentAction(LR.surgery);
colorectalCancerAdvancedLeftTumorDis.addTreatment(
	      colorectalCancerAdvancedLeftTumorTr1.getName());
colorectalCancerAdvancedLeftTumorDis.setCode358(81);
colorectalCancerAdvancedLeftTumorDis.setICD10code("C18");


// -------------- larynxCancer --------------
// (C) OntoOO Inc Sat Dec 31 16:21:47 PST 2011
Disease larynxCancerDis = new Disease(
   LR.larynxCancer, 
   "tumor on vocal cord or elsewhere", 
   LR.neoPlasms, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.larynxSysSt, 
   LR.alcoholAbuse
);
larynxCancerDis.setPrintName("larynx cancer");
larynxCancerDis.setSuperDisease(LR.cancer);
larynxCancerDis.addSymptom(LR.cough);
larynxCancerDis.addSymptom(LR.dyspnea);
larynxCancerDis.addSymptom(LR.dysphagia);
larynxCancerDis.addSymptom(LR.hoarseness);
larynxCancerDis.addSymptom(LR.throatSore);
larynxCancerDis.addReference("pp 63-65");
Treatment larynxCancerTr1  = new Treatment("larynxCancerTr1");
larynxCancerTr1.addTreatmentAction(LR.surgery);
larynxCancerDis.addTreatment(larynxCancerTr1.getName());
Treatment larynxCancerTr2  = new Treatment("larynxCancerTr2");
larynxCancerTr2.addTreatmentAction(LR.chemoTherapy);
larynxCancerDis.addTreatment(larynxCancerTr2.getName());
Treatment larynxCancerTr3  = new Treatment("larynxCancerTr3");
larynxCancerTr3.addTreatmentAction(LR.radiationTherapy);
larynxCancerDis.addTreatment(larynxCancerTr3.getName());
larynxCancerDis.setCode358(92);
larynxCancerDis.setICD10code("C32");


    // ----------------- lung cancer -----------------------------------
// (C) OntoOO Inc Fri Sep 28 13:00:32 PDT 2001
Disease lungCancerDis = new Disease(
   LR.lungCancer, 
   "destruction of the lungs due to pollutants - usually cigarette smoke", 
   LR.neoPlasms,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.none
);
lungCancerDis.setPrintName("lung cancer");
lungCancerDis.setSuperDisease(LR.cancer);
lungCancerDis.addReference("pp 70-73");
lungCancerDis.setMiscComments("14% survival after 5 years/ 80% are smokers");
Treatment lungCancerTr1 = new Treatment("lungCancerTr1");
lungCancerTr1.addTreatmentAction(LR.chemoTherapy);
lungCancerTr1.addTreatmentAction(LR.radiationTherapy);
lungCancerTr1.addTreatmentAction(LR.surgery);
lungCancerDis.addTreatment(lungCancerTr1.getName()); 
lungCancerDis.setCode358(93);
lungCancerDis.setICD10code("C33");


// -------------- lungCancerLargeCells --------------
// (C) OntoOO Inc Tue Jun 17 16:25:18 PDT 2003
Disease lungCancerLargeCellsDis = new Disease(
   LR.lungCancerLargeCells, 
   "destruction of large cells in the lungs due to pollutants - usually cigarette smoke", 
   LR.neoPlasms, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.none
);
lungCancerLargeCellsDis.setPrintName("lung cancer large cells");
lungCancerLargeCellsDis.setSuperDisease(LR.lungCancer);
lungCancerLargeCellsDis.addSymptom(LR.anorexia);
lungCancerLargeCellsDis.addSymptom(LR.shoulderPain);
lungCancerLargeCellsDis.addSymptom(LR.weakness);
lungCancerLargeCellsDis.addSymptom(LR.weightLoss);
lungCancerLargeCellsDis.addReference("pp 70-73");
lungCancerLargeCellsDis.setMiscComments("14% survival after 5 years");
lungCancerLargeCellsDis.setCode358(93);
lungCancerLargeCellsDis.setICD10code("C33");


// -------------- lungCancerSmallCells --------------
// (C) OntoOO Inc Tue Jun 17 16:19:34 PDT 2003
Disease lungCancerSmallCellsDis = new Disease(
   LR.lungCancerSmallCells, 
   "destruction of small cells in the lungs due to pollutants - usually cigarette smoke", 
   LR.neoPlasms, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.none
);
lungCancerSmallCellsDis.setPrintName("lung cancer small cells");
lungCancerSmallCellsDis.setSuperDisease(LR.lungCancer);
lungCancerSmallCellsDis.addSymptom(LR.chestPain);
lungCancerSmallCellsDis.addSymptom(LR.cough);
lungCancerSmallCellsDis.addSymptom(LR.dyspnea);
lungCancerSmallCellsDis.addSymptom(LR.hemoptysis);
lungCancerSmallCellsDis.addSymptom(LR.hoarseness);
lungCancerSmallCellsDis.addSymptom(LR.wheezing);
lungCancerSmallCellsDis.addReference("pp 70-73");
lungCancerSmallCellsDis.setMiscComments("14% survival after 5 years");
lungCancerSmallCellsDis.setCode358(93);
lungCancerSmallCellsDis.setICD10code("C33");


// -------------- breastsCancer --------------
// (C) OntoOO Inc Sat Apr 20 18:00:33 PDT 2002
Disease breastsCancerDis = new Disease(
   LR.breastsCancer, 
   "tumor(s) in the breasts", 
   LR.neoPlasms, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.breastsSysSt, 
   LR.none
);
breastsCancerDis.setPrintName("breasts cancer");
breastsCancerDis.setSuperDisease(LR.cancer);
breastsCancerDis.setGenetic("mother");
breastsCancerDis.setParentDisease(LR.breastsCancer);
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
breastsCancerDis.addExternalCause(LR.menstrualCycleLong);
breastsCancerDis.addExternalCause(LR.mensesEarly);
breastsCancerDis.addExternalCause(LR.menopauseLate);
breastsCancerDis.addExternalCause(LR.neverPregnant);
breastsCancerDis.addExternalCause(LR.firstPregnancyLate);
breastsCancerDis.addInternalCause(LR.ovariesCancer);
breastsCancerDis.addInternalCause(LR.uterusCancer);
breastsCancerDis.addReference("pp 74-8");
breastsCancerDis.setMiscComments(
  "can occur at any age after puberty; " +
  "most common location: upper outer quadrant of the left breast");
Treatment breastsCancerTr1 = new Treatment("breastsCancerTr1");
breastsCancerTr1.addTreatmentAction(LR.chemoTherapy);
breastsCancerTr1.addTreatmentAction(LR.radiationTherapy);
breastsCancerTr1.addTreatmentAction(LR.surgery);
breastsCancerDis.addTreatment(breastsCancerTr1.getName()); 
Treatment breastsCancerTr2 = new Treatment("breastsCancerTr2");
breastsCancerTr2.addDrug(LR.androgens);
breastsCancerTr2.addDrug(LR.estrogen);
breastsCancerTr2.addDrug(LR.progesterone);
breastsCancerTr2.addDrug(LR.aminoglutethimide);
breastsCancerDis.addTreatment(breastsCancerTr2.getName()); 
breastsCancerDis.setCode358(104);
breastsCancerDis.setICD10code("C50");


// -------------- cervixCancer --------------
// (C) OntoOO Inc Wed Apr 17 13:40:29 PDT 2002
Disease cervixCancerDis = new Disease(
   LR.cervixCancer, 
   "abnormal cells in the cervix lining surface or beyond", 
   LR.neoPlasms, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   50, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.cervixSysSt, 
   LR.none
);
cervixCancerDis.setPrintName("cervix cancer");
cervixCancerDis.setSuperDisease(LR.cancer);
cervixCancerDis.addInternalCause(LR.herpesSimplex); 
cervixCancerDis.addExternalCause(LR.multiplePartners); 
cervixCancerDis.addExternalCause(LR.multiplePregnancies); 
cervixCancerDis.addExternalCause(LR.youngAgeIntercourse);
cervixCancerDis.addReference("pp 104-7");
cervixCancerDis.setMiscComments(
   "Pap smear tests can detect abnormal cells <i>before</i> symptoms appear");
cervixCancerDis.setCode358(107);
cervixCancerDis.setICD10code("C53");


// -------------- cervixCancerEarly --------------
// (C) OntoOO Inc Wed Apr 17 13:40:29 PDT 2002
Disease cervixCancerEarlyDis = new Disease(
   LR.cervixCancerEarly, 
   "abnormal cells in the cervix lining surface or beyond", 
   LR.neoPlasms, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   50, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.cervixSysSt, 
   LR.none
);
cervixCancerEarlyDis.setPrintName("cervix cancer early");
cervixCancerEarlyDis.setSuperDisease(LR.cervixCancer);
cervixCancerEarlyDis.addSymptom(LR.bleedingFromVagina); 
cervixCancerEarlyDis.addSymptom(LR.vaginaDischargePersistent); 
cervixCancerEarlyDis.addSymptom(LR.postcoitalPain);
cervixCancerEarlyDis.addSymptom(LR.postcoitalBleeding);
cervixCancerEarlyDis.addReference("pp 104-7");
cervixCancerEarlyDis.setMiscComments(
   "Pap smear tests can detect abnormal cells <i>before</i> symptoms appear");
Treatment cervixCancerEarlyTr1  = 
  new Treatment("cervixCancerEarlyTr1");
cervixCancerEarlyTr1.addTreatmentAction(LR.cryosurgery);
cervixCancerEarlyTr1.addTreatmentAction(LR.excision);
cervixCancerEarlyTr1.addTreatmentAction(LR.laserSurgery);
cervixCancerEarlyDis.addTreatment(cervixCancerEarlyTr1.getName());
cervixCancerEarlyDis.setCode358(107);
cervixCancerEarlyDis.setICD10code("C53");


// -------------- cervixCancerAdvanced --------------
// (C) OntoOO Inc Wed Apr 17 13:40:29 PDT 2002
Disease cervixCancerAdvancedDis = new Disease(
   LR.cervixCancerAdvanced, 
   "abnormal cells in the cervix lining surface or beyond", 
   LR.neoPlasms, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   50, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.cervixSysSt, 
   LR.none
);
cervixCancerAdvancedDis.setPrintName("cervix cancer advanced");
cervixCancerAdvancedDis.setSuperDisease(LR.cervixCancer);
cervixCancerAdvancedDis.addSymptom(LR.anorexia); 
cervixCancerAdvancedDis.addSymptom(LR.bleedingFromVagina); 
cervixCancerAdvancedDis.addSymptom(LR.pelvisPain); 
cervixCancerAdvancedDis.addSymptom(LR.vaginaDischargePersistent); 
cervixCancerAdvancedDis.addSymptom(LR.weightLoss); 
cervixCancerAdvancedDis.addCausesDisease(LR.anemia); 
cervixCancerAdvancedDis.addReference("pp 104-7");
Treatment cervixCancerAdvancedTr2 = 
  new Treatment("cervixCancerAdvancedTr2");
cervixCancerAdvancedTr2.addTreatmentAction(LR.hysterectomy);
cervixCancerAdvancedTr2.addTreatmentAction(LR.radiationTherapy);
cervixCancerAdvancedDis.addTreatment(cervixCancerAdvancedTr2.getName()); 
cervixCancerAdvancedDis.setCode358(107);
cervixCancerAdvancedDis.setICD10code("C53");


// -------------- esophagusCancer --------------
// (C) OntoOO Inc Fri Dec 30 15:31:59 PST 2011
Disease esophagusCancerDis = new Disease(
   LR.esophagusCancer, 
   "nearly always fatal with low 5-year survival rate", 
   LR.neoPlasms, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   10, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.esophagusSysSt, 
   LR.alcoholAbuse
);
esophagusCancerDis.setPrintName("esophagus cancer");
esophagusCancerDis.setSuperDisease(LR.cancer);
esophagusCancerDis.addSymptom(LR.cough);
esophagusCancerDis.addSymptom(LR.dysphagia);
esophagusCancerDis.addSymptom(LR.emaciation);
esophagusCancerDis.addSymptom(LR.hoarseness);
esophagusCancerDis.addSymptom(LR.weightLoss);
esophagusCancerDis.addExternalCause(LR.tobaccoUse); 
esophagusCancerDis.addReference("pp 81-83");
Treatment esophagusCancerTr1  = new Treatment("esophagusCancerTr1");
esophagusCancerTr1.addTreatmentAction(LR.chemoTherapy);
esophagusCancerDis.addTreatment(esophagusCancerTr1.getName());
Treatment esophagusCancerTr2  = new Treatment("esophagusCancerTr2");
esophagusCancerTr2.addTreatmentAction(LR.surgery);
esophagusCancerDis.addTreatment(esophagusCancerTr2.getName());
Treatment esophagusCancerTr3  = new Treatment("esophagusCancerTr3");
esophagusCancerTr3.addTreatmentAction(LR.radiationTherapy);
esophagusCancerDis.addTreatment(esophagusCancerTr3.getName());
esophagusCancerDis.setCode358(77);
esophagusCancerDis.setICD10code("C15");


// -------------- hodgkinDisease --------------
// (C) OntoOO Inc Sat Feb 01 17:11:24 PST 2003
Disease hodgkinDiseaseDis = new Disease(
   LR.hodgkinDisease, 
   "progressive enlargement of lymph nodes and spleen", 
   LR.neoPlasms, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lymphSysSt, 
   LR.none
);
hodgkinDiseaseDis.setPrintName("Hodgkin disease");
hodgkinDiseaseDis.addReference("pp 133-6");
hodgkinDiseaseDis.setMiscComments(
   "treatment advances has increased the five year survival rate");
Treatment hodgkinDiseaseTr1 = new Treatment("hodgkinDiseaseTr1");
hodgkinDiseaseTr1.addTreatmentAction(LR.chemoTherapy);
hodgkinDiseaseTr1.addTreatmentAction(LR.radiationTherapy);
hodgkinDiseaseDis.addTreatment(hodgkinDiseaseTr1.getName()); 
hodgkinDiseaseDis.setCode358(127);
hodgkinDiseaseDis.setICD10code("C81");


// -------------- hodgkinDisease1 --------------
// (C) OntoOO Inc Mon May 10 16:23:51 PDT 2004
Disease hodgkinDisease1Dis = new Disease(
   LR.hodgkinDisease1, 
   "progressive enlargement of lymph nodes and spleen", 
   LR.neoPlasms, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lymphSysSt, 
   LR.none
);
hodgkinDisease1Dis.setPrintName("Hodgkin disease first phase");
hodgkinDisease1Dis.setSuperDisease(LR.hodgkinDisease);
hodgkinDisease1Dis.addSymptom(LR.neckLymphNodeEnlarged);
hodgkinDisease1Dis.addSymptom(LR.pruritus);
hodgkinDisease1Dis.setTemperature(LR.fever);
hodgkinDisease1Dis.addCausesDisease(LR.hodgkinDisease2); 
hodgkinDisease1Dis.addReference("pp 133-6");
hodgkinDisease1Dis.setMiscComments("the swollen lymph node is usually painless");
hodgkinDisease1Dis.setCode358(127);
hodgkinDisease1Dis.setICD10code("C81");


// -------------- hodgkinDisease2 --------------
// (C) OntoOO Inc Mon May 10 16:52:39 PDT 2004
Disease hodgkinDisease2Dis = new Disease(
   LR.hodgkinDisease2, 
   "progressive enlargement of lymph nodes and spleen", 
   LR.neoPlasms, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   2, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lymphSysSt, 
   LR.none
);
hodgkinDisease2Dis.setPrintName("Hodgkin disease later phase");
hodgkinDisease2Dis.setSuperDisease(LR.hodgkinDisease);
hodgkinDisease2Dis.addSymptom(LR.neckLymphNodeEnlarged, "", 1.0f);
hodgkinDisease2Dis.addSymptom(LR.pruritus, "", 1.0f);
hodgkinDisease2Dis.addSymptom(LR.jaundice);
hodgkinDisease2Dis.addSymptom(LR.lymphadenopathy);
hodgkinDisease2Dis.addSymptom(LR.faceEdema);
hodgkinDisease2Dis.addSymptom(LR.neckEdema);
hodgkinDisease2Dis.addSymptom(LR.nervePain);
hodgkinDisease2Dis.addInternalCause(LR.hodgkinDisease1);
hodgkinDisease2Dis.addCausesDisease(LR.anemia);
hodgkinDisease2Dis.setTemperature(LR.fever);
hodgkinDisease2Dis.addReference("pp 133-6");
hodgkinDisease2Dis.setMiscComments("organs may swell as well");
hodgkinDisease2Dis.setCode358(127);
hodgkinDisease2Dis.setICD10code("C81");


// -------------- kidneyCancer --------------
// (C) OntoOO Inc Sun Sep 25 16:05:45 PDT 2011
Disease kidneyCancerDis = new Disease(
    LR.kidneyCancer,
    "tumors are large firm nodular encapsulated unilateral solitary and have different cell types",
    LR.neoPlasms,
    LR.moreMale, // genderSpecificity
    LR.none, // raceSpecificity
    40, // minAge
    LR.maxAge,
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.renalSysSt,
    LR.none
);
kidneyCancerDis.setPrintName("kidney cancer");
kidneyCancerDis.setSuperDisease(LR.cancer);
kidneyCancerDis.addSymptom(LR.abdomenMassPalpable);
kidneyCancerDis.addSymptom(LR.abdomenPain);
kidneyCancerDis.addSymptom(LR.backPain);
kidneyCancerDis.addSymptom(LR.flankPain);
kidneyCancerDis.addSymptom(LR.hematuria);
kidneyCancerDis.addSymptom(LR.urineRetention);
kidneyCancerDis.addSymptom(LR.weightLoss);
kidneyCancerDis.addCausesDisease(LR.hypertension);
kidneyCancerDis.setTemperature(LR.fever);
kidneyCancerDis.addReference("pp 89-91"); 
Treatment kidneyCancerTr1 = new Treatment("kidneyCancerTr1");
kidneyCancerTr1.addTreatmentAction(LR.surgery);
kidneyCancerDis.addTreatment(kidneyCancerTr1.getName()); 
kidneyCancerDis.setCode358(117);
kidneyCancerDis.setICD10code("C64");


// -------------- leukemia --------------
// (C) OntoOO Inc Sun Feb 02 18:54:16 PST 2003
Disease leukemiaDis = new Disease(
   LR.leukemia, 
   "family of blood disorders", 
   LR.neoPlasms, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.hematologicSysSt, 
   LR.none
);
leukemiaDis.setTemperature((float)102.0);
leukemiaDis.addSymptom(LR.bleedingAbnormal, "", 1.0f);
leukemiaDis.addSymptom(LR.bruising, "", 1.0f);
leukemiaDis.addSymptom(LR.chills, "", 1.0f);
leukemiaDis.addSymptom(LR.ecchymoses, "", 1.0f);
leukemiaDis.addSymptom(LR.pallor, "", 1.0f);
leukemiaDis.addSymptom(LR.petechiae, "", 1.0f);
leukemiaDis.addSymptom(LR.purpura);
leukemiaDis.addSymptom(LR.dyspnea, "", 0.3f);
leukemiaDis.addSymptom(LR.fatigue, "", 0.3f);
leukemiaDis.addSymptom(LR.malaise, "", 0.3f);
leukemiaDis.addSymptom(LR.palpitations, "", 0.3f);
leukemiaDis.addSymptom(LR.tachycardia, "", 0.3f);
leukemiaDis.addCausesDisease(LR.anemia);
leukemiaDis.addReference("pp 139-45");
Treatment leukemiaTr1 = new Treatment("leukemiaTr1");
leukemiaTr1.addTreatmentAction(LR.chemoTherapy);
leukemiaTr1.addTreatmentAction(LR.boneMarrowTransplant);
leukemiaDis.addTreatment(leukemiaTr1.getName()); 
leukemiaDis.setCode358(135);
leukemiaDis.setICD10code("C92");


// -------------- liverCancer --------------
// (C) OntoOO Inc Sun Sep 25 21:22:31 PDT 2011
Disease liverCancerDis = new Disease(
     LR.liverCancer,
     "high mortality rare form of cancer (1% in US) more common elsewhere",
     LR.neoPlasms,
     LR.moreMale, // genderSpecificity
     LR.none, // raceSpecificity
     50, // minAge
     LR.maxAge,
     -1, // duration
     -1, // diagnosis frequency, -1 = unknown
     LR.liverSysSt,
     LR.none
);
liverCancerDis.setPrintName("liver cancer");
liverCancerDis.setSuperDisease(LR.cancer);
liverCancerDis.addInternalCause(LR.hepatitisViral);
liverCancerDis.addSymptom(LR.abdomenBloating);
liverCancerDis.addSymptom(LR.abdomenPainUpperRightSide);
liverCancerDis.addSymptom(LR.abdomenTenderness);
liverCancerDis.addSymptom(LR.anorexia);
liverCancerDis.addSymptom(LR.bleedingAbnormal);
liverCancerDis.addSymptom(LR.bruising);
liverCancerDis.addSymptom(LR.jaundice);
liverCancerDis.addSymptom(LR.weakness);
liverCancerDis.addSymptom(LR.weightLoss);
liverCancerDis.setTemperature(LR.fever);
liverCancerDis.addReference("pp 91-93"); 
liverCancerDis.setMiscComments("Most liver cancers are caused by a cancer started elsewhere"); 
Treatment liverCancerTr1 = new Treatment("liverCancerTr1");
liverCancerTr1.addTreatmentAction(LR.surgery);
liverCancerDis.addTreatment(liverCancerTr1.getName()); 
liverCancerDis.setCode358(85);
liverCancerDis.setICD10code("C22");


// -------------- malignantLymphomas ------------------
Disease malignantLymphomasDis = new Disease(
   LR.malignantLymphomas,
   "a family of diseases originating in lymph glands and lymphoid tissue",
   LR.neoPlasms,
   LR.moreMale, // genderSpecificity
   LR.none, // raceSpecificity
   0, // minAge
   LR.maxAge,
   -1, // duration
   -1, // diagnosis frequency, -1 = unknown
   LR.lymphSysSt,
   LR.none
);
malignantLymphomasDis.setPrintName("malignant lymphomas");
malignantLymphomasDis.setSuperDisease(LR.cancer);
malignantLymphomasDis.addSymptom(LR.appetiteLoss);
malignantLymphomasDis.addSymptom(LR.fatigue);
malignantLymphomasDis.addSymptom(LR.lymphadenopathy);
malignantLymphomasDis.addSymptom(LR.malaise);
malignantLymphomasDis.addSymptom(LR.nausea);
malignantLymphomasDis.addSymptom(LR.nightSweating);
malignantLymphomasDis.addSymptom(LR.tonsilsSwollen);
malignantLymphomasDis.addSymptom(LR.vomiting);
malignantLymphomasDis.addSymptom(LR.weightLoss);
malignantLymphomasDis.setTemperature(LR.fever);
malignantLymphomasDis.addReference("pp 136-138");
Treatment malignantLymphomasTr1 = new Treatment("malignantLymphomasTr1");
malignantLymphomasTr1.addTreatmentAction(LR.radiationTherapy);
malignantLymphomasDis.addTreatment(malignantLymphomasTr1.getName()); 
Treatment malignantLymphomasTr2 = new Treatment("malignantLymphomasTr2");
malignantLymphomasTr2.addTreatmentAction(LR.chemoTherapy);
malignantLymphomasTr2.addDrug(LR.cyclophosphamide);
malignantLymphomasTr2.addDrug(LR.prednisone);
malignantLymphomasDis.addTreatment(malignantLymphomasTr2.getName()); 
malignantLymphomasDis.setCode358(129);
malignantLymphomasDis.setICD10code("C82");


// -------------- malignantMelanoma --------------
// (C) OntoOO Inc Wed Oct 15 16:11:53 PDT 2003
Disease malignantMelanomaDis = new Disease(
   LR.malignantMelanoma, 
   "skin tumor with dark pigment", 
   LR.neoPlasms, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   10, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.sunLight
);
malignantMelanomaDis.setPrintName("malignant melanoma");
malignantMelanomaDis.setSuperDisease(LR.cancer);
malignantMelanomaDis.addReference("pp 127-31");
malignantMelanomaDis.setMiscComments(
    "typically between 50 and 70 but incidences is rising in younger age groups");
Treatment malignantMelanomaTr1 = new Treatment("malignantMelanomaTr1");
malignantMelanomaTr1.addTreatmentAction(LR.surgery);
malignantMelanomaDis.addTreatment("malignantMelanomaTr1");
Treatment malignantMelanomaTr2  = new Treatment("malignantMelanomaTr2", LR.ifSevere);
malignantMelanomaTr2.addTreatmentAction(LR.chemoTherapy);
malignantMelanomaDis.addTreatment(malignantMelanomaTr2.getName());
malignantMelanomaDis.setCode358(98);
malignantMelanomaDis.setICD10code("C43");


// subdiseases of melanoma

// -------------- lentigoMalignaMelanoma --------------
// (C) OntoOO Inc Thu Oct 23 15:11:15 PDT 2003
Disease lentigoMalignaMelanomaDis = new Disease(
   LR.lentigoMalignaMelanoma, 
   "lentigo maligna is a brown patch, generally on the face of the elderly which develops slowly", 
   LR.neoPlasms, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   10, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
lentigoMalignaMelanomaDis.setPrintName("lentigo maligna melanoma");
lentigoMalignaMelanomaDis.setSuperDisease(LR.malignantMelanoma);
lentigoMalignaMelanomaDis.addSymptom(LR.skinLesionFreckelLike);
lentigoMalignaMelanomaDis.addSymptom(LR.skinLesionBlackNodules);
lentigoMalignaMelanomaDis.addReference("pp 127-31");
lentigoMalignaMelanomaDis.setMiscComments(
   "develops usually between 60 and 70, " +
   "color can be: tan brown black whitish slate. " + 
   "location can also be finger nails and back of hands");
lentigoMalignaMelanomaDis.addIllustration(D.LentigoMalignaMelanomaJpg);
lentigoMalignaMelanomaDis.setCode358(98);
lentigoMalignaMelanomaDis.setICD10code("C43");


// -------------- nodularMelanoma --------------
// (C) OntoOO Inc Mon Oct 20 18:11:25 PDT 2003
Disease nodularMelanomaDis = new Disease(
   LR.nodularMelanoma, 
   "nodule like skin tumor that is quickly malignant ", 
   LR.neoPlasms, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   10, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
nodularMelanomaDis.setPrintName("nodular melanoma");
nodularMelanomaDis.setSuperDisease(LR.malignantMelanoma);
nodularMelanomaDis.addSymptom(LR.skinLesionUniformDarkColor);
nodularMelanomaDis.addSymptom(LR.skinLesionBlackberryLike);
nodularMelanomaDis.addReference("pp 127-31");
nodularMelanomaDis.setMiscComments(
   "develops usually between 40 and 50, lesions may be grayish instead");
nodularMelanomaDis.setCode358(98);
nodularMelanomaDis.setICD10code("C43");


// -------------- superficialSpreadingMelanoma --------------
// (C) OntoOO Inc Thu Oct 16 16:43:43 PDT 2003
Disease superficialSpreadingMelanomaDis = new Disease(
   LR.superficialSpreadingMelanoma, 
   "skin tumor with dark pigment that may grow horizontally for many years before becoming malignant", 
   LR.neoPlasms, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   10, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
superficialSpreadingMelanomaDis.setPrintName("superficial spreading melanoma");
superficialSpreadingMelanomaDis.setSuperDisease(LR.malignantMelanoma);
superficialSpreadingMelanomaDis.addSymptom(LR.skinLesionRedWhite);
superficialSpreadingMelanomaDis.addSymptom(LR.skinLesionBlue);
superficialSpreadingMelanomaDis.addSymptom(LR.skinLesionBackgroundBrownBlack);
superficialSpreadingMelanomaDis.addSymptom(LR.skinLesionSurfaceIrregular);
superficialSpreadingMelanomaDis.addSymptom(LR.skinLesionNodulesBleeding);
superficialSpreadingMelanomaDis.addReference("pp 127-31");
superficialSpreadingMelanomaDis.setMiscComments("develops usually between 40 and 50. " +
   "lesions arise in areas of chronic irritation. " +
   "in woman commonly between knees and ankles. " + 
   "in blacks and asians on the toe webs and soles");
superficialSpreadingMelanomaDis.setCode358(98);
superficialSpreadingMelanomaDis.setICD10code("C43");


// -------------- multipleMyeloma --------------
// (C) OntoOO Inc Fri Dec 30 17:03:07 PST 2011
Disease multipleMyelomaDis = new Disease(
   LR.multipleMyeloma, 
   "out of control growth in bone marrow causing bone tumors low survival rate", 
   LR.neoPlasms, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skeletalSysSt, 
   LR.none
);
multipleMyelomaDis.setPrintName("multiple myeloma");
multipleMyelomaDis.setSuperDisease(LR.cancer);
multipleMyelomaDis.addSymptom(LR.backPain);
multipleMyelomaDis.addSymptom(LR.jointSwelling);
multipleMyelomaDis.addSymptom(LR.jointTender);
multipleMyelomaDis.addSymptom(LR.feverSym);
multipleMyelomaDis.addSymptom(LR.malaise);
multipleMyelomaDis.addSymptom(LR.weightLoss);
multipleMyelomaDis.addCausesDisease(LR.anemia);
multipleMyelomaDis.addReference("pp 122-124");
Treatment multipleMyelomaTr1  = new Treatment("multipleMyelomaTr1");
multipleMyelomaTr1.addTreatmentAction(LR.chemoTherapy);
multipleMyelomaTr1.addDrug(LR.prednisone);
multipleMyelomaDis.addTreatment(multipleMyelomaTr1.getName());
multipleMyelomaDis.setCode358(132);
multipleMyelomaDis.setICD10code("C90");


// -------------- pancreasCancer --------------
// (C) OntoOO Inc Mon Jan 08 21:38:08 PST 2007
Disease pancreasCancerDis = new Disease(
   LR.pancreasCancer, 
   "cancer in the pancreas", 
   LR.neoPlasms, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   35, //  minAge 
   70,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.pancreasSysSt, 
   LR.alcoholAbuse
);
pancreasCancerDis.setPrintName("pancreas cancer");
pancreasCancerDis.setSuperDisease(LR.cancer);
pancreasCancerDis.setTemperature((float)101.0);
pancreasCancerDis.addSymptom(LR.abdomenPain, "", 0.5f);
pancreasCancerDis.addSymptom(LR.anxiety);
pancreasCancerDis.addSymptom(LR.diarrhea);
pancreasCancerDis.addSymptom(LR.doomFeeling);
pancreasCancerDis.addSymptom(LR.jaundice);
pancreasCancerDis.addSymptom(LR.lowBackPain, "", 0.5f);
pancreasCancerDis.addSymptom(LR.weightLoss);
pancreasCancerDis.addInternalCause(LR.diabetesMellitus);
pancreasCancerDis.addInternalCause(LR.pancreatitis);
pancreasCancerDis.addCausesDisease(LR.depression);
pancreasCancerDis.addReference("pp 83-7");
pancreasCancerDis.setMiscComments(
    "The disease has usually metastatized widely at diagnosis. " +
    "Survival rate is low."); 
Treatment pancreasCancerTr1 = new Treatment("pancreasCancerTr1");
pancreasCancerTr1.addTreatmentAction(LR.chemoTherapy);
pancreasCancerTr1.addTreatmentAction(LR.radiationTherapy);
pancreasCancerTr1.addTreatmentAction(LR.surgery);
pancreasCancerDis.addTreatment("pancreasCancerTr1");
pancreasCancerDis.setCode358(88);
pancreasCancerDis.setICD10code("C25");


// -------------- prostateCancer --------------
// (C) OntoOO Inc Tue Apr 15 20:24:49 PDT 2003
Disease prostateCancerDis = new Disease(
   LR.prostateCancer, 
   "prostate cancer", 
   LR.neoPlasms, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.prostateSysSt, 
   LR.none
);
prostateCancerDis.setPrintName();
prostateCancerDis.setSuperDisease(LR.cancer);
prostateCancerDis.addSymptom(LR.hematuria, "", 0.05f);
prostateCancerDis.addSymptom(LR.urinaryFrequency);
prostateCancerDis.addSymptom(LR.nocturia);
prostateCancerDis.addSymptom(LR.urinationStartDifficult, "", 1.0f);
prostateCancerDis.addSymptom(LR.urineDribbling, "", 1.0f);
prostateCancerDis.addSymptom(LR.urineRetention, "", 1.0f);
prostateCancerDis.addCausesDisease(LR.cystitis); 
prostateCancerDis.setMiscComments("incidence is higher in blacks and lowest in asians, " + 
				  "incidence increases with age");
prostateCancerDis.addReference("pp 98-101");
Treatment prostateCancerTr1 = new Treatment("prostateCancerTr1");
prostateCancerTr1.addTreatmentAction(LR.radiationTherapy);
prostateCancerTr1.addTreatmentAction(LR.surgery);
prostateCancerTr1.addDrug(LR.estrogen);
prostateCancerTr1.addDrug(LR.antiandrogens);
prostateCancerDis.addTreatment(prostateCancerTr1.getName()); 
prostateCancerDis.setCode358(113);
prostateCancerDis.setICD10code("C61");


// -------------- squamousCellCarcinoma --------------
// (C) OntoOO Inc Wed Oct 29 15:44:38 PST 2003
Disease squamousCellCarcinomaDis = new Disease(
   LR.squamousCellCarcinoma, 
   "tumor starting in the outmost epidermal layer", 
   LR.neoPlasms, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   50, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.sunLight
);
squamousCellCarcinomaDis.setPrintName("squamous cell carcinoma");
squamousCellCarcinomaDis.setSuperDisease(LR.cancer);
squamousCellCarcinomaDis.addSymptom(LR.papuleRedSmall, "or plaque like", 0.5f);
squamousCellCarcinomaDis.addSymptom(LR.skinLesionCrackedCrusty, "", 0.5f);
squamousCellCarcinomaDis.addSymptom(LR.skinLesionDryScaly, "", 0.5f);
squamousCellCarcinomaDis.addSymptom(LR.skinLesionSurfaceIrregular, 
				    "nodular sometimes warty surface", 0.5f); 
squamousCellCarcinomaDis.addReference("pp 125-7");
// squamousCellCarcinomaTr1 is defined at basalCellCarcinoma ...
squamousCellCarcinomaDis.addTreatment(squamousCellCarcinomaTr1.getName()); 


// -------------- stomachCancerSuper --------------
// (C) OntoOO Inc Mon Feb 17 15:19:30 PST 2003
Disease stomachCancerSuperDis = new Disease(
   LR.stomachCancerSuper, 
   "cancer of the stomach", 
   LR.neoPlasms, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.stomachSysSt, 
   LR.alcoholAbuse
);
stomachCancerSuperDis.setPrintName("stomach cancer super");
stomachCancerSuperDis.setSuperDisease(LR.cancer);
stomachCancerSuperDis.setGenetic("1parent");
stomachCancerSuperDis.setParentDisease(LR.stomachCancerSuper);
stomachCancerSuperDis.addSymptom(LR.dyspepsia);
stomachCancerSuperDis.addSymptom(LR.dysphagia);
stomachCancerSuperDis.addSymptom(LR.stomachache);
stomachCancerSuperDis.addExternalCause(LR.tobaccoUse);
stomachCancerSuperDis.addReference("pp 78-81");
Treatment stomachCancerSuperTr1  = new Treatment("stomachCancerSuperTr1");
stomachCancerSuperTr1.addTreatmentAction(LR.surgery);
stomachCancerSuperDis.addTreatment(stomachCancerSuperTr1.getName());
stomachCancerSuperDis.setCode358(78);
stomachCancerSuperDis.setICD10code("C16");


// -------------- stomachCancer --------------
// (C) OntoOO Inc Mon Feb 17 15:19:30 PST 2003
Disease stomachCancerDis = new Disease(
   LR.stomachCancer, 
   "cancer of the stomach", 
   LR.neoPlasms, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.stomachSysSt, 
   LR.alcoholAbuse
);
stomachCancerDis.setPrintName("stomach cancer");
stomachCancerDis.setSuperDisease(LR.stomachCancerSuper);
stomachCancerDis.setGenetic("1parent");
stomachCancerDis.setParentDisease(LR.stomachCancer);
stomachCancerDis.addSymptom(LR.anorexia, "", 0.5f);
stomachCancerDis.addSymptom(LR.bloating, "", 0.5f);
stomachCancerDis.addSymptom(LR.heartburn, "", 0.5f);
stomachCancerDis.addSymptom(LR.nausea, "", 0.5f);
stomachCancerDis.addCausesDisease(LR.stomachCancerAdvanced);
stomachCancerDis.addReference("pp 78-81");
stomachCancerDis.setCode358(78);
stomachCancerDis.setICD10code("C16");


// -------------- stomachCancerAdvanced --------------
// (C) OntoOO Inc Wed Feb 19 15:46:01 PST 2003
Disease stomachCancerAdvancedDis = new Disease(
   LR.stomachCancerAdvanced, 
   "cancer of the stomach advanced", 
   LR.neoPlasms, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.stomachSysSt, 
   LR.none
);
stomachCancerAdvancedDis.setPrintName("stomach cancer advanced");
stomachCancerAdvancedDis.setSuperDisease(LR.stomachCancerSuper);
stomachCancerAdvancedDis.setGenetic("1parent");
stomachCancerAdvancedDis.setParentDisease(LR.stomachCancer);
stomachCancerAdvancedDis.addSymptom(LR.anorexia, "", 1.0f);
stomachCancerAdvancedDis.addSymptom(LR.fatigue, "", 1.0f);
stomachCancerAdvancedDis.addSymptom(LR.vomiting, "", 1.0f);
stomachCancerAdvancedDis.addSymptom(LR.weightLoss, "", 1.0f);
stomachCancerAdvancedDis.addSymptom(LR.stoolBloody, "", 0.5f);
stomachCancerAdvancedDis.addInternalCause(LR.stomachCancer);
stomachCancerAdvancedDis.addCausesDisease(LR.anemia);
stomachCancerAdvancedDis.addReference("pp 78-81");
stomachCancerAdvancedDis.setCode358(78);
stomachCancerAdvancedDis.setICD10code("C16");


// -------------- thyroidCancer --------------
Disease thyroidCancerDis = new Disease(
    LR.thyroidCancer,
    "a family of different types with the papillary version " +
    "the most common and the least dangerous",
    LR.neoPlasms,
    LR.moreFemale, // genderSpecificity
    LR.none, // raceSpecificity
    0, // minAge
    LR.maxAge,
    -1, // duration
    -1, // diagnosis frequency, -1 = unknown
    LR.thyroidSysSt,
    LR.none
);
thyroidCancerDis.setPrintName("thyroid cancer");
thyroidCancerDis.setSuperDisease(LR.cancer);
thyroidCancerDis.addSymptom(LR.cough);
thyroidCancerDis.addSymptom(LR.dysphagia);
thyroidCancerDis.addSymptom(LR.dyspnea);
thyroidCancerDis.addSymptom(LR.hoarseness);
thyroidCancerDis.addSymptom(LR.neckEdema);
thyroidCancerDis.addSymptom(LR.thyroidEnlargement);
thyroidCancerDis.addReference("pp 65-68");
Treatment thyroidCancerTr1 = new Treatment("thyroidCancerTr1");
thyroidCancerTr1.addTreatmentAction(LR.surgery);
thyroidCancerDis.addTreatment(thyroidCancerTr1.getName()); 
Treatment thyroidCancerTr2 = new Treatment("thyroidCancerTr2");
thyroidCancerTr2.addTreatmentAction(LR.radiationTherapy);
thyroidCancerDis.addTreatment(thyroidCancerTr2.getName()); 
Treatment thyroidCancerTr3 = new Treatment("thyroidCancerTr3");
thyroidCancerTr3.addTreatmentAction(LR.chemoTherapy);
thyroidCancerDis.addTreatment(thyroidCancerTr3.getName()); 
thyroidCancerDis.setCode358(124);
thyroidCancerDis.setICD10code("C73");


// -------------- uterusCancer --------------
// (C) OntoOO Inc Thu Apr 18 10:58:12 PDT 2002
Disease uterusCancerDis = new Disease(
   LR.uterusCancer, 
   "abnormal cells in the uterus lining surface or beyond", 
   LR.neoPlasms, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   50, //  minAge 
   60, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.uterusSysSt, 
   LR.none
);
uterusCancerDis.setPrintName("uterus cancer");
uterusCancerDis.setSuperDisease(LR.cancer);
uterusCancerDis.setGenetic("mother");
uterusCancerDis.setParentDisease(LR.uterusCancer);
uterusCancerDis.addSymptom(LR.uterusBleedingAbnormal);
uterusCancerDis.addSymptom(LR.uterusEnlarged);
uterusCancerDis.addSymptom(LR.weightLoss, "if advanced", 0.2f);
uterusCancerDis.addSymptom(LR.uterusPain, "if advanced", 0.2f);
uterusCancerDis.addInternalCause(LR.diabetes); 
uterusCancerDis.addInternalCause(LR.obesity);
uterusCancerDis.addExternalCause(LR.uterusPolypsHistory);
uterusCancerDis.addCausingAbnormalCondition(LR.lowFertility);
uterusCancerDis.addCausingAbnormalCondition(LR.anovulation);
// uterusCancerDis.addCausingAbnormalCondition(LR.obesity);
uterusCancerDis.addReference("pp 107-10");
Treatment uterusCancerTr1  = new Treatment("uterusCancerTr1");
uterusCancerTr1.addTreatmentAction(LR.hysterectomy);
uterusCancerDis.addTreatment(uterusCancerTr1.getName());
Treatment uterusCancerTr2 = new Treatment("uterusCancerTr2");
uterusCancerTr2.addTreatmentAction(LR.radiationTherapy);
uterusCancerDis.addTreatment(uterusCancerTr2.getName()); 
Treatment uterusCancerTr3 = new Treatment("uterusCancerTr3");
uterusCancerTr3.addTreatmentAction(LR.hormoneTherapy);
uterusCancerDis.addTreatment(uterusCancerTr3.getName()); 
Treatment uterusCancerTr4 = new Treatment("uterusCancerTr4");
uterusCancerTr4.addTreatmentAction(LR.chemoTherapy);
uterusCancerDis.addTreatment(uterusCancerTr4.getName()); 
uterusCancerDis.setCode358(108);
uterusCancerDis.setICD10code("C54");


// -------------- vaginaCancer --------------
// (C) OntoOO Inc Thu Apr 18 22:28:01 PDT 2002
Disease vaginaCancerDis = new Disease(
   LR.vaginaCancer, 
   "abnormal cells in the vagina lining surface or beyond", 
   LR.neoPlasms, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   50, //  minAge 
   55, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vaginagySysSt, 
   LR.none
);
vaginaCancerDis.setPrintName("vagina cancer");
vaginaCancerDis.setSuperDisease(LR.cancer);
vaginaCancerDis.addSymptom(LR.bleedingFromVaginaAbnormal); 
vaginaCancerDis.addSymptom(LR.vaginaDischarge); 
vaginaCancerDis.addSymptom(LR.vaginaUlceratedLesion);
vaginaCancerDis.addReference("pp 110-2");
vaginaCancerDis.setCode358(106);
vaginaCancerDis.setICD10code("C52");


// -------------- vaginaCancerEarly --------------
// (C) OntoOO Inc Fri Apr 19 11:52:23 PDT 2002
Disease vaginaCancerEarlyDis = new Disease(
   LR.vaginaCancerEarly, 
   "abnormal cells in the vagina lining surface or beyond", 
   LR.neoPlasms, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   50, //  minAge 
   55, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vaginagySysSt, 
   LR.none
);
vaginaCancerEarlyDis.setPrintName("vagina cancer early");
vaginaCancerEarlyDis.setSuperDisease(LR.vaginaCancer);
vaginaCancerEarlyDis.addCausesDisease(LR.vaginaCancerAdvanced);
vaginaCancerEarlyDis.addReference("pp 110-2");
Treatment vaginaCancerEarlyTr1  = new Treatment("vaginaCancerEarlyTr1");
vaginaCancerEarlyTr1.addTreatmentAction(LR.chemoTherapy);
vaginaCancerEarlyDis.addTreatment(vaginaCancerEarlyTr1.getName());
vaginaCancerEarlyDis.setCode358(106);
vaginaCancerEarlyDis.setICD10code("C52");


// -------------- vaginaCancerAdvanced --------------
// (C) OntoOO Inc Fri Apr 19 12:11:09 PDT 2002
Disease vaginaCancerAdvancedDis = new Disease(
   LR.vaginaCancerAdvanced, 
   "abnormal cells in the vagina lining surface or beyond", 
   LR.neoPlasms, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   50, //  minAge 
   55, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vaginagySysSt, 
   LR.none
);
vaginaCancerAdvancedDis.setPrintName("vagina cancer advanced");
vaginaCancerAdvancedDis.setSuperDisease(LR.vaginaCancer);
vaginaCancerAdvancedDis.addSymptom(LR.bleedingFromRectum);
vaginaCancerAdvancedDis.addSymptom(LR.urinaryFrequency);
vaginaCancerAdvancedDis.addSymptom(LR.bladderPain);
vaginaCancerAdvancedDis.addSymptom(LR.vulvaLesion);
vaginaCancerAdvancedDis.addSymptom(LR.pubisPain);
vaginaCancerAdvancedDis.addInternalCause(LR.vaginaCancerEarly);

vaginaCancerAdvancedDis.addReference("pp 110-2");
Treatment vaginaCancerAdvancedTr1 = new Treatment("vaginaCancerAdvancedTr1");
vaginaCancerAdvancedTr1.addTreatmentAction(LR.radiationTherapy);
vaginaCancerAdvancedTr1.addTreatmentAction(LR.surgery);
vaginaCancerAdvancedDis.addTreatment(vaginaCancerAdvancedTr1.getName()); 
vaginaCancerAdvancedDis.setCode358(106);
vaginaCancerAdvancedDis.setICD10code("C52");


// -------------- ovariesCancer --------------
// (C) OntoOO Inc Sat Apr 20 17:07:17 PDT 2002
Disease ovariesCancerDis = new Disease(
   LR.ovariesCancer, 
   "tumor(s) in the ovaries", 
   LR.neoPlasms, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   54, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.ovariesSysSt, 
   LR.asbestosExposure
);
ovariesCancerDis.setPrintName("ovaries cancer");
ovariesCancerDis.setSuperDisease(LR.cancer);
ovariesCancerDis.setGenetic("mother");
ovariesCancerDis.setParentDisease(LR.ovariesCancer);
ovariesCancerDis.addExternalCause(LR.nulliparity);
ovariesCancerDis.addExternalCause(LR.dietHighFat);
ovariesCancerDis.addExternalCause(LR.talcExposure);
ovariesCancerDis.addInternalCause(LR.infertilityFemale);
ovariesCancerDis.addInternalCause(LR.breastsCancer);
ovariesCancerDis.addInternalCause(LR.uterusCancer);
ovariesCancerDis.addReference("pp 112-5");
Treatment ovariesCancerTr1  = new Treatment("ovariesCancerTr1");
ovariesCancerTr1.addTreatmentAction(LR.chemoTherapy);
ovariesCancerTr1.addTreatmentAction(LR.radiationTherapy);
ovariesCancerTr1.addTreatmentAction(LR.surgery);
ovariesCancerDis.addTreatment(ovariesCancerTr1.getName());
ovariesCancerDis.setCode358(109);
ovariesCancerDis.setICD10code("C56");


// -------------- ovariesCancerEarly --------------
// (C) OntoOO Inc Sat Apr 20 22:22:31 PDT 2002
Disease ovariesCancerEarlyDis = new Disease(
   LR.ovariesCancerEarly, 
   "tumor(s) in the ovaries", 
   LR.neoPlasms, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   54, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.ovariesSysSt, 
   LR.none
);
ovariesCancerEarlyDis.setPrintName("ovaries cancer early");
ovariesCancerEarlyDis.setSuperDisease(LR.ovariesCancer);
ovariesCancerEarlyDis.setGenetic("mother");
ovariesCancerEarlyDis.setParentDisease(LR.ovariesCancer);
ovariesCancerEarlyDis.addSymptom(LR.abdomenPain);
ovariesCancerEarlyDis.addSymptom(LR.constipation);
ovariesCancerEarlyDis.addSymptom(LR.dyspepsia);
ovariesCancerEarlyDis.addSymptom(LR.pelvisDiscomfort);
ovariesCancerEarlyDis.addSymptom(LR.urinaryFrequency);
ovariesCancerEarlyDis.addSymptom(LR.weightLoss);
ovariesCancerEarlyDis.addReference("pp 112-5");
ovariesCancerEarlyDis.setCode358(109);
ovariesCancerEarlyDis.setICD10code("C56");


// -------------- ovariesCancerAdvanced --------------
// (C) OntoOO Inc Sun Apr 21 15:03:03 PDT 2002
Disease ovariesCancerAdvancedDis = new Disease(
   LR.ovariesCancerAdvanced, 
   "tumor(s) in the ovaries", 
   LR.neoPlasms, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   54, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.ovariesSysSt, 
   LR.none
);
ovariesCancerAdvancedDis.setPrintName("ovaries cancer advanced");
ovariesCancerAdvancedDis.setSuperDisease(LR.ovariesCancerEarly);
ovariesCancerAdvancedDis.setGenetic("mother");
ovariesCancerAdvancedDis.setParentDisease(LR.ovariesCancer);
ovariesCancerAdvancedDis.addCausesAbnormalCondition(LR.ascites);
ovariesCancerAdvancedDis.addCausesAbnormalCondition(LR.pleuralEffusion);
ovariesCancerAdvancedDis.addReference("pp 112-5");
ovariesCancerAdvancedDis.setMiscComments(
   "additional symptoms arise from other affected metastatic sites");
ovariesCancerAdvancedDis.setCode358(109);
ovariesCancerAdvancedDis.setICD10code("C56");


// -------------- vulvaCancer --------------
// (C) OntoOO Inc Sun Apr 21 15:44:21 PDT 2002
Disease vulvaCancerDis = new Disease(
   LR.vulvaCancer, 
   "abnormal cells in the vulva lining surface or beyond", 
   LR.neoPlasms, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   60, //  minAge 
   70, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vulvaSysSt, 
   LR.nulliparity
);
vulvaCancerDis.setPrintName("vulva cancer");
vulvaCancerDis.setSuperDisease(LR.cancer);
vulvaCancerDis.addSymptom(LR.vulvaItching);
vulvaCancerDis.addSymptom(LR.bleedingVulva);
vulvaCancerDis.addSymptom(LR.vulvaUlcer);
vulvaCancerDis.addSymptom(LR.vulvaUlcerInfected);
vulvaCancerDis.addSymptom(LR.vulvaPain);
// vulvaCancerDis.addCausingAbnormalCondition(LR.obesity);
vulvaCancerDis.addInternalCause(LR.leukoplakia);
vulvaCancerDis.addInternalCause(LR.diabetes);
vulvaCancerDis.addInternalCause(LR.herpesSimplex);
vulvaCancerDis.addInternalCause(LR.obesity);
vulvaCancerDis.addReference("pp 115-7");
vulvaCancerDis.setMiscComments("can also occur at younger ages");
Treatment vulvaCancerTr1  = new Treatment("vulvaCancerTr1");
vulvaCancerTr1.addTreatmentAction(LR.laserSurgery);
vulvaCancerTr1.addTreatmentAction(LR.surgery);
vulvaCancerDis.addTreatment(vulvaCancerTr1.getName());
vulvaCancerDis.setCode358(106);
vulvaCancerDis.setICD10code("C51");


// -------------- fallopianTubeCancer --------------
// (C) OntoOO Inc Mon Apr 22 16:24:47 PDT 2002
Disease fallopianTubeCancerDis = new Disease(
   LR.fallopianTubeCancer, 
   "tumors in the fallopian tubes", 
   LR.neoPlasms, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   50, //  minAge 
   70, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.fallopianTubesSysSt, 
   LR.nulliparity
);
fallopianTubeCancerDis.setPrintName("fallopian tube cancer");
fallopianTubeCancerDis.setSuperDisease(LR.cancer);
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
fallopianTubeCancerDis.addReference("pp 117-9");
fallopianTubeCancerDis.setMiscComments("can also occur at younger ages");
Treatment fallopianTubeCancerTr1  = new Treatment("fallopianTubeCancerTr1");
fallopianTubeCancerTr1.addTreatmentAction(LR.chemoTherapy);
fallopianTubeCancerTr1.addTreatmentAction(LR.radiationTherapy);
fallopianTubeCancerTr1.addTreatmentAction(LR.surgery);
fallopianTubeCancerDis.addTreatment(fallopianTubeCancerTr1.getName());
fallopianTubeCancerDis.setCode358(110);
fallopianTubeCancerDis.setICD10code("C57");


// -------------- leukoplakia --------------
// (C) OntoOO Inc Sun Apr 21 21:05:52 PDT 2002
Disease leukoplakiaDis = new Disease(
   LR.leukoplakia, 
   "lesions on oral, anal, and genital mucous membranes", 
   LR.neoPlasms, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
leukoplakiaDis.addReference("pp 126");
Treatment leukoplakiaTr1 = new Treatment("leukoplakiaTr1");
leukoplakiaTr1.addTreatmentAction(LR.curettage);
leukoplakiaTr1.addTreatmentAction(LR.surgery);
leukoplakiaDis.addTreatment("leukoplakiaTr1");


// -------------- leukoplakiaMale --------------
// (C) OntoOO Inc Fri Jul 09 14:18:49 PDT 2004
Disease leukoplakiaMaleDis = new Disease(
   LR.leukoplakiaMale, 
   "lesions on oral mucous membrane", 
   LR.neoPlasms, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mouthSysSt, 
   LR.none
);
leukoplakiaMaleDis.setPrintName("leukoplakia male");
leukoplakiaMaleDis.setSuperDisease(LR.leukoplakia);
leukoplakiaMaleDis.addSymptom(LR.mouthLesionWhiteGrey);
leukoplakiaMaleDis.addReference("pp 126");


// -------------- leukoplakiaFemale --------------
// (C) OntoOO Inc Fri Jul 09 15:34:46 PDT 2004
Disease leukoplakiaFemaleDis = new Disease(
   LR.leukoplakiaFemale, 
   "lesions on mucous membrane", 
   LR.neoPlasms, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
leukoplakiaFemaleDis.setPrintName("leukoplakia female");
leukoplakiaFemaleDis.setSuperDisease(LR.leukoplakia);
leukoplakiaFemaleDis.addSymptom(LR.mouthLesionWhiteGrey);
leukoplakiaFemaleDis.addSymptom(LR.genitalLesionWhiteGrey);
leukoplakiaFemaleDis.addReference("pp 126");


  }
} // end InitNeoplasmDiseases
