// (C) OntoOO Inc 2000

package init;

import com.LR;
import com.L;
import com.D;
import concepts.*;

public class InitEndocrineSys {

  public static void doit() {

// (C) OntoOO Inc Wed Jul 04 09:08:29 PDT 2001
// ------------- endocrineSys  -------------
BodySystem endocrineSys = new BodySystem(
    LR.endocrineSysSt,
    LR.bodySt,
    LR.glandsSysSt,
    L.endocrineSysDescription
);
endocrineSys.addIllustration(D.EndocrineSystemGif);
endocrineSys.setPrintName(L.endocrineSysPrintName);

// (C) OntoOO Inc Wed Jul 04 09:59:33 PDT 2001
// ------------- adrenalSys  -------------
BodySystem adrenalSys = new BodySystem(
    LR.adrenalSysSt,
    LR.adrenalsSt,
    LR.endocrineSysSt,
    L.adrenalSysDescription
);
adrenalSys.addIllustration(D.EndocrineSystemGif);
adrenalSys.setPrintName(L.adrenalSysPrintName);

// (C) OntoOO Inc Wed Jul 04 10:41:20 PDT 2001
// ------------- ovariesSys  -------------
BodySystem ovariesSys = new BodySystem(
    LR.ovariesSysSt,
    LR.ovariesSt,
    LR.endocrineSysSt,
    L.ovariesSysDescription
);
ovariesSys.setPrintName(L.ovariesSysPrintName);
ovariesSys.setGender(LR.female);
ovariesSys.addIllustration(D.EndocrineSystemGif);

// (C) OntoOO Inc Wed Jul 04 10:03:06 PDT 2001
// ------------- pancreasSys  -------------
BodySystem pancreasSys = new BodySystem(
    LR.pancreasSysSt,
    LR.pancreasSt,
    LR.endocrineSysSt,
    L.pancreasSysDescription
);
pancreasSys.addIllustration(D.EndocrineSystemGif);
pancreasSys.setPrintName(L.pancreasSysPrintName);

// (C) OntoOO Inc Wed Jul 04 09:19:55 PDT 2001
// ------------- parathyroidSys  -------------
BodySystem parathyroidSys = new BodySystem(
    LR.parathyroidSysSt,
    LR.parathyroidsSt,
    LR.endocrineSysSt,
    L.parathyroidSysDescription
);
parathyroidSys.addIllustration(D.EndocrineSystemGif);
parathyroidSys.setPrintName(L.parathyroidSysPrintName);

// (C) OntoOO Inc Wed Jul 04 09:10:13 PDT 2001
// ------------- pituitarySys  -------------
BodySystem pituitarySys = new BodySystem(
    LR.pituitarySysSt,
    LR.pituitarySt,
    LR.endocrineSysSt,
    L.pituitarySysDescription
);
pituitarySys.addIllustration(D.EndocrineSystemGif);
pituitarySys.setPrintName(L.pituitarySysPrintName);

// (C) OntoOO Inc Wed Jul 04 09:13:06 PDT 2001
// ------------- thyroidSys  -------------
BodySystem thyroidSys = new BodySystem(
    LR.thyroidSysSt,
    LR.thyroidSt,
    LR.endocrineSysSt,
    L.thyroidSysDescription
);
thyroidSys.addIllustration(D.EndocrineSystemGif);
thyroidSys.setPrintName(L.thyroidSysPrintName);


  }
}
