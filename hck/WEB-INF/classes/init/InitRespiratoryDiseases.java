// (C) OntoOO Inc 2000
package init;

import com.D;
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

public class InitRespiratoryDiseases {
  public static void doit() {

// -------------- respiratoryDistressSyndrome --------------
// (C) OntoOO Inc Tue Jun 18 10:46:49 PDT 2002
Disease respiratoryDistressSyndromeDis = new Disease(
   LR.respiratoryDistressSyndrome, 
   "premature infants having underdeveloped lungs", 
   LR.respiratoryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   1,
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.none
);
respiratoryDistressSyndromeDis.setPrintName("respiratory distress syndrome");
respiratoryDistressSyndromeDis.addSymptom(LR.edemaPeripheral, "", 0.5f);
respiratoryDistressSyndromeDis.addSymptom(LR.grunting, "", 1.0f);
respiratoryDistressSyndromeDis.addSymptom(LR.hypotension, "", 0.5f);
respiratoryDistressSyndromeDis.addSymptom(LR.oliguria, "", 0.5f);
respiratoryDistressSyndromeDis.addSymptom(LR.tachypnea, "", 1.0f);
respiratoryDistressSyndromeDis.addSymptom(LR.respirationShallow, "", 1.0f);
respiratoryDistressSyndromeDis.addReference("pp 493-5");
Treatment respiratoryDistressSyndromeTr1  = new Treatment("respiratoryDistressSyndromeTr1");
respiratoryDistressSyndromeTr1.addTreatmentAction(LR.IVFluids);
respiratoryDistressSyndromeTr1.addTreatmentAction(LR.IVNutrition);
respiratoryDistressSyndromeTr1.addTreatmentAction(LR.mechanicalVentilation);
respiratoryDistressSyndromeDis.addTreatment(respiratoryDistressSyndromeTr1.getName());


// -------------- croup --------------
// (C) OntoOO Inc Tue Jan 28 09:30:11 PST 2003
Disease croupDis = new Disease(
   LR.croup, 
   "laryngitis in children, i.e. respiratory difficulties and a harsh cough", 
   LR.respiratoryDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   3,
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.tracheaSysSt, 
   LR.infection
);
croupDis.addSymptom(LR.coughBark, "", 1.0f);
croupDis.addSymptom(LR.stridor, "", 0.7f);
croupDis.addSymptom(LR.hoarseness, "", 0.5f);
croupDis.addSymptom(LR.respirationDistress, "", 0.6f);
croupDis.addSymptom(LR.throatSpasm, "", 0.3f);
croupDis.addExternalCause(LR.adenoVirusInfection);
croupDis.addExternalCause(LR.diphteriaBacterialInfection);
croupDis.addExternalCause(LR.influenzaVirusInfection);
croupDis.addExternalCause(LR.parainfluenzaVirusInfection);
croupDis.addExternalCause(LR.measlesVirusInfection);
croupDis.addExternalCause(LR.pertussisBacterialInfection);
croupDis.addExternalCause(LR.respiratorySyncytialVirusInfection);
croupDis.addCausesDisease(LR.otitisMedia);
croupDis.addCausesDisease(LR.pneumonia);
croupDis.addReference("pp 496-498");
Treatment croupTr1 = new Treatment("croupTr1");
croupTr1.addTreatmentAction(LR.ifFeverProvideAntipyretic);
croupTr1.addDrug(LR.ifInfectionProvideAntibiotic);
croupTr1.addDrug(LR.inhaleRacemicEpiphrine);
croupTr1.addDrug(LR.inhaleCorticosteroids);
croupDis.addTreatment("croupTr1");
Treatment croupTr2 = new Treatment("croupTr2", LR.ifDistress);
croupDis.addTreatment("croupTr2");
Treatment croupTr3 = new Treatment("croupTr3", LR.ifModerate);
croupTr3.addTreatmentAction(LR.homeCareAndRest);
croupDis.addTreatment("croupTr3");
Treatment croupTr4 = new Treatment("croupTr4", LR.ifSevere);
croupTr4.addTreatmentAction(LR.hospitalization);
croupTr4.addTreatmentAction(LR.parenteralFluidReplacement);
croupTr4.addTreatmentAction(LR.oxygenTherapy);
croupDis.addTreatment("croupTr4");


    // croup sub diseases:
    // -------------- laryngotracheobronchitis ---------------

    Disease laryngotracheobronchitisDis = new Disease(
       LR.laryngotracheobronchitis,
       "croup extended to the bronchi, the branches off the trachea into the lungs",
       LR.respiratoryDisorders,
       LR.moreMale, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge - 3 months in fact
       3, // maxAge
       -3, // duration, less than a week
       -1, // diagnosis frequency, unknown
       LR.tracheaSysSt,
       LR.infection
       );
    laryngotracheobronchitisDis.setSuperDisease(LR.croup);

    laryngotracheobronchitisDis.setTemperature(LR.fever);

    // symptoms:
    laryngotracheobronchitisDis.addSymptom(LR.crackles);
    laryngotracheobronchitisDis.addSymptom(LR.rhonchus);

    laryngotracheobronchitisDis.setMiscComments(
      "symptoms get worse at night; " +
      "inflammation causes edema of the bronchi and bronchioles; " +
      "diffusely decreased breath sounds; " +
      "scattered crackles"
      );

    // references:
    laryngotracheobronchitisDis.addReference("pp 496");

    // -------------- laryngitis ---------------

    Disease laryngitisDis = new Disease(
       LR.laryngitis,
       "croup restricted to the vocal cords",
       LR.respiratoryDisorders,
       LR.moreMale, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge - 3 months in fact
       150, // maxAge
       -3, // duration, less than a week
       -1, // diagnosis frequency, unknown
       LR.larynxSysSt,
       LR.infection
       );
    laryngitisDis.setSuperDisease(LR.croup);

    laryngitisDis.addSymptom(LR.throatSore);
    laryngitisDis.addSymptom(LR.cough);
    laryngitisDis.addInternalCause(LR.flu);

    // references:
    laryngitisDis.addReference("pp 496");
    laryngitisDis.setCode358(250);
    laryngitisDis.setICD10code("J04");
 

    // -------------- epiglottitis ---------------
    Disease epiglottitisDis = new Disease(
       LR.epiglottitis,
       "acute inflammation of the epiglottis that cause airway obstruction",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       2, // minAge - 3 months in fact
       8, // maxAge
       -3, // duration, less than a week
       -1, // diagnosis frequency, unknown
       LR.tracheaSysSt,
       LR.infection
       );

    // causing::
    epiglottitisDis.addExternalCause(LR.haemophilusInfluenzaBInfection);
    epiglottitisDis.addExternalCause(LR.pneumococciInfection);
    epiglottitisDis.addExternalCause(LR.streptococcusInfection);

    epiglottitisDis.setTemperature(LR.highFever);

    // symptoms:
    epiglottitisDis.addSymptom(LR.drooling);
    epiglottitisDis.addSymptom(LR.dysphagia);
    epiglottitisDis.addSymptom(LR.irritability);
    epiglottitisDis.addSymptom(LR.restlessness);
    epiglottitisDis.addSymptom(LR.rhonchus);
    epiglottitisDis.addSymptom(LR.throatSore);
    epiglottitisDis.addSymptom(LR.stridor);

    epiglottitisDis.setMiscComments(
        "Child may hyperextend neck, sit up, lean forward with mouth open, " +
	"tongue protruding, nostrils flaring to facilitate breathing");

    // treatments:
    Treatment epiglottitisTr1 = new Treatment("epiglottitisTr1", LR.ifAcute);
    epiglottitisTr1.addTreatmentAction(LR.hospitalization);
    epiglottitisTr1.addTreatmentAction(LR.endotrachealIntubation);
    epiglottitisTr1.addTreatmentAction(LR.tracheotomy);
    epiglottitisTr1.addDrug(LR.parenteralAntibiotics);
    epiglottitisDis.addTreatment(epiglottitisTr1.getName());

    Treatment epiglottitisTr2 = new Treatment("epiglottitisTr2", LR.ifSwallowingProblem);
    epiglottitisTr2.addTreatmentAction(LR.parenteralFluidAdministration);
    epiglottitisDis.addTreatment(epiglottitisTr2.getName());

    // can cause:

    // references:
    epiglottitisDis.addReference("pp 498-499");

    // -------------- aRFinCOPD ---------------

    Disease aRFinCOPDDis = new Disease(
       LR.aRFinCOPD,
       "acute respiratory failure on top of chronic obstructive pulmonary disease",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge - 3 months in fact
       LR.maxAge, // maxAge
       -2, // duration, less than a day
       -1, // diagnosis frequency, unknown
       LR.respiratorySysSt,
       LR.none // see subdiseases
    );
    aRFinCOPDDis.setPrintName("acute respiratory failure in COPD");

    // set underlying disease  
    aRFinCOPDDis.setUnderlyingDisease(LR.chronicObstructivePulmonaryDisease); 

    // symptoms:

    // treatments:
    Treatment aRFinCOPDTr1 = new Treatment("aRFinCOPDTr1");
    aRFinCOPDTr1.addDrug(LR.antibiotics);
    aRFinCOPDTr1.addDrug(LR.bronchodilator);
    aRFinCOPDTr1.addDrug(LR.steroids);
    aRFinCOPDDis.addTreatment(aRFinCOPDTr1.getName());

    Treatment aRFinCOPDTr2 = new Treatment("aRFinCOPDTr2", 
					   LR.ifSignificantRespiratoryAcidosis);
    aRFinCOPDTr2.addTreatmentAction(LR.mechanicalVentilation);
    aRFinCOPDTr2.addTreatmentAction(LR.endotrachealIntubation);
    aRFinCOPDTr2.addTreatmentAction(LR.tracheotomy);
    aRFinCOPDTr2.addTreatmentAction(LR.hospitalization);
    aRFinCOPDTr2.addTreatmentAction(LR.oxygenTherapy);
    aRFinCOPDDis.addTreatment(aRFinCOPDTr2.getName());

    // references:
    aRFinCOPDDis.addReference("pp 499-501");

    // causing abnormal conditions

    // causes abnormal conditions
    aRFinCOPDDis.addCausesAbnormalCondition(LR.acidosis);
    aRFinCOPDDis.addCausesAbnormalCondition(LR.hypoxemia);

    // subdiseases based on different causes


    // -------------- aRFinCOPDinf ---------------
    Disease aRFinCOPDinfDis = new Disease(
       LR.aRFinCOPDinf,
       "acute respiratory failure on top of chronic obstructive pulmonary disease " +
       "due to respiratory tract infection",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge - 3 months in fact
       LR.maxAge, // maxAge
       -2, // duration, less than a day
       -1, // diagnosis frequency, unknown
       LR.respiratorySysSt,
       LR.infection
    );
    aRFinCOPDinfDis.setPrintName("acute respirarory failure in COPD due to infection");
    // set super disease - if any
    aRFinCOPDinfDis.setSuperDisease(LR.aRFinCOPD);

    // causing:
    // aRFinCOPDinfDis.addInternalCause(LR.bronchitis);
    aRFinCOPDinfDis.addInternalCause(LR.pneumonia);
 
    // symptoms:
    aRFinCOPDinfDis.addSymptom(LR.airHunger);
    aRFinCOPDinfDis.addSymptom(LR.cyanosis);
    aRFinCOPDinfDis.addSymptom(LR.crackles);
    aRFinCOPDinfDis.addSymptom(LR.rhonchus);
    aRFinCOPDinfDis.addSymptom(LR.wheezing);

    // treatments:
    // can cause:
    // references:
    aRFinCOPDinfDis.addReference("pp 499-501");
    // complications: (abnormal conditions)
    aRFinCOPDinfDis.setCode358(278);
    aRFinCOPDinfDis.setICD10code("J80");


    // -------------- aRFinCOPDcns ---------------
    Disease aRFinCOPDcnsDis = new Disease(
       LR.aRFinCOPDcns,
       "acute respiratory failure on top of chronic obstructive pulmonary disease " +
       "due to central nervous system depression",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge - 3 months in fact
       LR.maxAge, // maxAge
       -2, // duration, less than a day
       -1, // diagnosis frequency, unknown
       LR.respiratorySysSt,
       LR.headTrauma
    );
    aRFinCOPDcnsDis.setPrintName("acute respirarory failure in COPD " +
    "due to central nervous system depression");
    // set super disease - if any
    aRFinCOPDcnsDis.setSuperDisease(LR.aRFinCOPD);

    // caused by:
    aRFinCOPDcnsDis.addExternalCause(LR.narcoticsMisuse);
    aRFinCOPDcnsDis.addExternalCause(LR.oxygenMisuse);
    aRFinCOPDcnsDis.addExternalCause(LR.sedativeMisuse);
    aRFinCOPDcnsDis.addExternalCause(LR.tranquilizerMisuse);

    // symptoms:
    aRFinCOPDcnsDis.addSymptom(LR.concentrationLoss);
    aRFinCOPDcnsDis.addSymptom(LR.confusion);
    aRFinCOPDcnsDis.addSymptom(LR.irritability);
    aRFinCOPDcnsDis.addSymptom(LR.papilledema);
    aRFinCOPDcnsDis.addSymptom(LR.restlessness);
    aRFinCOPDcnsDis.addSymptom(LR.tendonReflexDecreased);
    aRFinCOPDcnsDis.addSymptom(LR.trembling);

    // treatments:
    // can cause:
    // references:
    aRFinCOPDcnsDis.addReference("pp 499-501");
// comments:                  Dis.setMiscComments("");
// causing abnormal conditions Dis.addCausingAbnormalCondition(LR.dead);
    aRFinCOPDcnsDis.addCausingAbnormalCondition(LR.centralNervousSystemDepression);

// causes abnormal conditions / complications
//                            Dis.addCausesAbnormalCondition(LR.hypoxemia);
    aRFinCOPDcnsDis.setCode358(278);
    aRFinCOPDcnsDis.setICD10code("J80");


    // -------------- aRFinCOPDcardio ---------------
    Disease aRFinCOPDcardioDis = new Disease(
       LR.aRFinCOPDcardio,
       "acute respiratory failure on top of chronic obstructive pulmonary disease " +
       "due to cardiovascular disorder",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge - 3 months in fact
       LR.maxAge, // maxAge
       -2, // duration, less than a day
       -1, // diagnosis frequency, unknown
       LR.respiratorySysSt,
       LR.none
    );
    aRFinCOPDcardioDis.setPrintName("acute respirarory failure in COPD " +
    "due to cardiovascular disorder");
    // set super disease - if any
    aRFinCOPDcardioDis.setSuperDisease(LR.aRFinCOPD);

    // symptoms:
    aRFinCOPDcardioDis.addSymptom(LR.arrhythmia);
    aRFinCOPDcardioDis.addSymptom(LR.neckVeinsElevated);
    aRFinCOPDcardioDis.addSymptom(LR.liverEnlarged);
    aRFinCOPDcardioDis.addSymptom(LR.edemaPeripheral);
    aRFinCOPDcardioDis.addSymptom(LR.tachycardia);

    // treatments:
    // can cause:
    // references:
    aRFinCOPDcardioDis.addReference("pp 499-501");

    aRFinCOPDcardioDis.addInternalCause(LR.heartFailure);
    aRFinCOPDcardioDis.addInternalCause(LR.myocardialInfarction);
    aRFinCOPDcardioDis.addInternalCause(LR.pulmonaryEmbolism);

    // (abnormal conditions)
    aRFinCOPDcardioDis.addCausingAbnormalCondition(LR.myocardialHypoxia);
    aRFinCOPDcardioDis.setCode358(278);
    aRFinCOPDcardioDis.setICD10code("J80");


// -------------- adultRespiratoryDistressSyndrome --------------
// (C) OntoOO Inc Fri Nov 23 11:48:33 PST 2001
Disease adultRespiratoryDistressSyndromeDis = new Disease(
   LR.adultRespiratoryDistressSyndrome, 
   "adult respiratory distress syndrome", 
   LR.respiratoryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.trauma
);
adultRespiratoryDistressSyndromeDis.setPrintName();

adultRespiratoryDistressSyndromeDis.addSymptom(LR.apprehension, "", 1.0f);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.crackles, "", 1.0f);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.dyspnea, "", 1.0f);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.hypotension, "", 1.0f);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.motorDysfunction, "", 1.0f);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.oliguria, "", 1.0f);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.restlessness, "", 1.0f);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.rhonchus, "", 1.0f);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.sluggishness, "", 1.0f);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.tachycardia, "", 1.0f);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.tachypnea, "", 1.0f);
adultRespiratoryDistressSyndromeDis.addSymptom(LR.ventricularFibrillation, "", 1.0f);

