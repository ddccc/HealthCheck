// (C) OntoOO Dennis de Champeaux 2000, 2012
package init;

import com.Common;
import com.LR;
import concepts.XWordNormal;
import concepts.XWordPolish;
import concepts.DiseaseSet;

public class InitSynonyms {
  public static void doit() {
 
    String ADHD = LR.ADHD;
    Common.addXWord(ADHD, "synonym");
    XWordNormal ADHDx = (XWordNormal) Common.getXWord(ADHD);
    ADHDx.setSynonym(LR.attentionDeficitHyperactivityDisorder);
    Common.addDiseaseForShow(ADHD);

    String AIDS = LR.AIDS;
    Common.addXWord(AIDS, "synonym");
    XWordNormal AIDSx = (XWordNormal) Common.getXWord(AIDS);
    AIDSx.setSynonym(LR.acquiredImmunoDeficiencySyndrome);
    Common.addDiseaseForShow(AIDS);

    String aids = LR.aids;
    Common.addXWord(aids, "synonym");
    XWordNormal aidsx = (XWordNormal) Common.getXWord(aids);
    aidsx.setSynonym(LR.acquiredImmunoDeficiencySyndrome);
    Common.addDiseaseForShow(aids);

    String ALS = LR.ALS;
    Common.addXWord(ALS, "synonym");
    XWordNormal ALSx = (XWordNormal) Common.getXWord(ALS);
    ALSx.setSynonym(LR.amyotropicLateralSclerosis);
    Common.addDiseaseForShow(ALS);

    String anal = LR.anal;
    Common.addXWord(anal, "synonym");
    XWordNormal analx = (XWordNormal) Common.getXWord(anal);
    analx.setSynonym(LR.anusSt);

    String anxious = LR.anxious;
    Common.addXWord(anxious, "synonym");
    XWordNormal anxiousx = (XWordNormal) Common.getXWord(anxious);
    anxiousx.setSynonym(LR.anxiety);

    String ARDS = LR.ARDS;
    Common.addXWord(ARDS, "synonym");
    XWordNormal ARDSx = (XWordNormal) Common.getXWord(ARDS);
    ARDSx.setSynonym(LR.adultRespiratoryDistressSyndrome);
    Common.addDiseaseForShow(ARDS);

    String ASD = LR.ASD;
    Common.addXWord(ASD, "synonym");
    XWordNormal ASDx = (XWordNormal) Common.getXWord(ASD);
    ASDx.setSynonym(LR.atrialSeptalDefect);
    Common.addDiseaseForShow(ASD);

    String athleteFoot = LR.athleteFoot;
    Common.addXWord(athleteFoot, "synonym");
    XWordPolish athleteFootx = (XWordPolish) Common.getXWord(athleteFoot);
    athleteFootx.setSynonym(LR.tineaPedis);
    Common.addDiseaseForShow(athleteFoot);

    String avianFlu = LR.avianFlu;
    Common.addXWord(avianFlu, "synonym");
    XWordPolish avianFlux = (XWordPolish) Common.getXWord(avianFlu);
    avianFlux.setSynonym(LR.h5n1);
    Common.addDiseaseForShow(avianFlu);

    String balls = LR.balls;
    Common.addXWord(balls, "synonym");
    XWordNormal ballsx = (XWordNormal) Common.getXWord(balls);
    ballsx.setSynonym(LR.testes);

    String BasedowDisease = LR.BasedowDisease;
    Common.addXWord(BasedowDisease, "synonym");
    XWordPolish BasedowDiseasex = (XWordPolish) Common.getXWord(BasedowDisease);
    BasedowDiseasex.setSynonym(LR.hyperthyroidism);
    Common.addDiseaseForShow(BasedowDisease);

    String bilharziasis = LR.bilharziasis;
    Common.addXWord(bilharziasis, "synonym");
    XWordNormal bilharziasisx = (XWordNormal) Common.getXWord(bilharziasis);
    bilharziasisx.setSynonym(LR.schistosomiasis);
    Common.addDiseaseForShow(bilharziasis);

    String birdFlu = LR.birdFlu;
    Common.addXWord(birdFlu, "synonym");
    XWordPolish birdFlux = (XWordPolish) Common.getXWord(birdFlu);
    birdFlux.setSynonym(LR.h5n1);
    Common.addDiseaseForShow(birdFlu);

    String bladderInfection = LR.bladderInfection;
    Common.addXWord(bladderInfection, "synonym");
    XWordPolish bladderInfectionx = (XWordPolish) Common.getXWord(bladderInfection);
    bladderInfectionx.setSynonym(LR.cystitis);
    Common.addDiseaseForShow(bladderInfection);

    String BOOP = LR.BOOP;
    Common.addXWord(BOOP, "synonym");
    XWordNormal BOOPx = (XWordNormal) Common.getXWord(BOOP);
    BOOPx.setSynonym(LR.bronchiolitisObliteransWithPneumonia);
    Common.addDiseaseForShow(BOOP);

    String breakingWater = LR.breakingWater;
    Common.addXWord(breakingWater, "synonym");
    XWordPolish breakingWaterx = (XWordPolish) Common.getXWord(breakingWater);
    breakingWaterx.setSynonym(LR.amnioticMembraneRupture);

    String candidosis = LR.candidosis;
    Common.addXWord(candidosis, "synonym");
    XWordNormal candidosisx = (XWordNormal) Common.getXWord(candidosis);
    candidosisx.setSynonym(LR.candidiasis);
    Common.addDiseaseForShow(candidosis);

    String colic = LR.colic;
    Common.addXWord(colic, "synonym");
    XWordNormal colicx = (XWordNormal) Common.getXWord(colic);
    colicx.setSynonym(LR.abdomenPainSuddenSevere);

    String COPD = LR.COPD;
    Common.addXWord(COPD, "synonym");
    XWordNormal COPDx = (XWordNormal) Common.getXWord(COPD);
    COPDx.setSynonym(LR.chronicObstructivePulmonaryDisease);
    Common.addDiseaseForShow(COPD);

    String coughing = LR.coughing;
    Common.addXWord(coughing, "synonym");
    XWordNormal coughingx = (XWordNormal) Common.getXWord(coughing);
    coughingx.setSynonym(LR.cough);

    String cunt = LR.cunt;
    Common.addXWord(cunt, "synonym");
    XWordNormal cuntx = (XWordNormal) Common.getXWord(cunt);
    cuntx.setSynonym(LR.vaginaSt);

    String diabetic = LR.diabetic;
    Common.addXWord(diabetic, "synonym");
    XWordNormal diabeticx = (XWordNormal) Common.getXWord(diabetic);
    diabeticx.setSynonym(LR.diabetes);
    Common.addDiseaseForShow(diabetic);

    String DIC = LR.DIC;
    Common.addXWord(DIC, "synonym");
    XWordNormal DICx = (XWordNormal) Common.getXWord(DIC);
    DICx.setSynonym(LR.disseminatedIntravascularCoagulation);

    String earInfection = LR.earInfection;
    Common.addXWord(earInfection, "synonym");
    XWordPolish earInfectionx = (XWordPolish) Common.getXWord(earInfection);
    earInfectionx.setSynonym(LR.otitisMedia);
    Common.addDiseaseForShow(earInfection);

    String foodPoisoning = LR.foodPoisoning;
    Common.addXWord(foodPoisoning, "synonym");
    XWordPolish foodPoisoningx = (XWordPolish) Common.getXWord(foodPoisoning);
    foodPoisoningx.setSynonym(LR.gastroenteritis);
    Common.addDiseaseForShow(foodPoisoning);

    String fuck = LR.fuck;
    Common.addXWord(fuck, "synonym");
    XWordNormal fuckx = (XWordNormal) Common.getXWord(fuck);
    fuckx.setSynonym(LR.intercourse); // introduced by intercourseDiscomfort

    String gallstones = LR.gallstones;
    Common.addXWord(gallstones, "synonym");
    XWordNormal gallstonesx = (XWordNormal) Common.getXWord(gallstones);
    gallstonesx.setSynonym(LR.cholelithiasis);
    Common.addDiseaseForShow(gallstones);

    String gastric = LR.gastric;
    Common.addXWord(gastric, "synonym");
    XWordNormal gastricx = (XWordNormal) Common.getXWord(gastric);
    gastricx.setSynonym(LR.stomachSt); 

    String germanMeasles = LR.germanMeasles;
    Common.addXWord(germanMeasles, "synonym");
    XWordPolish germanMeaslesx = (XWordPolish) Common.getXWord(germanMeasles);
    germanMeaslesx.setSynonym(LR.rubella);
    Common.addDiseaseForShow(germanMeasles);

    String GravesDisease = LR.GravesDisease;
    Common.addXWord(GravesDisease, "synonym");
    XWordPolish GravesDiseasex = (XWordPolish) Common.getXWord(GravesDisease);
    GravesDiseasex.setSynonym(LR.hyperthyroidism);
    Common.addDiseaseForShow(GravesDisease);

    String H5N1 = LR.H5N1;
    Common.addXWord(H5N1, "synonym");
    XWordNormal H5N1x = (XWordNormal) Common.getXWord(H5N1);
    H5N1x.setSynonym(LR.h5n1);
    Common.addDiseaseForShow(H5N1);

    String heartAttack = LR.heartAttack;
    Common.addXWord(heartAttack, "synonym");
    XWordPolish heartAttackx = (XWordPolish) Common.getXWord(heartAttack);
    heartAttackx.setSynonym(LR.myocardialInfarction);
    Common.addDiseaseForShow(heartAttack);

    String highBloodPressure = LR.highBloodPressure;
    Common.addXWord(highBloodPressure, "synonym");
    XWordPolish highBloodPressurex = (XWordPolish) Common.getXWord(highBloodPressure);
    highBloodPressurex.setSynonym(LR.hypertension);
    Common.addDiseaseForShow(highBloodPressure);

    String hives = LR.hives;
    Common.addXWord(hives, "synonym");
    XWordNormal hivesx = (XWordNormal) Common.getXWord(hives);
    hivesx.setSynonym(LR.urticaria); 

    String hyperprolactinemia = LR.hyperprolactinemia;
    Common.addXWord(hyperprolactinemia, "synonym");
    XWordNormal hyperprolactinemiax = (XWordNormal) Common.getXWord(hyperprolactinemia);
    hyperprolactinemiax.setSynonym(LR.galactorrhea);
    Common.addDiseaseForShow(hyperprolactinemia);

    String impotent = LR.impotent;
    Common.addXWord(impotent, "synonym");
    XWordNormal impotentx = (XWordNormal) Common.getXWord(impotent);
    impotentx.setSynonym(LR.erectionDisorder);
    Common.addDiseaseForShow(impotent);

    String insomnia = LR.insomnia;
    Common.addXWord(insomnia, "synonym");
    XWordNormal insomniax = (XWordNormal) Common.getXWord(insomnia);
    insomniax.setSynonym(LR.sleepDisturbed);

    String interstitialLungDisease = LR.interstitialLungDisease;
    Common.addXWord(interstitialLungDisease, "synonym");
    XWordPolish interstitialLungDiseasex = (XWordPolish) Common.getXWord(interstitialLungDisease);
    interstitialLungDiseasex.setSynonym(LR.idiopathicPulmonaryFibrosis);
    Common.addDiseaseForShow(interstitialLungDisease);

    String intracranialAneurysm = LR.intracranialAneurysm;
    Common.addXWord(intracranialAneurysm, "synonym");
    XWordPolish intracranialAneurysmx = (XWordPolish) Common.getXWord(intracranialAneurysm);
    intracranialAneurysmx.setSynonym(LR.cerebralAneurysm);
    Common.addDiseaseForShow(intracranialAneurysm);

    String ITP = LR.ITP;
    Common.addXWord(ITP, "synonym");
    XWordNormal ITPx = (XWordNormal) Common.getXWord(ITP);
    ITPx.setSynonym(LR.idiopathicThrombocytopenicPurpura);
    Common.addDiseaseForShow(ITP);

    String jockItch = LR.jockItch;
    Common.addXWord(jockItch, "synonym");
    XWordPolish jockItchx = (XWordPolish) Common.getXWord(jockItch);
    jockItchx.setSynonym(LR.tineaCruris);
    Common.addDiseaseForShow(jockItch);

    String kidneyStone = LR.kidneyStone;
    Common.addXWord(kidneyStone, "synonym");
    XWordPolish kidneyStonex = (XWordPolish) Common.getXWord(kidneyStone);
    kidneyStonex.setSynonym(LR.renalCalculi);
    Common.addDiseaseForShow(kidneyStone);

    String lice = LR.lice; // is also an external condition
    Common.addXWord(lice, "synonym");
    XWordNormal licex = (XWordNormal) Common.getXWord(lice);
    licex.setSynonym(LR.pediculosis);
    Common.addDiseaseForShow(lice);

    String lowBloodPressure = LR.lowBloodPressure;
    Common.addXWord(lowBloodPressure, "synonym");
    XWordPolish lowBloodPressurex = (XWordPolish) Common.getXWord(lowBloodPressure);
    lowBloodPressurex.setSynonym(LR.hypotension);

    String maternalHypertension = LR.maternalHypertension;
    Common.addXWord(maternalHypertension, "synonym");
    XWordPolish maternalHypertensionx = 
      (XWordPolish)Common.getXWord(maternalHypertension);
    maternalHypertensionx.setSynonym(LR.pregnancyInducedHypertension);
    Common.addDiseaseForShow(maternalHypertension);

    String melanoma = LR.melanoma; 
    Common.addXWord(melanoma, "synonym");
    XWordNormal melanomax = (XWordNormal) Common.getXWord(melanoma);
    melanomax.setSynonym(LR.malignantMelanoma);
    Common.addDiseaseForShow(melanoma);

    String migraine = LR.migraine;
    Common.addXWord(migraine, "synonym");
    XWordNormal migrainex = (XWordNormal) Common.getXWord(migraine);
    migrainex.setSynonym(LR.chronicHeadache);

    String moniliasis = LR.moniliasis;
    Common.addXWord(moniliasis, "synonym");
    XWordNormal moniliasisx = (XWordNormal) Common.getXWord(moniliasis);
    moniliasisx.setSynonym(LR.candidiasis);
    Common.addDiseaseForShow(moniliasis);

    String mononucleosis = LR.mononucleosis;
    Common.addXWord(mononucleosis, "synonym");
    XWordNormal mononucleosisx = (XWordNormal) Common.getXWord(mononucleosis);
    mononucleosisx.setSynonym(LR.epsteinBarrDisease);
    Common.addDiseaseForShow(mononucleosis);
 
    String nasal = LR.nasal;
    Common.addXWord(nasal, "synonym");
    XWordNormal nasalx = (XWordNormal) Common.getXWord(nasal);
    nasalx.setSynonym(LR.noseSt);

    String NEC = LR.NEC;
    Common.addXWord(NEC, "synonym");
    XWordNormal NECx = (XWordNormal) Common.getXWord(NEC);
    NECx.setSynonym(LR.necrotizingEnterocolitis);
    Common.addDiseaseForShow(NEC);

    String odynophagia = LR.odynophagia;
    Common.addXWord(odynophagia, "synonym");
    XWordNormal odynophagiax = (XWordNormal) Common.getXWord(odynophagia);
    odynophagiax.setSynonym(LR.swallowingPainful);

    String pelvisCellulitis = LR.pelvisCellulitis;
    Common.addXWord(pelvisCellulitis, "synonym");
    XWordPolish pelvisCellulitisx = (XWordPolish) Common.getXWord(pelvisCellulitis);
    pelvisCellulitisx.setSynonym(LR.parametritis);
    Common.addDiseaseForShow(pelvisCellulitis);

    String pertussis = LR.pertussis;
    Common.addXWord(pertussis, "synonym");
    XWordNormal pertussisx = (XWordNormal) Common.getXWord(pertussis);
    pertussisx.setSynonym(LR.whoopingCough);
    Common.addDiseaseForShow(pertussis);

    String PID = LR.PID;
    Common.addXWord(PID, "synonym");
    XWordNormal PIDx = (XWordNormal) Common.getXWord(PID);
    PIDx.setSynonym(LR.pelvisInflammatoryDisease);
    Common.addDiseaseForShow(PID);

    String pinkEye = LR.pinkEye;
    Common.addXWord(pinkEye, "synonym");
    XWordPolish pinkEyex = (XWordPolish) Common.getXWord(pinkEye);
    pinkEyex.setSynonym(LR.conjunctivitis);
    Common.addDiseaseForShow(pinkEye);

    String piss = LR.piss;
    Common.addXWord(piss, "synonym");
    XWordNormal pissx = (XWordNormal) Common.getXWord(piss);
    pissx.setSynonym(LR.urinary); // introduced elsewhere

    String PMS = LR.PMS;
    Common.addXWord(PMS, "synonym");
    XWordNormal PMSx = (XWordNormal) Common.getXWord(PMS);
    PMSx.setSynonym(LR.pelvisInflammatoryDisease);
    Common.addDiseaseForShow(PMS);

    String poop = LR.poop;
    Common.addXWord(poop, "synonym");
    XWordNormal poopx = (XWordNormal) Common.getXWord(poop);
    poopx.setSynonym(LR.stool);

    String PROM = LR.PROM;
    Common.addXWord(PROM, "synonym");
    XWordNormal PROMx = (XWordNormal) Common.getXWord(PROM);
    PROMx.setSynonym(LR.prematureRuptureOfTheMembranes);
    Common.addDiseaseForShow(PROM);

    String pseudodiphtheria = LR.pseudodiphtheria;
    Common.addXWord(pseudodiphtheria, "synonym");
    XWordNormal pseudodiphtheriax = (XWordNormal) Common.getXWord(pseudodiphtheria);
    pseudodiphtheriax.setSynonym(LR.epsteinBarrDisease);
    Common.addDiseaseForShow(pseudodiphtheria);

    String RDS = LR.RDS;
    Common.addXWord(RDS, "synonym");
    XWordNormal RDSx = (XWordNormal) Common.getXWord(RDS);
    RDSx.setSynonym(LR.respiratoryDistressSyndrome);
    Common.addDiseaseForShow(RDS);

    String regurgitation = LR.regurgitation;
    Common.addXWord(regurgitation, "synonym");
    XWordNormal regurgitationx = (XWordNormal) Common.getXWord(regurgitation);
    regurgitationx.setSynonym(LR.vomiting);

    String renalCancer = LR.renalCancer;
    Common.addXWord(renalCancer, "synonym");
    XWordPolish renalCancerx = (XWordPolish) Common.getXWord(renalCancer);
    renalCancerx.setSynonym(LR.kidneyCancer);
    Common.addDiseaseForShow(renalCancer);

    String rhinorrhea = LR.rhinorrhea;
    Common.addXWord(rhinorrhea, "synonym");
    XWordNormal rhinorrheax = (XWordNormal) Common.getXWord(rhinorrhea);
    rhinorrheax.setSynonym(LR.noseDischarge);

    String runnyNose = LR.runnyNose;
    Common.addXWord(runnyNose, "synonym");
    XWordPolish runnyNosex = (XWordPolish) Common.getXWord(runnyNose);
    runnyNosex.setSynonym(LR.noseDischarge);

    String salpingitis = LR.salpingitis;
    Common.addXWord(salpingitis, "synonym");
    XWordNormal salpingitisx = (XWordNormal) Common.getXWord(salpingitis);
    salpingitisx.setSynonym(LR.salpingoOophoritis);
    Common.addDiseaseForShow(salpingitis);

    String SARS = LR.SARS;
    Common.addXWord(SARS, "synonym");
    XWordNormal SARSx = (XWordNormal) Common.getXWord(SARS);
    SARSx.setSynonym(LR.severeAcuteRespiratorySyndrome);
    Common.addDiseaseForShow(SARS);

    String sars = LR.sars;
    Common.addXWord(sars, "synonym");
    XWordNormal sarsx = (XWordNormal) Common.getXWord(sars);
    sarsx.setSynonym(LR.severeAcuteRespiratorySyndrome);
    Common.addDiseaseForShow(sars);

    String scarlatina = LR.scarlatina;
    Common.addXWord(scarlatina, "synonym");
    XWordNormal scarlatinax = (XWordNormal) Common.getXWord(scarlatina);
    scarlatinax.setSynonym(LR.scarletFever);
    Common.addDiseaseForShow(scarlatina);

    String scurvy = LR.scurvy;
    Common.addXWord(scurvy, "synonym");
    XWordNormal scurvyx = (XWordNormal) Common.getXWord(scurvy);
    scurvyx.setSynonym(LR.vitaminCDeficiency);
    Common.addDiseaseForShow(scurvy);

    String seizures = LR.seizures;
    Common.addXWord(seizures, "synonym");
    XWordNormal seizuresx = (XWordNormal) Common.getXWord(seizures);
    seizuresx.setSynonym(LR.seizure);

    String shingles = LR.shingles;
    Common.addXWord(shingles, "synonym");
    XWordNormal shinglesx = (XWordNormal) Common.getXWord(shingles);
    shinglesx.setSynonym(LR.herpesZoster);
    Common.addDiseaseForShow(shingles);

    String shortOfBreath = LR.shortOfBreath;
    Common.addXWord(shortOfBreath, "synonym");
    XWordPolish shortOfBreathx = (XWordPolish) Common.getXWord(shortOfBreath);
    shortOfBreathx.setSynonym(LR.dyspnea);

    String SIADH = LR.SIADH;
    Common.addXWord(SIADH, "synonym");
    XWordNormal SIADHx = (XWordNormal) Common.getXWord(SIADH);
    SIADHx.setSynonym(LR.syndromeOfInappropriateAntidiureticHormoneSecretion);
    Common.addDiseaseForShow(SIADH);

    String skinYellow = LR.skinYellow;
    Common.addXWord(skinYellow, "synonym");
    XWordPolish skinYellowx = (XWordPolish) Common.getXWord(skinYellow);
    skinYellowx.setSynonym(LR.jaundice);

    String sternum = LR.sternum;
    Common.addXWord(sternum, "synonym");
    XWordNormal sternumx = (XWordNormal) Common.getXWord(sternum);
    sternumx.setSynonym(LR.breastBoneSt);

    String strepThroat = LR.strepThroat;
    Common.addXWord(strepThroat, "synonym");
    XWordPolish strepThroatx = (XWordPolish) Common.getXWord(strepThroat);
    strepThroatx.setSynonym(LR.pharyngitisStreptococcal);
    Common.addDiseaseForShow(strepThroat);

    String stroke = LR.stroke;
    Common.addXWord(stroke, "synonym");
    XWordNormal strokex = (XWordNormal) Common.getXWord(stroke);
    strokex.setSynonym(LR.cerebrovascularAccident);
    Common.addDiseaseForShow(stroke);

    String swelling = LR.swelling;
    Common.addXWord(swelling, "synonym");
    XWordNormal swellingx = (XWordNormal) Common.getXWord(swelling);
    swellingx.setSynonym(LR.edema);

    String swollen = LR.swollen;
    Common.addXWord(swollen, "synonym");
    XWordNormal swollenx = (XWordNormal) Common.getXWord(swollen);
    swollenx.setSynonym(LR.edema);

    String system = LR.system;
    // Common.addXWord(system, "synonym");
    XWordNormal systemx = (XWordNormal) Common.getXWord(system);
    systemx.setSynonym(LR.sys);

    String testes = LR.testes;
    // Common.addXWord(testes, "synonym");
    XWordNormal testesx = (XWordNormal) Common.getXWord(testes);
    testesx.setSynonym(LR.testiclesSt);

    String thyrotoxicosis = LR.thyrotoxicosis;
    Common.addXWord(thyrotoxicosis, "synonym");
    XWordNormal thyrotoxicosisx = (XWordNormal) Common.getXWord(thyrotoxicosis);
    thyrotoxicosisx.setSynonym(LR.hyperthyroidism);
    Common.addDiseaseForShow(thyrotoxicosis);

    String tinea = LR.tinea;
    Common.addXWord(tinea, "synonym");
    XWordNormal tineax = (XWordNormal) Common.getXWord(tinea);
    tineax.setSynonym(LR.dermatophytosis);
    Common.addDiseaseForShow(tinea);

    String travelerDiarrhea = LR.travelerDiarrhea;
    Common.addXWord(travelerDiarrhea, "synonym");
    XWordPolish travelerDiarrheax = (XWordPolish) Common.getXWord(travelerDiarrhea);
    travelerDiarrheax.setSynonym(LR.gastroenteritis);
    Common.addDiseaseForShow(travelerDiarrhea);

    String twitch = LR.twitch;
    Common.addXWord(twitch, "synonym");
    XWordNormal twitchx = (XWordNormal) Common.getXWord(twitch);
    twitchx.setSynonym(LR.spasm);

    String UTI = LR.UTI;
    Common.addXWord(UTI, "synonym");
    XWordNormal UTIx = (XWordNormal) Common.getXWord(UTI);
    UTIx.setSynonym(LR.urinaryTractInfection);
    Common.addDiseaseForShow(UTI);

    String virusEnteritis = LR.virusEnteritis;
    Common.addXWord(virusEnteritis, "synonym");
    XWordPolish virusEnteritisx = (XWordPolish) Common.getXWord(virusEnteritis);
    virusEnteritisx.setSynonym(LR.gastroenteritis);
    Common.addDiseaseForShow(virusEnteritis);

    String VSD = LR.VSD;
    Common.addXWord(VSD, "synonym");
    XWordNormal VSDx = (XWordNormal) Common.getXWord(VSD);
    VSDx.setSynonym(LR.ventricularSeptalDefect);
    Common.addDiseaseForShow(VSD);


    // singular => plural add addReference(String ref)

    String ankle = LR.ankle; // introduced elsewhere
    XWordNormal anklex = (XWordNormal) Common.getXWord(ankle);
    anklex.checkAddReference(LR.anklesSt); // introduced elsewhere

    String arm = LR.arm; // introduced elsewhere
    XWordNormal armx = (XWordNormal) Common.getXWord(arm);
    armx.checkAddReference(LR.armsSt); // introduced elsewhere

    String bleeding = LR.bleeding; // introduced elsewhere
    XWordNormal bleedingx = (XWordNormal) Common.getXWord(bleeding);
    bleedingx.checkAddReference(LR.menstruation); // introduced elsewhere
    bleedingx.checkAddReference(LR.menarcheEarly); // introduced elsewhere

    String blood = LR.blood; // introduced elsewhere
    XWordNormal bloodx = (XWordNormal) Common.getXWord(blood);
    bloodx.checkAddReference(LR.bloody); // introduced elsewhere

    String breast = LR.breast; // introduced elsewhere
    XWordNormal breastx = (XWordNormal) Common.getXWord(breast);
    breastx.checkAddReference(LR.breastsSt); // introduced elsewhere

    String cornea = LR.cornea; // introduced elsewhere
    XWordNormal corneax = (XWordNormal) Common.getXWord(cornea);
    corneax.checkAddReference(LR.corneasSt); // introduced elsewhere

    String ear = LR.ear; // introduced elsewhere
    XWordNormal earx = (XWordNormal) Common.getXWord(ear);
    earx.checkAddReference(LR.earsSt); // introduced elsewhere

    String elbow = LR.elbow; // introduced elsewhere
    XWordNormal elbowx = (XWordNormal) Common.getXWord(elbow);
    elbowx.checkAddReference(LR.elbowsSt); // introduced elsewhere

    String eye = LR.eye; // introduced elsewhere
    XWordNormal eyex = (XWordNormal) Common.getXWord(eye);
    eyex.checkAddReference(LR.eyesSt); // introduced elsewhere

    String flank = LR.flank; // introduced elsewhere
    XWordNormal flankx = (XWordNormal) Common.getXWord(flank);
    flankx.checkAddReference(LR.flanksSt); // introduced elsewhere

    String finger = LR.finger; // introduced elsewhere
    XWordNormal fingerx = (XWordNormal) Common.getXWord(finger);
    fingerx.checkAddReference(LR.fingersSt); // introduced elsewhere

    String hand = LR.hand; // introduced elsewhere
    XWordNormal handx = (XWordNormal) Common.getXWord(hand);
    handx.checkAddReference(LR.handsSt); // introduced elsewhere

    String hip = LR.hip; // introduced elsewhere
    XWordNormal hipx = (XWordNormal) Common.getXWord(hip);
    hipx.checkAddReference(LR.hipsSt); // introduced elsewhere

    String jaw = LR.jaw; // introduced elsewhere
    XWordNormal jawx = (XWordNormal) Common.getXWord(jaw);
    jawx.checkAddReference(LR.jawsSt); // introduced elsewhere

    String joint = LR.joint; // introduced elsewhere
    XWordNormal jointx = (XWordNormal) Common.getXWord(joint);
    jointx.checkAddReference(LR.jointsSt); // introduced elsewhere

    String kidney = LR.kidney; // introduced elsewhere
    XWordNormal kidneyx = (XWordNormal) Common.getXWord(kidney);
    kidneyx.checkAddReference(LR.kidneysSt); // introduced elsewhere

    String knee = LR.knee; // introduced elsewhere
    XWordNormal kneex = (XWordNormal) Common.getXWord(knee);
    kneex.checkAddReference(LR.kneesSt); // introduced elsewhere

    String leg = LR.leg; // introduced elsewhere
    XWordNormal legx = (XWordNormal) Common.getXWord(leg);
    legx.checkAddReference(LR.legsSt); // introduced elsewhere

    String lip = LR.lip; // introduced elsewhere
    XWordNormal lipx = (XWordNormal) Common.getXWord(lip);
    lipx.checkAddReference(LR.lipsSt); // introduced elsewhere

    String lung = LR.lung; // introduced elsewhere
    XWordNormal lungx = (XWordNormal) Common.getXWord(lung);
    lungx.checkAddReference(LR.lungsSt); // introduced elsewhere

    String nail = LR.nail; // introduced elsewhere
    XWordNormal nailx = (XWordNormal) Common.getXWord(nail);
    nailx.checkAddReference(LR.nailsSt); // introduced elsewhere

    String nipple = LR.nipple; // introduced elsewhere
    XWordNormal nipplex = (XWordNormal) Common.getXWord(nipple);
    nipplex.checkAddReference(LR.nipplesSt); // introduced elsewhere

    String ovary = LR.ovary; // introduced elsewhere
    XWordNormal ovaryx = (XWordNormal) Common.getXWord(ovary);
    ovaryx.checkAddReference(LR.ovariesSt); // introduced elsewhere

    String palm = LR.palm; // introduced elsewhere
    XWordNormal palmx = (XWordNormal) Common.getXWord(palm);
    palmx.checkAddReference(LR.palmsSt); // introduced elsewhere

    String pupil = LR.pupil; // introduced elsewhere
    XWordNormal pupilx = (XWordNormal) Common.getXWord(pupil);
    pupilx.checkAddReference(LR.pupilsSt); // introduced elsewhere

    String retina = LR.retina; // introduced elsewhere
    XWordNormal retinax = (XWordNormal) Common.getXWord(retina);
    retinax.checkAddReference(LR.retinasSt); // introduced elsewhere

    String sex = LR.sex; // introduced elsewhere
    XWordNormal sexx = (XWordNormal) Common.getXWord(sex);
    sexx.checkAddReference(LR.sexual); // introduced elsewhere

    String shoulder = LR.shoulder; // introduced elsewhere
    XWordNormal shoulderx = (XWordNormal) Common.getXWord(shoulder);
    shoulderx.checkAddReference(LR.shouldersSt); // introduced elsewhere

    String thigh = LR.thigh; // introduced elsewhere
    XWordNormal thighx = (XWordNormal) Common.getXWord(thigh);
    thighx.checkAddReference(LR.thighsSt); // introduced elsewhere

    String thumb = LR.thumb; // introduced elsewhere
    XWordNormal thumbx = (XWordNormal) Common.getXWord(thumb);
    thumbx.checkAddReference(LR.thumbsSt); // introduced elsewhere

    String toe = LR.toe; // introduced elsewhere
    XWordNormal toex = (XWordNormal) Common.getXWord(toe);
    toex.checkAddReference(LR.toesSt); // introduced elsewhere

    String wrist = LR.wrist; // introduced elsewhere
    XWordNormal wristx = (XWordNormal) Common.getXWord(wrist);
    wristx.checkAddReference(LR.wristsSt); // introduced elsewhere


  } // end of doit(...)

} // end of InitSynonyms

