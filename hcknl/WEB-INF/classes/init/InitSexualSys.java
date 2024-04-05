// (C) OntoOO Inc 2000
package init;

import com.LR;
import com.L;
import concepts.*;

public class InitSexualSys {

  public static void doit() {

// (C) OntoOO Inc Thu Jul 05 15:03:20 PDT 2001
// ------------- sexualSys  -------------
BodySystem sexualSys = new BodySystem(
    LR.sexualSysSt,
    LR.bodySt,
    LR.bodySysSt,
    L.sexualSysDescription
);
sexualSys.setPrintName(L.sexualSysPrintName);

// (C) OntoOO Inc Thu Jul 05 16:15:01 PDT 2001
// ------------- clitorisSys  -------------
BodySystem clitorisSys = new BodySystem(
    LR.clitorisSysSt,
    LR.clitorisSt,
    LR.sexualSysSt,
    L.clitorisSysDescription
);
clitorisSys.setPrintName(L.clitorisSysPrintName);
clitorisSys.setGender(LR.female);

// (C) OntoOO Inc Tue Mar 12 11:37:33 PST 2002
// ------------- epididymisSys  -------------
BodySystem epididymisSys = new BodySystem(
    LR.epididymisSysSt,
    LR.epididymisSetSt,
    LR.sexualSysSt,
    L.epididymisSysDescription
);
epididymisSys.setPrintName(L.epididymisSysPrintName);
epididymisSys.setGender(LR.male);

// (C) OntoOO Inc Thu Jul 05 16:16:17 PDT 2001
// ------------- penisxSys  -------------
BodySystem penisxSys = new BodySystem(
    LR.penisxSysSt,
    LR.penisSt,
    LR.sexualSysSt,
    L.penisxSysDescription
);
penisxSys.setPrintName(L.penisxSysPrintName);
penisxSys.setGender(LR.male);

// (C) OntoOO Inc Tue Mar 12 14:35:03 PST 2002
// ------------- prostateSys  -------------
BodySystem prostateSys = new BodySystem(
    LR.prostateSysSt,
    LR.prostateSt,
    LR.sexualSysSt,
    L.prostateSysDescription
);
prostateSys.setPrintName(L.prostateSysPrintName);
prostateSys.setGender(LR.male);

// (C) OntoOO Inc Wed Jul 04 10:35:59 PDT 2001
// ------------- testesSys  -------------
BodySystem testesSys = new BodySystem(
    LR.testesSysSt,
    LR.testiclesSt,
    LR.sexualSysSt,
    L.testesSysDescription
);
testesSys.setPrintName(L.testesSysPrintName);
testesSys.setGender(LR.male);

// (C) OntoOO Inc Fri Jul 06 09:22:04 PDT 2001
// ------------- vaginasxSys  -------------
BodySystem vaginasxSys = new BodySystem(
    LR.vaginasxSysSt,
    LR.vaginaSt,
    LR.sexualSysSt,
    L.vaginasxSysDescription
);
vaginasxSys.setPrintName(L.vaginasxSysPrintName);
vaginasxSys.setGender(LR.female);

// ------------- vulvaSys  -------------
BodySystem vulvaSys = new BodySystem(
    LR.vulvaSysSt,
    LR.vulvaSt,
    LR.sexualSysSt,
    L.vulvaSysDescription
);
vulvaSys.setPrintName(L.vulvaSysPrintName);
vulvaSys.setGender(LR.female);


  }
}
