package org.example;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class Utils {
    public static String[][] addToArray(String[][] arr, String[] value) {
        String[][] added = Arrays.copyOf(arr, arr.length + 1);
        added[added.length - 1] = value;
        return added;
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
