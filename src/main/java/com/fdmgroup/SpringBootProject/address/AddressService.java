package com.fdmgroup.SpringBootProject.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}