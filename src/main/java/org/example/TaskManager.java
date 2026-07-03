package org.example;

public class TaskManager {
    public static void main(String[] args) {
        String[][] tasks = ReadSavedTasks.readSavedTasks();
        UI.displayMenu();
    }
}