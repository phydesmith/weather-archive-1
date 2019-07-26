set DERBY_INSTALL=C:\Apache\db-derby-10.15.1.3-bin
set CLASSPATH=%DERBY_INSTALL%\lib\derby.jar;%DERBY_INSTALL%\lib\derbytools.jar;.


cd C:\users\peter.hydesmith\documents\projects\weather-projects\weather

start /B javaw -classpath .\target\weather-1.0-SNAPSHOT.jar;%CLASSPATH% --module-path C:\Gluon\javafx-sdk-12\lib\ --add-modules javafx.controls,javafx.fxml io.javasmithy.App

