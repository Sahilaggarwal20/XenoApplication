package com.xeno.controller;

import com.xeno.config.AudienceService;
import com.xeno.entity.AudienceSegment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller

@RequestMapping("/audience")
public class Audiencecontroller {

    @Autowired
    private AudienceService service;
    // Show all audience segments
    @GetMapping
    public String viewSegments(Model model) {
        model.addAttribute("segments", service.getAllSegments());
        return "audience/segments";
    }
    // Show form to create a new audience segment
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("segment", new AudienceSegment());
        return "audience/create";  // Thymeleaf template
    }

    // Handle the form submission for creating a new audience segment
    @PostMapping("/create")
    public String createSegment(AudienceSegment segment) {
        service.saveSegment(segment);  // Calls saveSegment which calculates audience size
        return "redirect:/audience";  // Redirect to view all segments
    }
    
}
