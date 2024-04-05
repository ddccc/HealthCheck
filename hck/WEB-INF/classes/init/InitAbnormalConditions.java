// (C) OntoOO Inc 2000
package init;

import com.Common;
import com.LR;
import com.L;
import concepts.AbnormalCondition;
import concepts.Treatment;

public class InitAbnormalConditions {

  public static void doit() {

    Common.createTheAbnormalConditions();
    Common.setTheAbnormalConditionsLoaded(true);

// ------------- acidosis  -------------
AbnormalCondition acidosis = new AbnormalCondition(
    LR.acidosis,
    L.acidosisDescription,
    LR.bloodstreamSt
);
acidosis.setPrintName(L.acidosisPrintName);

// ------------- adrenalTumor  -------------
AbnormalCondition adrenalTumor = new AbnormalCondition(
    LR.adrenalTumor,
    L.adrenalTumorDescription,
    LR.adrenalsSt
);
adrenalTumor.setPrintName(L.adrenalTumorPrintName);

// ------------- airwayObstruction  -------------
AbnormalCondition airwayObstruction = new AbnormalCondition(
    LR.airwayObstruction,
    L.airwayObstructionDescription,
    LR.tracheaSt
);
airwayObstruction.setPrintName(L.airwayObstructionPrintName);

// ------------- anovulation  -------------
AbnormalCondition anovulation = new AbnormalCondition(
    LR.anovulation,
    L.anovulationDescription,
    LR.ovariesSt
);
anovulation.setPrintName(L.anovulationPrintName);

// -------------- areflexia --------------
// (C) OntoOO Inc Mon Apr 12 09:23:04 PDT 2004
AbnormalCondition areflexia = new AbnormalCondition(
    LR.areflexia,
    L.areflexiaDescription,
    LR.nervesSt
);
areflexia.setPrintName(L.areflexiaPrintName);

// ------------- ascites  -------------
AbnormalCondition ascites = new AbnormalCondition(
    LR.ascites,
    L.ascitesDescription,
    LR.abdomenSt
);
ascites.setPrintName(L.ascitesPrintName);

// ------------- atherosclerosis  -------------
AbnormalCondition atherosclerosis = new AbnormalCondition(
    LR.atherosclerosis,
    L.atherosclerosisDescription,
    LR.aVeinSt
);
atherosclerosis.setPrintName(L.atherosclerosisPrintName);

// ------------- atrialFibrillation  -------------
AbnormalCondition atrialFibrillation = new AbnormalCondition(
    LR.atrialFibrillation,
    L.atrialFibrillationDescription,
    LR.heartSt
);
atrialFibrillation.setPrintName(L.atrialFibrillationPrintName);

// ------------- atrioventricularHeartBlock  -------------
AbnormalCondition atrioventricularHeartBlock = new AbnormalCondition(
    LR.atrioventricularHeartBlock,
    L.atrioventricularHeartBlockDescription,
    LR.heartSt
);
atrioventricularHeartBlock.setPrintName(L.atrioventricularHeartBlockPrintName);

// ------------- azotemia  -------------
AbnormalCondition azotemia = new AbnormalCondition(
    LR.azotemia,
    L.azotemiaDescription,
    LR.bloodstreamSt
);
azotemia.setPrintName(L.azotemiaPrintName);

// -------------- bacteriuria --------------
// (C) OntoOO Inc Mon Aug 30 16:36:08 GMT-08:00 2004
AbnormalCondition bacteriuria = new AbnormalCondition(
    LR.bacteriuria,
    L.bacteriuriaDescription,
    LR.bladderSt
);
bacteriuria.setPrintName(L.bacteriuriaPrintName);

// ------------- blindness  -------------
AbnormalCondition blindness = new AbnormalCondition(
    LR.blindness,
    L.blindnessDescription,
    LR.eyesSt
);
blindness.setPrintName(L.blindnessPrintName);

// ------------- bloodDyscrasias  -------------
AbnormalCondition bloodDyscrasias = new AbnormalCondition(
    LR.bloodDyscrasias,
    L.bloodDyscrasiasDescription,
    LR.bloodstreamSt
);
bloodDyscrasias.setPrintName(L.bloodDyscrasiasPrintName);

// ------------- bloodPressureDifferences  -------------
AbnormalCondition bloodPressureDifferences = new AbnormalCondition(
    LR.bloodPressureDifferences,
    L.bloodPressureDifferencesDescription,
    LR.bloodstreamSt
);
bloodPressureDifferences.setPrintName(L.bloodPressureDifferencesPrintName);

// ------------- brainLesion  -------------
AbnormalCondition brainLesion = new AbnormalCondition(
    LR.brainLesion,
    L.brainLesionDescription,
    LR.brainSt
);
brainLesion.setPrintName(L.brainLesionPrintName);

// ------------- bronchialMucusPlugs  -------------
AbnormalCondition bronchialMucusPlugs = new AbnormalCondition(
    LR.bronchialMucusPlugs,
    L.bronchialMucusPlugsDescription,
    LR.lungsSt
);
bronchialMucusPlugs.setPrintName(L.bronchialMucusPlugsPrintName);

// ------------- cardiacEnlargement  -------------
AbnormalCondition cardiacEnlargement = new AbnormalCondition(
    LR.cardiacEnlargement,
    L.cardiacEnlargementDescription,
    LR.heartSt
);
cardiacEnlargement.setPrintName(L.cardiacEnlargementPrintName);

// ------------- centralNervousSystemDepression  -------------
AbnormalCondition centralNervousSystemDepression = new AbnormalCondition(
    LR.centralNervousSystemDepression,
    L.centralNervousSystemDepressionDescription,
    LR.brainSt
);
centralNervousSystemDepression.setPrintName(L.centralNervousSystemDepressionPrintName);

// ------------- circulatoryFailure  -------------
AbnormalCondition circulatoryFailure = new AbnormalCondition(
    LR.circulatoryFailure,
    L.circulatoryFailureDescription,
    LR.bloodstreamSt
);
circulatoryFailure.setPrintName(L.circulatoryFailurePrintName);

// ------------- cranialNerveDysfunction  -------------
AbnormalCondition cranialNerveDysfunction = new AbnormalCondition(
    LR.cranialNerveDysfunction,
    L.cranialNerveDysfunctionDescription,
    LR.brainSt
);
cranialNerveDysfunction.setPrintName(L.cranialNerveDysfunctionPrintName);

// ------------- death  -------------
AbnormalCondition death = new AbnormalCondition(
    LR.death,
    L.deathDescription,
    LR.bodySt
);
death.setPrintName(L.deathPrintName);

// ------------- diastolicMurmurs  -------------
AbnormalCondition diastolicMurmurs = new AbnormalCondition(
    LR.diastolicMurmurs,
    L.diastolicMurmursDescription,
    LR.heartSt
);
diastolicMurmurs.setPrintName(L.diastolicMurmursPrintName);

// ------------- electrolyteImbalance  -------------
AbnormalCondition electrolyteImbalance = new AbnormalCondition(
    LR.electrolyteImbalance,
    L.electrolyteImbalanceDescription,
    LR.bloodstreamSt
);
electrolyteImbalance.setPrintName(L.electrolyteImbalancePrintName);

// ------------- empyema  -------------
AbnormalCondition empyema = new AbnormalCondition(
    LR.empyema,
    L.empyemaDescription,
    LR.bodySt
);
empyema.setPrintName(L.empyemaPrintName);

// ------------- glycosuria  -------------
AbnormalCondition glycosuria = new AbnormalCondition(
    LR.glycosuria,
    L.glycosuriaDescription,
    LR.bladderSt
);
glycosuria.setPrintName(L.glycosuriaPrintName);

// ------------- hepaticFailure  -------------
AbnormalCondition hepaticFailure = new AbnormalCondition(
    LR.hepaticFailure,
    L.hepaticFailureDescription,
    LR.liverSt
);
hepaticFailure.setPrintName(L.hepaticFailurePrintName);

// ------------- hepatoJugularReflux  -------------
AbnormalCondition hepatoJugularReflux = new AbnormalCondition(
    LR.hepatoJugularReflux,
    L.hepatoJugularRefluxDescription,
    LR.liverSt
);
hepatoJugularReflux.setPrintName(L.hepatoJugularRefluxPrintName);

// ------------- hepatomegaly  -------------
AbnormalCondition hepatomegaly = new AbnormalCondition(
    LR.hepatomegaly,
    L.hepatomegalyDescription,
    LR.liverSt
);
hepatomegaly.setPrintName(L.hepatomegalyPrintName);

// ------------- hipDeformity  -------------
AbnormalCondition hipDeformity = new AbnormalCondition(
    LR.hipDeformity,
    L.hipDeformityDescription,
    LR.hipsSt
);
hipDeformity.setPrintName(L.hipDeformityPrintName);

// ------------- hypercalcemia  -------------
AbnormalCondition hypercalcemia = new AbnormalCondition(
    LR.hypercalcemia,
    L.hypercalcemiaDescription,
    LR.bloodstreamSt
);
hypercalcemia.setPrintName(L.hypercalcemiaPrintName);

// ------------- hypercalciuria  -------------
AbnormalCondition hypercalciuria = new AbnormalCondition(
    LR.hypercalciuria,
    L.hypercalciuriaDescription,
    LR.kidneysSt
);
hypercalciuria.setPrintName(L.hypercalciuriaPrintName);
hypercalciuria.setWebResource("http://google.yahoo.com/bin/query?p=hypercalciuria&hc=0&hs=0");

// ------------- hyperglycemia  -------------
AbnormalCondition hyperglycemia = new AbnormalCondition(
    LR.hyperglycemia,
    L.hyperglycemiaDescription,
    LR.bloodstreamSt
);
hyperglycemia.setPrintName(L.hyperglycemiaPrintName);

// ------------- hypervolemia  -------------
AbnormalCondition hypervolemia = new AbnormalCondition(
    LR.hypervolemia,
    L.hypervolemiaDescription,
    LR.bloodstreamSt
);
hypervolemia.setPrintName(L.hypervolemiaPrintName);

// ------------- hypoglycemia  -------------
AbnormalCondition hypoglycemia = new AbnormalCondition(
    LR.hypoglycemia,
    L.hypoglycemiaDescription,
    LR.bloodstreamSt
);
hypoglycemia.setPrintName(L.hypoglycemiaPrintName);

// -------------- hypotonia --------------
// (C) OntoOO Inc Mon Apr 12 09:20:46 PDT 2004
AbnormalCondition hypotonia = new AbnormalCondition(
    LR.hypotonia,
    L.hypotoniaDescription,
    LR.aMuscleSt
);
hypotonia.setPrintName(L.hypotoniaPrintName);

// ------------- hypovolemia  -------------
AbnormalCondition hypovolemia = new AbnormalCondition(
    LR.hypovolemia,
    L.hypovolemiaDescription,
    LR.bloodstreamSt
);
hypovolemia.setPrintName(L.hypovolemiaPrintName);

// ------------- hypoxemia  -------------
AbnormalCondition hypoxemia = new AbnormalCondition(
    LR.hypoxemia,
    L.hypoxemiaDescription,
    LR.bloodstreamSt
);
hypoxemia.setPrintName(L.hypoxemiaPrintName);
    Treatment hypoxemiaTr1 = new Treatment("hypoxemiaTr1");
    hypoxemiaTr1.addTreatmentAction(LR.oxygenTherapy);
    hypoxemia.addTreatment("hypoxemiaTr1");

// ------------- hypoxia  -------------
AbnormalCondition hypoxia = new AbnormalCondition(
    LR.hypoxia,
    L.hypoxiaDescription,
    LR.bodySt
);
hypoxia.setPrintName(L.hypoxiaPrintName);
hypoxia.addTreatment("hypoxemiaTr1");

// ------------- infectionsSevere  -------------
AbnormalCondition infectionsSevere = new AbnormalCondition(
    LR.infectionsSevere,
    L.infectionsSevereDescription,
    LR.bodySt
);
infectionsSevere.setPrintName(L.infectionsSeverePrintName);

// ------------- lactating  -------------
AbnormalCondition lactating = new AbnormalCondition(
    LR.lactating,
    L.lactatingDescription,
    LR.breastsFemaleSt
);
lactating.setPrintName(L.lactatingPrintName);

// ------------- leftVentricularDysfunction  -------------
AbnormalCondition leftVentricularDysfunction = new AbnormalCondition(
    LR.leftVentricularDysfunction,
    L.leftVentricularDysfunctionDescription,
    LR.heartSt
);
leftVentricularDysfunction.setPrintName(L.leftVentricularDysfunctionPrintName);

// ------------- leukocytosis  -------------
AbnormalCondition leukocytosis = new AbnormalCondition(
    LR.leukocytosis,
    L.leukocytosisDescription,
    LR.bloodstreamSt
);
leukocytosis.setPrintName(L.leukocytosisPrintName);

// -------------- leukopenia --------------
// (C) OntoOO Inc Sat May 15 15:24:28 PDT 2004
AbnormalCondition leukopenia = new AbnormalCondition(
    LR.leukopenia,
    L.leukopeniaDescription,
    LR.bloodstreamSt
);
leukopenia.setPrintName(L.leukopeniaPrintName);

// ------------- lowFertility  -------------
AbnormalCondition lowFertility = new AbnormalCondition(
    LR.lowFertility,
    L.lowFertilityDescription,
    LR.bodySt
);
lowFertility.setPrintName(L.lowFertilityPrintName);

// ------------- malnutrition  -------------
AbnormalCondition malnutrition = new AbnormalCondition(
    LR.malnutrition,
    L.malnutritionDescription,
    LR.bodySt
);
malnutrition.setPrintName(L.malnutritionPrintName);

// ------------- microEmboli  -------------
AbnormalCondition microEmboli = new AbnormalCondition(
    LR.microEmboli,
    L.microEmboliDescription,
    LR.lungsSt
);
microEmboli.setPrintName(L.microEmboliPrintName);

// ------------- myocardialHypoxia  -------------
AbnormalCondition myocardialHypoxia = new AbnormalCondition(
    LR.myocardialHypoxia,
    L.myocardialHypoxiaDescription,
    LR.bodySt
);
myocardialHypoxia.setPrintName(L.myocardialHypoxiaPrintName);

// ------------- neurologicDeficiences  -------------
AbnormalCondition neurologicDeficiences = new AbnormalCondition(
    LR.neurologicDeficiences,
    L.neurologicDeficiencesDescription,
    LR.nervesSt
);
neurologicDeficiences.setPrintName(L.neurologicDeficiencesPrintName);

// ------------- neuropathy  -------------
AbnormalCondition neuropathy = new AbnormalCondition(
    LR.neuropathy,
    L.neuropathyDescription,
    LR.nervesSt
);
neuropathy.setPrintName(L.neuropathyPrintName);

/* change into disease
// ------------- obesity  -------------
AbnormalCondition obesity = new AbnormalCondition(
    LR.obesity,
    L.obesityDescription,
    LR.bodySt
);
obesity.setPrintName(L.obesityPrintName);
*/

// ------------- obesityHypoVentilation  -------------
AbnormalCondition obesityHypoVentilation = new AbnormalCondition(
    LR.obesityHypoVentilation,
    L.obesityHypoVentilationDescription,
    LR.lungsSt
);
obesityHypoVentilation.setPrintName(L.obesityHypoVentilationPrintName);

// ------------- ovariesTumor  -------------
AbnormalCondition ovariesTumor = new AbnormalCondition(
    LR.ovariesTumor,
    L.ovariesTumorDescription,
    LR.ovariesSt
);
ovariesTumor.setPrintName(L.ovariesTumorPrintName);

// ------------- pericardialFrictionRub  -------------
AbnormalCondition pericardialFrictionRub = new AbnormalCondition(
    LR.pericardialFrictionRub,
    L.pericardialFrictionRubDescription,
    LR.pericardiumSt
);
pericardialFrictionRub.setPrintName(L.pericardialFrictionRubPrintName);

// ------------- pleuralEffusion  -------------
AbnormalCondition pleuralEffusion = new AbnormalCondition(
    LR.pleuralEffusion,
    L.pleuralEffusionDescription,
    LR.pleuraSt
);
pleuralEffusion.setPrintName(L.pleuralEffusionPrintName);

// ------------- pleuralEffusionLeft  -------------
AbnormalCondition pleuralEffusionLeft = new AbnormalCondition(
    LR.pleuralEffusionLeft,
    L.pleuralEffusionLeftDescription,
    LR.pleuraSt
);
pleuralEffusionLeft.setPrintName(L.pleuralEffusionLeftPrintName);

// ------------- pleuralSpaceRupture  -------------
AbnormalCondition pleuralSpaceRupture = new AbnormalCondition(
    LR.pleuralSpaceRupture,
    L.pleuralSpaceRuptureDescription,
    LR.lungsSt
);
pleuralSpaceRupture.setPrintName(L.pleuralSpaceRupturePrintName);

// ------------- polyhydramnios  -------------
AbnormalCondition polyhydramnios = new AbnormalCondition(
    LR.polyhydramnios,
    L.polyhydramniosDescription,
    LR.uterusSt
);
polyhydramnios.setPrintName(L.polyhydramniosPrintName);

// ------------- pregnancy  -------------
AbnormalCondition pregnancy = new AbnormalCondition(
    LR.pregnancy,
    L.pregnancyDescription,
    LR.bodySt
);
pregnancy.setPrintName(L.pregnancyPrintName);

// ------------- prostateEnlarged  -------------
AbnormalCondition prostateEnlarged = new AbnormalCondition(
    LR.prostateEnlarged,
    L.prostateEnlargedDescription,
    LR.prostateSt
);
prostateEnlarged.setPrintName(L.prostateEnlargedPrintName);

// ------------- prostateFirm  -------------
AbnormalCondition prostateFirm = new AbnormalCondition(
    LR.prostateFirm,
    L.prostateFirmDescription,
    LR.prostateSt
);
prostateFirm.setPrintName(L.prostateFirmPrintName);

// ------------- prostateSwollen  -------------
AbnormalCondition prostateSwollen = new AbnormalCondition(
    LR.prostateSwollen,
    L.prostateSwollenDescription,
    LR.prostateSt
);
prostateSwollen.setPrintName(L.prostateSwollenPrintName);

// ------------- prostateTender  -------------
AbnormalCondition prostateTender = new AbnormalCondition(
    LR.prostateTender,
    L.prostateTenderDescription,
    LR.prostateSt
);
prostateTender.setPrintName(L.prostateTenderPrintName);

// ------------- proteinuria  -------------
AbnormalCondition proteinuria = new AbnormalCondition(
    LR.proteinuria,
    L.proteinuriaDescription,
    LR.bladderSt
);
proteinuria.setPrintName(L.proteinuriaPrintName);

// ------------- psychicTraumaSevere  -------------
AbnormalCondition psychicTraumaSevere = new AbnormalCondition(
    LR.psychicTraumaSevere,
    L.psychicTraumaSevereDescription,
    LR.mindSt
);
psychicTraumaSevere.setPrintName(L.psychicTraumaSeverePrintName);

// ------------- pulmonaryFailure  -------------
AbnormalCondition pulmonaryFailure = new AbnormalCondition(
    LR.pulmonaryFailure,
    L.pulmonaryFailureDescription,
    LR.lungsSt
);
pulmonaryFailure.setPrintName(L.pulmonaryFailurePrintName);

// ------------- recurrentRespiratoryTractInfections  -------------
AbnormalCondition recurrentRespiratoryTractInfections = new AbnormalCondition(
    LR.recurrentRespiratoryTractInfections,
    L.recurrentRespiratoryTractInfectionsDescription,
    LR.lungsSt
);
recurrentRespiratoryTractInfections.setPrintName(L.recurrentRespiratoryTractInfectionsPrintName);

// ------------- respiratoryFailure  -------------
AbnormalCondition respiratoryFailure = new AbnormalCondition(
    LR.respiratoryFailure,
    L.respiratoryFailureDescription,
    LR.lungsSt
);
respiratoryFailure.setPrintName(L.respiratoryFailurePrintName);
    Treatment respiratoryFailureTr1 = new Treatment("respiratoryFailureTr1");
    respiratoryFailureTr1.addTreatmentAction(LR.mechanicalVentilation);
    respiratoryFailure.addTreatment("respiratoryFailureTr1");
// ------------- ribFracture  -------------
AbnormalCondition ribFracture = new AbnormalCondition(
    LR.ribFracture,
    L.ribFractureDescription,
    LR.ribCageSt
);
ribFracture.setPrintName(L.ribFracturePrintName);

// ------------- sepsis  -------------
AbnormalCondition sepsis = new AbnormalCondition(
    LR.sepsis,
    L.sepsisDescription,
    LR.bodySt
);
sepsis.setPrintName(L.sepsisPrintName);

// ------------- shock  -------------
AbnormalCondition shock = new AbnormalCondition(
    LR.shock,
    L.shockDescription,
    LR.bodySt
);
shock.setPrintName(L.shockPrintName);

// ------------- spinalCordLesionAboveC6  -------------
AbnormalCondition spinalCordLesionAboveC6 = new AbnormalCondition(
    LR.spinalCordLesionAboveC6,
    L.spinalCordLesionAboveC6Description,
    LR.spineSt
);
spinalCordLesionAboveC6.setPrintName(L.spinalCordLesionAboveC6PrintName);

// ------------- spineJointDegeneration  -------------
AbnormalCondition spineJointDegeneration = new AbnormalCondition(
    LR.spineJointDegeneration,
    L.spineJointDegenerationDescription,
    LR.spineSt
);
spineJointDegeneration.setPrintName(L.spineJointDegenerationPrintName);

// ------------- splenomegaly  -------------
AbnormalCondition splenomegaly = new AbnormalCondition(
    LR.splenomegaly,
    L.splenomegalyDescription,
    LR.spleenSt
);
splenomegaly.setPrintName(L.splenomegalyPrintName);

// ------------- systemicEmbolization  -------------
AbnormalCondition systemicEmbolization = new AbnormalCondition(
    LR.systemicEmbolization,
    L.systemicEmbolizationDescription,
    LR.bloodstreamSt
);
systemicEmbolization.setPrintName(L.systemicEmbolizationPrintName);

AbnormalCondition thrombocytopenia = new AbnormalCondition(
    LR.thrombocytopenia,
    L.thrombocytopeniaDescription,
    LR.bloodstreamSt
);
thrombocytopenia.setPrintName(L.thrombocytopeniaPrintName);

// ------------- thrombocytosis  -------------
AbnormalCondition thrombocytosis = new AbnormalCondition(
    LR.thrombocytosis,
    L.thrombocytosisDescription,
    LR.aVeinSt
);
thrombocytosis.setPrintName(L.thrombocytosisPrintName);

// ------------- tracheitis  -------------
AbnormalCondition tracheitis = new AbnormalCondition(
    LR.tracheitis,
    L.tracheitisDescription,
    LR.tracheaSt
);
tracheitis.setPrintName(L.tracheitisPrintName);

// ------------- upperAirwayObstruction  -------------
AbnormalCondition upperAirwayObstruction = new AbnormalCondition(
    LR.upperAirwayObstruction,
    L.upperAirwayObstructionDescription,
    LR.bodySt
);
upperAirwayObstruction.setPrintName(L.upperAirwayObstructionPrintName);

// ------------- uremia  -------------
AbnormalCondition uremia = new AbnormalCondition(
    LR.uremia,
    L.uremiaDescription,
    LR.bloodstreamSt
);
uremia.setPrintName(L.uremiaPrintName);

// ------------- uterusRupture  -------------
AbnormalCondition uterusRupture = new AbnormalCondition(
    LR.uterusRupture,
    L.uterusRuptureDescription,
    LR.uterusSt
);
uterusRupture.setPrintName(L.uterusRupturePrintName);

// ------------- uterusTumors  -------------
AbnormalCondition uterusTumors = new AbnormalCondition(
    LR.uterusTumors,
    L.uterusTumorsDescription,
    LR.uterusSt
);
uterusTumors.setPrintName(L.uterusTumorsPrintName);

// ------------- valvularInsufficiency  -------------
AbnormalCondition valvularInsufficiency = new AbnormalCondition(
    LR.valvularInsufficiency,
    L.valvularInsufficiencyDescription,
    LR.heartSt
);
valvularInsufficiency.setPrintName(L.valvularInsufficiencyPrintName);

// ------------- varicoseVeins  -------------
AbnormalCondition varicoseVeins = new AbnormalCondition(
    LR.varicoseVeins,
    L.varicoseVeinsDescription,
    LR.aVeinSt
);
varicoseVeins.setPrintName(L.varicoseVeinsPrintName);

// ------------- vascularCollapse  -------------
AbnormalCondition vascularCollapse = new AbnormalCondition(
    LR.vascularCollapse,
    L.vascularCollapseDescription,
    LR.aVeinSt
);
vascularCollapse.setPrintName(L.vascularCollapsePrintName);


  } // end doit()

} // end InitAbnormalConditions
