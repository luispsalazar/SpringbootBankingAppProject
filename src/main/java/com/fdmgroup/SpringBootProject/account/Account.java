package com.fdmgroup.SpringBootProject.account;

import com.fdmgroup.SpringBootProject.customer.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
//@MappedSuperclass
@Table(name = "ACCOUNT")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Account {

	@Id
	@Column(name = "ACCOUNT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_SEQ_GEN")
	@SequenceGenerator(name = "ACCOUNT_SEQ_GEN", sequenceName = "ACCOUNT_SEQ")
	private long accountId;

	@NotNull
	@Column(name = "BALANCE")
	private double balance;

	@ManyToOne
	@JoinColumn(name = "FK_CUST_ID")
	private Customer customer;

	public Account(long accountId, double balance, Customer customer) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.customer = customer;
	}
}