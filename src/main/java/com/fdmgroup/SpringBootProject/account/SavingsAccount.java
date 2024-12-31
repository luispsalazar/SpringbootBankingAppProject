package com.fdmgroup.SpringBootProject.account;

import com.fdmgroup.SpringBootProject.customer.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "SAVINGS_ACCOUNT")
public class SavingsAccount extends Account {

	@NotNull
	private double interestRate;

	public SavingsAccount(long accountId, double balance, Customer customer, double interestRate) {
		super(accountId, balance, customer);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "SavingsAccount [interestRate=" + interestRate + "]";
	}
}