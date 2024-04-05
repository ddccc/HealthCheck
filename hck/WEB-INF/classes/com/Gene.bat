echo ------------------------------------------------------------------
echo GENe / recompile the edit package
set classpath0=%classpath%
set classpath=%classpath%;C:\tomcat4\webapps\hck\WEB-INF\classes
cd ..\edit
pwd
javac *.java
cd ..\com
pwd
set classpath=%classpath0%
echo Finished





