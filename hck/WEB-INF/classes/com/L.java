// (C) OntoOO Inc 2004 Jan
package com;


public interface  L {

    final static String language = "US";

  // ---------------- concepts ---------------- 

    // AbnormalCondition.java
    final static String AbnormalCondition = "Abnormal Condition:";
    final static String CausesDiseases = "Causes Diseases: "; // space at end
    final static String CausedByDiseases = "Caused by Diseases:";
    final static String Treatments = "Treatments:";
    // BodySystem.java
    final static String BodySystem = "Body System:";
    final static String Location = "Location:";
    final static String gender = "gender:";
    final static String SupersystemKey = "Supersystem key:";
    final static String Description = "Description:";
    final static String DiseaseKeys = "Disease keys:";
    final static String SubsystemsKeys = "Subsystems keys:";
    // Bone.java
    final static String Bone = "Bone:";
    // BoneSet.java
    final static String BoneSet = "Bone Set:";
    //  Condition.java
    final static String Name = "Name:";
    final static String WebResource = "Web Resource:";
    // ConnectionLocation.java
    final static String ConnectionLocation = "Connection Location:";
    final static String ReferenceLocation1 = "Reference Location 1:";
    final static String ReferenceLocation2 = "Reference Location 2:";
    // Disease.java
    final static String Disease = "Disease:";
    final static String LifeThreatening = "Life Threatening:";
    final static String Yes  = "Yes";
    final static String SuperDisease = "Super disease:";
    final static String Subdiseases = "Subdiseases:";
    final static String DiseaseSet = "Disease Set:";
    final static String Temperature = "Temperature:";
    final static String GenderSpecific = "Gender specific?:";
    final static String RaceSpecific = "Race specific?:";
    final static String AgeRange = "Age range:";
    final static String AgeMin = "minimum:";
    final static String AgeMax = "maximum:";
    final static String StatusCondition = "Status condition:";
    final static String Duration = "Duration:";
    final static String frequency = "frequency:";
    final static String Genetic = "Genetic:";
    final static String ParentDisease = "Parent disease:";
    final static String UnderlyingDisease = "Underlying disease:";
    final static String ExternalCauses = "External causes:";
    final static String MiscComments = "Misc. comments:";
    final static String Symptoms = "Symptoms: "; // space at end !
    final static String MaxRate = "Max rate:";
    final static String InternalCauses = "Internal causes:";
    final static String CausingSets = "Causing sets:";
    final static String CausingAbnormalConditions = "Causing abnormal conditions:";
    //    final static String CausesDiseases = "Causes diseases:";
    final static String CausesAbnormalConditions = "Causes abnormal conditions/ complications:";
    final static String Literature = "Literature:";
    final static String Illustrations = "Illustrations:";
    //    final static String Treatments = "Treatments:";
    final static String AbnormalConditionTreatments = "Abnormal condition treatments:";
    final static String about = "about "; // space at end
    final static String days = " day(s)";
    final static String criticallyAcute = "critically acute";
    final static String chronic = "chronic";
    final static String lessDay = "less than a day";
    final static String lessWeek = "less than a week";
    final static String lessMonth = "less than a month";
    final static String lessMonth3  = "less than 3 months";
    final static String lessMonth6 = "less than 6 months";
    final static String lessYear = "less than a year";
    final static String unknown = "unknown";
    final static String NA = "NA";
    // DiseasePhase.java
    // DiseaseSet.java
    // final static String DiseaseSet = "Disease Set:";
    final static String members = "# members:";
    final static String DiseaseMembers = "Disease members:";
    // Drug.java
    final static String Drug = "Drug:";
    // ExternalCause.java
    final static String ExternalCause = "External Cause";
    // HasName.java
    // Literature.java
    // Location.java
    final static String ContainedLocations = "Contained locations:";
    final static String ContainedBodySystems = "Contained body-systems:";
    final static String AbnormalConditions = "Abnormal conditions:";
    // LocationRelation.java
    final static String inside = "inside";
    final static String surface = "surface";
    final static String adjacent = "adjacent";
    final static String connecting = "connecting";
    final static String left = "left";
    final static String right = "right";
    final static String leftToRight = "left to right";
    final static String leftToMiddle = "left to middle";
    final static String rightToMiddle = "right to middle";
    final static String top = "top";
    final static String bottom = "bottom";
    final static String topToBottom = "top to bottom";
    final static String topToMiddle = "top to middle";
    final static String bottomToMiddle = "bottom to middle";
    final static String back = "back";
    final static String front = "front";
    final static String backToFront = "back to front";
    final static String backToMiddle = "back to middle";
    final static String frontToMiddle = "front to middle";
    final static String middle = "middle";
    final static String both = "both"; 
    final static String male = "male";
    final static String female = "female";
    final static String moreMale = "more male";
    final static String moreFemale = "more female";
    final static String africanAmerican = "african american";
    final static String asian = "asian";
    final static String caucasian = "caucasian";
    final static String chineseAmerican = "chinese american";
    final static String hispanic = "hispanic";
    final static String indianAmerican = "indian american"; 
    final static String japaneseAmerican = "japanese american";
    final static String jewishAmerican = "jewish american";
    final static String nativeAmerican = "native american";

    final static String none   = "none";

    // LocationSet.java
    final static String LocationSet = "Location Set:";
    final static String SetMembers = "Set members:";
    final static String superset  = "superset:";
    final static String Subsets = "Subsets:";
    // Muscle.java
    final static String Muscle = "Muscle:";
    // MuscleSet.java
    final static String MuscleSet = "Muscle Set:";
    //  Organ.java
    final static String Organ = "Organ:";
    // OrganSet.java
    final static String OrganSet = "Organ Set:";
    // PartLocation.java
    final static String PartLocation = "Part Location:";
    final static String adjacentLocation2 = "adjacent location2";
    final static String alsoPartOf  = "also part of:";
    final static String leftRight = "left-right:";
    final static String topBottom = "top-bottom:";
    final static String backFront = "back-front:";
    // PartOfLocation.java
    final static String partOf = "part of:";
    final static String position = "position:";
    final static String memberOf = "member of:";
    // Symptom.java
    final static String Symptom = "Symptom:";
    // Tendon.java
    final static String Tendon = "Tendon:";
    // TendonSet.java
    final static String TendonSet = "Tendon Set:";
    // Treatment.java
    final static String Treatment = "Treatment:";
    final static String Condition = "Condition:";
    // TreatmentAction.java
    // Vein.java
    final static String Vein = "Vein:";
    // VeinSet.java
    final static String VeinSet = "Vein Set:";
    // WeightedSymptom.java
    final static String weight = "weight:";
    final static String elaboration = "elaboration:";
    // XWord.java
    final static String XWord = "XWord:";
    final static String name = "name:";
    final static String synonym = "synonym:";
    final static String Concept = "Concept:";
    final static String inClass  = "in class:";
    //  XWordNormal.java
    final static String References = "References:";
    final static String referenceTo = "reference to:";
    //  XWordPolish.java
    final static String SubWords = "SubWords:";
    final static String subWordTo = "subWord to:";

  // ---------------- locations ---------------- 

// aBone
final static String aBonePrintName = "a bone";
// aLymphNode
final static String aLymphNodePrintName = "a lymph node";
// aMuscle
final static String aMusclePrintName = "a muscle";
// aTendon
final static String aTendonPrintName = "a tendon";
// aVein
final static String aVeinPrintName = "a vein";
// abdomen
final static String abdomenPrintName = "abdomen";
// adrenals
final static String adrenalsPrintName = "adrenals";
// amnioticMembrane
final static String amnioticMembranePrintName = "amniotic membrane";
// anOrgan
final static String anOrganPrintName = "an organ";
// ankles
final static String anklesPrintName = "ankles";
// anus
final static String anusPrintName = "anus";
// aorta
final static String aortaPrintName = "aorta";
// appendix
final static String appendixPrintName = "appendix";
// armPits
final static String armPitsPrintName = "arm pits";
// arms
final static String armsPrintName = "arms";
// back
final static String backPrintName = "back";
// bladder
final static String bladderPrintName = "bladder";
// bloodstream
final static String bloodstreamPrintName = "bloodstream";
// body
final static String bodyPrintName = "body";
// brain
final static String brainPrintName = "brain";
// breastBone
final static String breastBonePrintName = "breast bone";
// breasts
final static String breastsPrintName = "breasts";
// breastsFemale
final static String breastsFemalePrintName = "breasts female";
// buttock
final static String buttockPrintName = "buttock";
// cervix
final static String cervixPrintName = "cervix";
// cheeks
final static String cheeksPrintName = "cheeks";
// chest
final static String chestPrintName = "chest";
// clitoris
final static String clitorisPrintName = "clitoris";
// colon
final static String colonPrintName = "colon";
// conjunctiva
final static String conjunctivaPrintName = "conjunctiva";
// corneas
final static String corneasPrintName = "corneas";
// cranialNerve5th
final static String cranialNerve5thPrintName = "cranial 5th nerve";
// cranialNerve7th
final static String cranialNerve7thPrintName = "cranial 7th nerve";
// digits
final static String digitsPrintName = "digits";
// ears
final static String earsPrintName = "ears";
// elbows
final static String elbowsPrintName = "elbows";
// endometrium
final static String endometriumPrintName = "endometrium";
// epididymisSet
final static String epididymisSetPrintName = "epididymis set";
// epigastricRegion
final static String epigastricRegionPrintName = "epigastric region";
// esophagus
final static String esophagusPrintName = "esophagus";
// eyelids
final static String eyelidsPrintName = "eyelids";
// eyes
final static String eyesPrintName = "eyes";
// face
final static String facePrintName = "face";
// fallopianTubes
final static String fallopianTubesPrintName = "fallopian tubes";
// feet
final static String feetPrintName = "feet";
// fingerNails
final static String fingerNailsPrintName = "finger nails";
// fingers
final static String fingersPrintName = "fingers";
// flanks
final static String flanksPrintName = "flanks";
// foreSkin
final static String foreSkinPrintName = "fore skin";
// gallbladder
final static String gallbladderPrintName = "gallbladder";
// genitalia
final static String genitaliaPrintName = "genitalia";
// glands
final static String glandsPrintName = "glands";
// glansPenis
final static String glansPenisPrintName = "glans penis";
// groin
final static String groinPrintName = "groin";
// gums
final static String gumsPrintName = "gums";
// hands
final static String handsPrintName = "hands";
// head
final static String headPrintName = "head";
// heart
final static String heartPrintName = "heart";
// hips
final static String hipsPrintName = "hips";
// indexToes
final static String indexToesPrintName = "index toes";
// indexes
final static String indexesPrintName = "indexes";
// intestines
final static String intestinesPrintName = "intestines";
// jaws
final static String jawsPrintName = "jaws";
// joints
final static String jointsPrintName = "joints";
// kidneys
final static String kidneysPrintName = "kidneys";
// knees
final static String kneesPrintName = "knees";
// labia
final static String labiaPrintName = "labia";
// largeIntestine
final static String largeIntestinePrintName = "large intestine";
// largeToes
final static String largeToesPrintName = "large toes";
// larynx
final static String larynxPrintName = "larynx";
// leftAnkle
final static String leftAnklePrintName = "left ankle";
// leftArm
final static String leftArmPrintName = "left arm";
// leftArmPit
final static String leftArmPitPrintName = "left arm pit";
// leftBreast
final static String leftBreastPrintName = "left breast";
// leftEar
final static String leftEarPrintName = "left ear";
// leftElbow
final static String leftElbowPrintName = "left elbow";
// leftEye
final static String leftEyePrintName = "left eye";
// leftFingers
final static String leftFingersPrintName = "left fingers";
// leftFoot
final static String leftFootPrintName = "left foot";
// leftHand
final static String leftHandPrintName = "left hand";
// leftHip
final static String leftHipPrintName = "left hip";
// leftIndex
final static String leftIndexPrintName = "left index";
// leftIndexToe
final static String leftIndexToePrintName = "left index toe";
// leftJaw
final static String leftJawPrintName = "left jaw";
// leftJoints
final static String leftJointsPrintName = "left joints";
// leftKidney
final static String leftKidneyPrintName = "left kidney";
// leftKnee
final static String leftKneePrintName = "left knee";
// leftLargeToe
final static String leftLargeToePrintName = "left large toe";
// leftLeg
final static String leftLegPrintName = "left leg";
// leftLowerArm
final static String leftLowerArmPrintName = "left lower arm";
// leftLowerLeg
final static String leftLowerLegPrintName = "left lower leg";
// leftLung
final static String leftLungPrintName = "left lung";
// leftMiddleFinger
final static String leftMiddleFingerPrintName = "left middle finger";
// leftMiddleToe
final static String leftMiddleToePrintName = "left middle toe";
// leftNipple
final static String leftNipplePrintName = "left nipple";
// leftOvary
final static String leftOvaryPrintName = "left ovary";
// leftPalm
final static String leftPalmPrintName = "left palm";
// leftPink
final static String leftPinkPrintName = "left pink";
// leftPinkToe
final static String leftPinkToePrintName = "left pink toe";
// leftRingFinger
final static String leftRingFingerPrintName = "left ring finger";
// leftRingToe
final static String leftRingToePrintName = "left ring toe";
// leftShoulder
final static String leftShoulderPrintName = "left shoulder";
// leftTesticle
final static String leftTesticlePrintName = "left testicle";
// leftThumb
final static String leftThumbPrintName = "left thumb";
// leftToes
final static String leftToesPrintName = "left toes";
// leftUpperArm
final static String leftUpperArmPrintName = "left upper arm";
// leftUpperLeg
final static String leftUpperLegPrintName = "left upper leg";
// leftWrist
final static String leftWristPrintName = "left wrist";
// legs
final static String legsPrintName = "legs";
// limbs
final static String limbsPrintName = "limbs";
// lips
final static String lipsPrintName = "lips";
// liver
final static String liverPrintName = "liver";
// lowerArms
final static String lowerArmsPrintName = "lower arms";
// lowerLegs
final static String lowerLegsPrintName = "lower legs";
// lumbar
final static String lumbarPrintName = "lumbar";
// lungs
final static String lungsPrintName = "lungs";
// lymphNodes
final static String lymphNodesPrintName = "lymph nodes";
// mammaryGlands
final static String mammaryGlandsPrintName = "mammary glands";
// middleFingers
final static String middleFingersPrintName = "middle fingers";
// middleToes
final static String middleToesPrintName = "middle toes";
// mind
final static String mindPrintName = "mind";
// mouth
final static String mouthPrintName = "mouth";
// mucousMembranes
final static String mucousMembranesPrintName = "mucous membranes";
// myocardium
final static String myocardiumPrintName = "myocardium";
// nails
final static String nailsPrintName = "nails";
// nape
final static String napePrintName = "nape";
// navel
final static String navelPrintName = "navel";
// neck
final static String neckPrintName = "neck";
// neckLymphNode
final static String neckLymphNodePrintName = "neck lymph node";
// neckVeins
final static String neckVeinsPrintName = "neck veins";
// nerves
final static String nervesPrintName = "nerves";
// nipples
final static String nipplesPrintName = "nipples";
// nipplesFemale
final static String nipplesFemalePrintName = "nipples female";
// nose
final static String nosePrintName = "nose";
// noseSeptum
final static String noseSeptumPrintName = "nose septum";
// ovaries
final static String ovariesPrintName = "ovaries";
// palate
final static String palatePrintName = "palate";
// palms
final static String palmsPrintName = "palms";
// pancreas
final static String pancreasPrintName = "pancreas";
// parathyroids
final static String parathyroidsPrintName = "parathyroids";
// parotidGlands
final static String parotidGlandsPrintName = "parotid glands";
// pelvis
final static String pelvisPrintName = "pelvis";
// penis
final static String penisPrintName = "penis";
// pericardium
final static String pericardiumPrintName = "pericardium";
// perineum
final static String perineumPrintName = "perineum";
// perineumVulvaVagina
final static String perineumVulvaVaginaPrintName = "perineum vulva vagina";
// peritoneum
final static String peritoneumPrintName = "peritoneum";
// phalanges
final static String phalangesPrintName = "phalanges";
// pinkToes
final static String pinkToesPrintName = "pink toes";
// pinks
final static String pinksPrintName = "pinks";
// pituitary
final static String pituitaryPrintName = "pituitary";
// placenta
final static String placentaPrintName = "placenta";
// pleura
final static String pleuraPrintName = "pleura";
// prostate
final static String prostatePrintName = "prostate";
// pubis
final static String pubisPrintName = "pubis";
// pulmonaryArteries
final static String pulmonaryArteriesPrintName = "pulmonary arteries";
// pupils
final static String pupilsPrintName = "pupils";
// rectum
final static String rectumPrintName = "rectum";
// retinas
final static String retinasPrintName = "retinas";
// ribCage
final static String ribCagePrintName = "rib cage";
// rightAnkle
final static String rightAnklePrintName = "right ankle";
// rightArm
final static String rightArmPrintName = "right arm";
// rightArmPit
final static String rightArmPitPrintName = "right arm pit";
// rightBreast
final static String rightBreastPrintName = "right breast";
// rightEar
final static String rightEarPrintName = "right ear";
// rightElbow
final static String rightElbowPrintName = "right elbow";
// rightEye
final static String rightEyePrintName = "right eye";
// rightFingers
final static String rightFingersPrintName = "right fingers";
// rightFoot
final static String rightFootPrintName = "right foot";
// rightHand
final static String rightHandPrintName = "right hand";
// rightHip
final static String rightHipPrintName = "right hip";
// rightIndex
final static String rightIndexPrintName = "right index";
// rightIndexToe
final static String rightIndexToePrintName = "right index toe";
// rightJaw
final static String rightJawPrintName = "right jaw";
// rightJoints
final static String rightJointsPrintName = "right joints";
// rightKidney
final static String rightKidneyPrintName = "right kidney";
// rightKnee
final static String rightKneePrintName = "right knee";
// rightLargeToe
final static String rightLargeToePrintName = "right large toe";
// rightLeg
final static String rightLegPrintName = "right leg";
// rightLowerArm
final static String rightLowerArmPrintName = "right lower arm";
// rightLowerLeg
final static String rightLowerLegPrintName = "right lower leg";
// rightLung
final static String rightLungPrintName = "right lung";
// rightMiddleFinger
final static String rightMiddleFingerPrintName = "right middle finger";
// rightMiddleToe
final static String rightMiddleToePrintName = "right middle toe";
// rightNipple
final static String rightNipplePrintName = "right nipple";
// rightOvary
final static String rightOvaryPrintName = "right ovary";
// rightPalm
final static String rightPalmPrintName = "right palm";
// rightPink
final static String rightPinkPrintName = "right pink";
// rightPinkToe
final static String rightPinkToePrintName = "right pink toe";
// rightRingFinger
final static String rightRingFingerPrintName = "right ring finger";
// rightRingToe
final static String rightRingToePrintName = "right ring toe";
// rightShoulder
final static String rightShoulderPrintName = "right shoulder";
// rightTesticle
final static String rightTesticlePrintName = "right testicle";
// rightThumb
final static String rightThumbPrintName = "right thumb";
// rightToes
final static String rightToesPrintName = "right toes";
// rightUpperArm
final static String rightUpperArmPrintName = "right upper arm";
// rightUpperLeg
final static String rightUpperLegPrintName = "right upper leg";
// rightWrist
final static String rightWristPrintName = "right wrist";
// ringFingers
final static String ringFingersPrintName = "ring fingers";
// ringToes
final static String ringToesPrintName = "ring toes";
// scalp
final static String scalpPrintName = "scalp";
// scrotum
final static String scrotumPrintName = "scrotum";
// shoulders
final static String shouldersPrintName = "shoulders";
// shins
final static String shinsPrintName = "shins";
// sinus
final static String sinusPrintName = "sinus";
// skin
final static String skinPrintName = "skin";
// skinOfGenital
final static String skinOfGenitalPrintName = "skin of genital";
// skull
final static String skullPrintName = "skull";
// smallIntestine
final static String smallIntestinePrintName = "small intestine";
// spine
final static String spinePrintName = "spine";
// spleen
final static String spleenPrintName = "spleen";
// stomach
final static String stomachPrintName = "stomach";
// teeth
final static String teethPrintName = "teeth";
// testicles
final static String testiclesPrintName = "testicles";
// thighs
final static String thighsPrintName = "thighs";
// throat
final static String throatPrintName = "throat";
// thumbs
final static String thumbsPrintName = "thumbs";
// thyroid
final static String thyroidPrintName = "thyroid";
// toeNails
final static String toeNailsPrintName = "toe nails";
// toes
final static String toesPrintName = "toes";
// tongue
final static String tonguePrintName = "tongue";
// tonsils
final static String tonsilsPrintName = "tonsils";
// torso
final static String torsoPrintName = "torso";
// trachea
final static String tracheaPrintName = "trachea";
// umbilicus
final static String umbilicusPrintName = "umbilicus";
// upperArms
final static String upperArmsPrintName = "upper arms";
// upperLegs
final static String upperLegsPrintName = "upper legs";
// urethraFM
final static String urethraFMPrintName = "urethra female";
// urethraML
final static String urethraMLPrintName = "urethra male";
// urethralExitFM
final static String urethralExitFMPrintName = "urethral exit female";
// urethralExitML
final static String urethralExitMLPrintName = "urethral exit male";
// uterus
final static String uterusPrintName = "uterus";
// vagina
final static String vaginaPrintName = "vagina";
// vocalCords
final static String vocalCordsPrintName = "vocal cords";
// vulva
final static String vulvaPrintName = "vulva";
// wrists
final static String wristsPrintName = "wrists";


  // ---------------- systems ---------------- 

// adrenalSys
final static String adrenalSysPrintName = "adrenal system";
final static String adrenalSysDescription = "hormones for stress/ fight-flight response/ blood pressure heart rate";
// anklesSys
final static String anklesSysPrintName = "ankles system";
final static String anklesSysDescription = "ankles";
// appendixSys
final static String appendixSysPrintName = "appendix system";
final static String appendixSysDescription = "appendix";
// armsSys
final static String armsSysPrintName = "arms system";
final static String armsSysDescription = "supports grasping";
// autonomicNervousSys
final static String autonomicNervousSysPrintName = "autonomic nervous system";
final static String autonomicNervousSysDescription = "regulates involuntary functioning of the organs";
// bladderSys
final static String bladderSysPrintName = "bladder system";
final static String bladderSysDescription = "urine container";
// bodySys
final static String bodySysPrintName = "body system";
final static String bodySysDescription = "the root system";
// brainSys
final static String brainSysPrintName = "brain system";
final static String brainSysDescription = "center for conscious and unconscious mental processing";
// breastsSys
final static String breastsSysPrintName = "breasts system";
final static String breastsSysDescription = "source of milk in females";
// cardioVascularSys
final static String cardioVascularSysPrintName = "cardio vascular system";
final static String cardioVascularSysDescription = "Transport system for oxygen, nutrients, waste, & hormones";
// centralNervousSys
final static String centralNervousSysPrintName = "central nervous system";
final static String centralNervousSysDescription = "the control center made up of the brain and the spine";
// cervixSys
final static String cervixSysPrintName = "cervix system";
final static String cervixSysDescription = "portal of the birth canal at the bottom of the uterus";
// clitorisSys
final static String clitorisSysPrintName = "clitoris system";
final static String clitorisSysDescription = "female mini penis";
// colonSys
final static String colonSysPrintName = "colon system";
final static String colonSysDescription = "between the small intestine and the rectum";
// cranialNerve5thSys
final static String cranialNerve5thSysPrintName = "cranial 5th nerve system";
final static String cranialNerve5thSysDescription = "sensors for the skin on the head";
// cranialNerve7thSys
final static String cranialNerve7thSysPrintName = "cranial 7th nerve system";
final static String cranialNerve7thSysDescription = "motoric control of the face muscles";
// earsSys
final static String earsSysPrintName = "ears system";
final static String earsSysDescription = "the ears";
// elbowsSys
final static String elbowsSysPrintName = "elbows system";
final static String elbowsSysDescription = "elbows";
// endocrineSys
final static String endocrineSysPrintName = "endocrine system";
final static String endocrineSysDescription = "provides chemical control through hormones";
// endometriumSys
final static String endometriumSysPrintName = "endometrium system";
final static String endometriumSysDescription = "lining of the uterus";
// epididymisSysSt
final static String epididymisSysPrintName = "epididymis system";
final static String epididymisSysDescription = "storage of sperm";
// esophagusSys
final static String esophagusSysPrintName = "esophagus system";
final static String esophagusSysDescription = "food track between the mouth/ pharynx and the stomach";
// exocrineGlandsSys
final static String exocrineGlandsSysPrintName = "exocrineGlands system";
final static String exocrineGlandsSysDescription = "glands that secrete through a duct";
// eyesSys
final static String eyesSysPrintName = "eyes system";
final static String eyesSysDescription = "the eyes";
// faceSys
final static String faceSysPrintName = "face system";
final static String faceSysDescription = "face part of the skin";
// fallopianTubesSys
final static String fallopianTubesSysPrintName = "fallopianTubes system";
final static String fallopianTubesSysDescription = "fallopian tubes - conduit for sperm and eggs";
// feetSys
final static String feetSysPrintName = "feet system";
final static String feetSysDescription = "part of the walking function";
// fingerNailsSys
final static String fingerNailsSysPrintName = "fingerNails system";
final static String fingerNailsSysDescription = "nail functionality";
// gallbladderSys
final static String gallbladderSysPrintName = "gallbladder system";
final static String gallbladderSysDescription = "appendix of the liver that stores bile";
// gastrointestinalSys
final static String gastrointestinalSysPrintName = "gastrointestinal system";
final static String gastrointestinalSysDescription = "all foot processing subsystems from the mouth upto the anorectum";
// glandsSys
final static String glandsSysPrintName = "glands system";
final static String glandsSysDescription = "secretes stuff";
// groinSys
final static String groinSysPrintName = "groin system";
final static String groinSysDescription = "groin region";
// gynecologicSys
final static String gynecologicSysPrintName = "gynecologic system";
final static String gynecologicSysDescription = "female procreation apparatus";
// hairSys
final static String hairSysPrintName = "hair system";
final static String hairSysDescription = "body hair";
// heartSys
final static String heartSysPrintName = "heart system";
final static String heartSysDescription = "blood pump";
// hematologicSys
final static String hematologicSysPrintName = "hematologic system";
final static String hematologicSysDescription = "the blood transportation facility";
// hepatobiliarySys
final static String hepatobiliarySysPrintName = "hepatobiliary system";
final static String hepatobiliarySysDescription = "liver and gallbladder";
// immuneSys
final static String immuneSysPrintName = "immune system";
final static String immuneSysDescription = "physical & chemical barriers and inflammatory & immune responses";
// intestinesSys
final static String intestinesSysPrintName = "intestines system";
final static String intestinesSysDescription = "last section of the mouth-rectum trajectory";
// jointsSys
final static String jointsSysPrintName = "joints system";
final static String jointsSysDescription = "joints";
// largeIntestineSys
final static String largeIntestineSysPrintName = "large intestine system";
final static String largeIntestineSysDescription = "end of the food track following the small intestines";
// largeToesSys
final static String largeToesSysPrintName = "largeToes system";
final static String largeToesSysDescription = "part of the walking function";
// larynxSys
final static String larynxSysPrintName = "larynx system";
final static String larynxSysDescription = "connects mouth and trachea and has vocal cords";
// leftKidneySys
final static String leftKidneySysPrintName = "left kidney system";
final static String leftKidneySysDescription = "eliminate waste through urine formation";
// leftLungSys
final static String leftLungSysPrintName = "left lung system";
final static String leftLungSysDescription = "concrete system to extract CO2 from and insert O2 into the bloodstream";
// legsSys
final static String legsSysPrintName = "legs system";
final static String legsSysDescription = "supports walking";
// limbsSys
final static String limbsSysPrintName = "limbs system";
final static String limbsSysDescription = "supports walking  and grasping";
// liverSys
final static String liverSysPrintName = "liver system";
final static String liverSysDescription = "100+ functions by this organ";
// lungsSys
final static String lungsSysPrintName = "lungs system";
final static String lungsSysDescription = "abstract system to extract CO2 from and insert O2 into the bloodstream";
// lymphSys
final static String lymphSysPrintName = "lymph system";
final static String lymphSysDescription = "collection of lymph nodes as part of the immune system";
// mammaryGlandsSys
final static String mammaryGlandsSysPrintName = "mammaryGlands system";
final static String mammaryGlandsSysDescription = "provides milk to a new born";
// metabolicSys
final static String metabolicSysPrintName = "metabolic system";
final static String metabolicSysDescription = "transform food into energy and rebuild cells";
// mindSys
final static String mindSysPrintName = "mind system";
final static String mindSysDescription = 
    "site of consciousness, cognitive operations, emotional states, moods, etc.";
// mouthSys
final static String mouthSysPrintName = "mouth system";
final static String mouthSysDescription = "start of the gastrointestinal trajectory";
// muscleSys
final static String muscleSysPrintName = "muscle system";
final static String muscleSysDescription = "muscles";
// musculoSkeletalSys
final static String musculoSkeletalSysPrintName = "musculo skeletal system";
final static String musculoSkeletalSysDescription = 
    "bones, muscles, ligaments, tendons & other connective tissues";
// nailsSys
final static String nailsSysPrintName = "nails system";
final static String nailsSysDescription = "nail functionality";
// neurologicSys
final static String neurologicSysPrintName = "neurologic system";
final static String neurologicSysDescription = "communications network of the body";
// noseSys
final static String noseSysPrintName = "nose system";
final static String noseSysDescription = "entry point for O2 and exit point for CO2";
// ovariesSys
final static String ovariesSysPrintName = "ovaries system";
final static String ovariesSysDescription = "produces estrogen and progesterone";
// pancreasSys
final static String pancreasSysPrintName = "pancreas system";
final static String pancreasSysDescription = "provides glucagon and insulin";
// parathyroidSys
final static String parathyroidSysPrintName = "parathyroid system";
final static String parathyroidSysDescription = "provides PTH that regulates calcium and phosphate metabolism";
// pelvisSys
final static String pelvisSysPrintName = "pelvis system";
final static String pelvisSysDescription = "pelvis region";
// penisxSys
final static String penisxSysPrintName = "penisx system";
final static String penisxSysDescription = "male maxi clitoris";
// perineumVulvaVaginaSys
final static String perineumVulvaVaginaSysPrintName = "perineumVulvaVagina system";
final static String perineumVulvaVaginaSysDescription = "female genitalia subject to infection";
// peripheralNervousSys
final static String peripheralNervousSysPrintName = "peripheral nervous system";
final static String peripheralNervousSysDescription = "motor & sensory nerves that connect to the CNS";
// peritoneumSys
final static String peritoneumSysPrintName = "peritoneum system";
final static String peritoneumSysDescription = "membrane that lines the abdominal cavity";
// pharynxSys
final static String pharynxSysPrintName = "pharynx system";
final static String pharynxSysDescription = "food track that connects the mouth with the esophagus";
// pituitarySys
final static String pituitarySysPrintName = "pituitary system";
final static String pituitarySysDescription = "produces hormones under neural (hypothalamus) control";
// placentaSys
final static String placentaSysPrintName = "placenta system";
final static String placentaSysDescription = "vascular organ that develops in pregancy that envelops the fetus";
// prostateSys
final static String prostateSysPrintName = "prostate system";
final static String prostateSysDescription = "creates seminal fluid";
// pubisHairSys
final static String pubisHairSysPrintName = "pubisHair system";
final static String pubisHairSysDescription = "pubis hair";
// pulmonaryArterySys
final static String pulmonaryArterySysPrintName = "pulmonary artery system";
final static String pulmonaryArterySysDescription = "arteries in the lungs";
// rectumSys
final static String rectumSysPrintName = "rectum system";
final static String rectumSysDescription = "last segment of the intestines";
// renalSys
final static String renalSysPrintName = "renal system";
final static String renalSysDescription = "kidneys";
// respiratorySys
final static String respiratorySysPrintName = "respiratory system";
final static String respiratorySysDescription = "abstract system to expel CO2 and absorb O2";
// rightKidneySys
final static String rightKidneySysPrintName = "right kidney system";
final static String rightKidneySysDescription = "eliminate waste through urine formation";
// rightLungSys
final static String rightLungSysPrintName = "right lung system";
final static String rightLungSysDescription = "concrete system to extract CO2 from and insert O2 into the bloodstream";
// scalpSys
final static String scalpSysPrintName = "scalp system";
final static String scalpSysDescription = "top part of the head";
// sexualSys
final static String sexualSysPrintName = "sexual system";
final static String sexualSysDescription = "procreation and recreation";
// skeletalSys
final static String skeletalSysPrintName = "skeletal system";
final static String skeletalSysDescription = "the human skeleton has 206 bones";
// skinSys
final static String skinSysPrintName = "skin system";
final static String skinSysDescription = "the skin";
// smallIntestineSys
final static String smallIntestineSysPrintName = "small intestine system";
final static String smallIntestineSysDescription = "part of the food track between the stomach and the large intestines";
// spineSys
final static String spineSysPrintName = "spine system";
final static String spineSysDescription = "path way from the brain to the peripheral nervous system & reflexes";
// spleenSys
final static String spleenSysPrintName = "spleen system";
final static String spleenSysDescription = "filters the blood as part of the immune system";
// stomachSys
final static String stomachSysPrintName = "stomach system";
final static String stomachSysDescription = "part of the food track between the esphagus and the small intestines";
// testesSys
final static String testesSysPrintName = "testes system";
final static String testesSysDescription = "provides testosterone and sperm";
// throatSys
final static String throatSysPrintName = "throat system";
final static String throatSysDescription = "the throat";
// thyroidSys
final static String thyroidSysPrintName = "thyroid system";
final static String thyroidSysDescription = "hormones for growth, metabolic level & protein synthesis";
// toeNailsSys
final static String toeNailsSysPrintName = "toeNails system";
final static String toeNailsSysDescription = "nail functionality";
// tongueSys
final static String tongueSysPrintName = "tongue system";
final static String tongueSysDescription = "food swallower, site of sensory elemensts and speech organ";
// tonsilsSys
final static String tonsilsSysPrintName = "tonsils system";
final static String tonsilsSysDescription = "function of the tonsils";
// tracheaSys
final static String tracheaSysPrintName = "trachea system";
final static String tracheaSysDescription = "conduit between lungs and nose";
// urethraFMSys
final static String urethraFMSysPrintName = "urethraFM system";
final static String urethraFMSysDescription = "urine exit conduit";
// urethraMLSys
final static String urethraMLSysPrintName = "urethraML system";
final static String urethraMLSysDescription = "urine and semen conduit";
// urologicSys
final static String urologicSysPrintName = "urologic system";
final static String urologicSysDescription = "urine storage and release";
// uterusSys
final static String uterusSysPrintName = "uterus system";
final static String uterusSysDescription = "location in which fertilized egg grows";
// vaginagySys
final static String vaginagySysPrintName = "vaginagy system";
final static String vaginagySysDescription = "passageway for sperm, menstrual fluid and childbirth";
// vaginasxSys
final static String vaginasxSysPrintName = "vaginasx system";
final static String vaginasxSysDescription = "the sexual view";
// vascularSys
final static String vascularSysPrintName = "vascular system";
final static String vascularSysDescription = "arteries and veins";
// vulvaSys
final static String vulvaSysPrintName = "vulva system";
final static String vulvaSysDescription = "exit of the vagina";
// wristsSys
final static String wristsSysPrintName = "wrists system";
final static String wristsSysDescription = "wrists";


