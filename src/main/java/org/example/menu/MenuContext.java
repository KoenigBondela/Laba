package org.example.menu;

import java.util.Scanner;

public class MenuContext {

    private MenuStrategy menuStrategy;

    public void setMenuStrategy(MenuStrategy menuStrategy) {
        this.menuStrategy = menuStrategy;
    }

    public void run(Scanner scanner) {
        if (menuStrategy == null) {
            throw new IllegalStateException("Стратегия меню не установлена");
        }
        menuStrategy.showMenu(scanner);
    }
}


