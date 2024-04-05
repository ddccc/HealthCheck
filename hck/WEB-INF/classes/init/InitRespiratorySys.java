// (C) OntoOO Inc 2000
package init;

import com.LR;
import com.L;
import concepts.*;

public class InitRespiratorySys {
  public static void doit() {

 
// ------------- respiratorySys  -------------
BodySystem respiratorySys = new BodySystem(
    LR.respiratorySysSt,
    LR.bodySt,
    LR.bodySysSt,
    L.respiratorySysDescription
);
respiratorySys.setPrintName(L.respiratorySysPrintName);

// ------------- lungsSys  -------------
BodySystem lungsSys = new BodySystem(
    LR.lungsSysSt,
    LR.lungsSt,
    LR.respiratorySysSt,
    L.lungsSysDescription
);
lungsSys.setPrintName(L.lungsSysPrintName);

// ------------- leftLungSys  -------------
BodySystem leftLungSys = new BodySystem(
    LR.leftLungSysSt,
    LR.leftLungSt,
    LR.lungsSysSt,
    L.leftLungSysDescription
);
leftLungSys.setPrintName(L.leftLungSysPrintName);

// ------------- rightLungSys  -------------
BodySystem rightLungSys = new BodySystem(
    LR.rightLungSysSt,
    LR.rightLungSt,
    LR.lungsSysSt,
    L.rightLungSysDescription
);
rightLungSys.setPrintName(L.rightLungSysPrintName);

// ------------- tracheaSys  -------------
BodySystem tracheaSys = new BodySystem(
    LR.tracheaSysSt,
    LR.tracheaSt,
    LR.respiratorySysSt,
    L.tracheaSysDescription
);
tracheaSys.setPrintName(L.tracheaSysPrintName);

// ------------- noseSys  -------------
BodySystem noseSys = new BodySystem(
    LR.noseSysSt,
    LR.noseSt,
    LR.respiratorySysSt,
    L.noseSysDescription
);
noseSys.setPrintName(L.noseSysPrintName);

// ------------- larynxSys  -------------
BodySystem larynxSys = new BodySystem(
    LR.larynxSysSt,
    LR.larynxSt,
    LR.respiratorySysSt,
    L.larynxSysDescription
);
larynxSys.setPrintName(L.larynxSysPrintName);

    
  } // end of doit()

} // end of InitRespiratorySys
