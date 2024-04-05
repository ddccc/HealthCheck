// Copyright OntoOO/ Dennis de Champeaux, 2011
package com;
import java.io.*;

import concepts.Disease;

public class Incidence358 implements Serializable {
    private static final int ageMax = 120;
    private static final int ageGroups = ageMax / 5;
    private static final int numberOfCodes = 457;

    static private Incidence358 incidence3 = null; 
    static public float incidence(String gender, int age, String disName) {
	if ( null == incidence3 ) {
	    try {
		FileInputStream fis = 
		    new FileInputStream(D.theConceptsDir + "incidence3");
		ObjectInputStream ois = new ObjectInputStream(fis);
		incidence3 = (Incidence358) ois.readObject();
		ois.close();
		fis.close();
	    } catch (Exception ex) {
		System.out.println(ex.getMessage());
		ex.printStackTrace();
		// throw exception
	    }
	}
	if ( null == incidence3 ) return 0;
	Disease dis = Common.getDisease(disName);
	int diseaseCode = dis.getCode358();
	if ( gender.equals(LR.male) ) 
	    return incidence3.getMProbability(diseaseCode, age);
	else 
	    return incidence3.getFProbability(diseaseCode, age);
    }


    // # deaths for a specific disease and age group
    private int [][] mCodes = new int[numberOfCodes][ageGroups];
    private int [][] fCodes = new int[numberOfCodes][ageGroups];
    // # deaths in an age bracket
    private int [] mDeathsCnt = new int[ageGroups];
    private int [] fDeathsCnt = new int[ageGroups];
    // set them
    public void setMCodes(int [][] mCodes) { this.mCodes = mCodes; }
    public void setFCodes(int [][] fCodes) { this.fCodes = fCodes; }
    public void setMDeathsCnt(int [] mDeathsCnt) { this.mDeathsCnt = mDeathsCnt; }
    public void setFDeathsCnt(int [] fDeathsCnt) { this.fDeathsCnt = fDeathsCnt; }
    // to get the data
    public float getMProbability(int diseaseCode, int age) {
	return  getMProbabilityB(diseaseCode, age/5);
    }
    private float getMProbabilityB(int diseaseCode, int ageBracket) {
	float a = ((float) mCodes[diseaseCode][ageBracket]);
	int b =  mDeathsCnt[ageBracket];
	float c = a/ b;
	// System.out.println(a + " " + b + " " + c);
	return c;
	// return ((float) mCodes[diseaseCode][ageBracket])/ mDeathsCnt[ageBracket];
    }
    public float getFProbability(int diseaseCode, int age) {
	return  getFProbabilityB(diseaseCode, age/5);
    }
    private float getFProbabilityB(int diseaseCode, int ageBracket) {
	return ((float) fCodes[diseaseCode][ageBracket])/ fDeathsCnt[ageBracket];
    }
} // end Incidence358
