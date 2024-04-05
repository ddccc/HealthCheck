echo ------------------------------------------------------------------
echo GEN2 / generating GenDiseases2.java
set classpath0=%classpath%
set classpath=%classpath%;C:\tomcat4\webapps\hck\WEB-INF\classes
cd ..\init
pwd
javac GenDiseases.java
cd ..\com
pwd
java init.GenDiseases
set classpath=%classpath0%
echo Finished





