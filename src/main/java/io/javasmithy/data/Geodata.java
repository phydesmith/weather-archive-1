package io.javasmithy.data;

import java.sql.*;

public class Geodata{
    static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    static String dbName = "locales";
    static String connectionURL = "jdbc:derby:" + dbName + ";";

    static Connection conn;
    static Statement s;

    static String createString = "CREATE TABLE WISH_LIST  "
    +  "(WISH_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY " 
    +  "   CONSTRAINT WISH_PK PRIMARY KEY, " 
    +  " ENTRY_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
    +  " WISH_ITEM VARCHAR(32) NOT NULL) " ;

    public static void findStation(String zipcode) {
        try {
            String searchZipcode = "select zipcode, geodata.latitude, geodata.longitude, station_id, stations.latitude, stations.longitude, "
                                + "sqrt((geodata.latitude-stations.latitude )*( geodata.latitude-stations.latitude)"
                                + "+( geodata.longitude-stations.longitude )*( geodata.longitude-stations.longitude )) distance "
                                + "FROM GEODATA JOIN STATIONS on "
                                + "(geodata.latitude > (stations.latitude-1) and geodata.latitude < (stations.latitude+1)) "
                                + "and"
                                + "(geodata.longitude > (stations.longitude-1) and geodata.longitude < (stations.longitude+1)) "
                                + "where zipcode = " 
                                + zipcode + " "
                                + "order by distance asc fetch first row only";

            //Class.forName(driver);
            //DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            conn = DriverManager.getConnection(connectionURL);

            s = conn.createStatement();
            System.out.println("getting station");
            System.out.println(searchZipcode);
            s.execute(searchZipcode);

        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
   
}