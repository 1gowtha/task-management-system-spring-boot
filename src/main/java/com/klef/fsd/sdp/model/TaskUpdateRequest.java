//package com.klef.fsd.sdp.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "task_update_requests")
//public class TaskUpdateRequest {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    
//    @ManyToOne
//    @JoinColumn(name = "task_id", nullable = false)
//    private Task task;
//    
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User requestedBy;
//    
//    private String newTitle;
//    private String newDescription;
//    private String newPriority;
//    private String newDate;
//    
//    @Enumerated(EnumType.STRING)
//    private ApprovalStatus status = ApprovalStatus.PENDING;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Task getTask() {
//		return task;
//	}
//
//	public void setTask(Task task) {
//		this.task = task;
//	}
//
//	public User getRequestedBy() {
//		return requestedBy;
//	}
//
//	public void setRequestedBy(User requestedBy) {
//		this.requestedBy = requestedBy;
//	}
//
//	public String getNewTitle() {
//		return newTitle;
//	}
//
//	public void setNewTitle(String newTitle) {
//		this.newTitle = newTitle;
//	}
//
//	public String getNewDescription() {
//		return newDescription;
//	}
//
//	public void setNewDescription(String newDescription) {
//		this.newDescription = newDescription;
//	}
//
//	public String getNewPriority() {
//		return newPriority;
//	}
//
//	public void setNewPriority(String newPriority) {
//		this.newPriority = newPriority;
//	}
//
//	public String getNewDate() {
//		return newDate;
//	}
//
//	public void setNewDate(String newDate) {
//		this.newDate = newDate;
//	}
//
//	public ApprovalStatus getStatus() {
//		return status;
//	}
//
//	public void setStatus(ApprovalStatus status) {
//		this.status = status;
//	}
//    
//    // Getters and setters
//    // Constructor
//}
//
//public enum ApprovalStatus {
//    PENDING, APPROVED, REJECTED
//}
