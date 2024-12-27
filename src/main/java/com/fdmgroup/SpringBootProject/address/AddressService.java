package com.fdmgroup.SpringBootProject.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

@Service
public class AddressService {

	private AddressRepository addressRepo;
	private final RestTemplate restTemplate;
	private final Gson gson;

	@Autowired
	public AddressService(AddressRepository addressRepo, RestTemplate restTemplate, Gson gson) {
		super();
		this.addressRepo = addressRepo;
		this.restTemplate = restTemplate;
		this.gson = gson;
	}

	public List<Address> getAddress() {
		return addressRepo.findAll();
	}

	public PostalResponse postalLookUp(String postalCode) {
		String url = "https://geocode.ca/?locate=" + postalCode + "&json=1";
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		String gson = response.getBody();
		//postalResponse=gson.from();
		return null;
	}

}