  // ---------------- symptoms ---------------- 

// abdomenBloating
final static String abdomenBloatingPrintName = "abdomen bloating";
final static String abdomenBloatingDescription = abdomenBloatingPrintName;
// abdomenCramping
final static String abdomenCrampingPrintName = "abdomen cramping";
final static String abdomenCrampingDescription = abdomenCrampingPrintName;
// abdomenDistension
final static String abdomenDistensionPrintName = "abdomen distension";
final static String abdomenDistensionDescription = abdomenDistensionPrintName;
// abdomenMassPalpable
final static String abdomenMassPalpablePrintName = "abdomen mass palpable";
final static String abdomenMassPalpableDescription = "felt mass in abdomen";
// abdomenPain
final static String abdomenPainPrintName = "abdomen pain";
final static String abdomenPainDescription = abdomenPainPrintName;
// abdomenPainLowerLeftSide
final static String abdomenPainLowerLeftSidePrintName = "abdomen pain lower left side";
final static String abdomenPainLowerLeftSideDescription = abdomenPainLowerLeftSidePrintName;
// abdomenPainLowerRightSide
final static String abdomenPainLowerRightSidePrintName = "abdomen pain lower right side";
final static String abdomenPainLowerRightSideDescription = abdomenPainLowerRightSidePrintName;
// abdomenPainLowerSide
final static String abdomenPainLowerSidePrintName = "abdomen pain lower side";
final static String abdomenPainLowerSideDescription = abdomenPainLowerSidePrintName;
// abdomenPainSuddenSevere
final static String abdomenPainSuddenSeverePrintName = "sudden severe abdomen pain";
final static String abdomenPainSuddenSevereDescription = abdomenPainSuddenSeverePrintName;
// abdomenPainUpperRightSide
final static String abdomenPainUpperRightSidePrintName = "abdomen pain upper right side";
final static String abdomenPainUpperRightSideDescription = abdomenPainUpperRightSidePrintName;
// abdomenPainUpperSide
final static String abdomenPainUpperSidePrintName = "abdomen pain upper side";
final static String abdomenPainUpperSideDescription = abdomenPainUpperSidePrintName;
// abdomenRigidity
final static String abdomenRigidityPrintName = "abdomen rigidity";
final static String abdomenRigidityDescription = abdomenRigidityPrintName;
// abdomenTenderness
final static String abdomenTendernessPrintName = "abdomen tenderness";
final static String abdomenTendernessDescription = abdomenTendernessPrintName;
// abortionSpontaneous
final static String abortionSpontaneousPrintName = "abortion spontaneous";
final static String abortionSpontaneousDescription = abortionSpontaneousPrintName;
// abstractThinkingImpaired
final static String abstractThinkingImpairedPrintName = "abstract thinking impaired";
final static String abstractThinkingImpairedDescription = abstractThinkingImpairedPrintName;
// acne
final static String acnePrintName = "acne";
final static String acneDescription = 
    "acne -> inflammation of oil glands on the face and elsewhere";
// adultHairPattern
final static String adultHairPatternPrintName = "hair pattern adult";
final static String adultHairPatternDescription = adultHairPatternPrintName;
// aggression
final static String aggressionPrintName = "aggression";
final static String aggressionDescription = aggressionPrintName;
// agitation
final static String agitationPrintName = "agitation";
final static String agitationDescription = agitationPrintName;
// airHunger
final static String airHungerPrintName = "gasping";
final static String airHungerDescription = "air hunger"; 
// akinesia
final static String akinesiaPrintName = "muscle control impaired";
final static String akinesiaDescription = akinesiaPrintName;
// alertnessHigh
final static String alertnessHighPrintName = "alertness high";
final static String alertnessHighDescription = alertnessHighPrintName;
// amnesia
final static String amnesiaPrintName = "memory loss";
final static String amnesiaDescription = amnesiaPrintName; 
// amnioticMembraneRupture
final static String amnioticMembraneRupturePrintName = "breaking the water";
final static String amnioticMembraneRuptureDescription = amnioticMembraneRupturePrintName;
// anginaPain
final static String anginaPainPrintName = "severe chest pain";
final static String anginaPainDescription = anginaPainPrintName;
// angry
final static String angryPrintName = "angry";
final static String angryDescription = angryPrintName;
// anklePain
final static String anklePainPrintName = "ankle pain";
final static String anklePainDescription = anklePainPrintName;
// anorexia
final static String anorexiaPrintName = "anorexia -> appetite loss";
final static String anorexiaDescription = anorexiaPrintName;
// anuria
final static String anuriaPrintName = "urination absent";
final static String anuriaDescription = anuriaPrintName;
// anusChancre
final static String anusChancrePrintName = "anus chancre";
final static String anusChancreDescription = "small fluid filled lesion";
// anusDischargeBloody = rectumBloodyDischarge
    // final static String anusDischargeBloodyPrintName = "anus discharge bloody";
    // final static String anusDischargeBloodyDescription = anusDischargeBloodyPrintName;
// anusDischargeMucopurulent
final static String anusDischargeMucopurulentPrintName = "anus discharge pussy";
final static String anusDischargeMucopurulentDescription = anusDischargeMucopurulentPrintName;
// anusLesion
final static String anusLesionPrintName = "anus lesion";
final static String anusLesionDescription = anusLesionPrintName;
// anxiety
final static String anxietyPrintName = "anxiety";
final static String anxietyDescription = anxietyPrintName;
// apathy
final static String apathyPrintName = "apathy";
final static String apathyDescription = apathyPrintName;
// aphasia
final static String aphasiaPrintName = "language use impaired";
final static String aphasiaDescription = aphasiaPrintName;
// apnea
final static String apneaPrintName = "breathing stops intermittently";
final static String apneaDescription = apneaPrintName;
// appetiteIncrease
final static String appetiteIncreasePrintName = "appetite increase";
final static String appetiteIncreaseDescription = appetiteIncreasePrintName;
// appetiteLoss
final static String appetiteLossPrintName = "appetite loss";
final static String appetiteLossDescription = appetiteLossPrintName;
// apprehension
final static String apprehensionPrintName = "apprehension";
final static String apprehensionDescription = "anticipate with anxiety";
// armPain
final static String armPainPrintName = "arm pain";
final static String armPainDescription = armPainPrintName;
// armPitPain
final static String armPitPainPrintName = "arm pit pain";
final static String armPitPainDescription = armPitPainPrintName;
// armWeakness
final static String armWeaknessPrintName = "arm weakness";
final static String armWeaknessDescription = armWeaknessPrintName;
// arrhythmia
final static String arrhythmiaPrintName = "heartbeat rhythm alterations";
final static String arrhythmiaDescription = arrhythmiaPrintName;
// arthralgia
final static String arthralgiaPrintName = "joint neuralgic pain";
final static String arthralgiaDescription = arthralgiaPrintName;
// asterixis
final static String asterixisPrintName = "hand tremor";
final static String asterixisDescription = "flapping tremor of the hand and wrist";
// ataxia
final static String ataxiaPrintName = "muscles incordinated";
final static String ataxiaDescription = ataxiaPrintName;
// atrophicVulvitis
final static String atrophicVulvitisPrintName = "vulva shrinkage";
final static String atrophicVulvitisDescription = atrophicVulvitisPrintName;
// backArched
final static String backArchedPrintName = "back arched";
final static String backArchedDescription = backArchedPrintName;
// backPain
final static String backPainPrintName = "back pain";
final static String backPainDescription = backPainPrintName;
// backStiff
final static String backStiffPrintName = "back stiff";
final static String backStiffDescription = backStiffPrintName;
// barrelChest
final static String barrelChestPrintName = "chest barrel shaped";
final static String barrelChestDescription = barrelChestPrintName;
// beardSkinLesions
final static String beardSkinLesionsPrintName = "beard skin lesions";
final static String beardSkinLesionsDescription = beardSkinLesionsPrintName;
// behaviorDisorganized
final static String behaviorDisorganizedPrintName = "behavior disorganized";
final static String behaviorDisorganizedDescription = behaviorDisorganizedPrintName;
// belching
final static String belchingPrintName = "belching";
final static String belchingDescription = belchingPrintName;
// bingeEating
final static String bingeEatingPrintName = "binge eating";
final static String bingeEatingDescription = bingeEatingPrintName;
// biteMarksRed
final static String biteMarksRedPrintName = "bite marks red";
final static String biteMarksRedDescription = biteMarksRedPrintName;
// bladderCramp
final static String bladderCrampPrintName = "bladder cramp";
final static String bladderCrampDescription = bladderCrampPrintName;
// bladderIrritability
final static String bladderIrritabilityPrintName = "bladder irritability";
final static String bladderIrritabilityDescription = bladderIrritabilityPrintName;
// bladderPain
final static String bladderPainPrintName = "bladder pain";
final static String bladderPainDescription = bladderPainPrintName;
// bladderPressure
final static String bladderPressurePrintName = "bladder pressure";
final static String bladderPressureDescription = bladderPressurePrintName;
// bleb
final static String blebPrintName = "bleb";
final static String blebDescription = "large blister";
// bleedingAbnormal
final static String bleedingAbnormalPrintName = "bleeding abnormal";
final static String bleedingAbnormalDescription = bleedingAbnormalPrintName;
// bleedingFromMouth
final static String bleedingFromMouthPrintName = "bleeding from mouth";
final static String bleedingFromMouthDescription = bleedingFromMouthPrintName;
// bleedingFromNose
final static String bleedingFromNosePrintName = "bleeding from nose";
final static String bleedingFromNoseDescription = bleedingFromNosePrintName;
// bleedingFromRectum
final static String bleedingFromRectumPrintName = "bleeding from rectum";
final static String bleedingFromRectumDescription = bleedingFromRectumPrintName;
// bleedingFromVagina
final static String bleedingFromVaginaPrintName = "bleeding from vagina";
final static String bleedingFromVaginaDescription = bleedingFromVaginaPrintName;
// bleedingFromVaginaAbnormal
final static String bleedingFromVaginaAbnormalPrintName = "bleeding abnormal from vagina";
final static String bleedingFromVaginaAbnormalDescription = bleedingFromVaginaAbnormalPrintName;
// bleedingFromVaginaProfuse
final static String bleedingFromVaginaProfusePrintName = "bleeding profuse from vagina";
final static String bleedingFromVaginaProfuseDescription = bleedingFromVaginaProfusePrintName;
// bleedingFromVaginaSlight
final static String bleedingFromVaginaSlightPrintName = "bleeding slight from vagina";
final static String bleedingFromVaginaSlightDescription = bleedingFromVaginaSlightPrintName;
// bleedingGestation2ndHalf
final static String bleedingGestation2ndHalfPrintName = "bleeding gestation 2nd half";
final static String bleedingGestation2ndHalfDescription = bleedingGestation2ndHalfPrintName;
// bleedingProlonged
final static String bleedingProlongedPrintName = "bleeding prolonged";
final static String bleedingProlongedDescription = bleedingProlongedPrintName;
// bleedingSkull
final static String bleedingSkullPrintName = "bleeding skull";
final static String bleedingSkullDescription = bleedingSkullPrintName;
// bleedingSpontaneously
final static String bleedingSpontaneouslyPrintName = "bleeding spontaneously";
final static String bleedingSpontaneouslyDescription = bleedingSpontaneouslyPrintName;
// bleedingThirdTrimester
final static String bleedingThirdTrimesterPrintName = "bleeding third trimester";
final static String bleedingThirdTrimesterDescription = bleedingThirdTrimesterPrintName;
// bleedingVulva
final static String bleedingVulvaPrintName = "bleeding vulva";
final static String bleedingVulvaDescription = bleedingVulvaPrintName;
// blister
final static String blisterPrintName = "blister";
final static String blisterDescription = blisterPrintName;
// blisterSmallItch
final static String blisterSmallItchPrintName = "blister small itch";
final static String blisterSmallItchDescription = blisterSmallItchPrintName;
// blisterSmallOoze
final static String blisterSmallOozePrintName = "blister small ooze";
final static String blisterSmallOozeDescription = blisterSmallOozePrintName;
// blisterSmallScale
final static String blisterSmallScalePrintName = "blister small scale";
final static String blisterSmallScaleDescription = blisterSmallScalePrintName;
// bloating
final static String bloatingPrintName = "bloating";
final static String bloatingDescription = bloatingPrintName;
// bloodyWoundDischarge
final static String bloodyWoundDischargePrintName = "wound bloody discharge";
final static String bloodyWoundDischargeDescription = bloodyWoundDischargePrintName;
// blotchesRed
final static String blotchesRedPrintName = "blotches red";
final static String blotchesRedDescription = blotchesRedPrintName;
// BMIover30
final static String BMIover30PrintName = "body mass index over 30";
final static String BMIover30Description = BMIover30PrintName;
// bodyHairSparse
final static String bodyHairSparsePrintName = "body hair sparse";
final static String bodyHairSparseDescription = bodyHairSparsePrintName;
// bodyImageDistorted
final static String bodyImageDistortedPrintName = "body image distorted";
final static String bodyImageDistortedDescription = bodyImageDistortedPrintName;
// boneAgeImmature
final static String boneAgeImmaturePrintName = "bone age immature";
final static String boneAgeImmatureDescription = "bone development retarded";
// boneDevelopmentEarly
final static String boneDevelopmentEarlyPrintName = "bone development early";
final static String boneDevelopmentEarlyDescription = "early bone development";
// boneGumma
final static String boneGummaPrintName = "bone gumma";
final static String boneGummaDescription = "chronic tumor like rubbery nodule";
// bonePain
final static String bonePainDescription = "bone pain";
final static String bonePainPrintName = "bone pain";
// borborygmi
final static String borborygmiPrintName = "borborygmi";
final static String borborygmiDescription = "rumbling gurgling sounds from the abdomen";
// bowelActivityDecreased
final static String bowelActivityDecreasedPrintName = "bowel activity decreased";
final static String bowelActivityDecreasedDescription = bowelActivityDecreasedPrintName;
// bradycardia
final static String bradycardiaPrintName = "heartbeat too slow";
final static String bradycardiaDescription = bradycardiaPrintName;
// bradypnea
final static String bradypneaPrintName = "breathing slowed";
final static String bradypneaDescription = bradypneaPrintName;
// breastBonePain
final static String breastBonePainPrintName = "breast bone pain";
final static String breastBonePainDescription = breastBonePainPrintName;
// breastDevelopment
final static String breastDevelopmentPrintName = "breast development";
final static String breastDevelopmentDescription = breastDevelopmentPrintName;
// breastDischargeUnusual
final static String breastDischargeUnusualPrintName = "breast discharge unusual";
final static String breastDischargeUnusualDescription = breastDischargeUnusualPrintName;
// breastHard
final static String breastHardPrintName = "breast hard";
final static String breastHardDescription = breastHardPrintName;
// breastLump
final static String breastLumpPrintName = "breast lump";
final static String breastLumpDescription = breastLumpPrintName;
// breastPapule
final static String breastPapulePrintName = "breast papule";
final static String breastPapuleDescription = breastPapulePrintName;
// breastSizeChange
final static String breastSizeChangePrintName = "breast size change";
final static String breastSizeChangeDescription = breastSizeChangePrintName;
// breastSizeDecrease
final static String breastSizeDecreasePrintName = "breast size decrease";
final static String breastSizeDecreaseDescription = breastSizeDecreasePrintName;
// breastSkinAreaHot
final static String breastSkinAreaHotPrintName = "breast skin area hot";
final static String breastSkinAreaHotDescription = breastSkinAreaHotPrintName;
// breastSkinDimpling
final static String breastSkinDimplingPrintName = "breast skin dimpling";
final static String breastSkinDimplingDescription = breastSkinDimplingPrintName;
// breastSkinEdema
final static String breastSkinEdemaPrintName = "breast skin edema";
final static String breastSkinEdemaDescription = "breast skin swelling";
// breastSkinThickening
final static String breastSkinThickeningPrintName = "breast skin thickening";
final static String breastSkinThickeningDescription = breastSkinThickeningPrintName;
// breastSkinUlceration
final static String breastSkinUlcerationPrintName = "breast skin ulceration";
final static String breastSkinUlcerationDescription = breastSkinUlcerationPrintName;
// breastSwelling
final static String breastSwellingPrintName = "breast swelling";
final static String breastSwellingDescription = breastSwellingPrintName;
// breastTenderness
final static String breastTendernessPrintName = "breast tenderness";
final static String breastTendernessDescription = breastTendernessPrintName;
// breastWarm
final static String breastWarmPrintName = "breast warm";
final static String breastWarmDescription = breastWarmPrintName;
// breathAcetone
final static String breathAcetonePrintName = "breath acetone";
final static String breathAcetoneDescription = breathAcetonePrintName;
// breathFruity
final static String breathFruityPrintName = "breath fruity";
final static String breathFruityDescription = breathFruityPrintName;
// breathingAsymmetric
final static String breathingAsymmetricPrintName = "breathing asymmetric";
final static String breathingAsymmetricDescription = breathingAsymmetricPrintName;
// breathingDifficult
final static String breathingDifficultPrintName = "breathing difficult";
final static String breathingDifficultDescription = breathingDifficultPrintName;
// breathingShallow = respirationShallow
    // final static String breathingShallowPrintName = "breathing shallow";
    // final static String breathingShallowDescription = breathingShallowPrintName;
// breathStinking
final static String breathStinkingPrintName = "breath stinking";
final static String breathStinkingDescription = breathStinkingPrintName;
// breathlessness
final static String breathlessnessPrintName = "breathlessness";
final static String breathlessnessDescription = breathlessnessPrintName;
// bruising
final static String bruisingPrintName = "bruising";
final static String bruisingDescription = 
    "bruising -> rupture of small blood vessels in the skin";
// buffaloHump
final static String buffaloHumpPrintName = "buffalo hump";
final static String buffaloHumpDescription = "fad pads at the upper back side";
// bumpItchy
final static String bumpItchyPrintName = "bump itchy";
final static String bumpItchyDescription = bumpItchyPrintName;
// bunion
final static String bunionPrintName = "bunion";
final static String bunionDescription = "inflamed swelling inside a foot at the large toe";
// burningSensation
final static String burningSensationPrintName = "burning sensation";
final static String burningSensationDescription = burningSensationPrintName;
// burping
final static String burpingPrintName = "burping";
final static String burpingDescription = burpingPrintName;
// butterflyRash
final static String butterflyRashPrintName = "butterfly rash";
final static String butterflyRashDescription = 
    "butter fly rash on the nose and extending at both sides";
// buttockPain
final static String buttockPainPrintName = "buttock pain";
final static String buttockPainDescription = buttockPainPrintName;
// cachexia
final static String cachexiaPrintName = "muscle wasting";
final static String cachexiaDescription = cachexiaPrintName;
// cataract
final static String cataractPrintName = "cataract";
final static String cataractDescription = "clouding of the eye lens";
// catatonic
final static String catatonicPrintName = "catatonic";
final static String catatonicDescription = "posturing abnormal";
// cerebrospinalFluidLeakage
final static String cerebrospinalFluidLeakagePrintName = "cerebrospinal fluid leakage";
final static String cerebrospinalFluidLeakageDescription = 
    cerebrospinalFluidLeakagePrintName;
    /*
// cervixAdenopathy
final static String cervixAdenopathyPrintName = "cervix adenopathy";
final static String cervixAdenopathyDescription = 
    "problem with lymphoid tissue in the neck?";
    */
// cervixDilation
final static String cervixDilationPrintName = "cervix dilation";
final static String cervixDilationDescription = cervixDilationPrintName;
// cervixDischargeGreenYellow
final static String cervixDischargeGreenYellowPrintName = "cervix discharge green yellow";
final static String cervixDischargeGreenYellowDescription = cervixDischargeGreenYellowPrintName;
// cervixEdematous
final static String cervixEdematousPrintName = "cervix swollen";
final static String cervixEdematousDescription = cervixEdematousPrintName;
// cervixErosion
final static String cervixErosionPrintName = "cervix erosion";
final static String cervixErosionDescription = cervixErosionPrintName;
// cervixPapule
final static String cervixPapulePrintName = "cervix papule";
final static String cervixPapuleDescription = cervixPapulePrintName;
// cervixRed
final static String cervixRedPrintName = "cervix red";
final static String cervixRedDescription = cervixRedPrintName;
// cervixTenderness
final static String cervixTendernessPrintName = "cervix tenderness";
final static String cervixTendernessDescription = cervixTendernessPrintName;
// cervixVesicle
final static String cervixVesiclePrintName = "cervix blister";
final static String cervixVesicleDescription = cervixVesiclePrintName;
// cervixWarts
final static String cervixWartsPrintName = "cervix warts";
final static String cervixWartsDescription = cervixWartsPrintName;
// cheeksFlushed
final static String cheeksFlushedPrintName = "cheeks flushed";
final static String cheeksFlushedDescription = cheeksFlushedPrintName;
// chestPain
final static String chestPainPrintName = "chest pain";
final static String chestPainDescription = chestPainPrintName;
// chestPainSevere
final static String chestPainSeverePrintName = "chest pain severe";
final static String chestPainSevereDescription = chestPainSeverePrintName;
// chestTightness
final static String chestTightnessPrintName = "chest tightness";
final static String chestTightnessDescription = chestTightnessPrintName;
// chewingDifficult
final static String chewingDifficultPrintName = "chewing difficult";
final static String chewingDifficultDescription = chewingDifficultPrintName;
// chewingPainful
final static String chewingPainfulPrintName = "chewing painful";
final static String chewingPainfulDescription = chewingPainfulPrintName;
// chills
final static String chillsPrintName = "chills";
final static String chillsDescription = "disagreeable sensation of coldness";
// chillsSevere
final static String chillsSeverePrintName = "chills severe";
final static String chillsSevereDescription = "severe disagreeable sensation of coldness";
// choking
final static String chokingPrintName = "choking";
final static String chokingDescription = chokingPrintName;
// chokingFeeling
final static String chokingFeelingPrintName = "choking feeling";
final static String chokingFeelingDescription = chokingFeelingPrintName;
// clitorisEnlarged
final static String clitorisEnlargedPrintName = "clitoris enlarged";
final static String clitorisEnlargedDescription = clitorisEnlargedPrintName;
// clumsy
final static String clumsyPrintName = "clumsy";
final static String clumsyDescription = clumsyPrintName;
// coldIntolerance
final static String coldIntolerancePrintName = "cold intolerance";
final static String coldIntoleranceDescription = coldIntolerancePrintName;
// colonPain
final static String colonPainPrintName = "colon pain";
final static String colonPainDescription = colonPainPrintName;
// coma
final static String comaPrintName = "coma";
final static String comaDescription = comaPrintName;
// communicationImpaired
final static String communicationImpairedPrintName = "communication impaired";
final static String communicationImpairedDescription = communicationImpairedPrintName;
// compulsiveActions
final static String compulsiveActionsPrintName = "compulsive actions";
final static String compulsiveActionsDescription = compulsiveActionsPrintName;
// concentrationLoss
final static String concentrationLossPrintName = "concentration loss";
final static String concentrationLossDescription = concentrationLossPrintName;
// confusion
final static String confusionPrintName = "confusion";
final static String confusionDescription = confusionPrintName;
// consciousnessDecreased
final static String consciousnessDecreasedPrintName = "consciousness decreased";
final static String consciousnessDecreasedDescription = consciousnessDecreasedPrintName;
// consciousnessLoss
final static String consciousnessLossPrintName = "consciousness loss";
final static String consciousnessLossDescription = consciousnessLossPrintName;
// constipation
final static String constipationPrintName = "constipation";
final static String constipationDescription = constipationPrintName;
// contractionsAfterChildbirth
final static String contractionsAfterChildbirthPrintName = "contractions after childbirth";
final static String contractionsAfterChildbirthDescription = contractionsAfterChildbirthPrintName;
// convulsions
final static String convulsionsPrintName = "convulsions";
final static String convulsionsDescription = convulsionsPrintName;
// coolExtremities
final static String coolExtremitiesPrintName = "extremities cool";
final static String coolExtremitiesDescription = coolExtremitiesPrintName;
// coordinationDetoriation
final static String coordinationDetoriationPrintName = "coordination detoriation";
final static String coordinationDetoriationDescription = coordinationDetoriationPrintName;
// corneaCloudy
final static String corneaCloudyPrintName = "cornea cloudy";
final static String corneaCloudyDescription = corneaCloudyPrintName;
// corneaOpaque
final static String corneaOpaquePrintName = "cornea opaque";
final static String corneaOpaqueDescription = corneaOpaquePrintName;
// coryza
final static String coryzaPrintName = "coryza";
final static String coryzaDescription = "nose congestion loss of smell and watering of the eyes";
// cough
final static String coughPrintName = "cough";
final static String coughDescription = coughPrintName;
// coughBark
final static String coughBarkPrintName = "cough sharp barklike";
final static String coughBarkDescription = coughBarkPrintName;
// coughDry
final static String coughDryPrintName = "cough dry";
final static String coughDryDescription = coughDryPrintName;
// coughHacking
final static String coughHackingPrintName = "cough hacking";
final static String coughHackingDescription = coughHackingPrintName;
// coughProductive
final static String coughProductivePrintName = "cough productive";
final static String coughProductiveDescription = coughProductivePrintName;
// coughProductiveFoulSmelling
final static String coughProductiveFoulSmellingPrintName = "cough productive foul smelling";
final static String coughProductiveFoulSmellingDescription = coughProductiveFoulSmellingPrintName;
// crackles
final static String cracklesPrintName = "crackles";
final static String cracklesDescription = "sharp sudden repeated noises";
// cryingSpell
final static String cryingSpellPrintName = "crying spell";
final static String cryingSpellDescription = cryingSpellPrintName;
// cryingSpellFrequent
final static String cryingSpellFrequentPrintName = "crying spells frequently";
final static String cryingSpellFrequentDescription = 
    "crying at least 3 hours a day 3 days a week in the first 4 months";
// cyanosis
final static String cyanosisPrintName = "skin bluish";
final static String cyanosisDescription = cyanosisPrintName;
// dailyActivityUninteresting
final static String dailyActivityUninterestingPrintName = "daily activity uninteresting";
final static String dailyActivityUninterestingDescription = dailyActivityUninterestingPrintName;
// daydreaming
final static String daydreamingPrintName = "daydreaming";
final static String daydreamingDescription = daydreamingPrintName;
// decerebratePosturing
final static String decerebratePosturingPrintName = "posturing abnormal";
final static String decerebratePosturingDescription = decerebratePosturingPrintName;
// deepThrustDyspareunia
final static String deepThrustDyspareuniaPrintName = "intercourse discomfort with deep thrust";
final static String deepThrustDyspareuniaDescription = deepThrustDyspareuniaPrintName;
// dehydration
final static String dehydrationPrintName = "dehydration";
final static String dehydrationDescription = dehydrationPrintName;
// delirium
final static String deliriumPrintName = "delirium";
final static String deliriumDescription = deliriumPrintName;
// delusions
final static String delusionsPrintName = "delusions";
final static String delusionsDescription = delusionsPrintName;
// developmentSlow
final static String developmentSlowPrintName = "development slow";
final static String developmentSlowDescription = developmentSlowPrintName;
// diaphoresis
final static String diaphoresisPrintName = "sweating a lot";
final static String diaphoresisDescription = diaphoresisPrintName;
// diarrhea
final static String diarrheaPrintName = "diarrhea";
final static String diarrheaDescription = diarrheaPrintName;
// diarrheaBloody
final static String diarrheaBloodyPrintName = "diarrhea bloody";
final static String diarrheaBloodyDescription = diarrheaBloodyPrintName;
// diarrheaNocturnal
final static String diarrheaNocturnalPrintName = "diarrhea at night";
final static String diarrheaNocturnalDescription = diarrheaNocturnalPrintName;
// diarrheaWatery
final static String diarrheaWateryPrintName = "diarrhea watery";
final static String diarrheaWateryDescription = diarrheaWateryPrintName;
// diastolicGallop
final static String diastolicGallopPrintName = "heartbeat racing";
final static String diastolicGallopDescription = diastolicGallopPrintName;
// digitsClubbing
final static String digitsClubbingPrintName = "digits clubbing";
final static String digitsClubbingDescription = digitsClubbingPrintName;
// diplopia
final static String diplopiaPrintName = "seeing two images of a single object";
final static String diplopiaDescription = diplopiaPrintName;
// discoloration
final static String discolorationPrintName = "discoloration";
final static String discolorationDescription = discolorationPrintName;
// disorientation
final static String disorientationPrintName = "disorientation";
final static String disorientationDescription = disorientationPrintName;
// dizziness
final static String dizzinessPrintName = "dizziness";  
final static String dizzinessDescription = dizzinessPrintName;
// doomFeeling
final static String doomFeelingPrintName = "doom feeling";
final static String doomFeelingDescription = doomFeelingPrintName;
// drooling
final static String droolingPrintName = "drooling";
final static String droolingDescription = droolingPrintName;
// drowsiness
final static String drowsinessPrintName = "drowsiness";
final static String drowsinessDescription = drowsinessPrintName;
// dysarthria
final static String dysarthriaPrintName = "word articulation impaired";
final static String dysarthriaDescription = dysarthriaPrintName;
// dyspepsia
final static String dyspepsiaPrintName = "indigestion";
final static String dyspepsiaDescription = dyspepsiaPrintName;
// dysphagia
final static String dysphagiaPrintName = "swallowing difficult";
final static String dysphagiaDescription = dysphagiaPrintName;
// dysphasia
final static String dysphasiaPrintName = "speech and comprehension impaired";
final static String dysphasiaDescription = dysphasiaPrintName;
// dysphonia
final static String dysphoniaPrintName = "speech disorder";
final static String dysphoniaDescription = dysphoniaPrintName;
// dyspnea
final static String dyspneaPrintName = "breath short";
final static String dyspneaDescription = dyspneaPrintName;
// dysuria
final static String dysuriaPrintName = "urination difficult";
final static String dysuriaDescription = dysuriaPrintName;
// earBlockageFeeling
final static String earBlockageFeelingPrintName = "ear blockage feeling";
final static String earBlockageFeelingDescription = earBlockageFeelingPrintName;
// earRinging = tinnitus
    // final static String earRingingPrintName = "ear ringing";
    // final static String earRingingDescription = earRingingPrintName;
// earache
final static String earachePrintName = "earache";
final static String earacheDescription = earachePrintName;
// ecchymoses
final static String ecchymosesPrintName = "skin bleuish areas";
final static String ecchymosesDescription = ecchymosesPrintName;
// ecchymosesFace
final static String ecchymosesFacePrintName = "blotchy areas of bleeding of the face";
final static String ecchymosesFaceDescription = ecchymosesFacePrintName;
// eczema
final static String eczemaPrintName = "eczema";
final static String eczemaDescription = eczemaPrintName;
// edema
final static String edemaPrintName = "swellings";
final static String edemaDescription = "swelling of any part of the body";
// edemaPeripheral
final static String edemaPeripheralPrintName = "swellings peripheral";
final static String edemaPeripheralDescription = edemaPeripheralPrintName;
// ejaculationPainful
final static String ejaculationPainfulPrintName = "ejaculation painful";
final static String ejaculationPainfulDescription = ejaculationPainfulPrintName;
// elbowLesion
final static String elbowLesionPrintName = "elbow lesion";
final static String elbowLesionDescription = elbowLesionPrintName;
// elbowPain
final static String elbowPainPrintName = "elbow pain";
final static String elbowPainDescription = elbowPainPrintName;
// emaciation
final static String emaciationPrintName = "emaciation";
final static String emaciationDescription = "become extremely thin";
// emotionPangs
final static String emotionPangsPrintName = "emotion pangs";
final static String emotionPangsDescription = emotionPangsPrintName;
// energyLoss
final static String energyLossPrintName = "energy loss";
final static String energyLossDescription = energyLossPrintName;
// epigastricPain
final static String epigastricPainPrintName = "stomach above navel pain";
final static String epigastricPainDescription = epigastricPainPrintName;
// epigastricUmbilicusPain
final static String epigastricUmbilicusPainPrintName = "stomach close to navel pain";
final static String epigastricUmbilicusPainDescription = epigastricUmbilicusPainPrintName;
// erectionFailure
final static String erectionFailurePrintName = "erection failure";
final static String erectionFailureDescription = erectionFailurePrintName;
// erectionFrequent
final static String erectionFrequentPrintName = "erection frequent";
final static String erectionFrequentDescription = erectionFrequentPrintName;
// erythema
final static String erythemaPrintName = "skin red";
final static String erythemaDescription = erythemaPrintName;
// erythemaNodosum 
final static String erythemaNodosumPrintName = "shins with red tender nodules";
final static String erythemaNodosumDescription = erythemaNodosumPrintName;
// erythemaUrethraMale
final static String erythemaUrethraMalePrintName = "urethra male red";
final static String erythemaUrethraMaleDescription = erythemaUrethraMalePrintName;
// esophagusSpasm
final static String esophagusSpasmPrintName = "esophagus spasm";
final static String esophagusSpasmDescription = esophagusSpasmPrintName;
// exacerbationOfMentalProblems
final static String exacerbationOfMentalProblemsPrintName = "mental exacerbation of problems";
final static String exacerbationOfMentalProblemsDescription = 
    exacerbationOfMentalProblemsPrintName;
// excited
final static String excitedPrintName = "excited";
final static String excitedDescription = excitedPrintName;
// exophthalmos
final static String exophthalmosPrintName = "eyes bulging";
final static String exophthalmosDescription = exophthalmosPrintName;
// eyeDryness
final static String eyeDrynessPrintName = "eye dryness";
final static String eyeDrynessDescription = eyeDrynessPrintName;
// eyeExudate
final static String eyeExudatePrintName = "eye tearing";
final static String eyeExudateDescription = eyeExudatePrintName;
// eyePain
final static String eyePainPrintName = "eye pain";
final static String eyePainDescription = eyePainPrintName;
// eyePainMild
final static String eyePainMildPrintName = "eye pain mild";
final static String eyePainMildDescription = eyePainMildPrintName;
// eyePressure
final static String eyePressurePrintName = "eye pressure";
final static String eyePressureDescription = eyePressurePrintName;
// eyelidChancre
final static String eyelidChancrePrintName = "eyelid chancre";
final static String eyelidChancreDescription = eyelidChancrePrintName;
// eyelidDroop
final static String eyelidDroopPrintName = "eyelid droop";
final static String eyelidDroopDescription = eyelidDroopPrintName;
// eyelidHyperemia
final static String eyelidHyperemiaPrintName = "eyelid blood congested";
final static String eyelidHyperemiaDescription = eyelidHyperemiaPrintName;
// eyelidRed
final static String eyelidRedPrintName = "eyelid red";
final static String eyelidRedDescription = eyelidRedPrintName;
// eyelidSwollen
final static String eyelidSwollenPrintName = "eyelid swollen";
final static String eyelidSwollenDescription = eyelidSwollenPrintName;
// eyeRedness
final static String eyeRednessPrintName = "eyes red";
final static String eyeRednessDescription = eyeRednessPrintName;
// faceBurningPain
final static String faceBurningPainPrintName = "face burning pain";
final static String faceBurningPainDescription = faceBurningPainPrintName;
// faceEdema
final static String faceEdemaPrintName = "face swollen";
final static String faceEdemaDescription = faceEdemaPrintName;
// faceHair
final static String faceHairPrintName = "face hair";
final static String faceHairDescription = faceHairPrintName;
// faceHairSparse
final static String faceHairSparsePrintName = "face hair sparse";
final static String faceHairSparseDescription = faceHairSparsePrintName;
// faceLesionPinkPapules
final static String faceLesionPinkPapulesPrintName = "face lesion pink papules";
final static String faceLesionPinkPapulesDescription = faceLesionPinkPapulesPrintName;
// faceLesionTranslucentPapules
final static String faceLesionTranslucentPapulesPrintName = 
    "face lesion translucent papules";
final static String faceLesionTranslucentPapulesDescription = 
    faceLesionTranslucentPapulesPrintName;
// faceMovementsAbnormal
final static String faceMovementsAbnormalPrintName = "face movements abnormal";
final static String faceMovementsAbnormalDescription = faceMovementsAbnormalPrintName;
// faceNumbness
final static String faceNumbnessPrintName = "face numbness";
final static String faceNumbnessDescription = faceNumbnessPrintName;
// faceSearingPain
final static String faceSearingPainPrintName = "face searing pain";
final static String faceSearingPainDescription = faceSearingPainPrintName;
// faceSpasm
final static String faceSpasmPrintName = "face spasm";
final static String faceSpasmDescription = faceSpasmPrintName;
// faceTingling
final static String faceTinglingPrintName = "face tingling";
final static String faceTinglingDescription = faceTinglingPrintName;
// fainting
final static String faintingPrintName = "fainting";
final static String faintingDescription = faintingPrintName;
// fallingSensation
final static String fallingSensationPrintName = "falling sensation";
final static String fallingSensationDescription = fallingSensationPrintName;
// fatigue
final static String fatiguePrintName = "fatigue";
final static String fatigueDescription = fatiguePrintName;
// fatigueProlonged
final static String fatigueProlongedPrintName = "fatigue prolonged";
final static String fatigueProlongedDescription = fatigueProlongedPrintName;
// fearful
final static String fearfulPrintName = "fearful";
final static String fearfulDescription = fearfulPrintName;
// feedingDifficulties
final static String feedingDifficultiesPrintName = "feeding difficulties";
final static String feedingDifficultiesDescription = feedingDifficultiesPrintName;
// feelingCold
final static String feelingColdPrintName = "feeling cold";
final static String feelingColdDescription = feelingColdPrintName;
// feetCold
final static String feetColdPrintName = "feet cold";
final static String feetColdDescription = feetColdPrintName;
// feetNumbness
final static String feetNumbnessPrintName = "feet numbness";
final static String feetNumbnessDescription = feetNumbnessPrintName;
// feetPain
final static String feetPainPrintName = "feet pain";
final static String feetPainDescription = feetPainPrintName;
// fetalHeartTonesAbsent
final static String fetalHeartTonesAbsentPrintName = "fetal heart tones absent";
final static String fetalHeartTonesAbsentDescription = fetalHeartTonesAbsentPrintName;
// fever
final static String feverPrintName = "fever";
final static String feverDescription = feverPrintName;
// feverIntermittent
final static String feverIntermittentPrintName = "fever intermittent";
final static String feverIntermittentDescription = feverIntermittentPrintName;
// feverRapidOnset
final static String feverRapidOnsetPrintName = "fever rapid onset";
final static String feverRapidOnsetDescription = feverRapidOnsetPrintName;
// fidgeting
final static String fidgetingPrintName = "fidgeting";
final static String fidgetingDescription = fidgetingPrintName;
// fingerBoneLesion
final static String fingerBoneLesionPrintName = "finger bone lesion";
final static String fingerBoneLesionDescription = fingerBoneLesionPrintName;
// fingerChancre
final static String fingerChancrePrintName = "finger chancre";
final static String fingerChancreDescription = fingerChancrePrintName;
// fingerJointDeformity
final static String fingerJointDeformityPrintName = "finger joint deformity";
final static String fingerJointDeformityDescription = fingerJointDeformityPrintName;
// fingerLesion
final static String fingerLesionPrintName = "finger lesion";
final static String fingerLesionDescription = fingerLesionPrintName;
// fingerNailsBlue
final static String fingerNailsBluePrintName = "finger nails blue";
final static String fingerNailsBlueDescription = fingerNailsBluePrintName;
// fingersNumbness
final static String fingersNumbnessPrintName = "fingers numb";
final static String fingersNumbnessDescription = fingersNumbnessPrintName;
// fingerSpasm
final static String fingerSpasmPrintName = "finger spasm";
final static String fingerSpasmDescription = fingerSpasmPrintName;
// fingersTingling
final static String fingersTinglingPrintName = "fingers numb";
final static String fingersTinglingDescription = fingersTinglingPrintName;
// fingerSwelling
final static String fingerSwellingPrintName = "finger swelling";
final static String fingerSwellingDescription = fingerSwellingPrintName;
// fitOfAnger
final static String fitOfAngerPrintName = "fit of anger";
final static String fitOfAngerDescription = fitOfAngerPrintName;
// flankPain
final static String flankPainPrintName = "flank pain";
final static String flankPainDescription = flankPainPrintName;
// flaringNostrils
final static String flaringNostrilsPrintName = "nostrils flaring";
final static String flaringNostrilsDescription = flaringNostrilsPrintName;
// flashbacks
final static String flashbacksPrintName = "flashbacks";
final static String flashbacksDescription = flashbacksPrintName;
// flushing
final static String flushingPrintName = "flushing";
final static String flushingDescription = flushingPrintName;
// focussingDifficulty
final static String focussingDifficultyPrintName = "focussing difficulty";
final static String focussingDifficultyDescription = focussingDifficultyPrintName;
// footSpasm
final static String footSpasmPrintName = "foot spasm";
final static String footSpasmDescription = footSpasmPrintName;
// foreSkinVesicle
final static String foreSkinVesiclePrintName = "penis fore skin blister";
final static String foreSkinVesicleDescription = foreSkinVesiclePrintName;
// forgetfulness
final static String forgetfulnessPrintName = "forgetfulness";
final static String forgetfulnessDescription = forgetfulnessPrintName;
// foulSmellingDischarge
    // final static String foulSmellingDischargePrintName = "foul smelling discharge";
    // final static String foulSmellingDischargeDescription = foulSmellingDischargePrintName;
// gas
final static String gasPrintName = "gas";
final static String gasDescription = gasPrintName;
// gastricResidueIncreased
final static String gastricResidueIncreasedPrintName = "stomach residue increased";
final static String gastricResidueIncreasedDescription = gastricResidueIncreasedPrintName;
// gastroparesis
final static String gastroparesisPrintName = "stomach empties too slow";
final static String gastroparesisDescription = gastroparesisPrintName;
// genitaliaExposureToStrangers
final static String genitaliaExposureToStrangersPrintName = "genitalia exposure to strangers";
final static String genitaliaExposureToStrangersDescription = genitaliaExposureToStrangersPrintName;
// genitalLesionWhiteGrey
final static String genitalLesionWhiteGreyPrintName = "genital lesion white grey";
final static String genitalLesionWhiteGreyDescription = genitalLesionWhiteGreyPrintName;
// giddiness
final static String giddinessPrintName = "giddiness";
final static String giddinessDescription = "lightheaded sensation";
// goiter
final static String goiterPrintName = "goiter";
final static String goiterDescription = "enlarged thyroid gland";
// groinAdenitis
final static String groinAdenitisPrintName = "groin lymph node swollen";
final static String groinAdenitisDescription = groinAdenitisPrintName;
// groinLesionItchy
final static String groinLesionItchyPrintName = "groin lesion itchy";
final static String groinLesionItchyDescription = groinLesionItchyPrintName;
// groinLesionRed
final static String groinLesionRedPrintName = "groin lesion red";
final static String groinLesionRedDescription = groinLesionRedPrintName;
// groinLymphNodeRuptured
final static String groinLymphNodeRupturedPrintName = "groin lymph node ruptured";
final static String groinLymphNodeRupturedDescription = groinLymphNodeRupturedPrintName;
// groinPain
final static String groinPainPrintName = "groin pain";
final static String groinPainDescription = groinPainPrintName;
// groinPapule
final static String groinPapulePrintName = "groin papule";
final static String groinPapuleDescription = groinPapulePrintName;
// groinStiffness
final static String groinStiffnessPrintName = "groin stiffness";
final static String groinStiffnessDescription = groinStiffnessPrintName;
// groinSwelling
final static String groinSwellingPrintName = "groin swelling";
final static String groinSwellingDescription = groinSwellingPrintName;
// growthRapid
final static String growthRapidPrintName = "growth rapid";
final static String growthRapidDescription = growthRapidPrintName;
// grunting
final static String gruntingPrintName = "grunting";
final static String gruntingDescription = gruntingPrintName;
// gumPockets
final static String gumPocketsPrintName = "gum pockets";
final static String gumPocketsDescription = gumPocketsPrintName;
// gumsBleeding
final static String gumsBleedingPrintName = "gums bleeding";
final static String gumsBleedingDescription = gumsBleedingPrintName;
// gumsSwollen
final static String gumsSwollenPrintName = "gums swollen";
final static String gumsSwollenDescription = gumsSwollenPrintName;
// hairBroken
final static String hairBrokenPrintName = "hair broken";
final static String hairBrokenDescription = hairBrokenPrintName;
// hairGrowthIncrease
final static String hairGrowthIncreasePrintName = "hair growth increase";
final static String hairGrowthIncreaseDescription = hairGrowthIncreasePrintName;
// hairLoss
final static String hairLossPrintName = "hair loss";
final static String hairLossDescription = hairLossPrintName;
// hairSmelly
final static String hairSmellyPrintName = "hair smelly";
final static String hairSmellyDescription = hairSmellyPrintName;
// hallucinations
final static String hallucinationsPrintName = "hallucinations";
final static String hallucinationsDescription = hallucinationsPrintName;
// handBurning
final static String handBurningPrintName = "hand burning";
final static String handBurningDescription = handBurningPrintName;
// handCold
final static String handColdPrintName = "hand cold";
final static String handColdDescription = handColdPrintName;
// handNodule
final static String handNodulePrintName = "hand nodule";
final static String handNoduleDescription = handNodulePrintName;
// handNumbness
final static String handNumbnessPrintName = "hand numbness";
final static String handNumbnessDescription = handNumbnessPrintName;
// handPain
final static String handPainPrintName = "hand pain";
final static String handPainDescription = handPainPrintName;
// handSpasm
final static String handSpasmPrintName = "hand spasm";
final static String handSpasmDescription = handSpasmPrintName;
// handTingling
final static String handTinglingPrintName = "hand tingling";
final static String handTinglingDescription = handTinglingPrintName;
// handWeak
final static String handWeakPrintName = "hand weak";
final static String handWeakDescription = handWeakPrintName;
// headache
final static String headachePrintName = "headache";
final static String headacheDescription = headachePrintName;
// headacheConstant
final static String headacheConstantPrintName = "headache constant";
final static String headacheConstantDescription = headacheConstantPrintName;
// headacheFrontal
final static String headacheFrontalPrintName = "headache front located";
final static String headacheFrontalDescription = headacheFrontalPrintName;
// headacheSevere
final static String headacheSeverePrintName = "headache severe";
final static String headacheSevereDescription = headacheSeverePrintName;
// headSwollen
final static String headSwollenPrintName = "head swollen";
final static String headSwollenDescription = headSwollenPrintName;
// hearingLoss
final static String hearingLossPrintName = "hearing loss";
final static String hearingLossDescription = hearingLossPrintName;
// heartPain
final static String heartPainPrintName = "heart pain";
final static String heartPainDescription = heartPainPrintName;
// heartburn
final static String heartburnPrintName = "heartburn";
final static String heartburnDescription = 
    "heartburn -> burning sensation in stomach and esophagus";
// heatSensitivity
final static String heatSensitivityPrintName = "heat sensitivity";
final static String heatSensitivityDescription = heatSensitivityPrintName;
// heightLoss
final static String heightLossPrintName = "height loss";
final static String heightLossDescription = heightLossPrintName;
// hematuria
final static String hematuriaPrintName = "urine with blood";
final static String hematuriaDescription = hematuriaPrintName;
// hemiparesis
final static String hemiparesisPrintName = "paralysis of one side of the body";
final static String hemiparesisDescription = hemiparesisPrintName;
// hemoptysis
final static String hemoptysisPrintName = "spitting of blood";
final static String hemoptysisDescription = hemoptysisPrintName;
// hemorrhage
final static String hemorrhagePrintName = "bleeding heavily";
final static String hemorrhageDescription = hemorrhagePrintName;
// hemospermia
final static String hemospermiaPrintName = "ejaculate with blood";
final static String hemospermiaDescription = hemospermiaPrintName;
// hiccups
final static String hiccupsPrintName = "hiccups";
final static String hiccupsDescription = hiccupsPrintName;
// hipPain
final static String hipPainPrintName = "hip pain";
final static String hipPainDescription = hipPainPrintName;
// hirsutism
final static String hirsutismPrintName = "hair growth abnormal";
final static String hirsutismDescription = hirsutismPrintName;
// hoarseness
final static String hoarsenessPrintName = "hoarseness";
final static String hoarsenessDescription = hoarsenessPrintName;
// hostility
final static String hostilityPrintName = "hostility";
final static String hostilityDescription = hostilityPrintName;
// hotFlash
final static String hotFlashPrintName = "hot flash";
final static String hotFlashDescription = hotFlashPrintName;
// hungerExcessive
final static String hungerExcessivePrintName = "hunger excessive";
final static String hungerExcessiveDescription = hungerExcessivePrintName;
// hydrophobia
final static String hydrophobiaPrintName = "fear of water";
final static String hydrophobiaDescription = hydrophobiaPrintName;
// hyperactivity
final static String hyperactivityPrintName = "hyperactivity";
final static String hyperactivityDescription = hyperactivityPrintName;
// hyperesthesia
final static String hyperesthesiaPrintName = "very sensitive to stimulations";
final static String hyperesthesiaDescription = hyperesthesiaPrintName;
// hyperventilation
final static String hyperventilationPrintName = "breathing deep and rapid";
final static String hyperventilationDescription = hyperventilationPrintName;
// hypotension
final static String hypotensionPrintName = "low blood pressure";
final static String hypotensionDescription = hypotensionPrintName;
// hypothermia
final static String hypothermiaPrintName = "body temperature subnormal";
final static String hypothermiaDescription = hypothermiaPrintName;
// hypoventilation
final static String hypoventilationPrintName = "breathing too slow";
final static String hypoventilationDescription = hypoventilationPrintName;
// impulsive
final static String impulsivePrintName = "impulsive";
final static String impulsiveDescription = impulsivePrintName;
// inattention
final static String inattentionPrintName = "inattention";
final static String inattentionDescription = inattentionPrintName;
// incoherence
final static String incoherencePrintName = "incoherence";
final static String incoherenceDescription = incoherencePrintName;
// incontinence
final static String incontinencePrintName = "incontinence";
final static String incontinenceDescription = incontinencePrintName;
// indecisive
final static String indecisivePrintName = "indecisive";
final static String indecisiveDescription = indecisivePrintName;
// indigestion see dyspepsia
    // final static String indigestionPrintName = "indigestion";
    // final static String indigestionDescription = indigestionPrintName;
// infectionSiteCrepitation
final static String infectionSiteCrepitationPrintName = 
	"infection site crepitation";
final static String infectionSiteCrepitationDescription = 
    "crackling sensation when skin is touched";
// infertilityFemaleSymptom
final static String infertilityFemaleSymptomPrintName = "infertility female";
final static String infertilityFemaleSymptomDescription = 
    "no conception after one year of regular intercourse";
// infertilityMaleSymptom
final static String infertilityMaleSymptomPrintName = "infertility male";
final static String infertilityMaleSymptomDescription = infertilityMaleSymptomPrintName;
// insectSting
final static String insectStingPrintName = "insect sting";
final static String insectStingDescription = insectStingPrintName;
// intellectImpaired
final static String intellectImpairedPrintName = "intellect impaired";
final static String intellectImpairedDescription = intellectImpairedPrintName;
// intercourseDiscomfort
final static String intercourseDiscomfortPrintName = "intercourse discomfort";
final static String intercourseDiscomfortDescription = intercourseDiscomfortPrintName;
// irritability
final static String irritabilityPrintName = "irritability";
final static String irritabilityDescription = irritabilityPrintName;
// itches
final static String itchesPrintName = "itches";
final static String itchesDescription = itchesPrintName;
// jaundice
final static String jaundicePrintName = "jaundice";
final static String jaundiceDescription = jaundicePrintName;
// jawPain
final static String jawPainPrintName = "jaw pain";
final static String jawPainDescription = jawPainPrintName;
// jointHot
final static String jointHotPrintName = "joint hot";
final static String jointHotDescription = jointHotPrintName;
// jointNodule
final static String jointNodulePrintName = "joint nodule";
final static String jointNoduleDescription = jointNodulePrintName;
// jointPain
final static String jointPainPrintName = "joint pain";
final static String jointPainDescription = jointPainPrintName;
// jointRedness
final static String jointRednessPrintName = "joint redness";
final static String jointRednessDescription = jointRednessPrintName;
// jointStiffen
final static String jointStiffenPrintName = "joint stiffen";
final static String jointStiffenDescription = jointStiffenPrintName;
// jointSwelling
final static String jointSwellingPrintName = "joint swelling";
final static String jointSwellingDescription = jointSwellingPrintName;
// jointTender
final static String jointTenderPrintName = "joint tender";
final static String jointTenderDescription = jointTenderPrintName;
// judgementImpaired
final static String judgementImpairedPrintName = "judgement impaired";
final static String judgementImpairedDescription = judgementImpairedPrintName;
// kneePain
final static String kneePainPrintName = "knee pain";
final static String kneePainDescription = kneePainPrintName;
// labiaVesicle
final static String labiaVesiclePrintName = "labia blister";
final static String labiaVesicleDescription = labiaVesiclePrintName;
// lacrimation
final static String lacrimationPrintName = "eyes tearing";
final static String lacrimationDescription = lacrimationPrintName;
// lactationAbnormal
final static String lactationAbnormalPrintName = "breast milk secretion abnormal";
final static String lactationAbnormalDescription = lactationAbnormalPrintName;
// languageDetoriation
final static String languageDetoriationPrintName = "language detoriation";
final static String languageDetoriationDescription = languageDetoriationPrintName;
// lassitude = fatique
    // final static String lassitudePrintName = "lassitude"; 
    // final static String lassitudeDescription = "exhaustion and weakness";
// laughing
final static String laughingPrintName = "laughing";
final static String laughingDescription = laughingPrintName;
// learningDifficulty
final static String learningDifficultyPrintName = "learning difficulty";
final static String learningDifficultyDescription = learningDifficultyPrintName;
// legCramps
final static String legCrampsPrintName = "leg cramps";
final static String legCrampsDescription = legCrampsPrintName;
// legEdema
final static String legEdemaPrintName = "leg swellings";
final static String legEdemaDescription = legEdemaPrintName;
// legPain
final static String legPainPrintName = "leg pain";
final static String legPainDescription = legPainPrintName;
// legStiff
final static String legStiffPrintName = "leg stiff";
final static String legStiffDescription = legStiffPrintName;
// legWeakness
final static String legWeaknessPrintName = "leg weakness";
final static String legWeaknessDescription = legWeaknessPrintName;
// lethargy
final static String lethargyPrintName = "lethargy";
final static String lethargyDescription = lethargyPrintName;
// libidoLoss
final static String libidoLossPrintName = "libido loss";
final static String libidoLossDescription = libidoLossPrintName;
// lightHeadedness
final static String lightHeadednessPrintName = "light headedness";
final static String lightHeadednessDescription = lightHeadednessPrintName;
// limbsBurning
final static String limbsBurningPrintName = "limbs burning";
final static String limbsBurningDescription = limbsBurningPrintName;
// limbsNumbness
final static String limbsNumbnessPrintName = "limbs numbness";
final static String limbsNumbnessDescription = limbsNumbnessPrintName;
// limbsPinsAndNeedles
final static String limbsPinsAndNeedlesPrintName = "limbs pins and needles";
final static String limbsPinsAndNeedlesDescription = limbsPinsAndNeedlesPrintName;
// limbsTingling
final static String limbsTinglingPrintName = "limbs tingling";
final static String limbsTinglingDescription = limbsTinglingPrintName;
// limbsWeak
final static String limbsWeakPrintName = "limbs weak";
final static String limbsWeakDescription = limbsWeakPrintName;
// lipChancre
final static String lipChancrePrintName = "lip chancre";
final static String lipChancreDescription = "small fluid filled lesion";
// lipLowerHanging
final static String lipLowerHangingPrintName = "lower lip hanging";
final static String lipLowerHangingDescription = lipLowerHangingPrintName;
// lipPapule
final static String lipPapulePrintName = "lip pimple";
final static String lipPapuleDescription = lipPapulePrintName;
// lipsBlue
final static String lipsBluePrintName = "lips blue";
final static String lipsBlueDescription = lipsBluePrintName;
// lipsPale
final static String lipsPalePrintName = "lips pale";
final static String lipsPaleDescription = lipsPalePrintName;
// lipsSwollen
final static String lipsSwollenPrintName = "lips swollen";
final static String lipsSwollenDescription = lipsSwollenPrintName;
// listlessness
final static String listlessnessPrintName = "listlessness";
final static String listlessnessDescription = "lack of inclination";
// liverEnlarged
final static String liverEnlargedPrintName = "liver enlarged";
final static String liverEnlargedDescription = liverEnlargedPrintName;
// liverPain
final static String liverPainPrintName = "liver pain";
final static String liverPainDescription = liverPainPrintName;
// liverTender
final static String liverTenderPrintName = "liver tender";
final static String liverTenderDescription = liverTenderPrintName;
// lochia
final static String lochiaPrintName = "vagina discharge after childbirth upto 6 weeks";
final static String lochiaDescription = lochiaPrintName;
// lochiaHeavy
final static String lochiaHeavyPrintName = "vagina discharge heavy after childbirth";
final static String lochiaHeavyDescription = lochiaHeavyPrintName;
// lockjaw
final static String lockjawPrintName = "lockjaw";
final static String lockjawDescription = lockjawPrintName;
// lordosis
final static String lordosisPrintName = "spine lower abnormal inward curved";
final static String lordosisDescription = lordosisPrintName;
// lossOfBalance
final static String lossOfBalancePrintName = "balance loss";
final static String lossOfBalanceDescription = lossOfBalancePrintName;
// lossOfCoordination
final static String lossOfCoordinationPrintName = "coordination loss";
final static String lossOfCoordinationDescription = lossOfCoordinationPrintName;
// lowBackPain
final static String lowBackPainPrintName = "low back pain";
final static String lowBackPainDescription = lowBackPainPrintName;
// lumbarPain
final static String lumbarPainPrintName = "lumbar pain";
final static String lumbarPainDescription = lumbarPainPrintName;
// lymphNodePainful
final static String lymphNodePainfulPrintName = "lymph node painful";
final static String lymphNodePainfulDescription = lymphNodePainfulPrintName;
// lymphNodeSwollen = lymphadenopathy
    // final static String lymphNodeSwollenPrintName = "lymph node swollen";
    // final static String lymphNodeSwollenDescription = lymphNodeSwollenPrintName;
// lymphadenitis
final static String lymphadenitisPrintName = "lymph node inflammation";
final static String lymphadenitisDescription = lymphadenitisPrintName;
// lymphadenopathy
final static String lymphadenopathyPrintName = "lymph node enlargement"; 
final static String lymphadenopathyDescription = lymphadenopathyPrintName;
// maculeEncrusted
final static String maculeEncrustedPrintName = "skin elevated with crust";
final static String maculeEncrustedDescription = maculeEncrustedPrintName;
// maculePustular
final static String maculePustularPrintName = "skin elevated with pus";
final static String maculePustularDescription = maculePustularPrintName;
// maculopapularEruption
final static String maculopapularEruptionPrintName = "skin elevated bursted colored";
final static String maculopapularEruptionDescription = maculopapularEruptionPrintName;
// malaise
final static String malaisePrintName = "malaise";
final static String malaiseDescription = "feeling of debility sickness";
// meatalTenderness
final static String meatalTendernessPrintName = "body opening tender";
final static String meatalTendernessDescription = meatalTendernessPrintName;
// melena
final static String melenaPrintName = "stool bloody black tarry";
final static String melenaDescription = melenaPrintName;
// memoryDetoriation
final static String memoryDetoriationPrintName = "memory detoriation";
final static String memoryDetoriationDescription = memoryDetoriationPrintName;
// memoryRecentLoss
final static String memoryRecentLossPrintName = "recent memory loss";
final static String memoryRecentLossDescription = memoryRecentLossPrintName;
// menarcheEarly
final static String menarcheEarlyPrintName = "menstruation 1st early";
final static String menarcheEarlyDescription = menarcheEarlyPrintName;
// menstruationAbsence
final static String menstruationAbsencePrintName = "menstruation absent";
final static String menstruationAbsenceDescription = menstruationAbsencePrintName;
// menstruationDeficient
final static String menstruationDeficientPrintName = "menstruation deficient";
final static String menstruationDeficientDescription = menstruationDeficientPrintName;
// menstruationFlowDecrease
final static String menstruationFlowDecreasePrintName = "menstruation flow decrease";
final static String menstruationFlowDecreaseDescription = menstruationFlowDecreasePrintName;
// menstruationInfrequent
final static String menstruationInfrequentPrintName = "menstruation infrequent";
final static String menstruationInfrequentDescription = menstruationInfrequentPrintName;
// menstruationIrregular
final static String menstruationIrregularPrintName = "menstruation irregular";
final static String menstruationIrregularDescription = menstruationIrregularPrintName;
// menstruationPainful
final static String menstruationPainfulPrintName = "menstruation painful";
final static String menstruationPainfulDescription = menstruationPainfulPrintName;
// menstruationProfuse
final static String menstruationProfusePrintName = "menstruation profuse";
final static String menstruationProfuseDescription = menstruationProfusePrintName;
// menstruationTooFrequent
final static String menstruationTooFrequentPrintName = "menstruation too frequent";
final static String menstruationTooFrequentDescription = menstruationTooFrequentPrintName;
// mentalDepression
final static String mentalDepressionPrintName = "mental depression";
final static String mentalDepressionDescription = mentalDepressionPrintName;
// mentalInstability
final static String mentalInstabilityPrintName = "mental instability";
final static String mentalInstabilityDescription = mentalInstabilityPrintName;
// moodSad
final static String moodSadPrintName = "mood sad";
final static String moodSadDescription = moodSadPrintName;
// moodSwings
final static String moodSwingsPrintName = "mood swings";
final static String moodSwingsDescription = moodSwingsPrintName;
// moonFace
final static String moonFacePrintName = "moon face";
final static String moonFaceDescription = moonFacePrintName;
// motivationLoss
final static String motivationLossPrintName = "motivation loss";
final static String motivationLossDescription = motivationLossPrintName;
// motorDysfunction
final static String motorDysfunctionPrintName = "motor dysfunction";
final static String motorDysfunctionDescription = motorDysfunctionPrintName;
// mouthDroops
final static String mouthDroopsPrintName = "mouth droops one side";
final static String mouthDroopsDescription = mouthDroopsPrintName;
// mouthDry
final static String mouthDryPrintName = "mouth dry";
final static String mouthDryDescription = mouthDryPrintName;
// mouthItches
final static String mouthItchesPrintName = "mouth itches";
final static String mouthItchesDescription = mouthItchesPrintName;
// mouthLesion
final static String mouthLesionPrintName = "mouth lesion";
final static String mouthLesionDescription = mouthLesionPrintName;
// mouthLesionWhiteGrey
final static String mouthLesionWhiteGreyPrintName = "mouth lesion white grey";
final static String mouthLesionWhiteGreyDescription = mouthLesionWhiteGreyPrintName;
// mouthNumbness
final static String mouthNumbnessPrintName = "mouth numbness";
final static String mouthNumbnessDescription = mouthNumbnessPrintName;
// mouthPain
final static String mouthPainPrintName = "mouth pain";
final static String mouthPainDescription = mouthPainPrintName;
// mouthPatchWhite
final static String mouthPatchWhitePrintName = "mouth patch white";
final static String mouthPatchWhiteDescription = mouthPatchWhitePrintName;
// mouthPatchYellow
final static String mouthPatchYellowPrintName = "mouth patch yellow";
final static String mouthPatchYellowDescription = mouthPatchYellowPrintName;
// mouthSore
final static String mouthSorePrintName = "mouth sore";
final static String mouthSoreDescription = mouthSorePrintName;
// mouthSwollen
final static String mouthSwollenPrintName = "mouth swollen";
final static String mouthSwollenDescription = mouthSwollenPrintName;
// mouthTasteMetallic
final static String mouthTasteMetallicPrintName = "mouth taste metallic";
final static String mouthTasteMetallicDescription = mouthTasteMetallicPrintName;
// mouthTingling
final static String mouthTinglingPrintName = "mouth tingling";
final static String mouthTinglingDescription = mouthTinglingPrintName;
// mouthUlcers
final static String mouthUlcersPrintName = "mouth ulcers";
final static String mouthUlcersDescription = mouthUlcersPrintName;
// movementsJerky
final static String movementsJerkyPrintName = "movements jerky";
final static String movementsJerkyDescription = movementsJerkyPrintName;
// mucousMembraneGumma
final static String mucousMembraneGummaPrintName = "mucous membrane gumma";
final static String mucousMembraneGummaDescription = "chronic tumor like rubbery nodule";
// mucousMembranesDry
final static String mucousMembranesDryPrintName = "mucous membranes dry";
final static String mucousMembranesDryDescription = mucousMembranesDryPrintName;
// murmerLoud
final static String murmurLoudPrintName = "murmur loud";
final static String murmurLoudDescription = murmurLoudPrintName;
// muscleAches = myalgia
    // final static String muscleAchesPrintName = "muscle aches";
    // final static String muscleAchesDescription = muscleAchesPrintName;
// muscleContractions
final static String muscleContractionsPrintName = "muscle contractions";
final static String muscleContractionsDescription = muscleContractionsPrintName;
// muscleCramps
final static String muscleCrampsPrintName = "muscle cramps";
final static String muscleCrampsDescription = muscleCrampsPrintName;
// muscleDevelopmentEarly
final static String muscleDevelopmentEarlyPrintName = "muscle development early";
final static String muscleDevelopmentEarlyDescription = muscleDevelopmentEarlyPrintName;
// muscleHypertonicity
final static String muscleHypertonicityPrintName = "muscle tension strong";
final static String muscleHypertonicityDescription = muscleHypertonicityPrintName;
// muscleLoss
final static String muscleLossPrintName = "muscle loss";
final static String muscleLossDescription = muscleLossPrintName;
// muscleRigid
final static String muscleRigidPrintName = "muscle rigid";
final static String muscleRigidDescription = muscleRigidPrintName;
// muscleTender
final static String muscleTenderPrintName = "muscle tender";
final static String muscleTenderDescription = muscleTenderPrintName;
// muscleUnderdeveloped
final static String muscleUnderdevelopedPrintName = "muscle underdeveloped";
final static String muscleUnderdevelopedDescription = muscleUnderdevelopedPrintName;
// muscleWeakness
final static String muscleWeaknessPrintName = "muscle weakness";
final static String muscleWeaknessDescription = muscleWeaknessPrintName;
// myalgia
final static String myalgiaPrintName = "muscle pain";
final static String myalgiaDescription = myalgiaPrintName;
// nailBedRed
final static String nailBedRedPrintName = "nail bed red";
final static String nailBedRedDescription = nailBedRedPrintName;
// nailBedSwollen
final static String nailBedSwollenPrintName = "nail bed swollen";
final static String nailBedSwollenDescription = nailBedSwollenPrintName;
// nailBrittle
final static String nailBrittlePrintName = "nails brittle";
final static String nailBrittleDescription = nailBrittlePrintName;
// nailsPale
final static String nailsPalePrintName = "nails pale";
final static String nailsPaleDescription = nailsPalePrintName;
// nasolabialFoldAbsent
final static String nasolabialFoldAbsentPrintName = "nose corner folds absent";
final static String nasolabialFoldAbsentDescription = nasolabialFoldAbsentPrintName;
// nausea
final static String nauseaPrintName = "nausea";
final static String nauseaDescription = nauseaPrintName;
// navelPapule
final static String navelPapulePrintName = "navel papule";
final static String navelPapuleDescription = navelPapulePrintName;
// neckEdema
final static String neckEdemaPrintName = "neck swollen";
final static String neckEdemaDescription = neckEdemaPrintName;
// neckLymphNodeEnlarged
final static String neckLymphNodeEnlargedPrintName = "neck lymph node enlarged";
final static String neckLymphNodeEnlargedDescription = neckLymphNodeEnlargedPrintName;
// neckPain
final static String neckPainPrintName = "neck pain";
final static String neckPainDescription = neckPainPrintName;
// neckSpasm
final static String neckSpasmPrintName = "neck spasm";
final static String neckSpasmDescription = neckSpasmPrintName;
// neckStiff
final static String neckStiffPrintName = "neck stiff";
final static String neckStiffDescription = neckStiffPrintName;
// neckVeinsElevated
final static String neckVeinsElevatedPrintName = "neck veins elevated";
final static String neckVeinsElevatedDescription = neckVeinsElevatedPrintName;
// necrosis
final static String necrosisPrintName = "necrosis";
final static String necrosisDescription = "dying tissue";
// nervePain
final static String nervePainPrintName = "nerve pain";
final static String nervePainDescription = nervePainPrintName;
// nervousness
final static String nervousnessPrintName = "nervousness";
final static String nervousnessDescription = nervousnessPrintName;
// nightSweating
final static String nightSweatingPrintName = "sweating at night";
final static String nightSweatingDescription = nightSweatingPrintName;
// nightmares
final static String nightmaresPrintName = "nightmares";
final static String nightmaresDescription = nightmaresPrintName;
// nippleAreaSkinScaly
final static String nippleAreaSkinScalyPrintName = "nipple area skin scaly";
final static String nippleAreaSkinScalyDescription = nippleAreaSkinScalyPrintName;
// nippleBurning
final static String nippleBurningPrintName = "nipple burning";
final static String nippleBurningDescription = nippleBurningPrintName;
// nippleChancre
final static String nippleChancrePrintName = "nipple chancre";
final static String nippleChancreDescription = "small fluid filled lesion on nipple";
// nippleErosion
final static String nippleErosionPrintName = "nipple erosion";
final static String nippleErosionDescription = nippleErosionPrintName;
// nippleItching
final static String nippleItchingPrintName = "nipple itching";
final static String nippleItchingDescription = nippleItchingPrintName;
// nippleRetraction
final static String nippleRetractionPrintName = "nipple retraction";
final static String nippleRetractionDescription = nippleRetractionPrintName;
// nocturia
final static String nocturiaPrintName = "urination at night";
final static String nocturiaDescription = nocturiaPrintName;
// noiseSensitivity
final static String noiseSensitivityPrintName = "noise sensitivity";
final static String noiseSensitivityDescription = noiseSensitivityPrintName;
// noseCyanosis
final static String noseCyanosisPrintName = "nose blue";
final static String noseCyanosisDescription = noseCyanosisPrintName;
// noseDischarge
final static String noseDischargePrintName = "nose discharge";
final static String noseDischargeDescription = noseDischargePrintName;
// noseItches
final static String noseItchesPrintName = "nose itches";
final static String noseItchesDescription = noseItchesPrintName;
// noseMucosaSwelling
final static String noseMucosaSwellingPrintName = "nose mucosa swelling";
final static String noseMucosaSwellingDescription = noseMucosaSwellingPrintName;
// noseMucosaUlceration
final static String noseMucosaUlcerationPrintName = "nose mucosa ulcer";
final static String noseMucosaUlcerationDescription = noseMucosaUlcerationPrintName;
// noseMucosalLesion
final static String noseMucosalLesionPrintName = "nose mucosal lesion";
final static String noseMucosalLesionDescription = noseMucosalLesionPrintName;
// noseSeptumPerforation
final static String noseSeptumPerforationPrintName = "nose septum perforation";
final static String noseSeptumPerforationDescription = noseSeptumPerforationPrintName;
// noseWhitePatches
final static String noseWhitePatchesPrintName = "nose white patches";
final static String noseWhitePatchesDescription = noseWhitePatchesPrintName;
// nuchalRigidity
final static String nuchalRigidityPrintName = "nape rigid";
final static String nuchalRigidityDescription = nuchalRigidityPrintName;
// numbness
final static String numbnessPrintName = "numbness";
final static String numbnessDescription = numbnessPrintName;
// nystagmus
final static String nystagmusPrintName = "eye movements rapid jerky involuntary";
final static String nystagmusDescription = nystagmusPrintName;
// obsessiveThoughts
final static String obsessiveThoughtsPrintName = "thoughts obsessive";
final static String obsessiveThoughtsDescription = obsessiveThoughtsPrintName;
// obstipation
final static String obstipationPrintName = "obstipation";
final static String obstipationDescription = 
    "severe constipation due to obstruction";
// obtundation
final static String obtundationPrintName = "obtundation";
final static String obtundationDescription = "mental status changes";
// ocularDisturbance
final static String ocularDisturbancePrintName = "vision disturbance";
final static String ocularDisturbanceDescription = ocularDisturbancePrintName;
// oliguria
final static String oliguriaPrintName = "urine volume low";
final static String oliguriaDescription = oliguriaPrintName;
// opisthotonos
final static String opisthotonosPrintName = "opisthotonos";
final static String opisthotonosDescription = 
    "posture abnormal rigidity and severe arching of the back";
// orbitPain
final static String orbitPainDescription = "eye socket pain";
final static String orbitPainPrintName = orbitPainDescription;
// organGumma
final static String organGummaPrintName = "organ gumma";
final static String organGummaDescription = "chronic tumor like rubbery nodule";
// orgasmUnachievable
final static String orgasmUnachievablePrintName = "orgasm unachievable";
final static String orgasmUnachievableDescription = orgasmUnachievablePrintName;
// orthopnea
final static String orthopneaPrintName = "breathing difficult while lying down";
final static String orthopneaDescription = orthopneaPrintName;
// overweight
final static String overweightPrintName = "overweight";
final static String overweightDescription = overweightPrintName;
// pain
final static String painPrintName = "pain";
final static String painDescription = painPrintName;
// painBurning
final static String painBurningPrintName = "pain burning";
final static String painBurningDescription = painBurningPrintName;
// painDeep
final static String painDeepPrintName = "pain deep";
final static String painDeepDescription = painDeepPrintName;
// painGnawing
final static String painGnawingPrintName = "pain gnawing";
final static String painGnawingDescription = painGnawingPrintName;
// painSevere
final static String painSeverePrintName = "pain severe";
final static String painSevereDescription = painSeverePrintName;
// painSharp
final static String painSharpPrintName = "pain sharp";
final static String painSharpDescription = painSharpPrintName;
// painStabbing
final static String painStabbingPrintName = "pain stabbing";
final static String painStabbingDescription = painStabbingPrintName;
// palatePerforation
final static String palatePerforationPrintName = "palate perforation";
final static String palatePerforationDescription = palatePerforationPrintName;
// pallor
final static String pallorPrintName = "face pale";
final static String pallorDescription = pallorPrintName;
// palmsPale
final static String palmsPalePrintName = "palms pale";
final static String palmsPaleDescription = palmsPalePrintName;
// palpitations
final static String palpitationsPrintName = "heartbeats rapid and irregular";
final static String palpitationsDescription = palpitationsPrintName;
// palsy
final static String palsyPrintName = "body part tremor uncontrolled";
final static String palsyDescription = palsyPrintName; 
// palsyFace
final static String palsyFacePrintName = "face tremors uncontrolled";
final static String palsyFaceDescription = palsyFacePrintName;
// panicAttacks
final static String panicAttacksPrintName = "panic attacks";
final static String panicAttacksDescription = panicAttacksPrintName;
// papilledema
final static String papilledemaPrintName = "vision loss temporally or permanent";
final static String papilledemaDescription = papilledemaPrintName;
// papuleRedSmall
final static String papuleRedSmallPrintName = "papule red small";
final static String papuleRedSmallDescription = papuleRedSmallPrintName;
// papuleRedWarm
final static String papuleRedWarmPrintName = "papule red warm";
final static String papuleRedWarmDescription = papuleRedWarmPrintName;
// papuleUlcerated
final static String papuleUlceratedPrintName = "papule ulcer";
final static String papuleUlceratedDescription = papuleUlceratedPrintName;
// paralysis
final static String paralysisPrintName = "paralysis";
final static String paralysisDescription = paralysisPrintName;
// paralysisTransient
final static String paralysisTransientPrintName = "paralysis transient";
final static String paralysisTransientDescription = paralysisTransientPrintName;
// paranoia
final static String paranoiaPrintName = "paranoia";
final static String paranoiaDescription = paranoiaPrintName;
// paresthesia
final static String paresthesiaPrintName = 
    "skin sensation prickling itching without cause";
final static String paresthesiaDescription = paresthesiaPrintName;
// parotidGlandsSwollen
final static String parotidGlandsSwollenPrintName = "mouth parotid glands swollen";
final static String parotidGlandsSwollenDescription = parotidGlandsSwollenPrintName;
// pelvisDiscomfort
final static String pelvisDiscomfortPrintName = "pelvis discomfort";
final static String pelvisDiscomfortDescription = pelvisDiscomfortPrintName;
// pelvisPain
final static String pelvisPainPrintName = "pelvis pain";
final static String pelvisPainDescription = pelvisPainPrintName;
// pelvisRelaxation
final static String pelvisRelaxationPrintName = "pelvis relaxation";
final static String pelvisRelaxationDescription = pelvisRelaxationPrintName;
// penisEnlarged
final static String penisEnlargedPrintName = "penis enlarged";
final static String penisEnlargedDescription = penisEnlargedPrintName;
// penisGlansVesicle
final static String penisGlansVesiclePrintName = "penis glans blister";
final static String penisGlansVesicleDescription = penisGlansVesiclePrintName;
// penisGrowth
final static String penisGrowthPrintName = "penis growth";
final static String penisGrowthDescription = penisGrowthPrintName;
// penisInfantile
final static String penisInfantilePrintName = "penis infantile";
final static String penisInfantileDescription = penisInfantilePrintName;
// penisPapule
final static String penisPapulePrintName = "penis papule";
final static String penisPapuleDescription = penisPapulePrintName;
// penisVesicle
final static String penisVesiclePrintName = "penis blister";
final static String penisVesicleDescription = penisVesiclePrintName;
// penisWarts
final static String penisWartsPrintName = "penis warts";
final static String penisWartsDescription = penisWartsPrintName;
// perineumWarts
final static String perineumWartsPrintName = "perineum warts";
final static String perineumWartsDescription = perineumWartsPrintName;
// personalityChange
final static String personalityChangePrintName = "personality change";
final static String personalityChangeDescription = personalityChangePrintName;
// perspiration
final static String perspirationPrintName = "perspiration";
final static String perspirationDescription = perspirationPrintName;
// petechiae
final static String petechiaePrintName = "skin pinpoint red dots";
final static String petechiaeDescription = petechiaePrintName;
// phlebitis
final static String phlebitisPrintName = "vein inflammation";
final static String phlebitisDescription = phlebitisPrintName;
// photophobia
final static String photophobiaPrintName = "light intolerance";
final static String photophobiaDescription = photophobiaPrintName;
// pleuriticChestPain
final static String pleuriticChestPainPrintName = "chest pleuris pain";
final static String pleuriticChestPainDescription = pleuriticChestPainPrintName;
// polyarthritis
final static String polyarthritisPrintName = "joint pain migrating";
final static String polyarthritisDescription = polyarthritisPrintName;
// polydipsia
final static String polydipsiaPrintName = "fluid intake large";
final static String polydipsiaDescription = polydipsiaPrintName;
// polyuria
final static String polyuriaPrintName = "urine volume large";
final static String polyuriaDescription = polyuriaPrintName;
// postcoitalBleeding
final static String postcoitalBleedingPrintName = "intercourse bleeding after";
final static String postcoitalBleedingDescription = postcoitalBleedingPrintName;
// postcoitalPain
final static String postcoitalPainPrintName = "intercourse pain after";
final static String postcoitalPainDescription = postcoitalPainPrintName;
// postVoidingPain
final static String postVoidingPainPrintName = "pain after voiding";
final static String postVoidingPainDescription = postVoidingPainPrintName;
// prematureEjaculationSymptom
final static String prematureEjaculationSymptomPrintName = "ejaculation premature";
final static String prematureEjaculationSymptomDescription = 
    prematureEjaculationSymptomPrintName;
// prolongedExpiration
final static String prolongedExpirationPrintName = "expiration prolonged";
final static String prolongedExpirationDescription = prolongedExpirationPrintName;
// prostration
final static String prostrationPrintName = "posture exhausted or helpless";
final static String prostrationDescription = prostrationPrintName;
// pruritus
final static String pruritusPrintName = "skin itchy";
final static String pruritusDescription = pruritusPrintName;
// psychosis
final static String psychosisPrintName = "psychosis";
final static String psychosisDescription = "mental deranged";
// ptosis
final static String ptosisPrintName = "eye lid upper drooping";
final static String ptosisDescription = ptosisPrintName;
// pubertyDelayed
final static String pubertyDelayedPrintName = "puberty delayed";
final static String pubertyDelayedDescription = pubertyDelayedPrintName;
// pubisHairDevelopment
final static String pubisHairDevelopmentPrintName = "pubis hair development";
final static String pubisHairDevelopmentDescription = pubisHairDevelopmentPrintName;
// pubisHairEarly
final static String pubisHairEarlyPrintName = "pubis hair early";
final static String pubisHairEarlyDescription = pubisHairEarlyPrintName;
// pubisHairLoss
final static String pubisHairLossPrintName = "pubis hair loss";
final static String pubisHairLossDescription = pubisHairLossPrintName;
// pubisPain
final static String pubisPainPrintName = "pubis pain";
final static String pubisPainDescription = pubisPainPrintName;
// pubisSkinIrritation
final static String pubisSkinIrritationPrintName = "pubis skin irritation";
final static String pubisSkinIrritationDescription = pubisSkinIrritationPrintName;
// pulmonaryCongestion
final static String pulmonaryCongestionPrintName = "lungs congestion";
final static String pulmonaryCongestionDescription = pulmonaryCongestionPrintName;
// pulseAbsent
final static String pulseAbsentPrintName = "pulse absent";
final static String pulseAbsentDescription = pulseAbsentPrintName;
// pulseDelay
final static String pulseDelayPrintName = "pulse delayed";
final static String pulseDelayDescription = pulseDelayPrintName;
// pulseFullBounding
final static String pulseFullBoundingPrintName = "pulse full bounding";
final static String pulseFullBoundingDescription = pulseFullBoundingPrintName;
// pulsePressureNarrows
final static String pulsePressureNarrowsPrintName = "pulse pressure narrows";
final static String pulsePressureNarrowsDescription = pulsePressureNarrowsPrintName;
// pulseRapid
final static String pulseRapidPrintName = "pulse rapid";
final static String pulseRapidDescription = pulseRapidPrintName;
// pulseThready
final static String pulseThreadyPrintName = "pulse thready";
final static String pulseThreadyDescription = pulseThreadyPrintName;
// pulseWeak
final static String pulseWeakPrintName = "pulse weak";
final static String pulseWeakDescription = pulseWeakPrintName;
// pulsusAlternans
final static String pulsusAlternansPrintName = "pulsus alternans";
final static String pulsusAlternansDescription = "every other beat is weak";
// pupilChanges
final static String pupilChangesPrintName = "pupil changes";
final static String pupilChangesDescription = pupilChangesPrintName;
// pupilDilation
final static String pupilDilationPrintName = "pupil widening";
final static String pupilDilationDescription = pupilDilationPrintName;
// pupilNarrowing
final static String pupilNarrowingPrintName = "pupil narrowing";
final static String pupilNarrowingDescription = pupilNarrowingPrintName;
// pupilNonReactive
final static String pupilNonReactivePrintName = "pupil non reactive";
final static String pupilNonReactiveDescription = pupilNonReactivePrintName;
// pupilResponseUnequal
final static String pupilResponseUnequalPrintName = "pupil response unequal";
final static String pupilResponseUnequalDescription = pupilResponseUnequalPrintName;
// purpura
final static String purpuraPrintName = "skin patches red";
final static String purpuraDescription = purpuraPrintName;
// pursedLipBreathing
final static String pursedLipBreathingPrintName = "breathing by pursed lips";
final static String pursedLipBreathingDescription = pursedLipBreathingPrintName;
// pyuria
final static String pyuriaPrintName = "urine with pus";
final static String pyuriaDescription = pyuriaPrintName;
// rash
final static String rashPrintName = "rash";
final static String rashDescription = rashPrintName;
// rashCreeping
final static String rashCreepingPrintName = "rash creeping";
final static String rashCreepingDescription = rashCreepingPrintName;
// rashErupting
final static String rashEruptingPrintName = "rash erupting";
final static String rashEruptingDescription = rashEruptingPrintName;
// rashItchy
final static String rashItchyPrintName = "rash itchy";
final static String rashItchyDescription = "itchy rash";
// rashPapular **2
final static String rashPapularPrintName = "rash papular";
final static String rashPapularDescription = "cone elevated rash";
// rashRed
final static String rashRedPrintName = "rash red";
final static String rashRedDescription = rashRedPrintName;
// rashSandpapery
final static String rashSandpaperyPrintName = "rash sandpapery";
final static String rashSandpaperyDescription = rashSandpaperyPrintName;
// rashScaly 
final static String rashScalyPrintName = "rash scaly";
final static String rashScalyDescription = rashScalyPrintName;
// reboundTenderness
final static String reboundTendernessPrintName = "rebound tenderness";
final static String reboundTendernessDescription = 
      "pain caused by releasing pressure on a location";
// rectumBloodyDischarge
final static String rectumBloodyDischargePrintName = "rectum bloody discharge";
final static String rectumBloodyDischargeDescription = rectumBloodyDischargePrintName;
// rectumBurning
final static String rectumBurningPrintName = "rectum burning";
final static String rectumBurningDescription = rectumBurningPrintName;
// rectumItching
final static String rectumItchingPrintName = "rectum itchy";
final static String rectumItchingDescription = rectumItchingPrintName;
    /* replaced by vulvaRedSwollen
       // redEdematousMembranes
       final static String redEdematousMembranesPrintName = "membranes red swollen"; 
       final static String redEdematousMembranesDescription = redEdematousMembranesPrintName;
    */
// reflexControlLoss
final static String reflexControlLossPrintName = "reflex control loss";
final static String reflexControlLossDescription = reflexControlLossPrintName;
// reflexesDecreased
final static String reflexesDecreasedPrintName = "reflexes decreased";
final static String reflexesDecreasedDescription = reflexesDecreasedPrintName;
// reflexesHyperactive
final static String reflexesHyperactivePrintName = "reflexes hyperactive";
final static String reflexesHyperactiveDescription = reflexesHyperactivePrintName;
// respirationDeep
final static String respirationDeepPrintName = "respiration deep";
final static String respirationDeepDescription = respirationDeepPrintName;
// respirationDistress
final static String respirationDistressPrintName = "respiration distress";
final static String respirationDistressDescription = respirationDistressPrintName;
// respirationKussmaul
final static String respirationKussmaulPrintName = "respiration slow and deep";
final static String respirationKussmaulDescription = respirationKussmaulPrintName;
// respirationLabored
final static String respirationLaboredPrintName = "respiration labored";
final static String respirationLaboredDescription = respirationLaboredPrintName;
// respirationParalysis
final static String respirationParalysisPrintName = "respiration paralysis";
final static String respirationParalysisDescription = respirationParalysisPrintName;
// respirationRapid = tachypnea
    // final static String respirationRapidPrintName = "respiration rapid";
    // final static String respirationRapidDescription = respirationRapidPrintName;
// respirationRetractive 
final static String respirationRetractivePrintName = "respiration retractive";
final static String respirationRetractiveDescription = 
      "inward movement of the chest on inspiration";
// respirationShallow 
final static String respirationShallowPrintName = "respiration shallow";
final static String respirationShallowDescription = respirationShallowPrintName;
// respirationSporadic
final static String respirationSporadicPrintName = "respiration sporadic";
final static String respirationSporadicDescription = respirationSporadicPrintName;
// restlessness
final static String restlessnessPrintName = "restlessness";
final static String restlessnessDescription = restlessnessPrintName;
// retinaHemorrhage
final static String retinaHemorrhagePrintName = "retina bleeding";
final static String retinaHemorrhageDescription = "bleeding in the eyes";
// retinaInflammation
final static String retinaInflammationPrintName = "retina inflammation";
final static String retinaInflammationDescription = retinaInflammationPrintName;
// retrosternalChestPain
final static String retrosternalChestPainPrintName = "breastbone behind pain";
final static String retrosternalChestPainDescription = retrosternalChestPainPrintName;
// rhinitis
final static String rhinitisPrintName = "nose membranes inflammation";
final static String rhinitisDescription = rhinitisPrintName;
// rhonchus
final static String rhonchusPrintName = "breathing sound coarse rattling";
final static String rhonchusDescription = rhonchusPrintName;
// rigidity
final static String rigidityPrintName = "rigidity";
final static String rigidityDescription = rigidityPrintName;
// ritualistic
final static String ritualisticPrintName = "ritualistic";
final static String ritualisticDescription = ritualisticPrintName;
// roleFunctioningDetoriation
final static String roleFunctioningDetoriationPrintName = "role functioning detoriated";
final static String roleFunctioningDetoriationDescription = roleFunctioningDetoriationPrintName;
// roundback
final static String roundbackPrintName = "roundback";
final static String roundbackDescription = "excessive curving of the back";
// salivation
final static String salivationPrintName = "salivation";
final static String salivationDescription = salivationPrintName;
// scab
final static String scabPrintName = "scab";
final static String scabDescription = scabPrintName;
// scalpNodule
final static String scalpNodulePrintName = "scalp nodule";
final static String scalpNoduleDescription = scalpNodulePrintName;
// scalpWound
final static String scalpWoundPrintName = "scalp wound";
final static String scalpWoundDescription = scalpWoundPrintName;
// scrotumEnlarged
final static String scrotumEnlargedPrintName = "scrotum enlarged";
final static String scrotumEnlargedDescription = scrotumEnlargedPrintName;
// scrotumSwellingPainful
final static String scrotumSwellingPainfulPrintName = "scrotum swelling painful";
final static String scrotumSwellingPainfulDescription = scrotumSwellingPainfulPrintName;
// seeingHalosAroundLights
final static String seeingHalosAroundLightsPrintName = "seeing halos around lights";
final static String seeingHalosAroundLightsDescription = seeingHalosAroundLightsPrintName;
// seizure
final static String seizurePrintName = "seizure";
final static String seizureDescription = seizurePrintName;
// selfAwarenessHigh
final static String selfAwarenessHighPrintName = "self awareness high";
final static String selfAwarenessHighDescription = selfAwarenessHighPrintName;
// selfDoubt
final static String selfDoubtPrintName = "self doubt";
final static String selfDoubtDescription = selfDoubtPrintName;
// sensoryChanges
final static String sensoryChangesPrintName = "sensory perception changed";
final static String sensoryChangesDescription = sensoryChangesPrintName;
// severeMalaise
final static String severeMalaisePrintName = "malaise severe";
final static String severeMalaiseDescription = severeMalaisePrintName;
// sexChangeDesire
final static String sexChangeDesirePrintName = "sex change desired";
final static String sexChangeDesireDescription = sexChangeDesirePrintName;
// sexDriveLow
final static String sexDriveLowPrintName = "sex drive low";
final static String sexDriveLowDescription = sexDriveLowPrintName;
// sexualArousalFromChildren
final static String sexualArousalFromChildrenPrintName = "sexual arousal from children";
final static String sexualArousalFromChildrenDescription = sexualArousalFromChildrenPrintName;
// sexualArousalFromCrossDressing
final static String sexualArousalFromCrossDressingPrintName = "sexual arousal from cross dressing";
final static String sexualArousalFromCrossDressingDescription = sexualArousalFromCrossDressingPrintName;
// sexualArousalFromInanimateObjects
final static String sexualArousalFromInanimateObjectsPrintName = "sexual arousal from inanimate objects";
final static String sexualArousalFromInanimateObjectsDescription = 
    sexualArousalFromInanimateObjectsPrintName;
// sexualArousalFromInflictingRealOrFantasizedPain
final static String sexualArousalFromInflictingRealOrFantasizedPainPrintName = 
    "sexual arousal from inflicting real or fantasized pain";
final static String sexualArousalFromInflictingRealOrFantasizedPainDescription = 
    sexualArousalFromInflictingRealOrFantasizedPainPrintName;
// sexualArousalFromObtainingRealOrFantasizedPain
final static String sexualArousalFromObtainingRealOrFantasizedPainPrintName = 
    "sexual arousal from obtaining real or fantasized pain";
final static String sexualArousalFromObtainingRealOrFantasizedPainDescription = 
    sexualArousalFromObtainingRealOrFantasizedPainPrintName;
// sexualArousalFromRubbingANonconsentingPerson
final static String sexualArousalFromRubbingANonconsentingPersonPrintName = 
    "sexual arousal from rubbing a nonconsenting person";
final static String sexualArousalFromRubbingANonconsentingPersonDescription = 
    sexualArousalFromRubbingANonconsentingPersonPrintName;
// sexualArousalFromWatchingSexualSituations
final static String sexualArousalFromWatchingSexualSituationsPrintName = 
    "sexual arousal from watching sexual situations";
final static String sexualArousalFromWatchingSexualSituationsDescription = 
    sexualArousalFromWatchingSexualSituationsPrintName;
// sexualDesireAbsent
final static String sexualDesireAbsentPrintName = "sexual desire absent";
final static String sexualDesireAbsentDescription = sexualDesireAbsentPrintName;
// sexualDysfunction
final static String sexualDysfunctionPrintName = "sexual dysfunction";
final static String sexualDysfunctionDescription = sexualDysfunctionPrintName;
// sexualStimulationIgnored
final static String sexualStimulationIgnoredPrintName = "sexual stimulation ignored";
final static String sexualStimulationIgnoredDescription = sexualStimulationIgnoredPrintName;
// shaking
final static String shakingPrintName = "shaking";
final static String shakingDescription = shakingPrintName;
// shoulderPain
final static String shoulderPainPrintName = "shoulder pain";
final static String shoulderPainDescription = shoulderPainPrintName;
// sinusPain
final static String sinusPainPrintName = "sinus pain";
final static String sinusPainDescription = sinusPainPrintName;
// sinusSwelling
final static String sinusSwellingPrintName = "sinus swelling";
final static String sinusSwellingDescription = sinusSwellingPrintName;
    /*
// skinBlue => cynanosis
final static String skinBluePrintName = "skin blue";
final static String skinBlueDescription = skinBluePrintName;
    */
// skinBurnedLeatheryBlack
final static String skinBurnedLeatheryBlackPrintName = "skin burned leathery black";
final static String skinBurnedLeatheryBlackDescription = skinBurnedLeatheryBlackPrintName;
// skinBurnedLeatheryBrown
final static String skinBurnedLeatheryBrownPrintName = "skin burned leathery brown";
final static String skinBurnedLeatheryBrownDescription = skinBurnedLeatheryBrownPrintName;
// skinBurnedLeatheryWhite
final static String skinBurnedLeatheryWhitePrintName = "skin burned leathery white";
final static String skinBurnedLeatheryWhiteDescription = skinBurnedLeatheryWhitePrintName;
// skinBurnedPain
final static String skinBurnedPainPrintName = "skin burned pain";
final static String skinBurnedPainDescription = skinBurnedPainPrintName;
// skinBurning
final static String skinBurningPrintName = "skin burning";
final static String skinBurningDescription = skinBurningPrintName;
// skinClammy
final static String skinClammyPrintName = "skin clammy";
final static String skinClammyDescription = skinClammyPrintName;
// skinCold
final static String skinColdPrintName = "skin cold";
final static String skinColdDescription = skinColdPrintName;
// skinDiscoloration
final static String skinDiscolorationPrintName = "skin discoloration";
final static String skinDiscolorationDescription = skinDiscolorationPrintName;
// skinDry
final static String skinDryPrintName = "skin dry";
final static String skinDryDescription = skinDryPrintName;
// skinDusky
final static String skinDuskyPrintName = "skin dusky";
final static String skinDuskyDescription = skinDuskyPrintName;
// skinElasticityLoss
final static String skinElasticityLossPrintName = "skin elasticity loss";
final static String skinElasticityLossDescription = skinElasticityLossPrintName;
// skinFaceTight
final static String skinFaceTightPrintName = "skin face tight";
final static String skinFaceTightDescription = skinFaceTightPrintName;
// skinFlushing
final static String skinFlushingPrintName = "skin flushing";
final static String skinFlushingDescription = skinFlushingPrintName;
// skinGumma
final static String skinGummaPrintName = "skin gumma";
final static String skinGummaDescription = skinGummaPrintName;
// skinHandsTight
final static String skinHandsTightPrintName = "skin hands tight";
final static String skinHandsTightDescription = skinHandsTightPrintName;
// skinInfection
final static String skinInfectionPrintName = "skin infection";
final static String skinInfectionDescription = skinInfectionPrintName;
// skinLesionBackgroundBrownBlack
final static String skinLesionBackgroundBrownBlackPrintName = 
    "skin lesion brown-black background";
final static String skinLesionBackgroundBrownBlackDescription = 
    skinLesionBackgroundBrownBlackPrintName;
// skinLesionBlackNodules
final static String skinLesionBlackNodulesPrintName = "skin lesion with black nodules";
final static String skinLesionBlackNodulesDescription = skinLesionBlackNodulesPrintName;
// skinLesionBlackberryLike
final static String skinLesionBlackberryLikePrintName = "skin lesion blackberry like";
final static String skinLesionBlackberryLikeDescription = skinLesionBlackberryLikePrintName;
// skinLesionBlue
final static String skinLesionBluePrintName = "skin lesion blue";
final static String skinLesionBlueDescription = skinLesionBluePrintName;
// skinLesionCoinShaped
final static String skinLesionCoinShapedPrintName = "skin lesion coin shaped";
final static String skinLesionCoinShapedDescription = skinLesionCoinShapedPrintName;
// skinLesionCrackedCrusty
final static String skinLesionCrackedCrustyPrintName = "skin lesion cracked crusty";
final static String skinLesionCrackedCrustyDescription = skinLesionCrackedCrustyPrintName;
// skinLesionDryScaly
final static String skinLesionDryScalyPrintName = "skin lesion dry scaly";
final static String skinLesionDryScalyDescription = skinLesionDryScalyPrintName;
// skinLesionEnlarged
final static String skinLesionEnlargedPrintName = "skin lesion enlarged";
final static String skinLesionEnlargedDescription = skinLesionEnlargedPrintName;
// skinLesionFoot
final static String skinLesionFootPrintName = "skin lesion on foot";
final static String skinLesionFootDescription = skinLesionFootPrintName;
// skinLesionFreckelLike
final static String skinLesionFreckelLikePrintName = "skin lesion freckel like";
final static String skinLesionFreckelLikeDescription = skinLesionFreckelLikePrintName;
// skinLesionFuzzyBorder
final static String skinLesionFuzzyBorderPrintName = "skin lesion fuzzy border";
final static String skinLesionFuzzyBorderDescription = skinLesionFuzzyBorderPrintName;
// skinLesionGreasy
final static String skinLesionGreasyPrintName = "skin lesion greasy";
final static String skinLesionGreasyDescription = skinLesionGreasyPrintName;
// skinLesionHand
final static String skinLesionHandPrintName = "skin lesion hand";
final static String skinLesionHandDescription = skinLesionHandPrintName;
// skinLesionLightlyPigmented
final static String skinLesionLightlyPigmentedPrintName = "skin lesion lightly pigmented";
final static String skinLesionLightlyPigmentedDescription = skinLesionLightlyPigmentedPrintName;
// skinLesionMacular
final static String skinLesionMacularPrintName = "skin lesion discolored";
final static String skinLesionMacularDescription = skinLesionMacularPrintName;
// skinLesionMoistCrusty
final static String skinLesionMoistCrustyPrintName = "skin lesion moist crusty";
final static String skinLesionMoistCrustyDescription = skinLesionMoistCrustyPrintName;
// skinLesionNodulesBleeding
final static String skinLesionNodulesBleedingPrintName = "skin lesion nodules bleeding";
final static String skinLesionNodulesBleedingDescription = skinLesionNodulesBleedingPrintName;
// skinLesionPinkWhite
final static String skinLesionPinkWhitePrintName = "skin lesion pink white";
final static String skinLesionPinkWhiteDescription = skinLesionPinkWhitePrintName;
// skinLesionPlaqueLike
final static String skinLesionPlaqueLikePrintName = "skin lesion plaque like";
final static String skinLesionPlaqueLikeDescription = skinLesionPlaqueLikePrintName;
// skinLesionRedNodule
final static String skinLesionRedNodulePrintName = "skin lesions of red nodules";
final static String skinLesionRedNoduleDescription = skinLesionRedNodulePrintName;
// skinLesionRedPapular
final static String skinLesionRedPapularPrintName = "skin lesion red papular";
final static String skinLesionRedPapularDescription = skinLesionRedPapularPrintName;
// skinLesionRedStreaked
final static String skinLesionRedStreakedPrintName = "skin lesion red streaked";
final static String skinLesionRedStreakedDescription = skinLesionRedStreakedPrintName;
// skinLesionRedSwollenRaised
final static String skinLesionRedSwollenRaisedPrintName = "skin lesion red swollen raised";
final static String skinLesionRedSwollenRaisedDescription = skinLesionRedSwollenRaisedPrintName;
// skinLesionRedWeeping
final static String skinLesionRedWeepingPrintName = "skin lesion red weeping";
final static String skinLesionRedWeepingDescription = skinLesionRedWeepingPrintName;
// skinLesionRedWhite
final static String skinLesionRedWhitePrintName = "skin lesion red white";
final static String skinLesionRedWhiteDescription = skinLesionRedWhitePrintName;
// skinLesionRingShaped
final static String skinLesionRingShapedPrintName = "skin lesion ring shaped";
final static String skinLesionRingShapedDescription = skinLesionRingShapedPrintName; 
// skinLesionSharpBorder
final static String skinLesionSharpBorderPrintName = "skin lesion sharp border";
final static String skinLesionSharpBorderDescription = skinLesionSharpBorderPrintName;
// skinLesionSurfaceIrregular
final static String skinLesionSurfaceIrregularPrintName = "skin lesion surface irregular";
final static String skinLesionSurfaceIrregularDescription = skinLesionSurfaceIrregularPrintName;
// skinLesionUniformDarkColor
final static String skinLesionUniformDarkColorPrintName = "skin lesion uniform dark color";
final static String skinLesionUniformDarkColorDescription = skinLesionUniformDarkColorPrintName;
// skinLesionYellowScales
final static String skinLesionYellowScalesPrintName = "skin lesion yellow scales";
final static String skinLesionYellowScalesDescription = skinLesionYellowScalesPrintName;
// skinLesionYellowish
final static String skinLesionYellowishPrintName = "skin lesion yellowish";
final static String skinLesionYellowishDescription = skinLesionYellowishPrintName;
// skinMottled
final static String skinMottledPrintName = "skin mottled";
final static String skinMottledDescription = skinMottledPrintName; 
// skinNodules
final static String skinNodulesPrintName = "skin nodules";
final static String skinNodulesDescription = skinNodulesPrintName;
// skinNumbness
final static String skinNumbnessPrintName = "skin numbness";
final static String skinNumbnessDescription = skinNumbnessPrintName;
// skinOfGenitalChancre
final static String skinOfGenitalChancrePrintName = "skin with genital chancre";
final static String skinOfGenitalChancreDescription = skinOfGenitalChancrePrintName;
// skinPale
final static String skinPalePrintName = "skin pale";
final static String skinPaleDescription = skinPalePrintName;
// skinPatchesPurple
final static String skinPatchesPurplePrintName = "skin patches purple";
final static String skinPatchesPurpleDescription = skinPatchesPurplePrintName;
// skinPeeling
final static String skinPeelingPrintName = "skin peeling";
final static String skinPeelingDescription = skinPeelingPrintName;
// skinPlaques
final static String skinPlaquesPrintName = "skin plaques";
final static String skinPlaquesDescription = skinPlaquesPrintName;
// skinPlaquesRaised
final static String skinPlaquesRaisedPrintName = "skin plaques raised";
final static String skinPlaquesRaisedDescription = skinPlaquesRaisedPrintName;
// skinPlaquesRed
final static String skinPlaquesRedPrintName = "skin plaques red";
final static String skinPlaquesRedDescription = skinPlaquesRedPrintName;
// skinPlaquesScailed
final static String skinPlaquesScaledPrintName = "skin plaques scaled";
final static String skinPlaquesScaledDescription = skinPlaquesScaledPrintName;
// skinPricking
final static String skinPrickingPrintName = "skin pricking";
final static String skinPrickingDescription = skinPrickingPrintName;
// skinSilveryScales
final static String skinSilveryScalesPrintName = "skin silvery scales";
final static String skinSilveryScalesDescription = skinSilveryScalesPrintName;
// skinSwollen
final static String skinSwollenPrintName = "skin swollen";
final static String skinSwollenDescription = skinSwollenPrintName;
// skinTender
final static String skinTenderPrintName = "skin tender";
final static String skinTenderDescription = skinTenderPrintName;
// skinTingling
final static String skinTinglingPrintName = "skin tingling";
final static String skinTinglingDescription = skinTinglingPrintName;
// skinTissueCharred
final static String skinTissueCharredPrintName = "skin tissue charred";
final static String skinTissueCharredDescription = skinTissueCharredPrintName;
// skinToneAdult
final static String skinToneAdultPrintName = "skin tone adult";
final static String skinToneAdultDescription = skinToneAdultPrintName;
// skinWarm
final static String skinWarmPrintName = "skin warm";
final static String skinWarmDescription = skinWarmPrintName;
// skinWaxy
final static String skinWaxyPrintName = "skin waxy";
final static String skinWaxyDescription = skinWaxyPrintName;
// skullDistension
final static String skullDistensionPrintName = "skull distension";
final static String skullDistensionDescription = skullDistensionPrintName;
// sleepDisturbed
final static String sleepDisturbedPrintName = "sleep disturbed";
final static String sleepDisturbedDescription = sleepDisturbedPrintName;
// slightAlopecia
final static String slightAlopeciaPrintName = "baldness slight";
final static String slightAlopeciaDescription = slightAlopeciaPrintName;
// sluggishness
final static String sluggishnessPrintName = "sluggish";
final static String sluggishnessDescription = sluggishnessPrintName;
// sneezing
final static String sneezingPrintName = "sneezing";
final static String sneezingDescription = sneezingPrintName;
// socialPerformanceFear
final static String socialPerformanceFearPrintName = "social performance fear"; 
final static String socialPerformanceFearDescription = socialPerformanceFearPrintName;
// socialWithdrawal
final static String socialWithdrawalPrintName = "social withdrawal";
final static String socialWithdrawalDescription = socialWithdrawalPrintName;
// somnolence
final static String somnolencePrintName = "sleepy";
final static String somnolenceDescription = somnolencePrintName;
// spasm
final static String spasmPrintName = "spasm";
final static String spasmDescription = "muscle contraction unwanted";
// speechDifficulty
final static String speechDifficultyPrintName = "speech difficulty";
final static String speechDifficultyDescription = speechDifficultyPrintName;
// speechSlurred
final static String speechSlurredPrintName = "speech slurred";
final static String speechSlurredDescription = speechSlurredPrintName;
// speechUnintelligible
final static String speechUnintelligiblePrintName = "speech unintelligible";
final static String speechUnintelligibleDescription = speechUnintelligiblePrintName;
// speechUnusual
final static String speechUnusualPrintName = "speech unusual";
final static String speechUnusualDescription = speechUnusualPrintName;
// spiderBite
final static String spiderBitePrintName = "spider bite";
final static String spiderBiteDescription = spiderBitePrintName;
// spineDeformation
final static String spineDeformationPrintName = "spine deformation";
final static String spineDeformationDescription = spineDeformationPrintName;
// spineStiff
final static String spineStiffPrintName = "spine stiff";
final static String spineStiffDescription = spineStiffPrintName;
// spotting
final static String spottingPrintName = "spotting";
final static String spottingDescription = spottingPrintName;
// sputumBlack
final static String sputumBlackPrintName = "sputum black"; 
final static String sputumBlackDescription = sputumBlackPrintName;
// sputumBloody
final static String sputumBloodyPrintName = "sputum bloody";
final static String sputumBloodyDescription = sputumBloodyPrintName;
// sputumFoulSmelling
final static String sputumFoulSmellingPrintName = "sputum foul smelling";
final static String sputumFoulSmellingDescription = sputumFoulSmellingPrintName;
// sputumFrothy
final static String sputumFrothyPrintName = "sputum frothy";
final static String sputumFrothyDescription = sputumFrothyPrintName;
// sputumGray
final static String sputumGrayPrintName = "sputum gray";
final static String sputumGrayDescription = sputumGrayPrintName;
// sputumMucoid
final static String sputumMucoidPrintName = "sputum slippery";
final static String sputumMucoidDescription = sputumMucoidPrintName;
// sputumMucopurulent
final static String sputumMucopurulentPrintName = "sputum with mucues and pus";
final static String sputumMucopurulentDescription = sputumMucopurulentPrintName;
// sputumProduction
final static String sputumProductionPrintName = "sputum production";
final static String sputumProductionDescription = sputumProductionPrintName;
// sputumPurulent
final static String sputumPurulentPrintName = "sputum with pus";
final static String sputumPurulentDescription = sputumPurulentPrintName;
// sputumYellowGreenThick
final static String sputumYellowGreenThickPrintName = "sputum yellow green thick";
final static String sputumYellowGreenThickDescription = sputumYellowGreenThickPrintName;
// stabbingChestPain
final static String stabbingChestPainPrintName = "chest pain stabbing";
final static String stabbingChestPainDescription = stabbingChestPainPrintName;
    // steatorrhea 
    // final static String steatorrheaPrintName = "steatorrhea";
    // final static String steatorrheaDescription = "stool bulky and foul smelling";
// stiffness
final static String stiffnessPrintName = "stiffness";
final static String stiffnessDescription = stiffnessPrintName;
// stomachache
final static String stomachachePrintName = "stomachache";
final static String stomachacheDescription = stomachachePrintName;
// stomachCramps
final static String stomachCrampsPrintName = "stomach cramps";
final static String stomachCrampsDescription = stomachCrampsPrintName;
// stomachSwelling
final static String stomachSwellingPrintName = "stomach swelling";
final static String stomachSwellingDescription = stomachSwellingPrintName;
// stomachUpset
final static String stomachUpsetPrintName = "stomach upset";
final static String stomachUpsetDescription = stomachUpsetPrintName;
// stoolBlack
final static String stoolBlackPrintName = "stool black";
final static String stoolBlackDescription = stoolBlackPrintName;
// stoolBloody
final static String stoolBloodyPrintName = "stool bloody";
final static String stoolBloodyDescription = stoolBloodyPrintName;
// stoolBrightRedBloody
final static String stoolBrightRedBloodyPrintName = "stool bright red bloody";
final static String stoolBrightRedBloodyDescription = stoolBrightRedBloodyPrintName;
// stoolClayColored
final static String stoolClayColoredPrintName = "stool clay colored";
final static String stoolClayColoredDescription = stoolClayColoredPrintName;
// stoolFrequent
final static String stoolFrequentPrintName = "stool frequent";
final static String stoolFrequentDescription = stoolFrequentPrintName;
// stoolGreasy
final static String stoolGreasyPrintName = "stool greasy";
final static String stoolGreasyDescription = stoolGreasyPrintName;
// stoolMalodorous
final static String stoolMalodorousPrintName = "stool stinking";
final static String stoolMalodorousDescription = stoolMalodorousPrintName; 
// stoolTarry
final static String stoolTarryPrintName = "stool tarry";
final static String stoolTarryDescription = stoolTarryPrintName;
// stoolThinShaped
final static String stoolThinShapedPrintName = "stool thin shaped";
final static String stoolThinShapedDescription = stoolThinShapedPrintName;
// stoolWatery
final static String stoolWateryPrintName = "stool watery";
final static String stoolWateryDescription = stoolWateryPrintName;
// striaePurplish
final static String striaePurplishPrintName = "skin purplish lines";
final static String striaePurplishDescription = striaePurplishPrintName;
// stridor
final static String stridorPrintName = "breathing noisy";
final static String stridorDescription = stridorPrintName;
// stupor
final static String stuporPrintName = "stupor";
final static String stuporDescription = stuporPrintName;
// substernalPain
final static String substernalPainPrintName = "breastbone below pain";
final static String substernalPainDescription = substernalPainPrintName;
// suckingSoundWhileBreathing
final static String suckingSoundWhileBreathingPrintName = 
    "breathing with sucking sound";
final static String suckingSoundWhileBreathingDescription = 
    suckingSoundWhileBreathingPrintName;
// suicideThoughts
final static String suicideThoughtsPrintName = "suicide thoughts";
final static String suicideThoughtsDescription = suicideThoughtsPrintName;
// suspiciousness
final static String suspiciousnessPrintName = "suspiciousness";
final static String suspiciousnessDescription = suspiciousnessPrintName;
// swallowingDifficult = dysphagia
    // final static String swallowingDifficultPrintName = "swallowing difficult";
    // final static String swallowingDifficultDescription = swallowingDifficultPrintName;
// swallowingPainful
final static String swallowingPainfulPrintName = "swallowing painful";
final static String swallowingPainfulDescription = swallowingPainfulPrintName;
// sweating
final static String sweatingPrintName = "sweating";
final static String sweatingDescription = sweatingPrintName;
// swellingLocal
final static String swellingLocalPrintName = "swelling local";
final static String swellingLocalDescription = swellingLocalPrintName;
// syncope
final static String syncopePrintName = "consciousness loss briefly";
final static String syncopeDescription = syncopePrintName;
// tachycardia
final static String tachycardiaPrintName = "heartbeat fast";
final static String tachycardiaDescription = tachycardiaPrintName;
// tachypnea
final static String tachypneaPrintName = "breathing fast";
final static String tachypneaDescription = tachypneaPrintName;
// talkative
final static String talkativePrintName = "talkative";
final static String talkativeDescription = talkativePrintName;
// thinkingFuzzy
final static String thinkingFuzzyPrintName = "thinking fuzzy";
final static String thinkingFuzzyDescription = thinkingFuzzyPrintName;
// tasteLoss
final static String tasteLossPrintName = "taste loss";
final static String tasteLossDescription = tasteLossPrintName;
// tearing
final static String tearingPrintName = "tearing";
final static String tearingDescription = tearingPrintName;
// teethLoose
final static String teethLoosePrintName = "teeth loose";
final static String teethLooseDescription = teethLoosePrintName;
// teethSore
final static String teethSorePrintName = "teeth sore";
final static String teethSoreDescription = teethSorePrintName;
// temperatureSwingsSevere
final static String temperatureSwingsSeverePrintName = "temperature swings severe";
final static String temperatureSwingsSevereDescription = temperatureSwingsSeverePrintName;
// tendernessLocal
final static String tendernessLocalPrintName = "tenderness local";
final static String tendernessLocalDescription = tendernessLocalPrintName;
// tendonReflexDecreased
final static String tendonReflexDecreasedPrintName = "tendon reflex decreased";
final static String tendonReflexDecreasedDescription = tendonReflexDecreasedPrintName;
// tendonReflexesHyperactive
final static String tendonReflexesHyperactivePrintName = "tendon reflex hyperactive";
final static String tendonReflexesHyperactiveDescription = tendonReflexesHyperactivePrintName;
// tenesmus
final static String tenesmusPrintName = "stool painful";
final static String tenesmusDescription = tenesmusPrintName;
// testicleNodule
final static String testicleNodulePrintName = "testicle nodule";
final static String testicleNoduleDescription = testicleNodulePrintName;
// testiclePain
final static String testiclePainPrintName = "testicle pain";
final static String testiclePainDescription = testiclePainPrintName;
// testicleSizeDiffer
final static String testicleSizeDifferPrintName = "testicle size differ";
final static String testicleSizeDifferDescription = testicleSizeDifferPrintName;
// testicleSoft
final static String testicleSoftPrintName = "testicle soft";
final static String testicleSoftDescription = testicleSoftPrintName;
// testiclesEnlarged
final static String testiclesEnlargedPrintName = "testicles enlarged";
final static String testiclesEnlargedDescription = testiclesEnlargedPrintName;
// tetany
final static String tetanyPrintName = "muscles contraction unwanted";
final static String tetanyDescription = tetanyPrintName;
// thickMucus
final static String thickMucusPrintName = "mucus thick";
final static String thickMucusDescription = thickMucusPrintName;
// thighPapule
final static String thighPapulePrintName = "thigh papule";
final static String thighPapuleDescription = thighPapulePrintName;
// thirst
final static String thirstPrintName = "thirst";
final static String thirstDescription = thirstPrintName;
// thirstExcessive
final static String thirstExcessivePrintName = "thirst excessive";
final static String thirstExcessiveDescription = thirstExcessivePrintName;
// thoughtsDisturbing
final static String thoughtsDisturbingPrintName = "thoughts disturbing";
final static String thoughtsDisturbingDescription = thoughtsDisturbingPrintName;
// throatConstriction
final static String throatConstrictionPrintName = "throat constriction";
final static String throatConstrictionDescription = throatConstrictionPrintName;
// throatDry
final static String throatDryPrintName = "throat dry";
final static String throatDryDescription = throatDryPrintName;
// throatItches
final static String throatItchesPrintName = "throat itches";
final static String throatItchesDescription = throatItchesPrintName;
// throatRed
final static String throatRedPrintName = "throat red";
final static String throatRedDescription = throatRedPrintName;
// throatScale
final static String throatScalePrintName = "throat scale";
final static String throatScaleDescription = throatScalePrintName;
// throatSore
final static String throatSorePrintName = "throat sore";
final static String throatSoreDescription = throatSorePrintName;
// throatSpasm
final static String throatSpasmPrintName = "throat spasm";
final static String throatSpasmDescription = throatSpasmPrintName;
// throatWhitePatches
final static String throatWhitePatchesPrintName = "throat white patches";
final static String throatWhitePatchesDescription = throatWhitePatchesPrintName;
// thyroidEnlargement
final static String thyroidEnlargementPrintName = "thyroid enlargement";
final static String thyroidEnlargementDescription = thyroidEnlargementPrintName;
// tickInSkin
final static String tickInSkinPrintName = "tick in skin";
final static String tickInSkinDescription = tickInSkinPrintName;
// tingling
final static String tinglingPrintName = "tingling";
final static String tinglingDescription = tinglingPrintName;
// tinnitus
final static String tinnitusPrintName = "ears having ringing sound";
final static String tinnitusDescription = tinnitusPrintName;
// toeNailCrumble
final static String toeNailCrumblePrintName = "toe nail crumble";
final static String toeNailCrumbleDescription = toeNailCrumblePrintName;
// toeNailDiscolor
final static String toeNailDiscolorPrintName = "toe nail discolor";
final static String toeNailDiscolorDescription = toeNailDiscolorPrintName;
// toeNailThicken
final static String toeNailThickenPrintName = "toe nail thicken";
final static String toeNailThickenDescription = toeNailThickenPrintName;
// toesBetweenBlisters
final static String toesBetweenBlistersPrintName = "toes with blisters between them";
final static String toesBetweenBlistersDescription = toesBetweenBlistersPrintName;
// toesBetweenScaling
final static String toesBetweenScalingPrintName = "toes scaling between them";
final static String toesBetweenScalingDescription = toesBetweenScalingPrintName;
// toesNumbness
final static String toesNumbnessPrintName = "toes numb";
final static String toesNumbnessDescription = toesNumbnessPrintName;
// toesTingling
final static String toesTinglingPrintName = "toes tingling";
final static String toesTinglingDescription = toesTinglingPrintName;
// tongueChancre
final static String tongueChancrePrintName = "tongue chancre";
final static String tongueChancreDescription = tongueChancrePrintName;
// tongueCoating
final static String tongueCoatingPrintName = "tongue coating";
final static String tongueCoatingDescription = tongueCoatingPrintName;
// tonguePainful
final static String tonguePainfulPrintName = "tongue painful";
final static String tonguePainfulDescription = tonguePainfulPrintName;
// tonguePale
final static String tonguePalePrintName = "tongue pale";
final static String tonguePaleDescription = tonguePalePrintName;
// tonguePapule
final static String tonguePapulePrintName = "tongue papule";
final static String tonguePapuleDescription = "tongue papule";
// tongueRed
final static String tongueRedPrintName = "tongue red";
final static String tongueRedDescription = tongueRedPrintName;
// tongueSwollen
final static String tongueSwollenPrintName = "tongue swollen";
final static String tongueSwollenDescription = tongueSwollenPrintName;
// tonsilChancre
final static String tonsilChancrePrintName = "tonsil chancre";
final static String tonsilChancreDescription = tonsilChancrePrintName;
// tonsilsExude
final static String tonsilsExudePrintName = "tonsils oozing";
final static String tonsilsExudeDescription = tonsilsExudePrintName;
// tonsilsSwollen
final static String tonsilsSwollenPrintName = "tonsils swollen";
final static String tonsilsSwollenDescription = tonsilsSwollenPrintName;
// trembling
final static String tremblingPrintName = "trembling";
final static String tremblingDescription = tremblingPrintName;
// tremors
final static String tremorsPrintName = "tremors";
final static String tremorsDescription = tremorsPrintName;
// twitching
final static String twitchingPrintName = "twitching";
final static String twitchingDescription = twitchingPrintName;
// ulcer
final static String ulcerPrintName = "ulcer";
final static String ulcerDescription = ulcerPrintName;
// ulcerBleedsEasily
final static String ulcerBleedsEasilyPrintName = "ulcer bleeds easily";
final static String ulcerBleedsEasilyDescription = ulcerBleedsEasilyPrintName;
// ulcerGray
final static String ulcerGrayPrintName = "ulcer gray";
final static String ulcerGrayDescription = ulcerGrayPrintName;
// ulcerMalodorous
final static String ulcerMalodorousPrintName = "ulcer stinking";
final static String ulcerMalodorousDescription = ulcerMalodorousPrintName;
// ulcerPainful
final static String ulcerPainfulPrintName = "ulcer painful";
final static String ulcerPainfulDescription = ulcerPainfulPrintName;
// ulcerShallow
final static String ulcerShallowPrintName = "ulcer shallow";
final static String ulcerShallowDescription = ulcerShallowPrintName;
// ulcerSoft
final static String ulcerSoftPrintName = "ulcer soft";
final static String ulcerSoftDescription = ulcerSoftPrintName;
// unhappy
final static String unhappyPrintName = "unhappy";
final static String unhappyDescription = unhappyPrintName;
// unrealityFeeling
final static String unrealityFeelingPrintName = "unreality feeling";
final static String unrealityFeelingDescription = unrealityFeelingPrintName;
// uremicBreath
final static String uremicBreathPrintName = "breath uremic";
final static String uremicBreathDescription = "breath with fishy odor";
// urethraFemaleDischargePurulent
final static String urethraFemaleDischargePurulentPrintName = 
    "urethra female discharge pussy";
final static String urethraFemaleDischargePurulentDescription = 
    urethraFemaleDischargePurulentPrintName;
// urethraFemaleItching
final static String urethraFemaleItchingPrintName = "urethra female itching";
final static String urethraFemaleItchingDescription = urethraFemaleItchingPrintName;
// urethraFemaleRed
final static String urethraFemaleRedPrintName = "urethra female red";
final static String urethraFemaleRedDescription = urethraFemaleRedPrintName;
// urethraFemaleSwollen
final static String urethraFemaleSwollenPrintName = "urethra female swollen";
final static String urethraFemaleSwollenDescription = urethraFemaleSwollenPrintName;
// urethraMaleDischarge
final static String urethraMaleDischargePrintName = "urethra male discharge";
final static String urethraMaleDischargeDescription = urethraMaleDischargePrintName;
// urethraMaleDischargePurulent
final static String urethraMaleDischargePurulentPrintName = "urethra discharge pussy";
final static String urethraMaleDischargePurulentDescription = urethraMaleDischargePurulentPrintName;
// urethraWarts
final static String urethraWartsPrintName = "urethra warts";
final static String urethraWartsDescription = urethraWartsPrintName;
// urinaryBurning
final static String urinaryBurningPrintName = "urinary burning";
final static String urinaryBurningDescription = urinaryBurningPrintName;
// urinaryFrequency
final static String urinaryFrequencyPrintName = "urinary frequency";
final static String urinaryFrequencyDescription = urinaryFrequencyPrintName;
// urinaryHesitancy
final static String urinaryHesitancyPrintName = "urinary hesitant";
final static String urinaryHesitancyDescription = urinaryHesitancyPrintName;
// urinaryStreamInterrupted
final static String urinaryStreamInterruptedPrintName = "urinary stream interrupted";
final static String urinaryStreamInterruptedDescription = urinaryStreamInterruptedPrintName;
// urinaryStreamReduced
final static String urinaryStreamReducedPrintName = "urinary stream reduced";
final static String urinaryStreamReducedDescription = "urinary stream reduced";
// urinaryUrgency
final static String urinaryUrgencyPrintName = "urinary urgent";
final static String urinaryUrgencyDescription = urinaryUrgencyPrintName;
// urinationPainful
final static String urinationPainfulPrintName = "urination painful";
final static String urinationPainfulDescription = urinationPainfulPrintName;
// urinationStartDifficult
final static String urinationStartDifficultPrintName = "urination start difficult";
final static String urinationStartDifficultDescription = urinationStartDifficultPrintName;
// urineCloudy
final static String urineCloudyPrintName = "urine cloudy";
final static String urineCloudyDescription = urineCloudyPrintName;
// urineDark
final static String urineDarkPrintName = "urine dark";
final static String urineDarkDescription = urineDarkPrintName;
// urineDribbling
final static String urineDribblingPrintName = "urine dribbling";
final static String urineDribblingDescription = urineDribblingPrintName;
// urineRetention
final static String urineRetentionPrintName = "urine retention";
final static String urineRetentionDescription = urineRetentionPrintName;
// urticaria
final static String urticariaPrintName = "skin patches itchy raised swollen";
final static String urticariaDescription = urticariaPrintName;
// uterusBleeding
final static String uterusBleedingPrintName = "uterus bleeding";
final static String uterusBleedingDescription = uterusBleedingPrintName;
// uterusBleedingAbnormal
final static String uterusBleedingAbnormalPrintName = "uterus bleeding abnormal";
final static String uterusBleedingAbnormalDescription = uterusBleedingAbnormalPrintName;
// uterusContractions
final static String uterusContractionsPrintName = "uterus contractions";
final static String uterusContractionsDescription = uterusContractionsPrintName;
// uterusEnlarged
final static String uterusEnlargedPrintName = "uterus enlarged";
final static String uterusEnlargedDescription = uterusEnlargedPrintName;
// uterusGrowsTooFast
final static String uterusGrowsTooFastPrintName = "uterus grows too fast";
final static String uterusGrowsTooFastDescription = uterusGrowsTooFastPrintName;
// uterusIrritation
final static String uterusIrritationPrintName = "uterus irritation";
final static String uterusIrritationDescription = uterusIrritationPrintName;
// uterusPain
final static String uterusPainPrintName = "uterus pain";
final static String uterusPainDescription = uterusPainPrintName;
// uterusTender
final static String uterusTenderPrintName = "uterus tender";
final static String uterusTenderDescription = uterusTenderPrintName;
// vaginaBurning
final static String vaginaBurningPrintName = "vagina burning";
final static String vaginaBurningDescription = vaginaBurningPrintName;
// vaginaDischarge
final static String vaginaDischargePrintName = "vagina discharge";
final static String vaginaDischargeDescription = vaginaDischargePrintName;
// vaginaDischargeAmberColored
final static String vaginaDischargeAmberColoredPrintName = "vagina discharge amber colored";
final static String vaginaDischargeAmberColoredDescription = vaginaDischargeAmberColoredPrintName;
// vaginaDischargeBloody
final static String vaginaDischargeBloodyPrintName = "vagina discharge bloody";
final static String vaginaDischargeBloodyDescription = vaginaDischargeBloodyPrintName;
// vaginaDischargeBrown
final static String vaginaDischargeBrownPrintName = "vagina discharge brown";
final static String vaginaDischargeBrownDescription = vaginaDischargeBrownPrintName;
// vaginaDischargeFoulSmelling
final static String vaginaDischargeFoulSmellingPrintName = "vagina discharge foul smelling";
final static String vaginaDischargeFoulSmellingDescription = 
    vaginaDischargeFoulSmellingPrintName;
// vaginaDischargeFrothy
final static String vaginaDischargeFrothyPrintName = "vagina discharge frothy";
final static String vaginaDischargeFrothyDescription = vaginaDischargeFrothyPrintName;
// vaginaDischargeGrayFoulFishySmelling
final static String vaginaDischargeGrayFoulFishySmellingPrintName = 
    "vagina discharge gray foul fishy smelling";
final static String vaginaDischargeGrayFoulFishySmellingDescription = 
    vaginaDischargeGrayFoulFishySmellingPrintName;
// vaginaDischargePersistent
final static String vaginaDischargePersistentPrintName = "vagina discharge persistent";
final static String vaginaDischargePersistentDescription = vaginaDischargePersistentPrintName;
// vaginaDischargePink
final static String vaginaDischargePinkPrintName = "vagina discharge pink";
final static String vaginaDischargePinkDescription = vaginaDischargePinkPrintName;
// vaginaDischargeProfuse
final static String vaginaDischargeProfusePrintName = "vagina discharge profuse";
final static String vaginaDischargeProfuseDescription = vaginaDischargeProfusePrintName;
// vaginaDischargePurulent
final static String vaginaDischargePurulentPrintName = "vagina discharge pussy";
final static String vaginaDischargePurulentDescription = vaginaDischargePurulentPrintName;
// vaginaDischargeThickWhite
final static String vaginaDischargeThickWhitePrintName = "vagina discharge thick white";
final static String vaginaDischargeThickWhiteDescription = vaginaDischargeThickWhitePrintName;
// vaginaDischargeThinBubblyGreentingedMalodorous
final static String vaginaDischargeThinBubblyGreentingedMalodorousPrintName = 
    "vagina discharge thin bubbly green-tinged bad smelling";
final static String vaginaDischargeThinBubblyGreentingedMalodorousDescription = 
    vaginaDischargeThinBubblyGreentingedMalodorousPrintName;
// vaginaDryness
final static String vaginaDrynessPrintName = "vagina dry";
final static String vaginaDrynessDescription = vaginaDrynessPrintName;
// vaginaItching
final static String vaginaItchingPrintName = "vagina itching";
final static String vaginaItchingDescription = vaginaItchingPrintName;
// vaginaMucosaAtrophy
final static String vaginaMucosaAtrophyPrintName = "vagina lining atrophy";
final static String vaginaMucosaAtrophyDescription = vaginaMucosaAtrophyPrintName;
// vaginaMuscleSpasm
final static String vaginaMuscleSpasmPrintName = "vagina muscle spasm";
final static String vaginaMuscleSpasmDescription = vaginaMuscleSpasmPrintName;
// vaginaPain
final static String vaginaPainPrintName = "vagina pain";
final static String vaginaPainDescription = vaginaPainPrintName;
// vaginaPapule
final static String vaginaPapulePrintName = "vagina papule";
final static String vaginaPapuleDescription = vaginaPapulePrintName;
// vaginaRed
final static String vaginaRedPrintName = "vagina red";
final static String vaginaRedDescription = vaginaRedPrintName;
// vaginaSwollen
final static String vaginaSwollenPrintName = "vagina swollen";
final static String vaginaSwollenDescription = vaginaSwollenPrintName;
// vaginaTenderness
final static String vaginaTendernessPrintName = "vagina tenderness";
final static String vaginaTendernessDescription = vaginaTendernessPrintName;
// vaginaUlceratedLesion
final static String vaginaUlceratedLesionPrintName = "vagina ulcerated lesion";
final static String vaginaUlceratedLesionDescription = vaginaUlceratedLesionPrintName;
// vaginaVesicle
final static String vaginaVesiclePrintName = "vagina blister";
final static String vaginaVesicleDescription = vaginaVesiclePrintName;
// vaginaWarts
final static String vaginaWartsPrintName = "vagina warts";
final static String vaginaWartsDescription = vaginaWartsPrintName;
    /* see the diseases vulvovaginitis
       // vaginitis
       final static String vaginitisPrintName = "vaginitis";
       final static String vaginitisDescription = "vagina infection";
    */
// vasodilation
final static String vasodilationPrintName = "bloodvessels widening";
final static String vasodilationDescription = vasodilationPrintName;
// veinHeat
final static String veinHeatPrintName = "vein heat";
final static String veinHeatDescription = veinHeatPrintName;
// veinPain
final static String veinPainPrintName = "vein pain";
final static String veinPainDescription = veinPainPrintName;
// veinSwelling
final static String veinSwellingPrintName = "vein swelling";
final static String veinSwellingDescription = veinSwellingPrintName;
// veinTender
final static String veinTenderPrintName = "vein tender";
final static String veinTenderDescription = veinTenderPrintName;
// ventricularFibrillation
final static String ventricularFibrillationPrintName = 
    "heart chamber muscles twitching uncordinated";
final static String ventricularFibrillationDescription = 
    ventricularFibrillationPrintName;
// vertigo
final static String vertigoPrintName = "mind disoriented confused";
final static String vertigoDescription = vertigoPrintName;
// vesicle
final static String vesiclePrintName = "skin blister small";
final static String vesicleDescription = vesiclePrintName;
// vesicleCheek
final static String vesicleCheekPrintName = "cheek small blister";
final static String vesicleCheekDescription = vesicleCheekPrintName;
// vesicleMouth
final static String vesicleMouthPrintName = "mouth small blister";
final static String vesicleMouthDescription = vesicleMouthPrintName;
// visionBlurred
final static String visionBlurredPrintName = "vision blurred";
final static String visionBlurredDescription = visionBlurredPrintName;
// visionDefect
final static String visionDefectPrintName = "vision defect";
final static String visionDefectDescription = visionDefectPrintName;
// visionDisturbance = ocularDisturbance
    // final static String visionDisturbancePrintName = "vision disturbance";
    // final static String visionDisturbanceDescription = visionDisturbancePrintName;
// visionLoss
final static String visionLossPrintName = "vision loss";
final static String visionLossDescription = visionLossPrintName;
// visionNightLoss
final static String visionNightLossPrintName = "vision night loss";
final static String visionNightLossDescription = visionNightLossPrintName;
// visionPeripheralLoss
final static String visionPeripheralLossPrintName = "vision peripheral loss";
final static String visionPeripheralLossDescription = visionPeripheralLossPrintName;
// voiceDeepened
final static String voiceDeepenedPrintName = "voice deepened";
final static String voiceDeepenedDescription = voiceDeepenedPrintName;
// vomitBile
final static String vomitBilePrintName = "vomit greenish bile";
final static String vomitBileDescription = vomitBilePrintName;
// vomitBlack
final static String vomitBlackPrintName = "vomit black";
final static String vomitBlackDescription = vomitBlackPrintName;
// vomitBloody
final static String vomitBloodyPrintName = "vomit bloody";
final static String vomitBloodyDescription = vomitBloodyPrintName;
// vomiting
final static String vomitingPrintName = "vomiting";
final static String vomitingDescription = vomitingPrintName;
// vulvaBurning
final static String vulvaBurningPrintName = "vulva burning";
final static String vulvaBurningDescription = vulvaBurningPrintName;
// vulvaItching
final static String vulvaItchingPrintName = "vulva itching";
final static String vulvaItchingDescription = vulvaItchingPrintName;
// vulvaLesion
final static String vulvaLesionPrintName = "vulva lesion";
final static String vulvaLesionDescription = vulvaLesionPrintName;
// vulvaPain
final static String vulvaPainPrintName = "vulva pain";
final static String vulvaPainDescription = vulvaPainPrintName;
// vulvaPapule
final static String vulvaPapulePrintName = "vulva papule";
final static String vulvaPapuleDescription = vulvaPapulePrintName;
// vulvaRedSwollen
final static String vulvaRedSwollenPrintName = "vulva red swollen";
final static String vulvaRedSwollenDescription = vulvaRedSwollenPrintName;
// vulvaUlcer
final static String vulvaUlcerPrintName = "vulva ulcer";
final static String vulvaUlcerDescription = vulvaUlcerPrintName;
// vulvaUlcerInfected
final static String vulvaUlcerInfectedPrintName = "vulva infected ulcer";
final static String vulvaUlcerInfectedDescription = vulvaUlcerInfectedPrintName;
// vulvaVesicle
final static String vulvaVesiclePrintName = "vulva blister";
final static String vulvaVesicleDescription = vulvaVesiclePrintName;
// vulvaWarts
final static String vulvaWartsPrintName = "vulva warts";
final static String vulvaWartsDescription = vulvaWartsPrintName;
// waddle
final static String waddlePrintName = "waddle";
final static String waddleDescription = "swaying gait";
// waistlineLesion
final static String waistlineLesionPrintName = "waistline lesion";
final static String waistlineLesionDescription = waistlineLesionPrintName;
// walkingTrouble
final static String walkingTroublePrintName = "walking trouble";
final static String walkingTroubleDescription = walkingTroublePrintName;
// weakness
final static String weaknessPrintName = "weakness";
final static String weaknessDescription = weaknessPrintName;
// weightGain
final static String weightGainPrintName = "weight gain";
final static String weightGainDescription = weightGainPrintName;
// weightGainExcessive
final static String weightGainExcessivePrintName = "weight gain excessive";
final static String weightGainExcessiveDescription = weightGainExcessivePrintName;
// weightLoss
final static String weightLossPrintName = "weight loss";
final static String weightLossDescription = weightLossPrintName;
// wheals
final static String whealsPrintName = "wheals";
final static String whealsDescription = "burning itching skin swellings";
// wheezing
final static String wheezingPrintName = "wheezing";
final static String wheezingDescription = wheezingPrintName;
// whoopInhalation
final static String whoopInhalationPrintName = "whoopy sound inhalation";
final static String whoopInhalationDescription = whoopInhalationPrintName;
// woundPainful
final static String woundPainfulPrintName = "wound painful";
final static String woundPainfulDescription = woundPainfulPrintName;
// wristLesion
final static String wristLesionPrintName = "wrist lesion";
final static String wristLesionDescription = wristLesionPrintName;
// yawning
final static String yawningPrintName = "yawning";
final static String yawningDescription = yawningPrintName;


