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

public class InitHematologicDiseases {
  public static void doit() {

// -------------- anemia --------------
// (C) OntoOO Inc Fri Apr 12 16:31:15 PDT 2002
Disease anemiaDis = new Disease(
   LR.anemia, 
   "lack of red blood cells, hemoglobin or total volume", 
   LR.hematologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.hematologicSysSt, 
   LR.none
);

anemiaDis.addInternalCause(LR.benignProstaticHyperplasia2); 
anemiaDis.addInternalCause(LR.bronchiectasis);
anemiaDis.addInternalCause(LR.celiacDisease);
anemiaDis.addInternalCause(LR.cervixCancerAdvanced);
anemiaDis.addInternalCause(LR.colorectalCancer);
anemiaDis.addInternalCause(LR.hirschsprungChild);
anemiaDis.addInternalCause(LR.hirschsprungAdult);
anemiaDis.addInternalCause(LR.hodgkinDisease2);
anemiaDis.addInternalCause(LR.hydatidiformMole);
anemiaDis.addInternalCause(LR.hypersplenism);
anemiaDis.addInternalCause(LR.leukemia);
anemiaDis.addInternalCause(LR.multipleMyeloma);
anemiaDis.addInternalCause(LR.pyelonephritisChronic);
anemiaDis.addInternalCause(LR.stomachCancerAdvanced);
anemiaDis.addInternalCause(LR.syphilisLateBenign);
anemiaDis.addInternalCause(LR.tubularNecrosisAcute);
anemiaDis.addInternalCause(LR.ulcerativeColitis);
anemiaDis.addInternalCause(LR.vitaminCDeficiency);
anemiaDis.addReference("pp 1021-36");


// -------------- anemiaFolicAcidDeficiency --------------
// (C) OntoOO Inc Fri Apr 12 13:17:13 PDT 2002
Disease anemiaFolicAcidDeficiencyDis = new Disease(
   LR.anemiaFolicAcidDeficiency, 
   "anemia due to lack of folic acid", 
   LR.hematologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   2, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.hematologicSysSt, 
   LR.alcoholAbuse
);
anemiaFolicAcidDeficiencyDis.setPrintName("anemia folic acid deficiency");
anemiaFolicAcidDeficiencyDis.setSuperDisease(LR.anemia);
anemiaFolicAcidDeficiencyDis.addSymptom(LR.anorexia); 
anemiaFolicAcidDeficiencyDis.addSymptom(LR.breathlessness); 
anemiaFolicAcidDeficiencyDis.addSymptom(LR.fainting); 
anemiaFolicAcidDeficiencyDis.addSymptom(LR.fatigue); 
anemiaFolicAcidDeficiencyDis.addSymptom(LR.forgetfulness);
anemiaFolicAcidDeficiencyDis.addSymptom(LR.headache); 
anemiaFolicAcidDeficiencyDis.addSymptom(LR.irritability); 
anemiaFolicAcidDeficiencyDis.addSymptom(LR.jaundice); 
anemiaFolicAcidDeficiencyDis.addSymptom(LR.nausea); 
anemiaFolicAcidDeficiencyDis.addSymptom(LR.pallor); 
anemiaFolicAcidDeficiencyDis.addSymptom(LR.palpitations); 
anemiaFolicAcidDeficiencyDis.addSymptom(LR.weakness); 
anemiaFolicAcidDeficiencyDis.addExternalCause(LR.excessiveCooking); 
anemiaFolicAcidDeficiencyDis.addExternalCause(LR.dietPoor);
anemiaFolicAcidDeficiencyDis.addCausesDisease(LR.glossitis);
anemiaFolicAcidDeficiencyDis.addCausingAbnormalCondition(LR.pregnancy);
anemiaFolicAcidDeficiencyDis.addCausingAbnormalCondition(LR.lactating);
anemiaFolicAcidDeficiencyDis.addReference("pp 1025-6");
Treatment anemiaFolicAcidDeficiencyTr1  = new Treatment("anemiaFolicAcidDeficiencyTr1");
anemiaFolicAcidDeficiencyTr1.addDrug(LR.folicAcidSupplement);
anemiaFolicAcidDeficiencyDis.addTreatment(anemiaFolicAcidDeficiencyTr1.getName());


    // -------------- DIC/ disseminatedIntravascularCoagulation ----------
// (C) OntoOO Inc Sun Nov 04 21:31:35 PST 2001
Disease disseminatedIntravascularCoagulationDis = new Disease(
   LR.disseminatedIntravascularCoagulation, 
   "abnormal bleeding in the absence of an obvious cause/ " + 
   "a complication of diversity of upstream diseases", 
   LR.hematologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.hematologicSysSt, 
   LR.none
);
disseminatedIntravascularCoagulationDis.setPrintName(
  "disseminated intravascular coagulation");
disseminatedIntravascularCoagulationDis.addSymptom(LR.bleedingAbnormal); 
disseminatedIntravascularCoagulationDis.addSymptom(LR.bruising);
disseminatedIntravascularCoagulationDis.addSymptom(LR.hypotension);
disseminatedIntravascularCoagulationDis.addInternalCause(
   LR.necrotizingEnterocolitis);
disseminatedIntravascularCoagulationDis.addInternalCause(LR.malaria2);
disseminatedIntravascularCoagulationDis.addInternalCause(
   LR.meningococcemiaSevere); 
disseminatedIntravascularCoagulationDis.addReference("pp 1052-5");
Treatment disseminatedIntravascularCoagulationTr1  = 
  new Treatment("disseminatedIntravascularCoagulationTr1");
disseminatedIntravascularCoagulationTr1.addTreatmentAction(LR.IVFluids);
disseminatedIntravascularCoagulationTr1.addTreatmentAction(LR.bloodTransfusion);
disseminatedIntravascularCoagulationTr1.addTreatmentAction(LR.platelets);
disseminatedIntravascularCoagulationTr1.addTreatmentAction(LR.freshFrozenPlasma);
disseminatedIntravascularCoagulationTr1.addTreatmentAction(LR.pressureDressing);
disseminatedIntravascularCoagulationDis.addTreatment(
     disseminatedIntravascularCoagulationTr1.getName());


    // -------------- hypersplenism  ---------------
// (C) OntoOO Inc Tue Oct 16 10:54:48 PDT 2001
Disease hypersplenismDis = new Disease(
   LR.hypersplenism, 
   "over active spleen that destroys blood cells", 
   LR.hematologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.spleenSysSt, 
   LR.none
);
hypersplenismDis.addSymptom(LR.palpitations);
hypersplenismDis.addSymptom(LR.weakness);
hypersplenismDis.addSymptom(LR.bruising);
hypersplenismDis.addSymptom(LR.bleedingSpontaneously);
hypersplenismDis.addSymptom(LR.ulcer, "on mouth, leg and feet", 0.8f);
hypersplenismDis.addInternalCause(LR.malaria);
hypersplenismDis.addInternalCause(LR.polycythemiaVera);
hypersplenismDis.addInternalCause(LR.rheumatoidArthritis);
hypersplenismDis.addCausesDisease(LR.anemia);
hypersplenismDis.addCausesAbnormalCondition(LR.splenomegaly);
hypersplenismDis.addCausesAbnormalCondition(LR.leukopenia);
hypersplenismDis.addCausesAbnormalCondition(LR.thrombocytopenia);
hypersplenismDis.addReference("pp 1057-9");


// -------------- idiopathicThrombocytopenicPurpura --------------
// (C) OntoOO Inc Sun Feb 02 18:38:57 PST 2003
Disease idiopathicThrombocytopenicPurpuraDis = new Disease(
   LR.idiopathicThrombocytopenicPurpura, 
   "platelet destruction", 
   LR.hematologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.hematologicSysSt, 
   LR.none
);
idiopathicThrombocytopenicPurpuraDis.setPrintName("idiopathic thrombocytopenic purpura");
idiopathicThrombocytopenicPurpuraDis.addSymptom(LR.bleedingFromMouth);
idiopathicThrombocytopenicPurpuraDis.addSymptom(LR.bleedingFromNose);
idiopathicThrombocytopenicPurpuraDis.addSymptom(LR.ecchymoses);
idiopathicThrombocytopenicPurpuraDis.addSymptom(LR.petechiae);
idiopathicThrombocytopenicPurpuraDis.addReference("pp 1049-51");


// -------------- idiopathicThrombocytopenicPurpuraAcute --------------
// (C) OntoOO Inc Tue Jun 29 13:28:09 PDT 2004
Disease idiopathicThrombocytopenicPurpuraAcuteDis = new Disease(
   LR.idiopathicThrombocytopenicPurpuraAcute, 
   "platelet destruction acute", 
   LR.hematologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   6,
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.hematologicSysSt, 
   LR.none
);
idiopathicThrombocytopenicPurpuraAcuteDis.setPrintName("idiopathic thrombocytopenic purpura acute");
idiopathicThrombocytopenicPurpuraAcuteDis.setSuperDisease(LR.idiopathicThrombocytopenicPurpura);
idiopathicThrombocytopenicPurpuraAcuteDis.addReference("pp 1049-51");
Treatment idiopathicThrombocytopenicPurpuraAcuteTr1  = 
    new Treatment("idiopathicThrombocytopenicPurpuraAcuteTr1");
idiopathicThrombocytopenicPurpuraAcuteTr1.addDrug(LR.glucocorticoids);
idiopathicThrombocytopenicPurpuraAcuteDis.addTreatment(
	       idiopathicThrombocytopenicPurpuraAcuteTr1.getName());


// -------------- idiopathicThrombocytopenicPurpuraChronic --------------
// (C) OntoOO Inc Tue Jun 29 13:41:48 PDT 2004
Disease idiopathicThrombocytopenicPurpuraChronicDis = new Disease(
   LR.idiopathicThrombocytopenicPurpuraChronic, 
   "platelet destruction chronic", 
   LR.hematologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   18, //  minAge 
   55,
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.hematologicSysSt, 
   LR.none
);
idiopathicThrombocytopenicPurpuraChronicDis.setPrintName(
     "idiopathic thrombocytopenic purpura chronic");
idiopathicThrombocytopenicPurpuraChronicDis.setSuperDisease(LR.idiopathicThrombocytopenicPurpura);
idiopathicThrombocytopenicPurpuraChronicDis.addReference("pp 1049-51");
Treatment idiopathicThrombocytopenicPurpuraChronicTr1 = 
      new Treatment("idiopathicThrombocytopenicPurpuraChronicTr1");
idiopathicThrombocytopenicPurpuraChronicTr1.addDrug(LR.corticosteroids);
idiopathicThrombocytopenicPurpuraChronicDis.addTreatment(
      "idiopathicThrombocytopenicPurpuraChronicTr1");
Treatment idiopathicThrombocytopenicPurpuraChronicTr2 =
      new Treatment("idiopathicThrombocytopenicPurpuraChronicTr2", LR.ifSevere);
idiopathicThrombocytopenicPurpuraChronicTr2.addTreatmentAction(LR.splenectomy);
idiopathicThrombocytopenicPurpuraChronicDis.addTreatment(
      idiopathicThrombocytopenicPurpuraChronicTr2.getName());


    // -------------- polycythemiaVera  ---------------
// (C) OntoOO Inc Sun Sep 09 18:16:49 PDT 2001
// (C) OntoOO Inc Sat Aug 21 14:33:34 GMT-08:00 2004
Disease polycythemiaVeraDis = new Disease(
   LR.polycythemiaVera, 
   "increased blood cell mass & leukocytosis & thrombocytosis & " +
   "increased hemoglobin concentration", 
   LR.hematologicDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.jewishAmerican, // raceSpecificity 
   40, //  minAge 
   60,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.hematologicSysSt, 
   LR.none
);
polycythemiaVeraDis.setPrintName("polycythemia vera");
polycythemiaVeraDis.addSymptom(LR.cyanosis, "", 1.0f);
polycythemiaVeraDis.addSymptom(LR.dizziness, "", 1.0f);
polycythemiaVeraDis.addSymptom(LR.headache, "", 1.0f);
polycythemiaVeraDis.addSymptom(LR.digitsClubbing);
polycythemiaVeraDis.addSymptom(LR.noseCyanosis);
polycythemiaVeraDis.addCausesAbnormalCondition(LR.hypervolemia);
polycythemiaVeraDis.addReference("pp 1036-9");
Treatment polycythemiaVeraTr1  = new Treatment("polycythemiaVeraTr1");
polycythemiaVeraTr1.addTreatmentAction(LR.phlebotomy);
polycythemiaVeraDis.addTreatment(polycythemiaVeraTr1.getName());


  } // end doit()

} // end InitHematologicDiseases
