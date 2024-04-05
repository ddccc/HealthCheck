// (C) OntoOO Inc 2000
package concepts;
import com.Common;
import com.D;
import com.L;

import java.util.*;
import java.io.*;

public class ExternalCause implements Serializable {

  private String description;
  Vector causesDiseases = new Vector();

  public ExternalCause(
	   String description
	   ) {
    this.description = description;
    Common.addExternalCause(this);  
  } // end of ExternalCause()

  public String getDescription() { return description; }

  public Vector getCausesDiseases() { return causesDiseases; }
  public void addCausesDisease(String name) { causesDiseases.addElement(name); }

  public void printExternalCause() {
	Common.println("");
	Common.print("ExternalCause:");
	Common.println(description);
	// Common.println("Disease Keys: " + getDiseaseKeys());
	if ( 0 < causesDiseases.size() ) 
	    Common.println("Causes Diseases: " + causesDiseases.toString());
  }

  public String html() {
    return 
	"<p><b>" + L.ExternalCause + "</b> " + 
	"<b>" + L.Description + " </b>" + description +
	// Common.htmlVectorDI(getHtmlDiseaseKeys(), "Disease Keys:") );
	( 0 == causesDiseases.size() ? "" : "<br /> " +
	  Common.htmlVectorDI(causesDiseases, L.CausesDiseases) );
  }

} // end of ExternalCause




