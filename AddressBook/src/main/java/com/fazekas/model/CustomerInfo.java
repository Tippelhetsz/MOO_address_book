package com.fazekas.model;

public class CustomerInfo {
	
	private String postcode;
	
	private String address;
	
	private String phoneNumber;
	
	public CustomerInfo(){
		
	}
	
	public CustomerInfo(String postcode, String address, String phoneNumber){
		this.postcode = postcode;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
