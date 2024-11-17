package com.xeno.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xeno.entity.AudienceSegment;
import com.xeno.entity.Customer;
import com.xeno.repo.AudienceRepo;
import com.xeno.repo.CRepository;

@Service
public class AudienceCustomerService {

    @Autowired
    private CRepository customerRepository;

    @Autowired
    private AudienceRepo audienceRepository; // Ensure this is correctly autowired

    public int calculateAudienceSize(AudienceSegment segment) {
        List<Customer> customers = customerRepository.findAll();
        return (int) customers.stream()
            .filter(customer -> {
                boolean matchesSpending = customer.getTotalSpending() >= segment.getSpendingValue();
                boolean matchesVisit = matchesVisitCondition(customer, segment);
                boolean matchesLastVisit = matchesLastVisitCondition(customer, segment);
                
                return segment.getConditionLogic().equalsIgnoreCase("AND") ? 
                    (matchesSpending && matchesVisit && matchesLastVisit) :
                    (matchesSpending || matchesVisit || matchesLastVisit);
            })
            .count();
    }

    private boolean matchesSpendingCondition(Customer customer, AudienceSegment segment) {
        return customer.getTotalSpending() >= segment.getSpendingValue();
    }

    private boolean matchesVisitCondition(Customer customer, AudienceSegment segment) {
        switch (segment.getVisitCondition()) {
            case "greater":
                return customer.getVisits() > segment.getVisitValue();
            case "less":
                return customer.getVisits() < segment.getVisitValue();
            case "equal":
                return customer.getVisits().equals(segment.getVisitValue());
            default:
                return false;
        }
    }

    private boolean matchesLastVisitCondition(Customer customer, AudienceSegment segment) {
        LocalDate cutoffDate = LocalDate.now().minusMonths(segment.getLastVisitMonths());
        return segment.getLastVisitCondition().equals("before")
               ? customer.getLastVisitDate().isBefore(cutoffDate)
               : customer.getLastVisitDate().isAfter(cutoffDate);
    }

    // Method to save AudienceSegment with audience size calculation
    public AudienceSegment saveSegment(AudienceSegment segment) {
        segment.setAudienceSize(calculateAudienceSize(segment));
        return audienceRepository.save(segment);  // Use segmentRepository here
    }

    // Method to retrieve all segments
    public List<AudienceSegment> getAllSegments() {
        return audienceRepository.findAll();  // Use segmentRepository here
    }
}
