package com.xeno.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xeno.entity.Corder;

public interface ORepo extends JpaRepository<Corder, Long> {

	@Override
	List<Corder> findAll();
}
