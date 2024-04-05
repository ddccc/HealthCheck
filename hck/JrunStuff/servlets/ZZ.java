// import java.util.Vector;
// import java.util.Hashtable;
// import java.util.Properties;
// import java.util.Enumeration;
// import java.io.*;

public class ZZ {

public static void main (String [] arguments) {
	String in = "inXxxxYyyy";
    StringBuffer sb = new StringBuffer(in);
    char sbi, sbi2;
    int lng = sb.length();
    for ( int i = lng - 1; 0 <= i; i--) {
      sbi = sb.charAt(i);
      if ( Character.isUpperCase(sbi) ) {
	sbi2 =  Character.toLowerCase(sbi);
	sb.setCharAt(i,sbi2);
	sb.insert(i,' ');
      }
    }
    String out = sb.toString();
    System.out.println("in: " + in + " out: " + out);


} // end of main

} // end class ZZ
