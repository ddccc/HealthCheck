// (C) OntoOO Inc 2007 Feb
package com;

/*
  This file has configurations for the following installations:
  JRun at location C:/JRun
  Tomcat at location C:/tomcat4/webapps/hck
  Tomcat at location C:/tomcat4/webapps/hcknl
  Tomcat at location /home/client/ddc/hck (and others)
  Tomcat at location /home/client/ddc/hcknl (and others)
  Only one of these installations must be uncommented.

  Each installation has two key entities to be set:
  site: which is the url for the application
  sysRoot: which is the location in the file system where the application resides.
  sysRoot is used to define subdirectories where an installation can write and read
 */


public class  Loc {

    final static int maxUserInactiveInterval0 = 60;
    final static int maxEditInactiveInterval0 = 3600;

    /* JRun
       final static int maxUserInactiveInterval = maxUserInactiveInterval0 * 1000;
       final static int maxEditInactiveInterval = maxEditInactiveInterval0 * 1000;

       final static String site = "http://localhost:8000";
       final static String sysRoot = "C:/JRun";

       final static String hck0 = "";
       final static String hck = hck0;

       final static String applRoot1 = sysRoot + "/classes/";
       final static String applRoot2 = sysRoot + "/servlets/";

       // data directories
       final static String theConceptsDir = applRoot1;
       final static String theLoggingDir = applRoot2;
       final static String theUsersDir = applRoot2;
       
       final static String actors = "/";
       final static String cc = "/";
       final static String edit = "/";
       final static String htmls = "/";
       final static String misc = "/";
       final static String patient = "/";
       final static String show = "/";
       final static String su = "/";
       final static String users = "/";
       final static String phone = "/";

       final static String concepts = "";
       final static String edit2 = "";

       // applet
       final static String appletBase = "CODEBASE='/' ";

       // images
       final static String images = hck0 + "/images"; 

       // Google ad
       final static String googleAd = ""; 
    */

    // /* Tomcat
       final static int maxUserInactiveInterval = maxUserInactiveInterval0;
       final static int maxEditInactiveInterval = maxEditInactiveInterval0;

       final static String site = "http://localhost:8080";
       final static String sysRoot = "C:/tomcat4/webapps"; 

       final static String hck0 = "/hck";
       final static String hck = hck0;

       final static String applRoot1 = sysRoot + hck;
       final static String applRoot2 = applRoot1 + "/WEB-INF/classes";

       // data directories
       final static String theConceptsDir = applRoot2 + "/com/";
       final static String theLoggingDir = applRoot2 + "/su/";
       final static String theUsersDir = applRoot2 + "/users/";

       // package names for Tomcat4
       final static String actors = "/actors.";
       final static String cc = "/cc.";
       final static String edit = "/edit.";
       final static String htmls = "/htmls.";
       final static String misc = "/misc.";
       final static String patient = "/patient.";
       final static String show = "/show.";
       final static String su = "/su.";
       final static String users = "/users.";
       final static String phone = "/phone.";

       final static String concepts = "concepts.";
       final static String edit2 = "edit.";

       // applet
       final static String appletBase = "CODEBASE='" + hck0 + "/applets/' ";

       // images
       final static String images = hck0 + "/images"; 

       // Google ad
       final static String googleAd = ""; 
    // */

    /* Tomcat hcknl
       final static int maxUserInactiveInterval = maxUserInactiveInterval0;
       final static int maxEditInactiveInterval = maxEditInactiveInterval0;

       final static String site = "http://localhost:8080";
       final static String sysRoot = "C:/tomcat4/webapps";

       final static String hck0 = "/hck";
       final static String hck = "/hcknl";

       final static String applRoot1 = sysRoot + hck;
       final static String applRoot2 = applRoot1 + "/WEB-INF/classes";

       // data directories
       final static String theConceptsDir = applRoot2 + "/com/";
       final static String theLoggingDir = applRoot2 + "/su/";
       final static String theUsersDir = applRoot2 + "/users/";

       // package names for Tomcat4
       final static String actors = "/actors.";
       final static String cc = "/cc.";
       final static String edit = "/edit.";
       final static String htmls = "/htmls.";
       final static String misc = "/misc.";
       final static String patient = "/patient.";
       final static String show = "/show.";
       final static String su = "/su.";
       final static String users = "/users.";
       final static String phone = "/phone.";

       final static String concepts = "concepts.";
       final static String edit2 = "edit.";

       // applet
       final static String appletBase = "CODEBASE='" + hck0 + "/applets/' ";

       // images
       final static String images = hck0 + "/images"; 

       // Google ad
       final static String googleAd = ""; 
     */

