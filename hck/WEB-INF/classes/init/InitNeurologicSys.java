// (C) OntoOO Inc 2000
package init;

import com.LR;
import com.L;
import com.D;
import concepts.*;

public class InitNeurologicSys {

  public static void doit() {

// (C) OntoOO Inc Sat Jun 30 21:56:16 PDT 2001
// ------------- neurologicSys  -------------
BodySystem neurologicSys = new BodySystem(
    LR.neurologicSysSt,
    LR.bodySt,
    LR.bodySysSt,
    L.neurologicSysDescription
);
neurologicSys.setPrintName(L.neurologicSysPrintName);

// (C) OntoOO Inc Sat Jun 30 21:59:10 PDT 2001
// ------------- centralNervousSys  -------------
BodySystem centralNervousSys = new BodySystem(
    LR.centralNervousSysSt,
    LR.bodySt,
    LR.neurologicSysSt,
    L.centralNervousSysDescription
);
centralNervousSys.setPrintName(L.centralNervousSysPrintName);

// (C) OntoOO Inc Sat Jun 30 22:01:44 PDT 2001
// ------------- brainSys  -------------
BodySystem brainSys = new BodySystem(
    LR.brainSysSt,
    LR.brainSt,
    LR.centralNervousSysSt,
    L.brainSysDescription
);
brainSys.setPrintName(L.brainSysPrintName);

// ------------- mindSys  -------------
BodySystem mindSys = new BodySystem(
    LR.mindSysSt,
    LR.brainSt,
    LR.brainSysSt,
    L.mindSysDescription
);
mindSys.setPrintName(L.mindSysPrintName);

// (C) OntoOO Inc Sat Jun 30 22:04:41 PDT 2001
// ------------- spineSys  -------------
BodySystem spineSys = new BodySystem(
    LR.spineSysSt,
    LR.spineSt,
    LR.centralNervousSysSt,
    L.spineSysDescription
);
spineSys.setPrintName(L.spineSysPrintName);

// (C) OntoOO Inc Sat Jun 30 22:08:13 PDT 2001
// ------------- peripheralNervousSys  -------------
BodySystem peripheralNervousSys = new BodySystem(
    LR.peripheralNervousSysSt,
    LR.bodySt,
    LR.neurologicSysSt,
    L.peripheralNervousSysDescription
);
peripheralNervousSys.setPrintName(L.peripheralNervousSysPrintName);

// (C) OntoOO Inc Sat Jun 30 22:10:19 PDT 2001
// ------------- autonomicNervousSys  -------------
BodySystem autonomicNervousSys = new BodySystem(
    LR.autonomicNervousSysSt,
    LR.bodySt,
    LR.neurologicSysSt,
    L.autonomicNervousSysDescription
);
autonomicNervousSys.setPrintName(L.autonomicNervousSysPrintName);

// (C) OntoOO Inc Thu May 15 15:49:02 PDT 2003
// ------------- cranialNerve5thSys  -------------
BodySystem cranialNerve5thSys = new BodySystem(
    LR.cranialNerve5thSysSt,
    LR.cranialNerve5thSt,
    LR.peripheralNervousSysSt,
    L.cranialNerve5thSysDescription
);
cranialNerve5thSys.setPrintName(L.cranialNerve5thSysPrintName);
cranialNerve5thSys.addIllustration(D.TrigeminalNeuralgiaGif);

// (C) OntoOO Inc Thu May 15 15:49:02 PDT 2003
// ------------- cranialNerve7thSys  -------------
BodySystem cranialNerve7thSys = new BodySystem(
    LR.cranialNerve7thSysSt,
    LR.cranialNerve7thSt,
    LR.peripheralNervousSysSt,
    L.cranialNerve7thSysDescription
);
cranialNerve7thSys.setPrintName(L.cranialNerve7thSysPrintName);


  }
}
