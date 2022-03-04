package com.acount.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acount.entities.Customer;
import com.acount.repository.CustomerRepo;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@GetMapping("/showCustomers")
	public ResponseEntity<?> getAllCustomers(){
		List<Customer> customer=this.customerRepo.findAll();
		if(customer.size()>0) {
			return new ResponseEntity<List<Customer>>(customer,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No Customers Available", HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
		try {
			//customer.setId(1);
//			customer.setName("First");
//			customer.setAddress("Dehri");
			Customer save=this.customerRepo.save(customer);
			return ResponseEntity.ok(save);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		

}
