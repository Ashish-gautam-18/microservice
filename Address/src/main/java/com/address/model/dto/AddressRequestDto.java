package com.address.model.dto;

import com.address.model.enums.AddressType;

public class AddressRequestDto {
	private Long id;
    private String state;
    private Long pinCode;
    private String city;
    private String country;
    private AddressType addressType;
	public Long getId() {
		return id;
	}
	public String getState() {
		return state;
	}
	public Long getPinCode() {
		return pinCode;
	}
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}
	public AddressType getAddressType() {
		return addressType;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
    
    
}
