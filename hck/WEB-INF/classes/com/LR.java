// (C) OntoOO Inc 2001
package com;


public interface  LR {

    final static int maxAge = 150;

  // location stuff

    final static String inside     = L.inside;
      // surface is ambiguous since no distinction is made between inside/outside
    final static String surface    = L.surface;
    final static String adjacent   = L.adjacent;
    final static String connecting = L.connecting;

    final static String left        = L.left;
    final static String right       = L.right;
    final static String leftToRight = L.leftToRight;
    final static String leftToMiddle = L.leftToMiddle;
    final static String rightToMiddle = L.rightToMiddle;

    final static String top          = L.top;
    final static String bottom       = L.bottom;
    final static String topToBottom  = L.topToBottom;
    final static String topToMiddle  = L.topToMiddle;
    final static String bottomToMiddle  = L.bottomToMiddle;

    final static String back        = L.back;
    final static String front       = L.front;
    final static String backToFront = L.backToFront;
    final static String backToMiddle = L.backToMiddle;
    final static String frontToMiddle = L.frontToMiddle;

    final static String middle   = L.middle;
    final static String na       = L.NA;

    final static String d0       = "d0";
    final static String d1       = "d1";
    final static String d2       = "d2";
    final static String d3       = "d3";

    final static String both     = L.both;
    final static String male     = L.male;
    final static String female   = L.female;
    final static String moreMale   = L.moreMale;
    final static String moreFemale   = L.moreFemale;

    final static String africanAmerican = L.africanAmerican;
    final static String asian = L.asian;
    final static String caucasian = L.caucasian;
    final static String chineseAmerican = L.chineseAmerican;
    final static String hispanic = L.hispanic;
    final static String indianAmerican = L.indianAmerican; 
    final static String japaneseAmerican = L.japaneseAmerican;
    final static String jewishAmerican = L.jewishAmerican;
    final static String nativeAmerican = L.nativeAmerican;

    final static String none   = L.none;

  // ===================================================================

  // locations
  // body
    final static String bodySt   = "body";
    final static String aBoneSt = "aBone";
    final static String aMuscleSt = "aMuscle";
    final static String anOrganSt = "anOrgan";
    final static String aTendonSt = "aTendon";
    final static String aVeinSt = "aVein";

  // body
    final static String aLymphNodeSt = "aLymphNode";
    final static String armsSt   = "arms";
    final static String armPitsSt   = "armPits";
    final static String bloodstreamSt = "bloodstream";
    final static String buttockSt = "buttock";
    final static String digitsSt = "digits";
    final static String esophagusSt   = "esophagus";
    final static String fingerNailsSt = "fingerNails";
    final static String glandsSt = "glands";
    final static String headSt   = "head";
    final static String hipsSt   = "hips";
    final static String jointsSt   = "joints";
    final static String leftArmPitSt = "leftArmPit";
    final static String leftHipSt = "leftHip";
    final static String leftJointsSt = "leftJoints";
    final static String leftShoulderSt   = "leftShoulder";
    final static String legsSt   = "legs";
    final static String limbsSt   = "limbs";
    final static String lymphNodesSt = "lymphNodes";
    final static String mucousMembranesSt = "mucousMembranes";
    final static String nailsSt   = "nails";
    final static String neckSt   = "neck";
    final static String nervesSt   = "nerves";
    final static String rightArmPitSt = "rightArmPit";
    final static String rightHipSt = "rightHip";
    final static String rightJointsSt = "rightJoints";
    final static String rightShoulderSt   = "rightShoulder";
    final static String shouldersSt   = "shoulders";
    final static String skinSt   = "skin";
    final static String spineSt   = "spine";
    final static String toeNailsSt = "toeNails";
    final static String torsoSt  = "torso";
    final static String tracheaSt   = "trachea";

  // torso
    final static String abdomenSt   = "abdomen";
    final static String aortaSt   = "aorta";
    final static String backSt   = "back";
    final static String chestSt   = "chest";
    final static String flanksSt = "flanks";

  // torso/ chest
    final static String breastBoneSt = "breastBone";
    final static String breastsSt   = "breasts";
    final static String breastsFemaleSt   = "breastsFemale";
    final static String heartSt   = "heart";
    final static String leftBreastSt   = "leftBreast";
    final static String leftLungSt   = "leftLung";
    final static String leftNippleSt   = "leftNipple";
    final static String lungsSt   = "lungs";
    final static String mammaryGlandsSt = "mammaryGlands";
    final static String nipplesSt = "nipples";
    final static String nipplesFemaleSt = "nipplesFemale";
    final static String pericardiumSt = "pericardium";
    final static String pleuraSt   = "pleura";
    final static String pulmonaryArteriesSt = "pulmonaryArteries";
    final static String ribCageSt   = "ribCage";
    final static String rightBreastSt   = "rightBreast";
    final static String rightLungSt   = "rightLung";
    final static String rightNippleSt   = "rightNipple";

  // torso/ abdomen
    final static String adrenalsSt = "adrenals";
    final static String amnioticMembraneSt = "amnioticMembrane";
    final static String anusSt = "anus";
    final static String appendixSt = "appendix";
    final static String bladderSt   = "bladder";
    final static String cervixSt = "cervix";
    final static String clitorisSt = "clitoris";
    final static String colonSt   = "colon";
    final static String endometriumSt = "endometrium";
    final static String epididymisSetSt = "epididymisSet";
    final static String epigastricRegionSt = "epigastricRegion";
    final static String fallopianTubesSt = "fallopianTubes";
    final static String foreSkinSt = "foreSkin";
    final static String gallbladderSt = "gallbladder";
    final static String genitaliaSt = "genitalia";
    final static String glansPenisSt = "glansPenis";
    final static String intestinesSt   = "intestines";
    final static String kidneysSt   = "kidneys";
    final static String labiaSt = "labia";
    final static String largeIntestineSt   = "largeIntestine";
    final static String leftKidneySt   = "leftKidney";
    final static String leftOvarySt   = "leftOvary";
    final static String leftTesticleSt   = "leftTesticle";
    final static String liverSt   = "liver";
    final static String lumbarSt = "lumbar";
    final static String navelSt = "navel";
    final static String ovariesSt   = "ovaries";
    final static String pancreasSt = "pancreas";
    final static String pelvisSt   = "pelvis";
    final static String penisSt   = "penis";
    final static String perineumSt = "perineum";
    final static String perineumVulvaVaginaSt = "perineumVulvaVagina";
    final static String peritoneumSt = "peritoneum";
    final static String placentaSt = "placenta";
    final static String prostateSt   = "prostate";
    final static String pubisSt = "pubis";
    final static String rectumSt = "rectum";
    final static String rightKidneySt   = "rightKidney";
    final static String rightOvarySt   = "rightOvary";
    final static String rightTesticleSt   = "rightTesticle";
    final static String scrotumSt = "scrotum";
    final static String skinOfGenitalSt = "skinOfGenital";
    final static String smallIntestineSt   = "smallIntestine";
    final static String spleenSt = "spleen";
    final static String stomachSt   = "stomach";
    final static String testiclesSt   = "testicles";
    final static String umbilicusSt = "umbilicus";
    final static String urethralExitFMSt = "urethralExitFM";
    final static String urethralExitMLSt = "urethralExitML";
    final static String urethraFMSt = "urethraFM";
    final static String urethraMLSt = "urethraML";
    final static String uterusSt   = "uterus";
    final static String vaginaSt   = "vagina";
    final static String vulvaSt   = "vulva";

  // heart
    final static String myocardiumSt   = "myocardium";

  // head
    final static String brainSt  = "brain";
    final static String cheeksSt  = "cheeks";
    final static String conjunctivaSt = "conjunctiva";
    final static String corneasSt = "corneas";
    final static String cranialNerve5thSt = "cranialNerve5th";
    final static String cranialNerve7thSt = "cranialNerve7th";
    final static String earsSt   = "ears";
    final static String eyesSt   = "eyes";
    final static String eyelidsSt = "eyelids";
    final static String faceSt   = "face";
    final static String gumsSt = "gums";
    final static String jawsSt   = "jaws";
    final static String larynxSt   = "larynx";
    final static String leftEarSt   = "leftEar";
    final static String leftEyeSt   = "leftEye";
    final static String leftJawSt   = "leftJaw";
    final static String lipsSt = "lips";
    final static String mindSt   = "mind"; // why not ...
    final static String mouthSt   = "mouth";
    final static String noseSeptumSt = "noseSeptum";
    final static String noseSt   = "nose";
    final static String palateSt = "palate";
    final static String parotidGlandsSt = "parotidGlands";
    final static String pupilsSt = "pupils";
    final static String pituitarySt = "pituitary";
    final static String retinasSt = "retinas";
    final static String rightEarSt   = "rightEar";
    final static String rightEyeSt   = "rightEye";
    final static String rightJawSt   = "rightJaw";
    final static String scalpSt = "scalp";
    final static String sinusSt = "sinus";
    final static String skullSt   = "skull";
    final static String teethSt = "teeth";
    final static String throatSt   = "throat";
    final static String tongueSt   = "tongue";
    final static String tonsilsSt   = "tonsils";

  // neck
    final static String napeSt   = "nape";
    final static String neckLymphNodeSt = "neckLymphNode";
    final static String neckVeinsSt   = "neckVeins";
    final static String thyroidSt = "thyroid";
    final static String parathyroidsSt = "parathyroids";
    final static String vocalCordsSt = "vocalCords";

  // legs
    final static String anklesSt = "ankles";
    final static String feetSt = "feet";
    final static String groinSt = "groin";
    final static String indexToesSt = "indexToes";
    final static String kneesSt = "knees";
    final static String largeToesSt = "largeToes";
    final static String leftAnkleSt = "leftAnkle";
    final static String leftFootSt = "leftFoot";
    final static String leftIndexToeSt = "leftIndexToe";
    final static String leftKneeSt = "leftKnee";
    final static String leftLargeToeSt = "leftLargeToe";
    final static String leftLegSt = "leftLeg";
    final static String leftLowerLegSt = "leftLowerLeg";
    final static String leftMiddleToeSt = "leftMiddleToe";
    final static String leftPinkToeSt = "leftPinkToe";
    final static String leftRingToeSt = "leftRingToe";
    final static String leftToesSt = "leftToes";
    final static String leftUpperLegSt = "leftUpperLeg";
    final static String lowerLegsSt = "lowerLegs";
    final static String middleToesSt = "middleToes";
    final static String pinkToesSt = "pinkToes";
    final static String rightAnkleSt = "rightAnkle";
    final static String rightFootSt = "rightFoot";
    final static String rightIndexToeSt = "rightIndexToe";
    final static String rightKneeSt = "rightKnee";
    final static String rightLargeToeSt = "rightLargeToe";
    final static String rightLegSt = "rightLeg";
    final static String rightLowerLegSt = "rightLowerLeg";
    final static String rightMiddleToeSt = "rightMiddleToe";
    final static String rightPinkToeSt = "rightPinkToe";
    final static String rightRingToeSt = "rightRingToe";
    final static String rightToesSt = "rightToes";
    final static String rightUpperLegSt = "rightUpperLeg";
    final static String ringToesSt = "ringToes";
    final static String shinsSt = "shins";
    final static String thighsSt = "thighs";
    final static String toesSt = "toes";
    final static String upperLegsSt = "upperLegs";

  // arms
    final static String elbowsSt = "elbows";
    final static String indexesSt = "indexes";
    final static String handsSt = "hands";
    final static String fingersSt = "fingers";
    final static String leftArmSt = "leftArm";
    final static String leftElbowSt = "leftElbow";
    final static String leftFingersSt = "leftFingers";
    final static String leftHandSt = "leftHand";
    final static String leftIndexSt = "leftIndex";
    final static String leftLowerArmSt = "leftLowerArm";
    final static String leftMiddleFingerSt = "leftMiddleFinger";
    final static String leftPalmSt = "leftPalm";
    final static String leftPinkSt = "leftPink";
    final static String leftRingFingerSt = "leftRingFinger";
    final static String leftThumbSt = "leftThumb";
    final static String leftUpperArmSt = "leftUpperArm";
    final static String leftWristSt = "leftWrist";
    final static String lowerArmsSt = "lowerArms";
    final static String middleFingersSt = "middleFingers";
    final static String palmsSt = "palms";
    final static String phalangesSt = "phalanges";
    final static String pinksSt = "pinks";
    final static String rightArmSt = "rightArm";
    final static String rightElbowSt = "rightElbow";
    final static String rightFingersSt = "rightFingers";
    final static String rightHandSt = "rightHand";
    final static String rightIndexSt = "rightIndex";
    final static String rightLowerArmSt = "rightLowerArm";
    final static String rightMiddleFingerSt = "rightMiddleFinger";
    final static String rightPinkSt = "rightPink";
    final static String rightPalmSt = "rightPalm";
    final static String rightRingFingerSt = "rightRingFinger";
    final static String rightThumbSt = "rightThumb";
    final static String rightUpperArmSt = "rightUpperArm";
    final static String rightWristSt = "rightWrist";
    final static String ringFingersSt = "ringFingers";
    final static String thumbsSt = "thumbs";
    final static String upperArmsSt = "upperArms";
    final static String wristsSt = "wrists";



  // ===================================================================


  // bodySystems/ the root
    final static String bodySysSt = "bodySys";

  // cardio vascular system
    final static String cardioVascularSysSt = "cardioVascularSys";
    final static String heartSysSt = "heartSys";
    final static String pulmonaryArterySysSt = "pulmonaryArterySys";
    final static String vascularSysSt = "vascularSys";

  // ears
    final static String earsSysSt = "earsSys";

  // endocrine system
    final static String adrenalSysSt = "adrenalSys";
    final static String ovariesSysSt = "ovariesSys";
    final static String pancreasSysSt = "pancreasSys";
    final static String parathyroidSysSt = "parathyroidSys";
    final static String pituitarySysSt = "pituitarySys";
    final static String testesSysSt = "testesSys";
    final static String thyroidSysSt = "thyroidSys";

  // eyes
    final static String eyesSysSt = "eyesSys";

  // gastrointestinal system

    final static String appendixSysSt = "appendixSys";
    final static String colonSysSt = "colonSys";
    final static String gastrointestinalSysSt = "gastrointestinalSys";
    final static String esophagusSysSt = "esophagusSys";
    final static String intestinesSysSt = "intestinesSys";
    final static String largeIntestineSysSt = "largeIntestineSys";
    final static String mouthSysSt = "mouthSys";
    final static String pharynxSysSt = "pharynxSys";
    final static String rectumSysSt = "rectumSys";
    final static String smallIntestineSysSt = "smallIntestineSys";
    final static String stomachSysSt = "stomachSys";
    final static String tongueSysSt = "tongueSys";

  // gland system
    final static String glandsSysSt = "glandsSys";
    final static String endocrineSysSt = "endocrineSys";
    final static String exocrineGlandsSysSt = "exocrineGlandsSys";
    final static String mammaryGlandsSysSt = "mammaryGlandsSys";

  // groin - body region
    final static String groinSysSt = "groinSys";

  // gynecologic system
    final static String gynecologicSysSt = "gynecologicSys";
    final static String cervixSysSt = "cervixSys";
    final static String endometriumSysSt = "endometriumSys";
    final static String fallopianTubesSysSt = "fallopianTubesSys";
    final static String perineumVulvaVaginaSysSt = "perineumVulvaVaginaSys";
    final static String placentaSysSt = "placentaSys";
    final static String uterusSysSt = "uterusSys";
    final static String vaginagySysSt = "vaginagySys";

// hematologic - blood
    final static String hematologicSysSt = "hematologicSys";
    final static String spleenSysSt = "spleenSys";

  // hepatobiliary system - liver & gallbladder
    final static String hepatobiliarySysSt = "hepatobiliarySys";
    final static String liverSysSt = "liverSys";
    final static String gallbladderSysSt = "gallbladderSys";

  // immune system
    final static String immuneSysSt = "immuneSys";
    final static String lymphSysSt = "lymphSys";

  // joints system
    final static String anklesSysSt = "anklesSys";
    final static String elbowsSysSt = "elbowsSys";
    final static String jointsSysSt = "jointsSys";
    final static String wristsSysSt = "wristsSys";

  // limbs system
    final static String armsSysSt = "armsSys";
    final static String feetSysSt = "feetSys";
    final static String largeToesSysSt = "largeToesSys";
    final static String legsSysSt = "legsSys";
    final static String limbsSysSt = "limbsSys";

  // metabolic system
    final static String metabolicSysSt = "metabolicSys";

  // musculo skeletal system
    final static String musculoSkeletalSysSt = "musculoSkeletalSys";
    final static String muscleSysSt = "muscleSys";
    final static String breastsSysSt = "breastsSys";
    final static String skeletalSysSt = "skeletalSys";

  // neurologic system
    final static String neurologicSysSt = "neurologicSys";
    final static String autonomicNervousSysSt = "autonomicNervousSys";
    final static String brainSysSt = "brainSys";
    final static String centralNervousSysSt = "centralNervousSys";
    final static String cranialNerve5thSysSt = "cranialNerve5thSys";
    final static String cranialNerve7thSysSt = "cranialNerve7thSys";
    final static String mindSysSt = "mindSys";
    final static String peripheralNervousSysSt = "peripheralNervousSys";
    final static String spineSysSt = "spineSys";

  // pelvis - body region
    final static String pelvisSysSt = "pelvisSys";

  // peritoneum - membrane that lines the abdomen cavity
    final static String peritoneumSysSt = "peritoneumSys";

  // renal - kidneys
    final static String leftKidneySysSt = "leftKidneySys";
    final static String renalSysSt = "renalSys";
    final static String rightKidneySysSt = "rightKidneySys";

  // respiratory system
    final static String respiratorySysSt   = "respiratorySys";
    final static String lungsSysSt   = "lungsSys";
    final static String leftLungSysSt   = "leftLungSys";
    final static String rightLungSysSt   = "rightLungSys";
    final static String tracheaSysSt   = "tracheaSys";
    final static String noseSysSt   = "noseSys";
    final static String larynxSysSt   = "larynxSys";

  // sexual system
    final static String sexualSysSt = "sexualSys";
    final static String clitorisSysSt = "clitorisSys";
    final static String epididymisSysSt = "epididymisSys";
    final static String penisxSysSt = "penisxSys";
    final static String prostateSysSt = "prostateSys";
    final static String vaginasxSysSt = "vaginasxSys";
    final static String vulvaSysSt = "vulvaSys";

  // skin system
    final static String faceSysSt = "faceSys";
    final static String fingerNailsSysSt = "fingerNailsSys";
    final static String hairSysSt = "hairSys";
    final static String nailsSysSt = "nailsSys";
    final static String pubisHairSysSt = "pubisHairSys";
    final static String scalpSysSt = "scalpSys";
    final static String skinSysSt = "skinSys";
    final static String toeNailsSysSt = "toeNailsSys";

  // throat
    final static String throatSysSt = "throatSys";
    final static String tonsilsSysSt = "tonsilsSys";

  // urologic
    final static String urologicSysSt = "urologicSys";
    final static String bladderSysSt = "bladderSys";
    final static String urethraFMSysSt = "urethraFMSys";
    final static String urethraMLSysSt = "urethraMLSys";

  // ============== Diseases =====================================================

