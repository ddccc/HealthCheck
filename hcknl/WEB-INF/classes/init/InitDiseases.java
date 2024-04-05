// (C) OntoOO Inc 2000
package init;

import com.Common;

public class InitDiseases {
  public static void doit() {
    System.out.println("****** InitDiseases ...");

    Common.createTheDiseases();
    Common.setTheDiseasesLoaded(true);

    Common.createTheExternalCauses();
    Common.setTheExternalCausesLoaded(true);


    int n = 0;
    System.out.println("****** InitCardioVascularDiseases ...");
    InitCardioVascularDiseases.doit();
    int i = Common.numOfDiseases(); int j = i - n; n = i;
    System.out.println("****** Exit InitCardioVascularDiseases ..." + j);

    System.out.println("****** InitEarDiseases ...");
    InitEarDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitEarDiseases ..." + j);

    System.out.println("****** InitEndocrineDiseases ...");
    InitEndocrineDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitEndocrineDiseases ..." + j);

    System.out.println("****** InitEyeDiseases ...");
    InitEyeDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitEyeDiseases ..." + j);

    System.out.println("****** InitGastrointestinalDiseases ...");
    InitGastrointestinalDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitGastrointestinalDiseases ..." + j);

    System.out.println("****** InitGeneticDiseases ...");
    InitGeneticDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitGeneticDiseases ..." + j);

    System.out.println("****** InitGynecologicDiseases ...");
    InitGynecologicDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitGynecologicDiseases ..." + j);

    System.out.println("****** InitHematologicDiseases ...");
    InitHematologicDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitHematologicDiseases ..." + j);

    System.out.println("****** InitHepaticDiseases ...");
    InitHepaticDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitHepaticDiseases ... " + j);

    System.out.println("****** InitImmuneDiseases ...");
    InitImmuneDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitImmuneDiseases ..." + j);

    System.out.println("****** InitInfectionDiseases ...");
    InitInfectionDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitInfectionDiseases ..." + j);

    System.out.println("****** InitMetabolicDiseases ...");
    InitMetabolicDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitMetabolicDiseases ..." + j);

    System.out.println("****** InitMusculoSkeletalDiseases ...");
    InitMusculoSkeletalDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitMusculoSkeletalDiseases ..." + j);

    System.out.println("****** InitNeoplasmDiseases ...");
    InitNeoplasmDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitNeoplasmDiseases ..." + j);

    System.out.println("****** InitNeurologicDiseases ...");
    InitNeurologicDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitNeurologicDiseases ..." + j);

    System.out.println("****** InitNoseDiseases ...");
    InitNoseDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitNoseDiseases ... " + j);

    System.out.println("****** InitNutritionalDiseases ...");
    InitNutritionalDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitNutritionalDiseases ... " + j);

    System.out.println("****** InitPediatricDiseases ...");
    InitPediatricDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitPediatricDiseases ... " + j);

    System.out.println("****** InitPsychiatricDiseases ...");
    InitPsychiatricDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitPsychiatricDiseases ..." + j);

    System.out.println("****** InitRenalDiseases ...");
    InitRenalDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitRenalDiseases ..." + j);

    System.out.println("****** InitRespiratoryDiseases ...");
    InitRespiratoryDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitRespiratoryDiseases ..." + j);

    System.out.println("****** InitSexualDiseases ...");
    InitSexualDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit SexualDiseases ..." + j);

    System.out.println("****** InitSkinDiseases ...");
    InitSkinDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit SkinDiseases ..." + j);

    System.out.println("****** InitThroatDiseases ...");
    InitThroatDiseases.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitThroatDiseases ..." + j);

    System.out.println("****** InitTraumas ...");
    InitTraumas.doit();
    i = Common.numOfDiseases(); j = i - n; n = i;
    System.out.println("****** Exit InitTraumas ..." + j);

    // diseases of other systems here ...

    System.out.println("****** Exit InitDiseases ... " + Common.numOfDiseases());

  } // end of main(...)

} // end of InitDiseases

