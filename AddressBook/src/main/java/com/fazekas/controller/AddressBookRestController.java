package com.fazekas.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fazekas.model.Customer;
import com.fazekas.service.AddressBookService;

@RestController
@RequestMapping("/api")
public class AddressBookRestController {
	
	private static Logger LOG = Logger.getGlobal();
	
	@Autowired
	AddressBookService bookService;
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public ResponseEntity<List<String>> listAllCustomers(){
		LOG.info("Listing customers");
		List<String> customers = bookService.getListOfCustomers();
		
		if(customers.isEmpty()){
            return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
        }
		
        return new ResponseEntity<List<String>>(customers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/customer/{surname}", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getCustomer(@PathVariable("surname") String surname){
		LOG.info("Returning customer with surname: " + surname);
		List<Customer> retList = bookService.getCustomerBySurname(surname);
		
		if(retList.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
        }
		
		return new ResponseEntity<List<Customer>>(retList, HttpStatus.OK);
	}

}
