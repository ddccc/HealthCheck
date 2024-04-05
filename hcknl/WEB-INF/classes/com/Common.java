// (C) OntoOO Dennis de Champeaux 2000, 2012
package com;

import java.util.*;
import java.io.*;
import concepts.*;
import patient.DiseaseInst;
import java.text.SimpleDateFormat;
import java.text.DateFormat;


public class Common {

  // ------------------- Utilities -------------------------

  static public String unPolish(String in) {
    boolean change = false;
    StringBuffer sb = new StringBuffer(in);
    char sbi, sbi2;
    int lng = sb.length();
    for ( int i = lng - 1; 0 <= i; i--) {
      sbi = sb.charAt(i);
      if ( Character.isUpperCase(sbi) ) {
	change = true;
	sbi2 = Character.toLowerCase(sbi);
	sb.setCharAt(i,sbi2);
	sb.insert(i,' ');
      }
    }
    return ( change ? sb.toString() : in );
  }

  static public String unPolish2(String in) {
      if ( in.equals(in.toUpperCase()) ) return in;
      return unPolish(in);
  }


  // this will "polish" a string with spaces/ the inverse is Common.unPolish
  static public String eliminateSpace(String in) {
    int ix = in.indexOf(' ');
    if ( ix < 0 ) return in;
    return eliminateSpace(
	in.substring(0, ix) +
	Character.toUpperCase(in.charAt(ix+1)) +
	in.substring(ix+2) );
  }


  public static String normalizedDate() {
    Date aDate = new Date();
    return Long.toString(aDate.getTime());
  } // end of normalizeDate()

  // infrastructure for ZInitTrace.txt
  private static FileOutputStream fos = null;
  private static PrintStream out = null;
  private static void createFOS() {
    if (fos == null) 
      try { fos = new FileOutputStream(D.zInitTrace);
    } catch (IOException ex) {
      System.out.println("*** createFOS: " + ex.getMessage());
      ex.printStackTrace();
    }
  }
  private static void createPS() {
    createFOS();
    if (null == fos) {
      System.out.println("Can't create zInitTrace");
      return;
    }
    if (null == out) 
      out = new PrintStream(fos);
  }
  public static void println(String string) {
    createPS();
    out.println(string);
  }
  public static void print(String string) {
    createPS();
    out.print(string);
  }
    /*
  private static StringBuffer sortVec(Vector vec, String prefix) {
    String [] strings = new String[lng];
    vec.copyInto(strings);
    Arrays.sort(strings);
    for (int i = 0; i < lng; i++) { vec.setElementAt(strings[i], i); }
    Collections.sort(vec);
    return new StringBuffer("<tr><td><b>" + prefix + "</b></td><td>");
  }
    */

  public static String htmlVector(Vector vec, String prefix) {
    int lng = vec.size();
    if ( 0<lng) {
      // sortVec(vec, prefix);
      StringBuffer sb = new StringBuffer("<tr><td><b>" + prefix + "</b></td><td>");
      Collections.sort(vec);
      String str;
      for (int i = 0; i < lng; i++) {
	str = (String) vec.elementAt(i);
	sb.append(" " + str);
      }
      sb.append("</td></tr>\n");
      return sb.toString();
    } else return "";
  }

    /*
  public static String htmlVectorX(Vector vec, String prefix,
				   String servlet) {
    int lng = vec.size();
    if ( 0<lng) {
      StringBuffer sb = sortVec(vec, prefix);
      String str;
      for (int i = 0; i < lng; i++) {
	str = (String) vec.elementAt(i);
	sb.append(
	//   " <a href='/servlet/ShowBodySystem?bs=" + str + "'>" +
	//   " <a href='/servlet/" + servlet + str + "'>" +
	     " <a href='" + servlet + str + "'>" +

	     Common.unPolish(str) + "</a>");
      }
      return sb.toString();
    } else return "";
  }
    */

  public static String htmlVectorBS(Vector vec, String prefix) {
      //    return htmlVectorX(vec, prefix, D.servletShowBodySystem + "?bs=");
      int lng = vec.size();
      if ( 0<lng) {
	  String servlet = D.servletShowBodySystem + "?bs=";
	  // StringBuffer sb = sortVec(vec, prefix);
	  StringBuffer sb = new StringBuffer("<tr><td><b>" + prefix + "</b></td><td>");
	  Collections.sort(vec);
	  String str;
	  for (int i = 0; i < lng; i++) {
	      str = (String) vec.elementAt(i);
	      BodySystem bs = Common.getBodySystem(str);
	      sb.append(
			//   " <a href='/servlet/ShowBodySystem?bs=" + str + "'>" +
			//   " <a href='/servlet/" + servlet + str + "'>" +
			" <a href='" + servlet + str + "'>" +
			bs.getPrintName() + "</a>");
	  }
	  sb.append("</td></tr>\n");
	  return sb.toString();
      } else return "";
  }

  public static String htmlVectorLOC(Vector vec, String prefix) {
      // return htmlVectorX(vec, prefix, D.servletShowLocation + "?loc=");
      int lng = vec.size();
      if ( 0<lng) {
	  String servlet = D.servletShowLocation + "?loc=";
	  // StringBuffer sb = sortVec(vec, prefix);
	  StringBuffer sb = new StringBuffer("<tr><td><b>" + prefix + "</b></td><td>");
	  Collections.sort(vec);
	  String str;
	  for (int i = 0; i < lng; i++) {
	      str = (String) vec.elementAt(i);
	      Location bs = Common.getLocation(str);
	      sb.append(
			" <a href='" + servlet + str + "'>" +
			bs.getPrintName() + "</a>");
	  }
	  sb.append("</td></tr>\n");
	  return sb.toString();
      } else return "";
  }

  public static String htmlVectorAC(Vector vec, String prefix) {
      //    return htmlVectorX(vec, prefix, D.servletShowAbnormalCondition + "?ac=");
      int lng = vec.size();
      if ( 0<lng) {
	  String servlet = D.servletShowAbnormalCondition + "?ac=";
	  // StringBuffer sb = sortVec(vec, prefix);
	  StringBuffer sb = new StringBuffer("<tr><td><b>" + prefix + "</b></td><td>");
	  Collections.sort(vec);
	  String str;
	  for (int i = 0; i < lng; i++) {
	      str = (String) vec.elementAt(i);
	      AbnormalCondition bs = Common.getAbnormalCondition(str);
	      sb.append(
			" <a href='" + servlet + str + "'>" +
			bs.getPrintName() + "</a>");
	  }
	  sb.append("</td></tr>\n");
	  return sb.toString();
      } else return "";
  }

  public static String htmlVectorSY(Vector vec, String prefix) {
      //    return htmlVectorX(vec, prefix, D.servletShowSymptom + "?sym=");
      int lng = vec.size();
      if ( 0<lng) {
	  String servlet = D.servletShowSymptom + "?sym=";
	  // StringBuffer sb = sortVec(vec, prefix);
	  StringBuffer sb = new StringBuffer("<tr><td><b>" + prefix + "</b></td><td>");
	  Collections.sort(vec);
	  String str;
	  for (int i = 0; i < lng; i++) {
	      str = (String) vec.elementAt(i);
	      Symptom bs = Common.getSymptom(str);
	      sb.append(
			" <a href='" + servlet + str + "'>" +
			bs.getPrintName() + "</a>");
	  }
	  sb.append("</td></tr>\n");
	  return sb.toString();
      } else return "";
  }

