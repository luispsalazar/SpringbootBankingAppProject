package com.fdmgroup.SpringBootProject.customer;

public class TellerCreatesCustomer {

	private String name;
	private String streetNumber;
	private String postalCode;
	private boolean isPerson;
		
	public boolean isPerson() {
		return isPerson;
	}
	public void setPerson(boolean isPerson) {
		this.isPerson = isPerson;
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
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}