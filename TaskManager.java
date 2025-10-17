package com.jap.task;

import java.util.Scanner;

public class TaskManager {
    // Attributes for category and task operations
    private CategoryOperations categoryOperations;
    private TaskOperations taskOperations;

    /**
     * Constructs a new TaskManager object.
     * Initializes category and task operation objects.
     */
    public TaskManager() {
        // Initialize category and task operation objects
        categoryOperations = new CategoryOperations();
        taskOperations = new TaskOperations();
    }

    /**
     * Allows the authenticated user to interact with the task manager by providing menu choices.
     *
     * @param authenticatedUser The authenticated user accessing the task manager.
     */
    public void takeChoices(User authenticatedUser) {
        Scanner scanner = new Scanner(System.in);
        String categoryName;
        Category selectedCategory;
        int choice;

        // Display the menu options and handle user choices until the user chooses to exit
        do {
            System.out.println("\nTask Manager Menu");
            System.out.println("1. Add a Task");
            System.out.println("2. List all Tasks");
            System.out.println("3. Mark a Task as Completed");
            System.out.println("4. Remove a Task");
            System.out.println("5. Add a Category");
            System.out.println("6. List all Categories");
            System.out.println("7. Search for a Task by Name");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add a new task
                    // Enter category name and fetch the category
                    // Check if category is present
                    // If present, display appropriate message to add task
                    // If category is not present, display appropriate message
                    break;
                case 2:
                    // List all tasks
                    // Enter category name and list tasks
                    break;
                case 3:
                    // Mark a task as completed
                    // Get the task name and task status
                    break;
                case 4:
                    // Remove a task
                    // Enter task name and handle exceptions
                    break;
                case 5:
                    // Add a new category
                    // Enter category name
                    break;
                case 6:
                    // List all categories
                    break;
                case 7:
                    // Search for a task by name
                    // Enter task name to search
                    break;
                case 8:
                    // Exit the program
                    System.out.println("Exiting Task Manager...");
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
                    break;
            }
        } while (choice != 8);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
