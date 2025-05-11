package com.klef.fsd.sdp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.fsd.sdp.model.Manager;
import com.klef.fsd.sdp.service.ManagerService;

@RestController
@RequestMapping("/manager")
@CrossOrigin("*")
public class ManagerController 
{
   @Autowired
   private ManagerService managerService;
	   
   @PostMapping("/checkmanagerlogin")
   public ResponseEntity<?> checkmanagerlogin(@RequestBody Manager manager) 
   {
       try 
       {
           Manager m = managerService.checkmanagerlogin(manager.getUsername(), manager.getPassword());

           if (m != null) 
           {
               return ResponseEntity.ok(m);
           } 
           else 
           {
               return ResponseEntity.status(401).body("Invalid Username or Password");
           }
       } 
       catch (Exception e) 
       {
           return ResponseEntity.status(500).body("Login failed: " + e.getMessage());
       }
   }
}
