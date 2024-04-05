// (C) OntoOO Inc 2000
package init;

import com.LR;
import com.L;
import concepts.*;

public class InitHepatobiliarySys {

  public static void doit() {


// (C) OntoOO Inc Mon Jul 02 22:14:09 PDT 2001
// ------------- hepatobiliarySys  -------------
BodySystem hepatobiliarySys = new BodySystem(
    LR.hepatobiliarySysSt,
    LR.abdomenSt,
    LR.bodySysSt,
    L.hepatobiliarySysDescription
);
hepatobiliarySys.setPrintName(L.hepatobiliarySysPrintName);

// (C) OntoOO Inc Mon Jul 02 22:16:12 PDT 2001
// ------------- liverSys  -------------
BodySystem liverSys = new BodySystem(
    LR.liverSysSt,
    LR.liverSt,
    LR.hepatobiliarySysSt,
    L.liverSysDescription
);
liverSys.setPrintName(L.liverSysPrintName);

// (C) OntoOO Inc Mon Jul 02 22:18:33 PDT 2001
// ------------- gallbladderSys  -------------
BodySystem gallbladderSys = new BodySystem(
    LR.gallbladderSysSt,
    LR.gallbladderSt,
    LR.hepatobiliarySysSt,
    L.gallbladderSysDescription
);
gallbladderSys.setPrintName(L.gallbladderSysPrintName);


  }
}
