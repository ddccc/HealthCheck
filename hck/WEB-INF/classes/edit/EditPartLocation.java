// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.Common;
import com.D;
import concepts.PartLocation;
import concepts.Location;
import concepts.LocationRelation;

public class EditPartLocation extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      // if we come in from ConnectionLocation:
      String referenceLocation1 =  req.getParameter("referenceLocation1");
      String referenceLocation2 =  req.getParameter("referenceLocation2");
      // if we come in from LocationSet:
      String superset =  req.getParameter("superset");
      // common to all:
      // pl = existing pl | newPartLocation | newConnectionLocation | newLocationSet
      String pl = req.getParameter("pl"); 
      boolean newPartLocation = 
	pl.equals("newPartLocation") || 
	pl.equals("newConnectionLocation") ||
	pl.equals("newLocationSet")  ;
      PartLocation abpl = ( newPartLocation ? null : 
			    (PartLocation) Common.getLocation(pl) );
      Class theClass = ( newPartLocation ? null : abpl.getClass() );
      String className = ( !newPartLocation ? theClass.getName() :
			   ( null != referenceLocation1 ? 
			     D.ConnectionLocationClass :
			     ( null != superset ?
			       D.LocationSetClass :
			       D.PartLocationClass ))); 
      String locationType = ( newPartLocation ? "provide location type" :
			   abpl.getLocationType());
      String gender = ( newPartLocation ? "provide gender" : abpl.getGender() );
      LocationRelation partOf = 
	( newPartLocation ? 
	  new LocationRelation("select", pl, "select", "select", "select", "select") :
	  abpl.getPartOf() );
      Vector memberships = ( newPartLocation ? null : abpl.getMemberships() );
      boolean bMemberships = ( (null != memberships) && (0 < memberships.size()) );
      Vector adjacents = ( newPartLocation ? null : abpl.getAdjacents() );
      boolean bAdjacents = ( (null != adjacents) && (0 < adjacents.size()) );
      Vector alsoPartOfs = ( newPartLocation ? null : abpl.getAlsoPartOfs() );
      boolean bAlsoPartOfs = ( (null != alsoPartOfs) && (0 < alsoPartOfs.size()) );

      String [] allLocations = Common.allLocations();
      int lng = allLocations.length;

      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<HTML>");
      out.println("<HEAD><TITLE>Edit PartLocation</TITLE></HEAD>");
      String script =
"<SCRIPT LANGUAGE= \"JavaScript\">" +
"function checkForm(form) {" +
	"if ( (form.name.value == \"\") || (form.name.value == \"newPartLocation\") ) {" +
	     "alert(\"Need value in Name: field ...\");" +
	     "return false;" +
	"}" +
	( bMemberships ? 
	  ( 1 < memberships.size() ?
	    "for (i = 0; i<form.memberships.length; i++) {" +
	       "if ( form.memberships[i].checked ) {" + 
	           "form.membershipsList.value += (\",\" + form.memberships[i].value);" +
	       "} }" :
	    "if ( form.memberships.checked ) {" + 
	           "form.membershipsList.value = form.memberships.value; }" )
	    :
	    "") +
	( bAdjacents ? adjacentsScript(adjacents) : "") +
	/*
	  ( 1 < adjacents.size() ?
	    "for (i = 0; i<form.adjacents.length; i++) {" +
	       "if ( form.adjacents[i].checked ) {" + 
	           "form.adjacentsList.value += (\",\" + form.adjacents[i].value);" +
	       "} }" :
	    "if ( form.adjacents.checked ) {" + 
	           "form.adjacentsList.value = form.adjacents.value; }" )

	    :
	   "") +
	   */
	( bAlsoPartOfs ? 
	  ( 1 < alsoPartOfs.size() ?
	    "for (i = 0; i<form.alsoPartOfs.length; i++) {" +
	       "if ( form.alsoPartOfs[i].checked ) {" + 
	           "form.alsoPartOfsList.value += (\",\" + form.alsoPartOfs[i].value);" +
	       "} }" :
	    "if ( form.alsoPartOfs.checked ) {" + 
	           "form.alsoPartOfsList.value = form.alsoPartOfs.value; }" )
	    :
	   "") +
	"form.submit();" +
