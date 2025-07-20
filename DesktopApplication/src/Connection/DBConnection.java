package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static Connection conn;
    private static final String DB_NAME = "travel";
    private static final String URL_WITHOUT_DB = "jdbc:mysql://localhost:3306/";
    private static final String URL_WITH_DB = "jdbc:mysql://localhost:3306/" + DB_NAME;
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private DBConnection() {}

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                // Load MySQL JDBC driver (modern version)
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Step 1: Connect without database
                Connection tempConn = DriverManager.getConnection(URL_WITHOUT_DB, USER, PASSWORD);

                // Step 2: Create the database if it doesn't exist
                Statement stmt = tempConn.createStatement();
                stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
                stmt.close();
                tempConn.close();

                // Step 3: Connect to the actual database
                conn = DriverManager.getConnection(URL_WITH_DB, USER, PASSWORD);
                System.out.println("connected successfully for travel db !!");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Database Connection Error: " + ex.getMessage());
        }

        return conn;
    }
}
