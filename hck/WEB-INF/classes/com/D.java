// (C) OntoOO/ Dennis de Champeaux 2003 Mar
package com;

public interface  D {

    final static int maxUserInactiveInterval = Loc.maxUserInactiveInterval;
    final static int maxEditInactiveInterval = Loc.maxEditInactiveInterval;

    final static String googleAd = Loc.googleAd;
    final static String site = Loc.site;
    // final static String site = "http://ddc:8000";
    final static String hck = Loc.hck;
    final static String applRoot2 = Loc.applRoot2;
	
    // data directories
    final static String theConceptsDir = Loc.theConceptsDir;
    final static String theLoggingDir = Loc.theLoggingDir;
    final static String theUsersDir = Loc.theUsersDir;

    final static String actors = Loc.actors;
    final static String cc = Loc.cc;
    final static String edit = Loc.edit;
    final static String htmls = Loc.htmls;
    final static String misc = Loc.misc;
    final static String patient = Loc.patient;
    final static String show = Loc.show;
    final static String su = Loc.su;
    final static String users = Loc.users;
    final static String phone = Loc.phone;

    final static String concepts = Loc.concepts;
    final static String edit2 = Loc.edit2;
    
    // applet
    final static String appletBase = Loc.appletBase;
    final static String images = Loc.images;


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    final static String fromAddress = "ddc@websina.com";
    final static String sendEmailAddress = "atlantisician@yahoo.com";

    final static String bgcolor = "khaki";

    // css
    final static String hckStyle = hck + "/hckStyle.css";
    final static String linkHckStyle = 
	"<link rel=\"stylesheet\" type=\"text/css\" href=\"" + hckStyle + "\" />";
    final static String blueStyle = hck + "/blueStyle.css";
    final static String linkBlueStyle = 
	"<link rel=\"stylesheet\" type=\"text/css\" href=\"" + blueStyle + "\" />";
    final static String greyStyle = hck + "/greyStyle.css";
    final static String linkGreyStyle = 
	"<link rel=\"stylesheet\" type=\"text/css\" href=\"" + greyStyle + "\" />";

    // favicon
    final static String favicon =
	"<link rel=\"shortcut icon\" href=\"" +	hck + "/favicon.ico\" type=\"image/x-icon\" />";

    // Js
    final static String kangelJs = hck + "/kangel.js";

    // servlet prefix
    final static String servlet = hck + "/servlet";

    // html
    // final static String AdviceMenopauseHtml = hck + "/AdviceMenopause.html";
    // final static String AdviceMenstruatingHtml = hck + "/AdviceMenstruating.html";
    // final static String AdvicePremenstruatingHtml = hck + "/AdvicePremenstruating.html";
    // final static String AngelHtml = hck + "/Angel.html";
    final static String AngelHtml = servlet + htmls + "Angel";
    // final static String AngelRootHtml = hck + "/AngelRoot.html";
    final static String AngelRootHtml = servlet + htmls + "AngelRoot";
    final static String ccloginHtml = hck + "/cclogin.html";
    final static String faqHtml = hck + "/faq.html";
    final static String GetTargetWeightHtml = hck + "/GetTargetWeight.html";
    final static String helpHtml = hck + "/help.html";
    final static String indexHtml = hck + "/index.html";
    final static String kblankHtml = hck + "/kblank.html";
    // final static String kChatClientInputHtml = hck + "/kChatClientInput.html";
    final static String kChatClientInputHtml = servlet + htmls + "KChatClientInputH";
    // final static String kChatCPersonInputHtml = hck + "/kChatCPersonInput.html";
    final static String kChatCPersonInputHtml = servlet + htmls + "KChatCPersonInputH";
    final static String kClientChatHtml = hck + "/kClientChat.html";
    final static String kCPersonChatHtml = hck + "/kCPersonChat.html";
    final static String killSessionHtml = hck + "/killSession.html";
    final static String phloginHtml = site + hck + "/phlogin.html"; // ph notification
    final static String ProgWeightHtml = hck + "/ProgWeight.html";
    final static String SendMailHtml = hck + "/SendMail.html";
    // final static String SetupAccountHtml = hck + "/SetupAccount.html";
    // final static String SetupCCAccountHtml = hck + "/SetupCCAccount.html";
    // final static String StartAnonymousHtml = hck + "/StartAnonymous.html";
    final static String startCCHtml = hck + "/startCC.html";
    final static String startHtml = hck + "/start.html";
    final static String startPHHtml = hck + "/startPH.html";
    // final static String start2Html = hck + "/start2.html";
    // final static String start3Html = hck + "/start3.html";
    final static String suloginHtml = site + hck + "/sulogin.html"; // for redirect
    final static String VisitorsHtml = site + hck + "/Visitors.html"; // for redirect

