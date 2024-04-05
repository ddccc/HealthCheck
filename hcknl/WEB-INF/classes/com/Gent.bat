echo ------------------------------------------------------------------
echo GENT
set classpath0=%classpath%
set classpath=%classpath%;C:\tomcat4\webapps\hcknl\WEB-INF\classes
echo javac com
cd ../patient
javac *.java
cd ../com
set classpath=%classpath0%
echo Finished