  // cardio vascular system diseases
    final static String aortaInsufficiency = "aortaInsufficiency";
    final static String atrialSeptalDefect = "atrialSeptalDefect";
    final static String cardiacArrest = "cardiacArrest";
    final static String cardiacArrhythmia = "cardiacArrhythmia";
    final static String cardiogenicShock = "cardiogenicShock";
    final static String cardiomyopathy = "cardiomyopathy";
    final static String coronaryArteryDisease = "coronaryArteryDisease";
    final static String corPulmonale = "corPulmonale";
    final static String dissectingAbdomenAortaAneurysm =
                       "dissectingAbdomenAortaAneurysm";
    final static String endocarditis = "endocarditis";
    final static String heartFailure = "heartFailure";
    final static String heartFailureLeftSided = "heartFailureLeftSided";
    final static String heartFailureRightSided = "heartFailureRightSided";
    final static String hypertension = "hypertension"; 
    final static String hypertensiveCrisis = "hypertensiveCrisis";
    final static String mitralInsufficiency = "mitralInsufficiency";
    final static String mitralStenosis = "mitralStenosis";
    final static String mitralValveProlapse = "mitralValveProlapse";
    final static String myocardialInfarction = "myocardialInfarction";
    final static String myocarditis = "myocarditis";
    final static String patentDuctusArteriosus = "patentDuctusArteriosus";
    final static String patentDuctusArteriosusAdult = "patentDuctusArteriosusAdult";
    final static String patentDuctusArteriosusChild = "patentDuctusArteriosusChild";
    final static String patentDuctusArteriosusInfant = "patentDuctusArteriosusInfant";
    final static String pericarditis = "pericarditis";
    final static String rheumaticFever = "rheumaticFever";
    final static String rheumaticFeverJoints = "rheumaticFeverJoints";
    final static String rheumaticFeverNodules = "rheumaticFeverNodules";
    final static String rheumaticFeverSkin = "rheumaticFeverSkin";
    final static String rheumaticHeartDisease = "rheumaticHeartDisease";
    final static String thoracicAortaAneurysm = "thoracicAortaAneurysm";
    final static String thrombophlebitis = "thrombophlebitis";
    final static String tricuspidInsufficiency = "tricuspidInsufficiency";
    final static String tricuspidStenosis = "tricuspidStenosis";
    final static String valveDisorders = "valveDisorders";
    final static String ventricularAneurysm = "ventricularAneurysm";
    final static String ventricularSeptalDefect = "ventricularSeptalDefect";

  // ear diseases
    final static String meniereDisease = "meniereDisease";
    final static String otitisMedia = "otitisMedia";  

  // endocrine system diseases
    final static String adrenalCrisis = "adrenalCrisis";
    final static String adrenogenitalSyndrome = "adrenogenitalSyndrome";
    final static String congenitalAdrenalHyperplasia = "congenitalAdrenalHyperplasia";
    final static String congenitalAdrenalHyperplasiaFemale = 
	               "congenitalAdrenalHyperplasiaFemale";
    final static String congenitalAdrenalHyperplasiaMale =
	               "congenitalAdrenalHyperplasiaMale";
    final static String cushingSyndrome = "cushingSyndrome";
    final static String diabetes = "diabetes";
    final static String diabetesInsidipus = "diabetesInsidipus";
    final static String diabetesMellitus = "diabetesMellitus";
    final static String diabetesMellitus2 = "diabetesMellitus2";
    final static String diabetesMellitusAdvanced = "diabetesMellitusAdvanced";
    final static String diabetesMellitusSuper = "diabetesMellitusSuper";
    final static String hyperaldosteronism = "hyperaldosteronism";
    final static String hyperthyroidism = "hyperthyroidism";
    final static String hypothyroidism = "hypothyroidism";
    final static String hypothyroidismCardio = "hypothyroidismCardio";
    final static String hypothyroidismSuper = "hypothyroidismSuper";
    final static String pheochromocytoma = "pheochromocytoma";
    final static String saltLosingCongenitalAdrenalHyperplasia = 
                       "saltLosingCongenitalAdrenalHyperplasia";

  // eye system diseases
    final static String conjunctivitis = "conjunctivitis";
    // final static String diabetesRetinopathy = "diabetesRetinopathy";
    final static String glaucoma = "glaucoma";
    final static String glaucomaAcute = "glaucomaAcute";
    final static String glaucomaChronic = "glaucomaChronic";
    final static String keratitis = "keratitis";
    final static String maculaDegeneration = "maculaDegeneration";
    final static String retinochoroiditis = "retinochoroiditis";
    final static String trachoma = "trachoma";
    final static String uveitis = "uveitis";
    final static String uveitisAnterior = "uveitisAnterior";
    final static String uveitisPosterior = "uveitisPosterior";
    final static String vascularRetinopathy = "vascularRetinopathy";

  // genetic diseases
    final static String cysticFibrosis = "cysticFibrosis";
    final static String hemophilia = "hemophilia";
    final static String sickleCellCrisis = "sickleCellCrisis";

  // gi track diseases
    final static String appendicitis = "appendicitis";
    final static String appendicitis2 = "appendicitis2";
    final static String celiacDisease = "celiacDisease";
    final static String diverticularSuper = "diverticularSuper";
    final static String diverticularDisease = "diverticularDisease";
    final static String diverticularDiseaseSevere = "diverticularDiseaseSevere";
    final static String gastroenteritis = "gastroenteritis";
    final static String gastroesophagealReflux = "gastroesophagealReflux";
    final static String giHemorrhage = "giHemorrhage";
    final static String gingivitis = "gingivitis";
    final static String glossitis = "glossitis";
    final static String hemorrhoids = "hemorrhoids";
    final static String hirschsprung = "hirschsprung";
    final static String hirschsprungAdult = "hirschsprungAdult";
    final static String hirschsprungChild = "hirschsprungChild";
    final static String hirschsprungInfant = "hirschsprungInfant";
    final static String intestinalObstruction = "intestinalObstruction";
    final static String necrotizingEnterocolitis = "necrotizingEnterocolitis";
    final static String pancreatitis = "pancreatitis";
    final static String pepticUlcers = "pepticUlcers";
    final static String peritonitis = "peritonitis";
    final static String stomatitis = "stomatitis";
    final static String stomatitisAcuteHerpetic = "stomatitisAcuteHerpetic";
    final static String stomatitisAphthous = "stomatitisAphthous";
    final static String ulcerativeColitis = "ulcerativeColitis";

  // gynecologic diseases
    final static String abnormalPremenopausalBleeding = 
                       "abnormalPremenopausalBleeding";
    final static String abortion = "abortion";
    final static String abruptioPlacentae = "abruptioPlacentae";
    final static String amenorrhea = "amenorrhea";
    final static String amnioticMembraneRupture = "amnioticMembraneRupture";
    final static String breastEngorgement = "breastEngorgement";
    final static String cardiovascularDiseaseInPregnancy = 
                       "cardiovascularDiseaseInPregnancy"; 
    final static String cervicitis = "cervicitis";
    final static String choriocarcinoma = "choriocarcinoma";
    final static String diabetesComplicationsInPregnancy = 
                       "diabetesComplicationsInPregnancy";
    final static String dysmenorrhea = "dysmenorrhea";
    final static String ectopicPregnancy = "ectopicPregnancy"; 
    final static String ectopicPregnancyRupture = "ectopicPregnancyRupture";
    final static String ectopicPregnancySuper = "ectopicPregnancySuper";
    final static String endometriosis = "endometriosis";
    final static String endometriosisBA = "endometriosisBA";
    final static String endometriosisBladder = "endometriosisBladder";
    final static String endometriosisOO = "endometriosisOO";
    final static String endometriosisOC = "endometriosisOC";
    final static String endometriosisCVP = "endometriosisCVP";
    final static String endometritis = "endometritis";
    final static String femoralThrombophlebitis = "femoralThrombophlebitis";
    final static String galactorrhea = "galactorrhea";
    final static String hydatidiformMole = "hydatidiformMole";
    final static String hyperbilirubinemia = "hyperbilirubinemia";
    final static String hyperbilirubinemiaPathologic = "hyperbilirubinemiaPathologic";
    final static String hyperbilirubinemiaPhysiologic = "hyperbilirubinemiaPhysiologic";
    final static String hyperemesisGravidarum = "hyperemesisGravidarum";
    final static String hypogonadism = "hypogonadism";
    final static String hypomenorrhea = "hypomenorrhea";
    final static String infertilityFemale = "infertilityFemale";
    final static String mastitis = "mastitis";
    final static String menopause = "menopause";
    final static String menorrhagia = "menorrhagia";
    final static String metrorrhagia = "metrorrhagia";
    final static String oligomenorrhea = "oligomenorrhea";
    final static String ovariesCysts = "ovariesCysts";
    final static String parametritis = "parametritis";
    final static String pelvisInflammatoryDisease = 
                       "pelvisInflammatoryDisease";
    final static String pelvisThrombophlebitis = "pelvisThrombophlebitis";
    final static String placentaPrevia = "placentaPrevia";
    final static String polymenorrhea = "polymenorrhea";
    final static String postMenopauseBleeding = "postMenopauseBleeding";
    final static String pregnancyInducedHypertension = 
                       "pregnancyInducedHypertension";
    final static String prematureLabor = "prematureLabor";
    final static String prematureRuptureOfTheMembranes = 
                       "prematureRuptureOfTheMembranes";
    final static String premenstrualSyndrome = "premenstrualSyndrome";
    final static String puerperalInfection = "puerperalInfection";
    final static String puerperalInfectionLocalLesions = 
                       "puerperalInfectionLocalLesions";
    final static String salpingoOophoritis = "salpingoOophoritis";
    final static String vaginismus = "vaginismus";
    final static String vulvovaginitis = "vulvovaginitis";
    final static String vulvovaginitisCan = "vulvovaginitisCan";
    final static String vulvovaginitisClam = "vulvovaginitisClam";
    final static String vulvovaginitisGar = "vulvovaginitisGar";
    final static String vulvovaginitisGon = "vulvovaginitisGon";
    final static String vulvovaginitisHer = "vulvovaginitisHer";
    final static String vulvovaginitisTri = "vulvovaginitisTri";


  // hematologic system diseases
    final static String anemia = "anemia";
    final static String anemiaFolicAcidDeficiency = "anemiaFolicAcidDeficiency";
    final static String disseminatedIntravascularCoagulation =
                       "disseminatedIntravascularCoagulation"; // DIC 
    final static String hypersplenism = "hypersplenism";
    final static String idiopathicThrombocytopenicPurpura = 
                       "idiopathicThrombocytopenicPurpura";
    final static String idiopathicThrombocytopenicPurpuraAcute = 
                       "idiopathicThrombocytopenicPurpuraAcute";
    final static String idiopathicThrombocytopenicPurpuraChronic = 
                       "idiopathicThrombocytopenicPurpuraChronic";
    final static String polycythemiaVera = "polycythemiaVera";
    final static String sickleCellAnemia = "sickleCellAnemia";

  // hepatic system diseases
    final static String bleedingEsophagealVarices = "bleedingEsophagealVarices";
    final static String cholelithiasis = "cholelithiasis";
    final static String cirrhosis = "cirrhosis";
    final static String hepatitis = "hepatitis";
    final static String hepatitisNonViral = "hepatitisNonViral";
    final static String hepatitisJaundice = "hepatitisJaundice";
    final static String hepatitisProdromal = "hepatitisProdromal";
    final static String hepatitisViral = "hepatitisViral";

  // immune diseases
    final static String acquiredImmunoDeficiencySyndrome = 
	               "acquiredImmunoDeficiencySyndrome";
    final static String acquiredImmunoDeficiencySyndromeAdvanced = 
	               "acquiredImmunoDeficiencySyndromeAdvanced";
    final static String anaphylaxis = "anaphylaxis";
    final static String ankylosingSpondylitis = "ankylosingSpondylitis";
    final static String arthritis = "arthritis";
    final static String asthma = "asthma";
    final static String chronicFatigueSyndrome = "chronicFatigueSyndrome";
    final static String lupusErythematosus = "lupusErythematosus";
    final static String lupusErythematosusDiscoid = "lupusErythematosusDiscoid";
    final static String lupusErythematosusSystemic = "lupusErythematosusSystemic";
    final static String polyarteritisNodosa = "polyarteritisNodosa";
    final static String polymyositis = "polymyositis";
    final static String rheumatoidArthritis = "rheumatoidArthritis";
    final static String rheumatoidArthritis1 = "rheumatoidArthritis1";
    final static String rheumatoidArthritis2 = "rheumatoidArthritis2";
    final static String rheumatoidArthritis3 = "rheumatoidArthritis3";
    final static String scleroderma = "scleroderma";
    final static String vasculitis = "vasculitis";
    final static String vasculitisPulmonary = "vasculitisPulmonary";

  // infection diseases
    final static String amebiasis = "amebiasis";
    final static String anthrax = "anthrax";
    final static String anthraxCutaneous = "anthraxCutaneous";
    final static String anthraxInhalation = "anthraxInhalation";
    final static String anthraxIntestinal = "anthraxIntestinal";
    final static String botulism = "botulism";
    final static String campylobacteriosis = "campylobacteriosis";
    final static String candidiasis = "candidiasis";
    final static String candidiasisBrain = "candidiasisBrain";
    final static String candidiasisEsophagus = "candidiasisEsophagus";
    final static String candidiasisEye = "candidiasisEye";
    final static String candidiasisNails = "candidiasisNails";
    final static String candidiasisPulmonary = "candidiasisPulmonary";
    final static String candidiasisRenal = "candidiasisRenal";
    final static String candidiasisSkin = "candidiasisSkin";
    final static String cryptosporidiosis = "cryptosporidiosis";
    final static String epsteinBarrDisease = "epsteinBarrDisease"; // mononucleosis
    final static String erypsipelas = "erypsipelas";
    final static String escherichiaColi = "escherichiaColi";
    final static String flu = "flu";
    final static String gasGangrene = "gasGangrene";
    final static String giardiasis = "giardiasis";
    final static String herpesSimplex = "herpesSimplex";
    final static String herpesSimplex1 = "herpesSimplex1";
    final static String herpesZoster = "herpesZoster";
    final static String herpesZoster1 = "herpesZoster1";
    final static String herpesZoster2 = "herpesZoster2";
    final static String herpesZoster3 = "herpesZoster3";
    final static String impetigo = "impetigo";
    final static String listeriosis = "listeriosis";
    final static String listeriosisPregnant = "listeriosisPregnant";
    final static String listeriosisSuper = "listeriosisSuper";
    final static String lymeDisease = "lymeDisease";
    final static String lymeDisease1 = "lymeDisease1";
    final static String lymeDisease2 = "lymeDisease2";
    final static String lymeDisease3 = "lymeDisease3";
    final static String malaria = "malaria";
    final static String malaria2 = "malaria2";
    final static String meningococcemia = "meningococcemia";
    final static String meningococcemiaSevere = "meningococcemiaSevere";
    final static String mumps = "mumps";
    // final static String mumps1 = "mumps1";
    // final static String mumps2 = "mumps2";
    final static String pertussis = "pertussis"; // whoopingCough
    final static String poliomyelitis = "poliomyelitis";
    final static String poliomyelitisMinor = "poliomyelitisMinor";
    final static String poliomyelitisNonparalytic = "poliomyelitisNonparalytic";
    final static String poliomyelitisParalytic = "poliomyelitisParalytic";
    final static String postherpeticNeuralgia = "postherpeticNeuralgia";
    final static String rabies = "rabies";
    final static String rockyMountainSpottedFever = "rockyMountainSpottedFever";
    final static String rubella = "rubella";
    final static String salmonellosis = "salmonellosis";
    final static String salmonellosisBacteremia = "salmonellosisBacteremia";
    final static String salmonellosisEnterocolitis = "salmonellosisEnterocolitis";
    final static String schistosomiasis = "schistosomiasis";
    final static String septicemia = "septicemia";
    final static String septicShock = "septicShock";
    final static String septicShockEarlyPhase = "septicShockEarlyPhase";
    final static String septicShockLatePhase = "septicShockLatePhase";
    final static String shigellosis = "shigellosis";
    final static String streptococcalInfection = "streptococcalInfection";
    final static String tetanus = "tetanus";
    final static String thrush = "thrush";
    final static String toxoplasmosis = "toxoplasmosis";
    final static String toxoplasmosisAcquired = "toxoplasmosisAcquired";
    final static String toxoplasmosisAcquiredAdvanced = "toxoplasmosisAcquiredAdvanced";
    final static String toxoplasmosisAcquiredSuper = "toxoplasmosisAcquiredSuper";
    final static String toxoplasmosisCongenital = "toxoplasmosisCongenital";
    final static String typhoidFever1 = "typhoidFever1";
    final static String typhoidFever2 = "typhoidFever2";
    final static String typhoidFever3 = "typhoidFever3";
    final static String westNileVirus = "westNileVirus";
    final static String westNileVirusMild = "westNileVirusMild";
    final static String westNileVirusSevere = "westNileVirusSevere";
    final static String whoopingCough = "whoopingCough";
    final static String whoopingCoughCatarrh = "whoopingCoughCatarrh";
    final static String whoopingCoughParoxysm = "whoopingCoughParoxysm";

  // metabolic diseases
    final static String diabetesKetoacidosis = "diabetesKetoacidosis";
    final static String hyperkalemia = "hyperkalemia";
    final static String hypochloremia = "hypochloremia";
    final static String hypochloremia1 = "hypochloremia1";
    final static String hypochloremia2 = "hypochloremia2";
    final static String hypokalemia = "hypokalemia";
    final static String hypokalemiaSevere = "hypokalemiaSevere";
    final static String hypokalemiaSuper = "hypokalemiaSuper";
    final static String hyponatremia = "hyponatremia";
    final static String metabolicAcidosis = "metabolicAcidosis";
    final static String metabolicAlkalosis = "metabolicAlkalosis";
    final static String potassiumImbalance = "potassiumImbalance";
    final static String syndromeOfInappropriateAntidiureticHormoneSecretion =
                       "syndromeOfInappropriateAntidiureticHormoneSecretion";
    final static String vitaminCDeficiency = "vitaminCDeficiency";
    final static String vitaminDDeficiency = "vitaminDDeficiency";
    final static String vitaminKDeficiency = "vitaminKDeficiency";

  // musculoskeletal diseases
    final static String carpalTunnelSyndrome = "carpalTunnelSyndrome"; 
    final static String gout = "gout";
    final static String halluxValgus = "halluxValgus";
    final static String herniatedDisk = "herniatedDisk";
    final static String kyphoscoliosis = "kyphoscoliosis";
    final static String kyphosis = "kyphosis";
    final static String muscularDystrophy = "muscularDystrophy";
    final static String muscularDystrophyBecker = "muscularDystrophyBecker";
    final static String muscularDystrophyDuchenne = "muscularDystrophyDuchenne";
    final static String muscularDystrophyFacioscapulahumeral =
	"muscularDystrophyFacioscapulahumeral";
    final static String muscularDystrophyLimbGirdle = "muscularDystrophyLimbGirdle";
    final static String osteoarthritis = "osteoarthritis";
    final static String osteoporosis = "osteoporosis";