  // ---------------- abnormal conditions AC ---------------- 

// acidosis
final static String acidosisPrintName = "acidosis";
final static String acidosisDescription = "too much acid in the bloodstream";
// adrenalTumor
final static String adrenalTumorPrintName = "adrenal tumor";
final static String adrenalTumorDescription = adrenalTumorPrintName;
// airwayObstruction
final static String airwayObstructionPrintName = "airway obstruction";
final static String airwayObstructionDescription = airwayObstructionPrintName;
// anovulation
final static String anovulationPrintName = "anovulation";
final static String anovulationDescription = "ovulation is irregular or absent";
// areflexia
final static String areflexiaPrintName = "areflexia";
final static String areflexiaDescription = "absence of neurologic reflexes";
// ascites
final static String ascitesPrintName = "ascites";
final static String ascitesDescription = "accumulation of fluid in the abdomen";
// atherosclerosis
final static String atherosclerosisPrintName = "atherosclerosis";
final static String atherosclerosisDescription = "narrowing of main arteries due to plaque and/or calcium";
// atrialFibrillation
final static String atrialFibrillationPrintName = "atrial fibrillation";
final static String atrialFibrillationDescription = "irregular contractions of the heart muscle";
// atrioventricularHeartBlock
final static String atrioventricularHeartBlockPrintName = "atrioventricular heart block";
final static String atrioventricularHeartBlockDescription = atrioventricularHeartBlockPrintName;
// azotemia
final static String azotemiaPrintName = "azotemia";
final static String azotemiaDescription = 
    "excess of nitrogeneous material in the blood due to kidney failure";
// bacteriuria
final static String bacteriuriaPrintName = "bacteriuria";
final static String bacteriuriaDescription = "bacteria in the urine";
// blindness
final static String blindnessPrintName = "blindness";
final static String blindnessDescription = blindnessPrintName;
// bloodDyscrasias
final static String bloodDyscrasiasPrintName = "blood dyscrasias";
final static String bloodDyscrasiasDescription = "blood abnormality";
// bloodPressureDifferences
final static String bloodPressureDifferencesPrintName = "blood pressure differences";
final static String bloodPressureDifferencesDescription = bloodPressureDifferencesPrintName;
// brainLesion
final static String brainLesionPrintName = "brain lesion";
final static String brainLesionDescription = brainLesionPrintName;
// bronchialMucusPlugs
final static String bronchialMucusPlugsPrintName = "bronchial mucus plugs";
final static String bronchialMucusPlugsDescription = bronchialMucusPlugsPrintName;
// cardiacEnlargement
final static String cardiacEnlargementPrintName = "cardiac enlargement";
final static String cardiacEnlargementDescription = cardiacEnlargementPrintName;
// centralNervousSystemDepression
final static String centralNervousSystemDepressionPrintName = "central nervous system depression";
final static String centralNervousSystemDepressionDescription = centralNervousSystemDepressionPrintName;
// circulatoryFailure
final static String circulatoryFailurePrintName = "circulatory failure";
final static String circulatoryFailureDescription = circulatoryFailurePrintName;
// cranialNerveDysfunction
final static String cranialNerveDysfunctionPrintName = "cranial nerve dysfunction";
final static String cranialNerveDysfunctionDescription = cranialNerveDysfunctionPrintName;
// death
final static String deathPrintName = "death";
final static String deathDescription = deathPrintName;
// diastolicMurmurs
final static String diastolicMurmursPrintName = "diastolic murmurs";
final static String diastolicMurmursDescription = diastolicMurmursPrintName;
// electrolyteImbalance
final static String electrolyteImbalancePrintName = "electrolyte imbalance";
final static String electrolyteImbalanceDescription = "improper ratio of ions in the blood stream";
// empyema
final static String empyemaPrintName = "empyema";
final static String empyemaDescription = "pus in a bodily cavity";
// glycosuria
final static String glycosuriaPrintName = "glycosuria";
final static String glycosuriaDescription = "excretion of glucose in the urine";
// hepaticFailure
final static String hepaticFailurePrintName = "hepatic failure";
final static String hepaticFailureDescription = "failing liver";
// hepatoJugularReflux
final static String hepatoJugularRefluxPrintName = "hepato jugular reflux";
final static String hepatoJugularRefluxDescription = "liver bloodstream reversed";
// hepatomegaly
final static String hepatomegalyPrintName = "hepatomegaly";
final static String hepatomegalyDescription = "enlarged liver";
// hipDeformity
final static String hipDeformityPrintName = "hip deformity";
final static String hipDeformityDescription = hipDeformityPrintName;
// hypercalcemia
final static String hypercalcemiaPrintName = "hypercalcemia";
final static String hypercalcemiaDescription = "excess calcium in blood";
// hypercalciuria
final static String hypercalciuriaPrintName = "hypercalciuria";
final static String hypercalciuriaDescription = "excess calcium in the urine";
// hyperglycemia
final static String hyperglycemiaPrintName = "hyperglycemia";
final static String hyperglycemiaDescription = "high blood sugar";
// hypervolemia
final static String hypervolemiaPrintName = "hypervolemia";
final static String hypervolemiaDescription = "excessive blood volume";
// hypoglycemia
final static String hypoglycemiaPrintName = "hypoglycemia";
final static String hypoglycemiaDescription = "low blood sugar";
// hypotonia
final static String hypotoniaPrintName = "hypotonia";
final static String hypotoniaDescription = "decreased muscle tone";
// hypovolemia
final static String hypovolemiaPrintName = "hypovolemia";
final static String hypovolemiaDescription = "insufficient blood volume";
// hypoxemia
final static String hypoxemiaPrintName = "hypoxemia";
final static String hypoxemiaDescription = "deficient oxygenation of the blood";
// hypoxia
final static String hypoxiaPrintName = "hypoxia";
final static String hypoxiaDescription = "deficiency of oxygen reaching the tissues of the body";
// infectionsSevere
final static String infectionsSeverePrintName = "infections severe";
final static String infectionsSevereDescription = "severe infections";
// lactating
final static String lactatingPrintName = "lactating";
final static String lactatingDescription = "secreting milk";
// leftVentricularDysfunction
final static String leftVentricularDysfunctionPrintName = "left ventricular dysfunction";
final static String leftVentricularDysfunctionDescription = leftVentricularDysfunctionPrintName;
// leukocytosis
final static String leukocytosisPrintName = "leukocytosis";
final static String leukocytosisDescription = "increase of white blood cells";
// leukopenia
final static String leukopeniaPrintName = "leukopenia";
final static String leukopeniaDescription = "reduced number of blood neutrophils";
// lowFertility
final static String lowFertilityPrintName = "low fertility";
final static String lowFertilityDescription = lowFertilityPrintName;
// malnutrition
final static String malnutritionPrintName = "malnutrition";
final static String malnutritionDescription = malnutritionPrintName;
// microEmboli
final static String microEmboliPrintName = "micro emboli";
final static String microEmboliDescription = "small blood vessel obstruction in the lungs";
// myocardialHypoxia
final static String myocardialHypoxiaPrintName = "myocardial hypoxia";
final static String myocardialHypoxiaDescription = "insufficient oxygen reaching body tissues due to trouble with the myocardium (= middle muscular layer of the heart)";
// neurologicDeficiences
final static String neurologicDeficiencesPrintName = "neurologic deficiences";
final static String neurologicDeficiencesDescription = neurologicDeficiencesPrintName;
// neuropathy
final static String neuropathyPrintName = "neuropathy";
final static String neuropathyDescription = "degenerative state of the nervous system";
    /* changed into a disease
// obesity
final static String obesityPrintName = "obesity";
final static String obesityDescription = obesityPrintName;
    */
// obesityHypoVentilation
final static String obesityHypoVentilationPrintName = "obesity hypo ventilation";
final static String obesityHypoVentilationDescription = "obesity low ventilation";
// ovariesTumor
final static String ovariesTumorPrintName = "ovaries tumor";
final static String ovariesTumorDescription = ovariesTumorPrintName;
// pericardialFrictionRub
final static String pericardialFrictionRubPrintName = "pericardial friction rub";
final static String pericardialFrictionRubDescription = pericardialFrictionRubPrintName;
// pleuralEffusion
final static String pleuralEffusionPrintName = "pleural effusion";
final static String pleuralEffusionDescription = 
    "excess of fluid in pleural space possibly due to a rupture";
// pleuralEffusionLeft
final static String pleuralEffusionLeftPrintName = "pleural effusion left";
final static String pleuralEffusionLeftDescription = 
    "excess fluid in the left side of the pleural space";
// pleuralSpaceRupture
final static String pleuralSpaceRupturePrintName = "pleural space rupture";
final static String pleuralSpaceRuptureDescription = 
    "for example: emphysematous bulla tubercular/ pneumocystic/ malignant lesion etc.";
// polyhydramnios
final static String polyhydramniosPrintName = "polyhydramnios";
final static String polyhydramniosDescription = "too much water surrounding the fetus";
// pregnancy
final static String pregnancyPrintName = "pregnancy";
final static String pregnancyDescription = "being pregnant";
// prostateEnlarged
final static String prostateEnlargedPrintName = "prostate enlarged";
final static String prostateEnlargedDescription = "enlarged prostate";
// prostateFirm
final static String prostateFirmPrintName = "prostate firm";
final static String prostateFirmDescription = prostateFirmPrintName;
// prostateSwollen
final static String prostateSwollenPrintName = "prostate swollen";
final static String prostateSwollenDescription = prostateSwollenPrintName;
// prostateTender
final static String prostateTenderPrintName = "prostate tender";
final static String prostateTenderDescription = prostateTenderPrintName;
// proteinuria
final static String proteinuriaPrintName = "proteinuria";
final static String proteinuriaDescription = "abnormally high amount of protein in the urine";
// psychicTraumaSevere
final static String psychicTraumaSeverePrintName = "psychic trauma severe";
final static String psychicTraumaSevereDescription = "severe psychic trauma";
// pulmonaryFailure
final static String pulmonaryFailurePrintName = "pulmonary failure";
final static String pulmonaryFailureDescription = "collapse of the respiratory system";
// recurrentRespiratoryTractInfections
final static String recurrentRespiratoryTractInfectionsPrintName = "recurrent respiratory tract infections";
final static String recurrentRespiratoryTractInfectionsDescription = recurrentRespiratoryTractInfectionsPrintName;
// respiratoryFailure
final static String respiratoryFailurePrintName = "respiratory failure";
final static String respiratoryFailureDescription = "failing of the breathing mechanism";
// ribFracture
final static String ribFracturePrintName = "rib fracture";
final static String ribFractureDescription = ribFracturePrintName;
// sepsis
final static String sepsisPrintName = "sepsis";
final static String sepsisDescription = "toxic condition due to the spread of bacteria or their products";
// shock
final static String shockPrintName = "shock";
final static String shockDescription = "loss of blood pressure and/or depression of vital signs";
// spinalCordLesionAboveC6
final static String spinalCordLesionAboveC6PrintName = "spinal cord lesion above C6";
final static String spinalCordLesionAboveC6Description = spinalCordLesionAboveC6PrintName;
// spineJointDegeneration
final static String spineJointDegenerationPrintName = "spine joint degeneration";
final static String spineJointDegenerationDescription = "degeneration of spine joints";
// splenomegaly
final static String splenomegalyPrintName = "splenomegaly";
final static String splenomegalyDescription = "enlargement of the spleen";
// systemicEmbolization
final static String systemicEmbolizationPrintName = "systemic embolization";
final static String systemicEmbolizationDescription = systemicEmbolizationPrintName;
// thrombocytopenia
final static String thrombocytopeniaPrintName = "thrombocytopenia";
final static String thrombocytopeniaDescription = "reduced platelet thrombocyte count";
// thrombocytosis
final static String thrombocytosisPrintName = "thrombocytosis";
final static String thrombocytosisDescription = "formation of thrombi";
// tracheitis
final static String tracheitisPrintName = "tracheitis";
final static String tracheitisDescription = "inflammation of the trachea";
// upperAirwayObstruction
final static String upperAirwayObstructionPrintName = "upper airway obstruction";
final static String upperAirwayObstructionDescription = upperAirwayObstructionPrintName;
// uremia
final static String uremiaPrintName = "uremia";
final static String uremiaDescription = "excess urea in the blood";
// uterusRupture
final static String uterusRupturePrintName = "uterus rupture";
final static String uterusRuptureDescription = uterusRupturePrintName;
// uterusTumors
final static String uterusTumorsPrintName = "uterus tumors";
final static String uterusTumorsDescription = "tumors in the uterus";
// valvularInsufficiency
final static String valvularInsufficiencyPrintName = "valvular insufficiency";
final static String valvularInsufficiencyDescription = "heart valves malfunctions";
// varicoseVeins
final static String varicoseVeinsPrintName = "varicose veins";
final static String varicoseVeinsDescription = "abnormally dilated and knotted veins";
// vascularCollapse
final static String vascularCollapsePrintName = "vascular collapse";
final static String vascularCollapseDescription = vascularCollapsePrintName;



