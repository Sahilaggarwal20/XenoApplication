package com.xeno.config;

import com.xeno.entity.Campaign;
import com.xeno.entity.CommunicationLog;
import com.xeno.entity.Customer;
import com.xeno.repo.CRepository;
import com.xeno.repo.CommunicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class CommunicationLogMessage {

    @Autowired
    private CRepository customerRepository;

    @Autowired
    private CommunicationRepo communicationsLogRepository;

    private static final Random RANDOM = new Random();

    /**
     * Sends a message to customers in the specified audience segment and updates the communication log.
     *
     * @param audienceSegmentName Name of the audience segment.
     * @param messageTemplate     Message template for personalization.
     * @return CommunicationsLog for the sent message.
     */
    public CommunicationLog sendMessage(String audienceSegmentName, String messageTemplate) {
        // Fetch audience segment customers (You might implement a filter based on your segment logic)
        List<Customer> customers = customerRepository.findBySegmentName(audienceSegmentName);

        // Log communication and simulate delivery status for each customer
        for (Customer customer : customers) {
            String personalizedMessage = messageTemplate.replace("[Name]", customer.getName());

            // Simulate delivery status
            String deliveryStatus = RANDOM.nextInt(10) < 9 ? "SENT" : "FAILED";

            // Save communication log
            CommunicationLog log = new CommunicationLog();
            log.setAudienceSegmentName(audienceSegmentName);
            log.setMessage(personalizedMessage);
            log.setStatus(deliveryStatus);
            log.setSentAt(LocalDateTime.now());
            log.setCustomerId(customer.getId());

            communicationsLogRepository.save(log);
        }

        // Return the last logged communication as an example
        return communicationsLogRepository.findFirstByOrderBySentAtDesc();
    }
    public void sendMessagesToAudience(Campaign campaign) {
        List<Customer> audience = getAudienceForCampaign(campaign);
        audience.forEach(customer -> {
            String status = Math.random() < 0.9 ? "SENT" : "FAILED";
            CommunicationLog log = new CommunicationLog();
            log.setCampaignId(campaign.getId());
            log.setStatus(status);
            log.setSentAt(LocalDateTime.now());
            communicationsLogRepository.save(log);
        });
    }
	private List<Customer> getAudienceForCampaign(Campaign campaign) {
		// TODO Auto-generated method stub
		return null;
	}
}
