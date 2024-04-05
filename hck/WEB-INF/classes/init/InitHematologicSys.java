// (C) OntoOO Inc 2000
package init;

import com.LR;
import com.L;
import concepts.*;

public class InitHematologicSys {
// hematologic - blood

  public static void doit() {

// (C) OntoOO Inc Fri Jul 06 15:48:46 PDT 2001
// ------------- hematologicSys  -------------
BodySystem hematologicSys = new BodySystem(
    LR.hematologicSysSt,
    LR.bodySt,
    LR.bodySysSt,
    L.hematologicSysDescription
);
hematologicSys.setPrintName(L.hematologicSysPrintName);

// (C) OntoOO Inc Tue Oct 16 10:52:46 PDT 2001
// ------------- spleenSys  -------------
BodySystem spleenSys = new BodySystem(
    LR.spleenSysSt,
    LR.spleenSt,
    LR.hematologicSysSt,
    L.spleenSysDescription
);
spleenSys.setPrintName(L.spleenSysPrintName);

  } // end doit()
} // end InitHematologicSys