    // Directories
    final static String theDiseasesDir = theConceptsDir + "Diseases/";
    final static String theLocationsDir = theConceptsDir + "Locations/";

    final static String theNewStuffDir = theConceptsDir;
    final static String theNewACsDir = theNewStuffDir + "newACs/";
    final static String theNewBSsDir = theNewStuffDir + "newBSs/";
    final static String theNewDiseasesDir = theNewStuffDir + "newDiseases/";
    final static String theNewPartLocationsDir = theNewStuffDir + "newPartLocations/";
    final static String theNewSymptomsDir = theNewStuffDir + "newSymptoms/";

    // data files
    final static String abdomenHierarchy = theConceptsDir + "abdomenHierarchy";
    final static String allDiss = theConceptsDir + "allDiss";
    final static String allLocs = theConceptsDir + "allLocs";
    final static String armsHierarchy = theConceptsDir + "armsHierarchy";
    final static String chestHierarchy = theConceptsDir + "chestHierarchy";
    final static String commonSymptomNames = theConceptsDir + "commonSymptomNames";
    final static String femaleDiseases = theConceptsDir + "femaleDiseases";
    final static String femaleLocations = theConceptsDir + "femaleLocations";
    final static String femaleSymptoms = theConceptsDir + "femaleSymptoms";
    final static String genitaliaHierarchy = theConceptsDir + "genitaliaHierarchy";
    final static String headHierarchy = theConceptsDir + "headHierarchy";
    final static String ignoreWords = theConceptsDir + "ignoreWords";
    final static String indexWords = theConceptsDir + "indexWords";
    final static String legsHierarchy = theConceptsDir + "legsHierarchy";
    final static String locationHierarchy = theConceptsDir + "locationHierarchy";
    final static String maleDiseases = theConceptsDir + "maleDiseases";
    final static String maleLocations = theConceptsDir + "maleLocations";
    final static String maleSymptoms = theConceptsDir + "maleSymptoms";
    final static String miscHierarchy = theConceptsDir + "miscHierarchy";
    final static String neckHierarchy = theConceptsDir + "neckHierarchy";
    final static String theAbnormalConditions = theConceptsDir + "theAbnormalConditions";
    final static String theBodySystems = theConceptsDir + "theBodySystems";
    final static String theDiseaseSets = theConceptsDir + "theDiseaseSets";
    final static String theDiseasesForShow = theConceptsDir + "theDiseasesForShow";
    final static String theDrugs = theConceptsDir + "theDrugs";
    final static String theExternalCauses = theConceptsDir + "theExternalCauses";
    final static String theExternalCauseToDiseases = theConceptsDir + "theExternalCauseToDiseases"; // ???
    final static String theSymptoms = theConceptsDir + "theSymptoms";
    final static String theSymptomToDiseases = theConceptsDir + "theSymptomToDiseases"; // remove later
    final static String theTreatmentActions = theConceptsDir + "theTreatmentActions";
    final static String theTreatmentConditions = theConceptsDir + "theTreatmentConditions";
    final static String theTreatments = theConceptsDir + "theTreatments";
    final static String theXWords = theConceptsDir + "theXWords";
    final static String zInitTrace = theConceptsDir + "zInitTrace.txt";

    final static String healthAngelLogging = theLoggingDir + "healthAngelLogging";

    final static String ccccAccounts = theUsersDir + "ccccAccounts";
    final static String phphAccounts = theUsersDir + "phphAccounts";
    final static String userAccounts = theUsersDir + "userAccounts";

