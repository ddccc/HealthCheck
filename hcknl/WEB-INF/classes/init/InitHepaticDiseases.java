// (C) OntoOO Inc 2000
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

public class InitHepaticDiseases {
  public static void doit() {

    // -------------- bleedingEsophagealVarices ---------------
// (C) OntoOO Inc Wed Oct 31 11:34:03 PST 2001
Disease bleedingEsophagealVaricesDis = new Disease(
   LR.bleedingEsophagealVarices, 
   "rupture of veins in the esophagus", 
   LR.hepatobiliaryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.esophagusSysSt, 
   LR.none
);
bleedingEsophagealVaricesDis.setPrintName("bleeding esophageal varices");
bleedingEsophagealVaricesDis.addSymptom(LR.anxiety, "", 1.0f);
bleedingEsophagealVaricesDis.addSymptom(LR.hypotension, "", 1.0f);
bleedingEsophagealVaricesDis.addSymptom(LR.respirationDistress, "", 1.0f);
bleedingEsophagealVaricesDis.addSymptom(LR.skinClammy, "", 1.0f);
bleedingEsophagealVaricesDis.addSymptom(LR.skinCold, "", 1.0f);
bleedingEsophagealVaricesDis.addSymptom(LR.tachycardia, "", 1.0f);
bleedingEsophagealVaricesDis.addSymptom(LR.vomitBloody, "", 1.0f);
bleedingEsophagealVaricesDis.addReference("pp 738-9");
Treatment bleedingEsophagealVaricesTr1 = 
  new Treatment("bleedingEsophagealVaricesTr1");
bleedingEsophagealVaricesTr1.addTreatmentAction(LR.IVFluids);
bleedingEsophagealVaricesTr1.addTreatmentAction(LR.endotrachealIntubation);
bleedingEsophagealVaricesTr1.addTreatmentAction(LR.mechanicalVentilation);
bleedingEsophagealVaricesTr1.addTreatmentAction(LR.surgery);
bleedingEsophagealVaricesTr1.addTreatmentAction(LR.bloodTransfusion);
bleedingEsophagealVaricesTr1.addTreatmentAction(LR.MinnesotaTube);
bleedingEsophagealVaricesTr1.addDrug(LR.vasopressin);
bleedingEsophagealVaricesDis.addTreatment(bleedingEsophagealVaricesTr1.getName()); 


// -------------- hepatitis --------------
// (C) OntoOO Inc Tue Mar 08 14:11:44 PST 2005
Disease hepatitisDis = new Disease(
   LR.hepatitis, 
   "liver damage which can be  fatal in old age and " +
   "when there are underlying complications", 
   LR.hepatobiliaryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.hepatobiliarySysSt, 
   LR.none
);
hepatitisDis.addSymptom(LR.anorexia, "", 1.0f);
hepatitisDis.addSymptom(LR.pruritus, "", 0.3f);
hepatitisDis.addSymptom(LR.stoolClayColored, "", 1.0f);
hepatitisDis.addSymptom(LR.urineDark, "", 1.0f);
hepatitisDis.addInternalCause(LR.lymeDisease1);
hepatitisDis.addInternalCause(LR.sarcoidosisHepatic);
hepatitisDis.addInternalCause(LR.toxoplasmosisAcquiredAdvanced);
hepatitisDis.addCausesAbnormalCondition(LR.hepatomegaly);
hepatitisDis.addReference("pp 733-6");
hepatitisDis.setMiscComments(
    "Viral hepatitis differs from the version caused by chemicals and drugs. " +
    "There are 5 sub types of the viral variant.");


// -------------- hepatitisViral --------------
// (C) OntoOO Inc Tue Mar 08 14:20:30 PST 2005
Disease hepatitisViralDis = new Disease(
   LR.hepatitisViral, 
   "liver damage due to a viral infection", 
   LR.hepatobiliaryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -11, //  duration 
   F.hepatitisViralFreq,
   LR.hepatobiliarySysSt, 
   LR.none
);
hepatitisViralDis.setPrintName("hepatitis viral");
hepatitisViralDis.setSuperDisease(LR.hepatitis);
hepatitisViralDis.addReference("pp 733-6");
hepatitisViralDis.setCode358(47);
hepatitisViralDis.setICD10code("B15");


// -------------- hepatitisProdromal --------------
// (C) OntoOO Inc Thu Apr 15 10:39:51 PDT 2004
Disease hepatitisProdromalDis = new Disease(
   LR.hepatitisProdromal, 
   "first phase of hepatitis", 
   LR.hepatobiliaryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -3, //  duration 
   F.hepatitisProdromalFreq,
   LR.hepatobiliarySysSt, 
   LR.none
);
hepatitisProdromalDis.setPrintName("hepatitis prodromal");
hepatitisProdromalDis.setSuperDisease(LR.hepatitisViral);
hepatitisProdromalDis.setTemperature((float)101.0);
hepatitisProdromalDis.addSymptom(LR.arthralgia);
hepatitisProdromalDis.addSymptom(LR.fatigue);
hepatitisProdromalDis.addSymptom(LR.headache);
hepatitisProdromalDis.addSymptom(LR.malaise);
hepatitisProdromalDis.addSymptom(LR.myalgia);
hepatitisProdromalDis.addSymptom(LR.nausea);
hepatitisProdromalDis.addSymptom(LR.vomiting);
hepatitisProdromalDis.addSymptom(LR.weakness);
hepatitisProdromalDis.addSymptom(LR.weightLoss);
hepatitisProdromalDis.addCausesDisease(LR.hepatitisJaundice); 
hepatitisProdromalDis.addReference("pp 733-6");
hepatitisProdromalDis.setMiscComments(
    "Sometimes changes in senses of taste and smell");
hepatitisProdromalDis.setCode358(47);
hepatitisProdromalDis.setICD10code("B15");


// -------------- hepatitisJaundice --------------
// (C) OntoOO Inc Thu Apr 15 10:51:57 PDT 2004
Disease hepatitisJaundiceDis = new Disease(
   LR.hepatitisJaundice, 
   "second jaundice phase of hepatitis", 
   LR.hepatobiliaryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   2, //  minAge 
   LR.maxAge,
   -5, //  duration 
   F.hepatitisJaundiceFreq,
   LR.hepatobiliarySysSt, 
   LR.none
);
hepatitisJaundiceDis.setPrintName("hepatitis jaundice");
hepatitisJaundiceDis.setSuperDisease(LR.hepatitisViral);
hepatitisJaundiceDis.setTemperature((float)101.0);
hepatitisJaundiceDis.addSymptom(LR.abdomenPain);
hepatitisJaundiceDis.addSymptom(LR.dyspepsia);
hepatitisJaundiceDis.addSymptom(LR.jaundice);
hepatitisJaundiceDis.addSymptom(LR.rash);
hepatitisJaundiceDis.addSymptom(LR.rashRed);
hepatitisJaundiceDis.addSymptom(LR.urticaria);
hepatitisJaundiceDis.addInternalCause(LR.hepatitisProdromal);
hepatitisJaundiceDis.addReference("pp 733-6");
hepatitisJaundiceDis.setCode358(47);
hepatitisJaundiceDis.setICD10code("B15");


// -------------- hepatitisNonViral --------------
// (C) OntoOO Inc Tue Mar 08 14:39:50 PST 2005
Disease hepatitisNonViralDis = new Disease(
   LR.hepatitisNonViral, 
   "liver damage due to a non viral infection", 
   LR.hepatobiliaryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   2, //  minAge 
   LR.maxAge,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.hepatobiliarySysSt, 
   LR.none
);
hepatitisNonViralDis.setPrintName("hepatitis non viral");
hepatitisNonViralDis.setSuperDisease(LR.hepatitis);
hepatitisNonViralDis.addSymptom(LR.abdomenPain);
hepatitisNonViralDis.addSymptom(LR.jaundice);
hepatitisNonViralDis.addSymptom(LR.nausea);
hepatitisNonViralDis.addSymptom(LR.vomiting);
hepatitisNonViralDis.addReference("pp 733-6");


// -------------- cirrhosis --------------
// (C) OntoOO Inc Tue Sep 14 15:41:03 GMT-08:00 2004
Disease cirrhosisDis = new Disease(
   LR.cirrhosis, 
   "destruction of liver cells and their replacement by fibrotic cells", 
   LR.hepatobiliaryDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   40, //  minAge 
   LR.maxAge,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.hepatobiliarySysSt, 
   LR.none
);
cirrhosisDis.addSymptom(LR.anorexia, "", 1.0f);
cirrhosisDis.addSymptom(LR.abdomenPain, "", 1.0f);
cirrhosisDis.addSymptom(LR.dyspepsia, "", 1.0f);
cirrhosisDis.addSymptom(LR.nausea, "", 1.0f);
cirrhosisDis.addSymptom(LR.vomiting, "", 1.0f);
cirrhosisDis.addInternalCause(LR.ulcerativeColitis);
cirrhosisDis.addReference("pp 736-40");
cirrhosisDis.setMiscComments("alcohol is prohibited/ mortality is high");
Treatment cirrhosisTr1 = new Treatment("cirrhosisTr1");
cirrhosisTr1.addTreatmentAction(LR.dietHighCalorie);
cirrhosisDis.addTreatment("cirrhosisTr1");
cirrhosisDis.setCode358(298);
cirrhosisDis.setICD10code("K70");


// -------------- cholelithiasis --------------
// (C) OntoOO Inc Fri Feb 20 15:26:46 PST 2004
Disease cholelithiasisDis = new Disease(
   LR.cholelithiasis, 
   "gallstone in the gallbladder", 
   LR.hepatobiliaryDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gallbladderSysSt, 
   LR.none
);
cholelithiasisDis.addSymptom(LR.abdomenPainUpperSide, "right side", 1.0f);
cholelithiasisDis.addSymptom(LR.backPain, "between shoulders", 0.3f);
cholelithiasisDis.addSymptom(LR.belching, "", 0.3f);
cholelithiasisDis.addSymptom(LR.chestPain, "", 0.3f);
cholelithiasisDis.addSymptom(LR.chills, "", 0.3f);
cholelithiasisDis.addSymptom(LR.diaphoresis, "", 0.3f);
cholelithiasisDis.addSymptom(LR.gas, "", 0.3f);
cholelithiasisDis.addSymptom(LR.dyspepsia, "", 0.3f);
cholelithiasisDis.addSymptom(LR.jaundice, "", 0.3f);
cholelithiasisDis.addSymptom(LR.nausea, "", 0.3f);
cholelithiasisDis.addSymptom(LR.vomiting, "", 0.3f);
cholelithiasisDis.addInternalCause(LR.celiacDisease);
cholelithiasisDis.addInternalCause(LR.diabetesMellitus);
cholelithiasisDis.addInternalCause(LR.pancreatitis);
cholelithiasisDis.addCausingAbnormalCondition(LR.pregnancy);
cholelithiasisDis.addReference("pp 747-50");
Treatment cholelithiasisTr1  = new Treatment("cholelithiasisTr1");
cholelithiasisTr1.addTreatmentAction(LR.surgery);
cholelithiasisTr1.addTreatmentAction(LR.dietLowFat);
cholelithiasisTr1.addDrug(LR.vitaminK);
cholelithiasisDis.addTreatment(cholelithiasisTr1.getName());
cholelithiasisDis.setCode358(302);
cholelithiasisDis.setICD10code("K80");

  } // end doit()

} // end InitHepaticDiseases
