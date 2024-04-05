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
cd ../gen
if not exist GenHtmlDir mkdir GenHtmlDir
cd ../com
cd Diseases
del *
cd ../Locations
del *
cd ..
del allDiss
del allLocs
rename InitAllNL.java InitAllNL.javaNL
javac *.java
rename InitAllNL.javaNL InitAllNL.java
cd ../actors
javac *.java
cd ../cc
javac *.java
cd ../concepts
javac *.java
cd ../edit
javac *.java
cd ../fol
javac *.java
cd ../init
rename GenDiseases2.java GenDiseases2.javaNL
javac *.java
java com.InitAll
rename GenDiseases2.javaNL GenDiseases2.java
cd ../gen
javac *.java
echo Generate some servlet code, move it and compile all servlets
java gen.GenAdviceMenopause
java gen.GenAdviceMenstruating
java gen.GenAdvicePremenstruating
java gen.GenAngel
java gen.GenAngelQuick
java gen.GenAngelRoot
java gen.GenCCLoginH :: remove echo to use this generator
echo Notice that there is NO generator for PHLoginH.java
java gen.GenFaq
java gen.GenGetTargetWeight
java gen.GenHelp
java gen.GenKChatClientInput
java gen.GenKChatCPersonInput
java gen.GenKChatCPersonInputH
java gen.GenKClientChat
java gen.GenKCPersonChat
java gen.GenKillSession
java gen.GenProgWeight
java gen.GenSendMail
java gen.GenSetupAccount
java gen.GenSetupCCAccount
java gen.GenStart
java gen.GenStart2
java gen.GenStart3
java gen.GenStartAnonymous
cd GenHtmlDir
mv *.java ../../htmls
mv *.html ../../../../
cd ../../htmls
javac *.java
cd ../misc
javac *.java
cd ../patient
javac *.java
cd ../phone
javac *.java
cd ../show
javac *.java
cd ../su
javac *.java
cd ../users
javac *.java
cd ../com
goto end
:error1
echo ** FAILURE because L.javaENG and L.javaNL are both present **
:end
set classpath=%classpath0%
echo Finished