    // cc
    final static String servletCCLogin = servlet + cc + "CCLogin";
    final static String servletCCLogout = servlet + cc + "CCLogout";
    final static String servletKCallPerson = site + servlet + cc + "KCallPerson"; // for redirect
    final static String servletKChatCPersonInput = servlet + cc + "KChatCPersonInput";
    final static String servletKChatCPersonTop = servlet + cc + "KChatCPersonTop";
    final static String servletKChatInvitation = servlet + cc + "KChatInvitation";
    final static String servletKChatResponse = servlet + cc + "KChatResponse";
    final static String servletKCPersonCanvas = servlet + cc + "KCPersonCanvas";
    final static String servletKCPersonScribe = servlet + cc + "KCPersonScribe";
    final static String servletKDetails2 = servlet + cc + "KDetails2";
    final static String servletKDetails = servlet + cc + "KDetails";
    final static String servletKInvite = servlet + cc + "KInvite";
    final static String servletKTransfer = servlet + cc + "KTransfer";
    final static String servletSetupCC = servlet + cc + "SetupCC";

    // edit
    final static String servletAddIndices = servlet + edit + "AddIndices";
    final static String servletARW = servlet + edit + "ARW";
    final static String servletDiseaseSubsumption = servlet + edit + "DiseaseSubsumption";
    final static String servletDynamicSortSymptom = servlet + edit + "DynamicSortSymptom";
    final static String servletEditAC2 = servlet + edit + "EditAC2";
    final static String servletEditAC = servlet + edit + "EditAC";
    final static String servletEditACs = servlet + edit + "EditACs";
    final static String servletEditBS2 = servlet + edit + "EditBS2";
    final static String servletEditBS = servlet + edit + "EditBS";
    final static String servletEditBSs = servlet + edit + "EditBSs";
    final static String servletEditConnectionLocation = servlet + edit + "EditConnectionLocation";
    final static String servletEditConnectionLocations = servlet + edit + "EditConnectionLocations";
    final static String servletEditDisease2 = servlet + edit + "EditDisease2";
    final static String servletEditDisease3 = servlet + edit + "EditDisease3";
    final static String servletEditDisease = servlet + edit + "EditDisease";
    final static String servletEditDiseases0 = servlet + edit + "EditDiseases0";
    final static String servletEditDiseases = servlet + edit + "EditDiseases";
    final static String servletEditDiseasesSuper = servlet + edit + "EditDiseasesSuper";
    final static String servletEditLocationSet = servlet + edit + "EditLocationSet";
    final static String servletEditLocationSets = servlet + edit + "EditLocationSets";
    final static String servletEditPartLocation2 = servlet + edit + "EditPartLocation2";
    final static String servletEditPartLocation3 = servlet + edit + "EditPartLocation3";
    final static String servletEditPartLocation4 = servlet + edit + "EditPartLocation4";
    final static String servletEditPartLocation = servlet + edit + "EditPartLocation";
    final static String servletEditPartLocations = servlet + edit + "EditPartLocations";
    final static String servletEditSymptom2 = servlet + edit + "EditSymptom2";
    final static String servletEditSymptom = servlet + edit + "EditSymptom";
    final static String servletEditSymptoms = servlet + edit + "EditSymptoms";
    final static String servletEditTreatments2 = servlet + edit + "EditTreatments2";
    final static String servletEditTreatments = servlet + edit + "EditTreatments";
    final static String servletEditXWords2 = servlet + edit + "EditXWords2";
    final static String servletFindIndexInBodySystem = servlet + edit + "FindIndexInBodySystem";
    final static String servletFindIndexInDisease = servlet + edit + "FindIndexInDisease";
    final static String servletFindIndexInLocation = servlet + edit + "FindIndexInLocation";
    final static String servletFindIndexInSymptom = servlet + edit + "FindIndexInSymptom";
    final static String servletIncidence = servlet + edit + "Incidence";
    final static String servletIncidence2 = servlet + edit + "Incidence2";
    final static String servletIncidence3 = servlet + edit + "Incidence3";
    final static String servletManageIgnoreWords = servlet + edit + "ManageIgnoreWords";
    final static String servletManageIgnoreWords2 = servlet + edit + "ManageIgnoreWords2";
    final static String servletManageIndexWords = servlet + edit + "ManageIndexWords";
    final static String servletManageIndexWords2 = servlet + edit + "ManageIndexWords2";
    final static String servletSelectSymptoms2 = servlet + edit + "SelectSymptoms2";
    final static String servletSelectSymptoms = servlet + edit + "SelectSymptoms";
    final static String servletShowDangerousSymptoms = servlet + edit + "ShowDangerousSymptoms";
    final static String servletShowDiseaseLinks = servlet + edit + "ShowDiseaseLinks";
    final static String servletShowLocationHierarchy = servlet + edit + "ShowLocationHierarchy";
    final static String servletShowMaleDiseases = servlet + edit + "ShowMaleDiseases";
    final static String servletShowMaleSymps = servlet + edit + "ShowMaleSymps";
    final static String servletShowSympBucket = servlet + edit + "ShowSympBucket";
    final static String servletShowSympClosure2 = servlet + edit + "ShowSympClosure2";
    final static String servletShowSympClosure = servlet + edit + "ShowSympClosure";
    final static String servletShowSympClosures = servlet + edit + "ShowSympClosures";
    final static String servletShowSympStats2 = servlet + edit + "ShowSympStats2";
    final static String servletShowSympStats = servlet + edit + "ShowSympStats";
    final static String servletShowSymptomDetails = servlet + edit + "ShowSymptomDetails";
    final static String servletShowSymptomsDetails = servlet + edit + "ShowSymptomsDetails";
    final static String servletSimulation = servlet + edit + "Simulation";

