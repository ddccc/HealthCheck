// (C) OntoOO Inc 2001
package misc;

import java.util.Date;
import java.io.Serializable;

public class Period implements Serializable {
  protected String label = "Period";
  protected Date start;
  protected Date end = null; // if null then chronic, or not yet set

  public Period() {
    start = new Date();
  }
  public void setEnd() { setEnd(new Date()); }
  public void setEnd(Date end) { this.end = end; }
  public Date getStart() { return start; }
  public Date getEnd() { return end; }
  private String stringDate(Date in) { return in.toString(); } 

  public String html() {
    return 
      "<p><b>" + label + ": </b>" + 
      "<br><b>start: </b>" + stringDate(start) +
      "<br><b>end: </b>" + 
      ( null == end ? "not set" : stringDate(end) );
  }

}
