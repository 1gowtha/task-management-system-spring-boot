package com.klef.fsd.sdp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;
    
    @Column(name="user_name", length = 50, nullable = false)
    private String name;
    
    @Column(name="user_gender", length = 10, nullable = false)
    private String gender;
    
    @Column(name="user_dob", length = 20, nullable = false)
    private String dob;
    
    @Column(name="user_email", length = 50, nullable = false, unique=true)
    private String email;
    
    @Column(name="user_uname", length = 50, nullable = false, unique=true)
    private String username;
    
    @Column(name="user_pwd", length = 50, nullable = false)
    private String password;
    
    @Column(name="user_mobileno", length = 20, nullable = false, unique=true)
    private String mobileno;
    
    @Column(name="user_location", length = 50, nullable = false)
    private String location;
    
    @Column(name="profile_status", length = 20, nullable = false)
    private String profileStatus = "ACTIVE";
    
    @Column(name="last_updated")
    private LocalDateTime lastUpdated;
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getMobileno() { return mobileno; }
    public void setMobileno(String mobileno) { this.mobileno = mobileno; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getProfileStatus() { return profileStatus; }
    public void setProfileStatus(String profileStatus) { this.profileStatus = profileStatus; }
    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }
}
