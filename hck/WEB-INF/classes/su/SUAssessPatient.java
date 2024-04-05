// (C) OntoOO Inc 2011 March
package su;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.Common;
import com.DV;
import com.DVM;
import com.D;
import misc.DB;
import misc.HCError;
import patient.AngelLogin;


/* Called now by PHLogin to assess a patient using a checklist.
   We double check the userName.
   We check whether the user is known already and if so we proceed with SUAssessPatient2.
   Otherwise we initialize the account with gender, age, etc. first.
*/
public class SUAssessPatient extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String userName = req.getParameter("userName");
      if ( null == userName ) {
	  HCError.call(res,
		      "User name is missing ..." +
		      "<br>Use the back arrow to return to the previous page.");
	  return;
      }

      // check it
      int lng = userName.length();
      if ( lng <= 0 || 10 < lng )  {
	  HCError.call(res,
		      "User name length unacceptable ..." +
		      "<br>Use the back arrow to return to the previous page.");
	  return;
      }

      char c;
      c = userName.charAt(0);
      if ( Character.isDigit(c) ) {
	  HCError.call(res, 
			"User name cannot start with a digit.<br />" +
			"Use the back arrow to return to the previous page.");
	  return;
      }

      for (int i = 0; i < lng; i++) {
	c = userName.charAt(i);
	if ( c == ' ' ) { 
	  HCError.call(res, 
			"No space allowed in the user name.<br />" +
			"Use the back arrow to return to the previous page.");
	    return;
	}
	if ( Character.isDigit(c) ) continue;
	if ( Character.isLowerCase(c) ) continue; 
	// if ( Character.isUpperCase(c) ) continue;
	HCError.call(res,
		      "Character(s) in the userName should be digit or lowercase letter.<br />" +
		      "Use the back arrow to return to the previous page.");
	return;
      }

      // Check user name
      String prefix2 = D.theUsersDir;
      DB props = null;
      try {
	  props = new DB(prefix2 + userName);
      } catch (IOException ignore) {}
      if ( null != props ) { // existing user !
	  props.put("intake", "1");
	  try { 
	      FileOutputStream fos = 
		  new FileOutputStream(prefix2 + userName);
	      props.store(fos, "SUAssessPatient");
	      fos.close();
	  }
	  catch (IOException ex) {
	      	HCError.call(res,
			     "Failure to use this existing account:" + userName + ".<br />" +
			     "Use the back arrow to return to the previous page.");
		return;
	  }
	  // We have a good user name.  Cancel session first:
	  HttpSession session = req.getSession(false);
	  if ( null != session ) {
	      session.invalidate();
	  }
	  String password = props.getProperty("password");
	  AngelLogin.call(req, res, userName, password);
	  return;
      }
      // last argument is true so that SUCA2 will set " props.put("intake", "1"); "
      SUCA2.call(req, res, userName, "anonymous", true);
    }

} // end SUAssessPatient
