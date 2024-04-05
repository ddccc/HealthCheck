// (C) Dennis de Champeaux/ OntoOO  2011
package com;

import concepts.Disease;

public class Incidence {
    /*
      The functions here provide an approximation to the disease 
      diagnosis incidence rate.
      A 2-step process is used:
      -- Gender and age provide access to mortality frequencies of
      disease sets and a few individual diseases
      -- Other functions generate relative frequencies of diseases 
      that belong to a set
      Combining these frequencies gives an approximation.

      This method improves with the age of the patient:
      Age group         5-9      15-19    45-49     85-89
      Accidents         36%       49%      14%        2%
      Assaults           5        17        2         0
      Suicide            0        11        5         0
                        ---+     ---+     ---+      ---+    
      Ignore:           41        77       21         2

      Actual diseases   59        23       79        98
      Other causes      20        11       15        18
      Ratio           39/59      12/23    64/79     80/98
      Captured by
         method         66%       52%      81%       82%

      Issues:
      - Only a few sets are referred to, hence diseases not belonging to
      these sets are out of scope with this method
      - Self limiting & non-lethal diseases are out of scope
      - Unspecified mortality causes in gender-age groups are between
      11-25%
      - Frequencies for diseases belonging to a set referred to are still 
      missing (2011 Oct 10)

      Can we come up with age & gender independent frequencies for out 
      of scope diseases???
      See the 2006 file with 113 causes/

     */

    // ********************************************************
    // Disease sets and their major instances with percentages
    // ********************************************************

    // final static private float residual1 = 0.001f;
    final static private float residual1 = 0f;

    static private float geneticDisorders(String disName) {
	// More here
	return 0.001f;
    }
    static private float neoPlasms(String disName, float[] ar) {
	if ( disName.equals(LR.bladderCancer) ) return ar[0];
	if ( disName.equals(LR.breastsCancer) ) return ar[1];
	if ( disName.equals(LR.colorectalCancer) ||
	     disName.equals(LR.colorectalCancerAdvanced) ||
	     disName.equals(LR.colorectalCancerAdvancedLeftTumor) ) 
	    return ar[2];
	if ( disName.equals(LR.ovariesCancer) ||
	     disName.equals(LR.ovariesCancerEarly) ||
	     disName.equals(LR.ovariesCancerAdvanced) ) 
	    return ar[3];
	if ( disName.equals(LR.kidneyCancer) ) return ar[4];
	if ( disName.equals(LR.leukemia) ) return ar[5];
	if ( disName.equals(LR.lungCancer) ||
	     disName.equals(LR.lungCancerLargeCells) ||
	     disName.equals(LR.lungCancerSmallCells) ) return ar[6];
	if ( disName.equals(LR.malignantMelanoma) ||
	     disName.equals(LR.nodularMelanoma) ||
	     disName.equals(LR.superficialSpreadingMelanoma) ||
	     disName.equals(LR.lentigoMalignaMelanoma) ) return ar[7];
	if ( disName.equals(LR.malignantLymphomas ) ) return ar[8];
	if ( disName.equals(LR.pancreasCancer) ) return ar[9];
	if ( disName.equals(LR.prostateCancer) ) return ar[10];
	if ( disName.equals(LR.stomachCancer) ||
	     disName.equals(LR.stomachCancerAdvanced) ) return ar[11];
	/*
	  # cancers above = 12
	  # cancers = 35 (in the professional guide).
	  # balance = 23
	  assume that the balance takes 20% of the cases and that the 23 
          members are equally likely.  THUS:
	return 0.2f/23;
	*/
	return 0f;
    }
    static private float cardioDisorders(String disName) {
	// if ( disName.equals(LR.hypertension) ) return 1f/3;
	// More here
	return 0.001f;
    }
    static private float perinatalDisorders(String disName) {
	// More here
	return 0.001f;
    }
    static private float respiratoryDisorders(String disName) {
	// More here
	return 0.001f;
    }
    static private float neurologicDisorders(String disName) {
	// limited to cerebrovasular ?????
	// More here
	return 0.001f;
    }

    // ****************************************
    // incidence calculation - separate gender
    // ****************************************
    static public float incidence(String gender, int age, String disName) {
	// if ( 25 <= age && disName.equals(LR.hypertension) ) return 1f/3;

	Disease dis = Common.getDisease(disName);
	if ( gender.equals(LR.male) ) 
	    return incidenceMale(age, dis);
	else 
	    return incidenceFemale(age, dis);
    }
    // ****************************************
    // incidence male - separate age regions
    // ****************************************
    static private float incidenceMale(int age, Disease dis) {
	String set = dis.getDiseaseSet();
	if ( age < 1 ) return incidenceMale0(dis, set); 
	if ( age < 5 ) return incidenceMale1(dis, set); 
	if ( age < 10 ) return incidenceMale5(dis, set); 
	if ( age < 15 ) return incidenceMale10(dis, set); 
	if ( age < 20 ) return incidenceMale15(dis, set); 
	if ( age < 25 ) return incidenceMale20(dis, set); 
	if ( age < 30 ) return incidenceMale25(dis, set); 
	if ( age < 35 ) return incidenceMale30(dis, set); 
	if ( age < 40 ) return incidenceMale35(dis, set); 
	if ( age < 45 ) return incidenceMale40(dis, set); 
	if ( age < 50 ) return incidenceMale45(dis, set); 
	if ( age < 55 ) return incidenceMale50(dis, set); 
	if ( age < 60 ) return incidenceMale55(dis, set); 
	if ( age < 65 ) return incidenceMale60(dis, set); 
	if ( age < 70 ) return incidenceMale65(dis, set); 
	if ( age < 75 ) return incidenceMale70(dis, set); 
	if ( age < 80 ) return incidenceMale75(dis, set); 
	if ( age < 85 ) return incidenceMale80(dis, set); 
	if ( age < 90 ) return incidenceMale85(dis, set); 
	if ( age < 95 ) return incidenceMale90(dis, set); 
	if ( age < 100 ) return incidenceMale95(dis, set);
	return incidenceMale100(dis, set); 
    } // end incidenceMale(int age, Disease dis)

    // # cancer deaths 2000-2004, from:
    // SEER Cancer Statistics 1975-2004  National Cancer Institute 


