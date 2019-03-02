package com.fazekas.controller;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fazekas.model.Customer;

public class AddressBookRestControllerTest {

	@Test
	public void givenNonExistingEndpointThen404IsRecieved() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/AddressBook/api/random");

		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		assertEquals(HttpStatus.NOT_FOUND.value(), httpResponse.getStatusLine().getStatusCode());
	}

	@Test
	public void retrievingListOfCustomersGivesJsonTypeResponse() throws ClientProtocolException, IOException {
		String jsonMimeType = "application/json";
		HttpUriRequest request = new HttpGet("http://localhost:8080/AddressBook/api/customer");

		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		String mimeType = ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();
		assertEquals(jsonMimeType, mimeType);
	}
	
	@Test
	public void retrievingListOfCustomersGivesListOf6Element() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/AddressBook/api/customer");

		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		String jsonString = EntityUtils.toString(httpResponse.getEntity());
		ObjectMapper mapper = new ObjectMapper();
		List<String> response = mapper.readValue(jsonString, new TypeReference<List<String>>(){});

		assertEquals(6, response.size());
	}

	@Test
	public void retrievingExistingCustomerThenRetrievedResponseIsCorrect() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:8080/AddressBook/api/customer/Fish");

		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		String jsonString = EntityUtils.toString(httpResponse.getEntity());
		ObjectMapper mapper = new ObjectMapper();
		List<Customer> response = mapper.readValue(jsonString, new TypeReference<List<Customer>>(){});

		assertEquals("Fish", response.get(0).getSurname());
	}

}
