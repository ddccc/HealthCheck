// (C) OntoOO Inc 2000
package init;

import com.LR;
import com.L;
import concepts.*;

public class InitRenalSys {

  public static void doit() {

// (C) OntoOO Inc Tue Jul 03 09:55:44 PDT 2001
// ------------- renalSys  -------------
BodySystem renalSys = new BodySystem(
    LR.renalSysSt,
    LR.kidneysSt,
    LR.bodySysSt,
    L.renalSysDescription
);
renalSys.setPrintName(L.renalSysPrintName);

// (C) OntoOO Inc Tue Jul 03 09:59:41 PDT 2001
// ------------- leftKidneySys  -------------
BodySystem leftKidneySys = new BodySystem(
    LR.leftKidneySysSt,
    LR.leftKidneySt,
    LR.renalSysSt,
    L.leftKidneySysDescription
);
leftKidneySys.setPrintName(L.leftKidneySysPrintName);

// (C) OntoOO Inc Tue Jul 03 10:01:13 PDT 2001
// ------------- rightKidneySys  -------------
BodySystem rightKidneySys = new BodySystem(
    LR.rightKidneySysSt,
    LR.rightKidneySt,
    LR.renalSysSt,
    L.rightKidneySysDescription
);
rightKidneySys.setPrintName(L.rightKidneySysPrintName);



  }
}
