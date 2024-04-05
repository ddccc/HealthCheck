// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import com.LR;
import concepts.PartLocation;
import concepts.ConnectionLocation;
import concepts.LocationRelation;
import concepts.LocationSet;

public class EditPartLocation2 extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      String trace = "start";
try{
      boolean doModifyIncore = true;

      String name = req.getParameter("name");
      String className = req.getParameter("className");
      String locationType = req.getParameter("locationType");
      String gender = req.getParameter("gender");
      String locationName1 = req.getParameter("locationName1");
      String position = req.getParameter("position");
      String leftRight = req.getParameter("leftRight");
      String topBottom = req.getParameter("topBottom");
      String backFront = req.getParameter("backFront");
      String addLocationSets = req.getParameter("addLocationSets");
      String addAdjacents = req.getParameter("addAdjacents");
      String addAlsoPartOfs = req.getParameter("addAlsoPartOfs");
      String membershipsList = req.getParameter("membershipsList"); 
      String adjacentsList = req.getParameter("adjacentsList"); 
      String alsoPartOfsList = req.getParameter("alsoPartOfsList"); 
      String referenceLocation1 =  req.getParameter("referenceLocation1");
      String referenceLocation2 =  req.getParameter("referenceLocation2");
      if ( referenceLocation1.equals("null") ) {
	referenceLocation1 = null; 
	referenceLocation2 = null; 
      }
      String superset =  req.getParameter("superset");
      if ( superset.equals("null") || superset.equals("none") ) superset = null;      

      String nameSt = name + "St";
      String lrnameSt = "LR." + nameSt;
      String lrName = "lr" + capitalize(name);

      String code = 
	"<br>LocationRelation " + lrName + " =" +
	"<br>   new LocationRelation(LR." + locationName1 + "St, " + lrnameSt + ", " +
	"LR." + position + ", " +
	"LR." + leftRight + ", " +
	"LR." + topBottom + ", " +
	"LR." + backFront + ");";

      LocationRelation newLocationRelation = null;
      if ( doModifyIncore )
	newLocationRelation =
	  new LocationRelation(locationName1,
			     name,
			     position,
			     leftRight,
			     topBottom,
			     backFront);

      code +=
	"<br>" + className + " " + name + " = new " + className + "(" + lrnameSt + ", " +
	"LR." + locationType + ", " + lrName +
	( null == referenceLocation1 ? ");" :
	  ", LR." + referenceLocation1 + "St, LR." +
	  referenceLocation2 + "St);");
      if ( null != superset ) 
	code +=
	  "<br>" + name + ".setSuperset(LR." + superset + "St);";
				

      // pl is the existing partlocation, if any, i.e. pl may be null!
      PartLocation pl = (PartLocation) Common.getLocation(name);

      // This is the new partlocation
      PartLocation newPL = null;

      if ( doModifyIncore ) {
	if ( null != referenceLocation1 ) {
	  newPL = new ConnectionLocation(
		      name, locationType, newLocationRelation, 
		      referenceLocation1, referenceLocation2);
	} else {
	  // Like LISP's lambda abstraction, but we worry about types ...
	  try{
	    Class aClass = Class.forName("concepts." + className); // no JRUN ...
	    Class strClass = Class.forName("java.lang.String");
	    Class lrClass = Class.forName(D.LocationRelationClass);
	    Class[] paramTypes = { strClass, strClass, lrClass };
	    java.lang.reflect.Constructor theConstructor = 
	      aClass.getConstructor(paramTypes);
	    Object[] theArgs = {name, locationType, newLocationRelation};
	    newPL = (PartLocation) theConstructor.newInstance(theArgs);
	    if ( null != superset ) {
	      LocationSet ls = (LocationSet) newPL;
	      ls.setSuperset(superset);
	    }
	  } catch(Exception ex) {
	    CharArrayWriter caw = new CharArrayWriter();
	    String str = "***** Reflect Exception: " + ex.toString();
	    str = str + "<br>className: " + className;
	    str = str + "<br>D.LocationRelationClass: " + D.LocationRelationClass;
	    caw.write(str, 0, str.length());
	    code += "<br>" + caw.toString();
	    doModifyIncore = false;

	  }
	}
      }

      if ( !gender.equals(LR.both) ) {
	 code += "<br>" + name + ".setGender(LR." + gender + ");";
	 if ( doModifyIncore ) 
	   newPL.setGender(gender);
      }

      if ( !membershipsList.equals("") ) {
	StringBuffer sb = new StringBuffer(code);
	StringTokenizer st = new StringTokenizer(membershipsList, ",");
	String locSet;
	while (st.hasMoreTokens()) {
	  locSet = st.nextToken();
	  sb.append("<br>" + name + ".addMembership(LR." + locSet + "St);");
	  if ( doModifyIncore )
	    newPL.addMembership(locSet);
	}
	code = sb.toString();
      }

      // Reminder pl has been set above with:
      // PartLocation pl = (PartLocation) Common.getLocation(name);
      // In case null == pl then adjacentsList.equals("") is true, hence
      // the body of the if statement is not entered

      // lrnameSt = "LR."+name+"St";
      if ( !adjacentsList.equals("") ) {
	StringBuffer sb = new StringBuffer(code);
	Vector adjacents = pl.getAdjacents();
	int lng = adjacents.size();
	LocationRelation lr, lrNew;
	String member, position2, leftRight2, topBottom2, backFront2;
	for (int i = 0; i < lng; i++) {
	  lr = (LocationRelation) adjacents.elementAt(i);
	  member = lr.getLocationName2();
	  if ( 0 <= adjacentsList.indexOf((member+".remove")) ) continue;
	  if ( 0 <= adjacentsList.indexOf((member+".edit")) ) {
	    if ( null == addAdjacents) 
	      addAdjacents = member;
	    else
	      addAdjacents += " " + member;
	    continue;
	  }
	  if ( adjacentsList.indexOf((member+".keep")) < 0 ) {
	    sb.append("<br>// Exception: " + member + " not in: " + adjacentsList);
	    continue;
	  }
	  position2 = lr.getPosition();
	  leftRight2 = lr.getLeftRight();
	  topBottom2 = lr.getTopBottom();
	  backFront2 = lr.getBackFront();
	  lrName = "lr"+capitalize(name)+capitalize(member);
	  String code2 = 
	    "<br>LocationRelation " + lrName + " =" +
	    "<br>   new LocationRelation(" + lrnameSt + ", LR." + member + "St, " +
	    "LR." + position2 + ", " +
	    "LR." + leftRight2 + ", " +
	    "LR." + topBottom2 + ", " +
	    "LR." + backFront2 + ");" +
	    "<br>" + name + ".addAdjacent(" + lrName + ");";

	  if ( doModifyIncore ) {
	    lrNew = new LocationRelation(
		       name, member, position2, leftRight2, topBottom2, backFront2);
	    newPL.addAdjacent(lrNew);
	  }
	  sb.append(code2);
	}
	code = sb.toString();
      }

      if ( !alsoPartOfsList.equals("") ) {
	Vector alsoPartOfs = pl.getAlsoPartOfs();
	int lng = alsoPartOfs.size();
	StringBuffer sb = new StringBuffer(code);
	StringTokenizer st = new StringTokenizer(alsoPartOfsList, ",");
	String containerLoc;
	String member, position2, leftRight2, topBottom2, backFront2;
	member = null;
	LocationRelation lr, lrNew;
	while (st.hasMoreTokens()) {
	  lr = null;
	  containerLoc = st.nextToken();
	  for (int i = 0; i < lng; i++) {
	    lr = (LocationRelation) alsoPartOfs.elementAt(i);
	    member = lr.getLocationName1();
	    if ( containerLoc.equals(member) ) break;
	  }
	  if ( null == lr ) {
	    sb.append("<br>// *** Error: can't find: " + containerLoc);
	    continue;
	  }
	  position2 = lr.getPosition();
	  leftRight2 = lr.getLeftRight();
	  topBottom2 = lr.getTopBottom();
	  backFront2 = lr.getBackFront();
	  lrName = "lr"+capitalize(name)+capitalize(member);
	  String code2 = 
	    "<br>LocationRelation " + lrName + " =" +
	    "<br>   new LocationRelation(LR." + member + "St, " + lrnameSt + ", " +
	    "LR." + position2 + ", " +
	    "LR." + leftRight2 + ", " +
	    "LR." + topBottom2 + ", " +
	    "LR." + backFront2 + ");" +
	    "<br>" + name + ".addAlsoPartOf(" + lrName + ");";
	  if ( doModifyIncore ) {
	    lrNew = new LocationRelation(
		       member, name, position2, leftRight2, topBottom2, backFront2);
	    newPL.addAlsoPartOf(lrNew);
	  }
	  sb.append(code2);
	}
	code = sb.toString();
      }

      if ( null != addLocationSets ) {
	StringBuffer sb = new StringBuffer(code);
	StringTokenizer st = new StringTokenizer(addLocationSets, ",");
	String locSet;
	while (st.hasMoreTokens()) {
	  locSet = st.nextToken();
	  sb.append("<br>" + name + ".addMembership(LR." + locSet + "St);");
	  if ( doModifyIncore ) {
	    newPL.addMembership(locSet);
	  }
	}
	code = sb.toString();
      }

      if ( (null != addAdjacents) || (null != addAlsoPartOfs) ) {
	HttpSession session = req.getSession(true);
	session.putValue("name", name);
	session.putValue("code", code);
	if ( null != addAdjacents ) 
	  session.putValue("addAdjacents", addAdjacents);
	if ( null != addAlsoPartOfs ) 
	  session.putValue("addAlsoPartOfs", addAlsoPartOfs);
	if ( null != newPL ) 
	  session.putValue("newPL", newPL);
	res.sendRedirect(D.servletEditPartLocation3);
	return;
      }

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Edit PartLocation2</TITLE></HEAD>");
      out.println("<BODY BGCOLOR=lightgreen>");
      out.println("<H3>Edit PartLocation2:</H3>");

      out.println("<br>name: " + name);
      out.println("<br>locationType: " + locationType);
      out.println("<br>gender: " + gender);
      out.println("<br>locationName1: " + locationName1);
      out.println("<br>position: " + position);
      out.println("<br>leftRight: " + leftRight);
      out.println("<br>topBottom: " + topBottom);
      out.println("<br>backFront: " + backFront);
      out.println("<br>addLocationSets: " + addLocationSets);
      out.println("<br>addAdjacents: " + addAdjacents);
      out.println("<br>addAlsoPartOfs: " + addAlsoPartOfs);
      out.println("<br>membershipsList: " + membershipsList);
      out.println("<br>adjacentsList: " + adjacentsList);
      out.println("<br>alsoPartOfsList: " + alsoPartOfsList);
      if ( null != referenceLocation1 )
	out.println("<br>referenceLocation1: " + referenceLocation1);
      if ( null != referenceLocation2 )
	out.println("<br>referenceLocation2: " + referenceLocation2);
      if ( null != newPL ) {
	out.println(newPL.html());
	Common.saveTheLocations();
      }
      out.println("<br><b>code generated:</b>");
      out.println(code);
      Vector codeLines = makeCodeLines(name, code);
      /*
      // to test:
      out.println("<br><b>AGAIN code  generated:</b>");
      for (int i = 0; i < codeLines.size(); i++) 
	out.println("<br>" + ((String)codeLines.elementAt(i)));
	*/
      String directory = D.theNewPartLocationsDir;
      writeCode(name, directory, codeLines, out);
      out.println("</BODY>");
      out.println("</HTML>");
} catch(Exception ex) {
      res.setContentType("text/html");
      ServletOutputStream outx = res.getOutputStream();
      outx.println("<HTML>");
      outx.println("<HEAD><TITLE>Edit Symptom Exception</TITLE></HEAD>");
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

  public static Vector makeCodeLines(String name, String code) {
    Vector vec = new Vector();
    //    vec.addElement("// " + name);
    vec.addElement("// -------------- " + name + " --------------");
    vec.addElement("// (C) OntoOO Inc " + ((new Date()).toString()) );
    if ( (null == code) || !code.startsWith("<br>") ) {
      vec.addElement(code);
      return vec;
    }
    return stripBR(code, vec);
  }

  public static Vector stripBR(String code, Vector vec) {
    // code starts with "<br>" ...
    int begin = 0; int next;
    String codeLine;
    while ( 0 <= begin ) {
      next = code.indexOf("<br>", begin + 1);
      if ( next < 0 ) {
	codeLine = code.substring(begin + 4);
      } else {
	codeLine = code.substring(begin + 4, next);
      }
      vec.addElement(codeLine);
      begin = next;
    }
    return vec;
  }

  public static void writeCode(String name, 
			       String directory,
			       Vector codeLines, 
			       ServletOutputStream out) throws IOException {
    File out2 = new File(directory + name + ".txt");
    try {
      FileOutputStream fos = new FileOutputStream(out2);
      PrintWriter pw = new PrintWriter(fos);
      for (int i = 0; i < codeLines.size(); i++) 
	pw.println( (String)codeLines.elementAt(i) );
	pw.flush();
	pw.close();
      } catch (IOException ex) {
	out.println("<H3>IOException: " + ex.getMessage() + "</H3>");
      }
  }

  private String capitalize(String in) { 
    if ( (null == in) || (in.length() <= 0) ) return in;
    return (Character.toUpperCase(in.charAt(0))) + in.substring(1);
  }

}



