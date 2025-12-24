package org.example.menu;

import org.example.auth.AuthService;
import org.example.services.EquipmentConfigService;
import org.example.services.EquipmentStatsService;

import java.util.Scanner;

public class RootMenuStrategy implements MenuStrategy {

    private final EquipmentConfigService configService = new EquipmentConfigService();
    private final EquipmentStatsService statsService = new EquipmentStatsService();
    private final AuthService authService = new AuthService(new Scanner(System.in));

    @Override
    public void showMenu(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println();
            System.out.println("=== Меню администратора (ROOT) ===");
            System.out.println("1) Изменить настройки оборудования");
            System.out.println("2) Просмотреть статистику по оборудованию");
            System.out.println("3) Добавить нового пользователя");
            System.out.println("4) Выход");
            System.out.print("Выберите пункт меню: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1" -> changeConfig(scanner);
                case "2" -> statsService.showStats();
                case "3" -> authService.addUser();
                case "4" -> exit = true;
                default -> System.out.println("Неизвестная команда. Попробуйте ещё раз.");
            }
        }
    }

    private void changeConfig(Scanner scanner) {
        System.out.println("Введите новые настройки оборудования (одной строкой): ");
        String newConfig = scanner.nextLine().trim();
        configService.changeConfig(newConfig);
    }
}


