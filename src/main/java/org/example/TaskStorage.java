package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TaskStorage {
    public static String[][] readSavedTasks(String fileName) {

        try (var scan = new Scanner(new File(fileName))){

            String[][] tasks = {};

            while(scan.hasNextLine()) {
                var line = scan.nextLine();
                var parts = line.split(",\\s+");

                if (!Utils.isValidTaskRow(parts)) {
                    throw new IllegalArgumentException("Invalid row in file: "
                                + fileName + " -> " + line);
                }
                tasks = Utils.addToArray(tasks, parts);
            }
            return tasks;

        } catch (FileNotFoundException e) {
            System.out.println("Could not read from file: " + fileName);
        }
        return new String[0][0];
    }

    public static void saveToFile(String[][] tasks, String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (var task : tasks) {
                writer.println(String.join(", ", task));
            }
            System.out.println("Successfully saved tasks to: " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + fileName);
        }
    }
}
