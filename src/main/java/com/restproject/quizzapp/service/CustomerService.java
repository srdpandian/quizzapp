package com.restproject.quizzapp.service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restproject.quizzapp.repository.CustomerRepository;
import com.restproject.quaizzapp.request.CreateRequest;
import com.restproject.quaizzapp.request.UpdateRequest;
import com.restproject.quizzapp.entity.CustomerEntity;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customRepo;
	
	public List<CustomerEntity> listAllCustomers() {
		List<CustomerEntity> listAll = customRepo.findAll();
		return listAll;
		
	}

	public String createCustomerUser(CreateRequest create) {
		// TODO Auto-generated method stub
		CustomerEntity cus = new CustomerEntity();
		cus.setUser_name(create.user_name);
		cus.setPassword(create.password);
		customRepo.save(cus);
		return "Successfully inserted";
	}

	public Optional<CustomerEntity> getCustomerUser(int id) {
		return customRepo.findById(id);
	}

	public String updateCustomer(UpdateRequest updrequest) {

		int userid = updrequest.user_id;
		Optional<CustomerEntity> existingUser = customRepo.findById(userid);
		if(existingUser.isPresent()) {
			CustomerEntity stsEntity = existingUser.get();
			stsEntity.setUser_name(stsEntity.getUser_name());
			stsEntity.setPassword(updrequest.password);
			customRepo.save(stsEntity);
		}
		return "Successfully Updated";
	}

}
