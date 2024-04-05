// (C) OntoOO Dennis de Champeaux 2000, 2012
package init;

import com.LR;
import concepts.*;

public class InitMetabolicDiseases {
  public static void doit() {

    // ------------------ diabetesKetoacidosis -----------------------
// (C) OntoOO Inc Sat Nov 03 10:37:47 PST 2001
Disease diabetesKetoacidosisDis = new Disease(
   LR.diabetesKetoacidosis, 
   "accumulation of ketones due to severely depressed insulin levels", 
   LR.metabolicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.metabolicSysSt, 
   LR.none
);
diabetesKetoacidosisDis.setPrintName("diabetes ketoacidosis");
diabetesKetoacidosisDis.addSymptom(LR.breathAcetone, "", 1.0f); 
diabetesKetoacidosisDis.addSymptom(LR.consciousnessDecreased, "", 1.0f); 
diabetesKetoacidosisDis.addSymptom(LR.dehydration, "", 1.0f); 
diabetesKetoacidosisDis.addSymptom(LR.mucousMembranesDry, "", 1.0f); 
diabetesKetoacidosisDis.addSymptom(LR.nausea, "", 1.0f); 
diabetesKetoacidosisDis.addSymptom(LR.pulseThready, "", 1.0f); 
diabetesKetoacidosisDis.addSymptom(LR.pulseWeak, "", 1.0f); 
diabetesKetoacidosisDis.addSymptom(LR.respirationKussmaul, "", 1.0f); 
diabetesKetoacidosisDis.addSymptom(LR.vomiting, "", 1.0f); 
diabetesKetoacidosisDis.addInternalCause(LR.diabetesInsidipus); 
diabetesKetoacidosisDis.addReference("pp 0; pp 906-8");
// diabetesKetoacidosisDis.setMiscComments("see metabolic acidosis (URL here!)");
Treatment diabetesKetoacidosisTr1  = new Treatment("diabetesKetoacidosisTr1");
diabetesKetoacidosisTr1.addTreatmentAction(LR.IVFluids);
diabetesKetoacidosisTr1.addDrug(LR.insulin);
diabetesKetoacidosisTr1.addDrug(LR.sodiumBicarbonate);
diabetesKetoacidosisDis.addTreatment(diabetesKetoacidosisTr1.getName());


    // ------------------ metabolicAcidosis -----------------------
// (C) OntoOO Inc Sun Jul 29 21:12:47 PDT 2001
Disease metabolicAcidosisDis = new Disease(
   LR.metabolicAcidosis, 
   "excess acid accumulation and deficient base bicarbonate " +
   "produced due to an underlying disorder", 
   LR.metabolicDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.metabolicSysSt, 
   LR.none
);
metabolicAcidosisDis.setPrintName("metabolic acidosis");
metabolicAcidosisDis.addSymptom(LR.drowsiness);
metabolicAcidosisDis.addSymptom(LR.headache);
metabolicAcidosisDis.addSymptom(LR.lethargy);
metabolicAcidosisDis.addSymptom(LR.stupor);
metabolicAcidosisDis.addInternalCause(LR.necrotizingEnterocolitis);
metabolicAcidosisDis.addCausesAbnormalCondition(LR.centralNervousSystemDepression);
metabolicAcidosisDis.addReference("pp 906-8");
Treatment metabolicAcidosisTr1 = new Treatment("metabolicAcidosisTr1");
metabolicAcidosisTr1.addDrug(LR.sodiumBicarbonate);
metabolicAcidosisDis.addTreatment(metabolicAcidosisTr1.getName()); 


// ------------------ metabolicAlkalosis -----------------------
// (C) OntoOO Inc Sun Jul 29 21:12:47 PDT 2001
// (C) OntoOO Inc Fri Aug 06 11:54:08 GMT-08:00 2004
Disease metabolicAlkalosisDis = new Disease(
   LR.metabolicAlkalosis, 
   "decreased amounts of acid accumulation and increased " +
   "base bicarbonate due to an underlying disorder", 
   LR.metabolicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.metabolicSysSt, 
   LR.none
);
metabolicAlkalosisDis.setPrintName("metabolic alkalosis");
metabolicAlkalosisDis.addSymptom(LR.confusion);
metabolicAlkalosisDis.addSymptom(LR.diarrhea);
metabolicAlkalosisDis.addSymptom(LR.hypoventilation);
metabolicAlkalosisDis.addSymptom(LR.irritability);
metabolicAlkalosisDis.addSymptom(LR.nausea);
metabolicAlkalosisDis.addSymptom(LR.twitching);
metabolicAlkalosisDis.addSymptom(LR.vomiting);
metabolicAlkalosisDis.addInternalCause(LR.hypokalemiaSuper);
metabolicAlkalosisDis.addReference("pp 908-9");
Treatment metabolicAlkalosisTr1  = new Treatment("metabolicAlkalosisTr1");
metabolicAlkalosisTr1.addDrug(LR.ammoniumChloride);
metabolicAlkalosisDis.addTreatment(metabolicAlkalosisTr1.getName());


    // ------------------ potassiumImbalance -----------------------
// (C) OntoOO Inc Thu Oct 25 21:22:28 PDT 2001
Disease potassiumImbalanceDis = new Disease(
   LR.potassiumImbalance, 
   "potassium is too low or too high ", 
   LR.metabolicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.muscleSysSt, 
   LR.none
);
potassiumImbalanceDis.setPrintName("potassium imbalance");
potassiumImbalanceDis.addSymptom(LR.muscleWeakness);
potassiumImbalanceDis.addReference("pp 892-894");


// -------------- hyponatremia --------------
// (C) OntoOO Inc Wed Jun 23 17:01:11 PDT 2004
Disease hyponatremiaDis = new Disease(
   LR.hyponatremia, 
   "too low sodium concentration in the body", 
   LR.metabolicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
hyponatremiaDis.addSymptom(LR.abdomenCramping, "", 1.0f);
hyponatremiaDis.addSymptom(LR.apathy, "", 1.0f);
hyponatremiaDis.addSymptom(LR.headache, "", 1.0f);
hyponatremiaDis.addSymptom(LR.hypotension, "", 1.0f);
hyponatremiaDis.addSymptom(LR.muscleWeakness, "", 1.0f);
hyponatremiaDis.addSymptom(LR.nausea, "", 1.0f);
hyponatremiaDis.addSymptom(LR.seizure, "", 1.0f);
hyponatremiaDis.addSymptom(LR.tachycardia, "", 1.0f);
hyponatremiaDis.addSymptom(LR.twitching, "", 1.0f);
hyponatremiaDis.addSymptom(LR.vomiting, "", 1.0f);
hyponatremiaDis.addSymptom(LR.skinClammy);
hyponatremiaDis.addSymptom(LR.skinCold);
hyponatremiaDis.addSymptom(LR.skinElasticityLoss);
hyponatremiaDis.addInternalCause(LR.cysticFibrosis);
hyponatremiaDis.addReference("pp 895-7");
Treatment hyponatremiaTr1  = new Treatment("hyponatremiaTr1");
hyponatremiaTr1.addTreatmentAction(LR.fluidRestriction);
hyponatremiaDis.addTreatment(hyponatremiaTr1.getName());


    // ------------------ hyperkalemia -----------------------
// (C) OntoOO Inc Thu Oct 25 21:25:10 PDT 2001
Disease hyperkalemiaDis = new Disease(
   LR.hyperkalemia, 
   "potassium excess", 
   LR.metabolicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.muscleSysSt, 
   LR.none
);
hyperkalemiaDis.setSuperDisease(LR.potassiumImbalance);
hyperkalemiaDis.addSymptom(LR.abdomenCramping, "", 1.0f);
hyperkalemiaDis.addSymptom(LR.anuria, "", 1.0f);
hyperkalemiaDis.addSymptom(LR.bradycardia, "later", 0.1f);
hyperkalemiaDis.addSymptom(LR.diarrhea, "", 1.0f);
hyperkalemiaDis.addSymptom(LR.nausea, "", 1.0f);
hyperkalemiaDis.addSymptom(LR.numbness, "", 1.0f);
hyperkalemiaDis.addSymptom(LR.oliguria, "", 1.0f);
hyperkalemiaDis.addSymptom(LR.paralysisTransient, "", 1.0f);
hyperkalemiaDis.addSymptom(LR.tachycardia, "", 1.0f);
hyperkalemiaDis.addSymptom(LR.tingling);
hyperkalemiaDis.addInternalCause(LR.tubularNecrosisAcute);
hyperkalemiaDis.addCausesAbnormalCondition(LR.acidosis);
hyperkalemiaDis.addReference("pp 892-4");
Treatment hyperkalemiaTr1 = new Treatment("hyperkalemiaTr1");
hyperkalemiaTr1.addDrug(LR.calciumGluconate);
hyperkalemiaDis.addTreatment("hyperkalemiaTr1");

// -------------- hypokalemiaSuper --------------
// (C) OntoOO Inc Mon Nov 19 19:45:36 PST 2001
Disease hypokalemiaSuperDis = new Disease(
   LR.hypokalemiaSuper, 
   "potassium deficiency", 
   LR.metabolicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.metabolicSysSt, 
   LR.none
);
hypokalemiaSuperDis.setPrintName("hypokalemia super");
hypokalemiaSuperDis.setSuperDisease(LR.potassiumImbalance);
hypokalemiaSuperDis.addSymptom(LR.abdomenDistension, "", 1.0f);
hypokalemiaSuperDis.addSymptom(LR.anorexia, "", 1.0f);
hypokalemiaSuperDis.addSymptom(LR.confusion, "", 1.0f);
hypokalemiaSuperDis.addSymptom(LR.diarrhea, "", 1.0f);
hypokalemiaSuperDis.addSymptom(LR.dizziness, "", 1.0f);
hypokalemiaSuperDis.addSymptom(LR.fatigue, "", 1.0f);
hypokalemiaSuperDis.addSymptom(LR.hypotension, "", 1.0f);
hypokalemiaSuperDis.addSymptom(LR.legCramps);
hypokalemiaSuperDis.addSymptom(LR.mentalDepression);
hypokalemiaSuperDis.addSymptom(LR.nausea, "", 1.0f);
hypokalemiaSuperDis.addSymptom(LR.reflexesDecreased, "", 1.0f);
hypokalemiaSuperDis.addSymptom(LR.polyuria);
hypokalemiaSuperDis.addSymptom(LR.respirationParalysis, "", 1.0f);
hypokalemiaSuperDis.addSymptom(LR.vomiting, "", 1.0f);

hypokalemiaSuperDis.addCausesDisease(LR.cardiacArrest);
hypokalemiaSuperDis.addCausesDisease(LR.metabolicAlkalosis);
hypokalemiaSuperDis.addReference("pp 893");

Treatment hypokalemiaSuperTr1 = new Treatment("hypokalemiaSuperTr1");
hypokalemiaSuperTr1.addTreatmentAction(LR.potassiumReplacement);
hypokalemiaSuperDis.addTreatment(hypokalemiaSuperTr1.getName()); 



// -------------- hypokalemia --------------
// (C) OntoOO Inc Mon Nov 19 19:45:36 PST 2001
Disease hypokalemiaDis = new Disease(
   LR.hypokalemia, 
   "potassium deficiency", 
   LR.metabolicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.metabolicSysSt, 
   LR.none
);
hypokalemiaDis.setPrintName("hypokalemia");
hypokalemiaDis.setSuperDisease(LR.hypokalemiaSuper);
hypokalemiaDis.addCausesDisease(LR.hypokalemiaSevere);
hypokalemiaDis.addReference("pp 893");


// -------------- hypokalemiaSevere --------------
// (C) OntoOO Inc Mon Nov 19 21:40:12 PST 2001
Disease hypokalemiaSevereDis = new Disease(
   LR.hypokalemiaSevere, 
   "severe potassium deficiency", 
   LR.metabolicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.metabolicSysSt, 
   LR.none
);
hypokalemiaSevereDis.setPrintName("hypokalemia severe");
hypokalemiaSevereDis.setSuperDisease(LR.hypokalemiaSuper);
hypokalemiaSevereDis.addInternalCause(LR.hypokalemia);
hypokalemiaSevereDis.addReference("pp 893");
Treatment hypokalemiaSevereTr1  = new Treatment("hypokalemiaSevereTr1");
hypokalemiaSevereTr1.addTreatmentAction(LR.CPR);
hypokalemiaSevereTr1.addTreatmentAction(LR.mechanicalVentilation);
hypokalemiaSevereDis.addTreatment(hypokalemiaSevereTr1.getName());


// -------------- hypochloremia --------------
// (C) OntoOO Inc Mon Feb 23 18:18:56 PST 2004
Disease hypochloremiaDis = new Disease(
   LR.hypochloremia, 
   "too low chloride concentration in the body", 
   LR.metabolicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
hypochloremiaDis.addSymptom(LR.headache);
hypochloremiaDis.addSymptom(LR.nausea);
hypochloremiaDis.addSymptom(LR.weakness);
hypochloremiaDis.addInternalCause(LR.cysticFibrosis);
hypochloremiaDis.addReference("pp 900-2");
Treatment hypochloremiaTr1  = new Treatment("hypochloremiaTr1");
hypochloremiaTr1.addTreatmentAction(LR.saltyBroth);
hypochloremiaDis.addTreatment(hypochloremiaTr1.getName());


// -------------- hypochloremia1 --------------
// (C) OntoOO Inc Mon Jun 21 15:59:20 PDT 2004
Disease hypochloremia1Dis = new Disease(
   LR.hypochloremia1, 
   "too low chloride concentration in the body due to hyponatremia", 
   LR.metabolicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
hypochloremia1Dis.setSuperDisease(LR.hypochloremia);
hypochloremia1Dis.addSymptom(LR.muscleWeakness);
hypochloremia1Dis.addSymptom(LR.twitching);
hypochloremia1Dis.addInternalCause(LR.hyponatremia);
hypochloremia1Dis.addReference("pp 900-2");


// -------------- hypochloremia2 --------------
// (C) OntoOO Inc Mon Jun 21 17:10:08 PDT 2004
Disease hypochloremia2Dis = new Disease(
   LR.hypochloremia2, 
   "too low chloride concentration in the body due to metabolic alkalosis", 
   LR.metabolicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
hypochloremia2Dis.setSuperDisease(LR.hypochloremia);
hypochloremia2Dis.addSymptom(LR.muscleHypertonicity);
hypochloremia2Dis.addSymptom(LR.tetany);
hypochloremia2Dis.addSymptom(LR.respirationShallow);
hypochloremia2Dis.addInternalCause(LR.metabolicAlkalosis);
hypochloremia2Dis.addReference("pp 900-2");


// -------------- syndromeOfInappropriateAntidiureticHormoneSecretion --------------
// -------------- SIADH --------------
// (C) OntoOO Inc Fri Dec 07 14:29:23 PST 2001
Disease syndromeOfInappropriateAntidiureticHormoneSecretionDis = new Disease(
   LR.syndromeOfInappropriateAntidiureticHormoneSecretion, 
   "excessive release of antidiuretic hormone", 
   LR.metabolicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.metabolicSysSt, 
   LR.none
);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.setPrintName(
    "syndrome of inappropriate antidiuretic hormone secretion");
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addSymptom(LR.anorexia);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addSymptom(LR.coma);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addSymptom(LR.nausea);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addSymptom(LR.restlessness);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addSymptom(LR.seizure);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addSymptom(LR.vomiting);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addSymptom(LR.weakness);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addSymptom(LR.weightGain);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addReference("pp 905-6");
Treatment syndromeOfInappropriateAntidiureticHormoneSecretionTr1 = 
     new Treatment("syndromeOfInappropriateAntidiureticHormoneSecretionTr1");
syndromeOfInappropriateAntidiureticHormoneSecretionTr1.addTreatmentAction(
     LR.fluidRestriction);
syndromeOfInappropriateAntidiureticHormoneSecretionTr1.addDrug(LR.lithium);
syndromeOfInappropriateAntidiureticHormoneSecretionTr1.addDrug(LR.demeclocycline);
syndromeOfInappropriateAntidiureticHormoneSecretionDis.addTreatment(
     syndromeOfInappropriateAntidiureticHormoneSecretionTr1.getName());


// -------------- vitaminCDeficiency --------------
// (C) OntoOO Inc Sat Feb 01 17:39:45 PST 2003
// (C) OntoOO Inc Fri Oct 08 14:33:27 GMT-08:00 2004
Disease vitaminCDeficiencyDis = new Disease(
   LR.vitaminCDeficiency, 
   "insufficient vitamin C intake", 
   LR.metabolicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
vitaminCDeficiencyDis.setPrintName("vitamin C deficiency");
vitaminCDeficiencyDis.addSymptom(LR.anorexia, "", 1.0f);
vitaminCDeficiencyDis.addSymptom(LR.ecchymoses, "", 1.0f);
vitaminCDeficiencyDis.addSymptom(LR.gumsSwollen, "", 1.0f);
vitaminCDeficiencyDis.addSymptom(LR.jointPain, "", 1.0f);
vitaminCDeficiencyDis.addSymptom(LR.pallor, "", 1.0f);
vitaminCDeficiencyDis.addSymptom(LR.petechiae, "", 1.0f);
vitaminCDeficiencyDis.addSymptom(LR.weakness, "", 1.0f);
vitaminCDeficiencyDis.addSymptom(LR.lethargy);
vitaminCDeficiencyDis.addSymptom(LR.sleepDisturbed);
vitaminCDeficiencyDis.addSymptom(LR.teethLoose);
vitaminCDeficiencyDis.addCausesDisease(LR.anemia);
vitaminCDeficiencyDis.addReference("pp 866-8");
Treatment vitaminCDeficiencyTr1  = new Treatment("vitaminCDeficiencyTr1");
vitaminCDeficiencyTr1.addDrug(LR.vitaminC);
vitaminCDeficiencyDis.addTreatment(vitaminCDeficiencyTr1.getName());


// -------------- vitaminDDeficiency --------------
// (C) OntoOO Inc Wed Feb 18 16:52:33 PST 2004
// (C) OntoOO Inc Mon Oct 11 14:35:20 GMT-08:00 2004
Disease vitaminDDeficiencyDis = new Disease(
   LR.vitaminDDeficiency, 
   "insufficient vitamin D intake", 
   LR.metabolicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
vitaminDDeficiencyDis.setPrintName("vitamin D deficiency");
vitaminDDeficiencyDis.addSymptom(LR.irritability);
vitaminDDeficiencyDis.addSymptom(LR.restlessness);
vitaminDDeficiencyDis.addSymptom(LR.sweating);
vitaminDDeficiencyDis.addInternalCause(LR.celiacDisease);
vitaminDDeficiencyDis.addReference("pp 868-9");
Treatment vitaminDDeficiencyTr1  = new Treatment("vitaminDDeficiencyTr1");
vitaminDDeficiencyTr1.addDrug(LR.vitaminD);
vitaminDDeficiencyDis.addTreatment(vitaminDDeficiencyTr1.getName());


// -------------- vitaminKDeficiency --------------
// (C) OntoOO Inc Sat Feb 01 17:39:45 PST 2003
// (C) OntoOO Inc Mon Oct 11 15:14:42 GMT-08:00 2004
Disease vitaminKDeficiencyDis = new Disease(
   LR.vitaminKDeficiency, 
   "insufficient vitamin K intake", 
   LR.metabolicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
vitaminKDeficiencyDis.setPrintName("vitamin K deficiency");
vitaminKDeficiencyDis.addSymptom(LR.bleedingAbnormal);
vitaminKDeficiencyDis.addSymptom(LR.bleedingFromNose);
vitaminKDeficiencyDis.addSymptom(LR.bruising);
vitaminKDeficiencyDis.addSymptom(LR.gumsBleeding);

vitaminKDeficiencyDis.addReference("pp 870-1");
Treatment vitaminKDeficiencyTr1  = new Treatment("vitaminKDeficiencyTr1");
vitaminKDeficiencyTr1.addDrug(LR.vitaminK);
vitaminKDeficiencyDis.addTreatment(vitaminKDeficiencyTr1.getName());


  } // end of doit
} // end InitMetabolicDiseases
