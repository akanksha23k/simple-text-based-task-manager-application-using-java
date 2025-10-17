package com.jap.task;

public class Task {
    private String name;
    private int priority; // 1-5
    private String description;
    private Category category;
    private String status; // "In Progress" or "Completed"

    public Task(String name, int priority, String description, Category category) {
        this.name = name;
        this.priority = priority;
        this.description = description;
        this.category = category;
        this.status = "In Progress";
    }

    // Overloaded constructor (used in your test)
    public Task(String name, int priority, String description, boolean isCompleted, Category category) {
        this.name = name;
        this.priority = priority;
        this.description = description;
        this.category = category;
        this.status = isCompleted ? "Completed" : "In Progress";
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