    // misc
    // final static String servletSessionExpired = servlet + misc + "SessionExpired";
    final static String servletSendEmail = servlet + misc + "SendEmail";
    final static String servletChangePassword0 = servlet + misc + "ChangePassword0";
    final static String servletChangePassword = servlet + misc + "ChangePassword";
    // final static String servletHCError = servlet + users + "HCError";
    final static String servletShowAccount = servlet + misc + "ShowAccount";
    final static String servletShowUserAccount = servlet + misc + "ShowUserAccount";

    // patient
    final static String servletActorRoot = servlet + actors + "ActorRoot";
    final static String servletAdmin = servlet + patient + "Admin";
    final static String servletAdminUpdate = servlet + patient + "AdminUpdate";
    final static String servletAngelLogin = servlet + patient + "AngelLogin";
    final static String servletAssessSymptoms = servlet + patient + "AssessSymptoms";
    final static String servletCalcBMI = servlet + patient + "CalcBMI";
    final static String servletCheckDrugEffects = servlet + patient + "CheckDrugEffects";
    final static String servletCheckMenopause2 = servlet + patient + "CheckMenopause2";
    final static String servletCheckMenstruating2 = servlet + patient + "CheckMenstruating2";
    final static String servletCheckPregnancy2 = servlet + patient + "CheckPregnancy2";
    final static String servletCheckPremenstruating2 = servlet + patient + "CheckPremenstruating2";
    // final static String servletCheckStatus = servlet + patient + "CheckStatus";
    final static String servletDebug = servlet + patient + "Debug";
    final static String servletDiag1a = servlet + patient + "Diag1a";
    // final static String servletDiag1b = servlet + patient + "Diag1b";
    final static String servletDiag1c = servlet + patient + "Diag1c";
    final static String servletDiag1cTerminate = servlet + patient + "Diag1cTerminate";
    final static String servletDiag1DiseaseSubsets = servlet + patient + "Diag1DiseaseSubsets";
    final static String servletDiag1Focussed = servlet + patient + "Diag1Focussed";
    final static String servletDiag1SearchLTD = servlet + patient + "Diag1SearchLTD";
    final static String servletDiag1Subsystem = servlet + patient + "Diag1Subsystem";
    final static String servletDiag1Unrestricted = servlet + patient + "Diag1Unrestricted";
    // final static String servletDiag2 = servlet + patient + "Diag2";
    final static String servletDiag2B = servlet + patient + "Diag2B";
    final static String servletDiagAcceptDisease = servlet + patient + "DiagAcceptDisease";
    // final static String servletDiagException = servlet + patient + "DiagException";
    final static String servletDiagShow = servlet + patient + "DiagShow";
    final static String servletDiagStart = servlet + patient + "DiagStart";
    final static String servletDiagStartSymptom = servlet + patient + "DiagStartSymptom";
    final static String servletDiagStart2 = servlet + patient + "DiagStart2";
    final static String servletDisplayDiseaseConjecturesHist = servlet + patient + 
                 "DisplayDiseaseConjecturesHist";
    final static String servletDisplayDiseaseConjInst = servlet + patient + "DisplayDiseaseConjInst";
    final static String servletDisplayDiseaseInst = servlet + patient + "DisplayDiseaseInst";
    final static String servletDisplayDiseaseInstHist = servlet + patient + "DisplayDiseaseInstHist";
    final static String servletElaborateSymptoms = servlet + patient + "ElaborateSymptoms";
    final static String servletGetBMIInput = servlet + patient + "GetBMIInput";
    final static String servletHistory = servlet + patient + "History";
    final static String servletInfo = servlet + patient + "Info";
    final static String servletKChatClientInput = servlet + patient + "KChatClientInput";
    final static String servletKChatClientTop = servlet + patient + "KChatClientTop";
    final static String servletKClient = servlet + patient + "KClient";
    final static String servletKClientCanvas = servlet + patient + "KClientCanvas";
    final static String servletKClientDigest = servlet + patient + "KClientDigest";
    final static String servletKClientScribe = servlet + patient + "KClientScribe";
    final static String servletNotifyQ = servlet + patient + "NotifyQ";
    final static String servletProcessWeightValue = servlet + patient + "ProcessWeightValue";
    final static String servletSetSessionMaxInterval =
	servlet + patient + "SetSessionMaxInterval";
    final static String servletSetup = servlet + patient + "Setup";
    final static String servletSetup2 = servlet + patient + "Setup2";
    final static String servletSetup3 = servlet + patient + "Setup3";
    final static String servletSetup4 = servlet + patient + "Setup4";
    final static String servletSetupWoman = servlet + patient + "SetupWoman";
    final static String servletShowInputs = servlet + patient + "ShowInputs";
    final static String servletShowWeightGraph = servlet + patient + "ShowWeightGraph";
    final static String servletUserLogout = servlet + patient + "UserLogout";
    final static String servletUserSearch = servlet + patient + "UserSearch";

