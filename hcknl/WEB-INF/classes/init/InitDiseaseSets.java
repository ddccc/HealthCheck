// (C) OntoOO Inc 2000
package init;

import com.Common;
import com.LR;
import concepts.*;

public class InitDiseaseSets {
  public static void doit() {

    Common.createTheDiseaseSets();
    Common.setTheDiseaseSetsLoaded(true);

    DiseaseSet cardioDisorders = new DiseaseSet(LR.cardioDisorders);
    DiseaseSet earDisorders = new DiseaseSet(LR.earDisorders);
    DiseaseSet endocrineDisorders = new DiseaseSet(LR.endocrineDisorders);
    DiseaseSet eyeDisorders = new DiseaseSet(LR.eyeDisorders);
    DiseaseSet immuneDisorders = new DiseaseSet(LR.immuneDisorders);
    DiseaseSet infections = new DiseaseSet(LR.infections);
    DiseaseSet gastrointestinalDisorders = new DiseaseSet(LR.gastrointestinalDisorders);
    DiseaseSet geneticDisorders = new DiseaseSet(LR.geneticDisorders);
    DiseaseSet gynecologicDisorders = new DiseaseSet(LR.gynecologicDisorders);
    DiseaseSet hematologicDisorders = new DiseaseSet(LR.hematologicDisorders);
    DiseaseSet hepatobiliaryDisorders = new DiseaseSet(LR.hepatobiliaryDisorders);
    DiseaseSet metabolicDisorders = new DiseaseSet(LR.metabolicDisorders);
    DiseaseSet musculoDisorders = new DiseaseSet(LR.musculoDisorders);
    DiseaseSet neoPlasms = new DiseaseSet(LR.neoPlasms);
    DiseaseSet neurologicDisorders = new DiseaseSet(LR.neurologicDisorders);
    DiseaseSet noseDisorders = new DiseaseSet(LR.noseDisorders);
    DiseaseSet nutritionalDisorders = new DiseaseSet(LR.nutritionalDisorders);
    DiseaseSet pediatricDisorders = new DiseaseSet(LR.pediatricDisorders);
    DiseaseSet psychiatricDisorders = new DiseaseSet(LR.psychiatricDisorders);
    DiseaseSet renalDisorders = new DiseaseSet(LR.renalDisorders);
    DiseaseSet respiratoryDisorders = new DiseaseSet(LR.respiratoryDisorders);
    DiseaseSet sexualDisorders = new DiseaseSet(LR.sexualDisorders);
    DiseaseSet skeletalDisorders = new DiseaseSet(LR.skeletalDisorders);
    DiseaseSet skinDisorders = new DiseaseSet(LR.skinDisorders);
    DiseaseSet throatDisorders = new DiseaseSet(LR.throatDisorders);
    DiseaseSet traumas = new DiseaseSet(LR.traumas);
    DiseaseSet urologicDisorders = new DiseaseSet(LR.urologicDisorders);
    DiseaseSet vascularDisorders = new DiseaseSet(LR.vascularDisorders);

    // ad hoc collections 
    DiseaseSet respiratoryTractInfections = 
      new DiseaseSet("respiratoryTractInfections"); // bronchiectasis
    respiratoryTractInfections.addDiseaseMember(LR.flu);
    respiratoryTractInfections.addDiseaseMember(LR.influenza);
    respiratoryTractInfections.addDiseaseMember(LR.measles);
    respiratoryTractInfections.addDiseaseMember(LR.pneumonia);
    respiratoryTractInfections.addDiseaseMember(LR.tuberculosis);
    respiratoryTractInfections.addDiseaseMember(LR.whoopingCough);

    DiseaseSet lifeThreateningDisorders = 
      new DiseaseSet(LR.lifeThreateningDisorders);
    lifeThreateningDisorders.addDiseaseMember(LR.appendicitis);
    lifeThreateningDisorders.addDiseaseMember(LR.appendicitis2);
    lifeThreateningDisorders.addDiseaseMember(LR.abdomenTrauma);
    lifeThreateningDisorders.addDiseaseMember(LR.adrenalCrisis);
    lifeThreateningDisorders.addDiseaseMember(LR.adultRespiratoryDistressSyndrome);
    lifeThreateningDisorders.addDiseaseMember(LR.anaphylaxis);
    lifeThreateningDisorders.addDiseaseMember(LR.anthraxInhalation);
    lifeThreateningDisorders.addDiseaseMember(LR.appendicitis);
    lifeThreateningDisorders.addDiseaseMember(LR.asphyxia);
    lifeThreateningDisorders.addDiseaseMember(LR.bleedingEsophagealVarices);
    lifeThreateningDisorders.addDiseaseMember(LR.botulism);
    lifeThreateningDisorders.addDiseaseMember(LR.brainAbscess);
    lifeThreateningDisorders.addDiseaseMember(LR.cardiacArrest);
    lifeThreateningDisorders.addDiseaseMember(LR.cardiogenicShock);
    lifeThreateningDisorders.addDiseaseMember(LR.cerebralAneurysm);
    lifeThreateningDisorders.addDiseaseMember(LR.cerebralContusion);
    lifeThreateningDisorders.addDiseaseMember(LR.cerebrovascularAccident);
    lifeThreateningDisorders.addDiseaseMember(LR.diabetesKetoacidosis);
    lifeThreateningDisorders.addDiseaseMember(LR.dissectingAbdomenAortaAneurysm);
    lifeThreateningDisorders.addDiseaseMember(LR.disseminatedIntravascularCoagulation);
    lifeThreateningDisorders.addDiseaseMember(LR.ectopicPregnancyRupture);
    lifeThreateningDisorders.addDiseaseMember(LR.electricShock);
    lifeThreateningDisorders.addDiseaseMember(LR.encephalitis);
    lifeThreateningDisorders.addDiseaseMember(LR.endocarditis);
    lifeThreateningDisorders.addDiseaseMember(LR.gasGangrene);
    lifeThreateningDisorders.addDiseaseMember(LR.giHemorrhage);
    lifeThreateningDisorders.addDiseaseMember(LR.heartFailure);
    lifeThreateningDisorders.addDiseaseMember(LR.heartFailureLeftSided);
    lifeThreateningDisorders.addDiseaseMember(LR.heartFailureRightSided);
    lifeThreateningDisorders.addDiseaseMember(LR.hypertensiveCrisis);
    lifeThreateningDisorders.addDiseaseMember(LR.hypokalemiaSevere);
    lifeThreateningDisorders.addDiseaseMember(LR.intestinalObstruction);
    lifeThreateningDisorders.addDiseaseMember(LR.legionaire);
    lifeThreateningDisorders.addDiseaseMember(LR.lungAbscess);
    lifeThreateningDisorders.addDiseaseMember(LR.meningitis);
    lifeThreateningDisorders.addDiseaseMember(LR.myocardialInfarction);
    lifeThreateningDisorders.addDiseaseMember(LR.necrotizingEnterocolitis);
    lifeThreateningDisorders.addDiseaseMember(LR.pancreatitis);
    lifeThreateningDisorders.addDiseaseMember(LR.penetratingChestWound);
    lifeThreateningDisorders.addDiseaseMember(LR.peritonitis);
    lifeThreateningDisorders.addDiseaseMember(LR.pneumoniaAcute);
    lifeThreateningDisorders.addDiseaseMember(LR.pneumothorax);
    lifeThreateningDisorders.addDiseaseMember(LR.poisoning);
    lifeThreateningDisorders.addDiseaseMember(LR.poisonousSnakeBite);
    lifeThreateningDisorders.addDiseaseMember(LR.pulmonaryEdemaAcute);
    lifeThreateningDisorders.addDiseaseMember(LR.pulmonaryEmbolism);
    lifeThreateningDisorders.addDiseaseMember(LR.rabies);
    lifeThreateningDisorders.addDiseaseMember(LR.renalFailureAcute);
    lifeThreateningDisorders.addDiseaseMember(LR.renalInfarction);
    lifeThreateningDisorders.addDiseaseMember(LR.renalVeinThrombosis);
    lifeThreateningDisorders.addDiseaseMember(LR.respiratoryAcidosis);
    lifeThreateningDisorders.addDiseaseMember(LR.respiratoryAlkalosis);
    lifeThreateningDisorders.addDiseaseMember(LR.respiratoryFailureAcute);
    lifeThreateningDisorders.addDiseaseMember(LR.septicemia);
    lifeThreateningDisorders.addDiseaseMember(LR.septicShock);
    lifeThreateningDisorders.addDiseaseMember(LR.septicShockEarlyPhase);
    lifeThreateningDisorders.addDiseaseMember(LR.septicShockLatePhase);
    lifeThreateningDisorders.addDiseaseMember(LR.sickleCellCrisis);
    lifeThreateningDisorders.addDiseaseMember(LR.skullFracture);
    lifeThreateningDisorders.addDiseaseMember(
              LR.syndromeOfInappropriateAntidiureticHormoneSecretion);
    lifeThreateningDisorders.addDiseaseMember(LR.tetanus);
    lifeThreateningDisorders.addDiseaseMember(LR.thoracicAortaAneurysm);
    lifeThreateningDisorders.addDiseaseMember(LR.tubularNecrosisAcute);
    lifeThreateningDisorders.addDiseaseMember(LR.ventricularAneurysm);
	      

  } // end of doit

} // end of InitDiseaseSets
