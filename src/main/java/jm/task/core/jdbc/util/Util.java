package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {

    private static final String URL = "jdbc:mysql://localhost/dbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "sqlforBlumen";
    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Подключение успешно выполнено...");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
