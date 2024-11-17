package com.xeno.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xeno.entity.CommunicationLog;

public interface CommunicationRepo extends JpaRepository<CommunicationLog, Long> {
    CommunicationLog findFirstByOrderBySentAtDesc();
}
