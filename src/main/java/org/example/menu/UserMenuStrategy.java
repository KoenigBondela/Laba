package org.example.menu;

import org.example.services.EquipmentConfigService;
import org.example.services.EquipmentStatsService;

import java.util.Scanner;

public class UserMenuStrategy implements MenuStrategy {

    private final EquipmentConfigService configService = new EquipmentConfigService();
    private final EquipmentStatsService statsService = new EquipmentStatsService();

    @Override
    public void showMenu(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println();
            System.out.println("=== Меню пользователя (USER) ===");
            System.out.println("1) Просмотреть настройки оборудования");
            System.out.println("2) Просмотреть статистику по оборудованию");
            System.out.println("3) Выход");
            System.out.print("Выберите пункт меню: ");

            String input = scanner.nextLine().trim();
            switch (input) {
                case "1" -> configService.viewConfig();
                case "2" -> statsService.showStats();
                case "3" -> exit = true;
                default -> System.out.println("Неизвестная команда. Попробуйте ещё раз.");
            }
        }
    }
}


