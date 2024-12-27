package com.fdmgroup.SpringBootProject.customer;

import java.util.Objects;

import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {

	@Id
	private long customerId;
	private String name;
	private String streetNumber;
	private String city;
	private String province;
	private String postalCode;

	public Customer() {
		super();
	}

	public Customer(long customerId, String name, String streetNumber, String city, String province,
			String postalCode) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.streetNumber = streetNumber;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
	}

	public Customer(String name, String streetNumber, String city, String province, String postalCode) {
		super();
		this.name = name;
		this.streetNumber = streetNumber;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
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

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, customerId, name, postalCode, province, streetNumber);
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
		return Objects.equals(city, other.city) && customerId == other.customerId && Objects.equals(name, other.name)
				&& Objects.equals(postalCode, other.postalCode) && Objects.equals(province, other.province)
				&& Objects.equals(streetNumber, other.streetNumber);
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", streetNumber=" + streetNumber + ", city="
				+ city + ", province=" + province + ", postalCode=" + postalCode + "]";
	}
}