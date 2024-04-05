// Copyright OntoOO Inc, 2000
package edit;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.D;


public class EditAny extends HttpServlet {

    public void doGet (HttpServletRequest req, 
		       HttpServletResponse res)
	throws ServletException, IOException
    {
      res.setContentType("text/html");
      ServletOutputStream out = res.getOutputStream();
      out.println("<html>");
      out.println("<head><title>Edit Any</title>" +
		  D.favicon + "</HEAD>");
      out.println("<body bgcolor=\"lightgreen\">");
      out.println("<h1>Edit Any</h1>");
      /*
	PartLocation
	    Bone
	    Muscle
	    Organ
	    Vein
	ConnectionLocation
	    Tendon
	LocationSet
	    Bone
	    Muscle
	    Organ
	    Vein
	    Tendon
       */

      StringBuffer sb = new StringBuffer();
   sb.append("<br><a href='" + D.servletEditPartLocations + "'>Edit PartLocations</a> | " +
	     "<a href='" + D.servletEditConnectionLocations + "'>Edit ConnectionLocations</a> |" +
	     "<a href='" + D.servletEditLocationSets + "'>Edit LocationSets</a> \n");
   sb.append("<br><a href='" + D.servletEditBSs + "'>Edit BodySystems</a> \n");
   sb.append("<br><a href='" + D.servletEditDiseases + "'>Edit Diseases</a> | " +
	     "<a href='" + D.servletEditDiseases0 + "'>Edit Diseases without attributes</a> | " +
	     "<a href='" + D.servletEditDiseasesSuper + "'>Edit Diseases Super</a> \n");
   sb.append("<br><a href='" + D.servletEditACs + "'>Edit AbnormalConditions</a> \n");
   sb.append("<br><a href='" + D.servletEditSymptoms + "'>Edit Symptoms</a> \n");
   sb.append("<hr>");
   sb.append("VALIDATION: " + 
	     "<a href='" + D.servletSimulation + "'>Simulation</a> | " +
	     "<a href='" + D.servletShowDiseaseLinks + "'>Show DiseaseLinks</a> | " +
	     "<a href='" + D.servletDiseaseSubsumption + "'>DiseaseSubsumption</a> \n");
   sb.append("<hr>");
   sb.append("<a href='" + D.servletEditXWords + "'>Show XWords</a> || " +
	     "<a href='" + D.servletEditXWords2 + "'>Show XWords freq occurrence</a> \n");
   sb.append("<br><a href='" + D.servletFindIndexInSymptom + "'>FindIndexInSymptom </a> | " +
	     "<a href='" + D.servletFindIndexInBodySystem + "'>FindIndexInBodySystem </a> | " +
	     "<a href='" + D.servletFindIndexInLocation + "'>FindIndexInLocation </a> | " +
	     "<a href='" + D.servletFindIndexInDisease + "'>FindIndexInDisease </a> || " +
	     "<a href='" + D.servletAddIndices + "'>AddIndices </a><br> \n " +
	     "<a href='" + D.servletManageIgnoreWords + "'>ManageIgnoreWords </a> | " +
	     "<a href='" + D.servletManageIndexWords + "'>ManageIndexWords </a><br> \n ");
   sb.append("<hr>");
   sb.append("<a href='" + D.servletShowSympStats + "'>Show Symp Stats</a> \n");
   sb.append("<br><a href='" + D.servletShowSympClosure + "'>Show Symp Closure</a> \n");
   sb.append("<br><a href='" + D.servletShowSympClosures + "'>Show Symp Equivalence Classes</a> \n");
   sb.append("<br><a href='" + D.servletSelectSymptoms + "'>Select Symptoms</a> \n");
   sb.append("<br><a href='" + D.servletShowMaleSymps + "'>Show Gender's Symps</a> | " +
	     "<a href='" + D.servletShowMaleDiseases + "'>Show Gender's Diseases</a> \n");
   sb.append("<br><a href='" + D.servletShowDangerousSymptoms + "'>Show Dangerous Symptoms</a> \n");
   sb.append("<br><a href='" + D.servletShowSymptomsDetails + "'>Show Symptoms Details</a> \n");
   sb.append("<hr>");
   sb.append("<a href='" + D.servletShowLocationHierarchy + "'>Show Location Hierarchy</a> \n");
   sb.append("<br><a href='" + D.servletShowDiseaseSets + "'>Show DiseaseSets</a> \n");
   sb.append("<br><a href='" + D.servletShowAll + "'>Show All</a> \n");
   sb.append("<br><a href='" + D.servletShowSympBucket + "'>Show Symp Bucket ??</a> \n");
   sb.append("<br><a href='" + D.servletShowDrugs + "'>Show Drugs</a>\n");
   sb.append("<hr>");
   sb.append("<a href='" + D.servletIncidence + "'>Show disease incidence</a> \n");

   out.println(sb.toString());
      out.println("</body>");
      out.println("</html>");
    }
}



