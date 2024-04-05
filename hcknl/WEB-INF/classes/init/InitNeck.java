// (C) OntoOO Inc 2000
package init;

import com.Common;
import com.LR;
import com.L;
import concepts.*;

public class InitNeck {

  public static void doit() {

    // neck
    String neckSt = LR.neckSt;

    // neckVeins
    String neckVeinsSt = LR.neckVeinsSt;
    LocationRelation lrNeckVeins = 
      new LocationRelation(neckSt, neckVeinsSt, LR.inside, LR.na, LR.na, LR.na);
    VeinSet neckVeins = new VeinSet(neckVeinsSt, LR.d3, lrNeckVeins);
neckVeins.setPrintName(L.neckVeinsPrintName);

// (C) OntoOO Inc Tue Jul 03 21:38:06 PDT 2001
LocationRelation lrThyroid =
   new LocationRelation(LR.neckSt, LR.thyroidSt, LR.inside, 
			LR.middle, LR.bottom, LR.front);
PartLocation thyroid = new PartLocation(LR.thyroidSt, LR.d3, lrThyroid);
LocationRelation lrThyroidTrachea =
   new LocationRelation(LR.thyroidSt, LR.tracheaSt, LR.adjacent, 
			LR.middle, LR.top, LR.front);
thyroid.addAdjacent(lrThyroidTrachea);
thyroid.setPrintName(L.thyroidPrintName);

// (C) OntoOO Inc Tue Jul 03 21:54:13 PDT 2001
LocationRelation lrParathyroids =
   new LocationRelation(LR.neckSt, LR.parathyroidsSt, LR.inside, 
			LR.na, LR.bottom, LR.middle);
LocationSet parathyroids = new LocationSet(LR.parathyroidsSt, LR.d3, lrParathyroids);
LocationRelation lrParathyroidsThyroid =
   new LocationRelation(LR.parathyroidsSt, LR.thyroidSt, LR.adjacent, 
			LR.na, LR.na, LR.back);
parathyroids.addAdjacent(lrParathyroidsThyroid);
parathyroids.setPrintName(L.parathyroidsPrintName);

    // VocalCords
// (C) OntoOO Inc Wed Oct 31 17:13:20 PST 2001
LocationRelation lrVocalCords =
   new LocationRelation(LR.larynxSt, LR.vocalCordsSt, LR.inside, 
			LR.middle, LR.middle, LR.front);
LocationSet vocalCords = new LocationSet(LR.vocalCordsSt, LR.d3, lrVocalCords);
LocationRelation lrVocalCordsTrachea =
   new LocationRelation(LR.vocalCordsSt, LR.tracheaSt, LR.adjacent, 
			LR.middle, LR.top, LR.middle);
vocalCords.addAdjacent(lrVocalCordsTrachea);
vocalCords.setPrintName(L.vocalCordsPrintName);

// -------------- nape --------------
// (C) OntoOO Inc Tue Nov 20 23:32:16 PST 2001
LocationRelation lrNape =
   new LocationRelation(LR.neckSt, LR.napeSt, LR.inside, 
			LR.middle, LR.topToBottom, LR.back);
PartLocation nape = new PartLocation(LR.napeSt, LR.d3, lrNape);
nape.setPrintName(L.napePrintName);

// -------------- neckLymphNode --------------
// (C) OntoOO Inc Mon May 10 15:16:06 PDT 2004
LocationRelation lrNeckLymphNode =
   new LocationRelation(LR.neckSt, LR.neckLymphNodeSt, LR.inside, LR.na, LR.na, LR.na);
PartLocation neckLymphNode = new PartLocation(LR.neckLymphNodeSt, LR.d3, lrNeckLymphNode);
neckLymphNode.addMembership(LR.lymphNodesSt);
neckLymphNode.setPrintName(L.neckLymphNodePrintName);


  } // end of doit()

} // end of InitNeck
