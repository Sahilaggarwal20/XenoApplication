package com.xeno.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import com.xeno.entity.Campaign;
import java.util.List;

public interface CampaignRepo extends JpaRepository<Campaign, Long> {
    List<Campaign> findByAudienceSegmentNameOrderByCreatedAtDesc(String audienceSegmentName);
}