  public static String htmlVectorDI(Vector vec, String prefix) {
      // return htmlVectorX(vec, prefix, D.servletShowDisease + "?dis=");
      int lng = vec.size();
      if ( 0<lng) {
	  String servlet = D.servletShowDisease + "?dis=";
	  // StringBuffer sb = sortVec(vec, prefix);
	  StringBuffer sb = new StringBuffer("<tr><td><b>" + prefix + "</b></td><td>");
	  Collections.sort(vec);
	  String str;
	  for (int i = 0; i < lng; i++) {
	      str = (String) vec.elementAt(i);
	      Disease bs = Common.getDisease(str);
	      boolean lt = bs.isLifeThreatening();
	      sb.append(
			" <a href='" + servlet + str + "'>" +
			(lt ? "<font color=\"#ff0000\">" : "") +
			bs.getPrintName() + 
			(lt ? "</font>" : "") +
			"</a>");
	  }
	  sb.append("</td></tr>\n");
	  return sb.toString();
      } else return "";
  }

  public static String htmlVectorDISet(Vector vec, String prefix) {
      //    return htmlVectorX(vec, prefix, D.servletShowDiseaseSet + "?dis=");
      int lng = vec.size();
      if ( 0<lng) {
	  String servlet = D.servletShowDiseaseSet + "?dis=";
	  // StringBuffer sb = sortVec(vec, prefix);
	  StringBuffer sb = new StringBuffer("<tr><td><b>" + prefix + "</b></td><td>");
	  Collections.sort(vec);
	  String str;
	  for (int i = 0; i < lng; i++) {
	      str = (String) vec.elementAt(i);
	      DiseaseSet bs = Common.getDiseaseSet(str);
	      sb.append(
			" <a href='" + servlet + str + "'>" +
			bs.getPrintName() + "</a>");
	  }
	  sb.append("</td></tr>\n");
	  return sb.toString();
      } else return "";
  }

  static public boolean included(String loc1, String loc2) { 
    if ( loc1.equals(loc2) ) return true;
    if ( loc1.equals("body") ) return false;
    PartOfLocation loc1Loc = (PartOfLocation) Common.getLocation(loc1);
    LocationRelation partOf = loc1Loc.getPartOf();
    if ( null == partOf ) return false;
    return included(partOf.getLocationName1(), loc2);
  }

  static public boolean included(Vector locations, String loc2) {
    int lng = locations.size();
    String loc1;
    for (int i = 0; i < lng; i++) {
      loc1 = (String) locations.elementAt(i);
      if ( included(loc1, loc2) ) return true;	
    }
    return false;
  }

  static public boolean member(String loc1, Vector locations) {
    return locations.contains(loc1);
  }

  static public void remove(String str, Vector vec) {
    vec.removeElement(str);
  }
	  
  static public boolean isDiseaseMember(String disease, Vector diseases) {
    DiseaseInst di = findDiseaseMember(disease, diseases);
    return ( null == di ? false : true );
  }

  static public DiseaseInst findDiseaseMember(String disease, Vector diseases) {
    int lng = diseases.size();
    for (int i = 0; i < lng; i++) {
      DiseaseInst di = (DiseaseInst) diseases.elementAt(i);
      if ( disease.equals(di.getDisease()) ) return di;
    }
    return null;
  }

  // ------------------- Initialization -------------------------

  static public void resetHashTables() {
    setTheLocationsLoaded(false);
    theLocations = null;
    setTheBodySystemsLoaded(false);
    theBodySystems = null;
    setTheDiseasesLoaded(false);
    theDiseases = null;
    setTheDiseaseSetsLoaded(false);
    theDiseaseSets = null;
    setTheSymptomsLoaded(false);
    theSymptoms = null;
    setTheTreatmentsLoaded(false);
    theTreatments = null;
    setTheAbnormalConditionsLoaded(false);
    theAbnormalConditions = null;
    setTheExternalCausesLoaded(false);
    theExternalCauses = null;
    setTheTreatmentConditionsLoaded(false);
    theTreatmentConditions = null;
    setTheTreatmentActionsLoaded(false);
    theTreatmentActions = null;
    setTheDrugsLoaded(false);
    theDrugs = null;
    setTheXWordsLoaded(false);
    theXWords = null;
  }

  static public void saveHashTables() {
    System.out.println("--- Enter Common.saveHashTables()");
    saveTheLocations();
    saveTheBodySystems();
    saveTheSymptoms();
    saveTheAbnormalConditions();
    saveTheDiseases();
    saveTheDiseaseSets();
    saveTheTreatments();
    saveTheExternalCauses();
    saveTheTreatmentConditions();
    saveTheTreatmentActions();
    saveTheDrugs();
    saveTheXWords();
    saveTheDiseasesForShow();
    System.out.println("--- Exit Common.saveHashTables()");
  }


  // ---------------------- Location  -----------------------------------

  // location name to Location
  private static Hashtable theLocations = null;
  private static Hashtable allLocs = null;
  public static void createTheLocations() { 
    theLocations = new Hashtable();
    allLocs = new Hashtable();
  }

  public static boolean isLocation(String name) {
    return allLocs.containsKey(name);
  }

  private static String[] allLocationsCached = null;
  public static String [] allLocations() {
    if ( null != allLocationsCached ) return allLocationsCached;
    loadTheLocations();
    Enumeration enumz = allLocs.keys();
    int size = allLocs.size();
    String [] out = new String [size];
    int i = 0;
    while ( enumz.hasMoreElements() ) {
	out[i++] = (String) enumz.nextElement();
    }
    Arrays.sort(out);
    allLocationsCached = out;
    return out;
  }

  public static String [] allPartLocations() {
    loadTheLocations();
    Enumeration enumz = allLocs.keys();
    Vector temp = new Vector();
    String loc;
    Location location;
    while ( enumz.hasMoreElements() ) {
	loc = (String) enumz.nextElement();
	location = getLocation(loc);
	if ( (location instanceof PartLocation) &&
	     !(location instanceof ConnectionLocation) &&
	     !(location instanceof LocationSet) )
	  temp.addElement(loc);
    }
    temp.addElement("body");
    int lng = temp.size();
    String [] out = new String[lng];
    for (int i = 0; i <lng; i++) out[i] = (String) temp.elementAt(i);
    Arrays.sort(out);
    return out;
  }

  public static String [] allConnectionLocations() {
    loadTheLocations();
    Enumeration enumz = allLocs.keys();
    Vector temp = new Vector();
    String loc;
    Location location;
    while ( enumz.hasMoreElements() ) {
	loc = (String) enumz.nextElement();
	location = getLocation(loc);
	if ( location instanceof ConnectionLocation )
	  temp.addElement(loc);
    }
    int lng = temp.size();
    String [] out = new String[lng];
    for (int i = 0; i <lng; i++) out[i] = (String) temp.elementAt(i);
    Arrays.sort(out);
    return out;
  }

