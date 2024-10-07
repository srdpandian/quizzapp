package com.restproject.quizzapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restproject.quizzapp.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer> {

}
