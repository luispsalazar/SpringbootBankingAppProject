package com.fdmgroup.SpringBootProject.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Person extends Customer {

	public Person() {
		super();
	}
}