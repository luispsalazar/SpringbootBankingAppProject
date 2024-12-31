package com.fdmgroup.SpringBootProject.account;

import com.fdmgroup.SpringBootProject.customer.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ACCOUNT")
public abstract class Account {

	@Id
	private long accountId;
	
	@NotNull
	private double balance;
	@ManyToOne
	private Customer customer;

	public Account(long accountId, double balance, Customer customer) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.customer = customer;
	}
}