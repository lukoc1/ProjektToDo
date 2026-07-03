package org.example;


public class TaskManager {

    private static final String TASKS_FILE = "tasks.csv";

    public static void main(String[] args) {

        String[][] tasks = TaskFileReader.readSavedTasks(TASKS_FILE);

        TaskController.run(tasks, TASKS_FILE);
    }
}