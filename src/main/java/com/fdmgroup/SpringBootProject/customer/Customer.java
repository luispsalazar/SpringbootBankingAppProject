package com.fdmgroup.SpringBootProject.customer;

import java.util.List;
import java.util.Objects;

import org.springframework.transaction.annotation.Transactional;

import com.fdmgroup.SpringBootProject.account.Account;
import com.fdmgroup.SpringBootProject.address.Address;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
//@MappedSuperclass
public abstract class Customer {

	@Id
	private long customerId;
	private String name;
	@OneToOne
	private Address address;
	@OneToMany
	private List<Account> accounts;

	public Customer() {
		super();
	}

	public Customer(String name, Address address, List<Account> accounts) {
		super();
		this.name = name;
		this.address = address;
		this.setAccounts(accounts);
	}

	public Customer(long customerId, String name, Address address, List<Account> accounts) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.setAccounts(accounts);
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, customerId, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && customerId == other.customerId
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + "]";
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}