// (C) OntoOO Inc 2000
package init;

import com.LR;
import com.L;
import concepts.*;
public class InitUrologicSys {

  public static void doit() {

// (C) OntoOO Inc Fri Jul 06 15:07:50 PDT 2001
// ------------- urologicSys  -------------
BodySystem urologicSys = new BodySystem(
    LR.urologicSysSt,
    LR.abdomenSt,
    LR.bodySysSt,
    L.urologicSysDescription
);
urologicSys.setPrintName(L.urologicSysPrintName);

// (C) OntoOO Inc Fri Jul 06 15:08:32 PDT 2001
// ------------- bladderSys  -------------
BodySystem bladderSys = new BodySystem(
    LR.bladderSysSt,
    LR.bladderSt,
    LR.urologicSysSt,
    L.bladderSysDescription
);
bladderSys.setPrintName(L.bladderSysPrintName);

// (C) OntoOO Inc Fri Jul 06 15:10:08 PDT 2001
// ------------- urethraFMSys  -------------
BodySystem urethraFMSys = new BodySystem(
    LR.urethraFMSysSt,
    LR.urethraFMSt,
    LR.urologicSysSt,
    L.urethraFMSysDescription
);
urethraFMSys.setPrintName(L.urethraFMSysPrintName);
urethraFMSys.setGender(LR.female);

// (C) OntoOO Inc Fri Jul 06 15:11:29 PDT 2001
// ------------- urethraMLSys  -------------
BodySystem urethraMLSys = new BodySystem(
    LR.urethraMLSysSt,
    LR.urethraMLSt,
    LR.urologicSysSt,
    L.urethraMLSysDescription
);
urethraMLSys.setPrintName(L.urethraMLSysPrintName);
urethraMLSys.setGender(LR.male);



  }
}
