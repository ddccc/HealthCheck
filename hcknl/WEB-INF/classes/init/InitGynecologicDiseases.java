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

public class InitGynecologicDiseases {
  public static void doit() {


// -------------- premenstrualSyndrome --------------
// (C) OntoOO Inc Wed Dec 12 21:23:45 PST 2001
Disease premenstrualSyndromeDis = new Disease(
   LR.premenstrualSyndrome, 
   "varying syndromes that appear 7-14 days before menses", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   50, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);
premenstrualSyndromeDis.setPrintName("premenstrual syndrome");
premenstrualSyndromeDis.setStatusCondition("menstruating");
premenstrualSyndromeDis.addSymptom(LR.abdomenBloating); 
premenstrualSyndromeDis.addSymptom(LR.abdomenTenderness); 
premenstrualSyndromeDis.addSymptom(LR.agitation, "", 1.0f); 
premenstrualSyndromeDis.addSymptom(LR.breastSwelling); 
premenstrualSyndromeDis.addSymptom(LR.breastTenderness); 
premenstrualSyndromeDis.addSymptom(LR.constipation, "", 1.0f); 
premenstrualSyndromeDis.addSymptom(LR.diarrhea, "", 1.0f); 
premenstrualSyndromeDis.addSymptom(LR.edema, "", 1.0f); 
premenstrualSyndromeDis.addSymptom(LR.fatigue, "", 1.0f); 
premenstrualSyndromeDis.addSymptom(LR.headache, "", 1.0f); 
premenstrualSyndromeDis.addSymptom(LR.hostility, "", 1.0f); 
premenstrualSyndromeDis.addSymptom(LR.irritability, "", 1.0f); 
premenstrualSyndromeDis.addSymptom(LR.jointPain); 
premenstrualSyndromeDis.addSymptom(LR.lethargy, "", 1.0f); 
premenstrualSyndromeDis.addSymptom(LR.mentalDepression, "", 1.0f); 
premenstrualSyndromeDis.addSymptom(LR.nervousness, "", 1.0f); 
premenstrualSyndromeDis.addSymptom(LR.rash, "", 1.0f); 
premenstrualSyndromeDis.addSymptom(LR.sleepDisturbed, "", 1.0f); 

premenstrualSyndromeDis.addReference("pp 920-1");
Treatment premenstrualSyndromeTr1 = new Treatment("premenstrualSyndromeTr1");
premenstrualSyndromeTr1.addDrug(LR.diuretics);
premenstrualSyndromeTr1.addDrug(LR.antidepressants);
premenstrualSyndromeTr1.addDrug(LR.vitaminBComplex);
premenstrualSyndromeTr1.addDrug(LR.progestins);
premenstrualSyndromeTr1.addDrug(LR.prostaglandinInhibitor);
premenstrualSyndromeDis.addTreatment(premenstrualSyndromeTr1.getName()); 


// -------------- dysmenorrhea --------------
// (C) OntoOO Inc Thu Dec 13 19:55:39 PST 2001
Disease dysmenorrheaDis = new Disease(
   LR.dysmenorrhea, 
   "painful menstruation", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   50, //  maxAge 
   -2, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.uterusSysSt, 
   LR.none
);
dysmenorrheaDis.setStatusCondition("menstruating");
dysmenorrheaDis.addSymptom(LR.abdomenCramping, "", 1.0f);
dysmenorrheaDis.addSymptom(LR.abdomenPainLowerSide, "", 1.0f);
dysmenorrheaDis.addSymptom(LR.dizziness, "", 0.3f);
dysmenorrheaDis.addSymptom(LR.headache, "", 0.3f);
dysmenorrheaDis.addSymptom(LR.nausea, "", 0.3f);
dysmenorrheaDis.addInternalCause(LR.trichomoniasisFemale);
dysmenorrheaDis.addReference("pp 921-3");
Treatment dysmenorrheaTr1  = new Treatment("dysmenorrheaTr1");
dysmenorrheaTr1.addDrug(LR.analgetics);
dysmenorrheaTr1.addDrug(LR.prostaglandinInhibitor);
dysmenorrheaDis.addTreatment(dysmenorrheaTr1.getName());
Treatment dysmenorrheaTr2 = new Treatment("dysmenorrheaTr2", LR.ifSevere);
dysmenorrheaTr2.addDrug(LR.narcotics);
dysmenorrheaDis.addTreatment("dysmenorrheaTr2");


// -------------- vulvovaginitis --------------
// (C) OntoOO Inc Thu Dec 13 20:25:35 PST 2001
Disease vulvovaginitisDis = new Disease(
   LR.vulvovaginitis, 
   "inflammation of the vulva and/or vagina", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vaginagySysSt, 
   LR.none
);
vulvovaginitisDis.addSymptom(LR.intercourseDiscomfort, "", 0.5f);
vulvovaginitisDis.addInternalCause(LR.diabetesMellitusAdvanced); 
vulvovaginitisDis.addReference("pp 923-4");

Treatment vulvovaginitisTr1 = 
  new Treatment("vulvovaginitisTr1", LR.ifItchyVulva);
vulvovaginitisTr1.addTreatmentAction(LR.coldCompress);
vulvovaginitisTr1.addTreatmentAction(LR.coolSitzBath);
vulvovaginitisDis.addTreatment("vulvovaginitisTr1");
Treatment vulvovaginitisTr2 = new Treatment("vulvovaginitisTr2", 
					    LR.ifSevereInflammation);
vulvovaginitisTr2.addTreatmentAction(LR.warmCompress);
vulvovaginitisTr2.addDrug(LR.corticosteroids);
vulvovaginitisDis.addTreatment("vulvovaginitisTr2");
Treatment vulvovaginitisTr3 = new Treatment("vulvovaginitisTr3", LR.ifChronic);
vulvovaginitisTr3.addDrug(LR.hydrocortisone);
vulvovaginitisTr3.addDrug(LR.antipruritics);
vulvovaginitisDis.addTreatment(vulvovaginitisTr3.getName()); 
Treatment vulvovaginitisTr4 = 
  new Treatment("vulvovaginitisTr4", LR.ifMenopausalMucosaAtrophy);
vulvovaginitisTr4.addTreatmentAction(LR.topicalEstrogenOintment);
vulvovaginitisDis.addTreatment(vulvovaginitisTr4.getName()); 


// -------------- vulvovaginitisCan --------------
// (C) OntoOO Inc Sat Dec 15 17:08:09 PST 2001
Disease vulvovaginitisCanDis = new Disease(
   LR.vulvovaginitisCan, 
   "vulva and/or vagina infection with candida albicans", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   50, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vaginagySysSt, 
   LR.candidaAlbicansInfection
);
vulvovaginitisCanDis.setPrintName("vulvovaginitis candida albicans");
vulvovaginitisCanDis.setSuperDisease(LR.vulvovaginitis);

vulvovaginitisCanDis.addSymptom(LR.pruritus); 
vulvovaginitisCanDis.addSymptom(LR.vulvaRedSwollen);
vulvovaginitisCanDis.addSymptom(LR.vaginaDischargeThickWhite); 
vulvovaginitisCanDis.addSymptom(LR.vaginaItching);

vulvovaginitisCanDis.addReference("pp 923-4");

Treatment vulvovaginitisCanTr1  = new Treatment("vulvovaginitisCanTr1");
vulvovaginitisCanTr1.addDrug(LR.miconazole);
vulvovaginitisCanTr1.addDrug(LR.clotrimazole);
vulvovaginitisCanDis.addTreatment(vulvovaginitisCanTr1.getName());


// -------------- vulvovaginitisClam --------------
// (C) OntoOO Inc Sat Dec 15 17:21:32 PST 2001
Disease vulvovaginitisClamDis = new Disease(
   LR.vulvovaginitisClam, 
   "vulva and/or vagina infection with chlamydial", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   50, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vaginagySysSt, 
   LR.infection
);
vulvovaginitisClamDis.setPrintName("vulvovaginitis chlamydial");
vulvovaginitisClamDis.setSuperDisease(LR.vulvovaginitis);
vulvovaginitisClamDis.addSymptom(LR.urinationPainful);
vulvovaginitisClamDis.addSymptom(LR.vaginaDischarge);
vulvovaginitisClamDis.addInternalCause(LR.chlamydialInfection);
vulvovaginitisClamDis.addReference("pp 923-4");

Treatment vulvovaginitisClamTr1  = new Treatment("vulvovaginitisClamTr1");
vulvovaginitisClamTr1.addDrug(LR.erythromycin);
vulvovaginitisClamTr1.addDrug(LR.doxycycline);
vulvovaginitisClamDis.addTreatment(vulvovaginitisClamTr1.getName());


// -------------- vulvovaginitisGar --------------
// (C) OntoOO Inc Sat Dec 15 17:11:48 PST 2001
Disease vulvovaginitisGarDis = new Disease(
   LR.vulvovaginitisGar, 
   "vulva and/or vagina infection with gardnerella", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   50, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vaginagySysSt, 
   LR.none
);
vulvovaginitisGarDis.setPrintName("vulvovaginitis gardnerella");
vulvovaginitisGarDis.setSuperDisease(LR.vulvovaginitis);
vulvovaginitisGarDis.addExternalCause(LR.gardnerellaInfection);

vulvovaginitisGarDis.addSymptom(LR.vaginaDischargeGrayFoulFishySmelling); 

vulvovaginitisGarDis.addReference("pp 923-4");

Treatment vulvovaginitisGarTr1  = new Treatment("vulvovaginitisGarTr1");
vulvovaginitisGarTr1.addDrug(LR.metronidazole);
vulvovaginitisGarDis.addTreatment(vulvovaginitisGarTr1.getName());


// -------------- vulvovaginitisGon --------------
// (C) OntoOO Inc Sat Dec 15 17:14:44 PST 2001
Disease vulvovaginitisGonDis = new Disease(
   LR.vulvovaginitisGon, 
   "vulva and/or vagina infection with gonorrhea", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   50, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vaginagySysSt, 
   LR.none
);
vulvovaginitisGonDis.setPrintName("vulvovaginitis gonorrhea");
vulvovaginitisGonDis.setSuperDisease(LR.vulvovaginitis);
vulvovaginitisGonDis.addExternalCause(LR.gonorrheaInfection);

vulvovaginitisGonDis.addSymptom(LR.dysuria); 
vulvovaginitisGonDis.addSymptom(LR.vaginaDischargePurulent); 

vulvovaginitisGonDis.addReference("pp 923-4");

Treatment vulvovaginitisGonTr1  = new Treatment("vulvovaginitisGonTr1");
vulvovaginitisGonTr1.addDrug(LR.antibiotics);
vulvovaginitisGonDis.addTreatment(vulvovaginitisGonTr1.getName());


// -------------- vulvovaginitisHer --------------
// (C) OntoOO Inc Sat Dec 15 17:14:44 PST 2001
Disease vulvovaginitisHerDis = new Disease(
   LR.vulvovaginitisHer, 
   "vulva and/or vagina infection with herpes virus", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   50, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vaginagySysSt, 
   LR.none
);
vulvovaginitisHerDis.setPrintName("vulvovaginitis herpes");
vulvovaginitisHerDis.setSuperDisease(LR.vulvovaginitis);

vulvovaginitisHerDis.addSymptom(LR.blister);
vulvovaginitisHerDis.addSymptom(LR.ulcer);
vulvovaginitisHerDis.addInternalCause(LR.herpesSimplex);

vulvovaginitisHerDis.addReference("pp 923-4");

Treatment vulvovaginitisHerTr1 = new Treatment("vulvovaginitisHerTr1");
vulvovaginitisHerTr1.addDrug(LR.acyclovir);
vulvovaginitisHerDis.addTreatment(vulvovaginitisHerTr1.getName()); 

// -------------- vulvovaginitisTri --------------
// (C) OntoOO Inc Sat Dec 15 17:03:48 PST 2001
Disease vulvovaginitisTriDis = new Disease(
   LR.vulvovaginitisTri, 
   "vulva and/or vagina infection with trichomonas", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   20, //  minAge 
   50, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vaginagySysSt, 
   LR.none
);
vulvovaginitisTriDis.setPrintName("vulvovaginitis trichomonas");
vulvovaginitisTriDis.setSuperDisease(LR.vulvovaginitis);
vulvovaginitisTriDis.addExternalCause(LR.trichomonasInfection);

vulvovaginitisTriDis.addSymptom(LR.burningSensation); 
vulvovaginitisTriDis.addSymptom(LR.vaginaItching);
vulvovaginitisTriDis.addSymptom(LR.pruritus); 
vulvovaginitisTriDis.addSymptom(LR.vaginaDischargeThinBubblyGreentingedMalodorous); 
vulvovaginitisTriDis.addReference("pp 923-4");

Treatment vulvovaginitisTriTr1  = new Treatment("vulvovaginitisTriTr1");
vulvovaginitisTriTr1.addDrug(LR.metronidazole);
vulvovaginitisTriDis.addTreatment(vulvovaginitisTriTr1.getName());


// -------------- ovariesCysts --------------
// (C) OntoOO Inc Thu Dec 20 13:57:28 PST 2001
Disease ovariesCystsDis = new Disease(
   LR.ovariesCysts, 
   "hollow fluid filled structure that extend an ovary. " + 
   "variants: follicular, granulosa-lutein, theca-lutein", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   10, //  minAge 
   55, //  maxAge 
   -5, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);
ovariesCystsDis.setPrintName("ovaries cysts");

ovariesCystsDis.addSymptom(LR.abdomenDistension, "", 1.0f); 
ovariesCystsDis.addSymptom(LR.abdomenPainSuddenSevere, "if cysts with torsion", 1.0f); 
ovariesCystsDis.addSymptom(LR.abdomenRigidity, "", 1.0f); 
ovariesCystsDis.addSymptom(LR.abdomenTenderness, "", 1.0f); 
ovariesCystsDis.addSymptom(LR.lowBackPain, "if large or multiple cysts", 1.0f); 
ovariesCystsDis.addSymptom(LR.pelvisDiscomfort, "if large or multiple cysts", 1.0f); 
ovariesCystsDis.addSymptom(LR.uterusBleeding, "if large or multiple cysts", 1.0f); 

ovariesCystsDis.addCausesDisease(LR.dyspareunia); 
ovariesCystsDis.addReference("pp 924-6");

Treatment ovariesCystsTr1 = new Treatment("ovariesCystsTr1");
ovariesCystsTr1.addDrug(LR.clomipheneCitrate);
ovariesCystsTr1.addDrug(LR.oralContraceptives);
ovariesCystsDis.addTreatment(ovariesCystsTr1.getName()); 


// -------------- endometriosis --------------
// (C) OntoOO Inc Fri Dec 21 16:55:25 PST 2001
Disease endometriosisDis = new Disease(
   LR.endometriosis, 
   "presence of endometrial tissue beyond the uterus - where it belongs", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   40, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);

endometriosisDis.addSymptom(LR.lowBackPain, "", 1.0f); 
endometriosisDis.addSymptom(LR.abdomenPainLowerSide, "", 1.0f); 
endometriosisDis.addSymptom(LR.menstruationPainful, "", 1.0f); 
endometriosisDis.addSymptom(LR.pelvisPain, "", 1.0f); 
endometriosisDis.addSymptom(LR.vaginaPain, "", 1.0f); 

endometriosisDis.addCausesDisease(LR.infertilityFemale); 
endometriosisDis.addReference("pp 926-7");

Treatment endometriosisTr1 = new Treatment("endometriosisTr1", LR.ifStage1Or2);
endometriosisTr1.addDrug(LR.androgens);
endometriosisTr1.addDrug(LR.progestins);
endometriosisTr1.addDrug(LR.oralContraceptives);
endometriosisDis.addTreatment("endometriosisTr1");
Treatment endometriosisTr2  = new Treatment("endometriosisTr2", LR.ifStage3Or4);
endometriosisTr2.addTreatmentAction(LR.surgery);
endometriosisDis.addTreatment(endometriosisTr2.getName());


// -------------- endometriosisOO --------------
// (C) OntoOO Inc Sat Dec 22 20:30:47 PST 2001
Disease endometriosisOODis = new Disease(
   LR.endometriosisOO, 
   "uterus tissue in the ovaries and oviducts", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   40, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.ovariesSysSt, 
   LR.none
);
endometriosisOODis.setPrintName("endometriosis ovaries and oviducts");
endometriosisOODis.setSuperDisease(LR.endometriosis);

endometriosisOODis.addSymptom(LR.infertilityFemaleSymptom);
endometriosisOODis.addSymptom(LR.menstruationProfuse); 

endometriosisOODis.addReference("pp 926-7");


// -------------- endometriosisOC --------------
// (C) OntoOO Inc Sat Dec 22 22:19:28 PST 2001
Disease endometriosisOCDis = new Disease(
   LR.endometriosisOC, 
   "uterus tissue in the ovaries or cul-de-sac", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   40, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.ovariesSysSt, 
   LR.none
);
endometriosisOCDis.setPrintName("endometriosis ovarian or cul-de-sac");
endometriosisOCDis.setSuperDisease(LR.endometriosis);

endometriosisOCDis.addSymptom(LR.deepThrustDyspareunia); 

endometriosisOCDis.addReference("pp 926-7");


// -------------- endometriosisBladder --------------
// (C) OntoOO Inc Sat Dec 22 22:52:19 PST 2001
Disease endometriosisBladderDis = new Disease(
   LR.endometriosisBladder, 
   "uterus tissue in the bladder", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   40, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bladderSysSt, 
   LR.none
);
endometriosisBladderDis.setPrintName("endometriosis bladder");
endometriosisBladderDis.setSuperDisease(LR.endometriosis);

endometriosisBladderDis.addSymptom(LR.dysuria, "", 1.0f); 
endometriosisBladderDis.addSymptom(LR.hematuria, "", 1.0f); 
endometriosisBladderDis.addSymptom(LR.pubisPain); 

endometriosisBladderDis.addReference("pp 926-7");


// -------------- endometriosisBA --------------
// (C) OntoOO Inc Tue Dec 25 17:42:50 PST 2001
Disease endometriosisBADis = new Disease(
   LR.endometriosisBA, 
   "uterus tissue in the small bowel and appendix", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   40, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.smallIntestineSysSt, 
   LR.none
);
endometriosisBADis.setPrintName("endometriosis of small bowel and appendix");
endometriosisBADis.setSuperDisease(LR.endometriosis);
endometriosisBADis.addSymptom(LR.abdomenCramping);
endometriosisBADis.addSymptom(LR.nausea);
endometriosisBADis.addSymptom(LR.vomiting);
endometriosisBADis.addReference("pp 926-7");


// -------------- endometriosisCVP --------------
// (C) OntoOO Inc Tue Dec 25 17:53:22 PST 2001
Disease endometriosisCVPDis = new Disease(
   LR.endometriosisCVP, 
   "uterus tissue in the cervix vagina and perineum", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   30, //  minAge 
   40, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vaginagySysSt, 
   LR.none
);
endometriosisCVPDis.setPrintName("endometriosis of cervix vagina and perineum");
endometriosisCVPDis.setSuperDisease(LR.endometriosis);

endometriosisCVPDis.addSymptom(LR.bleedingFromVagina);
endometriosisCVPDis.addReference("pp 926-7");


// -------------- menopause --------------
// (C) OntoOO Inc Tue Dec 25 18:24:57 PST 2001
Disease menopauseDis = new Disease(
   LR.menopause, 
   "cessation of menstruation (not really a disease/disorder)", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   45, //  minAge 
   55, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);
// general symptoms
menopauseDis.setStatusCondition("menopause");
menopauseDis.addSymptom(LR.atrophicVulvitis, "", 1.0f); 
menopauseDis.addSymptom(LR.menstruationFlowDecrease, "", 1.0f); 
menopauseDis.addSymptom(LR.menstruationIrregular, "", 1.0f); 
menopauseDis.addSymptom(LR.spotting, "", 1.0f); 
// reproductive system symptoms
menopauseDis.addSymptom(LR.pelvisRelaxation); 
menopauseDis.addSymptom(LR.vaginaDischarge); 
menopauseDis.addSymptom(LR.vaginaDryness); 
menopauseDis.addSymptom(LR.vaginaItching); 
menopauseDis.addSymptom(LR.vaginaMucosaAtrophy);
// urinary system
menopauseDis.addSymptom(LR.dysuria); 
menopauseDis.addSymptom(LR.hematuria); 
menopauseDis.addSymptom(LR.incontinence); 
menopauseDis.addSymptom(LR.meatalTenderness); 
menopauseDis.addSymptom(LR.pyuria); 
menopauseDis.addSymptom(LR.urinaryUrgency);
// mammary system
menopauseDis.addSymptom(LR.breastSizeDecrease);
// skin
menopauseDis.addSymptom(LR.slightAlopecia); 
menopauseDis.addSymptom(LR.pubisHairLoss); 
menopauseDis.addSymptom(LR.skinElasticityLoss); 
// autonomic nervous system
menopauseDis.addSymptom(LR.cryingSpell); 
menopauseDis.addSymptom(LR.dyspnea); 
menopauseDis.addSymptom(LR.exacerbationOfMentalProblems); 
menopauseDis.addSymptom(LR.fitOfAnger); 
menopauseDis.addSymptom(LR.hotFlash); 
menopauseDis.addSymptom(LR.irritability); 
menopauseDis.addSymptom(LR.nervousness); 
menopauseDis.addSymptom(LR.nightSweating); 
menopauseDis.addSymptom(LR.syncope); 
menopauseDis.addSymptom(LR.tachycardia); 
menopauseDis.addSymptom(LR.tinnitus); 
menopauseDis.addSymptom(LR.vertigo); 

menopauseDis.addCausesDisease(LR.osteoporosis); 

menopauseDis.addReference("pp 930-2");
Treatment menopauseTr1  = new Treatment("menopauseTr1");
menopauseTr1.addDrug(LR.estrogen);
menopauseDis.addTreatment(menopauseTr1.getName());


// -------------- infertilityFemale --------------
// (C) OntoOO Inc Sat Dec 22 14:54:30 PST 2001
Disease infertilityFemaleDis = new Disease(
   LR.infertilityFemale, 
   "female infertility", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   50, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);
infertilityFemaleDis.setPrintName();
infertilityFemaleDis.setStatusCondition("menstruating");
infertilityFemaleDis.addSymptom(LR.infertilityFemaleSymptom);
infertilityFemaleDis.addSymptom(LR.menstruationAbsence);
infertilityFemaleDis.addSymptom(LR.menstruationInfrequent);
infertilityFemaleDis.addSymptom(LR.menstruationIrregular);
infertilityFemaleDis.addInternalCause(LR.anorexiaNervosa);
infertilityFemaleDis.addInternalCause(LR.endometriosis);
 
infertilityFemaleDis.addReference("pp 932-4");
infertilityFemaleDis.setMiscComments(
       "Causes are hormonal, anatomic and psychosocial");
Treatment infertilityFemaleTr1 = 
  new Treatment("infertilityFemaleTr1", LR.ifAndrenalGlandMalfunction);
infertilityFemaleTr1.addTreatmentAction(LR.hormoneTherapy);
infertilityFemaleDis.addTreatment("infertilityFemaleTr1");
Treatment infertilityFemaleTr2 = 
  new Treatment("infertilityFemaleTr2", LR.ifThyroidGlandMalfunction);
infertilityFemaleTr2.addTreatmentAction(LR.hormoneTherapy);
infertilityFemaleDis.addTreatment("infertilityFemaleTr2");
Treatment infertilityFemaleTr3 = 
  new Treatment("infertilityFemaleTr3", LR.ifProgesteroneDeficiency);
infertilityFemaleTr3.addDrug(LR.progesterone);
infertilityFemaleDis.addTreatment("infertilityFemaleTr3");
Treatment infertilityFemaleTr4 = 
  new Treatment("infertilityFemaleTr4", LR.ifNoOvulation);
infertilityFemaleTr4.addDrug(LR.clomiphene);
infertilityFemaleTr4.addDrug(LR.gonadotropin);
infertilityFemaleDis.addTreatment("infertilityFemaleTr4");
Treatment infertilityFemaleTr5 = 
  new Treatment("infertilityFemaleTr5", LR.ifEndometriosis);
infertilityFemaleTr5.addTreatmentAction(LR.surgery);
infertilityFemaleTr5.addDrug(LR.oralContraceptives);
infertilityFemaleTr5.addDrug(LR.danazol);
infertilityFemaleTr5.addDrug(LR.medroxyprogesterone);
infertilityFemaleDis.addTreatment("infertilityFemaleTr5");
Treatment infertilityFemaleTr6 = 
  new Treatment("infertilityFemaleTr6", LR.ifAnatomicDefects);
infertilityFemaleTr6.addTreatmentAction(LR.surgery);
infertilityFemaleDis.addTreatment(infertilityFemaleTr6.getName()); 


// -------------- pelvisInflammatoryDisease --------------
// (C) OntoOO Inc Fri Jan 25 12:54:53 PST 2002
Disease pelvisInflammatoryDiseaseDis = new Disease(
   LR.pelvisInflammatoryDisease, 
   "infection of oviducts, ovaries, cervix, fallopian tubes and/or etc.", 
   LR.gynecologicDisorders,
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.infection
);
pelvisInflammatoryDiseaseDis.setPrintName("pelvis inflammatory disease");
pelvisInflammatoryDiseaseDis.setTemperature((float)101.5); 
pelvisInflammatoryDiseaseDis.addSymptom(LR.abdomenPainLowerSide); 
pelvisInflammatoryDiseaseDis.addSymptom(LR.malaise); 
pelvisInflammatoryDiseaseDis.addSymptom(LR.vaginaDischargePurulent); 

pelvisInflammatoryDiseaseDis.addInternalCause(LR.chlamydialInfectionCervix);
pelvisInflammatoryDiseaseDis.addInternalCause(LR.chlamydialInfectionEndometrium);
pelvisInflammatoryDiseaseDis.addInternalCause(LR.chlamydialInfectionUrethraFemale);
pelvisInflammatoryDiseaseDis.addInternalCause(LR.gonorrheaPelvis);

pelvisInflammatoryDiseaseDis.addReference("934-6");

Treatment pelvisInflammatoryDiseaseTr1 = new Treatment("pelvisInflammatoryDiseaseTr1");
pelvisInflammatoryDiseaseTr1.addDrug(LR.antibiotics);
pelvisInflammatoryDiseaseDis.addTreatment(pelvisInflammatoryDiseaseTr1.getName()); 


// -------------- salpingoOophoritis --------------
// (C) OntoOO Inc Tue Feb 26 17:09:41 PST 2002
Disease salpingoOophoritisDis = new Disease(
   LR.salpingoOophoritis, 
   "acute inflammation of the fallopian tubes and/or ovaries", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);
salpingoOophoritisDis.setPrintName("salpingo-oophoritis");
salpingoOophoritisDis.setSuperDisease(LR.pelvisInflammatoryDisease);
salpingoOophoritisDis.setTemperature((float)101.5);
salpingoOophoritisDis.addSymptom(LR.abdomenRigidity);
salpingoOophoritisDis.addSymptom(LR.abdomenTenderness);
salpingoOophoritisDis.addSymptom(LR.malaise);
salpingoOophoritisDis.addSymptom(LR.pelvisPain);
salpingoOophoritisDis.addSymptom(LR.tachycardia);

salpingoOophoritisDis.addInternalCause(LR.chlamydialInfectionCervix);
salpingoOophoritisDis.addInternalCause(LR.chlamydialInfectionEndometrium);
salpingoOophoritisDis.addInternalCause(LR.chlamydialInfectionUrethraFemale);
salpingoOophoritisDis.addInternalCause(LR.gonorrheaPelvis);

salpingoOophoritisDis.addReference("pp 935");


// -------------- cervicitis --------------
// (C) OntoOO Inc Tue Feb 26 17:46:56 PST 2002
Disease cervicitisDis = new Disease(
   LR.cervicitis, 
   "inflammation of the cervix", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.cervixSysSt, 
   LR.none
);
cervicitisDis.setSuperDisease(LR.pelvisInflammatoryDisease);
cervicitisDis.addSymptom(LR.infertilityFemaleSymptom, "", 1.0f); 
cervicitisDis.addSymptom(LR.pelvisDiscomfort, "", 1.0f); 
cervicitisDis.addSymptom(LR.vaginaDischargeFoulSmelling, "", 1.0f); 
cervicitisDis.addSymptom(LR.vaginaItching, "", 1.0f); 
cervicitisDis.addSymptom(LR.abortionSpontaneous); 
cervicitisDis.addSymptom(LR.cervixEdematous); 
cervicitisDis.addSymptom(LR.cervixRed); 
cervicitisDis.addSymptom(LR.sexualDysfunction); 
cervicitisDis.addSymptom(LR.vaginaBurning); 
cervicitisDis.addReference("pp 935");


// -------------- amenorrhea --------------
// (C) OntoOO Inc Sun Jan 27 12:29:39 PST 2002
Disease amenorrheaDis = new Disease(
   LR.amenorrhea, 
   "abnormal absence of menstruation", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   18, //  minAge 
   45, //  maxAge 
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);
amenorrheaDis.setStatusCondition("menstruating");
amenorrheaDis.addSymptom(LR.menstruationAbsence); 
amenorrheaDis.addInternalCause(LR.anorexiaNervosa);
amenorrheaDis.addInternalCause(LR.bulimiaNervosa); 
amenorrheaDis.addInternalCause(LR.celiacDisease);
amenorrheaDis.addReference("pp 936-7"); 
amenorrheaDis.setMiscComments(
   "many causes, among which hormonal abnormalities, anorexia, intense exercise, " +
   "malnutrition, tumors, etc."); 
Treatment amenorrheaTr1 = new Treatment("amenorrheaTr1");
amenorrheaTr1.addTreatmentAction(LR.hormoneTherapy);
amenorrheaDis.addTreatment("amenorrheaTr1");
Treatment amenorrheaTr2  = new Treatment("amenorrheaTr2", LR.ifTumor);
amenorrheaTr2.addTreatmentAction(LR.surgery);
amenorrheaDis.addTreatment(amenorrheaTr2.getName());


// -------------- abnormalPremenopausalBleeding --------------
// (C) OntoOO Inc Tue Jan 29 16:40:38 PST 2002
Disease abnormalPremenopausalBleedingDis = new Disease(
   LR.abnormalPremenopausalBleeding, 
   "abnormal premenopausal bleeding", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   50, //  maxAge 
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);
abnormalPremenopausalBleedingDis.setPrintName();
abnormalPremenopausalBleedingDis.setStatusCondition("menstruating"); 
abnormalPremenopausalBleedingDis.addSymptom(LR.breastTenderness, 
					    "if abnormal pregnancy", 0.1f); 
abnormalPremenopausalBleedingDis.addSymptom(LR.nausea, 
					    "if abnormal pregnancy", 0.1f); 
abnormalPremenopausalBleedingDis.addSymptom(LR.uterusBleedingAbnormal, "", 1.0f); 
abnormalPremenopausalBleedingDis.addSymptom(LR.bloating, 
					    "if abnormal pregnancy", 0.1f); 
abnormalPremenopausalBleedingDis.addReference("pp 937-9");

Treatment abnormalPremenopausalBleedingTr1 = 
  new Treatment("abnormalPremenopausalBleedingTr1", LR.toAchieveConception);
abnormalPremenopausalBleedingTr1.addDrug(LR.clomiphene);
abnormalPremenopausalBleedingDis.addTreatment("abnormalPremenopausalBleedingTr1");

Treatment abnormalPremenopausalBleedingTr2 = 
  new Treatment("abnormalPremenopausalBleedingTr2", LR.ifCervixPolyps);
abnormalPremenopausalBleedingTr2.addTreatmentAction(LR.electrocautery);
abnormalPremenopausalBleedingTr2.addTreatmentAction(LR.chemicalCautery);
abnormalPremenopausalBleedingTr2.addTreatmentAction(LR.cryosurgery);
abnormalPremenopausalBleedingDis.addTreatment("abnormalPremenopausalBleedingTr2");

Treatment abnormalPremenopausalBleedingTr3 = 
  new Treatment("abnormalPremenopausalBleedingTr3", LR.ifOrganicDisorder);
abnormalPremenopausalBleedingTr3.addTreatmentAction(LR.hysterectomy);
abnormalPremenopausalBleedingTr3.addTreatmentAction(LR.xrayTherapy);
abnormalPremenopausalBleedingDis.addTreatment("abnormalPremenopausalBleedingTr3");


// -------------- hypomenorrhea --------------
// (C) OntoOO Inc Thu Jan 31 19:26:25 PST 2002
Disease hypomenorrheaDis = new Disease(
   LR.hypomenorrhea, 
   "deficient menstruation", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   50, //  maxAge 
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);
hypomenorrheaDis.setStatusCondition("menstruating");
hypomenorrheaDis.setSuperDisease(LR.abnormalPremenopausalBleeding);
hypomenorrheaDis.addSymptom(LR.menstruationDeficient);
hypomenorrheaDis.addInternalCause(LR.hyperthyroidism);
hypomenorrheaDis.addCausingAbnormalCondition(LR.infectionsSevere);
hypomenorrheaDis.addCausingAbnormalCondition(LR.malnutrition);
hypomenorrheaDis.addCausingAbnormalCondition(LR.psychicTraumaSevere);
hypomenorrheaDis.addReference("pp 938");


// -------------- oligomenorrhea --------------
// (C) OntoOO Inc Thu Jan 31 21:01:45 PST 2002
Disease oligomenorrheaDis = new Disease(
   LR.oligomenorrhea, 
   "infrequent menstruation", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   50, //  maxAge 
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);
oligomenorrheaDis.setStatusCondition("menstruating");
oligomenorrheaDis.setSuperDisease(LR.abnormalPremenopausalBleeding);
oligomenorrheaDis.addSymptom(LR.menstruationInfrequent);
oligomenorrheaDis.addInternalCause(LR.hyperthyroidism);
oligomenorrheaDis.addCausingAbnormalCondition(LR.infectionsSevere);
oligomenorrheaDis.addCausingAbnormalCondition(LR.malnutrition);
oligomenorrheaDis.addCausingAbnormalCondition(LR.psychicTraumaSevere);
oligomenorrheaDis.addReference("pp 938");


// -------------- metrorrhagia --------------
// (C) OntoOO Inc Thu Jan 31 21:22:26 PST 2002
Disease metrorrhagiaDis = new Disease(
   LR.metrorrhagia, 
   "irregular menstruation", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   50, //  maxAge 
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);
metrorrhagiaDis.setStatusCondition("menstruating");
metrorrhagiaDis.setSuperDisease(LR.abnormalPremenopausalBleeding);
metrorrhagiaDis.addSymptom(LR.menstruationIrregular);
metrorrhagiaDis.addCausingAbnormalCondition(LR.bloodDyscrasias);
metrorrhagiaDis.addInternalCause(LR.endometritis);
metrorrhagiaDis.addCausingAbnormalCondition(LR.uterusTumors);
metrorrhagiaDis.addReference("pp 938");


// -------------- polymenorrhea --------------
// (C) OntoOO Inc Thu Jan 31 21:22:26 PST 2002
Disease polymenorrheaDis = new Disease(
   LR.polymenorrhea, 
   "too frequent menstruation", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   50, //  maxAge 
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);
polymenorrheaDis.setStatusCondition("menstruating");
polymenorrheaDis.setSuperDisease(LR.abnormalPremenopausalBleeding);
polymenorrheaDis.addSymptom(LR.menstruationTooFrequent);
polymenorrheaDis.addInternalCause(LR.hypothyroidism);
polymenorrheaDis.addCausingAbnormalCondition(LR.bloodDyscrasias);
polymenorrheaDis.addReference("pp 938");


// -------------- menorrhagia --------------
// (C) OntoOO Inc Thu Jan 31 21:22:26 PST 2002
Disease menorrhagiaDis = new Disease(
   LR.menorrhagia, 
   "irregular menstruation", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   50, //  maxAge 
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);
menorrhagiaDis.setStatusCondition("menstruating");
menorrhagiaDis.setSuperDisease(LR.abnormalPremenopausalBleeding);
menorrhagiaDis.addSymptom(LR.menstruationProfuse);
menorrhagiaDis.addInternalCause(LR.hypothyroidism);
menorrhagiaDis.addInternalCause(LR.trichomoniasisFemale);
menorrhagiaDis.addCausingAbnormalCondition(LR.bloodDyscrasias);
menorrhagiaDis.addCausingAbnormalCondition(LR.psychicTraumaSevere);
menorrhagiaDis.addCausingAbnormalCondition(LR.uterusTumors);
menorrhagiaDis.addReference("pp 938");


// -------------- postMenopauseBleeding --------------
// (C) OntoOO Inc Fri Feb 01 15:43:00 PST 2002
Disease postMenopauseBleedingDis = new Disease(
   LR.postMenopauseBleeding, 
   "bleeding from the reproductive tract after one year of cessation of menses", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   45, //  minAge 
   LR.maxAge, //  maxAge 
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);
postMenopauseBleedingDis.setPrintName("post menopause bleeding");
postMenopauseBleedingDis.setStatusCondition("postmenopause");
postMenopauseBleedingDis.addSymptom(LR.uterusBleedingAbnormal, "", 1.0f);
postMenopauseBleedingDis.addReference("pp 940-1");
Treatment postMenopauseBleedingTr1 = new Treatment("postMenopauseBleedingTr1");
postMenopauseBleedingTr1.addTreatmentAction(LR.curettage);
postMenopauseBleedingDis.addTreatment(postMenopauseBleedingTr1.getName()); 
Treatment postMenopauseBleedingTr2 = new Treatment("postMenopauseBleedingTr2");
postMenopauseBleedingTr2.addTreatmentAction(LR.hysterectomy);
postMenopauseBleedingDis.addTreatment(postMenopauseBleedingTr2.getName()); 


// -------------- abortion --------------
// (C) OntoOO Inc Fri Feb 01 17:04:32 PST 2002
Disease abortionDis = new Disease(
   LR.abortion, 
   "spontaneous or induced expulsion of the result of conception " +
   "before its viability", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   13, //  minAge 
   50, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.uterusSysSt, 
   LR.none
);
abortionDis.setStatusCondition("pregnant"); 
abortionDis.addSymptom(LR.bleedingFromVagina);
abortionDis.addSymptom(LR.vaginaDischargePink, "", 0.5f); 
abortionDis.addSymptom(LR.vaginaDischargeBrown, "", 0.5f); 
abortionDis.addSymptom(LR.abdomenCramping); 
abortionDis.addInternalCause(LR.hydatidiformMole);
abortionDis.addReference("pp 941-4");

Treatment abortionTr1 = new Treatment("abortionTr1", LR.ifSevereBleeding);
abortionTr1.addTreatmentAction(LR.hospitalization);
abortionTr1.addTreatmentAction(LR.bloodTransfusion);
abortionDis.addTreatment(abortionTr1.getName()); 
Treatment abortionTr2 = new Treatment("abortionTr2", LR.ifAbortionIncomplete);
abortionTr2.addTreatmentAction(LR.curettage);
abortionDis.addTreatment(abortionTr2.getName()); 
abortionDis.setCode358(342);
abortionDis.setICD10code("O03");


// -------------- ectopicPregnancySuper --------------
// (C) OntoOO Inc Sun Feb 03 17:45:44 PST 2002
Disease ectopicPregnancySuperDis = new Disease(
   LR.ectopicPregnancySuper, 
   "implantation of fertilized ovum outside the uterus cavity", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   13, //  minAge 
   50, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);
ectopicPregnancySuperDis.setPrintName("ectopic pregnancy super");
ectopicPregnancySuperDis.setStatusCondition("pregnant");
ectopicPregnancySuperDis.addSymptom(LR.menstruationAbsence); 
ectopicPregnancySuperDis.addSymptom(LR.menstruationDeficient); 
ectopicPregnancySuperDis.addSymptom(LR.bleedingFromVaginaSlight); 
ectopicPregnancySuperDis.addSymptom(LR.pelvisDiscomfort); 
ectopicPregnancySuperDis.addReference("pp 944-6");


// -------------- ectopicPregnancy --------------
// (C) OntoOO Inc Sun Feb 03 17:45:44 PST 2002
Disease ectopicPregnancyDis = new Disease(
   LR.ectopicPregnancy, 
   "implantation of fertilized ovum outside the uterus cavity", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   13, //  minAge 
   50, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);
ectopicPregnancyDis.setPrintName("ectopic pregnancy");
ectopicPregnancyDis.setSuperDisease(LR.ectopicPregnancySuper);
ectopicPregnancyDis.setStatusCondition("pregnant");
ectopicPregnancyDis.addCausesDisease(LR.ectopicPregnancyRupture);
ectopicPregnancyDis.addReference("pp 944-6");
ectopicPregnancyDis.setCode358(341);
ectopicPregnancyDis.setICD10code("O00");


// -------------- ectopicPregnancyRupture --------------
// (C) OntoOO Inc Tue Feb 05 12:32:13 PST 2002
Disease ectopicPregnancyRuptureDis = new Disease(
   LR.ectopicPregnancyRupture, 
   "rupture of fallopian tube in which ovum has implanted", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   13, //  minAge 
   50, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.fallopianTubesSysSt,
   LR.none
);
ectopicPregnancyRuptureDis.setPrintName("ectopic pregnancy rupture");
ectopicPregnancyRuptureDis.setSuperDisease(LR.ectopicPregnancySuper);
ectopicPregnancyRuptureDis.setStatusCondition("pregnant");
ectopicPregnancyRuptureDis.addSymptom(LR.hemorrhage);
ectopicPregnancyRuptureDis.addSymptom(LR.abdomenPainLowerSide);
ectopicPregnancyRuptureDis.addSymptom(LR.shoulderPain);
ectopicPregnancyRuptureDis.addSymptom(LR.neckPain);
ectopicPregnancyRuptureDis.addSymptom(LR.uterusTender);
ectopicPregnancyRuptureDis.addInternalCause(LR.ectopicPregnancy);
ectopicPregnancyRuptureDis.addCausesDisease(LR.peritonitis); 
ectopicPregnancyRuptureDis.addCausesAbnormalCondition(LR.shock);
ectopicPregnancyRuptureDis.addReference("pp 944-6");
Treatment ectopicPregnancyRuptureTr1 = 
  new Treatment("ectopicPregnancyRuptureTr1");
ectopicPregnancyRuptureTr1.addTreatmentAction(LR.bloodTransfusion);
ectopicPregnancyRuptureTr1.addTreatmentAction(LR.surgery);
ectopicPregnancyRuptureTr1.addDrug(LR.antibiotics);
ectopicPregnancyRuptureDis.addTreatment(ectopicPregnancyRuptureTr1.getName()); 
ectopicPregnancyRuptureDis.setCode358(341);
ectopicPregnancyRuptureDis.setICD10code("O00");


// -------------- hyperemesisGravidarum --------------
// (C) OntoOO Inc Sat Feb 09 20:37:25 PST 2002
Disease hyperemesisGravidarumDis = new Disease(
   LR.hyperemesisGravidarum, 
   "severe nausea and vomiting that persist after the third month of pregnancy", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   12, //  minAge 
   50, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
hyperemesisGravidarumDis.setPrintName("hyperemesis gravidarum");
hyperemesisGravidarumDis.setStatusCondition("pregnant");
hyperemesisGravidarumDis.addSymptom(LR.nausea);
hyperemesisGravidarumDis.addSymptom(LR.vomiting);
hyperemesisGravidarumDis.addSymptom(LR.weightLoss, "if persistent", 0.3f);
hyperemesisGravidarumDis.addSymptom(LR.skinDry, "if persistent", 0.3f);
hyperemesisGravidarumDis.addSymptom(LR.skinPale, "if persistent", 0.3f);
hyperemesisGravidarumDis.addSymptom(LR.skinWaxy, "if persistent", 0.3f);
hyperemesisGravidarumDis.addSymptom(LR.jaundice, "if persistent", 0.3f);
hyperemesisGravidarumDis.addSymptom(LR.pulseRapid, "if persistent", 0.3f);
hyperemesisGravidarumDis.addSymptom(LR.breathStinking, "if persistent", 0.3f);
hyperemesisGravidarumDis.addSymptom(LR.confusion, "if persistent", 0.1f); 
hyperemesisGravidarumDis.addSymptom(LR.delirium, "if persistent", 0.1f); 
hyperemesisGravidarumDis.addSymptom(LR.headache, "if persistent", 0.3f); 
hyperemesisGravidarumDis.addSymptom(LR.weakness, "if persistent", 0.3f); 
hyperemesisGravidarumDis.addSymptom(LR.stupor, "if persistent", 0.1f); 
hyperemesisGravidarumDis.addReference("pp 946-7");
Treatment hyperemesisGravidarumTr1 = 
  new Treatment("hyperemesisGravidarumTr1", LR.ifSevere);
hyperemesisGravidarumTr1.addTreatmentAction(LR.hospitalization);
hyperemesisGravidarumTr1.addTreatmentAction(LR.IVNutrition);
hyperemesisGravidarumDis.addTreatment(hyperemesisGravidarumTr1.getName()); 


// -------------- pregnancyInducedHypertension --------------
// (C) OntoOO Inc Sun Feb 10 20:59:59 PST 2002
Disease pregnancyInducedHypertensionDis = new Disease(
   LR.pregnancyInducedHypertension, 
   "pregnancy induced hypertension", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   12, //  minAge 
   50, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.vascularSysSt, 
   LR.none
);
pregnancyInducedHypertensionDis.setPrintName();
pregnancyInducedHypertensionDis.setStatusCondition("pregnant");
pregnancyInducedHypertensionDis.addSymptom(LR.edema); 
pregnancyInducedHypertensionDis.addSymptom(LR.weightGain); 
pregnancyInducedHypertensionDis.addCausesDisease(LR.hypertension); 

pregnancyInducedHypertensionDis.addReference("pp 947-9");
pregnancyInducedHypertensionDis.setMiscComments(
  "Can develop in the 7th week of pregnancy or later"); 
Treatment pregnancyInducedHypertensionTr1 = 
  new Treatment("pregnancyInducedHypertensionTr1", LR.ifNearTerm);
pregnancyInducedHypertensionTr1.addTreatmentAction(LR.inductionOfLabor);
pregnancyInducedHypertensionDis.addTreatment(
  pregnancyInducedHypertensionTr1.getName()); 
Treatment pregnancyInducedHypertensionTr2 = 
  new Treatment("pregnancyInducedHypertensionTr2");
pregnancyInducedHypertensionTr2.addTreatmentAction(LR.bedRest);
pregnancyInducedHypertensionTr2.addDrug(LR.anticonvulsants);
pregnancyInducedHypertensionTr2.addDrug(LR.sedatives);
pregnancyInducedHypertensionDis.addTreatment(
  pregnancyInducedHypertensionTr2.getName()); 


// -------------- hydatidiformMole --------------
// (C) OntoOO Inc Wed Feb 13 11:20:39 PST 2002
Disease hydatidiformMoleDis = new Disease(
   LR.hydatidiformMole, 
   "tumor of the placenta", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.asian, // raceSpecificity 
   45, //  minAge 
   55, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);
hydatidiformMoleDis.setPrintName("hydatidiform mole");
hydatidiformMoleDis.addSymptom(LR.abdomenCramping, "", 1.0f); 
hydatidiformMoleDis.addSymptom(LR.bleedingFromVagina, "", 1.0f); 
hydatidiformMoleDis.addSymptom(LR.menstruationAbsence, "", 1.0f); 
hydatidiformMoleDis.addSymptom(LR.fetalHeartTonesAbsent, "", 1.0f); 
hydatidiformMoleDis.addSymptom(LR.uterusGrowsTooFast, "", 1.0f); 
hydatidiformMoleDis.addCausingSet(LR.infections); 
hydatidiformMoleDis.addCausesDisease(LR.anemia);
hydatidiformMoleDis.addCausesDisease(LR.abortion); 
hydatidiformMoleDis.addCausesDisease(LR.choriocarcinoma); 
hydatidiformMoleDis.addCausesAbnormalCondition(LR.uterusRupture); 
hydatidiformMoleDis.addReference("pp 949-50");
hydatidiformMoleDis.setMiscComments(
  "mimics normal pregnancy, but uterus grows too fast, no fetal heart tones, etc."); 
Treatment hydatidiformMoleTr1 = new Treatment("hydatidiformMoleTr1");
hydatidiformMoleTr1.addTreatmentAction(LR.curettage);
hydatidiformMoleTr1.addTreatmentAction(LR.hysterectomy);
hydatidiformMoleDis.addTreatment(hydatidiformMoleTr1.getName()); 


// -------------- choriocarcinoma --------------
// (C) OntoOO Inc Sun Feb 17 15:27:59 PST 2002
Disease choriocarcinomaDis = new Disease(
   LR.choriocarcinoma, 
   "rapidly metastasizing malignant tumor of placental tissue", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   50, //  maxAge 
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.uterusSysSt, 
   LR.none
);
choriocarcinomaDis.addSymptom(LR.pelvisPain);
choriocarcinomaDis.addSymptom(LR.bleedingFromVaginaProfuse);
choriocarcinomaDis.addInternalCause(LR.hydatidiformMole);
choriocarcinomaDis.addReference("pp 1282-3");
choriocarcinomaDis.setMiscComments("rare disease");
Treatment choriocarcinomaTr1  = new Treatment("choriocarcinomaTr1");
choriocarcinomaTr1.addTreatmentAction(LR.curettage);
choriocarcinomaTr1.addTreatmentAction(LR.hysterectomy);
choriocarcinomaTr1.addTreatmentAction(LR.chemoTherapy);
choriocarcinomaDis.addTreatment(choriocarcinomaTr1.getName());


// -------------- placentaPrevia --------------
// (C) OntoOO Inc Sun Feb 17 17:17:03 PST 2002
Disease placentaPreviaDis = new Disease(
   LR.placentaPrevia, 
   "placenta is implanted in the lower uterus segment", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   50, //  maxAge 
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.placentaSysSt, 
   LR.none
);
placentaPreviaDis.setPrintName("placenta previa");
placentaPreviaDis.setStatusCondition("pregnant");
placentaPreviaDis.addSymptom(LR.bleedingThirdTrimester); 
placentaPreviaDis.addReference("pp 950-2");
Treatment placentaPreviaTr1 = new Treatment("placentaPreviaTr1");
placentaPreviaTr1.addTreatmentAction(LR.hospitalization);
placentaPreviaTr1.addTreatmentAction(LR.IVFluids);
placentaPreviaTr1.addTreatmentAction(LR.bloodTransfusion);
placentaPreviaDis.addTreatment(placentaPreviaTr1.getName()); 
Treatment placentaPreviaTr2 = 
   new Treatment("placentaPreviaTr2", LR.ifSevereBleeding);
placentaPreviaTr2.addTreatmentAction(LR.cesarianDelivery);
placentaPreviaDis.addTreatment(placentaPreviaTr2.getName()); 


// -------------- abruptioPlacentae --------------
// (C) OntoOO Inc Mon Feb 18 21:34:02 PST 2002
Disease abruptioPlacentaeDis = new Disease(
   LR.abruptioPlacentae, 
   "the placenta separates prematurely (partially) from the wall " +
   "typically after the 20th week of gestation", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   35, //  minAge 
   50, //  maxAge 
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.placentaSysSt, 
   LR.none
);
abruptioPlacentaeDis.setPrintName("abruptio placentae");
abruptioPlacentaeDis.setStatusCondition("pregnant"); 
abruptioPlacentaeDis.addSymptom(LR.abdomenPain); 
abruptioPlacentaeDis.addSymptom(LR.bleedingGestation2ndHalf);
abruptioPlacentaeDis.addSymptom(LR.uterusIrritation);
abruptioPlacentaeDis.addReference("pp 952-4");
abruptioPlacentaeDis.setMiscComments("most often with multi fetus");
Treatment abruptioPlacentaeTr1 = new Treatment("abruptioPlacentaeTr1");
abruptioPlacentaeTr1.addTreatmentAction(LR.IVFluids);
abruptioPlacentaeTr1.addTreatmentAction(LR.hospitalization);
abruptioPlacentaeDis.addTreatment(abruptioPlacentaeTr1.getName()); 


// -------------- cardiovascularDiseaseInPregnancy --------------
// (C) OntoOO Inc Tue Feb 19 16:43:05 PST 2002
Disease cardiovascularDiseaseInPregnancyDis = new Disease(
   LR.cardiovascularDiseaseInPregnancy, 
   "pregnancy puts additional strain on a compromised heart", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.cardioVascularSysSt, 
   LR.none
);
cardiovascularDiseaseInPregnancyDis.setPrintName("cardiovascular disease in pregnancy");
cardiovascularDiseaseInPregnancyDis.setStatusCondition("pregnant");
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.arrhythmia, "", 1.0f); 
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.neckVeinsElevated, "", 1.0f); 
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.crackles, "", 1.0f); 
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.cyanosis, "", 1.0f); 
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.pulseDelay, "", 1.0f); 
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.pulsusAlternans, "", 1.0f); 
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.dyspnea, 
					       "if heart overburdened", 0.2f); 
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.edema, 
					       "if heart overburdened", 0.2f); 
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.hemoptysis, 
					       "if heart overburdened", 0.2f); 
