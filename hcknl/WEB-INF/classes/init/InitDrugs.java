// (C) OntoOO/ Dennis de Champeaux  2011 Apr
package init;

// import com.D;
import com.LR;
import com.Common;
// import com.F;
import concepts.*;

public class InitDrugs {
  public static void doit() {
      String [] sideEffects = null;

String acetaminophenOxycodone = LR.acetaminophenOxycodone;
      Drug acetaminophenOxycodoneA = Common.getDrug(acetaminophenOxycodone);
      if ( null == acetaminophenOxycodoneA ) {
	  acetaminophenOxycodoneA = new Drug(acetaminophenOxycodone);
      }
      acetaminophenOxycodoneA.addBrandName("Endocet");
      acetaminophenOxycodoneA.addBrandName("Magnacet");
      acetaminophenOxycodoneA.addBrandName("Percocet");
      acetaminophenOxycodoneA.addBrandName("Primalev");
      acetaminophenOxycodoneA.addBrandName("Primlev");
      acetaminophenOxycodoneA.addBrandName("Roxicet");
      acetaminophenOxycodoneA.addBrandName("Tylox");
      acetaminophenOxycodoneA.addBrandName("Xolox");
      sideEffects = new String [] {
	  LR.dizziness,
	  LR.drowsiness,
	  LR.constipation,
	  LR.mouthDry,
	  LR.nausea,
	  LR.stomachUpset,
	  LR.visionBlurred,
	  LR.vomiting
      };
      acetaminophenOxycodoneA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.appetiteLoss,
	  LR.bradycardia, // heart beat too slow
	  LR.confusion,
	  LR.dysuria, // urination difficult
	  LR.epigastricPain, // upper stomach
	  LR.fainting,
	  LR.hallucinations,
	  LR.itches,
	  LR.jaundice,
	  LR.lightHeadedness,
	  LR.respirationShallow,
	  LR.seizure,
	  LR.stoolClayColored,
	  LR.urineDark
      };
      acetaminophenOxycodoneA.addCriticalSideEffects(sideEffects);