    // phone
    final static String servletAnySymptomsQ = site + servlet + phone + "AnySymptomsQ";
    final static String servletAskBodyPart = site + servlet + phone + "AskBodyPart";
    final static String servletAskLocation = site + servlet + phone + "AskLocation";
    final static String servletAskLocDrivenSymptoms = site + servlet + phone + "AskLocDrivenSymptoms";
    final static String servletAskMemberss = site + servlet + phone + "AskMembers";
    final static String servletAskMoreSymptoms = site + servlet + phone + "AskMoreSymptoms";
    final static String servletAskPart = site + servlet + phone + "AskPart";
    final static String servletAskSubsets = site + servlet + phone + "AskSubsets";
    final static String servletAskSymptom = site + servlet + phone + "AskSymptom";
    final static String servletLocationNarrowedQ = site + servlet + phone + "LocationNarrowedQ";
    final static String servletPCheckMenopause2 = site + servlet + phone + "PCheckMenopause2";
    final static String servletPCheckMenstruating2 = site + servlet + phone + "PCheckMenstruating2";
    final static String servletPCheckPregnancy2 = site + servlet + phone + "PCheckPregnancy2";
    final static String servletPCheckPremenstruating2 = site + servlet + phone + "PCheckPremenstruating2";
    final static String servletPhoneCheckStatus = site + servlet + phone + "PhoneCheckStatus";
    final static String servletPhoneError = site + servlet + phone + "PhoneError";
    final static String servletPhoneLogin = site + servlet + phone + "PhoneLogin";
    final static String servletPhoneLogout = site + servlet + phone + "PhoneLogout";
    final static String servletPhoneWait = site + servlet + phone + "PhoneWait";
    final static String servletPSetPregnant = site + servlet + phone + "PSetPregnant";
    final static String servletRefinePartQ = site + servlet + phone + "RefinePartQ";