cardiovascularDiseaseInPregnancyDis.addSymptom(LR.palpitations, 
					       "if heart overburdened", 0.2f);  
cardiovascularDiseaseInPregnancyDis.addInternalCause(LR.rheumaticHeartDisease); 
cardiovascularDiseaseInPregnancyDis.addCausesAbnormalCondition(LR.cardiacEnlargement); 
cardiovascularDiseaseInPregnancyDis.addCausesAbnormalCondition(LR.diastolicMurmurs); 
cardiovascularDiseaseInPregnancyDis.addReference("pp 954-6");
cardiovascularDiseaseInPregnancyDis.setMiscComments(
   "rheumatic heart disease is involved in 4 out of 5 cases");
Treatment cardiovascularDiseaseInPregnancyTr1 = 
   new Treatment("cardiovascularDiseaseInPregnancyTr1", LR.ifSevere);
cardiovascularDiseaseInPregnancyTr1.addTreatmentAction(LR.hospitalization);
cardiovascularDiseaseInPregnancyDis.addTreatment(
   cardiovascularDiseaseInPregnancyTr1.getName()); 


// -------------- diabetesComplicationsInPregnancy --------------
// (C) OntoOO Inc Wed Feb 20 22:39:03 PST 2002
Disease diabetesComplicationsInPregnancyDis = new Disease(
   LR.diabetesComplicationsInPregnancy, 
   "pregnancy can trigger the onset of diabetes or worsen a diabetes condition", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   50, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.endocrineSysSt, 
   LR.none
);
diabetesComplicationsInPregnancyDis.setPrintName("diabetes complications in pregnancy");
diabetesComplicationsInPregnancyDis.setStatusCondition("pregnant");
diabetesComplicationsInPregnancyDis.setSuperDisease(LR.diabetesMellitusSuper); 
diabetesComplicationsInPregnancyDis.setGenetic("1parent"); 
diabetesComplicationsInPregnancyDis.setParentDisease(LR.diabetes); 
// diabetesComplicationsInPregnancyDis.addSymptom(LR.polyuria, "", 1.0f); 
diabetesComplicationsInPregnancyDis.addSymptom(LR.hungerExcessive); 
diabetesComplicationsInPregnancyDis.addSymptom(LR.thirstExcessive); 
diabetesComplicationsInPregnancyDis.addSymptom(LR.weightGainExcessive); 
diabetesComplicationsInPregnancyDis.addInternalCause(LR.pregnancyInducedHypertension);
diabetesComplicationsInPregnancyDis.addInternalCause(LR.candidiasis);  
diabetesComplicationsInPregnancyDis.addInternalCause(LR.obesity); 
// diabetesComplicationsInPregnancyDis.addCausingAbnormalCondition(LR.obesity); 
diabetesComplicationsInPregnancyDis.addCausesAbnormalCondition(LR.glycosuria);
diabetesComplicationsInPregnancyDis.addCausesAbnormalCondition(LR.polyhydramnios);  
diabetesComplicationsInPregnancyDis.addReference("pp 958-60");
Treatment diabetesComplicationsInPregnancyTr1 = 
  new Treatment("diabetesComplicationsInPregnancyTr1", LR.toControlGlucoseLevel);