adultRespiratoryDistressSyndromeDis.addExternalCause(LR.aspirationGastricContents);
adultRespiratoryDistressSyndromeDis.addExternalCause(LR.oxygenToxicity);
adultRespiratoryDistressSyndromeDis.addExternalCause(LR.drugOverdose);
adultRespiratoryDistressSyndromeDis.addExternalCause(LR.bloodTransfusion);
adultRespiratoryDistressSyndromeDis.addExternalCause(LR.smokeInhalation);
adultRespiratoryDistressSyndromeDis.addExternalCause(LR.chemicalInhalation);
adultRespiratoryDistressSyndromeDis.addExternalCause(LR.hydrocarbonIngestion);
adultRespiratoryDistressSyndromeDis.addExternalCause(LR.paraquatIngestion);
adultRespiratoryDistressSyndromeDis.addExternalCause(LR.nearDrowning);

adultRespiratoryDistressSyndromeDis.addInternalCause(LR.pancreatitis);
adultRespiratoryDistressSyndromeDis.addInternalCause(LR.pneumonia);
adultRespiratoryDistressSyndromeDis.addInternalCause(LR.tuberculosis);

adultRespiratoryDistressSyndromeDis.addCausingAbnormalCondition(LR.acidosis);
adultRespiratoryDistressSyndromeDis.addCausingAbnormalCondition(LR.microEmboli);
adultRespiratoryDistressSyndromeDis.addCausingAbnormalCondition(LR.sepsis);
adultRespiratoryDistressSyndromeDis.addCausingAbnormalCondition(LR.shock);
adultRespiratoryDistressSyndromeDis.addCausingAbnormalCondition(LR.uremia);

adultRespiratoryDistressSyndromeDis.addCausesAbnormalCondition(LR.hypoxemia);
adultRespiratoryDistressSyndromeDis.addReference("pp 501-4");

Treatment ARDSTr1 = new Treatment("ARDSTr1");
ARDSTr1.addTreatmentAction(LR.humidifiedOxygen);
adultRespiratoryDistressSyndromeDis.addTreatment("ARDSTr1");
Treatment ARDSTr2 = new Treatment("ARDSTr2", LR.ifSevere);
ARDSTr2.addTreatmentAction(LR.intubation);
ARDSTr2.addTreatmentAction(LR.volumeVentilation);
ARDSTr2.addTreatmentAction(LR.fluidRestriction);
ARDSTr2.addDrug(LR.diuretics);
adultRespiratoryDistressSyndromeDis.addTreatment("ARDSTr2");
Treatment ARDSTr3 = new Treatment("ARDSTr3", LR.ifMechanicalVentilation);
ARDSTr3.addDrug(LR.sedatives);
ARDSTr3.addDrug(LR.narcotics);
ARDSTr3.addDrug(LR.tubocurarine);
ARDSTr3.addDrug(LR.pancuroniumBromide);
adultRespiratoryDistressSyndromeDis.addTreatment("ARDSTr3");
Treatment ARDSTr4 = new Treatment("ARDSTr4", LR.ifSevereAcidosis);
ARDSTr4.addDrug(LR.sodiumBicarbonate);
adultRespiratoryDistressSyndromeDis.addTreatment("ARDSTr4");
Treatment ARDSTr5 = new Treatment("ARDSTr5", LR.ifInfection);
ARDSTr5.addDrug(LR.antimicrobials);
adultRespiratoryDistressSyndromeDis.addTreatment("ARDSTr5");


    // -------------- pulmonaryEdema ---------------
    Disease pulmonaryEdemaDis = new Disease(
       LR.pulmonaryEdema,
       "pulmonary edema",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge 
       LR.maxAge, // maxAge
       -11, // duration, less than a week
       -1, // diagnosis frequency, unknown
       LR.lungsSysSt,
       LR.none
       );

    // set printName              Dis.setPrintName("");
    pulmonaryEdemaDis.setPrintName();

    // set super disease          Dis.setSuperDisease(LR.aRFinCOPD);
    // set underlying disease     Dis.setUnderlyingDisease(LR.COPD);

    // caused by:                 Dis.addExternalCause()
    pulmonaryEdemaDis.addExternalCause(LR.excessiveIVFluids);

    // symptoms:                  Dis.addSymptom(LR.airHunger);
    pulmonaryEdemaDis.addSymptom(LR.confusion);
    pulmonaryEdemaDis.addSymptom(LR.cough);
    pulmonaryEdemaDis.addSymptom(LR.cyanosis);
    pulmonaryEdemaDis.addSymptom(LR.dyspnea);
    pulmonaryEdemaDis.addSymptom(LR.neckVeinsElevated);
    pulmonaryEdemaDis.addSymptom(LR.orthopnea);
    pulmonaryEdemaDis.addSymptom(LR.skinClammy);
    pulmonaryEdemaDis.addSymptom(LR.hemoptysis);
    pulmonaryEdemaDis.addSymptom(LR.sputumFrothy);
    pulmonaryEdemaDis.addSymptom(LR.tachycardia);
    pulmonaryEdemaDis.addSymptom(LR.tachypnea);

    // causing:                   Dis.addInternalCause(LR.pneumonia);
    // can cause:                 Dis.addCausesDisease(LR.lungAbscess);
    // references:                
    pulmonaryEdemaDis.addReference("pp 504-5");

    // comments:                  Dis.setMiscComments("");
    pulmonaryEdemaDis.setMiscComments(
	   "It can occur as a chronic condition or " +
	   "develop quickly and rapidly become fatal");

    // causing abnormal conditions Dis.addCausingAbnormalCondition(LR.dead);
    pulmonaryEdemaDis.addInternalCause(LR.heartFailureLeftSided);
    pulmonaryEdemaDis.addInternalCause(LR.aortaInsufficiency); 
    pulmonaryEdemaDis.addInternalCause(LR.hypertension);

    // causes abnormal conditions / complications
    //                            Dis.addCausesAbnormalCondition(LR.hypoxemia);
    // treatments:
    Treatment pulmonaryEdemaTr1 = new Treatment("pulmonaryEdemaTr1");
    pulmonaryEdemaTr1.addTreatmentAction(LR.oxygenTherapy);
    pulmonaryEdemaTr1.addTreatmentAction(LR.mechanicalVentilation);
    pulmonaryEdemaDis.addTreatment(pulmonaryEdemaTr1.getName());

    Treatment pulmonaryEdemaTr2 = new Treatment("pulmonaryEdemaTr2");
    pulmonaryEdemaTr2.addDrug(LR.diuretics);
    pulmonaryEdemaDis.addTreatment(pulmonaryEdemaTr2.getName());

    Treatment pulmonaryEdemaTr3 = new Treatment("pulmonaryEdemaTr3");
    pulmonaryEdemaTr3.addDrug(LR.morphine);
    pulmonaryEdemaDis.addTreatment(pulmonaryEdemaTr3.getName());



    // -------------- pulmonaryEdemaAcute ---------------
    Disease pulmonaryEdemaAcuteDis = new Disease(
       LR.pulmonaryEdemaAcute,
       "pulmonary edema acute",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge 
       LR.maxAge, // maxAge
       0, // duration, less than a week
       -1, // diagnosis frequency, unknown
       LR.lungsSysSt,
       LR.none
       );

    // set printName              Dis.setPrintName("");
    pulmonaryEdemaAcuteDis.setPrintName();

    // set super disease          Dis.setSuperDisease(LR.aRFinCOPD);
    pulmonaryEdemaAcuteDis.setSuperDisease(LR.pulmonaryEdema);

    // set underlying disease     Dis.setUnderlyingDisease(LR.COPD);

    // caused by:                 Dis.addExternalCause()
    pulmonaryEdemaAcuteDis.addExternalCause(LR.excessiveIVFluids);

    // symptoms:                  Dis.addSymptom(LR.airHunger);
    pulmonaryEdemaAcuteDis.addSymptom(LR.crackles);
    pulmonaryEdemaAcuteDis.addSymptom(LR.diastolicGallop);
    pulmonaryEdemaAcuteDis.addSymptom(LR.skinCold);

    // treatments:

    Treatment pulmonaryEdemaAcuteTr1 = new Treatment("pulmonaryEdemaAcuteTr1");
    pulmonaryEdemaAcuteTr1.addDrug(LR.digitalisGlycosides);
    pulmonaryEdemaAcuteTr1.addDrug(LR.antiArrhythemics);
    pulmonaryEdemaAcuteTr1.addDrug(LR.vasodilators);
    pulmonaryEdemaAcuteDis.addTreatment(pulmonaryEdemaAcuteTr1.getName());


    // causing:                   Dis.addInternalCause(LR.pneumonia);
    // can cause:                 Dis.addCausesDisease(LR.lungAbscess);
    // references:                
    pulmonaryEdemaAcuteDis.addReference("pp 504-5");

    // comments:                  Dis.setMiscComments("");

    // causing abnormal conditions Dis.addCausingAbnormalCondition(LR.dead);

    // causes abnormal conditions / complications
    //                            Dis.addCausesAbnormalCondition(LR.hypoxemia);

    // -------------- pulmonaryEdemaChronic ---------------
    Disease pulmonaryEdemaChronicDis = new Disease(
       LR.pulmonaryEdemaChronic,
       "pulmonary edema chronic",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge 
       LR.maxAge, // maxAge
       -1, // duration, chronic
       -1, // diagnosis frequency, unknown
       LR.lungsSysSt,
       LR.none
       );

    // set printName              Dis.setPrintName("");
    pulmonaryEdemaChronicDis.setPrintName();

    // set super disease          Dis.setSuperDisease(LR.aRFinCOPD);
    pulmonaryEdemaChronicDis.setSuperDisease(LR.pulmonaryEdema);

    // set underlying disease     Dis.setUnderlyingDisease(LR.COPD);

    // caused by:                 Dis.addExternalCause()
    pulmonaryEdemaChronicDis.addExternalCause(LR.excessiveIVFluids);

    // symptoms:                  Dis.addSymptom(LR.airHunger);
    pulmonaryEdemaChronicDis.addSymptom(LR.hypotension);
    pulmonaryEdemaChronicDis.addSymptom(LR.respirationLabored);
    pulmonaryEdemaChronicDis.addSymptom(LR.tachypnea);
    pulmonaryEdemaChronicDis.addSymptom(LR.diaphoresis);

    // treatments:

    Treatment pulmonaryEdemaChronicTr1 = new Treatment("pulmonaryEdemaChronicTr1");
    pulmonaryEdemaChronicTr1.addDrug(LR.furosemide);
    pulmonaryEdemaChronicTr1.addDrug(LR.bumetanide);
    pulmonaryEdemaChronicDis.addTreatment(pulmonaryEdemaChronicTr1.getName());


    // causing:                   Dis.addInternalCause(LR.pneumonia);
    // can cause:                 Dis.addCausesDisease(LR.lungAbscess);
    // references:                
    pulmonaryEdemaChronicDis.addReference("pp 504-5");

    // comments:                  Dis.setMiscComments("");

    // causing abnormal conditions Dis.addCausingAbnormalCondition(LR.dead);

    // causes abnormal conditions / complications
    //                            Dis.addCausesAbnormalCondition(LR.hypoxemia);


    // -------------- corPulmonale ---------------
    // see InitCardioDiseases

    // -------------- legionaire ---------------
    Disease legionaireDis = new Disease(
       LR.legionaire,
       "acute broncho pneumonia",
       LR.respiratoryDisorders,
       LR.moreMale, // genderSpecificity
       LR.none, // raceSpecificity
       40, // minAge - 3 months in fact
       LR.maxAge, // maxAge 
       -4, // duration, less than a month (can be dead also)
       F.legionaireFreq,
       LR.lungsSysSt,
       LR.infection
       );

    // set printName              Dis.setPrintName("");
    legionaireDis.setPrintName("legionaire disease");

    // set super disease          Dis.setSuperDisease(LR.aRFinCOPD);
    // set underlying disease     Dis.setUnderlyingDisease(LR.COPD); 

    // caused by:                 Dis.addExternalCause(...)
    legionaireDis.addExternalCause(LR.legionellaPneumophiliaBacillus);

    legionaireDis.setTemperature(LR.veryHighFever);

    // symptoms:                  Dis.addSymptom(LR.airHunger);
    legionaireDis.addSymptom(LR.amnesia);
    legionaireDis.addSymptom(LR.anorexia);
    legionaireDis.addSymptom(LR.arrhythmia);
    legionaireDis.addSymptom(LR.bradycardia);
    legionaireDis.addSymptom(LR.chills);
    legionaireDis.addSymptom(LR.confusion);
    legionaireDis.addSymptom(LR.cough);
    legionaireDis.addSymptom(LR.crackles);
    legionaireDis.addSymptom(LR.delirium);
    legionaireDis.addSymptom(LR.diarrhea);
    legionaireDis.addSymptom(LR.disorientation);
    legionaireDis.addSymptom(LR.dyspnea);
    legionaireDis.addSymptom(LR.headache);
    legionaireDis.addSymptom(LR.hypotension);
    legionaireDis.addSymptom(LR.malaise);
    legionaireDis.addSymptom(LR.myalgia);
    legionaireDis.addSymptom(LR.nausea);
    legionaireDis.addSymptom(LR.pleuriticChestPain);
    legionaireDis.addSymptom(LR.sluggishness);
    legionaireDis.addSymptom(LR.hemoptysis);
    legionaireDis.addSymptom(LR.sputumGray);
    legionaireDis.addSymptom(LR.tachypnea);
    legionaireDis.addSymptom(LR.vomiting);
    legionaireDis.addSymptom(LR.weakness);

    // treatments:
    Treatment legionaireTr1 = new Treatment("legionaireTr1");
    legionaireTr1.addDrug(LR.antibiotics);
    legionaireTr1.addDrug(LR.erythromycin);
    legionaireTr1.addDrug(LR.rifampin);
    legionaireTr1.addDrug(LR.tetracycline);
    legionaireDis.addTreatment(legionaireTr1.getName());

    Treatment legionaireTr2 = new Treatment("legionaireTr2");
    legionaireTr2.addTreatmentAction(LR.ifFeverProvideAntipyretic);
    legionaireTr2.addTreatmentAction(LR.parenteralFluidReplacement);
    legionaireTr2.addTreatmentAction(LR.oxygenTherapy);
    legionaireDis.addTreatment(legionaireTr2.getName());

    // causing:                   Dis.addInternalCause(LR.pneumonia);
    // can cause:                 Dis.addCausesDisease(LR.lungAbscess);
    // references:                Dis.addReference("pp 508-9");
    legionaireDis.addReference("pp 508-9");

    // comments:                  Dis.setMiscComments("");
    legionaireDis.setMiscComments(
        "vulnerable conditions: " +
	"immunocompromised, chronic diabetes, renal failure, COPD, " +
	"alcoholism, cigarette smoking; 15% mortality");

    // causing abnormal conditions Dis.addCausingAbnormalCondition(LR.dead);
    // causes abnormal conditions / complications
    //                            Dis.addCausesAbnormalCondition(LR.hypoxemia);
    legionaireDis.addCausesDisease(LR.heartFailure);
    legionaireDis.addCausesDisease(LR.renalInfarction);

    legionaireDis.addCausesAbnormalCondition(LR.hypoxia);
    legionaireDis.addCausesAbnormalCondition(LR.respiratoryFailure);
    legionaireDis.addCausesAbnormalCondition(LR.shock);


    // -------------- atelectasis ---------------
    Disease atelectasisDis = new Disease(
       LR.atelectasis,
       "atelectasis is incomplete expansion of lobules or lung segments",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge - 3 months in fact
       LR.maxAge, // maxAge
       -10, // duration, chronic or acute
       -1, // diagnosis frequency, unknown
       LR.lungsSysSt,
       LR.trauma
       );

// set printName              Dis.setPrintName("");
// set super disease          Dis.setSuperDisease(LR.aRFinCOPD);
// set underlying disease     Dis.setUnderlyingDisease(LR.COPD); 

    // caused by:                 Dis.addExternalCause(...)
    atelectasisDis.addExternalCause(LR.oxygenToxicity);
    atelectasisDis.addExternalCause(LR.tightChessBandage);

