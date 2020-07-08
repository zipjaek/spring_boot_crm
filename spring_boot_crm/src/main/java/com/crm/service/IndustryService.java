package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.model.Industry;
import com.crm.repository.IndustryRepository;
 
@Service
@Transactional
public class IndustryService {
 
    @Autowired
    private IndustryRepository repo;
     
    public List<Industry> listAll() {
        return repo.findAll();
    }
     
    public void save(Industry industry) {
        repo.save(industry);
    }
     
    public Industry get(int id) {
        return repo.findById(id).get();
    }
     
    public void delete(int id) {
        repo.deleteById(id);
    }
}