  public static String [] allLocationSets() {
    loadTheLocations();
    Enumeration enumz = allLocs.keys();
    Vector temp = new Vector();
    String loc;
    Location location;
    while ( enumz.hasMoreElements() ) {
	loc = (String) enumz.nextElement();
	location = getLocation(loc);
	if ( location instanceof LocationSet )
	  temp.addElement(loc);
    }
    int lng = temp.size();
    String [] out = new String[lng];
    for (int i = 0; i <lng; i++) out[i] = (String) temp.elementAt(i);
    Arrays.sort(out);
    return out;
  }

  public static Location getLocation(String name) {
    loadTheLocations();
    Location out = (Location) theLocations.get(name);
    if ( null != out ) return out;
    try {
      FileInputStream fis = new FileInputStream(D.theLocationsDir + name);
      ObjectInputStream ois = new ObjectInputStream(fis);
      out = (Location) ois.readObject();
      ois.close();
      fis.close();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      ex.printStackTrace();
      // throw exception
    }
    if ( null != out ) theLocations.put(name, out);
    return out;
  }

  // to add:    theLocations.put(name, location);
  // to delete: theLocations.remove(name);

  public static void addLocation(Location location) {
    loadTheLocations();
    String name = location.getName();
    theLocations.put(name, location);
    setTheLocationsSaved(false);
    allLocs.put(name, name);
    addXWord(name, "Location");
  }
  public static void removeLocation(Location location) {
    removeLocation(location.getName());
  }
  public static void removeLocation(String locationName) {
    theLocations.remove(locationName);
    allLocs.remove(locationName);
    setTheLocationsSaved(false);
  }

  private static boolean theLocationsLoaded = false;
  public static boolean getTheLocationsLoaded() {
    return theLocationsLoaded;
  }
  public static void setTheLocationsLoaded(boolean val) {
    theLocationsLoaded = val;
  }

  public static void loadTheLocations() {
    if ( theLocationsLoaded ) return;
    if ( null == theLocations ) createTheLocations();
    allLocs = IO.readOrCreateHT(D.allLocs);
    theLocationsLoaded = true;
    theLocationsSaved = true;
  } // end loadTheLocations()

  private static boolean theLocationsSaved = false;
  public static boolean getTheLocationsSaved() {
    return theLocationsSaved;
  }
  public static void setTheLocationsSaved(boolean val) {
    theLocationsSaved = val;
  }
  public static void saveTheLocations() {
    if ( !theLocationsLoaded ) return;
    if ( theLocationsSaved ) return;
    System.out.println("--- writing the locations ...");
    Enumeration enumz = theLocations.keys();
    String loc, className;
    Location location;
    FileOutputStream fis;
    ObjectOutputStream ois;
    try {
      while ( enumz.hasMoreElements() ) {
	loc = (String) enumz.nextElement();
	location = (Location) theLocations.get(loc);
	fis = new FileOutputStream(D.theLocationsDir + loc);
	ois = new ObjectOutputStream(fis);
	ois.writeObject(location);
	ois.close();
	fis.close();
      }
      if ( IO.saveHT(D.allLocs, allLocs) )
	theLocationsSaved = true;
      else 
	System.out.println("** Error: Common.saveTheLocations()");

    } catch (IOException ex) {
      System.out.println("** Error: Common.saveTheLocations()");
      System.out.println(ex.getMessage());
      ex.printStackTrace();
      // throw exception
    }

  } // end saveTheLocations()


  // --------------------------- BodySystem ------------------------------

  // bodySystem name to BodySystem
  private static Hashtable theBodySystems = null;
  public static void createTheBodySystems() { 
    theBodySystems = new Hashtable();
  }

  private static String[] allBodySystemsCached = null;
  public static String [] allBodySystems() {
    if ( null != allBodySystemsCached ) return allBodySystemsCached;
    loadTheBodySystems();
    int size = theBodySystems.size();
    String [] out = new String [size];
    Enumeration enumz = theBodySystems.keys();
    int i = 0;
    while (enumz.hasMoreElements()) {
	out[i++] = (String) enumz.nextElement();
    }
    Arrays.sort(out);
    allBodySystemsCached = out;
    return out;
  }

  public static BodySystem getBodySystem(String name) {
    loadTheBodySystems();
    return (BodySystem) theBodySystems.get(name);
  }

  // to add:    theBodySystems.put(name, bodySystem);
  // to delete: theBodySystems.remove(name);

  public static void addBodySystem(BodySystem bodySystem) {
    loadTheBodySystems();
    String name = bodySystem.getName();
    theBodySystems.put(name, bodySystem);
    setTheBodySystemsSaved(false);
    addXWord(name, "BodySystem");
  }
  public static void removeBodySystem(BodySystem bodySystem) {
    removeBodySystem(bodySystem.getName());
  }
  public static void removeBodySystem(String bodySystemName) {
    theBodySystems.remove(bodySystemName);
    setTheBodySystemsSaved(false);
  }

  private static boolean theBodySystemsLoaded = false;
  public static boolean getTheBodySystemsLoaded() {
    return theBodySystemsLoaded;
  }
  public static void setTheBodySystemsLoaded(boolean val) {
    theBodySystemsLoaded = val;
  }
  private static final Boolean BSLOCK = new Boolean(true);
  public static void loadTheBodySystems() {
    if ( theBodySystemsLoaded ) return;
    synchronized (BSLOCK) {
      if ( theBodySystemsLoaded ) return;
      theBodySystems = IO.readOrCreateHT(D.theBodySystems);
      theBodySystemsLoaded = true;
      theBodySystemsSaved = true;
    }
  } // end loadTheBodySystems()

  private static boolean theBodySystemsSaved = false;
  public static boolean getTheBodySystemsSaved() {
    return theBodySystemsSaved;
  }
  public static void setTheBodySystemsSaved(boolean val) {
    theBodySystemsSaved = val;
  }
  public static void saveTheBodySystems() {
    if ( !theBodySystemsLoaded ) return;
    if ( theBodySystemsSaved ) return;
    if ( IO.saveHT(D.theBodySystems, theBodySystems) )
      theBodySystemsSaved = true;
    else 
      System.out.println("** Error: Common.saveTheBodySystems()");
  } // end saveTheBodySystems()


  // ---------------------- Disease  -----------------------------
 
  // disease name to Disease
  private static Hashtable theDiseases = null;
  private static Hashtable allDiss = null;
  public static void createTheDiseases() { 
    theDiseases = new Hashtable();
    allDiss = new Hashtable();
  }

  public static boolean isDisease(String name) {
    return allDiss.containsKey(name);
  }
  private static String[] allDiseasesCached = null;
  public static String [] allDiseases() {
    if ( null != allDiseasesCached ) return allDiseasesCached;
    loadTheDiseases();
    Enumeration enumz = allDiss.keys();
    int size = allDiss.size();
    String [] out = new String [size];
    int i = 0;
    while ( enumz.hasMoreElements() ) {
	out[i++] = (String) enumz.nextElement();
    }
    Arrays.sort(out);
    allDiseasesCached = out;
    return out;
  }

  public static Disease getDisease(String name) {
    loadTheDiseases();
    Disease out = (Disease) theDiseases.get(name);
    if ( null != out ) return out;
    try {
      FileInputStream fis = new FileInputStream(D.theDiseasesDir + name);
      ObjectInputStream ois = new ObjectInputStream(fis);
      out = (Disease) ois.readObject();
      ois.close();
      fis.close();
    } catch (Exception ex) { // ignore
	// System.out.println(ex.getMessage());
	// ex.printStackTrace();
        // throw exception
    }
    if ( null != out ) 	
	theDiseases.put(name, out);
    return out;
  }

