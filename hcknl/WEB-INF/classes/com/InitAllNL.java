// (C) OntoOO Inc 2000
package com;

import java.util.Vector;
import java.util.Collections;
import java.util.HashSet;

import concepts.*;
import init.*;

public class InitAllNL {
  public static void main(String[] args) {

    Common.resetHashTables();

    Common.createTheXWords();
    Common.setTheXWordsLoaded(true);

    // Locations
    InitAll.CreateLocations();

    // BodySystems
    System.out.println("****** InitBodySystems ...");
    InitBodySystems.doit();
    System.out.println("****** return from InitBodySystems ...");

    // Symptoms
    System.out.print("****** InitSymptoms: ");
    InitSymptoms.doit();
    String [] allSymptoms = Common.allSymptoms();
    int lng = allSymptoms.length;
    System.out.println(lng);

    Common.createTheTreatments();
    Common.setTheTreatmentsLoaded(true);
    Common.createTheDrugs();
    Common.setTheDrugsLoaded(true);
    Common.createTheTreatmentActions();
    Common.setTheTreatmentActionsLoaded(true);
    Common.createTheTreatmentConditions();
    Common.setTheTreatmentConditionsLoaded(true);

    // Abnormal Conditions
    System.out.println("****** InitAbnormalConditions ...");
    InitAbnormalConditions.doit();

    // Disease Sets
    System.out.println("****** InitDiseaseSets ...");
    InitDiseaseSets.doit();

    DiseaseSet cardioDisorders = Common.getDiseaseSet(LR.cardioDisorders);
    DiseaseSet earDisorders = Common.getDiseaseSet(LR.earDisorders);
    DiseaseSet endocrineDisorders = Common.getDiseaseSet(LR.endocrineDisorders);
    DiseaseSet eyeDisorders = Common.getDiseaseSet(LR.eyeDisorders);
    DiseaseSet immuneDisorders = Common.getDiseaseSet(LR.immuneDisorders);
    DiseaseSet infections = Common.getDiseaseSet(LR.infections);
    DiseaseSet gastrointestinalDisorders = Common.getDiseaseSet(LR.gastrointestinalDisorders);
    DiseaseSet geneticDisorders = Common.getDiseaseSet(LR.geneticDisorders);
    DiseaseSet gynecologicDisorders = Common.getDiseaseSet(LR.gynecologicDisorders);
    DiseaseSet hematologicDisorders = Common.getDiseaseSet(LR.hematologicDisorders);
    DiseaseSet hepatobiliaryDisorders = Common.getDiseaseSet(LR.hepatobiliaryDisorders);
    DiseaseSet metabolicDisorders = Common.getDiseaseSet(LR.metabolicDisorders);
    DiseaseSet musculoDisorders = Common.getDiseaseSet(LR.musculoDisorders);
    DiseaseSet neoPlasms = Common.getDiseaseSet(LR.neoPlasms);
    DiseaseSet neurologicDisorders = Common.getDiseaseSet(LR.neurologicDisorders);
    DiseaseSet noseDisorders = Common.getDiseaseSet(LR.noseDisorders);
    DiseaseSet nutritionalDisorders = Common.getDiseaseSet(LR.nutritionalDisorders);
    DiseaseSet pediatricDisorders = Common.getDiseaseSet(LR.pediatricDisorders);
    DiseaseSet psychiatricDisorders = Common.getDiseaseSet(LR.psychiatricDisorders);
    DiseaseSet renalDisorders = Common.getDiseaseSet(LR.renalDisorders);
    DiseaseSet respiratoryDisorders = Common.getDiseaseSet(LR.respiratoryDisorders);
    DiseaseSet sexualDisorders = Common.getDiseaseSet(LR.sexualDisorders);
    DiseaseSet skeletalDisorders = Common.getDiseaseSet(LR.skeletalDisorders);
    DiseaseSet skinDisorders = Common.getDiseaseSet(LR.skinDisorders);
    DiseaseSet throatDisorders = Common.getDiseaseSet(LR.throatDisorders);
    DiseaseSet traumas = Common.getDiseaseSet(LR.traumas);
    DiseaseSet urologicDisorders = Common.getDiseaseSet(LR.urologicDisorders);
    DiseaseSet vascularDisorders = Common.getDiseaseSet(LR.vascularDisorders);
    DiseaseSet respiratoryTractInfections = Common.getDiseaseSet(LR.respiratoryTractInfections);
    DiseaseSet lifeThreateningDisorders = Common.getDiseaseSet(LR.lifeThreateningDisorders);

    // set their printnames
     cardioDisorders.setPrintName(L.cardioDisordersPrintName);
     earDisorders.setPrintName(L.earDisordersPrintName);
     endocrineDisorders.setPrintName(L.endocrineDisordersPrintName);
     eyeDisorders.setPrintName(L.eyeDisordersPrintName);
     immuneDisorders.setPrintName(L.immuneDisordersPrintName);
     infections.setPrintName(L.infectionsPrintName);
     gastrointestinalDisorders.setPrintName(L.gastrointestinalDisordersPrintName);
     geneticDisorders.setPrintName(L.geneticDisordersPrintName);
     gynecologicDisorders.setPrintName(L.gynecologicDisordersPrintName);
     hematologicDisorders.setPrintName(L.hematologicDisordersPrintName);
     hepatobiliaryDisorders.setPrintName(L.hepatobiliaryDisordersPrintName);
     metabolicDisorders.setPrintName(L.metabolicDisordersPrintName);
     musculoDisorders.setPrintName(L.musculoDisordersPrintName);
     neoPlasms.setPrintName(L.neoPlasmsPrintName);
     neurologicDisorders.setPrintName(L.neurologicDisordersPrintName);
     noseDisorders.setPrintName(L.noseDisordersPrintName);
     nutritionalDisorders.setPrintName(L.nutritionalDisordersPrintName);
     pediatricDisorders.setPrintName(L.pediatricDisordersPrintName);
     psychiatricDisorders.setPrintName(L.psychiatricDisordersPrintName);
     renalDisorders.setPrintName(L.renalDisordersPrintName);
     respiratoryDisorders.setPrintName(L.respiratoryDisordersPrintName);
     sexualDisorders.setPrintName(L.sexualDisordersPrintName);
     skeletalDisorders.setPrintName(L.skeletalDisordersPrintName);
     skinDisorders.setPrintName(L.skinDisordersPrintName);
     throatDisorders.setPrintName(L.throatDisordersPrintName);
     traumas.setPrintName(L.traumasPrintName);
     urologicDisorders.setPrintName(L.urologicDisordersPrintName);
     vascularDisorders.setPrintName(L.vascularDisordersPrintName);

    // ad hoc collections 
     respiratoryTractInfections.setPrintName(L.respiratoryTractInfectionsPrintName);

     lifeThreateningDisorders.setPrintName(L.lifeThreateningDisordersPrintName);

    // Diseases
    /*
    System.out.println("****** Switch to InitDiseases ...");
    InitDiseases.doit();
    System.out.println("****** Return from InitDiseases ...");
    */
    System.out.println("****** Switch to GenDiseases2 ...");
    GenDiseases2.doit();
    System.out.println("****** Return from GenDiseases2 ...");

    // mark here the diseases that are life threatening ...
    InitAll.MarkLifeThreateningDiseases();

    // Drugs
    System.out.println("****** Switch to InitDrugs ...");
    InitDrugs.doit();
    System.out.println("****** Return from InitDrugs ...");

    // Read synonyms
    System.out.println("****** InitSynonyms ...");
    InitSynonyms.doit();
    System.out.println("****** Return from InitSynonyms ...");
    // Common.saveTheXWords();
    // System.out.println("****** Saved the XWords");
    System.out.println("////// Run AddIndices to add references ...");

    StringBuffer sb = new StringBuffer();
    InitAll.procAddIndices(sb, false);
    System.out.println(sb.toString());

    // make some diseases accessible
    InitAll.adjustSymptoms();

    // Create sets of male and female symptoms
    InitAll.CreateMaleFemaleSymptoms();

    // Create sets of male and female diseases
    InitAll.CreateMaleFemaleDiseases();

    // Create sets of male and female locations
    InitAll.CreateMaleFemaleLocations();

    // Create location hierarchy
    InitAll.CreateLocationHierarchy();
    InitAll.CreateHeadHierarchy();
    InitAll.CreateNeckHierarchy();
    InitAll.CreateChestHierarchy();
    InitAll.CreateAbdomenHierarchy();
    InitAll.CreateGenitaliaHierarchy();
    InitAll.CreateArmsHierarchy();
    InitAll.CreateLegsHierarchy();
    InitAll.CreateMiscHierarchy();

    Common.saveHashTables();


  } // end of main(...)


} // end of InitAllNL





