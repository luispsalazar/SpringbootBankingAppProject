package com.fdmgroup.SpringBootProject.account;

import com.fdmgroup.SpringBootProject.customer.Customer;

public class CheckingAccount extends Account {

	private int nextCheckNumber;

	public CheckingAccount(long accountId, double balance, Customer customer, int nextCheckNumber) {
		super(accountId, balance, customer);
		this.nextCheckNumber = nextCheckNumber;
	}

	public int getNextCheckNumber() {
		return nextCheckNumber;
	}

	public void setNextCheckNumber(int nextCheckNumber) {
		this.nextCheckNumber = nextCheckNumber;
	}

	@Override
	public String toString() {
		return "CheckingAccount [nextCheckNumber=" + nextCheckNumber + "]";
	}
}