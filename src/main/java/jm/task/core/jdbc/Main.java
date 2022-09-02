package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Ivan", "Petrov", (byte) 20);
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
