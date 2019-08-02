package io.javasmithy.weather;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class StationLocator{
    static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    static final String dbName = "locales";
    static final String connectionURL = "jdbc:derby:" + dbName + ";";

    public static String findStation(String zipcode) {
        try {
            //  This query uses the distance formula to find the shortest distance between zip code lat/long and stations within +/- 1 lat/long points of the zip code
            String findStationQuery = "select zipcode, geodata.latitude, geodata.longitude, station_id, stations.latitude, stations.longitude, "
                                    + "sqrt((geodata.latitude-stations.latitude )*( geodata.latitude-stations.latitude)"
                                    + "+( geodata.longitude-stations.longitude )*( geodata.longitude-stations.longitude )) distance "
                                    + "FROM GEODATA JOIN STATIONS on "
                                    + "(geodata.latitude > (stations.latitude-1) and geodata.latitude < (stations.latitude+1)) "
                                    + "and"
                                    + "(geodata.longitude > (stations.longitude-1) and geodata.longitude < (stations.longitude+1)) "
                                    + "where zipcode = " 
                                    + zipcode + " "
                                    + "order by distance asc fetch first row only";

            Connection connection = DriverManager.getConnection(connectionURL);
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(findStationQuery);

            results.next();
            String stationId = results.getString(4);
            return stationId;
            

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }   
    }
   
}