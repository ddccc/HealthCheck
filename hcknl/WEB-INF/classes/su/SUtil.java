// (C) OntoOO Inc 2002 May
package su;

import java.util.*;

import com.IO;
import com.D;

public class SUtil {

    // -------------------------------------------------------------------------
  static private String userAccountsFile = D.userAccounts;
  static private Vector uuAccounts = new Vector();

  static public Vector getUUaccounts() {
    if ( 0 == uuAccounts.size() )
      uuAccounts = IO.readOrCreateVector(userAccountsFile);
    return uuAccounts;
  }
  static public boolean deleteUUaccount(String ac) {
    boolean out;
    synchronized(uuAccounts) {
      uuAccounts = IO.readOrCreateVector(userAccountsFile);
      uuAccounts.removeElement(ac);
      out = IO.saveVector(userAccountsFile, uuAccounts);
    }
    return out;
  }
  static public boolean addUUaccount(String ac) {
    boolean out;
    synchronized(uuAccounts) {
      uuAccounts = IO.readOrCreateVector(userAccountsFile);
      if ( uuAccounts.contains(ac) )
	out = false;
      else {
	uuAccounts.addElement(ac);
	out = IO.saveVector(userAccountsFile, uuAccounts);
      }
    }
    return out;
  }
  static public boolean SetUUaccounts(Vector keptAccounts) {
    boolean out;
    synchronized(uuAccounts) {
	uuAccounts = keptAccounts;
	out = IO.saveVector(userAccountsFile, uuAccounts);
    }
    return out;
  }
    // -------------------------------------------------------------------------
  static private String ccccAccountsFile = D.ccccAccounts;
  static private Vector ccAccounts = new Vector();

  static public Vector getCCaccounts() {
    if ( 0 == ccAccounts.size() )
      ccAccounts = IO.readOrCreateVector(ccccAccountsFile);
    return ccAccounts;
  }
  static public boolean deleteCCaccount(String ac) {
    boolean out;
    synchronized(ccAccounts) {
      ccAccounts = IO.readOrCreateVector(ccccAccountsFile);
      ccAccounts.removeElement(ac);
      out = IO.saveVector(ccccAccountsFile, ccAccounts);
    }
    return out;
  }
  static public boolean addCCaccount(String ac) {
    boolean out;
    synchronized(ccAccounts) {
      ccAccounts = IO.readOrCreateVector(ccccAccountsFile);
      if ( ccAccounts.contains(ac) )
	out = false;
      else {
	ccAccounts.addElement(ac);
	out = IO.saveVector(ccccAccountsFile, ccAccounts);
      }
    }
    return out;
  }

    // -------------------------------------------------------------------------
  static private String phphAccountsFile = D.phphAccounts;
  static private Vector phAccounts = new Vector();

  static public Vector getPHaccounts() {
    if ( 0 == phAccounts.size() )
      phAccounts = IO.readOrCreateVector(phphAccountsFile);
    return phAccounts;
  }
  static public boolean deletePHaccount(String ac) {
    boolean out;
    synchronized(phAccounts) {
      phAccounts = IO.readOrCreateVector(phphAccountsFile);
      phAccounts.removeElement(ac);
      out = IO.saveVector(phphAccountsFile, phAccounts);
    }
    return out;
  }
  static public boolean addPHaccount(String ac) {
    boolean out;
    synchronized(phAccounts) {
      phAccounts = IO.readOrCreateVector(phphAccountsFile);
      if ( phAccounts.contains(ac) )
	out = false;
      else {
	phAccounts.addElement(ac);
	out = IO.saveVector(phphAccountsFile, phAccounts);
      }
    }
    return out;
  }

    // -------------------------------------------------------------------------

  static private String phOwnedHashtable = D.phphAccounts + "Table";
  static private Hashtable phOwnedAccounts = null;
  static private Hashtable fetchPhOwnedAccounts() {
      if ( null == phOwnedAccounts )
	  phOwnedAccounts = IO.readOrCreateHT(phOwnedHashtable);
      return phOwnedAccounts;
  }

