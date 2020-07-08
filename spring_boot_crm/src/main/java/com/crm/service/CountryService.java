package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.model.Country;
import com.crm.repository.CountryRepository;
 
@Service
@Transactional
public class CountryService {
 
    @Autowired
    private CountryRepository repo;
     
    public List<Country> listAll() {
        return repo.findAll();
    }
     
    public void save(Country country) {
        repo.save(country);
    }
     
    public Country get(int id) {
        return repo.findById(id).get();
    }
     
    public void delete(int id) {
        repo.deleteById(id);
    }
}
