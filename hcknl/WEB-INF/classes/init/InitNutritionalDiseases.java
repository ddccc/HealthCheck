// (C) OntoOO Inc 2007
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

public class InitNutritionalDiseases {
  public static void doit() {

// -------------- obesity --------------
// (C) OntoOO Inc Wed Mar 21 10:53:06 PST 2007
Disease obesityDis = new Disease(
   LR.obesity, 
   "excess of body fat, generally 20 percent above ideal body weight", 
   LR.nutritionalDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);

obesityDis.addSymptom(LR.BMIover30);
obesityDis.addSymptom(LR.overweight);
obesityDis.addCausesDisease(LR.atelectasis);
obesityDis.addCausesDisease(LR.diabetesComplicationsInPregnancy);
obesityDis.addCausesDisease(LR.diabetesMellitus);
obesityDis.addCausesDisease(LR.hypertension);
obesityDis.addCausesDisease(LR.pulmonaryEmbolism);
obesityDis.addCausesDisease(LR.uterusCancer);
obesityDis.addCausesDisease(LR.vulvaCancer);
obesityDis.addCausesAbnormalCondition(LR.death);
obesityDis.addReference("pp 874");
obesityDis.setMiscComments(
     "Excessive calorie intake and insufficient exercise are caused " +
     "by lifestyle choices, while genetic predispositions play a role as well. " +
     "Surgery is used in extreme cases");
Treatment obesityTr1  = new Treatment("obesityTr1");
obesityTr1.addTreatmentAction(LR.diet);
obesityTr1.addTreatmentAction(LR.exercise);
obesityTr1.addTreatmentAction(LR.surgery);
obesityDis.addTreatment(obesityTr1.getName());


  } // end doit()

} // end InitNutritionalDiseases

