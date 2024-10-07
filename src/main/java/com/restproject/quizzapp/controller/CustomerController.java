package com.restproject.quizzapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restproject.quizzapp.entity.CustomerEntity;
import com.restproject.quizzapp.service.CustomerService;
import com.restproject.quaizzapp.request.CreateRequest;
import com.restproject.quaizzapp.request.UpdateRequest;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService cusService;
	
	@GetMapping("getAllCustomers")
	public List<CustomerEntity> getAllCustomers() {
		return cusService.listAllCustomers();
	}
	
	@PostMapping("createCustomer")
    public String createUser(@RequestBody CreateRequest create) {
        return cusService.createCustomerUser(create);
    }
	
	@GetMapping("getCustomerByid/{id}")
	public Optional<CustomerEntity> getCustomerByid(@PathVariable int id){
		
		return cusService.getCustomerUser(id);
	}
	@PostMapping("updateCustomer")
	public String updateCustomer(@RequestBody UpdateRequest updrequest) {
		return cusService.updateCustomer(updrequest);
	}
}
