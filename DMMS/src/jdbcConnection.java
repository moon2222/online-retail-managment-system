/**
 * Created by Creator on 4/17/2016.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Crunchify.com
 * Simple Oracle JDBC Connection Tutorial
 */

public class jdbcConnection {

    static Connection crunchifyConn = null;
    static Statement crunchifyStmt = null;
    static ResultSet crunchifyResultset = null;

    public static void main(String[] args) throws SQLException {
        System.out.println("-------- Crunchify's tutorial on Oracle JDBC Connectivity  ------");

        try {
            // Returns the Class object associated with the class
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException exception) {
            System.out.println("Oracle Driver Class Not found Exception: " + exception.toString());
            return;
        }

        // Set connection timeout. Make sure you set this correctly as per your need
        DriverManager.setLoginTimeout(5);
        System.out.println("Oracle JDBC Driver Successfully Registered! Let's make connection now");

        try {
            // Attempts to establish a connection
            // here DB name: localhost, sid: crunchify
            crunchifyConn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:crunchify", "username", "password");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

        // Creates a Statement object for sending SQL statements to the database
        crunchifyStmt = crunchifyConn.createStatement();

        // Executes the given SQL statement, which returns a single ResultSet object
        crunchifyResultset = crunchifyStmt.executeQuery("SELECT * from CrunchifyEmployee where username = 'crunchify'");

        if (crunchifyResultset.next()) {
            System.out.println("Employee Details: " + crunchifyResultset.getString(1));
        } else {
            throw new SQLException("Can NOT retrieve Employee details from table 'CrunchifyEmployee'");
        }

        System.out.println("Oracle JDBC connect and query test completed.");
    }

}