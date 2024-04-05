// (C) OntoOO Inc 2000
package init;

import com.D;
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

public class InitSkinDiseases  {
  public static void doit() {

// -------------- cellulitis --------------
// (C) OntoOO Inc Wed Aug 27 17:30:27 PDT 2003
Disease cellulitisDis = new Disease(
   LR.cellulitis, 
   "potentially serious bacterial infection of the skin", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.staphylococcusInfection
);
cellulitisDis.addSymptom(LR.erythema);
cellulitisDis.addSymptom(LR.skinInfection);
cellulitisDis.addSymptom(LR.skinSwollen);
cellulitisDis.addSymptom(LR.skinTender);
cellulitisDis.addSymptom(LR.skinWarm);
cellulitisDis.addExternalCause(LR.streptococcusInfection);
cellulitisDis.addInternalCause(LR.impetigo);
cellulitisDis.addReference(
   "<a HREF='http://www.mayoclinic.com/invoke.cfm?id=DS00450'>" +
   "http://www.mayoclinic.com/invoke.cfm?id=DS00450</a>");
cellulitisDis.setMiscComments("legs arms and face are most commonly affected");
Treatment cellulitisTr1  = new Treatment("cellulitisTr1");
cellulitisTr1.addDrug(LR.antibiotics);
cellulitisDis.addTreatment(cellulitisTr1.getName());


// -------------- dermatitis --------------
// (C) OntoOO Inc Tue Aug 12 17:55:15 PDT 2003
Disease dermatitisDis = new Disease(
   LR.dermatitis, 
   "inflammation of the skin", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
dermatitisDis.addReference("pp 1255-60");
dermatitisDis.setMiscComments(
   "This entry is only the superclass of the different sub diseases");


// -------------- dermatitisAtopic --------------
// (C) OntoOO Inc Tue Aug 12 18:23:21 PDT 2003
Disease dermatitisAtopicDis = new Disease(
   LR.dermatitisAtopic, 
   "inflammation of the skin in infants, children upto adolescence", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   20,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
dermatitisAtopicDis.setPrintName("dermatitis atopic");
dermatitisAtopicDis.setSuperDisease(LR.dermatitis);
dermatitisAtopicDis.addSymptom(LR.skinDry);
dermatitisAtopicDis.addSymptom(LR.skinInfection);
dermatitisAtopicDis.addSymptom(LR.skinLesionDryScaly);
dermatitisAtopicDis.addSymptom(LR.skinLesionRedWeeping);
dermatitisAtopicDis.addExternalCause(LR.foodAllergies);
dermatitisAtopicDis.addExternalCause(LR.chemicals);
dermatitisAtopicDis.addExternalCause(LR.extremeHumidity);
dermatitisAtopicDis.addExternalCause(LR.extremeTemperature);
dermatitisAtopicDis.addReference("pp 1255-60");
dermatitisAtopicDis.setMiscComments("It flares up and subsides repeatedly");
Treatment dermatitisAtopicTr1  = new Treatment("dermatitisAtopicTr1");
dermatitisAtopicTr1.addDrug(LR.corticosteroids);
dermatitisAtopicDis.addTreatment(dermatitisAtopicTr1.getName());


// -------------- dermatitisChronic --------------
// (C) OntoOO Inc Tue Aug 26 16:45:45 PDT 2003
Disease dermatitisChronicDis = new Disease(
   LR.dermatitisChronic, 
   "chronic inflammation of the skin on hands and feet with long remissions", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   20,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
dermatitisChronicDis.setPrintName("dermatitis chronic");
dermatitisChronicDis.setSuperDisease(LR.dermatitis);
dermatitisChronicDis.addSymptom(LR.skinDry, "", 1.0f);
dermatitisChronicDis.addSymptom(LR.skinInfection, "", 1.0f);
dermatitisChronicDis.addSymptom(LR.skinLesionDryScaly, "", 1.0f);
dermatitisChronicDis.addSymptom(LR.skinLesionHand);
dermatitisChronicDis.addInternalCause(LR.dermatitisContact);
dermatitisChronicDis.addReference("pp 1255-60");
Treatment dermatitisChronicTr1  = new Treatment("dermatitisChronicTr1", LR.ifInfection);
dermatitisChronicTr1.addDrug(LR.antibiotics);
dermatitisChronicDis.addTreatment(dermatitisChronicTr1.getName());
Treatment dermatitisChronicTr2 = new Treatment("dermatitisChronicTr2");
dermatitisChronicTr2.addDrug(LR.antihistamines);
dermatitisChronicTr2.addDrug(LR.corticosteroids);
dermatitisChronicDis.addTreatment(dermatitisChronicTr2.getName()); 


// -------------- dermatitisContact --------------
// (C) OntoOO Inc Tue Aug 19 16:45:32 PDT 2003
Disease dermatitisContactDis = new Disease(
   LR.dermatitisContact, 
   "skin inflammation due to contact with concentrated substances", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.allergens
);
dermatitisContactDis.setPrintName("dermatitis contact");
dermatitisContactDis.setSuperDisease(LR.dermatitis);
dermatitisContactDis.addSymptom(LR.skinInfection, "", 1.0f);
dermatitisContactDis.addExternalCause(LR.chemicals); 
dermatitisContactDis.addReference("pp 1255-60");
Treatment dermatitisContactTr1  = new Treatment("dermatitisContactTr1");
dermatitisContactTr1.addTreatmentAction(LR.protectiveClothing);
dermatitisContactTr1.addDrug(LR.antihistamines);
dermatitisContactTr1.addDrug(LR.corticosteroids);
dermatitisContactDis.addTreatment(dermatitisContactTr1.getName());


// -------------- dermatitisContactMild --------------
// (C) OntoOO Inc Wed Aug 20 14:46:01 PDT 2003
Disease dermatitisContactMildDis = new Disease(
   LR.dermatitisContactMild, 
   "mild skin inflammation due to contact with concentrated substances", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
dermatitisContactMildDis.setPrintName("dermatitis contact mild");
dermatitisContactMildDis.setSuperDisease(LR.dermatitisContact);
dermatitisContactMildDis.addSymptom(LR.erythema);
dermatitisContactMildDis.addSymptom(LR.blisterSmallItch);
dermatitisContactMildDis.addSymptom(LR.blisterSmallOoze);
dermatitisContactMildDis.addSymptom(LR.blisterSmallScale);
dermatitisContactMildDis.addReference("pp 1255-60");


// -------------- dermatitisContactStrong --------------
// (C) OntoOO Inc Wed Aug 20 16:12:31 PDT 2003
Disease dermatitisContactStrongDis = new Disease(
   LR.dermatitisContactStrong, 
   "strong skin inflammation due to contact with concentrated substances", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
dermatitisContactStrongDis.setPrintName("dermatitis contact strong");
dermatitisContactStrongDis.setSuperDisease(LR.dermatitisContact);
dermatitisContactStrongDis.addSymptom(LR.blister);
dermatitisContactStrongDis.addSymptom(LR.ulcer);
dermatitisContactStrongDis.addReference("pp 1255-60");


// -------------- dermatitisContactAllergens --------------
// (C) OntoOO Inc Tue Aug 26 15:57:31 PDT 2003
Disease dermatitisContactAllergensDis = new Disease(
   LR.dermatitisContactAllergens, 
   "allergic skin inflammation due to contact with concentrated substances", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
dermatitisContactAllergensDis.setPrintName("dermatitis contact allergic");
dermatitisContactAllergensDis.setSuperDisease(LR.dermatitisContact);
dermatitisContactAllergensDis.addSymptom(LR.edema);
dermatitisContactAllergensDis.addReference("pp 1255-60");


// -------------- dermatitisHerpetiformis --------------
// (C) OntoOO Inc Tue Feb 24 20:00:59 PST 2004
Disease dermatitisHerpetiformisDis = new Disease(
   LR.dermatitisHerpetiformis, 
   "chronic skin inflammation causing severe itching and burning", 
   LR.skinDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
dermatitisHerpetiformisDis.setPrintName("dermatitis herpetiformis");
dermatitisHerpetiformisDis.setSuperDisease(LR.dermatitis);
dermatitisHerpetiformisDis.addSymptom(LR.blister);
dermatitisHerpetiformisDis.addSymptom(LR.burningSensation);
dermatitisHerpetiformisDis.addSymptom(LR.itches, "", 1.0f);
dermatitisHerpetiformisDis.addSymptom(LR.skinInfection, "", 1.0f);
dermatitisHerpetiformisDis.addSymptom(LR.skinLesionRedPapular);
dermatitisHerpetiformisDis.addInternalCause(LR.celiacDisease);

dermatitisHerpetiformisDis.addReference("pp 1284-5");
dermatitisHerpetiformisDis.setMiscComments("also known as Duhring disease");


// -------------- dermatitisNummular --------------
// (C) OntoOO Inc Tue Aug 19 14:52:07 PDT 2003
Disease dermatitisNummularDis = new Disease(
   LR.dermatitisNummular, 
   "chronic inflammation of coin shaped crusted scales and possibly itching " +
   "lesions on arms and legs", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.limbsSysSt, 
   LR.none
);
dermatitisNummularDis.setPrintName("dermatitis nummular");
dermatitisNummularDis.setSuperDisease(LR.dermatitis);
dermatitisNummularDis.addSymptom(LR.skinInfection, "", 1.0f);
dermatitisNummularDis.addSymptom(LR.itches, "", 1.0f);
dermatitisNummularDis.addSymptom(LR.skinLesionCoinShaped);
dermatitisNummularDis.addReference("pp 1255-60");
Treatment dermatitisNummularTr1  = new Treatment("dermatitisNummularTr1");
dermatitisNummularTr1.addTreatmentAction(LR.humidifiedAir);
dermatitisNummularTr1.addTreatmentAction(LR.wetDressings);
dermatitisNummularTr1.addDrug(LR.antibiotics);
dermatitisNummularTr1.addDrug(LR.corticosteroids);
dermatitisNummularTr1.addDrug(LR.antihistamines);
dermatitisNummularDis.addTreatment(dermatitisNummularTr1.getName());


// -------------- dermatitisSeborrheic --------------
// (C) OntoOO Inc Mon Aug 18 15:55:50 PDT 2003
Disease dermatitisSeborrheicDis = new Disease(
   LR.dermatitisSeborrheic, 
   "inflammation of the scalp, face and occasionally on the trunk and skin folds", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.scalpSysSt, 
   LR.none
);
dermatitisSeborrheicDis.setPrintName("dermatitis seborrheic");
dermatitisSeborrheicDis.setSuperDisease(LR.dermatitis);
dermatitisSeborrheicDis.addSymptom(LR.skinInfection, "", 1.0f);
dermatitisSeborrheicDis.addSymptom(LR.itches); 
dermatitisSeborrheicDis.addSymptom(LR.skinLesionGreasy, "", 0.5f);
dermatitisSeborrheicDis.addSymptom(LR.skinLesionYellowScales);
dermatitisSeborrheicDis.addReference("pp 1255-60");
Treatment dermatitisSeborrheicTr1  = new Treatment("dermatitisSeborrheicTr1");
dermatitisSeborrheicTr1.addDrug(LR.corticosteroids);
dermatitisSeborrheicDis.addTreatment(dermatitisSeborrheicTr1.getName());


// -------------- dermatophytosis --------------
// (C) OntoOO Inc Mon Jun 23 16:18:59 PDT 2003
Disease dermatophytosisDis = new Disease(
   LR.dermatophytosis, 
   "fungus infection", 
   LR.skinDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.fungi
);
dermatophytosisDis.addReference("pp 1240-2");
dermatophytosisDis.setMiscComments("becomes chronic in 20% of infections");
Treatment dermatophytosisTr1  = new Treatment("dermatophytosisTr1");
dermatophytosisTr1.addDrug(LR.imidazole);
dermatophytosisTr1.addDrug(LR.griseofulvin);
dermatophytosisDis.addTreatment(dermatophytosisTr1.getName());


// -------------- tineaBarbae --------------
// (C) OntoOO Inc Thu Jul 17 14:47:36 PDT 2003
Disease tineaBarbaeDis = new Disease(
   LR.tineaBarbae, 
   "fungus infection on the beard skin of males", 
   LR.skinDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   15,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.faceSysSt, 
   LR.fungi
);
tineaBarbaeDis.setPrintName("tinea barbae");
tineaBarbaeDis.setSuperDisease(LR.dermatophytosis);
tineaBarbaeDis.addSymptom(LR.beardSkinLesions);
tineaBarbaeDis.addReference("pp 1240-2");
tineaBarbaeDis.setMiscComments("becomes chronic in 20% of infections");


// -------------- tineaCapitis --------------
// (C) OntoOO Inc Tue Jun 24 10:25:40 PDT 2003
Disease tineaCapitisDis = new Disease(
   LR.tineaCapitis, 
   "fungus infection on the scalp", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   15,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.scalpSysSt, 
   LR.fungi
);
tineaCapitisDis.setPrintName("tinea capitis");
tineaCapitisDis.setSuperDisease(LR.dermatophytosis);
tineaCapitisDis.addSymptom(LR.hairBroken);
tineaCapitisDis.addSymptom(LR.hairLoss);
tineaCapitisDis.addSymptom(LR.scalpNodule);
tineaCapitisDis.addReference("pp 1240-2");
tineaCapitisDis.setMiscComments("becomes chronic in 20% of infections");


// -------------- tineaCorporis --------------
// (C) OntoOO Inc Thu Jun 26 16:27:54 PDT 2003
Disease tineaCorporisDis = new Disease(
   LR.tineaCorporis, 
   "fungus infection on the body", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   15,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.fungi
);
tineaCorporisDis.setPrintName("tinea corporis");
tineaCorporisDis.setSuperDisease(LR.dermatophytosis);
tineaCorporisDis.addSymptom(LR.skinLesionDryScaly, "", 0.5f);
tineaCorporisDis.addSymptom(LR.skinLesionMoistCrusty, "", 0.5f);
tineaCorporisDis.addSymptom(LR.skinLesionRingShaped);
tineaCorporisDis.addReference("pp 1240-2");
tineaCorporisDis.setMiscComments("becomes chronic in 20% of infections");


// -------------- tineaCruris --------------
// (C) OntoOO Inc Tue Jul 01 15:54:09 PDT 2003
Disease tineaCrurisDis = new Disease(
   LR.tineaCruris, 
   "fungus infection of the groin buttocks inner thights and genital area", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   15,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.groinSysSt, 
   LR.fungi
);
tineaCrurisDis.setPrintName("tinea cruris");
tineaCrurisDis.setSuperDisease(LR.dermatophytosis);
tineaCrurisDis.addSymptom(LR.groinLesionItchy);
tineaCrurisDis.addSymptom(LR.groinLesionRed);
tineaCrurisDis.addReference("pp 1240-2");
tineaCrurisDis.setMiscComments("becomes chronic in 20% of infections");


// -------------- tineaPedis --------------
// (C) OntoOO Inc Mon Jun 30 15:18:29 PDT 2003
Disease tineaPedisDis = new Disease(
   LR.tineaPedis, 
   "fungus infection on the feet between the toes", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   15,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.feetSysSt, 
   LR.fungi
);
tineaPedisDis.setPrintName("tinea pedis");
tineaPedisDis.setSuperDisease(LR.dermatophytosis);
tineaPedisDis.addSymptom(LR.toesBetweenBlisters);
tineaPedisDis.addSymptom(LR.toesBetweenScaling);
tineaPedisDis.addReference("pp 1240-2");
tineaPedisDis.setMiscComments("becomes chronic in 20% of infections");


// -------------- tineaUnguium --------------
// (C) OntoOO Inc Mon Jun 30 13:36:31 PDT 2003
Disease tineaUnguiumDis = new Disease(
   LR.tineaUnguium, 
   "fungus infection of the toenails", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   15,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.toeNailsSysSt, 
   LR.fungi
);
tineaUnguiumDis.setPrintName("tinea unguium");
tineaUnguiumDis.setSuperDisease(LR.dermatophytosis);
tineaUnguiumDis.addSymptom(LR.toeNailCrumble);
tineaUnguiumDis.addSymptom(LR.toeNailDiscolor);
tineaUnguiumDis.addSymptom(LR.toeNailThicken);
tineaUnguiumDis.addReference("pp 1240-2");
tineaUnguiumDis.setMiscComments("becomes chronic in 20% of infections");


// -------------- pediculosis --------------
// (C) OntoOO Inc Thu Sep 18 16:10:18 PDT 2003
Disease pediculosisDis = new Disease(
   LR.pediculosis, 
   "skin disease caused by three different kind of lice", 
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
pediculosisDis.addExternalCause(LR.lice);
pediculosisDis.addReference("pp 1244-6");


// -------------- pediculosisCapitis --------------
// (C) OntoOO Inc Sun Sep 21 16:06:18 PDT 2003
Disease pediculosisCapitisDis = new Disease(
   LR.pediculosisCapitis, 
   "head lice usually on the scalp", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.scalpSysSt, 
   LR.none
);
pediculosisCapitisDis.setPrintName("pediculosis capitis");
pediculosisCapitisDis.setSuperDisease(LR.pediculosis);
pediculosisCapitisDis.addSymptom(LR.itches);
pediculosisCapitisDis.addSymptom(LR.hairSmelly);
pediculosisCapitisDis.addSymptom(LR.neckLymphNodeEnlarged);
pediculosisCapitisDis.addReference("pp 1244-6");
Treatment pediculosisCapitisTr1  = new Treatment("pediculosisCapitisTr1");
pediculosisCapitisTr1.addTreatmentAction(LR.permethrinCream);
pediculosisCapitisDis.addTreatment(pediculosisCapitisTr1.getName());


// -------------- pediculosisCorporis --------------
// (C) OntoOO Inc Sun Sep 21 17:33:17 PDT 2003
Disease pediculosisCorporisDis = new Disease(
   LR.pediculosisCorporis, 
   "lice usually on the shoulders trunk and buttocks", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
pediculosisCorporisDis.setPrintName("pediculosis corporis");
pediculosisCorporisDis.setSuperDisease(LR.pediculosis);
pediculosisCorporisDis.addSymptom(LR.papuleRedSmall);
pediculosisCorporisDis.addSymptom(LR.wheals, "later", 0.5f);
pediculosisCorporisDis.addReference("pp 1244-6");
Treatment pediculosisCorporisTr1  = new Treatment("pediculosisCorporisTr1");
pediculosisCorporisTr1.addTreatmentAction(LR.lindaneCream);
pediculosisCorporisDis.addTreatment(pediculosisCorporisTr1.getName());


// -------------- pediculosisPubis --------------
// (C) OntoOO Inc Tue Sep 23 09:13:00 PDT 2003
Disease pediculosisPubisDis = new Disease(
   LR.pediculosisPubis, 
   "lice primarily in pubis hair", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.pubisHairSysSt,
   LR.none
);
pediculosisPubisDis.setPrintName("pediculosis pubis");
pediculosisPubisDis.setSuperDisease(LR.pediculosis);
pediculosisPubisDis.addSymptom(LR.pubisSkinIrritation);
pediculosisPubisDis.addReference("pp 1244-6");
Treatment pediculosisPubisTr1  = new Treatment("pediculosisPubisTr1");
pediculosisPubisTr1.addTreatmentAction(LR.lindaneShampoo);
pediculosisPubisDis.addTreatment(pediculosisPubisTr1.getName());
pediculosisPubisDis.addIllustration(D.PubicLiceJpg);


// -------------- psoriasis --------------
// (C) OntoOO Inc Wed Sep 17 17:10:55 PDT 2003
Disease psoriasisDis = new Disease(
   LR.psoriasis, 
   "excessive skin growth that results in silvery scales", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.stress
);
psoriasisDis.setGenetic("1parent");
psoriasisDis.setParentDisease(LR.psoriasis);
psoriasisDis.addSymptom(LR.erythema);
psoriasisDis.addSymptom(LR.itches);
psoriasisDis.addSymptom(LR.skinLesionDryScaly);
psoriasisDis.addSymptom(LR.skinLesionCrackedCrusty);
psoriasisDis.addSymptom(LR.skinPlaques);
psoriasisDis.addSymptom(LR.skinSilveryScales);
psoriasisDis.addExternalCause(LR.trauma);
psoriasisDis.addInternalCause(LR.celiacDisease);
psoriasisDis.addCausingAbnormalCondition(LR.pregnancy);
psoriasisDis.addReference("pp 1264-6");
psoriasisDis.setMiscComments("remissions and flare-ups alternate");
Treatment psoriasisTr1  = new Treatment("psoriasisTr1");
psoriasisTr1.addDrug(LR.steroidCream);
psoriasisDis.addTreatment(psoriasisTr1.getName());


// -------------- scabies --------------
// (C) OntoOO Inc Wed Aug 06 13:09:41 PDT 2003
Disease scabiesDis = new Disease(
   LR.scabies, 
   "skin infection due to itch mites", 
   LR.skinDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
scabiesDis.addSymptom(LR.elbowLesion);
scabiesDis.addSymptom(LR.fingerLesion);
scabiesDis.addSymptom(LR.itches);
scabiesDis.addSymptom(LR.waistlineLesion);
scabiesDis.addSymptom(LR.wristLesion);
scabiesDis.addExternalCause(LR.itchMite);
scabiesDis.addReference("pp 1242-3");
Treatment scabiesTr1  = new Treatment("scabiesTr1");
scabiesTr1.addTreatmentAction(LR.lindaneCream);
scabiesDis.addTreatment(scabiesTr1.getName());
scabiesDis.addIllustration(D.ScabiesHandJpg);


  } // end doit()

} // end InitSkinDiseases 
