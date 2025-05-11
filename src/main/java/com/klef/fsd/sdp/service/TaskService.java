package com.klef.fsd.sdp.service;

import java.util.List;
import com.klef.fsd.sdp.model.Task;

public interface TaskService {
    public String addtask(Task task);
    public List<Task> viewalltasks();
    public String deletetask(int id);
}