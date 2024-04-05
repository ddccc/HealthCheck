// (C) OntoOO Dennis de Champeaux 2001 2012
package concepts;

import com.Common;
import com.D;
import com.L;
import com.LR;

import java.io.*;

public class XWord implements Serializable {

    private String name;
    private String printName;
    // type = Location|Disease|AbnormalCondition|
    //        BodySystem|Symptom|synonym|unknown|Drug
    private String type;
    private String synonym = null;

    public XWord(String name, String type) { 
      this.name = name;
      this.type = type;
      Common.addXWord(this);
      printName = name;
      if ( type == LR.synonym ) {
	  printName = Common.unPolish2(name);
      }
    }
    
    public String getName() { return name; }
    public String getPrintName() { return printName; }
    public String getType() { return type; }
    public String getSynonym() { return synonym; }

    public void setType(String type) { this.type = type; }
    public void setSynonym(String synonym) { this.synonym = synonym; }

    public String html() {
	boolean ndcn = type.equals(LR.unknown) || type.equals(LR.synonym);
      return "<p><b>" + L.XWord + "</b>" + 
	"<br /><b>" + L.name + "</b> " + name + 
	( null == synonym ? "" :
	  "<br /><b>" + L.synonym + "</b> " + 
	  "<a href=\"" + D.servletShowXWord + "?xw=" + 
	           synonym + "\"> " + synonym + "</a>") + 
	( ndcn ? " " : displayClassName(type) );
    }

    private String displayClassName(String type) {
      return
	   "<br /><b>" + L.Concept + "</b> " + 
	   "<a href=\"" + D.servletShowHasName + "?hn=" + name + "&cn=" + type + "\"> " + 
	   name + " " + L.inClass + " " + type + "</a>";
    }
}





