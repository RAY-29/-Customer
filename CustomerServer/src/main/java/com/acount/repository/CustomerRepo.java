package com.acount.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.acount.entities.Customer;

public interface CustomerRepo extends MongoRepository<Customer, Integer> {

}
