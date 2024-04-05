// (C) OntoOO Inc 2000
package init;

import com.Common;
import com.LR;
import com.L;
import concepts.LocationSet;
import concepts.LocationRelation;
import concepts.PartLocation;
import concepts.ConnectionLocation;

public class InitLegs {
  public static void doit() {


    // legs
    String legsSt = LR.legsSt;
    LocationSet legs = (LocationSet) Common.getLocation(legsSt);

    // left leg
    String leftLegSt = LR.leftLegSt;

    // right leg
    String rightLegSt = LR.rightLegSt;

    // upperLegs
    String upperLegsSt = LR.upperLegsSt;
    LocationRelation lrUpperLegs = 
      new LocationRelation(legsSt, upperLegsSt, LR.inside, LR.na, LR.top, LR.middle);
    LocationSet upperLegs = new LocationSet(upperLegsSt, LR.d3, lrUpperLegs);
upperLegs.setPrintName(L.upperLegsPrintName);

    // thighs
// (C) OntoOO Inc Sat Nov 03 14:44:57 PST 2001
LocationRelation lrThighs =
   new LocationRelation(LR.upperLegsSt, LR.thighsSt, LR.inside, 
			LR.na, LR.top, LR.front);
LocationSet thighs = new LocationSet(LR.thighsSt, LR.d3, lrThighs);
thighs.setPrintName(L.thighsPrintName);

// groin (a set !!)
// (C) OntoOO Inc Sat Nov 03 14:49:07 PST 2001
LocationRelation lrGroin =
   new LocationRelation(LR.torsoSt, LR.groinSt, LR.inside, 
			LR.na, LR.bottom, LR.front);
LocationSet groin = new LocationSet(LR.groinSt, LR.d3, lrGroin);
LocationRelation lrGroinAbdomen =
   new LocationRelation(LR.groinSt, LR.abdomenSt, LR.adjacent, 
			LR.na, LR.top, LR.middle);
groin.addAdjacent(lrGroinAbdomen);
LocationRelation lrGroinThighs =
   new LocationRelation(LR.groinSt, LR.thighsSt, LR.adjacent, 
			LR.na, LR.bottom, LR.middle);
groin.addAdjacent(lrGroinThighs);
groin.setPrintName(L.groinPrintName);

    // left upperLeg
    String leftUpperLegSt = LR.leftUpperLegSt;
    LocationRelation lrLeftUpperLeg = 
      new LocationRelation(leftLegSt, leftUpperLegSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation leftUpperLeg = new PartLocation(leftUpperLegSt, LR.d3, lrLeftUpperLeg);
    leftUpperLeg.addMembership(upperLegs);
leftUpperLeg.setPrintName(L.leftUpperLegPrintName);

    // right upperLeg
    String rightUpperLegSt = LR.rightUpperLegSt;
    LocationRelation lrRightUpperLeg = 
      new LocationRelation(rightLegSt, rightUpperLegSt, LR.inside, 
			   LR.middle, LR.top, LR.middle);
    PartLocation rightUpperLeg = 
      new PartLocation(rightUpperLegSt, LR.d3, lrRightUpperLeg);
    rightUpperLeg.addMembership(upperLegs);
rightUpperLeg.setPrintName(L.rightUpperLegPrintName);

   // lowerLegs
    String lowerLegsSt = LR.lowerLegsSt;
    LocationRelation lrLowerLegs = 
      new LocationRelation(legsSt, lowerLegsSt, LR.inside, LR.na, LR.bottom, LR.middle);
    LocationSet lowerLegs = new LocationSet(lowerLegsSt, LR.d3, lrLowerLegs);
lowerLegs.setPrintName(L.lowerLegsPrintName);

    // left lowerLeg
    String leftLowerLegSt = LR.leftLowerLegSt;
    LocationRelation lrLeftLowerLeg = 
      new LocationRelation(leftLegSt, leftLowerLegSt, LR.inside,
			   LR.middle, LR.bottom, LR.middle);
    PartLocation leftLowerLeg = new PartLocation(leftLowerLegSt, LR.d3, lrLeftLowerLeg);
    leftLowerLeg.addMembership(lowerLegs);
leftLowerLeg.setPrintName(L.leftLowerLegPrintName);

    // right lowerLeg
    String rightLowerLegSt = LR.rightLowerLegSt;
    LocationRelation lrRightLowerLeg = 
      new LocationRelation(rightLegSt, rightLowerLegSt, LR.inside, 
			   LR.middle, LR.bottom, LR.middle);
    PartLocation rightLowerLeg = 
      new PartLocation(rightLowerLegSt, LR.d3, lrRightLowerLeg);
    rightLowerLeg.addMembership(lowerLegs);
rightLowerLeg.setPrintName(L.rightLowerLegPrintName);

   // knees
    String kneesSt = LR.kneesSt;
    LocationRelation lrKnees = 
      new LocationRelation(legsSt, kneesSt, LR.inside, LR.na, LR.middle, LR.middle);
    LocationSet knees = new LocationSet(kneesSt, LR.d3, lrKnees);
    knees.setSuperset(LR.jointsSt); 
knees.setPrintName(L.kneesPrintName);

    // left knee
    String leftKneeSt = LR.leftKneeSt;
    LocationRelation lrLeftKnee = 
      new LocationRelation(leftLegSt, leftKneeSt, LR.inside,
			   LR.middle, LR.middle, LR.middle);
    ConnectionLocation leftKnee = 
      new ConnectionLocation(leftKneeSt, LR.d3, lrLeftKnee,
			     leftUpperLegSt, leftLowerLegSt );
    leftKnee.addMembership(knees);
    leftKnee.addMembership(LR.leftJointsSt);
leftKnee.setPrintName(L.leftKneePrintName);

    // right knee
    String rightKneeSt = LR.rightKneeSt;
    LocationRelation lrRightKnee = 
      new LocationRelation(rightLegSt, rightKneeSt, LR.inside,
			   LR.middle, LR.middle, LR.middle);
    ConnectionLocation rightKnee = 
      new ConnectionLocation(rightKneeSt, LR.d3, lrRightKnee,
			     rightUpperLegSt, rightLowerLegSt );
    rightKnee.addMembership(knees);
    rightKnee.addMembership(LR.rightJointsSt);
rightKnee.setPrintName(L.rightKneePrintName);

   // shins
    String shinsSt = LR.shinsSt;
    LocationRelation lrShins = 
      new LocationRelation(lowerLegsSt, shinsSt, LR.surface, LR.na, LR.middle, LR.front);
    LocationSet shins = new LocationSet(shinsSt, LR.d2, lrShins);
shins.setPrintName(L.shinsPrintName);

    // foots
    String footsSt = LR.feetSt;
    LocationRelation lrFoots = 
      new LocationRelation(lowerLegsSt, footsSt, LR.inside, LR.na, LR.bottom, LR.middle);
    LocationSet foots = new LocationSet(footsSt, LR.d3, lrFoots);
foots.setPrintName(L.feetPrintName);

    // left foot
    String leftFootSt = LR.leftFootSt;
    LocationRelation lrLeftFoot = 
      new LocationRelation(leftLegSt, leftFootSt, LR.inside,
			   LR.middle, LR.bottom, LR.middle);
    PartLocation leftFoot = new PartLocation(leftFootSt, LR.d3, lrLeftFoot);
    leftFoot.addMembership(foots);
leftFoot.setPrintName(L.leftFootPrintName);

    // right foot
    String rightFootSt = LR.rightFootSt;
    LocationRelation lrRightFoot = 
      new LocationRelation(rightLegSt, rightFootSt, LR.inside, 
			   LR.middle, LR.bottom, LR.middle);
    PartLocation rightFoot = new PartLocation(rightFootSt, LR.d3, lrRightFoot);
    rightFoot.addMembership(foots);
rightFoot.setPrintName(L.rightFootPrintName);

    // ankles
    String anklesSt = LR.anklesSt;
    LocationRelation lrAnkles = 
      new LocationRelation(legsSt, anklesSt, LR.inside, LR.na, LR.bottom, LR.middle);
    LocationSet ankles = new LocationSet(anklesSt, LR.d3, lrAnkles);
    ankles.setSuperset(LR.jointsSt); 
ankles.setPrintName(L.anklesPrintName);

    // left ankle
    String leftAnkleSt = LR.leftAnkleSt;
    LocationRelation lrLeftAnkle = 
      new LocationRelation(leftLegSt, leftAnkleSt, LR.inside,
			   LR.middle, LR.bottom, LR.middle);
    ConnectionLocation leftAnkle = 
      new ConnectionLocation(leftAnkleSt, LR.d3, lrLeftAnkle,
			     leftLowerLegSt, leftFootSt );
    leftAnkle.addMembership(ankles);
    leftAnkle.addMembership(LR.leftJointsSt);
leftAnkle.setPrintName(L.leftAnklePrintName);

    // right ankle
    String rightAnkleSt = LR.rightAnkleSt;
    LocationRelation lrRightAnkle = 
      new LocationRelation(rightLegSt, rightAnkleSt, LR.inside,
			   LR.middle, LR.bottom, LR.middle);
    ConnectionLocation rightAnkle = 
      new ConnectionLocation(rightAnkleSt, LR.d3, lrRightAnkle,
			     rightLowerLegSt, rightFootSt );
    rightAnkle.addMembership(ankles);
    rightAnkle.addMembership(LR.rightJointsSt);
rightAnkle.setPrintName(L.rightAnklePrintName);

    // toes
    String toesSt = LR.toesSt;
    LocationRelation lrToes = 
      new LocationRelation(footsSt, toesSt, LR.inside, LR.na, LR.bottom, LR.middle);
    LocationSet toes = new LocationSet(toesSt, LR.d3, lrToes);
    toes.setSuperset(LR.digitsSt);
toes.setPrintName(L.toesPrintName);

// -------------- toeNails --------------
// (C) OntoOO Inc Mon Jun 30 13:47:07 PDT 2003
LocationRelation lrToeNails =
   new LocationRelation(LR.toesSt, LR.toeNailsSt, LR.surface, 
			LR.leftToRight, LR.top, LR.front);
LocationSet toeNails = new LocationSet(LR.toeNailsSt, LR.d2, lrToeNails);
toeNails.setSuperset(LR.nailsSt);
toeNails.setPrintName(L.toeNailsPrintName);

    // left toes
    String leftToesSt = LR.leftToesSt;
    LocationRelation lrLeftToes = 
      new LocationRelation(leftFootSt, leftToesSt, LR.inside,
			   LR.middle, LR.bottom, LR.middle);
    LocationSet leftToes = new LocationSet(leftToesSt, LR.d3, lrLeftToes);
    leftToes.addMembership(toes);
leftToes.setPrintName(L.leftToesPrintName);

    // right toes
    String rightToesSt = LR.rightToesSt;
    LocationRelation lrRightToes = 
      new LocationRelation(rightFootSt, rightToesSt, LR.inside, 
			   LR.middle, LR.bottom, LR.middle);
    LocationSet rightToes = new LocationSet(rightToesSt, LR.d3, lrRightToes);
    rightToes.addMembership(toes);
rightToes.setPrintName(L.rightToesPrintName);

    // largeToes
    String largeToesSt = LR.largeToesSt;
    LocationRelation lrLargeToes = 
      new LocationRelation(toesSt, largeToesSt, LR.inside, LR.na, LR.top, LR.middle);
    LocationSet largeToes = new LocationSet(largeToesSt, LR.d3, lrLargeToes);
largeToes.setPrintName(L.largeToesPrintName);

    // indexToes
    String indexToesSt = LR.indexToesSt;
    LocationRelation lrIndexToes = 
      new LocationRelation(toesSt, indexToesSt, LR.inside, LR.na, LR.top, LR.middle);
    LocationSet indexToes = new LocationSet(indexToesSt, LR.d3, lrIndexToes);
indexToes.setPrintName(L.indexToesPrintName);

    // middleToes
    String middleToesSt = LR.middleToesSt;
    LocationRelation lrMiddleToes = 
      new LocationRelation(toesSt, middleToesSt, LR.inside, LR.na, LR.middle, LR.middle);
    LocationSet middleToes = new LocationSet(middleToesSt, LR.d3, lrMiddleToes);
middleToes.setPrintName(L.middleToesPrintName);

    // ringToes
    String ringToesSt = LR.ringToesSt;
    LocationRelation lrRingToes = 
      new LocationRelation(toesSt, ringToesSt, LR.inside, LR.na, LR.bottom, LR.middle);
    LocationSet ringToes = new LocationSet(ringToesSt, LR.d3, lrRingToes);
ringToes.setPrintName(L.ringToesPrintName);

    // pinkToes
    String pinkToesSt = LR.pinkToesSt;
    LocationRelation lrPinkToes = 
      new LocationRelation(toesSt, pinkToesSt, LR.inside, LR.na, LR.bottom, LR.middle);
    LocationSet pinkToes = new LocationSet(pinkToesSt, LR.d3, lrPinkToes);
pinkToes.setPrintName(L.pinkToesPrintName);

    // left largeToe
    String leftLargeToeSt = LR.leftLargeToeSt;
    LocationRelation lrLeftLargeToe = 
      new LocationRelation(leftFootSt, leftLargeToeSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation leftLargeToe = new PartLocation(leftLargeToeSt, LR.d3, lrLeftLargeToe);
    leftLargeToe.addMembership(largeToes);
    leftLargeToe.addMembership(leftToes);
leftLargeToe.setPrintName(L.leftLargeToePrintName);

    // right largeToe
    String rightLargeToeSt = LR.rightLargeToeSt;
    LocationRelation lrRightLargeToe = 
      new LocationRelation(rightFootSt, rightLargeToeSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation rightLargeToe = 
      new PartLocation(rightLargeToeSt, LR.d3, lrRightLargeToe);
    rightLargeToe.addMembership(largeToes);
    rightLargeToe.addMembership(rightToes);
rightLargeToe.setPrintName(L.rightLargeToePrintName);

    // left indexToe
    String leftIndexToeSt = LR.leftIndexToeSt;
    LocationRelation lrLeftIndexToe = 
      new LocationRelation(leftFootSt, leftIndexToeSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation leftIndexToe = new PartLocation(leftIndexToeSt, LR.d3, lrLeftIndexToe);
    leftIndexToe.addMembership(indexToes);
    leftIndexToe.addMembership(leftToes);
leftIndexToe.setPrintName(L.leftIndexToePrintName);

    // right indexToe
    String rightIndexToeSt = LR.rightIndexToeSt;
    LocationRelation lrRightIndexToe = 
      new LocationRelation(rightFootSt, rightIndexToeSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation rightIndexToe = 
      new PartLocation(rightIndexToeSt, LR.d3, lrRightIndexToe);
    rightIndexToe.addMembership(indexToes);
    rightIndexToe.addMembership(rightToes);
rightIndexToe.setPrintName(L.rightIndexToePrintName);

    // left middleToe
    String leftMiddleToeSt = LR.leftMiddleToeSt;
    LocationRelation lrLeftMiddleToe = 
      new LocationRelation(leftFootSt, leftMiddleToeSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation leftMiddleToe = 
      new PartLocation(leftMiddleToeSt, LR.d3, lrLeftMiddleToe);
    leftMiddleToe.addMembership(middleToes);
    leftMiddleToe.addMembership(leftToes);
leftMiddleToe.setPrintName(L.leftMiddleToePrintName);

    // right middleToe
    String rightMiddleToeSt = LR.rightMiddleToeSt;
    LocationRelation lrRightMiddleToe = 
      new LocationRelation(rightFootSt, rightMiddleToeSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation rightMiddleToe = 
      new PartLocation(rightMiddleToeSt, LR.d3, lrRightMiddleToe);
    rightMiddleToe.addMembership(middleToes);
    rightMiddleToe.addMembership(rightToes);
rightMiddleToe.setPrintName(L.rightMiddleToePrintName);

    // left ringToe
    String leftRingToeSt = LR.leftRingToeSt;
    LocationRelation lrLeftRingToe = 
      new LocationRelation(leftFootSt, leftRingToeSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation leftRingToe = new PartLocation(leftRingToeSt, LR.d3, lrLeftRingToe);
    leftRingToe.addMembership(ringToes);
    leftRingToe.addMembership(leftToes);
leftRingToe.setPrintName(L.leftRingToePrintName);

    // right ringToe
    String rightRingToeSt = LR.rightRingToeSt;
    LocationRelation lrRightRingToe = 
      new LocationRelation(rightFootSt, rightRingToeSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation rightRingToe = new PartLocation(rightRingToeSt, LR.d3, lrRightRingToe);
    rightRingToe.addMembership(ringToes);
    rightRingToe.addMembership(rightToes);
rightRingToe.setPrintName(L.rightRingToePrintName);

    // left pinkToe
    String leftPinkToeSt = LR.leftPinkToeSt;
    LocationRelation lrLeftPinkToe = 
      new LocationRelation(leftFootSt, leftPinkToeSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation leftPinkToe = new PartLocation(leftPinkToeSt, LR.d3, lrLeftPinkToe);
    leftPinkToe.addMembership(pinkToes);
    leftPinkToe.addMembership(leftToes);
leftPinkToe.setPrintName(L.leftPinkToePrintName);

    // right pinkToe
    String rightPinkToeSt = LR.rightPinkToeSt;
    LocationRelation lrRightPinkToe = 
      new LocationRelation(rightFootSt, rightPinkToeSt, LR.inside,
			   LR.middle, LR.top, LR.middle);
    PartLocation rightPinkToe = new PartLocation(rightPinkToeSt, LR.d3, lrRightPinkToe);
    rightPinkToe.addMembership(pinkToes);
    rightPinkToe.addMembership(rightToes);
rightPinkToe.setPrintName(L.rightPinkToePrintName);


  } // end of main(...)

} // end of InitLegs
