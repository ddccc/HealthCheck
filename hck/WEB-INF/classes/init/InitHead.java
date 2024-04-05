// (C) OntoOO Inc 2000
package init;

import com.Common;
import com.LR;
import com.L;
import com.D;
import concepts.*;

public class InitHead {
  public static void doit() {

    // head
    String headSt = LR.headSt;
    PartLocation head = (PartLocation) Common.getLocation(headSt);

    // eyes
    String eyesSt = LR.eyesSt;
    LocationRelation lrEyes = 
      new LocationRelation(headSt, eyesSt, LR.inside, LR.na, LR.middle, LR.front);
    LocationSet eyes = new LocationSet(eyesSt, LR.d3, lrEyes);
eyes.setPrintName(L.eyesPrintName);

    // left eye
    String leftEyeSt = LR.leftEyeSt;
    LocationRelation lrLeftEye = 
      new LocationRelation(headSt, leftEyeSt, LR.inside, LR.left, LR.middle, LR.front);
    PartLocation leftEye = new PartLocation(leftEyeSt, LR.d3, lrLeftEye);
    leftEye.addMembership(eyes);
leftEye.setPrintName(L.leftEyePrintName);

    // right eye
    String rightEyeSt = LR.rightEyeSt;
    LocationRelation lrRightEye = 
      new LocationRelation(headSt, rightEyeSt, LR.inside, LR.right, LR.middle, LR.front);
    PartLocation rightEye = new PartLocation(rightEyeSt, LR.d3, lrRightEye);
    rightEye.addMembership(eyes);
rightEye.setPrintName(L.rightEyePrintName);

    // pupils
// (C) OntoOO Inc Fri Nov 02 09:33:37 PST 2001
LocationRelation lrPupils =
   new LocationRelation(LR.eyesSt, LR.pupilsSt, LR.inside, 
			LR.middle, LR.middle, LR.front);
LocationSet pupils = new LocationSet(LR.pupilsSt, LR.d2, lrPupils);
pupils.setPrintName(L.pupilsPrintName);

// -------------- retinas --------------
// (C) OntoOO Inc Sat Nov 17 21:11:23 PST 2001
LocationRelation lrRetinas =
   new LocationRelation(LR.eyesSt, LR.retinasSt, LR.surface, LR.leftToRight, LR.topToBottom, LR.back);
LocationSet retinas = new LocationSet(LR.retinasSt, LR.d2, lrRetinas);
retinas.setPrintName(L.retinasPrintName);

// -------------- eyelids --------------
// (C) OntoOO Inc Thu Mar 14 16:29:42 PST 2002
LocationRelation lrEyelids =
   new LocationRelation(LR.headSt, LR.eyelidsSt, LR.surface, LR.na, LR.middle, LR.front);
LocationSet eyelids = new LocationSet(LR.eyelidsSt, LR.d3, lrEyelids);
LocationRelation lrEyelidsEyes =
   new LocationRelation(LR.eyelidsSt, LR.eyesSt, LR.adjacent, LR.na, LR.middle, LR.back);
eyelids.addAdjacent(lrEyelidsEyes);
eyelids.setPrintName(L.eyelidsPrintName);

// -------------- conjunctiva --------------
// (C) OntoOO Inc Wed Aug 21 16:20:45 PDT 2002
LocationRelation lrConjunctiva =
   new LocationRelation(LR.eyelidsSt, LR.conjunctivaSt, LR.inside, LR.leftToRight, LR.topToBottom, LR.back);
LocationSet conjunctiva = new LocationSet(LR.conjunctivaSt, LR.d2, lrConjunctiva);
conjunctiva.setPrintName(L.conjunctivaPrintName);

// -------------- corneas --------------
// (C) OntoOO Inc Wed Mar 12 16:04:33 PST 2003
LocationRelation lrCorneas =
   new LocationRelation(LR.eyesSt, LR.corneasSt, LR.surface, LR.middle, LR.middle, LR.front);
LocationSet corneas = new LocationSet(LR.corneasSt, LR.d2, lrCorneas);
corneas.setPrintName(L.corneasPrintName);

    // ears
    String earsSt = LR.earsSt;
    LocationRelation lrEars = 
      new LocationRelation(headSt, earsSt, LR.inside, LR.na, LR.middle, LR.middle);
    LocationSet ears = new LocationSet(earsSt, LR.d3, lrEars);
ears.setPrintName(L.earsPrintName);

    // left ear
    String leftEarSt = LR.leftEarSt;
    LocationRelation lrLeftEar = 
      new LocationRelation(headSt, leftEarSt, LR.inside, LR.left, LR.middle, LR.middle);
    PartLocation leftEar = new PartLocation(leftEarSt, LR.d3, lrLeftEar);
    leftEar.addMembership(ears);
leftEar.setPrintName(L.leftEarPrintName);

    // right ear
    String rightEarSt = LR.rightEarSt;
    LocationRelation lrRightEar = 
      new LocationRelation(headSt, rightEarSt, LR.inside, 
			   LR.right, LR.middle, LR.middle);
    PartLocation rightEar = new PartLocation(rightEarSt, LR.d3, lrRightEar);
    rightEar.addMembership(ears);
rightEar.setPrintName(L.rightEarPrintName);

    // nose
    String noseSt = LR.noseSt;
    LocationRelation lrNose = 
      new LocationRelation(headSt, noseSt, LR.inside, LR.middle, LR.middle, LR.front);
    PartLocation nose = new PartLocation(noseSt, LR.d3, lrNose);
    LocationRelation lrNoseLeye = 
      new LocationRelation(noseSt, leftEyeSt, LR.adjacent, LR.left, LR.middle, LR.back);
    nose.addAdjacent(lrNoseLeye);
    LocationRelation lrNoseReye = 
      new LocationRelation(noseSt, rightEyeSt, LR.adjacent, 
			   LR.right, LR.middle, LR.back);
    nose.addAdjacent(lrNoseReye);
    nose.addMembership(LR.mucousMembranesSt);
nose.setPrintName(L.nosePrintName);

// -------------- noseSeptum --------------
// (C) OntoOO Inc Fri Mar 15 14:04:20 PST 2002
LocationRelation lrNoseSeptum =
   new LocationRelation(LR.noseSt, LR.noseSeptumSt, LR.inside, 
			LR.middle, LR.topToBottom, LR.backToFront);
PartLocation noseSeptum = new PartLocation(LR.noseSeptumSt, LR.d3, lrNoseSeptum);
noseSeptum.setPrintName(L.noseSeptumPrintName);

// -------------- sinus --------------
// (C) OntoOO Inc Sun Oct 20 21:32:05 PDT 2002
LocationRelation lrSinus =
   new LocationRelation(LR.headSt, LR.sinusSt, LR.inside, 
			LR.middle, LR.topToMiddle, LR.front);
PartLocation sinus = new PartLocation(LR.sinusSt, LR.d2, lrSinus);
LocationRelation lrSinusNose =
   new LocationRelation(LR.sinusSt, LR.noseSt, LR.adjacent, 
			LR.middle, LR.top, LR.middle);
sinus.addAdjacent(lrSinusNose);
sinus.setPrintName(L.sinusPrintName);

    // mouth
    String mouthSt = LR.mouthSt;
    LocationRelation lrMouth = 
      new LocationRelation(headSt, mouthSt, LR.inside, LR.middle, LR.bottom, LR.front);
    PartLocation mouth = new PartLocation(mouthSt, LR.d3, lrMouth);
    LocationRelation lrMouthNose = 
      new LocationRelation(mouthSt, noseSt, LR.adjacent, 
			   LR.middle, LR.bottom, LR.middle);
    mouth.addAdjacent(lrMouthNose);
    mouth.addMembership(LR.mucousMembranesSt);
mouth.setPrintName(L.mouthPrintName);

// -------------- palate --------------
// (C) OntoOO Inc Fri Mar 15 14:00:07 PST 2002
LocationRelation lrPalate =
   new LocationRelation(LR.mouthSt, LR.palateSt, LR.inside, 
			LR.leftToRight, LR.bottom, LR.backToFront);
PartLocation palate = new PartLocation(LR.palateSt, LR.d3, lrPalate);
LocationRelation lrPalateNose =
   new LocationRelation(LR.palateSt, LR.noseSt, LR.adjacent, 
			LR.middle, LR.top, LR.front);
palate.addAdjacent(lrPalateNose);
palate.setPrintName(L.palatePrintName);

// -------------- lips --------------
// (C) OntoOO Inc Thu Dec 06 20:44:47 PST 2001
LocationRelation lrLips =
   new LocationRelation(LR.skinSt, LR.lipsSt, LR.surface, LR.middle, LR.top, LR.front);
LocationSet lips = new LocationSet(LR.lipsSt, LR.d2, lrLips);
LocationRelation lrLipsMouth =
   new LocationRelation(LR.lipsSt, LR.mouthSt, LR.adjacent, 
			LR.leftToRight, LR.middle, LR.front);
lips.addAdjacent(lrLipsMouth);
lips.setPrintName(L.lipsPrintName);

// -------------- tongue --------------
// (C) OntoOO Inc Thu Dec 06 21:07:05 PST 2001
LocationRelation lrTongue =
   new LocationRelation(LR.mouthSt, LR.tongueSt, LR.inside, 
			LR.middle, LR.bottom, LR.middle);
PartLocation tongue = new PartLocation(LR.tongueSt, LR.d3, lrTongue);
tongue.setPrintName(L.tonguePrintName);

// -------------- parotidGlands --------------
// (C) OntoOO Inc Wed May 29 16:48:02 PDT 2002
LocationRelation lrParotidGlands =
   new LocationRelation(LR.mouthSt, LR.parotidGlandsSt, LR.inside, LR.na, LR.top, LR.front);
LocationSet parotidGlands = new LocationSet(LR.parotidGlandsSt, LR.d3, lrParotidGlands);
parotidGlands.setSuperset(LR.glandsSt);
parotidGlands.setPrintName(L.parotidGlandsPrintName);

// -------------- gums --------------
// (C) OntoOO Inc Sun Jun 15 17:47:02 PDT 2003
LocationRelation lrGums =
   new LocationRelation(LR.mouthSt, LR.gumsSt, LR.inside, 
			LR.leftToRight, LR.topToBottom, LR.front);
LocationSet gums = new LocationSet(LR.gumsSt, LR.d3, lrGums);
gums.setPrintName(L.gumsPrintName);

// -------------- teeth --------------
// (C) OntoOO Inc Fri Oct 08 14:47:13 GMT-08:00 2004
LocationRelation lrTeeth =
   new LocationRelation(LR.mouthSt, LR.teethSt, LR.inside, LR.leftToRight, LR.topToBottom, LR.front);
LocationSet teeth = new LocationSet(LR.teethSt, LR.d3, lrTeeth);
LocationRelation lrTeethABone =
   new LocationRelation(LR.aBoneSt, LR.teethSt, LR.inside, LR.na, LR.na, LR.na);
teeth.addAlsoPartOf(lrTeethABone);
LocationRelation lrTeethGums =
   new LocationRelation(LR.teethSt, LR.gumsSt, LR.adjacent, LR.leftToRight, LR.na, LR.backToFront);
teeth.addAdjacent(lrTeethGums);
teeth.setPrintName(L.teethPrintName);

    // skull
    String skullSt = LR.skullSt;
    LocationRelation lrSkull = 
      new LocationRelation(headSt, skullSt, LR.inside, 
			   LR.leftToRight, LR.topToBottom, LR.backToFront);
    Bone skull = new Bone(skullSt, LR.d2, lrSkull);
skull.setPrintName(L.skullPrintName);

    // brain
    String brainSt = LR.brainSt;
    LocationRelation lrBrain = 
      new LocationRelation(skullSt, brainSt, LR.inside, 
			   LR.leftToRight, LR.topToMiddle, LR.backToFront);
    PartLocation brain = new PartLocation(brainSt, LR.d3, lrBrain);
brain.setPrintName(L.brainPrintName);

    // mind
    String mindSt = LR.mindSt;
    LocationRelation lrMind = 
      new LocationRelation(brainSt, mindSt, LR.inside, 
			   LR.leftToRight, LR.topToMiddle, LR.backToFront);
    PartLocation mind = new PartLocation(mindSt, LR.d3, lrMind);
mind.setPrintName(L.mindPrintName);

     // larynx
    String larynxSt = LR.larynxSt;
    LocationRelation lrLarynx = 
      new LocationRelation(headSt, larynxSt, LR.inside, LR.middle, LR.bottom, LR.front);
    PartLocation larynx = new PartLocation(larynxSt, LR.d3, lrLarynx);
    LocationRelation lrLarynxMouth = 
      new LocationRelation(larynxSt, mouthSt, LR.adjacent, 
			   LR.middle, LR.middle, LR.back);
    larynx.addAdjacent(lrLarynxMouth);
larynx.setPrintName(L.larynxPrintName);

     // throat
    String throatSt = LR.throatSt;
    LocationRelation lrThroat = 
      new LocationRelation(headSt, throatSt, LR.inside, LR.middle, LR.bottom, LR.front);
    PartLocation throat = new PartLocation(throatSt, LR.d3, lrThroat);
    LocationRelation lrThroatMouth = 
      new LocationRelation(throatSt, mouthSt, LR.adjacent, 
			   LR.middle, LR.middle, LR.back);
    throat.addAdjacent(lrThroatMouth);
    throat.addMembership(LR.mucousMembranesSt); 
throat.setPrintName(L.throatPrintName);

// -------------- tonsils --------------
// (C) OntoOO Inc Thu Mar 07 21:32:02 PST 2002
LocationRelation lrTonsils =
   new LocationRelation(LR.throatSt, LR.tonsilsSt, LR.inside, 
			LR.middle, LR.middle, LR.back);
LocationSet tonsils = new LocationSet(LR.tonsilsSt, LR.d3, lrTonsils);
tonsils.setPrintName(L.tonsilsPrintName);

    // jaws
    String jawsSt = LR.jawsSt;
    LocationRelation lrJaws = 
      new LocationRelation(headSt, jawsSt, LR.inside, LR.na, LR.bottom, LR.middle);
    BoneSet jaws = new BoneSet(jawsSt, LR.d3, lrJaws);
    LocationRelation lrMouthJaws = 
      new LocationRelation(jawsSt, mouthSt, LR.adjacent, 
			   LR.middle, LR.bottom, LR.middle);
    jaws.addAdjacent(lrMouthJaws);
jaws.setPrintName(L.jawsPrintName);

    // left jaw
    String leftJawSt = LR.leftJawSt;
    LocationRelation lrLeftJaw = 
      new LocationRelation(headSt, leftJawSt, LR.inside, 
			   LR.left, LR.bottom, LR.middle);
    Bone leftJaw = new Bone(leftJawSt, LR.d3, lrLeftJaw);
    leftJaw.addMembership(jaws);
leftJaw.setPrintName(L.leftJawPrintName);

    // right jaw
    String rightJawSt = LR.rightJawSt;
    LocationRelation lrRightJaw = 
      new LocationRelation(headSt, rightJawSt, LR.inside, 
			   LR.right, LR.bottom, LR.middle);
    Bone rightJaw = new Bone(rightJawSt, LR.d3, lrRightJaw);
    rightJaw.addMembership(jaws);
rightJaw.setPrintName(L.rightJawPrintName);

// (C) OntoOO Inc Tue Jul 03 21:34:22 PDT 2001
LocationRelation lrPituitary =
   new LocationRelation(LR.headSt, LR.pituitarySt, LR.inside, 
			LR.middle, LR.middle, LR.middle);
PartLocation pituitary = new PartLocation(LR.pituitarySt, LR.d3, lrPituitary);
LocationRelation lrPituitaryBrain =
   new LocationRelation(LR.pituitarySt, LR.brainSt, LR.adjacent, 
			LR.middle, LR.bottom, LR.middle);
pituitary.addAdjacent(lrPituitaryBrain);
pituitary.setPrintName(L.pituitaryPrintName);

// (C) OntoOO Inc Tue Jul 31 15:27:57 PDT 2001
LocationRelation lrFace =
   new LocationRelation(LR.headSt, LR.faceSt, LR.surface, 
			LR.leftToRight, LR.topToBottom, LR.front);
PartLocation face = new PartLocation(LR.faceSt, LR.d2, lrFace);
LocationRelation lrFaceSkin =
   new LocationRelation(LR.skinSt, LR.faceSt, LR.surface, 
			LR.leftToRight, LR.top, LR.front);
face.addAlsoPartOf(lrFaceSkin);
face.setPrintName(L.facePrintName);

// -------------- cheeks --------------
// (C) OntoOO Inc Mon Apr 07 17:21:45 PDT 2003
LocationRelation lrCheeks =
   new LocationRelation(LR.faceSt, LR.cheeksSt, LR.surface, LR.leftToRight, LR.bottomToMiddle, LR.front);
LocationSet cheeks = new LocationSet(LR.cheeksSt, LR.d2, lrCheeks);
LocationRelation lrCheeksEars =
   new LocationRelation(LR.cheeksSt, LR.earsSt, LR.adjacent, LR.leftToRight, LR.top, LR.back);
cheeks.addAdjacent(lrCheeksEars);
LocationRelation lrCheeksJaws =
   new LocationRelation(LR.cheeksSt, LR.jawsSt, LR.adjacent, LR.leftToRight, LR.bottom, LR.front);
cheeks.addAdjacent(lrCheeksJaws);
LocationRelation lrCheeksMouth =
   new LocationRelation(LR.cheeksSt, LR.mouthSt, LR.adjacent, LR.middle, LR.middle, LR.front);
cheeks.addAdjacent(lrCheeksMouth);
LocationRelation lrCheeksNose =
   new LocationRelation(LR.cheeksSt, LR.noseSt, LR.adjacent, LR.middle, LR.top, LR.front);
cheeks.addAdjacent(lrCheeksNose);
cheeks.setPrintName(L.cheeksPrintName);

// scalp
// (C) OntoOO Inc Fri Nov 02 15:24:49 PST 2001
LocationRelation lrScalp =
   new LocationRelation(LR.headSt, LR.scalpSt, LR.surface, 
			LR.leftToRight, LR.top, LR.backToFront);
PartLocation scalp = new PartLocation(LR.scalpSt, LR.d2, lrScalp);
LocationRelation lrScalpSkin =
   new LocationRelation(LR.skinSt, LR.scalpSt, LR.inside, 
			LR.leftToRight, LR.top, LR.backToFront);
scalp.addAlsoPartOf(lrScalpSkin);
scalp.setPrintName(L.scalpPrintName);

// -------------- cranialNerve5th --------------
// (C) OntoOO Inc Thu May 15 15:40:00 PDT 2003
LocationRelation lrCranialNerve5th =
   new LocationRelation(LR.headSt, LR.cranialNerve5thSt, LR.inside, LR.na, LR.top, LR.front);
PartLocation cranialNerve5th = 
   new PartLocation(LR.cranialNerve5thSt, LR.d3, lrCranialNerve5th);
cranialNerve5th.addMembership(LR.nervesSt);
cranialNerve5th.setPrintName(L.cranialNerve5thPrintName);
cranialNerve5th.addIllustration(D.TrigeminalNeuralgiaGif);

// -------------- cranialNerve7th --------------
// (C) OntoOO Inc Thu May 15 15:40:00 PDT 2003
LocationRelation lrCranialNerve7th =
   new LocationRelation(LR.headSt, LR.cranialNerve7thSt, LR.inside, LR.na, LR.top, LR.front);
PartLocation cranialNerve7th = 
   new PartLocation(LR.cranialNerve7thSt, LR.d3, lrCranialNerve7th);
cranialNerve7th.addMembership(LR.nervesSt);
cranialNerve7th.setPrintName(L.cranialNerve7thPrintName);


  } // end of doit()

} // end of InitHead
