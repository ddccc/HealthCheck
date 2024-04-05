// Copyright OntoOO/ Dennis de Champeaux, 2011
package com;

import java.io.*;
import java.util.*;

/* This utility tool is access the auxiliary file: c:/tmp/Mort2008usOut.dat
   This file was produced by c:\ddc\Java\Mort2008us\Mort2008us.java 
   from the source file:
   c:/tmp/Mort2008us.dat
   which was obtained from the Center of Disease Control (CDC)
   on the page:
   http://www.cdc.gov/nchs/data_access/Vitalstatsonline.htm
   ftp://ftp.cdc.gov/pub/Health_Statistics/NCHS/Datasets/DVS/mortality/mort2008us.zip
   A description of the fields in that ascii file is available at:
   http://www.cdc.gov/nchs/nvss/mortality_public_use_data.htm
 */

public class Frequencies {

    private final static String fileName = "c:/tmp/Mort2008usOut.dat";
    private final static String outName = "com/incidence3";
    private static int cnt = 0;
    private static int ageMax = 120;
    private static int ageGroups = ageMax / 5;
	// int numberOfCodes = 114;
	// int numberOfCodes = 140;
    private static int numberOfCodes = 457;
    // # deaths in age group for a specific disease
    private static int [][] mGroups = new int[ageGroups][numberOfCodes];
    private static int [][] fGroups = new int[ageGroups][numberOfCodes];
    // # deaths for a specific disease and age group
    private static int [][] mCodes = new int[numberOfCodes][ageGroups];
    private static int [][] fCodes = new int[numberOfCodes][ageGroups];
    // # deaths for a specific disease per gender
    private static int [] mCodeCnt = new int[numberOfCodes];
    private static int [] fCodeCnt = new int[numberOfCodes];
    // # deaths for a specific disease sum of both genders/ for sorting
    // private static DisCount [] disCounts = new DisCount[numberOfCodes];
    // # deaths in an age bracket
    private static int [] mDeathsCnt = new int[ageGroups];
    private static int [] fDeathsCnt = new int[ageGroups];

