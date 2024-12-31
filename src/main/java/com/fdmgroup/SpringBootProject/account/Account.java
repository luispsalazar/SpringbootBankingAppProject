package com.fdmgroup.SpringBootProject.account;

import com.fdmgroup.SpringBootProject.customer.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public abstract class Account {

	@Id
	private long accountId;
	private double balance;
	private Customer customer;

	public Account(long accountId, double balance, Customer customer) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.customer = customer;
	}
}