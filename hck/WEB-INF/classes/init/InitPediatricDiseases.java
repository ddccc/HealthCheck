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

public class InitPediatricDiseases {
  public static void doit() {

// -------------- colicInfant --------------
// (C) OntoOO Inc Sat Mar 24 19:29:55 PST 2007
Disease colicInfantDis = new Disease(
LR.colicInfant,
"an infant that is otherwise healthy and is well fed but has frequent crying spells",
LR.pediatricDisorders,
LR.none, // genderSpecificity
LR.none, // raceSpecificity
0, // minAge
1,
-6, // duration
-1, // diagnosis frequency, -1 = unknown
LR.bodySysSt,
LR.none
);
colicInfantDis.setPrintName("colic infant");
colicInfantDis.addSymptom(LR.cryingSpellFrequent);
colicInfantDis.addReference("pp2 234-5");
colicInfantDis.setMiscComments(
    "In short: if the baby is healthy - do NOT worry, just provide a caring environment " +
    "with plenty of cuddling");


  } // end doit()

} // end InitPediatricDiseases
