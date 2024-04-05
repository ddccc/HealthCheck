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

public class EditTreatments2 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String trace = "start";

try{
      HttpSession session = req.getSession(true);
      String name = (String) session.getValue("name");
      String code = (String) session.getValue("code");
      Vector treatmentsVecEdit = (Vector) session.getValue("treatmentsVecEdit");
      String addTreatment = (String) session.getValue("addTreatment");
      Disease newDis = (Disease) session.getValue("newDis");
      boolean doModifyIncore = ( null != newDis );
      // doModifyIncore =false;
      String actualNewTreatmentName = 
	( addTreatment.equals("yes") ?
	  (String) req.getParameter("newTreatmentName") : "");

      String newTreatmentName = name + "TrX";
      boolean isNewTreatment;
      String aTreatment, aCondition, aNewCondition;
      Vector conditions = new Vector();
      Vector newconditions = new Vector();
      String theTreatmentActionList, aTreatmentAction, theAddTreatmentActs, newAct;
      String theDrugsList, aDrug, theAddDrugs, aNewDrug;
      Vector treatmentActions = new Vector();
      Vector addTreatmentActions = new Vector();
      Vector newTreatmentAction = new Vector();
      Vector drugs = new Vector();
      Vector addDrugs = new Vector();
      Vector newDrug = new Vector();
      String code2 = "";
      StringBuffer sb = new StringBuffer(code);
      int lng = treatmentsVecEdit.size();
      Vector vec;
      int lng2, aTreatmentLng;
      String prefix;
      Treatment newTreatment = null;
      for (int i = 0; i<lng; i++) {
	aTreatment = (String) treatmentsVecEdit.elementAt(i);
	prefix = aTreatment;
	if ( i == lng-1 && addTreatment.equals("yes") )
	  prefix = actualNewTreatmentName;
	aTreatmentLng = 1+aTreatment.length();
	aCondition = req.getParameter(aTreatment+"_condition");
	aNewCondition = req.getParameter(aTreatment+"_newcondition");
	if ( !aNewCondition.equals("") ) aCondition = aNewCondition;
	sb.append("<br>Treatment " + prefix + 
		  "  = new Treatment(\"" + prefix + "\"" +
		  (aCondition.equals("none") ? "" :
		   ", LR." + eliminateSpace(aCondition)) +  ");");
	if ( doModifyIncore ) {
	  if ( aCondition.equals("none") ) 
	    newTreatment = new Treatment(prefix);
	  else 
	    newTreatment = new Treatment(prefix, aCondition);
	}

	theTreatmentActionList = req.getParameter(aTreatment+"_treatmentActionsList");
	vec = EditDisease2.unpackList(theTreatmentActionList);
	lng2 = vec.size();
	for (int j = 0; j<lng2; j++) {
	  // croupTr3.addTreatmentAction(LR.homeCareAndRest);
	  aTreatmentAction = (String) vec.elementAt(j);
	  aTreatmentAction = aTreatmentAction.substring(aTreatmentLng);
	  aTreatmentAction = aTreatmentAction.replace('_', ' ');
	  sb.append("<br>" + prefix + ".addTreatmentAction(LR." +
		    eliminateSpace(aTreatmentAction) + ");");
	  if ( doModifyIncore ) 
	    newTreatment.addTreatmentAction(aTreatmentAction);
	}
	theAddTreatmentActs = req.getParameter(aTreatment+"_addTreatmentActs");
	vec = EditDisease2.unpackListS(theAddTreatmentActs);
	lng2 = vec.size();
	for (int j = 0; j<lng2; j++) {
	  // croupTr3.addTreatmentAction(LR.homeCareAndRest);
	  aTreatmentAction = (String) vec.elementAt(j);
	  aTreatmentAction = aTreatmentAction.replace('_', ' ');
	  sb.append("<br>" + prefix + ".addTreatmentAction(LR." +
		     eliminateSpace(aTreatmentAction) + ");");
	  if ( doModifyIncore ) 
	    newTreatment.addTreatmentAction(aTreatmentAction);
	}
	newAct = req.getParameter(aTreatment+"_newTreatmentAction");
	if ( !newAct.equals("") ) {
	  sb.append("<br>" + prefix + ".addTreatmentAction(LR." +
		    eliminateSpace(newAct) + ");");
	  if ( doModifyIncore ) 
	    newTreatment.addTreatmentAction(newAct);
	}

	theDrugsList = req.getParameter(aTreatment+"_drugsList");
	vec = EditDisease2.unpackList(theDrugsList);
	lng2 = vec.size();
	for (int j = 0; j<lng2; j++) {
	  // croupTr1.addDrug(LR.ifFeverProvideAntipyretic);
	  aDrug = (String) vec.elementAt(j);
	  aDrug = aDrug.substring(aTreatmentLng);
	  aDrug = aDrug.replace('_', ' ');
	  sb.append("<br>" + prefix + ".addDrug(LR." +
		    eliminateSpace(aDrug) + ");");
	  if ( doModifyIncore )
	    newTreatment.addDrug(aDrug);
	}
	theAddDrugs = req.getParameter(aTreatment+"_addDrugs");
	vec = EditDisease2.unpackListS(theAddDrugs);
	lng2 = vec.size();
	for (int j = 0; j<lng2; j++) {
	  // croupTr1.addDrug(LR.ifFeverProvideAntipyretic);
	  aDrug = (String) vec.elementAt(j);
	  aDrug = aDrug.replace('_', ' ');
	  sb.append("<br>" + prefix + ".addDrug(LR." +
		    eliminateSpace(aDrug) + ");");
	  if ( doModifyIncore ) 
	    newTreatment.addDrug(aDrug);
	}
	aNewDrug = req.getParameter(aTreatment+"_newDrug");
	if ( !aNewDrug.equals("") ) {
	  sb.append("<br>" + prefix + ".addDrug(LR." +
		    eliminateSpace(aNewDrug) + ");");
	  if ( doModifyIncore ) 
	    newTreatment.addDrug(aNewDrug);
	}
	//    croupDis.addTreatment(croupTr1.getName());
	sb.append("<br>" + name + "Dis.addTreatment(" + 
		  prefix + ".getName());");
	if ( doModifyIncore ) 
	  newDis.addTreatment(prefix);

	conditions.addElement(aCondition);
	newconditions.addElement(aNewCondition);
	treatmentActions.addElement(theTreatmentActionList);
 	addTreatmentActions.addElement(theAddTreatmentActs);
	newTreatmentAction.addElement(newAct);
	drugs.addElement(theDrugsList);
	addDrugs.addElement(theAddDrugs);
	newDrug.addElement(aNewDrug);
      }
      code2 = sb.toString();

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Edit Treatments2</TITLE></HEAD>");

      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H3>Edit Treatments2:</H3>");
      out.println("<br><b>Name:</b> " + name);
      /*
      out.println("<br><b>1st code:</b>");
      out.println(code);
      */
      out.println("<br><b>treatmentsVecEdit: </b>");
      out.println(treatmentsVecEdit.toString());
      out.println("<br><b>addTreatment: </b>");
      out.println(addTreatment);
      out.println("<br><b>actualNewTreatmentName: </b>");
      out.println(actualNewTreatmentName);
      out.println("<br><b>conditions: </b>");
      out.println(conditions.toString());
      out.println("<br><b>newconditions: </b>");
      out.println(newconditions.toString());
      out.println("<br><b>treatmentActions: </b>");
      out.println(treatmentActions.toString());
      out.println("<br><b>addTreatmentActions: </b>");
      out.println(addTreatmentActions.toString());
      out.println("<br><b>newTreatmentAction: </b>");
      out.println(newTreatmentAction.toString());
      out.println("<br><b>drugs: </b>");
      out.println(drugs.toString());
      out.println("<br><b>addDrugs: </b>");
      out.println(addDrugs.toString());
      out.println("<br><b>newDrug: </b>");
      out.println(newDrug.toString());
      out.println("<br><b>2nd code:</b>");
      out.println(code2);

      if ( null != newDis) {
	out.println("<table border>");
	out.println(newDis.html());
	out.println("</table>");
	Common.saveHashTables();
	out.println("<H3>Hash tables have been saved ... </H3>");
      } 

      Vector codeLines = EditPartLocation2.makeCodeLines(name, code2);
      String directory = D.theNewDiseasesDir;
      EditPartLocation2.writeCode(name, directory, codeLines, out);

      out.println("<H3>Code has been generated ...</H3>");
      out.println("</BODY>");
      out.println("</HTML>");

    } catch (Exception ex) {
      res.setContentType("text/html");
      ServletOutputStream outx = res.getOutputStream();
      outx.println("<HTML>");
      outx.println("<HEAD><TITLE>EditTreaments2 Exception</TITLE></HEAD>");
      outx.println("<BODY BGCOLOR=red>");
      outx.println("<H3>Trace: " + trace + "</H3>");
      	  outx.println("Exception: " + ex.toString());
	  outx.println("<pre>");
	  PrintStream ps = new PrintStream(outx);
	  ex.printStackTrace(ps);
	  outx.println("</pre>");
      outx.println("</BODY>");
      outx.println("</HTML>");
    }

    }

  private String capitalize(String in) { 
    if ( (null == in) || (in.length() <= 0) ) return in;
    return (Character.toUpperCase(in.charAt(0))) + in.substring(1);
  }

  private String eliminateSpace(String in) {
    return EditDisease.eliminateSpace(in);
  }

}



