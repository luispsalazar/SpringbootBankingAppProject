package com.fdmgroup.SpringBootProject.address;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@UuidGenerator

//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_SEQ_GEN")
//	@SequenceGenerator(name = "ADDRESS_SEQ_GEN", sequenceName = "ADDRESS_SEQ")
	@Column(name = "ADDRESS_ID")
	private String addressId;

	@NotNull
	@Column(name = "STREET_NUMBER")
	private String streetNumber;

	@NotNull
	@Column(name = "CITY")
	private String city;

	@NotNull
	@Column(name = "PROVINCE")
	private String province;

	@NotNull
	@Column(name = "POSTAL_CODE")
	private String postalCode;

	public Address() {
		super();
	}

	public Address(@NotNull String streetNumber, @NotNull String city, @NotNull String province,
			@NotNull String postalCode) {
		super();
		this.streetNumber = streetNumber;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
	}

	public Address(String addressId, @NotNull String streetNumber, @NotNull String city, @NotNull String province,
			@NotNull String postalCode) {
		super();
		this.addressId = addressId;
		this.streetNumber = streetNumber;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", streetNumber=" + streetNumber + ", province=" + province
				+ ", postalCode=" + postalCode + ", city=" + city + "]";
	}
}