"}" +
"</SCRIPT>";

      out.println(script);
      out.println("<BODY BGCOLOR=lightgreen>");
      if ( newPartLocation )
	out.println("<H3>Create a new location:</H3>");
      else
	out.println("<H3>Edit the location: " + pl + "</H3>");

      out.println("<FORM NAME=editPartLocation " +
		  "ACTION='" + D.servletEditPartLocation2 + "'>");
      out.println("<table BORDER>");
      out.println("<tr><td><b>Name:</b></td><td>" +
		  "<input type='text' name='name' size=30 value='" +
		  pl + "'> NO spaces as in: leftArm" +
		  "</td></tr>");
      if ( null != referenceLocation1 ) {
	out.println("<tr><td><b>referenceLocation1:</b></td><td>" + 
		    referenceLocation1 + "</td></tr>");
	out.println("<tr><td><b>referenceLocation2:</b></td><td>" + 
		    referenceLocation2 + "</td></tr>");
      }
      if ( null != superset && !superset.equals("") )
	out.println("<tr><td><b>superset:</b></td><td>" + 
		    superset + "</td></tr>");

      out.println("<tr><td><b>Select the class:</b></td><td>");
      out.println("<SELECT name=className>");
      out.println("<OPTION VALUE='PartLocation'" + 
		  ( className.equals(D.PartLocationClass) ? " SELECTED" : "") +
		  ">PartLocation"); 
      out.println("<OPTION VALUE='Bone'" + 
		  ( className.equals(D.BoneClass) ? " SELECTED" : "") +
		  ">Bone"); 
      out.println("<OPTION VALUE='Muscle'" + 
		  ( className.equals(D.MuscleClass) ? " SELECTED" : "") +
		  ">Muscle"); 
      out.println("<OPTION VALUE='Organ'" + 
		  ( className.equals(D.OrganClass) ? " SELECTED" : "") +
		  ">Organ"); 
      out.println("<OPTION VALUE='Tendon'" + 
		  ( className.equals(D.TendonClass) ? " SELECTED" : "") +
		  ">Tendon"); 
      out.println("<OPTION VALUE='Vein'" + 
		  ( className.equals(D.VeinClass) ? " SELECTED" : "") +
		  ">Vein"); 
      out.println("<OPTION VALUE='LocationSet'" + 
		  ( className.equals(D.LocationSetClass) ? " SELECTED" : "") +
		  ">LocationSet"); 
      out.println("<OPTION VALUE='BoneSet'" + 
		  ( className.equals(D.BoneSetClass) ? " SELECTED" : "") +
		  ">BoneSet"); 
      out.println("<OPTION VALUE='MuscleSet'" + 
		  ( className.equals(D.MuscleSetClass) ? " SELECTED" : "") +
		  ">MuscleSet"); 
      out.println("<OPTION VALUE='OrganSet'" + 
		  ( className.equals(D.OrganSetClass) ? " SELECTED" : "") +
		  ">OrganSet"); 
      out.println("<OPTION VALUE='TendonSet'" + 
		  ( className.equals(D.TendonSetClass) ? " SELECTED" : "") +
		  ">TendonSet"); 
      out.println("<OPTION VALUE='VeinSet'" + 
		  ( className.equals(D.VeinSetClass) ? " SELECTED" : "") +
		  ">VeinSet"); 
      out.println("<OPTION VALUE='ConnectionLocation'" + 
		  ( className.equals(D.ConnectionLocationClass) ? " SELECTED" : "") +
		  ">ConnectionLocation"); 
      // ... and other subclasses of PartLocation
      out.println("</SELECT>");
      out.println("</td></tr>");

      out.println("<tr><td><b>Select the locationType:</b></td><td>");
      out.println("<SELECT name=locationType>");
      out.println("<OPTION VALUE='d3'" + 
		  ( locationType.equals("d3") ? " SELECTED" : "") +
		  ">d3"); 
      out.println("<OPTION VALUE='d2'" + 
		  ( locationType.equals("d2") ? " SELECTED" : "") +
		  ">d2");
      out.println("<OPTION VALUE='d1'" + 
		  ( locationType.equals("d1") ? " SELECTED" : "") +
		  ">d1"); 
      out.println("<OPTION VALUE='d0'" + 
		  ( locationType.equals("d0") ? " SELECTED" : "") +
		  ">d0"); 
      out.println("</SELECT>");
      out.println("</td></tr>");

      out.println("<tr><td><b>Select the gender:</b></td><td>");
      out.println("<SELECT name=gender>");
      out.println("<OPTION VALUE='both'" + 
		  ( gender.equals("both") ? " SELECTED" : "") +
		  ">both"); 
      out.println("<OPTION VALUE='male'" + 
		  ( gender.equals("male") ? " SELECTED" : "") +
		  ">male"); 
      out.println("<OPTION VALUE='female'" + 
		  ( gender.equals("female") ? " SELECTED" : "") +
		  ">female");
      out.println("</SELECT>");
      out.println("</td></tr>");

      String locationName1 = partOf.getLocationName1();
      out.println("<tr><td><b>Select the containing loc:</b></td><td>");
      out.println("<SELECT name=locationName1>");
      String loc1;
      for (int i = 0; i < lng ; i++) {
	loc1 = allLocations[i];
	out.println("<OPTION VALUE='" + loc1 + "'" +
		    ( loc1.equals(locationName1) ? " SELECTED" : "" ) + 
		    ">" + loc1); 
      }
      out.println("</SELECT>");
      out.println("</td></tr>");

      String position = partOf.getPosition();
      out.println("<tr><td><b>Select the position:</b></td><td>");
      out.println("<SELECT name=position>");
      out.println("<OPTION VALUE='inside'" + 
		  ( position.equals("inside") ? " SELECTED" : "") +
		  ">inside"); 
      out.println("<OPTION VALUE='surface'" + 
		  ( position.equals("surface") ? " SELECTED" : "") +
		  ">surface"); 
      out.println("</SELECT>");
      out.println("</td></tr>");

      String leftRight = partOf.getLeftRight();
      out.println("<tr><td><b>Select leftRight:</b></td><td>");
      out.println("<SELECT name=leftRight>");
      out.println("<OPTION VALUE='left'" + 
		  ( leftRight.equals("left") ? " SELECTED" : "") +
		  ">left"); 
      out.println("<OPTION VALUE='right'" + 
		  ( leftRight.equals("right") ? " SELECTED" : "") +
		  ">right"); 
      out.println("<OPTION VALUE='middle'" + 
		  ( leftRight.equals("middle") ? " SELECTED" : "") +
		  ">middle"); 
      out.println("<OPTION VALUE='leftToRight'" + 
		  ( leftRight.equals("leftToRight") ? " SELECTED" : "") +
		  ">leftToRight"); 
      out.println("<OPTION VALUE='leftToMiddle'" + 
		  ( leftRight.equals("leftToMiddle") ? " SELECTED" : "") +
		  ">leftToMiddle"); 
      out.println("<OPTION VALUE='rightToMiddle'" + 
		  ( leftRight.equals("rightToMiddle") ? " SELECTED" : "") +
		  ">rightToMiddle");
      out.println("<OPTION VALUE='na'" + 
		  ( leftRight.equals("na") ? " SELECTED" : "") +
		  ">na"); 
      out.println("</SELECT>");
      out.println("</td></tr>");

      String topBottom = partOf.getTopBottom();
      out.println("<tr><td><b>Select topBottom:</b></td><td>");
      out.println("<SELECT name=topBottom>");
      out.println("<OPTION VALUE='top'" + 
		  ( topBottom.equals("top") ? " SELECTED" : "") +
		  ">top"); 
      out.println("<OPTION VALUE='bottom'" + 
		  ( topBottom.equals("bottom") ? " SELECTED" : "") +
		  ">bottom"); 
      out.println("<OPTION VALUE='middle'" + 
		  ( topBottom.equals("middle") ? " SELECTED" : "") +
		  ">middle");
      out.println("<OPTION VALUE='topToBottom'" + 
		  ( topBottom.equals("topToBottom") ? " SELECTED" : "") +
		  ">topToBottom"); 
      out.println("<OPTION VALUE='topToMiddle'" + 
		  ( topBottom.equals("topToMiddle") ? " SELECTED" : "") +
		  ">topToMiddle");
      out.println("<OPTION VALUE='bottomToMiddle'" + 
		  ( topBottom.equals("bottomToMiddle") ? " SELECTED" : "") +
		  ">bottomToMiddle");
      out.println("<OPTION VALUE='na'" + 
		  ( topBottom.equals("na") ? " SELECTED" : "") +
		  ">na"); 
      out.println("</SELECT>");
      out.println("</td></tr>");

      String backFront = partOf.getBackFront();
      out.println("<tr><td><b>Select backFront:</b></td><td>");
      out.println("<SELECT name=backFront>");
      out.println("<OPTION VALUE='front'" + 
		  ( backFront.equals("front") ? " SELECTED" : "") +
		  ">front"); 
      out.println("<OPTION VALUE='back'" + 
		  ( backFront.equals("back") ? " SELECTED" : "") +
		  ">back"); 
      out.println("<OPTION VALUE='middle'" + 
		  ( backFront.equals("middle") ? " SELECTED" : "") +
		  ">middle");
      out.println("<OPTION VALUE='backToFront'" + 
		  ( backFront.equals("backToFront") ? " SELECTED" : "") +
		  ">backToFront"); 
      out.println("<OPTION VALUE='frontToMiddle'" + 
		  ( backFront.equals("frontToMiddle") ? " SELECTED" : "") +
		  ">frontToMiddle");
      out.println("<OPTION VALUE='backToMiddle'" + 
		  ( backFront.equals("backToMiddle") ? " SELECTED" : "") +
		  ">backToMiddle"); 
      out.println("<OPTION VALUE='na'" + 
		  ( backFront.equals("na") ? " SELECTED" : "") +
		  ">na"); 
      out.println("</SELECT>");
      out.println("</td></tr>");

      if ( bMemberships ) {
	out.println("<tr><td><b>Keep memberships:</b></td><td>");
	lng = memberships.size();
	String member;
	for (int i = 0; i < lng; i++) {
	  member = (String)memberships.elementAt(i);
	  out.println("<br><INPUT TYPE='checkbox' NAME=memberships VALUE=" +
		      member + " CHECKED> " + member + "?");
	}
	out.println("</td></tr>");
      }

      String [] allLocationSets = Common.allLocationSets();
      lng = allLocationSets.length;
      out.println("<tr><td><b>Add memberships:</b></td><td>");
      out.println("<SELECT name=addLocationSets MULTIPLE SIZE=5>");
      String dis;
      // Location location;
      for (int i = 0; i < lng; i++) {
	dis = allLocationSets[i];
	// location = Common.getLocation(dis);
	// printName2 = location.getName();
	out.println("<OPTION VALUE='" + dis + "'>" + dis); 
      }
      out.println("</SELECT>");
      out.println("?</td></tr>");

      if ( bAdjacents ) {
	out.println("<tr><td><b>Adjacents:</b></td></tr>");
	lng = adjacents.size();
	LocationRelation lr;
	String member, position2, leftRight2, topBottom2, backFront2;
	for (int i = 0; i < lng; i++) {
	  lr = (LocationRelation) adjacents.elementAt(i);
	  position2 = lr.getPosition();
	  if ( !position2.equals("adjacent") ) continue;
	  member = lr.getLocationName2();
	  leftRight2 = lr.getLeftRight();
	  topBottom2 = lr.getTopBottom();
	  backFront2 = lr.getBackFront();
	  out.println(
             "<tr><td>" + member + " " +
	     "<INPUT TYPE='radio' NAME=" + member + " VALUE=keep CHECKED> keep? " +
	     "<INPUT TYPE='radio' NAME=" + member + " VALUE=edit> edit? " +
	     "<INPUT TYPE='radio' NAME=" + member + " VALUE=remove> remove? " +
	     "</td>");
	  out.println("<td>" +
		      " <b>position:</b> " + position2 +
		      " <b>leftRight:</b> " + leftRight2 +
		      " <b>topBottom:</b> " + topBottom2 +
		      " <b>backFront:</b> " + backFront2 +
		      "</td></tr>");
	}
	// out.println("</td></tr>");
      }

      // String [] allLocationSets = Common.allLocationSets();
      lng = allLocations.length;
      out.println("<tr><td><b>Add adjacents:</b></td><td>");
      out.println("<SELECT name=addAdjacents MULTIPLE SIZE=5>");
      // String dis;
      // Location location;
      for (int i = 0; i < lng; i++) {
	dis = allLocations[i];
	// location = Common.getLocation(dis);
	// printName2 = location.getName();
	out.println("<OPTION VALUE='" + dis + "'>" + dis); 
      }
      out.println("</SELECT>");
      out.println("?</td></tr>");

      if ( bAlsoPartOfs ) {
	out.println("<tr><td><b>Keep alsoPartOfs:</b></td><td>");
	lng = alsoPartOfs.size();
	LocationRelation lr;
	String member;
	for (int i = 0; i < lng; i++) {
	  lr = (LocationRelation) alsoPartOfs.elementAt(i);
	  member = lr.getLocationName1();
	  out.println("<br><INPUT TYPE='checkbox' NAME=alsoPartOfs VALUE=" +
		      member + " CHECKED> " + member + "?");
	}
	out.println("</td></tr>");
      }

      // String [] allLocationSets = Common.allLocationSets();
      lng = allLocations.length;
      out.println("<tr><td><b>Add alsoPartOfs:</b></td><td>");
      out.println("<SELECT name=addAlsoPartOfs MULTIPLE SIZE=5>");
      // String dis;
      // Location location;
      for (int i = 0; i < lng; i++) {
	dis = allLocations[i];
	// location = Common.getLocation(dis);
	// printName2 = location.getName();
	out.println("<OPTION VALUE='" + dis + "'>" + dis); 
      }
      out.println("</SELECT>");
      out.println("?</td></tr>");


      /*
      out.println("<SELECT name=locationSt>");
      out.println("<OPTION VALUE='select'  SELECTED>select"); 
      String dis, printName2;
      Location location;
      for (int i = 0; i < allLocations.length; i++) {
	dis = allLocations[i];
	location = Common.getLocation(dis);
	printName2 = location.getName();
	out.println("<OPTION VALUE='" + dis + "'>" + printName2); 
      }
      out.println("</SELECT>");
      out.println("</td></tr>");
      out.println("<tr><td><b>OR create new locationSt:</b></td><td>" + 
		  "<input type='text' name='newlocationSt' size=30 value='" +
		  locationSt + "'> NO spaces as in: leftHand</td></tr>");
		  */

      out.println("</table>");
      out.println("<p><input type='button' value='Submit' " +
		  "onClick= \"checkForm(this.form)\">");
      out.println("<input TYPE=\"hidden\" NAME= \"membershipsList\" VALUE=\"\">");
      out.println("<input TYPE=\"hidden\" NAME= \"adjacentsList\" VALUE=\"\">");
      out.println("<input TYPE=\"hidden\" NAME= \"alsoPartOfsList\" VALUE=\"\">");
      out.println("<input TYPE=\"hidden\" NAME= \"referenceLocation1\" " +
		  "VALUE='" + referenceLocation1 + "'>");
      out.println("<input TYPE=\"hidden\" NAME= \"referenceLocation2\" " +
		  "VALUE='" + referenceLocation2 + "'>");
      out.println("<input TYPE=\"hidden\" NAME= \"superset\" " +
		  "VALUE='" + superset + "'>");
      out.println("</FORM>");

      out.println("</BODY>");
      out.println("</HTML>");
    }

  private String adjacentsScript(Vector adjacents) {
    StringBuffer sb = new StringBuffer();
    int lng = adjacents.size();
    LocationRelation lr;
    String member, position, line1, line2, line3;
    for (int i = 0; i < lng; i++) {
      lr = (LocationRelation) adjacents.elementAt(i);
      position = lr.getPosition();
      if ( !position.equals("adjacent") ) continue;
      member = lr.getLocationName2();
      sb.append("for(count=0;count<3;count++){");
      line1 = "if(form." + member + "[count].checked){";
      sb.append(line1);
      line2 = "  val=form." + member + "[count].value;";
      sb.append(line2);
      // sb.append("alert('*** val: ' + val);");
      line3 = "  form.adjacentsList.value += (',' + '" + member + "' + '.' + val);";
      sb.append(line3);
      // sb.append("alert('*** val: ' + form.adjacentsList.value);");
      sb.append("  break; }}");
    }
    return sb.toString();
  }
}



