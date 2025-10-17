package com.jap.task;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Authenticate
        Authenticator authenticator = new Authenticator();
        User authenticatedUser = null;

        while (authenticatedUser == null) {
            System.out.println("Enter your Username");
            String username = scanner.nextLine();
            System.out.println("Enter your Password");
            String password = scanner.nextLine();

            if (authenticator.authenticateUser(username, password)) {
                authenticatedUser = authenticator.getAuthenticatedUser();
                System.out.println("Authentication Successful : Welcome " + authenticatedUser.getUserName());
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
        }

        // Step 2: Task Manager
        TaskOperations taskOperations = new TaskOperations();
        CategoryOperations categoryOperations = new CategoryOperations();

        int choice;
        do {
            System.out.println("\nTask Manager Menu");
            System.out.println("1. Add a Task");
            System.out.println("2. List the Task");
            System.out.println("3. Mark the Task as Completed");
            System.out.println("4. Remove the Task");
            System.out.println("5. Add a Category");
            System.out.println("6. List the Category");
            System.out.println("7. Search the Task by Name");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: // Add Task
                    System.out.print("Enter category name: ");
                    String categoryName = scanner.nextLine();
                    Category category = categoryOperations.findCategory(categoryName);
                    if (category == null) {
                        System.out.println("Category not found. Please create the category first.");
                    } else {
                        System.out.print("Enter Task Name: ");
                        String taskName = scanner.nextLine();
                        System.out.print("Enter Priority (1-5): ");
                        int priority = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Description: ");
                        String description = scanner.nextLine();
                        Task task = new Task(taskName, priority, description, category);
                        if (taskOperations.addTask(category, task, authenticatedUser)) {
                            System.out.println("Task added successfully!");
                        }
                    }
                    break;

                case 2: // List Tasks
                    for (Task t : taskOperations.listAllTasks()) {
                        System.out.println("Name: " + t.getName() +
                                " | Priority: " + t.getPriority() +
                                " | Description: " + t.getDescription() +
                                " | Category: " + t.getCategory().getName() +
                                " | Status: " + t.getStatus());
                    }
                    break;

                case 3: // Mark Completed
                    System.out.print("Enter task name to mark completed: ");
                    String taskToComplete = scanner.nextLine();
                    if (taskOperations.markTaskAsCompleted(taskToComplete, "Completed")) {
                        System.out.println("Task marked as Completed.");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 4: // Remove Task
                    System.out.print("Enter task name to remove: ");
                    String taskToRemove = scanner.nextLine();
                    try {
                        if (taskOperations.removeTask(taskToRemove)) {
                            System.out.println("Task removed successfully.");
                        }
                    } catch (TaskNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5: // Add Category
                    System.out.print("Enter category name: ");
                    String newCategory = scanner.nextLine();
                    if (categoryOperations.addCategory(newCategory)) {
                        System.out.println("Category added successfully.");
                    }
                    break;

                case 6: // List Categories
                    for (Category c : categoryOperations.listAllCategories()) {
                        System.out.println("Category: " + c.getName());
                    }
                    break;

                case 7: // Search Task
                    System.out.print("Enter task name to search: ");
                    String searchName = scanner.nextLine();
                    Task foundTask = taskOperations.searchTasksByName(searchName);
                    if (foundTask != null) {
                        System.out.println("Task found: " + foundTask.getName() +
                                " | Status: " + foundTask.getStatus());
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 8: // Exit
                    System.out.println("Exiting Task Manager...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 8);

        scanner.close();
    }
}
