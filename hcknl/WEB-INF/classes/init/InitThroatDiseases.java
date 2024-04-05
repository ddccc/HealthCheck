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

public class InitThroatDiseases {
  public static void doit() {

// -------------- pharyngitis --------------
// (C) OntoOO Inc Thu Aug 28 15:02:19 PDT 2003
Disease pharyngitisDis = new Disease(
   LR.pharyngitis, 
   "inflammation of the throat", 
   LR.throatDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.throatSysSt, 
   LR.infection
);
pharyngitisDis.addSymptom(LR.coryza, "", 0.3f);
pharyngitisDis.addSymptom(LR.headache, "", 0.3f);
pharyngitisDis.addSymptom(LR.jointPain, "", 0.3f);
pharyngitisDis.addSymptom(LR.myalgia, "", 0.3f);
pharyngitisDis.addSymptom(LR.dysphagia);
pharyngitisDis.addSymptom(LR.throatSore);
pharyngitisDis.addReference("pp 1219-20");
Treatment pharyngitisTr1  = new Treatment("pharyngitisTr1");
pharyngitisTr1.addTreatmentAction(LR.salineGargles);
pharyngitisDis.addTreatment(pharyngitisTr1.getName());
pharyngitisDis.setCode358(249);
pharyngitisDis.setICD10code("J02");


// -------------- pharyngitisBacterial --------------
// (C) OntoOO Inc Thu Aug 28 16:23:53 PDT 2003
Disease pharyngitisBacterialDis = new Disease(
   LR.pharyngitisBacterial, 
   "inflammation of the throat due to a bacterium", 
   LR.throatDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.throatSysSt, 
   LR.bacterialInfection
);
pharyngitisBacterialDis.setPrintName("pharyngitis bacterial");
pharyngitisBacterialDis.setSuperDisease(LR.pharyngitis);
pharyngitisBacterialDis.addReference("pp 1219-20");
Treatment pharyngitisBacterialTr1  = new Treatment("pharyngitisBacterialTr1");
pharyngitisBacterialTr1.addDrug(LR.antibiotics);
pharyngitisBacterialTr1.addDrug(LR.penicillin);
pharyngitisBacterialDis.addTreatment(pharyngitisBacterialTr1.getName());
pharyngitisBacterialDis.setCode358(249);
pharyngitisBacterialDis.setICD10code("J02");


// -------------- pharyngitisGonorrhea --------------
// (C) OntoOO Inc Thu Aug 28 16:42:41 PDT 2003
Disease pharyngitisGonorrheaDis = new Disease(
   LR.pharyngitisGonorrhea, 
   "inflammation of the throat due to gonorrhea infection", 
   LR.throatDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.throatSysSt, 
   LR.bacterialInfection
);
pharyngitisGonorrheaDis.setPrintName("pharyngitis gonorrhea");
pharyngitisGonorrheaDis.setSuperDisease(LR.pharyngitisBacterial);
pharyngitisGonorrheaDis.addSymptom(LR.feverSym);
pharyngitisGonorrheaDis.addSymptom(LR.neckLymphNodeEnlarged);
pharyngitisGonorrheaDis.addSymptom(LR.neckPain, "", 0.3f);
pharyngitisGonorrheaDis.addInternalCause(LR.gonorrhea);
pharyngitisGonorrheaDis.addExternalCause(LR.gonorrheaInfection);
pharyngitisGonorrheaDis.addReference("pp 1219-20");
pharyngitisGonorrheaDis.setCode358(249);
pharyngitisGonorrheaDis.setICD10code("J02");

// -------------- pharyngitisStreptococcal --------------
// (C) OntoOO Inc Thu Aug 28 16:53:29 PDT 2003
Disease pharyngitisStreptococcalDis = new Disease(
   LR.pharyngitisStreptococcal, 
   "inflammation of the throat due to streptococcus infection", 
   LR.throatDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.throatSysSt, 
   LR.bacterialInfection
);
pharyngitisStreptococcalDis.setPrintName("pharyngitis streptococcal");
pharyngitisStreptococcalDis.setSuperDisease(LR.pharyngitisBacterial);
pharyngitisStreptococcalDis.setTemperature((float)102.0); 
pharyngitisStreptococcalDis.addSymptom(LR.abdomenPain, "", 0.1f);
pharyngitisStreptococcalDis.addSymptom(LR.anorexia);
pharyngitisStreptococcalDis.addSymptom(LR.feverSym);
pharyngitisStreptococcalDis.addSymptom(LR.malaise);
pharyngitisStreptococcalDis.addSymptom(LR.throatRed);
pharyngitisStreptococcalDis.addSymptom(LR.tonsilsExude);
pharyngitisStreptococcalDis.addSymptom(LR.tonsilsSwollen);
pharyngitisStreptococcalDis.addSymptom(LR.weakness);
pharyngitisStreptococcalDis.addExternalCause(LR.streptococcusInfection);
pharyngitisStreptococcalDis.addCausesDisease(LR.otitisMedia);
pharyngitisStreptococcalDis.addCausesDisease(LR.sinusitis); 
pharyngitisStreptococcalDis.addReference("pp 1219-20");
Treatment pharyngitisStreptococcalTr1  = new Treatment("pharyngitisStreptococcalTr1");
pharyngitisStreptococcalTr1.addTreatmentAction(LR.bedRest);
pharyngitisStreptococcalTr1.addDrug(LR.analgetics);
pharyngitisStreptococcalTr1.addDrug(LR.antipyretic);
pharyngitisStreptococcalDis.addTreatment(pharyngitisStreptococcalTr1.getName());
pharyngitisStreptococcalDis.setCode358(249);
pharyngitisStreptococcalDis.setICD10code("J02");


// -------------- pharyngitisViral --------------
// (C) OntoOO Inc Thu Aug 28 16:15:34 PDT 2003
Disease pharyngitisViralDis = new Disease(
   LR.pharyngitisViral, 
   "inflammation of the throat due to a virus", 
   LR.throatDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.throatSysSt, 
   LR.virusInfection
);
pharyngitisViralDis.setPrintName("pharyngitis viral");
pharyngitisViralDis.setSuperDisease(LR.pharyngitis);
pharyngitisViralDis.addSymptom(LR.feverSym);
pharyngitisViralDis.addSymptom(LR.neckLymphNodeEnlarged);
pharyngitisViralDis.addReference("pp 1219-20");
pharyngitisViralDis.setMiscComments("pharyngitis is usually caused by a virus");
pharyngitisViralDis.setCode358(249);
pharyngitisViralDis.setICD10code("J02");


// -------------- tonsillitis --------------
// (C) OntoOO Inc Sat Feb 22 19:57:02 PST 2003
Disease tonsillitisDis = new Disease(
   LR.tonsillitis, 
   "inflammation of the tonsils", 
   LR.throatDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   10,
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.tonsilsSysSt, 
   LR.infection
);
tonsillitisDis.setTemperature((float)101.0);
tonsillitisDis.addSymptom(LR.chills, "", 0.3f);
tonsillitisDis.addSymptom(LR.dysphagia, "", 0.3f);
tonsillitisDis.addSymptom(LR.headache, "", 0.3f);
tonsillitisDis.addSymptom(LR.jointPain, "", 0.3f);
tonsillitisDis.addSymptom(LR.lymphadenopathy, "", 0.3f);
tonsillitisDis.addSymptom(LR.malaise, "", 0.4f);
tonsillitisDis.addSymptom(LR.myalgia, "", 0.3f);
tonsillitisDis.addSymptom(LR.throatSore, "", 1.0f);
tonsillitisDis.addInternalCause(LR.gonorrhea);
tonsillitisDis.addReference("pp 1220-1");
Treatment tonsillitisTr1 = new Treatment("tonsillitisTr1");
tonsillitisTr1.addTreatmentAction(LR.bedRest);
tonsillitisTr1.addTreatmentAction(LR.fluidIncrease);
tonsillitisTr1.addDrug(LR.antibiotics);
tonsillitisTr1.addDrug(LR.penicillin);
tonsillitisTr1.addDrug(LR.ibuprofen);
tonsillitisDis.addTreatment("tonsillitisTr1");
Treatment tonsillitisTr2 = new Treatment("tonsillitisTr2", LR.ifChronic);
tonsillitisTr2.addTreatmentAction(LR.surgery);
tonsillitisDis.addTreatment(tonsillitisTr2.getName()); 
tonsillitisDis.setCode358(249);
tonsillitisDis.setICD10code("J03");

  } // end doit()

} // end InitThroatDiseases
