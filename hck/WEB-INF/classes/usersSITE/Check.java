package users;

import java.util.*;
import java.io.*;
import com.Common;
import com.D;
import com.IO;

/*
This is an adhoc tool to investigate the list of user accounts
If it finds an entry of zero length, that element is removed from 
the vector, the vector is saved and the execution stops.
 */


public class Check {

  static private String userAccountsFile = D.userAccounts;
  static private Vector uuAccounts = new Vector();

  public static void main(String[] args) {
      uuAccounts = IO.readOrCreateVector(userAccountsFile);
      int lng = uuAccounts.size();
      System.out.println("start:: lng= " + lng);
      String name;
      int lngName; 
      for (int i=0; i<lng; i++) {
	  name = (String) uuAccounts.elementAt(i);
	  lngName = name.length();
	  // System.out.println("i= " + i + " name= " + name + " size= " + lngName);
	  if ( 0==lngName ) {
	      System.out.println("Found element with length 0 at: i= " + i);
	      uuAccounts.removeElementAt(i);
	      boolean written = IO.saveVector(userAccountsFile, uuAccounts);
	      System.out.println("written= " + written);
	      break;
	  }
      }

  }

 
} // end of Check