  static private boolean savePhOwnedAccounts() {
      if ( null == phOwnedAccounts ) return true;
      return IO.saveHT(phOwnedHashtable, phOwnedAccounts);
  }

  static public Vector getPHaccounts(String logName) {
      Hashtable ht = fetchPhOwnedAccounts();
      Vector out = (Vector) ht.get(logName);
      if ( null == out ) { 
	  out = new Vector();
	  ht.put(logName, out);
      }
      return out;
  }
  static public boolean deletePHaccount(String logName, String ac) {
      boolean out;
      Vector vec = getPHaccounts(logName);
      synchronized (phOwnedAccounts) {
	  vec.removeElement(ac);
	  if ( 0 == vec.size() ) { // delete the vector of logName's patients
	      Hashtable ht = fetchPhOwnedAccounts();
	      ht.remove(logName);
	  }
	  out = savePhOwnedAccounts();
      }
      return out;
  }
  static public boolean addPHaccount(String logName, String ac) {
      boolean out;
      Vector vec = getPHaccounts(logName);
      synchronized(phOwnedAccounts) {
	  if ( vec.contains(ac) )
	      out = false;
	  else {
	      vec.addElement(ac);
	      out = savePhOwnedAccounts();
      }
    }
    return out;
  }


    // -------------------------------------------------------------------------

  static private String phSessionsHashtable = D.phphAccounts + "Sessions";
  static private Hashtable phSessionsAccounts = null;
  static private Hashtable fetchPhSessionsAccounts() {
      if ( null == phSessionsAccounts )
	  phSessionsAccounts = IO.readOrCreateHT(phSessionsHashtable);
      return phSessionsAccounts;
  }

  static private String phTimestampsHashtable = D.phphAccounts + "Timestamps";
  static private Hashtable phTimestampsAccounts = null;
  static private Hashtable fetchPhTimestampsAccounts() {
      if ( null == phTimestampsAccounts )
	  phTimestampsAccounts = IO.readOrCreateHT(phTimestampsHashtable);
      return phTimestampsAccounts;
  }

  static private boolean savePhSessionsAccounts() {
      if ( null == phSessionsAccounts ) return true;
      return IO.saveHT(phSessionsHashtable, phSessionsAccounts);
  }

  static private boolean savePhTimestampsAccounts() {
      if ( null == phTimestampsAccounts ) return true;
      return IO.saveHT(phTimestampsHashtable, phTimestampsAccounts);
  }


  static public Vector getPHsessions(String logName) {
      Hashtable ht = fetchPhSessionsAccounts();
      Vector out = (Vector) ht.get(logName);
      if ( null == out ) { 
	  out = new Vector();
	  ht.put(logName, out);
      }
      return out;
  }
  static public boolean deletePHsession(String logName, String ac) {
      boolean out;
      Vector vec = getPHsessions(logName);
      Hashtable htt = fetchPhTimestampsAccounts();
      synchronized (phSessionsAccounts) {
	  vec.removeElement(ac);
	  htt.remove(ac);
	  if ( 0 == vec.size() ) { // delete the vector of logName's sessions
	      Hashtable ht = fetchPhSessionsAccounts();
	      ht.remove(logName);
	  }
	  out = savePhSessionsAccounts();
	  out = savePhTimestampsAccounts();
      }
      return out;
  }
  static public boolean addPHsession(String logName, String ac) {
      boolean out;
      Vector vec = getPHsessions(logName);
      Hashtable ht = fetchPhTimestampsAccounts();
      synchronized(phSessionsAccounts) {
	  if ( vec.contains(ac) )
	      out = false;
	  else {
	      vec.addElement(ac);
	      out = savePhSessionsAccounts();
	      ht.put(ac, new Date());
	      out = savePhTimestampsAccounts();
      }
    }
    return out;
  }
  static public Date getSessionDate(String ac) {
      Hashtable ht = fetchPhTimestampsAccounts();
      return (Date) ht.get(ac);
  }

}
