package com.klef.fsd.sdp.controller;

import com.klef.fsd.sdp.model.User;
import com.klef.fsd.sdp.model.ProfileUpdateRequest;
import com.klef.fsd.sdp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String home() {
        return "FSD SDP Project";
    }
    
    @PostMapping("/registration")
    public ResponseEntity<String> userRegistration(@RequestBody User user) {
        try {
            String output = userService.userRegistration(user);
            return ResponseEntity.ok(output);
        } catch(Exception e) {
            return ResponseEntity.status(500).body("User Registration Failed");
        }
    }
    
    @PostMapping("/checkuserlogin")
    public ResponseEntity<?> checkUserLogin(@RequestBody User user) {
        try {
            User u = userService.checkUserLogin(user.getUsername(), user.getPassword());
            if (u != null) {
                return ResponseEntity.ok(u);
            } else {
                return ResponseEntity.status(401).body("Invalid Username or Password");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Login failed: " + e.getMessage());
        }
    }
    @PostMapping("/requestprofileupdate")
    public ResponseEntity<?> requestProfileUpdate(@RequestBody ProfileUpdateRequest request) {
        try {
            String result = userService.requestProfileUpdate(request);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
        }
    }
    
    @PostMapping("/approveprofileupdate/{requestId}")
    public ResponseEntity<?> approveProfileUpdate(@PathVariable int requestId) {
        try {
            String result = userService.approveProfileUpdate(requestId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error approving request: " + e.getMessage());
        }
    }
    
    
    
    @GetMapping("/pendingprofileupdates")
    public ResponseEntity<?> getPendingProfileUpdates() {
        try {
            List<ProfileUpdateRequest> requests = userService.getPendingProfileUpdates();
            return ResponseEntity.ok(requests);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching requests: " + e.getMessage());
        }
    }
    
    
    
   
    @GetMapping("/getuserbyid/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        try {
            User user = userService.getUserById(id);
            if(user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(404).body("User not found");
            }
        } catch(Exception e) {
            return ResponseEntity.status(500).body("Error fetching user: " + e.getMessage());
        }
    }
    @PostMapping("/requestprofileupdate")
    public ResponseEntity<?> requestProfileUpdate(@RequestBody ProfileUpdateRequest request) {
        try {
            String result = userService.requestProfileUpdate(request);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing request: " + e.getMessage());
        }
    }
    
   
    
}
