package org.example;

import org.apache.commons.lang3.time.DateParser;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class Utils {
    public static String[][] addToArray(String[][] arr, String[] value) {
        String[][] added = Arrays.copyOf(arr, arr.length + 1);
        added[added.length - 1] = value;
        return added;
    }

    public static void saveToFile(String[][] tasks, String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (var task : tasks) {
                writer.println(Arrays.toString(task));
            }
            System.out.println("Successfully saved tasks to: " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + fileName);
        }
    }

    public static boolean isValidDate(String text) {
        try {
            LocalDate.parse(text);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
