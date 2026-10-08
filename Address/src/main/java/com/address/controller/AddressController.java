package com.address.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.address.model.dto.AddressDto;
import com.address.model.dto.AddressRequest;
import com.address.service.Impl.AddressService;

@RestController
@RequestMapping("/addresses")
public class AddressController {

	private final AddressService addressService;
	
	
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	
	}
	
	@PostMapping("/save")
	public ResponseEntity<List<AddressDto>> saveAddress(@RequestBody AddressRequest addressDto){
		List<AddressDto> response = addressService.saveAddress(addressDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<List<AddressDto>> updateAddress(@RequestBody AddressRequest addressDto){
		List<AddressDto> response = addressService.updateAddress(addressDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}

