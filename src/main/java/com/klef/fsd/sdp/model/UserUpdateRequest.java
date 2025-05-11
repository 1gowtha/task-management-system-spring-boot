package com.klef.fsd.sdp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_update_requests")
public class UserUpdateRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private int userId;
    
    @Column(length = 50)
    private String name;
    
    @Column(length = 10)
    private String gender;
    
    @Column(length = 20)
    private String dob;
    
    @Column(length = 50)
    private String email;
    
    @Column(length = 20)
    private String mobileno;
    
    @Column(length = 50)
    private String location;
    
    @Column(length = 20)
    private String status = "PENDING"; // PENDING, APPROVED, REJECTED

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getMobileno() { return mobileno; }
    public void setMobileno(String mobileno) { this.mobileno = mobileno; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
