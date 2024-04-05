// (C) OntoOO Dennis de Champeaux 2000 2012
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

public class InitTraumas {
  public static void doit() {

    // -------------- abdomenTrauma ---------------
// (C) OntoOO Inc Mon Oct 22 14:16:42 PDT 2001
Disease abdomenTraumaDis = new Disease(
   LR.abdomenTrauma, 
   "abdomen injuries due to accidents or 'accidents'", 
   LR.traumas, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.trauma
);
abdomenTraumaDis.setPrintName("abdomen trauma");
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

abdomenTraumaDis.addReference("pp 290-2");
Treatment abdomenTraumaTr1  = new Treatment("abdomenTraumaTr1");
abdomenTraumaTr1.addTreatmentAction(LR.IVFluids);
abdomenTraumaTr1.addTreatmentAction(LR.surgery);
abdomenTraumaTr1.addDrug(LR.analgetics);
abdomenTraumaTr1.addDrug(LR.antibiotics);
abdomenTraumaDis.addTreatment(abdomenTraumaTr1.getName());


    // -------------- asphyxia ---------------
// (C) OntoOO Inc Tue Oct 30 11:03:54 PST 2001
Disease asphyxiaDis = new Disease(
   LR.asphyxia, 
   "lack of O2 and too much CO2 in the blood leading to cardiopulmonary arrest", 
   LR.respiratoryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.respiratorySysSt, 
   LR.narcoticsMisuse
);
asphyxiaDis.addSymptom(LR.agitation, "", 1.0f);
asphyxiaDis.addSymptom(LR.anxiety, "", 1.0f);
asphyxiaDis.addSymptom(LR.apnea, "", 1.0f);
asphyxiaDis.addSymptom(LR.bradypnea, "", 1.0f);
asphyxiaDis.addSymptom(LR.breathlessness, "", 1.0f);
asphyxiaDis.addSymptom(LR.confusion, "", 1.0f);
asphyxiaDis.addSymptom(LR.consciousnessDecreased, "", 1.0f);
asphyxiaDis.addSymptom(LR.cyanosis, "", 1.0f);
asphyxiaDis.addSymptom(LR.dyspnea, "", 1.0f);
asphyxiaDis.addSymptom(LR.hypoventilation, "", 1.0f);
asphyxiaDis.addSymptom(LR.tachypnea, "", 1.0f);

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
asphyxiaDis.setMiscComments("without prompt treatment, it is fatal");

Treatment asphyxiaTr1 = new Treatment("asphyxiaTr1");
asphyxiaTr1.addTreatmentAction(LR.CPR);
asphyxiaTr1.addTreatmentAction(LR.endotrachealIntubation);
asphyxiaTr1.addTreatmentAction(LR.oxygenTherapy);
asphyxiaDis.addTreatment(asphyxiaTr1.getName()); 
Treatment asphyxiaTr2 = new Treatment("asphyxiaTr2", LR.ifObstructingObject);
asphyxiaTr2.addTreatmentAction(LR.bronchoscopy);
asphyxiaDis.addTreatment(asphyxiaTr2.getName()); 
Treatment asphyxiaTr3 = new Treatment("asphyxiaTr3", LR.ifNarcoticOverdose);
asphyxiaTr3.addDrug(LR.naloxone);
asphyxiaDis.addTreatment(asphyxiaTr3.getName()); 
Treatment asphyxiaTr4 = new Treatment("asphyxiaTr4", LR.ifPoisoned);
asphyxiaTr4.addTreatmentAction(LR.gastricLavage);
asphyxiaDis.addTreatment(asphyxiaTr4.getName()); 


// -------------- beeWaspYellowJacketSting --------------
// (C) OntoOO Inc Mon Dec 08 18:02:30 PST 2003
Disease beeWaspYellowJacketStingDis = new Disease(
   LR.beeWaspYellowJacketSting, 
   "sting from a bee wasp or yellow jacket", 
   LR.traumas, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
beeWaspYellowJacketStingDis.setPrintName("bee wasp yellow jacket sting");
beeWaspYellowJacketStingDis.addSymptom(LR.insectSting, "", 1.0f);
beeWaspYellowJacketStingDis.addSymptom(LR.woundPainful);
beeWaspYellowJacketStingDis.addSymptom(LR.edema);
beeWaspYellowJacketStingDis.addSymptom(LR.urticaria);
beeWaspYellowJacketStingDis.addSymptom(LR.pruritus);
beeWaspYellowJacketStingDis.addSymptom(LR.weakness, "within 20 minutes", 0.2f);
beeWaspYellowJacketStingDis.addSymptom(LR.chestTightness, "within 20 minutes", 0.2f);
beeWaspYellowJacketStingDis.addSymptom(LR.dizziness, "within 20 minutes", 0.2f);
beeWaspYellowJacketStingDis.addSymptom(LR.nausea, "within 20 minutes", 0.2f);
beeWaspYellowJacketStingDis.addSymptom(LR.vomiting, "within 20 minutes", 0.2f);
beeWaspYellowJacketStingDis.addSymptom(LR.abdomenCramping, "within 20 minutes", 0.2f);
beeWaspYellowJacketStingDis.addSymptom(LR.throatConstriction, "within 20 minutes", 0.2f);
beeWaspYellowJacketStingDis.addReference("pp 320-1");
beeWaspYellowJacketStingDis.setMiscComments("duration can be longer for certain people");
Treatment beeWaspYellowJacketStingTr1 = new Treatment("beeWaspYellowJacketStingTr1");
beeWaspYellowJacketStingTr1.addDrug(LR.antihistamines);
beeWaspYellowJacketStingTr1.addDrug(LR.corticosteroids);
beeWaspYellowJacketStingTr1.addDrug(LR.tetanusToxoid);
beeWaspYellowJacketStingDis.addTreatment("beeWaspYellowJacketStingTr1");
Treatment beeWaspYellowJacketStingTr2 = 
   new Treatment("beeWaspYellowJacketStingTr2", LR.ifHypersensitive);
beeWaspYellowJacketStingTr2.addTreatmentAction(LR.oxygenTherapy);
beeWaspYellowJacketStingTr2.addDrug(LR.epinephrine);
beeWaspYellowJacketStingDis.addTreatment("beeWaspYellowJacketStingTr2");
Treatment beeWaspYellowJacketStingTr3 = 
   new Treatment("beeWaspYellowJacketStingTr3", LR.ifBronchospasm);
beeWaspYellowJacketStingTr3.addDrug(LR.albuterol);
beeWaspYellowJacketStingTr3.addDrug(LR.corticosteroids);
beeWaspYellowJacketStingDis.addTreatment("beeWaspYellowJacketStingTr3");
Treatment beeWaspYellowJacketStingTr4  = 
   new Treatment("beeWaspYellowJacketStingTr4", LR.ifHypotension);
beeWaspYellowJacketStingTr4.addDrug(LR.epinephrine);
beeWaspYellowJacketStingTr4.addDrug(LR.isoproterenol);
beeWaspYellowJacketStingDis.addTreatment(beeWaspYellowJacketStingTr4.getName());


// -------------- blackWidowSpiderBite --------------
// (C) OntoOO Inc Wed Nov 12 17:53:21 PST 2003
Disease blackWidowSpiderBiteDis = new Disease(
   LR.blackWidowSpiderBite, 
   "black widow spider bite", 
   LR.traumas, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
blackWidowSpiderBiteDis.setPrintName();
blackWidowSpiderBiteDis.setTemperature((float)100.3);
blackWidowSpiderBiteDis.addSymptom(LR.spiderBite, "", 1.0f);
blackWidowSpiderBiteDis.addSymptom(LR.biteMarksRed);
blackWidowSpiderBiteDis.addSymptom(LR.abdomenPain);
blackWidowSpiderBiteDis.addSymptom(LR.chills, "", 1.0f);
blackWidowSpiderBiteDis.addSymptom(LR.edema, "", 1.0f);
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
blackWidowSpiderBiteDis.addSymptom(LR.seizure, "especially in children", 0.2f);
blackWidowSpiderBiteDis.addSymptom(LR.spasm);
blackWidowSpiderBiteDis.addSymptom(LR.dysphagia);
blackWidowSpiderBiteDis.addSymptom(LR.sweating);
blackWidowSpiderBiteDis.addSymptom(LR.tachycardia);
blackWidowSpiderBiteDis.addSymptom(LR.urticaria);
blackWidowSpiderBiteDis.addSymptom(LR.vertigo);
blackWidowSpiderBiteDis.addSymptom(LR.vomiting, "", 1.0f);
blackWidowSpiderBiteDis.addCausesDisease(LR.hypertension);
blackWidowSpiderBiteDis.addCausesAbnormalCondition(LR.circulatoryFailure);
blackWidowSpiderBiteDis.addReference("pp 320-1");
Treatment blackWidowSpiderBiteTr1 = new Treatment("blackWidowSpiderBiteTr1");
blackWidowSpiderBiteTr1.addTreatmentAction(LR.oxygenTherapy);
blackWidowSpiderBiteTr1.addTreatmentAction(LR.antivenin);
blackWidowSpiderBiteTr1.addTreatmentAction(LR.calciumGluconate);
blackWidowSpiderBiteTr1.addDrug(LR.antibiotics);
blackWidowSpiderBiteTr1.addDrug(LR.antihistamines);
blackWidowSpiderBiteTr1.addDrug(LR.diazepam);
blackWidowSpiderBiteTr1.addDrug(LR.tetanusToxoid);
blackWidowSpiderBiteDis.addTreatment(blackWidowSpiderBiteTr1.getName()); 
blackWidowSpiderBiteDis.addIllustration(D.BlackwidowGif);
blackWidowSpiderBiteDis.addIllustration(D.BlackwidowJpg);


// -------------- brownRecluseSpiderBite --------------
// (C) OntoOO Inc Tue Nov 11 18:13:47 PST 2003
Disease brownRecluseSpiderBiteDis = new Disease(
   LR.brownRecluseSpiderBite, 
   "brown recluse spider bite ", 
   LR.traumas, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
brownRecluseSpiderBiteDis.setPrintName("brown recluse spider bite");
brownRecluseSpiderBiteDis.setTemperature((float)100.3);
brownRecluseSpiderBiteDis.addSymptom(LR.spiderBite);
brownRecluseSpiderBiteDis.addSymptom(LR.bleb, "spider bite site", 1.0f);
brownRecluseSpiderBiteDis.addSymptom(LR.chills, "", 1.0f);
brownRecluseSpiderBiteDis.addSymptom(LR.cyanosis, "", 1.0f);
brownRecluseSpiderBiteDis.addSymptom(LR.edema, "", 1.0f);
brownRecluseSpiderBiteDis.addSymptom(LR.jointPain, "", 1.0f);
brownRecluseSpiderBiteDis.addSymptom(LR.malaise, "", 1.0f);
brownRecluseSpiderBiteDis.addSymptom(LR.petechiae, "", 1.0f);
brownRecluseSpiderBiteDis.addSymptom(LR.phlebitis, "", 0.3f);
brownRecluseSpiderBiteDis.addSymptom(LR.seizure, "", 1.0f);
brownRecluseSpiderBiteDis.addSymptom(LR.vomiting, "", 1.0f);
brownRecluseSpiderBiteDis.addSymptom(LR.weakness, "", 1.0f); 
brownRecluseSpiderBiteDis.addReference("pp 318-9");
Treatment brownRecluseSpiderBiteTr1  = new Treatment("brownRecluseSpiderBiteTr1");
brownRecluseSpiderBiteTr1.addTreatmentAction(LR.IVFluids);
brownRecluseSpiderBiteTr1.addDrug(LR.antibiotics);
brownRecluseSpiderBiteTr1.addDrug(LR.antihistamines);
brownRecluseSpiderBiteTr1.addDrug(LR.corticosteroids);
brownRecluseSpiderBiteTr1.addDrug(LR.tetanusToxoid);
brownRecluseSpiderBiteTr1.addDrug(LR.tranquilizer);
brownRecluseSpiderBiteDis.addTreatment(brownRecluseSpiderBiteTr1.getName());
brownRecluseSpiderBiteDis.addIllustration(D.RecluseJpg);
brownRecluseSpiderBiteDis.addIllustration(D.RecluseBiteGif);


// -------------- burn --------------
// (C) OntoOO Inc Sun Dec 28 17:21:26 PST 2003
Disease burnDis = new Disease(
   LR.burn, 
   "skin damage in varying degrees", 
   LR.traumas, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.chemicals
);
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
burnDis.addTreatment(burnTr2.getName()); 


// -------------- burnFirstDegree --------------
// (C) OntoOO Inc Tue Dec 30 20:01:52 PST 2003
Disease burnFirstDegreeDis = new Disease(
   LR.burnFirstDegree, 
   "first degree burned skin damage", 
   LR.traumas, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
burnFirstDegreeDis.setPrintName("burn first degree");
burnFirstDegreeDis.setSuperDisease(LR.burn);
burnFirstDegreeDis.addSymptom(LR.erythema);
burnFirstDegreeDis.addSymptom(LR.skinBurnedPain);
burnFirstDegreeDis.addReference("pp 299-302");
Treatment burnFirstDegreeTr1  = new Treatment("burnFirstDegreeTr1");
burnFirstDegreeTr1.addTreatmentAction(LR.coldCompress);
burnFirstDegreeTr1.addTreatmentAction(LR.painManagement);
burnFirstDegreeDis.addTreatment(burnFirstDegreeTr1.getName());


// -------------- burnSecondDegree --------------
// (C) OntoOO Inc Sun Jan 18 05:17:55 PST 2004
Disease burnSecondDegreeDis = new Disease(
   LR.burnSecondDegree, 
   "second degree burned skin damage", 
   LR.traumas, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
burnSecondDegreeDis.setPrintName("burn second degree");
burnSecondDegreeDis.setSuperDisease(LR.burn);
burnSecondDegreeDis.addSymptom(LR.skinBurnedPain, "", 1.0f);
burnSecondDegreeDis.addSymptom(LR.blister);
burnSecondDegreeDis.addSymptom(LR.edema);
burnSecondDegreeDis.addReference("pp 299-302");
Treatment burnSecondDegreeTr1  = new Treatment("burnSecondDegreeTr1");
burnSecondDegreeTr1.addTreatmentAction(LR.woundCare);
burnSecondDegreeTr1.addDrug(LR.tetanusToxoid);
burnSecondDegreeDis.addTreatment(burnSecondDegreeTr1.getName());


// -------------- burnThirdDegree --------------
// (C) OntoOO Inc Sun Jan 18 05:50:38 PST 2004
Disease burnThirdDegreeDis = new Disease(
   LR.burnThirdDegree, 
   "third degree burned skin damage ", 
   LR.traumas, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
burnThirdDegreeDis.setPrintName("burn third degree");
burnThirdDegreeDis.setSuperDisease(LR.burn);
burnThirdDegreeDis.addSymptom(LR.skinBurnedPain, "", 1.0f);
burnThirdDegreeDis.addSymptom(LR.skinBurnedLeatheryWhite, "", 0.3f);
burnThirdDegreeDis.addSymptom(LR.skinBurnedLeatheryBrown, "", 0.3f);
burnThirdDegreeDis.addSymptom(LR.skinBurnedLeatheryBlack, "", 0.3f);
burnThirdDegreeDis.addReference("pp 299-302");
burnThirdDegreeDis.addTreatment("burnSecondDegreeTr1");


// -------------- burnFourthDegree --------------
// (C) OntoOO Inc Sun Jan 18 09:13:26 PST 2004
Disease burnFourthDegreeDis = new Disease(
   LR.burnFourthDegree, 
   "fourth degree burned skin damage ", 
   LR.traumas, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
burnFourthDegreeDis.setPrintName("burn fourth degree");
burnFourthDegreeDis.setSuperDisease(LR.burn);
burnFourthDegreeDis.addSymptom(LR.skinBurnedPain, "", 1.0f);
burnFourthDegreeDis.addSymptom(LR.skinTissueCharred);
burnFourthDegreeDis.addReference("pp 299-302");
Treatment burnFourthDegreeTr1  = new Treatment("burnFourthDegreeTr1", LR.ifRespiratoryFailure);
burnFourthDegreeTr1.addTreatmentAction(LR.endotrachealIntubation);
burnFourthDegreeDis.addTreatment(burnFourthDegreeTr1.getName());
Treatment burnFourthDegreeTr2 = new Treatment("burnFourthDegreeTr2");
burnFourthDegreeTr2.addTreatmentAction(LR.IVFluids);
burnFourthDegreeDis.addTreatment(burnFourthDegreeTr2.getName()); 


    // -------------- cerebralContusion ---------------
// (C) OntoOO Inc Fri Nov 02 15:01:47 PST 2001 
Disease cerebralContusionDis = new Disease( 
LR.cerebralContusion, 
"bruising of brain tissue due to a severe blow to the head", 
LR.traumas, 
LR.none, // genderSpecificity 
LR.none, // raceSpecificity 
0, // minAge 
LR.maxAge, // maxAge 
0, // duration 
-1, // diagnosis frequency, -1 = unknown 
LR.brainSysSt, 
LR.trauma 
); 
cerebralContusionDis.setPrintName("cerebral contusion"); 

cerebralContusionDis.addSymptom(LR.confusion, "", 1.0f); 
cerebralContusionDis.addSymptom(LR.consciousnessLoss, "", 1.0f); 
cerebralContusionDis.addSymptom(LR.decerebratePosturing, "", 1.0f); 
cerebralContusionDis.addSymptom(LR.disorientation, "", 1.0f); 
cerebralContusionDis.addSymptom(LR.drowsiness, "", 1.0f); 
cerebralContusionDis.addSymptom(LR.hemiparesis, "", 1.0f); 
cerebralContusionDis.addSymptom(LR.pupilResponseUnequal, "", 1.0f); 
cerebralContusionDis.addSymptom(LR.respirationLabored, "", 1.0f); 
cerebralContusionDis.addSymptom(LR.scalpWound, "", 1.0f); 

cerebralContusionDis.addCausesAbnormalCondition(LR.death); 

cerebralContusionDis.addReference("pp 276-8"); 

Treatment cerebralContusionTr1 = new Treatment("cerebralContusionTr1");
cerebralContusionTr1.addTreatmentAction(LR.fluidRestriction);
cerebralContusionTr1.addTreatmentAction(LR.airwayMaintenance);
cerebralContusionTr1.addTreatmentAction(LR.bedHeadElevated);
cerebralContusionTr1.addTreatmentAction(LR.hyperventilationAfterIntubation);
cerebralContusionTr1.addDrug(LR.mannitol);
cerebralContusionTr1.addDrug(LR.dexamethasone);
cerebralContusionDis.addTreatment(cerebralContusionTr1.getName()); 


    // -------------- electricShock ---------------
// (C) OntoOO Inc Wed Nov 07 18:11:26 PST 2001
Disease electricShockDis = new Disease(
   LR.electricShock, 
   "electric shock", 
   LR.traumas, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.contactWithElectricalPower
);
electricShockDis.setPrintName();

electricShockDis.addSymptom(LR.arrhythmia, "", 1.0f);
electricShockDis.addSymptom(LR.cataract, "", 1.0f);
electricShockDis.addSymptom(LR.consciousnessLoss, "", 1.0f);
electricShockDis.addSymptom(LR.hearingLoss, "", 1.0f);
electricShockDis.addSymptom(LR.lymphadenopathy);
electricShockDis.addSymptom(LR.muscleContractions, "", 1.0f);
electricShockDis.addSymptom(LR.reflexControlLoss, "", 1.0f);
electricShockDis.addSymptom(LR.respirationParalysis, "", 1.0f);

electricShockDis.addCausesDisease(LR.burn);
electricShockDis.addCausesDisease(LR.myocardialInfarction);

electricShockDis.addReference("pp 302-4");

Treatment electricShockTr1 = new Treatment("electricShockTr1");
electricShockTr1.addTreatmentAction(LR.CPR);
electricShockTr1.addTreatmentAction(LR.lactatedRingerSolution);
electricShockTr1.addTreatmentAction(LR.surgicalDebridement);
electricShockTr1.addDrug(LR.furosemide);
electricShockTr1.addDrug(LR.mannitol);
electricShockTr1.addDrug(LR.sodiumBicarbonate);
electricShockDis.addTreatment(electricShockTr1.getName()); 


// -------------- intracerebralHemorrhage --------------
// (C) OntoOO Inc Fri Dec 30 17:54:02 PST 2011
Disease intracerebralHemorrhageDis = new Disease(
   LR.intracerebralHemorrhage, 
   "hemorrhage inside the skull due to head trauma", 
   LR.traumas, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.brainSysSt, 
   LR.headTrauma
);
intracerebralHemorrhageDis.setPrintName("intracerebral hemorrhage");
intracerebralHemorrhageDis.addSymptom(LR.aphasia);
intracerebralHemorrhageDis.addSymptom(LR.dizziness);
intracerebralHemorrhageDis.addSymptom(LR.headache);
intracerebralHemorrhageDis.addSymptom(LR.hemiparesis);
intracerebralHemorrhageDis.addSymptom(LR.nausea);
intracerebralHemorrhageDis.addSymptom(LR.seizure);
intracerebralHemorrhageDis.addSymptom(LR.vomiting);
intracerebralHemorrhageDis.addReference("pp 276-278");
Treatment intracerebralHemorrhageTr1 = 
    new Treatment("intracerebralHemorrhageTr1");
intracerebralHemorrhageTr1.addTreatmentAction(LR.surgery);
intracerebralHemorrhageDis.addTreatment(intracerebralHemorrhageTr1.getName()); 
intracerebralHemorrhageDis.setCode358(236);
intracerebralHemorrhageDis.setICD10code("I61");


// -------------- penetratingChestWound --------------
// (C) OntoOO Inc Thu Nov 22 18:29:36 PST 2001
Disease penetratingChestWoundDis = new Disease(
   LR.penetratingChestWound, 
   "penetrating chest wound", 
   LR.traumas, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
penetratingChestWoundDis.setPrintName();
penetratingChestWoundDis.addSymptom(LR.chestPainSevere); 
penetratingChestWoundDis.addSymptom(LR.consciousnessDecreased);
penetratingChestWoundDis.addSymptom(LR.pulseThready);
penetratingChestWoundDis.addSymptom(LR.pulseWeak);
penetratingChestWoundDis.addSymptom(LR.suckingSoundWhileBreathing); 
penetratingChestWoundDis.addSymptom(LR.tachycardia);

penetratingChestWoundDis.addReference("pp 289-90");

Treatment penetratingChestWoundTr1 = new Treatment("penetratingChestWoundTr1");
penetratingChestWoundTr1.addTreatmentAction(LR.airwayMaintenance);
penetratingChestWoundTr1.addTreatmentAction(LR.bleedingControl);
penetratingChestWoundTr1.addTreatmentAction(LR.bloodTransfusion);
penetratingChestWoundTr1.addTreatmentAction(LR.chestTubeDrainage);
penetratingChestWoundTr1.addTreatmentAction(LR.IVFluids);
penetratingChestWoundTr1.addTreatmentAction(LR.surgery);
penetratingChestWoundDis.addTreatment(penetratingChestWoundTr1.getName()); 


// -------------- poisoning --------------
// (C) OntoOO Inc Fri Nov 23 18:11:27 PST 2001
Disease poisoningDis = new Disease(
   LR.poisoning, 
   "poisoning", 
   LR.traumas, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
poisoningDis.addSymptom(LR.chestPain);
poisoningDis.addSymptom(LR.consciousnessLoss);
poisoningDis.addSymptom(LR.dizziness);
poisoningDis.addSymptom(LR.headache);
poisoningDis.addSymptom(LR.muscleWeakness);
poisoningDis.addSymptom(LR.nausea);
poisoningDis.addSymptom(LR.seizure);
poisoningDis.addSymptom(LR.vomiting);

poisoningDis.addReference("pp 313-5");

Treatment poisoningTr1  = new Treatment("poisoningTr1");
poisoningTr1.addTreatmentAction(LR.CPR);
poisoningTr1.addTreatmentAction(LR.IVFluids);
poisoningTr1.addTreatmentAction(LR.oxygenTherapy);
poisoningTr1.addTreatmentAction(LR.seizurePrecautions);
poisoningTr1.addTreatmentAction(LR.placedOnLeftSide);
poisoningTr1.addDrug(LR.poisonAntidote);
poisoningDis.addTreatment(poisoningTr1.getName());


// -------------- poisonousSnakeBite --------------
// (C) OntoOO Inc Fri Nov 23 21:54:16 PST 2001
Disease poisonousSnakeBiteDis = new Disease(
   LR.poisonousSnakeBite, 
   "poisonous snake bite", 
   LR.traumas, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
poisonousSnakeBiteDis.setPrintName();
poisonousSnakeBiteDis.setTemperature((float)100.3);

poisonousSnakeBiteDis.addSymptom(LR.bleb); 
poisonousSnakeBiteDis.addSymptom(LR.blister); 
poisonousSnakeBiteDis.addSymptom(LR.bloodyWoundDischarge); 
poisonousSnakeBiteDis.addSymptom(LR.ecchymoses); 
poisonousSnakeBiteDis.addSymptom(LR.edema, "", 1.0f); 
poisonousSnakeBiteDis.addSymptom(LR.necrosis);
poisonousSnakeBiteDis.addSymptom(LR.pain, "", 1.0f); 
poisonousSnakeBiteDis.addSymptom(LR.petechiae); 
poisonousSnakeBiteDis.addSymptom(LR.skinMottled, "", 1.0f); 

poisonousSnakeBiteDis.addReference("pp 315-9");

Treatment poisonousSnakeBiteTr1  = new Treatment("poisonousSnakeBiteTr1");
poisonousSnakeBiteTr1.addTreatmentAction(LR.IVFluids);
poisonousSnakeBiteTr1.addTreatmentAction(LR.bloodTransfusion);
poisonousSnakeBiteTr1.addTreatmentAction(LR.endotrachealIntubation);
poisonousSnakeBiteTr1.addTreatmentAction(LR.mechanicalVentilation);
poisonousSnakeBiteTr1.addTreatmentAction(LR.lieDownPatient);
poisonousSnakeBiteTr1.addTreatmentAction(LR.positionBittenLimbBelowHeart);
poisonousSnakeBiteTr1.addTreatmentAction(LR.surgicalDebridement);
poisonousSnakeBiteTr1.addDrug(LR.analgetics);
poisonousSnakeBiteTr1.addDrug(LR.antivenin);
poisonousSnakeBiteDis.addTreatment(poisonousSnakeBiteTr1.getName());


// -------------- scorpionSting --------------
// (C) OntoOO Inc Sat Nov 29 15:35:39 PST 2003
Disease scorpionStingDis = new Disease(
   LR.scorpionSting, 
   "sting by the curled tail end; has eight legs and is 3 inch long", 
   LR.traumas, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
scorpionStingDis.setPrintName("scorpion sting");
scorpionStingDis.addSymptom(LR.insectSting);
scorpionStingDis.addSymptom(LR.swellingLocal);
scorpionStingDis.addSymptom(LR.tendernessLocal);
scorpionStingDis.addSymptom(LR.burningSensation);
scorpionStingDis.addSymptom(LR.skinDiscoloration);
scorpionStingDis.addSymptom(LR.paresthesia, "", 1.0f);
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
scorpionStingDis.addReference("pp 320-1");
scorpionStingDis.setMiscComments("children and elderly are at risk");
Treatment scorpionStingTr1 = new Treatment("scorpionStingTr1");
scorpionStingTr1.addDrug(LR.antivenin);
scorpionStingTr1.addDrug(LR.calciumGluconate);
scorpionStingTr1.addDrug(LR.phenobarbital);
scorpionStingDis.addTreatment(scorpionStingTr1.getName());
scorpionStingDis.addIllustration(D.ScorpionGif); 



// -------------- skullFracture --------------
// (C) OntoOO Inc Fri Dec 07 08:31:36 PST 2001
Disease skullFractureDis = new Disease(
   LR.skullFracture, 
   "skull fracture", 
   LR.traumas, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.brainSysSt, 
   LR.blowToTheHead
);
skullFractureDis.setPrintName();

skullFractureDis.addSymptom(LR.agitation, "", 1.0f);
skullFractureDis.addSymptom(LR.bleedingSkull, "", 1.0f);
skullFractureDis.addSymptom(LR.cerebrospinalFluidLeakage);
skullFractureDis.addSymptom(LR.consciousnessLoss, "", 1.0f);
skullFractureDis.addSymptom(LR.ecchymosesFace);
skullFractureDis.addSymptom(LR.irritability, "", 1.0f);
skullFractureDis.addSymptom(LR.reflexesDecreased, "", 1.0f);
skullFractureDis.addSymptom(LR.seizure, "", 1.0f);
skullFractureDis.addSymptom(LR.vomiting, "", 1.0f);
skullFractureDis.addCausesDisease(LR.hypertension);

skullFractureDis.addReference("pp 278-81");

Treatment skullFractureTr1 = new Treatment("skullFractureTr1");
skullFractureTr1.addTreatmentAction(LR.IVFluids);
skullFractureTr1.addTreatmentAction(LR.bloodTransfusion);
skullFractureTr1.addTreatmentAction(LR.endotrachealIntubation);
skullFractureTr1.addTreatmentAction(LR.mechanicalVentilation);
skullFractureTr1.addTreatmentAction(LR.craniotomy);
skullFractureTr1.addDrug(LR.analgetics);
skullFractureTr1.addDrug(LR.antibiotics);
skullFractureTr1.addDrug(LR.dexamethasone);
skullFractureDis.addTreatment(skullFractureTr1.getName()); 


// -------------- tickBite --------------
// (C) OntoOO Inc Mon Nov 10 18:49:47 PST 2003
Disease tickBiteDis = new Disease(
   LR.tickBite, 
   "tick bite", 
   LR.traumas, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.tickBiteE
);
tickBiteDis.setPrintName();
tickBiteDis.setTemperature((float)100.3);
tickBiteDis.addSymptom(LR.tickInSkin);
tickBiteDis.addSymptom(LR.itches);
tickBiteDis.addCausesDisease(LR.lymeDisease);
tickBiteDis.addCausesDisease(LR.rockyMountainSpottedFever);
tickBiteDis.addReference("pp 318-9");
Treatment tickBiteTr1 = new Treatment("tickBiteTr1");
tickBiteTr1.addTreatmentAction(LR.removeTick);
tickBiteTr1.addDrug(LR.antipruritics);
tickBiteDis.addTreatment("tickBiteTr1");
Treatment tickBiteTr2 = new Treatment("tickBiteTr2", LR.ifRespiratoryFailure);
tickBiteTr2.addTreatmentAction(LR.mechanicalVentilation);
tickBiteDis.addTreatment("tickBiteTr2");
tickBiteDis.addIllustration(D.TickGif);

  } // end doit()

} // end InitTraumas
