// (C) OntoOO Inc 2001
package concepts;
import com.D;
import com.L;

import java.util.Vector;

public class XWordPolish extends XWord {

    private Vector subWords = new Vector();

    public XWordPolish(String name, String type) { 
      super(name, type);
    }

    public Vector getSubWords() { return subWords; }

    public void addSubWord(String ref) { subWords.addElement(ref); }

    public String html() {
      return 
	super.html() +
	displaySubWords(subWords);
    }

  private String displaySubWords(Vector subWords) {
      int lng = subWords.size();
      StringBuffer sb = new StringBuffer("<br><b>" + L.SubWords + "</b>");
      String xWord;
      for (int i = 0; i<lng; i++) {
	xWord = (String) subWords.elementAt(i);
	sb.append(
	   "<br />" + L.subWordTo + " " + 
	   "<a href=\"" + D.servletShowXWord + "?xw=" + xWord + "\"> " +
		  xWord + "</a>");
      }
      return sb.toString();
    }

}

