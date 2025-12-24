package org.example.menu;

import java.util.Scanner;

public interface MenuStrategy {

    /**
     * Запускает цикл показа меню и обработки команд.
     *
     * @param scanner общий сканер из main
     */
    void showMenu(Scanner scanner);
}


