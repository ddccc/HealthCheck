// (C) OntoOO Inc 2000
package init;

import com.Common;
import com.LR;
import com.L;
import concepts.*;

public class InitBodySystems {

  public static void doit() {

    Common.createTheBodySystems();
    Common.setTheBodySystemsLoaded(true);
    // System.out.println();


// (C) OntoOO Inc Thu Aug 02 16:57:19 PDT 2001
// ------------- bodySys  -------------
BodySystem bodySys = new BodySystem(
    LR.bodySysSt,
    LR.bodySt,
    null,
    L.bodySysDescription
);
bodySys.setPrintName(L.bodySysPrintName);

    System.out.println("****** InitRespiratorySys ...");
    InitRespiratorySys.doit();

    System.out.println("****** InitCardioVascularSys ...");
    InitCardioVascularSys.doit();

// (C) OntoOO Inc Wed Oct 03 09:31:03 PDT 2001
// ------------- glandsSys  -------------
BodySystem glandsSys = new BodySystem(
    LR.glandsSysSt,
    LR.glandsSt,
    LR.bodySysSt,
    L.glandsSysDescription
);
glandsSys.setPrintName(L.glandsSysPrintName);

// (C) OntoOO Inc Wed Oct 03 09:36:53 PDT 2001
// ------------- exocrineGlandsSys  -------------
BodySystem exocrineGlandsSys = new BodySystem(
    LR.exocrineGlandsSysSt,
    LR.glandsSt,
    LR.glandsSysSt,
    L.exocrineGlandsSysDescription
);
exocrineGlandsSys.setPrintName(L.exocrineGlandsSysPrintName);

// ------------- mammaryGlandsSys  -------------
BodySystem mammaryGlandsSys = new BodySystem(
    LR.mammaryGlandsSysSt,
    LR.mammaryGlandsSt,
    LR.exocrineGlandsSysSt,
    L.mammaryGlandsSysDescription
);
mammaryGlandsSys.setPrintName(L.mammaryGlandsSysPrintName);
mammaryGlandsSys.setGender(LR.female); 


    System.out.println("****** InitEndocrineSys ...");
    InitEndocrineSys.doit();

    System.out.println("****** InitGastrointestinalSys ...");
    InitGastrointestinalSys.doit();

    System.out.println("****** InitGynecologicSys ...");
    InitGynecologicSys.doit();

    System.out.println("****** InitHematologicSys ...");
    InitHematologicSys.doit();

    System.out.println("****** InitHepatobiliarySys ...");
    InitHepatobiliarySys.doit();

    System.out.println("****** InitLimbsSys ...");
    InitLimbsSys.doit();

    System.out.println("****** InitJointsSys ..."); // must follow limbs
    InitJointsSys.doit();

    System.out.println("****** InitMusculoSkeletalSys ...");
    InitMusculoSkeletalSys.doit();

    System.out.println("****** InitNeurologicSys ...");
    InitNeurologicSys.doit();


    System.out.println("****** InitRenalSys ...");
    InitRenalSys.doit();

    System.out.println("****** InitSexualSys ...");
    InitSexualSys.doit();

    System.out.println("****** InitUrologicSys ...");
    InitUrologicSys.doit();

    // ++++++ Other systems here ...

// ------------- earsSys  -------------
BodySystem earsSys = new BodySystem(
    LR.earsSysSt,
    LR.earsSt,
    LR.bodySysSt,
    L.earsSysDescription
);
earsSys.setPrintName(L.earsSysPrintName);

// ------------- eyesSys  -------------
BodySystem eyesSys = new BodySystem(
    LR.eyesSysSt,
    LR.eyesSt,
    LR.bodySysSt,
    L.eyesSysDescription
);
eyesSys.setPrintName(L.eyesSysPrintName);

// (C) OntoOO Inc Fri Mar 01 12:27:52 PST 2002
// ------------- groinSys  -------------
BodySystem groinSys = new BodySystem(
    LR.groinSysSt,
    LR.groinSt,
    LR.bodySysSt,
    L.groinSysDescription
);
groinSys.setPrintName(L.groinSysPrintName);

// (C) OntoOO Inc Sat Jun 30 21:44:22 PDT 2001
// ------------- immuneSys  -------------
BodySystem immuneSys = new BodySystem(
    LR.immuneSysSt,
    LR.bodySt,
    LR.bodySysSt,
    L.immuneSysDescription
);
immuneSys.setPrintName(L.immuneSysPrintName);

// (C) OntoOO Inc Tue Aug 07 22:07:49 PDT 2001
// ------------- lymphSys  -------------
BodySystem lymphSys = new BodySystem(
    LR.lymphSysSt,
    LR.lymphNodesSt,
    LR.immuneSysSt,
    L.lymphSysDescription
);
lymphSys.setPrintName(L.lymphSysPrintName);

// (C) OntoOO Inc Wed Jul 04 12:56:21 PDT 2001
// ------------- metabolicSys  -------------
BodySystem metabolicSys = new BodySystem(
    LR.metabolicSysSt,
    LR.bodySt,
    LR.bodySysSt,
    L.metabolicSysDescription
);
metabolicSys.setPrintName(L.metabolicSysPrintName);

// (C) OntoOO Inc Fri Mar 01 12:22:07 PST 2002
// ------------- pelvisSys  -------------
BodySystem pelvisSys = new BodySystem(
    LR.pelvisSysSt,
    LR.pelvisSt,
    LR.bodySysSt,
    L.pelvisSysDescription
);
pelvisSys.setPrintName(L.pelvisSysPrintName);

// (C) OntoOO Inc Fri Nov 23 12:37:18 PST 2001
// ------------- peritoneumSys  -------------
BodySystem peritoneumSys = new BodySystem(
    LR.peritoneumSysSt,
    LR.peritoneumSt,
    LR.bodySysSt,
    L.peritoneumSysDescription
);
peritoneumSys.setPrintName(L.peritoneumSysPrintName);

// (C) OntoOO Inc Fri Jul 06 16:06:16 PDT 2001
// ------------- skinSys  -------------
BodySystem skinSys = new BodySystem(
    LR.skinSysSt,
    LR.skinSt,
    LR.bodySysSt,
    L.skinSysDescription
);
skinSys.setPrintName(L.skinSysPrintName);

// (C) OntoOO Inc Thu Jul 17 14:54:42 PDT 2003
// ------------- faceSys  -------------
BodySystem faceSys = new BodySystem(
    LR.faceSysSt,
    LR.faceSt,
    LR.skinSysSt,
    L.faceSysDescription
);
faceSys.setPrintName(L.faceSysPrintName);

// (C) OntoOO Inc Mon Jun 30 13:57:12 PDT 2003
// ------------- nailsSys  -------------
BodySystem nailsSys = new BodySystem(
    LR.nailsSysSt,
    LR.nailsSt,
    LR.skinSysSt,
    L.nailsSysDescription
);
nailsSys.setPrintName(L.nailsSysPrintName);

// (C) OntoOO Inc Mon Jun 30 14:03:44 PDT 2003
// ------------- fingerNailsSys  -------------
BodySystem fingerNailsSys = new BodySystem(
    LR.fingerNailsSysSt,
    LR.fingerNailsSt,
    LR.nailsSysSt,
    L.fingerNailsSysDescription
);
fingerNailsSys.setPrintName(L.fingerNailsSysPrintName);

// (C) OntoOO Inc Mon Jun 30 14:03:04 PDT 2003
// ------------- toeNailsSys  -------------
BodySystem toeNailsSys = new BodySystem(
    LR.toeNailsSysSt,
    LR.toeNailsSt,
    LR.nailsSysSt,
    L.toeNailsSysDescription
);
toeNailsSys.setPrintName(L.toeNailsSysPrintName);

// (C) OntoOO Inc Tue Jun 24 10:17:59 PDT 2003
// ------------- scalpSys  -------------
BodySystem scalpSys = new BodySystem(
    LR.scalpSysSt,
    LR.scalpSt,
    LR.skinSysSt,
    L.scalpSysDescription
);
scalpSys.setPrintName(L.scalpSysPrintName);

// (C) OntoOO Inc Tue Sep 23 09:31:15 PDT 2003
// ------------- hairSys  -------------
BodySystem hairSys = new BodySystem(
    LR.hairSysSt,
    LR.skinSt,
    LR.skinSysSt,
    L.hairSysDescription
);
hairSys.setPrintName(L.hairSysPrintName);

// (C) OntoOO Inc Tue Sep 23 09:41:09 PDT 2003
// ------------- pubisHairSys  -------------
BodySystem pubisHairSys = new BodySystem(
    LR.pubisHairSysSt,
    LR.pubisSt,
    LR.hairSysSt,
    L.pubisHairSysDescription
);
pubisHairSys.setPrintName(L.pubisHairSysPrintName);

// (C) OntoOO Inc Fri Jul 06 16:04:59 PDT 2001
// ------------- throatSys  -------------
BodySystem throatSys = new BodySystem(
    LR.throatSysSt,
    LR.throatSt,
    LR.bodySysSt,
    L.throatSysDescription
);
throatSys.setPrintName(L.throatSysPrintName);

// (C) OntoOO Inc Thu Mar 07 21:37:41 PST 2002
// ------------- tonsilsSys  -------------
BodySystem tonsilsSys = new BodySystem(
    LR.tonsilsSysSt,
    LR.tonsilsSt,
    LR.throatSysSt,
    L.tonsilsSysDescription
);
tonsilsSys.setPrintName(L.tonsilsSysPrintName);


  } // end of doit(...)

} // end of InitBodySystems