diabetesComplicationsInPregnancyTr1.addDrug(LR.insulin);
diabetesComplicationsInPregnancyDis.addTreatment(
  diabetesComplicationsInPregnancyTr1.getName()); 


// -------------- prematureLabor --------------
// (C) OntoOO Inc Sat Feb 23 21:15:22 PST 2002
Disease prematureLaborDis = new Disease(
   LR.prematureLabor, 
   "premature labor", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   50, //  maxAge 
   -2, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);
prematureLaborDis.setPrintName();
prematureLaborDis.setStatusCondition("pregnant");
prematureLaborDis.addSymptom(LR.amnioticMembraneRupture, "", 0.5f); 
prematureLaborDis.addSymptom(LR.cervixDilation, "", 1.0f); 
prematureLaborDis.addSymptom(LR.uterusContractions, "", 1.0f); 
prematureLaborDis.addSymptom(LR.vaginaDischargeBloody); 
prematureLaborDis.addReference("pp 960-2");
Treatment prematureLaborTr1 = new Treatment("prematureLaborTr1", 
					    LR.ifSuppressLabor);
prematureLaborTr1.addTreatmentAction(LR.bedRest);
prematureLaborTr1.addDrug(LR.betaAdrenergicStimulants);
prematureLaborTr1.addDrug(LR.magnesiumSulfate);
prematureLaborDis.addTreatment(prematureLaborTr1.getName()); 


