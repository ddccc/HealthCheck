// (C) OntoOO Inc 2005
package misc;

import java.util.Hashtable;
import java.util.Vector;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import su.PHLogin;


public class PeriodLoginPH extends PeriodLogin0 {

  public PeriodLoginPH(String histVecName, String htName, String sessionId) {
    super(histVecName, htName, sessionId);
    label = "Period Login PH";
  }

  public void valueUnbound(HttpSessionBindingEvent event) {
      // KCallPerson.removeKCallPerson(sessionId);
    PHLogin.removePH(sessionId);
    end = new Date();
    unboundHashtable.put("end", end);
    // note that one can NOT access session anylonger !!
    // IE: values to be stored must have been put in unboundHashtable earlier
    // For example, a conclusion from a diagnostic session must have been
    // saved as:
    // Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");
    // unboundHashtable.put("conclusion", conclusion);
    // Note: only serializable objects can be saved !!

    Vector logSessions = Common.getLogSessions(histVecName);
    logSessions.addElement(unboundHashtable);
    Common.saveLogSessions(histVecName, logSessions);
  }
}