  // ---------------- Treatments ---------------- 

  // general treatment actions
    final static String alcoholModeration = "alcohol moderation";
    final static String anesthetic = "anesthetic";
    final static String anestheticLocal = "anesthetic local";
    final static String avoidSunlightExposure = "avoid sunlight exposure";
    final static String bedHeadElevated = "bed head elevated";
    final static String bedRest  = "bed rest";
    final static String bleedingControl = "bleeding control";
  // final static String bloodTransfusion = "blood transfusion";
    final static String boneMarrowTransplant = "bone marrow transplant";
    final static String cauterization = "cauterization";
    final static String chemoTherapy = "chemo therapy";
    final static String coldCompress = "cold compress";
    final static String colloidCrystalloidInfusions = 
                       "colloid crystalloid infusions"; 
    final static String coolSitzBath = "cool sitz bath";
    final static String cottonBall = "cotton ball";
    final static String dialysis  = "dialysis";
    final static String diet = "diet";
    final static String dietFiber = "diet fiber";
    final static String dietHighCalorie = "diet high calorie";
    final static String dietLiquid = "diet liquid";
    final static String dietLowCalcium = "diet low calcium";
    final static String dietLowProtein = "diet low protein";
    final static String dietLowSalt = "diet low salt";
    final static String dietWithoutGluten = "diet without gluten";
    final static String drainageOfAbscess = "drainage of abscess";
    final static String electrolyteReplacement = "electrolyte replacement";
    final static String excision = "excision"; 
    final static String exercise = "exercise";
    final static String externalPressure = "external pressure";
    final static String fluidManagement = "fluid management";
    final static String freshFrozenPlasma = "fresh frozen plasma";
    final static String gastricLavage = "gastric lavage";
    final static String hemodialysis = "hemodialysis";
    final static String homeCareAndRest  = "home care and rest";
    final static String hormoneTherapy = "hormoneTherapy";
    final static String hospitalization  = "hospitalization";
    final static String hydration  = "hydration";
    final static String hyperbaricOxygen = "hyperbaric oxygen";
    final static String icePack = "ice pack"; 
    final static String IVFluids = "IV fluids"; 
    final static String IVNutrition = "IV nutrition";
    final static String laserSurgery = "laser surgery";
    final static String lieDownPatient = "lie down patient";
    final static String lindaneCream = "lindane cream";
    final static String lindaneShampoo = "lindane shampoo";
    final static String massage = "massage";
    final static String mouthWash = "mouth wash";
    final static String nothingByMouth = "nothing by mouth";
    final static String nutritionImprove = "nutrition improve";
    final static String oralHygiene = "oral hygiene";
    final static String painManagement = "pain management";
    final static String parenteralFluidAdministration = 
                       "parenteral fluid administration";
    final static String parenteralFluidReplacement = 
                       "parenteral fluid replacement";
    final static String perhapsSurgery = "perhapsSurgery";
    final static String peritonealDialysis = "peritoneal dialysis";
    final static String phlebotomy = "phlebotomy";
    final static String placedOnLeftSide = "placedOnLeftSide";
    final static String pharmacotherapy = "pharmacotherapy";
    final static String platelets = "platelets";
    final static String pneumaticAntishockGarment = "pneumatic antishock garment";
    final static String pressureDressing = "pressure dressing";
    final static String protectiveClothing = "protective clothing";
    final static String proteinSupplement = "protein supplement";
    final static String psychoanalyticTherapy = "psychoanalytic therapy";
    final static String psychologicalCounseling = "psychological counseling";
    final static String radiationTherapy = "radiation therapy";
    final static String regularEjaculation = "regular ejaculation";
    final static String salineGargles = "saline gargles";
    final static String saltyBroth = "salty broth";
    final static String sitzBath = "sitz bath";
    final static String smokingCessation = "smoking cessation";
    final static String sodiumRestriction = "sodium restriction";
    final static String stretching = "stretching";
    final static String surgery = "surgery";
    final static String surgicalDebridement = "surgical debridement";
    final static String surgicalEmbolectomy = "surgical embolectomy";
  // final static String transfusion = "transfusion"; // bloodTransfusion
    final static String warmCompress = "warm compress";
    final static String wetDressings = "wet dressings";
    final static String weightIncrease = "weight increase";
    final static String weightReduction = "weight reduction";
    final static String woundCare = "wound care";
    final static String wristSplint = "wrist splint";