// -------------- prematureRuptureOfTheMembranes --------------
// (C) OntoOO Inc Sun Feb 24 20:01:52 PST 2002
Disease prematureRuptureOfTheMembranesDis = new Disease(
   LR.prematureRuptureOfTheMembranes, 
   "premature rupture of the membranes", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   13, //  minAge 
   50, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.none
);
prematureRuptureOfTheMembranesDis.setPrintName();
prematureRuptureOfTheMembranesDis.setStatusCondition("pregnant");
prematureRuptureOfTheMembranesDis.addSymptom(LR.amnioticMembraneRupture, "", 1.0f); 
prematureRuptureOfTheMembranesDis.addSymptom(LR.vaginaDischargeFoulSmelling, 
					     "if infection", 0.1f); 
prematureRuptureOfTheMembranesDis.addReference("pp 962-4");
Treatment prematureRuptureOfTheMembranesTr1 = 
  new Treatment("prematureRuptureOfTheMembranesTr1",
		LR.ifNoSpontaneousLabor);
prematureRuptureOfTheMembranesTr1.addTreatmentAction(LR.inductionOfLabor);
prematureRuptureOfTheMembranesTr1.addDrug(LR.oxytocin);
prematureRuptureOfTheMembranesDis.addTreatment(
  prematureRuptureOfTheMembranesTr1.getName()); 


