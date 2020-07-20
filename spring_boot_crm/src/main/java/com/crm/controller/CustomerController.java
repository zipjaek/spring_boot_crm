package com.crm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crm.model.Country;
import com.crm.model.Customer;
import com.crm.model.Industry;
import com.crm.service.CountryService;
import com.crm.service.CustomerService;
import com.crm.service.IndustryService;

@Controller
public class CustomerController {
 
    @Autowired
    private CustomerService service;
    
    @Autowired
    private CountryService countryService;
    
    @Autowired
    private IndustryService industryService;
     
    @RequestMapping("/")
    public String viewHomePage(Model model,
    		@Param("keyword") String keyword) {
    	List<Customer> listCustomers = service.listAll(keyword);
        model.addAttribute("listCustomers", listCustomers);
        model.addAttribute("keyword", keyword);
         
        return "index";
    }
    
    @RequestMapping("/new")
    public String showNewCustomerPage(Model model) {
    	List<Country> listCountries = countryService.listAll();
        model.addAttribute("listCountries", listCountries);
        
        List<Industry> listIndustries = industryService.listAll();
        model.addAttribute("listIndustries", listIndustries);
    	
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
         
        return "new_customer";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createCustomer(@Valid @ModelAttribute("customer") Customer customer,
    		BindingResult result, Model model) {
    	if(result.hasErrors()) {
    		List<Country> listCountries = countryService.listAll();
            model.addAttribute("listCountries", listCountries);
            
            List<Industry> listIndustries = industryService.listAll();
            model.addAttribute("listIndustries", listIndustries);
            return "new_customer";
    	} 
    	
        service.save(customer);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer,
    		BindingResult result, Model model) {
    	if(result.hasErrors()) {
    		List<Country> listCountries = countryService.listAll();
            model.addAttribute("listCountries", listCountries);
            
            List<Industry> listIndustries = industryService.listAll();
            model.addAttribute("listIndustries", listIndustries);
            return "edit_customer";
    	} 
    	
        service.save(customer);
        return "redirect:/";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCustomerPage(@PathVariable(name = "id") int id, Model model) {
    	List<Country> listCountries = countryService.listAll();
        model.addAttribute("listCountries", listCountries);
        
        List<Industry> listIndustries = industryService.listAll();
        model.addAttribute("listIndustries", listIndustries);
    	
        ModelAndView mav = new ModelAndView("edit_customer");
        Customer customer = service.get(id);
        mav.addObject("customer", customer);
         
        return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";       
    }
}