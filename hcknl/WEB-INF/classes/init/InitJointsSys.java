// (C) OntoOO Inc 2003 May
package init;

import com.LR;
import com.L;
import concepts.*;

public class InitJointsSys  {

  public static void doit() {

// (C) OntoOO Inc Sun Feb 23 16:46:44 PST 2003
// ------------- jointsSys  -------------
BodySystem jointsSys = new BodySystem(
    LR.jointsSysSt,
    LR.jointsSt,
    LR.limbsSysSt,
    L.jointsSysDescription
);
jointsSys.setPrintName(L.jointsSysPrintName);

// (C) OntoOO Inc Sun Feb 23 16:46:44 PST 2003
// ------------- anklesSys  -------------
BodySystem anklesSys = new BodySystem(
    LR.anklesSysSt,
    LR.anklesSt,
    LR.jointsSysSt,
    L.anklesSysDescription
);
anklesSys.setPrintName(L.anklesSysPrintName);

// (C) OntoOO Inc Sun Feb 23 16:46:44 PST 2003
// ------------- elbowsSys  -------------
BodySystem elbowsSys = new BodySystem(
    LR.elbowsSysSt,
    LR.elbowsSt,
    LR.jointsSysSt,
    L.elbowsSysDescription
);
elbowsSys.setPrintName(L.elbowsSysPrintName);

// (C) OntoOO Inc Sun Feb 23 16:46:44 PST 2003
// ------------- wristsSys  -------------
BodySystem wristsSys = new BodySystem(
    LR.wristsSysSt,
    LR.wristsSt,
    LR.jointsSysSt,
    L.wristsSysDescription
);
wristsSys.setPrintName(L.wristsSysPrintName);


  }
}
