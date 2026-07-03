package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TaskFileReader {
    public static String[][] readSavedTasks() {
        var fileName = "tasks.csv";

        try (var scan = new Scanner(new File(fileName));
             var scan2 = new Scanner(new File(fileName))){

            var rowsNum = 0;
            while (scan.hasNextLine()) {
                scan.nextLine();
                rowsNum++;
            }

            String[][] tasks = new String[rowsNum][3];

            int row = 0;
            while(scan2.hasNextLine()) {
                var line = scan2.nextLine();
                var parts = line.split("," + "\\s+");
                tasks[row][0] = parts[0];
                tasks[row][1] = parts[1];
                tasks[row][2] = parts[2];
                row++;
            }
            return (tasks);

        } catch (FileNotFoundException e) {
            System.out.println("Nie udało się odczytać pliku: " + fileName);
        }
        return (new String[0][0]);
    }
}
