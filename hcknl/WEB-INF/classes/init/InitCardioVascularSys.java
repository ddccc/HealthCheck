// (C) OntoOO Inc 2001
package init;

import com.LR;
import com.L;
import com.D;
import concepts.*;

public class InitCardioVascularSys {
  public static void doit() {


// ------------- cardioVascularSys  -------------
BodySystem cardioVascularSys = new BodySystem(
    LR.cardioVascularSysSt,
    LR.bodySt,
    LR.bodySysSt,
    L.cardioVascularSysDescription
);
cardioVascularSys.setPrintName(L.cardioVascularSysPrintName);

// ------------- heartSys  -------------
BodySystem heartSys = new BodySystem(
    LR.heartSysSt,
    LR.heartSt,
    LR.cardioVascularSysSt,
    L.heartSysDescription
);
heartSys.setPrintName(L.heartSysPrintName);
heartSys.addIllustration(D.Heart1Gif);
heartSys.addIllustration(D.Heart2Png);

// ------------- vascularSys  -------------
BodySystem vascularSys = new BodySystem(
    LR.vascularSysSt,
    LR.aVeinSt,
    LR.cardioVascularSysSt,
    L.vascularSysDescription
);
vascularSys.setPrintName(L.vascularSysPrintName);

// ------------- pulmonaryArterySys  -------------
BodySystem pulmonaryArterySys = new BodySystem(
    LR.pulmonaryArterySysSt,
    LR.pulmonaryArteriesSt,
    LR.vascularSysSt,
    L.pulmonaryArterySysDescription
);
pulmonaryArterySys.setPrintName(L.pulmonaryArterySysPrintName);

    // add veins
    // add lymphatics
    
  } // end of doit()

} // end of InitCardioVascularSys