  // general conditional actions
    final static String ifFeverProvideAntipyretic =
                       "if fever provide antipyretic";
    final static String ifInfectionProvideAntibiotic = 
                       "if infection provide antibiotic";

  // burn treatment actions
    final static String lactatedRingerSolution = "lactated Ringer solution";

  // cardiac treatment actions
    final static String angioplasty = "angioplasty";
    final static String antiembolismStockings = "antiembolism stockings";
    final static String antiplateletAggregateTherapy = 
                       "antiplatelet aggregate therapy";
    final static String cardioversion = "cardioversion"; // =???
    final static String CPR  = "CPR";
    final static String decreaseCardiacWorkload = "decrease cardiac workload";
    final static String embolectomy = "embolectomy";
    final static String increaseCardiacOutput = "increase cardiac output";
    final static String thrombolyticTherapy = "thrombolytic therapy";
    final static String valveReplacement = "valve replacement";

  // endocrine treatment actions
    final static String radioactiveIodine = "radioactive iodine";

  // eye treatment actions
    final static String laserPhotocoagulation = "laser photocoagulation";

  // GI treatment actions
    final static String bowelRest = "bowel rest";
    final static String nasogastricTube = "nasogastric tube";
    final static String nutritionSupport = "nutrition support";
    final static String paranteralNutrition = "paranteral nutrition";

