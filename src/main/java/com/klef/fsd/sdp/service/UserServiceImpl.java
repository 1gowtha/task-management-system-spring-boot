package com.klef.fsd.sdp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsd.sdp.model.ProfileUpdateRequest;
import com.klef.fsd.sdp.model.User;
import com.klef.fsd.sdp.repository.ProfileUpdateRequestRepository;
import com.klef.fsd.sdp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileUpdateRequestRepository profileUpdateRequestRepository;

    @Override
    public String userRegistration(User user) 
    {
        userRepository.save(user);
        return "User Registered Successfully";
    }

    @Override
    public User checkUserLogin(String username, String password) 
    {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public String updateUserProfile(User user) {
        return "Profile update must be approved by admin";
    }

    @Override
    public String requestProfileUpdate(ProfileUpdateRequest request) {
        profileUpdateRequestRepository.save(request);
        return "Profile update request submitted successfully";
    }

    @Override
    public List<ProfileUpdateRequest> getPendingProfileUpdates() {
        return profileUpdateRequestRepository.findByStatus("PENDING");
    }

    @Override
    public String approveProfileUpdate(int requestId) {
        try {
            ProfileUpdateRequest request = profileUpdateRequestRepository.findById(requestId).orElse(null);
            if (request != null) {
                User user = request.getUser();
                // Update user profile with requested changes
                user.setName(request.getName());
                user.setGender(request.getGender());
                user.setDob(request.getDob());
                user.setEmail(request.getEmail());
                user.setMobileno(request.getMobileno());
                user.setLocation(request.getLocation());
                
                userRepository.save(user);
                request.setStatus("APPROVED");
                profileUpdateRequestRepository.save(request);
                
                return "Profile update approved successfully";
            }
            return "Request not found";
        } catch (Exception e) {
            return "Error approving profile update: " + e.getMessage();
        }
    }


    @Override
    public String rejectProfileUpdate(int requestId) {
        try {
            ProfileUpdateRequest request = profileUpdateRequestRepository.findById(requestId).orElse(null);
            if (request != null) {
                request.setStatus("REJECTED");
                profileUpdateRequestRepository.save(request);
                return "Profile update rejected";
            }
            return "Request not found";
        } catch (Exception e) {
            return "Error rejecting profile update: " + e.getMessage();
        }
    }


}