  // to add:    theDiseases.put(name, disease);
  // to delete: theDiseases.remove(name);

  public static void addDisease(Disease disease) {
    loadTheDiseases();
    String name = disease.getName();
    theDiseases.put(name, disease);
    setTheDiseasesSaved(false);
    allDiss.put(name, name);
    addXWord(name, "Disease");
    addDiseaseForShow(name);
  }
  public static void removeDisease(Disease disease) {
    removeDisease(disease.getName());
  }
  public static void removeDisease(String diseaseName) {
    theDiseases.remove(diseaseName);
    allDiss.remove(diseaseName);
    setTheDiseasesSaved(false);
  }

  private static boolean theDiseasesLoaded = false;
  public static boolean getTheDiseasesLoaded() {
    return theDiseasesLoaded;
  }
  public static void setTheDiseasesLoaded(boolean val) {
    theDiseasesLoaded = val;
  }

  public static void loadTheDiseases() {
    if ( theDiseasesLoaded ) return;
    if ( null == theDiseases ) createTheDiseases();
    allDiss = IO.readOrCreateHT(D.allDiss);
    theDiseasesLoaded = true;
    theDiseasesSaved = true;
  } // end loadTheDiseases()

  private static boolean theDiseasesSaved = false;
  public static boolean getTheDiseasesSaved() {
    return theDiseasesSaved;
  }
  public static void setTheDiseasesSaved(boolean val) {
    theDiseasesSaved = val;
  }
  public static void saveTheDiseases() {
    if ( !theDiseasesLoaded ) return;
    if ( theDiseasesSaved ) return;
    System.out.println("--- writing the diseases ...");
    Enumeration enumz = theDiseases.keys();
    String loc, className;
    Disease disease;
    FileOutputStream fis;
    ObjectOutputStream ois;
    try {
      while ( enumz.hasMoreElements() ) {
	loc = (String) enumz.nextElement();
	disease = (Disease) theDiseases.get(loc);
	fis = new FileOutputStream(D.theDiseasesDir + loc);
	ois = new ObjectOutputStream(fis);
	ois.writeObject(disease);
	ois.close();
	fis.close();
      }
      if ( IO.saveHT(D.allDiss, allDiss) )
	theDiseasesSaved = true;
      else 
	System.out.println("** Error: Common.saveTheDiseases()");
    } catch (IOException ex) {
      System.out.println("** Error: Common.saveTheDiseases()");
      System.out.println(ex.getMessage());
      ex.printStackTrace();
      // throw exception
    }

  } // end saveTheDiseases()

  public static int numOfDiseases() { return theDiseases.size(); }


  // ---------------------- DiseasesForShow  -----------------------------
 
  // theDiseasesForShow is the set of diseases  + their aliases
  private static HashSet theDiseasesForShow = null;
  public static void createTheDiseasesForShow() { 
    theDiseasesForShow = new HashSet();
  }
  public static boolean isDiseaseForShow(String name) {
      loadTheDiseasesForShow();
      return theDiseasesForShow.contains(name);
  }
  private static String[] allDiseasesForShowCached = null;
  public static String [] allDiseasesForShow() {
    if ( null != allDiseasesForShowCached ) return allDiseasesForShowCached;
    loadTheDiseasesForShow();
    Iterator it = theDiseasesForShow.iterator();
    int size = theDiseasesForShow.size();
    String [] out = new String [size];
    int i = 0;
    while ( it.hasNext() ) {
	out[i++] = (String) it.next();
    }
    Arrays.sort(out);
    allDiseasesForShowCached = out;
    return out;
  }
  public static void addDiseaseForShow(String name) {
    loadTheDiseasesForShow();
    theDiseasesForShow.add(name);
    setTheDiseasesForShowSaved(false);
  }
  private static boolean theDiseasesForShowLoaded = false;
  public static boolean getTheDiseasesForShowLoaded() {
    return theDiseasesLoaded;
  }
  public static void setTheDiseasesForShowLoaded(boolean val) {
    theDiseasesLoaded = val;
  }

  public static void loadTheDiseasesForShow() {
    if ( theDiseasesForShowLoaded ) return;
    if ( null == theDiseasesForShow ) createTheDiseasesForShow();
    theDiseasesForShow = IO.readHashSet(D.theDiseasesForShow);
    theDiseasesForShowLoaded = true;
    theDiseasesForShowSaved = true;
  } // end loadTheDiseases()

  private static boolean theDiseasesForShowSaved = false;
  public static boolean getTheDiseasesForShowSaved() {
    return theDiseasesForShowSaved;
  }
  public static void setTheDiseasesForShowSaved(boolean val) {
    theDiseasesForShowSaved = val;
  }
  public static void saveTheDiseasesForShow() {
    if ( !theDiseasesForShowLoaded ) return;
    if ( theDiseasesForShowSaved ) return;
    System.out.println("--- writing the theDiseasesForShow ...");
    IO.saveHashSet(D.theDiseasesForShow, theDiseasesForShow);
    theDiseasesForShowSaved = true;
  }

  //------------------- DiseaseSet -------------------------------

  // diseaseSet name to DiseaseSet
  private static Hashtable theDiseaseSets = null;
  public static void createTheDiseaseSets() { 
    theDiseaseSets = new Hashtable();
  }

  private static String[] allDiseasesSetsCached = null;
  public static String [] allDiseaseSets() {
      if ( null != allDiseasesSetsCached ) return allDiseasesSetsCached;
    loadTheDiseaseSets();
    int size = theDiseaseSets.size();
    String [] out = new String [size];
    Enumeration enumz = theDiseaseSets.keys();
    int i = 0;
    while (enumz.hasMoreElements()) {
	out[i++] = (String) enumz.nextElement();
    }
    Arrays.sort(out);
    allDiseasesSetsCached = out;
    return out;
  }

  public static DiseaseSet getDiseaseSet(String name) {
    loadTheDiseaseSets();
    return (DiseaseSet) theDiseaseSets.get(name);
  }

  // to add:    theDiseaseSets.put(name, diseaseSet);
  // to delete: theDiseaseSets.remove(name);

  public static void addDiseaseSet(DiseaseSet diseaseSet) {
    loadTheDiseaseSets();
    String name = diseaseSet.getName();
    theDiseaseSets.put(name, diseaseSet);
    setTheDiseaseSetsSaved(false);
    addXWord(name, "DiseaseSet");

  }
  public static void removeDiseaseSet(DiseaseSet diseaseSet) {
    removeDiseaseSet(diseaseSet.getName());
  }
  public static void removeDiseaseSet(String diseaseSetName) {
    theDiseaseSets.remove(diseaseSetName);
    setTheDiseaseSetsSaved(false);
  }

  private static boolean theDiseaseSetsLoaded = false;
  public static boolean getTheDiseaseSetsLoaded() {
    return theDiseaseSetsLoaded;
  }
  public static void setTheDiseaseSetsLoaded(boolean val) {
    theDiseaseSetsLoaded = val;
  }
  public static void loadTheDiseaseSets() {
    if ( theDiseaseSetsLoaded ) return;
    theDiseaseSets = IO.readOrCreateHT(D.theDiseaseSets);
    theDiseaseSetsLoaded = true;
    theDiseaseSetsSaved = true;
  } // end loadTheDiseaseSets()

