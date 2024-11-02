package com.sricode;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java -jar tasktracker.jar <command> [options]");
            return;
        }

        String command = args[0];
        ArrayList<Task> tasks = JsonUtil.readTasks();

        switch (command) {
            case "add":
                if (args.length < 3) {
                    System.out.println("Usage: add <id> <description>");
                    return;
                }
                addTask(tasks, args[1], args[2]);
                break;
            case "update":
                if (args.length < 4) {
                    System.out.println("Usage: update <id> <description> <status>");
                    return;
                }
                updateTask(tasks, args[1], args[2], Status.valueOf(args[3]));
                break;
            case "delete":
                if (args.length < 2) {
                    System.out.println("Usage: delete <id>");
                    return;
                }
                deleteTask(tasks, args[1]);
                break;
            case "list":
                listTasks(tasks);
                break;
            case "list-done":
                listTasksByStatus(tasks, Status.DONE);
                break;
            case "list-not-done":
                listTasksByStatus(tasks, Status.OPEN);
                break;
            case "list-in-progress":
                listTasksByStatus(tasks, Status.IN_PROGRESS);
                break;
            default:
                System.out.println("Unknown command: " + command);
        }

        JsonUtil.writeTasks(tasks);
    }

    static void addTask(List<Task> tasks, String id, String description) {
        Task task = new Task(id, description, Status.OPEN, new Date(), new Date());
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    static void updateTask(List<Task> tasks, String id, String description, Status status) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setDescription(description);
                task.setStatus(status);
                task.setUpdatedDate(new Date());
                System.out.println("Task updated: " + task);
                return;
            }
        }
        System.out.println("Task not found: " + id);
    }

    static void deleteTask(List<Task> tasks, String id) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId().equals(id)) {
                iterator.remove();
                System.out.println("Task deleted: " + id);
                return;
            }
        }
        System.out.println("Task not found: " + id);
    }

    static void listTasks(List<Task> tasks) {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    static void listTasksByStatus(List<Task> tasks, Status status) {
        for (Task task : tasks) {
            if (task.getStatus() == status) {
                System.out.println(task);
            }
        }
    }
}