package com.sricode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testAddTask() {
        // Given
        Task task = new Task("1", "Task 1", Status.OPEN, null, null);
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);

        // When
        Main.addTask(tasks, "2", "Task 2");

        // Then
        assertEquals(2, tasks.size());
        assertEquals("2", tasks.get(1).getId());
        assertEquals("Task 2", tasks.get(1).getDescription());
        assertEquals(Status.OPEN, tasks.get(1).getStatus());
    }

    @Test
    public void testUpdateTask() {
        // Given
        Task task1 = new Task("1", "Task 1", Status.OPEN, null, null);
        Task task2 = new Task("2", "Task 2", Status.OPEN, null, null);
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);

        // When
        Main.updateTask(tasks, "2", "Task 2", Status.IN_PROGRESS);

        // Then
        assertEquals(2, tasks.size());
        assertEquals("2", tasks.get(1).getId());
        assertEquals("Task 2", tasks.get(1).getDescription());
        assertEquals(Status.IN_PROGRESS, tasks.get(1).getStatus());
    }

    @Test
    public void testDeleteTask() {
        // Given
        Task task1 = new Task("1", "Task 1", Status.OPEN, null, null);
        Task task2 = new Task("2", "Task 2", Status.OPEN, null, null);
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);

        // When
        Main.deleteTask(tasks, "2");

        // Then
        assertEquals(1, tasks.size());
        assertEquals("1", tasks.get(0).getId());
        assertEquals("Task 1", tasks.get(0).getDescription());
        assertEquals(Status.OPEN, tasks.get(0).getStatus());
    }

    @Test
    public void testListTasks() {
        // Given
        Task task1 = new Task("1", "Task 1", Status.OPEN, null, null);
        Task task2 = new Task("2", "Task 2", Status.IN_PROGRESS, null, null);
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);

        // When
        Main.listTasks(tasks);

        // Then
        // Verify that the method prints the tasks to the console
    }

    @Test
    public void testListTasksByStatus() {
        // Given
        Task task1 = new Task("1", "Task 1", Status.OPEN, null, null);
        Task task2 = new Task("2", "Task 2", Status.IN_PROGRESS, null, null);
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);

        // When
        Main.listTasksByStatus(tasks, Status.IN_PROGRESS);

        // Then
        // Verify that the method prints the tasks to the console
    }

}