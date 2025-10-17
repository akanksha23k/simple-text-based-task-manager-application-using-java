package com.jap.task;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class TaskOperations {
    private List<Task> tasks;

    public TaskOperations() {
        tasks = new ArrayList<>();
    }

    public boolean addTask(Category category, Task task, User user) {
        if (category == null || task == null || user == null) {
            return false;
        }
        tasks.add(task);
        return true;
    }

    public List<Task> listAllTasks() {
        return tasks;
    }

    public boolean markTaskAsCompleted(String taskName, String status) {
        for (Task task : tasks) {
            if (task.getName().equals(taskName)) {
                task.setStatus(status);
                return true;
            }
        }
        return false;
    }

    public boolean removeTask(String taskName) throws TaskNotFoundException {
        for (Task task : tasks) {
            if (task.getName().equals(taskName)) {
                tasks.remove(task);
                return true;
            }
        }
        throw new TaskNotFoundException("Task with name " + taskName + " not found!");
    }

    public Task searchTasksByName(String taskName) {
        for (Task task : tasks) {
            if (task.getName().equals(taskName)) {
                return task;
            }
        }
        return null;
    }
}