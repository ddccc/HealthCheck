// (C) OntoOO Inc 2001
package com;

public interface  DV {

  final static String CC = D.hck + "/";
  final static String CCjs = CC + "kangel.js";
  final static String srcCCjs = "src=\"" + CCjs + "\"";
  final static String SCRIPTCC = 
        "<script language=\"JavaScript\" " + srcCCjs + "> </script>";

  final static String htmlDismissOrBack =
	   "<p><form>" +
	   "<input type=\"button\" value=\"Dismiss\" onClick=\"parent.close()\" /> " +
	   "<input type=\"button\" value=\"Back\" onClick=\"history.back()\" />" +
	   "</form>";

  final static String htmlDismiss =
	   "<p><form>" +
	   "<input type=\"button\" value=\"Dismiss\" onClick=\"parent.close()\" />" +
	   "</form>";

  final static String htmlBack =
	   "<p><form>" +
	   "<input type=\"button\" value=\"Back\" onClick=\"history.back()\" />" +
	   "</form>";

  final static String scriptShowAccount =
  "<script language= \"JavaScript\"> \n " +
  "function showAccount(type, account) { \n" +
  "  showAccount2 = open( \n" +
  "    \"" + D.servletShowAccount + "?type=\"+type+\n" +
  "		                 \"&account=\"+account, \n" +
  "    \"showAccountWindow\", \n" +
  "    \"toolbar=1,resizable=1,scrollbars=1,height=300,width=600\" \n" +
  "  ); \n" +
  "} \n" +
  "</script> \n ";

  final static boolean expert = false;
  final static int maxInactiveInterval = D.maxUserInactiveInterval;

  // the maxNumberOfDisplayedDiseases applies only to the client, NOT to the CC
  final static int maxNumberOfDisplayedDiseases = 10;

  // logging & tracing stuff
  final static boolean LOGGING = false;
  final static boolean LOGGINGdiag1 = LOGGING;
  final static boolean LOGGINGdiag1a = LOGGING;
  final static boolean LOGGINGdiag1c = LOGGING;

  final static boolean TRACING = false;
  final static boolean TRACINGdiag2 = TRACING;
  final static boolean TRACINGdisplayDiseases = TRACING;

  final static int Diag1 = 0;
  final static int Diag1a = 1;
  final static int Diag1b = 2;
  final static int Diag1c = 3;
  final static int Diag2 = 4;
  final static int DisplayDiseaseInst = 5;
  final static int KChatCPersonInput = 6;
  final static int KChatCPersonTop = 7;
  final static int KChatClientInput = 8;
  final static int KChatClientTop = 9;
  final static int KChatInvitation = 10;
  final static int KChatResponse = 11;
  final static int KClientCanvas = 12; // dead code 
  final static int KClientScribe = 13;
  final static int KInvite = 14;
  final static int KUpdates = 15; // removed
  final static int ProcessWeightValue = 16;
  final static int Setup = 17; 
  final static int Transport = 18; // removed
  final static int History = 19;
  final static int ShowWeightGraph = 20;
  final static int Admin = 21;
  final static int KCPersonScribe = 22;
  final static int SendCCPerson = 23; // removed
  final static int ARW = 24; // utility program
  final static int AdminUpdate = 25;
  final static int DisplayDiseaseInstHist = 26;
  final static int DisplayDiseaseConjecturesHist = 27;
  final static int DisplayDiseaseConjInst = 28;
  final static int CheckStatus = 29;
  final static int CheckPregnancy2 = 30;
  final static int CheckMenstruating2 = 31;
  final static int CheckPremenstruating2 = 32;
  final static int CheckMenopause2 = 33;
  final static int Diag0 = 34;
  final static int SetSessionMaxInterval = 35;
  final static int KCPersonCanvas = 36;
  final static int GetBMIInput = 37;
  final static int CalcBMI = 38;
  final static int DiagAcceptDisease = 39;
  final static int DiagShow = 40;
  final static int DiagStart = 41;
  final static int SetupCC = 42;
  final static int ActorRoot = 43;
  final static int ElaborateSymptomsQ = 44;
  final static int ElaborateSymptoms = 45;
  final static int NotifyQ = 46;
  final static int SetupWoman = 47;
  final static int AssessSymptoms = 48;
  final static int Diag1cTerminate = 49;
  final static int CheckDrugEffects = 50;

  final static String [] SessionExpiredInfo = {
  "Diag1 = 0",
  "Diag1a = 1",
  "Diag1b = 2",
  "Diag1c = 3",
  "Diag2 = 4",
  "DisplayDiseaseInst = 5",
  "KChatCPersonInput = 6",
  "KChatCPersonTop = 7",
  "KChatClientInput = 8",
  "KChatClientTop = 9",
  "KChatInvitation = 10",
  "KChatResponse = 11",
  "KClientCanvas = 12", // dead code 
  "KClientScribe = 13",
  "KInvite = 14",
  "KUpdates = 15", // dead code 
  "ProcessWeightValue = 16",
  "Setup = 17", 
  "Transport = 18", // dead code 
  "History = 19",
  "ShowWeightGraph = 20",
  "Admin = 21",
  "KCPersonScribe = 22",
  "SendCCPerson = 23",  // dead code 
  "ARW = 24",  // dead code 
  "AdminUpdate = 25",
  "DisplayDiseaseInstHist = 26",
  "DisplayDiseaseConjecturesHist = 27",
  "DisplayDiseaseConjInst = 28",
  "CheckStatus = 29",
  "CheckPregnancy2 = 30",
  "CheckMenstruating2 = 31",
  "CheckPremenstruating2 = 32",
  "CheckMenopause2 = 33",
  "Diag0 = 34",
  "SetSessionMaxInterval = 35",
  "KCPersonCanvas = 36",
  "GetBMIInput = 37",
  "CalcBMI = 38",
  "DiagAcceptDisease = 39",
  "DiagShow = 40",
  "DiagStart = 41",
  "SetupCC = 42",
  "ActorRoot = 43",
  "ElaborateSymptomsQ = 44",
  "ElaborateSymptoms = 45",
  "NotifyQ = 46",
  "SetupWoman = 47",
  "AssessSymptoms = 48",
  "Diag1cTerminate = 49",
  "CheckDrugEffects = 50"
};


} // end of DV

