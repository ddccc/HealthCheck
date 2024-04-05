package users;
import java.util.*;
import java.io.*;

import com.Common;
import com.D;
import com.IO;
import su.SUtil;
import misc.DB;

public class ZFixAccount {


  public static void main(String[] args) {
      Vector uuAccounts = SUtil.getUUaccounts();
      int lng = uuAccounts.size();
      System.out.println("start:: lng= " + lng);
      // String prefix2 = D.theUsersDir;
      for (int i = 0; i < lng; i++) {
	String account = (String) uuAccounts.elementAt(i);
	System.out.println("account: " + account);
      }
  }
}
