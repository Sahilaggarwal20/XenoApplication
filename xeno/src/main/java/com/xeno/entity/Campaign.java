package com.xeno.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Campaign {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // Campaign name
    private String audienceSegmentName; // Associated audience segment
    private String message;  // Message sent
    private LocalDateTime createdAt;  // When the campaign was created
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAudienceSegmentName() {
		return audienceSegmentName;
	}
	public void setAudienceSegmentName(String audienceSegmentName) {
		this.audienceSegmentName = audienceSegmentName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
    
    // Getters and Setters
}
