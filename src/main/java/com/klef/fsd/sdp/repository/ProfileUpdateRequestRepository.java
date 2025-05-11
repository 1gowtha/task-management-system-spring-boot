package com.klef.fsd.sdp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.fsd.sdp.model.ProfileUpdateRequest;

@Repository
public interface ProfileUpdateRequestRepository extends JpaRepository<ProfileUpdateRequest, Integer> {
    List<ProfileUpdateRequest> findByStatus(String status);
}
