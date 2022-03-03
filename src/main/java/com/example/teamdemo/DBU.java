package com.example.teamdemo;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBU {


    public static String db_name = "Emp2";

    public static String host = "localhost";

    public static String port = "5432";

    public static String username = "postgres";

    public static String password = "10101992vhld";

    private static Connection connection = null;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + db_name + "", "" + username + "", "" + password + "");
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println(" Rami Zain");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }


}