      String alprazolam = LR.alprazolam;
      Drug alprazolamA = Common.getDrug(alprazolam);
      if ( null == alprazolamA ) {
	  alprazolamA = new Drug(alprazolam);
      }
      alprazolamA.addBrandName("Niravam");
      alprazolamA.addBrandName("Xanax");
      sideEffects = new String [] {
	  LR.appetiteLoss,
	  LR.concentrationLoss,
	  LR.constipation,
	  LR.dizziness,
	  LR.drowsiness,
	  LR.dysuria, // urination difficult
	  LR.fatigue,
	  LR.headache,
	  LR.irritability,
	  LR.jointPain,
	  LR.lightHeadedness,
	  LR.mouthDry,
	  LR.nausea,
	  LR.salivation,
	  LR.sexualDesireAbsent,
	  LR.talkative,
	  LR.weightGain,
	  LR.weightLoss
      };
      alprazolamA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.confusion,
	  LR.coordinationDetoriation,
	  LR.dyspnea, // short of breath
	  LR.hallucinations,
	  LR.jaundice,
	  LR.mentalDepression,
	  LR.memoryDetoriation,
	  LR.moodSwings,
	  LR.rash,
	  LR.seizure,
	  LR.speechDifficulty,
	  LR.suicideThoughts
      };
      alprazolamA.addCriticalSideEffects(sideEffects);


      String atenolol = LR.atenolol;
      Drug atenololA = Common.getDrug(atenolol);
      if ( null == atenololA ) {
	  atenololA = new Drug(atenolol);
      }
      atenololA.addBrandName("Senormin");
      atenololA.addBrandName("Tenormin");
      sideEffects = new String [] {
	  LR.diarrhea,
	  LR.dizziness,
	  LR.drowsiness,
	  LR.fatigue,
	  LR.lightHeadedness,
	  LR.mentalDepression,
	  LR.nausea
      };
      atenololA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.dyspnea, // short of breath
	  LR.edemaPeripheral,
	  LR.fainting,
	  LR.weightGain
      };
      atenololA.addCriticalSideEffects(sideEffects);



      String amoxicillin = LR.amoxicillin;
      Drug amoxicillinA = Common.getDrug(amoxicillin);
      if ( null == amoxicillinA ) {
	  amoxicillinA = new Drug(amoxicillin);
      }
      amoxicillinA.addBrandName("Amoxi");
      amoxicillinA.addBrandName("Amoxi Drop");
      amoxicillinA.addBrandName("Amoxicot");
      amoxicillinA.addBrandName("Amoxil");
      amoxicillinA.addBrandName("Biomox");
      amoxicillinA.addSideEffect(LR.diarrhea);
      amoxicillinA.addSideEffect(LR.stomachUpset);
      amoxicillinA.addSideEffect(LR.vomiting);
      amoxicillinA.addCriticalSideEffect(LR.bleedingSpontaneously);
      amoxicillinA.addCriticalSideEffect(LR.bruising);
      amoxicillinA.addCriticalSideEffect(LR.fatigue);
      amoxicillinA.addCriticalSideEffect(LR.jaundice);
      amoxicillinA.addCriticalSideEffect(LR.rash);
      amoxicillinA.addCriticalSideEffect(LR.seizure);
      amoxicillinA.addCriticalSideEffect(LR.skinPale);
      amoxicillinA.addCriticalSideEffect(LR.wheals);



      String azithromycin = LR.azithromycin;
      Drug azithromycinA = Common.getDrug(azithromycin);
      if ( null == azithromycinA ) {
	  azithromycinA = new Drug(azithromycin);
      }
      azithromycinA.addBrandName("Zithromax");
      azithromycinA.addBrandName("Zmax");
      azithromycinA.addSideEffect(LR.diarrhea);
      azithromycinA.addSideEffect(LR.rash);
      azithromycinA.addSideEffect(LR.stomachache);
      azithromycinA.addSideEffect(LR.stomachUpset);
      azithromycinA.addSideEffect(LR.vomiting);
      azithromycinA.addCriticalSideEffect(LR.breathingDifficult);
      azithromycinA.addCriticalSideEffect(LR.dysphagia); // swallowing hard
      azithromycinA.addCriticalSideEffect(LR.edema);
      azithromycinA.addCriticalSideEffect(LR.hoarseness);
      azithromycinA.addCriticalSideEffect(LR.itches);
      azithromycinA.addCriticalSideEffect(LR.jaundice);
      azithromycinA.addCriticalSideEffect(LR.palpitations); // heart rapid irregulat
      azithromycinA.addCriticalSideEffect(LR.wheals);


      String cephalexin = LR.cephalexin;
      Drug cephalexinA = Common.getDrug(cephalexin);
      if ( null == cephalexinA ) {
	  cephalexinA = new Drug(cephalexin);
      }
      cephalexinA.addBrandName("Bioce");
      cephalexinA.addBrandName("Kefle");
      cephalexinA.addBrandName("Keftab");
      cephalexinA.addBrandName("Zartan");
      sideEffects = new String [] {
	  LR.diarrhea,
	  LR.rash,
	  LR.stomachUpset,
	  LR.vomiting
      };
      cephalexinA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.bleedingSpontaneously,
	  LR.breathingDifficult,
	  LR.bruising,
	  LR.dysphagia, // swallowing hard
	  LR.itches,
	  LR.mouthSore,
	  LR.throatSore,
	  LR.wheals,
	  LR.wheezing
      };
      cephalexinA.addCriticalSideEffects(sideEffects);


      String ciprofloxacin = LR.ciprofloxacin;
      Drug ciprofloxacinA = Common.getDrug(ciprofloxacin);
      if ( null == ciprofloxacinA ) {
	  ciprofloxacinA = new Drug(ciprofloxacin);
      }
      ciprofloxacinA.addBrandName("Cipro");
      ciprofloxacinA.addBrandName("Proquin");
      sideEffects = new String [] {
	  LR.diarrhea,
	  LR.headache,
	  LR.heartburn,
	  LR.nausea,
	  LR.stomachache,
	  LR.urinaryUrgency,
	  LR.vomiting
      };
      ciprofloxacinA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.appetiteLoss,
	  LR.anxiety,
	  LR.bleedingSpontaneously,
	  LR.bruising,
	  LR.blister,
	  LR.breathingDifficult,
	  LR.confusion,
	  LR.dizziness,
	  LR.dysphagia, // swallowing hard
	  LR.edema,
	  LR.edemaPeripheral,
	  LR.energyLoss,
	  LR.epigastricPain, // upper stomach
	  LR.faceEdema,
	  LR.faceTingling,
	  LR.fainting,
	  LR.fatigue,
	  LR.hallucinations,
	  LR.hoarseness,
	  LR.itches,
	  LR.jaundice,
	  LR.jointPain,
	  LR.mentalDepression,
	  LR.myalgia, // muscle pain
	  LR.nervousness,
	  LR.nightmares,
	  LR.palpitations,
	  LR.paranoia,
	  LR.rash,
	  LR.restlessness,
	  LR.seizure,
	  LR.shaking,
	  LR.sleepDisturbed,
	  LR.stomachCramps,
	  LR.stoolBloody,
	  LR.stoolWatery,
	  LR.suicideThoughts,
	  LR.throatConstriction,
	  LR.urineDark,
	  LR.weakness,
	  LR.wheals,
	  LR.wheezing
      };
      ciprofloxacinA.addCriticalSideEffects(sideEffects);



      String citalopram = LR.citalopram;
      Drug citalopramA = Common.getDrug(citalopram);
      if ( null == citalopramA ) {
	  citalopramA = new Drug(citalopram);
      }
      citalopramA.addBrandName("Celexa");
      sideEffects = new String [] {
	  LR.appetiteLoss,
	  LR.diaphoresis, // sweating a lot
	  LR.diarrhea,
	  LR.drowsiness,
	  LR.excited,
	  LR.fatigue,
	  LR.feverSym,
	  LR.jointPain,
	  LR.mouthDry,
	  LR.myalgia,  // muscle pain
	  LR.nausea,
	  LR.nervousness,
	  LR.sexualDesireAbsent,
	  LR.shaking,
	  LR.stomachache,
	  LR.vomiting
      };
      citalopramA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.confusion,
	  LR.feverSym,
	  LR.hallucinations,
	  LR.muscleRigid,
	  LR.palpitations,
	  LR.seizure
      };
      citalopramA.addCriticalSideEffects(sideEffects);



      String clonazepam = LR.clonazepam;
      Drug clonazepamA = Common.getDrug(clonazepam);
      if ( null == clonazepamA ) {
	  clonazepamA = new Drug(clonazepam);
      }
      clonazepamA.addBrandName("Ceberclon");
      clonazepamA.addBrandName("Klonopin");
      clonazepamA.addBrandName("Valpax");
      sideEffects = new String [] {
	  LR.coordinationDetoriation,
	  LR.dizziness,
	  LR.drowsiness,
	  LR.jointPain,
	  LR.lossOfBalance,
	  LR.memoryDetoriation,
	  LR.myalgia, // muscle pain
	  LR.salivation,
	  LR.sexualDesireAbsent,
	  LR.thinkingFuzzy,
	  LR.urinaryFrequency,
	  LR.visionBlurred
      };
      clonazepamA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.breathingDifficult,
	  LR.dysphagia, // swallowing hard
	  LR.faceEdema,
	  LR.hoarseness,
	  LR.rash,
	  LR.wheals
      };
      clonazepamA.addCriticalSideEffects(sideEffects);



      String crestor = LR.crestor;
      Drug crestorA = Common.getDrug(crestor);
      if ( null == crestorA ) {	  
	  crestorA = new Drug(crestor);
      }
      crestorA.addBrandName("Rosuvastatin");
      sideEffects = new String [] {
	  LR.constipation,
	  LR.cough,
	  LR.dizziness,
	  LR.heartburn,
	  LR.jointPain,
	  LR.mentalDepression,
	  LR.sleepDisturbed
      };
      crestorA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.abdomenPainUpperRightSide,
	  LR.appetiteLoss,
	  LR.bleedingSpontaneously,
	  LR.breathingDifficult,
	  LR.bruising,
	  LR.chestPain,
	  LR.chills,
	  LR.dysphagia, // swallowing hard
	  LR.edema,
	  LR.edemaPeripheral,
	  LR.energyLoss,
	  LR.exophthalmos, // eyes bulging
	  LR.faceEdema,
	  LR.fatigue,
	  LR.feverSym,
	  LR.fingersNumbness,
	  LR.fingersTingling,
	  LR.hoarseness,
	  LR.itches,
	  LR.jaundice,
	  LR.muscleTender,
	  LR.muscleWeakness,
	  LR.myalgia, // muscle pain
	  LR.nausea,
	  LR.rash,
	  LR.toesNumbness,
	  LR.toesTingling,
	  LR.throatSore,
	  LR.tongueSwollen,
	  LR.wheals
      };
      crestorA.addCriticalSideEffects(sideEffects);



      String cyclobenzaprine = LR.cyclobenzaprine;
      Drug cyclobenzaprineA = Common.getDrug(cyclobenzaprine);
      if ( null == cyclobenzaprineA ) {
	  cyclobenzaprineA = new Drug(cyclobenzaprine);
      }
      cyclobenzaprineA.addBrandName("Fexmid");
      cyclobenzaprineA.addBrandName("Flexeril");
      sideEffects = new String [] {
	  LR.dizziness,
	  LR.drowsiness,
	  LR.mouthDry,
	  LR.stomachUpset
      };
      cyclobenzaprineA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.breathingDifficult,
	  LR.chestPain,
	  LR.dysphagia, // swallowing hard
	  LR.feverSym,
	  LR.rash,
	  LR.faceEdema,
	  LR.seizure,
	  LR.tachycardia, // heart beat fast
	  LR.tongueSwollen
      };
      cyclobenzaprineA.addCriticalSideEffects(sideEffects);


      String diovan = LR.diovan;
      Drug diovanA = Common.getDrug(diovan);
      if ( null == diovanA ) {
	  diovanA = new Drug(diovan);
      }
      diovanA.addBrandName("Valsartan");
      sideEffects = new String [] {
	  LR.backPain,
	  LR.diarrhea,
	  LR.dizziness,
	  LR.fatigue,
	  LR.headache,
	  LR.jointPain,
	  LR.stomachache
      };
      diovanA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.breathingDifficult,
	  LR.dysphagia, // swallowing hard
	  LR.edema,
	  LR.edemaPeripheral,
	  LR.exophthalmos, // eyes bulging
	  LR.faceEdema,
	  LR.fainting,
	  LR.hoarseness,
	  LR.tongueSwollen
      };
      diovanA.addCriticalSideEffects(sideEffects);



      String duloxetine = LR.duloxetine;
      Drug duloxetineA = Common.getDrug(duloxetine);
      if ( null == duloxetineA ) {
	  duloxetineA = new Drug(duloxetine);
      }
      duloxetineA.addBrandName("Cymbalta");
      duloxetineA.addSideEffect(LR.appetiteLoss);
      duloxetineA.addSideEffect(LR.constipation);
      // duloxetineA.addSideEffect(LR.diaphoresis); // sweating a lot
      duloxetineA.addSideEffect(LR.diarrhea);
      duloxetineA.addSideEffect(LR.dizziness);
      duloxetineA.addSideEffect(LR.drowsiness);
      duloxetineA.addSideEffect(LR.dysuria); // urinationDifficult
      duloxetineA.addSideEffect(LR.fatigue);
      duloxetineA.addSideEffect(LR.headache);
      duloxetineA.addSideEffect(LR.heartburn);
      duloxetineA.addSideEffect(LR.mouthDry);
      duloxetineA.addSideEffect(LR.muscleCramps);
      duloxetineA.addSideEffect(LR.myalgia); // muscle pain
      duloxetineA.addSideEffect(LR.nausea);
      duloxetineA.addSideEffect(LR.nightSweating);
      duloxetineA.addSideEffect(LR.sexualDesireAbsent);
      duloxetineA.addSideEffect(LR.shaking);
      duloxetineA.addSideEffect(LR.sleepDisturbed);
      duloxetineA.addSideEffect(LR.somnolence); // sleepy
      duloxetineA.addSideEffect(LR.stomachache);
      duloxetineA.addSideEffect(LR.sweating);
      duloxetineA.addSideEffect(LR.urinaryFrequency);
      duloxetineA.addSideEffect(LR.vomiting);
      duloxetineA.addSideEffect(LR.weakness);
      duloxetineA.addCriticalSideEffect(LR.abdomenBloating);
      duloxetineA.addCriticalSideEffect(LR.bleedingSpontaneously);
      duloxetineA.addCriticalSideEffect(LR.blister);
      duloxetineA.addCriticalSideEffect(LR.breathingDifficult);
      duloxetineA.addCriticalSideEffect(LR.bruising);
      duloxetineA.addCriticalSideEffect(LR.confusion);
      duloxetineA.addCriticalSideEffect(LR.dysphagia); // swallowing hard
      duloxetineA.addCriticalSideEffect(LR.edema);      
      duloxetineA.addCriticalSideEffect(LR.epigastricPain); // upper stomach
      duloxetineA.addCriticalSideEffect(LR.feverSym);
      duloxetineA.addCriticalSideEffect(LR.hoarseness);
      duloxetineA.addCriticalSideEffect(LR.itches);
      duloxetineA.addCriticalSideEffect(LR.jaundice);
      duloxetineA.addCriticalSideEffect(LR.muscleRigid);
      duloxetineA.addCriticalSideEffect(LR.palpitations); // heart rapid irregulat
      duloxetineA.addCriticalSideEffect(LR.rash);
      duloxetineA.addCriticalSideEffect(LR.skinPeeling);
      duloxetineA.addCriticalSideEffect(LR.urineDark);
      duloxetineA.addCriticalSideEffect(LR.visionBlurred);
      duloxetineA.addCriticalSideEffect(LR.wheals);


      String effexor = LR.effexor;
      Drug effexorA = Common.getDrug(effexor);
      if ( null == effexorA ) {
	  effexorA = new Drug(effexor);
      }
      effexorA.addBrandName("Venlafaxine");
      sideEffects = new String [] {
	  LR.appetiteLoss,
	  LR.burping,
	  LR.chills,
	  LR.constipation,
	  LR.diarrhea,
	  LR.dizziness,
	  LR.drowsiness,
	  LR.dysuria, // urinationDifficult
	  LR.fatigue,
	  LR.gas,
	  LR.headache,
	  LR.heartburn,
	  LR.hotFlash,
	  LR.mouthDry,
	  LR.muscleRigid,
	  LR.nausea,
	  LR.nightmares,
	  LR.pupilDilation,
	  LR.sexualDesireAbsent,
	  LR.shaking,
	  LR.skinFlushing,
	  LR.stomachache,
	  LR.sweating,
	  LR.throatSore,
	  LR.tinnitus,
	  LR.twitching,
	  LR.urinaryFrequency,
	  LR.weakness,
	  LR.weightLoss,
	  LR.vomiting
      };
      effexorA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.bleedingSpontaneously,
	  LR.breathingDifficult,
	  LR.bruising,
	  LR.chestPain,
	  LR.consciousnessLoss,
	  LR.coordinationDetoriation,
	  LR.dysphagia, // swallowing hard
	  LR.eyePain,
	  LR.eyeRedness,
	  LR.feverSym,
	  LR.hallucinations,
	  LR.itches,
	  LR.ocularDisturbance, // vision disturbance
	  LR.palpitations,
	  LR.rash,
	  LR.seizure,
	  LR.skinPatchesPurple,
	  LR.wheals
      };
      effexorA.addCriticalSideEffects(sideEffects);



      String fexofenadine = LR.fexofenadine;
      Drug fexofenadineA = Common.getDrug(fexofenadine);
      if ( null == fexofenadineA ) {
	  fexofenadineA = new Drug(fexofenadine);
      }
      fexofenadineA.addBrandName("Allegra");
      sideEffects = new String [] {
	  LR.armPain,
	  LR.backPain,
	  LR.cough,
	  LR.diarrhea,
	  LR.dizziness,
	  LR.headache,
	  LR.legPain,
	  LR.vomiting
      };
      fexofenadineA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.breathingDifficult,
	  LR.dysphagia, // swallowing hard
	  LR.edema,
	  LR.edemaPeripheral,
	  LR.exophthalmos, // eyes bulging
	  LR.faceEdema,
	  LR.itches,
	  LR.hoarseness,
	  LR.rash,
	  LR.tongueSwollen,
	  LR.wheals
      };
      fexofenadineA.addCriticalSideEffects(sideEffects);



      String fluoxetine = LR.fluoxetine;
      Drug fluoxetineA = Common.getDrug(fluoxetine);
      if ( null == fluoxetineA ) {
	  fluoxetineA = new Drug(fluoxetine);
      }
      fluoxetineA.addBrandName("Prozac");
      fluoxetineA.addBrandName("RECONCILE");
      fluoxetineA.addBrandName("Rapiflux");
      fluoxetineA.addBrandName("Sarafem");
      fluoxetineA.addBrandName("Selfemra");
      sideEffects = new String [] {
	  LR.diaphoresis, // sweating a lot
	  LR.drowsiness,
	  LR.mouthDry,
	  LR.nausea,
	  LR.nervousness,
	  LR.sexualDesireAbsent,
	  LR.shaking,
	  LR.throatSore,
	  LR.weakness,
	  LR.weightLoss
      };
      fluoxetineA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.appetiteLoss,
	  LR.breathingDifficult,
	  LR.confusion,
	  LR.dysphagia, // swallowing hard
	  LR.edema,
	  LR.edemaPeripheral,
	  LR.exophthalmos, // eyes bulging
	  LR.hallucinations,
	  LR.muscleRigid,
	  LR.feverSym,
	  LR.jointPain,
	  LR.palpitations,
	  LR.rash,
	  LR.seizure,
	  LR.sweating,
	  LR.wheals
      };
      fluoxetineA.addCriticalSideEffects(sideEffects);


      String fluticasone = LR.fluticasone;
      Drug fluticasoneA = Common.getDrug(fluticasone);
      if ( null == fluticasoneA ) {
	  fluticasoneA = new Drug(fluticasone);
      }
      fluticasoneA.addBrandName("Flonase");
      sideEffects = new String [] {
	  LR.bleedingFromNose,
	  LR.cough,
	  LR.diarrhea,
	  LR.dizziness,
	  LR.headache,
	  LR.nausea,
	  LR.noseDischarge,
	  LR.noseItches,
	  LR.stomachache,
	  LR.vomiting
      };
      fluticasoneA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.acne,
	  LR.bruising,
	  LR.faceEdema,
	  LR.fatigue,
	  LR.muscleWeakness,
	  LR.neckEdema,
	  LR.noseWhitePatches,
	  LR.rash,
	  LR.throatSore,
	  LR.throatWhitePatches,
	  LR.visionDefect,
	  LR.wheals
      };
      fluticasoneA.addCriticalSideEffects(sideEffects);



      String furosemide = LR.furosemide;
      Drug furosemideA = Common.getDrug(furosemide);
      if ( null == furosemideA ) {
	  furosemideA = new Drug(furosemide);
      }
      furosemideA.addBrandName("Delone");
      furosemideA.addBrandName("Furocot");
      furosemideA.addBrandName("Lasix");
      furosemideA.addBrandName("Lo-Aqua");
      sideEffects = new String [] {
	  LR.confusion,
	  LR.constipation,
	  LR.dizziness,
	  LR.headache,
	  LR.muscleCramps,
	  LR.restlessness,
	  LR.stomachUpset,
	  LR.thirstExcessive,
	  LR.visionBlurred,
	  LR.vomiting,
	  LR.weakness
      };
      furosemideA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.bleedingSpontaneously,
	  LR.breathingDifficult,
	  LR.bruising,
	  LR.dysphagia, // swallowing hard
	  LR.feverSym,
	  LR.hearingLoss,
	  LR.rash,
	  LR.skinPeeling,
	  LR.throatSore,
	  LR.tinnitus,
	  LR.weightLoss
      };
      furosemideA.addCriticalSideEffects(sideEffects);


      String gabapentin = LR.gabapentin;
      Drug gabapentinA = Common.getDrug(gabapentin);
      if ( null == gabapentinA ) {
	  gabapentinA = new Drug(gabapentin);
      }
      gabapentinA.addBrandName("Fanatrex");
      gabapentinA.addBrandName("Gabarone");
      gabapentinA.addBrandName("Neurontin");
      sideEffects = new String [] {
	  LR.anxiety,
	  LR.backPain,
	  LR.constipation,
	  LR.cough,
	  LR.diarrhea,
	  LR.diplopia, // double vision
	  LR.dizziness,
	  LR.drowsiness,
	  LR.earache,
	  LR.edemaPeripheral,
	  LR.eyeRedness,
	  LR.fatigue,
	  LR.feverSym,
	  LR.headache,
	  LR.heartburn,
	  LR.jointPain,
	  LR.lossOfBalance,
	  LR.memoryDetoriation,
	  LR.mouthDry,
	  LR.nausea,
	  LR.noseDischarge,
	  LR.nystagmus, // eye movements unwanted
	  LR.shaking,
	  LR.sneezing,
	  LR.thoughtsDisturbing,
	  LR.throatSore,
	  LR.visionBlurred,
	  LR.vomiting,
	  LR.weakness,
	  LR.weightGain
      };
      gabapentinA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.breathingDifficult,
	  LR.dysphagia, // swallowing hard
	  LR.itches,
	  LR.edema,
	  LR.faceEdema,
	  LR.hoarseness,
	  LR.rash,
	  LR.seizure
      };
      gabapentinA.addCriticalSideEffects(sideEffects);


      String hydrochlorothiazide = LR.hydrochlorothiazide;
      Drug hydrochlorothiazideA = Common.getDrug(hydrochlorothiazide);
      if ( null == hydrochlorothiazideA ) {
	  hydrochlorothiazideA = new Drug(hydrochlorothiazide);
      }
      hydrochlorothiazideA.addBrandName("Hydrodiuril");
      hydrochlorothiazideA.addBrandName("Ezide"); 
      hydrochlorothiazideA.addBrandName("HydroPar");
      hydrochlorothiazideA.addBrandName("Microzide");
      sideEffects = new String [] {
	  LR.appetiteLoss, 
	  LR.diarrhea,
	  LR.dizziness,
	  LR.hairLoss,
	  LR.headache,
	  LR.muscleWeakness,
	  LR.nausea,
	  LR.stomachache,
	  LR.thirst,
	  LR.vomiting
	     };
      hydrochlorothiazideA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.bleedingSpontaneously,
	  LR.breathingDifficult,
	  LR.bruising,
	  LR.dysphagia, // swallowing hard
	  LR.feverSym,
	  LR.rash,
	  LR.skinPeeling,
	  LR.throatSore
      };
      hydrochlorothiazideA.addCriticalSideEffects(sideEffects);


      String hydrocodoneAcetaminophen = LR.hydrocodoneAcetaminophen;
      Drug hydrocodoneA = Common.getDrug(hydrocodoneAcetaminophen);
      if ( null == hydrocodoneA ) {
	  hydrocodoneA = new Drug(hydrocodoneAcetaminophen);
      }
      hydrocodoneA.addBrandName("Vicodin");
      hydrocodoneA.addBrandName("Lortab");
      sideEffects = new String [] {
	  LR.anxiety,
	  LR.constipation,
	  LR.dizziness,
	  LR.drowsiness,
	  LR.dysuria, //urinationDifficult
	  LR.itches,
	  LR.lightHeadedness,
	  LR.moodSwings,
	  LR.nausea,
	  LR.pupilNarrowing,
	  LR.rash,
	  LR.thinkingFuzzy,
	  LR.throatDry,
	  LR.vomiting,
      };
      hydrocodoneA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.apnea, // breathing stops intermittently
	  LR.bradypnea, // breathing slowed
	  LR.chestTightness
      };
      hydrocodoneA.addCriticalSideEffects(sideEffects);


      String ibuprofen = LR.ibuprofen;
      Drug ibuprofenA = Common.getDrug(ibuprofen);
      if ( null == ibuprofenA ) {
	  ibuprofenA = new Drug(ibuprofen);
      }
      ibuprofenA.addBrandName("Advil");
      ibuprofenA.addBrandName("Motrin");
      sideEffects = new String [] {
	  LR.bloating,
	  LR.constipation,
	  LR.diarrhea,
	  LR.dizziness,
	  LR.gas,
	  LR.nervousness,
	  LR.tinnitus
      };
      ibuprofenA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.aggression,
	  LR.appetiteLoss,
	  LR.backPain,
	  LR.blister,
	  LR.breathingDifficult,
	  LR.confusion,
	  LR.dysphagia, // swallowing hard
	  LR.dysuria, // urination difficult
	  LR.edema,
	  LR.edemaPeripheral,
	  LR.epigastricPain, // upper stomach
	  LR.eyePain,
	  LR.eyeRedness,
	  LR.fatigue,
	  LR.feverSym,
	  LR.headache,
	  LR.hematuria, // urineWithBlood
	  LR.hoarseness,
	  LR.itches,
	  LR.jaundice,
	  LR.nausea,
	  LR.neckStiff,
	  LR.rash,
	  LR.skinPale,
	  LR.tachycardia, // heart beat fast
	  LR.urineCloudy,
	  LR.urineDark,
	  LR.visionBlurred,
	  LR.weightGain,
	  LR.wheals
      };
      ibuprofenA.addCriticalSideEffects(sideEffects);


      String levothyroxine = LR.levothyroxine;
      Drug levothyroxineA = Common.getDrug(levothyroxine);
      if ( null == levothyroxineA ) {
	  levothyroxineA = new Drug(levothyroxine);
      }
      levothyroxineA.addBrandName("Eltroxin");
      levothyroxineA.addBrandName("Euthyrox");
      levothyroxineA.addBrandName("Levo-T");
      levothyroxineA.addBrandName("Levotabs");
      levothyroxineA.addSideEffect(LR.appetiteIncrease);
      levothyroxineA.addSideEffect(LR.diaphoresis);
      levothyroxineA.addSideEffect(LR.diarrhea);
      levothyroxineA.addSideEffect(LR.feverSym);
      levothyroxineA.addSideEffect(LR.headache);
      levothyroxineA.addSideEffect(LR.heatSensitivity);
      levothyroxineA.addSideEffect(LR.irritability);
      levothyroxineA.addSideEffect(LR.nausea);
      levothyroxineA.addSideEffect(LR.nervousness);
      levothyroxineA.addSideEffect(LR.sleepDisturbed);
      levothyroxineA.addSideEffect(LR.stomachCramps);
      levothyroxineA.addSideEffect(LR.tremors);
      levothyroxineA.addSideEffect(LR.vomiting);
      levothyroxineA.addSideEffect(LR.weightLoss);
      levothyroxineA.addCriticalSideEffect(LR.chestPain);
      levothyroxineA.addCriticalSideEffect(LR.palpitations);
      levothyroxineA.addCriticalSideEffect(LR.tachycardia);


      String lexapro = LR.lexapro;
      Drug lexaproA = Common.getDrug(lexapro);
      if ( null == lexaproA ) {
	  lexaproA = new Drug(lexapro);
      }
      lexaproA.addBrandName("Escitalopram");
      sideEffects = new String [] {
	  LR.appetiteIncrease,
	  LR.constipation,
	  LR.diaphoresis,
	  LR.diarrhea,
	  LR.dizziness,
	  LR.drowsiness,
	  LR.fatigue,
	  LR.feverSym,
	  LR.heartburn,
	  LR.mouthDry,
	  LR.nausea,
	  LR.noseDischarge,
	  LR.sexualDesireAbsent,
	  LR.sneezing,
	  LR.stomachache
      };
      lexaproA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.confusion,
	  LR.excited,
	  LR.feverSym,
	  LR.hallucinations,
	  LR.muscleRigid,
	  LR.palpitations,
	  LR.sweating
      };
      lexaproA.addCriticalSideEffects(sideEffects);


      String lipitor = LR.lipitor;
      Drug lipitorA = Common.getDrug(lipitor);
      if ( null == lipitorA ) {
	  lipitorA = new Drug(lipitor);
      }
      lipitorA.addBrandName("Atorvastatin");
      lipitorA.addSideEffect(LR.diarrhea);
      lipitorA.addSideEffect(LR.constipation);
      lipitorA.addSideEffect(LR.gas);
      lipitorA.addSideEffect(LR.headache);
      lipitorA.addSideEffect(LR.jointPain);
      lipitorA.addCriticalSideEffect(LR.appetiteLoss);
      lipitorA.addCriticalSideEffect(LR.bleedingSpontaneously);
      lipitorA.addCriticalSideEffect(LR.breathingDifficult);
      lipitorA.addCriticalSideEffect(LR.bruising);
      lipitorA.addCriticalSideEffect(LR.chestPain);
      lipitorA.addCriticalSideEffect(LR.dysphagia); // swallowing hard
      lipitorA.addCriticalSideEffect(LR.edema);
      lipitorA.addCriticalSideEffect(LR.epigastricPain); // upper stomach
      lipitorA.addCriticalSideEffect(LR.fatigue);
      lipitorA.addCriticalSideEffect(LR.feverSym);
      lipitorA.addCriticalSideEffect(LR.hoarseness);
      lipitorA.addCriticalSideEffect(LR.itches);
      lipitorA.addCriticalSideEffect(LR.jaundice);
      lipitorA.addCriticalSideEffect(LR.muscleTender);
      lipitorA.addCriticalSideEffect(LR.muscleWeakness);
      lipitorA.addCriticalSideEffect(LR.myalgia); // muscle pain
      lipitorA.addCriticalSideEffect(LR.nausea);
      lipitorA.addCriticalSideEffect(LR.rash);
      lipitorA.addCriticalSideEffect(LR.wheals);


      String lisinopril = LR.lisinopril;
      Drug lisinoprilA = Common.getDrug(lisinopril);
      if ( null == lisinoprilA ) {
	  lisinoprilA = new Drug(lisinopril);
      }
      lisinoprilA.addBrandName("Prinivil");
      lisinoprilA.addBrandName("Zestril");
      lisinoprilA.addSideEffect(LR.cough);
      lisinoprilA.addSideEffect(LR.diarrhea);
      lisinoprilA.addSideEffect(LR.dizziness);
      lisinoprilA.addSideEffect(LR.headache);
      lisinoprilA.addSideEffect(LR.fatigue);
      lisinoprilA.addSideEffect(LR.nausea);
      lisinoprilA.addSideEffect(LR.noseDischarge);
      lisinoprilA.addSideEffect(LR.rash);
      lisinoprilA.addSideEffect(LR.sexualDesireAbsent);
      lisinoprilA.addSideEffect(LR.sneezing);
      lisinoprilA.addSideEffect(LR.weakness);
      lisinoprilA.addCriticalSideEffect(LR.breathingDifficult);
      lisinoprilA.addCriticalSideEffect(LR.chestPain);
      lisinoprilA.addCriticalSideEffect(LR.chills);
      lisinoprilA.addCriticalSideEffect(LR.dysphagia); // swallowing hard
      lisinoprilA.addCriticalSideEffect(LR.edema);
      lisinoprilA.addCriticalSideEffect(LR.fainting);
      lisinoprilA.addCriticalSideEffect(LR.feverSym);
      lisinoprilA.addCriticalSideEffect(LR.hoarseness);
      lisinoprilA.addCriticalSideEffect(LR.jaundice);
      lisinoprilA.addCriticalSideEffect(LR.lightHeadedness);
      lisinoprilA.addCriticalSideEffect(LR.throatSore);


      String lovastatin = LR.lovastatin;
      Drug lovastatinA = Common.getDrug(lovastatin);
      if ( null == lovastatinA ) {
	  lovastatinA = new Drug(lovastatin);
      }
      lovastatinA.addBrandName("Altocor");
      lovastatinA.addBrandName("Altoprev");
      lovastatinA.addBrandName("Mevacor");
      sideEffects = new String [] {
	  LR.constipation
      };
      lovastatinA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.appetiteLoss,
	  LR.bleedingSpontaneously,
	  LR.breathingDifficult,
	  LR.bruising,
	  LR.dysphagia, // swallowing hard
	  LR.edema,
	  LR.edemaPeripheral,
	  LR.epigastricPain, // upper stomach
	  LR.exophthalmos, // eyes bulging
	  LR.faceEdema,
	  LR.fatigue,
	  LR.feverSym,
	  LR.hoarseness,
	  LR.itches,
	  LR.jaundice,
	  LR.muscleTender,
	  LR.muscleWeakness,
	  LR.myalgia, // muscle pain
	  LR.nausea,
	  LR.rash,
	  LR.tongueSwollen,
	  LR.wheals
      };
      lovastatinA.addCriticalSideEffects(sideEffects);



      String lorazepam = LR.lorazepam;
      Drug lorazepamA = Common.getDrug(lorazepam);
      if ( null == lorazepamA ) {
	  lorazepamA = new Drug(lorazepam);
      }
      lorazepamA.addBrandName("Ativan");
      sideEffects = new String [] {
	  LR.appetiteIncrease, 
	  LR.appetiteLoss, 
	  LR.constipation,
	  LR.diarrhea,
	  LR.dizziness,
	  LR.drowsiness,
	  LR.dysuria, // urinationDifficult
	  LR.excited,
	  LR.fatigue,
	  LR.mouthDry,
	  LR.nausea,
	  LR.restlessness,
	  LR.sexualDesireAbsent,
	  LR.urinaryFrequency,
	  LR.visionBlurred,
	  LR.weakness
      };
      lorazepamA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.arrhythmia, // heart beat irregular
	  LR.breathingDifficult,
	  LR.dysphagia, // swallowing hard
	  LR.feverSym,
	  LR.jaundice,
	  LR.rash,
	  LR.tremors,
	  LR.walkingTrouble,
      };
      lorazepamA.addCriticalSideEffects(sideEffects);


      String metformin = LR.metformin;
      Drug metforminA = Common.getDrug(metformin);
      if ( null == metforminA ) {
	  metforminA = new Drug(metformin);
      }
      metforminA.addBrandName("Fortamet");
      metforminA.addBrandName("Glucophage");
      metforminA.addBrandName("Glumetza");
      sideEffects = new String [] {
	  LR.bloating,
	  LR.constipation,
	  LR.cough,
	  LR.diarrhea,
	  LR.dizziness,
	  LR.gas,
	  LR.headache,
	  LR.heartburn,
	  LR.irritability,
	  LR.lightHeadedness,
	  LR.moodSwings,
	  LR.mouthNumbness,
	  LR.mouthTasteMetallic,
	  LR.mouthTingling,
	  LR.movementsJerky,
	  LR.myalgia,  // muscle pain
	  LR.nervousness,
	  LR.noseDischarge,
	  LR.shaking,
	  LR.skinFlushing,
	  LR.skinPale,
	  LR.sneezing,
	  LR.stomachache,
	  LR.sweating,
	  LR.weakness
      };
      metforminA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.breathFruity,
	  LR.chestPain,
	  LR.confusion,
	  LR.consciousnessDecreased,
	  LR.consciousnessLoss,
	  LR.dyspnea, // short of breath
	  LR.hungerExcessive,
	  LR.mouthDry,
	  LR.nausea,
	  LR.rash,
	  LR.seizure,
	  LR.thirstExcessive,
	  LR.urinaryFrequency,
	  LR.visionBlurred,
	  LR.vomiting
      };
      metforminA.addCriticalSideEffects(sideEffects);


      String metoprolol = LR.metoprolol;
      Drug metoprololA = Common.getDrug(metoprolol);
      if ( null == metoprololA ) {
	  metoprololA = new Drug(metoprolol);
      }
      metoprololA.addBrandName("Lopressor");
      metoprololA.addBrandName("Toprol");
      sideEffects = new String [] {
	  LR.bloating,
	  LR.constipation,
	  LR.dizziness,
	  LR.fatigue,
	  LR.feetCold,
	  LR.gas,
	  LR.handCold,
	  LR.heartburn,
	  LR.itches,
	  LR.lightHeadedness,
	  LR.mentalDepression,
	  LR.mouthDry,
	  LR.nausea,
	  LR.noseDischarge,
	  LR.stomachache,
	  LR.rash,
	  LR.vomiting
      };
      metoprololA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.dyspnea, // short of breath
	  LR.edemaPeripheral,
	  LR.fainting,
	  LR.palpitations,
	  LR.weightGain,
	  LR.wheezing
      };
      metoprololA.addCriticalSideEffects(sideEffects);


      String nexium = LR.nexium;
      Drug nexiumA = Common.getDrug(nexium);
      if ( null == nexiumA ) {
	  nexiumA = new Drug(nexium);
      }
      nexiumA.addBrandName("Esomeprazole");
      sideEffects = new String [] {
	  LR.constipation,
	  LR.diarrhea,
	  LR.headache,
	  LR.gas,
	  LR.mouthDry,
	  LR.nausea,
	  LR.stomachache
      };
      nexiumA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.blister,
	  LR.breathingDifficult,
	  LR.dysphagia, // swallowing hard
	  LR.edema,
	  LR.edemaPeripheral,
	  LR.hoarseness,
	  LR.itches,
	  LR.rash,
	  LR.skinPeeling,
	  LR.wheals
      };
      nexiumA.addCriticalSideEffects(sideEffects);


      String omeprazole = LR.omeprazole;
      Drug omeprazoleA = Common.getDrug(omeprazole);
      if ( null == omeprazoleA ) {
	  omeprazoleA = new Drug(omeprazole);
      }
      omeprazoleA.addBrandName("Losec");
      omeprazoleA.addBrandName("Omesec");
      omeprazoleA.addBrandName("Prilosec");
      sideEffects = new String [] {
	  LR.constipation,
	  LR.diarrhea,
	  LR.feverSym,
	  LR.gas,
	  LR.headache,
	  LR.nausea,
	  LR.stomachache,
	  LR.vomiting
      };
      omeprazoleA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.breathingDifficult,
	  LR.dysphagia, // swallowing hard
	  LR.edema,
	  LR.hoarseness,
	  LR.itches,
	  LR.rash,
	  LR.wheals
      };
      omeprazoleA.addCriticalSideEffects(sideEffects);


      String oxycodone = LR.oxycodone;
      Drug oxycodoneA = Common.getDrug(oxycodone);
      if ( null == oxycodoneA ) {
	  oxycodoneA = new Drug(oxycodone);
      }
      oxycodoneA.addBrandName("Dazidox");
      oxycodoneA.addBrandName("Endocodone");
      oxycodoneA.addBrandName("ETH-Oxydose");
      sideEffects = new String [] {
	  LR.appetiteLoss,
	  LR.constipation,
	  LR.drowsiness,
	  LR.eyeRedness,
	  LR.headache,
	  LR.itches,
	  LR.lightHeadedness,
	  LR.moodSwings,
	  LR.mouthDry,
	  LR.nausea,
	  LR.pupilNarrowing,
	  LR.skinFlushing,
	  LR.sweating,
	  LR.vomiting,
	  LR.weakness
      };
      oxycodoneA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.bradycardia, // heart beat too slow
	  LR.breathingDifficult,
	  LR.confusion,
	  LR.consciousnessLoss,
	  LR.dizziness,
	  LR.dysphagia, // swallowing hard
	  LR.edema,
	  LR.edemaPeripheral,
	  LR.fainting,
	  LR.hallucinations,
	  LR.hoarseness,
	  LR.hypoventilation, // breathing too slow
	  LR.rash,
	  LR.seizure,
	  LR.tachycardia, // heart beat fast
	  LR.wheals
      };
      oxycodoneA.addCriticalSideEffects(sideEffects);


      String paroxetine = LR.paroxetine;
      Drug paroxetineA = Common.getDrug(paroxetine);
      if ( null == paroxetineA ) {
	  paroxetineA = new Drug(paroxetine);
      }
      paroxetineA.addBrandName("Paxil");
      paroxetineA.addBrandName("Pexeva");
      sideEffects = new String [] {
	  LR.appetiteLoss,
	  LR.backPain,
	  LR.concentrationLoss,
	  LR.confusion,
	  LR.constipation,
	  LR.cough,
	  LR.diarrhea,
	  LR.dizziness,
	  LR.forgetfulness,
	  LR.flushing,
	  LR.gas,
	  LR.headache,
	  LR.heartburn,
	  LR.jointPain,
	  LR.mouthDry,
	  LR.muscleRigid,
	  LR.muscleWeakness,
	  LR.myalgia, // muscle pain
	  LR.nausea,
	  LR.nervousness,
	  LR.nightmares,
	  LR.noseDischarge,
	  LR.photophobia, // light avoidance
	  LR.sexualDesireAbsent,
	  LR.somnolence, // sleepy
	  LR.stomachache,
	  LR.sweating,
	  LR.teethSore,
	  LR.throatConstriction,
	  LR.vomiting,
	  LR.weakness,
	  LR.weightGain,
	  LR.weightLoss,
	  LR.yawning
      };
      paroxetineA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.bleedingSpontaneously,
	  LR.breathingDifficult,
	  LR.bruising,
	  LR.chestPain,
	  LR.chills,
	  LR.confusion,
	  LR.dysphagia, // swallowing hard
	  LR.dysuria, // urinationDifficult
	  LR.edema,
	  LR.edemaPeripheral,
	  LR.fainting,
	  LR.feverSym,
	  LR.hallucinations,
	  LR.hoarseness,
	  LR.itches,
	  LR.limbsNumbness,
	  LR.limbsTingling,
	  LR.motorDysfunction,
	  LR.muscleRigid,
	  LR.palpitations,
	  LR.rash,
	  LR.seizure,
	  LR.shaking,
	  LR.skinPatchesPurple,
	  LR.stoolBlack,
	  LR.stoolBloody,
	  LR.stoolTarry,
	  LR.sweating,
	  LR.throatSore,
	  LR.twitching,
	  LR.urinaryFrequency,
	  LR.urinationPainful,
	  LR.vomitBloody,
	  LR.visionBlurred,
	  LR.wheals
      };
      paroxetineA.addCriticalSideEffects(sideEffects);



      String plavix = LR.plavix;
      Drug plavixA = Common.getDrug(plavix);
      if ( null == plavixA ) {
	  plavixA = new Drug(plavix);
      }
      plavixA.addBrandName("Clopidogre");
      sideEffects = new String [] {
	  LR.diarrhea,
	  LR.dizziness,
	  LR.bleedingFromNose,
	  LR.fatigue,
	  LR.headache,
	  LR.nausea,
	  LR.stomachache,
      };
      plavixA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.bleedingSpontaneously,
	  LR.breathingDifficult,
	  LR.bruising,
	  LR.confusion,
	  LR.dysphagia, // swallowing hard
	  LR.dyspnea, // short of breath
	  LR.edema,
	  LR.edemaPeripheral,
	  LR.feverSym,
	  LR.hoarseness,
	  LR.itches,
	  LR.jaundice,
	  LR.limbsNumbness,
	  LR.limbsWeak,
	  LR.rash,
	  LR.skinPale,
	  LR.skinPatchesPurple,
	  LR.speechDifficulty,
	  LR.stoolBlack,
	  LR.stoolBloody,
	  LR.stoolTarry,
	  LR.tachycardia, // heart beat fast
	  LR.visionLoss,
	  LR.vomitBlack,
	  LR.vomitBloody,
	  LR.wheals
      };
      plavixA.addCriticalSideEffects(sideEffects);


      String prednisone = LR.prednisone;
      Drug prednisoneA = Common.getDrug(prednisone);
      if ( null == prednisoneA ) {
	  prednisoneA = new Drug(prednisone);
      }
      prednisoneA.addBrandName("Deltasone");
      prednisoneA.addBrandName("Liquid Pred");
      prednisoneA.addBrandName("Meticorten");
      prednisoneA.addBrandName("Orasone");
      sideEffects = new String [] {
	  LR.acne,
	  LR.diaphoresis,  // sweating a lot
	  LR.dizziness,
	  LR.exophthalmos, // eyes bulging
	  LR.fatigue,
	  LR.hairGrowthIncrease,
	  LR.headache,
	  LR.heartburn,
	  LR.moodSwings,
	  LR.muscleWeakness,
	  LR.personalityChange,
	  LR.sexualDesireAbsent,
	  LR.skinPatchesPurple,
	  LR.sleepDisturbed,
      };
      prednisoneA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.arrhythmia, // heart beat irregular
	  LR.breathingDifficult,
	  LR.chills,
	  LR.confusion,
	  LR.coughDry,
	  LR.coughHacking,
	  LR.dysphagia, // swallowing hard
	  LR.dyspnea, // short of breath
	  LR.edema,
	  LR.edemaPeripheral,
	  LR.eyeExudate,
	  LR.eyePain,
	  LR.eyeRedness,
	  LR.faceBurningPain,
	  LR.faceNumbness,
	  LR.faceTingling,
	  LR.feverSym,
	  LR.itches,
	  LR.lightHeadedness,
	  LR.limbsBurning,
	  LR.limbsNumbness,
	  LR.limbsTingling,
	  LR.mentalDepression,
	  LR.muscleRigid,
	  LR.ocularDisturbance, // vision disturbance
	  LR.rash,
	  LR.seizure,
	  LR.shaking,
	  LR.stomachache,
	  LR.stomachSwelling,
	  LR.stomachUpset,
	  LR.throatSore,
	  LR.twitching,
	  LR.unrealityFeeling,
	  LR.vomiting,
	  LR.weightGain,
	  LR.wheals
      };
      prednisoneA.addCriticalSideEffects(sideEffects);

      String pregabalin = LR.pregabalin;
      Drug pregabalinA = Common.getDrug(pregabalin);
      if ( null == pregabalinA ) {
	  pregabalinA = new Drug(pregabalin);
      }
      pregabalinA.addBrandName("Lyrica");
      sideEffects = new String [] {
	  LR.anxiety,
	  LR.appetiteIncrease,
	  LR.backPain,
	  LR.bloating,
	  LR.concentrationLoss,
	  LR.confusion,
	  LR.constipation,
	  LR.coordinationDetoriation,
	  LR.dizziness,
	  LR.edemaPeripheral,
	  LR.excited,
	  LR.fatigue,
	  LR.forgetfulness,
	  LR.gas,
	  LR.headache,
	  LR.lossOfBalance,
	  LR.memoryDetoriation,
	  LR.mouthDry,
	  LR.movementsJerky,
	  LR.nausea,
	  LR.shaking,
	  LR.speechDifficulty,
	  LR.tetany, // muscles contraction unwanted ~~ twitching
	  LR.vomiting,
	  LR.weakness,
	  LR.weightGain
      };
      pregabalinA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.blister,
	  LR.chestPain,
	  LR.diplopia, // double vision
	  LR.dyspnea, // short of breath
	  LR.exophthalmos, // eyes bulging
	  LR.faceEdema,
	  LR.gumsSwollen,
	  LR.headSwollen,
	  LR.itches,
	  LR.lipsSwollen,
	  LR.mouthSwollen,
	  LR.muscleTender,
	  LR.muscleWeakness,
	  LR.myalgia, // muscle pain
	  LR.neckEdema,
	  LR.ocularDisturbance,
	  LR.rash,
	  LR.throatConstriction,
	  LR.tongueSwollen,
	  LR.urticaria,
	  LR.visionBlurred,
	  LR.wheezing
      };
      pregabalinA.addCriticalSideEffects(sideEffects);

      String prevacid = LR.prevacid;
      Drug prevacidA = Common.getDrug(prevacid);
      if ( null == prevacidA ) {
	  prevacidA = new Drug(prevacid);
      }
      prevacidA.addBrandName("Lansoprazole");
      sideEffects = new String [] {
	  LR.constipation,
	  LR.diarrhea,
	  LR.dizziness,
	  LR.headache,
	  LR.nausea,
	  LR.stomachache
      };
      prevacidA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.blister,
	  LR.breathingDifficult,
	  LR.dysphagia, // swallowing hard
	  LR.edema,
	  LR.exophthalmos, // eyes bulging
	  LR.faceEdema,
	  LR.hoarseness,
	  LR.rash,
	  LR.skinPeeling,
	  LR.tongueSwollen,
	  LR.wheals
      };
      prevacidA.addCriticalSideEffects(sideEffects);


      String sertraline = LR.sertraline;
      Drug sertralineA = Common.getDrug(sertraline);
      if ( null == sertralineA ) {
	  sertralineA = new Drug(sertraline);
      }
      sertralineA.addBrandName("Zoloft");
      sideEffects = new String [] {
	  LR.appetiteLoss,
	  LR.bloating,
	  LR.constipation,
	  LR.diaphoresis,  // sweating a lot
	  LR.diarrhea,
	  LR.dizziness,
	  LR.drowsiness,
	  LR.fatigue,
	  LR.feetPain,
	  LR.gas,
	  LR.handBurning,
	  LR.handTingling,
	  LR.headache,
	  LR.nervousness,
	  LR.mouthDry,
	  LR.nausea,
	  LR.sexualDesireAbsent,
	  LR.shaking,
	  LR.throatSore,
	  LR.vomiting,
	  LR.weightGain,
	  LR.weightLoss
      };
      sertralineA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.bleedingSpontaneously,
	  LR.bruising,
	  LR.confusion,
	  LR.hallucinations,
	  LR.muscleRigid,
	  LR.palpitations,
	  LR.seizure,
	  LR.sweating,
	  LR.visionBlurred
      };
      sertralineA.addCriticalSideEffects(sideEffects);


      String simvastatin = LR.simvastatin;
      Drug simvastatinA = Common.getDrug(simvastatin);
      if ( null == simvastatinA ) {
	  simvastatinA = new Drug(simvastatin);
      }
      simvastatinA.addBrandName("Zocor");
      simvastatinA.addSideEffect(LR.constipation);
      // simvastatinA.addSideEffect(LR.dyspepsia); // indigestion
      simvastatinA.addSideEffect(LR.headache);
      simvastatinA.addSideEffect(LR.nausea);
      // simvastatinA.addSideEffect(LR.sleepDisturbed); // insomnia
      // simvastatinA.addSideEffect(LR.sneezing);
      simvastatinA.addSideEffect(LR.stomachache);
      // simvastatinA.addSideEffect(LR.throatSore);

      // simvastatinA.addCriticalSideEffect(LR.anuria); // urination absent
      // simvastatinA.addCriticalSideEffect(LR.appetiteLoss);
      simvastatinA.addCriticalSideEffect(LR.blister);
      simvastatinA.addCriticalSideEffect(LR.breathingDifficult);
      simvastatinA.addCriticalSideEffect(LR.chills);
      simvastatinA.addCriticalSideEffect(LR.dysphagia); // swallowing hard
      // simvastatinA.addCriticalSideEffect(LR.dysuria); // urinationDifficult
      simvastatinA.addCriticalSideEffect(LR.edema);
      // simvastatinA.addCriticalSideEffect(LR.epigastricPain); // upper stomach
      simvastatinA.addCriticalSideEffect(LR.fatigue);
      simvastatinA.addCriticalSideEffect(LR.feverSym);
      simvastatinA.addCriticalSideEffect(LR.hoarseness);
      simvastatinA.addCriticalSideEffect(LR.itches);
      // simvastatinA.addCriticalSideEffect(LR.jaundice);
      simvastatinA.addCriticalSideEffect(LR.jointPain);
      simvastatinA.addCriticalSideEffect(LR.muscleTender);
      simvastatinA.addCriticalSideEffect(LR.muscleWeakness);
      simvastatinA.addCriticalSideEffect(LR.myalgia); // muscle pain
      simvastatinA.addCriticalSideEffect(LR.photophobia); // light avoidance
      simvastatinA.addCriticalSideEffect(LR.rash);
      simvastatinA.addCriticalSideEffect(LR.skinFlushing);
      // simvastatinA.addCriticalSideEffect(LR.stoolClayColored);
      simvastatinA.addCriticalSideEffect(LR.urineDark);
      simvastatinA.addCriticalSideEffect(LR.weakness);
      simvastatinA.addCriticalSideEffect(LR.wheals);
      // simvastatinA.addCriticalSideEffect(LR.weightGain);


      String singulair = LR.singulair;
      Drug singulairA = Common.getDrug(singulair);
      if ( null == singulairA ) {
	  singulairA = new Drug(singulair);
      }
      singulairA.addBrandName("Montelukast");
      sideEffects = new String [] {
	  LR.dizziness,
	  LR.fatigue,
	  LR.headache,
	  LR.heartburn,
	  LR.stomachache
      };
      singulairA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.breathingDifficult,
	  LR.dysphagia, // swallowing hard
	  LR.edema,
	  LR.edemaPeripheral,
	  LR.feverSym,
	  LR.hoarseness,
	  LR.itches,
	  LR.limbsNumbness,
	  LR.limbsPinsAndNeedles,
	  LR.rash,
	  LR.sinusPain,
	  LR.sinusSwelling,
	  LR.wheals
      };
      singulairA.addCriticalSideEffects(sideEffects);


      String synthroid = LR.synthroid;
      Drug synthroidA = Common.getDrug(synthroid);
      if ( null == synthroidA ) {
	  synthroidA = new Drug(synthroid);
      }
      synthroidA.addBrandName("Levothyroxine");
      sideEffects = new String [] {
	  LR.appetiteIncrease,
	  LR.diaphoresis,  // sweating a lot
	  LR.diarrhea,
	  LR.feverSym,
	  LR.headache,
	  LR.heatSensitivity,
	  LR.irritability,
	  LR.nausea,
	  LR.nervousness,
	  LR.sleepDisturbed,
	  LR.stomachCramps,
	  LR.tremors,
	  LR.vomiting,
	  LR.weightLoss
      };
      synthroidA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.chestPain,
	  LR.palpitations
      };
      synthroidA.addCriticalSideEffects(sideEffects);


      String tramadol = LR.tramadol;
      Drug tramadolA = Common.getDrug(tramadol);
      if ( null == tramadolA ) {
	  tramadolA = new Drug(tramadol);
      }
      tramadolA.addBrandName("Rybix");
      tramadolA.addBrandName("Ryzolt");
      tramadolA.addBrandName("Ultram");
      sideEffects = new String [] {
	  LR.agitation,
	  LR.chills,
	  LR.constipation,
	  LR.diarrhea,
	  LR.dizziness,
	  LR.drowsiness,
	  LR.dyspepsia, // indigestion
	  LR.headache,
	  LR.heartburn,
	  LR.itches,
	  LR.moodSwings,
	  LR.mouthDry,
	  LR.muscleRigid,
	  LR.nausea,
	  LR.nervousness,
	  LR.shaking,
	  LR.sleepDisturbed,
	  LR.somnolence, // sleepy
	  LR.sweating,
	  LR.vomiting,
	  LR.weakness
      };
      tramadolA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.breathingDifficult,
	  LR.dysphagia, // swallowing hard
	  LR.edema,
	  LR.edemaPeripheral,
	  LR.faceEdema,
	  LR.hallucinations,
	  LR.hoarseness,
	  LR.mouthSore,
	  LR.rash,
	  LR.seizure,
	  LR.throatSore,
	  LR.wheals
      };
      tramadolA.addCriticalSideEffects(sideEffects);


      String trazodone = LR.trazodone;
      Drug trazodoneA = Common.getDrug(trazodone);
      if ( null == trazodoneA ) {
	  trazodoneA = new Drug(trazodone);
      }
      trazodoneA.addBrandName("Desyrel");
      trazodoneA.addBrandName("Oleptro");
      sideEffects = new String [] {
	  LR.concentrationLoss,
	  LR.confusion,
	  LR.constipation,
	  LR.diarrhea,
	  LR.eyeRedness,
	  LR.fatigue,
	  LR.headache,
	  LR.memoryDetoriation,
	  LR.mouthDry,
	  LR.myalgia, // muscle pain
	  LR.nausea,
	  LR.nervousness,
	  LR.nightmares,
	  LR.stomachache,
	  LR.sweating,
	  LR.tinnitus,
	  LR.visionBlurred,
	  LR.vomiting,
	  LR.weakness
      };
      trazodoneA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.breathingDifficult,
	  LR.chestPain,
	  LR.chills,
	  LR.coordinationDetoriation,
	  LR.dizziness,
	  LR.dysphagia, // swallowing hard
	  LR.dyspnea, // short of breath
	  LR.edema,
	  LR.edemaPeripheral,
	  LR.exophthalmos, // eyes bulging
	  LR.faceEdema,
	  LR.fainting,
	  LR.feverSym,
	  LR.hoarseness,
	  LR.itches,
	  LR.lightHeadedness,
	  LR.palpitations,
	  LR.rash,
	  LR.shaking,
	  LR.throatSore,
	  LR.tongueSwollen,
	  LR.wheals
      };
      trazodoneA.addCriticalSideEffects(sideEffects);


      String triamterene = LR.triamterene;
      Drug triamtereneA = Common.getDrug(triamterene);
      if ( null == triamtereneA ) {
	  triamtereneA = new Drug(triamterene);
      }
      triamtereneA.addBrandName("Dyrenium");
      sideEffects = new String [] {
	  LR.dizziness,
	  LR.headache,
	  LR.vomiting
      };
      triamtereneA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.appetiteLoss,
	  LR.bleedingSpontaneously,
	  LR.breathingDifficult,
	  LR.bruising,
	  LR.dysphagia,  // swallowing hard
	  LR.energyLoss,
	  LR.epigastricPain, // upper stomach
	  LR.fatigue,
	  LR.jaundice,
	  LR.mouthDry,
	  LR.muscleCramps,
	  LR.muscleWeakness,
	  LR.diarrhea,
	  LR.rash,
	  LR.stomachUpset,
	  LR.throatSore,
      };
      triamtereneA.addCriticalSideEffects(sideEffects);


      String trimethoprim = LR.trimethoprim;
      Drug trimethoprimA = Common.getDrug(trimethoprim);
      if ( null == trimethoprimA ) {
	  trimethoprimA = new Drug(trimethoprim);
      }
      trimethoprimA.addBrandName("Proloprim");
      trimethoprimA.addBrandName("Trimpex");
      sideEffects = new String [] {
	  LR.diarrhea,
	  LR.stomachUpset,
	  LR.vomiting
      };
      trimethoprimA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.bleedingSpontaneously,
	  LR.breathingDifficult,
	  LR.bruising,
	  LR.chills,
	  LR.dysphagia, // swallowing hard
	  LR.feverSym,
	  LR.fingerNailsBlue,
	  LR.itches,
	  LR.jaundice,
	  LR.jointPain,
	  LR.lipsBlue,
	  LR.mouthSore,
	  LR.rash,
	  LR.cyanosis, // skin blue,
	  LR.skinPale,
	  LR.throatSore,
	  LR.wheals
      };
      trimethoprimA.addCriticalSideEffects(sideEffects);



      String warfarin = LR.warfarin;
      Drug warfarinA = Common.getDrug(warfarin);
      if ( null == warfarinA ) {
	  warfarinA = new Drug(warfarin);
      }
      warfarinA.addBrandName("Coumadin");
      warfarinA.addBrandName("Jantoven");
      warfarinA.addBrandName("Marfarin");
      sideEffects = new String [] {
	  LR.chills,
	  LR.fatigue,
	  LR.feelingCold,
	  LR.hairLoss,
	  LR.gas,
	  LR.skinPale
      };
      warfarinA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.appetiteLoss, 
	  LR.breathingDifficult,
	  LR.chestPain,
	  LR.diarrhea,
	  LR.dysphagia, // swallowing hard
	  LR.edema,
	  LR.edemaPeripheral,
	  LR.epigastricPain, // upper stomach
	  LR.exophthalmos, // eyes bulging
	  LR.faceEdema,
	  LR.feverSym,
	  LR.hoarseness,
	  LR.itches,
	  LR.jointPain,
	  LR.jaundice,
	  LR.motorDysfunction,
	  LR.myalgia, // muscle pain
	  LR.nausea,
	  LR.rash,
	  LR.skinBurning,
	  LR.skinNumbness,
	  LR.skinPricking,
	  LR.skinTingling,
	  LR.vomiting,
	  LR.wheals
      };
      warfarinA.addCriticalSideEffects(sideEffects);



      String zolpidem = LR.zolpidem;
      Drug zolpidemA = Common.getDrug(zolpidem);
      if ( null == zolpidemA ) {
	  zolpidemA = new Drug(zolpidem);
      }
      zolpidemA.addBrandName("Ambien");
      zolpidemA.addBrandName("Edluar");
      sideEffects = new String [] {
	  LR.appetiteLoss,
	  LR.backPain,
	  LR.constipation,
	  LR.diarrhea,
	  LR.dizziness,
	  LR.drowsiness,
	  LR.eyeRedness,
	  LR.gas,
	  LR.handBurning,
	  LR.handTingling,
	  LR.heartburn,
	  LR.headache,
	  LR.jointPain,
	  LR.lossOfBalance,
	  LR.menstruationProfuse,
	  LR.motorDysfunction,
	  LR.mouthDry,
	  LR.muscleCramps,
	  LR.myalgia,
	  LR.neckPain,
	  LR.shaking,
	  LR.stomachache,
	  LR.tinnitus,
	  LR.throatSore,
	  LR.weakness
      };
      zolpidemA.addSideEffects(sideEffects);
      sideEffects = new String [] {
	  LR.breathingDifficult,
	  LR.chestPain,
	  LR.dyspnea, // short of breath
	  LR.dysphagia, // swallowing hard
	  LR.edema,
	  LR.hoarseness,
	  LR.itches,
	  LR.nausea,
	  LR.rash,
	  LR.tachycardia, // heart beat fast
	  LR.throatConstriction,
	  LR.visionBlurred,
	  LR.vomiting,
	  LR.wheals
      };
      zolpidemA.addCriticalSideEffects(sideEffects);

  } // end doit
} // end InitDrugs
/*
      String zzz = LR.zzz;
      Drug zzzA = Common.getDrug(zzz);
      if ( null == zzzA ) {
	  zzzA = new Drug(zzz);
      }
      zzzA.addBrandName("===");
      sideEffects = new String [] {
      };
      zzzA.addSideEffects(sideEffects);
      sideEffects = new String [] {
      };
      zzzA.addCriticalSideEffects(sideEffects);
 */
