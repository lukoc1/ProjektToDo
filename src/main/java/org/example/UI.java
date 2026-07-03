package org.example;

public class UI {

    public static void displayMenu() {

        String[] menuOptions = {"add", "remove", "list", "exit"};

        System.out.println(ConsoleColors.RED + "--------------------" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "Please select an option:" + ConsoleColors.RESET);
        for (var option : menuOptions) {
            System.out.println(option);
        }
        System.out.println(ConsoleColors.RED + "--------------------" + ConsoleColors.RESET);

    }
}
