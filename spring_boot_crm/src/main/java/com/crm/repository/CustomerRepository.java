package com.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
 
}