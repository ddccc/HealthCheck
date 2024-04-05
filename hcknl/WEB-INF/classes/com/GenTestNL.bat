echo ------------------------------------------------------------------
echo Test Compile and Run Test in gen
set classpath0=%classpath%
set classpath=%classpath%;C:\tomcat4\webapps\hcknl\WEB-INF\classes
echo Assumption:: 
echo -- the file L.java is the NL version
echo -- GenDiseases has generated GenDiseases2 depending on L.java
if exist L.javaENG goto proceed
rename L.java L.javaENG
rename L.javaNL L.java
del L.class
:proceed
if exist L.javaNL goto error1
cd ../gen
javac Test.java
java gen.Test
cd ../com
goto end
:error1
echo ** FAILURE because L.javaENG and L.javaNL are both present **
:end
set classpath=%classpath0%
echo Finished





