// (C) OntoOO Inc 2001
package concepts;
import com.D;
import com.L;

import java.util.Vector;


public class XWordNormal extends XWord {

    private Vector references = new Vector();

    public XWordNormal(String name, String type) { 
      super(name, type);
    }

    public Vector getReferences() { return references; }

    public void addReference(String ref) { references.addElement(ref); }
    public void checkAddReference(String ref) { 
      if ( references.contains(ref) ) return;
      references.addElement(ref); 
    }

    public boolean isReferenced(String ref){
      return references.contains(ref);
    }

    public String html() {
      return 
	super.html() +
	displayReferences(references);
    }

  private String displayReferences(Vector references) {
      int lng = references.size();
      StringBuffer sb = new StringBuffer("<br><b>" + L.References + ":</b>");
      String xWord;
      for (int i = 0; i<lng; i++) {
	xWord = (String) references.elementAt(i);
	sb.append(
	   "<br /><b>" + L.referenceTo + "</b> " + 
	   "<a href=\"" + D.servletShowXWord + "?xw=" + xWord + "\"> " +
		  xWord + "</a>");
      }
      return sb.toString();
    }


}

