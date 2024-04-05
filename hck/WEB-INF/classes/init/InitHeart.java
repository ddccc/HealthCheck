// (C) OntoOO Inc 2000
package init;

import com.Common;
import com.LR;
import com.L;
import concepts.*;

public class InitHeart {

  public static void doit() {

    // heart
    String heartSt = LR.heartSt;

    // myocardium
    String myocardiumSt = LR.myocardiumSt;
    LocationRelation lrMyocardium = 
      new LocationRelation(heartSt, myocardiumSt, LR.inside, LR.middle, LR.na, LR.middle);
    PartLocation myocardium = new PartLocation(myocardiumSt, LR.d3, lrMyocardium);
myocardium.setPrintName(L.myocardiumPrintName);


  } // end of doit()

} // end of InitHeart
