package com.fdmgroup.SpringBootProject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fdmgroup.SpringBootProject.address.AddressService;
import com.fdmgroup.SpringBootProject.address.PostalResponse;

@SpringBootTest
public class AddressServiceTest {

	@Autowired
	AddressService addressService;

	@Test
	public void testPostalCodeRetrieve() {

		System.out.println("Starting test");
		PostalResponse response = addressService.postalLookUp("L5B 0E2");
		Assertions.assertThat("Mississauga".equals(response.getCity()));

		Assertions.assertThat("ON".equals(response.getProvince()));
	}
}