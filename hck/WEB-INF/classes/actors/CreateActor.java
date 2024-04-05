// (C) OntoOO Inc 2004 Oct
package actors;

import java.util.*;
import java.io.*;


public class CreateActor {

public static void main (String [] arguments) {
    Actor actor = new Actor("DdcAssistant");
    System.out.println("actor name: " + actor.getName());
    System.out.println("saved actor?: " + actor.saveActor());

    // Actor actor = Actor.getActor("DdcAssistant");
    actor = Actor.getActor("DdcAssistant");
    actor.start();
    /*
    try {
	Thread.sleep(10000);
    } catch (InterruptedException ignore) {}
    */
} // end of main

} // end of CreateActor


