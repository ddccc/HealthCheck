echo ------------------------------------------------------------------
echo Test Compile and Run Test in gen
set classpath0=%classpath%
set classpath=%classpath%;C:\tomcat4\webapps\hcknl\WEB-INF\classes
if exist L.javaNL goto proceed
rename L.java L.javaNL
rename L.javaENG L.java
del L.class
:proceed
if exist L.javaENG goto error1
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





