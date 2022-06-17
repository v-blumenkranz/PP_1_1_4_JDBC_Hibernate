package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        UserDaoHibernateImpl impl = new UserDaoHibernateImpl();
        impl.createUsersTable();
        impl.saveUser("Валерия", "Яровцева", (byte) 24);
        impl.saveUser("Алексей", "Федоров", (byte) 31);
        impl.saveUser("Ириска", "Татьяновна", (byte) 3);
        impl.saveUser("Ричард", "Сапогов", (byte) 35);
        impl.removeUserById(2);
        impl.getAllUsers();
        impl.cleanUsersTable();
        impl.dropUsersTable();

        Util.getSessionFactory().close();
    }
}
