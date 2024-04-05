// (C) OntoOO Inc 2002
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

public class InitPsychiatricDiseases  {
  public static void doit() {

// -------------- anorexiaNervosa --------------
// (C) OntoOO Inc Mon Apr 21 11:14:54 PDT 2003
Disease anorexiaNervosaDis = new Disease(
   LR.anorexiaNervosa, 
   "self imposed starvation due to a distorted body image and " +
   "an irrational fear of gaining weight", 
   LR.psychiatricDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mindSysSt, 
   LR.none
);
anorexiaNervosaDis.setPrintName("anorexia nervosa");
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
anorexiaNervosaDis.addSymptom(LR.weightLoss, "", 1.0f);
anorexiaNervosaDis.addSymptom(LR.reflexesDecreased);
anorexiaNervosaDis.addSymptom(LR.ritualistic, "", 0.3f);
anorexiaNervosaDis.addCausesDisease(LR.amenorrhea);
anorexiaNervosaDis.addCausesDisease(LR.infertilityFemale);
anorexiaNervosaDis.addReference("pp 480-3");
anorexiaNervosaDis.setMiscComments("19 in 20 are female");
Treatment anorexiaNervosaTr1 = new Treatment("anorexiaNervosaTr1");
anorexiaNervosaTr1.addTreatmentAction(LR.behaviorTherapy);
anorexiaNervosaTr1.addTreatmentAction(LR.weightIncrease);
anorexiaNervosaTr1.addTreatmentAction(LR.hospitalization);
anorexiaNervosaTr1.addDrug(LR.vitaminSupplements);
anorexiaNervosaDis.addTreatment("anorexiaNervosaTr1");


// -------------- attentionDeficitHyperactivityDisorder --------------
// (C) OntoOO Inc Mon Jan 27 17:44:47 PST 2003
Disease attentionDeficitHyperactivityDisorderDis = new Disease(
   LR.attentionDeficitHyperactivityDisorder, 
   "difficulty focussing attention and/or engaging in quiet passive activities", 
   LR.psychiatricDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.brainSysSt, 
   LR.none
);
attentionDeficitHyperactivityDisorderDis.setPrintName(
   "attention deficit hyperactivity disorder");
attentionDeficitHyperactivityDisorderDis.setGenetic("1parent");
attentionDeficitHyperactivityDisorderDis.setParentDisease(
   LR.attentionDeficitHyperactivityDisorder);
attentionDeficitHyperactivityDisorderDis.addSymptom(LR.concentrationLoss);
attentionDeficitHyperactivityDisorderDis.addSymptom(LR.daydreaming);
attentionDeficitHyperactivityDisorderDis.addSymptom(LR.fidgeting);
attentionDeficitHyperactivityDisorderDis.addSymptom(LR.impulsive);
attentionDeficitHyperactivityDisorderDis.addSymptom(LR.inattention);
attentionDeficitHyperactivityDisorderDis.addReference("pp 416-8");
Treatment attentionDeficitHyperactivityDisorderTr1 = 
   new Treatment("attentionDeficitHyperactivityDisorderTr1");
attentionDeficitHyperactivityDisorderTr1.addTreatmentAction(LR.behaviorTherapy);
attentionDeficitHyperactivityDisorderDis.addTreatment(
   attentionDeficitHyperactivityDisorderTr1.getName()); 


// -------------- bulimiaNervosa --------------
// (C) OntoOO Inc Sun Apr 20 15:38:06 PDT 2003
Disease bulimiaNervosaDis = new Disease(
   LR.bulimiaNervosa, 
   "eating binges followed by feelings of guilt humiliation and " + 
   "self-deprecation leading to self-induced vomiting laxatives " +
   "fasting strict dieting ...", 
   LR.psychiatricDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mindSysSt, 
   LR.none
);
bulimiaNervosaDis.setPrintName("bulimia nervosa");
bulimiaNervosaDis.addSymptom(LR.bingeEating);
bulimiaNervosaDis.addSymptom(LR.hyperactivity, "", 0.5f);
bulimiaNervosaDis.addSymptom(LR.bodyImageDistorted, "", 0.5f);
bulimiaNervosaDis.addCausesDisease(LR.amenorrhea);
bulimiaNervosaDis.addReference("pp  477-9");
bulimiaNervosaDis.setMiscComments("9 in 10 are female");
Treatment bulimiaNervosaTr1  = new Treatment("bulimiaNervosaTr1");
bulimiaNervosaTr1.addTreatmentAction(LR.behaviorTherapy);
bulimiaNervosaTr1.addDrug(LR.antidepressants);
bulimiaNervosaDis.addTreatment(bulimiaNervosaTr1.getName());


// -------------- depression --------------
// (C) OntoOO Inc Sun Apr 14 18:21:35 PDT 2002
Disease depressionDis = new Disease(
   LR.depression, 
   "persistent sad mood with disturbance of sleep and appetite, " + 
   "lethargy and pleasure inhibited ", 
   LR.psychiatricDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   10, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mindSysSt, 
   LR.none
);
depressionDis.addSymptom(LR.agitation, "provided not apathetic", 0.2f);
depressionDis.addSymptom(LR.angry, "", 0.4f);
depressionDis.addSymptom(LR.anxiety, "", 0.4f);
depressionDis.addSymptom(LR.apathy, "provided not agitated", 0.5f);
depressionDis.addSymptom(LR.appetiteIncrease, "or appetite loss", 0.2f);
depressionDis.addSymptom(LR.appetiteLoss, "or appetite increase", 0.2f);
depressionDis.addSymptom(LR.concentrationLoss, "", 0.4f);
depressionDis.addSymptom(LR.dailyActivityUninteresting);
depressionDis.addSymptom(LR.constipation, "or diarrhea", 0.2f);
depressionDis.addSymptom(LR.diarrhea, "or constipation", 0.2f);
depressionDis.addSymptom(LR.indecisive, "", 0.4f);
depressionDis.addSymptom(LR.moodSad);
depressionDis.addSymptom(LR.selfDoubt, "", 0.5f);
depressionDis.addSymptom(LR.sexualDesireAbsent, "", 0.4f);
depressionDis.addSymptom(LR.sleepDisturbed, "", 0.4f);
depressionDis.addSymptom(LR.unhappy, "", 0.5f);
depressionDis.addInternalCause(LR.multipleSclerosis);
depressionDis.addInternalCause(LR.nephroticSyndrome);
depressionDis.addInternalCause(LR.pancreasCancer);
depressionDis.addInternalCause(LR.posttraumaticStressDisorder);
depressionDis.addReference("pp 446-50");
Treatment depressionTr1 = new Treatment("depressionTr1");
depressionTr1.addTreatmentAction(LR.psychologicalCounseling);
depressionTr1.addTreatmentAction(LR.electroconvulsiveTherapy);
depressionTr1.addDrug(LR.antidepressants);
depressionDis.addTreatment(depressionTr1.getName()); 


// -------------- generalizedAnxiety --------------
// (C) OntoOO Inc Tue Apr 16 17:37:56 PDT 2002
Disease generalizedAnxietyDis = new Disease(
   LR.generalizedAnxiety, 
   "persistent uncontrollable and unreasonable worry that " +
   "interferes with normal functioning", 
   LR.psychiatricDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mindSysSt, 
   LR.none
);
generalizedAnxietyDis.setPrintName("generalized anxiety");
generalizedAnxietyDis.addSymptom(LR.angry, "if not fearful", 0.2f);
generalizedAnxietyDis.addSymptom(LR.anxiety, "", 1.0f);
generalizedAnxietyDis.addSymptom(LR.fearful, "if not angry", 0.2f);
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
generalizedAnxietyDis.setMiscComments(
   "no physical or environmental cause for the anxiety can be identified");  
generalizedAnxietyDis.addReference("pp 452-4");
Treatment generalizedAnxietyTr1  = new Treatment("generalizedAnxietyTr1");
generalizedAnxietyTr1.addTreatmentAction(LR.psychologicalCounseling);
generalizedAnxietyTr1.addDrug(LR.antidepressants);
generalizedAnxietyTr1.addDrug(LR.benzodiazepines);
generalizedAnxietyTr1.addDrug(LR.buspirone);
generalizedAnxietyDis.addTreatment(generalizedAnxietyTr1.getName());


// -------------- generalizedAnxietyMild --------------
// (C) OntoOO Inc Tue Apr 16 19:46:55 PDT 2002
Disease generalizedAnxietyMildDis = new Disease(
   LR.generalizedAnxietyMild, 
   "mild persistent uncontrollable and unreasonable worry " +
   "that interferes with normal functioning", 
   LR.psychiatricDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mindSysSt, 
   LR.none
);
generalizedAnxietyMildDis.setPrintName("generalized anxiety mild");
generalizedAnxietyMildDis.setSuperDisease(LR.generalizedAnxiety);
generalizedAnxietyMildDis.addCausesDisease(LR.generalizedAnxietyModerate);
generalizedAnxietyMildDis.addCausesDisease(LR.generalizedAnxietySevere);
generalizedAnxietyMildDis.addReference("pp 452-4");
generalizedAnxietyMildDis.setMiscComments(
   "no physical or environmental cause for the anxiety can be identified");


// -------------- generalizedAnxietyModerate --------------
// (C) OntoOO Inc Tue Apr 16 21:31:52 PDT 2002
Disease generalizedAnxietyModerateDis = new Disease(
   LR.generalizedAnxietyModerate, 
   "moderate persistent uncontrollable and unreasonable worry " +
   "that interferes with normal functioning", 
   LR.psychiatricDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mindSysSt, 
   LR.none
);
generalizedAnxietyModerateDis.setPrintName("generalized anxiety moderate");
generalizedAnxietyModerateDis.setSuperDisease(LR.generalizedAnxiety);
generalizedAnxietyModerateDis.addSymptom(LR.inattention);
generalizedAnxietyModerateDis.addInternalCause(LR.generalizedAnxietyMild);
generalizedAnxietyModerateDis.addCausesDisease(LR.generalizedAnxietySevere);

generalizedAnxietyModerateDis.addReference("pp 452-4");
generalizedAnxietyModerateDis.setMiscComments(
   "no physical or environmental cause for the anxiety can be identified");


// -------------- generalizedAnxietySevere --------------
// (C) OntoOO Inc Tue Apr 16 21:48:52 PDT 2002
Disease generalizedAnxietySevereDis = new Disease(
   LR.generalizedAnxietySevere, 
   "severe persistent uncontrollable and unreasonable worry " +
   "that interferes with normal functioning", 
   LR.psychiatricDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mindSysSt, 
   LR.none
);
generalizedAnxietySevereDis.setPrintName("generalized anxiety severe");
generalizedAnxietySevereDis.setSuperDisease(LR.generalizedAnxiety);
generalizedAnxietySevereDis.addSymptom(LR.concentrationLoss);
generalizedAnxietySevereDis.addSymptom(LR.speechUnintelligible);
generalizedAnxietySevereDis.addInternalCause(LR.generalizedAnxietyMild);
generalizedAnxietySevereDis.addInternalCause(LR.generalizedAnxietyModerate);
generalizedAnxietySevereDis.addReference("pp 452-4");
generalizedAnxietySevereDis.setMiscComments(
   "no physical or environmental cause for the anxiety can be identified");


// -------------- obsessiveCompulsiveDisorder --------------
// (C) OntoOO Inc Wed Apr 23 16:08:00 PDT 2003
Disease obsessiveCompulsiveDisorderDis = new Disease(
   LR.obsessiveCompulsiveDisorder, 
   "recurring efforts to control overwhelming anxiety guilt " +
   "unacceptable impulses obsessions etc.", 
   LR.psychiatricDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mindSysSt, 
   LR.none
);
obsessiveCompulsiveDisorderDis.setPrintName("obsessive compulsive disorder");
obsessiveCompulsiveDisorderDis.addSymptom(LR.anxiety);
obsessiveCompulsiveDisorderDis.addSymptom(LR.obsessiveThoughts, "", 1.0f);
obsessiveCompulsiveDisorderDis.addSymptom(LR.compulsiveActions); 
obsessiveCompulsiveDisorderDis.addReference("pp 456-9");
Treatment obsessiveCompulsiveDisorderTr1  = 
   new Treatment("obsessiveCompulsiveDisorderTr1");
obsessiveCompulsiveDisorderTr1.addTreatmentAction(LR.behaviorTherapy);
obsessiveCompulsiveDisorderTr1.addDrug(LR.antidepressants);
obsessiveCompulsiveDisorderDis.addTreatment(obsessiveCompulsiveDisorderTr1.getName());


// -------------- panicDisorder --------------
// (C) OntoOO Inc Wed Apr 23 14:42:54 PDT 2003
Disease panicDisorderDis = new Disease(
   LR.panicDisorder, 
   "recurrent episodes of intense apprehension, terror, and impending doom", 
   LR.psychiatricDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mindSysSt, 
   LR.none
);
panicDisorderDis.setPrintName("panic disorder");
panicDisorderDis.addSymptom(LR.anxiety, "during an attack", 1.0f);
panicDisorderDis.addSymptom(LR.apprehension, "during an attack", 1.0f);
panicDisorderDis.addSymptom(LR.diaphoresis, "during an attack", 0.5f);
panicDisorderDis.addSymptom(LR.fearful, "during an attack", 1.0f);
panicDisorderDis.addSymptom(LR.hyperventilation, "during an attack", 0.5f);
panicDisorderDis.addSymptom(LR.tachycardia, "during an attack", 0.5f);
panicDisorderDis.addSymptom(LR.breathingDifficult, "during an attack", 0.2f);
panicDisorderDis.addSymptom(LR.chestPain, "during an attack", 0.2f);
panicDisorderDis.addSymptom(LR.trembling, "during an attack", 0.5f); 
panicDisorderDis.addSymptom(LR.shaking, "during an attack", 0.5f); 
panicDisorderDis.addSymptom(LR.palpitations, "during an attack", 0.5f); 
panicDisorderDis.addSymptom(LR.chokingFeeling, "during an attack", 0.2f); 
panicDisorderDis.addReference("pp 454-6");
Treatment panicDisorderTr1  = new Treatment("panicDisorderTr1");
panicDisorderTr1.addTreatmentAction(LR.behaviorTherapy);
panicDisorderTr1.addDrug(LR.antianxietyDrug);
panicDisorderTr1.addDrug(LR.antidepressants);
panicDisorderTr1.addDrug(LR.betaBlocker);
panicDisorderDis.addTreatment(panicDisorderTr1.getName());


// -------------- phobia --------------
// (C) OntoOO Inc Tue Apr 22 16:41:42 PDT 2003
Disease phobiaDis = new Disease(
   LR.phobia, 
   "persistent irrational fear leading to a compelling " + 
   "desire to avoid a perceived hazard", 
   LR.psychiatricDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mindSysSt, 
   LR.none
);
phobiaDis.addSymptom(LR.anxiety);
phobiaDis.addSymptom(LR.palpitations, "", 0.3f);
phobiaDis.addSymptom(LR.sweating, "", 0.3f);
phobiaDis.addReference("pp 450-2");
Treatment phobiaTr1  = new Treatment("phobiaTr1");
phobiaTr1.addTreatmentAction(LR.behaviorTherapy);
phobiaDis.addTreatment(phobiaTr1.getName());


// -------------- agoraphobia --------------
// (C) OntoOO Inc Tue Apr 22 17:04:06 PDT 2003
Disease agoraphobiaDis = new Disease(
   LR.agoraphobia, 
   "fear of being alone, being in a crowd, in an open space, " + 
   "on a bridge, traveling, etc. ", 
   LR.psychiatricDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mindSysSt, 
   LR.none
);
agoraphobiaDis.setSuperDisease(LR.phobia);
agoraphobiaDis.addSymptom(LR.dizziness, "", 0.3f);
agoraphobiaDis.addSymptom(LR.fallingSensation, "", 0.3f);
agoraphobiaDis.addSymptom(LR.unrealityFeeling, "", 0.3f);
agoraphobiaDis.addSymptom(LR.vomiting, "", 0.3f);
agoraphobiaDis.addReference("pp 450-2");
Treatment agoraphobiaTr1  = new Treatment("agoraphobiaTr1");
agoraphobiaTr1.addDrug(LR.antidepressants);
agoraphobiaTr1.addDrug(LR.antianxietyDrug);
agoraphobiaDis.addTreatment(agoraphobiaTr1.getName());


// -------------- socialPhobia --------------
// (C) OntoOO Inc Tue Apr 22 18:11:57 PDT 2003
Disease socialPhobiaDis = new Disease(
   LR.socialPhobia, 
   "fear of embarassing oneself in public", 
   LR.psychiatricDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   10, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mindSysSt, 
   LR.none
);
socialPhobiaDis.setPrintName("social phobia");
socialPhobiaDis.setSuperDisease(LR.phobia);
socialPhobiaDis.addSymptom(LR.socialPerformanceFear);
socialPhobiaDis.addReference("pp 450-2");


// -------------- objectPhobia --------------
// (C) OntoOO Inc Wed Apr 23 13:56:20 PDT 2003
Disease objectPhobiaDis = new Disease(
   LR.objectPhobia, 
   "fear of a single specific object such as animals or heights", 
   LR.psychiatricDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   10, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mindSysSt, 
   LR.none
);
objectPhobiaDis.setPrintName("object phobia");
objectPhobiaDis.setSuperDisease(LR.phobia);
objectPhobiaDis.addSymptom(LR.nausea, "", 0.3f);
objectPhobiaDis.addReference("pp 450-2");


// -------------- posttraumaticStressDisorder --------------
// (C) OntoOO Inc Fri Apr 25 11:35:03 PDT 2003
Disease posttraumaticStressDisorderDis = new Disease(
   LR.posttraumaticStressDisorder, 
   "the unresolved consequence of experiencing, witnessing, or " +
   "learning about a physically or psychologically distressing event", 
   LR.psychiatricDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mindSysSt, 
   LR.none
);
posttraumaticStressDisorderDis.setPrintName("posttraumatic stress disorder");
posttraumaticStressDisorderDis.addSymptom(LR.anxiety);
posttraumaticStressDisorderDis.addSymptom(LR.panicAttacks);
posttraumaticStressDisorderDis.addSymptom(LR.sleepDisturbed); 
posttraumaticStressDisorderDis.addSymptom(LR.thoughtsDisturbing);
posttraumaticStressDisorderDis.addSymptom(LR.emotionPangs);
posttraumaticStressDisorderDis.addSymptom(LR.flashbacks);
posttraumaticStressDisorderDis.addSymptom(LR.fitOfAnger);
posttraumaticStressDisorderDis.addSymptom(LR.nightmares);
posttraumaticStressDisorderDis.addSymptom(LR.concentrationLoss);
posttraumaticStressDisorderDis.addCausesDisease(LR.depression); 
posttraumaticStressDisorderDis.setWebResource(
   "http://www.postgradmed.com/issues/2001/11_01/khouzam.htm");
posttraumaticStressDisorderDis.addReference("pp 459-61");
Treatment posttraumaticStressDisorderTr1 = new Treatment("posttraumaticStressDisorderTr1");
posttraumaticStressDisorderTr1.addTreatmentAction(LR.behaviorTherapy);
posttraumaticStressDisorderTr1.addTreatmentAction(LR.psychoanalyticTherapy);
posttraumaticStressDisorderTr1.addTreatmentAction(LR.psychologicalCounseling);
posttraumaticStressDisorderTr1.addDrug(LR.antianxietyDrug);
posttraumaticStressDisorderTr1.addDrug(LR.antidepressants);
posttraumaticStressDisorderDis.addTreatment(posttraumaticStressDisorderTr1.getName()); 


// -------------- schizophrenia --------------
// (C) OntoOO Inc Sat Apr 26 18:57:44 PDT 2003
Disease schizophreniaDis = new Disease(
   LR.schizophrenia, 
   "disturbances in thought content and form perception affect " + 
   "sense of self volition relationships and psychomotor behavior ", 
   LR.psychiatricDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mindSysSt, 
   LR.none
);
schizophreniaDis.setWebResource(
   "http://www.mentalhealth.com/dis/p20-ps01.html");
schizophreniaDis.addSymptom(LR.apathy);
schizophreniaDis.addReference("pp 431-7");
Treatment schizophreniaTr1  = new Treatment("schizophreniaTr1");
schizophreniaTr1.addTreatmentAction(LR.psychotherapy);
schizophreniaTr1.addDrug(LR.antipsychoticDrugs);
schizophreniaDis.addTreatment(schizophreniaTr1.getName());
schizophreniaDis.setCode358(180);
schizophreniaDis.setICD10code("F20");


// -------------- schizophreniaProdromal --------------
// (C) OntoOO Inc Mon Apr 28 09:04:45 PDT 2003
Disease schizophreniaProdromalDis = new Disease(
   LR.schizophreniaProdromal, 
   "initial phase of disturbances in thought content and form perception " + 
   "affect sense of self volition relationships and psychomotor behavior ", 
   LR.psychiatricDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mindSysSt, 
   LR.none
);
schizophreniaProdromalDis.setPrintName("schizophrenia prodromal");
schizophreniaProdromalDis.setSuperDisease(LR.schizophrenia);
schizophreniaProdromalDis.addSymptom(LR.anxiety, "", 0.6f);
schizophreniaProdromalDis.addSymptom(LR.concentrationLoss, "", 1.0f);
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
schizophreniaProdromalDis.addCausesDisease(LR.schizophreniaActive);
schizophreniaProdromalDis.addReference("pp 431-7");
schizophreniaProdromalDis.setCode358(180);
schizophreniaProdromalDis.setICD10code("F20");


// -------------- schizophreniaActive --------------
// (C) OntoOO Inc Tue Apr 29 15:03:44 PDT 2003
Disease schizophreniaActiveDis = new Disease(
   LR.schizophreniaActive, 
   "active phase of disturbances in thought content and form perception " +
   "affect sense of self volition relationships and psychomotor behavior ", 
   LR.psychiatricDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mindSysSt, 
   LR.none
);
schizophreniaActiveDis.setPrintName("schizophrenia active");
schizophreniaActiveDis.setSuperDisease(LR.schizophrenia);
schizophreniaActiveDis.addSymptom(LR.behaviorDisorganized, "", 1.0f);
schizophreniaActiveDis.addSymptom(LR.catatonic, "", 1.0f);
schizophreniaActiveDis.addSymptom(LR.delusions, "", 1.0f);
schizophreniaActiveDis.addSymptom(LR.hallucinations, "", 1.0f);
schizophreniaActiveDis.addSymptom(LR.incoherence, "", 1.0f);
schizophreniaActiveDis.addSymptom(LR.speechUnintelligible, "", 0.8f);
schizophreniaActiveDis.addSymptom(LR.speechUnusual, "", 0.8f);
schizophreniaActiveDis.addInternalCause(LR.schizophreniaProdromal);
schizophreniaActiveDis.addCausesDisease(LR.schizophreniaResidual);
schizophreniaActiveDis.addReference("pp 431-7");
schizophreniaActiveDis.setCode358(180);
schizophreniaActiveDis.setICD10code("F20");


// -------------- schizophreniaResidual --------------
// (C) OntoOO Inc Thu May 01 14:09:04 PDT 2003
Disease schizophreniaResidualDis = new Disease(
   LR.schizophreniaResidual, 
   "third phase of disturbances in thought content and form perception " + 
   "affect sense of self volition relationships and psychomotor behavior ", 
   LR.psychiatricDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mindSysSt, 
   LR.none
);
schizophreniaResidualDis.setPrintName("schizophrenia residual");
schizophreniaResidualDis.setSuperDisease(LR.schizophrenia);
schizophreniaResidualDis.addSymptom(LR.anxiety, "", 0.6f);
schizophreniaResidualDis.addSymptom(LR.concentrationLoss, "", 1.0f);
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
schizophreniaResidualDis.addInternalCause(LR.schizophreniaActive);
schizophreniaResidualDis.addReference("pp 431-7");
schizophreniaResidualDis.setCode358(180);
schizophreniaResidualDis.setICD10code("F20");

  } // end doit()

} // end InitPsychiatricDiseases
