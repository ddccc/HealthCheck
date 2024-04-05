// Copyright Dennis de Champeaux/ OntoOO 2011 
package misc;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.DV;
import com.D;
import com.Common;
import com.LR;
import concepts.Drug;
import concepts.Disease;
import misc.DB;
import patient.History;
import patient.Diag1b;
import patient.AngelLogin;
import misc.HCError;

public class ShowUserAccount extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
    throws ServletException, IOException {
	String account = req.getParameter("account");
	String fileName = account;
	String prefix2 = D.theUsersDir;
	DB props = null;
	try {
	    props = new DB(prefix2 + fileName);
	} catch (IOException ignore) {}
	if ( null == props ) {
	    HCError.call(res, 
			 "Account not found ...<br />" +
			 "Use the back arrow to return to the previous page.");
	    return;
	}

	res.setContentType("text/html");
	ServletOutputStream out = res.getOutputStream();
	out.println("<html>");
	out.println("<head><title>An Account</title></head>");
	// out.println(DV.scriptShowAccount);
	out.println("<body bgcolor=\"bbbbbb\">");

	out.println("<h3>The User Account: " + account + "</h3>");

	userAccountHeader(props, out);
	
	Vector logSessions = Common.getLogSessions(fileName);
	int lng = logSessions.size(); 
	if ( lng <= 0 ) {
	    out.println(DV.htmlDismissOrBack);
	    out.println("</body>");
	    out.println("</html>");
	    return;
	}
	// stuff from logSessions
	
	// in case we must deal with DiseaseInstHist:
	History.scriptDiseaseInstHist(out, fileName);

	StringBuffer sb = new StringBuffer("<p><table border=\"1\">");
	History.processLogSessions(sb, logSessions, false);
      
	sb.append("</table>");
	out.println(sb.toString());
	out.println(DV.htmlBack);
	
	out.println("</body>");
	out.println("</html>");
    } // end doGet

    static public void userAccountHeader(DB props, ServletOutputStream out) 
	throws IOException {
	out.println(Diag1b.popupDisplayDrug);
	out.println(Diag1b.popupDisplayDisease);
	int anchor = 1000; // for popup links

	out.println("<b>password:</b> " + props.getProperty("password"));
	String gender = props.getProperty("gender");
	out.println("<br /><b>gender:</b> " + gender);
	out.println("<br /><b>age:</b> " + AngelLogin.calcAge(props));
	String[] keys = new String[] { 
	    "dob", "race", "height" };
	String key, value;
	for ( int i = 0; i < keys.length; i++ ) {
	    key = keys[i]; value = props.getProperty(key);
	    if ( null != value )
		out.println("<br /><b>" + key + ":</b> " + value);
	}
	value = props.getMostRecent("weight");
	if ( null != value )
	    out.println("<br /><b>weight:</b> " + value);
	keys = new String[] { 
	    "bloodGroup", "stress",
	    "maritalStatus", "sexPartner",
	    "exercising", "alcohol", "smoking",
	    "myPhysician"
	};
	for ( int i = 0; i < keys.length; i++ ) {
	    key = keys[i]; value = props.getProperty(key);
	    if ( null != value )
		out.println("<br /><b>" + key + ":</b> " + value);
	}
	String statusCondition = props.getProperty("statusCondition");
	out.println("<br /><b>status condition:</b> " + statusCondition);
	if ( gender.equals(LR.female) ) {
	    if ( statusCondition.equals("pregnant") ) {
		out.println("<br /><b>Date Last Menstruation:</b> " +
			    props.getProperty("pregnantDate"));
	    } else {
		if ( !statusCondition.equals("premenstruation") ) {
		    out.println("<br /><b># Life Births:</b> " +
				props.getProperty("numLifeBirths"));
		    out.println("<br /><b># Miscarriages:</b> " +
				props.getProperty("numMiscarriages"));
		    out.println("<br /><b># Stillbirths:</b> " + 
				props.getProperty("numStillBirths"));
		}
	    }
	}

	String usedDrugs = props.getProperty("drugs_used");
	if ( null != usedDrugs && !usedDrugs.equals("") ) {
	    value = "";
	    StringTokenizer st = new StringTokenizer(usedDrugs, ",");
	    while ( st.hasMoreTokens() ) {
		anchor++;
		String drugName = st.nextToken();
		Drug drug = Common.getDrug(drugName);
		value = value + 
		    "<a href=\"#" + anchor + "\" name=\"" + anchor +
		    "\" onClick=\"displayDrug('" + drugName + "')\">" + 
		    drug.getPrintName() + "</a> ";
	    }
	    out.println("<br /><b>drugs used:</b> " + value);
	}

	usedDrugs = props.getProperty("drugs_causing_allergy");
	if ( null != usedDrugs && !usedDrugs.equals("") ) {
	    value = "";
	    StringTokenizer st = new StringTokenizer(usedDrugs, ",");
	    while ( st.hasMoreTokens() ) {
		anchor++;
		String drugName = st.nextToken();
		Drug drug = Common.getDrug(drugName);
		value = value + 
		    "<a href=\"#" + anchor + "\" name=\"" + anchor +
		    "\" onClick=\"displayDrug('" + drugName + "')\">" + 
		    drug.getPrintName() + "</a> ";
	    }
	    out.println("<br /><b>drugs causing allergy:</b> " + value);
	}

	String diseases = props.getProperty("diseases_of_father");
	if ( null != diseases && !diseases.equals("") ) {
	    value = "";
	    StringTokenizer st = new StringTokenizer(diseases, ",");
	    while ( st.hasMoreTokens() ) {
		anchor++;
		String disName = st.nextToken();
		Disease dis = Common.getDisease(disName);
		value = value + 
		    "<a href=\"#" + anchor + "\" name=\"" + anchor +
		    "\" onClick=\"displayDisease('" + disName + "')\">" + 
		    dis.getPrintName() + "</a> ";
	    }
	    out.println("<br /><b>diseases of father:</b> " + value);
	}
	diseases = props.getProperty("diseases_of_mother");
	if ( null != diseases && !diseases.equals("") ) {
	    value = "";
	    StringTokenizer st = new StringTokenizer(diseases, ",");
	    while ( st.hasMoreTokens() ) {
		anchor++;
		String disName = st.nextToken();
		Disease dis = Common.getDisease(disName);
		value = value + 
		    "<a href=\"#" + anchor + "\" name=\"" + anchor +
		    "\" onClick=\"displayDisease('" + disName + "')\">" + 
		    dis.getPrintName() + "</a> ";
	    }
	    out.println("<br /><b>diseases of mother:</b> " + value);
	}
	diseases = props.getProperty("diseases_of_sibling");
	if ( null != diseases && !diseases.equals("") ) {
	    value = "";
	    StringTokenizer st = new StringTokenizer(diseases, ",");
	    while ( st.hasMoreTokens() ) {
		anchor++;
		String disName = st.nextToken();
		Disease dis = Common.getDisease(disName);
		value = value + 
		    "<a href=\"#" + anchor + "\" name=\"" + anchor +
		    "\" onClick=\"displayDisease('" + disName + "')\">" + 
		    dis.getPrintName() + "</a> ";
	    }
	    out.println("<br /><b>diseases of sibling:</b> " + value);
	}

	value = props.getProperty("accountCreationDate");
	long x = 0;
	try { x = Long.parseLong(value); }
	catch (NumberFormatException ignore) {}
	Date aDate = new Date(x);
	out.println("<br /><b>accountCreationDate:</b> " + aDate.toString());
    }



} // end ShowUserAccount
