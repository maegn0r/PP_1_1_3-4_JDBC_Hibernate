package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("Nick", "Howard", (byte) 19);
        userService.saveUser("John", "Wick", (byte) 24);
        userService.saveUser("Bob", "Thornton", (byte) 46);
        userService.saveUser("Edvard", "Gray", (byte) 67);
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
