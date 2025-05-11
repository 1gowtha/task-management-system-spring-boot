package com.klef.fsd.sdp.service;

import java.util.List;
import com.klef.fsd.sdp.model.Admin;
import com.klef.fsd.sdp.model.User;
import com.klef.fsd.sdp.model.Manager;

public interface AdminService {
    public Admin checkadminlogin(String username, String password);
    public String adduser(User user);
    public String addeventmanager(Manager manager);
    public List<Manager> viewalleventmanagers();
    public List<User> viewallusers();
    public String deleteuser(int uid);
    public String deletemanager(int mid);
    public long displayusercount();
    public long displaymanagercount();
    public String addadmin(Admin admin);
}
