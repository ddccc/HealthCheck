echo Start copy from hck to e:\hck
cd c:\tomcat4\webapps\hck
xcopy /d *.* e:\hck
xcopy /d /e *.java e:\hck
cd c:\tomcat4\webapps\hck\WEB-INF\classes\com
xcopy /d ignorewords e:\hck\WEB-INF\classes\com
xcopy /d indexwords e:\hck\WEB-INF\classes\com
cd c:\tomcat4\webapps\hck\WEB-INF\classes\su
xcopy /d healthangelLogging e:\hck\WEB-INF\classes\su
cd c:\tomcat4\webapps\hck\WEB-INF\classes\users
xcopy /d suddc e:\hck\WEB-INF\classes\users
xcopy /d cccccc e:\hck\WEB-INF\classes\users
echo Finished copy from hck to e:\hck



