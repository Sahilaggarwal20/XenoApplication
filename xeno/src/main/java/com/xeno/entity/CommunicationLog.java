package com.xeno.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CommunicationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String audienceSegmentName;

    private String message;

    private String status;

    private LocalDateTime sentAt;

    private Long customerId; // Ensure this field exists

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

	public void setCampaignId(Long id2) {
		// TODO Auto-generated method stub
		
	}
}
