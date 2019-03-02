package com.fazekas.model;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
	
	private List<Customer> addressBook;
	
	public AddressBook(){
		this.addressBook = new ArrayList<>();
	}
	
	public AddressBook(List<Customer> addressBook){
		this.addressBook = addressBook;
	}

	public List<Customer> getAddressBook() {
		return addressBook;
	}

	public void setAddressBook(List<Customer> addressBook) {
		this.addressBook = addressBook;
	}

}
