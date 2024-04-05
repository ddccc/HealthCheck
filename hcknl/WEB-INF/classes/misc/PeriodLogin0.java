// (C) OntoOO Inc 2001
package misc;

import java.util.Hashtable;
import java.util.Vector;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public abstract class PeriodLogin0 extends Period implements HttpSessionBindingListener {

  protected String histVecName = null; // = logName
  private String htName = null;
  protected Hashtable unboundHashtable = new Hashtable();
  protected String sessionId;

  public PeriodLogin0(String histVecName, String htName, String sessionId) {
    super();
    this.histVecName = histVecName;
    this.htName = htName;
    this.sessionId = sessionId;
  }

  public String getHistVecName() { return histVecName; }

  public String html() {
    return super.html();
  }

  public void valueBound(HttpSessionBindingEvent event) {
    unboundHashtable.put("start", start);
    HttpSession session = event.getSession();
    session.putValue(htName, unboundHashtable);
  }

  public abstract void valueUnbound(HttpSessionBindingEvent event); 

}
