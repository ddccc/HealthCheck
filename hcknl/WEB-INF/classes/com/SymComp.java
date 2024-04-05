// Copyright OntoOO Inc, 2007
package com;
import concepts.Symptom;

import java.util.Comparator;

public class SymComp implements Comparator {
  public int compare(Object s1, Object s2) throws ClassCastException {
    if ( s2.equals(s1) ) return 0;
    if ( !(s1 instanceof Symptom ))
      throw new ClassCastException(
                   "Expect " + D.SymptomClass);
    if ( !(s2 instanceof Symptom ))
      throw new ClassCastException(
                   "Expect " + D.SymptomClass);
    Symptom ss2 = (Symptom) s2;
    Symptom ss1 = (Symptom) s1;
    String p2 = ss2.getPrintName();
    String p1 = ss1.getPrintName();
    return ( p1.compareTo(p2) );
  } // end compare
} // end SymComp

