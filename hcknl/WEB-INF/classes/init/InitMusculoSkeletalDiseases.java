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

public class InitMusculoSkeletalDiseases {
  public static void doit() {

      /*  See InitImmuneDiseases

// -------------- arthritis --------------
// (C) OntoOO Inc Sun Mar 30 08:46:53 PST 2003
Disease arthritisDis = new Disease(
   LR.arthritis, 
   "a family of  joint problems", 
   LR.musculoDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.jointsSysSt, 
   LR.none
);
arthritisDis.addReference("HealthWise pp 115-7");
arthritisDis.setMiscComments("** temp entry");
      */

// -------------- carpalTunnelSyndrome --------------
// (C) OntoOO Inc Thu May 01 17:27:26 PDT 2003
Disease carpalTunnelSyndromeDis = new Disease(
   LR.carpalTunnelSyndrome, 
   "repetitive stress injury of nerves in the wrist", 
   LR.musculoDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   60,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.wristsSysSt, 
   LR.none
);
carpalTunnelSyndromeDis.setPrintName("carpal tunnel syndrome");
carpalTunnelSyndromeDis.addSymptom(LR.handBurning);
carpalTunnelSyndromeDis.addSymptom(LR.handNumbness);
carpalTunnelSyndromeDis.addSymptom(LR.handPain); 
carpalTunnelSyndromeDis.addSymptom(LR.handTingling);
carpalTunnelSyndromeDis.addSymptom(LR.handWeak); 
carpalTunnelSyndromeDis.addReference("pp 594-6");
Treatment carpalTunnelSyndromeTr1 = new Treatment("carpalTunnelSyndromeTr1");
carpalTunnelSyndromeTr1.addTreatmentAction(LR.wristSplint);
carpalTunnelSyndromeDis.addTreatment("carpalTunnelSyndromeTr1");
Treatment carpalTunnelSyndromeTr2 = new Treatment("carpalTunnelSyndromeTr2");
carpalTunnelSyndromeTr2.addTreatmentAction(LR.surgery);
carpalTunnelSyndromeDis.addTreatment(carpalTunnelSyndromeTr2.getName()); 


// -------------- gout --------------
// (C) OntoOO Inc Tue Mar 16 15:24:00 PST 2004
Disease goutDis = new Disease(
   LR.gout, 
   "metabolic deficiency causing urate deposits producing painful arthritis joints", 
   LR.musculoDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.jointsSysSt, 
   LR.none
);
goutDis.setSuperDisease(LR.arthritis);
goutDis.addSymptom(LR.backPain, "", 0.2f);
goutDis.addSymptom(LR.jointRedness);
goutDis.addSymptom(LR.jointHot);
goutDis.addSymptom(LR.jointTender);
goutDis.addCausesDisease(LR.hypertension);
goutDis.addCausesDisease(LR.renalCalculi);
goutDis.addReference("pp 567-70");
goutDis.setMiscComments(
   "primary gout in men over 30 and postmenopausal woman, secondary gout in the elderly");
Treatment goutTr1  = new Treatment("goutTr1");
goutTr1.addTreatmentAction(LR.bedRest);
goutTr1.addDrug(LR.analgetics);
goutDis.addTreatment(goutTr1.getName());


// -------------- halluxValgus --------------
// (C) OntoOO Inc Wed May 07 21:30:42 PDT 2003
Disease halluxValgusDis = new Disease(
   LR.halluxValgus, 
   "solid growth at the base of a large toe at the inside of a foot", 
   LR.skeletalDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.largeToesSysSt, 
   LR.none
);
halluxValgusDis.setPrintName("hallux valgus");
halluxValgusDis.addSymptom(LR.bunion);
halluxValgusDis.addReference("pp 582-3");
Treatment halluxValgusTr1  = new Treatment("halluxValgusTr1", LR.ifSevere);
halluxValgusTr1.addTreatmentAction(LR.surgery);
halluxValgusDis.addTreatment(halluxValgusTr1.getName());


// -------------- herniatedDisk --------------
// (C) OntoOO Inc Sun Mar 30 15:34:41 PST 2003
Disease herniatedDiskDis = new Disease(
   LR.herniatedDisk, 
   "damaged disk that pinges on spine nerves", 
   LR.musculoDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.musculoSkeletalSysSt, 
   LR.trauma
);
herniatedDiskDis.setPrintName("herniated disk");
herniatedDiskDis.addSymptom(LR.buttockPain, "", 1.0f);
herniatedDiskDis.addSymptom(LR.feetPain, "", 1.0f);
herniatedDiskDis.addSymptom(LR.legPain, "", 1.0f);
herniatedDiskDis.addSymptom(LR.hipPain, "", 1.0f);
herniatedDiskDis.addSymptom(LR.lowBackPain, "", 1.0f);
herniatedDiskDis.addSymptom(LR.spasm, "", 0.3f);
herniatedDiskDis.addCausingAbnormalCondition(LR.spineJointDegeneration);
herniatedDiskDis.addReference("pp 585-7");
Treatment herniatedDiskTr1 = new Treatment("herniatedDiskTr1");
herniatedDiskTr1.addTreatmentAction(LR.exercise);
herniatedDiskTr1.addDrug(LR.aspirin);
herniatedDiskTr1.addDrug(LR.diazepam);
herniatedDiskTr1.addDrug(LR.methocarbamol);
herniatedDiskDis.addTreatment("herniatedDiskTr1");
Treatment herniatedDiskTr2 = new Treatment("herniatedDiskTr2", LR.ifSevere);
herniatedDiskTr2.addTreatmentAction(LR.surgery);
herniatedDiskDis.addTreatment(herniatedDiskTr2.getName()); 



// -------------- kyphoscoliosis --------------
// (C) OntoOO Inc Wed Jun 19 13:37:44 PDT 2002
Disease kyphoscoliosisDis = new Disease(
   LR.kyphoscoliosis, 
   "progressive deformity of the spine consisting of lateral and posterior curvatures.", 
   LR.skeletalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.spineSysSt, 
   LR.none
);
kyphoscoliosisDis.addSymptom(LR.spineDeformation);
kyphoscoliosisDis.setWebResource(
   "http://www.meddean.luc.edu/lumen/MedEd/medicine/pulmonar/diseases/pul22.htm");
kyphoscoliosisDis.addCausingAbnormalCondition(LR.hypoxia);
kyphoscoliosisDis.addCausesDisease(LR.corPulmonale);
kyphoscoliosisDis.addReference("pp 587-91");



// -------------- kyphosis --------------
// (C) OntoOO Inc Fri Dec 26 17:12:31 PST 2003
Disease kyphosisDis = new Disease(
   LR.kyphosis, 
   "curving of the spine yielding a bowing of the back", 
   LR.skeletalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.spineSysSt, 
   LR.infection
);
kyphosisDis.addSymptom(LR.roundback);
kyphosisDis.addInternalCause(LR.ankylosingSpondylitis);
kyphosisDis.addInternalCause(LR.osteoporosis);
kyphosisDis.addReference("pp 583-5");
Treatment kyphosisTr1 = new Treatment("kyphosisTr1");
kyphosisTr1.addTreatmentAction(LR.exercise);
kyphosisTr1.addTreatmentAction(LR.surgery);
kyphosisDis.addTreatment("kyphosisTr1");


// -------------- muscularDystrophy --------------
// (C) OntoOO Inc Wed Jan 02 13:04:44 PST 2002
Disease muscularDystrophyDis = new Disease(
   LR.muscularDystrophy, 
   "loss of skeletal muscles without neural defects", 
   LR.musculoDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.muscleSysSt, 
   LR.none
);
muscularDystrophyDis.addReference("pp 563-5");
muscularDystrophyDis.setMiscComments(
   "there are four variants with different life expectancies");


// -------------- muscularDystrophyDuchenne --------------
// (C) OntoOO Inc Wed Aug 11 13:21:32 GMT-08:00 2004
Disease muscularDystrophyDuchenneDis = new Disease(
   LR.muscularDystrophyDuchenne, 
   "loss of skeletal muscles without neural defects Duchenne variant", 
   LR.musculoDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   3, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.muscleSysSt, 
   LR.none
);
muscularDystrophyDuchenneDis.setPrintName("muscular dystrophy Duchenne");
muscularDystrophyDuchenneDis.setSuperDisease(LR.muscularDystrophy);
muscularDystrophyDuchenneDis.setGenetic("1parent");
muscularDystrophyDuchenneDis.setParentDisease(LR.muscularDystrophyDuchenne);
muscularDystrophyDuchenneDis.addSymptom(LR.fatigue);
muscularDystrophyDuchenneDis.addSymptom(LR.muscleContractions);
muscularDystrophyDuchenneDis.addSymptom(LR.muscleWeakness);
muscularDystrophyDuchenneDis.addSymptom(LR.walkingTrouble);
muscularDystrophyDuchenneDis.addSymptom(LR.waddle);
muscularDystrophyDuchenneDis.addSymptom(LR.lordosis);
muscularDystrophyDuchenneDis.addCausesDisease(LR.heartFailure);
muscularDystrophyDuchenneDis.addCausesDisease(LR.respiratoryFailureAcute);
muscularDystrophyDuchenneDis.addReference("pp 563-5");
muscularDystrophyDuchenneDis.setMiscComments("usually patients die by age 20");


// -------------- muscularDystrophyBecker --------------
// (C) OntoOO Inc Wed Aug 11 14:37:34 GMT-08:00 2004
Disease muscularDystrophyBeckerDis = new Disease(
   LR.muscularDystrophyBecker, 
   "loss of skeletal muscles without neural defects Becker variant", 
   LR.musculoDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.muscleSysSt, 
   LR.none
);
muscularDystrophyBeckerDis.setPrintName("muscular dystrophy Becker");
muscularDystrophyBeckerDis.setSuperDisease(LR.muscularDystrophy);
muscularDystrophyBeckerDis.setGenetic("1parent");
muscularDystrophyBeckerDis.setParentDisease(LR.muscularDystrophyBecker);
muscularDystrophyBeckerDis.addSymptom(LR.fatigue);
muscularDystrophyBeckerDis.addSymptom(LR.lossOfBalance);
muscularDystrophyBeckerDis.addSymptom(LR.muscleContractions, "", 1.0f);
muscularDystrophyBeckerDis.addSymptom(LR.muscleWeakness, "", 1.0f);
muscularDystrophyBeckerDis.addSymptom(LR.walkingTrouble, "", 1.0f);
muscularDystrophyBeckerDis.addSymptom(LR.waddle, "", 1.0f);
// muscularDystrophyBeckerDis.addSymptom(LR.lordosis);
muscularDystrophyBeckerDis.addCausesDisease(LR.heartFailure);
muscularDystrophyBeckerDis.addCausesDisease(LR.respiratoryFailureAcute);
muscularDystrophyBeckerDis.addReference("pp 563-5");
muscularDystrophyBeckerDis.setMiscComments("usually patients die by age 50");


// -------------- muscularDystrophyFacioscapulahumeral --------------
// (C) OntoOO Inc Thu Aug 12 13:34:15 GMT-08:00 2004
Disease muscularDystrophyFacioscapulahumeralDis = new Disease(
   LR.muscularDystrophyFacioscapulahumeral, 
   "slow loss of skeletal muscles without neural defects facioscapulahumeral variant", 
   LR.musculoDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   8, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.muscleSysSt, 
   LR.none
);
muscularDystrophyFacioscapulahumeralDis.setPrintName(
     "muscular dystrophy facioscapulahumeral");
muscularDystrophyFacioscapulahumeralDis.setSuperDisease(LR.muscularDystrophy);
muscularDystrophyFacioscapulahumeralDis.setGenetic("1parent");
muscularDystrophyFacioscapulahumeralDis.setParentDisease(
     LR.muscularDystrophyFacioscapulahumeral);
muscularDystrophyFacioscapulahumeralDis.addSymptom(LR.muscleWeakness, "", 1.0f);
muscularDystrophyFacioscapulahumeralDis.addSymptom(LR.lipLowerHanging);
muscularDystrophyFacioscapulahumeralDis.addSymptom(LR.faceMovementsAbnormal);
muscularDystrophyFacioscapulahumeralDis.addSymptom(LR.nasolabialFoldAbsent);
muscularDystrophyFacioscapulahumeralDis.addSymptom(LR.armWeakness);
muscularDystrophyFacioscapulahumeralDis.addReference("pp 563-5");


// -------------- muscularDystrophyLimbGirdle --------------
// (C) OntoOO Inc Mon Aug 16 15:39:19 GMT-08:00 2004
Disease muscularDystrophyLimbGirdleDis = new Disease(
   LR.muscularDystrophyLimbGirdle, 
   "slow loss of skeletal muscles without neural defects limb girdle variant", 
   LR.musculoDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   6, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.muscleSysSt, 
   LR.none
);
muscularDystrophyLimbGirdleDis.setPrintName("muscular dystrophy limb girdle");
muscularDystrophyLimbGirdleDis.setSuperDisease(LR.muscularDystrophy);
muscularDystrophyLimbGirdleDis.setGenetic("1parent");
muscularDystrophyLimbGirdleDis.setParentDisease(LR.muscularDystrophyLimbGirdle);
muscularDystrophyLimbGirdleDis.addSymptom(LR.muscleWeakness, "", 1.0f);
muscularDystrophyLimbGirdleDis.addSymptom(LR.lordosis);
muscularDystrophyLimbGirdleDis.addSymptom(LR.lossOfBalance);
muscularDystrophyLimbGirdleDis.addSymptom(LR.waddle);
muscularDystrophyLimbGirdleDis.addSymptom(LR.armWeakness);
muscularDystrophyLimbGirdleDis.addReference("pp 563-5");


// -------------- osteoarthritis --------------
// (C) OntoOO Inc Sun Mar 30 14:19:09 PST 2003
Disease osteoarthritisDis = new Disease(
   LR.osteoarthritis, 
   "detoriation of joint cartilage and formation of reactive new bone at the margins of the joints", 
   LR.musculoDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.musculoSkeletalSysSt, 
   LR.none
);
osteoarthritisDis.setSuperDisease(LR.arthritis);
osteoarthritisDis.addSymptom(LR.stiffness);
osteoarthritisDis.addReference("pp 571-4");
Treatment osteoarthritisTr1 = new Treatment("osteoarthritisTr1");
osteoarthritisTr1.addTreatmentAction(LR.massage);
osteoarthritisTr1.addDrug(LR.acetaminophen);
osteoarthritisDis.addTreatment("osteoarthritisTr1");
Treatment osteoarthritisTr2 = new Treatment("osteoarthritisTr2", LR.ifSevere);
osteoarthritisTr2.addTreatmentAction(LR.surgery);
osteoarthritisDis.addTreatment(osteoarthritisTr2.getName()); 


// -------------- osteoporosis --------------
// (C) OntoOO Inc Wed Jan 02 12:43:15 PST 2002
Disease osteoporosisDis = new Disease(
   LR.osteoporosis, 
   "loss of bone mass", 
   LR.skeletalDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   50, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skeletalSysSt, 
   LR.none
);

osteoporosisDis.addSymptom(LR.backPain, "", 1.0f);
osteoporosisDis.addSymptom(LR.heightLoss, "", 1.0f);

osteoporosisDis.addExternalCause(LR.lackOfCalciumInDiet); 
osteoporosisDis.addExternalCause(LR.sedentaryLifestyle); 
osteoporosisDis.addInternalCause(LR.menopause);
osteoporosisDis.addInternalCause(LR.celiacDisease);
osteoporosisDis.addCausesDisease(LR.kyphosis);
osteoporosisDis.addReference("pp 576-7");

Treatment osteoporosisTr1 = new Treatment("osteoporosisTr1");
osteoporosisTr1.addDrug(LR.estrogen);
osteoporosisTr1.addDrug(LR.sodiumFluoride);
osteoporosisTr1.addDrug(LR.vitaminD);
osteoporosisDis.addTreatment(osteoporosisTr1.getName());
osteoporosisDis.setCode358(317);
osteoporosisDis.setICD10code("M80");
 
  } // end doit()

} // end InitMusculoSkeletalDiseases