// -------------- puerperalInfection --------------
// (C) OntoOO Inc Tue Feb 26 11:24:45 PST 2002
Disease puerperalInfectionDis = new Disease(
   LR.puerperalInfection, 
   "inflammation of the birth canal after delivery or abortion", 
   LR.infections, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   13, //  minAge 
   50, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.gynecologicSysSt, 
   LR.infection
);
puerperalInfectionDis.setPrintName("puerperal infection");
puerperalInfectionDis.setTemperature((float)100.4);
puerperalInfectionDis.addSymptom(LR.anxiety);
puerperalInfectionDis.addSymptom(LR.chills);
puerperalInfectionDis.addSymptom(LR.headache);
puerperalInfectionDis.addSymptom(LR.malaise);
puerperalInfectionDis.addSymptom(LR.restlessness);
puerperalInfectionDis.addReference("pp 965-7");
Treatment puerperalInfectionTr1 = new Treatment("puerperalInfectionTr1");
puerperalInfectionTr1.addTreatmentAction(LR.IVFluids);
puerperalInfectionTr1.addTreatmentAction(LR.bedRest);
puerperalInfectionTr1.addDrug(LR.analgetics);
puerperalInfectionTr1.addDrug(LR.antibiotics);
// puerperalInfectionTr1.addDrug(LR.anticoagulants);
// puerperalInfectionTr1.addDrug(LR.antiemetics);
puerperalInfectionDis.addTreatment(puerperalInfectionTr1.getName()); 


