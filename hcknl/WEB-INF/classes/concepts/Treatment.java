// (C) OntoOO Inc 2000
package concepts;

import java.util.*;
import java.io.*;
import com.Common;
import com.L;
import com.D;

public class Treatment implements Serializable {

  private String name;
  private String condition = null;
  private Vector treatmentActions = new Vector(); // elements of TreatmentAction
  private Vector drugs = new Vector(); 

  public Treatment(
	   String name
	   ) {
    this.name = name;
    Common.addTreatment(this); 

  } // end of Treatment(String name)

  public Treatment(
	   String name, String condition
	   ) {
    this(name);
    this.condition = condition;
    Common.addTreatmentCondition(condition);

  } // end of Treatment(String name, String condition)

  public String getName() { return name; }

  public String getCondition() { return condition; }

  public void addTreatmentAction(String action) {
        TreatmentAction ta = Common.getTreatmentAction(action);
	if (null == ta ) {
	  ta = new TreatmentAction(action);
	  Common.addTreatmentAction(ta);
	}
	treatmentActions.addElement(ta);

  }
  public Vector getTreatmentActions() { return treatmentActions; }

  public void addDrug(String drug) {
	String name = Common.eliminateSpace(drug);
        Drug dr = Common.getDrug(name);
	if (null == dr) {
	  dr = new Drug(drug);
	  Common.addDrug(dr);
	}
	drugs.addElement(name);
  }
  public Vector getDrugs() { return drugs; }

  public void printTreatment() {
    Common.println("");
    Common.println("Treatment: " + name);
    Common.println("condition: " + condition);
    int lng = treatmentActions.size();
    if ( 0<lng ) {
      Common.println("Treatment actions:");
      TreatmentAction ta;
      for (int i=0; i<lng; i++) {
	ta = (TreatmentAction) treatmentActions.elementAt(i);
	Common.println(ta.getDescription());
      }
    }
    lng = drugs.size();
    if ( 0<lng ) {
      Common.println("Drugs:");
      Drug drug;
      for (int i=0; i<lng; i++) {
	drug = (Drug) drugs.elementAt(i);
	Common.println(drug.getDescription());
      }
    }
  }

  public String htmlNoBr() {
    return 
      "<b>" + L.Treatment + "</b> " + name +
      "<br /><b>" + L.Condition + "</b> " + condition +
      htmlActions(treatmentActions) +
      htmlDrugs(drugs);
  }
  public String html() { return "<br>" + htmlNoBr(); }

  public String htmlActions(Vector vec) {
      if ( 0 == vec.size() ) return "";
      return actions(vec, "<br>");
  }
  private String actions(Vector actions, String prefix) {
    StringBuffer sb = new StringBuffer("");
    int lng = actions.size();
    TreatmentAction ta;
    for (int i=0; i<lng; i++) {
      ta = (TreatmentAction) actions.elementAt(i);
      sb.append(prefix + (ta.getDescription()));
    }
    return sb.toString();
  }
  public String htmlDrugs(Vector drugs) {
      if ( 0 == drugs.size() ) return "";
      return drugs(drugs, "<br>");
  }
  static public String drugs(Vector drugs, String prefix) {
      return drugs(drugs, prefix, true);
  }
  static public String drugs(Vector drugs, String prefix, boolean allPrefix) {
    StringBuffer sb = new StringBuffer("");
    int lng = drugs.size();
    for (int i=0; i<lng; i++) {
      String drugName = (String) drugs.elementAt(i);
      Drug drug = Common.getDrug(drugName);
      // sb.append(prefix + drug.getDescription());
      sb.append( (allPrefix || 0 < i ? prefix : "") +
		 "<a href=\"" + D.servletShowDrug + "?drug=" + drugName + "\">" +
		 drug.getDescription() +  "</a>");
    }
    return sb.toString();
  }


  public String alertDescription() {
    return 
      (null == condition ? "" : L.Condition + " " + condition + ":: ") +
	actions(treatmentActions, " ") + 
	drugs(drugs, " ");
  }

} // end of Treatment
