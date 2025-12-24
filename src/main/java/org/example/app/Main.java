package org.example.app;

import org.example.auth.AuthService;
import org.example.auth.Role;
import org.example.menu.MenuContext;
import org.example.menu.RootMenuStrategy;
import org.example.menu.UserMenuStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService(scanner);

        System.out.println("=== Консоль настройки оборудования ===");

        Role role = authService.authenticate();
        if (role == null) {
            System.out.println("Ошибка авторизации. Завершение работы.");
            return;
        }

        MenuContext menuContext = new MenuContext();
        switch (role) {
            case USER -> menuContext.setMenuStrategy(new UserMenuStrategy());
            case ROOT -> menuContext.setMenuStrategy(new RootMenuStrategy());
            default -> {
                System.out.println("Неизвестная роль. Завершение работы.");
                return;
            }
        }

        menuContext.run(scanner);

        System.out.println("Программа завершена.");
    }
}


