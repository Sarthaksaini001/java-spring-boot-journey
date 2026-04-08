package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer for task management operations.
 * Handles business logic for creating and retrieving tasks.
 */
@Service
public class TaskService {
    
    // In-memory storage for tasks
    private final List<Task> tasks = new ArrayList<>();
    // Counter to generate unique task ids
    private Long nextId = 1L;

    /**
     * Retrieves all tasks from storage.
     * 
     * @return a list of all tasks
     */
    public List<Task> getAllTasks() {
        return tasks;
    }

    /**
     * Creates and stores a new task.
     * Assigns a unique id to the task before storing.
     * 
     * @param task the task to create
     * @return the created task with an assigned id
     */
    public Task createTask(Task task) {
        // Assign unique id and increment counter for next task
        task.setId(nextId++);
        // Add task to storage
        tasks.add(task);
        return task;
    }

    /**
     * Retrives the task that matches the Task Id.
     * 
     * @param id Task Id provided 
     * @return Returns the task that matches the Id
     */
    public Task getTaskById(Long id){
        return tasks.stream()
        .filter(task -> task.getId().equals(id))
        .findFirst()
        .orElse(null);
    }

    /**
     * Updates the Task
     * 
     * @param id Id of the task to be updates
     * @param updatedTask Updated Task 
     * 
     * @return Existing updated Task
     */
    public Task updateTask(Long id, Task updatedTask){
        Task existingTask = getTaskById(id);

        // Checks if the task is not null
        if ( existingTask != null ){
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setCompleted(updatedTask.isCompleted());
        }

        return existingTask;
    }

    /**
     * Deletes the Task
     * 
     * @param id Task Id to be deleted 
     * 
     * @return The Task deleted equavalen to ID 
     */
    public boolean deleteTask(Long id){
        return tasks.removeIf(task -> task.getId().equals(id));
    }
}
