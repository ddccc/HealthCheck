File: c:/bsd/HealthCheck/0ReadMe.txt
Date: Thu Apr 04 11:56:50 2024

This file is about the sources for the HealthCheck website(s).
See the pdf file and another txt file for the purpose of the system.

The English version is hck, the Dutch version is hcknl.
A webserver can run both of them at the same time if needed.
The English version is larger because of additions for a research
project involving AI agents.

A version must be added to a tomcat web server in its webapps
directory.
The file j2ee.jar goes into the lib directory - may be it is included
these days in the JDK.
Java compilation uses a JDK.
Scripts assume running on a window box; they need adjustments for linux.

Scripts are in: hck/WEB-INF/classes/com
The script Gen.bat generates the whole system; other scrips are
available for specific upgrades.

Users of the system:
- Anonymous 1-time users
- Anonymous users that create an account for return visits
- Known users whose account is created by a physician
- Physicians login in with: phlogin.html
- CallCenter folks login with: cclogin.html
- SuperUser login with: sulogin.html

The super login assumes there is a directory: users
   inside hck/WEB-INF/classes/users
in which there is a file like: suxyz
which contains something like:
#SUCA2
#Thu Jul 11 14:36:04 PDT 2002
password=XYZ55
firstName=Dennis
userName=xyz
lastName=deChampeaux

Hence the super user logs in with: 
username: xyz and the password: XYZ55

The super user manages the accounts of callcenter folks and physicians.


Inside hck/WEB-INF/classes/com there is a file Loc.java
Customize according it to where tomcat is installed.
The file D.java uses what is in Loc.java

L.java is for the English version.
L.javaNL is the Dutch version.
The Dutch hcknl version has them renamed into L.javaUS and L.java.

The source of the hcknl version can be used for an English version
because it omits the AI agent extension; just rename the L-files.
The phone-access extension is here omitted also. 

There are tools to edit the medical data files in the directory
   hck/WEB-INF/classes/edit
Here how to access it:
   http://localhost:8080/hck/servlet/edit.EditAny
There are numerous tools to show the content of the med files, which
helps to get a grip on the med ontology.

See also in /hck the files:
0ReadMe.txt for how the callcenter is monitoring users.
00ReadMe.txt for the AI actor research feature.

User privacy is 'guaranteed' because identiable data is not asked.  {The
webserver log may contain the ip-address.}

The AI agent version has a 'nurse' that looks at a user session and can
generate a warning. 
