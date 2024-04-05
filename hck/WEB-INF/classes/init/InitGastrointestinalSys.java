// (C) OntoOO Inc 2000
package init;

import com.LR;
import com.L;
import concepts.*;


public class InitGastrointestinalSys {

  public static void doit() {


// (C) OntoOO Inc Mon Jul 02 15:30:37 PDT 2001
// ------------- gastrointestinalSys  -------------
BodySystem gastrointestinalSys = new BodySystem(
    LR.gastrointestinalSysSt,
    LR.bodySt,
    LR.bodySysSt,
    L.gastrointestinalSysDescription
);
gastrointestinalSys.setPrintName(L.gastrointestinalSysPrintName);

// (C) OntoOO Inc Mon Jul 02 15:41:55 PDT 2001
// ------------- esophagusSys  -------------
BodySystem esophagusSys = new BodySystem(
    LR.esophagusSysSt,
    LR.esophagusSt,
    LR.gastrointestinalSysSt,
    L.esophagusSysDescription
);
esophagusSys.setPrintName(L.esophagusSysPrintName);

// (C) OntoOO Inc Tue Nov 20 14:00:54 PST 2001
// ------------- intestinesSys  -------------
BodySystem intestinesSys = new BodySystem(
    LR.intestinesSysSt,
    LR.abdomenSt,
    LR.gastrointestinalSysSt,
    L.intestinesSysDescription
);
intestinesSys.setPrintName(L.intestinesSysPrintName);

// (C) OntoOO Inc Tue Nov 20 14:02:02 PST 2001
// ------------- largeIntestineSys  -------------
BodySystem largeIntestineSys = new BodySystem(
    LR.largeIntestineSysSt,
    LR.largeIntestineSt,
    LR.intestinesSysSt,
    L.largeIntestineSysDescription
);
largeIntestineSys.setPrintName(L.largeIntestineSysPrintName);

BodySystem appendixSys = new BodySystem(
    LR.appendixSysSt,
    LR.appendixSt,
    LR.largeIntestineSysSt,
    //"no agreement of its purpose"
    L.appendixSysDescription
);
appendixSys.setPrintName(L.appendixSysPrintName);

// (C) OntoOO Inc Mon Feb 10 15:42:19 PST 2003
// ------------- colonSys  -------------
BodySystem colonSys = new BodySystem(
    LR.colonSysSt,
    LR.colonSt,
    LR.largeIntestineSysSt,
    L.colonSysDescription
);
colonSys.setPrintName(L.colonSysPrintName);

// (C) OntoOO Inc Mon Jul 02 15:35:32 PDT 2001
// ------------- mouthSys  -------------
BodySystem mouthSys = new BodySystem(
    LR.mouthSysSt,
    LR.mouthSt,
    LR.gastrointestinalSysSt,
    L.mouthSysDescription
);
mouthSys.setPrintName(L.mouthSysPrintName);

// (C) OntoOO Inc Mon Jul 02 15:39:56 PDT 2001
// ------------- pharynxSys  -------------
BodySystem pharynxSys = new BodySystem(
    LR.pharynxSysSt,
    LR.throatSt,
    LR.gastrointestinalSysSt,
    L.pharynxSysDescription
);
pharynxSys.setPrintName(L.pharynxSysPrintName);

// (C) OntoOO Inc Sun Mar 10 14:20:06 PST 2002
// ------------- rectumSys  -------------
BodySystem rectumSys = new BodySystem(
    LR.rectumSysSt,
    LR.rectumSt,
    LR.intestinesSysSt,
    L.rectumSysDescription
);
rectumSys.setPrintName(L.rectumSysPrintName);

// (C) OntoOO Inc Tue Nov 20 14:02:52 PST 2001
// ------------- smallIntestineSys  -------------
BodySystem smallIntestineSys = new BodySystem(
    LR.smallIntestineSysSt,
    LR.smallIntestineSt,
    LR.intestinesSysSt,
    L.smallIntestineSysDescription
);
smallIntestineSys.setPrintName(L.smallIntestineSysPrintName);

// (C) OntoOO Inc Mon Jul 02 16:55:18 PDT 2001
// ------------- stomachSys  -------------
BodySystem stomachSys = new BodySystem(
    LR.stomachSysSt,
    LR.stomachSt,
    LR.gastrointestinalSysSt,
    L.stomachSysDescription
);
stomachSys.setPrintName(L.stomachSysPrintName);

// (C) OntoOO Inc Fri Apr 12 15:20:45 PDT 2002
// ------------- tongueSys  -------------
BodySystem tongueSys = new BodySystem(
    LR.tongueSysSt,
    LR.tongueSt,
    LR.gastrointestinalSysSt,
    L.tongueSysDescription
);
tongueSys.setPrintName(L.tongueSysPrintName);


  }
}