  private static boolean theDiseaseSetsSaved = false;
  public static boolean getTheDiseaseSetsSaved() {
    return theDiseaseSetsSaved;
  }
  public static void setTheDiseaseSetsSaved(boolean val) {
    theDiseaseSetsSaved = val;
  }
  public static void saveTheDiseaseSets() {
    if ( !theDiseaseSetsLoaded ) return;
    if ( theDiseaseSetsSaved ) return;
    if ( IO.saveHT(D.theDiseaseSets, theDiseaseSets) )
      theDiseaseSetsSaved = true;
    else 
      System.out.println("** Error: Common.saveTheDiseaseSets()");
  } // end saveTheDiseaseSets()


  //------------------- Symptom ------------------------------------

  // symptom name to Symptom
  private static Hashtable theSymptoms = null;
  public static void createTheSymptoms() { 
    theSymptoms = new Hashtable();
  }

  private static String[] allSymptomsCached = null;
  public static String [] allSymptoms() {
      if ( null != allSymptomsCached ) return allSymptomsCached;
    loadTheSymptoms();
    int size = theSymptoms.size();
    String [] out = new String [size];
    Enumeration enumz = theSymptoms.keys();
    int i = 0;
    while (enumz.hasMoreElements()) {
	out[i++] = (String) enumz.nextElement();
    }
    Arrays.sort(out);
    allSymptomsCached = out;
    return out;
  }

  public static Symptom getSymptom(String name) {
    loadTheSymptoms();
    return (Symptom) theSymptoms.get(name);
  }

  // to add:    theSymptoms.put(name, symptom);
  // to delete: theSymptoms.remove(name);

  public static void addSymptom(Symptom symptom) {
    loadTheSymptoms();
    String name = symptom.getName();
    theSymptoms.put(name, symptom);
    setTheSymptomsSaved(false);
    addXWord(name, "Symptom");
  }
  public static void removeSymptom(Symptom symptom) {
    removeSymptom(symptom.getName());
  }
  public static void removeSymptom(String symptomName) {
    theSymptoms.remove(symptomName);
    setTheSymptomsSaved(false);
  }

  private static boolean theSymptomsLoaded = false;
  public static boolean getTheSymptomsLoaded() {
    return theSymptomsLoaded;
  }
  public static void setTheSymptomsLoaded(boolean val) {
    theSymptomsLoaded = val;
  }
  public static void loadTheSymptoms() {
    if ( theSymptomsLoaded ) return;
    theSymptoms = IO.readOrCreateHT(D.theSymptoms);
    theSymptomsLoaded = true;
    theSymptomsSaved = true;
  } // end loadTheSymptoms()

  private static boolean theSymptomsSaved = false;
  public static boolean getTheSymptomsSaved() {
    return theSymptomsSaved;
  }
  public static void setTheSymptomsSaved(boolean val) {
    theSymptomsSaved = val;
  }
  public static void saveTheSymptoms() {
    if ( !theSymptomsLoaded ) return;
    if ( theSymptomsSaved ) return;
    if ( IO.saveHT(D.theSymptoms, theSymptoms) )
      theSymptomsSaved = true;
    else 
      System.out.println("** Error: Common.saveTheSymptoms()");
  } // end saveTheSymptoms()


  //------------------- Treatment ---------------------------------

  // treatment name to Treatment
  private static Hashtable theTreatments = null;
  public static void createTheTreatments() { 
    theTreatments = new Hashtable();
  }

  public static Treatment getTreatment(String name) {
    loadTheTreatments();
    return (Treatment) theTreatments.get(name);
  }

  // to add:    theTreatments.put(name, treatment);
  // to delete: theTreatments.remove(name);

  public static void addTreatment(Treatment treatment) {
    loadTheTreatments();
    String name = treatment.getName();
    theTreatments.put(name, treatment);
    setTheTreatmentsSaved(false);
  }
  public static void removeTreatment(Treatment treatment) {
    removeTreatment(treatment.getName());
  }
  public static void removeTreatment(String treatmentName) {
    theTreatments.remove(treatmentName);
    setTheTreatmentsSaved(false);
  }

  private static boolean theTreatmentsLoaded = false;
  public static boolean getTheTreatmentsLoaded() {
    return theTreatmentsLoaded;
  }
  public static void setTheTreatmentsLoaded(boolean val) {
    theTreatmentsLoaded = val;
  }
  public static void loadTheTreatments() {
    if ( theTreatmentsLoaded ) return;
    theTreatments = IO.readOrCreateHT(D.theTreatments);
    theTreatmentsLoaded = true;
    theTreatmentsSaved = true;
  } // end loadTheTreatments()

  private static boolean theTreatmentsSaved = false;
  public static boolean getTheTreatmentsSaved() {
    return theTreatmentsSaved;
  }
  public static void setTheTreatmentsSaved(boolean val) {
    theTreatmentsSaved = val;
  }
  public static void saveTheTreatments() {
    if ( !theTreatmentsLoaded ) return;
    if ( theTreatmentsSaved ) return;
    if ( IO.saveHT(D.theTreatments, theTreatments) )
      theTreatmentsSaved = true;
    else 
      System.out.println("** Error: Common.saveTheTreatments()");
  } // end saveTheTreatments()


  //------------------- AbnormalCondition -------------------------------

  // abnormalCondition name to AbnormalCondition
  private static Hashtable theAbnormalConditions = null;
  public static void createTheAbnormalConditions() { 
    theAbnormalConditions = new Hashtable();
  }

  private static String[] allAbnormalConditionsCached = null;
  public static String [] allAbnormalConditions() {
    if ( null != allAbnormalConditionsCached ) return allAbnormalConditionsCached;
    loadTheAbnormalConditions();
    int size = theAbnormalConditions.size();
    String [] out = new String [size];
    Enumeration enumz = theAbnormalConditions.keys();
    int i = 0;
    while (enumz.hasMoreElements()) {
	out[i++] = (String) enumz.nextElement();
    }
    Arrays.sort(out);
    allAbnormalConditionsCached = out;
    return out;
  }


  public static AbnormalCondition getAbnormalCondition(String name) {
    loadTheAbnormalConditions();
    return (AbnormalCondition) theAbnormalConditions.get(name);
  }

  // to add:    theAbnormalConditions.put(name, abnormalCondition);
  // to delete: theAbnormalConditions.remove(name);

  public static void addAbnormalCondition(AbnormalCondition abnormalCondition) {
    loadTheAbnormalConditions();
    String name = abnormalCondition.getName();
    theAbnormalConditions.put(name, abnormalCondition);
    setTheAbnormalConditionsSaved(false);
    addXWord(name, "AbnormalCondition");
  }
  public static void removeAbnormalCondition(AbnormalCondition abnormalCondition) {
    removeAbnormalCondition(abnormalCondition.getName());
  }
  public static void removeAbnormalCondition(String abnormalConditionName) {
    theAbnormalConditions.remove(abnormalConditionName);
    setTheAbnormalConditionsSaved(false);
  }

