package com.xeno.repo;

import com.xeno.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CRepository extends JpaRepository<Customer, Long> {
    List<Customer> findBySegmentName(String segmentName); // Match 'segmentName' in Customer entity
}
