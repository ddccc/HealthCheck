// (C) OntoOO Inc 2000
package init;

import com.Common;
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

public class InitEarDiseases {
  public static void doit() {

// -------------- meniereDisease --------------
// (C) OntoOO Inc Thu Feb 20 15:49:55 PST 2003
Disease meniereDiseaseDis = new Disease(
   LR.meniereDisease, 
   "dysfunction of the labyrinth section of the middle ear", 
   LR.earDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   60,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.earsSysSt, 
   LR.none
);
meniereDiseaseDis.setPrintName("meniere disease");
meniereDiseaseDis.addSymptom(LR.hearingLoss, "after multiple attacks", 1.0f);
meniereDiseaseDis.addSymptom(LR.tinnitus, "", 1.0f);
meniereDiseaseDis.addSymptom(LR.earBlockageFeeling, "", 1.0f);
meniereDiseaseDis.addSymptom(LR.vertigo, "", 1.0f);
meniereDiseaseDis.addSymptom(LR.giddiness, "", 1.0f);
meniereDiseaseDis.addSymptom(LR.nystagmus, "", 1.0f);
meniereDiseaseDis.addSymptom(LR.nausea);
meniereDiseaseDis.addSymptom(LR.sweating);
meniereDiseaseDis.addSymptom(LR.vomiting);
meniereDiseaseDis.addSymptom(LR.lossOfBalance, "", 0.4f);
meniereDiseaseDis.addReference("pp 1205-6");
meniereDiseaseDis.setMiscComments("usually only one ear is involved");
Treatment meniereDiseaseTr1 = new Treatment("meniereDiseaseTr1");
meniereDiseaseTr1.addDrug(LR.atropine);
meniereDiseaseTr1.addDrug(LR.diazepam);
meniereDiseaseDis.addTreatment(meniereDiseaseTr1.getName()); 
Treatment meniereDiseaseTr2 = new Treatment("meniereDiseaseTr2", LR.ifSevereAttack);
meniereDiseaseTr2.addDrug(LR.diphenhydramine);
meniereDiseaseTr2.addDrug(LR.epinephrine);
meniereDiseaseDis.addTreatment(meniereDiseaseTr2.getName()); 
Treatment meniereDiseaseTr3 = new Treatment("meniereDiseaseTr3", LR.ifSevere);
meniereDiseaseTr3.addTreatmentAction(LR.surgery);
meniereDiseaseDis.addTreatment(meniereDiseaseTr3.getName()); 


// -------------- otitisMedia --------------
// (C) OntoOO Inc Fri Jan 17 15:44:08 PST 2003
Disease otitisMediaDis = new Disease(
   LR.otitisMedia, 
   "inflammation of the middle ear", 
   LR.earDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.earsSysSt, 
   LR.infection
);
otitisMediaDis.setPrintName("otitis media");
otitisMediaDis.addSymptom(LR.cough);
otitisMediaDis.addSymptom(LR.dizziness);
otitisMediaDis.addSymptom(LR.earache);
otitisMediaDis.addSymptom(LR.hearingLoss);
otitisMediaDis.addSymptom(LR.nausea);
otitisMediaDis.addSymptom(LR.sneezing);
otitisMediaDis.addSymptom(LR.tinnitus);
otitisMediaDis.addSymptom(LR.vomiting);
otitisMediaDis.addExternalCause(LR.pneumococciInfection);
otitisMediaDis.addExternalCause(LR.staphylococcusInfection);
otitisMediaDis.addExternalCause(LR.streptococcusInfection);
otitisMediaDis.addInternalCause(LR.croup);
otitisMediaDis.addInternalCause(LR.pharyngitisStreptococcal);
otitisMediaDis.addCausesDisease(LR.meningitis);
otitisMediaDis.addReference("pp 1199-1202");
Treatment otitisMediaTr1  = new Treatment("otitisMediaTr1");
otitisMediaTr1.addDrug(LR.antibiotics);
otitisMediaTr1.addDrug(LR.ampicillin);
otitisMediaTr1.addDrug(LR.amoxicillin);
otitisMediaDis.addTreatment(otitisMediaTr1.getName());


  } // end doit()

} // end InitEarDiseases
