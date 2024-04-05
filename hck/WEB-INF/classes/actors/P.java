// (C) OntoOO Inc 2004 Sep
package actors;

import java.util.*;
import java.io.*;
import com.D;

public class P {
    static private String actorDir = D.applRoot2 + "/actors";

    static public boolean store(String name, Object obj) {
	/* The code below of storing a whole actor is overkill and too fragile.
	   Instead we should store data and reload data as is done for patient records 
	   Then we can use functionality already available in Common ...
	   
	try {
	    FileOutputStream fis = new FileOutputStream(actorDir + "/" + name);
	    ObjectOutputStream ois = new ObjectOutputStream(fis);
	    ois.writeObject(obj);
	    ois.close();
	    fis.close();
	} catch (Exception ex) {
	    System.out.println("** Error saving object: " + name);
	    System.out.println("** ex: " + ex.getMessage());
	    return false;
	}
	*/ 
	return true;
    } // end store

    static public Object load (String name) {
	// not used for now
	Object in = null;
	try {
	    FileInputStream fis = new FileInputStream(actorDir + "/" + name);
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    in =  ois.readObject();
	    ois.close();
	    fis.close();
	} catch (Exception ex) {
	    System.out.println("** Error loading object: " + name);
	    System.out.println("** ex: " + ex.getMessage());
	}
	return in;
    } // end load(String name)

} // end P