    // show
    final static String servletDisplayBodySystem = servlet + show + "DisplayBodySystem";
    final static String servletDisplayTreatment = servlet + show + "DisplayTreatment";
    final static String servletEditXWords = servlet + show + "EditXWords"; 
    final static String servletShowAbnormalCondition = servlet + show + "ShowAbnormalCondition";
    final static String servletShowAbnormalConditions = servlet + show + "ShowAbnormalConditions";
    final static String servletShowAll = servlet + show + "ShowAll";
    final static String servletShowBodySystem = servlet + show + "ShowBodySystem";
    final static String servletShowBodySystems = servlet + show + "ShowBodySystems";
    final static String servletShowDisease = servlet + show + "ShowDisease";
    final static String servletShowDiseases = servlet + show + "ShowDiseases";
    final static String servletShowDiseaseSet = servlet + show + "ShowDiseaseSet";
    final static String servletShowDiseaseSets = servlet + show + "ShowDiseaseSets";
    final static String servletShowDrug = servlet + show + "ShowDrug";
    final static String servletShowDrugs = servlet + show + "ShowDrugs";
    final static String servletShowExternalCause = servlet + show + "ShowExternalCause";
    final static String servletShowExternalCauses = servlet + show + "ShowExternalCauses";
    final static String servletShowExternalCausesDis = servlet + show + "ShowExternalCausesDis";
    final static String servletShowHasName = servlet + show + "ShowHasName";
    final static String servletShowLocation = servlet + show + "ShowLocation";
    final static String servletShowLocations = servlet + show + "ShowLocations";
    final static String servletShowSymptom = servlet + show + "ShowSymptom";
    final static String servletShowSymptoms = servlet + show + "ShowSymptoms";
    final static String servletShowSymptomsDis = servlet + show + "ShowSymptomsDis";
    final static String servletShowXWord = servlet + show + "ShowXWord";

    // su
    final static String servletAccountQuick = servlet + su + "AccountQuick";
    final static String servletCreateAnonymousAccount = servlet + su + "CreateAnonymousAccount";
    final static String servletPHLogin2 = servlet + su + "PHLogin2";
    final static String servletPHLogout = servlet + su + "PHLogout";
    final static String servletSUAssessPatient = servlet + su + "SUAssessPatient";
    final static String servletSUCA2 = servlet + su + "SUCA2";
    final static String servletSUClearLog = servlet + su + "SUClearLog";
    final static String servletSUCreateAccount = servlet + su + "SUCreateAccount";
    final static String servletSUDeleteAccount = servlet + su + "SUDeleteAccount";
    final static String servletSUDeleteAnAccount = servlet + su + "SUDeleteAnAccount";
    final static String servletSUDeleteZeroAccounts = servlet + su + "SUDeleteZeroAccounts";
    final static String servletSUKillSession = servlet + su + "SUKillSession";
    final static String servletSULogin = servlet + su + "SULogin";
    final static String servletSULogout = servlet + su + "SULogout";
    final static String servletSURemoveSession = servlet + su + "SURemoveSession";
    // final static String servletSURoot = servlet + su + "SURoot";
    final static String servletSUShowAnAccount = servlet + su + "SUShowAnAccount";
    final static String servletSUShowChronoAccounts = servlet + su + "SUShowChronoAccounts";
    final static String servletSUShowHALogging = servlet + su + "SUShowHALogging";
    final static String servletSUShowLoggedinUsers = servlet + su + "SUShowLoggedinUsers";
    final static String servletSUShowLogger = servlet + su + "SUShowLogger";
    final static String servletSUShowUserAccounts = servlet + su + "SUShowUserAccounts";
    final static String servletSUShowZeroAccounts = servlet + su + "SUShowZeroAccounts";
    final static String servletSUtil = servlet + su + "SUtil";

    // users || moved to misc
    // final static String servletChangePassword0 = servlet + users + "ChangePassword0";
    // final static String servletChangePassword = servlet + users + "ChangePassword";
    // final static String servletHCError = servlet + users + "HCError";
    // final static String servletShowAccount = servlet + users + "ShowAccount";

