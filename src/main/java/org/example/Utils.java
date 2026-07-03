package org.example;

import java.util.Arrays;

public class Utils {
    public static String[][] addToArray(String[][] arr, String[] value) {
        String[][] added = Arrays.copyOf(arr, arr.length + 1);
        added[added.length - 1] = value;
        return added;
    }

    public static String[][] removeFromArray(String[][] arr, int id) {
        String[][] temp = {};
        for (int i = 0; i < arr.length; i++) {
            if (id == i) {
                continue;
            }
            temp = addToArray(temp, arr[i]);
        }
        return temp;

    }
}