  // gynecologic treatment actions
    final static String cesarianDelivery = "cesarian delivery";
    final static String chemicalCautery = "chemical cautery";
    final static String curettage = "curettage";
    final static String hysterectomy = "hysterectomy";
    final static String inductionOfLabor = "induction of labor";
    final static String phototherapy = "phototherapy";
    final static String topicalEstrogenOintment = "topical estrogen ointment";
    final static String upliftSupportBra = "uplift support bra";
    final static String xrayTherapy = "xray therapy";

  // hematologic treatment actions
    final static String splenectomy = "splenectomy";

  // metabolic treatment actions
    final static String potassiumReplacement = "potassium replacement";

  // neurologic treatment actions
    final static String neurosurgery = "neurosurgery";
    final static String seizurePrecautions = "seizure precautions";

  // psychiatric treatment actions
    final static String electroconvulsiveTherapy = "electroconvulsive therapy";
    final static String psychotherapy = "psychotherapy";

  // renal treatment actions
    final static String kidneyTransplantation = "kidney transplantation";

  // respiratory treatment actions
    final static String airwayMaintenance = "airway maintenance";
    final static String aspirationPrecautions = "aspiration precautions";
    final static String breathIntoPaperBag = "breath into paper bag";
    final static String bronchialDrainage = "bronchial drainage";
    final static String bronchoscopy = "bronchoscopy";
    final static String chestPercussion = "chest percussion";
    final static String chestTubeDrainage = "chest tube drainage";
    final static String coughingExercise = "coughing exercise";
    final static String deepBreathingExercise = "deep breathing exercise";
    final static String endotrachealIntubation = "endotracheal intubation";
    final static String establishmentOfAirway = "establishment of airway";
    final static String fibrinolyticTherapy = "fibrinolytic therapy";
    final static String fluidIncrease = "fluid increase";
    final static String fluidRestriction = "fluid restriction";
    final static String heartLungTransplantation = "heart lung transplantation";
    final static String humidifiedAir = "humidified air";
    final static String humidifiedOxygen = "humidified oxygen";
    final static String hyperventilationAfterIntubation =
                       "hyperventilation after intubation";
    final static String intubation = "intubation";
    final static String IVVolumeExpanders = "IV volume expanders";
    final static String lobectomy = "lobectomy";
    final static String mechanicalVentilation = "mechanical ventilation";
    final static String MinnesotaTube = "Minnesota tube";
    final static String oxygenTherapy = "oxygen therapy";
    final static String posturalDrainage = "postural drainage";
    final static String steamInhalation = "steam inhalation";
    final static String suctioning = "suctioning";
    final static String tracheotomy = "tracheotomy";
    final static String vasopressor = "vasopressor";
    final static String volumeVentilation = "volume ventilation";

  // sexual treatment actions
    final static String behaviorTherapy = "behavior therapy";
    final static String creamsOrGels = "creams or gels";
    final static String education = "education";
    final static String experientialTherapy = "experiential therapy";
    final static String MasterAndJohnsonTherapy = "Master and Johnson therapy";
    final static String sexTherapy = "sex therapy";

  // skin treatment actions
    final static String carbonDioxideLaser = "carbon dioxide laser";
    final static String cryosurgery = "cryosurgery";
    final static String electrocautery = "electrocautery";
    final static String permethrinCream = "permethrin cream";

  // trauma treatment actions
    final static String craniotomy = "craniotomy";
    final static String positionBittenLimbBelowHeart = 
                        "position bitten limb below heart";
    final static String removeTick = "remove tick";


