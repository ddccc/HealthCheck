// (C) OntoOO Inc 2005
package su;

import java.util.Date;
import com.Triple;

public class DiseaseRecord extends Triple implements Comparable    {

    public DiseaseRecord (String disease, Date date, String source) {
	super(disease, date, source);
    }
    public String getDisease() { return (String) getFirst(); }
    public Date getDate() { return (Date) getSecond(); }
    public String getSource() { return (String) getThird(); }

  public int compareTo(Object o) {
    int out = 0;
    DiseaseRecord di2 = this;
    try { di2 = (DiseaseRecord) o; } 
    catch (ClassCastException ignore) { return out; }
    Date date2 = di2.getDate();
    Date date = this.getDate();
    out = ( date.equals(date2) ? 0 :
	    ( date.before(date2) ? -1 : +1 ) );
    return out;
  }


} // end of DiseaseRecord
