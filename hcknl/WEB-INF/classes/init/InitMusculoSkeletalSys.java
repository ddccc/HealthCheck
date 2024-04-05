// (C) OntoOO Inc 2000
package init;

import com.LR;
import com.L;
import concepts.*;

public class InitMusculoSkeletalSys {

  public static void doit() {

// (C) OntoOO Inc Sat Jun 30 21:50:19 PDT 2001
// ------------- musculoSkeletalSys  -------------
BodySystem musculoSkeletalSys = new BodySystem(
    LR.musculoSkeletalSysSt,
    LR.bodySt,
    LR.bodySysSt,
    L.musculoSkeletalSysDescription
);
musculoSkeletalSys.setPrintName(L.musculoSkeletalSysPrintName);

// (C) OntoOO Inc Sat Jun 30 21:51:53 PDT 2001
// ------------- muscleSys  -------------
BodySystem muscleSys = new BodySystem(
    LR.muscleSysSt,
    LR.bodySt,
    LR.musculoSkeletalSysSt,
    L.muscleSysDescription
);
muscleSys.setPrintName(L.muscleSysPrintName);

// (C) OntoOO Inc Sat Apr 20 18:05:52 PDT 2002
// ------------- breastsSys  -------------
BodySystem breastsSys = new BodySystem(
    LR.breastsSysSt,
    LR.breastsSt,
    LR.muscleSysSt,
    L.breastsSysDescription
);
breastsSys.setPrintName(L.breastsSysPrintName);

// (C) OntoOO Inc Sat Jun 30 21:53:49 PDT 2001
// ------------- skeletalSys  -------------
BodySystem skeletalSys = new BodySystem(
    LR.skeletalSysSt,
    LR.bodySt,
    LR.musculoSkeletalSysSt,
    L.skeletalSysDescription
);
skeletalSys.setPrintName(L.skeletalSysPrintName);


  }
}
