package com.address.model.dto;

import java.util.List;

public class AddressRequest {
	
	private Long empId;
	private List<AddressRequestDto> addressRequestDtoList;
	public Long getEmpId() {
		return empId;
	}
	public List<AddressRequestDto> getAddressRequestDtoList() {
		return addressRequestDtoList;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public void setAddressRequestDtoList(List<AddressRequestDto> addressRequestDtoList) {
		this.addressRequestDtoList = addressRequestDtoList;
	}
	

}
