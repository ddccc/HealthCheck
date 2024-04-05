// (C) OntoOO Dennis de Champeaux 2000, 2012
package init;

import com.Common;
import com.LR;
import com.F;
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

public class InitGastrointestinalDiseases {
  public static void doit() {

// -------------- appendicitis --------------
// (C) OntoOO Inc Thu Oct 02 11:02:39 PDT 2008
Disease appendicitisDis = new Disease(
   LR.appendicitis,
   "inflammation of the appendix due to an obstruction",
   LR.gastrointestinalDisorders,
   LR.none, // genderSpecificity
   LR.none, // raceSpecificity
   0, // minAge
   LR.maxAge,
   0, // duration
   -1, // diagnosis frequency, -1 = unknown
   LR.appendixSysSt,
   LR.none
);
appendicitisDis.addSymptom(LR.abdomenPainUpperRightSide);
appendicitisDis.addSymptom(LR.anorexia);
appendicitisDis.addSymptom(LR.nausea);
appendicitisDis.addSymptom(LR.vomiting);
appendicitisDis.addCausesDisease(LR.appendicitis2); 
appendicitisDis.addReference("pp 696-7");
appendicitisDis.setMiscComments("rupture of the appendix is fatal without quick intervention");
Treatment appendicitisTr1 = new Treatment("appendicitisTr1");
appendicitisTr1.addTreatmentAction(LR.surgery);
appendicitisTr1.addDrug(LR.antibiotics);
appendicitisDis.addTreatment(appendicitisTr1.getName());

// -------------- appendicitis2 --------------
// (C) OntoOO Inc Thu Oct 02 20:46:22 PDT 2008
Disease appendicitis2Dis = new Disease(
   LR.appendicitis2, 
   "inflammation of the appendix due to an obstruction", 
   LR.gastrointestinalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.appendixSysSt, 
   LR.none
);
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
appendicitis2Dis.addInternalCause(LR.appendicitis); 
appendicitis2Dis.addReference("pp 696-7");
appendicitis2Dis.setMiscComments("rupture of the appendix is fatal without quick intervention");
appendicitis2Dis.addTreatment("appendicitisTr1");

// -------------- celiacDisease --------------
// (C) OntoOO Inc Tue Feb 11 08:14:29 PST 2003
Disease celiacDiseaseDis = new Disease(
   LR.celiacDisease, 
   "poor food absorbtion due to intolerance for gluten a protein in wheat", 
   LR.gastrointestinalDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.caucasian, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gastrointestinalSysSt, 
   LR.none
);
celiacDiseaseDis.setPrintName("celiac disease");
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
celiacDiseaseDis.addCausesDisease(LR.amenorrhea);
celiacDiseaseDis.addCausesDisease(LR.anemia);
celiacDiseaseDis.addCausesDisease(LR.dermatitisHerpetiformis);
celiacDiseaseDis.addCausesDisease(LR.osteoporosis);
celiacDiseaseDis.addCausesDisease(LR.psoriasis);
celiacDiseaseDis.addCausesDisease(LR.vitaminDDeficiency);
celiacDiseaseDis.addReference("pp 692-4");
Treatment celiacDiseaseTr1  = new Treatment("celiacDiseaseTr1");
celiacDiseaseTr1.addTreatmentAction(LR.dietWithoutGluten);
celiacDiseaseDis.addTreatment(celiacDiseaseTr1.getName());


// -------------- diverticularSuper --------------
// (C) OntoOO Inc Thu Feb 06 13:45:33 PST 2003
Disease diverticularSuperDis = new Disease(
   LR.diverticularSuper, 
   "bulging pouches in the gastro intestinal track especially in the colon", 
   LR.gastrointestinalDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.colonSysSt, 
   LR.none
);
diverticularSuperDis.setPrintName("diverticular super");
diverticularSuperDis.setTemperature((float)100.5);
diverticularSuperDis.addSymptom(LR.abdomenPainLowerLeftSide, "", 1.0f);
diverticularSuperDis.addSymptom(LR.constipation, "alternates with diarrhea", 0.5f);
diverticularSuperDis.addSymptom(LR.diarrhea, "alternates with constipation", 0.5f);
diverticularSuperDis.addSymptom(LR.feverSym);
diverticularSuperDis.addSymptom(LR.nausea, "", 1.0f);
diverticularSuperDis.addSymptom(LR.gas, "", 1.0f);
diverticularSuperDis.addCausesAbnormalCondition(LR.leukocytosis);
diverticularSuperDis.addReference("pp 694-6");
Treatment diverticularSuperTr1 = new Treatment("diverticularSuperTr1");
diverticularSuperTr1.addTreatmentAction(LR.bedRest);
diverticularSuperTr1.addTreatmentAction(LR.dietLiquid);
diverticularSuperTr1.addDrug(LR.antibiotics);
diverticularSuperTr1.addDrug(LR.stoolSoftener);
diverticularSuperTr1.addDrug(LR.meperidine);
diverticularSuperTr1.addDrug(LR.antispasmodic);
diverticularSuperDis.addTreatment(diverticularSuperTr1.getName());
diverticularSuperDis.setCode358(294);
diverticularSuperDis.setICD10code("K57");


// -------------- diverticularDisease --------------
// (C) OntoOO Inc Thu Feb 06 13:45:33 PST 2003
Disease diverticularDiseaseDis = new Disease(
   LR.diverticularDisease, 
   "bulging pouches in the gastro intestinal track especially in the colon", 
   LR.gastrointestinalDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.colonSysSt, 
   LR.none
);
diverticularDiseaseDis.setPrintName("diverticular disease");
diverticularDiseaseDis.setSuperDisease(LR.diverticularSuper);
diverticularDiseaseDis.setTemperature((float)100.5);
diverticularDiseaseDis.addCausesDisease(LR.diverticularDiseaseSevere);
diverticularDiseaseDis.setCode358(294);
diverticularDiseaseDis.setICD10code("K57");


// -------------- diverticularDiseaseSevere --------------
// (C) OntoOO Inc Thu Feb 06 15:34:12 PST 2003
Disease diverticularDiseaseSevereDis = new Disease(
   LR.diverticularDiseaseSevere, 
   "bulging pouches in the gastro intestinal track especially in the colon", 
   LR.gastrointestinalDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.colonSysSt, 
   LR.none
);
diverticularDiseaseSevereDis.setPrintName("diverticular disease severe");
diverticularDiseaseSevereDis.setSuperDisease(LR.diverticularSuper);
diverticularDiseaseSevereDis.setTemperature((float)103.0);
diverticularDiseaseSevereDis.addSymptom(LR.abdomenRigidity);
diverticularDiseaseSevereDis.addSymptom(LR.chills);
diverticularDiseaseSevereDis.addSymptom(LR.hypotension);
diverticularDiseaseSevereDis.addInternalCause(LR.diverticularDisease);
diverticularDiseaseSevereDis.addCausesDisease(LR.peritonitis);
diverticularDiseaseSevereDis.addCausesAbnormalCondition(LR.sepsis);
diverticularDiseaseSevereDis.addCausesAbnormalCondition(LR.shock);
diverticularDiseaseSevereDis.addReference("pp 694-6");
Treatment diverticularDiseaseSevereTr1  = 
   new Treatment("diverticularDiseaseSevereTr1", LR.ifSevere);
diverticularDiseaseSevereTr1.addTreatmentAction(LR.surgery);
diverticularDiseaseSevereDis.addTreatment(diverticularDiseaseSevereTr1.getName());
diverticularDiseaseSevereDis.setCode358(294);
diverticularDiseaseSevereDis.setICD10code("K57");


// -------------- gastroenteritis --------------
// (C) OntoOO Inc Mon Mar 15 12:36:44 PST 2004
Disease gastroenteritisDis = new Disease(
   LR.gastroenteritis, 
   "bowel disturbance due to bacteria - food poisoning - parasite, virus, toxins, antibiotics, etc.", 
   LR.gastrointestinalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -3, //  duration 
   F.gastroenteritisFreq,
   LR.intestinesSysSt, 
   LR.none
);
gastroenteritisDis.addSymptom(LR.vomiting, "", 0.3f);
gastroenteritisDis.addSymptom(LR.abdomenCramping);
gastroenteritisDis.addSymptom(LR.diarrhea);
gastroenteritisDis.addSymptom(LR.nausea);
gastroenteritisDis.addSymptom(LR.malaise, "", 0.3f);
gastroenteritisDis.addSymptom(LR.borborygmi, "", 0.3f);
gastroenteritisDis.addReference("pp 680-1");
Treatment gastroenteritisTr1  = new Treatment("gastroenteritisTr1");
gastroenteritisTr1.addTreatmentAction(LR.bedRest);
gastroenteritisTr1.addTreatmentAction(LR.fluidIncrease);
gastroenteritisTr1.addTreatmentAction(LR.nutritionSupport);
gastroenteritisDis.addTreatment(gastroenteritisTr1.getName());


// -------------- gastroesophagealReflux --------------
// (C) OntoOO Inc Tue Jan 28 10:42:59 PST 2003
Disease gastroesophagealRefluxDis = new Disease(
   LR.gastroesophagealReflux, 
   "backflow of stomach content into the esophagus", 
   LR.gastrointestinalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.esophagusSysSt, 
   LR.none
);
gastroesophagealRefluxDis.setPrintName("gastroesophageal reflux");
gastroesophagealRefluxDis.addSymptom(LR.bleedingFromMouth, 
				     "bright red or dark brown", 0.05f); 
gastroesophagealRefluxDis.addSymptom(LR.cough, "", 0.4f); 
gastroesophagealRefluxDis.addSymptom(LR.dysphagia, "", 0.4f); 
gastroesophagealRefluxDis.addSymptom(LR.esophagusSpasm, "", 0.4f); 
gastroesophagealRefluxDis.addSymptom(LR.heartburn); 
gastroesophagealRefluxDis.addSymptom(LR.hiccups, "", 0.4f); 
gastroesophagealRefluxDis.addSymptom(LR.hoarseness, "", 0.4f); 
gastroesophagealRefluxDis.addSymptom(LR.nausea, "after eating", 0.5f); 
gastroesophagealRefluxDis.addSymptom(LR.retrosternalChestPain);
gastroesophagealRefluxDis.addSymptom(LR.throatSore, "", 0.4f); 
gastroesophagealRefluxDis.addSymptom(LR.vomiting, "",  0.4f); 
gastroesophagealRefluxDis.addCausesDisease(LR.asthma);
gastroesophagealRefluxDis.addCausesDisease(LR.chronicObstructivePulmonaryDisease);
gastroesophagealRefluxDis.addReference("pp 666-8");
Treatment gastroesophagealRefluxTr1  = new Treatment("gastroesophagealRefluxTr1");
gastroesophagealRefluxTr1.addDrug(LR.antacid);
gastroesophagealRefluxDis.addTreatment(gastroesophagealRefluxTr1.getName());


// -------------- giHemorrhage --------------
// (C) OntoOO Inc Fri Nov 16 16:59:38 PST 2001
Disease giHemorrhageDis = new Disease(
   LR.giHemorrhage, 
   "bleeding of the GI tract", 
   LR.gastrointestinalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gastrointestinalSysSt, 
   LR.none
);
giHemorrhageDis.setPrintName("GI hemorrhage");

giHemorrhageDis.addSymptom(LR.bleedingFromMouth, "", 1.0f);
giHemorrhageDis.addSymptom(LR.bleedingFromRectum, "", 1.0f);
giHemorrhageDis.addSymptom(LR.consciousnessDecreased, "", 1.0f);
giHemorrhageDis.addSymptom(LR.hypotension, "", 1.0f);
giHemorrhageDis.addSymptom(LR.nausea, "", 1.0f);
giHemorrhageDis.addSymptom(LR.oliguria, "", 1.0f);
giHemorrhageDis.addSymptom(LR.tachypnea);
giHemorrhageDis.addSymptom(LR.skinClammy, "", 1.0f);
giHemorrhageDis.addSymptom(LR.skinCold, "", 1.0f);
giHemorrhageDis.addSymptom(LR.tachycardia, "", 1.0f);

giHemorrhageDis.addReference("pp 0");

Treatment giHemorrhageTr1  = new Treatment("giHemorrhageTr1");
giHemorrhageTr1.addTreatmentAction(LR.IVFluids);
giHemorrhageTr1.addTreatmentAction(LR.MinnesotaTube);
giHemorrhageTr1.addTreatmentAction(LR.bloodTransfusion);
giHemorrhageTr1.addTreatmentAction(LR.endotrachealIntubation);
giHemorrhageTr1.addTreatmentAction(LR.mechanicalVentilation);
giHemorrhageTr1.addTreatmentAction(LR.surgery);
giHemorrhageTr1.addTreatmentAction(LR.cauterization);
giHemorrhageTr1.addDrug(LR.vasopressin);
giHemorrhageDis.addTreatment(giHemorrhageTr1.getName());


// -------------- gingivitis --------------
// (C) OntoOO Inc Mon Jun 16 13:29:34 PDT 2003
Disease gingivitisDis = new Disease(
   LR.gingivitis, 
   "inflammation of the gums", 
   LR.gastrointestinalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mouthSysSt, 
   LR.none
);
gingivitisDis.addSymptom(LR.gumsBleeding);
gingivitisDis.addSymptom(LR.gumPockets);
gingivitisDis.addSymptom(LR.gumsSwollen);
gingivitisDis.addReference("pp 665");
Treatment gingivitisTr1  = new Treatment("gingivitisTr1");
gingivitisTr1.addTreatmentAction(LR.mouthWash);
gingivitisTr1.addTreatmentAction(LR.oralHygiene);
gingivitisTr1.addDrug(LR.corticosteroids);
gingivitisDis.addTreatment(gingivitisTr1.getName());


// -------------- glossitis --------------
// (C) OntoOO Inc Fri Apr 12 17:03:10 PDT 2002
Disease glossitisDis = new Disease(
   LR.glossitis, 
   "inflammation of the tongue", 
   LR.gastrointestinalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.tongueSysSt, 
   LR.alcoholAbuse
);
glossitisDis.addSymptom(LR.chewingPainful, "", 1.0f);
glossitisDis.addSymptom(LR.speechDifficulty, "", 1.0f);
glossitisDis.addSymptom(LR.tonguePainful, "", 1.0f);
glossitisDis.addSymptom(LR.tongueRed, "", 1.0f);
glossitisDis.addSymptom(LR.tongueSwollen, "", 1.0f);
glossitisDis.addSymptom(LR.swallowingPainful, "", 1.0f);
glossitisDis.addExternalCause(LR.streptococcusInfection);
glossitisDis.addExternalCause(LR.injury);
glossitisDis.addExternalCause(LR.smoking);
glossitisDis.addExternalCause(LR.spicyFoods);
glossitisDis.addExternalCause(LR.vitaminBDeficiency);
glossitisDis.addInternalCause(LR.anemia);
glossitisDis.addInternalCause(LR.anemiaFolicAcidDeficiency); 
glossitisDis.addReference("pp 665");
Treatment glossitisTr1 = new Treatment("glossitisTr1");
glossitisTr1.addTreatmentAction(LR.mouthWash);
glossitisTr1.addTreatmentAction(LR.oralHygiene);
glossitisTr1.addDrug(LR.aspirin);
glossitisDis.addTreatment("glossitisTr1");


// -------------- hemorrhoids --------------
// (C) OntoOO Inc Mon Aug 25 21:49:16 PDT 2003
Disease hemorrhoidsDis = new Disease(
   LR.hemorrhoids, 
   " veins around the anus or lower rectum are swollen and inflamed", 
   LR.gastrointestinalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   60,
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.rectumSysSt, 
   LR.none
);
hemorrhoidsDis.addSymptom(LR.stoolBrightRedBloody);
hemorrhoidsDis.addSymptom(LR.rectumItching); 
hemorrhoidsDis.addReference("pp 715-7");
Treatment hemorrhoidsTr1 = new Treatment("hemorrhoidsTr1");
hemorrhoidsTr1.addDrug(LR.stoolSoftener);
hemorrhoidsTr1.addTreatmentAction(LR.dietFiber);
hemorrhoidsTr1.addTreatmentAction(LR.anestheticLocal);
hemorrhoidsDis.addTreatment("hemorrhoidsTr1");
Treatment hemorrhoidsTr2  = new Treatment("hemorrhoidsTr2", LR.ifSevere);
hemorrhoidsTr2.addTreatmentAction(LR.surgery);
hemorrhoidsDis.addTreatment(hemorrhoidsTr2.getName());


// -------------- hirschsprung --------------
// (C) OntoOO Inc Mon Apr 23 15:23:51 PDT 2007
Disease hirschsprungDis = new Disease(
   LR.hirschsprung, 
   "neural defect in large intestine causing systemic constipations", 
   LR.gastrointestinalDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.largeIntestineSysSt, 
   LR.none
);
hirschsprungDis.setPrintName("Hirschsprung Disease");
hirschsprungDis.setWebResource("http://en.wikipedia.org/wiki/Hirschsprung_disease");
hirschsprungDis.setGenetic("mother");
hirschsprungDis.setParentDisease(LR.hirschsprung);
hirschsprungDis.addSymptom(LR.abdomenDistension);
hirschsprungDis.addSymptom(LR.constipation);
hirschsprungDis.addReference("pp 708-11");
Treatment hirschsprungTr1  = new Treatment("hirschsprungTr1");
hirschsprungTr1.addTreatmentAction(LR.surgery);
hirschsprungDis.addTreatment(hirschsprungTr1.getName());


// -------------- hirschsprungInfant --------------
// (C) OntoOO Inc Tue Apr 24 09:48:44 PDT 2007
Disease hirschsprungInfantDis = new Disease(
   LR.hirschsprungInfant, 
   "neural defect in large intestine causing systemic constipations", 
   LR.gastrointestinalDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   1,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.largeIntestineSysSt, 
   LR.none
);
hirschsprungInfantDis.setPrintName("Hirschsprung infant Disease");
hirschsprungInfantDis.setWebResource("http://en.wikipedia.org/wiki/Hirschsprung_disease");
hirschsprungInfantDis.setSuperDisease(LR.hirschsprung);
hirschsprungInfantDis.setGenetic("mother");
hirschsprungInfantDis.setParentDisease(LR.hirschsprung);
hirschsprungInfantDis.addSymptom(LR.dehydration);
hirschsprungInfantDis.addSymptom(LR.diarrhea, "", 0.2f); 
hirschsprungInfantDis.addSymptom(LR.feedingDifficulties);
hirschsprungInfantDis.addSymptom(LR.irritability);
hirschsprungInfantDis.addSymptom(LR.vomitBile);
hirschsprungInfantDis.addReference("pp 708-11");


// -------------- hirschsprungChild --------------
// (C) OntoOO Inc Tue Apr 24 15:30:37 PDT 2007
Disease hirschsprungChildDis = new Disease(
   LR.hirschsprungChild, 
   "neural defect in large intestine causing systemic constipations", 
   LR.gastrointestinalDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   2, //  minAge 
   17,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.largeIntestineSysSt, 
   LR.none
);
hirschsprungChildDis.setPrintName("Hirschsprung child Disease");
hirschsprungChildDis.setWebResource("http://en.wikipedia.org/wiki/Hirschsprung_disease");
hirschsprungChildDis.setSuperDisease(LR.hirschsprung);
hirschsprungChildDis.addSymptom(LR.anorexia, "", 0.4f); 
hirschsprungChildDis.addSymptom(LR.diarrhea, "", 0.2f); 
hirschsprungChildDis.setGenetic("mother");
hirschsprungChildDis.setParentDisease(LR.hirschsprung);
hirschsprungChildDis.addCausesDisease(LR.anemia);
hirschsprungChildDis.addReference("pp 708-11");


// -------------- hirschsprungAdult --------------
// (C) OntoOO Inc Tue Apr 24 15:30:37 PDT 2007
Disease hirschsprungAdultDis = new Disease(
   LR.hirschsprungAdult, 
   "neural defect in large intestine causing systemic constipations", 
   LR.gastrointestinalDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   18, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.largeIntestineSysSt, 
   LR.none
);
hirschsprungAdultDis.setPrintName("Hirschsprung adult Disease");
hirschsprungAdultDis.setWebResource("http://en.wikipedia.org/wiki/Hirschsprung_disease");
hirschsprungAdultDis.setSuperDisease(LR.hirschsprung);
hirschsprungAdultDis.setGenetic("mother");
hirschsprungAdultDis.setParentDisease(LR.hirschsprung);
hirschsprungAdultDis.addSymptom(LR.pallor, "", 0.2f); 
hirschsprungAdultDis.addCausesDisease(LR.anemia);
hirschsprungAdultDis.addReference("pp 708-11");


// -------------- intestinalObstruction --------------
// (C) OntoOO Inc Tue Nov 20 15:10:12 PST 2001
Disease intestinalObstructionDis = new Disease(
   LR.intestinalObstruction, 
   "intestinal obstruction", 
   LR.gastrointestinalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.intestinesSysSt, 
   LR.none
);
intestinalObstructionDis.setPrintName();
intestinalObstructionDis.addSymptom(LR.abdomenDistension, "", 1.0f);
intestinalObstructionDis.addSymptom(LR.abdomenPain, "", 1.0f);
intestinalObstructionDis.addSymptom(LR.obstipation, "", 1.0f);
intestinalObstructionDis.addSymptom(LR.dehydration, "", 1.0f);
intestinalObstructionDis.addSymptom(LR.diarrhea, "", 1.0f);
intestinalObstructionDis.addSymptom(LR.drowsiness, "", 1.0f);
intestinalObstructionDis.addSymptom(LR.nausea, "", 1.0f);
intestinalObstructionDis.addSymptom(LR.thirst);
intestinalObstructionDis.addSymptom(LR.vomiting, "", 1.0f);

intestinalObstructionDis.addReference("pp 699-703");

Treatment intestinalObstructionTr1 = new Treatment("intestinalObstructionTr1");
intestinalObstructionTr1.addTreatmentAction(LR.IVFluids);
intestinalObstructionTr1.addTreatmentAction(LR.bedRest);
intestinalObstructionTr1.addTreatmentAction(LR.surgery);
intestinalObstructionTr1.addTreatmentAction(LR.paranteralNutrition);
intestinalObstructionTr1.addTreatmentAction(LR.nasogastricTube);
intestinalObstructionDis.addTreatment(intestinalObstructionTr1.getName()); 


// -------------- necrotizingEnterocolitis --------------
// (C) OntoOO Inc Thu Nov 22 01:26:17 PST 2001
Disease necrotizingEnterocolitisDis = new Disease(
   LR.necrotizingEnterocolitis, 
   "dying tissue in the intestines", 
   LR.gastrointestinalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   2, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.intestinesSysSt, 
   LR.none
);
necrotizingEnterocolitisDis.setPrintName("necrotizing enterocolitis");
necrotizingEnterocolitisDis.addSymptom(LR.abdomenDistension);
necrotizingEnterocolitisDis.addSymptom(LR.bradycardia);
necrotizingEnterocolitisDis.addSymptom(LR.diarrheaBloody);
necrotizingEnterocolitisDis.addSymptom(LR.gastricResidueIncreased);
necrotizingEnterocolitisDis.addSymptom(LR.jaundice);
necrotizingEnterocolitisDis.addSymptom(LR.lethargy);
necrotizingEnterocolitisDis.addCausesDisease(LR.disseminatedIntravascularCoagulation);
necrotizingEnterocolitisDis.addCausesDisease(LR.metabolicAcidosis);
necrotizingEnterocolitisDis.addReference("pp 687-9");

Treatment necrotizingEnterocolitisTr1 = new Treatment("necrotizingEnterocolitisTr1");
necrotizingEnterocolitisTr1.addTreatmentAction(LR.IVFluids);
necrotizingEnterocolitisTr1.addTreatmentAction(LR.nasogastricTube);
necrotizingEnterocolitisTr1.addTreatmentAction(LR.paranteralNutrition);
necrotizingEnterocolitisTr1.addTreatmentAction(LR.surgery);
necrotizingEnterocolitisTr1.addTreatmentAction(LR.nothingByMouth);
necrotizingEnterocolitisTr1.addTreatmentAction(LR.bowelRest);
necrotizingEnterocolitisTr1.addDrug(LR.antibiotics);
necrotizingEnterocolitisTr1.addDrug(LR.dextran);
necrotizingEnterocolitisDis.addTreatment(necrotizingEnterocolitisTr1.getName()); 


    // -------------- pancreatitis ---------------
// (C) OntoOO Inc Mon Aug 27 16:08:58 PDT 2001
Disease pancreatitisDis = new Disease(
   LR.pancreatitis, 
   "inflammation of the pancreas", 
   LR.gastrointestinalDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.pancreasSysSt, 
   LR.none
);
pancreatitisDis.setTemperature((float)101.0);

pancreatitisDis.addSymptom(LR.abdomenRigidity, "", 1.0f); 
pancreatitisDis.addSymptom(LR.bowelActivityDecreased); 
pancreatitisDis.addSymptom(LR.crackles, "", 1.0f); 
pancreatitisDis.addSymptom(LR.epigastricUmbilicusPain); 
pancreatitisDis.addSymptom(LR.malaise, "", 1.0f); 
pancreatitisDis.addSymptom(LR.skinMottled); 
pancreatitisDis.addSymptom(LR.vomiting, "", 1.0f); 

pancreatitisDis.addCausesAbnormalCondition(LR.pleuralEffusionLeft); 
pancreatitisDis.addReference("pp 712-5");

Treatment pancreatitisTr1  = new Treatment("pancreatitisTr1");
pancreatitisTr1.addTreatmentAction(LR.IVFluids);
pancreatitisTr1.addDrug(LR.antibiotics);
pancreatitisTr1.addDrug(LR.insulin);
pancreatitisTr1.addDrug(LR.morphine);
pancreatitisTr1.addDrug(LR.diazepam);
pancreatitisTr1.addDrug(LR.calciumGluconate);
pancreatitisDis.addTreatment(pancreatitisTr1.getName());
pancreatitisDis.setCode358(304);
pancreatitisDis.setICD10code("K85");


// -------------- pepticUlcers --------------
// (C) OntoOO Inc Mon Feb 17 14:12:11 PST 2003
Disease pepticUlcersDis = new Disease(
   LR.pepticUlcers, 
   "lesions in the mucosa membranes of the gastrointestinal track", 
   LR.gastrointestinalDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gastrointestinalSysSt, 
   LR.helicobacterPyloriInfection
);
pepticUlcersDis.setPrintName("peptic ulcers");
pepticUlcersDis.addSymptom(LR.heartburn, "", 1.0f);
pepticUlcersDis.addSymptom(LR.dyspepsia);
pepticUlcersDis.addSymptom(LR.weightGain);
pepticUlcersDis.addExternalCause(LR.alcoholAbuse);
pepticUlcersDis.addExternalCause(LR.tobaccoUse);
pepticUlcersDis.addInternalCause(LR.hepatitis);
pepticUlcersDis.addInternalCause(LR.pancreatitis);
pepticUlcersDis.addReference("pp 681-4");
Treatment pepticUlcersTr1 = new Treatment("pepticUlcersTr1");
pepticUlcersTr1.addDrug(LR.amoxicillin);
pepticUlcersTr1.addDrug(LR.metronidazole);
pepticUlcersTr1.addDrug(LR.tetracycline);
pepticUlcersDis.addTreatment("pepticUlcersTr1");
pepticUlcersDis.setCode358(286);
pepticUlcersDis.setICD10code("K27");


// -------------- peritonitis --------------
// (C) OntoOO Inc Fri Nov 23 12:53:57 PST 2001
Disease peritonitisDis = new Disease(
   LR.peritonitis, 
   "inflammation of the peritoneum, lining of the abdomen", 
   LR.gastrointestinalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.peritoneumSysSt, 
   LR.none
);

peritonitisDis.addSymptom(LR.abdomenPainSuddenSevere);
peritonitisDis.addSymptom(LR.abdomenRigidity);
peritonitisDis.addSymptom(LR.nausea);
peritonitisDis.addSymptom(LR.vomiting);
peritonitisDis.addSymptom(LR.diarrhea); 
peritonitisDis.addSymptom(LR.pulseWeak); 
peritonitisDis.addSymptom(LR.tachycardia); 
peritonitisDis.addSymptom(LR.hiccups); 
peritonitisDis.addInternalCause(LR.ectopicPregnancyRupture);
peritonitisDis.addInternalCause(LR.diverticularDiseaseSevere);

peritonitisDis.addReference("pp 698-9");
peritonitisDis.setMiscComments("survival rate is 90%");

Treatment peritonitisTr1  = new Treatment("peritonitisTr1");
peritonitisTr1.addTreatmentAction(LR.IVFluids);
peritonitisTr1.addTreatmentAction(LR.nothingByMouth);
peritonitisTr1.addTreatmentAction(LR.electrolyteReplacement);
peritonitisTr1.addDrug(LR.antibiotics);
peritonitisTr1.addDrug(LR.antiemetics);
peritonitisDis.addTreatment(peritonitisTr1.getName());


// -------------- stomatitis --------------
// (C) OntoOO Inc Fri Jun 13 10:58:10 PDT 2003
Disease stomatitisDis = new Disease(
   LR.stomatitis, 
   "inflammation of the mucosa in the mouth", 
   LR.gastrointestinalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mouthSysSt, 
   LR.none
);
stomatitisDis.addSymptom(LR.mouthUlcers);
stomatitisDis.addInternalCause(LR.renalFailureAcute);
stomatitisDis.addReference("pp 664-6");


// -------------- stomatitisAcuteHerpetic --------------
// (C) OntoOO Inc Mon Jun 16 09:04:12 PDT 2003
Disease stomatitisAcuteHerpeticDis = new Disease(
   LR.stomatitisAcuteHerpetic, 
   "acute inflammation of the mucosa in the mouth", 
   LR.gastrointestinalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mouthSysSt, 
   LR.herpesSimplexVirus
);
stomatitisAcuteHerpeticDis.setPrintName("stomatitis acute herpetic");
stomatitisAcuteHerpeticDis.setSuperDisease(LR.stomatitis);
stomatitisAcuteHerpeticDis.addSymptom(LR.anorexia, "", 1.0f);
stomatitisAcuteHerpeticDis.addSymptom(LR.gumsSwollen, "", 1.0f);
stomatitisAcuteHerpeticDis.addSymptom(LR.irritability, "", 1.0f);
stomatitisAcuteHerpeticDis.addSymptom(LR.lethargy, "", 1.0f);
stomatitisAcuteHerpeticDis.addSymptom(LR.malaise, "", 1.0f);
stomatitisAcuteHerpeticDis.addSymptom(LR.mouthPain, "", 1.0f);
stomatitisAcuteHerpeticDis.addReference("pp 664-6");
Treatment stomatitisAcuteHerpeticTr1 = new Treatment("stomatitisAcuteHerpeticTr1");
stomatitisAcuteHerpeticTr1.addTreatmentAction(LR.mouthWash);
stomatitisAcuteHerpeticDis.addTreatment("stomatitisAcuteHerpeticTr1");


// -------------- stomatitisAphthous --------------
// (C) OntoOO Inc Mon Jun 16 09:37:22 PDT 2003
Disease stomatitisAphthousDis = new Disease(
   LR.stomatitisAphthous, 
   "acute inflammation of the mucosa in the mouth", 
   LR.gastrointestinalDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mouthSysSt, 
   LR.stress
);
stomatitisAphthousDis.setPrintName("stomatitis aphthous");
stomatitisAphthousDis.setSuperDisease(LR.stomatitis);
stomatitisAphthousDis.addSymptom(LR.feverSym, "", 0.3f);
stomatitisAphthousDis.addSymptom(LR.mouthTingling, "", 0.7f);
stomatitisAphthousDis.addSymptom(LR.mouthPain, "", 1.0f);
stomatitisAphthousDis.addExternalCause(LR.trauma);
stomatitisAphthousDis.addExternalCause(LR.fatigue); 
stomatitisAphthousDis.addReference("pp 664-6");
Treatment stomatitisAphthousTr1  = new Treatment("stomatitisAphthousTr1");
stomatitisAphthousTr1.addTreatmentAction(LR.anesthetic);
stomatitisAphthousDis.addTreatment(stomatitisAphthousTr1.getName());


// -------------- ulcerativeColitis --------------
// (C) OntoOO Inc Tue Feb 11 15:11:58 PST 2003
// (C) OntoOO Inc Mon Sep 13 15:46:27 GMT-08:00 2004
Disease ulcerativeColitisDis = new Disease(
   LR.ulcerativeColitis, 
   "inflammation of the lining of the colon - often chronic", 
   LR.gastrointestinalDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   60,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.colonSysSt, 
   LR.none
);
ulcerativeColitisDis.setPrintName("ulcerative colitis");
ulcerativeColitisDis.addSymptom(LR.abdomenPain, "", 1.0f);
ulcerativeColitisDis.addSymptom(LR.anorexia, "", 1.0f);
ulcerativeColitisDis.addSymptom(LR.diarrheaBloody, "", 1.0f);
ulcerativeColitisDis.addSymptom(LR.irritability, "", 1.0f);
ulcerativeColitisDis.addSymptom(LR.nausea, "", 1.0f);
ulcerativeColitisDis.addSymptom(LR.vomiting, "", 1.0f);
ulcerativeColitisDis.addSymptom(LR.weightLoss, "", 1.0f);
ulcerativeColitisDis.addCausesDisease(LR.anemia);
ulcerativeColitisDis.addCausesDisease(LR.ankylosingSpondylitis);
ulcerativeColitisDis.addCausesDisease(LR.arthritis);
ulcerativeColitisDis.addCausesDisease(LR.uveitis);
ulcerativeColitisDis.addCausesDisease(LR.cirrhosis);
ulcerativeColitisDis.addReference("pp 684-7");
ulcerativeColitisDis.setMiscComments(
   "prevalent among Jews and in higher economic groups possibly genetic component/ " +
   "onset between 15 and 20 and between 55 and 60");
Treatment ulcerativeColitisTr1  = new Treatment("ulcerativeColitisTr1");
ulcerativeColitisTr1.addTreatmentAction(LR.IVFluids);
ulcerativeColitisTr1.addTreatmentAction(LR.bedRest);
ulcerativeColitisTr1.addTreatmentAction(LR.dietLiquid);
ulcerativeColitisDis.addTreatment(ulcerativeColitisTr1.getName());
ulcerativeColitisDis.setCode358(292);
ulcerativeColitisDis.setICD10code("K51");


  } // end doit()

} // end InitGastrointestinalDiseases