    // -------------- treatment conditions -------------- 
  // treatment conditions
    final static String beforeSurgery = "before surgery";
    final static String ifAbortionIncomplete = "if abortion incomplete";
    final static String ifAcute = "if acute";
    final static String ifAcuteHypoxemia = "if acute hypoxemia";
    final static String ifAcuteUrinaryBlockage = "if acute urinary blockage";
    final static String ifAnatomicDefects = "if anatomic defects";
    final static String ifAndrenalGlandMalfunction =
                       "if andrenal gland malfunction";
    final static String ifBacterialInfection = "if bacterial infection";
    final static String ifBerylliumUlcer = "if beryllium ulcer";
    final static String ifBrainTumor = "if brain tumor";
    final static String ifBronchospasm = "if bronchospasm";
    final static String ifCardiacArrest = "if cardiac arrest";
    final static String ifCervixPolyps = "if cervix polyps";
    final static String ifChronic = "if chronic";
    final static String ifDistress = "if distress";
    final static String ifEndometriosis = "if endometriosis";
    final static String ifFever = "if fever";
    final static String ifHeartFailure = "if heart failure";
    final static String ifHipInvolvement = "if hip involvement";
    final static String ifHymenalScars = "if hymenal scars";
    final static String ifHypercalcemia = "if hypercalcemia";
    final static String ifHypersensitive = "if hypersensitive";
    final static String ifHypotension = "if hypotension";
  //    final static String ifHypoxemia = "if hypoxemia";
    final static String ifInfection = "if infection";
    final static String ifInfluenzaA = "if influenzaA";
    final static String ifInvasive = "if invasive";
    final static String ifItchyVulva = "if itchy vulva";
    final static String ifLubricationProblem = "if lubrication problem";
    final static String ifMassiveEmbolism = "if massive embolism";
    final static String ifMechanicalVentilation = "if mechanical ventilation";
    final static String ifMenopausalMucosaAtrophy =
                       "if menopausal mucosa atrophy";
    final static String ifModerate = "if moderate";
    final static String ifNarcoticOverdose = "if narcotic overdose";
    final static String ifNearTerm = "if near term";
    final static String ifNoOvulation = "if no ovulation";
    final static String ifNoSpontaneousLabor = "if no spontaneous labor";
    final static String ifObstructingNeoplasm = "if obstructing neoplasm";
    final static String ifObstructingObject = "if obstructing object";
    final static String ifOrganicDisorder = "if organic disorder";
    final static String ifPain = "if pain";
    final static String ifPhysicalProblem = "if physical problem";
    final static String ifPoisoned = "if poisoned";
    final static String ifPregnant = "if pregnant";
    final static String ifPreinvasive = "if preinvasive";
    final static String ifProgesteroneDeficiency = "if progesterone deficiency";
    final static String ifPsychologicalProblem = "if psychological problem";
    final static String ifRash = "if rash";
    final static String ifRespiratoryFailure = "if respiratory failure";
    final static String ifRightSidedHeartFailure = "if right sided heart failure";
    final static String ifSepticEmboli = "if septic emboli";
    final static String ifSevere = "if severe";
    final static String ifSevereAcidosis = "if severe acidosis";
    final static String ifSevereAnxiety = "if severe anxiety";
    final static String ifSevereAttack = "if severe attack";
    final static String ifSevereBleeding = "if severe bleeding";
    final static String ifSevereHemoptysis = "if severe hemoptysis";
    final static String ifSevereInflammation = "if severe inflammation";
    final static String ifSignificantRespiratoryAcidosis = "if significant respiratory acidosis";
    final static String ifStage1Or2 = "if stage 1 or 2";
    final static String ifStage3Or4 = "if stage 3 or 4";
    final static String ifSuicidal = "if suicidal";
    final static String ifSuppressLabor = "if suppress labor";
    final static String ifSwallowingProblem = "if swallowing problem";
    final static String ifThyroidGlandMalfunction =
                       "if thyroid gland malfunction";
    final static String ifTumor = "if tumor";
    final static String toAchieveConception = "to achieve conception";
    final static String toControlGlucoseLevel = "to control glucose level";


    // -------------- HTML primitives -------------- 
    final static String Submit = "Submit";
    final static String BackCancel = "Back/Cancel";
    final static String Home = "Home";
    final static String Logout = "Finish";


    // -------------- patient pages -------------- 

    //  Admin.java
    final static String AdminStuff = "Admin Stuff";
    final static String MakeCorrectionsAsNecessary = "Make corrections as necessary:";
    // final static String Name = "Name:";
    final static String Gender = "Gender:";
    final static String DateOfBirth = "Date of Birth:";
    final static String StreetAddress = "Street Address:";
    final static String City = "City:";
    final static String ZipCode = "Zip code:";
    final static String HomePhone = "Home phone:";
    final static String SS = "SS#:";
    final static String PleaseCheckAllFieldsBeforeSubmitting = 
                        "Please check all fields before submitting:";
    // AdminUpdate.java
    // AngelLogin.java
    final static String AngelLoginS1 = "Log name and password required!";
    final static String AngelLoginS2 = "Use the back arrow to return to the previous page.";
    final static String AngelLoginS3 = "Can not login twice!";
    final static String orTry = "Or try: ";
    final static String AngelLoginS5 = "User name - password combination not acceptable.";
    final static String AngelLoginS6 = "An unexpected session was invalidated.  Try to login again.";
    // CalcBMI.java
    final static float  bmiCoefficient = 703.0f;
    final static String YourBodyMassIndex = "Your Body Mass Index";
    final static String CalcBMIError = "Weight and/or height not realistic data ...";
    final static String YourWeight = "Your weight:";
    final static String YourHeight = "Your height:";
    final static String YourBMI = "Your BMI:";
    final static String CalcBMIExplain = 
                        "A BMI in the range of 20-25 is considered OK; " + 
	                "below 20 is under weight and above 25 is over weight.";
    // CheckDrugEffects
    final static String DrugSideEffects = "Drug Side Effects";
    final static String DrugSideEffects1 = "You have confirmed the following critical symptoms:";
    final static String DrugSideEffects2 = "You have confirmed the following other symptoms:";
    // CheckMenopause2.java
    // CheckMenstruating2.java
    // CheckPregnancy2.java
    // CheckPremenstruating2.java
    // CheckStatus.java
    final static String Menstruating = "Menstruating?";
    final static String CheckStatusQ1 = "According to previously provided info you have never menstruated";
    final static String PleaseCorrectIfNecessary = "Please correct if necessary:";
    final static String CheckStatusS1 = "Indeed I have never menstruated";
    final static String CheckStatusS2 = "I DO have had a menstruation (and I am NOT pregnant)";
    final static String CheckStatusS3 = "In fact, I AM pregnant. ";
    final static String CheckStatusS4 = "Date of last menstruation: ";
    final static String Pregnant = "Pregnant?";
    final static String CheckStatusQ2 = 
	"According to previously provided info you WERE pregnant";
    final static String LastMenstructionDate = "Last menstruction date: ";
    final static String CheckStatusS4A = 
	"If that pregnancy is still on going you are seriously overdue and " +
	"you should take immediate action.";
    /*
    final static String CheckStatusS4B = 
	"If that pregnancy is still on going you are overdue and " +
	"you should take immediate action.";
    */
    final static String CheckStatusS5 = "Indeed I am STILL pregnant. ";
    final static String CheckStatusS5A = 
	"I had a life birth and I am now NOT pregnant. ";
    final static String CheckStatusS5B = 
	"I had a life birth and I am pregnant again. ";
    final static String CheckStatusS5C = 
	"I had a still birth and I am now NOT pregnant. ";
    final static String CheckStatusS5D = 
	"I had a still birth and I am pregnant again. ";
    final static String CheckStatusS5E = 
	"I had a miscarriage and I am now NOT pregnant. ";
    final static String CheckStatusS5F = 
	"I had a miscarriage and I am pregnant again. ";
    /*
    final static String CheckStatusS6 = "I am NOT pregnant anymore:";
    final static String CheckStatusS6A = 
	"That pregnancy terminated, but I am pregnant again";
    final static String CheckStatusS7 = "due to a life birth";
    final static String CheckStatusS8 = "due to a miscarriage";
    final static String CheckStatusS9 = "due to a stillbirth";
    */
    final static String CheckStatusQ3 = "According to previously provided info you are NOT pregnant";
    final static String CheckStatusS10 = "Indeed I am NOT pregnant";
    final static String CheckStatusS11 = "I have become pregnant. ";
    final static String CheckStatusS12 = "I have entered menopause";
    final static String Menopause = "Menopause?";
    final static String CheckStatusQ4 = "According to previously provided info you are in menopause";
    final static String CheckStatusS13 = "Indeed I am still in menopause";
    final static String CheckStatusS14 = "Surprise, I have become pregnant. ";
    final static String CheckStatusS15 = "I have entered post menopause";
    // Debug.java
    // Diag1a.java
    // Diag1b.java
    final static String ConfirmConcepts = "Confirm Concepts";
    final static String Diag1bS1 = "Current Input. Validate and, Optional, Modify";
    final static String SymptomsSelected = "Symptoms selected:";
    final static String Diag1bS2 = "NO symptoms provided yet";
    final static String Diag1bS3 = "UNcheck if a previous selection was wrong:";
    final static String Diag1bS4 = "NO symptoms found yet";
    final static String LocationFocus = "Location Focus:";
    final static String Diag1bS5 = "Optional: Narrow down body part:";
    final static String SystemFocus = "System Focus:";
    final static String Diag1bS6 = "Optional: Narrow down system:";
    final static String SelectedDiseases = "Selected Diseases:";
    final static String Diag1bS7 = "UNcheck if a previous selection was wrong:";
    final static String Diag1bS8 = "Found in the text box. Confirm or Not:";
    final static String ConjecturedSymptoms = "Conjectured Symptoms:";
    final static String Diag1bS9 = "Check all that apply - if any:";
    final static String ConjecturedLocations = "Conjectured Locations:";
    final static String Diag1bS10 = "Check one that applies - if any:";
    final static String ConjecturedBodySystems = "Conjectured Body Systems:";
    final static String ConjecturedDiseases = "Conjectured Conditions";
    final static String Diag1bS11 = "Optional, provide more symptoms and/or locations:";
    final static String Diag1bS12 = "The more you provide the faster the search yields results.";
    final static String Hint = "Explain";
    final static String Diag1bS13 = "Please check your data before submitting";
    final static String Diag1bS14 = "Not processed concepts:";
    final static String Diag1bS15 = "Drug(s) potentially causing symptom(s)";
    final static String Diag1bS16 = "Drug(s) potentially causing critical symptom(s)";
    final static String Diag1bS17 = "If you experience critical symptoms you may " +
	"want to terminate this session and obtain professional help.";
    final static String Diag1bS18 = "If you believe that your symptoms are caused by your drugs " +
	"you many want to terminate this session.";
    final static String Diag1bS19 = 
	"If you do NOT terminate, you may want to UNcheck these drug related symptoms<br> " +
	"to avoid them being used for the generation of disease conjectures.";
    final static String Terminate = "Terminate"; 
    // Diag1c.java
    // Diag1DiseaseSubsets.java
    // Diag1Focussed.java
    // Diag1SearchLTD.java
    // Diag1Subsystem.java
    // Diag1Unrestricted.java
    // Diag2.java
    final static String HealthScreen = "Health Screen";
    final static String Iteration = "Iteration:";
    final static String Diag2S1 = "Pop Up My Previous Choices";
    final static String FinalConclusion = "Final Conclusion";
    final static String NoDiseasesFound = "No Conditions Found";
    final static String Continue = "Continue";
    final static String BackToRoot = "Back to Root";
    final static String AnotherSearch = "Another Search";
    final static String Diag2S2 = "Please decide more symptoms:";
    // final static String ConjecturedDiseases = "Conjectured Diseases:";
    // The next 2 strings are part of:
    // Life threatening disease in red
    // They are split in two to change the color of "red" into red
    final static String Diag2S3 = "Life threatening conditions in";
    final static String red = "red";
    final static String Diag2S4 = "Get details in a popup through these links";
    final static String Support = "Probability";
    final static String Diag2S5 = 
	"A number in this column is the ratio of the confirmed symptoms and " +
	"the expected symptoms for a disease. " +
	"Thus the support for a disease is less than 1 when one or more of " +
	"its symptoms have not been confirmed because: " +
	"-- it is optional, -- you have not recognized it, or " +
	"-- the system has not yet presented the symptom(s) to you. " +
	"The ordering in the table depends on gender, age and frequency of occurrence.";
    final static String Diag2S52 = 
      "The same data as in the previous column, but in graphical form.";
    // final static String Hint = "Hint";
    // final static String Treatments = "Treatments:";
    final static String Frequency = "Frequency";
    final static String FrequencyHint = 
	"The bar length is an estimate of the occurrence of the condition in the " + 
	"population.";
    final static String Accept = "Accord?";
    final static String Diag2S6 = 
      "A selected entry will be entered in your record and the search terminates.";
    final static String Diag2S7 = "# candidate conditions:";
    final static String Diag2S8 = "# displayed:";
    // The next 3 strings are part of:
    // Warning!! The listed diseases as well as the support levels 
    // are based on the limited 'knowledge' in this program
    // They are split to put "limited" in italics 
    final static String Diag2S9 = 
      "Warning!! The listed conditions as well as the probabilities " +
      "are based on the ";
    final static String limited = "limited ";
    final static String Diag2S10 = "'knowledge' in this system.";
    final static String Diag2S11 = "You have reached a high iteration level.";
    final static String Diag2S12 = 
	"A plausible condition is usually already identified at a lower level.";
    final static String Diag2S13 = "Consider trying another search.";
    final static String Diag2S14 = 
	"If you don't get Accord with any of the conjectured disease, " +
	"you can certainly continue, even when one of the diseases has all " +
	"of its required symptoms confirmed.";

    // DiagAcceptDisease.java
    final static String NotifyPhysicianQ = "You want your physician to be notified?";
    final static String DiagAcceptDiseaseS1 = 
	"Your session will terminate if you select to notify your physician";
    final static String YesNotify = "YES notify my physician";
    final static String NoNotify = "Do NOT notify my physician";
    // DiagException.java
    final static String DiagException = "Diag Exception";
    final static String DiagExceptionS1 = 
      "No diseases found to explore or your input did not " +
      "yield a recognized symptom or body location.";
    final static String DiagExceptionS2 = 
       "Provide different input and/or use another search mode.";
    final static String DiagExceptionS3 = "Use the browser BACK button to return.";
    // DiagShow.java
    final static String ShowDiseaseDetail = "Show Disease Detail";
    final static String DiagShowS1 = "OK, Here the Show Disease Options";
    final static String DiagShowS2 = "Pop up the Details of a Life Threatening Disease";
    final static String DiagShowS3 = "Pop up the Details of Any Disease";
    // DiagStart.java
    final static String unspecified = "unspecified";
    final static String unspecifiedLoc = "no specific location";
    final static String SelectSearch = "Focussed Search";
    final static String TemperatureF = "Temperature (F)";
    final static String DiagStartS1 = "OK, Here the Search Options";
    final static String DiagStartS2 = 
       "There are several ways to proceed. " +
       "Whatever your choice you always can start over.";
    final static String DiagStartS3 = 
       "If this is your first visit, jump around on this page with the links below " +
       "before making your choice.";
    final static String DiagStartS4 = 
       "Focussed Search among the Diseases Associated " +
       "with the Initial Input - RECOMMENDED";
    final static String DiagStartS5 = 
       "Search in the Subset of Life Threatening Diseases";
    final static String DiagStartS6 = 
      "Search in the Subset of Diseases Associated with a Body Subsystem";
    final static String DiagStartS7 = "Search in Disease Subset(s) of your Choice";
    final static String DiagStartS8 = "Search in all Diseases";
    final static String DiagStartS9 = "Focussed Search - RECOMMENDED";
    final static String DiagStartS10 = "This search mode may be the fastest.";
    final static String DiagStartS11 = "Select a body location:";
    final static String DiagStartS12 = "Provide one or more symptoms:";
    final static String topOfPage = "Return to top of page";
    final static String DiagStartS13 = 
       "Search in the Subset of Life Threatening Diseases";
    final static String DiagStartS14 = 
       "Search in the Subset of Diseases Associated with a Body Subsystem";
    final static String DiagStartS15 = "Search in Disease Subset(s) of your Choice";
    final static String DiagStartS16 = 
       "The more subsets you include, the more time it will take " +
       "to reach a final conclusion.";
    final static String DiagStartS17 = "Search in all Diseases";
    final static String DiagStartS18 = 
       "This search mode may take the longest to reach a final conclusion.";
    final static String DiagStartS19 = "Search for/ Explain (gender neutral):";
    final static String DiagStartS20 = 
       "This choice can be changed in a later iteration.";
    final static String DiagStartS21 = "A location that bothers you.";
    final static String What = "What?";
    final static String SearchAdvice =
	"The submit produces a yellow popup screen.<br>" +
	"Yellow screen tables often have a Web resource entry with a link into Yahoo and Google.";
    final static String DiagStartS22 = "Select symptom(s)";
    final static String DiagStartS23 = "Select a specific worrysome location, if any";
    final static String DiagStartS24 = "Select symptom(s) from a list ...";
    final static String DiagStartS25 = "... or type them";
    final static String DiagStartS26 = "A mistake can be corrected on the next page";
    final static String DiagStartS27 = "Selected symptoms:";
    final static String DiagStartS28 = "Common Symptoms:";
    final static String DiagStartS29 = "Cant proceed without your input!!!";
    final static String DiagStartS30 = "No symptom for: ";
    final static String DiagStartS31 = "When found click on the item:";
    final static String DiagStartS32 = "Remove last";
    final static String DiagStartS32L = "Reset";
    final static String DiagStartS33 = "Type assisted:";
    final static String DiagStartS34 = "Type free form:";
    final static String DiagStartS35 = "Select from all locations";
    final static String DiagStartS36 = "Select from other locations";
    final static String CheckDrugEffects = "Check for side-effect of drug(s)";

    // DiseaseInst.java
    final static String SupportingSymptoms = "Supporting symptoms:";
    final static String DiseaseInstS1 = "Not confirmed symptoms:";
    final static String AcceptanceRate = "Acceptance rate:";
    final static String ExpectedTemperature = "Expected temperature:";
    final static String ReportedTemperature = "Reported temperature:";
    // DiseaseInst0.java
    final static String DiseaseInst0S1 = "Disease instance of:";
    final static String Source = "Source:";
    final static String StartDate = "Start Date:";
    // DisplayDiseaseConjecturesHist.java
    final static String DDCHS1 = "Disease Conjectures Details";
    final static String DDCHS2 = "Conjectured diseases in session:";
    final static String DDCHS3 = "Conjectured Diseases:";
    // DisplayDiseaseConjInst.java
    final static String DiseaseDetails = "Disease Details";
    final static String DetailsFor = "Details for";
    // DisplayDiseaseInst.java
    // DisplayDiseaseInstHist.java
    // ElaborateSymptomsQ
    final static String ElaborateSymptoms = "Elaborate Symptoms"; 
    final static String provideDetails = "Please provide details on these symptoms:";
    final static String Change = "Change:"; 
    final static String anHour = "an hour or less";
    final static String aFewHours = "a few hours";
    final static String aDay = "a day or less";
    final static String severalDays = "several days";
    final static String aWeek = "a week or less";
    final static String severalWeeks = "several weeks";
    final static String quiteAWhile = "quite a while";
    final static String noChange = "no change";
    final static String getsWorse = "gets worse";
    final static String getsLess = "gets less";
    final static String AdditionalComments = "Additional Comments:";
    // GetBMIInput.java
    final static String GetBMIInputS1 = "Get Body Mass Index Input";
    final static String GetBMIInputS2 = "No weight and/or height data available";
    final static String GetBMIInputS3 = "Calculate Body Mass Index";
    final static String GetBMIInputS4 = 
      "Click submit or modify the weight and/or height fields first";
    final static String GetBMIInputS5 = "My weight in lbs is:";
    final static String GetBMIInputS6 = "Save this value:";
    final static String GetBMIInputS7 = "My height in inches is:";
    // History.java
    final static String History = "History";
    final static String HistoryElements = "History Elements";
    final static String HistoryS1 = "Health Check History Summary";
    final static String HistoryS2 = "Some items from previous sessions:";
    final static String HistoryS3 = "Diseases Pre Health Check";
    final static String LogSession = "Log Session";
    final static String DiseaseConjecture = "Disease Conjecture:";
    final static String DiseaseConjectures = "Disease Conjectures:";
    final static String SelectedSymptoms = "Selected Symptoms:";
    final static String ChatSession = "Chat Session:";
    final static String ChatSessions = "Chat Sessions:";
    // Info.java
    final static String GetInfo = "Get Info"; 
    // KChatClientInput.java
    // KChatClientTop.java
    final static String KChatClientTopS1 = "is assisting you";
    // KClient.java
    // KClientCanvas.java **** DEAD CODE ****
    // KClientDigest.java
    // KClientScribe.java
    // ProcessWeightValue.java
    // SetSessionMaxInterval.java 
    // Setup.java
    // Setup2.java
    final static String Setup2S1 = "Obtain Woman Specific History";
    final static String Setup2S2 = "OK, Here Woman Specific Questions";
    final static String Setup2S3 = 
       "Based on your age the program has guessed " +
       "that you are in the life phase of:";
    final static String Setup2S4 = "Please correct if necessary:";
    final static String Setup2S5 = 
       "premenstruating: you have never menstruated and " +
       "according to your age you are not supposed to";
    final static String Setup2S6 = 
       "menstruating: (you are not pregnant) and you have had at least once " +
       "a menstruation or you should have had one given your age";
    final static String Setup2S7 = "pregnant: date of last menstruation:";
    final static String Setup2S8 = 
       "menopause: your menstruations have become irregular as " +
       "expected with your age";
    final static String Setup2S9 = 
       "postmenopause: your menstruations has ceased as " +
       "expected with your age";
    final static String Setup2S10 = "# life births:";
    final static String Setup2S11 = "# miscarriages:";
    final static String Setup2S12 = "# stillbirths:";
    // Setup3.java
    /*
    final static String Setup3S1 = "Setup is Completed";
    final static String Setup3S2 = "Setup is completed.  To login:";
    */
    final static String Setup3S3 = "click here.";
    final static String Setup3S4 = "Medication/ Allergy/ Family";
    final static String Setup3S5 = "Select medication/drugs used";
    final static String Setup3S6 = "Select them from the list ...";
    final static String Setup3S7 = "Selected medication:";
    final static String Setup3S8 = "Common medication";
    final static String Setup3S9 = "Select:";
    final static String Setup3S10 = "Select medication/drugs causing allergy";
    final static String Setup3S11 = "Family history";
    final static String Setup3S12 = "Selected diseases:";
    final static String Setup3S13 = "Major diseases of father:";
    final static String Setup3S14 = "Major diseases of mother:";
    final static String Setup3S15 = "Major diseases of a sibling:";
    /*
    final static String Setup3S12 = "If your father died already, due to what disease?";
    final static String Setup3S13 = "If your mother died already, due to what disease?";
    final static String Setup3S14 = "If a sibling died already, due to what disease?";
    */
    // SetupWoman.java
    // ShowInputs.java
    final static String ShowInputs = "Show Inputs";
    final static String ShowInputsS1 = "Show Inputs/ Iteration:";
    final static String ShowInputsS2 = "Inputs at iteration:";
    final static String BodyLocation = "Body Location:";
    final static String Suggestion = "Suggestion:";
    final static String ShowInputsS3 = 
       "To change a choice at a previous iteration use " +
       "the browser back button and correct your choice.";
    // ShowWeightGraph.java
    final static String SWGS1 = "Draw Weight Graph";
    final static String SWGS2 = "No weight data available ...";
    final static String SWGS3 = "Weight Graph/ Keep it up/down :-)";
    // TestSymptoms.java
    // UserLogout.java
    // UserSearch.java
    final static String UserSearch = "User Search";
    final static String UserSearchS1 = "User Search Input:";
    final static String UserSearchS2 = "Concepts Found:";
    final static String noneFound = "none found";
    final static String Diseases = "Diseases";
    final static String ConjecturedConcepts = "Conjectured Concepts:";
    final static String UserSearchS3 = "Not processed concepts:";


    // --------------- show pages --------------- 

    // DisplayBodySystem.java // ******************* DEAD CODE *********
    // DisplayTreatment.java
    final static String DisplayTreatmentS1 = "No treatment for";
    final static String TreatmentFor = "Treatment for";
    final static String TreatmentNum = "Treatment #";
    // EditXWords.java
    final static String AllXWords = "All XWords";
    final static String SelectXWord = "Select XWord,";
    // ShowAbnormalCondition.java
    final static String AnAbnormalCondition = "An Abnormal Condition";
    final static String ShowAC = "The Abnormal Condition:";
    // ShowAbnormalConditions.java
    final static String AllAbnormalConditions = "All Abnormal Conditions";
    // ShowAll.java
    // ShowBodySystem.java
    final static String ShowBodySystem = "The Body System:";
    // ShowBodySystems.java
    final static String AllBodySystems = "All Body Systems";
    // ShowDisease.java
    final static String TheDisease = "The Disease:";
    // ShowDiseases.java
    final static String AllDiseases = "All Diseases";
    // ShowDiseaseSet.java
    final static String TheDiseaseSet = "The Disease Set:";
    final static String ShowDiseaseSetS1 = "# disease members:";
    // ShowDiseaseSets.java
    final static String AllDiseaseSets = "All Disease Sets";
    final static String ShowDiseaseSetsS1 = "Select Disease Set, # =";
    // ShowDrugs
    final static String AllDrugs = "All Drugs";
    final static String TheDrug = "The Drug";
    // ShowExternalCause.java
    final static String TheExternalCause = "The External Cause:";
    // ShowExternalCauses.java
    final static String AllExternalCauses = "All External Causes";
    // ShowExternalCausesDis.java
    final static String SECDS1 = "All External Causes and Diseases";
    // ShowHasName.java
    // ShowLocation.java
    final static String TheLocation = "The Location:";
    // ShowLocations.java
    final static String AllLocations = "All Locations";
    // ShowSymptom.java
    final static String TheSymptom = "The Symptom:";
    // ShowSymptoms.java
    final static String AllSymptoms = "All Symptoms:";
    // ShowSymptomsDis.java
    // ShowXWord.java


    // -------------- html pages -------------- 

    // AdviceMenopause.html
    final static String AdviceMenopauseS1 = 
       "ADVICE: Since your postmenopause ";
    final static String AdviceMenopauseS2 = 
       "appears to be late, please make an appointment with your physician.";
    // AdviceMenstruating.html
    final static String AdviceMenstruatingS1 = 
      "ADVICE: Since your menopause ";
    final static String AdviceMenstruatingS2 = AdviceMenopauseS2;
    // AdvicePremenstruating.html
    final static String AdvicePremenstruatingS1 = 
      "ADVICE: Since a first menstruation ";
    final static String AdvicePremenstruatingS2 = AdviceMenopauseS2;
    // Angel.html
    final static String HealthCheckLogin = "Health Check Login";
    final static String AngelS1 = "Enter values in both fields ...";
    final static String AngelS2 = "Welcome to Your Health Check";
    final static String AngelS3 = "If you have a life threatening condition:";
    final static String AngelS4 = "Call 911 or go to the nearest hospital.";
    final static String AngelS5 = 
       "The medical information in this system will always be incomplete, and";
    final static String AngelS6 = 
       "while assembled with great care it remains subjective.";
    final static String AngelS7 = 
       "A symptom of a disease may not be manifest or a symptom may be";
    final static String AngelS8 = 
       "manifest that is unrelated with a disease, etc.";
    final static String AngelS9 = 
       "You and only you are FULLY responsible for any conclusion you draw from the";
    final static String AngelS10 = 
       "presented information!!";
    final static String AngelS11 = 
       "Proceed only provided you fully agree with the above statements.";
    final static String LoginName = "Login name:";
    final static String Password = "Password:";
    final static String AngelS12 = "First time visitor: ";
    final static String AngelS12B = "Create an anonymous account";
    final static String AngelS13 = "Change my password";
    final static String AngelS14 = "I want to know more about this site";
    final static String HELP = "HELP";
    final static String Warnings = "Warnings:";
    final static String AngelS15 = 
       "** Do NOT log in as another person.  You will get erroneous results and ";
    final static String AngelS16 = 
       "you will mess up the history of that other person.";
    final static String AngelS16B = 
	" Login as another person?";
    final static String AngelS17 = 
       "** If you you leave the site for more than 60 seconds, your session will be ";
    final static String AngelS18 = 
       "terminated automaticly.";
    final static String AngelS18B = 
	" Automatic Termination";
    final static String AngelS19 = 
       "** POPUPS::: This site USES popups. No, NOT for ads, but to explain, ";
    final static String AngelS20 = "for example, a medical term. ";
    final static String AngelS21 = 
       "Tell your browser to accept popups from this site. ";
    final static String AngelS22 = 
       "There are also popup links into Yahoo to further explain medical terms, ";
    final static String AngelS23 = "which may in turn create whatever popups.";
    final static String AngelS23B = "Pop Ups";
    final static String AngelS23C = "Pop Up Test";
    final static String AngelS23D = 
	"YES! Your browser allows pop ups for this site<p>" +
	"It will go away by it self ...";
    final static String AngelS24 = 
       "** Your browser (or you) must accept a (session) cookie, ";
    final static String AngelS25 = 
       "and must have Javascript and Java enabled.";
    final static String AngelS25B = 
	"Cookies, etc.";
    final static String AngelS26 = 
       "** We found that the following browsers are 'broken':";
    final static String and = "and";
    final static String AngelS27 = 
       "The browsers IE6.0, Netscape7 and 4.08 and likely many others DO work.";
    final static String AngelS28 = 
       "Netscape 7.1 does not handle blinking properly ...";

    // AngelQuick.html
    final static String HealthCheckQuick = "Health Check Quick";
    final static String Day = "Day:";



    // AngelRoot.html
    final static String AngelRoot = "Angel Root";
    final static String AngelRootS1 = "Your Health Tool At Your Service!";
    final static String Select = "Select";
    final static String ONE = "ONE";
    final static String ofThese = "of These";
    //    final static String HealthScreen = "Health Screen:";
    final static String AngelRootS2 = "What Condition Could I Have?";
    final static String AngelRootS2b = "What Condition Could I Have? - Advanced Search";
    final static String AngelRootS3 = 
       "Details of a Suspected Condition";
    final static String WeightProgram = "Weight Tracking";
    final static String AngelRootS4 = "Enter Today's Weight";
    final static String AngelRootS5 = "Enter/Change my Target Weight";
    final static String AngelRootS6 = "Display my Weight Graph";
    final static String AngelRootS7 = "Calculate my Body Mass Index";
    final static String Miscellaneous = "Miscellaneous";
    final static String AngelRootS8 = "Show Medical History";
    final static String AngelRootS9 = "Search For/ Explain";

    // faq.html
    final static String faqS1 = "Frequently Asked Questions";
    final static String faqS2 = "What can I do with this site?";
    final static String faqS3 = // spaces at the end of a string !
      "You can do a self-diagnosis based on the answers you give.  It is " +
      "actually a pre-diagnosis because the program cannot see you, touch " +
      "you, do lab test, x-ray's, etc.";
    final static String faqS4 = "You can also track your weigth.";
    final static String faqS5 = 
      "And you can search the build-in medical 'knowledge' and go " +
      "transparently into the WWW to Yahoo and Google.";
    final static String faqS6 = "Do I have to login?";
    final static String faqS7 = 
	"Only if you want to want to come back. " +
	"The system can use the 'history' in subsequent sessions.<br>";
    final static String faqS8 = 
	"Of course you also can look into the history.";
    final static String faqS9 = 
      "How long does it take to set up an anonymous account?";
    final static String faqS10 = "Two minutes at most.";
    final static String faqS11 = "Is an anonymous account really anonymous?";
    final static String faqS12 = 
      "Yes! Just create an account name that does not identify yourself. " +
      "The system does not ask you anything that can be used to identify " +
      "you.  It is wise to change the password that is given to you, but even " +
      "if you do not change it then noone can get at you.  They can only mess up " +
      "your history. ";
    final static String faqS13 = 
      "What can I do if - during self-diagnosis - I realize that a previously " +
      "clicked in symptom is wrong? ";
    final static String faqS14 = 
      "Just use the back-button and correct your mistake.  In fact you can go " +
      "all the way back to the start diagnostic page and start over again. ";
    // HON code additions
    final static String faqS15 = 
	"Where does the medical content come from?";
    final static String faqS16 = 
	"The medical content comes, among others, from:<br> " +
	"<i>The Merck Manual</i>, 17th Edition, 1999<br> " +
	"<i>Professional Guide to Diseases</i>, 6th Edition, Springhouse, 1998<br> " +
	"<i>Clinical Evidence</i>, London: BMJ Publ. Group, 2001<br> " +
	"<i>Professional Guide to Signs & Symptoms</i>, 4th Edition, Lippincott, Williams " +
	"& Wilkins, 2003";
    final static String faqS17 = 
	"Does this site replaces the need for a (personal) physician?";
    final static String faqS18 = 
	"No.  Remember that this site provides at most a pre-diagnosis.  The site may help " +
	"you decide that you do not need (now) to contact a physician, or may help you decide " +
	"to get help soon, or may help you clarify questions to raise with your physician, etc. " +
	"In short: helping with your choices.";
    final static String faqS19 = 
	"Who provided the funding for this site?";
    final static String faqS20 = 
	"Nobody.";