  // neoplasm diseases
    final static String basalCellCarcinoma = "basalCellCarcinoma";
    final static String basalCellCarcinomaNodulo = "basalCellCarcinomaNodulo";
    final static String basalCellCarcinomaSclerotic = "basalCellCarcinomaSclerotic";
    final static String basalCellCarcinomaSuperficial = "basalCellCarcinomaSuperficial";
    final static String bladderCancer = "bladderCancer";
    final static String breastsCancer = "breastsCancer";
    final static String cancer = "cancer";
    final static String cervixCancer = "cervixCancer";
    final static String cervixCancerEarly = "cervixCancerEarly";
    final static String cervixCancerAdvanced = "cervixCancerAdvanced";
    final static String colorectalCancer = "colorectalCancer";
    final static String colorectalCancerAdvanced = "colorectalCancerAdvanced";
    final static String colorectalCancerAdvancedLeftTumor = 
	               "colorectalCancerAdvancedLeftTumor";
    final static String esophagusCancer = "esophagusCancer";
    final static String fallopianTubeCancer = "fallopianTubeCancer";
    final static String hodgkinDisease = "hodgkinDisease";
    final static String hodgkinDisease1 = "hodgkinDisease1";
    final static String hodgkinDisease2 = "hodgkinDisease2";
    final static String kidneyCancer = "kidneyCancer";
    final static String larynxCancer = "larynxCancer";
    final static String lentigoMalignaMelanoma = "lentigoMalignaMelanoma";
    final static String leukemia = "leukemia";
    final static String leukoplakia = "leukoplakia";
    final static String leukoplakiaFemale = "leukoplakiaFemale";
    final static String leukoplakiaMale = "leukoplakiaMale";
    final static String liverCancer = "liverCancer";
    final static String lungCancer = "lungCancer";
    final static String lungCancerLargeCells = "lungCancerLargeCells";
    final static String lungCancerSmallCells = "lungCancerSmallCells";
    final static String malignantLymphomas = "malignantLymphomas";
    final static String malignantMelanoma = "malignantMelanoma";
    final static String melanoma = "melanoma";
    final static String multipleMyeloma = "multipleMyeloma";
    final static String nodularMelanoma = "nodularMelanoma";
    final static String ovariesCancer = "ovariesCancer";
    final static String ovariesCancerAdvanced = "ovariesCancerAdvanced";
    final static String ovariesCancerEarly = "ovariesCancerEarly";
    final static String pancreasCancer = "pancreasCancer";
    final static String prostateCancer = "prostateCancer";
    final static String squamousCellCarcinoma = "squamousCellCarcinoma";
    final static String stomachCancer = "stomachCancer";
    final static String stomachCancerAdvanced = "stomachCancerAdvanced";
    final static String stomachCancerSuper = "stomachCancerSuper";
    final static String superficialSpreadingMelanoma = "superficialSpreadingMelanoma";
    final static String thyroidCancer = "thyroidCancer";
    final static String uterusCancer = "uterusCancer";
    final static String vaginaCancer = "vaginaCancer";
    final static String vaginaCancerEarly = "vaginaCancerEarly";
    final static String vaginaCancerAdvanced = "vaginaCancerAdvanced";
    final static String vulvaCancer = "vulvaCancer";

  // neurologic diseases
    final static String alzheimer = "alzheimer";
    final static String alzheimer1 = "alzheimer1";
    final static String alzheimer2 = "alzheimer2";
    final static String alzheimer3 = "alzheimer3";
    final static String amyotropicLateralSclerosis = "amyotropicLateralSclerosis";
    final static String bellPalsy = "bellPalsy";
    final static String brainAbscess = "brainAbscess";
    final static String cerebralAneurysm = "cerebralAneurysm";
    final static String cerebrovascularAccident = "cerebrovascularAccident";
    final static String chorea = "chorea";
    final static String choreaTransient = "choreaTransient";
    final static String chronicHeadache = "chronicHeadache";
    final static String encephalitis = "encephalitis";
    final static String epilepsy = "epilepsy";
    final static String guillainBarreSyndrome = "guillainBarreSyndrome";
    final static String huntingtonDisease = "huntingtonDisease";
    final static String hydrocephalus = "hydrocephalus";
    final static String hydrocephalusAdult = "hydrocephalusAdult";
    final static String hydrocephalusInfant = "hydrocephalusInfant";
    final static String meningitis = "meningitis";
    final static String multipleSclerosis = "multipleSclerosis";
    final static String myastheniaGravis = "myastheniaGravis";
    final static String parkinson = "parkinson";
    final static String trigeminalNeuralgia = "trigeminalNeuralgia";

  // nose diseases
    final static String epistaxis = "epistaxis";
    final static String sinusitis = "sinusitis";

  // nutritional diseases
    final static String obesity = "obesity";

  // pediatric diseases
    final static String colicInfant = "colicInfant";

  // psychiatric diseases
    final static String agoraphobia = "agoraphobia";
    final static String anorexiaNervosa = "anorexiaNervosa";
    final static String attentionDeficitHyperactivityDisorder =
                       "attentionDeficitHyperactivityDisorder";
    final static String bulimiaNervosa = "bulimiaNervosa";
    final static String depression = "depression";
    final static String generalizedAnxiety = "generalizedAnxiety";
    final static String generalizedAnxietyMild = "generalizedAnxietyMild";
    final static String generalizedAnxietyModerate = "generalizedAnxietyModerate";
    final static String generalizedAnxietySevere = "generalizedAnxietySevere";
    final static String objectPhobia = "objectPhobia";
    final static String obsessiveCompulsiveDisorder = "obsessiveCompulsiveDisorder";
    final static String panicDisorder = "panicDisorder";
    final static String phobia = "phobia";
    final static String posttraumaticStressDisorder = "posttraumaticStressDisorder";
    final static String schizophrenia = "schizophrenia";
    final static String schizophreniaActive = "schizophreniaActive";
    final static String schizophreniaProdromal = "schizophreniaProdromal";
    final static String schizophreniaResidual = "schizophreniaResidual";
    final static String socialPhobia = "socialPhobia";

  // renal system diseases
    final static String cystitis = "cystitis";
    final static String epididymitis = "epididymitis";
    final static String nephroticSyndrome = "nephroticSyndrome";
    final static String pyelonephritis = "pyelonephritis";
    final static String pyelonephritisAcute = "pyelonephritisAcute";
    final static String pyelonephritisChronic = "pyelonephritisChronic";
    final static String renalCalculi = "renalCalculi";
    final static String renalFailureAcute = "renalFailureAcute";
    final static String renalInfarction = "renalInfarction";
    final static String renalVeinThrombosis = "renalVeinThrombosis";
    final static String tubularNecrosisAcute = "tubularNecrosisAcute";
    final static String urethritisML = "urethritisML";
    final static String urinaryTractInfection = "urinaryTractInfection";

  // respiratory system diseases
    final static String adultRespiratoryDistressSyndrome = // ARDS 
                       "adultRespiratoryDistressSyndrome";
    final static String asbestosis = "asbestosis";
    // acute respiratory failure on top of chronic obstructive pulmonary disease
    final static String aRFinCOPD = "aRFinCOPD";
    final static String aRFinCOPDcardio = "aRFinCOPDcardio";
    final static String aRFinCOPDcns = "aRFinCOPDcns";
    final static String aRFinCOPDinf = "aRFinCOPDinf";
    final static String atelectasis = "atelectasis";
    final static String berylliosis = "berylliosis";
    final static String berylliosisAcute = "berylliosisAcute";
    final static String berylliosisChronic = "berylliosisChronic";
    final static String bronchiectasis = "bronchiectasis";
  // final static String bronchogenicCarcinoma = "bronchogenicCarcinoma";
  // final static String bronchitis = "bronchitis";
    final static String bronchiolitisObliteransWithPneumonia =
                       "bronchiolitisObliteransWithPneumonia";
    final static String chickenpox = "chickenpox";
    final static String chronicAsthma = "chronicAsthma";
    final static String chronicBronchitis = "chronicBronchitis";
    final static String chronicObstructivePulmonaryDisease = 
                       "chronicObstructivePulmonaryDisease";
    final static String coalWorkerPneumoconiosis = "coalWorkerPneumoconiosis";
    final static String croup = "croup";
    final static String epiglottitis = "epiglottitis";
    final static String emphysema = "emphysema";
    final static String h5n1 = "h5n1";
    final static String hemothorax = "hemothorax";
    final static String hyalineMembraneDisease = "hyalineMembraneDisease";
    final static String idiopathicPulmonaryFibrosis = "idiopathicPulmonaryFibrosis";
    // final static String inflammatoryLungDisease = "inflammatoryLungDisease";
    final static String influenza = "influenza";
    // final static String interstitialPneumonitis = "interstitialPneumonitis";
    final static String laryngitis = "laryngitis";
    final static String laryngotracheobronchitis = "laryngotracheobronchitis";
    final static String legionaire = "legionaire";
    final static String lungAbscess = "lungAbscess";
    final static String measles = "measles";
    final static String pleurisy = "pleurisy";
    final static String pneumocystisCarinii = "pneumocystisCarinii";
    final static String pneumonia = "pneumonia";
    final static String pneumoniaAcute = "pneumoniaAcute";
    final static String pneumoniaAdenoVirus = "pneumoniaAdenoVirus";
    final static String pneumoniaAspiration = "pneumoniaAspiration";
    // final static String pneumoconiosis = "pneumoconiosis";
    final static String pneumoniaKlebsiella = "pneumoniaKlebsiella";
    final static String pneumoniaCytomegaloVirus = "pneumoniaCytomegaloVirus";
    final static String pneumoniaStaphylococcus = "pneumoniaStaphylococcus";
    final static String pneumoniaStreptococcus = "pneumoniaStreptococcus";
    final static String pneumoniaSyncytialVirus = "pneumoniaSyncytialVirus";
    final static String pneumothorax = "pneumothorax";
    final static String pulmonaryEdema = "pulmonaryEdema";
    final static String pulmonaryEdemaAcute = "pulmonaryEdemaAcute";
    final static String pulmonaryEdemaChronic = "pulmonaryEdemaChronic";
    final static String pulmonaryEmbolism = "pulmonaryEmbolism";
    final static String pulmonaryHypertension = "pulmonaryHypertension";
    final static String pulmonaryHypertensionCardiac =
                       "pulmonaryHypertensionCardiac";
    final static String pulmonaryHypertensionPrimary = 
                       "pulmonaryHypertensionPrimary";
    final static String pulmonaryHypertensionHypoventilation = 
                       "pulmonaryHypertensionHypoventilation";
    final static String pulmonaryHypertensionVascularObstruction =
                       "pulmonaryHypertensionVascularObstruction";
    // final static String pulmonaryVascularDisease = "pulmonaryVascularDisease";
    final static String respiratoryAcidosis = "respiratoryAcidosis";
    final static String respiratoryDistressSyndrome = "respiratoryDistressSyndrome";
    final static String respiratoryAlkalosis = "respiratoryAlkalosis";
    final static String respiratoryFailureAcute = "respiratoryFailureAcute";
    final static String sarcoidosis = "sarcoidosis";
    final static String sarcoidosisCardio = "sarcoidosisCardio";
    final static String sarcoidosisCNS = "sarcoidosisCNS";
    final static String sarcoidosisCutaneous = "sarcoidosisCutaneous";
    final static String sarcoidosisHepatic = "sarcoidosisHepatic";
    final static String sarcoidosisLymphatic = "sarcoidosisLymphatic";
    final static String sarcoidosisMusculoSkeletal = "sarcoidosisMusculoSkeletal";
    final static String sarcoidosisOphthalmic = "sarcoidosisOphthalmic";
    final static String sarcoidosisRespiratory = "sarcoidosisRespiratory";
    final static String sarcoidosisUrinary = "sarcoidosisUrinary";
    final static String severeAcuteRespiratorySyndrome = "severeAcuteRespiratorySyndrome";
    final static String silicosis = "silicosis";
    final static String tuberculosis = "tuberculosis";
    // final static String upperLobePulmonaryFibrosis = "upperLobePulmonaryFibrosis";

  // sexual diseases
    final static String arousalDisorder = "arousalDisorder";
    final static String chancroid = "chancroid";
    final static String chancroidFemale = "chancroidFemale";
    final static String chancroidMale = "chancroidMale";
    final static String chancroidPhase2 = "chancroidPhase2";
    final static String chlamydialInfection = "chlamydialInfection";
    final static String chlamydialInfectionCervix = "chlamydialInfectionCervix";
    final static String chlamydialInfectionEndometrium = 
                       "chlamydialInfectionEndometrium";
    final static String chlamydialInfectionEpididymis =
                       "chlamydialInfectionEpididymis";
    final static String chlamydialInfectionProstate = "chlamydialInfectionProstate";
    final static String chlamydialInfectionRectum = "chlamydialInfectionRectum";
    final static String chlamydialInfectionUrethraFemale = 
                       "chlamydialInfectionUrethraFemale";
    final static String chlamydialInfectionUrethraMale =
                       "chlamydialInfectionUrethraMale";
    final static String dyspareunia = "dyspareunia"; 
    final static String erectionDisorder = "erectionDisorder";
    final static String exhibitionism = "exhibitionism";
    final static String fetishism = "fetishism";
    final static String frotteurism = "frotteurism";
    final static String genderIdentityDisorder = "genderIdentityDisorder";
    final static String genitalHerpes = "genitalHerpes";
    final static String genitalHerpesFemale = "genitalHerpesFemale";
    final static String genitalHerpesMale = "genitalHerpesMale";
    final static String genitalWarts = "genitalWarts";
    final static String genitalWartsFemale = "genitalWartsFemale";
    final static String genitalWartsMale = "genitalWartsMale";
    final static String gonococcalSepticemia = "gonococcalSepticemia";
    final static String gonorrhea = "gonorrhea";
    final static String gonorrheaFemale = "gonorrheaFemale";
    final static String gonorrheaLiver = "gonorrheaLiver";
    final static String gonorrheaPelvis = "gonorrheaPelvis";
    final static String gonorrheaRectum = "gonorrheaRectum";
    final static String gonorrheaUrethraFemale = "gonorrheaUrethraFemale";
    final static String gonorrheaUrethraMale = "gonorrheaUrethraMale";
    final static String gonorrheaVagina = "gonorrheaVagina";
    final static String gonorrheaVulva = "gonorrheaVulva";
    final static String infertilityMale = "infertilityMale";
    final static String orgasmicDisorder = "orgasmicDisorder";
    final static String paraphilias = "paraphilias";
    final static String pedophilia = "pedophilia";
    final static String precociousPubertyFemale = "precociousPubertyFemale";
    final static String precociousPubertyFemaleAdrenogenital = 
                       "precociousPubertyFemaleAdrenogenital";
    final static String precociousPubertyFemaleCerebral =
                       "precociousPubertyFemaleCerebral";
    final static String precociousPubertyFemaleConstitutional = 
                       "precociousPubertyFemaleConstitutional";
    final static String precociousPubertyFemaleTumor = "precociousPubertyFemaleTumor";
    final static String precociousPubertyMale = "precociousPubertyMale";
    final static String precociousPubertyMaleAdrenogenital =
                       "precociousPubertyMaleAdrenogenital";
    final static String precociousPubertyMaleConstitutional = 
                       "precociousPubertyMaleConstitutional";
    final static String precociousPubertyMaleCerebral =
                       "precociousPubertyMaleCerebral";
    final static String precociousPubertyMaleTumor = 
                       "precociousPubertyMaleTumor";
    final static String prematureEjaculation = "prematureEjaculation";
    final static String sexualMasochism = "sexualMasochism";
    final static String sexualSadism = "sexualSadism";
    final static String syphilis = "syphilis";
    final static String syphilisLate = "syphilisLate"; // 4th phase
    final static String syphilisLateBenign = "syphilisLateBenign"; // 4th phase
    final static String syphilisLateCardioVascular = "syphilisLateCardioVascular";
    final static String syphilisLateNeurologic = "syphilisLateNeurologic";
    final static String syphilisLatent = "syphilisLatent"; // 3rd phase
    final static String syphilisSecondary = "syphilisSecondary";
    final static String testicleTorsion = "testicleTorsion";
    final static String transvestiteFetishism = "transvestiteFetishism";
    final static String trichomoniasis = "trichomoniasis";
    final static String trichomoniasisFemale = "trichomoniasisFemale";
    final static String trichomoniasisMale = "trichomoniasisMale";
    final static String undescendedTestes = "undescendedTestes";
    final static String voyeurism = "voyeurism";

  // skin diseases
    final static String cellulitis = "cellulitis";
    final static String dermatitis = "dermatitis";
    final static String dermatitisAtopic = "dermatitisAtopic";
    final static String dermatitisChronic = "dermatitisChronic";
    final static String dermatitisContact = "dermatitisContact";
    final static String dermatitisContactAllergens = "dermatitisContactAllergens";
    final static String dermatitisContactMild = "dermatitisContactMild";
    final static String dermatitisContactStrong = "dermatitisContactStrong";
    final static String dermatitisHerpetiformis = "dermatitisHerpetiformis";
    final static String dermatitisNummular = "dermatitisNummular";
    final static String dermatitisSeborrheic = "dermatitisSeborrheic";
    final static String dermatophytosis = "dermatophytosis";
    final static String pediculosis = "pediculosis";
    final static String pediculosisCapitis = "pediculosisCapitis";
    final static String pediculosisCorporis = "pediculosisCorporis";
    final static String pediculosisPubis = "pediculosisPubis";
    final static String psoriasis = "psoriasis";
    final static String scabies = "scabies";
    final static String scarletFever = "scarletFever";
    final static String streptococcalGangrene = "streptococcalGangrene";
    final static String tineaBarbae = "tineaBarbae";
    final static String tineaCapitis = "tineaCapitis";
    final static String tineaCorporis = "tineaCorporis";
    final static String tineaCruris = "tineaCruris";
    final static String tineaPedis = "tineaPedis";
    final static String tineaUnguium = "tineaUnguium";

  // throat diseases
    final static String pharyngitis = "pharyngitis";
    final static String pharyngitisBacterial = "pharyngitisBacterial";
    final static String pharyngitisGonorrhea = "pharyngitisGonorrhea";
    final static String pharyngitisStreptococcal = "pharyngitisStreptococcal";
    final static String pharyngitisViral = "pharyngitisViral";
    final static String tonsillitis = "tonsillitis";

  // trauma
    final static String abdomenTrauma = "abdomenTrauma";
    final static String asphyxia = "asphyxia";
    final static String beeWaspYellowJacketSting = "beeWaspYellowJacketSting";
    final static String blackWidowSpiderBite = "blackWidowSpiderBite";
    final static String brownRecluseSpiderBite = "brownRecluseSpiderBite";
    final static String burn = "burn";
    final static String burnFirstDegree = "burnFirstDegree";
    final static String burnSecondDegree = "burnSecondDegree";
    final static String burnThirdDegree = "burnThirdDegree";
    final static String burnFourthDegree = "burnFourthDegree";
    final static String cerebralContusion = "cerebralContusion";
    final static String electricShock = "electricShock";
    final static String intracerebralHemorrhage = "intracerebralHemorrhage"; ////
    final static String penetratingChestWound = "penetratingChestWound";
    final static String poisoning = "poisoning";
    final static String poisonousSnakeBite = "poisonousSnakeBite";
    final static String scorpionSting = "scorpionSting";
    final static String skullFracture = "skullFracture";
    final static String tickBite = "tickBite";

  // urologic diseases
    final static String benignProstaticHyperplasia = "benignProstaticHyperplasia";
    final static String benignProstaticHyperplasia1 = "benignProstaticHyperplasia1";
    final static String benignProstaticHyperplasia2 = "benignProstaticHyperplasia2";
    final static String prostatitis = "prostatitis";
    final static String prostatitisAcute = "prostatitisAcute";
    final static String prostatitisChronic = "prostatitisChronic";

  // other diseases
    // final static String chronicMountainSickness = "chronicMountainSickness";
    final static String polyomyelitis = "polyomyelitis";
    // final static String thromboembolism = "thromboembolism";

  // internal causes - general categories (instead of specific upstream diseases)
  /*
    */
    final static String cardioDisorders = "cardioDisorders";
    final static String earDisorders = "earDisorders";
    final static String endocrineDisorders = "endocrineDisorders";
    final static String eyeDisorders = "eyeDisorders";
    final static String gastrointestinalDisorders = "gastrointestinalDisorders";
    final static String geneticDisorders = "geneticDisorders";
    final static String gynecologicDisorders = "gynecologicDisorders";
    final static String hematologicDisorders = "hematologicDisorders";
    final static String hepatobiliaryDisorders = "hepatobiliaryDisorders";
    final static String immuneDisorders = "immuneDisorders";
    final static String infections = "infections";
    final static String metabolicDisorders = "metabolicDisorders";
    final static String musculoDisorders = "musculoDisorders";
    final static String neoPlasms = "neoPlasms";
    final static String neurologicDisorders = "neurologicDisorders";
    final static String nutritionalDisorders = "nutritionalDisorders";
    final static String noseDisorders = "noseDisorders";
    final static String pediatricDisorders = "pediatricDisorders";
    final static String perinatalDisorders = "perinatalDisorders";
    final static String psychiatricDisorders = "psychiatricDisorders";
    final static String renalDisorders = "renalDisorders";
    final static String respiratoryDisorders = "respiratoryDisorders";
    final static String sexualDisorders = "sexualDisorders";
    final static String skeletalDisorders = "skeletalDisorders";
    final static String skinDisorders = "skinDisorders";
    final static String throatDisorders = "throatDisorders";
    final static String traumas = "traumas";
    final static String urologicDisorders = "urologicDisorders";
    final static String vascularDisorders = "vascularDisorders";

