package org.example;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Scanner;

public class Engine {

    public static void startGame(String[][] tasks) {

        var scan = new Scanner(System.in);
        var input = "";

        do {
            UI.displayMenu();
            input = scan.nextLine();

            switch (input) {
                case "add":
                    tasks = addTask(tasks);
                    break;
//                case "remove":
//                    removeTask();
//                    break;
                case "list":
                    listTasks(tasks);
                    break;
                //            case "exit":
                //                exitGame();
                //                break;
                default:
                    System.out.println("Please select a correct option.");
            }
        } while (!"exit".equals(input));

//        for (int i = 0; i < tasks.length; i++) {
//            for (int j = 0; j < tasks[i].length; j++) {
//                System.out.print(tasks[i][j] + ", ");
//
//            }
//            System.out.println();
//
//        }
    }

    private static String[][] addTask(String[][] tasks) {
        String[] newTask = new String[3];
        var scan = new Scanner(System.in);

        System.out.println("Please add task description");
        var line = scan.nextLine().strip();
        newTask[0] = line;

        System.out.println("Please add task due date");
        line = scan.nextLine().strip();
        newTask[1] = line;

        System.out.println("Is your task important: true/false");
        line = scan.nextLine().strip();
        while (!"true".equals(line) && !"false".equals(line)) {
            System.out.println(ConsoleColors.YELLOW + "Input not applicable. Only options are: true/false" + ConsoleColors.RESET);
            line = scan.nextLine().strip();
        }
        newTask[2] = line;

        var temp = Utils.addToArray(tasks, newTask);
        return temp;
    }

//    private static void removeTask() {
//
//    }
//
    private static void listTasks(String[][] tasks) {
        for (int i = 0; i < tasks.length; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < tasks[i].length; j++) {
                System.out.print(tasks[i][j] + " ");
            }
            System.out.println();
        }
    }
//
//    private static void exitGame() {
//
//    }
}
