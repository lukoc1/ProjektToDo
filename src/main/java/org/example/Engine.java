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
                case "remove":
                    tasks = removeTask(tasks);
                    break;
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

    }

    private static String[][] addTask(String[][] tasks) {
        String[] newTask = new String[3];
        var scan = new Scanner(System.in);
        var line = "";

        System.out.println("Please add task description.");
        do {
            System.out.println("Description cannot contain ','.");
            line = scan.nextLine().strip();
        } while(line.contains(","));
        newTask[0] = line;

        System.out.println("Please add task due date");
        line = scan.nextLine().strip();
        newTask[1] = line;

        System.out.println("Is your task important: true/false");
        line = scan.nextLine().strip();
        while (!"true".equals(line) && !"false".equals(line)) {
            System.out.println(ConsoleColors.YELLOW + "Input not applicable. Only options are: true/false" + ConsoleColors.RESET);
            line = scan.nextLine().replace(",", ".").strip();
        }
        newTask[2] = line;

        return Utils.addToArray(tasks, newTask);
    }

    private static String[][] removeTask(String[][] tasks) {

        int tasksNum = tasks.length - 1;
        if (tasksNum < 0) {
            System.out.println(ConsoleColors.YELLOW + "No tasks to remove." + ConsoleColors.YELLOW);
            return (tasks);
        }

        System.out.println("Please select number to remove");
        System.out.println("Possible options are: 0 -> " + tasksNum);
        var scan = new Scanner(System.in);
        var line = scan.nextLine().strip();
        while (true) {
            try {
                int num = Integer.valueOf(line);
                if (num > tasksNum || num < 0) {
                    System.out.println("Input is out of scope. Possible options are: 0 -> " + tasksNum);
                    line = scan.nextLine().strip();
                } else {
                    tasks = Utils.removeFromArray(tasks, num);
                    System.out.println("Value was successfully deleted.");
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Input not a integer value. Try again.");
                line = scan.nextLine().strip();
            }
        }
        return tasks;
    }

    private static void listTasks(String[][] tasks) {
        if (tasks.length == 0) {
            System.out.println(ConsoleColors.YELLOW + "No tasks to print out" + ConsoleColors.RESET);
        }

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
