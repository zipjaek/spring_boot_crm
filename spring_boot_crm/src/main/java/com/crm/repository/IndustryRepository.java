package com.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.model.Industry;

public interface IndustryRepository extends JpaRepository<Industry, Integer> {
 
}