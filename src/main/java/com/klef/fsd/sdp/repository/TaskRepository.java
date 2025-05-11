package com.klef.fsd.sdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klef.fsd.sdp.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    // Custom query methods can be added here if needed
}