    /* Site
       final static int maxUserInactiveInterval = maxUserInactiveInterval0;
       final static int maxEditInactiveInterval = maxEditInactiveInterval0;

       final static String site = "http://www.healthcheck4me.info";
       // final static String sysRoot = "/www/htdocs/healthcheck4me/tomcat/ROOT";  // shared server
       // final static String sysRoot = "/www/htdocs/healthcheck4me";  // own server
       // final static String sysRoot = "/home/client/ddc";
       final static String sysRoot = "/home/ddc/hckA";

       final static String hck0 = "/hck";
       final static String hck = hck0;

       final static String applRoot1 = sysRoot + hck;
       final static String applRoot2 = applRoot1 + "/WEB-INF/classes";

       // data directories
       final static String theConceptsDir = applRoot2 + "/com/";
       final static String theLoggingDir = applRoot2 + "/su/";
       final static String theUsersDir = applRoot2 + "/users/";

       // package names for Tomcat4
       final static String actors = "/actors.";
       final static String cc = "/cc.";
       final static String edit = "/edit.";
       final static String htmls = "/htmls.";
       final static String misc = "/misc.";
       final static String patient = "/patient.";
       final static String show = "/show.";
       final static String su = "/su.";
       final static String users = "/users.";
       final static String phone = "/phone.";

       final static String concepts = "concepts.";
       final static String edit2 = "edit.";

       // applet
       final static String appletBase = "CODEBASE='" + hck0 + "/applets/' ";

       // images
       final static String images = hck0 + "/images"; 

       // Google ad
//  728x90, created 4/26/08 
//  google_ad_slot = "9273945793";  white
//  greenish 

       final static String googleAd =
"<center> \n" +
"<script type=\"text/javascript\"><!-- \n" +
"google_ad_client = \"pub-5279599042595078\"; \n" +
"google_ad_slot = \"5358736784\";  \n" + 
"google_ad_width = 728; \n" +
"google_ad_height = 90; \n" +
"//--> \n" +
"</script> \n" +
"<script type=\"text/javascript\" \n" +
"src=\"http://pagead2.googlesyndication.com/pagead/show_ads.js\"> \n" +
"</script> \n" +
"</center>";

     */

    /* Site hcknl
       final static int maxUserInactiveInterval = maxUserInactiveInterval0;
       final static int maxEditInactiveInterval = maxEditInactiveInterval0;

       final static String site = "http://www.consultplusarts.nl";
       // final static String sysRoot = "/www/htdocs/healthcheck4me/tomcat/ROOT";  // shared server
       // final static String sysRoot = "/www/htdocs/healthcheck4me";  // own server
       // final static String sysRoot = "/home/client/ddc";
       final static String sysRoot = "/home/ddc/hcknlA";

       final static String hck0 = "/hck";
       final static String hck = "/hcknl";

       final static String applRoot1 = sysRoot + hck;
       final static String applRoot2 = applRoot1 + "/WEB-INF/classes";

       // data directories
       final static String theConceptsDir = applRoot2 + "/com/";
       final static String theLoggingDir = applRoot2 + "/su/";
       final static String theUsersDir = applRoot2 + "/users/";

       // package names for Tomcat4
       final static String actors = "/actors.";
       final static String cc = "/cc.";
       final static String edit = "/edit.";
       final static String htmls = "/htmls.";
       final static String misc = "/misc.";
       final static String patient = "/patient.";
       final static String show = "/show.";
       final static String su = "/su.";
       final static String users = "/users.";
       final static String phone = "/phone.";

       final static String concepts = "concepts.";
       final static String edit2 = "edit.";

       // applet
       final static String appletBase = "CODEBASE='" + hck0 + "/applets/' ";

       // images
       final static String images = hck0 + "/images"; 

       // Google ad
       final static String googleAd = ""; 
     */

} // end Loc
