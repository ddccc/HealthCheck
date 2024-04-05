// (C) OntoOO Inc 2000
package concepts;

import java.net.URLEncoder;
import java.io.*;
import com.Common;
import com.D;
import com.L;

public class Condition implements Serializable, HasName {

  protected String name;
  protected String printName;
  protected String description;
  protected String locationSt;
  protected String webResource = null;

  public Condition(
	   String name,
	   String description,
	   String locationSt
	   ) {
    this.name = name;
    printName = name;
    this.description = description;
    this.locationSt = locationSt;

  } // end of Condition()

  public void setPrintName() { printName = description; }
  public void setPrintName(String pn) { printName = pn; }
  public String getName() { return name; }
  public String getPrintName() { return printName; }
  public String getDescription() { return description; }
  public String getLocationSt() { return locationSt; }
  public void setWebResource(String wr) { webResource = wr; }
  public String getWebResource() { return webResource; }


  public void printCondition() {
	Common.println("Name: "+name);
	Common.println("PrintName: "+printName);
	Common.println("Description: "+description);
	Common.println("LocationSt: "+locationSt);
	if ( null != webResource ) 
	  Common.println("WebResource: "+webResource);
  }

  public String html() {
      String encodedName = URLEncoder.encode(printName);
      String wr1 = "http://search.yahoo.com/bin/search?p=" + encodedName;
      String wr2 = "http://www.google.com/search?q=" + encodedName;
      String wr = 
	  "<a href=\"" + wr1 + "\">Yahoo</a> | " +
	  "<a href=\"" + wr2 + "\">Google</a>";
      if ( null != webResource )
	  wr = "<a href=\"" + webResource + "\">" + webResource + "</a> | " + wr;
      /*
      return
	// "<b>" + L.Name + "</b> " + printName +
	"<tr><td><b>" + L.Description + "</b></td><td>" + description + "</td></tr>\n" +
	"<tr><td><b>" + L.Location + "</b></td><td>" + 
	     "<a href=\"" + D.servletShowLocation + "?loc=" + locationSt + "\">" +
	     locPrintName(locationSt) + "</a></td></tr>\n" +
	"<tr><td><b>" + L.WebResource + "</b></td><td>" + 
	     wr + "</td></tr>\n";
      */
      StringBuffer sb = new StringBuffer();
      sb.append("<tr><td><b>" + L.Description + 
		"</b></td><td>" + description + "</td></tr>\n");
      sb.append("<tr><td><b>" + L.Location + "</b></td><td>" + 
		"<a href=\"" + D.servletShowLocation + "?loc=" + locationSt + "\">" +
		locPrintName(locationSt) + "</a></td></tr>\n");
      sb.append("<tr><td><b>" + L.WebResource + "</b></td><td>" + 
		wr + "</td></tr>\n");
      return sb.toString();
  }

  static public String locPrintName(String disStr) {
	Location dis = Common.getLocation(disStr);
	if ( null != dis ) return dis.getPrintName();
	return disStr;
    }

} // end of Condition
