package com.klef.fsd.sdp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klef.fsd.sdp.model.Task;
import com.klef.fsd.sdp.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
    
    @Autowired
    private TaskRepository taskRepository;
    
    @Override
    public String addtask(Task task) {
        taskRepository.save(task);
        return "Task Added Successfully";
    }
    
    @Override
    public List<Task> viewalltasks() {
        return taskRepository.findAll();
    }
    
    @Override
    public String deletetask(int id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return "Task Deleted Successfully";
        }
        return "Task not found";
    }
}
