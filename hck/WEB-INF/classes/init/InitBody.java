// (C) OntoOO Inc 2000
package init;

import com.Common;
import com.LR;
import com.L;
import concepts.*;

public class InitBody {
  public static void doit() {

    Common.createTheLocations();
    Common.setTheLocationsLoaded(true);


    // body
    String bodySt = LR.bodySt;
    Location body = new Location(bodySt, LR.d3);
body.setPrintName(L.bodyPrintName);

    // head
    String headSt = LR.headSt;
    LocationRelation lrHead = 
      new LocationRelation(bodySt, headSt, LR.inside, LR.middle, LR.top, LR.middle);
    PartLocation head = new PartLocation(headSt, LR.d3, lrHead);
head.setPrintName(L.headPrintName);

    // torso
    String torsoSt = LR.torsoSt;
    LocationRelation lrTorso = 
      new LocationRelation(bodySt, torsoSt, LR.inside, LR.middle, LR.middle, LR.middle);
    PartLocation torso = new PartLocation(torsoSt, LR.d3, lrTorso);
torso.setPrintName(L.torsoPrintName);

    // neck
    String neckSt = LR.neckSt;
    LocationRelation lrNeck = 
      new LocationRelation(bodySt, neckSt, LR.inside, LR.middle, LR.top, LR.middle);
    ConnectionLocation neck = 
      new ConnectionLocation(neckSt, LR.d3, lrNeck, headSt, torsoSt);
neck.setPrintName(L.neckPrintName);

// -------------- limbs --------------
// (C) OntoOO Inc Wed May 07 15:11:24 PDT 2003
LocationRelation lrLimbs =
   new LocationRelation(LR.bodySt, LR.limbsSt, LR.inside, LR.na, LR.na, LR.na);
LocationSet limbs = new LocationSet(LR.limbsSt, LR.d3, lrLimbs);
limbs.setPrintName(L.limbsPrintName);


    // arms
    String armsSt = LR.armsSt;
    LocationRelation lrArms = 
      new LocationRelation(LR.bodySt, armsSt, LR.inside, LR.na, LR.middle, LR.middle);
    LocationSet arms = new LocationSet(armsSt, LR.d3, lrArms);
    arms.setSuperset(LR.limbsSt);
arms.setPrintName(L.armsPrintName);

    // legs
    String legsSt = LR.legsSt;
    LocationRelation lrLegs = 
      new LocationRelation(LR.bodySt, legsSt, LR.inside, LR.na, LR.bottom, LR.middle);
    LocationSet legs = new LocationSet(legsSt, LR.d3, lrLegs);
    legs.setSuperset(LR.limbsSt);
legs.setPrintName(L.legsPrintName);

    // joints
// (C) OntoOO Inc Fri Aug 03 17:54:36 PDT 2001
LocationRelation lrJoints =
   new LocationRelation(LR.bodySt, LR.jointsSt, LR.inside, LR.na, LR.na, LR.middle);
LocationSet joints = new LocationSet(LR.jointsSt, LR.d3, lrJoints);
joints.setPrintName(L.jointsPrintName);

    // shoulders 
    String shouldersSt = LR.shouldersSt; 
    LocationRelation lrShoulders = 
      new LocationRelation(bodySt, shouldersSt, LR.inside,
			   LR.na, LR.top, LR.middle); 
    LocationSet shoulders = new LocationSet(shouldersSt, LR.d3, lrShoulders);
    shoulders.setSuperset(LR.jointsSt);
shoulders.setPrintName(L.shouldersPrintName);

    // hips
    String hipsSt = LR.hipsSt; 
    LocationRelation lrHips = 
      new LocationRelation(bodySt, hipsSt, 
			   LR.inside, LR.na, LR.bottom, LR.middle);
    LocationSet hips = new LocationSet(hipsSt, LR.d3, lrHips);
    hips.setSuperset(LR.jointsSt); 
hips.setPrintName(L.hipsPrintName);

    // leftJoints
// (C) OntoOO Inc Fri Aug 03 17:54:36 PDT 2001
LocationRelation lrLeftJoints =
   new LocationRelation(LR.bodySt, LR.leftJointsSt, LR.inside, LR.left, LR.na, LR.middle);
LocationSet leftJoints = new LocationSet(LR.leftJointsSt, LR.d3, lrLeftJoints);
leftJoints.setSuperset(LR.jointsSt);
leftJoints.setPrintName(L.leftJointsPrintName);

    // rightJoints
// (C) OntoOO Inc Fri Aug 03 17:54:36 PDT 2001
LocationRelation lrRightJoints =
   new LocationRelation(LR.bodySt, LR.rightJointsSt, LR.inside, LR.right, LR.na, LR.middle);
LocationSet rightJoints = new LocationSet(LR.rightJointsSt, LR.d3, lrRightJoints);
rightJoints.setSuperset(LR.jointsSt);
rightJoints.setPrintName(L.rightJointsPrintName);

    // left arm
    String leftArmSt = LR.leftArmSt;
    LocationRelation lrLeftArm = 
      new LocationRelation(LR.bodySt, leftArmSt, LR.inside,
			   LR.left, LR.top, LR.middle);
    PartLocation leftArm = new PartLocation(leftArmSt, LR.d3, lrLeftArm);
    leftArm.addMembership(arms);
leftArm.setPrintName(L.leftArmPrintName);

    // right arm
    String rightArmSt = LR.rightArmSt;
    LocationRelation lrRightArm = 
      new LocationRelation(LR.bodySt, rightArmSt, LR.inside, 
			   LR.right, LR.top, LR.middle);
    PartLocation rightArm = new PartLocation(rightArmSt, LR.d3, lrRightArm);
    rightArm.addMembership(arms);
rightArm.setPrintName(L.rightArmPrintName);

    // left shoulder
    String leftShoulderSt = LR.leftShoulderSt;
    LocationRelation lrLeftShoulder = 
      new LocationRelation(LR.torsoSt, leftShoulderSt, LR.inside, 
			   LR.left, LR.top, LR.middle);
    ConnectionLocation leftShoulder = 
      new ConnectionLocation(leftShoulderSt, LR.d3, lrLeftShoulder,
		       LR.torsoSt, LR.leftArmSt);
    leftShoulder.addMembership(shoulders);
    leftShoulder.addMembership(leftJoints);
leftShoulder.setPrintName(L.leftShoulderPrintName);

    // right shoulder
    String rightShoulderSt = LR.rightShoulderSt;
    LocationRelation lrRightShoulder = 
      new LocationRelation(LR.torsoSt, rightShoulderSt, LR.inside, 
			   LR.right, LR.top, LR.middle);
    ConnectionLocation rightShoulder = 
      new ConnectionLocation(rightShoulderSt, LR.d3, lrRightShoulder,
		       LR.torsoSt, LR.rightArmSt);
    rightShoulder.addMembership(shoulders);
    rightShoulder.addMembership(rightJoints);
rightShoulder.setPrintName(L.rightShoulderPrintName);

    // left leg
    String leftLegSt = LR.leftLegSt;
    LocationRelation lrLeftLeg = 
      new LocationRelation(LR.bodySt, leftLegSt, LR.inside,
			   LR.left, LR.bottom, LR.middle);
    PartLocation leftLeg = new PartLocation(leftLegSt, LR.d3, lrLeftLeg);
    leftLeg.addMembership(legs);
leftLeg.setPrintName(L.leftLegPrintName);

    // right leg
    String rightLegSt = LR.rightLegSt;
    LocationRelation lrRightLeg = 
      new LocationRelation(LR.bodySt, rightLegSt, LR.inside, 
			   LR.right, LR.bottom, LR.middle);
    PartLocation rightLeg = new PartLocation(rightLegSt, LR.d3, lrRightLeg);
    rightLeg.addMembership(legs);
rightLeg.setPrintName(L.rightLegPrintName);

    // left hip
    String leftHipSt = LR.leftHipSt;
    LocationRelation lrLeftHip = 
      new LocationRelation(LR.bodySt, leftHipSt, LR.inside, 
			   LR.left, LR.top, LR.middle);
    ConnectionLocation leftHip = 
      new ConnectionLocation(leftHipSt, LR.d3, lrLeftHip,
		       LR.torsoSt, LR.leftLegSt);
    leftHip.addMembership(hips);
    leftHip.addMembership(leftJoints);
leftHip.setPrintName(L.leftHipPrintName);

    // right hip
    String rightHipSt = LR.rightHipSt;
    LocationRelation lrRightHip = 
      new LocationRelation(LR.bodySt, rightHipSt, LR.inside, 
			   LR.right, LR.top, LR.middle);
    ConnectionLocation rightHip = 
      new ConnectionLocation(rightHipSt, LR.d3, lrRightHip,
		       LR.torsoSt, LR.rightLegSt);
    rightHip.addMembership(hips);
    rightHip.addMembership(rightJoints);
rightHip.setPrintName(L.rightHipPrintName);

// -------------- digits --------------
// (C) OntoOO Inc Mon Aug 23 19:26:53 GMT-08:00 2004
LocationRelation lrDigits =
   new LocationRelation(LR.limbsSt, LR.digitsSt, LR.inside, LR.na, LR.na, LR.na);
LocationSet digits = new LocationSet(LR.digitsSt, LR.d3, lrDigits);
digits.setPrintName(L.digitsPrintName);


    // Here are locations that cross sublocation boundaries
    // Their additional relationships are given in InitMultiParts

    // spine
    String spineSt = LR.spineSt;
    LocationRelation lrSpine = 
      new LocationRelation(bodySt, spineSt, LR.inside, 
			   LR.middle, LR.middle, LR.back);
    PartLocation spine = new PartLocation(spineSt, LR.d1, lrSpine);
spine.setPrintName(L.spinePrintName);

    // skin
    String skinSt = LR.skinSt;
    LocationRelation lrSkin = 
      new LocationRelation(bodySt, skinSt, LR.surface, 
			   LR.na, LR.na, LR.na);
    PartLocation skin = new PartLocation(skinSt, LR.d2, lrSkin);
skin.setPrintName(L.skinPrintName);

    // mucousMembranes
// (C) OntoOO Inc Sat Nov 03 11:01:38 PST 2001
LocationRelation lrMucousMembranes =
   new LocationRelation(LR.bodySt, LR.mucousMembranesSt, LR.surface, 
			LR.na, LR.na, LR.front);
LocationSet mucousMembranes = 
   new LocationSet(LR.mucousMembranesSt, LR.d3, lrMucousMembranes);
mucousMembranes.setPrintName(L.mucousMembranesPrintName);

// (C) OntoOO Inc Tue Aug 07 19:51:45 PDT 2001
LocationRelation lrLymphNodes =
   new LocationRelation(LR.bodySt, LR.lymphNodesSt, LR.inside, LR.na, LR.na, LR.na);
LocationSet lymphNodes = new LocationSet(LR.lymphNodesSt, LR.d3, lrLymphNodes);
lymphNodes.setPrintName(L.lymphNodesPrintName);

// -------------- aLymphNode --------------
// (C) OntoOO Inc Mon Jan 20 12:19:08 PST 2003
LocationRelation lrALymphNode =
   new LocationRelation(LR.bodySt, LR.aLymphNodeSt, LR.inside, LR.na, LR.na, LR.na);
PartLocation aLymphNode = new PartLocation(LR.aLymphNodeSt, LR.d3, lrALymphNode);
aLymphNode.addMembership(LR.lymphNodesSt);
aLymphNode.setPrintName(L.aLymphNodePrintName);

// (C) OntoOO Inc Wed Aug 22 17:02:03 PDT 2001
LocationRelation lrArmPits =
   new LocationRelation(LR.bodySt, LR.armPitsSt, LR.inside, LR.na, LR.top, LR.na);
LocationSet armPits = new LocationSet(LR.armPitsSt, LR.d3, lrArmPits);
LocationRelation lrArmPitsArms =
   new LocationRelation(LR.armPitsSt, LR.armsSt, LR.adjacent, LR.na, LR.top, LR.middle);
armPits.addAdjacent(lrArmPitsArms);
LocationRelation lrArmPitsShoulders =
   new LocationRelation(LR.armPitsSt, LR.shouldersSt, LR.adjacent, 
			LR.na, LR.bottom, LR.middle);
armPits.addAdjacent(lrArmPitsShoulders);
armPits.setPrintName(L.armPitsPrintName);


// (C) OntoOO Inc Wed Aug 22 17:09:02 PDT 2001
LocationRelation lrLeftArmPit =
   new LocationRelation(LR.bodySt, LR.leftArmPitSt, LR.inside, 
			LR.left, LR.top, LR.middle);
PartLocation leftArmPit = new PartLocation(LR.leftArmPitSt, LR.d3, lrLeftArmPit);
leftArmPit.addMembership(LR.armPitsSt);
LocationRelation lrLeftArmPitLeftArm =
   new LocationRelation(LR.leftArmPitSt, LR.leftArmSt, LR.adjacent, 
			LR.right, LR.top, LR.middle);
leftArmPit.addAdjacent(lrLeftArmPitLeftArm);
LocationRelation lrLeftArmPitLeftShoulder =
   new LocationRelation(LR.leftArmPitSt, LR.leftShoulderSt, LR.adjacent, 
			LR.middle, LR.bottom, LR.middle);
leftArmPit.addAdjacent(lrLeftArmPitLeftShoulder);
leftArmPit.setPrintName(L.leftArmPitPrintName);

// (C) OntoOO Inc Wed Aug 22 17:11:14 PDT 2001
LocationRelation lrRightArmPit =
   new LocationRelation(LR.bodySt, LR.rightArmPitSt, LR.inside, 
			LR.right, LR.top, LR.middle);
PartLocation rightArmPit = new PartLocation(LR.rightArmPitSt, LR.d3, lrRightArmPit);
rightArmPit.addMembership(LR.armPitsSt);
LocationRelation lrRightArmPitRightArm =
   new LocationRelation(LR.rightArmPitSt, LR.rightArmSt, LR.adjacent, LR.left, 
			LR.top, LR.middle);
rightArmPit.addAdjacent(lrRightArmPitRightArm);
LocationRelation lrRightArmPitRightShoulder =
   new LocationRelation(LR.rightArmPitSt, LR.rightShoulderSt, LR.adjacent, 
			LR.middle, LR.bottom, LR.middle);
rightArmPit.addAdjacent(lrRightArmPitRightShoulder);
rightArmPit.setPrintName(L.rightArmPitPrintName);

       // glands
// (C) OntoOO Inc Wed Oct 03 09:25:48 PDT 2001
LocationRelation lrGlands =
   new LocationRelation(LR.bodySt, LR.glandsSt, LR.inside, LR.na, LR.na, LR.na);
LocationSet glands = new LocationSet(LR.glandsSt, LR.d3, lrGlands);
glands.setPrintName(L.glandsPrintName);

       // nerves
// (C) OntoOO Inc Mon Oct 22 18:57:38 PDT 2001
LocationRelation lrNerves =
   new LocationRelation(LR.bodySt, LR.nervesSt, LR.inside, LR.na, LR.na, LR.na);
LocationSet nerves = new LocationSet(LR.nervesSt, LR.d1, lrNerves);
nerves.setPrintName(L.nervesPrintName);

       // bloodstream
// (C) OntoOO Inc Mon Oct 22 19:25:00 PDT 2001
LocationRelation lrBloodstream =
   new LocationRelation(LR.bodySt, LR.bloodstreamSt, LR.inside, LR.na, LR.na, LR.na);
PartLocation bloodstream = new PartLocation(LR.bloodstreamSt, LR.d3, lrBloodstream);
bloodstream.setPrintName(L.bloodstreamPrintName);

// -------------- nails --------------
// (C) OntoOO Inc Thu Dec 06 21:18:30 PST 2001
LocationRelation lrNails =
   new LocationRelation(LR.skinSt, LR.nailsSt, LR.surface, 
			LR.na, LR.na, LR.na);
LocationSet nails = new LocationSet(LR.nailsSt, LR.d2, lrNails);
nails.setPrintName(L.nailsPrintName);

    // Create phantom entities to force the generation of typical elements:
    // Bone phantomBone = new Bone();
    // Muscle phantomMuscle = new Muscle();
    // Tendon phantomTendon = new Tendon();
    // Organ phantomOrgan = new Organ();
    // Vein phantomVein = new Vein();

    String aBoneSt = LR.aBoneSt;
    LocationRelation lrABone = 
      new LocationRelation(bodySt, aBoneSt, LR.inside, 
			   LR.na, LR.na, LR.na);
    Bone aBone = new Bone(aBoneSt, LR.d3, lrABone);
aBone.setPrintName(L.aBonePrintName);

    String aMuscleSt = LR.aMuscleSt;
    LocationRelation lrAMuscle = 
      new LocationRelation(bodySt, aMuscleSt, LR.inside, 
			   LR.na, LR.na, LR.na);
    Muscle aMuscle = new Muscle(aMuscleSt, LR.d3, lrAMuscle);
aMuscle.setPrintName(L.aMusclePrintName);

    String aTendonSt = LR.aTendonSt;
    LocationRelation lrATendon = 
      new LocationRelation(bodySt, aTendonSt, LR.inside, 
			   LR.na, LR.na, LR.na);
    Tendon aTendon = new Tendon(aTendonSt, LR.d1, lrATendon, aBoneSt, aMuscleSt);
aTendon.setPrintName(L.aTendonPrintName);

    String anOrganSt = LR.anOrganSt;
    LocationRelation lrAnOrgan = 
      new LocationRelation(torsoSt, anOrganSt, LR.inside, 
			   LR.na, LR.d3, LR.na);
    Organ anOrgan = new Organ(anOrganSt, LR.d3, lrAnOrgan);
anOrgan.setPrintName(L.anOrganPrintName);

    String aVeinSt = LR.aVeinSt;
    LocationRelation lrAVein = 
      new LocationRelation(bodySt, aVeinSt, LR.inside, 
			   LR.na, LR.na, LR.na);
    Vein aVein = new Vein(aVeinSt, LR.d1, lrAVein);
aVein.setPrintName(L.aVeinPrintName);


// -------------- buttock --------------
// (C) OntoOO Inc Sun Mar 30 15:56:20 PST 2003
LocationRelation lrButtock =
   new LocationRelation(LR.hipsSt, LR.buttockSt, LR.inside, LR.leftToRight, LR.topToBottom, LR.back);
PartLocation buttock = new PartLocation(LR.buttockSt, LR.d3, lrButtock);
LocationRelation lrButtockAMuscle =
   new LocationRelation(LR.aMuscleSt, LR.buttockSt, LR.inside, LR.na, LR.na, LR.na);
buttock.addAlsoPartOf(lrButtockAMuscle);
buttock.setPrintName(L.buttockPrintName);



  } // end of doit()

} // end of InitBody


