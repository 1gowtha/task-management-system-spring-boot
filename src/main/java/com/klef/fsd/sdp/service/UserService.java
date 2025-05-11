package com.klef.fsd.sdp.service;

import com.klef.fsd.sdp.model.User;
import com.klef.fsd.sdp.model.ProfileUpdateRequest;

import java.util.List;

public interface UserService {
    public String userRegistration(User user);
    public User checkUserLogin(String username, String password);
    public User getUserById(int id);
    public List<ProfileUpdateRequest> getPendingProfileUpdates();
    public String approveProfileUpdate(int requestId);
    public String rejectProfileUpdate(int requestId);
    public String updateUserProfile(User user);
    public String requestProfileUpdate(ProfileUpdateRequest request);
}
