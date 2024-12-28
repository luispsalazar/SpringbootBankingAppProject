package com.fdmgroup.SpringBootProject.address;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostalResponse {

	@JsonProperty("standard.city")
	String city;
	
	@JsonProperty("standard.prov")
	String province;

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