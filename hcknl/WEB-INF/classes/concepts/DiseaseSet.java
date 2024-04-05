// (C) OntoOO Inc 2001
package concepts;
import com.Common;
import com.L;

import java.util.*;
import java.io.*;

public class DiseaseSet implements Serializable, HasName {
  private String name;
  private String printName;
  private Vector diseaseMembers = new Vector();
  public DiseaseSet (String name) {
    this.name = name;
    printName = Common.unPolish(name);
    Common.addDiseaseSet(this);
  }
  public String getName() { return name; }
  public String getPrintName() { return printName; }
  public void setPrintName(String printName) { this.printName = printName; }
  public Vector getDiseaseMembers() { return diseaseMembers; }
  public void addDiseaseMember(String diseaseName) { 
    diseaseMembers.addElement(diseaseName);
  }
  
  public void printDiseaseSet() {
    Common.println("");
    Common.println("DiseaseSet: " + printName);
    Vector vec = diseaseMembers;
    int lng = vec.size();
    if ( 0<lng) {
      Common.println("Disease Members:");
      for (int i=0; i<lng; i++) Common.println((String)vec.elementAt(i));
    }
  }

  public String html() {
    Vector vec = diseaseMembers;
    int lng = vec.size();
    return 
      "<br /><b>" + L.DiseaseSet + "</b> " + printName +
      "<br /><b>" + L.members + "</b> " + lng +
      ( lng <= 0 ? "" :
	Common.htmlVectorDI(vec, L.DiseaseMembers) );
  }


} // end DiseaseSet