    static private float incidenceMale0(Disease dis, String set) {
	// < 1 year
	// More here
	return 0.001f;
    }
    static private float incidenceMale1(Disease dis, String set) {
	// 1-4 year
	String disName = dis.getName();
	final float allCauses = 2634.0f - (987 + 213 + 9);

	final int septicemia = 44; // member of infections 
	if ( disName.equals(LR.septicemia) ) return septicemia/allCauses;

	final int influenzaPlusPneumonia = 55; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/ allCauses; // divided by two?
	final int nephroticSyndrome = 11;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int meningitis = 11;
	if ( disName.equals(LR.meningitis) ) return meningitis/allCauses;
	final int cerebrovascularAccident = 20;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	final float geneticDisordersFrac = 286/allCauses;
	final float neoPlasmsFrac = (191+28)/allCauses;
	final float cardioDisordersFrac = 82/allCauses;
	final float perinatalDisordersFrac = 34/allCauses;
	final float respiratoryDisordersFrac = 30/allCauses;
	// final float neurologicDisordersFrac = 20/allCauses;
	final float residualFrac = 626/allCauses;

	if ( set.equals(LR.geneticDisorders) )
	    return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.001f;
	    final float[] ar = new float[]
		{ 0f,                       // bladder
		  0f,                       // breast
		  0f,                       // colorectal
		  0f,                       // ovary
		  0.001f*60578f/x,          // kidney
		  0.008f*107590f/x,         // leukemia
		  0f,                       // lung+bronchus
		  0f,                       // melanoma
		  0.001f*109357f/x,         // malignantLymphomas
		  0f,                       // pancreas
		  0f,                       // prostate
		  0f                        // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.perinatalDisorders) )
	    return perinatalDisordersFrac * perinatalDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
	    return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
	//     return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 1-4

    static private float incidenceMale5(Disease dis, String set) {
	// 5-9 year
	String disName = dis.getName();
	final float allCauses = 1519.0f - (572 + 66) ;

	final int septicemia = 24; // member of infections 
	if ( disName.equals(LR.septicemia) ) return septicemia/allCauses;

	final int influenzaPlusPneumonia = 25; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/ allCauses; // divided by two?
	final int nephroticSyndrome = 8;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	if ( disName.equals(LR.meningitis) ) return 0.0083f; // interpolatiion
	final int anemia = 8;
	if ( disName.equals(LR.anemiaFolicAcidDeficiency) ) return anemia/allCauses;
	final int diabetesMellitus = 6;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cerebrovascularAccident = 17;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	final float geneticDisordersFrac = 97/allCauses;
	final float neoPlasmsFrac = (255+21)/allCauses;
	final float cardioDisordersFrac = 63/allCauses;
	final float respiratoryDisordersFrac = 36/allCauses;
	// final float neurologicDisordersFrac = 17/allCauses;
	final float residualFrac = 310/allCauses;

	if ( set.equals(LR.geneticDisorders) )
	    return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.001f;
	    final float[] ar = new float[]
		{ 0f,                       // bladder
		  0f,                       // breast
		  0f,                       // colorectal
		  0f,                       // ovary
		  0.001f*60578f/x,          // kidney
		  0.008f*107590f/x,         // leukemia
		  0f,                       // lung+bronchus
		  0f,                       // melanoma
		  0.0008f*109357f/x,         // malignantLymphomas
		  0f,                       // pancreas
		  0f,                       // prostate
		  0f                        // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
	    return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
	//    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 5-9

    static private float incidenceMale10(Disease dis, String set) {
	// 10-14 year
	String disName = dis.getName();
	final float allCauses = 2066.0f - (774 + 144 + 128);

	final int septicemia = 21; // member of infections 
	if ( disName.equals(LR.septicemia) ) return septicemia/allCauses;
	final int pneumoniaAspiration = 10;
	if ( disName.equals(LR. pneumoniaAspiration) ) 
	    return  pneumoniaAspiration/allCauses;
	final int influenzaPlusPneumonia = 27; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/ allCauses; // divided by two?
	if ( disName.equals(LR.nephroticSyndrome) ) // by interpolation
	    return 0.01f;
	final int anemia = 13;
	if ( disName.equals(LR.anemiaFolicAcidDeficiency) ) 
	    return anemia/allCauses;
	final int meningitis = 9;
	if ( disName.equals(LR.meningitis) ) return meningitis/allCauses;
	final int cerebrovascularAccident = 20;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	final float geneticDisordersFrac = 97/allCauses;
	final float neoPlasmsFrac = (244+26)/allCauses;
	final float cardioDisordersFrac = 70/allCauses;
	final float perinatalDisordersFrac = 8/allCauses;
	final float respiratoryDisordersFrac = 42/allCauses;
	// final float neurologicDisordersFrac = 20/allCauses;
	final float residualFrac = 433/allCauses;

	if ( set.equals(LR.geneticDisorders) )
	    return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.001f;
	    final float[] ar = new float[]
		{ 0f,                       // bladder
		  0f,                       // breast
		  0f,                       // colorectal
		  0f,                       // ovary
		  0.001f*60578f/x,          // kidney
		  0.008f*107590f/x,         // leukemia
		  0f,                       // lung+bronchus
		  0f,                       // melanoma
		  0.0012f*109357f/x,         // malignantLymphomas
		  0f,                       // pancreas
		  0f,                       // prostate
		  0f                        // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.perinatalDisorders) )
	    return perinatalDisordersFrac * perinatalDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
	    return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //     return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 10-14

    static private float incidenceMale15(Disease dis, String set) {
	// 15-19 year
	String disName = dis.getName();
	final float allCauses = 9558.0f - (4542 + 1932 + 1221 + 24);

	final int septicemia = 24; // member of infections 
	if ( disName.equals(LR.septicemia) ) return septicemia/allCauses; 

	final int influenzaPlusPneumonia = 23; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/ allCauses; // divided by two?
	if ( disName.equals(LR.nephroticSyndrome) ) // by interpolation
	    return 0.01f;
	final int anemia = 15;
	if ( disName.equals(LR.anemiaFolicAcidDeficiency) ) 
	    return anemia/allCauses;
	final int diabetesMellitus = 31;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int aids = 14;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int cerebrovascularAccident = 40;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;


	final float geneticDisordersFrac = 113/allCauses;
	final float neoPlasmsFrac = (395+16)/allCauses;
	final float cardioDisordersFrac = 230/allCauses;
	final float respiratoryDisordersFrac = 43/allCauses;
	// final float neurologicDisordersFrac = 40/allCauses;
	final float residualFrac = 895/allCauses;

	if ( set.equals(LR.geneticDisorders) )
	    return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.001f;
	    final float[] ar = new float[]
		{ 0f,                       // bladder
		  0f,                       // breast
		  0f,                       // colorectal
		  0f,                       // ovary
		  0.001f*60578f/x,          // kidney
		  0.008f*107590f/x,         // leukemia
		  0f,                       // lung+bronchus
		  0.001f*38245f/x,          // melanoma
		  0.002f*109357f/x,         // malignantLymphomas
		  0f,                       // pancreas
		  0f,                       // prostate
		  0f                        // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
	    return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 15-19

    static private float incidenceMale20(Disease dis, String set) {
	// 20-24 year
	String disName = dis.getName();
	final float allCauses = 15758.0f - (7363 + 2897 + 2260 + 70);

	final int septicemia = 61; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;

	final int influenzaPlusPneumonia = 68; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int aids = 74;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int diabetesMellitus = 67;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int anemia = 34; 
	if ( disName.equals(LR.anemiaFolicAcidDeficiency) ) 
	    return anemia/allCauses;
	final int nephroticSyndrome = 34;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int cerebrovascularAccident = 73;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	final float geneticDisordersFrac = 128/allCauses;
	final float neoPlasmsFrac = (592+0)/allCauses;
	final float cardioDisordersFrac = 470/allCauses;
	final float respiratoryDisordersFrac = 53/allCauses;
	// final float neurologicDisordersFrac = 73/allCauses;
	final float residualFrac = 1514/allCauses;

	if ( set.equals(LR.geneticDisorders) )
	    return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.003f;
	    final float[] ar = new float[]
		{ 0.000f*62367f/x,    // bladder
		  0f,                 // breast
		  0.002f*280208f/x,   // colorectal
		  0f,                 // ovary
		  0.001f*60578f/x,    // kidney
		  0.008f*107590f/x,   // leukemia
		  0.000f*450375f*2/x, // lung+bronchus
		  0.007f*38245f/x,    // melanoma
		  0.007f*109357f/x,   // malignantLymphomas
		  0.000f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.004f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 20-24

    static private float incidenceMale25(Disease dis, String set) {
	// 25-29 year
	String disName = dis.getName();
	final float allCauses = 15107.0f - (6246 + 2306 + 2190 + 71);

	final int septicemia = 66; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 90; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int aids = 245;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int diabetesMellitus = 123;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 68;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 56;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int cerebrovascularAccident = 90;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	final float geneticDisordersFrac = 134/allCauses;
	final float neoPlasmsFrac = (715+0)/allCauses;
	final float cardioDisordersFrac = 847/allCauses;
	final float respiratoryDisordersFrac = 76/allCauses;
	// final float neurologicDisordersFrac = 90/allCauses;
	final float residualFrac = 1784/allCauses;

	if ( set.equals(LR.geneticDisorders) )
	    return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.003f;
	    final float[] ar = new float[]
		{ 0.000f*62367f/x,    // bladder
		  0f,                 // breast
		  0.002f*280208f/x,   // colorectal
		  0f,                 // ovary
		  0.002f*60578f/x,    // kidney
		  0.008f*107590f/x,   // leukemia 
		  0.000f*450375f*2/x, // lung+bronchus
		  0.010f*38245f/x,    // melanoma
		  0.005f*109357f/x,   // malignantLymphomas
		  0.001f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.004f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 25-29

    static private float incidenceMale30(Disease dis, String set) {
	// 30-34 year
	String disName = dis.getName();
	final float allCauses = 14685.0f - (5138 + 2091 + 1713 + 55);

	final int septicemia = 87; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 97; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int aids = 408;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int diabetesMellitus = 236;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 193;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 85;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int cerebrovascularAccident = 162;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	final float geneticDisordersFrac = 109/allCauses;
	final float neoPlasmsFrac = (977+0)/allCauses;
	final float cardioDisordersFrac = 1330/allCauses;
	final float respiratoryDisordersFrac = 74/allCauses;
	// final float neurologicDisordersFrac = 162/allCauses;
	final float residualFrac = 1930/allCauses;

	if ( set.equals(LR.geneticDisorders) )
	    return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.003f;
	    final float[] ar = new float[]
		{ 0.001f*62367f/x,    // bladder
		  0f,                 // breast
		  0.002f*280208f/x,   // colorectal
		  0f,                 // ovary
		  0.002f*60578f/x,    // kidney
		  0.008f*107590f/x,   // leukemia 
		  0.001f*450375f*2/x, // lung+bronchus
		  0.012f*38245f/x,    // melanoma
		  0.005f*109357f/x,   // malignantLymphomas
		  0.001f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.004f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //     return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 30-34

    static private float incidenceMale35(Disease dis, String set) {
	// 35-39 year
	String disName = dis.getName();
	final float allCauses = 19755.0f - (5582 + 2360 + 1254);

	final int septicemia = 169; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 154; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int aids = 923;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int diabetesMellitus = 479;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 492;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 151;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int thoracicAortaAneurysm = 110;
	if ( disName.equals(LR.thoracicAortaAneurysm) ) 
	    return thoracicAortaAneurysm/allCauses;
	final int cerebrovascularAccident = 401;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	final float geneticDisordersFrac = 119/allCauses;
	final float neoPlasmsFrac = (1757+0)/allCauses;
	final float cardioDisordersFrac = 2704/allCauses;
	final float respiratoryDisordersFrac = 108/allCauses;
	// final float neurologicDisordersFrac = 401/allCauses;
	final float residualFrac = 2992/allCauses;

	if ( set.equals(LR.geneticDisorders) )
            return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.0145f;
	    final float[] ar = new float[]
		{ 0.004f*62367f/x,    // bladder
		  0f,                 // breast
		  0.013f*280208f/x,   // colorectal
		  0f,                 // ovary
		  0.011f*60578f/x,    // kidney
		  0.022f*107590f/x,   // leukemia 
		  0.007f*450375f*2/x, // lung+bronchus
		  0.045f*38245f/x,    // melanoma
		  0.016f*109357f/x,   // malignantLymphomas
		  0.007f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.020f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //     return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 35-39

    static private float incidenceMale40(Disease dis, String set) {
	// 40-44 year
	String disName = dis.getName();
	final float allCauses = 30350.0f - (6440 + 2792 + 1035);

	final int septicemia = 294; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 289; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int aids = 1583;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int diabetesMellitus = 749;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 1230;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 277;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	if ( disName.equals(LR.thoracicAortaAneurysm) ) // by interpolation
	    return 0.009f;
	final int hepatitisViral = 239;
	if ( disName.equals(LR.hepatitisViral) ||
	     disName.equals(LR.hepatitisJaundice) ||
	     disName.equals(LR.hepatitisProdromal) ) 
	    return hepatitisViral/allCauses;
	final int renalFailureAcute = 170; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int cerebrovascularAccident = 742;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 119/allCauses;
	final float neoPlasmsFrac = (3994+0)/allCauses;
	final float cardioDisordersFrac = 5641/allCauses;
	final float respiratoryDisordersFrac = 284/allCauses;
	// final float neurologicDisordersFrac = 742/allCauses;
	final float residualFrac = 4641/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
        //     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.0145f;
 	    final float[] ar = new float[]
		{ 0.005f*62367f/x,    // bladder
		  0f,                 // breast
		  0.013f*280208f/x,   // colorectal
		  0f,                 // ovary
		  0.015f*60578f/x,    // kidney
		  0.014f*107590f/x,   // leukemia 
		  0.009f*450375f*2/x, // lung+bronchus
		  0.032f*38245f/x,    // melanoma
		  0.015f*109357f/x,   // malignantLymphomas
		  0.011f*151944f/x,   // pancreas
		  0.001f*150799f*2/x, // prostate
		  0.018f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //     return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 40-44

    static private float incidenceMale45(Disease dis, String set) {
	// 45-49 year
	String disName = dis.getName();
	final float allCauses = 47904.0f -(7369 + 3043 + 881);

	final int septicemia = 540; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 466; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int aids = 1624;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int diabetesMellitus = 1376;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 2429;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int hepatitisViral = 712;
	if ( disName.equals(LR.hepatitisViral) ||
	     disName.equals(LR.hepatitisJaundice) ||
	     disName.equals(LR.hepatitisProdromal) ) 
	    return hepatitisViral/allCauses;
	final int nephroticSyndrome = 485;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	if ( disName.equals(LR.thoracicAortaAneurysm) ) // by interpolation
	    return 0.008f;
	final int renalFailureAcute = 271; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int cerebrovascularAccident = 1410;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (8901+0)/allCauses;
	final float cardioDisordersFrac = 10624/allCauses;
	final float respiratoryDisordersFrac = 703/allCauses;
	// final float neurologicDisordersFrac = 1410/allCauses;
	final float residualFrac = 7070/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.0445f;
	    final float[] ar = new float[]
		{ 0.018f*62367f/x,    // bladder
		  0f,                 // breast
		  0.040f*280208f/x,   // colorectal
		  0f,                 // ovary
		  0.049f*60578f/x,    // kidney
		  0.032f*107590f/x,   // leukemia 
		  0.036f*450375f*2/x, // lung+bronchus
		  0.078f*38245f/x,    // melanoma
		  0.037f*109357f/x,   // malignantLymphomas
		  0.036f*151944f/x,   // pancreas
		  0.003f*150799f*2/x, // prostate
		  0.048f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 45-49

    static private float incidenceMale50(Disease dis, String set) {
	// 50-54 year
	String disName = dis.getName();
	final float allCauses = 66552.0f -(6648 + 2781 + 691);

	final int septicemia = 765; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 660; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int aids = 1404;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int diabetesMellitus = 2137;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 3359;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int hepatitisViral = 1285;
	if ( disName.equals(LR.hepatitisViral) ||
	     disName.equals(LR.hepatitisJaundice) ||
	     disName.equals(LR.hepatitisProdromal) ) 
	    return hepatitisViral/allCauses;
	final int nephroticSyndrome = 775;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	if ( disName.equals(LR.thoracicAortaAneurysm) ) // by interpolation
	    return 0.007f;
	final int renalFailureAcute = 489; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int cerebrovascularAccident = 2097;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (16469+0)/allCauses;
	final float cardioDisordersFrac = 16287/allCauses;
	final float respiratoryDisordersFrac = 1422/allCauses;
	// final float neurologicDisordersFrac = 2097/allCauses;
	final float residualFrac = 9283/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.0445f;
	    final float[] ar = new float[]
		{ 0.022f*62367f/x,    // bladder
		  0f,                 // breast
		  0.047f*280208f/x,   // colorectal
		  0f,                 // ovary
		  0.055f*60578f/x,    // kidney
		  0.034f*107590f/x,   // leukemia 
		  0.044f*450375f*2/x, // lung+bronchus
		  0.076f*38245f/x,    // melanoma
		  0.037f*109357f/x,   // malignantLymphomas
		  0.046f*151944f/x,   // pancreas
		  0.010f*150799f*2/x, // prostate
		  0.045f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 50-54

    static private float incidenceMale55(Disease dis, String set) {
	// 55-59 year
	String disName = dis.getName();
	final float allCauses = 81590.0f -(4944 + 2212 + 453);

	final int septicemia = 1051; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 834; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int aids = 840;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int diabetesMellitus = 3042;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 3278;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 1110;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int hepatitisViral = 1227;
	if ( disName.equals(LR.hepatitisViral) ||
	     disName.equals(LR.hepatitisJaundice) ||
	     disName.equals(LR.hepatitisProdromal) ) 
	    return hepatitisViral/allCauses;
	final int renalFailureAcute = 577; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int thoracicAortaAneurysm = 453;
	if ( disName.equals(LR.thoracicAortaAneurysm) ) 
	    return thoracicAortaAneurysm/allCauses;
	final int cerebrovascularAccident = 2757;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (24740+0)/allCauses;
	final float cardioDisordersFrac = 21227/allCauses;
	final float respiratoryDisordersFrac = 2478/allCauses;
	// final float neurologicDisordersFrac = 2757/allCauses;
	final float residualFrac = 10367/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.084f;
	    final float[] ar = new float[]
		{ 0.050f*62367f/x,    // bladder
		  0f,                 // breast
		  0.085f*280208f/x,   // colorectal
		  0f,                 // ovary
		  0.100f*60578f/x,    // kidney
		  0.055f*107590f/x,   // leukemia 
		  0.095f*450375f*2/x, // lung+bronchus
		  0.090f*38245f/x,    // melanoma
		  0.069f*109357f/x,   // malignantLymphomas
		  0.080f*151944f/x,   // pancreas
		  0.026f*150799f*2/x, // prostate
		  0.075f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //     return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 55-59

   static private float incidenceMale60(Disease dis, String set) {
	// 60-64 year
	String disName = dis.getName();
	final float allCauses = 92028.0f - (3413 + 1614);

	final int septicemia = 1152; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 1047; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int aids = 504;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int diabetesMellitus = 3602;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 2454;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 1368;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int hepatitisViral = 534;
	if ( disName.equals(LR.hepatitisViral) ||
	     disName.equals(LR.hepatitisJaundice) ||
	     disName.equals(LR.hepatitisProdromal) ) 
	    return hepatitisViral/allCauses;
	final int renalFailureAcute = 696; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int thoracicAortaAneurysm = 640;
	if ( disName.equals(LR.thoracicAortaAneurysm) ) 
	    return thoracicAortaAneurysm/allCauses;
	final int cerebrovascularAccident = 3235;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (31819+0)/allCauses;
	final float cardioDisordersFrac = 24331/allCauses;
	final float respiratoryDisordersFrac = 4255/allCauses;
	// final float neurologicDisordersFrac = 3235/allCauses;
	final float residualFrac = 11364/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.084f;
	    final float[] ar = new float[]
		{ 0.056f*62367f/x,    // bladder
		  0f,                 // breast
		  0.085f*280208f/x,   // colorectal
		  0f,                 // ovary
		  0.096f*60578f/x,    // kidney
		  0.065f*107590f/x,   // leukemia 
		  0.107f*450375f*2/x, // lung+bronchus
		  0.095f*38245f/x,    // melanoma
		  0.070f*109357f/x,   // malignantLymphomas
		  0.090f*151944f/x,   // pancreas
		  0.040f*150799f*2/x, // prostate
		  0.075f*61131f/x     // stomach
		};
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
   } // male 60-64

    static private float incidenceMale65(Disease dis, String set) {
	// 65-69 year
	String disName = dis.getName();
	final float allCauses = 100492.0f - (2749 + 1125);

	final int septicemia = 1442; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 1232; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int diabetesMellitus = 3914;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 1809;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 1693;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int thoracicAortaAneurysm = 751;
	if ( disName.equals(LR.thoracicAortaAneurysm) ) 
	    return thoracicAortaAneurysm/allCauses;
	final int renalFailureAcute = 735; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int parkinson = 474;
	if ( disName.equals(LR.parkinson) ) return parkinson/allCauses;
	final int cerebrovascularAccident = 3978;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;


	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (36166+583)/allCauses;
	final float cardioDisordersFrac = 25585/allCauses;
	final float respiratoryDisordersFrac = 6207/allCauses;
	// final float neurologicDisordersFrac = 3978/allCauses;
	final float residualFrac = 12049/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.13f;
	    final float[] ar = new float[]
		{ 0.100f*62367f/x,    // bladder
		  0f,                 // breast
		  0.137f*280208f/x,   // colorectal
		  0f,                 // ovary
		  0.130f*60578f/x,    // kidney
		  0.100f*107590f/x,   // leukemia
		  0.160f*450375f*2/x, // lung+bronchus
		  0.100f*38245f/x,    // melanoma
		  0.100f*109357f/x,   // malignantLymphomas
		  0.134f*151944f/x,   // pancreas
		  0.080f*150799f*2/x, // prostate
		  0.118f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 65-69

   static private float incidenceMale70(Disease dis, String set) {
	// 70-74 year
	String disName = dis.getName();
	final float allCauses = 117852.0f - (2844 + 878);

	final int septicemia = 1814; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 1812; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int diabetesMellitus = 4365;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 1410;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 2351;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int thoracicAortaAneurysm = 947;
	if ( disName.equals(LR.thoracicAortaAneurysm) ) 
	    return thoracicAortaAneurysm/allCauses;
	final int renalFailureAcute = 866; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int parkinson = 1033;
	if ( disName.equals(LR.parkinson) ) return parkinson/allCauses;
	final int alzheimer = 1221;
	if ( disName.equals(LR.alzheimer) ||
	     disName.equals(LR.alzheimer1) ||
	     disName.equals(LR.alzheimer2) ||
	     disName.equals(LR.alzheimer3) ) return alzheimer/allCauses;
	final int cerebrovascularAccident = 5373;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (39758+0)/allCauses;
	final float cardioDisordersFrac = 29947/allCauses;
	final float respiratoryDisordersFrac = 8472/allCauses;
	// final float neurologicDisordersFrac = 5373/allCauses;
	final float residualFrac = 14761/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.13f;
	    final float[] ar = new float[]
		{ 0.126f*62367f/x,    // bladder
		  0f,                 // breast
		  0.130f*280208f/x,   // colorectal
		  0f,                 // ovary
		  0.130f*60578f/x,    // kidney
		  0.125f*107590f/x,   // leukemia
		  0.171f*450375f*2/x, // lung+bronchus
		  0.116f*38245f/x,    // melanoma
		  0.137f*109357f/x,   // malignantLymphomas
		  0.134f*151944f/x,   // pancreas
		  0.128f*150799f*2/x, // prostate
		  0.118f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 70-74

    static private float incidenceMale75(Disease dis, String set) {
	// 75-79 year
	String disName = dis.getName();
	final float allCauses = 149669.0f - (3305);

	final int septicemia = 2200; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int pneumoniaAspiration = 1125;
	if ( disName.equals(LR. pneumoniaAspiration) ) 
	    return  pneumoniaAspiration/allCauses;
	final int influenzaPlusPneumonia = 2955; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int diabetesMellitus = 4841;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 1186;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 3253;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	if ( disName.equals(LR.thoracicAortaAneurysm) ) // by interpolation
	    return 0.0077f;
	final int alzheimer = 2949;
	if ( disName.equals(LR.alzheimer) ||
	     disName.equals(LR.alzheimer1) ||
	     disName.equals(LR.alzheimer2) ||
	     disName.equals(LR.alzheimer3) ) return alzheimer/allCauses;
	final int parkinson = 2323;
	if ( disName.equals(LR.parkinson) ) return parkinson/allCauses;
	final int renalFailureAcute = 1194; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int cerebrovascularAccident = 7868;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;


	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (44488+1161)/allCauses;
	final float cardioDisordersFrac = 39346/allCauses;
	final float respiratoryDisordersFrac = 11303/allCauses;
	// final float neurologicDisordersFrac = 7868/allCauses;
	final float residualFrac = 20172/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.15f;
	    final float[] ar = new float[]
		{ 0.175f*62367f/x,    // bladder
		  0f,                 // breast
		  0.150f*280208f/x,   // colorectal
		  0f,                 // ovary
		  0.150f*60578f/x,    // kidney
		  0.180f*107590f/x,   // leukemia
		  0.180f*450375f*2/x, // lung+bronchus
		  0.140f*38245f/x,    // melanoma
		  0.180f*109357f/x,   // malignantLymphomas
		  0.170f*151944f/x,   // pancreas
		  0.185f*150799f*2/x, // prostate
		  0.149f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 75-79

    static private float incidenceMale80(Disease dis, String set) {
	// 80-84 year
	String disName = dis.getName();
	final float allCauses = 171134.0f - (3963);

	final int septicemia = 2568; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int pneumoniaAspiration = 1801;
	if ( disName.equals(LR. pneumoniaAspiration) ) 
	    return  pneumoniaAspiration/allCauses;
	final int influenzaPlusPneumonia = 4457; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int diabetesMellitus = 5033;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	// final int cirrhosis = 1186;
	// if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 4182;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int alzheimer = 5301;
	if ( disName.equals(LR.alzheimer) ||
	     disName.equals(LR.alzheimer1) ||
	     disName.equals(LR.alzheimer2) ||
	     disName.equals(LR.alzheimer3) ) return alzheimer/allCauses;
	final int parkinson = 3371;
	if ( disName.equals(LR.parkinson) ) return parkinson/allCauses;
	final int renalFailureAcute = 1473; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int thoracicAortaAneurysm = 1222;
	if ( disName.equals(LR.thoracicAortaAneurysm) ) 
	    return thoracicAortaAneurysm/allCauses;
	final int cerebrovascularAccident = 9832;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (41439+1409)/allCauses;
	final float cardioDisordersFrac = 48659/allCauses;
	final float respiratoryDisordersFrac = 12136/allCauses;
	// final float neurologicDisordersFrac = 9832/allCauses;
	final float residualFrac = 24288/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.15f;
	    final float[] ar = new float[]
		{ 0.196f*62367f/x,    // bladder
		  0f,                 // breast
		  0.154f*280208f/x,   // colorectal
		  0f,                 // ovary
		  0.129f*60578f/x,    // kidney
		  0.136f*107590f/x,   // leukemia
		  0.116f*450375f*2/x, // lung+bronchus
		  0.091f*38245f/x,    // melanoma
		  0.154f*109357f/x,   // malignantLymphomas
		  0.145f*151944f/x,   // pancreas
		  0.233f*150799f*2/x, // prostate
		  0.149f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 80-84

    static private float incidenceMale85(Disease dis, String set) {
	// 85-89
	String disName = dis.getName();
	final float allCauses = 146114.0f - 3655;

	final int septicemia = 2064; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int pneumoniaAspiration = 2121;
	if ( disName.equals(LR. pneumoniaAspiration) ) 
	    return  pneumoniaAspiration/allCauses;
	final int influenzaPlusPneumonia = 4876; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int diabetesMellitus = 3620;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	// final int cirrhosis = 3335;
	// if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 3853;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int alzheimer = 6324;
	if ( disName.equals(LR.alzheimer) ||
	     disName.equals(LR.alzheimer1) ||
	     disName.equals(LR.alzheimer2) ||
	     disName.equals(LR.alzheimer3) ) return alzheimer/allCauses;
	final int parkinson = 2720;
	if ( disName.equals(LR.parkinson) ) return parkinson/allCauses;
	final int renalFailureAcute = 1486; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int thoracicAortaAneurysm = 937;
	if ( disName.equals(LR.thoracicAortaAneurysm) ) 
	    return thoracicAortaAneurysm/allCauses;
	final int cerebrovascularAccident = 9423;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (27005+1055)/allCauses;
	final float cardioDisordersFrac = 45558/allCauses;
	final float respiratoryDisordersFrac = 8729/allCauses;
	// final float neurologicDisordersFrac = 9423/allCauses;
	final float residualFrac = 22688/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.0355f;
	    final float[] ar = new float[]
		{ 0.062f*62367f/x,    // bladder
		  0f,                 // breast
		  0.035f*280208f/x,   // colorectal
		  0f,                 // ovary
		  0.031f*60578f/x,    // kidney
		  0.043f*107590f/x,   // leukemia
		  0.019f*450375f*2/x, // lung+bronchus
		  0.027f*38245f/x,    // melanoma
		  0.041f*109357f/x,   // malignantLymphomas
		  0.036f*151944f/x,   // pancreas
		  0.070f*150799f*2/x, // prostate
		  0.023f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //     return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 85-89

    static private float incidenceMale90(Disease dis, String set) {
	// 90-94
	String disName = dis.getName();
	final float allCauses = 77477.0f - 1865;

	final int septicemia = 1021; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int pneumoniaAspiration = 1341;
	if ( disName.equals(LR. pneumoniaAspiration) ) 
	    return  pneumoniaAspiration/allCauses;
	final int influenzaPlusPneumonia = 3319; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int diabetesMellitus = 1487;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	// final int cirrhosis = 3335;
	// if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 2123;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int alzheimer = 3920;
	if ( disName.equals(LR.alzheimer) ||
	     disName.equals(LR.alzheimer1) ||
	     disName.equals(LR.alzheimer2) ||
	     disName.equals(LR.alzheimer3) ) return alzheimer/allCauses;
	final int parkinson = 1123;
	if ( disName.equals(LR.parkinson) ) return parkinson/allCauses;
	final int renalFailureAcute = 949; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	// atherosclerosis   483 0.6%
	final int cerebrovascularAccident = 4955;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (10512+526)/allCauses;
	final float cardioDisordersFrac = 27021/allCauses;
	final float respiratoryDisordersFrac = 3737/allCauses;
	// final float neurologicDisordersFrac = 4955/allCauses;
	final float residualFrac = 13095/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.0355f;
	    final float[] ar = new float[]
		{ 0.062f*62367f/x,    // bladder
		  0f,                 // breast
		  0.035f*280208f/x,   // colorectal
		  0f,                 // ovary
		  0.031f*60578f/x,    // kidney
		  0.043f*107590f/x,   // leukemia
		  0.019f*450375f*2/x, // lung+bronchus
		  0.027f*38245f/x,    // melanoma
		  0.041f*109357f/x,   // malignantLymphomas
		  0.036f*151944f/x,   // pancreas
		  0.076f*150799f*2/x, // prostate
		  0.023f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 90-94

   static private float incidenceMale95(Disease dis, String set) {
	// 95-100
	String disName = dis.getName();
	final float allCauses = 22102.0f - 600;

	final int septicemia = 253; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int pneumoniaAspiration = 419;
	if ( disName.equals(LR. pneumoniaAspiration) ) 
	    return  pneumoniaAspiration/allCauses;
	final int influenzaPlusPneumonia = 1191; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int diabetesMellitus = 312;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	// final int cirrhosis = 3335;
	// if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 609;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int alzheimer = 1120;
	if ( disName.equals(LR.alzheimer) ||
	     disName.equals(LR.alzheimer1) ||
	     disName.equals(LR.alzheimer2) ||
	     disName.equals(LR.alzheimer3) ) return alzheimer/allCauses;
	final int parkinson = 194;
	if ( disName.equals(LR.parkinson) ) return parkinson/allCauses;
	final int renalFailureAcute = 326; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	// atherosclerosis   165 0.7%
	final int cerebrovascularAccident = 1376;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (2205+109)/allCauses;
	final float cardioDisordersFrac = 8281/allCauses;
	final float respiratoryDisordersFrac = 927/allCauses;
	// final float neurologicDisordersFrac = 1376/allCauses;
	final float residualFrac = 4015/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.0355f;
	    final float[] ar = new float[]
		{ 0.062f*62367f/x,    // bladder
		  0f,                 // breast
		  0.035f*280208f/x,   // colorectal
		  0f,                 // ovary
		  0.031f*60578f/x,    // kidney
		  0.043f*107590f/x,   // leukemia
		  0.019f*450375f*2/x, // lung+bronchus
		  0.027f*38245f/x,    // melanoma
		  0.041f*109357f/x,   // malignantLymphomas
		  0.036f*151944f/x,   // pancreas
		  0.073f*150799f*2/x, // prostate
		  0.023f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 95-99

   static private float incidenceMale100(Disease dis, String set) {
	// 100-
	String disName = dis.getName();
	final float allCauses = 3173.0f - 81;

	final int septicemia = 26; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int pneumoniaAspiration = 63;
	if ( disName.equals(LR. pneumoniaAspiration) ) 
	    return  pneumoniaAspiration/allCauses;
	final int influenzaPlusPneumonia = 256; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int diabetesMellitus = 43;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	// final int cirrhosis = 3335;
	// if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 101;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int alzheimer = 115;
	if ( disName.equals(LR.alzheimer) ||
	     disName.equals(LR.alzheimer1) ||
	     disName.equals(LR.alzheimer2) ||
	     disName.equals(LR.alzheimer3) ) return alzheimer/allCauses;
	final int parkinson = 14;
	if ( disName.equals(LR.parkinson) ) return parkinson/allCauses;
	final int renalFailureAcute = 44; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	//   atherosclerosis   38 0.7%
	final int anemia = 10; 
	if ( disName.equals(LR.anemiaFolicAcidDeficiency) ) return anemia/allCauses;
	final int cerebrovascularAccident = 161;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (242+10)/allCauses;
	final float cardioDisordersFrac = 1260/allCauses;
	final float respiratoryDisordersFrac = 87/allCauses;
	// final float neurologicDisordersFrac = 161/allCauses;
	final float residualFrac = 622/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.0355f;
	    final float[] ar = new float[]
		{ 0.062f*62367f/x,    // bladder
		  0f,                 // breast
		  0.035f*280208f/x,   // colorectal
		  0f,                 // ovary
		  0.031f*60578f/x,    // kidney
		  0.043f*107590f/x,   // leukemia
		  0.019f*450375f*2/x, // lung+bronchus
		  0.027f*38245f/x,    // melanoma
		  0.041f*109357f/x,   // malignantLymphomas
		  0.036f*151944f/x,   // pancreas
		  0.073f*150799f*2/x, // prostate
		  0.023f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // male 100-



    // ****************************************
    // incidence female - separate age regions
    // ****************************************

    static private float incidenceFemale(int age, Disease dis) {
	String set = dis.getDiseaseSet();
	if ( age < 1 ) return incidenceFemale0(dis, set); 
	if ( age < 5 ) return incidenceFemale1(dis, set); 
	if ( age < 10 ) return incidenceFemale5(dis, set); 
	if ( age < 15 ) return incidenceFemale10(dis, set); 
	if ( age < 20 ) return incidenceFemale15(dis, set); 
	if ( age < 25 ) return incidenceFemale20(dis, set); 
	if ( age < 30 ) return incidenceFemale25(dis, set); 
	if ( age < 35 ) return incidenceFemale30(dis, set); 
	if ( age < 40 ) return incidenceFemale35(dis, set); 
	if ( age < 45 ) return incidenceFemale40(dis, set); 
	if ( age < 50 ) return incidenceFemale45(dis, set); 
	if ( age < 55 ) return incidenceFemale50(dis, set); 
	if ( age < 60 ) return incidenceFemale55(dis, set); 
	if ( age < 65 ) return incidenceFemale60(dis, set); 
	if ( age < 70 ) return incidenceFemale65(dis, set); 
	if ( age < 75 ) return incidenceFemale70(dis, set); 
	if ( age < 80 ) return incidenceFemale75(dis, set); 
	if ( age < 85 ) return incidenceFemale80(dis, set); 
	if ( age < 90 ) return incidenceFemale85(dis, set); 
	if ( age < 95 ) return incidenceFemale90(dis, set); 
	if ( age < 100 ) return incidenceFemale95(dis, set);
	return incidenceFemale100(dis, set); 
    } // end incidenceFemale(final int age, Disease dis)

    static private float incidenceFemale0(Disease dis, String set) {
	// < 1 year
	// More here
	return residual1;
    }

    static private float incidenceFemale1(Disease dis, String set) {
	// 1-4 year
	String disName = dis.getName();
	final float allCauses = 2069.0f - (601 + 185);

	final int septicemia = 34; // member of infections 
	if ( disName.equals(LR.septicemia) ) return septicemia/allCauses;

	final int influenzaPlusPneumonia = 54; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/ allCauses; // divided by two?
	final int anemia = 11;
	if ( disName.equals(LR.anemiaFolicAcidDeficiency) )
	    return anemia/allCauses;
	final int nephroticSyndrome = 11;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int cerebrovascularAccident = 32;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	final float geneticDisordersFrac = 260/allCauses;
	final float neoPlasmsFrac = (173+31)/allCauses;
	final float cardioDisordersFrac = 91/allCauses;
	final float perinatalDisordersFrac = 36/allCauses;
	final float respiratoryDisordersFrac = 27/allCauses;
	// final float neurologicDisordersFrac = 32/allCauses;
	final float residualFrac = 501/allCauses;

	if ( set.equals(LR.geneticDisorders) )
	    return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.001f;
	    final float[] ar = new float[]
		{ 0f,                       // bladder
		  0f,                       // breast
		  0f,                       // colorectal
		  0f,                       // ovary
		  0.001f*60578f/x,          // kidney
		  0.008f*107590f/x,         // leukemia
		  0f,                       // lung+bronchus
		  0f,                       // melanoma
		  0.001f*109357f/x,         // malignantLymphomas
		  0f,                       // pancreas
		  0f,                       // prostate
		  0f                        // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.perinatalDisorders) )
	    return perinatalDisordersFrac * perinatalDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
	    return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 1-4

    static private float incidenceFemale5(Disease dis, String set) {
	// 5-9 year
	String disName = dis.getName();
	final float allCauses = 1192.0f - (393 + 67);

	final int septicemia = 12; // member of infections 
	if ( disName.equals(LR.septicemia) ) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 23; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int anemia = 5;
	if ( disName.equals(LR.anemiaFolicAcidDeficiency) )
	    return anemia/allCauses;
	final int meningitis = 9;
	if ( disName.equals(LR.meningitis) ) return meningitis/allCauses;
	final int nephroticSyndrome = 6;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int diabetesMellitus = 4;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cerebrovascularAccident = 21;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	final float geneticDisordersFrac = 99/allCauses;
	final float neoPlasmsFrac = (225+20)/allCauses;
	final float cardioDisordersFrac = 47/allCauses;
	final float perinatalDisordersFrac = 4/allCauses;
	final float respiratoryDisordersFrac = 18/allCauses;
	// final float neurologicDisordersFrac = 21/allCauses;
	final float residualFrac = 232/allCauses;

	if ( set.equals(LR.geneticDisorders) )
	    return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.001f;
	    final float[] ar = new float[]
		{ 0f,                       // bladder
		  0f,                       // breast
		  0f,                       // colorectal
		  0f,                       // ovary
		  0.001f*60578f/x,          // kidney
		  0.008f*107590f/x,         // leukemia
		  0f,                       // lung+bronchus
		  0f,                       // melanoma
		  0.0008f*109357f/x,         // malignantLymphomas
		  0f,                       // pancreas
		  0f,                       // prostate
		  0f                        // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.perinatalDisorders) )
	    return perinatalDisordersFrac * perinatalDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
	    return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
	//     return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 5-9

    static private float incidenceFemale10(Disease dis, String set) {
	// 10-14 year
	String disName = dis.getName();
	final float allCauses = 1370.0f - (455 + 69 + 52);

	final int septicemia = 17; // member of infections 
	if ( disName.equals(LR.septicemia) ) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 28; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/ allCauses; // divided by two?
	final int aids = 7;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	if ( disName.equals(LR.nephroticSyndrome) ) // by interpolation
	    return 0.011f;
	final int meningitis = 7;
	if ( disName.equals(LR.meningitis) ) return meningitis/allCauses;
	final int anemia = 6;
	if ( disName.equals(LR.anemiaFolicAcidDeficiency) ) 
	    return anemia/allCauses;
	final int diabetesMellitus = 6;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cerebrovascularAccident = 25;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	final float geneticDisordersFrac = 81/allCauses;
	final float neoPlasmsFrac = (235+17)/allCauses;
	final float cardioDisordersFrac = 61/allCauses;
	final float respiratoryDisordersFrac = 22/allCauses;
	// final float neurologicDisordersFrac = 25/allCauses;
	final float residualFrac = 282/allCauses;

	if ( set.equals(LR.geneticDisorders) )
	    return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.001f;
	    final float[] ar = new float[]
		{ 0f,                       // bladder
		  0f,                       // breast
		  0f,                       // colorectal
		  0.0004f*72529f*2/x,        // ovary
		  0.001f*60578f/x,          // kidney
		  0.008f*107590f/x,         // leukemia
		  0f,                       // lung+bronchus
		  0f,                       // melanoma
		  0.0012f*109357f/x,         // malignantLymphomas
		  0f,                       // pancreas
		  0f,                       // prostate
		  0f                        // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
	    return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 10-14

    static private float incidenceFemale15(Disease dis, String set) {
	// 15-19 year
	String disName = dis.getName();
	final float allCauses = 3741.0f - (1951 + 292 + 260);

	final int septicemia = 29; // member of infections 
	if ( disName.equals(LR.septicemia) ) return septicemia/allCauses; 
	final int influenzaPlusPneumonia = 29; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/ allCauses; // divided by two?
	final int diabetesMellitus = 24;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	if ( disName.equals(LR.nephroticSyndrome) ) // by interpolation
	    return 0.013f;
	final int anemia = 20;
	if ( disName.equals(LR.anemiaFolicAcidDeficiency) ) 
	    return anemia/allCauses;
	final int aids = 19;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int cerebrovascularAccident = 31;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	final float geneticDisordersFrac = 78/allCauses;
	final float neoPlasmsFrac = (278+16)/allCauses;
	final float cardioDisordersFrac = 116/allCauses;
	final float respiratoryDisordersFrac = 28/allCauses;
	// final float neurologicDisordersFrac = 31/allCauses; // cerebrovascular
	final float residualFrac = 526/allCauses;

	if ( set.equals(LR.geneticDisorders) )
	    return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.001f;
	    final float[] ar = new float[]
		{ 0f,                       // bladder
		  0f,                       // breast
		  0f,                       // colorectal
		  0.0006f*72529f*2/x,        // ovary
		  0.001f*60578f/x,          // kidney
		  0.008f*107590f/x,         // leukemia
		  0f,                       // lung+bronchus
		  0.001f*38245f/x,          // melanoma
		  0.002f*109357f/x,         // malignantLymphomas
		  0f,                       // pancreas
		  0f,                       // prostate
		  0f                        // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
	    return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 15-19

    static private float incidenceFemale20(Disease dis, String set) {
	// 20-24 year
	String disName = dis.getName();
	final float allCauses = 4925.0f - (2041 + 430 + 399);

	final int septicemia = 46; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 43; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int aids = 53;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int diabetesMellitus = 46;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int nephroticSyndrome = 31;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int cerebrovascularAccident = 51;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	final float geneticDisordersFrac = 83/allCauses;
	final float neoPlasmsFrac = (388+22)/allCauses;
	final float cardioDisordersFrac = 268/allCauses;
	final float respiratoryDisordersFrac = 25/allCauses;
	// final float neurologicDisordersFrac = 51/allCauses;
	final float residualFrac = 883/allCauses;

	if ( set.equals(LR.geneticDisorders) )
	    return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.003f;
	    final float[] ar = new float[]
		{ 0.000f*62367f/x,    // bladder
		  0.002f*207353f*2/x, // breast
		  0.001f*280208f/x,   // colorectal
		  0.002f*72529f*2/x,  // ovary
		  0.001f*60578f/x,    // kidney
		  0.008f*107590f/x,   // leukemia
		  0.000f*450375f*2/x, // lung+bronchus
		  0.007f*38245f/x,    // melanoma
		  0.007f*109357f/x,   // malignantLymphomas
		  0.000f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.004f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
	    return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 20-24

    static private float incidenceFemale25(Disease dis, String set) {
	// 25-29 year
	String disName = dis.getName();
	final float allCauses = 5824.0f - (1888 + 483 + 411);

	final int septicemia = 61; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 65; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int aids = 167;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int diabetesMellitus = 92;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int nephroticSyndrome = 48;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int cirrhosis = 43;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int cerebrovascularAccident = 90;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	final float geneticDisordersFrac = 92/allCauses;
	final float neoPlasmsFrac = (603+0)/allCauses;
	final float cardioDisordersFrac = 422/allCauses;
	final float respiratoryDisordersFrac = 51/allCauses;
	// final float neurologicDisordersFrac = 90/allCauses;
	final float residualFrac = 1150/allCauses;

	if ( set.equals(LR.geneticDisorders) )
	    return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.003f;
	    final float[] ar = new float[]
		{ 0.000f*62367f/x,    // bladder
		  0.004f*207353f*2/x, // breast
		  0.002f*280208f/x,   // colorectal
		  0.003f*72529f*2/x,  // ovary
		  0.002f*60578f/x,    // kidney
		  0.008f*107590f/x,   // leukemia 
		  0.000f*450375f*2/x, // lung+bronchus
		  0.010f*38245f/x,    // melanoma
		  0.006f*109357f/x,   // malignantLymphomas
		  0.001f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.004f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 25-29

    static private float incidenceFemale30(Disease dis, String set) {
	// 30-34 year
	String disName = dis.getName();
	final float allCauses = 6956.0f - (1705 + 328 + 514);

	final int septicemia = 83; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 79; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int aids = 271;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int diabetesMellitus = 159;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int nephroticSyndrome = 72;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int cirrhosis = 80;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int cerebrovascularAccident = 163;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	final float geneticDisordersFrac = 82/allCauses;
	final float neoPlasmsFrac = (1168+0)/allCauses;
	final float cardioDisordersFrac = 624/allCauses;
	final float respiratoryDisordersFrac = 62/allCauses;
	// final float neurologicDisordersFrac = 163/allCauses;
	final float residualFrac = 1398/allCauses;

	if ( set.equals(LR.geneticDisorders) )
	    return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.003f;
	    final float[] ar = new float[]
		{ 0.001f*62367f/x,    // bladder
		  0.005f*207353f*2/x, // breast
		  0.002f*280208f/x,   // colorectal
		  0.003f*72529f*2/x,  // ovary
		  0.002f*60578f/x,    // kidney
		  0.008f*107590f/x,   // leukemia 
		  0.001f*450375f*2/x, // lung+bronchus
		  0.012f*38245f/x,    // melanoma
		  0.004f*109357f/x,   // malignantLymphomas
		  0.001f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.004f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 30-34

    static private float incidenceFemale35(Disease dis, String set) {
	// 35-39 year
	String disName = dis.getName();
	final float allCauses = 11126.0f - (2155 + 365 + 662);

	final int septicemia = 159; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 133; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int aids = 459;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int diabetesMellitus = 270;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 250;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 130;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int cerebrovascularAccident = 332;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	final float geneticDisordersFrac = 114/allCauses;
	final float neoPlasmsFrac = (2480+0)/allCauses;
	final float cardioDisordersFrac = 1194/allCauses;
	final float respiratoryDisordersFrac = 120/allCauses;
	// final float neurologicDisordersFrac = 332/allCauses;
	final float residualFrac = 2147/allCauses;
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.0145f;
	    final float[] ar = new float[]
		{ 0.004f*62367f/x,    // bladder
		  0.030f*207353f*2/x, // breast
		  0.011f*280208f/x,   // colorectal
		  0.015f*72529f*2/x,  // ovary
		  0.011f*60578f/x,    // kidney
		  0.022f*107590f/x,   // leukemia 
		  0.009f*450375f*2/x, // lung+bronchus
		  0.045f*38245f/x,    // melanoma
		  0.016f*109357f/x,   // malignantLymphomas
		  0.007f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.020f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.geneticDisorders) )
	    return geneticDisordersFrac * geneticDisorders(disName);

	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 35-39

    static private float incidenceFemale40(Disease dis, String set) {
	// 40-44 year
	String disName = dis.getName();
	final float allCauses = 18375.0f - (2754 + 398 + 908);

	final int septicemia = 288; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 208; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int aids = 607;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int diabetesMellitus = 486;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 598;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 196;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int hepatitisViral = 134;
	if ( disName.equals(LR.hepatitisViral) ||
	     disName.equals(LR.hepatitisJaundice) ||
	     disName.equals(LR.hepatitisProdromal) ) 
	    return hepatitisViral/allCauses;
	final int cerebrovascularAccident = 658;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	final float geneticDisordersFrac = 142/allCauses;
	final float neoPlasmsFrac = (5107+0)/allCauses;
	final float cardioDisordersFrac = 2300/allCauses;
	final float respiratoryDisordersFrac = 284/allCauses;
	// final float neurologicDisordersFrac = 658/allCauses;
	final float residualFrac = 3307/allCauses;

	if ( set.equals(LR.geneticDisorders) )
	    return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.0145f;
	    final float[] ar = new float[]
		{ 0.005f*62367f/x,    // bladder
		  0.035f*207353f*2/x, // breast
		  0.011f*280208f/x,   // colorectal
		  0.017f*72529f*2/x,  // ovary
		  0.015f*60578f/x,    // kidney
		  0.014f*107590f/x,   // leukemia 
		  0.009f*450375f*2/x, // lung+bronchus
		  0.032f*38245f/x,    // melanoma
		  0.015f*109357f/x,   // malignantLymphomas
		  0.011f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.018f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //     return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 40-44

    static private float incidenceFemale45(Disease dis, String set) {
	// 45-49 year
	String disName = dis.getName();
	final float allCauses = 29834.0f - (3348 + 353 + 1008);

	final int septicemia = 462; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 334; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int aids = 643;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int diabetesMellitus = 785;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 1111;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 398;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int hepatitisViral = 307;
	if ( disName.equals(LR.hepatitisViral) ||
	     disName.equals(LR.hepatitisJaundice) ||
	     disName.equals(LR.hepatitisProdromal) ) 
	    return hepatitisViral/allCauses;
	final int renalFailureAcute = 164; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int cerebrovascularAccident = 1206;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;


	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (9877+0)/allCauses;
	final float cardioDisordersFrac = 4241/allCauses;
	final float respiratoryDisordersFrac = 694/allCauses;
	// final float neurologicDisordersFrac = 1206/allCauses;
	final float residualFrac = 4903/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.0445f;
	    final float[] ar = new float[]
		{ 0.018f*62367f/x,    // bladder
		  0.085f*207353f*2/x, // breast
		  0.034f*280208f/x,   // colorectal
		  0.050f*72529f*2/x,  // ovary
		  0.049f*60578f/x,    // kidney
		  0.032f*107590f/x,   // leukemia 
		  0.035f*450375f*2/x, // lung+bronchus
		  0.078f*38245f/x,    // melanoma
		  0.037f*109357f/x,   // malignantLymphomas
		  0.036f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.048f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 45-49

    static private float incidenceFemale50(Disease dis, String set) {
	// 50-54 year
	String disName = dis.getName();
	final float allCauses = 40396.0f - (2950 + 215 + 946);

	final int septicemia = 664; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 449; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int aids = 485;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int diabetesMellitus = 1455;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 1313;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 575;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int hepatitisViral = 511;
	if ( disName.equals(LR.hepatitisViral) ||
	     disName.equals(LR.hepatitisJaundice) ||
	     disName.equals(LR.hepatitisProdromal) ) 
	    return hepatitisViral/allCauses;
	final int renalFailureAcute = 311; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int cerebrovascularAccident = 1672;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (14920+0)/allCauses;
	final float cardioDisordersFrac = 6282/allCauses;
	final float respiratoryDisordersFrac = 1334/allCauses;
	// final float neurologicDisordersFrac = 1672/allCauses;
	final float residualFrac = 6314/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.0445f;
	    final float[] ar = new float[]
		{ 0.022f*62367f/x,    // bladder
		  0.068f*207353f*2/x, // breast
		  0.033f*280208f/x,   // colorectal
		  0.063f*72529f*2/x,  // ovary
		  0.055f*60578f/x,    // kidney
		  0.033f*107590f/x,   // leukemia 
		  0.039f*450375f*2/x, // lung+bronchus
		  0.076f*38245f/x,    // melanoma
		  0.037f*109357f/x,   // malignantLymphomas
		  0.046f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.045f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //     return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 50-54

    static private float incidenceFemale55(Disease dis, String set) {
	// 55-59 year
	String disName = dis.getName();
	final float allCauses = 50868.0f - (2156 + 0 + 750);

	final int septicemia = 907; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 562; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int aids = 260;
	if ( disName.equals(LR.acquiredImmunoDeficiencySyndrome) ||
	     disName.equals(LR.acquiredImmunoDeficiencySyndromeAdvanced) )
	    return aids/allCauses;
	final int diabetesMellitus = 2043;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 1207;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 867;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int hepatitisViral = 414;
	if ( disName.equals(LR.hepatitisViral) ||
	     disName.equals(LR.hepatitisJaundice) ||
	     disName.equals(LR.hepatitisProdromal) )
	    return hepatitisViral/allCauses;
	final int renalFailureAcute = 374; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int cerebrovascularAccident = 1988;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (20736+254)/allCauses;
	final float cardioDisordersFrac = 8566/allCauses;
	final float respiratoryDisordersFrac = 2163/allCauses;
	// final float neurologicDisordersFrac = 1988/allCauses;
	final float residualFrac = 7621/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.084f;
	    final float[] ar = new float[]
		{ 0.050f*62367f/x,    // bladder
		  0.100f*207353f*2/x, // breast
		  0.070f*280208f/x,   // colorectal
		  0.100f*72529f*2/x,  // ovary
		  0.100f*60578f/x,    // kidney
		  0.055f*107590f/x,   // leukemia 
		  0.080f*450375f*2/x, // lung+bronchus
		  0.090f*38245f/x,    // melanoma
		  0.069f*109357f/x,   // malignantLymphomas
		  0.080f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.075f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //     return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 55-59

    static private float incidenceFemale60(Disease dis, String set) {
	// 60-64 year
	String disName = dis.getName();
	final float allCauses = 62624.0f - (1680 + 0 + 493);

	final int septicemia = 1121; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 709; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int diabetesMellitus = 2617;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 1065;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 1095;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int hepatitisViral = 238;
	if ( disName.equals(LR.hepatitisViral) ||
	     disName.equals(LR.hepatitisJaundice) ||
	     disName.equals(LR.hepatitisProdromal) ) 
	    return hepatitisViral/allCauses;
	final int renalFailureAcute = 477; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int alzheimer = 275;
	if ( disName.equals(LR.alzheimer) ||
	     disName.equals(LR.alzheimer1) ||
	     disName.equals(LR.alzheimer2) ||
	     disName.equals(LR.alzheimer3) ) return alzheimer/allCauses;
	final int cerebrovascularAccident = 2520;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (25876+324)/allCauses;
	final float cardioDisordersFrac = 11403/allCauses;
	final float respiratoryDisordersFrac = 3881/allCauses;
	// final float neurologicDisordersFrac = 2520/allCauses;
	final float residualFrac = 8850/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.084f;
	    final float[] ar = new float[]
		{ 0.056f*62367f/x,    // bladder
		  0.090f*207353f*2/x, // breast
		  0.080f*280208f/x,   // colorectal
		  0.086f*72529f*2/x,  // ovary
		  0.096f*60578f/x,    // kidney
		  0.065f*107590f/x,   // leukemia 
		  0.103f*450375f*2/x, // lung+bronchus
		  0.095f*38245f/x,    // melanoma
		  0.070f*109357f/x,   // malignantLymphomas
		  0.090f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.075f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //     return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 60-64

    static private float incidenceFemale65(Disease dis, String set) {
	// 65-69 year
	String disName = dis.getName();
	final float allCauses = 74499.0f - (1438 + 0 + 257);

	final int septicemia = 1354; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 965; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int diabetesMellitus = 2965;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 936;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 1555;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int renalFailureAcute = 641; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int alzheimer = 601;
	if ( disName.equals(LR.alzheimer) ||
	     disName.equals(LR.alzheimer1) ||
	     disName.equals(LR.alzheimer2) ||
	     disName.equals(LR.alzheimer3) ) return alzheimer/allCauses;
	final int thoracicAortaAneurysm = 343;
	if ( disName.equals(LR.thoracicAortaAneurysm) ) 
	    return thoracicAortaAneurysm/allCauses;
	final int cerebrovascularAccident = 3483;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (29458+423)/allCauses;
	final float cardioDisordersFrac = 14105/allCauses;
	final float respiratoryDisordersFrac = 5768/allCauses;
	// final float neurologicDisordersFrac = 3483/allCauses;
	final float residualFrac = 10207/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.13f;
	    final float[] ar = new float[]
		{ 0.100f*62367f/x,    // bladder
		  0.100f*207353f*2/x, // breast
		  0.100f*280208f/x,   // colorectal
		  0.120f*72529f*2/x,  // ovary
		  0.130f*60578f/x,    // kidney
		  0.100f*107590f/x,   // leukemia
		  0.160f*450375f*2/x, // lung+bronchus
		  0.100f*38245f/x,    // melanoma
		  0.100f*109357f/x,   // malignantLymphomas
		  0.134f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.118f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}

	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //     return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 65-69

   static private float incidenceFemale70(Disease dis, String set) {
	// 70-74 year
	String disName = dis.getName();
	final float allCauses = 96395.0f - (1722 + 0 + 0);

	final int septicemia = 1735; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 1538; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int diabetesMellitus = 3868;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 1012;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 2153;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int renalFailureAcute = 891; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int alzheimer = 1689;
	if ( disName.equals(LR.alzheimer) ||
	     disName.equals(LR.alzheimer1) ||
	     disName.equals(LR.alzheimer2) ||
	     disName.equals(LR.alzheimer3) ) return alzheimer/allCauses;
	final int thoracicAortaAneurysm = 575;
	if ( disName.equals(LR.thoracicAortaAneurysm) ) 
	    return thoracicAortaAneurysm/allCauses;
	final int parkinson = 577;
	if ( disName.equals(LR.parkinson) ) return parkinson/allCauses;
	final int cerebrovascularAccident = 5173;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (33084+625)/allCauses;
	final float cardioDisordersFrac = 19952/allCauses;
	final float respiratoryDisordersFrac = 8217/allCauses;
	// final float neurologicDisordersFrac = 5173/allCauses;
	final float residualFrac = 13584/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.13f;
	    final float[] ar = new float[]
		{ 0.126f*62367f/x,    // bladder
		  0.104f*207353f*2/x, // breast
		  0.104f*280208f/x,   // colorectal
		  0.130f*72529f*2/x,  // ovary
		  0.130f*60578f/x,    // kidney
		  0.125f*107590f/x,   // leukemia
		  0.148f*450375f*2/x, // lung+bronchus
		  0.116f*38245f/x,    // melanoma
		  0.147f*109357f/x,   // malignantLymphomas
		  0.134f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.118f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //     return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 70-74

    static private float incidenceFemale75(Disease dis, String set) {
	// 75-79 year
	String disName = dis.getName();
	final float allCauses = 139360.0f - (2617 + 0 + 0);

	final int septicemia = 2429; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int influenzaPlusPneumonia = 2785; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int diabetesMellitus = 5171;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int cirrhosis = 957;
	if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 3132;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int alzheimer = 4626;
	if ( disName.equals(LR.alzheimer) ||
	     disName.equals(LR.alzheimer1) ||
	     disName.equals(LR.alzheimer2) ||
	     disName.equals(LR.alzheimer3) ) return alzheimer/allCauses;
	final int renalFailureAcute = 1380; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int parkinson = 1374;
	if ( disName.equals(LR.parkinson) ) return parkinson/allCauses;
	final int thoracicAortaAneurysm = 873;
	if ( disName.equals(LR.thoracicAortaAneurysm) ) 
	    return thoracicAortaAneurysm/allCauses;
	final int cerebrovascularAccident = 9105;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (38500+905)/allCauses;
	final float cardioDisordersFrac = 32243/allCauses;
	final float respiratoryDisordersFrac = 11455/allCauses;
	// final float neurologicDisordersFrac = 9105/allCauses;
	final float residualFrac = 21808/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.15f;
	    final float[] ar = new float[]
		{ 0.200f*62367f/x,    // bladder
		  0.120f*207353f*2/x, // breast
		  0.144f*280208f/x,   // colorectal
		  0.168f*72529f*2/x,  // ovary
		  0.150f*60578f/x,    // kidney
		  0.180f*107590f/x,   // leukemia
		  0.192f*450375f*2/x, // lung+bronchus
		  0.140f*38245f/x,    // melanoma
		  0.180f*109357f/x,   // malignantLymphomas
		  0.170f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.149f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 75-79

    static private float incidenceFemale80(Disease dis, String set) {
	// 80-84 year
	String disName = dis.getName();
	final float allCauses = 192519.0f - (3851 + 0 + 0);

	final int septicemia = 3206; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int pneumoniaAspiration = 1510;
	if ( disName.equals(LR. pneumoniaAspiration) ) 
	    return  pneumoniaAspiration/allCauses;
	final int influenzaPlusPneumonia = 4662; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int diabetesMellitus = 6144;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	// final int cirrhosis = 957;
	// if ( disName.equals(LR.cirrhosis) ) return cirrhosis/allCauses;
	final int nephroticSyndrome = 4144;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int alzheimer = 10133;
	if ( disName.equals(LR.alzheimer) ||
	     disName.equals(LR.alzheimer1) ||
	     disName.equals(LR.alzheimer2) ||
	     disName.equals(LR.alzheimer3) ) return alzheimer/allCauses;
	final int renalFailureAcute = 2395; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int parkinson = 2295;
	if ( disName.equals(LR.parkinson) ) return parkinson/allCauses;
	final int thoracicAortaAneurysm = 1132;
	if ( disName.equals(LR.thoracicAortaAneurysm) ) 
	    return thoracicAortaAneurysm/allCauses;
	final int cerebrovascularAccident = 15174;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (39181+1242)/allCauses;
	final float cardioDisordersFrac = 51009/allCauses;
	final float respiratoryDisordersFrac = 13147/allCauses;
	// final float neurologicDisordersFrac = 15174/allCauses;
	final float residualFrac = 33294/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.15f;
	    final float[] ar = new float[]
		{ 0.127f*62367f/x,    // bladder
		  0.110f*207353f*2/x, // breast
		  0.175f*280208f/x,   // colorectal
		  0.120f*72529f*2/x,  // ovary
		  0.129f*60578f/x,    // kidney
		  0.136f*107590f/x,   // leukemia
		  0.120f*450375f*2/x, // lung+bronchus
		  0.091f*38245f/x,    // melanoma
		  0.154f*109357f/x,   // malignantLymphomas
		  0.145f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.149f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 80-84

    static private float incidenceFemale85(Disease dis, String set) {
	// 85-89
	String disName = dis.getName();
	final float allCauses = 213110.0f - (4409 + 0 + 0);

	final int septicemia = 3271; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int pneumoniaAspiration = 1949;
	if ( disName.equals(LR. pneumoniaAspiration) ) 
	    return  pneumoniaAspiration/allCauses;
	final int influenzaPlusPneumonia = 6330; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int diabetesMellitus = 5465;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int nephroticSyndrome = 4581;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int alzheimer = 14787;
	if ( disName.equals(LR.alzheimer) ||
	     disName.equals(LR.alzheimer1) ||
	     disName.equals(LR.alzheimer2) ||
	     disName.equals(LR.alzheimer3) ) return alzheimer/allCauses;
	final int renalFailureAcute = 3201; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int parkinson = 2235;
	if ( disName.equals(LR.parkinson) ) return parkinson/allCauses;
	final int cerebrovascularAccident = 18738;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (28867+1315)/allCauses;
	final float cardioDisordersFrac = 64618/allCauses;
	final float respiratoryDisordersFrac = 10995/allCauses;
	// final float neurologicDisordersFrac = 18738/allCauses;
	final float residualFrac = 41167/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.0355f;
	    final float[] ar = new float[]
		{ 0.062f*62367f/x,    // bladder
		  0.037f*207353f*2/x, // breast
		  0.060f*280208f/x,   // colorectal
		  0.031f*72529f*2/x,  // ovary
		  0.031f*60578f/x,    // kidney
		  0.043f*107590f/x,   // leukemia
		  0.026f*450375f*2/x, // lung+bronchus
		  0.027f*38245f/x,    // melanoma
		  0.041f*109357f/x,   // malignantLymphomas
		  0.036f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.023f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 85-89

    static private float incidenceFemale90(Disease dis, String set) {
	// 90-94
	String disName = dis.getName();
	final float allCauses = 162703.0f - (3384 + 0 + 0);

	final int septicemia = 2038; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int pneumoniaAspiration = 1629;
	if ( disName.equals(LR. pneumoniaAspiration) ) 
	    return  pneumoniaAspiration/allCauses;
	final int influenzaPlusPneumonia = 5762; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int diabetesMellitus = 3126;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int nephroticSyndrome = 3203;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int alzheimer = 13155;
	if ( disName.equals(LR.alzheimer) ||
	     disName.equals(LR.alzheimer1) ||
	     disName.equals(LR.alzheimer2) ||
	     disName.equals(LR.alzheimer3) ) return alzheimer/allCauses;
	final int renalFailureAcute = 2767; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int parkinson = 1260;
	if ( disName.equals(LR.parkinson) ) return parkinson/allCauses;
	//    atherosclerosis   1125 0.7%
	final int cerebrovascularAccident = 14280;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (14062+848)/allCauses;
	final float cardioDisordersFrac = 55380/allCauses;
	final float respiratoryDisordersFrac = 6073/allCauses;
	// final float neurologicDisordersFrac = 14280/allCauses;
	final float residualFrac = 34611/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.0355f;
	    final float[] ar = new float[]
		{ 0.062f*62367f/x,    // bladder
		  0.037f*207353f*2/x, // breast
		  0.074f*280208f/x,   // colorectal
		  0.031f*72529f*2/x,  // ovary
		  0.031f*60578f/x,    // kidney
		  0.043f*107590f/x,   // leukemia
		  0.026f*450375f*2/x, // lung+bronchus
		  0.027f*38245f/x,    // melanoma
		  0.041f*109357f/x,   // malignantLymphomas
		  0.036f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.023f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //     return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 90-94

    static private float incidenceFemale95(Disease dis, String set) {
	// 95-99
	String disName = dis.getName();
	final float allCauses = 72375.0f - (1515 + 0 + 0);

	final int septicemia = 780; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int pneumoniaAspiration = 746;
	if ( disName.equals(LR. pneumoniaAspiration) ) 
	    return  pneumoniaAspiration/allCauses;
	final int influenzaPlusPneumonia = 2928; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int diabetesMellitus = 982;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int nephroticSyndrome = 1252;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int alzheimer = 6148;
	if ( disName.equals(LR.alzheimer) ||
	     disName.equals(LR.alzheimer1) ||
	     disName.equals(LR.alzheimer2) ||
	     disName.equals(LR.alzheimer3) ) return alzheimer/allCauses;
	final int renalFailureAcute = 1369; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int parkinson = 320;
	if ( disName.equals(LR.parkinson) ) return parkinson/allCauses;
	//    atherosclerosis   683 0.9%
	final int cerebrovascularAccident = 5939;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (4169+306)/allCauses;
	final float cardioDisordersFrac = 26729/allCauses;
	final float respiratoryDisordersFrac = 2009/allCauses;
	// final float neurologicDisordersFrac = 5939/allCauses;
	final float residualFrac = 16500/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.0355f;
	    final float[] ar = new float[]
		{ 0.062f*62367f/x,    // bladder
		  0.036f*207353f*2/x, // breast
		  0.065f*280208f/x,   // colorectal
		  0.030f*72529f*2/x,  // ovary
		  0.031f*60578f/x,    // kidney
		  0.043f*107590f/x,   // leukemia
		  0.026f*450375f*2/x, // lung+bronchus
		  0.027f*38245f/x,    // melanoma
		  0.041f*109357f/x,   // malignantLymphomas
		  0.036f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.023f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 95-99

    static private float incidenceFemale100(Disease dis, String set) {
	// 100-
	String disName = dis.getName();
	final float allCauses = 16593.0f - (294 + 0 + 0);

	final int septicemia = 161; // member of infections 
	if ( disName.equals(LR.septicemia)) return septicemia/allCauses;
	final int pneumoniaAspiration = 183;
	if ( disName.equals(LR. pneumoniaAspiration) ) 
	    return  pneumoniaAspiration/allCauses;
	final int influenzaPlusPneumonia = 873; // members of respiratoryDisorders
	if ( disName.equals(LR.influenza) ||
	     disName.equals(LR.pneumonia) ||
	     disName.equals(LR.pneumoniaAcute) ||
	     disName.equals(LR.pneumoniaAdenoVirus) ||
	     disName.equals(LR.pneumoniaAspiration) ||
	     disName.equals(LR.pneumoniaCytomegaloVirus) ||
	     disName.equals(LR.pneumoniaKlebsiella) ||
	     disName.equals(LR.pneumoniaStaphylococcus ) ||
	     disName.equals(LR.pneumoniaStreptococcus) )
	    return influenzaPlusPneumonia/allCauses; // divided by two?
	final int diabetesMellitus = 192;
	if ( disName.equals(LR.diabetesMellitusSuper) ||
	     disName.equals(LR.diabetesMellitus) ||
	     disName.equals(LR.diabetesMellitus2) ||
	     disName.equals(LR.diabetesMellitusAdvanced) )
	    return diabetesMellitus/allCauses;
	final int nephroticSyndrome = 299;
	if ( disName.equals(LR.nephroticSyndrome) ) 
	    return nephroticSyndrome/allCauses;
	final int alzheimer = 1235;
	if ( disName.equals(LR.alzheimer) ||
	     disName.equals(LR.alzheimer1) ||
	     disName.equals(LR.alzheimer2) ||
	     disName.equals(LR.alzheimer3) ) return alzheimer/allCauses;
	final int renalFailureAcute = 394; // ???? and/ or hypertension
	if ( disName.equals(LR.renalFailureAcute) ) 
	    return renalFailureAcute/allCauses;
	final int anemia = 55;
	if ( disName.equals(LR.anemiaFolicAcidDeficiency) ) 
	    return anemia/allCauses;
	// final int parkinson = 320;
	// if ( disName.equals(LR.parkinson) ) return parkinson/allCauses;
	//    atherosclerosis   240 1.4%
	//   nutrional deficiencies 51 0.3%
	final int cerebrovascularAccident = 1103;
	if ( disName.equals(LR.cerebrovascularAccident) ) 
	    return cerebrovascularAccident/allCauses;

	// final float geneticDisordersFrac = 249/allCauses;
	final float neoPlasmsFrac = (594+0)/allCauses;
	final float cardioDisordersFrac = 6402/allCauses;
	final float respiratoryDisordersFrac = 300/allCauses;
	// final float neurologicDisordersFrac = 1103/allCauses;
	final float residualFrac = 4217/allCauses;

	// if ( set.equals(LR.geneticDisorders) )
	//     return geneticDisordersFrac * geneticDisorders(disName);
	if ( set.equals(LR.neoPlasms) ) {
	    final float x = 2774874*0.0355f;
	    final float[] ar = new float[]
		{ 0.062f*62367f/x,    // bladder
		  0.036f*207353f*2/x, // breast
		  0.065f*280208f/x,   // colorectal
		  0.030f*72529f*2/x,  // ovary
		  0.031f*60578f/x,    // kidney
		  0.043f*107590f/x,   // leukemia
		  0.026f*450375f*2/x, // lung+bronchus
		  0.027f*38245f/x,    // melanoma
		  0.041f*109357f/x,   // malignantLymphomas
		  0.036f*151944f/x,   // pancreas
		  0.000f*150799f*2/x, // prostate
		  0.023f*61131f/x     // stomach
	    };
	    return neoPlasmsFrac * neoPlasms(disName, ar);
	}
	if ( set.equals(LR.cardioDisorders) )
	    return cardioDisordersFrac * cardioDisorders(disName);
	if ( set.equals(LR.respiratoryDisorders) )
            return respiratoryDisordersFrac * respiratoryDisorders(disName);
	// if ( set.equals(LR.neurologicDisorders) )
        //    return neurologicDisordersFrac * neurologicDisorders(disName);
	// More here

	return residualFrac * residual1;
    } // female 100-



} // end Incidence
