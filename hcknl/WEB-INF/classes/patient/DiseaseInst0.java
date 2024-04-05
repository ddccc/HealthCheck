// (C) OntoOO Inc 2002 June
package patient;

import concepts.Disease;
import com.Common;
import com.L;

import java.util.*;
import java.io.*;

/* An instance of this class is either a conjectured disease during a 
   diagnosis process or is a accepted/ confirmed disease and is a part of
   record of the client */

public class DiseaseInst0 implements Serializable, Comparable, Cloneable {

  // the name of the "class" to which this disease belongs
  protected String disease; 
  protected Date dateTime; // when this disease was decided
  protected Disease dis;
  protected boolean lifeThreatening;
  protected String source; 
  public DiseaseInst0 (String disease, String source, Date dateTime) {
    this.disease = disease;
    this.source = source;
    this.dateTime = dateTime;
    dis = Common.getDisease(disease);
    lifeThreatening = dis.isLifeThreatening();
  }
  public String getDisease() { return disease; }
  public Disease getDiseaseC() { return dis; }
  public String getPrintName() {
    // Disease dis = getDiseaseC();
    return dis.getPrintName();
  }
  public Date getDateTime() { return dateTime; }
  public void setDateTime(Date dt) { dateTime = dt; }
  public boolean isLifeThreatening() { return lifeThreatening; }
  public String getSource() { return source; }

  public int compareTo(Object o) {
    int out = 0;
    DiseaseInst0 di2 = this;
    try { di2 = (DiseaseInst0) o; } 
    catch (ClassCastException ignore) { return out; }
    Date dateTime2 = di2.getDateTime();
    out = ( dateTime.equals(dateTime2) ? 0 :
	    ( dateTime.before(dateTime2) ? -1 : +1 ) );
    return out;
  }

  public String html() { 
    return 
      "<tr><td><b>" +
	// "Disease instance of:" +
	L.DiseaseInst0S1 +
	"</b></td><td>" + getPrintName() + "</td></tr>" +
      ( lifeThreatening ? 
	"<tr><td><b>" +
	// "Life Threatening:" +
	L.LifeThreatening +
	"</b></td><td><font color=\"#FF0000\">Yes</font></td></tr>" : 
	"" ) +
      "<tr><td><b>" + L.Source + "</b></td><td>" + source + "</td></tr>" +
      "<tr><td><b>" + L.StartDate + "</b></td><td>" + dateTime.toString() + "</td></tr>";
  }


} // end of DiseaseInst0