    // GetTargetWeight.html
    final static String GTWS1 = "Weight Management Program";
    final static String GTWS2 = "Welcome to Weight Management";
    final static String GTWS3 = "Please provide your TARGET weight:";
    final static String GTWS4 = "My target weight is:";
    // help.html
    final static String Problem = "Problem:";
    final static String helpS1 = "I have trouble with creating an anonymous account.";
    final static String helpS2 = 
       "Sorry for that.  Here an example:";
    final static String helpS3 = 
       "- Click on the link: First time visitor: Create first an anonymous account";
    final static String helpS4 = "- Type in, for example: name23";
    final static String helpS5 = 
       "- This creates the account name23 with password name23";
    final static String helpS6 = 
       "- Proceed with the setup using name23 and name23";
    final static String helpS7 = 
       "- When the setup is completed login with name23 and name23";
    final static String helpS8 = "Yes, you can also change your password.";
    final static String helpS9 = "I cannot login.";
    final static String helpS10 = "Did you create first an anonymous account?";
    final static String IfNot = "If not:";
    final static String helpS11 = "Create an anonymous account";
    final static String helpS12 = "I forgot my password.";
    final static String helpS13 = 
       "If you are willing to disclose your email address then provide also your " +
       "user name and describe when you created the account, how many sessions you " +
       "think you had and things that you entered when you setup the account and " +
       "send this to:";
    final static String helpS14 = "ask for my password.";
    final static String helpS15 = 
       "Otherwise just create another account - with a different user name of course.";
    final static String helpS16 = 
       "I get a pink page that tells me that I cannot login twice.";
    final static String helpS17 = "That's right. There are several possibilities:";
    final static String helpS18 = 
       "-- You interrupted the setup of your account and went to another site. Try:";
    final static String killSession = "kill session";
    final static String helpS19 = "and do a login,";
    final static String helpS20 = "which will restart the account setup process.";
    final static String helpS21 = "-- You are logged in with the";
    final static String helpS22 = "same browser";
    final static String helpS23 = "as yourself or as another user.";
    final static String helpS24 = 
       "If you are already logged in as yourself, why logging in again?  You cannot.  " +
       "If you are logged in as another user, logout first.";
    final static String helpS25 = "-- You are logged in with";
    final static String helpS26 = "another browser.";
    final static String helpS27 = 
       "Well, you cannot and why login twice in the first place?";
    final static String helpS28 = "-- You are logged in on";
    final static String helpS29 = "another machine.";
    final static String helpS30 = 
       "Logout first.  You are at home and the other machine is at work?  Try:";
    final static String helpS31 = 
       "or you will be logged out when the server reboots: 12 noon and midnight PST.";
    final static String helpS32 = "-- Someone else is using your account. Try:";
    final static String helpS33 = "and change your password as soon as you can login again.";
    final static String helpS34 = 
       "-- Hmmm.  You mean the previous five cases do not apply? " +
       "Sorry to hear that.  Please let us know how you got in this pickle:";
    final static String helpS35 = "yeah, there is something else happening ...";
    final static String helpS36 = "I have another problem.";
    final static String helpS37 = "Sorry to hear that.  Please let us know:";
    final static String helpS38 = "yes, I have another problem ...";
    // index.html ***** Not yet translated *****
    // kblank.html ** Nothing to translate **
    // kChatClientInput.html
    final static String kCCIS1 = "Send to CallCenter";
    final static String kCCIS2 = "Terminate Chat Session/Cancel";
    // kChatCPersonInput.html
    final static String kCCPIS1 = "Send to Client";
    // kClientChat.html
    final static String ClientChat = "Client Chat";
    // kCPersonChat.html
    final static String CCPersonChat = "CC Person Chat";
    // killSession.html
    final static String KillSession = "Kill Session";
    // OntoOO.html ***** Not yet translated *****
    // ProgWeight.html
    final static String WeightManagementProgram = "Weight Management Program";
    final static String ProgWeightS1 = "Welcome to Weight Management";
    final static String ProgWeightS2 = "Please provide today's weight:";
    // SendMail.html
    final static String SendMail = "Send Mail";
    final static String SendMailS1 = "Your email address if you want an answer:";
    final static String YourMessage = "Your message:";
    // SetupAccount.html
    final static String SetupAccount = "Setup Account";
    final static String SetupAccountS1 = "The system does not 'know' you ... ";
    final static String SetupAccountS2 = 
       "To setup your account you have to answer first a questionaire.";
    final static String SetupAccountS3 = 
       "The more details you provide the more specific will be the information " +
       "that can be generated for you.";
    final static String SetupAccountS4 = 
       "If you have concerns regarding privacy, please contact your provider.";
    final static String ToProceed = "To proceed";
    // start.html
    final static String startS1 = "Set up new user";
    final static String startS2 = "OK, Lets Setup a New Account";
    final static String startS3 = "To access your data:";
    final static String Identification = "Identification:";
    final static String Administratrivia = "Administratrivia:";
    final static String FirstName = "First Name:";
    final static String LastName = "Last Name:";
    // final static String StreetAddress = "Street Address:";
    // final static String City = "City:";
    final static String State = "State:";
    // final static String ZipCode = "Zip code:";
    // final static String HomePhone = "Home Phone:";
    final static String startS4 = 
       "Is this line still available when you are connected with the Internet?";
    final static String ProviderId = "Provider Id:";
    final static String SomeDetails = "Some Details:";
    final static String Year = "Year:";
    final static String Month = "Month:";
    final static String PopulationGroup = "Population group:";
    final static String SexualOrientation = "Sexual orientation:";
    final static String oppositeSex = "opposite sex";
    final static String sameSex = "same sex";
    final static String bothSexes = "both sexes";
    final static String noneAbstain = "none/ abstain";
    final static String Miscellania = "Miscellania:";
    final static String Height = "Height(inches):"; // cm in EU
    final static String Weight = "Weight(lbs):"; // kg in EU
    final static String BloodGroup = "Blood Group:";
    final static String unKnown = "un-known";
    // start2.html
    final static String start2S1 = "Set up new user 2";
    final static String start2S2 = "OK, Here the 2nd Set of Questions";
    final static String LifeStyle = "Life style:";
    final static String MaritalStatus = "Marital Status:";
    final static String single = "single";
    final static String marriedOK = "married OK";
    final static String marriedNotOK = "married not OK";
    final static String remarried = "remarried";
    final static String separated = "separated";
    final static String divorced = "divorced";
    final static String widow = "widow(er)";
    final static String Smoking = "Smoking?";
    final static String lessThanOnePackDay = "less than one pack a day";
    final static String onePackDay = "one pack a day";
    final static String twoPackDay = "two pack a day";
    final static String moreThanTwoPackDay = "more than two pack a day";
    final static String Alcohol = "Alcohol?";
    final static String never = "never";
    final static String infrequent = "infrequent";
    final static String frequent = "frequent";
    final static String daily = "daily";
    final static String Exercising = "Exercising?";
    final static String start2S3 = "Sources of Tension and Worries:";
    final static String job = "job";
    final static String spouse = "spouse";
    final static String finances = "finances";
    final static String religion = "religion";
    final static String fellowEmployees = "fellow employees";
    final static String drugs = "drugs";
    final static String alcohol = "alcohol";
    // start3.html
    final static String start3S1 = "Set up new user 3";
    final static String start3S2 = "OK, Here the 3rd Set of Questions";
    final static String Illnesses = "Illnesses:";
    final static String start3S3 = "Check which apply & add year of illness";
    // StartAnonymous.html
    final static String StartAS1 = "Set up new anonymous user";


    // -------------- phone pages -------------- 
    final static String vxml1 =
	"<!DOCTYPE vxml PUBLIC \"-//BeVocal Inc//VoiceXML 2.0//EN\" \n" + 
	"	  \"http://cafe.bevocal.com/libraries/dtd/vxml2-0-bevocal.dtd\"> \n" +
	"<vxml version=\"2.0\"  xmlns=\"http://www.w3.org/2001/vxml\"> \n";
    final static String vxml2 =
	"<!DOCTYPE vxml PUBLIC '-//Nuance/DTD VoiceXML 1.0//EN' \n" +
	"          'http://voicexml.nuance.com/dtd/nuancevoicexml-1-2.dtd'> \n" +
	"<vxml version=\"2.0\"> \n";

    final static String noHelp = "I am sorry.  There is no help available here."; 
    final static String silence = "I am sorry. I did not hear anything.";
    final static String nomatch = "I did not get that.";


    final static String PhoneLoginS1 = "An unexpected session was invalidated.  Try to call in again.";

    final static String AskLocationS0 = "Your session expired while in Ask Location.";
    final static String partOrBody = 
	"Say <break time=\"500ms\"/> \"a part\" or say <break time=\"500ms\"/> \"body\".  ";
    final static String AskLocationS1 =
	"The first step is identifying a specific area, if any, of concern. \n" +
	"At any time you can say \"help\" to have a question repeated and or to obtain advice. \n" +
	"Are you bothered by a distinct part of your \"body\" \n" +
	"or does your problem concerns your whole \"body\"? \n" +
	"Please say \"a part\" or say \"body\". \n";
    final static String partOrBody2 = "PART [(a part) body] ";
    final static String AskLocationS2 =
	"<if cond=\"(answer == 'a part') \"> \n" +
	"    <prompt> \n" +
	"        OK, will explore parts of your: \"body\". \n";
    final static String AskLocationS3 = "OK, will concentrate on your: \"body\". \n"; 
    final static String AskLocationS4 = 
	"Other examples: abdomen, joints, back, my eyes, my lungs, and so on. \n";
    final static String AskLocationS5 = 
	"Please say which part of your body is bothering you the most. \n" +
	"For example say: neck, or say: my knees, or say: stomach, or say: my head. \n" +
	"Say \"help\" to hear some other choices. \n";
    final static String AskLocationS6 = 
"           [(?my abdomen)] {<answer2 \"abdomen\"> <answer3 \"abdomen\">} \n " +
"           [(?my ankles)] {<answer2 \"ankles\"> <answer3 \"ankles\">} \n " +
"           [(?my left ankle)] {<answer2 \"leftAnkle\"> <answer3 \"left ankle\">} \n " +
"           [(?my right ankle)] {<answer2 \"rightAnkle\"> <answer3 \"right ankle\">} \n " +
"           [(?my arms)] {<answer2 \"arms\"> <answer3 \"arms\">} \n " +
"           [(?my left arm)]  {<answer2 \"leftArm\"> <answer3 \"left arm\">} \n " +
"           [(?my right arm)] {<answer2 \"rightArm\"> <answer3 \"right arm\">} \n " +
"           [(?my arm pits)] {<answer2 \"armPits\"> <answer3  \"arm pits\">} \n " +
"           [(?my left arm pit)] {<answer2 \"leftArmPit\"> <answer3  \"left arm pit\">} \n " +
"           [(?my right arm pit)] {<answer2 \"rightArmPit\"> <answer3  \"right arm pit\">} \n " +
"           [(?my back)] {<answer2 \"back\"> <answer3  \"back\">} \n " +
"           [(?my chest)] {<answer2 \"chest\"> <answer3  \"chest\">} \n " +
"           [(?my ears)] {<answer2 \"ears\"> <answer3  \"ears\">} \n " +
"           [(?my left ear)]  {<answer2 \"leftEar\"> <answer3  \"left ear\">} \n " +
"           [(?my right ear)] {<answer2 \"rightEar\"> <answer3  \"right ear\">} \n " +
"           [(?my elbows)] {<answer2 \"elbows\"> <answer3  \"elbows\">} \n " +
"           [(?my left elbow)]  {<answer2 \"leftElbow\"> <answer3  \"left elbow\">} \n " +
"           [(?my right elbow)] {<answer2 \"rightElbow\"> <answer3  \"right elbow\">} \n " +
"           [(?my eyes)] {<answer2 \"eyes\"> <answer3  \"eyes\">} \n " +
"           [(?my left eye)]  {<answer2 \"leftEye\"> <answer3  \"left eye\">} \n " +
"           [(?my right eye)] {<answer2 \"rightEye\"> <answer3  \"right eye\">} \n " +
"           [(?my face)] {<answer2 \"face\"> <answer3  \"face\">} \n " +
"           [(?my feet)] {<answer2 \"feet\"> <answer3  \"feet\">} \n " +
"           [(?my left foot)] {<answer2 \"leftFoot\"> <answer3  \"left foot\">} \n " +
"           [(?my right foot)] {<answer2 \"rightFoot\"> <answer3  \"right foot\">} \n " +
"           [(?my fingers)] {<answer2 \"fingers\"> <answer3  \"fingers\">} \n " +
"           [(?my left fingers)]  {<answer2 \"leftFingers\"> <answer3  \"left fingers\">} \n " +
"           [(?my right fingers)] {<answer2 \"rightFingers\"> <answer3  \"right fingers\">} \n " +
"           [(?my hands)] {<answer2 \"hands\"> <answer3  \"hands\">} \n " +
"           [(?my left hand)]  {<answer2 \"leftHand\"> <answer3  \"left hand\">} \n " +
"           [(?my right hand)] {<answer2 \"rightHand\"> <answer3  \"right hand\">} \n " +
"           [(?my head)] {<answer2 \"head\"> <answer3  \"head\">} \n " +
"           [(?my heart)] {<answer2 \"heart\"> <answer3  \"heart\">} \n " +
"           [(?my hips)] {<answer2 \"hips\"> <answer3  \"hips\">} \n " +
"           [(?my left hip)]  {<answer2 \"leftHip\"> <answer3  \"left hip\">} \n " +
"           [(?my right hip)] {<answer2 \"rightHip\"> <answer3  \"right hip\">} \n " +
"           [(?my intestines)] {<answer2 \"intestines\"> <answer3  \"intestines\">} \n " +
"           [(?my jaws)] {<answer2 \"jaws\"> <answer3  \"jaws\">} \n " +
"           [(?my left jaw)]  {<answer2 \"leftJaw\"> <answer3  \"left jaw\">} \n " +
"           [(?my right jaw)] {<answer2 \"rightJaw\"> <answer3  \"right jaw\">} \n " +
"           [(?my joints)] {<answer2 \"joints\"> <answer3  \"joints\">} \n " +
"           [(?my left joints)]  {<answer2 \"leftJoints\"> <answer3  \"left joints\">} \n " +
"           [(?my right joints)] {<answer2 \"rightJoints\"> <answer3  \"right joints\">} \n " +
"           [(?my kidneys)] {<answer2 \"kidneys\"> <answer3  \"kidneys\">} \n " +
"           [(?my left kidney)]  {<answer2 \"leftKidney\"> <answer3  \"left kidney\">} \n " +
"           [(?my right kidney)] {<answer2 \"rightKidney\"> <answer3  \"right kidney\">} \n " +
"           [(?my knees)] {<answer2 \"knees\"> <answer3  \"knees\">} \n " +
"           [(?my left knee)]  {<answer2 \"leftKnee\"> <answer3  \"left knee\">} \n " +
"           [(?my right knee)] {<answer2 \"rightKnee\"> <answer3  \"right knee\">} \n " +
"           [(?my legs)] {<answer2 \"legs\"> <answer3  \"legs\">} \n " +
"           [(?my left leg)]  {<answer2 \"leftLeg\"> <answer3  \"left leg\">} \n " +
"           [(?my right leg)] {<answer2 \"rightLeg\"> <answer3  \"right leg\">} \n " +
"           [(?my liver)] {<answer2 \"liver\"> <answer3  \"liver\">} \n " +
"           [(?my lungs)] {<answer2 \"lungs\"> <answer3  \"lungs\">} \n " +
"           [(?my left lung)]  {<answer2 \"leftLung\"> <answer3  \"left lung\">} \n " +
"           [(?my right lung)] {<answer2 \"rightLung\"> <answer3  \"right lung\">} \n " +
"           [(?my neck)] {<answer2 \"neck\"> <answer3  \"neck\">} \n " +
"           [(?my nose)] {<answer2 \"nose\"> <answer3  \"nose\">} \n " +
"           [(?my shoulders)] {<answer2 \"shoulders\"> <answer3  \"shoulders\">} \n " +
"           [(?my left shoulder)]  {<answer2 \"leftShoulder\"> <answer3  \"leftShoulder\">} \n " +
"           [(?my right shoulder)] {<answer2 \"rightShoulder\"> <answer3  \"rightShoulder\">} \n " +
"           [(?my stomach)] {<answer2 \"stomach\"> <answer3  \"stomach\">} \n " +
"           [(?my throat)] {<answer2 \"throat\"> <answer3  \"throat\">} \n " +
"           [(?my tongue)] {<answer2 \"tongue\"> <answer3  \"tongue\">} \n " +
"           [(?my torso)] {<answer2 \"torso\"> <answer3  \"torso\">} \n ";
    final static String AskLocationS7 = 
	"Your answer was not recognized.  Let's try one more time with a more specific location. \n";
    final static String AskLocationS8 = 
	"Your answer was again not recognized.  Will try another systematic approach. \n";
    final static String AskLocationS9 = "OK will explore further: ";
    final static String AskBodyPart0 = "Your session expired while in Ask Body Part";
    final static String AskBodyPart1 = "OK, which part of your: ";
    final static String AskBodyPart2 = " if any, hinders you the most? \n";
    final static String AskBodyPart3 = "Select from the following choices: \n";
    final static String AskBodyPart4 = "OK will focus now on ";
    final static String AskBodyPart6 = 
	"An error happend in Ask Body Part.  The call will terminate!! \n";
    final static String PhoneError1 = 
	"A problem has been encountered that prevents continuation.  Specificly: \n";
    final static String PhoneLogout1 = 
	"Thanks for using Health Check's phone advice line.  Bye now. \n";
    final static String LocationNarrowedQ1 =
	"Your session expired while in Location Narrowed Q.";
    final static String RefinePartQ1 =
	"Your session expired while in Refine Part Q.";
    final static String AskPart1 =
	"Your session expired while in Ask Part.";
    final static String AskPart2 =
	"If you say \"a part\" you can then later select from the following: ";			    
    final static String AskPart3 =
	"Just say: ";
    final static String AskPart4 =
	" if you do <emphasis level=\"strong\"> not </emphasis> want to zoom in further. ";
    final static String AskPart5 =
	"Are you bothered by a distinct part of your ";
    final static String AskPart6 =
	" or does your problem concerns your whole ";
    final static String AskPart7 =
	"If you are focussed on a part of your ";
    final static String AskPart8 =
	"  say: \"a part\". \n";
    final static String AskPart9 =
	"  Otherwise say: ";
    final static String AskPart10 =
	" Say \"help\" to hear the choices you will get after you say \"a part\". \n";
    final static String AskPart11 =
	"              [ (a part) ] {<answer \"aPart\">} \n";
    final static String AskPart12 =
	"OK, will explore parts of your: ";
    final static String AskPart13 =
	"OK, will concentrate on your: ";
    final static String AskLocDrivenSymptoms1 =
	"Your session expired while in Ask Loc Driven Symptoms.";
    final static String AskLocDrivenSymptoms2 =
	"Do you have the symptom:";
    final static String AskLocDrivenSymptoms3 =
	"described by";
    final static String AskLocDrivenSymptoms4 =
	"Got it: you do have";
    final static String AskLocDrivenSymptoms5 =
	"OK, will get the next batch of questions, if any.";
    final static String AskMembers1 =
	"Your session expired while in Ask Members.";
    final static String noneOfThem = "none of them";
    final static String AskMembers3 =
	"OK, which member of the: ";
    final static String AskMoreSymptoms1 =
	"Your session expired while in Ask More Symptoms.";
    final static String AskMoreSymptoms2 =
	"You will now be transferred to a physician in the call center.";
    final static String AskMoreSymptoms3 =
	"The disease ";
    final static String AskMoreSymptoms4 =
	" has the rating: ";
    final static String AskMoreSymptoms5 =
	" is life threatening. ";
    final static String AskMoreSymptoms6 =
	"Start tracing info. ";
    final static String AskMoreSymptoms7 =
	"There are no disease conjectures yet."; 
    final static String AskMoreSymptoms8 =
	"The rating of the disease conjecture with most support is still " +
	"less than one.  The system has now found ";
    final static String AskMoreSymptoms9 =
	"disease conjectures. " +
	"Here some top disease conjectures: ";
    final static String AskMoreSymptoms10 =
	"Currently, the system will continue asking for symptoms " +
	"until one of the disease conjectures has full support. " +
	"Just hang up if you can not achieve this termination condition. ";
    final static String AskMoreSymptoms11 =
	"End tracing info.";

    final static String AskSubsets1 =
	"Your session expired while in Ask Subsets.";
    final static String AskSubsets2 =
	"OK, which subset of the: ";
    final static String AskSymptom1 =
	"Your session expired while in Ask Symptom.";
    final static String AskSymptom2 =
	"Please say which symptom bothers you the most.";
    final static String AskSymptom3 =
	"Secondly, we are investigating which symptoms you may have. " +
	"Please say which symptom bothers you the most. " +
	"For example say: short of breath, or say: headache, or say: chills, or say: cough, " +
	"or say chest pain, or say sore throat. ";
    final static String AskSymptom4 =
"     [(?i ?have abdomen pain) (pain ?in abdomen)] {<answer3 \"abdomen pain\"> <answer \"abdomenPain\">} \n " +
"     [(?i ?have no appetite) \n "+
"                 (?i ?am not hungry) \n "+
"                 (?i ?have not eaten) \n "+
"                 (?i don't want food) \n "+
"                 (?i don't  eat) \n "+
"                 (?i can't  eat)] \n "+
"                      {<answer3 \"no appetite\"> <answer \"anorexia\">} \n " +
"    [(?i ?have anxiety) \n " +
"                 (?i ?am fearfull) \n " +
"                 (?i ?am afraid) \n " +
"                 (?i ?am anxious) \n " +
"                 (?i ?am frightened)] \n " +
"                     {<answer3 \"anxious\"> <answer \"anxiety\">} \n " +
"    [(?i ?have arrhythmia)] {<answer3 \"arrhythmia\"> <answer \"arrhythmia\">} \n " +
"    [(?i ?have chills) \n " +
"                 (?i ?am ?feel cold) ] \n " +
"                      {<answer3 \"chills\"> <answer \"chills\">} \n " +
"    [(?i ?have confusion) \n "+
"                 (?i ?am confused)] \n " +
"                     {<answer3 \"confused\"> <answer \"confusion\">} \n " +
"    [(?i cough)(?i ?am coughing)] {<answer3 \"cough\"> <answer \"cough\">} \n " +
"    [(?i ?have crackles)] {<answer3 \"crackles\"> <answer \"crackles\">} \n " +
"    [(?i ?have diarrhea)] {<answer3 \"diarrhea\"> <answer \"diarrhea\">} \n " +
"    [(?i ?have blue skin) \n " + 
"                 (?i ?have blueish skin)] \n " +
"                     {<answer3 \"blue skin\"> <answer \"cyanosis\">} \n " +
"    [(?i ?have short of breath) \n " +
"                 (?i can not breath)] {<answer3 \"short of breath\"> <answer \"dyspnea\">} \n " +
"    [(?i ?have dysuria) \n " +
"                 (?i ?can not piss) \n " +
"                 (?i can't piss) \n " +
"                 (?i ?can not pee) \n " +
"                 (?i can't pee) \n " +
"                 (?i ?can not urinate) \n " +
"                 (?i can't urinate)] \n " +
"                     {<answer3 \"can't urinate\"> <answer \"dysuria\">} \n " +
"    [(?i ?have edema)(?i ?have swellings)] {<answer3 \"swellings\"> <answer \"edema\">} \n " +
"    [(?i ?am fatigued) \n " +
"                 (?i ?am tired)] \n " +
"                     {<answer3 \"tired\"> <answer \"fatique\">} \n " +
"    [(?i ?have ?a headache)] {<answer3 \"\"> <answer \"headache\">} \n " +
"    [(?i ?have low blood pressure) (blood pressure low)] \n " +
"                     {<answer3 \"low blood pressure\"> <answer \"hypotension\">} \n " +
"    [(?i ?am ?feel irritated )] \n " +
"                     {<answer3 \"irritated\"> <answer \"irritability\">} \n " +
"    [(?i ?feel sick)\n " +
"                 (?i ?feel miserable)] \n" +
"                     {<answer3 \"sick\"> <answer \"malaise\">} \n " +
"    [(?i ?have myalgia) \n " +
"                 (?i ?have muscle pain) \n " +
"                 (?i ?have painful muscles) \n " +
"                 (?i ?have hurting muscles) \n " +
"                 (?my muscles are painful) \n " +
"                 (?my muscles hurt)] \n " +
"                      {<answer3 \"muscle pain\"> <answer \"myalgia\">} \n " +
"    [(?i ?have nausea)] {<answer3 \"nausea\"> <answer \"nausea\">} \n " +
"    [(?i ?have seizures)] {<answer3 \"seizures\"> <answer \"seizure\">} \n " +
"    [(?i ?have ?a ?too fast heartbeat) \n" +
"                 (?my heartbeat ?is ?too fast)] \n" +
"                      {<answer3 \"fast heartbeat\"> <answer \"tachycardia\">} \n " +
"    [(?i breath fast) (fast breathing)] {<answer3 \"breath fast\"> <answer \"tachypnea\">} \n " +
"    [(?i ?have ?a sore throat) (throat ?is sore)] {<answer3 \"sore throat\"> <answer \"throatSore\">} \n " +
"    [(?i ?am vomiting)] {<answer3 \"vomiting\"> <answer \"vomiting\">} \n " +
"    [(?i ?feel ?am weak)\n " +
"                 (?i ?feel weakness)] \n" +
"                     {<answer3 \"weakness\"> <answer \"weakness\">} \n " +
"    [(?i ?am loosing weight) \n " +
"                 (?i ?have lost weight) \n " +
"                 (?i ?have weight loss)] \n " +
"                     {<answer3 \"weight loss\"> <answer \"weightloss\">} \n ";
    final static String AskSymptom5 =
	"Your answer was not recognized.  Let's try one more time.";
    final static String AskSymptom6 =
	"Your answer was again not recognized.  You are put for now in the wait queue.";
    final static String AskSymptom7 =
	"OK will proceed with: ";

    final static String PCheckStatus0 = 
	"Your session expired while in Phone Check Status.";
    final static String PCheckPremenstruating2S =
	"Since a first menstruation appears to be late, \n " +
	"please make an appointment with your physician.  \n"  +
	"Do you still want to proceed with this call? \n ";
    final static String PCheckStatus1 = 
	"OK, let's figure out the date of your last menstruation. " +
	"First the month and then the day. " +
	"What was the last month in which you menstruated? " +
	"For example say \"June\". ";
    final static String PCheckStatus2 = 
	"  [january] {<month \"Jan0\">} \n " +
	"  [february] {<month \"Feb1\">} \n " +
	"  [march] {<month \"Mar2\">} \n " +
	"  [april] {<month \"Apr3\">} \n " +
	"  [may] {<month \"May4\">} \n " +
	"  [june] {<month \"Jun5\">} \n " +
	"  [july] {<month \"Jul6\">} \n " +
	"  [august] {<month \"Aug7\">} \n " +
	"  [september] {<month \"Sep8\">} \n " +
	"  [october] {<month \"Oct9\">} \n " +
	"  [november] {<month \"Nov10\">} \n " +
	"  [december] {<month \"Dec11\">} \n ";
    final static String PCheckStatus3 = 
	"OK, now the day of your last menstruation. " +
	"For example say \"seventh\" or say \"twenty first\". ";
    final static String PCheckStatus4 = 
	"  [first] {<day \"1\">} \n " +
	"  [second] {<day \"2\">} \n " +
	"  [third] {<day \"3\">} \n " +
	"  [fourth] {<day \"4\">} \n " +
	"  [fifth] {<day \"5\">} \n " +
	"  [sixth] {<day \"6\">} \n " +
	"  [seventh] {<day \"7\">} \n " +
	"  [eighth] {<day \"8\">} \n " +
	"  [ninth] {<day \"9\">} \n " +
	"  [tenth] {<day \"10\">} \n " +
	"  [eleventh] {<day \"11\">} \n " +
	"  [twelfth] {<day \"12\">} \n " +
	"  [thirteenth] {<day \"13\">} \n " +
	"  [fourteenth] {<day \"14\">} \n " +
	"  [fifteenth] {<day \"15\">} \n " +
	"  [sixteenth] {<day \"16\">} \n " +
	"  [seventeenth] {<day \"17\">} \n " +
	"  [eighteenth] {<day \"18\">} \n " +
	"  [nineteenth] {<day \"19\">} \n " +
	"  [twentieth] {<day \"20\">} \n " +
	"  [(twenty first)] {<day \"21\">} \n " +
	"  [(twenty second)] {<day \"22\">} \n " +
	"  [(twenty third)] {<day \"23\">} \n " +
	"  [(twenty fourth)] {<day \"24\">} \n " +
	"  [(twenty fifth)] {<day \"25\">} \n " +
	"  [(twenty sixth)] {<day \"26\">} \n " +
	"  [(twenty seventh)] {<day \"27\">} \n " +
	"  [(twenty eighth)] {<day \"28\">} \n " +
	"  [(twenty ninth)] {<day \"29\">} \n " +
	"  [thirtieth] {<day \"30\">} \n " +
	"  [( thirty first )] {<day \"31\">} \n ";
    final static String PCheckStatus5 = 
	"Got it!"; 
    final static String PCheckStatus6 = 
	"According to previously provided info you have never menstruated. " +
	"Please say \"never menstruated\" if you have still never menstruated. " +
	"Say \"I have menstruated\" if you do have menstruated and you are not pregnant. " +
	"Say \"I am pregnant\" if you are now pregnant. " +
	"Say \"help\" to hear these choices again. ";
    final static String PCheckStatus7 = 
	"[(?i ?have never menstruated)] {<answer \"premenstruating\">} \n " +
	"[(?i ?have menstruated)] {<answer \"menstruating\">} \n " +
	"[(?i ?am pregnant)] {<answer \"pregnant\">} \n ";
    final static String PCheckStatus8 = 
	"According to previously provided info you were pregnant. " +
	"Your last recorded menstruation was ";
    final static String PCheckStatus9 = 
	"days ago. " +
	"Is that pregnancy still continuing? " +
	"Answer no if you had a miscarriage. ";
    final static String PCheckStatus10 = 
	"Have you become pregnant again? ";
    final static String PCheckStatus11 = PCheckStatus8;
    final static String PCheckStatus12 = 
	"days ago. ";
    final static String PCheckStatus13 = 
	"If that pregnancy is still continuing you are now overdue for ";
    final static String PCheckStatus14 = 
	"days and you should contact a physician. ";
    final static String PCheckStatus15 = 
	"Is that pregnancy still continuing? ";
    final static String PCheckStatus16 = 
	"If you had a life birth say \"life birth\". " +
	"If you had a still birth say \"still birth\". " +
	"If you had a miscariage say \"miscarriage\". " +
	"Say \"help\" to hear these choices again. ";
    final static String PCheckStatus17 = 
	" [(?i ?had ?a life birth)] {<answer \"lifeBirth\">} \n " +
	" [(?i ?had ?a miscarriage)] {<answer \"miscarriage\">} \n " +
	" [(?i ?had ?a stillBirth)] {<answer \"stillBirth\">} \n ";
    final static String PCheckStatus18 = 
	"According to previously provided info you were not pregnant. " +
	"Are you now pregnant? ";
    final static String PCheckStatus19 = 
	"Have you entered menopause? ";
    final static String PCheckStatus20 = 
	"According to previously provided info you are in menopause. " +
	"Please say \"menopause\" if you are still in menopause. " +
	"Say \"postmenopause\" if you have transitioned into postmenopause. " +
	"Say \"I am pregnant\" if you happen to be pregnant. " +
	"Say \"help\" to hear these choices again. ";
    final static String PCheckStatus21 = 
	" [(menopause)] {<answer \"menopause\">} \n " +
	" [(postmenopause)] {<answer \"postmenopause\">} \n " +
	" [(?i ?am pregnant)] {<answer \"pregnant\">} \n ";

    final static String PhoneWait1 =
	"Your session expired while in Phone Wait.";
    final static String PhoneWait2 = AskMoreSymptoms2;
    // "You will now be transferred to a physician in the call center. \n" 
    final static String PhoneWait3 = 
	"Waiting time ends.  " +
	"Thanks for using Health Check's phone advice line. " +
	"Bye now.";
    final static String PhoneWait4 = 
	"You arrived here either because either the system was not able " +
	"to recognize a body area " +
	"and neither any symptom or you managed to provide " +
	"all the symptoms for a disease conjecture. " +
	"The wait mode will currently terminate within a minute. ";
    final static String PhoneWait5 = 
	"You are still waiting with count is ";
    final static String PhoneWait6 = 
	"The wait mode will terminate pretty soon. ";
	
    final static String PSetPregnant1 =
	"Your session expired while in Phone Set Pregnant.";
    final static String PSetPregnant2 =
	"It looks like that your pregnancy is over due. \n " +
	"You should contact your physician or go to a hospital or perhaps call nine one one. \n" +
	"Do you still want to proceed with this call? \n";

    final static String 
	AnySymptomsQ1 = "Your session expired while in Any Symptoms Q.";

    // -------------- Actor stuff -------------- 
    final static String warrants = " warrants a visit to your physician.";
    final static String havingFever = "A fever" + warrants;
    final static String childWeightLoss = "Weight loss over 10%" + warrants;
    final static String inactive =
	"You have been inactive for awhile.<br>Call 911 if you need help";
    final static String lifeThreateningConjecture1 = "The life threatening disease ";
    final static String lifeThreateningConjecture2 = "has the acceptance rate ";
    final static String lifeThreateningConjecture3 = "Consider calling 911.";
    final static String internalCauseConjecture1 = "The disease conjecture ";
    final static String internalCauseConjecture2 = 
	"is a possible consequence of a previous disease.";
    final static String previousDisease = "and is a disease you had earlier.";
    final static String iterationDepth =
	"Consider typing a symptom or a body location or " +
	"restart because the iteration depth is already: ";
    final static String havingPolydipsiaAnduria =
	"Having " + polydipsiaPrintName + " and " + polyuriaPrintName + warrants;




} // end of L