    // selected class names
    final static String BoneClass = concepts + "Bone";
    final static String BoneSetClass = concepts + "BoneSet";
    final static String ConnectionLocationClass = concepts + "ConnectionLocation";
    final static String DynamicSortSymptomClass = edit2 + "DynamicSortSymptom";
    final static String LocationRelationClass = concepts + "LocationRelation";
    final static String LocationSetClass = concepts + "LocationSet";
    final static String MuscleClass = concepts + "Muscle";
    final static String MuscleSetClass = concepts + "MuscleSet";
    final static String OrganClass = concepts + "Organ";
    final static String OrganSetClass = concepts + "OrganSet";
    final static String PartLocationClass = concepts + "PartLocation";
    final static String SymptomClass = concepts + "Symptom";
    final static String TendonClass = concepts + "Tendon";
    final static String TendonSetClass = concepts + "TendonSet";
    final static String VeinClass = concepts + "Vein";
    final static String VeinSetClass = concepts + "VeinSet";
    final static String XWordNormalClass = concepts + "XWordNormal";
    final static String XWordPolishClass = concepts + "XWordPolish";

    // Images
    final static String BlackwidowGif = images + "/Blackwidow.gif";
    final static String BlackwidowJpg = images + "/Blackwidow.jpg";
    final static String ButterflyRashJpg = images + "/ButterflyRash.jpg";
    final static String ChancroidPenisUlcersJpg = images + "/ChancroidPenisUlcers.jpg";
    final static String ChancroidPenisRupturedPapuleJpg = images + "/ChancroidPenisRupturedPapule.jpg";
    final static String ChickenPoxJpg = images + "/ChickenPox.jpg";
    final static String DoctorGif = images + "/Doctor.gif";
    final static String dotGif = site + images + "/dot.gif";
    final static String dot3Gif = images + "/dot3.gif";
    final static String EndocrineSystemGif = images + "/EndocrineSystem.gif";
    final static String EpididymisGif = images + "/Epididymis.gif";
    final static String femaleJpg = images + "/female3.jpg";
    final static String FemaleOrgansGif = images + "/FemaleOrgans.gif";
    final static String GonococcalCervicitisJpg = images + "/GonococcalCervicitis.jpg";
    final static String GonococcalOphthalmiaJpg = images + "/GonococcalOphthalmia.jpg";
    final static String GonococcalUrethritisJpg = images + "/GonococcalUrethritis.jpg";
    final static String GonorrheaSkinLesion1Jpg = images + "/GonorrheaSkinLesion1.jpg";
    final static String GonorrheaSkinLesion2Jpg = images + "/GonorrheaSkinLesion2.jpg";
    final static String Heart1Gif = images + "/Heart1.gif";
    final static String Heart2Png = images + "/Heart2.png";
    final static String HerpesFemaleJpg = images + "/HerpesFemale.jpg";
    final static String HerpesFemalePrimaryJpg = images + "/HerpesFemalePrimary.jpg";
    final static String HerpesFemale4DaysLaterJpg = images + "/HerpesFemale4DaysLater.jpg";
    final static String HerpesMalePrimaryJpg = images + "/HerpesMalePrimary.jpg";
    final static String HerpesMaleRecurrentJpg = images + "/HerpesMaleRecurrent.jpg";
    final static String HerpesSimplexJpg = images + "/HerpesSimplex.jpg";
    final static String LentigoMalignaMelanomaJpg = images + "/LentigoMalignaMelanoma.jpg";
    final static String logoJpg = images + "/logo4.jpg";
    final static String mailJpg = images + "/mail.jpg";
    final static String maleJpg = images + "/male3.jpg";
    final static String PubicLiceJpg = images + "/PubicLice.jpg";
    final static String RecluseJpg = images + "/Recluse.jpg";
    final static String RecluseBiteGif = images + "/RecluseBite.gif";
    final static String ScabiesHandJpg = images + "/ScabiesHand.jpg";
    final static String ScorpionGif = images + "/Scorpion.gif";
    final static String Syphilis2CondylomaLataJpg = images + "/Syphilis2CondylomaLata.jpg";
    final static String Syphilis2RashChinJpg = images + "/Syphilis2RashChin.jpg";
    final static String Syphilis2RashHandsJpg = images + "/Syphilis2RashHands.jpg";
    final static String Syphilis2RashPapuloPustularJpg = images + "/Syphilis2RashPapuloPustular.jpg";
    final static String Syphilis2RashPapuloSquamousJpg = images + "/Syphilis2RashPapuloSquamous.jpg";
    final static String Syphilis2RashTorsoJpg = images + "/Syphilis2RashTorso.jpg";
    final static String Syphilis4CardioAortaNarrowingJpg = images + 
	              "/Syphilis4CardioAortaNarrowing.jpg";
    final static String Syphilis4GummaSerpiginousJpg = images + "/Syphilis4GummaSerpiginous.jpg";
    final static String Syphilis4GummaUlceratingJpg = images + "/Syphilis4GummaUlcerating.jpg";
    final static String Syphilis4NeuralTissueSpirochetesJpg = images + 
	              "/Syphilis4NeuralTissueSpirochetes.jpg";
    final static String SyphilisChancreAnusJpg = images + "/SyphilisChancreAnus.jpg";
    final static String SyphilisChancreChinJpg = images + "/SyphilisChancreChin.jpg";
    final static String SyphilisChancrePenisJpg = images + "/SyphilisChancrePenis.jpg";
    final static String SyphilisChancreVaginaJpg = images + "/SyphilisChancreVagina.jpg";
    final static String SyphilisChancreVagina2Jpg = images + "/SyphilisChancreVagina2.jpg";
    final static String TickGif = images + "/Tick.gif";
    final static String TrigeminalNeuralgiaGif = images + "/TrigeminalNeuralgia.gif";

