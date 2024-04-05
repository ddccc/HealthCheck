// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.Disease;
import concepts.Treatment;
import concepts.TreatmentAction;
import concepts.Drug;

public class EditTreatments extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      HttpSession session = req.getSession(true);
      String name = (String) session.getValue("name");
      String code = (String) session.getValue("code");
      Vector treatmentsVecEdit = (Vector) session.getValue("treatmentsVecEdit");
      String addTreatment = (String) session.getValue("addTreatment");

      String newTreatmentName = name + "TrX";
      boolean isNewTreatment;

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Edit Treatments</TITLE></HEAD>");
      String script = 
"<SCRIPT LANGUAGE= \"JavaScript\">" + "\n" +
"function checkForm(form) {" +
	( addTreatment.equals("yes") ?
	  "if (form.newTreatmentName.value == \"" + newTreatmentName + "\") {" +
	      "alert(\"Change the new treatment name ...\");" +
	      "return false;" +
  	  "}" + "\n" : "") +
	treatmentsScript(treatmentsVecEdit, addTreatment.equals("yes")) + "\n" +
	"form.submit();" + "\n" +
"}" + "\n" +
"</SCRIPT>";
      out.println(script);
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H3>Edit Treatments for: " + name + "</H3>");

try {
      Disease aDisease = Common.getDisease(name);
      out.println("<table border>");
      out.println(aDisease.html());
      out.println("</table>");


      /*
      out.println("<br><b>Name:</b> " + name);
      out.println("<br><b>code</b>");
      out.println(code);
      */

      out.println("<br><b>treatmentsVecEdit: </b>" + treatmentsVecEdit.toString());
      out.println("<br><b>addTreatment: </b>" + addTreatment);


      out.println("<FORM NAME=editTreatments ACTION='" + D.servletEditTreatments2 + "'>");
      out.println("<table BORDER>");
      int lng = treatmentsVecEdit.size();

      String aTreatment, condition, treatmentActionName, treatmentAction2, drugName, drug2;
      Treatment tr;
      Drug drug;
      Vector treatmentActions, drugs;
      TreatmentAction treatmentAction;
      int lng2;
      String conditionx, conditionx2;

      String[] allTreatmentConditions = Common.allTreatmentConditions();
      int lngATC = allTreatmentConditions.length;

      for (int v = 0; v < lng; v++) {
	aTreatment = (String) treatmentsVecEdit.elementAt(v);
	isNewTreatment = aTreatment.equals(newTreatmentName);
	try{
	if ( isNewTreatment )
	  out.println("<tr><td><b>New TreatmentName:</b></td><td>" +
		      "<input type='text' name=newTreatmentName " + 
		      "size=55 + value=" + aTreatment + "></td></tr>");
	else
	  out.println("<tr><td><b>" + aTreatment + "</b></td></tr>");

	tr = (isNewTreatment ? null : Common.getTreatment(aTreatment));

	// conditions
	condition = (isNewTreatment ? null : tr.getCondition());
	out.println("<tr><td><b>Condition:</b></td><td>");
	out.println("<SELECT name=" + aTreatment+"_condition>");
	out.println("<OPTION VALUE=none" +
		    ( null == condition ? " SELECTED" : "" ) +
		  ">none"); 
	for (int i = 0; i < lngATC; i++ ) {
	  conditionx = allTreatmentConditions[i];
	  conditionx2 = eliminateSpace(conditionx);
	  out.println("<OPTION VALUE='" + conditionx2 + 
		      (null == condition ? "'>" :
		       (condition.equals(conditionx) ? "' SELECTED>" : "'>")) +
		      conditionx);
	}
	out.println("</SELECT>");
	out.println("?</td></tr>");

	// new condition
	out.println("<tr><td><b>Or NEW Condition:</b></td><td>" +
		  "<input type='text' name=" + 
		    aTreatment + "_newcondition  size=30></td></tr>");

	// treatmentAction
	treatmentActions = (isNewTreatment ? null : tr.getTreatmentActions());
	lng2 = (isNewTreatment ? 0 : treatmentActions.size());
	if ( 0 < lng2) out.println("<tr><td><b>TreatmentActions:</b></td></tr>");
	for (int i = 0; i<lng2; i++) {
	  treatmentAction = (TreatmentAction) treatmentActions.elementAt(i);
	  treatmentActionName = treatmentAction.getDescription();
	  treatmentAction2 = replaceSpace(treatmentActionName);
	  out.println("<tr><td>"+treatmentActionName+"</td><td>"+
	     "<INPUT TYPE='radio' NAME=" + aTreatment + "_" + treatmentAction2 +
	     " VALUE=keep CHECKED> keep? " +
	     "<INPUT TYPE='radio' NAME=" + aTreatment + "_" + treatmentAction2 +
	     " VALUE=remove> remove? " +
	     "</td></tr>");
	}

	// add treatment action
	String[] treatmentActs = Common.allTreatmentActions();
	lng2 = treatmentActs.length;
	out.println("<tr><td><b>Add treatmentAct(s):</b></td><td>");
	out.println("<SELECT name=" +
		    aTreatment + "_addTreatmentActs MULTIPLE SIZE=5>");
	for (int i = 0; i < lng2; i++) {
	  treatmentActionName = treatmentActs[i];
	  treatmentAction2 = replaceSpace(treatmentActionName);
	  out.println("<OPTION VALUE='" + treatmentAction2 + "'>" + treatmentActionName); 
	}
	out.println("</SELECT>");
	out.println("?</td></tr>");

	// create new treatment action
	out.println("<tr><td><b>New treatment action, if any:</b></td><td>" +
		  "<input type='text' name=" + 
		    aTreatment + "_newTreatmentAction  size=60></td></tr>");

	// drugs 
	drugs = (isNewTreatment ? null : tr.getDrugs());
	lng2 = (isNewTreatment ? 0 : drugs.size());
	if ( 0 < lng2) out.println("<tr><td><b>Drugs:</b></td></tr>");
	for (int i = 0; i<lng2; i++) {
	  drug = (Drug) drugs.elementAt(i);
	  drugName = drug.getDescription();
	  drug2 = replaceSpace(drugName);
	  out.println("<tr><td>"+drugName+"</td><td>"+
	     "<INPUT TYPE='radio' NAME=" + aTreatment + "_" + drug2 +
	     " VALUE=keep CHECKED> keep? " +
	     "<INPUT TYPE='radio' NAME=" + aTreatment + "_" + drug2 +
	     " VALUE=remove> remove? " +
	     "</td></tr>");
	}

	// add drug
	String[] allDrugs = Common.allDrugs();
	lng2 = allDrugs.length;
	out.println("<tr><td><b>Add drug(s):</b></td><td>");
	out.println("<SELECT name=" +
		    aTreatment + "_addDrugs MULTIPLE SIZE=5>");
	for (int i = 0; i < lng2; i++) {
	  treatmentActionName = allDrugs[i];
	  treatmentAction2 = replaceSpace(treatmentActionName);
	  out.println("<OPTION VALUE='" + treatmentAction2 + "'>" + treatmentActionName); 
	}
	out.println("</SELECT>");
	out.println("?</td></tr>");

	// create new drug
	out.println("<tr><td><b>New drug, if any:</b></td><td>" +
		  "<input type='text' name=" + 
		    aTreatment + "_newDrug  size=60></td></tr>");

	// out.println("<tr><td><b>html</b></td><td>" + tr.html() + "</td></tr>");

	
	} catch(Exception ex) {
	  out.println("Exception: " + ex.toString());
	  out.println("<pre>");
	  PrintWriter ps = new PrintWriter(out);
	  ex.printStackTrace(ps);
	  out.println("</pre>");
	}
      }

      out.println("</table>");

      out.println("<p><input type='button' value='Submit' " +
		  "onClick= \"checkForm(this.form)\">");
      lng = treatmentsVecEdit.size();
      // since the new treatment has no existing treatment actions or drugs:
      if ( addTreatment.equals("yes") ) lng--; 
      for (int v = 0; v < lng; v++) {
	aTreatment = (String) treatmentsVecEdit.elementAt(v);
	out.println("<input TYPE=\"hidden\" NAME= \"" +
		    aTreatment+"_treatmentActionsList\" VALUE=\"\">");
	out.println("<input TYPE=\"hidden\" NAME= \"" +
		    aTreatment+"_drugsList\" VALUE=\"\">");
      }
      /*
      out.println("<input TYPE=\"hidden\" NAME= \"membershipsList\" VALUE=\"\">");
      */
      out.println("</FORM>");
} catch (Exception ex) {
	   out.println("<b>Exception:</b> " + ex.toString());
	   out.println("<pre>");
	   PrintStream ps = new PrintStream(out);
	   ex.printStackTrace(ps);
	   out.println("</pre>");

}
      out.println("</BODY>");
      out.println("</HTML>");
    }

  private String eliminateSpace(String in) {
    return EditDisease.eliminateSpace(in);
  }

  private String replaceSpace(String in) {
    return in.replace(' ', '_');
  }

  private String treatmentsScript(Vector treatments, boolean newTreatment) {
    StringBuffer sb = new StringBuffer();
    int lng = treatments.size();
    String aTreatment;
    Treatment treatment;
    Vector tas, drugs;
    int lng2;
    String treatmentActionName, treatmentAction2, 
      radioName, line0, line1, line2, line3, drugName, dr2;
    TreatmentAction treatmentAction;
    Drug dr;
    for (int i = 0; i < lng; i++) {
      aTreatment = (String) treatments.elementAt(i);
      line0 = 
	  "selectedConditionIndex = form." + 
	             aTreatment + "_condition.selectedIndex; \n" +
	  "newCondition = form." + 
	             aTreatment + "_newcondition.value; \n" +
	  "if(newCondition != \"\" && 0 < selectedConditionIndex) {" +
	       "alert(\"A selected condition contradicts a new condition ...\");" +
	      "return false;" +
  	  "}" + "\n";
      sb.append(line0);
      // The last item is a new treatment is there is any ...
      if ( newTreatment && (i == lng-1) ) continue; // ugh - sorry 

      treatment = Common.getTreatment(aTreatment);
      tas = treatment.getTreatmentActions();
      lng2 = tas.size();
      for (int j = 0; j<lng2; j++) {
	treatmentAction = (TreatmentAction) tas.elementAt(j);
	treatmentActionName = treatmentAction.getDescription();
	treatmentAction2 = replaceSpace(treatmentActionName);
	radioName = aTreatment + "_" + treatmentAction2;
	sb.append("for(count=0;count<2;count++){");
	line1 = "if(form." + radioName + "[count].checked){";
	sb.append(line1);
	line2 = "  val=form." + radioName + "[count].value;";
	sb.append(line2);
	// sb.append("alert('*** val: ' + val);");
	line3 = "  form." + aTreatment + 
	  "_treatmentActionsList.value += ('|' + '" + radioName + "' + '.' + val);";
	sb.append(line3);
	// sb.append("alert('*** symptomsList: ' + form.symptomsList.value);");
	sb.append("  break; }} \n");
      }
      drugs = treatment.getDrugs();
      lng2 = drugs.size();
      for (int j = 0; j<lng2; j++) {
	dr = (Drug) drugs.elementAt(j);
	drugName = dr.getDescription();
	dr2 = replaceSpace(drugName);
	radioName = aTreatment + "_" + dr2;
	sb.append("for(count=0;count<2;count++){");
	line1 = "if(form." + radioName + "[count].checked){";
	sb.append(line1);
	line2 = "  val=form." + radioName + "[count].value;";
	sb.append(line2);
	// sb.append("alert('*** val: ' + val);");
	line3 = "  form." + aTreatment + 
	  "_drugsList.value += ('|' + '" + radioName + "' + '.' + val);";
	sb.append(line3);
	// sb.append("alert('*** symptomsList: ' + form.symptomsList.value);");
	sb.append("  break; }} \n");
      }
    }
    return sb.toString();
  }
}



