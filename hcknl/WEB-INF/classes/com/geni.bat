echo ------------------------------------------------------------------
echo Compile and initialize the whole system
set classpath0=%classpath%
set classpath=%classpath%;C:\tomcat4\webapps\hcknl\WEB-INF\classes
if exist L.javaNL goto proceed
rename L.java L.javaNL
rename L.javaENG L.java
del L.class
:proceed
if exist L.javaENG goto error1
if not exist Diseases mkdir Diseases
if not exist Locations mkdir Locations
if not exist newACs mkdir newACs
if not exist newBSs mkdir newBSs
if not exist newDiseases mkdir newDiseases
if not exist newPartLocations mkdir newPartLocations
if not exist newSymptoms mkdir newSymptoms
cd ../init
rename GenDiseases2.java GenDiseases2.javaNL
javac *.java
java com.InitAll
rename GenDiseases2.javaNL GenDiseases2.java
cd ../com
goto end
:error1
echo ** FAILURE because L.javaENG and L.javaNL are both present **
:end
set classpath=%classpath0%
echo Finished





