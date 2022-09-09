package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    private static final UserService userService = new UserServiceImpl();
    public static void main(String[] args) {
        userService.createUsersTable();
        userService.saveUser("Ilya", "Petrov", (byte) 20);
        System.out.println("User с именем Ivan добавлен в базу данных");
        userService.saveUser("Petr", "Ivanov", (byte) 25);
        System.out.println("User с именем Petr добавлен в базу данных");
        userService.saveUser("Alex", "Sidorov", (byte) 30);
        System.out.println("User с именем Alex добавлен в базу данных");
        userService.saveUser("Jack", "Daniels", (byte) 36);
        System.out.println("User с именем Jack добавлен в базу данных");
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();



    }
}
