package com.fdmgroup.SpringBootProject.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/postal")
public class AddressController {

	AddressService addressService;

	@Autowired
	public AddressController(AddressService addressService) {
		super();
		this.addressService = addressService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostalResponse> getPostalInfo(@PathVariable String id) {
		PostalResponse response = addressService.postalLookUp(id);
		return ResponseEntity.ok(response);
	}
}