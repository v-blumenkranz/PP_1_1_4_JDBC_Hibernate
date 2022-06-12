package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl impl = new UserDaoJDBCImpl();
        impl.createUsersTable();
        impl.saveUser("Валерия", "Яровцева", (byte) 24);
        impl.saveUser("Алексей", "Федоров", (byte) 31);
        impl.saveUser("Ириска", "Татьяновна", (byte) 3);
        impl.saveUser("Ричард", "Сапогов", (byte) 35);
        impl.getAllUsers();
        impl.cleanUsersTable();
        impl.dropUsersTable();

        try {
            Util.connection.close();
            System.out.println("Соединение успешно закрыто...");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
