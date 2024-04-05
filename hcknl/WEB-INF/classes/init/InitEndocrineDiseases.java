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

public class InitEndocrineDiseases {
  public static void doit() {


// -------------- adrenalCrisis ---------------
// (C) OntoOO Inc Fri Oct 26 10:38:50 PDT 2001
Disease adrenalCrisisDis = new Disease(
   LR.adrenalCrisis, 
   "critical deficiency of mineralocorticoids and glucocorticoids", 
   LR.endocrineDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.adrenalSysSt, 
   LR.none
);
adrenalCrisisDis.setPrintName("adrenal crisis");
adrenalCrisisDis.setTemperature(LR.highFever);
adrenalCrisisDis.addSymptom(LR.coma, "if not treated", 0.1f);
adrenalCrisisDis.addSymptom(LR.fatigue, "", 1.0f);
adrenalCrisisDis.addSymptom(LR.hypotension, "", 1.0f);
adrenalCrisisDis.addSymptom(LR.nausea, "", 1.0f);
adrenalCrisisDis.addSymptom(LR.vomiting, "", 1.0f);
adrenalCrisisDis.addSymptom(LR.weakness, "", 1.0f);
adrenalCrisisDis.addSymptom(LR.dehydration, "", 1.0f); 
adrenalCrisisDis.addSymptom(LR.hypothermia, "after a phase with high fever", 0.3f); 
adrenalCrisisDis.addCausesDisease(LR.renalInfarction); 
adrenalCrisisDis.addCausesAbnormalCondition(LR.vascularCollapse); 
adrenalCrisisDis.addCausesAbnormalCondition(LR.death);
adrenalCrisisDis.addReference("pp 835-8");
adrenalCrisisDis.setMiscComments("subdisease of adrenalHypofunction ?");
Treatment adrenalCrisisTr1  = new Treatment("adrenalCrisisTr1");
adrenalCrisisTr1.addTreatmentAction(LR.IVFluids);
adrenalCrisisTr1.addDrug(LR.corticosteroids);
adrenalCrisisTr1.addDrug(LR.insulin);
adrenalCrisisTr1.addDrug(LR.potassium);
adrenalCrisisDis.addTreatment(adrenalCrisisTr1.getName());


// -------------- adrenogenitalSyndrome --------------
// (C) OntoOO Inc Fri Mar 29 11:23:57 PST 2002
Disease adrenogenitalSyndromeDis = new Disease(
   LR.adrenogenitalSyndrome, 
   "disorder of adrenocortical steroid biosynthesis ", 
   LR.endocrineDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.endocrineSysSt, 
   LR.none
);
adrenogenitalSyndromeDis.setPrintName("adrenogenital syndrome");
adrenogenitalSyndromeDis.addReference("pp 843-6");


// -------------- congenitalAdrenalHyperplasia --------------
// (C) OntoOO Inc Thu Dec 25 15:07:50 PST 2003
Disease congenitalAdrenalHyperplasiaDis = new Disease(
   LR.congenitalAdrenalHyperplasia, 
   "inherited adrenal disorder", 
   LR.endocrineDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   20,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.endocrineSysSt, 
   LR.none
);
congenitalAdrenalHyperplasiaDis.setPrintName("congenital adrenal hyperplasia");
congenitalAdrenalHyperplasiaDis.setSuperDisease(LR.adrenogenitalSyndrome);
congenitalAdrenalHyperplasiaDis.setGenetic("1parent");
congenitalAdrenalHyperplasiaDis.setParentDisease(LR.congenitalAdrenalHyperplasia);
congenitalAdrenalHyperplasiaDis.addReference("pp 843-6");
Treatment congenitalAdrenalHyperplasiaTr1  = 
   new Treatment("congenitalAdrenalHyperplasiaTr1");
congenitalAdrenalHyperplasiaTr1.addDrug(LR.hydrocortisone);
congenitalAdrenalHyperplasiaTr1.addDrug(LR.cortisone);
congenitalAdrenalHyperplasiaDis.addTreatment(congenitalAdrenalHyperplasiaTr1.getName());


// -------------- congenitalAdrenalHyperplasiaFemale --------------
// (C) OntoOO Inc Thu Dec 25 15:22:17 PST 2003
Disease congenitalAdrenalHyperplasiaFemaleDis = new Disease(
   LR.congenitalAdrenalHyperplasiaFemale, 
   "inherited adrenal disorder", 
   LR.endocrineDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   20,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.endocrineSysSt, 
   LR.none
);
congenitalAdrenalHyperplasiaFemaleDis.setPrintName("congenital adrenal hyperplasia female");
congenitalAdrenalHyperplasiaFemaleDis.setSuperDisease(LR.congenitalAdrenalHyperplasia);
congenitalAdrenalHyperplasiaFemaleDis.setGenetic("1parent");
congenitalAdrenalHyperplasiaFemaleDis.setParentDisease(LR.congenitalAdrenalHyperplasia);
congenitalAdrenalHyperplasiaFemaleDis.addSymptom(LR.acne);
congenitalAdrenalHyperplasiaFemaleDis.addSymptom(LR.voiceDeepened);
congenitalAdrenalHyperplasiaFemaleDis.addSymptom(LR.faceHair);
congenitalAdrenalHyperplasiaFemaleDis.addSymptom(LR.pubisHairEarly);
congenitalAdrenalHyperplasiaFemaleDis.addReference("pp 843-6");


// -------------- congenitalAdrenalHyperplasiaMale --------------
// (C) OntoOO Inc Thu Dec 25 15:40:34 PST 2003
Disease congenitalAdrenalHyperplasiaMaleDis = new Disease(
   LR.congenitalAdrenalHyperplasiaMale, 
   "inherited adrenal disorder", 
   LR.endocrineDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   20,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.endocrineSysSt, 
   LR.none
);
congenitalAdrenalHyperplasiaMaleDis.setPrintName("congenital adrenal hyperplasia male");
congenitalAdrenalHyperplasiaMaleDis.setSuperDisease(LR.congenitalAdrenalHyperplasia);
congenitalAdrenalHyperplasiaMaleDis.setGenetic("1parent");
congenitalAdrenalHyperplasiaMaleDis.setParentDisease(LR.congenitalAdrenalHyperplasia);
congenitalAdrenalHyperplasiaMaleDis.addSymptom(LR.voiceDeepened, "", 1.0f);
congenitalAdrenalHyperplasiaMaleDis.addSymptom(LR.penisEnlarged);
congenitalAdrenalHyperplasiaMaleDis.addSymptom(LR.erectionFrequent);
congenitalAdrenalHyperplasiaMaleDis.addReference("pp 843-6");


// -------------- saltLosingCongenitalAdrenalHyperplasia --------------
// (C) OntoOO Inc Thu Dec 25 16:41:16 PST 2003
Disease saltLosingCongenitalAdrenalHyperplasiaDis = new Disease(
   LR.saltLosingCongenitalAdrenalHyperplasia, 
   "inherited adrenal disorder", 
   LR.endocrineDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   1,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.endocrineSysSt, 
   LR.none
);
saltLosingCongenitalAdrenalHyperplasiaDis.setPrintName(
   "salt losing congenital adrenal hyperplasia");
saltLosingCongenitalAdrenalHyperplasiaDis.setSuperDisease(LR.adrenogenitalSyndrome);
saltLosingCongenitalAdrenalHyperplasiaDis.setGenetic("1parent");
saltLosingCongenitalAdrenalHyperplasiaDis.setParentDisease(
   LR.congenitalAdrenalHyperplasia);
saltLosingCongenitalAdrenalHyperplasiaDis.addSymptom(LR.apathy);
saltLosingCongenitalAdrenalHyperplasiaDis.addSymptom(LR.appetiteLoss);
saltLosingCongenitalAdrenalHyperplasiaDis.addSymptom(LR.dehydration);
saltLosingCongenitalAdrenalHyperplasiaDis.addSymptom(LR.diarrhea);
saltLosingCongenitalAdrenalHyperplasiaDis.addSymptom(LR.vomiting);
saltLosingCongenitalAdrenalHyperplasiaDis.addReference("pp 843-6");
Treatment saltLosingCongenitalAdrenalHyperplasiaTr1  = 
   new Treatment("saltLosingCongenitalAdrenalHyperplasiaTr1");
saltLosingCongenitalAdrenalHyperplasiaTr1.addTreatmentAction(LR.sodiumChloride);
saltLosingCongenitalAdrenalHyperplasiaTr1.addTreatmentAction(LR.glucose);
saltLosingCongenitalAdrenalHyperplasiaDis.addTreatment(
   saltLosingCongenitalAdrenalHyperplasiaTr1.getName());


// -------------- cushingSyndrome --------------
// (C) OntoOO Inc Sun Feb 22 15:43:17 PST 2004
Disease cushingSyndromeDis = new Disease(
   LR.cushingSyndrome, 
   "excessive secretion of adrenocortical hormones corticosteroids androgens " +
   "and or aldosterone", 
   LR.endocrineDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.adrenalSysSt, 
   LR.none
);
cushingSyndromeDis.setPrintName("Cushing Syndrome");
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
cushingSyndromeDis.addCausingAbnormalCondition(LR.leftVentricularDysfunction);
cushingSyndromeDis.addCausesDisease(LR.hypertension);
cushingSyndromeDis.addCausesDisease(LR.diabetesMellitusSuper);
cushingSyndromeDis.addCausesAbnormalCondition(LR.glycosuria);
cushingSyndromeDis.addCausesAbnormalCondition(LR.hypercalciuria); 
cushingSyndromeDis.addCausesAbnormalCondition(LR.hyperglycemia);
cushingSyndromeDis.addReference("pp 838-41");
Treatment cushingSyndromeTr1  = new Treatment("cushingSyndromeTr1");
cushingSyndromeTr1.addTreatmentAction(LR.radiationTherapy);
cushingSyndromeTr1.addTreatmentAction(LR.surgery);
cushingSyndromeTr1.addDrug(LR.aminoglutethimide);
cushingSyndromeTr1.addDrug(LR.ketoconazole);
cushingSyndromeDis.addTreatment(cushingSyndromeTr1.getName());


// -------------- diabetes --------------
// (C) OntoOO Inc Sat Feb 23 09:30:05 PST 2002
Disease diabetesDis = new Disease(
   LR.diabetes, 
   "a family of diseases defined by increased urine production", 
   LR.endocrineDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.endocrineSysSt, 
   LR.none
);
diabetesDis.addSymptom(LR.polydipsia);
diabetesDis.addSymptom(LR.polyuria);
diabetesDis.addReference("Webster");


// -------------- diabetesInsidipus --------------
// (C) OntoOO Inc Wed Mar 10 17:22:46 PST 2004
Disease diabetesInsidipusDis = new Disease(
   LR.diabetesInsidipus, 
   "disturbed water metabolism", 
   LR.endocrineDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.endocrineSysSt, 
   LR.none
);
diabetesInsidipusDis.setPrintName("diabetes insidipus");
diabetesInsidipusDis.setSuperDisease(LR.diabetes);
diabetesInsidipusDis.addSymptom(LR.constipation, "", 0.4f);
diabetesInsidipusDis.addSymptom(LR.dehydration, "", 0.4f);
diabetesInsidipusDis.addSymptom(LR.dizziness, "", 0.4f);
diabetesInsidipusDis.addSymptom(LR.fatigue, "if extreme", 0.1f);
diabetesInsidipusDis.addSymptom(LR.hypotension, "", 0.4f);
diabetesInsidipusDis.addSymptom(LR.mucousMembranesDry, "", 0.4f);
diabetesInsidipusDis.addSymptom(LR.muscleWeakness, "", 0.4f);
diabetesInsidipusDis.addSymptom(LR.nocturia, "", 0.3f);
diabetesInsidipusDis.addSymptom(LR.thirstExcessive);
diabetesInsidipusDis.addInternalCause(LR.sarcoidosisCNS);
diabetesInsidipusDis.addReference("pp 818-20");
Treatment diabetesInsidipusTr1 = new Treatment("diabetesInsidipusTr1");
diabetesInsidipusTr1.addTreatmentAction(LR.fluidIncrease);
diabetesInsidipusTr1.addDrug(LR.vasopressin);
diabetesInsidipusDis.addTreatment("diabetesInsidipusTr1");


// -------------- diabetesMellitusSuper --------------
// (C) OntoOO Inc Sat Feb 23 09:43:38 PST 2002
Disease diabetesMellitusSuperDis = new Disease(
   LR.diabetesMellitusSuper, 
   "insuline deficiency causing disturbances in carbohydrate, protein and fat metabolism", 
   LR.endocrineDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.endocrineSysSt, 
   LR.none
);
diabetesMellitusSuperDis.setPrintName("diabetes mellitus super");
diabetesMellitusSuperDis.setSuperDisease(LR.diabetes);
diabetesMellitusSuperDis.addSymptom(LR.bingeEating); 
diabetesMellitusSuperDis.addSymptom(LR.dehydration); 
diabetesMellitusSuperDis.addSymptom(LR.fatigue); 
diabetesMellitusSuperDis.addSymptom(LR.mucousMembranesDry); 
diabetesMellitusSuperDis.addSymptom(LR.skinElasticityLoss); 
diabetesMellitusSuperDis.addInternalCause(LR.cushingSyndrome);
diabetesMellitusSuperDis.addCausesAbnormalCondition(LR.hyperglycemia); 
diabetesMellitusSuperDis.addReference("pp 849-53");
Treatment diabetesMellitusSuperTr1 = new Treatment("diabetesMellitusSuperTr1");
diabetesMellitusSuperTr1.addTreatmentAction(LR.diet);
diabetesMellitusSuperTr1.addTreatmentAction(LR.exercise);
diabetesMellitusSuperTr1.addDrug(LR.insulin);
diabetesMellitusSuperDis.addTreatment(diabetesMellitusSuperTr1.getName()); 
diabetesMellitusSuperDis.setCode358(159);
diabetesMellitusSuperDis.setICD10code("E10");


// -------------- diabetesMellitus --------------
// (C) OntoOO Inc Sat Feb 23 09:43:38 PST 2002
Disease diabetesMellitusDis = new Disease(
   LR.diabetesMellitus, 
   "insuline deficiency causing disturbances in carbohydrate, protein and fat metabolism", 
   LR.endocrineDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.endocrineSysSt, 
   LR.none
);
diabetesMellitusDis.setPrintName("diabetes mellitus");
diabetesMellitusDis.setSuperDisease(LR.diabetesMellitusSuper);
diabetesMellitusDis.addSymptom(LR.nocturia);
diabetesMellitusDis.addSymptom(LR.weightLoss); 
diabetesMellitusDis.addInternalCause(LR.obesity);
diabetesMellitusDis.addCausesDisease(LR.diabetesMellitusAdvanced); 
diabetesMellitusDis.addReference("pp 849-53");
diabetesMellitusDis.setCode358(159);
diabetesMellitusDis.setICD10code("E10");


// -------------- diabetesMellitus2 --------------
// (C) OntoOO Inc Sat Feb 23 09:43:38 PST 2002
Disease diabetesMellitus2Dis = new Disease(
   LR.diabetesMellitus2, 
   "insuline deficiency causing disturbances in carbohydrate, protein and fat metabolism", 
   LR.endocrineDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.endocrineSysSt, 
   LR.none
);
diabetesMellitus2Dis.setPrintName("diabetes mellitus2");
diabetesMellitus2Dis.setSuperDisease(LR.diabetesMellitusSuper);
diabetesMellitus2Dis.addSymptom(LR.nocturia);
diabetesMellitus2Dis.addSymptom(LR.overweight); 
diabetesMellitus2Dis.addCausesDisease(LR.diabetesMellitusAdvanced); 
diabetesMellitus2Dis.addReference("pp 849-5");
diabetesMellitus2Dis.setCode358(159);
diabetesMellitus2Dis.setICD10code("E10");


// -------------- diabetesMellitusAdvanced --------------
// (C) OntoOO Inc Wed Apr 24 16:48:52 PDT 2002
Disease diabetesMellitusAdvancedDis = new Disease(
   LR.diabetesMellitusAdvanced, 
   "insuline deficiency long term effects", 
   LR.endocrineDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   17, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.endocrineSysSt, 
   LR.none
);
diabetesMellitusAdvancedDis.setPrintName("diabetes mellitus advanced");
diabetesMellitusAdvancedDis.setSuperDisease(LR.diabetesMellitusSuper);
diabetesMellitusAdvancedDis.addSymptom(LR.diarrheaNocturnal);
// diabetesMellitusAdvancedDis.addSymptom(LR.erectionFailure);
diabetesMellitusAdvancedDis.addSymptom(LR.feetNumbness, "", 0.4f);
diabetesMellitusAdvancedDis.addSymptom(LR.feetPain, "", 0.4f);
diabetesMellitusAdvancedDis.addSymptom(LR.gastroparesis);
diabetesMellitusAdvancedDis.addSymptom(LR.handNumbness, "", 0.4f);
diabetesMellitusAdvancedDis.addSymptom(LR.handPain, "", 0.4f);
diabetesMellitusAdvancedDis.addSymptom(LR.skinInfection);
// diabetesMellitusAdvancedDis.addSymptom(LR.vaginitis);
// diabetesMellitusAdvancedDis.addCausesDisease(LR.diabetesRetinopathy); 
diabetesMellitusAdvancedDis.addInternalCause(LR.diabetesMellitus);
diabetesMellitusAdvancedDis.addInternalCause(LR.diabetesMellitus2);
diabetesMellitusAdvancedDis.addCausesDisease(LR.vulvovaginitis);
diabetesMellitusAdvancedDis.addCausesDisease(LR.vascularRetinopathy);
diabetesMellitusAdvancedDis.addCausesDisease(LR.nephroticSyndrome);
diabetesMellitusAdvancedDis.addCausesDisease(LR.urinaryTractInfection); 
diabetesMellitusAdvancedDis.addCausesAbnormalCondition(LR.atherosclerosis);
diabetesMellitusAdvancedDis.addReference("pp 849-53");
diabetesMellitusAdvancedDis.setCode358(159);
diabetesMellitusAdvancedDis.setICD10code("E10");


// -------------- hyperaldosteronism --------------
// (C) OntoOO Inc Sun Dec 15 20:55:34 PST 2002
Disease hyperaldosteronismDis = new Disease(
   LR.hyperaldosteronism, 
   "excessive secretion of mineralocorticoid aldosterone by the adrenal cortex", 
   LR.endocrineDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   50,
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.adrenalSysSt, 
   LR.none
);
hyperaldosteronismDis.addSymptom(LR.fatigue, "", 1.0f);
hyperaldosteronismDis.addSymptom(LR.headache, "", 1.0f);
hyperaldosteronismDis.addSymptom(LR.paresthesia, "", 1.0f);
hyperaldosteronismDis.addSymptom(LR.muscleWeakness, "", 1.0f);
hyperaldosteronismDis.addSymptom(LR.paralysisTransient, "", 1.0f);
hyperaldosteronismDis.addSymptom(LR.tetany, "", 0.6f);
hyperaldosteronismDis.addSymptom(LR.ocularDisturbance, "", 0.4f);
hyperaldosteronismDis.addCausesDisease(LR.hypertension);
hyperaldosteronismDis.addReference("pp 841-3");
Treatment hyperaldosteronismTr1 = new Treatment("hyperaldosteronismTr1");
hyperaldosteronismTr1.addTreatmentAction(LR.sodiumRestriction);
hyperaldosteronismDis.addTreatment("hyperaldosteronismTr1");


// -------------- hyperthyroidism --------------
// (C) OntoOO Inc Thu Jan 31 16:58:55 PST 2002
Disease hyperthyroidismDis = new Disease(
   LR.hyperthyroidism, 
   "metabolic imbalance due to overproduction of the thyroid hormone", 
   LR.endocrineDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.thyroidSysSt, 
   LR.none
);
hyperthyroidismDis.setGenetic("1parent");
hyperthyroidismDis.setParentDisease(LR.hyperthyroidism);
hyperthyroidismDis.addSymptom(LR.goiter);
hyperthyroidismDis.addSymptom(LR.exophthalmos, "", 0.8f);
hyperthyroidismDis.addSymptom(LR.diarrhea);
hyperthyroidismDis.addSymptom(LR.nervousness);
hyperthyroidismDis.addSymptom(LR.palpitations);
hyperthyroidismDis.addSymptom(LR.sweating);
hyperthyroidismDis.addSymptom(LR.tremors);
hyperthyroidismDis.addSymptom(LR.weightLoss);
hyperthyroidismDis.addReference("pp 826-30");
hyperthyroidismDis.setMiscComments("most often between 30 and 40");
Treatment hyperthyroidismTr1 = new Treatment("hyperthyroidismTr1");
hyperthyroidismTr1.addTreatmentAction(LR.surgery);
hyperthyroidismTr1.addTreatmentAction(LR.radioactiveIodine);
hyperthyroidismTr1.addDrug(LR.antithyroid);
hyperthyroidismDis.addTreatment(hyperthyroidismTr1.getName()); 


// -------------- hypothyroidismSuper --------------
// (C) OntoOO Inc Thu Jan 31 17:05:01 PST 2002
Disease hypothyroidismSuperDis = new Disease(
   LR.hypothyroidismSuper, 
   "metabolic imbalance due to underproduction of the thyroid, hypothalamic or pituitary", 
   LR.endocrineDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   16, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.thyroidSysSt, 
   LR.none
);
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
hypothyroidismSuperDis.addReference("pp 820-2");
hypothyroidismSuperDis.setMiscComments("incidence is rising in the 40-50 age range");
Treatment hypothyroidismSuperTr1  = new Treatment("hypothyroidismSuperTr1");
hypothyroidismSuperTr1.addDrug(LR.levothyroxine);
hypothyroidismSuperDis.addTreatment(hypothyroidismSuperTr1.getName());


// -------------- hypothyroidism --------------
// (C) OntoOO Inc Thu Jan 31 17:05:01 PST 2002
Disease hypothyroidismDis = new Disease(
   LR.hypothyroidism, 
   "metabolic imbalance due to underproduction of the thyroid, hypothalamic or pituitary", 
   LR.endocrineDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   16, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.thyroidSysSt, 
   LR.none
);
hypothyroidismDis.setSuperDisease(LR.hypothyroidismSuper);
hypothyroidismDis.addCausesDisease(LR.hypothyroidismCardio);
hypothyroidismDis.addReference("pp 820-2");
hypothyroidismDis.setMiscComments("incidence is rising in the 40-50 age range");


// -------------- hypothyroidismCardio --------------
// (C) OntoOO Inc Fri May 21 14:58:08 PDT 2004
Disease hypothyroidismCardioDis = new Disease(
   LR.hypothyroidismCardio, 
   "metabolic imbalance due to underproduction of the thyroid, " +
   "hypothalamic or pituitary impacting the heart", 
   LR.endocrineDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   16, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.thyroidSysSt, 
   LR.none
);
hypothyroidismCardioDis.setPrintName("hypothyroidism with cardio impact");
hypothyroidismCardioDis.setSuperDisease(LR.hypothyroidismSuper);
hypothyroidismCardioDis.addSymptom(LR.coldIntolerance, "", 1.0f);
hypothyroidismCardioDis.addSymptom(LR.constipation, "", 1.0f);
hypothyroidismCardioDis.addSymptom(LR.eyelidDroop, "", 1.0f);
hypothyroidismCardioDis.addSymptom(LR.faceEdema, "", 1.0f);
hypothyroidismCardioDis.addSymptom(LR.fatigue, "", 1.0f);
hypothyroidismCardioDis.addSymptom(LR.forgetfulness, "", 1.0f);
hypothyroidismCardioDis.addSymptom(LR.hairLoss, "", 1.0f);
hypothyroidismCardioDis.addSymptom(LR.hoarseness, "", 1.0f);
hypothyroidismCardioDis.addSymptom(LR.mentalInstability, "", 1.0f);
hypothyroidismCardioDis.addSymptom(LR.nailBrittle, "", 1.0f);
hypothyroidismCardioDis.addSymptom(LR.skinDry, "", 1.0f);
hypothyroidismCardioDis.addSymptom(LR.skinElasticityLoss, "", 1.0f);
hypothyroidismCardioDis.addSymptom(LR.weightGain, "", 1.0f);
hypothyroidismCardioDis.addSymptom(LR.abdomenDistension);
hypothyroidismCardioDis.addSymptom(LR.anorexia);
hypothyroidismCardioDis.addSymptom(LR.ataxia);
hypothyroidismCardioDis.addSymptom(LR.libidoLoss);
hypothyroidismCardioDis.addSymptom(LR.pulseWeak);
hypothyroidismCardioDis.addInternalCause(LR.hypothyroidism);
hypothyroidismCardioDis.addReference("pp 820-2");
hypothyroidismCardioDis.setMiscComments("incidence is rising in the 40-50 age range");


// -------------- pheochromocytoma --------------
// (C) OntoOO Inc Sun Dec 15 16:37:28 PST 2002
// (C) OntoOO Inc Sat Aug 21 13:46:05 GMT-08:00 2004
Disease pheochromocytomaDis = new Disease(
   LR.pheochromocytoma, 
   "tumor that causes an excess of  ephrine, resulting in hypertension, " +
   "increased metabolism and hyperglycemia", 
   LR.endocrineDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   40,
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.adrenalSysSt, 
   LR.none
);
pheochromocytomaDis.setGenetic("1parent");
pheochromocytomaDis.setParentDisease(LR.pheochromocytoma);
pheochromocytomaDis.addSymptom(LR.abdomenPain, "", 1.0f);
pheochromocytomaDis.addSymptom(LR.diaphoresis, "", 1.0f);
pheochromocytomaDis.addSymptom(LR.doomFeeling, "", 1.0f);
pheochromocytomaDis.addSymptom(LR.flushing, "", 1.0f);
pheochromocytomaDis.addSymptom(LR.headache, "", 1.0f);
pheochromocytomaDis.addSymptom(LR.nausea, "", 1.0f);
pheochromocytomaDis.addSymptom(LR.nervousness, "", 1.0f);
pheochromocytomaDis.addSymptom(LR.pallor, "", 1.0f);
pheochromocytomaDis.addSymptom(LR.palpitations, "", 1.0f);
pheochromocytomaDis.addSymptom(LR.tachycardia, "", 1.0f);
pheochromocytomaDis.addSymptom(LR.tachypnea, "", 1.0f);
pheochromocytomaDis.addSymptom(LR.trembling, "", 1.0f);
pheochromocytomaDis.addSymptom(LR.vomiting, "", 1.0f);
pheochromocytomaDis.addCausesDisease(LR.hypertension);
pheochromocytomaDis.addCausesAbnormalCondition(LR.hyperglycemia);
pheochromocytomaDis.addReference("pp 846-8");
Treatment pheochromocytomaTr1  = new Treatment("pheochromocytomaTr1");
pheochromocytomaTr1.addTreatmentAction(LR.surgery);
pheochromocytomaDis.addTreatment(pheochromocytomaTr1.getName());


  } // end doit()
} // end InitEndocrineDiseases