  // adhoc sets:
    final static String respiratoryTractInfections = "respiratoryTractInfections";
    final static String lifeThreateningDisorders = "lifeThreateningDisorders";

  // external causes
    final static String airPollution = "air pollution";
    final static String airwayIrritants = "airway irritants";
    final static String alcoholAbuse = "alcohol abuse";
    final static String allergens = "allergens";
    final static String anestheticsUse = "anesthetics use";
    final static String animalDander = "animal dander";
    final static String antigenExposure = "antigen exposure";
    final static String aromaticHydrocarbonsExposure = "aromatic hydrocarbons exposure";
    final static String asbestosExposure = "asbestos exposure";
    final static String aspirationContamination = "aspiration contamination";
    // due to vomitted material that entered the trachea/ lungs::
    final static String aspirationGastricContents = 
                       "aspiration gastric contents";
    final static String aspirinToxicity = "aspirin toxicity";
    final static String aspirinUse = "aspirin use";
    final static String benzopyreneExposure = "benzopyrene exposure";
    final static String berylliumInhalation = "beryllium inhalation";
    final static String berylliumSkinAbsorption = "beryllium skin absorption";
    final static String bloodTransfusion = "blood transfusion";
    final static String blowToTheHead = "blow to the head";
    final static String chemicalInhalation = "chemical inhalation";
    final static String chemicals = "chemicals";
    final static String chestTrauma = "chest trauma";
    final static String childbirth = "childbirth";
    final static String cigaretteSmoking = "cigarette smoking";
    final static String coalDustInhalation = "coal dust inhalation";
    final static String congenital = "congenital";
    final static String constitutional = "constitutional"; // idiopathic
    final static String contactWithElectricalPower =
                       "contact with electrical power";
    final static String coughing = "coughing";
    final static String dietHighFat = "diet high fat";
    final static String dietLowFat = "diet low fat";
    final static String dietPoor = "diet poor";
    final static String drugOverdose = "drug overdose";
    final static String electrical = "electrical";
    final static String excessiveCooking = "excessive cooking";
    final static String excessiveIVFluids = "excessive IV fluids";
    final static String extremeHumidity = "extreme humidity";
    final static String extremeTemperature = "extreme temperature";
    final static String firstPregnancyLate = "first pregnancy late";
    final static String foodAllergies = "food allergies";
    final static String foodSulfites = "food sulfites";
    final static String friction = "friction";
    final static String fungi = "fungi";
    final static String genetic = "genetic";
    final static String h5n1BirdFluVirus = "h5n1 bird flu virus";
    final static String headTrauma = "head trauma";
    final static String highAltitude = "high altitude";
    final static String houseDustAndMold = "house dust and mold";
    final static String hypnoticsUse = "hypnotics use";
    final static String hydrocarbonIngestion = "hydrocarbon ingestion";
    final static String industrialPollutantsExposure =
                       "industrial pollutants exposure";
    final static String infection = "infection";
  // final static String inhalationCorrosiveGas = "inhalation corrosive gas";
    final static String inhalationOfToxicAgents = "inhalation of toxic agents";
    final static String injury = "injury";
    final static String itchMite = "itch mite";
    final static String kapokAndFeatherPillows = "kapok and feather pillows";
    final static String lackOfCalciumInDiet = "lack of calcium in diet";
    final static String legionellaPneumophiliaBacillus =
                       "legionella pneumophilia bacillus";
    final static String lice = "lice";
    final static String lifeStyle = "life style";
    final static String longTermImmobility = "long term immobility";
    final static String lungTissueLossDueToSurgery = 
                       "lung tissue loss due to surgery";
    final static String menopauseLate = "menopause late";
    final static String mensesEarly = "menses early";
    final static String menstrualCycleLong = "menstrual cycle long";
    final static String multiplePartners = "multiple partners";
    final static String multiplePregnancies = "multiple pregnancies";
    final static String narcoticsMisuse = "narcotics misuse";
    final static String nearDrowning = "near drowning";
    final static String neverPregnant = "never pregnant";
    final static String nulliparity = "nulliparity";
    final static String oralContraceptiveUse = "oral contraceptive use";
    final static String oxygenMisuse = "oxygen misuse";
    final static String oxygenToxicity = "oxygen toxicity";
    final static String paraquatIngestion = "paraquat ingestion";
    final static String physicalProblem = "physical problem";
    final static String pollen = "pollen";
    final static String psychologicalProblem = "psychological problem";
    final static String radiation = "radiation";
    final static String regularAsbestosExposure = "regular asbestos exposure";
    final static String renalObstruction = "renal obstruction";
    final static String sedativeMisuse = "sedative misuse";
    final static String sedativesUse = "sedatives use";
    final static String sedentaryLifestyle = "sedentary lifestyle";
    final static String several = "several"; // see sub diseases or the vector
    final static String silicaExposure = "silica exposure";
    final static String smoking = "smoking";
    final static String smokeInhalation = "smoke inhalation";
    final static String sodiumExcess = "sodium excess";
    final static String spicyFoods = "spicy foods";
    final static String strangulation = "strangulation";
    final static String stress = "stress";
    final static String suffocation = "suffocation";
    final static String sunLight = "sun light";
    final static String talcExposure = "talc exposure";
    final static String thermal = "thermal";
    final static String tickBiteE = "tick bite";
    final static String tightChessBandage = "tight chess bandage";
    final static String tobaccoUse = "tobacco use";
    final static String tranquilizerMisuse = "tranquilizer misuse"; 
    final static String trauma = "trauma";
    final static String unknown = "unknown";
    final static String uterusPolypsHistory = "uterus polyps history";
    final static String vinylChlorideExposure = "vinyl chloride exposure";
    final static String vitaminBDeficiency = "vitamin B deficiency";
    final static String youngAgeIntercourse = "young age intercourse";

  // infections by organism
    final static String adenoVirusInfection = "adeno virus infection";
    final static String anthracisBacterialInfection = "anthracis bacterial infection";
    final static String bacterialInfection = "bacterial infection";
    final static String borreliaBurgdorferiSpirochete = "borrelia burgdorferi spirochete";
    final static String candidaAlbicansInfection =
                       "candida albicans infection";
    final static String candidaInfection = "candida infection";
    final static String chlamydialInfectionExternal = "chlamydial infection";
    final static String chronicRespiratoryInfections = 
                       "chronic respiratory infections";
    final static String clostridiumBotulinumInfection = 
                       "clostridium botulinum infection";
    final static String clostridiumPerfringensInfection =
          "clostridium perfringens infection";
    final static String coronavirusInfection = "coronavirus infection";
    final static String diphteriaBacterialInfection = 
          "diphteria bacterial infection";
    final static String enterobacterInfection = "enterobacter infection";
    final static String epsteinBarrVirus = "epstein barr virus";
    final static String escherichiaColiInfection = "escherichia coli infection";
    final static String gardnerellaInfection = "gardnerella infection";
    final static String gonorrheaInfection = "gonorrhea infection";
    final static String haemophilusDucreyiInfection = "haemophilus ducreyi infection";
    final static String haemophilusInfluenzaBInfection = 
          "haemophilus influenza B infection";
    final static String helicobacterPyloriInfection = "helicobacter pylori infection";
    final static String herpesSimplexVirus = "herpes simplex virus";
    final static String herpesvirusVaricella = "herpesvirus varicella";
    final static String HIVInfection = "HIV infection";
    final static String influenzaVirusInfection = "influenza virus infection";
    final static String klebsiellaInfection = "klebsiella infection";
    final static String measlesVirusInfection = "measles virusInfection";
    final static String myxovirusInfluenzaeInfection = "myxovirus influenzae infection";
    final static String neisseriaMeningitidisInfection = "neisseria meningitidis infection";
    final static String papillomavirusInfection = "papillomavirus infection";
    final static String parainfluenzaVirusInfection = 
                       "parainfluenza virus infection";
    final static String pertussisBacterialInfection = 
                       "pertussis bacterial infection";
    final static String pneumococciInfection = "pneumococci infection";
    final static String pneumocystisCariniiInfection =
                       "pneumocystis carinii infection";
    final static String poliovirus = "poliovirus";
    final static String proteusInfection = "proteus infection";
    final static String protozoanInfection = "protozoan infection";
    final static String pseudomonasInfection = "pseudomonas infection";
    final static String respiratoryCytomegaloVirusInfection =
                       "respiratory cytomegalo virus infection";
    final static String respiratorySyncytialVirusInfection = 
                       "respiratory syncytial virus infection";
    final static String spirocheteTreponemaPallidumInfection =
                       "spirochete treponema pallidum infection";
    final static String staphylococcusInfection = "staphylococcus infection";
    final static String streptococcusInfection =
                       "streptococcus infection";
    final static String syncytialVirusInfection =
                       "syncytial virus infection";
    final static String tetanusInfection = "tetanus infection";
    final static String toxoplasmaGondiiInfection = "toxoplasma gondii infection";
    final static String trichomonasInfection = "trichomonas infection";
    final static String upperAirwayInfection = "upper airway infection";
    final static String virusInfection = "virus infection";


  // ===================================================================

  // temperature
    final static int fever = 101;
    final static int highFever = 103;
    final static int lowGradeFever = 100;
    final static int veryHighFever = 105;

  // symptoms generic
    final static String abdomenBloating = "abdomenBloating";
    final static String abdomenCramping = "abdomenCramping";
    final static String abdomenDistension = "abdomenDistension";
    final static String abdomenPain = "abdomenPain";
    final static String abdomenPainLowerLeftSide = "abdomenPainLowerLeftSide";
    final static String abdomenPainLowerRightSide = "abdomenPainLowerRightSide";
    final static String abdomenPainLowerSide = "abdomenPainLowerSide";
    final static String abdomenPainSuddenSevere = "abdomenPainSuddenSevere";
    final static String abdomenPainUpperRightSide = "abdomenPainUpperRightSide";
    final static String abdomenPainUpperSide = "abdomenPainUpperSide";
    final static String abdomenRigidity = "abdomenRigidity";
    final static String abdomenTenderness = "abdomenTenderness";
    final static String abortionSpontaneous = "abortionSpontaneous";
    final static String anorexia = "anorexia";
    final static String appetiteIncrease = "appetiteIncrease";
    final static String appetiteLoss = "appetiteLoss";
    final static String armWeakness = "armWeakness";
    final static String ataxia = "ataxia";
    final static String backArched = "backArched";
    final static String backPain = "backPain";
    final static String backStiff = "backStiff";
    final static String bleedingAbnormal = "bleedingAbnormal";
    final static String bleedingFromMouth = "bleedingFromMouth";
    final static String bleedingFromNose = "bleedingFromNose";
    final static String bleedingFromRectum = "bleedingFromRectum";
    final static String bleedingFromVagina = "bleedingFromVagina";
    final static String bleedingFromVaginaAbnormal = "bleedingFromVaginaAbnormal";
    final static String bleedingFromVaginaProfuse = "bleedingFromVaginaProfuse";
    final static String bleedingFromVaginaSlight = "bleedingFromVaginaSlight";
    final static String bleedingGestation2ndHalf = "bleedingGestation2ndHalf";
    final static String bleedingProlonged = "bleedingProlonged";
    final static String bleedingSkull = "bleedingSkull";
    final static String bleedingSpontaneously = "bleedingSpontaneously";
    final static String bloating = "bloating";
    final static String BMIover30 = "BMIover30";
    final static String breastHard = "breastHard";
    final static String breastSwelling = "breastSwelling";
    final static String breastTenderness = "breastTenderness";
    final static String breastWarm = "breastWarm";
    final static String breathAcetone = "breathAcetone";
    final static String breathFruity = "breathFruity";
    final static String breathStinking = "breathStinking";
    final static String burping = "burping";
    final static String buttockPain = "buttockPain";
    final static String cachexia = "cachexia";
    final static String cerebrospinalFluidLeakage = "cerebrospinalFluidLeakage";
    final static String cheeksFlushed = "cheeksFlushed";
    final static String chills = "chills";
    final static String chillsSevere = "chillsSevere";
    final static String coolExtremities = "coolExtremities";
    final static String decerebratePosturing = "decerebratePosturing";
    final static String dehydration = "dehydration";
  //    final static String decreasedUrine = "decreasedUrine"; // see oliguria
    final static String discoloration = "discoloration";
    final static String edema = "edema";
    final static String edemaPeripheral = "edemaPeripheral";
    final static String emaciation = "emaciation";
    final static String excited = "excited";
    final static String fainting = "fainting";
    final static String fatigue = "fatigue"; 
    final static String fatigueProlonged = "fatigueProlonged";
    final static String feedingDifficulties = "feedingDifficulties";
    final static String feelingCold = "feelingCold";
    final static String feetCold= "feetCold";
    final static String feetNumbness = "feetNumbness";
    final static String feetPain = "feetPain";
    final static String feverSym = "feverSym";
    final static String feverIntermittent = "feverIntermittent";
    final static String feverRapidOnset = "feverRapidOnset";
    final static String fingerNailsBlue = "fingerNailsBlue";
    final static String fingersNumbness = "fingersNumbness";
    final static String fingersTingling = "fingersTingling";
    final static String flankPain = "flankPain";
    // final static String foulSmellingDischarge = "foulSmellingDischarge";
    final static String giddiness = "giddiness";
    final static String groinPain = "groinPain";
    final static String groinStiffness = "groinStiffness";
    final static String groinSwelling = "groinSwelling";
    final static String growthRapid = "growthRapid";
    final static String gumsBleeding = "gumsBleeding";
    final static String gumPockets = "gumPockets";
    final static String gumsSwollen = "gumsSwollen";
    final static String handBurning = "handBurning";
    final static String handNumbness = "handNumbness";
    final static String handPain = "handPain";
    final static String handCold= "handCold";
    final static String handTingling = "handTingling";
    final static String handWeak = "handWeak";
    final static String headache = "headache";
    final static String headacheConstant = "headacheConstant";
    final static String headacheFrontal = "headacheFrontal";
    final static String headacheSevere = "headacheSevere";
    final static String headSwollen = "headSwollen";
    final static String heightLoss = "heightLoss";
    final static String hemiparesis = "hemiparesis";
    final static String hemoptysis = "hemoptysis";
    final static String hemorrhage = "hemorrhage";
    final static String hiccups = "hiccups";
    final static String hungerExcessive = "hungerExcessive";
    final static String hydrophobia = "hydrophobia";
    final static String hyperesthesia = "hyperesthesia";
    final static String hypothermia = "hypothermia";
    final static String infectionSiteCrepitation = "infectionSiteCrepitation";
    final static String infertilityFemaleSymptom = "infertilityFemaleSymptom";
    final static String infertilityMaleSymptom = "infertilityMaleSymptom";
    final static String jaundice = "jaundice";
    final static String lactationAbnormal = "lactationAbnormal";
    // final static String lassitude = "lassitude";
    final static String legWeakness = "legWeakness";
    final static String limbsBurning = "limbsBurning";
    final static String limbsNumbness = "limbsNumbness";
    final static String limbsTingling = "limbsTingling";
    final static String limbsPinsAndNeedles = "limbsPinsAndNeedles";
    final static String limbsWeak = "limbsWeak";
    final static String lipsBlue = "lipsBlue";
    final static String lipsSwollen = "lipsSwollen";
    final static String lossOfBalance = "lossOfBalance";
    final static String lossOfCoordination = "lossOfCoordination";
    final static String lowBackPain = "lowBackPain";
    final static String lumbarPain = "lumbarPain";
    final static String malaise = "malaise";
    final static String melena = "melena";
    final static String motorDysfunction = "motorDysfunction";
    final static String mouthDry = "mouthDry";
    final static String mouthItches = "mouthItches";
    final static String mouthNumbness = "mouthNumbness";
    final static String mouthPain = "mouthPain";
    final static String mouthPatchWhite = "mouthPatchWhite";
    final static String mouthPatchYellow = "mouthPatchYellow";
    final static String mouthSore = "mouthSore";
    final static String mouthSwollen = "mouthSwollen";
    final static String mouthTasteMetallic = "mouthTasteMetallic";
    final static String mouthTingling = "mouthTingling";
    final static String mouthUlcers = "mouthUlcers";
    final static String movementsJerky = "movementsJerky";
    final static String mucousMembranesDry = "mucousMembranesDry";
    final static String nailBedRed = "nailBedRed";
    final static String nailBedSwollen = "nailBedSwollen";
    final static String nailBrittle = "nailBrittle";
    final static String neckStiff = "neckStiff";
    final static String neckEdema = "neckEdema";
    final static String necrosis = "necrosis";
    final static String nervePain = "nervePain";
    final static String noiseSensitivity = "noiseSensitivity";
    final static String noseItches = "noseItches";
    final static String nuchalRigidity = "nuchalRigidity";
    final static String numbness = "numbness";
    final static String opisthotonos = "opisthotonos";
    final static String obstipation = "obstipation";
    final static String overweight = "overweight";
    final static String pain = "pain";
    final static String painBurning = "painBurning";
    final static String painDeep = "painDeep";
    final static String painGnawing = "painGnawing";
    final static String painSevere = "painSevere";
    final static String painSharp = "painSharp";
    final static String painStabbing = "painStabbing";
    final static String paralysis = "paralysis";
    final static String paralysisTransient = "paralysisTransient";
    final static String prostration = "prostration";
    final static String pubisPain = "pubisPain";
    final static String reboundTenderness = "reboundTenderness";
    final static String rigidity = "rigidity";
    final static String salivation = "salivation";
    final static String seizure = "seizure";
    final static String severeMalaise = "severeMalaise";
    final static String sexualDysfunction = "sexualDysfunction";
    final static String shaking = "shaking";
    final static String sinusPain = "sinusPain";
    final static String sinusSwelling = "sinusSwelling";
    final static String somnolence = "somnolence";
    final static String spineStiff = "spineStiff";
    // final static String steatorrhea = "steatorrhea"; // smelly stool
    final static String stoolBlack = "stoolBlack";
    final static String stoolBloody = "stoolBloody";
    final static String stoolBrightRedBloody = "stoolBrightRedBloody";
    final static String stoolClayColored = "stoolClayColored";
    final static String stoolFrequent = "stoolFrequent";
    final static String stoolGreasy = "stoolGreasy";
    final static String stoolMalodorous = "stoolMalodorous";
    final static String stoolThinShaped = "stoolThinShaped";
    final static String stoolTarry = "stoolTarry";
    final static String stoolWatery = "stoolWatery";
    final static String substernalPain = "substernalPain";
    final static String teethLoose = "teethLoose";
    final static String teethSore = "teethSore";
    final static String temperatureSwingsSevere = "temperatureSwingsSevere";
    final static String tendonReflexDecreased = "tendonReflexDecreased";
    final static String thirst = "thirst";
    final static String thirstExcessive = "thirstExcessive";
    final static String throatConstriction = "throatConstriction";
    final static String throatItches = "throatItches";
    final static String throatScale = "throatScale";
    final static String tingling = "tingling";
    final static String toesNumbness = "toesNumbness";
    final static String toesTingling = "toessTingling";
    final static String trembling = "trembling";
    final static String tremors = "tremors";
    // final static String tremulousness = "tremulousness";
    final static String twitching = "twitching";
    final static String voiceDeepened = "voiceDeepened";
    final static String vomitBile = "vomitBile";
    final static String vomitBlack = "vomitBlack";
    final static String vomitBloody = "vomitBloody";
    final static String vomiting = "vomiting";
    final static String weakness = "weakness";
    final static String weightGain = "weightGain";
    final static String weightGainExcessive = "weightGainExcessive";
    final static String weightLoss = "weightLoss";
    final static String whoopInhalation = "whoopInhalation";
    final static String woundPainful = "woundPainful";
    final static String yawning = "yawning";

