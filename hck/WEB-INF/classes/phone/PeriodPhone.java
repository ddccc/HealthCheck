// (C) OntoOO Inc 2004 March
package phone;

import java.util.Hashtable;
import java.util.Vector;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import patient.KClient;
import patient.AngelLogin;
import misc.PeriodLogin0;

public class PeriodPhone extends PeriodLogin0 {

  public PeriodPhone(String histVecName, String htName, String sessionId) {
    super(histVecName, htName, sessionId);
    label = "Period Phone";
  }

  public void valueUnbound(HttpSessionBindingEvent event) {
    KClient.removeKClient(sessionId);
    end = new Date();
    unboundHashtable.put("end", end);
    // note that one can NOT access session anylonger !!
    // IE: values to be stored must have been put in unboundHashtable earlier
    // For example, a conclusion from a diagnostic session must have been
    // saved as:
    // Hashtable unboundHashtable = (Hashtable) session.getValue("unboundHashtable");
    // unboundHashtable.put("conclusion", conclusion);
    // Note: only serializable objects can be saved !!

    /*
    // remove clutter
    Vector chatRecord = (Vector) unboundHashtable.get("chatRecord");
    if ( null != chatRecord && chatRecord.size() <= 1) 
      unboundHashtable.remove("chatRecord");
    */

    // add the hashtable to permanent record
    Vector logSessions = Common.getLogSessions(histVecName);
    logSessions.addElement(unboundHashtable);
    Common.saveLogSessions(histVecName, logSessions);
    // remove the client
    AngelLogin.logoutUser(histVecName);
  }
}
