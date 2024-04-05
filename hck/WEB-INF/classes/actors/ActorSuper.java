// (C) OntoOO Inc 2004 Nov
package actors;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ActorSuper {

    protected String name;
    public String getName() { return name; }
    ActorSuper(String name) { this.name = name; }

    /*
    protected State worry = new State(); 
    public void setWorry(float x) { worry.setFloatValue(x); }
    public void increaseWorry() { worry.increaseFloatValue(); }
    public void decreaseWorry() { worry.decreaseFloatValue(); }
    public float getWorry() { return worry.getFloatValue(); }
    public void worryWakeUp() { worry.wakeUp(); }    
    */

} // end ActorSuper