  // symptoms cardiovascular system
  //    final static String anemia = "anemia"; // is a disease ...
    final static String armPitPain = "armPitPain";
    final static String arrhythmia = "arrhythmia";
    final static String bradycardia = "bradycardia";
    final static String breastBonePain = "breastBonePain";
    final static String chestPain = "chestPain";
    final static String developmentSlow = "developmentSlow";
    final static String diastolicGallop = "diastolicGallop";
    final static String heartPain = "heartPain";
    final static String hypotension = "hypotension";
    final static String jawPain = "jawPain";
    final static String murmurLoud = "murmurLoud";
    final static String neckLymphNodeEnlarged = "neckLymphNodeEnlarged";
    final static String neckPain = "neckPain";
    final static String neckSpasm = "neckSpasm";
    final static String neckVeinsElevated = "neckVeinsElevated";
    final static String palpitations = "palpitations";
    final static String phlebitis = "phlebitis";
    final static String pulseAbsent = "pulseAbsent";
    final static String pulseDelay = "pulseDelay";
    final static String pulseFullBounding = "pulseFullBounding";
    final static String pulsePressureNarrows = "pulsePressureNarrows";
    final static String pulseRapid = "pulseRapid";
    final static String pulseThready = "pulseThready";
    final static String pulseWeak = "pulseWeak";
    final static String pulsusAlternans = "pulsusAlternans";
    final static String shoulderPain = "shoulderPain";
    final static String syncope = "syncope";
    final static String tachycardia = "tachycardia";
    final static String ventricularFibrillation = "ventricularFibrillation";

  // symptoms arms system
    final static String armPain = "armPain";

  // symptoms ear system
    final static String earache = "earache";
    final static String earBlockageFeeling = "earBlockageFeeling";
    final static String hearingLoss = "hearingLoss";
    final static String tinnitus = "tinnitus";

  // symptoms endocrine system
    final static String buffaloHump = "buffaloHump";
    final static String exophthalmos = "exophthalmos";
    final static String goiter = "goiter";
    final static String hirsutism = "hirsutism";
    final static String moonFace = "moonFace";
    final static String polydipsia = "polydipsia";

  // symptoms eye system
    // final static String anteriorUveitis = "anteriorUveitis"; is a disease
    final static String cataract = "cataract";
    final static String corneaCloudy = "corneaCloudy";
    final static String corneaOpaque = "corneaOpaque";
    final static String diplopia = "diplopia";
    final static String eyeDryness = "eyeDryness";
    final static String eyeExudate = "eyeExudate";
    final static String eyelidHyperemia = "eyelidHyperemia";
    final static String eyelidRed = "eyelidRed";
    final static String eyelidSwollen = "eyelidSwollen";
    final static String eyePain = "eyePain";
    final static String eyePainMild = "eyePainMild";
    final static String eyePressure = "eyePressure";
    final static String eyeRedness = "eyeRedness";
    final static String lacrimation = "lacrimation";
    final static String nystagmus = "nystagmus";
    final static String ocularDisturbance = "ocularDisturbance";
    final static String orbitPain = "orbitPain";
    final static String papilledema = "papilledema";
    final static String photophobia = "photophobia";
    final static String ptosis = "ptosis";
    final static String pupilChanges = "pupilChanges";
    final static String pupilDilation = "pupilDilation";
    final static String pupilNarrowing = "pupilNarrowing";
    final static String pupilNonReactive = "pupilNonReactive";
    final static String pupilResponseUnequal = "pupilResponseUnequal";
    final static String retinaHemorrhage = "retinaHemorrhage";
    final static String retinaInflammation = "retinaInflammation";
    final static String seeingHalosAroundLights = "seeingHalosAroundLights";
    final static String tearing = "tearing";
    final static String visionDefect = "visionDefect";
    final static String visionLoss = "visionLoss";
    final static String visionNightLoss = "visionNightLoss";
    final static String visionPeripheralLoss = "visionPeripheralLoss";

  // symptoms gastro-intestines system
    final static String belching = "belching";
    final static String bowelActivityDecreased = "bowelActivityDecreased";
    final static String chewingPainful = "chewingPainful";
    final static String constipation = "constipation";
    final static String diarrhea = "diarrhea";
    final static String diarrheaBloody = "diarrheaBloody";
    final static String diarrheaNocturnal = "diarrheaNocturnal";
    final static String diarrheaWatery = "diarrheaWatery";
    final static String dysphagia = "dysphagia";
    final static String dyspepsia = "dyspepsia";  
    final static String gas = "gas";
    final static String gastricResidueIncreased = "gastricResidueIncreased";
    final static String gastroparesis = "gastroparesis";
    // final static String indigestion = "indigestion";
    final static String rectumBloodyDischarge = "rectumBloodyDischarge";
    final static String rectumBurning = "rectumBurning";
    final static String rectumItching = "rectumItching";
    final static String regurgitation = "regurgitation";
    final static String swallowingPainful = "swallowingPainful";
    final static String uremicBreath = "uremicBreath";

  // symptoms gland system
    final static String parotidGlandsSwollen = "parotidGlandsSwollen";

  // symptoms gynecologic system & male symptoms
    final static String atrophicVulvitis = "atrophicVulvitis";
    final static String bleedingThirdTrimester = "bleedingThirdTrimester";
    final static String breastSizeDecrease = "breastSizeDecrease";
    final static String cervixDilation = "cervixDilation";
    final static String cervixEdematous = "cervixEdematous";
    final static String cervixErosion = "cervixErosion";
    final static String cervixRed = "cervixRed";
    final static String cervixTenderness = "cervixTenderness";
    final static String contractionsAfterChildbirth = 
                       "contractionsAfterChildbirth";
    final static String deepThrustDyspareunia = "deepThrustDyspareunia";
    final static String dysuria = "dysuria";
    final static String fetalHeartTonesAbsent = "fetalHeartTonesAbsent";
    final static String hemospermia = "hemospermia";
    final static String hotFlash = "hotFlash";
    final static String incontinence = "incontinence";
    final static String lochia = "lochia";
    final static String lochiaHeavy = "lochiaHeavy";
    final static String meatalTenderness = "meatalTenderness";
    final static String menstruationFlowDecrease = "menstruationFlowDecrease";
    final static String menstruationAbsence = "menstruationAbsence";
    final static String menstruationDeficient = "menstruationDeficient";
    final static String menstruationInfrequent = "menstruationInfrequent";
    final static String menstruationIrregular = "menstruationIrregular";
    final static String menstruationPainful = "menstruationPainful";
    final static String menstruationProfuse = "menstruationProfuse";
    final static String menstruationTooFrequent = "menstruationTooFrequent";
    final static String pelvisDiscomfort = "pelvisDiscomfort";
    final static String pelvisRelaxation = "pelvisRelaxation";
    final static String pelvisPain = "pelvisPain";
    final static String pyuria = "pyuria";
    // final static String redEdematousMembranes = "redEdematousMembranes";
    final static String spotting = "spotting";
    final static String uterusBleeding = "uterusBleeding";
    final static String uterusBleedingAbnormal = "uterusBleedingAbnormal";
    final static String uterusContractions = "uterusContractions";
    final static String uterusEnlarged = "uterusEnlarged";
    final static String uterusGrowsTooFast = "uterusGrowsTooFast";
    final static String uterusIrritation = "uterusIrritation";
    final static String uterusPain = "uterusPain";
    final static String uterusTender = "uterusTender";
    final static String urinaryBurning = "urinaryBurning";
    final static String urinaryFrequency = "urinaryFrequency";
    final static String urinaryHesitancy = "urinaryHesitancy";
    final static String urinaryStreamInterrupted = "urinaryStreamInterrupted";
    final static String urinaryStreamReduced = "urinaryStreamReduced";
    final static String urinaryUrgency = "urinaryUrgency";
    final static String urinationPainful = "urinationPainful";
    final static String urinationStartDifficult = "urinationStartDifficult";
    final static String urineCloudy = "urineCloudy";
    final static String urineDark = "urineDark";
    final static String urineDribbling = "urineDribbling";
    final static String urineRetention = "urineRetention";
    final static String vaginaBurning = "vaginaBurning";
    final static String vaginaDischarge = "vaginaDischarge";
    final static String vaginaDischargeBloody = "vaginaDischargeBloody";
    final static String vaginaDischargeBrown = "vaginaDischargeBrown";
    final static String vaginaDischargeFoulSmelling = "vaginaDischargeFoulSmelling";
    final static String vaginaDischargeFrothy = "vaginaDischargeFrothy";
    final static String vaginaDischargeGrayFoulFishySmelling =
                       "vaginaDischargeGrayFoulFishySmelling";
    final static String vaginaDischargePersistent = "vaginaDischargePersistent";
    final static String vaginaDischargePink = "vaginaDischargePink";
    final static String vaginaDischargeProfuse = "vaginaDischargeProfuse";
    final static String vaginaDischargePurulent = "vaginaDischargePurulent";
    final static String vaginaDischargeThickWhite = "vaginaDischargeThickWhite";
    final static String vaginaDischargeThinBubblyGreentingedMalodorous =
                       "vaginaDischargeThinBubblyGreentingedMalodorous";
    final static String vaginaDryness = "vaginaDryness";
    final static String vaginaItching = "vaginaItching";
    final static String vaginaMucosaAtrophy = "vaginaMucosaAtrophy";
    final static String vaginaPain = "vaginaPain";
    final static String vaginaRed = "vaginaRed";
    final static String vaginaSwollen = "vaginaSwollen";
    final static String vaginaTenderness = "vaginaTenderness";
    // final static String vaginitis = "vaginitis"; // is a disease, see vulvovaginitis
    final static String vulvaRedSwollen = "vulvaRedSwollen";

  // symptoms hematologic system
    final static String digitsClubbing = "digitsClubbing";
    final static String noseCyanosis = "noseCyanosis";

  // symptoms joints system
    final static String anklePain = "anklePain";
    final static String elbowPain = "elbowPain";
    final static String fingerJointDeformity = "fingerJointDeformity";
    final static String hipPain = "hipPain";
    final static String jointHot = "jointHot";
    final static String jointPain = "jointPain";
    final static String jointRedness = "jointRedness";
    final static String jointStiffen = "jointStiffen";
    final static String jointSwelling = "jointSwelling";
    final static String jointTender = "jointTender";
    final static String kneePain = "kneePain";
    final static String polyarthritis = "polyarthritis";

  // symptoms legs system
    final static String legCramps = "legCramps";
    final static String legEdema = "legEdema";
    final static String legPain = "legPain";
    final static String legStiff = "legStiff";
    // final static String legsStiff = "legsStiff";
    final static String waddle = "waddle";
    final static String walkingTrouble = "walkingTrouble";

  // symptoms liver system
    final static String liverEnlarged = "liverEnlarged";
    final static String liverPain = "liverPain";
    final static String liverTender = "liverTender";

  // symptoms lymph system
    final static String groinAdenitis = "groinAdenitis";
    final static String groinLymphNodeRuptured = "groinLymphNodeRuptured";
    final static String lymphadenitis = "lymphadenitis";
    final static String lymphadenopathy = "lymphadenopathy";
    final static String lymphNodePainful = "lymphNodePainful";
    // final static String lymphNodeSwollen = "lymphNodeSwollen";

  // symptoms mind
    final static String abstractThinkingImpaired = "abstractThinkingImpaired";
    final static String aggression = "aggression";
    final static String agitation = "agitation";
    final static String alertnessHigh = "alertnessHigh";
    final static String amnesia = "amnesia";
    final static String angry = "angry";
    final static String anxiety = "anxiety";
    final static String apathy = "apathy";
    final static String aphasia = "aphasia";
    final static String apprehension = "apprehension"; 
    final static String behaviorDisorganized = "behaviorDisorganized";
    final static String bingeEating = "bingeEating";
    final static String bodyImageDistorted = "bodyImageDistorted";
    final static String catatonic = "catatonic";
    final static String chokingFeeling = "chokingFeeling";
    final static String clumsy = "clumsy";
    final static String coldIntolerance = "coldIntolerance";
    final static String coma = "coma";
    final static String communicationImpaired = "communicationImpaired";
    final static String compulsiveActions = "compulsiveActions";
    final static String concentrationLoss = "concentrationLoss";
    final static String confusion = "confusion";
    final static String consciousnessDecreased = "consciousnessDecreased";
    final static String consciousnessLoss = "consciousnessLoss";
    final static String coordinationDetoriation = "coordinationDetoriation";
    final static String cryingSpell = "cryingSpell";
    final static String cryingSpellFrequent = "cryingSpellFrequent";
    final static String dailyActivityUninteresting = "dailyActivityUninteresting";
    final static String daydreaming = "daydreaming";
    final static String delirium = "delirium";
    final static String delusions = "delusions";
    final static String disorientation = "disorientation";
    final static String dizziness = "dizziness";
    final static String doomFeeling = "doomFeeling";
    final static String drowsiness = "drowsiness";
    final static String dysphasia = "dysphasia";
    final static String emotionPangs = "emotionPangs";
    final static String energyLoss = "energyLoss";
    final static String exacerbationOfMentalProblems = 
                       "exacerbationOfMentalProblems";
    final static String fallingSensation = "fallingSensation";
    final static String fearful = "fearful";
    final static String fidgeting = "fidgeting";
    final static String fitOfAnger = "fitOfAnger";
    final static String flashbacks = "flashbacks";
    final static String focussingDifficulty = "focussingDifficulty";
    final static String forgetfulness = "forgetfulness";
    final static String hallucinations = "hallucinations";
    final static String heatSensitivity = "heatSensitivity";
    final static String hostility = "hostility";
    final static String hyperactivity = "hyperactivity";
    final static String impulsive = "impulsive";
    final static String inattention = "inattention";
    final static String incoherence = "incoherence";
    final static String indecisive = "indecisive";
    final static String irritability = "irritability";
    final static String judgementImpaired = "judgementImpaired";
    final static String languageDetoriation = "languageDetoriation";
    final static String learningDifficulty = "learningDifficulty";
    final static String lethargy = "lethargy";
    final static String libidoLoss = "libidoLoss";
    final static String lightHeadedness = "lightHeadedness";
    final static String listlessness = "listlessness";
    final static String memoryDetoriation = "memoryDetoriation";
    final static String memoryRecentLoss = "memoryRecentLoss";
    final static String mentalDepression = "mentalDepression";
    final static String mentalInstability = "mentalInstability";
    final static String moodSad = "moodSad";
    final static String moodSwings = "moodSwings";
    final static String motivationLoss = "motivationLoss";
    final static String nervousness = "nervousness";
    final static String nightmares = "nightmares";
    final static String obsessiveThoughts = "obsessiveThoughts";
    final static String obtundation = "obtundation";
    final static String panicAttacks = "panicAttacks";
    final static String paranoia = "paranoia";
    final static String personalityChange = "personalityChange";
    final static String psychosis = "psychosis";
    final static String restlessness = "restlessness";
    final static String ritualistic = "ritualistic";
    final static String roleFunctioningDetoriation = "roleFunctioningDetoriation";
    final static String seeingTrouble = "seeingTrouble";
    final static String selfAwarenessHigh = "selfAwarenessHigh";
    final static String selfDoubt = "selfDoubt";
    final static String sensoryChanges = "sensoryChanges";
    final static String sleepDisturbed = "sleepDisturbed";
    final static String sluggishness = "sluggishness";
    final static String socialPerformanceFear = "socialPerformanceFear";
    final static String socialWithdrawal = "socialWithdrawal";
    final static String speechDifficulty = "speechDifficulty";
    final static String speechSlurred = "speechSlurred";
    final static String speechUnintelligible = "speechUnintelligible";
    final static String speechUnusual = "speechUnusual";
    final static String stupor = "stupor";
    final static String suicideThoughts = "suicideThoughts";
    final static String suspiciousness = "suspiciousness";
    final static String talkative = "talkative";
    final static String thinkingFuzzy = "thinkingFuzzy";
    final static String thoughtsDisturbing = "thoughtsDisturbing";
    final static String unhappy = "unhappy";
    final static String unrealityFeeling = "unrealityFeeling";
    final static String vertigo = "vertigo";
    final static String visionBlurred = "visionBlurred";
    // final static String visionDisturbance = "visionDisturbance";

  // symptoms mouth system
    final static String tonsilsExude = "tonsilsExude";
    final static String tonsilsSwollen = "tonsilsSwollen";

  // symptoms muscle & skeleton system
    final static String akinesia = "akinesia";
    final static String asterixis = "asterixis";
    final static String bonePain = "bonePain";
    final static String bunion = "bunion";
    final static String chewingDifficult = "chewingDifficult";
    final static String choking = "choking";
    final static String convulsions = "convulsions";
    final static String dysphonia = "dysphonia";
    final static String dysarthria = "dysarthria";
    final static String faceMovementsAbnormal = "faceMovementsAbnormal";
    final static String faceSpasm = "faceSpasm";
    final static String fingerBoneLesion = "fingerBoneLesion";
    final static String fingerSpasm = "fingerSpasm";
    final static String fingerSwelling = "fingerSwelling";
    final static String footSpasm = "footSpasm";
    final static String handSpasm = "handSpasm";
    final static String lipLowerHanging = "lipLowerHanging";
    final static String lockjaw = "lockjaw";
    final static String lordosis = "lordosis";
    // final static String muscleAches = "muscleAches";
    final static String muscleContractions = "muscleContractions";
    final static String muscleCramps = "muscleCramps";
    final static String muscleHypertonicity = "muscleHypertonicity";
    final static String muscleLoss = "muscleLoss";
    // final static String musclePain = "musclePain"; // see myalgia
    final static String muscleRigid = "muscleRigid";
    final static String muscleTender = "muscleTender";
    final static String muscleWeakness = "muscleWeakness";
    final static String myalgia = "myalgia"; //  musclePain
    final static String nasolabialFoldAbsent = "nasolabialFoldAbsent";
    final static String roundback = "roundback";
    final static String spasm = "spasm";
    // final static String speechDifficult = "speechDifficult";
    final static String spineDeformation = "spineDeformation";
    final static String stiffness = "stiffness";
    // final static String swallowingDifficult = "swallowingDifficult";
    final static String tetany = "tetany";
    final static String throatSpasm = "throatSpasm";

  // symptoms neoplasm
    final static String abdomenMassPalpable = "abdomenMassPalpable";
    final static String bladderPain = "bladderPain";
    final static String bladderPressure = "bladderPressure";
    final static String bleedingVulva = "bleedingVulva";
    final static String breastDischargeUnusual = "breastDischargeUnusual";
    final static String breastLump = "breastLump";
    final static String breastSizeChange = "breastSizeChange";
    final static String breastSkinAreaHot = "breastSkinAreaHot";
    final static String breastSkinDimpling = "breastSkinDimpling";
    final static String breastSkinEdema = "breastSkinEdema";
    final static String breastSkinThickening = "breastSkinThickening";
    final static String breastSkinUlceration = "breastSkinUlceration";
    final static String colonPain = "colonPain";
    final static String faceLesionPinkPapules = "faceLesionPinkPapules";
    final static String faceLesionTranslucentPapules = "faceLesionTranslucentPapules";
    final static String genitalLesionWhiteGrey = "genitalLesionWhiteGrey";
    final static String nippleAreaSkinScaly = "nippleAreaSkinScaly";
    final static String nippleBurning = "nippleBurning";
    final static String nippleErosion = "nippleErosion";
    final static String nippleItching = "nippleItching";
    final static String nippleRetraction = "nippleRetraction";
    final static String postcoitalBleeding = "postcoitalBleeding";
    final static String thyroidEnlargement = "thyroidEnlargement";
    final static String postcoitalPain = "postcoitalPain";
    final static String vaginaDischargeAmberColored = "vaginaDischargeAmberColored";
    final static String vaginaUlceratedLesion = "vaginaUlceratedLesion";
    final static String vulvaLesion = "vulvaLesion";
    final static String vulvaUlcer = "vulvaUlcer";
    final static String vulvaUlcerInfected = "vulvaUlcerInfected";