// temperature                Dis.setTemperature(LR.highFever);

    // symptoms:                  Dis.addSymptom(LR.airHunger);
    atelectasisDis.addSymptom(LR.dyspnea);
    atelectasisDis.addSymptom(LR.anxiety);
    atelectasisDis.addSymptom(LR.cyanosis);
    atelectasisDis.addSymptom(LR.diaphoresis);

    // treatments:
    Treatment atelectasisTr1 = new Treatment("atelectasisTr1");
    atelectasisTr1.addTreatmentAction(LR.coughingExercise);
    atelectasisTr1.addTreatmentAction(LR.deepBreathingExercise);
    atelectasisDis.addTreatment(atelectasisTr1.getName());

    Treatment atelectasisTr2 = new Treatment("atelectasisTr2");
    atelectasisTr2.addDrug(LR.mucolytics);
    atelectasisTr2.addTreatmentAction(LR.chestPercussion);
    atelectasisTr2.addTreatmentAction(LR.posturalDrainage);
    atelectasisTr2.addTreatmentAction(LR.bronchoscopy);
    atelectasisDis.addTreatment(atelectasisTr2.getName());

    Treatment atelectasisTr3 = new Treatment("atelectasisTr1", LR.ifObstructingNeoplasm);
    atelectasisTr3.addTreatmentAction(LR.surgery);
    atelectasisTr3.addTreatmentAction(LR.radiationTherapy);
    atelectasisDis.addTreatment(atelectasisTr3.getName());

    // causing:                   Dis.addInternalCause(LR.pneumonia);
    atelectasisDis.addInternalCause(LR.lungCancer);
    atelectasisDis.addInternalCause(LR.respiratoryDistressSyndrome);
    // atelectasisDis.addInternalCause(LR.inflammatoryLungDisease);
    atelectasisDis.addInternalCause(LR.pulmonaryEdema);
    atelectasisDis.addInternalCause(LR.cysticFibrosis);
    atelectasisDis.addInternalCause(LR.obesity);

   // can cause:                  Dis.addCausesDisease(LR.lungAbscess);

    // references:                Dis.addReference("pp 501-4");
    atelectasisDis.addReference("pp 510-11");

    // comments:                  Dis.setMiscComments("");

      // causing abnormal conditions Dis.addCausingAbnormalCondition(LR.dead);
    atelectasisDis.addCausingAbnormalCondition(LR.bronchialMucusPlugs);
    atelectasisDis.addCausingAbnormalCondition(LR.centralNervousSystemDepression);
    // atelectasisDis.addCausingAbnormalCondition(LR.obesity);
    atelectasisDis.addCausingAbnormalCondition(LR.ribFracture);

    // causes abnormal conditions / complications
    //                            Dis.addCausesAbnormalCondition(LR.hypoxemia);
    atelectasisDis.addCausesAbnormalCondition(LR.hypoxemia);


    // -------------- respiratory acidosis ---------------
// (C) OntoOO Inc Thu Jul 19 13:14:23 PDT 2001
Disease respiratoryAcidosisDis = new Disease(
   LR.respiratoryAcidosis, 
   "An acid-base disturbance due to reduced alveolar ventilation in the lungs", 
   LR.respiratoryDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.respiratorySysSt, 
   LR.anestheticsUse
);
respiratoryAcidosisDis.setPrintName("respiratory acidosis");

respiratoryAcidosisDis.addSymptom(LR.arrhythmia);
respiratoryAcidosisDis.addSymptom(LR.asterixis);
respiratoryAcidosisDis.addSymptom(LR.apprehension);
respiratoryAcidosisDis.addSymptom(LR.coma);
respiratoryAcidosisDis.addSymptom(LR.confusion);
respiratoryAcidosisDis.addSymptom(LR.dyspnea);
respiratoryAcidosisDis.addSymptom(LR.headache);
respiratoryAcidosisDis.addSymptom(LR.papilledema);
respiratoryAcidosisDis.addSymptom(LR.reflexesDecreased);
respiratoryAcidosisDis.addSymptom(LR.restlessness);
respiratoryAcidosisDis.addSymptom(LR.somnolence);
respiratoryAcidosisDis.addSymptom(LR.tachycardia);
respiratoryAcidosisDis.addSymptom(LR.tachypnea);
respiratoryAcidosisDis.addSymptom(LR.vasodilation);

respiratoryAcidosisDis.addExternalCause(LR.hypnoticsUse);
respiratoryAcidosisDis.addExternalCause(LR.narcoticsMisuse);
respiratoryAcidosisDis.addExternalCause(LR.sedativesUse);

respiratoryAcidosisDis.addInternalCause(LR.adultRespiratoryDistressSyndrome);
respiratoryAcidosisDis.addInternalCause(LR.asthma);
respiratoryAcidosisDis.addInternalCause(LR.chronicBronchitis);
respiratoryAcidosisDis.addInternalCause(LR.chronicObstructivePulmonaryDisease);
respiratoryAcidosisDis.addInternalCause(LR.guillainBarreSyndrome);
respiratoryAcidosisDis.addInternalCause(LR.pneumonia);
respiratoryAcidosisDis.addInternalCause(LR.myastheniaGravis);
respiratoryAcidosisDis.addInternalCause(LR.poliomyelitis);
respiratoryAcidosisDis.addInternalCause(LR.pulmonaryEdema);

respiratoryAcidosisDis.addCausingAbnormalCondition(LR.airwayObstruction);
respiratoryAcidosisDis.addCausingAbnormalCondition(LR.centralNervousSystemDepression);

respiratoryAcidosisDis.addReference("pp 511-3");
respiratoryAcidosisDis.setMiscComments(
   "prognosis depends on severity of underlying disturbance " +
   "and the general clinical condition");

Treatment respiratoryAcidosisTr1  = 
  new Treatment("respiratoryAcidosisTr1", LR.ifSevereAcidosis);
respiratoryAcidosisTr1.addTreatmentAction(LR.mechanicalVentilation);
respiratoryAcidosisTr1.addTreatmentAction(LR.oxygenTherapy);
respiratoryAcidosisTr1.addTreatmentAction(LR.dialysis);
respiratoryAcidosisTr1.addDrug(LR.antibiotics);
respiratoryAcidosisTr1.addDrug(LR.bronchodilator);
respiratoryAcidosisTr1.addDrug(LR.corticosteroids);
respiratoryAcidosisDis.addTreatment(respiratoryAcidosisTr1.getName());


    // -------------- respiratoryAlkalosis ---------------

// (C) OntoOO Inc Mon Jul 30 15:10:13 PDT 2001
Disease respiratoryAlkalosisDis = new Disease(
   LR.respiratoryAlkalosis, 
   "acid-base disturbance due to hyperventilation", 
   LR.respiratoryDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.respiratorySysSt, 
   LR.aspirinToxicity
);
respiratoryAlkalosisDis.setPrintName("respiratory alkalosis");

respiratoryAlkalosisDis.setTemperature((float)100.0);

respiratoryAlkalosisDis.addSymptom(LR.agitation, "", 1.0f);
respiratoryAlkalosisDis.addSymptom(LR.anxiety, "", 1.0f);
respiratoryAlkalosisDis.addSymptom(LR.arrhythmia, "", 1.0f);
respiratoryAlkalosisDis.addSymptom(LR.dizziness, "", 1.0f);
respiratoryAlkalosisDis.addSymptom(LR.hyperventilation, "", 1.0f);
respiratoryAlkalosisDis.addSymptom(LR.lightHeadedness, "", 1.0f);
respiratoryAlkalosisDis.addSymptom(LR.muscleWeakness, "", 1.0f);
respiratoryAlkalosisDis.addSymptom(LR.paresthesia);
respiratoryAlkalosisDis.addSymptom(LR.seizure, "", 1.0f);
respiratoryAlkalosisDis.addSymptom(LR.spasm, "", 1.0f);
respiratoryAlkalosisDis.addSymptom(LR.twitching);

respiratoryAlkalosisDis.addInternalCause(LR.asthma);
respiratoryAlkalosisDis.addInternalCause(LR.idiopathicPulmonaryFibrosis);
respiratoryAlkalosisDis.addInternalCause(LR.pneumonia);
// respiratoryAlkalosisDis.addInternalCause(LR.pulmonaryVascularDisease);

respiratoryAlkalosisDis.addCausingAbnormalCondition(LR.hepaticFailure);
respiratoryAlkalosisDis.addCausingAbnormalCondition(LR.hypoxemia);
respiratoryAlkalosisDis.addCausingAbnormalCondition(LR.sepsis);
respiratoryAlkalosisDis.addReference("pp 513");

Treatment respiratoryAlkalosisTr1  = new Treatment("respiratoryAlkalosisTr1", 
						   LR.ifSevereAnxiety);
respiratoryAlkalosisTr1.addTreatmentAction(LR.breathIntoPaperBag);
respiratoryAlkalosisDis.addTreatment(respiratoryAlkalosisTr1.getName());

Treatment respiratoryAlkalosisTr2  = new Treatment("respiratoryAlkalosisTr2", 
						   LR.ifAcuteHypoxemia);
respiratoryAlkalosisTr2.addTreatmentAction(LR.oxygenTherapy);
respiratoryAlkalosisDis.addTreatment(respiratoryAlkalosisTr2.getName());

/*
    // -------------- pulmonaryVascularDisease ---------------
// (C) OntoOO Inc Fri Jul 27 17:12:45 PDT 2001
Disease pulmonaryVascularDiseaseDis = new Disease(
   LR.pulmonaryVascularDisease, 
   "problem with the veins in the lungs", 
   LR.respiratoryDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.none
);
pulmonaryVascularDiseaseDis.setPrintName("pulmonary vascular disease");
pulmonaryVascularDiseaseDis.setMiscComments("** temp entry");
pulmonaryVascularDiseaseDis.setWebResource(
     "http://blue.temple.edu/~pathphys/pulmonary/pulmonary_vascular_disease.html");
*/

    // -------------- pneumothorax ---------------
// (C) OntoOO Inc Wed Aug 01 13:10:17 PDT 2001
Disease pneumothoraxDis = new Disease(
   LR.pneumothorax, 
   "accumulation of air inside the body but outside the lungs " +
   "that can cause a lung to collapse", 
   LR.respiratoryDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.trauma
);

pneumothoraxDis.addSymptom(LR.anxiety);
pneumothoraxDis.addSymptom(LR.breathingAsymmetric);
pneumothoraxDis.addSymptom(LR.dyspnea);
pneumothoraxDis.addSymptom(LR.neckVeinsElevated);
pneumothoraxDis.addSymptom(LR.pallor);
pneumothoraxDis.addSymptom(LR.pleuriticChestPain);
pneumothoraxDis.addSymptom(LR.pulseRapid);
pneumothoraxDis.addSymptom(LR.pulseWeak);
pneumothoraxDis.addSymptom(LR.dyspnea);

pneumothoraxDis.addInternalCause(LR.berylliosisChronic);
pneumothoraxDis.addInternalCause(LR.idiopathicPulmonaryFibrosis);

pneumothoraxDis.addCausingAbnormalCondition(LR.pleuralSpaceRupture);

pneumothoraxDis.addCausesAbnormalCondition(LR.circulatoryFailure);
pneumothoraxDis.addCausesAbnormalCondition(LR.pulmonaryFailure);

pneumothoraxDis.addReference("pp 513-5");
pneumothoraxDis.setMiscComments(
        "a large pneumothorax can become rapidly fatal without treatment ");

Treatment pneumothoraxTr1  = new Treatment("pneumothoraxTr1", LR.ifModerate);
pneumothoraxTr1.addTreatmentAction(LR.bedRest);
pneumothoraxTr1.addTreatmentAction(LR.oxygenTherapy);
pneumothoraxDis.addTreatment(pneumothoraxTr1.getName());

Treatment pneumothoraxTr2  = new Treatment("pneumothoraxTr2", LR.ifSevere);
pneumothoraxTr2.addTreatmentAction(LR.chestTubeDrainage);
pneumothoraxTr2.addTreatmentAction(LR.surgery);
pneumothoraxDis.addTreatment(pneumothoraxTr2.getName());


    // -------------- pneumonia ---------------
    Disease pneumoniaDis = new Disease(
       LR.pneumonia,
       "pneumonia = inflammation of the lungs",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge 
       LR.maxAge, // maxAge
       -3, // duration, less than a week
       -1, // diagnosis frequency, unknown
       LR.lungsSysSt,
       LR.infection
       );

    // caused by:  see the sub variants

    pneumoniaDis.setTemperature(LR.fever);

    // symptoms:
    pneumoniaDis.addSymptom(LR.chills);
    pneumoniaDis.addSymptom(LR.cough);
    pneumoniaDis.addSymptom(LR.crackles);
    pneumoniaDis.addSymptom(LR.pleuriticChestPain);
    pneumoniaDis.addSymptom(LR.shaking);
    pneumoniaDis.addSymptom(LR.sputumProduction);


    // treatments: nothing specific here/ see specializations

    pneumoniaDis.setMiscComments(
	"Prognosis is good provided before the onset " +
	"the lungs are OK and host defenses are adequate; " +
	"pneumonia is the 6th cause of death in the US; " +
	"pneumonia is a 'super' disease with a number of variants " +
	"distinguished by the causing infection");

    // references:
    pneumoniaDis.addReference("pp 515-520");

    pneumoniaDis.addInternalCause(LR.croup);

    // complications:
    pneumoniaDis.addCausesAbnormalCondition(LR.empyema);
    pneumoniaDis.addCausesAbnormalCondition(LR.hypoxemia);
    pneumoniaDis.addCausesAbnormalCondition(LR.pleuralEffusion);
    pneumoniaDis.addCausesAbnormalCondition(LR.respiratoryFailure);

    // can cause:
    pneumoniaDis.addCausesDisease(LR.endocarditis);
    pneumoniaDis.addCausesDisease(LR.lungAbscess);
    pneumoniaDis.addCausesDisease(LR.meningitis);
    pneumoniaDis.addCausesDisease(LR.pericarditis);

    // add here pneumonia sub diseases


    // -------------- pneumoniaAcute ---------------
// (C) OntoOO Inc Mon Oct 22 15:29:17 PDT 2001
Disease pneumoniaAcuteDis = new Disease(
   LR.pneumoniaAcute, 
   "sudden inflammation of the lungs", 
   LR.respiratoryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.infection
);
pneumoniaAcuteDis.setPrintName("pneumonia acute");
pneumoniaAcuteDis.setSuperDisease(LR.pneumonia);
pneumoniaAcuteDis.setTemperature(LR.fever);
pneumoniaAcuteDis.addSymptom(LR.breathingDifficult);
pneumoniaAcuteDis.addSymptom(LR.cheeksFlushed);
// pneumoniaAcuteDis.addSymptom(LR.chills); ... in super
pneumoniaAcuteDis.addSymptom(LR.feverSym);
pneumoniaAcuteDis.addSymptom(LR.sweating, "", 0.3f);
pneumoniaAcuteDis.addSymptom(LR.throatSore);
pneumoniaAcuteDis.addSymptom(LR.wheezing);
pneumoniaAcuteDis.addReference("pp 515-20");

Treatment pneumoniaAcuteTr1 = new Treatment("pneumoniaAcuteTr1");
pneumoniaAcuteTr1.addTreatmentAction(LR.bedRest);
pneumoniaAcuteTr1.addTreatmentAction(LR.fluidIncrease);
pneumoniaAcuteTr1.addTreatmentAction(LR.mechanicalVentilation);
pneumoniaAcuteTr1.addTreatmentAction(LR.oxygenTherapy);
pneumoniaAcuteTr1.addDrug(LR.analgetics);
pneumoniaAcuteTr1.addDrug(LR.antibiotics);
pneumoniaAcuteDis.addTreatment(pneumoniaAcuteTr1.getName()); 


    // -------------- influenza ---------------
    Disease influenzaDis = new Disease(
       LR.influenza,
       "influenza = pneumonia caused by viral infection",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge 
       LR.maxAge, // maxAge
       -3, // duration, less than a week
       -1, // diagnosis frequency, unknown
       LR.lungsSysSt,
       LR.infection
       );
    influenzaDis.setSuperDisease(LR.pneumonia);

    influenzaDis.setTemperature(LR.highFever);

    // symptoms:
    influenzaDis.addSymptom(LR.anorexia);
    influenzaDis.addSymptom(LR.cyanosis);
    influenzaDis.addSymptom(LR.dyspnea);
    influenzaDis.addSymptom(LR.fatigue);
    influenzaDis.addSymptom(LR.feverSym);
    influenzaDis.addSymptom(LR.headacheFrontal);
    influenzaDis.addSymptom(LR.malaise);
    influenzaDis.addSymptom(LR.myalgia);
    influenzaDis.addSymptom(LR.throatSore);

    // caused by:                 Dis.addExternalCause(...)
    influenzaDis.addExternalCause(LR.influenzaVirusInfection);


    influenzaDis.setMiscComments(
	"Death results from cardiopulmonary collapse");

    // treatments:
    Treatment influenzaTr1 = new Treatment("influenzaTr1");
    influenzaTr1.addTreatmentAction(LR.ifFeverProvideAntipyretic);
    // influenzaTr1.addTreatmentAction(LR.ifRespiratoryFailureIntubation);
    // influenzaTr1.addDrug(LR.ifInfluenzaAamantadine);
    influenzaDis.addTreatment(influenzaTr1.getName());

    Treatment influenzaTr2 = new Treatment("influenzaTr2", LR.ifRespiratoryFailure);
    influenzaTr2.addTreatmentAction(LR.endotrachealIntubation);
    influenzaTr2.addTreatmentAction(LR.mechanicalVentilation);
    influenzaDis.addTreatment(influenzaTr2.getName());

    Treatment influenzaTr3 = new Treatment("influenzaTr3", LR.ifInfluenzaA);
    influenzaTr3.addDrug(LR.amantadine);
    influenzaTr3.addDrug(LR.rimantadine);
    influenzaDis.addTreatment(influenzaTr3.getName());

    // references:
    influenzaDis.addReference("pp 516-7");
    influenzaDis.setCode358(253);
    influenzaDis.setICD10code("J10");


    // -------------- pneumoniaAdenoVirus ---------------
    Disease pneumoniaAdenoVirusDis = new Disease(
       LR.pneumoniaAdenoVirus,
       "pneumonia caused by adeno viral infection",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge 
       30, // maxAge
       -3, // duration, less than a week
       -1, // diagnosis frequency, unknown
       LR.lungsSysSt,
       LR.infection
       );
    pneumoniaAdenoVirusDis.setSuperDisease(LR.pneumonia);
    pneumoniaAdenoVirusDis.setPrintName("pneumonia by adeno virus");

    // caused by:                 Dis.addExternalCause(...)
    pneumoniaAdenoVirusDis.addExternalCause(LR.adenoVirusInfection);

    // symptoms:
