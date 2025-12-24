package org.example.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AuthService {

    private final Map<String, UserInfo> users = new HashMap<>();
    private final Scanner scanner;

    public AuthService(Scanner scanner) {
        this.scanner = scanner;
        seedUsers();
    }

    private void seedUsers() {
        users.put("user", new UserInfo("user", "user123", Role.USER));
        users.put("root", new UserInfo("root", "root123", Role.ROOT));
    }

    public Role authenticate() {
        System.out.print("Введите логин (user/root): ");
        String login = scanner.nextLine().trim();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine().trim();

        UserInfo userInfo = users.get(login);
        if (userInfo == null) {
            System.out.println("Пользователь не найден.");
            return null;
        }

        if (!userInfo.password().equals(password)) {
            System.out.println("Неверный пароль.");
            return null;
        }

        System.out.println("Авторизация успешна. Ваша роль: " + userInfo.role());
        return userInfo.role();
    }

    public void addUser() {
        System.out.print("Введите логин нового пользователя: ");
        String login = scanner.nextLine().trim();
        if (users.containsKey(login)) {
            System.out.println("Пользователь с таким логином уже существует.");
            return;
        }

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine().trim();

        users.put(login, new UserInfo(login, password, Role.USER));
        System.out.println("Пользователь " + login + " добавлен с ролью USER.");
    }

    private record UserInfo(String login, String password, Role role) {
    }
}


