package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDatabaseConnection {
    private static Connection con = null;

    private MysqlDatabaseConnection() {

    }

    public static Connection getConnection(String url, String user, String password)
            throws ClassNotFoundException, SQLException {
        if (con != null) {
            return con;
        } else {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            return con;
        }
    }
}
