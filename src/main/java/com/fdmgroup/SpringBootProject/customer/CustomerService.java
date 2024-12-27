package com.fdmgroup.SpringBootProject.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	private CustomerRepository customerRepo;

	@Autowired
	public CustomerService(CustomerRepository customerRepo) {
		super();
		this.customerRepo = customerRepo;
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
		Customer customer = new Customer();
		customer.setName(request.getName());
		customer.setPostalCode(request.getPostalCode());
		customer.setStreetNumber(request.getStreetNumber());
		return customerRepo.save(null);
	}

	public Customer updateCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	public Customer updateCustomer(CustomerUpdateRequest request, Long id) {
		Customer customer = customerRepo.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
		customer.setName(request.getName());
		customer.setCity(request.getCity());
		customer.setProvince(request.getProvince());
		customer.setPostalCode(request.getPostalCode());
		return customerRepo.save(customer);
	}

	public void deleteCustomer(long customerId) {
		customerRepo.deleteById(customerId);
	}
}