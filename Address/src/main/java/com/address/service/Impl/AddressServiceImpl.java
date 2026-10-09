package com.address.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.address.exception.ResourceNotFoundException;
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
		
		List <Address>listToSave  = this.saveOrUpdateAddressRequest(addressRequest);
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
		List <Address>listToUpdate   = this.saveOrUpdateAddressRequest(addressRequest);
		
		List <Long> upComingNonNullIds = listToUpdate.stream().map(Address::getId).filter(Objects::nonNull).toList();
		List<Long>existingIds = addressByEmpId.stream().map(Address::getId).toList();
		
		List<Long> idsToDelete = existingIds.stream().filter(id -> !upComingNonNullIds.contains(id)).toList();
		if(!idsToDelete.isEmpty()) {
			addressRepository.deleteAllById(idsToDelete);
		}
		List <Address> updateAddress = addressRepository.saveAll(listToUpdate);
		return updateAddress.stream().map((Address address) -> modelMapper.map(address, AddressDto.class)).toList();
	}

	
	
	
	
	
	@Override
	public AddressDto getSingleAddress(Long id) {
		
	Address address = addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address not found with id :" +id));
		return modelMapper.map(address, AddressDto.class);
	}

	@Override
	public List<AddressDto> getAllAddress() {
	List<Address> all = addressRepository.findAll();
	if(all.isEmpty()) {
		throw new ResourceNotFoundException("No Address Found");
	}
		return null;
	}

	@Override
	public void deleteAddress(Long id) {
		// TODO Auto-generated method stub
		
	}
        
	 private List<Address> saveOrUpdateAddressRequest(AddressRequest addressRequest){
		
		 List<Address> listToSave = new ArrayList<>();
			for(AddressRequestDto addressRequestDto : addressRequest.getAddressRequestDtoList()) {
				Address address = new Address();
				address.setId(addressRequestDto.getId()!=null ? addressRequestDto.getId() : null);
				address.setState(addressRequestDto.getState());
				address.setCity(addressRequestDto.getCity());
				address.setPinCode(addressRequestDto.getPinCode());
				address.setCountry(addressRequestDto.getCountry());
				address.setAddressType(addressRequestDto.getAddressType());
				address.setEmpId(addressRequest.getEmpId());
				listToSave.add(address);		
			}
		 
		 return listToSave;
		 
	 }
	
}









