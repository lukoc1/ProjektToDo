package org.example;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class TaskController {

    public static void run(String[][] tasks, String fileName) {

        var scan = new Scanner(System.in);
        var input = "";

        do {
            UI.displayMenu();
            input = StringUtils.normalizeSpace(scan.nextLine());

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
                case "exit":
                    exitGame(tasks, fileName);
                    break;
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
            line = StringUtils.normalizeSpace(scan.nextLine());
        } while(line.contains(","));
        newTask[0] = line;

        System.out.println("Please add task due date (use yyyy-MM-dd format)");
        while (true) {
            line = StringUtils.normalizeSpace(scan.nextLine());
            if (Utils.isValidDate(line)) {
                break;
            } else {
                System.out.println(ConsoleColors.YELLOW + "Given text is not in a applicable date format."
                        + " Try again and use yyyy-MM-dd" + ConsoleColors.RESET);
            }
        }
        newTask[1] = line;

        System.out.println("Is your task important: true/false");
        line = StringUtils.normalizeSpace(scan.nextLine());
        while (!"true".equals(line) && !"false".equals(line)) {
            System.out.println(ConsoleColors.YELLOW + "Input not applicable. Only options are: true/false" + ConsoleColors.RESET);
            line = StringUtils.normalizeSpace(scan.nextLine());
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
                int num = Integer.parseInt(line);
                if (num > tasksNum || num < 0) {
                    System.out.println(ConsoleColors.YELLOW + "Input is out of scope. Possible options are: 0 -> "
                            + tasksNum + ".\nTry again." + ConsoleColors.RESET);
                    line = scan.nextLine().strip();
                } else {
                    tasks = ArrayUtils.remove(tasks, num);
                    System.out.println("Task was successfully deleted.");
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

    private static void exitGame(String[][] tasks, String fileName) {
        Utils.saveToFile(tasks, fileName);
        System.out.println("Bye, bye.");
    }

}