    /*
    private static Hashtable m = new Hashtable();
    private static Hashtable f = new Hashtable();
    */
    public static void main(String[] args) {
	BufferedReader br = null;
	try { // getting a buffered reader
	    File source = new File(fileName);
	    // System.out.println("?: " + source.isFile());
	    // System.out.println("?: " + source.length());
	    FileInputStream fis = new FileInputStream(source);
	    InputStreamReader myReader = new InputStreamReader(fis); 
	    br = new BufferedReader(myReader);
	} catch (IOException ex) {
	    System.out.println("*** IO error/ bailing out");
	    System.exit(0);
	}
	/*
	PrintWriter pw = null;
	try {
	    File target = new File(outName);
	    FileOutputStream fos = new FileOutputStream(target);
	    pw = new PrintWriter(fos);
	} catch (IOException ex) {
	    System.out.println("*** IO error/ bailing out");
	    System.exit(0);
	}
	*/

	// reading lines 
	String line = null;
	StringBuffer sb = null;
	StringTokenizer st = null;
	int mCnt = 0; int fCnt = 0;
	// for ( int i = 0; i < numberOfCodes; i++ )
	//     disCounts[i] = new DisCount(i, 0);

	// while (cnt < 50) { 
	while (true) { 
	    /*
	    if ( 0 == (cnt % 50000) ) {
		System.out.println("cnt: " + cnt +
			   " cntBadManner: " + cntBadManner +
			   " m.size(): " + m.size() +
			   " f.size(): " + f.size());
	    }
	    */
	    cnt++;
	    try { line = br.readLine(); }
	    catch (IOException ex) {
		System.out.println("*** IO error/ cant read line");
		System.exit(0);
	    }
	    if ( null == line ) break;
	    // 
	    st = new StringTokenizer(line);
	    String gender = st.nextToken();
	    String ageStr = st.nextToken();
	    String ICD10 = st.nextToken();
	    String code358Str = st.nextToken();
	    String code113Str = st.nextToken();
	    int age = 0;
	    try { age = Integer.parseInt(ageStr); }
	    catch (NumberFormatException ex) {
		System.out.println("*** calc age from ageStr: " + ageStr);
		System.out.println("*** cnt: " + cnt);
		System.exit(0);
	    }
	    if ( ageMax <= age ) continue;
	    int ageBracket = age / 5;
	    int codeX = 0;
	    try { codeX = Integer.parseInt(code358Str); }
	    catch (NumberFormatException ex) {
		System.out.println("*** calc codeX from code358Str: " + 
				   code358Str);
		System.out.println("*** cnt: " + cnt);
		System.exit(0);
	    }
	    if ( gender.equals("M") ) {
		mCnt++; 
		mCodeCnt[codeX]++;
		mGroups[ageBracket][codeX]++;
		mCodes[codeX][ageBracket]++;
		// disCounts[codeX].increment();
		mDeathsCnt[ageBracket]++;
	    } else {
		fCnt++;
		fCodeCnt[codeX]++;
		fGroups[ageBracket][codeX]++;
		fCodes[codeX][ageBracket]++;
		// disCounts[codeX].increment();
		fDeathsCnt[ageBracket]++;
	    }
	} // end while
	/*
	// show males
	System.out.println("------ show males");
	for ( int i = 0; i < ageGroups; i++ ) {
	    boolean found = false;
	    for ( int j = 0; j < numberOfCodes; j++ ) {
		int z = mGroups[i][j];
		if ( 0 < z ) {
		    if ( false == found ) {
			found = true;
			sb = new StringBuffer();
		    }
		    sb.append("(" + j + " " + z + ") ");
		}
	    }
	    if ( found ) {
		System.out.print("i= " + i + " ");
		System.out.println(sb.toString());
	    }
	}
	// show females
	System.out.println("------ show females");
	for ( int i = 0; i < ageGroups; i++ ) {
	    boolean found = false;
	    for ( int j = 0; j < numberOfCodes; j++ ) {
		int z = fGroups[i][j];
		if ( 0 < z ) {
		    if ( false == found ) {
			found = true;
			sb = new StringBuffer();
		    }
		    sb.append("(" + j + " " + z + ") ");
		}
	    }
	    if ( found ) {
		System.out.print("i= " + i + " ");
		System.out.println(sb.toString());
	    }
	}
	// show male codes
	System.out.println("------ show male codes");
	for ( int j = 0; j < numberOfCodes; j++ ) {
	    boolean found = false;
	    for ( int i = 0; i < ageGroups; i++ ) {
		int z = mCodes[j][i];
		if ( 0 < z ) {
		    if ( false == found ) {
			found = true;
			sb = new StringBuffer();
		    }
		    sb.append("(" + i + " " + z + ") ");
		}
	    }
	    if ( found ) {
		System.out.print("j= " + j + " ");
		System.out.println(sb.toString());
	    }
	}
	// show female codes
	System.out.println("------ show female codes");
	for ( int j = 0; j < numberOfCodes; j++ ) {
	    boolean found = false;
	    for ( int i = 0; i < ageGroups; i++ ) {
		int z = fCodes[j][i];
		if ( 0 < z ) {
		    if ( false == found ) {
			found = true;
			sb = new StringBuffer();
		    }
		    sb.append("(" + i + " " + z + ") ");
		}
	    }
	    if ( found ) {
		System.out.print("j= " + j + " ");
		System.out.println(sb.toString());
	    }
	}
	for ( int i = 0; i < numberOfCodes; i++ ) {
	    int mc =  mCodeCnt[i]; int fc = fCodeCnt[i];
	    if ( 0 < mc || 0 < fc ) {
		System.out.print("i: " + i + " " + (mc+fc) + " ");
		if ( 0 < mc ) System.out.print("male: " + mc + " ");
		if ( 0 < fc ) System.out.print("fale: " + fc);
		System.out.println();
	    }
	}
	Arrays.sort(disCounts);
	for ( int k = 0; k < 10; k++ ) {
	    DisCount d = disCounts[k];
	    System.out.println( d.getIndex() + " " + d.getCnt() );
	}
	showDisCount(1);
	showDisCount(2);
	showDiseasesInBracket(15);
	*/
	System.out.println();
	Incidence358 in = new Incidence358();
	in.setMCodes(mCodes);
	in.setFCodes(fCodes);
	in.setMDeathsCnt(mDeathsCnt);
	in.setFDeathsCnt(fDeathsCnt);

	System.out.println("From in M: " + in.getMProbability(23, 75));
	System.out.println("From in F: " + in.getFProbability(23, 75));

	// Save 'in'
	FileOutputStream fos = null;
	ObjectOutputStream oos = null;
	try { 
	    fos = new FileOutputStream(outName);
	    oos = new ObjectOutputStream(fos);
	    oos.writeObject(in);
	    oos.close();
	    fos.close();
	} catch (IOException ex) {
	  System.out.println("*** IOException writing: 'in': " + 
			     ex.getMessage());
	}

	/*
	pw.flush();
	pw.close();
	*/
	System.out.println("\ncnt: " + cnt + " " +
			   "mCnt: " + mCnt + " " +
			   "fCnt: " + fCnt);
    } // end of main
    /*
    // show for a disease k how many times it occurs in all age brackets
    // first for male and subsequently for fale.
    // a list is made with triplets (A B C)
    // A = age bracket
    // B = total number of deaths in this bracket
    // C = # of deaths in this bracket due to disease k 
    private static void showDisCount(int k) {
	System.out.println("\n showDisCount k: " + k);
	StringBuffer sb = null;
	DisCount d = disCounts[k];
	int j = d.getIndex();
	boolean found = false;
	for ( int i = 0; i < ageGroups; i++ ) {
	    int z = mCodes[j][i];
	    if ( 0 < z ) {
		if ( false == found ) {
		    found = true;
		    sb = new StringBuffer();
		}
		sb.append("(" + i + " " + 
			  mDeathsCnt[i] + " " +
			  z + ") ");
	    }
	}
	if ( found ) {
	    System.out.print("Male j= " + j + " ");
	    System.out.println(sb.toString());
	}
	found = false;
	System.out.println("-----------");
	for ( int i = 0; i < ageGroups; i++ ) {
	    int z = fCodes[j][i];
	    if ( 0 < z ) {
		if ( false == found ) {
		    found = true;
		    sb = new StringBuffer();
		}
		sb.append("(" + i + " " + 
			  fDeathsCnt[i] + " " +
			  z + ") ");
	    }
	}
	if ( found ) {
	    System.out.print("Fale j= " + j + " ");
	    System.out.println(sb.toString());
	}
    } // end showDisCount(int k)

    private static void showDiseasesInBracket(int bracket) {
	System.out.println("\nshowDiseasesInBracket: " + bracket);
	float mDeaths =  (float) mDeathsCnt[bracket];
	float fDeaths =  (float) fDeathsCnt[bracket];
	System.out.println("Male deaths: " + mDeaths + " " +
			   "Fale deaths: " + fDeaths);
	for ( int c = 0; c < numberOfCodes; c++ ) {
	    int z = mGroups[bracket][c];
	    if (0 < z) 
		System.out.println(c + " " + 
				   mGroups[bracket][c]/mDeaths);
	}
	for ( int c = 0; c < numberOfCodes; c++ ) {
	    int z = fGroups[bracket][c];
	    if (0 < z) 
		System.out.println(c + " " + 
				   fGroups[bracket][c]/fDeaths);
	}
    } // end showDiseasesInBracket(int bracket)
    */

} // end of Mort2008us

