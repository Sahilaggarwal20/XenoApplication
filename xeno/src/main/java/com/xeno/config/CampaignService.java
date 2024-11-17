
package com.xeno.config;

import com.xeno.entity.Campaign;
import com.xeno.repo.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CampaignService {
    
    @Autowired
    private CampaignRepo campaignRepository;

    public List<Campaign> getCampaignHistory(String audienceSegmentName) {
        return campaignRepository.findByAudienceSegmentNameOrderByCreatedAtDesc(audienceSegmentName);
    }
    public Campaign createCampaign(Campaign campaign) {
        campaign.setCreatedAt(LocalDateTime.now());
        return campaignRepository.save(campaign);
    }
    /* 
     * public List<Campaign> getAllCampaign() {
        List<Campaign> campaigns = campaignRepository.findAll();
        if (campaigns.isEmpty()) {
            throw new RuntimeException("No campaigns found");
        }
        return campaigns;
    }
    */
    public List<Campaign> getAllCampaign() {
        return campaignRepository.findAll(); // Ensure the repository method works
    }


}
