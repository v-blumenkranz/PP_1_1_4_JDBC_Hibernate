package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class Util {

    private static final String URL = "jdbc:mysql://localhost/dbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "sqlforBlumen";
    public static Connection connection;

    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;


    static {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Подключение успешно выполнено...");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    static {
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        Map<String, String> dbSettings = new HashMap<>();
        dbSettings.put(Environment.USER, "root");
        dbSettings.put(Environment.PASS, "sqlforBlumen");
        dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/dbtest");
        dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL57Dialect");
        dbSettings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        dbSettings.put(Environment.SHOW_SQL, "true");

        registryBuilder.applySettings(dbSettings);
        standardServiceRegistry = registryBuilder.build();
        MetadataSources sources = new MetadataSources(standardServiceRegistry);
        sources.addAnnotatedClass(User.class);

        Metadata metadata = sources.getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
