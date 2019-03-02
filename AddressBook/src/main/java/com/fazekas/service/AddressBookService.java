package com.fazekas.service;

import java.util.List;

import com.fazekas.model.Customer;

public interface AddressBookService {
	
	public List<String> getListOfCustomers();
	
	public List<Customer> getCustomerBySurname(String surname);

}
