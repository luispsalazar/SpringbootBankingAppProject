package com.fdmgroup.SpringBootProject.customer;

import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.Transactional;

import com.fdmgroup.SpringBootProject.account.Account;
import com.fdmgroup.SpringBootProject.address.Address;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "CUSTOMER")
public abstract class Customer {

	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQ_GEN")
	@SequenceGenerator(name = "CUSTOMER_SEQ_GEN", sequenceName = "CUSTOMER_SEQ", allocationSize = 1001)
	private long customerId;

	@NotNull
	@Column(name = "CUSTOMER_NAME")
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_ADDRESS_ID")
	@NotNull
	private Address address;

	@OneToMany(mappedBy = "customer")
	private List<Account> accounts;

	@NotNull
	@Column(name = "CUSTOMER_TYPE")
	private String type;

	public Customer() {
		super();
	}

	public Customer(long customerId, @NotNull String name, @NotNull Address address, List<Account> accounts,
			@NotNull String type) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.accounts = accounts;
		this.type = type;
	}

	public Customer(@NotNull String name, @NotNull Address address, List<Account> accounts, @NotNull String type) {
		super();
		this.name = name;
		this.address = address;
		this.accounts = accounts;
		this.type = type;
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

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accounts, address, customerId, name, type);
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
		return Objects.equals(accounts, other.accounts) && Objects.equals(address, other.address)
				&& customerId == other.customerId && Objects.equals(name, other.name)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", accounts="
				+ accounts + ", type=" + type + "]";
	}
}