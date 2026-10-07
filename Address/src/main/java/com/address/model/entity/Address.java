package com.address.model.entity;

import com.address.model.enums.AddressType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long empId;
    private String state;
    private Long pinCode;
    private String city;
    private String country;
	
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

 
    
	public Address() {
		super();
	}
	
	

	public Long getId() {
		return id;
	}

	public Long getEmpId() {
		return empId;
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

	public void setEmpId(Long empId) {
		this.empId = empId;
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

	@Override
	public String toString() {
		return "Adress [id=" + id + ", empId=" + empId + ", state=" + state + ", pinCode=" + pinCode + ", city=" + city
				+ ", country=" + country + ", addressType=" + addressType + "]";
	}

	public Address(Long id, Long empId, String state, Long pinCode, String city, String country,
			AddressType addressType) {
		super();
		this.id = id;
		this.empId = empId;
		this.state = state;
		this.pinCode = pinCode;
		this.city = city;
		this.country = country;
		this.addressType = addressType;
	} 

    
}
