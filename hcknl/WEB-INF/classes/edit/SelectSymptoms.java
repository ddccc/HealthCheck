// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.DV;
import com.D;
import com.LR;
import concepts.Symptom;

public class SelectSymptoms extends HttpServlet {

  static final private String heartAttackSymptoms1 = 
      ",chestPain,chestPain," +
      "shoulderPain,shoulderPain," +
      "neckPain,neckPain," +
      "jawPain,jawPain," +
      "armPitPain,armPitPain";
  static final private String heartAttackSymptoms2 = 
      ",lightHeadedness,lightHeadedness," +
      "fainting,fainting," +
      "sweating,sweating," +
      "nausea,nausea," +
      "shortOfBreath,shortOfBreath";

  static final private String strokeSymptoms1 = 
      ",lossOfMemory," + LR.amnesia + "," +
      "speakingTrouble," + LR.aphasia + "," +
      "confusion,confusion," +
      "understandingTrouble," + LR.dysphasia + "," +
      "oneSidedNumbness," + LR.hemiparesis;
  static final private String strokeSymptoms2 =   
      ",changedPupils," + LR.pupilChanges + "," +
      "sensoryChanges,sensoryChanges," +
      "speechSlurred,speechSlurred," +
      "weakness,weakness";

  static final private String popularSymptoms1 =
      ",chills,chills," +
      "headache,headache," +
      "musclePain," + LR.myalgia + "," +
      "cough,cough," +
      "crackles,crackles";
  static final private String popularSymptoms2 =
      ",stomachache,stomachache," +
      "constipated,constipated," +
      "diarrhea,diarrhea";

  static final private String allSymptoms2 =
  /* 2nd's of:
      heartAttackSymptoms1 + heartAttackSymptoms2 +
      strokeSymptoms1 + strokeSymptoms2 +
      popularSymptoms1 + popularSymptoms2;
      */
      seconds(heartAttackSymptoms1) + seconds(heartAttackSymptoms2) +
      seconds(strokeSymptoms1) + seconds(strokeSymptoms2) +
      seconds(popularSymptoms1) + seconds(popularSymptoms2);



    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      HttpSession session = req.getSession(true);
      session.setMaxInactiveInterval(3600000); 
      Hashtable sTotal = new Hashtable();
      Hashtable dTotal = new Hashtable();
      Integer roundInt = new Integer(0);
      session.putValue("sTotal", sTotal);
      session.putValue("dTotal", dTotal);
      session.putValue("roundInt", roundInt);

      String [] allSymptoms = Common.allSymptoms();
      int lng = allSymptoms.length;
      Vector allSymptomsVec = new Vector();
      Symptom symptom;
      Vector sortSymptomsVec = new Vector();
      for (int i = 0; i < lng; i++) {
	symptom = Common.getSymptom(allSymptoms[i]);
	allSymptomsVec.addElement(symptom);
	sortSymptomsVec.addElement(new DynamicSortSymptom(symptom));
      }
      Collections.sort(allSymptomsVec);

      session.putValue("allSymptomsVec", allSymptomsVec);
      session.putValue("sortSymptomsVec", sortSymptomsVec);
      session.putValue("symptomVecs", new Vector());

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>SelectSymptoms</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H1>SelectSymptoms</H1>");
      out.println("Select collection of start symptoms:");
      out.println("<FORM  ACTION='" + D.servletSelectSymptoms2 + "'>");
      out.println("<SELECT name='startSymptoms' MULTIPLE SIZE=6>");
      String dis, printName2;
      for (int i = 0; i < lng; i++) {
	dis = allSymptoms[i];
	symptom = Common.getSymptom(dis);
	printName2 = symptom.getName();
	out.println("<OPTION VALUE='" + dis + "'>" + printName2); 
      }
      out.println("</SELECT>");
      out.println("<p><input type='submit' value='Submit'>");
      out.println("<input TYPE='hidden' NAME='allSymptoms2' " +
		  "VALUE='" + allSymptoms2 + "'>");
      out.println("</FORM>");

      out.println(DV.htmlDismissOrBack);
      out.println("</BODY>");
      out.println("</HTML>");
    }
  
  static private String seconds(String list) {
    StringTokenizer st = new StringTokenizer(list, ",");
    StringBuffer sb = new StringBuffer();
    String token;
    while ( st.hasMoreTokens() ) {
      token = st.nextToken();
      token = st.nextToken();
      sb.append("," + token);
    }
    return sb.toString();
  }


}  