pneumoniaAdenoVirusDis.addSymptom(LR.anorexia, "", 0.5f);
pneumoniaAdenoVirusDis.addSymptom(LR.retrosternalChestPain, "", 0.5f);
pneumoniaAdenoVirusDis.addSymptom(LR.throatSore, "", 1.0f);
pneumoniaAdenoVirusDis.addSymptom(LR.sputumMucoid, "", 1.0f);

    // treatments:
    // no treatments ...

    // references:
    pneumoniaAdenoVirusDis.addReference("pp 516-517");
pneumoniaAdenoVirusDis.setCode358(255);
pneumoniaAdenoVirusDis.setICD10code("J12");


    // -------------- pneumoniaSyncytialVirus ---------------
    Disease pneumoniaSyncytialVirusDis = new Disease(
       LR.pneumoniaSyncytialVirus,
       "pneumonia caused by syncytial viral infection",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge 
       10, // maxAge
       -4, // duration, less than a month
       -1, // diagnosis frequency, unknown
       LR.lungsSysSt,
       LR.infection
       );
    pneumoniaSyncytialVirusDis.setSuperDisease(LR.pneumonia);
    pneumoniaSyncytialVirusDis.setPrintName("pneumonia by syncytial virus");

    // symptoms:
    pneumoniaSyncytialVirusDis.addSymptom(LR.irritability);
    pneumoniaSyncytialVirusDis.addSymptom(LR.listlessness);
    pneumoniaSyncytialVirusDis.addSymptom(LR.severeMalaise);
    pneumoniaSyncytialVirusDis.addSymptom(LR.tachypnea);

    // caused by:                 Dis.addExternalCause(...)
    pneumoniaSyncytialVirusDis.addExternalCause(LR.syncytialVirusInfection);

    // treatments:
    Treatment pneumoniaSyncytialVirusTr1 = new Treatment("pneumoniaSyncytialVirusTr1");
    pneumoniaSyncytialVirusTr1.addTreatmentAction(LR.humidifiedAir);
    pneumoniaSyncytialVirusTr1.addTreatmentAction(LR.oxygenTherapy);
    pneumoniaSyncytialVirusTr1.addDrug(LR.ribavirin);
    pneumoniaSyncytialVirusTr1.addDrug(LR.antimicrobials);
    pneumoniaSyncytialVirusDis.addTreatment(pneumoniaSyncytialVirusTr1.getName());

    // references:
    pneumoniaSyncytialVirusDis.addReference("pp 516-517");
pneumoniaSyncytialVirusDis.setCode358(255);
pneumoniaSyncytialVirusDis.setICD10code("J12");


    // --------------  measles ---------------
    Disease measlesDis = new Disease(
       LR.measles,
       "pneumonia caused by measles viral infection",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge 
       LR.maxAge, // maxAge ??
       -4, // duration, less than a month ??
       F.measlesFreq,
       LR.lungsSysSt,
       LR.infection
       );
    measlesDis.setSuperDisease(LR.pneumonia);

    // caused by:                 Dis.addExternalCause(...)
    measlesDis.addExternalCause(LR.measlesVirusInfection); //  ??

    // symptoms:
    measlesDis.addSymptom(LR.coryza);
    measlesDis.addSymptom(LR.dyspnea);
    measlesDis.addSymptom(LR.lymphadenopathy);
    measlesDis.addSymptom(LR.rash);

    // treatments:
    Treatment measlesTr1 = new Treatment("measlesTr1");
    measlesTr1.addTreatmentAction(LR.bedRest);
    measlesTr1.addTreatmentAction(LR.hydration);
    measlesTr1.addDrug(LR.antimicrobials);
    measlesTr1.addTreatmentAction(LR.mechanicalVentilation);
    measlesDis.addTreatment(measlesTr1.getName());

    // references:
    measlesDis.addReference("pp 516-517");
    measlesDis.setCode358(45);
    measlesDis.setICD10code("B05");


    // --------------  chickenpox ---------------
    Disease chickenpoxDis = new Disease(
       LR.chickenpox,
       "pneumonia caused by chickenpox viral infection",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge 
       LR.maxAge, // maxAge ??
       -4, // duration, less than a month ??
       F.chickenpoxFreq,
       LR.lungsSysSt,
       LR.herpesvirusVaricella
       );
    chickenpoxDis.setSuperDisease(LR.pneumonia);
    chickenpoxDis.setPrintName("chicken pox");

    // symptoms:
    chickenpoxDis.addSymptom(LR.cyanosis);
    chickenpoxDis.addSymptom(LR.dyspnea);
    chickenpoxDis.addSymptom(LR.hemoptysis);
    chickenpoxDis.addSymptom(LR.rash);
    chickenpoxDis.addSymptom(LR.rhonchus);
    chickenpoxDis.addSymptom(LR.tachypnea);

    // treatments:
    Treatment chickenpoxTr1 = new Treatment("chickenpoxTr1");
    chickenpoxTr1.addTreatmentAction(LR.hydration);
    chickenpoxTr1.addTreatmentAction(LR.oxygenTherapy);
    chickenpoxTr1.addDrug(LR.acyclovir);
    chickenpoxDis.addTreatment(chickenpoxTr1.getName());

    // references:
    chickenpoxDis.addReference("pp 516-517");
    chickenpoxDis.addIllustration(D.ChickenPoxJpg);


    // --------------  pneumoniaCytomegaloVirus ---------------
    Disease pneumoniaCytomegaloVirusDis = new Disease(
       LR.pneumoniaCytomegaloVirus,
       "pneumonia caused by cytomegalo virus viral infection",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge 
       LR.maxAge, // maxAge ??
       -4, // duration, less than a month ??
       -1, // diagnosis frequency, unknown
       LR.lungsSysSt,
       LR.infection
       );
    pneumoniaCytomegaloVirusDis.setSuperDisease(LR.pneumonia);
    pneumoniaCytomegaloVirusDis.setPrintName("pneumonia by cytomegalo virus");

    // caused by:                 Dis.addExternalCause(...)
    pneumoniaCytomegaloVirusDis.addExternalCause(
	  LR.respiratoryCytomegaloVirusInfection); // ??

    pneumoniaCytomegaloVirusDis.setMiscComments(
       "Difficult to distinguish from other non bacterial pneumonias; " +
       "occurs in neonates as devastating multi systemic infection; " +
       "can be devastating for immuno compromised hosts");

    // symptoms:
    pneumoniaCytomegaloVirusDis.addSymptom(LR.cyanosis);
    pneumoniaCytomegaloVirusDis.addSymptom(LR.dyspnea);
    pneumoniaCytomegaloVirusDis.addSymptom(LR.fatigue);
    pneumoniaCytomegaloVirusDis.addSymptom(LR.feverSym);
    pneumoniaCytomegaloVirusDis.addSymptom(LR.malaise);
    pneumoniaCytomegaloVirusDis.addSymptom(LR.myalgia);
    pneumoniaCytomegaloVirusDis.addSymptom(LR.nightSweating);


    // treatments:
    Treatment pneumoniaCytomegaloVirusTr1 = 
      new Treatment("pneumoniaCytomegaloVirusTr1");
    pneumoniaCytomegaloVirusTr1.addTreatmentAction(LR.hydration);
    pneumoniaCytomegaloVirusTr1.addTreatmentAction(LR.oxygenTherapy);
    pneumoniaCytomegaloVirusTr1.addTreatmentAction(LR.bedRest);
    pneumoniaCytomegaloVirusTr1.addDrug(LR.ganciclovir);
    pneumoniaCytomegaloVirusDis.addTreatment(pneumoniaCytomegaloVirusTr1.getName());

    // references:
    pneumoniaCytomegaloVirusDis.addReference("pp 516-517");
    pneumoniaCytomegaloVirusDis.setCode358(255);
    pneumoniaCytomegaloVirusDis.setICD10code("J12");


    // --------------  pneumoniaStreptococcus ---------------

    Disease pneumoniaStreptococcusDis = new Disease(
       LR.pneumoniaStreptococcus,
       "pneumonia caused by streptococcus bacterial infection",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge 
       LR.maxAge, // maxAge ??
       -4, // duration, less than a month ??
       F.pneumoniaStreptococcusFreq,
       LR.lungsSysSt,
       LR.infection
       );
    pneumoniaStreptococcusDis.setSuperDisease(LR.pneumonia);
    pneumoniaStreptococcusDis.setPrintName("pneumonia streptococcus");

    // caused by:                 Dis.addExternalCause(...)
    pneumoniaStreptococcusDis.addExternalCause(LR.streptococcusInfection); // ??

    pneumoniaStreptococcusDis.setMiscComments(
       "Sudden onset with temp 102-104/ 39-40; " +
       "typically preceded by upper respiratory tract infection");

    // symptoms:
    pneumoniaStreptococcusDis.setTemperature(LR.highFever); // override superdisease
    pneumoniaStreptococcusDis.addSymptom(LR.coughProductive);
    pneumoniaStreptococcusDis.addSymptom(LR.fatigue);
    pneumoniaStreptococcusDis.addSymptom(LR.feverSym);
    pneumoniaStreptococcusDis.addSymptom(LR.headache);
    pneumoniaStreptococcusDis.addSymptom(LR.malaise);
    pneumoniaStreptococcusDis.addSymptom(LR.nausea);
    pneumoniaStreptococcusDis.addSymptom(LR.tachypnea);
    pneumoniaStreptococcusDis.addSymptom(LR.throatSore);
    pneumoniaStreptococcusDis.addSymptom(LR.vomiting);

    // treatments:
    Treatment pneumoniaStreptococcusTr1 = new Treatment("pneumoniaStreptococcusTr1");
    pneumoniaStreptococcusTr1.addDrug(LR.penicillinG);
    pneumoniaStreptococcusTr1.addDrug(LR.erythromycin);
    pneumoniaStreptococcusDis.addTreatment(pneumoniaStreptococcusTr1.getName());

    // references:
    pneumoniaStreptococcusDis.addReference("pp 516-517");
    pneumoniaStreptococcusDis.setCode358(256);
    pneumoniaStreptococcusDis.setICD10code("J13");


    // --------------  pneumoniaKlebsiella ---------------
    Disease pneumoniaKlebsiellaDis = new Disease(
       LR.pneumoniaKlebsiella,
       "pneumonia caused by klebsiella bacterial infection",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge 
       LR.maxAge, // maxAge ??
       -4, // duration, less than a month ??
       -1, // diagnosis frequency, unknown
       LR.lungsSysSt,
       LR.infection
       );
    pneumoniaKlebsiellaDis.setSuperDisease(LR.pneumonia);
    pneumoniaKlebsiellaDis.setPrintName("pneumonia by klebsiella");

    // caused by:                 Dis.addExternalCause(...)
    pneumoniaKlebsiellaDis.addExternalCause(LR.klebsiellaInfection);

    pneumoniaKlebsiellaDis.setMiscComments(
       "Often with chronic alcoholism, pulmonary disease or diabetes");

    // symptoms:
    pneumoniaKlebsiellaDis.addSymptom(LR.cyanosis);
    pneumoniaKlebsiellaDis.addSymptom(LR.hemoptysis);
    pneumoniaKlebsiellaDis.addSymptom(LR.respirationShallow);

    // treatments:
    Treatment pneumoniaKlebsiellaTr1 = new Treatment("pneumoniaKlebsiellaTr1");
    pneumoniaKlebsiellaTr1.addDrug(LR.antimicrobials);
    pneumoniaKlebsiellaTr1.addDrug(LR.aminoglycocide);
    pneumoniaKlebsiellaTr1.addDrug(LR.cephalosporin);
    pneumoniaKlebsiellaDis.addTreatment(pneumoniaKlebsiellaTr1.getName());

    // references:
    pneumoniaKlebsiellaDis.addReference("pp 518-519");
    pneumoniaKlebsiellaDis.setCode358(256);
    pneumoniaKlebsiellaDis.setICD10code("J13");


    // --------------  pneumoniaStaphylococcus ---------------
    Disease pneumoniaStaphylococcusDis = new Disease(
       LR.pneumoniaStaphylococcus,
       "pneumonia caused by staphylococcus bacterial infection",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge 
       LR.maxAge, // maxAge ??
       -4, // duration, less than a month ??
       -1, // diagnosis frequency, unknown
       LR.lungsSysSt,
       LR.infection
       );
    pneumoniaStaphylococcusDis.setSuperDisease(LR.pneumonia);
    pneumoniaStaphylococcusDis.setPrintName("pneumonia by staphylococcus");

    // caused by:                 Dis.addExternalCause(...)
    pneumoniaStaphylococcusDis.addExternalCause(LR.staphylococcusInfection);

    pneumoniaStaphylococcusDis.setMiscComments(
       "Often in the presence of viral illness/ influenza, measles & " +
       "cystic fibrosis");

    // symptoms:
    pneumoniaStaphylococcusDis.addSymptom(LR.dyspnea);
    pneumoniaStaphylococcusDis.addSymptom(LR.hemoptysis);
    pneumoniaStaphylococcusDis.addSymptom(LR.tachypnea);
    
    // treatments:
    Treatment pneumoniaStaphylococcusTr1 = new Treatment("pneumoniaStaphylococcusTr1");
    pneumoniaStaphylococcusTr1.addDrug(LR.antimicrobials);
    pneumoniaStaphylococcusTr1.addDrug(LR.nafcillin);
    pneumoniaStaphylococcusTr1.addDrug(LR.oxacillin);
    pneumoniaStaphylococcusTr1.addTreatmentAction(LR.chestTubeDrainage);
    pneumoniaStaphylococcusDis.addTreatment(pneumoniaStaphylococcusTr1.getName());

    // references:
    pneumoniaStaphylococcusDis.addReference("pp 518-519");
    pneumoniaStaphylococcusDis.setCode358(256);
    pneumoniaStaphylococcusDis.setICD10code("J13");


    // --------------  pneumocystisCarinii ---------------
    Disease pneumocystisCariniiDis = new Disease(
       LR.pneumocystisCarinii,
       "pneumonia caused by protozoan infection",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge 
       LR.maxAge, // maxAge ??
       -4, // duration, less than a month ??
       -1, // diagnosis frequency, unknown
       LR.lungsSysSt,
       LR.infection
       );

    pneumocystisCariniiDis.setSuperDisease(LR.pneumonia);
    pneumocystisCariniiDis.setPrintName("pneumonia by cystiscarinii");

    // caused by:                 Dis.addExternalCause(...)
    pneumocystisCariniiDis.addExternalCause(LR.pneumocystisCariniiInfection);

    pneumocystisCariniiDis.setMiscComments(
       "Occurs in immunocompromised persons");

    pneumocystisCariniiDis.setTemperature(LR.lowGradeFever);

    // symptoms:
    pneumocystisCariniiDis.addSymptom(LR.anorexia);
    pneumocystisCariniiDis.addSymptom(LR.dyspnea);
    pneumocystisCariniiDis.addSymptom(LR.fatigue);
    pneumocystisCariniiDis.addSymptom(LR.weightLoss);

    // treatments:
    Treatment pneumocystisCariniiTr1 = new Treatment("pneumocystisCariniiTr1");
    pneumocystisCariniiTr1.addDrug(LR.antimicrobials);
    pneumocystisCariniiTr1.addDrug(LR.coTrimoxazole);
    pneumocystisCariniiTr1.addDrug(LR.pentamidine);
    pneumocystisCariniiTr1.addTreatmentAction(LR.oxygenTherapy);
    pneumocystisCariniiTr1.addTreatmentAction(LR.mechanicalVentilation);
    pneumocystisCariniiTr1.addTreatmentAction(LR.nutritionImprove);
    pneumocystisCariniiDis.addTreatment(pneumocystisCariniiTr1.getName());

    // references:
    pneumocystisCariniiDis.addReference("pp 518-519");
    pneumocystisCariniiDis.setCode358(257);
    pneumocystisCariniiDis.setICD10code("J16");


    // --------------  pneumoniaAspiration ---------------
    Disease pneumoniaAspirationDis = new Disease(
       LR.pneumoniaAspiration,
       "pneumonia caused by vomiting and subsequent aspiration of material " +
       "into the trachea and lungs",
       LR.respiratoryDisorders,
       LR.none, // genderSpecificity
       LR.none, // raceSpecificity
       0, // minAge 
       LR.maxAge, // maxAge ??
       -4, // duration, less than a month ??
       -1, // diagnosis frequency, unknown
       LR.lungsSysSt,
       LR.infection
       );
    pneumoniaAspirationDis.setSuperDisease(LR.pneumonia);
    pneumoniaAspirationDis.setPrintName("pneumonia by aspiration");

    // caused by:                 Dis.addExternalCause(...)
    pneumoniaAspirationDis.addExternalCause(LR.aspirationContamination);

    pneumoniaAspirationDis.setMiscComments(
       "Stomac acid can damage respiratory epithelium (= lining of lungs) " +
       "causing pulmonary edema (= excess accumulation of fluid in lung) " +
       "presence of foreign material can lead to lung abscess");

    // symptoms:
    pneumoniaAspirationDis.addSymptom(LR.cyanosis);
    pneumoniaAspirationDis.addSymptom(LR.dyspnea);
    pneumoniaAspirationDis.addSymptom(LR.hypotension);
    pneumoniaAspirationDis.addSymptom(LR.tachycardia);

    // treatments:
    Treatment pneumoniaAspirationTr1 = new Treatment("pneumoniaAspirationTr1");
    pneumoniaAspirationTr1.addDrug(LR.antimicrobials);
    pneumoniaAspirationTr1.addDrug(LR.penicillinG);
    pneumoniaAspirationTr1.addDrug(LR.clindamycin);
    pneumoniaAspirationTr1.addTreatmentAction(LR.oxygenTherapy);
    pneumoniaAspirationTr1.addTreatmentAction(LR.suctioning);
    pneumoniaAspirationTr1.addTreatmentAction(LR.hydration);
    pneumoniaAspirationDis.addTreatment(pneumoniaAspirationTr1.getName());

    // references:
    pneumoniaAspirationDis.addReference("pp 518-519");
    pneumoniaAspirationDis.setCode358(273);
    pneumoniaAspirationDis.setICD10code("J69");


