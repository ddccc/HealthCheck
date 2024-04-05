// (C) OntoOO Inc 2000
package init;

import com.Common;
import com.LR;
import com.L;
import concepts.*;


public class InitArms {
  public static void doit() {

    // arms
    String armsSt = LR.armsSt;
    LocationSet arms = (LocationSet) Common.getLocation(armsSt);

    // left arm
    String leftArmSt = LR.leftArmSt;

    // right arm
    String rightArmSt = LR.rightArmSt;

    // upperArms
    String upperArmsSt = LR.upperArmsSt;
    LocationRelation lrUpperArms = 
      new LocationRelation(armsSt, upperArmsSt, LR.inside, LR.na, LR.top, LR.middle);
    LocationSet upperArms = new LocationSet(upperArmsSt, LR.d3, lrUpperArms);
upperArms.setPrintName(L.upperArmsPrintName);

    // left upperArm
    String leftUpperArmSt = LR.leftUpperArmSt;
    LocationRelation lrLeftUpperArm = 
      new LocationRelation(leftArmSt, leftUpperArmSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation leftUpperArm = new PartLocation(leftUpperArmSt, LR.d3, lrLeftUpperArm);
    leftUpperArm.addMembership(upperArms);
leftUpperArm.setPrintName(L.leftUpperArmPrintName);

    // right upperArm
    String rightUpperArmSt = LR.rightUpperArmSt;
    LocationRelation lrRightUpperArm = 
      new LocationRelation(rightArmSt, rightUpperArmSt, LR.inside, 
			   LR.middle, LR.top, LR.middle);
    PartLocation rightUpperArm = 
      new PartLocation(rightUpperArmSt, LR.d3, lrRightUpperArm);
    rightUpperArm.addMembership(upperArms);
rightUpperArm.setPrintName(L.rightUpperArmPrintName);

   // lowerArms
    String lowerArmsSt = LR.lowerArmsSt;
    LocationRelation lrLowerArms = 
      new LocationRelation(armsSt, lowerArmsSt, LR.inside, LR.na, LR.bottom, LR.middle);
    LocationSet lowerArms = new LocationSet(lowerArmsSt, LR.d3, lrLowerArms);
lowerArms.setPrintName(L.lowerArmsPrintName);

    // left lowerArm
    String leftLowerArmSt = LR.leftLowerArmSt;
    LocationRelation lrLeftLowerArm = 
      new LocationRelation(leftArmSt, leftLowerArmSt, LR.inside,
			   LR.middle, LR.bottom, LR.middle);
    PartLocation leftLowerArm = new PartLocation(leftLowerArmSt, LR.d3, lrLeftLowerArm);
    leftLowerArm.addMembership(lowerArms);
leftLowerArm.setPrintName(L.leftLowerArmPrintName);

    // right lowerArm
    String rightLowerArmSt = LR.rightLowerArmSt;
    LocationRelation lrRightLowerArm = 
      new LocationRelation(rightArmSt, rightLowerArmSt, LR.inside, 
			   LR.middle, LR.bottom, LR.middle);
    PartLocation rightLowerArm = 
      new PartLocation(rightLowerArmSt, LR.d3, lrRightLowerArm);
    rightLowerArm.addMembership(lowerArms);
rightLowerArm.setPrintName(L.rightLowerArmPrintName);

   // elbows
    String elbowsSt = LR.elbowsSt;
    LocationRelation lrElbows = 
      new LocationRelation(armsSt, elbowsSt, LR.inside, LR.na, LR.middle, LR.middle);
    LocationSet elbows = new LocationSet(elbowsSt, LR.d3, lrElbows);
    elbows.setSuperset(LR.jointsSt); 
elbows.setPrintName(L.elbowsPrintName);

    // left elbow
    String leftElbowSt = LR.leftElbowSt;
    LocationRelation lrLeftElbow = 
      new LocationRelation(leftArmSt, leftElbowSt, LR.inside,
			   LR.middle, LR.middle, LR.middle);
    ConnectionLocation leftElbow = 
      new ConnectionLocation(leftElbowSt, LR.d3, lrLeftElbow,
			     leftUpperArmSt, leftLowerArmSt );
    leftElbow.addMembership(elbows);
    leftElbow.addMembership(LR.leftJointsSt);
leftElbow.setPrintName(L.leftElbowPrintName);

    // right elbow
    String rightElbowSt = LR.rightElbowSt;
    LocationRelation lrRightElbow = 
      new LocationRelation(rightArmSt, rightElbowSt, LR.inside,
			   LR.middle, LR.middle, LR.middle);
    ConnectionLocation rightElbow = 
      new ConnectionLocation(rightElbowSt, LR.d3, lrRightElbow,
			     rightUpperArmSt, rightLowerArmSt );
    rightElbow.addMembership(elbows);
    rightElbow.addMembership(LR.rightJointsSt);
rightElbow.setPrintName(L.rightElbowPrintName);

    // hands
    String handsSt = LR.handsSt;
    LocationRelation lrHands = 
      new LocationRelation(armsSt, handsSt, LR.inside, LR.na, LR.bottom, LR.middle);
    LocationSet hands = new LocationSet(handsSt, LR.d3, lrHands);
hands.setPrintName(L.handsPrintName);

// -------------- palms --------------
// (C) OntoOO Inc Thu Dec 06 21:29:31 PST 2001
LocationRelation lrPalms =
   new LocationRelation(LR.handsSt, LR.palmsSt, LR.surface, LR.na, LR.top, LR.front);
LocationSet palms = new LocationSet(LR.palmsSt, LR.d2, lrPalms);
palms.setPrintName(L.palmsPrintName);

    // left hand
    String leftHandSt = LR.leftHandSt;
    LocationRelation lrLeftHand = 
      new LocationRelation(leftArmSt, leftHandSt, LR.inside,
			   LR.middle, LR.bottom, LR.middle);
    PartLocation leftHand = new PartLocation(leftHandSt, LR.d3, lrLeftHand);
    leftHand.addMembership(hands);
leftHand.setPrintName(L.leftHandPrintName);

    // right hand
    String rightHandSt = LR.rightHandSt;
    LocationRelation lrRightHand = 
      new LocationRelation(rightArmSt, rightHandSt, LR.inside, 
			   LR.middle, LR.bottom, LR.middle);
    PartLocation rightHand = new PartLocation(rightHandSt, LR.d3, lrRightHand);
    rightHand.addMembership(hands);
rightHand.setPrintName(L.rightHandPrintName);

    // wrists
    String wristsSt = LR.wristsSt;
    LocationRelation lrWrists = 
      new LocationRelation(armsSt, wristsSt, LR.inside, LR.na, LR.bottom, LR.middle);
    LocationSet wrists = new LocationSet(wristsSt, LR.d3, lrWrists);
    wrists.setSuperset(LR.jointsSt); 
wrists.setPrintName(L.wristsPrintName);

    // left wrist
    String leftWristSt = LR.leftWristSt;
    LocationRelation lrLeftWrist = 
      new LocationRelation(leftArmSt, leftWristSt, LR.inside,
			   LR.middle, LR.bottom, LR.middle);
    ConnectionLocation leftWrist = 
      new ConnectionLocation(leftWristSt, LR.d3, lrLeftWrist,
			     leftLowerArmSt, leftHandSt );
    leftWrist.addMembership(wristsSt);
    leftWrist.addMembership(LR.leftJointsSt);
leftWrist.setPrintName(L.leftWristPrintName);

    // right wrist
    String rightWristSt = LR.rightWristSt;
    LocationRelation lrRightWrist = 
      new LocationRelation(rightArmSt, rightWristSt, LR.inside,
			   LR.middle, LR.bottom, LR.middle);
    ConnectionLocation rightWrist = 
      new ConnectionLocation(rightWristSt, LR.d3, lrRightWrist,
			     rightLowerArmSt, rightHandSt );
    rightWrist.addMembership(wristsSt);
    rightWrist.addMembership(LR.rightJointsSt);
rightWrist.setPrintName(L.rightWristPrintName);

    // fingers
    String fingersSt = LR.fingersSt;
    LocationRelation lrFingers = 
      new LocationRelation(handsSt, fingersSt, LR.inside, LR.na, LR.bottom, LR.middle);
    LocationSet fingers = new LocationSet(fingersSt, LR.d3, lrFingers);
    fingers.setSuperset(LR.digitsSt);
fingers.setPrintName(L.fingersPrintName);

// -------------- fingerNails --------------
// (C) OntoOO Inc Mon Jun 30 13:45:46 PDT 2003
LocationRelation lrFingerNails =
   new LocationRelation(LR.fingersSt, LR.fingerNailsSt, LR.surface, 
			LR.leftToRight, LR.top, LR.front);
LocationSet fingerNails = new LocationSet(LR.fingerNailsSt, LR.d2, lrFingerNails);
fingerNails.setSuperset(LR.nailsSt);
fingerNails.setPrintName(L.fingerNailsPrintName);

    // left fingers
    String leftFingersSt = LR.leftFingersSt;
    LocationRelation lrLeftFingers = 
      new LocationRelation(leftHandSt, leftFingersSt, LR.inside,
			   LR.middle, LR.bottom, LR.middle);
    LocationSet leftFingers = new LocationSet(leftFingersSt, LR.d3, lrLeftFingers);
    leftFingers.addMembership(fingers);
leftFingers.setPrintName(L.leftFingersPrintName);

    // right fingers
    String rightFingersSt = LR.rightFingersSt;
    LocationRelation lrRightFingers = 
      new LocationRelation(rightHandSt, rightFingersSt, LR.inside, 
			   LR.middle, LR.bottom, LR.middle);
    LocationSet rightFingers = new LocationSet(rightFingersSt, LR.d3, lrRightFingers);
    rightFingers.addMembership(fingers);
rightFingers.setPrintName(L.rightFingersPrintName);

    // thumbs
    String thumbsSt = LR.thumbsSt;
    LocationRelation lrThumbs = 
      new LocationRelation(fingersSt, thumbsSt, LR.inside, LR.na, LR.top, LR.middle);
    LocationSet thumbs = new LocationSet(thumbsSt, LR.d3, lrThumbs);
thumbs.setPrintName(L.thumbsPrintName);

    // indexes
    String indexesSt = LR.indexesSt;
    LocationRelation lrIndexes = 
      new LocationRelation(fingersSt, indexesSt, LR.inside, LR.na, LR.top, LR.middle);
    LocationSet indexes = new LocationSet(indexesSt, LR.d3, lrIndexes);
indexes.setPrintName(L.indexesPrintName);

    // middleFingers
    String middleFingersSt = LR.middleFingersSt;
    LocationRelation lrMiddleFingers = 
      new LocationRelation(fingersSt, middleFingersSt, LR.inside, 
			   LR.na, LR.middle, LR.middle);
    LocationSet middleFingers = new LocationSet(middleFingersSt, LR.d3, lrMiddleFingers);
middleFingers.setPrintName(L.middleFingersPrintName);

    // ringFingers
    String ringFingersSt = LR.ringFingersSt;
    LocationRelation lrRingFingers = 
      new LocationRelation(fingersSt, ringFingersSt, LR.inside, 
			   LR.na, LR.bottom, LR.middle);
    LocationSet ringFingers = new LocationSet(ringFingersSt, LR.d3, lrRingFingers);
ringFingers.setPrintName(L.ringFingersPrintName);

    // pinks
    String pinksSt = LR.pinksSt;
    LocationRelation lrPinks = 
      new LocationRelation(fingersSt, pinksSt, LR.inside, LR.na, LR.bottom, LR.middle);
    LocationSet pinks = new LocationSet(pinksSt, LR.d3, lrPinks);
pinks.setPrintName(L.pinksPrintName);

    // left thumb
    String leftThumbSt = LR.leftThumbSt;
    LocationRelation lrLeftThumb = 
      new LocationRelation(leftHandSt, leftThumbSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation leftThumb = new PartLocation(leftThumbSt, LR.d3, lrLeftThumb);
    leftThumb.addMembership(thumbs);
    leftThumb.addMembership(leftFingers);
leftThumb.setPrintName(L.leftThumbPrintName);

    // right thumb
    String rightThumbSt = LR.rightThumbSt;
    LocationRelation lrRightThumb = 
      new LocationRelation(rightHandSt, rightThumbSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation rightThumb = new PartLocation(rightThumbSt, LR.d3, lrRightThumb);
    rightThumb.addMembership(thumbs);
    rightThumb.addMembership(rightFingers);
rightThumb.setPrintName(L.rightThumbPrintName);

    // left index
    String leftIndexSt = LR.leftIndexSt;
    LocationRelation lrLeftIndex = 
      new LocationRelation(leftHandSt, leftIndexSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation leftIndex = new PartLocation(leftIndexSt, LR.d3, lrLeftIndex);
    leftIndex.addMembership(indexes);
    leftIndex.addMembership(leftFingers);
leftIndex.setPrintName(L.leftIndexPrintName);

    // right index
    String rightIndexSt = LR.rightIndexSt;
    LocationRelation lrRightIndex = 
      new LocationRelation(rightHandSt, rightIndexSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation rightIndex = new PartLocation(rightIndexSt, LR.d3, lrRightIndex);
    rightIndex.addMembership(indexes);
    rightIndex.addMembership(rightFingers);
rightIndex.setPrintName(L.rightIndexPrintName);

    // left middleFinger
    String leftMiddleFingerSt = LR.leftMiddleFingerSt;
    LocationRelation lrLeftMiddleFinger = 
      new LocationRelation(leftHandSt, leftMiddleFingerSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation leftMiddleFinger = 
      new PartLocation(leftMiddleFingerSt, LR.d3, lrLeftMiddleFinger);
    leftMiddleFinger.addMembership(middleFingers);
    leftMiddleFinger.addMembership(leftFingers);
leftMiddleFinger.setPrintName(L.leftMiddleFingerPrintName);

    // right middleFinger
    String rightMiddleFingerSt = LR.rightMiddleFingerSt;
    LocationRelation lrRightMiddleFinger = 
      new LocationRelation(rightHandSt, rightMiddleFingerSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation rightMiddleFinger = 
      new PartLocation(rightMiddleFingerSt, LR.d3, lrRightMiddleFinger);
    rightMiddleFinger.addMembership(middleFingers);
    rightMiddleFinger.addMembership(rightFingers);
rightMiddleFinger.setPrintName(L.rightMiddleFingerPrintName);

    // left ringFinger
    String leftRingFingerSt = LR.leftRingFingerSt;
    LocationRelation lrLeftRingFinger = 
      new LocationRelation(leftHandSt, leftRingFingerSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation leftRingFinger = 
      new PartLocation(leftRingFingerSt, LR.d3, lrLeftRingFinger);
    leftRingFinger.addMembership(ringFingers);
    leftRingFinger.addMembership(leftFingers);
leftRingFinger.setPrintName(L.leftRingFingerPrintName);

    // right ringFinger
    String rightRingFingerSt = LR.rightRingFingerSt;
    LocationRelation lrRightRingFinger = 
      new LocationRelation(rightHandSt, rightRingFingerSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation rightRingFinger = 
      new PartLocation(rightRingFingerSt, LR.d3, lrRightRingFinger);
    rightRingFinger.addMembership(ringFingers);
    rightRingFinger.addMembership(rightFingers);
rightRingFinger.setPrintName(L.rightRingFingerPrintName);

    // left pink
    String leftPinkSt = LR.leftPinkSt;
    LocationRelation lrLeftPink = 
      new LocationRelation(leftHandSt, leftPinkSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation leftPink = new PartLocation(leftPinkSt, LR.d3, lrLeftPink);
    leftPink.addMembership(pinks);
    leftPink.addMembership(leftFingers);
leftPink.setPrintName(L.leftPinkPrintName);

    // right pink
    String rightPinkSt = LR.rightPinkSt;
    LocationRelation lrRightPink = 
      new LocationRelation(rightHandSt, rightPinkSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation rightPink = new PartLocation(rightPinkSt, LR.d3, lrRightPink);
    rightPink.addMembership(pinks);
    rightPink.addMembership(rightFingers);
rightPink.setPrintName(L.rightPinkPrintName);

    // left palm
    String leftPalmSt = LR.leftPalmSt;
    LocationRelation lrLeftPalm = 
      new LocationRelation(leftHandSt, leftPalmSt, LR.surface,
			   LR.middle, LR.bottom, LR.middle);
    PartLocation leftPalm = new PartLocation(leftPalmSt, LR.d2, lrLeftPalm);
    leftPalm.addMembership(palms);
leftPalm.setPrintName(L.leftPalmPrintName);

    // right palm
    String rightPalmSt = LR.rightPalmSt;
    LocationRelation lrRightPalm = 
      new LocationRelation(rightHandSt, rightPalmSt, LR.surface,
			   LR.middle, LR.bottom, LR.middle);
    PartLocation rightPalm = new PartLocation(rightPalmSt, LR.d2, lrRightPalm);
    rightPalm.addMembership(palms);
rightPalm.setPrintName(L.rightPalmPrintName);

    // phalanges
// (C) OntoOO Inc Wed Aug 08 16:47:39 PDT 2001
LocationRelation lrPhalanges =
   new LocationRelation(LR.fingersSt, LR.phalangesSt, LR.inside, 
			LR.middle, LR.topToBottom, LR.middle);
LocationSet phalanges = new LocationSet(LR.phalangesSt, LR.d3, lrPhalanges);
phalanges.setPrintName(L.phalangesPrintName);


  } // end of main(...)

} // end of InitArms




