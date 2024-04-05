echo ------------------------------------------------------------------
echo GENT
set classpath0=%classpath%
set classpath=%classpath%;C:\tomcat4\webapps\hck\WEB-INF\classes
echo javac su
cd ../su
javac *.java
cd ../com
set classpath=%classpath0%
echo Finished





