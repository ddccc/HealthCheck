// (C) OntoOO Inc 2000
package concepts;

import java.util.*;
import java.io.*;
import com.Common;

public class TreatmentAction implements Serializable {

  public TreatmentAction(
	   String description
	   ) {
    this.description = description;
    Common.addTreatmentAction(this);  
  } // end of TreatmentAction()

  private String description;
  public String getDescription() { return description; }

  /*
    // Perhaps this can be transformed into a relationship between 
    // TreatmentActions and diseases via the intervening Treatment ...

  private String theDiseaseKeys = null;

  public String getDiseaseKeys() { 
    if ( null != theDiseaseKeys ) return theDiseaseKeys;
    String expand = Common.getECDiseaseKeys(description);
    if ( null == expand ) return null;
    StringBuffer out = new StringBuffer(expand);
    boolean done = false;
    StringTokenizer st;
    String expand2 = "";
    String diseaseN;
    Disease dis;
    Vector subDiseases;
    String subDisI;
    while (!done) {
      st = new StringTokenizer(expand);
      while ( st.hasMoreTokens() ) {
	diseaseN = st.nextToken();
	dis = Common.getDisease(diseaseN);
	if ( !dis.isSuperDisease() ) continue;
	subDiseases = dis.getSubDiseases();
	for (int i=0; i<subDiseases.size(); i++) {
	  subDisI = " "+subDiseases.elementAt(i);
	  out.append(subDisI);
	  expand2 = expand2 + subDisI;
	}
      }
      if ( expand2.equals("") ) done = true; 
      else { expand = expand2; expand2 = ""; }
    }
    theDiseaseKeys = out.toString();
    return theDiseaseKeys;
  }

  public void printTreatmentAction() {
	Common.println("");
	Common.print("TreatmentAction:");
	Common.println(description);
	Common.println("Disease Keys: " + getDiseaseKeys());
  }

  public String html() {
    return ("<p><b>TreatmentAction:</b> " + 
	    "<b>Description: </b>" + description +
	    Common.htmlVectorDI(getHtmlDiseaseKeys(), "Disease Keys:") );
  }

  private Vector htmlDiseaseKeys = null;
  private Vector getHtmlDiseaseKeys() {
    if (null == htmlDiseaseKeys) setHtmlDiseaseKeys();
    return htmlDiseaseKeys;
  }
  private void setHtmlDiseaseKeys() {
    htmlDiseaseKeys = new Vector();
    String theDiseaseKeys = getDiseaseKeys();
    if ( null == theDiseaseKeys ) { return; }
    StringTokenizer st = new StringTokenizer(theDiseaseKeys);
    String diseaseN;
    while ( st.hasMoreTokens() ) {
	diseaseN = st.nextToken();
	htmlDiseaseKeys.addElement(diseaseN);
    }
  }
  */

} // end of TreatmentAction


