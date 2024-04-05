// (C) OntoOO Inc 2000
package init;

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

public class InitRenalDiseases {
  public static void doit() {

// -------------- benignProstaticHyperplasia --------------
// (C) OntoOO Inc Sun Apr 13 16:28:01 PDT 2003
Disease benignProstaticHyperplasiaDis = new Disease(
   LR.benignProstaticHyperplasia, 
   "prostate gland enlargement compressing the urethra causing urinary obstruction", 
   LR.urologicDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   50, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.prostateSysSt, 
   LR.none
);
benignProstaticHyperplasiaDis.setPrintName("benign prostatic hyperplasia");
benignProstaticHyperplasiaDis.addReference("pp 804-6");
Treatment benignProstaticHyperplasiaTr1 = new Treatment("benignProstaticHyperplasiaTr1");
benignProstaticHyperplasiaTr1.addTreatmentAction(LR.fluidRestriction);
benignProstaticHyperplasiaTr1.addTreatmentAction(LR.massage);
benignProstaticHyperplasiaTr1.addTreatmentAction(LR.sitzBath);
benignProstaticHyperplasiaTr1.addTreatmentAction(LR.regularEjaculation);
benignProstaticHyperplasiaDis.addTreatment("benignProstaticHyperplasiaTr1");
Treatment benignProstaticHyperplasiaTr2  = new Treatment("benignProstaticHyperplasiaTr2", LR.ifInfection);
benignProstaticHyperplasiaTr2.addDrug(LR.antimicrobials);
benignProstaticHyperplasiaDis.addTreatment(benignProstaticHyperplasiaTr2.getName());
Treatment benignProstaticHyperplasiaTr3 = new Treatment("benignProstaticHyperplasiaTr3");
benignProstaticHyperplasiaTr3.addDrug(LR.prazosin);
benignProstaticHyperplasiaTr3.addDrug(LR.terazosin);
benignProstaticHyperplasiaDis.addTreatment("benignProstaticHyperplasiaTr3");
Treatment benignProstaticHyperplasiaTr4 = new Treatment("benignProstaticHyperplasiaTr4");
benignProstaticHyperplasiaTr4.addDrug(LR.finasteride);
benignProstaticHyperplasiaDis.addTreatment("benignProstaticHyperplasiaTr4");


// -------------- benignProstaticHyperplasia1 --------------
// (C) OntoOO Inc Mon Apr 14 12:13:41 PDT 2003
Disease benignProstaticHyperplasia1Dis = new Disease(
   LR.benignProstaticHyperplasia1, 
   "prostate gland enlargement compressing the urethra causing mild urinary obstruction", 
   LR.urologicDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   50, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.prostateSysSt, 
   LR.none
);
benignProstaticHyperplasia1Dis.setPrintName("benign prostatic hyperplasia 1");
benignProstaticHyperplasia1Dis.setSuperDisease(LR.benignProstaticHyperplasia);
benignProstaticHyperplasia1Dis.addSymptom(LR.urinaryHesitancy, "", 1.0f);
benignProstaticHyperplasia1Dis.addSymptom(LR.urinaryStreamInterrupted, "", 1.0f);
benignProstaticHyperplasia1Dis.addSymptom(LR.urinaryStreamReduced, "", 1.0f);
benignProstaticHyperplasia1Dis.addSymptom(LR.urinationStartDifficult, "", 1.0f);
benignProstaticHyperplasia1Dis.addCausesDisease(LR.benignProstaticHyperplasia2);
benignProstaticHyperplasia1Dis.addReference("pp 804-6");


// -------------- benignProstaticHyperplasia2 --------------
// (C) OntoOO Inc Mon Apr 14 12:20:10 PDT 2003
Disease benignProstaticHyperplasia2Dis = new Disease(
   LR.benignProstaticHyperplasia2, 
   "prostate gland enlargement compressing the urethra causing severe urinary obstruction", 
   LR.urologicDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   50, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.prostateSysSt, 
   LR.none
);
benignProstaticHyperplasia2Dis.setPrintName("benign prostatic hyperplasia 2");
benignProstaticHyperplasia2Dis.setSuperDisease(LR.benignProstaticHyperplasia);
benignProstaticHyperplasia2Dis.addSymptom(LR.urinaryHesitancy, "", 1.0f);
benignProstaticHyperplasia2Dis.addSymptom(LR.urinaryStreamInterrupted, "", 1.0f);
benignProstaticHyperplasia2Dis.addSymptom(LR.urinaryStreamReduced, "", 1.0f);
benignProstaticHyperplasia2Dis.addSymptom(LR.urinationStartDifficult, "", 1.0f);
benignProstaticHyperplasia2Dis.addSymptom(LR.hematuria, "", 1.0f);
benignProstaticHyperplasia2Dis.addSymptom(LR.nocturia, "", 1.0f);
benignProstaticHyperplasia2Dis.addSymptom(LR.urinaryFrequency, "", 1.0f);
benignProstaticHyperplasia2Dis.addSymptom(LR.incontinence);
benignProstaticHyperplasia2Dis.addInternalCause(LR.benignProstaticHyperplasia1);
benignProstaticHyperplasia2Dis.addCausesDisease(LR.anemia);
benignProstaticHyperplasia2Dis.addCausesAbnormalCondition(LR.infectionsSevere);
benignProstaticHyperplasia2Dis.addCausesAbnormalCondition(LR.shock); 
benignProstaticHyperplasia2Dis.addReference("pp 804-6");
Treatment benignProstaticHyperplasia2Tr3 = 
   new Treatment("benignProstaticHyperplasia2Tr3", LR.ifAcuteUrinaryBlockage);
benignProstaticHyperplasia2Tr3.addTreatmentAction(LR.surgery);
benignProstaticHyperplasia2Dis.addTreatment("benignProstaticHyperplasia2Tr3");


// -------------- prostatitis --------------
// (C) OntoOO Inc Mon Apr 14 18:02:43 PDT 2003
Disease prostatitisDis = new Disease(
   LR.prostatitis, 
   "inflammation of the prostate gland", 
   LR.urologicDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.prostateSysSt, 
   LR.klebsiellaInfection
);
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
Treatment prostatitisTr2  = new Treatment("prostatitisTr2");
prostatitisTr2.addTreatmentAction(LR.massage);
prostatitisTr2.addTreatmentAction(LR.regularEjaculation);
prostatitisDis.addTreatment(prostatitisTr2.getName());
Treatment prostatitisTr3 = new Treatment("prostatitisTr3", LR.ifSevere);
prostatitisTr3.addTreatmentAction(LR.surgery);
prostatitisDis.addTreatment(prostatitisTr3.getName()); 


// -------------- prostatitisAcute --------------
// (C) OntoOO Inc Mon Apr 14 18:30:38 PDT 2003
Disease prostatitisAcuteDis = new Disease(
   LR.prostatitisAcute, 
   "acute inflammation of the prostate gland", 
   LR.urologicDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.prostateSysSt, 
   LR.none
);
prostatitisAcuteDis.setPrintName("prostatitis acute");
prostatitisAcuteDis.setSuperDisease(LR.prostatitis);
prostatitisAcuteDis.setTemperature((float)102.0);
prostatitisAcuteDis.addSymptom(LR.arthralgia, "", 1.0f);
prostatitisAcuteDis.addSymptom(LR.chills, "", 1.0f);
prostatitisAcuteDis.addSymptom(LR.dysuria, "", 0.3f);
prostatitisAcuteDis.addSymptom(LR.lowBackPain, "", 1.0f);
prostatitisAcuteDis.addSymptom(LR.myalgia, "", 1.0f);
prostatitisAcuteDis.addSymptom(LR.nocturia, "", 0.3f);
prostatitisAcuteDis.addSymptom(LR.urinaryFrequency, "", 1.0f); 
prostatitisAcuteDis.addSymptom(LR.urineCloudy, "", 0.1f); 
prostatitisAcuteDis.addCausesDisease(LR.prostatitisChronic);
prostatitisAcuteDis.addCausesAbnormalCondition(LR.prostateFirm);
prostatitisAcuteDis.addCausesAbnormalCondition(LR.prostateSwollen);
prostatitisAcuteDis.addCausesAbnormalCondition(LR.prostateTender);
prostatitisAcuteDis.addReference("pp 802-3");
Treatment prostatitisAcuteTr1  = new Treatment("prostatitisAcuteTr1");
prostatitisAcuteTr1.addDrug(LR.antibiotics);
prostatitisAcuteDis.addTreatment(prostatitisAcuteTr1.getName());


// -------------- prostatitisChronic --------------
// (C) OntoOO Inc Tue Apr 15 18:34:03 PDT 2003
Disease prostatitisChronicDis = new Disease(
   LR.prostatitisChronic, 
   "chronic inflammation of the prostate gland", 
   LR.urologicDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.prostateSysSt, 
   LR.none
);
prostatitisChronicDis.setPrintName("prostatitis chronic");
prostatitisChronicDis.setSuperDisease(LR.prostatitis);
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
prostatitisChronicDis.addInternalCause(LR.prostatitisAcute);
prostatitisChronicDis.addReference("pp 802-3");
Treatment prostatitisChronicTr1 = new Treatment("prostatitisChronicTr1");
prostatitisChronicTr1.addDrug(LR.coTrimoxazole);
prostatitisChronicDis.addTreatment("prostatitisChronicTr1");


// -------------- pyelonephritis --------------
// (C) OntoOO Inc Tue May 28 09:32:57 PDT 2002
// (C) OntoOO Inc Mon Aug 30 15:07:17 GMT-08:00 2004
Disease pyelonephritisDis = new Disease(
   LR.pyelonephritis, 
   "bacterial infection of the kidneys", 
   LR.renalDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   10, //  minAge 
   LR.maxAge,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.renalSysSt, 
   LR.none
);
pyelonephritisDis.addSymptom(LR.flankPain);
pyelonephritisDis.addReference("pp 766-768");
Treatment pyelonephritisTr1  = new Treatment("pyelonephritisTr1");
pyelonephritisTr1.addDrug(LR.antibiotics);
pyelonephritisDis.addTreatment(pyelonephritisTr1.getName());


// -------------- pyelonephritisAcute --------------
// (C) OntoOO Inc Tue May 28 09:44:54 PDT 2002
// (C) OntoOO Inc Mon Aug 30 15:46:43 GMT-08:00 2004
Disease pyelonephritisAcuteDis = new Disease(
   LR.pyelonephritisAcute, 
   "acute bacterial infection of the kidneys", 
   LR.renalDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   10, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.renalSysSt, 
   LR.none
);
pyelonephritisAcuteDis.setPrintName("acute pyelonephritis");
pyelonephritisAcuteDis.setSuperDisease(LR.pyelonephritis);
pyelonephritisAcuteDis.addSymptom(LR.dysuria, "", 1.0f);
pyelonephritisAcuteDis.addSymptom(LR.hematuria, "", 1.0f);
pyelonephritisAcuteDis.addSymptom(LR.nocturia, "", 1.0f);
pyelonephritisAcuteDis.addSymptom(LR.urineCloudy, "", 1.0f);
pyelonephritisAcuteDis.addSymptom(LR.urinaryBurning, "", 1.0f);
pyelonephritisAcuteDis.addSymptom(LR.urinaryFrequency, "", 1.0f);
pyelonephritisAcuteDis.addSymptom(LR.urinaryUrgency, "", 1.0f);
pyelonephritisAcuteDis.addSymptom(LR.anorexia);
pyelonephritisAcuteDis.addSymptom(LR.chills);
pyelonephritisAcuteDis.addSymptom(LR.fatigue);
pyelonephritisAcuteDis.addSymptom(LR.shaking);
pyelonephritisAcuteDis.addReference("pp 766-768");


// -------------- pyelonephritisChronic --------------
// (C) OntoOO Inc Tue May 28 09:48:23 PDT 2002
// (C) OntoOO Inc Mon Aug 30 16:30:00 GMT-08:00 2004
Disease pyelonephritisChronicDis = new Disease(
   LR.pyelonephritisChronic, 
   "chronic bacterial infection of the kidneys", 
   LR.renalDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.renalSysSt, 
   LR.none
);
pyelonephritisChronicDis.setPrintName("chronic pyelonephritis");
pyelonephritisChronicDis.setSuperDisease(LR.pyelonephritis);
pyelonephritisChronicDis.addSymptom(LR.anorexia);
pyelonephritisChronicDis.addSymptom(LR.feverSym);
pyelonephritisChronicDis.addSymptom(LR.hematuria);
pyelonephritisChronicDis.addSymptom(LR.malaise);
pyelonephritisChronicDis.addSymptom(LR.weightLoss);
pyelonephritisChronicDis.addInternalCause(LR.pyelonephritisAcute);
pyelonephritisChronicDis.addCausesDisease(LR.anemia);
pyelonephritisChronicDis.addCausesDisease(LR.hypertension);
pyelonephritisChronicDis.addCausesAbnormalCondition(LR.proteinuria);
pyelonephritisChronicDis.addCausesAbnormalCondition(LR.bacteriuria);
pyelonephritisChronicDis.addReference("pp 766-768");


    // -------------- renalCalculi  ---------------
// (C) OntoOO Inc Tue Oct 16 12:15:03 PDT 2001
// (C) OntoOO Inc Wed Sep 01 13:26:24 GMT-08:00 2004
Disease renalCalculiDis = new Disease(
   LR.renalCalculi, 
   "kidney stones", 
   LR.renalDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.caucasian, // raceSpecificity 
   30, //  minAge 
   50,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.renalSysSt, 
   LR.none
);
renalCalculiDis.setPrintName("renal calculi");
renalCalculiDis.addSymptom(LR.abdomenPain, "", 0.6f);
renalCalculiDis.addSymptom(LR.backPain, "", 0.6f);
renalCalculiDis.addSymptom(LR.flankPain, "", 1.0f);
renalCalculiDis.addSymptom(LR.nausea, "", 0.8f);
renalCalculiDis.addSymptom(LR.vomiting, "", 0.8f);
renalCalculiDis.addSymptom(LR.abdomenDistension, "", 0.3f);
renalCalculiDis.addSymptom(LR.anuria, "", 0.03f);
renalCalculiDis.addSymptom(LR.chills, "", 0.3f);
renalCalculiDis.addSymptom(LR.hematuria, "", 0.3f);
renalCalculiDis.addSymptom(LR.pyuria, "", 0.3f);
renalCalculiDis.addInternalCause(LR.berylliosisChronic);
renalCalculiDis.addInternalCause(LR.gout);
renalCalculiDis.addReference("pp 773-6");
Treatment renalCalculiTr1 = new Treatment("renalCalculiTr1", LR.ifSevere);
renalCalculiTr1.addTreatmentAction(LR.surgery);
renalCalculiDis.addTreatment("renalCalculiTr1");
Treatment renalCalculiTr2 = new Treatment("renalCalculiTr2");
renalCalculiTr2.addTreatmentAction(LR.hydration);
renalCalculiTr2.addDrug(LR.analgetics);
renalCalculiTr2.addDrug(LR.antimicrobials);
renalCalculiTr2.addDrug(LR.diuretics);
renalCalculiDis.addTreatment(renalCalculiTr2.getName());


    // -------------- renalFailureAcute  ---------------
// (C) OntoOO Inc Mon Oct 22 18:07:40 PDT 2001
Disease renalFailureAcuteDis = new Disease(
   LR.renalFailureAcute, 
   "acute kidney failure", 
   LR.renalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
    LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.renalSysSt, 
   LR.renalObstruction
);
renalFailureAcuteDis.setPrintName("renal failure acute");
renalFailureAcuteDis.setTemperature(LR.fever);
renalFailureAcuteDis.addSymptom(LR.anorexia, "", 1.0f);
renalFailureAcuteDis.addSymptom(LR.coma, "", 1.0f);
renalFailureAcuteDis.addSymptom(LR.confusion, "", 1.0f);
renalFailureAcuteDis.addSymptom(LR.constipation, "", 0.4f);
renalFailureAcuteDis.addSymptom(LR.diarrhea, "", 0.4f);
renalFailureAcuteDis.addSymptom(LR.drowsiness, "", 1.0f);
renalFailureAcuteDis.addSymptom(LR.edema, "", 1.0f);
renalFailureAcuteDis.addSymptom(LR.headache, "", 1.0f);
renalFailureAcuteDis.addSymptom(LR.irritability, "", 1.0f);
renalFailureAcuteDis.addSymptom(LR.nausea, "", 1.0f);
renalFailureAcuteDis.addSymptom(LR.pallor, "", 1.0f);
renalFailureAcuteDis.addSymptom(LR.seizure, "", 1.0f);
renalFailureAcuteDis.addSymptom(LR.vomiting, "", 1.0f);
renalFailureAcuteDis.addSymptom(LR.anuria, "", 0.02f);
renalFailureAcuteDis.addSymptom(LR.oliguria, "", 1.0f);
renalFailureAcuteDis.addSymptom(LR.uremicBreath, "", 1.0f);
renalFailureAcuteDis.addSymptom(LR.pruritus, "", 1.0f);

renalFailureAcuteDis.addInternalCause(LR.schistosomiasis);
renalFailureAcuteDis.addInternalCause(LR.hypertension);

renalFailureAcuteDis.addCausesDisease(LR.heartFailure);
renalFailureAcuteDis.addCausesDisease(LR.stomatitis);

renalFailureAcuteDis.addCausingAbnormalCondition(LR.azotemia);
renalFailureAcuteDis.addCausesAbnormalCondition(LR.acidosis);
renalFailureAcuteDis.addCausesAbnormalCondition(LR.electrolyteImbalance);
renalFailureAcuteDis.addCausesAbnormalCondition(LR.neuropathy);

renalFailureAcuteDis.addReference("pp 764-6");
Treatment renalFailureAcuteTr1  = new Treatment("renalFailureAcuteTr1");
renalFailureAcuteTr1.addTreatmentAction(LR.fluidManagement);
renalFailureAcuteTr1.addTreatmentAction(LR.dietHighCalorie);
renalFailureAcuteTr1.addTreatmentAction(LR.dietLowProtein);
renalFailureAcuteTr1.addTreatmentAction(LR.hemodialysis);
renalFailureAcuteTr1.addTreatmentAction(LR.peritonealDialysis);
renalFailureAcuteDis.addTreatment(renalFailureAcuteTr1.getName());
renalFailureAcuteDis.setCode358(327);
renalFailureAcuteDis.setICD10code("N17");


// -------------- renalInfarction --------------
// (C) OntoOO Inc Sun Nov 25 12:19:16 PST 2001
Disease renalInfarctionDis = new Disease(
   LR.renalInfarction, 
   "diseased area in one or both kidneys due to a blockage of a blood vessel", 
   LR.renalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
    LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.renalSysSt, 
   LR.none
);
renalInfarctionDis.setPrintName("renal infarction");
renalInfarctionDis.setTemperature((float)102.0);
renalInfarctionDis.addSymptom(LR.abdomenPainUpperSide);
renalInfarctionDis.addSymptom(LR.anorexia);
renalInfarctionDis.addSymptom(LR.flankPain);
renalInfarctionDis.addSymptom(LR.nausea);
renalInfarctionDis.addSymptom(LR.vomiting);
renalInfarctionDis.addInternalCause(LR.adrenalCrisis); 
renalInfarctionDis.addInternalCause(LR.legionaire);
renalInfarctionDis.addReference("pp 771-3");
Treatment renalInfarctionTr1  = new Treatment("renalInfarctionTr1");
renalInfarctionTr1.addTreatmentAction(LR.surgery);
renalInfarctionTr1.addDrug(LR.antihypertensives);
renalInfarctionTr1.addDrug(LR.heparin);
renalInfarctionTr1.addDrug(LR.streptokinase);
renalInfarctionDis.addTreatment(renalInfarctionTr1.getName());


// -------------- renalVeinThrombosis --------------
// (C) OntoOO Inc Sun Nov 25 17:58:58 PST 2001
Disease renalVeinThrombosisDis = new Disease(
   LR.renalVeinThrombosis, 
   "clotting in a renal (kidney) vein ", 
   LR.renalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
    LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.renalSysSt, 
   LR.none
);
renalVeinThrombosisDis.setPrintName("renal vein thrombosis");
renalVeinThrombosisDis.setTemperature((float)102.0);
renalVeinThrombosisDis.addSymptom(LR.edema);
renalVeinThrombosisDis.addSymptom(LR.epigastricPain);
renalVeinThrombosisDis.addSymptom(LR.flankPain);
renalVeinThrombosisDis.addSymptom(LR.hematuria);
renalVeinThrombosisDis.addSymptom(LR.lumbarPain);
renalVeinThrombosisDis.addSymptom(LR.oliguria);
renalVeinThrombosisDis.addSymptom(LR.pallor);

renalVeinThrombosisDis.addCausesAbnormalCondition(LR.leukocytosis);
renalVeinThrombosisDis.addCausesAbnormalCondition(LR.proteinuria);

renalVeinThrombosisDis.addReference("pp 776-7");

Treatment renalVeinThrombosisTr1 = new Treatment("renalVeinThrombosisTr1");
renalVeinThrombosisTr1.addTreatmentAction(LR.dialysis);
renalVeinThrombosisTr1.addTreatmentAction(LR.surgery);
renalVeinThrombosisTr1.addTreatmentAction(LR.kidneyTransplantation);
renalVeinThrombosisTr1.addDrug(LR.anticoagulants);
renalVeinThrombosisDis.addTreatment(renalVeinThrombosisTr1.getName()); 


    // -------------- tubularNecrosisAcute  ---------------
// (C) OntoOO Inc Thu Oct 25 12:43:56 PDT 2001
Disease tubularNecrosisAcuteDis = new Disease(
   LR.tubularNecrosisAcute, 
   "sudden damage to the kidney nephrons - the filter elements", 
   LR.renalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
    LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.renalSysSt, 
   LR.none
);
tubularNecrosisAcuteDis.setPrintName("tubular necrosis acute");
tubularNecrosisAcuteDis.addSymptom(LR.anorexia, "", 1.0f);
tubularNecrosisAcuteDis.addSymptom(LR.confusion, "", 1.0f);
tubularNecrosisAcuteDis.addSymptom(LR.consciousnessDecreased);
tubularNecrosisAcuteDis.addSymptom(LR.drowsiness);
tubularNecrosisAcuteDis.addSymptom(LR.edema);
tubularNecrosisAcuteDis.addSymptom(LR.nausea);
tubularNecrosisAcuteDis.addSymptom(LR.oliguria, "", 1.0f);
tubularNecrosisAcuteDis.addSymptom(LR.vomiting, "", 1.0f);

tubularNecrosisAcuteDis.addCausesDisease(LR.heartFailure);
tubularNecrosisAcuteDis.addCausesDisease(LR.pericarditis);
tubularNecrosisAcuteDis.addCausesDisease(LR.anemia);

tubularNecrosisAcuteDis.addCausesAbnormalCondition(LR.uremia);
tubularNecrosisAcuteDis.addCausesDisease(LR.hyperkalemia);
tubularNecrosisAcuteDis.addReference("pp 769-71");
tubularNecrosisAcuteDis.setMiscComments(
    "mortality is 40-70% depending on underlying complications");
Treatment tubularNecrosisAcuteTr1 = new Treatment("tubularNecrosisAcuteTr1");
tubularNecrosisAcuteTr1.addTreatmentAction(LR.IVFluids);
tubularNecrosisAcuteTr1.addTreatmentAction(LR.dialysis);
tubularNecrosisAcuteTr1.addTreatmentAction(LR.bloodTransfusion);
tubularNecrosisAcuteTr1.addDrug(LR.diuretics);
tubularNecrosisAcuteTr1.addDrug(LR.insulin);
tubularNecrosisAcuteDis.addTreatment(tubularNecrosisAcuteTr1.getName()); 


// -------------- nephroticSyndrome --------------
// (C) OntoOO Inc Fri Apr 26 21:13:42 PDT 2002
// (C) OntoOO Inc Thu Aug 19 14:02:49 GMT-08:00 2004
Disease nephroticSyndromeDis = new Disease(
   LR.nephroticSyndrome, 
   "abnormal conditions in the kidney", 
   LR.renalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.renalSysSt, 
   LR.none
);
nephroticSyndromeDis.setPrintName("nephrotic syndrome");
nephroticSyndromeDis.addSymptom(LR.edema, "", 1.0f);
nephroticSyndromeDis.addSymptom(LR.anorexia);
nephroticSyndromeDis.addSymptom(LR.hypotension);
nephroticSyndromeDis.addSymptom(LR.lethargy);
nephroticSyndromeDis.addSymptom(LR.pallor);
nephroticSyndromeDis.addInternalCause(LR.diabetesMellitusAdvanced);
nephroticSyndromeDis.addCausingAbnormalCondition(LR.proteinuria);
nephroticSyndromeDis.addCausesDisease(LR.depression);
nephroticSyndromeDis.addCausesAbnormalCondition(LR.ascites);
nephroticSyndromeDis.addCausesAbnormalCondition(LR.pleuralEffusion);
nephroticSyndromeDis.addReference("pp 777-9");
Treatment nephroticSyndromeTr1  = new Treatment("nephroticSyndromeTr1");
nephroticSyndromeTr1.addTreatmentAction(LR.sodiumRestriction);
nephroticSyndromeTr1.addTreatmentAction(LR.proteinSupplement);
nephroticSyndromeTr1.addDrug(LR.antibiotics);
nephroticSyndromeTr1.addDrug(LR.diuretics);
nephroticSyndromeDis.addTreatment(nephroticSyndromeTr1.getName());


// -------------- urinaryTractInfection --------------
// (C) OntoOO Inc Sun Mar 17 21:12:42 PST 2002
Disease urinaryTractInfectionDis = new Disease(
   LR.urinaryTractInfection, 
   "infection of urinary tract", 
   LR.urologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
    LR.maxAge, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.urologicSysSt, 
   LR.bacterialInfection
);
urinaryTractInfectionDis.setPrintName("urinary tract infection");
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
urinaryTractInfectionDis.addInternalCause(LR.diabetesMellitusAdvanced);
urinaryTractInfectionDis.addReference("pp 792-4");
Treatment urinaryTractInfectionTr1 = new Treatment("urinaryTractInfectionTr1");
urinaryTractInfectionTr1.addDrug(LR.antimicrobials);
urinaryTractInfectionDis.addTreatment(urinaryTractInfectionTr1.getName()); 
urinaryTractInfectionDis.setCode358(330);
urinaryTractInfectionDis.setICD10code("N39");


// -------------- cystitis --------------
// (C) OntoOO Inc Sun Mar 17 21:39:52 PST 2002
Disease cystitisDis = new Disease(
   LR.cystitis, 
   "infection of the bladder", 
   LR.urologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
    LR.maxAge, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bladderSysSt, 
   LR.none
);
cystitisDis.setSuperDisease(LR.urinaryTractInfection);
cystitisDis.setTemperature((float)101.0);
cystitisDis.addSymptom(LR.hematuria, "", 1.0f);
cystitisDis.addInternalCause(LR.prostateCancer);
cystitisDis.addReference("pp 792-4");


// -------------- urethritisML --------------
// (C) OntoOO Inc Sun Mar 17 21:45:41 PST 2002
Disease urethritisMLDis = new Disease(
   LR.urethritisML, 
   "infection of the male urethra", 
   LR.urologicDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
    LR.maxAge, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bladderSysSt, 
   LR.none
);
urethritisMLDis.setPrintName("urethritis male");
urethritisMLDis.setSuperDisease(LR.urinaryTractInfection);
urethritisMLDis.addSymptom(LR.urethraMaleDischarge);
urethritisMLDis.addInternalCause(LR.trichomoniasisMale);
urethritisMLDis.addReference("pp 792-4");


// -------------- epididymitis --------------
// (C) OntoOO Inc Tue Jun 18 16:01:57 PDT 2002
Disease epididymitisDis = new Disease(
   LR.epididymitis, 
   "infection of the testicle excretory duct", 
   LR.renalDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.epididymisSysSt, 
   LR.staphylococcusInfection
);
epididymitisDis.setTemperature((float)103.0);
epididymitisDis.addSymptom(LR.groinPain);
epididymitisDis.addSymptom(LR.groinSwelling);
epididymitisDis.addSymptom(LR.malaise);
epididymitisDis.addSymptom(LR.scrotumSwellingPainful);
epididymitisDis.addExternalCause(LR.streptococcusInfection);
epididymitisDis.addInternalCause(LR.chlamydialInfectionEpididymis);
epididymitisDis.addInternalCause(LR.gonorrheaUrethraMale);
epididymitisDis.addInternalCause(LR.syphilis);
epididymitisDis.addReference("pp 803-4");
Treatment epididymitisTr1  = new Treatment("epididymitisTr1");
epididymitisTr1.addDrug(LR.analgetics);
epididymitisTr1.addDrug(LR.antibiotics);
epididymitisDis.addTreatment(epididymitisTr1.getName());

  } // end doit()

} // end InitRenalDiseases
