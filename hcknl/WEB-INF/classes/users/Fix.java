package users;

import java.util.*;
import java.io.*;
import com.Common;
import com.D;
import com.IO;

/*
This is an adhoc tool to deal with the following problem:
Deleting a user account through SUDeleteAccount somehow corrupted
the file userAccounts.
The vector was not updated properly and still contained a String element with length zero.
Just execute java users.Fix will remove those elements.
 */


public class Fix {

  static private String userAccountsFile = D.userAccounts;
  static private Vector uuAccounts = new Vector();

  public static void main(String[] args) {
      uuAccounts = IO.readOrCreateVector(userAccountsFile);
      int lng0 = uuAccounts.size();
      int lng = lng0;
      System.out.println("start:: lng= " + lng);
      boolean proceed = true;
      int lng2 = 0;
      while ( proceed ) {
	  removeElement(uuAccounts);
	  lng2 = uuAccounts.size();
	  proceed = ( 0 < lng2 && lng2 < lng ); 
	  lng = lng2;
      }
      System.out.println("finish:: lng2= " + lng2);
      if ( lng2 < lng0 ) {
	  boolean written = IO.saveVector(userAccountsFile, uuAccounts);
	  System.out.println("written= " + written);
      }
  }

    private static void removeElement(Vector uuAccounts) {
      int lng = uuAccounts.size();
      System.out.println("Entering RemoveElement lng= " + lng); 
      String name;
      int lngName; 

      for (int i=0; i<lng; i++) {
	  name = (String) uuAccounts.elementAt(i);
	  lngName = name.length();
	  System.out.println("i= " + i + 
			     " name= " + name + 
			     " size= " + lngName);
	  if ( 0==lngName ) {
	      System.out.println("Found element with length 0 at: i= " + i);
	      uuAccounts.removeElementAt(i);
	      break;
	  }
      }
    }
 
} // end of Fix