  private static boolean theAbnormalConditionsLoaded = false;
  public static boolean getTheAbnormalConditionsLoaded() {
    return theAbnormalConditionsLoaded;
  }
  public static void setTheAbnormalConditionsLoaded(boolean val) {
    theAbnormalConditionsLoaded = val;
  }
  public static void loadTheAbnormalConditions() {
    if ( theAbnormalConditionsLoaded ) return;
    theAbnormalConditions = IO.readOrCreateHT(D.theAbnormalConditions);
    theAbnormalConditionsLoaded = true;
    theAbnormalConditionsSaved = true;
  } // end loadTheAbnormalConditions()

  private static boolean theAbnormalConditionsSaved = false;
  public static boolean getTheAbnormalConditionsSaved() {
    return theAbnormalConditionsSaved;
  }
  public static void setTheAbnormalConditionsSaved(boolean val) {
    theAbnormalConditionsSaved = val;
  }
  public static void saveTheAbnormalConditions() {
    if ( !theAbnormalConditionsLoaded ) return;
    if ( theAbnormalConditionsSaved ) return;
    if ( IO.saveHT(D.theAbnormalConditions, theAbnormalConditions) )
      theAbnormalConditionsSaved = true;
    else 
      System.out.println("** Error: Common.saveTheAbnormalConditions()");
  } // end saveTheAbnormalConditions()


  //------------------- External Causes ---------------------------------

  // description to ExternalCause
  private static Hashtable theExternalCauses = null;
  public static void createTheExternalCauses() { 
    theExternalCauses = new Hashtable();
  }

  private static String[] allExternalCausesCached = null;
  public static String [] allExternalCauses() {
    if ( null != allExternalCausesCached ) return allExternalCausesCached;
    loadTheExternalCauses();
    int size = theExternalCauses.size();
    String [] out = new String [size];
    Enumeration enumz = theExternalCauses.keys();
    int i = 0;
    while (enumz.hasMoreElements()) {
	out[i++] = (String) enumz.nextElement();
    }
    Arrays.sort(out);
    allExternalCausesCached = out;
    return out;
  }

  public static ExternalCause getExternalCause(String name) {
    loadTheExternalCauses();
    return (ExternalCause) theExternalCauses.get(name);
  }

  // to add:    theExternalCauses.put(name, externalCause);
  // to delete: theExternalCauses.remove(name);

  public static void addExternalCause(ExternalCause externalCause) {
    loadTheExternalCauses();
    String name = externalCause.getDescription();
    theExternalCauses.put(name, externalCause);
    setTheExternalCausesSaved(false);
  }
  public static void removeExternalCause(ExternalCause externalCause) {
    removeExternalCause(externalCause.getDescription());
  }
  public static void removeExternalCause(String externalCauseName) {
    theExternalCauses.remove(externalCauseName);
    setTheExternalCausesSaved(false);
  }

  private static boolean theExternalCausesLoaded = false;
  public static boolean getTheExternalCausesLoaded() {
    return theExternalCausesLoaded;
  }
  public static void setTheExternalCausesLoaded(boolean val) {
    theExternalCausesLoaded = val;
  }
  public static void loadTheExternalCauses() {
    if ( theExternalCausesLoaded ) return;
    theExternalCauses = IO.readOrCreateHT(D.theExternalCauses);
    theExternalCausesLoaded = true;
    theExternalCausesSaved = true;
  } // end loadTheExternalCauses()

  private static boolean theExternalCausesSaved = false;
  public static boolean getTheExternalCausesSaved() {
    return theExternalCausesSaved;
  }
  public static void setTheExternalCausesSaved(boolean val) {
    theExternalCausesSaved = val;
  }
  public static void saveTheExternalCauses() {
    if ( !theExternalCausesLoaded ) return;
    if ( theExternalCausesSaved ) return;
    if ( IO.saveHT(D.theExternalCauses, theExternalCauses) )
      theExternalCausesSaved = true;
    else 
      System.out.println("** Error: Common.saveTheExternalCauses()");
  } // end saveTheExternalCauses()


  // --------------------- Treatment Conditions ------------------------------

  static private Vector theTreatmentConditions = null;
  private static boolean treatmentConditionsLoaded = false;
  public static boolean getTheTreatmentConditionsLoaded() {
    return treatmentConditionsLoaded;
  }
  public static void setTheTreatmentConditionsLoaded(boolean val) {
    treatmentConditionsLoaded = val;
  }

  static public void addTreatmentCondition(String condition) {
    createTheTreatmentConditions();
    if ( !theTreatmentConditions.contains(condition) ) {
      theTreatmentConditions.addElement(condition);
      saveTheTreatmentConditions();
    }
  }
  static public void createTheTreatmentConditions() {
    if (treatmentConditionsLoaded) return;
    theTreatmentConditions = new Vector();
    setTheTreatmentConditionsLoaded(true);
  }

  static private void loadTheTreatmentConditions() {
    if (treatmentConditionsLoaded) return;
    theTreatmentConditions = IO.readOrCreateVector(D.theTreatmentConditions);
    treatmentConditionsLoaded = true;
  }
  static private void saveTheTreatmentConditions() {
    if ( !IO.saveVector(D.theTreatmentConditions, theTreatmentConditions) )
      System.out.println("** Error: Common.saveTheTreatmentConditions()");
  }

  public static String [] allTreatmentConditions() {
    loadTheTreatmentConditions();
    int size = theTreatmentConditions.size();
    String [] out = new String [size];
    Enumeration enumz = theTreatmentConditions.elements();
    int i = 0;
    while (enumz.hasMoreElements()) {
	out[i++] = (String) enumz.nextElement();
    }
    Arrays.sort(out);
    return out;
  }


  //------------------- Drugs --------------------------------

  // description to Drug
  private static Hashtable theDrugs = null;
  public static void createTheDrugs() { 
    theDrugs = new Hashtable();
  }

  private static String[] allDrugsCached = null;
  public static String [] allDrugs() {
    if ( null != allDrugsCached ) return allDrugsCached;
    loadTheDrugs();
    int size = theDrugs.size();
    String [] out = new String [size];
    Enumeration enumz = theDrugs.keys();
    int i = 0;
    while (enumz.hasMoreElements()) {
	out[i++] = (String) enumz.nextElement();
    }
    Arrays.sort(out);
    allDrugsCached = out;
    return out;
  }

  public static Drug getDrug(String name) {
    loadTheDrugs();
    return (Drug) theDrugs.get(name);
  }

  // to add:    theDrugs.put(name, drug);
  // to delete: theDrugs.remove(name);

  public static void addDrug(Drug drug) {
    loadTheDrugs();
    String name = drug.getName();
    theDrugs.put(name, drug);
    setTheDrugsSaved(false);
    addXWord(name, "Drug");
  }
  public static void removeDrug(Drug drug) {
    removeDrug(drug.getName());
  }
  public static void removeDrug(String drugName) {
    theDrugs.remove(drugName);
    setTheDrugsSaved(false);
  }

  private static boolean theDrugsLoaded = false;
  public static boolean getTheDrugsLoaded() {
    return theDrugsLoaded;
  }
  public static void setTheDrugsLoaded(boolean val) {
    theDrugsLoaded = val;
  }
  public static void loadTheDrugs() {
    if ( theDrugsLoaded ) return;
    theDrugs = IO.readOrCreateHT(D.theDrugs);
    theDrugsLoaded = true;
    theDrugsSaved = true;
  } // end loadTheDrugs()