// -------------- puerperalInfectionLocalLesions --------------
// (C) OntoOO Inc Wed Feb 27 13:11:51 PST 2002
Disease puerperalInfectionLocalLesionsDis = new Disease(
   LR.puerperalInfectionLocalLesions, 
   "inflammation of the perineum, vulva and/or vagina after delivery or abortion ", 
   LR.infections, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   13, //  minAge 
   50, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.perineumVulvaVaginaSysSt, 
   LR.infection
);
puerperalInfectionLocalLesionsDis.setPrintName("puerperal infection local lesions");
puerperalInfectionLocalLesionsDis.setSuperDisease(LR.puerperalInfection);
puerperalInfectionLocalLesionsDis.setTemperature((float)100.4);
puerperalInfectionLocalLesionsDis.addSymptom(LR.dysuria);
puerperalInfectionLocalLesionsDis.addSymptom(LR.edema);
puerperalInfectionLocalLesionsDis.addSymptom(LR.pain);
puerperalInfectionLocalLesionsDis.addReference("pp 965-7");
Treatment puerperalInfectionLocalLesionsTr1 = 
  new Treatment("puerperalInfectionLocalLesionsTr1");
puerperalInfectionLocalLesionsTr1.addDrug(LR.antiseptics);
puerperalInfectionLocalLesionsDis.addTreatment(
  puerperalInfectionLocalLesionsTr1.getName()); 


