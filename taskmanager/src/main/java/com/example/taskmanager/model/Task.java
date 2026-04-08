package com.example.taskmanager.model;

/**
 * Represents a task entity with id, title, and completion status.
 * This model is used for task management operations in the application.
 */
public class Task {

    // Primary identifier for the task
    private Long id;
    // Title or description of the task
    private String title;
    // Indicates whether the task is completed
    private boolean completed;

    /**
     * Default constructor for Task.
     */
    public Task() {
    }

    /**
     * Constructs a Task with the specified id, title, and completion status.
     * 
     * @param id the unique identifier for the task
     * @param title the title or description of the task
     * @param completed the completion status of the task
     */
    public Task(Long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }
    
    /**
     * Gets the unique identifier of the task.
     * 
     * @return the task id
     */
    public Long getId() {
        return id;
    }

    // This code should be removed as setting id with setId is not idle and prone to malicious attack
    public void setId(Long id){
        this.id = id;
    }


    /**
     * Gets the title of the task.
     * 
     * @return the task title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the task.
     * 
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Checks if the task is completed.
     * 
     * @return true if the task is completed, false otherwise
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Sets the completion status of the task.
     * 
     * @param completed the completion status to set
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}