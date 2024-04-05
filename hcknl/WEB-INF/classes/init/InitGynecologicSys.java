// (C) OntoOO Inc 2000
package init;

import com.LR;
import com.L;
import concepts.*;

public class InitGynecologicSys {

  public static void doit() {


// (C) OntoOO Inc Wed Jul 04 22:54:36 PDT 2001
// ------------- gynecologicSys  -------------
BodySystem gynecologicSys = new BodySystem(
    LR.gynecologicSysSt,
    LR.abdomenSt,
    LR.bodySysSt,
    L.gynecologicSysDescription
);
gynecologicSys.setPrintName(L.gynecologicSysPrintName);
gynecologicSys.setGender(LR.female);

// (C) OntoOO Inc Tue Feb 26 17:51:07 PST 2002
// ------------- cervixSys  -------------
BodySystem cervixSys = new BodySystem(
    LR.cervixSysSt,
    LR.cervixSt,
    LR.gynecologicSysSt,
    L.cervixSysDescription
);
cervixSys.setPrintName(L.cervixSysPrintName);
cervixSys.setGender(LR.female);

// (C) OntoOO Inc Tue Feb 05 12:46:33 PST 2002
// ------------- fallopianTubesSys  -------------
BodySystem fallopianTubesSys = new BodySystem(
    LR.fallopianTubesSysSt,
    LR.fallopianTubesSt,
    LR.gynecologicSysSt,
    L.fallopianTubesSysDescription
);
fallopianTubesSys.setPrintName(L.fallopianTubesSysPrintName);
fallopianTubesSys.setGender(LR.female);

// (C) OntoOO Inc Wed Feb 27 13:44:51 PST 2002
// ------------- perineumVulvaVaginaSys  -------------
BodySystem perineumVulvaVaginaSys = new BodySystem(
    LR.perineumVulvaVaginaSysSt,
    LR.perineumVulvaVaginaSt,
    LR.gynecologicSysSt,
    L.perineumVulvaVaginaSysDescription
);
perineumVulvaVaginaSys.setPrintName(L.perineumVulvaVaginaSysPrintName);
perineumVulvaVaginaSys.setGender(LR.female);

// (C) OntoOO Inc Wed Jul 04 23:03:00 PDT 2001
// ------------- uterusSys  -------------
BodySystem uterusSys = new BodySystem(
    LR.uterusSysSt,
    LR.uterusSt,
    LR.gynecologicSysSt,
    L.uterusSysDescription
);
uterusSys.setPrintName(L.uterusSysPrintName);
uterusSys.setGender(LR.female);

// (C) OntoOO Inc Wed Feb 27 21:35:36 PST 2002
// ------------- endometriumSys  -------------
BodySystem endometriumSys = new BodySystem(
    LR.endometriumSysSt,
    LR.endometriumSt,
    LR.uterusSysSt,
    L.endometriumSysDescription
);
endometriumSys.setPrintName(L.endometriumSysPrintName);
endometriumSys.setGender(LR.female);

// (C) OntoOO Inc Sun Feb 17 16:30:14 PST 2002
// ------------- placentaSys  -------------
BodySystem placentaSys = new BodySystem(
    LR.placentaSysSt,
    LR.placentaSt,
    LR.uterusSysSt,
    L.placentaSysDescription
);
placentaSys.setPrintName(L.placentaSysPrintName);
placentaSys.setGender(LR.female);

// (C) OntoOO Inc Wed Jul 04 23:00:06 PDT 2001
// ------------- vaginagySys  -------------
BodySystem vaginagySys = new BodySystem(
    LR.vaginagySysSt,
    LR.vaginaSt,
    LR.gynecologicSysSt,
    L.vaginagySysDescription
);
vaginagySys.setPrintName(L.vaginagySysPrintName);
vaginagySys.setGender(LR.female);


  }
}
