// (C) OntoOO Inc 2007
package init;

import com.Common;
import com.D;
import com.LR;
import concepts.DiseaseSet;
import concepts.Disease;
import concepts.WeightedSymptom;
import concepts.Treatment;
import concepts.TreatmentAction;
import concepts.Drug;

import java.util.Vector;
import java.util.HashSet;
// import java.util.Properties;
// import java.util.Enumeration;
import java.io.*;

public class GenDiseases {

public static void main (String [] arguments) 
    throws Exception     {
    String [] allDiseaseSets = Common.allDiseaseSets();
    int lng = allDiseaseSets.length;
    // File genDiseases = new File("./init/GenDiseases2.java");
    File genDiseases = new File(D.applRoot2 + "/init/GenDiseases2.java");
    FileOutputStream fos = new FileOutputStream(genDiseases);
    PrintWriter ps = new PrintWriter(fos);

    ps.println("// (C) OntoOO 2011");
    // ps.println("/*");
    ps.println("package init;");
    ps.println("import com.D;");
    ps.println("import com.L;");
    ps.println("import com.F;");
    ps.println("import com.LR;");
    ps.println("import concepts.Disease;");
    ps.println("import concepts.Treatment;");
    // ps.println("*/");
    ps.println("public class GenDiseases2 {");
    ps.println("  public static void doit() {");

    File genDiseasesStr = new File("L2.java");
    FileOutputStream fosStr = new FileOutputStream(genDiseasesStr);
    PrintWriter psStr = new PrintWriter(fosStr);
    psStr.println("public interface L2 {");

    String disSetName, disName, diseasePrintName, description, miscComment,
	webResource, pnLabel, descriptionLabel, miscCommentLabel, genetic, 
	disNameDis, superDisease, underlyingDisease;
    DiseaseSet disSet;
    Disease dis;
    HashSet tokenSet = new HashSet();

    for (int i = 0; i < lng ; i++) {
	disSetName = allDiseaseSets[i];
	if ( disSetName.equals(LR.lifeThreateningDisorders) ) continue;
	if ( disSetName.equals(LR.respiratoryTractInfections) ) continue;
	//	ps.println("// ------------- " + disSetName + "  -------------");
	ps.println("   " + disSetName + "();");
    }
    ps.println("} // end of doit");

    for (int i = 0; i < lng ; i++) {
	disSetName = allDiseaseSets[i];
	if ( disSetName.equals(LR.lifeThreateningDisorders) ) continue;
	if ( disSetName.equals(LR.respiratoryTractInfections) ) continue;
	ps.println();
	ps.println();
	ps.println("// ------------- " + disSetName + "  -------------");
	ps.println("static public void " + disSetName + "() { ");
	psStr.println("// ------------- " + disSetName + "  -------------");
	psStr.println();
	psStr.println();
	disSet = Common.getDiseaseSet(disSetName);
	Vector diseaseMembers = disSet.getDiseaseMembers();
	int lng2 = diseaseMembers.size();
	for (int j = 0; j < lng2; j++) {
	    disName = (String) diseaseMembers.elementAt(j);
	    disNameDis = disName + "Dis";
	    dis = Common.getDisease(disName);
	    diseasePrintName = dis.getPrintName();
	    description = dis.getDescription();	
	    /*    
	    if ( 0 <= description.indexOf("=") ) 
		System.out.println(disName + "/" + description);
	    */
	    miscComment = dis.getMiscComments();
	    webResource = dis.getWebResource();

	    pnLabel = disName + "PrintName";
	    descriptionLabel = disName + "Description";
	    miscCommentLabel = disName + "Comment";

	    psStr.println();
	    psStr.println("// " + disName);
	    psStr.println("final static String " + pnLabel + 
			  " = \"" + diseasePrintName + "\";");
	    if ( diseasePrintName.equals(description) ) 
		psStr.println("final static String " + descriptionLabel + 
			      " = " + pnLabel + ";");
	    else 
		psStr.println("final static String " + descriptionLabel + 
			      " = \"" + description + "\";");
	    if ( null != miscComment )
		psStr.println("final static String " + miscCommentLabel + 
			  " = \"" + miscComment + "\";");

	    Vector vec = dis.getExternalCauses0();
	    int lngVec = vec.size();

	    int frequency = dis.getFrequency();
	    String frequencyStr = ( -1 == frequency ? ""+frequency : "F." + disName + "Freq" );
	    ps.println();
	    ps.println();
	    ps.println("// ------------- " + disName + "  -------------");
	    ps.println("Disease " + disNameDis + " = new Disease(");
	    ps.println("    LR." + disName + ",");
	    ps.println("    L." + descriptionLabel + ",");
	    ps.println("    LR." + dis.getDiseaseSet() + ",");
	    ps.println("    LR." + eliminateSpace(dis.getGenderSpecificity()) + ", // genderSpecificity");
	    ps.println("    LR." + eliminateSpace(dis.getRaceSpecificity()) + ", // raceSpecificity");
	    ps.println("    " + dis.getMinAge() + ", // minAge");
	    ps.println("    " + dis.getMaxAge() + ", // maxAge");
	    ps.println("    " + dis.getDuration() + ", // duration");
	    ps.println("    " + frequencyStr + ", // diagnosis frequency, -1 = unknown"); 
	    ps.println("    LR." + dis.getBodySystem() + "St,");
	    if ( 0 == lngVec ) 
		ps.println("    LR.none");
	    else {
		String str =  eliminateSpace( (String) vec.elementAt(0) );
		ps.println("    LR." + str);
	    }
	    ps.println(");");
	    ps.println(disNameDis + ".setPrintName(L." + pnLabel + ");");
	    superDisease = dis.getSuperDisease();
	    if ( null != superDisease )
		ps.println(disNameDis + ".setSuperDisease(LR." + superDisease + ");");
	    underlyingDisease = dis.getUnderlyingDisease();
	    if ( null != underlyingDisease )
		ps.println(disNameDis + ".setUnderlyingDisease(LR." + underlyingDisease + ");");
	    if ( null != miscComment )
		ps.println(disNameDis + ".setMiscComments(L." + miscCommentLabel + ");");
	    if ( null != webResource ) 
		ps.println(disNameDis + ".setWebResource(\"" +
			   webResource + "\");");
	    for ( int k = 1; k < lngVec; k++) {
		String str = (String) vec.elementAt(k);
		ps.println(disNameDis + 
			   ".addExternalCause(LR." + 
			   eliminateSpace(str) + ");");
	    }
	    genetic = dis.getGenetic();
	    if ( !genetic.equals("none") ) {
		ps.println(disNameDis + ".setGenetic(\"" + genetic + "\");");
		ps.println(disNameDis + 
			   ".setParentDisease(LR." + 
			   dis.getParentDisease() + ");");
	    }
	    float temp = dis.getTemperature0();
	    if ( (float)99.3 != temp ) {
		ps.println(disNameDis + ".setTemperature(" + temp + "f);");
	    }
	    int code358 = dis.getCode358();
	    if ( 0 < code358) 
		ps.println(disNameDis + ".setCode358(" + code358 + ");");
	    String ICD10code = dis.getICD10code();
	    if ( null != ICD10code) 
		ps.println(disNameDis + ".setICD10code(\"" + ICD10code + "\");");
	    vec = dis.getInternalCauses0();
	    lngVec = vec.size();
	    for ( int k = 0; k < lngVec; k++) {
		String str = (String) vec.elementAt(k);
		ps.println(disNameDis + ".addInternalCause(LR." + str + ");");
	    }
	    vec = dis.getCausingAbnormalConditions0();
	    lngVec = vec.size();
	    for ( int k = 0; k < lngVec; k++) {
		String str = (String) vec.elementAt(k);
		ps.println(disNameDis + ".addCausingAbnormalCondition(LR." + str + ");");
	    }
	    vec = dis.getCausingSets();
	    lngVec = vec.size();
	    for ( int k = 0; k < lngVec; k++) {
		String str = (String) vec.elementAt(k);
		ps.println(disNameDis + ".addCausingSet(LR." + str + ");");
	    }
	    vec = dis.getCausesDiseases0();
	    lngVec = vec.size();
	    for ( int k = 0; k < lngVec; k++) {
		String str = (String) vec.elementAt(k);
		ps.println(disNameDis + ".addCausesDisease(LR." + str + ");");
	    }
	    vec = dis.getCausesAbnormalConditions0();
	    lngVec = vec.size();
	    for ( int k = 0; k < lngVec; k++) {
		String str = (String) vec.elementAt(k);
		ps.println(disNameDis + ".addCausesAbnormalCondition(LR." + str + ");");
	    }
	    vec = dis.getLiterature();
	    lngVec = vec.size();
	    for ( int k = 0; k < lngVec; k++) {
		String str = (String) vec.elementAt(k);
		ps.println(disNameDis + ".addReference(\"" + str + "\");");
	    }
	    vec = dis.getIllustrations();
	    lngVec = vec.size();
	    for ( int k = 0; k < lngVec; k++) {
		String str = (String) vec.elementAt(k);
		int begin = str.lastIndexOf('/');
		int end = str.indexOf('.');
		String fileName = str.substring(begin + 1,end);
		String fileExt = str.substring(end + 1);
		if ( fileExt.equals("gif") )
		    fileExt = "Gif";
		else
		if ( fileExt.equals("jpg") )
		    fileExt = "Jpg";
		else 
		    System.out.println("*** " + disName + 
				       " unexpected file extension: " + fileExt);
		String ref = "D." + fileName + fileExt;
		ps.println(disNameDis + ".addIllustration(" + ref + ");");
	    }
	    vec = dis.getSymptoms0();
	    lngVec = vec.size();
	    for ( int k = 0; k < lngVec; k++) {
		WeightedSymptom ws = (WeightedSymptom) vec.elementAt(k);
		String sym = ws.getSymptom();
		float weight = ws.getWeight();
		String elaboration = ws.getElaboration();
		if ( elaboration.equals("") ) {
		    if ( 1.0 == weight ) 
			ps.println(disNameDis + ".addSymptom(LR." + sym + ");");
		    else
			ps.println(disNameDis + 
				   ".addSymptom(LR." + sym + 
				   ", \"\", " + weight + "f);");
		} else { 
		    String str = disName + "_" + sym;
		    ps.println(disNameDis + 
			       ".addSymptom(LR." + sym + 
			       ", L." + str + ", " + weight + "f);");
		    psStr.println("final static String " + str + 
			      " = \"" + elaboration + "\";");
		}
	    }
	    vec = dis.getTreatments0();
	    lngVec = vec.size();
	    for ( int k = 0; k < lngVec; k++) {
		String token = (String) vec.elementAt(k);
		if ( tokenSet.contains(token) ) continue;
		tokenSet.add(token);
		Treatment tr = Common.getTreatment(token);
		String condition = tr.getCondition();
		ps.println("Treatment " + token + 
		      " = new Treatment(\"" + token + "\"" +
		      ( null == condition ? "" :
			", LR." + eliminateSpace(condition) ) +
		      ");");
		Vector vec2 = tr.getTreatmentActions();
		int lngVec2 = vec2.size();
		for (int m = 0; m<lngVec2; m++) {
		    TreatmentAction tac = (TreatmentAction) vec2.elementAt(m);
		    String veci = tac.getDescription();
		    ps.println(token + ".addTreatmentAction(LR." +
			      eliminateSpace(veci) + ");");
		}
		vec2 = tr.getDrugs();
		lngVec2 = vec2.size();
		for (int m = 0; m<lngVec2; m++) {
		    /*
		    Drug drug = (Drug) vec2.elementAt(m);
		    String veci = drug.getDescription();
		    ps.println(token + ".addDrug(LR." +
			       eliminateSpace(veci) + ");");
		    */
		    ps.println(token + ".addDrug(LR." +
			       ((String) vec2.elementAt(m)) + ");");
		}
		ps.println(disNameDis + ".addTreatment(\"" + token + "\");");
	    }
	}
	ps.println("} // end of " + disSetName);

	ps.println();
	ps.println();
	ps.println();
	psStr.println();
	psStr.println();
	psStr.println();
    }
    ps.println("}");
    ps.flush();ps.close();
    psStr.println("}");
    psStr.flush();psStr.close();
} // end of main

    private static String eliminateSpace(String str) {
	return Common.eliminateSpace(str);
    }

} // end class GenDiseases


