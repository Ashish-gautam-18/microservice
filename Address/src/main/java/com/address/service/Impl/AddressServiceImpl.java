package com.address.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.address.model.dto.AddressDto;
import com.address.model.dto.AddressRequest;
import com.address.model.dto.AddressRequestDto;
import com.address.model.entity.Address;
import com.address.repsitory.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService{

	Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);
	private final AddressRepository addressRepository;
	private final ModelMapper modelMapper;
	
	public AddressServiceImpl(AddressRepository addressRepository,
			                   ModelMapper modelMapper) {
		this.addressRepository = addressRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<AddressDto> saveAddress(AddressRequest addressRequest) {	
		List<Address> listToSave = new ArrayList<>();
		for(AddressRequestDto addressRequestDto : addressRequest.getAddressRequestDtoList()) {
			Address address = new Address();
			address.setState(addressRequestDto.getState());
			address.setCity(addressRequestDto.getCity());
			address.setPinCode(addressRequestDto.getPinCode());
			address.setCountry(addressRequestDto.getCountry());
			address.setAddressType(addressRequestDto.getAddressType());
			address.setEmpId(addressRequest.getEmpId());
			listToSave.add(address);		
		}
		List<Address> saveAddress=addressRepository.saveAll(listToSave);
		return saveAddress.stream().map((Address address) -> modelMapper.map(address, AddressDto.class)).toList();
	}

	
	@Override
	public List<AddressDto> updateAddress(AddressRequest addressRequest) {
		
		List <Address> addressByEmpId =addressRepository.findAllByEmpId(addressRequest.getEmpId());
		if (addressByEmpId.isEmpty()) {
			log.info("no address found for employee id ()" , addressRequest.getEmpId());
			log.info("new address create for employee id ()" , addressRequest.getEmpId());
		    
		}
		return null;
	}

	@Override
	public AddressDto getSingleAddress(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddressDto> getAllAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAddress(Long id) {
		// TODO Auto-generated method stub
		
	}
        
	   
	
}









