package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
    static Connection conn = null;
    public static Connection connect() {
    try {
        String url = "jdbc:mysql://localhost:3308/employee";
        String userName = "root";
        String password = "1234";

        conn = DriverManager.getConnection(url, userName, password);
    } catch( Exception e) {
        e.printStackTrace();
        }
        return conn;
    }

}
