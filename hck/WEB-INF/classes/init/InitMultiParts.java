// (C) OntoOO Inc 2000
package init;

import com.Common;
import com.LR;
import com.L;
import concepts.*;

public class InitMultiParts {
  public static void doit() {

    // Here we define locations that cross location boundaries.
    // Hence they are characterized by one all encompassing partof location 
    // and two or more sublocations

    // body
    String bodySt = LR.bodySt;
    Location body = (Location) Common.getLocation(bodySt);

    // spine
    String spineSt = LR.spineSt;
    PartLocation spine = (PartLocation) Common.getLocation(spineSt);
    String neckSt = LR.neckSt;
    LocationRelation lrSpine1 = 
      new LocationRelation(neckSt, spineSt, LR.inside, 
			   LR.middle, LR.topToBottom, LR.back);
    spine.addAlsoPartOf(lrSpine1);
    String torsoSt = LR.torsoSt;
    LocationRelation lrSpine2 = 
      new LocationRelation(torsoSt, spineSt, LR.inside, 
			   LR.middle, LR.topToBottom, LR.back);
    spine.addAlsoPartOf(lrSpine2);
    LocationRelation lrSpineSkull = 
      new LocationRelation(spineSt, LR.skullSt, LR.adjacent, 
			   LR.middle, LR.top, LR.middle);
    spine.addAdjacent(lrSpineSkull);
spine.setPrintName(L.spinePrintName);

    // trachea
    String tracheaSt = LR.tracheaSt;
    LocationRelation lrTrachea = 
      new LocationRelation(bodySt, tracheaSt, LR.inside, LR.middle, LR.middle, LR.middle);
    ConnectionLocation trachea = new ConnectionLocation(
	     tracheaSt, LR.d1, lrTrachea, LR.larynxSt, LR.lungsSt);
    LocationRelation lrTrachea1 = 
      new LocationRelation(neckSt, tracheaSt, LR.inside, 
			   LR.middle, LR.topToBottom, LR.front);
    trachea.addAlsoPartOf(lrTrachea1);
    trachea.addMembership(LR.mucousMembranesSt); 
trachea.setPrintName(L.tracheaPrintName);

    // ribCage
    String ribCageSt = LR.ribCageSt;
    LocationRelation lrTrachea2 = 
      new LocationRelation(ribCageSt, tracheaSt, LR.inside, 
			   LR.middle, LR.topToMiddle, LR.middle);
    trachea.addAlsoPartOf(lrTrachea2);

    String leftLungSt = LR.leftLungSt;
    LocationRelation lrTracheaLeftLung = 
      new LocationRelation(tracheaSt, leftLungSt, LR.adjacent, 
			   LR.left, LR.bottom, LR.middle); // ????
    trachea.addAdjacent(lrTracheaLeftLung);
    String rightLungSt = LR.rightLungSt;
    LocationRelation lrTracheaRightLung = 
      new LocationRelation(tracheaSt, rightLungSt, LR.adjacent, 
			   LR.right, LR.bottom, LR.middle); // ????
    trachea.addAdjacent(lrTracheaRightLung);

    // esophagus
    String esophagusSt = LR.esophagusSt;
    LocationRelation lrEsophagus = 
      new LocationRelation(bodySt, esophagusSt, LR.inside, LR.middle, LR.middle, LR.middle);
    ConnectionLocation esophagus = new ConnectionLocation(
	     esophagusSt, LR.d1, lrEsophagus, LR.larynxSt, LR.stomachSt);
    // PartLocation esophagus = (PartLocation) Common.getLocation(esophagusSt);
    LocationRelation lrEsophagus1 = 
      new LocationRelation(neckSt, esophagusSt, LR.inside, 
			   LR.middle, LR.topToBottom, LR.front);
    esophagus.addAlsoPartOf(lrEsophagus1);
esophagus.setPrintName(L.esophagusPrintName);

    LocationRelation lrEsophagus2 = 
      new LocationRelation(ribCageSt, esophagusSt, LR.inside, 
			   LR.middle, LR.topToMiddle, LR.middle);
    esophagus.addAlsoPartOf(lrEsophagus2);

    LocationRelation lrEsophagusLeftLung = 
      new LocationRelation(esophagusSt, leftLungSt, LR.adjacent, 
			   LR.left, LR.bottom, LR.middle); // ????
    esophagus.addAdjacent(lrEsophagusLeftLung);
    LocationRelation lrEsophagusRightLung = 
      new LocationRelation(esophagusSt, rightLungSt, LR.adjacent, 
			   LR.right, LR.bottom, LR.middle); // ????
    esophagus.addAdjacent(lrEsophagusRightLung);
    esophagus.addMembership(LR.mucousMembranesSt); 


  } // end of main(...)

} // end of InitMultiParts 
