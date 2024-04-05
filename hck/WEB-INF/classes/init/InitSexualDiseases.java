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

public class InitSexualDiseases {
  public static void doit() {


// -------------- gonorrhea --------------
// (C) OntoOO Inc Wed Mar 06 21:59:30 PST 2002
Disease gonorrheaDis = new Disease(
   LR.gonorrhea, 
   "infection of the genitouri tract", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   F.gonorrheaFreq,
   LR.bodySysSt, 
   LR.gonorrheaInfection 
);
gonorrheaDis.addCausesDisease(LR.pharyngitisGonorrhea); 
gonorrheaDis.addCausesDisease(LR.tonsillitis); 
gonorrheaDis.addCausesDisease(LR.gonococcalSepticemia);
gonorrheaDis.addReference("pp 983-5");
gonorrheaDis.setMiscComments(
  "occasionally the rectum, throat and eyes can be infected");
Treatment gonorrheaTr1 = new Treatment("gonorrheaTr1");
gonorrheaTr1.addDrug(LR.ceftriaxone);
gonorrheaDis.addTreatment(gonorrheaTr1.getName()); 
gonorrheaDis.addIllustration(D.GonococcalOphthalmiaJpg);
gonorrheaDis.addIllustration(D.GonorrheaSkinLesion1Jpg);
gonorrheaDis.addIllustration(D.GonorrheaSkinLesion2Jpg);
gonorrheaDis.setCode358(30);
gonorrheaDis.setICD10code("A54");


// -------------- gonorrheaRectum --------------
// (C) OntoOO Inc Wed Mar 06 21:59:30 PST 2002
Disease gonorrheaRectumDis = new Disease(
   LR.gonorrheaRectum, 
   "infection by gonorrhea of the rectum", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   F.gonorrheaFreq,
   LR.rectumSysSt, 
   LR.none
);
gonorrheaRectumDis.setPrintName("gonorrhea of the rectum");
gonorrheaRectumDis.setSuperDisease(LR.gonorrhea);
gonorrheaRectumDis.addSymptom(LR.rectumBloodyDischarge); 
gonorrheaRectumDis.addSymptom(LR.rectumBurning); 
gonorrheaRectumDis.addSymptom(LR.rectumItching); 
gonorrheaRectumDis.addReference("pp 983-5");
gonorrheaRectumDis.setCode358(30);
gonorrheaRectumDis.setICD10code("A54");


// -------------- gonorrheaUrethraMale --------------
// (C) OntoOO Inc Fri Mar 08 09:57:57 PST 2002
Disease gonorrheaUrethraMaleDis = new Disease(
   LR.gonorrheaUrethraMale, 
   "infection of the male urethra", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   F.gonorrheaFreq,
   LR.urethraMLSysSt, 
   LR.none
);
gonorrheaUrethraMaleDis.setPrintName("gonorrhea urethra male");
gonorrheaUrethraMaleDis.setSuperDisease(LR.gonorrhea);
gonorrheaUrethraMaleDis.addSymptom(LR.dysuria);
gonorrheaUrethraMaleDis.addSymptom(LR.urethraMaleDischargePurulent); 
gonorrheaUrethraMaleDis.addSymptom(LR.urinationPainful);
gonorrheaUrethraMaleDis.addReference("pp 983-5");
gonorrheaUrethraMaleDis.addIllustration(D.GonococcalUrethritisJpg);
gonorrheaUrethraMaleDis.setCode358(30);
gonorrheaUrethraMaleDis.setICD10code("A54");


// -------------- gonorrheaFemale --------------
// (C) OntoOO Inc Fri Mar 08 13:05:15 PST 2002
Disease gonorrheaFemaleDis = new Disease(
   LR.gonorrheaFemale, 
   "infection of the genitouri tract", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   F.gonorrheaFreq,
   LR.bodySysSt, 
   LR.none
);
gonorrheaFemaleDis.setPrintName("gonorrhea female");
gonorrheaFemaleDis.setSuperDisease(LR.gonorrhea);
gonorrheaFemaleDis.addSymptom(LR.cervixDischargeGreenYellow); 
gonorrheaFemaleDis.addReference("pp 983-5");
gonorrheaFemaleDis.setCode358(30);
gonorrheaFemaleDis.setICD10code("A54");


// -------------- gonorrheaUrethraFemale --------------
// (C) OntoOO Inc Fri Mar 08 09:57:57 PST 2002
Disease gonorrheaUrethraFemaleDis = new Disease(
   LR.gonorrheaUrethraFemale, 
   "infection by gonorrhea of the female urethra", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   F.gonorrheaFreq,
   LR.urethraFMSysSt, 
   LR.none
);
gonorrheaUrethraFemaleDis.setPrintName("gonorrhea urethra female");
gonorrheaUrethraFemaleDis.setSuperDisease(LR.gonorrheaFemale);
gonorrheaUrethraFemaleDis.addSymptom(LR.dysuria);
gonorrheaUrethraFemaleDis.addSymptom(LR.urinaryFrequency);
gonorrheaUrethraFemaleDis.addSymptom(LR.incontinence); 
gonorrheaUrethraFemaleDis.addSymptom(LR.urethraFemaleDischargePurulent);
gonorrheaUrethraFemaleDis.addSymptom(LR.urethraFemaleItching);
gonorrheaUrethraFemaleDis.addSymptom(LR.urethraFemaleRed);
gonorrheaUrethraFemaleDis.addSymptom(LR.urethraFemaleSwollen);
gonorrheaUrethraFemaleDis.addReference("pp 983-5");
gonorrheaUrethraFemaleDis.setCode358(30);
gonorrheaUrethraFemaleDis.setICD10code("A54");


// -------------- gonorrheaVulva --------------
// (C) OntoOO Inc Fri Mar 08 09:57:57 PST 2002
Disease gonorrheaVulvaDis = new Disease(
   LR.gonorrheaVulva, 
   "infection by gonorrhea of the vulva", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   F.gonorrheaFreq,
   LR.vulvaSysSt, 
   LR.none
);
gonorrheaVulvaDis.setPrintName("gonorrhea of vulva");
gonorrheaVulvaDis.setSuperDisease(LR.gonorrheaFemale);
gonorrheaVulvaDis.addSymptom(LR.vulvaItching);
gonorrheaVulvaDis.addSymptom(LR.vulvaBurning);
gonorrheaVulvaDis.addSymptom(LR.vulvaPain);
gonorrheaVulvaDis.addReference("pp 983-5");
gonorrheaVulvaDis.setCode358(30);
gonorrheaVulvaDis.setICD10code("A54");


// -------------- gonorrheaVagina --------------
// (C) OntoOO Inc Fri Mar 08 09:57:57 PST 2002
Disease gonorrheaVaginaDis = new Disease(
   LR.gonorrheaVagina, 
   "infection by gonorrhea of the vagina", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   F.gonorrheaFreq,
   LR.vaginagySysSt, 
   LR.none
);
gonorrheaVaginaDis.setPrintName("gonorrhea of vagina");
gonorrheaVaginaDis.setSuperDisease(LR.gonorrheaFemale);
gonorrheaVaginaDis.addSymptom(LR.vaginaRed);
gonorrheaVaginaDis.addSymptom(LR.vaginaSwollen);
gonorrheaVaginaDis.addSymptom(LR.vaginaDischargePurulent);
gonorrheaVaginaDis.addReference("pp 983-5");
gonorrheaVaginaDis.addIllustration(D.GonococcalCervicitisJpg);
gonorrheaVaginaDis.setCode358(30);
gonorrheaVaginaDis.setICD10code("A54");


// -------------- gonorrheaLiver --------------
// (C) OntoOO Inc Fri Mar 08 09:57:57 PST 2002
Disease gonorrheaLiverDis = new Disease(
   LR.gonorrheaLiver, 
   "infection by gonorrhea of the liver", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   F.gonorrheaFreq,
   LR.liverSysSt, 
   LR.none
);
gonorrheaLiverDis.setPrintName("gonorrhea of liver");
gonorrheaLiverDis.setSuperDisease(LR.gonorrhea);
gonorrheaLiverDis.addSymptom(LR.liverPain);
gonorrheaLiverDis.addReference("pp 983-5");
gonorrheaLiverDis.setCode358(30);
gonorrheaLiverDis.setICD10code("A54");


// -------------- gonorrheaPelvis --------------
// (C) OntoOO Inc Fri Mar 08 13:05:15 PST 2002
Disease gonorrheaPelvisDis = new Disease(
   LR.gonorrheaPelvis, 
   "infection of the genitouri tract", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   F.gonorrheaFreq,
   LR.pelvisSysSt, 
   LR.none
);
gonorrheaPelvisDis.setPrintName("gonorrhea pelvis");
gonorrheaPelvisDis.setSuperDisease(LR.gonorrheaFemale);
gonorrheaPelvisDis.addSymptom(LR.abdomenDistension);
gonorrheaPelvisDis.addSymptom(LR.abdomenPainLowerSide);
gonorrheaPelvisDis.addSymptom(LR.abdomenTenderness);
gonorrheaPelvisDis.addSymptom(LR.pelvisPain);
gonorrheaPelvisDis.addCausesDisease(LR.pelvisInflammatoryDisease);
gonorrheaPelvisDis.addCausesDisease(LR.salpingoOophoritis);
gonorrheaPelvisDis.addReference("pp 983-5");
gonorrheaPelvisDis.setCode358(30);
gonorrheaPelvisDis.setICD10code("A54");


// -------------- gonococcalSepticemia --------------
// (C) OntoOO Inc Fri Mar 08 22:55:52 PST 2002
Disease gonococcalSepticemiaDis = new Disease(
   LR.gonococcalSepticemia, 
   "gonorrhea organisms invaded the bloodstream", 
   LR.sexualDisorders, 
   LR.moreFemale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   F.gonorrheaFreq,
   LR.bodySysSt, 
   LR.gonorrheaInfection
);
gonococcalSepticemiaDis.setPrintName("gonococcal septicemia");
gonococcalSepticemiaDis.addSymptom(LR.skinLesionFoot); 
gonococcalSepticemiaDis.addSymptom(LR.skinLesionHand); 
gonococcalSepticemiaDis.addInternalCause(LR.gonorrhea);
gonococcalSepticemiaDis.addReference("pp 983-5");
// Treatment gonorrheaTr1 = new Treatment("gonorrheaTr1");
// gonorrheaTr1.addDrug(LR.ceftriaxone);
gonococcalSepticemiaDis.addTreatment("gonorrheaTr1");
gonococcalSepticemiaDis.setCode358(30);
gonococcalSepticemiaDis.setICD10code("A54");


// -------------- chlamydialInfection --------------
// (C) OntoOO Inc Sat Mar 09 17:25:42 PST 2002
Disease chlamydialInfectionDis = new Disease(
   LR.chlamydialInfection, 
   "infection by chlamydia trachomatis", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.chlamydialInfectionExternal
);
chlamydialInfectionDis.setPrintName("chlamydial infection");
chlamydialInfectionDis.addReference("pp 985-7");
Treatment chlamydialInfectionTr1  = new Treatment("chlamydialInfectionTr1");
chlamydialInfectionTr1.addDrug(LR.doxycycline);
chlamydialInfectionTr1.addDrug(LR.azithromycin);
chlamydialInfectionDis.addTreatment(chlamydialInfectionTr1.getName());
Treatment chlamydialInfectionTr2 = new Treatment("chlamydialInfectionTr2", LR.ifPregnant);
chlamydialInfectionTr2.addDrug(LR.erythromycin);
chlamydialInfectionDis.addTreatment(chlamydialInfectionTr2.getName()); 
chlamydialInfectionDis.setCode358(32);
chlamydialInfectionDis.setICD10code("A69");


// -------------- chlamydialInfectionCervix --------------
// (C) OntoOO Inc Sun Mar 10 19:18:28 PST 2002
Disease chlamydialInfectionCervixDis = new Disease(
   LR.chlamydialInfectionCervix, 
   "cervix infection by chlamydia trachomatis", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   F.chlamydialInfectionFreq,
   LR.cervixSysSt, 
   LR.none
);
chlamydialInfectionCervixDis.setPrintName("chlamydial infection of the cervix");
chlamydialInfectionCervixDis.setSuperDisease(LR.chlamydialInfection);
chlamydialInfectionCervixDis.addSymptom(LR.pelvisPain);
chlamydialInfectionCervixDis.addSymptom(LR.vaginaDischargePurulent);
chlamydialInfectionCervixDis.addSymptom(LR.cervixErosion);
chlamydialInfectionCervixDis.addCausesDisease(LR.dyspareunia);
chlamydialInfectionCervixDis.addCausesDisease(LR.pelvisInflammatoryDisease);
chlamydialInfectionCervixDis.addCausesDisease(LR.salpingoOophoritis);
chlamydialInfectionCervixDis.addReference("pp 985-7");
chlamydialInfectionCervixDis.setCode358(32);
chlamydialInfectionCervixDis.setICD10code("A69");


// -------------- chlamydialInfectionEndometrium --------------
// (C) OntoOO Inc Sun Mar 10 20:51:18 PST 2002
Disease chlamydialInfectionEndometriumDis = new Disease(
   LR.chlamydialInfectionEndometrium, 
   "endometrium infection by chlamydia trachomatis", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   F.chlamydialInfectionFreq,
   LR.endometriumSysSt, 
   LR.none
);
chlamydialInfectionEndometriumDis.setPrintName("chlamydial infection of the endometrium");
chlamydialInfectionEndometriumDis.setSuperDisease(LR.chlamydialInfection);
chlamydialInfectionEndometriumDis.setTemperature((float)101.0);
chlamydialInfectionEndometriumDis.addSymptom(LR.abdomenPain);
chlamydialInfectionEndometriumDis.addSymptom(LR.abdomenTenderness);
chlamydialInfectionEndometriumDis.addSymptom(LR.cervixTenderness);
chlamydialInfectionEndometriumDis.addSymptom(LR.chills);
chlamydialInfectionEndometriumDis.addSymptom(LR.dysuria);
chlamydialInfectionEndometriumDis.addSymptom(LR.postcoitalBleeding);
chlamydialInfectionEndometriumDis.addSymptom(LR.uterusTender);
chlamydialInfectionEndometriumDis.addSymptom(LR.vaginaDischarge);
chlamydialInfectionEndometriumDis.addSymptom(LR.vaginaDischargeBloody);
chlamydialInfectionEndometriumDis.addCausesDisease(LR.pelvisInflammatoryDisease);
chlamydialInfectionEndometriumDis.addCausesDisease(LR.salpingoOophoritis);
chlamydialInfectionEndometriumDis.addReference("pp 985-7");
chlamydialInfectionEndometriumDis.setCode358(32);
chlamydialInfectionEndometriumDis.setICD10code("A69");


// -------------- chlamydialInfectionUrethraFemale --------------
// (C) OntoOO Inc Sun Mar 10 21:18:10 PST 2002
Disease chlamydialInfectionUrethraFemaleDis = new Disease(
   LR.chlamydialInfectionUrethraFemale, 
   "female urethra infection by chlamydia trachomatis", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   F.chlamydialInfectionFreq,
   LR.urethraFMSysSt, 
   LR.none
);
chlamydialInfectionUrethraFemaleDis.setPrintName(
   "chlamydial infection of the female urethra");
chlamydialInfectionUrethraFemaleDis.setSuperDisease(LR.chlamydialInfection);
chlamydialInfectionUrethraFemaleDis.addSymptom(LR.dysuria);
chlamydialInfectionUrethraFemaleDis.addSymptom(LR.pyuria);
chlamydialInfectionUrethraFemaleDis.addSymptom(LR.urinaryFrequency);
chlamydialInfectionUrethraFemaleDis.addCausesDisease(LR.pelvisInflammatoryDisease);
chlamydialInfectionUrethraFemaleDis.addCausesDisease(LR.salpingoOophoritis);
chlamydialInfectionUrethraFemaleDis.addReference("pp 985-7");
chlamydialInfectionUrethraFemaleDis.setCode358(32);
chlamydialInfectionUrethraFemaleDis.setICD10code("A69");


// -------------- chlamydialInfectionUrethraMale --------------
// (C) OntoOO Inc Mon Mar 11 20:18:01 PST 2002
Disease chlamydialInfectionUrethraMaleDis = new Disease(
   LR.chlamydialInfectionUrethraMale, 
   "male urethra infection by chlamydia trachomatis", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.urethraMLSysSt, 
   LR.none
);
chlamydialInfectionUrethraMaleDis.setPrintName(
   "chlamydial infection of the male urethra");
chlamydialInfectionUrethraMaleDis.setSuperDisease(LR.chlamydialInfection);
chlamydialInfectionUrethraMaleDis.addSymptom(LR.dysuria, "", 1.0f);
chlamydialInfectionUrethraMaleDis.addSymptom(LR.urinaryFrequency, "", 1.0f);
chlamydialInfectionUrethraMaleDis.addSymptom(LR.pruritus);
chlamydialInfectionUrethraMaleDis.addSymptom(LR.urethraMaleDischarge);
chlamydialInfectionUrethraMaleDis.addSymptom(LR.erythemaUrethraMale);
chlamydialInfectionUrethraMaleDis.addReference("pp 985-7");
chlamydialInfectionUrethraMaleDis.setCode358(32);
chlamydialInfectionUrethraMaleDis.setICD10code("A69");


// -------------- chlamydialInfectionEpididymis --------------
// (C) OntoOO Inc Tue Mar 12 11:44:45 PST 2002
Disease chlamydialInfectionEpididymisDis = new Disease(
   LR.chlamydialInfectionEpididymis, 
   "chlamydial infection of the male epididymis", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.epididymisSysSt, 
   LR.none
);
chlamydialInfectionEpididymisDis.setPrintName();
chlamydialInfectionEpididymisDis.setSuperDisease(LR.chlamydialInfection);
chlamydialInfectionEpididymisDis.addSymptom(LR.urethraMaleDischarge, "", 1.0f);
chlamydialInfectionEpididymisDis.addSymptom(LR.scrotumSwellingPainful, "", 1.0f);
chlamydialInfectionEpididymisDis.addCausesDisease(LR.epididymitis);
chlamydialInfectionEpididymisDis.addReference("pp 985-7");
chlamydialInfectionEpididymisDis.setCode358(32);
chlamydialInfectionEpididymisDis.setICD10code("A69");


// -------------- chlamydialInfectionProstate --------------
// (C) OntoOO Inc Tue Mar 12 14:46:00 PST 2002
Disease chlamydialInfectionProstateDis = new Disease(
   LR.chlamydialInfectionProstate, 
   "chlamydial infection of the male prostate", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.prostateSysSt, 
   LR.none
);
chlamydialInfectionProstateDis.setPrintName();
chlamydialInfectionProstateDis.setSuperDisease(LR.chlamydialInfection);
chlamydialInfectionProstateDis.addSymptom(LR.backPain);
chlamydialInfectionProstateDis.addSymptom(LR.dysuria);
chlamydialInfectionProstateDis.addSymptom(LR.urinaryFrequency);
chlamydialInfectionProstateDis.addSymptom(LR.nocturia);
chlamydialInfectionProstateDis.addSymptom(LR.ejaculationPainful);
chlamydialInfectionProstateDis.addReference("pp 985-7");
chlamydialInfectionProstateDis.setCode358(32);
chlamydialInfectionProstateDis.setICD10code("A69");


// -------------- chlamydialInfectionRectum --------------
// (C) OntoOO Inc Tue Mar 12 16:03:41 PST 2002
Disease chlamydialInfectionRectumDis = new Disease(
   LR.chlamydialInfectionRectum, 
   "chlamydial infection of the rectum", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -3, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.rectumSysSt, 
   LR.none
);
chlamydialInfectionRectumDis.setPrintName();
chlamydialInfectionRectumDis.setSuperDisease(LR.chlamydialInfection);
chlamydialInfectionRectumDis.addSymptom(LR.diarrhea);
chlamydialInfectionRectumDis.addSymptom(LR.pruritus);
chlamydialInfectionRectumDis.addSymptom(LR.tenesmus);
chlamydialInfectionRectumDis.addSymptom(LR.rectumBloodyDischarge, "", 0.5f);
chlamydialInfectionRectumDis.addSymptom(LR.anusDischargeMucopurulent, "", 0.5f);
chlamydialInfectionRectumDis.addReference("pp 985-7");
chlamydialInfectionRectumDis.setCode358(32);
chlamydialInfectionRectumDis.setICD10code("A69");


// -------------- genitalHerpes --------------
// (C) OntoOO Inc Tue Mar 12 16:45:58 PST 2002
Disease genitalHerpesDis = new Disease(
   LR.genitalHerpes, 
   "acute inflammation of the genitalia by the herpes virus type 2 or 1", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   F.genitalHerpesFreq,
   LR.bodySysSt, 
   LR.none
);
genitalHerpesDis.setSuperDisease(LR.herpesSimplex);
genitalHerpesDis.setPrintName("genital herpes");
genitalHerpesDis.setTemperature((float)101.0); 
genitalHerpesDis.addSymptom(LR.dysuria); 
genitalHerpesDis.addSymptom(LR.malaise); 
genitalHerpesDis.addSymptom(LR.mouthLesion, "", 0.3f); 
genitalHerpesDis.addSymptom(LR.anusLesion, "", 0.1f); 
genitalHerpesDis.addReference("pp 987-9");
Treatment genitalHerpesTr1  = new Treatment("genitalHerpesTr1");
genitalHerpesTr1.addDrug(LR.acyclovir);
genitalHerpesDis.addTreatment(genitalHerpesTr1.getName());


// -------------- genitalHerpesMale --------------
// (C) OntoOO Inc Tue Mar 12 21:39:44 PST 2002
Disease genitalHerpesMaleDis = new Disease(
   LR.genitalHerpesMale, 
   "acute inflammation of the male genitalia by the herpes virus type 2 or 1", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   F.genitalHerpesMaleFreq,
   LR.penisxSysSt, 
   LR.none
);
genitalHerpesMaleDis.setPrintName("male genital herpes");
genitalHerpesMaleDis.setSuperDisease(LR.genitalHerpes);
genitalHerpesMaleDis.addSymptom(LR.penisVesicle);
genitalHerpesMaleDis.addSymptom(LR.penisGlansVesicle);
genitalHerpesMaleDis.addSymptom(LR.foreSkinVesicle);
genitalHerpesMaleDis.setTemperature((float)101.0);
genitalHerpesMaleDis.addReference("pp 987-9");
genitalHerpesMaleDis.setMiscComments(
  "blisters will rupture, become painful ulcers with swollen, yellow oozing centers"); 
genitalHerpesMaleDis.addIllustration(D.HerpesMalePrimaryJpg);
genitalHerpesMaleDis.addIllustration(D.HerpesMaleRecurrentJpg);


// -------------- genitalHerpesFemale --------------
// (C) OntoOO Inc Wed Mar 13 08:39:22 PST 2002
Disease genitalHerpesFemaleDis = new Disease(
   LR.genitalHerpesFemale, 
   "acute inflammation of the female genitalia by the herpes virus type 2 or 1", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   0, //  duration 
   F.genitalHerpesFemaleFreq,
   LR.cervixSysSt, 
   LR.none
);
genitalHerpesFemaleDis.setPrintName("female genital herpes");
genitalHerpesFemaleDis.setSuperDisease(LR.genitalHerpes);
genitalHerpesFemaleDis.addSymptom(LR.cervixVesicle);
genitalHerpesFemaleDis.addSymptom(LR.labiaVesicle, "", 0.3f);
genitalHerpesFemaleDis.addSymptom(LR.vulvaVesicle, "", 0.3f);
genitalHerpesFemaleDis.addSymptom(LR.vaginaVesicle, "", 0.3f);
genitalHerpesFemaleDis.setTemperature((float)101.0);
genitalHerpesFemaleDis.addReference("pp 987-9");
genitalHerpesFemaleDis.setMiscComments(
   "blisters will rupture, become painful ulcers with swollen, yellow oozing centers");
genitalHerpesFemaleDis.addIllustration(D.HerpesFemaleJpg);
genitalHerpesFemaleDis.addIllustration(D.HerpesFemalePrimaryJpg);
genitalHerpesFemaleDis.addIllustration(D.HerpesFemale4DaysLaterJpg);


// -------------- genitalWarts --------------
// (C) OntoOO Inc Wed Mar 13 09:58:45 PST 2002
Disease genitalWartsDis = new Disease(
   LR.genitalWarts, 
   "warts in the genital area", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   12, //  minAge 
   50, //  maxAge 
   -6, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.papillomavirusInfection
);
genitalWartsDis.setPrintName("genital warts");
genitalWartsDis.addSymptom(LR.perineumWarts); 
genitalWartsDis.addReference("pp 989");
genitalWartsDis.setMiscComments("relapse is common");
Treatment genitalWartsTr1  = new Treatment("genitalWartsTr1");
genitalWartsTr1.addDrug(LR.podophyllum);
genitalWartsDis.addTreatment(genitalWartsTr1.getName());
Treatment genitalWartsTr2 = new Treatment("genitalWartsTr2");
genitalWartsTr2.addTreatmentAction(LR.electrocautery);
genitalWartsTr2.addTreatmentAction(LR.carbonDioxideLaser);
genitalWartsTr2.addTreatmentAction(LR.cryosurgery);
genitalWartsDis.addTreatment(genitalWartsTr2.getName()); 


// -------------- genitalWartsFemale --------------
// (C) OntoOO Inc Wed Mar 13 11:10:15 PST 2002
Disease genitalWartsFemaleDis = new Disease(
   LR.genitalWartsFemale, 
   "warts in the female genital area", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   12, //  minAge 
   50, //  maxAge 
   -6, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
genitalWartsFemaleDis.setPrintName("genital warts female");
genitalWartsFemaleDis.setSuperDisease(LR.genitalWarts);
genitalWartsFemaleDis.addSymptom(LR.cervixWarts); 
genitalWartsFemaleDis.addSymptom(LR.vaginaWarts); 
genitalWartsFemaleDis.addSymptom(LR.vulvaWarts); 
genitalWartsFemaleDis.addReference("pp 989");
genitalWartsFemaleDis.setMiscComments("relapse is common");


// -------------- genitalWartsMale --------------
// (C) OntoOO Inc Wed Mar 13 13:43:59 PST 2002
Disease genitalWartsMaleDis = new Disease(
   LR.genitalWartsMale, 
   "warts in the male genital area", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   12, //  minAge 
   50, //  maxAge 
   -6, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.skinSysSt, 
   LR.none
);
genitalWartsMaleDis.setPrintName("genital warts male");
genitalWartsMaleDis.setSuperDisease(LR.genitalWarts);
genitalWartsMaleDis.addSymptom(LR.penisWarts); 
genitalWartsMaleDis.addSymptom(LR.urethraWarts); 
genitalWartsMaleDis.addReference("pp 989");
genitalWartsMaleDis.setMiscComments("relapse is common");


// -------------- syphilis --------------
// (C) OntoOO Inc Wed Mar 13 18:38:20 PST 2002
Disease syphilisDis = new Disease(
   LR.syphilis, 
   "infection by the spirochete treponema pallidum", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   39, //  maxAge 
   -1, //  duration 
   F.syphilisFreq,
   LR.bodySysSt, 
   LR.spirocheteTreponemaPallidumInfection
);
syphilisDis.addSymptom(LR.skinOfGenitalChancre);
syphilisDis.addSymptom(LR.anusChancre, "", 0.2f);
syphilisDis.addSymptom(LR.fingerChancre, "", 0.2f);
syphilisDis.addSymptom(LR.lipChancre, "", 0.2f);
syphilisDis.addSymptom(LR.tongueChancre, "", 0.2f);
syphilisDis.addSymptom(LR.nippleChancre, "", 0.2f);
syphilisDis.addSymptom(LR.tonsilChancre, "", 0.2f);
syphilisDis.addSymptom(LR.eyelidChancre, "", 0.2f);
syphilisDis.addCausesDisease(LR.syphilisSecondary); 
syphilisDis.addReference("pp 989-92");
syphilisDis.setMiscComments("chronic if not treated/ " +
			    "chancres disappear in 3-6 weeks");
Treatment syphilisTr1 = new Treatment("syphilisTr1");
syphilisTr1.addDrug(LR.penicillinG);
syphilisDis.addTreatment(syphilisTr1.getName()); 
syphilisDis.addIllustration(D.SyphilisChancrePenisJpg);
syphilisDis.addIllustration(D.SyphilisChancreVaginaJpg);
syphilisDis.addIllustration(D.SyphilisChancreVagina2Jpg);
syphilisDis.addIllustration(D.SyphilisChancreAnusJpg);
syphilisDis.addIllustration(D.SyphilisChancreChinJpg);
syphilisDis.setCode358(26);
syphilisDis.setICD10code("A50");


// -------------- syphilisSecondary --------------
// (C) OntoOO Inc Wed Mar 13 18:42:48 PST 2002
Disease syphilisSecondaryDis = new Disease(
   LR.syphilisSecondary, 
   "2nd phase infection by the spirochete treponema pallidum", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   39, //  maxAge 
   -1, //  duration 
   F.syphilisSecondaryFreq,
   LR.bodySysSt, 
   LR.spirocheteTreponemaPallidumInfection
);
syphilisSecondaryDis.setPrintName("syphilis 2nd phase");
syphilisSecondaryDis.addSymptom(LR.rash);
syphilisSecondaryDis.addSymptom(LR.rashErupting);
syphilisSecondaryDis.addSymptom(LR.skinLesionPinkWhite, 
				"after a rash enlarges and erodes/ " +
				"they are contagious", 1.0f);
syphilisSecondaryDis.addSymptom(LR.anorexia, "", 1.0f); 
syphilisSecondaryDis.addSymptom(LR.headache, "", 1.0f); 
syphilisSecondaryDis.addSymptom(LR.malaise, "", 1.0f); 
syphilisSecondaryDis.addSymptom(LR.nausea, "", 1.0f); 
syphilisSecondaryDis.addSymptom(LR.weightLoss, "", 1.0f); 
syphilisSecondaryDis.addSymptom(LR.vomiting); 
syphilisSecondaryDis.addSymptom(LR.throatSore);
syphilisSecondaryDis.addSymptom(LR.nailBrittle);
syphilisSecondaryDis.addInternalCause(LR.syphilis); 
syphilisSecondaryDis.addCausesDisease(LR.syphilisLatent); 
syphilisSecondaryDis.addReference("pp 989-92");
syphilisSecondaryDis.setMiscComments(
   "chronic if not treated/ " +
   "symptoms start upto 8 weeks after the chancres of phase 1 appeared (and disappeared)");
syphilisSecondaryDis.addTreatment(syphilisTr1.getName()); 
syphilisSecondaryDis.addIllustration(D.Syphilis2RashPapuloSquamousJpg);
syphilisSecondaryDis.addIllustration(D.Syphilis2RashPapuloPustularJpg);
syphilisSecondaryDis.addIllustration(D.Syphilis2RashHandsJpg);
syphilisSecondaryDis.addIllustration(D.Syphilis2CondylomaLataJpg);
syphilisSecondaryDis.addIllustration(D.Syphilis2RashTorsoJpg);
syphilisSecondaryDis.addIllustration(D.Syphilis2RashChinJpg);
syphilisSecondaryDis.setCode358(26);
syphilisSecondaryDis.setICD10code("A50");

// -------------- syphilisLatent --------------
// (C) OntoOO Inc Fri Mar 15 10:27:47 PST 2002
Disease syphilisLatentDis = new Disease(
   LR.syphilisLatent, 
   "3rd phase infection by the spirochete treponema pallidum", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   F.syphilisLatentFreq,
   LR.bodySysSt, 
   LR.spirocheteTreponemaPallidumInfection
);
syphilisLatentDis.setPrintName("syphilis latent 3rd phase");
syphilisLatentDis.addSymptom(LR.skinLesionPinkWhite, 
			     "upto 4 years after the onset, they are contagious", 1.0f);
syphilisLatentDis.addInternalCause(LR.syphilisSecondary);
syphilisLatentDis.addCausesDisease(LR.syphilisLate); 
syphilisLatentDis.addReference("pp 989-92");
syphilisLatentDis.setMiscComments(
   "chronic if not treated/ absence of symptoms can last for years " +
   "and 2/3 will remain asymptomatic until death");
// Treatment syphilisTr1 = new Treatment("syphilisTr1");
// syphilisTr1.addDrug(LR.penicillinG);
syphilisLatentDis.addTreatment("syphilisTr1");
syphilisLatentDis.setCode358(26);
syphilisLatentDis.setICD10code("A50");


// -------------- syphilisLate --------------
// (C) OntoOO Inc Fri Mar 15 10:51:47 PST 2002
Disease syphilisLateDis = new Disease(
   LR.syphilisLate, 
   "4th phase infection by the spirochete treponema pallidum", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   F.syphilisLateFreq,
   LR.bodySysSt, 
   LR.spirocheteTreponemaPallidumInfection
);
syphilisLateDis.setPrintName("syphilis late 4th phase");
syphilisLateDis.addInternalCause(LR.syphilisLatent);
syphilisLateDis.addReference("pp 989-92");
// Treatment syphilisTr1 = new Treatment("syphilisTr1");
// syphilisTr1.addDrug(LR.penicillinG);
syphilisLateDis.addTreatment("syphilisTr1");
syphilisLateDis.setCode358(26);
syphilisLateDis.setICD10code("A50");


// -------------- syphilisLateBenign --------------
// (C) OntoOO Inc Fri Mar 15 11:14:44 PST 2002
Disease syphilisLateBenignDis = new Disease(
   LR.syphilisLateBenign, 
   "4th phase benign version infection by the spirochete treponema pallidum", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   F.syphilisLateBenignFreq,
   LR.bodySysSt, 
   LR.none
);
syphilisLateBenignDis.setPrintName("syphilis late benign 4th phase");
syphilisLateBenignDis.setSuperDisease(LR.syphilisLate);
syphilisLateBenignDis.addSymptom(LR.skinGumma);
syphilisLateBenignDis.addSymptom(LR.boneGumma);
syphilisLateBenignDis.addSymptom(LR.mucousMembraneGumma);
syphilisLateBenignDis.addSymptom(LR.organGumma);
syphilisLateBenignDis.addSymptom(LR.epigastricPain, "if liver affected", 0.2f); 
syphilisLateBenignDis.addSymptom(LR.liverTender, "if liver affected", 0.2f); 
syphilisLateBenignDis.addSymptom(LR.noseSeptumPerforation, "", 0.1f);
syphilisLateBenignDis.addSymptom(LR.palatePerforation, "", 0.1f);
// syphilisLateBenignDis.addInternalCause(LR.syphilisLatent); // is inherited
syphilisLateBenignDis.addCausesDisease(LR.anemia);
syphilisLateBenignDis.addCausesAbnormalCondition(LR.splenomegaly); 
syphilisLateBenignDis.addReference("pp 989-92");
syphilisLateBenignDis.addIllustration(D.Syphilis4GummaSerpiginousJpg);
syphilisLateBenignDis.addIllustration(D.Syphilis4GummaUlceratingJpg);
syphilisLateBenignDis.setCode358(26);
syphilisLateBenignDis.setICD10code("A50");


// -------------- syphilisLateCardioVascular --------------
// (C) OntoOO Inc Fri Mar 15 14:38:05 PST 2002
Disease syphilisLateCardioVascularDis = new Disease(
   LR.syphilisLateCardioVascular, 
   "4th phase cardio vascular version infection by the spirochete treponema pallidum", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   F.syphilisLateCardioVascularFreq,
   LR.cardioVascularSysSt, 
   LR.none
);
syphilisLateCardioVascularDis.setPrintName("syphilis late cardio vascular 4th phase");
syphilisLateCardioVascularDis.setSuperDisease(LR.syphilisLate);
syphilisLateCardioVascularDis.addCausesDisease(LR.thoracicAortaAneurysm);
syphilisLateCardioVascularDis.addCausesDisease(LR.aortaInsufficiency);
syphilisLateCardioVascularDis.addReference("pp 989-92");
syphilisLateCardioVascularDis.setMiscComments(
   "this variant develops after 10 years in 10% of the untreated patients");
syphilisLateCardioVascularDis.addIllustration(D.Syphilis4CardioAortaNarrowingJpg);
syphilisLateCardioVascularDis.setCode358(27);
syphilisLateCardioVascularDis.setICD10code("A52");


// -------------- syphilisLateNeurologic --------------
// (C) OntoOO Inc Fri Mar 15 22:33:06 PST 2002
Disease syphilisLateNeurologicDis = new Disease(
   LR.syphilisLateNeurologic, 
   "4th phase neurologic version infection by the spirochete treponema pallidum", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   F.syphilisLateNeurologicFreq,
   LR.neurologicSysSt, 
   LR.none
);
syphilisLateNeurologicDis.setPrintName("syphilis late neurologic 4th phase");
syphilisLateNeurologicDis.setSuperDisease(LR.syphilisLate);
syphilisLateNeurologicDis.addSymptom(LR.armWeakness); 
syphilisLateNeurologicDis.addSymptom(LR.legWeakness); 
syphilisLateNeurologicDis.addSymptom(LR.paralysis);
syphilisLateNeurologicDis.addSymptom(LR.personalityChange);
syphilisLateNeurologicDis.addCausesDisease(LR.meningitis); 
syphilisLateNeurologicDis.addReference("pp 989-92");
syphilisLateNeurologicDis.setMiscComments(
   "this variant develops after 5-35 years in 8% of the untreated patients");
syphilisLateNeurologicDis.addIllustration(D.Syphilis4NeuralTissueSpirochetesJpg);
syphilisLateNeurologicDis.setCode358(28);
syphilisLateNeurologicDis.setICD10code("A52");


// -------------- trichomoniasis --------------
// (C) OntoOO Inc Sat Mar 16 17:15:24 PST 2002
Disease trichomoniasisDis = new Disease(
   LR.trichomoniasis, 
   "protozoal infection of the genitourinary tract", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -5, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.protozoanInfection
);
trichomoniasisDis.addReference("pp 992-4");
Treatment trichomoniasisTr1 = new Treatment("trichomoniasisTr1");
trichomoniasisTr1.addDrug(LR.metronidazole);
trichomoniasisDis.addTreatment(trichomoniasisTr1.getName()); 


// -------------- trichomoniasisFemale --------------
// (C) OntoOO Inc Sun Mar 17 15:10:12 PST 2002
Disease trichomoniasisFemaleDis = new Disease(
   LR.trichomoniasisFemale, 
   "protozoal infection of the female genitourinary tract", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -5, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
trichomoniasisFemaleDis.setPrintName("trichomoniasis female");
trichomoniasisFemaleDis.setSuperDisease(LR.trichomoniasis);
trichomoniasisFemaleDis.addSymptom(LR.dysuria, "", 1.0f); 
trichomoniasisFemaleDis.addSymptom(LR.urinaryFrequency, "", 1.0f); 
trichomoniasisFemaleDis.addSymptom(LR.vaginaRed, "", 1.0f); 
trichomoniasisFemaleDis.addSymptom(LR.vaginaSwollen, "", 1.0f); 
trichomoniasisFemaleDis.addSymptom(LR.vaginaDischargeFrothy, "", 0.5f); 
trichomoniasisFemaleDis.addSymptom(LR.vaginaDischargeProfuse, "", 0.5f); 
trichomoniasisFemaleDis.addSymptom(LR.vaginaDischargeGrayFoulFishySmelling, "", 0.5f); 
trichomoniasisFemaleDis.addSymptom(LR.vaginaItching, "", 1.0f); 
trichomoniasisFemaleDis.addSymptom(LR.vaginaTenderness, "", 1.0f); 
trichomoniasisFemaleDis.addCausesDisease(LR.dyspareunia); 
trichomoniasisFemaleDis.addCausesDisease(LR.dysmenorrhea); 
trichomoniasisFemaleDis.addCausesDisease(LR.menorrhagia); 
trichomoniasisFemaleDis.addReference("pp 992-4");


// -------------- trichomoniasisMale --------------
// (C) OntoOO Inc Sun Mar 17 20:43:15 PST 2002
Disease trichomoniasisMaleDis = new Disease(
   LR.trichomoniasisMale, 
   "protozoal infection of the male genitourinary tract", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -5, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.bodySysSt, 
   LR.none
);
trichomoniasisMaleDis.setPrintName("trichomoniasis male");
trichomoniasisMaleDis.setSuperDisease(LR.trichomoniasis);
trichomoniasisMaleDis.addSymptom(LR.dysuria, "", 1.0f);
trichomoniasisMaleDis.addSymptom(LR.urethraMaleDischargePurulent, "", 0.05f);
trichomoniasisMaleDis.addSymptom(LR.urinaryBurning, "", 1.0f);
trichomoniasisMaleDis.addSymptom(LR.urinaryFrequency, "", 1.0f);
trichomoniasisMaleDis.addCausesDisease(LR.urethritisML);
trichomoniasisMaleDis.addReference("pp 992-4");


// -------------- chancroid --------------
// (C) OntoOO Inc Mon Mar 18 09:39:58 PST 2002
Disease chancroidDis = new Disease(
   LR.chancroid, 
   "genital ulcer due to sexual transmitted infection", 
   LR.sexualDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.haemophilusDucreyiInfection
);
chancroidDis.addSymptom(LR.groinPapule, "", 0.4f);
chancroidDis.addSymptom(LR.thighPapule, "", 0.4f);
chancroidDis.addSymptom(LR.tonguePapule, "", 0.01f);
chancroidDis.addSymptom(LR.lipPapule, "", 0.01f);
chancroidDis.addSymptom(LR.navelPapule, "", 0.01f);
// chancroidDis.addSymptom(LR.headache, "", 0.5f);
// chancroidDis.addSymptom(LR.malaise, "", 0.5f);
chancroidDis.addCausesDisease(LR.chancroidPhase2);
chancroidDis.addReference("pp 994-5");
chancroidDis.setMiscComments("common in tropical countries");
Treatment chancroidTr1 = new Treatment("chancroidTr1");
chancroidTr1.addDrug(LR.azithromycin);
chancroidDis.addTreatment(chancroidTr1.getName()); 


// -------------- chancroidMale --------------
// (C) OntoOO Inc Mon Mar 18 11:43:58 PST 2002
Disease chancroidMaleDis = new Disease(
   LR.chancroidMale, 
   "genital ulcer due to sexual transmitted infection", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
chancroidMaleDis.setPrintName("chancroid male");
chancroidMaleDis.setSuperDisease(LR.chancroid);
chancroidMaleDis.addSymptom(LR.penisPapule, "", 0.1f);
chancroidMaleDis.addReference("pp 994-5");
chancroidMaleDis.setMiscComments("common in tropical countries");
chancroidMaleDis.addIllustration(D.ChancroidPenisUlcersJpg);
chancroidMaleDis.addIllustration(D.ChancroidPenisRupturedPapuleJpg);


// -------------- chancroidFemale --------------
// (C) OntoOO Inc Mon Mar 18 11:49:49 PST 2002
Disease chancroidFemaleDis = new Disease(
   LR.chancroidFemale, 
   "genital ulcer due to sexual transmitted infection", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
chancroidFemaleDis.setPrintName("chancroid female");
chancroidFemaleDis.setSuperDisease(LR.chancroid);
chancroidFemaleDis.addSymptom(LR.vulvaPapule, "", 0.08f);
chancroidFemaleDis.addSymptom(LR.vaginaPapule, "", 0.02f);
chancroidFemaleDis.addSymptom(LR.cervixPapule, "", 0.02f);
chancroidFemaleDis.addSymptom(LR.breastPapule, "", 0.01f);
chancroidFemaleDis.addReference("pp 994-5");
chancroidFemaleDis.setMiscComments("common in tropical countries");


// -------------- chancroidPhase2 --------------
// (C) OntoOO Inc Mon Mar 18 12:11:08 PST 2002
Disease chancroidPhase2Dis = new Disease(
   LR.chancroidPhase2, 
   "genital ulcer due to sexual transmitted infection", 
   LR.sexualDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -4, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.haemophilusDucreyiInfection
);
chancroidPhase2Dis.setPrintName("chancroid phase 2");
chancroidPhase2Dis.addSymptom(LR.headache, "", 0.5f);
chancroidPhase2Dis.addSymptom(LR.malaise, "", 0.5f);
chancroidPhase2Dis.addSymptom(LR.papuleUlcerated, 
			      "see preceding chancroid disease", 1.0f);
chancroidPhase2Dis.addSymptom(LR.ulcerPainful);
chancroidPhase2Dis.addSymptom(LR.ulcerSoft);
chancroidPhase2Dis.addSymptom(LR.ulcerMalodorous);
chancroidPhase2Dis.addSymptom(LR.ulcerBleedsEasily);
chancroidPhase2Dis.addSymptom(LR.ulcerGray);
chancroidPhase2Dis.addSymptom(LR.ulcerShallow);
chancroidPhase2Dis.addSymptom(LR.groinAdenitis, "within 2-3 weeks", 1.0f);
chancroidPhase2Dis.addSymptom(LR.groinLymphNodeRuptured);
chancroidPhase2Dis.addInternalCause(LR.chancroid);
chancroidPhase2Dis.addReference("pp 994-5");
chancroidPhase2Dis.setMiscComments("common in tropical countries");
// Treatment chancroidTr1 = new Treatment("chancroidTr1");
// chancroidTr1.addDrug(LR.azithromycin);
chancroidPhase2Dis.addTreatment("chancroidTr1");
chancroidPhase2Dis.addIllustration(D.ChancroidPenisUlcersJpg);
chancroidPhase2Dis.addIllustration(D.ChancroidPenisRupturedPapuleJpg);


// -------------- arousalDisorder --------------
// (C) OntoOO Inc Mon Mar 18 19:34:32 PST 2002
Disease arousalDisorderDis = new Disease(
   LR.arousalDisorder, 
   "inability to attain or maintain an adequate lubrication-swelling " +
   "response of sexual excitement", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
arousalDisorderDis.setPrintName("arousal disorder");
arousalDisorderDis.addSymptom(LR.sexualDesireAbsent);
arousalDisorderDis.addSymptom(LR.sexualStimulationIgnored);
arousalDisorderDis.addReference("pp 996-8");
Treatment arousalDisorderTr1 = new Treatment("arousalDisorderTr1");
arousalDisorderTr1.addTreatmentAction(LR.MasterAndJohnsonTherapy);
arousalDisorderTr1.addTreatmentAction(LR.psychoanalyticTherapy);
arousalDisorderTr1.addTreatmentAction(LR.behaviorTherapy);
arousalDisorderDis.addTreatment(arousalDisorderTr1.getName()); 


// -------------- orgasmicDisorder --------------
// (C) OntoOO Inc Mon Mar 18 20:48:59 PST 2002
Disease orgasmicDisorderDis = new Disease(
   LR.orgasmicDisorder, 
   "delay or absence of orgasm after a sexual excitement phase ", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
orgasmicDisorderDis.setPrintName("orgasmic disorder");
orgasmicDisorderDis.addSymptom(LR.orgasmUnachievable);
orgasmicDisorderDis.addReference("pp 996-8");
Treatment orgasmicDisorderTr1  = new Treatment("orgasmicDisorderTr1");
orgasmicDisorderTr1.addTreatmentAction(LR.behaviorTherapy);
orgasmicDisorderTr1.addTreatmentAction(LR.psychoanalyticTherapy);
orgasmicDisorderTr1.addTreatmentAction(LR.experientialTherapy);
orgasmicDisorderDis.addTreatment(orgasmicDisorderTr1.getName());


// -------------- dyspareunia --------------
// (C) OntoOO Inc Tue Mar 19 12:48:29 PST 2002
Disease dyspareuniaDis = new Disease(
   LR.dyspareunia, 
   "genital pain associated with intercourse", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
dyspareuniaDis.addSymptom(LR.intercourseDiscomfort);
dyspareuniaDis.addSymptom(LR.vaginaBurning);
dyspareuniaDis.addSymptom(LR.vaginaItching);
dyspareuniaDis.addExternalCause(LR.physicalProblem);
dyspareuniaDis.addExternalCause(LR.psychologicalProblem);
dyspareuniaDis.addInternalCause(LR.chlamydialInfectionCervix);
dyspareuniaDis.addInternalCause(LR.ovariesCysts);
dyspareuniaDis.addInternalCause(LR.trichomoniasisFemale);
dyspareuniaDis.addReference("pp 998-9");
dyspareuniaDis.setMiscComments(
   "there are numerous physiological and psychological causes ");
Treatment dyspareuniaTr1 = new Treatment("dyspareuniaTr1", LR.ifLubricationProblem);
dyspareuniaTr1.addTreatmentAction(LR.creamsOrGels);
dyspareuniaDis.addTreatment(dyspareuniaTr1.getName()); 
Treatment dyspareuniaTr2 = new Treatment("dyspareuniaTr2", LR.ifInfection);
dyspareuniaTr2.addDrug(LR.antibiotics);
dyspareuniaTr2.addDrug(LR.antimicrobials);
dyspareuniaDis.addTreatment(dyspareuniaTr2.getName()); 
Treatment dyspareuniaTr3 = new Treatment("dyspareuniaTr3", LR.ifHymenalScars);
dyspareuniaTr3.addTreatmentAction(LR.excision);
dyspareuniaDis.addTreatment(dyspareuniaTr3.getName()); 
Treatment dyspareuniaTr4 = new Treatment("dyspareuniaTr4", LR.ifPsychologicalProblem);
dyspareuniaTr4.addTreatmentAction(LR.behaviorTherapy);
dyspareuniaTr4.addTreatmentAction(LR.education);
dyspareuniaDis.addTreatment(dyspareuniaTr4.getName()); 


// -------------- vaginismus --------------
// (C) OntoOO Inc Tue Mar 19 15:58:11 PST 2002
Disease vaginismusDis = new Disease(
   LR.vaginismus, 
   "involuntary spastic constriction of the lower vaginal muscles, " +
   "usually from fear of vaginal penetration", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.physicalProblem
);
vaginismusDis.addExternalCause(LR.psychologicalProblem);
vaginismusDis.addSymptom(LR.vaginaMuscleSpasm, "if object inserted", 1.0f);
vaginismusDis.addSymptom(LR.sexualDesireAbsent, "", 0.5f);
vaginismusDis.addReference("pp 999-1000");
Treatment vaginismusTr1  = new Treatment("vaginismusTr1", LR.ifPsychologicalProblem);
vaginismusTr1.addTreatmentAction(LR.MasterAndJohnsonTherapy);
vaginismusTr1.addTreatmentAction(LR.behaviorTherapy);
vaginismusDis.addTreatment(vaginismusTr1.getName());


// -------------- erectionDisorder --------------
// (C) OntoOO Inc Wed Mar 20 09:27:09 PST 2002
Disease erectionDisorderDis = new Disease(
   LR.erectionDisorder, 
   "inability to attain or maintain an erection sufficient to complete intercourse", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.penisxSysSt, 
   LR.physicalProblem
);
erectionDisorderDis.setPrintName("erection disorder");
erectionDisorderDis.addSymptom(LR.erectionFailure);
erectionDisorderDis.addExternalCause(LR.psychologicalProblem);
erectionDisorderDis.addReference("pp 1000-1");
erectionDisorderDis.setMiscComments("multiple causes can contribute");
Treatment erectionDisorderTr1  = 
  new Treatment("erectionDisorderTr1", LR.ifPsychologicalProblem);
erectionDisorderTr1.addTreatmentAction(LR.sexTherapy);
erectionDisorderDis.addTreatment(erectionDisorderTr1.getName());
Treatment erectionDisorderTr2 = 
  new Treatment("erectionDisorderTr2", LR.ifPhysicalProblem);
erectionDisorderTr2.addTreatmentAction(LR.surgery);
erectionDisorderDis.addTreatment(erectionDisorderTr2.getName()); 


// -------------- hypogonadism --------------
// (C) OntoOO Inc Wed Mar 20 11:52:34 PST 2002
Disease hypogonadismDis = new Disease(
   LR.hypogonadism, 
   "condition causing infertility and inhibits secondary sex characteristics", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.endocrineSysSt, 
   LR.none
);
hypogonadismDis.addSymptom(LR.boneAgeImmature);
hypogonadismDis.addSymptom(LR.pubertyDelayed);
hypogonadismDis.addSymptom(LR.penisInfantile);
hypogonadismDis.addSymptom(LR.testicleSoft);
hypogonadismDis.addSymptom(LR.muscleUnderdeveloped);
hypogonadismDis.addSymptom(LR.muscleWeakness);
hypogonadismDis.addSymptom(LR.faceHairSparse);
hypogonadismDis.addSymptom(LR.bodyHairSparse);
hypogonadismDis.addSymptom(LR.sexDriveLow);
hypogonadismDis.addReference("pp 1001-3");
Treatment hypogonadismTr1  = new Treatment("hypogonadismTr1");
hypogonadismTr1.addTreatmentAction(LR.hormoneTherapy);
hypogonadismTr1.addDrug(LR.gonadotropin);
hypogonadismTr1.addDrug(LR.testosterone);
hypogonadismDis.addTreatment(hypogonadismTr1.getName());


// -------------- undescendedTestes --------------
// (C) OntoOO Inc Fri Mar 22 16:15:14 PST 2002
Disease undescendedTestesDis = new Disease(
   LR.undescendedTestes, 
   "one or both testicles did not descend", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.testesSysSt, 
   LR.congenital
);
undescendedTestesDis.setPrintName("undescended testes");
undescendedTestesDis.addSymptom(LR.infertilityMaleSymptom);
undescendedTestesDis.addReference("pp 1003-4");
Treatment undescendedTestesTr1  = new Treatment("undescendedTestesTr1");
undescendedTestesTr1.addTreatmentAction(LR.surgery);
undescendedTestesDis.addTreatment(undescendedTestesTr1.getName());


// -------------- prematureEjaculation --------------
// (C) OntoOO Inc Sat Mar 23 10:59:04 PST 2002
Disease prematureEjaculationDis = new Disease(
   LR.prematureEjaculation, 
   "premature ejaculation", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   12, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
prematureEjaculationDis.setPrintName();
prematureEjaculationDis.addSymptom(LR.prematureEjaculationSymptom);
prematureEjaculationDis.addReference("pp 1004-5");
Treatment prematureEjaculationTr1  = new Treatment("prematureEjaculationTr1");
prematureEjaculationTr1.addTreatmentAction(LR.MasterAndJohnsonTherapy);
prematureEjaculationDis.addTreatment(prematureEjaculationTr1.getName());


// -------------- testicleTorsion --------------
// (C) OntoOO Inc Sun Mar 24 17:01:18 PST 2002
Disease testicleTorsionDis = new Disease(
   LR.testicleTorsion, 
   "abnormal twisting of the spermatic cord", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   12, //  minAge 
   18, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.testesSysSt, 
   LR.none
);
testicleTorsionDis.setPrintName("testicle torsion");
testicleTorsionDis.addSymptom(LR.testiclePain);
testicleTorsionDis.addReference("pp 1005-6");
Treatment testicleTorsionTr1  = new Treatment("testicleTorsionTr1");
testicleTorsionTr1.addTreatmentAction(LR.surgery);
testicleTorsionDis.addTreatment(testicleTorsionTr1.getName());


// -------------- infertilityMale --------------
// (C) OntoOO Inc Sun Mar 24 17:26:04 PST 2002
Disease infertilityMaleDis = new Disease(
   LR.infertilityMale, 
   "male infertility", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -11, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
infertilityMaleDis.setPrintName();
infertilityMaleDis.addSymptom(LR.infertilityMaleSymptom);
infertilityMaleDis.addReference("pp 1006-7");
infertilityMaleDis.setMiscComments("Causes are hormonal, anatomic and psychosocial");
Treatment infertilityMaleTr1 = 
  new Treatment("infertilityMaleTr1", LR.ifPhysicalProblem);
infertilityMaleTr1.addTreatmentAction(LR.surgery);
infertilityMaleDis.addTreatment(infertilityMaleTr1.getName()); 
Treatment infertilityMaleTr2 = 
  new Treatment("infertilityMaleTr2", LR.ifPsychologicalProblem);
infertilityMaleTr2.addTreatmentAction(LR.education);
infertilityMaleTr2.addTreatmentAction(LR.sexTherapy);
infertilityMaleDis.addTreatment(infertilityMaleTr2.getName()); 
Treatment infertilityMaleTr3 = new Treatment("infertilityMaleTr3");
infertilityMaleTr3.addDrug(LR.gonadotropin);
infertilityMaleTr3.addDrug(LR.testosterone);
infertilityMaleDis.addTreatment(infertilityMaleTr3.getName()); 


// -------------- precociousPubertyMale --------------
// (C) OntoOO Inc Sun Mar 24 18:55:11 PST 2002
Disease precociousPubertyMaleDis = new Disease(
   LR.precociousPubertyMale, 
   "sexual development before age 10", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   10, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
precociousPubertyMaleDis.setPrintName("precocious puberty male");
precociousPubertyMaleDis.addSymptom(LR.boneDevelopmentEarly);
precociousPubertyMaleDis.addSymptom(LR.muscleDevelopmentEarly);
precociousPubertyMaleDis.addSymptom(LR.adultHairPattern);
precociousPubertyMaleDis.addSymptom(LR.penisGrowth);
// precociousPubertyMaleDis.addSymptom(LR.testiclesEnlarged);
precociousPubertyMaleDis.addReference("pp 1007-9");


// -------------- precociousPubertyMaleConstitutional --------------
// (C) OntoOO Inc Thu Mar 28 16:32:53 PST 2002
Disease precociousPubertyMaleConstitutionalDis = new Disease(
   LR.precociousPubertyMaleConstitutional, 
   "sexual development before age 10 due to the constitution", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   10, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.constitutional
);
precociousPubertyMaleConstitutionalDis.setPrintName(
   "precocious puberty male constitutional");
precociousPubertyMaleConstitutionalDis.setSuperDisease(LR.precociousPubertyMale);
precociousPubertyMaleConstitutionalDis.setGenetic("father");
precociousPubertyMaleConstitutionalDis.setParentDisease(
   LR.precociousPubertyMaleConstitutional);
precociousPubertyMaleConstitutionalDis.addSymptom(LR.testiclesEnlarged);
precociousPubertyMaleConstitutionalDis.addReference("pp 1007-9");
Treatment precociousPubertyMaleConstitutionalTr1 =
   new Treatment("precociousPubertyMaleConstitutionalTr1");
precociousPubertyMaleConstitutionalTr1.addTreatmentAction(LR.psychologicalCounseling);
precociousPubertyMaleConstitutionalDis.addTreatment(
   precociousPubertyMaleConstitutionalTr1.getName());


// -------------- precociousPubertyMaleCerebral --------------
// (C) OntoOO Inc Thu Mar 28 17:03:17 PST 2002
Disease precociousPubertyMaleCerebralDis = new Disease(
   LR.precociousPubertyMaleCerebral, 
   "sexual development before age 10", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   10, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
precociousPubertyMaleCerebralDis.setPrintName("precocious puberty male cerebral");
precociousPubertyMaleCerebralDis.setSuperDisease(LR.precociousPubertyMale);
precociousPubertyMaleCerebralDis.addSymptom(LR.testiclesEnlarged, "", 1.0f);
precociousPubertyMaleCerebralDis.addSymptom(LR.headache);
precociousPubertyMaleCerebralDis.addSymptom(LR.nausea);
precociousPubertyMaleCerebralDis.addSymptom(LR.vomiting);
precociousPubertyMaleCerebralDis.addSymptom(LR.ocularDisturbance);
precociousPubertyMaleCerebralDis.addCausesDisease(LR.hydrocephalus);
precociousPubertyMaleCerebralDis.addCausingAbnormalCondition(LR.brainLesion);
precociousPubertyMaleCerebralDis.addReference("pp 1007-9");
precociousPubertyMaleCerebralDis.setMiscComments(
   "pituiary or hypothalamic lesions cause excessive gonadotropin");
Treatment precociousPubertyMaleCerebralTr1  = 
   new Treatment("precociousPubertyMaleCerebralTr1", LR.ifBrainTumor);
precociousPubertyMaleCerebralTr1.addTreatmentAction(LR.neurosurgery);
precociousPubertyMaleCerebralDis.addTreatment(
   precociousPubertyMaleCerebralTr1.getName());


// -------------- precociousPubertyMaleTumor --------------
// (C) OntoOO Inc Fri Mar 29 09:49:52 PST 2002
Disease precociousPubertyMaleTumorDis = new Disease(
   LR.precociousPubertyMaleTumor, 
   "sexual development before age 10", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   10, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
precociousPubertyMaleTumorDis.setPrintName("precocious puberty male tumor");
precociousPubertyMaleTumorDis.setSuperDisease(LR.precociousPubertyMale);
precociousPubertyMaleTumorDis.addSymptom(LR.testiclesEnlarged, "", 1.0f);
precociousPubertyMaleTumorDis.addSymptom(LR.acne, "", 1.0f);
precociousPubertyMaleTumorDis.addSymptom(LR.testicleSizeDiffer, "", 0.8f);
precociousPubertyMaleTumorDis.addSymptom(LR.testicleNodule, "", 0.5f);
precociousPubertyMaleTumorDis.addReference("pp 1007-9");
Treatment precociousPubertyMaleTumorTr1  = new Treatment("precociousPubertyMaleTumorTr1");
precociousPubertyMaleTumorTr1.addTreatmentAction(LR.surgery);
precociousPubertyMaleTumorDis.addTreatment(precociousPubertyMaleTumorTr1.getName());


// -------------- precociousPubertyMaleAdrenogenital --------------
// (C) OntoOO Inc Fri Mar 29 10:47:00 PST 2002
Disease precociousPubertyMaleAdrenogenitalDis = new Disease(
   LR.precociousPubertyMaleAdrenogenital, 
   "sexual development before age 10", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   10, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
precociousPubertyMaleAdrenogenitalDis.setPrintName(
   "precocious puberty male due to adrenogenital disorder");
precociousPubertyMaleAdrenogenitalDis.setSuperDisease(LR.precociousPubertyMale);
precociousPubertyMaleAdrenogenitalDis.addSymptom(LR.skinToneAdult);
precociousPubertyMaleAdrenogenitalDis.addSymptom(LR.voiceDeepened);
precociousPubertyMaleAdrenogenitalDis.addSymptom(LR.scrotumEnlarged);
precociousPubertyMaleAdrenogenitalDis.addCausesAbnormalCondition(LR.prostateEnlarged);
precociousPubertyMaleAdrenogenitalDis.setUnderlyingDisease(LR.adrenogenitalSyndrome);
precociousPubertyMaleAdrenogenitalDis.addReference("pp 1007-9");
Treatment precociousPubertyMaleAdrenogenitalTr1  = 
   new Treatment("precociousPubertyMaleAdrenogenitalTr1");
precociousPubertyMaleAdrenogenitalTr1.addDrug(LR.glucocorticoids);
precociousPubertyMaleAdrenogenitalDis.addTreatment(
   precociousPubertyMaleAdrenogenitalTr1.getName());


// -------------- precociousPubertyFemale --------------
// (C) OntoOO Inc Mon Apr 01 20:49:07 PST 2002
Disease precociousPubertyFemaleDis = new Disease(
   LR.precociousPubertyFemale, 
   "sexual development before age 9", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   9, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
precociousPubertyFemaleDis.setPrintName("precocious puberty female");
precociousPubertyFemaleDis.setStatusCondition("premenstruating");
precociousPubertyFemaleDis.addSymptom(LR.growthRapid);
precociousPubertyFemaleDis.addSymptom(LR.breastDevelopment);
precociousPubertyFemaleDis.addSymptom(LR.pubisHairDevelopment);
precociousPubertyFemaleDis.addSymptom(LR.menarcheEarly);
precociousPubertyFemaleDis.addReference("pp 928-9");


// -------------- precociousPubertyFemaleConstitutional --------------
// (C) OntoOO Inc Tue Apr 02 07:58:32 PST 2002
Disease precociousPubertyFemaleConstitutionalDis = new Disease(
   LR.precociousPubertyFemaleConstitutional, 
   "sexual development before age 9 due to constitution", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   9, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.constitutional
);
precociousPubertyFemaleConstitutionalDis.setPrintName(
   "precocious puberty female constitution");
precociousPubertyFemaleConstitutionalDis.setSuperDisease(LR.precociousPubertyFemale);
precociousPubertyFemaleConstitutionalDis.setStatusCondition("premenstruating");
// growth spurt
precociousPubertyFemaleConstitutionalDis.addReference("pp 928-9");
Treatment precociousPubertyFemaleConstitutionalTr1  = 
   new Treatment("precociousPubertyFemaleConstitutionalTr1");
precociousPubertyFemaleConstitutionalTr1.addDrug(LR.medroxyprogesterone);
precociousPubertyFemaleConstitutionalDis.addTreatment(
   precociousPubertyFemaleConstitutionalTr1.getName());


// -------------- precociousPubertyFemaleAdrenogenital --------------
// (C) OntoOO Inc Tue Apr 02 08:09:03 PST 2002
Disease precociousPubertyFemaleAdrenogenitalDis = new Disease(
   LR.precociousPubertyFemaleAdrenogenital, 
   "sexual development before age 9 due to adrenogenital syndrome", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   9, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
precociousPubertyFemaleAdrenogenitalDis.setPrintName(
   "precocious puberty female adrenogenital");
precociousPubertyFemaleAdrenogenitalDis.setSuperDisease(LR.precociousPubertyFemale);
precociousPubertyFemaleAdrenogenitalDis.setStatusCondition("premenstruating");
precociousPubertyFemaleAdrenogenitalDis.addSymptom(LR.clitorisEnlarged);
// precociousPubertyFemaleAdrenogenitalDis.addSymptom(LR.infertilityFemaleSymptom);
precociousPubertyFemaleAdrenogenitalDis.setUnderlyingDisease(LR.adrenogenitalSyndrome);
precociousPubertyFemaleAdrenogenitalDis.addCausesAbnormalCondition(LR.anovulation);
precociousPubertyFemaleAdrenogenitalDis.addReference("pp 928-9");
Treatment precociousPubertyFemaleAdrenogenitalTr1  = 
   new Treatment("precociousPubertyFemaleAdrenogenitalTr1");
precociousPubertyFemaleAdrenogenitalTr1.addDrug(LR.corticosteroids);
precociousPubertyFemaleAdrenogenitalDis.addTreatment(
   precociousPubertyFemaleAdrenogenitalTr1.getName());


// -------------- precociousPubertyFemaleCerebral --------------
// (C) OntoOO Inc Tue Apr 02 22:19:00 PST 2002
Disease precociousPubertyFemaleCerebralDis = new Disease(
   LR.precociousPubertyFemaleCerebral, 
   "sexual development before age 9", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   9, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
precociousPubertyFemaleCerebralDis.setPrintName("precocious puberty female cerebral");
precociousPubertyFemaleCerebralDis.setSuperDisease(LR.precociousPubertyFemale);
precociousPubertyFemaleCerebralDis.setStatusCondition("premenstruating");
precociousPubertyFemaleCerebralDis.addSymptom(LR.acne);
precociousPubertyFemaleCerebralDis.addCausesDisease(LR.hydrocephalus);
precociousPubertyFemaleCerebralDis.addCausingAbnormalCondition(LR.brainLesion);
precociousPubertyFemaleCerebralDis.addReference("pp 928-9");
precociousPubertyFemaleCerebralDis.setMiscComments(
   "pituiary or hypothalamic lesions cause excessive gonadotropin");
Treatment precociousPubertyFemaleCerebralTr1 = 
   new Treatment("precociousPubertyFemaleCerebralTr1", LR.ifBrainTumor);
precociousPubertyFemaleCerebralTr1.addTreatmentAction(LR.neurosurgery);
precociousPubertyFemaleCerebralDis.addTreatment("precociousPubertyFemaleCerebralTr1");


// -------------- precociousPubertyFemaleTumor --------------
// (C) OntoOO Inc Tue Apr 02 22:33:06 PST 2002
Disease precociousPubertyFemaleTumorDis = new Disease(
   LR.precociousPubertyFemaleTumor, 
   "sexual development before age 9", 
   LR.sexualDisorders, 
   LR.female, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   9, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
precociousPubertyFemaleTumorDis.setPrintName("precocious puberty female tumor");
precociousPubertyFemaleTumorDis.setSuperDisease(LR.precociousPubertyFemale);
precociousPubertyFemaleTumorDis.setStatusCondition("premenstruating");
precociousPubertyFemaleTumorDis.addInternalCause(LR.choriocarcinoma);
precociousPubertyFemaleTumorDis.addCausingAbnormalCondition(LR.ovariesTumor);
precociousPubertyFemaleTumorDis.addCausingAbnormalCondition(LR.adrenalTumor);
precociousPubertyFemaleTumorDis.addReference("pp 928-9");
Treatment precociousPubertyFemaleTumorTr1  = new Treatment("precociousPubertyFemaleTumorTr1");
precociousPubertyFemaleTumorTr1.addTreatmentAction(LR.surgery);
precociousPubertyFemaleTumorDis.addTreatment(precociousPubertyFemaleTumorTr1.getName());


// -------------- genderIdentityDisorder --------------
// (C) OntoOO Inc Wed Apr 03 19:53:11 PST 2002
Disease genderIdentityDisorderDis = new Disease(
   LR.genderIdentityDisorder, 
   "discomfort with the assigned gender leading to a desire being the opposite gender", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   5, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
genderIdentityDisorderDis.setPrintName("gender identity disorder");
genderIdentityDisorderDis.addSymptom(LR.sexChangeDesire);
genderIdentityDisorderDis.addReference("pp 1009-10");
Treatment genderIdentityDisorderTr1  = new Treatment("genderIdentityDisorderTr1");
genderIdentityDisorderTr1.addTreatmentAction(LR.psychologicalCounseling);
genderIdentityDisorderDis.addTreatment(genderIdentityDisorderTr1.getName());
Treatment genderIdentityDisorderTr2 = 
  new Treatment("genderIdentityDisorderTr2", LR.ifSuicidal);
genderIdentityDisorderTr2.addTreatmentAction(LR.hospitalization);
genderIdentityDisorderDis.addTreatment(genderIdentityDisorderTr2.getName()); 
Treatment genderIdentityDisorderTr3 = new Treatment("genderIdentityDisorderTr3");
genderIdentityDisorderTr3.addTreatmentAction(LR.perhapsSurgery);
genderIdentityDisorderDis.addTreatment(genderIdentityDisorderTr3.getName()); 


// -------------- paraphilias --------------
// (C) OntoOO Inc Wed Apr 03 21:05:13 PST 2002
Disease paraphiliasDis = new Disease(
   LR.paraphilias, 
   "dependence on unusual behaviors or fantasies to obtain sexual excitement", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   0, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
paraphiliasDis.addReference("pp 1010-3");
Treatment paraphiliasTr1 = new Treatment("paraphiliasTr1");
paraphiliasTr1.addTreatmentAction(LR.behaviorTherapy);
paraphiliasTr1.addTreatmentAction(LR.psychologicalCounseling);
paraphiliasTr1.addTreatmentAction(LR.surgery);
paraphiliasTr1.addTreatmentAction(LR.pharmacotherapy);
paraphiliasDis.addTreatment(paraphiliasTr1.getName()); 


// -------------- exhibitionism --------------
// (C) OntoOO Inc Sat Apr 06 20:57:50 PST 2002
Disease exhibitionismDis = new Disease(
   LR.exhibitionism, 
   "public exposure of genitalia thereby seeking sexual gratification", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
exhibitionismDis.setSuperDisease(LR.paraphilias);
exhibitionismDis.addSymptom(LR.genitaliaExposureToStrangers);
exhibitionismDis.addReference("pp 1010-3");


// -------------- fetishism --------------
// (C) OntoOO Inc Sun Apr 07 20:00:38 PDT 2002
Disease fetishismDis = new Disease(
   LR.fetishism, 
   "obtaining sexual arousal from an inanimate object - usually clothing", 
   LR.sexualDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
fetishismDis.setSuperDisease(LR.paraphilias);
fetishismDis.addSymptom(LR.sexualArousalFromInanimateObjects);
fetishismDis.addReference("pp 1010-3");


// -------------- frotteurism --------------
// (C) OntoOO Inc Sun Apr 07 20:24:51 PDT 2002
Disease frotteurismDis = new Disease(
   LR.frotteurism, 
   "obtaining sexual arousal by touching a nonconsenting person", 
   LR.sexualDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   25, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
frotteurismDis.setSuperDisease(LR.paraphilias);
frotteurismDis.addSymptom(LR.sexualArousalFromRubbingANonconsentingPerson);
frotteurismDis.addReference("pp 1010-3");


// -------------- pedophilia --------------
// (C) OntoOO Inc Sun Apr 07 20:56:22 PDT 2002
Disease pedophiliaDis = new Disease(
   LR.pedophilia, 
   "seeking sexual gratification from children", 
   LR.sexualDisorders, 
   LR.moreMale, // genderSpecificity 
   LR.none, // raceSpecificity 
   16, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
pedophiliaDis.setSuperDisease(LR.paraphilias);
pedophiliaDis.addSymptom(LR.sexualArousalFromChildren);
pedophiliaDis.addReference("pp 1010-3");


// -------------- sexualMasochism --------------
// (C) OntoOO Inc Mon Apr 08 16:39:03 PDT 2002
Disease sexualMasochismDis = new Disease(
   LR.sexualMasochism, 
   "obtaining sexual gratification by submitting to (fantasized) " +
   "psychological or physical pain", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
sexualMasochismDis.setPrintName("sexual masochism");
sexualMasochismDis.setSuperDisease(LR.paraphilias);
sexualMasochismDis.addSymptom(LR.sexualArousalFromObtainingRealOrFantasizedPain);
sexualMasochismDis.addReference("pp 1010-3");


// -------------- sexualSadism --------------
// (C) OntoOO Inc Mon Apr 08 16:58:46 PDT 2002
Disease sexualSadismDis = new Disease(
   LR.sexualSadism, 
   "obtaining sexual gratification by inflicting (fantasized) " +
   "psychological or physical pain", 
   LR.sexualDisorders, 
   LR.none, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
sexualSadismDis.setPrintName("sexual sadism");
sexualSadismDis.setSuperDisease(LR.paraphilias);
sexualSadismDis.addSymptom(LR.sexualArousalFromInflictingRealOrFantasizedPain);
sexualSadismDis.addReference("pp 1010-3");


// -------------- transvestiteFetishism --------------
// (C) OntoOO Inc Mon Apr 08 17:20:19 PDT 2002
Disease transvestiteFetishismDis = new Disease(
   LR.transvestiteFetishism, 
   "obtaining sexual arousal from dressing in woman clothing", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
transvestiteFetishismDis.setPrintName("transvestite fetishism");
transvestiteFetishismDis.setSuperDisease(LR.paraphilias);
transvestiteFetishismDis.addSymptom(LR.sexualArousalFromCrossDressing);
transvestiteFetishismDis.addReference("pp 1010-3");


// -------------- voyeurism --------------
// (C) OntoOO Inc Mon Apr 08 17:36:50 PDT 2002
Disease voyeurismDis = new Disease(
   LR.voyeurism, 
   "obtaining sexual arousal from looking at (real) sexual objects or situations", 
   LR.sexualDisorders, 
   LR.male, // genderSpecificity 
   LR.none, // raceSpecificity 
   15, //  minAge 
   LR.maxAge, //  maxAge 
   -1, //  duration 
   -1, //  diagnosis frequency, -1 = unknown 
   LR.sexualSysSt, 
   LR.none
);
voyeurismDis.setSuperDisease(LR.paraphilias);
voyeurismDis.addSymptom(LR.sexualArousalFromWatchingSexualSituations);
voyeurismDis.addReference("pp 1010-3");


  } // end doit()

} // end InitSexualDiseases
