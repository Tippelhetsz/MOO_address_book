package com.fazekas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fazekas.model.AddressBook;
import com.fazekas.model.Customer;
import com.fazekas.model.CustomerInfo;
import com.fazekas.service.AddressBookService;

@Service
public class AddressBookServiceImpl implements AddressBookService{
	
	private static AddressBook addressBook;
	
	static {
		addressBook = populateAddressBook();
	}

	@Override
	public List<String> getListOfCustomers() {
		List<String> retCustomerList = new ArrayList<>();
		
		for(Customer customer : addressBook.getAddressBook()){
			String name = customer.getFirstName() + " " + customer.getSurname() + "(" + customer.getId() + ")";
			retCustomerList.add(name);
		}
		
		return retCustomerList;
	}

	@Override
	public List<Customer> getCustomerBySurname(String surmname) {
		List<Customer> retCustomerList = new ArrayList<>();
		List<Customer> book = addressBook.getAddressBook();
		
		for(Customer customer : book){
			if(customer.getSurname().equalsIgnoreCase(surmname)){
				retCustomerList.add(customer);
			}
		}
		
		return retCustomerList;
	}
	
	private static AddressBook populateAddressBook() {
		AddressBook returnBook = new AddressBook();
		
		CustomerInfo custInfo1 = new CustomerInfo("AB12 1AB", "A str 11", "0123456789");
		CustomerInfo custInfo2 = new CustomerInfo("CD34 3DC", "B str 22", "0987654321");
		CustomerInfo custInfo3 = new CustomerInfo("EF56 5EF", "C str 33", "0234567891");
		CustomerInfo custInfo4 = new CustomerInfo("GH78 7GH", "D str 44", "0876543219");
		CustomerInfo custInfo5 = new CustomerInfo("IJ90 9IJ", "E str 55", "0345678912");
		CustomerInfo custInfo6 = new CustomerInfo("KL11 1KL", "F str 66", "0765432198");
		
		Customer cust1 = new Customer("John", "Smith", custInfo1);
		Customer cust2 = new Customer("Sam", "Fish", custInfo2);
		Customer cust3 = new Customer("Susan", "Kovacs", custInfo3);
		Customer cust4 = new Customer("Scott", "Smith", custInfo4);
		Customer cust5 = new Customer("Mark", "Burg", custInfo5);
		Customer cust6 = new Customer("John", "Smith", custInfo6);
		
		returnBook.getAddressBook().add(cust1);
		returnBook.getAddressBook().add(cust2);
		returnBook.getAddressBook().add(cust3);
		returnBook.getAddressBook().add(cust4);
		returnBook.getAddressBook().add(cust5);
		returnBook.getAddressBook().add(cust6);
		
		return returnBook;
	}

}
