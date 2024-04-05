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

public class InitEyeDiseases {
  public static void doit() {

// -------------- conjunctivitis --------------
// (C) OntoOO Inc Fri Mar 07 12:00:33 PST 2003
Disease conjunctivitisDis = new Disease(
   LR.conjunctivitis, 
   "infection of the inside of the upper eye lid = conjunctiva", 
   LR.eyeDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.eyesSysSt, 
   LR.infection
);
conjunctivitisDis.addSymptom(LR.eyelidHyperemia, "", 1.0f);
conjunctivitisDis.addSymptom(LR.eyePain, "", 0.3f);
conjunctivitisDis.addSymptom(LR.photophobia, "", 0.2f);
conjunctivitisDis.addSymptom(LR.tearing, "", 0.3f); 
conjunctivitisDis.addInternalCause(LR.flu);
conjunctivitisDis.addInternalCause(LR.westNileVirus);
conjunctivitisDis.addInternalCause(LR.whoopingCoughCatarrh);
conjunctivitisDis.addReference("pp 1166-7");
conjunctivitisDis.setMiscComments("infection can be bacterial or viral");
Treatment conjunctivitisTr1  = new Treatment("conjunctivitisTr1", LR.ifBacterialInfection);
conjunctivitisTr1.addDrug(LR.antibiotics);
conjunctivitisTr1.addDrug(LR.sulfonamide);
conjunctivitisDis.addTreatment(conjunctivitisTr1.getName());


// -------------- vascularRetinopathy --------------
// (C) OntoOO Inc Fri Apr 26 20:24:00 PDT 2002
Disease vascularRetinopathyDis = new Disease(
   LR.vascularRetinopathy, 
   "blood supply problem to the eye that effects the retina", 
   LR.eyeDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.eyesSysSt, 
   LR.none
);
vascularRetinopathyDis.setPrintName("vascular retinopathy");
vascularRetinopathyDis.addSymptom(LR.visionDefect);
vascularRetinopathyDis.addSymptom(LR.visionLoss);
vascularRetinopathyDis.addInternalCause(LR.diabetesMellitusAdvanced);
vascularRetinopathyDis.addCausesAbnormalCondition(LR.blindness);
vascularRetinopathyDis.addReference("pp 1175-8");
vascularRetinopathyDis.setMiscComments("vision loss can be partial");


/*
// -------------- diabetesRetinopathy --------------
// (C) OntoOO Inc Fri Apr 26 20:38:33 PDT 2002
Disease diabetesRetinopathyDis = new Disease(
   LR.diabetesRetinopathy, 
   "blood supply problem to the eye that effects the retina triggered by diabetes", 
   LR.eyeDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.eyesSysSt, 
   LR.none
);
diabetesRetinopathyDis.setPrintName("diabetes retinopathy");
diabetesRetinopathyDis.setSuperDisease(LR.vascularRetinopathy);
diabetesRetinopathyDis.addSymptom(LR.visionLoss);
diabetesRetinopathyDis.addInternalCause(LR.diabetesMellitusAdvanced);
diabetesRetinopathyDis.addCausesAbnormalCondition(LR.blindness);
diabetesRetinopathyDis.addReference("pp 1175-8");
Treatment diabetesRetinopathyTr1 = new Treatment("diabetesRetinopathyTr1");
diabetesRetinopathyTr1.addTreatmentAction(LR.laserPhotocoagulation);
diabetesRetinopathyDis.addTreatment(diabetesRetinopathyTr1.getName()); 
*/

// -------------- glaucoma ---------------
// (C) OntoOO Inc Tue Aug 07 15:51:09 PDT 2001
Disease glaucomaDis = new Disease(
   LR.glaucoma, 
   "abnormal high pressure inside the eye that can damage the optic nerve",
   LR.eyeDisorders,
   LR.none, // genderSpecificity 
   LR.africanAmerican, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.eyesSysSt, 
   LR.none
);
glaucomaDis.setWebResource("http://search.yahoo.com/bin/search?p=glaucoma");
glaucomaDis.addInternalCause(LR.sarcoidosisOphthalmic);
glaucomaDis.addReference("pp 1186-9");
glaucomaDis.setMiscComments(
   "Two main variants: chronic & accute with different symptoms & treatments");


// -------------- glaucomaChronic --------------
// (C) OntoOO Inc Fri Mar 07 14:54:21 PST 2003
Disease glaucomaChronicDis = new Disease(
   LR.glaucomaChronic, 
   "abnormal high pressure inside the eye that can damage the optic nerve", 
   LR.eyeDisorders, 
   LR.none, // genderSpecificity 
   LR.africanAmerican, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.eyesSysSt, 
   LR.none
);
glaucomaChronicDis.setPrintName("glaucoma chronic");
glaucomaChronicDis.setWebResource("http://search.yahoo.com/bin/search?p=glaucoma");
glaucomaChronicDis.setSuperDisease(LR.glaucoma);
glaucomaChronicDis.setGenetic("1parent");
glaucomaChronicDis.setParentDisease(LR.glaucoma);
glaucomaChronicDis.addSymptom(LR.eyePainMild);
glaucomaChronicDis.addSymptom(LR.visionPeripheralLoss);
glaucomaChronicDis.addSymptom(LR.visionNightLoss);
glaucomaChronicDis.addSymptom(LR.seeingHalosAroundLights);
glaucomaChronicDis.addInternalCause(LR.diabetes);
glaucomaChronicDis.addInternalCause(LR.hypertension);
glaucomaChronicDis.addReference("pp 1186-9");
Treatment glaucomaChronicTr1  = new Treatment("glaucomaChronicTr1");
glaucomaChronicTr1.addDrug(LR.betaBlocker);
glaucomaChronicTr1.addDrug(LR.diuretics);
glaucomaChronicDis.addTreatment(glaucomaChronicTr1.getName());


// -------------- glaucomaAcute --------------
// (C) OntoOO Inc Wed Mar 12 15:07:52 PST 2003
Disease glaucomaAcuteDis = new Disease(
   LR.glaucomaAcute, 
   "abnormal high pressure inside the eye that can damage the optic nerve", 
   LR.eyeDisorders, 
   LR.none, // genderSpecificity 
   LR.africanAmerican, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.eyesSysSt, 
   LR.none
);
glaucomaAcuteDis.setPrintName("glaucoma acute");
glaucomaAcuteDis.setWebResource("http://search.yahoo.com/bin/search?p=glaucoma");
glaucomaAcuteDis.setSuperDisease(LR.glaucoma);
glaucomaAcuteDis.setGenetic("1parent");
glaucomaAcuteDis.setParentDisease(LR.glaucoma);
glaucomaAcuteDis.addSymptom(LR.eyePainMild, "", 1.0f);
glaucomaAcuteDis.addSymptom(LR.seeingHalosAroundLights, "", 1.0f);
glaucomaAcuteDis.addSymptom(LR.photophobia);
glaucomaAcuteDis.addSymptom(LR.pupilDilation);
glaucomaAcuteDis.addSymptom(LR.corneaCloudy);
glaucomaAcuteDis.addSymptom(LR.eyePressure);
glaucomaAcuteDis.addSymptom(LR.visionBlurred);
glaucomaAcuteDis.addSymptom(LR.nausea, "if severe eye pressure", 0.1f);
glaucomaAcuteDis.addSymptom(LR.vomiting, "if severe eye pressure", 0.1f);
glaucomaAcuteDis.addReference("pp 1186-9");
glaucomaAcuteDis.setMiscComments("without prompt treatment: blindness in 3 to 5 days ");
glaucomaAcuteDis.addTreatment("glaucomaChronicTr1");
Treatment glaucomaAcuteTr1  = new Treatment("glaucomaAcuteTr1");
glaucomaAcuteTr1.addTreatmentAction(LR.surgery);
glaucomaAcuteDis.addTreatment(glaucomaAcuteTr1.getName());


// -------------- keratitis --------------
// (C) OntoOO Inc Thu Mar 13 13:28:02 PST 2003
Disease keratitisDis = new Disease(
   LR.keratitis, 
   "inflammation of the cornea", 
   LR.eyeDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.eyesSysSt, 
   LR.bacterialInfection
);
keratitisDis.addSymptom(LR.corneaOpaque);
keratitisDis.addSymptom(LR.eyePainMild);
keratitisDis.addSymptom(LR.photophobia);
keratitisDis.addSymptom(LR.tearing);
keratitisDis.addSymptom(LR.visionBlurred, "if the center is infected", 0.1f);
keratitisDis.addExternalCause(LR.herpesSimplexVirus);
keratitisDis.addReference("pp 1169-70");
Treatment keratitisTr1  = new Treatment("keratitisTr1");
keratitisTr1.addDrug(LR.trifluridineEyeDrops);
keratitisTr1.addDrug(LR.vidarabineOintment);
keratitisDis.addTreatment(keratitisTr1.getName());


// -------------- maculaDegeneration --------------
// (C) OntoOO Inc Tue Feb 25 18:02:39 PST 2003
Disease maculaDegenerationDis = new Disease(
LR.maculaDegeneration,
"degeneration of cells in the macula area in front of the optic nerve",
LR.eyeDisorders,
LR.none, // genderSpecificity
LR.none, // raceSpecificity
40, // minAge
LR.maxAge,
-1, // duration
-1, // diagnosis frequency, -1 = unknown
LR.eyesSysSt,
LR.none
);
maculaDegenerationDis.setPrintName("macula degeneration");
maculaDegenerationDis.addSymptom(LR.visionBlurred);
maculaDegenerationDis.addSymptom(LR.visionDefect);
maculaDegenerationDis.addReference("pp 1178-9");
Treatment maculaDegenerationTr1  = new Treatment("maculaDegenerationTr1");
maculaDegenerationTr1.addTreatmentAction(LR.laserPhotocoagulation);
maculaDegenerationDis.addTreatment(maculaDegenerationTr1.getName());


// -------------- retinochoroiditis --------------
// (C) OntoOO Inc Tue Mar 25 10:45:16 PST 2003
Disease retinochoroiditisDis = new Disease(
   LR.retinochoroiditis, 
   "inflammation of the retina and choroid marked by small inflammatory areas close to the papilla", 
   LR.eyeDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.eyesSysSt, 
   LR.none
);
retinochoroiditisDis.addSymptom(LR.retinaInflammation);
retinochoroiditisDis.addInternalCause(LR.toxoplasmosisCongenital);
retinochoroiditisDis.addReference("pp 1294-5");
retinochoroiditisDis.setMiscComments("cause is probably an autoimmune process");
Treatment retinochoroiditisTr1  = new Treatment("retinochoroiditisTr1");
retinochoroiditisTr1.addDrug(LR.steroids);
retinochoroiditisDis.addTreatment(retinochoroiditisTr1.getName());


// -------------- trachoma --------------
// (C) OntoOO Inc Thu Mar 13 15:58:20 PST 2003
Disease trachomaDis = new Disease(
   LR.trachoma, 
   "eye infection", 
   LR.eyeDisorders, 
   LR.none, // genderSpecificity 
   LR.indianAmerican, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.eyesSysSt, 
   LR.chlamydialInfection
);
trachomaDis.addSymptom(LR.eyePain);
trachomaDis.addSymptom(LR.eyelidRed);
trachomaDis.addSymptom(LR.eyelidSwollen);
trachomaDis.addSymptom(LR.photophobia);
trachomaDis.addSymptom(LR.tearing);
trachomaDis.addReference("pp 1167-9");
Treatment trachomaTr1  = new Treatment("trachomaTr1");
trachomaTr1.addDrug(LR.antibiotics);
trachomaTr1.addDrug(LR.erythromycin);
trachomaTr1.addDrug(LR.sulfonamide);
trachomaTr1.addDrug(LR.tetracycline);
trachomaDis.addTreatment(trachomaTr1.getName());


// -------------- uveitis --------------
// (C) OntoOO Inc Sun Feb 23 15:59:43 PST 2003
Disease uveitisDis = new Disease(
   LR.uveitis, 
   "inflammation of the front back or both sides of an eye", 
   LR.eyeDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.eyesSysSt, 
   LR.allergens
);
uveitisDis.addExternalCause(LR.infection);
uveitisDis.addExternalCause(LR.trauma);
uveitisDis.addExternalCause(LR.fungi);
uveitisDis.addInternalCause(LR.rheumatoidArthritis);
uveitisDis.addInternalCause(LR.ankylosingSpondylitis);
uveitisDis.addInternalCause(LR.toxoplasmosis);
uveitisDis.addInternalCause(LR.ulcerativeColitis);
uveitisDis.addReference("pp 1173-4");
Treatment uveitisTr1 = new Treatment("uveitisTr1");
uveitisTr1.addDrug(LR.cycloplegic);
uveitisDis.addTreatment("uveitisTr1");
Treatment uveitisTr2  = new Treatment("uveitisTr2", LR.ifSevere);
uveitisTr2.addDrug(LR.corticosteroids);
uveitisDis.addTreatment(uveitisTr2.getName());


// -------------- uveitisAnterior --------------
// (C) OntoOO Inc Mon Feb 24 08:31:28 PST 2003
Disease uveitisAnteriorDis = new Disease(
   LR.uveitisAnterior, 
   "inflammation of the frront side of an eye", 
   LR.eyeDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.eyesSysSt, 
   LR.none
);
uveitisAnteriorDis.setPrintName("uveitis anterior");
uveitisAnteriorDis.setSuperDisease(LR.uveitis);
uveitisAnteriorDis.addSymptom(LR.eyePain);
uveitisAnteriorDis.addSymptom(LR.photophobia);
uveitisAnteriorDis.addSymptom(LR.pupilNonReactive);
uveitisAnteriorDis.addSymptom(LR.tearing);
uveitisAnteriorDis.addSymptom(LR.visionBlurred);
uveitisAnteriorDis.addInternalCause(LR.sarcoidosisOphthalmic);
uveitisAnteriorDis.addReference("pp 1173-4");


// -------------- uveitisPosterior --------------
// (C) OntoOO Inc Tue Feb 25 16:38:12 PST 2003
Disease uveitisPosteriorDis = new Disease(
   LR.uveitisPosterior, 
   "inflammation of the back side of an eye", 
   LR.eyeDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.eyesSysSt, 
   LR.none
);
uveitisPosteriorDis.setPrintName("uveitis posterior");
uveitisPosteriorDis.setSuperDisease(LR.uveitis);
uveitisPosteriorDis.addSymptom(LR.eyePain, "", 0.5f);
uveitisPosteriorDis.addSymptom(LR.photophobia, "", 0.2f);
uveitisPosteriorDis.addSymptom(LR.visionBlurred, "", 1.0f);
uveitisPosteriorDis.addCausesAbnormalCondition(LR.blindness);
uveitisPosteriorDis.addReference("pp 1173-4");
uveitisPosteriorDis.setMiscComments("prognosis is fair to poor");


  } // end doit()

} // end InitEyeDiseases