  // symptoms neurologic system
    final static String arthralgia = "arthralgia";
    // final static String earRinging = "earRinging";
    final static String faceBurningPain = "faceBurningPain";
    final static String faceNumbness = "faceNumbness";
    final static String faceSearingPain = "faceSearingPain";
    final static String faceTingling = "faceTingling";
    final static String intellectImpaired = "intellectImpaired";
    final static String tendonReflexesHyperactive = "tendonReflexesHyperactive";
    final static String mouthDroops = "mouthDroops";
    final static String palsy = "palsy";
    final static String palsyFace = "palsyFace";
    final static String reflexControlLoss = "reflexControlLoss";
    final static String reflexesDecreased = "reflexesDecreased";
    final static String reflexesHyperactive = "reflexesHyperactive";
    final static String skullDistension = "skullDistension";
    final static String tasteLoss = "tasteLoss";

  // symptoms nose system
    final static String noseDischarge = "noseDischarge";
    final static String noseWhitePatches = "noseWhitePatches";
    final static String rhinitis = "rhinitis";

  // symptoms renal & urologic system
    final static String anuria = "anuria";
    final static String bladderCramp = "bladderCramp";
    final static String bladderIrritability = "bladderIrritability";
    final static String hematuria = "hematuria";
    final static String oliguria = "oliguria";
    final static String polyuria = "polyuria";
    final static String postVoidingPain = "postVoidingPain";

  // symptoms respiratory system
    final static String airHunger = "airHunger";
    final static String anginaPain = "anginaPain";
    final static String apnea = "apnea";
    final static String barrelChest = "barrelChest";
    final static String bradypnea = "bradypnea";
    final static String breathingAsymmetric = "breathingAsymmetric";
    final static String breathingDifficult = "breathingDifficult";
    // final static String breathingShallow = "breathingShallow";
    final static String breathlessness = "breathlessness";
    final static String cervixAdenopathy = "cervixAdenopathy";
    final static String chestTightness = "chestTightness";
    final static String coryza = "coryza";
    final static String cough = "cough";
    final static String coughBark = "coughBark";
    final static String coughDry = "coughDry";
    final static String coughHacking = "coughHacking";
    final static String coughProductive = "coughProductive";
    final static String coughProductiveFoulSmelling = "coughProductiveFoulSmelling";
    final static String crackles = "crackles";
    final static String drooling = "drooling";
    final static String dyspnea = "dyspnea";
    final static String flaringNostrils = "flaringNostrils";
    final static String grunting = "grunting";
    final static String hoarseness = "hoarseness";
    final static String hyperventilation = "hyperventilation";
    final static String hypoventilation = "hypoventilation";
    final static String laughing = "laughing";
    final static String orthopnea = "orthopnea";
    final static String pleuriticChestPain = "pleuriticChestPain";
    final static String prolongedExpiration = "prolongedExpiration";
    final static String pulmonaryCongestion = "pulmonaryCongestion";
    final static String pursedLipBreathing = "pursedLipBreathing";
    final static String respirationDeep = "respirationDeep";
    final static String respirationDistress = "respirationDistress";
    final static String respirationKussmaul = "respirationKussmaul";
    final static String respirationLabored = "respirationLabored";
    final static String respirationParalysis = "respirationParalysis";
    // final static String respirationRapid = "respirationRapid";
    final static String respirationRetractive = "respirationRetractive";
    final static String respirationShallow = "respirationShallow";
    final static String respirationSporadic = "respirationSporadic";
    final static String retrosternalChestPain = "retrosternalChestPain";
    final static String rhonchus = "rhonchus";
    final static String sneezing = "sneezing";
    final static String sputumBlack = "sputumBlack";
    // final static String sputumBloody = "sputumBloody";   see hemoptysis
    final static String sputumFoulSmelling = "sputumFoulSmelling";
    final static String sputumFrothy = "sputumFrothy";
    final static String sputumGray = "sputumGray";
    final static String sputumMucoid = "sputumMucoid";
    final static String sputumMucopurulent = "sputumMucopurulent";
    final static String sputumProduction = "sputumProduction";
    final static String sputumPurulent = "sputumPurulent";
    final static String sputumYellowGreenThick = "sputumYellowGreenThick";
    final static String stabbingChestPain = "stabbingChestPain";
    final static String stridor = "stridor";
    final static String tachypnea = "tachypnea";
    final static String thickMucus = "thickMucus";
    final static String throatDry = "throatDry";
    final static String throatRed = "throatRed";
    final static String throatSore = "throatSore";
    final static String wheezing = "wheezing";

  // symptoms sexual
    final static String adultHairPattern = "adultHairPattern";
    final static String anusChancre = "anusChancre";
    // final static String anusDischargeBloody = "anusDischargeBloody";
    final static String anusDischargeMucopurulent = "anusDischargeMucopurulent";
    final static String anusLesion = "anusLesion";
    final static String bodyHairSparse = "bodyHairSparse";
    final static String boneAgeImmature = "boneAgeImmature";
    final static String boneDevelopmentEarly = "boneDevelopmentEarly";
    final static String boneGumma = "boneGumma";
    final static String breastDevelopment = "breastDevelopment";
    final static String breastPapule = "breastPapule";
    final static String cervixDischargeGreenYellow = "cervixDischargeGreenYellow";
    final static String cervixPapule = "cervixPapule";
    final static String cervixVesicle = "cervixVesicle";
    final static String clitorisEnlarged = "clitorisEnlarged";
    final static String ejaculationPainful = "ejaculationPainful";
    final static String erectionFailure = "erectionFailure";
    final static String erectionFrequent = "erectionFrequent";
    final static String erythemaUrethraMale = "erythemaUrethraMale";
    final static String eyelidChancre = "eyelidChancre";
    final static String eyelidDroop = "eyelidDroop";
    final static String faceEdema = "faceEdema";
    final static String faceHair = "faceHair";
    final static String faceHairSparse = "faceHairSparse";
    final static String fingerChancre = "fingerChancre";
    final static String foreSkinVesicle = "foreSkinVesicle";
    final static String genitaliaExposureToStrangers = "genitaliaExposureToStrangers";
    final static String groinPapule = "groinPapule";
    final static String intercourseDiscomfort = "intercourseDiscomfort";
    final static String labiaVesicle = "labiaVesicle";
    final static String lipChancre = "lipChancre";
    final static String lipPapule = "lipPapule";
    final static String menarcheEarly = "menarcheEarly";
    final static String mouthLesion = "mouthLesion";
    final static String mouthLesionWhiteGrey = "mouthLesionWhiteGrey";
    final static String mucousMembraneGumma = "mucousMembraneGumma";
    final static String muscleDevelopmentEarly = "muscleDevelopmentEarly";
    final static String muscleUnderdeveloped = "muscleUnderdeveloped";
    final static String navelPapule = "navelPapule";
    final static String noseSeptumPerforation = "noseSeptumPerforation";
    final static String nippleChancre = "nippleChancre";
    final static String nocturia = "nocturia";
    final static String organGumma = "organGumma";
    final static String orgasmUnachievable = "orgasmUnachievable";
    final static String palatePerforation = "palatePerforation";
    final static String penisEnlarged = "penisEnlarged";
    final static String penisGlansVesicle = "penisGlansVesicle";
    final static String penisGrowth = "penisGrowth";
    final static String penisInfantile = "penisInfantile";
    final static String penisPapule = "penisPapule";
    final static String penisVesicle = "penisVesicle";
    final static String prematureEjaculationSymptom = "prematureEjaculationSymptom";
    final static String pubertyDelayed = "pubertyDelayed";
    final static String pubisHairDevelopment = "pubisHairDevelopment";
    final static String pubisHairEarly = "pubisHairEarly";
    final static String scrotumEnlarged = "scrotumEnlarged";
    final static String scrotumSwellingPainful = "scrotumSwellingPainful";
    final static String sexChangeDesire = "sexChangeDesire";
    final static String sexDriveLow = "sexDriveLow";
    final static String sexualArousalFromChildren = "sexualArousalFromChildren";
    final static String sexualArousalFromCrossDressing =
                       "sexualArousalFromCrossDressing";
    final static String sexualArousalFromInanimateObjects =
                       "sexualArousalFromInanimateObjects";
    final static String sexualArousalFromInflictingRealOrFantasizedPain =
                       "sexualArousalFromInflictingRealOrFantasizedPain";
    final static String sexualArousalFromObtainingRealOrFantasizedPain =
                       "sexualArousalFromObtainingRealOrFantasizedPain";
    final static String sexualArousalFromRubbingANonconsentingPerson =
                       "sexualArousalFromRubbingANonconsentingPerson";
    final static String sexualArousalFromWatchingSexualSituations =
                       "sexualArousalFromWatchingSexualSituations";
    final static String sexualDesireAbsent = "sexualDesireAbsent";
    final static String sexualStimulationIgnored = "sexualStimulationIgnored";
    final static String tenesmus = "tenesmus";
    final static String testicleNodule = "testicleNodule";
    final static String testiclePain = "testiclePain";
    final static String testiclesEnlarged = "testiclesEnlarged";
    final static String testicleSizeDiffer = "testicleSizeDiffer";
    final static String testicleSoft = "testicleSoft";
    final static String thighPapule = "thighPapule";
    final static String tongueChancre = "tongueChancre";
    final static String tonguePapule = "tonguePapule";
    final static String tonsilChancre = "tonsilChancre";
    final static String urethraFemaleDischargePurulent = "urethraFemaleDischargePurulent";
    final static String urethraFemaleItching = "urethraFemaleItching";
    final static String urethraFemaleRed = "urethraFemaleRed";
    final static String urethraFemaleSwollen = "urethraFemaleSwollen";
    final static String urethraMaleDischarge = "urethraMaleDischarge";
    final static String urethraMaleDischargePurulent = "urethraMaleDischargePurulent";
    final static String vaginaMuscleSpasm = "vaginaMuscleSpasm";
    final static String vaginaPapule = "vaginaPapule";
    final static String vaginaVesicle = "vaginaVesicle";
    final static String vulvaBurning = "vulvaBurning";
    final static String vulvaItching = "vulvaItching";
    final static String vulvaPain = "vulvaPain";
    final static String vulvaPapule = "vulvaPapule";
    final static String vulvaVesicle = "vulvaVesicle";

  // symptoms skin
    final static String acne = "acne";
    final static String beardSkinLesions = "beardSkinLesions";
    final static String biteMarksRed = "biteMarksRed";
    final static String bleb = "bleb";
    final static String blister = "blister";
    final static String blisterSmallItch = "blisterSmallItch";
    final static String blisterSmallOoze = "blisterSmallOoze";
    final static String blisterSmallScale = "blisterSmallScale";
    final static String bloodyWoundDischarge = "bloodyWoundDischarge";
    final static String blotchesRed = "blotchesRed";
    final static String bruising = "bruising";
    final static String bumpItchy = "bumpItchy";
    final static String burningSensation = "burningSensation";
    final static String butterflyRash = "butterflyRash";
    final static String cervixWarts = "cervixWarts";
    final static String cyanosis = "cyanosis";
    final static String diaphoresis = "diaphoresis";
    final static String ecchymoses = "ecchymoses";
    final static String ecchymosesFace = "ecchymosesFace";
    final static String eczema = "eczema";
    final static String elbowLesion = "elbowLesion";
    final static String erythema = "erythema";
    final static String erythemaNodosum = "erythemaNodosum";
    final static String fingerLesion = "fingerLesion";
    final static String flushing = "flushing";
    final static String groinLesionItchy = "groinLesionItchy";
    final static String groinLesionRed = "groinLesionRed";
    final static String hairBroken = "hairBroken";
    final static String hairGrowthIncrease = "hairGrowthIncrease";
    final static String hairLoss = "hairLoss";
    final static String hairSmelly = "hairSmelly";
    final static String handNodule = "handNodule";
    final static String insectSting = "insectSting";
    final static String itches = "itches";
    final static String jointNodule = "jointNodule";
    final static String lipsPale = "lipsPale";
    final static String maculeEncrusted = "maculeEncrusted";
    final static String maculePustular = "maculePustular";
    final static String maculopapularEruption = "maculopapularEruption";
    final static String nailsPale = "nailsPale";
    final static String nightSweating = "nightSweating";
    final static String noseMucosalLesion = "noseMucosalLesion";
    final static String noseMucosaSwelling = "noseMucosaSwelling";
    final static String noseMucosaUlceration = "noseMucosaUlceration";
    final static String pallor = "pallor";
    final static String palmsPale = "palmsPale";
    final static String papuleRedSmall = "papuleRedSmall";
    final static String papuleRedWarm = "papuleRedWarm";
    final static String papuleUlcerated = "papuleUlcerated";
    final static String paresthesia = "paresthesia";
    final static String penisWarts = "penisWarts";
    final static String perineumWarts = "perineumWarts";
    final static String perspiration = "perspiration";
    final static String petechiae = "petechiae";
    final static String pruritus = "pruritus";
    final static String pubisHairLoss = "pubisHairLoss";
    final static String pubisSkinIrritation = "pubisSkinIrritation";
    final static String purpura = "purpura";
    final static String rash = "rash";
    final static String rashCreeping = "rashCreeping";
    final static String rashErupting = "rashErupting";
    final static String rashItchy = "rashItchy";
    final static String rashRed = "rashRed";
    final static String rashPapular = "rashPapular";
    final static String rashSandpapery = "rashSandpapery";
    final static String rashScaly = "rashScaly";
    final static String scab = "scab";
    final static String scalpNodule = "scalpNodule";
    final static String scalpWound = "scalpWound";
    // final static String skinBlue = "skinBlue"; // => cyanosis
    final static String skinBurnedLeatheryBlack = "skinBurnedLeatheryBlack";
    final static String skinBurnedLeatheryBrown = "skinBurnedLeatheryBrown";
    final static String skinBurnedPain = "skinBurnedPain";
    final static String skinBurnedLeatheryWhite = "skinBurnedLeatheryWhite";
    final static String skinBurning = "skinBurning";
    final static String skinClammy = "skinClammy";
    final static String skinCold = "skinCold";
    final static String skinDiscoloration = "skinDiscoloration";
    final static String skinDusky = "skinDusky";
    final static String skinDry = "skinDry";
    final static String skinElasticityLoss = "skinElasticityLoss";
    final static String skinFaceTight = "skinFaceTight";
    final static String skinFlushing = "skinFlushing";
    final static String skinGumma = "skinGumma";
    final static String skinHandsTight = "skinHandsTight";
    final static String skinInfection = "skinInfection";
    final static String skinJaundiced = "skinJaundiced";
    final static String skinLesionBackgroundBrownBlack = "skinLesionBackgroundBrownBlack";
    final static String skinLesionBlackberryLike = "skinLesionBlackberryLike";
    final static String skinLesionBlackNodules = "skinLesionBlackNodules";
    final static String skinLesionBlue = "skinLesionBlue";
    final static String skinLesionCoinShaped = "skinLesionCoinShaped";
    final static String skinLesionCrackedCrusty = "skinLesionCrackedCrusty";
    final static String skinLesionDryScaly = "skinLesionDryScaly";
    final static String skinLesionEnlarged = "skinLesionEnlarged";
    final static String skinLesionFoot = "skinLesionFoot";
    final static String skinLesionFreckelLike = "skinLesionFreckelLike";
    final static String skinLesionFuzzyBorder = "skinLesionFuzzyBorder";
    final static String skinLesionGreasy = "skinLesionGreasy";
    final static String skinLesionHand = "skinLesionHand";
    final static String skinLesionLightlyPigmented = "skinLesionLightlyPigmented";
    final static String skinLesionMacular = "skinLesionMacular";
    final static String skinLesionMoistCrusty = "skinLesionMoistCrusty";
    final static String skinLesionNodulesBleeding = "skinLesionNodulesBleeding";
    final static String skinLesionPinkWhite = "skinLesionPinkWhite";
    final static String skinLesionPlaqueLike = "skinLesionPlaqueLike";
    final static String skinLesionRedNodule = "skinLesionRedNodule";
    final static String skinLesionRedPapular = "skinLesionRedPapular";
    final static String skinLesionRedStreaked = "skinLesionRedStreaked";
    final static String skinLesionRedSwollenRaised = "skinLesionRedSwollenRaised";
    final static String skinLesionRedWeeping = "skinLesionRedWeeping";
    final static String skinLesionRedWhite = "skinLesionRedWhite";
    final static String skinLesionRingShaped = "skinLesionRingShaped";
    final static String skinLesionSharpBorder = "skinLesionSharpBorder";
    final static String skinLesionSurfaceIrregular = "skinLesionSurfaceIrregular";
    final static String skinLesionUniformDarkColor = "skinLesionUniformDarkColor";
    final static String skinLesionYellowish = "skinLesionYellowish";
    final static String skinLesionYellowScales = "skinLesionYellowScales";
    final static String skinMottled = "skinMottled";
    final static String skinNodules = "skinNodules";
    final static String skinNumbness = "skinNumbness";
    final static String skinOfGenitalChancre = "skinOfGenitalChancre";
    final static String skinPale = "skinPale";
    final static String skinPatchesPurple = "skinPatchesPurple";
    final static String skinPeeling = "skinPeeling";
    // final static String skinPinkWhite = "skinPinkWhite";
    final static String skinPlaques = "skinPlaques";
    final static String skinPlaquesRaised = "skinPlaquesRaised";
    final static String skinPlaquesRed = "skinPlaquesRed";
    final static String skinPlaquesScaled = "skinPlaquesScaled";
    final static String skinPricking = "skinPricking";
    final static String skinSilveryScales = "skinSilveryScales";
    final static String skinSwollen = "skinSwollen";
    final static String skinTender = "skinTender";
    final static String skinTingling = "skinTingling";
    final static String skinTissueCharred = "skinTissueCharred";
    final static String skinToneAdult = "skinToneAdult"; 
    final static String skinWarm = "skinWarm";
    final static String skinWaxy = "skinWaxy";
    final static String slightAlopecia = "slightAlopecia";
    final static String spiderBite = "spiderBite";
    final static String striaePurplish = "striaePurplish";
    final static String sweating = "sweating";
    final static String swellingLocal = "swellingLocal";
    final static String tendernessLocal = "tendernessLocal";
    final static String tickInSkin = "tickInSkin";
    final static String toeNailCrumble = "toeNailCrumble";
    final static String toeNailDiscolor = "toeNailDiscolor";
    final static String toeNailThicken = "toeNailThicken";
    final static String toesBetweenBlisters = "toesBetweenBlisters";
    final static String toesBetweenScaling = "toesBetweenScaling";
    final static String tongueCoating = "tongueCoating";
    final static String tonguePainful = "tonguePainful";
    final static String tonguePale = "tonguePale";
    final static String tongueRed = "tongueRed";
    final static String tongueSwollen = "tongueSwollen";
    final static String ulcer = "ulcer";
    final static String ulcerBleedsEasily = "ulcerBleedsEasily";
    final static String ulcerGray = "ulcerGray";
    final static String ulcerMalodorous = "ulcerMalodorous";
    final static String ulcerPainful = "ulcerPainful";
    final static String ulcerShallow = "ulcerShallow";
    final static String ulcerSoft = "ulcerSoft";
    final static String urethraWarts = "urethraWarts";
    final static String urticaria = "urticaria";
    final static String vaginaWarts = "vaginaWarts";
    final static String vesicle = "vesicle";
    final static String vesicleCheek = "vesicleCheek";
    final static String vesicleMouth = "vesicleMouth";
    final static String vulvaWarts = "vulvaWarts";
    final static String waistlineLesion = "waistlineLesion";
    final static String wheals = "wheals";
    final static String wristLesion = "wristLesion";

