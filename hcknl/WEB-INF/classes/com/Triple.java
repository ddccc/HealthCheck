// (C) OntoOO Inc 2005
package com;

import java.io.Serializable;

public class Triple implements Serializable {

    private Object first;
    private Object second;
    private Object third;
    public Triple (Object first, Object second, Object third) {
	this.first = first;
	this.second = second;
	this.third = third;
    }
    public Object getFirst() { return first; };
    public Object getSecond() { return second; };
    public Object getThird() { return third; };

} // end of Triple
