package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDaoRealization = new UserDaoHibernateImpl();
    public void createUsersTable() throws SQLException {
        userDaoRealization.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoRealization.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoRealization.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDaoRealization.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoRealization.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoRealization.cleanUsersTable();
    }
}
