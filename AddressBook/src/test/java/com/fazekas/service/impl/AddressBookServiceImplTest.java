package com.fazekas.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;


public class AddressBookServiceImplTest {

	@Test
	public void testGetListOfCustomers() {
		AddressBookServiceImpl service = new AddressBookServiceImpl();
		assertEquals(6, service.getListOfCustomers().size());
	}

	@Test
	public void testGetCustomerBySurname() {
		AddressBookServiceImpl service = new AddressBookServiceImpl();
		
		assertNotNull(service.getCustomerBySurname("Smith"));
		assertEquals("Smith", service.getCustomerBySurname("Smith").get(0).getSurname());
		
		assertNotNull(service.getCustomerBySurname("smith"));
		assertEquals("Smith", service.getCustomerBySurname("smith").get(0).getSurname());
		
		assertTrue(service.getCustomerBySurname("abcd").isEmpty());
	}

}