// -------------- severeAcuteRespiratorySyndrome --------------
// (C) OntoOO Inc Fri Mar 28 08:35:19 PST 2003
Disease severeAcuteRespiratorySyndromeDis = new Disease(
   LR.severeAcuteRespiratorySyndrome, 
   "atypical newer variant of pneumonia", 
   LR.respiratoryDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.coronavirusInfection
);
severeAcuteRespiratorySyndromeDis.setPrintName("severe acute respiratory syndrome");
severeAcuteRespiratorySyndromeDis.setWebResource("http://www.cdc.gov/ncidod/sars/");
severeAcuteRespiratorySyndromeDis.setSuperDisease(LR.pneumonia);
severeAcuteRespiratorySyndromeDis.setTemperature((float)100.5);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.breathingDifficult);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.chills);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.diarrhea, "", 0.3f);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.dizziness, "", 0.3f);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.feverSym);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.headache);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.malaise);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.myalgia);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.nausea, "", 0.3f);
severeAcuteRespiratorySyndromeDis.addSymptom(LR.throatSore, "", 0.3f);


// -------------- h5n1 --------------
// (C) OntoOO Inc Fri Mar 10 12:42:53 PST 2006
Disease h5n1Dis = new Disease(
   LR.h5n1, 
   "pneumonia caused by the H5N1 bird flu virus", 
   LR.respiratoryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.infection
);
h5n1Dis.setPrintName("avian influenza");
h5n1Dis.setWebResource("http://www.who.int/mediacentre/factsheets/avian_influenza/en/index.html");
h5n1Dis.setSuperDisease(LR.pneumonia);
h5n1Dis.setTemperature((float)103.0);
h5n1Dis.addSymptom(LR.cyanosis, "", 1.0f);
h5n1Dis.addSymptom(LR.dyspnea, "", 1.0f);
h5n1Dis.addSymptom(LR.headacheFrontal, "", 1.0f);
h5n1Dis.addSymptom(LR.myalgia, "", 1.0f);
h5n1Dis.addSymptom(LR.abdomenPain);
h5n1Dis.addSymptom(LR.breathingDifficult);
h5n1Dis.addSymptom(LR.diarrhea);
h5n1Dis.addSymptom(LR.gumsBleeding);
h5n1Dis.addSymptom(LR.hoarseness);
h5n1Dis.addSymptom(LR.respirationDistress);
h5n1Dis.addSymptom(LR.vomiting);
h5n1Dis.addExternalCause(LR.h5n1BirdFluVirus);
h5n1Dis.setMiscComments("early treatment is required");
Treatment h5n1Tr1  = new Treatment("h5n1Tr1");
h5n1Tr1.addDrug(LR.oseltamivir);
h5n1Dis.addTreatment(h5n1Tr1.getName());


    // -------------- bronchiolitisObliteransWithPneumonia  ---------------
// (C) OntoOO Inc Tue Aug 14 14:05:51 PDT 2001
Disease bronchiolitisObliteransWithPneumoniaDis = new Disease(
   LR.bronchiolitisObliteransWithPneumonia, 
   "inflammation of the small airways with pneumonia", 
   LR.respiratoryDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   50, //  minAge 
   60, //  maxAge 
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.none
);
bronchiolitisObliteransWithPneumoniaDis.setPrintName(
     "bronchiolitis obliterans with pneumonia");
bronchiolitisObliteransWithPneumoniaDis.setUnderlyingDisease(LR.pneumonia);
bronchiolitisObliteransWithPneumoniaDis.setTemperature((float)100.0);

bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.anorexia);
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.chestTightness);
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.chills);
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.cough);
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.crackles);
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.dyspnea);
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.hemoptysis);
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.malaise);
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.nightSweating);
bronchiolitisObliteransWithPneumoniaDis.addSymptom(LR.weightLoss);

bronchiolitisObliteransWithPneumoniaDis.addCausesAbnormalCondition(LR.hypoxemia);

bronchiolitisObliteransWithPneumoniaDis.addReference("pp 520-2");
bronchiolitisObliteransWithPneumoniaDis.setMiscComments(
        "Very responsive to treatments");

Treatment bronchiolitisObliteransWithPneumoniaTr1  = 
  new Treatment("bronchiolitisObliteransWithPneumoniaTr1");
bronchiolitisObliteransWithPneumoniaTr1.addDrug(LR.corticosteroids);
bronchiolitisObliteransWithPneumoniaDis.addTreatment(
        bronchiolitisObliteransWithPneumoniaTr1.getName());
bronchiolitisObliteransWithPneumoniaDis.setCode358(259);
bronchiolitisObliteransWithPneumoniaDis.setICD10code("J21");


    // -------------- pulmonaryEmbolism  ---------------
// (C) OntoOO Inc Wed Sep 05 17:39:44 PDT 2001
Disease pulmonaryEmbolismDis = new Disease(
   LR.pulmonaryEmbolism, 
   "obstruction of the pulmonary arterial bed by a dislodged thrombus " +
   "or foreign substance", 
   LR.respiratoryDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.surgery
);

pulmonaryEmbolismDis.setPrintName("pulmonary embolism");
pulmonaryEmbolismDis.setTemperature((float)99.8);

pulmonaryEmbolismDis.addSymptom(LR.anginaPain, "", 1.0f);
pulmonaryEmbolismDis.addSymptom(LR.coughProductive, "", 1.0f);
pulmonaryEmbolismDis.addSymptom(LR.cyanosis, "with a large embolus", 0.2f);
pulmonaryEmbolismDis.addSymptom(LR.dyspnea, "", 1.0f);
pulmonaryEmbolismDis.addSymptom(LR.neckVeinsElevated, "with a large embolus", 0.2f);
pulmonaryEmbolismDis.addSymptom(LR.hemoptysis, "", 0.2f);
pulmonaryEmbolismDis.addSymptom(LR.legEdema, "", 0.2f);
pulmonaryEmbolismDis.addSymptom(LR.pleuriticChestPain, "", 1.0f);
pulmonaryEmbolismDis.addSymptom(LR.hemoptysis, "", 1.0f);
pulmonaryEmbolismDis.addSymptom(LR.syncope, "with a large embolus", 0.2f);
pulmonaryEmbolismDis.addSymptom(LR.tachycardia, "", 1.0f);

pulmonaryEmbolismDis.addExternalCause(LR.longTermImmobility);
pulmonaryEmbolismDis.addExternalCause(LR.oralContraceptiveUse);

pulmonaryEmbolismDis.addInternalCause(LR.burn);
pulmonaryEmbolismDis.addInternalCause(LR.cancer);
pulmonaryEmbolismDis.addInternalCause(LR.chronicObstructivePulmonaryDisease);
pulmonaryEmbolismDis.addInternalCause(LR.heartFailure);
pulmonaryEmbolismDis.addInternalCause(LR.polycythemiaVera);
pulmonaryEmbolismDis.addInternalCause(LR.sickleCellAnemia);
pulmonaryEmbolismDis.addInternalCause(LR.thrombophlebitis);
pulmonaryEmbolismDis.addInternalCause(LR.femoralThrombophlebitis);
pulmonaryEmbolismDis.addInternalCause(LR.obesity);

pulmonaryEmbolismDis.addCausingAbnormalCondition(LR.atrialFibrillation);
// pulmonaryEmbolismDis.addCausingAbnormalCondition(LR.obesity);
pulmonaryEmbolismDis.addCausingAbnormalCondition(LR.thrombocytosis);
pulmonaryEmbolismDis.addCausingAbnormalCondition(LR.varicoseVeins);

pulmonaryEmbolismDis.addCausesAbnormalCondition(LR.pleuralEffusion);

pulmonaryEmbolismDis.addReference("pp 522-4");

Treatment pulmonaryEmbolismTr1  = new Treatment("pulmonaryEmbolismTr1");
pulmonaryEmbolismTr1.addTreatmentAction(LR.oxygenTherapy);
pulmonaryEmbolismTr1.addDrug(LR.analgetics);
pulmonaryEmbolismTr1.addDrug(LR.anticoagulants);
pulmonaryEmbolismTr1.addDrug(LR.heparin);
pulmonaryEmbolismDis.addTreatment(pulmonaryEmbolismTr1.getName());
Treatment pulmonaryEmbolismTr2  
  = new Treatment("pulmonaryEmbolismTr2", LR.ifMassiveEmbolism);
pulmonaryEmbolismTr2.addTreatmentAction(LR.fibrinolyticTherapy);
pulmonaryEmbolismTr2.addTreatmentAction(LR.surgicalEmbolectomy);
pulmonaryEmbolismDis.addTreatment(pulmonaryEmbolismTr2.getName());
Treatment pulmonaryEmbolismTr3  
  = new Treatment("pulmonaryEmbolismTr3", LR.ifHypotension);
pulmonaryEmbolismTr3.addTreatmentAction(LR.vasopressor);
pulmonaryEmbolismDis.addTreatment(pulmonaryEmbolismTr3.getName());
Treatment pulmonaryEmbolismTr4 
  = new Treatment("pulmonaryEmbolismTr4", LR.ifSepticEmboli);
pulmonaryEmbolismTr4.addDrug(LR.antibiotics);
pulmonaryEmbolismDis.addTreatment(pulmonaryEmbolismTr4.getName());
pulmonaryEmbolismDis.setCode358(218);
pulmonaryEmbolismDis.setICD10code("I26");


    // -------------- sarcoidosis  ---------------
