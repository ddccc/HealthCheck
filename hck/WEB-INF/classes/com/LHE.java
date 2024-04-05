// (C) OntoOO Inc 2007
package com;

import java.util.Vector;
import java.io.*;

public class LHE implements Serializable {
    // LHE = LocationHierarchyElement

    private String locStr = null;
    private String gender = null;
    private String printName = null;
    private Vector symptoms = null;
    private int level = 0;
    public LHE(String locStr, String printName, String gender,
	       Vector symptoms, int level) {
	this.locStr = locStr;
	this.printName = printName;
	this.gender = gender;
	this.symptoms = symptoms;
	this.level = level;
    }
    public String getLocStr() { return locStr; }
    public String getPrintName() { return printName; }
    public String getGender() { return gender; }
    public Vector getSymptoms() { return symptoms; }
    public int getLevel() { return level; }

}
