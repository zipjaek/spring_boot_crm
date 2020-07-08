package com.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
 
}