  // symptoms gi track / stomach
    final static String borborygmi = "borborygmi";
    final static String epigastricPain = "epigastricPain";
    final static String epigastricUmbilicusPain = "epigastricUmbilicusPain";
    final static String esophagusSpasm = "esophagusSpasm";
    final static String heartburn = "heartburn";
    final static String nausea = "nausea";
    final static String stomachache = "stomachache";
    final static String stomachCramps = "stomachCramps";
    final static String stomachSwelling = "stomachSwelling";
    final static String stomachUpset = "stomachUpset";

  // symptoms throat
    final static String throatWhitePatches = "throatWhitePatches";

  // symptoms trauma
    final static String chestPainSevere = "chestPainSevere";
    final static String suckingSoundWhileBreathing = "suckingSoundWhileBreathing";

  // symptoms veins
    final static String vasodilation = "vasodilation";
    final static String veinHeat = "veinHeat";
    final static String veinPain = "veinPain";
    final static String veinSwelling = "veinSwelling";
    final static String veinTender = "veinTender";


  // ====================================================================

  // abnormal conditions/ often complications
    final static String acidosis = "acidosis";
    final static String adrenalTumor = "adrenalTumor";
    final static String airwayObstruction = "airwayObstruction";
    final static String anovulation = "anovulation";
    final static String areflexia = "areflexia";
    final static String ascites = "ascites";
    final static String atherosclerosis = "atherosclerosis"; // or a disease???
    final static String atrialFibrillation = "atrialFibrillation";
    final static String atrioventricularHeartBlock = "atrioventricularHeartBlock";
    final static String azotemia = "azotemia";
    final static String bacteriuria = "bacteriuria";
    final static String blindness = "blindness";
    final static String bloodDyscrasias = "bloodDyscrasias";
    final static String bloodPressureDifferences = "bloodPressureDifferences";
    final static String brainLesion = "brainLesion";
    final static String bronchialMucusPlugs = "bronchialMucusPlugs";
    final static String cardiacEnlargement = "cardiacEnlargement";
    final static String centralNervousSystemDepression =
          "centralNervousSystemDepression";
    final static String circulatoryFailure = "circulatoryFailure";
    final static String cranialNerveDysfunction = "cranialNerveDysfunction";
    final static String death = "death";
    final static String diastolicMurmurs = "diastolicMurmurs";
    final static String electrolyteImbalance = "electrolyteImbalance";
    final static String empyema = "empyema";
    final static String glycosuria = "glycosuria";
  //    final static String heartFailure = "heartFailure";
    final static String hepaticFailure = "hepaticFailure";
    final static String hepatoJugularReflux = "hepatoJugularReflux";
    final static String hepatomegaly = "hepatomegaly";
    final static String hipDeformity = "hipDeformity";
    final static String hypercalcemia = "hypercalcemia";
    final static String hypercalciuria = "hypercalciuria";
    final static String hyperglycemia = "hyperglycemia";
    final static String hypervolemia = "hypervolemia";
    final static String hypoglycemia = "hypoglycemia";
    final static String hypotonia = "hypotonia";
    final static String hypoxemia = "hypoxemia";
    final static String hypovolemia = "hypovolemia";
    final static String hypoxia = "hypoxia";
    final static String infectionsSevere = "infectionsSevere";
    final static String lactating = "lactating";
    final static String leftVentricularDysfunction = "leftVentricularDysfunction";
    final static String leukocytosis = "leukocytosis";
    final static String leukopenia = "leukopenia";
    final static String lowFertility = "lowFertility";
    final static String malnutrition = "malnutrition";
    final static String microEmboli = "microEmboli";
    final static String myocardialHypoxia = "myocardialHypoxia";
    final static String neurologicDeficiences = "neurologicDeficiences";
    final static String neuropathy = "neuropathy";
    // final static String obesity = "obesity";
    final static String obesityHypoVentilation = "obesityHypoVentilation";
    final static String ovariesTumor = "ovariesTumor";
    final static String pericardialFrictionRub = "pericardialFrictionRub";
    final static String pleuralEffusion = "pleuralEffusion";
    final static String pleuralEffusionLeft = "pleuralEffusionLeft";
    final static String pleuralSpaceRupture = "pleuralSpaceRupture";
    final static String polyhydramnios = "polyhydramnios";
    final static String pregnancy = "pregnancy";
    final static String prostateEnlarged = "prostateEnlarged";
    final static String prostateFirm = "prostateFirm";
    final static String prostateSwollen = "prostateSwollen";
    final static String prostateTender = "prostateTender";
    final static String proteinuria = "proteinuria";
    final static String psychicTraumaSevere = "psychicTraumaSevere";
    // final static String pulmonaryEmboli = "pulmonaryEmboli";
    final static String pulmonaryFailure = "pulmonaryFailure";
    final static String recurrentRespiratoryTractInfections = 
                       "recurrentRespiratoryTractInfections";
    // final static String renalFailure = "renalFailure";
    final static String respiratoryFailure = "respiratoryFailure";
    final static String ribFracture = "ribFracture";
    final static String sepsis = "sepsis";
    final static String shock = "shock";
    final static String spinalCordLesionAboveC6 = 
                       "spinalCordLesionAboveC6";
    final static String spineJointDegeneration = "spineJointDegeneration";
    final static String splenomegaly = "splenomegaly";
    final static String systemicEmbolization = "systemicEmbolization";
    final static String thrombocytopenia = "thrombocytopenia";
    final static String thrombocytosis = "thrombocytosis";
    final static String tracheitis = "tracheitis";
    final static String upperAirwayObstruction = "upperAirwayObstruction";
    final static String uremia = "uremia";
    final static String uterusRupture = "uterusRupture";
    final static String uterusTumors = "uterusTumors";
    final static String valvularInsufficiency = "valvularInsufficiency";
    final static String varicoseVeins = "varicoseVeins";
    final static String vascularCollapse = "vascularCollapse";

  // ==================================================================

  // treatment conditions

final static String beforeSurgery = L.beforeSurgery;
final static String ifAbortionIncomplete = L.ifAbortionIncomplete;
final static String ifAcute = L.ifAcute;
final static String ifAcuteHypoxemia = L.ifAcuteHypoxemia;
final static String ifAcuteUrinaryBlockage = L.ifAcuteUrinaryBlockage;
final static String ifAnatomicDefects = L.ifAnatomicDefects;
final static String ifAndrenalGlandMalfunction = L.ifAndrenalGlandMalfunction;
final static String ifBacterialInfection = L.ifBacterialInfection;
final static String ifBerylliumUlcer = L.ifBerylliumUlcer;
final static String ifBrainTumor = L.ifBrainTumor;
final static String ifBronchospasm = L.ifBronchospasm;
final static String ifCardiacArrest = L.ifCardiacArrest;
final static String ifCervixPolyps = L.ifCervixPolyps;
final static String ifChronic = L.ifChronic;
final static String ifDistress = L.ifDistress;
final static String ifEndometriosis = L.ifEndometriosis;
final static String ifFever = L.ifFever;
final static String ifHeartFailure = L.ifHeartFailure;
final static String ifHipInvolvement = L.ifHipInvolvement;
final static String ifHymenalScars = L.ifHymenalScars;
final static String ifHypercalcemia = L.ifHypercalcemia;
final static String ifHypersensitive = L.ifHypersensitive;
final static String ifHypotension = L.ifHypotension;
final static String ifInfection = L.ifInfection;
final static String ifInfluenzaA = L.ifInfluenzaA;
final static String ifInvasive = L.ifInvasive;
final static String ifItchyVulva = L.ifItchyVulva;
final static String ifLubricationProblem = L.ifLubricationProblem;
final static String ifMassiveEmbolism = L.ifMassiveEmbolism;
final static String ifMechanicalVentilation = L.ifMechanicalVentilation;
final static String ifMenopausalMucosaAtrophy = L.ifMenopausalMucosaAtrophy;
final static String ifModerate = L.ifModerate;
final static String ifNarcoticOverdose = L.ifNarcoticOverdose;
final static String ifNearTerm = L.ifNearTerm;
final static String ifNoOvulation = L.ifNoOvulation;
final static String ifNoSpontaneousLabor = L.ifNoSpontaneousLabor;
final static String ifObstructingNeoplasm = L.ifObstructingNeoplasm;
final static String ifObstructingObject = L.ifObstructingObject;
final static String ifOrganicDisorder = L.ifOrganicDisorder;
final static String ifPain = L.ifPain;
final static String ifPhysicalProblem = L.ifPhysicalProblem;
final static String ifPoisoned = L.ifPoisoned;
final static String ifPregnant = L.ifPregnant;
final static String ifPreinvasive = L.ifPreinvasive;
final static String ifProgesteroneDeficiency = L.ifProgesteroneDeficiency;
final static String ifPsychologicalProblem = L.ifPsychologicalProblem;
final static String ifRash = L.ifRash;
final static String ifRespiratoryFailure = L.ifRespiratoryFailure;
final static String ifRightSidedHeartFailure = L.ifRightSidedHeartFailure;
final static String ifSepticEmboli = L.ifSepticEmboli;
final static String ifSevere = L.ifSevere;
final static String ifSevereAcidosis = L.ifSevereAcidosis;
final static String ifSevereAnxiety = L.ifSevereAnxiety;
final static String ifSevereAttack = L.ifSevereAttack;
final static String ifSevereBleeding = L.ifSevereBleeding;
final static String ifSevereHemoptysis = L.ifSevereHemoptysis;
final static String ifSevereInflammation = L.ifSevereInflammation;
final static String ifSignificantRespiratoryAcidosis = L.ifSignificantRespiratoryAcidosis;
final static String ifStage1Or2 = L.ifStage1Or2;
final static String ifStage3Or4 = L.ifStage3Or4;
final static String ifSuicidal = L.ifSuicidal;
final static String ifSuppressLabor = L.ifSuppressLabor;
final static String ifSwallowingProblem = L.ifSwallowingProblem;
final static String ifThyroidGlandMalfunction = L.ifThyroidGlandMalfunction;
final static String ifTumor = L.ifTumor;
final static String toAchieveConception = L.toAchieveConception;
final static String toControlGlucoseLevel = L.toControlGlucoseLevel;


  // general (?) drugs
    final static String acetaminophen = "acetaminophen";
    final static String acetaminophenOxycodone = "acetaminophen with oxycodone";
    final static String alprazolam = "alprazolam";
    final static String ammoniumChloride = "ammonium chloride";
    final static String amoxicillin = "amoxicillin";
    final static String ampicillin = "ampicillin";
    final static String analgetics = "analgetics";
    final static String antibiotics  = "antibiotics";
    final static String anticoagulants = "anticoagulants";
    final static String anticonvulsants = "anticonvulsants";
    final static String antiemetics = "antiemetics"; // against nausea
    final static String antimicrobials  = "antimicrobials";
    final static String antipruritics = "antipruritics";
    final static String antipyretic = "antipyretic";
    final static String antivenin = "antivenin";
    final static String aspirin = "aspirin";
    final static String atenolol = "atenolol";
    final static String bumetanide = "bumetanide";
    final static String calciumGluconate = "calcium gluconate";
    final static String cephalexin = "cephalexin";
    final static String chloramphenicol = "chloramphenicol";
    final static String ciprofloxacin = "ciprofloxacin";
    final static String citalopram = "citalopram";
    final static String clonazepam = "clonazepam";
    final static String cortisone = "cortisone";
    final static String crestor = "crestor";
    final static String cyclobenzaprine = "cyclobenzaprine";
    final static String demeclocycline = "demeclocycline";
    final static String dexamethasone = "dexamethasone";
    final static String dextran = "dextran";
    final static String diazepam = "diazepam";
    final static String digitalisGlycosides = "digitalis glycosides";
    final static String digoxin = "digoxin";
    final static String diovan = "diovan";
    final static String diuretics = "diuretics";
    final static String duloxetine = "duloxetine";
    final static String effexor = "effexor";
    final static String erythromycin = "erythromycin";
    final static String fexofenadine = "fexofenadine";     
    final static String fluoxetine = "fluoxetine";
    final static String fluticasone = "fluticasone";
    final static String furosemide = "furosemide";
    final static String gabapentin = "gabapentin";
    final static String glucocorticoids = "glucocorticoids";
    final static String glucose = "glucose";
    final static String heparin = "heparin";
    final static String hydrochlorothiazide = "hydrochlorothiazide";
    final static String hydrocodoneAcetaminophen = "hydrocodone acetaminophen";
    final static String hydrocortisone = "hydrocortisone";
    final static String ibuprofen = "ibuprofen";
    final static String insulin = "insulin";
    final static String isoniazid = "isoniazid";
    final static String isoproterenol = "isoproterenol";
    final static String lexapro = "lexapro";
    final static String lipitor = "lipitor";
    final static String lisinopril = "lisinopril";
    final static String lovastatin = "lovastatin";
    final static String lorazepam = "lorazepam";
    final static String mannitol = "mannitol";
    final static String metformin = "metformin";
    final static String methocarbamol = "methocarbamol";
    final static String metoprolol = "metoprolol";
    final static String morphine = "morphine"; 
    final static String naloxone = "naloxone";
    final static String negativeInotropicAgents = "negative inotropic agents";
    final static String nexium = "nexium";
    final static String omeprazole = "omeprazole";
    final static String oralContraceptives = "oral contraceptives";
    final static String oseltamivir = "oseltamivir";
    final static String oxycodone = "oxycodone";
    final static String parenteralAntibiotics = "parenteral antibiotics";
    final static String paroxetine = "paroxetine";
    final static String penicillinG = "penicillinG";
    final static String penicillin = "penicillin";
    final static String pirazinamide = "pirazinamide";
    final static String plavix = "plavix";
    final static String poisonAntidote = "poison antidote";
    final static String potassium = "potassium";
    final static String prevacid = "prevacid";
    final static String prostaglandinInhibitor = "prostaglandin inhibitor";
    final static String rifampin = "rifampin";
    final static String sertraline = "sertraline";
    final static String singulair = "singulair";
    final static String simvastatin = "simvastatin";
    final static String sodiumChloride = "sodium chloride";
    final static String steroidCream = "steroid cream";
    final static String steroids = "steroids";
    final static String stoolSoftener = "stool softener";
    final static String streptokinase = "streptokinase";  
    final static String sulfonamide = "sulfonamide";
    final static String synthroid = "synthroid";
    final static String tetracycline = "tetracycline";
    final static String topicalAnesthetics = "topical anesthetics";
    final static String tramadol = "tramadol";
    final static String tranquilizer = "tranquilizer";
    final static String trazodone = "trazodone";
    final static String triamterene = "triamterene";
    final static String trimethoprim = "trimethoprim";
    final static String vitaminBComplex = "vitamin B complex";
    final static String vitaminC = "vitamin C";
    final static String vitaminD = "vitamin D";
    final static String vitaminE = "vitamin E";
    final static String vitaminK = "vitamin K";
    final static String vitaminSupplements = "vitamin supplements";
    final static String warfarin = "warfarin";
    final static String zolpidem = "zolpidem";

  // cardiac drugs (are they actually specific?)
    final static String antiArrhythemics = "anti arrhythemics";
    final static String antihypertensives = "antihypertensives";
    final static String betaBlocker = "beta blocker";
    final static String bretyllium = "bretyllium";
    final static String calciumChannelBlockers = "calcium channel blockers";
    final static String codeine = "codeine";
    final static String fibrinolyticInhibitor = "fibrinolytic inhibitor";
    final static String lidocaine = "lidocaine";
    final static String phenytoin = "phenytoin";
    final static String phenobarbital = "phenobarbital";
          // sodium nitroprusside = nitroprusside ???
    final static String sodiumNitroprusside = "sodium nitroprusside";

  // ear drugs
    final static String atropine = "atropine";

  // endocrine drugs
    final static String antithyroid = "antithyroid";
    final static String ketoconazole = "ketoconazole";
    final static String levothyroxine = "levothyroxine";

  // eye drugs
    final static String cycloplegic = "cycloplegic";
    final static String trifluridineEyeDrops = "trifluridine eye drops";
    final static String vidarabineOintment = "vidarabine ointment";

  // gastrointestinal drugs
    final static String antacid = "antacid";
    final static String antispasmodic = "antispasmodic";
    final static String meperidine = "meperidine";

  // gynecologic drugs
    final static String androgens = "androgens";
    final static String betaAdrenergicStimulants = "beta adrenergic stimulants";
    final static String bromocriptine = "bromocriptine";
    final static String ceftriaxone = "ceftriaxone";
    final static String clomiphene = "clomiphene";
    final static String clomipheneCitrate = "clomiphene citrate";
    final static String danazol = "danazol";
    final static String estrogen = "estrogen";
    final static String gonadotropin = "gonadotropin";
    final static String magnesiumSulfate = "magnesium sulfate";
    final static String medroxyprogesterone = "medroxyprogesterone";
    final static String oxytocin = "oxytocin";
    final static String progesterone = "progesterone";
    final static String progestins = "progestins";
    final static String sodiumFluoride = "sodium fluoride";

  // hematologic drugs
    final static String folicAcidSupplement = "folic acid supplement";

  // immune drugs (AIDS and other)
    final static String ampligen = "ampligen";
    final static String didanosine = "didanosine";
    final static String indinavir = "indinavir";
    final static String lamivudine = "lamivudine";
    final static String nelfinavir = "nelfinavir";
    final static String ritonavir = "ritonavir";
    final static String saquinavirMaleate = "saquinavir maleate";
    final static String stavudine = "stavudine";
    final static String zalcitabine = "zalcitabine";
    final static String zidovudine = "zidovudine";

  // infection drugs
    final static String antiseptics = "antiseptics";
    final static String antitussive = "antitussive";
    final static String azithromycin = "azithromycin";
    final static String botulinumAntitoxin = "botulinum antitoxin";
    final static String chloroquine = "chloroquine";
    final static String clotrimazole = "clotrimazole";
    final static String doxycycline = "doxycycline";
    final static String fluconazole = "fluconazole";
    final static String metronidazole = "metronidazole";
    final static String miconazole = "miconazole";
    final static String nystatin = "nystatin";
    final static String praziquantel = "praziquantel";
    final static String pyrimetathamine = "pyrimetathamine";
    final static String rabiesImmuneGlobin = "rabies immune globin";
    final static String tetanusToxoid = "tetanus toxoid";

  // neoplasm drugs
    final static String aminoglutethimide = "aminoglutethimide";

  // neurologic drugs
    final static String anticholinesterase = "anticholinesterase";
    final static String carbamazepine = "carbamazepine";
    final static String cerebralVasodilators = "cerebral vasodilators";
    final static String corticotropin = "corticotropin";
    final static String immunosuppressant = "immunosuppressant";
    final static String levodopa = "levodopa";
    final static String plasmapheresis = "plasmapheresis";
    final static String prednisone = "prednisone"; // ako oral cortisone
    final static String pregabalin = "pregabalin";
    final static String primidone = "primidone";
    final static String psychostimulators = "psychostimulators";
    final static String tacrine = "tacrine";

  // nose drugs
    final static String decongestant = "decongestant";

  // psychiatric drugs 
    final static String antianxietyDrug = "antianxiety drug";
    final static String antidepressants = "antidepressants";
    final static String antipsychoticDrugs = "antipsychotic drugs";
    final static String benzodiazepines = "benzodiazepines";
    final static String buspirone = "buspirone";
    final static String lithium = "lithium"; 

