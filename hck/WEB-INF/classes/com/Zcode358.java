// (C) OntoOO/ Dennis de Champeaux 2011 December
package com;

import java.util.*;
import java.io.*;

import com.Common;
import concepts.Disease;

public class Zcode358 {
    public static void main (String [] arguments) {
	int cnt = 0;
	int lng = 450;
	boolean [] hits = new boolean [lng];
	String [] allDiseases = Common.allDiseases();
	int lng2 = allDiseases.length;
	Disease disease;
	for (int i = 0; i < lng2; i++) {
	    String dis = allDiseases[i];
	    disease = Common.getDisease(dis);
	    hits[disease.getCode358()] = true;
	}
	for (int i=0; i < lng; i++) {
	    if ( 0 == i%10 ) System.out.println();
	    if ( hits[i] ) { 
		System.out.print(i + " ");
		cnt++;
	    }
	}
	System.out.println();
	System.out.println("cnt: " + cnt);
    } // end of main
} // end Zcode358
