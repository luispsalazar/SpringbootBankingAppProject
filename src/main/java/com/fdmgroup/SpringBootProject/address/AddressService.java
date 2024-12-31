package com.fdmgroup.SpringBootProject.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressService {

	private AddressRepository addressRepo;
	private final RestTemplate restTemplate;

	public List<Address> getAddress() {
		return addressRepo.findAll();
	}

	@Autowired
	public AddressService(AddressRepository addressRepo, RestTemplate restTemplate) {
		super();
		this.addressRepo = addressRepo;
		this.restTemplate = restTemplate;
	}

	public PostalResponse postalLookUp(String postalCode) {
		String url = "https://geocoder.ca/?locate=" + postalCode + "&json=1";
		PostalResponse response = restTemplate.getForObject(url, PostalResponse.class);
		return response;
	}

//	public String postalLookUp(String postalCode) {
//		// String url = "https://geocoder.ca";
//		String url = "https://geocoder.ca/?locate=" + postalCode + "&json=1";
//
//		// Data to send
//		PostalResponse requestedData = new PostalResponse("postalCode");
//
//		// Optional: Set headers
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Content-Type", "application/json");
//
//		// Wrap request data in HttpEntity
//		HttpEntity<PostalResponse> requestEntity = new HttpEntity<>(requestedData, headers);
//
//		// Make POST request and get response
//		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
//
//		// Return response body
//		return response.getBody().toString();
//	}
}