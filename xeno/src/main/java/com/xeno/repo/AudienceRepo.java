package com.xeno.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xeno.entity.AudienceSegment;

public interface AudienceRepo extends JpaRepository<AudienceSegment, Long> {
    // Custom queries (if needed) can be added here

}
