// (C) OntoOO Inc 2007 Jun
package com;

import concepts.*;
import init.*;

import java.util.*;
import java.io.*;



public class ZZ {

public static void main (String [] arguments) {

    CreateMaleFemaleSymptoms();


} // end of main


static public void CreateMaleFemaleSymptoms() {

	String [] allSymptoms = Common.allSymptoms();
	int lng = allSymptoms.length;
	HashSet maleSymptoms = new HashSet();
	HashSet femaleSymptoms = new HashSet();
	String symp, locationSt, gender;
	Symptom symptom;
	Vector theDiseases;
	PartOfLocation location;
	String aDiseaseName;
	Disease aDisease;
	int minAge, maxAge;
	boolean none; 
	boolean premenstruating;
	boolean menstruating;
	boolean pregnant;
	boolean menopause;
	boolean postmenopause;
	boolean male;
	boolean female;
	// for (int i = 0; i < lng; i++) {
	//    symp = allSymptoms[i];
	symp = "vaginaItching";
	    symptom = Common.getSymptom(symp);
	    theDiseases = symptom.getTheDiseases();
	    // if ( theDiseases.size() <= 0 ) continue; // ignore these
	    // investigate here whether we can specialize this symptom
	    theDiseases = (Vector) theDiseases.clone();
	    minAge = LR.maxAge;
	    maxAge = 0;
	    none = false; 
	    male = true;
	    female = true;
	    premenstruating = false; 
	    menstruating = false;
	    pregnant = false;
	    menopause = false;
	    postmenopause = false;
	    for (int j = 0; j < theDiseases.size(); j++) {
		aDiseaseName = (String) theDiseases.elementAt(j);
		aDisease = Common.getDisease(aDiseaseName);
		int minAge2 = aDisease.getMinAge();
		int maxAge2 = aDisease.getMaxAge();
		String statusCondition2 = aDisease.getStatusCondition();
		System.out.println("** aDiseaseName : " + aDiseaseName + 
				   " statusCondition2: " + statusCondition2);
		Vector subDiseases = aDisease.getSubDiseases();
		for (int k = 0; k < subDiseases.size(); k++) 
		    theDiseases.addElement(subDiseases.elementAt(k));
		gender = aDisease.getGenderSpecificity();
		if ( gender.equals(LR.male) )
		    female = false;
		else
		if ( gender.equals(LR.female) )
		    male = false;
		else { // we find a disease that is NOT gender specific, thus the symptom 
		       // is not gender specific regarding the diseases it is occurring in
		    female = false;
		    male = false;
		}
		if ( minAge2 < minAge ) minAge = minAge2;
		if ( maxAge < maxAge2 ) maxAge = maxAge2;
		if ( statusCondition2.equals("none") ) { none = true; continue; }
		if ( statusCondition2.equals("premenstruating") ) { premenstruating = true; continue; }
		if ( statusCondition2.equals("menstruating") ) { menstruating = true; continue; }
		if ( statusCondition2.equals("pregnant") ) { pregnant = true; continue; }
		if ( statusCondition2.equals("menopause") ) { menopause = true; continue; }
		if ( statusCondition2.equals("postmenopause") ) { postmenopause = true; continue; }
		// }
	    }
	    // none = ( !male && !female );
	    // adjust in symptom minAge, maxAge, statusCondition ...
	    symptom.setMinAge(minAge);
	    // if (0 < minAge) System.out.println("** Symptom: " + symp + " minAge: " + minAge);
	    symptom.setMaxAge(maxAge);
	    // if (maxAge < LR.maxAge) System.out.println("** Symptom: " + symp + " maxAge: " + maxAge);
	    // narrow down statusCondition if warranted
	    if ( female ) {
		if ( none ) { 
		    symptom.setStatusCondition("none");
		}
		else
		if ( premenstruating && !menstruating && !pregnant && !menopause && !postmenopause ) {
		    symptom.setStatusCondition("premenstruating");
		}
		else
		if ( !premenstruating && menstruating && !pregnant && !menopause && !postmenopause ) {
		    symptom.setStatusCondition("menstruating");
		}
		else
		if ( !premenstruating && !menstruating && pregnant && !menopause && !postmenopause ) {
		    symptom.setStatusCondition("pregnant");
		}
		else
		if ( !premenstruating && !menstruating && !pregnant && menopause && !postmenopause ) {
		    symptom.setStatusCondition("menopause");
		}
		else
		if ( !premenstruating && !menstruating && !pregnant && !menopause && postmenopause ) {
		    symptom.setStatusCondition("postmenopause");
		}
	    }
	    // /*
	      String statusCondition = symptom.getStatusCondition();
	      System.out.println("** Symptom: " + symp + " statusCondition: " + statusCondition);
	      // */



    } // end CreateMaleFemaleSymptoms()



} // end class ZZ