    // myAlert
    final static String myAlert =
	"<script language=\"JavaScript\"> \n" +
	/* Not usable:
	"function myAlert0(ev, timeOut, txt) { \n" +
	"  // positions relative to the left top window \n" +
	"  xe = ev.clientX; \n" +
	"  ye = ev.clientY; \n" +
	"  myAlert(xe + 10, ye + 10, timeOut, txt);  \n" +
	"} \n" +
	*/
	"function myAlert(x, y, timeOut, txt) { \n" +
	"    document.getElementById('toolTipBox').style.top = y + \"px\"; \n" +
	"    document.getElementById('toolTipBox').style.left = x + \"px\"; \n" +
	"    document.getElementById('toolTipBox').innerHTML= txt; \n" +
	"    document.getElementById('toolTipBox').style.display=\"block\"; \n" +
	"    setTimeout(\"closeTT()\", timeOut); \n" +
	"} \n" +
	"function closeTT() { \n" +
	"    document.getElementById('toolTipBox').style.display=\"none\"; \n" +
	"} \n" +
	"function sloagan() {  \n" +
	"   return 'HC4M is a product of <br> " +
	       "<a href=\"#11\" name=\"11\" onClick=\"openOOWin()\">OntoOO</a>'; \n" +
	"} \n" +
	"function openOOWin() {  \n" +
	"  open('http://www.ontooo.com', 'OntoOO'); \n" +
	"} \n" +
	"</script> \n";

    // Page heading
    final static String leftHeading = 
	"<span id=\"toolTipBox\" width=\"200\"></span> \n" +
	myAlert +
	"<table width=\"100%\"> \n" +
	//	"<tr><td><img align='left' height=26 width=174 border=1 src='" + D.logoJpg + "' \n" +
	"<tr><td><img align=\"left\" height=\"24\" width=\"141\" border=\"1\" src=\"" + 
	         D.logoJpg + "\" \n" +
	// "onClick=\"alert('HC4M is a product of OntoOO.  Visit: www.ontooo.com')\"></td> \n" +
	// "        onClick=\"myAlert0(event, 7000, sloagan())\" ></td> \n" +
	"        onClick=\"myAlert(30, 30, 3000, sloagan())\" /></td> \n" +
	"<td align=\"left\"> \n" +
	"<font color=\"#1C5540\" size=\"4\"> \n" +
	"<b>";
    final static String rightHeading = 
	"</b> \n" +
	"</font> \n" +
	"</td><td align=\"right\"> \n" +
	"<input type=\"submit\" value=\"" + L.Logout + "\" /> \n" +
	"</td></tr> \n" +
	"</table> \n";

    // Logger
    final static String logger = theLoggingDir + "loggerFile";

} // end of D



