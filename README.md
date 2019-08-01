# WEATHER
It works.

## How to run:
    
### Download:
  <br/>Derby 10.15.1.3: https://db.apache.org/derby/releases/release-10.15.1.3.cgi
  <br/>OpenJFX 12: https://gluonhq.com/products/javafx/
  
  I found it easiest to extract it to /C/Apache/ and /C/Gluon/
  
### Set Environment Variables:
  using git bash
 <br/>export DERBY_INSTALL=/C/Apache/db-derby-10.14.1.3-bin
 <br/>export CLASSPATH=$DERBY_INSTALL/lib/derby.jar:$DERBY_INSTALL/lib/derbytools.jar
  
  <br/>cd to location of project ~/.../weather
  <br/>mvn clean compile package
  <br/>java -classpath $CLASSPATH:target/weather-1.0-SNAPSHOT.jar --module-path /c/Gluon/javafx-sdk-12/lib/ --add-modules javafx.controls,javafx.fxml io.javasmithy.App
  
  ### Type in a valid US zipcode
    Compare results to https://www.weather.gov/ for accuracy.
    Should pull weather data from the station nearest to zip lat/long. 
    Examples: 94027
              33462
              94022
              94301
              94957
              11962
              81656
              90210
              
