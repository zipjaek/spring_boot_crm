package com.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crm.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query("SELECT c FROM Customer c WHERE "
			+ "CONCAT(c.name, c.lastname, c.phone, c.email, c.country.name, c.industry.name)"
			+ " LIKE %?1%")
	public List<Customer> findAll(String keyword);
}