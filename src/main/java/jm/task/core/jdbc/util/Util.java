package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Vva020972";
    private static final String URL = "jdbc:mysql://localhost:3306/sys";
    private static Connection connection;
    private static SessionFactory factory;

    public static Connection getConnection() {


        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static SessionFactory getFactory() {
        if (factory == null) {
            Configuration cfg = new Configuration();
            Properties prop = new Properties();
            prop.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            prop.put(Environment.URL, "jdbc:mysql://localhost:3306/sys");
            prop.put(Environment.USER, "root");
            prop.put(Environment.PASS, "Vva020972");
            prop.put(Environment.SHOW_SQL, "true");
            prop.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
            prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            prop.put(Environment.HBM2DDL_AUTO, "create");

            cfg.setProperties(prop);
            cfg.addAnnotatedClass(User.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(cfg.getProperties()).build();
            factory = cfg.buildSessionFactory(serviceRegistry);
        }
        return factory;
    }

}