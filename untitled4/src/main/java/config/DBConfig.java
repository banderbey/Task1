package config;

import java.sql.*;

public class DBConfig {
    private static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/firstschema?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public ResultSet executeQuery(String sqlQuery) throws SQLException {
        Connection conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        PreparedStatement ps = conn.prepareStatement(sqlQuery);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
}