// (C) OntoOO Inc Thu Aug 02 10:26:29 PDT 2001
Disease sarcoidosisDis = new Disease(
   LR.sarcoidosis, 
   "granules in the lungs and lymph nodes and " +
   "also causing lesions in the liver, eye, skin and other tissues ", 
   LR.respiratoryDisorders,
   LR.moreFemale, // genderSpecificity 
   LR.africanAmerican, // raceSpecificity 
   20, //  minAge 
   40, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
sarcoidosisDis.setWebResource(
"http://health.yahoo.com/health/Diseases_and_Conditions/Disease_Feed_Data/Sarcoidosis/");
// general

sarcoidosisDis.addSymptom(LR.arthralgia, "", 0.1f);
sarcoidosisDis.addSymptom(LR.fatigue, "", 0.6f);
sarcoidosisDis.addSymptom(LR.feverSym, "", 0.6f);
sarcoidosisDis.addSymptom(LR.malaise);
sarcoidosisDis.addSymptom(LR.nightSweating, "", 0.6f);
sarcoidosisDis.addSymptom(LR.weightLoss, "", 0.6f);
sarcoidosisDis.addReference("pp 524-6");

sarcoidosisDis.setMiscComments(
"the acute variant resolves within 2 years;" + 
"the uncommon chronic progressive variant is associated with pulmonary fibrosis");

Treatment sarcoidosisTr1 = new Treatment("sarcoidosisTr1");
sarcoidosisTr1.addTreatmentAction(LR.dietLowCalcium);
sarcoidosisTr1.addDrug(LR.steroids);
sarcoidosisDis.addTreatment(sarcoidosisTr1.getName()); 
Treatment sarcoidosisTr2  = new Treatment("sarcoidosisTr2", LR.ifHypercalcemia);
sarcoidosisTr2.addTreatmentAction(LR.avoidSunlightExposure);
sarcoidosisDis.addTreatment(sarcoidosisTr2.getName());


    // --------------  sarcoidosisRespiratory ---------------
// (C) OntoOO Inc Sat Aug 04 18:05:43 PDT 2001
Disease sarcoidosisRespiratoryDis = new Disease(
   LR.sarcoidosisRespiratory, 
   "impact of sarcoidosis on the lungs", 
   LR.respiratoryDisorders,
   LR.moreFemale, // genderSpecificity 
   LR.africanAmerican, // raceSpecificity 
   20, //  minAge 
   40, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.none
);
sarcoidosisRespiratoryDis.setPrintName("sarcoidosis wrt lungs");
sarcoidosisRespiratoryDis.setSuperDisease(LR.sarcoidosis);

sarcoidosisRespiratoryDis.addSymptom(LR.breathlessness, "", 0.4f);
sarcoidosisRespiratoryDis.addSymptom(LR.cough, "", 0.4f);
sarcoidosisRespiratoryDis.addSymptom(LR.substernalPain, "", 0.4f);

sarcoidosisRespiratoryDis.addCausesDisease(LR.corPulmonale);
sarcoidosisRespiratoryDis.addCausesDisease(LR.pulmonaryHypertension);

sarcoidosisRespiratoryDis.addReference("pp 525");


    // --------------  sarcoidosisCutaneous ---------------
// (C) OntoOO Inc Sun Aug 05 08:53:19 PDT 2001
Disease sarcoidosisCutaneousDis = new Disease(
   LR.sarcoidosisCutaneous, 
   "impact of sarcoidosis on the skin", 
   LR.respiratoryDisorders,
   LR.moreFemale, // genderSpecificity 
   LR.africanAmerican, // raceSpecificity 
   20, //  minAge 
   40, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
sarcoidosisCutaneousDis.setPrintName("sarcoidosis wrt skin");
sarcoidosisCutaneousDis.setSuperDisease(LR.sarcoidosis);

sarcoidosisCutaneousDis.addSymptom(LR.erythemaNodosum, "", 0.4f);
sarcoidosisCutaneousDis.addSymptom(LR.maculopapularEruption, "", 0.4f);
sarcoidosisCutaneousDis.addSymptom(LR.noseMucosalLesion, "", 0.4f);
sarcoidosisCutaneousDis.addSymptom(LR.skinNodules, "", 0.4f);

sarcoidosisCutaneousDis.addReference("pp 525");


    // --------------  sarcoidosisOphthalmic ---------------
// (C) OntoOO Inc Sun Aug 05 08:53:19 PDT 2001
Disease sarcoidosisOphthalmicDis = new Disease(
   LR.sarcoidosisOphthalmic, 
   "impact of sarcoidosis on the eye", 
   LR.respiratoryDisorders,
   LR.moreFemale, // genderSpecificity 
   LR.africanAmerican, // raceSpecificity 
   20, //  minAge 
   40, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.eyesSysSt, 
   LR.none
);
sarcoidosisOphthalmicDis.setPrintName("sarcoidosis wrt eyes");
sarcoidosisOphthalmicDis.setSuperDisease(LR.sarcoidosis);
sarcoidosisOphthalmicDis.addSymptom(LR.eyePain, "", 0.4f);
sarcoidosisOphthalmicDis.addSymptom(LR.eyeDryness, "", 0.4f);
sarcoidosisOphthalmicDis.addSymptom(LR.eyeExudate, "", 0.4f);
sarcoidosisOphthalmicDis.addSymptom(LR.eyeRedness, "", 0.4f);
sarcoidosisOphthalmicDis.addSymptom(LR.visionBlurred, "", 0.4f);
sarcoidosisOphthalmicDis.addCausesDisease(LR.uveitisAnterior);
sarcoidosisOphthalmicDis.addCausesDisease(LR.glaucoma); 
sarcoidosisOphthalmicDis.addCausesAbnormalCondition(LR.blindness); 
sarcoidosisOphthalmicDis.addReference("pp 525");


    // --------------  sarcoidosisLymphatic ---------------
// (C) OntoOO Inc Sun Aug 05 08:53:19 PDT 2001
Disease sarcoidosisLymphaticDis = new Disease(
   LR.sarcoidosisLymphatic, 
   "impact of sarcoidosis on the lymph nodes",
   LR.respiratoryDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.africanAmerican, // raceSpecificity 
   20, //  minAge 
   40, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lymphSysSt, 
   LR.none
);
sarcoidosisLymphaticDis.setPrintName("sarcoidosis wrt lymph nodes");
sarcoidosisLymphaticDis.setSuperDisease(LR.sarcoidosis);

sarcoidosisLymphaticDis.addSymptom(LR.lymphadenopathy, "", 0.2f);

sarcoidosisLymphaticDis.addCausesAbnormalCondition(LR.splenomegaly);

sarcoidosisLymphaticDis.addReference("pp 525");


    // --------------  sarcoidosisMusculoSkeletal ---------------
// (C) OntoOO Inc Sun Aug 05 08:53:19 PDT 2001
Disease sarcoidosisMusculoSkeletalDis = new Disease(
   LR.sarcoidosisMusculoSkeletal, 
   "impact of sarcoidosis on the muscles & skeleton", 
   LR.respiratoryDisorders,
   LR.moreFemale, // genderSpecificity 
   LR.africanAmerican, // raceSpecificity 
   20, //  minAge 
   40, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.musculoSkeletalSysSt, 
   LR.none
);
sarcoidosisMusculoSkeletalDis.setPrintName("sarcoidosis wrt muscle & skeleton");
sarcoidosisMusculoSkeletalDis.setSuperDisease(LR.sarcoidosis);

sarcoidosisMusculoSkeletalDis.addSymptom(LR.arthralgia, "", 0.2f);
sarcoidosisMusculoSkeletalDis.addSymptom(LR.fingerBoneLesion, "", 0.2f);
sarcoidosisMusculoSkeletalDis.addSymptom(LR.myalgia, "", 0.2f);
sarcoidosisMusculoSkeletalDis.addSymptom(LR.muscleWeakness, "", 0.2f);

sarcoidosisMusculoSkeletalDis.addReference("pp 525");


    // --------------  sarcoidosisHepatic ---------------
// (C) OntoOO Inc Sun Aug 05 08:53:19 PDT 2001
Disease sarcoidosisHepaticDis = new Disease(
   LR.sarcoidosisHepatic, 
   "impact of sarcoidosis on the liver", 
   LR.respiratoryDisorders,
   LR.moreFemale, // genderSpecificity 
   LR.africanAmerican, // raceSpecificity 
   20, //  minAge 
   40, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.liverSysSt, 
   LR.none
);
sarcoidosisHepaticDis.setPrintName("sarcoidosis wrt liver");
sarcoidosisHepaticDis.setSuperDisease(LR.sarcoidosis);
sarcoidosisHepaticDis.addSymptom(LR.jaundice, "", 0.2f);
sarcoidosisHepaticDis.addSymptom(LR.pruritus, "", 0.2f);
sarcoidosisHepaticDis.addCausesDisease(LR.hepatitis);
sarcoidosisHepaticDis.addReference("pp 525");


    // --------------  sarcoidosisUrinary ---------------
// (C) OntoOO Inc Sun Aug 05 08:53:19 PDT 2001
Disease sarcoidosisUrinaryDis = new Disease(
   LR.sarcoidosisUrinary, 
   "impact of sarcoidosis on the urinary track", 
   LR.respiratoryDisorders,
   LR.moreFemale, // genderSpecificity 
   LR.africanAmerican, // raceSpecificity 
   20, //  minAge 
   40, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bladderSysSt, 
   LR.none
);
sarcoidosisUrinaryDis.setPrintName("sarcoidosis wrt urine track");
sarcoidosisUrinaryDis.setSuperDisease(LR.sarcoidosis);
sarcoidosisUrinaryDis.addSymptom(LR.backPain, "", 0.2f);
sarcoidosisUrinaryDis.addSymptom(LR.flankPain, "", 0.2f);
sarcoidosisUrinaryDis.addSymptom(LR.urinaryFrequency, "", 0.2f);

sarcoidosisUrinaryDis.addCausesAbnormalCondition(LR.hypercalciuria);

sarcoidosisUrinaryDis.addReference("pp 525");


    // --------------  sarcoidosisCardio ---------------
// (C) OntoOO Inc Sun Aug 05 08:53:19 PDT 2001
Disease sarcoidosisCardioDis = new Disease(
   LR.sarcoidosisCardio, 
   "impact of sarcoidosis on the heart", 
   LR.respiratoryDisorders,
   LR.moreFemale, // genderSpecificity 
   LR.africanAmerican, // raceSpecificity 
   20, //  minAge 
   40, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.heartSysSt, 
   LR.none
);
sarcoidosisCardioDis.setPrintName("sarcoidosis wrt heart");
sarcoidosisCardioDis.setSuperDisease(LR.sarcoidosis);

sarcoidosisCardioDis.addSymptom(LR.arrhythmia, "", 0.2f);
sarcoidosisCardioDis.addSymptom(LR.chestTightness, "", 0.2f);
sarcoidosisCardioDis.addSymptom(LR.dyspnea, "", 0.2f);
sarcoidosisCardioDis.addSymptom(LR.legEdema, "", 0.2f);
sarcoidosisCardioDis.addSymptom(LR.palpitations, "", 0.2f);

sarcoidosisCardioDis.addCausesDisease(LR.cardiomyopathy);
sarcoidosisCardioDis.addReference("pp 525");


    // --------------  sarcoidosisCNS ---------------
// (C) OntoOO Inc Sun Aug 05 08:53:19 PDT 2001
Disease sarcoidosisCNSDis = new Disease(
   LR.sarcoidosisCNS, 
   "impact of sarcoidosis on the central nervous system", 
   LR.respiratoryDisorders,
   LR.moreFemale, // genderSpecificity 
   LR.africanAmerican, // raceSpecificity 
   20, //  minAge 
   40, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.centralNervousSysSt, 
   LR.none
);
sarcoidosisCNSDis.setPrintName("sarcoidosis wrt central nervous system");
sarcoidosisCNSDis.setSuperDisease(LR.sarcoidosis);

sarcoidosisCNSDis.addSymptom(LR.headache, "", 0.2f);
sarcoidosisCNSDis.addSymptom(LR.palsy, "", 0.2f);
sarcoidosisCNSDis.addSymptom(LR.seizure, "", 0.2f);
sarcoidosisCNSDis.addSymptom(LR.visionDefect, "", 0.2f);

sarcoidosisCNSDis.addCausesDisease(LR.diabetesInsidipus);
sarcoidosisCNSDis.addCausesDisease(LR.meningitis);

sarcoidosisCNSDis.addReference("pp 525");


    // --------------  lungAbscessDis ---------------
// (C) OntoOO Inc Tue Sep 25 14:45:37 PDT 2001
Disease lungAbscessDis = new Disease(
   LR.lungAbscess, 
   "lung infection producing pus and causing tissue destruction", 
   LR.respiratoryDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -6, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.infection
);
lungAbscessDis.setPrintName("lung abscess");
lungAbscessDis.setTemperature((float)99.9);

lungAbscessDis.addSymptom(LR.chills);
lungAbscessDis.addSymptom(LR.cough);
lungAbscessDis.addSymptom(LR.diaphoresis);
lungAbscessDis.addSymptom(LR.dyspnea);
lungAbscessDis.addSymptom(LR.headache);
lungAbscessDis.addSymptom(LR.hemorrhage, "if rupture in pleural space", 0.05f);
lungAbscessDis.addSymptom(LR.malaise);
lungAbscessDis.addSymptom(LR.pleuriticChestPain);
lungAbscessDis.addSymptom(LR.hemoptysis);
lungAbscessDis.addSymptom(LR.sputumFoulSmelling); 
lungAbscessDis.addSymptom(LR.sputumPurulent); 
lungAbscessDis.addSymptom(LR.weightLoss);
lungAbscessDis.addInternalCause(LR.pneumonia);

lungAbscessDis.addCausesDisease(LR.bronchiectasis);

lungAbscessDis.addCausesAbnormalCondition(LR.empyema);

lungAbscessDis.addReference("pp 526-7");
lungAbscessDis.setMiscComments("associated with poor oral hygiene");

Treatment lungAbscessTr1 = new Treatment("lungAbscessTr1");
lungAbscessTr1.addTreatmentAction(LR.IVFluids);
lungAbscessTr1.addTreatmentAction(LR.oxygenTherapy);
lungAbscessTr1.addTreatmentAction(LR.suctioning);
lungAbscessTr1.addTreatmentAction(LR.aspirationPrecautions);
lungAbscessTr1.addDrug(LR.antibiotics);
lungAbscessDis.addTreatment(lungAbscessTr1.getName()); 


    // --------------  hemothorax ---------------
// (C) OntoOO Inc Tue Sep 25 21:08:08 PDT 2001
Disease hemothoraxDis = new Disease(
   LR.hemothorax, 
   "blood from damaged lung vessels enters the pleural cavity", 
   LR.respiratoryDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.chestTrauma
);

hemothoraxDis.addSymptom(LR.anxiety, "if respiratory failure", 1.0f);
hemothoraxDis.addSymptom(LR.chestPain, "", 1.0f);
hemothoraxDis.addSymptom(LR.cyanosis, "if respiratory failure", 0.5f);
hemothoraxDis.addSymptom(LR.dyspnea, "", 1.0f);
hemothoraxDis.addSymptom(LR.hypotension, "if substantial blood loss", 0.2f);
hemothoraxDis.addSymptom(LR.restlessness, "if respiratory failure", 1.0f);
hemothoraxDis.addSymptom(LR.stupor, "if respiratory failure", 0.5f);
hemothoraxDis.addSymptom(LR.tachypnea, "", 1.0f);

hemothoraxDis.addCausesAbnormalCondition(LR.shock);

hemothoraxDis.addReference("pp 527");

Treatment hemothoraxTr1  = new Treatment("hemothoraxTr1");
hemothoraxTr1.addTreatmentAction(LR.oxygenTherapy);
hemothoraxTr1.addTreatmentAction(LR.IVFluids);
hemothoraxTr1.addTreatmentAction(LR.bloodTransfusion);
hemothoraxDis.addTreatment(hemothoraxTr1.getName());


    // --------------  pulmonaryHypertension ---------------
// (C) OntoOO Inc Wed Sep 26 20:14:19 PDT 2001
Disease pulmonaryHypertensionDis = new Disease(
   LR.pulmonaryHypertension, 
   "when pulmonary artery pressure rises above normal (other than aging or altitude)", 
   LR.respiratoryDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.pulmonaryArterySysSt, 
   LR.none
);
pulmonaryHypertensionDis.setPrintName("pulmonary hypertension");
pulmonaryHypertensionDis.setWebResource(
     "http://www.primary-pulmonary-hypertension-resources.com/");

pulmonaryHypertensionDis.addSymptom(LR.chestPain, "", 0.3f);
pulmonaryHypertensionDis.addSymptom(LR.dizziness, "", 0.6f);
pulmonaryHypertensionDis.addSymptom(LR.dyspnea, "", 1.0f);
pulmonaryHypertensionDis.addSymptom(LR.edemaPeripheral);
pulmonaryHypertensionDis.addSymptom(LR.fainting, "", 0.6f);
pulmonaryHypertensionDis.addSymptom(LR.fatigue, "", 0.6f);
pulmonaryHypertensionDis.addSymptom(LR.neckVeinsElevated);
pulmonaryHypertensionDis.addSymptom(LR.syncope, "", 1.0f);
pulmonaryHypertensionDis.addSymptom(LR.weakness, "", 1.0f);

pulmonaryHypertensionDis.addInternalCause(LR.asbestosis); 
pulmonaryHypertensionDis.addInternalCause(LR.berylliosisChronic);
pulmonaryHypertensionDis.addInternalCause(LR.coalWorkerPneumoconiosis);
pulmonaryHypertensionDis.addInternalCause(LR.idiopathicPulmonaryFibrosis);
pulmonaryHypertensionDis.addInternalCause(LR.respiratoryFailureAcute);
pulmonaryHypertensionDis.addInternalCause(LR.sarcoidosisRespiratory);
pulmonaryHypertensionDis.addInternalCause(LR.schistosomiasis);

pulmonaryHypertensionDis.addCausesDisease(LR.heartFailureRightSided);

pulmonaryHypertensionDis.addCausesAbnormalCondition(LR.ascites);
pulmonaryHypertensionDis.addCausesAbnormalCondition(LR.hepatomegaly);

pulmonaryHypertensionDis.addReference("pp 528-9");
pulmonaryHypertensionDis.setMiscComments(
      "long-term prognosis is poor: 25% survival after 5 years");

Treatment pulmonaryHypertensionTr1  = new Treatment("pulmonaryHypertensionTr1");
pulmonaryHypertensionTr1.addTreatmentAction(LR.oxygenTherapy);
pulmonaryHypertensionDis.addTreatment(pulmonaryHypertensionTr1.getName());
Treatment pulmonaryHypertensionTr2 = 
  new Treatment("pulmonaryHypertensionTr2", LR.ifRightSidedHeartFailure);
pulmonaryHypertensionTr2.addTreatmentAction(LR.fluidRestriction);
pulmonaryHypertensionTr2.addDrug(LR.diuretics);
pulmonaryHypertensionTr2.addDrug(LR.digitalisGlycosides);
pulmonaryHypertensionDis.addTreatment(pulmonaryHypertensionTr2.getName()); 


    // --------------  pulmonaryHypertensionPrimary ---------------
// (C) OntoOO Inc Thu Sep 27 15:19:58 PDT 2001
Disease pulmonaryHypertensionPrimaryDis = new Disease(
   LR.pulmonaryHypertensionPrimary, 
   "high blood pressure without known cause (no underlying disease) ", 
   LR.respiratoryDisorders,
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   40, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.pulmonaryArterySysSt, 
   LR.none
);
pulmonaryHypertensionPrimaryDis.setPrintName("pulmonary hypertension primary");
pulmonaryHypertensionPrimaryDis.setSuperDisease(LR.pulmonaryHypertension);

pulmonaryHypertensionPrimaryDis.addReference("pp 528-9");
pulmonaryHypertensionPrimaryDis.setMiscComments(
      "see super disease: pulmonary hypertension");

Treatment pulmonaryHypertensionPrimaryTr1  = 
  new Treatment("pulmonaryHypertensionPrimaryTr1");
pulmonaryHypertensionPrimaryTr1.addTreatmentAction(LR.heartLungTransplantation);
pulmonaryHypertensionPrimaryDis.addTreatment(pulmonaryHypertensionPrimaryTr1.getName());


    // --------------  pulmonaryHypertensionHypoventilation ---------------
// (C) OntoOO Inc Thu Sep 27 17:03:38 PDT 2001
Disease pulmonaryHypertensionHypoventilationDis = new Disease(
   LR.pulmonaryHypertensionHypoventilation, 
   "high blood pressure as a result of too low lung ventilation", 
   LR.respiratoryDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.pulmonaryArterySysSt, 
   LR.none
);
pulmonaryHypertensionHypoventilationDis.setPrintName(
     "pulmonary hypertension by hypoventilation");
pulmonaryHypertensionHypoventilationDis.setSuperDisease(LR.pulmonaryHypertension);

pulmonaryHypertensionHypoventilationDis.addInternalCause(
		     LR.chronicObstructivePulmonaryDisease);
pulmonaryHypertensionHypoventilationDis.addInternalCause(LR.lungCancer);
pulmonaryHypertensionHypoventilationDis.addInternalCause(LR.sarcoidosis);
pulmonaryHypertensionHypoventilationDis.addInternalCause(LR.scleroderma);
pulmonaryHypertensionHypoventilationDis.addInternalCause(LR.silicosis);

pulmonaryHypertensionHypoventilationDis.addCausingAbnormalCondition(LR.hypoxemia);

pulmonaryHypertensionHypoventilationDis.addReference("pp 528");


    // --------------  pulmonaryHypertensionVascularObstruction ---------------
// (C) OntoOO Inc Fri Sep 28 14:20:47 PDT 2001
Disease pulmonaryHypertensionVascularObstructionDis = new Disease(
   LR.pulmonaryHypertensionVascularObstruction, 
   "high blood pressure due to obstruction in veins", 
   LR.respiratoryDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.pulmonaryArterySysSt, 
   LR.none
);
pulmonaryHypertensionVascularObstructionDis.setPrintName(
     "pulmonary hypertension by vascular obstruction");
pulmonaryHypertensionVascularObstructionDis.setSuperDisease(
     LR.pulmonaryHypertension);

pulmonaryHypertensionVascularObstructionDis.addInternalCause(
     LR.pulmonaryEmbolism);
pulmonaryHypertensionVascularObstructionDis.addInternalCause(LR.vasculitis);

pulmonaryHypertensionVascularObstructionDis.addReference("pp 528");


    // --------------  pulmonaryHypertensionCardiac ---------------
// (C) OntoOO Inc Sun Sep 30 20:19:13 PDT 2001
Disease pulmonaryHypertensionCardiacDis = new Disease(
   LR.pulmonaryHypertensionCardiac, 
   "high blood pressure due to a cardiac problem", 
   LR.respiratoryDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.pulmonaryArterySysSt, 
   LR.none
);
pulmonaryHypertensionCardiacDis.setPrintName(
   "pulmonary hypertension due cardiac disease");
pulmonaryHypertensionCardiacDis.setSuperDisease(LR.pulmonaryHypertension);

pulmonaryHypertensionCardiacDis.addInternalCause(LR.mitralStenosis);
pulmonaryHypertensionCardiacDis.addInternalCause(LR.patentDuctusArteriosus);

pulmonaryHypertensionCardiacDis.addReference("pp 528");


    // --------------  pleurisy ---------------
// (C) OntoOO Inc Mon Oct 01 11:35:16 PDT 2001
Disease pleurisyDis = new Disease(
   LR.pleurisy, 
   "inflammation of the pleurae that envelop the lungs", 
   LR.respiratoryDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.chestTrauma
);

pleurisyDis.addSymptom(LR.dyspnea, "", 0.6f);
pleurisyDis.addSymptom(LR.stabbingChestPain);

pleurisyDis.addInternalCause(LR.lupusErythematosus);
pleurisyDis.addInternalCause(LR.pneumonia);
pleurisyDis.addInternalCause(LR.rheumatoidArthritis);
pleurisyDis.addInternalCause(LR.tuberculosis);
pleurisyDis.addInternalCause(LR.rheumatoidArthritis3);

pleurisyDis.addCausingAbnormalCondition(LR.uremia);
pleurisyDis.addReference("pp 531");

Treatment pleurisyTr1  = new Treatment("pleurisyTr1");
pleurisyTr1.addTreatmentAction(LR.bedRest);
pleurisyTr1.addDrug(LR.analgetics);
pleurisyDis.addTreatment(pleurisyTr1.getName());


    // --------------  chronicObstructivePulmonaryDisease---------------

    Disease chronicObstructivePulmonaryDiseaseDis = new Disease(
       LR.chronicObstructivePulmonaryDisease,
       "chronic obstructive pulmonary disease",
       LR.respiratoryDisorders,
       LR.moreMale, // genderSpecificity
       LR.none, // raceSpecificity
       20, // minAge - 3 months in fact
       LR.maxAge, // maxAge
       -1, // duration, chronic
       -1, // diagnosis frequency, unknown
       LR.lungsSysSt,
       LR.airPollution
       );
    chronicObstructivePulmonaryDiseaseDis.setPrintName();

    // set super disease - if any
    // caused by:
    chronicObstructivePulmonaryDiseaseDis.addExternalCause(LR.chronicRespiratoryInfections); // pretty vague

    // symptoms:
    chronicObstructivePulmonaryDiseaseDis.addSymptom(LR.coughProductive);
    chronicObstructivePulmonaryDiseaseDis.addSymptom(LR.dyspnea);

    // treatments:
    Treatment chronicObstructivePulmonaryDiseaseTr1 = 
      new Treatment("chronicObstructivePulmonaryDiseaseTr1");
    chronicObstructivePulmonaryDiseaseTr1.addDrug(LR.betaAgonistBronchodilator);
    chronicObstructivePulmonaryDiseaseTr1.addDrug(LR.albuterol);
    chronicObstructivePulmonaryDiseaseTr1.addDrug(LR.salmeterol);
    chronicObstructivePulmonaryDiseaseTr1.addDrug(LR.anticholinergicBronchodilator);
    chronicObstructivePulmonaryDiseaseTr1.addDrug(LR.ipratropium);
    chronicObstructivePulmonaryDiseaseTr1.addDrug(LR.corticosteroids);
    chronicObstructivePulmonaryDiseaseTr1.addDrug(LR.beclomethasone);
    chronicObstructivePulmonaryDiseaseTr1.addDrug(LR.triamcinolone);
    chronicObstructivePulmonaryDiseaseDis.addTreatment(
		     chronicObstructivePulmonaryDiseaseTr1.getName());
    
    Treatment chronicObstructivePulmonaryDiseaseTr2 = 
      new Treatment("chronicObstructivePulmonaryDiseaseTr2");
    chronicObstructivePulmonaryDiseaseTr2.addDrug(LR.ifInfectionProvideAntibiotic);
    chronicObstructivePulmonaryDiseaseDis.addTreatment(chronicObstructivePulmonaryDiseaseTr2.getName());

    Treatment chronicObstructivePulmonaryDiseaseTr3 = new Treatment("chronicObstructivePulmonaryDiseaseTr3");
    chronicObstructivePulmonaryDiseaseTr2.addTreatmentAction(LR.oxygenTherapy);
    chronicObstructivePulmonaryDiseaseDis.addTreatment(chronicObstructivePulmonaryDiseaseTr3.getName());

    // causing:
    // chronicObstructivePulmonaryDiseaseDis.addInternalCause(LR.allergy); // astma only
    chronicObstructivePulmonaryDiseaseDis.addInternalCause(LR.gastroesophagealReflux);

    // can cause:
    // chronicObstructivePulmonaryDiseaseDis.addCausesDisease(LR.respiratoryInfection); // too vague
    chronicObstructivePulmonaryDiseaseDis.addCausesDisease(LR.corPulmonale);

    // references:
    chronicObstructivePulmonaryDiseaseDis.addReference("pp 531-537");

    // causing abnormal conditions
    // causes abnormal conditions / complications
    chronicObstructivePulmonaryDiseaseDis.addCausesAbnormalCondition(LR.hypoxemia);

    // chronicObstructivePulmonaryDisease sub disease: emphysema

    // --------------  emphysema ---------------
    Disease emphysemaDis = new Disease(
       LR.emphysema,
       "irreversible enlargement of airspace in the lungs " + 
       "resulting in decreased elastic recoil",
       LR.respiratoryDisorders,
       LR.moreMale, // genderSpecific
       LR.none, // raceSpecificity
       40, // minAge 
       LR.maxAge, // maxAge
       -1, // duration, chronic
       -1, // diagnosis frequency, unknown
       LR.lungsSysSt,
       LR.lifeStyle
       );
    // set super disease - if any
    emphysemaDis.setSuperDisease(LR.chronicObstructivePulmonaryDisease);
    
    // caused by:                 Dis.addExternalCause(...)
    emphysemaDis.addExternalCause(LR.cigaretteSmoking);

    emphysemaDis.addInternalCause(LR.coalWorkerPneumoconiosis);
    emphysemaDis.addInternalCause(LR.cysticFibrosis);

    // symptoms:
    emphysemaDis.addSymptom(LR.anorexia);
    emphysemaDis.addSymptom(LR.barrelChest);
    emphysemaDis.addSymptom(LR.grunting);
    emphysemaDis.addSymptom(LR.malaise);
    emphysemaDis.addSymptom(LR.pursedLipBreathing);
    emphysemaDis.addSymptom(LR.tachypnea);
    emphysemaDis.addSymptom(LR.weightLoss);

    // treatments:
    // causing:
    // can cause:
    // references:
    emphysemaDis.addReference("pp 532-3");

    // causing abnormal conditions
    // causes abnormal conditions / complications
    emphysemaDis.addCausesAbnormalCondition(LR.death);
    emphysemaDis.addCausesAbnormalCondition(
	    LR.recurrentRespiratoryTractInfections);
    emphysemaDis.addCausesAbnormalCondition(LR.respiratoryFailure);
emphysemaDis.setCode358(266);
emphysemaDis.setICD10code("J43");

    // chronicObstructivePulmonaryDisease sub disease: chronic bronchitis


    // --------------  chronicBronchitis ---------------
    Disease chronicBronchitisDis = new Disease(
       LR.chronicBronchitis,
       "excessive mucus production with productive cough " +
       "at least 3 months a year for 2 successive years",
       LR.respiratoryDisorders,
       LR.moreMale, // genderSpecific
       LR.none, // raceSpecificity
       40, // minAge - 3 months in fact
       LR.maxAge, // maxAge
       -1, // duration, chronic
       -1, // diagnosis frequency, unknown
       LR.lungsSysSt,
       LR.lifeStyle
       );
    chronicBronchitisDis.setPrintName("chronic bronchitis");
    // set super disease - if any
    chronicBronchitisDis.setSuperDisease(LR.chronicObstructivePulmonaryDisease);

    // caused by:                 Dis.addExternalCause(...)
    chronicBronchitisDis.addExternalCause(LR.cigaretteSmoking);

    chronicBronchitisDis.addInternalCause(LR.coalWorkerPneumoconiosis);

    // symptoms:
    chronicBronchitisDis.addSymptom(LR.cyanosis);
    chronicBronchitisDis.addSymptom(LR.prolongedExpiration);
    chronicBronchitisDis.addSymptom(LR.sputumProduction);
    chronicBronchitisDis.addSymptom(LR.tachypnea);
    chronicBronchitisDis.addSymptom(LR.weightGain);
    chronicBronchitisDis.addSymptom(LR.wheezing);

    // treatments:
    Treatment chronicBronchitisTr1 = new Treatment("chronicBronchitisTr1");
    chronicBronchitisTr1.addDrug(LR.diuretics);
    chronicBronchitisDis.addTreatment(chronicBronchitisTr1.getName());
chronicBronchitisDis.setCode358(265);
chronicBronchitisDis.setICD10code("J41");

    // causing:
    // can cause:
    // references:  chronicBronchitisDis.addReference("pp 532-3");
    // causing abnormal conditions
    // causes abnormal conditions / complications

    // chronicObstructivePulmonaryDisease 
    // sub disease: asthma / see also under immune disease, allergy


    // --------------  chronicAsthma ---------------
    Disease chronicAsthmaDis = new Disease(
       LR.chronicAsthma,
       "increased bronchial reactivity to a variety of stimuli, " +
       "which produces episodic bronchospasm and airway obstruction " +
       "in conjunction with airway inflammation",
       LR.respiratoryDisorders,
       LR.none, // genderSpecific
       LR.none, // raceSpecificity
       5, // minAge 
       LR.maxAge, // maxAge
       -1, // duration, chronic
       -1, // diagnosis frequency, unknown
       LR.lungsSysSt,
       LR.lifeStyle
       );
    // set super disease - if any
    chronicAsthmaDis.setSuperDisease(LR.chronicObstructivePulmonaryDisease);
    // chronicAsthmaDis.setSuperDisease(LR.asthma); // double inheritance !!
    chronicAsthmaDis.setPrintName("chronic asthma");
    

    // symptoms:
    chronicAsthmaDis.addSymptom(LR.chestTightness);
    chronicAsthmaDis.addSymptom(LR.eczema);
    chronicAsthmaDis.addSymptom(LR.flaringNostrils);
    chronicAsthmaDis.addSymptom(LR.flushing);
    chronicAsthmaDis.addSymptom(LR.perspiration);
    chronicAsthmaDis.addSymptom(LR.prolongedExpiration);
    chronicAsthmaDis.addSymptom(LR.tachycardia);
    chronicAsthmaDis.addSymptom(LR.tachypnea);
    chronicAsthmaDis.addSymptom(LR.thickMucus);
    chronicAsthmaDis.addSymptom(LR.wheezing);
    // caused by:
    chronicAsthmaDis.addExternalCause(LR.cigaretteSmoking);
    chronicAsthmaDis.addExternalCause(LR.coughing);
    chronicAsthmaDis.addExternalCause(LR.laughing);
    chronicAsthmaDis.addExternalCause(LR.anxiety);
    
    chronicAsthmaDis.addInternalCause(LR.asthma);


    chronicAsthmaDis.setMiscComments(
	   "Often in conjunction with allergic rhinitis (hay fever)");

    // treatments:
    Treatment chronicAsthmaTr1 = new Treatment("chronicAsthmaTr1");
    chronicAsthmaTr1.addDrug(LR.metaproterenol);
    chronicAsthmaTr1.addDrug(LR.terbutaline);
    chronicAsthmaTr1.addDrug(LR.theophylline);
    chronicAsthmaDis.addTreatment(chronicAsthmaTr1.getName());

    Treatment chronicAsthmaTr2 = 
      new Treatment("chronicAsthmaTr2", LR.ifSevere);
    chronicAsthmaTr2.addDrug(LR.IVTheophylline);
    chronicAsthmaTr2.addDrug(LR.corticosteroids);
    chronicAsthmaTr2.addDrug(LR.epinephrine);
    chronicAsthmaTr2.addDrug(LR.ipratropiumBromide);
    chronicAsthmaDis.addTreatment(chronicAsthmaTr2.getName());

    // causing:

    // can cause:
    // references:
    chronicAsthmaDis.addReference("pp 534-5");

    // causing abnormal conditions
    chronicAsthmaDis.addExternalCause(LR.upperAirwayInfection);

    // causes abnormal conditions / complications
    chronicAsthmaDis.addCausesAbnormalCondition(LR.death);
    chronicAsthmaDis.addCausesAbnormalCondition(LR.respiratoryFailure);
    chronicAsthmaDis.setCode358(268);
    chronicAsthmaDis.setICD10code("J46");


    // --------------  bronchiectasis ---------------
// (C) OntoOO Inc Tue Oct 02 20:05:43 PDT 2001
Disease bronchiectasisDis = new Disease(
   LR.bronchiectasis, 
   "chronic abnormal dilation of bronchi and destruction of bronchial walls", 
   LR.respiratoryDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.aspirationGastricContents
);
bronchiectasisDis.setTemperature((float)99.8);
bronchiectasisDis.addSymptom(LR.coughProductiveFoulSmelling);
bronchiectasisDis.addSymptom(LR.crackles);
bronchiectasisDis.addSymptom(LR.dyspnea);
bronchiectasisDis.addSymptom(LR.hemoptysis);
bronchiectasisDis.addSymptom(LR.malaise);
bronchiectasisDis.addSymptom(LR.weightLoss);
bronchiectasisDis.addSymptom(LR.wheezing);

bronchiectasisDis.addExternalCause(LR.chemicalInhalation);

bronchiectasisDis.addInternalCause(LR.cysticFibrosis);
bronchiectasisDis.addInternalCause(LR.lungAbscess);

bronchiectasisDis.addCausingSet(LR.immuneDisorders);
bronchiectasisDis.addCausingSet(LR.respiratoryTractInfections);

bronchiectasisDis.addCausesDisease(LR.corPulmonale);
bronchiectasisDis.addCausesDisease(LR.heartFailureRightSided);
bronchiectasisDis.addCausesDisease(LR.anemia);
bronchiectasisDis.addCausesDisease(LR.sinusitis);

bronchiectasisDis.addCausesAbnormalCondition(LR.hypoxemia);

bronchiectasisDis.addReference("pp 537-9");
bronchiectasisDis.setMiscComments("highest occurrence with Eskimos & Maoris ");

Treatment bronchiectasisTr1  = new Treatment("bronchiectasisTr1");
bronchiectasisTr1.addTreatmentAction(LR.bronchoscopy);
bronchiectasisTr1.addTreatmentAction(LR.chestPercussion);
bronchiectasisTr1.addTreatmentAction(LR.posturalDrainage);
bronchiectasisTr1.addDrug(LR.antibiotics);
bronchiectasisTr1.addDrug(LR.bronchodilator);
bronchiectasisDis.addTreatment(bronchiectasisTr1.getName());
Treatment bronchiectasisTr2  = 
    new Treatment("bronchiectasisTr2", LR.ifSevereHemoptysis);
bronchiectasisTr2.addTreatmentAction(LR.lobectomy);
bronchiectasisDis.addTreatment(bronchiectasisTr2.getName());
bronchiectasisDis.setCode358(269);
bronchiectasisDis.setICD10code("J47");


    // -------------- idiopathicPulmonaryFibrosis  ---------------
// (C) OntoOO Inc Sun Oct 07 18:35:00 PDT 2001
Disease idiopathicPulmonaryFibrosisDis = new Disease(
   LR.idiopathicPulmonaryFibrosis, 
   "inflammatory, immune and fibrotic processes in the lung", 
   LR.respiratoryDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   50, //  minAge 
   70, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.none
);
idiopathicPulmonaryFibrosisDis.setPrintName("idiopathic pulmonary fibrosis");

idiopathicPulmonaryFibrosisDis.addSymptom(LR.coughHacking);
idiopathicPulmonaryFibrosisDis.addSymptom(LR.crackles);
idiopathicPulmonaryFibrosisDis.addSymptom(LR.cyanosis);
idiopathicPulmonaryFibrosisDis.addSymptom(LR.dyspnea);
idiopathicPulmonaryFibrosisDis.addSymptom(LR.tachypnea);
idiopathicPulmonaryFibrosisDis.addSymptom(LR.respirationShallow);
idiopathicPulmonaryFibrosisDis.addInternalCause(LR.ankylosingSpondylitis); 

idiopathicPulmonaryFibrosisDis.addCausesDisease(LR.pulmonaryHypertension);

idiopathicPulmonaryFibrosisDis.addCausesAbnormalCondition(LR.hypoxia);

idiopathicPulmonaryFibrosisDis.addReference("pp 539-42");
idiopathicPulmonaryFibrosisDis.setMiscComments(
       "5 year survival is 50%; cause is unknown but smoking contributes");

Treatment idiopathicPulmonaryFibrosisTr1  = 
       new Treatment("idiopathicPulmonaryFibrosisTr1");
idiopathicPulmonaryFibrosisTr1.addTreatmentAction(LR.oxygenTherapy);
idiopathicPulmonaryFibrosisTr1.addDrug(LR.corticosteroids);
idiopathicPulmonaryFibrosisTr1.addDrug(LR.cyclophosphamide);
idiopathicPulmonaryFibrosisTr1.addDrug(LR.colchicine);
idiopathicPulmonaryFibrosisDis.addTreatment(idiopathicPulmonaryFibrosisTr1.getName());

/*
// -------------- upperLobePulmonaryFibrosis --------------
// (C) OntoOO Inc Sun Dec 28 16:10:56 PST 2003
Disease upperLobePulmonaryFibrosisDis = new Disease(
   LR.upperLobePulmonaryFibrosis, 
   "scarring in the top of lungs", 
   LR.respiratoryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge,
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.radiation
);
upperLobePulmonaryFibrosisDis.setPrintName("upper lobe pulmonary fibrosis");
upperLobePulmonaryFibrosisDis.setSuperDisease(LR.idiopathicPulmonaryFibrosis);
upperLobePulmonaryFibrosisDis.addInternalCause(LR.ankylosingSpondylitis);
upperLobePulmonaryFibrosisDis.addInternalCause(LR.silicosis);
upperLobePulmonaryFibrosisDis.addInternalCause(LR.sarcoidosis);
upperLobePulmonaryFibrosisDis.addInternalCause(LR.tuberculosis);
upperLobePulmonaryFibrosisDis.addReference("pp 539-42");
*/

    // --------------  tuberculosis ---------------
// (C) OntoOO Inc Mon Aug 27 16:01:04 PDT 2001
Disease tuberculosisDis = new Disease(
   LR.tuberculosis, 
   "infection by tuberculosis mycobacterium", 
   LR.respiratoryDisorders,
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -11, //  duration 
   F.tuberculosisFreq,
   LR.lungsSysSt, 
   LR.infection
);
tuberculosisDis.addSymptom(LR.anorexia, "", 1.0f);
tuberculosisDis.addSymptom(LR.chestPain, "", 0.3f);
tuberculosisDis.addSymptom(LR.cough, "", 1.0f);
tuberculosisDis.addSymptom(LR.fatigue, "", 1.0f);
tuberculosisDis.addSymptom(LR.hemoptysis, "", 0.3f);
tuberculosisDis.addSymptom(LR.nightSweating, "", 1.0f);
tuberculosisDis.addSymptom(LR.sputumMucopurulent, "", 1.0f);
tuberculosisDis.addSymptom(LR.weakness, "", 1.0f);
tuberculosisDis.addSymptom(LR.weightLoss, "", 1.0f);

tuberculosisDis.addInternalCause(LR.coalWorkerPneumoconiosis);

tuberculosisDis.addReference("pp 542-4");

Treatment tuberculosisTr1  = new Treatment("tuberculosisTr1");
tuberculosisTr1.addDrug(LR.isoniazid);
tuberculosisTr1.addDrug(LR.rifampin);
tuberculosisTr1.addDrug(LR.pirazinamide);
tuberculosisDis.addTreatment(tuberculosisTr1.getName());
tuberculosisDis.setCode358(12);
tuberculosisDis.setICD10code("A16");


    // --------------  silicosis ---------------
// (C) OntoOO Inc Tue Oct 09 17:41:33 PDT 2001
Disease silicosisDis = new Disease(
   LR.silicosis, 
   "3 stages disease leading to lung nodular lesions due to respirable silica", 
   LR.respiratoryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   LR.maxAge, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.silicaExposure
);
silicosisDis.addSymptom(LR.confusion, "in advanced stage", 1.0f);
silicosisDis.addSymptom(LR.coughDry, "", 1.0f);
silicosisDis.addSymptom(LR.dyspnea, "", 1.0f);
silicosisDis.addSymptom(LR.hoarseness, "", 1.0f);
silicosisDis.addSymptom(LR.lethargy, "in advanced stage", 1.0f);
silicosisDis.addSymptom(LR.malaise, "", 1.0f);
silicosisDis.addSymptom(LR.respirationShallow, "in advanced stage", 1.0f);
silicosisDis.addSymptom(LR.sleepDisturbed, "", 1.0f);
silicosisDis.addSymptom(LR.tachypnea, "", 1.0f);

silicosisDis.addCausesDisease(LR.pulmonaryHypertensionHypoventilation);

silicosisDis.addCausesAbnormalCondition(LR.hypoxemia);

silicosisDis.addReference("pp 544-5");
silicosisDis.setMiscComments(
   "phases by the concentration and years of exposures:: " + 
   "acute: high 1-3, accelerated: low 10, chronic: low 20+");

Treatment silicosisTr1  = new Treatment("silicosisTr1");
silicosisTr1.addTreatmentAction(LR.chestPercussion);
silicosisTr1.addTreatmentAction(LR.ifInfectionProvideAntibiotic);
silicosisTr1.addTreatmentAction(LR.fluidIncrease);
silicosisTr1.addTreatmentAction(LR.steamInhalation);
silicosisTr1.addDrug(LR.bronchodilator);
silicosisDis.addTreatment(silicosisTr1.getName());


    // --------------  asbestosis  ---------------
// (C) OntoOO Inc Wed Oct 10 13:53:55 PDT 2001
Disease asbestosisDis = new Disease(
   LR.asbestosis, 
   "diffuse interstitial fibrosis lung damage", 
   LR.respiratoryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.regularAsbestosExposure
);
asbestosisDis.addSymptom(LR.chestPain);
asbestosisDis.addSymptom(LR.coughDry);
asbestosisDis.addSymptom(LR.dyspnea);
asbestosisDis.addSymptom(LR.tachypnea);
asbestosisDis.addSymptom(LR.weightLoss);

asbestosisDis.addCausingSet(LR.respiratoryTractInfections);

asbestosisDis.addCausesDisease(LR.corPulmonale);
// asbestosisDis.addCausesDisease(LR.heartFailureRightSided); 
asbestosisDis.addCausesDisease(LR.pulmonaryHypertension);

asbestosisDis.addCausesAbnormalCondition(LR.hypoxemia);

asbestosisDis.addReference("pp 545-7");
asbestosisDis.setMiscComments(
     "can develop even 15-20 years after asbestos exposures ended");

Treatment asbestosisTr1  = new Treatment("asbestosisTr1");
asbestosisTr1.addTreatmentAction(LR.chestPercussion);
asbestosisTr1.addTreatmentAction(LR.coughingExercise);
asbestosisTr1.addTreatmentAction(LR.fluidIncrease);
asbestosisTr1.addTreatmentAction(LR.ifInfectionProvideAntibiotic);
asbestosisTr1.addTreatmentAction(LR.bronchialDrainage);
asbestosisTr1.addDrug(LR.mucolytics);
asbestosisDis.addTreatment(asbestosisTr1.getName());


    // --------------  berylliosis  ---------------
// (C) OntoOO Inc Thu Oct 11 16:59:09 PDT 2001
Disease berylliosisDis = new Disease(
   LR.berylliosis, 
   "toxic consequences of beryllium exposure: mostly pulmonary manifestations", 
   LR.respiratoryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.respiratorySysSt, 
   LR.berylliumInhalation
);
berylliosisDis.addExternalCause(LR.berylliumSkinAbsorption);
// berylliosisDis.addCausesDisease(LR.bronchitis);

berylliosisDis.addReference("pp 547-8");
berylliosisDis.setMiscComments(
     "distinctions: acute vs chronic & inhalation vs skin absorbtion");


    // --------------  berylliosisAcute  ---------------
// (C) OntoOO Inc Mon Oct 15 12:41:07 PDT 2001
Disease berylliosisAcuteDis = new Disease(
   LR.berylliosisAcute, 
   "short term toxic results of beryllium exposure", 
   LR.respiratoryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.respiratorySysSt, 
   LR.none
);
berylliosisAcuteDis.setPrintName("berylliosis acute");
berylliosisAcuteDis.setSuperDisease(LR.berylliosis);

berylliosisAcuteDis.addSymptom(LR.chestTightness, "", 1.0f);
berylliosisAcuteDis.addSymptom(LR.coughDry, "", 1.0f);
berylliosisAcuteDis.addSymptom(LR.noseMucosaSwelling);
berylliosisAcuteDis.addSymptom(LR.noseMucosaUlceration);
berylliosisAcuteDis.addSymptom(LR.rashItchy);
berylliosisAcuteDis.addSymptom(LR.substernalPain, "", 1.0f);
berylliosisAcuteDis.addSymptom(LR.tachycardia, "", 1.0f);
berylliosisAcuteDis.addSymptom(LR.noseSeptumPerforation);

berylliosisAcuteDis.addCausesAbnormalCondition(LR.hypoxemia);
berylliosisAcuteDis.addCausesAbnormalCondition(LR.tracheitis);
berylliosisAcuteDis.addCausesAbnormalCondition(LR.respiratoryFailure);

berylliosisAcuteDis.addReference("pp 547-8");
berylliosisAcuteDis.setMiscComments(
     "accidental implantation of beryllium in the skin causes a beryllium ulcer");

Treatment berylliosisAcuteTr1 = 
     new Treatment("berylliosisAcuteTr1", LR.ifBerylliumUlcer);
berylliosisAcuteTr1.addTreatmentAction(LR.excision);
berylliosisAcuteDis.addTreatment(berylliosisAcuteTr1.getName()); 
Treatment berylliosisAcuteTr2  = new Treatment("berylliosisAcuteTr2");
berylliosisAcuteTr2.addDrug(LR.corticosteroids);
berylliosisAcuteDis.addTreatment(berylliosisAcuteTr2.getName());


    // --------------  berylliosisChronic  ---------------
// (C) OntoOO Inc Mon Oct 15 19:25:13 PDT 2001
Disease berylliosisChronicDis = new Disease(
   LR.berylliosisChronic, 
   "long term consequence of beryllium exposure", 
   LR.respiratoryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.none
);
berylliosisChronicDis.setPrintName("berylliosis chronic");
berylliosisChronicDis.setSuperDisease(LR.berylliosis);

berylliosisChronicDis.addSymptom(LR.anorexia, "", 1.0f);
berylliosisChronicDis.addSymptom(LR.chestPain, "", 1.0f);
berylliosisChronicDis.addSymptom(LR.coughDry, "", 1.0f);
berylliosisChronicDis.addSymptom(LR.dyspnea, "", 1.0f);
berylliosisChronicDis.addSymptom(LR.fatigue, "", 1.0f);
berylliosisChronicDis.addSymptom(LR.tachypnea, "", 1.0f);

berylliosisChronicDis.addCausesDisease(LR.corPulmonale);
berylliosisChronicDis.addCausesDisease(LR.pneumothorax);
berylliosisChronicDis.addCausesDisease(LR.pulmonaryHypertension);
berylliosisChronicDis.addCausesDisease(LR.renalCalculi);

berylliosisChronicDis.addCausesAbnormalCondition(LR.splenomegaly);

berylliosisChronicDis.addReference("pp 547-8");
berylliosisChronicDis.setMiscComments(
     "10% of patients with acute beryliosis develop " +
     "10-15 year later chronic complications");

Treatment berylliosisChronicTr1 = new Treatment("berylliosisChronicTr1");
berylliosisChronicTr1.addDrug(LR.corticosteroids);
berylliosisChronicDis.addTreatment(berylliosisChronicTr1.getName()); 


    // --------------  coalWorkerPneumoconiosis  ---------------
// (C) OntoOO Inc Tue Oct 16 16:21:23 PDT 2001
Disease coalWorkerPneumoconiosisDis = new Disease(
   LR.coalWorkerPneumoconiosis, 
   "lung destruction due to inhalation of coal dust", 
   LR.respiratoryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.lungsSysSt, 
   LR.coalDustInhalation
);
coalWorkerPneumoconiosisDis.setPrintName("coal worker pneumoconiosis");

coalWorkerPneumoconiosisDis.addSymptom(LR.cough);
coalWorkerPneumoconiosisDis.addSymptom(LR.coughProductive);
coalWorkerPneumoconiosisDis.addSymptom(LR.dyspnea);
coalWorkerPneumoconiosisDis.addSymptom(LR.sputumBlack);
coalWorkerPneumoconiosisDis.addSymptom(LR.sputumGray);
coalWorkerPneumoconiosisDis.addSymptom(LR.sputumYellowGreenThick);

coalWorkerPneumoconiosisDis.addCausesDisease(LR.chronicBronchitis);
coalWorkerPneumoconiosisDis.addCausesDisease(LR.corPulmonale);
coalWorkerPneumoconiosisDis.addCausesDisease(LR.emphysema);
coalWorkerPneumoconiosisDis.addCausesDisease(LR.pulmonaryHypertension);
coalWorkerPneumoconiosisDis.addCausesDisease(LR.tuberculosis);

coalWorkerPneumoconiosisDis.addCausesAbnormalCondition(LR.hypoxemia);

coalWorkerPneumoconiosisDis.addReference("pp 548-9");
coalWorkerPneumoconiosisDis.setMiscComments(
    "disease becomes pronounced after +- 15 years of exposure");

Treatment coalWorkerPneumoconiosisTr1 = 
    new Treatment("coalWorkerPneumoconiosisTr1");
coalWorkerPneumoconiosisTr1.addTreatmentAction(LR.bronchialDrainage);
coalWorkerPneumoconiosisTr1.addTreatmentAction(LR.chestPercussion);
coalWorkerPneumoconiosisTr1.addTreatmentAction(LR.coughingExercise);
coalWorkerPneumoconiosisTr1.addTreatmentAction(LR.fluidIncrease);
coalWorkerPneumoconiosisTr1.addDrug(LR.bronchodilator);
coalWorkerPneumoconiosisTr1.addDrug(LR.mucolytics);
coalWorkerPneumoconiosisDis.addTreatment(coalWorkerPneumoconiosisTr1.getName()); 


    // --------------  respiratoryFailureAcute  ---------------
// (C) OntoOO Inc Wed Oct 24 18:34:19 PDT 2001
Disease respiratoryFailureAcuteDis = new Disease(
   LR.respiratoryFailureAcute, 
   "respiratory failure acute", 
   LR.respiratoryDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.respiratorySysSt, 
   LR.none
);
respiratoryFailureAcuteDis.setPrintName();

respiratoryFailureAcuteDis.addSymptom(LR.airHunger, "", 1.0f);
respiratoryFailureAcuteDis.addSymptom(LR.confusion, "", 1.0f);
respiratoryFailureAcuteDis.addSymptom(LR.consciousnessDecreased, "", 1.0f);
respiratoryFailureAcuteDis.addSymptom(LR.cyanosis, "", 1.0f);
respiratoryFailureAcuteDis.addSymptom(LR.irritability, "", 1.0f);
respiratoryFailureAcuteDis.addSymptom(LR.respirationDeep, "", 0.5f);
respiratoryFailureAcuteDis.addSymptom(LR.respirationShallow, "", 0.5f);
respiratoryFailureAcuteDis.addSymptom(LR.respirationSporadic, "", 1.0f);
respiratoryFailureAcuteDis.addSymptom(LR.tachycardia, "", 1.0f);

respiratoryFailureAcuteDis.addInternalCause(LR.muscularDystrophyBecker);
respiratoryFailureAcuteDis.addInternalCause(LR.muscularDystrophyDuchenne);
respiratoryFailureAcuteDis.addCausesDisease(LR.pulmonaryHypertension);

respiratoryFailureAcuteDis.addReference("pp 0");

Treatment respiratoryFailureAcuteTr1 = new Treatment("respiratoryFailureAcuteTr1");
respiratoryFailureAcuteTr1.addTreatmentAction(LR.bedRest);
respiratoryFailureAcuteTr1.addTreatmentAction(LR.fluidManagement);
respiratoryFailureAcuteTr1.addTreatmentAction(LR.oxygenTherapy);
respiratoryFailureAcuteTr1.addDrug(LR.antibiotics);
respiratoryFailureAcuteDis.addTreatment(respiratoryFailureAcuteTr1.getName()); 


/*
Common.println("***** InitRespiratoryDiseases items ...");

laryngitisDis.printDisease();

BodySystem larynxSys = Common.getBodySystem(LR.larynxSysSt);
larynxSys.printBodySystem();

croupTr1.printTreatment();

Location loc = Common.getLocation(LR.larynxSt);
loc.printLocation();

hypoxemia.printAbnormalCondition();

pneumoniaDis.printDisease();

influenzaDis.printDisease();
pneumoniaAdenoVirusDis.printDisease();
pneumoniaSyncytialVirusDis.printDisease();
measlesDis.printDisease();
chickenpoxDis.printDisease();
pneumoniaCytomegaloVirusDis.printDisease();
pneumoniaStreptococcusDis.printDisease();
pneumoniaKlebsiellaDis.printDisease();
pneumoniaStaphylococcusDis.printDisease();
pneumocystisCariniiDis.printDisease();
pneumoniaAspirationDis.printDisease();

Common.println("");
Location body = Common.getLocation(LR.bodySt);
body.printLocation();
aRFinchronicObstructivePulmonaryDiseasecnsDis.printDisease();
*/

   } // end of doit()


} // end of InitRespiratoryDiseases
