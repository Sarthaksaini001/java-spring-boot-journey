package com.example.taskmanager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;

/**
 * REST controller for managing tasks.
 * Provides endpoints for retrieving and creating tasks.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    // Dependency injected service for task operations
    private final TaskService taskService;

    // Constructs a TaskController with the specified TaskService.
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Retrieves all tasks.
     * 
     * @return a list of all tasks
     */
    @GetMapping
    public List<Task> getAllTasks() {
        // Delegate to service layer to fetch all tasks
        return taskService.getAllTasks();
    }

    /**
     *  v02 : CRUD mapping operations are learned while making version 2
     * 
     *  Get - Read
     *  Post - Create
     *  Put - Update
     *  Delete - Delete
     *  
     */
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/{id}")
    public Task getTaskbyId(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id){
        boolean isdeleted = taskService.deleteTask(id);
        return isdeleted ? "Hurahhh! Task is deleted bro" : "There is no Task with this ID hehe";
    }

}