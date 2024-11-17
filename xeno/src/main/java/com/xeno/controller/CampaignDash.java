package com.xeno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xeno.config.CampaignService;

@org.springframework.stereotype.Controller
@RequestMapping("/campaigns")
public class CampaignDash {
    @Autowired
    private CampaignService campaignService;
    
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("campaigns", campaignService.getAllCampaign());
        return "campaigns/dashboard";
    }
}