// -------------- endometritis --------------
// (C) OntoOO Inc Wed Feb 27 21:41:33 PST 2002
Disease endometritisDis = new Disease(
   LR.endometritis, 
   "infection of the endometrium, the lining of the uterus", 
   LR.infections, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   13, //  minAge 
   50, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.endometriumSysSt,
   LR.infection
);
endometritisDis.setSuperDisease(LR.puerperalInfection);
endometritisDis.setTemperature((float)100.4);
endometritisDis.addSymptom(LR.backPain, "", 1.0f); 
endometritisDis.addSymptom(LR.uterusTender, "", 1.0f); 
endometritisDis.addSymptom(LR.uterusEnlarged, "", 1.0f); 
endometritisDis.addSymptom(LR.vaginaDischargeFoulSmelling, "", 0.2f); 
endometritisDis.addSymptom(LR.lochiaHeavy, "", 1.0f);
endometritisDis.addSymptom(LR.contractionsAfterChildbirth, "", 1.0f);
endometritisDis.addReference("pp 965-7");
Treatment endometritisTr1 = new Treatment("endometritisTr1");
endometritisTr1.addDrug(LR.anticoagulants);
endometritisDis.addTreatment(endometritisTr1.getName()); 


// -------------- parametritis --------------
// (C) OntoOO Inc Fri Mar 01 09:16:44 PST 2002
Disease parametritisDis = new Disease(
   LR.parametritis, 
   "infection of the pelvis after birth (pelvic cellulitis)", 
   LR.infections, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   13, //  minAge 
   50, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.pelvisSysSt, 
   LR.infection
);
parametritisDis.setSuperDisease(LR.puerperalInfection);
parametritisDis.setTemperature((float)100.4);
parametritisDis.addSymptom(LR.abdomenPain);
parametritisDis.addSymptom(LR.abdomenTenderness);
parametritisDis.addSymptom(LR.vaginaTenderness);
parametritisDis.addReference("pp 965-7");