  // respiratory drugs (are they actually specific?)
    final static String acyclovir = "acyclovir";
    final static String albuterol = "albuterol";
    final static String amantadine = "amantadine";
    final static String aminoglycocide = "aminoglycocide";
    final static String anticholinergicBronchodilator = 
                       "anticholinergic bronchodilator";
    final static String beclomethasone = "beclomethasone";
    final static String betaAgonistBronchodilator = "beta agonist bronchodilator";
    final static String bronchodilator = "bronchodilator";
    final static String cephalosporin = "cephalosporin";
    final static String clindamycin = "clindamycin";
    final static String colchicine = "colchicine";
    final static String corticosteroids = "corticosteroids";
    final static String coTrimoxazole = "coTrimoxazole";
    final static String cyclophosphamide = "cyclophosphamide";
    final static String diazoxide = "diazoxide";
    final static String diphenhydramine = "diphenhydramine";
    final static String epinephrine = "epinephrine";
    final static String ganciclovir = "ganciclovir";
    final static String hydralazine = "hydralazine";
    final static String inhaleRacemicEpiphrine = "inhale racemic epiphrine";
    final static String inhaleCorticosteroids = "inhale corticosteroids";
    final static String ipratropium = "ipratropium";
    final static String ipratropiumBromide = "ipratropium bromide";
    final static String IVTheophylline = "IV theophylline";
    final static String metaproterenol = "metaproterenol";
    final static String methyldopa = "methyldopa";
    final static String mucolytics = "mucolytics";
    final static String nafcillin = "nafcillin";
    final static String narcotics = "narcotics";
    final static String nitroglycerin = "nitroglycerin";
    final static String nitroprusside = "nitroprusside";
    final static String oxacillin = "oxacillin";
    final static String pancuroniumBromide = "pancuronium bromide";
    final static String pentamidine = "pentamidine";
    final static String prostaglandins = "prostaglandins";
    final static String pulmonaryArteryVasodilators = 
                       "pulmonary artery vasodilators";
    final static String ribavirin = "ribavirin";
    final static String rimantadine = "rimantadine";
    final static String salmeterol = "salmeterol";
    final static String sedatives = "sedatives";
    final static String sodiumBicarbonate = "sodium bicarbonate";
    final static String terbutaline = "terbutaline";
    final static String theophylline = "theophylline";
    final static String triamcinolone = "triamcinolone";
    final static String trimethaphan = "trimethaphan";
    final static String tubocurarine = "tubocurarine";
    final static String vasodilators = "vasodilators";
    final static String vasopressin = "vasopressin";

  // sexual drugs
    final static String testosterone = "testosterone";

  // skin drugs
    final static String antihistamines = "antihistamines";
    final static String imidazole = "imidazole";
    final static String griseofulvin = "griseofulvin";
    final static String podophyllum = "podophyllum";

  // urologic drugs
    final static String antiandrogens = "antiandrogens";
    final static String finasteride = "finasteride";
    final static String prazosin = "prazosin";
    final static String terazosin = "terazosin";


  // general treatment actions

final static String alcoholModeration = L.alcoholModeration;
final static String anesthetic = L.anesthetic;
final static String anestheticLocal = L.anestheticLocal;
final static String avoidSunlightExposure = L.avoidSunlightExposure;
final static String bedHeadElevated = L.bedHeadElevated;
final static String bedRest  = L.bedRest ;
final static String bleedingControl = L.bleedingControl;
final static String boneMarrowTransplant = L.boneMarrowTransplant;
final static String cauterization = L.cauterization;
final static String chemoTherapy = L.chemoTherapy;
final static String coldCompress = L.coldCompress;
final static String colloidCrystalloidInfusions = L.colloidCrystalloidInfusions;
final static String coolSitzBath = L.coolSitzBath;
final static String cottonBall = L.cottonBall;
final static String dialysis  = L.dialysis ;
final static String diet = L.diet;
final static String dietFiber = L.dietFiber;
final static String dietHighCalorie = L.dietHighCalorie;
final static String dietLiquid = L.dietLiquid;
final static String dietLowCalcium = L.dietLowCalcium;
final static String dietLowProtein = L.dietLowProtein;
final static String dietLowSalt = L.dietLowSalt;
final static String dietWithoutGluten = L.dietWithoutGluten;
final static String drainageOfAbscess = L.drainageOfAbscess;
final static String electrolyteReplacement = L.electrolyteReplacement;
final static String excision = L.excision;
final static String exercise = L.exercise;
final static String externalPressure = L.externalPressure;
final static String fluidManagement = L.fluidManagement;
final static String freshFrozenPlasma = L.freshFrozenPlasma;
final static String gastricLavage = L.gastricLavage;
final static String hemodialysis = L.hemodialysis;
final static String homeCareAndRest  = L.homeCareAndRest ;
final static String hormoneTherapy = L.hormoneTherapy;
final static String hospitalization  = L.hospitalization ;
final static String hydration  = L.hydration ;
final static String hyperbaricOxygen = L.hyperbaricOxygen;
final static String icePack = L.icePack;
final static String IVFluids = L.IVFluids;
final static String IVNutrition = L.IVNutrition;
final static String laserSurgery = L.laserSurgery;
final static String lieDownPatient = L.lieDownPatient;
final static String lindaneCream = L.lindaneCream;
final static String lindaneShampoo = L.lindaneShampoo;
final static String massage = L.massage;
final static String mouthWash = L.mouthWash;
final static String nothingByMouth = L.nothingByMouth;
final static String nutritionImprove = L.nutritionImprove;
final static String oralHygiene = L.oralHygiene;
final static String painManagement = L.painManagement;
final static String parenteralFluidAdministration = L.parenteralFluidAdministration;
final static String parenteralFluidReplacement = L.parenteralFluidReplacement;
final static String perhapsSurgery = L.perhapsSurgery;
final static String peritonealDialysis = L.peritonealDialysis;
final static String phlebotomy = L.phlebotomy;
final static String placedOnLeftSide = L.placedOnLeftSide;
final static String pharmacotherapy = L.pharmacotherapy;
final static String platelets = L.platelets;
final static String pneumaticAntishockGarment = L.pneumaticAntishockGarment;
final static String pressureDressing = L.pressureDressing;
final static String protectiveClothing = L.protectiveClothing;
final static String proteinSupplement = L.proteinSupplement;
final static String psychoanalyticTherapy = L.psychoanalyticTherapy;
final static String psychologicalCounseling = L.psychologicalCounseling;
final static String radiationTherapy = L.radiationTherapy;
final static String regularEjaculation = L.regularEjaculation;
final static String salineGargles = L.salineGargles;
final static String saltyBroth = L.saltyBroth;
final static String sitzBath = L.sitzBath;
final static String smokingCessation = L.smokingCessation;
final static String sodiumRestriction = L.sodiumRestriction;
final static String stretching = L.stretching;
final static String surgery = L.surgery;
final static String surgicalDebridement = L.surgicalDebridement;
final static String surgicalEmbolectomy = L.surgicalEmbolectomy;
final static String warmCompress = L.warmCompress;
final static String wetDressings = L.wetDressings;
final static String weightIncrease = L.weightIncrease;
final static String weightReduction = L.weightReduction;
final static String woundCare = L.woundCare;
final static String wristSplint = L.wristSplint;

  // general conditional actions
final static String ifFeverProvideAntipyretic = L.ifFeverProvideAntipyretic;
final static String ifInfectionProvideAntibiotic = L.ifInfectionProvideAntibiotic;

  // burn treatment actions
final static String lactatedRingerSolution = L.lactatedRingerSolution;

  // cardiac treatment actions
final static String angioplasty = L.angioplasty;
final static String antiembolismStockings = L.antiembolismStockings;
final static String antiplateletAggregateTherapy = L.antiplateletAggregateTherapy;
final static String cardioversion = L.cardioversion;
final static String CPR = L.CPR;
final static String decreaseCardiacWorkload = L.decreaseCardiacWorkload;
final static String embolectomy = L.embolectomy;
final static String increaseCardiacOutput = L.increaseCardiacOutput;
final static String thrombolyticTherapy = L.thrombolyticTherapy;
final static String valveReplacement = L.valveReplacement;

  // endocrine treatment actions
final static String radioactiveIodine = L.radioactiveIodine;

  // eye treatment actions
final static String laserPhotocoagulation = L.laserPhotocoagulation;

  // GI treatment actions
final static String bowelRest = L.bowelRest;
final static String nasogastricTube = L.nasogastricTube;
final static String nutritionSupport = L.nutritionSupport;
final static String paranteralNutrition = L.paranteralNutrition;

  // gynecologic treatment actions
final static String cesarianDelivery = L.cesarianDelivery;
final static String chemicalCautery = L.chemicalCautery;
final static String curettage = L.curettage;
final static String hysterectomy = L.hysterectomy;
final static String inductionOfLabor = L.inductionOfLabor;
final static String phototherapy = L.phototherapy;
final static String topicalEstrogenOintment = L.topicalEstrogenOintment;
final static String upliftSupportBra = L.upliftSupportBra;
final static String xrayTherapy = L.xrayTherapy;

  // hematologic treatment actions
final static String splenectomy = L.splenectomy;

  // metabolic treatment actions
final static String potassiumReplacement = L.potassiumReplacement;

  // neurologic treatment actions
final static String neurosurgery = L.neurosurgery;
final static String seizurePrecautions = L.seizurePrecautions;

  // psychiatric treatment actions
final static String electroconvulsiveTherapy = L.electroconvulsiveTherapy;
final static String psychotherapy = L.psychotherapy;

  // renal treatment actions
final static String kidneyTransplantation = L.kidneyTransplantation;

  // respiratory treatment actions
final static String airwayMaintenance = L.airwayMaintenance;
final static String aspirationPrecautions = L.aspirationPrecautions;
final static String breathIntoPaperBag = L.breathIntoPaperBag;
final static String bronchialDrainage = L.bronchialDrainage;
final static String bronchoscopy = L.bronchoscopy;
final static String chestPercussion = L.chestPercussion;
final static String chestTubeDrainage = L.chestTubeDrainage;
final static String coughingExercise = L.coughingExercise;
final static String deepBreathingExercise = L.deepBreathingExercise;
final static String endotrachealIntubation = L.endotrachealIntubation;
final static String establishmentOfAirway = L.establishmentOfAirway;
final static String fibrinolyticTherapy = L.fibrinolyticTherapy;
final static String fluidIncrease = L.fluidIncrease;
final static String fluidRestriction = L.fluidRestriction;
final static String heartLungTransplantation = L.heartLungTransplantation;
final static String humidifiedAir = L.humidifiedAir;
final static String humidifiedOxygen = L.humidifiedOxygen;
final static String hyperventilationAfterIntubation = L.hyperventilationAfterIntubation;
final static String intubation = L.intubation;
final static String IVVolumeExpanders = L.IVVolumeExpanders;
final static String lobectomy = L.lobectomy;
final static String mechanicalVentilation = L.mechanicalVentilation;
final static String MinnesotaTube = L.MinnesotaTube;
final static String oxygenTherapy = L.oxygenTherapy;
final static String posturalDrainage = L.posturalDrainage;
final static String steamInhalation = L.steamInhalation;
final static String suctioning = L.suctioning;
final static String tracheotomy = L.tracheotomy;
final static String vasopressor = L.vasopressor;
final static String volumeVentilation = L.volumeVentilation;

  // sexual treatment actions
final static String behaviorTherapy = L.behaviorTherapy;
final static String creamsOrGels = L.creamsOrGels;
final static String education = L.education;
final static String experientialTherapy = L.experientialTherapy;
final static String MasterAndJohnsonTherapy = L.MasterAndJohnsonTherapy;
final static String sexTherapy = L.sexTherapy;

  // skin treatment actions
final static String carbonDioxideLaser = L.carbonDioxideLaser;
final static String cryosurgery = L.cryosurgery;
final static String electrocautery = L.electrocautery;
final static String permethrinCream = L.permethrinCream;

  // trauma treatment actions
final static String craniotomy = L.craniotomy;
final static String positionBittenLimbBelowHeart = L.positionBittenLimbBelowHeart;
final static String removeTick = L.removeTick;

  // -------------------  synonyms - aliases -----------------------

  final static String ADHD = "ADHD"; // attentionDeficitHyperactivityDisorder
  final static String AIDS = "AIDS"; // acquiredImmunoDeficiencySyndrome
  final static String aids = "aids"; // acquiredImmunoDeficiencySyndrome
  final static String ALS = "ALS"; // amyotropicLateralSclerosis
  final static String anal = "anal"; // anus
  final static String anxious = "anxious"; // anxiety
  final static String ARDS = "ARDS"; // adult respiratory distress syndrome
  final static String ASD = "ASD"; // atrialSeptalDefect
  final static String athleteFoot = "athleteFoot"; // tineaPedis
  final static String avianFlu = "avianFlu";
  final static String balls = "balls"; // testicles
  final static String BasedowDisease = "BasedowDisease"; // hyperthyroidism
  final static String bilharziasis = "bilharziasis"; // schistosomiasis
  final static String birdFlu = "birdFlu";
  final static String bladderInfection = "bladderInfection"; // cystitis
  final static String bleeding = "bleeding"; // menstruation & menarcheEarly
  final static String BOOP = "BOOP"; // bronchiolitisObliteransWithPneumonia
  final static String breakingWater = "breakingWater"; // amnioticMembraneRupture
  final static String candidosis = "candidosis"; // candidiasis
  final static String colic = "colic"; // abdomenPainSuddenSevere
  final static String COPD = "COPD"; // chronic obstructive pulmonary disease
    // final static String coughing = "coughing"; // cough also external cause
  final static String diabetic = "diabetic";
  final static String DIC = "DIC"; // disseminated intravascular coagulation
  final static String earInfection = "earInfection";
  final static String foodPoisoning = "foodPoisoning"; // gastroenteritis
  final static String fuck = "fuck"; // intercourse
  final static String gallstones = "gallstones";
  final static String gastric = "gastric"; // stomach
  final static String germanMeasles = "germanMeasles";
  final static String GravesDisease = "GravesDisease"; // hyperthyroidism
  final static String H5N1 = "H5N1";
  final static String heartAttack = "heartAttack";
  final static String highBloodPressure = "highBloodPressure"; // hypertension
    final static String hives = "hives"; // urticaria
  final static String hyperprolactinemia = "hyperprolactinemia"; // galactorrhea
  final static String impotent = "impotent"; // erectionDisorder
  final static String insomnia = "insomnia"; // sleepDisturbed
  final static String interstitialLungDisease = "interstitialLungDisease";
  final static String intracranialAneurysm = "intracranialAneurysm";
  final static String ITP = "ITP"; // idiopathicThrombocytopenicPurpura
  final static String intercourse = "intercourse"; // in intercourseDiscomfort
  final static String jockItch = "jockItch";
  final static String kidneyStone = "kidneyStone";
  final static String lowBloodPressure = "lowBloodPressure"; // hypotension
  final static String maternalHypertension = "maternalHypertension"; // pregnancyInducedHypertension
  final static String menstruation = "menstruation"; // in several combinations
  final static String migraine = "migraine"; // chronicHeadache
  final static String moniliasis = "moniliasis"; // candidiasis
  final static String mononucleosis = "mononucleosis"; // epsteinBarrDisease
  final static String nasal = "nasal"; // nose
  final static String NEC = "NEC"; // necrotizingEnterocolitis
  final static String odynophagia = "odynophagia"; // swallowingPainful
  final static String pelvisCellulitis = "pelvisCellulitis"; // parametritis
  final static String PID = "PID"; // pelvisInflammatoryDisease
  final static String pinkEye = "pinkEye"; // conjunctivitis
  final static String piss = "piss"; // -> urinary
  final static String pissing = "pissing"; // -> urinary
  final static String PMS = "PMS"; // premenstrualSyndrome
  final static String PROM = "PROM"; // prematureRuptureOfTheMembranes
  final static String pseudodiphtheria = "pseudodiphtheria"; // epsteinBarrDisease
  final static String RDS = "RDS"; // = respiratoryDistressSyndrome
  final static String rhinorrhea = "rhinorrhea"; // noseDischarge
  final static String renalCancer = "renalCancer"; // kidneyCancer
  final static String runnyNose = "runnyNose"; // noseDischarge
  final static String salpingitis = "salpingitis"; // salpingoOophoritis
  final static String SARS = "SARS"; // severeAcuteRespiratorySyndrome
  final static String sars = "sars"; // severeAcuteRespiratorySyndrome
  final static String scarlatina = "scarlatina"; // -> scarletFever
  final static String scurvy = "scurvy"; // vitaminCdeficiency
  final static String seizures = "seizures"; // -> seizure
  final static String sex = "sex";
  final static String sexual = "sexual";
  final static String shingles = "shingles"; // herpesZoster
  final static String shortOfBreath = "shortOfBreath"; // -> dyspnea
        // SIADH = syndromeOfInappropriateAntidiureticHormoneSecretion
  final static String SIADH = "SIADH"; 
  final static String skinYellow = "skinYellow"; //  -> jaundice
  final static String sternum = "sternum"; // -> breastBone
  final static String strepThroat = "strepThroat"; // -> pharyngitisStreptococcal
  final static String stroke = "stroke"; // -> cerebrovascularAccident
  final static String swelling = "swelling"; // -> edema
  final static String swollen = "swollen"; // -> edema
  final static String system = "system";
  final static String sys = "sys";
  final static String testes = "testes"; // testicles
  final static String thyrotoxicosis = "thyrotoxicosis"; // hyperthyroidism
  final static String tinea = "tinea"; // dermatophytosis
  final static String travelerDiarrhea = "travelerDiarrhea"; // gastroenteritis
  final static String twitch = "twitch"; // spasm
  final static String UTI = "UTI"; // urinaryTractInfection
  final static String virusEnteritis = "virusEnteritis"; // gastroenteritis
  final static String VSD = "VSD"; // ventricularSeptalDefect

  // ref from singular to plural or the other way around

  final static String ankle = "ankle"; // -> ankles
  final static String arm = "arm"; // -> arms
  final static String breast = "breast"; // -> breasts
  final static String cornea = "cornea"; // -> corneas
  final static String ear = "ear"; // -> ears
  final static String elbow = "elbow"; // -> elbows
  final static String eye = "eye"; // -> eyes
  final static String finger = "finger"; // -> fingers
  final static String flank = "flank"; // -> flanks
  final static String hand = "hand"; // -> hands
  final static String hip = "hip"; // -> hips
  final static String jaw = "jaw"; // -> jaws
  final static String joint = "joint"; // -> joints
  final static String knee = "knee"; // -> kneess
  final static String kidney = "kidney"; // -> kidneys
  final static String leg = "leg"; // -> legs
  final static String lip = "lip"; // -> lips
  final static String lung = "lung"; // -> lungs
  final static String nail = "nail"; // -> nails
  final static String nipple = "nipple"; // -> nipples
  final static String palm = "palm"; // -> palms
  final static String pupil = "pupil"; // -> pupils
  final static String retina = "retina"; // -> retinas
  final static String ovary = "ovary"; // -> ovaries
  final static String shoulder = "shoulder"; // -> shoulders
  final static String thigh = "thigh"; // -> thighs
  final static String thumb = "thumb"; // -> thumbs
  final static String toe = "toe"; // -> toes
  final static String wrist = "wrist"; // -> wrists

    // colloquial and other words
  final static String blood = "blood"; // fragment of other names
  final static String bloody = "bloody"; // fragment of other names
  final static String cunt = "cunt"; // -> vagina
  final static String poop = "poop"; // -> stool
  final static String stool = "stool"; // unknown type word
  final static String urinary = "urinary"; // unknown type word

 /*
  final static String lossOfMemory = amnesia;
  final static String speakingTrouble = aphasia;
  final static String understandingTrouble = dysphasia;
  final static String oneSidedNumbness = hemiparesis;
  final static String changedPupils = pupillaryChanges;
  */

    final static String synonym = "synonym";

} // end of LR




