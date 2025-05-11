package com.klef.fsd.sdp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.klef.fsd.sdp.model.Task;
import com.klef.fsd.sdp.service.TaskService;

@RestController
@RequestMapping("/task")
@CrossOrigin("*")
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
    @GetMapping("/")
    public String home() {
        return "Task Management System";
    }
    
    @PostMapping("/addtask")
    public ResponseEntity<?> addtask(@RequestBody Task task) {
        try {
            String output = taskService.addtask(task);
            return ResponseEntity.ok(output);
        } catch(Exception e) {
            return ResponseEntity.status(500).body("Failed to Add task: " + e.getMessage()); 
        }
    }
    
    @GetMapping("/viewalltasks")
    public ResponseEntity<?> viewalltasks() {
        try {
            List<Task> tasks = taskService.viewalltasks();
            if(tasks.isEmpty()) {
                return ResponseEntity.ok("No tasks found");
            }
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching tasks: " + e.getMessage());
        }
    }
    
    @DeleteMapping("/deletetask")
    public ResponseEntity<?> deletetask(@RequestParam("id") int id) {
        try {
            String output = taskService.deletetask(id);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting task: " + e.getMessage());
        }
    }
}