/*
class Incidence3 implements Serializable {
    private static final int ageMax = 120;
    private static final int ageGroups = ageMax / 5;
    private static final int numberOfCodes = 457;
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
	return ((float) mCodes[diseaseCode][ageBracket])/ mDeathsCnt[ageBracket];
    }
    public float getFProbability(int diseaseCode, int age) {
	return  getFProbabilityB(diseaseCode, age/5);
    }
    private float getFProbabilityB(int diseaseCode, int ageBracket) {
	return ((float) fCodes[diseaseCode][ageBracket])/ fDeathsCnt[ageBracket];
    }
} // end Incidence3
*/

/*
class DisCount implements Comparable {
    private int index;
    private int cnt;
    public DisCount(int index, int cnt) {
	this.index = index;
	this.cnt = cnt;
    }
    public int getIndex() { return index; }
    public int getCnt() { return cnt; }
    public void increment() { cnt++; }
    public int compareTo(Object o) {
	DisCount d = (DisCount) o;
	int di = d.getCnt();
	return ( di == cnt ? 0 :
		 ( cnt < di ? +1 : -1 ) );
    }
}

class ICD10 {
    private String name;
    private int[] ageBrackets = new int[21];
    
    public ICD10(String name) {
	this.name = name;
    }
    public String getName() { return name; }
    public int getAgeBracket(int i) {
	if ( i < 0 || 20 < i ) {
	    System.out.println("*** getAgeBracket i: " + i);
	    i = 0;
	}
	return ageBrackets[i];
    }
    public void incrementAgeBracket(int age) {
	if ( age < 0 ) {
	    System.out.println("*** incrementAgeBracket age: " + age);
	    age = 0;
	}
	int i = age/5;
	if ( 20 < i ) i = 20;
	ageBrackets[i]++;
    }
}
*/
