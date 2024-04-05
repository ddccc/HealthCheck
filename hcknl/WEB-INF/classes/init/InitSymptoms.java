// (C) OntoOO Dennis de Champeaux 2000, 2012
package init;


import com.Common;
import com.LR;
import com.L;
import concepts.Symptom;


public class InitSymptoms {
  public static void doit() {

    Common.createTheSymptoms();
    Common.setTheSymptomsLoaded(true);

    /*
      The printname of a symptom is by default equal to the LR.string name
      The printname can be set explicitly with: 
            .setPrintName(<String>)
      The printname can be set to the description (2nd argument) with:
            .setPrintName()
      */

// ------------- abdomenBloating  -------------
Symptom abdomenBloating = new Symptom(
    LR.abdomenBloating,
    L.abdomenBloatingDescription,
    LR.abdomenSt
);
abdomenBloating.setPrintName(L.abdomenBloatingPrintName);

// ------------- abdomenCramping  -------------
Symptom abdomenCramping = new Symptom(
    LR.abdomenCramping,
    L.abdomenCrampingDescription,
    LR.abdomenSt
);
abdomenCramping.setPrintName(L.abdomenCrampingPrintName);

// ------------- abdomenDistension  -------------
Symptom abdomenDistension = new Symptom(
    LR.abdomenDistension,
    L.abdomenDistensionDescription,
    LR.abdomenSt
);
abdomenDistension.setPrintName(L.abdomenDistensionPrintName);

// ------------- abdomenMassPalpable  -------------
Symptom abdomenMassPalpable = new Symptom(
    LR.abdomenMassPalpable,
    L.abdomenMassPalpableDescription,
    LR.abdomenSt
);
abdomenMassPalpable.setPrintName(L.abdomenMassPalpablePrintName);

// ------------- abdomenPain  -------------
Symptom abdomenPain = new Symptom(
    LR.abdomenPain,
    L.abdomenPainDescription,
    LR.abdomenSt
);
abdomenPain.setPrintName(L.abdomenPainPrintName);

// ------------- abdomenPainLowerLeftSide  -------------
Symptom abdomenPainLowerLeftSide = new Symptom(
    LR.abdomenPainLowerLeftSide,
    L.abdomenPainLowerLeftSideDescription,
    LR.abdomenSt
);
abdomenPainLowerLeftSide.setPrintName(L.abdomenPainLowerLeftSidePrintName);

// -------------- abdomenPainLowerRightSide --------------
// (C) OntoOO Inc Thu Oct 02 12:46:39 PDT 2008
Symptom abdomenPainLowerRightSide = new Symptom(
    LR.abdomenPainLowerRightSide,
    L.abdomenPainLowerRightSideDescription,
    LR.abdomenSt
);
abdomenPainLowerRightSide.setPrintName(L.abdomenPainLowerRightSidePrintName);

// ------------- abdomenPainLowerSide  -------------
Symptom abdomenPainLowerSide = new Symptom(
    LR.abdomenPainLowerSide,
    L.abdomenPainLowerSideDescription,
    LR.abdomenSt
);
abdomenPainLowerSide.setPrintName(L.abdomenPainLowerSidePrintName);

// ------------- abdomenPainSuddenSevere  -------------
Symptom abdomenPainSuddenSevere = new Symptom(
    LR.abdomenPainSuddenSevere,
    L.abdomenPainSuddenSevereDescription,
    LR.abdomenSt
);
abdomenPainSuddenSevere.setPrintName(L.abdomenPainSuddenSeverePrintName);

// -------------- abdomenPainUpperRightSide --------------
// (C) OntoOO Inc Thu Oct 02 12:46:39 PDT 2008
Symptom abdomenPainUpperRightSide = new Symptom(
    LR.abdomenPainUpperRightSide,
    L.abdomenPainUpperRightSideDescription,
    LR.abdomenSt
);
abdomenPainUpperRightSide.setPrintName(L.abdomenPainUpperRightSidePrintName);


// ------------- abdomenPainUpperSide  -------------
Symptom abdomenPainUpperSide = new Symptom(
    LR.abdomenPainUpperSide,
    L.abdomenPainUpperSideDescription,
    LR.abdomenSt
);
abdomenPainUpperSide.setPrintName(L.abdomenPainUpperSidePrintName);

// ------------- abdomenRigidity  -------------
Symptom abdomenRigidity = new Symptom(
    LR.abdomenRigidity,
    L.abdomenRigidityDescription,
    LR.abdomenSt
);
abdomenRigidity.setPrintName(L.abdomenRigidityPrintName);

// ------------- abdomenTenderness  -------------
Symptom abdomenTenderness = new Symptom(
    LR.abdomenTenderness,
    L.abdomenTendernessDescription,
    LR.abdomenSt
);
abdomenTenderness.setPrintName(L.abdomenTendernessPrintName);

// ------------- abortionSpontaneous  -------------
Symptom abortionSpontaneous = new Symptom(
    LR.abortionSpontaneous,
    L.abortionSpontaneousDescription,
    LR.bodySt
);
abortionSpontaneous.setPrintName(L.abortionSpontaneousPrintName);

// ------------- abstractThinkingImpaired  -------------
Symptom abstractThinkingImpaired = new Symptom(
    LR.abstractThinkingImpaired,
    L.abstractThinkingImpairedDescription,
    LR.mindSt
);
abstractThinkingImpaired.setPrintName(L.abstractThinkingImpairedPrintName);

// ------------- acne  -------------
Symptom acne = new Symptom(
    LR.acne,
    L.acneDescription,
    LR.faceSt
);
acne.setPrintName(L.acnePrintName);

// ------------- adultHairPattern  -------------
Symptom adultHairPattern = new Symptom(
    LR.adultHairPattern,
    L.adultHairPatternDescription,
    LR.headSt
);
adultHairPattern.setPrintName(L.adultHairPatternPrintName);

// ------------- aggression  -------------
Symptom aggression = new Symptom(
    LR.aggression,
    L.aggressionDescription,
    LR.mindSt
);
aggression.setPrintName(L.aggressionPrintName);

// ------------- agitation  -------------
Symptom agitation = new Symptom(
    LR.agitation,
    L.agitationDescription,
    LR.mindSt
);
agitation.setPrintName(L.agitationPrintName);

// ------------- airHunger  -------------
Symptom airHunger = new Symptom(
    LR.airHunger,
    L.airHungerDescription,
    LR.bodySt
);
airHunger.setPrintName(L.airHungerPrintName);

// ------------- akinesia  -------------
Symptom akinesia = new Symptom(
    LR.akinesia,
    L.akinesiaDescription,
    LR.aMuscleSt
);
akinesia.setPrintName(L.akinesiaPrintName);

// ------------- alertnessHigh  -------------
Symptom alertnessHigh = new Symptom(
    LR.alertnessHigh,
    L.alertnessHighDescription,
    LR.mindSt
);
alertnessHigh.setPrintName(L.alertnessHighPrintName);

// ------------- amnesia  -------------
Symptom amnesia = new Symptom(
    LR.amnesia,
    L.amnesiaDescription,
    LR.mindSt
);
amnesia.setPrintName(L.amnesiaPrintName);

// ------------- amnioticMembraneRupture  -------------
Symptom amnioticMembraneRupture = new Symptom(
    LR.amnioticMembraneRupture,
    L.amnioticMembraneRuptureDescription,
    LR.amnioticMembraneSt
);
amnioticMembraneRupture.setPrintName(L.amnioticMembraneRupturePrintName);

// ------------- anginaPain  -------------
Symptom anginaPain = new Symptom(
    LR.anginaPain,
    L.anginaPainDescription,
    LR.throatSt
);
anginaPain.setPrintName(L.anginaPainPrintName);

// ------------- angry  -------------
Symptom angry = new Symptom(
    LR.angry,
    L.angryDescription,
    LR.mindSt
);
angry.setPrintName(L.angryPrintName);

// ------------- anklePain  -------------
Symptom anklePain = new Symptom(
    LR.anklePain,
    L.anklePainDescription,
    LR.anklesSt
);
anklePain.setPrintName(L.anklePainPrintName);

// ------------- anorexia  -------------
Symptom anorexia = new Symptom(
    LR.anorexia,
    L.anorexiaDescription,
    LR.mindSt
);
anorexia.setPrintName(L.anorexiaPrintName);

// ------------- anuria  -------------
Symptom anuria = new Symptom(
    LR.anuria,
    L.anuriaDescription,
    LR.kidneysSt
);
anuria.setPrintName(L.anuriaPrintName);

// ------------- anusChancre  -------------
Symptom anusChancre = new Symptom(
    LR.anusChancre,
    L.anusChancreDescription,
    LR.anusSt
);
anusChancre.setPrintName(L.anusChancrePrintName);

// ------------- anusDischargeBloody  -------------
/*
Symptom anusDischargeBloody = new Symptom(
    LR.anusDischargeBloody,
    L.anusDischargeBloodyDescription,
    LR.anusSt
);
anusDischargeBloody.setPrintName(L.anusDischargeBloodyPrintName);
*/

// ------------- anusDischargeMucopurulent  -------------
Symptom anusDischargeMucopurulent = new Symptom(
    LR.anusDischargeMucopurulent,
    L.anusDischargeMucopurulentDescription,
    LR.anusSt
);
anusDischargeMucopurulent.setPrintName(L.anusDischargeMucopurulentPrintName);

// ------------- anusLesion  -------------
Symptom anusLesion = new Symptom(
    LR.anusLesion,
    L.anusLesionDescription,
    LR.anusSt
);
anusLesion.setPrintName(L.anusLesionPrintName);

// ------------- anxiety  -------------
Symptom anxiety = new Symptom(
    LR.anxiety,
    L.anxietyDescription,
    LR.mindSt
);
anxiety.setPrintName(L.anxietyPrintName);

// ------------- apathy  -------------
Symptom apathy = new Symptom(
    LR.apathy,
    L.apathyDescription,
    LR.mindSt
);
apathy.setPrintName(L.apathyPrintName);

// ------------- aphasia  -------------
Symptom aphasia = new Symptom(
    LR.aphasia,
    L.aphasiaDescription,
    LR.mindSt
);
aphasia.setPrintName(L.aphasiaPrintName);

// ------------- apnea  -------------
Symptom apnea = new Symptom(
    LR.apnea,
    L.apneaDescription,
    LR.lungsSt
);
apnea.setPrintName(L.apneaPrintName);

// ------------- appetiteIncrease  -------------
Symptom appetiteIncrease = new Symptom(
    LR.appetiteIncrease,
    L.appetiteIncreaseDescription,
    LR.bodySt
);
appetiteIncrease.setPrintName(L.appetiteIncreasePrintName);

// ------------- appetiteLoss  -------------
Symptom appetiteLoss = new Symptom(
    LR.appetiteLoss,
    L.appetiteLossDescription,
    LR.bodySt
);
appetiteLoss.setPrintName(L.appetiteLossPrintName);

// ------------- apprehension  -------------
Symptom apprehension = new Symptom(
    LR.apprehension,
    L.apprehensionDescription,
    LR.mindSt
);
apprehension.setPrintName(L.apprehensionPrintName);

// -------------- armPain --------------
// (C) OntoOO Inc Wed Oct 13 11:12:52 GMT-08:00 2004
Symptom armPain = new Symptom(
    LR.armPain,
    L.armPainDescription,
    LR.armsSt
);
armPain.setPrintName(L.armPainPrintName);

// ------------- armPitPain  -------------
Symptom armPitPain = new Symptom(
    LR.armPitPain,
    L.armPitPainDescription,
    LR.armPitsSt
);
armPitPain.setPrintName(L.armPitPainPrintName);

// ------------- armWeakness  -------------
Symptom armWeakness = new Symptom(
    LR.armWeakness,
    L.armWeaknessDescription,
    LR.armsSt
);
armWeakness.setPrintName(L.armWeaknessPrintName);

// ------------- arrhythmia  -------------
Symptom arrhythmia = new Symptom(
    LR.arrhythmia,
    L.arrhythmiaDescription,
    LR.heartSt
);
arrhythmia.setPrintName(L.arrhythmiaPrintName);

// ------------- arthralgia  -------------
Symptom arthralgia = new Symptom(
    LR.arthralgia,
    L.arthralgiaDescription,
    LR.jointsSt
);
arthralgia.setPrintName(L.arthralgiaPrintName);

// ------------- asterixis  -------------
Symptom asterixis = new Symptom(
    LR.asterixis,
    L.asterixisDescription,
    LR.aMuscleSt
);
asterixis.setPrintName(L.asterixisPrintName);

// ------------- ataxia  -------------
Symptom ataxia = new Symptom(
    LR.ataxia,
    L.ataxiaDescription,
    LR.bodySt
);
ataxia.setPrintName(L.ataxiaPrintName);

// ------------- atrophicVulvitis  -------------
Symptom atrophicVulvitis = new Symptom(
    LR.atrophicVulvitis,
    L.atrophicVulvitisDescription,
    LR.vulvaSt
);
atrophicVulvitis.setPrintName(L.atrophicVulvitisPrintName);

// ------------- backArched  -------------
Symptom backArched = new Symptom(
    LR.backArched,
    L.backArchedDescription,
    LR.backSt
);
backArched.setPrintName(L.backArchedPrintName);

// ------------- backPain  -------------
Symptom backPain = new Symptom(
    LR.backPain,
    L.backPainDescription,
    LR.backSt
);
backPain.setPrintName(L.backPainPrintName);

// ------------- backStiff  -------------
Symptom backStiff = new Symptom(
    LR.backStiff,
    L.backStiffDescription,
    LR.backSt
);
backStiff.setPrintName(L.backStiffPrintName);

// ------------- barrelChest  -------------
Symptom barrelChest = new Symptom(
    LR.barrelChest,
    L.barrelChestDescription,
    LR.chestSt
);
barrelChest.setPrintName(L.barrelChestPrintName);

// ------------- beardSkinLesions  -------------
Symptom beardSkinLesions = new Symptom(
    LR.beardSkinLesions,
    L.beardSkinLesionsDescription,
    LR.faceSt
);
beardSkinLesions.setPrintName(L.beardSkinLesionsPrintName);

// ------------- behaviorDisorganized  -------------
Symptom behaviorDisorganized = new Symptom(
    LR.behaviorDisorganized,
    L.behaviorDisorganizedDescription,
    LR.mindSt
);
behaviorDisorganized.setPrintName(L.behaviorDisorganizedPrintName);

// -------------- belching --------------
// (C) OntoOO Inc Fri Feb 20 15:41:02 PST 2004
Symptom belching = new Symptom(
    LR.belching,
    L.belchingDescription,
    LR.mouthSt
);
belching.setPrintName(L.belchingPrintName);

// ------------- bingeEating  -------------
Symptom bingeEating = new Symptom(
    LR.bingeEating,
    L.bingeEatingDescription,
    LR.mouthSt
);
bingeEating.setPrintName(L.bingeEatingPrintName);

// ------------- biteMarksRed  -------------
Symptom biteMarksRed = new Symptom(
    LR.biteMarksRed,
    L.biteMarksRedDescription,
    LR.skinSt
);
biteMarksRed.setPrintName(L.biteMarksRedPrintName);

// ------------- bladderCramp  -------------
Symptom bladderCramp = new Symptom(
    LR.bladderCramp,
    L.bladderCrampDescription,
    LR.bladderSt
);
bladderCramp.setPrintName(L.bladderCrampPrintName);

// ------------- bladderIrritability  -------------
Symptom bladderIrritability = new Symptom(
    LR.bladderIrritability,
    L.bladderIrritabilityDescription,
    LR.bladderSt
);
bladderIrritability.setPrintName(L.bladderIrritabilityPrintName); 

// ------------- bladderPain  -------------
Symptom bladderPain = new Symptom(
    LR.bladderPain,
    L.bladderPainDescription,
    LR.bladderSt
);
bladderPain.setPrintName(L.bladderPainPrintName);

// ------------- bladderPressure  -------------
Symptom bladderPressure = new Symptom(
    LR.bladderPressure,
    L.bladderPressureDescription,
    LR.bladderSt
);
bladderPressure.setPrintName(L.bladderPressurePrintName);

// ------------- bleb  -------------
Symptom bleb = new Symptom(
    LR.bleb,
    L.blebDescription,
    LR.skinSt
);
bleb.setPrintName(L.blebPrintName);

// ------------- bleedingAbnormal  -------------
Symptom bleedingAbnormal = new Symptom(
    LR.bleedingAbnormal,
    L.bleedingAbnormalDescription,
    LR.bodySt
);
bleedingAbnormal.setPrintName(L.bleedingAbnormalPrintName);

// ------------- bleedingFromMouth  -------------
Symptom bleedingFromMouth = new Symptom(
    LR.bleedingFromMouth,
    L.bleedingFromMouthDescription,
    LR.mouthSt
);
bleedingFromMouth.setPrintName(L.bleedingFromMouthPrintName);

// ------------- bleedingFromNose  -------------
Symptom bleedingFromNose = new Symptom(
    LR.bleedingFromNose,
    L.bleedingFromNoseDescription,
    LR.noseSt
);
bleedingFromNose.setPrintName(L.bleedingFromNosePrintName);

// ------------- bleedingFromRectum  -------------
Symptom bleedingFromRectum = new Symptom(
    LR.bleedingFromRectum,
    L.bleedingFromRectumDescription,
    LR.rectumSt
);
bleedingFromRectum.setPrintName(L.bleedingFromRectumPrintName);

// ------------- bleedingFromVagina  -------------
Symptom bleedingFromVagina = new Symptom(
    LR.bleedingFromVagina,
    L.bleedingFromVaginaDescription,
    LR.vaginaSt
);
bleedingFromVagina.setPrintName(L.bleedingFromVaginaPrintName);

// ------------- bleedingFromVaginaAbnormal  -------------
Symptom bleedingFromVaginaAbnormal = new Symptom(
    LR.bleedingFromVaginaAbnormal,
    L.bleedingFromVaginaAbnormalDescription,
    LR.vaginaSt
);
bleedingFromVaginaAbnormal.setPrintName(L.bleedingFromVaginaAbnormalPrintName);

// ------------- bleedingFromVaginaProfuse  -------------
Symptom bleedingFromVaginaProfuse = new Symptom(
    LR.bleedingFromVaginaProfuse,
    L.bleedingFromVaginaProfuseDescription,
    LR.vaginaSt
);
bleedingFromVaginaProfuse.setPrintName(L.bleedingFromVaginaProfusePrintName);

// ------------- bleedingFromVaginaSlight  -------------
Symptom bleedingFromVaginaSlight = new Symptom(
    LR.bleedingFromVaginaSlight,
    L.bleedingFromVaginaSlightDescription,
    LR.vaginaSt
);
bleedingFromVaginaSlight.setPrintName(L.bleedingFromVaginaSlightPrintName);

// ------------- bleedingGestation2ndHalf  -------------
Symptom bleedingGestation2ndHalf = new Symptom(
    LR.bleedingGestation2ndHalf,
    L.bleedingGestation2ndHalfDescription,
    LR.vaginaSt
);
bleedingGestation2ndHalf.setPrintName(L.bleedingGestation2ndHalfPrintName);

// ------------- bleedingProlonged  -------------
Symptom bleedingProlonged = new Symptom(
    LR.bleedingProlonged,
    L.bleedingProlongedDescription,
    LR.bodySt
);
bleedingProlonged.setPrintName(L.bleedingProlongedPrintName);

// ------------- bleedingSkull  -------------
Symptom bleedingSkull = new Symptom(
    LR.bleedingSkull,
    L.bleedingSkullDescription,
    LR.skullSt
);
bleedingSkull.setPrintName(L.bleedingSkullPrintName);

// -------------- bleedingSpontaneously --------------
// (C) OntoOO Inc Tue May 18 16:37:35 PDT 2004
Symptom bleedingSpontaneously = new Symptom(
    LR.bleedingSpontaneously,
    L.bleedingSpontaneouslyDescription,
    LR.bodySt
);
bleedingSpontaneously.setPrintName(L.bleedingSpontaneouslyPrintName);

// ------------- bleedingThirdTrimester  -------------
Symptom bleedingThirdTrimester = new Symptom(
    LR.bleedingThirdTrimester,
    L.bleedingThirdTrimesterDescription,
    LR.vaginaSt
);
bleedingThirdTrimester.setPrintName(L.bleedingThirdTrimesterPrintName);

// ------------- bleedingVulva  -------------
Symptom bleedingVulva = new Symptom(
    LR.bleedingVulva,
    L.bleedingVulvaDescription,
    LR.vulvaSt
);
bleedingVulva.setPrintName(L.bleedingVulvaPrintName);

// ------------- blister  -------------
Symptom blister = new Symptom(
    LR.blister,
    L.blisterDescription,
    LR.skinSt
);
blister.setPrintName(L.blisterPrintName);

// ------------- blisterSmallItch  -------------
Symptom blisterSmallItch = new Symptom(
    LR.blisterSmallItch,
    L.blisterSmallItchDescription,
    LR.skinSt
);
blisterSmallItch.setPrintName(L.blisterSmallItchPrintName);

// ------------- blisterSmallOoze  -------------
Symptom blisterSmallOoze = new Symptom(
    LR.blisterSmallOoze,
    L.blisterSmallOozeDescription,
    LR.skinSt
);
blisterSmallOoze.setPrintName(L.blisterSmallOozePrintName);

// ------------- blisterSmallScale  -------------
Symptom blisterSmallScale = new Symptom(
    LR.blisterSmallScale,
    L.blisterSmallScaleDescription,
    LR.skinSt
);
blisterSmallScale.setPrintName(L.blisterSmallScalePrintName);

// ------------- bloating  -------------
Symptom bloating = new Symptom(
    LR.bloating,
    L.bloatingDescription,
    LR.bodySt
);
bloating.setPrintName(L.bloatingPrintName);

// ------------- bloodyWoundDischarge  -------------
Symptom bloodyWoundDischarge = new Symptom(
    LR.bloodyWoundDischarge,
    L.bloodyWoundDischargeDescription,
    LR.skinSt
);
bloodyWoundDischarge.setPrintName(L.bloodyWoundDischargePrintName);

// ------------- blotchesRed  -------------
Symptom blotchesRed = new Symptom(
    LR.blotchesRed,
    L.blotchesRedDescription,
    LR.skinSt
);
blotchesRed.setPrintName(L.blotchesRedPrintName);

// ------------- BMIover30  -------------
Symptom BMIover30 = new Symptom(
    LR.BMIover30,
    L.BMIover30Description,
    LR.bodySt
);
BMIover30.setPrintName(L.BMIover30PrintName);

// ------------- bodyHairSparse  -------------
Symptom bodyHairSparse = new Symptom(
    LR.bodyHairSparse,
    L.bodyHairSparseDescription,
    LR.bodySt
);
bodyHairSparse.setPrintName(L.bodyHairSparsePrintName);

// ------------- bodyImageDistorted  -------------
Symptom bodyImageDistorted = new Symptom(
    LR.bodyImageDistorted,
    L.bodyImageDistortedDescription,
    LR.mindSt
);
bodyImageDistorted.setPrintName(L.bodyImageDistortedPrintName);

// ------------- boneAgeImmature  -------------
Symptom boneAgeImmature = new Symptom(
    LR.boneAgeImmature,
    L.boneAgeImmatureDescription,
    LR.aBoneSt
);
boneAgeImmature.setPrintName(L.boneAgeImmaturePrintName);

// ------------- boneDevelopmentEarly  -------------
Symptom boneDevelopmentEarly = new Symptom(
    LR.boneDevelopmentEarly,
    L.boneDevelopmentEarlyDescription,
    LR.aBoneSt
);
boneDevelopmentEarly.setPrintName(L.boneDevelopmentEarlyPrintName);

// ------------- boneGumma  -------------
Symptom boneGumma = new Symptom(
    LR.boneGumma,
    L.boneGummaDescription,
    LR.aBoneSt
);
boneGumma.setPrintName(L.boneGummaPrintName);

// -------------- bonePain --------------
// (C) OntoOO Inc Wed Feb 18 17:35:21 PST 2004
Symptom bonePain = new Symptom(
    LR.bonePain,
    L.bonePainDescription,
    LR.aBoneSt
);
bonePain.setPrintName(L.bonePainPrintName);

// -------------- borborygmi --------------
// (C) OntoOO Inc Mon Mar 15 12:52:28 PST 2004
Symptom borborygmi = new Symptom(
    LR.borborygmi,
    L.borborygmiDescription,
    LR.abdomenSt
);
borborygmi.setPrintName(L.borborygmiPrintName);

// ------------- bowelActivityDecreased  -------------
Symptom bowelActivityDecreased = new Symptom(
    LR.bowelActivityDecreased,
    L.bowelActivityDecreasedDescription,
    LR.intestinesSt
);
bowelActivityDecreased.setPrintName(L.bowelActivityDecreasedPrintName);

// ------------- bradycardia  -------------
Symptom bradycardia = new Symptom(
    LR.bradycardia,
    L.bradycardiaDescription,
    LR.heartSt
);
bradycardia.setPrintName(L.bradycardiaPrintName);

// ------------- bradypnea  -------------
Symptom bradypnea = new Symptom(
    LR.bradypnea,
    L.bradypneaDescription,
    LR.lungsSt
);
bradypnea.setPrintName(L.bradypneaPrintName);

// ------------- breastBonePain  -------------
Symptom breastBonePain = new Symptom(
    LR.breastBonePain,
    L.breastBonePainDescription,
    LR.breastBoneSt
);
breastBonePain.setPrintName(L.breastBonePainPrintName);

// ------------- breastDevelopment  -------------
Symptom breastDevelopment = new Symptom(
    LR.breastDevelopment,
    L.breastDevelopmentDescription,
    LR.breastsFemaleSt
);
breastDevelopment.setPrintName(L.breastDevelopmentPrintName);

// ------------- breastDischargeUnusual  -------------
Symptom breastDischargeUnusual = new Symptom(
    LR.breastDischargeUnusual,
    L.breastDischargeUnusualDescription,
    LR.breastsFemaleSt
);
breastDischargeUnusual.setPrintName(L.breastDischargeUnusualPrintName);

// ------------- breastHard  -------------
Symptom breastHard = new Symptom(
    LR.breastHard,
    L.breastHardDescription,
    LR.breastsFemaleSt
);
breastHard.setPrintName(L.breastHardPrintName);

// ------------- breastLump  -------------
Symptom breastLump = new Symptom(
    LR.breastLump,
    L.breastLumpDescription,
    LR.breastsFemaleSt
);
breastLump.setPrintName(L.breastLumpPrintName);
breastLump.setCardinal();

// ------------- breastPapule  -------------
Symptom breastPapule = new Symptom(
    LR.breastPapule,
    L.breastPapuleDescription,
    LR.breastsFemaleSt
);
breastPapule.setPrintName(L.breastPapulePrintName);

// ------------- breastSizeChange  -------------
Symptom breastSizeChange = new Symptom(
    LR.breastSizeChange,
    L.breastSizeChangeDescription,
    LR.breastsFemaleSt
);
breastSizeChange.setPrintName(L.breastSizeChangePrintName);

// ------------- breastSizeDecrease  -------------
Symptom breastSizeDecrease = new Symptom(
    LR.breastSizeDecrease,
    L.breastSizeDecreaseDescription,
    LR.breastsFemaleSt
);
breastSizeDecrease.setPrintName(L.breastSizeDecreasePrintName);

// ------------- breastSkinAreaHot  -------------
Symptom breastSkinAreaHot = new Symptom(
    LR.breastSkinAreaHot,
    L.breastSkinAreaHotDescription,
    LR.breastsFemaleSt
);
breastSkinAreaHot.setPrintName(L.breastSkinAreaHotPrintName);

// ------------- breastSkinDimpling  -------------
Symptom breastSkinDimpling = new Symptom(
    LR.breastSkinDimpling,
    L.breastSkinDimplingDescription,
    LR.breastsFemaleSt
);
breastSkinDimpling.setPrintName(L.breastSkinDimplingPrintName);

// ------------- breastSkinEdema  -------------
Symptom breastSkinEdema = new Symptom(
    LR.breastSkinEdema,
    L.breastSkinEdemaDescription,
    LR.breastsFemaleSt
);
breastSkinEdema.setPrintName(L.breastSkinEdemaPrintName);

// ------------- breastSkinThickening  -------------
Symptom breastSkinThickening = new Symptom(
    LR.breastSkinThickening,
    L.breastSkinThickeningDescription,
    LR.breastsFemaleSt
);
breastSkinThickening.setPrintName(L.breastSkinThickeningPrintName);

// ------------- breastSkinUlceration  -------------
Symptom breastSkinUlceration = new Symptom(
    LR.breastSkinUlceration,
    L.breastSkinUlcerationDescription,
    LR.breastsFemaleSt
);
breastSkinUlceration.setPrintName(L.breastSkinUlcerationPrintName);

// ------------- breastSwelling  -------------
Symptom breastSwelling = new Symptom(
    LR.breastSwelling,
    L.breastSwellingDescription,
    LR.breastsFemaleSt
);
breastSwelling.setPrintName(L.breastSwellingPrintName);

// ------------- breastTenderness  -------------
Symptom breastTenderness = new Symptom(
    LR.breastTenderness,
    L.breastTendernessDescription,
    LR.breastsFemaleSt
);
breastTenderness.setPrintName(L.breastTendernessPrintName);

// ------------- breastWarm  -------------
Symptom breastWarm = new Symptom(
    LR.breastWarm,
    L.breastWarmDescription,
    LR.breastsFemaleSt
);
breastWarm.setPrintName(L.breastWarmPrintName);

// ------------- breathAcetone  -------------
Symptom breathAcetone = new Symptom(
    LR.breathAcetone,
    L.breathAcetoneDescription,
    LR.mouthSt
);
breathAcetone.setPrintName(L.breathAcetonePrintName);

// ------------- breathFruity  -------------
Symptom breathFruity = new Symptom(
    LR.breathFruity,
    L.breathFruityDescription,
    LR.mouthSt
);
breathFruity.setPrintName(L.breathFruityPrintName);

// ------------- breathingAsymmetric  -------------
Symptom breathingAsymmetric = new Symptom(
    LR.breathingAsymmetric,
    L.breathingAsymmetricDescription,
    LR.chestSt
);
breathingAsymmetric.setPrintName(L.breathingAsymmetricPrintName);

// ------------- breathingDifficult  -------------
Symptom breathingDifficult = new Symptom(
    LR.breathingDifficult,
    L.breathingDifficultDescription,
    LR.lungsSt
);
breathingDifficult.setPrintName(L.breathingDifficultPrintName);

// -------------- breathingShallow --------------
/*
// (C) OntoOO Inc Mon Jun 21 17:14:14 PDT 2004
Symptom breathingShallow = new Symptom(
    LR.breathingShallow,
    L.breathingShallowDescription,
    LR.lungsSt
);
breathingShallow.setPrintName(L.breathingShallowPrintName);
*/

// ------------- breathlessness  -------------
Symptom breathlessness = new Symptom(
    LR.breathlessness,
    L.breathlessnessDescription,
    LR.lungsSt
);
breathlessness.setPrintName(L.breathlessnessPrintName);

// ------------- breathStinking  -------------
Symptom breathStinking = new Symptom(
    LR.breathStinking,
    L.breathStinkingDescription,
    LR.mouthSt
);
breathStinking.setPrintName(L.breathStinkingPrintName);

// ------------- bruising  -------------
Symptom bruising = new Symptom(
    LR.bruising,
    L.bruisingDescription,
    LR.skinSt
);
bruising.setPrintName(L.bruisingPrintName);

// -------------- buffaloHump --------------
// (C) OntoOO Inc Sun Feb 22 16:51:54 PST 2004
Symptom buffaloHump = new Symptom(
    LR.buffaloHump,
    L.buffaloHumpDescription,
    LR.backSt
);
buffaloHump.setPrintName(L.buffaloHumpPrintName);

// ------------- bumpItchy  -------------
Symptom bumpItchy = new Symptom(
    LR.bumpItchy,
    L.bumpItchyDescription,
    LR.skinSt
);
bumpItchy.setPrintName(L.bumpItchyPrintName);

// ------------- bunion  -------------
Symptom bunion = new Symptom(
    LR.bunion,
    L.bunionDescription,
    LR.largeToesSt
);
bunion.setPrintName(L.bunionPrintName);

// ------------- burningSensation  -------------
Symptom burningSensation = new Symptom(
    LR.burningSensation,
    L.burningSensationDescription,
    LR.skinSt
);
burningSensation.setPrintName(L.burningSensationPrintName);

// ------------- burping  -------------
Symptom burping = new Symptom(
    LR.burping,
    L.burpingDescription,
    LR.mouthSt
);
burping.setPrintName(L.burpingPrintName);

// -------------- butterflyRash --------------
// (C) OntoOO Inc Mon Jul 19 15:54:02 PDT 2004
Symptom butterflyRash = new Symptom(
    LR.butterflyRash,
    L.butterflyRashDescription,
    LR.faceSt
);
butterflyRash.setPrintName(L.butterflyRashPrintName);

// ------------- buttockPain  -------------
Symptom buttockPain = new Symptom(
    LR.buttockPain,
    L.buttockPainDescription,
    LR.buttockSt
);
buttockPain.setPrintName(L.buttockPainPrintName);

// ------------- cachexia  -------------
Symptom cachexia = new Symptom(
    LR.cachexia,
    L.cachexiaDescription,
    LR.bodySt
);
cachexia.setPrintName(L.cachexiaPrintName);

// ------------- cataract  -------------
Symptom cataract = new Symptom(
    LR.cataract,
    L.cataractDescription,
    LR.eyesSt
);
cataract.setPrintName(L.cataractPrintName);

// ------------- catatonic  -------------
Symptom catatonic = new Symptom(
    LR.catatonic,
    L.catatonicDescription,
    LR.mindSt
);
catatonic.setPrintName(L.catatonicPrintName);

// ------------- cerebrospinalFluidLeakage  -------------
Symptom cerebrospinalFluidLeakage = new Symptom(
    LR.cerebrospinalFluidLeakage,
    L.cerebrospinalFluidLeakageDescription,
    LR.brainSt
);
cerebrospinalFluidLeakage.setPrintName(L.cerebrospinalFluidLeakagePrintName);

/*
// ------------- cervixAdenopathy  -------------
Symptom cervixAdenopathy = new Symptom(
    LR.cervixAdenopathy,
    L.cervixAdenopathyDescription,
    LR.neckSt
);
cervixAdenopathy.setPrintName(L.cervixAdenopathyPrintName);
*/

// ------------- cervixDilation  -------------
Symptom cervixDilation = new Symptom(
    LR.cervixDilation,
    L.cervixDilationDescription,
    LR.cervixSt
);
cervixDilation.setPrintName(L.cervixDilationPrintName);

// ------------- cervixDischargeGreenYellow  -------------
Symptom cervixDischargeGreenYellow = new Symptom(
    LR.cervixDischargeGreenYellow,
    L.cervixDischargeGreenYellowDescription,
    LR.cervixSt
);
cervixDischargeGreenYellow.setPrintName(L.cervixDischargeGreenYellowPrintName);

// ------------- cervixEdematous  -------------
Symptom cervixEdematous = new Symptom(
    LR.cervixEdematous,
    L.cervixEdematousDescription,
    LR.cervixSt
);
cervixEdematous.setPrintName(L.cervixEdematousPrintName);

// ------------- cervixErosion  -------------
Symptom cervixErosion = new Symptom(
    LR.cervixErosion,
    L.cervixErosionDescription,
    LR.cervixSt
);
cervixErosion.setPrintName(L.cervixErosionPrintName);

// ------------- cervixPapule  -------------
Symptom cervixPapule = new Symptom(
    LR.cervixPapule,
    L.cervixPapuleDescription,
    LR.cervixSt
);
cervixPapule.setPrintName(L.cervixPapulePrintName);

// ------------- cervixRed  -------------
Symptom cervixRed = new Symptom(
    LR.cervixRed,
    L.cervixRedDescription,
    LR.cervixSt
);
cervixRed.setPrintName(L.cervixRedPrintName);

// ------------- cervixTenderness  -------------
Symptom cervixTenderness = new Symptom(
    LR.cervixTenderness,
    L.cervixTendernessDescription,
    LR.cervixSt
);
cervixTenderness.setPrintName(L.cervixTendernessPrintName);

// ------------- cervixVesicle  -------------
Symptom cervixVesicle = new Symptom(
    LR.cervixVesicle,
    L.cervixVesicleDescription,
    LR.cervixSt
);
cervixVesicle.setPrintName(L.cervixVesiclePrintName);

// ------------- cervixWarts  -------------
Symptom cervixWarts = new Symptom(
    LR.cervixWarts,
    L.cervixWartsDescription,
    LR.cervixSt
);
cervixWarts.setPrintName(L.cervixWartsPrintName);

// ------------- cheeksFlushed  -------------
Symptom cheeksFlushed = new Symptom(
    LR.cheeksFlushed,
    L.cheeksFlushedDescription,
    LR.cheeksSt
);
cheeksFlushed.setPrintName(L.cheeksFlushedPrintName);

// ------------- chestPain  -------------
Symptom chestPain = new Symptom(
    LR.chestPain,
    L.chestPainDescription,
    LR.chestSt
);
chestPain.setPrintName(L.chestPainPrintName);

// ------------- chestPainSevere  -------------
Symptom chestPainSevere = new Symptom(
    LR.chestPainSevere,
    L.chestPainSevereDescription,
    LR.chestSt
);
chestPainSevere.setPrintName(L.chestPainSeverePrintName);

// ------------- chestTightness  -------------
Symptom chestTightness = new Symptom(
    LR.chestTightness,
    L.chestTightnessDescription,
    LR.chestSt
);
chestTightness.setPrintName(L.chestTightnessPrintName);

// ------------- chewingDifficult  -------------
Symptom chewingDifficult = new Symptom(
    LR.chewingDifficult,
    L.chewingDifficultDescription,
    LR.mouthSt
);
chewingDifficult.setPrintName(L.chewingDifficultPrintName);

// ------------- chewingPainful  -------------
Symptom chewingPainful = new Symptom(
    LR.chewingPainful,
    L.chewingPainfulDescription,
    LR.mouthSt
);
chewingPainful.setPrintName(L.chewingPainfulPrintName);

// ------------- chills  -------------
Symptom chills = new Symptom(
    LR.chills,
    L.chillsDescription,
    LR.bodySt
);
chills.setPrintName(L.chillsPrintName);

// ------------- chillsSevere  -------------
Symptom chillsSevere = new Symptom(
    LR.chillsSevere,
    L.chillsSevereDescription,
    LR.bodySt
);
chillsSevere.setPrintName(L.chillsSeverePrintName);

// ------------- choking  -------------
Symptom choking = new Symptom(
    LR.choking,
    L.chokingDescription,
    LR.mouthSt
);
choking.setPrintName(L.chokingPrintName);

// ------------- chokingFeeling  -------------
Symptom chokingFeeling = new Symptom(
    LR.chokingFeeling,
    L.chokingFeelingDescription,
    LR.mindSt
);
chokingFeeling.setPrintName(L.chokingFeelingPrintName);

// ------------- clitorisEnlarged  -------------
Symptom clitorisEnlarged = new Symptom(
    LR.clitorisEnlarged,
    L.clitorisEnlargedDescription,
    LR.clitorisSt
);
clitorisEnlarged.setPrintName(L.clitorisEnlargedPrintName);

// ------------- clumsy  -------------
Symptom clumsy = new Symptom(
    LR.clumsy,
    L.clumsyDescription,
    LR.mindSt
);
clumsy.setPrintName(L.clumsyPrintName);

// ------------- coldIntolerance  -------------
Symptom coldIntolerance = new Symptom(
    LR.coldIntolerance,
    L.coldIntoleranceDescription,
    LR.mindSt
);
coldIntolerance.setPrintName(L.coldIntolerancePrintName);

// ------------- colonPain  -------------
Symptom colonPain = new Symptom(
    LR.colonPain,
    L.colonPainDescription,
    LR.colonSt
);
colonPain.setPrintName(L.colonPainPrintName);

// ------------- coma  -------------
Symptom coma = new Symptom(
    LR.coma,
    L.comaDescription,
    LR.mindSt
);
coma.setPrintName(L.comaPrintName);

// ------------- communicationImpaired  -------------
Symptom communicationImpaired = new Symptom(
    LR.communicationImpaired,
    L.communicationImpairedDescription,
    LR.mindSt
);
communicationImpaired.setPrintName(L.communicationImpairedPrintName);

// ------------- compulsiveActions  -------------
Symptom compulsiveActions = new Symptom(
    LR.compulsiveActions,
    L.compulsiveActionsDescription,
    LR.mindSt
);
compulsiveActions.setPrintName(L.compulsiveActionsPrintName);

// ------------- concentrationLoss  -------------
Symptom concentrationLoss = new Symptom(
    LR.concentrationLoss,
    L.concentrationLossDescription,
    LR.mindSt
);
concentrationLoss.setPrintName(L.concentrationLossPrintName);

// ------------- confusion  -------------
Symptom confusion = new Symptom(
    LR.confusion,
    L.confusionDescription,
    LR.mindSt
);
confusion.setPrintName(L.confusionPrintName);
confusion.setCardinal();

// ------------- consciousnessDecreased  -------------
Symptom consciousnessDecreased = new Symptom(
    LR.consciousnessDecreased,
    L.consciousnessDecreasedDescription,
    LR.mindSt
);
consciousnessDecreased.setPrintName(L.consciousnessDecreasedPrintName);

// ------------- consciousnessLoss  -------------
Symptom consciousnessLoss = new Symptom(
    LR.consciousnessLoss,
    L.consciousnessLossDescription,
    LR.mindSt
);
consciousnessLoss.setPrintName(L.consciousnessLossPrintName);

// ------------- constipation  -------------
Symptom constipation = new Symptom(
    LR.constipation,
    L.constipationDescription,
    LR.intestinesSt
);
constipation.setPrintName(L.constipationPrintName);

// ------------- contractionsAfterChildbirth  -------------
Symptom contractionsAfterChildbirth = new Symptom(
    LR.contractionsAfterChildbirth,
    L.contractionsAfterChildbirthDescription,
    LR.uterusSt
);
contractionsAfterChildbirth.setPrintName(L.contractionsAfterChildbirthPrintName);

// -------------- convulsions --------------
// (C) OntoOO Inc Mon Aug 01 15:40:49 PDT 2005
Symptom convulsions = new Symptom(
    LR.convulsions,
    L.convulsionsDescription,
    LR.aMuscleSt
);
convulsions.setPrintName(L.convulsionsPrintName);
convulsions.setCardinal();

// ------------- coolExtremities  -------------
Symptom coolExtremities = new Symptom(
    LR.coolExtremities,
    L.coolExtremitiesDescription,
    LR.bodySt
);
coolExtremities.setPrintName(L.coolExtremitiesPrintName);

// ------------- coordinationDetoriation  -------------
Symptom coordinationDetoriation = new Symptom(
    LR.coordinationDetoriation,
    L.coordinationDetoriationDescription,
    LR.mindSt
);
coordinationDetoriation.setPrintName(L.coordinationDetoriationPrintName);

// ------------- corneaCloudy  -------------
Symptom corneaCloudy = new Symptom(
    LR.corneaCloudy,
    L.corneaCloudyDescription,
    LR.corneasSt
);
corneaCloudy.setPrintName(L.corneaCloudyPrintName);

// ------------- corneaOpaque  -------------
Symptom corneaOpaque = new Symptom(
    LR.corneaOpaque,
    L.corneaOpaqueDescription,
    LR.corneasSt
);
corneaOpaque.setPrintName(L.corneaOpaquePrintName);

// ------------- coryza  -------------
Symptom coryza = new Symptom(
    LR.coryza,
    L.coryzaDescription,
    LR.noseSt
);
coryza.setPrintName(L.coryzaPrintName);

// ------------- cough  -------------
Symptom cough = new Symptom(
    LR.cough,
    L.coughDescription,
    LR.throatSt
);
cough.setPrintName(L.coughPrintName);

// ------------- coughBark  -------------
Symptom coughBark = new Symptom(
    LR.coughBark,
    L.coughBarkDescription,
    LR.throatSt
);
coughBark.setPrintName(L.coughBarkPrintName);

// ------------- coughDry  -------------
Symptom coughDry = new Symptom(
    LR.coughDry,
    L.coughDryDescription,
    LR.throatSt
);
coughDry.setPrintName(L.coughDryPrintName);

// ------------- coughHacking  -------------
Symptom coughHacking = new Symptom(
    LR.coughHacking,
    L.coughHackingDescription,
    LR.throatSt
);
coughHacking.setPrintName(L.coughHackingPrintName);

// ------------- coughProductive  -------------
Symptom coughProductive = new Symptom(
    LR.coughProductive,
    L.coughProductiveDescription,
    LR.throatSt
);
coughProductive.setPrintName(L.coughProductivePrintName);

// ------------- coughProductiveFoulSmelling  -------------
Symptom coughProductiveFoulSmelling = new Symptom(
    LR.coughProductiveFoulSmelling,
    L.coughProductiveFoulSmellingDescription,
    LR.throatSt
);
coughProductiveFoulSmelling.setPrintName(L.coughProductiveFoulSmellingPrintName);

// ------------- crackles  -------------
Symptom crackles = new Symptom(
    LR.crackles,
    L.cracklesDescription,
    LR.mouthSt
);
crackles.setPrintName(L.cracklesPrintName);

// ------------- cryingSpell  -------------
Symptom cryingSpell = new Symptom(
    LR.cryingSpell,
    L.cryingSpellDescription,
    LR.eyesSt
);
cryingSpell.setPrintName(L.cryingSpellPrintName);

// -------------- cryingSpellFrequent --------------
// (C) OntoOO Inc Sat Mar 24 19:00:28 PST 2007
Symptom cryingSpellFrequent = new Symptom(
    LR.cryingSpellFrequent,
    L.cryingSpellFrequentDescription,
    LR.eyesSt
);
cryingSpellFrequent.setPrintName(L.cryingSpellFrequentPrintName);

// ------------- cyanosis  -------------
Symptom cyanosis = new Symptom(
    LR.cyanosis,
    L.cyanosisDescription,
    LR.skinSt
);
cyanosis.setPrintName(L.cyanosisPrintName);

// ------------- dailyActivityUninteresting  -------------
Symptom dailyActivityUninteresting = new Symptom(
    LR.dailyActivityUninteresting,
    L.dailyActivityUninterestingDescription,
    LR.mindSt
);
dailyActivityUninteresting.setPrintName(L.dailyActivityUninterestingPrintName);

// ------------- daydreaming  -------------
Symptom daydreaming = new Symptom(
    LR.daydreaming,
    L.daydreamingDescription,
    LR.mindSt
);
daydreaming.setPrintName(L.daydreamingPrintName);

// ------------- decerebratePosturing  -------------
Symptom decerebratePosturing = new Symptom(
    LR.decerebratePosturing,
    L.decerebratePosturingDescription,
    LR.brainSt
);
decerebratePosturing.setPrintName(L.decerebratePosturingPrintName);

// ------------- deepThrustDyspareunia  -------------
Symptom deepThrustDyspareunia = new Symptom(
    LR.deepThrustDyspareunia,
    L.deepThrustDyspareuniaDescription,
    LR.vaginaSt
);
deepThrustDyspareunia.setPrintName(L.deepThrustDyspareuniaPrintName);

// ------------- dehydration  -------------
Symptom dehydration = new Symptom(
    LR.dehydration,
    L.dehydrationDescription,
    LR.bodySt
);
dehydration.setPrintName(L.dehydrationPrintName);

// ------------- delirium  -------------
Symptom delirium = new Symptom(
    LR.delirium,
    L.deliriumDescription,
    LR.mindSt
);
delirium.setPrintName(L.deliriumPrintName);

// ------------- delusions  -------------
Symptom delusions = new Symptom(
    LR.delusions,
    L.delusionsDescription,
    LR.mindSt
);
delusions.setPrintName(L.delusionsPrintName);

// -------------- developmentSlow --------------
// (C) OntoOO Inc Fri Aug 20 12:46:51 GMT-08:00 2004
Symptom developmentSlow = new Symptom(
    LR.developmentSlow,
    L.developmentSlowDescription,
    LR.bodySt
);
developmentSlow.setPrintName(L.developmentSlowPrintName);

// ------------- diaphoresis  -------------
Symptom diaphoresis = new Symptom(
    LR.diaphoresis,
    L.diaphoresisDescription,
    LR.skinSt
);
diaphoresis.setPrintName(L.diaphoresisPrintName);

// ------------- diarrhea  -------------
Symptom diarrhea = new Symptom(
    LR.diarrhea,
    L.diarrheaDescription,
    LR.intestinesSt
);
diarrhea.setPrintName(L.diarrheaPrintName);

// ------------- diarrheaBloody  -------------
Symptom diarrheaBloody = new Symptom(
    LR.diarrheaBloody,
    L.diarrheaBloodyDescription,
    LR.bodySt
);
diarrheaBloody.setPrintName(L.diarrheaBloodyPrintName);

// ------------- diarrheaNocturnal  -------------
Symptom diarrheaNocturnal = new Symptom(
    LR.diarrheaNocturnal,
    L.diarrheaNocturnalDescription,
    LR.bodySt
);
diarrheaNocturnal.setPrintName(L.diarrheaNocturnalPrintName);

// -------------- diarrheaWatery --------------
// (C) OntoOO Inc Thu Feb 24 16:44:49 PST 2005
Symptom diarrheaWatery = new Symptom(
    LR.diarrheaWatery,
    L.diarrheaWateryDescription,
    LR.bodySt
);
diarrheaWatery.setPrintName(L.diarrheaWateryPrintName);

// ------------- diastolicGallop  -------------
Symptom diastolicGallop = new Symptom(
    LR.diastolicGallop,
    L.diastolicGallopDescription,
    LR.heartSt
);
diastolicGallop.setPrintName(L.diastolicGallopPrintName);

// -------------- digitsClubbing --------------
// (C) OntoOO Inc Mon Aug 23 20:00:05 GMT-08:00 2004
Symptom digitsClubbing = new Symptom(
    LR.digitsClubbing,
    L.digitsClubbingDescription,
    LR.digitsSt
);
digitsClubbing.setPrintName(L.digitsClubbingPrintName);

// ------------- diplopia  -------------
Symptom diplopia = new Symptom(
    LR.diplopia,
    L.diplopiaDescription,
    LR.eyesSt
);
diplopia.setPrintName(L.diplopiaPrintName);

// ------------- discoloration  -------------
Symptom discoloration = new Symptom(
    LR.discoloration,
    L.discolorationDescription,
    LR.bodySt
);
discoloration.setPrintName(L.discolorationPrintName);

// ------------- disorientation  -------------
Symptom disorientation = new Symptom(
    LR.disorientation,
    L.disorientationDescription,
    LR.mindSt
);
disorientation.setPrintName(L.disorientationPrintName);

// ------------- dizziness  -------------
Symptom dizziness = new Symptom(
    LR.dizziness,
    L.dizzinessDescription,
    LR.mindSt
);
dizziness.setPrintName(L.dizzinessPrintName);

// ------------- doomFeeling  -------------
Symptom doomFeeling = new Symptom(
    LR.doomFeeling,
    L.doomFeelingDescription,
    LR.mindSt
);
doomFeeling.setPrintName(L.doomFeelingPrintName);

// ------------- drooling  -------------
Symptom drooling = new Symptom(
    LR.drooling,
    L.droolingDescription,
    LR.mouthSt
);
drooling.setPrintName(L.droolingPrintName);

// ------------- drowsiness  -------------
Symptom drowsiness = new Symptom(
    LR.drowsiness,
    L.drowsinessDescription,
    LR.mindSt
);
drowsiness.setPrintName(L.drowsinessPrintName);

// ------------- dysarthria  -------------
Symptom dysarthria = new Symptom(
    LR.dysarthria,
    L.dysarthriaDescription,
    LR.vocalCordsSt
);
dysarthria.setPrintName(L.dysarthriaPrintName);

// ------------- dyspepsia  -------------
Symptom dyspepsia = new Symptom(
    LR.dyspepsia,
    L.dyspepsiaDescription,
    LR.bodySt
);
dyspepsia.setPrintName(L.dyspepsiaPrintName);

// ------------- dysphagia  -------------
Symptom dysphagia = new Symptom(
    LR.dysphagia,
    L.dysphagiaDescription,
    LR.mouthSt
);
dysphagia.setPrintName(L.dysphagiaPrintName);

// ------------- dysphasia  -------------
Symptom dysphasia = new Symptom(
    LR.dysphasia,
    L.dysphasiaDescription,
    LR.mindSt
);
dysphasia.setPrintName(L.dysphasiaPrintName);

// -------------- dysphonia --------------
// (C) OntoOO Inc Thu Aug 26 17:28:14 GMT-08:00 2004
Symptom dysphonia = new Symptom(
    LR.dysphonia,
    L.dysphoniaDescription,
    LR.vocalCordsSt
);
dysphonia.setPrintName(L.dysphoniaPrintName);

// ------------- dyspnea  -------------
Symptom dyspnea = new Symptom(
    LR.dyspnea,
    L.dyspneaDescription,
    LR.lungsSt
);
dyspnea.setPrintName(L.dyspneaPrintName);

// ------------- dysuria  -------------
Symptom dysuria = new Symptom(
    LR.dysuria,
    L.dysuriaDescription,
    LR.bladderSt
);
dysuria.setPrintName(L.dysuriaPrintName);

// ------------- earBlockageFeeling  -------------
Symptom earBlockageFeeling = new Symptom(
    LR.earBlockageFeeling,
    L.earBlockageFeelingDescription,
    LR.earsSt
);
earBlockageFeeling.setPrintName(L.earBlockageFeelingPrintName);

// ------------- earRinging  -------------
/*
Symptom earRinging = new Symptom(
    LR.earRinging,
    L.earRingingDescription,
    LR.earsSt
);
earRinging.setPrintName(L.earRingingPrintName);
*/

// ------------- earache  -------------
Symptom earache = new Symptom(
    LR.earache,
    L.earacheDescription,
    LR.earsSt
);
earache.setPrintName(L.earachePrintName);

// ------------- ecchymoses  -------------
Symptom ecchymoses = new Symptom(
    LR.ecchymoses,
    L.ecchymosesDescription,
    LR.skinSt
);
ecchymoses.setPrintName(L.ecchymosesPrintName);

// ------------- ecchymosesFace  -------------
Symptom ecchymosesFace = new Symptom(
    LR.ecchymosesFace,
    L.ecchymosesFaceDescription,
    LR.faceSt
);
ecchymosesFace.setPrintName(L.ecchymosesFacePrintName);

// ------------- eczema  -------------
Symptom eczema = new Symptom(
    LR.eczema,
    L.eczemaDescription,
    LR.skinSt
);
eczema.setPrintName(L.eczemaPrintName);

// ------------- edema  -------------
Symptom edema = new Symptom(
    LR.edema,
    L.edemaDescription,
    LR.bodySt
);
edema.setPrintName(L.edemaPrintName);

// ------------- edemaPeripheral  -------------
Symptom edemaPeripheral = new Symptom(
    LR.edemaPeripheral,
    L.edemaPeripheralDescription,
    LR.skinSt
);
edemaPeripheral.setPrintName(L.edemaPeripheralPrintName);

// ------------- ejaculationPainful  -------------
Symptom ejaculationPainful = new Symptom(
    LR.ejaculationPainful,
    L.ejaculationPainfulDescription,
    LR.penisSt
);
ejaculationPainful.setPrintName(L.ejaculationPainfulPrintName);

// ------------- elbowLesion  -------------
Symptom elbowLesion = new Symptom(
    LR.elbowLesion,
    L.elbowLesionDescription,
    LR.elbowsSt
);
elbowLesion.setPrintName(L.elbowLesionPrintName);

// ------------- elbowPain  -------------
Symptom elbowPain = new Symptom(
    LR.elbowPain,
    L.elbowPainDescription,
    LR.elbowsSt
);
elbowPain.setPrintName(L.elbowPainPrintName);

// ------------- emaciation  -------------
Symptom emaciation = new Symptom(
    LR.emaciation,
    L.emaciationDescription,
    LR.bodySt
);
emaciation.setPrintName(L.emaciationPrintName);

// ------------- emotionPangs  -------------
Symptom emotionPangs = new Symptom(
    LR.emotionPangs,
    L.emotionPangsDescription,
    LR.mindSt
);
emotionPangs.setPrintName(L.emotionPangsPrintName);

// ------------- energyLoss  -------------
Symptom energyLoss = new Symptom(
    LR.energyLoss,
    L.energyLossDescription,
    LR.mindSt
);
energyLoss.setPrintName(L.energyLossPrintName);

// ------------- epigastricPain  -------------
Symptom epigastricPain = new Symptom(
    LR.epigastricPain,
    L.epigastricPainDescription,
    LR.stomachSt
);
epigastricPain.setPrintName(L.epigastricPainPrintName);

// ------------- epigastricUmbilicusPain  -------------
Symptom epigastricUmbilicusPain = new Symptom(
    LR.epigastricUmbilicusPain,
    L.epigastricUmbilicusPainDescription,
    LR.stomachSt
);
epigastricUmbilicusPain.setPrintName(L.epigastricUmbilicusPainPrintName);

// ------------- erectionFailure  -------------
Symptom erectionFailure = new Symptom(
    LR.erectionFailure,
    L.erectionFailureDescription,
    LR.penisSt
);
erectionFailure.setPrintName(L.erectionFailurePrintName);

// ------------- erectionFrequent  -------------
Symptom erectionFrequent = new Symptom(
    LR.erectionFrequent,
    L.erectionFrequentDescription,
    LR.penisSt
);
erectionFrequent.setPrintName(L.erectionFrequentPrintName);

// ------------- erythema  -------------
Symptom erythema = new Symptom(
    LR.erythema,
    L.erythemaDescription,
    LR.skinSt
);
erythema.setPrintName(L.erythemaPrintName);

// ------------- erythemaNodosum  -------------
Symptom erythemaNodosum = new Symptom(
    LR.erythemaNodosum,
    L.erythemaNodosumDescription,
    LR.shinsSt
);
erythemaNodosum.setPrintName(L.erythemaNodosumPrintName);
erythemaNodosum.setWebResource("http://umm.drkoop.com/conditions/ency/article/000881.htm");

// ------------- erythemaUrethraMale  -------------
Symptom erythemaUrethraMale = new Symptom(
    LR.erythemaUrethraMale,
    L.erythemaUrethraMaleDescription,
    LR.urethralExitMLSt
);
erythemaUrethraMale.setPrintName(L.erythemaUrethraMalePrintName);

// ------------- esophagusSpasm  -------------
Symptom esophagusSpasm = new Symptom(
    LR.esophagusSpasm,
    L.esophagusSpasmDescription,
    LR.esophagusSt
);
esophagusSpasm.setPrintName(L.esophagusSpasmPrintName);

// ------------- exacerbationOfMentalProblems  -------------
Symptom exacerbationOfMentalProblems = new Symptom(
    LR.exacerbationOfMentalProblems,
    L.exacerbationOfMentalProblemsDescription,
    LR.mindSt
);
exacerbationOfMentalProblems.setPrintName(L.exacerbationOfMentalProblemsPrintName);

// -------------- exophthalmos --------------
// (C) OntoOO Inc Wed May 19 17:13:18 PDT 2004
Symptom exophthalmos = new Symptom(
    LR.exophthalmos,
    L.exophthalmosDescription,
    LR.eyesSt
);
exophthalmos.setPrintName(L.exophthalmosPrintName);

// -------------- excited --------------
// (C) OntoOO Inc Sat Apr 23 22:00:14 2011
Symptom excited = new Symptom(
    LR.excited,
    L.excitedDescription,
    LR.mindSt
);
excited.setPrintName(L.excitedPrintName);

// -------------- eyeDryness --------------
// (C) OntoOO Inc Tue Feb 17 18:12:54 PST 2004
Symptom eyeDryness = new Symptom(
    LR.eyeDryness,
    L.eyeDrynessDescription,
    LR.eyesSt
);
eyeDryness.setPrintName(L.eyeDrynessPrintName);

// -------------- eyeExudate --------------
// (C) OntoOO Inc Tue Feb 17 18:12:54 PST 2004
Symptom eyeExudate = new Symptom(
    LR.eyeExudate,
    L.eyeExudateDescription,
    LR.eyesSt
);
eyeExudate.setPrintName(L.eyeExudatePrintName);

// ------------- eyePain  -------------
Symptom eyePain = new Symptom(
    LR.eyePain,
    L.eyePainDescription,
    LR.eyesSt
);
eyePain.setPrintName(L.eyePainPrintName);

// ------------- eyePainMild  -------------
Symptom eyePainMild = new Symptom(
    LR.eyePainMild,
    L.eyePainMildDescription,
    LR.eyesSt
);
eyePainMild.setPrintName(L.eyePainMildPrintName);

// ------------- eyePressure  -------------
Symptom eyePressure = new Symptom(
    LR.eyePressure,
    L.eyePressureDescription,
    LR.eyesSt
);
eyePressure.setPrintName(L.eyePressurePrintName);

// ------------- eyelidChancre  -------------
Symptom eyelidChancre = new Symptom(
    LR.eyelidChancre,
    L.eyelidChancreDescription,
    LR.eyelidsSt
);
eyelidChancre.setPrintName(L.eyelidChancrePrintName);

// -------------- eyelidDroop --------------
// (C) OntoOO Inc Thu May 20 18:23:32 PDT 2004
Symptom eyelidDroop = new Symptom(
    LR.eyelidDroop,
    L.eyelidDroopDescription,
    LR.eyelidsSt
);
eyelidDroop.setPrintName(L.eyelidDroopPrintName);

// ------------- eyelidHyperemia  -------------
Symptom eyelidHyperemia = new Symptom(
    LR.eyelidHyperemia,
    L.eyelidHyperemiaDescription,
    LR.conjunctivaSt
);
eyelidHyperemia.setPrintName(L.eyelidHyperemiaPrintName);

// ------------- eyelidRed  -------------
Symptom eyelidRed = new Symptom(
    LR.eyelidRed,
    L.eyelidRedDescription,
    LR.eyelidsSt
);
eyelidRed.setPrintName(L.eyelidRedPrintName);

// ------------- eyelidSwollen  -------------
Symptom eyelidSwollen = new Symptom(
    LR.eyelidSwollen,
    L.eyelidSwollenDescription,
    LR.eyelidsSt
);
eyelidSwollen.setPrintName(L.eyelidSwollenPrintName);

// ------------- eyeRedness  -------------
Symptom eyeRedness= new Symptom(
    LR.eyeRedness,
    L.eyeRednessDescription,
    LR.eyesSt
);
eyeRedness.setPrintName(L.eyeRednessPrintName);

// ------------- faceBurningPain  -------------
Symptom faceBurningPain = new Symptom(
    LR.faceBurningPain,
    L.faceBurningPainDescription,
    LR.faceSt
);
faceBurningPain.setPrintName(L.faceBurningPainPrintName);
faceBurningPain.setCardinal();

// -------------- faceEdema --------------
// (C) OntoOO Inc Mon May 10 17:02:25 PDT 2004
Symptom faceEdema = new Symptom(
    LR.faceEdema,
    L.faceEdemaDescription,
    LR.faceSt
);
faceEdema.setPrintName(L.faceEdemaPrintName);

// ------------- faceHair  -------------
Symptom faceHair = new Symptom(
    LR.faceHair,
    L.faceHairDescription,
    LR.faceSt
);
faceHair.setPrintName(L.faceHairPrintName);

// ------------- faceHairSparse  -------------
Symptom faceHairSparse = new Symptom(
    LR.faceHairSparse,
    L.faceHairSparseDescription,
    LR.faceSt
);
faceHairSparse.setPrintName(L.faceHairSparsePrintName);

// ------------- faceLesionPinkPapules  -------------
Symptom faceLesionPinkPapules = new Symptom(
    LR.faceLesionPinkPapules,
    L.faceLesionPinkPapulesDescription,
    LR.faceSt
);
faceLesionPinkPapules.setPrintName(L.faceLesionPinkPapulesPrintName);
faceLesionPinkPapules.setCardinal();

// ------------- faceLesionTranslucentPapules  -------------
Symptom faceLesionTranslucentPapules = new Symptom(
    LR.faceLesionTranslucentPapules,
    L.faceLesionTranslucentPapulesDescription,
    LR.faceSt
);
faceLesionTranslucentPapules.setPrintName(L.faceLesionTranslucentPapulesPrintName);

// -------------- faceMovementsAbnormal --------------
// (C) OntoOO Inc Thu Aug 12 16:07:12 GMT-08:00 2004
Symptom faceMovementsAbnormal = new Symptom(
    LR.faceMovementsAbnormal,
    L.faceMovementsAbnormalDescription,
    LR.faceSt
);
faceMovementsAbnormal.setPrintName(L.faceMovementsAbnormalPrintName);

// ------------- faceNumbness  -------------
Symptom faceNumbness = new Symptom(
    LR.faceNumbness,
    L.faceNumbnessDescription,
    LR.faceSt
);
faceNumbness.setPrintName(L.faceNumbnessPrintName);

// ------------- faceSearingPain  -------------
Symptom faceSearingPain = new Symptom(
    LR.faceSearingPain,
    L.faceSearingPainDescription,
    LR.faceSt
);
faceSearingPain.setPrintName(L.faceSearingPainPrintName);

// ------------- faceTingling  -------------
Symptom faceTingling = new Symptom(
    LR.faceTingling,
    L.faceTinglingDescription,
    LR.faceSt
);
faceTingling.setPrintName(L.faceTinglingPrintName);

// ------------- faceSpasm  -------------
Symptom faceSpasm = new Symptom(
    LR.faceSpasm,
    L.faceSpasmDescription,
    LR.faceSt
);
faceSpasm.setPrintName(L.faceSpasmPrintName);

// ------------- fainting  -------------
Symptom fainting = new Symptom(
    LR.fainting,
    L.faintingDescription,
    LR.bodySt
);
fainting.setPrintName(L.faintingPrintName);

// ------------- fallingSensation  -------------
Symptom fallingSensation = new Symptom(
    LR.fallingSensation,
    L.fallingSensationDescription,
    LR.mindSt
);
fallingSensation.setPrintName(L.fallingSensationPrintName);

// ------------- fatigue  -------------
Symptom fatigue = new Symptom(
    LR.fatigue,
    L.fatigueDescription,
    LR.bodySt
);
fatigue.setPrintName(L.fatiguePrintName);

// ------------- fatigueProlonged  -------------
Symptom fatigueProlonged = new Symptom(
    LR.fatigueProlonged,
    L.fatigueProlongedDescription,
    LR.bodySt
);
fatigueProlonged.setPrintName(L.fatigueProlongedPrintName);

// ------------- fearful  -------------
Symptom fearful = new Symptom(
    LR.fearful,
    L.fearfulDescription,
    LR.mindSt
);
fearful.setPrintName(L.fearfulPrintName);

// -------------- feedingDifficulties --------------
// (C) OntoOO Inc Tue Apr 24 10:13:39 PDT 2007
Symptom feedingDifficulties = new Symptom(
    LR.feedingDifficulties,
    L.feedingDifficultiesDescription,
    LR.bodySt
);
feedingDifficulties.setPrintName(L.feedingDifficultiesPrintName);

// ------------- feelingCold  -------------
Symptom feelingCold = new Symptom(
    LR.feelingCold,
    L.feelingColdDescription,
    LR.mindSt
);
feelingCold.setPrintName(L.feelingColdPrintName);

// ------------- feetCold  -------------
Symptom feetCold = new Symptom(
    LR.feetCold,
    L.feetColdDescription,
    LR.feetSt
);
feetCold.setPrintName(L.feetColdPrintName);
// ------------- feetNumbness  -------------
Symptom feetNumbness = new Symptom(
    LR.feetNumbness,
    L.feetNumbnessDescription,
    LR.feetSt
);
feetNumbness.setPrintName(L.feetNumbnessPrintName);

// ------------- feetPain  -------------
Symptom feetPain = new Symptom(
    LR.feetPain,
    L.feetPainDescription,
    LR.feetSt
);
feetPain.setPrintName(L.feetPainPrintName);

// ------------- fetalHeartTonesAbsent  -------------
Symptom fetalHeartTonesAbsent = new Symptom(
    LR.fetalHeartTonesAbsent,
    L.fetalHeartTonesAbsentDescription,
    LR.uterusSt
);
fetalHeartTonesAbsent.setPrintName(L.fetalHeartTonesAbsentPrintName);

// ------------- fever  -------------
Symptom fever = new Symptom(
    LR.feverSym,
    L.feverDescription,
    LR.bodySt
);
fever.setPrintName(L.feverPrintName);

// ------------- feverIntermittent  -------------
Symptom feverIntermittent = new Symptom(
    LR.feverIntermittent,
    L.feverIntermittentDescription,
    LR.bodySt
);
feverIntermittent.setPrintName(L.feverIntermittentPrintName);

// ------------- feverRapidOnset  -------------
Symptom feverRapidOnset = new Symptom(
    LR.feverRapidOnset,
    L.feverRapidOnsetDescription,
    LR.bodySt
);
feverRapidOnset.setPrintName(L.feverRapidOnsetPrintName);

// ------------- fidgeting  -------------
Symptom fidgeting = new Symptom(
    LR.fidgeting,
    L.fidgetingDescription,
    LR.mindSt
);
fidgeting.setPrintName(L.fidgetingPrintName);

// ------------- fingerBoneLesion  -------------
Symptom fingerBoneLesion = new Symptom(
    LR.fingerBoneLesion,
    L.fingerBoneLesionDescription,
    LR.phalangesSt
);
fingerBoneLesion.setPrintName(L.fingerBoneLesionPrintName);

// ------------- fingerChancre  -------------
Symptom fingerChancre = new Symptom(
    LR.fingerChancre,
    L.fingerChancreDescription,
    LR.fingersSt
);
fingerChancre.setPrintName(L.fingerChancrePrintName);

// ------------- fingerJointDeformity  -------------
Symptom fingerJointDeformity = new Symptom(
    LR.fingerJointDeformity,
    L.fingerJointDeformityDescription,
    LR.fingersSt
);
fingerJointDeformity.setPrintName(L.fingerJointDeformityPrintName);

// ------------- fingerLesion  -------------
Symptom fingerLesion = new Symptom(
    LR.fingerLesion,
    L.fingerLesionDescription,
    LR.fingersSt
);
fingerLesion.setPrintName(L.fingerLesionPrintName);

// ------------- fingerNailsBlue  -------------
Symptom fingerNailsBlue = new Symptom(
    LR.fingerNailsBlue,
    L.fingerNailsBlueDescription,
    LR.fingersSt
);
fingerNailsBlue.setPrintName(L.fingerNailsBluePrintName);

// ------------- fingersNumbness  -------------
Symptom fingersNumbness = new Symptom(
    LR.fingersNumbness,
    L.fingersNumbnessDescription,
    LR.fingersSt
);
fingersNumbness.setPrintName(L.fingersNumbnessPrintName);

// ------------- fingerSpasm  -------------
Symptom fingerSpasm = new Symptom(
    LR.fingerSpasm,
    L.fingerSpasmDescription,
    LR.fingersSt
);
fingerSpasm.setPrintName(L.fingerSpasmPrintName);

// ------------- fingersTingling  -------------
Symptom fingersTingling = new Symptom(
    LR.fingersTingling,
    L.fingersTinglingDescription,
    LR.fingersSt
);
fingersTingling.setPrintName(L.fingersTinglingPrintName);

// -------------- fingerSwelling --------------
// (C) OntoOO Inc Thu Sep 09 15:27:21 GMT-08:00 2004
Symptom fingerSwelling = new Symptom(
    LR.fingerSwelling,
    L.fingerSwellingDescription,
    LR.fingersSt
);
fingerSwelling.setPrintName(L.fingerSwellingPrintName);

// ------------- fitOfAnger  -------------
Symptom fitOfAnger = new Symptom(
    LR.fitOfAnger,
    L.fitOfAngerDescription,
    LR.mindSt
);
fitOfAnger.setPrintName(L.fitOfAngerPrintName);

// ------------- flankPain  -------------
Symptom flankPain = new Symptom(
    LR.flankPain,
    L.flankPainDescription,
    LR.flanksSt
);
flankPain.setPrintName(L.flankPainPrintName);

// ------------- flaringNostrils  -------------
Symptom flaringNostrils = new Symptom(
    LR.flaringNostrils,
    L.flaringNostrilsDescription,
    LR.noseSt
);
flaringNostrils.setPrintName(L.flaringNostrilsPrintName);

// ------------- flashbacks  -------------
Symptom flashbacks = new Symptom(
    LR.flashbacks,
    L.flashbacksDescription,
    LR.mindSt
);
flashbacks.setPrintName(L.flashbacksPrintName);

// ------------- flushing  -------------
Symptom flushing = new Symptom(
    LR.flushing,
    L.flushingDescription,
    LR.skinSt
);
flushing.setPrintName(L.flushingPrintName);

// ------------- focussingDifficulty  -------------
Symptom focussingDifficulty = new Symptom(
    LR.focussingDifficulty,
    L.focussingDifficultyDescription,
    LR.mindSt
);
focussingDifficulty.setPrintName(L.focussingDifficultyPrintName);

// ------------- footSpasm  -------------
Symptom footSpasm = new Symptom(
    LR.footSpasm,
    L.footSpasmDescription,
    LR.feetSt
);
footSpasm.setPrintName(L.footSpasmPrintName);

// ------------- foreSkinVesicle  -------------
Symptom foreSkinVesicle = new Symptom(
    LR.foreSkinVesicle,
    L.foreSkinVesicleDescription,
    LR.foreSkinSt
);
foreSkinVesicle.setPrintName(L.foreSkinVesiclePrintName);

// ------------- forgetfulness  -------------
Symptom forgetfulness = new Symptom(
    LR.forgetfulness,
    L.forgetfulnessDescription,
    LR.mindSt
);
forgetfulness.setPrintName(L.forgetfulnessPrintName);

/*
// ------------- foulSmellingDischarge  -------------
Symptom foulSmellingDischarge = new Symptom(
    LR.foulSmellingDischarge,
    L.foulSmellingDischargeDescription,
    LR.bodySt
);
foulSmellingDischarge.setPrintName(L.foulSmellingDischargePrintName);
*/

// ------------- gas  -------------
Symptom gas = new Symptom(
    LR.gas,
    L.gasDescription,
    LR.colonSt
);
gas.setPrintName(L.gasPrintName);

// ------------- gastricResidueIncreased  -------------
Symptom gastricResidueIncreased = new Symptom(
    LR.gastricResidueIncreased,
    L.gastricResidueIncreasedDescription,
    LR.stomachSt
);
gastricResidueIncreased.setPrintName(L.gastricResidueIncreasedPrintName);

// ------------- gastroparesis  -------------
Symptom gastroparesis = new Symptom(
    LR.gastroparesis,
    L.gastroparesisDescription,
    LR.stomachSt
);
gastroparesis.setPrintName(L.gastroparesisPrintName);

// ------------- genitaliaExposureToStrangers  -------------
Symptom genitaliaExposureToStrangers = new Symptom(
    LR.genitaliaExposureToStrangers,
    L.genitaliaExposureToStrangersDescription,
    LR.mindSt
);
genitaliaExposureToStrangers.setPrintName(L.genitaliaExposureToStrangersPrintName);

// -------------- genitalLesionWhiteGrey --------------
// (C) OntoOO Inc Fri Jul 09 15:40:53 PDT 2004
Symptom genitalLesionWhiteGrey = new Symptom(
    LR.genitalLesionWhiteGrey,
    L.genitalLesionWhiteGreyDescription,
    LR.genitaliaSt
);
genitalLesionWhiteGrey.setPrintName(L.genitalLesionWhiteGreyPrintName);

// ------------- giddiness  -------------
Symptom giddiness = new Symptom(
    LR.giddiness,
    L.giddinessDescription,
    LR.bodySt
);
giddiness.setPrintName(L.giddinessPrintName);

// -------------- goiter --------------
// (C) OntoOO Inc Wed May 19 16:37:33 PDT 2004
Symptom goiter = new Symptom(
    LR.goiter,
    L.goiterDescription,
    LR.thyroidSt
);
goiter.setPrintName(L.goiterPrintName);

// ------------- groinAdenitis  -------------
Symptom groinAdenitis = new Symptom(
    LR.groinAdenitis,
    L.groinAdenitisDescription,
    LR.groinSt
);
groinAdenitis.setPrintName(L.groinAdenitisPrintName);

// ------------- groinLesionItchy  -------------
Symptom groinLesionItchy = new Symptom(
    LR.groinLesionItchy,
    L.groinLesionItchyDescription,
    LR.groinSt
);
groinLesionItchy.setPrintName(L.groinLesionItchyPrintName);
groinLesionItchy.setCardinal();

// ------------- groinLesionRed  -------------
Symptom groinLesionRed = new Symptom(
    LR.groinLesionRed,
    L.groinLesionRedDescription,
    LR.groinSt
);
groinLesionRed.setPrintName(L.groinLesionRedPrintName);

// ------------- groinLymphNodeRuptured  -------------
Symptom groinLymphNodeRuptured = new Symptom(
    LR.groinLymphNodeRuptured,
    L.groinLymphNodeRupturedDescription,
    LR.groinSt
);
groinLymphNodeRuptured.setPrintName(L.groinLymphNodeRupturedPrintName);

// ------------- groinPain  -------------
Symptom groinPain = new Symptom(
    LR.groinPain,
    L.groinPainDescription,
    LR.groinSt
);
groinPain.setPrintName(L.groinPainPrintName);

// ------------- groinPapule  -------------
Symptom groinPapule = new Symptom(
    LR.groinPapule,
    L.groinPapuleDescription,
    LR.groinSt
);
groinPapule.setPrintName(L.groinPapulePrintName);

// ------------- groinStiffness  -------------
Symptom groinStiffness = new Symptom(
    LR.groinStiffness,
    L.groinStiffnessDescription,
    LR.groinSt
);
groinStiffness.setPrintName(L.groinStiffnessPrintName);

// ------------- groinSwelling  -------------
Symptom groinSwelling = new Symptom(
    LR.groinSwelling,
    L.groinSwellingDescription,
    LR.groinSt
);
groinSwelling.setPrintName(L.groinSwellingPrintName);

// ------------- growthRapid  -------------
Symptom growthRapid = new Symptom(
    LR.growthRapid,
    L.growthRapidDescription,
    LR.bodySt
);
growthRapid.setPrintName(L.growthRapidPrintName);

// ------------- grunting  -------------
Symptom grunting = new Symptom(
    LR.grunting,
    L.gruntingDescription,
    LR.throatSt
);
grunting.setPrintName(L.gruntingPrintName);

// ------------- gumPockets  -------------
Symptom gumPockets = new Symptom(
    LR.gumPockets,
    L.gumPocketsDescription,
    LR.gumsSt
);
gumPockets.setPrintName(L.gumPocketsPrintName);

// ------------- gumsBleeding  -------------
Symptom gumsBleeding = new Symptom(
    LR.gumsBleeding,
    L.gumsBleedingDescription,
    LR.gumsSt
);
gumsBleeding.setPrintName(L.gumsBleedingPrintName);

// ------------- gumsSwollen  -------------
Symptom gumsSwollen = new Symptom(
    LR.gumsSwollen,
    L.gumsSwollenDescription,
    LR.gumsSt
);
gumsSwollen.setPrintName(L.gumsSwollenPrintName);

// ------------- hairBroken  -------------
Symptom hairBroken = new Symptom(
    LR.hairBroken,
    L.hairBrokenDescription,
    LR.scalpSt
);
hairBroken.setPrintName(L.hairBrokenPrintName);

// ------------- hairGrowthIncrease  -------------
Symptom hairGrowthIncrease = new Symptom(
    LR.hairGrowthIncrease,
    L.hairGrowthIncreaseDescription,
    LR.scalpSt
);
hairGrowthIncrease.setPrintName(L.hairGrowthIncreasePrintName);

// ------------- hairLoss  -------------
Symptom hairLoss = new Symptom(
    LR.hairLoss,
    L.hairLossDescription,
    LR.scalpSt
);
hairLoss.setPrintName(L.hairLossPrintName);

// ------------- hairSmelly  -------------
Symptom hairSmelly = new Symptom(
    LR.hairSmelly,
    L.hairSmellyDescription,
    LR.scalpSt
);
hairSmelly.setPrintName(L.hairSmellyPrintName);

// ------------- hallucinations  -------------
Symptom hallucinations = new Symptom(
    LR.hallucinations,
    L.hallucinationsDescription,
    LR.mindSt
);
hallucinations.setPrintName(L.hallucinationsPrintName);

// ------------- handBurning  -------------
Symptom handBurning = new Symptom(
    LR.handBurning,
    L.handBurningDescription,
    LR.handsSt
);
handBurning.setPrintName(L.handBurningPrintName);

// ------------- handCold  -------------
Symptom handCold = new Symptom(
    LR.handCold,
    L.handColdDescription,
    LR.handsSt
);
handCold.setPrintName(L.handColdPrintName);

// ------------- handNodule  -------------
Symptom handNodule = new Symptom(
    LR.handNodule,
    L.handNoduleDescription,
    LR.handsSt
);
handNodule.setPrintName(L.handNodulePrintName);

// ------------- handNumbness  -------------
Symptom handNumbness = new Symptom(
    LR.handNumbness,
    L.handNumbnessDescription,
    LR.handsSt
);
handNumbness.setPrintName(L.handNumbnessPrintName);

// ------------- handPain  -------------
Symptom handPain = new Symptom(
    LR.handPain,
    L.handPainDescription,
    LR.handsSt
);
handPain.setPrintName(L.handPainPrintName);

// ------------- handSpasm  -------------
Symptom handSpasm = new Symptom(
    LR.handSpasm,
    L.handSpasmDescription,
    LR.handsSt
);
handSpasm.setPrintName(L.handSpasmPrintName);

// ------------- handTingling  -------------
Symptom handTingling = new Symptom(
    LR.handTingling,
    L.handTinglingDescription,
    LR.handsSt
);
handTingling.setPrintName(L.handTinglingPrintName);

// ------------- handWeak  -------------
Symptom handWeak = new Symptom(
    LR.handWeak,
    L.handWeakDescription,
    LR.handsSt
);
handWeak.setPrintName(L.handWeakPrintName);

// ------------- headache  -------------
Symptom headache = new Symptom(
    LR.headache,
    L.headacheDescription,
    LR.brainSt
);
headache.setPrintName(L.headachePrintName);

// ------------- headacheConstant  -------------
Symptom headacheConstant = new Symptom(
    LR.headacheConstant,
    L.headacheConstantDescription,
    LR.brainSt
);
headacheConstant.setPrintName(L.headacheConstantPrintName);

// ------------- headacheFrontal  -------------
Symptom headacheFrontal = new Symptom(
    LR.headacheFrontal,
    L.headacheFrontalDescription,
    LR.brainSt
);
headacheFrontal.setPrintName(L.headacheFrontalPrintName);

// ------------- headacheSevere  -------------
Symptom headacheSevere = new Symptom(
    LR.headacheSevere,
    L.headacheSevereDescription,
    LR.brainSt
);
headacheSevere.setPrintName(L.headacheSeverePrintName);

// ------------- headSwollen  -------------
Symptom headSwollen = new Symptom(
    LR.headSwollen,
    L.headSwollenDescription,
    LR.headSt
);
headSwollen.setPrintName(L.headSwollenPrintName);

// ------------- hearingLoss  -------------
Symptom hearingLoss = new Symptom(
    LR.hearingLoss,
    L.hearingLossDescription,
    LR.earsSt
);
hearingLoss.setPrintName(L.hearingLossPrintName);

// ------------- heartPain  -------------
Symptom heartPain = new Symptom(
    LR.heartPain,
    L.heartPainDescription,
    LR.heartSt
);
heartPain.setPrintName(L.heartPainPrintName);

// ------------- heartburn  -------------
Symptom heartburn = new Symptom(
    LR.heartburn,
    L.heartburnDescription,
    LR.stomachSt
);
heartburn.setPrintName(L.heartburnPrintName);

// ------------- heatSensitivity  -------------
Symptom heatSensitivity = new Symptom(
    LR.heatSensitivity,
    L.heatSensitivityDescription,
    LR.mindSt
);
heatSensitivity.setPrintName(L.heatSensitivityPrintName);

// ------------- heightLoss  -------------
Symptom heightLoss = new Symptom(
    LR.heightLoss,
    L.heightLossDescription,
    LR.bodySt
);
heightLoss.setPrintName(L.heightLossPrintName);

// ------------- hematuria  -------------
Symptom hematuria = new Symptom(
    LR.hematuria,
    L.hematuriaDescription,
    LR.bladderSt
);
hematuria.setPrintName(L.hematuriaPrintName);
hematuria.setCardinal();

// ------------- hemiparesis  -------------
Symptom hemiparesis = new Symptom(
    LR.hemiparesis,
    L.hemiparesisDescription,
    LR.bodySt
);
hemiparesis.setPrintName(L.hemiparesisPrintName);

// ------------- hemoptysis  -------------
Symptom hemoptysis = new Symptom(
    LR.hemoptysis,
    L.hemoptysisDescription,
    LR.mouthSt
);
hemoptysis.setPrintName(L.hemoptysisPrintName);

// ------------- hemorrhage  -------------
Symptom hemorrhage = new Symptom(
    LR.hemorrhage,
    L.hemorrhageDescription,
    LR.bodySt
);
hemorrhage.setPrintName(L.hemorrhagePrintName);

// ------------- hemospermia  -------------
Symptom hemospermia = new Symptom(
    LR.hemospermia,
    L.hemospermiaDescription,
    LR.penisSt
);
hemospermia.setPrintName(L.hemospermiaPrintName);

// ------------- hiccups  -------------
Symptom hiccups = new Symptom(
    LR.hiccups,
    L.hiccupsDescription,
    LR.lungsSt
);
hiccups.setPrintName(L.hiccupsPrintName);

// ------------- hipPain  -------------
Symptom hipPain = new Symptom(
    LR.hipPain,
    L.hipPainDescription,
    LR.hipsSt
);
hipPain.setPrintName(L.hipPainPrintName);

// -------------- hirsutism --------------
// (C) OntoOO Inc Sun Feb 22 17:08:49 PST 2004
Symptom hirsutism = new Symptom(
    LR.hirsutism,
    L.hirsutismDescription,
    LR.skinSt
);
hirsutism.setPrintName(L.hirsutismPrintName);

// ------------- hoarseness  -------------
Symptom hoarseness = new Symptom(
    LR.hoarseness,
    L.hoarsenessDescription,
    LR.throatSt
);
hoarseness.setPrintName(L.hoarsenessPrintName);

// ------------- hostility  -------------
Symptom hostility = new Symptom(
    LR.hostility,
    L.hostilityDescription,
    LR.mindSt
);
hostility.setPrintName(L.hostilityPrintName);

// ------------- hotFlash  -------------
Symptom hotFlash = new Symptom(
    LR.hotFlash,
    L.hotFlashDescription,
    LR.bodySt
);
hotFlash.setPrintName(L.hotFlashPrintName);

// ------------- hungerExcessive  -------------
Symptom hungerExcessive = new Symptom(
    LR.hungerExcessive,
    L.hungerExcessiveDescription,
    LR.bodySt
);
hungerExcessive.setPrintName(L.hungerExcessivePrintName);

// ------------- hydrophobia  -------------
Symptom hydrophobia = new Symptom(
    LR.hydrophobia,
    L.hydrophobiaDescription,
    LR.mouthSt
);
hydrophobia.setPrintName(L.hydrophobiaPrintName);

// ------------- hyperactivity  -------------
Symptom hyperactivity = new Symptom(
    LR.hyperactivity,
    L.hyperactivityDescription,
    LR.mindSt
);
hyperactivity.setPrintName(L.hyperactivityPrintName);

// ------------- hyperesthesia  -------------
Symptom hyperesthesia = new Symptom(
    LR.hyperesthesia,
    L.hyperesthesiaDescription,
    LR.bodySt
);
hyperesthesia.setPrintName(L.hyperesthesiaPrintName);

// ------------- hyperventilation  -------------
Symptom hyperventilation = new Symptom(
    LR.hyperventilation,
    L.hyperventilationDescription,
    LR.lungsSt
);
hyperventilation.setPrintName(L.hyperventilationPrintName);

// ------------- hypotension  -------------
Symptom hypotension = new Symptom(
    LR.hypotension,
    L.hypotensionDescription,
    LR.bloodstreamSt
);
hypotension.setPrintName(L.hypotensionPrintName);

// ------------- hypothermia  -------------
Symptom hypothermia = new Symptom(
    LR.hypothermia,
    L.hypothermiaDescription,
    LR.bodySt
);
hypothermia.setPrintName(L.hypothermiaPrintName);

// ------------- hypoventilation  -------------
Symptom hypoventilation = new Symptom(
    LR.hypoventilation,
    L.hypoventilationDescription,
    LR.lungsSt
);
hypoventilation.setPrintName(L.hypoventilationPrintName);

// ------------- impulsive  -------------
Symptom impulsive = new Symptom(
    LR.impulsive,
    L.impulsiveDescription,
    LR.mindSt
);
impulsive.setPrintName(L.impulsivePrintName);

// ------------- inattention  -------------
Symptom inattention = new Symptom(
    LR.inattention,
    L.inattentionDescription,
    LR.mindSt
);
inattention.setPrintName(L.inattentionPrintName);

// ------------- incoherence  -------------
Symptom incoherence = new Symptom(
    LR.incoherence,
    L.incoherenceDescription,
    LR.mindSt
);
incoherence.setPrintName(L.incoherencePrintName);

// ------------- incontinence  -------------
Symptom incontinence = new Symptom(
    LR.incontinence,
    L.incontinenceDescription,
    LR.bladderSt
);
incontinence.setPrintName(L.incontinencePrintName);

// ------------- indecisive  -------------
Symptom indecisive = new Symptom(
    LR.indecisive,
    L.indecisiveDescription,
    LR.mindSt
);
indecisive.setPrintName(L.indecisivePrintName);

// ------------- indigestion  -------------
/* see dyspepsia
Symptom indigestion = new Symptom(
    LR.indigestion,
    L.indigestionDescription,
    LR.stomachSt
);
indigestion.setPrintName(L.indigestionPrintName);
*/

// ------------- infectionSiteCrepitation  -------------
Symptom infectionSiteCrepitation = new Symptom(
    LR.infectionSiteCrepitation,
    L.infectionSiteCrepitationDescription,
    LR.bodySt
);
infectionSiteCrepitation.setPrintName(L.infectionSiteCrepitationPrintName);

// ------------- infertilityFemaleSymptom  -------------
Symptom infertilityFemaleSymptom = new Symptom(
    LR.infertilityFemaleSymptom,
    L.infertilityFemaleSymptomDescription,
    LR.uterusSt
);
infertilityFemaleSymptom.setPrintName(L.infertilityFemaleSymptomPrintName);

// ------------- infertilityMaleSymptom  -------------
Symptom infertilityMaleSymptom = new Symptom(
    LR.infertilityMaleSymptom,
    L.infertilityMaleSymptomDescription,
    LR.testiclesSt
);
infertilityMaleSymptom.setPrintName(L.infertilityMaleSymptomPrintName);

// ------------- insectSting  -------------
Symptom insectSting = new Symptom(
    LR.insectSting,
    L.insectStingDescription,
    LR.skinSt
);
insectSting.setPrintName(L.insectStingPrintName);

// -------------- intellectImpaired --------------
// (C) OntoOO Inc Tue May 11 16:34:00 PDT 2004
Symptom intellectImpaired = new Symptom(
    LR.intellectImpaired,
    L.intellectImpairedDescription,
    LR.mindSt
);
intellectImpaired.setPrintName(L.intellectImpairedPrintName);

// ------------- intercourseDiscomfort  -------------
Symptom intercourseDiscomfort = new Symptom(
    LR.intercourseDiscomfort,
    L.intercourseDiscomfortDescription,
    LR.mindSt
);
intercourseDiscomfort.setPrintName(L.intercourseDiscomfortPrintName);

// ------------- irritability  -------------
Symptom irritability = new Symptom(
    LR.irritability,
    L.irritabilityDescription,
    LR.mindSt
);
irritability.setPrintName(L.irritabilityPrintName);

// ------------- itches  -------------
Symptom itches = new Symptom(
    LR.itches,
    L.itchesDescription,
    LR.skinSt
);
itches.setPrintName(L.itchesPrintName);

// ------------- jaundice  -------------
Symptom jaundice = new Symptom(
    LR.jaundice,
    L.jaundiceDescription,
    LR.skinSt
);
jaundice.setPrintName(L.jaundicePrintName);
jaundice.setCardinal();

// ------------- jawPain  -------------
Symptom jawPain = new Symptom(
    LR.jawPain,
    L.jawPainDescription,
    LR.jawsSt
);
jawPain.setPrintName(L.jawPainPrintName);

// ------------- jointHot  -------------
Symptom jointHot = new Symptom(
    LR.jointHot,
    L.jointHotDescription,
    LR.jointsSt
);
jointHot.setPrintName(L.jointHotPrintName);

// ------------- jointNodule  -------------
Symptom jointNodule = new Symptom(
    LR.jointNodule,
    L.jointNoduleDescription,
    LR.jointsSt
);
jointNodule.setPrintName(L.jointNodulePrintName);

// ------------- jointPain  -------------
Symptom jointPain = new Symptom(
    LR.jointPain,
    L.jointPainDescription,
    LR.jointsSt
);
jointPain.setPrintName(L.jointPainPrintName);

// ------------- jointRedness  -------------
Symptom jointRedness = new Symptom(
    LR.jointRedness,
    L.jointRednessDescription,
    LR.jointsSt
);
jointRedness.setPrintName(L.jointRednessPrintName);

// ------------- jointStiffen  -------------
Symptom jointStiffen = new Symptom(
    LR.jointStiffen,
    L.jointStiffenDescription,
    LR.jointsSt
);
jointStiffen.setPrintName(L.jointStiffenPrintName);

// ------------- jointSwelling  -------------
Symptom jointSwelling = new Symptom(
    LR.jointSwelling,
    L.jointSwellingDescription,
    LR.jointsSt
);
jointSwelling.setPrintName(L.jointSwellingPrintName);

// ------------- jointTender  -------------
Symptom jointTender = new Symptom(
    LR.jointTender,
    L.jointTenderDescription,
    LR.jointsSt
);
jointTender.setPrintName(L.jointTenderPrintName);

// ------------- judgementImpaired  -------------
Symptom judgementImpaired = new Symptom(
    LR.judgementImpaired,
    L.judgementImpairedDescription,
    LR.mindSt
);
judgementImpaired.setPrintName(L.judgementImpairedPrintName);

// ------------- kneePain  -------------
Symptom kneePain = new Symptom(
    LR.kneePain,
    L.kneePainDescription,
    LR.kneesSt
);
kneePain.setPrintName(L.kneePainPrintName);

// ------------- labiaVesicle  -------------
Symptom labiaVesicle = new Symptom(
    LR.labiaVesicle,
    L.labiaVesicleDescription,
    LR.labiaSt
);
labiaVesicle.setPrintName(L.labiaVesiclePrintName);

// ------------- lacrimation  -------------
Symptom lacrimation = new Symptom(
    LR.lacrimation,
    L.lacrimationDescription,
    LR.eyesSt
);
lacrimation.setPrintName(L.lacrimationPrintName);

// ------------- lactationAbnormal  -------------
Symptom lactationAbnormal = new Symptom(
    LR.lactationAbnormal,
    L.lactationAbnormalDescription,
    LR.breastsFemaleSt
);
lactationAbnormal.setPrintName(L.lactationAbnormalPrintName);

// ------------- languageDetoriation  -------------
Symptom languageDetoriation = new Symptom(
    LR.languageDetoriation,
    L.languageDetoriationDescription,
    LR.mindSt
);
languageDetoriation.setPrintName(L.languageDetoriationPrintName);

// ------------- lassitude  -------------
/*
Symptom lassitude = new Symptom(
    LR.lassitude,
    L.lassitudeDescription,
    LR.bodySt
);
lassitude.setPrintName(L.lassitudePrintName);
*/

// ------------- laughing  -------------
Symptom laughing = new Symptom(
    LR.laughing,
    L.laughingDescription,
    LR.throatSt
);
laughing.setPrintName(L.laughingPrintName);

// ------------- learningDifficulty  -------------
Symptom learningDifficulty = new Symptom(
    LR.learningDifficulty,
    L.learningDifficultyDescription,
    LR.mindSt
);
learningDifficulty.setPrintName(L.learningDifficultyPrintName);

// ------------- legCramps  -------------
Symptom legCramps = new Symptom(
    LR.legCramps,
    L.legCrampsDescription,
    LR.legsSt
);
legCramps.setPrintName(L.legCrampsPrintName);

// ------------- legEdema  -------------
Symptom legEdema = new Symptom(
    LR.legEdema,
    L.legEdemaDescription,
    LR.legsSt
);
legEdema.setPrintName(L.legEdemaPrintName);

// ------------- legPain  -------------
Symptom legPain = new Symptom(
    LR.legPain,
    L.legPainDescription,
    LR.legsSt
);
legPain.setPrintName(L.legPainPrintName);

// ------------- legStiff  -------------
Symptom legStiff = new Symptom(
    LR.legStiff,
    L.legStiffDescription,
    LR.legsSt
);
legStiff.setPrintName(L.legStiffPrintName);

// ------------- legWeakness  -------------
Symptom legWeakness = new Symptom(
    LR.legWeakness,
    L.legWeaknessDescription,
    LR.legsSt
);
legWeakness.setPrintName(L.legWeaknessPrintName);

/*
// ------------- legsStiff  -------------
Symptom legsStiff = new Symptom(
    LR.legsStiff,
    L.legsStiffDescription,
    LR.legsSt
);
legsStiff.setPrintName(L.legsStiffPrintName);
*/

// ------------- lethargy  -------------
Symptom lethargy = new Symptom(
    LR.lethargy,
    L.lethargyDescription,
    LR.mindSt
);
lethargy.setPrintName(L.lethargyPrintName);
lethargy.setCardinal();

// ------------- libidoLoss  -------------
Symptom libidoLoss = new Symptom(
    LR.libidoLoss,
    L.libidoLossDescription,
    LR.mindSt
);
libidoLoss.setPrintName(L.libidoLossPrintName);

// ------------- lightHeadedness  -------------
Symptom lightHeadedness = new Symptom(
    LR.lightHeadedness,
    L.lightHeadednessDescription,
    LR.brainSt
);
lightHeadedness.setPrintName(L.lightHeadednessPrintName);

// ------------- limbsBurning  -------------
Symptom limbsBurning = new Symptom(
    LR.limbsBurning,
    L.limbsBurningDescription,
    LR.limbsSt
);
limbsBurning.setPrintName(L.limbsBurningPrintName);

// ------------- limbsNumbness  -------------
Symptom limbsNumbness = new Symptom(
    LR.limbsNumbness,
    L.limbsNumbnessDescription,
    LR.limbsSt
);
limbsNumbness.setPrintName(L.limbsNumbnessPrintName);

// ------------- limbsPinsAndNeedles  -------------
Symptom limbsPinsAndNeedles = new Symptom(
    LR.limbsPinsAndNeedles,
    L.limbsPinsAndNeedlesDescription,
    LR.limbsSt
);
limbsPinsAndNeedles.setPrintName(L.limbsPinsAndNeedlesPrintName);

// ------------- limbsTingling  -------------
Symptom limbsTingling = new Symptom(
    LR.limbsTingling,
    L.limbsTinglingDescription,
    LR.limbsSt
);
limbsTingling.setPrintName(L.limbsTinglingPrintName);

// ------------- limbsWeak  -------------
Symptom limbsWeak = new Symptom(
    LR.limbsWeak,
    L.limbsWeakDescription,
    LR.limbsSt
);
limbsWeak.setPrintName(L.limbsWeakPrintName);

// ------------- lipChancre  -------------
Symptom lipChancre = new Symptom(
    LR.lipChancre,
    L.lipChancreDescription,
    LR.lipsSt
);
lipChancre.setPrintName(L.lipChancrePrintName);

// -------------- lipLowerHanging --------------
// (C) OntoOO Inc Thu Aug 12 14:16:25 GMT-08:00 2004
Symptom lipLowerHanging = new Symptom(
    LR.lipLowerHanging,
    L.lipLowerHangingDescription,
    LR.lipsSt
);
lipLowerHanging.setPrintName(L.lipLowerHangingPrintName);

// ------------- lipPapule  -------------
Symptom lipPapule = new Symptom(
    LR.lipPapule,
    L.lipPapuleDescription,
    LR.lipsSt
);
lipPapule.setPrintName(L.lipPapulePrintName);

// ------------- lipsBlue  -------------
Symptom lipsBlue = new Symptom(
    LR.lipsBlue,
    L.lipsBlueDescription,
    LR.lipsSt
);
lipsBlue.setPrintName(L.lipsBluePrintName);

// ------------- lipsSwollen  -------------
Symptom lipsSwollen = new Symptom(
    LR.lipsSwollen,
    L.lipsSwollenDescription,
    LR.lipsSt
);
lipsSwollen.setPrintName(L.lipsSwollenPrintName);

// ------------- lipsPale  -------------
Symptom lipsPale = new Symptom(
    LR.lipsPale,
    L.lipsPaleDescription,
    LR.lipsSt
);
lipsPale.setPrintName(L.lipsPalePrintName);

// ------------- listlessness  -------------
Symptom listlessness = new Symptom(
    LR.listlessness,
    L.listlessnessDescription,
    LR.mindSt
);
listlessness.setPrintName(L.listlessnessPrintName);

// ------------- liverEnlarged  -------------
Symptom liverEnlarged = new Symptom(
    LR.liverEnlarged,
    L.liverEnlargedDescription,
    LR.liverSt
);
liverEnlarged.setPrintName(L.liverEnlargedPrintName);

// ------------- liverPain  -------------
Symptom liverPain = new Symptom(
    LR.liverPain,
    L.liverPainDescription,
    LR.liverSt
);
liverPain.setPrintName(L.liverPainPrintName);

// ------------- liverTender  -------------
Symptom liverTender = new Symptom(
    LR.liverTender,
    L.liverTenderDescription,
    LR.liverSt
);
liverTender.setPrintName(L.liverTenderPrintName);

// ------------- lochia  -------------
Symptom lochia = new Symptom(
    LR.lochia,
    L.lochiaDescription,
    LR.vaginaSt
);
lochia.setPrintName(L.lochiaPrintName);

// ------------- lochiaHeavy  -------------
Symptom lochiaHeavy = new Symptom(
    LR.lochiaHeavy,
    L.lochiaHeavyDescription,
    LR.vaginaSt
);
lochiaHeavy.setPrintName(L.lochiaHeavyPrintName);

// ------------- lockjaw  -------------
Symptom lockjaw = new Symptom(
    LR.lockjaw,
    L.lockjawDescription,
    LR.jawsSt
);
lockjaw.setPrintName(L.lockjawPrintName);

// -------------- lordosis --------------
// (C) OntoOO Inc Wed Aug 11 14:48:15 GMT-08:00 2004
Symptom lordosis = new Symptom(
    LR.lordosis,
    L.lordosisDescription,
    LR.spineSt
);
lordosis.setPrintName(L.lordosisPrintName);

// ------------- lossOfBalance  -------------
Symptom lossOfBalance = new Symptom(
    LR.lossOfBalance,
    L.lossOfBalanceDescription,
    LR.bodySt
);
lossOfBalance.setPrintName(L.lossOfBalancePrintName);

// ------------- lossOfCoordination  -------------
Symptom lossOfCoordination = new Symptom(
    LR.lossOfCoordination,
    L.lossOfCoordinationDescription,
    LR.bodySt
);
lossOfCoordination.setPrintName(L.lossOfCoordinationPrintName);

// ------------- lowBackPain  -------------
Symptom lowBackPain = new Symptom(
    LR.lowBackPain,
    L.lowBackPainDescription,
    LR.backSt
);
lowBackPain.setPrintName(L.lowBackPainPrintName);

// ------------- lumbarPain  -------------
Symptom lumbarPain = new Symptom(
    LR.lumbarPain,
    L.lumbarPainDescription,
    LR.lumbarSt
);
lumbarPain.setPrintName(L.lumbarPainPrintName);

// ------------- lymphNodePainful  -------------
Symptom lymphNodePainful = new Symptom(
    LR.lymphNodePainful,
    L.lymphNodePainfulDescription,
    LR.lymphNodesSt
);
lymphNodePainful.setPrintName(L.lymphNodePainfulPrintName);

// ------------- lymphNodeSwollen  -------------
/*
Symptom lymphNodeSwollen = new Symptom(
    LR.lymphNodeSwollen,
    L.lymphNodeSwollenDescription,
    LR.lymphNodesSt
);
lymphNodeSwollen.setPrintName(L.lymphNodeSwollenPrintName);
*/

// ------------- lymphadenitis  -------------
Symptom lymphadenitis = new Symptom(
    LR.lymphadenitis,
    L.lymphadenitisDescription,
    LR.aLymphNodeSt
);
lymphadenitis.setPrintName(L.lymphadenitisPrintName);

// ------------- lymphadenopathy  -------------
Symptom lymphadenopathy = new Symptom(
    LR.lymphadenopathy,
    L.lymphadenopathyDescription,
    LR.lymphNodesSt
);
lymphadenopathy.setPrintName(L.lymphadenopathyPrintName);

// ------------- maculeEncrusted  -------------
Symptom maculeEncrusted = new Symptom(
    LR.maculeEncrusted,
    L.maculeEncrustedDescription,
    LR.skinSt
);
maculeEncrusted.setPrintName(L.maculeEncrustedPrintName);

// ------------- maculePustular  -------------
Symptom maculePustular = new Symptom(
    LR.maculePustular,
    L.maculePustularDescription,
    LR.skinSt
);
maculePustular.setPrintName(L.maculePustularPrintName);

// ------------- maculopapularEruption  -------------
Symptom maculopapularEruption = new Symptom(
    LR.maculopapularEruption,
    L.maculopapularEruptionDescription,
    LR.skinSt
);
maculopapularEruption.setPrintName(L.maculopapularEruptionPrintName);

// ------------- malaise  -------------
Symptom malaise = new Symptom(
    LR.malaise,
    L.malaiseDescription,
    LR.mindSt
);
malaise.setPrintName(L.malaisePrintName);

// ------------- meatalTenderness  -------------
Symptom meatalTenderness = new Symptom(
    LR.meatalTenderness,
    L.meatalTendernessDescription,
    LR.vaginaSt
);
meatalTenderness.setPrintName(L.meatalTendernessPrintName);

// ------------- melena  -------------
Symptom melena = new Symptom(
    LR.melena,
    L.melenaDescription,
    LR.bodySt
);
melena.setPrintName(L.melenaPrintName);

// ------------- memoryDetoriation  -------------
Symptom memoryDetoriation = new Symptom(
    LR.memoryDetoriation,
    L.memoryDetoriationDescription,
    LR.mindSt
);
memoryDetoriation.setPrintName(L.memoryDetoriationPrintName);

// ------------- memoryRecentLoss  -------------
Symptom memoryRecentLoss = new Symptom(
    LR.memoryRecentLoss,
    L.memoryRecentLossDescription,
    LR.mindSt
);
memoryRecentLoss.setPrintName(L.memoryRecentLossPrintName);

// ------------- menarcheEarly  -------------
Symptom menarcheEarly = new Symptom(
    LR.menarcheEarly,
    L.menarcheEarlyDescription,
    LR.uterusSt
);
menarcheEarly.setPrintName(L.menarcheEarlyPrintName);

// ------------- menstruationAbsence  -------------
Symptom menstruationAbsence = new Symptom(
    LR.menstruationAbsence,
    L.menstruationAbsenceDescription,
    LR.bodySt
);
menstruationAbsence.setPrintName(L.menstruationAbsencePrintName);

// ------------- menstruationDeficient  -------------
Symptom menstruationDeficient = new Symptom(
    LR.menstruationDeficient,
    L.menstruationDeficientDescription,
    LR.uterusSt
);
menstruationDeficient.setPrintName(L.menstruationDeficientPrintName);

// ------------- menstruationFlowDecrease  -------------
Symptom menstruationFlowDecrease = new Symptom(
    LR.menstruationFlowDecrease,
    L.menstruationFlowDecreaseDescription,
    LR.uterusSt
);
menstruationFlowDecrease.setPrintName(L.menstruationFlowDecreasePrintName);

// ------------- menstruationInfrequent  -------------
Symptom menstruationInfrequent = new Symptom(
    LR.menstruationInfrequent,
    L.menstruationInfrequentDescription,
    LR.uterusSt
);
menstruationInfrequent.setPrintName(L.menstruationInfrequentPrintName);

// ------------- menstruationIrregular  -------------
Symptom menstruationIrregular = new Symptom(
    LR.menstruationIrregular,
    L.menstruationIrregularDescription,
    LR.uterusSt
);
menstruationIrregular.setPrintName(L.menstruationIrregularPrintName);

// ------------- menstruationPainful  -------------
Symptom menstruationPainful = new Symptom(
    LR.menstruationPainful,
    L.menstruationPainfulDescription,
    LR.uterusSt
);
menstruationPainful.setPrintName(L.menstruationPainfulPrintName);

// ------------- menstruationProfuse  -------------
Symptom menstruationProfuse = new Symptom(
    LR.menstruationProfuse,
    L.menstruationProfuseDescription,
    LR.uterusSt
);
menstruationProfuse.setPrintName(L.menstruationProfusePrintName);

// ------------- menstruationTooFrequent  -------------
Symptom menstruationTooFrequent = new Symptom(
    LR.menstruationTooFrequent,
    L.menstruationTooFrequentDescription,
    LR.uterusSt
);
menstruationTooFrequent.setPrintName(L.menstruationTooFrequentPrintName);

// ------------- mentalDepression  -------------
Symptom mentalDepression = new Symptom(
    LR.mentalDepression,
    L.mentalDepressionDescription,
    LR.mindSt
);
mentalDepression.setPrintName(L.mentalDepressionPrintName);

// -------------- mentalInstability --------------
// (C) OntoOO Inc Thu May 20 16:57:18 PDT 2004
Symptom mentalInstability = new Symptom(
    LR.mentalInstability,
    L.mentalInstabilityDescription,
    LR.mindSt
);
mentalInstability.setPrintName(L.mentalInstabilityPrintName);

// ------------- moodSad  -------------
Symptom moodSad = new Symptom(
    LR.moodSad,
    L.moodSadDescription,
    LR.mindSt
);
moodSad.setPrintName(L.moodSadPrintName);

// ------------- moodSwings  -------------
Symptom moodSwings = new Symptom(
    LR.moodSwings,
    L.moodSwingsDescription,
    LR.mindSt
);
moodSwings.setPrintName(L.moodSwingsPrintName);

// -------------- moonFace --------------
// (C) OntoOO Inc Sun Feb 22 16:59:47 PST 2004
Symptom moonFace = new Symptom(
    LR.moonFace,
    L.moonFaceDescription,
    LR.faceSt
);
moonFace.setPrintName(L.moonFacePrintName);

// ------------- motivationLoss  -------------
Symptom motivationLoss = new Symptom(
    LR.motivationLoss,
    L.motivationLossDescription,
    LR.mindSt
);
motivationLoss.setPrintName(L.motivationLossPrintName);

// ------------- motorDysfunction  -------------
Symptom motorDysfunction = new Symptom(
    LR.motorDysfunction,
    L.motorDysfunctionDescription,
    LR.bodySt
);
motorDysfunction.setPrintName(L.motorDysfunctionPrintName);

// ------------- mouthDroops  -------------
Symptom mouthDroops = new Symptom(
    LR.mouthDroops,
    L.mouthDroopsDescription,
    LR.mouthSt
);
mouthDroops.setPrintName(L.mouthDroopsPrintName);
mouthDroops.setCardinal();

// ------------- mouthDry  -------------
Symptom mouthDry = new Symptom(
    LR.mouthDry,
    L.mouthDryDescription,
    LR.mouthSt
);
mouthDry.setPrintName(L.mouthDryPrintName);

// ------------- mouthItches  -------------
Symptom mouthItches = new Symptom(
    LR.mouthItches,
    L.mouthItchesDescription,
    LR.mouthSt
);
mouthItches.setPrintName(L.mouthItchesPrintName);

// ------------- mouthLesion  -------------
Symptom mouthLesion = new Symptom(
    LR.mouthLesion,
    L.mouthLesionDescription,
    LR.mouthSt
);
mouthLesion.setPrintName(L.mouthLesionPrintName);

// -------------- mouthLesionWhiteGrey --------------
// (C) OntoOO Inc Fri Jul 09 15:17:35 PDT 2004
Symptom mouthLesionWhiteGrey = new Symptom(
    LR.mouthLesionWhiteGrey,
    L.mouthLesionWhiteGreyDescription,
    LR.mouthSt
);
mouthLesionWhiteGrey.setPrintName(L.mouthLesionWhiteGreyPrintName);

// ------------- mouthNumbness  -------------
Symptom mouthNumbness = new Symptom(
    LR.mouthNumbness,
    L.mouthNumbnessDescription,
    LR.mouthSt
);
mouthNumbness.setPrintName(L.mouthNumbnessPrintName);

// ------------- mouthPain  -------------
Symptom mouthPain = new Symptom(
    LR.mouthPain,
    L.mouthPainDescription,
    LR.mouthSt
);
mouthPain.setPrintName(L.mouthPainPrintName);

// -------------- mouthPatchWhite --------------
// (C) OntoOO Inc Mon Feb 02 17:12:03 PST 2004
Symptom mouthPatchWhite = new Symptom(
    LR.mouthPatchWhite,
    L.mouthPatchWhiteDescription,
    LR.mouthSt
);
mouthPatchWhite.setPrintName(L.mouthPatchWhitePrintName);

// -------------- mouthPatchYellow --------------
// (C) OntoOO Inc Mon Feb 02 17:12:03 PST 2004
Symptom mouthPatchYellow = new Symptom(
    LR.mouthPatchYellow,
    L.mouthPatchYellowDescription,
    LR.mouthSt
);
mouthPatchYellow.setPrintName(L.mouthPatchYellowPrintName);

// ------------- mouthSore  -------------
Symptom mouthSore = new Symptom(
    LR.mouthSore,
    L.mouthSoreDescription,
    LR.mouthSt
);
mouthSore.setPrintName(L.mouthSorePrintName);

// ------------- mouthSwollen  -------------
Symptom mouthSwollen = new Symptom(
    LR.mouthSwollen,
    L.mouthSwollenDescription,
    LR.mouthSt
);
mouthSwollen.setPrintName(L.mouthSwollenPrintName);

// ------------- mouthTasteMetallic  -------------
Symptom mouthTasteMetallic = new Symptom(
    LR.mouthTasteMetallic,
    L.mouthTasteMetallicDescription,
    LR.mouthSt
);
mouthTasteMetallic.setPrintName(L.mouthTasteMetallicPrintName);

// ------------- mouthTingling  -------------
Symptom mouthTingling = new Symptom(
    LR.mouthTingling,
    L.mouthTinglingDescription,
    LR.mouthSt
);
mouthTingling.setPrintName(L.mouthTinglingPrintName);


// ------------- mouthUlcers  -------------
Symptom mouthUlcers = new Symptom(
    LR.mouthUlcers,
    L.mouthUlcersDescription,
    LR.mouthSt
);
mouthUlcers.setPrintName(L.mouthUlcersPrintName);

// ------------- movementsJerky  -------------
Symptom movementsJerky = new Symptom(
    LR.movementsJerky,
    L.movementsJerkyDescription,
    LR.bodySt
);
movementsJerky.setPrintName(L.movementsJerkyPrintName);

// ------------- mucousMembraneGumma  -------------
Symptom mucousMembraneGumma = new Symptom(
    LR.mucousMembraneGumma,
    L.mucousMembraneGummaDescription,
    LR.mucousMembranesSt
);
mucousMembraneGumma.setPrintName(L.mucousMembraneGummaPrintName);

// ------------- mucousMembranesDry  -------------
Symptom mucousMembranesDry = new Symptom(
    LR.mucousMembranesDry,
    L.mucousMembranesDryDescription,
    LR.mucousMembranesSt
);
mucousMembranesDry.setPrintName(L.mucousMembranesDryPrintName);

// ------------- murmurLoud  -------------
Symptom murmurLoud = new Symptom(
    LR.murmurLoud,
    L.murmurLoudDescription,
    LR.heartSt
);
murmurLoud.setPrintName(L.murmurLoudPrintName);

// ------------- muscleAches  -------------
/*
Symptom muscleAches = new Symptom(
    LR.muscleAches,
    L.muscleAchesDescription,
    LR.aMuscleSt
);
muscleAches.setPrintName(L.muscleAchesPrintName);
*/

// ------------- muscleContractions  -------------
Symptom muscleContractions = new Symptom(
    LR.muscleContractions,
    L.muscleContractionsDescription,
    LR.aMuscleSt
);
muscleContractions.setPrintName(L.muscleContractionsPrintName);

// ------------- muscleCramps  -------------
Symptom muscleCramps = new Symptom(
    LR.muscleCramps,
    L.muscleCrampsDescription,
    LR.aMuscleSt
);
muscleCramps.setPrintName(L.muscleCrampsPrintName);

// ------------- muscleDevelopmentEarly  -------------
Symptom muscleDevelopmentEarly = new Symptom(
    LR.muscleDevelopmentEarly,
    L.muscleDevelopmentEarlyDescription,
    LR.aMuscleSt
);
muscleDevelopmentEarly.setPrintName(L.muscleDevelopmentEarlyPrintName);

// ------------- muscleHypertonicity  -------------
Symptom muscleHypertonicity = new Symptom(
    LR.muscleHypertonicity,
    L.muscleHypertonicityDescription,
    LR.aMuscleSt
);
muscleHypertonicity.setPrintName(L.muscleHypertonicityPrintName);

// ------------- muscleLoss  -------------
Symptom muscleLoss = new Symptom(
    LR.muscleLoss,
    L.muscleLossDescription,
    LR.aMuscleSt
);
muscleLoss.setPrintName(L.muscleLossPrintName);

// ------------- muscleRigid  -------------
Symptom muscleRigid = new Symptom(
    LR.muscleRigid,
    L.muscleRigidDescription,
    LR.aMuscleSt
);
muscleRigid.setPrintName(L.muscleRigidPrintName);

// -------------- muscleTender --------------
// (C) OntoOO Inc Fri Aug 27 12:41:56 GMT-08:00 2004
Symptom muscleTender = new Symptom(
    LR.muscleTender,
    L.muscleTenderDescription,
    LR.aMuscleSt
);
muscleTender.setPrintName(L.muscleTenderPrintName);

// ------------- muscleUnderdeveloped  -------------
Symptom muscleUnderdeveloped = new Symptom(
    LR.muscleUnderdeveloped,
    L.muscleUnderdevelopedDescription,
    LR.aMuscleSt
);
muscleUnderdeveloped.setPrintName(L.muscleUnderdevelopedPrintName);

// ------------- muscleWeakness  -------------
Symptom muscleWeakness = new Symptom(
    LR.muscleWeakness,
    L.muscleWeaknessDescription,
    LR.aMuscleSt
);
muscleWeakness.setPrintName(L.muscleWeaknessPrintName);

// ------------- myalgia  -------------
Symptom myalgia = new Symptom(
    LR.myalgia,
    L.myalgiaDescription,
    LR.bodySt
);
myalgia.setPrintName(L.myalgiaPrintName);

// ------------- nailBedRed  -------------
Symptom nailBedRed = new Symptom(
    LR.nailBedRed,
    L.nailBedRedDescription,
    LR.nailsSt
);
nailBedRed.setPrintName(L.nailBedRedPrintName);

// ------------- nailBedSwollen  -------------
Symptom nailBedSwollen = new Symptom(
    LR.nailBedSwollen,
    L.nailBedSwollenDescription,
    LR.nailsSt
);
nailBedSwollen.setPrintName(L.nailBedSwollenPrintName);
nailBedSwollen.setCardinal();

// ------------- nailBrittle  -------------
Symptom nailBrittle = new Symptom(
    LR.nailBrittle,
    L.nailBrittleDescription,
    LR.nailsSt
);
nailBrittle.setPrintName(L.nailBrittlePrintName);

// ------------- nailsPale  -------------
Symptom nailsPale = new Symptom(
    LR.nailsPale,
    L.nailsPaleDescription,
    LR.nailsSt
);
nailsPale.setPrintName(L.nailsPalePrintName);

// -------------- nasolabialFoldAbsent --------------
// (C) OntoOO Inc Mon Aug 16 14:07:29 GMT-08:00 2004
Symptom nasolabialFoldAbsent = new Symptom(
    LR.nasolabialFoldAbsent,
    L.nasolabialFoldAbsentDescription,
    LR.faceSt
);
nasolabialFoldAbsent.setPrintName(L.nasolabialFoldAbsentPrintName);

// ------------- nausea  -------------
Symptom nausea = new Symptom(
    LR.nausea,
    L.nauseaDescription,
    LR.stomachSt
);
nausea.setPrintName(L.nauseaPrintName);

// ------------- navelPapule  -------------
Symptom navelPapule = new Symptom(
    LR.navelPapule,
    L.navelPapuleDescription,
    LR.navelSt
);
navelPapule.setPrintName(L.navelPapulePrintName);

// -------------- neckEdema --------------
// (C) OntoOO Inc Mon May 10 17:02:25 PDT 2004
Symptom neckEdema = new Symptom(
    LR.neckEdema,
    L.neckEdemaDescription,
    LR.neckSt
);
neckEdema.setPrintName(L.neckEdemaPrintName);

// ------------- neckLymphNodeEnlarged  -------------
Symptom neckLymphNodeEnlarged = new Symptom(
    LR.neckLymphNodeEnlarged,
    L.neckLymphNodeEnlargedDescription,
    LR.neckLymphNodeSt
);
neckLymphNodeEnlarged.setPrintName(L.neckLymphNodeEnlargedPrintName);

// ------------- neckPain  -------------
Symptom neckPain = new Symptom(
    LR.neckPain,
    L.neckPainDescription,
    LR.neckSt
);
neckPain.setPrintName(L.neckPainPrintName);

// -------------- neckSpasm --------------
// (C) OntoOO Inc Wed Oct 13 11:35:46 GMT-08:00 2004
Symptom neckSpasm = new Symptom(
    LR.neckSpasm,
    L.neckSpasmDescription,
    LR.neckSt
);
neckSpasm.setPrintName(L.neckSpasmPrintName);

// ------------- neckStiff  -------------
Symptom neckStiff = new Symptom(
    LR.neckStiff,
    L.neckStiffDescription,
    LR.neckSt
);
neckStiff.setPrintName(L.neckStiffPrintName);

// ------------- neckVeinsElevated  -------------
Symptom neckVeinsElevated = new Symptom(
    LR.neckVeinsElevated,
    L.neckVeinsElevatedDescription,
    LR.neckVeinsSt
);
neckVeinsElevated.setPrintName(L.neckVeinsElevatedPrintName);

// ------------- necrosis  -------------
Symptom necrosis = new Symptom(
    LR.necrosis,
    L.necrosisDescription,
    LR.bodySt
);
necrosis.setPrintName(L.necrosisPrintName);

// -------------- nervePain --------------
// (C) OntoOO Inc Mon May 10 17:18:26 PDT 2004
Symptom nervePain = new Symptom(
    LR.nervePain,
    L.nervePainDescription,
    LR.nervesSt
);
nervePain.setPrintName(L.nervePainPrintName);

// ------------- nervousness  -------------
Symptom nervousness = new Symptom(
    LR.nervousness,
    L.nervousnessDescription,
    LR.mindSt
);
nervousness.setPrintName(L.nervousnessPrintName);

// ------------- nightSweating  -------------
Symptom nightSweating = new Symptom(
    LR.nightSweating,
    L.nightSweatingDescription,
    LR.skinSt
);
nightSweating.setPrintName(L.nightSweatingPrintName);

// ------------- nightmares  -------------
Symptom nightmares = new Symptom(
    LR.nightmares,
    L.nightmaresDescription,
    LR.mindSt
);
nightmares.setPrintName(L.nightmaresPrintName);

// ------------- nippleAreaSkinScaly  -------------
Symptom nippleAreaSkinScaly = new Symptom(
    LR.nippleAreaSkinScaly,
    L.nippleAreaSkinScalyDescription,
    LR.nipplesFemaleSt
);
nippleAreaSkinScaly.setPrintName(L.nippleAreaSkinScalyPrintName);

// ------------- nippleBurning  -------------
Symptom nippleBurning = new Symptom(
    LR.nippleBurning,
    L.nippleBurningDescription,
    LR.nipplesFemaleSt
);
nippleBurning.setPrintName(L.nippleBurningPrintName);

// ------------- nippleChancre  -------------
Symptom nippleChancre = new Symptom(
    LR.nippleChancre,
    L.nippleChancreDescription,
    LR.nipplesSt
);
nippleChancre.setPrintName(L.nippleChancrePrintName);

// ------------- nippleErosion  -------------
Symptom nippleErosion = new Symptom(
    LR.nippleErosion,
    L.nippleErosionDescription,
    LR.nipplesFemaleSt
);
nippleErosion.setPrintName(L.nippleErosionPrintName);

// ------------- nippleItching  -------------
Symptom nippleItching = new Symptom(
    LR.nippleItching,
    L.nippleItchingDescription,
    LR.nipplesFemaleSt
);
nippleItching.setPrintName(L.nippleItchingPrintName);

// ------------- nippleRetraction  -------------
Symptom nippleRetraction = new Symptom(
    LR.nippleRetraction,
    L.nippleRetractionDescription,
    LR.nipplesFemaleSt
);
nippleRetraction.setPrintName(L.nippleRetractionPrintName);

// ------------- nocturia  -------------
Symptom nocturia = new Symptom(
    LR.nocturia,
    L.nocturiaDescription,
    LR.bladderSt
);
nocturia.setPrintName(L.nocturiaPrintName);

// ------------- noiseSensitivity  -------------
Symptom noiseSensitivity = new Symptom(
    LR.noiseSensitivity,
    L.noiseSensitivityDescription,
    LR.mindSt
);
noiseSensitivity.setPrintName(L.noiseSensitivityPrintName);

// -------------- noseCyanosis --------------
// (C) OntoOO Inc Tue Aug 24 10:59:00 GMT-08:00 2004
Symptom noseCyanosis = new Symptom(
    LR.noseCyanosis,
    L.noseCyanosisDescription,
    LR.noseSt
);
noseCyanosis.setPrintName(L.noseCyanosisPrintName);

// ------------- noseDischarge  -------------
Symptom noseDischarge = new Symptom(
    LR.noseDischarge,
    L.noseDischargeDescription,
    LR.noseSt
);
noseDischarge.setPrintName(L.noseDischargePrintName);

// ------------- noseItches  -------------
Symptom noseItches = new Symptom(
    LR.noseItches,
    L.noseItchesDescription,
    LR.noseSt
);
noseItches.setPrintName(L.noseItchesPrintName);

// ------------- noseMucosaSwelling  -------------
Symptom noseMucosaSwelling = new Symptom(
    LR.noseMucosaSwelling,
    L.noseMucosaSwellingDescription,
    LR.noseSt
);
noseMucosaSwelling.setPrintName(L.noseMucosaSwellingPrintName);

// ------------- noseMucosaUlceration  -------------
Symptom noseMucosaUlceration = new Symptom(
    LR.noseMucosaUlceration,
    L.noseMucosaUlcerationDescription,
    LR.noseSt
);
noseMucosaUlceration.setPrintName(L.noseMucosaUlcerationPrintName);

// ------------- noseMucosalLesion  -------------
Symptom noseMucosalLesion = new Symptom(
    LR.noseMucosalLesion,
    L.noseMucosalLesionDescription,
    LR.noseSt
);
noseMucosalLesion.setPrintName(L.noseMucosalLesionPrintName);

// ------------- noseSeptumPerforation  -------------
Symptom noseSeptumPerforation = new Symptom(
    LR.noseSeptumPerforation,
    L.noseSeptumPerforationDescription,
    LR.noseSeptumSt
);
noseSeptumPerforation.setPrintName(L.noseSeptumPerforationPrintName);

// ------------- noseWhitePatches  -------------
Symptom noseWhitePatches = new Symptom(
    LR.noseWhitePatches,
    L.noseWhitePatchesDescription,
    LR.noseSt
);
noseWhitePatches.setPrintName(L.noseWhitePatchesPrintName);

// ------------- nuchalRigidity  -------------
Symptom nuchalRigidity = new Symptom(
    LR.nuchalRigidity,
    L.nuchalRigidityDescription,
    LR.napeSt
);
nuchalRigidity.setPrintName(L.nuchalRigidityPrintName);

// ------------- numbness  -------------
Symptom numbness = new Symptom(
    LR.numbness,
    L.numbnessDescription,
    LR.bodySt
);
numbness.setPrintName(L.numbnessPrintName);

// ------------- nystagmus  -------------
Symptom nystagmus = new Symptom(
    LR.nystagmus,
    L.nystagmusDescription,
    LR.eyesSt
);
nystagmus.setPrintName(L.nystagmusPrintName);

// ------------- obsessiveThoughts  -------------
Symptom obsessiveThoughts = new Symptom(
    LR.obsessiveThoughts,
    L.obsessiveThoughtsDescription,
    LR.mindSt
);
obsessiveThoughts.setPrintName(L.obsessiveThoughtsPrintName);

// ------------- obstipation  -------------
Symptom obstipation = new Symptom(
    LR.obstipation,
    L.obstipationDescription,
    LR.colonSt
);
obstipation.setPrintName(L.obstipationPrintName);

// ------------- obtundation  -------------
Symptom obtundation = new Symptom(
    LR.obtundation,
    L.obtundationDescription,
    LR.mindSt
);
obtundation.setPrintName(L.obtundationPrintName);

// ------------- ocularDisturbance  -------------
Symptom ocularDisturbance = new Symptom(
    LR.ocularDisturbance,
    L.ocularDisturbanceDescription,
    LR.eyesSt
);
ocularDisturbance.setPrintName(L.ocularDisturbancePrintName);

// ------------- oliguria  -------------
Symptom oliguria = new Symptom(
    LR.oliguria,
    L.oliguriaDescription,
    LR.kidneysSt
);
oliguria.setPrintName(L.oliguriaPrintName);

// ------------- opisthotonos  -------------
Symptom opisthotonos = new Symptom(
    LR.opisthotonos,
    L.opisthotonosDescription,
    LR.backSt
);
opisthotonos.setPrintName(L.opisthotonosPrintName);

// -------------- orbitPain --------------
// (C) OntoOO Inc Tue Feb 17 17:55:13 PST 2004
Symptom orbitPain = new Symptom(
    LR.orbitPain,
    L.orbitPainDescription,
    LR.eyesSt
);
orbitPain.setPrintName(L.orbitPainPrintName);

// ------------- organGumma  -------------
Symptom organGumma = new Symptom(
    LR.organGumma,
    L.organGummaDescription,
    LR.anOrganSt
);
organGumma.setPrintName(L.organGummaPrintName);

// ------------- orgasmUnachievable  -------------
Symptom orgasmUnachievable = new Symptom(
    LR.orgasmUnachievable,
    L.orgasmUnachievableDescription,
    LR.mindSt
);
orgasmUnachievable.setPrintName(L.orgasmUnachievablePrintName);

// ------------- orthopnea  -------------
Symptom orthopnea = new Symptom(
    LR.orthopnea,
    L.orthopneaDescription,
    LR.lungsSt
);
orthopnea.setPrintName(L.orthopneaPrintName);

// -------------- overweight --------------
// (C) OntoOO Inc Wed Mar 21 12:26:44 PST 2007
Symptom overweight = new Symptom(
    LR.overweight,
    L.overweightDescription,
    LR.bodySt
);
overweight.setPrintName(L.overweightPrintName);

// ------------- pain  -------------
Symptom pain = new Symptom(
    LR.pain,
    L.painDescription,
    LR.bodySt
);
pain.setPrintName(L.painPrintName);

// ------------- painBurning  -------------
Symptom painBurning = new Symptom(
    LR.painBurning,
    L.painBurningDescription,
    LR.bodySt
);
painBurning.setPrintName(L.painBurningPrintName);

// ------------- painDeep  -------------
Symptom painDeep = new Symptom(
    LR.painDeep,
    L.painDeepDescription,
    LR.bodySt
);
painDeep.setPrintName(L.painDeepPrintName);

// ------------- painGnawing  -------------
Symptom painGnawing = new Symptom(
    LR.painGnawing,
    L.painGnawingDescription,
    LR.bodySt
);
painGnawing.setPrintName(L.painGnawingPrintName);

// ------------- painSevere  -------------
Symptom painSevere = new Symptom(
    LR.painSevere,
    L.painSevereDescription,
    LR.bodySt
);
painSevere.setPrintName(L.painSeverePrintName);

// ------------- painSharp  -------------
Symptom painSharp = new Symptom(
    LR.painSharp,
    L.painSharpDescription,
    LR.bodySt
);
painSharp.setPrintName(L.painSharpPrintName);

// ------------- painStabbing  -------------
Symptom painStabbing = new Symptom(
    LR.painStabbing,
    L.painStabbingDescription,
    LR.bodySt
);
painStabbing.setPrintName(L.painStabbingPrintName);

// ------------- palatePerforation  -------------
Symptom palatePerforation = new Symptom(
    LR.palatePerforation,
    L.palatePerforationDescription,
    LR.palateSt
);
palatePerforation.setPrintName(L.palatePerforationPrintName);

// ------------- pallor  -------------
Symptom pallor = new Symptom(
    LR.pallor,
    L.pallorDescription,
    LR.faceSt
);
pallor.setPrintName(L.pallorPrintName);

// ------------- palmsPale  -------------
Symptom palmsPale = new Symptom(
    LR.palmsPale,
    L.palmsPaleDescription,
    LR.palmsSt
);
palmsPale.setPrintName(L.palmsPalePrintName);

// ------------- palpitations  -------------
Symptom palpitations = new Symptom(
    LR.palpitations,
    L.palpitationsDescription,
    LR.heartSt
);
palpitations.setPrintName(L.palpitationsPrintName);

// ------------- palsy  -------------
Symptom palsy = new Symptom(
    LR.palsy,
    L.palsyDescription,
    LR.bodySt
);
palsy.setPrintName(L.palsyPrintName);

// ------------- palsyFace  -------------
Symptom palsyFace = new Symptom(
    LR.palsyFace,
    L.palsyFaceDescription,
    LR.faceSt
);
palsyFace.setPrintName(L.palsyFacePrintName);

// ------------- panicAttacks  -------------
Symptom panicAttacks = new Symptom(
    LR.panicAttacks,
    L.panicAttacksDescription,
    LR.mindSt
);
panicAttacks.setPrintName(L.panicAttacksPrintName);

// ------------- papilledema  -------------
Symptom papilledema = new Symptom(
    LR.papilledema,
    L.papilledemaDescription,
    LR.eyesSt
);
papilledema.setPrintName(L.papilledemaPrintName);

// ------------- papuleRedSmall  -------------
Symptom papuleRedSmall = new Symptom(
    LR.papuleRedSmall,
    L.papuleRedSmallDescription,
    LR.skinSt
);
papuleRedSmall.setPrintName(L.papuleRedSmallPrintName);

// ------------- papuleRedWarm  -------------
Symptom papuleRedWarm = new Symptom(
    LR.papuleRedWarm,
    L.papuleRedWarmDescription,
    LR.skinSt
);
papuleRedWarm.setPrintName(L.papuleRedWarmPrintName);

// ------------- papuleUlcerated  -------------
Symptom papuleUlcerated = new Symptom(
    LR.papuleUlcerated,
    L.papuleUlceratedDescription,
    LR.skinSt
);
papuleUlcerated.setPrintName(L.papuleUlceratedPrintName);

// ------------- paranoia  -------------
Symptom paranoia = new Symptom(
    LR.paranoia,
    L.paranoiaDescription,
    LR.mindSt
);
paranoia.setPrintName(L.paranoiaPrintName);

// ------------- paralysis  -------------
Symptom paralysis = new Symptom(
    LR.paralysis,
    L.paralysisDescription,
    LR.bodySt
);
paralysis.setPrintName(L.paralysisPrintName);

// ------------- paralysisTransient  -------------
Symptom paralysisTransient = new Symptom(
    LR.paralysisTransient,
    L.paralysisTransientDescription,
    LR.bodySt
);
paralysisTransient.setPrintName(L.paralysisTransientPrintName);

// ------------- paresthesia  -------------
Symptom paresthesia = new Symptom(
    LR.paresthesia,
    L.paresthesiaDescription,
    LR.skinSt
);
paresthesia.setPrintName(L.paresthesiaPrintName);

// ------------- parotidGlandsSwollen  -------------
Symptom parotidGlandsSwollen = new Symptom(
    LR.parotidGlandsSwollen,
    L.parotidGlandsSwollenDescription,
    LR.parotidGlandsSt
);
parotidGlandsSwollen.setPrintName(L.parotidGlandsSwollenPrintName);

// ------------- pelvisDiscomfort  -------------
Symptom pelvisDiscomfort = new Symptom(
    LR.pelvisDiscomfort,
    L.pelvisDiscomfortDescription,
    LR.pelvisSt
);
pelvisDiscomfort.setPrintName(L.pelvisDiscomfortPrintName);

// ------------- pelvisPain  -------------
Symptom pelvisPain = new Symptom(
    LR.pelvisPain,
    L.pelvisPainDescription,
    LR.pelvisSt
);
pelvisPain.setPrintName(L.pelvisPainPrintName);

// ------------- pelvisRelaxation  -------------
Symptom pelvisRelaxation = new Symptom(
    LR.pelvisRelaxation,
    L.pelvisRelaxationDescription,
    LR.pelvisSt
);
pelvisRelaxation.setPrintName(L.pelvisRelaxationPrintName);

// ------------- penisEnlarged  -------------
Symptom penisEnlarged = new Symptom(
    LR.penisEnlarged,
    L.penisEnlargedDescription,
    LR.penisSt
);
penisEnlarged.setPrintName(L.penisEnlargedPrintName);

// ------------- penisGlansVesicle  -------------
Symptom penisGlansVesicle = new Symptom(
    LR.penisGlansVesicle,
    L.penisGlansVesicleDescription,
    LR.glansPenisSt
);
penisGlansVesicle.setPrintName(L.penisGlansVesiclePrintName);

// ------------- penisGrowth  -------------
Symptom penisGrowth = new Symptom(
    LR.penisGrowth,
    L.penisGrowthDescription,
    LR.penisSt
);
penisGrowth.setPrintName(L.penisGrowthPrintName);

// ------------- penisInfantile  -------------
Symptom penisInfantile = new Symptom(
    LR.penisInfantile,
    L.penisInfantileDescription,
    LR.penisSt
);
penisInfantile.setPrintName(L.penisInfantilePrintName);

// ------------- penisPapule  -------------
Symptom penisPapule = new Symptom(
    LR.penisPapule,
    L.penisPapuleDescription,
    LR.penisSt
);
penisPapule.setPrintName(L.penisPapulePrintName);

// ------------- penisVesicle  -------------
Symptom penisVesicle = new Symptom(
    LR.penisVesicle,
    L.penisVesicleDescription,
    LR.penisSt
);
penisVesicle.setPrintName(L.penisVesiclePrintName);

// ------------- penisWarts  -------------
Symptom penisWarts = new Symptom(
    LR.penisWarts,
    L.penisWartsDescription,
    LR.penisSt
);
penisWarts.setPrintName(L.penisWartsPrintName);

// ------------- perineumWarts  -------------
Symptom perineumWarts = new Symptom(
    LR.perineumWarts,
    L.perineumWartsDescription,
    LR.perineumSt
);
perineumWarts.setPrintName(L.perineumWartsPrintName);

// ------------- personalityChange  -------------
Symptom personalityChange = new Symptom(
    LR.personalityChange,
    L.personalityChangeDescription,
    LR.mindSt
);
personalityChange.setPrintName(L.personalityChangePrintName);

// ------------- perspiration  -------------
Symptom perspiration = new Symptom(
    LR.perspiration,
    L.perspirationDescription,
    LR.skinSt
);
perspiration.setPrintName(L.perspirationPrintName);

// ------------- petechiae  -------------
Symptom petechiae = new Symptom(
    LR.petechiae,
    L.petechiaeDescription,
    LR.skinSt
);
petechiae.setPrintName(L.petechiaePrintName);

// ------------- phlebitis  -------------
Symptom phlebitis = new Symptom(
    LR.phlebitis,
    L.phlebitisDescription,
    LR.aVeinSt
);
phlebitis.setPrintName(L.phlebitisPrintName);

// ------------- photophobia  -------------
Symptom photophobia = new Symptom(
    LR.photophobia,
    L.photophobiaDescription,
    LR.eyesSt
);
photophobia.setPrintName(L.photophobiaPrintName);

// ------------- pleuriticChestPain  -------------
Symptom pleuriticChestPain = new Symptom(
    LR.pleuriticChestPain,
    L.pleuriticChestPainDescription,
    LR.pleuraSt
);
pleuriticChestPain.setPrintName(L.pleuriticChestPainPrintName);

// ------------- polyarthritis  -------------
Symptom polyarthritis = new Symptom(
    LR.polyarthritis,
    L.polyarthritisDescription,
    LR.jointsSt
);
polyarthritis.setPrintName(L.polyarthritisPrintName);

// ------------- polydipsia  -------------
Symptom polydipsia = new Symptom(
    LR.polydipsia,
    L.polydipsiaDescription,
    LR.bodySt
);
polydipsia.setPrintName(L.polydipsiaPrintName);

// ------------- polyuria  -------------
Symptom polyuria = new Symptom(
    LR.polyuria,
    L.polyuriaDescription,
    LR.bladderSt
);
polyuria.setPrintName(L.polyuriaPrintName);

// ------------- postcoitalBleeding  -------------
Symptom postcoitalBleeding = new Symptom(
    LR.postcoitalBleeding,
    L.postcoitalBleedingDescription,
    LR.vaginaSt
);
postcoitalBleeding.setPrintName(L.postcoitalBleedingPrintName);

// ------------- postcoitalPain  -------------
Symptom postcoitalPain = new Symptom(
    LR.postcoitalPain,
    L.postcoitalPainDescription,
    LR.cervixSt
);
postcoitalPain.setPrintName(L.postcoitalPainPrintName);

// ------------- postVoidingPain  -------------
Symptom postVoidingPain = new Symptom(
    LR.postVoidingPain,
    L.postVoidingPainDescription,
    LR.bodySt
);
postVoidingPain.setPrintName(L.postVoidingPainPrintName);

// ------------- prematureEjaculationSymptom  -------------
Symptom prematureEjaculationSymptom = new Symptom(
    LR.prematureEjaculationSymptom,
    L.prematureEjaculationSymptomDescription,
    LR.testiclesSt
);
prematureEjaculationSymptom.setPrintName(L.prematureEjaculationSymptomPrintName);

// ------------- prolongedExpiration  -------------
Symptom prolongedExpiration = new Symptom(
    LR.prolongedExpiration,
    L.prolongedExpirationDescription,
    LR.lungsSt
);
prolongedExpiration.setPrintName(L.prolongedExpirationPrintName);

// ------------- prostration  -------------
Symptom prostration = new Symptom(
    LR.prostration,
    L.prostrationDescription,
    LR.bodySt
);
prostration.setPrintName(L.prostrationPrintName);

// ------------- pruritus  -------------
Symptom pruritus = new Symptom(
    LR.pruritus,
    L.pruritusDescription,
    LR.skinSt
);
pruritus.setPrintName(L.pruritusPrintName);

// ------------- psychosis  -------------
Symptom psychosis = new Symptom(
    LR.psychosis,
    L.psychosisDescription,
    LR.mindSt
);
psychosis.setPrintName(L.psychosisPrintName);

// ------------- ptosis  -------------
Symptom ptosis = new Symptom(
    LR.ptosis,
    L.ptosisDescription,
    LR.eyesSt
);
ptosis.setPrintName(L.ptosisPrintName);

// ------------- pubertyDelayed  -------------
Symptom pubertyDelayed = new Symptom(
    LR.pubertyDelayed,
    L.pubertyDelayedDescription,
    LR.bodySt
);
pubertyDelayed.setPrintName(L.pubertyDelayedPrintName);

// ------------- pubisHairDevelopment  -------------
Symptom pubisHairDevelopment = new Symptom(
    LR.pubisHairDevelopment,
    L.pubisHairDevelopmentDescription,
    LR.pubisSt
);
pubisHairDevelopment.setPrintName(L.pubisHairDevelopmentPrintName);

// ------------- pubisHairEarly  -------------
Symptom pubisHairEarly = new Symptom(
    LR.pubisHairEarly,
    L.pubisHairEarlyDescription,
    LR.pubisSt
);
pubisHairEarly.setPrintName(L.pubisHairEarlyPrintName);

// ------------- pubisHairLoss  -------------
Symptom pubisHairLoss = new Symptom(
    LR.pubisHairLoss,
    L.pubisHairLossDescription,
    LR.pubisSt
);
pubisHairLoss.setPrintName(L.pubisHairLossPrintName);

// ------------- pubisPain  -------------
Symptom pubisPain = new Symptom(
    LR.pubisPain,
    L.pubisPainDescription,
    LR.pubisSt
);
pubisPain.setPrintName(L.pubisPainPrintName);

// ------------- pubisSkinIrritation  -------------
Symptom pubisSkinIrritation = new Symptom(
    LR.pubisSkinIrritation,
    L.pubisSkinIrritationDescription,
    LR.pubisSt
);
pubisSkinIrritation.setPrintName(L.pubisSkinIrritationPrintName);

// -------------- pulmonaryCongestion --------------
// (C) OntoOO Inc Fri Oct 08 12:53:40 GMT-08:00 2004
Symptom pulmonaryCongestion = new Symptom(
    LR.pulmonaryCongestion,
    L.pulmonaryCongestionDescription,
    LR.lungsSt
);
pulmonaryCongestion.setPrintName(L.pulmonaryCongestionPrintName);

// ------------- pulseAbsent  -------------
Symptom pulseAbsent = new Symptom(
    LR.pulseAbsent,
    L.pulseAbsentDescription,
    LR.heartSt
);
pulseAbsent.setPrintName(L.pulseAbsentPrintName);

// ------------- pulseDelay  -------------
Symptom pulseDelay = new Symptom(
    LR.pulseDelay,
    L.pulseDelayDescription,
    LR.heartSt
);
pulseDelay.setPrintName(L.pulseDelayPrintName);

// ------------- pulseFullBounding  -------------
Symptom pulseFullBounding = new Symptom(
    LR.pulseFullBounding,
    L.pulseFullBoundingDescription,
    LR.heartSt
);
pulseFullBounding.setPrintName(L.pulseFullBoundingPrintName);

// ------------- pulsePressureNarrows  -------------
Symptom pulsePressureNarrows = new Symptom(
    LR.pulsePressureNarrows,
    L.pulsePressureNarrowsDescription,
    LR.heartSt
);
pulsePressureNarrows.setPrintName(L.pulsePressureNarrowsPrintName);

// ------------- pulseRapid  -------------
Symptom pulseRapid = new Symptom(
    LR.pulseRapid,
    L.pulseRapidDescription,
    LR.heartSt
);
pulseRapid.setPrintName(L.pulseRapidPrintName);

// ------------- pulseThready  -------------
Symptom pulseThready = new Symptom(
    LR.pulseThready,
    L.pulseThreadyDescription,
    LR.heartSt
);
pulseThready.setPrintName(L.pulseThreadyPrintName);

// ------------- pulseWeak  -------------
Symptom pulseWeak = new Symptom(
    LR.pulseWeak,
    L.pulseWeakDescription,
    LR.heartSt
);
pulseWeak.setPrintName(L.pulseWeakPrintName);

// ------------- pulsusAlternans  -------------
Symptom pulsusAlternans = new Symptom(
    LR.pulsusAlternans,
    L.pulsusAlternansDescription,
    LR.heartSt
);
pulsusAlternans.setPrintName(L.pulsusAlternansPrintName);

// ------------- pupilChanges  -------------
Symptom pupilChanges = new Symptom(
    LR.pupilChanges,
    L.pupilChangesDescription,
    LR.pupilsSt
);
pupilChanges.setPrintName(L.pupilChangesPrintName);

// ------------- pupilDilation  -------------
Symptom pupilDilation = new Symptom(
    LR.pupilDilation,
    L.pupilDilationDescription,
    LR.pupilsSt
);
pupilDilation.setPrintName(L.pupilDilationPrintName);

// ------------- pupilNarrowing  -------------
Symptom pupilNarrowing = new Symptom(
    LR.pupilNarrowing,
    L.pupilNarrowingDescription,
    LR.pupilsSt
);
pupilNarrowing.setPrintName(L.pupilNarrowingPrintName);

// ------------- pupilNonReactive  -------------
Symptom pupilNonReactive = new Symptom(
    LR.pupilNonReactive,
    L.pupilNonReactiveDescription,
    LR.pupilsSt
);
pupilNonReactive.setPrintName(L.pupilNonReactivePrintName);

// ------------- pupilResponseUnequal  -------------
Symptom pupilResponseUnequal = new Symptom(
    LR.pupilResponseUnequal,
    L.pupilResponseUnequalDescription,
    LR.pupilsSt
);
pupilResponseUnequal.setPrintName(L.pupilResponseUnequalPrintName);

// -------------- purpura --------------
// (C) OntoOO Inc Thu Jul 08 16:28:39 PDT 2004
Symptom purpura = new Symptom(
    LR.purpura,
    L.purpuraDescription,
    LR.skinSt
);
purpura.setPrintName(L.purpuraPrintName);

// ------------- pursedLipBreathing  -------------
Symptom pursedLipBreathing = new Symptom(
    LR.pursedLipBreathing,
    L.pursedLipBreathingDescription,
    LR.mouthSt
);
pursedLipBreathing.setPrintName(L.pursedLipBreathingPrintName);

// ------------- pyuria  -------------
Symptom pyuria = new Symptom(
    LR.pyuria,
    L.pyuriaDescription,
    LR.bladderSt
);
pyuria.setPrintName(L.pyuriaPrintName);

// ------------- rash  -------------
Symptom rash = new Symptom(
    LR.rash,
    L.rashDescription,
    LR.skinSt
);
rash.setPrintName(L.rashPrintName);

// ------------- rashCreeping  -------------
Symptom rashCreeping = new Symptom(
    LR.rashCreeping,
    L.rashCreepingDescription,
    LR.skinSt
);
rashCreeping.setPrintName(L.rashCreepingPrintName);

// ------------- rashErupting  -------------
Symptom rashErupting = new Symptom(
    LR.rashErupting,
    L.rashEruptingDescription,
    LR.skinSt
);
rashErupting.setPrintName(L.rashEruptingPrintName);

// ------------- rashItchy  -------------
Symptom rashItchy = new Symptom(
    LR.rashItchy,
    L.rashItchyDescription,
    LR.skinSt
);
rashItchy.setPrintName(L.rashItchyPrintName);

// -------------- rashPapular --------------
// (C) OntoOO Inc Mon Jan 26 17:49:43 PST 2004
Symptom rashPapular = new Symptom(
    LR.rashPapular,
    L.rashPapularDescription,
    LR.skinSt
);
rashPapular.setPrintName(L.rashPapularPrintName);

// -------------- rashRed --------------
// (C) OntoOO Inc Mon Jan 26 17:49:43 PST 2004
Symptom rashRed = new Symptom(
    LR.rashRed,
    L.rashRedDescription,
    LR.skinSt
);
rashRed.setPrintName(L.rashRedPrintName);

// ------------- rashSandpapery  -------------
Symptom rashSandpapery = new Symptom(
    LR.rashSandpapery,
    L.rashSandpaperyDescription,
    LR.skinSt
);
rashSandpapery.setPrintName(L.rashSandpaperyPrintName);

// -------------- rashScaly --------------
// (C) OntoOO Inc Mon Jan 26 17:31:48 PST 2004
Symptom rashScaly = new Symptom(
    LR.rashScaly,
    L.rashScalyDescription,
    LR.skinSt
);
rashScaly.setPrintName(L.rashScalyPrintName);

// -------------- reboundTenderness --------------
// (C) OntoOO Inc Thu Oct 02 21:56:54 PDT 2008
Symptom reboundTenderness = new Symptom(
    LR.reboundTenderness,
    // "pain caused by releasing pressure on a location",
    L.reboundTendernessDescription,
    LR.bodySt
);
// reboundTenderness.setPrintName("rebound tenderness");
reboundTenderness.setPrintName(L.reboundTendernessPrintName);

// ------------- rectumBloodyDischarge  -------------
Symptom rectumBloodyDischarge = new Symptom(
    LR.rectumBloodyDischarge,
    L.rectumBloodyDischargeDescription,
    LR.rectumSt
);
rectumBloodyDischarge.setPrintName(L.rectumBloodyDischargePrintName);

// ------------- rectumBurning  -------------
Symptom rectumBurning = new Symptom(
    LR.rectumBurning,
    L.rectumBurningDescription,
    LR.rectumSt
);
rectumBurning.setPrintName(L.rectumBurningPrintName);

// ------------- rectumItching  -------------
Symptom rectumItching = new Symptom(
    LR.rectumItching,
    L.rectumItchingDescription,
    LR.rectumSt
);
rectumItching.setPrintName(L.rectumItchingPrintName);

/* replaced by vulvaRedSwollen
// ------------- redEdematousMembranes  -------------
Symptom redEdematousMembranes = new Symptom(
    LR.redEdematousMembranes,
    L.redEdematousMembranesDescription,
    LR.vulvaSt
);
redEdematousMembranes.setPrintName(L.redEdematousMembranesPrintName);
*/

// ------------- reflexControlLoss  -------------
Symptom reflexControlLoss = new Symptom(
    LR.reflexControlLoss,
    L.reflexControlLossDescription,
    LR.nervesSt
);
reflexControlLoss.setPrintName(L.reflexControlLossPrintName);

// ------------- reflexesDecreased  -------------
Symptom reflexesDecreased = new Symptom(
    LR.reflexesDecreased,
    L.reflexesDecreasedDescription,
    LR.nervesSt
);
reflexesDecreased.setPrintName(L.reflexesDecreasedPrintName);

// ------------- reflexesHyperactive  -------------
Symptom reflexesHyperactive = new Symptom(
    LR.reflexesHyperactive,
    L.reflexesHyperactiveDescription,
    LR.nervesSt
);
reflexesHyperactive.setPrintName(L.reflexesHyperactivePrintName);

// ------------- respirationDeep  -------------
Symptom respirationDeep = new Symptom(
    LR.respirationDeep,
    L.respirationDeepDescription,
    LR.lungsSt
);
respirationDeep.setPrintName(L.respirationDeepPrintName);

// ------------- respirationDistress  -------------
Symptom respirationDistress = new Symptom(
    LR.respirationDistress,
    L.respirationDistressDescription,
    LR.lungsSt
);
respirationDistress.setPrintName(L.respirationDistressPrintName);

// ------------- respirationKussmaul  -------------
Symptom respirationKussmaul = new Symptom(
    LR.respirationKussmaul,
    L.respirationKussmaulDescription,
    LR.lungsSt
);
respirationKussmaul.setPrintName(L.respirationKussmaulPrintName);

// ------------- respirationLabored  -------------
Symptom respirationLabored = new Symptom(
    LR.respirationLabored,
    L.respirationLaboredDescription,
    LR.lungsSt
);
respirationLabored.setPrintName(L.respirationLaboredPrintName);

// ------------- respirationParalysis  -------------
Symptom respirationParalysis = new Symptom(
    LR.respirationParalysis,
    L.respirationParalysisDescription,
    LR.lungsSt
);
respirationParalysis.setPrintName(L.respirationParalysisPrintName);

// ------------- respirationRapid  -------------
/*
Symptom respirationRapid = new Symptom(
    LR.respirationRapid,
    L.respirationRapidDescription,
    LR.lungsSt
);
respirationRapid.setPrintName(L.respirationRapidPrintName);
*/

// -------------- respirationRetractive --------------
// (C) OntoOO Inc Fri Oct 03 10:43:13 PDT 2008
Symptom respirationRetractive = new Symptom(
    LR.respirationRetractive,
    // "inward movement of the chest on inspiration",
    L.respirationRetractiveDescription,
    LR.lungsSt
);
// respirationRetractive.setPrintName("respiration retractive");
respirationRetractive.setPrintName(L.respirationRetractivePrintName);

// ------------- respirationShallow  -------------
Symptom respirationShallow = new Symptom(
    LR.respirationShallow,
    L.respirationShallowDescription,
    LR.mouthSt
);
respirationShallow.setPrintName(L.respirationShallowPrintName);

// ------------- respirationSporadic  -------------
Symptom respirationSporadic = new Symptom(
    LR.respirationSporadic,
    L.respirationSporadicDescription,
    LR.lungsSt
);
respirationSporadic.setPrintName(L.respirationSporadicPrintName);

// ------------- restlessness  -------------
Symptom restlessness = new Symptom(
    LR.restlessness,
    L.restlessnessDescription,
    LR.bodySt
);
restlessness.setPrintName(L.restlessnessPrintName);

// ------------- retinaHemorrhage  -------------
Symptom retinaHemorrhage = new Symptom(
    LR.retinaHemorrhage,
    L.retinaHemorrhageDescription,
    LR.retinasSt
);
retinaHemorrhage.setPrintName(L.retinaHemorrhagePrintName);

// ------------- retinaInflammation  -------------
Symptom retinaInflammation = new Symptom(
    LR.retinaInflammation,
    L.retinaInflammationDescription,
    LR.retinasSt
);
retinaInflammation.setPrintName(L.retinaInflammationPrintName);

// ------------- retrosternalChestPain  -------------
Symptom retrosternalChestPain = new Symptom(
    LR.retrosternalChestPain,
    L.retrosternalChestPainDescription,
    LR.ribCageSt
);
retrosternalChestPain.setPrintName(L.retrosternalChestPainPrintName);

// ------------- rhinitis  -------------
Symptom rhinitis = new Symptom(
    LR.rhinitis,
    L.rhinitisDescription,
    LR.noseSt
);
rhinitis.setPrintName(L.rhinitisPrintName);

// ------------- rhonchus  -------------
Symptom rhonchus = new Symptom(
    LR.rhonchus,
    L.rhonchusDescription,
    LR.tracheaSt
);
rhonchus.setPrintName(L.rhonchusPrintName);

// ------------- rigidity  -------------
Symptom rigidity = new Symptom(
    LR.rigidity,
    L.rigidityDescription,
    LR.bodySt
);
rigidity.setPrintName(L.rigidityPrintName);

// ------------- ritualistic  -------------
Symptom ritualistic = new Symptom(
    LR.ritualistic,
    L.ritualisticDescription,
    LR.mindSt
);
ritualistic.setPrintName(L.ritualisticPrintName);

// ------------- roleFunctioningDetoriation  -------------
Symptom roleFunctioningDetoriation = new Symptom(
    LR.roleFunctioningDetoriation,
    L.roleFunctioningDetoriationDescription,
    LR.mindSt
);
roleFunctioningDetoriation.setPrintName(L.roleFunctioningDetoriationPrintName);

// -------------- roundback --------------
// (C) OntoOO Inc Tue Jul 06 13:27:31 PDT 2004
Symptom roundback = new Symptom(
    LR.roundback,
    L.roundbackDescription,
    LR.backSt
);
roundback.setPrintName(L.roundbackPrintName);

// ------------- salivation  -------------
Symptom salivation = new Symptom(
    LR.salivation,
    L.salivationDescription,
    LR.mouthSt
);
salivation.setPrintName(L.salivationPrintName);

// ------------- scab  -------------
Symptom scab = new Symptom(
    LR.scab,
    L.scabDescription,
    LR.skinSt
);
scab.setPrintName(L.scabPrintName);

// ------------- scalpNodule  -------------
Symptom scalpNodule = new Symptom(
    LR.scalpNodule,
    L.scalpNoduleDescription,
    LR.scalpSt
);
scalpNodule.setPrintName(L.scalpNodulePrintName);

// ------------- scalpWound  -------------
Symptom scalpWound = new Symptom(
    LR.scalpWound,
    L.scalpWoundDescription,
    LR.scalpSt
);
scalpWound.setPrintName(L.scalpWoundPrintName);

// ------------- scrotumEnlarged  -------------
Symptom scrotumEnlarged = new Symptom(
    LR.scrotumEnlarged,
    L.scrotumEnlargedDescription,
    LR.scrotumSt
);
scrotumEnlarged.setPrintName(L.scrotumEnlargedPrintName);

// ------------- scrotumSwellingPainful  -------------
Symptom scrotumSwellingPainful = new Symptom(
    LR.scrotumSwellingPainful,
    L.scrotumSwellingPainfulDescription,
    LR.scrotumSt
);
scrotumSwellingPainful.setPrintName(L.scrotumSwellingPainfulPrintName);

// ------------- seeingHalosAroundLights  -------------
Symptom seeingHalosAroundLights = new Symptom(
    LR.seeingHalosAroundLights,
    L.seeingHalosAroundLightsDescription,
    LR.eyesSt
);
seeingHalosAroundLights.setPrintName(L.seeingHalosAroundLightsPrintName);

// ------------- seizure  -------------
Symptom seizure = new Symptom(
    LR.seizure,
    L.seizureDescription,
    LR.brainSt
);
seizure.setPrintName(L.seizurePrintName);

// ------------- selfAwarenessHigh  -------------
Symptom selfAwarenessHigh = new Symptom(
    LR.selfAwarenessHigh,
    L.selfAwarenessHighDescription,
    LR.mindSt
);
selfAwarenessHigh.setPrintName(L.selfAwarenessHighPrintName);

// ------------- selfDoubt  -------------
Symptom selfDoubt = new Symptom(
    LR.selfDoubt,
    L.selfDoubtDescription,
    LR.mindSt
);
selfDoubt.setPrintName(L.selfDoubtPrintName);

// ------------- sensoryChanges  -------------
Symptom sensoryChanges = new Symptom(
    LR.sensoryChanges,
    L.sensoryChangesDescription,
    LR.mindSt
);
sensoryChanges.setPrintName(L.sensoryChangesPrintName);

// ------------- severeMalaise  -------------
Symptom severeMalaise = new Symptom(
    LR.severeMalaise,
    L.severeMalaiseDescription,
    LR.bodySt
);
severeMalaise.setPrintName(L.severeMalaisePrintName);

// ------------- sexChangeDesire  -------------
Symptom sexChangeDesire = new Symptom(
    LR.sexChangeDesire,
    L.sexChangeDesireDescription,
    LR.bodySt
);
sexChangeDesire.setPrintName(L.sexChangeDesirePrintName);

// ------------- sexDriveLow  -------------
Symptom sexDriveLow = new Symptom(
    LR.sexDriveLow,
    L.sexDriveLowDescription,
    LR.bodySt
);
sexDriveLow.setPrintName(L.sexDriveLowPrintName);

// ------------- sexualArousalFromChildren  -------------
Symptom sexualArousalFromChildren = new Symptom(
    LR.sexualArousalFromChildren,
    L.sexualArousalFromChildrenDescription,
    LR.mindSt
);
sexualArousalFromChildren.setPrintName(L.sexualArousalFromChildrenPrintName);

// ------------- sexualArousalFromCrossDressing  -------------
Symptom sexualArousalFromCrossDressing = new Symptom(
    LR.sexualArousalFromCrossDressing,
    L.sexualArousalFromCrossDressingDescription,
    LR.mindSt
);
sexualArousalFromCrossDressing.setPrintName(L.sexualArousalFromCrossDressingPrintName);

// ------------- sexualArousalFromInanimateObjects  -------------
Symptom sexualArousalFromInanimateObjects = new Symptom(
    LR.sexualArousalFromInanimateObjects,
    L.sexualArousalFromInanimateObjectsDescription,
    LR.mindSt
);
sexualArousalFromInanimateObjects.setPrintName(L.sexualArousalFromInanimateObjectsPrintName);

// ------------- sexualArousalFromInflictingRealOrFantasizedPain  -------------
Symptom sexualArousalFromInflictingRealOrFantasizedPain = new Symptom(
    LR.sexualArousalFromInflictingRealOrFantasizedPain,
    L.sexualArousalFromInflictingRealOrFantasizedPainDescription,
    LR.mindSt
);
sexualArousalFromInflictingRealOrFantasizedPain.setPrintName(L.sexualArousalFromInflictingRealOrFantasizedPainPrintName);

// ------------- sexualArousalFromObtainingRealOrFantasizedPain  -------------
Symptom sexualArousalFromObtainingRealOrFantasizedPain = new Symptom(
    LR.sexualArousalFromObtainingRealOrFantasizedPain,
    L.sexualArousalFromObtainingRealOrFantasizedPainDescription,
    LR.mindSt
);
sexualArousalFromObtainingRealOrFantasizedPain.setPrintName(L.sexualArousalFromObtainingRealOrFantasizedPainPrintName);

// ------------- sexualArousalFromRubbingANonconsentingPerson  -------------
Symptom sexualArousalFromRubbingANonconsentingPerson = new Symptom(
    LR.sexualArousalFromRubbingANonconsentingPerson,
    L.sexualArousalFromRubbingANonconsentingPersonDescription,
    LR.mindSt
);
sexualArousalFromRubbingANonconsentingPerson.setPrintName(L.sexualArousalFromRubbingANonconsentingPersonPrintName);

// ------------- sexualArousalFromWatchingSexualSituations  -------------
Symptom sexualArousalFromWatchingSexualSituations = new Symptom(
    LR.sexualArousalFromWatchingSexualSituations,
    L.sexualArousalFromWatchingSexualSituationsDescription,
    LR.mindSt
);
sexualArousalFromWatchingSexualSituations.setPrintName(L.sexualArousalFromWatchingSexualSituationsPrintName);

// ------------- sexualDesireAbsent  -------------
Symptom sexualDesireAbsent = new Symptom(
    LR.sexualDesireAbsent,
    L.sexualDesireAbsentDescription,
    LR.mindSt
);
sexualDesireAbsent.setPrintName(L.sexualDesireAbsentPrintName);

// ------------- sexualDysfunction  -------------
Symptom sexualDysfunction = new Symptom(
    LR.sexualDysfunction,
    L.sexualDysfunctionDescription,
    LR.bodySt
);
sexualDysfunction.setPrintName(L.sexualDysfunctionPrintName);

// ------------- sexualStimulationIgnored  -------------
Symptom sexualStimulationIgnored = new Symptom(
    LR.sexualStimulationIgnored,
    L.sexualStimulationIgnoredDescription,
    LR.mindSt
);
sexualStimulationIgnored.setPrintName(L.sexualStimulationIgnoredPrintName);

// ------------- shaking  -------------
Symptom shaking = new Symptom(
    LR.shaking,
    L.shakingDescription,
    LR.bodySt
);
shaking.setPrintName(L.shakingPrintName);

// ------------- shoulderPain  -------------
Symptom shoulderPain = new Symptom(
    LR.shoulderPain,
    L.shoulderPainDescription,
    LR.shouldersSt
);
shoulderPain.setPrintName(L.shoulderPainPrintName);

// ------------- sinusPain  -------------
Symptom sinusPain = new Symptom(
    LR.sinusPain,
    L.sinusPainDescription,
    LR.sinusSt
);
sinusPain.setPrintName(L.sinusPainPrintName);

// ------------- sinusSwelling  -------------
Symptom sinusSwelling = new Symptom(
    LR.sinusSwelling,
    L.sinusSwellingDescription,
    LR.sinusSt
);
sinusSwelling.setPrintName(L.sinusSwellingPrintName);

/* => cyanosis
// ------------- skinBlue  -------------
Symptom skinBlue = new Symptom(
    LR.skinBlue,
    L.skinBlueDescription,
    LR.skinSt
);
skinBlue.setPrintName(L.skinBluePrintName);
*/

// ------------- skinBurnedLeatheryBlack  -------------
Symptom skinBurnedLeatheryBlack = new Symptom(
    LR.skinBurnedLeatheryBlack,
    L.skinBurnedLeatheryBlackDescription,
    LR.skinSt
);
skinBurnedLeatheryBlack.setPrintName(L.skinBurnedLeatheryBlackPrintName);

// ------------- skinBurnedLeatheryBrown  -------------
Symptom skinBurnedLeatheryBrown = new Symptom(
    LR.skinBurnedLeatheryBrown,
    L.skinBurnedLeatheryBrownDescription,
    LR.skinSt
);
skinBurnedLeatheryBrown.setPrintName(L.skinBurnedLeatheryBrownPrintName);

// ------------- skinBurnedLeatheryWhite  -------------
Symptom skinBurnedLeatheryWhite = new Symptom(
    LR.skinBurnedLeatheryWhite,
    L.skinBurnedLeatheryWhiteDescription,
    LR.skinSt
);
skinBurnedLeatheryWhite.setPrintName(L.skinBurnedLeatheryWhitePrintName);

// ------------- skinBurnedPain  -------------
Symptom skinBurnedPain = new Symptom(
    LR.skinBurnedPain,
    L.skinBurnedPainDescription,
    LR.skinSt
);
skinBurnedPain.setPrintName(L.skinBurnedPainPrintName);

// ------------- skinBurning  -------------
Symptom skinBurning = new Symptom(
    LR.skinBurning,
    L.skinBurningDescription,
    LR.skinSt
);
skinBurning.setPrintName(L.skinBurningPrintName);

// ------------- skinClammy  -------------
Symptom skinClammy = new Symptom(
    LR.skinClammy,
    L.skinClammyDescription,
    LR.skinSt
);
skinClammy.setPrintName(L.skinClammyPrintName);

// ------------- skinCold  -------------
Symptom skinCold = new Symptom(
    LR.skinCold,
    L.skinColdDescription,
    LR.skinSt
);
skinCold.setPrintName(L.skinColdPrintName);

// ------------- skinDiscoloration  -------------
Symptom skinDiscoloration = new Symptom(
    LR.skinDiscoloration,
    L.skinDiscolorationDescription,
    LR.skinSt
);
skinDiscoloration.setPrintName(L.skinDiscolorationPrintName);

// ------------- skinDry  -------------
Symptom skinDry = new Symptom(
    LR.skinDry,
    L.skinDryDescription,
    LR.skinSt
);
skinDry.setPrintName(L.skinDryPrintName);

// ------------- skinDusky  -------------
Symptom skinDusky = new Symptom(
    LR.skinDusky,
    L.skinDuskyDescription,
    LR.skinSt
);
skinDusky.setPrintName(L.skinDuskyPrintName);

// ------------- skinElasticityLoss  -------------
Symptom skinElasticityLoss = new Symptom(
    LR.skinElasticityLoss,
    L.skinElasticityLossDescription,
    LR.skinSt
);
skinElasticityLoss.setPrintName(L.skinElasticityLossPrintName);

// -------------- skinFaceTight --------------
// (C) OntoOO Inc Thu Sep 09 16:07:31 GMT-08:00 2004
Symptom skinFaceTight = new Symptom(
    LR.skinFaceTight,
    L.skinFaceTightDescription,
    LR.faceSt
);
skinFaceTight.setPrintName(L.skinFaceTightPrintName);

// ------------- skinFlushing  -------------
Symptom skinFlushing = new Symptom(
    LR.skinFlushing,
    L.skinFlushingDescription,
    LR.skinSt
);
skinFlushing.setPrintName(L.skinFlushingPrintName);

// ------------- skinGumma  -------------
Symptom skinGumma = new Symptom(
    LR.skinGumma,
    L.skinGummaDescription,
    LR.skinSt
);
skinGumma.setPrintName(L.skinGummaPrintName);

// -------------- skinHandsTight --------------
// (C) OntoOO Inc Thu Sep 09 16:07:31 GMT-08:00 2004
Symptom skinHandsTight = new Symptom(
    LR.skinHandsTight,
    L.skinHandsTightDescription,
    LR.handsSt
);
skinHandsTight.setPrintName(L.skinHandsTightPrintName);

// ------------- skinInfection  -------------
Symptom skinInfection = new Symptom(
    LR.skinInfection,
    L.skinInfectionDescription,
    LR.skinSt
);
skinInfection.setPrintName(L.skinInfectionPrintName);

// ------------- skinLesionBackgroundBrownBlack  -------------
Symptom skinLesionBackgroundBrownBlack = new Symptom(
    LR.skinLesionBackgroundBrownBlack,
    L.skinLesionBackgroundBrownBlackDescription,
    LR.skinSt
);
skinLesionBackgroundBrownBlack.setPrintName(L.skinLesionBackgroundBrownBlackPrintName);

// ------------- skinLesionBlackNodules  -------------
Symptom skinLesionBlackNodules = new Symptom(
    LR.skinLesionBlackNodules,
    L.skinLesionBlackNodulesDescription,
    LR.skinSt
);
skinLesionBlackNodules.setPrintName(L.skinLesionBlackNodulesPrintName);

// ------------- skinLesionBlackberryLike  -------------
Symptom skinLesionBlackberryLike = new Symptom(
    LR.skinLesionBlackberryLike,
    L.skinLesionBlackberryLikeDescription,
    LR.skinSt
);
skinLesionBlackberryLike.setPrintName(L.skinLesionBlackberryLikePrintName);
skinLesionBlackberryLike.setCardinal();

// ------------- skinLesionBlue  -------------
Symptom skinLesionBlue = new Symptom(
    LR.skinLesionBlue,
    L.skinLesionBlueDescription,
    LR.skinSt
);
skinLesionBlue.setPrintName(L.skinLesionBluePrintName);

// ------------- skinLesionCoinShaped  -------------
Symptom skinLesionCoinShaped = new Symptom(
    LR.skinLesionCoinShaped,
    L.skinLesionCoinShapedDescription,
    LR.skinSt
);
skinLesionCoinShaped.setPrintName(L.skinLesionCoinShapedPrintName);

// ------------- skinLesionCrackedCrusty  -------------
Symptom skinLesionCrackedCrusty = new Symptom(
    LR.skinLesionCrackedCrusty,
    L.skinLesionCrackedCrustyDescription,
    LR.skinSt
);
skinLesionCrackedCrusty.setPrintName(L.skinLesionCrackedCrustyPrintName);

// ------------- skinLesionDryScaly  -------------
Symptom skinLesionDryScaly = new Symptom(
    LR.skinLesionDryScaly,
    L.skinLesionDryScalyDescription,
    LR.skinSt
);
skinLesionDryScaly.setPrintName(L.skinLesionDryScalyPrintName);

// ------------- skinLesionEnlarged  -------------
Symptom skinLesionEnlarged = new Symptom(
    LR.skinLesionEnlarged,
    L.skinLesionEnlargedDescription,
    LR.skinSt
);
skinLesionEnlarged.setPrintName(L.skinLesionEnlargedPrintName);

// ------------- skinLesionFoot  -------------
Symptom skinLesionFoot = new Symptom(
    LR.skinLesionFoot,
    L.skinLesionFootDescription,
    LR.feetSt
);
skinLesionFoot.setPrintName(L.skinLesionFootPrintName);

// ------------- skinLesionFreckelLike  -------------
Symptom skinLesionFreckelLike = new Symptom(
    LR.skinLesionFreckelLike,
    L.skinLesionFreckelLikeDescription,
    LR.skinSt
);
skinLesionFreckelLike.setPrintName(L.skinLesionFreckelLikePrintName);
skinLesionFreckelLike.setCardinal();

// ------------- skinLesionFuzzyBorder  -------------
Symptom skinLesionFuzzyBorder = new Symptom(
    LR.skinLesionFuzzyBorder,
    L.skinLesionFuzzyBorderDescription,
    LR.skinSt
);
skinLesionFuzzyBorder.setPrintName(L.skinLesionFuzzyBorderPrintName);

// ------------- skinLesionGreasy  -------------
Symptom skinLesionGreasy = new Symptom(
    LR.skinLesionGreasy,
    L.skinLesionGreasyDescription,
    LR.skinSt
);
skinLesionGreasy.setPrintName(L.skinLesionGreasyPrintName);

// ------------- skinLesionHand  -------------
Symptom skinLesionHand = new Symptom(
    LR.skinLesionHand,
    L.skinLesionHandDescription,
    LR.handsSt
);
skinLesionHand.setPrintName(L.skinLesionHandPrintName);

// ------------- skinLesionLightlyPigmented  -------------
Symptom skinLesionLightlyPigmented = new Symptom(
    LR.skinLesionLightlyPigmented,
    L.skinLesionLightlyPigmentedDescription,
    LR.skinSt
);
skinLesionLightlyPigmented.setPrintName(L.skinLesionLightlyPigmentedPrintName);

// ------------- skinLesionMacular  -------------
Symptom skinLesionMacular = new Symptom(
    LR.skinLesionMacular,
    L.skinLesionMacularDescription,
    LR.skinSt
);
skinLesionMacular.setPrintName(L.skinLesionMacularPrintName);

// ------------- skinLesionMoistCrusty  -------------
Symptom skinLesionMoistCrusty = new Symptom(
    LR.skinLesionMoistCrusty,
    L.skinLesionMoistCrustyDescription,
    LR.skinSt
);
skinLesionMoistCrusty.setPrintName(L.skinLesionMoistCrustyPrintName);

// ------------- skinLesionNodulesBleeding  -------------
Symptom skinLesionNodulesBleeding = new Symptom(
    LR.skinLesionNodulesBleeding,
    L.skinLesionNodulesBleedingDescription,
    LR.skinSt
);
skinLesionNodulesBleeding.setPrintName(L.skinLesionNodulesBleedingPrintName);

// ------------- skinLesionPinkWhite  -------------
Symptom skinLesionPinkWhite = new Symptom(
    LR.skinLesionPinkWhite,
    L.skinLesionPinkWhiteDescription,
    LR.skinSt
);
skinLesionPinkWhite.setPrintName(L.skinLesionPinkWhitePrintName);

// ------------- skinLesionPlaqueLike  -------------
Symptom skinLesionPlaqueLike = new Symptom(
    LR.skinLesionPlaqueLike,
    L.skinLesionPlaqueLikeDescription,
    LR.skinSt
);
skinLesionPlaqueLike.setPrintName(L.skinLesionPlaqueLikePrintName);

// ------------- skinLesionRedNodule  -------------
Symptom skinLesionRedNodule = new Symptom(
    LR.skinLesionRedNodule,
    L.skinLesionRedNoduleDescription,
    LR.skinSt
);
skinLesionRedNodule.setPrintName(L.skinLesionRedNodulePrintName);

// -------------- skinLesionRedPapular --------------
// (C) OntoOO Inc Tue Feb 24 21:13:08 PST 2004
Symptom skinLesionRedPapular = new Symptom(
    LR.skinLesionRedPapular,
    L.skinLesionRedPapularDescription,
    LR.skinSt
);
skinLesionRedPapular.setPrintName(L.skinLesionRedPapularPrintName);

// ------------- skinLesionRedStreaked  -------------
Symptom skinLesionRedStreaked = new Symptom(
    LR.skinLesionRedStreaked,
    L.skinLesionRedStreakedDescription,
    LR.skinSt
);
skinLesionRedStreaked.setPrintName(L.skinLesionRedStreakedPrintName);

// ------------- skinLesionRedSwollenRaised  -------------
Symptom skinLesionRedSwollenRaised = new Symptom(
    LR.skinLesionRedSwollenRaised,
    L.skinLesionRedSwollenRaisedDescription,
    LR.skinSt
);
skinLesionRedSwollenRaised.setPrintName(L.skinLesionRedSwollenRaisedPrintName);

// ------------- skinLesionRedWeeping  -------------
Symptom skinLesionRedWeeping = new Symptom(
    LR.skinLesionRedWeeping,
    L.skinLesionRedWeepingDescription,
    LR.skinSt
);
skinLesionRedWeeping.setPrintName(L.skinLesionRedWeepingPrintName);

// ------------- skinLesionRedWhite  -------------
Symptom skinLesionRedWhite = new Symptom(
    LR.skinLesionRedWhite,
    L.skinLesionRedWhiteDescription,
    LR.skinSt
);
skinLesionRedWhite.setPrintName(L.skinLesionRedWhitePrintName);

// ------------- skinLesionRingShaped  -------------
Symptom skinLesionRingShaped = new Symptom(
    LR.skinLesionRingShaped,
    L.skinLesionRingShapedDescription,
    LR.skinSt
);
skinLesionRingShaped.setPrintName(L.skinLesionRingShapedPrintName);

// ------------- skinLesionSharpBorder  -------------
Symptom skinLesionSharpBorder = new Symptom(
    LR.skinLesionSharpBorder,
    L.skinLesionSharpBorderDescription,
    LR.skinSt
);
skinLesionSharpBorder.setPrintName(L.skinLesionSharpBorderPrintName);

// ------------- skinLesionSurfaceIrregular  -------------
Symptom skinLesionSurfaceIrregular = new Symptom(
    LR.skinLesionSurfaceIrregular,
    L.skinLesionSurfaceIrregularDescription,
    LR.skinSt
);
skinLesionSurfaceIrregular.setPrintName(L.skinLesionSurfaceIrregularPrintName);

// ------------- skinLesionUniformDarkColor  -------------
Symptom skinLesionUniformDarkColor = new Symptom(
    LR.skinLesionUniformDarkColor,
    L.skinLesionUniformDarkColorDescription,
    LR.skinSt
);
skinLesionUniformDarkColor.setPrintName(L.skinLesionUniformDarkColorPrintName);

// ------------- skinLesionYellowScales  -------------
Symptom skinLesionYellowScales = new Symptom(
    LR.skinLesionYellowScales,
    L.skinLesionYellowScalesDescription,
    LR.skinSt
);
skinLesionYellowScales.setPrintName(L.skinLesionYellowScalesPrintName);

// ------------- skinLesionYellowish  -------------
Symptom skinLesionYellowish = new Symptom(
    LR.skinLesionYellowish,
    L.skinLesionYellowishDescription,
    LR.skinSt
);
skinLesionYellowish.setPrintName(L.skinLesionYellowishPrintName);

// ------------- skinMottled  -------------
Symptom skinMottled = new Symptom(
    LR.skinMottled,
    L.skinMottledDescription,
    LR.skinSt
);
skinMottled.setPrintName(L.skinMottledPrintName);

// ------------- skinNodules  -------------
Symptom skinNodules = new Symptom(
    LR.skinNodules,
    L.skinNodulesDescription,
    LR.skinSt
);
skinNodules.setPrintName(L.skinNodulesPrintName);

// ------------- skinNumbness  -------------
Symptom skinNumbness = new Symptom(
    LR.skinNumbness,
    L.skinNumbnessDescription,
    LR.skinSt
);
skinNumbness.setPrintName(L.skinNumbnessPrintName);

// ------------- skinOfGenitalChancre  -------------
Symptom skinOfGenitalChancre = new Symptom(
    LR.skinOfGenitalChancre,
    L.skinOfGenitalChancreDescription,
    LR.skinOfGenitalSt
);
skinOfGenitalChancre.setPrintName(L.skinOfGenitalChancrePrintName);
skinOfGenitalChancre.setCardinal();

// ------------- skinPale  -------------
Symptom skinPale = new Symptom(
    LR.skinPale,
    L.skinPaleDescription,
    LR.skinSt
);
skinPale.setPrintName(L.skinPalePrintName);

// ------------- skinPatchesPurple  -------------
Symptom skinPatchesPurple = new Symptom(
    LR.skinPatchesPurple,
    L.skinPatchesPurpleDescription,
    LR.skinSt
);
skinPatchesPurple.setPrintName(L.skinPatchesPurplePrintName);

// ------------- skinPeeling  -------------
Symptom skinPeeling = new Symptom(
    LR.skinPeeling,
    L.skinPeelingDescription,
    LR.skinSt
);
skinPeeling.setPrintName(L.skinPeelingPrintName);

// ------------- skinPlaques  -------------
Symptom skinPlaques = new Symptom(
    LR.skinPlaques,
    L.skinPlaquesDescription,
    LR.skinSt
);
skinPlaques.setPrintName(L.skinPlaquesPrintName);

// -------------- skinPlaquesRaised --------------
// (C) OntoOO Inc Wed Jul 14 07:54:59 PDT 2004
Symptom skinPlaquesRaised = new Symptom(
    LR.skinPlaquesRaised,
    L.skinPlaquesRaisedDescription,
    LR.skinSt
);
skinPlaquesRaised.setPrintName(L.skinPlaquesRaisedPrintName);

// -------------- skinPlaquesRed --------------
// (C) OntoOO Inc Wed Jul 14 07:54:59 PDT 2004
Symptom skinPlaquesRed = new Symptom(
    LR.skinPlaquesRed,
    L.skinPlaquesRedDescription,
    LR.skinSt
);
skinPlaquesRed.setPrintName(L.skinPlaquesRedPrintName);

// -------------- skinPlaquesScaled --------------
// (C) OntoOO Inc Wed Jul 14 07:54:59 PDT 2004
Symptom skinPlaquesScaled = new Symptom(
    LR.skinPlaquesScaled,
    L.skinPlaquesScaledDescription,
    LR.skinSt
);
skinPlaquesScaled.setPrintName(L.skinPlaquesScaledPrintName);

// ------------- skinPricking  -------------
Symptom skinPricking = new Symptom(
    LR.skinPricking,
    L.skinPrickingDescription,
    LR.skinSt
);
skinPricking.setPrintName(L.skinPrickingPrintName);

// ------------- skinSilveryScales  -------------
Symptom skinSilveryScales = new Symptom(
    LR.skinSilveryScales,
    L.skinSilveryScalesDescription,
    LR.skinSt
);
skinSilveryScales.setPrintName(L.skinSilveryScalesPrintName);

// ------------- skinSwollen  -------------
Symptom skinSwollen = new Symptom(
    LR.skinSwollen,
    L.skinSwollenDescription,
    LR.skinSt
);
skinSwollen.setPrintName(L.skinSwollenPrintName);

// ------------- skinTender  -------------
Symptom skinTender = new Symptom(
    LR.skinTender,
    L.skinTenderDescription,
    LR.skinSt
);
skinTender.setPrintName(L.skinTenderPrintName);

// ------------- skinTingling  -------------
Symptom skinTingling = new Symptom(
    LR.skinTingling,
    L.skinTinglingDescription,
    LR.skinSt
);
skinTingling.setPrintName(L.skinTinglingPrintName);

// ------------- skinTissueCharred  -------------
Symptom skinTissueCharred = new Symptom(
    LR.skinTissueCharred,
    L.skinTissueCharredDescription,
    LR.skinSt
);
skinTissueCharred.setPrintName(L.skinTissueCharredPrintName);

// ------------- skinToneAdult  -------------
Symptom skinToneAdult = new Symptom(
    LR.skinToneAdult,
    L.skinToneAdultDescription,
    LR.skinSt
);
skinToneAdult.setPrintName(L.skinToneAdultPrintName);

// ------------- skinWarm  -------------
Symptom skinWarm = new Symptom(
    LR.skinWarm,
    L.skinWarmDescription,
    LR.skinSt
);
skinWarm.setPrintName(L.skinWarmPrintName);

// ------------- skinWaxy  -------------
Symptom skinWaxy = new Symptom(
    LR.skinWaxy,
    L.skinWaxyDescription,
    LR.skinSt
);
skinWaxy.setPrintName(L.skinWaxyPrintName);

// -------------- skullDistension --------------
// (C) OntoOO Inc Tue May 11 16:06:58 PDT 2004
Symptom skullDistension = new Symptom(
    LR.skullDistension,
    L.skullDistensionDescription,
    LR.skullSt
);
skullDistension.setPrintName(L.skullDistensionPrintName);

// ------------- sleepDisturbed  -------------
Symptom sleepDisturbed = new Symptom(
    LR.sleepDisturbed,
    L.sleepDisturbedDescription,
    LR.brainSt
);
sleepDisturbed.setPrintName(L.sleepDisturbedPrintName);

// ------------- slightAlopecia  -------------
Symptom slightAlopecia = new Symptom(
    LR.slightAlopecia,
    L.slightAlopeciaDescription,
    LR.scalpSt
);
slightAlopecia.setPrintName(L.slightAlopeciaPrintName);

// ------------- sluggishness  -------------
Symptom sluggishness = new Symptom(
    LR.sluggishness,
    L.sluggishnessDescription,
    LR.bodySt
);
sluggishness.setPrintName(L.sluggishnessPrintName);

// ------------- sneezing  -------------
Symptom sneezing = new Symptom(
    LR.sneezing,
    L.sneezingDescription,
    LR.noseSt
);
sneezing.setPrintName(L.sneezingPrintName);

// ------------- socialPerformanceFear  -------------
Symptom socialPerformanceFear = new Symptom(
    LR.socialPerformanceFear,
    L.socialPerformanceFearDescription,
    LR.mindSt
);
socialPerformanceFear.setPrintName(L.socialPerformanceFearPrintName);

// ------------- socialWithdrawal  -------------
Symptom socialWithdrawal = new Symptom(
    LR.socialWithdrawal,
    L.socialWithdrawalDescription,
    LR.mindSt
);
socialWithdrawal.setPrintName(L.socialWithdrawalPrintName);

// ------------- somnolence  -------------
Symptom somnolence = new Symptom(
    LR.somnolence,
    L.somnolenceDescription,
    LR.bodySt
);
somnolence.setPrintName(L.somnolencePrintName);

// ------------- spasm  -------------
Symptom spasm = new Symptom(
    LR.spasm,
    L.spasmDescription,
    LR.aMuscleSt
);
spasm.setPrintName(L.spasmPrintName);

// ------------- speechDifficulty  -------------
Symptom speechDifficulty = new Symptom(
    LR.speechDifficulty,
    L.speechDifficultyDescription,
    LR.tongueSt
);
speechDifficulty.setPrintName(L.speechDifficultyPrintName);

// ------------- speechSlurred  -------------
Symptom speechSlurred = new Symptom(
    LR.speechSlurred,
    L.speechSlurredDescription,
    LR.mindSt
);
speechSlurred.setPrintName(L.speechSlurredPrintName);

// ------------- speechUnintelligible  -------------
Symptom speechUnintelligible = new Symptom(
    LR.speechUnintelligible,
    L.speechUnintelligibleDescription,
    LR.mindSt
);
speechUnintelligible.setPrintName(L.speechUnintelligiblePrintName);

// ------------- speechUnusual  -------------
Symptom speechUnusual = new Symptom(
    LR.speechUnusual,
    L.speechUnusualDescription,
    LR.mindSt
);
speechUnusual.setPrintName(L.speechUnusualPrintName);

// ------------- spiderBite  -------------
Symptom spiderBite = new Symptom(
    LR.spiderBite,
    L.spiderBiteDescription,
    LR.skinSt
);
spiderBite.setPrintName(L.spiderBitePrintName);

// ------------- spineDeformation  -------------
Symptom spineDeformation = new Symptom(
    LR.spineDeformation,
    L.spineDeformationDescription,
    LR.spineSt
);
spineDeformation.setPrintName(L.spineDeformationPrintName);

// ------------- spineStiff  -------------
Symptom spineStiff = new Symptom(
    LR.spineStiff,
    L.spineStiffDescription,
    LR.spineSt
);
spineStiff.setPrintName(L.spineStiffPrintName);

// ------------- spotting  -------------
Symptom spotting = new Symptom(
    LR.spotting,
    L.spottingDescription,
    LR.vulvaSt
);
spotting.setPrintName(L.spottingPrintName);

// ------------- sputumBlack  -------------
Symptom sputumBlack = new Symptom(
    LR.sputumBlack,
    L.sputumBlackDescription,
    LR.mouthSt
);
sputumBlack.setPrintName(L.sputumBlackPrintName);

/*  see hemoptysis
// ------------- sputumBloody  -------------
Symptom sputumBloody = new Symptom(
    LR.sputumBloody,
    L.sputumBloodyDescription,
    LR.mouthSt
);
sputumBloody.setPrintName(L.sputumBloodyPrintName);
*/

// ------------- sputumFoulSmelling  -------------
Symptom sputumFoulSmelling = new Symptom(
    LR.sputumFoulSmelling,
    L.sputumFoulSmellingDescription,
    LR.mouthSt
);
sputumFoulSmelling.setPrintName(L.sputumFoulSmellingPrintName);

// ------------- sputumFrothy  -------------
Symptom sputumFrothy = new Symptom(
    LR.sputumFrothy,
    L.sputumFrothyDescription,
    LR.mouthSt
);
sputumFrothy.setPrintName(L.sputumFrothyPrintName);

// ------------- sputumGray  -------------
Symptom sputumGray = new Symptom(
    LR.sputumGray,
    L.sputumGrayDescription,
    LR.mouthSt
);
sputumGray.setPrintName(L.sputumGrayPrintName);

// ------------- sputumMucoid  -------------
Symptom sputumMucoid = new Symptom(
    LR.sputumMucoid,
    L.sputumMucoidDescription,
    LR.mouthSt
);
sputumMucoid.setPrintName(L.sputumMucoidPrintName);

// ------------- sputumMucopurulent  -------------
Symptom sputumMucopurulent = new Symptom(
    LR.sputumMucopurulent,
    L.sputumMucopurulentDescription,
    LR.mouthSt
);
sputumMucopurulent.setPrintName(L.sputumMucopurulentPrintName);

// ------------- sputumProduction  -------------
Symptom sputumProduction = new Symptom(
    LR.sputumProduction,
    L.sputumProductionDescription,
    LR.mouthSt
);
sputumProduction.setPrintName(L.sputumProductionPrintName);

// ------------- sputumPurulent  -------------
Symptom sputumPurulent = new Symptom(
    LR.sputumPurulent,
    L.sputumPurulentDescription,
    LR.mouthSt
);
sputumPurulent.setPrintName(L.sputumPurulentPrintName);

// ------------- sputumYellowGreenThick  -------------
Symptom sputumYellowGreenThick = new Symptom(
    LR.sputumYellowGreenThick,
    L.sputumYellowGreenThickDescription,
    LR.mouthSt
);
sputumYellowGreenThick.setPrintName(L.sputumYellowGreenThickPrintName);

// ------------- stabbingChestPain  -------------
Symptom stabbingChestPain = new Symptom(
    LR.stabbingChestPain,
    L.stabbingChestPainDescription,
    LR.chestSt
);
stabbingChestPain.setPrintName(L.stabbingChestPainPrintName);

/*
// -------------- steatorrhea --------------
// (C) OntoOO Inc Wed Feb 18 16:36:39 PST 2004
Symptom steatorrhea  = new Symptom(
    LR.steatorrhea,
    L.steatorrheaDescription,
    LR.rectumSt
);
steatorrhea.setPrintName(L.steatorrheaPrintName);
*/

// ------------- stiffness  -------------
Symptom stiffness = new Symptom(
    LR.stiffness,
    L.stiffnessDescription,
    LR.jointsSt
);
stiffness.setPrintName(L.stiffnessPrintName);

// ------------- stomachache  -------------
Symptom stomachache = new Symptom(
    LR.stomachache,
    L.stomachacheDescription,
    LR.stomachSt
);
stomachache.setPrintName(L.stomachachePrintName);

// ------------- stomachCramps  -------------
Symptom stomachCramps = new Symptom(
    LR.stomachCramps,
    L.stomachCrampsDescription,
    LR.stomachSt
);
stomachCramps.setPrintName(L.stomachCrampsPrintName);

// ------------- stomachSwelling  -------------
Symptom stomachSwelling = new Symptom(
    LR.stomachSwelling,
    L.stomachSwellingDescription,
    LR.stomachSt
);
stomachSwelling.setPrintName(L.stomachSwellingPrintName);

// ------------- stomachUpset  -------------
Symptom stomachUpset = new Symptom(
    LR.stomachUpset,
    L.stomachUpsetDescription,
    LR.stomachSt
);
stomachUpset.setPrintName(L.stomachUpsetPrintName);

// ------------- stoolBlack  -------------
Symptom stoolBlack = new Symptom(
    LR.stoolBlack,
    L.stoolBlackDescription,
    LR.rectumSt
);
stoolBlack.setPrintName(L.stoolBlackPrintName);

// ------------- stoolBloody  -------------
Symptom stoolBloody = new Symptom(
    LR.stoolBloody,
    L.stoolBloodyDescription,
    LR.rectumSt
);
stoolBloody.setPrintName(L.stoolBloodyPrintName);
stoolBloody.setCardinal();

// ------------- stoolBrightRedBloody  -------------
Symptom stoolBrightRedBloody = new Symptom(
    LR.stoolBrightRedBloody,
    L.stoolBrightRedBloodyDescription,
    LR.rectumSt
);
stoolBrightRedBloody.setPrintName(L.stoolBrightRedBloodyPrintName);

// -------------- stoolClayColored --------------
// (C) OntoOO Inc Tue Mar 08 13:37:15 PST 2005
Symptom stoolClayColored = new Symptom(
    LR.stoolClayColored,
    L.stoolClayColoredDescription,
    LR.rectumSt
);
stoolClayColored.setPrintName(L.stoolClayColoredPrintName);

// -------------- stoolFrequent --------------
// (C) OntoOO Inc Fri Feb 25 10:54:18 PST 2005
Symptom stoolFrequent = new Symptom(
    LR.stoolFrequent,
    L.stoolFrequentDescription,
    LR.rectumSt
);
stoolFrequent.setPrintName(L.stoolFrequentPrintName);

// -------------- stoolGreasy --------------
// (C) OntoOO Inc Fri Feb 25 10:52:44 PST 2005
Symptom stoolGreasy = new Symptom(
    LR.stoolGreasy,
    L.stoolGreasyDescription,
    LR.rectumSt
);
stoolGreasy.setPrintName(L.stoolGreasyPrintName);

// -------------- stoolMalodorous --------------
// (C) OntoOO Inc Fri Feb 25 10:53:29 PST 2005
Symptom stoolMalodorous = new Symptom(
    LR.stoolMalodorous,
    L.stoolMalodorousDescription,
    LR.rectumSt
);
stoolMalodorous.setPrintName(L.stoolMalodorousPrintName);

// ------------- stoolTarry  -------------
Symptom stoolTarry = new Symptom(
    LR.stoolTarry,
    L.stoolTarryDescription,
    LR.rectumSt
);
stoolTarry.setPrintName(L.stoolTarryPrintName);

// ------------- stoolThinShaped  -------------
Symptom stoolThinShaped = new Symptom(
    LR.stoolThinShaped,
    L.stoolThinShapedDescription,
    LR.rectumSt
);
stoolThinShaped.setPrintName(L.stoolThinShapedPrintName);

// ------------- stoolWatery  -------------
Symptom stoolWatery = new Symptom(
    LR.stoolWatery,
    L.stoolWateryDescription,
    LR.rectumSt
);
stoolWatery.setPrintName(L.stoolWateryPrintName);

// -------------- striaePurplish --------------
// (C) OntoOO Inc Sun Feb 22 16:30:44 PST 2004
Symptom striaePurplish = new Symptom(
    LR.striaePurplish,
    L.striaePurplishDescription,
    LR.skinSt
);
striaePurplish.setPrintName(L.striaePurplishPrintName);

// ------------- stridor  -------------
Symptom stridor = new Symptom(
    LR.stridor,
    L.stridorDescription,
    LR.tracheaSt
);
stridor.setPrintName(L.stridorPrintName);
stridor.setCardinal();

// ------------- stupor  -------------
Symptom stupor = new Symptom(
    LR.stupor,
    L.stuporDescription,
    LR.mindSt
);
stupor.setPrintName(L.stuporPrintName);

// ------------- substernalPain  -------------
Symptom substernalPain = new Symptom(
    LR.substernalPain,
    L.substernalPainDescription,
    LR.chestSt
);
substernalPain.setPrintName(L.substernalPainPrintName);

// ------------- suckingSoundWhileBreathing  -------------
Symptom suckingSoundWhileBreathing = new Symptom(
    LR.suckingSoundWhileBreathing,
    L.suckingSoundWhileBreathingDescription,
    LR.chestSt
);
suckingSoundWhileBreathing.setPrintName(L.suckingSoundWhileBreathingPrintName);

// ------------- suicideThoughts  -------------
Symptom suicideThoughts = new Symptom(
    LR.suicideThoughts,
    L.suicideThoughtsDescription,
    LR.mindSt
);
suicideThoughts.setPrintName(L.suicideThoughtsPrintName);

// ------------- suspiciousness  -------------
Symptom suspiciousness = new Symptom(
    LR.suspiciousness,
    L.suspiciousnessDescription,
    LR.mindSt
);
suspiciousness.setPrintName(L.suspiciousnessPrintName);

// ------------- swallowingDifficult  -------------
/*
Symptom swallowingDifficult = new Symptom(
    LR.swallowingDifficult,
    L.swallowingDifficultDescription,
    LR.tongueSt
);
swallowingDifficult.setPrintName(L.swallowingDifficultPrintName);
*/

// ------------- swallowingPainful  -------------
Symptom swallowingPainful = new Symptom(
    LR.swallowingPainful,
    L.swallowingPainfulDescription,
    LR.tongueSt
);
swallowingPainful.setPrintName(L.swallowingPainfulPrintName);

// ------------- sweating  -------------
Symptom sweating = new Symptom(
    LR.sweating,
    L.sweatingDescription,
    LR.skinSt
);
sweating.setPrintName(L.sweatingPrintName);

// ------------- swellingLocal  -------------
Symptom swellingLocal = new Symptom(
    LR.swellingLocal,
    L.swellingLocalDescription,
    LR.skinSt
);
swellingLocal.setPrintName(L.swellingLocalPrintName);

// ------------- syncope  -------------
Symptom syncope = new Symptom(
    LR.syncope,
    L.syncopeDescription,
    LR.heartSt
);
syncope.setPrintName(L.syncopePrintName);

// ------------- tachycardia  -------------
Symptom tachycardia = new Symptom(
    LR.tachycardia,
    L.tachycardiaDescription,
    LR.heartSt
);
tachycardia.setPrintName(L.tachycardiaPrintName);

// ------------- tachypnea  -------------
Symptom tachypnea = new Symptom(
    LR.tachypnea,
    L.tachypneaDescription,
    LR.lungsSt
);
tachypnea.setPrintName(L.tachypneaPrintName);

// ------------- talkative  -------------
Symptom talkative = new Symptom(
    LR.talkative,
    L.talkativeDescription,
    LR.mindSt
);
talkative.setPrintName(L.talkativePrintName);

// ------------- thinkingFuzzy  -------------
Symptom thinkingFuzzy = new Symptom(
    LR.thinkingFuzzy,
    L.thinkingFuzzyDescription,
    LR.mindSt
);
thinkingFuzzy.setPrintName(L.thinkingFuzzyPrintName);

// ------------- tasteLoss  -------------
Symptom tasteLoss = new Symptom(
    LR.tasteLoss,
    L.tasteLossDescription,
    LR.mouthSt
);
tasteLoss.setPrintName(L.tasteLossPrintName);

// ------------- tearing  -------------
Symptom tearing = new Symptom(
    LR.tearing,
    L.tearingDescription,
    LR.eyesSt
);
tearing.setPrintName(L.tearingPrintName);

// -------------- teethLoose --------------
// (C) OntoOO Inc Fri Oct 08 14:58:24 GMT-08:00 2004
Symptom teethLoose = new Symptom(
    LR.teethLoose,
    L.teethLooseDescription,
    LR.teethSt
);
teethLoose.setPrintName(L.teethLoosePrintName);

// -------------- teethSore --------------
// (C) OntoOO Inc Wed May 04 17:58:11 2011
Symptom teethSore = new Symptom(
    LR.teethSore,
    L.teethSoreDescription,
    LR.teethSt
);
teethSore.setPrintName(L.teethSorePrintName);

// ------------- temperatureSwingsSevere  -------------
Symptom temperatureSwingsSevere = new Symptom(
    LR.temperatureSwingsSevere,
    L.temperatureSwingsSevereDescription,
    LR.bodySt
);
temperatureSwingsSevere.setPrintName(L.temperatureSwingsSeverePrintName);

// ------------- tendernessLocal  -------------
Symptom tendernessLocal = new Symptom(
    LR.tendernessLocal,
    L.tendernessLocalDescription,
    LR.skinSt
);
tendernessLocal.setPrintName(L.tendernessLocalPrintName);

// ------------- tendonReflexDecreased  -------------
Symptom tendonReflexDecreased = new Symptom(
    LR.tendonReflexDecreased,
    L.tendonReflexDecreasedDescription,
    LR.aTendonSt
);
tendonReflexDecreased.setPrintName(L.tendonReflexDecreasedPrintName);

// ------------- tendonReflexesHyperactive  -------------
Symptom tendonReflexesHyperactive = new Symptom(
    LR.tendonReflexesHyperactive,
    L.tendonReflexesHyperactiveDescription,
    LR.aTendonSt
);
tendonReflexesHyperactive.setPrintName(L.tendonReflexesHyperactivePrintName);

// ------------- tenesmus  -------------
Symptom tenesmus = new Symptom(
    LR.tenesmus,
    L.tenesmusDescription,
    LR.anusSt
);
tenesmus.setPrintName(L.tenesmusPrintName);

// ------------- testicleNodule  -------------
Symptom testicleNodule = new Symptom(
    LR.testicleNodule,
    L.testicleNoduleDescription,
    LR.testiclesSt
);
testicleNodule.setPrintName(L.testicleNodulePrintName);

// ------------- testiclePain  -------------
Symptom testiclePain = new Symptom(
    LR.testiclePain,
    L.testiclePainDescription,
    LR.testiclesSt
);
testiclePain.setPrintName(L.testiclePainPrintName);

// ------------- testicleSizeDiffer  -------------
Symptom testicleSizeDiffer = new Symptom(
    LR.testicleSizeDiffer,
    L.testicleSizeDifferDescription,
    LR.testiclesSt
);
testicleSizeDiffer.setPrintName(L.testicleSizeDifferPrintName);

// ------------- testicleSoft  -------------
Symptom testicleSoft = new Symptom(
    LR.testicleSoft,
    L.testicleSoftDescription,
    LR.testiclesSt
);
testicleSoft.setPrintName(L.testicleSoftPrintName);

// ------------- testiclesEnlarged  -------------
Symptom testiclesEnlarged = new Symptom(
    LR.testiclesEnlarged,
    L.testiclesEnlargedDescription,
    LR.testiclesSt
);
testiclesEnlarged.setPrintName(L.testiclesEnlargedPrintName);

// -------------- tetany --------------
// (C) OntoOO Inc Wed Feb 18 17:29:49 PST 2004
Symptom tetany = new Symptom(
    LR.tetany,
    L.tetanyDescription,
    LR.aMuscleSt
);
tetany.setPrintName(L.tetanyPrintName);

// ------------- thickMucus  -------------
Symptom thickMucus = new Symptom(
    LR.thickMucus,
    L.thickMucusDescription,
    LR.lungsSt
);
thickMucus.setPrintName(L.thickMucusPrintName);

// ------------- thighPapule  -------------
Symptom thighPapule = new Symptom(
    LR.thighPapule,
    L.thighPapuleDescription,
    LR.thighsSt
);
thighPapule.setPrintName(L.thighPapulePrintName);

// ------------- thirst  -------------
Symptom thirst = new Symptom(
    LR.thirst,
    L.thirstDescription,
    LR.bodySt
);
thirst.setPrintName(L.thirstPrintName);

// ------------- thirstExcessive  -------------
Symptom thirstExcessive = new Symptom(
    LR.thirstExcessive,
    L.thirstExcessiveDescription,
    LR.bodySt
);
thirstExcessive.setPrintName(L.thirstExcessivePrintName);

// ------------- thoughtsDisturbing  -------------
Symptom thoughtsDisturbing = new Symptom(
    LR.thoughtsDisturbing,
    L.thoughtsDisturbingDescription,
    LR.mindSt
);
thoughtsDisturbing.setPrintName(L.thoughtsDisturbingPrintName);

// ------------- throatConstriction  -------------
Symptom throatConstriction = new Symptom(
    LR.throatConstriction,
    L.throatConstrictionDescription,
    LR.throatSt
);
throatConstriction.setPrintName(L.throatConstrictionPrintName);

// ------------- throatDry  -------------
Symptom throatDry = new Symptom(
    LR.throatDry,
    L.throatDryDescription,
    LR.throatSt
);
throatDry.setPrintName(L.throatDryPrintName);

// ------------- throatItches  -------------
Symptom throatItches = new Symptom(
    LR.throatItches,
    L.throatItchesDescription,
    LR.throatSt
);
throatItches.setPrintName(L.throatItchesPrintName);

// ------------- throatRed  -------------
Symptom throatRed = new Symptom(
    LR.throatRed,
    L.throatRedDescription,
    LR.throatSt
);
throatRed.setPrintName(L.throatRedPrintName);

// -------------- throatScale --------------
// (C) OntoOO Inc Mon Feb 16 11:39:09 PST 2004
Symptom throatScale = new Symptom(
    LR.throatScale,
    L.throatScaleDescription,
    LR.throatSt
);
throatScale.setPrintName(L.throatScalePrintName);

// ------------- throatSore  -------------
Symptom throatSore = new Symptom(
    LR.throatSore,
    L.throatSoreDescription,
    LR.throatSt
);
throatSore.setPrintName(L.throatSorePrintName);

// ------------- throatSpasm  -------------
Symptom throatSpasm = new Symptom(
    LR.throatSpasm,
    L.throatSpasmDescription,
    LR.throatSt
);
throatSpasm.setPrintName(L.throatSpasmPrintName);

// ------------- throatWhitePatches  -------------
Symptom throatWhitePatches = new Symptom(
    LR.throatWhitePatches,
    L.throatWhitePatchesDescription,
    LR.throatSt
);
throatWhitePatches.setPrintName(L.throatWhitePatchesPrintName);

// ------------- thyroidEnlargement  -------------
Symptom thyroidEnlargement = new Symptom(
    LR.thyroidEnlargement,
    L.thyroidEnlargementDescription,
    LR.skinSt
);
thyroidEnlargement.setPrintName(L.thyroidEnlargementPrintName);

// ------------- tickInSkin  -------------
Symptom tickInSkin = new Symptom(
    LR.tickInSkin,
    L.tickInSkinDescription,
    LR.skinSt
);
tickInSkin.setPrintName(L.tickInSkinPrintName);

// -------------- tingling --------------
// (C) OntoOO Inc Thu May 13 14:43:40 PDT 2004
Symptom tingling = new Symptom(
    LR.tingling,
    L.tinglingDescription,
    LR.skinSt
);
tingling.setPrintName(L.tinglingPrintName);

// ------------- tinnitus  -------------
Symptom tinnitus = new Symptom(
    LR.tinnitus,
    L.tinnitusDescription,
    LR.earsSt
);
tinnitus.setPrintName(L.tinnitusPrintName);

// ------------- toeNailCrumble  -------------
Symptom toeNailCrumble = new Symptom(
    LR.toeNailCrumble,
    L.toeNailCrumbleDescription,
    LR.toeNailsSt
);
toeNailCrumble.setPrintName(L.toeNailCrumblePrintName);

// ------------- toeNailDiscolor  -------------
Symptom toeNailDiscolor = new Symptom(
    LR.toeNailDiscolor,
    L.toeNailDiscolorDescription,
    LR.toeNailsSt
);
toeNailDiscolor.setPrintName(L.toeNailDiscolorPrintName);

// ------------- toeNailThicken  -------------
Symptom toeNailThicken = new Symptom(
    LR.toeNailThicken,
    L.toeNailThickenDescription,
    LR.toeNailsSt
);
toeNailThicken.setPrintName(L.toeNailThickenPrintName);
toeNailThicken.setCardinal();

// ------------- toesBetweenBlisters  -------------
Symptom toesBetweenBlisters = new Symptom(
    LR.toesBetweenBlisters,
    L.toesBetweenBlistersDescription,
    LR.toesSt
);
toesBetweenBlisters.setPrintName(L.toesBetweenBlistersPrintName);

// ------------- toesBetweenScaling  -------------
Symptom toesBetweenScaling = new Symptom(
    LR.toesBetweenScaling,
    L.toesBetweenScalingDescription,
    LR.toesSt
);
toesBetweenScaling.setPrintName(L.toesBetweenScalingPrintName);
toesBetweenScaling.setCardinal();

// ------------- toesNumbness  -------------
Symptom toesNumbness = new Symptom(
    LR.toesNumbness,
    L.toesNumbnessDescription,
    LR.toesSt
);
toesNumbness.setPrintName(L.toesNumbnessPrintName);

// ------------- toesTingling  -------------
Symptom toesTingling = new Symptom(
    LR.toesTingling,
    L.toesTinglingDescription,
    LR.toesSt
);
toesTingling.setPrintName(L.toesTinglingPrintName);

// ------------- tongueChancre  -------------
Symptom tongueChancre = new Symptom(
    LR.tongueChancre,
    L.tongueChancreDescription,
    LR.tongueSt
);
tongueChancre.setPrintName(L.tongueChancrePrintName);

// -------------- tongueCoating --------------
// (C) OntoOO Inc Thu Sep 02 13:06:20 GMT-08:00 2004
Symptom tongueCoating = new Symptom(
    LR.tongueCoating,
    L.tongueCoatingDescription,
    LR.tongueSt
);
tongueCoating.setPrintName(L.tongueCoatingPrintName);

// ------------- tonguePainful  -------------
Symptom tonguePainful = new Symptom(
    LR.tonguePainful,
    L.tonguePainfulDescription,
    LR.tongueSt
);
tonguePainful.setPrintName(L.tonguePainfulPrintName);

// ------------- tonguePale  -------------
Symptom tonguePale = new Symptom(
    LR.tonguePale,
    L.tonguePaleDescription,
    LR.tongueSt
);
tonguePale.setPrintName(L.tonguePalePrintName);

// ------------- tonguePapule  -------------
Symptom tonguePapule = new Symptom(
    LR.tonguePapule,
    L.tonguePapuleDescription,
    LR.tongueSt
);
tonguePapule.setPrintName(L.tonguePapulePrintName);

// ------------- tongueRed  -------------
Symptom tongueRed = new Symptom(
    LR.tongueRed,
    L.tongueRedDescription,
    LR.tongueSt
);
tongueRed.setPrintName(L.tongueRedPrintName);

// ------------- tongueSwollen  -------------
Symptom tongueSwollen = new Symptom(
    LR.tongueSwollen,
    L.tongueSwollenDescription,
    LR.tongueSt
);
tongueSwollen.setPrintName(L.tongueSwollenPrintName);

// ------------- tonsilChancre  -------------
Symptom tonsilChancre = new Symptom(
    LR.tonsilChancre,
    L.tonsilChancreDescription,
    LR.tonsilsSt
);
tonsilChancre.setPrintName(L.tonsilChancrePrintName);

// ------------- tonsilsExude  -------------
Symptom tonsilsExude = new Symptom(
    LR.tonsilsExude,
    L.tonsilsExudeDescription,
    LR.tonsilsSt
);
tonsilsExude.setPrintName(L.tonsilsExudePrintName);

// ------------- tonsilsSwollen  -------------
Symptom tonsilsSwollen = new Symptom(
    LR.tonsilsSwollen,
    L.tonsilsSwollenDescription,
    LR.tonsilsSt
);
tonsilsSwollen.setPrintName(L.tonsilsSwollenPrintName);

// ------------- trembling  -------------
Symptom trembling = new Symptom(
    LR.trembling,
    L.tremblingDescription,
    LR.bodySt
);
trembling.setPrintName(L.tremblingPrintName);

// ------------- tremors  -------------
Symptom tremors = new Symptom(
    LR.tremors,
    L.tremorsDescription,
    LR.bodySt
);
tremors.setPrintName(L.tremorsPrintName);

// ------------- twitching  -------------
Symptom twitching = new Symptom(
    LR.twitching,
    L.twitchingDescription,
    LR.bodySt
);
twitching.setPrintName(L.twitchingPrintName);

// ------------- ulcer  -------------
Symptom ulcer = new Symptom(
    LR.ulcer,
    L.ulcerDescription,
    LR.skinSt
);
ulcer.setPrintName(L.ulcerPrintName);

// ------------- ulcerBleedsEasily  -------------
Symptom ulcerBleedsEasily = new Symptom(
    LR.ulcerBleedsEasily,
    L.ulcerBleedsEasilyDescription,
    LR.skinSt
);
ulcerBleedsEasily.setPrintName(L.ulcerBleedsEasilyPrintName);

// ------------- ulcerGray  -------------
Symptom ulcerGray = new Symptom(
    LR.ulcerGray,
    L.ulcerGrayDescription,
    LR.skinSt
);
ulcerGray.setPrintName(L.ulcerGrayPrintName);

// ------------- ulcerMalodorous  -------------
Symptom ulcerMalodorous = new Symptom(
    LR.ulcerMalodorous,
    L.ulcerMalodorousDescription,
    LR.skinSt
);
ulcerMalodorous.setPrintName(L.ulcerMalodorousPrintName);

// ------------- ulcerPainful  -------------
Symptom ulcerPainful = new Symptom(
    LR.ulcerPainful,
    L.ulcerPainfulDescription,
    LR.skinSt
);
ulcerPainful.setPrintName(L.ulcerPainfulPrintName);

// ------------- ulcerShallow  -------------
Symptom ulcerShallow = new Symptom(
    LR.ulcerShallow,
    L.ulcerShallowDescription,
    LR.skinSt
);
ulcerShallow.setPrintName(L.ulcerShallowPrintName);

// ------------- ulcerSoft  -------------
Symptom ulcerSoft = new Symptom(
    LR.ulcerSoft,
    L.ulcerSoftDescription,
    LR.skinSt
);
ulcerSoft.setPrintName(L.ulcerSoftPrintName);

// ------------- unhappy  -------------
Symptom unhappy = new Symptom(
    LR.unhappy,
    L.unhappyDescription,
    LR.mindSt
);
unhappy.setPrintName(L.unhappyPrintName);

// ------------- unrealityFeeling  -------------
Symptom unrealityFeeling = new Symptom(
    LR.unrealityFeeling,
    L.unrealityFeelingDescription,
    LR.mindSt
);
unrealityFeeling.setPrintName(L.unrealityFeelingPrintName);

// ------------- uremicBreath  -------------
Symptom uremicBreath = new Symptom(
    LR.uremicBreath,
    L.uremicBreathDescription,
    LR.mouthSt
);
uremicBreath.setPrintName(L.uremicBreathPrintName);

// ------------- urethraFemaleDischargePurulent  -------------
Symptom urethraFemaleDischargePurulent = new Symptom(
    LR.urethraFemaleDischargePurulent,
    L.urethraFemaleDischargePurulentDescription,
    LR.urethralExitFMSt
);
urethraFemaleDischargePurulent.setPrintName(L.urethraFemaleDischargePurulentPrintName);

// ------------- urethraFemaleItching  -------------
Symptom urethraFemaleItching = new Symptom(
    LR.urethraFemaleItching,
    L.urethraFemaleItchingDescription,
    LR.urethralExitFMSt
);
urethraFemaleItching.setPrintName(L.urethraFemaleItchingPrintName);

// ------------- urethraFemaleRed  -------------
Symptom urethraFemaleRed = new Symptom(
    LR.urethraFemaleRed,
    L.urethraFemaleRedDescription,
    LR.urethralExitFMSt
);
urethraFemaleRed.setPrintName(L.urethraFemaleRedPrintName);

// ------------- urethraFemaleSwollen  -------------
Symptom urethraFemaleSwollen = new Symptom(
    LR.urethraFemaleSwollen,
    L.urethraFemaleSwollenDescription,
    LR.urethralExitFMSt
);
urethraFemaleSwollen.setPrintName(L.urethraFemaleSwollenPrintName);

// ------------- urethraMaleDischarge  -------------
Symptom urethraMaleDischarge = new Symptom(
    LR.urethraMaleDischarge,
    L.urethraMaleDischargeDescription,
    LR.urethralExitMLSt
);
urethraMaleDischarge.setPrintName(L.urethraMaleDischargePrintName);

// ------------- urethraMaleDischargePurulent  -------------
Symptom urethraMaleDischargePurulent = new Symptom(
    LR.urethraMaleDischargePurulent,
    L.urethraMaleDischargePurulentDescription,
    LR.urethralExitMLSt
);
urethraMaleDischargePurulent.setPrintName(L.urethraMaleDischargePurulentPrintName);

// ------------- urethraWarts  -------------
Symptom urethraWarts = new Symptom(
    LR.urethraWarts,
    L.urethraWartsDescription,
    LR.urethraMLSt
);
urethraWarts.setPrintName(L.urethraWartsPrintName);

// -------------- urinaryBurning --------------
// (C) OntoOO Inc Mon Aug 30 15:57:15 GMT-08:00 2004
Symptom urinaryBurning = new Symptom(
    LR.urinaryBurning,
    L.urinaryBurningDescription,
    LR.bladderSt
);
urinaryBurning.setPrintName(L.urinaryBurningPrintName);

// ------------- urinaryFrequency  -------------
Symptom urinaryFrequency = new Symptom(
    LR.urinaryFrequency,
    L.urinaryFrequencyDescription,
    LR.bladderSt
);
urinaryFrequency.setPrintName(L.urinaryFrequencyPrintName);

// ------------- urinaryHesitancy  -------------
Symptom urinaryHesitancy = new Symptom(
    LR.urinaryHesitancy,
    L.urinaryHesitancyDescription,
    LR.bladderSt
);
urinaryHesitancy.setPrintName(L.urinaryHesitancyPrintName);

// ------------- urinaryStreamInterrupted  -------------
Symptom urinaryStreamInterrupted = new Symptom(
    LR.urinaryStreamInterrupted,
    L.urinaryStreamInterruptedDescription,
    LR.bladderSt
);
urinaryStreamInterrupted.setPrintName(L.urinaryStreamInterruptedPrintName);

// ------------- urinaryStreamReduced  -------------
Symptom urinaryStreamReduced = new Symptom(
    LR.urinaryStreamReduced,
    L.urinaryStreamReducedDescription,
    LR.bladderSt
);
urinaryStreamReduced.setPrintName(L.urinaryStreamReducedPrintName);

// ------------- urinaryUrgency  -------------
Symptom urinaryUrgency = new Symptom(
    LR.urinaryUrgency,
    L.urinaryUrgencyDescription,
    LR.bladderSt
);
urinaryUrgency.setPrintName(L.urinaryUrgencyPrintName);

// ------------- urinationPainful  -------------
Symptom urinationPainful = new Symptom(
    LR.urinationPainful,
    L.urinationPainfulDescription,
    LR.bladderSt
);
urinationPainful.setPrintName(L.urinationPainfulPrintName);

// ------------- urinationStartDifficult  -------------
Symptom urinationStartDifficult = new Symptom(
    LR.urinationStartDifficult,
    L.urinationStartDifficultDescription,
    LR.bladderSt
);
urinationStartDifficult.setPrintName(L.urinationStartDifficultPrintName);

// ------------- urineCloudy  -------------
Symptom urineCloudy = new Symptom(
    LR.urineCloudy,
    L.urineCloudyDescription,
    LR.bladderSt
);
urineCloudy.setPrintName(L.urineCloudyPrintName);

// -------------- urineDark --------------
// (C) OntoOO Inc Tue Mar 08 13:38:20 PST 2005
Symptom urineDark = new Symptom(
    LR.urineDark,
    L.urineDarkDescription,
    LR.bladderSt
);
urineDark.setPrintName(L.urineDarkPrintName);

// ------------- urineDribbling  -------------
Symptom urineDribbling = new Symptom(
    LR.urineDribbling,
    L.urineDribblingDescription,
    LR.bladderSt
);
urineDribbling.setPrintName(L.urineDribblingPrintName);

// ------------- urineRetention  -------------
Symptom urineRetention = new Symptom(
    LR.urineRetention,
    L.urineRetentionDescription,
    LR.bladderSt
);
urineRetention.setPrintName(L.urineRetentionPrintName);

// ------------- urticaria  -------------
Symptom urticaria = new Symptom(
    LR.urticaria,
    L.urticariaDescription,
    LR.skinSt
);
urticaria.setPrintName(L.urticariaPrintName);

// ------------- uterusBleeding  -------------
Symptom uterusBleeding = new Symptom(
    LR.uterusBleeding,
    L.uterusBleedingDescription,
    LR.uterusSt
);
uterusBleeding.setPrintName(L.uterusBleedingPrintName);

// ------------- uterusBleedingAbnormal  -------------
Symptom uterusBleedingAbnormal = new Symptom(
    LR.uterusBleedingAbnormal,
    L.uterusBleedingAbnormalDescription,
    LR.uterusSt
);
uterusBleedingAbnormal.setPrintName(L.uterusBleedingAbnormalPrintName);

// ------------- uterusContractions  -------------
Symptom uterusContractions = new Symptom(
    LR.uterusContractions,
    L.uterusContractionsDescription,
    LR.uterusSt
);
uterusContractions.setPrintName(L.uterusContractionsPrintName);

// ------------- uterusEnlarged  -------------
Symptom uterusEnlarged = new Symptom(
    LR.uterusEnlarged,
    L.uterusEnlargedDescription,
    LR.uterusSt
);
uterusEnlarged.setPrintName(L.uterusEnlargedPrintName);

// ------------- uterusGrowsTooFast  -------------
Symptom uterusGrowsTooFast = new Symptom(
    LR.uterusGrowsTooFast,
    L.uterusGrowsTooFastDescription,
    LR.uterusSt
);
uterusGrowsTooFast.setPrintName(L.uterusGrowsTooFastPrintName);

// ------------- uterusIrritation  -------------
Symptom uterusIrritation = new Symptom(
    LR.uterusIrritation,
    L.uterusIrritationDescription,
    LR.uterusSt
);
uterusIrritation.setPrintName(L.uterusIrritationPrintName);

// ------------- uterusPain  -------------
Symptom uterusPain = new Symptom(
    LR.uterusPain,
    L.uterusPainDescription,
    LR.uterusSt
);
uterusPain.setPrintName(L.uterusPainPrintName);

// ------------- uterusTender  -------------
Symptom uterusTender = new Symptom(
    LR.uterusTender,
    L.uterusTenderDescription,
    LR.uterusSt
);
uterusTender.setPrintName(L.uterusTenderPrintName);

// ------------- vaginaBurning  -------------
Symptom vaginaBurning = new Symptom(
    LR.vaginaBurning,
    L.vaginaBurningDescription,
    LR.vaginaSt
);
vaginaBurning.setPrintName(L.vaginaBurningPrintName);

// ------------- vaginaDischarge  -------------
Symptom vaginaDischarge = new Symptom(
    LR.vaginaDischarge,
    L.vaginaDischargeDescription,
    LR.vaginaSt
);
vaginaDischarge.setPrintName(L.vaginaDischargePrintName);

// ------------- vaginaDischargeAmberColored  -------------
Symptom vaginaDischargeAmberColored = new Symptom(
    LR.vaginaDischargeAmberColored,
    L.vaginaDischargeAmberColoredDescription,
    LR.vaginaSt
);
vaginaDischargeAmberColored.setPrintName(L.vaginaDischargeAmberColoredPrintName);

// ------------- vaginaDischargeBloody  -------------
Symptom vaginaDischargeBloody = new Symptom(
    LR.vaginaDischargeBloody,
    L.vaginaDischargeBloodyDescription,
    LR.vaginaSt
);
vaginaDischargeBloody.setPrintName(L.vaginaDischargeBloodyPrintName);

// ------------- vaginaDischargeBrown  -------------
Symptom vaginaDischargeBrown = new Symptom(
    LR.vaginaDischargeBrown,
    L.vaginaDischargeBrownDescription,
    LR.vaginaSt
);
vaginaDischargeBrown.setPrintName(L.vaginaDischargeBrownPrintName);

// ------------- vaginaDischargeFoulSmelling  -------------
Symptom vaginaDischargeFoulSmelling = new Symptom(
    LR.vaginaDischargeFoulSmelling,
    L.vaginaDischargeFoulSmellingDescription,
    LR.vaginaSt
);
vaginaDischargeFoulSmelling.setPrintName(L.vaginaDischargeFoulSmellingPrintName);

// ------------- vaginaDischargeFrothy  -------------
Symptom vaginaDischargeFrothy = new Symptom(
    LR.vaginaDischargeFrothy,
    L.vaginaDischargeFrothyDescription,
    LR.vaginaSt
);
vaginaDischargeFrothy.setPrintName(L.vaginaDischargeFrothyPrintName);

// ------------- vaginaDischargeGrayFoulFishySmelling  -------------
Symptom vaginaDischargeGrayFoulFishySmelling = new Symptom(
    LR.vaginaDischargeGrayFoulFishySmelling,
    L.vaginaDischargeGrayFoulFishySmellingDescription,
    LR.vaginaSt
);
vaginaDischargeGrayFoulFishySmelling.setPrintName(L.vaginaDischargeGrayFoulFishySmellingPrintName);

// ------------- vaginaDischargePersistent  -------------
Symptom vaginaDischargePersistent = new Symptom(
    LR.vaginaDischargePersistent,
    L.vaginaDischargePersistentDescription,
    LR.vaginaSt
);
vaginaDischargePersistent.setPrintName(L.vaginaDischargePersistentPrintName);

// ------------- vaginaDischargePink  -------------
Symptom vaginaDischargePink = new Symptom(
    LR.vaginaDischargePink,
    L.vaginaDischargePinkDescription,
    LR.vaginaSt
);
vaginaDischargePink.setPrintName(L.vaginaDischargePinkPrintName);

// ------------- vaginaDischargeProfuse  -------------
Symptom vaginaDischargeProfuse = new Symptom(
    LR.vaginaDischargeProfuse,
    L.vaginaDischargeProfuseDescription,
    LR.vaginaSt
);
vaginaDischargeProfuse.setPrintName(L.vaginaDischargeProfusePrintName);

// ------------- vaginaDischargePurulent  -------------
Symptom vaginaDischargePurulent = new Symptom(
    LR.vaginaDischargePurulent,
    L.vaginaDischargePurulentDescription,
    LR.vaginaSt
);
vaginaDischargePurulent.setPrintName(L.vaginaDischargePurulentPrintName);

// ------------- vaginaDischargeThickWhite  -------------
Symptom vaginaDischargeThickWhite = new Symptom(
    LR.vaginaDischargeThickWhite,
    L.vaginaDischargeThickWhiteDescription,
    LR.vaginaSt
);
vaginaDischargeThickWhite.setPrintName(L.vaginaDischargeThickWhitePrintName);

// ------------- vaginaDischargeThinBubblyGreentingedMalodorous  -------------
Symptom vaginaDischargeThinBubblyGreentingedMalodorous = new Symptom(
    LR.vaginaDischargeThinBubblyGreentingedMalodorous,
    L.vaginaDischargeThinBubblyGreentingedMalodorousDescription,
    LR.vaginaSt
);
vaginaDischargeThinBubblyGreentingedMalodorous.setPrintName(L.vaginaDischargeThinBubblyGreentingedMalodorousPrintName);

// ------------- vaginaDryness  -------------
Symptom vaginaDryness = new Symptom(
    LR.vaginaDryness,
    L.vaginaDrynessDescription,
    LR.vaginaSt
);
vaginaDryness.setPrintName(L.vaginaDrynessPrintName);

// ------------- vaginaItching  -------------
Symptom vaginaItching = new Symptom(
    LR.vaginaItching,
    L.vaginaItchingDescription,
    LR.vaginaSt
);
vaginaItching.setPrintName(L.vaginaItchingPrintName);

// ------------- vaginaMucosaAtrophy  -------------
Symptom vaginaMucosaAtrophy = new Symptom(
    LR.vaginaMucosaAtrophy,
    L.vaginaMucosaAtrophyDescription,
    LR.vaginaSt
);
vaginaMucosaAtrophy.setPrintName(L.vaginaMucosaAtrophyPrintName);

// ------------- vaginaMuscleSpasm  -------------
Symptom vaginaMuscleSpasm = new Symptom(
    LR.vaginaMuscleSpasm,
    L.vaginaMuscleSpasmDescription,
    LR.vaginaSt
);
vaginaMuscleSpasm.setPrintName(L.vaginaMuscleSpasmPrintName);

// ------------- vaginaPain  -------------
Symptom vaginaPain = new Symptom(
    LR.vaginaPain,
    L.vaginaPainDescription,
    LR.vaginaSt
);
vaginaPain.setPrintName(L.vaginaPainPrintName);

// ------------- vaginaPapule  -------------
Symptom vaginaPapule = new Symptom(
    LR.vaginaPapule,
    L.vaginaPapuleDescription,
    LR.vaginaSt
);
vaginaPapule.setPrintName(L.vaginaPapulePrintName);

// ------------- vaginaRed  -------------
Symptom vaginaRed = new Symptom(
    LR.vaginaRed,
    L.vaginaRedDescription,
    LR.vaginaSt
);
vaginaRed.setPrintName(L.vaginaRedPrintName);

// ------------- vaginaSwollen  -------------
Symptom vaginaSwollen = new Symptom(
    LR.vaginaSwollen,
    L.vaginaSwollenDescription,
    LR.vaginaSt
);
vaginaSwollen.setPrintName(L.vaginaSwollenPrintName);

// ------------- vaginaTenderness  -------------
Symptom vaginaTenderness = new Symptom(
    LR.vaginaTenderness,
    L.vaginaTendernessDescription,
    LR.vaginaSt
);
vaginaTenderness.setPrintName(L.vaginaTendernessPrintName);

// ------------- vaginaUlceratedLesion  -------------
Symptom vaginaUlceratedLesion = new Symptom(
    LR.vaginaUlceratedLesion,
    L.vaginaUlceratedLesionDescription,
    LR.vaginaSt
);
vaginaUlceratedLesion.setPrintName(L.vaginaUlceratedLesionPrintName);

// ------------- vaginaVesicle  -------------
Symptom vaginaVesicle = new Symptom(
    LR.vaginaVesicle,
    L.vaginaVesicleDescription,
    LR.vaginaSt
);
vaginaVesicle.setPrintName(L.vaginaVesiclePrintName);

// ------------- vaginaWarts  -------------
Symptom vaginaWarts = new Symptom(
    LR.vaginaWarts,
    L.vaginaWartsDescription,
    LR.vaginaSt
);
vaginaWarts.setPrintName(L.vaginaWartsPrintName);

/* This is NOT symptom but a disease, which is covered by vulvovaginitis
// ------------- vaginitis  -------------
Symptom vaginitis = new Symptom(
    LR.vaginitis,
    L.vaginitisDescription,
    LR.vaginaSt
);
vaginitis.setPrintName(L.vaginitisPrintName);
*/

// ------------- vasodilation  -------------
Symptom vasodilation = new Symptom(
    LR.vasodilation,
    L.vasodilationDescription,
    LR.aVeinSt
);
vasodilation.setPrintName(L.vasodilationPrintName);

// ------------- veinHeat  -------------
Symptom veinHeat = new Symptom(
    LR.veinHeat,
    L.veinHeatDescription,
    LR.aVeinSt
);
veinHeat.setPrintName(L.veinHeatPrintName);

// ------------- veinPain  -------------
Symptom veinPain = new Symptom(
    LR.veinPain,
    L.veinPainDescription,
    LR.aVeinSt
);
veinPain.setPrintName(L.veinPainPrintName);

// ------------- veinSwelling  -------------
Symptom veinSwelling = new Symptom(
    LR.veinSwelling,
    L.veinSwellingDescription,
    LR.aVeinSt
);
veinSwelling.setPrintName(L.veinSwellingPrintName);

// ------------- veinTender  -------------
Symptom veinTender = new Symptom(
    LR.veinTender,
    L.veinTenderDescription,
    LR.aVeinSt
);
veinTender.setPrintName(L.veinTenderPrintName);

// ------------- ventricularFibrillation  -------------
Symptom ventricularFibrillation = new Symptom(
    LR.ventricularFibrillation,
    L.ventricularFibrillationDescription,
    LR.heartSt
);
ventricularFibrillation.setPrintName(L.ventricularFibrillationPrintName);

// ------------- vertigo  -------------
Symptom vertigo = new Symptom(
    LR.vertigo,
    L.vertigoDescription,
    LR.mindSt
);
vertigo.setPrintName(L.vertigoPrintName);

// ------------- vesicle  -------------
Symptom vesicle = new Symptom(
    LR.vesicle,
    L.vesicleDescription,
    LR.skinSt
);
vesicle.setPrintName(L.vesiclePrintName);

// ------------- vesicleCheek  -------------
Symptom vesicleCheek = new Symptom(
    LR.vesicleCheek,
    L.vesicleCheekDescription,
    LR.cheeksSt
);
vesicleCheek.setPrintName(L.vesicleCheekPrintName);

// ------------- vesicleMouth  -------------
Symptom vesicleMouth = new Symptom(
    LR.vesicleMouth,
    L.vesicleMouthDescription,
    LR.mouthSt
);
vesicleMouth.setPrintName(L.vesicleMouthPrintName);
vesicleMouth.setCardinal();

// ------------- visionBlurred  -------------
Symptom visionBlurred = new Symptom(
    LR.visionBlurred,
    L.visionBlurredDescription,
    LR.mindSt
);
visionBlurred.setPrintName(L.visionBlurredPrintName);

// ------------- visionDefect  -------------
Symptom visionDefect = new Symptom(
    LR.visionDefect,
    L.visionDefectDescription,
    LR.eyesSt
);
visionDefect.setPrintName(L.visionDefectPrintName);

// -------------- visionLoss --------------
// (C) OntoOO Inc Fri Mar 12 15:58:56 PST 2004
Symptom visionLoss = new Symptom(
    LR.visionLoss,
    L.visionLossDescription,
    LR.eyesSt
);
visionLoss.setPrintName(L.visionLossPrintName);

// ------------- visionDisturbance  -------------
/*
Symptom visionDisturbance = new Symptom(
    LR.visionDisturbance,
    L.visionDisturbanceDescription,
    LR.mindSt
);
visionDisturbance.setPrintName(L.visionDisturbancePrintName);
*/

// ------------- visionNightLoss  -------------
Symptom visionNightLoss = new Symptom(
    LR.visionNightLoss,
    L.visionNightLossDescription,
    LR.eyesSt
);
visionNightLoss.setPrintName(L.visionNightLossPrintName);

// ------------- visionPeripheralLoss  -------------
Symptom visionPeripheralLoss = new Symptom(
    LR.visionPeripheralLoss,
    L.visionPeripheralLossDescription,
    LR.eyesSt
);
visionPeripheralLoss.setPrintName(L.visionPeripheralLossPrintName);

// ------------- voiceDeepened  -------------
Symptom voiceDeepened = new Symptom(
    LR.voiceDeepened,
    L.voiceDeepenedDescription,
    LR.bodySt
);
voiceDeepened.setPrintName(L.voiceDeepenedPrintName);

// -------------- vomitBile --------------
// (C) OntoOO Inc Tue Apr 24 11:02:25 PDT 2007
Symptom vomitBile = new Symptom(
    LR.vomitBile,
    L.vomitBileDescription,
    LR.mouthSt
);
vomitBile.setPrintName(L.vomitBilePrintName);
vomitBile.setCardinal();

// ------------- vomitBlack  -------------
Symptom vomitBlack = new Symptom(
    LR.vomitBlack,
    L.vomitBlackDescription,
    LR.mouthSt
);
vomitBlack.setPrintName(L.vomitBlackPrintName);

// ------------- vomitBloody  -------------
Symptom vomitBloody = new Symptom(
    LR.vomitBloody,
    L.vomitBloodyDescription,
    LR.mouthSt
);
vomitBloody.setPrintName(L.vomitBloodyPrintName);

// ------------- vomiting  -------------
Symptom vomiting = new Symptom(
    LR.vomiting,
    L.vomitingDescription,
    LR.mouthSt
);
vomiting.setPrintName(L.vomitingPrintName);

// ------------- vulvaBurning  -------------
Symptom vulvaBurning = new Symptom(
    LR.vulvaBurning,
    L.vulvaBurningDescription,
    LR.vulvaSt
);
vulvaBurning.setPrintName(L.vulvaBurningPrintName);

// ------------- vulvaItching  -------------
Symptom vulvaItching = new Symptom(
    LR.vulvaItching,
    L.vulvaItchingDescription,
    LR.vulvaSt
);
vulvaItching.setPrintName(L.vulvaItchingPrintName);

// ------------- vulvaLesion  -------------
Symptom vulvaLesion = new Symptom(
    LR.vulvaLesion,
    L.vulvaLesionDescription,
    LR.vulvaSt
);
vulvaLesion.setPrintName(L.vulvaLesionPrintName);

// ------------- vulvaPain  -------------
Symptom vulvaPain = new Symptom(
    LR.vulvaPain,
    L.vulvaPainDescription,
    LR.vulvaSt
);
vulvaPain.setPrintName(L.vulvaPainPrintName);

// ------------- vulvaPapule  -------------
Symptom vulvaPapule = new Symptom(
    LR.vulvaPapule,
    L.vulvaPapuleDescription,
    LR.vulvaSt
);
vulvaPapule.setPrintName(L.vulvaPapulePrintName);

// ------------- vulvaRedSwollen  -------------
Symptom vulvaRedSwollen = new Symptom(
    LR.vulvaRedSwollen,
    L.vulvaRedSwollenDescription,
    LR.vulvaSt
);
vulvaRedSwollen.setPrintName(L.vulvaRedSwollenPrintName);

// ------------- vulvaUlcer  -------------
Symptom vulvaUlcer = new Symptom(
    LR.vulvaUlcer,
    L.vulvaUlcerDescription,
    LR.vulvaSt
);
vulvaUlcer.setPrintName(L.vulvaUlcerPrintName);

// ------------- vulvaUlcerInfected  -------------
Symptom vulvaUlcerInfected = new Symptom(
    LR.vulvaUlcerInfected,
    L.vulvaUlcerInfectedDescription,
    LR.vulvaSt
);
vulvaUlcerInfected.setPrintName(L.vulvaUlcerInfectedPrintName);

// ------------- vulvaVesicle  -------------
Symptom vulvaVesicle = new Symptom(
    LR.vulvaVesicle,
    L.vulvaVesicleDescription,
    LR.vulvaSt
);
vulvaVesicle.setPrintName(L.vulvaVesiclePrintName);

// ------------- vulvaWarts  -------------
Symptom vulvaWarts = new Symptom(
    LR.vulvaWarts,
    L.vulvaWartsDescription,
    LR.vulvaSt
);
vulvaWarts.setPrintName(L.vulvaWartsPrintName);

// -------------- waddle --------------
// (C) OntoOO Inc Wed Aug 11 14:11:28 GMT-08:00 2004
Symptom waddle = new Symptom(
    LR.waddle,
    L.waddleDescription,
    LR.bodySt
);
waddle.setPrintName(L.waddlePrintName);

// ------------- waistlineLesion  -------------
Symptom waistlineLesion = new Symptom(
    LR.waistlineLesion,
    L.waistlineLesionDescription,
    LR.torsoSt
);
waistlineLesion.setPrintName(L.waistlineLesionPrintName);

// ------------- walkingTrouble  -------------
Symptom walkingTrouble = new Symptom(
    LR.walkingTrouble,
    L.walkingTroubleDescription,
    LR.legsSt
);
walkingTrouble.setPrintName(L.walkingTroublePrintName);

// ------------- weakness  -------------
Symptom weakness = new Symptom(
    LR.weakness,
    L.weaknessDescription,
    LR.bodySt
);
weakness.setPrintName(L.weaknessPrintName);

// ------------- weightGain  -------------
Symptom weightGain = new Symptom(
    LR.weightGain,
    L.weightGainDescription,
    LR.bodySt
);
weightGain.setPrintName(L.weightGainPrintName);

// ------------- weightGainExcessive  -------------
Symptom weightGainExcessive = new Symptom(
    LR.weightGainExcessive,
    L.weightGainExcessiveDescription,
    LR.bodySt
);
weightGainExcessive.setPrintName(L.weightGainExcessivePrintName);

// ------------- weightLoss  -------------
Symptom weightLoss = new Symptom(
    LR.weightLoss,
    L.weightLossDescription,
    LR.bodySt
);
weightLoss.setPrintName(L.weightLossPrintName);
weightLoss.setCardinal();

// ------------- wheals  -------------
Symptom wheals = new Symptom(
    LR.wheals,
    L.whealsDescription,
    LR.skinSt
);
wheals.setPrintName(L.whealsPrintName);

// ------------- wheezing  -------------
Symptom wheezing = new Symptom(
    LR.wheezing,
    L.wheezingDescription,
    LR.lungsSt
);
wheezing.setPrintName(L.wheezingPrintName);

// -------------- whoopInhalation --------------
// (C) OntoOO Inc Wed Sep 08 14:02:31 GMT-08:00 2004
Symptom whoopInhalation = new Symptom(
    LR.whoopInhalation,
    L.whoopInhalationDescription,
    LR.throatSt
);
whoopInhalation.setPrintName(L.whoopInhalationPrintName);

// ------------- woundPainful  -------------
Symptom woundPainful = new Symptom(
    LR.woundPainful,
    L.woundPainfulDescription,
    LR.bodySt
);
woundPainful.setPrintName(L.woundPainfulPrintName);

// ------------- wristLesion  -------------
Symptom wristLesion = new Symptom(
    LR.wristLesion,
    L.wristLesionDescription,
    LR.wristsSt
);
wristLesion.setPrintName(L.wristLesionPrintName);

// ------------- yawning  -------------
Symptom yawning = new Symptom(
    LR.yawning,
    L.yawningDescription,
    LR.mouthSt
);
yawning.setPrintName(L.yawningPrintName);

  } // end of doit

} // end of InitSymptoms

