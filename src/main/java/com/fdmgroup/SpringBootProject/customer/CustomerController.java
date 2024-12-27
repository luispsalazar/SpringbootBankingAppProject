package com.fdmgroup.SpringBootProject.customer;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		System.out.println("Customer controller constructed");
		this.customerService = customerService;
	}

	@GetMapping
	public ResponseEntity<List<Customer>> getCustomers() {
		System.out.println("Hello from GetCustomers");
		List<Customer> customers = customerService.getCustomers();
		return ResponseEntity.ok(customers);
	}

	@PostMapping
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
		Customer createdCustomer = customerService.createCustomer(customer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdCustomer.getCustomerId()).toUri();
		return ResponseEntity.created(location).body(createdCustomer);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody CustomerUpdateRequest request) {
		Customer updatedCustomer = customerService.updateCustomer(request, id);
		return ResponseEntity.ok(updatedCustomer);
	}

	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable long id) {
		customerService.deleteCustomer(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable long id) {
		System.out.println("from id");
		Customer customer = customerService.getCustomer(id);
		return ResponseEntity.ok(customer);
	}
}