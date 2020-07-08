package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.model.Customer;
import com.crm.repository.CustomerRepository;
 
@Service
@Transactional
public class CustomerService {
 
    @Autowired
    private CustomerRepository repo;
     
    public List<Customer> listAll() {
    	return repo.findAll();
    }
     
    public void save(Customer customer) {
        repo.save(customer);
    }
     
    public Customer get(int id) {
        return repo.findById(id).get();
    }
     
    public void delete(int id) {
        repo.deleteById(id);
    }
}
