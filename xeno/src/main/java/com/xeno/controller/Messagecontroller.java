package com.xeno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.xeno.config.CampaignService;
import com.xeno.config.AudienceService;
import com.xeno.config.CommunicationLogMessage;
import com.xeno.entity.Campaign;

@Controller
@RequestMapping("/messages")
public class Messagecontroller {
    
    @Autowired
    private CampaignService campaignService;
    
    @Autowired
    private AudienceService audienceService;
    
    @Autowired
    private CommunicationLogMessage communicationService;
    
    @GetMapping
    public String listMessages(Model model) {
        model.addAttribute("campaigns", campaignService.getAllCampaign());
        return "messages/list";
    }
    
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        // Fetch audience segments and add them to the model
        model.addAttribute("segments", audienceService.getAllSegments());
        model.addAttribute("campaign", new Campaign()); // Add a new campaign object for binding
        return "messages/create"; // Return the template name
    }

    
    @PostMapping("/create")
    public String createMessage(@ModelAttribute Campaign campaign) {
        // Save campaign
        Campaign savedCampaign = campaignService.createCampaign(campaign);
        
        // Send messages to audience
        communicationService.sendMessage(
            campaign.getAudienceSegmentName(),
            campaign.getMessage()
        );
        
        return "redirect:/messages";
    }
    
    @GetMapping("/view/{id}")
    public String viewCampaign(@PathVariable Long id, Model model) {
        // Add campaign details and delivery stats to the model
        model.addAttribute("campaigns", 
            campaignService.getCampaignHistory(id.toString()));
        return "messages/view";
    }
    @GetMapping("/error")
    public String handleError() {
        // Return a custom error page
        return "error";
    }
}