// -------------- pelvisThrombophlebitis --------------
// (C) OntoOO Inc Fri Mar 01 10:58:07 PST 2002
Disease pelvisThrombophlebitisDis = new Disease(
   LR.pelvisThrombophlebitis, 
   "infection of the pelvis after birth, which is spreading", 
   LR.infections, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   13, //  minAge 
   50, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.pelvisSysSt, 
   LR.infection
);
pelvisThrombophlebitisDis.setPrintName("pelvis thrombophlebitis");
pelvisThrombophlebitisDis.setSuperDisease(LR.puerperalInfection);
pelvisThrombophlebitisDis.setTemperature((float)100.4);
pelvisThrombophlebitisDis.addSymptom(LR.abdomenTenderness, 
				     "develops near the 2nd postpartum week", 1.0f);
pelvisThrombophlebitisDis.addSymptom(LR.abdomenPainLowerSide);
pelvisThrombophlebitisDis.addSymptom(LR.chillsSevere);
pelvisThrombophlebitisDis.addSymptom(LR.flankPain);
pelvisThrombophlebitisDis.addSymptom(LR.temperatureSwingsSevere);
pelvisThrombophlebitisDis.addReference("pp 965-7");
Treatment pelvisThrombophlebitisTr1 = new Treatment("pelvisThrombophlebitisTr1");
pelvisThrombophlebitisTr1.addDrug(LR.anticoagulants);
pelvisThrombophlebitisDis.addTreatment(pelvisThrombophlebitisTr1.getName()); 


// -------------- femoralThrombophlebitis --------------
// (C) OntoOO Inc Fri Mar 01 11:46:05 PST 2002
Disease femoralThrombophlebitisDis = new Disease(
   LR.femoralThrombophlebitis, 
   "infection of a leg after birth", 
   LR.infections, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   13, //  minAge 
   50, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.groinSysSt, 
   LR.infection
);
femoralThrombophlebitisDis.setPrintName("femoral thrombophlebitis");
femoralThrombophlebitisDis.setSuperDisease(LR.puerperalInfection);
femoralThrombophlebitisDis.setTemperature((float)100.4);
femoralThrombophlebitisDis.addSymptom(LR.groinPain);
femoralThrombophlebitisDis.addSymptom(LR.legEdema);
femoralThrombophlebitisDis.addSymptom(LR.groinStiffness); 
femoralThrombophlebitisDis.addSymptom(LR.groinSwelling); 
femoralThrombophlebitisDis.addSymptom(LR.legPain); 
femoralThrombophlebitisDis.addSymptom(LR.legStiff); 
femoralThrombophlebitisDis.addCausesDisease(LR.pulmonaryEmbolism);
femoralThrombophlebitisDis.addReference("pp 965-7");


// -------------- mastitis --------------
// (C) OntoOO Inc Fri Mar 01 23:24:57 PST 2002
Disease mastitisDis = new Disease(
   LR.mastitis, 
   "inflammation of the mammary glands", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   13, //  minAge 
   50, //  maxAge 
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mammaryGlandsSysSt, 
   LR.none
);
mastitisDis.setTemperature((float)101.0); 
mastitisDis.addSymptom(LR.malaise, "", 1.0f); 
mastitisDis.addSymptom(LR.breastHard); 
mastitisDis.addSymptom(LR.breastSwelling); 
mastitisDis.addSymptom(LR.breastTenderness); 
mastitisDis.addSymptom(LR.breastWarm); 
mastitisDis.addReference("pp 967-70");
mastitisDis.setMiscComments("occurs in 1% of deliveries");
Treatment mastitisTr1 = new Treatment("mastitisTr1");
mastitisTr1.addDrug(LR.antibiotics);
mastitisDis.addTreatment(mastitisTr1.getName()); 
Treatment mastitisTr2 = new Treatment("mastitisTr2", LR.ifPain);
mastitisTr2.addDrug(LR.analgetics);
mastitisDis.addTreatment(mastitisTr2.getName()); 
Treatment mastitisTr3 = new Treatment("mastitisTr3", LR.ifSevere);
mastitisTr3.addTreatmentAction(LR.surgery);
mastitisDis.addTreatment(mastitisTr3.getName()); 


// -------------- breastEngorgement --------------
// (C) OntoOO Inc Sun Mar 03 22:12:04 PST 2002
Disease breastEngorgementDis = new Disease(
   LR.breastEngorgement, 
   "breast congestion during lactation", 
   LR.gynecologicDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   13, //  minAge 
   50, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mammaryGlandsSysSt, 
   LR.none
);
breastEngorgementDis.setPrintName("breast engorgement");
breastEngorgementDis.setStatusCondition("menstruating");
breastEngorgementDis.setTemperature((float)101.0);
breastEngorgementDis.addSymptom(LR.breastHard);
breastEngorgementDis.addSymptom(LR.breastSwelling);
breastEngorgementDis.addSymptom(LR.breastTenderness);
breastEngorgementDis.addSymptom(LR.breastWarm);
Treatment breastEngorgementTr1  = new Treatment("breastEngorgementTr1", LR.ifPain);
breastEngorgementTr1.addDrug(LR.analgetics);
breastEngorgementDis.addTreatment(breastEngorgementTr1.getName());
Treatment breastEngorgementTr2 = new Treatment("breastEngorgementTr2");
breastEngorgementTr2.addTreatmentAction(LR.icePack);
breastEngorgementTr2.addTreatmentAction(LR.upliftSupportBra);
breastEngorgementDis.addTreatment(breastEngorgementTr2.getName()); 


// -------------- galactorrhea --------------
// (C) OntoOO Inc Sun Mar 03 22:26:51 PST 2002
Disease galactorrheaDis = new Disease(
   LR.galactorrhea, 
   "inappropriate breast milk secretion", 
   LR.gynecologicDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   13, //  minAge 
   50, //  maxAge 
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.mammaryGlandsSysSt, 
   LR.none
);
galactorrheaDis.addReference("pp 970");
galactorrheaDis.addSymptom(LR.lactationAbnormal);
galactorrheaDis.setMiscComments(
   "may follow an abortion/ " +
   "may occur in a female that has not been pregnant/ " +
   "occurs rarely in males"); 
Treatment galactorrheaTr1 = new Treatment("galactorrheaTr1");
galactorrheaTr1.addDrug(LR.estrogen);
galactorrheaTr1.addDrug(LR.progestins);
galactorrheaTr1.addDrug(LR.bromocriptine);
galactorrheaDis.addTreatment(galactorrheaTr1.getName()); 


// -------------- hyperbilirubinemia --------------
// (C) OntoOO Inc Thu Aug 18 10:55:52 PDT 2005
Disease hyperbilirubinemiaDis = new Disease(
   LR.hyperbilirubinemia, 
   "jaundice and elevated bilirubin in an infant", 
   LR.gynecologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   1,
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
hyperbilirubinemiaDis.addSymptom(LR.jaundice);
hyperbilirubinemiaDis.addReference("pp 971-3");
hyperbilirubinemiaDis.setMiscComments("see the two variants");


// -------------- hyperbilirubinemiaPhysiologic --------------
// (C) OntoOO Inc Thu Aug 18 11:18:31 PDT 2005
Disease hyperbilirubinemiaPhysiologicDis = new Disease(
   LR.hyperbilirubinemiaPhysiologic, 
   "jaundice and elevated bilirubin in an infant", 
   LR.gynecologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   1,
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
hyperbilirubinemiaPhysiologicDis.setPrintName("hyperbilirubinemia physiologic");
hyperbilirubinemiaPhysiologicDis.setSuperDisease(LR.hyperbilirubinemia);
hyperbilirubinemiaPhysiologicDis.addSymptom(LR.jaundice, "", 1.0f);
hyperbilirubinemiaPhysiologicDis.addReference("pp 971-3");
hyperbilirubinemiaPhysiologicDis.setMiscComments("jaundice is the only symptom ");
Treatment hyperbilirubinemiaPhysiologicTr1 = 
    new Treatment("hyperbilirubinemiaPhysiologicTr1");
hyperbilirubinemiaPhysiologicTr1.addTreatmentAction(LR.phototherapy);
hyperbilirubinemiaPhysiologicDis.addTreatment("hyperbilirubinemiaPhysiologicTr1");


// -------------- hyperbilirubinemiaPathologic --------------
// (C) OntoOO Inc Thu Aug 18 11:42:08 PDT 2005
Disease hyperbilirubinemiaPathologicDis = new Disease(
   LR.hyperbilirubinemiaPathologic, 
   "jaundice and elevated bilirubin in an infant due to an underlying disease", 
   LR.gynecologicDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   1,
   -10, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
hyperbilirubinemiaPathologicDis.setPrintName("hyperbilirubinemia pathologic");
hyperbilirubinemiaPathologicDis.setSuperDisease(LR.hyperbilirubinemia);
hyperbilirubinemiaPathologicDis.addSymptom(LR.jaundice, "", 1.0f);
hyperbilirubinemiaPathologicDis.addReference("pp 971-3");
hyperbilirubinemiaPathologicDis.setMiscComments("jaundice is not the only symptom");
Treatment hyperbilirubinemiaPathologicTr2 = 
    new Treatment("hyperbilirubinemiaPathologicTr2");
hyperbilirubinemiaPathologicTr2.addTreatmentAction(LR.bloodTransfusion);
hyperbilirubinemiaPathologicDis.addTreatment("hyperbilirubinemiaPathologicTr2");



  } // end doit()
} // end InitGynecologicDiseases