  private static boolean theDrugsSaved = false;
  public static boolean getTheDrugsSaved() {
    return theDrugsSaved;
  }
  public static void setTheDrugsSaved(boolean val) {
    theDrugsSaved = val;
  }
  public static void saveTheDrugs() {
    if ( !theDrugsLoaded ) return;
    if ( theDrugsSaved ) return;
    if ( IO.saveHT(D.theDrugs, theDrugs) )
      theDrugsSaved = true;
    else 
      System.out.println("** Error: Common.saveTheDrugs()");
  } // end saveTheDrugs()


  //------------------- TreatmentActions ---------------------------

  // description to TreatmentAction
  private static Hashtable theTreatmentActions = null;
  public static void createTheTreatmentActions() { 
    theTreatmentActions = new Hashtable();
  }

  public static String [] allTreatmentActions() {
    loadTheTreatmentActions();
    int size = theTreatmentActions.size();
    String [] out = new String [size];
    Enumeration enumz = theTreatmentActions.keys();
    int i = 0;
    while (enumz.hasMoreElements()) {
	out[i++] = (String) enumz.nextElement();
    }
    Arrays.sort(out);
    return out;
  }

  public static TreatmentAction getTreatmentAction(String name) {
    loadTheTreatmentActions();
    return (TreatmentAction) theTreatmentActions.get(name);
  }

  // to add:    theTreatmentActions.put(name, treatmentAction);
  // to delete: theTreatmentActions.remove(name);

  public static void addTreatmentAction(TreatmentAction treatmentAction) {
    loadTheTreatmentActions();
    String name = treatmentAction.getDescription();
    theTreatmentActions.put(name, treatmentAction);
    setTheTreatmentActionsSaved(false);
  }
  public static void removeTreatmentAction(TreatmentAction treatmentAction) {
    removeTreatmentAction(treatmentAction.getDescription());
  }
  public static void removeTreatmentAction(String treatmentActionName) {
    theTreatmentActions.remove(treatmentActionName);
    setTheTreatmentActionsSaved(false);
  }

  private static boolean theTreatmentActionsLoaded = false;
  public static boolean getTheTreatmentActionsLoaded() {
    return theTreatmentActionsLoaded;
  }
  public static void setTheTreatmentActionsLoaded(boolean val) {
    theTreatmentActionsLoaded = val;
  }
  public static void loadTheTreatmentActions() {
    if ( theTreatmentActionsLoaded ) return;
    theTreatmentActions = IO.readOrCreateHT(D.theTreatmentActions);
    theTreatmentActionsLoaded = true;
    theTreatmentActionsSaved = true;
  } // end loadTheTreatmentActions()

  private static boolean theTreatmentActionsSaved = false;
  public static boolean getTheTreatmentActionsSaved() {
    return theTreatmentActionsSaved;
  }
  public static void setTheTreatmentActionsSaved(boolean val) {
    theTreatmentActionsSaved = val;
  }
  public static void saveTheTreatmentActions() {
    if ( !theTreatmentActionsLoaded ) return;
    if ( theTreatmentActionsSaved ) return;
    if ( IO.saveHT(D.theTreatmentActions, theTreatmentActions) )
      theTreatmentActionsSaved = true;
    else 
      System.out.println("** Error: Common.saveTheTreatmentActions()");
  } // end saveTheTreatmentActions()


  //------------------- XWords ------------------------------

  public static void addXWord(String name, String type) {
    String unknown = LR.unknown;
    XWord xWord = getXWord(name);
    if ( null != xWord ) { 
      if ( xWord.getType().equals(unknown) )
	xWord.setType(type);
      // else write error .....
      return;
    }
    // null == xWord 
    String test = name.toUpperCase();
    if ( test.equals(name) ) { // all uppercase
      xWord = new XWordNormal(name, type); 
      return;
    }
    test = unPolish(name);
    if ( test.equals(name) ) { // all lowercase
      xWord = new XWordNormal(name, type);
      return;
    }
    // something like: heartAttack
    XWordPolish xwp = new XWordPolish(name, type);
    xWord = xwp;
    StringTokenizer st = new StringTokenizer(test);
    String token;
    XWordNormal subword;
    while ( st.hasMoreTokens() ) {
      token = st.nextToken();
      // put filter here
      if ( token.length() < 3 ) continue;
      subword = (XWordNormal) getXWord(token);
      if ( null == subword ) {
	subword = new XWordNormal(token, unknown);
	//  addXWord(subword);
      }
      xwp.addSubWord(token);
      subword.addReference(name);
    }
  }

  // description to XWord
  private static Hashtable theXWords = null;
  public static void createTheXWords() { 
    theXWords = new Hashtable();
  }

  private static String[] allXWordsCached = null;
  public static String [] allXWords() {
      if ( null != allXWordsCached ) return allXWordsCached;
    loadTheXWords();
    int size = theXWords.size();
    String [] out = new String [size];
    Enumeration enumz = theXWords.keys();
    int i = 0;
    while (enumz.hasMoreElements()) {
	out[i++] = (String) enumz.nextElement();
    }
    Arrays.sort(out);
    allXWordsCached = out;
    return out;
  }

  public static XWord getXWord(String name) {
    loadTheXWords();
    return (XWord) theXWords.get(name);
  }

  // to add:    theXWords.put(name, xWord);
  // to delete: theXWords.remove(name);

    // used by XWord
  public static void addXWord(XWord xWord) {
    loadTheXWords();
    String name = xWord.getName();
    theXWords.put(name, xWord);
    setTheXWordsSaved(false);
  }
  public static void removeXWord(XWord xWord) {
    removeXWord(xWord.getName());
  }
  public static void removeXWord(String xWordName) {
    theXWords.remove(xWordName);
    setTheXWordsSaved(false);
  }

  private static boolean theXWordsLoaded = false;
  public static boolean getTheXWordsLoaded() {
    return theXWordsLoaded;
  }
  public static void setTheXWordsLoaded(boolean val) {
    theXWordsLoaded = val;
  }
  public static void loadTheXWords() {
    if ( theXWordsLoaded ) return;
    theXWords = IO.readOrCreateHT(D.theXWords);
    theXWordsLoaded = true;
    theXWordsSaved = true;
  } // end loadTheXWords()

  private static boolean theXWordsSaved = false;
  public static boolean getTheXWordsSaved() {
    return theXWordsSaved;
  }
  public static void setTheXWordsSaved(boolean val) {
    theXWordsSaved = val;
  }
  public static void saveTheXWords() {
    if ( !theXWordsLoaded ) return;
    if ( theXWordsSaved ) return;
    if ( IO.saveHT(D.theXWords, theXWords) )
      theXWordsSaved = true;
    else 
      System.out.println("** Error: Common.saveTheXWords()");
  } // end saveTheXWords()


  //------------------- logSessions ------------------------------

  // logSessions a vector with as elements instances of Hashtable
  public static Vector getLogSessions(String logName) {
    Vector out = IO.readOrCreateVector(D.theUsersDir+logName+"logSessions");
    return out;
  } // end getLogSessions(String logName)

  public static void saveLogSessions(String logName, Vector out) {
    if ( !IO.saveVector(D.theUsersDir+logName+"logSessions", out) )
      System.out.println("** Error: Common.saveLogSessions(...)");
  } // end saveLogSessions(String logName, Vector out)


