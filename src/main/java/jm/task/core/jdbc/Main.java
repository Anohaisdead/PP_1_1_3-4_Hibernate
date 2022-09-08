package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;



public class Main {
    private static final UserDao userDao = new UserDaoJDBCImpl();
    public static void main(String[] args) {
        userDao.createUsersTable();
        userDao.saveUser("Ivan", "Petrov", (byte) 20);
        System.out.println("User с именем Ivan добавлен в базу данных");
        userDao.saveUser("Petr", "Ivanov", (byte) 25);
        System.out.println("User с именем Petr добавлен в базу данных");
        userDao.saveUser("Alex", "Sidorov", (byte) 30);
        System.out.println("User с именем Alex добавлен в базу данных");
        userDao.saveUser("Jack", "Daniels", (byte) 36);
        System.out.println("User с именем Jack добавлен в базу данных");
        System.out.println(userDao.getAllUsers());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();



    }
}
