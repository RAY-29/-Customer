package com.acount.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.acount.entities.Customer;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, Integer> {

}
