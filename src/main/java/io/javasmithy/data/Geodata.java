package io.javasmithy.data;

import java.sql.*;

public class Geodata{
    static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    static String dbName = "WISH_LIST";
    static String connectionURL = "jdbc:derby:" + dbName + ";create=true";

    static Connection conn;
    static Statement s;

    static String createString = "CREATE TABLE WISH_LIST  "
    +  "(WISH_ID INT NOT NULL GENERATED ALWAYS AS IDENTITY " 
    +  "   CONSTRAINT WISH_PK PRIMARY KEY, " 
    +  " ENTRY_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
    +  " WISH_ITEM VARCHAR(32) NOT NULL) " ;

    public static void testDerby() {
        try {
            //Class.forName(driver);
            //DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            conn = DriverManager.getConnection(connectionURL);

            s = conn.createStatement();
            System.out.println("... creating table firstdb");
            s.execute(createString);

        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
   
}