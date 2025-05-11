package com.klef.fsd.sdp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klef.fsd.sdp.model.Admin;
import com.klef.fsd.sdp.model.User;
import com.klef.fsd.sdp.model.Manager;
import com.klef.fsd.sdp.repository.AdminRepository;
import com.klef.fsd.sdp.repository.UserRepository;
import com.klef.fsd.sdp.repository.ManagerRepository;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public String addadmin(Admin admin) {
        adminRepository.save(admin);
        return "Admin Added Successfully";
    }
    @Override
    public Admin checkadminlogin(String username, String password) {
        return adminRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public String addeventmanager(Manager manager) {
        managerRepository.save(manager);
        return "Event Manager Added Successfully";
    }

    @Override
    public List<Manager> viewalleventmanagers() {
        return managerRepository.findAll();
    }

    @Override
    public List<User> viewallusers() {
        return userRepository.findAll();
    }

    @Override
    public String deleteuser(int uid) {
        userRepository.deleteById(uid);
        return "User Deleted Successfully";
    }

    @Override
    public String deletemanager(int mid) {
        managerRepository.deleteById(mid);
        return "Manager Deleted Successfully";
    }

    @Override
    public String adduser(User user) {
        userRepository.save(user);
        return "User Added Successfully";
    }

    @Override
    public long displayusercount() {
        return userRepository.usercount();
    }

    @Override
    public long displaymanagercount() {
        return managerRepository.managercount();
    }
}
