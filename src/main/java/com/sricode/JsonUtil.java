package com.sricode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonUtil {
    private static final String FILE_PATH = "tasks.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final Logger logger = Logger.getLogger(JsonUtil.class.getName());

    public static ArrayList<Task> readTasks() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Task[] tasks = gson.fromJson(reader, Task[].class);
            return tasks == null ? new ArrayList<>() : new ArrayList<>(List.of(tasks));
        }  catch (IOException e ) {
            logger.log(Level.SEVERE, "Error reading tasks from JSON file", e);
            return new ArrayList<>();
        }
    }

    public static void writeTasks(ArrayList<Task> tasks) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(tasks, writer);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error writing tasks to JSON file", e);
        }
    }
}
