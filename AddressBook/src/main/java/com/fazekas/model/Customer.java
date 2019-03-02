package com.fazekas.model;

import java.util.Random;

public class Customer {
	
	private int id;
	
	private String firstName;
	
	private String surname;
	
	private CustomerInfo details;
	
	public Customer(){
		
	}
	
	public Customer(String firstName, String surname, CustomerInfo details){
		this.id = new Random().nextInt(1000);
		this.firstName = firstName;
		this.surname = surname;
		this.details = details;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurname() {
		return surname;
	}
	
	public CustomerInfo getInfo(){
		return details;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setInfo(CustomerInfo details){
		this.details = details;
	}

}
