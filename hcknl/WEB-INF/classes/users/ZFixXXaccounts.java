package users;

import java.util.*;
import java.io.*;

import com.Common;
import com.D;
import com.IO;
import su.SUtil;
import misc.DB;


/*
This is adhoc tool to add to xx accounts the property: anonymous=1
 */


public class ZFixXXaccounts {

  static private String userAccountsFile = D.userAccounts;

  public static void main(String[] args) {
      Vector uuAccounts = SUtil.getUUaccounts();
      int lng = uuAccounts.size();
      System.out.println("start:: lng= " + lng);
      String prefix2 = D.theUsersDir;
      FileOutputStream fos;
      for (int i = 0; i < lng; i++) {
	String account = (String) uuAccounts.elementAt(i);
	System.out.println("account: " + account);
	DB props = null;
	try {
	    props = new DB(prefix2 + account);
	} catch (IOException ignore) {}
	if ( null == props ) { 
	    System.out.println("** File with null props: " + account);
	    continue; // screwed up/ hence ignore
	}
	if ( account.startsWith("xx") ) {
	    props.putProperty("anonymous", "1");
	    try {
		fos = new FileOutputStream(prefix2 + account);
		props.store(fos, "ZFixXXaccounts");
		fos.close();
	    }
	    catch (IOException ex) {
		System.out.println("** Cant write file: " + account);
	    }
	    System.out.println("!! Fixed file: " + account);
	}
      }
  }


 
} // end of ZFixXXaccounts

