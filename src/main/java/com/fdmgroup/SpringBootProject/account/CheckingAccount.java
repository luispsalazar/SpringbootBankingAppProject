package com.fdmgroup.SpringBootProject.account;

import com.fdmgroup.SpringBootProject.customer.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "CHECKING_ACCOUNT")
public class CheckingAccount extends Account {

	@Id
	private long accountId;

	@NotNull
	private int nextCheckNumber;

	public CheckingAccount(long accountId, double balance, Customer customer, @NotNull int nextCheckNumber) {
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