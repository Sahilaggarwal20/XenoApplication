package com.xeno.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xeno.entity.AudienceSegment;
import com.xeno.entity.Customer;
import com.xeno.repo.AudienceRepo;
import com.xeno.repo.CRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class AudienceService {

    @Autowired
    private AudienceRepo repository;
    
    @Autowired
    private CRepository customerRepository;

    public AudienceSegment saveSegment(AudienceSegment segment) {
        int size = calculateAudienceSize(segment);
        segment.setAudienceSize(size);
        return repository.save(segment);
    }

    public List<AudienceSegment> getAllSegments() {
        return repository.findAll();
    }

    private int calculateAudienceSize(AudienceSegment segment) {
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

    private boolean matchesVisitCondition(Customer customer, AudienceSegment segment) {
        if (customer.getVisits() == null || segment.getVisitValue() == null) {
            return false;
        }
        switch (segment.getVisitCondition().toLowerCase()) {
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
        if (customer.getLastVisitDate() == null || segment.getLastVisitMonths() == null) {
            return false;
        }
        LocalDate cutoffDate = LocalDate.now().minusMonths(segment.getLastVisitMonths());
        return segment.getLastVisitCondition().equals("before") ?
               customer.getLastVisitDate().isBefore(cutoffDate) :
               customer.getLastVisitDate().isAfter(cutoffDate);
    }
}