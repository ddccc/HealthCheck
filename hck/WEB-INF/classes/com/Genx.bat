echo ------------------------------------------------------------------
echo GENx / recompile a specific directory or class
set classpath0=%classpath%
set classpath=%classpath%;C:\tomcat4\webapps\hck\WEB-INF\classes
rem a comment line can also start with ::
cd ..\patient
pwd
:: javac *.java
javac DiseaseInst.java
cd ..\com
pwd
set classpath=%classpath0%
echo Finished





