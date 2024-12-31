package com.fdmgroup.SpringBootProject.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.SpringBootProject.address.Address;
import com.fdmgroup.SpringBootProject.address.AddressRepository;

@Service
public class CustomerService {

	private CustomerRepository customerRepo;
	private AddressRepository addressRepo;

	@Autowired
	public CustomerService(CustomerRepository customerRepo, AddressRepository addressRepo) {
		super();
		this.customerRepo = customerRepo;
		this.addressRepo = addressRepo;
	}

	public List<Customer> getCustomers() {
		return customerRepo.findAll();
	}

	public Customer getCustomer(long customerId) {
		Optional<Customer> customerOpt = customerRepo.findById(customerId);
		if (!customerOpt.isPresent()) {
			throw new CustomerNotFoundException("Customer with id: " + customerId + " was not found");
		}
		return customerOpt.get();
	}

	public Customer createCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	public Customer createCustomer(TellerCreatesCustomer request) {

		Customer customer;
		if (request.getType().equals("person")) {
			customer = new Person();
		} else {
			customer = new Company();
		}
		Address address = addressRepo.save(new Address());
		address.setPostalCode(request.getPostalCode());
		address.setStreetNumber(request.getStreetNumber());
		customer.setName(request.getName());
		customer.setAddress(address);

		return customerRepo.save(customer);
	}

	public Customer updateCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	public Customer updateCustomer(CustomerUpdateRequest request, Long id) {
		Customer customer = customerRepo.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
		customer.setName(request.getName());
		Address address = customer.getAddress();
		address.setPostalCode(request.getPostalCode());
		address.setCity(request.getCity());
		address.setProvince(request.getProvince());

		return customerRepo.save(customer);
	}

	public void deleteCustomer(long customerId) {
		customerRepo.deleteById(customerId);
	}
}