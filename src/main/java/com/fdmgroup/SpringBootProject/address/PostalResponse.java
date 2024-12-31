package com.fdmgroup.SpringBootProject.address;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostalResponse {

	@JsonProperty("standard.city")
	private String city;

	@JsonProperty("standard.prov")
	private String province;

	//private String postalCode;

//	public PostalResponse(String postalCode) {
//		super();
//		this.postalCode = postalCode;
//	}

//	public String getPostalCode() {
//		return postalCode;
//	}
//
//	public void setPostalCode(String postalCode) {
//		this.postalCode = postalCode;
//	}

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
}