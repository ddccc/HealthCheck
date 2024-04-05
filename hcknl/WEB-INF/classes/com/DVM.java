// (C) OntoOO Inc 2002 May
package com;

// utility class for functions
public class  DVM {

  static public String htmlLogoutUser(String heading) {
      return htmlLogout(D.servletUserLogout, heading);
  }

  static public String htmlLogoutCC(String heading) {
      return htmlLogout(D.servletCCLogout, heading);
  }

  static public String htmlLogoutPH(String heading) {
      return htmlLogout(D.servletPHLogout, heading);
  }

  static public String htmlLogoutSU(String heading) {
      return htmlLogout(D.servletSULogout, heading);
  }

  static public String htmlLogout(String servlet, String heading) {
    StringBuffer sb = new StringBuffer("<form action=\"");
    sb.append(servlet);
    sb.append("\"> \n" +
	      /*
	      "<table width='100%'> \n" +
//	      "<tr><td><img align='left' height=34 width=75 border=1 src='" + D.logoJpg + 
	      "<tr><td><img align='left' height='26' width='174' border='1' src='" + D.logoJpg + 
	      "' onClick='alert(\"HC4M is a product of OntoOO Inc.  Visit: www.ontooo.com\")'></td> \n" +
	      "<td align='left'> \n" +
	      "<FONT Color='#1C5540' Size='4'> \n" +
	      "<b>");
	      */
	      D.leftHeading);
    sb.append(heading);
    sb.append(
	      /*
	      "</b> \n" +
	      "</FONT> \n" +
	      "</td><td align=right> \n" +
	      "<input TYPE='SUBMIT' VALUE='Logout'> \n" +
	      "</td></tr> \n" +
	      "</table> \n" +
	      */
	      D.rightHeading + " \n" +
	      "</form> \n" );
    return sb.toString();
  } // end of htmlLogout(String servlet, String heading)

    /*
      // This code was used in Diag1b, AskBodyPart & RefinePartQ.
      // It has been replaced by the simple test:
      // if ( body instanceof LocationSet ) ...
    static public boolean isSetClass(String className) {
	return 
	    className.equals(D.LocationSetClass) ||
	    className.equals(D.BoneSetClass) ||
	    className.equals(D.MuscleSetClass) ||
	    className.equals(D.OrganSetClass) ||
	    className.equals(D.TendonSetClass) ||
	    className.equals(D.VeinSetClass);
	    
    }  // end isSetClass
    */


} // end of DVM




