package com.klef.fsd.sdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.fsd.sdp.model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    Manager findByUsernameAndPassword(String username, String password);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    @Query("select count(m) from Manager m")
    long managercount();
}
