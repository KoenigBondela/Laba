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
        MenuContext menuContext = new MenuContext();

        System.out.println("=== Консоль настройки оборудования ===");

        while (true) {
            Role role = authService.authenticate();
            if (role == null) {
                System.out.println("Ошибка авторизации. Попробуйте снова.\n");
                continue;
            }

            switch (role) {
                case USER -> menuContext.setMenuStrategy(new UserMenuStrategy());
                case ROOT -> menuContext.setMenuStrategy(new RootMenuStrategy(authService));
                default -> {
                    System.out.println("Неизвестная роль. Попробуйте снова.\n");
                    continue;
                }
            }

            menuContext.run(scanner);
            System.out.println("Вы вышли из меню. Возврат к авторизации.\n");
        }
    }
}


