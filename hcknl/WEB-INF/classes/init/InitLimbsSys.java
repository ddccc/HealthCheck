// (C) OntoOO Inc 2003 May
package init;

import com.LR;
import com.L;
import concepts.*;

public class InitLimbsSys  {

  public static void doit() {

// (C) OntoOO Inc Wed May 07 15:20:17 PDT 2003
// ------------- limbsSys  -------------
BodySystem limbsSys = new BodySystem(
    LR.limbsSysSt,
    LR.limbsSt,
    LR.bodySysSt,
    L.limbsSysDescription
);
limbsSys.setPrintName(L.limbsSysPrintName);

// (C) OntoOO Inc Wed May 07 15:32:41 PDT 2003
// ------------- armsSys  -------------
BodySystem armsSys = new BodySystem(
    LR.armsSysSt,
    LR.armsSt,
    LR.limbsSysSt,
    L.armsSysDescription
);
armsSys.setPrintName(L.armsSysPrintName);

// (C) OntoOO Inc Wed May 07 15:35:02 PDT 2003
// ------------- legsSys  -------------
BodySystem legsSys = new BodySystem(
    LR.legsSysSt,
    LR.legsSt,
    LR.limbsSysSt,
    L.legsSysDescription
);
legsSys.setPrintName(L.legsSysPrintName);

// (C) OntoOO Inc Wed May 07 20:22:59 PDT 2003
// ------------- feetSys  -------------
BodySystem feetSys = new BodySystem(
    LR.feetSysSt,
    LR.feetSt,
    LR.legsSysSt,
    L.feetSysDescription
);
feetSys.setPrintName(L.feetSysPrintName);

// (C) OntoOO Inc Wed May 07 20:27:39 PDT 2003
// ------------- largeToesSys  -------------
BodySystem largeToesSys = new BodySystem(
    LR.largeToesSysSt,
    LR.largeToesSt,
    LR.feetSysSt,
    L.largeToesSysDescription
);
largeToesSys.setPrintName(L.largeToesSysPrintName);


  }
}
