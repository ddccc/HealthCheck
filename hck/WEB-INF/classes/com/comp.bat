echo Start angel compile
cd c:\tomcat4\webapps\hck\WEB-INF\classes\cc
javac *.java
cd ..\com
javac *.java
cd ..\concepts
javac *.java
cd ..\edit
javac *.java
cd ..\htmls
javac *.java
cd ..\init
javac *.java
cd ..\misc
javac *.java
cd ..\patient
javac *.java
cd ..\show
javac *.java
cd ..\su
javac *.java
cd ..\users
javac *.java
cd ..\phone
javac *.java
cd ..\com
java com.InitAll
echo Finished angel compile



