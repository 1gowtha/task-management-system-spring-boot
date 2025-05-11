package com.klef.fsd.sdp.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.klef.fsd.sdp.model.Admin;
import com.klef.fsd.sdp.model.User;
import com.klef.fsd.sdp.model.Manager;
import com.klef.fsd.sdp.service.AdminService;
import com.klef.fsd.sdp.service.GetMapping;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping("/adminlogin")
    public String adminLogin() {
        return "adminlogin"; // loads src/main/resources/templates/adminlogin.html
    }
   
        @GetMapping("/")
        public String home() {
            return "index"; // make sure src/main/resources/templates/index.html exists
        }
    
    @PostMapping("/checkadminlogin")
    public ResponseEntity<?> checkadminlogin(@RequestBody Admin admin) {
        try {
            Admin a = adminService.checkadminlogin(admin.getUsername(), admin.getPassword());
            if (a != null) {
                return ResponseEntity.ok(a);
            } else {
                return ResponseEntity.status(401).body("Invalid Username or Password");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Login failed: " + e.getMessage());
        }
    }

    @GetMapping("/viewallusers")
    public ResponseEntity<?> viewallusers() {
        try {
            List<User> users = adminService.viewallusers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching users: " + e.getMessage());
        }
    }
    
    @PostMapping("/adduser")
    public ResponseEntity<?> adduser(@RequestBody User user) {
        try {
            String output = adminService.adduser(user);
            return ResponseEntity.ok(output);
        } catch(Exception e) {
            return ResponseEntity.status(500).body("Failed to Add User: " + e.getMessage()); 
        }
    }

    @PostMapping("/addeventmanager")
    public ResponseEntity<?> addeventmanager(@RequestBody Manager manager) {
        try {
            String output = adminService.addeventmanager(manager);
            return ResponseEntity.ok(output);
        } catch(Exception e) {
            return ResponseEntity.status(500).body("Failed to Add Event Manager: " + e.getMessage()); 
        }
    }

    @GetMapping("/viewalleventmanagers")
    public ResponseEntity<?> viewalleventmanagers() {
        try {
            List<Manager> eventmanagers = adminService.viewalleventmanagers();
            return ResponseEntity.ok(eventmanagers);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching managers: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteuser")
    public ResponseEntity<?> deleteuser(@RequestParam("uid") int uid) {
        try {
            String output = adminService.deleteuser(uid);
            return ResponseEntity.ok(output);
        } catch(Exception e) {
            return ResponseEntity.status(500).body("Failed to Delete User: " + e.getMessage()); 
        }
    }

    @DeleteMapping("/deletemanager/{mid}")
    public ResponseEntity<?> deletemanager(@PathVariable int mid) {
        try {
            String output = adminService.deletemanager(mid);
            return ResponseEntity.ok(output);
        } catch(Exception e) {
            return ResponseEntity.status(500).body("Failed to Delete Manager: " + e.getMessage()); 
        }
    }
    @PostMapping("/addadmin")
    public ResponseEntity<?> addadmin(@RequestBody Admin admin) {
        try {
            String output = adminService.addadmin(admin);
            return ResponseEntity.ok(output);
        } catch(Exception e) {
            return ResponseEntity.status(500).body("Failed to Add Admin: " + e.getMessage());
        }
    }
    
    @GetMapping("/usercount")
    public ResponseEntity<Long> getUserCount() {
        long count = adminService.displayusercount();
        return ResponseEntity.ok(count);
    }

    
    @GetMapping("/managercount")
    public ResponseEntity<Long> getManagerCount() {
        long count = adminService.displaymanagercount();
        return ResponseEntity.ok(count);
    }
}
