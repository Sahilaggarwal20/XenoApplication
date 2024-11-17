package com.xeno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xeno.entity.CommunicationLog;
import com.xeno.repo.CommunicationRepo;

import java.time.LocalDateTime;
import java.util.Random;

@RestController
@RequestMapping("/api/messages")
public class MessageAPI {
    
    @Autowired
    private CommunicationRepo communicationsLogRepository;

    @PostMapping("/send")
    public CommunicationLog sendMessage(@RequestParam String audienceSegmentName, @RequestParam String message) {
        CommunicationLog log = new CommunicationLog();
        log.setAudienceSegmentName(audienceSegmentName);
        log.setMessage(message);
        log.setStatus("PENDING");
        log.setSentAt(LocalDateTime.now());
        
        CommunicationLog savedLog = communicationsLogRepository.save(log);

        // Simulate delivery receipt
        handleDeliveryReceipt(savedLog.getId());
        return savedLog;
    }

    private void handleDeliveryReceipt(Long logId) {
        Random random = new Random();
        String status = random.nextInt(10) < 9 ? "SENT" : "FAILED";

        CommunicationLog log = communicationsLogRepository.findById(logId).orElseThrow();
        log.setStatus(status);
        communicationsLogRepository.save(log);
    }
}
