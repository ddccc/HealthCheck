// (C) OntoOO Inc 2000
package init;

import com.Common;
import com.LR;
import com.L;
import com.D;
import concepts.*;

public class InitTorso {
  public static void doit() {

    // torso
    String torsoSt = LR.torsoSt;
    PartLocation torso = (PartLocation) Common.getLocation(torsoSt);

    // chest
    String chestSt = LR.chestSt;
    LocationRelation lrChest = 
      new LocationRelation(torsoSt, chestSt, LR.inside, LR.middle, LR.top, LR.middle);
    PartLocation chest = new PartLocation(chestSt, LR.d3, lrChest);
chest.setPrintName(L.chestPrintName);

    // abdomen
    String abdomenSt = LR.abdomenSt;
    LocationRelation lrAbdomen = 
      new LocationRelation(torsoSt, abdomenSt, LR.inside, 
			   LR.middle, LR.top, LR.middle);
    PartLocation abdomen = new PartLocation(abdomenSt, LR.d3, lrAbdomen);
    LocationRelation lrAbdomenChest = 
      new LocationRelation(abdomenSt, chestSt, LR.adjacent, 
			   LR.middle, LR.top, LR.middle);
    abdomen.addAdjacent(lrAbdomenChest);
abdomen.setPrintName(L.abdomenPrintName);

// -------------- genitalia --------------
// (C) OntoOO Inc Sat Apr 06 21:04:05 PST 2002
LocationRelation lrGenitalia =
   new LocationRelation(LR.abdomenSt, LR.genitaliaSt, LR.inside, 
			LR.middle, LR.bottom, LR.front);
LocationSet genitalia = new LocationSet(LR.genitaliaSt, LR.d3, lrGenitalia);
genitalia.setPrintName(L.genitaliaPrintName);

    // ribCage
    String ribCageSt = LR.ribCageSt;
    LocationRelation lrRibCage = 
      new LocationRelation(chestSt, ribCageSt, LR.inside, 
			   LR.leftToRight, LR.topToMiddle, LR.backToFront);
    PartLocation ribCage = new PartLocation(ribCageSt, LR.d2, lrRibCage);
ribCage.setPrintName(L.ribCagePrintName);
 
// -------------- breastBone --------------
// (C) OntoOO Inc Fri Oct 25 09:23:54 PDT 2002
LocationRelation lrBreastBone =
   new LocationRelation(LR.ribCageSt, LR.breastBoneSt, LR.inside, 
			LR.middle, LR.topToBottom, LR.front);
Bone breastBone = new Bone(LR.breastBoneSt, LR.d3, lrBreastBone);
breastBone.setPrintName(L.breastBonePrintName);

    // lungs
    String lungsSt = LR.lungsSt;
    LocationRelation lrLungs = 
      new LocationRelation(ribCageSt, lungsSt, LR.inside, LR.na, LR.middle, LR.middle);
    OrganSet lungs = new OrganSet(lungsSt, LR.d3, lrLungs);
lungs.setPrintName(L.lungsPrintName);

    // pleura
    String pleuraSt = LR.pleuraSt;
    LocationRelation lrPleura = 
      new LocationRelation(lungsSt, pleuraSt, LR.surface, LR.na, LR.na, LR.na);
    PartLocation pleura = new PartLocation(pleuraSt, LR.d2, lrPleura);
pleura.setPrintName(L.pleuraPrintName);

    // left lung
    String leftLungSt = LR.leftLungSt;
    LocationRelation lrLeftLung = 
      new LocationRelation(ribCageSt, leftLungSt, LR.inside,
			   LR.left, LR.middle, LR.middle);
    Organ leftLung = new Organ(leftLungSt, LR.d3, lrLeftLung);
    leftLung.addMembership(lungs);
leftLung.setPrintName(L.leftLungPrintName);

    // right lung
    String rightLungSt = LR.rightLungSt;
    LocationRelation lrRightLung = 
      new LocationRelation(ribCageSt, rightLungSt, LR.inside, 
			   LR.right, LR.middle, LR.middle);
    Organ rightLung = new Organ(rightLungSt, LR.d3, lrRightLung);
    rightLung.addMembership(lungs);
rightLung.setPrintName(L.rightLungPrintName);

    // pulmonary arteries
// (C) OntoOO Inc Fri Sep 28 14:35:37 PDT 2001
LocationRelation lrPulmonaryArteries =
   new LocationRelation(LR.lungsSt, LR.pulmonaryArteriesSt, LR.inside, 
			LR.na, LR.na, LR.na);
VeinSet pulmonaryArteries = 
  new VeinSet(LR.pulmonaryArteriesSt, LR.d1, lrPulmonaryArteries);
pulmonaryArteries.setPrintName(L.pulmonaryArteriesPrintName);

    // heart
    String heartSt = LR.heartSt;
    LocationRelation lrHeart = 
      new LocationRelation(ribCageSt, heartSt, LR.inside, LR.left, LR.middle, LR.middle);
    Organ heart = new Organ(heartSt, LR.d3, lrHeart);
    LocationRelation lrHeartLeftLung = 
      new LocationRelation(heartSt, leftLungSt, LR.adjacent, 
			   LR.middle, LR.middle, LR.middle); // ????
    heart.addAdjacent(lrHeartLeftLung);
heart.setPrintName(L.heartPrintName);
heart.addIllustration(D.Heart1Gif);
heart.addIllustration(D.Heart2Png);


// -------------- peritoneum --------------
// membrane that lines the abdominal cavity and covers the visceral organs
// (C) OntoOO Inc Fri Nov 23 12:33:40 PST 2001
LocationRelation lrPeritoneum =
   new LocationRelation(LR.abdomenSt, LR.peritoneumSt, LR.surface, 
			LR.leftToRight, LR.topToBottom, LR.back);
PartLocation peritoneum = new PartLocation(LR.peritoneumSt, LR.d2, lrPeritoneum);
peritoneum.setPrintName(L.peritoneumPrintName);

    // stomach
    String stomachSt = LR.stomachSt;
    LocationRelation lrStomach = 
      new LocationRelation(abdomenSt, stomachSt, LR.inside, 
			   LR.middle, LR.middle, LR.middle);
    Organ stomach = new Organ(stomachSt, LR.d3, lrStomach);
    LocationRelation lrStomachRibCage = 
      new LocationRelation(stomachSt, ribCageSt, LR.adjacent, 
			   LR.middle, LR.top, LR.middle);
    stomach.addAdjacent(lrStomachRibCage);
stomach.setPrintName(L.stomachPrintName);

    // liver
    String liverSt = LR.liverSt;
    LocationRelation lrLiver = 
      new LocationRelation(abdomenSt, liverSt, LR.inside, LR.left, LR.bottom, LR.middle);
    Organ liver = new Organ(liverSt, LR.d3, lrLiver);
    LocationRelation lrLiverStomach = 
      new LocationRelation(liverSt, stomachSt, LR.adjacent, LR.middle, LR.top, LR.middle);
    liver.addAdjacent(lrLiverStomach);
liver.setPrintName(L.liverPrintName);

    // gallbladder
// (C) OntoOO Inc Mon Jul 02 22:11:27 PDT 2001
LocationRelation lrGallbladder =
   new LocationRelation(LR.abdomenSt, LR.gallbladderSt, LR.inside, 
			LR.right, LR.top, LR.middle);
Organ gallbladder = new Organ(LR.gallbladderSt, LR.d3, lrGallbladder);
LocationRelation lrGallbladderLiver =
   new LocationRelation(LR.gallbladderSt, LR.liverSt, LR.adjacent, 
			LR.right, LR.bottom, LR.middle);
gallbladder.addAdjacent(lrGallbladderLiver);
gallbladder.setPrintName(L.gallbladderPrintName);

    // kidneys
    String kidneysSt = LR.kidneysSt;
    LocationRelation lrKidneys = 
      new LocationRelation(abdomenSt, kidneysSt, LR.inside, LR.na, LR.bottom, LR.middle);
    OrganSet kidneys = new OrganSet(kidneysSt, LR.d3, lrKidneys);
kidneys.setPrintName(L.kidneysPrintName);

    // left kidney
    String leftKidneySt = LR.leftKidneySt;
    LocationRelation lrLeftKidney = 
      new LocationRelation(abdomenSt, leftKidneySt, LR.inside, 
			   LR.left, LR.bottom, LR.middle);
    Organ leftKidney = new Organ(leftKidneySt, LR.d3, lrLeftKidney);
    leftKidney.addMembership(kidneys);
leftKidney.setPrintName(L.leftKidneyPrintName);

    // right kidney
    String rightKidneySt = LR.rightKidneySt;
    LocationRelation lrRightKidney = 
      new LocationRelation(abdomenSt, rightKidneySt, LR.inside, 
			   LR.right, LR.bottom, LR.middle);
    Organ rightKidney = new Organ(rightKidneySt, LR.d3, lrRightKidney);
    rightKidney.addMembership(kidneys);
rightKidney.setPrintName(L.rightKidneyPrintName);

    // intestines
    String intestinesSt = LR.intestinesSt;
    LocationRelation lrIntestines = 
      new LocationRelation(abdomenSt, intestinesSt, LR.inside, 
			   LR.na, LR.bottom, LR.middle);
    LocationSet intestines = new LocationSet(intestinesSt, LR.d3, lrIntestines);
intestines.setPrintName(L.intestinesPrintName);

    // small intestine
    String smallIntestineSt = LR.smallIntestineSt;
    LocationRelation lrSmallIntestine = 
      new LocationRelation(abdomenSt, smallIntestineSt, LR.inside, 
			   LR.middle, LR.bottom, LR.middle);
    PartLocation smallIntestine = 
      new PartLocation(smallIntestineSt, LR.d3, lrSmallIntestine);
    smallIntestine.addMembership(intestines);
smallIntestine.setPrintName(L.smallIntestinePrintName);

    // large intestine
    String largeIntestineSt = LR.largeIntestineSt;
    LocationRelation lrLargeIntestine = 
      new LocationRelation(abdomenSt, largeIntestineSt, LR.inside, 
			   LR.middle, LR.bottom, LR.middle);
    PartLocation largeIntestine = 
      new PartLocation(largeIntestineSt, LR.d3, lrLargeIntestine);
    largeIntestine.addMembership(intestines);
largeIntestine.setPrintName(L.largeIntestinePrintName);

     
// -------------- appendix --------------
// (C) OntoOO Inc Thu Oct 02 10:16:01 PDT 2008
   LocationRelation lrAppendix =
     new LocationRelation(LR.abdomenSt, LR.appendixSt, LR.inside, LR.right, LR.bottom, LR.middle);
   PartLocation appendix = new PartLocation(LR.appendixSt, LR.d3, lrAppendix);

   LocationRelation lrAppendixLargeIntestine =
     new LocationRelation(LR.appendixSt, LR.largeIntestineSt, LR.adjacent, LR.right, LR.bottom, LR.middle);
   appendix.addAdjacent(lrAppendixLargeIntestine);


    // colon
    String colonSt = LR.colonSt;
    LocationRelation lrColon = 
      new LocationRelation(abdomenSt, colonSt, LR.inside, 
			   LR.middle, LR.bottom, LR.middle);
    PartLocation colon = new PartLocation(colonSt, LR.d3, lrColon);
    colon.addMembership(intestines);
colon.setPrintName(L.colonPrintName);

    // rectum
// (C) OntoOO Inc Fri Nov 16 16:03:20 PST 2001
LocationRelation lrRectum =
   new LocationRelation(LR.abdomenSt, LR.rectumSt, LR.surface, 
			LR.middle, LR.bottom, LR.back);
PartLocation rectum = new PartLocation(LR.rectumSt, LR.d1, lrRectum);
LocationRelation lrRectumColon =
   new LocationRelation(LR.rectumSt, LR.colonSt, LR.adjacent, 
			LR.middle, LR.bottom, LR.middle);
rectum.addAdjacent(lrRectumColon);
rectum.setPrintName(L.rectumPrintName);

    // anus
// (C) OntoOO Inc Fri Nov 16 16:03:20 PST 2001
LocationRelation lrAnus =
   new LocationRelation(LR.abdomenSt, LR.anusSt, LR.surface, 
			LR.middle, LR.bottom, LR.back);
PartLocation anus = new PartLocation(LR.anusSt, LR.d0, lrAnus);
LocationRelation lrAnusRectum =
   new LocationRelation(LR.anusSt, LR.rectumSt, LR.adjacent, 
			LR.middle, LR.bottom, LR.middle);
anus.addAdjacent(lrAnusRectum);
anus.setPrintName(L.anusPrintName);

    // bladder
    String bladderSt = LR.bladderSt;
    LocationRelation lrBladder = 
      new LocationRelation(abdomenSt, bladderSt, LR.inside, 
			   LR.middle, LR.bottom, LR.middle);
    Organ bladder = new Organ(bladderSt, LR.d3, lrBladder);
bladder.setPrintName(L.bladderPrintName);

    // breasts
    String breastsSt = LR.breastsSt;
    LocationRelation lrBreasts = 
      new LocationRelation(chestSt, breastsSt, LR.inside, LR.na, LR.top, LR.front);
    LocationSet breasts = new LocationSet(breastsSt, LR.d3, lrBreasts);
breasts.setPrintName(L.breastsPrintName);

    // left breast
    String leftBreastSt = LR.leftBreastSt;
    LocationRelation lrLeftBreast = 
      new LocationRelation(chestSt, leftBreastSt, LR.inside, 
			   LR.left, LR.top, LR.front);
    PartLocation leftBreast = new PartLocation(leftBreastSt, LR.d3, lrLeftBreast);
    leftBreast.addMembership(breasts);
    LocationRelation lrLeftBreastRibCage = 
      new LocationRelation(leftBreastSt, ribCageSt, LR.adjacent, 
			   LR.middle, LR.middle, LR.back);
    leftBreast.addAdjacent(lrLeftBreastRibCage);
leftBreast.setPrintName(L.leftBreastPrintName);

    // right breast
    String rightBreastSt = LR.rightBreastSt;
    LocationRelation lrRightBreast = 
      new LocationRelation(chestSt, rightBreastSt, LR.inside, 
			   LR.right, LR.top, LR.front);
    PartLocation rightBreast = new PartLocation(rightBreastSt, LR.d3, lrRightBreast);
    rightBreast.addMembership(breasts);
    LocationRelation lrRightBreastRibCage = 
      new LocationRelation(rightBreastSt, ribCageSt, LR.adjacent, 
			   LR.middle, LR.middle, LR.back);
    rightBreast.addAdjacent(lrRightBreastRibCage);
rightBreast.setPrintName(L.rightBreastPrintName);

    // breastsFemale
    String breastsFemaleSt = LR.breastsFemaleSt;
    LocationRelation lrBreastsFemale = 
      new LocationRelation(chestSt, breastsFemaleSt, LR.inside, LR.na, LR.top, LR.front);
    LocationSet breastsFemale = new LocationSet(breastsFemaleSt, LR.d3, lrBreastsFemale);
    breastsFemale.setGender(LR.female);
    breastsFemale.setSuperset(LR.breastsSt);
breastsFemale.setPrintName(L.breastsFemalePrintName);


// -------------- nipples --------------
// (C) OntoOO Inc Thu Mar 14 16:15:56 PST 2002
LocationRelation lrNipples =
   new LocationRelation(LR.breastsSt, LR.nipplesSt, LR.inside, 
			LR.na, LR.middle, LR.front);
LocationSet nipples = new LocationSet(LR.nipplesSt, LR.d3, lrNipples);
nipples.setPrintName(L.nipplesPrintName);

    // left nipple
    String leftNippleSt = LR.leftNippleSt;
    LocationRelation lrLeftNipple = 
      new LocationRelation(leftBreastSt, leftNippleSt, LR.inside, 
			   LR.middle, LR.middle, LR.front);
    PartLocation leftNipple = new PartLocation(leftNippleSt, LR.d3, lrLeftNipple);
    leftNipple.addMembership(nipples);
leftNipple.setPrintName(L.leftNipplePrintName);

    // right nipple
    String rightNippleSt = LR.rightNippleSt;
    LocationRelation lrRightNipple = 
      new LocationRelation(rightBreastSt, rightNippleSt, LR.inside, 
			   LR.middle, LR.middle, LR.front);
    PartLocation rightNipple = new PartLocation(rightNippleSt, LR.d3, lrRightNipple);
    rightNipple.addMembership(nipples);
rightNipple.setPrintName(L.rightNipplePrintName);


// -------------- nipplesFemale --------------
// (C) OntoOO Inc Mon Oct 25 11:40:47 2004
LocationRelation lrNipplesFemale =
   new LocationRelation(LR.breastsFemaleSt, LR.nipplesFemaleSt, LR.inside, 
			LR.na, LR.middle, LR.front);
LocationSet nipplesFemale = new LocationSet(LR.nipplesFemaleSt, LR.d3, lrNipplesFemale);
nipplesFemale.setGender(LR.female);
nipplesFemale.setSuperset(LR.nipplesSt);
nipplesFemale.setPrintName(L.nipplesFemalePrintName);


// -------------- mammaryGlands --------------
// (C) OntoOO Inc Fri Mar 01 23:29:55 PST 2002
LocationRelation lrMammaryGlands =
   new LocationRelation(LR.breastsFemaleSt, LR.mammaryGlandsSt, LR.inside, 
			LR.na, LR.bottomToMiddle, LR.front);
LocationSet mammaryGlands = new LocationSet(LR.mammaryGlandsSt, LR.d3, lrMammaryGlands);
mammaryGlands.setSuperset(LR.glandsSt);
mammaryGlands.setGender(LR.female);
mammaryGlands.setPrintName(L.mammaryGlandsPrintName);

    // ovaries
    String ovariesSt = LR.ovariesSt;
    LocationRelation lrOvaries = 
      new LocationRelation(abdomenSt, ovariesSt, LR.inside, 
			   LR.na, LR.bottom, LR.middle);
    LocationSet ovaries = new LocationSet(ovariesSt, LR.d3, lrOvaries);
    ovaries.setGender(LR.female);
    ovaries.addIllustration(D.FemaleOrgansGif);
ovaries.setPrintName(L.ovariesPrintName);

    // left ovary
    String leftOvarySt = LR.leftOvarySt;
    LocationRelation lrLeftOvary = 
      new LocationRelation(abdomenSt, leftOvarySt, LR.inside, 
			   LR.left, LR.bottom, LR.middle);
    PartLocation leftOvary = new PartLocation(leftOvarySt, LR.d3, lrLeftOvary);
    leftOvary.addMembership(ovaries);
    leftOvary.setGender(LR.female);
    leftOvary.addIllustration(D.FemaleOrgansGif);
leftOvary.setPrintName(L.leftOvaryPrintName);

    // right ovary
    String rightOvarySt = LR.rightOvarySt;
    LocationRelation lrRightOvary = 
      new LocationRelation(abdomenSt, rightOvarySt, LR.inside, 
			   LR.right, LR.bottom, LR.middle);
    PartLocation rightOvary = new PartLocation(rightOvarySt, LR.d3, lrRightOvary);
    rightOvary.addMembership(ovaries);
    rightOvary.setGender(LR.female);
    rightOvary.addIllustration(D.FemaleOrgansGif);
rightOvary.setPrintName(L.rightOvaryPrintName);

// -------------- umbilicus --------------
// (C) OntoOO Inc Thu Nov 22 12:38:54 PST 2001
LocationRelation lrUmbilicus =
   new LocationRelation(LR.abdomenSt, LR.umbilicusSt, LR.surface, 
			LR.middle, LR.top, LR.front);
PartLocation umbilicus = new PartLocation(LR.umbilicusSt, LR.d0, lrUmbilicus);
umbilicus.setPrintName(L.umbilicusPrintName);

    // uterus
    String uterusSt = LR.uterusSt;
    LocationRelation lrUterus = 
      new LocationRelation(abdomenSt, uterusSt, LR.inside, 
			   LR.middle, LR.bottom, LR.middle);
    Organ uterus = new Organ(uterusSt, LR.d3, lrUterus);
    uterus.setGender(LR.female);
    LocationRelation lrUterusLeftOvary = 
      new LocationRelation(uterusSt, leftOvarySt, LR.adjacent, 
			   LR.left, LR.middle, LR.middle);
    uterus.addAdjacent(lrUterusLeftOvary);
    LocationRelation lrUterusRightOvary = 
      new LocationRelation(uterusSt, rightOvarySt, LR.adjacent, 
			   LR.right, LR.middle, LR.middle);
    uterus.addAdjacent(lrUterusRightOvary);
    uterus.addIllustration(D.FemaleOrgansGif);
uterus.setPrintName(L.uterusPrintName);

// -------------- endometrium --------------
// (C) OntoOO Inc Wed Feb 27 21:31:27 PST 2002
LocationRelation lrEndometrium =
   new LocationRelation(LR.uterusSt, LR.endometriumSt, LR.inside, 
			LR.leftToRight, LR.topToBottom, LR.backToFront);
PartLocation endometrium = new PartLocation(LR.endometriumSt, LR.d2, lrEndometrium);
endometrium.setGender(LR.female);
endometrium.setPrintName(L.endometriumPrintName);

// -------------- placenta --------------
// (C) OntoOO Inc Sun Feb 17 16:23:07 PST 2002
LocationRelation lrPlacenta =
   new LocationRelation(LR.uterusSt, LR.placentaSt, LR.surface, 
			LR.leftToRight, LR.topToBottom, LR.backToFront);
PartLocation placenta = new PartLocation(LR.placentaSt, LR.d2, lrPlacenta);
placenta.setGender(LR.female);
placenta.setPrintName(L.placentaPrintName);

// -------------- amnioticMembrane --------------
// (C) OntoOO Inc Sun Feb 24 18:35:20 PST 2002
LocationRelation lrAmnioticMembrane =
   new LocationRelation(LR.placentaSt, LR.amnioticMembraneSt, LR.surface, 
			LR.leftToRight, LR.topToBottom, LR.backToFront);
PartLocation amnioticMembrane = 
  new PartLocation(LR.amnioticMembraneSt, LR.d2, lrAmnioticMembrane);
amnioticMembrane.setGender(LR.female);
amnioticMembrane.setPrintName(L.amnioticMembranePrintName);

// -------------- pelvis --------------
// (C) OntoOO Inc Thu Dec 20 21:13:58 PST 2001
LocationRelation lrPelvis =
   new LocationRelation(LR.abdomenSt, LR.pelvisSt, LR.inside, 
			LR.middle, LR.bottom, LR.front);
Bone pelvis = new Bone(LR.pelvisSt, LR.d3, lrPelvis);
pelvis.setPrintName(L.pelvisPrintName);

// -------------- perineumVulvaVagina --------------
// (C) OntoOO Inc Wed Feb 27 13:38:34 PST 2002
LocationRelation lrPerineumVulvaVagina =
   new LocationRelation(LR.abdomenSt, LR.perineumVulvaVaginaSt, LR.inside, 
			LR.middle, LR.bottom, LR.backToFront);
LocationSet perineumVulvaVagina = 
  new LocationSet(LR.perineumVulvaVaginaSt, LR.d3, lrPerineumVulvaVagina);
perineumVulvaVagina.setGender(LR.female);
perineumVulvaVagina.setPrintName(L.perineumVulvaVaginaPrintName);


// -------------- perineum --------------
// (C) OntoOO Inc Wed Feb 27 13:40:05 PST 2002
LocationRelation lrPerineum =
   new LocationRelation(LR.abdomenSt, LR.perineumSt, LR.inside, 
			LR.middle, LR.bottom, LR.middle);
PartLocation perineum = new PartLocation(LR.perineumSt, LR.d3, lrPerineum);
LocationRelation lrPerineumPelvis =
   new LocationRelation(LR.perineumSt, LR.pelvisSt, LR.adjacent, 
			LR.middle, LR.middle, LR.back);
perineum.addAdjacent(lrPerineumPelvis);
LocationRelation lrPerineumAnus =
   new LocationRelation(LR.perineumSt, LR.anusSt, LR.adjacent, 
			LR.middle, LR.middle, LR.back);
perineum.addAdjacent(lrPerineumAnus);
perineum.addMembership(LR.perineumVulvaVaginaSt);
perineum.setPrintName(L.perineumPrintName);

// -------------- vagina --------------
// (C) OntoOO Inc Wed Feb 27 13:41:05 PST 2002
LocationRelation lrVagina =
   new LocationRelation(LR.abdomenSt, LR.vaginaSt, LR.inside, 
			LR.middle, LR.bottom, LR.front);
PartLocation vagina = new PartLocation(LR.vaginaSt, LR.d3, lrVagina);
vagina.setGender(LR.female);
LocationRelation lrVaginaUterus =
   new LocationRelation(LR.vaginaSt, LR.uterusSt, LR.adjacent, 
			LR.middle, LR.top, LR.middle);
vagina.addAdjacent(lrVaginaUterus);
vagina.addMembership(LR.perineumVulvaVaginaSt);
vagina.addMembership(LR.mucousMembranesSt); 
vagina.addMembership(genitalia);
vagina.addIllustration(D.FemaleOrgansGif);
vagina.setPrintName(L.vaginaPrintName);

// -------------- labia --------------
// (C) OntoOO Inc Wed Mar 13 09:13:02 PST 2002
LocationRelation lrLabia =
   new LocationRelation(LR.abdomenSt, LR.labiaSt, LR.surface, 
			LR.middle, LR.bottom, LR.front);
PartLocation labia = new PartLocation(LR.labiaSt, LR.d2, lrLabia);
labia.setGender(LR.female);
LocationRelation lrLabiaVagina =
   new LocationRelation(LR.labiaSt, LR.vaginaSt, LR.adjacent, 
			LR.leftToRight, LR.topToBottom, LR.backToFront);
labia.addAdjacent(lrLabiaVagina);
labia.setPrintName(L.labiaPrintName);

// -------------- cervix --------------
// (C) OntoOO Inc Sun Feb 24 18:07:18 PST 2002
LocationRelation lrCervix =
   new LocationRelation(LR.abdomenSt, LR.cervixSt, LR.inside, 
			LR.middle, LR.middle, LR.middle);
ConnectionLocation cervix = 
  new ConnectionLocation(LR.cervixSt, LR.d3, lrCervix, LR.uterusSt, LR.vaginaSt);
cervix.setGender(LR.female);
cervix.addIllustration(D.FemaleOrgansGif);
cervix.setPrintName(L.cervixPrintName);

// -------------- vulva --------------
// (C) OntoOO Inc Wed Feb 27 13:42:12 PST 2002
LocationRelation lrVulva =
   new LocationRelation(LR.abdomenSt, LR.vulvaSt, LR.inside, 
			LR.middle, LR.bottom, LR.front);
PartLocation vulva = new PartLocation(LR.vulvaSt, LR.d3, lrVulva);
vulva.setGender(LR.female);
LocationRelation lrVulvaVagina =
   new LocationRelation(LR.vulvaSt, LR.vaginaSt, LR.adjacent, 
			LR.middle, LR.top, LR.middle);
vulva.addAdjacent(lrVulvaVagina);
vulva.addMembership(LR.perineumVulvaVaginaSt);
vulva.addMembership(genitalia);
vulva.addIllustration(D.FemaleOrgansGif);
vulva.setPrintName(L.vulvaPrintName);

// -------------- clitoris --------------
// (C) OntoOO Inc Thu Jul 05 15:26:59 PDT 2001
LocationRelation lrClitoris =
   new LocationRelation(LR.abdomenSt, LR.clitorisSt, LR.inside, 
			LR.middle, LR.bottom, LR.front);
PartLocation clitoris = new PartLocation(LR.clitorisSt, LR.d3, lrClitoris);
clitoris.setGender(LR.female);
LocationRelation lrClitorisVagina =
   new LocationRelation(LR.clitorisSt, LR.vaginaSt, LR.adjacent, 
			LR.middle, LR.bottom, LR.front);
clitoris.addAdjacent(lrClitorisVagina);
clitoris.addIllustration(D.FemaleOrgansGif);
clitoris.setPrintName(L.clitorisPrintName);

    // prostate
    String prostateSt = LR.prostateSt;
    LocationRelation lrProstate = 
      new LocationRelation(abdomenSt, prostateSt, LR.inside, 
			   LR.middle, LR.bottom, LR.front);
    PartLocation prostate = new PartLocation(prostateSt, LR.d3, lrProstate);
    prostate.setGender(LR.male);
    LocationRelation lrProstateBladder = 
      new LocationRelation(prostateSt, bladderSt, LR.adjacent, 
			   LR.middle, LR.top, LR.middle);
    prostate.addAdjacent(lrProstateBladder);
    prostate.addMembership(LR.glandsSt);
    prostate.addIllustration(D.EpididymisGif);
prostate.setPrintName(L.prostatePrintName);

    // penis
    String penisSt = LR.penisSt;
    LocationRelation lrPenis = 
      new LocationRelation(abdomenSt, penisSt, LR.inside, 
			   LR.middle, LR.bottom, LR.front);
    PartLocation penis = new PartLocation(penisSt, LR.d3, lrPenis);
    penis.setGender(LR.male);
    LocationRelation lrPenisBladder = 
      new LocationRelation(penisSt, bladderSt, LR.adjacent, 
			   LR.middle, LR.top, LR.middle);
    penis.addAdjacent(lrPenisBladder);
    penis.addMembership(genitalia);
    penis.addIllustration(D.EpididymisGif);
penis.setPrintName(L.penisPrintName);

// -------------- glansPenis --------------
// (C) OntoOO Inc Tue Mar 12 21:47:19 PST 2002
LocationRelation lrGlansPenis =
   new LocationRelation(LR.penisSt, LR.glansPenisSt, LR.surface, 
			LR.leftToRight, LR.bottom, LR.front);
PartLocation glansPenis = new PartLocation(LR.glansPenisSt, LR.d2, lrGlansPenis);
glansPenis.setGender(LR.male);
glansPenis.addIllustration(D.EpididymisGif);
glansPenis.setPrintName(L.glansPenisPrintName);

// -------------- foreSkin --------------
// (C) OntoOO Inc Tue Mar 12 21:50:38 PST 2002
LocationRelation lrForeSkin =
   new LocationRelation(LR.penisSt, LR.foreSkinSt, LR.surface, 
			LR.leftToRight, LR.bottom, LR.front);
PartLocation foreSkin = new PartLocation(LR.foreSkinSt, LR.d2, lrForeSkin);
foreSkin.setGender(LR.male);
foreSkin.addIllustration(D.EpididymisGif);
foreSkin.setPrintName(L.foreSkinPrintName);

// -------------- scrotum --------------
// (C) OntoOO Inc Tue Mar 12 11:02:15 PST 2002
LocationRelation lrScrotum =
   new LocationRelation(LR.abdomenSt, LR.scrotumSt, LR.inside, 
			LR.middle, LR.bottom, LR.front);
PartLocation scrotum = new PartLocation(LR.scrotumSt, LR.d3, lrScrotum);
scrotum.setGender(LR.male);
LocationRelation lrScrotumPenis =
   new LocationRelation(LR.scrotumSt, LR.penisSt, LR.adjacent, 
			LR.middle, LR.top, LR.front);
scrotum.addAdjacent(lrScrotumPenis);
scrotum.addIllustration(D.EpididymisGif);
scrotum.setPrintName(L.scrotumPrintName);

    // testicles
    String testiclesSt = LR.testiclesSt;
    LocationRelation lrTesticles = 
      new LocationRelation(LR.scrotumSt, testiclesSt, LR.inside, 
			   LR.na, LR.bottom, LR.front);
    LocationSet testicles = new LocationSet(testiclesSt, LR.d3, lrTesticles);
    testicles.setGender(LR.male);
    testicles.addIllustration(D.EpididymisGif);
testicles.setPrintName(L.testiclesPrintName);

    // left testicle
    String leftTesticleSt = LR.leftTesticleSt;
    LocationRelation lrLeftTesticle = 
      new LocationRelation(abdomenSt, leftTesticleSt, LR.inside, 
			   LR.left, LR.bottom, LR.front);
    PartLocation leftTesticle = 
      new PartLocation(leftTesticleSt, LR.d3, lrLeftTesticle);
    leftTesticle.addMembership(testicles);
    LocationRelation lrLeftTesticlePenis = 
      new LocationRelation(leftTesticleSt, penisSt, LR.adjacent, 
			   LR.right, LR.middle, LR.front);
    leftTesticle.addAdjacent(lrLeftTesticlePenis);
    leftTesticle.setGender(LR.male);
    leftTesticle.addIllustration(D.EpididymisGif);
leftTesticle.setPrintName(L.leftTesticlePrintName);

    // right testicle
    String rightTesticleSt = LR.rightTesticleSt;
    LocationRelation lrRightTesticle = 
      new LocationRelation(abdomenSt, rightTesticleSt, LR.inside, 
			   LR.right, LR.bottom, LR.front);
    PartLocation rightTesticle = 
      new PartLocation(rightTesticleSt, LR.d3, lrRightTesticle);
    rightTesticle.addMembership(testicles);
    LocationRelation lrRightTesticlePenis = 
      new LocationRelation(rightTesticleSt, penisSt, LR.adjacent, 
			   LR.left, LR.middle, LR.front);
    rightTesticle.addAdjacent(lrRightTesticlePenis);
    rightTesticle.setGender(LR.male);
    rightTesticle.addIllustration(D.EpididymisGif);
rightTesticle.setPrintName(L.rightTesticlePrintName);

// -------------- epididymisSet --------------
// (C) OntoOO Inc Tue Mar 12 11:24:46 PST 2002
LocationRelation lrEpididymisSet =
   new LocationRelation(LR.scrotumSt, LR.epididymisSetSt, LR.inside, 
			LR.na, LR.top, LR.middle);
LocationSet epididymisSet = new LocationSet(LR.epididymisSetSt, LR.d3, lrEpididymisSet);
epididymisSet.setGender(LR.male);
LocationRelation lrEpididymisSetTesticles =
   new LocationRelation(LR.epididymisSetSt, LR.testiclesSt, LR.adjacent, 
			LR.na, LR.top, LR.back);
epididymisSet.addAdjacent(lrEpididymisSetTesticles);
epididymisSet.addIllustration(D.EpididymisGif);
epididymisSet.setPrintName(L.epididymisSetPrintName);

// -------------- adrenals --------------
// (C) OntoOO Inc Wed Jul 04 08:38:27 PDT 2001
LocationRelation lrAdrenals =
   new LocationRelation(LR.abdomenSt, LR.adrenalsSt, LR.inside, 
			LR.na, LR.top, LR.back);
LocationSet adrenals = new LocationSet(LR.adrenalsSt, LR.d3, lrAdrenals);
LocationRelation lrAdrenalsKidneys =
   new LocationRelation(LR.adrenalsSt, LR.kidneysSt, LR.adjacent, 
			LR.na, LR.top, LR.middle);
adrenals.addAdjacent(lrAdrenalsKidneys);
adrenals.setPrintName(L.adrenalsPrintName);

// pancreas
// (C) OntoOO Inc Wed Jul 04 08:44:04 PDT 2001
LocationRelation lrPancreas =
   new LocationRelation(LR.abdomenSt, LR.pancreasSt, LR.inside, 
			LR.middle, LR.middle, LR.middle);
PartLocation pancreas = new PartLocation(LR.pancreasSt, LR.d3, lrPancreas);
LocationRelation lrPancreasKidneys =
   new LocationRelation(LR.pancreasSt, LR.kidneysSt, LR.adjacent, 
			LR.na, LR.middle, LR.front);
pancreas.addAdjacent(lrPancreasKidneys);
LocationRelation lrPancreasStomach =
   new LocationRelation(LR.pancreasSt, LR.stomachSt, LR.adjacent, 
			LR.middle, LR.middle, LR.back);
pancreas.addAdjacent(lrPancreasStomach);
pancreas.setPrintName(L.pancreasPrintName);

// urethralExitFM 
// (C) OntoOO Inc Fri Jul 06 14:32:34 PDT 2001
LocationRelation lrUrethralExitFM =
   new LocationRelation(LR.abdomenSt, LR.urethralExitFMSt, LR.surface, 
			LR.middle, LR.bottom, LR.middle);
PartLocation urethralExitFM = 
  new PartLocation(LR.urethralExitFMSt, LR.d0, lrUrethralExitFM);
urethralExitFM.setGender(LR.female);
urethralExitFM.addIllustration(D.FemaleOrgansGif);
urethralExitFM.setPrintName(L.urethralExitFMPrintName);

// urethraFM
// (C) OntoOO Inc Fri Jul 06 14:47:38 PDT 2001
LocationRelation lrUrethraFM =
   new LocationRelation(LR.abdomenSt, LR.urethraFMSt, LR.inside, 
			LR.middle, LR.bottom, LR.middle);
ConnectionLocation urethraFM = 
  new ConnectionLocation(LR.urethraFMSt, LR.d1, lrUrethraFM, 
			 LR.bladderSt, LR.urethralExitFMSt);
urethraFM.setGender(LR.female);
urethraFM.addIllustration(D.FemaleOrgansGif);
urethraFM.setPrintName(L.urethraFMPrintName);

// urethralExitML
// (C) OntoOO Inc Fri Jul 06 14:22:25 PDT 2001
LocationRelation lrUrethralExitML =
   new LocationRelation(LR.penisSt, LR.urethralExitMLSt, LR.surface, 
			LR.middle, LR.bottom, LR.middle);
PartLocation urethralExitML = 
  new PartLocation(LR.urethralExitMLSt, LR.d0, lrUrethralExitML);
urethralExitML.setGender(LR.male);
urethralExitML.addIllustration(D.EpididymisGif);
urethralExitML.setPrintName(L.urethralExitMLPrintName);

// urethraML
// (C) OntoOO Inc Fri Jul 06 14:30:22 PDT 2001
LocationRelation lrUrethraML =
   new LocationRelation(LR.abdomenSt, LR.urethraMLSt, LR.inside, 
			LR.middle, LR.bottom, LR.front);
ConnectionLocation urethraML = 
  new ConnectionLocation(LR.urethraMLSt, LR.d1, lrUrethraML, 
			 LR.bladderSt, LR.urethralExitMLSt);
urethraML.setGender(LR.male);
LocationRelation lrUrethraMLPenis =
   new LocationRelation(LR.urethraMLSt, LR.penisSt, LR.adjacent, 
			LR.middle, LR.topToBottom, LR.middle);
urethraML.addAdjacent(lrUrethraMLPenis);
urethraML.addIllustration(D.EpididymisGif);
urethraML.setPrintName(L.urethraMLPrintName);

// spleen
// (C) OntoOO Inc Tue Aug 07 21:54:10 PDT 2001
LocationRelation lrSpleen =
   new LocationRelation(LR.abdomenSt, LR.spleenSt, LR.inside, 
			LR.left, LR.top, LR.middle);
Organ spleen = new Organ(LR.spleenSt, LR.d3, lrSpleen);
spleen.setPrintName(L.spleenPrintName);

// back
// (C) OntoOO Inc Fri Nov 02 09:29:48 PST 2001
LocationRelation lrBack =
   new LocationRelation(LR.torsoSt, LR.backSt, LR.surface, 
			LR.leftToRight, LR.topToBottom, LR.back);
PartLocation back = new PartLocation(LR.backSt, LR.d2, lrBack);
back.setPrintName(L.backPrintName);

// flanks
// (C) OntoOO Inc Sat Nov 03 14:34:44 PST 2001
LocationRelation lrFlanks =
   new LocationRelation(LR.torsoSt, LR.flanksSt, LR.inside, 
			LR.na, LR.middle, LR.middle);
LocationSet flanks = new LocationSet(LR.flanksSt, LR.d3, lrFlanks);
LocationRelation lrFlanksHips =
   new LocationRelation(LR.flanksSt, LR.hipsSt, LR.adjacent, 
			LR.na, LR.bottom, LR.middle);
flanks.addAdjacent(lrFlanksHips);
LocationRelation lrFlanksRibCage =
   new LocationRelation(LR.flanksSt, LR.ribCageSt, LR.adjacent, 
			LR.na, LR.top, LR.middle);
flanks.addAdjacent(lrFlanksRibCage);
flanks.setPrintName(L.flanksPrintName);

// -------------- epigastricRegion --------------
// (C) OntoOO Inc Sun Nov 25 17:12:23 PST 2001
LocationRelation lrEpigastricRegion =
   new LocationRelation(LR.abdomenSt, LR.epigastricRegionSt, LR.inside, 
			LR.middle, LR.top, LR.front);
PartLocation epigastricRegion = 
  new PartLocation(LR.epigastricRegionSt, LR.d3, lrEpigastricRegion);
LocationRelation lrEpigastricRegionUmbilicus =
   new LocationRelation(LR.epigastricRegionSt, LR.umbilicusSt, LR.adjacent, 
			LR.middle, LR.top, LR.front);
epigastricRegion.addAdjacent(lrEpigastricRegionUmbilicus);
epigastricRegion.setPrintName(L.epigastricRegionPrintName);

// -------------- lumbar --------------
// (C) OntoOO Inc Sun Nov 25 17:07:34 PST 2001
LocationRelation lrLumbar =
   new LocationRelation(LR.backSt, LR.lumbarSt, LR.inside, 
			LR.leftToRight, LR.bottomToMiddle, LR.back);
PartLocation lumbar = new PartLocation(LR.lumbarSt, LR.d3, lrLumbar);
LocationRelation lrLumbarHips =
   new LocationRelation(LR.lumbarSt, LR.hipsSt, LR.adjacent, 
			LR.leftToRight, LR.bottom, LR.middle);
lumbar.addAdjacent(lrLumbarHips);
LocationRelation lrLumbarRibCage =
   new LocationRelation(LR.lumbarSt, LR.ribCageSt, LR.adjacent, 
			LR.leftToRight, LR.top, LR.middle);
lumbar.addAdjacent(lrLumbarRibCage);
lumbar.setPrintName(L.lumbarPrintName);

// -------------- aorta --------------
// (C) OntoOO Inc Sat Dec 08 22:41:34 PST 2001
LocationRelation lrAorta =
   new LocationRelation(LR.torsoSt, LR.aortaSt, LR.inside, 
			LR.middle, LR.topToMiddle, LR.middle);
Vein aorta = new Vein(LR.aortaSt, LR.d1, lrAorta);
LocationRelation lrAortaHeart =
   new LocationRelation(LR.aortaSt, LR.heartSt, LR.adjacent, 
			LR.right, LR.top, LR.middle);
aorta.addAdjacent(lrAortaHeart);
aorta.setPrintName(L.aortaPrintName);

// -------------- pericardium --------------
// (C) OntoOO Inc Sat Dec 08 22:52:26 PST 2001
LocationRelation lrPericardium =
   new LocationRelation(LR.heartSt, LR.pericardiumSt, LR.surface, 
			LR.leftToRight, LR.topToBottom, LR.backToFront);
PartLocation pericardium = new PartLocation(LR.pericardiumSt, LR.d2, lrPericardium);
pericardium.setPrintName(L.pericardiumPrintName);

// -------------- pubis --------------
// (C) OntoOO Inc Sat Dec 22 23:18:06 PST 2001
LocationRelation lrPubis =
   new LocationRelation(LR.abdomenSt, LR.pubisSt, LR.surface, 
			LR.middle, LR.bottom, LR.front);
PartLocation pubis = new PartLocation(LR.pubisSt, LR.d3, lrPubis);
LocationRelation lrPubisBladder =
   new LocationRelation(LR.pubisSt, LR.bladderSt, LR.adjacent, 
			LR.middle, LR.middle, LR.back);
pubis.addAdjacent(lrPubisBladder);
pubis.setPrintName(L.pubisPrintName);

// -------------- fallopianTubes --------------
// (C) OntoOO Inc Tue Feb 05 12:40:47 PST 2002
LocationRelation lrFallopianTubes =
   new LocationRelation(LR.abdomenSt, LR.fallopianTubesSt, LR.inside, 
			LR.na, LR.middle, LR.middle);
LocationSet fallopianTubes = 
  new LocationSet(LR.fallopianTubesSt, LR.d1, lrFallopianTubes);
LocationRelation lrFallopianTubesOvaries =
   new LocationRelation(LR.fallopianTubesSt, LR.ovariesSt, LR.adjacent, 
			LR.na, LR.top, LR.middle);
fallopianTubes.addAdjacent(lrFallopianTubesOvaries);
LocationRelation lrFallopianTubesUterus =
   new LocationRelation(LR.fallopianTubesSt, LR.uterusSt, LR.adjacent, 
			LR.na, LR.top, LR.middle);
fallopianTubes.addAdjacent(lrFallopianTubesUterus);
fallopianTubes.addIllustration(D.FemaleOrgansGif);
fallopianTubes.setPrintName(L.fallopianTubesPrintName);

// -------------- skinOfGenital -------------- 
// (C) OntoOO Inc Thu Mar 14 09:22:19 PST 2002 
LocationRelation lrSkinOfGenital = 
  new LocationRelation(LR.abdomenSt, LR.skinOfGenitalSt, LR.surface,
		       LR.middle, LR.bottom, LR.frontToMiddle); 
PartLocation skinOfGenital =
  new PartLocation(LR.skinOfGenitalSt, LR.d2, lrSkinOfGenital);
LocationRelation lrSkinOfGenitalSkin = new
  LocationRelation(LR.skinSt, LR.skinOfGenitalSt, LR.inside, LR.middle,
		   LR.middle, LR.frontToMiddle);
skinOfGenital.addAlsoPartOf(lrSkinOfGenitalSkin);
skinOfGenital.setPrintName(L.skinOfGenitalPrintName);

// -------------- navel --------------
// (C) OntoOO Inc Mon Mar 18 11:15:58 PST 2002
LocationRelation lrNavel =
   new LocationRelation(LR.abdomenSt, LR.navelSt, LR.surface, 
			LR.middle, LR.middle, LR.front);
PartLocation navel = new PartLocation(LR.navelSt, LR.d0, lrNavel);
navel.setPrintName(L.navelPrintName);

  }

} // end of InitTorso
