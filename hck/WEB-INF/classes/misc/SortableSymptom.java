// (C) OntoOO Inc 2002
package misc;

import java.io.Serializable;


public class SortableSymptom implements Serializable, Comparable {
    private String symp;
    private String source;
    private float sigma;
    private boolean lifeThreatening = false;

    public SortableSymptom(String symp, String source) {
	this.symp = symp;
	this.source = source;
    }
    public String getSympName() { return symp; }
    public void setSource(String source) { this.source = source; }
    public String getSource() { return source; }
    public void setSigma(float sigma) { this.sigma = sigma; }
    public float getSigma() { return sigma; }
    public boolean isLifeThreatening() { return lifeThreatening; }
    public void setLifeThreatening() { lifeThreatening = true; }

    public int compareTo(Object o2) {
	SortableSymptom ss2 = this;
	try { ss2 = (SortableSymptom) o2; }
	catch (ClassCastException ignore) { return 0; }
	float sigma2 = ss2.getSigma();
	return ( sigma == sigma2 ? 0 :
		 ( sigma > sigma2 ? -1 : 1 ) );
    }
}
