// (C) OntoOO Inc 2002
package com;

import java.util.*;
import java.io.*;


public class IO {

  // --------------------- IO functions ----------------------------
  static public boolean saveHT(String htName, Hashtable ht) {
    // ****** htName is here the complete path! ******
      boolean out = true;
      FileOutputStream fis = null;
      ObjectOutputStream ois = null;
      try {
	  fis = new FileOutputStream(htName);
	  ois = new ObjectOutputStream(fis);
	  ois.writeObject(ht);
      } catch (Exception ex) {
	  System.out.println("Exception: saveHT htName: " + 
			     htName + " " + ex.getMessage());
	  out = false;
      }
      finally {
	  try { ois.close(); fis.close(); }
	  catch (Exception ignore) {}
      }
      return out;
  }

  static public Hashtable readHT(String htName) {
    // ****** htName is here the complete path! ******
      File aFile = new File(htName);
      if ( !aFile.exists() ) return new Hashtable();
      Hashtable ht = null;
      FileInputStream fis = null;
      ObjectInputStream ois = null;
      try {
	  fis = new FileInputStream(aFile);
	  ois = new ObjectInputStream(fis);
	  ht = (Hashtable) ois.readObject();
      } catch (Exception ex) {
	  System.out.println("Exception: readHT htName: " + 
			     htName + " " + ex.getMessage());
      }
      finally {
	  try { ois.close(); fis.close(); }
	  catch (Exception ignore) {}
      }
      return ht;
  }

  static public Hashtable readOrCreateHT(String htName) {
      Hashtable ht = readHT(htName);
      return ( null == ht ? new Hashtable() : ht );
  }

  static public boolean saveVector(String htName, Vector vec) {
    // ****** htName is here the complete path! ******
      boolean out = true;
      FileOutputStream fis = null;
      ObjectOutputStream ois = null;
      try {
	  fis = new FileOutputStream(htName);
	  ois = new ObjectOutputStream(fis);
	  ois.writeObject(vec);
      } catch (Exception ex) {
	  System.out.println("Exception: saveVector htName: " + 
			     htName + " " + ex.getMessage());
	  out = false;
      }
      finally {
	  try { ois.close(); fis.close(); }
	  catch (Exception ignore) {}
      }
      return out;
  }

  static public Vector readVector(String vecName) {
    // ****** vecName is here the complete path! ******
      File aFile = new File(vecName);
      if ( !aFile.exists() ) return new Vector();
      Vector vec = null;
      FileInputStream fis = null;
      ObjectInputStream ois = null;
      try {
	  fis = new FileInputStream(aFile);
	  ois = new ObjectInputStream(fis);
	  vec = (Vector) ois.readObject();
      } catch (Exception ex) {
	  System.out.println("Exception: readVector vecName: " + 
			     vecName + " " + ex.getMessage());
      }
      finally {
	  try { ois.close(); fis.close(); }
	  catch (Exception ignore) {}
      }
      return vec;
  }

  static public Vector readOrCreateVector(String htName) {
    // ****** htName is here the complete path! ******
    Vector vec = readVector(htName);
    return ( null == vec ? new Vector() : vec );
  }

  static public boolean saveHashSet(String htName, HashSet vec) {
    // ****** htName is here the complete path! ******
      boolean out = true;
      FileOutputStream fis = null;
      ObjectOutputStream ois = null;
      try {
	  fis = new FileOutputStream(htName);
	  ois = new ObjectOutputStream(fis);
	  ois.writeObject(vec);
      } catch (Exception ex) {
	  System.out.println("Exception: saveHashSet htName: " + 
			     htName + " " + ex.getMessage());
	  out = false;
      }
      finally {
	  try { ois.close(); fis.close(); }
	  catch (Exception ignore) {}
      }
      return out;
  }

  static public HashSet readHashSet(String htName) {
    // ****** htName is here the complete path! ******
      File aFile = new File(htName);
      if ( !aFile.exists() ) return new HashSet();
      HashSet vec = null;
      FileInputStream fis = null;
      ObjectInputStream ois = null;
      try {
	  fis = new FileInputStream(aFile);
	  ois = new ObjectInputStream(fis);
	  vec = (HashSet) ois.readObject();
      } catch (Exception ex) {
	  System.out.println("Exception: readHashSet htName: " + 
			     htName + " " + ex.getMessage());
      }
      finally {
	  try { ois.close(); fis.close(); }
	  catch (Exception ignore) {}
      }
     return vec;
  }

  static public HashSet readOrCreateHashSet(String htName) {
    // ****** htName is here the complete path! ******
    HashSet vec = readHashSet(htName);
    return ( null == vec ? new HashSet() : vec );
  }

}


