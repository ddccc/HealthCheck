// (C) OntoOO Inc 2000
package init;

import com.D;
import com.LR;
import com.F;
import concepts.*;

public class InitInfectionDiseases {
  public static void doit() {


// -------------- amebiasis --------------
// (C) OntoOO Inc Tue Feb 22 15:12:23 PST 2005
Disease amebiasisDis = new Disease(
   LR.amebiasis, 
   "protozoal infection caused by entamoeba histolytica", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -3, //  duration 
   F.amebiasisFreq,
   LR.intestinesSysSt, 
   LR.protozoanInfection
);
amebiasisDis.setTemperature((float)104.0);
amebiasisDis.addSymptom(LR.abdomenCramping);
amebiasisDis.addSymptom(LR.abdomenTenderness);
amebiasisDis.addSymptom(LR.chills);
amebiasisDis.addSymptom(LR.diarrheaBloody);
amebiasisDis.addSymptom(LR.tenesmus);
amebiasisDis.addReference("pp 254");
amebiasisDis.setMiscComments(
    "more common in the tropics, subtropics, areas with poor sanitation and among homosexuals");
Treatment amebiasisTr1  = new Treatment("amebiasisTr1");
amebiasisTr1.addDrug(LR.metronidazole);
amebiasisDis.addTreatment(amebiasisTr1.getName());
amebiasisDis.setCode358(9);
amebiasisDis.setICD10code("A06");


    // ----------------  anthrax --------------------------
// (C) OntoOO Inc Fri Oct 19 16:15:51 PDT 2001
Disease anthraxDis = new Disease(
   LR.anthrax, 
   "infection by anthracis bacterium; high mortality if not treated in an early phase", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.anthracisBacterialInfection
);
anthraxDis.addReference("pp 1278-9");
anthraxDis.setMiscComments(
      "infection through: inhalation (most dangerous), cutaneous (skin), " +
      "gastrointestinal (contaminated food)/ see sub diseases");
Treatment anthraxTr1  = new Treatment("anthraxTr1");
anthraxTr1.addDrug(LR.antibiotics);
anthraxTr1.addDrug(LR.penicillin);
anthraxTr1.addDrug(LR.erythromycin);
anthraxTr1.addDrug(LR.tetracycline);
anthraxTr1.addDrug(LR.chloramphenicol);
anthraxDis.addTreatment(anthraxTr1.getName());


    // ----------------  anthraxCutaneous --------------------------
// (C) OntoOO Inc Fri Oct 19 17:02:51 PDT 2001
Disease anthraxCutaneousDis = new Disease(
   LR.anthraxCutaneous, 
   "anthrax infection through a skin cut", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.anthracisBacterialInfection
);
anthraxCutaneousDis.setPrintName("anthrax cutaneous");
anthraxCutaneousDis.setSuperDisease(LR.anthrax);
anthraxCutaneousDis.addSymptom(LR.bumpItchy);
anthraxCutaneousDis.addSymptom(LR.lymphadenopathy);
anthraxCutaneousDis.addSymptom(LR.ulcer);
anthraxCutaneousDis.addReference("pp 1278-9");
anthraxCutaneousDis.setMiscComments("20% mortality if not treated");


    // ----------------  anthraxInhalation --------------------------
// (C) OntoOO Inc Sat Oct 20 11:59:28 PDT 2001
Disease anthraxInhalationDis = new Disease(
   LR.anthraxInhalation, 
   "anthrax infection through inhalation of anthrax bacterium and/or spores", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.respiratorySysSt, 
   LR.anthracisBacterialInfection
);
anthraxInhalationDis.setPrintName("anthrax inhalation");
anthraxInhalationDis.setSuperDisease(LR.anthrax);
anthraxInhalationDis.setTemperature((float)102.5);
anthraxInhalationDis.addSymptom(LR.breathlessness, "advanced stage", 0.2f);
anthraxInhalationDis.addSymptom(LR.chills, "initial", 1.0f);
anthraxInhalationDis.addSymptom(LR.cough, "initial", 1.0f);
anthraxInhalationDis.addSymptom(LR.headache, "initial", 1.0f);
anthraxInhalationDis.addSymptom(LR.malaise, "initial", 1.0f);
anthraxInhalationDis.addSymptom(LR.myalgia, "initial", 1.0f);
anthraxInhalationDis.addCausesAbnormalCondition(LR.shock);
anthraxInhalationDis.addReference("pp 516-7");
anthraxInhalationDis.setMiscComments(
     "death results in 1-2 days after onset of the acute symptoms");


    // ----------------  anthraxIntestinal --------------------------
// (C) OntoOO Inc Sat Oct 20 12:22:48 PDT 2001
Disease anthraxIntestinalDis = new Disease(
   LR.anthraxIntestinal, 
   "anthrax infection through contaminated food", 
   LR.infections,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gastrointestinalSysSt, 
   LR.anthracisBacterialInfection
);
anthraxIntestinalDis.setPrintName("anthrax intestinal");
anthraxIntestinalDis.setSuperDisease(LR.anthrax);
anthraxIntestinalDis.addSymptom(LR.abdomenPain);
anthraxIntestinalDis.addSymptom(LR.appetiteLoss);
anthraxIntestinalDis.addSymptom(LR.diarrhea);
anthraxIntestinalDis.addSymptom(LR.hemoptysis);
anthraxIntestinalDis.addSymptom(LR.nausea);
anthraxIntestinalDis.addSymptom(LR.vomiting);
anthraxIntestinalDis.addReference("pp 1278-9 ");
anthraxIntestinalDis.setMiscComments("death results in 25% to 60% of cases");


// -------------- campylobacteriosis --------------
// (C) OntoOO Inc Wed Feb 23 15:35:47 PST 2005
Disease campylobacteriosisDis = new Disease(
   LR.campylobacteriosis, 
   "infection by bacteria campylobacter", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -3, //  duration 
   F.campylobacteriosisFreq,
   LR.intestinesSysSt, 
   LR.bacterialInfection
);
campylobacteriosisDis.setTemperature((float)101.0);
campylobacteriosisDis.addSymptom(LR.abdomenCramping, "", 1.0f);
campylobacteriosisDis.addSymptom(LR.abdomenPain, "", 1.0f);
campylobacteriosisDis.addSymptom(LR.diarrhea, "", 1.0f);
campylobacteriosisDis.addSymptom(LR.diarrheaBloody, "", 0.4f);
campylobacteriosisDis.addSymptom(LR.fatigue);
campylobacteriosisDis.addSymptom(LR.feverSym);
campylobacteriosisDis.addSymptom(LR.headache);
campylobacteriosisDis.addSymptom(LR.myalgia);;
campylobacteriosisDis.addSymptom(LR.nausea, "", 0.4f);
campylobacteriosisDis.addSymptom(LR.vomiting, "", 0.4f);
campylobacteriosisDis.addCausesDisease(LR.guillainBarreSyndrome);
campylobacteriosisDis.addReference("www.cdc.gov");
campylobacteriosisDis.setMiscComments(
   "only one in thousand may get the Guillain-Barr syndrome complication");
Treatment campylobacteriosisTr1 = new Treatment("campylobacteriosisTr1");
campylobacteriosisTr1.addTreatmentAction(LR.fluidIncrease);
campylobacteriosisDis.addTreatment("campylobacteriosisTr1");


    // ----------------  botulism --------------------------
// (C) OntoOO Inc Wed Oct 31 16:30:10 PST 2001
Disease botulismDis = new Disease(
   LR.botulism, 
   "infection caused by bacillus clostridium botulinum", 
   LR.infections,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.clostridiumBotulinumInfection
);

botulismDis.addSymptom(LR.diarrhea, "", 1.0f);
botulismDis.addSymptom(LR.diplopia, "", 1.0f);
botulismDis.addSymptom(LR.mouthDry, "", 1.0f);
botulismDis.addSymptom(LR.dysarthria, "", 1.0f);
botulismDis.addSymptom(LR.muscleWeakness, "in trunk or extremities", 1.0f);
botulismDis.addSymptom(LR.ptosis, "", 1.0f);
botulismDis.addSymptom(LR.throatSore, "", 1.0f);
botulismDis.addSymptom(LR.vomiting, "", 1.0f);
botulismDis.addSymptom(LR.weakness, "", 1.0f);
botulismDis.addReference("pp 177-8");
botulismDis.setMiscComments(
            "25% mortality due to respiratory failure during 1st week");
Treatment botulismTr1  = new Treatment("botulismTr1");
botulismTr1.addDrug(LR.botulinumAntitoxin);
botulismDis.addTreatment(botulismTr1.getName());


// -------------- candidiasis --------------
// (C) OntoOO Inc Thu Jan 22 11:08:10 PST 2004
Disease candidiasisDis = new Disease(
   LR.candidiasis, 
   "fungus infection caused by candida", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.candidaInfection
);
candidiasisDis.addReference("pp 205-7");
candidiasisDis.setMiscComments(
       "incidence increases due to the usage of " +
       "broad spectrum antibiotics that permits candida organisms to proliferate");
Treatment candidiasisTr1  = new Treatment("candidiasisTr1");
candidiasisTr1.addDrug(LR.nystatin);
candidiasisTr1.addDrug(LR.fluconazole);
candidiasisDis.addTreatment(candidiasisTr1.getName());


// -------------- candidiasisBrain --------------
// (C) OntoOO Inc Tue Feb 17 16:02:01 PST 2004
Disease candidiasisBrainDis = new Disease(
   LR.candidiasisBrain, 
   "fungus infection of the brain caused by candida", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.brainSysSt, 
   LR.none
);
candidiasisBrainDis.setPrintName("candidiasis brain");
candidiasisBrainDis.setSuperDisease(LR.candidiasis);
candidiasisBrainDis.setTemperature((float)101.0);
candidiasisBrainDis.addSymptom(LR.confusion);
candidiasisBrainDis.addSymptom(LR.disorientation);
candidiasisBrainDis.addSymptom(LR.feverSym);
candidiasisBrainDis.addSymptom(LR.headache);
candidiasisBrainDis.addSymptom(LR.nuchalRigidity);
candidiasisBrainDis.addSymptom(LR.seizure);
candidiasisBrainDis.addReference("pp 205-7");


// -------------- candidiasisEsophagus --------------
// (C) OntoOO Inc Mon Feb 16 11:08:31 PST 2004
Disease candidiasisEsophagusDis = new Disease(
   LR.candidiasisEsophagus, 
   "fungus infection of the esophagus caused by candida", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.esophagusSysSt, 
   LR.none
);
candidiasisEsophagusDis.setPrintName("candidiasis esophagus");
candidiasisEsophagusDis.setSuperDisease(LR.candidiasis);
candidiasisEsophagusDis.addSymptom(LR.dysphagia);
candidiasisEsophagusDis.addSymptom(LR.retrosternalChestPain);
candidiasisEsophagusDis.addSymptom(LR.vomiting);
candidiasisEsophagusDis.addSymptom(LR.mouthLesion, "", 0.1f); 
candidiasisEsophagusDis.addSymptom(LR.throatScale, "", 0.1f); 
candidiasisEsophagusDis.addReference("pp 205-7");


// -------------- candidiasisEye --------------
// (C) OntoOO Inc Tue Feb 17 17:03:03 PST 2004
Disease candidiasisEyeDis = new Disease(
   LR.candidiasisEye, 
   "fungus infection of the eyes caused by candida", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.eyesSysSt, 
   LR.none
);
candidiasisEyeDis.setPrintName("candidiasis eye");
candidiasisEyeDis.setSuperDisease(LR.candidiasis);
candidiasisEyeDis.setTemperature((float)101.0);
candidiasisEyeDis.addSymptom(LR.visionBlurred);
candidiasisEyeDis.addSymptom(LR.orbitPain);
candidiasisEyeDis.addSymptom(LR.eyeExudate);
candidiasisEyeDis.addReference("pp 205-7");


// -------------- candidiasisNails --------------
// (C) OntoOO Inc Mon Jan 26 18:21:23 PST 2004
Disease candidiasisNailsDis = new Disease(
   LR.candidiasisNails, 
   "fungus infection under the nails caused by candida", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
candidiasisNailsDis.setPrintName("candidiasis nails");
candidiasisNailsDis.setSuperDisease(LR.candidiasis);
candidiasisNailsDis.addSymptom(LR.nailBedRed);
candidiasisNailsDis.addSymptom(LR.nailBedSwollen);
candidiasisNailsDis.addReference("pp 205-7");


// -------------- candidiasisPulmonary --------------
// (C) OntoOO Inc Mon Feb 16 15:28:45 PST 2004
Disease candidiasisPulmonaryDis = new Disease(
   LR.candidiasisPulmonary, 
   "fungus infection of the lungs caused by candida", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.none
);
candidiasisPulmonaryDis.setPrintName("candidiasis pulmonary");
candidiasisPulmonaryDis.setSuperDisease(LR.candidiasis);
candidiasisPulmonaryDis.setTemperature((float)101.0);
candidiasisPulmonaryDis.addSymptom(LR.anorexia);
candidiasisPulmonaryDis.addSymptom(LR.cough);
candidiasisPulmonaryDis.addSymptom(LR.feverSym);
candidiasisPulmonaryDis.addSymptom(LR.hemoptysis);
candidiasisPulmonaryDis.addSymptom(LR.weakness);
candidiasisPulmonaryDis.addReference("pp 205-7");


// -------------- candidiasisRenal --------------
// (C) OntoOO Inc Tue Feb 17 15:46:25 PST 2004
Disease candidiasisRenalDis = new Disease(
   LR.candidiasisRenal, 
   "fungus infection of the kidneys caused by candida", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.none
);
candidiasisRenalDis.setPrintName("candidiasis renal");
candidiasisRenalDis.setSuperDisease(LR.candidiasis);
candidiasisRenalDis.setTemperature((float)101.0);
candidiasisRenalDis.addSymptom(LR.dysuria);
candidiasisRenalDis.addSymptom(LR.flankPain);
candidiasisRenalDis.addSymptom(LR.hematuria);
candidiasisRenalDis.addSymptom(LR.pyuria);
candidiasisRenalDis.addSymptom(LR.urineCloudy);
candidiasisRenalDis.addReference("pp 205-7");


// -------------- candidiasisSkin --------------
// (C) OntoOO Inc Thu Jan 22 13:46:59 PST 2004
Disease candidiasisSkinDis = new Disease(
   LR.candidiasisSkin, 
   "fungus infection caused by candida below breast, between fingers, groin, etc.", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
candidiasisSkinDis.setPrintName("candidiasis skin");
candidiasisSkinDis.setSuperDisease(LR.candidiasis);
candidiasisSkinDis.addSymptom(LR.rash);
candidiasisSkinDis.addSymptom(LR.rashErupting);
candidiasisSkinDis.addSymptom(LR.rashScaly);
candidiasisSkinDis.addSymptom(LR.rashRed);
candidiasisSkinDis.addSymptom(LR.rashPapular);
candidiasisSkinDis.addReference("pp 205-7");
candidiasisSkinDis.setMiscComments(
    "especially below breast, between fingers, groin, navel, etc.");


// subdisease of candidiasis .................
// -------------- thrush --------------
// (C) OntoOO Inc Tue Jan 27 15:46:09 PST 2004
Disease thrushDis = new Disease(
   LR.thrush, 
   "fungus infection in the mouth caused by candida", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mouthSysSt, 
   LR.none
);
thrushDis.setSuperDisease(LR.candidiasis);
thrushDis.addSymptom(LR.mouthPain);
thrushDis.addSymptom(LR.mouthPatchWhite);
thrushDis.addSymptom(LR.mouthPatchYellow);
thrushDis.addReference("pp 205-7");


// -------------- cryptosporidiosis --------------
// (C) OntoOO Inc Thu Feb 24 10:29:21 PST 2005
Disease cryptosporidiosisDis = new Disease(
   LR.cryptosporidiosis, 
   "infection by protozoa cryptosporidium", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   F.cryptosporidiosisFreq,
   LR.intestinesSysSt, 
   LR.protozoanInfection
);
cryptosporidiosisDis.setTemperature((float)101.0);
cryptosporidiosisDis.addSymptom(LR.abdomenCramping);
cryptosporidiosisDis.addSymptom(LR.anorexia);
cryptosporidiosisDis.addSymptom(LR.diarrheaWatery);
cryptosporidiosisDis.addSymptom(LR.gas);
cryptosporidiosisDis.addSymptom(LR.malaise);
cryptosporidiosisDis.addSymptom(LR.myalgia);
cryptosporidiosisDis.addSymptom(LR.nausea);
cryptosporidiosisDis.addSymptom(LR.vomiting);
cryptosporidiosisDis.setMiscComments("no treatment required if otherwise healthy");


// -------------- epsteinBarrDisease --------------
// (C) OntoOO Inc Wed May 29 15:10:31 PDT 2002
Disease epsteinBarrDiseaseDis = new Disease(
   LR.epsteinBarrDisease, 
   "infection by Epstein-Barr virus", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
epsteinBarrDiseaseDis.setPrintName("Epstein-Barr Disease / mononucleosis");
epsteinBarrDiseaseDis.setTemperature((float)101.0);
epsteinBarrDiseaseDis.addSymptom(LR.feverSym);
epsteinBarrDiseaseDis.addSymptom(LR.lymphadenopathy);
epsteinBarrDiseaseDis.addSymptom(LR.throatSore);
epsteinBarrDiseaseDis.addExternalCause(LR.epsteinBarrVirus);
epsteinBarrDiseaseDis.addReference("pp 1286-7");


// -------------- escherichiaColi --------------
// (C) OntoOO Inc Wed Mar 23 15:02:33 PST 2005
Disease escherichiaColiDis = new Disease(
   LR.escherichiaColi, 
   "infection by E.coli bacilli among which the variant 0157:H7 due to undercooked food", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -3, //  duration 
   F.escherichiaColiFreq,
   LR.intestinesSysSt, 
   LR.none
);
escherichiaColiDis.setPrintName("escherichia coli");
escherichiaColiDis.addSymptom(LR.abdomenCramping);
escherichiaColiDis.addSymptom(LR.diarrheaBloody);
escherichiaColiDis.addSymptom(LR.feverSym, "", 0.5f);
escherichiaColiDis.addSymptom(LR.irritability);
escherichiaColiDis.addSymptom(LR.nausea);
escherichiaColiDis.addSymptom(LR.vomiting);
escherichiaColiDis.addReference("pp 187-8");
escherichiaColiDis.setMiscComments("young children are at risk for serious complications");
Treatment escherichiaColiTr1  = new Treatment("escherichiaColiTr1");
escherichiaColiTr1.addTreatmentAction(LR.fluidManagement);
escherichiaColiDis.addTreatment(escherichiaColiTr1.getName());


// -------------- flu --------------
// (C) OntoOO Inc Fri Feb 28 15:59:47 PST 2003
Disease fluDis = new Disease(
   LR.flu, 
   "contagious infection of the respiratory tract", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.respiratorySysSt, 
   LR.none
);
fluDis.setTemperature((float)102.5);
fluDis.addSymptom(LR.chills);
fluDis.addSymptom(LR.cough);
fluDis.addSymptom(LR.headache);
fluDis.addSymptom(LR.hoarseness);
fluDis.addSymptom(LR.malaise);
fluDis.addSymptom(LR.myalgia);
fluDis.addSymptom(LR.rhinitis);
fluDis.addSymptom(LR.noseDischarge);
fluDis.addExternalCause(LR.myxovirusInfluenzaeInfection);
fluDis.addCausesDisease(LR.conjunctivitis);
fluDis.addCausesDisease(LR.laryngitis);
fluDis.addReference("pp 220-1");
Treatment fluTr1  = new Treatment("fluTr1");
fluTr1.addTreatmentAction(LR.bedRest);
fluTr1.addTreatmentAction(LR.fluidIncrease);
fluTr1.addDrug(LR.aspirin);
fluTr1.addDrug(LR.antitussive);
fluDis.addTreatment(fluTr1.getName());


// -------------- gasGangrene --------------
// (C) OntoOO Inc Fri Nov 16 13:07:59 PST 2001
Disease gasGangreneDis = new Disease(
   LR.gasGangrene, 
   "local infection of tissue with bad circulation due to trauma/ surgery/ etc.", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.clostridiumPerfringensInfection
);
gasGangreneDis.setPrintName("gas gangrene");
gasGangreneDis.setTemperature((float)100.0);

gasGangreneDis.addSymptom(LR.discoloration, "", 1.0f);
gasGangreneDis.addSymptom(LR.stoolMalodorous);
gasGangreneDis.addSymptom(LR.hypotension, "", 1.0f);
gasGangreneDis.addSymptom(LR.infectionSiteCrepitation, "", 1.0f);
gasGangreneDis.addSymptom(LR.pain);
gasGangreneDis.addSymptom(LR.tachycardia, "", 1.0f);
gasGangreneDis.addSymptom(LR.tachypnea, "", 1.0f);
gasGangreneDis.addCausesAbnormalCondition(LR.hypovolemia);
gasGangreneDis.addReference("pp 178-80");

Treatment gasGangreneTr1 = new Treatment("gasGangreneTr1");
gasGangreneTr1.addTreatmentAction(LR.IVFluids);
gasGangreneTr1.addTreatmentAction(LR.surgery);
gasGangreneTr1.addTreatmentAction(LR.hyperbaricOxygen);
gasGangreneTr1.addTreatmentAction(LR.painManagement);
gasGangreneTr1.addDrug(LR.antibiotics);
gasGangreneDis.addTreatment(gasGangreneTr1.getName()); 


// -------------- giardiasis --------------
// (C) OntoOO Inc Fri Feb 25 10:19:18 PST 2005
Disease giardiasisDis = new Disease(
   LR.giardiasis, 
   "bowel infection due to the protozoa giardia lamblia", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -3, //  duration 
   F.giardiasisFreq,
   LR.intestinesSysSt, 
   LR.protozoanInfection
);
giardiasisDis.addSymptom(LR.abdomenCramping, "", 1.0f);
giardiasisDis.addSymptom(LR.nausea, "", 1.0f);
giardiasisDis.addSymptom(LR.diarrheaWatery);
giardiasisDis.addSymptom(LR.gas);
giardiasisDis.addSymptom(LR.stoolFrequent);
giardiasisDis.addSymptom(LR.stoolGreasy);
giardiasisDis.addSymptom(LR.stoolMalodorous); 
giardiasisDis.addReference("pp 256-7");
giardiasisDis.setMiscComments("the chronic variant causes faitigue and weight loss");
Treatment giardiasisTr1 = new Treatment("giardiasisTr1");
giardiasisTr1.addDrug(LR.metronidazole);
giardiasisDis.addTreatment("giardiasisTr1");


// -------------- herpesSimplex --------------
// (C) OntoOO Inc Sun Apr 21 15:59:36 PDT 2002
Disease herpesSimplexDis = new Disease(
   LR.herpesSimplex, 
   "viral infection by herpesvirus hominis", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.herpesSimplexVirus
);
herpesSimplexDis.setPrintName("herpes simplex");
herpesSimplexDis.addReference("pp 228-32");
herpesSimplexDis.setCode358(42);
herpesSimplexDis.setICD10code("B00");


// -------------- herpesSimplex1 --------------
// (C) OntoOO Inc Mon Apr 07 17:01:18 PDT 2003
Disease herpesSimplex1Dis = new Disease(
   LR.herpesSimplex1, 
   "viral infection by herpesvirus hominis - non genital variant", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.herpesSimplexVirus
);
herpesSimplex1Dis.setPrintName("herpes simplex 1");
herpesSimplex1Dis.setSuperDisease(LR.herpesSimplex);
herpesSimplex1Dis.addSymptom(LR.vesicleMouth, "they rupture and leave painful ulcer with yellow crust", 1.0f);
herpesSimplex1Dis.addSymptom(LR.vesicleCheek, "they rupture and leave painful ulcer with yellow crust", 1.0f);
herpesSimplex1Dis.addReference("pp 228-32");
Treatment herpesSimplex1Tr1 = new Treatment("herpesSimplex1Tr1", LR.ifFever);
herpesSimplex1Tr1.addDrug(LR.analgetics);
herpesSimplex1Tr1.addDrug(LR.antipyretic);
herpesSimplex1Dis.addTreatment("herpesSimplex1Tr1");
herpesSimplex1Dis.addIllustration(D.HerpesSimplexJpg);
herpesSimplex1Dis.setCode358(42);
herpesSimplex1Dis.setICD10code("B00");


// -------------- herpesZoster --------------
// (C) OntoOO Inc Sun Apr 06 17:00:06 PDT 2003
Disease herpesZosterDis = new Disease(
   LR.herpesZoster, 
   "viral infection by herpesvirus varicella", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.herpesvirusVaricella
);
herpesZosterDis.setPrintName("herpes zoster - shingles");
herpesZosterDis.setTemperature((float)102.0);
herpesZosterDis.addReference("pp 230-2");
herpesZosterDis.setMiscComments("virus causes first chicken pox");
Treatment herpesZosterTr1 = new Treatment("herpesZosterTr1");
herpesZosterTr1.addDrug(LR.antipruritics);
herpesZosterTr1.addDrug(LR.aspirin);
herpesZosterDis.addTreatment("herpesZosterTr1");
Treatment herpesZosterTr2 = new Treatment("herpesZosterTr2", LR.ifInfection);
herpesZosterTr2.addDrug(LR.antibiotics);
herpesZosterDis.addTreatment("herpesZosterTr2");
Treatment herpesZosterTr3 = new Treatment("herpesZosterTr3", LR.ifRash);
herpesZosterTr3.addDrug(LR.acyclovir);
herpesZosterDis.addTreatment(herpesZosterTr3.getName()); 
herpesZosterDis.setCode358(43);
herpesZosterDis.setICD10code("B02");


// -------------- herpesZoster1 --------------
// (C) OntoOO Inc Sun Apr 06 17:40:03 PDT 2003
Disease herpesZoster1Dis = new Disease(
   LR.herpesZoster1, 
   "viral infection by herpesvirus varicella", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
herpesZoster1Dis.setPrintName("herpes zoster stage 1");
herpesZoster1Dis.setSuperDisease(LR.herpesZoster);
herpesZoster1Dis.setTemperature((float)102.0);
herpesZoster1Dis.addSymptom(LR.malaise, "", 1.0f);
herpesZoster1Dis.addSymptom(LR.painDeep);
herpesZoster1Dis.addSymptom(LR.paresthesia);
herpesZoster1Dis.addSymptom(LR.pruritus);
herpesZoster1Dis.addCausesDisease(LR.herpesZoster2);
herpesZoster1Dis.addReference("pp 230-2");
herpesZoster1Dis.setMiscComments("stage last 1-4 weeks");
herpesZoster1Dis.setCode358(43);
herpesZoster1Dis.setICD10code("B02");


// -------------- herpesZoster2 --------------
// (C) OntoOO Inc Sun Apr 06 19:32:09 PDT 2003
Disease herpesZoster2Dis = new Disease(
   LR.herpesZoster2, 
   "viral infection by herpesvirus varicella", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
herpesZoster2Dis.setPrintName("herpes zoster stage 2");
herpesZoster2Dis.setSuperDisease(LR.herpesZoster);
herpesZoster2Dis.setTemperature((float)102.0);
herpesZoster2Dis.addSymptom(LR.malaise, "", 1.0f);
herpesZoster2Dis.addSymptom(LR.painDeep, "", 1.0f);
herpesZoster2Dis.addSymptom(LR.skinLesionRedNodule, "", 1.0f);
herpesZoster2Dis.addSymptom(LR.vesicle, "nodules change quickly into vesicles", 1.0f);
herpesZoster2Dis.addInternalCause(LR.herpesZoster1);
herpesZoster2Dis.addCausesDisease(LR.herpesZoster3);
herpesZoster2Dis.addReference("pp 230-2");
herpesZoster2Dis.setMiscComments("stage last 1-2 weeks");
herpesZoster2Dis.setCode358(43);
herpesZoster2Dis.setICD10code("B02");


// -------------- herpesZoster3 --------------
// (C) OntoOO Inc Mon Apr 07 15:20:32 PDT 2003
Disease herpesZoster3Dis = new Disease(
   LR.herpesZoster3, 
   "viral infection by herpesvirus varicella", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
herpesZoster3Dis.setPrintName("herpes zoster stage 3");
herpesZoster3Dis.setSuperDisease(LR.herpesZoster);
herpesZoster3Dis.setTemperature((float)102.0);
herpesZoster3Dis.addSymptom(LR.malaise, "", 1.0f);
herpesZoster3Dis.addSymptom(LR.painDeep, "", 1.0f);
herpesZoster2Dis.addSymptom(LR.vesicle, "", 1.0f);
herpesZoster3Dis.addSymptom(LR.scab, "the vesicles turn into scabs", 1.0f);
herpesZoster3Dis.addInternalCause(LR.herpesZoster2);
herpesZoster3Dis.addCausesDisease(LR.postherpeticNeuralgia);
herpesZoster3Dis.addReference("pp 230-2");
herpesZoster3Dis.setCode358(43);
herpesZoster3Dis.setICD10code("B02");


// -------------- postherpeticNeuralgia --------------
// (C) OntoOO Inc Fri Apr 11 14:21:38 PDT 2003
Disease postherpeticNeuralgiaDis = new Disease(
   LR.postherpeticNeuralgia, 
   "late stage viral infection by herpesvirus varicella", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   50, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
postherpeticNeuralgiaDis.setPrintName("postherpetic neuralgia");
postherpeticNeuralgiaDis.setSuperDisease(LR.herpesZoster);
postherpeticNeuralgiaDis.setTemperature((float)102.0);
postherpeticNeuralgiaDis.addSymptom(LR.painDeep, "", 1.0f);
postherpeticNeuralgiaDis.addSymptom(LR.painBurning, "", 1.0f);
postherpeticNeuralgiaDis.addSymptom(LR.painStabbing, "", 1.0f);
postherpeticNeuralgiaDis.addSymptom(LR.painGnawing, "", 1.0f);
postherpeticNeuralgiaDis.addInternalCause(LR.herpesZoster3);
postherpeticNeuralgiaDis.addReference("pp 230-2");
postherpeticNeuralgiaDis.setMiscComments(
      "symptoms decrease often over time by themselves");


// -------------- listeriosisSuper --------------
// (C) OntoOO Inc Thu Mar 31 12:59:28 PST 2005
Disease listeriosisSuperDis = new Disease(
   LR.listeriosisSuper, 
   "infection caused by the bacillus listeria monocytogenes affects " +
   "fetus, neonates, older adults and immunosuppressed", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -5, //  duration 
   F.listeriosisSuperFreq,
   LR.bodySysSt, 
   LR.none
);
listeriosisSuperDis.setPrintName("listeriosis super");
listeriosisSuperDis.setTemperature((float)103.0);
listeriosisSuperDis.addSymptom(LR.diarrhea, "", 0.05f);
listeriosisSuperDis.addSymptom(LR.feverSym);
listeriosisSuperDis.addSymptom(LR.myalgia, "", 1.0f);
listeriosisSuperDis.addSymptom(LR.nausea, "", 0.05f);
listeriosisSuperDis.addSymptom(LR.vomiting, "", 0.05f);
listeriosisSuperDis.addCausesDisease(LR.meningitis);
listeriosisSuperDis.addReference("pp 174-5");
Treatment listeriosisSuperTr1  = new Treatment("listeriosisSuperTr1");
listeriosisSuperTr1.addDrug(LR.ampicillin);
listeriosisSuperTr1.addDrug(LR.penicillin);
listeriosisSuperDis.addTreatment(listeriosisSuperTr1.getName());


// -------------- listeriosisPregnant --------------
// (C) OntoOO Inc Thu Mar 31 13:44:56 PST 2005
Disease listeriosisPregnantDis = new Disease(
   LR.listeriosisPregnant, 
   "infection caused by the bacillus listeria monocytogenes", 
   LR.infections, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -5, //  duration 
   F.listeriosisPregnantFreq,
   LR.bodySysSt, 
   LR.none
);
listeriosisPregnantDis.setPrintName("listeriosis pregnant");
listeriosisPregnantDis.setSuperDisease(LR.listeriosisSuper);
listeriosisPregnantDis.setTemperature((float)103.0);
listeriosisPregnantDis.setStatusCondition("pregnant");
listeriosisPregnantDis.addSymptom(LR.backPain);
listeriosisPregnantDis.addSymptom(LR.chills);
listeriosisPregnantDis.addSymptom(LR.irritability, "", 0.4f);
listeriosisPregnantDis.addSymptom(LR.malaise);
listeriosisPregnantDis.addReference("pp 174-5");
listeriosisPregnantDis.setMiscComments(
   "risk of damage to the fetus also causing abortion, premature delivery, stillbirth");


// -------------- listeriosis --------------
// (C) OntoOO Inc Thu Mar 31 14:32:58 PST 2005
Disease listeriosisDis = new Disease(
   LR.listeriosis, 
   "infection caused by the bacillus listeria monocytogenes", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -5, //  duration 
   F.listeriosisFreq,
   LR.bodySysSt, 
   LR.none
);
listeriosisDis.setSuperDisease(LR.listeriosisSuper);
listeriosisDis.setTemperature((float)103.0);
listeriosisDis.addSymptom(LR.convulsions, "", 0.1f);
listeriosisDis.addSymptom(LR.headache, "", 0.1f);
listeriosisDis.addSymptom(LR.lossOfBalance, "", 0.1f);
listeriosisDis.addSymptom(LR.malaise, "", 1.0f);
listeriosisDis.addSymptom(LR.neckStiff, "", 0.1f);
listeriosisDis.addReference("pp 174-5");


// -------------- lymeDisease --------------
// (C) OntoOO Inc Wed Mar 26 16:44:53 PST 2003
Disease lymeDiseaseDis = new Disease(
   LR.lymeDisease, 
   "infection due to tick bite leading weeks or months later to cardiac and " +
   "neurologic abnormalities and possibly arthritis of the large joints", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   F.lymeDiseaseFreq,
   LR.bodySysSt, 
   LR.none
);
lymeDiseaseDis.setPrintName("lyme disease");
lymeDiseaseDis.addExternalCause(LR.borreliaBurgdorferiSpirochete);
lymeDiseaseDis.addInternalCause(LR.tickBite);
lymeDiseaseDis.addCausesDisease(LR.encephalitis);
lymeDiseaseDis.addReference("pp 199-200");
lymeDiseaseDis.setMiscComments("there are 3 stages");
Treatment lymeDiseaseTr1  = new Treatment("lymeDiseaseTr1");
lymeDiseaseTr1.addDrug(LR.antibiotics);
lymeDiseaseDis.addTreatment(lymeDiseaseTr1.getName());
lymeDiseaseDis.setCode358(33);
lymeDiseaseDis.setICD10code("A69");


// -------------- lymeDisease1 --------------
// (C) OntoOO Inc Wed Mar 26 17:08:40 PST 2003
Disease lymeDisease1Dis = new Disease(
   LR.lymeDisease1, 
   "infection due to tick bite leading weeks or months later to cardiac and " +
   "neurologic abnormalities and possibly arthritis of the large joints", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -5, //  duration 
   F.lymeDisease1Freq,
   LR.bodySysSt, 
   LR.none
);
lymeDisease1Dis.setPrintName("lyme disease stage 1");
lymeDisease1Dis.setSuperDisease(LR.lymeDisease);
lymeDisease1Dis.setTemperature((float)101.0);
lymeDisease1Dis.addSymptom(LR.throatSore, "before skin eruption", 0.05f);
lymeDisease1Dis.addSymptom(LR.coughDry, "before skin eruption", 0.05f);
lymeDisease1Dis.addSymptom(LR.papuleRedWarm, 
			   "resembles a bull eye and may grow to 20 inch (50 cm)", 1.0f);
lymeDisease1Dis.addSymptom(LR.blotchesRed, 
			   "after 3-4 weeks and they last several more weeks", 1.0f);
lymeDisease1Dis.addSymptom(LR.chills, "intermittent", 0.2f);
lymeDisease1Dis.addSymptom(LR.fatigue, "", 1.0f);
lymeDisease1Dis.addSymptom(LR.headache, "intermittent", 0.2f);
lymeDisease1Dis.addSymptom(LR.lymphadenopathy, "inytermittent", 0.2f);
lymeDisease1Dis.addSymptom(LR.malaise, "", 1.0f);
lymeDisease1Dis.addSymptom(LR.neckStiff, "intermittent", 0.2f);
lymeDisease1Dis.addSymptom(LR.myalgia, "migrating", 0.1f);
lymeDisease1Dis.addCausesDisease(LR.lymeDisease2);
lymeDisease1Dis.addCausesDisease(LR.hepatitis);
lymeDisease1Dis.addCausesAbnormalCondition(LR.splenomegaly); 
lymeDisease1Dis.addReference("pp 199-200");
lymeDisease1Dis.setCode358(33);
lymeDisease1Dis.setICD10code("A69");


// -------------- lymeDisease2 --------------
// (C) OntoOO Inc Thu Mar 27 10:39:42 PST 2003
Disease lymeDisease2Dis = new Disease(
   LR.lymeDisease2, 
   "infection due to tick bite leading weeks or months later to cardiac and " +
   "neurologic abnormalities and possibly arthritis of the large joints", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -10, //  duration 
   F.lymeDisease2Freq,
   LR.bodySysSt, 
   LR.none
);
lymeDisease2Dis.setPrintName("lyme disease stage 2");
lymeDisease2Dis.setSuperDisease(LR.lymeDisease);
lymeDisease2Dis.addSymptom(LR.palsyFace);
lymeDisease2Dis.addInternalCause(LR.lymeDisease1);
lymeDisease2Dis.addCausesDisease(LR.lymeDisease3);
lymeDisease2Dis.addCausesDisease(LR.meningitis);
lymeDisease2Dis.addCausesAbnormalCondition(LR.cardiacEnlargement);
lymeDisease2Dis.addCausesAbnormalCondition(LR.neurologicDeficiences);
lymeDisease2Dis.addCausesAbnormalCondition(LR.atrioventricularHeartBlock);
lymeDisease2Dis.addCausesAbnormalCondition(LR.leftVentricularDysfunction);
lymeDisease2Dis.addReference("pp 199-200");
lymeDisease2Dis.setMiscComments("heart problems last only a few weeks but can be fatal");
lymeDisease2Dis.setCode358(33);
lymeDisease2Dis.setICD10code("A69");


// -------------- lymeDisease3 --------------
// (C) OntoOO Inc Sun Mar 30 08:33:52 PST 2003
Disease lymeDisease3Dis = new Disease(
   LR.lymeDisease3, 
   "infection due to tick bite leading weeks or months later to cardiac and " +
   "neurologic abnormalities and possibly arthritis of the large joints", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -10, //  duration 
   F.lymeDisease3Freq,
   LR.bodySysSt, 
   LR.none
);
lymeDisease3Dis.setPrintName("lyme disease stage 3");
lymeDisease3Dis.setSuperDisease(LR.lymeDisease);
lymeDisease3Dis.addSymptom(LR.myalgia);
lymeDisease3Dis.addSymptom(LR.jointSwelling);
lymeDisease3Dis.addInternalCause(LR.lymeDisease2);
lymeDisease3Dis.addCausesDisease(LR.arthritis);
lymeDisease3Dis.addReference("pp 199-200");
lymeDisease3Dis.setCode358(33);
lymeDisease3Dis.setICD10code("A69");


// -------------- malaria --------------
// (C) OntoOO Inc Sun Sep 08 19:16:56 PDT 2002
Disease malariaDis = new Disease(
   LR.malaria, 
   "acute infection by a protozoa of the genus Plasmodicum, which is transmitted by mosquitos", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   F.malariaFreq,
   LR.liverSysSt, 
   LR.none
);
malariaDis.setTemperature((float)105.0);
malariaDis.addSymptom(LR.chills);
malariaDis.addSymptom(LR.headache);
malariaDis.addSymptom(LR.myalgia);
malariaDis.addSymptom(LR.shaking);
malariaDis.addSymptom(LR.sweating);
malariaDis.addCausesDisease(LR.malaria2);
malariaDis.addReference("pp 250-4");
malariaDis.setMiscComments("10% mortality when untreated due to DIC");
Treatment malariaTr1  = new Treatment("malariaTr1");
malariaTr1.addDrug(LR.chloroquine);
malariaDis.addTreatment(malariaTr1.getName());
malariaDis.setCode358(58);
malariaDis.setICD10code("B50");


// -------------- malaria2 --------------
// (C) OntoOO Inc Sun Sep 08 20:12:46 PDT 2002
Disease malaria2Dis = new Disease(
   LR.malaria2, 
   "acute infection by a protozoa falciparum which is transmitted by mosquitos", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   F.malaria2Freq,
   LR.liverSysSt, 
   LR.none
);
malaria2Dis.setPrintName("malaria falciparum");
malaria2Dis.setTemperature((float)105.0);
malaria2Dis.addSymptom(LR.abdomenPain, "", 1.0f);
malaria2Dis.addSymptom(LR.anuria, "", 1.0f);
malaria2Dis.addSymptom(LR.coma, "", 1.0f);
malaria2Dis.addSymptom(LR.cough, "", 1.0f);
malaria2Dis.addSymptom(LR.delirium, "", 1.0f);
malaria2Dis.addSymptom(LR.diarrhea, "", 1.0f);
malaria2Dis.addSymptom(LR.hemoptysis, "", 1.0f);
malaria2Dis.addSymptom(LR.oliguria, "", 1.0f);
malaria2Dis.addSymptom(LR.seizure, "", 1.0f);
malaria2Dis.addSymptom(LR.vomiting, "", 1.0f);
malaria2Dis.addSymptom(LR.hemiparesis);
malaria2Dis.addSymptom(LR.melena);
malaria2Dis.addInternalCause(LR.malaria);
malaria2Dis.addCausesDisease(LR.disseminatedIntravascularCoagulation);
malaria2Dis.addCausesAbnormalCondition(LR.uremia);
malaria2Dis.addReference("pp 250-4");
malaria2Dis.setMiscComments("10% mortality when untreated due to DIC");
malaria2Dis.setCode358(58);
malaria2Dis.setICD10code("B50");


// -------------- meningococcemia --------------
// (C) OntoOO Inc Thu Apr 03 17:27:11 PST 2003
Disease meningococcemiaDis = new Disease(
   LR.meningococcemia, 
   "bacterial infection", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   F.meningococcemiaFreq,
   LR.bodySysSt, 
   LR.neisseriaMeningitidisInfection
);
meningococcemiaDis.setTemperature((float)102.0);
meningococcemiaDis.addSymptom(LR.arthralgia);
meningococcemiaDis.addSymptom(LR.chills);
meningococcemiaDis.addSymptom(LR.cough);
meningococcemiaDis.addSymptom(LR.headache);
meningococcemiaDis.addSymptom(LR.hypotension);
meningococcemiaDis.addSymptom(LR.myalgia);
meningococcemiaDis.addSymptom(LR.rash);
meningococcemiaDis.addSymptom(LR.tachycardia);
meningococcemiaDis.addSymptom(LR.tachypnea);
meningococcemiaDis.addSymptom(LR.throatSore);
meningococcemiaDis.addCausesDisease(LR.meningococcemiaSevere);
meningococcemiaDis.addReference("pp 172-3");
Treatment meningococcemiaTr1 = new Treatment("meningococcemiaTr1");
meningococcemiaTr1.addDrug(LR.ampicillin);
meningococcemiaTr1.addDrug(LR.penicillinG);
meningococcemiaDis.addTreatment("meningococcemiaTr1");
Treatment meningococcemiaTr2  = new Treatment("meningococcemiaTr2");
meningococcemiaTr2.addTreatmentAction(LR.bedRest);
meningococcemiaTr2.addTreatmentAction(LR.electrolyteReplacement);
meningococcemiaTr2.addTreatmentAction(LR.fluidManagement);
meningococcemiaDis.addTreatment(meningococcemiaTr2.getName());
meningococcemiaDis.setCode358(22);
meningococcemiaDis.setICD10code("A39");


// -------------- meningococcemiaSevere --------------
// (C) OntoOO Inc Fri Apr 04 15:45:47 PST 2003
Disease meningococcemiaSevereDis = new Disease(
   LR.meningococcemiaSevere, 
   "bacterial infection ", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   F.meningococcemiaSevereFreq,
   LR.bodySysSt, 
   LR.neisseriaMeningitidisInfection
);
meningococcemiaSevereDis.setPrintName("meningococcemia severe");
// meningococcemiaSevereDis.setSuperDisease(LR.meningococcemia);
meningococcemiaSevereDis.addSymptom(LR.skinLesionEnlarged);
meningococcemiaSevereDis.setTemperature((float)102.0);
meningococcemiaSevereDis.addSymptom(LR.arthralgia);
meningococcemiaSevereDis.addSymptom(LR.chills);
meningococcemiaSevereDis.addSymptom(LR.cough);
meningococcemiaSevereDis.addSymptom(LR.headache);
meningococcemiaSevereDis.addSymptom(LR.hypotension);
meningococcemiaSevereDis.addSymptom(LR.myalgia);
meningococcemiaSevereDis.addSymptom(LR.rash);
meningococcemiaSevereDis.addSymptom(LR.tachycardia);
meningococcemiaSevereDis.addSymptom(LR.tachypnea);
meningococcemiaSevereDis.addSymptom(LR.throatSore);
meningococcemiaSevereDis.setTemperature((float)102.0);
meningococcemiaSevereDis.addInternalCause(LR.meningococcemia);
meningococcemiaSevereDis.addCausesDisease(LR.disseminatedIntravascularCoagulation);
meningococcemiaSevereDis.addCausesAbnormalCondition(LR.shock);
meningococcemiaSevereDis.addReference("pp 172-3");
meningococcemiaSevereDis.setMiscComments(
   "upto 20% that have meningococcemia develop into this stage, is fatal without prompt treatment");
meningococcemiaSevereDis.addTreatment("meningococcemiaTr1");
meningococcemiaSevereDis.addTreatment("meningococcemiaTr1");


// -------------- mumps --------------
// (C) OntoOO Inc Wed May 29 16:10:44 PDT 2002
Disease mumpsDis = new Disease(
   LR.mumps, 
   "infection by paramyxovirus", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   6, //  minAge 
   8, //  maxAge 
   -4, //  duration 
   F.mumpsFreq,
   LR.bodySysSt, 
   LR.none
);
mumpsDis.addSymptom(LR.anorexia);
// mumpsDis.addSymptom(LR.headache);
mumpsDis.addSymptom(LR.chills);
mumpsDis.addSymptom(LR.fatigue);
mumpsDis.addSymptom(LR.feverSym);
mumpsDis.addSymptom(LR.malaise);
mumpsDis.addSymptom(LR.myalgia);
mumpsDis.addSymptom(LR.parotidGlandsSwollen);
mumpsDis.addSymptom(LR.throatSore);
mumpsDis.addSymptom(LR.weakness);
mumpsDis.addReference("pp 238-9");
Treatment mumpsTr1  = new Treatment("mumpsTr1");
mumpsTr1.addTreatmentAction(LR.ifFeverProvideAntipyretic);
mumpsTr1.addDrug(LR.analgetics);
mumpsDis.addTreatment(mumpsTr1.getName());


/*
// -------------- mumps1 --------------
// (C) OntoOO Inc Wed May 29 16:10:44 PDT 2002
Disease mumps1Dis = new Disease(
   LR.mumps1, 
   "infection by paramyxovirus", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   6, //  minAge 
   8, //  maxAge 
   -4, //  duration 
   F.mumps1Freq,
   LR.bodySysSt, 
   LR.none
);
mumps1Dis.setSuperDisease(LR.mumps);
mumps1Dis.addCausesDisease(LR.mumps2);
mumps1Dis.addReference("pp 238-9");


// -------------- mumps2 --------------
// (C) OntoOO Inc Wed May 29 17:07:20 PDT 2002
Disease mumps2Dis = new Disease(
   LR.mumps2, 
   "2nd phase of mumps", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   6, //  minAge 
   8, //  maxAge 
   -4, //  duration 
   F.mumps2Freq,
   LR.bodySysSt, 
   LR.none
);
mumps2Dis.setSuperDisease(LR.mumps);
mumps2Dis.setTemperature((float)102.5);
mumps2Dis.addSymptom(LR.earache);
mumps2Dis.addSymptom(LR.parotidGlandsSwollen);
mumps2Dis.addInternalCause(LR.mumps1);
mumps2Dis.addReference("pp 238-9");
*/

    // ----------------  poliomyelitis --------------------------
// (C) OntoOO Inc Tue Jul 17 17:15:48 PDT 2001
// (C) OntoOO Inc Tue Oct 12 13:26:11 GMT-08:00 2004
Disease poliomyelitisDis = new Disease(
   LR.poliomyelitis, 
   "virus infection that ranges from inapparent infection to fatal paralysis", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge,
   -7, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.poliovirus
);
poliomyelitisDis.setTemperature((float)99.8);
poliomyelitisDis.addReference("pp 234-237");
poliomyelitisDis.setCode358(37);
poliomyelitisDis.setICD10code("A80");


// -------------- poliomyelitisMinor --------------
// (C) OntoOO Inc Tue Oct 12 13:06:51 GMT-08:00 2004
Disease poliomyelitisMinorDis = new Disease(
   LR.poliomyelitisMinor, 
   "polio virus infection of short duration", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge,
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
poliomyelitisMinorDis.setPrintName("poliomyelitis minor");
poliomyelitisMinorDis.setSuperDisease(LR.poliomyelitis);
poliomyelitisMinorDis.setTemperature((float)101.0);
poliomyelitisMinorDis.addSymptom(LR.abdomenPain);
poliomyelitisMinorDis.addSymptom(LR.constipation);
poliomyelitisMinorDis.addSymptom(LR.feverSym);
poliomyelitisMinorDis.addSymptom(LR.headache, "", 1.0f);
poliomyelitisMinorDis.addSymptom(LR.malaise, "", 1.0f);
poliomyelitisMinorDis.addSymptom(LR.nausea);
poliomyelitisMinorDis.addSymptom(LR.throatSore, "", 1.0f);
poliomyelitisMinorDis.addSymptom(LR.vomiting, "", 1.0f);
poliomyelitisMinorDis.addReference("pp 234-237");
poliomyelitisMinorDis.setCode358(37);
poliomyelitisMinorDis.setICD10code("A80");


// -------------- poliomyelitisNonparalytic --------------
// (C) OntoOO Inc Tue Oct 12 14:36:16 GMT-08:00 2004
Disease poliomyelitisNonparalyticDis = new Disease(
   LR.poliomyelitisNonparalytic, 
   "polio virus infection of longer duration but no paralysis", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
poliomyelitisNonparalyticDis.setPrintName("poliomyelitis nonparalytic");
poliomyelitisNonparalyticDis.setSuperDisease(LR.poliomyelitis);
poliomyelitisNonparalyticDis.setTemperature((float)101.0);
poliomyelitisNonparalyticDis.addSymptom(LR.headache, "", 1.0f);
poliomyelitisNonparalyticDis.addSymptom(LR.vomiting, "", 1.0f);
poliomyelitisNonparalyticDis.addSymptom(LR.abdomenPain);
poliomyelitisNonparalyticDis.addSymptom(LR.armPain);
poliomyelitisNonparalyticDis.addSymptom(LR.backPain);
poliomyelitisNonparalyticDis.addSymptom(LR.irritability);
poliomyelitisNonparalyticDis.addSymptom(LR.legPain);
poliomyelitisNonparalyticDis.addSymptom(LR.lethargy);
poliomyelitisNonparalyticDis.addSymptom(LR.muscleTender);
poliomyelitisNonparalyticDis.addSymptom(LR.neckPain);
poliomyelitisNonparalyticDis.addSymptom(LR.neckSpasm);
poliomyelitisNonparalyticDis.addSymptom(LR.weakness);
poliomyelitisNonparalyticDis.addReference("pp 234-237");
Treatment poliomyelitisNonparalyticTr1  = new Treatment("poliomyelitisNonparalyticTr1");
poliomyelitisNonparalyticTr1.addDrug(LR.analgetics);
poliomyelitisNonparalyticDis.addTreatment(poliomyelitisNonparalyticTr1.getName());
poliomyelitisNonparalyticDis.setCode358(37);
poliomyelitisNonparalyticDis.setICD10code("A80");


// -------------- poliomyelitisParalytic --------------
// (C) OntoOO Inc Wed Oct 13 13:46:58 GMT-08:00 2004
Disease poliomyelitisParalyticDis = new Disease(
   LR.poliomyelitisParalytic, 
   "polio virus infection of longer duration with paralysis", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge,
   -7, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
poliomyelitisParalyticDis.setPrintName("poliomyelitis paralytic");
poliomyelitisParalyticDis.setSuperDisease(LR.poliomyelitis);
poliomyelitisParalyticDis.setTemperature((float)101.0);
poliomyelitisParalyticDis.addSymptom(LR.headache, "", 1.0f);
poliomyelitisParalyticDis.addSymptom(LR.vomiting, "", 1.0f);
poliomyelitisParalyticDis.addSymptom(LR.abdomenPain, "", 1.0f);
poliomyelitisParalyticDis.addSymptom(LR.armPain, "", 1.0f);
poliomyelitisParalyticDis.addSymptom(LR.backPain, "", 1.0f);
poliomyelitisParalyticDis.addSymptom(LR.irritability, "", 1.0f);
poliomyelitisParalyticDis.addSymptom(LR.legPain, "", 1.0f);
poliomyelitisParalyticDis.addSymptom(LR.lethargy, "", 1.0f);
poliomyelitisParalyticDis.addSymptom(LR.muscleTender, "", 1.0f);
poliomyelitisParalyticDis.addSymptom(LR.neckPain, "", 1.0f);
poliomyelitisParalyticDis.addSymptom(LR.neckSpasm, "", 1.0f);
poliomyelitisParalyticDis.addSymptom(LR.weakness, "", 1.0f);
poliomyelitisParalyticDis.addSymptom(LR.abdomenDistension, "", 1.0f);
poliomyelitisParalyticDis.addSymptom(LR.constipation, "", 1.0f);
poliomyelitisParalyticDis.addSymptom(LR.paresthesia, "", 1.0f);
poliomyelitisParalyticDis.addSymptom(LR.reflexControlLoss, "", 1.0f);
poliomyelitisParalyticDis.addSymptom(LR.urineRetention, "", 1.0f);
poliomyelitisParalyticDis.addReference("pp 234-237");
poliomyelitisParalyticDis.addTreatment("poliomyelitisNonparalyticTr1");
Treatment poliomyelitisParalyticTr1 = new Treatment("poliomyelitisParalyticTr1");
poliomyelitisParalyticTr1.addTreatmentAction(LR.bedRest);
poliomyelitisParalyticDis.addTreatment("poliomyelitisParalyticTr1");
poliomyelitisParalyticDis.setCode358(37);
poliomyelitisParalyticDis.setICD10code("A80");


// -------------- rabies --------------
// (C) OntoOO Inc Sat Nov 24 15:02:03 PST 2001
Disease rabiesDis = new Disease(
   LR.rabies, 
   "brain infection transmitted by the saliva of infected (wild) animals", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   F.rabiesFreq,
   LR.centralNervousSysSt, 
   LR.none
);

rabiesDis.setTemperature((float)101.5); 
rabiesDis.addSymptom(LR.anorexia); 
rabiesDis.addSymptom(LR.burningSensation); 
rabiesDis.addSymptom(LR.headache); 
rabiesDis.addSymptom(LR.hydrophobia); 
rabiesDis.addSymptom(LR.irritability); 
rabiesDis.addSymptom(LR.lacrimation); 
rabiesDis.addSymptom(LR.malaise); 
rabiesDis.addSymptom(LR.nausea); 
rabiesDis.addSymptom(LR.noiseSensitivity); 
rabiesDis.addSymptom(LR.pain); 
rabiesDis.addSymptom(LR.perspiration); 
rabiesDis.addSymptom(LR.photophobia); 
rabiesDis.addSymptom(LR.pupilDilation); 
rabiesDis.addSymptom(LR.salivation); 
rabiesDis.addSymptom(LR.throatSore);
 
rabiesDis.addCausesAbnormalCondition(LR.cranialNerveDysfunction); 
rabiesDis.addReference("pp 240-2");
rabiesDis.setMiscComments(
          "mortality is high if symptoms occur; early treatment is essential ");

Treatment rabiesTr1  = new Treatment("rabiesTr1");
rabiesTr1.addDrug(LR.rabiesImmuneGlobin);
rabiesDis.addTreatment(rabiesTr1.getName());
rabiesDis.setCode358(38);
rabiesDis.setICD10code("A82");


// -------------- rockyMountainSpottedFever --------------
// (C) OntoOO Inc Mon Nov 10 20:26:05 PST 2003
// (C) OntoOO Inc Thu Sep 02 12:45:49 GMT-08:00 2004
Disease rockyMountainSpottedFeverDis = new Disease(
   LR.rockyMountainSpottedFever, 
   "infection due to the rickettsia rickettsii bacteria", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   F.rockyMountainSpottedFeverFreq,
   LR.bodySysSt, 
   LR.none
);
rockyMountainSpottedFeverDis.setPrintName("Rocky Mountain spotted fever");
rockyMountainSpottedFeverDis.setTemperature((float)103.0);
rockyMountainSpottedFeverDis.addSymptom(LR.bonePain, "", 1.0f);
rockyMountainSpottedFeverDis.addSymptom(LR.headacheSevere, "", 1.0f);
rockyMountainSpottedFeverDis.addSymptom(LR.jointPain, "", 1.0f);
rockyMountainSpottedFeverDis.addSymptom(LR.myalgia, "", 1.0f);
rockyMountainSpottedFeverDis.addSymptom(LR.nausea, "", 1.0f);
rockyMountainSpottedFeverDis.addSymptom(LR.vomiting, "", 1.0f);
rockyMountainSpottedFeverDis.addSymptom(LR.chills);
rockyMountainSpottedFeverDis.addSymptom(LR.fatigue);
rockyMountainSpottedFeverDis.addSymptom(LR.rashErupting);
rockyMountainSpottedFeverDis.addSymptom(LR.tongueCoating);
rockyMountainSpottedFeverDis.addInternalCause(LR.tickBite);
rockyMountainSpottedFeverDis.addReference("pp 246-8");
rockyMountainSpottedFeverDis.setMiscComments(
     "fatal in rare cases/ ticks carrying rickettsia bacteria can be found in most states");
Treatment rockyMountainSpottedFeverTr1 = new Treatment("rockyMountainSpottedFeverTr1");
rockyMountainSpottedFeverTr1.addDrug(LR.antibiotics);
rockyMountainSpottedFeverDis.addTreatment("rockyMountainSpottedFeverTr1");


// -------------- rubella --------------
// (C) OntoOO Inc Tue May 28 17:06:25 PDT 2002
// (C) OntoOO Inc Tue Sep 07 14:27:00 GMT-08:00 2004
Disease rubellaDis = new Disease(
   LR.rubella, 
   "acute infection by the rubella virus, which is contagious", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   25,
   -4, //  duration 
   F.rubellaFreq,
   LR.bodySysSt, 
   LR.none
);
rubellaDis.setPrintName("rubella / German measles");
rubellaDis.setTemperature((float)101.0);
rubellaDis.addSymptom(LR.appetiteLoss, "", 0.5f);
rubellaDis.addSymptom(LR.headache, "", 0.5f);
rubellaDis.addSymptom(LR.jointPain, "", 0.5f);
rubellaDis.addSymptom(LR.lymphadenopathy, "", 1.0f);
rubellaDis.addSymptom(LR.rashPapular, "", 1.0f);
rubellaDis.addSymptom(LR.throatSore, "", 0.5f);
rubellaDis.addReference("pp 224-6");
rubellaDis.setMiscComments("causes birth defects in the first trimester");
Treatment rubellaTr1 = new Treatment("rubellaTr1");
rubellaTr1.addDrug(LR.aspirin);
rubellaDis.addTreatment("rubellaTr1");
rubellaDis.setCode358(46);
rubellaDis.setICD10code("B06");


// -------------- salmonellosis --------------
// (C) OntoOO Inc Mon Mar 14 10:41:01 PST 2005
Disease salmonellosisDis = new Disease(
   LR.salmonellosis, 
   "infection caused by the salmonella bacillus", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
salmonellosisDis.setTemperature((float)101.0);
salmonellosisDis.addSymptom(LR.abdomenPain);
salmonellosisDis.addExternalCause(LR.infection);
salmonellosisDis.addReference("pp 182-5");
salmonellosisDis.setMiscComments(
"salmonellosis is typically causes by contaminated or inadequately processed foods");
Treatment salmonellosisTr1  = new Treatment("salmonellosisTr1");
salmonellosisTr1.addTreatmentAction(LR.bedRest);
salmonellosisTr1.addTreatmentAction(LR.electrolyteReplacement);
salmonellosisTr1.addTreatmentAction(LR.fluidIncrease);
salmonellosisDis.addTreatment(salmonellosisTr1.getName());


// -------------- salmonellosisBacteremia --------------
// (C) OntoOO Inc Tue Mar 15 15:46:33 PST 2005
Disease salmonellosisBacteremiaDis = new Disease(
   LR.salmonellosisBacteremia, 
   "infection caused by the salmonella bacillus in the bloodstream", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vascularSysSt, 
   LR.none
);
salmonellosisBacteremiaDis.setPrintName("salmonellosis bacteremia");
salmonellosisBacteremiaDis.setSuperDisease(LR.salmonellosis);
salmonellosisBacteremiaDis.setTemperature((float)101.0);
salmonellosisBacteremiaDis.addSymptom(LR.anorexia, "", 1.0f);
salmonellosisBacteremiaDis.addSymptom(LR.chills, "", 1.0f);
salmonellosisBacteremiaDis.addSymptom(LR.jointPain, "", 1.0f);
salmonellosisBacteremiaDis.addSymptom(LR.weightLoss, "", 1.0f);
salmonellosisBacteremiaDis.addReference("pp 182-5");
salmonellosisBacteremiaDis.setMiscComments(
  "salmonellosis is typically causes by contaminated or inadequately processed foods");
Treatment salmonellosisBacteremiaTr1  = new Treatment("salmonellosisBacteremiaTr1");
salmonellosisBacteremiaTr1.addDrug(LR.amoxicillin);
salmonellosisBacteremiaTr1.addDrug(LR.chloramphenicol);
salmonellosisBacteremiaDis.addTreatment(salmonellosisBacteremiaTr1.getName());


// -------------- salmonellosisEnterocolitis --------------
// (C) OntoOO Inc Wed Mar 16 15:09:03 PST 2005
Disease salmonellosisEnterocolitisDis = new Disease(
   LR.salmonellosisEnterocolitis, 
   "infection caused by the salmonella bacillus in the intestines", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -3, //  duration 
   F.salmonellosisEnterocolitisFreq,
   LR.intestinesSysSt, 
   LR.none
);
salmonellosisEnterocolitisDis.setPrintName("salmonellosis enterocolitis");
salmonellosisEnterocolitisDis.setSuperDisease(LR.salmonellosis);
salmonellosisEnterocolitisDis.setTemperature((float)101.0);
salmonellosisEnterocolitisDis.addSymptom(LR.chills);
salmonellosisEnterocolitisDis.addSymptom(LR.diarrhea);
salmonellosisEnterocolitisDis.addSymptom(LR.feverSym);
salmonellosisEnterocolitisDis.addSymptom(LR.myalgia);
salmonellosisEnterocolitisDis.addSymptom(LR.nausea);
salmonellosisEnterocolitisDis.addSymptom(LR.vomiting);
salmonellosisEnterocolitisDis.addReference("pp 182-5");
salmonellosisEnterocolitisDis.setMiscComments(
     "salmonellosis is typically causes by contaminated or inadequately processed foods");


// -------------- typhoidFever1 --------------
// (C) OntoOO Inc Thu Mar 17 14:47:41 PST 2005
Disease typhoidFever1Dis = new Disease(
   LR.typhoidFever1, 
   "infection caused by the salmonella typhi bacillus in the bloodstream " +
   "and beyond during the first week", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -3, //  duration 
   F.typhoidFever1Freq,
   LR.bodySysSt, 
   LR.none
);
typhoidFever1Dis.setPrintName("typhoid fever initial");
typhoidFever1Dis.setSuperDisease(LR.salmonellosis);
typhoidFever1Dis.setTemperature((float)101.0);
typhoidFever1Dis.addSymptom(LR.diarrhea, "", 1.0f);
typhoidFever1Dis.addSymptom(LR.nausea, "", 1.0f);
typhoidFever1Dis.addSymptom(LR.vomiting, "", 1.0f);
typhoidFever1Dis.addSymptom(LR.anorexia);
typhoidFever1Dis.addSymptom(LR.headache);
typhoidFever1Dis.addSymptom(LR.malaise);
typhoidFever1Dis.addSymptom(LR.myalgia);
typhoidFever1Dis.addSymptom(LR.pulseWeak);
typhoidFever1Dis.addCausesDisease(LR.typhoidFever2); 
typhoidFever1Dis.addReference("pp 182-5");
typhoidFever1Dis.setMiscComments(
     "salmonellosis is typically causes by contaminated or inadequately processed foods");
typhoidFever1Dis.addTreatment(salmonellosisBacteremiaTr1.getName());
typhoidFever1Dis.setCode358(5);
typhoidFever1Dis.setICD10code("A01");

// -------------- typhoidFever2 --------------
// (C) OntoOO Inc Thu Mar 17 15:27:46 PST 2005
Disease typhoidFever2Dis = new Disease(
   LR.typhoidFever2, 
   "infection caused by the salmonella typhi bacillus in the bloodstream and " +
   "beyond during the second week", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -3, //  duration 
   F.typhoidFever2Freq,
   LR.bodySysSt, 
   LR.none
);
typhoidFever2Dis.setPrintName("typhoid fever 2nd week");
typhoidFever2Dis.setSuperDisease(LR.salmonellosis);
typhoidFever2Dis.setTemperature((float)103.0);
typhoidFever2Dis.addSymptom(LR.diarrhea, "", 0.5f);
typhoidFever2Dis.addSymptom(LR.malaise, "", 1.0f);
typhoidFever2Dis.addSymptom(LR.abdomenDistension);
typhoidFever2Dis.addSymptom(LR.chills);
typhoidFever2Dis.addSymptom(LR.constipation, "", 0.5f);
typhoidFever2Dis.addSymptom(LR.cough);
typhoidFever2Dis.addSymptom(LR.crackles);
typhoidFever2Dis.addSymptom(LR.delirium);
typhoidFever2Dis.addSymptom(LR.diaphoresis);
typhoidFever2Dis.addSymptom(LR.rashPapular);
typhoidFever2Dis.addSymptom(LR.weakness);
typhoidFever2Dis.addInternalCause(LR.typhoidFever1);
typhoidFever2Dis.addCausesDisease(LR.typhoidFever3); 
typhoidFever2Dis.addReference("pp 182-5");
typhoidFever2Dis.setMiscComments(
     "salmonellosis is typically causes by contaminated or inadequately processed foods");
typhoidFever2Dis.addTreatment("salmonellosisBacteremiaTr1");
typhoidFever2Dis.setCode358(5);
typhoidFever2Dis.setICD10code("A01");


// -------------- typhoidFever3 --------------
// (C) OntoOO Inc Thu Mar 17 16:09:48 PST 2005
Disease typhoidFever3Dis = new Disease(
   LR.typhoidFever3, 
   "infection caused by the salmonella typhi bacillus in the bloodstream and " +
   "beyond during the third week", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -3, //  duration 
   F.typhoidFever3Freq,
   LR.bodySysSt, 
   LR.none
);
typhoidFever3Dis.setPrintName("typhoid fever 3rd week");
typhoidFever3Dis.setSuperDisease(LR.salmonellosis);
typhoidFever3Dis.setTemperature((float)103.0);
typhoidFever3Dis.addSymptom(LR.malaise, "", 1.0f);
typhoidFever3Dis.addSymptom(LR.weakness, "", 1.0f);
typhoidFever3Dis.addSymptom(LR.fatigue);
typhoidFever3Dis.addInternalCause(LR.typhoidFever2);
typhoidFever3Dis.addReference("pp 182-5");
typhoidFever3Dis.setMiscComments(
    "salmonellosis is typically causes by contaminated or inadequately processed foods");
typhoidFever3Dis.addTreatment("salmonellosisBacteremiaTr1");
typhoidFever3Dis.setCode358(5);
typhoidFever3Dis.setICD10code("A01");


// -------------- schistosomiasis --------------
// (C) OntoOO Inc Wed Jun 19 11:17:34 PDT 2002
Disease schistosomiasisDis = new Disease(
   LR.schistosomiasis, 
   "slowly progressive infection by blood flukes from the class " +
   "Trematoda due to bathing, swimming, etc. in infested waters", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.intestinesSysSt, 
   LR.infection
);
schistosomiasisDis.setTemperature((float)101.5);
schistosomiasisDis.addSymptom(LR.cough, "", 1.0f);
schistosomiasisDis.addSymptom(LR.myalgia, "", 1.0f);
schistosomiasisDis.addSymptom(LR.paralysisTransient, "later stage", 0.3f);
schistosomiasisDis.addSymptom(LR.rashErupting, "", 1.0f);
schistosomiasisDis.addSymptom(LR.seizure, "later stage", 0.3f);
schistosomiasisDis.addSymptom(LR.ulcer, "later stage", 0.3f);
schistosomiasisDis.addCausesDisease(LR.heartFailure);
schistosomiasisDis.addCausesDisease(LR.pulmonaryHypertension);
schistosomiasisDis.addCausesDisease(LR.renalFailureAcute);
schistosomiasisDis.addCausesAbnormalCondition(LR.hepatomegaly);
schistosomiasisDis.addCausesAbnormalCondition(LR.splenomegaly);
schistosomiasisDis.addCausesAbnormalCondition(LR.ascites);
schistosomiasisDis.addReference("pp 265-6");
schistosomiasisDis.setMiscComments(
   "intestinal tract infected by: Schistosoma mansoni & S.japonicum; " +
   "urinary tract by: S.haematobium");
Treatment schistosomiasisTr1 = new Treatment("schistosomiasisTr1");
schistosomiasisTr1.addDrug(LR.praziquantel);
schistosomiasisDis.addTreatment("schistosomiasisTr1");


// -------------- septicShock --------------
// (C) OntoOO Inc Thu Dec 06 13:08:15 PST 2001
Disease septicShockDis = new Disease(
   LR.septicShock, 
   "infection causing circulatory collapse, oxygen supply and demand failures, " + 
   "metabolic changes, etc.", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.infection
);
septicShockDis.setPrintName("septic shock");
septicShockDis.addReference("pp 191-3");
septicShockDis.setMiscComments("phases: early, late see the subdiseases");

Treatment septicShockTr1  = new Treatment("septicShockTr1");
septicShockTr1.addTreatmentAction(LR.IVFluids);
septicShockTr1.addTreatmentAction(LR.vasopressor);
septicShockTr1.addTreatmentAction(LR.colloidCrystalloidInfusions);
septicShockTr1.addDrug(LR.antimicrobials);
septicShockTr1.addDrug(LR.diuretics);
septicShockDis.addTreatment(septicShockTr1.getName());


// -------------- septicShockEarlyPhase --------------
// (C) OntoOO Inc Thu Dec 06 13:46:54 PST 2001
Disease septicShockEarlyPhaseDis = new Disease(
   LR.septicShockEarlyPhase, 
   "early phase of septic shock infection", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.infection
);
septicShockEarlyPhaseDis.setPrintName("septic shock early phase");
septicShockEarlyPhaseDis.setSuperDisease(LR.septicShock);
septicShockEarlyPhaseDis.setTemperature((float)101.0); 
septicShockEarlyPhaseDis.addSymptom(LR.chills, "", 1.0f); 
septicShockEarlyPhaseDis.addSymptom(LR.diarrhea, "", 1.0f); 
septicShockEarlyPhaseDis.addSymptom(LR.feverRapidOnset, "", 1.0f); 
septicShockEarlyPhaseDis.addSymptom(LR.nausea, "", 1.0f); 
septicShockEarlyPhaseDis.addSymptom(LR.oliguria, "", 1.0f); 
septicShockEarlyPhaseDis.addSymptom(LR.prostration); 
septicShockEarlyPhaseDis.addSymptom(LR.pulseFullBounding); 
septicShockEarlyPhaseDis.addSymptom(LR.tachycardia, "", 1.0f); 
septicShockEarlyPhaseDis.addSymptom(LR.tachypnea, "", 1.0f); 
septicShockEarlyPhaseDis.addSymptom(LR.vomiting, "", 1.0f); 

septicShockEarlyPhaseDis.addCausesAbnormalCondition(LR.hyperglycemia); 
septicShockEarlyPhaseDis.addReference("pp 191-3"); 


// -------------- septicShockLatePhase --------------
// (C) OntoOO Inc Thu Dec 06 14:49:04 PST 2001
Disease septicShockLatePhaseDis = new Disease(
   LR.septicShockLatePhase, 
   "late stage of septic shock infection", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.infection
);
septicShockLatePhaseDis.setPrintName("septic shock late phase");
septicShockLatePhaseDis.addSymptom(LR.anuria);
septicShockLatePhaseDis.addSymptom(LR.apprehension);
septicShockLatePhaseDis.addSymptom(LR.consciousnessDecreased);
septicShockLatePhaseDis.addSymptom(LR.hyperventilation);
septicShockLatePhaseDis.addSymptom(LR.hypotension);
septicShockLatePhaseDis.addSymptom(LR.hypothermia);
septicShockLatePhaseDis.addSymptom(LR.irritability);
septicShockLatePhaseDis.addSymptom(LR.restlessness);
septicShockLatePhaseDis.addSymptom(LR.thirst);
septicShockLatePhaseDis.addCausesAbnormalCondition(LR.hypoglycemia);
septicShockLatePhaseDis.addReference("pp 191-3");
septicShockLatePhaseDis.setMiscComments(
       "hypotension, consciousness loss and hyperventilation " +
       "may be the only symptoms in infants and elderly");


// -------------- shigellosis --------------
// (C) OntoOO Inc Fri Mar 18 15:13:15 PST 2005
Disease shigellosisDis = new Disease(
   LR.shigellosis, 
   "infection caused by the shigella bacteria", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   F.shigellosisFreq,
   LR.intestinesSysSt, 
   LR.infection
);
shigellosisDis.setTemperature((float)101.0);
shigellosisDis.addSymptom(LR.abdomenPain, "", 1.0f);
shigellosisDis.addSymptom(LR.abdomenCramping, "", 1.0f);
shigellosisDis.addSymptom(LR.diarrhea, "", 1.0f);
shigellosisDis.addSymptom(LR.diarrheaBloody, "", 0.8f);
shigellosisDis.addSymptom(LR.feverSym);
shigellosisDis.addSymptom(LR.nausea);
shigellosisDis.addSymptom(LR.vomiting);
shigellosisDis.addReference("pp 182-5");
shigellosisDis.setMiscComments("young children and the elderly are at risk for complications");
Treatment shigellosisTr1 = new Treatment("shigellosisTr1");
shigellosisTr1.addTreatmentAction(LR.fluidManagement);
shigellosisDis.addTreatment("shigellosisTr1");
Treatment shigellosisTr2  = new Treatment("shigellosisTr2", LR.ifSevere);
shigellosisTr2.addTreatmentAction(LR.hospitalization);
shigellosisTr2.addDrug(LR.ampicillin);
shigellosisTr2.addDrug(LR.coTrimoxazole);
shigellosisTr2.addDrug(LR.tetracycline);
shigellosisDis.addTreatment(shigellosisTr2.getName());
shigellosisDis.setCode358(7);
shigellosisDis.setICD10code("A03");


// -------------- streptococcalInfection --------------
// (C) OntoOO Inc Thu Aug 28 14:08:33 PDT 2003
Disease streptococcalInfectionDis = new Disease(
   LR.streptococcalInfection, 
   "infection by the streptococci bacteria", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.streptococcusInfection
);
streptococcalInfectionDis.setPrintName("streptococcal infection");
streptococcalInfectionDis.addReference("pp 166-71");
Treatment streptococcalInfectionTr1  = new Treatment("streptococcalInfectionTr1");
streptococcalInfectionTr1.addDrug(LR.penicillin);
streptococcalInfectionDis.addTreatment(streptococcalInfectionTr1.getName());


// -------------- erypsipelas --------------
// (C) OntoOO Inc Mon Sep 01 17:53:58 PDT 2003
Disease erypsipelasDis = new Disease(
   LR.erypsipelas, 
   "sudden skin  disease caused by streptococcal infection", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
erypsipelasDis.setSuperDisease(LR.streptococcalInfection);
erypsipelasDis.setTemperature((float)102.0);
erypsipelasDis.addSymptom(LR.throatSore, "", 1.0f);
erypsipelasDis.addSymptom(LR.vomiting, "", 0.3f);
erypsipelasDis.addSymptom(LR.headache, "", 1.0f);
erypsipelasDis.addSymptom(LR.lymphadenopathy, "", 1.0f);
erypsipelasDis.addSymptom(LR.bleb, "", 1.0f);
erypsipelasDis.addSymptom(LR.skinLesionRedSwollenRaised, "orange peel appearance`", 1.0f);
erypsipelasDis.addInternalCause(LR.pharyngitisStreptococcal);
erypsipelasDis.addReference("pp 166-7");
Treatment erypsipelasTr1 = new Treatment("erypsipelasTr1");
erypsipelasTr1.addDrug(LR.analgetics);
erypsipelasTr1.addDrug(LR.topicalAnesthetics);
erypsipelasDis.addTreatment(erypsipelasTr1.getName()); 


// -------------- impetigo --------------
// (C) OntoOO Inc Mon Sep 15 09:09:10 PDT 2003
Disease impetigoDis = new Disease(
   LR.impetigo, 
   "skin  disease caused by streptococcal infection in children in hot humid weather", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   2, //  minAge 
   5,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
impetigoDis.setSuperDisease(LR.streptococcalInfection);
impetigoDis.setTemperature((float)102.0);
impetigoDis.addSymptom(LR.erythema);
impetigoDis.addSymptom(LR.itches);
impetigoDis.addSymptom(LR.vesicle);
impetigoDis.addSymptom(LR.maculePustular);
impetigoDis.addSymptom(LR.maculeEncrusted);
impetigoDis.addCausesDisease(LR.cellulitis);
impetigoDis.addCausesDisease(LR.septicemia);
impetigoDis.addReference("pp 168-9");
Treatment impetigoTr1 = new Treatment("impetigoTr1");
impetigoTr1.addTreatmentAction(LR.woundCare);
impetigoDis.addTreatment(impetigoTr1.getName()); 


// -------------- scarletFever --------------
// (C) OntoOO Inc Fri Aug 29 13:23:07 PDT 2003
Disease scarletFeverDis = new Disease(
   LR.scarletFever, 
   "rash caused by streptococcal infection", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   2, //  minAge 
   15,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
scarletFeverDis.setPrintName("scarlet fever");
scarletFeverDis.setSuperDisease(LR.streptococcalInfection);
scarletFeverDis.setTemperature((float)102.0);
scarletFeverDis.addSymptom(LR.erythema);
scarletFeverDis.addSymptom(LR.rashSandpapery);
scarletFeverDis.addSymptom(LR.throatSore);
scarletFeverDis.addSymptom(LR.tongueRed);
scarletFeverDis.addSymptom(LR.abdomenPain, "", 0.3f);
scarletFeverDis.addSymptom(LR.chills, "", 0.3f);
scarletFeverDis.addSymptom(LR.malaise, "", 0.3f);
scarletFeverDis.addSymptom(LR.vomiting, "", 0.3f); 
scarletFeverDis.addInternalCause(LR.pharyngitisStreptococcal);
scarletFeverDis.addReference("pp 166-7");
scarletFeverDis.setMiscComments(
   "rash usually begins at upper chest and spreads to neck abdomen legs and arms");
scarletFeverDis.setCode358(21);
scarletFeverDis.setICD10code("A38");


// -------------- streptococcalGangrene --------------
// (C) OntoOO Inc Tue Sep 16 18:42:19 PDT 2003
Disease streptococcalGangreneDis = new Disease(
   LR.streptococcalGangrene, 
   "skin lesions in usually elderly with diabetes vascular disease recent " +
   "surgery wounds skin ulcers ...", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   50, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
streptococcalGangreneDis.setPrintName("streptococcal gangrene");
streptococcalGangreneDis.setSuperDisease(LR.streptococcalInfection);
streptococcalGangreneDis.setTemperature((float)102.0);
streptococcalGangreneDis.addSymptom(LR.disorientation);
streptococcalGangreneDis.addSymptom(LR.hypotension);
streptococcalGangreneDis.addSymptom(LR.jaundice);
streptococcalGangreneDis.addSymptom(LR.lethargy);
streptococcalGangreneDis.addSymptom(LR.prostration);
streptococcalGangreneDis.addSymptom(LR.skinLesionRedStreaked, 
				    "dusky red surrounding tissue", 1.0f);
streptococcalGangreneDis.addSymptom(LR.tachycardia);
streptococcalGangreneDis.addCausesAbnormalCondition(LR.hypovolemia);
streptococcalGangreneDis.addReference("pp 168-9");
Treatment streptococcalGangreneTr1  = new Treatment("streptococcalGangreneTr1");
streptococcalGangreneTr1.addTreatmentAction(LR.surgery);
streptococcalGangreneDis.addTreatment(streptococcalGangreneTr1.getName());


// -------------- septicemia --------------
// (C) OntoOO Inc Mon Sep 15 19:54:43 PDT 2003
Disease septicemiaDis = new Disease(
   LR.septicemia, 
   "septicemia is the presence of bacteria in the blood", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.immuneSysSt, 
   LR.infection
);
septicemiaDis.setTemperature((float)103.0);
septicemiaDis.addSymptom(LR.agitation, "", 1.0f);
septicemiaDis.addSymptom(LR.anxiety, "", 1.0f);
septicemiaDis.addSymptom(LR.chills, "", 1.0f);
septicemiaDis.addSymptom(LR.coma, "", 1.0f);
septicemiaDis.addSymptom(LR.irritability, "", 1.0f);
septicemiaDis.addSymptom(LR.lethargy, "", 1.0f);
septicemiaDis.addSymptom(LR.cyanosis);
septicemiaDis.addSymptom(LR.ecchymoses);
septicemiaDis.addSymptom(LR.skinClammy);
septicemiaDis.addSymptom(LR.pallor);
septicemiaDis.addSymptom(LR.petechiae);
septicemiaDis.addSymptom(LR.urineRetention);
septicemiaDis.addInternalCause(LR.impetigo);
septicemiaDis.addCausingAbnormalCondition(LR.sepsis);
septicemiaDis.addCausingAbnormalCondition(LR.shock);
Treatment septicemiaTr1  = new Treatment("septicemiaTr1");
septicemiaTr1.addTreatmentAction(LR.IVFluids);
septicemiaTr1.addTreatmentAction(LR.hospitalization);
septicemiaTr1.addTreatmentAction(LR.oxygenTherapy);
septicemiaTr1.addDrug(LR.antibiotics);
septicemiaDis.addTreatment(septicemiaTr1.getName());
septicemiaDis.setCode358(23);
septicemiaDis.setICD10code("A40");


// -------------- tetanus --------------
// (C) OntoOO Inc Sun Dec 09 12:30:35 PST 2001
Disease tetanusDis = new Disease(
   LR.tetanus, 
   "infection by bacillus clostridium tetani", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
tetanusDis.addExternalCause(LR.tetanusInfection);

tetanusDis.addSymptom(LR.abdomenRigidity); 
tetanusDis.addSymptom(LR.apnea); 
tetanusDis.addSymptom(LR.backArched); 
tetanusDis.addSymptom(LR.diaphoresis); 
tetanusDis.addSymptom(LR.tendonReflexesHyperactive);
tetanusDis.addSymptom(LR.lockjaw); 
tetanusDis.addSymptom(LR.muscleContractions); 
tetanusDis.addSymptom(LR.muscleHypertonicity); 
tetanusDis.addSymptom(LR.seizure); 
tetanusDis.addSymptom(LR.tachycardia); 

tetanusDis.addReference("pp 175-7");

Treatment tetanusTr1 = new Treatment("tetanusTr1");
tetanusTr1.addTreatmentAction(LR.airwayMaintenance);
tetanusTr1.addDrug(LR.antibiotics);
tetanusTr1.addDrug(LR.diazepam);
tetanusTr1.addDrug(LR.tetanusToxoid);
tetanusDis.addTreatment(tetanusTr1.getName()); 
tetanusDis.setCode358(18);
tetanusDis.setICD10code("A33");


// -------------- toxoplasmosis --------------
// (C) OntoOO Inc Thu Mar 20 16:46:38 PST 2003
Disease toxoplasmosisDis = new Disease(
   LR.toxoplasmosis, 
   "infection acquired through food and the like or during pregnancy of the mother", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
toxoplasmosisDis.addExternalCause(LR.toxoplasmaGondiiInfection);
toxoplasmosisDis.addCausesDisease(LR.uveitis);
toxoplasmosisDis.addReference("pp 257-8");
toxoplasmosisDis.setMiscComments("see the two subdiseases variants");


// -------------- toxoplasmosisAcquiredSuper --------------
// (C) OntoOO Inc Thu Mar 20 17:05:37 PST 2003
Disease toxoplasmosisAcquiredSuperDis = new Disease(
   LR.toxoplasmosisAcquiredSuper, 
   "infection acquired through food and the like", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
toxoplasmosisAcquiredSuperDis.setPrintName("toxoplasmosis acquired super");
toxoplasmosisAcquiredSuperDis.setSuperDisease(LR.toxoplasmosis);
toxoplasmosisAcquiredSuperDis.setTemperature((float)101.0);
toxoplasmosisAcquiredSuperDis.addSymptom(LR.fatigue);
toxoplasmosisAcquiredSuperDis.addSymptom(LR.headache);
toxoplasmosisAcquiredSuperDis.addSymptom(LR.lymphadenitis);
toxoplasmosisAcquiredSuperDis.addSymptom(LR.lymphadenopathy);
toxoplasmosisAcquiredSuperDis.addSymptom(LR.malaise);
toxoplasmosisAcquiredSuperDis.addSymptom(LR.myalgia);
toxoplasmosisAcquiredSuperDis.addSymptom(LR.throatSore);
toxoplasmosisAcquiredSuperDis.addExternalCause(LR.toxoplasmaGondiiInfection);
toxoplasmosisAcquiredSuperDis.addReference("pp 257-8");
toxoplasmosisAcquiredSuperDis.setMiscComments("can be acquired by uncooked meat");
Treatment toxoplasmosisAcquiredSuperTr1  = new Treatment("toxoplasmosisAcquiredSuperTr1");
toxoplasmosisAcquiredSuperTr1.addDrug(LR.sulfonamide);
toxoplasmosisAcquiredSuperTr1.addDrug(LR.pyrimetathamine);
toxoplasmosisAcquiredSuperDis.addTreatment(toxoplasmosisAcquiredSuperTr1.getName());


// -------------- toxoplasmosisAcquired --------------
// (C) OntoOO Inc Thu Mar 20 17:05:37 PST 2003
Disease toxoplasmosisAcquiredDis = new Disease(
   LR.toxoplasmosisAcquired, 
   "infection acquired through food and the like", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
toxoplasmosisAcquiredDis.setPrintName("toxoplasmosis acquired");
toxoplasmosisAcquiredDis.setSuperDisease(LR.toxoplasmosisAcquiredSuper);
toxoplasmosisAcquiredDis.setTemperature((float)101.0);
toxoplasmosisAcquiredDis.addCausesDisease(LR.toxoplasmosisAcquiredAdvanced);
toxoplasmosisAcquiredDis.addReference("pp 257-8");
toxoplasmosisAcquiredDis.setMiscComments("can be acquired by uncooked meat");


// -------------- toxoplasmosisAcquiredAdvanced --------------
// (C) OntoOO Inc Tue Mar 25 11:57:19 PST 2003
Disease toxoplasmosisAcquiredAdvancedDis = new Disease(
   LR.toxoplasmosisAcquiredAdvanced, 
   "advanced infection acquired through food and the like", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.toxoplasmaGondiiInfection
);
toxoplasmosisAcquiredAdvancedDis.setPrintName("toxoplasmosis acquired");
toxoplasmosisAcquiredAdvancedDis.setSuperDisease(LR.toxoplasmosisAcquiredSuper);
toxoplasmosisAcquiredAdvancedDis.setTemperature((float)101.0);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.fatigue, "", 1.0f);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.headache, "", 1.0f);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.lymphadenitis, "", 1.0f);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.lymphadenopathy, "", 1.0f);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.malaise, "", 1.0f);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.myalgia, "", 1.0f);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.throatSore, "", 1.0f);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.delirium);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.rash);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.seizure);
toxoplasmosisAcquiredAdvancedDis.addSymptom(LR.vomiting);
toxoplasmosisAcquiredAdvancedDis.addInternalCause(LR.toxoplasmosisAcquired);
toxoplasmosisAcquiredAdvancedDis.addCausesDisease(LR.encephalitis);
toxoplasmosisAcquiredAdvancedDis.addCausesDisease(LR.hepatitis);
toxoplasmosisAcquiredAdvancedDis.addCausesDisease(LR.myocarditis);
// toxoplasmosisAcquiredAdvancedDis.addCausesDisease(LR.pneumonitis);
toxoplasmosisAcquiredAdvancedDis.addCausesDisease(LR.polymyositis);
toxoplasmosisAcquiredAdvancedDis.addReference("pp 257-8");
toxoplasmosisAcquiredAdvancedDis.setMiscComments("can be acquired by uncooked meat");


// -------------- toxoplasmosisCongenital --------------
// (C) OntoOO Inc Thu Mar 20 17:18:32 PST 2003
Disease toxoplasmosisCongenitalDis = new Disease(
   LR.toxoplasmosisCongenital, 
   "infection acquired during pregnancy of the mother", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   2,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.toxoplasmaGondiiInfection
);
toxoplasmosisCongenitalDis.setPrintName("toxoplasmosis congenital");
toxoplasmosisCongenitalDis.setSuperDisease(LR.toxoplasmosis);
toxoplasmosisCongenitalDis.setTemperature((float)101.0);
toxoplasmosisCongenitalDis.addSymptom(LR.jaundice);
toxoplasmosisCongenitalDis.addSymptom(LR.lymphadenopathy);
toxoplasmosisCongenitalDis.addSymptom(LR.rash);
toxoplasmosisCongenitalDis.addSymptom(LR.seizure);
toxoplasmosisCongenitalDis.addCausesDisease(LR.retinochoroiditis);
toxoplasmosisCongenitalDis.addCausesDisease(LR.hydrocephalus);
toxoplasmosisCongenitalDis.addCausesAbnormalCondition(LR.hepatomegaly);
toxoplasmosisCongenitalDis.addCausesAbnormalCondition(LR.splenomegaly); 
toxoplasmosisCongenitalDis.addReference("pp 257-8");
toxoplasmosisCongenitalDis.setMiscComments(
     "two third result in still birth, no safe treatment available");


// -------------- westNileVirus --------------
// (C) OntoOO Inc Wed Aug 21 16:47:03 PDT 2002
Disease westNileVirusDis = new Disease(
   LR.westNileVirus, 
   "virus infection transmitted by mosquitos which is spreading rapidly in the US since 1999", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.virusInfection
);
westNileVirusDis.setPrintName("West Nile Virus");
westNileVirusDis.setTemperature((float)101.0);
westNileVirusDis.addSymptom(LR.headache, "", 1.0f);


// -------------- westNileVirusMild --------------
// (C) OntoOO Inc Mon Aug 01 15:07:30 PDT 2005
Disease westNileVirusMildDis = new Disease(
   LR.westNileVirusMild, 
   "virus infection transmitted by mosquitos which is spreading " +
   "rapidly in the US since 1999 mild version", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
westNileVirusMildDis.setPrintName("West Nile Virus mild");
westNileVirusMildDis.setSuperDisease(LR.westNileVirus);
westNileVirusMildDis.setTemperature((float)101.0);
westNileVirusMildDis.addSymptom(LR.myalgia, "", 1.0f);
westNileVirusMildDis.addSymptom(LR.nausea, "", 1.0f);
westNileVirusMildDis.addSymptom(LR.rash, "", 0.2f);
westNileVirusMildDis.addSymptom(LR.vomiting, "", 1.0f);
westNileVirusMildDis.addSymptom(LR.lymphadenopathy, "", 0.2f);
westNileVirusMildDis.addCausesDisease(LR.westNileVirusSevere);
westNileVirusMildDis.setMiscComments(
   "about 20 percent that are infected will display symptoms");


// -------------- westNileVirusSevere --------------
// (C) OntoOO Inc Mon Aug 01 15:28:21 PDT 2005
Disease westNileVirusSevereDis = new Disease(
   LR.westNileVirusSevere, 
   "virus infection transmitted by mosquitos which is spreading " +
   "rapidly in the US since 1999 severe version", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
westNileVirusSevereDis.setPrintName("West Nile Virus severe");
westNileVirusSevereDis.setSuperDisease(LR.westNileVirus);
westNileVirusSevereDis.setTemperature((float)103.0);
westNileVirusSevereDis.addSymptom(LR.coma, "", 1.0f);
westNileVirusSevereDis.addSymptom(LR.convulsions, "", 1.0f);
westNileVirusSevereDis.addSymptom(LR.disorientation, "", 1.0f);
westNileVirusSevereDis.addSymptom(LR.neckStiff, "", 1.0f);
westNileVirusSevereDis.addSymptom(LR.stupor, "", 1.0f);
westNileVirusSevereDis.addSymptom(LR.tremors, "", 1.0f);
westNileVirusSevereDis.addSymptom(LR.muscleWeakness);
westNileVirusSevereDis.addSymptom(LR.numbness);
westNileVirusSevereDis.addSymptom(LR.paralysis);
westNileVirusSevereDis.addSymptom(LR.visionLoss);
westNileVirusSevereDis.addInternalCause(LR.westNileVirusMild);
westNileVirusSevereDis.setMiscComments(
    "about one in 150 people infected will display severe symptoms");


    // ----------------  whoopingCough --------------------------
// (C) OntoOO Inc Fri Oct 05 12:55:02 PDT 2001
// (C) OntoOO Inc Wed Sep 08 12:15:44 GMT-08:00 2004
Disease whoopingCoughDis = new Disease(
   LR.whoopingCough, 
   "whooping cough due to respiratory infection", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -5, //  duration 
   F.whoopingCoughFreq,
   LR.respiratorySysSt, 
   LR.none
);
whoopingCoughDis.setPrintName("whooping cough");
whoopingCoughDis.addReference("pp 194-5");
Treatment whoopingCoughTr1  = new Treatment("whoopingCoughTr1");
whoopingCoughTr1.addDrug(LR.antibiotics);
whoopingCoughTr1.addDrug(LR.codeine);
whoopingCoughDis.addTreatment(whoopingCoughTr1.getName());
whoopingCoughDis.setCode358(20);
whoopingCoughDis.setICD10code("A37");


// -------------- whoopingCoughCatarrh --------------
// (C) OntoOO Inc Wed Sep 08 13:13:15 GMT-08:00 2004
Disease whoopingCoughCatarrhDis = new Disease(
   LR.whoopingCoughCatarrh, 
   "whooping cough due to respiratory infection - first phase", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   F.whoopingCoughCatarrhFreq,
   LR.respiratorySysSt, 
   LR.none
);
whoopingCoughCatarrhDis.setPrintName("whooping cough catarrh stage");
whoopingCoughCatarrhDis.setSuperDisease(LR.whoopingCough);
whoopingCoughCatarrhDis.setTemperature((float)101.0);
whoopingCoughCatarrhDis.addSymptom(LR.anorexia);
whoopingCoughCatarrhDis.addSymptom(LR.coughHacking);
whoopingCoughCatarrhDis.addSymptom(LR.listlessness);
whoopingCoughCatarrhDis.addSymptom(LR.sneezing);
whoopingCoughCatarrhDis.addCausesDisease(LR.conjunctivitis);
whoopingCoughCatarrhDis.addReference("pp 194-5");
whoopingCoughCatarrhDis.setMiscComments("highly contagious in this stage");
whoopingCoughCatarrhDis.setCode358(20);
whoopingCoughCatarrhDis.setICD10code("A37");

// -------------- whoopingCoughParoxysm --------------
// (C) OntoOO Inc Wed Sep 08 13:31:22 GMT-08:00 2004
Disease whoopingCoughParoxysmDis = new Disease(
   LR.whoopingCoughParoxysm, 
   "whooping cough due to respiratory infection - second phase", 
   LR.infections, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   F.whoopingCoughParoxysmFreq,
   LR.respiratorySysSt, 
   LR.none
);
whoopingCoughParoxysmDis.setPrintName("whooping cough paroxysm stage");
whoopingCoughParoxysmDis.setSuperDisease(LR.whoopingCough);
whoopingCoughParoxysmDis.addSymptom(LR.cough);
whoopingCoughParoxysmDis.addSymptom(LR.coughProductive);
whoopingCoughParoxysmDis.addSymptom(LR.thickMucus);
whoopingCoughParoxysmDis.addSymptom(LR.vomiting);
whoopingCoughParoxysmDis.addSymptom(LR.whoopInhalation);
whoopingCoughParoxysmDis.addReference("pp 194-5");
whoopingCoughParoxysmDis.setCode358(20);
whoopingCoughParoxysmDis.setICD10code("A37");

  } // end of doit(...)

} // end of InitInfectionDiseases
