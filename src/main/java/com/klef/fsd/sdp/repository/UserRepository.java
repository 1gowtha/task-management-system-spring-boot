package com.klef.fsd.sdp.repository;

import com.klef.fsd.sdp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByMobileno(String mobileno);

    @Modifying
    @Query("UPDATE User u SET u.name = ?2, u.gender = ?3, u.dob = ?4, u.email = ?5, u.mobileno = ?6, u.location = ?7, u.lastUpdated = CURRENT_TIMESTAMP WHERE u.id = ?1")
    void updateUserProfile(int userId, String name, String gender, String dob, String email, String mobileno, String location);

    @Query("select count(u) from User u")
    long usercount();
    
    @Query("select count(t) from Task t where t.user.id = ?1 and t.status = 'PENDING'")
    long countPendingTasksByUser(int userId);
}