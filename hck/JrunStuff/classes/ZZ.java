import java.util.Vector;
// import java.util.Hashtable;
// import java.util.Properties;
// import java.util.Enumeration;
// import java.io.*;

public class ZZ {

public static void main (String [] arguments) {
	//  Ztendon.setType("whatever");
	// Ztendon zt = new Ztendon();
	System.out.println("zt: " + Ztendon.tE.getType());
} // end of main

} // end class ZZ


class Ztendon {

static private String type = "whatever";
public String getType() { return type; }
// static void setType(String val) { type = val; }

public static Ztendon tE = new Ztendon();


}