  //------------------- gender symptoms stuff ------------------------------

  private static HashSet maleSymptoms = null;
  private static HashSet femaleSymptoms = null;
  public static HashSet allMaleSymptoms() {
    if ( null != maleSymptoms ) return maleSymptoms;
    maleSymptoms = IO.readOrCreateHashSet(D.maleSymptoms);
    return maleSymptoms;
  }
  public static HashSet allFemaleSymptoms() {
    if ( null != femaleSymptoms ) return femaleSymptoms;
    femaleSymptoms = IO.readOrCreateHashSet(D.femaleSymptoms);
    return femaleSymptoms;
  }


  //------------------- gender diseases stuff ------------------------------

  private static HashSet maleDiseases = null;
  private static HashSet femaleDiseases = null;
  public static HashSet allMaleDiseases() {
    if ( null != maleDiseases ) return maleDiseases;
    maleDiseases = IO.readOrCreateHashSet(D.maleDiseases);
    return maleDiseases;
  }
  public static HashSet allFemaleDiseases() {
    if ( null != femaleDiseases ) return femaleDiseases;
    femaleDiseases = IO.readOrCreateHashSet(D.femaleDiseases);
    return femaleDiseases;
  }
  private static String[] allMaleDiseasesArrCached = null;
  public static String[] allMaleDiseasesArr() {
      if ( null != allMaleDiseasesArrCached ) return allMaleDiseasesArrCached;
      HashSet hs = allMaleDiseases();
      Iterator it = hs.iterator();
      int size = hs.size();
      String [] out = new String [size];
      int i = 0;
      while ( it.hasNext() ) {
	out[i++] = (String) it.next();
      }
      Arrays.sort(out);
      allMaleDiseasesArrCached = out;
      return out;
  }
  private static String[] allFemaleDiseasesArrCached = null;
  public static String[] allFemaleDiseasesArr() {
      if ( null != allFemaleDiseasesArrCached ) return allFemaleDiseasesArrCached;
      HashSet hs = allFemaleDiseases();
      Iterator it = hs.iterator();
      int size = hs.size();
      String [] out = new String [size];
      int i = 0;
      while ( it.hasNext() ) {
	out[i++] = (String) it.next();
      }
      Arrays.sort(out);
      allFemaleDiseasesArrCached = out;
      return out;
  }

  //------------------- gender locations stuff ------------------------------

  private static HashSet maleLocations = null;
  private static HashSet femaleLocations = null;
  public static HashSet allMaleLocations() {
    if ( null != maleLocations ) return maleLocations;
    maleLocations = IO.readOrCreateHashSet(D.maleLocations);
    return maleLocations;
  }
  public static HashSet allFemaleLocations() {
    if ( null != femaleLocations ) return femaleLocations;
    femaleLocations = IO.readOrCreateHashSet(D.femaleLocations);
    return femaleLocations;
  }


  //------------------- Location Hierarchy ------------------------------

    private static Vector locationHierarchy = null;
    public static Vector theLocationHierarchy() {
	if ( null == locationHierarchy ) 
	    locationHierarchy = IO.readOrCreateVector(D.locationHierarchy);
	return locationHierarchy;
    }

  //------------------- Head Hierarchy ------------------------------

    private static Vector headHierarchy = null;
    public static Vector theHeadHierarchy() {
	if ( null == headHierarchy ) 
	    headHierarchy = IO.readOrCreateVector(D.headHierarchy);
	return headHierarchy;
    }

  //------------------- Neck Hierarchy ------------------------------

    private static Vector neckHierarchy = null;
    public static Vector theNeckHierarchy() {
	if ( null == neckHierarchy ) 
	    neckHierarchy = IO.readOrCreateVector(D.neckHierarchy);
	return neckHierarchy;
    }

  //------------------- Chest Hierarchy ------------------------------

    private static Vector chestHierarchy = null;
    public static Vector theChestHierarchy() {
	if ( null == chestHierarchy ) 
	    chestHierarchy = IO.readOrCreateVector(D.chestHierarchy);
	return chestHierarchy;
    }

  //------------------- Abdomen Hierarchy ------------------------------

    private static Vector abdomenHierarchy = null;
    public static Vector theAbdomenHierarchy() {
	if ( null == abdomenHierarchy ) 
	    abdomenHierarchy = IO.readOrCreateVector(D.abdomenHierarchy);
	return abdomenHierarchy;
    }

  //------------------- Genitalia Hierarchy ------------------------------

    private static Vector genitaliaHierarchy = null;
    public static Vector theGenitaliaHierarchy() {
	if ( null == genitaliaHierarchy ) 
	    genitaliaHierarchy = IO.readOrCreateVector(D.genitaliaHierarchy);
	return genitaliaHierarchy;
    }

  //------------------- Arms Hierarchy ------------------------------

    private static Vector armsHierarchy = null;
    public static Vector theArmsHierarchy() {
	if ( null == armsHierarchy ) 
	    armsHierarchy = IO.readOrCreateVector(D.armsHierarchy);
	return armsHierarchy;
    }

  //------------------- Legs Hierarchy ------------------------------

    private static Vector legsHierarchy = null;
    public static Vector theLegsHierarchy() {
	if ( null == legsHierarchy ) 
	    legsHierarchy = IO.readOrCreateVector(D.legsHierarchy);
	return legsHierarchy;
    }

  //------------------- Misc Hierarchy ------------------------------

    private static Vector miscHierarchy = null;
    public static Vector theMiscHierarchy() {
	if ( null == miscHierarchy ) 
	    miscHierarchy = IO.readOrCreateVector(D.miscHierarchy);
	return miscHierarchy;
    }

  //------------------- commonSymptomNames ------------------------------

    private static Vector commonSymptomNames = null;
    public static Vector theCommonSymptomNames() {
	if ( null == commonSymptomNames ) 
	    commonSymptomNames = IO.readOrCreateVector(D.commonSymptomNames);
	return commonSymptomNames;
    }

    //----------------- Logger ------------------------------------------

    private static Vector logger = null;
    public static Vector getLogger() {
	if ( null == logger ) 
	    logger = IO.readOrCreateVector(D.logger);
	return logger;
    }
    public static void saveLogger(Vector logger) {
	IO.saveVector(D.logger, logger);
    }
    public static void log0(String msg) {
	Vector logger = getLogger();
	if ( null == logger ) return; // or send an email ...
	logger.addElement(msg);
	saveLogger(logger);
    }
    public static void log1(String msg) {
	Date now = new Date();
        DateFormat format = 
	    new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        log0(format.format(now) + "|" + msg);
    }
    public static void log(String className, String msg) {
	log1(className + "|" + msg);
    }
    public static String getLog(Vector logger, String separator) {
	int lng = logger.size();
	if ( 0 == lng ) return "";
	StringBuffer sb = new StringBuffer();
	String item = null;
	for (int i = 0; i < lng; i++) {
	    item = (String) logger.elementAt(i);
	    sb.append(item);
	    sb.append(separator);
	}
	return sb.toString();
    }
    public static String getLogHTML(Vector logger) {
	return getLog(logger, "<br />");
    }
    public static String getLog(String separator) {
	return getLog(getLogger(), separator);
    }
    public static String getLog() {
	return getLog("<br />");
    }
    public static void clearLog() {
	saveLogger(new Vector());
    }

} // end of Common
